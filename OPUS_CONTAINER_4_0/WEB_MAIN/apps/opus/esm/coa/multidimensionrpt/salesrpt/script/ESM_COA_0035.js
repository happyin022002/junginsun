/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0035.js
*@FileTitle  : Inquiry by Source Data
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var sheet_selno=""; //Selected sheet
var RPTForm_Acct="ACCT"; //Account
var RPTForm_TpSz="TPSZ"; //Type Size
var sheet_height_in  = 237;  	//SJH.20141127.MOD
var sheet_height_out = 450; 	//SJH.20141127.MOD
var TmrID;

/* Event handler processing by button click event */
document.onclick=processButtonClick; 

/* Event handler processing by button name */
function processButtonClick() {
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_retrieve":
                if (sheet_selno == RPTForm_Acct) { //The 1st sheet
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                } else if (sheet_selno == RPTForm_TpSz) { //The 2nd sheet
                    doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
                }
                break;
            case "btn_downexcel":
                if (sheet_selno == RPTForm_Acct) {        //The 1st sheet
                    if(sheetObject1.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                        break;
                    }else{
                        doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                    }
                } else if (sheet_selno == RPTForm_TpSz) { //The 2nd sheet
                    if(sheetObject2.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                        break;
                    }else{
                        doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
                    }
                }
                break;
            case "btn_filedownload":
                if (sheet_selno == RPTForm_Acct) {        //The 1st sheet
                    doActionIBSheet(sheetObject1,formObject,IBCREATE);
                } else if (sheet_selno == RPTForm_TpSz) { //The 2nd sheet
                    doActionIBSheet2(sheetObject2,formObject,IBCREATE);
                }
                break;
            //SJH.20141127.MOD
            case "bu_zoom_in1": //next
            case "bu_zoom_in2":
                if (sheet_selno == RPTForm_Acct) { //The 1st sheet
                	if(sheetObject1.RowCount()>9) 
                		sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, sheetObject1.LastRow()+4));
                	 else 
                		sheetObject1.SetSheetHeight(sheet_height_out);                	
                    div_zoom_in1.style.display="none";
                    div_zoom_out1.style.display="inline"; 
                } else if (sheet_selno == RPTForm_TpSz) { //The 2nd sheet
                	if(sheetObject2.RowCount()>9)
                		sheetObject2.SetSheetHeight(ComGetSheetHeight(sheetObject1, sheetObject1.LastRow()+4));
                	else 
                		sheetObject2.SetSheetHeight(sheet_height_out);                   	
                	sheetObject2.SetSheetHeight(sheet_height_out);
            		div_zoom_in2.style.display="none";
            		div_zoom_out2.style.display="inline";   
                }
                break;
            case "bu_zoom_out1": //next
            case "bu_zoom_out2":
                if (sheet_selno == RPTForm_Acct) { //The 1st sheet
                	sheetObject1.SetSheetHeight(sheet_height_in);                	
                    div_zoom_in1.style.display="inline";
                    div_zoom_out1.style.display="none";
                } else if (sheet_selno == RPTForm_TpSz) { //The 2nd sheet
                	sheetObject2.SetSheetHeight(sheet_height_in);         
                	div_zoom_in2.style.display="inline";
                	div_zoom_out2.style.display="none";
                }
                break;
        } // end switch
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
    var formObject=document.form;
    loadingMode=true; 
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    // handling multi-combo object (시작) ---------------------------------------------
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k], k+1);
    }
    
    //SJH.20141027 MOD : CM default, Enable false
    f_pro_vw.SetEnable(0);
    f_pro_lvl.SetEnable(0);
    f_pro_lvl.SetSelectCode("C", false);
    f_type_cd.SetSelectCode("A", true);		//SJH.20141111.ADD      
    
    // handling multi-combo object (종료) ---------------------------------------------
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    sheet_hidden(sheetObjects[0]);			//SJH.20141112.ADD	  
    document.getElementById("tabLayer2").style.display="none"; // tabLayer2.style.display="none";
    RPTForm_Acct="ACCT";
    RPTForm_TpSz="TPSZ";
    sheet_selno=RPTForm_Acct; //Selected sheet (1st sheet)
    loadingMode=false;
}    
/**
 * Multi-combo handling
* initializing Tab
* setting Tab items
 */
function initCombo (comboObj, comboNo) {
     with (comboObj) {
        SetDropHeight(200);
        SetSelectIndex(0);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
    }
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj, sheetNo) {
var formObj=document.form;
var tpsz="";
var tpsz_cnt=0;
var rev_head="";
var load_hade="";
var cm_cost_hade_a="";	//SJH.20141112.ADD,MOD
var cm_cost_hade_b="";
var op_cost_hade="";
var cm_hade_a="";		//SJH.20141112.ADD,MOD
var cm_hade_b="";
var op_hade="";
var tmp_cnt=0;
var fix_cnt=0;
var var_cnt=0;
var HeadTitle="";
var n=0;   
switch(sheetNo) {
    case 1:      //sheet1 init
        if (strTpsz == "") {
            head1="|AAA|BBB|CCC|DDD|EEE|FFF";
            head2="|AAA|BBB|CCC|DDD|EEE|FFF";
        }
        fix_cnt=75;
        tpsz=strTpsz.replace(/(^\s*)/g, '').split("|");
        tpsz_cnt=tpsz.length;
        for(j=1; j<tpsz_cnt; j++){
            rev_head=rev_head  + "|FR_REV_" + tpsz[j];
            load_hade=load_hade + "|LOAD_"   + tpsz[j];
        }
        with(sheetObj){
            HeadTitle="SEQ|R.MONTH|S.MONTH|WEEK|BKG NO|1ST SAILING DATE|BL NO|BL TYPE|TYPE/SIZE|SERVICE SCOPE|TRADE|SUB TRADE|R.LANE|IOC|REV VVD|DIR"	//SJH.20141215.ADD : 1ST SAILING DATE, BL TYPE, SERVICE SCOPE, SUB TRADE
            + "|C.RHQ|C.AD|C.OFC|C.S.REP|L.RHQ|L.AD|L.OFC|L.REP|BKG OFC|BKG STS|USA MODE|POR|1ST POL|LAST POD|DEL"							//SJH.20141215.MOD : POR|1ST POL|LAST POD|DEL
            + "|RCV TERM|DEL TERM|REP CMDT CD|REP CMDT DESC|CMDT CD|CMDT DESC|TRADE1|TRADE2|TRADE3|TRADE4"
            + "|LANE1|LANE2|LANE3|LANE4|VVD1|VVD2|VVD3|VVD4|POL1|POL2|POL3|POL4|POD1|POD2|POD3|POD4"
            + "|TRUNK POL|TRUNK POD|LAST VVD|LAST TRADE|LAST LANE|EMPTY PICK UP|EMPTY RETURN"												//SJH.20141215.ADD
            + "|SC NO|RFA No|TAA NO|NVOCC|SC/RFA CUST TP|SC/RFA CUST CD|SC/RFA CUST NM|SC/RFA GROUP CUST NM|SC/RFA CUST NEED BASE SEG. CLASS 1|SC/RFA CUST NEED BASE SEG. CLASS 2|SC/RFA CUST NEED BASE SEG. CLASS 3|SC/RFA CUST KEY ACCOUNT FLAG|BKG SHPR CD|BKG SHPR NM"								//SJH.20141215.ADD : TAA NO, CUST TP->SC/RFA CUST TP
            + "|B/L SHPR TP|B/L SHPR NM|CNEE CD|CNEE NM|NOTIFY CD|NOTIFY NM|PRD CCT"
            //SJH.20141215.ADD : AUTO RATING DATE|CARGO WEIGHT|TARE WEIGHT|CARGO WEGHT UNIT|TARE WEIGHT UNIT|QUANTITY|TEU|FR_REV
            + "|BL ON BOARD DT|CGO RCV DT|SOC|REV MT|DG|RF|BB|AK|AUTO RATING DATE|CARGO WEIGHT|TARE WEIGHT|CARGO WEGHT UNIT|TARE WEIGHT UNIT|QUANTITY|TEU|FR_REV"
            if (ComGetObjValue(formObj.f_pro_vw) == "P" && ComGetObjValue(formObj.f_pro_lvl) == "O") {
                var_cnt=40;	//SJH.20141111.MOD
                HeadTitle=HeadTitle
                //+ rev_head																												//SJH.20141215.DEL
                //+ "|FR_REV_TTL|MISC_REV_TTL|REV_TTL"																						//SJH.20141215.DEL
                + "|MISC_REV_TTL|REV_TTL"																									//SJH.20141215.ADD
                //+ load_hade																												//SJH.20141215.DEL
                //+ "|LOAD_TTL(TEU)"																										//SJH.20141215.DEL
                //+ "|Freight Revenue|Misc Operation Revenue|CNTR DEM/DET|Basic Stevedorage|Other CY Expense|T/S Stevedorage|On Dock CY Expense|Cargo Handling Expense|Storage|Misc Cargo Handling Expense|Exclusive Terminal Additional Cost|Cargo Variable Volume Discount|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"
                //SJH.20141217.ADD
                + "|CNTR DEM/DET|OB Basic Stevedorage|IB Basic Stevedorage|OB On Dock CY Expense|OB Cargo Handling Expense|OB Storage|OB Misc Cargo Handling Expense|IB On Dock CY Expense|IB Cargo Handling Expense|IB Storage|IB Misc Cargo Handling Expense"
                + "|TS Stevedorage|TS Other Cy Expense|TS On Dock Cy Expense|TS Cargo Handling Expense|TS Storage|Cargo Variable Volume Discount"
                + "|OB Rail Truck|OB Rail Direct|OB Truck Direct|OB Water Direct|OB Water Rail|OB Water Truck|OB Other Transport Expense"
                + "|IB Rail Truck|IB Rail Direct|IB Truck Direct|IB Water Direct|IB Water Rail|IB Water Truck|IB Other Transport Expense"
                + "|TS Full Transport Expense|TS Other Transport Expense|OB Empty Repositioning Cost A|IB Empty Repositioning Cost A|OB Empty Repositioning Cost B|IB Empty Repositioning Cost B"
                + "|OB Agency Commission|IB Agency Commsision|T/S Agency Commission|FAC A/C|CHF Commission|Other Commission"
                //+ "|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"			//SJH.20141217.DEL
                //SJH.20141111.MOD : Empty Terminal Expense - > Empty Reposition Expense, CM Cost Total, CM Total Type A/B, SJH.20141217.DEL
                //+ "|Empty Reposition Expense(EPP A)|Empty Reposition Expense(EPP B)|Agent Commission|Slot Internal Pricing"
                + "|Slot Internal Pricing|Mnr Cost|Reefer Cost|Chassis Cost"
                //+ "|CM Cost Total(EPP A)|CM Total(EPP A)|CM Cost Total(EPP B)|CM Total(EPP B)"
                + "|Variable Cost Total A|CM Total A|Variable Cost Total B|CM Total B"
                + "|CNTR Long Term EQ Rental|CNTR Short Term EQ Rental|CNTR M&R Charge|CNTR Depreciation|CNTR Insurance"
                + "|Chassis Short Term EQ Rental|Chassis Long Term EQ Rental|Chassis M&R Charge|Chassis Depreciation|Chassis Drayage|Chassis Insurance"
            }else if (ComGetObjValue(formObj.f_pro_vw) == "P" && ComGetObjValue(formObj.f_pro_lvl) == "C") {
                var_cnt=27;
                HeadTitle=HeadTitle
                //+ rev_head																												//SJH.20141215.DEL
                //+ "|FR_REV_TTL|MISC_REV_TTL|REV_TTL"																						//SJH.20141215.DEL
                + "|MISC_REV_TTL|REV_TTL"																									//SJH.20141215.ADD
                //+ load_hade																												//SJH.20141215.DEL
                //+ "|LOAD_TTL(TEU)"																										//SJH.20141215.DEL
                //+ "|Freight Revenue|Misc Operation Revenue|Basic Stevedorage|Other CY Expense|T/S Stevedorage|On Dock CY Expense|Cargo Handling Expense|Storage|Misc Cargo Handling Expense|Exclusive Terminal Additional Cost|Cargo Variable Volume Discount|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"
                //SJH.20141217.ADD
                + "|OB Basic Stevedorage|IB Basic Stevedorage|OB On Dock CY Expense|OB Cargo Handling Expense|OB Storage|OB Misc Cargo Handling Expense|IB On Dock CY Expense|IB Cargo Handling Expense|IB Storage|IB Misc Cargo Handling Expense"
                + "|TS Stevedorage|TS Other Cy Expense|TS On Dock Cy Expense|TS Cargo Handling Expense|TS Storage|Cargo Variable Volume Discount"
                + "|OB Rail Truck|OB Rail Direct|OB Truck Direct|OB Water Direct|OB Water Rail|OB Water Truck|OB Other Transport Expense"
                + "|IB Rail Truck|IB Rail Direct|IB Truck Direct|IB Water Direct|IB Water Rail|IB Water Truck|IB Other Transport Expense"
                + "|TS Full Transport Expense|TS Other Transport Expense|OB Empty Repositioning Cost A|IB Empty Repositioning Cost A|OB Empty Repositioning Cost B|IB Empty Repositioning Cost B"
                + "|OB Agency Commission|IB Agency Commsision|T/S Agency Commission|FAC A/C|CHF Commission|Other Commission"
                //+ "|Rail Direct|Rail Truck|Truck Direct|Water Direct|Water Rail|Water Truck|Other Transport Expense"			//SJH.20141217.DEL
                //SJH.20141111.MOD : Empty Terminal Expense - > Empty Reposition Expense, CM Cost Total, CM Total Type A/B, SJH.20141217.DEL
                //+ "|Empty Reposition Expense(EPP A)|Empty Reposition Expense(EPP B)|Agent Commission|Slot Internal Pricing"	
                + "|Slot Internal Pricing|Mnr Cost|Reefer Cost|Chassis Cost"
                //+ "|CM Cost Total(EPP A)|CM Total(EPP A)|CM Cost Total(EPP B)|CM Total(EPP B)"
                + "|Variable Cost Total A|CM Total A|Variable Cost Total B|CM Total B"
            }
          
            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:5, DataRowMerge:0 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Seq",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : 1ST SAILING DATE
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },                        
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : BL TYPE, TYPE/SIZE
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : SERVICE SCOPE
                        {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : SUB TRADE
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : TRUNK POL ~ EMPTY RETURN : START
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : TRUNK POL ~ EMPTY RETURN : END
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : TAA NO
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141218.ADD : SC/RFA GROUP CUST NM ~ SC/RFA CUST KEY ACCOUNT FLAG
                        {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141111.ADD : RC
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : AUTO RATING DATE
                        {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"AutoSum",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : TARE WEIGHT
                        {Type:"AutoSum",   Hidden:0,  Width:95,   Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141215.ADD : TARE WEIGHT UNIT ~ FR_REV
                        {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"fr_rev",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 }];
            
            // FR_REV variable
//SJH.20141215.DEL
//            for(j=1; j<tpsz_cnt; j++){
//                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"fr_rev_"+tpsz[j], KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1});
//            }
//            cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"fr_rev_tot",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"misc_rev_tot",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"rev_tot",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            
            // LOAD variable
//SJH.20141215.DEL       
//            for(j=1; j<tpsz_cnt; j++){
//                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"load_"+tpsz[j],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1});
//            }
//            cols.push({Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"load_tot",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
            
         // CM COST ACCOUNT -------------------------------------------------------------------------------------
            
//            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp01",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
//            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"tmp02",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            if (ComGetObjValue(formObj.f_pro_lvl) == "O"){
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp01",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            }
            //SJH.20141215.ADD : IB/OB BASIC STEVEDORAGE
            cols.push({Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"tmp02",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"tmp03",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            
            //--cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp05",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //--cols.push({Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"tmp06",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            
            //SJH.20141217.ADD : OB ON DOCK CY EXPENSE ~ IB MISC CARGO HANDLING EXPENSE
            cols.push({Type:"AutoSum",   Hidden:0, Width:160,  Align:"Right",   ColMerge:0,   SaveName:"tmp04",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:170,  Align:"Right",   ColMerge:0,   SaveName:"tmp05",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp06",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:200,  Align:"Right",   ColMerge:0,   SaveName:"tmp07",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp08",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp09",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp10",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:200,  Align:"Right",   ColMerge:0,   SaveName:"tmp11",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141217.ADD : TS STEVEDORAGE ~ TS STORAGE
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp12",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"tmp13",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:170,  Align:"Right",   ColMerge:0,   SaveName:"tmp14",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp15",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp16",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //cols.push({Type:"AutoSum",   Hidden:0, Width:210,  Align:"Right",   ColMerge:0,   SaveName:"tmp11",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //Cargo Variable Volume Discount
            cols.push({Type:"AutoSum",   Hidden:0, Width:200,  Align:"Right",   ColMerge:0,   SaveName:"tmp17",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141217.ADD : OB RAIL TRUCK ~ OB OTHER TRANSPORT EXPENSE
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp18",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp19",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp20",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp21",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp22",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp23",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp24",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141217.ADD : IB RAIL TRUCK ~ IB OTHER TRANSPORT EXPENSE
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp25",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp26",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp27",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp28",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp29",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp30",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp31",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141217.ADD : TS_FULL_TRSP_COM_AMT ~ IB_MTY_PA_AMT2
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp32",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp33",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:185,  Align:"Right",   ColMerge:0,   SaveName:"tmp34",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp35",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:185,  Align:"Right",   ColMerge:0,   SaveName:"tmp36",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:180,  Align:"Right",   ColMerge:0,   SaveName:"tmp37",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141217.ADD : OB Agency Commission ~ Other Commission
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"tmp38",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"tmp39",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"tmp40",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp41",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp42",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tmp43",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141217.DEL : Rail Direct ~ Other Transport Expense
            //SJH.20141217.DEL
//            if (ComGetObjValue(formObj.f_pro_vw) == "P"){
//            	//SJH.20141111.MOD : SIZE
//                cols.push({Type:"AutoSum",   Hidden:0, Width:220,  Align:"Right",   ColMerge:0,   SaveName:"tmp20",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
//                cols.push({Type:"AutoSum",   Hidden:0, Width:220,  Align:"Right",   ColMerge:0,   SaveName:"tmp21",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
//            }
//            cols.push({Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"tmp22",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141027.ADD : Slot Internal Pricing
            cols.push({Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:0,   SaveName:"tmp44",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141217.ADD
            cols.push({Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"tmp45",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"tmp46",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"tmp47",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            
            //Divide the cm-cost with the bkg-cm            
            //SJH.20141111.ADD.MOD
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"cm_cost_tot_a",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cm_a",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"cm_cost_tot_b",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cm_b",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            if(ComGetObjValue(formObj.f_pro_vw) == "P" && ComGetObjValue(formObj.f_pro_lvl) == "O"){
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cols.push({Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            }
            
            InitColumns(cols);
            
            //SJH.20141215.DEL
//            for(j=1; j<tpsz_cnt; j++){
//                SetCellBackColor(0, "fr_rev_"+tpsz[j] , "#FFF8FB") ;
//                SetCellFontColor(0, "fr_rev_"+tpsz[j],"#555555");
//                SetCellBackColor(0, "load_"+tpsz[j] , "#FFF8FB") ;
//                SetCellFontColor(0, "load_"+tpsz[j], "#555555");
//            }
//            SetCellBackColor(0,"fr_rev_tot","#FFD5D2");
//            SetCellFontColor(0,"fr_rev_tot","#555555");            
	        SetCellBackColor(0,"fr_rev", "#FFF8FB") ;				//SJH.20141215.ADD
	        SetCellFontColor(0,"fr_rev", "#555555");            
            SetCellBackColor(0,"misc_rev_tot","#FFD5D2");
            SetCellFontColor(0,"misc_rev_tot","#555555");
            SetCellBackColor(0,"rev_tot","#FFD5D2");
            SetCellFontColor(0,"rev_tot","#555555");
            SetCellBackColor(0,"load_tot","#FFD5D2");
            SetCellFontColor(0,"load_tot","#555555");
            for(z=1; z<=23; z++){
//            	if (z < 10) {
//                	SetCellBackColor(0, "tmp0"+z , "#E6FFFF") ;
//                    SetCellFontColor(0, "tmp0"+z, "#555555");  
//            	} else {
//                	SetCellBackColor(0, "tmp"+z , "#E6FFFF") ;
//                    SetCellFontColor(0, "tmp"+z, "#555555");            		
//            	}
            }            
            //SJH.20141111.ADD.MOD
            SetCellBackColor(0,"cm_cost_tot_a","#A7EEFF");
            SetCellFontColor(0,"cm_cost_tot_a","#555555");
            SetCellBackColor(0,"cm_a","#A7EEFF");
            SetCellFontColor(0,"cm_a","#555555");
            SetCellBackColor(0,"cm_cost_tot_b","#A7EEFF");
            SetCellFontColor(0,"cm_cost_tot_b","#555555");
            SetCellBackColor(0,"cm_b","#A7EEFF");
            SetCellFontColor(0,"cm_b","#555555");  
            SetCountPosition(0);
            
            SetEditable(0);
            SetHeaderRowHeight(20);
            SetSheetHeight(sheet_height_in);	//SJH.20141127.MOD
			resizeSheet();
        }
        break;
    case 2:      //sheet2 init
        if (strTpsz == "") {
            head1="|AAA|BBB|CCC|DDD|EEE|FFF";
            head2="|AAA|BBB|CCC|DDD|EEE|FFF";
        }
        fix_cnt=75;
        tpsz=strTpsz.replace(/(^\s*)/g, '').split("|");
        tpsz_cnt=tpsz.length;
        for(j=1; j<tpsz_cnt; j++){
            rev_head=rev_head  + "|FR_REV_" + tpsz[j];
            load_hade=load_hade + "|LOAD_"   + tpsz[j];
            //SJH.20141112.ADD,MOD
            cm_cost_hade_a=cm_cost_hade_a + "|CM_COST_" + tpsz[j] + "(EPP A)";
            cm_cost_hade_b=cm_cost_hade_b + "|CM_COST_" + tpsz[j] + "(EPP B)";
            op_cost_hade=op_cost_hade 	  + "|OP_COST_" + tpsz[j];
            op_hade=op_hade      		  + "|BKG_OP_"  + tpsz[j];
            //SJH.20141112.ADD,MOD
            cm_hade_a=cm_hade_a      	  + "|CM_"   	+ tpsz[j] + "(EPP A)";
            cm_hade_b=cm_hade_b      	  + "|CM_"   	+ tpsz[j] + "(EPP B)";
        }

        with(sheetObj){
            HeadTitle="SEQ|R.MONTH|S.MONTH|WEEK|BKG NO|BL NO|TRADE|R.LANE|IOC|REV VVD|DIR"
            + "|C.RHQ|C.AD|C.OFC|C.S.REP|L.RHQ|L.AD|L.OFC|L.REP|BKG OFC|BKG STS|USA MODE|BKG POR|BKG POL|BKG POD|BKG DEL"
            + "|RCV TERM|DEL TERM|REP CMDT CD|REP CMDT DESC|CMDT CD|CMDT DESC|TRADE1|TRADE2|TRADE3|TRADE4"
            + "|LANE1|LANE2|LANE3|LANE4|VVD1|VVD2|VVD3|VVD4|POL1|POL2|POL3|POL4|POD1|POD2|POD3|POD4"
            + "|SC NO|RFA No|NVOCC|CUST TP|SC CUST CD|SC CUST NM|BKG SHPR CD|BKG SHPR NM"
            + "|B/L SHPR TP|B/L SHPR NM|CNEE CD|CNEE NM|NOTIFY CD|NOTIFY NM|PRD CCT"
            + "|BL ON BOARD DT|CGO RCV DT|SOC|REV MT|RC|DG|BB|AK|WEIGHT|UNIT"	//SJH.20141112.ADD
            if (ComGetObjValue(formObj.f_pro_lvl) == "C" && ComGetObjValue(formObj.f_pro_vw) == "P" ) {
                var_cnt=(tpsz_cnt)*6 +8;	//SJH.20141112.MOD
                HeadTitle=HeadTitle
                + rev_head
                + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL" // + t_name6 MISC - remove
                + load_hade
                + "|LOAD_TTL(TEU)"
                //SJH.20141112.MOD
                + cm_cost_hade_a
                + "|CM Cost Total(EPP A)"
                + cm_hade_a
                + "|CM Total(EPP A)"
                //SJH.20141112.ADD
                + cm_cost_hade_b                
                + "|CM Cost Total(EPP B)"
                + cm_hade_b
                + "|CM Total(EPP B)"
            } else if (ComGetObjValue(formObj.f_pro_lvl) == "O" &&  ComGetObjValue(formObj.f_pro_vw) == "P") {
                var_cnt=(tpsz_cnt)*6 +8;
                HeadTitle=HeadTitle
                + rev_head
                + "|FR_REV_TTL|MISC_REV_TTL|REV_TTL" // + t_name6 MISC - remove
                + load_hade
                //SJH.20141112.MOD
                + "|LOAD_TTL(TEU)"
                + cm_cost_hade_a                
                + "|CM Cost Total(EPP A)"
                +  cm_hade_a
                + "|CM Total(EPP A)"
                //SJH.20141112.ADD
                + cm_cost_hade_b
                + "|CM Cost Total(EPP B)"                
                +  cm_hade_b                
                + "|CM Total(EPP B)"
            }

            cnt=0;
            
            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:5, DataRowMerge:0 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        //SJH.20141112.ADD : RC
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            for(j=1; j<tpsz_cnt; j++){
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"fr_rev_"+tpsz[n], KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1, BackColor:"#FFF8FB"});
                cnt++;
            }
            cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"fr_rev_tot",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"misc_rev_tot",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"rev_tot",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            for(j=1; j<tpsz_cnt; j++){
                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"load_"+tpsz[n],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1, BackColor:"#FFF8FB" });
                cnt++;
            }
            cols.push({Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"load_tot",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141112.MOD
            for(j=1; j<tpsz_cnt; j++){
                cols.push({Type:"AutoSum",   Hidden:0, Width:150,   Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1, BackColor:"#E6FFFF" });
                cnt++;
            }
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"cm_cost_tot_a",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1, BackColor:"#E6FFFF" });
            for(j=1; j<tpsz_cnt; j++){
                cols.push({Type:"AutoSum",   Hidden:0, Width:150,   Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cnt++;
            }
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"cm_a",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
            //SJH.20141112.ADD
            for(j=1; j<tpsz_cnt; j++){
                cols.push({Type:"AutoSum",   Hidden:0, Width:150,   Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1, BackColor:"#E6FFFF" });
                cnt++;
            }
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"cm_cost_tot_b",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1, BackColor:"#E6FFFF" });
            for(j=1; j<tpsz_cnt; j++){
                cols.push({Type:"AutoSum",   Hidden:0, Width:150,   Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
                cnt++;
            }
            cols.push({Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"cm_b",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 });            
            
            InitColumns(cols);
            
            SetEditable(0);
            SetCellBackColor(0,"fr_rev_tot","#FFD5D2");
            SetCellBackColor(0,"misc_rev_tot","#FFD5D2");
            SetCellBackColor(0,"rev_tot","#FFD5D2");
            SetCellBackColor(0,"load_tot","#FFD5D2");
            //SJH.20141112.ADD,MOD
            SetCellBackColor(0,"cm_cost_tot_a","#A7EEFF");
            SetCellBackColor(0,"cm_a","#C8FAC8");
            SetCellBackColor(0,"cm_cost_tot_b","#A7EEFF");
            SetCellBackColor(0,"cm_b","#C8FAC8");            
            SetCountPosition(0);
            SetHeaderRowHeight(20);
//            SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height2));
			resizeSheet();
        }
        break;
    }
}
/**
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Multi-combo handling
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * Change the period when the year, month, week is changed
 */
function setPeriod(obj) {
     ComCoaSetPeriod4(obj); 
}
/**
 * Display R.Lane by ifram
 */
function f_trd_cd_OnChange(obj) {
    if (loadingMode == true)
        return;
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
//    if (obj.GetSelectText()!= "") {					//20150602.MOD
        formObj.f_cmd.value=SEARCHLIST11;
        var sXml=sheetObj.GetSearchData("ESM_COA_0035GS2.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
            ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "code");
        f_rlane_cd.SetSelectIndex(0);
//    }
}
//SJH.20141112.ADD
function f_type_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
	 var sheetObj=sheetObjects[0];
     if (sheet_selno == RPTForm_Acct) sheetObj=sheetObjects[0];
     else if (sheet_selno == RPTForm_TpSz) sheetObj=sheetObjects[1];
	 sheet_hidden(sheetObj);		//SJH.20141112.ADD	 
}
/**
        * Handling RPT form of the window
 */
function rPTFormOnChange(obj) {
    var formObj=document.form;
    var flag=obj.value;  //1:Account, 2:TpSz
    if (flag == "ACCT") { //Account
        document.getElementById("tabLayer1").style.display="inline";
        document.getElementById("tabLayer2").style.display="none";
    } else if (flag == "TPSZ") { //Type size
        document.getElementById("tabLayer1").style.display="none";
        document.getElementById("tabLayer2").style.display="inline";
    }
    sheet_selno=(flag==null)?"ACCT":flag ;
    //parent.syncHeight();
	resizeSheet();
}
function f_ofc_lvl_OnChange(obj, code){
     if (loadingMode == true) return; 
     fOfcLvlOnChange(obj);
}
/**
 * Change office
 */ 
function fOfcLvlOnChange(obj){
     var formObj=document.form;
     var sheetObj=sheetObjects[0];
     if(obj.GetSelectText()!= ""){
        formObj.f_cmd.value=SEARCHLIST12;
        var sXml=sheetObj.GetSearchData("ESM_COA_0035GS2.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_ofc_cd, "code", "code");
        f_ofc_cd.SetSelectIndex(0);
     }
}
/**
        * Open the window
 * 
 */
function shipperPopUp(){
    var formObj=document.form;
    var param="";
    var tmp=formObj.txtShipper.value;
    formObj.f_cmd.value="";
    if(tmp.length == 0){
        param="?f_cust_cnt_cd=&f_cust_seq="
    }
    if(tmp.length >0 && tmp.length< 3){
        param="?f_cust_cnt_cd=" + tmp +"&f_cust_seq="; 
    } else if(tmp.length>2) {
        param="?f_cust_cnt_cd=" + tmp.substring(0,2); 
        param=param + "&f_cust_seq=" + tmp.substring(2); 
    }
    ComOpenWindow('ESM_COA_0144.do' + param, 'Shipper Pop', 'width=600,height=460,menubar=0,status=1,scrollbars=0,resizable=0');
}
/**
 * Open a popup about SC_NO and RFA_NO
 * 20150806.MOD
 */
function comPopupLoc(flag, value) {
    display="1,0,1,1,1,1,1,1";
    var cont_tp="";
    var cont_no="";
    if(value != ""){
        cont_tp=value.substring(0,3);
        cont_no=value.substring(3);
    }
    var param="?cont_tp="+cont_tp+"&cont_no="+cont_no+"&flag="+flag;
    if(flag == 1){
        var targetFun="getCOM_ENS_021_1";
    }
    ComOpenPopup('/opuscntr/COM_ENS_021.do' + param, 780, 480, targetFun, display, true);    // radio PopUp
}
/**
 * Setting RFA_NO
 */
function getComEns021_2(rowArray) {
    var colArray=rowArray[0];
    document.form.f_rfa_no.value=colArray[2];
}    
/*
 * Getting a list of the ofc_cd in case of changing on year and month values
 */
function changeCostYrmon(val){
    if(val != '') fOfcLvlOnChange(f_ofc_lvl);
}
//changeCostYrmon
// Handling processes about the Sheet1_Account
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
    		//SJH.20150102.ADD
			formObj.f_yearM.value=ComGetNowInfo("yy");								
			formObj.f_year.value=ComGetNowInfo("yy");   
            formObj.f_mon.value=ComGetNowInfo("mm").lpad(2, "0");
            
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            var sXml=document.form.sXml.value; 
            var arrXml=sXml.split("|$$|");
            if (ComGetEtcData(arrXml[0], "ofc_cd") == undefined){
                ComShowMessage(OBJECT_ERROR);
                ComOpenWait(false);
                return;
            }
            formObj.f_usr_ofc_cd.value=ComGetEtcData(arrXml[0], "ofc_cd"); 
            formObj.f_usr_ofc_lvl.value=ComGetEtcData(arrXml[0], "ofc_lvl"); 
            //SJH.20150102.ADD
            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY");
            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";
            
            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], f_pro_vw, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], f_ofc_vw, "code", "name");
            if (arrXml.length > 2)
                ComXml2ComboItem(arrXml[2], f_pro_lvl, "code", "name");
            if (arrXml.length > 3)
                ComXml2ComboItem(arrXml[3], f_ofc_lvl, "code", "name");
            if (arrXml.length > 4)
                ComXml2ComboItem(arrXml[4], f_ofc_cd, "code", "code");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], f_trd_cd, "code", "code");
            if (arrXml.length > 6)
                ComXml2ComboItem(arrXml[6], f_rlane_cd, "code", "code");
            if (arrXml.length > 7)
                ComXml2ComboItem(arrXml[7], f_ioc_cd, "code", "code");
            if (arrXml.length > 8)
                ComXml2ComboItem(arrXml[8], f_dir_cd, "code", "code");
//            if (arrXml.length > 9)
//                ComXml2ComboItem(arrXml[9], f_rep_cmdt_cd, "code", "code|name");
            if (arrXml.length > 9)
                ComXml2ComboItem(arrXml[9], f_usa_bkg_mod_cd, "code", "code");
            //SJH.20141111.ADD : 나중 교체!!!!!!!!!!!!!!!!!!!!!!!
            /*if (arrXml.length > 11)
            ComXml2ComboItem(arrXml[11], f_type_cd, "code", "code");*/
	        f_type_cd.InsertItem(0, "All", "All");
	        f_type_cd.InsertItem(1, "EPP A", "A");
	        f_type_cd.InsertItem(2, "EPP B", "B");	                  
            document.form.sXml.value="";
            ComOpenWait(false);
            break;  
        case IBSEARCH:      //Inquiry
            if (!validateCond(formObj, sAction)) {
                return false;
            }
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST01;
	            formObj.f_excel.value="N";
	            formObj.f_shpr_cd.value=formObj.txtShipper.value;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0035GS.do", coaFormQueryString(formObj));
	            //sheetObj.RenderSheet(0);
	//            sheetObj.SetVisible(0);
	//            sheetObj.RemoveAll();
	//            sheetObj = sheetObj.Reset();
	            //ComConfigSheet(sheetObjects[0]);
	//            initSheet(sheetObj, 1);
	//            sheetObj.SetVisible(1);
	            //sheetObj.RenderSheet(1);
	            // SpeedOption for the performance before the LoadSearchXm 
	            //sheetObj.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOTRIM,NOCALC,NOTDTAG,NOCOMBO";
	            sheetObj.LoadSearchData(sXml,{Sync:0} );
	            ComOpenWait(false);
            }, 100);
            break;
        case IBCREATE:      // Validate File DownLoad
            if (!validateCond(formObj, sAction)) {
                return false;
            }
            //------------------------------- 
            // Create a data by async
            //------------------------------- 
            formObj.f_cmd.value=MULTI01;
            formObj.f_excel.value="Y";
            formObj.target="_top";
            formObj.action="ESM_COA_0035DL.do?"+coaFormQueryString(formObj);
            formObj.submit();
            sheetObj.RemoveEtcData(); // Delete ETC data
            break;
        case IBDOWNEXCEL:   // Excell download		
        	sheetObj.SetWaitImageVisible(0);		//20150716.ADD
        	selectDownExcelMethod(sheetObj,0);        	
            break;
    }
}


function callBackExcelMethod(excelType) {	
	ComOpenWait(true);    			//20150716.ADD
    var sheetObj = sheetObjects[excelType[1]];
    switch (excelType[0]) {
	    case "AY":
	        sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	        break;
	    case "AN":
	    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	break;
	    case "DY":
	    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	    case "DN":
	    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	}     
    ComOpenWait(false);				//20150716.ADD
}

// Handling processes related Sheet2_Type Size
function doActionIBSheet2(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:      //Inquiry        	
            if (!validateCond(formObj, sAction)) {
                return false;
            }
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST02;
	            formObj.f_excel.value="N";
	            formObj.f_shpr_cd.value=formObj.txtShipper.value;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0035GS.do", coaFormQueryString(formObj));
	            //sheetObj.RenderSheet(0);
	//            sheetObj.SetVisible(0);
	//            sheetObj.RemoveAll();
	//            sheetObj = sheetObj.Reset();
	//            initSheet(sheetObj, 2);
	//            sheetObj.SetVisible(1);
	            //sheetObj.RenderSheet(1);
	            // SpeedOption for the performance before the LoadSearchXm 
	            sheetObj.LoadSearchData(sXml,{Sync:0} );
	            ComOpenWait(false);
            }, 100);
            break;
        case IBCREATE:      //file download
            if (!validateCond(formObj, sAction)) {
                return false;
            }
            //------------------------------- 
            // Create a data by async
            //------------------------------- 
            formObj.f_cmd.value=MULTI02;
            formObj.f_excel.value="Y";
            formObj.target="_top";
            formObj.action="ESM_COA_0035DL.do?"+coaFormQueryString(formObj);;
            formObj.submit();
            sheetObj.RemoveEtcData(); // Delete ETC data
            break;
        case IBDOWNEXCEL:   // Excell download
        	sheetObj.SetWaitImageVisible(0);		//20150716.ADD
        	selectDownExcelMethod(sheetObj,1);
        	
            break;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
//	sheet_hidden(sheetObj);		//SJH.20141112.ADD, 20150626.MOD : EPP TYPE HIDDEN 처리시 했어야 했는데..
    ComOpenWait(false);
    sheetObj.SetSumText(0,0, "TOTAL");
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
//	sheet_hidden(sheetObj);		//SJH.20141112.ADD, 20150626.MOD : EPP TYPE HIDDEN 처리시 했어야 했는데..
    ComOpenWait(false);
}

//SJH.20141111.ADD : HIDDEN
function sheet_hidden(sheetObj) {
	for ( var Col = 0 ; Col <= sheetObj.LastCol() ; Col++) {
		if(sheetObj.GetCellValue(0, Col).indexOf("EPP A") > -1 || sheetObj.GetCellValue(0, Col).indexOf("EPP B") > -1) sheetObj.SetColHidden(Col, 0);
		if(ComGetObjValue(f_type_cd) == "A") {
			if(sheetObj.GetCellValue(0, Col).indexOf("EPP B") > -1) sheetObj.SetColHidden(Col, 1);
		}else if(ComGetObjValue(f_type_cd) == "B") {
			if(sheetObj.GetCellValue(0, Col).indexOf("EPP A") > -1) sheetObj.SetColHidden(Col, 1);
		}
	}	
}

function getIbComboObjValue(obj){
    if (obj.GetSelectCode()== "All" ){
        return "";
    }
    return obj.GetSelectCode();
}
/**
 * Handling process for input validation
 */
function validateCond(formObj, sAction) {
        // Check for the argument year
		if(!chkValidSearch()) return false; 
		
        if(sAction == IBCREATE){
        	//20150717.DEL
//            if(getIbComboObjValue(f_ofc_cd) != "") {
//                if(parseInt(getIbComboObjValue(f_ofc_lvl)) <= 3){
//                    if(ComParseInt(formObj.f_to_wk.value)-ComParseInt(formObj.f_fm_wk.value) != 0){
//                        // [COA10003] : Based on one week for the week item
//                        ComShowMessage(ComGetMsg("COA10003", "Week", "1wk"));
//                        ComSetFocus(formObj.f_to_wk);
//                        return false;
//                    }                     
//                } else {
//                    if(ComParseInt(formObj.f_to_wk.value)-ComParseInt(formObj.f_fm_wk.value) > 4){
//                        // [COA10003] : Based on 5 weeks for the week item
//                        ComShowMessage(ComGetMsg("COA10003", "Week", "5wk"));
//                        ComSetFocus(formObj.f_to_wk);
//                        return false;
//                    } 
//                }
//            } else {
//                if(ComParseInt(formObj.f_to_wk.value)-ComParseInt(formObj.f_fm_wk.value) != 0){
//                    // [COA10003] : Based on 1 week for the week item
//                    ComShowMessage(ComGetMsg("COA10003", "Week", "1wk"));
//                    ComSetFocus(formObj.f_to_wk);
//                    return false;
//                }                             
//            }  
//            if(formObj.f_mon.value != "" && formObj.f_chkprd[1].checked) {
//                if(parseInt(getIbComboObjValue(f_ofc_lvl)) < 3 && getIbComboObjValue(f_trd_cd) == "") {
//                     ComShowMessage(ComGetMsg('COM12114','Trade'));
//                     ComSetFocus(formObj.f_trd_cd);
//                     return false;
//                }
//            }
        	//20150717.ADD
            if(getIbComboObjValue(f_rlane_cd) == "" && getIbComboObjValue(f_trd_cd) == ""){
                ComShowMessage(ComGetMsg('COA10002','Trade or Lane'));
                ComSetFocus(formObj.f_rlane_cd);
                return false;
            }             
        // SEARCHLIST              
        } else {
            if(parseInt(formObj.f_usr_ofc_lvl.value) == 1 && getIbComboObjValue(f_ofc_cd) == "" && parseInt(ComGetObjValue(f_ofc_lvl)) < 6){ 
//               if(getIbComboObjValue(f_trd_cd) == ""){
//                        ComShowMessage(ComGetMsg('COM12114','Trade'));
//                        ComSetFocus(formObj.f_trd_cd);
//                        return false;
//               } //20150327.PCM.Trade 로직 제거
               if(getIbComboObjValue(f_rlane_cd) == ""){
                        ComShowMessage(ComGetMsg('COM12114','Lane'));
                        ComSetFocus(formObj.f_rlane_cd);
                        return false;
               }
          } 

           if(getIbComboObjValue(f_ofc_cd) != "" || parseInt(getIbComboObjValue(f_ofc_lvl)) > 3) { //More than area
                // Level    Trade   Rlane   Period
                //--------------------------------------
                // Head Office       O      0      1
                //--------------------------------------
                // Regional Grp      O      0      1
                //--------------------------------------
                // SubRegional Grp   O      0      1
                //--------------------------------------
                // Area              O      X      3
                //--------------------------------------
                // below               X      X      3
                //--------------------------------------
//                if(parseInt(getIbComboObjValue(f_ofc_lvl)) <= 4){ //Selection OFC : HQ ~ Area 
//                    if(getIbComboObjValue(f_trd_cd) == ""){
//                        ComShowMessage(ComGetMsg('COM12114','Trade'));
//                        ComSetFocus(formObj.f_trd_cd);
//                        return false;
//                    }
//                } //20150327.PCM.Trade 로직 제거
                if(parseInt(getIbComboObjValue(f_ofc_lvl)) < 4){ //Selection OFC : HQ ~ sub regional group
                    if(getIbComboObjValue(f_rlane_cd) == ""){
                        ComShowMessage(ComGetMsg('COM12114','Lane'));
                        ComSetFocus(formObj.f_rlane_cd);
                        return false;
                    }
                }
                //20150615.MOD
//                if(parseInt(getIbComboObjValue(f_ofc_lvl)) <= 4){ // Selection OFC : HQ ~ Area 
//                    if(ComParseInt(ComGetObjValue(formObj.f_to_wk))-ComParseInt(ComGetObjValue(formObj.f_fm_wk)) != 0){
//                        // [COA10003] : Based on 1 week for the week item
//                        ComShowMessage(ComGetMsg("COA10003", "Week", "1wk"));                        
//                        ComSetFocus(formObj.f_to_wk);
//                        return false;
//                    }                     
//                } else { // Selection OFC : More then Sales OFC
//                    if(ComParseInt(ComGetObjValue(formObj.f_to_wk))-ComParseInt(ComGetObjValue(formObj.f_fm_wk)) > 2){
//                        // [COA10003] : Based on 3 weeks for the week item
//                        ComShowMessage(ComGetMsg("COA10003", "Week", "3wk"));
//                        ComSetFocus(formObj.f_to_wk);
//                        return false;
//                    }                     
//                }
          } else {
//                if(getIbComboObjValue(f_trd_cd) == ""){
//                    ComShowMessage(ComGetMsg('COM12114','Trade'));
//                    ComSetFocus(formObj.f_trd_cd);
//                    return false;
//                }  //20150327.PCM.Trade 로직 제거
                if(getIbComboObjValue(f_rlane_cd) == ""){
                    ComShowMessage(ComGetMsg('COM12114','Lane'));
                    ComSetFocus(formObj.f_rlane_cd);
                    return false;
                }         
            }
        }
        
        //20150612.ADD : 위크 선택시만.., 20150615.MOD
        if(formObj.f_chkprd[0].checked){
            if(ComParseInt(formObj.f_to_wk.value)-ComParseInt(formObj.f_fm_wk.value) > 4){
                // [COA10003] : Based on 1 week for the week item
                ComShowMessage(ComGetMsg("COA10003", "Week", "5wk"));                    
                ComSetFocus(formObj.f_to_wk);
                return false;
            }                 	
        }  
    return true;
}

function resizeSheet(){
	if (document.form.RPTForm.value == "ACCT") {
		ComResizeSheet(sheetObjects[0]);
	} else {
		ComResizeSheet(sheetObjects[1]);
	}
}

/**
 * Return S/C results
 * 20150806.ADD
 */
function getCOM_ENS_021_1(rowArray) {
    var colArray=rowArray[0];
//        ComShowMessage(rowArray.length+" ::::: " + colArray[0]+":"+colArray[1]+":"+colArray[2]+":"+colArray[3]+":"+colArray[4]+":"+colArray[5]+":"+colArray[6]+":"+colArray[7]+":"+colArray[8]);
    document.all.f_sc_no.value=colArray[2];
}

/**
 * Open the window
*  20160115.ADD
*/
function CommodityPopUp(){
    ComOpenPopup('/opuscntr/COM_ENS_0K1.do', 780, 480, "getCOM_ENS_0K1_1", "1,0,1,1,1,1,1,1", true);
}
/**
 * Setting Commodity
 */
function getCOM_ENS_0K1_1(rowArray) {
    var colArray=rowArray[0];
    document.all.f_rep_cmdt_cd.value=colArray[3];
}

/**
 * Display R.Lane by ifram
 */
//function searchCommodity() {
//	var formObj=document.form;
//	formObj.f_cmd.value=SEARCHLIST13;
////	sheetObjects[0].SetWaitImageVisible(0);
//	$.ajax({
//		url:"ESM_COA_0035GS2.do",
//		dataType:"text",
//		type:"POST",
//		async: true,
//		data : coaFormQueryString(formObj),
//		success:function(sXml){
//			var arrXml=sXml.split("|$$|");
//			if (arrXml.length > 0)
//				ComXml2ComboItem(arrXml[0], f_rep_cmdt_cd, "code", "code|name");
//			f_rep_cmdt_cd.SetSelectIndex(0); 
//		}, 
//		error: function(xhr){ 
//			console.log('error', xhr);
//		}
//	});   
//}