/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0078.js
*@FileTitle  : Base Data Preparation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/15
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
		if(ComGetBtnDisable(srcName)) return false;
        if (window.event.srcElement.tagName == "IMG" && document.getElementsByName(srcName)[0].GetEnable() != undefined && !document.getElementsByName(srcName)[0].GetEnable()) {
            return;
        }
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;
                
            case "btn_interface":
                // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet)
                ComOpenPopup("ESM_SAQ_0178.do", 700, 350, "", "1,0", true, false);
                break;
                
            case "btn_downexcel":
                doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                break;
            
            case "btn_loadexcel":
                sheetObject.RemoveAll();
				doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
                break;
            
        	case "btn_new":				
				sheetObject.RemoveAll();
	 	    	ComResetAll();	 	    	
				break;
				
		    case "btn_confirm":
                doActionIBSheet(sheetObject, formObject, MODIFY01);
                break;
            
            case "btn_cancel":
                doActionIBSheet(sheetObject, formObject, MODIFY02);
                break;
                
            case "btn_notify":
                doActionIBSheet(sheetObject, formObject, MODIFY03);
                break;
			
			case "btng_ofcVerify":
				var param = "?year="+formObject.year.value+"&bse_qtr_cd="+formObject.bse_qtr_cd.value+"&trade="+comObjects[0].GetSelectCode()+"&bound="+formObject.bound.value+"&search_lane="+comObjects[1].GetSelectCode();	            
	            //ComOpenPopupScroll(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, addHeight)
                ComOpenPopupScroll("ESM_SAQ_0179.do"+param, 650, 620, "", "none", true, false);
                break;
                
            case "btng_ofcAdjust":
            	var param = "?year="+formObject.year.value+"&bse_qtr_cd="+formObject.bse_qtr_cd.value+"&trade="+comObjects[0].GetSelectCode()+"&bound="+formObject.bound.value+"&search_lane="+comObjects[1].GetSelectCode();
                // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet)
                ComOpenPopupScroll("ESM_SAQ_0184.do"+param, 740, 640, "", "1,0,1,1,1,1,1", true, false);
                break;
                
            case "btng_laneAdjust":
            	var param = "?year="+formObject.year.value+"&bse_qtr_cd="+formObject.bse_qtr_cd.value+"&trade="+comObjects[0].GetSelectCode()+"&bound="+formObject.bound.value+"&search_lane="+comObjects[1].GetSelectCode();
                // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet)
                ComOpenPopupScroll("ESM_SAQ_0181.do"+param, 630, 520, "", "1,0,1,1,1,1,1", true, false);
                break;
                
            case "btng_CPBAdjust":
            	var param = "?year="+formObject.year.value+"&bse_qtr_cd="+formObject.bse_qtr_cd.value+"&trade="+comObjects[0].GetSelectCode()+"&bound="+formObject.bound.value+"&search_lane="+comObjects[1].GetSelectCode();
                // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet)
                ComOpenPopupScroll("ESM_SAQ_0183.do"+param, 720, 620, "", "1,0,1,1,1,1,1", true, false);
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
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
    //  
    optionSetting();
    var formObj = document.form;
    setYearMonthObject(formObj.year, formObj.bse_qtr_cd);
    document.form.year.focus();
    //doActionIBSheet(sheetObjects[0], formObj, IBSEARCH); 
    
    var rtn=getCodeXmlList("CoaInferfaceYN", "");    
    var arrData=SaqXml2ComboItem(rtn, "code", "text");
        
    if(arrData[1] == "N"){
    	ComBtnDisable("btn_interface");   
    } else {
    	ComBtnEnable("btn_interface");
    }	
    
    ComBtnDisable("btn_confirm");
    ComBtnDisable("btn_cancel");
    ComBtnDisable("btn_notify");
    	
    ComBtnDisable("btng_ofcVerify");
    ComBtnDisable("btng_ofcAdjust");
    ComBtnDisable("btng_laneAdjust");
    ComBtnDisable("btng_CPBAdjust");
    ComBtnDisable("btn_loadexcel");    	
}

/**
 * setting Combo initial values and header
 * param : sheetObj, sheetNo
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
				
				var HeadTitle = "||Version|Trade|Sub Trade|IOC|Lane|DIR|CTRT RHQ|CTRT AQ|CTRT OFC|SLS RHQ|SLS AQ|SLS OFC|TEU|RPB|CPB|CMPB";
				
				SetConfig( { SearchMode:2, MergeSheet:2, Page:100, FrozenCol:0, DataRowMerge:0 } );
				
				var info = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [{Type:"Status",   	Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Text",   	Hidden:1,   Width:80,   Align:"Center",  	ColMerge:1,   SaveName:"fcast_trns_sts_cd",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:1,   SaveName:"mqta_mdl_ver_no",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },								
							{Type:"Text",   	Hidden:0,   Width:70,   Align:"Center",  	ColMerge:1,   SaveName:"trd_cd", 					KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:1,   SaveName:"sub_trd_cd",				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:40,   Align:"Center",  	ColMerge:1,   SaveName:"ioc_cd",  					KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:1,   SaveName:"rlane_cd",    			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:40,   Align:"Center",  	ColMerge:1,   SaveName:"dir_cd",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:0,   SaveName:"ctrt_rhq_cd",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:0,   SaveName:"ctrt_aq_cd",        		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:0,   SaveName:"ctrt_ofc_cd", 			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:0,   SaveName:"sls_rhq_cd",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:0,   SaveName:"sls_aq_cd",        		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   	Hidden:0,   Width:80,   Align:"Center",  	ColMerge:0,   SaveName:"sls_ofc_cd",   			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   	Hidden:0,   Width:80,   Align:"Right",   	ColMerge:0,   SaveName:"lod_qty",          		KeyField:0,   CalcLogic:"",   Format:"Integer",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   	Hidden:0,   Width:80,   Align:"Right",  	ColMerge:0,   SaveName:"grs_rpb_rev",   			KeyField:0,   CalcLogic:"",   Format:"Integer",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",    	Hidden:0,   Width:80,   Align:"Right",   	ColMerge:0,   SaveName:"cm_uc_amt",       		KeyField:0,   CalcLogic:"",   Format:"Integer",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Int",   	Hidden:0,   Width:80,   Align:"Right",  	ColMerge:0,   SaveName:"cmpb",   				KeyField:0,   CalcLogic:"",   Format:"Integer",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
							{Type:"Text",   	Hidden:1,   Width:80,   Align:"Right",  	ColMerge:0,   SaveName:"gline_sts_flg",   		KeyField:0,   CalcLogic:"",   Format:"",   		   PointCount:0,   UpdateEdit:0,   InsertEdit:0 }			
							];				
				InitColumns(cols);
				SetEditable(0);
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				resizeSheet();
				//SetSheetHeight(429);
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
        case IBSEARCH:
            //ComOpenWait(true);
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            iPageNo = 1;
            formObj.f_cmd.value = SEARCH;
            selectVal = FormQueryString(formObj);            
            sheetObj.DoSearch("ESM_SAQ_0078GS.do",  selectVal + "&iPage=1");
            break;
            
        case IBSEARCHAPPEND: // 페이징 조회
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_SAQ_0078GS.do", selectVal + "&iPage=" + PageNo, {Append: true});
            break;
            
        case IBDOWNEXCEL: //Excel download     
            var params = { FileName : "Base Data Preparation.xls",  SheetName : "Sheet", DownCols : "2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17"} ;
			sheetObj.Down2Excel(params);
            break;
        
        case IBLOADEXCEL:            
            // Sheet Reset				
            sheetObj.RemoveAll();
            
		    // Init Sheet
		    initSheet(sheetObj,1);
            
            var params = { Mode : "HeaderMatch" } ;
			sheetObj.LoadExcel(params);           
            break;
            
        case MODIFY01:   
            //ComOpenWait(true);
            formObj.f_cmd.value = MODIFY01;
            formObj.mqta_mdl_ver_no.value = sheetObj.GetCellValue(1, "mqta_mdl_ver_no");            
            sheetObj.SetCellValue(1, "ibflag", "U");      
            selectVal = FormQueryString(formObj);  
            sheetObj.DoSave("ESM_SAQ_0078GS.do", selectVal); //Confirm
            
            break;
        
        case MODIFY02:   
            //ComOpenWait(true);
            formObj.f_cmd.value = MODIFY02;
            formObj.mqta_mdl_ver_no.value = sheetObj.GetCellValue(1, "mqta_mdl_ver_no");
            sheetObj.SetCellValue(1, "ibflag", "U");      
            selectVal = FormQueryString(formObj);  
            sheetObj.DoSave("ESM_SAQ_0078GS.do", selectVal); //Cancel Confirmation
            
            break;
            
        case MODIFY03:   
            //ComOpenWait(true);
            formObj.f_cmd.value = MODIFY03;
            formObj.mqta_mdl_ver_no.value = sheetObj.GetCellValue(1, "mqta_mdl_ver_no");
            sheetObj.SetCellValue(1, "ibflag", "U");      
            selectVal = FormQueryString(formObj);  
            sheetObj.DoSave("ESM_SAQ_0078GS.do", selectVal); //Notify
            
            break;
    }
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg){
	if(isExceedMaxRow(msg))return; //2014-04-22 공통 요청사항(10,000 Row 제어)
}

function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    iPageNo = iPageNo + 1;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, iPageNo);
}

function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

    if (newCode == "") return;

    search_lane.RemoveAll();

    SaqSearchOptionLane("search_lane", true, false, 'Y', newCode);

    comObjects[1].SetSelectIndex(0);
    // 콤보 표시 데이터 취득후 콤보박스 속성 설정.
    initCombo(search_lane, 2);
}

function sheet1_OnSearchEnd(shtObj, ErrMsg) {        
    var rowCnt = shtObj.RowCount();		
    var strStatus = shtObj.GetCellValue(1, "fcast_trns_sts_cd");
    var strVvdStatus = shtObj.GetCellValue(1, "gline_sts_flg"); //VVD Management 상태가 Notify 인 경우만 버튼 활성화
    
    if(strStatus == "N"){
    	ComBtnDisable("btn_confirm");
    	ComBtnDisable("btn_cancel");
    	ComBtnDisable("btn_notify");
    	
    	ComBtnDisable("btng_ofcVerify");
    	ComBtnDisable("btng_ofcAdjust");
    	ComBtnDisable("btng_laneAdjust");
    	ComBtnDisable("btng_CPBAdjust");
    	ComBtnDisable("btn_loadexcel");    	
    	
    } else if(strStatus == "C"){
    	ComBtnDisable("btn_confirm");
    	
    	ComBtnDisable("btng_ofcVerify");
    	ComBtnDisable("btng_ofcAdjust");
    	ComBtnDisable("btng_laneAdjust");
    	ComBtnDisable("btng_CPBAdjust");
    	ComBtnDisable("btn_loadexcel");
    	
    } else if(strVvdStatus == "N") {
    	ComBtnEnable("btn_confirm");
    	ComBtnEnable("btn_cancel");
    	ComBtnEnable("btn_notify");
    	
    	ComBtnEnable("btng_ofcVerify");
    	ComBtnEnable("btng_ofcAdjust");
    	ComBtnEnable("btng_laneAdjust");
    	ComBtnEnable("btng_CPBAdjust");
    	
    	ComBtnEnable("btn_new");    
    	ComBtnEnable("btn_downexcel");
    	
    	ComBtnEnable("btn_loadexcel");
    }
    //ComOpenWait(false);    
}

function sheet1_OnSaveEnd(shtObj, ErrMsg) {    
    if(shtObj.GetEtcData("status") != "OK"){
    	return;
    }    
    var formObject = document.form;
    doActionIBSheet(shtObj, formObject, IBSEARCH);
    //ComOpenWait(false);  
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
        case IBSEARCH:
// 			  if (comObjects[0].GetSelectCode() == "") {
//                ComShowMessage(getMsg("SAQ90126", "Trade"));
//                formObj.trade.focus();
//                return false;
//            }
//
//            if (formObj.bound.value == "") {
//                ComShowMessage(getMsg("SAQ90126", "Bound"));
//                formObj.bound.focus();
//                return false;
//            }
            break;
    }
    return true;
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_qtr_cd");
    SaqSearchOptionTrade("trade", true);
    SaqSearchOptionBound("bound", true);
    SaqSearchOptionLane("search_lane", true, false, 'Y');
    //SaqSearchOptionComCode("ioc", "CD20012", true);
    SaqSearchOptionMonth("bse_month");
}
