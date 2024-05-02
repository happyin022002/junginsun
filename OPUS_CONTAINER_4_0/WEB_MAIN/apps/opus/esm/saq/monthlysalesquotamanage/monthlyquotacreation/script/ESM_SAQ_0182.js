/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0182.js
*@FileTitle  : Guide Line Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/14
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
            case "btn_init":
                doActionIBSheet(sheetObject, formObject, SEARCH01);
                break;
            
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, SEARCH02);
                break;     
                
            case "btn_downexcel":
                doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                break;
           
            case "btn_save":
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;  
            
            case "btn_confirm":
                doActionIBSheet(sheetObject, formObject, MULTI03);
                break;          
                
            case "btn_cancelconfirmation":
                doActionIBSheet(sheetObject, formObject, MULTI04);
                break;    
                 
            case "btn_notify":
                doActionIBSheet(sheetObject, formObject, MULTI05);
                break;                    

            case "btn_cancelnotification":
                doActionIBSheet(sheetObject, formObject, MULTI06);
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
    
    ComBtnDisable("btn_save");
	ComBtnDisable("btn_confirm");
	ComBtnDisable("btn_cancelconfirmation");
	ComBtnDisable("btn_notify");
	ComBtnDisable("btn_cancelnotification");	
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
        case "subtrade":
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
				
				var HeadTitle1 = "|||||||MONTH|TRADE|SUB TRADE|BOUND|Supply|L/F(%)|L/F(%)|L/F(%)|TEU|TEU|TEU|CM(1,000USD)|CM(1,000USD)|CM(1,000USD)";
				var HeadTitle2 = "|||||||MONTH|TRADE|SUB TRADE|BOUND|Supply|INITIAL|GUIDELINE|+/-|INITIAL|GUIDELINE|+/-|INITIAL|GUIDELINE|+/-";
				
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				var info = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"}  ];
				InitHeaders(headers, info);
				
				var cols = [{Type:"Status",   	Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Text",   		Hidden:1,  	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"mqta_mdl_ver_no",  	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   		Hidden:1,  	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"fcast_trns_sts_cd",  	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   		Hidden:1,  	Width:30,   	Align:"Center",  ColMerge:0,   SaveName:"gline_sts_flg",  			KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   		Hidden:1,   	Width:30,  	Align:"Center",  ColMerge:0,   SaveName:"bse_yr", 					KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   		Hidden:1,   	Width:30,  	Align:"Center",  ColMerge:0,   SaveName:"bse_mon", 				KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   		Hidden:1,   	Width:90,  Align:"Right",  	ColMerge:0,   SaveName:"cm_amt", 				KeyField:0,   CalcLogic:"",   Format:"Integer",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		
							
							//{Type:"CheckBox", 	Hidden:0,   	Width:30,  	Align:"Center",  ColMerge:0,   SaveName:"DelChk",  				KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",   		Hidden:0,   	Width:90,  Align:"Center",  	ColMerge:0,   SaveName:"year_mon", 				KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },																		
							{Type:"Text",   		Hidden:0,   	Width:90,  Align:"Center",  	ColMerge:0,   SaveName:"trd_cd", 					KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   		Hidden:0,   	Width:90,  Align:"Center",  	ColMerge:0,   SaveName:"sub_trd_cd",				KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",   		Hidden:0,   	Width:70,  Align:"Center",  	ColMerge:0,   SaveName:"dir_cd", 					KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   		Hidden:0,   	Width:80,  Align:"Right",  	ColMerge:0,   SaveName:"spl_amt", 				KeyField:0,   CalcLogic:"",   Format:"Integer",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   		Hidden:0,   	Width:90,  Align:"Right",  	ColMerge:0,   SaveName:"org_ldf_rto", 			KeyField:0,   CalcLogic:"",   Format:"Integer",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   		Hidden:0,   	Width:90,  Align:"Right",  	ColMerge:0,   SaveName:"ldf_rto", 					KeyField:0,   CalcLogic:"",   Format:"Integer",		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",   		Hidden:0,   	Width:80,  Align:"Right",  	ColMerge:0,   SaveName:"ldf_rto_gap", 			KeyField:0,   CalcLogic:"|ldf_rto| - |org_ldf_rto|",   Format:"Integer",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   		Hidden:0,   	Width:90,  Align:"Right",   	ColMerge:0,   SaveName:"org_lod_qty",          	KeyField:0,   CalcLogic:"",   Format:"Integer",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   		Hidden:0,   	Width:90,  Align:"Right",   	ColMerge:0,   SaveName:"lod_qty",          		KeyField:0,   CalcLogic:"",   Format:"Integer",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   		Hidden:0,   	Width:80,  Align:"Right",   	ColMerge:0,   SaveName:"lod_qty_gap",          	KeyField:0,   CalcLogic:"|lod_qty| - |org_lod_qty|",   Format:"Integer",   	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",   		Hidden:0,   	Width:90,  Align:"Right",  	ColMerge:0,   SaveName:"init_cm_amt", 			KeyField:0,   CalcLogic:"",   Format:"Integer",		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },												
							{Type:"Int",    		Hidden:0,   	Width:90,  Align:"Right",   	ColMerge:0,   SaveName:"gline_cm_amt",       	KeyField:0,   CalcLogic:"",   Format:"Integer",   	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },		
							{Type:"Int",    		Hidden:0,   	Width:80,  Align:"Right",   	ColMerge:0,   SaveName:"cm_amt_gap",       	KeyField:0,   CalcLogic:"|gline_cm_amt| - |init_cm_amt|",   Format:"Integer",   	PointCount:0,   UpdateEdit:0,   InsertEdit:1 }											
							];
				
				InitColumns(cols);
				SetEditable(1);
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				resizeSheet();
				//SetSheetHeight(429);
				//SetAutoSumPosition();
				
				//var arg = [ {StdCol:"trd_cd|dir_cd", SumCols:"spl_amt|lod_qty|init_cm_amt|gline_cm_amt|cm_amt_gap", AvgCols:"trd_cd|dir_cd|ldf_rto", CaptionCol: "year_mon", CaptionText: "QTA Total", Sort:1, ShowCumulate:0} ];
                //ShowSubSum(arg);
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
        case SEARCH01: //Initial Data Creation
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            //ComOpenWait(true);
            iPageNo = 1;
            formObj.f_cmd.value = SEARCHLIST01;
            formObj.mqta_mdl_ver_no.value = formObj.year.value.substring(2,4) + formObj.bse_qtr_cd.value + "01";
            formObj.trd_cd.value = comObjects[0].GetSelectCode();      
            formObj.sub_trd_cd.value = comObjects[1].GetSelectCode();  
            selectVal = FormQueryString(formObj);            
            sheetObj.DoSearch("ESM_SAQ_0182GS.do", selectVal + "&iPage=1");
            break;
        
        case SEARCH02: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            //ComOpenWait(true);
            iPageNo = 1;
            formObj.f_cmd.value = SEARCHLIST02;
            formObj.mqta_mdl_ver_no.value = formObj.year.value.substring(2,4) + formObj.bse_qtr_cd.value + "01";
            formObj.trd_cd.value = comObjects[0].GetSelectCode();      
            formObj.sub_trd_cd.value = comObjects[1].GetSelectCode();      
            selectVal = FormQueryString(formObj);            
            sheetObj.DoSearch("ESM_SAQ_0182GS.do", selectVal + "&iPage=1");
            break;
            
        case IBSEARCHAPPEND: // 페이징 조회
            //ComOpenWait(true);
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_SAQ_0182GS.do", selectVal + "&iPage=" + PageNo, {Append: true});
            break;
            
        case IBDOWNEXCEL: //Excel download     
            var params = { FileName : "Gideline Input.xls",  SheetName : "Sheet", DownCols : makeHiddenSkipCol(sheetObj)} ;
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
            
        case IBSAVE:   
            //ComOpenWait(true);
            formObj.f_cmd.value = MULTI01;         
                        
//            var rowCnt = sheetObj.RowCount();		
//            for (var i = 1; i < rowCnt +1; i++) {
//                sheetObj.SetCellValue(i, "ibflag", "U");  
//            }
                           
            selectVal = FormQueryString(formObj);  
            sheetObj.DoSave("ESM_SAQ_0182GS.do", selectVal);             
            break;
            
      case MODIFY01:            
            //ComOpenWait(true);
            formObj.f_cmd.value=MODIFY01;
            selectVal = saqFormString(formObj);			  
		  	sheetObj.DoSearch("ESM_SAQ_0182GS.do", selectVal);   
            break;
	 			
	  case MULTI02:      
	    	if (formObj.version.value == null || formObj.version.value == "") {			
	 			break;
	 		}
	 		var flag=confirm(getMsg("SAQ90139", "save Version" + formObj.version.value + " as Final Version"));
	 		if (flag) {
				//ComOpenWait(true);
				formObj.f_cmd.value=MULTI02;				
				sheetObj.DoSearch("ESM_SAQ_0182GS.do", FormQueryString(formObj), "trd", false);
			}
			break;
			     
	  case MULTI03:   
            //ComOpenWait(true);
            formObj.f_cmd.value = MULTI03;
            formObj.mqta_mdl_ver_no.value = sheetObj.GetCellValue(2, "mqta_mdl_ver_no");            
            sheetObj.SetCellValue(2, "ibflag", "U");      
            selectVal = FormQueryString(formObj);  
            sheetObj.DoSave("ESM_SAQ_0182GS.do", selectVal); //Confirm            
            break;   

	  case MULTI04:   
            //ComOpenWait(true);
            formObj.f_cmd.value = MULTI04;
            formObj.mqta_mdl_ver_no.value = sheetObj.GetCellValue(2, "mqta_mdl_ver_no");            
            sheetObj.SetCellValue(2, "ibflag", "U");      
            selectVal = FormQueryString(formObj);  
            sheetObj.DoSave("ESM_SAQ_0182GS.do", selectVal); //Cancel Confirmation            
            break;   
                        
	  case MULTI05:   
            //ComOpenWait(true);
            formObj.f_cmd.value = MULTI05;
            formObj.mqta_mdl_ver_no.value = sheetObj.GetCellValue(2, "mqta_mdl_ver_no");            
            sheetObj.SetCellValue(2, "ibflag", "U");      
            selectVal = FormQueryString(formObj);  
            sheetObj.DoSave("ESM_SAQ_0182GS.do", selectVal); //Notify            
            break;                           

	  case MULTI06:   
            //ComOpenWait(true);
            formObj.f_cmd.value = MULTI06;
            formObj.mqta_mdl_ver_no.value = sheetObj.GetCellValue(2, "mqta_mdl_ver_no");            
            sheetObj.SetCellValue(2, "ibflag", "U");      
            selectVal = FormQueryString(formObj);  
            sheetObj.DoSave("ESM_SAQ_0182GS.do", selectVal); //Cancel Notification            
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

function sheet1_OnSearchEnd(shtObj, ErrMsg) {        
    var rowCnt = shtObj.RowCount();		
    var strFStatus = shtObj.GetCellValue(shtObj.HeaderRows(), "fcast_trns_sts_cd");
    var strGStatus = shtObj.GetCellValue(shtObj.HeaderRows(), "gline_sts_flg");
    
    if(strGStatus == "C"){
    	ComBtnDisable("btn_save");
	    ComBtnDisable("btn_confirm");	    
	    ComBtnDisable("btn_init");	    
	    ComBtnEnable("btn_cancelconfirmation");
		ComBtnEnable("btn_notify");
		ComBtnDisable("btn_cancelnotification");	
		
	} else if(strGStatus == "N"){
    	ComBtnDisable("btn_save");
	    ComBtnDisable("btn_confirm");	    
	    ComBtnDisable("btn_init");	    
	    ComBtnDisable("btn_cancelconfirmation");
		ComBtnDisable("btn_notify");
		ComBtnEnable("btn_cancelnotification");	
		
	} else {
	    ComBtnEnable("btn_save");
	    ComBtnEnable("btn_confirm");
	    ComBtnEnable("btn_init");
	    ComBtnDisable("btn_cancelconfirmation");
	    ComBtnDisable("btn_notify");
		ComBtnDisable("btn_cancelnotification");	
	}
	
	if(strFStatus != "N"){
		ComBtnDisable("btn_save");
	    ComBtnDisable("btn_confirm");
	    ComBtnDisable("btn_cancelconfirmation");
	    ComBtnDisable("btn_notify");
	    ComBtnDisable("btn_cancelnotification");	    
	}    
    
//    if(rowCnt < 1){
//    	ComBtnEnable("btn_init");
//    }
    
    for (var i = shtObj.HeaderRows(); i < rowCnt + shtObj.HeaderRows(); i++) {
        if (shtObj.GetCellValue(i, "bse_mon") == "QTA Total"){            
            shtObj.SetCellEditable(i, "ldf_rto", false);
            shtObj.SetCellEditable(i, "gline_cm_amt", false);
        }        
    }
    //ComOpenWait(false);
}

function sheet1_OnSaveEnd(shtObj, ErrMsg) {    
    if(shtObj.GetEtcData("status") != "OK"){
    	return;
    }
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
    doActionIBSheet(sheetObject, formObject, SEARCH02);
}

function sheet1_OnChange(sheetObj, row, col, value){	
	if(col == "13" && "QTA Total" != sheetObj.GetCellValue(row, "bse_mon")){ // L/F 수정 되었을때	    	    
	    var nTeu = Math.round(parseInt(sheetObj.GetCellValue(row, "spl_amt")) * parseInt(sheetObj.GetCellValue(row, "ldf_rto")) / 100) ;
	    sheetObj.SetCellValue(row, "lod_qty", nTeu);
	    
	    var nIntCm = Math.round(parseInt(sheetObj.GetCellValue(row, "cm_amt")) / parseInt(sheetObj.GetCellValue(row, "org_lod_qty")) * nTeu) ;
	    sheetObj.SetCellValue(row, "init_cm_amt", nIntCm);
	}	
	
	if(col == "14" || col == "19") { // L/F or CM 수정 되었을때
		var rowCnt = sheetObj.RowCount();	
		var strBseMon = sheetObj.GetCellValue(row, "bse_mon");
		var strTrdCd = sheetObj.GetCellValue(row, "trd_cd");
		var strSubTrdCd = sheetObj.GetCellValue(row, "sub_trd_cd");
		var strDirCd = sheetObj.GetCellValue(row, "dir_cd");	
		var nLRto = 0;
		var nCm = 0;
		var nInitCm = 0;
		var nCnt = 0;
		var nTotRow = 0;
		
	    for (var i = sheetObj.HeaderRows(); i < rowCnt + sheetObj.HeaderRows(); i++) {	        
	        if(strTrdCd == sheetObj.GetCellValue(i, "trd_cd") && strSubTrdCd == sheetObj.GetCellValue(i, "sub_trd_cd") && strDirCd == sheetObj.GetCellValue(i, "dir_cd")){            
		    	if ("QTA Total" != sheetObj.GetCellValue(i, "bse_mon")){		            
		            nLRto += parseInt(sheetObj.GetCellValue(i, "ldf_rto"));
		            nCm += parseInt(sheetObj.GetCellValue(i, "gline_cm_amt"));
		            nInitCm += parseInt(sheetObj.GetCellValue(i, "init_cm_amt"));
		            nCnt++;
	            } else {
	            	nTotRow = i; //합계를 표시할 row
	            }
	        }        
	    }
	
	    sheetObj.SetCellValue(nTotRow, "ldf_rto", nLRto/nCnt); // 평균 L/F 으로 변경
		sheetObj.SetCellValue(nTotRow, "gline_cm_amt", nCm); // 합계 Cm 으로 변경  
		sheetObj.SetCellValue(nTotRow, "init_cm_amt", nInitCm); // 합계 InitCm 으로 변경  
    }    
}

function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

    if (newCode == "") return;

    comObjects[1].RemoveAll();
    
    SaqSearchOptionSubTrade("subtrade", true, false, 'Y', newCode);

    comObjects[1].SetSelectIndex(0);
    // 콤보 표시 데이터 취득후 콤보박스 속성 설정.
    initCombo(subtrade, 2);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
        case SEARCH01:
        case SEARCH02:
            //if (comObjects[0].GetSelectCode() == "") {
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
    SaqSearchOptionTrade("trade", false);
    SaqSearchOptionBound("bound", true);
    SaqSearchOptionSubTrade("subtrade", true, true);
}
