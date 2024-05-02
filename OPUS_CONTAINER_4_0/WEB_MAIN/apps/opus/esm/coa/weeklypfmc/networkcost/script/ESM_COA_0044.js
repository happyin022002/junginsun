/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0044.js
*@FileTitle  : Re-Assignment by Bound
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/

/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0044 : ESM_COA_0044 Business script for the UI
 */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */ 
document.onclick=processButtonClick;
/**
 * Contents : Event handler processing by button name <br>
 * <b>Example : </b>
 * <pre>
 *    processButtonClick()
 * </pre>
 * @see #Link
 */
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
 * Contents :  Sheet default setting and Initialize <br>
 *          implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br><b>Example : </b>
 * <pre>
 *     loadPage()
 * </pre>
 * @param 
 * @see #Link
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
 * SJH.20150106.ADD 
 */ 
function initCombo(comboObj, comboNo) {
	with(comboObj) {
		
        SetDropHeight(300);
        SetMultiSelect(0);
        SetMaxSelect(1);
        ValidChar(2,1);		
        SetSelectIndex(0);
        
        switch(comboObj.id) {
        case "f_seltrade":
            SetMaxLength(3);                
            break;
        case "f_selrlane":
            SetMaxLength(5);                
            break;   
        case "f_selioc":
            SetMaxLength(1);
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
 * Contents :  Initialize sheet and define header info <br>
 *          adding case as numbers of counting sheets<br>
 * <br><b>Example : </b>
 * <pre>
 *     initSheet(sheetObj,sheetNo,tpszValue)
 * </pre>
 * @param {object}  sheetObj - Sheet Object
 * @param {Number}  sheetNo  - Sheet Number (A sequence No that is assigned in the sheet object tag ID)
 * @param {String}  Trade  - Trade
 * @see #Link
 */
function initSheet(sheetObj,sheetNo) {
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
              var HeadTitle="Sub TOTAL|Merge column|"
              + "Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Conti.|Port|Call IND|Call SEQ|Apply(%)|Pendulum (%)"		//20160129.ADD
              + "|Port \nExpense"
              + "|Canal \nTransit Fee"
              + "|Port Days|Sea Days"
              + "|Total Days"
              + "|FO Cons.|Bunker\n(FO Cons.+DO Cons.)"
              + "|Crew \nExpense"
              + "|Insurance"
              + "|Lubricant \nExpense"
              + "|Store Supply \nExpense"
              + "|Vessel \nM&R"
              + "|Depreciations"
              + "|Telecom \nExpense"
              + "|Other Operation \nFixed Exp"
              + "|Time \nCharterage"
              + "|General\nExpense";
              var cnt=0;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"totsum_code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"subsum_code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"conti_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_dbl_call_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"clpt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"aply_voy_rto",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     //20160129.ADD
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pndlm_rto",      	KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"amt_01",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"amt_02",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"port_dys",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"sea_dys",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"ttl_tz_dys",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"amt_03",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"amt_13",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_04",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_05",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_06",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_07",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_08",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_09",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_10",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"amt_11",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_12",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"amt_14",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetCountPosition(0);
			  resizeSheet();
			  
			 var cols="amt_01|amt_02|sea_dys|port_dys|ttl_tz_dys|amt_13|amt_03|amt_04|amt_05|amt_06|amt_07|amt_08|amt_09|amt_10|amt_11|amt_12|amt_14";
			 sheetObj.ShowSubSum([{StdCol:0, SumCols:cols, Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"TOTAL"}
			 					 ,{StdCol:1, SumCols:cols, Sort:true, ShowCumulate:false, CaptionCol:2, CaptionText:"SUB"}]);
		
				
            }
            break;
    }
}
/**
 * Contents : Registering IBSheet Object as list <br>
 *         adding process for list in case of needing batch processing with other items<br>
 *         defining list on the top of source<br>
 * <b>Example : </b>
 * <pre>
 *    setComboObject(sheet_obj)
 *    </pre>
 * @param {object}  sheet_obj - Sheet Object
 * @see #Link
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Contents : Handling process about the sheet object <br>
 * <br><b>Example : </b>
 * <pre>
 *     doActionIBSheet(sheetObj,formObj,sAction)
 * </pre>
 * @param {object}  sheetObj - Sheet Object
 * @param {form}    formObj  - From Object
 * @param {String}  sAction  - Kinds of processes 
 * @see #Link
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);//  Prohibit button click when a business transaction is processing
    switch(sAction) {
        case IBCLEAR:          //Inquiry
    		//SJH.20150106.ADD
			formObj.f_yearM.value=ComGetNowInfo("yy");								
		    formObj.f_year.value=ComGetNowInfo("yy");            
		    formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
		    formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");
    
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=INIT;
            var sXml=sheetObj.GetSearchData("ESM_COA_0044GS2.do", coaFormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            
            //SJH.20150106.ADD
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
                f_selrlane.SetSelectIndex(0);
            }
            if (2 < arrXml.length) {
                ComXml2ComboItem(arrXml[2], f_selioc, "code", "name");
                f_selioc.SetSelectIndex(0);
            }
            ComOpenWait(false);
            break;  
        case IBSEARCH:      //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            ComOpenWait(true);
            if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value=fillZero(formObj.f_fm_mon.value, 2, '0','left');
            if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value=fillZero(formObj.f_to_mon.value, 2, '0','left');
            if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value=fillZero(formObj.f_fm_wk.value, 2, '0','left');
            if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value=fillZero(formObj.f_to_wk.value, 2, '0','left');
            formObj.f_cmd.value=SEARCHLIST;
            sheetObj.DoSearch("ESM_COA_0044GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8') );
            break;
        case IBDOWNEXCEL:   // Excell download
            var excelType=selectDownExcelMethod(sheetObj);
            break;
    }
}

function callBackExcelMethod(excelType) {
    var sheetObj = sheetObjects[0];
    switch (excelType) {
	    case "AY":
	        sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1 , CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
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
 * Reflash the rLane list when a trade code is changed
 */
function f_seltrade_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    formObj.f_cmd.value=SEARCHLIST01;
    var sXml=sheetObj.GetSearchData("ESM_COA_0044GS2.do", coaFormQueryString(formObj));
    var arrXml=sXml.split("|$$|");
    if (arrXml.length > 0) {
        ComXml2ComboItem(arrXml[0], f_selrlane, "code", "name");
        f_selrlane.SetSelectIndex(0);
    }
}
/**
 *  Contents :  Change period when the month, week changed <br>
 * <br><b>Example : </b>
 * <pre>
 *     setPeriod(obj)
 * </pre>
 * @param (object) obj - Document Object
 * @see #Link
 */
function setPeriod(obj) {
    ComCoaSetPeriod(obj);
}
/**
 * Contents : Event after inquiry <br>
 * <br><b>Example : </b>
 * <pre>
 *     sheet1_OnSearchEnd(sheetObj, errMsg)
 * </pre>
 * @param {object}  sheetObj - sheet
 * @param {String}  errMsg
 * @see #Link
 */
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	ComOpenWait(false);
  //  var cols="amt_01|amt_02|sea_dys|port_dys|ttl_tz_dys|amt_13|amt_03|amt_04|amt_05|amt_06|amt_07|amt_08|amt_09|amt_10|amt_11|amt_12|amt_14";
  //  sheetObj.ShowSubSum([{StdCol:0, SumCols:cols, Sort:true, ShowCumulate:false, CaptionCol:1, CaptionText:"2=TOTAL"}]);
  //  sheetObj.ShowSubSum([{StdCol:1, SumCols:cols, Sort:true, ShowCumulate:false, CaptionCol:1, CaptionText:"2=SUB"}]);
}
/**
 *  validateForm(sheetObj,formObj,sAction)  
 * SJH.20150106.ADD
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(!chkValidSearch()) return false;        
    }
    return true;
}
function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
