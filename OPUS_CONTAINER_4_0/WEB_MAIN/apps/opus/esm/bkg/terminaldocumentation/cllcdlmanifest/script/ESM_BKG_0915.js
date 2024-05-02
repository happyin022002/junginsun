/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0915
*@FileTitle  : ESM_BKG_0915
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/17
=========================================================*/

/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/

// Common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var check=true;
var state="";
 //Event Handler definition for Button Click event */
document.onclick=processButtonClick;
//Event Handler for branch processing by judging button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;	
		case "btn_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		case "btn_delete":
			doActionIBSheet(sheetObject, formObject, IBDELETE);
			break;			
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;			
		case "btn_close":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
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
  * Registering IBSheet Object in to Array
  * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
  * The array is defined at upper part of source
  * @param sheet_obj IBSheet Object
  */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
   /**
    * Sheet basic setting & initializing
    * onLoad Event HandlerImplementation of body tag
    * After loading screen in the browser, add function in pre-processing
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
 * Dynamic loading event of HTML Control in page.<br>
 * @link Initializing IBSheet Object with calling on oadPage} function to this function <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects order in array
 */
function initControl() {
	// ** Date seperator **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
//	 Axon event processing1. eventcatch
//	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - focus
//	 exiting
//	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - socus
//	 entering
//	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
//	 keyboard
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_save");
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	document.form.form1_imdg_un_no.focus()
}


/**
 * Definition for sheet initial setting value, header
 * param : sheetObj ==> sheet object, sheetNo ==> If the serial number ID tag attached to the sheet are many,
 * adding 'Case' clause as a number of sheets, configures initial module.
 * @param sheetObj sheet object
 * @param sheetNo Sheet object tag ID attached serial number
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {
		    var HeadTitle="|||||||||||||||||||||||||||||||||||";
	
		    SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	
		    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);
	
		    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		              {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cll_dg_seq" },
		              {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		              {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		              {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"dg_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"emer_cntc_phn_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:18,   Align:"Center",  ColMerge:0,   SaveName:"flsh_pnt_cdo_temp",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dg_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"emer_prc_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		              {Type:"Text",      Hidden:0,  Width:28,   Align:"Right",   ColMerge:0,   SaveName:"dg_pck_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:28,   Align:"Right",   ColMerge:0,   SaveName:"polut_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dg_lbl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dg_lbl_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tml_pck_ut_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		              {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"net_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		              {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"net_wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		              {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"grs_cntr_wgt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"grs_wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Int",       Hidden:0,  Width:74,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		              {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"hzd_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"stwg_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lodg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"dg_cntr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"emer_cntc_pson_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"aply_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:74,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ref_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		     
		    InitColumns(cols);
		    SetSheetHeight(314);
		    SetEditable(1);
        }
		break;
	}
}
/**
* Handling process about Sheet
* @param sheetObj Sheet
* @param formObj form object
* @param sAction job processing code
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	// alert(sAction);
	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction))
		{
			formObj.f_cmd.value=SEARCH;	
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
 			sheetObj.DoSearch("ESM_BKG_0915GS.do", FormQueryString(formObj) );
			
		}
		break;
	case IBSAVE:
		formObj.f_cmd.value=MULTI;	
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		if ( sheetObj.RowCount()== 0 && check == false )
		{
			sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(sheetObj.RowCount(), "cll_dg_seq",sheetObj.RowCount());
			sheetObj.SetCellValue(sheetObj.RowCount(), "vsl_cd",formObj.in_vsl_cd.value);
			sheetObj.SetCellValue(sheetObj.RowCount(), "skd_voy_no",formObj.in_skd_voy_no.value);
			sheetObj.SetCellValue(sheetObj.RowCount(), "skd_dir_cd",formObj.in_skd_dir_cd.value);
			sheetObj.SetCellValue(sheetObj.RowCount(), "port_cd",formObj.in_port_cd.value);
			sheetObj.SetCellValue(sheetObj.RowCount(), "cntr_lodg_no",formObj.in_cntr_lodg_no.value);
			sheetObj.SetCellValue(sheetObj.RowCount(), "cll_dg_seq","0");
			// sheetObj.RowHidden(1) = true;
			// sheetObj.RowStatus(1) = "D";
			// alert(sheetObj.CellValue(sheetObj.RowCount, "ibflag"));
			sheetObj.SetCellValue(sheetObj.RowCount(), "bkg_no",formObj.in_bkg_no.value);
			sheetObj.SetCellValue(sheetObj.RowCount(), "cntr_no",formObj.in_cntr_no.value);
			check=true;
			sheetObj.DoAllSave("ESM_BKG_0915GS.do", FormQueryString(formObj));
			// sheetObj.RowDelete(1, false);
		} else {
			//alert();
			IBS_CopyFormToRow(formObj, sheetObj, formObj.currentSeq.value*1, "form1_");
			sheetObj.DoAllSave("ESM_BKG_0915GS.do", FormQueryString(formObj));
		}
		
		break;		
	case IBINSERT:
		IBS_CopyFormToRow(formObj, sheetObj, formObj.currentSeq.value*1, "form1_");
		sheetObj.DataInsert(-1);
		sheetObj.SetCellValue(sheetObj.RowCount(), "cll_dg_seq",sheetObj.RowCount());
		sheetObj.SetCellValue(sheetObj.RowCount(), "vsl_cd",formObj.in_vsl_cd.value);
		sheetObj.SetCellValue(sheetObj.RowCount(), "skd_voy_no",formObj.in_skd_voy_no.value);
		sheetObj.SetCellValue(sheetObj.RowCount(), "skd_dir_cd",formObj.in_skd_dir_cd.value);
		sheetObj.SetCellValue(sheetObj.RowCount(), "port_cd",formObj.in_port_cd.value);
		sheetObj.SetCellValue(sheetObj.RowCount(), "cntr_lodg_no",formObj.in_cntr_lodg_no.value);
		sheetObj.SetCellValue(sheetObj.RowCount(), "bkg_no",formObj.form1_bkg_no.value);
		sheetObj.SetCellValue(sheetObj.RowCount(), "cntr_no",formObj.form1_cntr_no.value);
		sheetObj.SetCellValue(sheetObj.RowCount(), "dg_cntr_seq",formObj.form1_dg_cntr_seq.value);
		IBS_CopyRowToForm(sheetObj, formObj, sheetObj.RowCount(), "form1_");
		formObj.currentSeq.value=sheetObj.RowCount();
		formObj.totalSeq.value=sheetObj.RowCount();
		ComBtnEnable("btn_save");
		break;		
	case IBDELETE:
		sheetObj.RowDelete(formObj.currentSeq.value*1, false);
		if ( sheetObj.RowCount()> 0 )
		{
			for ( var i=formObj.currentSeq.value*1 ; i<sheetObj.RowCount()+1 ; i++ )
			{
				sheetObj.SetCellValue(i, "cll_dg_seq",i);
			}
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
			if ( sheetObj.RowCount()== 0 )
			{		
				formObj.currentSeq.value="0";
			} else {
				formObj.currentSeq.value="1";
			}
			formObj.totalSeq.value=sheetObj.RowCount();
		} else {
			formObj.currentSeq.value="0";
			formObj.totalSeq.value=sheetObj.RowCount();
		}
		break;
	case COMMAND01:
		if (validateForm(sheetObj, formObj, sAction))
		{			
			var opener = window.dialogArguments;
			if (!opener)
				opener = parent;
			opener.setCheckBox(formObj.rowNum.value, "915", sheetObj.RowCount());
			ComClosePopup(); 
		} else {
			doActionIBSheet(sheetObj, formObj, IBSAVE);
		}
	}
}

function sheet1_OnSearchEnd(sheetObj){
	var formObj = document.form;
	IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
	
	if ( sheetObj.RowCount()== 0 )
	{
		formObj.currentSeq.value="0";
		formObj.form1_bkg_no.value=formObj.in_bkg_no.value;
		formObj.form1_cntr_no.value=formObj.in_cntr_no.value;	
	} else {
		formObj.currentSeq.value="1";
	}
	formObj.totalSeq.value=sheetObj.RowCount();
	state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
	if (state == "S") {
		if (sheetObj.RowCount()> 0 )
		{
			check=false;
			ComBtnEnable("btn_save");
		} else {
			ComBtnDisable("btn_save");
		}
	}
	ComOpenWait(false);
	
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
//    if (ErrMsg != "") return;
//    ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
	ComOpenWait(false);
	state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
	if (state == "S") {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}

/**
 * Handling validity verification process about screen form input value.
 * @param sheetObj Sheet
 * @param formObj form object
 * @param sAction job processing code
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		return true;
		break;
	case IBSAVE:
		return true;
		break;	
	case COMMAND01:
		//Checking whether more than one
		var vIsCheck=true;
		for(var i=1; i <= sheetObj.RowCount(); i++) {
			if (sheetObj.GetRowStatus(i) == "I"||
					sheetObj.GetRowStatus(i) == "U"||
					sheetObj.GetRowStatus(i) == "D") {
				vIsCheck=false;
				break;
			}
		}
		if ( check == false && sheetObj.RowCount()== 0 )
			vIsCheck=false;
		if (!vIsCheck) {
			//ComShowCodeMessage('BKG00265','');
			if ( confirm("Do you want to save your change(s)?") )
			{
				return false;
			}
		}		
		return true;
		break;			
	}
}
/**
* Calling next data
*/
function goNext()
{
	var formObj=document.form;
	IBS_CopyFormToRow(formObj, sheetObjects[0], formObj.currentSeq.value*1, "form1_");
	var nextSeq=formObj.currentSeq.value*1 + 1;
	// alert(sheetObjects[0].RowCount);
	if ( nextSeq*1 <= sheetObjects[0].RowCount())
	{
		IBS_CopyRowToForm(sheetObjects[0], formObj, nextSeq, "form1_");
		formObj.currentSeq.value=nextSeq;
	}
}
/**
* Calling previous data
*/
function goPrev()
{
	var formObj=document.form;
	IBS_CopyFormToRow(formObj, sheetObjects[0], formObj.currentSeq.value*1, "form1_");
	var prevSeq=formObj.currentSeq.value*1 - 1;
	// alert(sheetObjects[0].RowCount);
	if ( prevSeq*1 >= 1)
	{
		IBS_CopyRowToForm(sheetObjects[0], formObj, prevSeq, "form1_");
		formObj.currentSeq.value=prevSeq;
	}
}
