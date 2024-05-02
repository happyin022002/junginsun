/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0039.js
*@FileTitle  : EQ Availability
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
    /**
    * @extends 
    * @class ees_cim_0039 : business script for ees_cim_0039 
    */
    // common variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button click event */
    function processButtonClick(){
        var shtCnt=0;
        var sheetObject=sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Downexcel":
                	if(sheetObjects[0].RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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
               
            var HeadTitle1="I/O|Trans Mode|VVD|From|From|To|To|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|";
            var HeadTitle2="I/O|Trans Mode|VVD|Yard|ETD|Yard|ETB/ETA|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:7, Page:20, DataRowMerge:1 } );

            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"},
                    { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:1,   SaveName:"eq_trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"etd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd" },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"etb_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd" },
             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total",           KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty1",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty3",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty6",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty7",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty8",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty9",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty10",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty11",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty12",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty13",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty14",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty15",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"lvl",             KeyField:0,   CalcLogic:"",   Format:"" } ];
             
            InitColumns(cols);
            SetSheetHeight(530);
            SetEditable(0);
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
                formObj.head_cntr_tpsz_cd.value="D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
                 sheetObj.DoSearch("EES_CIM_0039GS.do",FormQueryString(formObj) );
            	ComOpenWait(false);             	
                break;
            case IBDOWNEXCEL:      
               sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
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
     * calling event after retreing Tab1 
     */
     function sheet1_OnSearchEnd(sheetObj, msg){
        for(var i=0; i<=sheetObj.LastRow(); i++){
        	if (sheetObj.GetCellValue(i,"lvl") == '0111111' && sheetObj.GetCellValue(i,"io_bnd_cd") == 'I'){
                sheetObj.SetCellValue(i,"io_bnd_cd",'MTY Repo. In Total');
                 sheetObj.SetCellFont("FontBold", i,"io_bnd_cd",1);
                 sheetObj.SetCellFont("FontBold", i,"eq_trsp_mod_cd",1);
                 sheetObj.SetCellFont("FontBold", i,"vvd",1);
                 sheetObj.SetCellFont("FontBold", i,"total",1);
                for ( var j=1; j<=15; j++ ) {
                 	sheetObj.SetCellFont("FontBold", i,"fcast_qty"+j,1);
                }
                sheetObj.SetMergeCell(i, 0, 1, 3);
                sheetObj.SetRowBackColor(i,"#FFFFFF");
        	} else if  (sheetObj.GetCellValue(i,"lvl") == '0111111' && sheetObj.GetCellValue(i,"io_bnd_cd") == 'O'){
                sheetObj.SetCellValue(i,"io_bnd_cd",'MTY Repo. Out Total');
                 sheetObj.SetCellFont("FontBold", i,"io_bnd_cd",1);
                 sheetObj.SetCellFont("FontBold", i,"eq_trsp_mod_cd",1);
                 sheetObj.SetCellFont("FontBold", i,"vvd",1);
                 sheetObj.SetCellFont("FontBold", i,"total",1);
                for ( var j=1; j<=15; j++ ) {
                 	sheetObj.SetCellFont("FontBold", i,"fcast_qty"+j,1);
                }
                sheetObj.SetMergeCell(i, 0, 1, 3);
                sheetObj.SetRowBackColor(i,"#FFFFFF");
        	} else if  (sheetObj.GetCellValue(i,"lvl") == '1111111'){
                sheetObj.SetCellValue(i,"io_bnd_cd",'Repo. Balance (In - Out)');
                for ( var j=1; j<=15; j++ ) {
                	if ( sheetObj.GetCellValue(i,"fcast_qty"+j) > 0 ) {
                         sheetObj.SetCellFontColor(i,"fcast_qty"+j,"#0000FF");
                    }
                	if ( sheetObj.GetCellValue(i,"fcast_qty"+j) < 0 ) {
                         sheetObj.SetCellFontColor(i,"fcast_qty"+j,"#FF0000");
                    }
                     sheetObj.SetCellFont("FontBold", i,"io_bnd_cd",1);
                     sheetObj.SetCellFont("FontBold", i,"eq_trsp_mod_cd",1);
                     sheetObj.SetCellFont("FontBold", i,"vvd",1);
                     sheetObj.SetCellFont("FontBold", i,"total",1);
                     sheetObj.SetCellFont("FontBold", i,"fcast_qty"+j,1);
                }
                if ( sheetObj.GetCellValue(i,"total") > 0 ) {
                     sheetObj.SetCellFontColor(i,"total","#0000FF");
                }
                if ( sheetObj.GetCellValue(i,"total") < 0 ) {
                     sheetObj.SetCellFontColor(i,"total","#FF0000");
                }
                sheetObj.SetMergeCell(i, 0, 1, 3);
                sheetObj.SetRowBackColor(i,"#FFFFFF");
            }
        }
        //no support[implemented common]CLT sheetObj.SelectHighLight=false;
     }
     /**
      * event in case of clicking cell
      * setting background color selected column
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
     }	     
