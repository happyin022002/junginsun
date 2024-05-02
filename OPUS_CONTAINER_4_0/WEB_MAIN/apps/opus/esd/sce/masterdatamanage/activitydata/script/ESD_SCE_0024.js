/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0024.js
*@FileTitle :  
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick(){
	 var sheetObj=sheetObjects[0];
	 /*******************************************************/
	 var formObj=document.form;
	try{
		var srcName=ComGetEvent("name");
		switch(srcName) {
	 		case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			case "btn_downexcel":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				}
				break;
			case "btn_save":
			    doActionIBSheet(sheetObj,formObj,IBSAVE);
			    break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e);
		}
	}
}
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
		    with(sheetObj){
			      var HeadTitle="STS|Seq|Logic No.|Basic Activity|Activity Name|Fomula|Hour|Dwell Time %|Effective\nDate From|Effective\nDate To" ;

			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"r_skd_lgc_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cop_skd_lgc_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
			             {Type:"Combo",     Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"act_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"act_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cop_foml_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"foml_tm_hrs",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"foml_pct_no",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"fm_eff_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"to_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			       
			      InitColumns(cols);

			      SetEditable(1);
			                        //conversion of function[check again]CLT 				InitDataValid(0,  2, vtEngOther, "1234567890-");
			      //conversion of function[check again]CLT 				InitDataValid(0,  2, vtEngOther, "1234567890-");
					SetColProperty("act_cd", {ComboText:"|"+actCDText, ComboCode:"|"+actCDCode} );
					SetColProperty("cop_foml_cd", {ComboText:"|+|-", ComboCode:"|+|-"} );
//	                  SetSheetHeight(360);
					resizeSheet();
			      }


			break;
	}
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false );
	switch(sAction) {
	   case IBSEARCH:
		   //2013505 박은정 수정된 데이타 있을 경우 무시하고 리트리브 진행할것인지 물어봄 
	 	   if(sheetObj.IsDataModified()== true){
	 		   if(!ComShowConfirm("There are changed data. Do you still want to retrieve?")){
	 			   return false;
	 		   }
	 	   }
	 	   //
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value=SEARCHLIST ;
				sheetObj.DoSearch("ESD_SCE_0024GS.do", FormQueryString(formObj) );
			}
			break;
	   case IBDOWNEXCEL:		
		   sheetObj.Down2Excel({ HiddenColumn:1,Merge:true});
		  break;
		case IBSAVE:
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value=MULTI ;
				sheetObj.DoSave("ESD_SCE_0024GS.do", FormQueryString(formObj));
			}
			break;
	}
}
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSAVE:
			var chgRows=sheetObj.FindStatusRow("I|U").split(";");
			var dtNullCnt=0 ;
			var preLgcNo="" ;
			var foml_tm_hrs = "";
			var foml_pct_no = "";
			
			if(chgRows != ""){
				for(i=0; i<=chgRows.length-1; i++){
					foml_tm_hrs = sheetObj.GetCellText(chgRows[i], "foml_tm_hrs");
					foml_pct_no = sheetObj.GetCellText(chgRows[i], "foml_pct_no");
					
					if(foml_tm_hrs == 0 &&
							foml_pct_no == 0 ){
						ComShowMessage(ComGetMsg("COM12138","Hour", "Dwell Time")) ;
						sheetObj.SelectCell(chgRows[i], "foml_tm_hrs") ;
						return false ;
					}
					
					else if(foml_tm_hrs == ""||
							foml_pct_no == ""){
						ComShowMessage(ComGetMsg("COM12138","Hour", "Dwell Time")) ;
						sheetObj.SelectCell(chgRows[i], "foml_tm_hrs") ;
						return false ;
					}
	//				else if(!ComIsEmpty(sheetObj.GetCellValue(chgRows[i], "foml_tm_hrs"))&&
	//						!ComIsEmpty(sheetObj.GetCellValue(chgRows[i], "foml_pct_no"))){
	//					if(sheetObj.GetCellValue(chgRows[i], "foml_tm_hrs") != 0 &&
	//							sheetObj.GetCellValue(chgRows[i], "foml_pct_no") != 0 ){
	//							ComShowMessage(ComGetMsg("SCE90021", "Hour", "Dwell Time")) ;
	//							sheetObj.SelectCell(chgRows[i], "foml_tm_hrs") ;
	//							return false ;
	//						}
	//				}
					
					else if(foml_tm_hrs!=""&&
							foml_pct_no!=""){
						if(foml_tm_hrs != 0 &&
								foml_pct_no != 0 ){
								ComShowMessage(ComGetMsg("SCE90021", "Hour", "Dwell Time")) ;
								sheetObj.SelectCell(chgRows[i], "foml_tm_hrs") ;
								return false ;
							}
					}
					else if(!chkNullT0EffDT(sheetObj,sheetObj.GetCellValue(chgRows[i], "cop_skd_lgc_no"))){
						ComShowMessage(ComGetMsg("SCE90022", sheetObj.GetCellValue(chgRows[i], "cop_skd_lgc_no"))) ;
						sheetObj.SelectCell(chgRows[i], "to_eff_dt") ;
						return false ;
					}
				}
			}
			break;
		default:
			break;
	}
	return true;
}
function sheet1_OnChange(sheetObj, row, col){
	if(col==2){
		sheetObj.SetCellValue(row, "act_nm",actNames[sheetObj.GetCellValue(row, "act_cd")] ,0);
	}
	else if(col==3){
		sheetObj.SetCellValue(row, "cop_skd_lgc_no",sheetObj.GetCellValue(row, "cop_skd_lgc_no").toUpperCase() ,0);
	}
}
function sheet1_OnSaveEnd(sheetObj, errMsg){
	if(errMsg==""){
		doActionIBSheet(sheetObj, document.form, IBSEARCH) ;
		ComShowMessage(ComGetMsg('SCE90005')) ;
	}	
}
function chkNullT0EffDT(sheetObj, skdLgcNo){
	var nullCnt=0 ;
	for(j=1; j<=sheetObj.RowCount(); j++){
		if(sheetObj.GetCellValue(j, "cop_skd_lgc_no")==skdLgcNo &&
				ComIsEmpty(sheetObj.GetCellValue(j, "to_eff_dt"))){
			nullCnt ++ ;
			if(nullCnt>1){
				return false ;
			}
		}
	}
	return true ;
}
function sheet1_OnSearchEnd(sheetObj) {
	var totalCnt=sheetObj.GetCellValue(3, "totcnt");
    var formObj=document.form;	
	if(sheetObj.GetTotalRows()> 0){
		sheetObj.SetTotalRows(totalCnt);
		for(var i=0; i<totalCnt; i++){
			if(sheetObj.GetCellValue(i, "to_eff_dt") == '' ){
				sheetObj.SetCellEditable(i, "to_eff_dt",1);
			}else{
				sheetObj.SetCellEditable(i, "to_eff_dt",0);
			}
		}		
	}
}
function changeLogicNo(){
	 var sheetObj=sheetObjects[0];
	 var formObj=document.form;	
	doActionIBSheet(sheetObj,formObj,IBSEARCH);	
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 