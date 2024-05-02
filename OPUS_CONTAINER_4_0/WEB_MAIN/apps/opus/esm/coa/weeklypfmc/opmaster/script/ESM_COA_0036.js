/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0036.js
*@FileTitle  : Create lane table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheet_height=200; // sheet??height
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
     /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
     var sheetObject=sheetObjects[0];
     /*******************************************************/
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
            case "btn_Rowadd":
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
            case "bu_zoom_in":
                if ( sheetObject.RowCount() < 1 ) return;
                sheetObject.SetSheetHeight( sheetObject.GetSheetHeight(sheet_height) * 2 );
                div_zoom_in.style.display="none";
                div_zoom_out.style.display="inline";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
                break;
            case "bu_zoom_out":
                if ( sheetObject.RowCount() < 1 ) return;
//                sheetObject.SetSheetHeight( 360 );
                resizeSheet();
                div_zoom_in.style.display="inline";
                div_zoom_out.style.display="none";
                if (parent && parent.syncHeight) {
                    parent.syncHeight();
                }
                break;
        } // end switch
    }catch(e) {
        alert(e);
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111", "", ""));
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
 * @author SJH.20150107.MOD
 */ 
function initCombo(comboObj, comboNo) {
    with(comboObj) {
        SetDropHeight(300);
        SetMultiSelect(0);
        SetMaxSelect(1);
        SetMaxLength(3);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
        SetSelectIndex(0);
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
                var HeadTitle="Del.|STS|Trade|Sub Trade|S.Lane|R.Lane|Bound|IOC|Lane T/P|Step Up/Down|Sector Price|T/P|Eur.|T/A|Intra Asia/\nIntra Europe|Trunk\nIPC|Pendulum\nFlag|Load to BSA|Sub Desc|History\nFlag|Del Mark";
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:3, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                            {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                            {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"stup_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"CheckBox",  Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sctr_prc_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trns_pcf_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eur_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trns_atlan_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"intr_asia_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trnk_ipt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pndlm_lane_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lod_spl_cng_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"sub_trd_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lane_tp_his_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
                InitColumns(cols); 
                
                SetEditable(1);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
				resizeSheet();
                SetColProperty(0 ,"trns_pcf_flg"   , {AcceptKeys:"[Y,N]", InputCaseSensitive:1});
                SetColProperty(0 ,"eur_flg"        , {AcceptKeys:"[Y,N]", InputCaseSensitive:1});
                SetColProperty(0 ,"trns_atlan_flg" , {AcceptKeys:"[Y,N]", InputCaseSensitive:1});
                SetColProperty(0 ,"intr_asia_flg"  , {AcceptKeys:"[Y,N]", InputCaseSensitive:1});
                SetColProperty(0 ,"trnk_ipt_flg"   , {AcceptKeys:"[Y,N]", InputCaseSensitive:1});
                SetColProperty(0 ,"delt_flg"       , {AcceptKeys:"[Other Char]"});
                SetColProperty(0 ,"slan_cd"        , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                SetColProperty(0 ,"rlane_cd"        , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                InitComboNoMatchText(1,"",1);
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
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
    var formObj=document.form;
    if(formObj.f_chkdel.checked){
        sheetObj.SetColHidden(0,1);
    }else{
        sheetObj.SetColHidden(0,0);
    }// end if
}
// trade code가 변경되었을때 sub trade combo를 변경시킨다.
function sheet1_OnChange(sheetObj, row, col, value){
    var formObj=document.form;
    if ("trd_cd"==sheetObj.ColSaveName(col)) {
        doActionIBSheet(sheetObj,formObj,IBROWSEARCH);
    }
}
   
 /**
        * open window
  */
 function sheet1_OnDblClick(sheetObj, row, col, value){
    var param="?";
    param=param + "f_trd_cd=" + sheetObj.GetCellValue(row, "trd_cd");
    param=param + "&f_rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd");
    param=param + "&f_dir_cd=" + sheetObj.GetCellValue(row, "dir_cd");
    param=param + "&f_ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
    ComOpenWindow2('ESM_COA_0145.do'+param,'', 'width=900,height=440,menubar=0,status=0,scrollbars=0,resizable=0');
}
//20150522.ADD
function retrieve(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
/**
 * Handling process about the sheet object
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=INIT;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0036GS3.do", coaFormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            if (arrXml.length > 0)
	                ComXml2ComboItem(arrXml[0], f_cbotrade, "code", "name");
	                f_cbotrade.SetSelectIndex(0);
	            if (arrXml.length > 1)
	                ComXml2ComboItem(arrXml[1], f_cboslane, "code", "name");
	                f_cboslane.SetSelectIndex(0);
	            if (arrXml.length > 2)
	                ComCoaSetIBCombo(sheetObj, arrXml[2], "trd_cd", true, 0);
	            if (arrXml.length > 3)
	                ComCoaSetIBCombo(sheetObj, arrXml[3], "sub_trd_cd", true, 0);
	            if (arrXml.length > 4)
	                ComCoaSetIBCombo(sheetObj, arrXml[4], "vsl_lane_tp_cd", true, 0);
	            if (arrXml.length > 5)
	                ComCoaSetIBCombo(sheetObj, arrXml[5], "dir_cd", true, 0);
	            if (arrXml.length > 6)
	                ComCoaSetIBCombo(sheetObj, arrXml[6], "ioc_cd", true, 0);
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
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST01;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0036GS.do", coaFormQueryString(formObj));
	            sheetObj.LoadSearchData(sXml,{Sync:1} );
	            ComOpenWait(false);
            }, 100);
            break;
        case IBSAVE:        //Save
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // You must input one of the T/P, Eur., T/A, Intra Asia and Trunk IPC
            // Otherwise an error message
            //-------------------------------------------------------------------------------
            var findData=sheetObj.FindStatusRow("I|U");
            var arRow=findData.split(";");
            var cnt=0;
            if(arRow.length > 1){
                for(j=0; j<arRow.length ; j++){
                    if(arRow[j] != ""){
                        if(sheetObj.GetCellValue(arRow[j], "trns_pcf_flg") == "Y") cnt++;
                        if(sheetObj.GetCellValue(arRow[j], "eur_flg") == "Y") cnt++;
                        if(sheetObj.GetCellValue(arRow[j], "trns_atlan_flg") == "Y") cnt++;
                        if(sheetObj.GetCellValue(arRow[j], "intr_asia_flg") == "Y") cnt++;
                        if(sheetObj.GetCellValue(arRow[j], "trnk_ipt_flg") == "Y") cnt++;
                        if(cnt>1){
                            // [COA10026] : You must input one of the T/P, Eur., T/A, Intra Asia and Trunk IPC
                            ComShowMessage(ComGetMsg("COA10026", "T/P, Eur., T/A, Intra Asia, Trunk IPC "));
                            sheetObj.SelectCell(arRow[j], "trns_pcf_flg");
                            return false;
                        }
                        cnt=0;
                    }
                }
            }
            //-------------------------------------------------------------------------------
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI01;            
            sheetObj.DoSave("ESM_COA_0036GS.do", coaFormQueryString(formObj));			//SJH.20150107.MOD
            ComOpenWait(false);
            break;
        case IBROWSEARCH:
            formObj.f_cmd.value=MULTI02;
            sheetObj.DoRowSearch(sheetObj.GetSelectRow() , "ESM_COA_0036GS2.do?sRow=" +sheetObj.GetSelectRow()+ "&trade=" +sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trd_cd") , coaFormQueryString(formObj,'f_cmd',true));
            
            break;
        case IBINSERT:      // Insert
            sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(sheetObj.LastRow(), "delt_flg","N",0);
            sheetObj.SetCellValue(sheetObj.LastRow(), "stup_flg","0",0);
            break;
        case IBDOWNEXCEL:        // Excell download
            var excelType= selectDownExcelMethod(sheetObj);            
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

//SJH.20150107.ADD : 저장후 메시지 추가
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
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
    }
    return true;
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
