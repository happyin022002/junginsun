/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_1048.js
*@FileTitle  : China: Customs Result View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	/* */
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_excel":
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
			case "btn_Close":
				ComClosePopup();
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
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
			with(sheetObj){
				var HeadTitle1="|Seq.|B/L No.|RHQ|POL|POD|SEND DATE|B/L ACK|B/L ACK TEXT|Agency Ack Message|Agency Ack Date|CNTR No.|Customs Ack Message|Customs Ack Date|CNTR ACK|CNTR ACK TEXT|ACK DATE|CNT";

				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq",        	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },


							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"sent_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"bl_ack_type",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"bl_ack_text",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },

							{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"agn_ack_msg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",    ColMerge:1,   SaveName:"agn_ack_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },


							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_ack_msg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_ack_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },

							{Type:"Text",      Hidden:1,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cntr_ack_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cntr_ack_text",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"ack_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,    Align:"Center",  ColMerge:0,   SaveName:"cnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

				InitColumns(cols);
				SetEditable(1);

				SetShowButtonImage(2);
				SetCountPosition(0);
				SetSheetHeight(400);
				ShowSubSum([{StdCol:"bl_no", SumCols:"17", Sort:false, ShowCumulate:false, CaptionCol:2, OtherColText:"bl_no=CNTR: ;rhq=|17|"}]);
			}

			break;
	}
}

/**
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch(sAction) {
		case IBSEARCH:      //retrieve
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			if(sheetObj.id == "sheet1")
			sheetObj.DoSearch("ESM_BKG_1048GS.do", FormQueryString(formObj) );
		break;
		case IBDOWNEXCEL:   //Down Excel
			if (sheetObj.RowCount()== 0 ) {
				ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
				return;
			} else {
				ComOpenWait(true);
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				}
				ComOpenWait(false);
			}
			break;
	}
}

/**
 * handling event after retrieving
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
	var tot_bl=0;
	var pre_bl="";
	var tot_cntr=0;
	var i=0;
	var j=0;
	with(sheetObj) {
		for (var i=HeaderRows(); i<LastRow(); i++) {
			var bl_no = GetCellValue(i, "bl_no");
			if (bl_no != "CNTR: " && pre_bl != bl_no) tot_bl = (tot_bl + 1);
			pre_bl=bl_no;
		}
		document.form.cntr_cnt.value = ComAddComma(GetTotalRows());
		document.form.bl_cnt.value = tot_bl;
		SetSubSumBackColor("#C3C3C3");
		var sRow=FindSubSumRow();
		var arrRow=sRow.split("|");
		for (idx=0; idx<=arrRow.length-1; idx++) {
			SetCellFont("FontBold", arrRow[idx],2,arrRow[idx],3,1);
		}
	}


}

/**
 * onClick event
 * @param SheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(SheetObj, Row, Col){
	 if (SheetObj.ColSaveName(Col) == "bl_ack_text")
	 {
		ComShowMemoPad(SheetObj,Row,8,false,326,100,4000,8);
	 }
	 if (SheetObj.ColSaveName(Col) == "agn_ack_msg")
	 {
		ComShowMemoPad(SheetObj,Row,9,false,326,100,4000,9);
	 }
	 if (SheetObj.ColSaveName(Col) == "cust_ack_msg")
	 {
		ComShowMemoPad(SheetObj,Row,12,false,326,100,4000,12);
	 }
	 if (SheetObj.ColSaveName(Col) == "cntr_ack_text")
	 {
		ComShowMemoPad(SheetObj,Row,12,false,326,100,4000,12);
	 }
}

/**
 * MemoPad2
 */
function ComShowMemoPad2(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax,col2) {
	try{
		if (row == undefined        || row == null)         row=sheetObj.GetSelectRow();
		if (col == undefined        || col == null)         col=sheetObj.GetSelectCol();
		if (bReadOnly == undefined  || bReadOnly == null)   bReadOnly=false;
		if (iWidth == undefined     || iWidth == null)      iWidth=200;
		if (iHeight == undefined    || iHeight == null)     iHeight=200;
		if (iMax == undefined       || iMax == null)        iMax=4000;
		//Validation for the MemoPad
		if (sheetObj.GetCellEditable(row,col)) {
			return ComShowMessage("[ComShowMemoPad] "+ sheetObj.id + "(" + row + "," + col + ") NOT editable");
		}
		//IBSheet Info for MemoPad
		if (!ComIsNumber(col)) col=sheetObj.SaveNameCol(col);
		memoSheet=sheetObj;
		memoRow=row;
		memoCol=col;
		//Creating the MemoPad
		momo_imsi=sheetObj.GetCellText(row,col);
		if (!initMemoPad2(iMax)) return;
		//Calculating the location for Memo DIV
		var iLeft=AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col2) + 2;
		var iTop=AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row)  + 2;
		if (sheetObj.GetCountPosition()!= 0)  iTop += 16; // Change the Height
		//Modifying the location if scrolling is impossible and the current page is in iframe or frame
		if (top.document != document && window.frameElement.scrolling=="no") {
			//Height  exceed
			if (iTop + iHeight  > document.body.clientHeight) {
				iBottom=iTop + sheetObj.GetRowHeight(row);
				if (iBottom > document.body.clientHeight) iBottom=document.body.clientHeight;
				iTop=iBottom-iHeight;
				if (iTop <0) iTop=0
			}
			//Width  exceed
			if (iLeft + iWidth  > document.body.clientWidth)   {
				iLeft=document.body.clientWidth - iWidth;
				if (iLeft<0) iLeft=0;
			}
		}
		var _divMemo=document.getElementById(MEMO_DIV_NAME);
		var _frameDoc=document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor=bReadOnly?"#E8E7EC":"";
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily=sheetObj.GetSheetFontName;
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize=11;
		_frameDoc.getElementById(MEMO_TEXT_NAME).SetSheetHeight(iHeight-25);
		_frameDoc.getElementById(MEMO_TEXT_NAME).value=sheetObj.GetCellText(row,col);
		_frameDoc.getElementById(MEMO_TEXT_NAME).readOnly=bReadOnly;
		_divMemo.style.width=iWidth;
		_divMemo.SetSheetHeight(iHeight);
		_divMemo.style.top=iTop;
		_divMemo.style.left=iLeft;
		_divMemo.style.visibility="visible";
		_divMemo.focus();
		ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
	} catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * Creating the MemoPad<br>
 */
function initMemoPad2(iMax) {
	try {
		//Creating the Memo Div
		if (document.getElementById(MEMO_DIV_NAME) != null) return true;
		//Div for Memo
		var _divMemo=document.createElement("<div id='"+  MEMO_DIV_NAME +"' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
		document.body.insertBefore(_divMemo);
		//iFrame in Div
		var _frameMemo=document.createElement("<IFRAME id='"+MEMO_FRAME_NAME+"' src='' frameborder=0 marginHeight=0 marginWidth=0 width=100% height=100% />");
		_divMemo.appendChild(_frameMemo);
		var _FrameDoc=_frameMemo.contentWindow.document;
		//Div Tag in iFrame
		var _FrameDiv=_FrameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
		_FrameDoc.appendChild(_FrameDiv);
		//Textarea in Div
		var _area=_FrameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME +"' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
		_FrameDiv.appendChild(_area);
		//center Tag in  in Div
		var _centerTag=_FrameDoc.createElement("<center>");
		_FrameDiv.appendChild(_centerTag);
		//Close Button
		var _button2=_FrameDoc.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
		_button2.innerHTML="Close";
		_centerTag.appendChild(_button2);
		//Closing the Memo iFrame automatically
		if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
			// Close the MemoPad like this way because Axon use onmouseup
			window.popupMemoOldEventListener=document.onmouseup;
			if (window.popupMemoOldEventListener != null) {
				//alert("CoObject \n" + window.popupMemoOldEventListener.toString());
				// document.onmouseup value is exist
				document.onmouseup=new Function("window.popupMemoOldEventListener(); ComHideMemoPad();");
			} else {
				// document.onmouseup value is NOT exist
				document.onmouseup=ComHideMemoPad;
			}
			//Close the MemoDiV if focus on the ActiveX
			var objs=document.getElementsByTagName("OBJECT")
			window.popupMemoOldObjEventListener=new Array(objs.length);
			for(var i=0 ; i < objs.length ; i++){
				window.popupMemoOldObjEventListener[i]=objs[i].onfocus;
				if (window.popupMemoOldObjEventListener[i] != null) {
					// document.onmouseup value is exist
					objs[i].onfocus=new Function("window.popupMemoOldObjEventListener["+i+"](); ComHideMemoPad();");
				} else {
					// document.onmouseup value is NOT exist
					objs[i].onfocus=ComHideMemoPad;
				}
			}
		}
	} catch(err) { ComFuncErrMsg(err.message); return false;}
	return true;
}

/**
* Calling this function when the 'Apply' button clicked from MemoPad
*/
function setMemoValue2(sValue,iMax) {
	try {
		if(sValue.length > iMax){
			ComShowMessage("characters long");
			return;
		}else{
			if (memoSheet == null) return;
			if(momo_imsi == "")
			memoSheet.SetCellValue(memoRow, memoCol,sValue,0);
			ComHideMemoPad(true);
		}
   } catch(err) { ComFuncErrMsg(err.message); }
}
