/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0123.js
*@FileTitle  : Shippers transmission Schedule Management Screen
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE :  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview .
 * @author 
 */
/**
 * @extends 
 * @class ESD_SCE_0123 :  business script for ESD_SCE_0123
 */
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var prefix="sheet2_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
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
  * adding first-served functions after loading screen. 
  */
 function loadPage() {
     for(i=0;i<sheetObjects.length;i++){
          ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
    initControl();
    document.getElementById("mainTable1").style.display="";
 }
/*
 *  <br>
 * {@link #loadPage} IBSheet Object will initialize. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 
 */
function initControl() {
    DATE_SEPARATOR="/";
    var formObj=document.form; 
    axon_event.addListenerForm  ('keypress', 'fnObjKeyPress',  formObj );
    axon_event.addListenerFormat('change',   'obj_change',  formObj); 
 }
/**
 * <pre>
 *    form Element in the event of a KeyPress Event Processing.
 *    
 * </pre>
 * @return
 */ 
//function fnObjKeyPress(){
//    var obj=ComGetEvent();
//    var formObj=document.form;
//    var attr=obj.getAttribute("dataformat");
//    switch (attr){
//        case  '':
//              break;
//        case  'ymd':
//              ComKeyOnlyNumber( obj );
//              break;
//        case  'engup':
//              ComKeyOnlyAlphabet( 'upper' );
//              break;     
//        case  'engupnum':
//              ComKeyOnlyAlphabet( 'uppernum' );
//              break;   
//    }
//}
function obj_change(){
    var obj=ComGetEvent();
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if ( ComTrim(obj.value) != "" ) {
        switch(ComGetEvent("name")) {
            case "cust_trd_prnr_id":
            	formObj.f_cmd.value=SEARCH01;
            	formObj.partner_id.value=formObj.cust_trd_prnr_id.value.toUpperCase();
            	formObj.cust_trd_prnr_id.value=formObj.cust_trd_prnr_id.value.toUpperCase();
//                var sXml=sheetObjects[1].GetSearchData("ESD_SCE_0122GS.do" , SceFrmQryString(form));
            	var sXml=sheetObjects[1].GetSearchData("ESD_SCE_0120GS.do" , SceFrmQryString(form));
                if(sXml != ""){
                    var partnerName=ComGetEtcData(sXml,"partner_name");
                    var custTrdPrnrId=ComGetEtcData(sXml,"custTrdPrnrId") == "" ? "" : ComGetEtcData(sXml,"custTrdPrnrId");
                    formObj.partnerName.value=partnerName;
                    checkOption(custTrdPrnrId);
                }
                break;
        }
    } else {
        switch(ComGetEvent("name")) {
            case "cust_trd_prnr_id":
                formObj.vndr_nm.value="";
                break;
        }
    }
}

// Event handler processing by button name */
function processButtonClick() {
    var sheetObject0=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) { 
        case "btn_retrieve":
            if(formObj.cust_trd_prnr_id.value == "C1T0W"){
                doActionIBSheet(sheetObject1, formObj, IBSEARCH);
            }else{
                doActionIBSheet(sheetObject0, formObj, IBSEARCH_ASYNC01);
            }
            break;
        case "btn_new":
            sheetObject1.RemoveAll();
            sheetObject0.RemoveAll();
            formObj.cust_trd_prnr_id.value="";
            formObj.partnerName.value="";
            formObj.pol_cd.value="";
            formObj.pol_cnt.value="";
            formObj.pol_conti.value="";
            formObj.pod_cd.value="";
            formObj.pod_cnt.value="";
            formObj.pod_conti.value="";
            formObj.pol_conti_nm.value="";
            formObj.pod_conti_nm.value="";
            formObj.slan_cd.value="";
            formObj.cust_trd_prnr_id.focus();
            break;
        case "btn_save":
            doActionIBSheet(sheetObject1, formObj, IBSAVE);
            break;
        case "btn_RowAdd":
            //sheetObject1.DataCopy();  
            //doRowAdd(sheetObject1, formObj); 
            var iRow=sheetObjects[1].DataInsert();
            var i=sheetObject1.selectRow;
            //key
            if(i == 2){
                sheetObject1.SetCellValue(i,prefix+"cust_trd_prnr_id","");
                sheetObject1.SetCellValue(i,prefix+"pol_cd","");
                sheetObject1.SetCellValue(i,prefix+"pod_cd","");
            }else{
                sheetObject1.SetCellValue(i,prefix+"cust_trd_prnr_id",sheetObject1.GetCellValue(i-1,prefix+"cust_trd_prnr_id"));
                sheetObject1.SetCellValue(i,prefix+"pol_cd",sheetObject1.GetCellValue(i-1,prefix+"pol_cd"));
                sheetObject1.SetCellValue(i,prefix+"pod_cd",sheetObject1.GetCellValue(i-1,prefix+"pod_cd"));
            }
            //기타  
            sheetObject1.SetCellValue(i,prefix+"etd_adj_dy","");
            sheetObject1.SetCellValue(i,prefix+"dct_adj_dy","");
            sheetObject1.SetCellValue(i,prefix+"cct_adj_dy","");
            sheetObj=sheetObject1;
            allEdit1(sheetObj, i);
            allEdit2(sheetObj, i);
            break;
        case "btn_RowDelete":
            ComRowHideDelete(sheetObject1,prefix+"check");
        break;
        case "btns_conti1":
            var classId="COM_ENS_0H1";
            var param='?classId='+classId;
            var v_display="1,0,1,1,1";
            ComOpenPopupWithTarget('/opuscntr/COM_ENS_0H1.do' + param, 705, 380, "3:pol_conti|4:pol_conti_nm", v_display, true);
            break;
        case "btns_conti2":
            var classId="COM_ENS_0H1";
            var param='?classId='+classId;
            var v_display="1,0,1,1,1";
            ComOpenPopupWithTarget('/opuscntr/COM_ENS_0H1.do' + param, 705, 380, "3:pod_conti|4:pod_conti_nm", v_display, true);
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('JOO00001');
        } else {
            ComShowMessage(e);
        }
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo, rlaneSheetList) {
    var cnt=0;
    switch(sheetNo) {
    case 1:      //IBSheet1 init
        with(sheetObj){
          var HeadTitle="SEQ|STS|POR|POL|1st T/S|2nd T/S|3rd T/S|POD|DEL|Block\n Lane";
          var HeadTitle1="SEQ|STS|POR|POL|Port|Port|Port|POD|DEL|Block\n Lane";
          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);
          var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"status",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"por_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"pol_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"n1st_pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"n2nd_pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"n3rd_pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"block_lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cust_trd_prnr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rout_rcv_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rout_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 } ];
          InitColumns(cols);
          SetEditable(1);
          SetColProperty(0 ,prefix+"por_cd"     , {AcceptKeys:"E", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"pol_cd"     , {AcceptKeys:"E", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"n1st_pol_cd", {AcceptKeys:"E", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"n2nd_pol_cd", {AcceptKeys:"E", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"n3rd_pol_cd", {AcceptKeys:"E", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"pod_cd"     , {AcceptKeys:"E", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"del_cd"     , {AcceptKeys:"E", InputCaseSensitive:1});
          SetRangeBackColor(1, 3, 1, 5,"#555555");
          SetHeaderRowHeight(20);
          SetSheetHeight(600);
          
      }
    break;
    
    case 2:      //IBSheet1 init
        with(sheetObj){
          var HeadTitle="SEQ|Del.|STS|POL|POD|Block\n Lane|Adj\n Lane|ETD|ETD|DCT|DCT|DCT|DCT|DCT|DCT|DCT|CCT|CCT|CCT|CCT|CCT|CCT|CCT";
          var HeadTitle1="SEQ|Del.|STS|POL|POD|Block\n Lane|Adj\n Lane|Day|Time|Day|Day|ETB|ETB|ETD|ETD|Time|Day|Day|ETB|ETB|ETD|ETD|Time";
          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);
          var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                 {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"check",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:1 },
                 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Popup",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"block_lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_adj_dy",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_adj_hrmnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"is_dct_adj_dy",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dct_adj_dy",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"is_dct_adj_etb",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dct_adj_etb_dys",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"is_dct_adj_etd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dct_adj_etd_dys",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dct_adj_hrmnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:4 },
                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"is_cct_adj_dy",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_adj_dy",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"is_cct_adj_etb",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_adj_etb_dys",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"is_cct_adj_etd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_adj_etd_dys",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_adj_hrmnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:4 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_trd_prnr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"adj_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dct_adj_tp_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cct_adj_tp_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rout_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
          InitColumns(cols);
          SetEditable(1);
          SetColProperty(prefix+"etd_adj_hrmnt", {Format:"####"} );
          SetColProperty(prefix+"dct_adj_hrmnt", {Format:"####"} );
          SetColProperty(prefix+"cct_adj_hrmnt", {Format:"####"} );
          SetColProperty(0 ,prefix+"pol_cd", {AcceptKeys:"E", InputCaseSensitive:1});
          SetColProperty(0 ,prefix+"pod_cd", {AcceptKeys:"E", InputCaseSensitive:1});
          SetHeaderRowHeight(20);
          SetColProperty(prefix+"etd_adj_dy", {ComboText:"SUN|MON|TUE|WED|THU|FRI|SAT", ComboCode:"1|2|3|4|5|6|7"} );
          SetColProperty(prefix+"dct_adj_dy", {ComboText:"SUN|MON|TUE|WED|THU|FRI|SAT", ComboCode:"1|2|3|4|5|6|7"} );
          SetColProperty(prefix+"cct_adj_dy", {ComboText:"SUN|MON|TUE|WED|THU|FRI|SAT", ComboCode:"1|2|3|4|5|6|7"} );
          SetRangeBackColor(1, 3, 1, 5,"#555555");
//          SetSheetHeight(260 );
          resizeSheet();
        }
        break;
    }
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    switch (sAction) { 
    case IBSEARCH: 
        if (validateForm(sheetObj, formObj, sAction)){
            /*if(formObj.partnerName.value == ""){
                form.f_cmd.value=SEARCH01; 
                var formObj=document.form;
                //sheetObjects[1].WaitImageVisible = false;
//parameter changed[check again]CLT                     var sXml=sheetObjects[1].GetSearchData("ESD_SCE_0122GS.do" , SceFrmQryString(form));
                //텍스트 가져오기[partnerName]
                if(sXml != ""){
                    var partnerName=ComGetEtcData(sXml,"partnerName");
                    var custTrdPrnrId=ComGetEtcData(sXml,"custTrdPrnrId") == "" ? "" : ComGetEtcData(sXml,"custTrdPrnrId");
                    formObj.partnerName.value=partnerName;
                    checkOption(custTrdPrnrId);
                }
            }*/
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESD_SCE_0123GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam(prefix) );
        }
    break;
    case IBSEARCH_ASYNC01: 
    if (validateForm(sheetObj, formObj, sAction)){
//        if(formObj.partnerName.value != ""){
//            form.f_cmd.value=SEARCH01;
//            var formObj=document.form;
//            //sheetObjects[1].WaitImageVisible = false;
//            var sXml=sheetObjects[1].GetSearchData("ESD_SCE_0122GS.do" , SceFrmQryString(form));
//            //[partnerName]
//            if(sXml != ""){
//                var partnerName=ComGetEtcData(sXml,"partnerName");
//                var custTrdPrnrId=ComGetEtcData(sXml,"custTrdPrnrId") == "" ? "" : ComGetEtcData(sXml,"custTrdPrnrId");
//                formObj.partnerName.value=partnerName;
//                checkOption(custTrdPrnrId);
//            }
//        }
        formObj.f_cmd.value=SEARCHLIST01;
        sheetObj.DoSearch("ESD_SCE_0123GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam(prefix1) );
    }
    break;
    case IBSAVE:    
        if (validateForm(sheetObj, formObj, sAction)){
            var SaveStr=ComGetSaveString(sheetObj);
            if (SaveStr == ""){
                ComShowCodeMessage("SCE01222");
                return;
            }
            formObj.f_cmd.value=MULTI;
            var aryPrefix=new Array("sheet2_");     
            var sXml=sheetObj.GetSaveData("ESD_SCE_0123GS.do", SaveStr + "&" + SceFrmQryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
            sheetObj.LoadSearchData(sXml,{Sync:1} );
            doActionIBSheet(sheetObject1, formObj, IBSEARCH);
            //document.form.cust_trd_prnr_id.focus();
        }
    break;
    case SEARCH01:
        document.getElementById('cust_trd_prnr_id').value=document.getElementById('cust_trd_prnr_id').value.toUpperCase();
        sheetObj.ShowDebugMsg(false);
        formObj.f_cmd.value=SEARCH01; 
        sheetObj.DoSearch("ESD_SCE_0123GS.do",SceFrmQryString(formObj) );
        var partnerName=sheetObj.GetEtcData("partnerName");
        document.getElementById('partnerName').value=sheetObj.GetEtcData("partnerName");
        //IBS_EtcDataToForm2(formObj,sheetObj) ;
        sheetObj.RemoveAll();
    break; 
    }
}
/**
* handling process for input validation
*/
function validateForm(sheetObj, formObj, sAction) {
sheetObj.ShowDebugMsg(false);
switch (sAction) {
        case IBSEARCH:      
            if(formObj.cust_trd_prnr_id.value == ""){
                ComShowMessage(ComGetMsg('SCE01221', "TP ID"));
            }
        break;
        case IBSAVE:    
            for (var inx=1; inx <= sheetObj.RowCount(); inx++){
                if (sheetObj.GetCellValue(inx, prefix+"ibflag") == "I" || sheetObj.GetCellValue(inx, prefix+"ibflag") == "U"){
                    //Key Check
                    if(sheetObj.GetCellValue(inx, prefix+"slan_cd") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "Adj Lane"));
                        return false;
                    }
                    sheetObj.SetCellValue(inx,prefix+"cust_trd_prnr_id",formObj.cust_trd_prnr_id.value);
                    //Time Check
                    if(sheetObj.GetCellValue(inx, prefix+"etd_adj_dy") != "" && sheetObj.GetCellValue(inx, prefix+"etd_adj_hrmnt") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "ETD Time"));
                        return false;
                    }
                    if((sheetObj.GetCellValue(inx, prefix+"dct_adj_dy") != "" || sheetObj.GetCellValue(inx, prefix+"dct_adj_etb_dys") != "" || sheetObj.GetCellValue(inx, prefix+"dct_adj_etd_dys") != "") && sheetObj.GetCellValue(inx, prefix+"dct_adj_hrmnt") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "DCT Time"));
                        return false;
                    }
                    if((sheetObj.GetCellValue(inx, prefix+"cct_adj_dy") != "" || sheetObj.GetCellValue(inx, prefix+"cct_adj_etb_dys") != "" || sheetObj.GetCellValue(inx, prefix+"cct_adj_etd_dys") != "") && sheetObj.GetCellValue(inx, prefix+"cct_adj_hrmnt") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "CCT Time"));
                        return false;
                    }
                    if(sheetObj.cellvalue(inx, prefix+"is_dct_adj_dy") == 1 && sheetObj.GetCellValue(inx, prefix+"dct_adj_dy") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "DCT Day"));
                        return false;
                    }
                    if(sheetObj.cellvalue(inx, prefix+"is_dct_adj_etb") == 1 && sheetObj.GetCellValue(inx, prefix+"dct_adj_etb_dys") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "DCT ETB"));
                        return false;
                    }
                    if(sheetObj.cellvalue(inx, prefix+"is_dct_adj_etd") == 1 && sheetObj.GetCellValue(inx, prefix+"dct_adj_etd_dys") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "DCT ETD"));
                        return false;
                    }
                    if(sheetObj.cellvalue(inx, prefix+"is_cct_adj_dy") == 1 && sheetObj.GetCellValue(inx, prefix+"cct_adj_dy") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "CCT Day"));
                        return false;
                    }
                    if(sheetObj.cellvalue(inx, prefix+"is_cct_adj_etb") == 1 && sheetObj.GetCellValue(inx, prefix+"cct_adj_etb_dys") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "CCT ETB"));
                        return false;
                    }
                    if(sheetObj.cellvalue(inx, prefix+"is_cct_adj_etd") == 1 && sheetObj.GetCellValue(inx, prefix+"cct_adj_etd_dys") == ""){
                        ComShowMessage(ComGetMsg('SCE01221', "CCT ETD"));
                        return false;
                    }
                }
            }
        break;
}
return true;
} 
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
/*
*   
*/
  function checkNumber(sValue){
  try{
    var value=sValue.search(/^\d*(\.?\d*)$/gi);
    if(value !=-1){
        return true;
    }else{
        return false;
    }
  }catch(errorObject){
    showErrorDig("checkNumber()", errorObject);
  }
}
function ComGetDateAdd2(sDate, sFlag, iVal, sDelim){
  try {
      if (sDelim==null || sDelim==undefined) sDelim="-";
      if (sDate==null || sDate==undefined) {
          sDate=new Date();
      } else {
          sDate=getArgValue(sDate); 
      }
      var yy=eval(sDate); 
      iVal=ComParseInt(iVal);   
      switch(sFlag.toLowerCase()) {
          case "y":   yy += eval(iVal);    break;
      }
      return yy ;
  } catch(err) { ComFuncErrMsg(err.message); }
 }
/*
function sheet2_OnSearchEnd(sheetObj,errMsg){
    for (var i=1; i<=sheetObj.RowCount()+1; i++) {
var a=sheetObj.GetCellValue(i,prefix+"is_dct_adj_dy");
var b=sheetObj.GetCellValue(i,prefix+"is_dct_adj_etb");
var c=sheetObj.GetCellValue(i,prefix+"is_dct_adj_etd");
var d=sheetObj.GetCellValue(i,prefix+"is_cct_adj_dy");
var e=sheetObj.GetCellValue(i,prefix+"is_cct_adj_etb");
var f=sheetObj.GetCellValue(i,prefix+"is_cct_adj_etd");
        if(a==0 && b==0 && c==0){
            allEdit1(sheetObj, i);
        }else if (a == 1) { 
            sheetObj.SetCellEditable(i,prefix+"is_dct_adj_dy",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_dy",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_hrmnt",1);
        }else if (b == 1) { 
            sheetObj.SetCellEditable(i,prefix+"is_dct_adj_etb",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_etb_dys",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_hrmnt",1);
        }else if (c == 1) { 
            sheetObj.SetCellEditable(i,prefix+"is_dct_adj_etd",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_etd_dys",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_hrmnt",1);
        }
        if(d==0 && e==0 && f==0){
            allEdit2(sheetObj, i);
        }else if (d == 1) {
            sheetObj.SetCellEditable(i,prefix+"is_cct_adj_dy",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_dy",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_hrmnt",1);
        }else if (e == 1) { 
            sheetObj.SetCellEditable(i,prefix+"is_cct_adj_etb",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_etb_dys",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_hrmnt",1);
        }else if (f == 1) {
            sheetObj.SetCellEditable(i,prefix+"is_cct_adj_etd",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_etd_dys",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_hrmnt",1);
        }
    }
}
*/
function chkOnSearchEnd(sheetObj,i){
    var a=sheetObj.GetCellValue(i,prefix+"is_dct_adj_dy");
    var b=sheetObj.GetCellValue(i,prefix+"is_dct_adj_etb");
    var c=sheetObj.GetCellValue(i,prefix+"is_dct_adj_etd");
    var d=sheetObj.GetCellValue(i,prefix+"is_cct_adj_dy");
    var e=sheetObj.GetCellValue(i,prefix+"is_cct_adj_etb");
    var f=sheetObj.GetCellValue(i,prefix+"is_cct_adj_etd");
        if(a==0 && b==0 && c==0){
            allEdit1(sheetObj, i);
        }else if (a == 1) { 
            sheetObj.SetCellEditable(i,prefix+"is_dct_adj_dy",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_dy",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_hrmnt",1);
        }else if (b == 1) { 
            sheetObj.SetCellEditable(i,prefix+"is_dct_adj_etb",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_etb_dys",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_hrmnt",1);
        }else if (c == 1) { 
            sheetObj.SetCellEditable(i,prefix+"is_dct_adj_etd",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_etd_dys",1);
            sheetObj.SetCellEditable(i,prefix+"dct_adj_hrmnt",1);
        }
        if(d==0 && e==0 && f==0){
            allEdit2(sheetObj, i);
        }else if (d == 1) {
            sheetObj.SetCellEditable(i,prefix+"is_cct_adj_dy",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_dy",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_hrmnt",1);
        }else if (e == 1) { 
            sheetObj.SetCellEditable(i,prefix+"is_cct_adj_etb",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_etb_dys",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_hrmnt",1);
        }else if (f == 1) {
            sheetObj.SetCellEditable(i,prefix+"is_cct_adj_etd",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_etd_dys",1);
            sheetObj.SetCellEditable(i,prefix+"cct_adj_hrmnt",1);
        }
}
function allEdit1(sheetObj, i){
    sheetObj.SetCellEditable(i,prefix+"is_dct_adj_dy",1);
    sheetObj.SetCellEditable(i,prefix+"is_dct_adj_etb",1);
    sheetObj.SetCellEditable(i,prefix+"is_dct_adj_etd",1);
}
function allEdit2(sheetObj, i){
    sheetObj.SetCellEditable(i,prefix+"is_cct_adj_dy",1);
    sheetObj.SetCellEditable(i,prefix+"is_cct_adj_etb",1);
    sheetObj.SetCellEditable(i,prefix+"is_cct_adj_etd",1);
}
  /**
  * @param sheetObj
  * @param row
  * @param col
  * @return
  */
  function sheet2_OnChange(sheetObj, row, col) {
    //chkOnSearchEnd(sheetObj,row);
      var rows=sheetObj.Rows;
     switch (sheetObj.ColSaveName(col)) {
        //1 
        case prefix+"is_dct_adj_dy" :
            if(row > 0){
                if(sheetObj.cellvalue(row,prefix+"is_dct_adj_dy") == 1) {   //check
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_etb",0);
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_etb",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_dy",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_hrmnt",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_etb_dys",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_etd_dys",0);
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_tp_nm","DAY");
                    return;
                }
                if(sheetObj.cellvalue(row,prefix+"is_dct_adj_dy") == 0) {   //uncheck
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_etb",0);
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_etb",1);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_etd",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_hrmnt",0);
                    sheetObj.SetCellValue(row,prefix+"dct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_hrmnt","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_tp_nm","");
                    return;
                }
            }
        break;
        case prefix+"is_dct_adj_etb" :
            if(row > 0){
                if(sheetObj.cellvalue(row,prefix+"is_dct_adj_etb") == 1) {  //check
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_dy",0);
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_etb_dys",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_hrmnt",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_etd_dys",0);
                    sheetObj.SetCellValue(row,prefix+"dct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_tp_nm","ETB");
                    return;
                }
                if(sheetObj.cellvalue(row,prefix+"is_dct_adj_etb") == 0) {  //uncheck
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_dy",0);
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_dy",1);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_etd",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_etb_dys",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_hrmnt",0);
                    sheetObj.SetCellValue(row,prefix+"dct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_hrmnt","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_tp_nm","");
                    return;
                }
            }
        break;
        case prefix+"is_dct_adj_etd" :
            if(row > 0){
                if(sheetObj.cellvalue(row,prefix+"is_dct_adj_etd") == 1) {  //check
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_dy",0);
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_etb",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_etb",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_etd_dys",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_hrmnt",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_etb_dys",0);
                    sheetObj.SetCellValue(row,prefix+"dct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_tp_nm","ETD");
                    return;
                }
                if(sheetObj.cellvalue(row,prefix+"is_dct_adj_etd") == 0) {  //uncheck
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_dy",0);
                    sheetObj.SetCellValue(row,prefix+"is_dct_adj_etb",0);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_dy",1);
                    sheetObj.SetCellEditable(row,prefix+"is_dct_adj_etb",1);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_etd_dys",0);
                    sheetObj.SetCellEditable(row,prefix+"dct_adj_hrmnt",0);
                    sheetObj.SetCellValue(row,prefix+"dct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_hrmnt","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"dct_adj_tp_nm","");
                    return;
                }
            }
        break;
        //2 
        case prefix+"is_cct_adj_dy" :
            if(row > 0){
                if(sheetObj.cellvalue(row,prefix+"is_cct_adj_dy") == 1) {   //check
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_etb",0);
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_etb",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_dy",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_hrmnt",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_etb_dys",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_etd_dys",0);
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_tp_nm","DAY");
                    return;
                }
                if(sheetObj.cellvalue(row,prefix+"is_cct_adj_dy") == 0) {   //uncheck
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_etb",0);
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_etb",1);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_etd",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_hrmnt",0);
                    sheetObj.SetCellValue(row,prefix+"cct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_hrmnt","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_tp_nm","");
                    return;
                }
            }
        break;
        case prefix+"is_cct_adj_etb" :
            if(row > 0){
                if(sheetObj.cellvalue(row,prefix+"is_cct_adj_etb") == 1) {  //check
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_dy",0);
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_etb_dys",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_hrmnt",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_etd_dys",0);
                    sheetObj.SetCellValue(row,prefix+"cct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_tp_nm","ETB");
                    return;
                }
                if(sheetObj.cellvalue(row,prefix+"is_cct_adj_etb") == 0) {  //uncheck
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_dy",0);
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_etd",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_dy",1);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_etd",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_etb_dys",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_hrmnt",0);
                    sheetObj.SetCellValue(row,prefix+"cct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_hrmnt","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_tp_nm","");
                    return;
                }
            }
        break;
        case prefix+"is_cct_adj_etd" :
            if(row > 0){
                if(sheetObj.cellvalue(row,prefix+"is_cct_adj_etd") == 1) {  //check
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_dy",0);
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_etb",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_etb",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_etd_dys",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_hrmnt",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_dy",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_etb_dys",0);
                    sheetObj.SetCellValue(row,prefix+"cct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_tp_nm","ETD");
                    return;
                }
                if(sheetObj.cellvalue(row,prefix+"is_cct_adj_etd") == 0) {  //uncheck
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_dy",0);
                    sheetObj.SetCellValue(row,prefix+"is_cct_adj_etb",0);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_dy",1);
                    sheetObj.SetCellEditable(row,prefix+"is_cct_adj_etb",1);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_etd_dys",0);
                    sheetObj.SetCellEditable(row,prefix+"cct_adj_hrmnt",0);
                    sheetObj.SetCellValue(row,prefix+"cct_adj_dy","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_hrmnt","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etb_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_etd_dys","");
                    sheetObj.SetCellValue(row,prefix+"cct_adj_tp_nm","");
                    return;
                }
            }
        break;
     }
 }
function getPartnerName(){
    form.f_cmd.value=SEARCH01;
    var formObj=document.form;
    //sheetObjects[1].WaitImageVisible = false;
    var sXml=sheetObjects[1].GetSearchData("ESD_SCE_0122GS.do" , SceFrmQryString(form));
    //[partnerName]
    var partnerName=ComGetEtcData(sXml,"partnerName");
    var custTrdPrnrId=ComGetEtcData(sXml,"custTrdPrnrId") == "" ? "" : ComGetEtcData(sXml,"custTrdPrnrId");
    formObj.partnerName.value=partnerName;
    checkOption(custTrdPrnrId);
}
function resetConti(inx){
    var formObj=document.form;
    if(inx == 1){
        if(formObj.pol_conti.value == "" || formObj.pol_conti.value == " "){
            formObj.pol_conti_nm.value="";
            formObj.pol_conti.value="";
        }
    }else{
        if(formObj.pod_conti.value == "" || formObj.pod_conti.value == " "){
            formObj.pod_conti_nm.value="";
            formObj.pod_conti.value="";
        }
    }
}
function checkOption(cust_trd_prnr_id){
    var formObj=document.form;
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    formObj.cb_slan_cd="";
    formObj.cb_skd_dir_cd="";
    formObj.cb_pol_cd="";
    if (cust_trd_prnr_id == "C1T0W"){
        document.getElementById("mainTable1").style.display="none";
        document.getElementById("btnRet").style.display="none";
        document.getElementById("samLayer").style.display="";
        document.getElementById("mainTable2").style.display="";
        document.getElementById("btnLayer").style.display="";
        document.getElementById("btnSave").style.display="";
    }else{
        document.getElementById("samLayer").style.display="none";
        document.getElementById("mainTable2").style.display="none";
        document.getElementById("btnLayer").style.display="none";
        document.getElementById("mainTable1").style.display="";
        document.getElementById("btnSave").style.display="none";
        document.getElementById("btnRet").style.display="";
    }
    setTimeout("checkOptionExec('" + cust_trd_prnr_id + "')", 100 );
}
function checkOptionExec(cust_trd_prnr_id){
    if (cust_trd_prnr_id == "C1T0W"){
        document.getElementById("mainTable2").style.display="none";
        document.getElementById("mainTable2").style.display="";
    }else{
        document.getElementById("mainTable1").style.display="none";
        document.getElementById("mainTable1").style.display="";
    }
}
/**
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col){
    var sUrl="/opuscntr/ESD_SCE_0124.do";
    var rout_rcv_dt=sheetObj.GetCellValue(Row,  sheetObj.SaveNameCol(prefix1+"rout_rcv_dt"));
    var rout_seq=sheetObj.GetCellValue(Row,  sheetObj.SaveNameCol(prefix1+"rout_seq"));
    var param="?gubun=A&rout_rcv_dt="+rout_rcv_dt+"&rout_seq="+rout_seq;
    ComOpenPopup(sUrl + param, 550, 410, "", "none",false);
}
/**
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnPopupClick(sheetObj, Row, Col){
    var sUrl="/opuscntr/ESD_SCE_0124.do";
    var cust_trd_prnr_id=document.form.cust_trd_prnr_id.value;
    var pol_cd=sheetObj.GetCellValue(Row,  sheetObj.SaveNameCol(prefix+"pol_cd"));
    var pod_cd=sheetObj.GetCellValue(Row,  sheetObj.SaveNameCol(prefix+"pod_cd"));
    var rout_seq=sheetObj.GetCellValue(Row,  sheetObj.SaveNameCol(prefix+"rout_seq"));
    var param="?gubun=B&cust_trd_prnr_id="+cust_trd_prnr_id+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&rout_seq="+rout_seq;
    ComOpenPopup(sUrl + param, 550, 410, "", "none",false);
}

function popOk(gubun, blockSel){
    var sheetObj="";
    if(gubun == "is_dct_adj_dy"){
        var i=sheetObjects[0].selectRow;
        sheetObjects[0].SetCellValue(i, sheetObjects[0].SaveNameCol(prefix1+"block_lane"),blockSel,0);
    }else{  //B
        var i=sheetObjects[1].selectRow;
        sheetObjects[1].SetCellValue(i, sheetObjects[1].SaveNameCol(prefix+"block_lane"),blockSel,0);
    }
    
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);    
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[1]);
} 
