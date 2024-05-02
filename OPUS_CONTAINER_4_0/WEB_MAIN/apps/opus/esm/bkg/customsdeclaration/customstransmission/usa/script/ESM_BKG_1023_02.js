/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.1
*@FileName   : ESM_BKG_0978.js.js
*@FileTitle  : CNTR Substitute
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/30
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
			switch(srcName) {
			case "btn_transmit":
				var opener = window.dialogArguments;
				if (!opener) opener = parent;
				if(formObj.allerror.value==1){ // 첫 번째 라디오 버튼 클릭
					opener.document.form.hidden_vvd.value=formObj.vvd1.value;
				}else{						   // 두 번째 라디오 버튼 클릭
					opener.document.form.hidden_vvd.value=formObj.vvd2.value;
				}
				opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, MULTI);
				ComClosePopup();
				break;
			case "btn_close":
				ComClosePopup();
				break;
			} // end switch
        } // end try
	catch(e) {
		ComShowMessage(e);
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
 * registering the created IBCombo Object at page as comboObjects list
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj=sheetObjects[0];
	switch (sAction) {
	case SEARCH04:
		formObj.f_cmd.value=SEARCH04;
		var sXml=sheetObj.GetSearchData("ESM_BKG_1023GS.do", FormQueryString(formObj));
		sheetObj.LoadSearchData(sXml,{Sync:1});
			document.form.vvd1.value=sheetObj.GetCellValue(1,"vvd")
			document.form.vvd2.value=sheetObj.GetCellValue(2,"vvd")
			document.form.crn1.value=sheetObj.GetCellValue(1,"cvy_ref_no")
			document.form.crn2.value=sheetObj.GetCellValue(2,"cvy_ref_no")
		break;
	}
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(var i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);         	
        ComEndConfigSheet(sheetObjects[i]);            
    }
    doActionIBSheet(sheetObjects[0], document.form, SEARCH04);
}

function initControl() {
	var formObject=document.form;
}
/**
 * setting sheet initial values and header
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	switch(sheetObj.id) {
        case "sheet1":      //sheet1 init
            with(sheetObj){
    			var HeadTitle =	"|vvd|cvy_ref_no";
				SetConfig( { SearchMode:1, MergeSheet:5, Page:20} );
				
				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				var headers = [ { Text:HeadTitle, Align:"Center"}];
				InitHeaders(headers, info);
						
				var cols = [ {Type:"Status",Hidden:0, Width:30,  Align:"Center", ColMerge:0, SaveName:"ibflag" },
				             {Type:"Text",	Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"vvd"},
				             {Type:"Text",	Hidden:0, Width:150, Align:"Center", ColMerge:0, SaveName:"cvy_ref_no"} ];
	   
				InitColumns(cols);
				SetEditable(1);
				ComResizeSheet(sheetObj);
				SetVisible(0);
	        	}
            break;
		}
	}
