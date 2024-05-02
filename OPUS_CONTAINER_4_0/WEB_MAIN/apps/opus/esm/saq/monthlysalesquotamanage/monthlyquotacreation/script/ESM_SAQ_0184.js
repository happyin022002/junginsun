/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0184.js
*@FileTitle  : Office Adjust
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
var initFlag = "Y";

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
            
            case "btn_rowcopy":					
				var addRow = sheetObject.DataCopy();
				sheetObject.SetCellValue(addRow, "Status", "R");	
				sheetObject.SetCellValue(addRow, "ctrt_ofc_cd", "");
				sheetObject.SetCellValue(addRow, "sls_ofc_cd", "");						
				break;	
            
        	case "btn_rowadd":				
//       		var curRow = sheetObject.GetSelectRow();
//				var addRow = sheetObject.DataInsert(curRow+1);		
				var addRow = sheetObject.DataCopy();
				sheetObject.SetCellValue(addRow, "Status", "R");	
				sheetObject.SetCellValue(addRow, "ctrt_ofc_cd", "");
				sheetObject.SetCellValue(addRow, "sls_ofc_cd", "");
				sheetObject.SetCellValue(addRow, "lod_qty", "");
				sheetObject.SetCellValue(addRow, "grs_rpb_rev", "");
				sheetObject.SetCellValue(addRow, "cm_uc_amt", "");				
				break;	
				
			case "btn_rowdel":				
				ComRowHideDelete(sheetObj, "DelChk"); 
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
    formObj.bound.value = formObj.rq_bound.value;
    comObjects[0].SetSelectCode(formObj.rq_trade.value, false);
    comObjects[1].SetSelectCode(formObj.rq_search_lane.value, false);
    
    var sheetObject = sheetObjects[0];
    doActionIBSheet(sheetObject, formObj, SEARCH01);    
    formObj.year.focus();    
    initFlag = "N";    
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
            
        case "search_lane":
            with(comboObj) {
                SetDropHeight(340);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetUseAutoComplete(1);
                ValidChar(2, 1);
                SetMaxLength(5);
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
				
				var HeadTitle = "|||||||Trade|Sub Trade|Rev Lane|Bound|C/OFC|L/OFC|TEU|RPB|CPB|CMPB";
				
				SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [{Type:"Status",   		Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"mqta_mdl_ver_no", 	KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"ioc_cd", 					KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"st_dt", 					KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"ctrt_rgn_ofc_cd", 		KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:1,   SaveName:"sls_rgn_ofc_cd", 		KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"DummyCheck",	Hidden:0,  	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"DelChk",  				KeyField:0,   CalcLogic:"",   Format:"",    			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },	
							{Type:"Text",   			Hidden:0,   	Width:50,  	Align:"Center",  ColMerge:0,   SaveName:"trd_cd", 					KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,   	Width:70,  	Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",				KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,   	Width:70,  	Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",  				KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,   	Width:50,   	Align:"Center",  ColMerge:0,   SaveName:"dir_cd", 					KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"PopupEdit",   	Hidden:0,   	Width:70,  	Align:"Center",  ColMerge:0,   SaveName:"ctrt_ofc_cd",				KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:1, InputCaseSensitive:1, EditLen:5},
							{Type:"PopupEdit",   	Hidden:0,   	Width:70,  	Align:"Center",  ColMerge:0,   SaveName:"sls_ofc_cd",				KeyField:0,   CalcLogic:"",   Format:"",         		PointCount:0,   UpdateEdit:0,   InsertEdit:1, InputCaseSensitive:1, EditLen:5},							
							{Type:"Int",   			Hidden:0,   	Width:60,  	Align:"Right",  	ColMerge:0,   SaveName:"lod_qty",					KeyField:0,   CalcLogic:"",   Format:"Integer",    	PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:10 },
							{Type:"Int",   			Hidden:0,   	Width:60,  	Align:"Right",  	ColMerge:0,   SaveName:"grs_rpb_rev",			KeyField:0,   CalcLogic:"",   Format:"Integer",    	PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:10 },
							{Type:"Int",   			Hidden:0,   	Width:60,  	Align:"Right",  	ColMerge:0,   SaveName:"cm_uc_amt",				KeyField:0,   CalcLogic:"",   Format:"Integer",    	PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:10 },
							{Type:"Int",   			Hidden:0,   	Width:60,  	Align:"Right",  	ColMerge:0,   SaveName:"cmpb",					KeyField:0,   CalcLogic:"|grs_rpb_rev| - |cm_uc_amt|",   Format:"Integer",    	PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
							];
				
				InitColumns(cols);
				SetEditable(1);
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				resizeSheet();
				//SetSheetHeight(229);
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
            formObj.rlane_cd.value = comObjects[1].GetSelectCode();
            
            selectVal = FormQueryString(formObj);            
            sheetObj.DoSearch("ESM_SAQ_0184GS.do", selectVal + "&iPage=1");
            break;
            
        case IBSEARCHAPPEND: // 페이징 조회
            //ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST01;
            sheetObj.DoSearch("ESM_SAQ_0184GS.do", selectVal + "&iPage=" + PageNo, {Append: true});
            break;   
            
        case IBSAVE:           	
        	if (!validateForm(sheetObj, formObj, sAction)) {                
                return false;
            }
            //ComOpenWait(true);            
            sheetObj.DoSave("ESM_SAQ_0184GS.do", "f_cmd=" + MULTI01);            
            break;
    }
}

function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    iPageNo = iPageNo + 1;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, iPageNo);
}

/**
 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
 * @param {shtObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 저장 후 메시지
 */
function sheet1_OnSaveEnd(shtObj, ErrMsg) {
    if (ErrMsg != "") return;    
    var formObj = document.form;
    doActionIBSheet(shtObj, formObj, SEARCH01);  
    
    //ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
}

function sheet1_OnSearchEnd(shtObj, ErrMsg) {        
    var rowCnt = shtObj.RowCount();		
    
    if(rowCnt > 0){
    	ComBtnEnable("btn_rowcopy");
    	ComBtnEnable("btn_rowadd");
    	ComBtnEnable("btn_rowdel");
    } else {
    	ComBtnDisable("btn_rowcopy");
    	ComBtnDisable("btn_rowadd");
    	ComBtnDisable("btn_rowdel");
    }   
    //ComOpenWait(false);
}

function sheet1_OnChange(sheetObj, row, col, value) {
    with(sheetObj){
    	switch(ColSaveName(col)){        		
            case "ctrt_ofc_cd":
            case "sls_ofc_cd":
            	if(value!=""){
            		checkValidOfc(sheetObj, row, col, value);
            	}
            	break;
        }
    }
}

function checkValidOfc(sheetObj, row, col, value){
	var param="f_cmd=" + SEARCH01;
	param=param + "&sls_ofc_cd="	+ value;
 	var sXml=sheetObj.GetSearchData("ESM_SAQ_0179GS.do", param);
	var flg=ComGetEtcData(sXml, "valid_flg");
	if(flg!="Y"){
		ComShowMessage("Office is not level 4. Please check again.");
		sheetObj.SetCellValue(row, col, "", 0);
		sheetObj.SetCellBackColor(row, col, "#FFFF66");				            			
		sheetObj.SetCellFontColor(row, col, "#FF0000");    
	} else {		
        sheetObj.SetCellBackColor(row, col, "#FFFFFF");				            			
		sheetObj.SetCellFontColor(row, col, "#000000");   
	}
}

function sheet1_OnPopupClick(sheetObj, row, col){	
	if ( sheetObj.ColSaveName(col) == "ctrt_ofc_cd" || sheetObj.ColSaveName(col) == "sls_ofc_cd" ){				
		//ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll, addHeight) 
		ComOpenPopup('/opuscntr/COM_ENS_071.do', 770, 475, 'setSheet1PopUpValue', "1,0,1", false, false, row, col);
    }
}

function setSheet1PopUpValue(rowArray, row, col) {	
	var sheetObj=sheetObjects[0];
	var colArray=rowArray[0];
	sheetObj.SetCellValue(row, col, colArray[3]);
} 

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {    
    switch (sAction) {
        case SEARCH01:
        case SEARCH02:
//            if (comObjects[0].GetSelectCode() == "") {
//                if(initFlag == "N"){
//                	ComShowMessage(getMsg("SAQ90126", "Trade"));
//                }                
//                comObjects[0].Focus();
//                return false;
//            }
            break;
            
        case IBSAVE:
            var rowCnt = sheetObj.RowCount();	
            var nCnt = 0;
            var strMsg = "";
            
            for (var i = 1; i < rowCnt + 1; i++) {	
            	if(sheetObj.GetCellValue(i, "ctrt_ofc_cd").length == 0){            		
            		sheetObj.SetCellBackColor(i, "ctrt_ofc_cd", "#FFFF66");            	
		            sheetObj.SetCellFontColor(i, "ctrt_ofc_cd", "#FF0000");		            
		            strMsg += " [C/OFC]";
		            nCnt++;
		            
            	}
            	
            	if(sheetObj.GetCellValue(i, "sls_ofc_cd").length == 0){            		
            		sheetObj.SetCellBackColor(i, "sls_ofc_cd", "#FFFF66");            	
		            sheetObj.SetCellFontColor(i, "sls_ofc_cd", "#FF0000");		            
		            strMsg += " [L/OFC]";
		            nCnt++;
            	} 
            	
            	if(nCnt > 0){
	            	ComShowMessage(getMsg("SAQ90126", strMsg));
	            	return false;
	            }
            }            
            
            var dupRow = sheetObj.ColValueDup("trd_cd|sub_trd_cd|rlane_cd|dir_cd|ctrt_ofc_cd|sls_ofc_cd");     		    
		    
		    if (dupRow > 0) {
		        var idx = 0;        		
		        var Rows;
		        Rows = sheetObj.ColValueDupRows("trd_cd|sub_trd_cd|rlane_cd|dir_cd|ctrt_ofc_cd|sls_ofc_cd");
		        var arr_rows = null;	
		        
		        if (Rows != null && Rows.trim() != "") {
		            arr_rows = Rows.split(",");
		        }		        
		        
		        for (var i = 0; arr_rows != null && i < arr_rows.length; i++) {		        	
//		            sheetObj.SetRowFontColor(arr_rows[i], "#FF0000");
//		            sheetObj.SetRowBackColor(arr_rows[i], "#FFFF66");
		
//					sheetObj.SetCellBackColor(arr_rows[i], "trd_cd", "#FFFF66");            		
//		            sheetObj.SetCellFontColor(arr_rows[i], "trd_cd", "#FF0000");
//		
//		            sheetObj.SetCellBackColor(arr_rows[i], "sub_trd_cd", "#FFFF66");
//		            sheetObj.SetCellFontColor(arr_rows[i], "sub_trd_cd", "#FF0000");
//		
//		            sheetObj.SetCellBackColor(arr_rows[i], "rlane_cd", "#FFFF66");
//		            sheetObj.SetCellFontColor(arr_rows[i], "rlane_cd", "#FF0000");
//		
		            sheetObj.SetCellBackColor(arr_rows[i], "ctrt_ofc_cd", "#FFFF66");            	
		            sheetObj.SetCellFontColor(arr_rows[i], "ctrt_ofc_cd", "#FF0000");
		
		            sheetObj.SetCellBackColor(arr_rows[i], "sls_ofc_cd", "#FFFF66");            	
		            sheetObj.SetCellFontColor(arr_rows[i], "sls_ofc_cd", "#FF0000");			        
		        }
		        ComShowCodeMessage("COM131302", "[Trade][Sub Trade][Rev lane][C/OFC][L/OFC]");    // {?msg1} is duplicated.
		        return false;
		    } else {	
		   		for (var i = 1; i < rowCnt + 1; i++) {	
//		   		    if(sheetObj.GetCellEditable(Row, Col) == 1){
//			   		    sheetObj.SetRowFontColor(i, "#000000");
//			            sheetObj.SetRowBackColor(i, "#FFFFFF");	
//		            }
//		            sheetObj.SetRowFontColor(i, "#000000");
//		            sheetObj.SetRowBackColor(i, "#FFFFFF");
		            
//		            sheetObj.SetCellBackColor(i, "trd_cd", "#FFFFFF");            		
//		            sheetObj.SetCellFontColor(i, "trd_cd", "#000000");
//		
//		            sheetObj.SetCellBackColor(i, "sub_trd_cd", "#FFFFFF");
//		            sheetObj.SetCellFontColor(i, "sub_trd_cd", "#000000");
//		
//		            sheetObj.SetCellBackColor(i, "rlane_cd", "#FFFFFF");
//		            sheetObj.SetCellFontColor(i, "rlane_cd", "#000000");
//		
		            if(sheetObj.GetCellEditable(i, "ctrt_ofc_cd") == 1){
			            sheetObj.SetCellBackColor(i, "ctrt_ofc_cd", "#FFFFFF");            	
			            sheetObj.SetCellFontColor(i, "ctrt_ofc_cd", "#000000");
			
			            sheetObj.SetCellBackColor(i, "sls_ofc_cd", "#FFFFFF");            	
			            sheetObj.SetCellFontColor(i, "sls_ofc_cd", "#000000");			
		            } else {
		            	sheetObj.SetCellBackColor(i, "ctrt_ofc_cd", "#f4f4f4");            	
			            sheetObj.SetCellFontColor(i, "ctrt_ofc_cd", "#000000");
			
			            sheetObj.SetCellBackColor(i, "sls_ofc_cd", "#f4f4f4");            	
			            sheetObj.SetCellFontColor(i, "sls_ofc_cd", "#000000");		
		            }        
		        }
		    }
		    break;
    }
    return true;
}

function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

    if (newCode == "") return;

    search_lane.RemoveAll();

    SaqSearchOptionLane("search_lane", true, false, 'Y', newCode);

    comObjects[1].SetSelectIndex(0);
    // 콤보 표시 데이터 취득후 콤보박스 속성 설정.
    initCombo(search_lane, 2);
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_qtr_cd");
    SaqSearchOptionTrade("trade", true);
    SaqSearchOptionBound("bound", true);
    SaqSearchOptionLane("search_lane", true, false, 'Y');
}
