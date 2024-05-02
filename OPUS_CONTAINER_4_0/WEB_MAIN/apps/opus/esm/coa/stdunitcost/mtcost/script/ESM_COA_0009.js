/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0009.js
*@FileTitle  : Create MT standard unit cost per ECC & MT Turntime
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0009 : ESM_COA_0009 Business script for the UI
 */
//var calPop = new calendarPopupGrid();
var curTab=1;
var beforetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array(); // IB Combo variable
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
    /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    //mt
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var sheetObject2=sheetObjects[2];
    var sheetObject3=sheetObjects[3];
    var sheetObject4=sheetObjects[4];
    var sheetObject5=sheetObjects[5];
    var sheetObject6=sheetObjects[6];
    var sheetObject7=sheetObjects[7];
    //full  
    var sheetObject8=sheetObjects[8];
    var sheetObject9=sheetObjects[9];
    var sheetObject10=sheetObjects[10];
    var sheetObject11=sheetObjects[11];
    var sheetObject12=sheetObjects[12];
    var sheetObject13=sheetObjects[13];
    var sheetObject14=sheetObjects[14];
    var costLocGrpCdCombo=comboObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Retrieve":
               if(formObject.kind[1].checked){ //mt     
                    if(costLocGrpCdCombo.GetSelectCode()== "R") {//RCC
                        doActionIBSheet3(sheetObject5,formObject,IBSEARCH);
                    } else if(costLocGrpCdCombo.GetSelectCode()== "L") {//LCC
                        doActionIBSheet2(sheetObject3,formObject,IBSEARCH);
                    } else if(costLocGrpCdCombo.GetSelectCode()== "E") {//ECC
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    }
                    formObject.f_ecc_cd2.value="";
                    formObject.f_ori_dest[0].checked=true;
               } else { //full
                    if(costLocGrpCdCombo.GetSelectCode()== "R") {//RCC
                        doActionIBSheet6(sheetObject12,formObject,IBSEARCH);
                    } else if(costLocGrpCdCombo.GetSelectCode()== "L") {//LCC
                        doActionIBSheet5(sheetObject10,formObject,IBSEARCH);
                    } else if(costLocGrpCdCombo.GetSelectCode()== "E") {//ECC
                        doActionIBSheet4(sheetObject7,formObject,IBSEARCH);
                    }
                    formObject.f_ecc_cd3.value="";
                    formObject.f_ori_dest2[0].checked=true; 
               }
                break;
            case "btn_Creation":
                if(formObject.f_cost_yrmon.value == "") {
                    ComShowCodeMessage('COA10002', 'YYYY-MM');
                    ComSetFocus(formObject.f_cost_yrmon);
                    return false;   
                }
                 var param="?cost_yrmon="+formObject.f_cost_yrmon.value;
                 popup=ComOpenWindowCenter('/opuscntr/ESM_COA_3003.do' + param, "test_", 300, 140, true );
                if(popup != ""){
                    var arrXml=popup.split("@@");
                    formObject.f_fm_mon.value=arrXml[0];
                    formObject.f_to_mon.value=arrXml[1];
                    doActionIBSheet(sheetObject, formObject, IBCREATE);
                }
                break;
            case "btn_DownExcel":
                if(formObject.kind[1].checked){ //mt
                    if(costLocGrpCdCombo.GetSelectCode()== "R") {//RCC
                        if(sheetObject5.RowCount() < 1){//no data
                            ComShowCodeMessage("COM132501");
                        }else{
                            doActionIBSheet3(sheetObject5,formObject,IBDOWNEXCEL);
                        }
                    } else if(costLocGrpCdCombo.GetSelectCode()== "L") {//LCC
                        if(sheetObject3.RowCount() < 1){//no data
                            ComShowCodeMessage("COM132501");
                        }else{
                            doActionIBSheet2(sheetObject3,formObject,IBDOWNEXCEL);
                        }
                    } else if(costLocGrpCdCombo.GetSelectCode()== "E") {//ECC
                        if(sheetObject.RowCount() < 1){//no data
                            ComShowCodeMessage("COM132501");
                        }else{
                            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                        }
                    }
                } else if(formObject.kind[0].checked){  //full
                    if(costLocGrpCdCombo.GetSelectCode()== "R") {//RCC
                        if(sheetObject12.RowCount() < 1){//no data
                            ComShowCodeMessage("COM132501");
                        }else{
                            doActionIBSheet6(sheetObject12,formObject,IBDOWNEXCEL);
                        }
                    } else if(costLocGrpCdCombo.GetSelectCode()== "L") {//LCC
                        if(sheetObject10.RowCount() < 1){//no data
                            ComShowCodeMessage("COM132501");
                        }else{
                            doActionIBSheet5(sheetObject10,formObject,IBDOWNEXCEL);
                        }
                    } else if(costLocGrpCdCombo.GetSelectCode()== "E") {//ECC
                        if(sheetObject7.RowCount() < 1){//no data
                            ComShowCodeMessage("COM132501");
                        }else{
                            doActionIBSheet4(sheetObject7,formObject,IBDOWNEXCEL);
                        }
                    }   
                }
                break;
            case "btng_EccStatus1":
                if(sheetObject.RowCount()>0){
                    var sRow=sheetObject.GetSelectRow();
                    formObject.p_cost_yrmon.value=sheetObject.GetCellValue(sRow, "cost_yrmon");
                    formObject.p_fcntr_ecc_cd.value=sheetObject.GetCellValue(sRow, "ecc_cd");
                    formObject.p_cntr_tpsz_cd.value=sheetObject.GetCellValue(sRow, "cntr_tpsz_cd");
                    formObject.p_cntr_io_vol_sts_cd.value=sheetObject.GetCellValue(sRow, "cntr_io_vol_sts_cd");
                    formObject.p_ori_dest.value=sheetObject.GetCellValue(sRow, "ori_dest_cd").substr(0,1);
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet1');
                }
                break;
            case "btng_LccStatus1":
                if(sheetObject3.RowCount()>0){
                    var sRow=sheetObject3.GetSelectRow();
                    formObject.p_cost_yrmon.value=sheetObject3.GetCellValue(sRow, "cost_yrmon");
                    formObject.p_fcntr_ecc_cd.value=sheetObject3.GetCellValue(sRow, "lcc_cd");
                    formObject.p_cntr_tpsz_cd.value=sheetObject3.GetCellValue(sRow, "cntr_tpsz_cd");
                    formObject.p_cntr_io_vol_sts_cd.value=sheetObject3.GetCellValue(sRow, "cntr_io_vol_sts_cd");
                    doActionIBSheet2(sheetObject4,formObject,IBSEARCH);
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet4');
                }
                break;
            case "btng_RccStatus1":
                if(sheetObject5.RowCount()> 0){
                    var sRow=sheetObject5.GetSelectRow();
                    formObject.p_cost_yrmon.value=sheetObject5.GetCellValue(sRow, "cost_yrmon");
                    formObject.p_fcntr_ecc_cd.value=sheetObject5.GetCellValue(sRow, "rcc_cd");
                    formObject.p_cntr_tpsz_cd.value=sheetObject5.GetCellValue(sRow, "cntr_tpsz_cd");
                    formObject.p_cntr_io_vol_sts_cd.value=sheetObject5.GetCellValue(sRow, "cntr_io_vol_sts_cd");
                    doActionIBSheet3(sheetObject6,formObject,IBSEARCH);
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet13');
                }
                break;
            case "btng_RouteDetail1":
                if(sheetObject1.RowCount()>0){
                    var sRow=sheetObject1.GetSelectRow();
                    formObject.f_ecc_cd2.value=sheetObject1.GetCellValue(sRow, "fcntr_ecc_cd");
                    formObject.f_cntr_tpsz_cd2.value=sheetObject1.GetCellValue(sRow, "cntr_tpsz_cd");
                    //Initialize                        
                    if(sheetObject1.GetCellValue(sRow, "ori_dest_cd").substr(0,1) == 'O') formObject.f_ori_dest[0].checked=true;
                    else formObject.f_ori_dest[1].checked=true;
                    doActionIBSheet(sheetObject2,formObject,IBSEARCH);
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet2');
                }
                break;
            case "btng_RouteDetail2":
                if(sheetObject1.RowCount()>0){
                    if(sheetObject2.RowCount()>0) {
                        var selrow=sheetObject2.GetSelectRow();
                        var f_ori_dest='';
                        if(formObject.f_ori_dest[1].checked) f_ori_dest=formObject.f_ori_dest[1].value;
                        else f_ori_dest=formObject.f_ori_dest[0].value;
                        var str="f_cost_yrmon=" + sheetObject2.GetCellValue(selrow, "cost_yrmon") +
                        "&f_from_ecc=" + sheetObject2.GetCellValue(selrow, "from_ecc") +
                        "&f_to_ecc=" + sheetObject2.GetCellValue(selrow, "to_ecc") +
                        "&f_cntr_tpsz_cd=" + sheetObject2.GetCellValue(selrow, "cntr_tpsz_cd")+
                            "&f_ori_dest=" + f_ori_dest;
                        //
                        mtCntrHistoryPopup(str);
                    } else {
                         ComShowCodeMessage('COA10005', 'Sheet3');
                    }
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet2');
                }
                break;
            case "btng_RouteDetail3":
                if(sheetObject8.RowCount()>0){
                    var sRow=sheetObject8.GetSelectRow();
                    formObject.f_ecc_cd3.value=sheetObject8.GetCellValue(sRow, "fcntr_ecc_cd");
                    formObject.f_cntr_tpsz_cd3.value=sheetObject8.GetCellValue(sRow, "cntr_tpsz_cd");
                    //Initialize
                    if(sheetObject8.GetCellValue(sRow, "ori_dest") == 'O') formObject.f_ori_dest2[0].checked=true;
                    else formObject.f_ori_dest2[1].checked=true;
                    doActionIBSheet4(sheetObject9,formObject,IBSEARCH);
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet9');
                }
                break;
            case "btng_RouteDetail4":
                if(sheetObject8.RowCount()>0){
                    if(sheetObject9.RowCount()>0) {
                        var selrow=sheetObject9.GetSelectRow();
                        var f_ori_dest2='';
                        if(formObject.f_ori_dest2[1].checked) f_ori_dest2=formObject.f_ori_dest2[1].value;
                        else f_ori_dest2=formObject.f_ori_dest2[0].value;
                        var str="f_cost_yrmon=" + sheetObject9.GetCellValue(selrow, "cost_yrmon") +
                        "&f_from_ecc=" + sheetObject9.GetCellValue(selrow, "from_ecc") +
                        "&f_to_ecc=" + sheetObject9.GetCellValue(selrow, "to_ecc") +
                        "&f_cntr_tpsz_cd=" + sheetObject9.GetCellValue(selrow, "cntr_tpsz_cd")+
                            "&f_ori_dest=" + f_ori_dest2;
                        //
                        mtCntrHistoryPopup(str);
                    } else {
                         ComShowCodeMessage('COA10005', 'Sheet10');
                    }
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet9');
                }
                break;
            case "btng_EccStatus2":
                if(sheetObject7.RowCount()>0){
                    var sRow=sheetObject7.GetSelectRow();
                    formObject.p_cost_yrmon.value=sheetObject7.GetCellValue(sRow, "cost_yrmon");
                    formObject.p_fcntr_ecc_cd.value=sheetObject7.GetCellValue(sRow, "ecc_cd");
                    formObject.p_cntr_tpsz_cd.value=sheetObject7.GetCellValue(sRow, "cntr_tpsz_cd");
                    formObject.p_cntr_io_vol_sts_cd.value=sheetObject7.GetCellValue(sRow, "cntr_io_vol_sts_cd");
                    formObject.p_ori_dest.value=sheetObject7.GetCellValue(sRow, "ori_dest").substr(0,1);
                    doActionIBSheet4(sheetObject8,formObject,IBSEARCH);
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet8');
                }
                break;
            case "btng_LccStatus2":
                if(sheetObject10.RowCount()>0){
                    var sRow=sheetObject10.GetSelectRow();
                    formObject.p_cost_yrmon.value=sheetObject10.GetCellValue(sRow, "cost_yrmon");
                    formObject.p_fcntr_ecc_cd.value=sheetObject10.GetCellValue(sRow, "lcc_cd");
                    formObject.p_cntr_tpsz_cd.value=sheetObject10.GetCellValue(sRow, "cntr_tpsz_cd");
                    formObject.p_cntr_io_vol_sts_cd.value=sheetObject10.GetCellValue(sRow, "cntr_io_vol_sts_cd");
                    doActionIBSheet5(sheetObject11,formObject,IBSEARCH);
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet11');
                }
                break;
            case "btng_RccStatus2":
                if(sheetObject12.RowCount()> 0){
                    var sRow=sheetObject12.GetSelectRow();
                    formObject.p_cost_yrmon.value=sheetObject12.GetCellValue(sRow, "cost_yrmon");
                    formObject.p_fcntr_ecc_cd.value=sheetObject12.GetCellValue(sRow, "rcc_cd");
                    formObject.p_cntr_tpsz_cd.value=sheetObject12.GetCellValue(sRow, "cntr_tpsz_cd");
                    formObject.p_cntr_io_vol_sts_cd.value=sheetObject12.GetCellValue(sRow, "cntr_io_vol_sts_cd");
                    doActionIBSheet6(sheetObject13,formObject,IBSEARCH);
                } else {
                     ComShowCodeMessage('COA10005', 'Sheet13');
                }
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
             ComShowCodeMessage(OBJECT_ERROR);
        } else {
             ComShowCodeMessage(e);
        }
    }
}
 /**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage(frmECC) {
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    // handling multi-combo object
    // ---------------------------------------------
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode=false;
}   
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    sheetObj.UseUtf8=true;
    var cnt=0;
    switch(sheetNo) {
        case 1: //sheet1 init
            with(sheetObj){
              var HeadTitle="H_YM|ECC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|MT Transit Time|MT Transit Time";
              var HeadTitle1="H_YM|ECC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Unit Cost|AMT|Unit Cost|AMT|T.Time|Total Days" ;

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ecc_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_status" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_io_vol_sts_cd" },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"imbal_rto",           KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ori_dest_cd" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol",                 KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sim_stvg_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_steve",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sim_trsp_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_trans",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_tz_hrs",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"calcu_days",          KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
              //SetRangeBackColor(1, 8, 1, 13,"#DEFBF8");
              SetHeaderRowHeight(10);
              SetSheetHeight(140) ;
          }


            break;
        case 2: //sheet2 init
            with(sheetObj){
              var HeadTitle="H_YM|ECC|H_O/D|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fcntr_ecc_cd" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ori_dest_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_status" },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_rto",  KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_ib_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_ob_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SetSheetHeight(80) ;
          }


            break;
        case 3: //sheet3 init
            with(sheetObj){
              var HeadTitle="H_YM|From|To|TP/SZ|Vol.|within conti|within conti|within conti|whole route|whole route|whole route";
              var HeadTitle1="H_YM|From|To|TP/SZ|Vol.|MT Steve.|MT Trans.|MT Days|MT Steve.|MT Trans.|MT Days";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"from_ecc" },
                     {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"to_ecc" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Int",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vol" },
                     {Type:"Int",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"conti_steve",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"conti_trans",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"conti_days",    KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Int",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"mvmt_steve",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"mvmt_trans",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mvmt_days",     KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
              //SetRangeBackColor(1, 4, 1, 10,"#DEFBF8");
              SetSheetHeight(160) ;
          }


            break;
        case 4: //sheet4 init
            with(sheetObj){
              var HeadTitle="H_YM|LCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|MT Transit Time|MT Transit Time";
              var HeadTitle1="H_YM|LCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Unit Cost|AMT|Unit Cost|AMT|T.Time|Total Days" ;

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_status" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_io_vol_sts_cd" },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"imbal_rto",           KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ori_dest" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol",                 KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sim_stvg_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_steve",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sim_trsp_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_trans",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sim_tz_dys",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"calcu_days",          KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
//                    SetRangeBackColor(1, 8, 1, 13,"#DEFBF8");
              SetHeaderRowHeight(10);
              SetSheetHeight(160) ;
          }


            break;
        case 5: //sheet5 init
            with(sheetObj){
              var HeadTitle="H_YM|LCC|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fcntr_ecc_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_status" },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_rto",  KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_ib_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_ob_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SetSheetHeight(80) ;
          }


            break;
        case 6: //sheet6 init
            with(sheetObj){
              var HeadTitle="H_YM|RCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|MT Transit Time|MT Transit Time";
              var HeadTitle1="H_YM|RCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Unit Cost|AMT|Unit Cost|AMT|T.Time|Total Days" ;

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_status" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_io_vol_sts_cd" },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"imbal_rto",           KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ori_dest" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol",                 KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sim_stvg_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_steve",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sim_trsp_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_trans",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"sim_tz_dys",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"calcu_days",          KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
//                    SetRangeBackColor(1, 8, 1, 13,"#DEFBF8");
              SetHeaderRowHeight(10);
              SetSheetHeight(160) ;
          }


            break;
        case 7: //sheet7 init
            with(sheetObj){
              var HeadTitle="H_YM|RCC|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fcntr_ecc_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_status" },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_rto",  KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_ib_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_ob_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SetSheetHeight(80) ;
          }


            break;
        case 8: //sheet8 init
            with(sheetObj){
              var HeadTitle="H_YM|ECC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|MT Transit Time|MT Transit Time";
              var HeadTitle1="H_YM|ECC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Unit Cost|AMT|Unit Cost|AMT|T.Time|Total Days" ;

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ecc_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_status" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_io_vol_sts_cd" },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"imbal_rto",           KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ori_dest" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol",                 KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_stvg_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_steve",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_trsp_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_trans",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_tz_hrs",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"calcu_days",          KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
//                    SetRangeBackColor(1, 8, 1, 13,"#DEFBF8");
              SetHeaderRowHeight(10);
              SetSheetHeight(240) ;			//SJH.20150105.MOD
          }


            break;
        case 9: //sheet9 init
            with(sheetObj){
              var HeadTitle="H_YM|ECC|H_O/D|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fcntr_ecc_cd" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ori_dest" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_status" },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_rto",  KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_ib_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_ob_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SetSheetHeight(80) ;
          }


            break;
        case 10:    //sheet10 init
            with(sheetObj){
                var HeadTitle="H_YM|From|To|TP/SZ|Vol.|within conti|within conti|within conti|whole route|whole route|whole route";
                var HeadTitle1="H_YM|From|To|TP/SZ|Vol.|MT Steve.|MT Trans.|MT Days|MT Steve.|MT Trans.|MT Days";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},
                { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"from_ecc" },
                {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"to_ecc" },
                {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vol", Format:"Integer" },
                {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"conti_steve",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"conti_trans",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"conti_days",    KeyField:0,   CalcLogic:"",   Format:"Integer" },
                {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"mvmt_steve",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"mvmt_trans",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mvmt_days",     KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
                
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
                SetWaitImageVisible(0);
//                                                                                      SetRangeBackColor(1, 4, 1, 10,"#DEFBF8");
                SetSheetHeight(160) ;
            }


            break;
        case 11:    //sheet11 init
            with(sheetObj){
              var HeadTitle="H_YM|LCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|MT Transit Time|MT Transit Time";
              var HeadTitle1="H_YM|LCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Unit Cost|AMT|Unit Cost|AMT|T.Time|Total Days" ;

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_status" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_io_vol_sts_cd" },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"imbal_rto",           KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ori_dest" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol",                 KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_stvg_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_steve",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_trsp_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_trans",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_tz_hrs",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"calcu_days",          KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
//                    SetRangeBackColor(1, 8, 1, 13,"#DEFBF8");
              SetHeaderRowHeight(10);
              SetSheetHeight(140) ;
          }


            break;
        case 12:    //sheet12 init
            with(sheetObj){
              var HeadTitle="H_YM|LCC|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fcntr_ecc_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_status" },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_rto",  KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_ib_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_ob_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SetSheetHeight(80) ;
          }


            break;
        case 13:    //sheet13 init
            with(sheetObj){
              var HeadTitle="H_YM|RCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|MT Transit Time|MT Transit Time";
              var HeadTitle1="H_YM|RCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Unit Cost|AMT|Unit Cost|AMT|T.Time|Total Days" ;

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_status" },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_io_vol_sts_cd" },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"imbal_rto",           KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ori_dest" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol",                 KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_stvg_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_steve",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_trsp_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"calcu_trans",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mty_tz_hrs",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"calcu_days",          KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
//                    SetRangeBackColor(1, 8, 1, 13,"#DEFBF8");
              SetHeaderRowHeight(10);
              SetSheetHeight(140) ;
          }


            break;
        case 14:    //sheet14 init
            with(sheetObj){
              var HeadTitle="H_YM|RCC|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fcntr_ecc_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_status" },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_rto",  KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:1 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_imbal_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_ib_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_ob_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
               
              InitColumns(cols);

              SetEditable(0);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SetSheetHeight(80) ;
          }


            break;
    }
}
/**
 * Function to initialize the IBCOMBO <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
* @param {ibsheet} comboObj mandatory IBMultiCombo Object
* @param {int} comboNo mandatory  The order of the IBMultiCombo
 * @return nothing
 */ 
function initCombo(comboObj, comboId) {
     switch(comboObj.id) {
        case "f_cost_loc_grp_cd":
            with(comboObj) {
                SetDropHeight(300);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(4);
                SetUseAutoComplete(1);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
            }
            break;
        case "f_ecc_cd":
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "40");
                SetDropHeight(500);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(5);
                SetUseAutoComplete(1);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
            }
            break;
       case "f_lcc_cd":
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "40");
                SetDropHeight(500);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(5);
                SetUseAutoComplete(1);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
            }
            break;
      case "f_rcc_cd":
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "40");
                SetDropHeight(500);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(5);
                SetUseAutoComplete(1);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
            }
            break;
       case "f_cntr_tpsz_cd":
            with(comboObj) {
                SetDropHeight(500);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(3);
                SetUseAutoComplete(1);
                ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
            }
            break;
    }
}
/**
 * Registering IBSheet Object as list
 * Calling from comSheetObject(id)
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source by.yjjeon
   */
  function setComboObject(combo_obj){
      comboObjects[comboCnt++]=combo_obj;
  } 
// window double click  //////////////////////////////////
/**
* Details are viewed by double-clicking on sheet1
*/  
function sheet1_OnDblClick(sheetObj , row, col){
    var formObject=document.form;
    formObject.p_cost_yrmon.value=sheetObj.GetCellValue(row, "cost_yrmon");
    formObject.p_fcntr_ecc_cd.value=sheetObj.GetCellValue(row, "ecc_cd");
    formObject.p_cntr_tpsz_cd.value=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
    formObject.p_cntr_io_vol_sts_cd.value=sheetObj.GetCellValue(row, "cntr_io_vol_sts_cd");
    formObject.p_ori_dest.value=sheetObj.GetCellValue(row, "ori_dest_cd").substr(0,1);
    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
}
/**
* Search details with double clicking on sheet2
*/  
function sheet2_OnDblClick(sheetObj , row, col){ 
    var formObject=document.form;
    formObject.f_ecc_cd2.value=sheetObj.GetCellValue(row, "fcntr_ecc_cd");
    formObject.f_cntr_tpsz_cd2.value=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
    //origin_dest
    if((sheetObj.GetCellValue(row, "ori_dest_cd")).substr(0,1) == 'O') formObject.f_ori_dest[0].checked=true;
    else formObject.f_ori_dest[1].checked=true;
    doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
}
/**
* Open popup with double clicking on sheet3
*/
function sheet3_OnDblClick(sheetObj , row, col){
    var f_ori_dest='';
    if(document.form.f_ori_dest[1].checked) f_ori_dest=document.form.f_ori_dest[1].value;
    else f_ori_dest=document.form.f_ori_dest[0].value;
    var str="f_cost_yrmon=" + sheetObj.GetCellValue(row, "cost_yrmon") +
    "&f_from_ecc=" + sheetObj.GetCellValue(row, "from_ecc") +
    "&f_to_ecc=" + sheetObj.GetCellValue(row, "to_ecc") +
    "&f_cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd")+
                "&f_ori_dest=" + f_ori_dest;
    mtCntrHistoryPopup(str);
}
/**
* Search details with double clicking on sheet4
*/
function sheet4_OnDblClick(sheetObj , row, col){
    var formObject=document.form;
    formObject.p_cost_yrmon.value=sheetObj.GetCellValue(row, "cost_yrmon");
    formObject.p_fcntr_ecc_cd.value=sheetObj.GetCellValue(row, "lcc_cd");
    formObject.p_cntr_tpsz_cd.value=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
    formObject.p_cntr_io_vol_sts_cd.value=sheetObj.GetCellValue(row, "cntr_io_vol_sts_cd");
    doActionIBSheet2(sheetObjects[4],formObject,IBSEARCH);
}
/**
* Search details with double clicking on sheet6
*/
function sheet6_OnDblClick(sheetObj , row, col){
    var formObject=document.form;
    formObject.p_cost_yrmon.value=sheetObj.GetCellValue(row, "cost_yrmon");
    formObject.p_fcntr_ecc_cd.value=sheetObj.GetCellValue(row, "rcc_cd");
    formObject.p_cntr_tpsz_cd.value=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
    formObject.p_cntr_io_vol_sts_cd.value=sheetObj.GetCellValue(row, "cntr_io_vol_sts_cd");
    doActionIBSheet3(sheetObjects[6],formObject,IBSEARCH);
}
    // window double click //////////////////////////////////
/**
* Search details with double clicking on sheet8
*/
function sheet8_OnDblClick(sheetObj , row, col){
    var formObject=document.form;
    formObject.p_cost_yrmon.value=sheetObj.GetCellValue(row, "cost_yrmon");
    formObject.p_fcntr_ecc_cd.value=sheetObj.GetCellValue(row, "ecc_cd");
    formObject.p_cntr_tpsz_cd.value=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
    formObject.p_cntr_io_vol_sts_cd.value=sheetObj.GetCellValue(row, "cntr_io_vol_sts_cd");
    formObject.p_ori_dest.value=sheetObj.GetCellValue(row, "ori_dest").substr(0,1);
    doActionIBSheet4(sheetObjects[8],formObject,IBSEARCH);
}
/**
* Search details with double clicking on sheet9
*/
function sheet9_OnDblClick(sheetObj , row, col){
    var formObject=document.form;       
    formObject.f_ecc_cd3.value=sheetObj.GetCellValue(row, "fcntr_ecc_cd");
    formObject.f_cntr_tpsz_cd3.value=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
    //origin_dest
    if((sheetObj.GetCellValue(row, "ori_dest")).substr(0,1) == 'O') formObject.f_ori_dest2[0].checked=true;
    else formObject.f_ori_dest2[1].checked=true;
    doActionIBSheet4(sheetObjects[9],formObject,IBSEARCH);
}
/**
* Open popup with double clicking on sheet10
*/
function sheet10_OnDblClick(sheetObj , row, col){
    var f_ori_dest2='';
    if(document.form.f_ori_dest2[1].checked) f_ori_dest2=document.form.f_ori_dest2[1].value;
    else f_ori_dest2=document.form.f_ori_dest2[0].value;
    var str="f_cost_yrmon=" + sheetObj.GetCellValue(row, "cost_yrmon") +
    "&f_from_ecc=" + sheetObj.GetCellValue(row, "from_ecc") +
    "&f_to_ecc=" + sheetObj.GetCellValue(row, "to_ecc") +
    "&f_cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd")+
                "&f_ori_dest=" + f_ori_dest2;
    mtCntrHistoryPopup(str);
}   
/**
* Search details with double clicking on sheet11
*/
function sheet11_OnDblClick(sheetObj , row, col){
    var formObject=document.form;
    formObject.p_cost_yrmon.value=sheetObj.GetCellValue(row, "cost_yrmon");
    formObject.p_fcntr_ecc_cd.value=sheetObj.GetCellValue(row, "lcc_cd");
    formObject.p_cntr_tpsz_cd.value=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
    formObject.p_cntr_io_vol_sts_cd.value=sheetObj.GetCellValue(row, "cntr_io_vol_sts_cd");
    doActionIBSheet5(sheetObjects[11],formObject,IBSEARCH);
}
/**
* Search details with double clicking on sheet13
*/
function sheet13_OnDblClick(sheetObj , row, col){
    var formObject=document.form;
    formObject.p_cost_yrmon.value=sheetObj.GetCellValue(row, "cost_yrmon");
    formObject.p_fcntr_ecc_cd.value=sheetObj.GetCellValue(row, "rcc_cd");
    formObject.p_cntr_tpsz_cd.value=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
    formObject.p_cntr_io_vol_sts_cd.value=sheetObj.GetCellValue(row, "cntr_io_vol_sts_cd");
    doActionIBSheet6(sheetObjects[13],formObject,IBSEARCH);
}
/**
* Handling process about the sheet object MT ECC
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:                   
            ComOpenWait(true);
            var sXml=formObj.sXml.value;                    
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0) {
                ComXml2ComboItem(arrXml[0], f_cost_loc_grp_cd, "code", "name");
                f_cost_loc_grp_cd.SetSelectIndex(0);
            }
            if (arrXml.length > 1) {
                ComXml2ComboItem(arrXml[1], f_ecc_cd, "code", "code");
                comboObjects[1].InsertItem(0, 'All', '');
                f_ecc_cd.SetSelectIndex(0);
            }
            if (arrXml.length > 2) {
                ComXml2ComboItem(arrXml[2], f_lcc_cd, "code", "code");
                comboObjects[2].InsertItem(0, 'All', '');
                f_lcc_cd.SetSelectIndex(0);
            }
            if (arrXml.length > 3) {
                ComXml2ComboItem(arrXml[3], f_rcc_cd, "code", "code");
                comboObjects[3].InsertItem(0, 'All', '');
                f_rcc_cd.SetSelectIndex(0);
            }
            if (arrXml.length > 4) {
                ComXml2ComboItem(arrXml[4], f_cntr_tpsz_cd, "code", "code");
                comboObjects[4].InsertItem(0, 'All', '');
                f_cntr_tpsz_cd.SetSelectIndex(0);
            }
            ComSetObjValue(formObj.sXml, "");
            setYrMon();
            ComOpenWait(false);
            break;
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            if(sheetObj.id == "sheet1"){
                formObj.f_cmd.value=SEARCH01;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
                sheetObjects[1].RemoveAll();
            } else if (sheetObj.id == "sheet2"){
                formObj.f_cmd.value=SEARCH02;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            } else if (sheetObj.id == "sheet3"){
                formObj.f_cmd.value=SEARCH03;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            }
//	            ComOpenWait(false);
            break;
        case IBCREATE:
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=MULTI01;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0009GS.do", coaFormQueryString(formObj));
	            var statusCode=ComGetEtcData(sXml, "BatchStatus" );
	            switch(statusCode){
	                case "5":// Error 발생
	                    ComShowMessage("M/B Creation");
	                    break;
	                default: 
	                    break;                          
	            }  
	            ComOpenWait(false);
            }, 100);
            break;
        case IBDOWNEXCEL:   // Excell download
			var excelType=selectDownExcelMethod(sheetObj, "0");
            break;
    }
}

/**
* Handling process about the sheet object MT LCC
*/
function doActionIBSheet2(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:  //Inquiry
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            if(sheetObj.id == "sheet4"){
                formObj.f_cmd.value=SEARCH04;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            } else{
                formObj.f_cmd.value=SEARCH05;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            }
//	            ComOpenWait(false);
           break;
        case IBDOWNEXCEL:   // Excell download
			var excelType=selectDownExcelMethod(sheetObj, "3");
            break;
    }
}
/**
* Handling process about the sheet object MT RCC
*/
function doActionIBSheet3(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:  //Inquiry
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            if(sheetObj.id == "sheet6"){
                formObj.f_cmd.value=SEARCH06;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            } else{
                formObj.f_cmd.value=SEARCH07;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            } 
//            ComOpenWait(false);
           break;
        case IBDOWNEXCEL:   // Excell download
			var excelType=selectDownExcelMethod(sheetObj, "5");
            break;
    }
}

/**
* Handling process about the sheet object Full ECC
*/
function doActionIBSheet4(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            if(sheetObj.id == "sheet8"){
                formObj.f_cmd.value=SEARCH08;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
                sheetObjects[8].RemoveAll();
            } else if(sheetObj.id == "sheet9") {
                formObj.f_cmd.value=SEARCH09;
                //settingHiddenDate("div_period");
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            } else if(sheetObj.id == "sheet10") {
                formObj.f_cmd.value=SEARCH10;
                //settingHiddenDate("div_period");
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            }
//            ComOpenWait(false);
            break;
        case IBCOPYROW: // Row copy
            sheetObj.DataCopy();
            break;
        case IBDOWNEXCEL:   // Excell download
			var excelType=selectDownExcelMethod(sheetObj, "7");
            break;
    }
}
/**
* Handling process about the sheet object Full LCC
*/
function doActionIBSheet5(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            if(sheetObj.id == "sheet11"){
                formObj.f_cmd.value=SEARCH11;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            } else if(sheetObj.id == "sheet12"){
                formObj.f_cmd.value=SEARCH12;
                //settingHiddenDate("div_period2");
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            }
//	            ComOpenWait(false);
            break;
        case IBDOWNEXCEL:   // Excell download
			var excelType=selectDownExcelMethod(sheetObj, "10");
            break;
    }
}
/**
* Handling process about the sheet object Full RCC
*/
function doActionIBSheet6(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:  //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            if(sheetObj.id == "sheet13"){
                formObj.f_cmd.value=SEARCH13;
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            } else if(sheetObj.id == "sheet14"){
                formObj.f_cmd.value=SEARCH14;                   
                sheetObj.DoSearch("ESM_COA_0009GS.do", coaFormQueryString(formObj) );
            }
//	            ComOpenWait(false);
            break;
        case IBDOWNEXCEL:   // Excell download
			var excelType=selectDownExcelMethod(sheetObj, "12");
            break;
    }
}

/**
* Download Excel
*/
function callBackExcelMethod(excelType){  
	callBackExcelMethod2(excelType[0], excelType[1]);
}

function sheet1_OnDownFinish(downloadType, result) {
	var sheetObject1=sheetObjects[1];
	selectDownExcelMethod(sheetObject1, "1");
}

function sheet2_OnDownFinish(downloadType, result) {
	var sheetObject1=sheetObjects[2];
	selectDownExcelMethod(sheetObject1, "2");
}

function sheet4_OnDownFinish(downloadType, result) {
	var sheetObject1=sheetObjects[4];
	selectDownExcelMethod(sheetObject1, "4");
}

function sheet6_OnDownFinish(downloadType, result) {
	var sheetObject1=sheetObjects[6];
	selectDownExcelMethod(sheetObject1, "6");
}

function sheet8_OnDownFinish(downloadType, result) {
	var sheetObject1=sheetObjects[8];
	selectDownExcelMethod(sheetObject1, "8");
}

function sheet9_OnDownFinish(downloadType, result) {
	var sheetObject1=sheetObjects[9];
	selectDownExcelMethod(sheetObject1, "9");
}

function sheet11_OnDownFinish(downloadType, result) {
	var sheetObject1=sheetObjects[11];
	selectDownExcelMethod(sheetObject1, "11");
}

function sheet13_OnDownFinish(downloadType, result) {
	var sheetObject1=sheetObjects[13];
	selectDownExcelMethod(sheetObject1, "13");
}

function callBackExcelMethod2(excelType, shtNo){
    var sheetObj = sheetObjects[shtNo];
    switch (excelType) {
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
}

//function callBackExcelMethod2(excelType, shtNo){    
//    var sheetObj = sheetObjects[shtNo];
//	sheetObjects[0].Down2ExcelBuffer(true);
//	var shtLimitNo = Number(shtNo) + 2;
//	alert(0);
//    switch (excelType) {
//	    case "AY":
//	    	for(var i = shtNo; i <= shtLimitNo; i++) {
//               if ( sheetObjects[i].RowCount() > 0 ) {
//            	   sheetObjects[i].Down2Excel({HiddenColumn:0, SheetName:"Sheet" + i, SheetDesign:1,Merge:1 });
//               }
//	    	}
//	        break;
//	    case "AN":
//	    	for(var i = shtNo; i <= shtLimitNo; i++) {
//               if ( sheetObjects[i].RowCount() > 0 ) {
//            	   sheetObjects[i].Down2Excel({HiddenColumn:0, SheetName:"Sheet" + i, SheetDesign:0, Merge:0 });
//               }
//	    	}
//	    	break;
//	    case "DY":
//	    	alert(1);
//	    	alert(shtNo+"%"+shtLimitNo);
//	    	for(var i = shtNo; i <= shtLimitNo; i++) {
//               if ( sheetObjects[i].RowCount() > 0 ) {
//            	   sheetObjects[i].Down2Excel({HiddenColumn:1, SheetName:"Sheet" + i, SheetDesign:1, Merge:1 });
//               }
//	    	}
//    //	    	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
//	    	break;
//	    case "DN":
//	    	for(var i = shtNo; i <= shtLimitNo; i++) {
//               if ( sheetObjects[i].RowCount() > 0 ) {
//            	   sheetObjects[i].Down2Excel({HiddenColumn:1, SheetName:"Sheet" + i, SheetDesign:0, Merge:0 });
//               }
//	    	}
////	    	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
//	    	break;
//	}
//	sheetObjects[0].Down2ExcelBuffer(false);
//}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet3_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet4_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet5_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet6_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet7_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet8_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet9_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet10_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    sheetObj.SetSumText(1, "TOTAL");
//	sheetObj.SetSumValue(0, "TOTAL");
}

function sheet11_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet12_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet13_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet14_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

/**
 * Handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    if(formObj.f_cost_yrmon.value == "") {
        ComShowCodeMessage('COA10002', 'YYYY-MM');
        ComSetFocus(formObj.f_cost_yrmon);
        return false;   
    }
    if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
        ComShowCodeMessage('COM12180');
        ComSetFocus(formObj.f_cost_yrmon);
        return false;   
    } else {
        return true;
    }
    if (f_ecc_cd.GetSelectText()== ""){
        ComShowCodeMessage('COA10002', 'ECC Code');
        ComSetFocus(formObj.f_cost_yrmon);          
        f_ecc_cd.Focus();           
        return false;
    }
    return true;
}
/**
        * window conversion
 */
function changeSheet( kind ){
    for(var k=0; k<11; k++)
        if(sheetObjects[k].RowCount()>0) sheetObjects[k].removeAll();
    if ( kind == "1" ) { //FUll
        div_mt.style.display="none";
        div_full.style.display="inline";
        if(comboObjects[0].GetSelectCode()== "E") {//Ecc
            full_rcc_sheet.style.display="none";
            full_lcc_sheet.style.display="none";
            full_ecc_sheet.style.display="inline";                  
        } else if(comboObjects[0].GetSelectCode()== "L") {//Lcc
            full_rcc_sheet.style.display="none";
            full_lcc_sheet.style.display="inline";
            full_ecc_sheet.style.display="none";                
        } else {//RCC
            full_rcc_sheet.style.display="inline";
            full_lcc_sheet.style.display="none";
            full_ecc_sheet.style.display="none";                
        }
    } else if ( kind == "2") {//MT
        div_mt.style.display="inline";
        div_full.style.display="none";
        if(comboObjects[0].GetSelectCode()== "E") {//Ecc
            mt_rcc_sheet.style.display="none";
            mt_lcc_sheet.style.display="none";
            mt_ecc_sheet.style.display="inline";                
        } else if(comboObjects[0].GetSelectCode()== "L") {//Lcc
            mt_rcc_sheet.style.display="none";
            mt_lcc_sheet.style.display="inline";
            full_ecc_sheet.style.display="none";                
        } else {//RCC
            mt_rcc_sheet.style.display="inline";
            mt_lcc_sheet.style.display="none";
            mt_ecc_sheet.style.display="none";                  
        }
    } 
    document.form.f_cost_yrmon.focus();
}
/**
 * In case of clicking origin/dest radio button (click on MT Simulated)
 */
function reSearch(){        
    var formObject=document.form;
    doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
}
/**
 * In case of clicking origin/dest radio button (click on the Full)
 */
function reSearch2(){       
    var formObject=document.form;
    doActionIBSheet4(sheetObjects[9],formObject,IBSEARCH);
}
/**
        * Open window 
 */
function mtCntrHistoryPopup(str){
    ComOpenWindow2("ESM_COA_0010.do?" + str,'', 'width=800, height=587, menubar=no, scrollbars=yes, resizable=yes');
}
/**
 * Function is called when the onChange event occurs  <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj mandatory IBSheet Combo Object
 * @param {int} code mandatory  Code in case of the Onclick event
 * @return nothing
 */
function f_cost_loc_grp_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;
    //ecc, rcc hidden
    if(NewCode == 'R'){//RCC
        //Combo box:rcc combo activate
        div_rcc.style.display="inline";
        div_lcc.style.display="none";
        div_ecc.style.display="none";
        div_combo_title.innerHTML = "RCC";
          if(formObj.kind[1].checked) {//mt
            //sheet:sheet3 activate
            mt_rcc_sheet.style.display="inline";
            mt_lcc_sheet.style.display="none";
            mt_ecc_sheet.style.display="none";
          } else {//full
            full_rcc_sheet.style.display="inline";
            full_lcc_sheet.style.display="none"; 
            full_ecc_sheet.style.display="none";               
          }    
    } else if(NewCode == 'L'){//LCC
        //Combo box:lcc combo activate
        div_rcc.style.display="none";
        div_lcc.style.display="inline";
        div_ecc.style.display="none";
        div_combo_title.innerHTML = "LCC";
          if(formObj.kind[1].checked) {//mt
            //sheet:sheet3 activate
            mt_rcc_sheet.style.display="none";
            mt_lcc_sheet.style.display="inline";
            mt_ecc_sheet.style.display="none";
          } else {//full
            full_rcc_sheet.style.display="none";
            full_lcc_sheet.style.display="inline";
            full_ecc_sheet.style.display="none";               
          }
    } else if(NewCode == 'E'){//ECC
        //Combo box:ecc combo activate
        div_rcc.style.display="none";
        div_lcc.style.display="none";
        div_ecc.style.display="inline";
        div_combo_title.innerHTML = "ECC";
        if(formObj.kind[1].checked) {//mt
            //sheet:sheet1, sheet2 activate
            mt_rcc_sheet.style.display="none";
            mt_lcc_sheet.style.display="none";
            mt_ecc_sheet.style.display="inline";
        } else {//full
            full_rcc_sheet.style.display="none";
            full_lcc_sheet.style.display="none";
            full_ecc_sheet.style.display="inline";              
        }      
    }
    comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
function f_ecc_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
function f_lcc_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
function f_rcc_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
function f_cntr_tpsz_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
/**
 * combo box activate
 */
function changeLocationHierarchy(val) {
    //ecc, rcc hidden
    if(val == 'R'){//RCC
        //Combo box:rcc combo activate
        div_rcc.style.display="inline";
        div_lcc.style.display="none";
        div_ecc.style.display="none";
          if(document.form.kind[1].checked) {//mt
            //sheet:sheet3 activate
            mt_rcc_sheet.style.display="inline";
            mt_lcc_sheet.style.display="none";
            mt_ecc_sheet.style.display="none";
          } else {//full
            full_rcc_sheet.style.display="inline";
            full_lcc_sheet.style.display="none"; 
            full_ecc_sheet.style.display="none";               
          }    
    } else if(val == 'L'){//LCC
        //Combo box:lcc combo activate
        div_rcc.style.display="none";
        div_lcc.style.display="inline";
        div_ecc.style.display="none";
          if(document.form.kind[1].checked) {//mt
            //sheet:sheet3 activate
            mt_rcc_sheet.style.display="none";
            mt_lcc_sheet.style.display="inline";
            mt_ecc_sheet.style.display="none";
          } else {//full
            full_rcc_sheet.style.display="none";
            full_lcc_sheet.style.display="inline";
            full_ecc_sheet.style.display="none";               
          }
    } else if(val == 'E'){//ECC
        //Combo box:ecc combo activate
        div_rcc.style.display="none";
        div_lcc.style.display="none";
        div_ecc.style.display="inline";
        if(document.form.kind[1].checked) {//mt
            //sheet:sheet1, sheet2 activate
            mt_rcc_sheet.style.display="none";
            mt_lcc_sheet.style.display="none";
            mt_ecc_sheet.style.display="inline";
        } else {//full
            full_rcc_sheet.style.display="none";
            full_lcc_sheet.style.display="none";
            full_ecc_sheet.style.display="inline";              
        }
    }
}
/**
* Retrieve sheet in case of clicking keyEnter
*/
function changeSearchSheet(){
    if(ComGetEvent("keyCode") == 13){
        var fObj=document.form;
        if(document.form.kind[1].checked) {//mt
           if(comboObjects[0].GetSelectCode()== "R") {//RCC
                doActionIBSheet3(sheetObjects[5],fObj,IBSEARCH);    
           } else if(comboObjects[0].GetSelectCode()== "L") {//LCC
                doActionIBSheet2(sheetObjects[3],fObj,IBSEARCH);    
           } else if(comboObjects[0].GetSelectCode()== "E") {//ECC
              doActionIBSheet(sheetObjects[0],fObj,IBSEARCH);
           }            
        } else if(document.form.kind[0].checked){//full
            if(comboObjects[0].GetSelectCode()== "R") {//RCC
                doActionIBSheet6(sheetObjects[12],fObj,IBSEARCH);
            } else if(comboObjects[0].GetSelectCode()== "L") {//LCC
                doActionIBSheet5(sheetObjects[10],fObj,IBSEARCH);
            } else if(comboObjects[0].GetSelectCode()== "E") {//ECC
                doActionIBSheet4(sheetObjects[7],fObj,IBSEARCH);
            }
        }
    }
}
/**
 * Handling about hidden values of the sheet
 */
function settingHiddenDate(divname){
    var ym=document.form.f_cost_yrmon.value;
    ym=ym.replace(/\/|\-|\./g,"");
    var year=ym.substring(0,4);
    var month=ym.substring(4,6);
    y=ComParseInt(year);
    m=ComParseInt(month);
    if(m>=3){   m=m-2;}
    else {//change last year
        y=y-1;
        if(m==1) m=11;
        else if(m==2) m=12;
    }
    year=y + '';
    if(m<10) month='0' + m;
    else month=m + '';
    var tmp=year + month + ' ~ ' + ym;
    document.getElementById(divname).innerHTML="" + tmp;
}
function sheet1_OnSaveEnd(sheetObj, errMsg){
    if(ErrMsg == ""){
        // [COA10006] : The processes was completed
        ComShowMessage(ComGetMsg("COA10006"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }
}
/**
 * Setting this month
 * setYrMon()
 *
 * @param NONE
 * @return NONE
 */
function setYrMon(){
    var formObj=document.form;
    with(formObj){
        var nowYear=ComGetNowInfo("yy");
        var nowMon=ComGetNowInfo("mm");
        if ( nowMon.length == 1 ) nowMon="0" + nowMon; // conversion : 1month -> 01month 
        var nowYrMon=nowYear + nowMon;
        f_cost_yrmon.value=nowYrMon;
        f_cost_yrmon.dataformat="ym";
        //isValidYYYYMM(f_yearweek,true,'-',true);
        if(!ComAddSeparator(f_cost_yrmon)) return false;
    }
}
