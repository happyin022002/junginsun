/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0189.js
 *@FileTitle : M&R Service Provider Inquiry_Pop Up
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/**
	 * @extends
	 * @class EES_MNR_0189 : EES_MNR_0189 - Defining a script used by screen
	 */
	function EES_MNR_0189() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	// Common global variable

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Defining event handler of button click */
	document.onclick = processButtonClick;

	// Event handler to diverge process by button name */
	function processButtonClick() {
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;

				case "btn_OK":
					doSayOK();
					break;

				case "btn_Close":
					doClose();
					break;

			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
			}
		}
	}

	/**
	 * Assigning array of IBSheet object
	 * Array defined at the top of the source
	 */
	function setSheetObject(sheet_obj) {

		sheetObjects[sheetCnt++] = sheet_obj;

	}

	/**
	 * Sheet default setting and initializing
	 * To implement for onload event of body tag
	 * After loading in your browser should display the ability to add pre-processing
	 */
	function loadPage() {
		MnrWaitControl(true);
		for (i = 0; i < sheetObjects.length; i++) {

			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);

			ComEndConfigSheet(sheetObjects[i]);
		}
		 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		 MnrWaitControl(false);
	}



	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj, sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;

		switch (sheetID) {
			case "sheet1":
				with (sheetObj) {
					// Setting height
					style.height = 180;
					// Setting the overall width
					SheetWidth = mainTable.clientWidth;

					//Setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);

					//All merge option[Default msNone]
					MergeSheet = msHeaderOnly;

					//All Editing option[Default msNone]
					Editable = true;

					//Setting all row[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Sel|Seq|AGMT NO|Ref.NO|S/P Code|S/P Name|Agreement Office|Address|Effective Date";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//Setting all column[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// Setting various function of sheet header
					InitHeadMode(true, true, false, true, false, false);

					//Sheet header info setting[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//Setting attribute of Data    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 20, daCenter, true,
					        "Status");
					InitDataProperty(0, cnt++, dtRadioCheck, 30, daCenter, true,
					        "selchk");
					InitDataProperty(0, cnt++, dtSeq, 60, daCenter, false, "Seq");
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true,
					        "agmt_no", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 140, daCenter, true,
					        "agmt_ref_no", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true,
					        "vndr_seq", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 110, daLeft, false,
					        "vndr_lgl_eng_nm", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 110, daLeft, false,
					        "agmt_ofc_cd", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 160, daLeft, true,
					        "eng_addr", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true,
					        "effect_dt", false, "", dfNone, 0, true, true);
					CountPosition = 0;

				}
				break;

		}
	}

	//Sheet processing-related processes
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {

			case IBSEARCH: //Retrieving
				MnrWaitControl(true);
				sheetObj.Redraw = false;
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("EES_MNR_0189GS.do", FormQueryString(formObj));
				sheetObj.Redraw = true;
				break;

			case IBCLEAR:
				formObj.vndr_seq.value = "";
				formObj.pic_eng_nm.value = "";
				sheetObj.removeAll();
				break;

		}
	}


	function doSayOK() {
		comPopupOK();
		//self.close();
	}
	function doClose() {
		window.close();

	}
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		 MnrWaitControl(false);
	}

	function sheet1_OnDblClick(sheetObj, Row, Col) {
		var formObj = document.form;
		formObj.retfld.value = sheetObj.CellText(Row, "num_cd");
		//alert(formObj.retfld.value);
		comPopupOK();
		//self.close();
	}
	function sheet1_OnClick(sheetObj, Row, Col) {
		var formObj = document.form;
		formObj.retfld.value = sheetObj.CellText(Row, "num_cd");

	}

	/**
	 * Validating process for input form data
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			if ((sAction == IBSEARCH) || (sAction == IBSAVE)) {
				if (!ComChkValid(formObj))
					return false;
			}
		}

		return true;
	}