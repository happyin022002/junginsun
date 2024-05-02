/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0008.js
*@FileTitle : Lease Term Code Creation
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
     * @fileoverview 
     * @author 
     */
 // common static variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var sheet1=null;
//html form
 var frm=null;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
 		  var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
          try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
             		//Download Excel Button
				case "btn_downexcel":
					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(	sheetObject1), SheetDesign:1,Merge:1,KeyFieldMark:0 });
					break;
				case "btn_loadexcel":
	                sheetObject1.RemoveAll();
					sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
				
					break; 
				case "btn_save":
					/*alert(sheetObject1.GetCellValue(1,0));
					alert(sheetObject1.GetCellValue(1,1));
					alert(sheetObject1.GetCellValue(1,2));
					alert(sheetObject1.GetCellValue(1,3));
					alert(sheetObject1.GetCellValue(1,4));
					alert(sheetObject1.GetCellValue(1,5));
					alert(sheetObject1.GetCellValue(1,6));
										return;
					//conversion of function[check again]CLT 					InitDataValid(0, "pln_yr", vtNumericOnly);
					//conversion of function[check again]CLT 					InitDataValid(0, "pln_mon", vtNumericOnly);
					//conversion of function[check again]CLT 					InitDataValid(0, "pln_wk", vtNumericOnly);
					//conversion of function[check again]CLT 					InitDataValid(0, "wk_st_dt", vtNumericOnly);
					//conversion of function[check again]CLT 					InitDataValid(0, "wk_end_dt", vtNumericOnly);
					sheetObject1.ColValueDupRows("2|4")
					*/
					//Validation
					if(sheetObject1.RowCount()!=null && sheetObject1.RowCount()> 0){
						for(var i=1; i<=sheetObject1.RowCount(); i++){
						var plnYr=sheetObject1.GetCellValue(i,"pln_yr");
						var plnMon=sheetObject1.GetCellValue(i,"pln_mon");
						var plnWk=sheetObject1.GetCellValue(i,"pln_wk");
						var wkStDt=sheetObject1.GetCellValue(i,"wk_st_dt");
						var wkEndDt=sheetObject1.GetCellValue(i,"wk_end_dt");
							if(ComTrim(plnYr)==''){
								ComShowCodeMessage("COM130403","Year" );
								sheetObject1.SetCellValue(i,2,"");
								sheetObject1.SelectCell(i,2, true);
								return;
							}
							if(ComTrim(plnMon)==''){
								ComShowCodeMessage("COM130403","Month" );
								sheetObject1.SetCellValue(i,3,"");
								sheetObject1.SelectCell(i,3, true);
								return;
							}
							if(ComTrim(plnWk)==''){
								ComShowCodeMessage("COM130403","Week" );
								sheetObject1.SetCellValue(i,4,"");
								sheetObject1.SelectCell(i,4, true);
								return;
							}
							if(ComTrim(wkStDt)==''){
								ComShowCodeMessage("COM130403","Week Start Date" );
								sheetObject1.SetCellValue(i,5,"");
								sheetObject1.SelectCell(i,5, true);
								return;
							}
							if(ComTrim(wkEndDt)==''){
								ComShowCodeMessage("COM130403","Week End Date" );
								sheetObject1.SetCellValue(i,6,"");
								sheetObject1.SelectCell(i,6, true);
								return;
							}
							if(!ComIsMonth(plnMon)){
								ComShowCodeMessage("COM132201","Month" );
								//sheetObject1.CellValue(i,3) = "";
								sheetObject1.SelectCell(i,3, true);
								return;
							}
							if(!ComIsWeek(plnWk)){
								ComShowCodeMessage("COM132201","Week" );
								//sheetObject1.CellValue(i,4) = "";
								sheetObject1.SelectCell(i,4, true);
								return;
							}
							if(!ComIsDate(wkStDt, "ymd")){
								ComShowCodeMessage("COM12187","YYYYMMDD" );
								sheetObject1.SetCellValue(i,5,"");
								sheetObject1.SelectCell(i,5, true);
								return;
							}
							if(!ComIsDate(wkEndDt, "ymd")){
								ComShowCodeMessage("COM12187","YYYYMMDD" );
								sheetObject1.SetCellValue(i,6,"");
								sheetObject1.SelectCell(i,6, true);
								return;
							}
							if(wkStDt>wkEndDt){
								ComShowCodeMessage("COM132002");
								sheetObject1.SetCellValue(i,5,"");
								sheetObject1.SetCellValue(i,6,"");
								sheetObject1.SelectCell(i,5, true);
								return;
							}
						}
					}
	        		// in case of same year, week exist, showing error message
	        		var dupRows = sheetObject1.ColValueDupRows("2|4");
	        		var arrRow=dupRows.split(",");
			        if (dupRows != ""){
			        	ComShowCodeMessage("COM12115", "Year : "+sheetObject1.GetCellValue(arrRow[0],2)+", Week :"+sheetObject1.GetCellValue(arrRow[0],4));
		       			 sheetObject1.SelectCell(arrRow[0], 2, true);
		       			 return;				        	
			        } 
			       // return;
			        doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
				case "btn_Add":
					sheetObject1.DataInsert(0);
				break;
				case "btn_retrive":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH); 
				break;
				//Delete Button
				case "btn_Del":
   					if(sheetObject1.FindCheckedRow("del_chk")=="")
   					{
   						ComShowCodeMessage("COM12189");
   					}
   					else if(ComShowCodeConfirm("COM12171")) 
   					{ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
				break;
				case "btn_new":
					sheetObject1.RemoveAll();
					formObject.reset();                 	
				break;
				case "btn_close":
					ComClosePopup(); 
				break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(e.message);
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
     /**
      * initailizing form control
      */
     function initControl() {
         // change
         //axon_event.addListenerForm('change', 'obj_change', frm);
      	 // focus in
         //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);         
     }     
     /**
      * HTML Control Foucs in
      */
     function obj_change(){
     }
     
     function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
 		if (isExceedMaxRow(msg))return;
 	}
     
     
     function obj_deactivate(){
     }
    // ===================================================================================
    // handling event changin on Sheet 
    // ===================================================================================
    /**
     * pur_opt_flg : pur_opt_flg 
     * @param {long} row Row Index
     * @param {long} col Column Index
     * @param {string} value  
     * 
     */
     function sheet1_OnChange(sheet , row , col , value) {

    	 var selrow=sheetObjects[0].GetSelectRow();
    	 var wkStDt = "";
    	 var wkEndDt = "";
    	 wkStDt = sheetObjects[0].GetCellValue(selrow,"wk_st_dt");
    	 wkEndDt = sheetObjects[0].GetCellValue(selrow,"wk_end_dt");
    	 
    	 if(sheetObjects[0].CellSaveName(row, col) == "wk_st_dt" || sheetObjects[0].CellSaveName(row, col) == "wk_end_dt") {
    		 if(sheetObjects[0].GetCellValue(row, "wk_st_dt") != "" && sheetObjects[0].GetCellValue(row, "wk_end_dt") != "") {
	    		 if(sheet_dateDiff(getDateObj(wkStDt), getDateObj(wkEndDt) , "D") != 6) {
	    			 ComShowCodeMessage("EQR01145");
	    			 if(sheetObjects[0].CellSaveName(row, col) == "wk_st_dt") {
	    				 sheetObjects[0].SetCellValue(row, col, ComTrimAll(ComGetDateAdd(wkEndDt, "D", -6), "-"));
	    			 }
	    			 
	    			 if(sheetObjects[0].CellSaveName(row, col) == "wk_end_dt") {
	    				 sheetObjects[0].SetCellValue(row, col, ComTrimAll(ComGetDateAdd(wkStDt, "D", 6), "-"));
	    			 }
	    		 }
    		 }else{
    			 if ( (!isValidDate(sheetObjects[0].GetCellValue(row, "wk_st_dt")) &&  sheetObjects[0].GetCellValue(row, "wk_st_dt") != "")
    					 || (!isValidDate(sheetObjects[0].GetCellValue(row, "wk_end_dt")) &&  sheetObjects[0].GetCellValue(row, "wk_end_dt") != "")) {
    				 ComShowCodeMessage("EQR90222","YYYYMMDD");
    				 sheetObjects[0].SetCellValue(row, col,"");
    			 }
    			 
    			
    		 }
    	 }
    	 
    	 if(sheetObjects[0].CellSaveName(row, col) == "pln_mon") {
    		 if(sheetObjects[0].GetCellValue(row, col) > 12) {
    			 ComShowCodeMessage("EQR90221");
    			 sheetObjects[0].SetCellValue(row, col,"");
    		 }
    	 }
     }
     
     
 	//checking mandatory
 	function sheet1_OnAfterEdit(sheetObj,Row,Col){
 		
 	}
 	/**
 	 * handling click event on sheet <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {ibsheet} row     	selected Row
 	 * @param {ibsheet} col     	selected Col
 	 **/
 	function sheet1_OnClick(sheetObj, row, col) {
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
    	 //setting static variable
    	 frm=document.form;    	  
    	 sheet1=sheetObjects[0];
         for(i=0;i<sheetObjects.length;i++){
	         ComConfigSheet (sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         ComEndConfigSheet(sheetObjects[i]);
         }
         //initailizing form control
         initControl();  
         //doActionIBSheet(sheetObjects[0], document.form, SEARCH09);
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
     }
     
     function sheet1_OnLoadFinish(sheetObj) {
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
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
	               var HeadTitle="||Year|Month|Week|Week Start Date|Week End Date";
	               var prefix="sheet1_";
	
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pln_yr",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pln_mon",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pln_wk",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                      {Type:"Text",      Hidden:0,  Width:235,  Align:"Center",  ColMerge:0,   SaveName:"wk_st_dt",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                      {Type:"Text",      Hidden:0,  Width:235,  Align:"Center",  ColMerge:0,   SaveName:"wk_end_dt",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
	                
	               InitColumns(cols);
	
	               SetEditable(1);
	                     //conversion of function[check again]CLT  					 InitDataValid(0, "pln_yr", vtNumericOnly);
	               SetColProperty(0, "pln_yr", {AcceptKeys:"N"});
	               //conversion of function[check again]CLT  					 InitDataValid(0, "pln_mon", vtNumericOnly);
	               SetColProperty(0, "pln_mon", {AcceptKeys:"N"});
	               //conversion of function[check again]CLT  					 InitDataValid(0, "pln_wk", vtNumericOnly);
	               SetColProperty(0, "pln_wk", {AcceptKeys:"N"});
	               //conversion of function[check again]CLT  					 InitDataValid(0, "wk_st_dt", vtNumericOnly);
	               SetColProperty(0, "wk_st_dt", {AcceptKeys:"N"});
	               //conversion of function[check again]CLT  					 InitDataValid(0, "wk_end_dt", vtNumericOnly);
	               SetColProperty(0, "wk_end_dt", {AcceptKeys:"N"});
	               //SetSheetHeight(448);
	               resizeSheet();
               }
                break;
         }
     }
     // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 var prefix="sheet1_";
         sheetObj.ShowDebugMsg(false);
         var selrow=sheetObj.GetSelectRow();
         switch(sAction) {
            case IBSEARCH:      //retrieve
			   if(sheetObj.id == "sheet1") {
				  sheetObj.SetWaitImageVisible(0);
				  //sheetObj.ColumnSort(0);
				  ComOpenWait(true);				   
				  formObj.f_cmd.value=SEARCHLIST;
 				  sheetObj.DoSearch("EES_EQR_0008GS.do", FormQueryString(formObj) );
				  ComOpenWait(false);
			   }
            break;
 			case IBSAVE:        //saving
				if(validateForm(sheetObj,formObj,sAction)){		
					formObj.f_cmd.value=MULTI;
					//var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true, true, prefix+"ibflag");
					var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true, true);
					//alert(sParam);
					//return;
			        if(confirm(ComGetMsg("COM130101","Data"))) {
	         			ComOpenWait(true);
 	         			var sXml=sheetObj.GetSaveData("EES_EQR_0008GS.do", sParam);
	         			//ComOpenWait(false);
	         			var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	         			ComOpenWait(false);
	         			if(result != "F"){
	         				ComShowCodeMessage("COM130102", "Data");
	         				doActionIBSheet(sheetObj, formObj, IBSEARCH);
	         			}else{
 	         				sheetObj.LoadSaveData(sXml);
//		         				ComShowCodeMessage("COM130103", "Data");
	         			}
	     			}
			        /*
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("EES_EQR_0008GS.do", FormQueryString(formObj));
					ComOpenWait(false);
					//doActionIBSheet(sheetObj,formObj,IBSEARCH);
					*/
				}else{
					ComShowCodeMessage("COM130503");
				}
            break;
 			case IBDELETE:      // removing
	   	   		if (sheetObj.id == 'sheet1') {  
 	   	   		    sheetObj.SelectFontBold=false;
		   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk"); 
						//sheetObj.SelectFontBold = true;
					}
				}    			
			break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 var rCnt=0;
    	 if(sheetObj.RowCount()<=0){
    		return false; 
    	 }else{
    		 for (var idx=1; idx <= sheetObj.RowCount(); idx++){
    			 if(sheetObj.GetCellValue(idx,0)=='R'){
    				rCnt++; 
    			 }
    			 if(sheetObj.GetCellValue(idx,1)=='1'){
    				return true;
    			 }
    		 }
    		 if(rCnt == sheetObj.RowCount()){
    			 return false;
    		 }
    	 }
         return true;
     }  
     
     function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
