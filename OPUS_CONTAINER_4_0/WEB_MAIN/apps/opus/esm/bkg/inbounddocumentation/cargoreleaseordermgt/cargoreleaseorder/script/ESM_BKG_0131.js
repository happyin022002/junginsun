/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0131.js
*@FileTitle  : Cargo Release Order_Do List Check Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var sheetNames=new Array("sheet1", "sheet2");
var sheetInits=new Array(   false,    false);
// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
	/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				if (formObject.rd_flag[1].checked) {
					formObject.vsl_cd.value=formObject.vvd.value.substring(0,4);
					formObject.skd_voy_no.value=formObject.vvd.value.substring(4,8);
					formObject.skd_dir_cd.value=formObject.vvd.value.substring(8,9);
				}
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
				break;
			case "btn_DownExcel":
				if (formObject.rd_flag[1].checked) {
					formObject.vsl_cd.value=formObject.vvd.value.substring(0,4);
					formObject.skd_voy_no.value=formObject.vvd.value.substring(4,8);
					formObject.skd_dir_cd.value=formObject.vvd.value.substring(8,9);
				}
				doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL,"","");
				break;
			case "btn_CargoRelease":
				fnMoveToCargoRelease(sheetObject);
				break;
			case "btn_Print":
				if(sheetObject.RowCount() < 1){
					ComShowCodeMessage("BKG00394");
				}else{
					fnPrintSheet(sheetObject);
				}
				break;
			case "btn_evnt_dt":
				formObject.rd_flag[0].checked=true;
				fnSetUpUIByRdFlag();
				var cal=new ComCalendarFromTo();
				cal.select(formObject.evnt_dt_fm, formObject.evnt_dt_to, 'yyyy-MM-dd');
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
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj mandatory. Register Object
 * @return void
 * @author
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() {
	for(i=0;i<sheetNames.length;i++){
		if(sheetNames[i] == "sheet1") {
			sheetInit(i);
		}
	}
	initControl();
	fnSetUpUIByRdFlag();
	ComSetFocus(document.form.evnt_dt_fm);
}

/**
 * Sheet initialization function
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {int} idx mandatory, Sheet Index
 * @return {void}
 * @author
 * @version
 */
function sheetInit(idx) {
	if (sheetInits[idx] == false) {
		ComConfigSheet (sheetObjects[idx] );
		initSheet(sheetObjects[idx],idx+1);
		ComEndConfigSheet(sheetObjects[idx]);
		sheetInits[idx]=true;
	}
}

/**
 * Initialization task: an event is registered.<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function initControl() {
	axon_event.addListenerForm('click', 'objClick', form );     //- event handling onkeypress
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	axon_event.addListenerForm('focus', 'objFocus', form);
//    axon_event.addListenerForm('keypress', 'objKeyPress', form);
	var formObj=document.form;
	formObj.evnt_dt_to.value=ComGetNowInfo('ymd','-');
	formObj.evnt_dt_fm.value=ComGetDateAdd(null, 'd', -21, '-');
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}


/**
 * setting sheet initial values and header<br>
 * param : sheetObj, sheetNo<br>
 * adding case as numbers of counting sheets<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet Object
 * @param {int} sheetNo mandatory, Sheet Index
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){

				var HeadTitle1="Seq.|B/L No.|VVD|POD|DEL|D/O No.|Release Date|Release OFC|Release Staff|Consignee|Notify|Remark(s)|Release Pop-up|Warehouse|";

				SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
							 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"evnt_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cn_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"nf_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"do_prn_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cgor_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"wh_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];

				InitColumns(cols);

				SetEditable(1);
				SetEllipsis(1);
				SetWaitImageVisible(0);
				SetCountFormat("[ SELECTDATAROW / TOTALROWS ]");
				SetSelectionMode(smSelectionList);
				FrozenCols=2;
//                SetSheetHeight(440);
				resizeSheet();
		}


			break;
		case 2:      //sheet1 init
			with(sheetObj){

				 var HeadTitle1="Seq.|B/L No.|VVD|POD|DEL|D/O No.|Release Date|Release OFC|Release Staff|Consignee|Notify|Remark(s)|Release Pop-up|Warehouse";

				 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				 InitHeaders(headers, info);

				 var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
							  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"evnt_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"cn_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"nf_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"do_prn_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cgor_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
							  {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"wh_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];

				 InitColumns(cols);

				 SetEditable(1);
				 SetVisible(false);
			}
			break;
	}
}

/**
 * Sheet handling process<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet
 * @param {Object} formObj mandatory, form Object
 * @param {int} sAction mandatory, Work-handling code
 * @param {String} CondParam mandatory, Server transfers the information
 * @param {int} Select the PageNo, page number
 * @return void
 * @author
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
			if (!validateForm(sheetObj,formObj,sAction)) return;
			// VVD, Duration
			if (formObj.rd_flag[0].checked == true) {
				// maximum 1 month
				if (!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value,formObj.evnt_dt_to.value, "1")) {
					ComShowCodeMessage("BKG40013", "1");
					ComSetFocus(formObj.evnt_dt_to);
					return false;
				}
				// Release Office / Release ID either one necessarily must be entered
				if (formObj.evnt_ofc_cd.value == "" && formObj.evnt_usr_id.value == "") {
					// You didn't put it in OFC or ID column. Please insert either OFC or ID to retrieve data
					ComShowCodeMessage("BKG40078");
					ComSetFocus(formObj.evnt_ofc_cd);
					return false;
				}
			}
			if (sheetObj.id == "sheet1") {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_BKG_0131GS.do", FormQueryString(formObj) + "&page_no=1", {Append:false, Sync:1} );
				iPageNo = 1;
				ComOpenWait(false);
			}
			break;

		case IBSEARCHAPPEND: // search page
			if (!validateForm(sheetObj, formObj, IBSEARCH)) return;
			formObj.f_cmd.value = SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			if (PageNo >= 1) {
				sheetObj.DoSearch("ESM_BKG_0131GS.do", FormQueryString(formObj) + "&page_no=" + PageNo, {Append:true, Sync:1} );
			} else {
				sheetObj.DoSearch("ESM_BKG_0131GS.do", FormQueryString(formObj) + "&page_no=1", {Append:false, Sync:1} );
			}
			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:
			if (!validateForm(sheetObj, formObj, IBSEARCH)) return;
			// VVD, Duration
			if (formObj.rd_flag[0].checked == true) {
				// maximum 1 month
				if(!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value,formObj.evnt_dt_to.value, "1")){
					ComShowCodeMessage("BKG40013", "1");
					ComSetFocus(formObj.evnt_dt_to);
					return false;
				}
				// Release Office / Release ID either one necessarily must be entered
				if(formObj.evnt_ofc_cd.value == "" && formObj.evnt_usr_id.value == "") {
					// You didn't put it in OFC or ID column. Please insert either OFC or ID to retrieve data
					ComShowCodeMessage("BKG40078");
					ComSetFocus(formObj.evnt_ofc_cd);
					return false;
				}
			}
			if(sheetObj.id == "sheet2") {
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				sheetInit(1);
				sheetObj.DoSearch("ESM_BKG_0131GS.do",FormQueryString(formObj) + "&excel_flg=Y" );
			}
			break;
	}
}

/**
 * handling process for input validation<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet
 * @param {Object} formObj mandatory, Form Object
 * @param {int} sAction mandatory,handling  code
 * @return boolean
 * @author
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction){
	 switch (sAction){
		 case IBSEARCH:
			 if(!ComChkValid(formObj)) return false;
			 if (formObj.rd_flag[0].checked== true) {
				 if(!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value, formObj.evnt_dt_to.value, 3)) {
					ComShowCodeMessage("BKG40013", "3"); //only less than {?msg1}-month periods allowed
					return false;
				 }
			 }
			 break;
		 case IBDOWNEXCEL:
			 if(!ComChkValid(formObj)) return false;
			 if (formObj.rd_flag[0].checked== true) {
				 if(!ComBkgMonthsBetweenCheck(formObj.evnt_dt_fm.value, formObj.evnt_dt_to.value, 3)) {
					ComShowCodeMessage("BKG40013", "3"); //only less than {?msg1}-month periods allowed
					return false;
				 }
			 }
			 break;
	 }
	return true;
}

/**
 * radio button event:Change the status search conditions.<br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function fnSetUpUIByRdFlag() {
	var formObj=document.form;
	with(formObj) {
		if(rd_flag[0].checked == true) { // F  -- Release Date
			document.getElementsByName("evnt_dt_fm")[0].setAttribute("required", true);
			document.getElementsByName("evnt_dt_to")[0].setAttribute("required", true);
			document.getElementsByName("vvd")[0].removeAttribute("required");
			document.getElementsByName("vvd")[0].removeAttribute("fullfill");
			document.getElementsByName("pod_cd")[0].removeAttribute("required");
			document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
			document.getElementsByName("bl_no")[0].removeAttribute("required");
		} else if(rd_flag[1].checked == true) { // T  -- VVD
			document.getElementsByName("evnt_dt_fm")[0].removeAttribute("required");
			document.getElementsByName("evnt_dt_to")[0].removeAttribute("required");
			document.getElementsByName("vvd")[0].setAttribute("required", true);
			document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
			document.getElementsByName("pod_cd")[0].setAttribute("required", true);
			document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
			document.getElementsByName("bl_no")[0].removeAttribute("required");
		} else { // S BL
			document.getElementsByName("evnt_dt_fm")[0].removeAttribute("required");
			document.getElementsByName("evnt_dt_to")[0].removeAttribute("required");
			document.getElementsByName("vvd")[0].removeAttribute("required");
			document.getElementsByName("vvd")[0].removeAttribute("fullfill");
			document.getElementsByName("pod_cd")[0].removeAttribute("required");
			document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
			document.getElementsByName("bl_no")[0].setAttribute("required", true);
		}
	}
}

/**
 * form object click Event<br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function objClick() {
	var objName=ComGetEvent("name");
	var formObj=document.form;
	switch(objName) {
		case "evnt_dt_fm":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_dt_to":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_ofc_cd":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_usr_id":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "vvd":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "pod_cd":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "del_cd":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "bl_no":
			formObj.rd_flag[2].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "rd_flag":
			fnSetUpUIByRdFlag();
			break;
	}
}

/**
 *  keypress Event <br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function objKeyPress() {
	var objName=ComGetEvent("name");
	var formObj=document.form;
	switch(objName) {
	case "evnt_dt_fm":
		obj_KeyPress(ComGetEvent());
		break;
	case "evnt_dt_to":
		obj_KeyPress(ComGetEvent());
		break;
	case "evnt_ofc_cd":
		ComKeyOnlyAlphabet('upper');
		break;
	case "vvd":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "pod_cd":
		ComKeyOnlyAlphabet('upper');
		break;
	case "del_cd":
		ComKeyOnlyAlphabet('upper');
		break;
	case "bl_no":
		ComKeyOnlyAlphabet('uppernum');
		break;
	}
}

/**
 * HTML focus event handling <br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function objFocus() {
	var objName=ComGetEvent("name");
	var formObj=document.form;
	switch(objName) {
		case "evnt_dt_fm":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_dt_to":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_ofc_cd":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "evnt_usr_id":
			formObj.rd_flag[0].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "vvd":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "pod_cd":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "del_cd":
			formObj.rd_flag[1].checked=true;
			fnSetUpUIByRdFlag();
			break;
		case "bl_no":
			formObj.rd_flag[2].checked=true;
			fnSetUpUIByRdFlag();
			break;
	}
}

/**
 *  Scroll click  :Next Page handling<br>
 * @param {Object} sheetObj mandatory, Sheet Object
 * @param {String} CondParam mandatory, Search condition
 * @param {int} PageNo mandatory, Page Number
 * @param {int} OnePageRows select, Page Count
 * @return void
 * @author
 * @version 2009.10.01
 */
var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}

/**
 * Search at the end of the Excel  event-handling.(Excel)<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj mandatory, Sheet Object
 * @param {String} errStr mandatory, The message String
 * @returns void
 * @author
 * @version 2009.10.01
 */
function sheet2_OnSearchEnd(sheetObj, errXml) {
	ComOpenWait(false);
	if (sheetObj.RowCount() < 1) {//If there's no result
		ComShowCodeMessage("BKG00109");
	} else {
		sheetObj.Down2Excel();
	}
}

/**
 * Cargo Release the screen to move to.<br>
 * @param {Object} sheetObj mandatory, Sheet Object
 * @return void
 * @author
 * @version 2009.10.01
 */
function fnMoveToCargoRelease(sheetObj) {
	var bkgNo="";
	if (sheetObj.RowCount() > 0) {
		var sRowStr=sheetObj.GetSelectionRows("|");
		if (sRowStr == "0" ) {
			// Please retrieve data first.
			ComShowCodeMessage("BKG00012");
			return ;
		}
		var sRowArr=sRowStr.split("|");
		if(sRowArr.length > 1){
			ComShowCodeMessage("BKG00362");
			return;
		}
		bkgNo=sheetObj.GetCellValue(sRowArr[0], "bkg_no");
		if (bkgNo=="") {
			// Please retrieve data first.
			ComShowCodeMessage("BKG00012");
			return;
		}
	}
	var param="?bkg_no="+bkgNo+"&pgmNo=ESM_BKG_0128";
	ComOpenWindowCenter("ESM_BKG_0128_POP.do"+param, "ESM_BKG_0128", 1130, 768, false, "yes");
}

/**
 * Print selected row<br>
 * @param {Object} sheetObj mandatory, Sheet Object
 * @return void
 * @author
 * @version 2009.10.01
 */
function fnPrintSheet(sheetObj) {
	sheetInit(1);
	var prtSheet=sheetObjects[1];
	var sRowStr=sheetObj.GetSelectionRows("|");
	if (sRowStr == "0" ) {
		// Please retrieve data first.
		ComShowCodeMessage("BKG00012");
		return ;
	}
	var sRowArr=sRowStr.split("|");
	var blNo=sheetObj.GetCellValue(sRowArr[0], "bl_no");
	if(blNo=="") {
		// Please retrieve data first.
		ComShowCodeMessage("BKG00012");
		return;
	}
	var sRowArr=sRowStr.split("|");
	prtSheet.RemoveAll();
	for (var idx=0; idx <sRowArr.length; idx++) {
		fnCopyRow(prtSheet, sheetObj, sRowArr[idx]);
	}
	prtSheet.DoPrint();
}

/**
 * targetObj new lines add, source  particular row copy<br>
 * @param {Object} targetObj mandatory, targetObj
 * @param {Object} sourceObj mandatory, sourceObj
 * @param {int} row mandatory. row number
 * @return void
 * @author
 * @version 2009.10.01
 */
function fnCopyRow(targetObj, sourceObj, row) {
	var lastIdx=targetObj.LastCol();
	var newIdx=targetObj.DataInsert(-1);
	for (var idx=0; idx<=lastIdx; idx++) {
		targetObj.SetCellValue(newIdx, targetObj.ColSaveName(idx),sourceObj.GetCellValue(row, targetObj.ColSaveName(idx)),0);
	}
}

/**
 * ibSheet OnClick Event handling<br>
 * @param {Object} sheetObj mandatory, Sheet Object
 * @param {int} row mandatory. row number
 * @param {int} col mandatory, col number
 * @return void
 * @author
 * @version 2009.10.01
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var eventCol=sheetObj.ColSaveName(col);
var eventValue=sheetObj.GetCellValue(row, col);
	switch (eventCol) {
		case "cn_nm":
			if (eventValue != ""){
				ComShowMemoPad(sheetObj, row, "cn_nm", true, 200, 100, 200 );
			}
			break;
		case "nf_nm":
			if (eventValue != ""){
				ComShowMemoPad(sheetObj, row, "nf_nm", true, 200, 100, 200 );
			}
			break;
		case "do_prn_rmk":
			if (eventValue != ""){
				ComShowMemoPad(sheetObj, row, "do_prn_rmk", true, 200, 100, 200 );
			}
			break;
		case "evnt_usr_id":
			if(eventValue != "") {
				ComUserPopup(eventValue);
			}
			break;
	}
}