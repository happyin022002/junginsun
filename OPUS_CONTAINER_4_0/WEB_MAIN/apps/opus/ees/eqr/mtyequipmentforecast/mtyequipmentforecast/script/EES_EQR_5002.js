/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_5002.js
*@FileTitle  : MTY Repo In/ Out Plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
    // common static variable
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
            switch(srcName) {
                case "btn_downexcel":
                    if(sheetObjects[0].RowCount()> 0){
                        doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                    }
                    else
                	{
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
                with (sheetObj) {
                var HeadTitle1="Seq.|Trans Mode|Lane|VVD|From|From|To|To|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ||";
                var HeadTitle2="Seq.|Trans Mode|Lane|VVD|Yard|ETD|Yard|ETB/ETA|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5||";
                headCount=ComCountHeadTitle(HeadTitle1);
                sheetObj.FrozenCols=8;
                SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:7, Page:20, DataRowMerge:0 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                            { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"Seq",          KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Combo",     Hidden:0, Width:73,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_etd_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_eta_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"total",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty1",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty2",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty3",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty4",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty5",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty6",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty7",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty8",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty9",   KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty10",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty11",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty12",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty13",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty14",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"fcast_qty15",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"lvl",          KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",    KeyField:0,   CalcLogic:"",   Format:"" } ];
                InitColumns(cols);
                SetEditable(0);
                SetRangeBackColor(1, 3, 1, 23,"#555555");
                SetColProperty("trsp_mod_cd", {ComboText:"T/DVVD|Water|Truck|Rail", ComboCode:"1|2|3|4"} );
                SetSheetHeight(522);
               }
               break;
        }
    }
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieve
            	sheetObj.SetWaitImageVisible(0);
            	ComOpenWait(true); 
                formObj.f_cmd.value=SEARCH;
                //sheetObj.RenderSheet(0);
                sheetObj.DoSearch("EES_EQR_5002GS.do",FormQueryString(formObj) );
                break;
            case IBDOWNEXCEL:      // inserting
            	if(sheetObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            		}else{
            			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
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
     * handling search end event on sheet
     */
     function sheet1_OnSearchEnd(sheetObj, msg){
    	 if(sheetObj.RowCount()> 0) {
    		 for(var i=0; i<=sheetObj.LastRow(); i++){
    			 if (sheetObj.GetCellValue(i,"lvl") == '111111') {
    				 sheetObj.SetCellFont("FontBold", i,"",1);
    				 sheetObj.SetCellFont("FontBold", i,"vsl_slan_cd",1);
    				 sheetObj.SetCellFont("FontBold", i,"vvd",1);
    				 sheetObj.SetCellFont("FontBold", i,"total",1);
    				 for ( var j=1; j<=15; j++ ) {
    					 sheetObj.SetCellFont("FontBold", i,"fcast_qty"+j,1);
    				 }
    				 if ( sheetObj.GetCellValue(i,"total") > 0 ) {
    					 sheetObj.SetCellFontColor(i,"total","#0000FF");
    				 }
    				 if ( sheetObj.GetCellValue(i,"total") < 0 ) {
    					 sheetObj.SetCellFontColor(i,"total","#FF0000");
    				 }
    				 for ( var j=0; j<headCount; j++ ) {
    					 if ( j < 4 ) {
    						 sheetObj.SetCellValue(i,j,'');
    					 } else {
    						 sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j));
    					 }
    				 }
    			 } 
			}
    		if ( document.form.repo_flag.value == 'IN' ) {
    			sheetObj.SetCellValue(sheetObj.LastRow(),"Seq",'MTY Repo. In Total',0);
			} else {
			    sheetObj.SetCellValue(sheetObj.LastRow(),"Seq",'MTY Repo. Out Total',0);
			}
    		sheetObj.SetCellAlign(sheetObj.LastRow(),"Seq","Center");
			sheetObj.SetRowHidden(sheetObj.LastRow()-1,1);
			sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 8);
//no support[check again]CLT 			sheetObj.SetSumBackColor(sheetObj.WebColor2SysColor("#D3EBED"));
			sheetObj.SetSumFontBold(1);
			if ( sheetObj.GetCellValue(sheetObj.LastRow(),"total") > 0 ) {
				sheetObj.SetCellFontColor(sheetObj.LastRow(),"total","#0000FF");
			}
			if ( sheetObj.GetCellValue(sheetObj.LastRow(),"total") < 0 ) {
				sheetObj.SetCellFontColor(sheetObj.LastRow(),"total","#FF0000");
			}
			for ( var j=1; j<=15; j++ ) {
				if ( sheetObj.GetCellValue(sheetObj.LastRow(),"fcast_qty"+j) > 0 ) {
					sheetObj.SetCellFontColor(sheetObj.LastRow(),"fcast_qty"+j,"#0000FF");
				}
				if ( sheetObj.GetCellValue(sheetObj.LastRow(),"fcast_qty"+j) < 0 ) {
					sheetObj.SetCellFontColor(sheetObj.LastRow(),"fcast_qty"+j,"#FF0000");
				}
			} 
//no support[check again]CLT 			sheetObj.SetRowBackColor(sheetObj.LastRow(),sheetObj.WebColor2SysColor("#D3EBED"));
    	 }
    //no support[implemented common]CLT 	 sheetObj.SelectHighLight=false;
    	 //sheetObj.RenderSheet(1);
         ComOpenWait(false); 
     }
     /**
      * handling click event on sheet <br>
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      	if ( row == sheetObj.LastRow()) {
          //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
      		sheetObj.SetRowBackColor(row,-1);
      	} else {
          //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
      	}
     }	     
