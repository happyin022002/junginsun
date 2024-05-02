/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 :  ESM_SPC_0053.js
*@FileTitle  : Control Option Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    //sheetResizeFull = true;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    	function processButtonClick(){
    		 /***** setting additional sheet value in case of more 2 sheet per tab *****/
    		 var sheetObject=sheetObjects[0];
    		 /*******************************************************/
    		 var formObject=document.form;
    		try {
    			var srcName=ComGetEvent("name");
    			 if(ComGetBtnDisable(srcName)) return false;
    			switch(srcName) {
    				case "btn_retrieve":
//            			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
            	    	sheetObjects[0].RemoveAll();
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				case "btn_new":
    					if(checkModifiedSheet(sheetObject)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//using common funtion : initializing the screen
    					formObject.reset();
    					sheetObject.RemoveAll();
    					optionSetting();
    					break;
    				case "btn_downexcel":
    					if(sheetObject.RowCount() < 1){//no data
    						ComShowCodeMessage("COM132501");
    					}else{
    						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					}
    					
    					break;
    				case "btn_popup_vvd":
    					var param="&vvd_cd=" + formObject.vvd.value;
      					spcPopup("VVD", param, 770, 470, "getVVD", "1,0,1,1,1,1,1,1" );
    	   	        	break;  	
    			} // end switch
    		}catch(e) {
        		if( e == "[object Error]") {
        		    ComShowCodeMessage("COM12111");
        		} else {
        			ComShowMessage(e);
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
    		for(i=0;i<sheetObjects.length;i++){
    			// change the name of start environment setting funtion
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			// Adding last environment setting funtion
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		var sheetResizeFull=true;
    		document_onresize();
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
    			      var HeadTitle="Rep. Trade|Rep.\nSub Trade|Lane|Bound|Week|VVD|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Control Option|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Loadable|Loadable|Loadable|Loadable|Loadable|Loadable";
    			      var HeadTitle1="Rep. Trade|Rep.\nSub Trade|Lane|Bound|Week|VVD|Volume|HC|45'|53'|Reefer|POL/POD|Weight|Volume|HC|45'|53'|Reefer|Weight|Volume|HC|45'|53'|Reefer|Weight";
    			      // row merge하지 않음, column merge만 함
//    			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1} );
    			      SetConfig( { SearchMode:0, DataRowMerge:0, MergeSheet:7} );
    			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    			      var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
    			      InitHeaders(headers, info);
    			      var cols = [ 
    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ColMerge:1 },
    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, TrueValue:"Y", FalseValue:"N" },
    			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
    			             {Type:"Text",      Hidden:1,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 } ];
    			       
    			      InitColumns(cols);
    			      SetEditable(0);
//    			      SetSheetHeight(550);
    			      resizeSheet();
    			      SetHeaderRowHeight(20);
    			      SetHeaderRowHeight(21);
    			     // SetRangeBackColor(1,6, 1,21,"#DEFBF8");
    			      SetFocusEditMode(default_edit_mode);
    			      }
    				break;
    		}
    	}
     // Handling the process related with sheet
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
    				formObj.f_cmd.value=SEARCHLIST;
    				var param=SpcFormString(formObj,"f_cmd,year1,week1,year2,week2,trade,subtrade,lane,bound,vvd");
    				var sXml=sheetObj.GetSearchData("ESM_SPC_0053GS.do", param );
    				sheetObj.LoadSearchData(sXml,{Sync:1} );
    				break;			
    		   case IBDOWNEXCEL:        //Excel download
    			   
            	   sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
    				break;
    		}
    	}	
    	/*
    	 * Changing trade
    	 */
    	function trade_OnChange(comObj){		
        	//sub_trade value change  
        	comObjects[1].SetSelectIndex(0,false);
        	//lane value change
        	comObjects[2].SetSelectIndex(0,false);
        	
        	var formObj = document.form;
        	var trade = formObj.trade.value;
        
        	if(trade != null && trade != ''){		
        		SpcSearchOptionSubTrade("subtrade",true,false, "", formObj.trade.value);			// 0207 SHKIM			
        		SpcSearchOptionLane("lane",true,true,'',formObj.trade.value,formObj.subtrade.value,true);	// 0207 SHKIM
        	}        	
        	
    	}
    	/*
    	 * Changing sub_trade
    	 */
    	function subtrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	    if(newText != "" ){  
    	      comObjects[0].SetSelectCode(comboObj.GetText(parseInt(newIndex),0),false);
    	    }else{
    	   		comObjects[0].SetSelectCode("",false);
    	    }
    	    //lane value change
    	    comObjects[2].SetSelectIndex(0,false);
    	    
    		var formObj = document.form;
    		var subtrade = formObj.subtrade.value;
    	
    		if(subtrade != null && subtrade != ''){		
    			SpcSearchOptionLane("lane",true,true,'',formObj.trade.value,formObj.subtrade.value,true);	// 0207 SHKIM
    		}    	    
    	    
      	} 
       	/*
    	 * Changing lane
    	 */
       	function lane_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
       		var repTrade=comboObj.GetText(parseInt(newIndex),0);  
    	    var subTrade=comboObj.GetText(parseInt(newIndex),1);
    	    if(newText != "" ){  
    		   	comObjects[0].SetSelectCode(repTrade,false);
    		   	comObjects[1].SetSelectCode(subTrade,false);
    		}else{
    	 		comObjects[0].SetSelectCode("",false);
    			comObjects[1].SetSelectCode("",false); 
    	    }
       	}
    	/*
    	 * Getting VVD value
    	 */
    	function getVVD(rowArray) {
    		var colArray=rowArray[0];
    		document.all.vvd.value=colArray[7];
    	}
    	/*
    	* Checking inputed VVD value
    	 */
    	 function checkValue() {
        	var formObj=document.form;
        	var value=formObj.vvd.value;
        	value=ComTrim(value);
    		if(value.length>0){
    			if(value.length<9){
    				ComShowMessage(getMsg("SPC90116", "VVD"));
    				formObj.vvd.focus();
    				return;
    			}else{
    				var rtn=getCodeList("VVD", "vvd_cd="+value);
    		    	if(rtn[0] == ""){    		
    		    		ComShowMessage(getMsg("SPC90199", value));
    		    		formObj.vvd.focus();
    		    		return;
    		    	}	
    			}
    		}
        }	
       /**
    	 * handling process for input validation
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    			var wk=calcPeriod(year1.value,week1.value,year2.value,week2.value);
    			if( wk < 0 ){
                	ComShowMessage(getMsg("SPC90115","Period")); 
                    formObj.year1.focus();
                    return false;
                }
                var vvd_value=vvd.value;
                if(vvd_value.length>0 && vvd_value.length<9){
                	ComShowCodeMessage("COM12174", "VVD", "9"); 
                    formObj.vvd.focus();
                    return false;
                } 
    		}
    		return true;
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
    	
    	function resizeSheet(){
    	    ComResizeSheet(sheetObjects[0]);
    	}

