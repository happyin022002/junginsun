/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1091.js
*@FileTitle  : ESM_BKG_1091
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08 
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG_0969 : business script for ESM_BKG_0969
 */
function ESM_BKG_0969() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_Select":
			// ComShowMessage("Under Construction!");
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
		case "btn_Close":
  ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var form=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	if (form.bay_pln_id.value != "") {
		doActionIBSheet(sheetObjects[0], form, IBSEARCH);
	}
}
/**
 * setting sheet initial values and header
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1":
	    with(sheetObj){
		      
		      if (location.hostname != "")
		      //no support[check again]CLT 				InitHostInfo(location.hostname, location.port, page_path);
		      var HeadTitle1="|Sel.|Seq.|Container No|Cell Position|Gross Weight|Wgt Unit|TP/SZ(ISO)|"
		      + "POL|POD|F/M|Operator|Class|Un No.";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		
		      SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eur_dg_cntr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cell_psn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"iso_cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eur_dg_full_mty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_opr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(1);
		      SetCountPosition(4);
		      SetWaitImageVisible(0);
		      FrozenCols=5;
		      SetSheetHeight(312);
      }


		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value=SEARCH;
 		sheetObj.DoSearch("ESM_BKG_1091GS.do", FormQueryString(formObj) );
		ComOpenWait(false);
		break;
	case COMMAND01: // select
		if(!validateForm(sheetObj,formObj,sAction)) return false;
		var arrSaveData=getCheckedRowsByColNames(sheetObj, "chk", "eur_dg_cntr_id|cell_psn_no" );
		var obj=new Object();
		 obj=arrSaveData ; 
		 if(obj != undefined && obj.length > 0) {
			 window.returnValue=obj;
			 ComClosePopup(); 
		 }
		break;
	}
}
/**
 * sending checked data
 * @param sheetObj
 * @param chkName
 * @param colName
 * @return
 */
function getCheckedRowsByColNames(sheetObj,chkName,colName) {
    var checkRows;
    var colsCnt=sheetObj.LastCol()+ 1;
    //no support[check again]CLT var rows=sheetObj.Rows;
    var rArray=null; // Row Data
    var cArray=null; // Column Data
    var colNameArr=null; 
    var colNameArrLength=0;
    var tmpValue="";
    checkRows=sheetObj.CheckedRows(chkName);
    if(checkRows == 0) {
        return null;
    }else {
      var idx=0;
      rArray=new Array(checkRows);
      if(colName != undefined && colName != "") {
	      colNameArr=colName.split("|");
	      colNameArrLength=colNameArr.length;
      }
      for(var i=0; i < checkRows; i++) {
    	  if(sheetObj.GetCellValue(i, chkName) == 1) {
            cArray=null;
            if(colName != null && colName != "") {
            	tmpValue="";
            	for(var ii=0; ii<colNameArrLength; ii++) {
            		tmpValue += sheetObj.GetCellValue(i, colNameArr[ii]);
            		if(ii < colNameArrLength-1) {
            			tmpValue += "|";
            		}
            	}
        		cArray=tmpValue;
            } else {
              cArray=new Array(colsCnt);
              for(var j=0; j<cArray.length; j++) {
            	  cArray[j]=sheetObj.GetCellValue(i, j);
                      }
                  }
                  rArray[idx++]=cArray;
           }
        }
      }
      return rArray;
  }
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var sheet1RowCnt=sheetObj.RowCount();
	switch (sAction) {
		case IBSEARCH: { // retrieve
			if (!ComChkValid(formObj))
				return false;
			break;
		}
		case COMMAND01: {
			if(formObj.openType.value != "2") { // 메인 페이지에서 팝업으로 open아니면
				return false;
			}
			if(formObj.currMainPageListCnt.value == "0") { // 메인 페이지 sheet에 retrieve된 건이 0건이면
				ComShowMessage("Results are viewed on the main page!");
				return false;
			}
			break;
		}
	}
	return true;
}
/**
 * event handling when double click on the cell of data field
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	// var obj = new Object();
	//		   
	// obj.cd = sheetObj.CellValue(Row, "eur_dg_cntr_id");
	// obj.nm = sheetObj.CellValue(Row, "cell_psn_no");
	//		
	// if(obj.cd !="" && obj.nm != "") {
	// window.returnValue = obj;
	// self.close();
	// }
}
/**
 * process when input retrieve keyword
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (srcName == "bay_pln_id" && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * event handling after retrieve
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.checkAll2("chk")=0;
}
