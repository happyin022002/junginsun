/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0047.js
*@FileTitle  : Model Execution
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
     * @extends
     * @class ESM_SAQ_0047 : business script for ESM_SAQ_0047
     */
    function ESM_SAQ_0047() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var currentTabIndex=0;
 // Event handler processing by button click event */
    document.onclick=processButtonClick;
 // Event handler processing by button name */
        function processButtonClick(){
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		 if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
//                    case "btn_reset":
//    					doActionIBSheet(sheetObjects[currentTabIndex], formObject, IBSEARCH_ASYNC01);
//                        break;
                    case "btn_retrieve":
    					doActionIBSheet(sheetObjects[currentTabIndex], formObject, IBSEARCH);
                        break;
                    case "btn_create":
       	            	doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                        break;
    				case "btn_downexcel":
    					if(sheetObjects[currentTabIndex].RowCount() < 1){//no data
    						ComShowCodeMessage("COM132501");
    					}else{
    						doActionIBSheet(sheetObjects[currentTabIndex],formObject,IBDOWNEXCEL);
    					}

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
    	function setTabObject(tab_obj){
    		tabObjects[tabCnt++]=tab_obj;
    	}
    	/**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
        	optionSetting();
            for(var i=0;i<sheetObjects.length;i++){
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
    				// tab Object init
    				for(k=0;k<tabObjects.length;k++){
    					initTab(tabObjects[k],k+1);
    					  tabObjects[k].SetSelectedIndex(0);
    				}
    				var sheetResizeFull=true;
    				var sheetResizeCount=2;
           	var formObj=document.form;
           	setYearMonthObject(formObj.year, formObj.bse_qtr_cd);
    		doActionIBSheet(sheetObjects[currentTabIndex],formObj,IBSEARCH);
    		document.form.year.focus();
        }
        /**
         * initializing Tab
         * setting Tab items
         */
    	function initTab(tabObj, tabNo) {
    		var cnt=0 ;
    		switch(tabNo) {
    			 case 1:
    				with (tabObj) {
    				 InsertItem( "Execution Item" , "");
    				 InsertItem( "Execution Log"  , "");
    				}
    				break;
    		}
    	}
    	/**
         * Event when clicking Tab
         * activating selected tab items
         */
    	function tab1_OnChange(tabObj , nItem)
    	{
    		currentTabIndex=nItem;
    		var objs=document.all.item("tabLayer");
    		for(i=0; i<objs.length; i++) {
    			objs[i].style.display="none";
    		}
    		objs[nItem].style.display="Inline";
    		// Tab Click시 자동 조회
    		if ( currentTabIndex == 1 ) {
    	       	var formObj=document.form;
    			doActionIBSheet(sheetObjects[currentTabIndex], formObj, IBSEARCH);
    		}
    		// Search 조건 div 컨트롤
    		var searchObjs=document.all.item("searchLayer");
    		for(i=0; i<searchObjs.length; i++) {
    			searchObjs[i].style.display="none";
    		}
    		searchObjs[currentTabIndex].style.display="Inline";
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
			             var HeadTitle="Seq|Process Item|Status|";
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			             var headers = [ { Text:HeadTitle, Align:"Center"} ];
			             InitHeaders(headers, info);
			             var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"code",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			                          {Type:"Text",      Hidden:0,  Width:600,  Align:"Left",    ColMerge:0,   SaveName:"item",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
			                          {Type:"Image",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"status",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                          {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"status1" } ];

			             InitColumns(cols);
			             SetEditable(0);
			             SetSheetHeight(411);
			             SetImageList(0,"/opuscntr/img/ico_g.gif");
			             SetImageList(1,"/opuscntr/img/ico_r.gif");
			             SetImageList(2,"/opuscntr/img/ico_y.gif");
                	}
                    break;
                case 2:      //sheet1 init
                    with(sheetObj){
		                  var HeadTitle="System Date|Log Date|Mode Name|Log Desc.";
		                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                  InitHeaders(headers, info);
		                  var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sys_date",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"exec_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                         {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"mod_name",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
		                         {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"log_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];

		                  InitColumns(cols);
		                  SetEditable(0);
		                  SetSheetHeight(411);
                        }
                    break;
            }
        }
      	// handling sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
               case IBSEARCH:      //retrieve
                	if ( currentTabIndex == 0 ) {
    					formObj.f_cmd.value=SEARCHLIST01;
    				} else {
    					formObj.f_cmd.value=SEARCHLIST02;
    				}
                	sheetObj.DoSearch("ESM_SAQ_0047GS.do", saqFormString(formObj) );
                	if ( currentTabIndex == 0 ) {
    					// Step Initialization variable
    					document.forms[0].step.value="";
    					document.forms[0].fm_step.value="";
    					document.forms[0].to_step.value="";
    				}
                    break;
                case IBSAVE:        //save
                	var row=sheetObj.GetSelectRow();
    	        	// not used row(1,2)
    	        	if ( row == 1 || row == 2 ) {
    	        		return;
    	        	}
    	        	// Step setting
    	        	formObj.step.value=sheetObj.GetCellValue(row, 0);
    	        	formObj.fm_step.value=sheetObj.GetCellValue(row, 0);
    	        	formObj.to_step.value=sheetObj.GetCellValue(row, 0);
        			// setting row color
        			for(i=3 ; i <= 13 ; i++){
        				sheetObj.SetRowBackColor(i,"#FFFFFF");
        			}
        			sheetObj.SetRowBackColor(row,"#FFFF00");
    	        	if(ComShowConfirm (getMsg("SAQ99999", "Do you process the selected item?")) != 1){
    	           		return;
    	         	}
                	var fm_step=formObj.fm_step.value;
                	var to_step=formObj.to_step.value;
                	if ( fm_step && to_step ) {
    					formObj.f_cmd.value=MULTI01;
    					// Retrieve
    					doActionIBSheet(sheetObj,formObj,IBSEARCH);
    				} else {
    		        	alert (getMsg("SAQ99999", "You didn't select the item. Process after selecting the item."));
    				}
                    break;
    		   case IBDOWNEXCEL:
    			   selectDownExcelMethod(sheetObj);
    			   break;
             }
        }
        
        function callBackExcelMethod(excelType) {
        	var sheetObj = sheetObjects[currentTabIndex];
    		if(sheetObj.RowCount() < 1){//no data
    			ComShowCodeMessage("COM132501");
    			return;
    		}
    		DownExcel(sheetObj, excelType);
    	}

        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	// setting row color
        	for(i=1 ; i <= 2 ; i++){
				sheetObj.SetRowBackColor(i,"#808080");
			}
        }

    	/*
    	 * Sheet Double Click Event
    	 */
    	function sheet1_OnDblClick(sheetObj, Row, Col) {
    		formObj=document.forms[0];
    		with(sheetObj) {
    			doActionIBSheet(sheetObj,formObj,IBSAVE);
    		}
    	}
    	function optionSetting() {
    		SaqSearchOptionYear("year");
    		SaqSearchOptionQuarter("bse_qtr_cd");
    	}

