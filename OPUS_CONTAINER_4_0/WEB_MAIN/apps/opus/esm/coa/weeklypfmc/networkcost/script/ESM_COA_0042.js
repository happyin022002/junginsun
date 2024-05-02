/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0042.js
*@FileTitle  : Daily hire by Chartered vessel
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
    /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    var sheetObject=sheetObjects[0];
    /*******************************************************/
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
            case "btn_Save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
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
            case "btns_calendar1":
                var cal=new ComCalendar();
                cal.select(formObject.f_yearweek, 'yyyyMM');
                break;
                
            case "btn_create":
            	doActionIBSheet(sheetObject,formObject,IBCREATE);
                break;

        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg(OBJECT_ERROR));
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * Change period when the month, week changed
 * SJH.20150108.MOD
 */
function setPeriod(obj){
	ComCoaSetPeriod2(obj);
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
    
    //SJH.20141027 ADD : SELCDA일 경우만 Create 버튼 활성화  , SJH.20141128,MOD 
//    if (document.form.v_ofc_cd.value == 'SELCDA' || document.form.v_ofc_cd.value == 'CLTCO'){
		ComBtnEnable("btn_create");
//	} else {
//		ComBtnDisable("btn_create");
//	}    
	
    loadingMode=false;
}
/**
 * Setting multicombo items
 * SJH.20150108.MOD
 */
function initCombo(comboObj, comboId) {
    with (comboObj) {        
    	SetDropHeight(300);    	
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
        case 1:     //sheet1 init
            with(sheetObj){
        		//20151201.MOD
                var HeadTitle="STS|YYYY-MM|Week|VSL Code|Contract No.|From|To|VSL\nClass|Standard \nLoadable Capa.|Hire SEQ|Hire Rate1|Hire Curr1|Hire Rate2|Hire Curr2|Daily Hire";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sStatus" },
                            {Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sYM",           KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_week",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sVslCd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                            {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
                            {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            //20151201.ADD
                            {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"vsl_clss_capa", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                            {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"stnd_ldb_capa", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"sDlyHireAmt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:27 } ];
               
                InitColumns(cols);
                
                SetEditable(1);//Editkind[optional,Defaultfalse]
                SetCountPosition(4);								//SJH.20141223.MOD : 우측하단
                SetColProperty(0 ,"cost_wk" , {AcceptKeys:"N"});
                SetColProperty(0 ,"sVslCd"  , {AcceptKeys:"E"   , InputCaseSensitive:1});
                SetColHidden("cost_week",1);				//SJH.20150108.ADD
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
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
    sheetObj.SetSumText(0,0,"");
    sheetObj.SetSumText(0,1,"TOTAL");		//SJH.20141223.MOD    
}
//SJH.20150108.ADD : 저장후 메시지 추가
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if(document.form.f_cmd.value==MULTI01){
		chkYWM('',"2");						//SJH.20150108.ADD		
	} else {
		if(ErrMsg == ""){
	        // [COM130102] : Success
	    	ComShowMessage(ComGetMsg("COM130102","Data"));
	    }else{
	        ComShowMessage(ComGetMsg("COM132101"));
	    }
	}	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
}
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=INIT;
            var sXml=sheetObj.GetSearchData("ESM_COA_0042GS2.do", coaFormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0) {
                ComXml2ComboItem(arrXml[0], select1, "code", "name");
                select1.SetSelectIndex(0);
            }
            //SJH.20150108.ADD
            formObj.f_yearweek.value=ComGetMaskedValue(ComGetNowInfo("yy")+ComGetNowInfo("mm").lpad(2, "0"),"ym","-");
            chkYWM('',"2");
            ComOpenWait(false);
            break;  
        case IBSEARCH:      //Inquiry
        	if(!validateForm(sheetObj,formObj,sAction)) return false;
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
//                formObj.f_yearweek.value=ComGetMaskedValue(formObj.f_yearweek.value,formObj.f_yrtype[0].checked?"ym":"yw");
                formObj.f_vsl_cd.value="All"==select1.GetSelectCode()?"":select1.GetSelectCode();
                sheetObj.DoSearch("ESM_COA_0042GS.do", coaFormQueryString(formObj) );
            break;
        case IBSAVE:        //Save
        	if(!validateForm(sheetObj,formObj,sAction)) return false;
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI;
            sheetObj.DoSave("ESM_COA_0042GS.do", coaFormQueryString(formObj));
            ComOpenWait(false);
            break;
        case IBINSERT:      // Insert
            sheetObj.DataInsert();
            break;
        case IBCOPYROW:     // Row copy
            sheetObj.DataCopy();
            break;
        case IBDOWNEXCEL:       // Excell download
            var excelType=selectDownExcelMethod(sheetObj);
            break;
            
        case IBLOADEXCEL:
//            if(formObj.f_yrtype[1].checked) {
//                ComShowMessage(ComGetMsg("COA10003", "Load Excel", "YYYY-MM"));
//                return false;
//            }
    		//20150716.MOD/ADD/DEL
    		sheetObj.SetWaitImageVisible(0);
        	sheetObj.RemoveAll();
        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
            break;   
            
        case IBCREATE:         	
        	if(!validateForm(sheetObj,formObj,sAction)) return false;
           	if (ComShowConfirm(ComGetMsg('COA10020')) == true) {
               ComOpenWait(true);
               ComAddSeparator_Local(formObj.f_yearweek, "-");
               formObj.f_cmd.value = MULTI01;
               var sXml = sheetObj.GetSaveData("ESM_COA_0042GS.do",coaFormQueryString(formObj));
               
               if (sXml != "") sheetObj.LoadSaveData(sXml,{Sync:0} );
               
               var XrateCnt = ComGetEtcData(sXml, "XrateCnt" );
               
               if (XrateCnt == "X") {
               	ComShowMessage(ComGetMsg("COA10015","Accounting Exchange Rate",""));
               	ComOpenWait(false);
               	return;
               }                   
               ComOpenWait(false);
           	}       
            break;
    }
}

function ComAddSeparator_Local(obj, sFormat) {
    try {
        obj.value=obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
    } catch(err) { ComFuncErrMsg(err.message); }
}

function callBackExcelMethod(excelType) {
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
* SJH.20150108.MOD
*/
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(!chkValidSearch2()) return false;         
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
