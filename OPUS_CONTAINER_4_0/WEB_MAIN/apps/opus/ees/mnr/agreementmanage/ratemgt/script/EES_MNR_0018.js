/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0018.js
*@FileTitle  : M&R Agreement List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_mnr_0018 : business script for ees_mnr_0018.
     */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;    
var initLoader=0;
var strMnrOfficeLevel="";   // Office level of login user : HO level -> L1, RHQ level -> L2, Office level -> L3 (MnrOfficeLevel reference at CoMnr.js)
var oldAgmtGrpList = "";
var agmtGrpList = "";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            case "btn_new":
                doActionIBSheet(sheetObject1,formObject,IBCLEAR);
                break;
            case "btn_popup":
                ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 500, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
                break;      
            case "btn_detail":
                var agmt_no=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "agmt_no");
                var agmt_ofc_cd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "agmt_ofc_cd");
                if(sheetObject1.RowCount()>0){
                    ComOpenPopup('/opuscntr/EES_MNR_0218.do?agmt_no='+agmt_no+'&agmt_ofc_cd='+agmt_ofc_cd, 1050, 700, '', "0,1,1,1,1,1", true);
                }
                else
                {
                    //2013-08-27 Recover PQC Test defects by J.H Han 
                    ComShowCodeMessage('MNR00204', '');
                }
                break;  
            case "btn_downexcel":
                if(sheetObject1.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                }
                break;
            case "cre_dt_cal":
                var cal=new ComCalendarFromTo();
                cal.select(formObject.agmt_fm_dt, formObject.agmt_to_dt, 'yyyy-MM-dd');
                break;      
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComFuncErrMsg(e);
        } else {
            ComFuncErrMsg(e);
        }
    }
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    initControl();
    MnrWaitControl(true);
    agmtGrpList = getAgmtGrpList(sheetObjects[0], "A");
    oldAgmtGrpList = agmtGrpList;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    //initializing IBMultiCombo 
    for(var k=0;k<comboObjects.length;k++){ 
        initCombo(comboObjects[k],k + 1);  
    }   
    if(rhqOfcCd == ""){
    	rhqOfcCd = getRhqOfcCode(sheetObjects[0], currOfcCd);
    }
    //setting on strMnrOfficeLevel and retrieving Office Level
    MnrOfficeLevel(currOfcCd,rhqOfcCd);
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}
/**   
 * setting combo basic info    
 * @param   {IBMultiCombo}  combo_obj   ComboObject. 
 * @param   {Number}    comboNo     ComboObject tag serial number 
 * adding case as numbers of counting combos 
 */     
function initCombo (comboObj, comboNo) {        
    var formObject=document.form
    switch(comboNo) {    
        case 1: 
            with (comboObj) { 
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                SetColWidth(0, "80");
                SetColWidth(1, "100");
                SetDropHeight(160);
                SetUseAutoComplete(1);
            }      
            break;    
        case 2: 
            with (comboObj) { 
                SetMultiSeparator("|");
                SetTitle("Office Code|Office Name");
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                //SetColWidth("100|150"); 
                SetDropHeight(160);
                SetUseAutoComplete(1);
                ValidChar(2);
	            SetTitleVisible(1);
	            SetMaxLength(6);
            }      
            break;    
        case 3: 
            with (comboObj) { 
                SetMultiSeparator("|");
                SetTitle("Office Code|Office Name");
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                //SetColWidth("100|150");
                SetDropHeight(160);
                SetUseAutoComplete(1);
                ValidChar(2);
	            SetTitleVisible(1);
	            SetMaxLength(6);
            }      
            break;  
        case 4: 
            with (comboObj) { 
                SetMultiSeparator("|");
                SetTitle("Office Code|Office Name");
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                //SetColWidth("100|150");        
                SetDropHeight(160);
                SetUseAutoComplete(1);
                ValidChar(2);
	            SetTitleVisible(1);
	            SetMaxLength(6);
            }      
            break; 
     } 
}     
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      // sheet1 init
            with(sheetObj){
                var HeadTitle="|Seq.|Regional H/O|AGMT OFC|EQ Type|AGMT No.|Delete Flag|Tariff No.|Ref. No.|S/P Code|S/P Name|Eff Date|Create User|Create Date/Time|Last Update User|Last Update Date/Time";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:4, DataRowMerge:1 } );
                
                oldAgmtGrpList = agmtGrpList;
    			var arrAgmtGrpList = "";
    			if(oldAgmtGrpList != ""){
    				arrAgmtGrpList = oldAgmtGrpList.split("|");
    			}

    			//handling header title by changing column
				if (agmtGrpList != "") {
					HeadTitle += "|" + oldAgmtGrpList;
				}
				
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
                            {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rhq_ofc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mnr_cd_dp_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"trf_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:185,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",    ColMerge:0,   SaveName:"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",    ColMerge:0,   SaveName:"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },];
               

			    var sCount = "";
				var x = 1;
				var width = 0;
	
				for (var i = 0; i < arrAgmtGrpList.length; i++) {
					if (arrAgmtGrpList.length > 1) {
						sCount = "chk" + x;
						if(arrAgmtGrpList[i].length > 10){
							width = 100;
						}else{
							width = 60;
						}
						cols.push({Type : "Text", Hidden : 0, Width : width, Align : "Center", ColMerge : 0, SaveName : sCount, KeyField : 0, CalcLogic : "", Format : "", PointCount :0, UpdateEdit :0, InsertEdit :0});
						x++;
					}
				}
	              
                InitColumns(cols);
                
                SetEditable(1);
                SetSelectionMode(smSelectionRow);
//                SetSheetHeight(402);
                resizeSheet( sheetObj );
            }

            break;
    }
}
function initControl() {  
    //Axon handling event1. event catch  
//    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);            
//    axon_event.addListenerFormat('focus',   'obj_activate',    form);            
    axon_event.addListenerFormat('keypress', 'obj_keypress',    form);            
    axon_event.addListenerFormat('change',   'obj_change',  form); 
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
 * registering IBCombo Object as list
 * @param   {IBMultiCombo}  combo_obj   adding ComboObject. 
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj){    
    comboObjects[comboCnt++]=combo_obj;  
}    
/**
 * HTML Control deactivate event <br>
 **/
function obj_deactivate(){    
    // 2013-08-27 Recovery PQC test defects by J.H Han
    var obj=ComGetEvent();
    var formObj=document.form;
    if ( ComTrim(obj.value) != "" ) {
        switch(ComGetEvent("name")) {
            case "agmt_fm_dt":
                ComAddSeparator(obj, "ymd");
                break;
            case "agmt_to_dt":
                ComAddSeparator(obj, "ymd");
                break;
        }
    }
} 
/**
 * HTML Control activate event <br>
 **/
function obj_activate(){   
    ComClearSeparator(ComGetEvent());
}        
function obj_change(){     
    var obj=ComGetEvent(); 
    var formObj=document.form; 
    var sheetObj=sheetObjects[0]; 
    if ( ComTrim(obj.value) != "" ) {
        switch(ComGetEvent("name")) {      
            case "vndr_seq":   
                vndr_seq_confirm();  
                doActionIBSheet(sheetObj,formObj,IBSEARCH);
                break;  
             // 2013-08-27 Recovery PQC test defects by J.H Han
            case "agmt_fm_dt":
                if(ComGetDaysBetween(formObj.agmt_fm_dt.value, formObj.agmt_to_dt.value) < 0){
                    ComShowCodeMessage("MNR00366");
                    ComClearSeparator(formObj.agmt_fm_dt);
                    ComSetFocus(formObj.agmt_fm_dt);
                }
                break;
            // 2013-08-27 Recovery PQC test defects by J.H Han  
            case "agmt_to_dt":
                if(ComGetDaysBetween(formObj.agmt_fm_dt.value, formObj.agmt_to_dt.value) < 0){
                    ComShowCodeMessage("MNR00366");
                    ComClearSeparator(formObj.agmt_to_dt);
                    ComSetFocus(formObj.agmt_to_dt);
                }
                break;
        }       
    } 
}    
/**
 * HTML Control keypress event <br>
 **/     
function obj_keypress(){     
    obj=ComGetEvent();    
    if(obj.dataformat == null) return; 
    window.defaultStatus=obj.dataformat;
    switch(obj.dataformat) {  
        case "ymd":   
        case "int":    
            ComKeyOnlyNumber(obj); 
            break;     
        case "float":   
            ComKeyOnlyNumber(obj, ".");
            break; 
        case "eng":   
            ComKeyOnlyAlphabet();
            break;   
        case "engup": 
            if(obj.name=="vndr_seq"){ 
                ComKeyOnlyNumber(obj);     
            }else{
                ComKeyOnlyAlphabet('uppernum'); 
            }       
            break;    
    }
}   
/**  
 * combo1 Change event      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  
//function combo1_OnChange(comboObj,Index_Code, Text){ 
function combo1_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;        
    formObj.agmt_eq_type.value=comboObj.GetSelectCode();
    
    sheetObjects[0] = sheetObjects[0].Reset();
    sheetObj = sheetObjects[0];
    agmtGrpList = getAgmtGrpList(sheetObjects[0], comboObj.GetSelectCode());
    oldAgmtGrpList = agmtGrpList;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
}       
/**  
 * combo2 Change event      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  
//function combo2_OnChange(comboObj,Index_Code, Text){ 
function combo2_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;       
    if(comboObj.GetSelectCode()=="A"){
        formObj.ar_hd_qtr_cd.value=""; 
    }else{
        formObj.ar_hd_qtr_cd.value=comboObj.GetSelectCode();
    }
    getAgmtOfcCd(comboObj,NewCode, NewText);
}  
/**  
 * combo3 Change event      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */     
//function combo3_OnChange(comboObj,Index_Code, Text){ 
function combo3_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;     
    if(comboObj.GetSelectCode()=="A"){
        formObj.agmt_ofc_cd.value=""; 
    }else{
        formObj.agmt_ofc_cd.value=comboObj.GetSelectCode();
    }
}  
/**  
 * combo4 Change event      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  
//function combo4_OnChange(comboObj,Index_Code, Text){ 
function combo4_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;      
    if(comboObj.GetSelectCode()=="A"){
        formObj.cost_ofc_cd.value=""; 
    }else{
        formObj.cost_ofc_cd.value=comboObj.GetSelectCode();
    }
}  
/**
 * handling process sheet
 * @param   {IBSheet}   sheetObj    handling sheetObject 
 * @param   {Form}      formObj     handling formObject
 * @param   {Number}    sAction     Action constants  
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH:      //retrieving
            if(validateForm(sheetObj,formObj,sAction)){
                if(sheetObj.id =="sheet1"){       
                    formObj.f_cmd.value=SEARCH; 
                    sheetObj.DoSearch("EES_MNR_0018GS.do",FormQueryString(formObj) );
                }  
            }   
            break;
        case IBCLEAR:        //initializing
            MnrWaitControl(true);
            sheetObj.SetWaitImageVisible(0);
            if(initLoader == 0){
                //initializing combo
                for(var i=0; i < comboObjects.length;i++){ 
                    comboObjects[i].RemoveAll();
                }   
                var sCondition=new Array (
                    new Array("MnrGenCd","","CUSTOM9"), //Eq Kind
                    new Array("MdmOrganization","RHQ","FALSE")  //Regional HQ
                );   
                var comboList=MnrComSearchCombo(sheetObj,sCondition);
                //setting combo
                for(var i=0; i < comboList.length;i++){
                    if(comboList[i] != null){
                        //initializing sheetCombo
                        sheetComboText="";
                        sheetComboCode="";
                        for(var j=0; j < comboList[i].length;j++){ 
                            var tempText=comboList[i][j].split("|");
                            sheetComboText +=  tempText[1] + "|";
                            sheetComboCode +=  tempText[0] + "|";
                            //Eq Kind
                            if(i==0) {
                                combo1.InsertItem(j, tempText[1] ,tempText[0]);
                            }else if(i==1){ //Regional HQ
                                combo2.InsertItem(j, comboList[i][j] ,tempText[0]);
                            }
                        }
                    }
                }
                combo1.InsertItem(0, "ALL" ,"A" );
                combo1.SetSelectCode("A");
                formObj.agmt_eq_type.value=combo1.GetSelectCode();
                combo2.InsertItem(0, "ALL" ,"A" );
//                if(strMnrOfficeLevel=="L1"){
//                    combo2.SetSelectCode("A");
//                }else{
//                    combo2.SetEnable(0);
//                    combo2.SetSelectCode(rhqOfcCd);
//                }
                if(formObj.strAccess_system.value=="SPP"){
                    formObj.vndr_seq.value=ComLpad(formObj.strVndr_seq.value,6,"0");
                    formObj.vndr_lgl_eng_nm.value=formObj.strVndr_nm.value;
                    MnrFormSetReadOnly(formObj,true,"vndr_seq");
                    formObj.btn_popup.style.display="none";
                    combo2.SetEnable(0);
                }
                initLoader=1;   
            }
            //initializing sheet   
            for(i=0;i<sheetObjects.length;i++){   
                sheetObjects[i].RemoveAll();
            }  
            combo1.SetSelectCode("A");
            combo2.SetSelectCode("A");
//            if(initLoader != 0){
//            	getAgmtOfcCd(combo2,"A", "ALL");
//            }
            formObj.agmt_fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
            formObj.agmt_to_dt.value=ComGetNowInfo();
            sheetObj.SetWaitImageVisible(1);
            formObj.vndr_seq.value = "";
            formObj.vndr_lgl_eng_nm.value = "";
            
            MnrWaitControl(false);
            break;
        case IBDOWNEXCEL:
            //sheetObj.Down2Excel(-1);   
            sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol( sheetObj), SheetDesign:1,Merge:1 });
            break;
            
    }
}
/**
 * handling process for input validation
 * @param   {IBSheet}   sheetObj    checking sheetObject 
 * @param   {Form}      formObj     checking comboObject
 * @param   {Number}    sAction     Action constants  
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(formObj.agmt_eq_type.value == "" ) {
            ComAlertFocus(combo1, ComGetMsg('MNR00003'));
            return;
        } else if(formObj.agmt_fm_dt.value == "") {
            ComAlertFocus(formObj.agmt_fm_dt, ComGetMsg('MNR00003'));
            return;
        } else if(formObj.agmt_to_dt.value == "") {
            ComAlertFocus(formObj.agmt_to_dt, ComGetMsg('MNR00003'));
            return; 
        }
        // 2013-08-27 Recovery PQC test defects by J.H Han
        if(ComGetDaysBetween(formObj.agmt_fm_dt.value, formObj.agmt_to_dt.value) < 0){
            ComShowCodeMessage("MNR00366");
            ComClearSeparator(formObj.agmt_fm_dt);
            ComSetFocus(formObj.agmt_fm_dt);
            return;
        }
    }
    return true;        
}       
/**  
 * checking whether ofc_cd exists or not    
 */     
function ofc_cd_confirm(fieldName){
    var retArray=null;        
    var formObj=document.form;
    var checkOffice=formObj[fieldName].value;               
    if (checkOffice!=""){
        retArray=MnrGeneralCodeCheck(sheetObjects[0],"OFC",checkOffice);      
        if(retArray == null){           
            ComShowCodeMessage("MNR00165",checkOffice);  
            formObj[fieldName].value="";
            formObj[fieldName].focus();
        }   
    }
}
/**  
 * checking whether vndr_seq exists or not    
 */             
function vndr_seq_confirm(){
    var formObj=document.form;
    if(formObj.vndr_seq.value != ""){ 
        //retrieving service provider 
        var sCondition=new Array ( 
            new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
        )                            
        //setting in case of existing retrieving result
        var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
        if(comboList[0] != null){
            var tempText=comboList[0][0].split("|"); 
            formObj.vndr_lgl_eng_nm.value=tempText[1];  
        } else {       
            ComShowCodeMessage("MNR00005", "Service Provider");              
            ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
            ComSetObjValue(formObj.vndr_seq, "");
            ComSetFocus(formObj.vndr_seq);
        }   
    }
}
/**
 * getCOM_ENS_0C1 receiving function values ??from Pop-up   
 * @param   {String[][]}    aryPopupData    return value from pupup
 */   
function getCOM_ENS_0C1(aryPopupData, row, col, sheetIdx){
    var formObj=document.form;
    var vndrSeq="";
    var vndrNm="";
    var i=0;
    for(i=0; i < aryPopupData.length; i++){
        vndrSeq=vndrSeq + aryPopupData[i][2];
        if(aryPopupData.length == 1){
            vndrNm=vndrNm + aryPopupData[i][4];
        }
        if(i < aryPopupData.length - 1){
            vndrSeq=vndrSeq + ",";
        }
    }
    formObj.vndr_seq.value=vndrSeq;
    formObj.vndr_lgl_eng_nm.value=vndrNm;
}
/**
 * retrieving Agreement Office of Regional HQ
 * @param comboObj
 * @param Index_Code
 * @param Text
 * @return
 */   
function getAgmtOfcCd(comboObj,Index_Code, Text){ 
    var formObj=document.form;
    combo3.RemoveAll();
    combo4.RemoveAll();
    var sCondition=new Array (      
        new Array("MdmOrganization","SEARCH",Index_Code) 
    )                                
    var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
    if(comboList[0] != null){      
        for(var j=0; j < comboList[0].length;j++){  
            var tempText=comboList[0][j].split("|");  
            combo3.InsertItem(j,comboList[0][j] ,tempText[0]);
            combo4.InsertItem(j,comboList[0][j] ,tempText[0]);
        }             
        combo3.InsertItem(0, "ALL" , "A");
        combo4.InsertItem(0, "ALL" , "A");
        combo3.SetSelectCode("A");
        combo4.SetSelectCode("A");
        
      //setting initial value
//		if(strMnrOfficeLevel=="L3"){
//			combo3.SetSelectCode(currOfcCd);
//			combo3.SetEnable(0); //Local Office 
//			combo4.SetSelectCode(currOfcCd);
//			combo4.SetEnable(0); //Local Office 
//		}
    } 
} 
/* developer job */
