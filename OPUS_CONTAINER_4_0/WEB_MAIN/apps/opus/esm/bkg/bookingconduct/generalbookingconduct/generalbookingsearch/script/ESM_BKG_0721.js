/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0721.js
*@FileTitle  : Cut Off Time
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1="sheet1_";
// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {                     
			case "btn_save":
				if (validateForm(sheetObject,document.form,IBSAVE)){
					doActionIBSheet(sheetObject,document.form,IBSAVE);
				}
            break;
			case "btn_close": 
				var bflag=true;
				if (formObject.modifyFlag.value=="Y"){ 
					bflag=ComShowCodeConfirm("BKG00168");
				}
				if (bflag){
					ComClosePopup(); 
				}else{							
				}					
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
	for(i=0;i<sheetObjects.length;i++){
 		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
    } 
	if (!ComIsNull(document.form.bkg_no)){
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}	
}
 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	var sheetId=sheetObj.id;
    switch(sheetId) {
        case "sheet1":
        	with(sheetObj){
	        	var HeadTitle1="| | |Port(s)/Yard|System Time|System Time|Manual Update Time|Manual Update Time|Updated by|Notice";
	
	        	SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	InitHeaders(headers, info);
	
	        	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			        	     {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"nmtp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"clz_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"systemdate",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"systemtime",        KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"manualupdate",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"manualupdatetime",  KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mnl_set_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			        	     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ntc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",FalseValue:"N"},
			        	     {Type:"Text",      Hidden:1, Width:100,  Align:undefined, ColMerge:0,   SaveName:"clz_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:1, Width:100,  Align:undefined, ColMerge:0,   SaveName:"updatebyname",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:1, Width:100,  Align:undefined, ColMerge:0,   SaveName:"mnl_set_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:1, Width:100,  Align:undefined, ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	
	        	InitColumns(cols);
	
	        	SetEditable(1);
	        	SetCountPosition(0);
	        	SetEditEnterBehavior("tab");
	        	SetDataLinkMouse("mnl_set_usr_id", 1);
	        	SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
	        	SetMergeSheet(msPrevColumnMerge + msHeaderOnly);
        	}


            break;
    }
}
/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return void
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
	var arrPreFix=new Array("sheet1_");
    switch(sAction) {
      	case IBSEARCH:      //retrieve
			 formObj.f_cmd.value=SEARCH; 
			 var sXml=sheetObj.GetSearchData("ESM_BKG_0721GS.do", "f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value);
			 sheetObj.LoadSearchData(sXml);
			 formObj.vvd.value=ComGetEtcData(sXml,"vvd");
			 formObj.pol.value=ComGetEtcData(sXml,"pol");
			 formObj.etb.value=ComGetEtcData(sXml,"etb");
			 formObj.etd.value=ComGetEtcData(sXml,"etd");
			 formObj.modifyFlag.value="N";
		break;
      	case IBSAVE:        
			formObj.f_cmd.value=MULTI; 
			for(var i=1;i<=sheetObj.LastRow();i++){
				sheetObj.SetCellValue(i,"ibflag","U");
				if(sheetObj.GetCellValue(i,"manualupdatetime").length<4 && sheetObj.GetCellValue(i,"manualupdate").length>0){
					sheetObj.SetCellValue(i,"manualupdatetime","00:00",0);
				}
				sheetObj.SetCellValue(i,"mnl_set_dt",sheetObj.GetCellValue(i,"manualupdate")+ sheetObj.GetCellValue(i,"manualupdatetime"),0);
				sheetObj.SetCellValue(i,"bkg_no",ComGetObjValue(formObj.bkg_no));
			}
			var sParam="f_cmd="+MULTI+"&"+ComGetSaveString(sheetObj);
			if (sParam == "") return; 
			
			/*var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0721GS.do", sParam);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
        	if(State == "S"){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			} else {
				sheetObj.LoadSaveData(sXml);
			}*/
			var rData=sheetObjects[0].GetSaveData("ESM_BKG_0721GS.do", sParam);
			sheetObjects[0].LoadSaveData(rData);
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		break;
    }
}

/**
 * handling process for input validation <br>
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return boolean
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSAVE:				
			if(ComIsNull(formObj.bkg_no)){
				ComShowCodeMessage("BKG00835"); 
				return false;
			}
			if (sheetObj.GetCellValue(2,"manualupdate").length>0){
				if (sheetObj.GetCellValue(2,"manualupdate")<ComParseInt(ComReplaceStr(formObj.etb.value.substring(0,10)))){
					return false; 
				}
			}
			if(sheetObj.GetCellValue(3,"manualupdate").length>0){
				if (sheetObj.GetCellValue(3,"manualupdate")<ComParseInt(ComReplaceStr(formObj.etb.value.substring(0,10)))){
					ComShowCodeMessage("BKG00079"); 
					return false; 
				}
			}
			if(sheetObj.GetCellValue(6,"manualupdate").length>0){
				if (sheetObj.GetCellValue(6,"manualupdate")<ComParseInt(ComReplaceStr(formObj.etb.value.substring(0,10)))){
					ComShowCodeMessage("BKG00079"); 
					return false; 
				}
			}
			if(ComGetObjValue(formObj.bdr_Flag) =='Y'){
				ComShowCodeMessage("BKG00106");
				return false;
			}
		break; 
	} 
    return true;
}

/*
* bkg_clz_tm table key value inserts at grit
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	with(sheetObj){
	    if (sheetObj.LastRow()>=3) sheetObj.SetCellBackColor(3, "manualupdatetime","#EFEBEF");
		if (sheetObj.LastRow()>=4) sheetObj.SetCellBackColor(4, "manualupdatetime","#EFEBEF");
		for (i=HeaderRows();i<HeaderRows()+RowCount();i++){
		   SetCellValue(i,"bkg_no",document.form.bkg_no.value);
		   SetCellValue(i,"mnl_set_dt",GetCellValue(i,"manualupdate")+GetCellValue(i,"manualupdatetime"),0);
		   
		   if(GetCellValue(i,"nm")==GetCellValue(i,"nmtp")){
			   SetMergeCell(i, 1, 1, 2);
		   }
	   	}
		sheetObj.SetCellEditable(sheetObj.LastRow(),"manualupdate", 0);
		sheetObj.SetCellEditable(sheetObj.LastRow(),"manualupdatetime", 0);
		sheetObj.SetCellEditable(sheetObj.LastRow(),"ntc_flg", 0);
		formObj.modifyFlag.value="N";
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	with(sheetObj){   
		document.form.modifyFlag.value="Y";	
		if (ColSaveName(Col) =="manualupdate"){
			if(ComIsNull(Value)){
				SetCellValue(Row,"manualupdate","",0);
				SetCellValue(Row,"manualupdatetime","",0);
				SetCellValue(Row,"mnl_set_dt","",0);
			} else {
				if(GetCellValue(Row,"manualupdatetime").length<4){
					SetCellValue(Row,"manualupdatetime","00:00",0);
				} else {
					SetCellValue(Row,"mnl_set_dt",GetCellValue(Row,"manualupdate")+ GetCellValue(Row,"manualupdatetime"),0);
				}
			}
		}
		if (ColSaveName(Col) =="manualupdatetime"){
			if(GetCellValue(Row,"manualupdatetime").length<4){
				SetCellValue(Row,"manualupdatetime","00:00",0);
			} else {
				SetCellValue(Row,"mnl_set_dt",GetCellValue(Row,"manualupdate")+ GetCellValue(Row,"manualupdatetime"),0);
			}		
		}	
	}		
}
/*
* grid selection focus event
*/
function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
	with(sheetObj){  
		if (ColSaveName(NewCol) =="mnl_set_usr_id"){
			SelectCell(NewRow+1,"manualupdate",false);
		}
	}
}
/*
* Modified or not, depending on whether the check box
*/
function sheet1_OnBeforeCheck(sheetObj,Row,Col){ 		 

}
