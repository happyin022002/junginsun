/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_SCE_0009.js
*@FileTitle : COP Main Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var isFirst=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/***** Setting variable over two sheet at tab *****/
	var sheetObject=sheet1;
	var sheetObject1=sheet2; 
	/*******************************************************/
	var formObject=document.form;

	var opener = window.dialogArguments;
	if (!opener) opener=window.opener;  //이 코드 추가할것
	if (!opener) opener=parent; //이 코드 추가할것
	
	var opener2 = opener.window.dialogArguments;
	if (!opener2) opener2=opener.window.opener;  //이 코드 추가할것
	if (!opener2) opener2=opener.parent; //이 코드 추가할것
	try {
//		var opener=window.dialogArguments;
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_apply":
				//alert(opener2.form.bkg_no.value);
				var result=	doActionIBSheet2(sheetObject, sheetObject1, formObject, IBSAVE);

				opener2.researchScreen();
				ComShowMessage(ComGetMsg('SCE90013'));
				opener.ComClosePopup();
				ComClosePopup(); 

								
//				if(result){
//					//ComPopUpReturnValue("apply"); 
//					//ComShowMessage(ComGetMsg('SCE90013')) ;					
//					//ComClosePopup(); 
//				}
				
			break;
	        case "btn_close":
	        	ComClosePopup(); 
		        break;			
		} // end switch
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
	for(i=0;i<sheetObjects.length;i++) {
		//changing initializing function name
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//adding last function name
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
  /**
   * setting sheet initial values and header
   * param : sheetObj, sheetNo
   * adding case as numbers of counting sheets
   */
function initSheet(sheetObj,sheetNo,sheet2LoopCnt) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //IBSheet1 init
			with (sheetObj) {
			    var HeadTitle="Seq.|COP No.|Container No.|Current Activity|Location\n(Yard / Zone)|Actual\nDate / Time|Planned\nDelivery Date / Time|Estimated\nDelivery Date / Time|Estimated\nTotal Cost(USD)" ;
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
	
			    var cols = [ 
			              {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cop_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0, Width:230,  Align:"Center",  ColMerge:0,   SaveName:"act_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0, Width:170,  Align:"Center",  ColMerge:0,   SaveName:"planed_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0, Width:170,  Align:"Center",  ColMerge:0,   SaveName:"est_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"estm_cost",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cop_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pctl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cop_sub_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"max_dtl_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ioBndCd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			              {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			     
			    InitColumns(cols);
			    SetEditable(0);
			    SetSheetHeight(280);
			}
		break;
		case 2:      //IBSheet2 init
			with (sheetObj) {
			    var newTitle="";
			    var loopCnt=4;
			    if(sheet2LoopCnt != null) {
			    	loopCnt=parseInt(sheet2LoopCnt);
			    }
			    if(loopCnt > 0) {
				    for(var i=0; i < loopCnt; i++) {
				    	newTitle += "|" + "Location\n(Yard / Zone)|Mode|S.P. Name|Agreement\nRef No";
				    }
			    } else {
			    	newTitle="|Location\n(Yard / Zone)|Mode|S.P. Name|Agreement\nRef No";
			    }
			    var aryTitle=newTitle.split("|");
			    var colCnt=aryTitle.length - 1;
			    var colcount=colCnt + 7 ;
			    
			    (colcount+1+1, 1, 0, true);
			    var HeadTitle="Select|PCTLNO|Route\nPlan No" + newTitle + "|Location\n(Yard / Zone)|Estimated\nDelivery Time|Estimated\nTotal Cost|Combined|TmpFlg" ;
			    var modbsize=70;
			    var ydbsize=110;
			    var spsize=150;
	
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
	
			    var cols = [ 
			    {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pctl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			    {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_pln_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			    for (var i=0; i <loopCnt; i++) {
			    	cols.push({Type:"Text",      Hidden:0,  Width:ydbsize,Align:"Center",  ColMerge:1,   SaveName:"",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    	cols.push({Type:"Text",      Hidden:0,  Width:modbsize,Align:"Center", ColMerge:1,   SaveName:"",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    	cols.push({Type:"Text",      Hidden:0,  Width:spsize,Align:"Left",     ColMerge:1,   SaveName:"",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    	cols.push({Type:"Text",      Hidden:0,  Width:80,Align:"Center",       ColMerge:1,   SaveName:"",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    }
			    cols.push({Type:"Text",      Hidden:0, Width:ydbsize, Align:"Center",  ColMerge:1,   SaveName:"",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    cols.push({Type:"Text",      Hidden:0, Width:150,     Align:"Center",  ColMerge:1,   SaveName:"est_dlv_tm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    cols.push({Type:"Int",       Hidden:0, Width:100,     Align:"Right",   ColMerge:1,   SaveName:"est_tot_cost",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    cols.push({Type:"Text",      Hidden:0, Width:100,     Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    cols.push({Type:"Text",      Hidden:1, Width:100,     Align:"Right",   ColMerge:1,   SaveName:"inlnd_rout_tmp_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    cols.push({Type:"Text",      Hidden:1, Width:100,     Align:"Right",   ColMerge:1,   SaveName:"",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			    cols.push({Type:"Text",      Hidden:1, Width:100,     Align:"Right",   ColMerge:1,   SaveName:"",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			  
			    InitColumns(cols);
	
			    SetEditable(1);
//			    SetSheetHeight(190 );
			    resizeSheet();
			}
		break;
	}
}
// handling Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	if(formObj.f_cmd.value == '') {
		switch(sAction) {
			case IBSEARCH:      //retrieving(after onload) 
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCHLIST;
					sheetObj.DoSearch("ESD_SCE_0009Search.do", SceFrmQryString(formObj), {Sync:2} );
					if(sheetObj.RowCount()== 0){
						ComShowMessage('COP has been closed');
						break;
					}
					formObj.f_cmd.value=SEARCHLIST02;
					var queryStr=sheetObj.GetSaveString(true);
					var sXml=sheetObjects[1].GetSearchData("ESD_SCE_0009Search2.do",queryStr+"&"+SceFrmQryString(formObj),"",false);
					//sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
					var sheet2MaxCnt=ComGetEtcData(sXml, "maxCnt");
					//var sxml2=ComGetEtcData(sXml, "sxml2");
					//alert(sxml2);
					sheetObj.RemoveEtcData();
//					sheetObjects[1].RemoveAll();
					sheetObjects[1] = sheetObjects[1].Reset();
					initSheet(sheetObjects[1],2,sheet2MaxCnt);
					sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				}
			break;
		}
	}
}
// setting Apply
function doActionIBSheet2(sheetObj1, sheetObj2, formObj,sAction) {
	sheetObj1.ShowDebugMsg(false);
	switch(sAction) {
		case IBSAVE:
			if(validateForm(sheetObj2,formObj,sAction)) {
				formObj.f_cmd.value=MULTI01;
				sheetObj1.DoAllSave("ESD_SCE_0009Update.do", SceFrmQryString(formObj));
				return true;
			}else{
				return false;
			}
		break ;
	}
}
/**
* handling process for input validation
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj) {
		switch(sAction){
			case IBSAVE :
				if(sheetObj.CheckedRows("chk")==0){
					ComShowMessage(ComGetMsg('COM12113', 'Possible Mode Infomation')) ;
					return false ;
				}
				var iCheckRow=sheetObj.FindCheckedRow("chk");
				var arrRow=iCheckRow.split("|");
				if(sheetObj.GetCellValue(arrRow[0], "inlnd_rout_tmp_flg")=="Y"){
					if(!ComShowCodeConfirm("SCE90049")) return false ;
				}
//				return true ;
			break ;
			default :
			break ;
		}
	}
	return true;
}
function sheet2_OnChange(sheetObj2, row, col){
	var pctlNo=sheetObj2.GetCellValue(row, "pctl_no") ;
	var ioBndCd=sheetObj2.GetCellValue(row, "io_bnd_cd") ;
	var sheetObj1=sheetObjects[0] ;
	var rowCnt=sheetObj1.RowCount();
	for(i=1; i<=rowCnt; i++){
		sheetObj1.SetCellValue(i, "pctl_no",pctlNo ,0);
		sheetObj1.SetCellValue(i, "io_bnd_cd",ioBndCd ,0);
	}
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	if(ErrMsg==""){			
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		ComShowMessage(ComGetMsg('SCE90013')) ;
		ComClosePopup(); 
	}
}
function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[1]);
} 