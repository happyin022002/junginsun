/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0039.js
*@FileTitle  : Lane Transit-time
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
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
            case "btn_Save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * Reflash the rLane list when a trade code is changed
 */
function f_seltrade_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    formObj.f_cmd.value=SEARCHLIST02;
    var sXml=sheetObj.GetSearchData("ESM_COA_0039GS2.do", coaFormQueryString(formObj));
    var arrXml=sXml.split("|$$|");
    if (arrXml.length > 0)
        ComXml2ComboItem(arrXml[0], f_selrlane, "code", "name");
    f_selrlane.SetSelectIndex(0);
}
/**
 * Change period when the month, week changed
 */
function setPeriod(obj){
    ComCoaSetPeriod(obj);
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
    document.form.f_year.focus();
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
 * @SJH.20150106.MOD
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
        case "f_seldir":
                SetMaxLength(1);
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
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
              var HeadTitle="STS|YYYY-WW|VSL CD|Voy.|Dir.|Continent|S. Lane|Trade|Rev. Lane|IOC|Loc.|Call Ind.|SEQ|Port Day|Sea Day|Total Days|Apply (%)|Pendulum (%)|Remark";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrwk",        KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conti_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_dbl_call_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clpt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"port_dys",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                     {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"sea_dys",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                     {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_tz_dys",        KeyField:0,   CalcLogic:"|sea_dys|+|port_dys|",Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"aply_voy_rto",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                     //20151029.ADD
                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pndlm_rto",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                     {Type:"Text",      Hidden:0,  Width:1000, Align:"Left",    ColMerge:1,   SaveName:"vvd_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3000 } ];
               
              InitColumns(cols);

              SetEditable(1);//Editkind[optional,Defaultfalse]
              SetCountPosition(0);
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
/**
 * Change row color when the number of the sea_dys and port_dys is negative
 */
function sheet1_OnChange(sheetObj, row, col, value){
    if(sheetObj.ColSaveName(col) == "sea_dys" ||
       sheetObj.ColSaveName(col) == "port_dys"){
        if(sheetObj.GetCellValue(row, "sea_dys") < 0 || sheetObj.GetCellValue(row, "port_dys") <0 ){
            sheetObj.SetRowBackColor(row,"#F7E7EC");
        } else {
            sheetObj.SetRangeBackColor(row,0, row,12,"#EFEBEF");
            sheetObj.SetRangeBackColor(row,13, row,14,"#FFFFFF");
            sheetObj.SetRangeBackColor(row,15, row,16,"#EFEBEF");
        }
    }
}
function sheet1_OnDblClick(sheetObj , row, col){
    var vvd="";
    var classId="COM_ENS_0B1";
    var param="";
    vvd=sheetObj.GetCellValue(row, "vsl_cd")+sheetObj.GetCellValue(row, "skd_voy_no")+sheetObj.GetCellValue(row, "dir_cd");
    param='?vvd_cd='+vvd+'&classId='+classId;
    ComOpenPopup("/opuscntr/COM_ENS_0B1.do"+param, 630, 470, "", "0,0,1,1,1,1,1,1,1,1", true);
}
/**
 * Handling process about the sheet object
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);// Prohibit button click when a business transaction is processing
    switch(sAction) {
        case IBCLEAR:          //Inquiry
        	//SJH.20150106.ADD/MOD
        	formObj.f_yearM.value=ComGetNowInfo("yy");
	        formObj.f_year.value=ComGetNowInfo("yy");            
	        formObj.f_fm_mon.value=ComGetNowInfo("mm").lpad(2, "0");
	        formObj.f_to_mon.value=ComGetNowInfo("mm").lpad(2, "0");   
	        
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=INIT;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0039GS2.do", coaFormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            if (arrXml.length > 0)
	                ComXml2ComboItem(arrXml[0], f_seltrade, "code", "name");
	                f_seltrade.SetSelectIndex(0);
	            if (arrXml.length > 1)
	                ComXml2ComboItem(arrXml[1], f_selrlane, "code", "name");
	                f_selrlane.SetSelectIndex(0);
	            if (arrXml.length > 2)
	                ComXml2ComboItem(arrXml[2], f_seldir, "code", "name");
	                f_seldir.SetSelectIndex(0);
	            if (arrXml.length > 3)
	                ComXml2ComboItem(arrXml[3], f_selioc, "code", "name");
	                f_selioc.SetSelectIndex(0);
	                
              	//SJH.20150106.ADD/MOD
                formObj.f_yearW.value=ComGetEtcData(arrXml[0], "prevWeekY");
                formObj.f_year.value=ComGetEtcData(arrXml[0], "prevWeekY"); 
                formObj.f_fm_wk.value=ComGetEtcData(arrXml[0], "prevWeekW");
                formObj.f_to_wk.value=ComGetEtcData(arrXml[0], "prevWeekW"); 
                document.getElementById("div_period").innerHTML="("+ComGetEtcData(arrXml[0], "period") +")"; 
                
	            ComOpenWait(false);
            }, 100);
            break;  
        case IBSEARCH:      //Inquiry
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            if (sheetObj.IsDataModified()&& ComShowCodeConfirm("COM130504")) {
                //validation check
                if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
                    return false;
                }
            }
            ComOpenWait(true);
            if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value=fillZero(formObj.f_fm_mon.value, 2, '0','left');
            if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value=fillZero(formObj.f_to_mon.value, 2, '0','left');
            if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value=fillZero(formObj.f_fm_wk.value, 2, '0','left');
            if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value=fillZero(formObj.f_to_wk.value, 2, '0','left');
            formObj.f_cmd.value=SEARCHLIST01;
            sheetObj.DoSearch("ESM_COA_0039GS.do", coaFormQueryString(formObj) );
//            ComOpenWait(false);
            break;
        case IBSAVE:        //Save
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI01;
            sheetObj.DoSave("ESM_COA_0039GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
            ComOpenWait(false);
            break;
        case IBDOWNEXCEL:        // Excell download
            //sheetObj.SpeedDown2Excel(-1);
            var excelType=selectDownExcelMethod(sheetObj);
            break;
    }
}

function callBackExcelMethod(excelType){
	 switch (excelType) {
	     case "AY":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	         break;
	     case "AN":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
	     case "DY":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	     	break;
	     case "DN":
	    	 sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
	 }
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
	sheetObj.SetSumText(0,3, "TOTAL");
}	

//SJH.20150106.ADD : 저장후 메시지 추가
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if(ErrMsg == ""){
        // [COM130102] : Success
    	ComShowMessage(ComGetMsg("COM130102","Data"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
} 

/**
* Handling process for form object input validation
* SJH.20150106.ADD
*/
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(!chkValidSearch()) return false;
    }
    return true;
}
/**
 * VVD code 입력후 유효성을 체크한다.
 */
function chkVVD(){
    var formObj=document.form;
}
/**
 * VVD 유효성 결과는 넘겨준다.
 */
function isValidVVD(result){
    var formObj=document.form;
    if(!result){
        ComShowMessage(ComGetMsg("COM12114","VVD",""));
        formObj.f_vsl_cd.value="";
        formObj.f_skd_voy_no.value="";
        formObj.f_dir_cd.value="";
        formObj.f_vsl_cd.focus();
    }
}
function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
