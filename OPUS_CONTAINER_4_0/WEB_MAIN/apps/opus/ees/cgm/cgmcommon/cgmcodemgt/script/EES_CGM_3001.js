/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_3001.js
*@FileTitle  : Chassis pool company Manager (General Inventory Graphic)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/**
 * @extends
 * @class EES_CGM_3001 : business script for EES_CGM_3001EES_CGM_3001
 */
function ees_cgm_3001() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
    document.onclick=processButtonClick;
 // Event handler processing by button name */
function processButtonClick() {
	/** *** use additional sheet var in case of more than 2 tap each sheet **** */
	var sheetObject1=sheetObjects[0];
	// var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	// 
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
		case "btn_add":
			doActionIBSheet(sheetObject1,formObject,IBINSERT);
			break;
		case "btn_del":
			doActionIBSheet(sheetObject1,formObject,REMOVE);
			break;
		} // end switch
		tRoleApply();
    }catch(e) {
        if( e == "[object Error]") {
         ComShowMessage(OBJECT_ERROR);
        } else {
         ComShowMessage(e.message);
        }
    }
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	tRoleApply();
	sheet1_OnLoadFinish(sheet1);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}
/**
 * function(ex:btn_save) role(trole) apply <br>
 * 
 * @param
 * @return 
 * @author 
 * @version 
 */     
 function tRoleApply() {
//  var formObj=document.form;
//  if(formObj.trole.value == "Authenticated")
//  {
//  }else
//  {
//	  ComBtnDisable("btn_save");
//	  ComBtnDisable("btn_del");
//	  ComBtnDisable("btn_add");
//  }
 } 
 /**
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items
  * defining list on the top of source
  */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * setting sheet initial values and header / param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
		case 1: 
			with (sheetObj) {
				var HeadTitle="|Sel|Chassis Pool Code|Chassis Pool Name|Pool Management Company Code |Pool Management Company Name|Create User|Create Date|Update User|Update Date";
	
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var prefix="sheet1_";
				var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"chss_pool_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:prefix+"chss_pool_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pool_mgmt_co_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pool_mgmt_co_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",     KeyField:0,   CalcLogic:"",   Format:"####-##-##",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 }
				             ];
				 
				InitColumns(cols);
	
				SetEditable(1);
//				SetSheetHeight(362);
				resizeSheet();
			}
			sheetObj.SetColProperty(0, prefix + "chss_pool_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
			sheetObj.SetColProperty(0 ,prefix + "pool_mgmt_co_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
			sheetObj.SetColProperty(0 ,prefix+"cre_dt", {Format:"####-##-##"} );
			sheetObj.SetColProperty(0 ,prefix+"upd_dt", {Format:"####-##-##"} );
	    	break;
    	}
    }
function resizeSheet( ){
	ComResizeSheet( sheetObjects[0] );
}
 // handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	var prefix="sheet1_";
	var form=document.form;
	var sheetObject1=sheetObjects[0];
	switch (sAction) {
    	case IBSEARCH: // retrieve
    		sheetObj.SetWaitImageVisible(0);
    		ComOpenWait(true);		 	
    		formObj.f_cmd.value=SEARCH;
    		sheetObj.DoSearch("EES_CGM_3001GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
     		ComOpenWait(false);
    		break;
    	case IBSAVE: // saving
    		for(i=1; i < sheetObj.rowCount+1; i++){
    			if(sheetObj.GetCellValue(i, prefix + "chss_pool_cd") == "" || sheetObj.GetCellValue(i, prefix + "chss_pool_cd" == null)){
    				ComShowCodeMessage("CGM10004", "Chassis Pool Code");
    				sheetObj.SelectCell(i, prefix + "chss_pool_cd", true);
    				return
    			}
    		}
    		sheetObj.SetWaitImageVisible(0);
     		ComOpenWait(true);		 	
    		formObj.f_cmd.value=MULTI;
    		sheetObj.DoSave("EES_CGM_3001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
     		ComOpenWait(false);		 
    		break;
    	case IBINSERT: // inserting
    		sheetObj.DataInsert(0);
    		// setting hidden culumn value(CUD Query mandatory culumn value)
    		for(i=1; i<sheetObj.rowCount+1; i++){
    			if(sheetObj.GetCellValue(i, prefix + "ibflag") == "D") {
    				continue;
    			}
    		}
            break;
    	case REMOVE: // deleting
    		ComRowHideDelete(sheetObject1, prefix + "del_chk");
    		break;
	}
}
/**
 *  duplication check
 */
function sheet1_OnChange(sheetObj, Row, Col){
	var sheetObj=sheetObjects[0];
 	var formObj=document.form;
 	var prefix="sheet1_";
 	var invRefNoCol=sheetObj.SaveNameCol(prefix + "chss_pool_cd");
 	if (Col == invRefNoCol && Row !=0) { 
		var GetCellValue=sheetObj.GetCellValue(Row, Col);
//		var Row2=sheetObj.FindText(Col, GetCellValue, -1);
		var Row2=sheetObj.FindText(Col, GetCellValue, Row, -1, false);
 		if(Row2 > 0){
// 			Row2=sheetObj.FindText(Col, GetCellValue, Row2+1);
 			var startRow = parseInt(Row2)+1;
 			Row2=sheetObj.FindText(Col, GetCellValue, startRow, -1, false);
 			if (Row2 > 0) {
	        	ComShowCodeMessage('COM12115', 'Chassis Pool Code');
				sheetObj.SetCellValue(Row, Col,'',0);
				sheetObj.SelectCell(Row, Col, true);
 			}
		}
	}
}
function sheet1_OnLoadFinish(sheetObj) {
    sheetObj.SetWaitImageVisible(0);
	 for (i=0; i < sheetObjects.length; i++) {
	     doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	 }
    doActionIBSheet(sheetObj,document.form,IBCLEAR);
    sheetObj.SetWaitImageVisible(1);
}

function sheet1_OnSaveEnd(sheetObj, errMsg){
	ComShowCodeMessage("CGM00003");
}
/* developer jop */
