/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0335.js
*@FileTitle  : Customs Entry Type Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
        case "btn_Retrieve":
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            break;
        case "btn_Select":
            doActionIBSheet(sheetObjects[0],formObject,SEARCH11);
            break;
        case "btn_Add":
            doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
            break;
        case "btn_Del":
            doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
            break;
        case "btn_Save":
            doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
            break;
        case "btn_Close":
            ComClosePopup(); 
            break;
        case "btn_downexcel":
        	if(sheetObjects[0].RowCount() < 1){//no data
        		ComShowCodeMessage("COM132501");
       	    } else{
       	    	doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
       	    }
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
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
    /**
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen.
    */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);         
        ComEndConfigSheet(sheetObjects[i]);
    }
    ComBtnDisable("btn_Save");
    sheet1_OnLoadFinish();
}
/**
 * Sheet1 
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
    var form=document.form;
    /*if (form.view_type.value=='create') {
        ComBtnEnable("btn_Del");
        ComBtnEnable("btn_Add");
    }else {
        ComBtnDisable("btn_Del");
        ComBtnDisable("btn_Add");
        ComBtnDisable("btn_Save");
    }*/
    //if (form.cnt_cd.value.length > 1) doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    //axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	//var sheetObject1=sheetObjects[0];
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
    case "sheet1":      //sheet1 init
        with(sheetObj){
              var HeadTitle1="flag|Sel.|Seq.|Code|Name|Country";
              var headCount=ComCountHeadTitle(HeadTitle1);
        
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1} );//, SizeMode:1
        
              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
        
              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cstms_entr_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                     {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"entr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"cnt_cd" } ];
              //if (location.href.indexOf("pgmNo=ESM_BKG_0335_Q") > 0 ){
              //  GetColHidden("Sel") = true;
             // }
         
              InitColumns(cols);
        
              SetEditable(1);
              //varGetCellEditable1=false;
              //if(document.form.view_type.value=='create')GetCellEditable1=true;
              SetSheetHeight(ComGetSheetHeight(sheetObj, 6));
              ComResizeSheet(sheetObj);
            }


    break;
    }
}
//handling of Sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
    case IBSEARCH:      // retrieve
        formObj.f_cmd.value=SEARCH;
        if(validateForm(sheetObj,formObj,sAction)) {
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchData("ESM_BKG_0335GS.do", FormQueryString(formObj));
            ///sheetObjects[0].RenderSheet(0);
            sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
            ///sheetObjects[0].RenderSheet(1);
            //ComOpenWait(false);
        }
        ComBtnDisable("btn_Save");
        break;
    case IBINSERT:      // insert
        sheetObj.DataInsert(-1);
        ComBtnEnable("btn_Save");
        break;
    case IBDELETE:
        ComRowHideDelete(sheetObj,"Sel");
        ComBtnEnable("btn_Save");
        break;
    case IBSAVE:    // save
        if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI;
            ComBtnDisable("btn_Save");
            sheetObj.DoSave("ESM_BKG_0335GS.do", FormQueryString(formObj), -1, false);
            //ComOpenWait(false);
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }
        break;
    case SEARCH11:  // SELECT           
//        select(sheetObj, sheetObj.selectRow, '');
        select(sheetObj, sheetObj.GetSelectRow(), '');
        break;  
    case IBDOWNEXCEL: // excel
        if(!validateForm(sheetObj,formObj,sAction)) return false;
        var columnSkipList="";
        columnSkipList="ibflag|Sel|cnt_cd";
        if(sheetObj.RowCount() < 1){//no data
          ComShowCodeMessage("COM132501");
        }else{
			sheetObj.SetHeaderBackColor("#CCCCCC");
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			sheetObj.SetHeaderBackColor("#333333");
        }
    break;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if (formObj.cnt_cd.value.length < 2) {
            ComShowCodeMessage('BKG00186');
            formObj.cnt_cd.focus();
            return false;
        }
    }
    return true;
}
/**
 * process input key 
 * @return
 */
//function obj_keypress(){
//    obj=event.srcElement;
//    if(obj.dataformat == null) return;
//    window.defaultStatus=obj.dataformat;
//    switch(obj.dataformat) {
//    case "ymd":
//    case "ym":
//    case "hms":
//    case "hm":
//    case "jumin":
//    case "saupja":
//        ComKeyOnlyNumber(obj);
//        break;
//    case "int":
//        if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
//        else ComKeyOnlyNumber(obj);
//        break;
//    case "float":
//        ComKeyOnlyNumber(obj, "-.");
//        break;
//    case "eng":
//        ComKeyOnlyAlphabet(); break;
//    case "engup":
//        ComKeyOnlyAlphabet('upper'); break;
//    case "engupnum":
//        ComKeyOnlyAlphabet('uppernum'); break;
//    case "engdn":
//        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
//        else ComKeyOnlyAlphabet('lower');
//        break;
//    }
//}
/**
 * sheet Change event
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){
    var formObject=document.form;
    sheetObj.SetWaitImageVisible(0);
    try {
        sheetObj.SetCellValue(Row, Col,sheetObj.GetCellValue(Row, Col).toUpperCase());
        sheetObj.SetCellValue(Row, "cnt_cd",formObject.cnt_cd.value);
    }catch(e) {}
    if (formObject.view_type.value=='create') ComBtnEnable("btn_Save");
}
/**
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col) {
    sheetObj.CheckAll("Sel",0);
    sheetObj.SetCellValue(Row, "Sel",1);
    selRow=Row;
}
/**
 * select button click
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function select(sheetObj,Row,Col) {
if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'cstms_entr_cd').length < 1) {
    }else {
        try{        
            var obj=new Object(); 
            obj.cd=sheetObj.GetCellValue(Row, "cstms_entr_cd");
            //window.returnValue=obj.cd;
            ComPopUpReturnValue(obj);
            ComClosePopup(); 
        }catch(e){}
    }
}


