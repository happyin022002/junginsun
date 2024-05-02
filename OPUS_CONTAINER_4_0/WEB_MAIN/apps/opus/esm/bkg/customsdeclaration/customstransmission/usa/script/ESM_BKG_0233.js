/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0233.js
*@FileTitle  : Inbond EDA Adjustment by VVD 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
 * @author 
 */
/**
 * @extends
 * @class ESM_BKG-0233 : business script for ESM_BKG-0233 
 */
	
	function esm_bkg_0233() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	//Common global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var sheetObject = sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_New":
				formObject.reset();
				sheetObject.RemoveAll();
				break;
			case "btn_DownExcel":
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}
				break;
			case "btn_Transmit":
				doActionIBSheet(sheetObjects[0], document.form, MULTI01);
				break;
			case "btn_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
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
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	}
	/**
	 * HTML Control on the page  loaded dynamically  the event. <br>
	 * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects array  sequence number
	 */
	function initControl() {
		//** Date Delimiter **/
		DATE_SEPARATOR = "-";
		var formObject=document.form;
		//axon_event.addListenerFormat('keypress', 'obj_KeyPress2', formObject); // - When typing the keyboard
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: //sheet1 init
		    with(sheetObj){
		      var HeadTitle1="|Seq.||VVD|POD|MI EDA|SKD ETA|B/L count";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"CheckBox",  Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
		             {Type:"Text",      Hidden:0,  Width:165,  Align:"Center",  ColMerge:1,   SaveName:"vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:165,  Align:"Center",  ColMerge:1,   SaveName:"eda_on_mi",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"eta",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bl_count",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
//		      SetSheetHeight(440);
		      ComResizeSheet(sheetObj);
		    }
		break;
		}
	}
	//Sheet handling process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: //Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0233GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:0} );
			}
			break;
			
		case MULTI01: // Transmit
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=MULTI01;
				var sParam=ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0233GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
			}
			break;
			
		case IBINSERT: 
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH:
			if (!ComChkRequired(formObj))
				return false;
			if (chkDateTimeValid(formObj.from_dt, "ymd") == "false") {
				return false;
			}
			if (chkDateTimeValid(formObj.to_dt, "ymd") == "false") {
				return false;
			}
			break;
		case MULTI01:
			if (sheetObj.CheckedRows("chk") == 0) {
				ComShowCodeMessage('BKG00333');
				return false;
			}
			if (!ComShowCodeConfirm("BKG00447")) {
				return false;
			}
			break;
		}
		return true;
	}
	
	function chkDateTimeValid(obj, gubun) {
		var rtn="";
		if(gubun == "ymd") {
			var tmp=obj.value.replace('-', '').replace('-', '').replace('/', '').replace('/', '');
			if(tmp.length < 8) {
				ComShowCodeMessage('BKG00921');
				obj.focus();
				return "false";
			}
			var year=parseInt(tmp.substring(0, 4));
			var mon=parseInt(eval(tmp.substring(4, 6))) - 1;
			var days=parseInt(eval(tmp.substring(6, 8)));
			d=new Date(year, mon, days);
			var yearD=d.getFullYear();
			var monD=d.getMonth();
			var daysD=d.getDate();
			if(year != yearD || mon != monD || days != daysD){
				ComShowCodeMessage('BKG00714');
				obj.focus();
				return "false";
			}
			var arrDtM="";
			if(monD+1 < 10) arrDtM="0"+(monD+1);
			else arrDtM=""+(monD+1);
			var arrDtD="";
			if(daysD < 10) arrDtD="0"+daysD;
			else arrDtD=""+daysD;
			rtn=yearD+"-"+arrDtM+"-"+arrDtD;
		}
		return rtn;
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			for (var i=1; i <= RowCount()+1; i ++) {
				var etaVal=GetCellValue(i, "eta");
				if(etaVal.length > 10) {
					etaVal=etaVal.substring(0, 10);
				}
				if (GetCellValue(i, "eda_on_mi") != etaVal) {
					SetCellBackColor(i, "Seq","#FF0000");// The red letters
					sheetObj.SetCellFontColor(i, "eta","#FF0000");
				}
			}
		}
	}
	
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		var state = sheetObj.GetEtcData("TRANS_RESULT_KEY");
		if (state == "S") {
			ComShowCodeMessage('BKG00101'); 
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}