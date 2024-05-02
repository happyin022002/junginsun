/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0045.js
*@FileTitle  : Company Sales/Slot Cht-out
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
*SJH.20150106.MOD : 전반수정
=========================================================*/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0045 : ESM_COA_0045 Business script for the UI
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
              if(doActionIBSheet(sheetObject,formObject,IBCREATE))
            	  doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
 * Function to initialize the IBCOMBO <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
* @param {ibsheet} comboObj mandatory IBMultiCombo Object
* @param {int} comboNo mandatory  The order of the IBMultiCombo
 * @return nothing
 * @author
 * @version
 * SJH.20150106.MOD
 */ 
function initCombo(comboObj, comboId) {
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
        var head1="|All Network cost by VVD";
        var head2="|Network cost for Company Sales";
        var head3="|Network cost for space charter-out";
        var head4="|Total" 
                  + "|Port\nExpense"         
                  + "|Canal\nTransit Fee"         
                  + "|Bunker"         
                  + "|Crew\nExpense"         
                  + "|Insurance"         
                  + "|Lubricant\nExpense"         
                  + "|Store\nSupply Expense"         
                  + "|Vessel M&R"         
                  + "|Depreciations"         
                  + "|Telecom\nExpense"         
                  + "|Other Operation\nFixed Exp"         
                  + "|Time\nCharterage"
//                  + "|Space\nCharterage"			//20150622.MOD
                  + "|SC Slot"						//20150622.MOD
                  + "|SC Ope"						//20150622.ADD
                  + "|General\nExpense";
        var tmp1=""; 
        var tmp2=""; 
        var tmp3=""; 
        var headText1=""; 
        var headText2=""; 
        for (var i=0; i<16; i++) {					//20150622.MOD
          tmp1=tmp1 + head1;
          tmp2=tmp2 + head2;
          tmp3=tmp3 + head3;
        }
        headText1=tmp1 + tmp2 + tmp3;
        for (var j=0; j<3; j++) {
          headText2=headText2 + head4;
        }
        var LOGIC_amt_1_tot="|amt_1_01|+|amt_1_02|+|amt_1_03|+|amt_1_04|+|amt_1_05|+"
                            + "|amt_1_06|+|amt_1_07|+|amt_1_08|+|amt_1_09|+|amt_1_10|+"
                            + "|amt_1_11|+|amt_1_12|+|amt_1_13|+|amt_1_14|+|amt_1_15|";		//20150622.ADD
        var LOGIC_amt_2_tot="|amt_2_01|+|amt_2_02|+|amt_2_03|+|amt_2_04|+|amt_2_05|+"
                            + "|amt_2_06|+|amt_2_07|+|amt_2_08|+|amt_2_09|+|amt_2_10|+"
                            + "|amt_2_11|+|amt_2_12|+|amt_2_13|+|amt_2_14|+|amt_2_15|";		//20150622.ADD
        var LOGIC_amt_3_tot="|amt_3_01|+|amt_3_02|+|amt_3_03|+|amt_3_04|+|amt_3_05|+"
                            + "|amt_3_06|+|amt_3_07|+|amt_3_08|+|amt_3_09|+|amt_3_10|+"
                            + "|amt_3_11|+|amt_3_12|+|amt_3_13|+|amt_3_14|+|amt_3_15|";		//20150622.ADD
        with(sheetObj){
            var HeadTitle0="Trade|Lane|Vessel|Voy.|BD|OPR|V.Capa.|BSA.Capa.|Type|Final\nCompany BSA|CHT OUT|Company(%)|CHT(%)|Unit Cost\nPer Slot"
            + headText1;
            var HeadTitle1="Trade|Lane|Vessel|Voy.|BD|OPR|V.Capa.|BSA.Capa.|Type|Final\nCompany BSA|CHT OUT|Company(%)|CHT(%)|Unit Cost\nPer Slot"
            + headText2;
            var cnt=0;
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:6, DataRowMerge:0 } );		//SJH.20141226.MOD : FrozenCol 0->6
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle0, Align:"Center"},
                      { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vsl_capa",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"fnl_co_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_capa",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_rto",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"chtr_bsa_rto",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ts_uc_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_tot",        KeyField:0,   CalcLogic:LOGIC_amt_1_tot,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_01",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_02",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_03",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_04",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_05",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_06",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_07",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_08",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_09",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_10",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_11",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_12",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_13",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_14",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_1_15",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_tot",        KeyField:0,   CalcLogic:LOGIC_amt_2_tot,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_01",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_02",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_03",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_04",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_05",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_06",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_07",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_08",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_09",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_10",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_11",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_12",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_13",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_14",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_2_15",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_tot",        KeyField:0,   CalcLogic:LOGIC_amt_3_tot,Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_01",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_02",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_03",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_04",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_05",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_06",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_07",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_08",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_09",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_10",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_11",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_12",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_13",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_14",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"amt_3_15",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
           
            InitColumns(cols);
            
            SetEditable(0);
            SetCountPosition(0);
            SetWaitImageVisible(0);
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
function f_seltrade_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    formObj.f_cmd.value=SEARCHLIST01;
    var sXml=sheetObj.GetSearchData("ESM_COA_0045GS2.do", coaFormQueryString(formObj));
    var arrXml=sXml.split("|$$|");
    if (arrXml.length > 0) {
        ComXml2ComboItem(arrXml[0], f_selrlane, "code", "name");
        f_selrlane.SetSelectIndex(0);
    }
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
    switch(sAction) {
        case IBCLEAR:
    		//SJH.20150106.ADD/MOD
        	formObj.f_yearM.value=ComGetNowInfo("yy");
            formObj.f_year.value=ComGetNowInfo("yy");            
            formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
            formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");  
            
            ComOpenWait(true);
            var sXml=formObj.sXml.value;            
            var arrXml=sXml.split("|$$|");
            
          	//SJH.20150106.ADD/MOD
            formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
            formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
            formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
            formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
            document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")";  
            
            if (arrXml.length > 0) {
                ComXml2ComboItem(arrXml[0], f_seltrade, "code", "name");
                f_seltrade.SetSelectIndex(0);
            }
            if (arrXml.length > 1) {
                ComXml2ComboItem(arrXml[1], f_selrlane, "code", "name");
                f_selrlane.SetSelectIndex(0);
            }
            if (arrXml.length > 2) {
                ComXml2ComboItem(arrXml[2], f_selioc, "code", "name");
                f_selioc.SetSelectIndex(0);
            }            
            ComSetObjValue(formObj.sXml, "");
            
            ComOpenWait(false);
            break;
        case IBSEARCH:      //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // Prohibit button click when a business transaction is processing 
            ComOpenWait(true);
            if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value=fillZero(formObj.f_fm_mon.value, 2, '0','left');
            if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value=fillZero(formObj.f_to_mon.value, 2, '0','left');
            if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value=fillZero(formObj.f_fm_wk.value, 2, '0','left');
            if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value=fillZero(formObj.f_to_wk.value, 2, '0','left');
            formObj.f_cmd.value=SEARCHLIST;
            sheetObj.DoSearch("ESM_COA_0045GS.do", coaFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8') );
            break;
        case IBDOWNEXCEL:   // Excell download
            var excelType=selectDownExcelMethod(sheetObj);
            break;
        case IBCREATE:      //Create
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            
                if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                    ComOpenWait(true);   
                    
                    setTimeout( function () {
                    	formObj.f_cmd.value=MULTI01;
                        var sParam = sheetObj.GetSaveString(1);
                        if (sheetObj.IsDataModified() && sParam == "") return;
                        sParam = sParam + "&" + FormQueryString(formObj);
                        var sXml = sheetObj.GetSaveData("ESM_COA_0045GS.do", sParam );
        	            sheetObj.LoadSaveData(sXml, {Sync:1});
                        
                        var err_cd = ComGetEtcData(sXml, "err_cd");
                        var err_msg = ComGetEtcData(sXml, "err_msg");	                        
        	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
        	                return false;
        	            }	                
                        if (err_cd == "00000") {
                            ComShowMessage(ComGetMsg('COA10018','CREATION')); 
                        } else if(err_cd == "CHK05"  || err_cd == "CHK11") {
                            // If there is a value omitted when you create company Sales/Slot Cht-out  
                              strUrl="?f_stryear="+formObj.f_year.value;
                              strUrl += "&f_strfmmonth="+formObj.f_fm_mon.value;
                              strUrl += "&f_strtomonth="+formObj.f_to_mon.value;                    
                              strUrl += "&f_strfmweek="+formObj.f_fm_wk.value;
                              strUrl += "&f_strtoweek="+formObj.f_to_wk.value ;                   
                              if(formObj.f_chkprd[0].checked){
                                strUrl += "&f_strchkprd="+"W"    // W:Week, M: Month                
                              } else {
                                strUrl += "&f_strchkprd="+"M"    // W:Week, M: Month                
                              }       
                              if (f_seltrade.GetSelectCode()== "All"){
                                  strUrl += "&f_strtrade=";
                              }else{
                                  strUrl += "&f_strtrade="+f_seltrade.GetSelectCode();
                              }
                              if (f_selrlane.GetSelectCode()== "All"){
                                  strUrl += "&f_strlane=";
                              }else{
                                  strUrl += "&f_strlane="+f_selrlane.GetSelectCode();
                              }
                              strUrl += "&f_strvessel="+formObj.f_vsl_cd.value;
                              strUrl += "&f_strvoyage="+formObj.f_skd_voy_no.value;
                              strUrl += "&f_strdir="+formObj.f_dir_cd.value;
                              strUrl += "&f_strtype="+"3";
                              strUrl += "&f_strprcnm="+"Company Sales/Slot Cht-out";
                              ComOpenWindow2("ESM_COA_0114.do" + strUrl,'', "width=900,height=450,menubar=0,status=0,scrollbars=0,resizable=1");
                        } else if(err_cd == "COA00023") {
                            // If there is a network cost missed 
                              ComShowMessage(err_msg); 
                              return false;
                        } else {
                            ComShowMessage("["+err_cd+"]:"+err_msg);
                            return false;
                        }
                        sheetObj.SetEtcData("err_cd","");
                        sheetObj.SetEtcData("err_msg","");
                        
                        ComOpenWait(false);
                    }, 100);
                }
            
            return true;
            break;
    }
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

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    sheetObj.SetSumText(0,0, "TOTAL");
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

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
