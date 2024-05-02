/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0040.js
*@FileTitle  : Object List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var cmbAllTpCd= "";
var cmbAllTpNm= "";
var cmbModTpCd = "A|M";
var cmbModTpNm = "Automation|Manual";
var gAdminIds = ["CLTADM","CLTSAADM","OPUSADM","CLTML04"];
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_New":
				formObject.obj_nm.value='';
				sheetObject.RemoveAll();
				break;
			case "btn_Save":
				//formObject.obj_nm.value='';
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btn_DownExcel":
				if(sheetObject.RowCount() < 1){//no data
				  ComShowCodeMessage("com132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}					
				break;
			case "btn_RowAdd":
				var inx=sheetObject.DataInsert(-1);
				sheetObject.CellComboItem(inx, "sheet1_pso_obj_list_tp_cd", {ComboText:cmbAllTpNm, ComboCode:cmbAllTpCd} );
				break;
			case "btn_RowDel":
				ComRowHideDelete(sheetObject, "sheet1_del_chk");
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
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
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    resizeSheet();
	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
function initControl(sheetObj){
	initAdminConfig();
}

function isAdminUser(){
	var userId = document.form.user_id.value;
	if(gAdminIds.indexOf(userId) >= -1){
		return true;
	}else{
		return true;
	}
}

function initAdminConfig(){
	//Row Delete Hidden
	if(isAdminUser()){
		ComSetDisplay("btn_RowDel", true);
		sheetObjects[0].SetColHidden("sheet1_del_chk", 0);
	}else{
		ComSetDisplay("btn_RowDel", false);
		sheetObjects[0].SetColHidden("sheet1_del_chk", 1);
	}	
}
  /**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1 :
			with(sheetObj){
        
				var HeadTitle="||Obj NO.|Object Name|Object Type|Object Code|Measure Unit|Object Abbreviation Name|Yard Link|Formula|Condition|Data Source|Description";
				var headCount=ComCountHeadTitle(HeadTitle);
				//(headCount, 0, 0, true);
				var prefix="sheet1_";
		
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
		
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
				             {Type:"Int",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:prefix+"obj_list_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",  ColMerge:0,   SaveName:prefix+"obj_list_nm",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
				             {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pso_obj_list_tp_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pso_obj_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pso_meas_ut_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:0,   SaveName:prefix+"obj_list_abbr_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_link_yn",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:prefix+"foml_used_yn",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cond_used_yn",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:0,   SaveName:prefix+"dflt_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:0,   SaveName:prefix+"diff_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 } ];
		   
				InitColumns(cols);
				SetEditable(1);
	      //	SetSheetHeight(448);
			}
			break;
	}
}
  // handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	 sheetObj.ShowDebugMsg(false);
	 switch(sAction) {
	     case IBSEARCH:
	        ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            var rXml=sheetObj.GetSearchData("VOP_PSO_0040GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			sheetObj.LoadSearchData(rXml,{Sync:2} );
			sheetObj.SetColProperty(2, "sheet1_pso_obj_list_tp_cd", {ComboText:cmbModTpNm, ComboCode:cmbModTpCd} );
			sheetObj.SetCellEditable(2, "sheet1_pso_obj_list_tp_cd",1);
			ComOpenWait(false);
	    	break;
    	  case IBSAVE:
				var sParam=ComGetSaveString(sheetObjects, true, true);
				if (sParam == "") return;
				if (validateForm(sheetObj, formObj, IBSAVE)){
					formObj.f_cmd.value=MULTI;
					ComOpenWait(true);
					var sXml=sheetObjects[0].GetSaveData("VOP_PSO_0040GS.do", "f_cmd=" + MULTI + "&" + sParam);
					ComOpenWait(false);
					 
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("COM130102", "Data");
					}else{
						sheetObj.LoadSaveData(sXml);
						//var msg = ComGetSelectSingleNode(xmlStr, "MESSAGE");
						//ComShowMessage(msg);
					}
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					
				}
				break;
		   case SEARCH01:
		   		var prefix="sheet1_";
		   		formObj.f_cmd.value=SEARCH01;
		   		var sXml=sheetObj.GetSearchData("VOP_PSO_0040GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
		   		cmbAllTpCd=ComGetEtcData(sXml, "tp_cd");		
		   		cmbAllTpNm=ComGetEtcData(sXml, "tp_nm");
				var xmlUtCd=ComGetEtcData(sXml, "ut_cd");		
				var xmlUtNm=ComGetEtcData(sXml, "ut_nm");
				sheetObj.SetColProperty(prefix+"pso_obj_list_tp_cd", {ComboText:cmbAllTpNm, ComboCode:cmbAllTpCd} );
				sheetObj.SetColProperty(prefix+"pso_meas_ut_cd", {ComboText:xmlUtNm, ComboCode:xmlUtCd} );
		   		break;
	}	
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
  	switch (sAction) {
		case IBSAVE:
    	 	for(var i=sheetObj.HeaderRows(); i< sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
    	 		if((sheetObj.GetCellValue(i, "sheet1_obj_list_nm")) == "" ) {
    	 			ComShowCodeMessage("COM130403","Object Name");
    	 			return false;
    	 		} 
    	 		if ((sheetObj.GetCellValue(i, "sheet1_pso_obj_list_tp_cd")) == "" ){
    	 			ComShowCodeMessage("COM130403","Object Type");
    	 			return false;
    	 		}  
    	 		if ((sheetObj.GetCellValue(i, "sheet1_pso_meas_ut_cd")) == "" ){
    	 			ComShowCodeMessage("COM130403","Measure Unit");
    	 			return false;
    	 		} 
    	 		if ((sheetObj.GetCellValue(i, "sheet1_obj_list_abbr_nm")) == "" ){
    	 			ComShowCodeMessage("COM130403","Object Abbreviation Name");
        	 			return false;
        	 		} 
        	 	}
				break;
        }
		return true;
 }
    
function resizeSheet(){
	for (var i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}


function sheet1_OnSearchEnd(sheetObj){
	var prefix="sheet1_";
	for(var row=sheetObj.HeaderRows(); row<=sheetObj.LastRow(); row++){
		var tmpYdLinkYn = sheetObj.GetCellValue(row, prefix+"yd_link_yn");
		var tmpFomlUsedYn = sheetObj.GetCellValue(row, prefix+"foml_used_yn");
		var tmpCondUsedYn = sheetObj.GetCellValue(row, prefix+"cond_used_yn");
		if("N" == tmpYdLinkYn && "N" == tmpFomlUsedYn && "N" == tmpCondUsedYn){
			//sheetObj.SetRowEditable(row,1);
			sheetObj.SetRowBackColor(row,gColorRed);
			//sheetObj.SetCellEditable(row, prefix+"obj_list_nm",1);
			//sheetObj.SetCellEditable(row, prefix+"pso_obj_list_tp_cd",1);
			//sheetObj.SetCellEditable(row, prefix+"pso_meas_ut_cd",1);
			//sheetObj.SetCellEditable(row, prefix+"obj_list_abbr_nm",1);
			sheetObj.SetCellEditable(row, prefix+"del_chk",1);
		}else{
			sheetObj.SetCellEditable(row, prefix+"del_chk",0);
		}
		
		//Object Type : Charge(System Code) ReadOnly
		var tmpPsoObjListTpCd = sheetObj.GetCellValue(row, prefix+"pso_obj_list_tp_cd");
		if("C" == tmpPsoObjListTpCd){
			sheetObj.CellComboItem(row	,prefix+"pso_obj_list_tp_cd", {ComboText:cmbAllTpNm, ComboCode:cmbAllTpCd} );
			sheetObj.SetCellEditable(row, prefix+"pso_obj_list_tp_cd",0);
		}else{
			//
            sheetObj.CellComboItem(row	, prefix+"pso_obj_list_tp_cd", {ComboText:cmbModTpNm, ComboCode:cmbModTpCd} );
			sheetObj.SetCellEditable(row, prefix+"pso_obj_list_tp_cd",1);
		}

		//Admin
		if(isAdminUser()){
			sheetObj.SetCellEditable(row, prefix+"pso_meas_ut_cd",1);
			if("N" == tmpYdLinkYn && "N" == tmpFomlUsedYn && "N" == tmpCondUsedYn){
				sheetObj.SetCellEditable(row, prefix+"obj_list_nm",1);
				sheetObj.SetCellEditable(row, prefix+"obj_list_abbr_nm",1);
			}
		}
		
	}
}    
