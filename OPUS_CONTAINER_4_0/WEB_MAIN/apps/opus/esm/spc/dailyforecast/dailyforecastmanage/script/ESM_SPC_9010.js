/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_9010.js
*@FileTitle  : Account Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
// global variable
var sheetObjects = new Array();
var comObjects = new Array();
var comboCnt = 0;
var sheetCnt = 0;
var opener_obj = window.dialogArguments;
var insCnt = 0;
var init_year = '';
var init_week = '';
var init_duration = '';

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/**
 * Event handler processing by button name
 * @return
 */
function processButtonClick() {	
    var sheetObject = sheetObjects[0];
    var formObj = document.form;
    try {
        var srcName = ComGetEvent("name");        
        if(ComGetBtnDisable(srcName)) return false;
        
        switch (srcName) {
            case "btn_retrieve":                                
                doActionIBSheet(sheetObject, formObj, IBSEARCH);
                break;
                
           case "btn_template":   
                doActionIBSheet(sheetObject, formObj, SEARCHLIST01);
                break;
                
            case "btn_loadexcel":
                sheetObject.RemoveAll();
                doActionIBSheet(sheetObject, formObj, IBLOADEXCEL);
                break;
                
            case "btn_save":                               
                ComOpenWait(true);
                setTimeout(function() {
                    doActionIBSheet(sheetObject, formObj, IBSAVE);
                    ComOpenWait(false);
                }, 100);                
                break;
                
            case "btn_close":
                sheetObjects[0].SetEditable(0);
                sheetObjects[1].SetEditable(0);
                sheetObjects[2].SetEditable(0);
                ComClosePopup();
                //window.dialogArguments.goRetrieve();
                break;
                
            case "btn_downexcel":
                //                    location.href="apps/opus/esm/spc/dailyforecast/dailyforecastmanage/jsp/ESM_SPC_9010DL.jsp";
                //                	sheetObjects[2].RemoveAll();
                //                	sheetObjects[2].DataInsert(-1);
                //                	sheetObjects[2].cellValue(1, "CUST_CNT")="XX";
                //                	sheetObjects[2].cellValue(1, "CUST_SEQ")="999999";
                //                	sheetObjects[2].SpeedDown2Excel(-1);
                doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
                break;
                
            case "btn_rowadd":
                var row = sheetObject.DataInsert(-1);
                break;
                
            case "btn_rowdel":
                var rowCnt = sheetObject.RowCount();
                for (var i = rowCnt; i > 0; i--) {
                    if (sheetObject.GetCellValue(i, "chk") == 1)
                        sheetObject.RowDelete(i, false);
                }
                // header 체크의 초기화
                sheetObject.ClearHeaderCheck();
                break;
                
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage("The service is not available now."); //ComShowMessage("The service is not available now.");
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * set Sheet Cells Editable
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {int}		rownum		Row Index
 * @param {int}		colnms		editable
 * @return
 */
function setShtCellsEditable(sheetObj, rownum, colnms) {
    if (rownum == null || rownum == undefined || colnms == null || colnms == undefined) {
        return false;
    }
    var arr_colnms = colnms.split('|'); //Trade|Sub Trade|Lane|VVD|OCN/IPC/TS|Sales Rep|Cust Type|CUST_CNT|CUST_SEQ|Pol|Pod|Office
    for (var i = 0; arr_colnms != null && i < arr_colnms.length; i++) {
        sheetObj.SetCellEditable(rownum, arr_colnms[i], 1);
    }
}

/**
 * set sheet status
 * @param {ibsheet}	sheetObj	IBSheet Object
 * @param {int}		sts_colnm	Column Index
 * @param {int}		to_sts		Column Index
 * @return
 */
function setShtStatus(sheetObj, sts_colnm, to_sts) {
    if (sheetObj.RowCount() > 0) {
        if (sts_colnm != null && sts_colnm != undefined && sts_colnm.trim() != '' &&
            to_sts != null && to_sts != undefined && to_sts.trim() != '') {
            //no support[check again]CLT 				
            for (i = 1; i < sheetObj.Rows; i++) {
                sheetObj.SetCellValue(i, sts_colnm, to_sts, 0);
            }
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet} sheet_obj 	IBSheet Object
 * @return
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * registering IBSheet Object as list
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
 * @return
 */
function loadPage() {
    var formObject = document.form;
    optionSetting();
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    //initializing the combobox
    for (var k = 0; k < comObjects.length; k++) {
        initCombo(comObjects[k], k + 1);
    }
    
    //focusing
    formObject.year.focus();
    init_year = formObject.year.value; 
    init_week = formObject.week.value; 
    init_duration = formObject.duration.value; 
    
    //		if (document.form.fm_prd_dt.value != window.dialogArguments.document.main_hidden.CellValue(1,'fm_prd_dt') || 
    //			document.form.to_prd_dt.value != window.dialogArguments.document.main_hidden.CellValue(1,'to_prd_dt'))
    //		{
    //			ComShowMessage(ComGetMsg('TES23038'));
    //			window.close();
    //		}
    //
    //		document.form.manual_input_yn[1].checked = true;
    // eBilling - E
}

/**
 * setting Combo initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting Combos
 */
function initCombo(comboObj, comboNo) {
    var formObject = document.form;
    switch (comboObj.options.id) {
        case "trade":
            with(comboObj) {
                SetDropHeight(250);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetUseAutoComplete(1);
                ValidChar(2);
                SetMaxLength(3);
            }
            break;
            
        case "subtrade":
            with(comboObj) {
                SetDropHeight(250);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetUseAutoComplete(1);
                ValidChar(2);
                SetMaxLength(2);
            }
            break;
            
        case "lane":
            with(comboObj) {
                SetDropHeight(340);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetUseAutoComplete(1);
                ValidChar(2, 1);
                SetMaxLength(5);
            }
            break;
    }
}

/**
 * Exist check Coincidence, Discrepancy, CalcTMNL, CalcByDay sheet data
 * @return
 */
function hasOprShtData() {
    var opener_sheet_obj;
    for (var i = 1; i <= 4; i++) {
        opener_sheet_obj = opener_obj.eval('document.t' + i + 'sheet1');
        if (opener_sheet_obj != null && opener_sheet_obj.RowCount() > 0) {
            return true;
        }
    }
    return false;
}

/**
 * setting sheet initial values and header
 * @param {ibsheet}sheetObj 	IBSheet Object
 * @param {int} 	sheetNo
 * 	adding case as numbers of counting sheets
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
						
				//no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//20160203.ADD, 20160325.MOD
			    var HeadTitle="||Year|Week|Trade|Sub Trade|Lane|Dir Cd|Vsl Cd|Skd Voy No|Skd Dir Cd|VVD|OCN/IPC/TS|Sales Rep|Cust Type|CUST_CNT|CUST_SEQ|CTRT_NO|CTRT_CUST_CNT|CTRT_CUST_SEQ|CTRT_CUST_NM|POL Yard|POD Yard|Office|F'cast TEU|HC(40')|45'|RF|F'cast WT||||Remark";
				var headCount=ComCountHeadTitle(HeadTitle);
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",	Hidden:1, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				            
							{Type:"CheckBox",	Hidden:0, 	Width:50,   	Align:"Center",  ColMerge:0,   SaveName:"chk",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:0, 	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:0, 	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"cost_wk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							//20160315.MOD : Keyfield trade/subtrade 추가
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"trd_cd",             	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1, EditLen:3 },
							{Type:"Text",      	Hidden:0,  	Width:75,   	Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1, EditLen:2 },
							{Type:"Text",      	Hidden:0,  	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",           	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1, EditLen:5},
							{Type:"Text",      	Hidden:1, 	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"dir_cd",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:1, 	Width:60,   	Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:1, 	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:1, 	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:0, 	Width:90,   	Align:"Center",  ColMerge:1,   SaveName:"vvd",                	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1, EditLen:9 },
							{Type:"Combo",    	Hidden:0,  	Width:100, 		Align:"Center",  ColMerge:1,   SaveName:"ioc_ts_cd",          	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"srep_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1, EditLen:5 },
							{Type:"Combo",    	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"fcast_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1, EditLen:2 },
							{Type:"Text",     	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"cust_seq",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N", EditLen:6 },
							//20160203.ADD Start, 20160325.MOD
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"ctrt_no",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1, EditLen:11 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1, EditLen:2 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_seq",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N", EditLen:6 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_nm",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							//20160203.ADD End
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",         	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1, EditLen:7 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"pod_yd_cd",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1, EditLen:7 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"fcast_ofc_cd",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1, EditLen:6 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"fcast_ttl_qty",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N", EditLen:10 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"fcast_40ft_hc_qty",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N", EditLen:10 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"fcast_45ft_hc_qty",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N", EditLen:10 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"fcast_rf_qty",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N", EditLen:10 },
							{Type:"Text",      	Hidden:0,  	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"fcast_ttl_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N", EditLen:10 },
							{Type:"Text",      	Hidden:1, 	Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"valid_chk",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:1, 	Width:10,   	Align:"Center",  ColMerge:1,   SaveName:"dup_chk_conf",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:1, 	Width:10,   	Align:"Center",  ColMerge:1,   SaveName:"date_chk",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:0, 	Width:300, 	Align:"Center",  ColMerge:1,   SaveName:"remark",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						
				InitColumns(cols);
				SetColProperty("ioc_ts_cd", {ComboText:"OCN|IPC|TS", ComboCode:"O|I|T"} );
//				SetColProperty("fcast_cust_tp_cd", {ComboText:"Contractor|Shipper", ComboCode:"C|S"} );
				SetColProperty("fcast_cust_tp_cd", {ComboText:"BCO|Non-BCO", ComboCode:"B|N"} );				//20160211.MOD
//				SetToolTipText(0,"ioc_ts_cd","OCN=>O, IPC=>I, TS=>T");
//				SetToolTipText(0,"fcast_cust_tp_cd","Contractor=>C, Shipper=>S");
				
				SetEditable(1);
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				//SetSheetHeight(240);
				
				resizeSheet();
			}
			break;
		
		case 2:      //sheet2 init
			with(sheetObj){
			
				//no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//20160203.ADD
				var HeadTitle="||Year|Week|Trade|Sub Trade|Lane|Dir Cd|Vsl Cd|Skd Voy No|Skd Dir Cd|VVD|OCN/IPC/TS|Sales Rep|Cust Type|CUST_CNT|CUST_SEQ|CTRT_CUST_CNT|CTRT_CUST_SEQ|CTRT_CUST_NM|POL Yard|POD Yard|Office|F'cast TEU|HC(40')|45'|RF|F'cast WT|";
				var headCount=ComCountHeadTitle(HeadTitle);
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				{Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      	Hidden:0, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      	Hidden:0, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },			
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ioc_ts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"srep_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				//20160203.ADD Start
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_cnt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1, EditLen:2 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N", EditLen:6 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				//20160203.ADD End
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_ttl_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_40ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_45ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_rf_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_ttl_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
				{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"remark",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }				
				 ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				//SetSheetHeight(240);
				resizeSheet();
			}
			break;
		
		case 3:      //sheet1 init
			//with(sheetObj){
//				SetColProperty("OCN/IPC/TS", {ComboText:"O|I|T", ComboCode:"O|I|T"} );
//				SetColProperty("CustType", {ComboText:"C|S", ComboCode:"C|S"} );
//				
//				//no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//				var HeadTitle="||Year|Week|Trade|Sub Trade|  Lane  |Dir Cd|Vsl Cd|Skd Voy No|Skd Dir Cd|       VVD      |OCN/IPC/TS|Sales Rep|Cust Type|CUST_CNT|CUST_SEQ|Pol Yard|Pod Yard| Office |F'cast TEU|HC(40')|45'|RF'|F'cast WT|||Remark";
//				var headCount=ComCountHeadTitle(HeadTitle);
//				
//				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
//				
//				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
//				var headers = [ { Text:HeadTitle, Align:"Center"} ];
//				InitHeaders(headers, info);
//				
//				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
//				{Type:"Text",      	Hidden:0, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//				{Type:"Text",      	Hidden:0, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },			
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"Trade",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"SubTrade",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"Lane",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"VVD",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"OCN/IPC/TS",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"SalesRep",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CustType",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CUST_CNT",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CUST_SEQ",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"Pol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"Pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"Office",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"F'castTEU",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"40'",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"45'",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"RF'",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"F'castWT",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"valid_chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"dup_chk_conf",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      	Hidden:1, 	Width:10,   Align:"Center",  ColMerge:1,   SaveName:"date_chk",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//				{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
//				
//				InitColumns(cols);
//				
//				SetEditable(1);
//				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
//				//no support[check again]CLT 					ToolTipOption="balloon:false;width:250;backcolor:#ffeeff;forecolor:#333333;icon:1;title:Remark";
//				SetToolTipText(0,"OCN/IPC/TS","OCN=>0, IPC=>I, TS=>T");
//				SetToolTipText(0,"Cust Type","Contractor=>C, Shipper=>S");
//				//SetSheetHeight(240);
//				resizeSheet();
//			}
			break;                 
	}	       
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

/**
 * handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}		sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    
    switch (sAction) {        
        case IBSEARCH: //Retrieve                 
            if (!validateForm(sheetObj, formObj, sAction)) {                
                return false;
            }
            
            var param = "year=" + formObj.year.value;
            param = param + "&week=" + formObj.week.value;
            param = param + "&duration=" + formObj.duration.value;
            param = param + "&trade=" + comObjects[0].GetSelectCode();
            param = param + "&subtrade=" + comObjects[1].GetSelectCode();
            param = param + "&lane=" + comObjects[2].GetSelectCode();
            param = param + "&vvd=" + formObj.vvd.value;
            param = param + "&bound=" + formObj.bound.value;
            
            sheetObj.RemoveAll();
            
            //parameter changed[check again]CLT 				
//            var rtn = sheetObjects[1].GetSearchData("ESM_SPC_9010GS.do", "f_cmd=" + (SEARCH) + "&" + param);
//            sheetObjects[1].LoadSearchData(rtn, {Sync: 1});
            
            var rtn = sheetObj.GetSearchData("ESM_SPC_9010GS.do", "f_cmd=" + (SEARCH) + "&" + param);
            sheetObj.LoadSearchData(rtn, {Sync: 1});
            
//            if (sheetObjects[1].RowCount() > 0) {
//                sheetObjects[1].Copy2SheetCol(sheetObj, "", "", -1, -1, 2, 1, false, false);
//            } else {
//                sheetObj.LoadSearchData(rtn, {Sync: 1});
//            }
            
            check_retrive = true;
            break;        
    
        case SEARCHLIST01: //Template Down           
            if (!validateForm(sheetObj, formObj, sAction)) {                
                return false;
            }
            
            var chkRep = "";
            var chkCust = "";
            
            if (formObj.salesrep.checked) {
            	chkRep = "Y";
            } 
            
			if (formObj.fcast.checked) {
            	chkCust = "Y";
            }
                        
            var param = "year=" + formObj.year.value;
            param = param + "&week=" + formObj.week.value;
            param = param + "&duration=" + formObj.duration.value;
            param = param + "&trade=" + comObjects[0].GetSelectCode();
            param = param + "&subtrade=" + comObjects[1].GetSelectCode();
            param = param + "&lane=" + comObjects[2].GetSelectCode();
            param = param + "&vvd=" + formObj.vvd.value;
            param = param + "&bound=" + formObj.bound.value;
            
            param = param + "&operator=" + chkRep;
            param = param + "&fcast=" + chkCust;
            param = param + "&office=" + formObj.usr_ofc_cd.value;            
        
            
            //parameter changed[check again]CLT 				
            var rtn = sheetObjects[1].GetSearchData("ESM_SPC_9010GS.do", "f_cmd=" + (SEARCHLIST01) + "&" + param);
            sheetObjects[1].LoadSearchData(rtn, {Sync: 1});
            
//            var rtn = sheetObj.GetSearchData("ESM_SPC_9010GS.do", "f_cmd=" + (SEARCHLIST01) + "&" + param);
//            sheetObj.LoadSearchData(rtn, {Sync: 1});
            
            if (sheetObjects[1].RowCount() > 0) {                 
                sheetObjects[1].Down2Excel({FileName : "Forecast_Input_Template", DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign: 1, Merge: 1});		//20160203.MOD : 버그수정
            } else {
                ComShowCodeMessage("COM130401"); 
            }
            
            break;
            
        case IBSAVE:            
            formObj.f_cmd.value = ADD;
            //no support[check again]CLT sheetObj.SpaceDupCheck=false;   
            if (!val_chk(sheetObj)) {
                ComShowMessage(getMsg("SPC90199", "Yellow Column"));
                return;
            }
            
            if (!chkDupRow(sheetObj)) {
                ComShowMessage(getMsg("SPC90199", "Yellow Column"));
                return;
            }
            
            if (document.form.excel_chk.value == "N") {
                return false;
            }
            
            for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
                sheetObj.SetCellValue(i, "dir_cd", sheetObj.GetCellValue(i, "skd_dir_cd"));
                sheetObj.SetCellValue(i, "vsl_cd", sheetObj.GetCellValue(i, "vvd").substring(0, 4));
                sheetObj.SetCellValue(i, "skd_voy_no", sheetObj.GetCellValue(i, "vvd").substring(4, 8));
                sheetObj.SetCellValue(i, "skd_dir_cd", sheetObj.GetCellValue(i, "vvd").substring(8, 9));
            }

            //sheetObj.Copy2SheetCol(sheetObjects[1], "", "", -1, -1, 2, 1, false, false);

            //if (sheetObjects[1].RowCount() == 0) {
            if (sheetObj.RowCount() == 0) {
                ComShowMessage("Please check row.");
                return false;
            }
            
            if (ComShowConfirm(getMsg("SPC90010")) != 1) {
                return;
            } else {
                //var param = sheetObjects[1].GetSaveString(true, false);
                var param = sheetObj.GetSaveString(true, false);
                
                //parameter changed[check again]CLT 	                   
                //var saveXml = sheetObjects[1].GetSaveData("ESM_SPC_9010GS.do", param + '&' + FormQueryString(formObj), false);
                var saveXml = sheetObj.GetSaveData("ESM_SPC_9010GS.do", param + '&' + FormQueryString(formObj), false);
                
                    //sheetObj.RemoveAll();
                    sheetObj.LoadSaveData(saveXml);
//                    sheetObjects[1].LoadSaveData(saveXml);
//                    sheetObjects[1].Copy2SheetCol(sheetObj, "", "", -1, -1, 2, 1, false, false);
                    
                    for (var i = 1; i < sheetObj.RowCount()+1; i++) {                    	
                    	if (sheetObj.GetCellValue(i, "date_chk") == "YW") { //Server 에서 체크 된 건에 대해 오류 표시 (색상변경)	                        
	                        sheetObj.SetCellFontColor(i, "sls_yrmon", "#FF0000");	            			
				            sheetObj.SetCellFontColor(i, "cost_wk", "#FF0000");
				            
				        } else if (sheetObj.GetCellValue(i, "date_chk") == "Y") { 	                        
	                        sheetObj.SetCellFontColor(i, "sls_yrmon", "#FF0000");	            			
				            
				        } else if (sheetObj.GetCellValue(i, "date_chk") == "W") { 	  
				            sheetObj.SetCellFontColor(i, "cost_wk", "#FF0000");
				        }
				        		        
	                    if (sheetObj.GetCellValue(i, "remark").length != 0) { //Server 에서 체크 된 건에 대해 오류 표시 (색상변경)	                        
	                        sheetObj.SetCellBackColor(i, "trd_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "trd_cd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "sub_trd_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "sub_trd_cd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "rlane_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "rlane_cd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "vvd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "vvd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "ioc_ts_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "ioc_ts_cd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "srep_usr_id", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "srep_usr_id", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "fcast_cust_tp_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "fcast_cust_tp_cd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "cust_cnt_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "cust_cnt_cd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "cust_seq", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "cust_seq", "#FF0000");
				            
				            //20160203.ADD, 20160325.MOD
				            sheetObj.SetCellBackColor(i, "ctrt_no", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "ctrt_no", "#FF0000");
				            sheetObj.SetCellBackColor(i, "ctrt_cust_cnt_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "ctrt_cust_cnt_cd", "#FF0000");
				            sheetObj.SetCellBackColor(i, "ctrt_cust_seq", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "ctrt_cust_seq", "#FF0000");
				            sheetObj.SetCellBackColor(i, "ctrt_cust_nm", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "ctrt_cust_nm", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "pol_yd_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "pol_yd_cd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "pod_yd_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "pod_yd_cd", "#FF0000");
				            
				            sheetObj.SetCellBackColor(i, "fcast_ofc_cd", "#FFFF66");				            			
				            sheetObj.SetCellFontColor(i, "fcast_ofc_cd", "#FF0000");
	                    }
	                }
                }
         
            break;
            
        case IBLOADEXCEL:
            //parameter changed[check again]CLT      
        	sheetObj.SetDataAutoTrim(1);
            sheetObj.LoadExcel({Mode: "HeaderMatch"});
            break;
            
        case IBDOWNEXCEL: //Excel download    		    			
//            if (sheetObj.RowCount() > 0) {
                //mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge], [SaveAsName],[ReportPageUrl], [HideExcelMsg],[WriteTreeLevel], [WorkSheetName], [FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect],[bFormula], [IncludeImageType]) 
                //parameter changed[check again]CLT     				
                sheetObj.Down2Excel({FileName : "Forecast_Input", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1});
//            }  else {
//                sheetObjects[2].RemoveAll();
//                sheetObjects[2].DataInsert(-1);                
//                sheetObjects[2].SetCellValue(1, "cust_cnt_cd", "XX");
//                sheetObjects[2].SetCellValue(1, "cust_seq", "999999");                            	
//                sheetObjects[2].Down2Excel({FileName : "Forecast_Input", DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign: 1, Merge: 1});
//            }
            break;
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {    
    switch (sAction) {
        case IBSEARCH: //Retrieve       
        case SEARCHLIST01: //Template Down             
            var sel_vvd = formObj.vvd.value;
            var sel_trade = comObjects[0].GetSelectCode();                        
            if (sel_vvd == "" && sel_trade == "") {                
                ComShowMessage(getMsg("SPC90114", "Trade"));  
                comObjects[0].Focus();
                return false;
            }       
            
            var sel_bound = formObj.bound.value;
            if (sel_vvd == "" && sel_bound == "") {
                ComShowMessage(getMsg("SPC90114", "Bound"));
                formObj.bound.focus();
                return false;
            }
                        
            if (sel_vvd != "" && sel_vvd.length < 9) {                
                ComShowCodeMessage("COM12174", "VVD", "9");
                formObj.vvd.focus();
                return false;
            }            
            break;
    }
    return true;
}

/**
 * CellEditable
 * @param {ibsheet}	sheet		IBSheet Object
 * @param {string}	ErrMsg		error message
 * @return
 */
function GetCellEditable(sheetObj, argFlg) {    
    if (sheetObj.RowCount() > 0) {
        var colnms = "trd_cd|sub_trd_cd|rlane_cd|vvd|ioc_ts_cd|srep_usr_id|fcast_cust_tp_cd|cust_cnt_cd|cust_seq|pol_yd_cd|pod_yd_cd|fcast_ofc_cd";
        var arr_colnms = colnms.split("|");
        for (var i = 1; i <= sheetObj.RowCount(); i++) {
            for (var j = 0; arr_colnms != null && j < arr_colnms.length; j++) {
                sheetObj.SetCellEditable(i, arr_colnms[j], argFlg);
            }
        }
    }
}

/**
 * loae excel event
 * @param {ibsheet}	sheet		IBSheet Object
 * @return
 */
function sheet_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return; //2014-04-22 공통 요청사항(10,000 Row 제어)
    val_chk(sheet);
    chkDupRow(sheet);
    //		rmvInvRow(sheet);
}

/*
 * Calling after saving
 */
function sheet_OnSaveEnd(sheetObj, errMsg) {   
    if(sheetObj.GetEtcData("status") == "OK"){
		ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.		
		var sheetObject = sheetObjects[0];
	    var formObj = document.form;
		//doActionIBSheet(sheetObject, formObj, IBSEARCH);
	}    
    //window.close();					
    //window.dialogArguments.goRetrieve();    	
}

/**
 * Sheet change event
 * @param {ibsheet}	sheet		IBSheet Object
 * @param {int}		row			Row Index
 * @param {int}		col			Column Index
 * @param {int}		val
 * @return
 */
//	function sheet_OnChange(sheet, row, col, val){
//		var sName = null;
//		if (sheet.RowCount > 0){
//			sName = sheet.ColSaveName(col);
//			if (sName!=undefined && sName!=null && (sName=='cntr_sty_cd' || sName=='cntr_tpsz_cd')) {
//				sheet.CellValue2(row,col) = sheet.CellValue(row,col).toUpperCase();
//			}
//		}
//	}

/**
 * duplication check
 * @param {ibsheet}	sheet	IBSheet Object
 * @return
 */
function chkDupRow(sheet) {
	//20160203.ADD : ctrt_정보 체크
    var dupRow = sheet.ColValueDup("trd_cd|sub_trd_cd|rlane_cd|vvd|ioc_ts_cd|srep_usr_id|fcast_cust_tp_cd|cust_cnt_cd|cust_seq|pol_yd_cd|pod_yd_cd|fcast_ofc_cd|ctrt_no|ctrt_cust_cnt_cd|ctrt_cust_seq");
    var chkFlg = true;
    if (dupRow > 0) {
        var idx = 0;        		
        var Rows;
        //20160203.ADD : ctrt_정보 체크
        Rows = sheet.ColValueDupRows("trd_cd|sub_trd_cd|rlane_cd|vvd|ioc_ts_cd|srep_usr_id|fcast_cust_tp_cd|cust_cnt_cd|cust_seq|pol_yd_cd|pod_yd_cd|fcast_ofc_cd|ctrt_no|ctrt_cust_cnt_cd|ctrt_cust_seq");
        var arr_rows = null;
        	
        if (Rows != null && Rows.trim() != "") {
            arr_rows = Rows.split(",");
        }
        
        for (var i = 0; arr_rows != null && i < arr_rows.length; i++) {
            sheet.SetRowFontColor(arr_rows[i], "#FF0000");
            sheet.SetCellValue(arr_rows[i], "dup_chk_conf", ++idx, 0);
            sheet.SetCellValue(arr_rows[i], "remark", 'Duplicate');
            document.form.excel_chk.value = "N";

            sheet.SetCellBackColor(arr_rows[i], "trd_cd", "#FFFF66");            		
            sheet.SetCellFontColor(arr_rows[i], "trd_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "sub_trd_cd", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "sub_trd_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "rlane_cd", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "rlane_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "vvd", "#FFFF66");            	
            sheet.SetCellFontColor(arr_rows[i], "vvd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "ioc_ts_cd", "#FFFF66");            	
            sheet.SetCellFontColor(arr_rows[i], "ioc_ts_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "srep_usr_id", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "srep_usr_id", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "fcast_cust_tp_cd", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "fcast_cust_tp_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "cust_cnt_cd", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "cust_cnt_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "cust_seq", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "cust_seq", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "pol_yd_cd", "#FFFF66");            	
            sheet.SetCellFontColor(arr_rows[i], "pol_yd_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "pod_yd_cd", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "pod_yd_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "fcast_ofc_cd", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "fcast_ofc_cd", "#FF0000");
            document.form.excel_chk.value = "N"; 
            
            //20160203.ADD
            sheet.SetCellBackColor(arr_rows[i], "ctrt_no", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "ctrt_no", "#FF0000");
            document.form.excel_chk.value = "N";    
            
            sheet.SetCellBackColor(arr_rows[i], "ctrt_cust_cnt_cd", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "ctrt_cust_cnt_cd", "#FF0000");
            document.form.excel_chk.value = "N";            

            sheet.SetCellBackColor(arr_rows[i], "ctrt_cust_seq", "#FFFF66");
            sheet.SetCellFontColor(arr_rows[i], "ctrt_cust_seq", "#FF0000");
            document.form.excel_chk.value = "N";              

            chkFlg = false;
        }
    }
    return chkFlg;
}

/**
 * validation check excel data
 * @param {ibsheet}	sheet	IBSheet Object
 * @return
 */
function rmvInvRow(sheet) {
    var inval_row = false;
    if (sheet.RowCount() > 0) {
        var delRows = '';
        var cnt = 0;
        for (var i = 1; i <= sheet.RowCount(); i++) {
            if ((sheet.GetCellValue(i, 'valid_chk') != undefined && sheet.GetCellValue(i, 'valid_chk').trim() == 'X') ||
                (sheet.GetCellValue(i, 'dup_chk_conf') != undefined && sheet.GetCellValue(i, 'dup_chk_conf') != null &&
                    sheet.GetCellValue(i, 'dup_chk_conf').trim() != '')) {
                delRows = delRows + (cnt > 0 ? "|" : "") + (new String(i));
                inval_row = true;
                cnt++;
            }
        }
        if (inval_row) {
            ComShowMessage("Please modify them on file and reload it.");
        } else {
            return true;
        }
    }
}

/**
 * row delete
 * @param {ibsheet}sheet	IBSheet Object
 * @param {int}	delRows	row index
 * @return
 */
function delInvalRow(sheet, delRows) {
    if (sheet.RowCount() > 0) {
        var arr = delRows.split('|');
        for (var i = (arr.length - 1); arr != null && i >= 0; i--) {
            sheet.RowDelete(arr[i], false);
        }
        return true;
    }
}

/**
 * @param {ibsheet}sheet	IBSheet Object
 * @return
 */
function delBlkRows(sheet) {
    if (sheet.RowCount() > 0) {
        for (var i = sheet.RowCount(); sheet != null && i >= 0; i--) {
            if ((sheet.GetCellValue(i, 'rlane_cd') == null || sheet.GetCellValue(i, 'rlane_cd') == '') &&
                (sheet.GetCellValue(i, 'vsl_cd') == null || sheet.GetCellValue(i, 'vsl_cd') == '') &&
                (sheet.GetCellValue(i, 'skd_voy_no') == null || sheet.GetCellValue(i, 'skd_voy_no') == '') &&
                (sheet.GetCellValue(i, 'skd_dir_cd') == null || sheet.GetCellValue(i, 'skd_dir_cd') == '') &&
                (sheet.GetCellValue(i, 'ioc_ts_cd') == null || sheet.GetCellValue(i, 'ioc_ts_cd') == '') &&
                (sheet.GetCellValue(i, 'srep_usr_id') == null || sheet.GetCellValue(i, 'srep_usr_id') == '') &&
                (sheet.GetCellValue(i, 'cust_cnt_cd') == null || sheet.GetCellValue(i, 'cust_cnt_cd') == '') &&
                (sheet.GetCellValue(i, 'cust_seq') == null || sheet.GetCellValue(i, 'cust_seq') == '') &&
                (sheet.GetCellValue(i, 'pol_yd_cd') == null || sheet.GetCellValue(i, 'pol_yd_cd') == '') &&
                (sheet.GetCellValue(i, 'pod_yd_cd') == null || sheet.GetCellValue(i, 'pod_yd_cd') == '') &&
                (sheet.GetCellValue(i, 'fcast_ofc_cd') == null || sheet.GetCellValue(i, 'fcast_ofc_cd') == '') &&
                (sheet.GetCellValue(i, 'fcast_cust_tp_cd') == null || sheet.GetCellValue(i, 'fcast_cust_tp_cd') == '')
            ) {
                sheet.RowDelete(i, false);
            }
        }
    }
}

/**
 * validation check sheet
 * @param {ibsheet}sheet	IBSheet Object
 * @return
 */
function val_chk(sheetObj) {
    document.form.excel_chk.value = "Y";
    var chkFlg = true;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
		var strMnMsg = "";
        var strMsg = "";
        var chkIOC = true;
        
        //IPC/TS 일때 Lane, Pod 컬럼은 Mandatory 
        if (sheetObj.GetCellValue(i, "ioc_ts_cd") == "I" || sheetObj.GetCellValue(i, "ioc_ts_cd") == "T") {
            if (sheetObj.GetCellValue(i, "rlane_cd").length == 0) {                
                sheetObj.SetCellBackColor(i, "rlane_cd", "#FFFF66");             			
            	sheetObj.SetCellFontColor(i, "rlane_cd", "#FF0000");            
                strMnMsg += "[Lane] ";
                chkIOC = false;
                chkFlg = false;
            } else {                
                sheetObj.SetCellBackColor(i, "rlane_cd", "#FFFFFF");            			
            	sheetObj.SetCellFontColor(i, "rlane_cd", "#000000");
            }

            if (sheetObj.GetCellValue(i, "pod_yd_cd").length == 0) {                
                sheetObj.SetCellBackColor(i, "pod_yd_cd", "#FFFF66");             			
            	sheetObj.SetCellFontColor(i, "pod_yd_cd", "#FF0000");              	
                strMnMsg += "[Pod] ";
                chkIOC = false;
                chkFlg = false;
            } else {
                sheetObj.SetCellBackColor(i, "pod_yd_cd", "#FFFFFF");            			
            	sheetObj.SetCellFontColor(i, "pod_yd_cd", "#000000");
            }
        }
        
        //20160315.ADD
        if (sheetObj.GetCellValue(i, "trd_cd").length != 0) {
            sheetObj.SetCellValue(i, "trd_cd", sheetObj.GetCellValue(i, "trd_cd").toUpperCase(), 0);
            sheetObj.SetCellBackColor(i, "trd_cd", "#FFFFFF");            			
        	sheetObj.SetCellFontColor(i, "trd_cd", "#000000");            
        } else {
            sheetObj.SetCellBackColor(i, "trd_cd", "#FFFF66");             			
        	sheetObj.SetCellFontColor(i, "trd_cd", "#FF0000");              	
            strMnMsg += "[Trade] ";
            chkFlg = false;        	
        }
        
        //20160315.ADD
        if (sheetObj.GetCellValue(i, "sub_trd_cd").length != 0) {
            sheetObj.SetCellValue(i, "sub_trd_cd", sheetObj.GetCellValue(i, "sub_trd_cd").toUpperCase(), 0);
            sheetObj.SetCellBackColor(i, "sub_trd_cd", "#FFFFFF");            			
        	sheetObj.SetCellFontColor(i, "sub_trd_cd", "#000000");            
        } else {
            sheetObj.SetCellBackColor(i, "sub_trd_cd", "#FFFF66");             			
        	sheetObj.SetCellFontColor(i, "sub_trd_cd", "#FF0000");              	
            strMnMsg += "[Sub Trade] ";
            chkFlg = false;        	
        }
        
        if (sheetObj.GetCellValue(i, "rlane_cd").length != 0) {
            sheetObj.SetCellValue(i, "rlane_cd", sheetObj.GetCellValue(i, "rlane_cd").toUpperCase(), 0);
        }

        if (sheetObj.GetCellValue(i, "vvd").length != 9) {
            sheetObj.SetCellBackColor(i, "vvd", "#FFFF66");            			
            sheetObj.SetCellFontColor(i, "vvd", "#FF0000");            
            strMsg += "[VVD] ";
            chkFlg = false;
        } else {
            sheetObj.SetCellValue(i, "vsl_cd", sheetObj.GetCellValue(i, "vvd").substring(0, 4));
            sheetObj.SetCellValue(i, "skd_voy_no", sheetObj.GetCellValue(i, "vvd").substring(4, 8));
            sheetObj.SetCellValue(i, "skd_dir_cd", sheetObj.GetCellValue(i, "vvd").substring(8, 9));
            sheetObj.SetCellValue(i, "vvd", sheetObj.GetCellValue(i, "vvd").toUpperCase());
            sheetObj.SetCellBackColor(i, "vvd", "#FFFFFF");            		
            sheetObj.SetCellFontColor(i, "vvd", "#000000");
        }
        
        if (sheetObj.GetCellValue(i, "ioc_ts_cd").length != 1) {
            sheetObj.SetCellBackColor(i, "ioc_ts_cd", "#FFFF66");             			
            sheetObj.SetCellFontColor(i, "ioc_ts_cd", "#FF0000");
            strMnMsg += "[OCN/IPC/TS] ";
            chkFlg = false;
        } else {
            sheetObj.SetCellBackColor(i, "ioc_ts_cd", "#FFFFFF");            			
            sheetObj.SetCellFontColor(i, "ioc_ts_cd", "#000000");
        }
       
        if (sheetObj.GetCellValue(i, "srep_usr_id").length != 0) {
            sheetObj.SetCellValue(i, "srep_usr_id", sheetObj.GetCellValue(i, "srep_usr_id").toUpperCase(), 0);
        }
        
        if (sheetObj.GetCellValue(i, "fcast_cust_tp_cd").length == 0) {
            sheetObj.SetCellValue(i, "fcast_cust_tp_cd", "B", 0);				//20160203.MOD : C->B
        }
        
        if (sheetObj.GetCellValue(i, "cust_cnt_cd").length == 0) {
            sheetObj.SetCellValue(i, "cust_cnt_cd", "XX", 0);
        } else {
            sheetObj.SetCellValue(i, "cust_cnt_cd", sheetObj.GetCellValue(i, "cust_cnt_cd").toUpperCase());
        }
        
        if (sheetObj.GetCellValue(i, "cust_seq").length == 0) {
            sheetObj.SetCellValue(i, "cust_seq", "999999", 0);
        }
        
        //20160203.ADD, 20160325.MOD
        if (sheetObj.GetCellValue(i, "ctrt_no").length != 0) {
            sheetObj.SetCellValue(i, "ctrt_no", sheetObj.GetCellValue(i, "ctrt_no").toUpperCase(), 0);
        } 
        if (sheetObj.GetCellValue(i, "ctrt_cust_cnt_cd").length != 0) {
            sheetObj.SetCellValue(i, "ctrt_cust_cnt_cd", sheetObj.GetCellValue(i, "ctrt_cust_cnt_cd").toUpperCase(), 0);
        }
        if (sheetObj.GetCellValue(i, "ctrt_cust_nm").length != 0) {					//NM은 들어와도 자동지움!!
            sheetObj.SetCellValue(i, "ctrt_cust_nm", "", 0);
        }
        
        //20160321.ADD, 20160325.MOD
        if (sheetObj.GetCellValue(i, "ctrt_no").length != 0) {
        	if (sheetObj.GetCellValue(i, "ctrt_cust_cnt_cd").length == 0 || sheetObj.GetCellValue(i, "ctrt_cust_seq").length == 0) {
                sheetObj.SetCellBackColor(i, "ctrt_cust_cnt_cd", "#FFFF66");             			
                sheetObj.SetCellFontColor(i, "ctrt_cust_cnt_cd", "#FF0000");
                sheetObj.SetCellBackColor(i, "ctrt_cust_seq", "#FFFF66");             			
                sheetObj.SetCellFontColor(i, "ctrt_cust_seq", "#FF0000");                
                strMsg += "[Ctrt Cust Info] ";
                chkFlg = false;
        	}
        }
        if (sheetObj.GetCellValue(i, "ctrt_cust_cnt_cd").length != 0 || sheetObj.GetCellValue(i, "ctrt_cust_seq").length != 0) {
        	if (sheetObj.GetCellValue(i, "ctrt_no").length == 0) {
                sheetObj.SetCellBackColor(i, "ctrt_no", "#FFFF66");             			
                sheetObj.SetCellFontColor(i, "ctrt_no", "#FF0000");            
                strMsg += "[Ctrt No. Info] ";
                chkFlg = false;
        	}
        }        

        if (sheetObj.GetCellValue(i, "fcast_ofc_cd").length == 0) {
            sheetObj.SetCellValue(i, "fcast_ofc_cd", document.form.usr_ofc_cd.value.toUpperCase(), 0);
        } else {
            sheetObj.SetCellValue(i, "fcast_ofc_cd", sheetObj.GetCellValue(i, "fcast_ofc_cd").toUpperCase(), 0);
        }

        if (sheetObj.GetCellValue(i, "pol_yd_cd").length != 5 && sheetObj.GetCellValue(i, "pol_yd_cd").length != 7) {
            sheetObj.SetCellBackColor(i, "pol_yd_cd", "#FFFF66");             			
            sheetObj.SetCellFontColor(i, "pol_yd_cd", "#FF0000");
            strMsg += "[Pol] ";
            chkFlg = false;
        } else {
            sheetObj.SetCellBackColor(i, "pol_yd_cd", "#FFFFFF");            			
            sheetObj.SetCellFontColor(i, "pol_yd_cd", "#000000");
            sheetObj.SetCellValue(i, "pol_yd_cd", sheetObj.GetCellValue(i, "pol_yd_cd").toUpperCase(), 0);
        }

        if (sheetObj.GetCellValue(i, "pod_yd_cd").length != 0 && sheetObj.GetCellValue(i, "pod_yd_cd").length != 5 && sheetObj.GetCellValue(i, "pod_yd_cd").length != 7) {
            sheetObj.SetCellBackColor(i, "pod_yd_cd", "#FFFF66");            	 			
            sheetObj.SetCellFontColor(i, "pod_yd_cd", "#FF0000");
            strMsg += "[Pod] ";
            chkFlg = false;
        } else {
            //IPC/TS 일때 Pod 컬럼 Mandatory 체크에서 걸리지 않으면 색상 해제
            if (chkIOC) {
                sheetObj.SetCellBackColor(i, "pod_yd_cd", "#FFFFFF");             			
	            sheetObj.SetCellFontColor(i, "pod_yd_cd", "#000000");
	            sheetObj.SetCellValue(i, "pod_yd_cd", sheetObj.GetCellValue(i, "pod_yd_cd").toUpperCase(), 0);
            }
        }

		var fcFlag = true;
		
//        if (sheetObj.GetCellValue(i, "fcast_ttl_qty").length == 0) {
//            sheetObj.SetCellBackColor(i, "fcast_ttl_qty", "#FFFF66");            			
//            sheetObj.SetCellFontColor(i, "fcast_ttl_qty", "#FF0000");
//            strMsg += "[F'cast TEU] ";
//            chkFlg = false;
//        } else {
//            sheetObj.SetCellBackColor(i, "fcast_ttl_qty", "#FFFFFF");             			
//            sheetObj.SetCellFontColor(i, "fcast_ttl_qty", "#000000");
//        }
        
        if (!chkFlg) {
            document.form.excel_chk.value = "N";
            var totMsg = "";

            if (strMsg.length > 0) {
                totMsg += "Wrong " + strMsg;
            }

            if (strMnMsg.length > 0) {
                totMsg += strMnMsg + "is mandatory";
            }
                        
            sheetObj.SetCellValue(i, "remark", totMsg, 0);
        }
        /*	 		
        	 		var nTeu=0; 	 		
        	 		var n40=0; 	 		
        	 		var n45=0;	 		
        	 		var nRF=0;	 	
        	 		var nTot=0;	
        	 		if(ComIsNumber(parseInt(sheetObj.GetCellValue(i, "fcast_ttl_qty")))){
        	 			nTeu=parseInt(sheetObj.GetCellValue(i, "fcast_ttl_qty"));
        	 		}	 		
        	 		if(ComIsNumber(parseInt(sheetObj.GetCellValue(i, "fcast_40ft_hc_qty'")))){
        	 			n40=parseInt(sheetObj.GetCellValue(i, "fcast_40ft_hc_qty"));
        	 		}
        	 		if(ComIsNumber(parseInt(sheetObj.GetCellValue(i, "fcast_45ft_hc_qty'")))){
        	 			n45=parseInt(sheetObj.GetCellValue(i, "fcast_45ft_hc_qty'"));
        	 		}
        	 		if(ComIsNumber(parseInt(sheetObj.GetCellValue(i, "fcast_rf_qty'")))){
        	 			nRF=parseInt(sheetObj.GetCellValue(i, "fcast_rf_qty'"));
        	 		}
        	 		nTot=n40*2 + n45*2 + nRF*2;	 		
        	 		if(fcFlag){
        		 		if(nTeu < nTot ){		 			
        		 			sheetObj.SetCellBackColor(i, "fcast_ttl_qty","#FFFF66");
        //parameter changed[check again]CLT 		 			
        		 			sheetObj.SetCellFontColor(i, "fcast_ttl_qty","#FF0000");
        		 			document.form.excel_chk.value="N";
        		 			sheetObj.SetCellValue(i,"remark","F'cast TEU");
        		 			chkFlg=false;
        		 		} else {		 			
        		 			sheetObj.SetCellBackColor(i, "fcast_ttl_qty","#000000");
        //parameter changed[check again]CLT 		 			
        		 			sheetObj.SetCellFontColor(i, "fcast_ttl_qty","#000000");
        		 		}	
        	 		}
        */
        //	 		if(sheetObj.CellValue(i, "40'").length == 0){
        //	 			sheetObj.CellBackColor(i, "40'") = "#FFFF66"; 
        //	 			sheetObj.CellFontColor(i, "40'") = "#FF0000";	
        //	 			document.form.excel_chk.value="N";
        //	 			sheetObj.CellValue(i,"remark") = "40'";
        //	 		}
        //	 		if(sheetObj.CellValue(i, "45'").length == 0){
        //	 			sheetObj.CellBackColor(i, "45'") = "#FFFF66"; 
        //	 			sheetObj.CellFontColor(i, "45'") = "#FF0000";	
        //	 			document.form.excel_chk.value="N";
        //	 			sheetObj.CellValue(i,"remark") = "45'";
        //	 		}
        //	 		if(sheetObj.CellValue(i, "RF'").length == 0){
        //	 			sheetObj.CellBackColor(i, "RF'") = "#FFFF66"; 
        //	 			sheetObj.CellFontColor(i, "RF'") = "#FF0000";	
        //	 			document.form.excel_chk.value="N";
        //	 			sheetObj.CellValue(i,"remark") = "RF'";
        //	 		}
        //	 		if(sheetObj.CellValue(i, "F'cast WT").length == 0){
        //	 			sheetObj.CellBackColor(i, "F'cast WT") = "#FFFF66"; 
        //	 			sheetObj.CellFontColor(i, "F'cast WT") = "#FF0000";	
        //	 			document.form.excel_chk.value="N";
        //	 			sheetObj.CellValue(i,"remark") = "F'cast WT";
        //	 		}	 		
        //	 		if(!ComIsDate(sheetObj.CellValue(i, "srep_usr_id"))){
        //	 			sheetObj.CellBackColor(i, "srep_usr_id") = "#FFFF66";
        //	 			sheetObj.CellFontColor(i, "srep_usr_id") = "#FF0000";		
        //	 			document.form.excel_chk.value="N";
        //	 			sheetObj.CellValue(i,"remark") = 'Srep Usr Id';
        //	 		}
    }
    //		var Rows;
    //		Rows = sheetObj.ColValueDupRows("cntr_no");
    //		alert(Rows);
    //		var arr_rows = Rows.split(',');
    //		alert(arr_rows);
    //		for (var i=0; arr_rows!='' && i<arr_rows.length; i++){
    //			sheetObj.RowFontColor(arr_rows[i]) = "#FF0000";
    //			document.form.excel_chk.value="N";
    //			sheetObj.CellValue(arr_rows[i],"remark") = 'Duplicate';
    //		}
    return chkFlg;
}


/**
 * validate check date format
 * @param {string}	src	date
 * @return
 */
function checkDateFormat(src) {
    var date_regexp = /(^\d{4}-\d{2}-\d{2}$)/;
    if (src.search(date_regexp) != -1) {
        return true;
    } else {
        return false;
    }
}

/**
 * validate check date format
 * @param {String}	str		YYYYMM
 * @return
 */
function isValidYYYYMM(src) {
    var str = src.replace(/\/|\-|\./g, "");
    /*
    		if (!isNumSlash(src) && !isNumPeriod(src) && !isNumDash(src)) {
    			return false;
    		}
    */
    if (str.length != 6) {
        return false;
    }
    var year = str.substring(0, 4);
    var month = str.substring(4, 6);
    if (ComParseInt(year) >= 1900 && isMonth(month))
        return true;
    else {
        return false;
    }
}

/**
 * validation check date+time format
 * @param {String}	str		YYYYMMDDHHMI
 * @return
 */
function isValidYYYYMMDDHHMI(str) {
    str = new String(str);
    str = str.replace(/\/|\-|\./g, "");
    if (!ComIsNumber(str)) {
        return false;
    }
    if (str.length != 12) {
        return false;
    }
    var sDate = str.substring(0, 8);
    var sHour = str.substring(8, 10);
    var sMin = str.substring(10, 12);
    if (ComIsDate(sDate) && ComIsTime(sHour + ":" + sMin, "hm")) {
        return true;
    } else {
        return false;
    }
}

/**
 * validation check month format
 * @param {String}	month	MM
 * @return
 */
function isMonth(month) {
    if (month.length > 2) return false;
    month = parseInt(month, 10);
    if ((month <= 0) || (month > 12)) return false;
    return true;
}

/**
 * validation check day format
 * @param {String}	day	DD
 * @return
 */
function isDay2(day) {
    if (day.length > 2) return false;
    day = parseInt(day, 10);
    if ((day <= 0) || (day > 31)) return false;
    return true;
}

/**
 * validation check day format
 * @param {String}	year	YYYY
 * @param {String}	month	MM
 * @param {String}	day		DD
 * @return
 */
function isDay(year, month, day) {
    if (day.length > 2) return false;
    year = parseInt(year, 10);
    month = parseInt(month, 10);
    day = parseInt(day, 10);
    if ((day <= 0) || (day > ComGetLastDay(year, month))) return false;
    return true;
}

/**
 * validation check hour format
 * @param {String}	hh	HH
 * @return
 */
function isHour(hh) {
    var h = parseInt(hh, 10);
    return (h >= 0 && h < 24);
}

/**
 * validation check minute format
 * @param {String}	mi	MI
 * @return
 */
function isMin(mi) {
    var m = parseInt(mi, 10);
    return (m >= 0 && m < 60);
}

/**
 * ComConfigSheet
 * @param {sheet}	sheet_obj	ibsheet
 * @return
 */
function TesComConfigSheet(sheet_obj) {
    ComConfigSheet(sheet_obj);
    try {
        with(sheet_obj) {
            //			  var arr = GetSelectionRows("/").split("/");
            //
            //			  if( arr.length > 0 ){
            //				  SelectBackColor       = "#FFF5E4";
            //				  RowFontColor(arr[0]) = "#FF0000";
            //			  }
            //no support[implemented common]CLT 				
            SelectHighLight = false;
            //no support[implemented common]CLT 				
            SelectFontBold = true;
        }
    } catch (err) {
        ComFuncErrMsg(err.message);
    }
}

function vvdChanged() {
    var obj = event.srcElement;
    if (obj.value == "") {
    	//20160211.MOD
        trade_OnChange(comObjects[0], "", "", "", "", comObjects[0].GetSelectText(), comObjects[0].GetSelectCode());
    } else {
        initDataValue_trade();
        initDataValue_subtrade();
        initDataValue_lane();
    }
}

//20160211.MOD
function trade_OnChange(combj, oldindex, oldtext, oldvalue, newIndex, text, value) {
    if (value == "") return;
    if (document.all.vvd.value != "") return;

    var formObj = document.form;
    var trade = formObj.trade.value;

    if (trade != null && trade != '') {
        SpcSearchOptionSubTrade("subtrade", true, false, "", formObj.trade.value); // 0207 SHKIM			
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subtrade.value, true); // 0207 SHKIM
    }
}
//20160211.MOD
function subtrade_OnChange(combj, value, text) {
    if (value == "") return;
    if (document.all.vvd.value != "") return;

    var formObj = document.form;
    var subtrade = formObj.subtrade.value;

    if (subtrade != null && subtrade != '') {
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subtrade.value, true); // 0207 SHKIM
    }
}

function initDataValue_trade() {
    var sheetObj = document.getElementById("trade");
    with(sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_subtrade() {
    var sheetObj = document.getElementById("subtrade");
    with(sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_lane() {
    var sheetObj = document.getElementById("lane");
    with(sheetObj) {
        Index2 = 0;
    }
}

function optionSetting() {
    SpcSearchOptionYear("year");
    SpcSearchOptionWeek("week");
    SpcSearchOptionDuration("duration", 5, 4);
    SpcSearchOptionTrade("trade");
    SpcSearchOptionSubTrade("subtrade", true, true);
    SpcSearchOptionLane("lane", true, true);
    SpcSearchOptionBound("bound");
}