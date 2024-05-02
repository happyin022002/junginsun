/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : CoJobcodemanagement.js
 *@FileTitle : CoJobcodemanagement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.05.10
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2013.05.10 김상수
 * 1.0 Creation
=========================================================*/
msgs["JOB00001"] = "{?msg1} was {?msg2} successfully.";
msgs["JOB00002"] = "{?msg1} is invalid. {?msg2}";
msgs["JOB00003"] = "{?msg1} and {?msg2} can not be the same.";
msgs["JOB00004"] = "Selected {?msg1} is different from {?msg2}.\n\nDo you want to continue?";
msgs["JOB00005"] = "'{?msg1}' does not exist in User List.";
msgs["JOB00006"] = "You can not assign anything at this time. Please set this assignment after saving this job code.";
msgs["JOB00007"] = "{?msg1} Approver already Exists.";
msgs["JOB00008"] = "{?msg1} is non-existent user.";



//--------------------------------------------------------//



	/**
	 * Form Element의  OnBeforeDeactivate 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate 이벤트에 코드 처리
	 */
	function frmObj_OnBeforeDeactivate() {
		ComChkObjValid(window.event.srcElement);
	}


	/**
	 * Form Element의 OnBeforeActivate 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate 이벤트에 코드 처리
	 */
	function frmObj_OnBeforeActivate() {
		ComClearSeparator(window.event.srcElement);
	}


	/**
	 * Form Element의 OnKeyPress 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
	 */
	function frmObj_OnKeyPress() {
		var obj = window.event.srcElement;
		if (obj.dataformat == null) return;

		switch (obj.dataformat) {
			case "ymd":
			case "ym":
			case "hms":
			case "hm":
			case "jumin":
			case "saupja":
				ComKeyOnlyNumber(obj);
				break;

			case "int":
				ComKeyOnlyNumber(obj, "-");
				break;

			case "float":
				ComKeyOnlyNumber(obj, "-.");
				break;

			case "eng":
				ComKeyOnlyAlphabet("num", "32|64|~");
				break;

			case "engup":
				ComKeyOnlyAlphabet("uppernum");
				break;

			case "engdn":
				ComKeyOnlyAlphabet("lowernum");
				break;
		}
	}


	/**
	 * Form Element의 OnKeyPress 이벤트 (공통에서 예외)
	 * OnKeyPress시 TEXTAREA에 대한 MaxLength기능
	 */
	function frmObj_OnKeyPress4TextArea() {
		var obj = window.event.srcElement;
		if (obj.value.length > obj.maxlength - 1) {
			window.event.returnValue = false;
		} else {
			window.event.returnValue = true;
		}
	}


	/**
	 * Form Element의 OnKeyUp 이벤트 (공통에서 예외)
	 * OnKeyPress시 TEXTAREA에 대한 MaxLength기능
	 */
	function frmObj_OnKeyUp4TextArea() {
		var obj = window.event.srcElement;
		if (obj.value.length > obj.maxlength) {
			obj.value = obj.value.substring(0, obj.maxlength);
		}
	}


	/**
	 * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
	 *
	 * @param {string} shtObj 필수, IBSheet Object
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @return {Boorean}
	 */
	function JOBDecideErrXml(shtObj, xmlStr) {
		if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
		if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
			shtObj.LoadSearchXml(xmlStr);
			return true;    // Error일때
		} else {
			return false;
		}
	}


	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML데이터를
	 * HTML Input Select Object의 option으로 insert
	 *
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @param {object} Select Object 필수, insert하고자 하는 HTML Input Select Object.
	 * @param {string} textCol 필수, xmlStr 중 Text컬럼명.
	 * @param {string} codeCol 필수, xmlStr 중 Code컬럼명.
	 * @param {boolean} firstNull 선택, 첫번째 Item에 Null Item 생성여부
	 * @return {boolean} Select Object의 option생성 실패시 false return.
	 */
	function JOBXml2SelectItem(xmlStr, selectObj, textCol, codeCol, firstNull) {
		if (xmlStr == null || xmlStr == "" || selectObj == null || selectObj == "") return false;
		if (JOBDecideErrXml(sheetObjects[0], xmlStr))return false;
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") return false;
		if (!firstNull || firstNull == null) firstNull == false;

		try {
			// Select Object Clear
			ComClearCombo(selectObj);

			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);

			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) return false;

			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) return false;

			var colArr = dataNode.getAttribute("COLORDER").split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");

			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) return false;

			// code/text에 해당하는 컬럼index 추출
			var codeColIdx = 0;
			var textColIdx = 0;
			for (var i=0; i<colArr.length; i++) {
				if (colArr[i] == codeCol) {
					codeColIdx = i;
				}
				if (colArr[i] == textCol) {
					textColIdx = i;
				}
			}

			// firstNull이 true이면 null item생성
			if (firstNull) {
				ComAddComboItem(selectObj, "", "");
				selectObj.options[0].selected = true;
			}
			// 컬럼index로  code/text 내용추출
			for (var i=0; i<dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) continue;
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				// Select Object에 item생성
				ComAddComboItem(selectObj, arrData[textColIdx], arrData[codeColIdx]);
			}
			// 첫번째 항목 선택
			if (selectObj.options.length > 0) {
				selectObj.options[0].selected = true;
			}
			return true;

		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	}


	/**
	 * IBSheet에 시작Col과 끝Col을 지정하여 Editable속성을 일괄 변경
	 * (행단위 Editable 변경을 shtObj.RowEditable사용 할 것)
	 * @param {object} shtObj 필수, 해당 IBSheet Object
	 * @param {String} startColNm 필수, Start Col SaveName
	 * @param {String} endColNm 필수, End Col SaveName
	 * @param {Boolean} editMode 필수, Editable Value
	 * @param {int} startRowIdx 선택, Start Row Index
	 * @param {int} endRowIdx 선택, End Row Index
	 */
	function JOBCellEditable(shtObj, startColNm, endColNm, editMode, startRowIdx, endRowIdx) {
		if (shtObj == null || shtObj == "" || startColNm == null || startColNm == "" || endColNm == null || endColNm == "" || editMode == null) return;
		if (shtObj.RowCount < 1) return;
		if (startRowIdx == null || startRowIdx == "") startRowIdx = shtObj.TopRow;
		if (endRowIdx == null || endRowIdx == "") endRowIdx = shtObj.LastRow;

		shtObj.ReDraw = false;
		for (var i=startRowIdx; i<=endRowIdx; i++) {
			for (var k=shtObj.SaveNameCol(startColNm); k<=shtObj.SaveNameCol(endColNm); k++) {
				shtObj.CellEditable(i, k) = editMode;
			}
		}
		shtObj.ReDraw = true;
	}


