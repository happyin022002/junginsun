/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0022.js
*@FileTitle  : Inquiry by Trade
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=0;
    var save_lane;		//selected lane in case of double-clicking
    var save_bound;		//selected bound in case of double-clicking
    var save_vvd;		//selected vvd in case of double-clicking
    var save_ocn_ipc;   //selected ocn_ipc in case of double-clicking
    var save_trade;		//selected trade in case of double-clicking
    var save_subtrade	//selected subtrade in case of double-clicking
    //var sheetResizeFull = true;
    var sheetResizeCount=2;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** setting additional sheet value in case of more 2 sheet per tab *****/
         /*******************************************************/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var sheetObject2=sheetObjects[2];
         var sheetObject3=sheetObjects[3];
         var sheetObject4=sheetObjects[4];
         var formObject=document.form;
//        	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
        	    case "btn_retrieve":
//        			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
        			sheetObjects[0].RemoveAll();
        			sheetObjects[1].RemoveAll();
        			sheetObjects[2].RemoveAll();
        			sheetObjects[3].RemoveAll();
        			sheetObjects[4].RemoveAll();
        			
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            break;
				case "btn_new":
					if(checkModifiedSheet(sheetObject)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
	            	//using common funtion : initializing the screen
					resetAll(); 
					comObjects[0].SetSelectCode("");
					break;
				case "btn_downexcel":
					if(beforetab==0){
    	            	doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
    	            } else if(beforetab==1){
    	            	doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
    	            } else if(beforetab==2){
    	            	doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
    	            } else if(beforetab==3){
    	            	doActionIBSheet(sheetObjects[3],formObject,IBDOWNEXCEL);
    	            } else if(beforetab==4){
    	            	doActionIBSheet(sheetObjects[4],formObject,IBDOWNEXCEL);
    	            } 
					break;	
				case "maxi":
					doZoom();
					break;
            } // end switch
//        	}catch(e) {
//        		if( e == "[object Error]") {
//        			ComShowCodeMessage("COM12111");
//        		} else {
//        			ComShowMessage(e);
//        		}
//        	}
    }

    function doZoom() {
    	var obj = ComGetEvent();
    	var sheetId = obj.getAttributeNode("sheetId").value;
    	switch (sheetId) {
    	case "sheet1":
    		toggleSheetSize("wrap_search", "wrap_result2");
    		break;
    	case "t1sheet1":
    	case "t2sheet1":
    	case "t3sheet1":
    	case "t4sheet1":
    		toggleSheetSize("wrap_search", "wrap_result1", "tabArea");
    		break;
    	}
    }
    /*
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
      * registering IBCombo Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    function setComboObject(combo_obj){
		comObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	optionSetting();
    	var tabLayer = document.all.item("tabLayer");
    	var objs=document.all.tabLayer;
        for(var i=0;i<sheetObjects.length;i++){
        	// change the name of start environment setting funtion
            ComConfigSheet (sheetObjects[i]);
        	if(i > 0){
            	tdisp=tabLayer[i-1].style.display;
            	tabLayer[i-1].style.display="block";
        	}
            initSheet(sheetObjects[i],i+1);
        	if(i > 0){
				tabLayer[i-1].style.display=tdisp;
			}
        	// Adding last environment setting funtion
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetResizeFull=true;
		document_onresize();
//        resizeSheet();
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
//            tabObjects[k].SetSelectedIndex(0);
        }
//        var obj=eval(sheetObjects[1].document.form.type1);
        var obj = document.form.type1;
//        var obj1=eval(sheetObjects[1].document.form.weight1);
        var obj1 = document.form.weight1;
        changeTitle2('1', obj);
        changeTitle1('1', obj1);
        if(isDevMode){
        }
//        rhq_txt1_OnLoadFinish();
    }
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		                
		              SetFocusEditMode(default_edit_mode);
		              (23, 10, 0, true);
//		              var HeadTitle1="SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|OCN/\nIPC|BSA|Loadable|Load QTA|Load QTA|Forecast|Forecast|L/F|Alloc|Alloc|Alloc|Booking|Booking|Booking|Booking";
//		              var HeadTitle2="SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|OCN/\nIPC|BSA|Loadable|VOL|CMB|VOL|WGT|L/F|VOL|WGT|TS|Firm|Waiting|Total|WGT";
		              
	                    var HeadTitle1 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|OCN/\nIPC|BSA|Loadable|Load QTA|Load QTA|Forecast|Forecast|Forecast|Forecast|L/F|Alloc|Alloc|Alloc|Alloc|Booking|Booking|Booking|Booking|Booking|Booking";
	                    var HeadTitle2 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|OCN/\nIPC|BSA|Loadable|VOL|CMPB|VOL|WGT|T/S|T/S|L/F|VOL|WGT|T/S|T/S|Firm|Waiting|Total|WGT|T/S|T/S";
	                    var HeadTitle3 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|OCN/\nIPC|BSA|Loadable|VOL|CMPB|VOL|WGT|VOL|WGT|L/F|VOL|WGT|VOL|WGT|Firm|Waiting|Total|WGT|VOL|WGT";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}, { Text:HeadTitle3, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"TRADE",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"SUBTRADE",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"LANE",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"BOUND",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"WEEK",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"OCN_IPC",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"BSA",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"LOAD",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"QTA_VOL",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"QTA_CMB",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"FCAST_VOL",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"FCAST_WGT",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  ApproximateType:1 },
		                     
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"FCAST_TS_WGT",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"FCAST_TS_WGT",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  ApproximateType:1 },
		                     
		                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"LF",         KeyField:0,   CalcLogic:"|FCAST_VOL|/|BSA|*100",Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  ApproximateType:1 },
		                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                           {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  ApproximateType:1 }
//		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		                     ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
//		              SetRangeBackColor(1,10, 1,13,"#8C8C8C");
//		              SetRangeBackColor(1,15, 1,21,"#8C8C8C");
		              SetHeaderRowHeight(8);
		              SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
//		              SetSheetHeight(150);
              }
                break;
            case 2:     //t1sheet1 init
                with(sheetObj){
		              SetFocusEditMode(default_edit_mode);
//		              (41, 3, 0, true);
		              var HeadTitle1 = "OCN\nIPC\nTS|Area/RHQ|Load\nQuota|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|" +
              		"Forecast|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|" +
              		"Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|" +
              		"Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|" +
              		"Waiting Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|" +
              		"Total Booking|Total Booking";
		              var HeadTitle2 = "OCN\nIPC\nTS|Area/RHQ|Load\nQuota|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|" +
              		"Volume|Volume|Volume|Volume|Weight|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight" +
              		"|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Volume|Volume|Volume|Volume|Volume" +
              		"|Volume|Weight";
		              var HeadTitle3 = "OCN\nIPC\nTS|Area/RHQ|Load\nQuota|Total TEU|TEU|HC|45'|53'|Reefer|Weight|TEU|HC|45'|53'|" +
              		"Reefer|Weight|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight|" +
              		"Total TEU|20'|40'|HC|45'|53'|Reefer|Weight";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"},
		                          { Text:HeadTitle3, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"qta",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  ApproximateType:1 },
		                     
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  ApproximateType:1 },
		                    
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  ApproximateType:1 },
		                     
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1  },
		                    
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",     	 PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,  ApproximateType:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
//		              SetRangeBackColor(1,3, 2,33,"#8C8C8C");
		              SetHeaderRowHeight(10);
//		              SetSheetHeight(GetSheetHeight(8));
		              SetSheetHeight(170);
              }
                break;
              case 3:     //t1sheet1 init
            	    with(sheetObj){
		                SetFocusEditMode(default_edit_mode);
//		                (41, 3, 0, true);
		                var HeadTitle1="SEQ|POL|RHQ|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|" +
		                "Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Firm Booking|Firm Booking|" +
		                "Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Waiting Booking|Waiting Booking|" +
		                "Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|" +
		                "Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking";
		                var HeadTitle2="SEQ|POL|RHQ|Volume|Volume|Volume|Volume|Volume|Volume|Weight" +
		                "|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight" +
		                "|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Weight|Volume|Volume|Volume|Volume|Volume|Volume" +
		                "|Volume|Weight";
		                var HeadTitle3="SEQ|POL|RHQ|Total TEU|TEU|HC|45'|53'|Reefer|Weight|TEU|HC|45'|53'|Reefer" +
		                "|Weight|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight|" +
		                "Total TEU|20'|40'|HC|45'|53'|Reefer|Weight";
		
		                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		                var headers = [ { Text:HeadTitle1, Align:"Center"},
		                            { Text:HeadTitle2, Align:"Center"},
		                            { Text:HeadTitle3, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1},
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1},
		                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1},
		                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1},
		                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1, ApproximateType:1} ];
		                 
		                InitColumns(cols);
		
		                SetEditable(0);
//		                SetRangeBackColor(1,3, 2,33,"#8C8C8C");
		                SetHeaderRowHeight(10);
//		                SetSheetHeight(GetSheetHeight(8));
		                SetSheetHeight(170);
                }
                break;  
           case 4:     //t4sheet1 init
        	    with(sheetObj){
		             SetFocusEditMode(default_edit_mode);
//		             (38, 5, 0, true);
		             var HeadTitle1="SEQ|Customer\nCode|Customer\nName|PORT|RHQ|Forecast"
		             + "|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Firm Booking|Firm Booking|Firm Booking|Firm Booking|"
		             + "Firm Booking|Firm Booking|Firm Booking|Firm Booking|Waiting Booking|Waiting Booking|Waiting Booking|"
		             + "Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Total Booking|Total Booking|"
		             + "Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking";
		             var HeadTitle2="SEQ|Customer\nCode|Customer\nName|PORT|RHQ|Vol|Vol|Vol|Vol|"
		             + "Vol|Vol|Weight\n(Ton)"
		             + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
		             + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
		             + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)";
		             var HeadTitle3="SEQ|Customer\nCode|Customer\nName|PORT|RHQ|Total TEU|TEU|HC|45'|53'|Reefer|Weight\n(Ton)"
		             + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
		             + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
		             + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)";
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		             var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"},
		                         { Text:HeadTitle2, Align:"Center"},
		                         { Text:HeadTitle3, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1 },
		                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1, ApproximateType:1 },
		                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1 },
		                    {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu_",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                    {Type:"Text",      Hidden:1, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl_",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1, ApproximateType:1 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(0);
//		             SetRangeBackColor(1,5, 2,31,"#8C8C8C");
		             SetHeaderRowHeight(10);
//		             SetSheetHeight(GetSheetHeight(8));
		             SetSheetHeight(170);
             }
                break;  
             case 5:     //t4sheet1 init
            	    with(sheetObj){
		               SetFocusEditMode(default_edit_mode);
//		               (38, 5, 0, true);
		               var HeadTitle1="SEQ|Customer\nCode|Customer\nName|PORT|RHQ|Forecast"
		               + "|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Firm Booking|Firm Booking|Firm Booking|Firm Booking|"
		               + "Firm Booking|Firm Booking|Firm Booking|Firm Booking|Waiting Booking|Waiting Booking|Waiting Booking|"
		               + "Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Total Booking|Total Booking|"
		               + "Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking";
		               var HeadTitle2="SEQ|Customer\nCode|Customer\nName|PORT|RHQ|Vol|Vol|Vol|Vol|"
		               + "Vol|Vol|Weight\n(Ton)"
		               + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
		               + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
		               + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)";
		               var HeadTitle3="SEQ|Customer\nCode|Customer\nName|PORT|RHQ|Total TEU|TEU|HC|45'|53'|Reefer|Weight\n(Ton)"
		               + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
		               + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
		               + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"},
		                           { Text:HeadTitle2, Align:"Center"},
		                           { Text:HeadTitle3, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1, ApproximateType:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1 },
		                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vol_teu_",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d2_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d4_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d5_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_d7_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"vol_53_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vol_rf_",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"wgt_ttl_",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,  ApproximateType:1 } ];
		                
		               InitColumns(cols);
		
		               SetEditable(0);
//	       			   SetRangeBackColor(1,5, 2,31,"#8C8C8C");
		               SetHeaderRowHeight(10);
//		               SetSheetHeight(GetSheetHeight(8));
		               SetSheetHeight(170);
               }
                break;     
        }
    }
	/**
    *Tab Basic setting
     *Setting items of tab
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                	 var cnt=0 ;
                	 InsertItem( "By Office" , "");
                	 InsertItem( "By POL / POD" , "");
                	 InsertItem( "By Shipper " , "");
                	 InsertItem( "By Contractor" , "");
                } 
             break;
         }
         tabObj.SetSelectedIndex(0);
    }
    //Handling the process related with Sheet1
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
				if(checkModifiedSheet(sheetObj)){
			        if(ComShowConfirm (getMsg("SPC90001")) != 1){
			            return;
			        }
				}			
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }  
				formObj.f_cmd.value=SEARCHLIST01;		
				form.vvd1.value="";
				form.vvd2.value="";
				form.vvd3.value="";
				form.vvd4.value="";		
				var param=SpcFormString(formObj,'year1,week1,year2,week2,rhq_txt,only_vvd,trade,subtrade,lane,bound,onc_ipc,vvd1,rhq_gso1,weight1,vvd2,rhq_gso2,pol_pod2,weight2,vvd3,rhq_gso3,pol_pod3,weight3,vvd4,rhq_gso4,pol_pod4,weight4');
 				sheetObj.DoSearch("ESM_SPC_0022GS.do","f_cmd="+ SEARCHLIST01 +"&"+ param );
				break;
           case IBDOWNEXCEL:        //Excel download
               	if(sheetObj.RowCount() < 1){//no data	
               		ComShowCodeMessage("COM132501");
               	}else{	
               		if(sheetObj == sheetObjects[1] || sheetObj == sheetObjects[2] || sheetObj == sheetObjects[3] || sheetObj == sheetObjects[4] ) {
               			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
               		} //메인LIST는 다운로드 받지 않음
               	}	
             	break;
        }
    }
 	/**
	 *the event in case of clicking Tab
	* Activating the element of selected tab
	 */
	function tab1_OnChange(tabObj , nItem)
	{
        var objs=document.all.item("tabLayer");
		for(var i=0 ; i < objs.length ; i++){
			objs[i].style.display= "none";
		}
		objs[nItem].style.display="Inline";
		beforetab=nItem;
		if(save_vvd==null){
    		save_vvd="";
    	}
		if(nItem==0){			
			beforetab=1;
			// Showing the field in case of selecting check box
//			var obj=eval(sheetObjects[1].form.type1);
			var obj = document.form.type1;
        	changeTitle2('1', obj);
		}
		else if(nItem==1){
			beforetab=2;
			// Showing the field in case of selecting check box
//			var obj=eval(sheetObjects[2].form.type2);
			var obj = document.form.type2;
        	changeTitle2('2', obj);
		}
		else if(nItem==2){
			beforetab=3;
			// Showing the field in case of selecting check box
//			var obj=eval(sheetObjects[3].form.type3);
			var obj = document.form.type3;
        	changeTitle2('3', obj);
		}
		else if(nItem==3){
			beforetab=4;
			// Showing the field in case of selecting check box
//			var obj=eval(sheetObjects[4].form.type4);
			var obj = document.form.type4;
        	changeTitle2('4', obj);
		}
//		resizeSheet();
	}
 	/*
 	 *Retrieving tab page in case of clicking sheet1
 	 */
 	function sheet1_OnDblClick(sheetObj, row, col)
    {
    	var sheetObj=sheetObjects[0];
    	var sheetObj1=sheetObjects[beforetab + 1];
    	var formObj=document.form;
    	var year1=formObj.year1.value;
    	var week1=formObj.week1.value;
    	var year2=formObj.year2.value;
    	var week2=formObj.week2.value;
		var rhq_txt=comObjects[0].GetSelectCode();
		var pol_pod ;		
		var rhq_gso;
		var ocn_ipc;
		save_lane=sheetObj.GetCellValue(row, "LANE");
		save_bound=sheetObj.GetCellValue(row, "BOUND");
		save_vvd=sheetObj.GetCellValue(row, "VVD");
		save_trade=sheetObj.GetCellValue(row, "TRADE");
		save_subtrade=sheetObj.GetCellValue(row, "SUBTRADE");
		
    		//tab1 retrieve		
		formObj.vvd1.value=save_vvd;
		rhq_gso=_getRadioValue(formObj.rhq_gso1);
		pol_pod=_getRadioValue(formObj.pol_pod1);
		ocn_ipc=sheetObj.GetCellValue(row, "OCN_IPC");
		if(ocn_ipc=="OCN"){
			ocn_ipc="O";
		}else{
			ocn_ipc="I";
		}
		save_ocn_ipc=ocn_ipc;
		var param1="f_cmd="+SEARCHLIST02+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
		"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
		"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
 		sheetObjects[1].DoSearch("ESM_SPC_0022GS.do", param1 );
		// hidding TEU and showing Total TEU in case of FCAST (Handling fcast_ttl_teu_qty)
		var col_idx=sheetObjects[1].SaveNameCol("fcast_ttl_teu_qty");
		var type_sts=document.form.type1.checked;
//		2014.08.07 김용습 - 아래 부분에서 걸려 다음 탭 조회가 되지 않고, 헤더의 머지 버그가 발생하여 아래 부분 일단 주석처리 하였습니다
//		if(!type_sts) {
//		    sheetObjects[1].SetColHidden(col_idx + 1,1);
//		    sheetObjects[1].SetColWidth(col_idx,80);
//		}
		//tab2 retrieve		
		formObj.vvd2.value=save_vvd;
		rhq_gso=_getRadioValue(formObj.rhq_gso2);
		pol_pod=_getRadioValue(formObj.pol_pod2);
		ocn_ipc=sheetObj.GetCellValue(row, "OCN_IPC");
		if(ocn_ipc=="OCN"){
			ocn_ipc="O";
		}else{
			ocn_ipc="I";
		}
		save_ocn_ipc=ocn_ipc;
		var param2="f_cmd="+SEARCHLIST03+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
		"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
		"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
 		sheetObjects[2].DoSearch("ESM_SPC_0022GS.do", param2 );
		// hidding TEU and showing Total TEU in case of FCAST (Handling fcast_ttl_teu_qty)
		col_idx=sheetObjects[2].SaveNameCol("fcast_ttl_teu_qty");
		type_sts=document.form.type2.checked;
//		2014.08.07 김용습 - 아래 부분에서 걸려 다음 탭 조회가 되지 않고, 헤더의 머지 버그가 발생하여 아래 부분 일단 주석처리 하였습니다
//		if(!type_sts) {
//		    sheetObjects[2].SetColHidden(col_idx + 1,1);
//		    sheetObjects[2].SetColWidth(col_idx,80);
//		}
		//tab3 retrieve		
		formObj.vvd3.value=save_vvd;
        rhq_gs=_getRadioValue(formObj.rhq_gso3);
       	pol_pod=_getRadioValue(formObj.pol_pod3);
       	ocn_ipc=sheetObj.GetCellValue(row, "OCN_IPC");
		if(ocn_ipc=="OCN"){
			ocn_ipc="O";
		}else{
			ocn_ipc="I";
		}
		save_ocn_ipc=ocn_ipc;
		var param3="f_cmd="+SEARCHLIST04+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
		"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
		"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
 		sheetObjects[3].DoSearch("ESM_SPC_0022GS.do", param3 );
		// hidding TEU and showing Total TEU in case of FCAST (Handling fcast_ttl_teu_qty)
		col_idx=sheetObjects[3].SaveNameCol("fcast_ttl_teu_qty");
		type_sts=document.form.type3.checked;
//		2014.08.07 김용습 - 아래 부분에서 걸려 다음 탭 조회가 되지 않고, 헤더의 머지 버그가 발생하여 아래 부분 일단 주석처리 하였습니다
//		if(!type_sts) {
//		    sheetObjects[3].SetColHidden(col_idx + 1,1);
//		    sheetObjects[3].SetColWidth(col_idx,80);
//		}
       //tab4 retrieve		
		formObj.vvd4.value=save_vvd;
		//formObj.vvd4.value = save_vvd;
        //save_vvd = sheetObj.CellValue(row, "VVD");
        rhq_gs=_getRadioValue(formObj.rhq_gso4);
       	pol_pod=_getRadioValue(formObj.pol_pod4);
       	ocn_ipc=sheetObj.GetCellValue(row, "OCN_IPC");
		if(ocn_ipc=="OCN"){
			ocn_ipc="O";
		}else{
			ocn_ipc="I";
		}
		save_ocn_ipc=ocn_ipc;
		var param4="f_cmd="+SEARCHLIST05+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
		"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
		"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
 		sheetObjects[4].DoSearch("ESM_SPC_0022GS.do", param4 );
		// hidding TEU and showing Total TEU in case of FCAST (Handling fcast_ttl_teu_qty)
		col_idx=sheetObjects[4].SaveNameCol("fcast_ttl_teu_qty");
		type_sts=document.form.type4.checked;
//		2014.08.07 김용습 - 아래 부분에서 걸려 다음 탭 조회가 되지 않고, 헤더의 머지 버그가 발생하여 아래 부분 일단 주석처리 하였습니다
//		if(!type_sts) {
//		    sheetObjects[4].SetColHidden(col_idx + 1,1);
//		    sheetObjects[4].SetColWidth(col_idx,80);
//		}
    }
    /*
     *clearing tab sheet after retrieving sheet1
     */
    function sheet1_OnSearchEnd(sheetObj , ErrMsg){
        var sheetObject1=sheetObjects[1];
        var sheetObject2=sheetObjects[2];
        var sheetObject3=sheetObjects[3];
        var sheetObject4=sheetObjects[4];
        if(ErrMsg== ""){	   
            sheetObject1.RemoveAll();
            sheetObject2.RemoveAll();
            sheetObject3.RemoveAll();
            sheetObject4.RemoveAll();
      	}
    }
    /*
     * RHQ/POL title
     */
    function changeTitle_Colum(form_name)
    {   
       	var rhq_gso;
    	var pol_pod;
    	var sheetObj1=sheetObjects[beforetab];
		var formObj=document.form;
		var year1=formObj.year1.value;
    	var week1=formObj.week1.value;
    	var year2=formObj.year2.value;
    	var week2=formObj.week2.value;
		var rhq_txt=comObjects[0].GetSelectCode();
		var vvd;
		var ocn_ipc=save_ocn_ipc;
    	if(form_name=="1"){
    		rhq_gso=_getRadioValue(formObj.rhq_gso1);
    		pol_pod=_getRadioValue(formObj.pol_pod1);
			vvd=formObj.vvd1.value;
			if(rhq_gso=="RHQ"){
				sheetObj1.SetCellText(0,1 ,"Area/RHQ");
				sheetObj1.SetCellText(1,1 ,"Area/RHQ");
				sheetObj1.SetCellText(2,1 ,"Area/RHQ");
			}else{
				sheetObj1.SetCellText(0,1 ,"Office");
				sheetObj1.SetCellText(1,1 ,"Office");
				sheetObj1.SetCellText(2,1 ,"Office");
			}
			if(vvd==""){
				ComShowMessage(getMsg("SPC90199", "VVD"));
				formObj.vvd1.focus();
				return;
			}else{
				var param="f_cmd="+SEARCHLIST02+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
				"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
				"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
 				sheetObj1.DoSearch("ESM_SPC_0022GS.do", param );
			}
    	}else if(form_name=="2"){
    		rhq_gso=_getRadioValue(formObj.rhq_gso2);
    		pol_pod=_getRadioValue(formObj.pol_pod2);
    		vvd=formObj.vvd2.value;
			if(rhq_gso=="RHQ"){
				if(pol_pod=="POL"){
					sheetObj1.SetCellText(0,1 ,"POL");
					sheetObj1.SetCellText(1,1 ,"POL");
					sheetObj1.SetCellText(2,1 ,"POL");
					sheetObj1.SetCellText(0,2 ,"RHQ");
					sheetObj1.SetCellText(1,2 ,"RHQ");
					sheetObj1.SetCellText(2,2 ,"RHQ");
				}else{
					sheetObj1.SetCellText(0,1 ,"POD");
					sheetObj1.SetCellText(1,1 ,"POD");
					sheetObj1.SetCellText(2,1 ,"POD");
					sheetObj1.SetCellText(0,2 ,"RHQ");
					sheetObj1.SetCellText(1,2 ,"RHQ");
					sheetObj1.SetCellText(2,2 ,"RHQ");
				}
			}else{
				if(pol_pod=="POL"){
					sheetObj1.SetCellText(0,1 ,"POL");
					sheetObj1.SetCellText(1,1 ,"POL");
					sheetObj1.SetCellText(2,1 ,"POL");
					sheetObj1.SetCellText(0,2 ,"Office");
					sheetObj1.SetCellText(1,2 ,"Office");
					sheetObj1.SetCellText(2,2 ,"Office");
				}else{
					sheetObj1.SetCellText(0,1 ,"POD");
					sheetObj1.SetCellText(1,1 ,"POD");
					sheetObj1.SetCellText(2,1 ,"POD");
					sheetObj1.SetCellText(0,2 ,"Office");
					sheetObj1.SetCellText(1,2 ,"Office");
					sheetObj1.SetCellText(2,2 ,"Office");
				}
			}
			if(vvd==""){
				ComShowMessage(getMsg("SPC90199", "VVD"));
				formObj.vvd2.focus();
				return;
			}else{
				var param="f_cmd="+SEARCHLIST03+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
				"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
				"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
 				sheetObj1.DoSearch("ESM_SPC_0022GS.do", param );
			}
    	}
    	else if(form_name=="3"){
    		rhq_gso=_getRadioValue(formObj.rhq_gso3);
    		pol_pod=_getRadioValue(formObj.pol_pod3);
    		vvd=formObj.vvd3.value;
			if(rhq_gso=="RHQ"){
				if(pol_pod=="POL"){
					sheetObj1.SetCellText(0,3 ,"POL");
					sheetObj1.SetCellText(1,3 ,"POL");
					sheetObj1.SetCellText(2,3 ,"POL");
					sheetObj1.SetCellText(0,4 ,"RHQ");
					sheetObj1.SetCellText(1,4 ,"RHQ");
					sheetObj1.SetCellText(2,4 ,"RHQ");
				}else{
					sheetObj1.SetCellText(0,3 ,"POD");
					sheetObj1.SetCellText(1,3 ,"POD");
					sheetObj1.SetCellText(2,3 ,"POD");
					sheetObj1.SetCellText(0,4 ,"RHQ");
					sheetObj1.SetCellText(1,4 ,"RHQ");
					sheetObj1.SetCellText(2,4 ,"RHQ");
				}
			}else{
				if(pol_pod=="POL"){
					sheetObj1.SetCellText(0,3 ,"POL");
					sheetObj1.SetCellText(1,3 ,"POL");
					sheetObj1.SetCellText(2,3 ,"POL");
					sheetObj1.SetCellText(0,4 ,"Office");
					sheetObj1.SetCellText(1,4 ,"Office");
					sheetObj1.SetCellText(2,4 ,"Office");
				}else{
					sheetObj1.SetCellText(0,3 ,"POD");
					sheetObj1.SetCellText(1,3 ,"POD");
					sheetObj1.SetCellText(2,3 ,"POD");
					sheetObj1.SetCellText(0,4 ,"Office");
					sheetObj1.SetCellText(1,4 ,"Office");
					sheetObj1.SetCellText(2,4 ,"Office");
				}
			}
			if(vvd==""){
				ComShowMessage(getMsg("SPC90199", "VVD"));
				formObj.vvd3.focus();
				return;
			}else{
				var param="f_cmd="+SEARCHLIST04+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
				"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
				"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
 				sheetObj1.DoSearch("ESM_SPC_0022GS.do", param );
			}
    	}
    	else if(form_name=="4"){
    		rhq_gso=_getRadioValue(formObj.rhq_gso4);
    		pol_pod=_getRadioValue(formObj.pol_pod4);
    		vvd=formObj.vvd4.value;
            if(rhq_gso=="RHQ"){
				if(pol_pod=="POL"){
					sheetObj1.SetCellText(0,3 ,"POL");
					sheetObj1.SetCellText(1,3 ,"POL");
					sheetObj1.SetCellText(2,3 ,"POL");
					sheetObj1.SetCellText(0,4 ,"RHQ");
					sheetObj1.SetCellText(1,4 ,"RHQ");
					sheetObj1.SetCellText(2,4 ,"RHQ");
				}else{
					sheetObj1.SetCellText(0,3 ,"POD");
					sheetObj1.SetCellText(1,3 ,"POD");
					sheetObj1.SetCellText(2,3 ,"POD");
					sheetObj1.SetCellText(0,4 ,"RHQ");
					sheetObj1.SetCellText(1,4 ,"RHQ");
					sheetObj1.SetCellText(2,4 ,"RHQ");
				}
			}else{
				if(pol_pod=="POL"){
					sheetObj1.SetCellText(0,3 ,"POL");
					sheetObj1.SetCellText(1,3 ,"POL");
					sheetObj1.SetCellText(2,3 ,"POL");
					sheetObj1.SetCellText(0,4 ,"Office");
					sheetObj1.SetCellText(1,4 ,"Office");
					sheetObj1.SetCellText(2,4 ,"Office");
				}else{
					sheetObj1.SetCellText(0,3 ,"POD");
					sheetObj1.SetCellText(1,3 ,"POD");
					sheetObj1.SetCellText(2,3 ,"POD");
					sheetObj1.SetCellText(0,4 ,"Office");
					sheetObj1.SetCellText(1,4 ,"Office");
					sheetObj1.SetCellText(2,4 ,"Office");
				}
			}
			if(vvd==""){
				ComShowMessage(getMsg("SPC90199", "VVD"));
				formObj.vvd4.focus();
				return;
			}else{
				var param="f_cmd="+SEARCHLIST05+"&year1="+year1+"&week1="+week1+"&year2="+year2+"&week2="+week2+
				"&lane="+save_lane+"&bound="+save_bound+"&vvd="+save_vvd+"&rhq_txt="+rhq_txt+"&pol_pod="+pol_pod+
				"&rhq_gso="+rhq_gso+"&onc_ipc="+save_ocn_ipc+"&trade="+save_trade+"&subtrade="+save_subtrade;
 				sheetObj1.DoSearch("ESM_SPC_0022GS.do", param );
			}
    	}
    }	
    function changePolPod(tab){
		var atab=tab;
		if(tab){
			tab=tab - 1;
		}
		else{
			tab=beforetab - 1;
		}
        var formObj=document.form;
        var chkObj=tab==0?formObj.chkPolPodS:formObj.chkPolPodC;
        var selPort=chkObj[0].checked?"POL":"POD";
        var sheetObj=sheetObjects[tab + 2];
        var row=-1;
        while((row=sheetObj.FindText("flg", selPort, row+1)) > 0){
            sheetObj.SetRowHidden(row,0);
        }
        selPort=chkObj[0].checked?"POD":"POL";
        while((row=sheetObj.FindText("flg", selPort, row+1)) > 0){
            sheetObj.SetRowHidden(row,1);
        }
    } 	
    /*
     *Showing or hidding the title in case of selecting View by Type
     */
    function changeTitle2(form_name, obj){    	
    	var sheetObj;
    	var sts, weight; 
//    	var obj1=eval(sheetObjects[1].form.weight1);
    	var obj1= form.weight1;
    	sheetObj=sheetObjects[form_name * 1];
    	sts=obj.checked;
		sheetObj.RenderSheet(0);
		var beforeCol="";
    	for (i=0; i<=sheetObj.LastCol(); i++) {
    		var colName=sheetObj.ColSaveName(i);
    		switch(colName.substring(4)){
    			case "teu":
    			case "ttl"://Weight
    				sheetObj.SetColWidth(i,sts?60:80);
    				break;
    			case "d2":
    			case "d4":
    			case "d5":
    			case "d7":
    			case "53":
    			case "rf":
    				sheetObj.SetColHidden(i,!sts);
    				break;
    		}
    		// hidding TEU and showing Total TEU in case of FCAST (Handling fcast_ttl_teu_qty)
    		if(beforeCol == 'fcast_ttl_teu_qty' && colName == 'vol_teu') {
    		    if(sts) {
    		        sheetObj.SetColHidden(i,0);
    		        sheetObj.SetColWidth(i,60);
    		        sheetObj.SetColWidth(i-1,60);
    		    }
    		    else {
    		        sheetObj.SetColHidden(i,1);
    		        sheetObj.SetColWidth(i-1,80);
    		    }
    		}    		
    		beforeCol=colName;
      	}
      	sheetObj.RenderSheet(1);
    }
    /*
     * View by Weight
     */
    function changeTitle1(form_name, obj){    	
    	var sheetObj;
    	var sts, weight; 
    	sheetObj=sheetObjects[form_name * 1];
    	sts=obj.checked;
		sheetObj.RenderSheet(0);
    	for (i=0; i<=sheetObj.LastCol(); i++) {
    		var colName=sheetObj.ColSaveName(i);
    		switch(colName){
    			case "wgt_ttl":
    				sheetObj.SetColHidden(i,!sts);
    				break;
    		}
      	}
      	sheetObj.RenderSheet(1);
    }
    /*
    *Setting the value of ofc_cd  in case logined ofc_cd is not 'SELHO'
     */    
//    function rhq_txt1_OnLoadFinish(){
//    	var formObj=document.form;
//    	if(formObj.ofc_cd.value!="SELHO"){
//    		comObjects[0].SetEnable(0);
//    		comObjects[0].SetSelectText(formObj.ofc_cd.value,false);
//    		comObjects[0].SetSelectCode(formObj.ofc_cd.value,false);
//    	}
//    } 
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			var ovvd=formObj.only_vvd.value;
			var rhq=comObjects[0].GetSelectCode();
			var wk=calcPeriod(year1.value,week1.value,year2.value,week2.value);
            if(ovvd!="" && ovvd.length<9){
            	ComShowMessage(getMsg("SPC90116","VVD")); 
                formObj.only_vvd.focus();
                return false;
            }else if(ovvd==""){
	            if( wk < 0 ){
	            	ComShowMessage(getMsg("SPC90115","Period")); 
	                formObj.year1.focus();
	                return false;
	            }
            }
            if(rhq==""){
            	ComShowMessage(getMsg("SPC90114","RHQ")); 
                formObj.year1.focus();
                comObjects[0].Focus();
                return false;
            }
		}
        return true;
    }
     /*
      * Returning one of selected radio Object value
      * @param     oRadio : object Radio
      * @return    String
      */
     function _getRadioValue(oRadio) {
         if (oRadio == null) return "";
         if (oRadio.length != null)
         {
             for(i=0; i<oRadio.length; i++)
             {
                 if (oRadio[i].checked) return oRadio[i].value;
             } // end for
         } else  {
             if (oRadio.checked) return oRadio.value;
         } // end if
         return "";
     }
     
     function trade_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){  
     	if(newCode == "") return;
     	// sub_trade initialization
     	comObjects[2].SetSelectIndex(0,false);
     	// lane initialization
     	comObjects[3].SetSelectIndex(0,false);
     	
     	var formObj = document.form;
     	var trade = formObj.trade.value;
             	
     	if(trade != null && trade != ''){		
     		SpcSearchOptionSubTrade("subtrade",true,false, "", formObj.trade.value);			// 0207 SHKIM			
     		SpcSearchOptionLane("lane",true,true,'',formObj.trade.value,formObj.subtrade.value,true);	// 0207 SHKIM
     	}	           	
     }         
     function subtrade_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){  
     	if(newCode == "") return;
     	comObjects[1].SetSelectCode(comObj.GetText(newCode, 0), false);
     	// lane initialization
     	comObjects[3].SetSelectIndex(0, false);
     	
 		var formObj = document.form;
 		var subtrade = formObj.subtrade.value;
 	
 		if(subtrade != null && subtrade != ''){		
 			SpcSearchOptionLane("lane",true,true,'',formObj.trade.value,formObj.subtrade.value,true);	// 0207 SHKIM
 		}	           	
     } 
     function lane_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
     	if(newCode == "" ) return;
     	var repTrade=comObj.GetText(newCode,0);  
     	var subTrade=comObj.GetText(newCode,1);
     	comObjects[1].SetSelectCode(repTrade,false);
     	comObjects[2].SetSelectCode(subTrade,false);
     }    
      

     function initDataValue_rhq_txt(){
      	var sheetObj=document.getElementById("rhq_txt");
      	with(sheetObj){
      		Index2=0;
      	}
      }
     function initDataValue_trade(){
     	var sheetObj=document.getElementById("trade");
     	with(sheetObj){
     		Index2=0;
     	}
     }
     function initDataValue_subtrade(){
     	var sheetObj=document.getElementById("subtrade");
     	with(sheetObj){
     		Index2=0;
     	}
     }
     function initDataValue_lane(){
     	var sheetObj=document.getElementById("lane");
     	with(sheetObj){
     		Index2=0;
     	}
     }
     function optionSetting() {
    	 SpcSearchOptionYear("year1");
      	 SpcSearchOptionWeek("week1");
      	 SpcSearchOptionYear("year2");
      	 SpcSearchOptionWeek("week2");
      	 
      	 if(document.form.ofc_cd.value=='SINHO'){
      		 SpcSearchOptionRhq("rhq_txt");
      	 }else{
      		 SpcSearchOptionRhq("rhq_txt","","","",true);
      	 }
      	 SpcSearchOptionTrade("trade");
      	 SpcSearchOptionSubTrade("subtrade");
      	 SpcSearchOptionLane("lane");
      	 SpcSearchOptionBound("bound");
      	 SpcSearchOptionComCode("onc_ipc", "CD00206");
      }
     
      /**
       * This method counts numbers again.
       * @param Col
       * @param SortArrow
       */
      //2014.08.06 김용습 - 정렬시 SEQ. 무너지는 버그 해결하기 위해 추가한 메소드
      function sheet1_OnSort(Col, SortArrow){
    	  sheet1.ReNumberSeq();
      }
      
//      function resizeSheet(){
//          for(var i=1;i<sheetObjects.length;i++){
//             ComResizeSheet(sheetObjects[i]);
//          }    		
//      }
