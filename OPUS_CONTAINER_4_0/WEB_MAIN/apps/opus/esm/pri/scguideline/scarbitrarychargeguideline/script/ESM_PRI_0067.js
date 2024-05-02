/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0067.js
*@FileTitle  : Guideline Arbitrary - Excel Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27   
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // global variables 
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var errFlg=false;	// setting flag value after click check button 
 var opener;
//Event handler processing by button click event */
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
        	  if(ComGetBtnDisable(srcName)) return false;
      		  
        	  switch(srcName) {
           		case "btn_save":
	           		 	if(validateForm(sheetObject1,formObject,IBSAVE)) {
					 		doActionIBSheet(sheetObject1,formObject,IBSAVE);
					 	} 
                     break;
                 case "btn_check":
                	 	if(validateForm(sheetObject1,formObject,IBSEARCH)) {
     				 		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
     				 	}
                     break; 
                 case "btn_close":
                	 ComClosePopup(); 
                     break;
                 case "btn_file":                   
//parameter changed[check again]CLT                 	 sheetObjects[0].LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false});
                	//var type=ComGetObjValue(formObj.rail_cd);
                 	var file="";
         /*    	    if (type == "CY" || type == "NS") {
             	    	file=sheetObj.ShowDialog("", "", "", "*.xls|*.xls|*.xlsx|*xlsx");	
             	    } else {
             	    	file=sheetObj.ShowDialog("", "", "", "*.xls|*.xls|*.xlsx|*xlsx");
//             	    	file=sheetObj.ShowDialog("", "", "", "*.txt");	
             	    }
                 	if (file == "" || file == "<USER_CANCEL>") break;
         */         ComOpenWait(true);

                		//formObj.file_name.value=file;
           	    	sheetObjects[0].LoadExcel();
             	    ComOpenWait(false);
             	   /* // load parsing result after send file content to server
                     if(validateForm(sheetObj,formObj,sAction) == false) {
                         ComOpenWait(false);
                     	break;
                     }
                     if (sheetObj.RowCount()< 1) {
                         ComOpenWait(false);
                     	break;
                     }
                     formObj.f_cmd.value=COMMAND01;
                     var sParam=FormQueryString(formObj);
                     var sParamSheet1=sheetObjects[1].GetSaveString();
                     if (sParamSheet1 != "") {
                         sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
                     }
                     var sXml=sheetObj.GetSearchData("ESM_BKG_1064GS.do", sParam);
         			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
         			sheetObjects[0].ColumnSort("bl_no|cntr_no");
         			fncRemoveFileInfoDup();
         			ComOpenWait(false);*/
                     
                	 break;
                 case "btn_Template":
                	 downform.submit();
                	 break;
             } // end switch
     	}catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
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
      * Initializing and setting Sheet basics<br> 
      * Setting body tag's onLoad event handler<br>
      * Adding pre-handling function after loading screen on the browser <br>
      */
     function loadPage() {
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         buttonControl("INIT");
     }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
    	 var formOrg=document.form;
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
		               var HeadTitle="|Seq.|Point|Trans. Mode|Term|Base Port|VIA|Weight\n(Ton <=)|Weight\n( > Ton)|Direct Call|Per|Cargo Type|Cur|Rate|1|2|3|4|5|6";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               var HeadTitle="|Seq.|Point|Trans. Mode|Term|Base Port|VIA|Weight\n(Ton <=)|Weight\n( > Ton)|Direct Call|Per|Cargo Type|Cur|Rate";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"arb_seq" },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                      {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                      {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",     	   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                      {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                      {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		                      {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"bse_port_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"via_port_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" } ];
		                
		               InitColumns(cols);
		
		               SetEditable(1);
		               SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdComboText ,ComboCode:prcTrspModCdComboValue} );
		               SetColProperty("rcv_de_term_cd", {ComboText:rcvDeTermCdComboText ,ComboCode:rcvDeTermCdComboValue} );
		               SetColProperty("rat_ut_cd", {ComboText:ratUtCdComboText ,ComboCode:ratUtCdComboValue} );
		               SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdComboText ,ComboCode:prcCgoTpCdComboValue} );
		               SetColProperty("curr_cd", {ComboText:currCdComboText ,ComboCode:currCdComboValue} );
		               SetColProperty("rout_pnt_loc_def_cd", {AcceptKeys:"E|N", InputCaseSensitive:1} );
		               SetColProperty("bse_port_def_cd", {AcceptKeys:"E|N", InputCaseSensitive:1} );
		               SetColProperty("via_port_def_cd", {AcceptKeys:"E|N", InputCaseSensitive:1} );
		               SetWaitImageVisible(0);
		               SetShowButtonImage(2);
		               SetSheetHeight(310);
               		}
                 break;
             case 2:      //sheet1 init
                 with(sheetObj){
				  var HeadTitle="|Seq.|Point|Trans. Mode|Term|Base Port|VIA|Weight\n(Ton <=)|Weight\n( > Ton)|Direct Call|Per|Cargo Type|Cur|Rate|1|2|3|4|5|6";
				  var headCount=ComCountHeadTitle(HeadTitle);
				
				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				  var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				  var headers = [ { Text:HeadTitle, Align:"Center"} ];
				  InitHeaders(headers, info);
				
				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"arb_seq" },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd" },
								{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd" },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd" },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd" },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd" },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"min_cgo_wgt" },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"max_cgo_wgt" },
								{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg" },
								{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd" },
								{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd" },
								{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt" },
								{Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
								{Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"bse_port_tp_cd" },
								{Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"via_port_tp_cd" },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" } ];
				   
				  InitColumns(cols);
				  
				  SetEditable(0);
				  SetWaitImageVisible(0);
				  SetSheetHeight(160);
             }
             break;
         }
     }
     
 	/**
      * frt_rt_amt's validation check function <br>
      * @author 
      * @version 
      */
 	function validCheckFreightRateAmount(sheetObj, Row, Value) {
 		if(!ComIsMoneyNumber(Value)) {
 			return false;
 		}
 		return true;
 	}
     
	 /**
	* calling function when occurring OnChange Event <br> 
	* when selecting multi comboBox, showing description <br>
	*/ 	
	        function sheet1_OnChange(sheetObj, Row, Col, Value)
        {
        	var colname=sheetObj.ColSaveName(Col);
        	var formObj=document.form;
        	switch(colname)
        	{
    	    	case "rout_pnt_loc_def_cd":
    	    		if(Value.length == 5){
      	    			formObj.f_cmd.value=SEARCH05;
      	    			formObj.cd.value=sheetObj.GetCellValue(Row,Col);  	
    	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
    	  				var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
    	  				if (arrData != null && arrData.length > 0) {
    	  					sheetObj.SetCellValue(Row, "loc_des",arrData[0][1],0);
    	  					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","L",0);
      					}else{  						
    						sheetObj.SetCellValue(Row,"loc_des","",0);
    						sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd","",0);
    						sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","",0);
    						sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
    					}		    			
    	    		}else{
    					sheetObj.SetCellValue(Row,"loc_des","",0);
    					sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd","",0);
    					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","",0);
    					sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
    	    		}
    	    		break;
    	    	case "bse_port_def_cd":
    	    		if (Value.length == 4){
     	    			formObj.f_cmd.value=SEARCH11;
     	    			formObj.cd.value=Value;  	  
     	    			var param="&etc1="+formObj.svc_scp_cd.value+"&etc2="+formObj.gline_seq.value;	
      	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
     	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm"); 	  				
     	  				if(arrData[1] != ""){
    	 					sheetObj.SetCellValue(Row,"bse_port_tp_cd","G",0);
    	 				}else{	
		 					sheetObj.SetCellValue(Row,"bse_port_def_cd","",0);
		 					sheetObj.SetCellValue(Row,"bse_port_tp_cd","",0);
		 					sheetObj.SelectCell(Row,"bse_port_def_cd");
	 					}    			
    	    		}else if(Value.length == 5){
    	    			if(Value == sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") && sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D") {
    	    				ComShowCodeMessage('PRI01020');
    	    				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
    	    				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
    	    				sheetObj.SelectCell(Row, "bse_port_def_cd");
    	    				break;
    	    			}
      	    			formObj.f_cmd.value=SEARCH05;
      	    			formObj.cd.value=Value;  	
     	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
    	  				var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
    	  				if (arrData != null && arrData.length > 0) {
    	  					sheetObj.SetCellValue(Row,"bse_port_tp_cd","L",0);
      					}else{  						
    	 					sheetObj.SetCellValue(Row,"bse_port_def_cd","",0);
    	 					sheetObj.SetCellValue(Row,"bse_port_tp_cd","",0);
    	 					sheetObj.SelectCell(Row,"bse_port_def_cd");
    					}		    			
    	    		}else{
     					sheetObj.SetCellValue(Row,"bse_port_def_cd","",0);
     					sheetObj.SetCellValue(Row,"bse_port_tp_cd","",0);
     					sheetObj.SelectCell(Row,"bse_port_def_cd");
    	    		}	    		
    	    		break;
    	    	case "via_port_def_cd":
    				if(Value.length == 5){
    		  			formObj.f_cmd.value=SEARCH05;
    		  			formObj.cd.value=Value;  	
     					var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
    					var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		
    					if (arrData != null && arrData.length > 0) {
    						sheetObj.SetCellValue(Row,"dir_call_flg","0",0);
    						sheetObj.SetCellValue(Row,"via_port_tp_cd","L",0);
    					}else{  						
    						sheetObj.SetCellValue(Row,"via_port_def_cd","",0);
    						sheetObj.SetCellValue(Row,"via_port_tp_cd","",0);
    						sheetObj.SelectCell(Row,"via_port_def_cd");
    					}		    			
    				}else{
    						sheetObj.SetCellValue(Row,"via_port_def_cd","",0);
    						sheetObj.SetCellValue(Row,"via_port_tp_cd","",0);
    						sheetObj.SelectCell(Row,"via_port_def_cd");
    				}	    	
    	    		break;	
    	    	case "dir_call_flg":
    	    		if (Value == "1"){
    	    			sheetObj.SetCellValue(Row,"via_port_def_cd","",0);
    	    			sheetObj.SetCellValue(Row,"via_port_tp_cd","",0);
    	    			sheetObj.SetCellEditable(Row, "via_port_def_cd",0);
    	    		} else {
    	    			sheetObj.SetCellEditable(Row, "via_port_def_cd",1);
    	    		}
    	    		break;
        	}
        }   
	  	  /**
	  	   * Handling sheet process<br>
	  	   */
		function doActionIBSheet(sheetObj,formObj,sAction) {
			try {
				sheetObj.ShowDebugMsg(false);
				switch(sAction) {
					case IBSEARCH:		
		  				ComOpenWait(true);			
						formObj.f_cmd.value=MULTI02;
				 		var sParam=FormQueryString(formObj);
				 		var sParamSheet1=sheetObj.GetSaveString();
				 		sParam += "&" + sParamSheet1;
 						var sXml=sheetObj.GetSearchData("ESM_PRI_0067GS.do", sParam);
						sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
						// setting red color in case of error data
						checkValidationAllData(sheetObjects[1]);
						ComOpenWait(false);
						break;
					case IBSAVE:		
						if(errFlg) {
							buttonControl("FAIL");
							return false;
						}
						if((ComShowCodeConfirm("PRI00001")) ) {
			  				ComOpenWait(true);
				  			formObj.f_cmd.value=MULTI;
			  				var sParam=FormQueryString(formObj);
			  				var sParamSheet=sheetObj.GetSaveString();
			  				if (sParamSheet != "") {
			  					sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
			  				}		  				
 			  				var sXml=sheetObj.GetSaveData("ESM_PRI_0067GS.do", sParam);
			  				ComOpenWait(false);		  				
 			  				sheetObj.LoadSaveData(sXml);
						}
						break;
			     }
			}catch(e){
				if (e == "[object Error]") {
					ComShowMessage(OBJECT_ERROR);
				} else {
					ComShowMessage(e.message);
				}
			}finally {
				 ComOpenWait(false);
			}
		}
		/**
		* checking validation process of inputted form data <br>
		*/
      function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
	  		case IBSEARCH: 
		  		if (!sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
				break;  
	  		case IBSAVE: 
	  			if(ComGetBtnDisable("btn_save")) return false;
	  			if (sheetObjects[0].IsDataModified()) {
	  				// checking duplicate with existed data
	  				sheetObjects[1].RemoveAll();
	  				var sXml=ComPriSheet2Xml(sheetObjects[0])
	  				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
	  				formObj.f_cmd.value=SEARCH;
 	  				sXml=sheetObj.GetSearchData("ESM_PRI_0001_04GS.do", FormQueryString(formObj));
	  				sheetObjects[1].LoadSearchData(sXml,{Append:1 , Sync:1} );
					var rowM = sheetObjects[1].ColValueDupRows("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd" +
					 		"|bse_port_def_cd|via_port_def_cd|min_cgo_wgt|max_cgo_wgt|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd", false, true);	
					if (rowM != "") {
						 var rowDup=rowM.split("|");
		  				 ComShowCodeMessage("PRI00303", "Sheet", rowDup[0]);
						 sheetObj.SetEditable(1);
						 buttonControl("FAIL");
					     return false;
				    }	
					
					
				}
	  			break;	  		
    	  }
    	  return true;
     }
    /**
     * calling function when occurring OnSaveEnd event <br>
     * showing the save completion message in case of successful saving
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
		var psheetObj=opener.sheetObjects[0];
		var pformObj=opener.document.form;
		opener.doActionIBSheet(psheetObj,pformObj,IBSEARCH);
		ComClosePopup(); 
	}
    /**
     * calling function when occurring LoadExcel event <br> 
     * setting SHEET COLUMN in case of successful loading excel file 
     */
 	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
 		if(isExceedMaxRow(msg))return;
		var formObj=document.form;
		if(sheetObj.RowCount()> 0 ){
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	     		sheetObj.SetCellValue(i, "svc_scp_cd",formObj.svc_scp_cd.value,0);
				sheetObj.SetCellValue(i, "gline_seq",formObj.gline_seq.value,0);
				sheetObj.SetCellValue(i, "org_dest_tp_cd",formObj.org_dest_tp_cd.value,0);
				if(sheetObj.GetCellValue(i,"dir_call_flg") == "1") {
					sheetObj.SetCellEditable(i, "via_port_def_cd",0);
				} else {
					sheetObj.SetCellEditable(i, "via_port_def_cd",1);
				}
			}
		}
		buttonControl("LOAD");
	}
     /**
      * calling function when occurring Check button Event <br>
      * setting red color sheet's background in case of error data exist
      */
     function checkValidationAllData(sheetObj) {
  		var check=0;
  		// setting error cell color
 		var color="#FF0000"; // red
		// setting initial color - white
  		for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
  			sheetObjects[0].SetRowBackColor(i,0);
  		}
		// checking validation on screen 
  		check += validateSheetData(sheetObjects[0], color);
		// checking validation in DB
  		check += checkDBCodeExist(sheetObj, color);
  		if (check > 0) {
  			errFlg=true;
			buttonControl("FAIL");
		} else {
			errFlg=false;
			sheetObjects[0].SetEditable(0);
			buttonControl("SUCCEED");
		}
	}
     
 	/**
      * calling Event when keyboard press data cell <br> 
     */
     function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
         if (errFlg && KeyCode == 9) {
             while (true) {
                 if (Col > sheetObj.LastCol()) {
                     Row++;
                     Col=1;
                 }
                 if (Row > sheetObj.LastRow()) {
                     Row=sheetObj.HeaderRows();
                 }
                 if (sheetObj.GetCellBackColor(Row, Col) == "#FF0000") {
                     sheetObj.SelectCell(Row, Col, false);
                     break;
                 }
                 Col++;
             }
         }
     }
     
	/**
      * checking validation process of sheet's data <br>
      * returning check value in case finding validated data <br>
     */
  	function validateSheetData(sheetObj, color){ 
  		var check=0;
  		var baseColor="#FFFFFF";
  		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
  			if(sheetObj.GetCellValue(i,"rout_pnt_loc_def_cd").length != 5){
				sheetObj.SetCellBackColor(i,"rout_pnt_loc_def_cd",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"rout_pnt_loc_def_cd",baseColor);
			}  
  			if(sheetObj.GetCellValue(i,"prc_trsp_mod_cd") == "" && ComTrim(sheetObj.GetCellText(i,"prc_trsp_mod_cd")) != ""){
				sheetObj.SetCellBackColor(i,"prc_trsp_mod_cd",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"prc_trsp_mod_cd",baseColor);
			}
  			if(sheetObj.GetCellValue(i,"rcv_de_term_cd") == ""){
				sheetObj.SetCellBackColor(i,"rcv_de_term_cd",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"rcv_de_term_cd",baseColor);
			}
  			if(sheetObj.GetCellValue(i,"bse_port_def_cd") == ""){
				sheetObj.SetCellBackColor(i,"bse_port_def_cd",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"bse_port_def_cd",baseColor);
			}
  			if(sheetObj.GetCellValue(i,"via_port_def_cd") != "" && sheetObj.GetCellValue(i,"dir_call_flg") == "1"){
				sheetObj.SetCellBackColor(i,"via_port_def_cd",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"via_port_def_cd",baseColor);
			}
  			if(sheetObj.GetCellValue(i,"rat_ut_cd") == ""){
				sheetObj.SetCellBackColor(i,"rat_ut_cd",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"rat_ut_cd",baseColor);
			}
			/*
			if(sheetObj.GetCellValue(i,"prc_cgo_tp_cd") == ""){
				sheetObj.SetCellBackColor(i,"prc_cgo_tp_cd",color);
				check++;
			} 
			*/
  			if(sheetObj.GetCellValue(i,"curr_cd") == ""){
				sheetObj.SetCellBackColor(i,"curr_cd",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"curr_cd",baseColor);
			}
  			if(sheetObj.GetCellValue(i,"frt_rt_amt").length > 10 ){
				sheetObj.SetCellBackColor(i,"frt_rt_amt",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"frt_rt_amt",baseColor);
			}
  			if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != "D"
  				&& (sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == sheetObj.GetCellValue(i, "bse_port_def_cd"))) {
				sheetObj.SetCellBackColor(i, "rcv_de_term_cd",color);
				sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd",color);
				sheetObj.SetCellBackColor(i, "bse_port_def_cd",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i, "rcv_de_term_cd",baseColor);
				sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd",baseColor);
				sheetObj.SetCellBackColor(i, "bse_port_def_cd",baseColor);
			}
  			
  			var minCgoWgt = sheetObj.GetCellValue(i, "min_cgo_wgt");
			var maxCgoWgt = sheetObj.GetCellValue(i, "max_cgo_wgt");
			if(sheetObj.GetRowStatus(i) != "D" && minCgoWgt != "" && minCgoWgt > 999.999) {
				sheetObj.SetCellBackColor(i,"min_cgo_wgt",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"min_cgo_wgt",baseColor);
			}
			if(sheetObj.GetRowStatus(i) != "D" && maxCgoWgt != "" && maxCgoWgt > 999.999) {
				sheetObj.SetCellBackColor(i,"max_cgo_wgt",color);
				check++;
			}else{
				sheetObj.SetCellBackColor(i,"max_cgo_wgt",baseColor);
			}
		}
  		return check;
  	}
  /**
   * validation function of excel file loading <br>
   * existing error data, changed color <br>
   */
      function checkDBCodeExist(sheetObj, color) {
    	  	var check=0;
    	  	var baseColor="#FFFFFF";
    	  	var arbSeq=0;
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				arbSeq=sheetObjects[0].GetCellValue(i, "arb_seq");
				if(sheetObjects[0].GetCellValue(arbSeq, "via_port_def_cd") != "") {
					if(sheetObj.GetCellValue(i, "via_port_def_cd") == "0"
						&& sheetObjects[0].GetCellValue(arbSeq, "via_port_def_cd") != ""){
						sheetObjects[0].SetCellBackColor(arbSeq, "via_port_def_cd",color);
						check ++;
					} else {
						sheetObjects[0].SetCellValue(arbSeq, "via_port_tp_cd","L",0);
						sheetObjects[0].SetCellBackColor(arbSeq, "via_port_def_cd",baseColor);
					}
				}
				if(sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == "0"){
					sheetObjects[0].SetCellBackColor(arbSeq, "rout_pnt_loc_def_cd",color);
					check ++;
				} else {
					sheetObjects[0].SetCellValue(arbSeq, "rout_pnt_loc_tp_cd","L",0);
					sheetObjects[0].SetCellBackColor(arbSeq, "rout_pnt_loc_def_cd",baseColor);
				}
				if(sheetObj.GetCellValue(i, "bse_port_def_cd") == "0"){
					sheetObjects[0].SetCellBackColor(arbSeq, "bse_port_def_cd",color);
					check ++;
				} else {
					if(sheetObjects[0].GetCellValue(arbSeq, "bse_port_def_cd").length == 4) {
						sheetObjects[0].SetCellValue(arbSeq, "bse_port_tp_cd","G",0);
					} else if(sheetObjects[0].GetCellValue(arbSeq, "bse_port_def_cd").length == 5) {
						sheetObjects[0].SetCellValue(arbSeq, "bse_port_tp_cd","L",0);
					}
					sheetObjects[0].SetCellBackColor(arbSeq, "bse_port_def_cd",baseColor);
				}
			}
			return check;
      }
    /**
     * button authority control function by button status<br>
     */
     function buttonControl(valChck){
     	var formObj=document.form;
     	var rowCount=sheetObjects[0].RowCount();
     	try{
     		ComBtnDisable("btn_file");
     		ComBtnDisable("btn_check");
     		ComBtnDisable("btn_save");
     		ComBtnEnable("btn_close");
     		switch(valChck) {
     			case "SUCCEED":
     				ComBtnEnable("btn_save");
     				break;
     			case "FAIL":
     				ComBtnEnable("btn_file");
     				ComBtnEnable("btn_check");
     				ComBtnDisable("btn_save");
     				break;
     			case "LOAD":
     				ComBtnEnable("btn_file");
     				ComBtnEnable("btn_check");
     				ComBtnDisable("btn_save");
     				break;
     			case "INIT":
     				ComBtnEnable("btn_file");
     				ComBtnDisable("btn_check");
     				ComBtnDisable("btn_save");
     				break;
     		}	
     	} catch (e) {}
     }
