/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_EQR_1021_01.js
 *@FileTitle : MTY COD Simulation 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var currentSheet="";
var sheetObjects=new Array();
var sheetCnt=0;
var keyId="";
var findVvdMaxCount=50;
var popupCnt=0;
document.onclick=processButtonClick;
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_s1retrieve":
			searchLane(sheetObjects[0], document.form.lane1.value, document.form.lane1);
			break;
		case "btn_s2retrieve":
			searchLane(sheetObjects[2], document.form.lane2.value, document.form.lane2);
			break;
		case "btn_s3retrieve":
			searchLane(sheetObjects[4], document.form.lane3.value, document.form.lane3);
			break;
		case "btn_s4retrieve":
			searchLane(sheetObjects[6], document.form.lane4.value, document.form.lane4);
			break;
		case "btn_s5retrieve":
			searchLane(sheetObjects[8], document.form.lane5.value, document.form.lane5);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("EQR01147");
		} else {
			alert(e);
		}
	}
}
/**
 * REMARK POPUP.
 * @return
 */
function remarkPop() {
var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
ComOpenWindowCenter("/opuscntr/EES_EQR_1054.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane=" + sheetObjects[10].GetCellValue(Row, "lane")
+ "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision=" + sheetObjects[10].GetCellValue(Row, "weekdivision")
+ "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
}
/**
 * IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var frmObj=document.form;
//	axon_event.addListener('click', 'radio_click', 'tpsz', '');		
	//axon_event.addListenerForm('keypress', 'obj_keypress', frmObj);	
	initControl();
}
/**
 * script 
 * @return
 */
function initControl() {
	ComBtnDisable("btn_s1retrieve");
	ComBtnDisable("btn_s2retrieve");
	ComBtnDisable("btn_s3retrieve");
	ComBtnDisable("btn_s4retrieve");
	ComBtnDisable("btn_s5retrieve");
	parent.ComBtnDisable_frameLayer0("btn_remark");
	parent.ComBtnDisable_frameLayer0("btn_mainretrieve");
	this.scroll(324, 0);
}
function hideCursorBar(){
	sheetObjects[0].SetSelectRow(0);
	sheetObjects[1].SetSelectRow(0);
	sheetObjects[2].SetSelectRow(0);
	sheetObjects[3].SetSelectRow(0);
	sheetObjects[4].SetSelectRow(0);
	sheetObjects[5].SetSelectRow(0);
	sheetObjects[6].SetSelectRow(0);
	sheetObjects[7].SetSelectRow(0);
	sheetObjects[8].SetSelectRow(0);
	sheetObjects[9].SetSelectRow(0);
}
/**
 * searchLane
 * 
 * @param sheetObj
 * @param lane
 * @return
 */
function searchLane(sheetObj, lane, laneObj) {
	if (lane == "" || lane == null) {
		ComShowCodeMessage("EQR90196");
		laneObj.focus();
		return;
	}
	var flag=sheetObj.FindText(1, lane);
	if (flag == -1) {
		ComShowCodeMessage("EQR90197");
		laneObj.value="";
		laneObj.focus();
		return;
	} else {
		hideCursorBar();
		sheetObj.SelectCell(flag, 1, false);
	}
	laneObj.value="";
}
/**
 * searchVvd
 * 
 * @param vvd
 * @return
 */
function searchVvd(vvd, vvdObj) {
	if (vvd == "" || vvd == null) {
		ComShowCodeMessage("EQR90198");
		vvdObj.focus();
		return;
	}
	var flag=sheetObjects[11].FindText(4, vvd);
	if (flag == -1) {
		ComShowCodeMessage("EQR90199");
		vvdObj.value="";
		vvdObj.focus();
		return;
	} else {
		var weekDivision=sheetObjects[11].GetCellValue(flag, 1);
		if (weekDivision == 1) {
			weekDivision=parseInt(weekDivision) - 1;
			this.scroll(0, 0);
		} else if (weekDivision == 2) {
			weekDivision=parseInt(weekDivision);
			this.scroll(0, 0);
		} else if (weekDivision == 3) {
			weekDivision=parseInt(weekDivision) + 1;
			this.scroll(324, 0);
		} else if (weekDivision == 4) {
			weekDivision=parseInt(weekDivision) + 2;
			this.scroll(900, 0);
		} else if (weekDivision == 5) {
			weekDivision=parseInt(weekDivision) + 3;
			this.scroll(900, 0);
		}
		hideCursorBar();
		var Row=sheetObjects[weekDivision].FindText(2, vvd);
		//sheetObjects[weekDivision].focus();
		sheetObjects[weekDivision].SelectCell(Row, 2, false);
	}
	vvdObj.value="";
}
/**
 * obj_keypress 
 * 
 * @return
 */
function obj_keypress() {
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	switch (event.srcElement.name) {
	case "lane1":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[0], document.form.lane1.value, document.form.lane1);
		}
		break;
	case "lane2":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[2], document.form.lane2.value, document.form.lane2);
		}
		break;
	case "lane3":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[4], document.form.lane3.value, document.form.lane3);
		}
		break;
	case "lane4":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[6], document.form.lane4.value, document.form.lane4);
		}
		break;
	case "lane5":
		ComKeyOnlyAlphabet('uppernum');
		if (keyValue == 13) {
			searchLane(sheetObjects[8], document.form.lane5.value, document.form.lane5);
		}
		break;
	}
}
/**
 * @return
 */
function radio_click() {
	var formObject=parent.document.form;
	var val="";
	for ( var i=0; i < formObject.tpsz.length; i++) {
		if (formObject.tpsz[i].checked) {
			val=formObject.tpsz[i].value;
		}
	}
	if (val == "D") { 
		for ( var i=9; i < 22; i++) {
			sheetObjects[0].SetColHidden(i,1);
			sheetObjects[2].SetColHidden(i,1);
			sheetObjects[4].SetColHidden(i,1);
			sheetObjects[6].SetColHidden(i,1);
			sheetObjects[8].SetColHidden(i,1);
		}
		for ( var i=5; i < 9; i++) {
			sheetObjects[0].SetColHidden(i,0);
			sheetObjects[2].SetColHidden(i,0);
			sheetObjects[4].SetColHidden(i,0);
			sheetObjects[6].SetColHidden(i,0);
			sheetObjects[8].SetColHidden(i,0);
		}
		for ( var i=6; i < 19; i++) {
			sheetObjects[1].SetColHidden(i,1);
			sheetObjects[3].SetColHidden(i,1);
			sheetObjects[5].SetColHidden(i,1);
			sheetObjects[7].SetColHidden(i,1);
			sheetObjects[9].SetColHidden(i,1);
		}
		for ( var i=2; i < 6; i++) {
			sheetObjects[1].SetColHidden(i,0);
			sheetObjects[3].SetColHidden(i,0);
			sheetObjects[5].SetColHidden(i,0);
			sheetObjects[7].SetColHidden(i,0);
			sheetObjects[9].SetColHidden(i,0);
		}
	} else if (val == "S") { 
		for ( var i=5; i < 9; i++) {
			sheetObjects[0].SetColHidden(i,1);
			sheetObjects[2].SetColHidden(i,1);
			sheetObjects[4].SetColHidden(i,1);
			sheetObjects[6].SetColHidden(i,1);
			sheetObjects[8].SetColHidden(i,1);
		}
		for ( var i=9; i < 22; i++) {
			sheetObjects[0].SetColHidden(i,0);
			sheetObjects[2].SetColHidden(i,0);
			sheetObjects[4].SetColHidden(i,0);
			sheetObjects[6].SetColHidden(i,0);
			sheetObjects[8].SetColHidden(i,0);
		}
		for ( var i=2; i < 6; i++) {
			sheetObjects[1].SetColHidden(i,1);
			sheetObjects[3].SetColHidden(i,1);
			sheetObjects[5].SetColHidden(i,1);
			sheetObjects[7].SetColHidden(i,1);
			sheetObjects[9].SetColHidden(i,1);
		}
		for ( var i=6; i < 19; i++) {
			sheetObjects[1].SetColHidden(i,0);
			sheetObjects[3].SetColHidden(i,0);
			sheetObjects[5].SetColHidden(i,0);
			sheetObjects[7].SetColHidden(i,0);
			sheetObjects[9].SetColHidden(i,0);
		}
	} else { 
		for ( var i=1; i < 22; i++) {
			sheetObjects[0].SetColHidden(i,0);
			sheetObjects[1].SetColHidden(i,0);
			sheetObjects[2].SetColHidden(i,0);
			sheetObjects[3].SetColHidden(i,0);
			sheetObjects[4].SetColHidden(i,0);
			sheetObjects[5].SetColHidden(i,0);
			sheetObjects[6].SetColHidden(i,0);
			sheetObjects[7].SetColHidden(i,0);
			sheetObjects[8].SetColHidden(i,0);
			sheetObjects[9].SetColHidden(i,0);
		}
	}
}
/**
 * sheet initialize
 */
function initSheet(sheetObj, sheetNo, HeadTitle) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
     // (28, 0, 0, true);
      var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|||||";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:1,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r9",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"keyid" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"etbweekdivision" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remarkflag" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remark" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"firstetb" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"weekdivision" } ];
       
      InitColumns(cols);
      
      SetEditable(1);
      SetEditableColorDiff(0);
      SetCountPosition(0);
      InitComboNoMatchText(true);
      InitViewFormat(0, "etb", "MM-dd");
      radio_click();
      //FrozenCols=5;
      SetSheetHeight(302);
      SetSheetWidth(330);
      ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21",  CaptionCol:2, CaptionText:"Total"}]);
      }


		break;
	case "sheet2": // sheet2 init
	    with(sheetObj){
       
     
      //(28, 0, 0, true);
      var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|||||";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:1,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r9",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"keyid" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"etbweekdivision" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remarkflag" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remark" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"firstetb" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"weekdivision" } ];
       
      InitColumns(cols);
      SetSheetHeight(302);
      SetSheetWidth(330);
      SetEditable(1);
      SetEditableColorDiff(0);
      SetCountPosition(0);
            InitComboNoMatchText(true);
      InitViewFormat(0, "etb", "MM-dd");
      radio_click();
      FrozenCols=5;
      ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", Sort:false, ShowCumulate:false, CaptionCol:2, CaptionText:"Total"}]);
      }


		break;
	case "sheet3": // sheet3 init
	    with(sheetObj){
      //(28, 0, 0, true);
      var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|||||";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:1,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r9",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"keyid" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"etbweekdivision" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remarkflag" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remark" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"firstetb" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"weekdivision" } ];
       
      InitColumns(cols);
      SetSheetHeight(302);
      SetSheetWidth(330);
      SetEditable(1);
      SetEditableColorDiff(0);
      SetCountPosition(0);
            InitComboNoMatchText(true);
      InitViewFormat(0, "etb", "MM-dd");
      radio_click();
      FrozenCols=5;
      ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", Sort:false, ShowCumulate:false, CaptionCol:2, CaptionText:"Total"}]);
      }


		break;
	case "sheet4": // sheet4 init
	    with(sheetObj){
      //(28, 0, 0, true);
      var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|||||";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:1,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r9",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"keyid" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"etbweekdivision" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remarkflag" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remark" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"firstetb" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"weekdivision" } ];
       
      InitColumns(cols);
      SetSheetHeight(302);
      SetSheetWidth(330);
      SetEditable(1);
      SetEditableColorDiff(0);
      SetCountPosition(0);
            InitComboNoMatchText(true);
      InitViewFormat(0, "etb", "MM-dd");
      radio_click();
      FrozenCols=5;
      ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", Sort:false, ShowCumulate:false, CaptionCol:2, CaptionText:"Total"}]);
      }


		break;
	case "sheet5": // sheet5 init
	    with(sheetObj){
        
      var HeadTitle1="V|LANE|VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|||||";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:32,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0 },
             {Type:"Text",     Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Date",      Hidden:0,  Width:34,   Align:"Center",  ColMerge:1,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:true,UpdateEdit:0 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"r9",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"o5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"keyid" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"etbweekdivision" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remarkflag" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"remark" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"firstetb" },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"weekdivision" } ];
       
      InitColumns(cols);
      SetSheetHeight(302);
      SetSheetWidth(330);
      SetEditable(1);
      SetEditableColorDiff(0);
      SetCountPosition(0);
            InitComboNoMatchText(true);
      InitViewFormat(0, "etb", "MM-dd");
      radio_click();
      FrozenCols=5;
      ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", Sort:false, ShowCumulate:false, CaptionCol:2, CaptionText:"Total"}]);
      }


		break;
	 /*********************************************** Top Grid End *************************************************************************************/
	case "sheet6": // sheet6 init
	    with(sheetObj){
        
      
      //(19, 0, 0, true);
      var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r9",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 } ];
       
      InitColumns(cols);
      SetSheetHeight(262);
      SetSheetWidth(330);
      SetEditable(0);
      SetCountPosition(0);
            radio_click();
      FrozenCols=2;
      }


		break;
	case "sheet7": // sheet7 init
	    with(sheetObj){
        
      
      //(19, 0, 0, true);
      var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r9",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 } ];
       
      InitColumns(cols);
      SetSheetHeight(262);
      SetSheetWidth(330);
      SetEditable(0);
      SetCountPosition(0);
            radio_click();
      FrozenCols=2;
      }


		break;
	case "sheet8": // sheet8 init
	    with(sheetObj){
        
      
      //(19, 0, 0, true);
      var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r9",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 } ];
       
      InitColumns(cols);
      SetSheetHeight(262);
      SetSheetWidth(330);
      SetEditable(0);
      SetCountPosition(0);
            radio_click();
      FrozenCols=2;
      }


		break;
	case "sheet9": // sheet9 init
	    with(sheetObj){
        
      
      //(19, 0, 0, true);
      var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r9",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 } ];
       
      InitColumns(cols);
      SetSheetHeight(262);
      SetSheetWidth(330);
      SetEditable(0);
      SetCountPosition(0);
            radio_click();
      FrozenCols=2;
      
      }


		break;
	case "sheet10": // sheet10 init
	    with(sheetObj){
        
     
      //(19, 0, 0, true);
      var HeadTitle1="|MTY Dishcarge Vol|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
      if (HeadTitle != "" && HeadTitle != null) {
      HeadTitle1=HeadTitle;
      }

      SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"d7",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"r9",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"s4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"o5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"a4",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:37,   Align:"Center",  ColMerge:0,   SaveName:"f5",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 } ];
       
      InitColumns(cols);
      SetSheetHeight(262);
      SetSheetWidth(330);
      SetEditable(0);
      SetCountPosition(0);
            radio_click();
      FrozenCols=2;
      }


		break;
	case "vvdTotal": // vvdTotal init
	    with(sheetObj){
        
      
      var HeadTitle1="1|2|3|4|5|6|7|8|9|10|11";

      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"weekdivision",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"week",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"div",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lane",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"remarkflag",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"status" },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Left",    ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mnlinpflg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 } ];
       
      InitColumns(cols);
      SetSheetHeight(182);
      SetEditable(1);
      SetCountPosition(0);
            }


		break;
	case "portTotal": // portTotal init
	    with(sheetObj){
        
      var HeadTitle1="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30";

      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"keyid" },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"weekdivision",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"week",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"div",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"remarkflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"idflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"etb",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"etbweek",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"etbweekdivision",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"d2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"d4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"d5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"d7",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"r2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"r5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"r9",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"o2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"s2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"o4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"s4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"o5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"f2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"a2",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"f4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"a4",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Int",       Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"f5",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:true,UpdateEdit:1 },
             {Type:"Text",     Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"status" },
             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"hiddencheck" },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"yardcode",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"clptindseq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 } ];
       
      InitColumns(cols);
      SetSheetHeight(182);
      SetEditable(1);
      SetCountPosition(0);
            }


		break;
		/*********************************************** Bottom Grid End *************************************************************************************/
	}
}
// Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // Search
		if (validateForm(sheetObj, formObj, sAction)) {
			this.scroll(324, 0);
			formObj.f_cmd.value=SEARCH01;
			formObj.week.value=parent.document.form.week.value.replace(/\/|\-|\./g, "");
			formObj.trade.value=parent.document.form.trade.value;
			initControl();
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("EES_EQR_1021_01GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			var week=ComGetEtcData(arrXml[0], "sHead");
			week=week.split(",");
			var week1=week[0];
			var week2=week[1];
			var week3=week[2];
			var week4=week[3];
			var week5=week[4];
			var HeadTitle1="V|LANE|WK" + week1.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5||||";
			var HeadTitle2="V|LANE|WK" + week2.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5||||";
			var HeadTitle3="V|LANE|WK" + week3.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5||||";
			/*
			 * var HeadTitle4 = week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|" + week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|" + week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|" + week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|" + week + " (Lane basis, 1st Asian port's ETB)|" +
			 * week + " (Lane basis, 1st Asian port's ETB)|" + week + " (Lane
			 * basis, 1st Asian port's ETB)|" + week + " (Lane basis, 1st Asian
			 * port's ETB)|";
			 * 
			 * week = week5.substring(0, 4) + "-" + week5.substring(4, 6);
			 */
			var HeadTitle4="V|LANE|WK" + week4.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5||||";
			var HeadTitle5="V|LANE|WK" + week5.substring(4, 6) + " VVD|POD|ETB|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5||||";
			/*
			 * week = week1.substring(0, 4) + "-" + week1.substring(4, 6);
			 * 
			 * var HeadTitle6 = "|" + week + " (Port basis)|" + week + " (Port
			 * basis)|" + week + " (Port basis)|" + week + " (Port basis)|" +
			 * week + " (Port basis)|" + week + " (Port basis)|" + week + "
			 * (Port basis)|" + week + " (Port basis)|" + week + " (Port
			 * basis)|" + week + " (Port basis)|" + week + " (Port basis)|" +
			 * week + " (Port basis)|" + week + " (Port basis)|" + week + "
			 * (Port basis)|" + week + " (Port basis)|" + week + " (Port
			 * basis)";
			 */
			var HeadTitle6="|WK" + week1.substring(4, 6) +"("+ week1.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
			var HeadTitle7="|WK" + week2.substring(4, 6) +"("+ week2.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
			var HeadTitle8="|WK" + week3.substring(4, 6) +"("+ week3.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
			var HeadTitle9="|WK" + week4.substring(4, 6) +"("+ week4.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
			var HeadTitle10="|WK" + week5.substring(4, 6) +"("+ week5.substring(6) +")|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
			sheetObjects[0].RenderSheet(0);
			sheetObjects[0].RemoveAll();
			sheetObjects[0] = sheetObjects[0].Reset();
			sheetObjects[1].RenderSheet(0);
			sheetObjects[1].RemoveAll();
			sheetObjects[1] = sheetObjects[1].Reset();
			sheetObjects[2].RenderSheet(0);
			sheetObjects[2].RemoveAll();
			sheetObjects[2] = sheetObjects[2].Reset();
			sheetObjects[3].RenderSheet(0);
			sheetObjects[3].RemoveAll();
			sheetObjects[3] = sheetObjects[3].Reset();
			sheetObjects[4].RenderSheet(0);
			sheetObjects[4].RemoveAll();
			sheetObjects[4] = sheetObjects[4].Reset();
			sheetObjects[5].RenderSheet(0);
			sheetObjects[5].RemoveAll();
			sheetObjects[5] = sheetObjects[5].Reset();
			sheetObjects[6].RenderSheet(0);
			sheetObjects[6].RemoveAll();
			sheetObjects[6] = sheetObjects[6].Reset();
			sheetObjects[7].RenderSheet(0);
			sheetObjects[7].RemoveAll();
			sheetObjects[7] = sheetObjects[7].Reset();
			sheetObjects[8].RenderSheet(0);
			sheetObjects[8].RemoveAll();
			sheetObjects[8] = sheetObjects[8].Reset();
			sheetObjects[9].RenderSheet(0);
			sheetObjects[9].RemoveAll();
			sheetObjects[9] = sheetObjects[9].Reset();
			initSheet(sheetObjects[0], '', HeadTitle1);
			initSheet(sheetObjects[1], '', HeadTitle2);
			initSheet(sheetObjects[2], '', HeadTitle3);
			initSheet(sheetObjects[3], '', HeadTitle4);
			initSheet(sheetObjects[4], '', HeadTitle5);
			
			initSheet(sheetObjects[5], '', HeadTitle6);
			initSheet(sheetObjects[6], '', HeadTitle7);
			initSheet(sheetObjects[7], '', HeadTitle8);
			initSheet(sheetObjects[8], '', HeadTitle9);
			initSheet(sheetObjects[9], '', HeadTitle10);
			
			sheetObjects[0].RenderSheet(1);
			sheetObjects[1].RenderSheet(1);
			sheetObjects[2].RenderSheet(1);
			sheetObjects[3].RenderSheet(1);
			sheetObjects[4].RenderSheet(1);
			sheetObjects[5].RenderSheet(1);
			sheetObjects[6].RenderSheet(1);
			sheetObjects[7].RenderSheet(1);
			sheetObjects[8].RenderSheet(1);
			sheetObjects[9].RenderSheet(1);
			//------------------------------------------------------------------------------------------------------------------------------
			// SHEET 1 ~ 12 (data load)
			if (arrXml.length > 0)
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			if (arrXml.length > 1)
				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			if (arrXml.length > 2)
				sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			if (arrXml.length > 3)
				sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
			if (arrXml.length > 4)
				sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
			if (arrXml.length > 5)
				sheetObjects[5].LoadSearchData(arrXml[5],{Sync:1} );
			if (arrXml.length > 6)
				sheetObjects[6].LoadSearchData(arrXml[6],{Sync:1} );
			if (arrXml.length > 7)
				sheetObjects[7].LoadSearchData(arrXml[7],{Sync:1} );
			if (arrXml.length > 8)
				sheetObjects[8].LoadSearchData(arrXml[8],{Sync:1} );
			if (arrXml.length > 9)
				sheetObjects[9].LoadSearchData(arrXml[9],{Sync:1} );
			if (arrXml.length > 10)
				sheetObjects[10].LoadSearchData(arrXml[10],{Sync:1} );
			if (arrXml.length > 11)
				sheetObjects[11].LoadSearchData(arrXml[11],{Sync:1} );
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(false);
		} else {
			ComSetFocus(parent.document.form.week);
			return;
		}
		break;
	case IBSAVE: // save
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value=MULTI;
		var sParam1=sheetObjects[10].GetSaveString(false, true, "status");
		if (sParam1 == "") { // 
			ComShowCodeMessage("EQR90225");
			return;
		}
		if (!ComShowCodeConfirm("EQR90192")) return;
		/*
		 * vvd_port_master sheet Delete
		 */
		var deleteChecks=false;
		for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
			deleteChecks=false;
			if (sheetObjects[11].GetCellValue(i, "status") == "I" && (sheetObjects[11].GetCellValue(i, "etb") == "" || sheetObjects[11].GetCellValue(i, "etb") == "SKIP")) {
				for ( var j=12; j < 28; j++) {
					if (sheetObjects[11].GetCellValue(i, j) != 0) {
						deleteChecks=true;
					}
				}
				if (deleteChecks == false) { 
					sheetObjects[11].SetCellValue(i, "status","D");
				}
			}
		}
		var sParam2=sheetObjects[11].GetSaveString(false);
		sParam1=ComSetPrifix(sParam1, "sub");
		sParam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj);
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		var sXml=sheetObj.GetSaveData("EES_EQR_1021_01GS.do", sParam);
		sheetObjects[10].LoadSaveData(sXml, false, "status");
		doActionIBSheet(sheetObjects[4], formObj, IBSEARCH);
		break;
	case IBINSERT: // insert
		var row=sheetObj.DataInsert();
		keyId=sheetObjects[10].RowCount()+ sheetObjects[11].RowCount()+ 1;
		if (sheetObj.GetSelectRow()> 1) {
sheetObj.SetCellValue(sheetObj.GetSelectRow(), 0,sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, 0),0);
sheetObj.SetCellValue(sheetObj.GetSelectRow(), 1,sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, 1),0);
sheetObj.SetCellValue(sheetObj.GetSelectRow(), 2,sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, 2),0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 21,keyId,0);
		} else {
sheetObj.SetCellValue(sheetObj.GetSelectRow(), 0,sheetObj.GetCellValue(sheetObj.GetSelectRow(), 0),0);
sheetObj.SetCellValue(sheetObj.GetSelectRow(), 1,sheetObj.GetCellValue(sheetObj.GetSelectRow(), 1),0);
sheetObj.SetCellValue(sheetObj.GetSelectRow(), 2,sheetObj.GetCellValue(sheetObj.GetSelectRow(), 2),0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), 21,keyId,0);
		}
		break;
	case IBDELETE: // delete
		if (!ComShowCodeConfirm("EQR90193"))
			return;
		var deleteCheck=false;
		var deleteNum=0;
var num=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 21);
		// port_summary sheet Delete 
		if (num != "") { // SUMMARY SHEET
			if (num == "1") {
				num="1";
			} else if (num == "2") {
				num="3";
			} else if (num == "3") {
				num="5";
			} else if (num == "4") {
				num="7";
			} else if (num == "5") {
				num="9";
			}
			for ( var i=1; i < sheetObjects[num].RowCount()+ 1; i++) {
if (sheetObj.GetCellText(sheetObj.GetSelectRow(), 3) == sheetObjects[num].GetCellValue(i, 1)) {
					for ( var j=2; j < 18; j++) {
						// SUMMARY POD SHEET 
sheetObjects[num].SetCellValue(i, j,sheetObjects[num].GetCellValue(i, j) - sheetObj.GetCellValue(sheetObj.GetSelectRow(), j + 3));
if (sheetObjects[num].GetCellValue(i, j) != 0) {
							deleteCheck=true;
						}
					}
					deleteNum=i;
					break;
				}
			}
			if (deleteCheck == false) { 
				sheetObjects[num].RowDelete(deleteNum, false);
			}
		}
		// vvd_port_master sheet Delete <== Hidden
		deleteCheck=false;
		for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
if (sheetObjects[11].GetCellValue(i, 0) == sheetObj.GetCellValue(sheetObj.GetSelectRow(), 21)) {
				for ( var j=12; j < 28; j++) {
sheetObjects[11].SetCellValue(i, j,sheetObjects[11].GetCellValue(i, j) - sheetObj.GetCellValue(sheetObj.GetSelectRow(), j - 7),0);
if (sheetObjects[11].GetCellValue(i, j) != 0) {
						deleteCheck=true;
					}
				}
				// sheetObjects[11].CellValue(i, "status") = "I";
				// ComDebug(sheetObjects[11].CellValue(i, "status"));
				deleteNum=i;
				deleteDetail(sheetObj, sheetObj.GetSelectRow());
			}
		}
		if (deleteCheck == false) {
			sheetObjects[11].SetCellValue(deleteNum, "status","I");
			// sheetObjects[11].RowDelete(deleteNum, false);
		}
		sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
		sheetObj.HideSubSum();
		sheetObj.ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"0=;2=Total"}]);
		break;
	}
}
/**
 * hidden sheet
 * 
 * @param sheetObj
 * @param Row
 * @return
 */
function deleteDetail(sheetObj, Row) {
	// var check = false;
	// vvd master sheet 
	for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
if (sheetObjects[10].GetCellValue(i, 3) == sheetObj.GetCellValue(Row, 2)) {
			sheetObjects[10].SetCellValue(i, 6,"I",0);
			break;
		}
	}
	// vvd_port_master sheet 
	// check = false;
	for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
if (sheetObjects[11].GetCellValue(i, 4) == sheetObj.GetCellValue(Row, 2)) {
			sheetObjects[11].SetCellValue(i, 28,"I",0);
		}
	}
}
/**
 * sheet1_OnClick
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
	// POD,ETB IS NULL
if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
	} else {
if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
var OrgValue="";
/*
function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
OrgValue=sheetObj.GetCellValue(Row, Col);
} 
*/
/**
 * sheet1 key down press
 */
function sheet1_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet2 key down press
 */
function sheet2_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet3 key down press
 */
function sheet3_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet4 key down press
 */
function sheet4_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet5 key down press
 */
function sheet5_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift) {
OrgValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * sheet1_OnChange 
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 23,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { 
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet 
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);
						// STATUS
						check=true;
						break;
					}
				} 
				// vvd_port_master sheet 
				check=false;
var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 22));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 29,"I",0);
					}
				}
				// vvd_port_master --> AddRow
				if (check == false) { 
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 22),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 29,"I",0);
					for ( var i=5; i < 22; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// HideSubSum();

				// 1~5 SUMMARY POD SHEET
if (GetCellValue(Row, 23) == '1') {
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '2') {
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '3') {
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '4') {
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '5') {
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
			}
		}
	}
}
/**
 * sheet2_OnClick
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
		// if(sheetObj.RowCount > 0){
document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
		// }
	} else {
if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
/**
 * sheet2_OnChange 
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD 
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 23,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { 
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet 
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);
						// STATUS
						check=true;
						break;
					}
				} 
				// vvd_port_master sheet 
				check=false;
var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 22));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 29,"I",0);
					}
				}
				// vvd_port_master --> AddRow
				if (check == false) { 
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 22),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 29,"I",0);
					for ( var i=5; i < 22; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// HideSubSum();
ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"0=;2=Total"}]);
				// 1~5 SUMMARY POD SHEET
if (GetCellValue(Row, 23) == '1') {
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '2') {
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '3') {
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '4') {
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '5') {
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
			}
		}
	}
}
/**
 * sheet3_OnClick
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet3_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
		// if(sheetObj.RowCount <= 1){
document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
		// }
	} else {
if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
/**
 * sheet3_OnChange 
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet3_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD 
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 23,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { 
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet 
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);
						// STATUS
						check=true;
						break;
					}
				} 
				// vvd_port_master sheet 
				check=false;
var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 22));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 29,"I",0);
					}
				}
				// vvd_port_master --> AddRow
				if (check == false) { 
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 22),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 29,"I",0);
					for ( var i=5; i < 22; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// HideSubSum();
ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"0=;2=Total"}]);
				// 1~5week SUMMARY POD SHEET
if (GetCellValue(Row, 23) == '1') {
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
							// 컨테이너 값 입력시 변경
sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '2') { // -1week Sheet value
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '3') {
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '4') { // +1week Sheet value
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '5') {
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
			}
		}
	}
}
/**
 * sheet4_OnClick
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet4_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
		// if(sheetObj.RowCount <= 1){
document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
		// }
	} else {
if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
/**
 * sheet4_OnChange 
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet4_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD 
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 23,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { 
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet 
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);
						// STATUS
						check=true;
						break;
					}
				} 
				// vvd_port_master sheet 
				check=false;
var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 22));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 29,"I",0);
					}
				}
				// vvd_port_master --> AddRow
				if (check == false) { 
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 22),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 29,"I",0);
					for ( var i=5; i < 22; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// HideSubSum();
ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"0=;2=Total"}]);
				// 1~5week SUMMARY POD SHEET
if (GetCellValue(Row, 23) == '1') { // -2 week sheet value
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '2') { // -1 week sheet value
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '3') { // Change basic week's sheet value
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '4') { // +1 week sheet value
					// 변경
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '5') {  // +2 week sheet value
					// 변경
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}
			}
		}
	}
}
/**
 * sheet5_OnClick
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet5_OnClick(sheetObj, Row, Col) {
	currentSheet=sheetObj;
if (ComGetLenByByte(sheetObj.GetCellValue(Row, 2)) > 0 && ComGetLenByByte(sheetObj.GetCellText(Row, 3)) > 0) {
		parent.ComBtnEnable_frameLayer0("btn_remark");
	} else {
		parent.ComBtnDisable_frameLayer0("btn_remark");
	}
if (Col == 3 && sheetObj.GetCellValue(Row, 4) == "" && sheetObj.GetCellText(Row, 3) == "" && sheetObj.GetCellValue(Row, 0) != "") {
document.form.vvd.value=sheetObj.GetCellValue(Row, 2);
		if (sheetObj.GetComboInfo(Row, Col, "Text") == "") {
			document.form.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("EES_EQR_1021_01GS.do", FormQueryString(document.form));
			var cols=ComXml2ComboString(sXml, "pod", "etb");
			sheetObj.CellComboItem(Row,"pod", {ComboText:"||"+cols[0], ComboCode:"||"+cols[1]} );
		}
	} else {
if (sheetObj.GetCellValue(Row, 4) != "") {
			sheetObj.SetCellEditable(Row, 3,0);
		}
	}
}
/**
 * sheet5_OnChange 
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet5_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj=document.form;
		if (Col == 3) { // POD
			var arrcode=Value.split("&&");
			var rCnt01=RowCount()+ 1;
			for ( var i=1; i < Row; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			for ( var i=Row + 1; i < rCnt01; i++) {
				if (GetCellText(i, Col) == arrcode[3] && GetCellText(i, "vvd") == GetCellText(Row, "vvd")) {
					ComShowCodeMessage("EQR90194");
					SelectCell(Row, Col, true, "");
					SetCellValue(Row, Col + 1,"",0);
					return false;
				}
			}
			SetCellValue(Row, 4,arrcode[0],0);// ETB
			SetCellValue(Row, 23,arrcode[2],0);// etbweekdivision
		} else {
			if (Col > 4) { 
				SetCellFontColor(Row, Col,"#0000FF");
				SetCellFont("FontBold", Row, Col,1);
				var check=false;
				// vvd master sheet
				for ( var i=1; i < sheetObjects[10].RowCount()+ 1; i++) {
if (sheetObjects[10].GetCellValue(i, 3) == GetCellValue(Row, 2)) {
						sheetObjects[10].SetCellValue(i, 6,"I",0);
						// STATUS
						check=true;
						break;
					}
				} 
				// vvd_port_master sheet 
				check=false;
var vvdRow1=sheetObjects[11].FindText(0, GetCellValue(Row, 22));
				if (vvdRow1 == -1) {
					check=false;
				} else {
					sheetObjects[11].SetCellValue(vvdRow1, Col + 7,Value,0);
					check=true;
				}
var vvdRowStart=sheetObjects[11].FindText(4, GetCellValue(Row, 2));
				var vvdRowEnd="";
				if (vvdRowStart == -1) {
					vvdRowStart=1;
				} else {
					if ((sheetObjects[11].RowCount()- vvdRowStart) > findVvdMaxCount) {
						vvdRowEnd=vvdRowStart + findVvdMaxCount;
					} else {
						vvdRowEnd=sheetObjects[11].RowCount()+ 1;
					}
				}
				for ( var i=vvdRowStart; i < vvdRowEnd; i++) {
if (sheetObjects[11].GetCellValue(i, 4) == GetCellValue(Row, 2)) {
						sheetObjects[11].SetCellValue(i, 29,"I",0);
					}
				}
				// vvd_port_master --> AddRow
				if (check == false) { 
					var row=sheetObjects[11].DataInsert();
					sheetObjects[11].SetCellValue(row, 0,keyId,0);
sheetObjects[11].SetCellValue(row, 3,GetCellValue(Row, 0),0);
sheetObjects[11].SetCellValue(row, 4,GetCellValue(Row, 2),0);
sheetObjects[11].SetCellValue(row, 5,GetCellValue(Row, 1),0);
sheetObjects[11].SetCellValue(row, 6,GetCellValue(Row, 22),0);
					sheetObjects[11].SetCellValue(row, 7,GetCellText(Row, 3),0);
sheetObjects[11].SetCellValue(row, 9,GetCellValue(Row, 4),0);
					sheetObjects[11].SetCellValue(row, 29,"I",0);
					for ( var i=5; i < 22; i++) {
						sheetObjects[11].SetCellValue(row, i + 7,Value,0);
						break;
					}
				}
				// HideSubSum();
ShowSubSum([{StdCol:"2", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"0=;2=Total"}]);
				// 1~5week SUMMARY POD SHEET
if (GetCellValue(Row, 23) == '1') {
					check=false;
					for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
if (sheetObjects[1].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[1].SetCellValue(i, Col - 3,parseInt(sheetObjects[1].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[1].DataInsert();
						sheetObjects[1].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[1].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '2') {
					// 변경
					check=false;
					for ( var i=1; i < sheetObjects[3].RowCount()+ 1; i++) {
if (sheetObjects[3].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[3].SetCellValue(i, Col - 3,parseInt(sheetObjects[3].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[3].DataInsert();
						sheetObjects[3].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[3].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '3') {
					check=false;
					for ( var i=1; i < sheetObjects[5].RowCount()+ 1; i++) {
if (sheetObjects[5].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[5].SetCellValue(i, Col - 3,parseInt(sheetObjects[5].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[5].DataInsert();
						sheetObjects[5].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[5].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '4') {
					check=false;
					for ( var i=1; i < sheetObjects[7].RowCount()+ 1; i++) {
if (sheetObjects[7].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[7].SetCellValue(i, Col - 3,parseInt(sheetObjects[7].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[7].DataInsert();
						sheetObjects[7].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[7].SetCellValue(row, Col - 3,Value,0);
					}
} else if (GetCellValue(Row, 23) == '5') {
					// 변경
					check=false;
					for ( var i=1; i < sheetObjects[9].RowCount()+ 1; i++) {
if (sheetObjects[9].GetCellValue(i, 1) == GetCellText(Row, 3)) {
sheetObjects[9].SetCellValue(i, Col - 3,parseInt(sheetObjects[9].GetCellValue(i, Col - 3)) - (parseInt(OrgValue) - parseInt(Value)),0);
							check=true;
						}
					}
					if (check == false) { 
						var row=sheetObjects[9].DataInsert();
						sheetObjects[9].SetCellValue(row, 1,sheetObj.GetCellText(sheetObj.GetSelectRow(), 3),0);
						sheetObjects[9].SetCellValue(row, Col - 3,Value,0);
					}
				}			
			}
		}
	}
}
/**
 * sheet1_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=1; i < RowCount()+ 1; i++) {
			if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') { 	// POD && ETB <> NULL
				SetCellEditable(i, 3,0);// EDIT FALSE
			}
			if (GetCellValue(i, 23) == "Y") { // REMARK
				// CellFontColor(i,0) = "#0000FF";
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		//ColumnSort("firstetb");

		if (sheetObj.RowCount()> 1) {
			ComBtnEnable("btn_s1retrieve");
		}
		if (sheetObjects[11].RowCount()> 1) {
			parent.ComBtnEnable_frameLayer0("btn_mainretrieve"); // PARENT RemarkVVD  
		}
	}
}
/**
 * sheet2_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=1; i < RowCount()+ 1; i++) {
if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') {
				SetCellEditable(i, 3,0);
			}
if (GetCellValue(i, 23) == "Y") {
				// CellFontColor(i,0) = "#0000FF";
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		//ColumnSort("firstetb");

		if (sheetObj.RowCount()> 1) {
			ComBtnEnable("btn_s2retrieve");
		}
	}
}
/**
 * sheet3_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=1; i < RowCount()+ 1; i++) {
if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') {
				SetCellEditable(i, 3,0);
			}
if (GetCellValue(i, 23) == "Y") {
				// CellFontColor(i,0) = "#0000FF";
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		//ColumnSort("firstetb");

		if (sheetObj.RowCount()> 1) {
			ComBtnEnable("btn_s3retrieve");
		}
	}
}
/**
 * sheet4_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=1; i < RowCount()+ 1; i++) {
if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') {
				SetCellEditable(i, 3,0);
			}
if (GetCellValue(i, 23) == "Y") {
				// CellFontColor(i,0) = "#0000FF";
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		//ColumnSort("firstetb");

		if (sheetObj.RowCount()> 1) {
			ComBtnEnable("btn_s4retrieve");
		}
	}
}
/**
 * sheet5_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=1; i < RowCount()+ 1; i++) {
if (GetCellValue(i, 4) != "" || GetCellText(i, 3) != '') {
				SetCellEditable(i, 3,0);
			}
if (GetCellValue(i, 23) == "Y") {
				SetCellFont("FontBold", i, 0,1);
				SetCellFont("FontUnderline", i, 0,1);
			}
		}
		//ColumnSort("firstetb");

		if (sheetObj.RowCount()> 1) {
			ComBtnEnable("btn_s5retrieve");
		}
	}
}
/**
 * sheet6_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}
/**
 * sheet7_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}
/**
 * sheet8_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}
/**
 * sheet9_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}
/**
 * sheet10_OnSearchEnd
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColumnSort("pod");
	}
}
/**
 * IBSeet Event - cell double click <br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
				var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
				ComOpenWindowCenter("/opuscntr/EES_EQR_1054.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
				+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
				+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		if (GetSelectCol()== 3) {
			var weekDivision=GetCellValue(Row, "weekdivision");
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}
		//--------------------------------------------------------------------------------
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet2_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
				var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
				ComOpenWindowCenter("/opuscntr/EES_EQR_1054.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
				+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
				+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		if (GetSelectCol()== 3) {
var weekDivision=GetCellValue(Row,  "weekdivision");
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet3_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
ComOpenWindowCenter("/opuscntr/EES_EQR_1054.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		if (GetSelectCol()== 3) {
var weekDivision=GetCellValue(Row,  "weekdivision");
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet4_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
ComOpenWindowCenter("/opuscntr/EES_EQR_1054.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		if (GetSelectCol()== 3) {
var weekDivision=GetCellValue(Row,  "weekdivision");
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet5_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "etb")) > 0) {
			if (GetSelectCol()<= 2) {
var Row=sheetObjects[10].FindText("vvd", currentSheet.GetCellValue(currentSheet.GetSelectRow(), "vvd"));
ComOpenWindowCenter("/opuscntr/EES_EQR_1054.do" + "?week=" + sheetObjects[10].GetCellValue(Row, "week") + "&lane="
+ sheetObjects[10].GetCellValue(Row, "lane") + "&vvd=" + sheetObjects[10].GetCellValue(Row, "vvd") + "&row=" + Row + "&weekdivision="
+ sheetObjects[10].GetCellValue(Row, "weekdivision") + "&remark=" + sheetObjects[10].GetCellValue(Row, "remark"), "EES_EQR_1054", 700, 420);
			}
		}
		if (GetSelectCol()== 3) {
var weekDivision=GetCellValue(Row, "weekdivision");
			if (weekDivision == 1) {
				weekDivision=parseInt(weekDivision);
				this.scroll(0, 0);
			} else if (weekDivision == 2) {
				weekDivision=parseInt(weekDivision) + 1;
				this.scroll(0, 0);
			} else if (weekDivision == 3) {
				weekDivision=parseInt(weekDivision) + 2;
				this.scroll(324, 0);
			} else if (weekDivision == 4) {
				weekDivision=parseInt(weekDivision) + 3;
				this.scroll(900, 0);
			} else if (weekDivision == 5) {
				weekDivision=parseInt(weekDivision) + 4;
				this.scroll(900, 0);
			}
			else{
				SelectCell(Row, 3, false);
			}
			if(weekDivision != ""){
				hideCursorBar();
				var FindRow=sheetObjects[weekDivision].FindText(1, GetCellText(Row, 3));
				sheetObjects[weekDivision].focus();
				sheetObjects[weekDivision].SelectCell(FindRow, 1, false);
			}
		}		
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet6_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "pod")) > 0) {
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 1) {
					sheetObjects[11].SetCellValue(i, 31,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
		}
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet7_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "pod")) > 0) {
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 2) {
					sheetObjects[11].SetCellValue(i, 31,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
		}
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet8_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "pod")) > 0) {
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 3) {
					sheetObjects[11].SetCellValue(i, 31,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
		}
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet9_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		if (ComGetLenByByte(GetCellvalue(Row, "pod")) > 0) {
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 4) {
					sheetObjects[11].SetCellValue(i, 31,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
		}
	}
}
/**
 * IBSeet Event - cell double click<br>
 * 
 * @param {sheetObj} String 
 * @param {Row} Long : Row Index
 * @param {Col} Long : Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : X
 * @param {CellY} Long : Y
 * @param {CellW} Long : wide
 * @param {CellH} Long : height
 */
function sheet10_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	with (sheetObj) {
		// 더블클릭한 row의 "pod"컬럼 값이 있으면
		if (ComGetLenByByte(GetCellvalue(Row, "pod")) > 0) {
			// if(SelectCol == 1){
			for ( var i=1; i < sheetObjects[11].RowCount()+ 1; i++) {
				if (sheetObjects[11].GetCellValue(i, 7) == GetCellValue(Row, 1) && sheetObjects[11].GetCellValue(i, 11) != "" && sheetObjects[11].GetCellValue(i, 11) == 5) {
					sheetObjects[11].SetCellValue(i, 31,"1",0);
				}
			}
			ComOpenWindowCenter("/opuscntr/EES_EQR_1055.do", "EES_EQR_1055"+popupCnt, 880, 670);
			popupCnt++;
			// }
		}
	}
}
/**
 * vvdTotal_OnSearchEnd --> hidden sheet
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function vvdTotal_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		if (sheetObjects[10].RowCount()> 0) {
			parent.ComBtnEnable_frameLayer0("btn_mainretrieve");
		}
	}
}
/**
 * validate input value
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (parent.document.form.week.value == "") {
				ComShowCodeMessage("EQR90195");
				return false;
			}
			var w=parent.document.form.week;
			sVal1=w.value.replace(/\/|\-|\./g, "");
			if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6))) {
				// ComShowCodeMessage("EQR90211", "YYYYWW");
				ComSetFocus(w);
				// w.value = "";
				return false;
			}
		} else {
			// if(sheetObj)
		}
	}
	return true;
}
