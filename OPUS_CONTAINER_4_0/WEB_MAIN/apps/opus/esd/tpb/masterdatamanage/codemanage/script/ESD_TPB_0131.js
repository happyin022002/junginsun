/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0131.jsp
*@FileTitle  : CodeManage
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var curTab=1;
var beforetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
/**
 * @extends 
 * @class ESD_TPB_0131 : business script for ESD_TPB_0131
 */
/**
 * Setting IBTab Object Initial.
 * Tab ID is tab1,tab2,...
 * InitTab() function is called before the loadPage() function call from setupPage() function.
 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertItem( "Dry Index" , "");
				InsertItem( "Tanker Index" , "");
				InsertItem( "Time Charter" , "");
				InsertItem( "Bunker Price" , "");
				InsertItem( "Ship Price" , "");
				InsertItem( "FFA Index" , "");
		}
	}catch(e){
		ComShowMessage(e.message);
	}
}
/**
 * onChange event of tab1
 * Implementing defined function from IBSheetConfig.js
 */
function tab1_OnChange(nItem){
	ChangeTab(document.all.tab1,nItem);
}
/**
 * Showing tab contents in case of clicking IBTab Object
 * ID of Grouped each tab DIV TAG defined "tabLayer"
 */
function ChangeTab(tabObj,nItem){
	tabObj.SetBackColor("#FFFFFF");
	var objs=document.all.item("tabLayer");
	objs[beforetab].style.display="none";
	objs[nItem].style.display="Inline";
	//--------------- Notice --------------------------//
	//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//Not a click button in case of zIndex under 2
	objs[beforetab].style.zIndex=0;
	objs[nItem].style.zIndex=9;
	//------------------------------------------------------//
	beforetab=nItem;
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
	   	//Setting startup environment. Change the name of the function
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//Setting final environment.
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	sheetObj.UseUtf8=true;
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with(sheetObj){
				var cnt=0;
				var HeadTitle="Del.|STS|I/F Type|Expense Type|Code|Name|Description|SCEM Exception Case|Interfaced To|Active\nFlag";

				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:3, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Combo",     Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"n3pty_if_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
	             {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"n3pty_expn_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
	             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
	             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"n3pty_bil_tp_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
	             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"expt_cs_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cml_sys_if_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"act_flg",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
       
				InitColumns(cols);

				SetEditable(1);
                SetColProperty("act_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
                getTPBGenCombo('s_billing_case_cd','searchBillingCaseCode','F','','1');
			    SetColHidden(0,1);
			    SetColHidden(1,1);
			    SetColProperty("n3pty_expn_tp_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
				SetColProperty("cml_sys_if_cd", {ComboText:combo02Text, ComboCode:combo02Code} );
				SetColProperty("n3pty_if_tp_cd", {ComboText:combo03Text, ComboCode:combo03Code} );
				//SetSheetHeight(460);
				ComResizeSheet(sheetObjects[0]);    
	      }
		break;
	}
}
/* Event handler defined process to button click event */
document.onclick=processButtonClick;
/* Event handler is branch processing by name of button */
function processButtonClick(){
	 /***** Assignment sheet in case of over 2 by tab ****/
 var sheetObject=sheetObjects[curTab-1];
 /******************************************************/
 var formObject=document.form;
 if(curTab == 2)
	formObject=document.form2;
 try {
	var srcName=ComGetEvent("name");
	switch(srcName) {
		case "btn_downexcel":
			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
	} // end switch
 }catch(e) {			
	if( e == "[object Error]") {
		ComShowMessage(getMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/* Processing Sheet */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	   case IBSEARCH:	  //Retrieve
		   if(!validateForm(sheetObj,formObj,sAction)) {
			   return false;
		   }
		   formObj.f_cmd.value=SEARCH;
		   sheetObj.DoSearch("ESD_TPB_0131GS.do", tpbFrmQryStr(formObj) );
		   break;
	   case IBDOWNEXCEL:  //Excel download
		   if(sheetObj.RowCount() < 1){//no data
			   ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel(TPBDown2ExcelOptions);
				}
			break;
	}
}
/**
 * Checking validation of input value
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	   if(!ComChkValid(formObj)) return false;
	}
	return true;
}
/**
 * Processing function in case of error to result of retrieve
 * Defined by DataSheetObject.prototype.event_OnSearchEnd
 */
function sheet1_OnSearchEnd(sheetObj,errMsg){
	//if(errMsg!=null){
//ComShowMessage(errMsg);
//}
}
/**
 * Defined by DataSheetObject.prototype.event_OnSaveEnd
 */
function sheet1_OnSaveEnd(sheetObj,errMsg){
	if(errMsg==null || errMsg == ''){
		ComShowMessage(getMsg('COM12149','Data','',''));
	}
	IBS_EtcDataToForm2(document.form, sheetObj);
	getTPBGenCombo('s_billing_case_cd','searchBillingCaseCode');
}
function sheet1_OnChange(sheetObj,Row,Col,Value){
	_sheet_onchange( sheetObj,Row,Col,Value );
	var selectValue="";
	if(sheetObj.GetCellValue(Row,'ibflag') == 'I'
		&& sheetObj.GetCellValue(Row,'n3pty_bil_tp_cd') != ""
			&& (sheetObj.ColSaveName(Col) == "n3pty_bil_tp_cd"|| sheetObj.ColSaveName(Col) == "n3pty_expn_tp_cd") ){
		var selectValue=sheetObj.GetCellValue(Row,'n3pty_bil_tp_cd');
		var s_codeAll=document.form.s_codeAll.value;
		var s_y=selectValue + "|Y";
		var s_n=selectValue + "|N";
		if(s_codeAll.indexOf(s_y) != -1){
			ComShowMessage(getMsg('TPB90016','','',''));
			sheetObj.SetCellValue(Row,'n3pty_bil_tp_cd',"",0);
		}else if(s_codeAll.indexOf(s_n) != -1){
			ComShowMessage(getMsg('TPB90017','','',''));
		}
	}
}
/**
 * Checking duplication of code
 */
function checkTPBCode(sheetObj){
		var insertRow=new Array();
		for ( var i=0; i <= sheetObj.RowCount(); i++ ){
			if(sheetObj.GetCellValue(i,'ibflag') == 'I'){
				insertRow[insertRow.length]=sheetObj.GetCellValue(i,'n3pty_bil_tp_cd');
			}
		}
		if(insertRow.length > 0){
			for ( var i=0; i <= sheetObj.RowCount(); i++ ){
				for(var j=0 ; j<insertRow.length;j++){
					if(insertRow[j] != '' && 
					sheetObj.GetCellValue(i,'ibflag') != 'I' &&
					sheetObj.GetCellValue(i,'n3pty_bil_tp_cd') == insertRow[j]){
					return false;
				}
			}
		}
	}
	return true;
}
/* Finishing work */
