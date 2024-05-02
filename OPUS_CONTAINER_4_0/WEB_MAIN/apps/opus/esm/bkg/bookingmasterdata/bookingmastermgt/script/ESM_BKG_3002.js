/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_3002.js
*@FileTitle  : BL Group Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	var sheetObjects=new Array();
    var sheetCnt=0;
	var prefix1="sheet1_";
	var prefix2="sheet2_";
    
    var dblClickStatus=0;
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** using extra sheet valuable if there are more 2 sheets *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var sheetObject3=sheetObjects[2];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
   			case "btn_retrieve":
   				
   				var SaveStr1 = sheetObjects[0].GetSaveString(0);
				var SaveStr2 = sheetObjects[1].GetSaveString(0);
				if(SaveStr1 != "" || SaveStr2 != "" ){
					if(ComShowCodeConfirm('BKG00254')){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					}
				}
   				
   				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   				break;
   			case "btn_save":
   				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
   			case "btn_RowAdd1":
   				var SaveStr = sheetObjects[1].GetSaveString(0);
				if(SaveStr != ""){
					if(ComShowCodeConfirm('BKG00254')){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					}
				}
   				
				addRow(sheetObjects[0]);
				break;
			case "btn_RowDel1":
//				var sRow = sheetObjects[0].FindCheckedRow("chk");
//				sheetObjects[0].SetRowHidden(sRow, 1);
				deleteRow(sheetObjects[0]);
				break;
			case "btn_RowAdd2":
				if(dblClickStatus == 1){
					addRow(sheetObjects[1]);
				}else if (dblClickStatus != 1){
					ComShowMessage("This Row Add Button is available only when you did double click parents table's Row.");
   				}
				break;
			case "btn_RowDel2":
//				var sRow = sheetObjects[1].FindCheckedRow("chk");
//				sheetObjects[1].SetRowHidden(sRow, 1);
				
				deleteRow(sheetObjects[1]);
				break;
			case "btn_new":

				var SaveStr1 = sheetObjects[0].GetSaveString(0);
				var SaveStr2 = sheetObjects[1].GetSaveString(0);
				if(SaveStr1 != "" || SaveStr2 != "" ){
					if(ComShowCodeConfirm('BKG00254')){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					}
				}
				
				initControl();
				break;
			case "cust_pop":
				ComOpenPopup('COM_ENS_041.do', 770, 470, "callBackCustCd", "1,0,1,1,1,1,1", true);
				break;
				
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
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
    	initControl();
    }
    function initControl() {
    	var formObj = document.form;
   	 
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		formObj.bl_grp_seq.value = "";
		formObj.bl_grp_nm.value = "";
		formObj.bl_grp_desc.value = "";
    	 
		formObj.cust_cnt_cd.value = "";
		formObj.cust_seq.value = "";
		
		ComBtnEnable("btn_RowAdd1");
		ComBtnEnable("btn_RowDel1");
		ComBtnDisable("btn_RowAdd2");
		ComBtnDisable("btn_RowDel2");
    }
    /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
            	with(sheetObj){                
                
                	var HeadTitle = "|Sel.|Seq|row_idx|bl_grp_seq|BL Group Name|Description|Create DT|Create User|Update DT|Update User";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:1,   SaveName:prefix1+"ibflag" },
			                     {Type:"DummyCheck",Hidden:0, Width:30,   Align:"Center",  	ColMerge:1,   SaveName:prefix1+"chk" },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  	ColMerge:1,   SaveName:prefix1+"seq" },
			                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  	ColMerge:1,   SaveName:prefix1+"row_idx" },
			                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  	ColMerge:1,   SaveName:prefix1+"bl_grp_seq"},
			                     {Type:"Text",      Hidden:0, Width:200,  Align:"left",  	ColMerge:1,   SaveName:prefix1+"bl_grp_nm",		KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200, InputCaseSensitive:1 },
			                     {Type:"Text",      Hidden:0, Width:540,  Align:"left",   	ColMerge:1,   SaveName:prefix1+"bl_grp_desc",	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:prefix1+"cre_dt", Format:"Ymd", UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:prefix1+"cre_usr_id", UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:prefix1+"upd_dt", Format:"Ymd", UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:prefix1+"upd_usr_id", UpdateEdit:0,   InsertEdit:0}
			                     ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetWaitImageVisible(0);                
	                SetAutoRowHeight(0);
	                SetDataRowHeight(22);
	                SetSheetHeight(185);
                
                }
            break;
            case 2:      // sheet2 init
                with(sheetObj){	                
            		//no support[check again]CLT 	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            		var HeadTitle = "|Sel.|Seq|row_idx|bl_grp_seq|old_cust_cnt_cd|cust_cnt_cd|cust_seq|Customer Code|Company|Create DT|Create User|Update DT|Update User";
	            	var headCount=ComCountHeadTitle(HeadTitle);
		
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
		
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:1,   SaveName:prefix2+"ibflag" },
			                     {Type:"DummyCheck",	Hidden:0, Width:40,   Align:"Center",  	ColMerge:1,   SaveName:prefix2+"chk" },
			                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  	ColMerge:1,   SaveName:prefix2+"seq" },
		                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  	ColMerge:1,   SaveName:prefix2+"row_idx" },
			                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  	ColMerge:1,   SaveName:prefix2+"bl_grp_seq"},
			                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  	ColMerge:1,   SaveName:prefix2+"old_cust_cd"},
			                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  	ColMerge:1,   SaveName:prefix2+"cust_cnt_cd"},
			                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  	ColMerge:1,   SaveName:prefix2+"cust_seq"},
			                     {Type:"Popup",     Hidden:0, Width:200,  Align:"Center",  	ColMerge:1,   SaveName:prefix2+"cust_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
			                     {Type:"Text",      Hidden:0, Width:540,  Align:"left",  	ColMerge:1,   SaveName:prefix2+"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:prefix2+"cre_dt", Format:"Ymd", UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:prefix2+"cre_usr_id", UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:prefix2+"upd_dt", Format:"Ymd", UpdateEdit:0,   InsertEdit:0},
			                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",   ColMerge:1,   SaveName:prefix2+"upd_usr_id", UpdateEdit:0,   InsertEdit:0}
			                     ];
		               
	            	InitColumns(cols);
		
	            	SetEditable(1);
	            	SetWaitImageVisible(0);	              
	            	SetAutoRowHeight(0);
	            	SetDataRowHeight(22);
	            	SetSheetHeight(170);
              	}


                break;
            
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var aryPrefix=new Array(prefix1, prefix2);
        switch(sAction) {
           case IBSEARCH:
        	   
				ComOpenWait(true);
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.bl_grp_seq.value = "";
				formObj.f_cmd.value=SEARCH;
				var sParam = FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix1);
 				sheetObj.DoSearch("ESM_BKG_3002GS.do",sParam );

				ComOpenWait(false);
				break;
			case SEARCH01:
				formObj.f_cmd.value=SEARCH01;
				ComOpenWait(true);
				var sParam = FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix2);
				sheetObj.DoSearch("ESM_BKG_3002GS.do",sParam );
				ComOpenWait(false);
				dblClickStatus = 1;
	            break;
			case IBSAVE:

				if(!validateForm(sheetObj,formObj,sAction)) {
		            return;
		        }
				
        	   sheetObj.WaitImageVisible=false;
        	   ComOpenWait(true);
        	   
        	   formObj.f_cmd.value = MULTI;
        	   var sParam=ComGetSaveString(sheetObjects, true, true);
        	   if (sParam == "")
        		   return false;
        	   sParam += "&" + FormQueryString(formObj); // hidden param value
        	   sParam += "&" + ComGetPrefixParam(aryPrefix);
        	   
        	   var sXml = sheetObj.GetSaveData("ESM_BKG_3002GS.do", sParam);
        	   ComOpenWait(false);	
        	   if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
        		   ComShowCodeMessage('BKG00102');
            	   doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        	   } else { 
        		   ComShowMessage(ComResultMessage(sXml));
        	   }
        	   break;
				
           case IBDELETE:
        	   
        	   if(sheetObj.id == "sheet1"){
            	   formObj.f_cmd.value = REMOVE;
        	   }else if(sheetObj.id == "sheet2"){
            	   formObj.f_cmd.value = REMOVE01;
        	   }
        	   
        	   
    		   if(!ComShowCodeConfirm('BKG00535'))	return;
    		   
        	   sheetObj.WaitImageVisible=false;
        	   ComOpenWait(true);
        	   var sParam1 = sheetObj.GetSaveString(0); 

        	   var sParam = FormQueryString(formObj) + "&" + ComSetPrifix(sParam1, "sheet1_");
        	   sheetObj.GetSaveData("ESM_BKG_3002GS.do", sParam);
        	   ComOpenWait(false);	
        	   
        	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        	   
        	   break;
        }
    }

//    function searchDetailSheet(sheetObj){
//        var formObj = document.form;
//    	
//    	if(sheetObj.RowCount() > 0){
//    		formObj.bl_grp_seq.value = sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix1+"bl_grp_seq");
//            ComBtnEnable("btn_RowAdd2");
//            ComBtnEnable("btn_RowDel2");
//
//    	}else{
//    		formObj.bl_grp_seq.value = "";
//            ComBtnDisable("btn_RowAdd2");
//            ComBtnDisable("btn_RowDel2");
//    	}
//    	doActionIBSheet(sheetObjects[1],formObj,SEARCH01);
//    	doActionIBSheet(sheetObjects[2],formObj,SEARCH02);
//    }

     /**
      * add Row of sheet1 and sheet2
      * @param SheetObj
      * @param sheetNo
      */ 
    function addRow(sheetObj) {
    	var formObj=document.form;
    	switch(sheetObj.id) {
	    	case "sheet1" :
	    		with (sheetObjects[0]) {
	    			var nowRow=GetSelectRow();
	    			nowRow=DataInsert(-1);
	    			sheetObj.SetCellValue(nowRow, prefix1+"row_idx", nowRow);
	    	  	}
    	  		if(sheetObjects[0].RowCount() > 0){
    	            ComBtnEnable("btn_RowAdd2");
    	            ComBtnEnable("btn_RowDel2");
    	    	}
    	    	//Detail 행 삭제
				sheetObjects[1].RemoveAll();
				
				formObj.f_cmd.value = SEARCH02;
				var sParam = FormQueryString(formObj)
				var sXml = sheetObj.GetSearchData("ESM_BKG_3002GS.do", sParam);
				var bl_grp_seq = ComGetEtcData(sXml,"bl_grp_seq")
				sheetObj.SetCellValue(nowRow, prefix1+"bl_grp_seq", bl_grp_seq);
				formObj.bl_grp_seq.value = bl_grp_seq;    	  		
	    	  		
			break;
	    	case "sheet2" :
	    		with (sheetObjects[1]) {
	    			var nowRow = sheetObjects[1].DataInsert(-1);
	    			sheetObjects[1].SetCellValue(nowRow, prefix2+"bl_grp_seq", sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefix1+"bl_grp_seq"));
//	    			if(sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) == "I"){
//	    				SetCellValue(nowRow, "row_idx", sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "row_idx"));
//	    			}else{
//	    			}
	    		}
	        break;
        
       }
    }
    /**
     * delete Row of sheet1 and sheet2
     * @param SheetObj
     * @param sheetNo
     */  
    function deleteRow(sheetObj) {    	 
     	var isRetreive	= false;
    	var formObj 	= document.form;

    	 
     	switch(sheetObj.id){
	     	case "sheet1" : 
	     		var sRow = sheetObj.FindCheckedRow(prefix1+"chk");

	     		if(sRow == ""){
	     			ComShowCodeMessage('BKG00546');
					return;
	     		}
	     		
				with (sheetObj) {
					var deleteRow = sRow.split("|");
					for (var i = 0; i < deleteRow.length; i++) {
						if(deleteRow[i] != ""){
							var row = deleteRow[i];
							if(GetRowStatus(row) == "R" || GetRowStatus(row) == "U"){
								SetRowStatus(row, "D");
								SetRowHidden(row, 1);
							}else if(GetRowStatus(row) == "I"){
								RowDelete(row, 0);
							}
						}
					}
				}
			break;
	     	case "sheet2" : 
				if(sheetObj.RowCount() < 1){
					ComShowCodeMessage('BKG00546');
					return;
				}
				with (sheetObj) {
					for(var i = 1 ; i < sheetObj.RowCount()+1 ; i++){
						if(GetCellValue(i, prefix2+"chk") == 1 && (GetRowStatus(i) == "R" || GetRowStatus(i) == "U"))
						{
							SetRowStatus(i,"D");
							SetRowHidden(i, 1);
						}else if(GetCellValue(i, prefix2+"chk") == 1 && GetRowStatus(i) == "I"){
							RowDelete(i, 0);
						}
					}
				}
			break;		
     	}         
    }

	function sheet2_OnPopupClick(sheetObj, row, col){
		
        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {
			case "cust_cd":
				ComOpenPopup('COM_ENS_041.do', 770, 470, "callBackCust", "1,0,1,1,1,1,1", true);
			break;  
		}		
	}    
	
	function callBackCust(rArray)
	{
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), prefix2+"cust_cd", rArray[0][3]);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), prefix2+"cust_nm", rArray[0][4]);
	}
	
	function callBackCustCd(rArray)
	{
		var custCd = rArray[0][3];
		document.form.cust_cnt_cd.value = custCd.substring(0,2);
		document.form.cust_seq.value = custCd.substring(2,custCd.length);
	}
	
	function sheet1_OnClick(SheetObj, Row, Col) {
		var formObj = document.form;
		if(SheetObj.ColSaveName(Col)==prefix1+"bl_grp_nm"||SheetObj.ColSaveName(Col)==prefix1+"seq"){
			if(SheetObj.GetCellValue(Row,prefix1+"bl_grp_seq")!="" && SheetObj.GetCellValue(Row,prefix1+"bl_grp_nm")!=""){ 
				var SaveStr = sheetObjects[1].GetSaveString(0);
				if(SaveStr != ""){
					if(ComShowCodeConfirm('BKG00254')){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					}
				}
				var nowRow = SheetObj.GetSelectRow();
				formObj.bl_grp_seq.value = SheetObj.GetCellValue(nowRow, prefix1+"bl_grp_seq");
				doActionIBSheet(sheetObjects[1],formObj,SEARCH01);
			}
		}
		
        ComBtnEnable("btn_RowAdd2");
        ComBtnEnable("btn_RowDel2");
	}    
	
	function validateForm(sheetObj, formObj, sAction){
   	 	for (var i=1 ; i < sheetObjects[0].RowCount()+1 ; i++){
   	 		if (sheetObjects[0].GetCellValue(i,5) == ''){
   	 			ComShowCodeMessage("BKG43064", "BL Group Name");
   	 			sheetObjects[0].SelectCell(i, 5, true, '');
	    		return false;
	    	}else if(sheetObjects[0].GetCellValue(i,6) == ''){
	    		ComShowCodeMessage("BKG43064", "Description");
	    		sheetObjects[0].SelectCell(i, 6, true, '');
	    		return false;
	    	}
   	 	}
   	 	
   	 	for (var i=1 ; i < sheetObjects[1].RowCount()+1 ; i++){
	 		if (sheetObjects[1].GetCellValue(i,8) == ''){
	 			ComShowCodeMessage("BKG43064", "Customer Code");
	 			sheetObjects[1].SelectCell(i, 8, true, '');
	    		return false;
	    	}
	 	}
   	 	
 		var dupBlGrpNm = sheetObjects[0].ColValueDupRows(prefix1+"bl_grp_nm", false, true);
 		
		if (dupBlGrpNm != null && dupBlGrpNm != "") {	//msgs['BKG00764']="{?msg1} is duplicated."
			ComShowCodeMessage("BKG00764","BL Group Name");
			return false;
		}     

   	 
   	 	return	true;
	}