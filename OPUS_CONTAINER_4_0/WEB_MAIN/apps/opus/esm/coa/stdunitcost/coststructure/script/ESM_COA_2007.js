/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_coa_2007.js
*@FileTitle  : Week Period Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_coa_2007 : business script for esm_coa_2007
     */
    var sheetObjects=new Array();
    var sheetCnt=0;
    var strOfcCd="";
     // Event handler processing by button click event */
    document.onclick=processButtonClick;
     // Event handler processing by button name */
        function processButtonClick(){
       	 var sheetObject1=sheetObjects[0];
       	 var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName)
                {
   				case "btn_add":
   					doActionIBSheet(sheetObject1,formObject,IBINSERT);
   				break; 
   				case "btn_retrieve":
   					sheetObject1.SetWaitImageVisible(0);
   					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
   					sheetObject1.SetWaitImageVisible(1);
   				break;														
   				case "btn_save":
   					doActionIBSheet(sheetObject1,formObject,IBSAVE);
   				break;														
   				case "btn_downexcel":
   					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
   				break;
   				case "btn_loadexcel":
    				doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
    				break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COA00011",srcName+" Button Fail.");
        		} else {
        			ComShowCodeMessage("COA00011",e);
        		}
        	}
        }
        /**
         * registering IBSheet Object as list
         * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
         */
        function setSheetObject(sheet_obj)
        {
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() 
        {
            for(i=0;i<sheetObjects.length;i++)
            {
            	ComConfigSheet (sheetObjects[i] );
            	initSheet(sheetObjects[i],i+1);
            	ComEndConfigSheet(sheetObjects[i]);
            }
            sheet1_OnLoadFinish(sheet1);
      		//loadingMode = true;
            //doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            //loadingMode = false;
            //axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
        	//axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
        	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        	//axon_event.addListenerForm('change', 'obj_change', document.form); // change
        	//axon_event.addListenerForm('click', 'obj_click', document.form); // click
        }
        function sheet1_OnLoadFinish(sheetObj){
            sheetObj.SetWaitImageVisible(0);
            //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            sheetObj.SetWaitImageVisible(1);
     	}
     	/**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) 
        {
            var cnt=0;
            switch(sheetNo) 
            {
                case 1:      //sheet1 init
                    with(sheetObj){
//		                  (7, 0, 0, true);
		                  var HeadTitle="Del.|STS|Year|Week|From Sales Date|To Sales Date";
		
		                  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                  InitHeaders(headers, info);
		
		                  var cols = [ {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg" },
		                         {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                         {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cost_yr",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
		                         {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cost_wk",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
		                         {Type:"Date",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"sls_fm_dt",  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                         {Type:"Date",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"sls_to_dt",  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
		                   
		                  InitColumns(cols);
		                  SetColProperty(0 ,"cost_yr" , {AcceptKeys:"N" , InputCaseSensitive:1});
		                  SetColProperty(0 ,"cost_wk" , {AcceptKeys:"N" , InputCaseSensitive:1});
		                  SetEditable(1);
//		                  SetSheetHeight(430);
						  resizeSheet();
                        }
                    break;
            }
        }
        /**
         * sheet event
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
			var selrow=sheetObj.GetSelectRow();
            switch(sAction) 
            {
			case IBINSERT:
   				var currow=sheetObj.DataInsert();
		    	//sheetObj.CellValue(currow, 2) = document.form.f_cost_yr.value;
   			break;
   			case IBSEARCH:
  				if(!validateForm(sheetObj,formObj,sAction)){
  					return false;
  				}
  				if(sheetObj.id == "sheet1") {
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);	
		            setTimeout( function () {				
						formObj.f_cmd.value=SEARCH;
		 				var xml="";
	 	 				xml=sheetObj.GetSearchData("ESM_COA_2007GS.do", FormQueryString(formObj));
		 				sheetObj.LoadSearchData(xml,{Sync:1} );
		 				ComOpenWait(false);
		            }, 100);
				}
   			break;
   			case IBSAVE:
   				if(validateForm(sheetObj,formObj,IBSAVE)){
   					if(sheetObj.id == "sheet1") 
   					{
   						var sel_code=sheetObj.GetCellValue(selrow,"sls_fm_dt");
   						var cur_code="";
   						sheetObj.SetWaitImageVisible(0);
   						ComOpenWait(true);	   						
   						formObj.f_cmd.value=MULTI;
   						if(sheetObj.DoSave("ESM_COA_2007GS.do", FormQueryString(formObj)))
   						{
   	   						//retrieving in case of successful saving
   	   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   	   		                for(var i=1; i<=sheetObj.RowCount(); i++)
   	   		                {
   	   		                	cur_code=sheetObj.GetCellValue(i,"sls_fm_dt");
   	   		   	            	if(sel_code == cur_code)
   	   		   	            	{
   	   		   	            		sheetObj.SelectCell(i, 3, true);
   	   		   	            		ComOpenWait(false);
   	   		   	            		return;
   	   		   	            	}
   	   		                }		// End for
   						}
   						ComOpenWait(false);
   					}
   				}
   			break;
			case IBDOWNEXCEL:	//excel download
				selectDownExcelMethod(sheetObj);
			break;
			case IBLOADEXCEL:                  // excell loading
        		//20150716.MOD/ADD/DEL
        		sheetObj.SetWaitImageVisible(0);
	        	sheetObj.RemoveAll();
	        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
				break;
            }
        }
        
  
        function callBackExcelMethod(excelType) {
        	switch (excelType) {
            case "AY":
            	sheet1.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
                break;
            case "AN":
            	sheet1.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
            case "DY":
            	sheet1.Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
            	break;
            case "DN":
            	sheet1.Down2Excel({HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
			}
        }
        
    	/**
    	* input validation
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		switch(sAction){		
    		case IBSEARCH:
    			with(formObj){
    			if(!ComChkObjValid(f_cost_yr, null, null, "yyyy")) return false;
    			if(f_cost_wk_fm.value.length != "" & f_cost_wk_fm.value.length != 2) {
                    ComShowMessage(ComGetMsg("COM12114","From Week",""));
                    f_cost_wk_fm.focus();
                    return false;
                }
    			if(f_cost_wk_to.value.length != "" & f_cost_wk_to.value.length != 2) {
                    ComShowMessage(ComGetMsg("COM12114","To Week",""));
                    f_cost_wk_to.focus();
                    return false;
                }
    			if (f_cost_wk_fm.value > f_cost_wk_to.value) {
                    // [COA10011] = Check for month value : From <= to
                    ComShowMessage(ComGetMsg("COA10011","Week","From","To"));
                    f_cost_wk_to.focus();
                    return false;
                }
    			if(!ComChkObjValid(f_cost_wk_fm, null, null, "yw")) return false;
                if(!ComChkObjValid(f_cost_wk_to, null, null, "yw")) return false;
    			}
			break;
    		case IBSAVE:	
    			var dr=sheetObj.ColValueDup("cost_yr|cost_wk");
    			if(dr>0){				
    				ComShowCodeMessage('COM12115', 'Year, Week Group');
    				sheetObj.SelectCell(dr,"cost_wk");
    				return false;
    			}
    			var fm_dt=null;
    			var to_dt=null;
    			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
    				if ((sheetObj.GetCellValue(i, "ibflag") == "I") || (sheetObj.GetCellValue(i, "ibflag") == "U")) {
    					if (sheetObj.GetCellValue(i, "cost_wk") != "00" && sheetObj.GetCellValue(i, "cost_wk") != "01" && sheetObj.GetCellValue(i, "cost_wk")  < 53) {
    						fm_dt=sheetObj.GetCellValue(i, "sls_fm_dt").substr(0, 4) + "-" + sheetObj.GetCellValue(i, "sls_fm_dt").substr(4, 2) + "-" + sheetObj.GetCellValue(i, "sls_fm_dt").substr(6, 2);
    						to_dt=sheetObj.GetCellValue(i, "sls_to_dt").substr(0, 4) + "-" + sheetObj.GetCellValue(i, "sls_to_dt").substr(4, 2) + "-" + sheetObj.GetCellValue(i, "sls_to_dt").substr(6, 2);
	    					if (ComGetDaysBetween(fm_dt, to_dt) != 6) {
	    	    				ComShowCodeMessage('COA10015', 'Sales Date Duration');
	    	    				sheetObj.SelectCell(i,"sls_to_dt");
	    	    				return false;
	    					}
    					}
    				}
    			}
    			break;
    		}
    		return true;
    	}
        function sheet1_OnChange(sheetObj, row, col, value)
        {
        }

        function resizeSheet(){
       	 ComResizeSheet(sheetObjects[0]);
        }
        
        //SJH.20150507.ADD : LOADEXCEL OPTION
        function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
        	ComOpenWait(false);									//20150716.MOD
        	if(isExceedMaxRow(msg)) return;
        }    
        
        //20150716.ADD
        function sheet1_OnLoadFileSelect(sheetObj){
            ComOpenWait(true);
        }      
