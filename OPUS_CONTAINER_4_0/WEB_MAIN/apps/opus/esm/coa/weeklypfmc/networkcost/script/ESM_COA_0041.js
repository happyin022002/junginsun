/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0041.js
*@FileTitle  : Bunker Fee
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var EXCEL_LOAD_FLG=false;   //check excell loading
var sRow=0;
/** 
 *Event handler processing by button click event  
 */
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
                    break;
                }else{
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                }
                break;
            case "btn_Loadexcel":
                doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
            case "btn_rowadd":
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
            case "btng_copyfrompast":
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    } finally {
        ComOpenWait(false);
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
//        SetSelectIndex(0);
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
        		//SJH.20141222.MOD : 타이틀 수정
                var HeadTitle0="STS|YYYY-MM|Week|Service Lane|Revenue Lane|Class|Dir.|FUEL OIL|FUEL OIL|DIESEL OIL|DIESEL OIL";
                var HeadTitle1="STS|YYYY-MM|Week|Service Lane|Revenue Lane|Class|Dir.|Consumption|Unit Cost|Consumption|Unit Cost";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",     KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_week",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                            {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_clss_capa",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slan_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"AutoSum",   Hidden:0, Width:125,  Align:"Right",   ColMerge:1,   SaveName:"foil_csm",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:27 },
                            {Type:"AutoSum",   Hidden:0, Width:115,  Align:"Right",   ColMerge:1,   SaveName:"foil_uc_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:31 },
                            {Type:"AutoSum",   Hidden:0, Width:125,  Align:"Right",   ColMerge:1,   SaveName:"doil_csm",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:27 },
                            {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"doil_uc_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:31 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(1);//Editkind[optional,Defaultfalse]
                SetCountPosition(0);
                SetColProperty(0 ,"cost_week" , {AcceptKeys:"N"});
                SetColProperty(0 ,"slan_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
                SetColProperty(0 ,"rlane_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
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
/**
 * Check validation of the S.Lane code
 */
function sheet1_OnChange(sheetObj, row, col, value){
    var formObj=document.form;
    //SJH.20141223.MOD
    if(sheetObj.ColSaveName(col) == "slan_cd"){
        if(sheetObj.GetCellValue(row,"slan_cd") != ""){
            var param="f_cmd="+SEARCH02;
            param=param + "&f_slan_cd="+value;
            var sXml=sheetObj.GetSearchData("ESM_COA_0041GS.do", param);
            var arrXml=sXml.split("|$$|");
            isValidSlane(row,ComCoaGetEtcData(arrXml[0], "rtnValue"));
        }
    } else if(sheetObj.ColSaveName(col) == "rlane_cd"){
        if(sheetObj.GetCellValue(row, "rlane_cd") != ""){
            var param="f_cmd="+SEARCH03;
            param=param + "&f_rlane_cd="+value;
            var sXml=sheetObj.GetSearchData("ESM_COA_0041GS.do", param);
            var arrXml=sXml.split("|$$|");
            isValidRLane(row,ComCoaGetEtcData(arrXml[0], "rtnValue"));
        }
    }
}
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBCLEAR:          //Inquiry
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            setTimeout( function () {
	            formObj.f_cmd.value=INIT;
	            var sXml=sheetObj.GetSearchData("ESM_COA_0041GS2.do", coaFormQueryString(formObj));
	            var arrXml=sXml.split("|$$|");
	            if (arrXml.length > 0) {
	            	ComXml2ComboItem(arrXml[0], f_selslane, "code", "name");
	                f_selslane.SetSelectIndex(0);
	            }
	            if (arrXml.length > 1) {
	                ComXml2ComboItem(arrXml[1], f_selrlane, "code", "name");
	                f_selrlane.SetSelectIndex(0);
	            }
	            if (arrXml.length > 2) {
	                ComXml2ComboItem(arrXml[2], f_selclass, "code", "name");
		            f_selclass.SetSelectIndex(0);
	            }
	            if (arrXml.length > 3)
	                ComCoaSetIBCombo(sheetObj, arrXml[3], "slan_dir_cd", true, 0);
	            if (arrXml.length > 4)
	                ComCoaSetIBCombo(sheetObj, arrXml[4], "vsl_clss_capa", true, 0);
	            
	            //SJH.20150108.ADD
	            formObj.f_yearweek.value=ComGetMaskedValue(ComGetNowInfo("yy")+ComGetNowInfo("mm").lpad(2, "0"),"ym","-");
	            chkYWM('',"2");
	            
	            ComOpenWait(false);
            }, 100);
            break;  
        case IBSEARCH:              //Inquiry, SJH.20150108.MOD
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCHLIST01; 
            sheetObj.DoSearch("ESM_COA_0041GS.do", coaFormQueryString(formObj) );
            break;
        case IBSAVE:                //Save
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=MULTI01;
            sheetObj.DoSave("ESM_COA_0041GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, true);
            ComOpenWait(false);
            break;
        case IBINSERT:      // Insert
            sheetObj.DataInsert();
            sheetObj.SetSumText(0,0,"");
            sheetObj.SetSumText(0,1,"TOTAL");		//SJH.20141223.MOD
            break;
        case IBDOWNEXCEL:           // Excell download
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
    }
}
//SJH.20150108.MOD
function sheet1_OnSearchEnd(sheetObj, errMsg){
    ComOpenWait(false);
    sheetObj.SetSumText(0, 1,"TOTAL");    
}
//SJH.20150108.ADD : 저장후 메시지 추가
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if(ErrMsg == ""){
        // [COM130102] : Success
    	ComShowMessage(ComGetMsg("COM130102","Data"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
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

/**
 * Handling process for form object input validation
 * SJH.20150108.MOD
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(!chkValidSearch2()) return false;         
        //20150603.ADD
        if (sAction == IBSAVE) {
  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {	  				
  				if(sheetObj.GetCellValue(i, "ibflag") == "U" || sheetObj.GetCellValue(i, "ibflag") == "I") {
		  	  		if(sheetObj.GetCellValue(i, "vsl_clss_capa") == "") {
		  	  			ComShowMessage(ComGetMsg('COA10014','Vessel Class'));
		  	  			sheetObj.SelectCell(i, "vsl_clss_capa");
		  	  			return false; 	
		  	  			break;				  	  			
		  	  		}	  	  		
		  	  	}
	  	  	}
  		}          
    }
    return true;
}
/**
 * Return validation of the S.Lane code (From ESM_COA_5128.jsp)
 */
function isValidSlane(sRow,result){
    var sheetObj=sheetObjects[0];
    if(result == "false"){
        ComShowMessage(ComGetMsg("COM12114","S.Lane",""));
        sheetObj.SetCellValue(sRow, "slan_cd","");
        sheetObj.SelectCell(sRow, "slan_cd");
    }
}
/**
 * Return validation of the R.Lane code (From ESM_COA_5125.jsp)
 */
function isValidRLane(sRow,result){
    var sheetObj=sheetObjects[0];
    if(result == "false"){
        ComShowMessage(ComGetMsg("COM12114","RLane",""));
        sheetObj.SetCellValue(sRow, "rlane_cd","");
        sheetObj.SelectCell(sRow, "rlane_cd");
    }
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}

function moveTab(obj1, obj2){
    var keyValue=ComGetEvent("keycode");
    if(obj1.maxLength == obj1.value.length &&  keyValue != '9' &&  keyValue != '16' ){          // 역 Tab
		if (obj2.type == "text" ||  obj2.type == "password" || obj2.type == "textarea") {
			obj2.select();
		} else {
			obj2.focus();
		}
    }
}

//SJH.20141223.ADD
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