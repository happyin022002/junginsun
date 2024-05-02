/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0183.js
*@FileTitle  : CPB Adjust
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/12
=========================================================*/

var sheetObjects = new Array();
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var tabCnt = 0;
var selectVal;
var iPageNo = 1;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (window.event.srcElement.tagName == "IMG" && document.getElementsByName(srcName)[0].GetEnable() != undefined && !document.getElementsByName(srcName)[0].GetEnable()) {
            return;
        }
        
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, SEARCH01);
                break;       
                
            case "btn_save":
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;
            
            case "btn_close":
                ComClosePopup();
                break;
            
        	case "btn_apply":			
				var rowCnt = sheetObject.RowCount();
				var nAmt = parseInt(formObject.amount.value.replace(",",""));
                var nRtio = parseInt(formObject.ratio.value.replace(",",""));
                var nCpb = 0;
                var nVal = 0;                
                                
                for (var i = 1; i < rowCnt + 1; i++) {
                	nCpb = parseInt(sheetObject.GetCellValue(i, "cm_uc_amt"));     
                	
                	if(nAmt != null && nAmt != "" && !isNaN(nAmt)){
                		nVal = nCpb + nAmt;                		
                	} else if(nRtio != null && nRtio != "" && !isNaN(nRtio)){
                		nVal = nCpb * nRtio / 100;                		
                	}    
                	
                	sheetObject.SetCellValue(i, "chng_cm_uc_amt", nVal);                                             
                }                
				break;		
			
			case "btn_init":				
				var rowCnt = sheetObject.RowCount();
                for (var i = 1; i < rowCnt + 1; i++) {
                    sheetObject.SetCellValue(i, "chng_cm_uc_amt", sheetObject.GetCellValue(i, "cm_uc_amt"));                        
                }                
				break;		
                 
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}
    
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comObjects[comboCnt++] = combo_obj;
}

/**
 * setting page initial values 
 */
function loadPage() {    
    var sheetResizeFull = true;
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    //initializing the combobox
//    for (var k = 0; k < comObjects.length; k++) {
//        initCombo(comObjects[k], k + 1);
//    }  
    
    optionSetting();
    
    var formObj = document.form;
    setYearMonthObject(formObj.year, formObj.bse_qtr_cd);
    
    formObj.year.value = formObj.rq_year.value; 
    formObj.bse_qtr_cd.value = formObj.rq_bse_qtr_cd.value;
    formObj.bound.value = formObj.rq_bound.value;
    comObjects[0].SetSelectCode(formObj.rq_trade.value, false);    
    
    document.form.year.focus();
}

/**
 * setting Combo initial values and header
 * param : comboObj, comboNo
 * adding case as numbers of counting Combos
 */
function initCombo(comboObj, comboNo) {
    var formObject = document.form;
    switch (comboObj.options.id) {
        case "trade":
            with(comboObj) {
                SetDropHeight(250);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetUseAutoComplete(1);
                ValidChar(2);
                SetMaxLength(3);
            }
            break;        
    }
}
    			

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:     
			with(sheetObj){		
				//no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				SetFocusEditMode(default_edit_mode);
				
				var HeadTitle = "|||Trade|Sub Trade|Rev Lane|Bound|C/OFC|L/OFC|CPB PFMC|CPB Adjusted";
				
				SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				var info = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [{Type:"Status",   		Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"mqta_mdl_ver_no", 	KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"ioc_cd", 					KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							//{Type:"DummyCheck",	Hidden:0,  	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"DelChk",  				KeyField:0,   CalcLogic:"",   Format:"",    			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",   			Hidden:0,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"trd_cd", 					KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,  	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",				KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Text",   			Hidden:0,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",    			KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"dir_cd",           		KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Text",   			Hidden:0,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"ctrt_ofc_cd", 			KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Text",   			Hidden:0,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"sls_ofc_cd",   			KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Int",    			Hidden:0,   	Width:80,   	Align:"Right",   ColMerge:0,   SaveName:"cm_uc_amt",       		KeyField:0,   CalcLogic:"",   Format:"Integer",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						    {Type:"Int",    			Hidden:0,   	Width:80,   	Align:"Right",   ColMerge:0,   SaveName:"chng_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Integer",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 }							 
							];
				
				InitColumns(cols);
				SetEditable(0);
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				resizeSheet();
				//SetSheetHeight(259);
			}
			break;                
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}
     
// handling sheet1 process
function doActionIBSheet(sheetObj, formObj, sAction, a, PageNo) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case SEARCH01:
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            //ComOpenWait(true);
            iPageNo = 1;
            formObj.f_cmd.value = SEARCHLIST01;
            formObj.mqta_mdl_ver_no.value = formObj.year.value.substring(2,4) + formObj.bse_qtr_cd.value + "01";
            formObj.trd_cd.value = comObjects[0].GetSelectCode();        
            
            selectVal = FormQueryString(formObj);            
            sheetObj.DoSearch("ESM_SAQ_0183GS.do", selectVal + "&iPage=1");
            break;
            
        case IBSEARCHAPPEND: // 페이징 조회
            //ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST01;
            //sheetObj.DoSearch("ESM_SAQ_0183GS.do", selectVal + "&iPage=" + PageNo, {Append: true});
            break;
                  
        case IBSAVE:   
            //ComOpenWait(true);
            sheetObj.DoSave("ESM_SAQ_0183GS.do", "f_cmd=" + MULTI01);            
            break;            
    }
}

function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    iPageNo = iPageNo + 1;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, iPageNo);
}

function amt_OnKeyDown() {	
	document.form.ratio.value = "";
}

function rto_OnKeyDown() {	
	document.form.amount.value = "";
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {    
    switch (sAction) {
        case SEARCH01:
        case SEARCH02:
//            if (comObjects[0].GetSelectCode() == "") {
//                ComShowMessage(getMsg("SAQ90126", "Trade"));                
//                comObjects[0].Focus();
//                return false;
//            }
    }
    return true;
}

function sheet1_OnSearchEnd(shtObj, ErrMsg) {  
    //ComOpenWait(false);    
}

function sheet1_OnSaveEnd(shtObj, ErrMsg) {   
    //ComOpenWait(false);  
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_qtr_cd");
    SaqSearchOptionTrade("trade", true);
    SaqSearchOptionBound("bound", true);
}
