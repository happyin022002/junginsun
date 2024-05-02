/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_0052.js
*@FileTitle  : Past BR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
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
		              var HeadTitle1="Pick-up\nDate|Yard|BKG No.|TP/SZ|Vol|1st  VVD|ETA|Rev.\nTerm|BKG OFC|CMDT|BKG\nDate|Internal Remark";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 0, 0, true);
		              sheetObj.FrozenCols=5;
		              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fcast_dt",      KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eta",           KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cre_dt",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inter_rmk",     KeyField:0,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);
		              SetEditable(0);
		              SetSheetHeight(350);
                    }
               break;
            case "sheet2":      //sheet1 init
                with(sheetObj){               
		              var HeadTitle1="D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 0, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"d2_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                          /* {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"d4_qty1",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },*/
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"d4_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"d5_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"d7_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"r2_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"r5_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"o2_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"s2_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"o4_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"s4_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"f2_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"a2_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"f4_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"a4_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"f5_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" } ];
		               
		              InitColumns(cols);
		              SetEditable(0);
		              SetSheetHeight(120);
                    }
            	break;               
        }
    }
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
            	sheetObj.SetWaitImageVisible(0);
            	ComOpenWait(true);             	
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("EES_CIM_0052GS.do",FormQueryString(formObj) );
            	ComOpenWait(false);             	
                break;
            case IBDOWNEXCEL:      
                if(sheetObjects[0].RowCount()> 0){
 	    			sheetObjects[0].Down2Excel({ HiddenColumn:0,TreeLevel:false});
                }
             break;
        }
    }
    
    function sheet1_OnDownFinish(sheetObj, downloadType, result) {
        if(sheetObjects[1].RowCount()> 0){
         	sheetObjects[1].Down2Excel({ HiddenColumn:1,TreeLevel:false});
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
    	 if( sheetObj.RowCount()== 0 ){
    		 return;
    	 }
    	 var d2_qty=0;
    	 var d4_qty=0;
    	 var d5_qty=0;
    	 var d7_qty=0;
    	 var r2_qty=0;
    	 var r5_qty=0;
    	 var o2_qty=0;
    	 var s2_qty=0;
    	 var o4_qty=0;
    	 var s4_qty=0;
    	 var f2_qty=0;
    	 var a2_qty=0;
    	 var f4_qty=0;
    	 var a4_qty=0;
    	 var f5_qty=0;
    	 for( var i=0; i<=sheetObj.LastRow(); i++ ){
			var cntr_vol_qty=ComReplaceStr(sheetObj.GetCellValue(i, "cntr_vol_qty"),",","");
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'D2' ){
    	 		d2_qty=d2_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'D4' ){
    	 		d4_qty=d4_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'D5' ){
    	 		d5_qty=d5_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'D7' ){
    	 		d7_qty=d7_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'R2' ){
    	 		r2_qty=r2_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'R5' ){
    	 		r5_qty=r5_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'O2' ){
    	 		o2_qty=o2_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'S2' ){
    	 		s2_qty=s2_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'O4' ){
    	 		o4_qty=o4_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'S4' ){
    	 		s4_qty=s4_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'F2' ){
    	 		f2_qty=f2_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'A2' ){
    	 		a2_qty=a2_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'F4' ){
    	 		f4_qty=f4_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'A4' ){
    	 		a4_qty=a4_qty + eval(cntr_vol_qty);
    	 	}
			if ( sheetObj.GetCellValue(i,"cntr_tpsz_cd") == 'F5' ){
    	 		f5_qty=f5_qty + eval(cntr_vol_qty);
    	 	}
    	 }
    	 sheetObjects[1].DataInsert(-1);
    	 sheetObjects[1].SetCellText(1,"d2_qty",d2_qty);
    	 sheetObjects[1].SetCellText(1,"d4_qty",d4_qty);
    	 sheetObjects[1].SetCellText(1,"d5_qty",d5_qty);
    	 sheetObjects[1].SetCellText(1,"d7_qty",d7_qty);
    	 sheetObjects[1].SetCellText(1,"r2_qty",r2_qty);
    	 sheetObjects[1].SetCellText(1,"r5_qty",r5_qty);
    	 sheetObjects[1].SetCellText(1,"o2_qty",o2_qty);
    	 sheetObjects[1].SetCellText(1,"s2_qty",s2_qty);
    	 sheetObjects[1].SetCellText(1,"o4_qty",o4_qty);
    	 sheetObjects[1].SetCellText(1,"s4_qty",s4_qty);
    	 sheetObjects[1].SetCellText(1,"f2_qty",f2_qty);
    	 sheetObjects[1].SetCellText(1,"a2_qty",a2_qty);
    	 sheetObjects[1].SetCellText(1,"f4_qty",f4_qty);
    	 sheetObjects[1].SetCellText(1,"a4_qty",a4_qty);
    	 sheetObjects[1].SetCellText(1,"f5_qty",f5_qty);
         //no support[implemented common]CLT sheetObj.SelectHighLight=false;
     }
     /**
      * event when clicking cell
      * setting background color for selected row
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
     }	     
