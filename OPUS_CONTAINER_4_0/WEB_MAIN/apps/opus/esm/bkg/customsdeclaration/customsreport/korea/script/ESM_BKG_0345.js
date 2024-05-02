/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0345.js
*@FileTitle  : Bonded Area by Country Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================*/

//global variable
var sheetObjects=new Array();
var sheetCnt=0;

//Event handler processing by button click event */
document.onclick=processButtonClick;

//Event handler processing by button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject,IBSEARCH);
			break;
		case "btn_select":
			doActionIBSheet(sheetObjects[0], formObject,SEARCH11);
			break;
		case "btn_downexcel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
			break;
		case "btn_close":
			ComClosePopup();
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
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheetOnLoadFinish();
}

/**
 * sheetOnLoadFinish
 * @param
 * @return
 */
function sheetOnLoadFinish() {
	axon_event.addListener("keydown", "ComKeyEnter", document.form);
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
		case "sheet1":
			with(sheetObj){
				var HeadTitle1="Sel.|Seq.|Abbr. Code|Bonded Area Code|Bonded Area Name|Location|Phone|PIC|Fax";
				var headCount=ComCountHeadTitle(HeadTitle1);
				(headCount, 0, 0, true);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"CheckBox",  Hidden:selHidden, Width:30,   Align:"Center",  SaveName:"Sel" },
							{Type:"Seq",       Hidden:0,         Width:40,   Align:"Center",  SaveName:"Seq"      },
							{Type:"Text",      Hidden:0,         Width:110,  Align:"Center",  SaveName:"wh_cd"    },
							{Type:"Text",      Hidden:0,         Width:150,  Align:"Center",  SaveName:"cstms_cd" },
							{Type:"Text",      Hidden:0,         Width:200,  Align:"Left",    SaveName:"wh_nm"    },
							{Type:"Text",      Hidden:0,         Width:120,  Align:"Center",  SaveName:"loc_cd"   },
							{Type:"Text",      Hidden:0,         Width:120,  Align:"Center",  SaveName:"phn_no"   },
							{Type:"Text",      Hidden:0,         Width:120,  Align:"Center",  SaveName:"pson_nm"  },
							{Type:"Text",      Hidden:0,         Width:120,  Align:"Center",  SaveName:"fax_no"   } ];

				InitColumns(cols);

				SetEditable(0);
				SetSheetHeight(322);
			}

			break;
	}
}

//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);

	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(validateForm(sheetObj,formObj,sAction)) {
				sheetObj.SetWaitImageVisible(0);

				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0345GS.do", FormQueryString(formObj));

				//sheetObjects[0].RenderSheet(0);
				sheetObjects[0].LoadSearchData(sXml, {Sync:1});

				//sheetObjects[0].RenderSheet(1);
				ComOpenWait(false);
			}
			break;
		case SEARCH11:        //SELECT
			this.select(sheetObj, sheetObj.GetSelectRow(), "");
			break;
		case IBDOWNEXCEL: // EXCEL
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			if (sheetObj.RowCount()== 0 ) {
				ComShowCodeMessage("COM132501"); // No data to dowload as Excel
				return;
			} else {
				var columnSkipList="";
				columnSkipList="ibflag|Sel";
				sheetObj.Down2Excel({ HiddenColumn:0, DownCols:"1|2|3|4|5|6|7|8"});
			}

			break;
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.cnt_cd.value.length < 2) {
			ComShowCodeMessage("BKG00186");
			formObj.cnt_cd.focus();

			return false;
		}
	}

	return true;
}

/**
 * select button click Event Handling
 *
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function select(sheetObj, Row, Col) {
	if (sheetObj.GetCellValue(sheetObj.selectRow, "cstms_cd").length < 1) {
		ComClosePopup();
	} else {
		var obj = new Object();
		obj.cd = sheetObj.GetCellValue(Row, "cstms_cd");
		obj.wh_nm = sheetObj.GetCellValue(Row, "wh_nm");
		obj.loc_cd = sheetObj.GetCellValue(Row, "loc_cd");
		ComPopUpReturnValue(obj);
		ComClosePopup();
	}
}

/**
 * Dbl Click Event Handling
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	select(sheetObj, Row, Col);
}

/**
* click Event Handling
* @param SheetObj
* @param formObj
* @param sAction
* @return
*/
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	for(var i=1; i <= sheetObj.RowCount(); i++) {
		if (i != Row) {
			sheetObj.SetCellValue(i, "Sel",0);
		} else {
			sheetObj.SetCellValue(i, "Sel",1);
		}
	}
}
