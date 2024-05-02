/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0549.js
*@FileTitle : Customer Code Entry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/05
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	 var sheetObject1=sheetObjects[0];
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;
			case "btn_downexcel":
				doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
			break;
			case "btn_close":
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
 * adding first-served functions after loading screen
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	initControl();
}
/**
 * registering initial event
 */
function initControl() {
	var formObject=document.form;
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- focus out
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- focus in
	axon_event.addListenerFormat('keypress',         'obj_keypress',    formObject);
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	/*
	axon_event.addListener('keypress', 'eng_keypress', 'hamo_cd_desc');
	axon_event.addListener('keypress', 'obj_keypress', 'hamo_trf_cd');
	*/
	ComSetFocus(formObject.vvd);
}
/**
 * handling onkeypress event of HTML Control
 */
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "int":
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "eng":
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			ComKeyOnlyAlphabet('upper');
			break;
		default:
			ComKeyOnlyNumber(event.srcElement);
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch(sheetId) {
		case "sheet1":
			with(sheetObj){

		  var HeadTitle1="|Seq.|B/L No|Booking No.|Results||";
		  var headCount=ComCountHeadTitle(HeadTitle1);
		  var prefix='sheet1_';

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
				 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:prefix+"results",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_decl_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dnld_sts",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

		  InitColumns(cols);

		  SetEditable(1);
		  SetCountPosition(0);
		  SetSheetHeight(350);
				}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:
			if( validateForm(sheetObj,formObj,sAction) ){
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0549GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
				formObj.total.value=sheetObj.RowCount();
			}
		break;
		case IBSAVE:
			if( validateForm(sheetObj,formObj,sAction) ){
				formObj.f_cmd.value=MULTI;
				var bkgNo="";
				var blNo="";
				var cstmsDeclTpCd="";
				var okCnt=0;
				var failCnt=0;
				for(var i=1; i <= sheetObjects[0].RowCount(); i++){
//   			    	sheetObjects[0].SelectRow(i);
					if (i > 10) sheetObjects[0].SetTopRow(i - 10);
					bkgNo=sheetObjects[0].GetCellValue( i, 3 );
					blNo=sheetObjects[0].GetCellValue( i, 2 );
					cstmsDeclTpCd=sheetObjects[0].GetCellValue( i, 5 );
					var sParam="bl_no=" + blNo
						+ "&" + "bkg_no="  + bkgNo
						+ "&" + "cstms_decl_tp_cd=" + cstmsDeclTpCd
						+ "&" + FormQueryString(formObj);
//					alert(sParam);
					var sXml=sheetObj.GetSaveData("ESM_BKG_0549GS.do",sParam);
					var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					if ( State != 'S' ) {
						failCnt ++ ;
					} else {
						okCnt ++;
					}
					formObj.ok.value=okCnt;
					formObj.fail.value=failCnt;
					var message=ComGetEtcData(sXml, "MESSAGE");
					sheetObjects[0].SetCellValue( i, 4 ,message);
				}
				sheetObjects[0].LoadSaveData(sXml);
			}
		break;
		case IBDELETE:
			var checked=0;
			for (var i=2 ; i <= sheetObj.RowCount()+1 ; i++){
				if( sheetObj.GetCellValue(i,1) == '1' ){
					checked=1;
					if (sheetObj.GetCellValue(i,0) != "I"){
						if( sheetObj.GetCellValue(i,1) == '1' ){
							sheetObj.SetRowHidden( i ,1);
							sheetObj.SetRowStatus( i ,"D");
						}
					}else{
						if( sheetObj.GetCellValue(i,1) == '1' ){
							//sheetObj.RowHidden( i ) = true;
							sheetObj.SetRowStatus( i ,"D");
							i--;
							//sheetObj.RowDelete();
						}
					}
				}
			}
			if ( checked == 0 ) ComShowCodeMessage('BKG00249');
		break;
		case IBDOWNEXCEL:
			if( sheetObj.RowCount()> 0 )
				sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObjects[0]), SheetDesign:1,Merge:1 });
			else
				ComShowCodeMessage('BKG00389');
		break;
	}
}
 /**
	 * handling process for input validation
	 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		return true;
		break;
	case IBSAVE:
		if (ComChkLen(formObj.vvd, 9) != 2) {
			ComShowCodeMessage("BKG01019", "VVD");
			ComSetFocus(formObj.vvd);
			return false;
		}
		if (ComChkLen(formObj.whf_pol_cd, 5) != 2) {
			ComShowCodeMessage("BKG01019", "Port");
			ComSetFocus(formObj.whf_pol_cd);
			return false;
		}
		if (ComChkLen(formObj.whf_bnd_cd, 2) != 2) {
			ComShowCodeMessage("BKG01019", "Bound");
			ComSetFocus(formObj.whf_bnd_cd);
			return false;
		}
		return true;
		break;
	case IBDELETE:
		if (formObj.port_cd.value == "") {
			ComShowCodeMessage('BKG00266');
			formObj.port_cd.focus();
			return false;
		}
		return true;
		break;
	}
}
 /**
	 * setting data type when addrow
	 */
	 function addRowEdit(sheetObj,formObj){
		 //var Row = sheetObj.SelectRow;
	 //sheetObj.CellValue2(Row,1) = "1";
	 //sheetObj.CellEditable(Row, 5) = false;
 }
