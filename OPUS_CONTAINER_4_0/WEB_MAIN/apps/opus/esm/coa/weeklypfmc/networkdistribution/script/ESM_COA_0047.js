/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0047.js
*@FileTitle  : TS Allocation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
*SJH.20150106.MOD : 전반수정
=========================================================*/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0047 : ESM_COA_0047 Business script for the UI
 */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;

/* Event handler processing by button click event */
document.onclick=processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
            case "btn_Downexcel":
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                      doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                }
                break;
            case "btn_Creation":
                doActionIBSheet(sheetObject,formObject,IBCREATE);
                break;
        } // end switch
    } catch(e) {
        if( e == "[object Error]") {
          ComShowMessage(OBJECT_ERROR);
        } else {
          ComShowMessage(e);
        }
    }
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode=false;
}
/**
 * Initializing IBCOMBO<br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} comboObj Mandatory IBMultiCombo Object
 * @param {int} comboNo Mandatory IBMultiCombo's Sequence
 * @return N/A
 * @author SJH.20150106.MOD
 */ 
function initCombo(comboObj, comboNo) {
    with(comboObj) {
    	
        SetDropHeight(300);
        SetMultiSelect(0);
        SetMaxSelect(1);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
        SetSelectIndex(0);
        
        switch(comboObj.options.id) {
        case "f_seltrade":
            SetMaxLength(3);
            break;
        case "f_selrlane":
            SetMaxLength(5);
            break;   
        case "f_selioc":
            SetMaxLength(1);
            break;
        case "f_selcost":
        	SetMaxSelect(1);
        	break;
        }        
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
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
  switch(sheetNo) {
      case 1:      //sheet1 init
        var com_head="Trade|Lane|IOC|VVD|Original Compony\nSales AMT|Slot Internal\nPrice|Company Sales\nAMT";	//SJH.20141104.MOD
        var head1="|Network Cost Assignment"
                  + "|Network Cost Assignment"
                  + "|Network Cost Assignment"
                  + "|Network Cost Assignment"
                  + "|Network Cost Assignment"
                  + "|Actual Operating Profit"
                  + "|Actual Operating Profit"
                  + "|Actual Operating Profit";
        var head2="|Trade|Lane|IOC|VVD|Status"
                  + "|Vol(TEU)|Ratio(%)|Assigned AMT";
        with(sheetObj){
            var HeadTitle0=com_head + head1;
            var HeadTitle1=com_head + head2;
            var cnt=0;
            
            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 //{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"M_ts_uc_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 //SJH.20141104.MOD : dfFloatOrg -> dfNullFloatOrg
                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"org_co_sls_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"slt_inter_prc_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"M_co_sls_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"D_trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"D_rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"D_ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"D_vvd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"D_locl_ts_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"D_ts_qty",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"D_ts_rto",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"D_fx_cost_dtrb_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
           
            InitColumns(cols);
            
            SetEditable(0);
            SetCountPosition(0);
            SetHeaderRowHeight(10);
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
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Reflash the rLane list when a trade code is changed
 */
//function f_seltrade_OnChange(obj,value,text) {
function f_seltrade_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    formObj.f_cmd.value=SEARCHLIST01;
    var sXml=sheetObj.GetSearchData("ESM_COA_0047GS2.do", coaFormQueryString(formObj));
    var arrXml=sXml.split("|$$|");
    if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_selrlane, "code", "name");
    f_selrlane.SetSelectIndex(0);
}
/**
 * Change the period when the year, month, week is changed
 */
function setPeriod(obj) {
    ComCoaSetPeriod(obj);
}
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);
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
        var sXml=sheetObj.GetSearchData("ESM_COA_0047GS2.do", coaFormQueryString(formObj));
        var arrXml=sXml.split("|$$|");
        
      	//SJH.20150106.ADD/MOD
        formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
        formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
        formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
        formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
        document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";          
        
        if (0 < arrXml.length) {
            ComXml2ComboItem(arrXml[0], f_seltrade, "code", "name");
            f_seltrade.SetSelectIndex(0);
        }
        if (1 < arrXml.length) {
            ComXml2ComboItem(arrXml[1], f_selrlane, "code", "name");
        }
        if (2 < arrXml.length) {
            ComXml2ComboItem(arrXml[2], f_selioc, "code", "name");
        }
        if (3 < arrXml.length) {
            ComXml2ComboItem(arrXml[3], f_selcost, "code", "name");
        }
        
        ComOpenWait(false);
        break;  
    case IBSEARCH:      //Inquiry
        if(!validateForm(sheetObj,formObj,sAction)) return false;
        if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value=fillZero(formObj.f_fm_mon.value, 2, '0','left');
        if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value=fillZero(formObj.f_to_mon.value, 2, '0','left');
        if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value=fillZero(formObj.f_fm_wk.value, 2, '0','left');
        if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value=fillZero(formObj.f_to_wk.value, 2, '0','left');
        // Prohibit button click when a business transaction is processing 
        sheetObj.SetWaitImageVisible(0);
        ComOpenWait(true);
        formObj.f_cmd.value=SEARCHLIST;
        sheetObj.DoSearch("ESM_COA_0047GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
        ComOpenWait(false);
        break;
    case IBDOWNEXCEL:   // Excell download
        var excelType=selectDownExcelMethod(sheetObj);
        break;
    case IBCREATE:      //SJH.20150106.MOD
        if(!validateForm(sheetObj,formObj,sAction)) return false;
        
        if (sheetObj.RowCount()> 0) {
            if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                ComOpenWait(true); 
                
                setTimeout( function () {
                	formObj.f_cmd.value=MULTI01;
                    var sParam = sheetObj.GetSaveString(1);
                    if (sheetObj.IsDataModified() && sParam == "") return;
                    sParam = sParam + "&" + FormQueryString(formObj);
                    var sXml = sheetObj.GetSaveData("ESM_COA_0047GS.do", sParam );
    	            sheetObj.LoadSaveData(sXml, {Sync:1});
                    
                    var err_cd = ComGetEtcData(sXml, "err_cd");
                    var err_msg = ComGetEtcData(sXml, "err_msg");	                        
    	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
    	                return false;
    	            }	                
                    if (err_cd == "00000") {
                        ComShowMessage(ComGetMsg('COA10018','CREATION')); 
                    } else {
                        ComShowMessage("["+err_cd+"]:"+err_msg);
                    }
                    sheetObj.SetEtcData("err_cd","");
                    sheetObj.SetEtcData("err_msg","");
                    
                    ComOpenWait(false);
                }, 100);
            }
        } else {
            ComShowMessage(ComGetMsg('COA10017'));
        }
        break;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    sheetObj.SetSumText(0,0, "TOTAL");
}

function callBackExcelMethod(excelType){
    var sheetObj = sheetObjects[0];
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
/**
 * Handling process for form object input validation
 * SJH.20150106.MOD
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {    	
    	if(!chkValidSearch()) return false;
    	
        if (sAction == IBCREATE) {
            // It must be same the 2nd argument of the 1st argument with the 3rd argument
            chkWM('W','1');
            if (ComParseInt(f_fm_wk.value) != ComParseInt(f_to_wk.value)) {
                ComShowMessage(ComGetMsg('COA10012', 'Creation', 'From Week', 'To Week'));
                f_fm_wk.focus();
                return false;
            }
        }
    }
    return true;
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
