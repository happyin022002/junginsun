/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0170.js
*@FileTitle  : RMK POPUP
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1_maxRows=25; 
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
    /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btng_Downexcel":
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                }
                break;
            case "bu_zoom_in1":
                if(sheetObject.LastRow()>sheet1_maxRows){
                    sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, sheetObject.SearchRows()+2));
                    div_zoom_out1.style.display="inline";
                    div_zoom_in1.style.display="none";
                }
                break;
            case "bu_zoom_out1":
                if(sheetObject.LastRow()>sheet1_maxRows){
                    sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, sheet1_maxRows));
                    div_zoom_in1.style.display="inline";
                    div_zoom_out1.style.display="none";
                }
                break;
            case "btng_Close":
                ComClosePopup(); 
                break;                  
        } // end switch
    }catch(e) {
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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:  //sheet1 init
            with(sheetObj){
                var HeadTitle="Node/Link|Activity Group|Account|Cost Element|Source\nCode|Source Code Description/Activity|Type\nSize|Amount|Ctrt/Avg|Remark|SEQ" ;
                
                //SJH.20141204.MOD : PAGE 20-> 10000 : 다른대책 찾아보기..
                SetConfig( { SearchMode:2, MergeSheet:2, Page:10000, FrozenCol:0, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"nod_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"grp",              KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stnd_cost_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:135,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_nm",     KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"coa_cost_src_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:1,   SaveName:"coa_cost_src_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_rtn_flg",     KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"cost_calc_rmk",    KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:1, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"acct_dp_seq",      KeyField:0,   CalcLogic:"",   Format:"" } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
                SetHeaderRowHeight("30" );
                SetSheetHeight(ComGetSheetHeight(sheetObj, sheet1_maxRows));
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
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/*To retrieve when the screen is loaded */
function setRetrieveAction(){
    sheetObject=sheetObjects[0];
    formObject=document.form;
    doActionIBSheet(sheetObject,formObject,IBSEARCH);
}
/**
 * handling sheet row size 
 */
function changeSheetRows(){
    var windowHeight=0;
    var calcuRows=0;
    sheetObj=sheetObjects[0];
    if (parseInt(navigator.appVersion())>3) {
      if (navigator.appName=="Netscape") { 
        windowHeight=window.innerHeight-16; 
      } 
      if (navigator.appName.indexOf("Microsoft")!=-1) { 
        windowHeight=document.body.offsetHeight-20; 
      } 
    }       
    calcuRows=Math.round(windowHeight/sheetObj.GetRowHeight(2)) - 7;
    //Size of difference
    if(sheet1_maxRows < calcuRows) 
    sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, calcuRows));
}
/**
* When the sheet loading is complete
*/
function sheet1_OnSearchEnd(sheetObj, errMessge) {
    //Display yellow color : DEM/DET, MISC OP Rev
    ComOpenWait(false);
    if(sheetObj.SetCellValue(1, "grp") == '') sheetObj.GetRowBackColor(1,"#FFFFB4");
    if(sheetObj.SetCellValue(2, "grp") == '') sheetObj.GetRowBackColor(2,"#FFFFB4");
    sheetObj.SelectCell(3, 0);//Focus at the first part of the expense
}
/**
 * Handling process about the sheet object
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:   //Inquiry
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCHLIST01;
            sheetObj.DoSearch("ESM_COA_0170GS.do", coaFormQueryString(formObj) );
            ComOpenWait(false);

            if (!opener) opener=parent;

            if(opener.form.f_pro_lvl.value == "C"){
             sheetObj.SetRowHidden(1,1);
            }
            break;
        case IBCOPYROW:     // Row copy
            sheetObj.DataCopy();
            break;
        case IBDOWNEXCEL:       // Excell download
            formObj.f_cmd.value="";
            var excelType=selectDownExcelMethod(sheetObj);
            break;
    }
}

function callBackExcelMethod(excelType){
	 switch (excelType) {
	    case "AY":
	        sheetObjects[0].Down2Excel({ HiddenColumn:0,Merge:true});
	        break;
	    case "DY":
	   	 sheetObjects[0].Down2Excel({ HiddenColumn:-1,Merge:true});
	        break;
	    case "AN":
	   	 sheetObjects[0].Down2Excel({ HiddenColumn:0});
	        break;
	    case "DN":
	   	 sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
	        break;
	 }
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
