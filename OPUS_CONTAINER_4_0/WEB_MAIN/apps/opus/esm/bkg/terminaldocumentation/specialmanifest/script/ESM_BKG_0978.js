/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.1
*@FileName   : ESM_BKG_0978.js.js
*@FileTitle  : CNTR Substitute
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/30
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var rdObjects=new Array();
var rdCnt=0;
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
			case "btn_Substitute":
                for(var i = 1; i <= sheetObjects[0].RowCount(); i++) {
                    if (ComIsNull(sheetObjects[0].GetCellValue(i, "from_cntr_no"))) {
                        ComShowCodeMessage("BKG01101", "From Cntr No.");
                        sheetObj.SelectCell(i, "from_cntr_no");
                        return;
                    }
                    if (ComIsNull(sheetObjects[0].GetCellValue(i, "to_cntr_no"))) {
                        ComShowCodeMessage("BKG01101", "To Cntr No.");
                        sheetObj.SelectCell(i, "to_cntr_no");
                        return;
                    }
                }
                comPopupOK(); 
			    break;
            case "btn_new":
                ComResetAll();
                break;
			case "btn_add":
			    var cntrCnt = formObj.cntr_cnt.value;
			    if(ComIsNull(cntrCnt)) {
			        ComShowCodeMessage("BKG00767", "Container Count");
			        formObj.cntr_cnt.focus();
			    }
			    for(var i = 0; i < cntrCnt; i++) {
			        sheetObjects[0].DataInsert(-1);
			    }
                break;
			case "btn_delete":
			    sheetObjects[0].RowDelete(sheetObjects[0].GetSelectRow());
			    break;
			case "btn_close":
				ComClosePopup(); 
				break;
        } // end switch
	}catch(e) {
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
    sheetObjects[0].DataInsert(-1);
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
    			var HeadTitle =	"status|Seq|From Cntr No.|To Cntr No.";
				SetConfig( { SearchMode:1, MergeSheet:5, Page:20} );
				
				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				var headers = [ { Text:HeadTitle, Align:"Center"}];
				InitHeaders(headers, info);
						
				var cols = [ {Type:"Status",Hidden:1,   Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Seq",	Hidden:0, 	Width:40,  	Align:"Center",	ColMerge:0,	SaveName:"his_seq",       KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
				             {Type:"Text",	Hidden:0, 	Width:150,	Align:"Center",	ColMerge:0,	SaveName:"from_cntr_no",  KeyField:0,	CalcLogic:"", 	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1, InputCaseSensitive:1},
						     {Type:"Text",	Hidden:0, 	Width:150,	Align:"Center",	ColMerge:0,	SaveName:"to_cntr_no",    KeyField:0,	CalcLogic:"", 	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1, InputCaseSensitive:1 }];
	   
				InitColumns(cols);
				SetEditable(1);
				ComResizeSheet(sheetObj);
	        	}
		    break;
		}
}
