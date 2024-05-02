/*=========================================================
  *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : EES_MNR_0202.js
 *@FileTitle : Tire Purchase Report by Item
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class EES_MNR_0202 : business script for EES_MNR_0202.
 */
/* developer job	*/
// common global variables

var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObject1,formObject,IBCLEAR);
			break;
		case "btn_downexcel":
			doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
			break;
		case "btn_ofc_cd":
			ComOpenPopup("COM_ENS_071.do", 720, 450, 'setPopUpParam_COM_ENS_071', '1,0,1,1,1,1,1,1', true);
			break;				
		case "btn_sup_cd":
			ComOpenPopup("COM_ENS_0C1.do", 700, 550, 'setPopUpParam_COM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
			break;	   					
		case "cre_dt_cal":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
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
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i] , i+1 , "" );
		ComEndConfigSheet(sheetObjects[i]);
	}
	formObj.ofc_cd.value="";
	formObj.sup_cd.value="";   
	formObj.sup_nm.value="";   				
	formObj.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
	MnrSetFromDate(formObj.from_dt,"TIRE");	
	formObj.to_dt.value=ComGetNowInfo();
//	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo,sheetHeadTitle) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      // sheet1 init
		    with(sheetObj){
				  var HeadTitle="|RHQ|Office|Supplier\nCode|Supplier\nName|Brand\nName|Curr||||||||||||";
				  if(MnrNullToBlank(sheetHeadTitle) != ""){
					  HeadTitle=sheetHeadTitle;
	              }
				  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:8, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols =[{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
						 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rhq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ofc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"sup_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:0,   SaveName:"sup_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:0,   SaveName:"brand_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cur",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd01",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd02",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd03",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd04",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd05",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd06",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd07",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd08",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd09",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd10",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd11",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd12",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"cd13",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 }];
	
					InitColumns(cols);

					SetEditable(0);
					cnt=0;
//					SetSheetHeight(380);
					resizeSheet( sheetObj );
				  }


		break;
	}
}
var oldTitle ;
// handling process for sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //retrieving
		if(validateForm(sheetObj,formObj,sAction))
			if ( sheetObj.id == "sheet1"){
				formObj.f_cmd.value=SEARCH;     						
//				sheetObj.DoSearch("EES_MNR_0202GS.do",FormQueryString(formObj) );
				
				var sXml=sheetObj.GetSearchData("EES_MNR_0202GS.do",FormQueryString(formObj));
                var headTitle1=ComGetEtcData(sXml,"TITLE");
                headTitle1="|RHQ|Office|Supplier\nCode|Supplier\nName|Brand\nName|Curr||" + headTitle1;
                oldTitle = headTitle1;
                sheetObj=sheetObj.Reset();
                sheetObjects[0] = sheetObj;
                initSheet(sheetObj,1,headTitle1);
                sheetObj.LoadSearchData(sXml,{Sync:0} );
			}
		break;
	case IBCLEAR:        //initializing
		MnrWaitControl(true);
//		sheetObj.SetWaitImageVisible(0);
		
		
		//initializing sheet   
		
//		for(i=0;i<sheetObjects.length;i++){
//			alert(sheetObjects[i].id);
//			sheetObjects[i].RemoveAll();
//			sheetObjects[i].Reset();
//			initSheet(sheetObjects[i] , i+1 , "" );
//		}
		location.reload();
//		formObj.ofc_cd.value="";
//		formObj.sup_cd.value="";   
//		formObj.sup_nm.value="";   				
//		formObj.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
//		MnrSetFromDate(formObj.from_dt,"TIRE");	
//		formObj.to_dt.value=ComGetNowInfo();
//		sheetObj.SetWaitImageVisible(1);
		MnrWaitControl(false);   			    
		break;
	case IBDOWNEXCEL:
		 if(sheetObj.RowCount() < 1){//no data
			  ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			}
		break;			    
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if(sAction==IBSEARCH) {	  	    
			if(!MnrChkFromDate(formObj.from_dt,"TIRE")) return false;
		}  	
	}
	return true;
}
function setPopUpParam_COM_ENS_071(array) {
	if(array == null)return;
	var formObj=document.form;
	var str=array + "";	
	var arr=str.split(',');
	formObj.ofc_cd.value=arr[3];
}   
/**
 * (Service Provider) handling Pop-up Return Value<br>
 * @param {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row IBSheet Row index
 * @param Col IBSheet Col index
 * @param Sheet Array index 
 */
function setPopUpParam_COM_ENS_0C1(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;   
	if ( aryPopupData.length > 0 ) {
		formObj.sup_cd.value=aryPopupData[0][2];
		formObj.sup_nm.value=aryPopupData[0][4];
	}
}    
/**
 * handling after retrieving
 */	
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	var row=sheetObj.RowCount();
//	var HeadTitle1=sheetObj.GetEtcData("TITLE");
//	HeadTitle1="|RHQ|Office|Supplier\nCode|Supplier\nName|Brand\nName|Curr||" + HeadTitle1;
//	changeHeaderRow(sheetObj, 0, HeadTitle1);
	if(sheetObj.RowCount()> 0){
		for(var i=0; i<21; i++){
			if(sheetObj.GetCellValue(0,i) == 'N'){
				sheetObj.SetColHidden(i,1);
			}
		}
		
		sheetObj.DataInsert(-1);
        sheetObj.DataInsert(-1);
        sheetObj.DataInsert(-1);
    	
        sheetObj.SetCellValue(row + 1,7,"QTY",0);
        sheetObj.SetCellValue(row + 1,1,"TOTAL",0);
        sheetObj.SetCellValue(row + 2,7,"AMT",0);
        sheetObj.SetCellValue(row + 3,7,"AVG",0);
        
		//AVG
		for(var j=8; j<21; j++){       
			var sumQty = 0;
        	var sumAmt = 0;
        	for(var k=sheetObj.HeaderRows(); k <= row; k++){
        		if(sheetObj.GetCellValue(k, 7) == "QTY"){
        			sumQty = sumQty + sheetObj.GetCellValue(k, j);
        		}else if(sheetObj.GetCellValue(k, 7) == "AMT"){
        			sumAmt = sumAmt + sheetObj.GetCellValue(k, j);
        		}
        	}
			
        	sheetObj.SetCellValue(row+1, j, sumQty);
        	sheetObj.SetCellValue(row+2, j, sumAmt);
        	
			if(sheetObj.GetCellValue(row+1,j) == 0){
				sheetObj.SetCellValue(row+3,j,0,0);
			}else{
				var avg1=sheetObj.GetCellValue(row + 2,j) / sheetObj.GetCellValue(row + 1,j);   // (TOTAL)AMT / (TOTAL)QTY
                var avg2=Math.round(avg1*100)/100;                                      // Rounding to two decimal digits
                sheetObj.SetCellValue(row + 3,j,avg2,0);
			}       			
		}
		sheetObj.SetRangeBackColor(row+1, 0, row+3, sheetObj.LastCol(), "#FFA7A7");
		sheetObj.SetRangeFontBold(row+1, 0, row+3, sheetObj.LastCol(), 1);
		sheetObj.SetSelectRow(1);
	}	    	    	
}
/* developer job */