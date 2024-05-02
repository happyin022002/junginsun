/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1112.js
*@FileTitle  : Eur24 Hour : View MSG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	var comboObjects=new Array();
    var comboCnt=0;
	// Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     *  registering Combo Object as list
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj; 
    }
    /**

// Event handler processing by button name */
function processButtonClick(){
    /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
	try{
		var srcName=ComGetEvent("name");
		switch(srcName){
			case "btn_close":
				ComClosePopup(); 
			break;						
        } // end switch
	}catch(e){
		if( e == "[object Error]"){
			ComShowMessage(OBJECT_ERROR);
		} else{
			ComShowMessage(e.message);
		}
	}
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage(){
	var formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
   doActionIBSheet(sheetObjects[0],document.form,SEARCH);
}
/**
 * Event  after loading 
 * @param sheetObj
 * @return
 */
//no support[check again]CLT 
function sheet1_OnLoadFinish(sheetObj){
	var formObj=document.form;
	//initSheetData(sheetObjects[0], formObj);
   	//ComSetFocus(formObj.form1_vvd_cd);
}   
/**
 * Sheet DblClick Event
 * @param sheetObj Sheet
 * @param Row Row Index
 * @param Col Col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
       var colSaveName=sheetObj.ColSaveName(col);
       switch(colSaveName) {
       	case "err_img" :
			if(sheetObj.GetCellValue(row, "err_id") != ""){
			ComOpenWindowCenter("/opuscntr/ESM_BKG_1115.do?pgmNo=ESM_BKG_1115&err_id=" + sheetObj.GetCellValue(row,"err_id")+"&cnt_cd="+ComGetObjValue(form.cnt_cd), "1115", 870,500, false);
       		}
	    	break;
       } // end switch
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
     var cnt=0;
	 var sheetID=sheetObj.id;
     switch(sheetID) {
     case "sheet1":
    	    with(sheetObj){
		         
		       var HeadTitle1="||||err_id";
		       var headCount=ComCountHeadTitle(HeadTitle1);
		       //(headCount, 0, 0, true);
		
		       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		       var headers = [ { Text:HeadTitle1, Align:"Center"}  ];
		       InitHeaders(headers, info);
		
		       var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,  SaveName:"column1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:330,  Align:"Left",    ColMerge:0,  SaveName:"remark1", MultiLineText:1,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"err_img",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"err_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		        
		       InitColumns(cols);
		
		       SetEditable(1);
		       SetImageList(0,"img/btns_search.gif");
		       SetImageList(1,"img/blank.gif");
		       SetCountPosition(0);
		       SetRowHidden(0, 1);
		       SetSheetHeight(500);
             }


		break;
     }
 }
/**
 * Sheet handling process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj,formObj,sAction){
	sheetObj.ShowDebugMsg(false);
	switch(sAction){
		case SEARCH :	//Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT 			
			var sXml=sheetObj.GetSearchData("ESM_BKG_1112GS.do", FormQueryString(formObj));
			var valResult=ComGetEtcData(sXml, "data");
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			if(sheetObj.RowCount()== 0){
				ComOpenWait(false);
				ComShowCodeMessage('BKG00095', "Ack Message");
				//initSheetData(sheetObj, formObj);
				initSheet(sheetObj,0);
			}
            ComOpenWait(false);
		break;
	}
}
