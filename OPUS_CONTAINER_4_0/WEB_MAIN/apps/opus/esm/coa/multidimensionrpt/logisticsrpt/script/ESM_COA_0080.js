/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0080.js
*@FileTitle  : Logistics Exp. by Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheet_height=200; // sheet height
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var RP_COMBO_IDX=0; // Setting index of the report combo
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
    /*Specify additional sheet variable in case of using more than two sheet per tab */
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
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case "btng_Detail":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            case "bu_zoom_in1":
                if(sheetObject.LastRow()>8){
                    sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, sheetObject.LastRow()));
                    div_zoom_out1.style.display="inline";
                    div_zoom_in1.style.display="none";
                    //parent.syncHeight();
                }
                break;
            case "bu_zoom_out1":
                if(sheetObject.LastRow()>8){
                    sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, 8));
                    div_zoom_in1.style.display="inline";
                    div_zoom_out1.style.display="none";
                    //parent.syncHeight();
                }
                break;
            case "bu_zoom_in2":
                if(sheetObject1.LastRow()>8){
                    sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, sheetObject1.LastRow()));
                    div_zoom_out2.style.display="inline";
                    div_zoom_in2.style.display="none";
                    //parent.syncHeight();
                }
                break;
            case "bu_zoom_out2":
                if(sheetObject1.LastRow()>8){
                    sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, 8));
                    div_zoom_in2.style.display="inline";
                    div_zoom_out2.style.display="none";
                    //parent.syncHeight();
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
 * Change period when the month, week changed
*/
function setPeriod(obj){
     ComCoaSetPeriod(obj);
}
/**
 *  Month/Week
*/
function viewMonWeek(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    if(formObj.f_split_mw.checked){
       sheetObj.SetColHidden("cost_yrmon",0);
       sheetObj.SetColHidden("cost_wk",0);
    } else {
       sheetObj.SetColHidden("cost_yrmon",1);
       sheetObj.SetColHidden("cost_wk",1);
    }      
    sheetObj.RemoveAll();
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
// handling combo object
/**
*  Display R.Lane using ifram
*/
function f_trd_cd_OnChange(obj) {
    if (loadingMode == true)
        return;
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if (obj.GetSelectText()!= "") {
        formObj.f_cmd.value=SEARCHLIST11;
        var sXml=sheetObj.GetSearchData("ESM_COA_0080GS.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0)
            ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "code");
        f_rlane_cd.SetSelectIndex(0);
    }    
}

/**
 * OnChange event function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj mandatory IBSheet Combo Object
 * @param {int} code  Onclick event code
 * @param {int} text  text displayed column
 * @return nothing
 */
function f_report_OnChange(comboObj, oldindex , oldttext, oldcode , newindex , text , code ) {
    var formObj=document.form;
    if (code != null && code !="T" && code != "L") {
        //return pre-index
        comboObj.SetSelectIndex(RP_COMBO_IDX,false);
        ComShowCodeMessage("COA10060"); 
    }
    RP_COMBO_IDX=comboObj.GetSelectIndex();
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
    }
   
	switch(comboId) {
	case "f_report":
	    //SJH.20140730 ADD : Sub-Trade, VVD delete
	    comboObj.DeleteItem("S", true);		//Sub-Trade
	  	comboObj.DeleteItem("V", true);		//VVD
	    break;	 
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
                var HeadTitle="H|Subsum|Month|Week|Trade|Lane|B/D|Load\n(TEU)|Void Vol\n(TEU)|Expense|Expense|Expense|Unit Cost (Cost per Load)|Unit Cost (Cost per Load)|Unit Cost (Cost per Load)";
                var HeadTitle1="H|Subsum|Month|Week|Trade|Lane|B/D|Load\n(TEU)|Void Vol\n(TEU)|TMNL|TRANS|Total|TMNL|TRANS|Total";
                
                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:9, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},
                { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"p_report",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmonwk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"load",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"void_vol",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"tm_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"tr_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"total_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"unit_tm",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"unit_tr",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"unit_ttl",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                               
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
//                SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
                SetSheetHeight(200);
                
                ShowSubSum([{StdCol:"cost_yrmonwk", SumCols:"load|void_vol|tm_amt|tr_amt|total_amt", Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"Mon/Week"}]);
                
            }

            break;
        case 2:    //sheet2 init
            with(sheetObj){
                var HeadTitle="H|Trade|Lane|B/D|Load (TEU)|Cost Group|In/Out|KPI|Vol (BOX)|Expense|Unit Cost";
                
                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"p_report",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"p_load",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lgs_kpi_cost_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"in_out",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"kpi_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"vol",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"total_cost",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"unit_cost",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                                  
                InitColumns(cols);
                
                SetEditable(0);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
//                SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
//                SetSheetHeight(200);
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
 * sheet1
*/
function sheet1_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);
    //sheet2 
    sheetObjects[1].RemoveAll();
    //1:Trade, 2:Lane
    sheetObj.SetColHidden("rlane_cd",0);
    sheetObj.SetColHidden("dir_cd",0);
    if(sheetObj.GetCellValue(1, "p_report") == '1'){ //trade
        sheetObj.SetColHidden("rlane_cd",1);
        sheetObj.SetColHidden("dir_cd",1);
    }
    //Unit cost setting
    if(sheetObj.RowCount() > 0){
    	var load=sheetObj.GetSumValue(0, "load");
//    	var load=parseFloat(sheetObj.GetSumValue(0, "load"));
//    	var load=parseFloat(sheetObj.GetCellValue(sheetObj.LastRow(),"load"));
    	
//        sheetObj.SetCellValue(sheetObj.LastRow(), "unit_tm",parseFloat(sheetObj.GetCellValue(sheetObj.LastRow(),"tm_amt"))/load);
//        sheetObj.SetCellValue(sheetObj.LastRow(), "unit_tr",parseFloat(sheetObj.GetCellValue(sheetObj.LastRow(),"tr_amt"))/load);
//        sheetObj.SetCellValue(sheetObj.LastRow(), "unit_ttl",parseFloat(sheetObj.GetCellValue(sheetObj.LastRow(),"total_amt"))/load);
//        sheetObj.SetCellValue(sheetObj.LastRow(), "unit_tm",parseFloat(sheetObj.GetSumValue("tm_amt"))/load);
//        sheetObj.SetCellValue(sheetObj.LastRow(), "unit_tr",parseFloat(sheetObj.GetSumValue("tr_amt"))/load);
//        sheetObj.SetCellValue(sheetObj.LastRow(), "unit_ttl",parseFloat(sheetObj.GetSumValue("total_amt"))/load);
    }
}
/**
 * Setting hidden column after inquiry sheet1 
 */
function sheet1_OnDblClick(sheetObj, row, col){
    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
}
/**
 * Setting hidden column after inquiry sheet2 
*/
function sheet2_OnSearchEnd(sheetObj, errMessge) {
    ComOpenWait(false);
    //1:Trade, 2:Lane
    sheetObj.SetColHidden("rlane_cd",0);
    sheetObj.SetColHidden("dir_cd",0);
    if(sheetObj.GetCellValue(1, "p_report") == '1'){ //trade
        sheetObj.SetColHidden("rlane_cd",1);
        sheetObj.SetColHidden("dir_cd",1);
    }
}

//Handling process about the sheet object
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
        var sXml=sheetObj.GetSearchData("ESM_COA_0080GS.do", coaFormQueryString(formObj));
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
            ComXml2ComboItem(arrXml[1], f_trd_cd, "code", "code");
        if (arrXml.length > 2)
            ComXml2ComboItem(arrXml[2], f_rlane_cd, "code", "code");        
        if (arrXml.length > 3)
            ComXml2ComboItem(arrXml[3], f_skd_dir_cd, "code", "name");
        if (arrXml.length > 4)
            ComXml2ComboItem(arrXml[4], f_lgs_mn_kpi_cd, "code", "name");
        if (arrXml.length > 5)
            ComXml2ComboItem(arrXml[5], f_lgs_kpi_cd, "code", "name");
        
        ComOpenWait(false);        
        break;  
    case IBSEARCH:   //Inquiry          
        if(validateForm(sheetObj,formObj,sAction)) {
            if ( sheetObj.id == "sheet1" ) {
                // Prohibit button click when a business transaction is processing 
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST01;
                sheetObj.DoSearch("ESM_COA_0080GS.do", coaFormQueryString(formObj) );
//                ComOpenWait(false);
            }
            else if ( sheetObj.id == "sheet2" ) {
                if(sheetObjects[0].RowCount()>0){//sheet1
                    // Prohibit button click when a business transaction is processing 
                    /*sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);*/
                    formObj.f_cmd.value=SEARCHLIST02;
                    var sheetObject=sheetObjects[0];
                    //sheet1
                    var selrow=sheetObject.GetSelectRow();
                    var selValue="";
                    selValue=sheetObject.GetCellValue(selrow, "cost_yrmon").replace("X", "");
                    formObj.s_cost_yrmon2.value=selValue;
                    selValue=sheetObject.GetCellValue(selrow, "cost_wk").replace("X", "");
                    formObj.s_cost_wk2.value=selValue;                                                                         
                    formObj.s_trd_cd.value=sheetObject.GetCellValue(selrow, "trd_cd");
                    formObj.s_rlane_cd.value=sheetObject.GetCellValue(selrow, "rlane_cd");
                    formObj.s_skd_dir_cd.value=sheetObject.GetCellValue(selrow, "dir_cd");
                    formObj.s_load.value=sheetObject.GetCellValue(selrow, "load");
                    sheetObj.DoSearch("ESM_COA_0080GS2.do", coaFormQueryString(formObj) );
                    /*ComOpenWait(false);*/
                } else {
                    ComShowMessage(ComGetMsg('COA10005'));
                }
            }
        }
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

//SJH.20150105.MOD
function callBackExcelMethod(excelType) {	
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


function resizeSheet(){
	 ComResizeSheet(sheetObjects[1]);
}