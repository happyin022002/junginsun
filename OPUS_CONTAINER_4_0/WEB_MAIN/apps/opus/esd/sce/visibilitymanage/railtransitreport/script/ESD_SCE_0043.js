﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : ESD_SCE_0043.js
*@FileTitle  : Car Location Message Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
var PageNo=1 ;
document.onclick=processButtonClick;

function remoteOperation(r_row_size,r_cntr_no,r_toDate,r_fmDate) {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	loadPage();
	formObj.row_size.value=r_row_size;
	formObj.cntr_no.value=r_cntr_no;
	formObj.arr_dt1.value=r_toDate; 
	formObj.arr_dt2.value=r_fmDate;
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}

function processButtonClick() {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
            case "btn_new":
            	sheetObj.RemoveAll();
            	formObj.reset();
            	formObj.arr_dt1.value=formObj.r_fmDate.value;
            	formObj.arr_dt2.value=formObj.r_toDate.value;
                break;	
	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
			case "btns_calendar":
	            var cal=new ComCalendarFromTo();
	            cal.displayType="date";
	            cal.select(form.arr_dt1,  form.arr_dt2,  'yyyy-MM-dd');
				break ;
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
	for(i=0; i<sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with(sheetObj) {
				var HeadTitle="SEQ|F/M|Event|Current|Current|Current|Current|Current|Carrier|MD|Rail Origin|Rail Origin|Rail Destination|Rail Destination|Rail Destination|Train/Truck|Flat Car|BKG NO|WBL NO|Pick-up No|Received Date";
				var HeadTitle1="SEQ|F/M|Event|Location|Description|State|Event Date|Event Date|Carrier|MD|Location|State|Location|State|Description|Train/Truck|Flat Car|BKG NO|WBL NO|Pick-up No|Received Date";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"},
				                { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Seq",   Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,  CalcLogic:"",   Format:"engup",  PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",       KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clm_sght_abbr_nm",  KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",            KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"arr_loc_nm",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_ste_cd",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Date",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"arr_date",          KeyField:0,  CalcLogic:"",   Format:"Ymd",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_time",          KeyField:0,  CalcLogic:"",   Format:"Hm",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clm_crr_nm",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_tp_cd",    KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_ste_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_ste_cd",         KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"dep_loc_nm",        KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trn_no",            KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fcar_no",           KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wbl_no",            KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no",           KeyField:0,  CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Date",  Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",            KeyField:0,  CalcLogic:"",   Format:"YmdHms", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
				InitColumns(cols);
				SetEditable(0);
				SetRangeBackColor(1, 3, 1, 14,"#555555");
				resizeSheet(); 
	      	}
		    break;
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:	  //조회
			if(validateForm(sheetObj,formObj,sAction)) {
				formObj.f_cmd.value=SEARCHLIST ;
				sheetObj.DoSearch("ESD_SCE_0043GS.do",  FormQueryString(formObj)+"&i_page=1" );
		        ComEtcDataToForm(formObj, sheetObj);//만들어진 ETC-DATA 를 화면단으로 불러 붙인다.				
			}
			break;
		case IBDOWNEXCEL:		// excel down
			if(validateForm(sheetObj,formObj,sAction)) {
				if(sheetObj.RowCount() < 1) { //no data
					ComShowCodeMessage("COM132501");
				} else {
					sheetObj.Down2Excel( { Merge:1, HiddenColumn :1 } );
				}
			}
			break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var result=true;
	switch(sAction) {
		case IBSEARCH:
			if(ComIsEmpty(formObj.cntr_no)) {
				ComShowMessage(ComGetMsg('COM12114', "Container No"));
				formObj.cntr_no.focus();
				result=false;
			} else if(!ComChkLenByByte(formObj.cntr_no, 14)) {
				ComShowMessage(ComGetMsg('COM12142', "Container No", 14));
				result=false;
			} else if(!ComIsDate(formObj.arr_dt1)) {
		        ComShowMessage(ComGetMsg('COM12132','Duration'));
		        formObj.arr_dt1.focus();
		        result=false;
		    } else if(!ComIsDate(formObj.arr_dt2)) {
		        ComShowMessage(ComGetMsg('COM12132','Duration'));
		        formObj.arr_dt2.focus();
		        result=false;
		    }
	   		break;
		default :
			break; 
	}
	return result;
}

var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    var formObj=document.form;
    selectVal=SceFrmQryString(formObj);
    sheetObj.DoSearch("ESD_SCE_0043GS.do",  selectVal+"&"+ "i_page=" + PageNo,{Append:true}  );
}

function chkLenth(obj, len, msg) {
	var result=true;
	if(ComGetLenByByte(obj.value)!= len) {
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
        obj.focus();
        result=false;
	}
	return result;
}

function CheckDigit(obj) {
    var rtnval=cntrCheckDigit(obj);
    obj.value=rtnval;
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
} 