/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0929.js
*@FileTitle  : Payment History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var opener_obj = opener;
if (!opener_obj) {
	opener_obj = parent;
}

document.onclick=processButtonClick;
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_close":
        	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("TRS90392");
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * IBSheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * onLoad
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        fillFormData();  
  }
   /**
     * param : sheetObj, sheetNo 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	                var HeadTitle="Paid|From Node|From Node|To Node|To Node|Cargo|Vendor|Vendor|Rail Billing\nDate|Paid\nDate|Invoice\nCUR|Invoice\nAmount|Invoice\nNo.|Registration\nNo.";
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [   {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"paid",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fm_nod_cd2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"to_nod_cd2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:150,  Align:"left",    ColMerge:0,   SaveName:"vndr_abbr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rail_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pay_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"inv_amt",        KeyField:0,   CalcLogic:"",   Format:"",     	   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:100,  Align:"left",    ColMerge:0,   SaveName:"inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rgst_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                InitColumns(cols);
	                SetEditable(0);
	                SetColProperty('inv_curr_cd', {ComboText:"|"+inv_curr_cdText, ComboCode:"|"+inv_curr_cdCode} );
	                ComResizeSheet(sheetObj);
               }
                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      
        	    sheetObj.ShowDebugMsg(true);
        	    formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESD_TRS_0929GS.do", TrsFrmQryString(formObj), {Sync: 1 } );
                ComEtcDataToForm(formObj ,sheetObj);
                sheetObj.ShowDebugMsg(false);
                sheetObj.RemoveEtcData();
                break;
           case IBLOADEXCEL:        
        	   sheetObj.LoadExcel();
              break;
        }
    }
    /**
     *  form Data
     */
     function fillFormData() {
        document.form.cntr_no.value = opener_obj.document.form.cntr_no.value; 
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
      }
