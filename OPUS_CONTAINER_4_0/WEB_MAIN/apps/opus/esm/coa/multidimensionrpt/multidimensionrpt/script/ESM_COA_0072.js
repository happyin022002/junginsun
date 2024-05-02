/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0072.js
*@FileTitle  : Inquire Weekly Sales Report By Office 3
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var sheet_selno="1"; //Selected SHEET ==> 1:By Account, 2:By Lane/BND, 3:By VVD
var sheet_height=250; // sheet1 height	SJH.20141230.MOD
var gHeadCode1=""; // sheet1 header
var gHeadCode2=""; // sheet2 header
var gHeadCode3=""; // sheet3 header
//When you change the Fixed Header, it influence on sheet_OnSearchEnd() 
var fixHeadCnt1=4; // sheet1 fixed header count
var fixHeadCnt2=7; // sheet2 fixed header count
var fixHeadCnt3=12; // sheet3 fixed header count
var zoomFlag1="close"; // Zoom Flag #1
var zoomFlag2="close"; // Zoom Flag #2
var zoomFlag3="close"; // Zoom Flag #3
var first_load1=true;  //Setting  sheet1 height on first loading
var first_load2=true;  //Setting  sheet2 height on first loading
var first_load3=true;  //Setting  sheet3 height on first loading
/* Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name
function processButtonClick() {
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    var sheetObject3=sheetObjects[2];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_retrieve":
                if (sheet_selno == "1") { //The 1st sheet
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                } else if (sheet_selno == "2") { //The 2nd sheet
                    doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
                } else if (sheet_selno == "3") { //The 3rd sheet
                    doActionIBSheet3(sheetObject3,formObject,IBSEARCH);
                }
                break;
            case "btn_downexcel":
                if (sheet_selno == "1") { //The 1st sheet
                    doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "2") { //The 2nd sheet
                    doActionIBSheet2(sheet2,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "3") { //The 3rd sheet
                    doActionIBSheet3(sheet3,formObject,IBDOWNEXCEL);
                }
                break;
            case "bu_zoom_in": //SJH.20141230.MOD
                if (sheet_selno == "1") { //The 1st sheet
                	getToggleSheetHeight(sheetObject1, (sheetObject1.GetSheetHeight(sheet_height) * 2), div_zoom_in, div_zoom_out, "none", "inline", "0");
                } else if (sheet_selno == "2") { //The 2nd sheet
                	getToggleSheetHeight(sheetObject2, (sheetObject2.GetSheetHeight(sheet_height) * 2), div_zoom_in, div_zoom_out, "none", "inline", "0");
                } else if (sheet_selno == "3") { //The 3rd sheet
                	getToggleSheetHeight(sheetObject3, (sheetObject3.GetSheetHeight(sheet_height) * 2), div_zoom_in, div_zoom_out, "none", "inline", "0");
                }
            	break;
            case "bu_zoom_out": //SJH.20141230.MOD
                if (sheet_selno == "1") { //The 1st sheet
                	getToggleSheetHeight(sheetObject1, sheet_height, div_zoom_in, div_zoom_out, "inline", "none", "1");
                } else if (sheet_selno == "2") { //The 2nd sheet
                	getToggleSheetHeight(sheetObject2, sheet_height, div_zoom_in, div_zoom_out, "inline", "none", "1");                    
                } else if (sheet_selno == "3") { //The 3rd sheet
                	getToggleSheetHeight(sheetObject3, sheet_height, div_zoom_in, div_zoom_out, "inline", "none", "1");
                } 
                break;
            case "f_rdotype":
                //document.getElementById("tabLayer1").style.display = "inline";
                if (formObject.f_rdotype[0].checked) { //By Account
                    sheet_selno=formObject.f_rdotype[0].value;
                    tabLayer1.style.display="inline";
                    tabLayer2.style.display="none";
                    tabLayer3.style.display="none";
                    div_locl.style.display="inline";                     
                } else if (formObject.f_rdotype[1].checked) { //By Lane/BND
                    sheet_selno=formObject.f_rdotype[1].value;
                    tabLayer1.style.display="none";
                    tabLayer2.style.display="inline";
                    tabLayer3.style.display="none";
                    div_locl.style.display="none";                  
                } else if (formObject.f_rdotype[2].checked) { //By VVD
                    view_rhq();
                    sheet_selno=formObject.f_rdotype[2].value;
                    tabLayer1.style.display="none";
                    tabLayer2.style.display="none";
                    tabLayer3.style.display="inline";
                    div_locl.style.display="none";                     
                }
                resizeSheet();
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
 * Sheet default setting and Initialize
 */
function loadPage(hCode1,hName1,hCode2,hName2,hCode3,hName3) {
    var headCode="";
    var headName="";
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        if (i==0) {
            headCode=hCode1;
            headName=hName1;
        } else if (i==1) {
            headCode=hCode2;
            headName=hName2;
        } else if (i==2) {
            headCode=hCode3;
            headName=hName3;
        }
        initSheet(sheetObjects[i], i+1, headCode, headName);
        ComEndConfigSheet(sheetObjects[i]);
    }
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    // handling multi-combo object
    //---------------------------------------------
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k], comboObjects[k].options.id);
    }
    //---------------------------------------------
    loadingMode=false;
    tabLayer2.style.display="none";
    tabLayer3.style.display="none";
    sheet_selno="1"; //default: By Account
    setCobDisplay();
//    setZoom();			//SJH.20141230.MOD
}
 /**
 * initializing Tab
 * setting Tab items
*/
function initCombo (comboObj, comboId) {
    with (comboObj) {
        SetDropHeight(300);
        SetSelectIndex(0);
    }
}
/**
 * Initialize sheet and define header info
 */
function initSheet(sheetObj, sheetNo, headCode, headName) {
    var formObj=document.form;
    var cnt=0;
    var varCnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            gHeadCode1 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
            var arrHead = headName.replace(/(^\s*)/g,'').split("|");
            varCnt = arrHead.length - 1;

            var headText0 = "";
            var headText1 = "";
            for (n=1; n<=varCnt; n++) {
                headText0 = headText0 + "|"+arrHead[n] + "|"+arrHead[n] + "|"+arrHead[n];
                headText1 = headText1 + "|E/B|W/B|TOT";
            }
            with(sheetObj){
                var HeadTitle0="SEQ|stnd_cost_cd|Items" + headText0 + "|Total";
                var HeadTitle1="SEQ|stnd_cost_cd|Items" + headText1 + "|Total";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:fixHeadCnt1-1, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stnd_cost_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,  TreeCol:1, LevelSaveName:"itm_name",  SaveName:"itm_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];


                for (n=0; n<varCnt; n++) {
                    cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"dir_e_amt"+(n+1),KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 ,BackColor:"#DEFBF8"});
                    cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"dir_w_amt"+(n+1),KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 ,BackColor:"#DEFBF8"});
                    cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"trd_amt"+(n+1),  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 ,BackColor:"#DEFBF8"});
                }

                cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
                
                InitColumns(cols);
                
                //SetHeaderRowHeight(10);
                SetCountPosition(0);
                SetDataLinkMouse("itm_desc" , true);
                 
                SetEditable(0);
                
                if (first_load1 == true) {
//                    SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
  				  resizeSheet();
                }
                first_load1=false;
            }
        break;
        case 2:      //sheet2 init
            gHeadCode2=headCode.substring(1).replace(/(^\s*)/g,'').split("|");
            varCnt=gHeadCode2.length;
            
            with(sheetObj){

              var HeadTitle="Seq.|Month|Trade|Sub Trade|R.Lane|IOC|DIR" + headName;

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:fixHeadCnt2, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sls_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
              var iDataType = "Text";
              
              for (n=0; n<varCnt; n++) {
                  if (gHeadCode2[n] == "LOADFACT" || gHeadCode2[n] == "RPB00000" || gHeadCode2[n] == "CMCB0000" ||
                          gHeadCode2[n] == "CMB00000" || gHeadCode2[n] == "OPCB0000" || gHeadCode2[n] == "OPB00000" ||
                          gHeadCode2[n] == "BOPB0000" || gHeadCode2[n] == "BOPB0000" ) {
                      iDataType = "Float";
                  } else {
                      iDataType = "AutoSum";
                  }
                  
                  if (gHeadCode2[n] == "LOADFACT") {
                      cols.push({Type:iDataType,  Hidden:0,  width:110,  Align:"Right",   ColMerge:0,   SaveName:"cost_amt"+(n+1),KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 ,BackColor:"#DEFBF8"});
                  } else {
                      cols.push({Type:iDataType,  Hidden:0,  width:110,  Align:"Right",   ColMerge:0,   SaveName:"cost_amt"+(n+1),KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 ,BackColor:"#DEFBF8"});
                  }
              }
              InitColumns(cols);

              SetEditable(0);
              SetCountPosition(0);
              //SetHeaderRowHeight(10);

              if (first_load2 == true) {
//                SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height2));
  				  resizeSheet();
              }
              first_load2=false;
            }           
        break;
        case 3:      //sheet3 init
            gHeadCode3=headCode.substring(1).replace(/(^\s*)/g,'').split("|");
            varCnt=gHeadCode3.length;
            
            with(sheetObj){
              var HeadTitle="SEQ|R.Month|S.Month|Week|Rhq|Trade|Sub Trade|R.Lane|IOC|Vessel|Voyage|DIR" + headName;

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:fixHeadCnt3, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"" },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sls_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cost_wk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rhq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              var iDataType="Text";
              for (n=0; n<varCnt; n++) {
                  if (gHeadCode3[n] == "LOADFACT" || gHeadCode3[n] == "RPB00000" || gHeadCode3[n] == "CMCB0000" ||
                          gHeadCode3[n] == "CMB00000" || gHeadCode3[n] == "OPCB0000" || gHeadCode3[n] == "OPB00000" ||
                          gHeadCode3[n] == "BOPB0000" || gHeadCode3[n] == "BOPB0000" ) {
                      iDataType = "Float";
                  } else {
                      iDataType = "AutoSum";
                  }
                  
                  if (gHeadCode3[n] == "LOADFACT") {
                      cols.push({Type:iDataType,  Hidden:0, width:110,  Align:"Right",   ColMerge:0,   SaveName:"cost_amt"+(n+1),KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 ,BackColor:"#DEFBF8"});
                  } else {
                      cols.push({Type:iDataType,  Hidden:0, width:110,  Align:"Right",   ColMerge:0,   SaveName:"cost_amt"+(n+1),KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 ,BackColor:"#DEFBF8"});
                  }
              }
              InitColumns(cols);

              SetEditable(0);
              SetCountPosition(0);
             // SetHeaderRowHeight(10);
              SetColHidden("rhq",1);
              if (first_load3 == true) {
//                SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height3));
  				  resizeSheet();
              }
              first_load3=false;
            }
        break;
    }
}
 /**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
*/
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * Registering IBSheet Object as list
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
    var fixCnt=fixHeadCnt1 - 1; //Except the total field after variable-length
    var supply=0;
    var load=0;
    with(sheetObj) {
        //Recalculation total amount of the L/F, RPB
        var loadR=FindText("stnd_cost_cd","LOAD0000"); // Load
        var supplyR=FindText("stnd_cost_cd","BSA00000"); // Supply
        var revR=FindText("stnd_cost_cd","REVENUE0"); // Revenue
        var t1R=FindText("stnd_cost_cd","LOADFACT"); // L/F=(Load / Supply) * 100
        var t2R=FindText("stnd_cost_cd","RPB00000"); // RPB=Revenue / Load
        var s3R=FindText("stnd_cost_cd","CMCOST00"); // Cost1 Total
        var t3R=FindText("stnd_cost_cd","CMCB0000"); // Cost1/TEU=Cost1 Total / Load
        var s4R=FindText("stnd_cost_cd","CMCTOTAL"); // CM(Net Revenue) Total
        var t4R=FindText("stnd_cost_cd","CMB00000"); // CM(Net Revenue)/TEU=CM(Net Revenue) Total / Load
        var s7R=FindText("stnd_cost_cd","BCMTOTAL"); // Branch CM(Net Revenue) Total
        var t7R=FindText("stnd_cost_cd","BCMB0000"); // Branch CM(Net Revenue)/TEU=Branch CM(Net Revenue) Total / Load
        var s5R=FindText("stnd_cost_cd","OPCOST00"); // Cost2 Total
        var t5R=FindText("stnd_cost_cd","OPCB0000"); // Cost2/TEU=Cost2 Total / Load
        var s6R=FindText("stnd_cost_cd","OPCTOTAL"); // OP(Operating Profit) Total
        var t6R=FindText("stnd_cost_cd","OPB00000"); // OP(Operating Profit)/TEU=OP(Operating Profit) Total / Load
        var s8R=FindText("stnd_cost_cd","BOPTOTAL"); // BKG OP(Operating Profit) Total
        var t8R=FindText("stnd_cost_cd","BOPB0000"); // BKG OP(Operating Profit)/TEU=OP(Operating Profit) Total / Load
        for (var i=fixCnt; i<=LastCol(); i++) {
            if (GetCellValue(1,i) == "E/B" || GetCellValue(1,i) == "W/B" || GetCellValue(1,i) == "TOT") {
                supply=(GetCellValue(supplyR,i)==null) ? 0 : GetCellValue(supplyR,i);
                load=(GetCellValue(loadR,i)==null) ? 0 : GetCellValue(loadR,i);
                if (t1R > -1) SetCellValue(t1R,i,(supply==0) ? 0 : (load / supply) * 100,0);
                if (t2R > -1 && revR > -1) SetCellValue(t2R,i,(load==0) ? 0 : GetCellValue(revR,i) / load,0);
                if (t3R > -1 && s3R > -1) SetCellValue(t3R,i,(load==0) ? 0 : GetCellValue(s3R,i) / load,0);
                if (t4R > -1 && s4R > -1) SetCellValue(t4R,i,(load==0) ? 0 : GetCellValue(s4R,i) / load,0);
                if (t7R > -1 && s7R > -1) SetCellValue(t7R,i,(load==0) ? 0 : GetCellValue(s7R,i) / load,0);
                if (t5R > -1 && s5R > -1) SetCellValue(t5R,i,(load==0) ? 0 : GetCellValue(s5R,i) / load,0);
                if (t6R > -1 && s6R > -1) SetCellValue(t6R,i,(load==0) ? 0 : GetCellValue(s6R,i) / load,0);
                if (t8R > -1 && s8R > -1) SetCellValue(t8R,i,(load==0) ? 0 : GetCellValue(s8R,i) / load,0);
            }
        }
        //Recalculation total
        supply=(GetCellValue(supplyR,"ttl_amt")==null) ? 0 : parseFloat(GetCellValue(supplyR,"ttl_amt"));
        load=(GetCellValue(loadR,"ttl_amt")==null) ? 0 : parseFloat(GetCellValue(loadR,"ttl_amt"));
        if(t1R>0) SetCellValue(t1R,"ttl_amt",(supply==0) ? 0 : (load / supply) * 100,0);
        if(t2R>0) SetCellValue(t2R,"ttl_amt",(load==0) ? 0 : parseFloat(GetCellValue(revR,"ttl_amt")) /  load,0);
        if(t3R>0) SetCellValue(t3R,"ttl_amt",(load==0) ? 0 : parseFloat(GetCellValue(s3R,"ttl_amt")) /  load,0);
        if(t4R>0) SetCellValue(t4R,"ttl_amt",(load==0) ? 0 : parseFloat(GetCellValue(s4R,"ttl_amt")) /  load,0);
        if(t7R>0) SetCellValue(t7R,"ttl_amt",(load==0) ? 0 : parseFloat(GetCellValue(s7R,"ttl_amt")) /  load,0);
        if(t5R>0) SetCellValue(t5R,"ttl_amt",(load==0) ? 0 : parseFloat(GetCellValue(s5R,"ttl_amt")) /  load,0);
        if(t6R>0) SetCellValue(t6R,"ttl_amt",(load==0) ? 0 : parseFloat(GetCellValue(s6R,"ttl_amt")) /  load,0);
        // BKG OP TEU
        if(t8R>0) SetCellValue(t8R,"ttl_amt",(load==0) ? 0 : parseFloat(GetCellValue(s8R,"ttl_amt"))/parseInt(load),0);
    }
}
function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
    with(sheetObj) {
        var loadC=0; // Load
        var supplyC=0; // Supply
        var revC=0; // Revenue
        var t1C=0; // L/F=(Load / Supply) * 100
        var t2C=0; // RPB=Revenue / Load
        var s3C=0; // Cost1 Total
        var t3C=0; // Cost1/TEU=Cost1 Total / Load
        var s4C=0; // CM(Net Revenue) Total
        var t4C=0; // CM(Net Revenue)/TEU=CM(Net Revenue) Total / Load
        var s7C=0; // Branch CM(Net Revenue) Total
        var t7C=0; // Branch CM(Net Revenue)/TEU=CM(Net Revenue) Total / Load       
        var s5C=0; // Cost2 Total
        var t5C=0; // Cost2/TEU=Cost2 Total / Load
        var s6C=0; // OP(Operating Profit) Total
        var t6C=0; // OP(Operating Profit)/TEU=OP(Operating Profit) Total / Load
        var s8C=0; // OP(Operating Profit) Total
        var t8C=0; // OP(Operating Profit)/TEU=OP(Operating Profit) Total / Load
        var arrCnt=gHeadCode2.length;
        for (var i=0; i<arrCnt; i++) {
            if (gHeadCode2[i] == "LOAD0000") { loadC=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "BSA00000") { supplyC=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "REVENUE0") { revC=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "LOADFACT") { t1C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "RPB00000") { t2C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "CMCOST00") { s3C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "CMCB0000") { t3C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "CMCTOTAL") { s4C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "CMB00000") { t4C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "BCMTOTAL") { s7C=i + fixHeadCnt2; }           
            if (gHeadCode2[i] == "BCMB0000") { t7C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "OPCOST00") { s5C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "OPCB0000") { t5C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "OPCTOTAL") { s6C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "OPB00000") { t6C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "BOPTOTAL") { s8C=i + fixHeadCnt2; }
            if (gHeadCode2[i] == "BOPB0000") { t8C=i + fixHeadCnt2; }
        }
        var Row=LastRow();
        supply=(GetCellValue(0,supplyC)==null) ? 0 : parseFloat(GetSumValue(0,supplyC));
        load=(GetCellValue(0,loadC)==null) ? 0 : parseFloat(GetSumValue(0,loadC));
//        if (t1C > 0 && loadC > 0) SetCellValue(Row,t1C,(supply==0) ? 0 : (parseFloat(GetSumValue(0,loadC)) / supply) * 100,0);
//        if (t2C > 0 && revC > 0) SetCellValue(Row,t2C,(load==0) ? 0 : parseFloat(GetSumValue(0,revC)) / load,0);

//        if (t3C > 0 && s3C > 0) SetCellValue(Row,t3C,(load==0) ? 0 : parseFloat(GetSumValue(0,s3C)) / load,0);
//        if (t4C > 0 && s4C > 0) SetCellValue(Row,t4C,(load==0) ? 0 : parseFloat(GetSumValue(0,s4C)) / load,0);
//        if (t7C > 0 && s7C > 0) SetCellValue(Row,t7C,(load==0) ? 0 : parseFloat(GetSumValue(0,s7C)) / load,0);
//        if (t5C > 0 && s5C > 0) SetCellValue(Row,t5C,(load==0) ? 0 : parseFloat(GetSumValue(0,s5C)) / load,0);
//        if (t6C > 0 && s6C > 0) SetCellValue(Row,t6C,(load==0) ? 0 : parseFloat(GetSumValue(0,s6C)) / load,0);
//        if (t8C > 0 && s8C > 0) SetCellValue(Row,t8C,(load==0) ? 0 : parseFloat(GetSumValue(0,s8C)) / load,0);

      if (t1C > 0 && loadC > 0) SetCellValue(Row,t1C,(supply==0) ? 0 : ComAddThreeDigitComma(((parseFloat(GetSumValue(0,loadC)) / supply) * 100),2),0);
      if (t2C > 0 && revC > 0) SetCellValue(Row,t2C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,revC)) / load),2),0);

      if (t3C > 0 && s3C > 0) SetCellValue(Row,t3C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s3C)) / load),2),0);
      if (t4C > 0 && s4C > 0) SetCellValue(Row,t4C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s4C)) / load),2),0);
      if (t7C > 0 && s7C > 0) SetCellValue(Row,t7C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s7C)) / load),2),0);
      if (t5C > 0 && s5C > 0) SetCellValue(Row,t5C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s5C)) / load),2),0);
      if (t6C > 0 && s6C > 0) SetCellValue(Row,t6C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s6C)) / load),2),0);
      if (t8C > 0 && s8C > 0) SetCellValue(Row,t8C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s8C)) / load),2),0);  
    }
    sheetObj.SetSumText(0,0, "TOTAL");
}
function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
    with(sheetObj) {
        var loadC=0; // Load
        var supplyC=0; // Supply
        var revC=0; // Revenue
        var t1C=0; // L/F=L/F=(Load / Supply) * 100
        var t2C=0; // RPB=Revenue / Load
        var s3C=0; // Cost1 Total
        var t3C=0; // Cost1/TEU=Cost1 Total / Load
        var s4C=0; // CM(Net Revenue) Total
        var t4C=0; // CM(Net Revenue)/TEU=CM(Net Revenue) Total / Load
        var s7C=0; // Branch CM(Net Revenue) Total
        var t7C=0; // Branch CM(Net Revenue)/TEU=Branch CM(Net Revenue) Total / Load
        var s5C=0; // Cost2 Total
        var t5C=0; // Cost2/TEU=Cost2 Total / Load
        var s6C=0; // OP(Operating Profit) Total
        var t6C=0; // OP(Operating Profit)/TEU=OP(Operating Profit) Total / Load
        var s8C=0; // OP(Operating Profit) Total
        var t8C=0; // OP(Operating Profit)/TEU=OP(Operating Profit) Total / Load
        var arrCnt=gHeadCode3.length;
        for (var i=0; i<arrCnt; i++) {
            if (gHeadCode3[i] == "LOAD0000") { loadC=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "BSA00000") { supplyC=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "REVENUE0") { revC=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "LOADFACT") { t1C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "RPB00000") { t2C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "CMCOST00") { s3C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "CMCB0000") { t3C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "CMCTOTAL") { s4C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "CMB00000") { t4C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "BCMTOTAL") { s7C=i + fixHeadCnt3; }           
            if (gHeadCode3[i] == "BCMB0000") { t7C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "OPCOST00") { s5C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "OPCB0000") { t5C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "OPCTOTAL") { s6C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "OPB00000") { t6C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "BOPTOTAL") { s8C=i + fixHeadCnt3; }
            if (gHeadCode3[i] == "BOPB0000") { t8C=i + fixHeadCnt3; }
        }
        var Row=LastRow();
        supply=(GetSumValue(0,supplyC)==null) ? 0 : parseFloat(GetSumValue(0,supplyC));
        load=(GetSumValue(0,loadC)==null) ? 0 : parseFloat(GetSumValue(0,loadC));
        
        if (t1C > 0 && loadC > 0) SetCellValue(Row,t1C,(supply==0) ? 0 : ComAddThreeDigitComma(((parseFloat(GetSumValue(0,loadC)) / supply) * 100),2),0);
        if (t2C > 0 && revC > 0) SetCellValue(Row,t2C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,revC)) / load),2),0);
        if (t3C > 0 && s3C > 0) SetCellValue(Row,t3C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s3C)) / load),2),0);
        if (t4C > 0 && s4C > 0) SetCellValue(Row,t4C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s4C)) / load),2),0);
        if (t7C > 0 && s7C > 0) SetCellValue(Row,t7C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s7C)) / load),2),0);
        if (t5C > 0 && s5C > 0) SetCellValue(Row,t5C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s5C)) / load),2),0);
        if (t6C > 0 && s6C > 0) SetCellValue(Row,t6C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s6C)) / load),2),0);
        if (t8C > 0 && s8C > 0) SetCellValue(Row,t8C,(load==0) ? 0 : ComAddThreeDigitComma((parseFloat(GetSumValue(0,s8C)) / load),2),0);
    }
    sheetObj.SetSumText(0,0, "TOTAL");
}
/**
* Change R.Lane combo in case of changing the trade
*/
function f_trd_cd_OnChange(obj) {
    obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
    if (loadingMode == true)
        return;
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if (obj.GetSelectText()!= "") {
        formObj.f_cmd.value=SEARCHLIST11;
        var sXml=sheetObj.GetSearchData("ESM_COA_0072GS4.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
            ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "code");
        f_rlane_cd.SetSelectIndex(0);
    }
}
function f_rlane_cd_OnChange(obj) {
    obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
function f_dir_cd_OnChange(obj) {
    obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
/**
 * Change the period when the year, month, week is changed
 */
function setPeriod(obj) {
    ComCoaSetPeriod(obj);
}
//Handling the profit view of the window
function f_pro_vw_OnChange(obj) {
    setCobDisplay();
    obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
function f_ofc_vw_OnChange(obj) {
    setCobDisplay();
    obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
//Handling the profit level of the window
function f_pro_lvl_OnChange(obj) {
    setCobDisplay();
    obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
//Handling  combo display of the window
function setCobDisplay() {
    var formObj=document.form;
    if (ComGetObjValue(f_pro_vw) == "P" && ComGetObjValue(f_pro_lvl) == "O") { // Trade Profit + OP
        div_chtBiz.style.display="inline";
    } else { 
        div_text.style.display="none";
        div_chtBiz.style.display="none";
    }
}
/**
* Change the office combo in case of changing the office level
*/
function f_ofc_lvl_OnChange(obj, code){
    obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
     if (loadingMode == true) return;  
     chgOffice(obj);
}
function f_ofc_cd_OnChange(obj, code){
    obj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
}
/**
* In case of changing the H/Q office 
*/
function chgOffice(obj){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if(obj.GetSelectText()!= ""){
        formObj.f_cmd.value=SEARCHLIST13;
        var sXml=sheetObj.GetSearchData("ESM_COA_0072GS4.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_ofc_cd, "code", "code");
        f_ofc_cd.SetSelectIndex(0);
    }
}
/*
 * Getting a list of the ofc_cd in case of changing on year and month values
 */
function changeCostYrmon(val){
    if(val != '') chgOffice(f_ofc_lvl);
}
//changeCostYrmon
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
        	
        	//SJH.20150106.ADD/MOD
        	formObj.f_yearM.value=ComGetNowInfo("yy");        	
            formObj.f_year.value=ComGetNowInfo("yy");
            formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
            formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=INIT;
            var sXml=document.form.sXml.value; 
            document.form.sXml.value="";
            
            var arrXml=sXml.split("|$$|");
            var State=ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key); 
            
          	//SJH.20150106.ADD/MOD
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
                ComXml2ComboItem(arrXml[3], formObj.f_pro_obj, "code", "name");
            if (arrXml.length > 4)
                ComXml2ComboItem(arrXml[4], f_ofc_lvl, "code", "name");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], f_ofc_cd, "code", "code");
            if (arrXml.length > 6)
                ComXml2ComboItem(arrXml[6], f_trd_cd, "code", "code");
            if (arrXml.length > 7)
                ComXml2ComboItem(arrXml[7], f_rlane_cd, "code", "code");
            if (arrXml.length > 8)
                ComXml2ComboItem(arrXml[8], f_dir_cd, "code", "code");
            if (arrXml.length > 9)
                ComXml2ComboItem(arrXml[9], f_chtbiz, "code", "name");
            // Setting head name
            var headCode=ComGetEtcData(arrXml[0], "headCode1"); 
            var headName=ComGetEtcData(arrXml[0], "headName1"); 
            var headCode2=ComGetEtcData(arrXml[0], "headCode2"); 
            var headName2=ComGetEtcData(arrXml[0], "headName2");
            var headCode3=ComGetEtcData(arrXml[0], "headCode3"); 
            var headName3=ComGetEtcData(arrXml[0], "headName3"); 
            if (headName != "") {
                //sheetObj.RenderSheet(0);
                sheetObjects[0] = sheetObjects[0].Reset();
                ComConfigSheet(sheetObjects[0]);
                initSheet(sheetObjects[0], 1, headCode, headName);
               // sheetObj.RenderSheet(1);
            }
            if (headName2 != "") {
                //sheetObjects[1].RenderSheet(0);
                sheetObjects[1] = sheetObjects[1].Reset();
                ComConfigSheet(sheetObjects[1]);
                initSheet(sheetObjects[1], 2, headCode2, headName2);
                //sheetObjects[1].RenderSheet(1);
            }
            if (headName3 != "") {
                //sheetObjects[2].RenderSheet(0);
                sheetObjects[2] =  sheetObjects[2].Reset();
                ComConfigSheet(sheetObjects[2]);
                initSheet(sheetObjects[2], 3, headCode3, headName3);
                //sheetObjects[2].RenderSheet(1);
            }
            //////////////////////////////////////////////////////////
            ComOpenWait(false);
            break;
        case IBSEARCH:      //Inquiry
            // check date validation
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // check the VVD 
            if(!validateCond(formObj)) return false;
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST01;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0072GS.do", coaFormQueryString(formObj));
	            var headCode=ComGetEtcData(sXml,'headCode');
	            var headName=ComGetEtcData(sXml,'headName');
	
	            if (headName != "") {                
	                sheetObjects[0].SetVisible(0);
	                sheetObjects[0] = sheetObjects[0].Reset();
	                ComConfigSheet(sheetObjects[0]);
	                initSheet(sheetObjects[0], 1, headCode, headName);
	                sheetObjects[0].SetVisible(1);
	                sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
	                sheetObjects[0].RemoveEtcData(); // Delete ETC data
	            }
	            ComOpenWait(false);
            }, 100);
            break;
        case IBDOWNEXCEL:   // Excell download
            sheetObj.ShowTreeLevel(-1); //Display all the tree
            selectDownExcelMethod(sheetObj);
            
            break;
    }
}

function callBackExcelMethod(excelType){
	    if (sheet_selno == "1") { //The 1st sheet
	    	sheetObj =sheet1;
	    } else if (sheet_selno == "2") { //The 2nd sheet
	    	sheetObj =sheet2;
	    } else if (sheet_selno == "3") { //The 3rd sheet
	    	sheetObj =sheet3;
	    }
	    switch (excelType) {
        case "AY":
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
            	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
            }
            break;
        case "DY":
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
            	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
            }
            break;
        case "AN":
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
            	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
            }
            break;
        case "DN":
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
            	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
            }
            break;
    }               

	}


// Handling process about the sheet object
function doActionIBSheet2(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:      //Inquiry
            // check date validation
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // check the VVD 
            if(!validateCond(formObj)) return false;
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST02;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0072GS2.do", coaFormQueryString(formObj));
	            var headCode=ComGetEtcData(sXml,'headCode');
	            var headName=ComGetEtcData(sXml,'headName');
	
	            if (headName != "") {
	            	sheetObjects[1].SetVisible(0);
	                sheetObjects[1] = sheetObjects[1].Reset();
	                ComConfigSheet(sheetObjects[1]);
	                initSheet(sheetObjects[1], 2, headCode, headName);
	                sheetObjects[1].SetVisible(1);
	                sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
	                sheetObjects[1].RemoveEtcData(); 
	            }
	            ComOpenWait(false);
            }, 100);
            break;
        case IBDOWNEXCEL:   // Excell download
            selectDownExcelMethod(sheetObj);
            break;
    }
}
// Handling process about the sheet object
function doActionIBSheet3(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:      //Inquiry
            // check date validation
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // check the VVD 
            if(!validateCond(formObj)) return false;
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST03;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0072GS3.do", coaFormQueryString(formObj));
	            var headCode=searchEtcData("headCode", sXml, "1");
	            var headName=searchEtcData("headName", sXml, "1");
	            if (headName != "") {
	            	sheetObjects[2].SetVisible(0);
	                sheetObjects[2] = sheetObjects[2].Reset();
	                ComConfigSheet(sheetObjects[2]);
	                initSheet(sheetObjects[2], 3, headCode, headName);
	                sheetObjects[2].SetVisible(1);
	                sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
	                sheetObjects[2].RemoveEtcData(); 
	            }
	            ComOpenWait(false);
    		}, 100);
            view_rhq();
            break;
        case IBDOWNEXCEL:   // Excell download
            selectDownExcelMethod(sheetObj);
            break;
    }
}

/**
 * Handling process for form object input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(!chkValidSearch()) return false;         
    }
    return true;
}
/**
 * Handling process for input validation
 */
function validateCond(formObj) {
    with(formObj){
        // Check for the lenth(arg2) of the argument(arg1)
        if (ComTrim(f_vsl_cd.value) != "" && ComTrim(f_vsl_cd.value).length != 4){
            ComShowMessage(ComGetMsg('COM12174','VVD First Element','4'));
            f_vsl_cd.focus();
            return false;
        }
        if (ComTrim(f_skd_voy_no.value) != "" && ComTrim(f_skd_voy_no.value).length != 4){
            ComShowMessage(ComGetMsg('COM12174','VVD Second Element','4'));
            f_skd_voy_no.focus();
            return false;
        }
    }
    return true;
}
/**
 *  Display the RHQ of the office level in the VVD view
 */
function view_rhq() {
    formObj=document.form;
    if(formObj.f_rdotype[2].checked && ComGetObjValue(f_ofc_lvl)==2) {
        sheetObjects[2].SetColHidden("rhq",0);
    } else {
        sheetObjects[2].SetColHidden("rhq",1);
    }
}


function resizeSheet(){
	var formObject = document.form;
	if (formObject.f_rdotype[0].checked) { //By Account
		ComResizeSheet(sheetObjects[0], 93);
	} else if (formObject.f_rdotype[1].checked) { //By Lane/BND
		ComResizeSheet(sheetObjects[1], 93);
	} else if (formObject.f_rdotype[2].checked) { //By VVD
		ComResizeSheet(sheetObjects[2], 93);
	}
}