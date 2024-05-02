/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0334.js
*@FileTitle  : Discharge CY Setup by Country
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event
document.onclick=processButtonClick;

// Event handler processing by button name
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
		case "btn_Select":
			doActionIBSheet(sheetObjects[0],formObject,SEARCH11);
			break;
		case "btn_Add":
			doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
			break;
		case "btn_Del":
			doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;
		case "btn_Close":
			ComClosePopup();
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	var form=document.form;
	if (form.view_type.value=='create') {
		ComBtnEnable("btn_Del");
		ComBtnEnable("btn_Add");
		ComBtnDisable("btn_Save");
	}else {
		ComBtnDisable("btn_Del");
		ComBtnDisable("btn_Add");
		ComBtnDisable("btn_Save");
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1":      //sheet1 init
		with (sheetObj) {
			var HeadTitle1="flag|Sel.|Seq.|Bonded Area Code|Yard Code|CY LOC|Yard Name|Port|Lane|Dir|E-D/O Trans";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				   {Type:"Radio",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel",           KeyField:0,   CalcLogic:""   },
				   {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Popup",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"otr_dchg_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
				   {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
				   {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				   {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"loc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
				   {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				   {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				   {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
				   {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"edo_trsm_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 } ];

			InitColumns(cols);
			SetEditable(1);
			SetWaitImageVisible(0);
			//varGetCellEditable1=false;
		   // if(document.form.view_type.value=='create')GetCellEditable1=true;
//            SetColProperty("otr_dchg_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("yd_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("loc_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
//            SetColProperty("loc_nm", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("port_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("slan_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			SetColProperty("skd_dir_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
//            SetSheetHeight(450);
			ComResizeSheet(sheetObj);
		}
		break;
	}
	if (form.view_type.value=='create') {
		ComBtnEnable("btn_Del");
		ComBtnEnable("btn_Add");
	}else {
		ComBtnDisable("btn_Del");
		ComBtnDisable("btn_Add");
	}
}

//handling of Sheet process
function doActionIBSheet(sheetObj,formObj,sAction, reqString) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      // retrieve
		if(!validateForm(sheetObj,formObj,sAction)) return;
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
		if (formObj.loc_full_cd.value.length > 1) {
			formObj.country.value=formObj.loc_full_cd.value.substring(0,2);
			formObj.loc_cd.value=formObj.loc_full_cd.value;
		}else {
			formObj.loc_cd.value=formObj.country.value;
		}
		var sXml=sheetObj.GetSearchData("ESM_BKG_0334GS.do", FormQueryString(formObj));
		//sheetObjects[0].RenderSheet(0);
		sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
		//sheetObjects[0].RenderSheet(1);
		ComBtnDisable("btn_Save");
		break;
	case IBINSERT:      // insert
		sheetObj.DataInsert(-1);
		ComBtnEnable("btn_Save");
		break;
	case IBDELETE:
		ComRowHideDelete(sheetObj,"Sel");
		ComBtnEnable("btn_Save");
		break;
	case IBSAVE:    // save
		if(!validateForm(sheetObj,formObj,sAction)) return;
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			// Sheet의 Mandatory Check 용도
			if (sheetObj.RowCount() > 0 && sheetObj.GetSaveString(true) == "") return;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			ComBtnDisable("btn_Save");
			var retVal=sheetObj.DoSave("ESM_BKG_0334GS.do", FormQueryString(formObj), -1, false);
			//ComOpenWait(false);
			if(retVal == true) {
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
		break;
	case SEARCH11:  // SELECT
		select(sheetObj, sheetObj.GetSelectRow(), '');
		break;
	case SEARCH12:  // validation
		formObj.f_cmd.value=SEARCH;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0334GS.do", reqString);
		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.async="false";
		xmlDoc.loadXML(sXml);
		var dataNode=xmlDoc.documentElement.getElementsByTagName("DATA").item(0);
		var total=0;
		if(dataNode != null) {
			total=dataNode.getAttribute("TOTAL");
			//alert("total : " + total);
		}
		return total;
		break;
	case IBDOWNEXCEL: // excel
		if(!validateForm(sheetObj,formObj,sAction)) return;
		var columnSkipList = "";
		columnSkipList = "ibflag|Sel";
		if(sheetObj.RowCount() < 1){//no data
		  ComShowCodeMessage("COM132501");
		}else{
		  //sheetObj.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false, SheetDesign:1, AutoSizeColumn:1, DownCols:"Seq|otr_dchg_cd|yd_cd|loc_cd|loc_nm|port_cd|slan_cd|skd_dir_cd|edo_trsm_flg"});
			sheetObj.SetHeaderBackColor("#CCCCCC");
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			sheetObj.SetHeaderBackColor("#333333");
		}
	break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.country.value.length < 2) {
			ComShowCodeMessage('BKG00186');
			formObj.country.focus();
			return false;
		}
	}
	return true;
}

/**
 * IBSheet popup event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row,Col) {
	var colName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
	switch(colName)
	{
	case "otr_dchg_cd":
		var sUrl="ESM_BKG_0345_POP.do";
		//var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0345", 1024, 600, true);

		ComOpenPopup(sUrl, 1024, 600, "findCustomsCode", "1,0,1,1,1,1,1", true);

	   /* if (rtnVal != null) {
			sheetObj.SetCellValue(Row, 'otr_dchg_cd',rtnVal.cd,0);
			sheetObj.SetCellValue(Row, 'loc_nm',rtnVal.wh_nm,0);
			sheetObj.SetCellValue(Row, 'loc_cd',rtnVal.loc_cd,0);
			sheet1_OnChange(sheetObj, Row, Col, '');
		}*/
		break;
	}
}

function findCustomsCode(rtnVal) {
	var sheetObj = sheetObjects[0];
	var Row = sheetObj.GetSelectRow();
	var Col = sheetObj.GetSelectCol();
	if (rtnVal != null) {
		sheetObj.SetCellValue(Row, 'otr_dchg_cd',rtnVal.cd,0);
		sheetObj.SetCellValue(Row, 'loc_nm',rtnVal.wh_nm,0);
		sheetObj.SetCellValue(Row, 'loc_cd',rtnVal.loc_cd,0);
		sheet1_OnChange(sheetObj, Row, Col, '');
	}

}

/**
 * sheet Change event
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObject=document.form;
	sheetObj.SetWaitImageVisible(0);
	if (formObject.view_type.value=='create') ComBtnEnable("btn_Save");
	var colName=sheetObj.ColSaveName(Col);
	var reqString="";
	var otrDchgCd="";
	var portCd="";
	var slanCd="";
	var skdDirCd="";

	switch(colName) {
		case "otr_dchg_cd" :
		case "port_cd" :
		case "slan_cd" :
		case "skd_dir_cd" :
			otrDchgCd=sheetObj.GetCellValue(Row, "otr_dchg_cd");
			portCd=sheetObj.GetCellValue(Row, "port_cd");
			slanCd=sheetObj.GetCellValue(Row, "slan_cd");
			skdDirCd=sheetObj.GetCellValue(Row, "skd_dir_cd");
			if( otrDchgCd != "" && portCd != "" && slanCd != "" && skdDirCd != "" ) {
				reqString="f_cmd=" + SEARCH + "&otr_dchg_cd=" + otrDchgCd
											  + "&port_cd=" + portCd
											  + "&slan_cd=" + slanCd
											  + "&skd_dir_cd=" + skdDirCd;
				var selectRows=doActionIBSheet(sheetObj,document.form,SEARCH12, reqString);
				if(selectRows >= 1) {
					ComShowCodeMessage('BKG00488', "Customs Code : " + otrDchgCd  + ", Port : " + portCd + ",\nLane : " + slanCd + ", Dir : " + skdDirCd);
					sheetObj.SetCellValue(Row, "otr_dchg_cd","",0);
					sheetObj.SetCellValue(Row, "port_cd","",0);
					sheetObj.SetCellValue(Row, "slan_cd","",0);
					sheetObj.SetCellValue(Row, "skd_dir_cd","",0);
				}
			}
		break;
	}
}

/**
 * select btn clk
 *
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function select(sheetObj,Row,Col) {
if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'otr_dchg_cd').length < 1) {
	}else {
		try{
			var obj=new Object();
			obj.cd=sheetObj.GetCellValue(Row, "otr_dchg_cd");
			obj.loc_nm=sheetObj.GetCellValue(Row, "loc_nm");
			//window.returnValue=obj;
			ComPopUpReturnValue(obj);
			ComClosePopup();
		}catch(e){}
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}
