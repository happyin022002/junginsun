/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0021.js
*@FileTitle  : Daily Forecast Status
*@author     : CLT 
*@version    : 1.0
*@since      : 2014/07/07
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
    var beforetab=1;
    //retrive check
    var check_retrive=false;
    var tab_retrives=new Array(3);
    var week;
    var fdtd;
    var rtn; 
    var portv;
    var week1;
    var fdtd1;
    var rtn1;  
    var portv1;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /***** setting additional sheet value in case of more 2 sheet per tab *****/
             /*******************************************************/
             var sheetObject=sheet1;
             var sheetObject1=sheet2;
             var sheetObject2=sheet3;
             var sheetObject3=sheet4;
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
            	    case "btn_retrieve":
            	    	
        	            for(var i=0 ; i < sheetObjects.length; i++){
    				        tab_retrives[i]=false;
    				    }
    				    check_retrive=true;
        	            if(beforetab==0){ 
        	            	doActionIBSheet(sheet1,formObject,IBSEARCH);
        	            	tab_retrives[0]=true;
        	            }else if(beforetab==1){ 
        	            	doActionIBSheet(sheet2,formObject,IBSEARCH);
        	            	tab_retrives[1]=true;
        	            }else if(beforetab==2){ 
        	            	doActionIBSheet(sheet3,formObject,IBSEARCH);
        	            	tab_retrives[2]=true;
        	            }else if(beforetab==3){ 
        	            	doActionIBSheet(sheet4,formObject,IBSEARCH);
        	            	tab_retrives[3]=true;
        	            }
            	        break;
            	    case "btn_new":
    					if(checkModifiedSheet(sheet1)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//using common funtion : initializing the screen
    					resetAll(); 
    					comObjects[1].SetSelectCode("");
    					for(var i=0 ; i < sheetObjects.length ; i++){
    				        tab_retrives[i]=false;
    				    }
    				    check_retrive=false;
    					break;
                    case "btn_downexcel":
        	            if(beforetab==0){
        	            	doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
        	            }else if(beforetab==1){
        	            	doActionIBSheet(sheet2,formObject,IBDOWNEXCEL);
        	            }else if(beforetab==2){
        	            	doActionIBSheet(sheet3,formObject,IBDOWNEXCEL);
        	            }else if(beforetab==3){
        	            	doActionIBSheet(sheet4,formObject,IBDOWNEXCEL);
        	            }
                        break;
                    case "btn_print":
                        ComShowMessage("btn_print cleck");
                        break;
                    case "btn_popup_office":
    	   	        	var sales_office=formObject.sales_office.value;
    	   	        	var param='ofc_cd='+sales_office;
    					spcPopup("SalesOffice", param, 770, 470, "getSalesOffice", "1,0,1,1,1,1,1,1");
            	        break;    
    				case "btn_popup_pol_cd":
    		   	        var pol_cd=formObject.pol_cd.value;
    		   	        spcPopup("POL", "loc_cd="+pol_cd+"&loc_port_ind=Y", 900, 470, "getPOL", "1,0,1,1,1,1,1,1" );
    	   	        	break;  
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
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
        	var objs=document.all.tabLayer;
        	
            for(var i=0;i<sheetObjects.length;i++){
            	// change the name of start environment setting funtion
                ComConfigSheet (sheetObjects[i]);
                objs[i].style.display="Inline";
                initSheet(sheetObjects[i],i+1);
                objs[i].style.display="none";
                // Adding last environment setting funtion
                ComEndConfigSheet(sheetObjects[i]);
            }
           
           
            
           sheet1.RenderSheet(0);
     	   changeSheet1(sheet1, "200701|200702|200703");
           sheet1.RenderSheet(1);
           sheet2.RenderSheet(0);
           changeSheet2(sheet2, "200701|200702|200703"); 
           sheet2.RenderSheet(1);
           sheet3.RenderSheet(0);
           changeSheet3(sheet3, "200701|200702|200703");
           sheet3.RenderSheet(1);
            
//            var sheetResizeFull=true;
//    		document_onresize();
           resizeSheet();
           
            for(var k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
                tabObjects[k].SetSelectedIndex(0);
            }
        	var chkViewP=document.form.chkViewP.checked;
        	var chkViewL=document.form.chkViewL.checked;
        	if(chkViewP==true && chkViewL==false){
    			document.form.chkview.value="P";
        	}else{
        		document.form.chkview.value="O"; 
        	}
        	document.form.duration.options.value="4";
        	tab_retrives[0]=false;
    		tab_retrives[1]=false;
    		tab_retrives[2]=false;
    		changetitle();
    		changeTitle2(document.form.check_office);
    		changeTitle3(document.form.check_office2);
    		document.form.year.focus();
//    		if(isDevMode){
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
                	initSheet1(sheet1, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O");
                    break;
                case 2:     //sheet2 init
                    initSheet2(sheet2, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O");
                    break;
                case 3:     //sheet3 init
                    initSheet2(sheet3, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120", "O");
                    break;
                case 4:
                    with (sheetObj) {
                    SetFocusEditMode(default_edit_mode);
                    var HeadTitle1="RHQ|Trade|Bound|Lane|WK|VVD|BSA|QTA|LOAD(TEU)|LOAD(TEU)|LOAD(TEU)|LOAD(TEU)|LOAD(TEU)|LOAD(TEU)|RATIO|RATIO|";
                    var HeadTitle2="RHQ|Trade|Bound|Lane|WK|VVD|BSA|QTA|OCN|IPC|T/S|MTY|TTL1|TTL2|TTL1|TTL2|";
//                    SetConfig( { SearchMode:0, MergeSheet:7, DataRowMerge:0 } );
                    SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7, UseNoDataRow:1  } );
                    var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"RHQ",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Trade",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Bound",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"Lane",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"WK",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"VVD",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"BSA",    KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"QTA",    KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"OCN",    KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"IPC",    KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"T/S",    KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"MTY",    KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"TTL1",   KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"TTL2",   KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"TTL1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"TTL2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                              {Type:"Text",      Hidden:0,  Width:10,   Align:"Right",   ColMerge:0,   SaveName:"pd",   KeyField:0,   CalcLogic:"",   Format:""}];
                       for(var i=1;i<17;i++){
	                    SetCellBackColor(1,i ,"#8C8C8C");
	                    SetCellBackColor(2,i ,"#8C8C8C");
                    }
                  
                    InitColumns(cols);
                    SetEditable(0);
                    SetCellBackColor(1,i,"#8C8C8C");
                    SetCellBackColor(2,i,"#8C8C8C");
//                    SetHeaderRowHeight(20);
                    SetSheetHeight(ComGetSheetHeight(sheetObj, 19));
                    }


                    break;
            }
        }
        /**
         * Changing title after retrieving TabSheet1
         */
    	function initSheet1(sheetObj, strWeeks, strFdTds, strPortV){
    	      with(sheetObj){
    	         SetFocusEditMode(default_edit_mode);
    	         var weekArr=strWeeks.split("|");
    	         var fdtdArr=strFdTds.split("|");
    	         var columnCount=3 + (weekArr.length) *30;
    	         if(strPortV=="O"){
    	         var HeadTitle0="Area|Office|Lvl";
    	         var HeadTitle1="Area|Office|Lvl";
    	         }else{
    	         var HeadTitle0="Port|Office|Lvl";
    	         var HeadTitle1="Port|Office|Lvl";
    	         }
    	         var HeadTitle2="QTA|F'cast|-1 day F'cast|DIFF|BKG|Perf";
    	         var WeekTitle="";
    	         var FdTdTitle="";
    	         var Title3="";
    	         for(var i=0 ; i < weekArr.length ; i++){
	    	         for(var h=0 ; h < 5 ; h++){
		    	         for(var k=0 ; k < 6 ; k++){
			    	         WeekTitle=WeekTitle+ "|" + weekArr[i];
			    	         FdTdTitle=FdTdTitle+ "|" + fdtdArr[i];
		    	         }
		    	         Title3=Title3+"|"+ HeadTitle2;
	    	         }
    	         }
    	         HeadTitle0=HeadTitle0+ WeekTitle + "|";
    	         HeadTitle1=HeadTitle1+ FdTdTitle + "|";
    	         if(strPortV=="O"){
    	        	 HeadTitle2="Area|Office| "+Title3 + "|";
    	         }else{
    	        	 HeadTitle2="Port|Office| "+Title3 + "|";
    	         }
    	         var cnt=0;
//    	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
    	         SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7, UseNoDataRow:1  } );
    	         var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    	         var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
    	         InitHeaders(headers, info);
    	         var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"area",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	                      {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"level",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0}];
    	         
    	                  for(var j=1 ; j < weekArr.length+1 ; j++){
    	                	  for(var i=1 ; i <= 5 ; i++){
				    	         cols.push({Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qta"+i+j,  KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    	         cols.push({Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast"+i+j,KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    	         cols.push({Type:"Text",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"prev"+i+j, KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    	         cols.push({Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"diff"+i+j, KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    	         cols.push({Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg"+i+j,  KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    	         cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pref"+i+j, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
    	                	  }
			    	         for(var m=0 ; m <columnCount ; m ++)
			    	         {
			    	         	SetCellBackColor(1,m,"#8C8C8C");
			    	         	SetCellBackColor(2,m,"#8C8C8C");
			    	         }
				    	        
//			    	         SetCellBackColor(1,0,"#555555");
//			    	         SetCellBackColor(1,m,"#555555");
//			    	         SetCellBackColor(2,m,"#555555");
    	                  }
    	                  
		    	         cols.push({Type:"Text",      Hidden:0,  Width:20,   Align:"Right",   ColMerge:0,   SaveName:"pd", KeyField:0,   CalcLogic:"",   Format:""});

    	                  InitColumns(cols);
			    	      SetEditable(0);
//    	         sheetObj.ShowTreeLevel(2);
    	         //InitTreeInfo(2, "level", "#0000FFNAN");
//    	         SetHeaderRowHeight(20);
    	         SetSheetHeight(ComGetSheetHeight(sheetObj, 19));
    	       }
    	}
    	/**
         * Changing the title after retrieving it in TabSheet2
         */
    	function initSheet2(sheetObj, strWeeks, strFdTds, strPortV){ 
    	      with(sheetObj){
    	         SetFocusEditMode(default_edit_mode);
    	         var weekArr=strWeeks.split("|");
    	         var fdtdArr=strFdTds.split("|");
    	         var columnCount=5 + (weekArr.length) *5;
    	         var HeadTitle0="";
    	         var HeadTitle1="";
    	         if(strPortV=="O"){
	    	         HeadTitle0="Sub Trade\n/Lane|||";
	    	         HeadTitle1="Sub Trade\n/Lane||Area|Load Office";
    	         }else{
	    	         HeadTitle0="Sub Trade\n/Lane|||";
	    	         HeadTitle1="Sub Trade\n/Lane||Port|Load Office";
    	         }
    	         var HeadTitle2=HeadTitle0;
    	         var HeadTitle3=HeadTitle0;
    	         var WeekTitle="";
    	         var FdTdTitle="";
    	         var Title3="";
    	         var ItemArr=new Array("Vol/Teu.");
    	         var ValuArr=new Array("QTA", "F'cast", "Alloc", "BKG", "Perf");
    	         var ItemTitle="";
    	         for(var i=0 ; i < weekArr.length ; i++){
	    	         for(var k=0 ; k < 5 ; k++){
		    	         HeadTitle0=HeadTitle0+ "|" + weekArr[i];
		    	         HeadTitle1=HeadTitle1+ "|" + fdtdArr[i];
		    	         HeadTitle2=HeadTitle2+ "|" + ItemArr[0];
		    	         HeadTitle3=HeadTitle3+ "|" + ValuArr[k];
	    	         }
    	         }
    	         HeadTitle0 = HeadTitle0 + "|cL2|";
    	         HeadTitle1 = HeadTitle1 + "|cL2|";
    	         HeadTitle2 = HeadTitle2 + "|cL2|";
    	         HeadTitle3 = HeadTitle3 + "|cL2|";
    	         
    	         var cnt=0;

//    	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
    	         SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7, UseNoDataRow:1  } );
    	         var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    	         var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}, { Text:HeadTitle3, Align:"Center"} ];
    	         InitHeaders(headers, info);
    	         var cols = [ {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			    	          {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"level",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			    	          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"area",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
			    	          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 }];
    	         var sCol=cnt;
    	         for(var j=1 ; j < weekArr.length+1 ; j++){
    	        	 var m=1;
	    	         cols.push({Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"qta"+m+j,   KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	    	         cols.push({Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"fcast"+m+j, KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	    	         cols.push({Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"alloc"+m+j, KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	    	         cols.push({Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bkg"+m+j,   KeyField:0,   CalcLogic:"",   Format:"NullInteger",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	    	         cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pref"+m+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
    	         }
    	         var eCol=cnt;
    	         for(var n=sCol ; n < eCol ; n++){
    	        	 SetColHidden(n,1);
    	         }
    	         
    	         cols.push({Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL2",     KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:30});
    	         cols.push({Type:"Text",      Hidden:0,  Width:20,   Align:"Right",   ColMerge:0,   SaveName:"pd", KeyField:0,   CalcLogic:"",   Format:""});
    	         InitColumns(cols);
    	         SetEditable(0);
    	         sheetObj.SetRangeBackColor(1, 4, 3, columnCount-1,"#555555");
    	         //InitTreeInfo(1, "level", "#000000NAN");
//    	         SetHeaderRowHeight(20);
    	         SetRowHidden(2,1);
    	         SetSheetHeight(ComGetSheetHeight(sheetObj, 19));
    	         
    	       }
    	}
    	var allocHide=false;
    	function hideAlloc(){
    		allocHide=true;
    		check_alloc_div.style.display="none";
    		check_alloc_div2.style.display="none";
    	}
    	/*
    	 * Displaying the column in case of select item1
    	 */
    	function changeColum1(obj){
    		if(check_retrive && tab_retrives[0]){
    			var sheetObj=sheet1;
    			week=sheetObj.GetEtcData("week");
    	    	changeSheet1(sheetObj, week);
    		} 	
    	}
    	/*
    	 * Displaying the column in case of select item2
    	 */
    	function changeColum2(obj){
    		if(check_retrive && tab_retrives[1]){
    			var sheetObj=sheet2;
    	    	changeSheet2(sheetObj);
    		} 	
    	}
    	/*
    	 *Displaying the column in case of select item3
    	 */
    	function changeColum3(obj){
    		if(check_retrive && tab_retrives[2]){
    			var sheetObj=sheet3;
    	    	changeSheet3(sheetObj);
    		} 	
    	}
    	/*
    	 * Setting hidden column
    	 */
    	function changeSheet1(sheetObj, week){
    		var formObj=document.form;
    		var item1_index=formObj.item1.options.selectedIndex;
            var item1=formObj.item1.options[item1_index].value;
            var weekArr=week.split("|");
    		var row=sheetObj.RowCount()+2;
    		for(var j=1 ; j < weekArr.length+1 ; j++){
    			for(var i=1 ; i < 6 ; i++){
    				var sts=(i != item1);
            		sheetObj.SetColHidden("qta"+i+j,sts);
            		sheetObj.SetColHidden("fcast"+i+j,sts);
            		sheetObj.SetColHidden("prev"+i+j,sts);
            		sheetObj.SetColHidden("diff"+i+j,sts);
            		sheetObj.SetColHidden("bkg"+i+j,sts);
            		sheetObj.SetColHidden("pref"+i+j,sts);
    			}
    		}
           	sheetObj.SetRowHidden(row,(item1 != 1));
    	}
        /*
    	 * Checking whether office column is shown or not in case of selecting check box
    	 */
    	function showAlloc2(obj){    	
        	var sheetObj=sheet2;
    		var formObj=document.form;
    		var item2_index=formObj.item2.options.selectedIndex;
            var item2=formObj.item2.options[item2_index].value;
            var week1=sheetObj.GetEtcData("week");
            var weekArr=week1.split("|");
            var wlen=weekArr.length;
        	var type=obj.checked;
            hiddenItem2(sheetObj, item2, wlen, false, !type);
        }
        /*
    	 * Checking whether office column is shown or not in case of selecting check box
    	 */
    	function showAlloc3(obj){    	
        	var sheetObj=sheet3;
    		var formObj=document.form;
    		var item3_index=formObj.item3.options.selectedIndex;
            var item3=formObj.item3.options[item3_index].value;
            var week1=sheetObj.GetEtcData("week");
            var weekArr=week1.split("|");
            var wlen=weekArr.length;
        	var type=obj.checked;
            hiddenItem2(sheetObj, item3, wlen, false, !type);
        }
    	/*
    	 * Setting hidden column
    	 */
    	var oldItem="0";
    	function hiddenItem2(sheetObj, item, wlen, sts, aloc){
    		if(item == "0") return;
    		sheetObj.RenderSheet(0);
        	for(var j=1 ; j <= wlen ; j++){
        		sheetObj.SetColHidden("qta" + item + j,sts);
        		sheetObj.SetColHidden("fcast" + item + j,sts);
        		sheetObj.SetColHidden("alloc" + item + j,allocHide?1:(sts || aloc));
        		sheetObj.SetColHidden("bkg" + item + j,sts);
        		sheetObj.SetColHidden("pref" + item + j,sts);
        	}
        	if(!sts) sheetObj.SetColWidth("ofc_cd", 80 );
        	sheetObj.RenderSheet(1);
    	}
    	function changeSheet2(sheetObj, week1){
    		var formObj=document.form;
    		var item2_index=formObj.item2.options.selectedIndex;
            var item2=formObj.item2.options[item2_index].value;
            if(week1 == undefined){
    	        week1=sheetObj.GetEtcData("week");
    	    }
            var weekArr=week1.split("|");
            var wlen=weekArr.length;
            hiddenItem2(sheetObj, oldItem, wlen, true, true);
            hiddenItem2(sheetObj, item2, wlen, false, !formObj.check_alloc.checked);
    		oldItem=item2;
    	}
    	function changeSheet3(sheetObj, week1){
    		var formObj=document.form;
    		var item3_index=formObj.item3.options.selectedIndex;
            var item3=formObj.item3.options[item3_index].value;
            if(week1 == undefined){
    	        week1=sheetObj.GetEtcData("week");
    	    }
            var weekArr=week1.split("|");
            var wlen=weekArr.length;
            hiddenItem2(sheetObj, oldItem, wlen, true, true);
            hiddenItem2(sheetObj, item3, wlen, false, !formObj.check_alloc2.checked);
    		oldItem=item3;
    	}
    	function subtrade1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    		var formObj=document.form;
    		var item1_index=formObj.item1.options.selectedIndex;
        	formObj.item1.value=formObj.item1.options[item1_index].value;
        	if(!formObj.chkViewL.checked){
        		formObj.f_cmd.value=SEARCHLIST01;	
        	}else{
        		formObj.f_cmd.value=SEARCHLIST02;	
        	}
        	sheet1.RemoveAll();
        	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
     		rtn=sheet1.GetSearchData("ESM_SPC_0021GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
			if(ComGetTotalRows(rtn)>0) {
	    		week=getEtcDataFromXml(rtn, "week");
	        	fdtd=getEtcDataFromXml(rtn, "fdtd");
	        	portv=getEtcDataFromXml(rtn, "portv");
	        	sheetObjects[0] = sheet1.Reset();
	        	initSheet1(sheet1, week, fdtd, portv);
	        	sheet1.RenderSheet(0);
	        	sheet1.LoadSearchData(rtn,{Sync:1} );
	        	sheet1.RenderSheet(1);
			} else {
				sheet1.LoadSearchData(rtn,{Sync:1} );
			}

    	}
    	function subtrade2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){

    		var formObj=document.form;
    		var item2_index=formObj.item2.options.selectedIndex;
        	formObj.item2.value=formObj.item2.options[item2_index].value;
        	if(!formObj.chkViewL.checked){
    			formObj.f_cmd.value=SEARCHLIST03;	
        	}else{
        		formObj.f_cmd.value=SEARCHLIST04;	
        	}
        	sheet2.RemoveAll();
        	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
    		rtn1=sheet2.GetSearchData("ESM_SPC_0021GS2.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    		if(ComGetTotalRows(rtn1)>0) {
	        	week1=getEtcDataFromXml(rtn1, "week");
	        	fdtd1=getEtcDataFromXml(rtn1, "fdtd");
	        	portv1=getEtcDataFromXml(rtn1, "portv");
	        	sheetObjects[1] = sheet2.Reset();
	        	initSheet2(sheet2, week1, fdtd1, portv1);
	        	sheet2.RenderSheet(0);
	        	sheet2.LoadSearchData(rtn1,{Sync:1} );
	        	sheet2.RenderSheet(1);
    		} else {
    			sheet2.LoadSearchData(rtn1,{Sync:1} );
			}
    	}
    	function subtrade3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    		var formObj=document.form;
    		var item3_index=formObj.item3.options.selectedIndex;
        	formObj.item3.value=formObj.item3.options[item3_index].value;

        	if(!formObj.chkViewL.checked){
    			formObj.f_cmd.value=SEARCHLIST05;	
        	}else{
        		formObj.f_cmd.value=SEARCHLIST06;	
        	}
        	sheet3.RemoveAll();
        	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
    		rtn1=sheet3.GetSearchData("ESM_SPC_0021GS3.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    		if(ComGetTotalRows(rtn1)>0) {
	        	week1=getEtcDataFromXml(rtn1, "week");
	        	fdtd1=getEtcDataFromXml(rtn1, "fdtd");
	        	portv1=getEtcDataFromXml(rtn1, "portv");
	        	sheetObjects[2] = sheet3.Reset();
	        	initSheet2(sheet3, week1, fdtd1, portv1);
	        	sheet3.RenderSheet(0);
	        	sheet3.LoadSearchData(rtn1,{Sync:1} );
	        	sheet3.RenderSheet(1);
    		}  else {
    			sheet3.LoadSearchData(rtn1,{Sync:1} );
			}
    	}
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
            var formObj=document.form;
    		var item1_index=formObj.item1.options.selectedIndex;
            var item1=formObj.item1.options[item1_index].value;
    		week=getEtcDataFromXml(rtn, "week");
    	    fdtd=getEtcDataFromXml(rtn, "fdtd");
    	    var weekArr=week.split("|");
    	    sheet1.RenderSheet(0);
    		for(var j=1 ; j < weekArr.length+1 ; j++){
    			for(var i=1 ; i < 6 ; i++){
    				var sts=(i != item1);
            		sheetObj.SetColHidden("qta"+i+j,sts);
            		sheetObj.SetColHidden("fcast"+i+j,sts);
            		sheetObj.SetColHidden("prev"+i+j,sts);
            		sheetObj.SetColHidden("diff"+i+j,sts);
            		sheetObj.SetColHidden("bkg"+i+j,sts);
            		sheetObj.SetColHidden("pref"+i+j,sts);
    			}
    		}
    	    sheet1.RenderSheet(1);
    	}
    	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
            var formObj=document.form;
    		changeTitle2(formObj.check_office);
    		sheet1.RenderSheet(0);
    		changeSheet2(sheetObj);
    		sheet1.RenderSheet(1);
    	}
    	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
            var formObj=document.form;
    		changeTitle3(formObj.check_office2);
    		sheet1.RenderSheet(0);
    		changeSheet3(sheetObj);
    		sheet1.RenderSheet(1);
    	}
      // Handling the process related with sheet1
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
                case IBSEARCH:      //Retrieve
                	
                    if(validateForm(sheetObj,formObj,sAction)){
    					if(formObj.chkViewP.checked){
    						
    						formObj.chkview.value="P"; 
    					}else{
    						formObj.chkview.value="O"; 
    					}
    					
                        if(beforetab==0){	               
                        	
    						var item1_index=formObj.item1.options.selectedIndex;
                        	formObj.item1.value=formObj.item1.options[item1_index].value;
                        	if(!formObj.chkViewL.checked){
    							formObj.f_cmd.value=SEARCHLIST01;	
                        	}else{
                        		formObj.f_cmd.value=SEARCHLIST02;	
                        	}
                        	sheet1.RemoveAll();
    	                	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
     	                	rtn=sheet1.GetSearchData("ESM_SPC_0021GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);     	                	
							if(ComGetTotalRows(rtn)>0) {
	    						week=getEtcDataFromXml(rtn, "week");
	    	                	fdtd=getEtcDataFromXml(rtn, "fdtd");
	    	                	portv=getEtcDataFromXml(rtn, "portv");
	    	                	sheetObjects[0] = sheet1.Reset();
	    	                	initSheet1(sheet1, week, fdtd, portv);
	    	                	sheet1.RenderSheet(0);
	    	                	sheet1.LoadSearchData(rtn,{Sync:1} );
	    	                	sheet1.RenderSheet(1);
							} else {
								sheet1.LoadSearchData(rtn,{Sync:1} );
							}

    	                	
    	                }else if(beforetab==1){
    	                	
    	                	var item2_index=formObj.item2.options.selectedIndex;
                        	formObj.item2.value=formObj.item2.options[item2_index].value;
    	                	if(!formObj.chkViewL.checked){
    	                		
    							formObj.f_cmd.value=SEARCHLIST03;	
                        	}else{
                        		
                        		formObj.f_cmd.value=SEARCHLIST04;	
                        	}
    	                	
    	                	sheet2.RemoveAll();
                            var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
     	                	rtn1=sheet2.GetSearchData("ESM_SPC_0021GS2.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
     	                	if(ComGetTotalRows(rtn1)>0) {
	    	                	week1=getEtcDataFromXml(rtn1, "week");
	    	                	fdtd1=getEtcDataFromXml(rtn1, "fdtd");
	    	                	portv1=getEtcDataFromXml(rtn1, "portv");
	    	                	sheetObjects[1] = sheet2.Reset();
	    	                	initSheet2(sheet2, week1, fdtd1, portv1);
	    	                	sheet2.RenderSheet(0);
	    	                	sheet2.LoadSearchData(rtn1,{Sync:1} );
	    	                	sheet2.RenderSheet(1);
     	                	} else {
     	                		sheet2.LoadSearchData(rtn1,{Sync:1} );
							}
    	                	
    	                }else if(beforetab==2){
    	                	
    	                	var item3_index=formObj.item3.options.selectedIndex;
                        	formObj.item3.value=formObj.item3.options[item3_index].value;
    	                	if(!formObj.chkViewL.checked){   	                		
    							formObj.f_cmd.value=SEARCHLIST05;
                        	}else{
                        		
                        		formObj.f_cmd.value=SEARCHLIST06;
                        	}
    	                	
    	                	sheet3.RemoveAll();
    	                	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
      	                	rtn1=sheet3.GetSearchData("ESM_SPC_0021GS3.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
      	                	if(ComGetTotalRows(rtn1)>0) {
	    	                	week1=getEtcDataFromXml(rtn1, "week");
	    	                	fdtd1=getEtcDataFromXml(rtn1, "fdtd");
	    	                	portv1=getEtcDataFromXml(rtn1, "portv");
	    	                	sheetObjects[2] = sheet3.Reset();
	    	                	initSheet2(sheet3, week1, fdtd1, portv1);
	    	                	sheet3.RenderSheet(0);
	    	                	sheet3.LoadSearchData(rtn1,{Sync:1} );
	    	                	sheet3.RenderSheet(1);
      	                	} else {
     	                		sheet2.LoadSearchData(rtn1,{Sync:1} );
							}
    	                }else{   	                	
    	                	formObj.f_cmd.value=SEARCHLIST07;	
    	                	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
    	                	sheet4.DoSearch4Post("ESM_SPC_0021GS3.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    	                }
                        
                    }
                    break;
                case IBDOWNEXCEL:        //Excel download
                	if(sheetObj.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                		 sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
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
    		tab_retrives[tabCnt++]=false;
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
                        InsertItem( "F'cast Comparison" , "");
                        InsertItem( "Allocation Status" , "");
                        InsertItem( "Adjusted allocation status" , "");
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
            var formObj=document.form;
            var objs=document.all.item("tabLayer");
            var chkview;
            var chkViewP=document.form.chkViewP.checked;
        	var chkViewL=document.form.chkViewL.checked;
        	if(formObj.chkViewP.checked){
    			formObj.chkview.value="P";
    			chkview="P";
    		}else{
    			formObj.chkview.value="O";
    			chkview="O";
    		}
        	objs[nItem].style.display="Inline";
        	for(var i = 0; i<objs.length; i++){
 		       if(i != nItem){
 		        objs[i].style.display="none";
 		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
 		       }
 		      }
        	beforetab=nItem;
    		//Changing the title
    		changetitle();
        	if(check_retrive && !tab_retrives[beforetab]){  
        		var queryString="";
                if(beforetab==0){	
    				tab_retrives[0]=true;
    				var item1_index=formObj.item1.options.selectedIndex;
                	formObj.item1.value=formObj.item1.options[item1_index].value;
                	if(!formObj.chkViewL.checked){
    					formObj.f_cmd.value=SEARCHLIST01;	
                	}else{
                		formObj.f_cmd.value=SEARCHLIST02;	
                	}
                	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
                 	rtn=sheet1.GetSearchData("ESM_SPC_0021GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
                 	if(ComGetTotalRows(rtn)>0) {
	    				week=getEtcDataFromXml(rtn, "week");
	                	fdtd=getEtcDataFromXml(rtn, "fdtd");
	                	portv=getEtcDataFromXml(rtn, "portv");
	                	sheet1.RemoveAll(); 
	                	sheetObjects[0] = sheet1.Reset();
	                	initSheet1(sheet1, week, fdtd, portv);
	                	sheet1.RenderSheet(0);
	                	sheet1.LoadSearchData(rtn,{Sync:1} );
	                	sheet1.RenderSheet(1);
                 	} else {
                 		sheet1.LoadSearchData(rtn,{Sync:1} );
					}
                }else if(beforetab==1){
    				tab_retrives[1]=true;
    				var item2_index=formObj.item2.options.selectedIndex;
                	formObj.item2.value=formObj.item2.options[item2_index].value;
                	if(!formObj.chkViewL.checked){
    					formObj.f_cmd.value=SEARCHLIST03;	
                	}else{
                		formObj.f_cmd.value=SEARCHLIST04;	
                	}
                	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
                 	rtn1=sheet2.GetSearchData("ESM_SPC_0021GS2.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
                 	if(ComGetTotalRows(rtn1)>0) {
	                	week1=getEtcDataFromXml(rtn1, "week");
	                	fdtd1=getEtcDataFromXml(rtn1, "fdtd");
	                	portv1=getEtcDataFromXml(rtn1, "portv");
	                	sheetObjects[1] = sheet2.Reset();
	                	initSheet2(sheet2, week1, fdtd1, portv1);
	                	sheet2.RenderSheet(0);
	                	sheet2.LoadSearchData(rtn1,{Sync:1} );
	                	sheet2.RenderSheet(1);
                 	} else {
                 		sheet2.LoadSearchData(rtn1,{Sync:1} );
					}
                }else if(beforetab==2){
    				tab_retrives[2]=true;
    				var item3_index=formObj.item3.options.selectedIndex;
                	formObj.item3.value=formObj.item3.options[item3_index].value;
                	if(!formObj.chkViewL.checked){
    					formObj.f_cmd.value=SEARCHLIST05;	
                	}else{
                		formObj.f_cmd.value=SEARCHLIST06;	
                	}
                	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
 	                rtn1=sheet3.GetSearchData("ESM_SPC_0021GS3.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
 	                if(ComGetTotalRows(rtn1)>0) {
	                	week1=getEtcDataFromXml(rtn1, "week");
	                	fdtd1=getEtcDataFromXml(rtn1, "fdtd");
	                	portv1=getEtcDataFromXml(rtn1, "portv");
	                	sheetObjects[2] = sheet3.Reset();
	                	initSheet2(sheet3, week1, fdtd1, portv1);
	                	sheet3.RenderSheet(0);
	                	sheet3.LoadSearchData(rtn1,{Sync:1} );
	                	sheet3.RenderSheet(1);
 	                } else {
 	                	sheet3.LoadSearchData(rtn1,{Sync:1} );
					}	                
 	                
                }else{
                	formObj.f_cmd.value=SEARCHLIST07;	
                	var param=SpcFormString(formObj,'chkview,year,week1,duration,trade,bound,rhq,area,sales_office,pol_cd,item1,subtrade1,item2,subtrade2,check_office,check_alloc,item3,subtrade3,check_office2,check_alloc2,subtrade4');
                 	sheet3.DoSearch("ESM_SPC_0021GS3.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param );
                }	
        	}
        	
        	resizeSheet();
        }
        /*
         *in case of selecting tree structure 
         */
        function sheet1_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "area":
        	case "ofc_cd":
        		var total_row=sheetObj.FindText("ofc_cd", "TOTAL");
        		if(sheetObj.GetCellValue(row, col) == "+"){
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,0);
    					if(sheetObj.ColSaveName(col) == "area" && sheetObj.GetCellValue(startRow, "ofc_cd") == '+'){
    						startRow = sheetObj.GetMergedEndCell(startRow,"area").split(",")[0] ;	
    					}
    				}
//        			sheetObj.SetRowExpanded(row,1);
       				sheetObj.SetCellValue(row, col,"-",0);
        		}else if(sheetObj.GetCellValue(row, col) == "-"){
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,1);
    				}
//        			sheetObj.SetRowExpanded(row,0);
       				sheetObj.SetCellValue(row, col,"+",0);
        		}
    			sheetObj.SetDataMerge();
        		break;
        	}
        } 
        /*
         *in case of selecting tree structure 
         */
        function sheet2_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "rlane_cd":
        	case "area":
        		if(sheetObj.GetCellValue(row, col) == "+"){
//        			sheetObj.SetRowExpanded(row,1);
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,0);
    					if(sheetObj.ColSaveName(col) == "rlane_cd" && sheetObj.GetCellValue(startRow, "area") == '+'){
    						startRow = sheetObj.GetMergedEndCell(startRow,"rlane_cd").split(",")[0] ;	
    					}
    				}
       				sheetObj.SetCellValue(row, col,"-",0);
        		}else if(sheetObj.GetCellValue(row, col) == "-"){
//        			sheetObj.SetRowExpanded(row,0);
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,1);
    				}
       				sheetObj.SetCellValue(row, col,"+",0);
        		}
        		sheetObj.SetDataMerge();
        		break;
        	case "ofc_cd":
        		if(sheetObj.GetCellValue(row, col) == "+"){
//        			sheetObj.SetRowExpanded(row,1);
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,0);
    					if(sheetObj.ColSaveName(col) == "area" && sheetObj.GetCellValue(startRow, "ofc_cd") == '+'){
    						startRow = sheetObj.GetMergedEndCell(startRow,"area").split(",")[0] ;	
    					}
    				}
       				sheetObj.SetCellValue(row, col,"-",0);
        		}else if(sheetObj.GetCellValue(row, col) == "-"){
//        			sheetObj.SetRowExpanded(row,0);
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,1);
    				}
       				sheetObj.SetCellValue(row, col,"+",0);
        		}
        		sheetObj.SetDataMerge();
        		break;
        	}
        }
        /*
         *in case of selecting tree structure 
         */
        function sheet3_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "rlane_cd":
        	case "area":
        		if(sheetObj.GetCellValue(row, col) == "+"){
//        			sheetObj.SetRowExpanded(row,1);
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,0);
    					if(sheetObj.ColSaveName(col) == "rlane_cd" && sheetObj.GetCellValue(startRow, "area") == '+'){
    						startRow = sheetObj.GetMergedEndCell(startRow,"rlane_cd").split(",")[0] ;	
    					}
    				}
       				sheetObj.SetCellValue(row, col,"-",0);
        		}else if(sheetObj.GetCellValue(row, col) == "-"){
//        			sheetObj.SetRowExpanded(row,0);
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,1);
    				}
       				sheetObj.SetCellValue(row, col,"+",0);
        		}
        		sheetObj.SetDataMerge();
        		break;
        	case "ofc_cd":
        		if(sheetObj.GetCellValue(row, col) == "+"){
//        			sheetObj.SetRowExpanded(row,1);
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,0);
    					if(sheetObj.ColSaveName(col) == "area" && sheetObj.GetCellValue(startRow, "ofc_cd") == '+'){
    						startRow = sheetObj.GetMergedEndCell(startRow,"area").split(",")[0] ;	
    					}
    				}
       				sheetObj.SetCellValue(row, col,"-",0);
        		}else if(sheetObj.GetCellValue(row, col) == "-"){
//        			sheetObj.SetRowExpanded(row,0);
    				var startRow = row + 1;
    				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
    				for(;startRow <= endRow;startRow++){
    					sheetObj.SetRowHidden(startRow,1);
    				}
       				sheetObj.SetCellValue(row, col,"+",0);
        		}
        		sheetObj.SetDataMerge();
        		break;
        	}
        }
        /*
         * Changing the title in case of checking port view
         */
        function changetitle(){
        	var formObj=document.form;
        	var chkViewP=formObj.chkViewP.checked;
        	if(beforetab==0){
    	    	if(chkViewP){
    	    		sheet1.SetCellText(0,0 ,"Port");
    	    		sheet1.SetCellText(1,0 ,"Port");
    	    		sheet1.SetCellText(2,0 ,"Port");
    	    	}else{
    	    		sheet1.SetCellText(0,0 ,"Area");
    	    		sheet1.SetCellText(1,0 ,"Area");
    	    		sheet1.SetCellText(2,0 ,"Area");
    	    	}
        	}else{
        		if(chkViewP){  		
        			sheet2.SetCellText(0,2 ,"Port");
        			sheet2.SetCellText(1,2 ,"Port");
        			sheet2.SetCellText(2,2 ,"Port");
        			sheet2.SetCellText(3,2 ,"Port");
        			sheet3.SetCellText(0,2 ,"Port");
        			sheet3.SetCellText(1,2 ,"Port");
        			sheet3.SetCellText(2,2 ,"Port");
        			sheet3.SetCellText(3,2 ,"Port");
    	    	}else{
    	    		sheet2.SetCellText(0,2 ,"Area");
    	    		sheet2.SetCellText(1,2 ,"Area");
    	    		sheet2.SetCellText(2,2 ,"Area");
    	    		sheet2.SetCellText(3,2 ,"Area");
    	    		sheet3.SetCellText(0,2 ,"Area");
    	    		sheet3.SetCellText(1,2 ,"Area");
    	    		sheet3.SetCellText(2,2 ,"Area");
    	    		sheet3.SetCellText(3,2 ,"Area");
    	    	}
        	}
        }
        /*
    	 * Checking whether office column is shown or not in case of selecting check box
    	 */
    	function changeTitle2(obj){    	
        	var sheetObj;
        	var type;     	
        	sheetObj=sheet2;
        	type=obj.checked;
    		sheetObj.RenderSheet(0);
    		if(type){
//    			sheetObj.ShowTreeLevel(2, 2);
    			var iCheckRow = sheetObj.FindCheckedRow("cL2");
    			var arrRow=iCheckRow.split("|");//2레벨				
    			for (var idx=0; idx<arrRow.length; idx++){
    				  sheetObj.SetRowHidden(arrRow[idx], 0);
    			}
    		}
    		else{
//    			sheetObj.ShowTreeLevel(1, 1);
    			var iCheckRow = sheetObj.FindCheckedRow("cL2");
    			var arrRow=iCheckRow.split("|");//2레벨			
    			for (var idx=0; idx<arrRow.length; idx++){
    				  sheetObj.SetRowHidden(arrRow[idx], 1);
    			}
    		}
    		var row=0;
    		var findTxt="+";
    		var replTxt="-";

    		while((row=sheetObj.FindText("area", findTxt, row)) > 0){
    			sheetObj.SetCellValue(row, "area",replTxt,0);
    		}
    		row=0;
    		while((row=sheetObj.FindText("ofc_cd", findTxt, row)) > 0){
    			sheetObj.SetCellValue(row, "ofc_cd",replTxt,0);
    		}
			sheetObj.SetDataMerge();
    		sheetObj.RenderSheet(1);
        }
        /*
    	 * Checking whether office column is shown or not in case of selecting check box
    	 */
    	function changeTitle3(obj){    	
        	var sheetObj;
        	var type;     	
        	sheetObj=sheet3;
        	type=obj.checked;
    		sheetObj.RenderSheet(0);
    		if(type){
//    			sheetObj.ShowTreeLevel(2, 2);
    			var iCheckRow = sheetObj.FindCheckedRow("cL2");
    			var arrRow=iCheckRow.split("|");//2레벨				
    			for (var idx=0; idx<arrRow.length; idx++){
    				  sheetObj.SetRowHidden(arrRow[idx], 0);
    			}
    		}
    		else{
//    			sheetObj.ShowTreeLevel(1, 1);
    			var iCheckRow = sheetObj.FindCheckedRow("cL2");
    			var arrRow=iCheckRow.split("|");//2레벨				
    			for (var idx=0; idx<arrRow.length; idx++){
    				  sheetObj.SetRowHidden(arrRow[idx], 1);
    			}
    		}
    		var row=0;
    		var findTxt="+";
    		var replTxt="-";

    		while((row=sheetObj.FindText("area", findTxt, row)) > 0){
    			sheetObj.SetCellValue(row, "area",replTxt,0);
    		}
    		row=0;
    		while((row=sheetObj.FindText("ofc_cd", findTxt, row)) > 0){
    			sheetObj.SetCellValue(row, "ofc_cd",replTxt,0);
    		}
    		sheetObj.SetDataMerge();
    		sheetObj.RenderSheet(1);
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){	
            var sheetObj=sheetObjects[beforetab];
    		var queryString=FormQueryString(formObj);
    		var area=formObj.area.value;
            var sales_office=formObj.sales_office.value;
    		var trade=comObjects[0].GetSelectCode();
    		var bound=formObj.bound.value;
    		var rhq=comObjects[1].GetSelectCode();
    		if(trade==""){
    			ComShowMessage(getMsg("SPC90114", "Trade"));
    			//formObj.trade.focus();
    			comObjects[0].Focus();
    			return false; 
    		}
    		if(beforetab==2){
    			if(rhq==""){
    				ComShowMessage(getMsg("SPC90114", "RHQ"));
    				comObjects[1].Focus();
    				return false; 
    			}
    		}else{
    			if(rhq=="" && area=="" && sales_office==""){
    				ComShowMessage(getMsg("SPC90121", "RHQ", "Area","Office"));
    				comObjects[1].Focus();
    				return false; 
    			}
    		}
            return true;
        }
        /*
    	 * Changing Sales Offeice
    	 */
    	function getSalesOffice(rowArray){
            var colArray=rowArray[0];	    	
        	document.all.sales_office.value=colArray[3];        
        }
        /*pol setting
    	* 
    	*/		
    	function getPOL(rowArray){
        	var colArray=rowArray[0];	    	
        	document.all.pol_cd.value=colArray[3];        
        }
        function getEtcDataFromXml(xml, str){
        	var pos=xml.indexOf("ETC KEY=\""+str+"\"");
        	if(pos < 0) return "";
    		pos=xml.indexOf(">", pos + 1);
    		if(pos < 0) return "";
    		var epos=xml.indexOf("</ETC>", pos + 1);
    		var rtn="";
    		if(epos < 0){
    			rtn=xml.substring(pos + 1);
    		}
    		else{
    			rtn=xml.substring(pos + 1, epos);
    		}
    		return rtn;
    	}
    	/*
    	 * Checking inputed the value of office and port
    	 */
    	 function checkValue(obj) {
        	var formObj=document.form;
        	var value;
        	var rtn;
        	if(obj=="office"){
        		value=formObj.sales_office.value;
        		value=ComTrim(value);
    	    	if(value.length>0){
    				if(value.length<5){
    					ComShowMessage(getMsg("SPC90116", "Office"));
    					formObj.sales_office.focus();
    					return;
    				}else{
    					rtn=getCodeList("Office", "ofc_cd="+value);
    			    	if(rtn[0] == ""){    		
    			    		ComShowMessage(getMsg("SPC90106", value));
    			    		formObj.sales_office.focus();
    			    		return;
    			    	}	
    				}
    	    	}
        	}else if(obj="pol"){
        		value=formObj.pol_cd.value;
        		value=ComTrim(value);
    	    	if(value.length>0){
    		    	if(value.length<5){
    		    		ComShowMessage(getMsg("SPC90116", "Port"));
    					formObj.pol_cd.focus();
    					return;
    				}else{
    			    	rtn=getCodeList("Port", "port_cd="+value);
    			    	if(rtn[0] == ""){    		
    			    		ComShowMessage(getMsg("SPC90108", value));
    			    		formObj.pol_cd.focus();
    			    		return;
    			    	}	
    				}
    	    	}
        	}
        }
    	 function initDataValue_trade(){
         	var sheetObj=document.getElementById("trade");
         	with(sheetObj){
         		Index2=0;
         	}
         }
    	 function initDataValue_rhq(){
          	var sheetObj=document.getElementById("rhq");
          	with(sheetObj){
          		Index2=0;
          	}
          }
         function initDataValue_subtrade1(){
         	var sheetObj=document.getElementById("subtrade1");
         	with(sheetObj){
         		Index2=0;
         	}
         }
         function initDataValue_subtrade2(){
          	var sheetObj=document.getElementById("subtrade2");
          	with(sheetObj){
          		Index2=0;
          	}
         }
         function initDataValue_subtrade3(){
          	var sheetObj=document.getElementById("subtrade3");
          	with(sheetObj){
          		Index2=0;
          	}
         }
    	 function optionSetting() {
         	SpcSearchOptionYear("year");
         	SpcSearchOptionWeek("week1");
         	SpcSearchOptionDuration("duration", 5, 4);
         	SpcSearchOptionTrade("trade");
         	SpcSearchOptionBound("bound");

        	if(document.form.ofc_cd.value=='SINHO'){
        		SpcSearchOptionRhq("rhq");
        	}else{
        		SpcSearchOptionRhq("rhq","","","",true);
        	}
         	
         	SpcSearchOptionSubTrade("subtrade1");
         	SpcSearchOptionSubTrade("subtrade2");
         	SpcSearchOptionSubTrade("subtrade3");
         }
    	 
    		function resizeSheet(){
    	        for(var i=0;i<sheetObjects.length;i++){
    	            ComResizeSheet(sheetObjects[i]);
    	        }    		
    		}
