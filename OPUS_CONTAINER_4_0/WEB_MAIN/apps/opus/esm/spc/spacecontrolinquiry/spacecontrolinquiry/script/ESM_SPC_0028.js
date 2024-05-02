/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 :  ESM_SPC_0028.js
*@FileTitle  : Inquiry by Sub Office 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
    var save_trade;		//selected trade in case of double-clicking
    var save_subtrade	//selected subtrade in case of double-clicking
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
             var formObject=document.form;
        	//try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
            	    case "btn_retrieve":
//            			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
            			sheetObjects[0].RemoveAll();
            			sheetObjects[1].RemoveAll();
            			sheetObjects[2].RemoveAll();
            			sheetObjects[3].RemoveAll();
            			
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	            break;
    				case "btn_new":
    					if(checkModifiedSheet(sheetObject)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//using common funtion : initializing the screen
//    					sheet1.RemoveAll();
//    					t1sheet1.RemoveAll();
//    					t1sheet2.RemoveAll();
//    					t1sheet3.RemoveAll();
//    					formObject.reset(); 
    					formObject.sales_office.value="";
    					resetAll(); 
    					break;
    				case "btn_downexcel":			
    					if(beforetab==0){
        	            	doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
        	            }else if(beforetab==1){
        	            	doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
        	            }else if(beforetab==2){
        	            	doActionIBSheet(sheetObjects[3],formObject,IBDOWNEXCEL);
        	            }
    				case "maxi":
    					doZoom();
    					break;		
                } // end switch
        	//}catch(e) {
        	//	if( e == "[object Error]") {
        	//		ComShowCodeMessage("COM12111");
        	//	} else {
        	//		ComShowMessage(e);
        	//	}
        	//}
        }

        function doZoom() {
        	var obj = ComGetEvent();
        	var sheetId = obj.getAttributeNode("sheetId").value;
        	switch (sheetId) {
        	case "sheet1":
        		toggleSheetSize("wrap_search", "wrap_result2");
        		break;
        	case "t1sheet1":
        	case "t1sheet2":
        	case "t1sheet3":
        		toggleSheetSize("wrap_search", "wrap_result1", "tabArea");
        		break;
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
         * registering IBSheet Object as list
         * adding process for list in case of needing batch processing with other items
         * defining list on the top of source
         */
        function setComboObject(combo_obj){
    		comObjects[comboCnt++]=combo_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen
         */
        function loadPage() {
        	optionSetting();
        	var objs= document.all.item("tabLayer");
    		var tdisp = false;
            for(var i=0;i<sheetObjects.length;i++){
                // change the name of start environment setting funtion
                ComConfigSheet (sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            var sheetResizeFull=true;
    		document_onresize();
//            resizeSheet();
            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);  
                tabObjects[k].SetSelectedIndex(0);
            }
//            if(isDevMode){
//            	
//            }
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
//		                  var HeadTitle0="SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|Load QTA|Load QTA|Forecast|" +
//		                  "Forecast|Alloc|Alloc|Alloc|Booking|Booking|Booking|Booking|RATIO";
//		                  var HeadTitle1="SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|VOL|CMB|VOL|WGT|VOL|WT|TS|" +
//		                  "Firm|Waiting|Total|WGT|RATIO";
		                  
		                  var HeadTitle0 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|Load QTA|Load QTA|Forecast|" +
                  			"Forecast|Forecast|Forecast|Alloc|Alloc|Alloc|Alloc|Booking|Booking|Booking|Booking|Booking|Booking|RATIO| ";
		                  var HeadTitle1 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|VOL|CMPB|VOL|WGT|T/S|T/S|VOL|WT|T/S|T/S|" +
                  			"Firm|Waiting|Total|WGT|T/S|T/S|RATIO| ";
		                  var HeadTitle2 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|VOL|CMPB|VOL|WGT|VOL|WGT|VOL|WT|VOL|WGT|" +
		                  "Firm|Waiting|Total|WGT|VOL|WGT|RATIO| ";
		                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		                  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		                  var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		                  InitHeaders(headers, info);		
		                  var cols = [   {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"TRADE",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SUBTRADE",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"LANE",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"BOUND",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"WEEK",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"VVD",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         //Load QTA
				                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         //Forecast
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         //Alloc
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"NullFloatr",  PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"NullFloatr",  PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         //Booking
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 }, 
				                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                         //Ratio
				                         {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 }];
		                   
		                  InitColumns(cols);
		                  SetEditable(0);
//		                  SetSheetHeight(250);
		                  SetHeaderRowHeight(8);
		                  SetSheetHeight(ComGetSheetHeight(sheetObj, 7));
		                  SetFocusEditMode(default_edit_mode);
//		                  SetRangeBackColor(1,7, 1,17,"#8C8C8C");
                  }
                   break;
                case 2:     //t1sheet1 init
                    with(sheetObj){
		                  var HeadTitle="OCN\nIPC\nTS|OFC|POL|POD|TREE|Load\nQuota|";
		                  var HeadTitle1=HeadTitle + "Forecast|Forecast|Forecast|Forecast|Forecast|" +
		                  "Forecast|Forecast|Allocation|Allocation|Allocation|Allocation|Allocation|" +
		                  "Allocation|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|" +
		                  "Firm Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|" +
		                  "Waiting Booking|Waiting Booking|Total Booking|Total Booking|Total Booking|Total Booking|Total Booking|" +
		                  "Total Booking|Total Booking|Total Booking";
		                  var HeadTitle2=HeadTitle + "Vol|Vol|Vol|Vol|Vol|Vol|Weight|" +
		                  "Vol|Vol|Vol|Vol|Vol|Weight|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight|Vol|Vol|" +
		                  "Vol|Vol|Vol|Vol|Vol|Weight|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight";
		                  var HeadTitle3=HeadTitle + "Total TEU|TEU|HC|45'|53'|Reefer|Weight|TEU|HC|45'|53'|" +
		                  "Reefer|Weight|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight|" +
		                  "Total TEU|20'|40'|HC|45'|53'|Reefer|Weight";
//		                  SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		                  SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7  } );
		                  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		                  var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
		                  InitHeaders(headers, info);
		                  var cols = [ 
		                             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"proj_teu",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"proj_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"proj_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"proj_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"proj_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"proj_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"alloc_teu",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"alloc_d5",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"alloc_d7",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"alloc_53",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"alloc_rf",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"alloc_wt",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"firm_teu",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"firm_d2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"firm_d4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"firm_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"firm_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"firm_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"firm_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"firm_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"book_teu",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"book_d2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"book_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"book_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"totl_teu",           KeyField:0,   CalcLogic:"|firm_teu|+|book_teu|",Format:"",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d2",            KeyField:0,   CalcLogic:"|firm_d2|+|book_d2|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d4",            KeyField:0,   CalcLogic:"|firm_d4|+|book_d4|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d5",            KeyField:0,   CalcLogic:"|firm_d5|+|book_d5|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d7",            KeyField:0,   CalcLogic:"|firm_d7|+|book_d7|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_53",            KeyField:0,   CalcLogic:"|firm_53|+|book_53|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"totl_rf",            KeyField:0,   CalcLogic:"|firm_rf|+|book_rf|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"totl_wt",            KeyField:0,   CalcLogic:"|firm_wt|+|book_wt|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         {Type:"Text",      Hidden:0,  Width:01,   Align:"Right",   ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                   
		                  InitColumns(cols);
		                  SetEditable(0); 
		                  SetSheetHeight(165);
		                  SetFocusEditMode(default_edit_mode);
//		                  SetRangeBackColor(1,6, 2,37,"#8C8C8C");
//		                  InitTreeInfo(4, "tree");
		                  SetHeaderRowHeight(10);
		                  
                  }
                   break;
                case 3:      //t2sheet2 init
                    with(sheetObj){
		                  var HeadTitle0="SEQ|Customer\nCode|Customer\nName|PORT|OFC|Forecast|Forecast"
		                  + "|Forecast|Forecast|Forecast|Forecast|Forecast|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|"
		                  + "Firm Booking|Firm Booking|Firm Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|"
		                  + "Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Total Booking|Total Booking|Total Booking|"
		                  + "Total Booking|Total Booking|Total Booking|Total Booking|Total Booking";
		                  var HeadTitle1="SEQ|Customer\nCode|Customer\nName|PORT|OFC|Vol|Vol|Vol|Vol|Vol|"
		                  + "Vol|Weight\n(Ton)"
		                  + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
		                  + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
		                  + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)";
		                  var HeadTitle2="SEQ|Customer\nCode|Customer\nName|PORT|OFC|Total TEU|TEU|HC|45'|53'|Reefer|Weight\n(Ton)"
		                  + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
		                  + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
		                  + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)";
		                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		                  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		                  var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		                  InitHeaders(headers, info);
		                  var cols = [ 
		                         {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"proj_teu",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"proj_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"proj_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"proj_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"proj_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"proj_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"firm_teu",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_d2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_d4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"firm_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"firm_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"book_teu",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"book_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"book_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"totl_teu",           KeyField:0,   CalcLogic:"|firm_teu|+|book_teu|",Format:"",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d2",            KeyField:0,   CalcLogic:"|firm_d2|+|book_d2|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d4",            KeyField:0,   CalcLogic:"|firm_d4|+|book_d4|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d5",            KeyField:0,   CalcLogic:"|firm_d5|+|book_d5|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d7",            KeyField:0,   CalcLogic:"|firm_d7|+|book_d7|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_53",            KeyField:0,   CalcLogic:"|firm_53|+|book_53|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"totl_rf",            KeyField:0,   CalcLogic:"|firm_rf|+|book_rf|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"totl_wt",            KeyField:0,   CalcLogic:"|firm_wt|+|book_wt|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:1, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                   
		                  InitColumns(cols);
		                  SetEditable(0);   
		                  SetSheetHeight(170);
		                  SetFocusEditMode(default_edit_mode);
//		                  SetRangeBackColor(1,5, 2,32,"#8C8C8C");
		                  SetHeaderRowHeight(10);
                  }
                    break;
                case 4:      //t2sheet2 init
                    with(sheetObj){
		                  var HeadTitle0="SEQ|Customer\nCode|Customer\nName|PORT|OFC|Forecast|Forecast|Forecast"
		                  + "|Forecast|Forecast|Forecast|Forecast|Firm Booking|Firm Booking|Firm Booking|Firm Booking|Firm Booking|"
		                  + "Firm Booking|Firm Booking|Firm Booking|Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|"
		                  + "Waiting Booking|Waiting Booking|Waiting Booking|Waiting Booking|Total Booking|Total Booking|Total Booking|"
		                  + "Total Booking|Total Booking|Total Booking|Total Booking|Total Booking";
		                  var HeadTitle1="SEQ|Customer\nCode|Customer\nName|PORT|OFC|Vol|Vol|Vol|Vol|Vol|"
		                  + "Vol|Weight\n(Ton)"
		                  + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
		                  + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)"
		                  + "|Vol|Vol|Vol|Vol|Vol|Vol|Vol|Weight\n(Ton)";
		                  var HeadTitle2="SEQ|Customer\nCode|Customer\nName|PORT|OFC|Total TEU|TEU|HC|45'|53'|Reefer|Weight\n(Ton)"
		                  + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
		                  + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)"
		                  + "|Total TEU|20'|40'|HC|45'|53'|Reefer|Weight\n(Ton)";
		                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		                  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		                  var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		                  InitHeaders(headers, info);
		                  var cols = [ 
		                         {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"proj_teu",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"proj_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"proj_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"proj_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"proj_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"proj_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"firm_teu",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_d2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_d4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"firm_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"firm_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"firm_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"book_teu",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"book_53",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"book_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"book_wt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"totl_teu",           KeyField:0,   CalcLogic:"|firm_teu|+|book_teu|",Format:"",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d2",            KeyField:0,   CalcLogic:"|firm_d2|+|book_d2|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d4",            KeyField:0,   CalcLogic:"|firm_d4|+|book_d4|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d5",            KeyField:0,   CalcLogic:"|firm_d5|+|book_d5|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_d7",            KeyField:0,   CalcLogic:"|firm_d7|+|book_d7|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"totl_53",            KeyField:0,   CalcLogic:"|firm_53|+|book_53|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"totl_rf",            KeyField:0,   CalcLogic:"|firm_rf|+|book_rf|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"totl_wt",            KeyField:0,   CalcLogic:"|firm_wt|+|book_wt|",Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:1,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                   
		                  InitColumns(cols);
		                  SetEditable(0);
		                  SetSheetHeight(170);
		                  SetFocusEditMode(default_edit_mode);
//		                  SetRangeBackColor(1,5, 2,32,"#8C8C8C");
		                  SetHeaderRowHeight(10);
                  }
                    break;
            }
        }
      // Handling the process related with sheet1
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
    				formObj.vvd[0].value="";
    				formObj.vvd[1].value="";
    				var param="year1=" + formObj.year1.value;
    				param=param + "&week1="        + formObj.week1.value;
    				param=param + "&year2="        + formObj.year2.value;
    				param=param + "&week2="        + formObj.week2.value;
    				param=param + "&only_vvd="     + formObj.only_vvd.value;
    				param=param + "&sales_office=" + formObj.sales_office.value;
    				param=param + "&trade="        + comObjects[0].GetSelectCode();
        			param=param + "&subtrade="     + comObjects[1].GetSelectCode();
        			param=param + "&lane="         + comObjects[2].GetSelectCode();
        			param=param + "&bound="        + formObj.bound.value;
    				sheetObj.DoSearch("ESM_SPC_0028GS.do","f_cmd=" + (SEARCHLIST01)+"&"+param  );
    				break;
               case IBDOWNEXCEL:        //Excel download
                 	
                   	if(sheetObj.RowCount() < 1){//no data	
                   		ComShowCodeMessage("COM132501");
                   	} else {	
                       		if(sheetObj == sheetObjects[1] || sheetObj == sheetObjects[2] || sheetObj == sheetObjects[3]) {
                       			sheetObj.Down2Excel( {DownRows:"Visible", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
                       		} //메인LIST는 다운로드 받지 않음
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
        *Tab Basic setting
         *Setting items of tab
         */
        function initTab(tabObj , tabNo) {
             switch(tabNo) {
                 case 1:
                    with (tabObj) {
                        var cnt=0 ;
						InsertItem( "By Office" , "");
						InsertItem( "By Shipper " , "");
						InsertItem( "By Contractor " , "");
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
         	objs[nItem].style.display="Inline";
         	for(var i = 0; i<objs.length; i++){
  		       if(i != nItem){
  		        objs[i].style.display="none";
  		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
  		       }
  		      }
         	beforetab=nItem;
//         	resizeSheet();
        }	
        /*
     	 *Retrieving tab page in case of clicking sheet1
     	 */
     	function sheet1_OnDblClick(sheetObj, row, col)
        {
        	var sheetObj=sheetObjects[0];
        	var sheetObj1=sheetObjects[beforetab+1];
        	var formObj=document.form;
        	var year1=formObj.year1.value;
        	var week1=formObj.week1.value;
        	var year2=formObj.year2.value;
        	var week2=formObj.week2.value;
    		var sales_office=formObj.sales_office.value;
    		var pol_pod ;		        
			save_lane=sheetObj.GetCellValue(row, "LANE");
			save_bound=sheetObj.GetCellValue(row, "BOUND");
			save_vvd=sheetObj.GetCellValue(row, "VVD");
			save_trade=sheetObj.GetCellValue(row, "TRADE");
			save_subtrade=sheetObj.GetCellValue(row, "SUBTRADE");
    		for(var i=0 ; i < formObj.vvd.length ; i++){
    			formObj.vvd[i].value=save_vvd;
    		}
    		var paramCond="&year1="        + year1
    		              + "&week1="        + week1
    		              + "&year2="        + year2
    		              + "&week2="        + week2
    		              + "&sales_office=" + sales_office
    		              + "&lane="         + save_lane
    		              + "&bound="        + save_bound
    		              + "&vvd="          + save_vvd
    		              + "&pol_pod=POL"
    		              + "&trade="        + save_trade
    		              + "&subtrade="     + save_subtrade;
    		var param="f_cmd="+SEARCHLIST02+paramCond;
    		var datas=sheetObjects[beforetab+1].GetSearchData("ESM_SPC_0028GS.do", param);
    		var xmls=datas.split("[+]");
    		for(var j=0 ; j < xmls.length ; j++){
    			sheetObjects[j+1].LoadSearchData(xmls[j],{Sync:1} );
    		}
        }
        /*
         *clearing tab sheet after retrieving sheet1
         */
        function sheet1_OnSearchEnd(sheetObj , ErrMsg){
            if(ErrMsg== ""){	   
            	for(var i=1 ; i < sheetObjects.length ; i++){ 
                	sheetObjects[i].RemoveAll();
                }
          	}
        }
        /*
         *clearing tab sheet after retrieving sheet1
         */
    	var ctrl_port=false;
    	var ctrl_d5=false;
    	var ctrl_d7=false;
    	var ctrl_53=false;
    	var ctrl_rf=false;
    	var ctrl_wt=false;
    	
        function t1sheet1_OnSearchEnd(sheetObj , ErrMsg){        	
        	ctrl_port=sheetObj.GetEtcData("pol_pod");
        	ctrl_d5=sheetObj.GetEtcData("hc40") == "Y";
        	ctrl_d7=sheetObj.GetEtcData("hc45") == "Y";
        	ctrl_53=sheetObj.GetEtcData("ft53") == "Y";
        	ctrl_rf=sheetObj.GetEtcData("reefer") == "Y";
        	ctrl_wt=sheetObj.GetEtcData("weight") == "Y";
        	var formObj=document.form;
        	
        	formObj.chkPort.value=ctrl_port;
        	formObj.chkHC40.checked=ctrl_d5;
        	formObj.chkHC45.checked=ctrl_d7;
        	formObj.chk53FT.checked=ctrl_53;
        	formObj.chkRFR.checked=ctrl_rf;
        	formObj.chkWGT.checked=ctrl_wt;
//        	formObj.chkPol.checked=ctrl_port=="L" || ctrl_port=="D";
//        	formObj.chkPod.checked=ctrl_port=="D";
        	
        	//20160317.ADD : 첫초기화해야함.
    		formObj.chkPod.checked = false;
    		formObj.chkPol.checked = false;  
    		
        	if(ctrl_port=="D"){
        		formObj.chkPod.checked = true;
        		formObj.chkPol.checked = true;        		
        	}
        	if(ctrl_port=="L"){
        		formObj.chkPol.checked = true;
        		formObj.chkPod.checked = false;
        		var rowCnt = sheetObj.RowCount() + 3;
				for(var i=3 ; i < rowCnt ; i++){
					if(sheetObj.GetCellValue(i, "pod") == "" || sheetObj.GetCellValue(i, "pod") == "-"){
						sheetObj.SetRowHidden(i,0);
					}else{
						sheetObj.SetRowHidden(i,1);
					}
				}
        	}
        	formObj.chkTYP[0].checked=(ctrl_d5 || ctrl_d7 || ctrl_rf);
        	
        	//20160317.MOD
        	if(ctrl_port=="D"){
        		changePort(formObj.chkPod);
        	} else {
        		changePort(formObj.chkPol);
        	}
        	changeTpSz(0);
        	changeWgt(0);
        }

        /*
         *Clearing tab sheet after retrieving t1sheet1
         */
        function t1sheet2_OnSearchEnd(sheetObj , ErrMsg){
            changePolPod(1);
        	changeTpSz(1);
        	changeWgt(1);
        }
        /*
         * Clearing tab sheet after retrieving t1sheet2
         */
        function t1sheet3_OnSearchEnd(sheetObj , ErrMsg){
            changePolPod(2);
        	changeTpSz(2);
        	changeWgt(2);
        }
        //20160317.MOD : 인수변동
    	function changePort(obj){
    		var formObj=document.form;				//20160317.MOD
    		var objName=obj.name;					//20160317.MOD
//    		if(event != null){						//20160317.DEL
//    			obj=event.srcElement;
//    			formObj=document.form;
//    			objName=obj.name;
//    		}
//    		else{
//    			formObj=document.form;
//    			objName="";
//    		}
    		var sheetObj=sheetObjects[1];    		
    		
    		var chkpol=document.form.chkPol.checked;
    		if(!chkpol) document.form.chkPod.checked = false;
    		var chkpod = document.form.chkPod.checked;
    		var rowCnt = sheetObj.RowCount() + 3;
    		switch(objName){
    			case "chkPol":
    				if(obj.checked){
    					for(var i=3 ; i < rowCnt ; i++){
    						if(chkpod == true){
    							sheetObj.SetRowHidden(i,0);
    						}else{
    							if(sheetObj.GetCellValue(i, "pod") == "" || sheetObj.GetCellValue(i, "pod") == "-"){
    								sheetObj.SetRowHidden(i,0);
    							}else{
    								sheetObj.SetRowHidden(i,1);
    							}
    						}
    					}
    				}else{
    					for(var i=3 ; i < rowCnt ; i++){
    						if(sheetObj.GetCellValue(i, "pol") == "-"){
    							sheetObj.SetRowHidden(i,0);
    						}else{
    							sheetObj.SetRowHidden(i,1);
    						}
    					}
    				}
    				break;
    			case "chkPod":
    				if(obj.checked){
    					for(var i=3 ; i < rowCnt ; i++){
    						sheetObj.SetRowHidden(i,0);
    					}
    				}else{
    					for(var i=3 ; i < rowCnt ; i++){
    						if(sheetObj.GetCellValue(i, "pod") == "" || sheetObj.GetCellValue(i, "pod") == "-"){
    							sheetObj.SetRowHidden(i,0);
    						}else{
    							sheetObj.SetRowHidden(i,1);
    						}
    					}
    				}
    				break;
    		}
    		sheetObj.SetColHidden("pol",!formObj.chkPol.checked);
    		sheetObj.SetColHidden("pod",!formObj.chkPod.checked);    		
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
    	function selectChange(){ 
    		var obj=event.srcElement;
    		var objName=obj.name;
    		switch(objName){
    			case "chkTYP":
    				changeTpSz(beforetab);
    				break;
    			case "chkWT":
    				changeWgt(beforetab);
    				break;
    		}
    	}
    	function changeTpSz(tab){
    		var formObj=document.form;
    		var obj=formObj.chkTYP[tab];
    		var hidden=!obj.checked;
    		var sheetObj=sheetObjects[tab+1];
    		var size=sheetObj.LastCol();
    		for(var i=0 ; i <= size ; i++){
    			var name=sheetObj.ColSaveName(i);
    			if(name == "") continue;
    			var names=name.split("_");
    			if(names.length == 1 || names[1] == "teu" || names[1] == "wt") continue; 
    			if(names[0] == "alloc"){
    				var checked=!eval("ctrl_" + names[1]);
    				sheetObj.SetColHidden(i,hidden || checked);
    			}
    			else{
    				sheetObj.SetColHidden(i,hidden);
    			}
    			// hidding TEU and showing Total TEU in case of FCAST (Handling fcast_ttl_teu_qty)
    			if(name == 'fcast_ttl_teu_qty'){//always showing Total TEU column
    			    sheetObj.SetColHidden(i,0);
    			    sheetObj.SetColHidden(i+1,hidden);
    			} 
    		}
    	}
    	function changeWgt(tab){
    		var formObj=document.form;
    		var obj=formObj.chkWT[tab];
    		var hidden=!obj.checked;
    		var sheetObj=sheetObjects[tab+1];
    		var size=sheetObj.LastCol();
    		for(var i=0 ; i <= size ; i++){
    			var name=sheetObj.ColSaveName(i);
    			if(name == "") continue;
    			var names=name.split("_");
    			if(names[1] != "wt") continue;
    			if(names[0] == "alloc"){
    				var checked=!eval("ctrl_" + names[1]);
    				sheetObj.SetColHidden(i,hidden || checked);
    			}
    			else{
    				sheetObj.SetColHidden(i,hidden);
    			}
    		}
    	}
    	/*
    	 * Checking inputed offce value
    	 */
    	 function checkValue() {
        	var formObj=document.form;
        	var value=formObj.sales_office.value;
        	value=ComTrim(value);//value=trim(value);
    		if(value.length>0){
    			if(value.length<5){
    				ComShowMessage(getMsg("SPC90116", "Office"));
    				formObj.sales_office.focus();
    				return;
    			}else{
    				var rtn=getCodeList("Office", "ofc_cd="+value);
    		    	if(rtn[0] == ""){    		
    		    		ComShowMessage(getMsg("SPC90106", value));
    		    		formObj.sales_office.focus();
    		    		return;
    		    	}	
    			}
    		}
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            var ovvd=formObj.only_vvd.value;
            var wk=calcPeriod(formObj.year1.value,formObj.week1.value,formObj.year2.value,formObj.week2.value);
    		var office=formObj.sales_office.value;
    		if(office==""){
    			ComShowMessage(getMsg("SPC90114", "Office"));
    			formObj.sales_office.focus();
    			return false; 
    		}
    		if(ovvd!="" && ovvd.length<9){
    			ComShowCodeMessage("COM12174", "VVD", "9"); 
                formObj.only_vvd.focus();
                return false;
            }else if(ovvd==""){
    			if( wk < 0 ){
                	ComShowMessage(getMsg("SPC90115","Period")); 
                    formObj.year1.focus();
                    return false;
                }
            }
            return true;
        }
        
        function trade_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){  
         	if(newCode == "") return;
         	// sub_trade initialization
         	comObjects[1].SetSelectIndex(0,false);
         	// lane initialization
         	comObjects[2].SetSelectIndex(0,false);
         	
         	var formObj = document.form;
         	var trade = formObj.trade.value;
                 	
         	if(trade != null && trade != ''){		
         		SpcSearchOptionSubTrade("subtrade",true,false, "", formObj.trade.value);			// 0207 SHKIM			
         		SpcSearchOptionLane("lane",true,true,'',formObj.trade.value,formObj.subtrade.value,true);	// 0207 SHKIM
         	}	           	
         }         
         function subtrade_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){  
         	if(newCode == "") return;
         	comObjects[0].SetSelectCode(comObj.GetText(newCode, 0), false);
         	// lane initialization
         	comObjects[2].SetSelectIndex(0, false);
         	
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
         	comObjects[0].SetSelectCode(repTrade,false);
         	comObjects[1].SetSelectCode(subTrade,false);
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
         	SpcSearchOptionTrade("trade");
         	SpcSearchOptionSubTrade("subtrade");
         	SpcSearchOptionLane("lane");
         	SpcSearchOptionBound("bound");
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
        
//    	function resizeSheet(){
//            for(var i=1;i<sheetObjects.length;i++){
//                ComResizeSheet(sheetObjects[i]);
//            }    		
//    	}