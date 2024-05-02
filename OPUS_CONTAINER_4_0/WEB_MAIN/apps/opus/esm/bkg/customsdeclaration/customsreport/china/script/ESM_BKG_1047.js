/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1047.js
*@FileTitle  : China: Transmit & Receive History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
 */

// global variable
var sheetObjects = new Array();
var sheetCnt = 0;

//Event handler processing by button click event */
document.onclick = processButtonClick;

function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_view":
			doActionIBSheet(sheetObjects[0], formObject, SEARCH11);
			break;
		case "btn_new":
			 //form Initialization
			formObject.vvd_cd.value='';
			formObject.pol_cd.value='';
			formObject.ofc_cd.value='';
			formObject.usr_id.value='';
			formObject.send_indicator.value='%';
			formObject.date_check.checked=true;
			form.start_snd_dt.className="input";
			form.end_snd_dt.className="input";
			form.start_snd_dt2.className="input";
			form.end_snd_dt2.className="input";
			formObject.start_snd_dt.value=ComGetNowInfo('ymd','-');
			formObject.end_snd_dt.value=ComGetNowInfo('ymd','-');
			formObject.start_snd_dt2.value="00:00";
			formObject.end_snd_dt2.value="23:59";
			break;
		case "btn_excel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
			break;
		case "btns_calendar": //calendar button
			// don't use before search
			var cal=new ComCalendarFromTo();
			cal.select(formObject.start_snd_dt,formObject.end_snd_dt, 'yyyy-MM-dd');
			break;
		}
	}
	catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag
 */
function loadPage() {

	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}



/**
 * registering initial event
 */
function initControl() {
	DATE_SEPARATOR = "-";
	var formObject = document.form;

	axon_event.addListenerForm  ('blur', 'obj_deactivate', formObject); //- focus in
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); //- focus out

	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListener('click', 'chkClick', 'form');
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	formObject.vvd_cd.focus();
}

/**
 * When you enter search conditions, handling
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = ComGetEvent("name");
	var srcMaxLength = ComGetEvent("maxlength");
	var srcValue = ComGetEvent("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2" && (srcName == "pod_cd")){
		formObject.ofc_cd.focus();
	}
	if (ComChkLen(srcValue, srcMaxLength) == "2" && (srcName != "pod_cd")) {
		ComSetNextFocus();
	}
}

/**
 *  Validation of HTML Control onblur Event <br>
 **/
function obj_activate(){
	// Input Validation to check
	switch(ComGetEvent("name")){
		case "start_snd_dt":
			ComClearSeparator(ComGetEvent());
			break;
		case "end_snd_dt":
			ComClearSeparator(ComGetEvent());
			break;
		default:
			break;
	}
}

/**
 *  Validation of HTML Control onblur Event <br>
 **/
function obj_deactivate(){
	//input Validation check
	switch(ComGetEvent("name")){
		case "start_snd_dt":
			ComAddSeparator(ComGetEvent());
			break;
		case "end_snd_dt":
			ComAddSeparator(ComGetEvent());
			break;
		default:
			break;
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
			case "sheet1":      //sheet1 init
			with (sheetObj) {
				var HeadTitle1="|Seq.|RHQ|Office|VVD|POL|POD|MSG|MSG Type|Send Date|ACK MESSAGE|ACK MESSAGE|ACK DATE|USER ID||EDI REF";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq",                Edit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",         Edit:0 },
					{Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",             Edit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             Edit:0 },
					{Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pod_cd",             Edit:0 },
					{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"send_indicator",     Edit:0 },
					{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"send_indicator_nm",  Edit:0 },
					{Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",             Edit:0 },
					{Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"ack_cont",           Edit:0 },
					{Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ack_cont2",          Edit:1 },
					{Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"ack_dt",             Edit:0 },
					{Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"snd_usr_id",         Edit:0 },
					{Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ack_tp",             Edit:0 },
					{Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"edi_ref_id",         Edit:0 } ];
				InitColumns(cols);
				SetSheetHeight(385);
				SetEditable(1);

				SetCountPosition(0);
				SetWaitImageVisible(0);
				SetShowButtonImage(2);
				SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		   }
		   break;
	}
}

/**
 * handling sheet process
 */
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	//sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case SEARCH11: // retrieve
			var param_vvd_cd = sheetObj.GetCellValue(sheetObj.GetSelectRow(),"vvd_cd") == -1 ? "" : sheetObj.GetCellValue(sheetObj.GetSelectRow(),"vvd_cd");
			var param_pod_cd = sheetObj.GetCellValue(sheetObj.GetSelectRow(),"pod_cd") == -1 ? "" : sheetObj.GetCellValue(sheetObj.GetSelectRow(),"pod_cd");
			var param_pol_cd = sheetObj.GetCellValue(sheetObj.GetSelectRow(),"pol_cd") == -1 ? "" : sheetObj.GetCellValue(sheetObj.GetSelectRow(),"pol_cd");
			var param_edi_ref_id = sheetObj.GetCellValue(sheetObj.GetSelectRow(),"edi_ref_id") == -1 ? "" : sheetObj.GetCellValue(sheetObj.GetSelectRow(),"edi_ref_id");
			var sUrl="ESM_BKG_1048.do?edi_ref_id="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),"edi_ref_id")
					+ "&vvd_cd="+ param_vvd_cd
					+ "&pod_cd="+ param_pod_cd
					+ "&pol_cd="+ param_pol_cd
					+ "&edi_ref_id="+ param_edi_ref_id;
			ComOpenWindowCenter(sUrl, "ESM_BKG_1048", 1200, 650, false);
			break;

		case IBSEARCH: // retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				if ( formObj.date_check.checked )
					formObj.date_check.value="Y";
				else
					formObj.date_check.value="";
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_1047GS.do", FormQueryString(formObj), {Sync:2} );
				ComOpenWait(false);
			}
			break;

		case IBDOWNEXCEL: 	//Down Excel
			if (sheetObj.RowCount()== 0 ) {
				ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
				return;
			} else {
				ComOpenWait(true);
				var viewCols = makeHiddenSkipCol(sheetObj).replace("|" + sheetObj.SaveNameCol("ack_cont2"), "");
				sheetObj.Down2Excel({DownCols:viewCols, SheetDesign:1, Merge:1});
				ComOpenWait(false);
			}
			break;

		case IBSEARCHAPPEND:  // pasing retrieve
			if (!validateForm(sheetObj,formObj,IBSEARCH)) return false;
			if ( formObj.date_check.checked )
				formObj.date_check.value="Y";
			else
				formObj.date_check.value="";
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			if(PageNo >= 1){
				sheetObj.DoSearch("ESM_BKG_1047GS.do", CondParam+"&"+ "iPage=" + PageNo,{Append:true} , {Sync:2});
			}else{
				sheetObj.DoSearch("ESM_BKG_1047GS.do", FormQueryString(formObj)+"&"+ "iPage=1",{Append:false}, {Sync:2} );
			}
			ComOpenWait(false);
			break;
	}
}

/**
 * When contact is made with a vertical scroll bar on the bottom of the events that occur Catch
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // retrieve
		if ( !formObj.date_check.checked && formObj.vvd_cd.value=="" && formObj.pol_cd.value == "" && formObj.usr_id.value=="" && formObj.ofc_cd.value=="")
		{
				ComShowCodeMessage('BKG06011');
				formObj.start_snd_dt.focus();
				return false;
		}
		if ( formObj.date_check.checked )
		{
			if ( formObj.start_snd_dt.value == "" )
			{
				ComShowCodeMessage('BKG00528');
				formObj.start_snd_dt.focus();
				return false;
			}
			if ( formObj.start_snd_dt2.value == "" || formObj.start_snd_dt2.value.length != "5" )
			{
				ComShowCodeMessage('BKG00528');
				formObj.start_snd_dt2.focus();
				return false;
			}
			if ( formObj.end_snd_dt.value == "" )
			{
				ComShowCodeMessage('BKG00528');
				formObj.end_snd_dt.focus();
				return false;
			}
			if ( formObj.end_snd_dt2.value == "" || formObj.end_snd_dt2.value.length != "5" )
			{
				ComShowCodeMessage('BKG00528');
				formObj.end_snd_dt2.focus();
				return false;
			}
			if ( formObj.start_snd_dt2.value.substring(0, 1)==":" || formObj.start_snd_dt2.value.substring(1, 2)==":" )
			{
				alert("Invalid Hours format, Please input the number between 0 and 23.");
				formObj.start_snd_dt2.focus();
				return false;
			} else {
				var hh=parseInt(eval(formObj.start_snd_dt2.value.substring(0, 2)));
				if (!(0 <= hh && hh <= 23)) {
					alert("Invalid Hours format, Please input the number between 0 and 23.");
					formObj.start_snd_dt2.focus();
					return false;
				}
			}
			if ( formObj.start_snd_dt2.value.substring(3, 4)==":" || formObj.start_snd_dt2.value.substring(4, 5)==":" )
			{
				alert("Invalid Minutes format, Please input the number between 0 and 59.");
				formObj.start_snd_dt2.focus();
				return false;
			} else {
				var mi=parseInt(eval(formObj.start_snd_dt2.value.substring(3, 5)));
				if (!(0 <= mi && mi <= 59)) {
					alert("Invalid Minutes format, Please input the number between 0 and 59.");
					formObj.start_snd_dt2.focus();
					return false;
				}
			}
			if ( formObj.end_snd_dt2.value.substring(0, 1)==":" || formObj.end_snd_dt2.value.substring(1, 2)==":" )
			{
				alert("Invalid Hours format, Please input the number between 0 and 23.");
				formObj.start_snd_dt2.focus();
				return false;
			} else {
				var hh2=parseInt(eval(formObj.end_snd_dt2.value.substring(0, 2)));
				if (!(0 <= hh2 && hh2 <= 23)) {
					alert("Invalid Hours format, Please input the number between 0 and 23.");
					formObj.end_snd_dt2.focus();
					return false;
				}
			}
			if ( formObj.end_snd_dt2.value.substring(3, 4)==":" || formObj.end_snd_dt2.value.substring(4, 5)==":" )
			{
				alert("Invalid Minutes format, Please input the number between 0 and 59.");
				formObj.start_snd_dt2.focus();
				return false;
			} else {
				var mi2=parseInt(eval(formObj.end_snd_dt2.value.substring(3, 5)));
				if (!(0 <= mi2 && mi2 <= 59)) {
					alert("Invalid Minutes format, Please input the number between 0 and 59.");
					formObj.end_snd_dt2.focus();
					return false;
				}
			}
		}
		if (!ComChkValid(formObj))
		{
			formObj.start_snd_dt.focus();
			return false;
		}
		return true;
		break;
	}

}

/**
 * When seleted checkBox, Form control active handling
 */
function chkClick(){
	if(ComGetEvent("name") == "date_check"){
		var sr=ComGetEvent();
		var formObj = document.form;

		if(sr.checked){
			document.getElementById("start_snd_dt").disabled=false;
			document.getElementById("end_snd_dt").disabled=false;
			document.getElementById("start_snd_dt2").disabled=false;
			document.getElementById("end_snd_dt2").disabled=false;


		}else{
			document.getElementById("start_snd_dt").disabled=true;
			document.getElementById("end_snd_dt").disabled=true;
			document.getElementById("start_snd_dt2").disabled=true;
			document.getElementById("end_snd_dt2").disabled=true;
		}
	}

}

/**
 * sheet DblClick popup open
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col){
	 doActionIBSheet(sheetObjects[0], document.form, SEARCH11);
}

/**
 * when sheet click, memopad open
 */
function sheet1_OnPopupClick(SheetObj, Row, Col){
	 if (SheetObj.ColSaveName(Col) == "ack_cont2")
	 {
		ComShowMemoPad(SheetObj,Row,10,true,370,120,4000,10);
	 }
}


/**
 * when letter of paticualr cell in IBSheet fell one line, call MemoPad. <br>
 * <br><b>Example :</b>
 * <pre>
 *    function sheet1_OnClick(sheetObj, Row, Col, Value) {
 *        //desc cell onClick, MemoPad display.(MemoPad editable)
 *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj);
 *    }
 *    function sheet2_OnClick(sheetObj, Row, Col, Value) {
 *        //desc cell onClick, MemoPad display.(MemoPad diseditable)
 *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj, Row, Col, true);
 *    }
 * </pre>
 * @param {ibsheet}     sheetObj
 * @param {int}         row
 * @param {int}         col
 * * @param {int}       col2
 * @param {bool}        bReadOnly
 * @param {int}         iWidth
 * @param {int}         iHeight
 * @see #ComHideMemoPad
 * @return <br>
 */
function ComShowMemoPad2(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax,col2) {
	try{
		 // set default value
		if (row == undefined 		|| row == null) 		row=sheetObj.GetSelectRow();
		if (col == undefined 		|| col == null) 		col=sheetObj.GetSelectCol();
		if (bReadOnly == undefined  || bReadOnly == null) 	bReadOnly=false;
		if (iWidth == undefined 	|| iWidth == null) 		iWidth=200;
		if (iHeight == undefined 	|| iHeight == null) 	iHeight=200;
		if (iMax == undefined 	    || iMax == null) 	    iMax=4000;
		// IBSheet info Validation check
		if (sheetObj.GetCellEditable(row,col)) {
			return ComShowMessage("[ComShowMemoPad] "+ sheetObj.id + "(" + row + "," + col + ") 셀은 편집불가능이어야 합니다.");
		}
		//set IBSheetinfo
		if (!ComIsNumber(col)) col=sheetObj.SaveNameCol(col);
		memoSheet=sheetObj;
		memoRow=row;
		memoCol=col;
		//create MemoPad
		momo_imsi=sheetObj.GetCellText(row,col);
		if (!initMemoPad2(iMax)) return;

		var iLeft=AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col2) + 2;
		var iTop=AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row)  + 2;
		if (sheetObj.GetCountPosition()!= 0)  iTop += 16;

		if (top.document != document && window.frameElement.scrolling=="no") {
			//Height over balance
			if (iTop + iHeight  > document.body.clientHeight) {
				iBottom=iTop + sheetObj.GetRowHeight(row);
				if (iBottom > document.body.clientHeight) iBottom=document.body.clientHeight;
				iTop=iBottom-iHeight;
				if (iTop <0) iTop=0
			}
			//width over balance
			if (iLeft + iWidth  > document.body.clientWidth)   {
				iLeft=document.body.clientWidth - iWidth;
				if (iLeft<0) iLeft=0;
			}
		}
		var _divMemo=document.getElementById(MEMO_DIV_NAME);
		var _frameDoc=document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
		//_frameDoc.getElementById("btn_apply").style.display = (bReadOnly)?"none":"inline";
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
	}
	catch(err) { ComFuncErrMsg(err.message); }

}
/**
 *DIV inside the iFrame creates for MemoPad, iFrame is generated in a Textarea with the button. <br>
 */
function initMemoPad2(iMax) {
	try{
		if (document.getElementById(MEMO_DIV_NAME) != null) return true;

		var _divMemo=document.createElement("<div id='"+  MEMO_DIV_NAME +"' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
		document.body.insertBefore(_divMemo);

		var _frameMemo=document.createElement("<IFRAME id='"+MEMO_FRAME_NAME+"' src='' frameborder=0 marginHeight=0 marginWidth=0 width=100% height=100% />");
		_divMemo.appendChild(_frameMemo);
		var _FrameDoc=_frameMemo.contentWindow.document;

		var _FrameDiv=_FrameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
		_FrameDoc.appendChild(_FrameDiv);

		var _area=_FrameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME +"' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
		_FrameDiv.appendChild(_area);

		var _centerTag=_FrameDoc.createElement("<center>");
		_FrameDiv.appendChild(_centerTag);

		var _button2=_FrameDoc.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
		_button2.innerHTML="Close";
		_centerTag.appendChild(_button2);

		if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {

			window.popupMemoOldEventListener=document.onmouseup;
			if (window.popupMemoOldEventListener != null) {
				document.onmouseup=new Function("window.popupMemoOldEventListener(); ComHideMemoPad();");
			} else {
				document.onmouseup=ComHideMemoPad;
			}

			var objs=document.getElementsByTagName("OBJECT")
			window.popupMemoOldObjEventListener=new Array(objs.length);
			for(var i=0 ; i < objs.length ; i++){
				window.popupMemoOldObjEventListener[i]=objs[i].onfocus;
				if (window.popupMemoOldObjEventListener[i] != null) {
					objs[i].onfocus=new Function("window.popupMemoOldObjEventListener["+i+"](); ComHideMemoPad();");
				} else {
					objs[i].onfocus=ComHideMemoPad;
				}
			}
		}
	}
	catch(err) { ComFuncErrMsg(err.message); return false;}
	return true;
}
/**
* Apply button is pressed in MemoPad call this function, and, MemoPad IBSheet the value of a particular cell is set to. <br>
*/
function setMemoValue2(sValue,iMax) {
	try {
		if(sValue.length > iMax){
			ComShowMessage("characters long");
			return;
		}else{
			if (memoSheet == null) return;
			if(momo_imsi == "")
				memoSheet.SetCellValue(memoRow, "ack_cont",sValue,0);
			memoSheet.SetCellValue(memoRow, memoCol,sValue,0);
			ComHideMemoPad(true);
		}
   } catch(err) { ComFuncErrMsg(err.message); }
}
