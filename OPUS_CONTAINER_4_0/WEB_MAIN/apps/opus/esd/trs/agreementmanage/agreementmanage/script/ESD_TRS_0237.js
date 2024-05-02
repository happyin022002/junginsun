/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESD_TRS_0237.js
*@FileTitle      : Common Surcharge Management
*Open Issues     : 
*Change history  : 
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
=========================================================*/




/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * setting sheet initial values and header
 * parameters : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo)
{
    var sheetObject = sheetObjects[0];
    var cnt = 0;
    switch(sheetNo)
    {
        case 1: // sheet_main initialize
        with (sheetObj)
        {
            //SetSheetHeight(355);
            //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            var HeadTitle1="||Seq|Surcharge Kind|Cost\nMode|Trans\nMode|Geography Hierarchy|Geography Hierarchy|Geography Hierarchy|Equipment|Equipment|Equipment|Cargo|Bound|Rate\nType|Currency|CY\nRate|DR\nRate|Effective\nDate|Effective\nDate|Update\nInformation|Update\nInformation|Update\nInformation||||||" ;
            var HeadTitle2="||Seq|Surcharge Kind|Cost\nMode|Trans\nMode|RCC|LCC|SCC|Kind|Type|Size|Cargo|Bound|Rate\nType|Currency|CY\nRate|DR\nRate|From|To|ID|Name|Date||||||" ;

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:6, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [
                {Type:"CheckBox", Hidden:0, Width:30,  Align:"Center", ColMerge:1, SaveName:"sheet1_chk",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1  },
                {Type:"Status",   Hidden:1, Width:45,  Align:"Center", ColMerge:1, SaveName:"sheet1_ibflag",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1  },
                {Type:"Seq",      Hidden:0, Width:45,  Align:"Center", ColMerge:1, SaveName:"sheet1_seq",              KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12 },
                {Type:"Combo",    Hidden:0, Width:190, Align:"Left",   ColMerge:1, SaveName:"sheet1_com_scg_knd_cd",   KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6  },
                {Type:"Combo",    Hidden:0, Width:55,  Align:"Center", ColMerge:1, SaveName:"sheet1_trsp_cost_mod_cd", KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2  },
                {Type:"Combo",    Hidden:0, Width:55,  Align:"Center", ColMerge:1, SaveName:"sheet1_agmt_trsp_tp_cd",  KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2  },
                {Type:"Combo",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"sheet1_rcc_cd",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5  },
                {Type:"Popup",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"sheet1_lcc_cd",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5  },
                {Type:"Popup",    Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"sheet1_scc_cd",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5  },
                {Type:"Combo",    Hidden:0, Width:100, Align:"Center", ColMerge:1, SaveName:"sheet1_eq_knd_cd",        KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1  },
                {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"sheet1_eq_tp_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2  },
                {Type:"Combo",    Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"sheet1_eq_sz_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2  },
                {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"sheet1_cgo_tp_cd",        KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2  },
                {Type:"Combo",    Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"sheet1_bnd_cd",           KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1  },
                {Type:"Combo",    Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"sheet1_rt_tp_cd",         KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1  },
                {Type:"Combo",    Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"sheet1_curr_cd",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:3  },
                {Type:"Float",    Hidden:0, Width:90,  Align:"Right",  ColMerge:1, SaveName:"sheet1_one_wy_rt",        KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                {Type:"Float",    Hidden:0, Width:90,  Align:"Right",  ColMerge:1, SaveName:"sheet1_rnd_rt",           KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"sheet1_eff_fm_dt",        KeyField:1, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8  },
                {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"sheet1_eff_to_dt",        KeyField:1, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8  },
                {Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"sheet1_upd_usr_id",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:20 },
                {Type:"Text",     Hidden:0, Width:90,  Align:"Center", ColMerge:1, SaveName:"sheet1_upd_usr_nm",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:100},
                {Type:"Date",     Hidden:0, Width:75,  Align:"Center", ColMerge:1, SaveName:"sheet1_upd_dt",           KeyField:0, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:8  },
                {Type:"Text",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"sheet1_com_scg_seq",      KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:12 },
                {Type:"Text",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"sheet1_wo_aply_flg",      KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1  },
                {Type:"CheckBox", Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"sheet1_ck_vf",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1  },
                {Type:"Text",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"sheet1_h_bnd_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1  },
                {Type:"Float",    Hidden:1, Width:90,  Align:"Right",  ColMerge:1, SaveName:"sheet1_h_rnd_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:18 },
                {Type:"Text",     Hidden:1, Width:90,  Align:"Center", ColMerge:1, SaveName:"sheet1_h_curr_cd",        KeyField:0, CalcLogic:"", Format:"",          PointCount:3, UpdateEdit:1, InsertEdit:1, EditLen:3  },
                {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"sheet1_h_rcc_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5  },
                {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"sheet1_h_lcc_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5  },
                {Type:"Text",     Hidden:1, Width:80,  Align:"Center", ColMerge:1, SaveName:"sheet1_h_scc_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:5  }
            ];

            InitColumns(cols);
            SetEditable(1);
            SetAutoRowHeight(0);
            resizeSheet();
            SetColProperty('sheet1_com_scg_knd_cd', {ComboText:"|"+com_scg_knd_cdText, ComboCode:"|"+com_scg_knd_cdCode});
            SetColProperty('sheet1_trsp_cost_mod_cd', {ComboText:"|CY|DR", ComboCode:"|CY|DR"});
            SetColProperty('sheet1_agmt_trsp_tp_cd', {ComboText:"|"+agmt_trsp_tp_cdText, ComboCode:"|"+agmt_trsp_tp_cdCode});
            SetColProperty('sheet1_eq_knd_cd', {ComboText:eq_knd_cdText, ComboCode:eq_knd_cdCode});
            SetColProperty('sheet1_eq_tp_cd', {ComboText:eq_tp_cdCode, ComboCode:eq_tp_cdCode});
            SetColProperty('sheet1_eq_sz_cd', {ComboText:_eqSzComboListA, ComboCode:_eqSzComboListA});
            SetColProperty('sheet1_cgo_tp_cd', {ComboText:"|"+cgo_tp_cdText, ComboCode:"|"+cgo_tp_cdCode});
            SetColProperty('sheet1_bnd_cd', {ComboText:"|"+bnd_cdText, ComboCode:"|"+bnd_cdCode});
            SetColProperty('sheet1_rt_tp_cd', {ComboText:"|Fixed|Ratio", ComboCode:"|F|R"});
            SetColProperty('sheet1_curr_cd', {ComboText:"|"+curr_cdText, ComboCode:"|"+curr_cdCode});
            SetColProperty("sheet1_lcc_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
            SetColProperty("sheet1_scc_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
            document.form.header_row.value = HeaderRows() - 1;
        }
        break;
    }
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage()
{
    for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
    // EQ Type/Size Combo Settings
    change_eq_tp_sz(0);
}

/*------------------From here the common JavaScript function is defined     ------------------*/
/* Common global variable */
var sheetObjects = new Array();
var sheetCnt     = 0;

// Type, Size Combo List
var _eqTpComboListA = "AL|D|R|F|O|S|A|P|T|SF|SL|GN|CB|EG|ZT|CG|UG";
var _eqTpComboListU = "AL|D|R|F|O|S|A|P|T";
var _eqTpComboListZ = "AL|SF|SL|GN|CB|EG|ZT";
var _eqTpComboListG = "AL|CG|UG";
var _eqSzComboListA = "AL|2|4|5|7|8|9";
var _eqSzComboListU = "AL|2|4|5|7|9";
var _eqSzComboListZ = "AL|2|4|5|7|8";
var _eqSzComboListG = "AL";

document.onclick = processButtonClick;

/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick()
{
    var sheetObject = sheetObjects[0];

    /*******************************************************/
    var formObject = document.form;

    try
    {
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName)
        {
            case "btn_retrieve":
        		if(validateFormSearch())
                {
                    doActionIBSheet(sheetObject, formObject, IBSEARCH);
                }
            break;

            case "btn_new":
                reset_all();
            break;

            case "btn_save":
                doActionIBSheet(sheetObject, formObject, IBSAVE);
            break;

            case "btng_row_add":
                var row = sheetObject.DataInsert(-1);
                sheetObject.SetCellValue(row,  'sheet1_ck_vf', 1, 0);
                sheetObject.SetCellValue(row,  'sheet1_chk',   1, 0);
                sheetObject.CellComboItem(row, "sheet1_eq_tp_cd", {ComboText:_eqTpComboListU, ComboCode:_eqTpComboListU});
                sheetObject.CellComboItem(row, "sheet1_eq_sz_cd", {ComboText:_eqSzComboListU, ComboCode:_eqSzComboListU});
                sheetObject.SetCellValue(row,  "sheet1_eff_to_dt", "99991231", 0);
            break;

            case "btng_row_delete":
                doActionIBSheet(sheetObject, formObject, IBDELETE, "");
            break;

            case "btns_calendar":
                var cal = new ComCalendar();
                cal.select(formObject.eff_dt, 'yyyy-MM-dd');
            break;
            
            case "btng_loadexcel":
            	doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
            break;
            
            case "btng_downexcel":
            	if (sheetObject.RowCount() < 1){ //no data
                    ComShowCodeMessage("COM132501");
                } else {
                	doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                }
            break;
        }
    }
    catch(e)
    {
        if( e == "[object Error]")
        {
            ComShowCodeMessage('TRS90031');
        }
        else
        {
            ComShowMessage(e);
        }
    }
}

/**
 * When you click the radio button to delete the status change and add hidden value, the opposite value.
 */
function change_eq_val()
{
    var formObject = document.form;
    var num;

    if ( formObject.btns_radio_eq[0].checked == true )
    {
        formObject.eq_knd_cd.value = "";
        formObject.cgo_tp_cd.disabled = false;
        formObject.bnd_cd.disabled = false;
        num = 0;
    }
    else if( formObject.btns_radio_eq[1].checked == true )
    {
        formObject.eq_knd_cd.value = "U";
        formObject.cgo_tp_cd.disabled = false;
        formObject.bnd_cd.disabled = false;
        num = 1;
    }
    else if( formObject.btns_radio_eq[2].checked == true )
    {
        formObject.eq_knd_cd.value = "Z";
        formObject.cgo_tp_cd.value = "ALL";
        formObject.bnd_cd.value = "ALL";
        formObject.cgo_tp_cd.disabled = true;
        formObject.bnd_cd.disabled = true;
        num = 2;
    }
    else if( formObject.btns_radio_eq[3].checked == true )
    {
        formObject.eq_knd_cd.value = "G";
        formObject.cgo_tp_cd.value = "ALL";
        formObject.bnd_cd.value = "ALL";
        formObject.cgo_tp_cd.disabled = true;
        formObject.bnd_cd.disabled = true;
        num = 3;
    }

    change_eq_tp_sz(num);
}


/////////////////////////////////////////
// EQ Type/Size Combo Settings BEGIN
/////////////////////////////////////////

function change_eq_tp_sz(num)
{
    var formObject = document.form;

    /////////////////////////////
    // EQ Type
    /////////////////////////////
    tpList    = new Array(2);
    tpList[0] = new Array(18);
    tpList[1] = new Array(9);
    tpList[2] = new Array(8);
    tpList[3] = new Array(3);

    // ALL
    tpList[0][0] ="AL";
    tpList[0][1] ="D";
    tpList[0][2] ="R";
    tpList[0][3] ="F";
    tpList[0][4] ="O";
    tpList[0][5] ="S";        
    tpList[0][6] ="A";
    tpList[0][7] ="P";
    tpList[0][8] ="T";
    tpList[0][9] ="SF";
    tpList[0][10]="SL";
    tpList[0][11]="TA";
    tpList[0][12]="GN";
    tpList[0][13]="CB";
    tpList[0][14]="EG";
    tpList[0][15]="ZT";
    tpList[0][16]="CG";
    tpList[0][17]="UG";

    // Container
    tpList[1][0] ="AL";
    tpList[1][1] ="D";
    tpList[1][2] ="R";
    tpList[1][3] ="F";
    tpList[1][4] ="O";
    tpList[1][5] ="S";        
    tpList[1][6] ="A";
    tpList[1][7] ="P";
    tpList[1][8] ="T";

    // Chassis
    tpList[2][0] ="AL";
    tpList[2][1] ="SF";
    tpList[2][2] ="SL";
    tpList[2][3] ="TA";
    tpList[2][4] ="GN";
    tpList[2][5] ="CB";
    tpList[2][6] ="EG";
    tpList[2][7] ="ZT";

    // Genset
    tpList[3][0] ="AL";
    tpList[3][1] ="CG";
    tpList[3][2] ="UG";

    /////////////////////////////
    // EQ Size
    /////////////////////////////
    szList    = new Array(2);        
    szList[0] = new Array(7);
    szList[1] = new Array(6);
    szList[2] = new Array(5);
    szList[3] = new Array(1);

    // ALL
    szList[0][0] ="AL";
    szList[0][1] ="2";
    szList[0][2] ="4";
    szList[0][3] ="5";
    szList[0][4] ="7";
    szList[0][5] ="8";
    szList[0][6] ="9";

    // Container
    szList[1][0] ="AL";
    szList[1][1] ="2";
    szList[1][2] ="4";
    szList[1][3] ="5";
    szList[1][4] ="7";
    szList[1][5] ="9";

    // Chassis
    szList[2][0] ="AL";
    szList[2][1] ="2";
    szList[2][2] ="4";
    szList[2][3] ="5";
    szList[2][4] ="8";

    // Genset
    szList[3][0] ="AL";

    for(var ctr = 0; ctr < tpList[num].length; ctr++)
    {
       // Category fill the combo box value
       formObject.eq_tp_cd.options[ctr] = new Option(tpList[num][ctr], tpList[num][ctr]);
    }

    for(var ctr = 0; ctr < szList[num].length; ctr++)
    {
       // Category fill the combo box value
       formObject.eq_sz_cd.options[ctr] = new Option(szList[num][ctr], szList[num][ctr]);
    }

    // Select specify the length of the list
    formObject.eq_tp_cd.length = tpList[num].length;
    formObject.eq_sz_cd.length = szList[num].length;
}

/////////////////////////////////////////
//EQ Type/Size Combo Settings END
/////////////////////////////////////////


/////////////////////////////////////////
//EQ Type Size Settings BEGIN
/////////////////////////////////////////
function change_eq_tp()
{
    var formObject = document.form;
    var eqKind     = formObject.eq_knd_cd.value;
    var eqTp       = formObject.eq_tp_cd.value;
    var num;

    /////////////////////////////
    // EQ Size
    /////////////////////////////
    szList    = new Array(2);
    szList[0] = new Array(7);
    szList[1] = new Array(6);
    szList[2] = new Array(5);
    szList[3] = new Array(1);

    // ALL
    szList[0][0] ="AL";
    szList[0][1] ="2";
    szList[0][2] ="4";
    szList[0][3] ="5";
    szList[0][4] ="7";
    szList[0][5] ="8";
    szList[0][6] ="9";

    // Container
    szList[1][0] ="AL";
    szList[1][1] ="2";
    szList[1][2] ="4";
    szList[1][3] ="5";
    szList[1][4] ="7";
    szList[1][5] ="9";

    // Chassis
    szList[2][0] ="AL";
    szList[2][1] ="2";
    szList[2][2] ="4";
    szList[2][3] ="5";
    szList[2][4] ="8";

    // Genset
    szList[3][0] ="AL";

    // ALL
    if(eqKind == '')
    {
        if(eqTp == 'AL')
        {
            num = 0;
        }
        else if(eqTp == 'D'
             || eqTp == 'R'
             || eqTp == 'F'
             || eqTp == 'O'
             || eqTp == 'S'
             || eqTp == 'A'
             || eqTp == 'P'
             || eqTp == 'T')
        {
            num = 1;
        }
        else if(eqTp == 'SF'
             || eqTp == 'SL'
             || eqTp == 'TA'
             || eqTp == 'GN'
             || eqTp == 'CB'
             || eqTp == 'EG'
             || eqTp == 'ZT')
        {
            num = 2;
        }
        else if(eqTp == 'CG'
             || eqTp == 'UG')
        {
            num = 3;
        }
        for(var ctr = 0; ctr < szList[num].length; ctr++)
        {
            // Category fill the combo box value
            formObject.eq_sz_cd.options[ctr] = new Option(szList[num][ctr], szList[num][ctr]);
        }
        formObject.eq_sz_cd.length = szList[num].length;
    }
}

/////////////////////////////////////////
//EQ Type Size Settings END
/////////////////////////////////////////


// Cargo : EMPTY === > Bound Deactivating
function change_cgo_tp()
{
    var formObject = document.form;

    if ( formObject.cgo_tp_cd.value == "M" )
    {
        formObject.bnd_cd.value = "ALL";
        formObject.bnd_cd.disabled = true;
    }
    else
    {
        formObject.bnd_cd.disabled = false;
    }
}

/**
 * handling of Sheet 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    var formObject = document.form;
    var x1 ="";

    switch(sAction) {
    	case COMMAND01:
    		formObj.f_cmd.value = INIT;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            var sXml = sheetObj.GetSearchData("ESD_TRS_0237GS.do", FormQueryString(formObj), {sync:2});
            var arrXml = sXml.split("|$$|");
            // RCC Code 값 IBCombo에 입력
            ComXml2ComboItem(arrXml[0], rcc_cd, "rcc_cd", "rcc_cd");
            comboObjects[0].InsertItem(0, " ALL", "ALL");
            // IBCombo 초기값을 "ALL"로 설정
            rcc_cd.SetSelectCode("ALL");
            rcc_cd.SetDropHeight(300);
            
            // RCC Code 값 IBSheet에 입력
            var rccCdList = ComXml2ComboString(arrXml[0], "rcc_cd", "rcc_cd");
            var rccCdCombo = rccCdList[0];
            sheetObj.SetColProperty('sheet1_rcc_cd', {ComboText:"|" + rccCdCombo, ComboCode:"|" + rccCdCombo});
            
            ComOpenWait(false);
    	break;
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH01;
            sheetObj.DoSearch("ESD_TRS_0237GS.do", TrsFrmQryString(formObj) + "&IBPREFIX=sheet1_");
        break;

        case IBSAVE:
            if( sheetObj.CheckedRows("sheet1_chk") < 1 ) {
                ComShowCodeMessage('TRS90381');
                return false;
            }
            
            if(!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            //if(confirm("Are you sure to save?"))
            //{

				var sParam = sheetObj.GetSaveString(false, true, "sheet1_chk");
                formObj.f_cmd.value = MULTI01;
                var sXml = sheetObj.GetSaveData("ESD_TRS_0237GS.do", TrsFrmQryString(formObj) + "&" + sParam);
    			var rowNo = ComGetEtcData(sXml, "ROW_NO");
    			var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
    			if(result != "S") {
//    				ComShowMessage(ComResultMessage(sXml));
    				showErrorMsg(sXml);
    				ComOpenWait(false, false);
                    return false;
    			} else if (rowNo != undefined && rowNo != "") {
    				ComShowCodeMessage("TRS90412", "Row " + rowNo);
    				ComOpenWait(false, false);
                    return false;
    			} else {
    				sheetObj.LoadSaveData(sXml);
    			}
            //}
        break;

        case IBDELETE:
            if( sheetObj.CheckedRows("sheet1_chk") < 1 ) {
                ComShowCodeMessage('TRS90383');
                return false;
            } else {
                eq_delete(sheetObj, "sheet1_chk"); //ROW is not stored in the DB to handle a dropped first.
                if( sheetObj.CheckedRows("sheet1_chk") < 1 ) return false; //That is not stored in the DB to be deleted sakjecheorihu ROW ROW If you do not have the event does not run anymore.
                if(confirm("Are you sure to delete?")) {
                    formObj.f_cmd.value = REMOVE01;
                    sheetObj.DoSave("ESD_TRS_0237GS.do", TrsFrmQryString(formObj), "sheet1_chk", false, true);
                }
            }
        break;
        
        case IBLOADEXCEL:
            sheetObj.SetWaitImageVisible(0);
            sheetObj.LoadExcel({Append:1});
        break;
        
        case IBDOWNEXCEL:
        	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
        break;
    }
}

/**
 * setSheetObject
 */
function setSheetObject(sheet_obj)
{
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
 */
function sheet0_OnLoadFinish()
{

}

/**
 * Views that occur after the EVENT
 */
function sheet0_OnSearchEnd(sheetObj, errMsg)
{
    var sheet_count = sheetObj.RowCount();
    for(var k=sheetObj.HeaderRows(); k<sheet_count+sheetObj.HeaderRows(); k++)
    {
        sheetObj.SetCellEditable(k, "sheet1_com_scg_knd_cd", 0);

        if(sheetObj.GetCellValue(k, "sheet1_com_scg_knd_cd") == 'SCFAAL'
        || sheetObj.GetCellValue(k, "sheet1_com_scg_knd_cd") == 'SCFCAL')
        {
            sheetObj.SetCellEditable(k, "sheet1_rt_tp_cd", 1);
        }
        else
        {
            sheetObj.SetCellEditable(k, "sheet1_rt_tp_cd", 0);
        }

        if(sheetObj.GetCellValue(k, "sheet1_trsp_cost_mod_cd") == 'CY')
        {
            sheetObj.SetCellEditable(k, "sheet1_one_wy_rt", 1);
            sheetObj.SetCellEditable(k, "sheet1_rnd_rt", 0);
        }
        else if(sheetObj.GetCellValue(k, "sheet1_trsp_cost_mod_cd") == 'DR')
        {
            sheetObj.SetCellEditable(k, "sheet1_one_wy_rt", 0);
            sheetObj.SetCellEditable(k, "sheet1_rnd_rt", 1);
        }

        if(sheetObj.GetCellValue(k, "sheet1_rcc_cd") != '' && sheetObj.GetCellValue(k, "sheet1_lcc_cd") == '' && sheetObj.GetCellValue(k, "sheet1_scc_cd") == '')
        {
            sheetObj.SetCellEditable(k, "sheet1_lcc_cd", 0);
            sheetObj.SetCellEditable(k, "sheet1_scc_cd", 0);
        }
        else if(sheetObj.GetCellValue(k, "sheet1_rcc_cd") == '' && sheetObj.GetCellValue(k, "sheet1_lcc_cd") != '' && sheetObj.GetCellValue(k, "sheet1_scc_cd") == '')
        {
            sheetObj.SetCellEditable(k, "sheet1_rcc_cd", 0);
            sheetObj.SetCellEditable(k, "sheet1_scc_cd", 0);
        }
        else if(sheetObj.GetCellValue(k, "sheet1_rcc_cd") == '' && sheetObj.GetCellValue(k, "sheet1_lcc_cd") == '' && sheetObj.GetCellValue(k, "sheet1_scc_cd") != '')
        {
            sheetObj.SetCellEditable(k, "sheet1_rcc_cd", 0);
            sheetObj.SetCellEditable(k, "sheet1_lcc_cd", 0);
        }
        else if(sheetObj.GetCellValue(k, "sheet1_rcc_cd") == '' && sheetObj.GetCellValue(k, "sheet1_lcc_cd") == '' && sheetObj.GetCellValue(k, "sheet1_scc_cd") == '')
        {
            sheetObj.SetCellEditable(k, "sheet1_rcc_cd", 1);
            sheetObj.SetCellEditable(k, "sheet1_lcc_cd", 1);
            sheetObj.SetCellEditable(k, "sheet1_scc_cd", 1);
        }

        if(sheetObj.GetCellValue(k, "sheet1_eq_knd_cd") == 'U')
        {
            sheetObj.CellComboItem(k,"sheet1_eq_tp_cd", {ComboText:_eqTpComboListU, ComboCode:_eqTpComboListU} );
            sheetObj.CellComboItem(k,"sheet1_eq_sz_cd", {ComboText:_eqSzComboListU, ComboCode:_eqSzComboListU} );
            sheetObj.SetCellEditable(k, "sheet1_cgo_tp_cd", 1);
            sheetObj.SetCellEditable(k, "sheet1_bnd_cd", 1);
        }
        else if(sheetObj.GetCellValue(k, "sheet1_eq_knd_cd") == 'Z')
        {
            sheetObj.CellComboItem(k,"sheet1_eq_tp_cd", {ComboText:_eqTpComboListZ, ComboCode:_eqTpComboListZ} );
            sheetObj.CellComboItem(k,"sheet1_eq_sz_cd", {ComboText:_eqSzComboListZ, ComboCode:_eqSzComboListZ} );
            sheetObj.SetCellEditable(k, "sheet1_cgo_tp_cd", 0);
            sheetObj.SetCellEditable(k, "sheet1_bnd_cd", 0);
        }
        else if(sheetObj.GetCellValue(k, "sheet1_eq_knd_cd") == 'G')
        {
            sheetObj.CellComboItem(k,"sheet1_eq_tp_cd", {ComboText:_eqTpComboListG, ComboCode:_eqTpComboListG} );
            sheetObj.CellComboItem(k,"sheet1_eq_sz_cd", {ComboText:_eqSzComboListG, ComboCode:_eqSzComboListG} );
            sheetObj.SetCellEditable(k, "sheet1_cgo_tp_cd", 0);
            sheetObj.SetCellEditable(k, "sheet1_bnd_cd", 0);
        }

        if(sheetObj.GetCellValue(k, "sheet1_cgo_tp_cd") == 'F')
        {
            sheetObj.SetCellEditable(k, "sheet1_bnd_cd", 1);
            //sheetObj.SetCellEditable(k, "rnd_rt", 1);
        }
        else
        {
            sheetObj.SetCellEditable(k, "sheet1_bnd_cd", 0);
            //sheetObj.SetCellEditable(k, "rnd_rt", 0);
        }

        if(sheetObj.GetCellValue(k, "sheet1_rt_tp_cd") == 'R')
        {
            sheetObj.SetCellEditable(k, "sheet1_curr_cd", 0);
        }
        else
        {
            sheetObj.SetCellEditable(k, "sheet1_curr_cd", 1);
        }

        if(sheetObj.GetCellValue(k, "sheet1_com_scg_seq") != "")
        {
            sheetObj.SetCellValue(k, "sheet1_h_bnd_cd",  sheetObj.GetCellValue(k, "sheet1_bnd_cd"),  0);
            sheetObj.SetCellValue(k, "sheet1_h_rnd_rt",  sheetObj.GetCellValue(k, "sheet1_rnd_rt"),  0);
            sheetObj.SetCellValue(k, "sheet1_h_curr_cd", sheetObj.GetCellValue(k, "sheet1_curr_cd"), 0);
            sheetObj.SetCellValue(k, "sheet1_h_rcc_cd",  sheetObj.GetCellValue(k, "sheet1_rcc_cd"),  0);
            sheetObj.SetCellValue(k, "sheet1_h_lcc_cd",  sheetObj.GetCellValue(k, "sheet1_lcc_cd"),  0);
            sheetObj.SetCellValue(k, "sheet1_h_scc_cd",  sheetObj.GetCellValue(k, "sheet1_scc_cd"),  0);
        }
    }
}

/**
 * sheet0_OnChange
 */
function sheet0_OnChange(sheetObj, row, col, value)
{
    if( sheetObj.ColSaveName(col) != "sheet1_chk" )
    {
        sheetObj.SetCellValue(row, 'sheet1_chk',   1, 0);
        sheetObj.SetCellValue(row, 'sheet1_ck_vf', 1, 0);
    }

    var form = document.form;
    var colName = sheetObj.ColSaveName(col);
    switch(colName)
    {
        case "sheet1_com_scg_knd_cd": 
            if(value == 'SCFAAL' || value == 'SCFCAL')
            {
                sheetObj.SetCellValue(row, "sheet1_rt_tp_cd","F", 0);
                sheetObj.SetCellEditable(row, "sheet1_rt_tp_cd", 1);
            }
            else
            {
                sheetObj.SetCellValue(row, "sheet1_rt_tp_cd","F", 0);
                sheetObj.SetCellEditable(row, "sheet1_rt_tp_cd", 0);
            }
            break;

        case "sheet1_trsp_cost_mod_cd": 
            if(value == 'CY')
            {
                //sheetObj.SetCellValue(row, "sheet1_one_wy_rt", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_one_wy_rt", 1);
                sheetObj.SetCellValue(row, "sheet1_rnd_rt", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_rnd_rt", 0);
            }
            else if(value == 'DR')
            {
                sheetObj.SetCellValue(row, "sheet1_one_wy_rt", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_one_wy_rt", 0);
                //sheetObj.SetCellValue(row, "sheet1_rnd_rt", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_rnd_rt", 1);
            }
            break;

        case "sheet1_rcc_cd": 
            if(value != '')
            {
                sheetObj.SetCellValue(row, "sheet1_lcc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_lcc_cd", 0);
                sheetObj.SetCellValue(row, "sheet1_scc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_scc_cd", 0);
            }
            else
            {
                sheetObj.SetCellValue(row, "sheet1_lcc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_lcc_cd", 1);
                sheetObj.SetCellValue(row, "sheet1_scc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_scc_cd", 1);
            }
            break;

        case "sheet1_lcc_cd": 
            if(value != '')
            {
                sheetObj.SetCellValue(row, "sheet1_rcc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_rcc_cd", 0);
                sheetObj.SetCellValue(row, "sheet1_scc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_scc_cd", 0);
            }
            else
            {
                sheetObj.SetCellValue(row, "sheet1_rcc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_rcc_cd", 1);
                sheetObj.SetCellValue(row, "sheet1_scc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_scc_cd", 1);
            }
            break;

        case "sheet1_scc_cd": 
            if(value != '')
            {
                sheetObj.SetCellValue(row, "sheet1_rcc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_rcc_cd", 0);
                sheetObj.SetCellValue(row, "sheet1_lcc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_lcc_cd", 0);
            }
            else
            {
                sheetObj.SetCellValue(row, "sheet1_rcc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_rcc_cd", 1);
                sheetObj.SetCellValue(row, "sheet1_lcc_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_lcc_cd", 1);
            }
            break;

        case "sheet1_eq_knd_cd": 
            if(value == '')
            {
                sheetObj.CellComboItem(row,"sheet1_eq_tp_cd", {ComboText:_eqTpComboListA, ComboCode:_eqTpComboListA} );
                sheetObj.CellComboItem(row,"sheet1_eq_sz_cd", {ComboText:_eqSzComboListA, ComboCode:_eqSzComboListA} );
                sheetObj.SetCellEditable(row, "sheet1_cgo_tp_cd", 1);
                sheetObj.SetCellValue(row, "sheet1_eq_tp_cd","AL", 0);
                sheetObj.SetCellValue(row, "sheet1_eq_sz_cd","AL", 0);
            }
            else if(value == 'U')
            {
                sheetObj.CellComboItem(row,"sheet1_eq_tp_cd", {ComboText:_eqTpComboListU, ComboCode:_eqTpComboListU} );
                sheetObj.CellComboItem(row,"sheet1_eq_sz_cd", {ComboText:_eqSzComboListU, ComboCode:_eqSzComboListU} );
                sheetObj.SetCellEditable(row, "sheet1_cgo_tp_cd", 1);
            }
            else if(value == 'Z')
            {
                sheetObj.CellComboItem(row,"sheet1_eq_tp_cd", {ComboText:_eqTpComboListZ, ComboCode:_eqTpComboListZ} );
                sheetObj.CellComboItem(row,"sheet1_eq_sz_cd", {ComboText:_eqSzComboListZ, ComboCode:_eqSzComboListZ} );
                sheetObj.SetCellValue(row, "sheet1_cgo_tp_cd","", 0);
                sheetObj.SetCellEditable(row, "sheet1_cgo_tp_cd", 0);
                sheetObj.SetCellValue(row, "sheet1_bnd_cd","", 0);
                sheetObj.SetCellEditable(row, "sheet1_bnd_cd", 0);
            }
            else if(value == 'G')
            {
                sheetObj.CellComboItem(row,"sheet1_eq_tp_cd", {ComboText:_eqTpComboListG, ComboCode:_eqTpComboListG} );
                sheetObj.CellComboItem(row,"sheet1_eq_sz_cd", {ComboText:_eqSzComboListG, ComboCode:_eqSzComboListG} );
                sheetObj.SetCellValue(row, "sheet1_cgo_tp_cd","", 0);
                sheetObj.SetCellEditable(row, "sheet1_cgo_tp_cd", 0);
                sheetObj.SetCellValue(row, "sheet1_bnd_cd","", 0);
                sheetObj.SetCellEditable(row, "sheet1_bnd_cd", 0);
            }
            break;

        case "sheet1_cgo_tp_cd": 
            if(value == 'F')
            {
                sheetObj.SetCellValue(row, "sheet1_bnd_cd", sheetObj.GetCellValue(row, "sheet1_h_bnd_cd"), 0);
                sheetObj.SetCellEditable(row, "sheet1_bnd_cd", 1);
                //sheetObj.SetCellValue(row, "sheet1_rnd_rt", sheetObj.GetCellValue(row, "sheet1_h_rnd_rt"), 0);
                //sheetObj.SetCellEditable(row, "sheet1_rnd_rt", 1);
            }
            else
            {
                sheetObj.SetCellValue(row, "sheet1_bnd_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_bnd_cd", 0);
                //sheetObj.SetCellValue(row, "sheet1_rnd_rt", "", 0);
                //sheetObj.SetCellEditable(row, "sheet1_rnd_rt", 0);
            }
            break;

        case "sheet1_bnd_cd": 
            if(value == '')
            {
                sheetObj.SetCellValue(row, "sheet1_cgo_tp_cd", "", 0);
            }
            else if(value == 'I' || value == 'O')
            {
                sheetObj.SetCellValue(row, "sheet1_cgo_tp_cd", "F", 0);
            }
            break;

        case "sheet1_rt_tp_cd": 
            if(value == 'R')
            {
                sheetObj.SetCellValue(row, "sheet1_curr_cd", "", 0);
                sheetObj.SetCellEditable(row, "sheet1_curr_cd", 0);
            }
            else
            {
                sheetObj.SetCellValue(row, "sheet1_curr_cd", sheetObj.GetCellValue(row, "sheet1_h_curr_cd"), 0);
                sheetObj.SetCellEditable(row, "sheet1_curr_cd", 1);
            }
            break;
    }
}

/**
  * Rate handle events that occur after deleting
  */
function sheet0_OnSaveEnd(sheetObj, errMsg)
{
    if( errMsg.length > 0 )
    {
        ComShowMessage(errMsg);
    }
    else
    {
        if( document.form.f_cmd.value == MULTI01 || document.form.f_cmd.value == REMOVE01 )
        {
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
        }
    }
}


////////////////////////////////////////////////
// LCC, SCC POPUP BEGIN
////////////////////////////////////////////////

// Multi
function sheet0_OnPopupClick(sheetObj, row, col)
{
    with(sheetObj)
    {
        var formObj = document.form;
        var colNm = ColSaveName(col);

        switch (colNm)
        {
            case "sheet1_lcc_cd":
                var dispaly = "0,0";
                var classId = "ESD_TRS_0980";
                var sheet = "0";
                var param = "";
                var rtnFnc = "";
                param = '?sheet='+sheet+'&classId='+classId+'&main_page=false';
                ComOpenPopup('ESD_TRS_0980.do' + param, 600, 425, "locCodeHelp", dispaly, true, false, row, col);
            break;

            case "sheet1_scc_cd":
                var dispaly = "0,0";
                var classId = "ESD_TRS_0980";
                var sheet = "0";
                var param = "";
                var rtnFnc = "";
                param = '?sheet='+sheet+'&classId='+classId+'&main_page=false';
                ComOpenPopup('ESD_TRS_0980.do' + param, 600, 425, "locCodeHelp1", dispaly, true, false, row, col);
            break;
        }
    }
}

function locCodeHelp(rowArray, row, col)
{
    var colArray=rowArray[0];
    var sheetObj=sheetObjects[0];
    sheetObj.SetCellValue(row, col, colArray[4], 0);

    if(sheetObj.GetCellValue(row, "sheet1_lcc_cd") != "")
    {
        sheetObj.SetCellValue(row, "sheet1_rcc_cd", "", 0);
        sheetObj.SetCellEditable(row, "sheet1_rcc_cd", 0);
        sheetObj.SetCellValue(row, "sheet1_scc_cd", "", 0);
        sheetObj.SetCellEditable(row, "sheet1_scc_cd", 0);
        sheetObj.SetCellValue(row, 'sheet1_chk',   1, 0);
        sheetObj.SetCellValue(row, 'sheet1_ck_vf', 1, 0);
    }
    else if(sheetObj.GetCellValue(row, "sheet1_scc_cd") != "")
    {
        sheetObj.SetCellValue(row, "sheet1_rcc_cd", "", 0);
        sheetObj.SetCellEditable(row, "sheet1_rcc_cd", 0);
        sheetObj.SetCellValue(row, "sheet1_lcc_cd", "", 0);
        sheetObj.SetCellEditable(row, "sheet1_lcc_cd", 0);
        sheetObj.SetCellValue(row, 'sheet1_chk',   1, 0);
        sheetObj.SetCellValue(row, 'sheet1_ck_vf', 1, 0);
    }
}

function locCodeHelp1(rowArray, row, col)
{
    var colArray=rowArray[0];
    var sheetObj=sheetObjects[0];
    sheetObj.SetCellValue(row, col, colArray[3], 0);

    if(sheetObj.GetCellValue(row, "sheet1_lcc_cd") != "")
    {
        sheetObj.SetCellValue(row, "sheet1_rcc_cd", "", 0);
        sheetObj.SetCellEditable(row, "sheet1_rcc_cd", 0);
        sheetObj.SetCellValue(row, "sheet1_scc_cd", "", 0);
        sheetObj.SetCellEditable(row, "sheet1_scc_cd", 0);
        sheetObj.SetCellValue(row, 'sheet1_chk',   1, 0);
        sheetObj.SetCellValue(row, 'sheet1_ck_vf', 1, 0);
    }
    else if(sheetObj.GetCellValue(row, "sheet1_scc_cd") != "")
    {
        sheetObj.SetCellValue(row, "sheet1_rcc_cd", "", 0);
        sheetObj.SetCellEditable(row, "sheet1_rcc_cd", 0);
        sheetObj.SetCellValue(row, "sheet1_lcc_cd", "", 0);
        sheetObj.SetCellEditable(row, "sheet1_lcc_cd", 0);
        sheetObj.SetCellValue(row, 'sheet1_chk',   1, 0);
        sheetObj.SetCellValue(row, 'sheet1_ck_vf', 1, 0);
    }
}

// Single
function openRccPopUp(param)
{
    var dispaly = "0,0";
    var helpFunc;
    if(param == 'LCC')
    {
        helpFunc = 'locCodeHelp2';
    }
    else if(param == 'SCC')
    {
        helpFunc = 'locCodeHelp3';
    }
    ComOpenPopup('/opuscntr/ESD_TRS_0980.do?main_page=false', 600, 425, helpFunc, dispaly, true);
}

// LCC
function locCodeHelp2(rowArray)
{
    var formObject = document.form;
    var colArray = rowArray[0];
    document.form.lcc_cd.value = colArray[4];
}

// SCC
function locCodeHelp3(rowArray)
{
    var formObject = document.form;
    var colArray = rowArray[0];
    document.form.scc_cd.value = colArray[3];
}

////////////////////////////////////////////////
//LCC, SCC POPUP END
////////////////////////////////////////////////


/**
  * And passed out on the grid data is deleted.
  */
function eq_delete(fromSheet, sStatus)
{
    var fromRow = 0;
    var sRow = fromSheet.FindCheckedRow(sStatus);
    var arrRow = sRow.split("|");
    //for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--)
    for (var ir = arrRow.length-1; ir >=0 ; ir--)
    {
        fromRow = arrRow[ir];
        if(fromSheet.GetCellValue(fromRow, "sheet1_com_scg_seq") == "")
        {
            fromSheet.RowDelete(fromRow, false);
        }
    }
}

/**
  * Sheet expand / collapse
  */
function Minimize(nItem)
{
    var objs = document.all.item("MiniLayer");
    if( nItem == "1" )
    {
        objs.style.display = "none";
        sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(22);
    }
    else
    {
        objs.style.display = "inline";
        sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(16);
    }
}

/**
* Container Reset screen
*/
function reset_all()
{
    var formObject                      = document.form;
    document.getElementById("eff_dt").className="input2";
    formObject.dt_all.checked           = true;
    formObject.eff_dt.disabled          = true;
    formObject.eff_dt.value             = "";
    formObject.btns_calendar.disabled   = true;
    formObject.com_scg_knd_cd.value     = "ALL";
    formObject.rcc_cd.value             = "ALL";
    formObject.lcc_cd.value             = "";
    formObject.scc_cd.value             = "";
    formObject.btns_radio_eq[0].checked = true;
    formObject.eq_knd_cd.value          = "";
    change_eq_tp_sz(0);
    formObject.cgo_tp_cd.value          = "ALL";
    formObject.bnd_cd.value             = "ALL";
    formObject.eq_tp_cd.value           = "AL";
    formObject.eq_sz_cd.value           = "AL";

    sheet0.RemoveEtcData();
    sheet0.RemoveAll();
}

/**
* Lookups required validation
*/
function validateFormSearch()
{
    var formObj = document.form;
    var eff_dt = formObj.eff_dt.value;

    if(formObj.dt_eff.checked == true && eff_dt == "")
    { 
        ComShowCodeMessage("TRS90410", "Effective Date");
        formObj.eff_dt.focus();
        return false;
    }
    return true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
     switch (sAction) {
        case SEARCH01:
            break;
        case IBSAVE:
            for (i=1; i<=sheetObj.LastRow(); i++) {
                if(sheetObj.GetCellValue(i, "sheet1_com_scg_knd_cd") == "") {
                    ComShowCodeMessage("TRS90410", "Surcharge Kind");
                    sheetObj.SelectCell(i, "sheet1_com_scg_knd_cd");
                    return false;
                }
                if(sheetObj.GetCellValue(i, "sheet1_trsp_cost_mod_cd") == "") {
                    ComShowCodeMessage("TRS90410", "Cost Mode");
                    sheetObj.SelectCell(i, "sheet1_trsp_cost_mod_cd");
                    return false;
                }
                if(sheetObj.GetCellValue(i, "sheet1_agmt_trsp_tp_cd") == "") {
                    ComShowCodeMessage("TRS90410", "Trans Mode");
                    sheetObj.SelectCell(i, "sheet1_agmt_trsp_tp_cd");
                    return false;
                }
                if(sheetObj.GetCellValue(i, "sheet1_rcc_cd") == "" && sheetObj.GetCellValue(i, "sheet1_lcc_cd") == "" && sheetObj.GetCellValue(i, "sheet1_scc_cd") == "") {
                    ComShowCodeMessage("TRS90410", "Either of Geography Hierarchy(RCC or LCC or SCC)");
                    sheetObj.SelectCell(i, "sheet1_rcc_cd");
                    return false;
                }
//                if(sheetObj.GetCellValue(i, "eq_knd_cd") == "U" && sheetObj.GetCellValue(i, "cgo_tp_cd") == "")
//                {
//                    ComShowCodeMessage("TRS90410", "Cargo");
//                    sheetObj.SelectCell(i, "cgo_tp_cd");
//                    return false;
//                }
//                if(
//                   (sheetObj.GetCellValue(i, "com_scg_knd_cd") == "SCFAAL"
//                 || sheetObj.GetCellValue(i, "com_scg_knd_cd") == 'SCFCAL')
//                 && sheetObj.GetCellValue(i, "rt_tp_cd") == ""
//                  )
//                {
//                    ComShowCodeMessage("TRS90410", "Rate Type");
//                    sheetObj.SelectCell(i, "rt_tp_cd");
//                    return false;
//                }
                if(sheetObj.GetCellValue(i, "sheet1_rt_tp_cd") == "") {
                    ComShowCodeMessage("TRS90410", "Rate Type");
                    sheetObj.SelectCell(i, "sheet1_rt_tp_cd");
                    return false;
                }
                if(sheetObj.GetCellValue(i, "sheet1_rt_tp_cd") == "F" && sheetObj.GetCellValue(i, "sheet1_curr_cd") == "") {
                    ComShowCodeMessage("TRS90410", "Currency");
                    sheetObj.SelectCell(i, "sheet1_curr_cd");
                    return false;
                }
                if(sheetObj.GetCellValue(i, "sheet1_rt_tp_cd") == "F" && sheetObj.GetCellValue(i, "sheet1_one_wy_rt") == "" && sheetObj.GetCellValue(i, "sheet1_rnd_rt") == "") {
                    ComShowCodeMessage("TRS90410", "Rate(CY Rate or DR Rate)");
                    sheetObj.SelectCell(i, "sheet1_one_wy_rt");
                    return false;
                }
//                if(sheetObj.GetCellValue(i, "rt_tp_cd") == "F" && sheetObj.GetCellValue(i, "trsp_cost_mod_cd") == "CY" && sheetObj.GetCellValue(i, "one_wy_rt") == "")
//                {
//                    ComShowCodeMessage("TRS90410", "CY Rate");
//                    sheetObj.SelectCell(i, "one_wy_rt");
//                    return false;
//                }
//                if(sheetObj.GetCellValue(i, "rt_tp_cd") == "F" && sheetObj.GetCellValue(i, "trsp_cost_mod_cd") == "DR" && sheetObj.GetCellValue(i, "rnd_rt") == "")
//                {
//                    ComShowCodeMessage("TRS90410", "DR Rate");
//                    sheetObj.SelectCell(i, "rnd_rt");
//                    return false;
//                }
                if(sheetObj.GetCellValue(i, "sheet1_eff_fm_dt") == "") {
                    ComShowCodeMessage("TRS90410", "Effective From Date");
                    sheetObj.SelectCell(i, "sheet1_eff_fm_dt");
                    return false;
                }
                if(sheetObj.GetCellValue(i, "sheet1_eff_to_dt") == "") {
                    ComShowCodeMessage("TRS90410", "Effective To Date");
                    sheetObj.SelectCell(i, "sheet1_eff_to_dt");
                    return false;
                }
            }
            
            var dupRow = sheetObj.ColValueDup("sheet1_com_scg_knd_cd|sheet1_trsp_cost_mod_cd|sheet1_agmt_trsp_tp_cd|sheet1_rcc_cd|sheet1_lcc_cd|sheet1_scc_cd|sheet1_eq_knd_cd|sheet1_eq_tp_cd|sheet1_eq_sz_cd|sheet1_cgo_tp_cd|sheet1_bnd_cd|sheet1_eff_fm_dt|sheet1_eff_to_dt");
            var dupRow2 = dupRow - 1;
            if(dupRow != -1) {
                ComShowCodeMessage("TRS90412", "row " + dupRow2);
                sheetObj.SetSelectRow(dupRow);
                return false;
            }

            var dupKey = "sheet1_com_scg_knd_cd|sheet1_trsp_cost_mod_cd|sheet1_agmt_trsp_tp_cd|sheet1_rcc_cd|sheet1_lcc_cd|sheet1_scc_cd|sheet1_eq_knd_cd|sheet1_eq_tp_cd|sheet1_eq_sz_cd|sheet1_cgo_tp_cd|sheet1_bnd_cd";
            var effedctiveDateCheck = checkEffectiveDate(sheetObj, dupKey);
            if(!effedctiveDateCheck) {
            	ComShowMessage("Effective Date Duplication.")
                ComOpenWait(false);
                return;
            }

            break;
        case IBDELETE:
            break;
     }
    return true;
}

/**
 * EffectiveDate Duplicate Check
 * @param sheetObj
 * @param dupKey
 * @returns {Boolean}
 */
function checkEffectiveDate(sheetObj, dupKey) {
    var checkList = sheetObj.FindCheckedRow('sheet1_chk');
    var checkArray = checkList.split('|');
    var effedctiveDateCheck = true;
    for(var idx = 0; idx < checkArray.length; idx++) {
        var dateCheck = true;
        for(var rw = 2; rw < sheetObj.RowCount() + 2; rw++) {
            if(checkArray[idx] != rw) {
                var dupCheck = true;
                var dupKeyArray = dupKey.split("|");
                for(var kk =0; kk < dupKeyArray.length; kk++) {
                    if(sheetObj.GetCellValue(checkArray[idx], dupKeyArray[kk]) != sheetObj.GetCellValue(rw, dupKeyArray[kk])) {
                        dupCheck = false;
                        break;
                    }
                }

                if(dupCheck) {
                    var checkedEffFmDt = sheetObj.GetCellValue(checkArray[idx], "sheet1_eff_fm_dt");
                    var checkedEffToDt = sheetObj.GetCellValue(checkArray[idx], "sheet1_eff_to_dt");

                    var sheetRowEffFmDt = sheetObj.GetCellValue(rw, "sheet1_eff_fm_dt");
                    var sheetRowEffToDt = sheetObj.GetCellValue(rw, "sheet1_eff_to_dt");
                    if((sheetRowEffFmDt <= checkedEffFmDt && checkedEffFmDt <= sheetRowEffToDt) ||
               		   (sheetRowEffFmDt <= checkedEffToDt && checkedEffToDt <= sheetRowEffToDt) ||
               		   (sheetRowEffFmDt >= checkedEffFmDt && checkedEffToDt >= sheetRowEffToDt)    ) {
                        dateCheck = false;
                        break;
                    }
                }
            }
        }

        if(!dateCheck) {
            effedctiveDateCheck = false;
        }
    }
    return effedctiveDateCheck;
}

/**
 * Effective Date 검색조건을 변경하는 Function
 * 
 * @param obj
 */
function fun_dateChange(obj) {
	sheetObjects[0].RemoveAll();
	if( obj == "ALL" ) {
		document.form.eff_dt.disabled=true;
		document.form.eff_dt.value="";
		document.form.btns_calendar.disabled=true;
		document.getElementById("eff_dt").className="input2";
	} else {
		document.form.eff_dt.disabled=false;
		document.form.eff_dt.value=document.form.hid_today.value;
		document.form.btns_calendar.disabled=false;
		document.getElementById("eff_dt").className="input1";
	}
}

// UI 표준화관련 하단 여백 설정
function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}
