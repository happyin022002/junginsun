/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0023.jsp
*@FileTitle  : Add Carriers
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
*=========================================================--
*/
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_close": 
				ComClosePopup(); 
				break;
			case "btn_add":
				var bsaOpCd=formObject.bsa_op_cd.value;
				var param="?bsa_op_cd=" + bsaOpCd;
				ComOpenPopup("/opuscntr/ESM_BSA_0120.do"+param, 406, 400,'getCrrCd', '1,0,1,1,1,1,1,1',false);
				break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
 }
/**
* calling funtion in case of popup close
*
*/
function getCrrCd(rArray){
	var cArray=rArray[0];
	if (cArray[2] != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  
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
	var formObj=document.form;
	for (i=0; i<sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1, "");
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sXml=formObj.sXml.value;
	var arrXml=sXml.split("|$$|");
	var rtnArr=null;
	var codeArr=null;
	var nameArr=null;
	var bsa_op_jb=formObj.bsa_op_cd.value;
	if (arrXml.length > 0)
		rtnArr=ComXml2ComboString(arrXml[0], "code", "name");
	codeArr=rtnArr[0].split("|");
	nameArr=rtnArr[1].split("|");
	for(var i=0; i< codeArr.length; i++){
		if( bsa_op_jb == codeArr[i] ){
			formObj.bsa_op_nm.value=nameArr[i];
		}
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  
}
var UOC=3;  // numbers of field counting
var fixCnt=2;  // numbers of column counting with fixed length 
var varCnt=27; //numbers of column counting with variable length
var totCnt=fixCnt + varCnt; //numbers of total column counting=numbers of column counting with fixed length + numbers of column counting with variable length
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo,header) {
	var arrHeader="";
	switch(sheetNo) {
		case 1:      //sheet1 init
			    with(sheetObj){
				  	if (header == "") { //UOC Dependent
	                  header="|CRR1|CRR1|CRR1" + "|CRR2|CRR2|CRR2" + "|CRR3|CRR3|CRR3"
	                  + "|CRR4|CRR4|CRR4" + "|CRR5|CRR5|CRR5" + "|CRR6|CRR6|CRR6"
	                  + "|CRR7|CRR7|CRR7" + "|CRR8|CRR8|CRR8" + "|CRR9|CRR9|CRR9";
	                }
	                  arrHeader=header.split("|");
	                  varCnt=arrHeader.length -1;
	                  totCnt=fixCnt + varCnt;
				      var HeadTitle="STS|JOB CD" + header;
				      var cnt=0;
	
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
	
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
	
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"bsa_op_jb_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      for (var i=0; i<(varCnt/UOC) ; i++) {
					      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"D_ibflag"+i,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"D_bsa_op_cd"+i, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					      cols.push({Type:"CheckBox",  Hidden:0, Width:42,   Align:"Center",  ColMerge:1,   SaveName:"D_aply_flg"+i,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" });
				      }
				      InitColumns(cols);
				      SetEditable(1);
//				      SetHeaderRowHeight(10);
				      SetSheetHeight(220);
				      
				      SetEditArrowBehavior(3); 
			      }
				break;
	}
}
// handling the process realated with sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if (!validateCond(sheetObj,formObj,sAction)) {
				return false;
			}
			formObj.f_cmd.value=SEARCHLIST;
 			var sXml=sheetObj.GetSearchData("ESM_BSA_0023GS.do", bsaFormString(formObj,getParam('ESM_BSA_0023')));
			var header=GetEtcDataForExceptional(sXml, "header");
			var crrcd=GetEtcDataForExceptional(sXml, "crrCd");
			if (header != "") {

				formObj.crr_cd.value = crrcd;

				sheetObj = sheetObj.Reset();
				initSheet(sheetObj, 1, header);

				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.RemoveEtcData(); //ETC Data delete
			}
			break;
		case IBSAVE:        //save
			if (!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			formObj.f_cmd.value=MODIFY;
			sheetObj.DoSave("ESM_BSA_0023GS.do", bsaFormString(formObj,getParam('ESM_BSA_0023','S')), -1, true);
			
//			2015.06.06 김용습 - 저장 완료 메시지 추가
//			ComShowCodeMessage("BSA10047");
			
			break;
		case IBDOWNEXCEL:   //excel download
			//sheetObj.SpeedDown2Excel(-1);
            selectDownExcelMethod(sheetObj);
//            switch (excelType) {
//                case "AY":
//                     sheetObj.Down2Excel({ HiddenColumn:0,Merge:true});
//                    break;
//                case "DY":
//                     sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
//                    break;
//                case "AN":
//                     sheetObj.Down2Excel({ HiddenColumn:0});
//                    break;
//                case "DN":
//                     sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol( sheetObj), SheetDesign:1,Merge:1 });
//                    break;
//            }               
			break;
	}
}
function callBackExcelMethod(excelType) {
	 var sheetObj = sheet1;
	 if(sheetObj.RowCount() < 1){//no data
	  ComShowCodeMessage("COM132501");
	  return;
	 }
	 switch (excelType) {
	 case "AY":
         sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
         break;
	 case "AN":
         sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
         break;
	 case "DY":
         sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
         break;
	 case "DN":
         sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
         break;
	 }
	}
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	with (sheetObj) {
		for (var i=1; i<LastRow()+1; i++) {
			for (var j=1; j<LastCol()+1; j++) {
				if (ColSaveName(j).substring(0,10) == "D_aply_flg") {
					if (GetCellValue(i,j) == "1") {
						SetCellEditable(i,j,0);
					} else if (GetCellValue(i,j) == "0") {
						SetCellEditable(i,j,1);
					}
				}
			}
		}
	}
}
function sheet1_OnChange(sheetObj,Row,Col,Value) {
	// changing flag
	if (sheetObj.ColSaveName(Col).substring(0,10) == "D_aply_flg") {
		var TarCol=Col - (UOC - 1);
		if(sheetObj.GetCellValue(Row, Col) == sheetObj.CellSearchValue(Row, Col)){
			sheetObj.SetCellValue(Row, TarCol,"R",0);
		}
		else{
			sheetObj.SetCellValue(Row, TarCol,"U",0);
		}
	}
}
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	with (sheetObj) {
		//ComShowMessage("LastRow="+sheetObj.LastRow+ ",  LastCol="+LastCol);
		sheetObjects[0] = sheetObj;
		if (LastRow()> 0) {
			for (var k=0; k<LastCol(); k++) {
				if (ConstantMgr.isCompanyCode(GetCellValue(0,k))) {
					SetCellBackColor(0,k,"#555555");
				}
			}
		}
		for (var i=1; i<LastRow()+1; i++) {
			for (var j=1; j<LastCol()+1; j++) {
				if (ColSaveName(j).substring(0,10)  == "D_aply_flg") {
					if (GetCellValue(i,j) == "1") {
						SetCellEditable(i,j,0);
					} else if (GetCellValue(i,j) == "0") {
						SetCellEditable(i,j,1);
					}
				}
//				if (ConstantMgr.isCompanyCode(CellValue(0,j))) {
//						CellEditable(i,j) = false;
//				}
			}
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction) {
	with(formObj){
	}
	return true;
}
/**
 * handling process for retrieve validation
 */
function validateCond(sheetObj,formObj,sAction) {
	with(formObj){
	}
	return true;
}
