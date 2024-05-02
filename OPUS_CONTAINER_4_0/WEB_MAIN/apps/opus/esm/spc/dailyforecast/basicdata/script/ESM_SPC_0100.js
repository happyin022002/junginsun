/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0100.js
*@FileTitle  : Lane-Office-POL
*@author     : CLT 
*@version    : 1.0 
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
/**
 * @extends
 * @class ESM_SPC_0100 : business script for ESM_SPC_0100
 */
var sheetObjects = new Array();
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
//sheetResizeFull = true;
//type check
var type_check;
//retrive check
var check_retrive = false;
var tab_retrives = null;
var searchParams = "";
document.onclick = processButtonClick;
var init_year = '';
var init_week = '';

/* Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve":
                //       			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();

                for (var i = 0; i < tab_retrives.length; i++) {
                    tab_retrives[i] = false;
                }
                doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
                break;
            case "btn_new":
                if (checkModifiedSheet(sheetObject)) {
                    if (ComShowConfirm(getMsg("SPC90001")) != 1) {
                        return;
                    }
                }
                //using common funtion : initializing the screen
                resetAll();
                for (var i = 0; i < tab_retrives.length; i++) {
                    tab_retrives[i] = false;
                }
                check_retrive = false;
                formObject.year.value = init_year;
                formObject.week.value = init_week;
                SpcSearchOptionWeek("week", false, document.form.year.value);
                SpcSearchOptionTrade("trade", true, true, '', true);
                SpcSearchOptionSubTrade("subtrade", true, true);
                SpcSearchOptionLane("lane", true, false); // 0207 SHKIM    	
                break;
            case "btn_save":
                doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
                break;
            case "btn_rowadd":
                for (var i = 0; i < tab_retrives.length; i++) {
                    tab_retrives[i] = false;
                }
                doActionIBSheet(sheetObjects[beforetab], formObject, IBINSERT);
                break;
            case "btn_downexcel":
                if (sheetObjects[beforetab].RowCount() < 1) { //no data 
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
                }

                break;
            case "btn_popup_pol_cd":
                var pol_cd = formObject.pol.value;
                spcPopup("POL", "tt_pol_cd=" + pol_cd, 770, 470, "getPOL", "1,0,1,1,1,1,1,1");
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

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
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
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * tab1_OnChange
 *
 */
function tab1_OnChange(tabObj, nItem) {
    var formObj = document.form;
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";
    //--------------- --------------------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
    //------------------------------------------------------//
    beforetab = nItem;
    resizeSheet();

    if (!check_retrive) return;
    if (beforetab == 0) {
        searchByWeek(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
    } else if (beforetab == 1) {
        searchByVvd(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
    }
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
    optionSetting();
    tab_retrives = new Array(sheetObjects.length);
    var objs = document.all.tabLayer;

    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        objs[i].style.display = "Inline";
        initSheet(sheetObjects[i], i + 1);
        objs[i].style.display = "none";
        ComEndConfigSheet(sheetObjects[i]);
    }
    //        var sheetResizeFull=true;
    //		document_onresize();
    resizeSheet();

    for (var k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }
    var formObject = document.form;
    formObject.year.focus();
    initSheetCombo();
    init_year = formObject.year.value;
    init_week = formObject.week.value;
    //    	
    //    	formObject.rhq.Code = "SHAAS";
    //    	formObject.trade.Code = "TPS";
    //    	formObject.lane.Code = "CAXTP";
    //    	formObject.ocnipc.value = "OCN";
}

function initSheetCombo() {
    initSheetCombo_trade();
    initSheetCombo_subtrade();
    initSheetCombo_lane();
    initSheetCombo_bound();
    initSheetCombo_ocnipc();
    initSheetCombo_year();
    initSheetCombo_week();
}

function initSheetCombo_trade() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var rtn = getCodeXmlList("TradeCombo", "isRepTrade=false&del=");
    var arrData = ComXml2ComboString(rtn, "trd_cd", "trd_nm");
    if (arrData != null) {
        var arrCode = arrData[0].split("|");
        var arrName = arrData[1].split("|");
        var conData = "";
        for (var i = 0; i < arrName.length; i++) {
            if (i == 0) {
                arrName[i] = arrCode[i] + "\t" + arrName[i];
            } else {
                arrName[i] = "|" + arrCode[i] + "\t" + arrName[i];
            }
            conData = conData.concat(arrName[i]);
        }
        arrData[1] = conData;
    }
    arrData[0] = " |" + arrData[0];
    arrData[1] = " |" + arrData[1];
    sheetObject.SetColProperty("rep_trd_cd", { ComboText: arrData[1], ComboCode: arrData[0] });
    sheetObject1.SetColProperty("rep_trd_cd", { ComboText: arrData[1], ComboCode: arrData[0] });
}

function initSheetCombo_subtrade() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true");
    var arrData = SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
    arrData[0] = " |" + arrData[0];
    arrData[1] = "\t\t|" + arrData[1];
    //sheetObject.SetColProperty("rep_sub_trd_cd", {ComboText:arrData[1] ,arrData[0], ComboCode:"",""} );
    sheetObject.SetColProperty("rep_sub_trd_cd", { ComboText: arrData[1], ComboCode: arrData[0], ShowCol: 1 });
    sheetObject1.SetColProperty("rep_sub_trd_cd", { ComboText: arrData[1], ComboCode: arrData[0], ShowCol: 1 });
}

function initSheetCombo_lane() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=");
    var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
    arrData[0] = " |" + arrData[0];
    arrData[1] = "\t\t\t|" + arrData[1];
    sheetObject.SetColProperty("rlane_cd", { ComboText: arrData[1], ComboCode: arrData[0], ShowCol: 2 });
    sheetObject1.SetColProperty("rlane_cd", { ComboText: arrData[1], ComboCode: arrData[0], ShowCol: 2 });
}

function initSheetCombo_bound() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var bound = " |E|W|S|N";
    sheetObject.SetColProperty("dir_cd", { ComboText: bound,  ComboCode: bound });
    sheetObject1.SetColProperty("dir_cd", { ComboText: bound, ComboCode: bound });
}

function initSheetCombo_ocnipc() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var ocnipc = " |OCN|IPC|T/S";
    sheetObject.SetColProperty("ioc_ts_cd", { ComboText: ocnipc,  ComboCode: ocnipc });
    sheetObject1.SetColProperty("ioc_ts_cd", { ComboText: ocnipc, ComboCode: ocnipc });
}

function initSheetCombo_year() {
    var sheetObject = sheetObjects[0];
    var today = new Date();
    var year = today.getFullYear();
    var pre = 1;
    var post = 5;
    var code = " ";
    for (var i = year + pre; i > year - pre - post; i--) {
        code = code + "|" + i;
    }
    sheetObject.SetColProperty("bse_yr", { ComboText: code, ComboCode: code });
}

function initSheetCombo_week() {
    var sheetObject = sheetObjects[0];
    var today = new Date();
    var year = today.getFullYear();
    var pre = 1;
    var post = 5;
    var code = " ";
    for (var i = 0; 54 > i; i++) {
        code = code + "|" + (i < 10 ? "0" : "") + i;
    }
    sheetObject.SetColProperty("bse_wk", { ComboText: code, ComboCode: code });
}

/**
 *Tab Basic setting
 *Setting items of tab
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("By Week", "");
                InsertItem("By VVD", "");
            }
            break;
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;
    switch (sheetNo) {
        case 1:
            initSheet1(sheetObj); //sheet1 init
            break;
        case 2:
            initSheet2(sheetObj); //sheet2 init
            break;
    }
}

/**
* Changing title after retrieving TabSheet1
*/
function initSheet1(sheetObj){       	 
	with(sheetObj){
		var HeadTitle1="DEL|STS|SEQ|Rep.\nTrade|Rep.\nSub\nTrade|Lane|BD|O/I/T|Start|Start|Area|RGN\nOFC|Port1|Port2|Port3|Port4|Port5|Port6|Port7|Port8|Port9|Port10";
		var HeadTitle2="DEL|STS|SEQ|Rep.\nTrade|Rep.\nSub\nTrade|Lane|BD|O/I/T|Year|WK|Area|RGN\nOFC|Port1|Port2|Port3|Port4|Port5|Port6|Port7|Port8|Port9|Port10";
		var cnt=0;

		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tmp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"ComboEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rep_trd_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, 	AcceptKeys:"E", InputCaseSensitive:1, EditLen:3 },
				{Type:"ComboEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rep_sub_trd_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, 	AcceptKeys:"E", InputCaseSensitive:1, EditLen:2 },
				{Type:"ComboEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, 	AcceptKeys:"E|N", InputCaseSensitive:1, EditLen:5 },
				{Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, 	AcceptKeys:"E", InputCaseSensitive:1, EditLen:1 },
				{Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ioc_ts_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, 	AcceptKeys:"E|[/]", InputCaseSensitive:1, EditLen:3 },
				{Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, 	AcceptKeys:"N", InputCaseSensitive:1, EditLen:4 },
				{Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_wk",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, 	AcceptKeys:"N", InputCaseSensitive:1, EditLen:2 },
				{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_aq_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6},
				{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6, AcceptKeys:"E", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd6",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N",  InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd8",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd9",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd10",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 } ];
		
		for(var i=0 ; i < 19 ; i++){
		  SetColProperty(0 ,3+i , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		}

		InitColumns(cols);
		InitComboNoMatchText(1,"",1);
		SetEditable(1);
		SetFocusEditMode(default_edit_mode);
		//              SetSheetHeight(getSheetHeight(19) );
		SetSheetHeight(ComGetSheetHeight(sheetObj, 17));
		SetCountPosition(0);
	}   	       
}
     
/**
* Changing the title after retrieving it in TabSheet2
*/
function initSheet2(sheetObj){
	with(sheetObj){
		var HeadTitle1="DEL|STS|SEQ|REP\nTrade|Sub\nTrade|Lane|BD|O/I/T|VVD|Year|WK|Area|RGN OFC|Port1|Port2|Port3|Port4|Port5|Port6|Port7|Port8|Port9|Port10";
		var HeadTitle2="DEL|STS|SEQ|REP\nTrade|Sub\nTrade|Lane|BD|O/I/T|VVD|Year|WK|Area|RGN OFC|Port1|Port2|Port3|Port4|Port5|Port6|Port7|Port8|Port9|Port10";
		var cnt=0;

		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tmp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					{Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rep_trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1, EditLen:3 },
					{Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rep_sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1 , EditLen:2 },
					{Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1, EditLen:5  },
					{Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1, EditLen:1 },
					{Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ioc_ts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E|[/]", InputCaseSensitive:1, EditLen:3 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9, InputCaseSensitive:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:6},
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:2},
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_aq_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:6},
					{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:6, AcceptKeys:"E", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd6",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd8",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd9",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
					{Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd10",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 } ];
		 
		 for(var i=0 ; i < 20 ; i++){
	//                	 InitDataValid(0, 3+i, vtEngUpOther,"0123456789");
			 SetColProperty(0 ,3+i , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		 }

	 InitColumns(cols);
	 InitComboNoMatchText(1,"",1);
	 SetEditable(1);
	//			 SetSheetHeight(getSheetHeight(19) );
	 SetFocusEditMode(default_edit_mode);
	 SetSheetHeight(ComGetSheetHeight(sheetObj, 17));
	 SetCountPosition(0);
	}
}

// Sheet Combo Setting Start 
function doActionIBSheet(sheetObj, formObj, sAction) {
    //        sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieving
            var sheetObj = sheetObjects[beforetab];
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            check_retrive = true;
            if (beforetab == 0) {
                searchByWeek(sheetObj, formObj, (SEARCHLIST01 + beforetab));
            } else if (beforetab == 1) {
                searchByVvd(sheetObj, formObj, (SEARCHLIST01 + beforetab));
            }
            break;
            
        case IBSAVE: //Saving	
            var tran_rows = sheetObj.FindStatusRow("I|U");
            if (!retouchPort(sheetObj, tran_rows)) { //Controling duplicated port and ordering
                return false;
            }
            if (!checkFormat(sheetObj, tran_rows)) {
                return false;
            }
            if (!checkDupRow(sheetObj)) { //Checking duplicated row with rgn ofc
                return false;
            }
            //20160225.ADD
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
      
            var rtn = doSaveSheet(sheetObj, "ESM_SPC_0100GS.do", "f_cmd=" + (MULTI01 + beforetab));
            break;
            
        case IBINSERT: // Insert
            var sheetObj = sheetObjects[beforetab];
            var Row = sheetObj.DataInsert();
            if (beforetab == 0) {
                var text = sheetObj.GetCellValue(Row, "ibflag")
                for (var k = 0; k < 10; k++) {
                    sheetObj.SetCellValue(Row, 22 + (k * 9), text, 0);
                }
            } else if (beforetab == 1) {
                var text = sheetObj.GetCellValue(Row, "ibflag");
                for (var j = 0; j < 10; j++) {
                    sheetObj.SetCellValue(Row, 23 + (j * 8), text, 0);
                }
            }
            break;
            
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) { //no data
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1,  Merge: 1,  ExcelFontSize: 9 });
            }
            break;
    }
}

function searchByWeek(sheetObj, formObj, command) {
    if (tab_retrives[beforetab]) return;
    var param = "year=" + formObj.year.value;
    param = param + "&week=" + formObj.week.value;
    param = param + "&rhq=" + comObjects[0].GetSelectCode();
    param = param + "&vvd=" + formObj.vvd.value;
    param = param + "&trade=" + comObjects[1].GetSelectCode();
    param = param + "&subtrade=" + comObjects[2].GetSelectCode();
    param = param + "&lane=" + comObjects[3].GetSelectCode();
    param = param + "&bound=" + formObj.bound.value;
    param = param + "&ocnipc=" + formObj.ocnipc.value;
    var rtn = sheetObj.DoSearch("ESM_SPC_0100GS.do", "f_cmd=" + command + "&" + param + "&" + ComGetPrefixParam(""));
    tab_retrives[beforetab] = true;
}

function searchByVvd(sheetObj, formObj, command) {
    if (tab_retrives[beforetab]) return;
    var param = "year=" + formObj.year.value;
    param = param + "&week=" + formObj.week.value;
    param = param + "&rhq=" + comObjects[0].GetSelectCode();
    param = param + "&vvd=" + formObj.vvd.value;
    param = param + "&trade=" + comObjects[1].GetSelectCode();
    param = param + "&subtrade=" + comObjects[2].GetSelectCode();
    param = param + "&lane=" + comObjects[3].GetSelectCode();
    param = param + "&bound=" + formObj.bound.value;
    param = param + "&ocnipc=" + formObj.ocnipc.value;
    var rtn = sheetObj.DoSearch("ESM_SPC_0100GS2.do", "f_cmd=" + command + "&" + param + "&" + ComGetPrefixParam(""));
    tab_retrives[beforetab] = true;
}

function t1sheet1_OnPopupClick(sheetObj, row, col) {
    if (sheetObj.ColSaveName(col).substring(0, 6) == "pol_cd") {
        var pol_cd = sheetObj.GetCellValue(row, col);
        spcPopup("POL", "tt_pol_cd=" + pol_cd + "", 770, 470, "setSheet1PopUpValue", "1,0,1,1,1,1,1,1", row, col);
    }
}

function t2sheet2_OnPopupClick(sheetObj, row, col) {
    if (sheetObj.ColSaveName(col).substring(0, 6) == "pol_cd") {
        var pol_cd = sheetObj.GetCellValue(row, col);
        spcPopup("POL", "tt_pol_cd=" + pol_cd + "", 770, 470, "setSheet2PopUpValue", "1,0,1,1,1,1,1,1", row, col);
    }
}

function setSheet1PopUpValue(rowArray, row, col) {
    var sheetObj = sheetObjects[0];
    var colArray = rowArray[0];
    sheetObj.SetCellValue(row, col, colArray[3]);
}

function setSheet2PopUpValue(rowArray, row, col) {
    var sheetObj = sheetObjects[1];
    var colArray = rowArray[0];
    sheetObj.SetCellValue(row, col, colArray[3]);
}

function checkFormat(sheetObj, trans_rows) {
    var arrRow = trans_rows.split(";");
    var sheetObj = sheetObjects[beforetab];
    for (var idx = 0; idx < arrRow.length - 1; idx++) {
        var trade = sheetObj.GetCellValue(arrRow[idx], 3);
        var subtrade = sheetObj.GetCellValue(arrRow[idx], 4);
        var lane = sheetObj.GetCellValue(arrRow[idx], 5);
        var dir_cd = sheetObj.GetCellValue(arrRow[idx], 6);
        var ioc_ts_cd = sheetObj.GetCellValue(arrRow[idx], 7);
        var bse_yr = sheetObj.GetCellValue(arrRow[idx], 8);
        var bse_wk = sheetObj.GetCellValue(arrRow[idx], 9);
        var sls_ofc_cd = sheetObj.GetCellValue(arrRow[idx], 11);
        var pol_cd = sheetObj.GetCellValue(arrRow[idx], 12);
        if (trade == "") {
            ComShowMessage(getMsg("SPC90117", "Trade"));
            sheetObj.SelectCell(arrRow[idx], 3, true);
            return false;
        } else if (subtrade == "") {
            ComShowMessage(getMsg("SPC90117", "Sub_Trade"));
            sheetObj.SelectCell(arrRow[idx], 4, true);
            return false;
        } else if (lane == "") {
            ComShowMessage(getMsg("SPC90117", "Lane"));
            sheetObj.SelectCell(arrRow[idx], 5, true);
            return false;
        } else if (dir_cd == "") {
            ComShowMessage(getMsg("SPC90117", "Bound"));
            sheetObj.SelectCell(arrRow[idx], 6, true);
            return false;
        } else if (ioc_ts_cd == "") {
            ComShowMessage(getMsg("SPC90117", "O/I/T"));
            sheetObj.SelectCell(arrRow[idx], 7, true);
            return false;
        }
        if (beforetab == 0) {
            if (bse_yr == "") {
                ComShowMessage(getMsg("SPC90117", "Year"));
                sheetObj.SelectCell(arrRow[idx], 8, true);
                return false;
            } else if (bse_wk == "") {
                ComShowMessage(getMsg("SPC90117", "Week"));
                sheetObj.SelectCell(arrRow[idx], 9, true);
                return false;
            } else if (sls_ofc_cd == "") {
                ComShowMessage(getMsg("SPC90117", "Office"));
                sheetObj.SelectCell(arrRow[idx], 11, true);
                return false;
            } else if (pol_cd == "") {
                ComShowMessage(getMsg("SPC90117", "Port"));
                sheetObj.SelectCell(arrRow[idx], 12, true);
                return false;
            }
        } else if (beforetab == 1) {
            var vvd = sheetObj.GetCellValue(arrRow[idx], 8);
            var sls_ofc_cd = sheetObj.GetCellValue(arrRow[idx], 12);
            var pol_cd = sheetObj.GetCellValue(arrRow[idx], 13);
            if (vvd == "") {
                ComShowMessage(getMsg("SPC90117", "Vvd"));
                sheetObj.SelectCell(arrRow[idx], 8, true);
                return false;
            } else if (sls_ofc_cd == "") {
                ComShowMessage(getMsg("SPC90117", "Office"));
                sheetObj.SelectCell(arrRow[idx], 12, true);
                return false;
            } else if (pol_cd == "") {
                ComShowMessage(getMsg("SPC90117", "Port"));
                sheetObj.SelectCell(arrRow[idx], 13, true);
                return false;
            }
        }
    }
    return true;
}

/*
 *  Changing trade
 */
function trade_OnChange(comObj, value, text) {
    //initializing sub_trade
    comObjects[2].index2 = 0;
    //initializing lane
    comObjects[3].SetSelectIndex(0, false); //check!!!!


    //    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);
    //		SpcSearchOptionLane("lane",true,false,'',value,'',true);
    //		
    var formObj = document.form;
    var trade = formObj.trade.value;

    //if (trade != null && trade != '') {
        SpcSearchOptionSubTrade("subtrade", true, false, "", formObj.trade.value); // 0207 SHKIM			
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subtrade.value, true); // 0207 SHKIM
    //}

}

function subtrade_OnChange(comObj, value, text) {
    //    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.GetSelectCode(),value,true);
    if (value == "") return;
//    var arrTrade = text.split("|");
//    if (arrTrade.length > 1) {
//        comObjects[1].SetSelectCode(arrTrade[0], false);
//        comObjects[3].SetSelectCode('', false);
//    } else {
//        comObjects[1].SetSelectCode(comObj.GetText(value, 0), false);
//        comObjects[3].SetSelectCode('', false);
//    }

    var formObj = document.form;
    var subtrade = formObj.subtrade.value;

    //if (subtrade != null && subtrade != '') {
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subtrade.value, true); // 0207 SHKIM
    //}

}

function lane_OnChange(comObj, value, text) {    
    if (value == "") return;
//    var arrLane = text.split("|");
//    if (arrLane.length > 1) {
//        comObjects[1].SetSelectCode(arrLane[0], false);
//        comObjects[2].SetSelectCode(arrLane[1], false);
//    } else {
//        comObjects[1].SetSelectCode(comObj.GetText(value, 0), false);
//        comObjects[2].SetSelectCode(comObj.GetText(value, 1), false);
//    }
}

function t1sheet1_OnChange(sheetObj, row, col, value) {    
    with(sheetObj) {
        switch (ColSaveName(col)) {
            case "rlane_cd":
//                if (value != "" && sheetObj.CellValue(row, "pol_cd1") != "") {
//                    if (!checkValidPort(sheetObj, row, "pol_cd1", sheetObj.CellValue(row, "pol_cd1"))) {
//                        sheetObj.CellValue(row, "pol_cd2")
//                        break;
//                    }
//                }
//                var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
//                SetCellValue(row, "rep_trd_cd", text, 0);
//                text = getSheetComboText(sheetObj, row, col, 1, "lane", value);
//                SetCellValue(row, "rep_sub_trd_cd", text, 0);
//                text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
//                SetCellValue(row, "rlane_cd", text, 0);
                break;
            case "rep_sub_trd_cd":
//                var text = getSheetComboText(sheetObj, row, col, 0, "subtrade", value);
//                SetCellValue(row, "rep_trd_cd", text, 0);
//                text = getSheetComboText(sheetObj, row, col, 1, "subtrade", value);
//                SetCellValue(row, "rep_sub_trd_cd", text, 0);
//                SetCellValue(row, "rlane_cd", "", 0);
				
				//SubTrade에 따른 Lane 세팅
				var strTrdCd = getSheetComboText(sheetObj, row, 3, 0, "trade", value);
				
				var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=&locTrdCd="+strTrdCd+"&locSubTrdCd="+value);
			    var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
			    arrData[0] = " |" + arrData[0];
			    arrData[1] = "\t\t\t|" + arrData[1];			    
			    sheetObj.InitCellProperty(row, "rlane_cd", {Type: "Combo", ComboText:arrData[1], ComboCode:arrData[0], ShowCol:2} );
			    
                break;
            case "rep_trd_cd":
//                var text = getSheetComboText(sheetObj, row, col, 0, "trade", value);
//                SetCellValue(row, "rep_trd_cd", text, 0);
//                SetCellValue(row, "rep_sub_trd_cd", "", 0);
//                SetCellValue(row, "rlane_cd", "", 0);
                
                //Trade에 따른 Sub Trade 세팅
                var rtn=getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true&trdCd="+value);
                var arrData=SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
                arrData[0]=" |" + arrData[0];
                arrData[1]="\t\t|" + arrData[1];
                                       
                sheetObj.InitCellProperty(row, "rep_sub_trd_cd", {Type: "Combo", ComboText:arrData[1], ComboCode:arrData[0], ShowCol:1} );    
                
                //Trade에 따른 Lane 세팅
                var strSubTrdCd = getSheetComboText(sheetObj, row, 4, 1, "subtrade", value);
                
                var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=&locTrdCd="+value+"&locSubTrdCd="+strSubTrdCd);
			    var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
			    arrData[0] = " |" + arrData[0];
			    arrData[1] = "\t\t\t|" + arrData[1];			    
			    sheetObj.InitCellProperty(row, "rlane_cd", {Type: "Combo", ComboText:arrData[1], ComboCode:arrData[0], ShowCol:2} );
                        
                break;
            case "dir_cd":
                var text = getSheetComboText(sheetObj, row, col, 0, "bound", value);
                SetCellValue(row, "dir_cd", text, 0);
                break;
            case "ioc_ts_cd":
                var text = getSheetComboText(sheetObj, row, col, 0, "ocnipc", value);
                SetCellValue(row, "ioc_ts_cd", text, 0);
                break;
            case "bse_yr":
                var text = getSheetComboText(sheetObj, row, col, 0, "year", value);
                if (text == "") text = value;
                SetCellValue(row, "bse_yr", text, 0);
                break;
            case "bse_wk":
                var text = getSheetComboText(sheetObj, row, col, 0, "week", value);
                SetCellValue(row, "bse_wk", text, 0);
                break;
            case "pol_cd1":
            case "pol_cd2":
            case "pol_cd3":
            case "pol_cd4":
            case "pol_cd5":
            case "pol_cd6":
            case "pol_cd7":
            case "pol_cd8":
            case "pol_cd9":
            case "pol_cd10":
                if (value != "") {
                    if (sheetObj.GetCellValue(row, "rlane_cd") == "") {
                        ComShowMessage(getMsg("SPC90117", "Lane first"));
                        sheetObj.SetCellValue(row, col, "", 0);
                        sheetObj.SelectCell(row, "rlane_cd");
                    } else if (sheetObj.GetCellValue(row, "dir_cd") == "") {
                        ComShowMessage(getMsg("SPC90117", "Bound first"));
                        sheetObj.SetCellValue(row, col, "", 0);
                        sheetObj.SelectCell(row, "dir_cd");
                    } else if (sheetObj.GetCellValue(row, "ioc_ts_cd") == "") {
                        ComShowMessage(getMsg("SPC90117", "OCN/IPC/TS first"));
                        sheetObj.SetCellValue(row, col, "", 0);
                        sheetObj.SelectCell(row, "ioc_ts_cd");
                    } else {
                        checkValidPort(sheetObj, row, col, value);
                    }
                }
                break;
            case "sls_ofc_cd":
                if (value != "") {
                    checkValidOfc(sheetObj, row, col, value);
                }
                break;
        }
    }
}

function t2sheet2_OnChange(sheetObj, row, col, value) {    
    with(sheetObj) {
        switch (ColSaveName(col)) {
            case "rlane_cd":
//                var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
//                SetCellValue(row, "rep_trd_cd", text, 0);
//                text = getSheetComboText(sheetObj, row, col, 1, "lane", value);
//                SetCellValue(row, "rep_sub_trd_cd", text, 0);
//                text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
//                SetCellValue(row, "rlane_cd", text, 0);
                break;
            case "rep_sub_trd_cd":
//                var text = getSheetComboText(sheetObj, row, col, 0, "subtrade", value);
//                SetCellValue(row, "rep_trd_cd", text, 0);
//                text = getSheetComboText(sheetObj, row, col, 1, "subtrade", value);
//                SetCellValue(row, "rep_sub_trd_cd", text, 0);
//                SetCellValue(row, "rlane_cd", "", 0);
                
                //SubTrade에 따른 Lane 세팅
				var strTrdCd = getSheetComboText(sheetObj, row, 3, 0, "trade", value);
				
				var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=&locTrdCd="+strTrdCd+"&locSubTrdCd="+value);
			    var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
			    arrData[0] = " |" + arrData[0];
			    arrData[1] = "\t\t\t|" + arrData[1];			    
			    sheetObj.InitCellProperty(row, "rlane_cd", {Type: "Combo", ComboText:arrData[1], ComboCode:arrData[0], ShowCol:2} );			    
                break;
            case "rep_trd_cd":
//                var text = getSheetComboText(sheetObj, row, col, 0, "trade", value);
//                SetCellValue(row, "rep_trd_cd", text, 0);
//                SetCellValue(row, "rep_sub_trd_cd", "", 0);
//                SetCellValue(row, "rlane_cd", "", 0);
                
                //Trade에 따른 Sub Trade 세팅
                var rtn=getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true&trdCd="+value);
                var arrData=SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
                arrData[0]=" |" + arrData[0];
                arrData[1]="\t\t|" + arrData[1];
                                       
                sheetObj.InitCellProperty(row, "rep_sub_trd_cd", {Type: "Combo", ComboText:arrData[1], ComboCode:arrData[0], ShowCol:1} );    
                
                //Trade에 따른 Lane 세팅
                var strSubTrdCd = getSheetComboText(sheetObj, row, 4, 1, "subtrade", value);
                
                var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=&locTrdCd="+value+"&locSubTrdCd="+strSubTrdCd);
			    var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
			    arrData[0] = " |" + arrData[0];
			    arrData[1] = "\t\t\t|" + arrData[1];			    
			    sheetObj.InitCellProperty(row, "rlane_cd", {Type: "Combo", ComboText:arrData[1], ComboCode:arrData[0], ShowCol:2} );
                break;
            case "dir_cd":
                var text = getSheetComboText(sheetObj, row, col, 0, "bound", value);
                SetCellValue(row, "dir_cd", text, 0);
                break;
            case "ioc_ts_cd":
                var text = getSheetComboText(sheetObj, row, col, 0, "ocnipc", value);
                SetCellValue(row, "ioc_ts_cd", text, 0);
                break;
            case "pol_cd1":
            case "pol_cd2":
            case "pol_cd3":
            case "pol_cd4":
            case "pol_cd5":
            case "pol_cd6":
            case "pol_cd7":
            case "pol_cd8":
            case "pol_cd9":
            case "pol_cd10":
                if (value != "") {
                    if (sheetObj.GetCellValue(row, "rlane_cd") == "") {
                        ComShowMessage(getMsg("SPC90117", "Lane first"));
                        sheetObj.SetCellValue(row, col, "", 0);
                        sheetObj.SelectCell(row, "rlane_cd");
                    } else if (sheetObj.GetCellValue(row, "dir_cd") == "") {
                        ComShowMessage(getMsg("SPC90117", "Bound first"));
                        sheetObj.SetCellValue(row, col, "", 0);
                        sheetObj.SelectCell(row, "dir_cd");
                    } else if (sheetObj.GetCellValue(row, "ioc_ts_cd") == "") {
                        ComShowMessage(getMsg("SPC90117", "OCN/IPC/TS first"));
                        sheetObj.SetCellValue(row, col, "", 0);
                        sheetObj.SelectCell(row, "ioc_ts_cd");
                    } else {
                        checkValidPort(sheetObj, row, col, value);
                    }
                }
                break;
            case "sls_ofc_cd":
                if (value != "") {
                    checkValidOfc(sheetObj, row, col, value);
                }
                break;
            case "vvd":
                if (value != "") {
                    if (sheetObj.GetCellValue(row, "ioc_ts_cd") == "") {
                        ComShowMessage(getMsg("SPC90117", "OCN/IPC/TS first"));
                        sheetObj.SetCellValue(row, col, "", 0);
                        sheetObj.SelectCell(row, "ioc_ts_cd");
                    } else if (sheetObj.GetCellValue(row, "rlane_cd") == "") {
                        ComShowMessage(getMsg("SPC90117", "Lane first"));
                        sheetObj.SetCellValue(row, col, "", 0);
                        sheetObj.SelectCell(row, "rlane_cd");
                    } else if (sheetObj.GetCellValue(row, "dir_cd") != value.substring(value.length - 1, value.length)) {
                        ComShowMessage("Please check a direction.");
                        sheetObj.SetCellValue(row, col, "", 0);
                    } else {
                        checkValidVvd(sheetObj, row, col, value);
                    }
                }
                break;
        }
    }
}

/**
 * handling process for input validation
 */
//20160225.ADD, MOD
function validateForm(sheetObj, formObj, sAction) {    
	switch (sAction) {
	case IBSEARCH: 	
	    var year = formObj.year.value;
	    var week = formObj.week.value;
	    var rhq = comObjects[0].GetSelectCode();
	    var vvd = formObj.vvd.value;
	    var trade = comObjects[1].GetSelectCode();		
	    if (year == "" && week == "") {
	        ComShowCodeMessage("COM12139", "Year", "Week");
	        formObj.year.focus();
	        return false;
	    }
	    
	    if (rhq == "") {
	        ComShowMessage(getMsg("SPC90114", "RHQ"));
	        comObjects[0].Focus();
	        return false;
	    }
	    
	    if (trade == "") {
	        ComShowMessage(getMsg("SPC90114", "Trade"));
	        //		    formObj.trade.focus();
	        comObjects[1].Focus();
	        return false;
	    }
	    
	    if (vvd != "" && vvd.length < 9) {
	        ComShowCodeMessage("COM12174", "VVD", "9");
	        formObj.vvd.focus();
	        return false;
	    }		
		break;
		
	case IBSAVE: 	
		var toCol = "";
		var thValue = "";
		var toValue = "";			
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if(sheetObj.GetCellValue(i, "ibflag") == "U" || sheetObj.GetCellValue(i, "ibflag") == "I") {
			
				for ( var Col = 0 ; Col <= sheetObj.LastCol() ; Col++) {
					if(sheetObj.ColSaveName(Col).substring(0,6)=="pol_cd") {
						if(ComParseInt(sheetObj.ColSaveName(Col).substring(6)) < 10)
						{
							toCol = sheetObj.ColSaveName(Col).substring(0,6) + (ComParseInt(sheetObj.ColSaveName(Col).substring(6))+1).toString();
							thValue = sheetObj.GetCellValue(i, sheetObj.ColSaveName(Col));	//현재
							toValue = sheetObj.GetCellValue(i, toCol);						//뒤
							if(thValue == "" && toValue != "") {
								ComShowMessage("Please Enter Port Information in Order.");
								sheetObj.SelectCell(i, sheetObj.ColSaveName(Col), true);
								return false;
								break;
							}
						}

					}
				}
				if(!checkValidOfc(sheetObj, i, "sls_ofc_cd", sheetObj.GetCellValue(i, "sls_ofc_cd"))){
				return false;
				}
			}
		}
  		break;
	}  
    return true;
}

function t1sheet2_OnSaveEnd(sheetObj, Code, errMsg) {
    if (sheetObj.GetEtcData("status") == "OK") {
//        ComShowMessage("saved successfully.");
    	ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.	
        doActionIBSheet(sheetObj, document.form, IBSEARCH); //위치이동(doActionIBSheet마지막에서 이곳으로)
    } else if (sheetObj.GetEtcData("status") != "OK") {
        ComShowMessage(errMsg);
    }
}

function t1sheet1_OnSaveEnd(sheetObj, Code, errMsg) {
    if (sheetObj.GetEtcData("status") == "OK") {
//        ComShowMessage("saved successfully.");
    	ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.	
        tab_retrives[0] = false;
        searchByWeek(t1sheet1, document.form, (SEARCHLIST01 + 0));
    } else {
        ComShowMessage(errMsg);
    }
}

function t2sheet2_OnSaveEnd(sheetObj, Code, errMsg) {
    if (sheetObj.GetEtcData("status") == "OK") {
//        ComShowMessage("saved successfully.");
    	ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.	
        tab_retrives[1] = false;
        searchByVvd(t2sheet2, document.form, (SEARCHLIST01 + 1));
    } else {
        ComShowMessage(errMsg);
    }
}

function initDataValue_rhq() {
    var sheetObj = document.getElementById("rhq");
    with(sheetObj) {
        Index2 = 0;
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

/**
 * In case of changing year of Start Week, changing week
 */
function checkWeek() {
    SpcSearchOptionWeek("week", false, document.form.year.value);
}

function checkValidPort(sheetObj, row, col, value) {
    var param = "f_cmd=" + SEARCH01;
    param = param + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd");
    param = param + "&dir_cd=" + sheetObj.GetCellValue(row, "dir_cd");
    param = param + "&ioc_ts_cd=" + sheetObj.GetCellValue(row, "ioc_ts_cd");
    
    if(beforetab == 1){
    	param = param + "&vvd=" + sheetObj.GetCellValue(row, "vvd");
    }
    
    param = param + "&pol_yd_cd=" + value;
    param = param + "&tab_index=" + beforetab;
    var sXml = sheetObj.GetSearchData("ESM_SPC_0100GS.do", param);
    var flg = ComGetEtcData(sXml, "valid_flg");
    if (flg != "Y") {
        ComShowMessage("Lane, Bound, O/I/T and Port do not match. Please check again.");
        sheetObj.SetCellValue(row, col, "", 0);
        sheetObj.SelectCell(row, col);
        return false;
    }
    return true;
}

function checkValidOfc(sheetObj, row, col, value) {
	var ibflag = sheetObj.GetCellValue(row, "ibflag");
    var param = "f_cmd=" + SEARCH02;
    param = param + "&sls_ofc_cd=" + value;
    var sXml = sheetObj.GetSearchData("ESM_SPC_0100GS.do", param);
    var flg = ComGetEtcData(sXml, "valid_flg");
    if (flg != "Y") {
    	if (ibflag == "I"){
    		ComShowMessage("Office is not level 4. Please check again.");
    		sheetObj.SetCellValue(row, col, "", 0);
    		return false;
    	}else{
    		ComShowMessage("Office is not level 4. Please check again.");
    		sheetObj.SetCellBackColor(row, col, "#FFFF66");         
    		sheetObj.SetCellFontColor(row, col,"#FF0000");
    		return false;
    	    }
    	
    	}
    return true;
}

function checkValidVvd(sheetObj, row, col, value) {
    var param = "f_cmd=" + SEARCH03;
    param = param + "&vvd=" + sheetObj.GetCellValue(row, "vvd");
    param = param + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd");
    param = param + "&ioc_ts_cd=" + sheetObj.GetCellValue(row, "ioc_ts_cd");
    var sXml = sheetObj.GetSearchData("ESM_SPC_0100GS.do", param);
    var flg = ComGetEtcData(sXml, "valid_flg");
    if (flg != "Y") {
        ComShowMessage(value + " is not a target VVD. Please check again.");
        sheetObj.SetCellValue(row, col, "", 0);
    }
}

function retouchPort(sheetObj, trans_rows) {
    var baseIdx;
    if (beforetab == 0) {
        baseIdx = 11;
    } else {
        baseIdx = 12;
    }
    var arrRow = trans_rows.split(";");
    for (var idx = 0; idx < arrRow.length - 1; idx++) {
        if (!removeDupPort(sheetObj, arrRow[idx], baseIdx)) {
            return false;
        }
        for (var portIdx = 10; portIdx > 1; portIdx--) {
            var polCd = sheetObj.GetCellValue(arrRow[idx], Number(baseIdx) + portIdx);
            if (polCd != "") {
                movingPort(sheetObj, arrRow[idx], portIdx, baseIdx);
            }
        }
    }
    return true;
}



function movingPort(sheetObj, row, portIdx, baseIdx) {
    var movePort = sheetObj.GetCellValue(row, Number(baseIdx) + portIdx);
    for (var i = 1; i < portIdx; i++) {
        var pCd = sheetObj.GetCellValue(row, Number(baseIdx) + i);
        if (pCd == "") {
            sheetObj.SetCellValue(row, Number(baseIdx) + i, movePort, 0);
            sheetObj.SetCellValue(row, Number(baseIdx) + portIdx, "", 0);
            return;
        }
    }
}

function removeDupPort(sheetObj, row, baseIdx) {
    for (var portIdx = 10; portIdx > 1; portIdx--) {
        var portCd = sheetObj.GetCellValue(row, Number(baseIdx) + portIdx);
        if (sheetObj.GetCellValue(row, Number(baseIdx) + portIdx) != "") {
            for (var cprIdx = portIdx - 1; cprIdx >= 1; cprIdx--) {
                var cprPortCd = sheetObj.GetCellValue(row, Number(baseIdx) + cprIdx);
                if (portCd == cprPortCd) {
                    ComShowMessage(getMsg("SPC90135"));
                    sheetObj.SelectCell(row, Number(baseIdx) + portIdx);
                    return false;
                }
            }
        }
    }
    return true;
}

function checkDupRow(sheetObj) {
    //no support[check again]CLT 		sheetObj.SpaceDupCheck=true;
    var cmprCol;
    if (beforetab == 0) {
        cmprCol = "3|4|5|6|7|8|9|11"; //trade,sub trade,lane,bd,oit,yr,wk,rgn ofc
    } else {
        cmprCol = "3|4|5|6|7|8|12"; //trade,sub trade,lane,bd,oit,vvd,rgn ofc
    }
    var rtn = sheetObj.ColValueDup(cmprCol, false);
    if (rtn != "-1") {
        ComShowMessage("There are duplicated rows. Please check again.");
        sheetObj.SelectCell(rtn, "tmp_seq");
        return false;
    }
    return true;
}

function optionSetting() {
    SpcSearchOptionYear("year");
    SpcSearchOptionWeek("week");
    //        	SpcSearchOptionRhq("rhq");


    if (document.form.ofc_cd.value == 'SINHO') {
        SpcSearchOptionRhq("rhq");
    } else {
        SpcSearchOptionRhq("rhq", "", "", "", true);
    }

    SpcSearchOptionTrade("trade", true, true);
    SpcSearchOptionSubTrade("subtrade", true, true);
    //SpcSearchOptionLane("lane", true, true);
    SpcSearchOptionLane("lane");
    SpcSearchOptionBound("bound");
    SpcSearchOptionIoc("ocnipc");
}

/**
 * This method counts numbers again.
 * @param Col
 * @param SortArrow
 */
//2014.08.06 김용습 - 정렬시 SEQ. 무너지는 버그 해결하기 위해 추가한 메소드
function sheet1_OnSort(Col, SortArrow) {
    sheet1.ReNumberSeq();
}

//function lane_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//    if (newCode == "") return;
//
//    var repTrade = comObj.GetText(newCode, 0);
//    var subTrade = comObj.GetText(newCode, 1);
//    comObjects[1].SetSelectCode(repTrade, false);
//    comObjects[2].SetSelectCode(subTrade, false);
//}

function resizeSheet() {
    for (var i = 0; i < sheetObjects.length; i++) {
        ComResizeSheet(sheetObjects[i]);
    }
}