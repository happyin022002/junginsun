/*=========================================================
*1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESM_PRI_0001_04.js
*@FileTitle  :  Origin/Destination Arbitrary Charge Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview .
     * @author 
     */
    /**
     * @extends 
     * @class Origin/Destination Arbitrary Charge Guideline Creation : Business Script for Origin/Destination Arbitrary Charge Guideline Creation 
     */
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var enableFlag=true;
 var opener;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return void
  * @author 
  * @version 2009.04.17
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
				case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;						
				case "btn_Save":
					if(enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
						if (ComPriConfirmSave()) {
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
						}
					}    						
					break;				
				case "btn_Add":
					if (enableFlag && validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}					
					break;					
				case "btn_DownExcel":
					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		                return false;
					}
					break;
				case "btn_LoadExcel":
					if (validateForm(sheetObject1,formObject,IBLOADEXCEL)) {					
						var svcScpCd=formObject.svc_scp_cd.value;
						var glineSeq=formObject.gline_seq.value;
				 		if (formObject.dest_tp_cd[0].checked == true){
				 			var ordDestTpCd="O";
				 		} else{
				 			var ordDestTpCd="D";
				 		}					
						var sParam="svc_scp_cd="+svcScpCd+"&gline_seq="+glineSeq+"&org_dest_tp_cd="+ordDestTpCd;		
						var str=ComOpenWindowCenter("/opuscntr/ESM_PRI_0067.do?"+sParam, "", getWidth(1100), getHeight(425), true);
						fontChange();
						opener.setTabStyle();
					}else{
		                ComShowCodeMessage('PRI08001');
		                return false;
					}
					break;					
				case "btn_Copy":
					if (enableFlag && validateForm(sheetObject1,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject1,formObject,IBCOPYROW);			
					}	
					break;			
				case "btn_Del":						
					if (enableFlag && validateForm(sheetObject1,formObject,IBDELETE)) { 
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
				case "dest_tp_cd":
					obj_click();
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
     /**
      * registering IBSheet Object as list <br>
      * adding process for list in case of needing batch processing with other items<br>
      * defining list on the top of source <br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj);
      * </pre>
      * @param {ibsheet} sheet_obj mandatory IBSheet Object
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet <br>
      * implementing onLoad event handler in body tag <br>
      * adding first-served functions after loading screen. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function loadPage() {
    	 
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
          for(i=0;i<sheetObjects.length;i++){        	  
        	  //Modify Environment Setting Function's name
              ComConfigSheet(sheetObjects[i]);
              initSheet(sheetObjects[i],i+1);
              //Add Environment Setting Function
              ComEndConfigSheet(sheetObjects[i]);
          }
          
          resizeSheet();
       	  doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
       	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
       	  toggleButtons("CLEAR");       	  
       	  opener.loadTabPage();
     }
    
     /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.04.17
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id; 		  
 			    switch(sheetID) {
		 			   case "sheet1":
		 				  with(sheetObj){
		 			   var HeadTitle="|Sel.|Seq.|ARBSEQ|pnttpcd|Point|Description|Trans. Mode|Term|bptpcd|Base Port|vptpcd|VIA|Weight\n(Ton <=)|Weight\n( > Ton)|Direct Call|Per|Cargo Type|Cur|Rate|svcscpcd|glineseq|orgdesttpcd";
		 			   var headCount=ComCountHeadTitle(HeadTitle);
		 			   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		 			   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		 			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
		 			   InitHeaders(headers, info);
		
		 			   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		 			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		 			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		 			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"arb_seq" },
		 			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rout_pnt_loc_tp_cd" },
		 			             {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		 			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
		 			             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bse_port_tp_cd" },
		 			             {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		 			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"via_port_tp_cd" },
		 			             {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		 			             {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",     	   KeyField:0,   CalcLogic:"",   Format:"NullFloat",  PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		 			             {Type:"Float",     Hidden:0,  Width:70,  Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",  PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		 			             {Type:"CheckBox",  Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		 			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 			             {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 			             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",           KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		 			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		 			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
		 			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" } ];
		 			    
		 			   InitColumns(cols);
		
		 			   SetEditable(1);
		 			   SetImageList(0,"img/btns_search_off.gif");
		 			   SetImageList(1,"img/btns_search.gif");
		 			   SetWaitImageVisible(0);
		 			   SetShowButtonImage(2);
		 			  resizeSheet(); //SetSheetHeight(340);
 			   }
             break;
         }
     }
     
     function resizeSheet(){
	   	ComResizeSheet(sheetObjects[0]);
	  }
     
     /**
      * Handling sheet's processes <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {form} formObj mandatory html form object
      * @param {int} sAction mandatory,Constant Variable
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
             switch(sAction) {
	 	 		case IBSEARCH_ASYNC01: // When screen is loading, Customer type retrieves again
	 	 			var firstCheck=false;
	 				formObj.f_cmd.value=SEARCH01;
 	 				var sXml=sheetObj.GetSearchData("ESM_PRI_0001_04GS.do" , FormQueryString(formObj));
	 				var arrData=ComPriXml2Array(sXml, "typecd|typecount");
	 				var obj=document.form;
	 				if (parseInt(arrData[0][1]) > 0) {
	 					document.getElementById("dest_tp_cd1").style.fontWeight="bold";
	 					formObj.dest_tp_cd[0].checked=true;
	 					obj.org_dest_tp_cd.value="O";
	 					firstCheck=true;
	 				}else{
	 					document.getElementById("dest_tp_cd1").style.fontWeight="";
	 					formObj.dest_tp_cd[0].checked=true;
	 				}
	 				if (parseInt(arrData[1][1]) > 0) {
	 					document.getElementById("dest_tp_cd2").style.fontWeight="bold";
	 					if (!firstCheck){
	 						formObj.dest_tp_cd[1].checked=true;
	 						obj.org_dest_tp_cd.value="D";
	 					}
	 				}else{
	 					document.getElementById("dest_tp_cd2").style.fontWeight="";
	 				}		
	 				if (obj.org_dest_tp_cd.value == "D"){
	 					// Common term 
	 					sheetObj.SetColProperty("rcv_de_term_cd", {ComboText:termDesCdComboText, ComboCode:termDesCdComboValue} );
	 				}else if (obj.org_dest_tp_cd.value =="O"){
	 					// Common term 
	 					sheetObj.SetColProperty("rcv_de_term_cd", {ComboText:termOrgCdComboText, ComboCode:termOrgCdComboValue} );
	 				}
	 				break;
	  			case IBCLEAR: 
	 				//currency combo
	 				sheetObj.SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
	 				// per combo
	 				sheetObj.SetColProperty("rat_ut_cd", {ComboText:perCdComboText, ComboCode:perCdComboValue} );
	 				//common trans mode
	 				sheetObj.SetColProperty("prc_trsp_mod_cd", {ComboText:transCdComboText, ComboCode:transCdComboValue} );
	 				//common cargo type
	 				sheetObj.SetColProperty("prc_cgo_tp_cd", {ComboText:cargoCdComboText, ComboCode:cargoCdComboValue} );
	 				break;
	 			case IBSEARCH:      //Retrieving	
	 				ComOpenWait(true); //->waiting->start 	 			
	 				formObj.f_cmd.value=SEARCH;
 	 				sheetObj.DoSearch("ESM_PRI_0001_04GS.do", FormQueryString(formObj) );
	 				ComOpenWait(false); //->waiting->End
	              	break;
	 			case IBSAVE:        
	 				ComOpenWait(true); //->waiting->start 	 			
	 				formObj.f_cmd.value=MULTI;			
	 				var sParam=FormQueryString(formObj);				
	  				var sParamSheet=sheetObj.GetSaveString();
	 				 if (!sheetObj.IsDataModified()) {
	 					ComShowCodeMessage("PRI00301");
	 					return false;
	 				}					 
	 				if (sParamSheet == ""){
	 					return false;
	 				}
 	  				var sXml=sheetObj.GetSaveData("ESM_PRI_0001_04GS.do", sParam+"&"+sParamSheet);
 	  				sheetObj.LoadSaveData(sXml);
	  				ComOpenWait(false); //->waiting->End
	                 return true;
	  				break;
	 			case IBINSERT:      // Insert
	 			    sheetObj.SetDataAutoTrim(0);
	 		        var Row=sheetObj.DataInsert();
	 				sheetObj.SetCellValue(Row, "svc_scp_cd",formObj.svc_scp_cd.value);
	 				sheetObj.SetCellValue(Row, "gline_seq",formObj.gline_seq.value);
	 				sheetObj.SetCellValue(Row, "org_dest_tp_cd",formObj.org_dest_tp_cd.value);
	 				sheetObj.SetCellValue(Row,"arb_seq",parseInt(ComPriGetMax(sheetObj, "arb_seq"))+ 1);
	 				sheetObj.SetCellValue(Row, "frt_rt_amt","0.00");
	 				sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
	 				break;				
	 			case IBDOWNEXCEL:      // Input
	 				var colNames = "Seq|rout_pnt_loc_def_cd|loc_des|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|via_port_def_cd|min_cgo_wgt|max_cgo_wgt|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|curr_cd|frt_rt_amt";
 	 				sheetObj.Down2Excel( {DownCols: colNames , CheckBoxOnValue:'Y', CheckBoxOffValue:' ',  Merge:1, KeyFieldMark:0 });
	 				break;
	 			case IBCOPYROW: // Row Copy
	 				var Row=sheetObj.DataCopy();
	 				sheetObj.SetCellValue(Row,"arb_seq",parseInt(ComPriGetMax(sheetObj, "arb_seq"))+ 1);
	 				break;			
	 			case IBDELETE: // Delete
	 				deleteRowCheck(sheetObj, "chk" ,true);
	 				break;		
	          }        	 
         } catch (e) {
       		if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }finally{
	          	if ( sAction == IBCLEAR || sAction == IBDELETE || sAction == IBINSERT
	          			|| sAction == IBSEARCH_ASYNC01 || sAction == IBDOWNEXCEL || sAction == IBCOPYROW) {
	          		return;
	          	}
	          	ComOpenWait(false); //->waiting->End
         }
     }
     /**
      * handling process for input validation <br>
      * <br><b>Example :</b>
      * <pre>
      *     if (validateForm(sheetObj,document.form,IBSAVE)) {
      *        handling logic
      *     }
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {form} formObj mandatory html form object
      * @param {int} sAction mandatory,Constant Variable
      * @returns bool <br>
      *          true  : valid<br>
      *          false : inValid
      * @author 
      * @version 2009.04.17
      */
     function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
	  		case IBSEARCH: // retrieving			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				}
				break;    	  
    	  	case IBSAVE: // Saving
		       if (opener.document.form.cfm_flg.value == "Yes"){
		    	   ComShowCodeMessage("PRI00105");
		    	   return false;
		       }
				if (sheetObjects[0].IsDataModified()) {
					var rowM=sheetObjects[0].ColValueDup("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|via_port_def_cd|min_cgo_wgt|max_cgo_wgt|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd", false);
					 if (rowM >= 0) {
						 ComShowCodeMessage("PRI00303", "Arbitrary Sheet", rowM);
						 sheetObj.SelectCell(rowM, "bse_port_def_cd");
					     return false;
				    }
					 var mRow = getValidRowCount(sheetObj);
					for (i=1; i <= mRow; i++){						
						if (sheetObj.GetCellValue(i, "rcv_de_term_cd") !="D" && (sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == sheetObj.GetCellValue(i, "bse_port_def_cd")) ){
							ComShowCodeMessage("PRI08013");
							sheetObj.SelectCell(i,"bse_port_def_cd");
							return false;							
						}
						
						var minCgoWgt = sheetObj.GetCellValue(i, "min_cgo_wgt");
						var maxCgoWgt = sheetObj.GetCellValue(i, "max_cgo_wgt");
						if(sheetObj.GetRowStatus(i) != "D" && minCgoWgt != "" && minCgoWgt > 999.999) {

							ComShowCodeMessage("PRI00336", 'Weight(Ton<=)', '999.999');
							sheetObj.SelectCell(i, "min_cgo_wgt");
							return false;
						}
						if(sheetObj.GetRowStatus(i) != "D" && maxCgoWgt != "" && maxCgoWgt > 999.999) {

							ComShowCodeMessage("PRI00336", 'Weight(<Ton)', '999.999');
							sheetObj.SelectCell(i, "max_cgo_wgt");
							return false;
						}

					}
				 
				}
				break;
    			//getMainStatus
    		case IBINSERT: // Row Add
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				return false;
    			}
		       if (!getMainStatus()){
		    	   return false;
		       }
    			break;
    		case IBCOPYROW: // Row Copy
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				return false;
    			}
		       if (!getMainStatus()){
		    	   return false;
		       }
    			break;
    		case IBDELETE: // Delete
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				return false;
    			}
		       if (!getMainStatus()){
		    	   return false;
		       }
    			break;
    		case IBLOADEXCEL: // Excel Load
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            }    
				break;	
            case IBDOWNEXCEL: // 
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            }
	        	if (sheetObj.IsDataModified()== true){
	        		ComShowCodeMessage('PRI00309','Arbitrary');
	        		return false;
	        	}            
	            break;				
    	  }
         return true;
     }
    /**
     * calling function in case of Clicking radio button <br>
     * Depend on Origin, Destination Option, Retrieve proper term type.
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param  void
     * @returns void
     * @author 
     * @version 2009.04.17
     */ 	
 	function obj_click()
 	{
 		var obj=document.form;
 		var sheetObj=sheetObjects[0];
 		if (sheetObjects[0].IsDataModified()){
 			if (ComPriConfirmSave()) {
				if (validateForm(sheetObjects[0],obj,IBSAVE)) {					
					if(doActionIBSheet(sheetObjects[0],obj,IBSAVE)){
						fontChange();	
					}else{
						obj.dest_tp_cd[getTpCd()].checked=true;
						return;
					}							
				}else{
					obj.dest_tp_cd[getTpCd()].checked=true;
					return;
				}
 			}
		} 		
 		if (obj.dest_tp_cd[0].checked == true){
 			obj.org_dest_tp_cd.value="O";
 			obj.cd.value="CD02138"; // origin
 		} else{
 			obj.org_dest_tp_cd.value="D";
 			obj.cd.value="CD02139"; //dest
 		}
		if (obj.org_dest_tp_cd.value == "D"){
			// Common term 
			sheetObj.SetColProperty("rcv_de_term_cd", {ComboText:termDesCdComboText, ComboCode:termDesCdComboValue} );
		}else if (obj.org_dest_tp_cd.value =="O"){
			// Common term 
			sheetObj.SetColProperty("rcv_de_term_cd", {ComboText:termOrgCdComboText, ComboCode:termOrgCdComboValue} );
		}	 		
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	}
     /**
     * Return index of selected object's type. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     * 	getTpCd()
     * </pre>
     * @param  void
     * @return {int} Currently selected radio button index 
     * @author 
     * @version 2009.04.17
     */ 	 	
    function getTpCd(){
    	var formObj=document.form;
    	var tpCd=formObj.org_dest_tp_cd.value;
    	var optIdx=0;
    	switch (tpCd){
	    	case "O":
	    		optIdx=0;
	    		break;
	    	case "D":
	    		optIdx=1;
	    		break;
    	}
    	return optIdx;
    } 	
     /**
     * Function to modify font of radio button<br>
     * Show BOLD if data exists<br>
     * <br><b>Example :</b>
     * <pre>
     * 	fontChange()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */ 	     
    function fontChange(){
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetObjects[0]);
    	var formObj=document.form;
		var fontBold="";
    	var eleName="";
    	var tpCd=formObj.org_dest_tp_cd.value;
    	switch (tpCd) {
	    	case "O":
	    		eleName="dest_tp_cd1";
	    		break;
	    	case "D":
	    		eleName="dest_tp_cd2";
	    		break; 		
    	}
 		if (row_count > 0) {
 			fontBold="bold";
 		}    	
    	document.getElementById(eleName).style.fontWeight=fontBold;
    }
     /**
      * calling function when occurring OnSaveEnd event <br>
      * Showing saving confirmation message <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {string} ErrMsg mandatory from server
      * @return void
      * @author 
      * @version 2009.04.17
      */ 	
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
    		opener.setTabStyle();
		}
    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}   
    /**
    * Calling Function in case of OnChange event <br>
    * showing Description<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row mandatory Onclick ,Cell's Row Index
    * @param {int} Col mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory Value
    * @return void
    * @author 
    * @version 2009.04.17
    */  	
    function sheet1_OnChange(sheetObj, Row, Col, Value)
    {
    	var colname=sheetObj.ColSaveName(Col);
    	var formObj=document.form
    	switch(colname)
    	{
	    	case "rout_pnt_loc_def_cd":
	    		sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd",sheetObj.GetCellValue(Row,"rout_pnt_loc_def_cd").toUpperCase(),0);
	    		if(Value.length == 5){
  	    			formObj.f_cmd.value=SEARCH05;
  	    			formObj.cd.value=sheetObj.GetCellValue(Row,"rout_pnt_loc_def_cd");  	
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
	  				if (arrData != null && arrData.length > 0) {
	  					sheetObj.SetCellValue(Row, "loc_des",arrData[0][1],0);
	  					sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","L",0);
	  					locationDupChk(sheetObj, Row, colname);
  					}else{  
  						ComShowCodeMessage("PRI00315");
  						cellClear(sheetObj,Row, colname);
					}	
	    		}else if (Value.length == 0){
	    			cellClear(sheetObj,Row, colname);
	    		}else{
	    			ComShowCodeMessage("PRI00315");
	    			cellClear(sheetObj,Row, colname);
	    		}
	    		break;
	    	case "bse_port_def_cd":
	    		sheetObj.SetCellValue(Row,"bse_port_def_cd",sheetObj.GetCellValue(Row,"bse_port_def_cd").toUpperCase(),0);
	    		if (Value.length == 4){
 	    			formObj.f_cmd.value=SEARCH11;
 	    			formObj.cd.value=Value.toUpperCase();  	  
 	    			var param="&etc1="+formObj.svc_scp_cd.value+"&etc2="+formObj.gline_seq.value;	
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm"); 	  				
	 				if (arrData != null && arrData.length > 0) {
	 					if (arrData[1]!=""){
	 						sheetObj.SetCellValue(Row,"bse_port_tp_cd","G",0);
	 					}else{	
	 						ComShowCodeMessage("PRI00315");
	 						cellClear(sheetObj,Row, colname);
	 					}
	 				}	    			
	    		}else if(Value.length == 5){
  	    			formObj.f_cmd.value=SEARCH05;
  	    			formObj.cd.value=Value.toUpperCase();  	
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
	  				if (arrData != null && arrData.length > 0) {
	  					sheetObj.SetCellValue(Row,"bse_port_tp_cd","L",0);
	  					locationDupChk(sheetObj,Row, colname);
  					}else{  
  						ComShowCodeMessage("PRI00315");
  						cellClear(sheetObj,Row, colname);
					}
	    		}else if (Value.length == 0){	    
	    			cellClear(sheetObj,Row, colname);
	    		}else{
	    			ComShowCodeMessage("PRI00315");
	    			cellClear(sheetObj,Row, colname);
	    		}	    		
	    		break;
	    	case "via_port_def_cd":
	    		sheetObj.SetCellValue(Row,"via_port_def_cd",sheetObj.GetCellValue(Row,"via_port_def_cd").toUpperCase(),0);
	    		if (Value.length == 4){
 	    			formObj.f_cmd.value=SEARCH11;
 	    			formObj.cd.value=Value.toUpperCase();  	  
 	    			var param="&etc1="+formObj.svc_scp_cd.value+"&etc2="+formObj.gline_seq.value;	
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm"); 	  				
	 				if (arrData != null && arrData.length > 0) {
	 					if (arrData[1]!=""){
	 						sheetObj.SetCellValue(Row,"via_port_tp_cd","G",0);
	 					}else{	
	 						ComShowCodeMessage("PRI00315");
	 						cellClear(sheetObj,Row, colname);
	 					}
	 				}	    			
	    		}else if(Value.length == 5){
		  			formObj.f_cmd.value=SEARCH05;
		  			formObj.cd.value=Value.toUpperCase();  	
 					var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		
					if (arrData != null && arrData.length > 0) {
						sheetObj.SetCellValue(Row,"dir_call_flg","0",0);
						sheetObj.SetCellValue(Row,"via_port_tp_cd","L",0);
					}else{  
						ComShowCodeMessage("PRI00315");
						cellClear(sheetObj,Row, colname);
					}	
				}else if (Value.length == 0){
					cellClear(sheetObj,Row, colname);
				}else{
					ComShowCodeMessage("PRI00315");
					cellClear(sheetObj,Row, colname);
				}	    	
	    		break;	
	    	case "dir_call_flg":
	    		if (sheetObj.GetCellValue(Row, "via_port_def_cd") !="") {
	    			ComShowCodeMessage('PRI08014');
	    			sheetObj.SetCellValue(Row,"dir_call_flg","0",0);
	    			return;
	    		}
	    		if (Value == "1"){
	    			sheetObj.SetCellEditable(Row,"via_port_def_cd",0);
    //no support[check again]CLT 				sheetObj.PopupButtonImage(Row, "via_port_def_cd")=0;
	    		}else{
	    			sheetObj.SetCellEditable(Row,"via_port_def_cd",1);
//no support[check again]CLT 	    			sheetObj.PopupButtonImage(Row, "via_port_def_cd")=1;
	    		}
	    		break;
	    	case "rat_ut_cd":
	    		if (sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK"){
		    		var perList="A,F,O,Q,S,P";
		    		var preCd=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
		            if (perList.indexOf(preCd) < 0) {
		                ComShowCodeMessage("PRI08003");
		                sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
		            }
	    		}
	    		break;
	    	case "prc_cgo_tp_cd":
	    		if (Value == "AK"){
		    		var perList="A,F,O,Q,S,P";
		    		var preCd=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
		            if (perList.indexOf(preCd) < 0) {
		                ComShowCodeMessage("PRI08003");
		                sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
		            }
	    		}
	    		break; 
    	}
    }    
        /**
         * Calling Function in case of OnSearchEnd event <br>
         * <br><b>Example :</b>
         * <pre>
         * 
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {string} ErrMsg mandatory from server
         * @return void
         * @author 
         * @version 2009.05.20
         */ 	  	
    	function sheet1_OnSearchEnd(sheetObj, code, errMsg){
    //no support[check again]CLT 		for(i=1 ; i < sheetObj.Rows; i++){
    		if (sheetObj.GetCellValue(i, "dir_call_flg") =="1" ){
    				sheetObj.SetCellEditable(i,"via_port_def_cd",0);
    //no support[check again]CLT 				sheetObj.PopupButtonImage(i, "via_port_def_cd")=0;
    		}else{
    				sheetObj.SetCellEditable(i,"via_port_def_cd",1);
    //no support[check again]CLT 				sheetObj.PopupButtonImage(i, "via_port_def_cd")=1;
    		}
    		fontChange();
    	}    
    	
    /**
    * Check the same location registered in Point and B.Port <br>
    * <br><b>Example :</b>
    * <pre>
    * 		locationDupChk(sheetObj,1,1)
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row Mandatory Cell's Row Index  
    * @param {int} Col Mandatory Cell's Col Index 
    * @return void
    * @author 
    * @version 2009.04.17
    */  
    function locationDupChk(sheetObj,Row,Col){
    	if (sheetObj.GetCellValue(Row, "rcv_de_term_cd") !="D" && (sheetObj.GetCellValue(Row,"rout_pnt_loc_def_cd") == sheetObj.GetCellValue(Row,"bse_port_def_cd"))){
    		ComShowCodeMessage("PRI08013");
    		cellClear(sheetObj,Row,Col);
    	}
    }
    /**
    * Initializing sheet's specific cell value <br>
    * <br><b>Example :</b>
    * <pre>
    * 		cellClear(sheetObj,1,"point")
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row Mandatory ,Cell Row Index    
    * @param {int} Col Mandatory Cell's Col Index     
    * @param {str} msg PRI Common Message    
    * @return void
    * @author 
    * @version 2009.04.17
    */  	    
 	function cellClear(sheetObj,Row, Col){
  		if (Col == "rout_pnt_loc_def_cd"){
			sheetObj.SetCellValue(Row,"loc_des","",0);
			sheetObj.SetCellValue(Row,"rout_pnt_loc_def_cd","",0);
			sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd","",0);
			sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
 		}else if (Col == "bse_port_def_cd"){
			sheetObj.SetCellValue(Row,"bse_port_def_cd","",0);
			sheetObj.SetCellValue(Row,"bse_port_tp_cd","",0);
			sheetObj.SelectCell(Row,"bse_port_def_cd");
 		}else if (Col == "via_port_def_cd"){
			sheetObj.SetCellValue(Row,"via_port_def_cd","",0);
			sheetObj.SetCellValue(Row,"via_port_tp_cd","",0);
			sheetObj.SelectCell(Row,"via_port_def_cd");
 		}
 	}        
    /**
    * Calling function in case of OnPopupClick event<br>
    * Calling Location PopUp <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
    * @param {int} Col Mandatory OnPopupClick 'Cell's Column Index
    * @return void
    * @author 
    * @version 2009.05.07
    */  
 	var popupRow = 0;
 	var colName="";
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		colName=sheetObj.ColSaveName(Col);
		popupRow = Row;
		var formObj=document.form;	
		
		if (colName == "rout_pnt_loc_def_cd"){
			
			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&location_cmd=L&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);      

		}else if (colName == "via_port_def_cd"){	
			
			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&location_cmd=LG&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);   
		
		}else if (colName == "bse_port_def_cd"){
			
			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&location_cmd=LG&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true); 
			
		}
	}
	
	function setReturnValue(rtnVal) {
		if (rtnVal != null){
			var sheetObj=sheetObjects[0];
			var tpCd="G";
			if (rtnVal.cd.length == 5){
				tpCd="L";
			}
			if (colName == "rout_pnt_loc_def_cd"){
				sheetObj.SetCellValue(popupRow, "rout_pnt_loc_tp_cd", tpCd ,0);
				sheetObj.SetCellValue(popupRow, "rout_pnt_loc_def_cd", rtnVal.cd, 0);
				sheetObj.SetCellValue(popupRow, "loc_des", rtnVal.nm, 0);
			} else if(colName == "via_port_def_cd") {
				sheetObj.SetCellValue(popupRow, "via_port_tp_cd", tpCd, 0);
				sheetObj.SetCellValue(popupRow, "via_port_def_cd", rtnVal.cd, 0);
			} else if (colName == "bse_port_def_cd") {
				sheetObj.SetCellValue(popupRow,"bse_port_tp_cd",tpCd ,0);
				sheetObj.SetCellValue(popupRow,"bse_port_def_cd",rtnVal.cd ,0);
			}
			
		}
	}
    /**
     * Decide Editable option using the status of parent window. <br>
     * <br><b>Example :</b>
     * <pre>
     * getMainStatus())
     * </pre>
     * @param  void
     * @return {Boolean} true(Editable, Status of Main is NO) false (Non-Editable, Status of Main is Yes)
     * @author 
     * @version 2009.04.17
     */    
    function getMainStatus(){
    	var mainStatus=opener.document.form.cfm_flg.value;
    	var editStatus=true;
    	if (mainStatus == "Yes"){
    		editStatus=false;
    	}
    	return editStatus;
    }
 /**
  * Depend on the status of window, control the button activate/deactivate <br>
  * <br><b>Example :</b>
  * <pre>
  *  toggleButtons(mode)
  * </pre>
  * @param {String} Status of screen Mandatory 
  * @author 
  * @version 2009.04.17
  */        
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_LoadExcel");
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Del");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			if (getMainStatus()){
				ComBtnEnable("btn_Save");
				ComBtnEnable("btn_LoadExcel");
			}else{
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_LoadExcel");
			}
			ComBtnEnable("btn_Add");
			ComBtnEnable("btn_Copy");
			ComBtnEnable("btn_Del");
			ComBtnEnable("btn_DownExcel");			
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnDisable("btn_LoadExcel");
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Del");
			break;
		}
	}
  /**
   * Calling function in case of clicking tabl on parent screen <br>
   * It shows screen and process retrieve <br>
   * <br><b>Example :</b>
   * <pre>
   * tabLoadSheet("ACE", "1")
   * </pre>
   * @param {string} sSvcScpCd Mandatory svc_scp_cd 
   * @param {string} sGlineSeq Mandatory gline_seq
   * @param {string} isAproUsr Mandatory Authority Value
   * @return void
   * @author 
   * @version 2009.04.17
   */ 		    	
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
            if (isAproUsr && opener.getCfmFlg() == "N") {
            	enableFlag=true;
            } else {
            	enableFlag=false;
            }
            tabEnableSheet(enableFlag);			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
    /**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */ 		 
	function tabClearSheet() {
		var formObject=document.form;		
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";		
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");		
		for (var i=1; i <3; i++){
			document.getElementById("dest_tp_cd"+i).style.fontWeight="";	
		}
		formObject.dest_tp_cd[0].checked=true
	}     
     /**
     * Calling function from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * 	tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return void
     * @author 
     * @version 2009.04.17
     */ 	 
	function tabEnableSheet(flag) {
		var formObject=document.form;	
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		
	}
