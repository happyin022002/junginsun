/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0071.js
*@FileTitle  :  Block Stowage Group Creation & Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
var tabObjects=new Array();
var tabCnt=0;
var beforetab1=1;
var beforetab2=1
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick() {
    var sheetObject1=sheetObjects[0];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
        case "btn_Retrieve":
            doActionIBSheet(sheetObject1, formObject, IBSEARCH);
            break;
        case "btn_New":
            formObject.reset();
            sheetObject1.RemoveAll();
            break;
        case "btn_Save":
            doActionIBSheet(sheetObject1, formObject, IBSAVE);
            break;
        case "btn_DownExcel":
        	if(sheetObject1.RowCount() < 1){// no data
        		ComShowCodeMessage("COM132501");
        	}else{
        		doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
        	}
            break;
        case "btn_RowAdd":
            doActionIBSheet(sheetObject1, formObject, IBINSERT);
            break;
        case "btn_RowCopy":
            doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            alert(ComGetMsg('COM12111'));
        } else {
            ComShowMessage(e.message);
        }
    }
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'pod_code', 'hub_code', 'lane_code', 'group_code');
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetObj.id) {
    case "sheet1": // sheet1 init
        with(sheetObj){
        
				      if (location.hostname != "")
				      var HeadTitle1="NO.|Status|Del|POD|HUB|LANE|GROUP|C. User|C. Date|U. User|U. Date";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_flag",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_code",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hub_code",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo", 	Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane_code",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"group_code",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"c_user_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"c_date",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"u_user_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"u_date",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      resizeSheet();
				      InitComboNoMatchText(1 ,"",1);
				      
				      SetColProperty(0 ,"pod_code" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetColProperty(0 ,"hub_code" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetColProperty(0 ,"group_code" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
      }
        break;
    }
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case IBSEARCH: 
        if (validateForm(sheetObj, formObj, sAction)) {
        	if (sheetObj.id == "sheet1") {
        		ComOpenWait(true);
	            setTimeout( function () {
	                formObj.f_cmd.value=SEARCH;
	                sheetObj.DoSearch("ESD_PRD_0071GS.do", PrdFQString(formObj) , {Sync:2});
                    ComOpenWait(false);
            	} , 100);
            }
        }
        break;
    case IBSAVE: 
        if (validateForm(sheetObj, formObj, sAction)) {
            formObj.f_cmd.value=MULTI;
            sheetObj.DoSave("ESD_PRD_0071GS.do", PrdFQString(formObj));
        }
        break;
    case IBDOWNEXCEL: 
    	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        break;
    case IBINSERT: 
        sheetObj.DataInsert();
        break;
    case IBCOPYROW: 
        sheetObj.DataCopy();
        sheetObj.SetCellValue(sheetObj.GetSelectRow(), 3,"",0);
        sheetObj.SelectCell(sheetObj.GetSelectRow(), 3);
        break;
    }
}
function sheet1_OnChange(sheetObj, row, col, value) {
	var sXml ;
    if(col == 2 ){
    	if(sheetObj.GetRowStatus(row) == "I"){
            sheetObj.SetRowStatus(row,"D");
        }
        return;
    }
	var f=document.form;
    if (sheetObj.ColSaveName(col) == "pod_code") {
		if(value.length < 5){
			sheetObj.CellComboItem(row,"lane_code", {ComboText:"ALL", ComboCode:"ALL"} );
			sheetObj.SetCellValue(row, col,"",0);
            sheetObj.SelectCell(row, col);
			return;
		}
		/*if("US,CA,MX".indexOf(value.substring(0, 2),0) == -1){
			ComShowMessage(ComGetMsg('PRD90109'));
            sheetObj.SetCellValue(row, col,"",0);
            sheetObj.SelectCell(row, col);
			return;
		}*/
		
		// POD validation
		f.f_cmd.value=SEARCH02;
		sheetObj.SetEtcData("rowCount","");
		sXml=sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=ESD_PRD_0070&check_data=" + value + "&" + PrdFQString(f));
		var retCount=ComGetEtcData(sXml,"rowCount");
        if (retCount == "" || retCount < 1) {
            sheetObj.SetCellValue(row, col,"",0);
            sheetObj.SelectCell(row, col);
			sheetObj.CellComboItem(row,"lane_code", {ComboText:"ALL", ComboCode:"ALL"} );
			return;
        }
		f.f_cmd.value=SEARCH01;
		sXml=sheetObj.GetSaveData("ESD_PRD_0071GS.do", "uid=ESD_PRD_0071&pod_code=" + value + "&" + PrdFQString(f));
		var str=PrdComEtcDataToComboString(sXml);
		str="ALL|"+str;
		sheetObj.CellComboItem(row,"lane_code", {ComboText:str, ComboCode:str} );
		 sheetObj.SetCellValue(row, "lane_code","ALL",0);
	} else if (sheetObj.ColSaveName(col) == "hub_code") {
		f.f_cmd.value=SEARCH02;
		sheetObj.SetEtcData("rowCount","");
		sXml=sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=ESD_PRD_0070&check_data=" + value + "&" + PrdFQString(f));
        var retCount=ComGetEtcData(sXml,"rowCount");
        if (retCount == "" || retCount < 1) {
            sheetObj.SetCellValue(row, col,"",0);
            sheetObj.SelectCell(row, col);
        }
	}
    
    if(sheetObj.GetCellValue(row,"pod_code").length == 5 && sheetObj.GetCellValue(row,"hub_code").length == 5 && sheetObj.GetCellValue(row,"group_code").length == 3 ){
    	var retCount  =ComSearchEtcData(sheetObj, "ESD_PRD_0071GS.do", "f_cmd="+SEARCH+"&del_flag=N&group_code=&"+sheetObj.RowSaveStr(row), "rowCount");
		if (retCount > 0) {
			ComShowMessage(ComGetMsg('COM131302','Data'));
			sheetObj.SetCellValue(row, col, "" ,0);
			sheetObj.SelectCell(row, col);
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {
    }
    return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     var rowCount=sheetObj.RowCount()+ 1;
     for(var i=1; i<rowCount; i++){
         if(sheetObj.CellSearchValue(i, "del_flag") == 1){
             sheetObj.SetCellEditable(i, "del_flag",0);
         }
     }
}
/**
 * Event when clicking Tab activating selected tab items
 */
function tab2_OnChange(tabObj, nItem) {
    var objs=document.all.item("tabLayer2");
    objs[nItem].style.display="Inline";
    objs[beforetab2].style.display="none";
    objs[beforetab2].style.zIndex=objs[nItem].style.zIndex - 1;
    beforetab2=nItem;
}