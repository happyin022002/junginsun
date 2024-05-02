/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0387.js
*@FileTitle  : Next VVD Assign I (by VVD POD)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESM_BKG_0387 : business script for ESM_BKG_0387
 */
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="t1sheet1_";
var prefix4="t2sheet1_";
var prefix5="sheet3_";
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     var sheetObject3=sheetObjects[2];
     var sheetObject4=sheetObjects[3];
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                if (validateForm(sheetObject1,formObject,IBSEARCH)) {
                    btnEnable(true);
                    ComClearObject(formObject.vsl_nm); 
                    ComClearObject(formObject.eta); 
                    ComClearObject(formObject.etd); 
                    ComSetObjValue(formObject.total20,"0");
                    ComSetObjValue(formObject.total40,"0");
                    ComSetObjValue(formObject.selBKG20,"0");
                    ComSetObjValue(formObject.selBKG40,"0");
                    ComSetObjValue(formObject.selVVD20,"0");
                    ComSetObjValue(formObject.selVVD40,"0");
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    sheetObjects[2].RemoveAll();
                    sheetObjects[3].RemoveAll();
                    tabObjects[0].SetSelectedIndex(0);
                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                }
            break;  
            case "btn_new":
                initForm();
                ComClearObject(formObject.etb_from);
                ComClearObject(formObject.etb_to);
                btnEnable(true);
            break;
            case "btn_DownExcel":
                if ( beforetab == 0 ) {   //retrieving on 1st tab
                    if(sheetObjects[2].RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                    }else{
                        doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
                    }
                } else if ( beforetab == 1 ) {  //retrieving on 2nd tab
                    if(sheetObjects[3].RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                    }else{
                        doActionIBSheet(sheetObjects[3],formObject,IBDOWNEXCEL);
                    }
                }  
            break;
            case "btn_cancelassign":
                if ( beforetab == 0 ) {   //retrieving on 1st tab
                    if (CheckRowGrid(sheetObjects[2],prefix3+"chk")){ 
                        btnEnable(false);
                        doActionIBSheet(sheetObjects[2],formObject,COMMAND03);
                    }
                } else if ( beforetab == 1 ) {  //retrieving on 2nd tab
                    if (CheckRowGrid(sheetObjects[3],prefix4+"chk")){ 
                        btnEnable(false);
                        doActionIBSheet(sheetObjects[3],formObject,COMMAND03);
                    }
                }  
            break;
            case "btn_vvdassign":
                if ( beforetab == 0 ) {   //retrieving on 1st tab
                    if (CheckRowGrid(sheetObjects[1],prefix2+"chk")){
                        btnEnable(false);
                        doActionIBSheet(sheetObjects[2],formObject,COMMAND04);
                    }
                } else if ( beforetab == 1 ) {  //retrieving on 2nd tab
                    if (CheckRowGrid(sheetObjects[1],prefix2+"chk")){ 
                        btnEnable(false);
                        doActionIBSheet(sheetObjects[3],formObject,COMMAND04);
                    }
                } 
            break;
            case "btn_duration":
                var cal=new ComCalendarFromTo();
                cal.select(formObject.etb_from, formObject.etb_to,'yyyy-MM-dd');
            break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
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
 * adding first-served functions after loading screen
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    sheet1OnLoadFinish(sheetObjects[0]);

    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
    tabObjects[0].SetSelectedIndex(0);
    initForm(); 
    axon_event.addListenerFormat('keypress','bkg0387_keypress',document.form); 
    axon_event.addListenerForm  ('beforedeactivate', 'bkg0387_deactivate',  document.form);
    axon_event.addListenerFormat('beforeactivate',   'bkg0387_activate',    document.form);
    axon_event.addListenerForm('click', 'bkg0387_click', document.form);
}
/*
* remove Sheet blinking
*/
function sheet1OnLoadFinish(sheetObj) {   
    doActionIBSheet(sheetObj,document.form,COMMAND05);   
}   
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init. Left top visible (Former VVD)
            with(sheetObj){
                var HeadTitle="|Sel.|1st VVD|ETB|TMNL";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
                     {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, RadioIcon:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"former_vvd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"etb",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pod_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 } 
                    ,{Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"former_clpt_ind_seq", KeyField:0, CalcLogic:"", Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                     ];
               
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(150);
            }
            break;
        case 2:      //sheet2 init Right Top visible ((NEXT VVD SELECTION)
            with(sheetObj){
                var HeadTitle="|Sel.|Next VVD|LANE|OOP|ETD|ETA|Relay TMNL|Next TMNL";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"ibflag" },
                     {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, RadioIcon:0 },
                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"next_vvd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"slan_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"op_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:98,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"etd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:98,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"eta",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"relay_tmnl", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"next_tmnl",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"next_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                InitColumns(cols);
                
                SetEditable(1);
                SetSheetHeight(150);
            }
            break;
        case 3:      //t1sheet1 init center visible [By VVD & POD] tab
            with(sheetObj){
                var HeadTitle="|Sel.|Next Port|20'|40'|Next VVD|OOP|ETB|ETD|Special";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix3+"next_port", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"fit20",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"fit40",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix3+"next_vvd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"op_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix3+"etb",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix3+"etd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix3+"spcl",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
               
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetSheetHeight(170);
            }
            break;
        case 4:      //t2sheet1 init center visible [By Booking] tab
            with(sheetObj){
                var HeadTitle="|Sel.|B/L No.|BKG No.|CNTR No.|TP|Weight|Weight|POL|DEL|Next Port|Next Port|Former VVD|ETB|TMNL|Next VVD|OOP|ETD|D/G|R/F|A/K|S/T|||CNTR Vol.";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix4+"ibflag" },
                         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix4+"cntr_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"next_port",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"next_port_yard", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"former_vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"etb",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"tmnl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"next_vvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"op_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"etd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"dcgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"rc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"awk_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"st",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"next_tmnl",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Float",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"cntr_qty",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 }];
                   
                InitColumns(cols);
                
                SetEditable(1);
                SetShowButtonImage(2);
                SetColProperty(prefix4+"dcgo_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
                SetColProperty(prefix4+"rc_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
                SetColProperty(prefix4+"awk_cgo_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
                SetColProperty(prefix4+"st", {ComboText:"Y|N", ComboCode:"Y|N"} );
                SetSheetHeight(240);
            }
            break;
      case 5: // Not visible
            with(sheetObj){
                var HeadTitle="|Chk|BKG No.|POL|OP_CD|Former VVD|Next VVD|Next TMNL|Before TMNL|Next Seq";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix5+"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix5+"chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix5+"pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix5+"op_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"former_vvd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"next_vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"next_tmnl",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"before_tmnl", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix5+"next_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
                InitColumns(cols);
                SetEditable(1);
                SetVisible(0);
            }
            break;
    }
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    var arrPreFix=new Array("sheet1_","sheet2_","t1sheet1_","t2sheet1_");
    var preFix=sheetObj.id+"_"; 
    switch(sAction) {
       case IBSEARCH: 
            ComOpenWait(true);
            sheetObj.SetWaitImageVisible(0);
            formObj.f_cmd.value=SEARCH;
            var sXml=sheetObj.GetSearchData("ESM_BKG_0387GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
            sheetObj.LoadSearchData(sXml,{Sync:1} );
            ComSetObjValue(formObj.oldRelayPort,formObj.relay_port.value);  
          break;
       case IBSAVE:    
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI; 
            var params=FormQueryString(formObj);
            params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
            params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
            params=params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));
            params=params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true));
            var sXml=sheetObj.GetSaveData("ESM_BKG_0387GS.do", params);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            sheetObj.LoadSearchData(sXml,{Sync:1} );
            break;
       case IBDOWNEXCEL:    
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            var rowSkip="";
            for(var i=1;i<sheetObj.Rows;i++){
                if (typeof(sheetObj.GetCellValue(i,preFix+"chk").length) !="undefined"){
                    if (i==sheetObj.Rows-1){
                        rowSkip+=i;
                    }else{
                        rowSkip+=i+"|";
                    }
                } 
            }
            sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
            break;
        case COMMAND01:         //grid_Former change
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=COMMAND01; 
            tabObjects[0].SetSelectedIndex(0);
            var params=FormQueryString(formObj);
            sheetObj.SetWaitImageVisible(0);
            var params=FormQueryString(formObj);
            params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true))+ "&" + ComGetPrefixParam(new Array("t1sheet1_","t2sheet1_"));
            var sXml=sheetObj.GetSearchData("ESM_BKG_0387GS.do", params);
            var arrXml=sXml.split("|$$|");
            sheetObjects[2].RemoveAll();
            sheetObjects[3].RemoveAll();
            sheetObjects[2].SetWaitImageVisible(0);
            for(var i=0; i < arrXml.length; i++){ 
                sheetObjects[i+2].LoadSearchData(arrXml[i],{Sync:1} );
            }
            ComSetObjValue(formObj.selBKG20,"0");
            ComSetObjValue(formObj.selBKG40,"0");
            ComSetObjValue(formObj.selVVD20,"0");
            ComSetObjValue(formObj.selVVD40,"0");
            ComSetObjValue(formObj.vsl_nm,ComGetEtcData(arrXml[0],"vs_nm")); 
            ComSetObjValue(formObj.eta,ComGetEtcData(arrXml[0],"eta")); 
            ComSetObjValue(formObj.etd,ComGetEtcData(arrXml[0],"etd")); 
            fitSum(formObj,sheetObjects[2]);
            setRmkBackColor(); 
            break;
        case COMMAND02:         //NEXT VVD SELECTION
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=COMMAND02;  
            var params=FormQueryString(formObj);
            params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
            params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
            params=params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));
            params=params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true));
            params=params + "&" + ComGetPrefixParam(new Array("sheet2_"));
            var sXml=sheetObj.GetSearchData("ESM_BKG_0387GS.do", params);
            sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
            break;
        case COMMAND03:         //btn_cancelassign
            sheetObj.SetWaitImageVisible(0);
            formObj.f_cmd.value=COMMAND03; 
            var params=FormQueryString(formObj); 
            var sBkgNo=""; 
            var idx=1;
            var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
            var arrRow=sRow.split("|"); 
            if (sheetObjects[3].CheckedRows(prefix4+"chk") == 0) return;
            sheetObjects[4].RemoveAll();
            for(var iRow=0;iRow<arrRow.length;iRow++){ 
                if (sBkgNo !=sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no")){
                    sBkgNo=sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no");
                    sheetObjects[4].DataInsert(-1);
                    sheetObjects[4].SetCellValue(idx,prefix5+"next_vvd","COXX0001E");
                    sheetObjects[4].SetCellValue(idx,prefix5+"former_vvd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"next_vvd"));
                    sheetObjects[4].SetCellValue(idx,prefix5+"bkg_no",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no"));
                    sheetObjects[4].SetCellValue(idx,prefix5+"pol_cd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"pol_cd"));
                    idx++;
                }
            }
            tabObjects[0].SetSelectedIndex(1);
            ComOpenWait(true);
            var sXml=sendAction(sheetObjects[4],params,"C");
            ComOpenWait(false);
            if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
                ComBkgSaveCompleted();
            }                                               
            break;
        case COMMAND04:         //btn_assign
            sheetObj.SetWaitImageVisible(0);
            formObj.f_cmd.value=COMMAND04; 
            var params=FormQueryString(formObj);
            ComOpenWait(true);
            var sXml=sendAction(sheetObjects[4],params,"A");
            ComOpenWait(false);
            if(sheetObjects[4].RowCount() == 0 && sXml == undefined ){  
                var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
                var arrRow=sRow.split("|");
                if(sheetObjects[4].RowCount()== 0){
                    for(var i=0; i<arrRow.length; i++){
                            sheetObjects[3].SetRowFontColor(arrRow[i],"#0033FF");
                            sheetObjects[3].SetCellFont("FontBold",arrRow[i],2,arrRow[i],21,1);
                    }
                }else{
                    for(var idx=0;idx<arrRow.length;idx++){
                        if(bkgNo ==sheetObjects[3].GetCellValue(arrRow[idx],prefix4+"bkg_no")){
                            sheetObjects[3].SetRowFontColor(arrRow[idx],"#0033FF");
                            sheetObjects[3].SetCellFont("FontBold",arrRow[idx],2,arrRow[idx],21,1);
                            sheetObjects[3].SetCellValue(arrRow[idx],prefix4+"next_vvd",sVvd,0);
                            sheetObjects[3].SetCellValue(arrRow[idx],prefix4+"tmnl",sTmnl,0);
                        }
                    }
                }   
                ComBkgSaveCompleted(); 
            }
            if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
                ComBkgSaveCompleted();
            }                                           
            break;
         case COMMAND05:            //Relay Port
            sheetObj.SetWaitImageVisible(0);
            formObj.f_cmd.value=COMMAND05; 
            var params=FormQueryString(formObj);  
            var sXml=sheetObj.GetSaveData("ESM_BKG_0387GS.do", params);
            ComSetObjValue(formObj.relay_port,ComGetEtcData(sXml,"relayPort"));
            ComSetObjValue(formObj.baseRelayPort,ComGetEtcData(sXml,"relayPort"));
            if (!ComIsEmpty(ComGetEtcData(sXml,"etbFrom"))){
                ComSetObjValue(formObj.etb_from,ComGetEtcData(sXml,"etbFrom"));
                ComSetObjValue(formObj.etb_to,ComGetEtcData(sXml,"erbTo"));
                if (ComGetEtcData(sXml,"nextVvd")=="A"){
                    formObj.next_vvd_select[0].checked=true;
                }else if (ComGetEtcData(sXml,"nextVvd")=="Y"){
                    formObj.next_vvd_select[1].checked=true;
                }else if (ComGetEtcData(sXml,"nextVvd")=="N"){
                    formObj.next_vvd_select[2].checked=true;
                }
            }
            break;
    }
    ComOpenWait(false);
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function t1sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function t2sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function t1sheet1_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
}

function t2sheet1_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt=0 ;
                InsertItem( "By VVD & POD" , "");
                InsertItem( "By Booking" , "");
            }
         break;
     }
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs=document.all.item("tabLayer");
        objs[nItem].style.display="Inline";
        objs[beforetab].style.display="none";
        objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
        beforetab=nItem;
        var sRow="";
        var arrRow="";
        if (beforetab ==0){
            //CellCheckAll(sheetObjects[3],false,prefix4+"chk"); 
            //ComSetObjValue(document.form.selBKG20,"0");
            //ComSetObjValue(document.form.selBKG40,"0");
            sRow=sheetObjects[2].FindCheckedRow(prefix3+"chk");
            arrRow=sRow.split("|");  
            if (sheetObjects[2].CheckedRows(prefix3+"chk") == 0) return; 
            sheetObjects[2].SelectCell(arrRow[0], 0, false);
        }else if (beforetab ==1){
            //CellCheckAll(sheetObjects[2],false,prefix3+"chk");
            //ComSetObjValue(document.form.selVVD20,"0");
            //ComSetObjValue(document.form.selVVD40,"0");
            sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
            arrRow=sRow.split("|");  
            if (sheetObjects[3].CheckedRows(prefix4+"chk") == 0) return; 
            sheetObjects[3].SelectCell(arrRow[0], 0, false);
        }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction) {
    with(formObj){
        switch (sAction) {
            case IBSEARCH: {
                if((ComIsEmpty(relay_port) || (ComIsEmpty(former_vvd)&&ComIsEmpty(etb_from)&&ComIsEmpty(etb_to)))){
                    ComShowCodeMessage("BKG00704");
                    return false;
                }
                if (ComGetDaysBetween(etb_from.value, etb_to.value) > 30) {
                    //ComShowCodeMessage("BKG02016"); 
                    ComShowCodeMessage("BKG00756", "Duration", "30Days");
                    etb_from.focus();
                    return false;
                }
                break;
            }
        }
    }
    return true;
}
/*
 * handler double click event sheet in 2nd tab
 */
function t2sheet1_OnDblClick(sheetObj, Row, Col){
    with(sheetObj){
        sheetObj.SetWaitImageVisible(0);
        var formObject=document.form;
        var sName=ColSaveName(Col);
        var param="?bkg_no="+GetCellValue(Row,prefix4+"bkg_no");
        param+="&relay_port="+ComGetObjValue(formObject.oldRelayPort);
        param+="&pgmNo=ESM_BKG_0903";
        if(sName == prefix4+"bl_no"){
            ComOpenWindowCenter("/opuscntr/ESM_BKG_0903.do"+param, "myWin", 500,278, true);
        }
    }
}
/*
*handler mouseMove event sheet in 2nd tab
*/
function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    with(sheetObj){
        var sName=ColSaveName(MouseCol());
        if(sName == prefix4+"bl_no"){
            SetMousePointer("Hand");
        }else{
            SetMousePointer("Default");
        }
    }
}
/*
* handler Sheet1 OnClick evnet
*/
function sheet1_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
	if (sheetObj.GetCellValue(Row,prefix1+"chk")=="0"){
		sheetObj.SetCellValue(Row,prefix1+"chk","1",0);
	} 
    if (sheetObj.ColSaveName(Col) !=prefix1+"chk"){
        sheet1_OnChange(sheetObj,Row, sheetObj.SaveNameCol(prefix1+"chk"), sheetObj.GetCellValue(Row,prefix1+"chk"));
    }
}
/*
* handler Sheet2 OnClick event
*/
function sheet2_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
	if (sheetObj.GetCellValue(Row,prefix2+"chk")=="0"){
		sheetObj.SetCellValue(Row,prefix2+"chk","1",0);
	}
    if (sheetObj.ColSaveName(Col) !=prefix2+"chk"){
        sheet2_OnChange(sheetObj,Row, sheetObj.SaveNameCol(prefix2+"chk"), sheetObj.GetCellValue(Row,prefix2+"chk"));
    }
}
/*
* handler t1sheet1 OnClick event
*/
function t1sheet1_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
    if (sheetObj.ColSaveName(Col) !=prefix3+"chk" && sheetObj.GetCellValue(Row,prefix3+"chk")=="0"){
        sheetObj.SetCellValue(Row,prefix3+"chk","1",0);
    }else if (sheetObj.ColSaveName(Col) !=prefix3+"chk" && sheetObj.GetCellValue(Row,prefix3+"chk")=="1"){
        sheetObj.SetCellValue(Row,prefix3+"chk","0",0);
    }
    if (sheetObj.ColSaveName(Col) !=prefix3+"chk"){
        t1sheet1_OnChange(sheetObj,Row, sheetObj.SaveNameCol(prefix3+"chk"), sheetObj.GetCellValue(Row,prefix3+"chk"));
    }
}
/*
* handler t2sheet1 OnClick event
*/
function t2sheet1_OnClick(sheetObj,Row, Col, Value, CellX, CellY, CellW, CellH){
    if (sheetObj.ColSaveName(Col) !=prefix4+"chk" && sheetObj.GetCellValue(Row,prefix4+"chk")=="0"){
        sheetObj.SetCellValue(Row,prefix4+"chk","1",0);
    }else if (sheetObj.ColSaveName(Col) !=prefix4+"chk" && sheetObj.GetCellValue(Row,prefix4+"chk")=="1"){
        sheetObj.SetCellValue(Row,prefix4+"chk","0",0);
    }
    if (sheetObj.ColSaveName(Col) !=prefix4+"chk") {
        t2sheet1_OnChange(sheetObj,Row, sheetObj.SaveNameCol(prefix4+"chk"), sheetObj.GetCellValue(Row,prefix4+"chk"));
    }
}
/*
* handler Sheet1 OnChange event
*/
function sheet1_OnChange(sheetObj,Row, Col, Value){
    var formObject=document.form; 
    with(sheetObj){
        SetWaitImageVisible(0);
        ComOpenWait(true);
        var sName=ColSaveName(Col);
        if(sName == prefix1+"chk" && Value && !ComIsEmpty(formObject.relay_port)){
            sheetObjects[1].RemoveAll();
            sheetObjects[4].RemoveAll();
            doActionIBSheet(sheetObj,formObject,COMMAND01);
            btnEnable(true);
        }
    }
    ComOpenWait(false);
    sheetObjects[3].SelectCell(0,1);
    sheetObjects[2].SelectCell(0,1);
}
/*
* handler Sheet2 OnChange event
*/
function sheet2_OnChange(sheetObj,Row, Col, Value){
    with(sheetObj){
        var sName=ColSaveName(Col);
        var sBkgNo=""; 
        var idx=1;
        sheetObj.SetWaitImageVisible(0);
        if(sName == prefix2+"chk" && Value){
            var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
            var arrRow=sRow.split("|"); 
            if (sheetObjects[3].CheckedRows(prefix4+"chk")==0) return;
            sheetObjects[4].RemoveAll();
            for(var iRow=0;iRow<arrRow.length;iRow++){
                if (sBkgNo !=sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no")){
                    sBkgNo=sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no");
                    sheetObjects[4].DataInsert(-1);
                    sheetObjects[4].SetCellValue(idx,prefix5+"next_vvd",GetCellValue(Row,prefix2+"next_vvd"));
//                      sheetObjects[4].CellValue(idx,prefix5+"former_vvd") =sheetObjects[3].CellValue(arrRow[iRow],prefix4+"former_vvd");
                    sheetObjects[4].SetCellValue(idx,prefix5+"former_vvd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"next_vvd"));
                    sheetObjects[4].SetCellValue(idx,prefix5+"bkg_no",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no"));
                    sheetObjects[4].SetCellValue(idx,prefix5+"pol_cd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"pol_cd"));
                    sheetObjects[4].SetCellValue(idx,prefix5+"op_cd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"op_cd"));
                    idx++;
                }
            }
            tabObjects[0].SetSelectedIndex(1);
        }
    }
    sheetObjects[4].RemoveAll();
    var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
    var arrRow=sRow.split("|"); 
    var sBkgNo=" "; 
    var idx=1;
    for(var iRow=0;iRow<arrRow.length;iRow++){
        if (sBkgNo !=sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no")){
            sBkgNo=sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no");
            sheetObjects[4].DataInsert(-1);
            sheetObjects[4].SetCellValue(idx,prefix5+"next_vvd",sheetObjects[1].GetCellValue(Row,prefix2+"next_vvd"));
            sheetObjects[4].SetCellValue(idx,prefix5+"former_vvd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"next_vvd"));
            sheetObjects[4].SetCellValue(idx,prefix5+"bkg_no",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no"));
            sheetObjects[4].SetCellValue(idx,prefix5+"pol_cd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"pol_cd"));
            sheetObjects[4].SetCellValue(idx,prefix5+"op_cd",sheetObjects[1].GetCellValue(Row,prefix2+"op_cd"));
            sheetObjects[4].SetCellValue(idx,prefix5+"next_tmnl",sheetObjects[1].GetCellValue(Row,prefix2+"next_tmnl"),0);
            sheetObjects[4].SetCellValue(idx,prefix5+"before_tmnl",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"next_tmnl"),0);
            sheetObjects[4].SetCellValue(idx,prefix5+"next_seq",sheetObjects[1].GetCellValue(Row,prefix2+"next_seq"),0);
            idx++;          
        }
    }
    btnEnable(true);
}
/*
* handler t1sheet1 OnChange event
*/
function t1sheet1_OnChange(sheetObj,Row, Col, Value){
    var formObject=document.form;
    var sName=sheetObj.ColSaveName(Col);
    if(sName == prefix3+"chk" && Value && !ComIsEmpty(formObject.relay_port)){
        SheetRowRadioCheck(sheetObj,Row,Col,Value); 
        Sheet1ToSheet2Chk(sheetObj,sheetObjects[3],Row,Value);
        ComSetObjValue(formObject.selVVD20,sheetObj.GetCellValue(Row,prefix3+"fit20"));
        ComSetObjValue(formObject.selVVD40,sheetObj.GetCellValue(Row,prefix3+"fit40"));
        ComSetObjValue(formObject.nextVvdFor,"t1sheet1_"); 
        doActionIBSheet(sheetObjects[1],formObject,COMMAND02);  
    }else if(sName == prefix3+"chk" && !Value && !ComIsEmpty(formObject.relay_port)){ 
        SheetRowRadioCheck(sheetObj,Row,Col,Value); 
        Sheet1ToSheet2Chk(sheetObj,sheetObjects[3],Row,Value);
        ComSetObjValue(formObject.selVVD20,"0");
        ComSetObjValue(formObject.selVVD40,"0");
        sheetObjects[1].RemoveAll();
    }               
    btnEnable(true);
}
/*
* handler t2sheet1 OnChange event
*/
function t2sheet1_OnChange(sheetObj,Row, Col, Value){
    var formObject=document.form;
    var sName=sheetObj.ColSaveName(Col);
    var calBKG20 = 0;
    var calBKG40 = 0;
    var calValue = 0;
    if(sName == prefix4+"chk" && Value && !ComIsEmpty(formObject.relay_port)){
        var sRow1=sheetObjects[2].FindCheckedRow(prefix3+"chk");
        var arrRow1=sRow1.split("|");
        Sheet2ToSheet1Chk(sheetObj,sheetObjects[2],Row,Value);
        if (sheetObjects[2].CheckedRows(prefix3+"chk") > 0){
            if (sheetObj.GetCellValue(Row,prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
            	calBKG20 = BkgParseFloat(sheetObj.GetCellValue(Row,prefix4+"cntr_qty"));
            	calValue = (BkgParseFloat(ComGetObjValue(formObject.selBKG20)) + calBKG20).toFixed(2);		
        		ComSetObjValue(formObject.selBKG20,calValue);
            }else {
            	calBKG40 = BkgParseFloat(sheetObj.GetCellValue(Row,prefix4+"cntr_qty"));
            	calValue = (BkgParseFloat(ComGetObjValue(formObject.selBKG40)) + calBKG40).toFixed(2);
        		ComSetObjValue(formObject.selBKG40,calValue);
            }
        }
    }else if(sName == prefix4+"chk" && !Value && !ComIsEmpty(formObject.relay_port) 
    		&& (BkgParseFloat(formObject.selBKG20.value) >0 ||BkgParseFloat(formObject.selBKG40.value) >0)){
        if (sheetObj.GetCellValue(Row,prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
        	calBKG20 = BkgParseFloat(sheetObj.GetCellValue(Row,prefix4+"cntr_qty"));
        	calValue = (BkgParseFloat(ComGetObjValue(formObject.selBKG20)) - calBKG20).toFixed(2);			//Float 형 계산오류 수정 2자리에서 고정소숫점 표시
    		ComSetObjValue(formObject.selBKG20,calValue);
        }else{
        	calBKG40 = BkgParseFloat(sheetObj.GetCellValue(Row,prefix4+"cntr_qty"));
        	calValue = (BkgParseFloat(ComGetObjValue(formObject.selBKG40)) - calBKG40).toFixed(2);			//Float 형 계산오류 수정 2자리에서 고정소숫점 표시
    		ComSetObjValue(formObject.selBKG40,calValue);
        }
        var sRow2=sheetObjects[3].FindCheckedRow(prefix4+"chk");
        var arrRow2=sRow2.split("|");  
        if (sheetObjects[3].CheckedRows(prefix4+"chk") == 0){
            sheetObjects[2].CheckAll(prefix3+"chk","0",0);
            sheetObjects[1].RemoveAll();
            ComSetObjValue(formObject.selVVD20,"0");
            ComSetObjValue(formObject.selVVD40,"0"); 
        }else{
            //doActionIBSheet(sheetObjects[1],formObject,COMMAND02);
        }
    }
    sheetObjects[4].RemoveAll();
    var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
    var arrRow=sRow.split("|");
    var sRow2=sheetObjects[1].FindCheckedRow(prefix2+"chk");
    var arrRow2;
    var sBkgNo=" "; 
    var idx=1;
    for (var iRow=0;iRow<arrRow.length;iRow++) {
        if (sBkgNo !=sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no")) {
            sBkgNo=sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no");
            sheetObjects[4].DataInsert(-1);
            sheetObjects[4].SetCellValue(idx,prefix5+"bkg_no",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"bkg_no"),0);
            sheetObjects[4].SetCellValue(idx,prefix5+"pol_cd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"pol_cd"),0);
            sheetObjects[4].SetCellValue(idx,prefix5+"former_vvd",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"next_vvd"),0);
            sheetObjects[4].SetCellValue(idx,prefix5+"before_tmnl",sheetObjects[3].GetCellValue(arrRow[iRow],prefix4+"next_tmnl"),0);
            if (sRow2) {
                arrRow2=sRow2.split("|");
                if (arrRow2 && 0<arrRow2.length) {
                    sheetObjects[4].SetCellValue(idx,prefix5+"next_vvd",sheetObjects[1].GetCellValue(arrRow2[0],prefix2+"next_vvd"),0);
                    sheetObjects[4].SetCellValue(idx,prefix5+"op_cd",sheetObjects[1].GetCellValue(arrRow2[0],prefix2+"op_cd"),0);
                    sheetObjects[4].SetCellValue(idx,prefix5+"next_tmnl",sheetObjects[1].GetCellValue(arrRow2[0],prefix2+"next_tmnl"),0);
                    sheetObjects[4].SetCellValue(idx,prefix5+"next_seq",sheetObjects[1].GetCellValue(arrRow2[0],prefix2+"next_seq"),0);
                }
            }
            idx++;          
        }
    }
    btnEnable(true);
}
/*
* initialize Form 
*/
function initForm(){
    var formObject=document.form;
     formObject.etb_from.value=ComGetNowInfo();
     formObject.etb_to.value=ComGetNowInfo();
     //ComClearObject(formObject.relay_port);
     formObject.relay_port.value=formObject.baseRelayPort.value;
     ComClearObject(formObject.oldRelayPort);
     ComClearObject(formObject.former_vvd);
     ComClearObject(formObject.pol_cd);  
     ComClearObject(formObject.next_vvd);
     ComClearObject(formObject.pod_cd);
     ComClearObject(formObject.next_port); 
     ComClearObject(formObject.vsl_nm); 
     ComClearObject(formObject.eta); 
     ComClearObject(formObject.etd); 
     ComClearObject(formObject.nextVvdFor);
     ComSetObjValue(formObject.total20,"0");
     ComSetObjValue(formObject.total40,"0");
     ComSetObjValue(formObject.selBKG20,"0");
     ComSetObjValue(formObject.selBKG40,"0");
     ComSetObjValue(formObject.selVVD20,"0");
     ComSetObjValue(formObject.selVVD40,"0");
     formObject.rc_flg.checked=false;
     formObject.dcgo_flg.checked=false;
     formObject.awk_cgo_flg.checked=false;
     formObject.rd_cgo_flg.checked=false;
     formObject.next_vvd_select[0].checked=true;
     sheetObjects[0].RemoveAll();
     sheetObjects[1].RemoveAll();
     sheetObjects[2].RemoveAll();
     sheetObjects[3].RemoveAll();
     sheetObjects[4].RemoveAll();
     tabObjects[0].SetSelectedIndex(0);
     btnEnable(true); 
}
/*
*  handler Sheet2 Cell popup event in Tab2
*/
function t2sheet1_OnPopupClick(sheetObj, Row,Col){
    var param="?bkg_no="+sheetObj.GetCellValue(Row,prefix4+"bkg_no");
    param+="&pgmNo=ESM_BKG_0079";
    var bkgNo=sheetObj.GetCellValue(Row,prefix4+"bkg_no");
    with(sheetObj)
    {
        var sName=ColSaveName(Col);
        switch(sName){
             case prefix4+"dcgo_flg":
//                   ComOpenWindowCenter("/opuscntr/ESM_BKG_0079.do" + param, "PopupEsmBkg0387", 1005, 650, false);
                 comBkgCallPopBkgDetail(bkgNo);
              break;
             case prefix4+"rc_flg":
//                   ComOpenWindowCenter("/opuscntr/ESM_BKG_0079.do" + param, "PopupEsmBkg0387", 1005, 650, false);
                 comBkgCallPopBkgDetail(bkgNo);
              break;
             case prefix4+"awk_cgo_flg":
//                   ComOpenWindowCenter("/opuscntr/ESM_BKG_0079.do" + param, "PopupEsmBkg0387", 1005, 650, false);
                 comBkgCallPopBkgDetail(bkgNo);
              break;
             case prefix4+"st":
//                   ComOpenWindowCenter("/opuscntr/ESM_BKG_0079.do" + param, "PopupEsmBkg0387", 1005, 650, false);
                 comBkgCallPopBkgDetail(bkgNo);
              break;
        }
    }
}
/*
 * handling KeyPress Event
 */
function bkg0387_keypress(){
    obj=ComGetEvent();
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat; 
    switch(obj.dataformat){ 
        case "num": 
            ComKeyOnlyNumber(ComGetEvent());
            break;   
         case "engup": 
             ComKeyOnlyAlphabet('uppernum'); 
            break; 
    }
}
/*
 * handling Activate Event
 */
function bkg0387_activate(){
    switch(ComGetEvent("name")){ 
        case "etb_from":
            ComClearSeparator(ComGetEvent());
            break;
        case "etb_to":
            ComClearSeparator(ComGetEvent());
            break; 
        default:
            break;
    }
}
/*
 * handling Deactivate Event
 */
function bkg0387_deactivate(){ 
    switch(ComGetEvent("name")){ 
        case "etb_from":
            ComAddSeparator(ComGetEvent());
            break;
        case "etb_to":
            ComAddSeparator(ComGetEvent());
            break; 
        default:
            break; 
    }
}
/*
* calculate sum each container
*/
function fitSum(formObj,sheetObj){
    var fit20=0;
    var fit40=0;
    with(sheetObj){
        for(var iRow=1;iRow<RowCount()+1;iRow++){
            if (!ComIsEmpty(GetCellValue(iRow,prefix3+"fit20"))){
                fit20+=BkgParseFloat(GetCellValue(iRow,prefix3+"fit20"));
                fit40+=BkgParseFloat(GetCellValue(iRow,prefix3+"fit40"));
            }
        }
        ComSetObjValue(formObj.total20,fit20);
        ComSetObjValue(formObj.total40,fit40);
    }
}
/*
* handling radio button in grid
*/
function SheetRowRadioCheck(sheetObj,Row,Col,Value){
     sheetObj.CheckAll(Col,0,0);
     sheetObj.SetCellValue(Row,Col,Value,0);
}
/*
*  check NextPort sheet in Tab2 in case of sheet in Tab1 check nextPort 
*/
function Sheet1ToSheet2Chk(sheetObj1,sheetObj2,Row,Value){ 
    var formObject=document.form; 
    sheetObj2.CheckAll(prefix4+"chk","0",0);	//uncheck all
    ComSetObjValue(formObject.selBKG20,"0"); 
    ComSetObjValue(formObject.selBKG40,"0"); 
    var calBKG20 = 0;
    var calBKG40 = 0;
    
    for(var iRow=1;iRow<sheetObj2.RowCount()+1;iRow++){
        if (sheetObj1.GetCellValue(Row,prefix3+"next_port")==(sheetObj2.GetCellValue(iRow,prefix4+"next_port")+sheetObj2.GetCellValue(iRow,prefix4+"next_port_yard"))
        		&& sheetObj1.GetCellValue(Row,prefix3+"next_vvd")==(sheetObj2.GetCellValue(iRow,prefix4+"next_vvd"))
        		){
            sheetObj2.SetCellValue(iRow,prefix4+"chk",Value,0);
            if (Value){
            	if (sheetObj2.GetCellValue(iRow,prefix4+"cntr_tpsz_cd").indexOf("2")>-1){	//D2
            		calBKG20 = BkgParseFloat(sheetObj2.GetCellValue(iRow,prefix4+"cntr_qty"));
            		ComSetObjValue(formObject.selBKG20,BkgParseFloat(ComGetObjValue(formObject.selBKG20)) + calBKG20);
            	}else{
            		calBKG40 = BkgParseFloat(sheetObj2.GetCellValue(iRow,prefix4+"cntr_qty"));
            		ComSetObjValue(formObject.selBKG40,BkgParseFloat(ComGetObjValue(formObject.selBKG40)) + calBKG40);
            	}
            }
        }
    }
}
/*
* check NextPort sheet in Tab1 in case of sheet in Tab2 check nextPort
*/
function Sheet2ToSheet1Chk(sheetObj2,sheetObj1,Row,Value){ 
	
    var formObject=document.form; 
    var sRow1=sheetObj1.FindCheckedRow(prefix3+"chk");
    var arrRow1 = sRow1.split("|"); 
    var sRow2=sheetObj2.FindCheckedRow(prefix4+"chk");
    var arrRow2 = sRow2.split("|");
    var calBKG20 = 0;
    var calBKG40 = 0;
    if (sheetObj1.CheckedRows(prefix3+"chk")==0){ 
        if (sheetObj2.CheckedRows(prefix4+"chk")==0) return; 
        for(var iRow=0;iRow<arrRow2.length;iRow++){
            sheetObj2.SetCellValue(arrRow2[iRow],prefix4+"chk","1",0);
            if (sheetObj2.GetCellValue(arrRow2[iRow],prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
//                    ComSetObjValue(formObject.selBKG20,BkgParseFloat(formObject.selBKG20.value)+1);
            	calBKG20 = BkgParseFloat(sheetObj2.GetCellValue(iRow,prefix4+"cntr_qty"));
            	if(!isNaN(calBKG20)){
                	ComSetObjValue(formObject.selBKG20,BkgParseFloat(ComGetObjValue(formObject.selBKG20)) + calBKG20);
            	}
            }else {
//                ComSetObjValue(formObject.selBKG40,BkgParseFloat(formObject.selBKG40.value)+1);
            	calBKG40 = BkgParseFloat(sheetObj2.GetCellValue(iRow,prefix4+"cntr_qty"));
            	if(!isNaN(calBKG40)){
            		ComSetObjValue(formObject.selBKG40,BkgParseFloat(ComGetObjValue(formObject.selBKG40)) + calBKG40);
            	}
            }
        }
        for(var iRow=0;iRow<sheetObj1.RowCount()+1;iRow++){
            if (sheetObj1.GetCellValue(iRow,prefix3+"next_port")==(sheetObj2.GetCellValue(Row,prefix4+"next_port")+sheetObj2.GetCellValue(Row,prefix4+"next_port_yard")) 
            		&& sheetObj1.GetCellValue(iRow,prefix3+"next_vvd")==(sheetObj2.GetCellValue(Row,prefix4+"next_vvd"))
            		){
                sheetObj1.SetCellValue(iRow,prefix3+"chk",Value,0);
                sheetObj2.SetCellValue(Row,prefix4+"chk",Value,0);
                if (Value){
                    ComSetObjValue(formObject.selVVD20,sheetObj1.GetCellValue(iRow,prefix3+"fit20"));
                    ComSetObjValue(formObject.selVVD40,sheetObj1.GetCellValue(iRow,prefix3+"fit40"));
                    ComSetObjValue(formObject.nextVvdFor,"t1sheet1_"); 
                }
                doActionIBSheet(sheetObjects[1],formObject,COMMAND02);  
            }
        } 
    }else if (sheetObj2.CheckedRows(prefix4+"chk")>0){ 
        nextVVDCheck(sheetObjects[3],Row,sheetObjects[3].GetCellValue(Row,prefix4+"next_port")+sheetObjects[3].GetCellValue(Row,prefix4+"next_port_yard"),sheetObjects[3].GetCellValue(Row,prefix4+"next_vvd"));
    }

}
/*
* checking difference nextVVD value of checked row in sheet
*/
function nextVVDCheck(sheetObj,Row,nextPort,nextVVD){
    var formObject=document.form;
    var sRow=sheetObj.FindCheckedRow(prefix4+"chk");
    var arrRow=sRow.split("|"); 
    var calBKG20 = 0;
    var calBKG40 = 0;
    var arrNextPort = "";
    var arrNextVVD  = "";
    if (sheetObj.CheckedRows(prefix4+"chk") == 0) return;
    for(var iRow=0;iRow<arrRow.length;iRow++){
    	arrNextPort = sheetObj.GetCellValue(arrRow[iRow],prefix4+"next_port")+sheetObj.GetCellValue(arrRow[iRow],prefix4+"next_port_yard");
    	arrNextVVD  = sheetObj.GetCellValue(arrRow[iRow],prefix4+"next_vvd");
    	
        if ((arrNextPort == nextPort && arrNextVVD != nextVVD) 
        		|| (arrNextPort != nextPort && arrNextVVD == nextVVD)
        		|| (arrNextPort != nextPort && arrNextVVD != nextVVD)
        		){
            sheetObj.SetCellValue(Row,prefix4+"chk","0",0);
            if (sheetObj.GetCellValue(Row,prefix4+"cntr_tpsz_cd").indexOf("2")>-1){
//                ComSetObjValue(formObject.selBKG20,BkgParseFloat(formObject.selBKG20.value)-1); 
            	calBKG20 = BkgParseFloat(sheetObj.GetCellValue(Row,prefix4+"cntr_qty"));
            	ComSetObjValue(formObject.selBKG20,BkgParseFloat(ComGetObjValue(formObject.selBKG20)) - calBKG20);
            }else {
//            	ComSetObjValue(formObject.selBKG40,BkgParseFloat(formObject.selBKG40.value)-1);
            	calBKG40 = BkgParseFloat(sheetObj.GetCellValue(Row,prefix4+"cntr_qty"));
            	ComSetObjValue(formObject.selBKG40,BkgParseFloat(ComGetObjValue(formObject.selBKG40)) - calBKG20);
            }
            ComShowCodeMessage("BKG00215");
            break;
        }
    }
}
 /**
 * fnAutoratingRfaAvailable  
 * checking validation AutoratingRfa
 * @param v_bkg_no 
 * @param v_rfa_no 
 * @param v_date
 * @return boolean
 */
 function fnSearchBkgVvdCheck(sheetObj,v_bkg_no) {
    var input_text=v_bkg_no ;
    var param=param + "&f_cmd=" + SEARCH03 + "&input_text=" + input_text;
    var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
    var output_text=ComGetEtcData(sXml, "output_text");
    if ('Y' == output_text) {   
        ComShowCodeMessage("BKG08153");             
    }else{
        //
    }
    return true;
 }
/*
* handling Assian each sheet Row
*/
function sendAction(sheetObj,params,assignFlag){
    var bRtn=true;
    var iRtn=0;
    var bfalg=false;
    var sXml="";
    var sVvd="";
    var sTmnl="";
    var sNextPort="";
    var sNextYd="";
    var sBeforeTmnl="";
    var saveParams=""
    if (assignFlag=="C"){
//          sVvd="COXX0001E";
        sVvd="";
    }else{
        var sRow1=sheetObjects[1].FindCheckedRow(prefix2+"chk");
        var arrRow1=sRow1.split("|");
        sVvd=sheetObjects[1].GetCellValue(arrRow1[0],prefix2+"next_vvd");
        sTmnl=sheetObjects[1].GetCellValue(arrRow1[0],prefix2+"relay_tmnl");
        /* for Next Port Yard Setting  */
        sNextPort=sheetObjects[1].GetCellValue(arrRow1[0],prefix2+"next_tmnl").substring(0,5);
        sBeforeTmnl=sheetObjects[1].GetCellValue(arrRow1[0],prefix2+"next_tmnl");
        if((sheetObjects[1].GetCellValue(arrRow1[0],prefix2+"next_tmnl")).length == 5){
            sNextYd="";
        }else{
            sNextYd=sheetObjects[1].GetCellValue(arrRow1[0],prefix2+"next_tmnl").substring(5,7);
        }
    }
    for(var iRow=sheetObj.LastRow(); iRow>=sheetObj.HeaderRows(); iRow--){
        if((sheetObjects[4].GetCellValue(iRow,prefix5+"former_vvd") == sheetObjects[4].GetCellValue(iRow,prefix5+"next_vvd"))
                && (sheetObjects[4].GetCellValue(iRow,prefix5+"next_tmnl") == sheetObjects[4].GetCellValue(iRow,prefix5+"before_tmnl"))){
            var findRow=sheetObjects[3].FindText(prefix4 + "bkg_no",sheetObjects[4].GetCellValue(iRow,prefix5+"bkg_no"));
            sheetObjects[4].RowDelete(iRow,false);
        }
    }
    if(sheetObjects[4].RowCount() == 0) return;
    for(var iRow=1;iRow<sheetObjects[4].RowCount()+1;iRow++){
        if(fnSearchBkgVvdCheck(sheetObj, sheetObj.GetCellValue(iRow,prefix5+"bkg_no"))){
            sheetObj.SetCellValue(iRow,prefix5+"chk","1",0);
            saveParams=params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
            sXml=sheetObj.GetSaveData("ESM_BKG_0387GS.do", saveParams);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            if (State=="S"){
                sheetObj.SetCellValue(iRow,prefix5+"chk","0",0);
                if (iRow==sheetObj.Rows-1) bfalg=true;
                iRtn=sheetBackColor(iRtn,sheetObj.GetCellValue(iRow,prefix5+"bkg_no"),bfalg,sVvd,sTmnl,sNextPort,sNextYd,sBeforeTmnl);
            }else{
                bRtn=false;
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                break;
            }
        }
    }
    return sXml;
}
/*
* handling font color of processed sheet
*/
function sheetBackColor(iRtn,bkgNo,flag,sVvd,sTmnl,sNextPort,sNextYd,sBeforeTmnl){
    var sRow=sheetObjects[3].FindCheckedRow(prefix4+"chk");
    var arrRow=sRow.split("|");  
    if(iRtn == undefined) return;
    for(var idx=iRtn;idx<arrRow.length;idx++){
        if(bkgNo ==sheetObjects[3].GetCellValue(arrRow[idx],prefix4+"bkg_no")){
            sheetObjects[3].SetRowFontColor(arrRow[idx],"#0033FF");
            sheetObjects[3].SetCellFont("FontBold",arrRow[idx],2,arrRow[idx],21,1);
            sheetObjects[3].SetCellValue(arrRow[idx],prefix4+"next_vvd",sVvd,0);
            sheetObjects[3].SetCellValue(arrRow[idx],prefix4+"tmnl",sTmnl,0);
            sheetObjects[3].SetCellValue(arrRow[idx],prefix4+"next_port",sNextPort,0);
            sheetObjects[3].SetCellValue(arrRow[idx],prefix4+"next_tmnl",sBeforeTmnl,0);
            if(sNextYd.length > 0){
                sheetObjects[3].SetCellValue(arrRow[idx],prefix4+"next_port_yard",sNextYd,0);
            }
            if (flag) {
                sheetObjects[3].SelectCell((BkgParseFloat(arrRow[idx])+1),0);
            }else{
                sheetObjects[3].SelectCell(arrRow[idx],0);
            }
        }
        else{
            return idx;
        }
    }
}
/*
* setting color of cell exist Remark value
*/
function setRmkBackColor(){
//no support[check again]CLT        
    if (sheetObjects[3].Rows<2) return; 
//no support[check again]CLT        
    for(var idx=1;idx<sheetObjects[3].Rows;idx++){
        var vvdRows1,vvdRows2;
        /* By Booking Color change*/
        if (sheetObjects[3].GetCellValue(idx,prefix4+"rmk")=="Y"){
            sheetObjects[3].SetRowBackColor(idx,"#CCFFFC");
            /* By VVD & POD Color change */
            vvdRows1=ComFindText(sheetObjects[2],prefix3+"next_port",sheetObjects[3].GetCellValue(idx,prefix4+"next_tmnl"));
            vvdRows2=ComFindText(sheetObjects[2],prefix3+"next_vvd",sheetObjects[3].GetCellValue(idx,prefix4+"next_vvd"));
            if (vvdRows1 && vvdRows2 && 0<vvdRows1.length && 0<vvdRows2.length) {
                for (var idx2=0; idx2<vvdRows1.length; idx2++) {
                    for (var idx3=0; idx3<vvdRows2.length; idx3++) {
                        if (vvdRows1[idx2]==vvdRows2[idx3]) {
//if (!ComIsEmpty(sheetObjects[2].CellValue(vvdRows1[idx2],prefix3+"next_vvd")) && !ComIsEmpty(sheetObjects[3].CellValue(idx,prefix4+"next_vvd")))
//{
                            sheetObjects[2].SetRowBackColor(vvdRows1[idx2],"#CCFFFC");
//}
                        }
                    }
                }
            }
        } 
    }
}
/*
* handling button disable
*/
function btnEnable(flag){
    if (flag){
        ComBtnEnable("btn_cancelassign");
        ComBtnEnable("btn_vvdassign");
    }else{
        ComBtnDisable("btn_cancelassign");
        ComBtnDisable("btn_vvdassign");
    }
}
/*
* handling Click Event
*/
function bkg0387_click(){
    var formObject=document.form; 
    switch(ComGetEvent("name")){ 
        case "rc_flg":
            formObject.dcgo_flg.checked=false;
            formObject.awk_cgo_flg.checked=false;
            formObject.rd_cgo_flg.checked=false; 
            break;
        case "dcgo_flg":
            formObject.rc_flg.checked=false;
            formObject.awk_cgo_flg.checked=false;
            formObject.rd_cgo_flg.checked=false;  
            break; 
        case "awk_cgo_flg":
            formObject.rc_flg.checked=false;
            formObject.dcgo_flg.checked=false;
            formObject.rd_cgo_flg.checked=false;  
            break; 
        case "rd_cgo_flg":
            formObject.rc_flg.checked=false;
            formObject.dcgo_flg.checked=false;
            formObject.awk_cgo_flg.checked=false;
            break; 
    }  
}
/*
* handling t2sheet1 OnMouseDown envet
*/
function t2sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y) {
        if (Shift==1){
            with(sheetObj){
                var sRow=FindCheckedRow(prefix4+"chk");
                var arrRow=sRow.split("|");
                if (CheckedRows(prefix4+"chk") == 0) return;
                var iStart=arrRow[0];
                var iEnd=MouseRow();
                var nextVvd=GetCellValue(iStart,prefix4+"next_vvd");
                for(var idx=iStart;idx<iEnd;idx++){
                    if (GetCellValue(idx,prefix4+"next_vvd")==nextVvd){
                        SetCellValue(idx,prefix4+"chk",1,0);
                    }
                }
            }
        }
}
