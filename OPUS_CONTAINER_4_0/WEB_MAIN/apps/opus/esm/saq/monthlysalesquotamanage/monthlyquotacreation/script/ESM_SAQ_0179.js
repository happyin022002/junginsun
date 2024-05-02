/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0179.js
*@FileTitle  : Office Verify
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/11
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
                
            case "btn_lofc":
                doActionIBSheet(sheetObject, formObject, SEARCH02);
                break;
                
            case "btn_save":
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;
            
            case "btn_close":
                ComClosePopup();
                break;
            
        	case "btn_rowdel":				
				ComRowHideDelete(sheetObj, "DelChk");
				
				//var rowCnt = sheetObject.RowCount();				
//                for (var i = rowCnt; i > 0; i--) {
//                    if (sheetObject.GetCellValue(i, "chk") == 1)
//                        sheetObject.RowDelete(i, false);
//                }
//                // header 체크의 초기화
//                sheetObject.ClearHeaderCheck();
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
    //formObj.bound.value = formObj.rq_bound.value;
    //comObjects[0].SetSelectCode(formObj.rq_trade.value, false);
    
    document.form.year.focus();
    
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
    doActionIBSheet(sheetObject, formObject, SEARCH01);
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
				SetFocusEditMode(1);
				
				var HeadTitle1 = "|||||||||CONTRACT|CONTRACT|LOADING|LOADING|REVISE|REVISE";
				var HeadTitle2 = "|||||||||RHQ|OFC|RHQ|OFC|C / OFC|L / OFC";
				
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [{Type:"Status",   		Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"mqta_mdl_ver_no", 	KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"trd_cd", 					KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"rlane_cd", 				KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd", 			KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"dir_cd", 					KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"ctrt_flg", 				KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:1,   	Width:80,   	Align:"Center",  ColMerge:0,   SaveName:"sls_flg", 					KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"DummyCheck",	Hidden:0,  	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"DelChk",  				KeyField:0,   CalcLogic:"",   Format:"",    		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },	
							{Type:"Text",   			Hidden:0,   	Width:90,  	Align:"Center",  ColMerge:0,   SaveName:"ctrt_rhq_cd", 			KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,   	Width:90,  	Align:"Center",  ColMerge:0,   SaveName:"ctrt_ofc_cd", 			KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Text",   			Hidden:0,   	Width:90,  	Align:"Center",  ColMerge:0,   SaveName:"sls_rhq_cd", 			KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   			Hidden:0,   	Width:90,  	Align:"Center",  ColMerge:0,   SaveName:"sls_ofc_cd", 				KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"PopupEdit",   	Hidden:0,   	Width:90,  	Align:"Center",  ColMerge:0,   SaveName:"chng_ctrt_ofc_cd",  	KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:5 },
							{Type:"PopupEdit",   	Hidden:0,   	Width:90,  	Align:"Center",  ColMerge:0,   SaveName:"chng_sls_ofc_cd",  		KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:5 }
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
            //formObj.trd_cd.value = comObjects[0].GetSelectCode();        
            
            selectVal = FormQueryString(formObj);            
            sheetObj.DoSearch("ESM_SAQ_0179GS.do", selectVal + "&iPage=1");
            break;
            
        case IBSEARCHAPPEND: // 페이징 조회
            //ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST01;
            sheetObj.DoSearch("ESM_SAQ_0179GS.do", selectVal + "&iPage=" + PageNo, {Append: true});
            break;
            
        case SEARCH02:              
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            //ComOpenWait(true);
            iPageNo = 1;
            formObj.f_cmd.value = SEARCHLIST02;
            formObj.mqta_mdl_ver_no.value = formObj.year.value.substring(2,4) + formObj.bse_qtr_cd.value + "01";
            //formObj.trd_cd.value = comObjects[0].GetSelectCode();        
            selectVal = FormQueryString(formObj);            
            sheetObj.DoSearch("ESM_SAQ_0179GS.do", selectVal + "&iPage=1");
            break;        
            
        case IBSAVE:             
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            } 
            //ComOpenWait(true);                
            sheetObj.DoSave("ESM_SAQ_0179GS.do", "f_cmd=" + MULTI01);            
            break;
    }
}

function sheet1_OnChange(sheetObj, row, col, value) {
    with(sheetObj){
    	switch(ColSaveName(col)){        		
            case "chng_ctrt_ofc_cd":
            case "chng_sls_ofc_cd":
            	if(value!=""){
            		checkValidOfc(sheetObj, row, col, value);
            	}
            	break;
        }
    }
}

function sheet1_OnPopupClick(sheetObj, row, col){	
	if ( sheetObj.ColSaveName(col) == "chng_ctrt_ofc_cd" || sheetObj.ColSaveName(col) == "chng_sls_ofc_cd" ){				
		//ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll, addHeight) 
		ComOpenPopup('/opuscntr/COM_ENS_071.do', 770, 475, 'setSheet1PopUpValue', "1,0,1", false, false, row, col);
    }
}

function setSheet1PopUpValue(rowArray, row, col) {	
	var sheetObj=sheetObjects[0];
	var colArray=rowArray[0];
	sheetObj.SetCellValue(row, col, colArray[3]);
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
function tab1sheet1_OnSaveEnd(shtObj, ErrMsg) {
    if (ErrMsg != "") return;
    //ComOpenWait(false);
    ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
    
}

function sheet1_OnSearchEnd(shtObj, ErrMsg) {   
	for (var i = 2; i < sheetObj.RowCount()+2; i++) {				        
		if (sheetObj.GetCellValue(i, "ctrt_flg") == "Y") {                 
		    sheetObj.SetCellBackColor(i, "ctrt_ofc_cd", "#FFFF66");				            			
		    sheetObj.SetCellFontColor(i, "ctrt_ofc_cd", "#FF0000");
		    sheetObj.SetCellEditable(i, "chng_ctrt_ofc_cd", 1);
		} else {
			sheetObj.SetCellEditable(i, "chng_ctrt_ofc_cd", 0);
		}
		
		if (sheetObj.GetCellValue(i, "sls_flg") == "Y") {                 
		    sheetObj.SetCellBackColor(i, "sls_ofc_cd", "#FFFF66");				            			
		    sheetObj.SetCellFontColor(i, "sls_ofc_cd", "#FF0000");
		    sheetObj.SetCellEditable(i, "chng_sls_ofc_cd", 1);
		} else {
			sheetObj.SetCellEditable(i, "chng_sls_ofc_cd", 0);
		}
	}
	//ComOpenWait(false);
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
			break;

        case IBSAVE:
			for (var i = 2; i < sheetObj.RowCount()+2; i++) {	
				if (sheetObj.GetCellValue(i, "ibflag") == "U") {                 
				    if (sheetObj.GetCellValue(i, "chng_ctrt_ofc_cd").length == 0){ 				    	     
				    	sheetObj.SetCellBackColor(i, "chng_ctrt_ofc_cd", "#FFFF66");				            			
		    			sheetObj.SetCellFontColor(i, "chng_ctrt_ofc_cd", "#FF0000");
		    			ComShowMessage(getMsg("SAQ90126", "C/OFC"));    	                
		                return false;
				    } else if(sheetObj.GetCellValue(i, "chng_sls_ofc_cd").length == 0){		                
		                sheetObj.SetCellBackColor(i, "chng_sls_ofc_cd", "#FFFF66");				            			
		    			sheetObj.SetCellFontColor(i, "chng_sls_ofc_cd", "#FF0000");           
		                ComShowMessage(getMsg("SAQ90126", "L/OFC"));     
		                return false;
				    }
				} else {
					sheetObj.SetCellBackColor(i, "chng_ctrt_ofc_cd", "#FFFFFF");				            			
		    		sheetObj.SetCellFontColor(i, "chng_ctrt_ofc_cd", "#000000");  
		    		sheetObj.SetCellBackColor(i, "chng_sls_ofc_cd", "#FFFFFF");				            			
		    		sheetObj.SetCellFontColor(i, "chng_sls_ofc_cd", "#000000");              
				}
			}
            break;
    }
    return true;
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
	}
}
    
function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_qtr_cd");
    //SaqSearchOptionTrade("trade", false);
    //SaqSearchOptionBound("bound", false);
}
