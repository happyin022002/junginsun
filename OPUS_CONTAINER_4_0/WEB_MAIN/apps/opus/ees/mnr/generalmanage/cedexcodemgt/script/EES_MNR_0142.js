/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0142.js
 *@FileTitle : Pop Up_Tariff Code Finding
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
	 * @class EES_MNR_0142 : EES_MNR_0142 - Defining a script used by screen
	 */
	function EES_MNR_0142() {
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
	var comboObjects = new Array();
	var comboCnt = 0;

	// Defining event handler of button click */
	document.onclick = processButtonClick;

	// Event handler to diverge process by button name */
	function processButtonClick() {
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject = sheetObjects[0];

		/** **************************************************** */
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {

				case "btn_OK":
					comPopupOK();
					//self.close();
					break;

				case "btn_Close":
					window.close();
					break;

			} // end switch
		} catch (e) {
			if( e == "[object Error]") {
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
	 * Initializing combo
	 * @return
	 */
	function initCombo() {
		 var formObject = document.form;
		 var i = 0;
	     with (formObject.combo1)
	     {
			   MultiSeparator = "|";
			   SetTitle("Tariff Code|Tariff Name");
			   //MultiSelect = false;
			   SetColAlign("left|left");
			   SetColWidth("100|150");
			   DropHeight = 160;

			   var comboList = getTariffCodeType();
			   for(var i=0; i<comboList.length; i++)
				{
					if(comboList[i] != null)
					{
						for(var j = 0; j < comboList[i].length;j++)
						{
							var xmlVal = comboList[i][j].split("|");
						if(i==0){
							InsertItem(j, comboList[i][j] ,xmlVal[0]);
						}
					}
					if(i==0){
						if(tct != ""){
							Code = tct;
							Enable = false;
						}
					}
				}
			}
	    }
	}

	 function getTariffCodeType(){

			var sheetObj=sheetObjects[0];
			var sCondition = new Array (
					new Array("MnrGenCd","CD00014", "COMMON") //Tariff Code Type
				);
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
			return comboList;

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
		initCombo();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		MnrWaitControl(false);
	}

	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj, sheetNo) {

		var cnt = 0;

		switch (sheetObj.id) {
			case "sheet1":
			with (sheetObj) {

				// Setting height
				style.height = 350;
				// Setting the overall width
				SheetWidth = mainTable.clientWidth;

				// Setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// All merge option[Default msNone]
				MergeSheet = msNone;

				// All Editing option[Default msNone]
				Editable = true;

				// Setting all row[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				var HeadTitle = "|Sel|Seq|Numeric|Code|Name";

				var headCount = ComCountHeadTitle(HeadTitle);

				// Setting all column[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// Setting various function of sheet header
				InitHeadMode(true, true, false, true, false, false)

				// Sheet header info setting[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// Data attribute [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0);
				InitDataProperty(0, cnt++, dtRadioCheck,       30,  daCenter, true,  	"selchk");
				InitDataProperty(0, cnt++, dtSeq,                 50,  daCenter, false,    "Seq");
				InitDataProperty(0, cnt++, dtData,                90,  daCenter, false,    "num_cd",        false, "", dfNone);
				InitDataProperty(0, cnt++, dtData,                90,  daCenter, false,    "cd",    false, "", dfNone);
				InitDataProperty(0, cnt++, dtData,               150,  daLeft,    false,    "nm",           false,  "", dfNone);

				CountPosition = 2;
			}
			break;

		}
	}

	//Sheet processing-related processes
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {

		case IBSEARCH: //Retrieving
			doIBSEARCH(sheetObj, formObj, sAction);
			break;

	//	case IBSAVE: //Saving
	//		if (validateForm(sheetObj, formObj, sAction))
	//			alert(" Save .. ");
	//		break;
	//
	//	case IBINSERT: //Inserting
	//		break;
		}
	}


	function doIBSEARCH(sheetObj, formObj, sAction){
		   MnrWaitControl(true);
		   sheetObj.Redraw = false;
	       formObj.f_cmd.value = SEARCH;
	       //alert(FormQueryString(formObj) );
	       sheetObj.DoSearch("EES_MNR_0142GS.do",FormQueryString(formObj) );
	       sheetObj.Redraw = true;

	}
 	function sheet1_OnSearchEnd(sheetObj, errMsg) {
 		MnrWaitControl(false);
 	}
	function sheet1_OnDblClick(sheetObj,Row,Col){
		var formObj = document.form;
		 formObj.retfld.value = sheetObj.CellText(Row, "num_cd");
	     //alert(formObj.retfld.value);
		  comPopupOK();
		  //self.close();
	 }
	 function sheet1_OnClick(sheetObj,Row,Col){
			var formObj = document.form;
	      	 formObj.retfld.value = sheetObj.CellText(Row,  "num_cd");

	 }
	 function combo1_OnChange(comboObj,Index_Code, Text){
		 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * Validating process for input form data
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			//            if (!isNumber(formObj.iPage)) {
			//                return false;
			// }
		}

		return true;
	}
