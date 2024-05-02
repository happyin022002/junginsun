/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0181.js
*@FileTitle  : Lane Adjust
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
            
			case "btn_rowdel":				
				ComRowHideDelete(sheetObject, "DelChk"); 
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
    for (var k = 0; k < comObjects.length; k++) {
        initCombo(comObjects[k], k + 1);
    }  
    
    optionSetting();
    
    var formObj = document.form;
    setYearMonthObject(formObj.year, formObj.bse_qtr_cd);
        
    formObj.year.value = formObj.rq_year.value; 
    formObj.bse_qtr_cd.value = formObj.rq_bse_qtr_cd.value;
    //formObj.bound.value = formObj.rq_bound.value;
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
				
				var HeadTitle = "||||Trade|Sub Trade|Rev Lane|Base Data Copy";
				
				SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				var info = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [{Type:"Status",   		Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"mqta_mdl_ver_no", 	KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"row_clr", 				KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							
							{Type:"DummyCheck",	Hidden:0,  	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"DelChk",  				KeyField:0,   CalcLogic:"",   Format:"",    			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },	
							{Type:"Text",   			Hidden:0,   	Width:140,  	Align:"Center",  ColMerge:0,   SaveName:"trd_cd", 					KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,   	Width:140,  	Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",				KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,   	Width:140,  	Align:"Center",  ColMerge:0,   SaveName:"org_rlane_cd",			KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },									
							{Type:"ComboEdit",	Hidden:0, 	Width:50,   	Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",        		KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:5 }		
							];
				
				InitColumns(cols);
				InitComboNoMatchText(1,"",1);
				SetEditable(1);
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				resizeSheet();
				//SetSheetHeight(309);
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
            iPageNo = 1;
            formObj.f_cmd.value = SEARCHLIST01;
            formObj.mqta_mdl_ver_no.value = formObj.year.value.substring(2,4) + formObj.bse_qtr_cd.value + "01";
            formObj.trd_cd.value = comObjects[0].GetSelectCode();        
            
            selectVal = FormQueryString(formObj);            
            sheetObj.DoSearch("ESM_SAQ_0181GS.do", selectVal + "&iPage=1");
            break;
            
        case IBSEARCHAPPEND: // 페이징 조회            
            formObj.f_cmd.value = SEARCHLIST01;
            sheetObj.DoSearch("ESM_SAQ_0181GS.do", selectVal + "&iPage=" + PageNo, {Append: true});
            break;
            
        case IBSAVE:        	
        	if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }           
            sheetObj.DoSave("ESM_SAQ_0181GS.do", "f_cmd=" + MULTI01);            
            break;          
    }
}

function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    iPageNo = iPageNo + 1;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, iPageNo);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {    
    switch (sAction) {
        case SEARCH01:
        case SEARCH02:
//			  if (comObjects[0].GetSelectCode() == "") {
//                ComShowMessage(getMsg("SAQ90126", "Trade"));                
//                comObjects[0].Focus();
//                return false;
//            }
            break;
        
        case IBSAVE:
            var Row = sheetObj.ColValueDup(6, 0);           
			if(Row > 0){		
				ComShowMessage(getMsg("SAQ90155", "Rev Lane"));     
				sheetObj.SelectCell(Row, 3);		
				return false;
			}
            break;
    }
    return true;
}

/**
* handling process for input validation
*/
//function sheet1_OnValidation(sheetObj, Row, Col, Value){
//	var Row = sheetObj.ColValueDup("3", 0);
//	if(Row > 0){		
//		//ComShowCodeMessage("FIN00001", "Zone IOC Code");
//		sheetObj.ValidateFail(1);
//		sheetObj.SelectCell(Row, 3);		
//	}
//}

function sheet1_OnSearchEnd(shtObj, ErrMsg) {   
	var nRowCnt = shtObj.RowCount();
	for (var i = 1; i < nRowCnt +1; i++) {
        if(shtObj.GetCellValue(i, "row_clr") == "BLUE"){
        	shtObj.SetCellEditable(i, "rlane_cd", 1);
        	shtObj.SetCellEditable(i, "DelChk", 0);
        	shtObj.SetRowFontColor(i, "#0000FF");
        	shtObj.SetToolTipText(i,"org_rlane_cd","Revenue lane which is Target Lane for Quota without Base Data User need to select Base Data");
        	
        	var formObj = document.form;
		
			var mqtaMdlVerNo =  formObj.year.value.substring(2,4) + formObj.bse_qtr_cd.value + "01";
			var year = formObj.year.value;
			var bseQtrCd = formObj.bse_qtr_cd.value;
			
		    var rtn=getCodeXmlList("BSRLaneCombo", "mqtaMdlVerNo="+mqtaMdlVerNo+"&year="+year+"&bseQtrCd="+bseQtrCd+"&trade="+ shtObj.GetCellValue(i, "trd_cd")+"&subTrde="+ shtObj.GetCellValue(i, "sub_trd_cd"));
		    var arrData=SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
		    
		    arrData[0]=" |" + arrData[0];
		    arrData[1]="\t\t\t|" + arrData[1];
		    
		    shtObj.InitCellProperty(i, "rlane_cd", {Type: "Combo", ComboText:arrData[1], ComboCode:arrData[0], ShowCol:2} );         
        } else {
        	shtObj.SetCellEditable(i, "rlane_cd", 0);
        	shtObj.SetCellEditable(i, "DelChk", 1);
        	shtObj.SetRowFontColor(i, "#FF0000");
        	shtObj.SetToolTipText(i,"org_rlane_cd","It is not Target Lane for Quota");
        }    		
    }  
}

/**
 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
 * @param {shtObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 저장 후 메시지
 */
function sheet1_OnSaveEnd(shtObj, ErrMsg) {
 
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_qtr_cd");
    SaqSearchOptionTrade("trade", true);
    //SaqSearchOptionBound("bound", true);
}
