/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_082.js
*@FileTitle  : Logistics Exp. by Node & Link
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
                if(comboObjects[5].GetSelectIndex()== 0)
                    doActionIBSheet(sheetObject,formObject,IBSEARCH); //tmnl
                else doActionIBSheet(sheetObject1,formObject,IBSEARCH);//trans
                break;
            case "btn_DownExcel":
                if(comboObjects[5].GetSelectIndex()== 0){
                    if(sheetObject.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                        break;
                    }else{
                        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL); //tmnl
                    }
                }
                else {
                    if(sheetObject1.RowCount() < 1){//no data
                        ComShowCodeMessage("COM132501");
                        break;
                    }else{
                        doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);//trans
                    }
                }
                break;
            case "bu_Zoom_in":
                if(comboObjects[5].GetSelectIndex()== 0) {; //tmnl
                    if(sheetObject.LastRow()>17){
                       sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, sheetObject.LastRow()));
                       div_zoom_out.style.display="inline";
                       div_zoom_in.style.display="none";
                       //parent.syncHeight();
                    }
                } else {//trans                             
                    if(sheetObject1.LastRow()>17){
                        sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, sheetObject1.LastRow()));
                        div_zoom_out.style.display="inline";
                        div_zoom_in.style.display="none";
                        //parent.syncHeight();
                    }
                }
                break;
            case "bu_Zoom_out":
                if(comboObjects[5].GetSelectIndex()== 0) {; //tmnl
                    if(sheetObject.LastRow()>17){
                        sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, 17));
                        div_zoom_in.style.display="inline";
                        div_zoom_out.style.display="none";
                        //parent.syncHeight();
                    }
                } else {//trans                             
                    if(sheetObject1.LastRow()>17){
                        sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, 17));
                        div_zoom_in.style.display="inline";
                        div_zoom_out.style.display="none";
                        //parent.syncHeight();
                    }
                }                   
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
/**
 * Retrieve a handle on the screen when you click Enter
 *
 */
function keyEnterTmlTrs(){
    var formObj=document.form;
    if(event.keyCode == 13){
        if(comboObjects[5].GetSelectIndex()== 0)
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH); //tmnl
        else doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);//trans
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
    sheetObj.RemoveAll();
}
// handling combo object
/**
* Displayed R.Lane by ifram
*/
function f_trd_cd_OnChange(obj) {
    if (loadingMode == true)
    return;
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if (obj.GetSelectText()!= "") {
        formObj.f_cmd.value=SEARCHLIST11;
        var sXml=sheetObj.GetSearchData("ESM_COA_0082GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
            ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "code");
        f_rlane_cd.SetSelectIndex(0);
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
        var sXml=sheetObj.GetSearchData("ESM_COA_0082GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
            ComXml2ComboItem(arrXml[0], f_ctrl_ofc_cd, "code", "code");
        f_ctrl_ofc_cd.SetSelectIndex(0);
    }
}  
 /**
  * DIV enable / disable function <br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
  * @param {int} code  Mandatory Onclick event code
  * @param {int} text  Text in the mandatory item
  * @return nothing
  */
function f_lgs_kpi_cost_grp_cd_OnChange(comboObj, oldindex , oldttext, oldcode , newindex , text , code ) {
    var formObj=document.form;
    if (code == "TM") {
        div_tmnl.style.display="inline";
        div_trans.style.display="none";
        div_tm_nod_title.style.display="inline";  
        div_tr_route_title.style.display="none";
        div_tr_nod_to.style.display="inline";
        div_tr_route_to.style.display="none";
        formObj.f_report.value="1";
        f_ctrl_ofc_cd.SetSelectIndex(0);
    } else {
        div_tmnl.style.display="none";
        div_trans.style.display="inline";           
        div_tm_nod_title.style.display="none";
        div_tr_route_title.style.display="inline";
        div_tr_nod_to.style.display="none";   
        div_tr_route_to.style.display="inline"; 
        formObj.f_report.value="2";
    }
	resizeSheet();	
}
/**
* Rhq, office search condition enabled and disabled
*/
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
        initCombo(comboObjects[k], comboObjects[k].options.id);
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
	viewMonWeek();		//SJH.20140731.ADD
	
    formObject.f_year.focus();
}
/**
* initializing Tab
* setting Tab items
 */
function initCombo(comboObj, comboId) {
    with (comboObj) {
        SetDropHeight(300);
        SetSelectIndex(0);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
        
		switch(comboId) {
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
                var HeadTitle="Month|Week|RHQ|Control Office|KPI|In/Out|Node|Trade|Lane|B/D|TPSZ|Volume (BOX)|Account|Amount|Unit Cost";
                
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:7, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"kpi_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"inout",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"nod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vol",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"total_cost",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"unit_cost",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
//                SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
//                SetSheetHeight(380);
				resizeSheet();
            }
            break;
        case 2: //sheet2 init
            with(sheetObj){
                var HeadTitle="Month|Week|RHQ|Control Office|KPI|In/Out|N1ST|N2ND|N3RD|N4TH|Trade|Lane|B/D|TPSZ|Volume (BOX)|Account|Amount|Unit Cost";
                
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:7, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"kpi_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"inout",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3rd_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n4th_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vol",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"total_cost",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"unit_cost",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
//                SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
//                SetSheetHeight(380);
				resizeSheet();
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
* Setting the hidden item after sheet1 inquiry
*/
function sheet1_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);
    sheetObj.SetColHidden("trd_cd",0);
    sheetObj.SetColHidden("rlane_cd",0);
    sheetObj.SetColHidden("dir_cd",0);
    sheetObj.SetColHidden("cntr_tpsz_cd",0);
    sheetObj.SetColHidden("nod_cd",0);
//    sheetObj.SetColHidden("cost_yrmon",0);
//    sheetObj.SetColHidden("cost_wk",0);
    if(!document.form.f_islane_display.checked){
        sheetObj.SetColHidden("trd_cd",1);
        sheetObj.SetColHidden("rlane_cd",1);
        sheetObj.SetColHidden("dir_cd",1);
    }
    if(!document.form.f_istpsz_display.checked){
        sheetObj.SetColHidden("cntr_tpsz_cd",1);
    }
    if(!document.form.f_isnode_display.checked){
        sheetObj.SetColHidden("nod_cd",1);
    } 
//    if(!document.form.f_split_mw.checked){
//        sheetObj.SetColHidden("cost_yrmon",1);
//        sheetObj.SetColHidden("cost_wk",1);
//    }
    if(document.form.f_split_mw.checked){
    	sheetObj.SetSumText(0, "TOTAL");
    } else {
    	sheetObj.SetSumText(2, "TOTAL");
    }
}
/**
* Setting the hidden item after sheet2 inquiry
*/
function sheet2_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);
    sheetObj.SetColHidden("trd_cd",0);
    sheetObj.SetColHidden("rlane_cd",0);
    sheetObj.SetColHidden("dir_cd",0);
    sheetObj.SetColHidden("cntr_tpsz_cd",0);
    sheetObj.SetColHidden("n1st_nod_cd",0);
    sheetObj.SetColHidden("n2nd_nod_cd",0);
    sheetObj.SetColHidden("n3rd_nod_cd",0);
    sheetObj.SetColHidden("n4th_nod_cd",0);
//    sheetObj.SetColHidden("cost_yrmon",0);
//    sheetObj.SetColHidden("cost_wk",0);
    if(!document.form.f_islane_display.checked){
        sheetObj.SetColHidden("trd_cd",1);
        sheetObj.SetColHidden("rlane_cd",1);
        sheetObj.SetColHidden("dir_cd",1);
    }
    if(!document.form.f_istpsz_display.checked){
        sheetObj.SetColHidden("cntr_tpsz_cd",1);
    }
    if(!document.form.f_isnode_display.checked){
        sheetObj.SetColHidden("n1st_nod_cd",1);
        sheetObj.SetColHidden("n2nd_nod_cd",1);
        sheetObj.SetColHidden("n3rd_nod_cd",1);
        sheetObj.SetColHidden("n4th_nod_cd",1);
    }
//    if(!document.form.f_split_mw.checked){
//        sheetObj.SetColHidden("cost_yrmon",1);
//        sheetObj.SetColHidden("cost_wk",1);
//    }       
    sheetObj.SetSumText(2, "TOTAL");
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
            formObj.f_cmd.value=INIT;
            var sXml=sheetObj.GetSearchData("ESM_COA_0082GS.do", coaFormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            
          	//SJH.20150106.ADD/MOD
            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";  
            
            if (arrXml.length > 0) 
                ComXml2ComboItem(arrXml[0], f_trd_cd, "code", "code");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], f_rlane_cd, "code", "code");
            if (arrXml.length > 2)
                ComXml2ComboItem(arrXml[2], f_skd_dir_cd, "code", "code");
            if (arrXml.length > 3)
                ComXml2ComboItem(arrXml[3], f_rhq_cd, "code", "code");
            if (arrXml.length > 4)
                ComXml2ComboItem(arrXml[4], f_ctrl_ofc_cd, "code", "code");
            if (arrXml.length > 5)
                ComXml2ComboItem(arrXml[5], f_lgs_kpi_cost_grp_cd, "code", "name");
            if (arrXml.length > 6)
                ComXml2ComboItem(arrXml[6], f_in_out, "code", "name");
            if (arrXml.length > 7)
                ComXml2ComboItem(arrXml[7], f_lgs_kpi_cd, "code", "name");
            
            ComOpenWait(false);
            break;  
        case IBSEARCH:  //Inquiry               
            if(validateForm(sheetObj,formObj,sAction)) {
                if ( sheetObj.id == "sheet1" ) {
                    // Prohibit button click when a business transaction is processing 
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    formObj.f_cmd.value=SEARCHLIST01;
                    sheetObj.DoSearch("ESM_COA_0082GS.do", coaFormQueryString(formObj) );
//                    ComOpenWait(false);
                } else if ( sheetObj.id == "sheet2" ) {
                    // Prohibit button click when a business transaction is processing 
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    formObj.f_cmd.value=SEARCHLIST02;
                    sheetObj.DoSearch("ESM_COA_0082GS2.do", coaFormQueryString(formObj) );
//                    ComOpenWait(false);
                }
            }
            break;
        case IBCOPYROW:     // Row copy
            sheetObj.DataCopy();
            break;
        case IBDOWNEXCEL:       // Excell download
        	if(f_lgs_kpi_cost_grp_cd.GetSelectCode() == "TM") {
            	selectDownExcelMethod(sheetObj,0);
        	} else {
            	selectDownExcelMethod(sheetObj,1);
        	}
            break;
        case IBLOADEXCEL:       // Excel upload
            sheetObj.LoadExcel();
            break;  
    }
}


function callBackExcelMethod(excelType) {	
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
}
/**
* Handling process for form object input validation
* SJH.20150106.MOD
*/
function validateForm(sheetObj,formObj,sAction){    
    with(formObj){        
        if(!chkValidSearch())return false;
    }       
    return true;
}
/**
* Check mandatory input when searching
* SJH.20150106.ADD
*/
function chkValidSearchIndv(){
    var formObj=document.form;
    var vChkPrd="";
    with(formObj){        
        for(var i=0;i<f_chkprd.length;i++)
        {
            if(f_chkprd[i].checked) vChkPrd=f_chkprd[i].value;
        }
        if(vChkPrd == "M" && (ComParseInt(f_to_mon.value) - ComParseInt(f_fm_mon.value)) > 1){
            ComShowMessage(ComGetMsg("COA10038","2 Months"));
            f_fm_mon.focus();
            return false;
        }
        if(vChkPrd == "W" && (ComParseInt(f_to_wk.value) - ComParseInt(f_fm_wk.value)) > 1){
            ComShowMessage(ComGetMsg("COA10038","2 Weeks"));
            f_fm_wk.focus();
            return false;
        }
    }
    return true;
}
function resizeSheet(){
    if(comboObjects[5].GetSelectIndex()== 0)
    	ComResizeSheet(sheetObjects[0]);
    else
    	ComResizeSheet(sheetObjects[1]);
}