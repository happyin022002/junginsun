/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : Esm_BKG_0455.js
*@FileTitle  : SEA-NACCS_B/L Correction_Container Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/30
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* Start of developer's work*/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /** **************************************************** */
    var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
       switch(srcName) {
	          case "btn_save":
	        	  doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	        	  break; 
	          case "btn_close":
	        	  doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	        	  break;
	          case "btn_add":
	        	  doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
					break;
	          case "btn_delete":
	        	  doActionIBSheet(sheetObjects[0], document.form, IBDELETE);      	
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
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo sequence of sheet Object
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	var sheetID=sheetObj.id;
    switch(sheetID) {
		case "sheet1":      //sheet1 init
		    with(sheetObj){
				
				//no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				var HeadTitle1="|Sel.|Seq.||CONTAINER|Type|SEAL No|P|R / D|R / D|Empty/Full|Supplied";

			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_no" },
			             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14,  AcceptKeys:"E|N" , InputCaseSensitive:1},
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 ,  AcceptKeys:"E|N" , InputCaseSensitive:1},
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20,AcceptKeys:"E|N" , InputCaseSensitive:1},
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, AcceptKeys:"E|N" , InputCaseSensitive:1},
			             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1,AcceptKeys:"E|N" , InputCaseSensitive:1},
			             {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"jp_cntr_ownr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetColProperty(0,"prt_flg", {ComboText:"N|Y" , ComboCode:"N|Y"} );
			      SetColProperty(0,"full_mty_cd", {ComboText:"Empty|Full", ComboCode:"E|F"} );
			      SetColProperty(0,"jp_cntr_ownr_cd", {ComboText:"Shipper|Carrier" , ComboCode:"1|2"} );
			      SetCountPosition(0);
			      SetSheetHeight(205);
			}
            break;
    }
}
/**
* handling of Sheet 
* @param sheetObj Sheet
* @param formObj formb object
* @param sAction code
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSAVE:
			if (validateForm(sheetObj, formObj, sAction))
			{
				sheetObj.SetCellValue(1,"bl_no",formObj.bl_number.value);
				formObj.f_cmd.value=MULTI;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoAllSave("ESM_BKG_0455GS.do", {Param:FormQueryString(formObj),Col:"sel",Quest:"false",UrlEncode:"true", Sync:1} );
				state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
				
			}
			break;			
		case IBSEARCH: 
			if (validateForm(sheetObj, formObj, sAction))
			{
				formObj.f_cmd.value=SEARCH;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);	
				sheetObj.DoSearch("ESM_BKG_0455GS.do", FormQueryString(formObj), {Sync:2} );
				ComOpenWait(false);
			}			
			break;
		case COMMAND01: 
//			ComClosePopup(); 
			var opener = window.dialogArguments;
			if (!opener) opener = parent;
			var vIsCheck = true
			for(var i=1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.RowStatus(i) == "I"||
					sheetObj.RowStatus(i) == "U"||
					sheetObj.RowStatus(i) == "D") {
					vIsCheck = false;
					break;
				}
			}
			if (vIsCheck) {
				opener.retrieve();
				ComClosePopup();
        		break;
			}			
			
			if (!validateForm(sheetObj, formObj, sAction))
			{			
				opener.retrieve();
				ComClosePopup();
			} else {
				formObj.f_cmd.value = MULTI;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.DoAllSave("ESM_BKG_0455GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}
			break;	
		case IBDELETE: 
			if (validateForm(sheetObj, formObj, sAction))
			{							
				ComRowHideDelete(sheetObj, "del_chk");
	        	sheetObj.CheckAll("del_chk",0,1);
			}	
			break;	
		case IBINSERT: 
			sheetObj.DataInsert(-1);
			for (var i=1 ; i <= sheetObj.RowCount(); i++){
				sheetObj.SetCellValue(i,3,formObj.bl_number.value);
			}
			break;			
	}
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	ComOpenWait(false);
	
	if (state == "S") {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}	
	
}
/**
* handling process for input validation
* @param sheetObj Sheet
* @param formObj form object
* @param sAction code
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	case IBSAVE:
		var vIsCheck=false;
		vIsCheck=validCheck(sheetObj);
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00260','');
			return false;
		}		
		return true;
		break;	
	case COMMAND01:
		var vIsCheck=false;
		vIsCheck=validCheck(sheetObj);
		if (!vIsCheck) {
			if ( !ComShowCodeConfirm("BKG00350") )
			{
				return false;
			}
		}		
		return true;
		break;	
	case IBDELETE: 
		var vIsCheck=false;
		for(var i=1; i <= sheetObj.RowCount(); i++) {
			if (sheetObj.GetCellValue(i, "del_chk") == 1) {
				vIsCheck=true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249','');
			return false;
		}			
		if (!ComShowCodeConfirm("COM12188")) {
			return false;
		}		
		return true;
		break;		
	case IBSEARCH:
		return true;
		break;			
	}
}
/**
* checking modification at sheet
* @param sheetObj Sheet
*/
function validCheck(sheetObj)
{
	for(var i=1; i <= sheetObj.RowCount(); i++) {
		if (sheetObj.GetRowStatus(i) == "I"||
			sheetObj.GetRowStatus(i) == "U"||
			sheetObj.GetRowStatus(i) == "D") {
			return true;
		}
	}
	return false;
}
/**
* checking mandatory column at Sheet
* @param sheetObj Sheet
* @param Row Row
* @param Col Col
* @param Value Value
*/
function sheet1_OnValidation(sheetObj,Row,Col,Value)
{
	switch(Col)
	{
		case 4:
			if ( sheetObj.GetRowStatus(Row) != "D" )
			{
				if ( Value=="" )
				{
					ComShowCodeMessage('BKG01028');
					sheetObj.ValidateFail(true);
					sheetObj.SelectCell(Row, Col);
					return false;
				}		
			}
			break;
	}
}
