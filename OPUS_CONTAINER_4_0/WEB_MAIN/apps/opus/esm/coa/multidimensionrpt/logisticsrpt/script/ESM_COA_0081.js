/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_081.js
*@FileTitle  : Logistics Exp. by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/

// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
    /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
            case "btn_new":
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                formObject.reset();
                break;
            case "btn_DownExcel":
            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);		//SJH.20150105.MOD
                break;
            case "btng_Detail":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            case "bu_zoom_in1":            	
            	getToggleSheetHeight(sheetObject, (ComGetSheetHeight(sheetObject, 8) * 2), div_zoom_in1, div_zoom_out1, "none", "inline", "0");
                break;
            case "bu_zoom_out1":
            	getToggleSheetHeight(sheetObject, ComGetSheetHeight(sheetObject, 8), div_zoom_in1, div_zoom_out1, "inline", "none", "0");  
                break;
            case "bu_zoom_in2":
            	getToggleSheetHeight(sheetObject1, (ComGetSheetHeight(sheetObject1, 8) * 2), div_zoom_in2, div_zoom_out2, "none", "inline", "0");
//                if(sheetObject1.LastRow()>8){
//                    sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, sheetObject1.LastRow()+2));
//                    div_zoom_out2.style.display="inline";
//                    div_zoom_in2.style.display="none";
////                    parent.syncHeight();
//                }
                break;
            case "bu_zoom_out2":
            	getToggleSheetHeight(sheetObject1, ComGetSheetHeight(sheetObject1, 8), div_zoom_in2, div_zoom_out2, "inline", "none", "0");  
//                if(sheetObject1.LastRow()>8){
//                    sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, 8));
//                    div_zoom_in2.style.display="inline";
//                    div_zoom_out2.style.display="none";
////                    parent.syncHeight();
//                }
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
            ComShowMessage(e.message);
        }
    }
}
/**
 *  Depending on the display of the Month / Week column shows the sheet
 */
function viewMonWeek(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;    
    
    //SJH.20140731.ADD 
    if(formObj.f_split_mw.checked){
       sheetObj.SetColHidden("cost_yrmon",0);
       sheetObj.SetColHidden("cost_wk",0);
    } else {
        sheetObj.SetColHidden("cost_yrmon",1);
        sheetObj.SetColHidden("cost_wk",1);
    }           
    
    initSheet(sheetObjects[0],1);
    sheetObj.RemoveAll();
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function clearDatePeriod(){
    document.form.txtWeek.value="";
    document.getElementById("div_period").innerHTML="<div id='div_period'></div>";
}
/**
* Change period when the month, week changed
*/
function setPeriod(obj){
    ComCoaSetPeriod(obj);
}
 //kpl
 function changeKpiType(kpiType) {
    if(kpiType == '2') {
        div_mnKpi.style.display="none";
        div_lgsKpi.style.display="inline";
    } else {
        div_mnKpi.style.display="inline";
        div_lgsKpi.style.display="none";
    }      
 }
 /**
  * RHQ, OFFICE condition to enable / disable function <br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
  * @param {int} code  Mandatory Onclick event code
  * @param {int} text  Text in the mandatory item
  * @return nothing
  */
function f_report_OnChange(comboObj, oldindex , oldttext, oldcode , newindex , text , code ) {
    var formObj=document.form;
    if (code == "1") {
        f_rhq_cd.SetEnable(0);
        f_ctrl_ofc_cd.SetEnable(0);
        f_ctrl_ofc_cd.SetSelectIndex(0);
        f_rhq_cd.SetSelectIndex(0);
    } else if(code == "2") {
        f_rhq_cd.SetEnable(1);
        f_ctrl_ofc_cd.SetEnable(0);
        f_ctrl_ofc_cd.SetSelectIndex(0);
    } else {
        f_rhq_cd.SetEnable(1);
        f_ctrl_ofc_cd.SetEnable(1);
    }    
}
function changeHideColumn(){
    if(document.form.f_isViewAct.checked == false)  {
        sheetObjects[0].SetColHidden("cost_act_grp_nm",1);
    } else {
        sheetObjects[0].SetColHidden("cost_act_grp_nm",0);
    }
}
/**
 * Display RHQ OFFICE using ifram
 */
 function f_rhq_cd_OnChange(comboObj, oldindex , oldttext, oldcode , newindex , text , code ) {
    if (loadingMode == true)
        return;
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if (comboObj.GetSelectText()!= "") {
        formObj.f_cmd.value=SEARCHLIST13;
        var sXml=sheetObj.GetSearchData("ESM_COA_0081GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
            ComXml2ComboItem(arrXml[0], formObj.f_ctrl_ofc_cd, "code", "code");
        f_ctrl_ofc_cd.SetSelectIndex(0);
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
    // handling multi-combo object
    //---------------------------------------------
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k], comboObjects[k].id);
    }
    //---------------------------------------------
    loadingMode=false;
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    }
    f_rhq_cd.SetEnable(0);
    f_ctrl_ofc_cd.SetEnable(0);
}
 /**
 * initializing Tab
 * setting Tab items
 */
function initCombo(comboObj, comboId) {
    with (comboObj) {
        SetSelectIndex(0);
        SetDropHeight(150);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고

        switch(comboObj.options.id) {
		case "f_in_out":
		    //SJH.20140730 ADD : RBC insert
		    comboObj.InsertItem(-1, "RBC", "R");		    
		    break;	 
		}		
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
        case 1: //sheet1 init
            with(sheetObj){
                var HeadTitle="H|subsum|Month|Week|RHQ|Control Office|H|Cost Group|H|KPI|Volume (BOX)|Expense|Unit Cost|kpiOrder";
                
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:4, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"p_report",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmonwk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lgs_kpi_cost_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"kpi_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"kpi_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vol",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"total_cost",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"unit_cost",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"kpi_order",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
                SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
            }
            //소계(subsum) 표시
            if(document.form.f_split_mw.checked){ 
                sheetObj.ShowSubSum([{StdCol:"p_report", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"TOTAL"}, {StdCol:"cost_yrmonwk", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"Mon/Week"}, {StdCol:"lgs_kpi_cost_grp_nm", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"CostGroup"}]);
            }else {        
                sheetObj.ShowSubSum([{StdCol:"p_report", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"TOTAL"}, {StdCol:"lgs_kpi_cost_grp_nm", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"CostGroup"}]);
            } 
            break;
        case 2: //sheet2 init
            with(sheetObj){
                var HeadTitle="H|RHQ|Control Office|Cost Group|KPI|In/Out|Volume\n(BOX)|Expense|Expense|Expense";
                var HeadTitle1="H|RHQ|Control Office|Cost Group|KPI|In/Out|Volume\n(BOX)|Account|Amount|Unit Cost";
                
                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:7, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"p_report",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lgs_kpi_cost_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"kpi_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"in_out",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vol",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"total_cost",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"unit_cost",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
                SetHeaderRowHeight(20);
                SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
            }

            break;
    }
}
/**
    * registering IBCombo Object as list
    * adding process for list in case of needing batch processing with other items 
    * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
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
* Details are viewed by double-clicking on sheet1
*/
function sheet1_OnDblClick(sheetObj, row, col){
    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
}
/**
* When a new query data from sheet1 to sheet2 is initialized.
*/
function sheet1_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);
    sheetObjects[1].RemoveAll();
    //1:worldwide, 2:RHQ, 3:Control Office
    //1:RHQ, 2:Control Office, 3:Sub Office
    sheetObj.SetColHidden("rhq_cd",0);
    sheetObj.SetColHidden("ctrl_ofc_cd",0);
    sheetObj.SetColHidden("ofc_cd",0);
    if(sheetObj.GetCellValue(1, "p_report") == '1'){
        sheetObj.SetColHidden("rhq_cd",1);
        sheetObj.SetColHidden("ctrl_ofc_cd",1);
        sheetObj.SetColHidden("ofc_cd",1);
    } else if(sheetObj.GetCellValue(1, "p_report") == '2'){ //2
        sheetObj.SetColHidden("ctrl_ofc_cd",1);
        sheetObj.SetColHidden("ofc_cd",1);
    }
//    if(document.form.f_split_mw.checked){                               
//        sheetObj.ShowSubSum([{StdCol:"p_report", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"TOTAL"}]);
//        sheetObj.ShowSubSum([{StdCol:"cost_yrmonwk", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"Mon/Week"}]);
//    }else {
//        sheetObj.ShowSubSum([{StdCol:"p_report", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"TOTAL"}]);
//    }               
//    sheetObj.ShowSubSum([{StdCol:"lgs_kpi_cost_grp_nm", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"CostGroup"}]);
//    sheetObj.SetSumText(2, "TOTAL");
}
/**
* Setting the volume at the end of sheet2 inquiry
*/
function sheet2_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);
    //1:RHQ, 2:Control Office, 3:Sub Office
    sheetObj.SetColHidden("rhq_cd",0);
    sheetObj.SetColHidden("ctrl_ofc_cd",0);
    sheetObj.SetColHidden("ofc_cd",0);
    if(sheetObj.GetCellValue(2, "p_report") == '1'){
        sheetObj.SetColHidden("rhq_cd",1);
        sheetObj.SetColHidden("ctrl_ofc_cd",1);
        sheetObj.SetColHidden("ofc_cd",1);
    } else if(sheetObj.GetCellValue(2, "p_report") == '2'){ //2
        sheetObj.SetColHidden("ctrl_ofc_cd",1);
        sheetObj.SetColHidden("ofc_cd",1);
    }
}
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
        var prevWeek="";
        formObj.f_cmd.value=INIT;
        var sXml=sheetObj.GetSearchData("ESM_COA_0081GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        
      	//SJH.20150106.ADD/MOD
        formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
        formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
        formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
        formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
        document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";  	
        
        if (arrXml.length > 0)
        	ComXml2ComboItem(arrXml[0], f_report, "code", "name");    
        if (arrXml.length > 1)
            ComXml2ComboItem(arrXml[1], f_rhq_cd, "code", "code");
        if (arrXml.length > 2)
            ComXml2ComboItem(arrXml[2], f_ctrl_ofc_cd, "code", "code");         
        if (arrXml.length > 3)
            ComXml2ComboItem(arrXml[3], f_in_out, "code", "name");          
        if (arrXml.length > 4)
            ComXml2ComboItem(arrXml[4], f_lgs_kpi_cost_grp_cd, "code", "name");
        if (arrXml.length > 5)
            ComXml2ComboItem(arrXml[5], f_lgs_mn_kpi_cd, "code", "name");
        if (arrXml.length > 6)
            ComXml2ComboItem(arrXml[6], f_lgs_kpi_cd, "code", "name");      
        
        ComOpenWait(false);
        break;      
    case IBSEARCH:  //Inquiry
	    	//소계(subsum) 표시
//	        if(document.form.f_report.value == "2"){ 
//	            sheetObj.ShowSubSum([{StdCol:"lgs_kpi_cost_grp_nm", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"CostGroup"}]);
//	            sheetObj.ShowSubSum([{StdCol:"p_report", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"TOTAL"}, {StdCol:"p_report", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"Mon/Week"}, {StdCol:"kpi_order", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"CostGroup"}]);
//	 	       }else {        
//	            sheetObj.ShowSubSum([{StdCol:"p_report", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"TOTAL"}, {StdCol:"lgs_kpi_cost_grp_nm", SumCols:"total_cost", Sort:true, ShowCumulate:false, CaptionCol:9, CaptionText:"CostGroup"}]);
//	        } 
        
            if(validateForm(sheetObj,formObj,sAction)) {
                if ( sheetObj.id == "sheet1" ) {
                    // Prohibit button click when a business transaction is processing 
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    formObj.f_cmd.value=SEARCHLIST01;
                    sheetObj.DoSearch("ESM_COA_0081GS.do", coaFormQueryString(formObj) );
//                    ComOpenWait(false);
                }
                else if ( sheetObj.id == "sheet2" ) {
                    if(sheetObjects[0].RowCount()>0){//When the data in sheet1
                        // Prohibit button click when a business transaction is processing 
                        //sheetObj.WaitImageVisible = false;
                        //ComOpenWait(true);
                        formObj.f_cmd.value=SEARCHLIST02;
                        var sheetObject=sheetObjects[0];
                        //sheet1 of the selected rows in the query
                        var selrow=sheetObject.GetSelectRow();
                        var selValue="";                            
                        selValue=sheetObject.GetCellValue(selrow, "cost_yrmon").replace("X", "");
                        formObj.s_cost_yrmon2.value=selValue;                           
                        selValue=sheetObject.GetCellValue(selrow, "cost_wk").replace("X", "");
                        formObj.s_cost_wk2.value=selValue;  
                        formObj.s_rhq_cd.value=sheetObject.GetCellValue(selrow, "rhq_cd");
                        formObj.s_cntr_ofc_cd.value=sheetObject.GetCellValue(selrow, "ctrl_ofc_cd");
                        formObj.s_lgs_kpi_cost_grp_cd.value=sheetObject.GetCellValue(selrow, "cost_act_grp_tp_cd");
                        formObj.s_kpi_cd.value=sheetObject.GetCellValue(selrow, "kpi_cd");
                        sheetObj.DoSearch("ESM_COA_0081GS2.do", coaFormQueryString(formObj) );
                        //ComOpenWait(false);
                    } else {
                        ComShowMessage(ComGetMsg('COA10005', 'Sheet1'));
                    }
                }
            }
            break;
        case IBSAVE:        //Save
            break;
        case IBINSERT:  // Insert
            sheetObj.DataInsert();
            break;
        case IBCOPYROW:     // Row copy
            sheetObj.DataCopy();
            break;
        case IBDOWNEXCEL:       // Excell download
        	//SJH.20150105.MOD
    		if(sheetObjects[0].RowCount() < 1){//no data
    			  ComShowCodeMessage("COM132501");
    			  return;
    		}        	
    	  	var excelType=selectDownExcelMethod(sheetObj);
            break;
        case IBLOADEXCEL:       // Excel upload
            sheetObj.LoadExcel();
            break;
    }
}

/**
* Download Excel
* SJH.20150105.MOD
*/
function callBackExcelMethod(excelType){  
	var sheetObj = sheetObjects[0];
	sheetObjects[0].Down2ExcelBuffer(true);
    switch (excelType) {
	    case "AY":
	    	sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetName:'sheet1', SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	sheetObjects[1].Down2Excel({ HiddenColumn:0, SheetName:'sheet2', SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	        break;
	    case "AN":
	    	sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetName:'sheet1', SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	sheetObjects[1].Down2Excel({ HiddenColumn:0, SheetName:'sheet2', SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	    	break;
	    case "DY":
	    	sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetName:'sheet1', SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	sheetObjects[1].Down2Excel({ HiddenColumn:1, SheetName:'sheet2', SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	    case "DN":
	    	sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetName:'sheet1', SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	sheetObjects[1].Down2Excel({ HiddenColumn:1, SheetName:'sheet2', SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	    	break;
	} 
    sheetObjects[0].Down2ExcelBuffer(false);  
}
/**
* Handling process for form object input validation
* SJH.20150106.MOD
*/
function validateForm(sheetObj,formObj,sAction){
    with(formObj){        
        if(!chkValidSearch()) return false;
        if(f_report.selectedIndex == 2) {//control office
            if(f_rhq_cd.GetSelectIndex()== 0) {
                ComShowMessage(ComGetMsg("COM12113", "RHQ"));
                f_rhq_cd.focus();
                return false;
            }
        }
    }
    return true;
}
/**
* Check mandatory input when searching
* SJH.20150106.ADD
*/
function chkValidSearchIndv(){
    var formObj=document.form;
    with(formObj){        
        // 3 Mon or 5 Week
        for(var i=0;i<f_chkprd.length;i++)
        {
        	if(f_chkprd[i].checked) vChkPrd=f_chkprd[i].value;
        }
        if(vChkPrd == "M" && (ComParseInt(f_to_mon.value) - ComParseInt(f_fm_mon.value)) > 2){
            ComShowMessage(ComGetMsg("COA10038","3 Months"));
            f_fm_mon.focus();
            return false;
        }
        if(vChkPrd == "W" && (ComParseInt(f_to_wk.value) - ComParseInt(f_fm_wk.value)) > 4){
            ComShowMessage(ComGetMsg("COA10038","5 Weeks"));
            f_fm_wk.focus();
            return false;
        }
    }
    return true;
}
