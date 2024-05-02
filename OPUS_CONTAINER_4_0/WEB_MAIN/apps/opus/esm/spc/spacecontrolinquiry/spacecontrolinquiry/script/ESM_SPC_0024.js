/*========================================================= 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0024.js
*@FileTitle  : No-Show Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
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
    var beforetab=1;
    //type check
    var type_check;
    //retrive check
    var check_retrive=false;
    var tab_retrives=null;
    var searchParams="";
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* the title name of TabSheet2 Month*/
    var monthTitles=new Array("Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "July.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec.");
    /* Event handler processing by button name */
        function processButtonClick(){
             /***** setting additional sheet value in case of more 2 sheet per tab *****/
             var sheetObject=sheetObjects[0];
             var sheetObject1=sheetObjects[1];
             var sheetObject2=sheetObjects[2];
             /*******************************************************/
             var formObject=document.form;
        	//try {
        		var srcName=ComGetEvent("name");
        		 if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
            	    case "btn_retrieve":
//           			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
//           				sheetObjects[0].RemoveAll();
//           				sheetObjects[1].RemoveAll();
//           				sheetObjects[2].RemoveAll();
           				
        	            for(var i=0 ; i < tab_retrives.length ; i++){
    				        tab_retrives[i]=false;
    				    }
       	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
        	            break;
    				case "btn_new":
    					if(checkModifiedSheet(sheetObject)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//using common funtion : initializing the screen
    					formObject.reset();
    					t1sheet1.RemoveAll();
    					t1sheet2.RemoveAll();
    					t1sheet3.RemoveAll();
    					t1sheet4.RemoveAll();
    					t1sheet5.RemoveAll();
    					for(var i=0 ; i < tab_retrives.length ; i++){
    				        tab_retrives[i]=false;
    				    }
    				    check_retrive=false;
    					break;
            	    case "btn_downexcel":
            	    	if(sheetObjects[beforetab].RowCount() < 1){//no data
            	    		ComShowCodeMessage("COM132501");
            	    	}else{
            	    		doActionIBSheet(sheetObjects[beforetab],formObject,IBDOWNEXCEL);
            	    	}
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
         * registering IBTab Object as list
         * adding process for list in case of needing batch processing with other items
         * defining list on the top of source
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++]=tab_obj;
        }
        /**
         * tab1_OnChange 
         * 
         */
        function tab1_OnChange(tabObj , nItem)
        {
    	    var formObj=document.form;
            var objs=document.all.item("tabLayer");
        	objs[nItem].style.display="Inline";
        	objs[beforetab].style.display="none";
        	for(var i = 0; i<objs.length; i++){
 		       if(i != nItem){
 		        objs[i].style.display="none";
 		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
 		       }
 		      }
        	beforetab=nItem;
        	resizeSheet();
        	
    		if(!check_retrive) return;
    		
            if(beforetab==0){
            	searchSummary(sheetObjects[beforetab], formObj, (SEARCHLIST01));
            }else if(beforetab==1){
            	searchByTrade(sheetObjects[beforetab], formObj, (SEARCHLIST02));
            }else if(beforetab==2){
            	searchByOffice(sheetObjects[beforetab], formObj, (SEARCHLIST03));
            }else if(beforetab==3){
            	searchByLane(sheetObjects[beforetab], formObj, (SEARCHLIST04));
            }else if(beforetab==4){
            	searchBySubOffice(sheetObjects[beforetab], formObj, (SEARCHLIST05));
            }       
            
            
        }
    	/*
    	 * Checking inputed offce value
    	 */
    	 function checkValue() {
        	var formObj=document.form;
        	var value=formObj.sales_office.value;
        	value=ComTrim(value);
        	if(value.length>0){
    			if(value.length<5){
    				ComShowMessage(getMsg("SPC90116", "Office"));
    				//formObj.sales_office.focus();
    				return;
    			}else{
    				var rtn=getCodeList("Office", "ofc_cd="+value);
    		    	if(rtn[0] == ""){    		
    		    		ComShowMessage(getMsg("SPC90106", value));
    		    		//formObj.sales_office.focus();
    		    		return;
    		    	}	
    			}
        	}
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen
         */
        function loadPage() {
        	optionSetting();
            tab_retrives=new Array(sheetObjects.length);
            var objs=document.all.tabLayer;
            
            for(var i=0;i<sheetObjects.length;i++){
            	// change the name of start environment setting funtion
                ComConfigSheet(sheetObjects[i]);
                objs[i].style.display="Inline";
                initSheet(sheetObjects[i],i+1);
                // Adding last environment setting funtion
                objs[i].style.display="none";
                ComEndConfigSheet(sheetObjects[i]);
            }
//            var sheetResizeFull=true;
//    		document_onresize();
            resizeSheet();
            
    		for(var k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
                tabObjects[k].SetSelectedIndex(0);
            }
            var formObject=document.form;
        	formObject.year.focus();
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
						InsertItem( "Summary" , "");
						InsertItem( "By Trade" , "");
						InsertItem( "By Office/Lane" , "");
						InsertItem( "By Lane/Office" , "");
						InsertItem( "By SUB-Office" , "");
                    }
                 break;
             }
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
    				initSheet1(sheetObj, "AES|TAS|TPS|TTL");
                    break;
                case 2:      //sheet1 init
    				initSheet2(sheetObj, "JAN|FEB|MAR|Total");
                    break;
                case 3:      //sheet1 init
    				initSheet3(sheetObj);
                    break;
                case 4:      //sheet1 init
    				initSheet4(sheetObj);
                    break;
                case 5:      //sheet1 init
    				initSheet5(sheetObj);
                    break;
            }
        }
        /**
         * Changing title after retrieving TabSheet1
         */
    	function initSheet1(sheetObj, strTrades){
    	       with (sheetObj) {
    	    	    	   var trades=strTrades.split("|");
    	    	    	   var columnCount=4 + (trades.length) * 3;
    	    	    	   (columnCount, 2 , 0, true);
    	    	    	   var txtHead1="F'Cast|Diff/Shortfall|Ratio";
    	    	    	   var HeadTitle1="Trade|Trade";
    	    	    	   var HeadTitle2="Area|Office";
    	    	    	   for(var i=0 ; i < trades.length ; i++){
    	    	    		   HeadTitle1=HeadTitle1 + "|" + trades[i] + "|" + trades[i] + "|" + trades[i];
    	    	    		   HeadTitle2=HeadTitle2 + "|" + txtHead1;
    	    	    	   }
    	    	    	   var cnt=0;
//    	    	    	   SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
    	    	    	   SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7  } );
    	    	    	   var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    	    	    	   var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
    	    	    	   InitHeaders(headers, info);
    	    	    	   var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	    	    	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    	    	    	   for(var j=0 ; j < trades.length ; j++){
    	    	    		   	cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"Fcast",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    	    	    		   	cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"NoSho",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    	    	    		   	cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"Ratio",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
    	    	    	   }
    	    	    	   cols.push({Type:"Text",      Hidden:1, Width:1,    Align:"Left",    ColMerge:0,   SaveName:"lvl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    	    	    	   cols.push({Type:"Text",      Hidden:0,  Width:1,    Align:"Center",  ColMerge:0,   SaveName:"",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
    	    	    	   for(var k=0 ; k <columnCount ; k ++)
    	    	    	   {
    	    	    		   SetCellBackColor(1,k,GetCellBackColor(1,0));
    	    	    	   }    	    	    	 
    	    	    	   InitColumns(cols);
    	    	    	   SetEditable(0);
    	    	    	   if(!check_retrive){
        	    	    	   SetSheetHeight(ComGetSheetHeight(sheetObj,16) );
    	    	    	   }
    	    	    	  // SetCellBackColor(1,0,"#DEFBF8");
    	    	    	   SetCellBackColor(1,k,GetCellBackColor(1,0));
    	    	    	   //InitTreeInfo(columnCount - 2, "sLevel", "#0000FFNAN");
    	       }
    	}
	/**
	 * Changing the title after retrieving it in TabSheet2
	 */
	function initSheet2(sheetObj, strTrades) {
		with(sheetObj) {
			var trades = strTrades.split("|");
			var columnCount = 5 + (trades.length) * 3;
			var txtHead1 = "F'Cast|Diff/Shortfall|Ratio";
			var HeadTitle1 = "Trade|Month|Month";
			var HeadTitle2 = "Trade|RHQ/Area|Office";

			for (var i=0; i<trades.length; i++) {
				HeadTitle1 = HeadTitle1 + "|" + trades[i] + "|" + trades[i] + "|" + trades[i];
				HeadTitle2 = HeadTitle2 + "|" + txtHead1;
			}
//			SetConfig({"SearchMode":2, "MergeSheet":5, "Page":20, "DataRowMerge":0});
//			var info = {"Sort":0, "ColMove":1, "HeaderCheck":1, "ColResize":1};
    	   SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7  } );
    	   var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    	   
			var headers = [{Text:HeadTitle1, Align:"Center"}, {Text:HeadTitle2, Align:"Center"}];
			InitHeaders(headers, info);

			var cols = [
				{Type:"Text",	Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:"",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0},
				{Type:"Text",	Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:"",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0},
				{Type:"Text",	Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:"",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0}
			];
			for(var j=0; j<trades.length; j++) {
				cols.push({Type:"Int",	Hidden:0,	Width:60,	Align:"Right",	ColMerge:0,	SaveName:"Fcast",	KeyField:0,	CalcLogic:"",	Format:"Integer",	PointCount:0,	UpdateEdit:0,	InsertEdit:0});
				cols.push({Type:"Int",	Hidden:0,	Width:80,	Align:"Right",	ColMerge:0,	SaveName:"NoSho",KeyField:0,	CalcLogic:"",	Format:"Integer",	PointCount:0,	UpdateEdit:0,	InsertEdit:0});
				cols.push({Type:"Text",	Hidden:0,	Width:60,	Align:"Right",	ColMerge:0,	SaveName:"Ratio",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:2,	UpdateEdit:0,	InsertEdit:0});
			}
			
			cols.push({Type:"Text",	Hidden:1,	Width:50,	Align:"Left",		ColMerge:0,	SaveName:"lvl",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0});
			cols.push({Type:"Text",	Hidden:0,	Width:1,	Align:"Center",	ColMerge:0,	SaveName:"",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0});
			InitColumns(cols);

			SetEditable(0);
			if (!check_retrive) {
				SetSheetHeight(ComGetSheetHeight(sheetObj, 16));
			}
			SetCellBackColor(1, 0, "#DEFBF8");
			SetCellBackColor(1, columnCount, GetCellBackColor(1, 0));
		}
	}

    	/**
    	 * Changing the title after retrieving it in TabSheet3
    	 */
    	function initSheet3(sheetObj) {
    		with(sheetObj) {
    			var columnCount = 12;
    			(columnCount, 0 , 0, false);
		    	      var HeadTitle1="RHQ/Area|Office|Lane|Week|VVD|F'cast|BKG|Alloc|Diff/Shortfall|Ratio";
		    	      var cnt=0;
//		    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
//		    	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			       	   SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7  } );
			    	   var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		    	      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"office",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"week",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"Fcast",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"BKG",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"Alloc",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"NoSho",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"Ratio",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:30,    Align:"Left",    ColMerge:0,   SaveName:"lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},//, TreeCol:1 ,  LevelSaveName:"sLevel"
		    	             {Type:"Text",      Hidden:0,  Width:1,    Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		    	       
		    	      InitColumns(cols);
		    	      SetEditable(0);
		    	      SetSheetHeight(ComGetSheetHeight(sheetObj,16) );
		    	      }
    	}
    	/**
         *Changing the title after retrieving it in TabSheet4
         */
    	function initSheet4(sheetObj){
            with(sheetObj){
		            var columnCount=15;
		            (columnCount, 0 , 0, false);
		            var HeadTitle1="Trade|Lane|Week|VVD|RHQ/Area|Office|F'cast|BKG|Alloc|Diff/Shortfall|Ratio";
		            var cnt=0;
//		            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
//		            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		     	   SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7  } );
		    	   var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trade",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"week",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"area",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"office",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"Fcast",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"BKG",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"Alloc",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"NoSho",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"Ratio",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:30,    Align:"Left",    ColMerge:0,   SaveName:"lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //, TreeCol:1 ,  LevelSaveName:"sLevel"
			    	             {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL3", KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL4", KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	             {Type:"Text",      Hidden:0,  Width:1,    Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		             
		            InitColumns(cols);
		            SetEditable(0);
		            SetSheetHeight(ComGetSheetHeight(sheetObj,16));
		            //InitTreeInfo(columnCount - 2, "sLevel", "#0000FFNAN";
            }
    	}
    	/**
         * Changing the title after retrieving it in TabSheet5
         */
    	function initSheet5(sheetObj){
    	      with(sheetObj){    	         
	    	         var columnCount=14;
	    	         (columnCount, 0 , 0, false);
	    	         var HeadTitle1="Trade|Lane|Week|VVD|RGN-Office|Sub-Office|F'cast|BKG|Alloc|Diff/Shortfall|Ratio";
	    	         var cnt=0;
//	    	         SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
//	    	         var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		     	     SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7  } );
		    	     var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    	         InitHeaders(headers, info);
	    	         var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trade",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"week",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rgn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"office",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"Fcast",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"BKG",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"Alloc",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"NoSho",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"Ratio",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Text",      Hidden:1, Width:30,    Align:"Left",    ColMerge:0,   SaveName:"lvl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0}, //,  TreeCol:1,  LevelSaveName:"sLevel"
				    	             {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL3", KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL4", KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    	             {Type:"Text",      Hidden:0,  Width:1,    Align:"Center",  ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    	          
	    	         InitColumns(cols);
	    	         SetEditable(0);
	    	         SetSheetHeight(ComGetSheetHeight(sheetObj,16));
	    	         }
    	}

	function dataSelectionByTradeByOffice(event) {
		var object = document.getElementById("ofcCheck");
		var rowCount = t1sheet2.RowCount();

		for (var i=0; i<rowCount; i++) {
			var cellValue = t1sheet2.GetCellValue(i+2, "lvl");
			if (cellValue == "2") {
				t1sheet2.SetRowHidden(i+2, !object.checked);
			}
		}
		t1sheet2.SetDataMerge(); 
	}

    	function t1sheet3_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "office":
        	case "lane":
        	case "week":
        		var mark=sheetObj.GetCellValue(row, col);
    			if(mark == "+" || mark == "-"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
    	function t1sheet4_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "lane":
        	case "week":
        	case "area":
        	case "office":
        		var mark=sheetObj.GetCellValue(row, col);
    			if(mark == "+" || mark == "-"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
    	function t1sheet5_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "lane":
        	case "week":
        	case "rgn":
        	case "office":
        		var mark=sheetObj.GetCellValue(row, col);
    			if(mark == "+" || mark == "-"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
    	
    	/*
    	 * toggle 재정의
    	 */
       	function toggleExpand(sheetObj, row, col){
       		var mark=sheetObj.GetCellValue(row, col);
//    		if(sheetObj.GetRowExpanded(row)){
//    			sheetObj.SetRowExpanded(row,0);
//    			sheetObj.SetCellValue(row, col,"+",0);
//    		}
//    		else{
//    			sheetObj.SetRowExpanded(row,1);
//    			sheetObj.SetCellValue(row, col,"-",0);
//    		}
    		
			if(mark == "+" ){
				//toggleExpand(sheetObj, row, col);
				var startRow = row + 1;
				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
				
				for(;startRow <= endRow;startRow++){
					sheetObj.SetRowHidden(startRow,0);
				}
   				sheetObj.SetCellValue(row, col, "-", 0);
				
			} else if(mark == "-") {
				var startRow = row + 1;
				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
				for(;startRow <= endRow;startRow++){
					sheetObj.SetRowHidden(startRow,1);
				}
   				sheetObj.SetCellValue(row, col, "+", 0);
			}
	
    		
//			if(mark == "+" ){
//				//toggleExpand(sheetObj, row, col);
//				var startRow = row + 1;
//				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
//				
//				for(;startRow <= endRow;startRow++){
//					sheetObj.SetRowHidden(startRow,0);
//					if(sheetObj.ColSaveName(col) == "pol_cd" && sheetObj.GetCellValue(startRow, "pod_cd") == '+'){
//						startRow = sheetObj.GetMergedEndCell(startRow,"pol_cd").split(",")[0] ;	
//					}
//				}
//   				sheetObj.SetCellValue(row, col, "-", 0);
//				
//			} else if(mark == "-") {
//				var startRow = row + 1;
//				var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
//				for(;startRow <= endRow;startRow++){
//					sheetObj.SetRowHidden(startRow,1);
//				}
//   				sheetObj.SetCellValue(row, col, "+", 0);
//			}
			sheetObj.SetDataMerge();
   		
    		
    		
       	}
       	
       	
       	
       	
    	function changePeriod(){
/*
    		var obj=event.srcElement;
    		if(obj.selectedIndex == 0) return;
    		switch(ComGetEvent("name")){
    		case "month":
    			obj.form.week.selectedIndex=0;
    			break;
    		case "week":
    			obj.form.month.selectedIndex=0;
    			break;
    		}
*/
    	}
     // Handling the process related with sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
               case IBSEARCH:      //Retrieve
                    var sheetObj=sheetObjects[beforetab];
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }  
    				searchParams=SpcFormString(formObj,'type,year,month,week,rhq,office,trade,lane,vvd,ofcChek');
    				check_retrive=true;
    				for(var i=0 ; i < tab_retrives.length ; i++){
    					tab_retrives[i]=false;
    				}
    				//for(var j=0 ; j < sheetObjects.length ; j++){
    				//	sheetObjects[j].RemoveAll();
    				//}
                    if(beforetab==0){
                    	searchSummary(sheetObj, formObj, (SEARCHLIST01));
                    }else if(beforetab==1){
                    	searchByTrade(sheetObj, formObj, (SEARCHLIST02));
                    }else if(beforetab==2){
                    	searchByOffice(sheetObj, formObj, (SEARCHLIST03));
                    }else if(beforetab==3){
                    	searchByLane(sheetObj, formObj, (SEARCHLIST04));
                    }else if(beforetab==4){
                    	searchBySubOffice(sheetObj, formObj, (SEARCHLIST05));
                    }
    				break;
               case IBDOWNEXCEL:        //Excel download             
            	   sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
                  break;
            }
        }
    	function searchSummary(sheetObj, formObj, command){
    		if(tab_retrives[beforetab]) return;
    		var rtn=sheetObj.GetSearchData("ESM_SPC_0024GS.do", "f_cmd="+command+"&"+searchParams);  		

    		if(ComGetTotalRows(rtn)>1) {
        		tab_retrives[beforetab]=true;
        		var title=getEtcDataFromXml(rtn, "title");
        		var week=getEtcDataFromXml(rtn, "week");
//        		t1sheet1.Reset(); 
        		sheetObjects[0] = sheetObjects[0].Reset();
        		
            	initSheet1(t1sheet1, title);
            	t1sheet1.RenderSheet(0);
            	t1sheet1.LoadSearchData(rtn,{Sync:1} );
            	t1sheet1.RenderSheet(1);
            	sheet1_wk.innerText=week;
    		}  else {
    			t1sheet1.LoadSearchData(rtn,{Sync:1} );
			}
        	
    	}

    	function searchByTrade(sheetObj, formObj, command) {
    		if (tab_retrives[beforetab]) return;
    		var rtn = sheetObj.GetSearchData("ESM_SPC_0024GS2.do", "f_cmd=" + command + "&" + searchParams);

    		if(ComGetTotalRows(rtn)>1) {
        		tab_retrives[beforetab] = true;
        		var title = getEtcDataFromXml(rtn, "title"); 
        		sheetObjects[1] = sheetObjects[1].Reset();
            	initSheet2(t1sheet2, title);
            	t1sheet2.RenderSheet(0);
            	t1sheet2.LoadSearchData(rtn, {Sync:1});
            	t1sheet2.RenderSheet(1);
    		}  else {
    			sheetObj.LoadSearchData(rtn,{Sync:1} );
			}
        	
    	}

    	function searchByOffice(sheetObj, formObj, command) {
    		if (tab_retrives[beforetab]) return;
    		var rtn = sheetObj.GetSearchData("ESM_SPC_0024GS3.do", "f_cmd=" + command + "&" + searchParams);
    		
    		if(ComGetTotalRows(rtn)>0) {        		
        		tab_retrives[beforetab] = true;
        		sheetObj.RenderSheet(0);
        		sheetObj.LoadSearchData(rtn, {Sync:1});
        		sheetObj.RenderSheet(1);
    		}  else {
    			sheetObj.LoadSearchData(rtn,{Sync:1} );
			}

    	}

    	function searchByLane(sheetObj, formObj, command){
    		if(tab_retrives[beforetab]) return;
//     		var rtn = sheetObj.DoSearch("ESM_SPC_0024GS4.do", "f_cmd="+command+"&"+searchParams );
			var rtn=sheetObj.GetSearchData("ESM_SPC_0024GS4.do", "f_cmd="+command+"&"+searchParams );
			
    		if(ComGetTotalRows(rtn)>0) {
    			sheetObj.RenderSheet(0);
    			sheetObj.LoadSearchData(rtn, {Sync:1});
    			sheetObj.RenderSheet(1);
    			
    			//tree접기
    			var iCheckRow = sheetObj.FindCheckedRow("cL4");
    			var arrRow=iCheckRow.split("|");//
    			for (var idx=0; idx<arrRow.length; idx++){
    				t1sheet4_OnClick(sheetObj, parseInt(arrRow[idx]), 5);
    			}
    			iCheckRow = sheetObj.FindCheckedRow("cL3");
    			arrRow=iCheckRow.split("|");//
    			for (var idx=0; idx<arrRow.length; idx++){
    				t1sheet4_OnClick(sheetObj, parseInt(arrRow[idx]), 4);
    			}
    			
        		tab_retrives[beforetab]=true;
    		}  else {
    			sheetObj.LoadSearchData(rtn,{Sync:1} );
			}
    		
    	}
    	function searchBySubOffice(sheetObj, formObj, command){
    		if(tab_retrives[beforetab]) return;
//     		var rtn = sheetObj.DoSearch("ESM_SPC_0024GS5.do", "f_cmd="+command+"&"+searchParams );
			var rtn=sheetObj.GetSearchData("ESM_SPC_0024GS5.do", "f_cmd="+command+"&"+searchParams );
			
    		if(ComGetTotalRows(rtn)>0) {
        		
    			sheetObj.RenderSheet(0);
    			sheetObj.LoadSearchData(rtn, {Sync:1});
    			sheetObj.RenderSheet(1);
    			
    			//tree접기
    			var iCheckRow = sheetObj.FindCheckedRow("cL4");
    			var arrRow=iCheckRow.split("|");//
    			for (var idx=0; idx<arrRow.length; idx++){
    				t1sheet5_OnClick(sheetObj, parseInt(arrRow[idx]), 5);
    			}
    			iCheckRow = sheetObj.FindCheckedRow("cL3");
    			arrRow=iCheckRow.split("|");//
    			for (var idx=0; idx<arrRow.length; idx++){
    				t1sheet5_OnClick(sheetObj, parseInt(arrRow[idx]), 4);
    			}
    			
        		tab_retrives[beforetab]=true;
    		}  else {
    			sheetObj.LoadSearchData(rtn,{Sync:1} );
			}

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
    		//log("rtn : " + rtn);
    		return rtn;
    	}
      	/*
    	 * Changing trade
    	 */
    	function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	    //lane value change
    	    comObjects[2].SetSelectIndex(0,false);
    	    
        	var formObj = document.form;
        	var trade = formObj.trade.value;
        
        	if(trade != null && trade != ''){		
        		SpcSearchOptionLane("lane",true,true,'',formObj.trade.value,"",true);	// 0207 SHKIM
        	}	    	    
    	    
      	}	
        /*
    	 * Changing lane
    	 */
    	var value;
       	function lane_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	    var trade=comboObj.GetText(newCode,0);
    	    if(value != "" ){    	
    		   	comObjects[1].SetSelectCode(trade,false);
    	 	}else{
    			comObjects[1].SetSelectCode("",false);
    	    }
       	} 
       	function lane_location_OnBlur() {
       	 document.form.lane_location_text.value = lane.GetText(parseInt(combo_location.GetSelectIndex()), 0);
       	}

       /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
    		var month=formObj.month.value;
    		var week=formObj.week.value;
    		var rhq=comObjects[0].GetSelectCode();
    		var vvd=formObj.vvd.value;
    		if(vvd == "" && month == "" && week == ""){
    			ComShowCodeMessage("COM12139", "Month", "Week");
    			//formObj.month.focus();
    			return false;
    		}
    		if(rhq == ""){
    			ComShowMessage(getMsg("SPC90114", "RHQ"));
    			//formObj.rhq.focus();
    			return false;
    		}
    		if(vvd != "" && vvd.length < 9){
    			ComShowCodeMessage("COM12174", "VVD", "9");
    			//formObj.vvd.focus();
    			return false;
    		}
            return true;
        }
        function initDataValue_rhq(){
        	var sheetObj=document.getElementById("rhq");
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
        function initDataValue_lane(){
        	var sheetObj=document.getElementById("lane");
        	with(sheetObj){
        		Index2=0;
        	}
        }
        function optionSetting() {
        	SpcSearchOptionYear("year");
        	SpcSearchOptionMonth("month", true);
         	SpcSearchOptionWeek("week", true);
         	
        	if(document.form.office.value=='SINHO'){
        		SpcSearchOptionRhq("rhq");
        	}else{
        		SpcSearchOptionRhq("rhq","","","",true);
        	}
        	
        	var strOffice = document.form.office.value;
        	
        	if(strOffice == 'SINHO' || strOffice == 'NYCHQ' || strOffice == 'SINHQ' || strOffice == 'LONHQ'){
        		document.form.office.value = "";
        	}
        	
         	SpcSearchOptionTrade("trade");
         	SpcSearchOptionLane("lane");
        }
        
    	function resizeSheet(){
            for(var i=0;i<sheetObjects.length;i++){
                ComResizeSheet(sheetObjects[i]);
            }    		
    	}
