/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0951.js
*@FileTitle  : Load Summary by POD 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends
 * @class ESM_BKG_0951 : ESM_BKG_0951 - task script definition for screen
 */
function ESM_BKG_0951() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// public variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_new":
			document.form.reset();
			sheetObject1.RemoveAll();
			sheetObject2.RemoveAll();
			sheetObject3.RemoveAll();
			// sheetObject4.RemoveAll();
			formObject.in_vvd_cd.focus();
			break;
		case "btn_print":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
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
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	//for (i = 0; i < sheetObjects.length; i++) {
	//	doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	// }
	document.form.in_vvd_cd.focus();
	initControl();
}
/**
 * load HTML Control event on the page <br>
 * {@link #loadPage}call the function and init IBSheet Object <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 
 */
function initControl() {
	// ** Date devision **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	// Axon Event process1 Event catch(Develoer can change)
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); 
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); 
	//axon_event.addListenerFormat('keypress', 'obj_keypress', formObject);
	// 키보드
//	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_print");
}
/**
 * process when you enter retrieve condition
 */
//function obj_KeyUp() {
//	var formObject=document.form;
//	var srcName=ComGetEvent("name");
//	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	var srcValue=window.event.srcElement.getAttribute("value");
//	if (ComChkLen(srcValue, srcMaxLength) == "2") {
//		ComSetNextFocus();
//	}
//}
/**
 * control keyboard input  onkeypress event of HTML Control
 */
//function obj_keypress() {
//	switch (event.srcElement.dataformat) {
//	case "uppernum":
//		// English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyOnlyAlphabet('uppernum');
//		break;
//	case "upper":
//		// English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyOnlyAlphabet('upper');
//		break;
//	case "uppernum2":
//		// English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyAlphabetNChar('uppernum');
//		break;
//	default:
//		// enter just number
//		ComKeyOnlyNumber(event.srcElement);
//	}
//}
/**
 * setting sheet initial values and header
 * 
 * adding case as numbers of counting sheets
 * @param sheetObj 
 * @param sheetNo 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch (sheetid) {
	case "sheet1":
	    with(sheetObj){
        
      if (location.hostname != "")
      //no support[check again]CLT InitHostInfo(location.hostname, location.port, page_path);
      var HeadTitle1="|POD|Local|Local|Local|Local|T/S|T/S|T/S|T/S|Empty|Empty|Empty|Empty|Total|Total|Total|Total|Weight (KGS)";
      var HeadTitle2="|POD|20|40|40H|45|20|40|40H|45|20|40|40H|45|20|40|40H|45|Weight (KGS)";
      var headCount=ComCountHeadTitle(HeadTitle1);
      (headCount, 0, 0, true);

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"},
                  { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"lo_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"lo_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"lo_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"lo_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ts_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ts_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ts_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ts_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"mt_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"mt_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"mt_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"mt_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"to_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"to_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"to_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"to_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"wgt_mt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);
      SetSheetHeight(150);
      SetEditable(1);
      SetRangeBackColor(1,1,1,17,"#555555");
      }


		break;
	case "sheet2":
	    with(sheetObj){
        
      if (location.hostname != "")
      //no support[check again]CLT InitHostInfo(location.hostname, location.port, page_path);
      var HeadTitle1="|POD|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total|Total";
      var HeadTitle2="|POD|DG|DG|DG|RF|RF|RF|FR|FR|FR|OT|OT|DG|DG|DG|RF|RF|RF|FR|FR|FR|OT|OT|DG|DG|DG|RF|RF|RF|FR|FR|FR|OT|OT";
      var HeadTitle3="|POD|20|40|40H|20|40|40H|20|40|40H|20|40|20|40|40H|20|40|40H|20|40|40H|20|40|20|40|40H|20|40|40H|20|40|40H|20|40";
      var headCount=ComCountHeadTitle(HeadTitle1);
      (headCount, 0, 0, true);

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"},
                  { Text:HeadTitle2, Align:"Center"},
                  { Text:HeadTitle3, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ 
             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d_lo_20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d_lo_40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"d_lo_40h",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_lo_20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_lo_40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_lo_40h",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_lo_20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_lo_40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_lo_40h",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"o_lo_20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"o_lo_40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d_ts_20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d_ts_40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d_ts_40h",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_ts_20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_ts_40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_ts_40h",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_ts_20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_ts_40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_ts_40h",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"o_ts_20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"o_ts_40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d_lo_ts_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d_lo_ts_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"d_lo_ts_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_lo_ts_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_lo_ts_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"r_lo_ts_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_lo_ts_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_lo_ts_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"f_lo_ts_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"o_lo_ts_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"o_lo_ts_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);
      SetSheetHeight(180);
      SetEditable(1);
      SetRangeBackColor(1,1,2,34,"#555555");
      }


		break;
	case "sheet3":
	    with(sheetObj){    
	      if (location.hostname != "")
	      //no support[check again]CLT InitHostInfo(location.hostname, location.port, page_path);
	      var HeadTitle1="|POD|OD|OD|OD|ODET|ODET|ODET|ODHD|ODHD|ODHD|ODTB|ODTB|ODTB|ODTS|ODTS|ODTS|UD|UD|UD|UDAB|UDAB|UDAB|UDAV|UDAV|UDAV|UDBW|UDBW|UDBW|UDHG|UDHG|UDHG|UDTS|UDTS|UDTS|PCOD|PCOD|PCOD";
	      var HeadTitle2="|POD|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H";
	      var headCount=ComCountHeadTitle(HeadTitle1);

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	                      { Text:HeadTitle2, Align:"Center"},                  
//	                  	  { Text:HeadTitle3, Align:"Center"},
	                  	];
	      InitHeaders(headers, info);

	      var cols = [ 
	             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"od_20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"od_40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidde301n:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"od_40h",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odet_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odet_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odet_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odhd_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odhd_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odhd_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odtb_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odtb_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odtb_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odts_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odts_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"odts_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"ud_20",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"ud_40",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"ud_40h",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udab_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udab_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udab_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udav_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udav_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udav_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udbw_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udbw_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udbw_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udhg_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udhg_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udhg_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udts_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udts_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"udts_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"pcod_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"pcod_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"pcod_40h",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(180);
	      Editable=true;
	      SetRangeBackColor(1,1,1,37,"#555555");
	      }

		break;
	}
}
/**
 * handling sheet process
 * @param sheetObj 
 * @param formObj
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
//parameter changed[check again]CLT 			
			var sXml=sheetObj.GetSearchData("ESM_BKG_0951GS.do",FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			} else {
				sheetObjects[0].RemoveAll();
			}
			if (arrXml.length > 1) {
				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			} else {
				sheetObjects[1].RemoveAll();
			}
			if (arrXml.length > 2) {
				sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			} else {
				sheetObjects[2].RemoveAll();
			}
			//formObj.shp_id_no.value = sheetObj.EtcData("shp_id_no");
			ComEtcDataToForm(formObj, sheetObj);
			state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
			if (state == "S") {
				if (sheetObj.RowCount()!= 0) {
					if (document.form.in_vvd_cd.value != "") {
						//alert();
						ComBtnEnable("btn_print");
					}
				} else {
					ComBtnDisable("btn_print");
				}
			}
			ComOpenWait(false);
		}
		break;
	case COMMAND01: // save
		if (validateForm(sheetObj, formObj, sAction)) {
			var inVvdCd=formObj.in_vvd_cd.value;
			var inPolCd=formObj.in_pol_cd.value;
			var inPolYdCd=formObj.in_pol_yd_cd.value;
			var inBkgOfcCd=formObj.in_bkg_ofc_cd.value;
			var setText1=formObj.setText1.value;
			var setText2=formObj.setText2.value;
			var remark2=formObj.remark.value;
			var remark=ComReplaceStr(remark2, "\r\n", "`");
			var vvdCd=formObj.vvd_cd.value;
			var unLocCd=formObj.un_loc_cd.value;
			var vpsEtdDt=formObj.vps_etd_dt.value;
			// var sUrl = "/opuscntr/ESM_BKG_5011.do?inVvdCd=" + inVvdCd
			// + "&inPolCd=" + inPolCd + "&inPolYdCd=" + inPolYdCd
			// + "&inBkgOfcCd=" + inBkgOfcCd + "&setText1=" + setText1
			// + "&setText2=" + setText2 + "&remark=" + remark
			// + "&vvdCd=" + vvdCd + "&unLocCd=" + unLocCd
			// + "&vpsEtdDt=" + vpsEtdDt;
			// var sUrl = "/opuscntr/ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			// ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 1024, 768, false);
			ComOpenWindowCenter("/opuscntr/ESM_BKG_5011.do?pgmNo=ESM_BKG_5011",
					"ESM_BKG_5011", 1024, 600, false);
		}
	}
}
/**
 * registering IBTab Object as list adding process for list in case of needing batch processing with other items 
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab setting Tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
InsertItem( "Container Info", "");
InsertItem( "Customer Info", "");
InsertItem( "Export No", "");
		}
		break;
	}
}
/**
 * Event when clicking Tab activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	// --------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab=nItem;
}
/**
 * handling process for input validation
 * @param sheetObj 
 * @param formObj 
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // retrieve
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00251');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
			ComShowCodeConfirm('BKG01101', 'POL');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	case COMMAND01: // retrieve
		// alert(formObj.vvd_cd.value);
		// alert(formObj.vps_eta_start_dt.value);
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00251');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5) {
			ComShowCodeConfirm('BKG01101', 'POL');
			formObj.in_pol_cd.focus();
			return false;
		}
		return true;
		break;
	}
}
/**
 * Enter event
 * @return
 */
function obj_ComKeyEnter() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	// alert(srcName);
	if (srcName != "remark") {
		ComKeyEnter();
	}
}