/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0043.js
*@FileTitle  : AVG-hire by Own-VSL
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
/**
 * Event handler processing by button name
 */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Retrieve":
                if(sheetObject.IsDataModified()){
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                }
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
            case "btn_Downexcel":
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                }
                break;
            case "btn_loadexcel":
                doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
            case "btn_rowadd":
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111","",""));
        } else {
            ComShowMessage(e);
        }
    }
}
/**
 * Setting week value
 * setYrWk('25')
 *
 * @param Previous Week
 * @return NONE
 */
function setYrWk(prevWeek){
    var formObj=document.form;
    with(formObj){
        var nowYear=ComGetNowInfo("yy");
        f_yearweek.value=nowYear+prevWeek;
        if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
        f_yearweek.select();
        // display period
        setPeriod(f_yearweek);
    }
    fnYearWeekSet(document.getElementById("f_yearweek"));
}
/**
 * Setting this month
 * setYrMon()
 *
 * @param NONE
 * @return NONE
 */
function setYrMon(){
    var formObj=document.form;
    with(formObj){
        var nowYear=ComGetNowInfo("yy");
        var nowMon=ComGetNowInfo("mm");
        if ( nowMon.length == 1 ) nowMon="0" + nowMon; // conversion : 1month -> 01month 
        var nowYrMon=nowYear + nowMon;
        f_yearweek.value=nowYrMon;
        if(!ComAddSeparator(f_yearweek)) return false;
        //f_yearweek.select();
        // display period
        setPeriod(f_yearweek);
    }
    fnYearWeekSet(document.getElementById("f_yearweek"));
}
function fnYearWeekSet(obj){        
    if ( document.form.f_yrtype[0].checked ) {
        obj.value=ComGetMaskedValue(obj.value,"ym");
    } else {
        obj.value=ComGetMaskedValue(obj.value,"yw");
    }
    setPeriod(obj);
}
function ComAddSeparator_Local(obj, sFormat) {
    try {
        obj.value=obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * Change period when the month, week changed
 */
function setPeriod(obj){
    var formObj=document.form;
    if ( formObj.f_yrtype[0].checked ) {
        sheetObjects[0].SetColHidden("cost_wk",1);
        
    }else if ( formObj.f_yrtype[1].checked ) {
        sheetObjects[0].SetColHidden("cost_wk",0);
    }
    ComCoaSetPeriod2(obj);
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage(header, headerNM) {
    loadingMode=true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode=false;
}
/**
 * Setting multicombo items
 */
function initCombo(comboObj, comboId) {
    with (comboObj) {
        SetDropHeight(300);
        SetSelectIndex(0);
        ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
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
function initSheet(sheetObj,sheetNo, header, headerNM) {
    var cnt=0;
    var aryCD="";
    var aryNo="";
    var colNo=0;
    aryCD=header.split("|");
    aryNo=aryCD.length;
    switch(sheetNo) {
        case 1:      //sheet1 init
            colNo=aryNo + 7;
            with(sheetObj){
                var HeadTitle="STS|YYYY-MM|Week|VSL Code|VSL Class|"+headerNM+"|Total|Remark";
                var tot="";
                
                for(j=0; j<aryNo; j++){
                    tot += "|t"+aryCD[j]+"|";
                    if(j != aryNo-1)tot += "+";
                }
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon",     KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_wk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"vsl_clss_capa",  KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

                for(j=0; j<aryNo; j++) {
                    cols.push({Type:"AutoSum",   Hidden:0, Width:160,  Align:"Right",   ColMerge:0,   SaveName:"t"+aryCD[j],     KeyField:0,   CalcLogic:"",   Format:"Int", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:27, AcceptKeys:"N" });
                }

                cols.push({Type:"AutoSum",   Hidden:0, Width:150,   Align:"Right",   ColMerge:0,   SaveName:"",               KeyField:0,   CalcLogic:tot,  Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
                //SJH.20141230.MOD : WIDTH 150->200
                cols.push({Type:"Text",      Hidden:0,  Width:220,   Align:"Left",    ColMerge:0,   SaveName:"own_vsl_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 });
                
                InitColumns(cols);
                
                SetEditable(1);//Editkind[optional,Defaultfalse]
                SetCountPosition(4);								//SJH.20141223.MOD : 우측하단
                SetColProperty(0 ,"cost_wk" , {AcceptKeys:"N"});
                SetColProperty(0 ,"vsl_cd"  , {AcceptKeys:"E"   , InputCaseSensitive:1});
//                SetSheetHeight(430) ;
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

function sheet1_OnSearchEnd(sheetObj, errMsg){
    sheetObj.SetSumText(0,0,"");
    sheetObj.SetSumText(0,1,"TOTAL");				//SJH.20141223.MOD
    var formObj=document.form;
    if ( formObj.f_yrtype[0].checked ) {
        sheetObjects[0].SetColHidden("cost_wk",1);
    }else if ( formObj.f_yrtype[1].checked ) {
        sheetObjects[0].SetColHidden("cost_wk",0);
    }
    //SJH.20141226.ADD
    //sheetObj.SetColWidth("own_vsl_rmk", 0);
}
// Handling process about the sheet object
var xml_param;
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=INIT;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0043GS2.do", coaFormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            if (arrXml.length > 0) {
	                for (i=0;i<sheetObjects.length;i++) {
	                    ComConfigSheet(sheetObjects[i]);
	                    initSheet(sheetObjects[i],i+1, ComGetEtcData(arrXml[0],"headerCD"), ComGetEtcData(arrXml[0],"headerNM"));
	                    ComEndConfigSheet(sheetObjects[i]);
	                }
	                ComSetObjValue(formObj.f_header, ComGetEtcData(arrXml[0],"headerCD"));
	                ComXml2ComboItem(arrXml[0], f_selvessel, "code", "name");
	                formObj.f_yrtype[1].onclick=function(){setYrWk(ComGetEtcData(arrXml[0],"prevWeek"))};
	                f_selvessel.SetSelectIndex(0);
	            }
	            setYrMon();  // Setting this month
	            ComOpenWait(false);
            }, 100);
            break;  
        case IBSEARCH:      //Inquiry
            ComAddSeparator_Local(formObj.f_yearweek, "-");
            if(validateForm(sheetObj,formObj,sAction)){
                // Prohibit button click when a business transaction is processing 
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                setTimeout( function () {
	                formObj.f_cmd.value=SEARCHLIST01;
	                if ( formObj.f_yrtype[0].checked ) {
	                    formObj.f_yearweek.value=ComGetMaskedValue(formObj.f_yearweek.value,"ym");
	                } else {
	                    formObj.f_yearweek.value=ComGetMaskedValue(formObj.f_yearweek.value,"yw");
	                }
	                var xmlEtc=sheetObj.GetSearchData("ESM_COA_0043GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
	                var xml1=ComGetEtcData(xmlEtc,'xml1');;
	                sheetObjects[0].SetVisible(1);
	                sheetObjects[0].LoadSearchData(xml1,{Sync:1} );
	                sheetObjects[0].RemoveEtcData(); // Delete ETC data
	                
	                ComOpenWait(false);
                }, 100);
            }
            break;
        case IBSAVE:        //Save
//            ComAddSeparator_Local(formObj.f_yearweek, "-");
            if(validateForm(sheetObj,formObj,sAction)){
                // Prohibit button click when a business transaction is processing 
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI01;                    
                sheetObj.DoSave("ESM_COA_0043GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'), -1, true);
                ComOpenWait(false);
            }
            break;
        case IBDOWNEXCEL:        // Excell download
            var excelType=selectDownExcelMethod(sheetObj);
            break;
        case IBLOADEXCEL:
            if(formObj.f_yrtype[1].checked) {
                ComShowMessage(ComGetMsg("COA10003", "Load Excel", "YYYY-MM"));
                return false;
            }
    		//20150716.MOD/ADD/DEL
    		sheetObj.SetWaitImageVisible(0);
        	sheetObj.RemoveAll();
        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
            break;                                                
       case IBINSERT:
           var idx=sheetObj.DataInsert();
           sheetObj.SetCellValue(idx, "cost_yrmon",formObj.f_yearweek.value,0);
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

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
//    ComOpenWait(false);
//    if(Code == 0){
//        ComShowCodeMessage("COM132601");
//    }    
    if(Msg == ""){
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
        if(f_yearweek.value == "") {
            if(f_yrtype[0].checked){
                // [COM12114] : Check for the fom YYYY-MM
                ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                f_yearweek.focus();
                return false;
            }
            else{
                // [COM12114] : Check for the fom YYYY-WW
                ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                f_yearweek.focus();
                return false;
            }
        }
        if(f_yearweek.value.replace("-","").length != 6) {
            if(f_yrtype[0].checked){
                // [COM12114] : Check for the fom YYYY-MM
                ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                f_yearweek.focus();
                return false;
            }
            else{
                // [COM12114] : Check for the fom YYYY-WW
                ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                f_yearweek.focus();
                return false;
            }
        }
        if(f_yrtype[0].checked == true){
           if(!ComChkObjValid(f_yearweek, null, null, "ym")) return false;
        }else{
           if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
        }
        var dr=sheetObj.ColValueDup("cost_yrmon|vsl_cd|vsl_clss_capa");
        if(dr>0){               
            ComShowCodeMessage('COM12115', 'YYYY-MM, VSL Code, VSL Class');
            sheetObj.SelectCell(dr,"cost_yrmon");
            return false;
        }
    }
    return true;
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}

//SJH.20141223.ADD, 
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	ComOpenWait(false);									//20150716.MOD
	if(isExceedMaxRow(msg)) return;						//20150501.COMMON ADD
	
//	var sheetObj = sheetObjects[0];
	//Delete the last row(total) in case of copy & paste
    var lastRow=sheetObj.GetCellValue(sheetObj.LastRow()-1, 1);
    if(lastRow == "" || lastRow == "TOTAL") {
        sheetObj.RowDelete(sheetObj.LastRow()-1, false);
    }
    sheetObj.SetSumText(0,1,"TOTAL");
}  

//20150716.ADD
function sheet1_OnLoadFileSelect(sheetObj){
    ComOpenWait(true);
}
