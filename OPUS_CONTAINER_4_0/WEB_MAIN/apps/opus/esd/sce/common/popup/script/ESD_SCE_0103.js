/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0103.js
*@FileTitle  : ESD_SCE_0103
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var selCol=0;
var selOfc="";
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	document.all['seletad'].selectedIndex=document.form.f_slt_idx.value;
}
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
    	    case "btn_retrieve":
    	    	if( validateForm(formObject) ){
		            doActionIBSheet(sheetObject,formObject,IBSEARCH);
		        }
    	        break;
    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;
//            case "btns_calendar1":
//    	         var cal = new calendarPopup();
//        		 cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
//    	        break;
//
//    	    case "btns_calendar2":
//    	         var cal = new calendarPopup();
//        		 cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
//    	        break;
            case "btn_close":
            	ComClosePopup(); 
    	        break;
			case "btn_apply":
				PopupOK(sheetObject, formObject);
			    break;
			case "btn_bkg_calendar":
				var cal=new ComCalendarFromTo();
				//cal.displayType="date";
				//cal.select(formObject.sdate, 'sdate',formObject.edate, 'edate', 'yyyy-MM-dd');
				cal.select(formObject.sdate, formObject.edate, 'yyyy-MM-dd');
				break ;
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo,evtTp) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //IBSheet1 init
            with (sheetObj) {
        	if(evtTp=="ETA"||evtTp==null){
            	HeadTitle="|SEQ|VVD|Lane|POD|ETA" ;
            }else{
            	var HeadTitle="|SEQ|VVD|Lane|POL|ETD" ;
            }
            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"slane",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"port",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"etdate",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
            InitColumns(cols);
            SetEditable(1);
//            SetSheetHeight(180);
            resizeSheet();
               }
            break;
        case 9:      //IBSheet1 init
            with (sheetObj) {
            var HeadTitle="|SEQ|VVD|Lane|POL|POD" ;
            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"slane",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"port",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:116,  Align:"Center",  ColMerge:0,   SaveName:"etdate",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
            InitColumns(cols);
            SetEditable(1);
            SetSheetHeight(180);
           }
            break;
    }
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      
			formObj.f_cmd.value=SEARCH03;
			ComClearSeparator(formObj.sdate);
			ComClearSeparator(formObj.edate);
			sheetObj.DoSearch("ESD_SCE_0103GS.do", SceFrmQryString(formObj) );
			break;
	   case IBDOWNEXCEL:       
		   if(sheetObj.RowCount() < 1){//no data
			   ComShowCodeMessage("COM132501");
			   }else{
				   sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
			   }
		  break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(formObj){
    with(formObj){
 	    if(formObj.sdate.value=="" || formObj.edate.value=="") {
  	        ComShowMessage("You must input period");
  	        if(formObj.sdate.value=="" || !chkDateValue(formObj.sdate.value) )  {
  	          //setFocus(formObj.sdate);
  	          formObj.sdate.focus() ;
  	          return false;
  	        }
  	        if(formObj.edate.value=="" || !chkDateValue(formObj.edate.value) ) {
  	          //setFocus(formObj.edate);
  	          formObj.edate.focus() ;
  	          return false;
  	        }
  	    }
  	    if( formObj.seletad.value == "ETA" ){
	  	    if(formObj.selpod.value=="") {
	  	        ComShowMessage("You must input POD");
	  	        //setFocus(formObj.selpod);
	  	        formObj.selpod.focus() ;
	  	        return false;
	  	    }
  	    } else{
	  	    if(formObj.selpol.value=="") {
	  	        ComShowMessage("You must input POL");
	  	        //setFocus(formObj.selpol);
	  	        formObj.selpol.focus() ;
	  	        return false;
	  	    }
  	    }
  	    if(formObj.selvvd.value != null && formObj.selvvd.value != "") {
  	    	if(formObj.selvvd.value.length != 9) {
      	        ComShowMessage("VVD must be 9 characters");
      	        ComSetFocus(formObj.selvvd);
      	        return false;
      	    }
  	    }
  	    if(formObj.sellane.value != null && formObj.sellane.value != "") {
  	    	if(formObj.sellane.value.length != 3) {
      	        ComShowMessage("Lane must be 3 characters");
      	        setFocus(formObj.sellane);
      	        return false;
      	    }
  	    }
    }
    return true;
}
function PopupOK(sheetObj, formObject){
	var val="";	
//no support[check again]CLT 	var rows=sheetObj.Rows;
	var iCheckRow=sheetObj.CheckedRows("check");
	var opener=window.dialogArguments;
	if(iCheckRow == 0) {
		return null;
	}
	else {
		var ik=0;
		for(var i=0; i < rows; i++) {
			if(sheetObj.GetCellValue(i, "check") == 1) {
	  			if(ik == 0) {
	  				val=sheetObj.GetCellValue(i, "vvd");
	  			} else {
	  				val=val + "," + sheetObj.GetCellValue(i, "vvd");
                }
                ik++;
     		}
  		}
  	}
  	opener.rtn_vvd_code(val);
  	opener.rtn_pol_code(document.form.selpol.value);
  	opener.rtn_pod_code(document.form.selpod.value);
  	ComClosePopup(); 
}
/*
 * ETA / ETD due to the selection change Query IBSheet
 * */
function selectVSLEVNT(evt){
  //alert("evt:"+evt);
if(evt=="ETA"){
   document.all['seletad'].selectedIndex=0;
   document.form.f_slt_idx.value=0;
}else{
   document.all['seletad'].selectedIndex=1;
   document.form.f_slt_idx.value=1;
}
            ComConfigSheet(sheetObjects[0]);
            initSheet(sheetObjects[0],1,evt);
            ComEndConfigSheet(sheetObjects[0]);
}
function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[0]);
} 