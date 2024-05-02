/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0051.jsp
*@FileTitle  : ON(OW&On-hire) Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/  
    // common variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var shtCnt=0;
        var sheetObject=sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Downexcel":
                	if(sheetObjects[0].RowCount()> 0){
                		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                	}
                	else {
                		ComShowCodeMessage("COM132501");
                	}
                    break;
                case "btn_Close":
                	ComClosePopup(); 
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
        for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
                
		              var HeadTitle1="On-hire\nDue Date|On-hire\nPlan Yard|On-hire\nAct. Date|On-hire\nAct. Yard|TP/SZ|Vol|Lease\nTerm|Lessor|AGMT No.|Auth No.";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		
		              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_dt",      KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"evnt_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lessor",        KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_auth_no",  KeyField:0,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
		              SetCountPosition(0);
		              SetSheetHeight(400);
                    }

               break;
        }
    }
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
            	sheetObj.SetWaitImageVisible(0);
            	ComOpenWait(true);             	
                formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("EES_CIM_0051GS.do",FormQueryString(formObj) );
            	ComOpenWait(false);             	
                break;
            case IBDOWNEXCEL:
            	if(sheetObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		sheetObj.Down2Excel({ HiddenColumn:true});
            	}				
            	break;
        }
    }
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * end of retrieving Tab1 
     * calling event after retrieving Tab1
     */
     function sheet1_OnSearchEnd(sheetObj, msg){
    	 sheetObj.SelectHighLight=false;
     }
     /**
      * event when clicking cell
      * setting background color for selected row
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
    	 sheetObj.SelectHighLight=true;
     }	     
