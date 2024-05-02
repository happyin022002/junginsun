/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_mst_0001.js
*@FileTitle  : Equipment Status Code Creation, Update & Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // common static variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var std_ofc_cd="";
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 	 /**
 	  * Event handler processing by button name
 	  */
     function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	/*******************************************************/
    	var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) 
             {
				case "btn_downexcel":
 					if(sheetObject1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheet1), HiddenColumn:-1,Merge:true,TreeLevel:false});
 					}
				break;
				case "btn_save":
					// checking. : There is no contents to save.
					if(sheetObject1.IsDataModified()== false && sheetObject2.IsDataModified()== false)
					{
						ComShowCodeMessage("MST00012");
						return;
					}
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				case "btn_add":
   					doActionIBSheet(sheetObject1,formObject,IBINSERT);
				break;
				case "btn_delete":
   					if(sheetObject1.FindCheckedRow("Sel")=="")
   					{
   						ComShowCodeMessage("MST00010");
   					}
   					else if(ComShowCodeConfirm("MST00005")) 
   					{ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
				break;
				case "btn_add2":
					if(ComIsEmpty(formObject.cntr_sts_cd)) {
						ComShowCodeMessage("MST01017");
					} else {
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
				break;
				case "btn_delete2":
   					if(sheetObject2.FindCheckedRow("Sel")=="")
   					{
   						ComShowCodeMessage("MST00010");
   					}
   					else if(ComShowCodeConfirm("MST00005")) 
   					{ 
   						doActionIBSheet(sheetObject2,formObject,IBDELETE);
   					}
				break;							
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("MST00011",srcName+" Button Fail.");
     		} else {
     			ComShowCodeMessage("MST00011",e);
     		}
     	}
     }
     
     function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	     var formObject = document.form;
         if (ErrMsg == "") {
        	 doActionIBSheet(sheetObj,formObject,IBSEARCH);
         } 
	  }
     
     
     /**
      * registering IBsheet Object as list
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
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++)
         {
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         sheet1_OnLoadFinish(sheet1);
     }
     
     function sheet1_OnLoadFinish(sheetObj) 
     {
    	 sheetObj.SetWaitImageVisible(0);
    	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   		 // show cntr_sts_cd about first optional
    	 var	 cntr_sts_cd=sheetObjects[0].GetCellValue(1, "cntr_sts_cd");
    	 document.form.cntr_sts_cd.value=cntr_sts_cd;
    	 SheetFiltering(1,cntr_sts_cd,"cntr_sts_cd");
    	 sheetObj.SetWaitImageVisible(1);
     }
 	
     /* ********* User Functions ************* */	
     /** 
 	 * in case of click event, filtering eachsheet
 	 * @param	{Number}	sheetIdx		
 	 * @param 	{String}  	keyValue
 	 * @param 	{Form}  	foreginKey 
 	 */ 
 	 function SheetFiltering(sheetIdx,keyValue,foreginKey){ 
 		 for (var idx=1; idx <= sheetObjects[sheetIdx].RowCount(); idx++){
 			 if(sheetObjects[sheetIdx].GetCellValue(idx,foreginKey) == keyValue &&
 					 sheetObjects[sheetIdx].GetRowStatus(idx) != "D"){
 				 sheetObjects[sheetIdx].SetRowHidden(idx,0);
 			 } else {    
 				 if(sheetObjects[sheetIdx].GetRowHidden(idx) != 1){
 					 sheetObjects[sheetIdx].SetRowHidden(idx,1);
 				 }
 			 }     
 		 } 	 	    				  
 	 }
 	 
	/** 
	 * removing all code that preStsCd is empty
	 */
	function deleteInvalidCd()
	{
    	var cur_pre_sts_code="";			// current preStsCd
    	for(var i=1; i<=sheetObjects[1].RowCount(); i++)
		{
    		cur_pre_sts_code=sheetObjects[1].GetCellValue(i,"cntr_pre_sts_cd");
    		if(ComIsEmpty(ComTrim(cur_pre_sts_code)))
    		{
    			sheetObjects[1].SetCellValue(i,"Sel","Y");
    		}
		}
	}
	
 	/**
 	 * show column that preStsCd is empty
 	 */
    function findEmptyPreStsCd()
    {
    	var cur_sts_code="";				// current stsCd
    	var sel_sts_code="";				// optional된 stsCd
    	var cur_pre_sts_code="";			// current preStsCd
    	// searching column that preStsCd is empty
    	for(var i=1; i<=sheetObjects[1].RowCount(); i++)
    	{
    		cur_sts_code=sheetObjects[1].GetCellValue(i,"cntr_sts_cd");
    		cur_pre_sts_code=sheetObjects[1].GetCellValue(i,"cntr_pre_sts_cd");
    		if(ComIsEmpty(ComTrim(cur_pre_sts_code)))
    		{
    			for(var k=1; k<sheetObjects[0].RowCount(); k++)
    			{
    				sel_sts_code=sheetObjects[0].GetCellValue(k,"cntr_sts_cd");
    				// in case of stsCd that preStsCd is empty, sts_cd is optional and show preStsCd
    				if(sel_sts_code == cur_sts_code)
    				{
    					sheetObjects[0].SelectCell(k, 3, true);
    					document.form.cntr_sts_cd.value=cur_sts_code;
    					SheetFiltering(1,cur_sts_code,"cntr_sts_cd");
    					sheetObjects[1].SelectCell(i, 2, true);
    					return;
    				}
    			}
    			return;
    		}
    	}
    	return;
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
            	 with(sheetObj)
                 {
	               var HeadTitle="||Seq.|Code|Description";
	
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
	                      {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                      {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"cntr_sts_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 } ];
	                
	               InitColumns(cols);
	
	               SetEditable(1);
	               SetColProperty(0 ,"cntr_sts_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	               SetColProperty(0 ,"cntr_sts_nm" , {AcceptKeys:"E|N|[- ]" , InputCaseSensitive:1});
	               SetSheetHeight(510);
	               //resizeSheet();
               }


                 break;
             case 2:      //sheet2 init
         	    with(sheetObj)
               {
	               var HeadTitle="||Pre Status";
	
	               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1, VScrollMode:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
	                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cntr_pre_sts_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                      {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 } ];
	                
	               InitColumns(cols);
	
	               SetEditable(1);
	               SetCountPosition(0);
	               SetColProperty(0 ,"cntr_pre_sts_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	               SetSheetHeight(510);
	              // resizeSheet();
               }


                 break;
         }
     }
     
      /**
      * handling process for sheet
      */
     function doActionIBSheet(sheetObj,formObj,sAction) 
     {
    	  sheetObj.ShowDebugMsg(false);
         // current optional row.
         var selrow=sheetObj.GetSelectRow();
         switch(sAction) 
         {
            case IBSEARCH:      //retrieve
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;
             	var sXml=sheetObj.GetSearchData("EES_MST_0001GS.do", FormQueryString(formObj));
            	var arrXml=sXml.split("|$$|");
            	if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
            	if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
            	ComOpenWait(false);
            break;
			case IBSAVE:        //save
	            sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=MULTI;
				var sparam="";
				var sParam1=sheetObjects[0].GetSaveString();
				if (sheetObjects[0].IsDataModified()&& sParam1 == "") return;
				
				var sParam2=sheetObjects[1].GetSaveString();
				if (sheetObjects[1].IsDataModified()&& sParam2 == "")
				{
					findEmptyPreStsCd(sheetObjects[1]);
					return;
				}
				
				if(sheetObjects[0].IsDataModified()== true)
				{
					sparam=sParam1 + "&";
				}
				
				if(sheetObjects[1].IsDataModified()== true)
				{
					// attaching prefix for seperate data
					sParam2=ComSetPrifix(sParam2,"sub");
					sparam=sparam + sParam2 + "&";
				}
				
				sparam=sparam + FormQueryString(formObj);
				if(validateForm(sheetObjects[0],formObj,sAction)){
					ComOpenWait(true);
 					var sXml=sheetObj.GetSaveData("EES_MST_0001GS.do", sparam);
					if(sheetObjects[0].IsDataModified()== true){
 						sheetObjects[0].LoadSaveData(sXml);
					}else{
 						sheetObjects[1].LoadSaveData(sXml);
					}
					ComOpenWait(false);
				}
			break;
			case IBINSERT:      // inserting : after current optional column
   				if ( selrow > 0 )
   				{
   					sheetObj.DataInsert(selrow);
   					// inserting first data, rowcount initailizing.
					if(sheetObj.RowCount()==1) {
						selrow=0;
					}
   					if(sheetObj.id == "sheet1") {
   						sheetObj.SelectCell(selrow+1, 3, true);
   					} else if(sheetObj.id == "sheet2") {
   						// cntr_sts_cd
   						sheetObj.SetCellText(selrow, 3,document.form.cntr_sts_cd.value);
   						sheetObj.SelectCell(selrow, 2, true);
   					}
   				}
   				else
   				{
   					sheetObj.DataInsert(-1);
   				}
   			break;
   		 	case IBDELETE: // removing
   		 		ComRowHideDelete(sheetObj, "Sel");
   		 		var nextrow=selrow + 1;
   		 		var bFind=false;
   		 		if(sheetObj.id == "sheet1")
   		 		{
   		 			if(sheetObj.GetRowStatus(selrow) == "D")
	   		 		{
	   		 			// in case of checked row != last row, find next row
	   		 			if(selrow != sheetObj.RowCount())
	   		 			{
		   		 			while(nextrow <= sheetObj.RowCount())
		   		 			{
		   		 				// in case of row status != delete
		   		 				if(sheetObj.GetRowStatus(nextrow) != "D")
		   		 				{
		   		 					bFind=true;
		   		 					break;
		   		 				}
		   		 				nextrow++;
		   		 			}
	   		 			}
	   		 			// in case of current row is last row, find before row
	   		 			if(bFind == false)
	   		 			{
	   		 				nextrow=selrow - 1;
		   		 			while(nextrow > 0)
		   		 			{
		   		 				if(sheetObj.GetRowStatus(nextrow) != "D")
		   		 				{
		   		 					break;
		   		 				}
		   		 				nextrow--;
		   		 			}
	   		 			}
	   		 		}
	   		 		else
	   		 		{
	   		 			nextrow--;		// current row
	   		 		}
	   		 		sheetObj.SelectCell(nextrow, 3, true);
	   		 		// in case of preStsCd is null, removing all codes
	   		 		deleteInvalidCd();
	   		 		var cntr_sts_cd=sheetObj.GetCellValue(nextrow, "cntr_sts_cd");
	   	            document.form.cntr_sts_cd.value=cntr_sts_cd;
	   	            SheetFiltering(1,cntr_sts_cd,"cntr_sts_cd");
   		 		}
	 		break;
	   		case IBSEARCH_ASYNC01:      // retrieve Officd Code 
				if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "MST", strOfcCd) ) {	
					div_ofc1.style.display="none";
					div_ofc2.style.display="none";
					$('#btn_save').hide();
				}else{
					div_ofc1.style.display="";
					div_ofc2.style.display="";
					$('#btn_save').show();
				}
			break;
         }
     }
     
     /**
      *  handling double click event onsheet1
      */
     function sheet1_OnDblClick(sheetObj, row, col, value) 
     {
    	 var cntr_sts_cd=sheetObj.GetCellValue(row, "cntr_sts_cd");
    	// in case of click null, error message 
		if(ComIsEmpty(cntr_sts_cd)) {
			ComShowCodeMessage("MST01017");
			sheetObj.SelectCell(row, 3, true);
			return;
		}
		
        // inserting SSC code
        document.form.cntr_sts_cd.value=cntr_sts_cd;
		SheetFiltering(1,cntr_sts_cd,"cntr_sts_cd");
		// changing status to checked
		for (var idx=1; idx <= sheetObjects[1].RowCount(); idx++){
			if(sheetObjects[1].GetRowHidden(idx) == false){
				sheetObjects[1].SelectCell(idx, 2, false);
				return;
			}     
		} 	 	    				  
     }
     
     /**
      * checking stsCd
      * @param sheetObj
      * @param row
      * @param col
      * @param value
      * @return
      */
     function sheet1_OnChange(sheetObj, row, col, value)
     {
		if(sheetObj.ColSaveName(col) == "cntr_sts_cd")
		{
             if(value.length != 3 && value.length != 0) 
             {
                 // error message : Please check up the CODE.
                 ComShowCodeMessage("MST01017");
                 sheetObj.SetCellValue(row,"cntr_sts_cd","");
                 sheetObj.SelectCell(row, 3, true);
                 return;
             }
             var cur_code="";
             var sel_code=sheetObj.GetCellValue(row,"cntr_sts_cd");
             //  checking duplication onsheet
             for(var i=1; i<=sheetObj.RowCount(); i++)
             {
            	 if(i != row)		
            	 {
            		 cur_code=sheetObj.GetCellValue(i,"cntr_sts_cd");
            		 if(sel_code == cur_code)
            		 {
            			 // error message : Data is duplicated, Please check data again.
            			 ComShowCodeMessage("MST00002",cur_code);
            			 sheetObj.SetCellValue(row,"cntr_sts_cd","");
            			 sheetObj.SelectCell(row, 2, true);
            			 return;
            		 }
            	 }
             }		// End for
		}
     }
     
     /**
     * checking preStsCd
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     * @return
     */
     function sheet2_OnChange(sheetObj, row, col, value)
     {
    	 if(sheetObj.ColSaveName(col) == "cntr_pre_sts_cd")
    	 {
    		 if(value.length != 3 && value.length != 0) 
    		 {
    			 // error message : Please check up the CODE.
                 ComShowCodeMessage("MST01017");
                 sheetObj.SetCellValue(row,"cntr_pre_sts_cd","");
                 sheetObj.SelectCell(row, 2, true);
                 return;
             }
             var cur_code="";
             var sel_code=sheetObj.GetCellValue(row,"cntr_pre_sts_cd");
             //  checking duplication onsheet
             for(var i=1; i<= sheetObj.RowCount(); i++)
             {
            	 if(sheetObj.GetRowHidden(i)==false && i != row)		// in case of not hidden & not itself, checking duplication
            	 {
            		 cur_code=sheetObj.GetCellValue(i,"cntr_pre_sts_cd");
            		 if(sel_code == cur_code)
            		 {
            			 // error message : Data is duplicated, Please check data again.
            			 ComShowCodeMessage("MST00002",cur_code);
            			 sheetObj.SetCellValue(row,"cntr_pre_sts_cd","");
            			 sheetObj.SelectCell(row, 2, true);
            			 return;
            		 }
            	 }
             }		// End for
    	 }
     }
     
  	 /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
     		 switch(sAction) {
     		 	case IBSAVE:
     		 	 		var total=sheetObj.GetTotalRows()+1;
     		 	 		var checkCount=0;
     		 	 		for (var i=0 ; i < total ; i++){
     		 	 			if (sheetObj.GetCellValue(i  ,"cntr_sts_nm").trim().length == 0){
     		 	 				checkCount ++;
     						}
     		 	 		}
     		 	 		if (checkCount > 0){
     		 	 			ComShowCodeMessage("MST00001", "Description");
     						return false;
     					}
 	        		   break;
 			 }
 		  }
 		  return true;
 	 }
     
     
     function resizeSheet(){
       ComResizeSheet(sheetObjects[0]);
       ComResizeSheet(sheetObjects[1]);
     }
