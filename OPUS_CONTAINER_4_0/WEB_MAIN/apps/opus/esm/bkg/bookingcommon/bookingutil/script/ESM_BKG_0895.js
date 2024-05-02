/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0753.js
*@FileTitle  : bookingReport
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0895 : business script for esm_bkg_0895
     */
//    function esm_bkg_0895() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
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
            doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
            if (document.form.edit_yn.value == "N"){
            	ComBtnDisable("btn_OK");
    		}
        }
      /**
         * setting sheet initial values and header
         * @param sheetObj
         * @param sheetNo
         * @return
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		switch(sheetObj.id) {
    			case "sheet1":      //sheet1 init
    				with (sheetObj) {
    		       
	    		        var HeadTitle="|Sel.|Seq.|Item Group|Item List";
	    		        var headCount=ComCountHeadTitle(HeadTitle);
	    		        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	    		        var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		        InitHeaders(headers, info);
	
	    		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	    		               {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"check" },
	    		               {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ord_seq" },
	    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sql_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"item_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tbl_nm" },
	    		               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"col_nm" } ];
	    		         
	    		        InitColumns(cols);
	
	    		        SetEditable(1);
	    		        SetSheetHeight(520);

    				}
    				break;
    			case "sheet2":      //sheet2 init
    				with (sheetObj) {
    		        
	    		        var HeadTitle="|Sel.|Seq.||Item Group|Selected List";	    		        
	    		        var headCount=ComCountHeadTitle(HeadTitle);
	    		        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	    		        var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	    		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		        InitHeaders(headers, info);

	    		        var cols = [ {Type:"Status",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	  	    		               {Type:"CheckBox",  Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"check" },
	  	    		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ord_seq" },
	  	    		               {Type:"Seq",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	  	    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sql_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  	    		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"item_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	  	    		               {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tbl_nm" },
	  	    		               {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"col_nm" } ];
	    		        
	    		         
	    		        InitColumns(cols);
	    		        SetEditable(1);
	    		        SetSheetHeight(520);

    				}
    				break;
    			}
    	}
      // Event handler processing by button name */
         function processButtonClick(){
              /***** using extra sheet valuable if there are more 2 sheets *****/
              var sheetObject1=sheetObjects[0];
              var sheetObject2=sheetObjects[1];
              /*******************************************************/
              var formObject=document.form;
         	try {
         		var srcName=ComGetEvent("name");
         		if(ComGetBtnDisable(srcName)) return false;
     			switch(srcName) {
     				case "btns_add":
     					addDelRow("add");
     					break;
     				case "btns_del":
     					addDelRow("del");
     					break;
     				case "btns_up":
     					rowUpDown(sheetObject2, "UP");
     					break;
     				case "btns_down":
     					rowUpDown(sheetObject2, "DOWN");
     					break;
     				case "btn_OK":
     					returnValue();
	 					opener.setSearchSaveOption();
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
      // handling sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
              	case IBSEARCH:      //retrieve	
    	          	if(!validateForm(sheetObj,formObj,sAction)) return;
	              	formObj.f_cmd.value=SEARCH;   
					sheetObj.SetWaitImageVisible(0);
 					ComOpenWait(true);
 					var resultXml=sheetObj.GetSearchData("ESM_BKG_0895GS.do", FormQueryString(formObj));
					var arrXml=resultXml.split("|$$|"); 	
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
					ComOpenWait(false);
                    break;
    	 		case IBSAVE:        
    	          	if(validateForm(sheetObj,formObj,sAction)) alert (" Save .. ");
                    break;
    			case IBINSERT:      
                    break;
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            }
            return true;
        }
            /**
             * ok event
             */
        function returnValue(){
            var reValue='';	 
        	for (var i=1 ; i < sheetObjects[1].RowCount()+1 ; i++){
        		//if (sheetObjects[1].CellValue(i,0) == '1'){
        		reValue=reValue + "|" + sheetObjects[1].GetCellValue(i,"tbl_nm") + ">" + sheetObjects[1].GetCellValue(i,"col_nm");
   			    //}
        	}
        	opener.setTemplate(reValue);
        	ComClosePopup(); 
        }
            /**
             * row add/delete
             */    
            function addDelRow(type){
            	var hiddenRow = "";
            	 
          	   	if (type == "add"){
	          	   for (var i=1 ; i < sheetObjects[0].RowCount()+1 ; i++){
	          		   if (sheetObjects[0].GetCellValue(i,"check") == '1'){
	      				   var chkValue=true;
	      				   for (var j=1 ; j < sheetObjects[1].RowCount()+1 ; j++){
	      					   if (sheetObjects[0].GetCellValue(i,"tbl_nm") == sheetObjects[1].GetCellValue(j,"tbl_nm") &&
	      							   sheetObjects[0].GetCellValue(i,"col_nm") == sheetObjects[1].GetCellValue(j,"col_nm")){
	      						   chkValue=false;
	      						   break;
	      					   }
	      				   }
	      				   if (chkValue){
	  	    				   var row=sheetObjects[1].DataInsert(-1);
	  	    				   		sheetObjects[1].SetCellValue(row,"ord_seq",sheetObjects[0].GetCellValue(i,"ord_seq"),0);
									sheetObjects[1].SetCellValue(row,"sql_ctnt",sheetObjects[0].GetCellValue(i,"sql_ctnt"),0);
									sheetObjects[1].SetCellValue(row,"item_nm",sheetObjects[0].GetCellValue(i,"item_nm"),0);
									sheetObjects[1].SetCellValue(row,"tbl_nm",sheetObjects[0].GetCellValue(i,"tbl_nm"),0);
									sheetObjects[1].SetCellValue(row,"col_nm",sheetObjects[0].GetCellValue(i,"col_nm"),0);
									
									
									sheetObjects[0].SetCellValue(i,"check", 0);
									
									if (hiddenRow == "") {
		         	    				hiddenRow = i;
		         	    			 } else {
		         	    				hiddenRow = hiddenRow + "|" + i;
		         	    			 }
									
	      				   }else{
	      					   alert("exist same data");
	      				   }
	      			   }
	      		   }
	          	   
         	      if (hiddenRow != "") {
         	    	  sheetObjects[0].SetRowHidden(hiddenRow, 1);
         	      }
	          	   
          	   }else{
          		 var delRow = "";
          		   
          		 for (var i=1 ; i < sheetObjects[1].RowCount()+1 ; i++){
	          		   if (sheetObjects[1].GetCellValue(i,"check") == '1'){
	          			   var seqVal = sheetObjects[1].GetCellValue(i, "ord_seq");
	          			   
	          			   for (var j=1 ; j < sheetObjects[0].RowCount()+1 ; j++){
	          				   if (sheetObjects[0].GetCellValue(j,"ord_seq") == seqVal) {
	          					   if (hiddenRow == "") {
	          						   hiddenRow = j;
	          						   delRow = i;
	          					   } else {
	          						   hiddenRow = hiddenRow + "|" + j;
	          						   delRow = delRow + "|" + i;
	          					   }
	          				   }
	          			   }
          			   }
          	     	}
          		 
          		 	if (hiddenRow != "") {
          		 		sheetObjects[0].SetRowHidden(hiddenRow, 0);
          		 	}
          		 	
          		 	if (delRow != "") {
          		 		sheetObjects[1].RowDelete(delRow,false);
          		 	}
          	   }
           }
          /**
           * row UP/DOWN
           */
           function rowUpDown(sheetObj, type){
        	   Row=sheetObj.GetSelectRow();
        	   if (sheetObj.RowCount()> 0){
        		   if (type == 'UP'){
        			   if (Row > 1){
							var tempUPCheck=sheetObj.GetCellValue(Row-1,"check");
							var tempUPOrdSeq=sheetObj.GetCellValue(Row-1,"ord_seq");
							var tempUPCtnt=sheetObj.GetCellValue(Row-1,"sql_ctnt");
							var tempUPItem=sheetObj.GetCellValue(Row-1,"item_nm");
							var tempUPTbl=sheetObj.GetCellValue(Row-1,"tbl_nm");
							var tempUPCol=sheetObj.GetCellValue(Row-1,"col_nm");
							var tempNowCheck=sheetObj.GetCellValue(Row,"check");
							var tempNowOrdSeq=sheetObj.GetCellValue(Row,"ord_seq");
							var tempNowCtnt=sheetObj.GetCellValue(Row,"sql_ctnt");
							var tempNowItem=sheetObj.GetCellValue(Row,"item_nm");
							var tempNowTbl=sheetObj.GetCellValue(Row,"tbl_nm");
							var tempNowCol=sheetObj.GetCellValue(Row,"col_nm");
        				   sheetObj.SetCellValue(Row-1,"check",tempNowCheck);
        				   sheetObj.SetCellValue(Row-1,"sql_ctnt",tempNowCtnt);
        				   sheetObj.SetCellValue(Row-1,"ord_seq",tempNowOrdSeq);
        				   sheetObj.SetCellValue(Row-1,"item_nm",tempNowItem);
        				   sheetObj.SetCellValue(Row-1,"tbl_nm",tempNowTbl);
        				   sheetObj.SetCellValue(Row-1,"col_nm",tempNowCol);
        				   
        				   sheetObj.SetCellValue(Row,"check",tempUPCheck);
        				   sheetObj.SetCellValue(Row,"sql_ctnt",tempUPCtnt);
        				   sheetObj.SetCellValue(Row,"ord_seq",tempUPOrdSeq);
        				   sheetObj.SetCellValue(Row,"item_nm",tempUPItem);
        				   sheetObj.SetCellValue(Row,"tbl_nm",tempUPTbl);
        				   sheetObj.SetCellValue(Row,"col_nm",tempUPCol);
        				   sheetObj.SelectCell(Row-1, 1);
        			   }
        		   }else{
        			   if (Row < sheetObj.RowCount()){
							var tempDWCheck=sheetObj.GetCellValue(Row+1,"check");
							var tempDWOrdSeq=sheetObj.GetCellValue(Row+1,"ord_seq");
							var tempDWCtnt=sheetObj.GetCellValue(Row+1,"sql_ctnt");
							var tempDWItem=sheetObj.GetCellValue(Row+1,"item_nm");
							var tempDWTbl=sheetObj.GetCellValue(Row+1,"tbl_nm");
							var tempDWCol=sheetObj.GetCellValue(Row+1,"col_nm");
							var tempNowCheck=sheetObj.GetCellValue(Row,"check");
							var tempNowOrdSeq=sheetObj.GetCellValue(Row,"ord_seq");
							var tempNowCtnt=sheetObj.GetCellValue(Row,"sql_ctnt");
							var tempNowItem=sheetObj.GetCellValue(Row,"item_nm");
							var tempNowTbl=sheetObj.GetCellValue(Row,"tbl_nm");
							var tempNowCol=sheetObj.GetCellValue(Row,"col_nm");
        				   sheetObj.SetCellValue(Row+1,"check",tempNowCheck);
        				   sheetObj.SetCellValue(Row+1,"ord_seq",tempNowOrdSeq);
        				   sheetObj.SetCellValue(Row+1,"sql_ctnt",tempNowCtnt);
        				   sheetObj.SetCellValue(Row+1,"item_nm",tempNowItem);
        				   sheetObj.SetCellValue(Row+1,"tbl_nm",tempNowTbl);
        				   sheetObj.SetCellValue(Row+1,"col_nm",tempNowCol);

        				   sheetObj.SetCellValue(Row,"check",tempDWCheck);
        				   sheetObj.SetCellValue(Row,"ord_seq",tempDWOrdSeq);
        				   sheetObj.SetCellValue(Row,"sql_ctnt",tempDWCtnt);
        				   sheetObj.SetCellValue(Row,"item_nm",tempDWItem);
        				   sheetObj.SetCellValue(Row,"tbl_nm",tempDWTbl);
        				   sheetObj.SetCellValue(Row,"col_nm",tempDWCol);
        				   sheetObj.SelectCell(Row+1, 1);
        			   }
        		   }
        	   }
           }

           /*
            * after searching if Type is Common and Shared, Editable = false; 
            */ 
           function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        	   var seqVal = "";
        	   var hiddenRow = "";

        	   if(sheetObj.RowCount()> 1){
	               with (sheetObj) {
	         	       for (var i=1; i < sheetObj.RowCount()+1 ; i++) {
	         	    	  seqVal = sheetObj.GetCellValue(i, "ord_seq");
	         	    	 
	         	    	  for (var j=1 ; j < sheetObjects[0].RowCount()+1 ; j++){
	         	    		 if (sheetObjects[0].GetCellValue(j,"ord_seq") == seqVal) {
	         	    			 if (hiddenRow == "") {
	         	    				hiddenRow = j;
	         	    			 } else {
	         	    				hiddenRow = hiddenRow + "|" + j;
	         	    			 }
	         	    		 }
	  	      			  }
	  	      		   }
	         	    
	         	       
	         	      if (hiddenRow != "") {
	         	    	  sheetObjects[0].SetRowHidden(hiddenRow, 1);
	         	      }
	               }
        	   } 
           }           