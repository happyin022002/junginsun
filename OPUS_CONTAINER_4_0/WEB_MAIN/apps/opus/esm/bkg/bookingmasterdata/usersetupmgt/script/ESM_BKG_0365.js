/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_bkg_0365.js
*@FileTitle  : Mark & Description Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ui_bkg_0365 : business script for ui_bkg_0365
     */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var cur_usr_id='';
	var cur_ofc_cd='';
	var returnObject='';
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
     /***** using extra sheet valuable if there are more 2 sheets *****/
     var sheetObject1=sheetObjects[0];
     //var sheetObject2 = sheetObjects[1];
     /*******************************************************/
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		
        switch(srcName) {
				case "marks_type":
					var mk_type=ComGetEvent("value");
					filteredData(sheetObject1, mk_type);
                break;
				case "btn_office":
					var ofc_cd=sheetObject1.GetEtcData("ofc_cd");
					var url="ESM_BKG_0922.do?func=callbackOffice&ofc_cd="+cur_ofc_cd;
//					if (!ComIsEmpty(ofc_cd)) {
//						url="ESM_BKG_0922.do?func=callbackOffice&ofc_cd="+ofc_cd;
//					}
					ComOpenWindow(url, "ESM_BKG_0922", "dialogWidth:500px;dialogHeight:290px;", true);
                break;
				case "btn_rowAdd":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
                break;
				case "btn_delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
                break;
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;
				case "btn_select":
					doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
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
 * adding first-served functions after loading screen.
 */
function loadPage() {
	if (!opener) opener=window.dialogArguments;
	if (!opener) opener=parent; //이 코드 추가할것
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	// set init-data for sheets
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

}
 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
		case 1:      //sheet1 init
		      with(sheetObj){
		         var HeadTitle1="|Sel|Template Seq.|Template Type|Template Name|Contents";
		
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		         InitHeaders(headers, info);
		
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",        Wrap:1 },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel",           Wrap:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tmplt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tmplt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"tmplt_hdr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"tmplt_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2000,  Wrap:1 } ];
		          
		         InitColumns(cols);
		
		         SetEditable(1);
		         SetCountPosition(0);
	            SetSheetHeight(220);
             }
		break;
    }
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){

	var formObj=document.form;
	var mk_type=getRadioValue(formObj.marks_type);
	filteredData(sheetObj, mk_type);

}



// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
		case IBSEARCH:      //retrieve
			if(validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0365GS.do", FormQueryString(formObj) );
			}

		break;
		case IBINSERT:     
			var newRow=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(newRow, "tmplt_tp_cd", getRadioValue(formObj.marks_type) , 0);//formObj.tmplt_tp_cd.value;
		break;
		case IBDELETE:      
			ComRowHideDelete(sheetObj, "sel");
		break;
		case IBSAVE:        
			if(validateForm(sheetObj,formObj,sAction)) {
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("ESM_BKG_0365GS.do", FormQueryString(formObj), -1, false, true);
			}
		break;
		case IBCOPYROW:
			if(validateForm(sheetObj,formObj,sAction)) {
				if(returnObject == undefined || returnObject == null){
				}else{
					var arrRow=ComFindText(sheetObj, "sel", 1);
					if(formObj.tmplt_tp_cd.value == 'T'){
						returnObject.value=chekcSpecialValue(sheetObj.GetCellValue(arrRow[0], "tmplt_ctnt"));	//특수문자 제외 로직 추가
//						returnObject.value=sheetObj.GetCellValue(arrRow[0], "tmplt_ctnt");
					}else{
						returnObject.value += chekcSpecialValue(sheetObj.GetCellValue(arrRow[0], "tmplt_ctnt"));
//						returnObject.value += sheetObj.GetCellValue(arrRow[0], "tmplt_ctnt");
					}
					opener.document.form.dirty_flag.value="Y";
					ComClosePopup(); 
				}
			}
		break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj,sAction){
	switch(sAction) {
		case IBSEARCH:      //retrieve
		break;
		case IBSAVE:        
			if(!confirm(ComGetMsg("BKG00498"))) {
				return false;
			}
			if(cur_usr_id == '') {
				ComShowMessage(ComGetMsg("BKG00768"));
				return false;
			}
		break;
      	case IBCOPYROW:     
		    var arrRow=ComFindText(sheetObj, "sel", 1);
			//alert(arrRow);
			if(arrRow.length == 0) {
				ComShowMessage(ComGetMsg("BKG08040"));
				return false;
			}
			if(arrRow.length > 1) {
				ComShowMessage(ComGetMsg("BKG08040"));
				return false;
			}
        break;
	}
    return true;
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	if(!opener) opener=window.dialogArguments;
	if(!opener) opener=parent; //이 코드 추가할것
	opener.doActionIBSheet(opener.sheetObjects[1], opener.document.form, SEARCH01);	
}
function filteredData(sheetObj, mkType){
	var cnt=sheetObj.RowCount();
	for (ix=1; ix <= cnt; ix++) {
		if(sheetObj.GetRowStatus(ix) == 'D') continue;
		//alert("* " + ix + " : " + mkType + " = " + sheetObj.CellValue(ix, "tmplt_tp_cd"));
		if(sheetObj.GetCellValue(ix, "tmplt_tp_cd") == mkType){
			sheetObj.SetRowHidden(ix,0);
		}else{
			sheetObj.SetCellValue(ix, "sel",0);
			sheetObj.SetRowHidden(ix,1);
		}
	}
}
function callbackOffice(retVal){
	//alert(retVal);
	if(retVal == undefined || retVal.length == 0) return;
	//HEAD OFFICE,SEOUL|$$|25-11,YOIDO-DONG, YOUNGDEUNGPO-KU, SEOUL, KOREA|$$|KR|$$|82-2-3770-6114|$$|82-2-3770-6747
	var rets=retVal.split("|$$|");
	//
	var nrow=sheetObjects[0].DataInsert(-1);
	sheetObjects[0].SetCellValue(nrow, "tmplt_tp_cd",getRadioValue(document.form.marks_type),0);
	sheetObjects[0].SetCellValue(nrow, "tmplt_hdr_nm",rets[0],0);
	sheetObjects[0].SetCellValue(nrow, "tmplt_ctnt",rets[1] + '\n' + rets[2] + '\nTel: ' + rets[4] + '\nFax: ' + rets[5],0);
}
//===================================
