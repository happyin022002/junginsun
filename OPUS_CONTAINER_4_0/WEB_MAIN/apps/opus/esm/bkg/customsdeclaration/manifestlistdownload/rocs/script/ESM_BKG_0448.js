/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0448.js
*@FileTitle  : Receive History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var sel_row=0;
var sel_col=0;

// Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name"); 
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;                                                      
            case "btn_downexcel":
                if(sheetObject1.RowCount() < 1){//no data
                	ComShowCodeMessage("COM132501");
                }else{
//                	sheetObject1.Down2Excel({ HiddenColumn:0,TreeLevel:false});
                	sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1,DownSum:1,KeyFieldMark:0});
                }
                break;
            case "btn_view":
                doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
                break;
            case "btn_history":
                doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
                break;                                                                                  
            case "btn_print":
                doActionIBSheet(sheetObjects[0],document.form,COMMAND03);                               
                break;
            case "btn_calendar": 
                // prohibiting before searching
                if(formObject.vps_eta_start_dt.disabled) return;
                var cal=new ComCalendarFromTo();
                cal.select(formObject.vps_eta_start_dt,formObject.vps_eta_end_dt, 'yyyy-MM-dd');
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
  * adding first-served functions after loading screen.
  */
 function loadPage() {
     for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
     if(document.form.from_vvd_number.value != "" || document.form.from_pod_cd.value != "")
     {
        document.form.vvd_number.value=document.form.from_vvd_number.value;
        document.form.pod_cd.value=document.form.from_pod_cd.value;
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
     
    // axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
     axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
     axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
     axon_event.addListenerForm("click","obj_click", document.form);
 }
 
 /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":      //sheet1 init
            with(sheetObj){
                var HeadTitle="|Sel.|Seq.|History|Received Result|B/L No.|Received Date|VVD|POL|POD|Received Seq|Error Code|Error Description|Error Ref";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                              {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
                              {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hist",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"rtm_edi_msg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"msg_snd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_number",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"rowcnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rtm_edi_err_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:0,   SaveName:"err_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"err_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
          
                InitColumns(cols);

                SetEditable(1);
                SetColProperty("msg_snd_dt", {Format:"YmdHms"} );
                SetSheetHeight(492);
            }

        case "sheet2":
            with(sheetObj){
                var HeadTitle="|Sel.|Seq.|History|Received Result|B/L No.|Received Date|VVD|POL|POD|Received Seq|Error Code|Error Description|Error Ref";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
                            {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hist",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"rtm_edi_msg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"msg_snd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_number",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"rowcnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rtm_edi_err_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:220,  Align:"Center",  ColMerge:0,   SaveName:"err_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"err_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
                InitColumns(cols);

                SetEditable(1);
                SetColProperty("msg_snd_dt", {Format:"YmdHms"} );
                SetSheetHeight(492);
           }
           break;
        case "sheet3":
            with(sheetObj){
                var HeadTitle="Seq.|History|Received Result|B/L No.|Received Date|VVD|POL|POD|Received Seq.|Error Code|Error Description|Error Ref.";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hist",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"rtm_edi_msg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"msg_snd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_number",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"rowcnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rtm_edi_err_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:220,  Align:"Center",  ColMerge:0,   SaveName:"err_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"err_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
                InitColumns(cols);

                SetEditable(1);
                SetColProperty("msg_snd_dt", {Format:"YmdHms"} );

                SetSheetHeight(175);
            }
        break;
    }
}

// handling of Sheet 
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:              
            if(!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true); 
            if(formObj.vvd_number.value.length > 0)
            {
                formObj.vsl_cd.value=formObj.vvd_number.value.substring(0,4);
                formObj.skd_voy_no.value=formObj.vvd_number.value.substring(4,8);
                formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);                          
            }
            formObj.f_cmd.value=SEARCH;
            formObj.msg_type.value=formObj.sel_msg_type.value;
            sheetObj.DoSearch("ESM_BKG_0448GS.do", FormQueryString(formObj) );
            ComOpenWait(false); 
            break;
        case IBSAVE:        
            if(validateForm(sheetObj,formObj,sAction))
                alert (" Save .. ");
            break;
        case COMMAND01:        //history
            if(!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }
            view_history(sel_row,sel_col);
            break;
        case COMMAND03:        //print                      
            sheetObjects[2].RemoveAll();
            if(sheetObjects[0].RowCount()>0){
                for(var i=1; i<=sheetObjects[0].RowCount(); i++){
                    var si = sheetObjects[2].DataInsert(-1);
                    sheetObjects[2].SetCellValue(si,"Seq",sheetObjects[0].GetCellValue(i,"Seq"),0);
                    sheetObjects[2].SetCellValue(si,"hist",sheetObjects[0].GetCellValue(i,"hist"),0);
                    sheetObjects[2].SetCellValue(si,"rtm_edi_msg_tp_cd",sheetObjects[0].GetCellValue(i,"rtm_edi_msg_tp_cd"),0);
                    sheetObjects[2].SetCellValue(si,"bl_no",sheetObjects[0].GetCellValue(i,"bl_no"),0);
                    sheetObjects[2].SetCellValue(si,"msg_snd_dt",sheetObjects[0].GetCellValue(i,"msg_snd_dt"),0);
                    sheetObjects[2].SetCellValue(si,"vvd_number",sheetObjects[0].GetCellValue(i,"vvd_number"),0);
                    sheetObjects[2].SetCellValue(si,"pol_cd",sheetObjects[0].GetCellValue(i,"pol_cd"),0);
                    sheetObjects[2].SetCellValue(si,"pod_cd",sheetObjects[0].GetCellValue(i,"pod_cd"),0);
                    sheetObjects[2].SetCellValue(si,"rowcnt",sheetObjects[0].GetCellValue(i,"rowcnt"),0);
                    sheetObjects[2].SetCellValue(si,"rtm_edi_err_id",sheetObjects[0].GetCellValue(i,"rtm_edi_err_id"),0);
                    sheetObjects[2].SetCellValue(si,"err_desc",sheetObjects[0].GetCellValue(i,"err_desc"),0);
                    sheetObjects[2].SetCellValue(si,"err_ctnt",sheetObjects[0].GetCellValue(i,"err_ctnt"),0);
                }
            }                    
//            sheetObjects[2].RowDelete(sheetObjects[2].RowCount(),false);
            if( sheetObjects[2].RowCount()==0 ) {
                ComShowCodeMessage("BKG00889");
                return;
            }
            ComOpenWindowCenter("/opuscntr/ESM_BKG_0448_1.do?pgmNo=ESM_BKG_0448_1", "0448_1", 900, 600, false);                         
            break;
        case COMMAND02:        //LOG View
            if(!validateForm(sheetObj,formObj,sAction)) {
                return false;
            } 
            var sUrl="/opuscntr/ESM_BKG_1027.do?pgmNo=ESM_BKG_1027&rcv_snd_div_cd=R&sheet_msg_snd_dt="+formObj.sheet_msg_snd_dt.value+"&sheet_bl_no="+formObj.sheet_bl_no.value;
            ComOpenWindowCenter(sUrl, "ESM_BKG_1027", 780, 580, false);
            break;
        case IBINSERT:     
            break;
     }
 }
 
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
        case IBSEARCH: 
            if(formObj.date_gubun.value == "2" && formObj.vps_eta_start_dt.value.length > 0 && !ComIsDate(formObj.vps_eta_start_dt.value, "ymd"))
            {
                ComShowCodeMessage('BKG00377');
                formObj.vps_eta_start_dt.focus();
                return false;
            }
            if(formObj.date_gubun.value == "2" &&formObj.vps_eta_end_dt.value.length > 0 && !ComIsDate(formObj.vps_eta_end_dt.value, "ymd"))
            {
                ComShowCodeMessage('BKG00377');
                formObj.vps_eta_end_dt.focus();
                return false;
            }
            if (formObj.date_gubun.value == "2" && ComChkPeriod(formObj.vps_eta_start_dt.value, formObj.vps_eta_end_dt.value) < 1 )
            {
                //alert("it is unsure to set period.");
                ComShowCodeMessage('BKG00377');
                formObj.vps_eta_start_dt.focus();
                return false;               
            }
            if(formObj.date_gubun.value == "2" && !ComIsTime(formObj.fromtime.value, "hm"))
            {
                ComShowCodeMessage('BKG00421');
                formObj.fromtime.focus();
                return false;
            }
            if(formObj.date_gubun.value == "2" && !ComIsTime(formObj.totime.value, "hm"))
            {
                ComShowCodeMessage('BKG00421');
                formObj.totime.focus();
                return false;
            }
            if(formObj.date_gubun.value == "2")
            {
                var iDays=ComGetDaysBetween(formObj.vps_eta_start_dt.value, formObj.vps_eta_end_dt.value);
                if(iDays > 14)
                {
                    ComShowCodeMessage('BKG40014','2');
                    return false;
                }
            }
//          if( ComGetLenByByte(formObj.bl_no) > 0 && ComGetLenByByte(formObj.bl_no) < 12) // Toyota B/L
//          {
//              ComShowCodeMessage('BKG00709');
//              formObj.bl_no.focus();
//              return false;
//          }
            if( ComGetLenByByte(formObj.pol_cd) > 0 && ComGetLenByByte(formObj.pol_cd) < 5)
            {
                ComShowCodeMessage('BKG00711');
                formObj.pol_cd.focus();
                return false;
            }
            if( ComGetLenByByte(formObj.pod_cd) > 0 && ComGetLenByByte(formObj.pod_cd) < 5)
            {
                ComShowCodeMessage('BKG00712');
                formObj.pod_cd.focus();
                return false;
            }
            if(formObj.date_gubun.value == "1" && ComGetLenByByte(formObj.vvd_number) > 0 && ComGetLenByByte(formObj.vvd_number) < 9)
            {
                ComShowCodeMessage('BKG00710');
                formObj.vvd_number.focus();
                return false;
            }
            if(formObj.date_gubun.value == "1" && ComGetLenByByte(formObj.vvd_number) == 0)
            {
                ComShowCodeMessage('BKG00710');
                formObj.vvd_number.focus();
                return false;
            }
            return true;
            
            break;
        case COMMAND01: // history
            if(sel_row == 0 )
            {                
                ComShowCodeMessage('BKG00249');
                return false;                   
            }
            if(sheetObjects[0].GetCellValue(sel_row,"hist") == "H")
            {                 
                ComShowCodeMessage('BKG06034');
                return false;
            }
            return true;
            
            break;
        case COMMAND02: // history
            if(sel_row == 0 )
            {                
                ComShowCodeMessage('BKG00249');
                return false;                   
            }
            return true;
            break;
    }            
}
  
  /**
   * screen deactivating /activating as selecting radio button
   * @return
   */
function obj_click(){
    for(var i=0; i < document.form.gubun.length; i++) {
        if(document.form.gubun[i].checked) {
            if(document.form.gubun[i].value == 1)
            {
                document.form.vvd_number.disabled=false;
                document.form.vps_eta_start_dt.disabled=true;
                document.form.vps_eta_end_dt.disabled=true;
                document.form.fromtime.disabled=true;
                document.form.totime.disabled=true;                       
                document.form.date_gubun.value="1";
            }
            if(document.form.gubun[i].value == 2)
            {
                document.form.vvd_number.disabled=true;
                document.form.vvd_number.value="";
                document.form.vsl_cd.value="";
                document.form.skd_voy_no.value="";
                document.form.skd_dir_cd.value="";
                document.form.vps_eta_start_dt.disabled=false;
                document.form.vps_eta_end_dt.disabled=false;
                document.form.fromtime.disabled=false;
                document.form.totime.disabled=false;                      
                document.form.date_gubun.value="2";
            }
        }
    }
}  

/**
 *  inputting selected value of row into variable (to search history)
 * @param SheetObj
 * @param Row
 * @param Col
 * @return
*/ 
function sheet1_OnClick(SheetObj, Row, Col){
    sel_row=Row;
    sel_col=Col;
    document.form.sheet_vvd_number.value=sheetObjects[0].GetCellValue( Row, "vvd_number" );
    document.form.sheet_pol_cd.value=sheetObjects[0].GetCellValue( Row, "pol_cd" );
    document.form.sheet_pod_cd.value=sheetObjects[0].GetCellValue( Row, "pod_cd" );
    document.form.sheet_bl_no.value=sheetObjects[0].GetCellValue( Row, "bl_no" );
    document.form.sheet_msg_snd_dt.value=sheetObjects[0].GetCellValue( Row, "msg_snd_dt" );
}

/**
 *  showing previous history data of bl_no if searched Row is selected
 * @param row
 * @param col
 * @return
*/
function view_history(row,col)
{   
    document.form.f_cmd.value=SEARCH01; 
    var rownumber=0;          
    sheetObjects[1].DoSearch("ESM_BKG_0448GS.do", FormQueryString(document.form),{Sync:2} );
    for(var i=0; i<sheetObjects[1].RowCount()+1; i++) {
		if (i > 0) {
			sheetObjects[0].SetCellValue(row,"hist","H",0);
			rownumber=sheetObjects[0].DataInsert();
		}
		for(var col=0;col<=sheetObjects[1].LastCol();col++){
			sheetObjects[0].SetCellValue(rownumber, col,sheetObjects[1].GetCellValue(i, col),0);
		}
	}
	// sheetObjects[0].ColumnSort("0", "ASC");
	sheetObjects[0].ReNumberSeq();
}



function sheet2_OnSearchEnd(sheetObj, Code, Msg) {  
    for(var i=0; i<sheetObjects[1].RowCount()+1; i++) {
        if (i > 0) {
            sheetObjects[0].SetCellValue(row,"hist","H",0);
            rownumber=sheetObjects[0].DataInsert();
        }
        for(var col=0;col<=sheetObjects[1].LastCol();col++){
            sheetObjects[0].SetCellValue(rownumber, col,sheetObjects[1].GetCellValue(i, col),0);
        }
    }	
}
/**
 * Enter event(searching)
 * @return
 */
function obj_ComKeyEnter() {
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    if( srcName != "") {                 
        ComKeyEnter();
    }                    
}

///**
// * controlling keyboard on onkeyUp event
// */
//function obj_KeyUp() {
//    var formObject=document.form;        
//    var srcName=ComGetEvent("name");
//    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//    var srcValue=window.event.srcElement.getAttribute("value");
//    if (ComChkLen(srcValue, srcMaxLength) == "2") {
//        ComSetNextFocus();                      
//    }
//}
