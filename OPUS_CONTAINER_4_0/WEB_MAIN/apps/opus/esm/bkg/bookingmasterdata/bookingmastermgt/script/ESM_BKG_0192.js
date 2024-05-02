/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0192.js
*@FileTitle  : B/L CUSTOMER
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
==================================================================*/
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var prefix="sheet1_";//IBSheet divider
var prefix2="sheet2_";//IBSheet divider
var rowsPerPage=50;
/*********************** EDTITABLE MULIT COMBO START ********************/
var comboCnt=0;
var comboObjects=new Array();
/*********************** EDTITABLE MULIT COMBO END ********************/
var isValidateFail=false;
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (var i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	if (document.form.cust_cnt_cd.value != "") {
		//add the criteria to search not to show alert message first time
		if (document.form.cust_seq.value != "" || document.form.cust_nm.value != "" || document.form.cust_addr.value != ""){
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	document.form.cust_cnt_cd.focus();
}
function initControl() {
	var formObject=document.form;
	//axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- keyboard
	axon_event.addListenerForm('blur', 'bkg_deactivate', formObject); //- out of focus     
	//axon_event.addListenerFormat('blur', 'bkg_activate', formObject); //- focus in
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
/*********************** KEY EVENT START ********************/
//function bkg_keypress() {
//	switch (ComGetEvent().dataformat) {
//	case "engup":  //alphabet upper case
//		ComKeyOnlyAlphabet('upper');
//		break;
//	case "engupnum":  //number+"alphabet upper case"
//		ComKeyOnlyAlphabet('uppernum');
//		break;
//	case "custname":  //number+"alphabet upper case"
//		ComKeyOnlyAlphabet('uppernum', '32');
//		break;
//	case "engdnnum":  //number+"alphabet upper case"
//		ComKeyOnlyAlphabet('lowernum');
//		break;
//	case "num":  //number 
//		ComKeyOnlyNumber(ComGetEvent());
//		break;
//	case "address":  //number+"alphabet upper case"
//		ComKeyOnlyAlphabet('uppernum', '40|41|46|44|32|42|38|35|45');
//		break;
//	case "num":
//	case "zipcode":  //number 
//		ComKeyOnlyAlphabet('uppernum', '45|32');
//		break;
//	default:
//	}
//}
/**
 * controlling onBlur of HTML Control
 **/
function bkg_deactivate() {
	var formObj=document.form;
	switch (ComGetEvent("name")) {
	case "from_dt":
		ComAddSeparator(ComGetEvent());
		break;
	case "to_dt":
		ComAddSeparator(ComGetEvent());
		break;

	}
}
/**
 * checking Validation on event of onFocus. <br>
 **/
function bkg_activate() {
	var formObj=document.form;
	switch (ComGetEvent("name")) {
	case "from_dt":
		ComClearSeparator(ComGetEvent());
		break;
	case "to_dt":
		ComClearSeparator(ComGetEvent());
		break;
	default:
		break;
	}
}
/*********************** KEY EVENT END ********************/
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var comboObject1=comboObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_RowAdd":
				doActionIBSheet(sheetObject2, formObject, IBINSERT);
				break;
			case "btn_RowDelete":
				if (0==sheetObject2.CheckedRows(prefix2 + "del_chk")) {
					ComShowCodeMessage("COM12189");
					return;
				}
				var chkRows=sheetObject2.FindCheckedRow(prefix2 + "del_chk").split("|");
				var chkRow;
				for (var i=chkRows.length-1; i>=0; i--) {
					chkRow=parseInt(chkRows[i]);
					sheetObject2.SetRowHidden(chkRows[i],1);
					sheetObject2.SetRowStatus(chkRows[i],"D");
					sheetObject2.GetCellValue(chkRows[i] < (sheetObject2.HeaderRows()+sheetObject2.SetTotalRows) ? parseInt(chkRows[i])+1 : sheetObject2.LastRow()-1, prefix2 + "del_chk");
				}
				break;
			case "btn_Copy":
				if (0==sheetObject1.RowCount()|| !isUsable(sheetObject1)) return;
				setCopyData();
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject2, formObject, IBSAVE);
				break;
			case "btn_Select":
				custPopupOK();
				break;
			case "btn_Close":
				if (formObject.cust_val.value == "Y") {
					var retObj1 = null;
					var retObj2 = null;
					callbackMethod(retObj1, retObj2, "Y");
				}
				ComClosePopup(); 
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
// handling of Sheet 
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.curr_page.value=1;// to initialize PageNo
		pagedMaxCnt=sheetObj.HeaderRows();//initializing variable which is for changing color of using flag is N
		formObj.f_cmd.value=SEARCH;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0192GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		sheetObjects[1].RemoveAll();
		if (sheetObjects[0].RowCount()> 0) {
			doActionIBSheet(sheetObjects[1], formObj, SEARCH01, sheetObjects[0].FindCheckedRow(prefix + "radio").split("|")[0], 1);
		}
		break;
	case SEARCH01:
		formObj.f_cmd.value=SEARCH01;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0192GS.do", "cust_cnt_cd="+ sheetObjects[0].GetCellValue(Row, prefix + "cust_cnt_cd")
				+ "&cust_seq="+ sheetObjects[0].GetCellValue(Row, prefix + "cust_seq")+ "&f_cmd=" + SEARCH01 + "&" + ComGetPrefixParam(prefix2));
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		break;
	case IBSEARCHAPPEND: 
		formObj.f_cmd.value=SEARCH;
		formObj.curr_page.value=PageNo;
		selectVal=FormQueryString(formObj);
		sheetObj.DoSearch("ESM_BKG_0192GS.do", selectVal + "&" + ComGetPrefixParam(prefix), "iPage=" + PageNo, true);
		break;
	case IBINSERT: 
		var fromSheet=sheetObjects[0];
		var chkRow=fromSheet.FindCheckedRow(prefix + "radio").split("|")[0];
		if(chkRow==""){
			ComShowCodeMessage("BKG00012");
			break;
		}
		var toSheet=sheetObjects[1];
		var row=toSheet.DataInsert(-1);
		toSheet.SetCellValue(row, prefix2 + "cust_cnt_cd",fromSheet.GetCellValue(chkRow, prefix + "cust_cnt_cd"));
		toSheet.SetCellValue(row, prefix2 + "cust_seq",fromSheet.GetCellValue(chkRow, prefix + "cust_seq"));
		break;
	case IBSAVE: 
		if (!sheetObj.IsDataModified()&& sParam == "") return;
		isValidateFail = false;
		formObj.f_cmd.value=MULTI;

		var v_cust_nm = "";
		var v_cust_addr = "";
		//특수문자 제거 로직
		for(var i=2; i< sheetObj.RowCount()+2; i++){
			v_cust_nm	= chekcSpecialValue(sheetObj.GetCellValue(i, prefix2+"cust_nm"));
			v_cust_addr	= chekcSpecialValue(sheetObj.GetCellValue(i, prefix2+"cust_addr"));
			
			sheetObj.SetCellValue(i, prefix2+"cust_nm", v_cust_nm);
			sheetObj.SetCellValue(i, prefix2+"cust_addr", v_cust_addr);
		}
		
		var sParam=sheetObj.GetSaveString() + "&" + FormQueryString(formObj);
		var sXml=sheetObj.GetSaveData("ESM_BKG_0192GS.do", sParam);
		if (!isValidateFail) {
			sheetObj.LoadSaveData(sXml,{Sync:1});
		}
		break;
	case IBDOWNEXCEL: 
		if(sheetObj.RowCount() < 1){//no data
			ComShowCodeMessage("COM132501");
		}else{
			sheetObj.Down2Excel({ HiddenColumn:1});
		}
		break;
	}
}
/**
 *  Event which can be called when you move the scroll bar by last of list<br>
 */
function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheet, document.form, IBSEARCHAPPEND, true, true, PageNo);
}
/*
 *  variable which is to handle as the number of searching result after handling paging 
 * initial value = the number of sheet header
 */
var pagedMaxCnt=2;
/**
 * handling event >>> changing color of font
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var redColor="#FF0000";
		for ( var i=pagedMaxCnt; i <= sheetObj.LastRow(); i++) {
			if (i == HeaderRows()) {
				SetCellValue(i, prefix + "radio",1);
				var formObject=document.form;
			}
			setCelColor(GetCellValue(i, prefix + "delt_flg"), sheetObj, i, prefix + "delt_flg", redColor);
		}
	}
	pagedMaxCnt=sheetObj.LastRow();
}
function sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {
	if (!isUsable(sheetObj)) return;
	sheetObjects[0].SetCellValue(rowIdx, prefix + "radio",1);
	doActionIBSheet(sheetObjects[1], document.form, SEARCH01, rowIdx, colIdx)
}
function sheet1_OnClick(sheetObj, rowIdx, colIdx) {
	with (sheetObj) {
		if (colIdx == SaveNameCol(prefix + "radio")) {
			doActionIBSheet(sheetObjects[1], document.form, SEARCH01, rowIdx, colIdx)
		}
	}
}
function setCopyData() {
	var fromSheet=sheetObjects[0];
	var toSheet=sheetObjects[1];
	var row=toSheet.DataInsert(-1);
	var chkRow=fromSheet.FindCheckedRow(prefix + "radio").split("|")[0];
	toSheet.SetCellValue(row, prefix2 + "cust_cnt_cd",fromSheet.GetCellValue(chkRow, prefix + "cust_cnt_cd"));
	toSheet.SetCellValue(row, prefix2 + "cust_seq",fromSheet.GetCellValue(chkRow, prefix + "cust_seq"));
	toSheet.SetCellValue(row, prefix2 + "cust_nm",fromSheet.GetCellValue(chkRow, prefix + "cust_nm"));
	toSheet.SetCellValue(row, prefix2 + "cust_addr",fromSheet.GetCellValue(chkRow, prefix + "cust_addr"));
	toSheet.SetCellValue(row, prefix2 + "cust_cty_nm",fromSheet.GetCellValue(chkRow, prefix + "cty_nm"));
	toSheet.SetCellValue(row, prefix2 + "cust_ste_cd",fromSheet.GetCellValue(chkRow, prefix + "ste_cd"));
	toSheet.SetCellValue(row, prefix2 + "cust_zip_cd",fromSheet.GetCellValue(chkRow, prefix + "zip_cd"));
	toSheet.SetCellValue(row, prefix2 + "cstms_decl_cnt_cd", fromSheet.GetCellValue(chkRow, prefix + "cnt_cd"));
}
/**
 * Event which can be called when you double click at data cell 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnClick(sheetObj, Row, Col) {
	var colSaveName=sheetObj.ColSaveName(Col);
	switch (colSaveName) {
	case prefix2 + "cust_nm":
		ComShowMemoPad2(sheetObj, Row, Col, false, 270, 200, 2, 35);
		break;
	case prefix2 + "cust_addr":
		ComShowMemoPad2(sheetObj, Row, Col, false, 270, 200, 3, 35);
		break;
	} // end switch()
}
var memoSheet=null, memoRow, memoCol;

/**
 * prohibiting to use the common ComShowMemoPad because of restriction at the number of character<br>
 * creating and using the ComShowMemoPad2<br>
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param bReadOnly
 * @param iWidth
 * @param iHeight
 * @param iMax
 * @return
 */
function ComShowMemoPad2(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax) {
	try {
		// 함수의 인자 default 값 설정하기
		if (row == undefined || row == null)
			row = sheetObj.GetSelectRow();
		if (col == undefined || col == null)
			col = sheetObj.GetSelectCol();
		if (bReadOnly == undefined || bReadOnly == null)
			bReadOnly = false;
		if (iWidth == undefined || iWidth == null)
			iWidth = 200;
		if (iHeight == undefined || iHeight == null)
			iHeight = 200;
		if (iMax == undefined || iMax == null)
			iMax = 4000;

		// 메모를 위한 IBSheet 정보의 Validation 확인하기
		if (sheetObj.GetCellEditable(row, col)) {
			return ComShowMessage("[ComShowMemoPad] " + sheetObj.id + "(" + row
					+ "," + col + ") 셀은 편집불가능이어야 합니다.");
		}
		// 메모를 위한 IBSheet 정보 받기
		if (!ComIsNumber(col))
			col = sheetObj.SaveNameCol(col);
		memoSheet = sheetObj;
		memoRow = row;
		memoCol = col;

		// 메모메드 만들기
		if (!initMemoPad2(iMax)) return;

		// 메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft,
		// AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
		var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col);
		var iTop = AnchorPosition_getPageOffsetTop(sheetObj)	+ sheetObj.RowTop(row);

		// 현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
		if (top.document != document && window.frameElement.scrolling == "no") {
			// 높이초과
			if (iTop + iHeight > document.body.clientHeight) {
				iBottom = iTop + sheetObj.GetRowHeight(row);
				if (iBottom > document.body.clientHeight)
					iBottom = document.body.clientHeight;
				iTop = iBottom - iHeight;
				if (iTop < 0)
					iTop = 0
			}

			// 넓이초과
			if (iLeft + iWidth > document.body.clientWidth) {
				iLeft = document.body.clientWidth - iWidth;
				if (iLeft < 0)
					iLeft = 0;
			}
		}

		var _divMemo = document.getElementById(MEMO_DIV_NAME);
		var _frameDoc = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;

		_frameDoc.getElementById("btn_apply").style.display = (bReadOnly) ? "none": "inline";
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor = bReadOnly ? "#E8E7EC": "";
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily = sheetObj.GetSheetFontName();
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily="Courier New";
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize = 11;
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight - 50 +"px";
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.width = iWidth +"px";
		_frameDoc.getElementById(MEMO_TEXT_NAME).value = sheetObj.GetCellText(row, col);
		_frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = bReadOnly;

	
//		_divMemo.style.width=iWidth;
//		_divMemo.SetSheetHeight(iHeight);
//		_divMemo.style.top=iTop;
//		_divMemo.style.left=iLeft;
//		_divMemo.style.visibility="visible";
//		_divMemo.focus();
//		ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));		
//		
		
		_divMemo.style.width = (iWidth+30)+ "px";
		_divMemo.style.height = (iHeight)+"px";
		_divMemo.style.top = iTop + "px";
		_divMemo.style.left = iLeft + "px";
		_divMemo.style.visibility = "visible";
		_divMemo.focus();
		
		ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}


/**
 * MemoPad를 위한 DIV안에 iFrame을 만들고, iFrame안에 Textarea와 버튼을 생성한다. <br>
 */
function initMemoPad2(iMax) {
	try {
		// 메모용 Div가 없으면 생성한다.
		if (document.getElementById(MEMO_DIV_NAME) != null)
			return true;

		// 메모용 Div 만들기
        var _divMemo=document.createElement("div");
        _divMemo.id=MEMO_DIV_NAME;
        _divMemo.style.position = "absolute";
        _divMemo.style.overflow = "hidden";
        _divMemo.style.width = "200px";
        _divMemo.style.height = "200px";
        _divMemo.style.zIndex = "1000";
        _divMemo.style.visibility="hidden";
        
        
        document.body.appendChild(_divMemo);

        //var _divMemo = document
		//		.createElement("<div id='"
		//				+ MEMO_DIV_NAME
		//				+ "' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
		//document.body.insertBefore(_divMemo);

		// 메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
        _divMemo.innerHTML = "<iframe id='"+ MEMO_FRAME_NAME +"' style='width:100%;height:100%'></iframe>";
        var _frameMemo = document.getElementById(MEMO_FRAME_NAME);
		//var _frameMemo = document
		//		.createElement("<IFRAME id='"
		//				+ MEMO_FRAME_NAME
		//				+ "' frameborder='0' marginHeight='0' marginWidth='0' width='100%' height='100%' />");
		//_divMemo.appendChild(_frameMemo);

		var _FrameDoc = _frameMemo.contentWindow.document;

		// iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
        var _FrameDiv=_FrameDoc.createElement("div");
        _FrameDiv.style.position = "absolute";
        _FrameDiv.style.overflow = "hidden";
        _FrameDiv.style.backgroundColor = "#E6EFF6";
        _FrameDiv.style.width = "100%";
        _FrameDiv.style.height = "100%";
        if (_FrameDoc.body){
            _FrameDoc.body.appendChild(_FrameDiv);
        }else {
            _FrameDoc.appendChild(_FrameDiv);
        }
        
		//var _FrameDiv = _FrameDoc
		//		.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
		//_FrameDoc.appendChild(_FrameDiv);

		// Div안에 Textarea 만들기
        //var sHtml = "<link href=\"style/css/theme_default.css\" rel=\"stylesheet\" type=\"text/css\">";
//      var sHtml = "<textarea id='"+ MEMO_TEXT_NAME+ "' onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:#7F9DB9 1px solid; font-family:Courier New; font-size:12px; color:#4f4f4f; height:175px; width:100%' rows='10' cols='6'></textarea>"
        var special_chars = " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?";
        var sHtml = "<textarea id='"+ MEMO_TEXT_NAME+ "'" 
                  + " onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);'"
                  + " style='border:#7F9DB9 1px solid; font-family:Courier New; font-size:12px; color:#4f4f4f; height:175px; width:100%'"
                  + " rows='10'"
                  + " cols='6'"
                  + " dataformat='engup'"
                  + " otherchar='" + special_chars+ "'"
                  + " onpaste='parent.mousePaste(this)'"
                  + "></textarea>"
                  + "\n<button id='btn_apply' class='btn_etc' onclick='parent.setMemoValue2(document.getElementById(\""+ MEMO_TEXT_NAME + "\").value," + iMax + ");'>Apply</button>"
				  + "\n<button id='btn_close' class='btn_etc' onclick='parent.ComHideMemoPad(true)'>Close</button>"
				  + "</body>";
        _FrameDiv.innerHTML=sHtml;
		//making Textarea in DIV
//		var _area=_FrameDoc.createElement("textarea");
//		_area.setAttribute('id',MEMO_TEXT_NAME);
//		_area.setAttribute('style','border:#7F9DB9 1px solid; font-family:Courier New; font-size:12px; color:#4f4f4f; height:175px; width:100%');
//		_FrameDiv.appendChild(_area);
        
        
        //var _area = _FrameDoc
		//		.createElement("<textarea id='"
		//				+ MEMO_TEXT_NAME
		//				+ "' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
		//_FrameDiv.appendChild(_area);

        /*
		// Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
		var _centerTag = _FrameDoc.createElement("<center>");
		_FrameDiv.appendChild(_centerTag);

		// Apply 버튼 만들기
		var _button1 = _FrameDoc
				.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemoValue2(document.getElementById(\""
						+ MEMO_TEXT_NAME + "\").value," + iMax + ");'/>");
		_button1.innerHTML = "Apply";
		_centerTag.appendChild(_button1);

		// Close 버튼 만들기
		var _button2 = _FrameDoc
				.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
		_button2.innerHTML = "Close";
		_centerTag.appendChild(_button2);
		*/

		// 메모용 iFrame 자동 닫기 처리
		if (document.onmouseup == null
				|| document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
			// Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
			window.popupMemoOldEventListener = document.onmouseup;
			if (window.popupMemoOldEventListener != null) {
				// alert("CoObject \n" +
				// window.popupMemoOldEventListener.toString());
				// 기존에 document.onmouseup에 정의된 함수가 있는 경우
				document.onmouseup = new Function(
						"window.popupMemoOldEventListener(); ComHideMemoPad();");
			} else {
				// 기존에 document.onmouseup에 정의된 함수가 없는 경우
				document.onmouseup = ComHideMemoPad;
			}

			/*
			// ActiveX에 포커스가 갔을때 메모DiV 닫기
			var objs = document.getElementsByTagName("OBJECT")
			window.popupMemoOldObjEventListener = new Array(objs.length);
			for ( var i = 0; i < objs.length; i++) {
				window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
				if (window.popupMemoOldObjEventListener[i] != null) {
					// 기존에 document.onmouseup에 정의된 함수가 있는 경우
					objs[i].onfocus = new Function(
							"window.popupMemoOldObjEventListener[" + i
									+ "](); ComHideMemoPad();");
				} else {
					// 기존에 document.onmouseup에 정의된 함수가 없는 경우
					objs[i].onfocus = ComHideMemoPad;
				}
			}*/
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
		return false;
	}
	return true;
}




function setMemoValue2(sValue, iMax) {
	try {
		if (!validateCols2(sValue)) {
			return;
		} else {
			ComHideMemoPad(true);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/*
 *  checking validation of the number of row and TextArea character
 * @param rows : the number of Max row
 * @param cols : Max number of character in one row
 * @param obj : Textarea Object
 * @author 
 * @version 2009.09.01
 */
function validateCols2(str) {
	var displayText;
	var iCols=35;
	var iRows=2;
	if (sheetObjects[1].ColSaveName(sheetObjects[1].GetSelectCol()) == "sheet2_cust_addr")
		iRows=3;
	var parseCols=parseInt(iCols);
	
	var rowArr=str.split("\n");
	for ( var i=0; i < rowArr.length; i++) {
		if (countLineBreaks(rowArr[i]) > 0) {
			if (rowArr[i].length > parseCols + 1) {
				var loopCnt;
				if (rowArr[i].length % parseCols > 0) {
					loopCnt=rowArr[i].length / parseCols + 1;
				} else {
					loopCnt=rowArr[i].length / parseCols;
				}
				for ( var j=0; j < Math.floor(loopCnt); j++) {
					if (i < 1) {
						if (j < 1) {
							displayText=rowArr[i].substring(0, parseCols * (j + 1));
						} else {
							displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
//							displayText=displayText	+ rowArr[i].substring(parseCols * j,parseCols * (j + 1));
						}
					} else {
						displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
//						displayText=displayText	+ rowArr[i].substring(parseCols * j, parseCols * (j + 1));
					}
				}
				if (countLineBreaks(displayText) > 0) {
					displayText=displayText.substring(0,displayText.length - 1);
				}
			} else {
				if (i < 1) {
					displayText=rowArr[i];
				} else {
					displayText = displayText + "\n" + rowArr[i];
//					displayText=displayText + rowArr[i];
				}
			}
		} else {
			if (rowArr[i].length > parseCols) {
				var loopCnt;
				if (rowArr[i].length % parseCols > 0) {
					loopCnt=rowArr[i].length / parseCols + 1;
				} else {
					loopCnt=rowArr[i].length / parseCols;
				}
				for ( var j=0; j < Math.floor(loopCnt); j++) {
					if (i < 1) {
						if (j < 1) {
							displayText=rowArr[i].substring(0, parseCols * (j + 1));
						} else {
							displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
//							displayText=displayText	+ rowArr[i].substring(parseCols * j,parseCols * (j + 1));
						}
					} else {
						displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
//						displayText=displayText	+ rowArr[i].substring(parseCols * j, parseCols* (j + 1));
					}
				}
			} else {
				if (i < 1) {
					displayText=rowArr[i];
				} else {
					displayText = displayText + "\n" + rowArr[i];
//					displayText=displayText + rowArr[i];
				}
			}
		}
	}

	var _frameDoc = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
	_frameDoc.getElementById(MEMO_TEXT_NAME).value = displayText;
	
	var enterCnt=countLineBreaks(displayText);
	if (iRows - 1 < enterCnt) {
		ComShowCodeMessage("BKG02006", '', iRows);
		return false;
	} else {
		memoSheet.SetCellValue(memoRow, memoCol,displayText,0);
	}
	return true;
}
/**
 * calling function when OnSaveEnd is called <br>
 * showing message of finishing to save <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj  IBSheet Object
 * @param {string} ErrMsg  message of sever
 * @return 
 * @version 2009.05.17
 */
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	sheetObj.RemoveAll();
	doActionIBSheet(sheetObj, document.form, SEARCH01, sheetObjects[0].FindCheckedRow(prefix + "radio").split("|")[0], "");
}
/**
 * Save - checking validation  function <br>
 *  <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} rowIdx 
 * @param {int} colIdx 
 * @param String value  
 * @return 
 * @version 2009.05.17
 */
function sheet2_OnValidation(sheetObj, rowIdx, colIdx, value) {
if ("D"==sheetObj.GetCellValue(rowIdx, prefix2 + "ibflag")) return;
	if (colIdx == sheetObj.SaveNameCol(prefix2 + "cust_phn_no")) {
		if (!ComIsNull(value) && !ComIsNumber(value, "-")) {
			ComShowCodeMessage("BKG95001", " enter correct 'Tel No'", "(Format:123-1234-1234)");
			sheetObj.ValidateFail(true);
			isValidateFail = true;
			sheetObj.SelectCell(rowIdx, colIdx);
		}
	} else if (colIdx == sheetObj.SaveNameCol(prefix2 + "cust_fax_no")) {
		if (!ComIsNull(value) && !ComIsNumber(value, "-")) {
			ComShowCodeMessage("BKG95001", " enter correct 'Fax No'", "(Format:123-1234-1234)");
			sheetObj.ValidateFail(true);
			isValidateFail = true;
			sheetObj.SelectCell(rowIdx, colIdx);
		}
	} else if (colIdx == sheetObj.SaveNameCol(prefix2 + "cust_eml")) {
		if (!ComIsNull(value) && !ComIsEmailAddr(value)) {
			ComShowCodeMessage("BKG95001", " enter correct 'Email Address'", "");
			sheetObj.ValidateFail(true);
			isValidateFail = true;
			sheetObj.SelectCell(rowIdx, colIdx);
		}
	}
}
/*
 * checking usable
 * */
function isUsable(sheetObj) {
if (sheetObj.GetCellValue(sheetObj.FindCheckedRow(prefix + "radio").split("|")[0], prefix + "delt_flg") == 'Y') {
		ComShowCodeMessage("BKG02004",
sheetObj.GetCellValue(sheetObj.FindCheckedRow(prefix + "radio").split("|")[0], prefix + "cust_cnt_cd") +
sheetObj.GetCellValue(sheetObj.FindCheckedRow(prefix + "radio").split("|")[0], prefix + "cust_seq"));
		return false;
	}
	return true;
}
function setCelColor(flag, obj, idx, celName, color) {
	if (flag == "N")
		obj.SetCellFontColor(idx, celName,color);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (ComIsNull(formObj.cust_cnt_cd)) {
			ComShowCodeMessage('BKG00626', 'Country Code');
			return false;
		}
		if (formObj.cust_cnt_cd.value.length != 2) {
			ComShowCodeMessage('BKG95018', 'Country Code', '2');
			return false;
		}
		if (ComIsNull(formObj.cust_seq) && ComIsNull(formObj.cust_nm) && ComIsNull(formObj.cust_addr)) {
			ComShowCodeMessage('BKG08322');
			return false;
		}
		break;
	}
	return true;
}
/**
 *  checking date 
 */
function dateCheck(dateobj) {
	if (dateobj.value == "")
		return true;//in case of null, don't check 
	return ComIsDate(dateobj.value);
}
function isNullEtcData(xmlStr) {
	var rtn=false;
	var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
	xmlDoc.loadXML(xmlStr);
	var xmlRoot=xmlDoc.documentElement;
	if (xmlRoot == null)
		return true;
	var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	if (etcDataNode == null)
		return true;
	var etcNodes=etcDataNode.childNodes;
	if (etcNodes == null)
		return true;
	if (etcNodes.length == 0)
		rtn=true;
	return rtn;
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1":
	    with(sheetObj){
		      if (location.hostname != "")
		      var HeadTitle1=" Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM";
		      var HeadTitle2=" | | |Seq.|Use|I/B Office\nHistory|Code|Name|Customer Address|S.OFC|City|State|Zip Code";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);		
		      var cols = [ {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_cnt_cd" },
			             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_seq" },
			             {Type:"Radio",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"radio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:38,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
			             {Type:"Text",      Hidden:0,  Width:38,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"history_yn",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"code",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cust_addr",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cty_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ste_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Left",    ColMerge:0,   SaveName:prefix+"zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:45,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(187);
            }


		break;
	case "sheet2":
	    with(sheetObj){        
		      var HeadTitle1="||||Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template";
		      var HeadTitle2="||||Sel.|Seq.|Name|Address|Tel. No.|Fax No.|PIC|City|State|Country|Zip Code|E-mail|Street/P.O.Box|EORI No|Remark";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cust_cnt_cd" },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cust_seq" },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"tmplt_seq" },
				             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"del_chk" },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"Seq" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix2+"cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix2+"cust_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cust_phn_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cust_fax_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:prefix2+"pic",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:prefix2+"cust_cty_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:300 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:prefix2+"cust_ste_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cstms_decl_cnt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Left",    ColMerge:0,   SaveName:prefix2+"cust_zip_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix2+"cust_eml",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:prefix2+"eur_cstms_st_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:prefix2+"eori_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix2+"tmplt_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 } ];
		       
		      
		      
	

		      InitColumns(cols);
		      SetEditable(1);
//		      SetSheetHeight(242);
		      SetColProperty(0 ,prefix2+"cust_nm" , {AcceptKeys:"E|N|[ ,.-()]", InputCaseSensitive:1});	
		      SetColProperty(0 ,prefix2+"cust_addr" ,{AcceptKeys:"E|N|[ ,.-()]", InputCaseSensitive:1});	
		      SetColProperty(0 ,prefix2+"cust_phn_no" , {AcceptKeys:"N|[- ,.-()]"});
		      SetColProperty(0 ,prefix2+"cust_fax_no" , {AcceptKeys:"N|[- ,.-()]"});
//		      SetColProperty(0 ,prefix2+"cust_zip_cd" , {AcceptKeys:"N|[-]"});
		      SetColProperty(0 ,prefix2+"cust_zip_cd" , {AcceptKeys:"E|N|[ ,-]"});
		      SetColProperty(0 ,prefix2+"pic", {AcceptKeys:"E|N|[ ,.-()]", InputCaseSensitive:1});		
		      SetColProperty(0 ,prefix2+"cust_cty_nm", {AcceptKeys:"E|N|[ ,.-()]", InputCaseSensitive:1});		
		      SetColProperty(0 ,prefix2+"cust_ste_cd", {AcceptKeys:"E|N", InputCaseSensitive:1});		
		      SetColProperty(0 ,prefix2+"cstms_decl_cnt_cd", {AcceptKeys:"E", InputCaseSensitive:1});	
//		      SetColProperty(0 ,prefix2+"cust_eml", {AcceptKeys:"E|N|[ -@.]"});	 //User cannot enter @ by UK keyboard. So stop using ibsheet validation.

		      resizeSheet();
		}
		break;
	}
}

function resizeSheet(){
	         ComResizeSheet(sheetObjects[1], 50);
}
function custPopupOK() {
	
	//set the flag of deleted rows off 
	var arrDelRow=sheetObjects[1].FindStatusRow("D").split(";");
	for(var k=0; k<arrDelRow.length; k++){
		if(arrDelRow[k]!=""){
			sheetObjects[1].SetCellValue(arrDelRow[k], prefix2 + "del_chk", 0);
		}
	}
	
	if (0==sheetObjects[1].CheckedRows(prefix2 + "del_chk")) {
		if (0==sheetObjects[0].CheckedRows(prefix + "radio")) {
			ComShowCodeMessage("COM12189");
			return;
		}
		if (!isUsable(sheetObjects[0])) {
			return;
		}
	}
	if (1<sheetObjects[1].CheckedRows(prefix2 + "del_chk")) {
		ComShowCodeMessage("BKG08040");  //Please select only one row.
		return;
	}
	var isModified=false;
	if (sheetObjects[1].IsDataModified()) {
		var arrRow=sheetObjects[1].FindStatusRow("I|U|D").split(";");
//		for (var i=0; i<arrRow.length-1; i++) {
		for (var i=0; i<arrRow.length; i++) {
			for (var j=0; j<sheetObjects[1].LastCol()+1; j++) {
				if (j == sheetObjects[1].SaveNameCol(prefix2 + "ibflag") && "D"!=sheetObjects[1].GetCellValue(arrRow[i],prefix2 + "ibflag")) continue;
				if (j == sheetObjects[1].SaveNameCol(prefix2 + "del_chk")) continue;
				if (j == sheetObjects[1].SaveNameCol(prefix2 + "Seq")) continue;
				if (sheetObjects[1].GetCellValue(arrRow[i],j) != sheetObjects[1].CellSearchValue(arrRow[i],j)) {
					isModified=true;
					break;
				}
			}
		}
	}
	var retObj1=getCustInfoRows(sheetObjects[0].FindCheckedRow(prefix + "radio").split("|")[0]);
	var retObj2=getTemplateRows(prefix2 + "del_chk");
	var chkTempRow=sheetObjects[1].FindCheckedRow(prefix2 + "del_chk").split("|")[0];
	isValidateFail = false;
	if (isModified) {
		if (ComShowCodeConfirm("BKG00386")) {  //Data changed. Do you want to save?
			doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
		}
		else{
			if(chkTempRow!=""){ //check only selected data
				sheet2_OnValidation(sheetObjects[1], chkTempRow, sheetObjects[1].SaveNameCol(prefix2 + "cust_phn_no"), sheetObjects[1].GetCellValue(chkTempRow, prefix2 + "cust_phn_no"));
				sheet2_OnValidation(sheetObjects[1], chkTempRow, sheetObjects[1].SaveNameCol(prefix2 + "cust_fax_no"), sheetObjects[1].GetCellValue(chkTempRow, prefix2 + "cust_fax_no"));
				sheet2_OnValidation(sheetObjects[1], chkTempRow, sheetObjects[1].SaveNameCol(prefix2 + "cust_eml")   , sheetObjects[1].GetCellValue(chkTempRow, prefix2 + "cust_eml"));
			}
		}
	}
	if (!isValidateFail) {
		if (callbackMethod) {
			callbackMethod(retObj1, retObj2);
			ComClosePopup(); 
		} else {
			ComClosePopup(); 
		}
	}
}
function getTemplateRows(colName) {
	if (0==sheetObjects[1].CheckedRows(colName)) return null;
	var chkRow=sheetObjects[1].FindCheckedRow(colName).split("|")[0];
	var cArray=new Array();  //list of column data
	for (var j=0; j < sheetObjects[1].LastCol()+1; j++) {
		cArray[j]=sheetObjects[1].GetCellValue(chkRow, j);
	}
	return cArray;
}
function getCustInfoRows(idx) {
	if (0==sheetObjects[0].CheckedRows(prefix + "radio")) return null;
	var cArray=new Array(); //list of column data
	for (var j=0; j < sheetObjects[0].LastCol()+1; j++) {
		if (j==sheetObjects[0].SaveNameCol(prefix + "radio")) {
			continue;
		}
		cArray[j]=sheetObjects[0].GetCellValue(idx, j);
	}
	return cArray;
}


/*
 * MOUSE PASTE 이벤트
 */
function mousePaste(obj){
   	var updateString = checkSpecial(obj);	//특수문자 제외 로직
}
/* the end of developer's work */
