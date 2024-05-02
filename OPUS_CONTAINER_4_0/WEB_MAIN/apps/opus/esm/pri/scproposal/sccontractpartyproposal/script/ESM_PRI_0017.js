/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0017.js
*@FileTitle  : Customer Type Amend Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/

 // global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var rData="";
 var opener;
 //Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  */
     function processButtonClick(){
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Amend":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY03);
					break;
				case "btn_AmendCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY04);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_Accept":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
					break;
				case "btn_AcceptCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
					break;
				case "btn_Close":				
					ComPopUpReturnValue(rData);
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
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Initializing and setting Sheet basics <br>
      * Setting body tag's onLoad event handler <br>
      * Adding pre-handling function after loading screen on the browser  <br>
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
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         buttonControl(); 
     }
	/**
	 * body tag's unonLoad event handler <br>
	 * adding function when closing the screen <br>
	 */      
  	 function unloadPage(){
  		 window.returnValue=rData;
  	 }       
     /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id; 
         var amdt_seq=document.form.amdt_seq.value;
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
                 with(sheetObj){                
	              var HeadTitle="|sel|propno|amdtseq|ptytpcd|Customer Type|EFF Date|EXP Date|Source|Source|Status|Status||||";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              (headCount, 0, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                  {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_pty_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             if (amdt_seq == "0"){
	                  cols.push({Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_cust_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	              }else{
	            	  cols.push({Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_cust_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              }
	              cols.push({Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"src_info_dtl",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_dtl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	      
	              InitColumns(cols);
	              SetEditable(1);
	              SetWaitImageVisible(0);
	              SetColHidden("chk",1);
	              SetSheetHeight(150);
              }
                 break;
         }
     }
     /**
      * Handling sheet process <br>
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
             switch(sAction) {
 	 		 case IBSEARCH_ASYNC10://combo setting
 	 			//srcInfocd		        
  	 			sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
  		        //status
  	 			sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
  		        //cust type cd		        
  	 			sheetObj.InitDataCombo(0,"prc_ctrt_cust_tp_cd", custTpCdText, custTpCdValue);
 				break;
 	 		case IBSEARCH:      //retrieve	 		
 	 			ComOpenWait(true); //->waiting->start 
 				if (!validateForm(sheetObjects[0],document.form,sAction)) {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}				
 				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESM_PRI_0017GS.do", FormQueryString(formObj) );
 				ComOpenWait(false); //->waiting->End
 				break;
 			 case IBSAVE:        //save
 			 	ComOpenWait(true); //->waiting->start 
 				if (!validateForm(sheetObjects[0],document.form,sAction)) {
 					return false;
 				}
 	             if (!sheetObjects[0].IsDataModified()) {
 	                 ComShowCodeMessage("PRI00301");
 	                 return false;
 	             }
 	             if (!ComPriConfirmSave()) {
 	                 return false;
 	             }
 				formObj.f_cmd.value=MULTI;
  				var sParam=FormQueryString(formObj);
  				var sParamSheet=sheetObj.GetSaveString();
  				if (!sheetObj.IsDataModified()&& sParamSheet == "") {
  					ComShowCodeMessage("PRI00301");
  					return;
  				}	 			 	
   				var sXml=sheetObj.GetSaveData("ESM_PRI_0017GS.do", sParam+"&"+sParamSheet);
   				sheetObj.LoadSaveData(sXml);
 				ComOpenWait(false); //->waiting->End
 				break;
 			 case MODIFY01:        //accept
 			 	ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }			 
 			 	formObj.f_cmd.value=MODIFY01;
 				var rVal=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0017GS.do");
 				ComOpenWait(false); //->waiting->End
 				break;				
 			 case MODIFY02:        //accept cancel
 			 	ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            }			 
 			 	formObj.f_cmd.value=MODIFY02;
 				var rVal=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0017GS.do");
 				ComOpenWait(false); //->waiting->End
 				break;		 
 			 case MODIFY03:        //amend
 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{						
 						comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", "prc_ctrt_cust_tp_cd");						
 					}
 				}else{ 					
 					comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "prc_ctrt_cust_tp_cd");
 				}
 			 	sheetObj.SelectCell(2, "prc_ctrt_cust_tp_cd");
 				break;				 
 			 case MODIFY04:        //amend cancel
 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{
 						comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "prc_ctrt_cust_tp_cd");		
 					}
 				}else{ 
 					comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "prc_ctrt_cust_tp_cd");
 				}	
 				break;		
          }//end switch
 		} catch (e) {
			if (e == "[object Error]") {
			    ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}finally{
			if (sAction == IBSEARCH_ASYNC10 || sAction == MODIFY03 || sAction == MODIFY04) {
				return;
			}
			ComOpenWait(false); //->waiting->End
		}
     }
    /**
     * calling function when occurring OnSearchEnd Event <br>
     */ 		
	function sheet1_OnSearchEnd(sheetObj, errMsg){    	 
    	var sCols="prc_ctrt_cust_tp_cd";
    	searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value); 
		buttonControl();
	}	
     /**
     * calling function when occurring OnChange Event <br>
     * showing message when changing Customer Type <br>
     */       
     function sheet1_OnChange(sheetObj, Row, Col)
     {
         var colName=sheetObj.ColSaveName(Col);
         var formObj=document.form;
         var parentSheet=opener.sheetObjects[0];
         switch(colName)
         {
             case "prc_ctrt_cust_tp_cd":
  				if (!getValidRowCount(sheetObj) < 2){
  					if (parentSheet.GetCellValue(1, "ori_real_cust_cd") !=""
  						&& parentSheet.GetCellValue(1, "ori_real_cust_seq") != ""
  		        			&& window.dialogArguments.document.form.prop_no.value != "" ){
  		        		ComShowCodeMessage("PRI01079");
  		        		sheetObj.SetCellValue(Row,Col,"N",0);
  		        		return;
  		        	}  					
  					if (checkCustomerType() == 'Y'){
  						ComShowCodeMessage('PRI01111');
	  	            }
  				}   
                 break;      
         }
     }       
     /**
     * calling function when occurring OnSaveEnd event  <br>
     * setting edit column after saving<br>
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			parent.comUpdateProposalStatusSummary("07", "");
//			rData = sheetObjects[0].CellValue(sheetObjects[0].RowCount,"prc_ctrt_cust_tp_cd");
			rData="Y";
		}
	}    
     /**
     * calling function when occurring OnSelectCell Event <br>
     */        	
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
         if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
         }
  	}      
   /**
    * button authority control function <br>
    */
    function buttonControl(){
   			var formObj=document.form;
   			var reqUsrFlg=formObj.req_usr_flg.value;
   			var aproUsrFlg=formObj.apro_usr_flg.value;
   			var amdt_seq=formObj.amdt_seq.value;
   			var sts=formObj.prop_sts_cd.value;
			if(amdt_seq == 0) {
   				hiddenButton("btn_Amend");
   				hiddenButton("btn_AmendCancel");
   			} else {
   				showButton("btn_Amend");
   				showButton("btn_AmendCancel");	
   			}	
   			if (aproUsrFlg == "false" && reqUsrFlg == "false"){
   				ComBtnDisable("btn_Save");
   				ComBtnDisable("btn_Amend");
   				ComBtnDisable("btn_AmendCancel");
   				ComBtnDisable("btn_Accept");
   				ComBtnDisable("btn_AcceptCancel");
				for (var i=1; i <= sheetObjects[0].RowCount();i++){
					sheetObjects[0].SetCellEditable(i,"prc_ctrt_cust_tp_cd",0);
				}	
   				return;
   			}
   			try{
   				switch(sts) { 				
   					case 'I':   // Initial										
   						ComBtnDisable("btn_Accept");
   						ComBtnDisable("btn_AcceptCancel");
   						for (var i=1; i <= sheetObjects[0].RowCount();i++){
   							if (sheetObjects[0].GetCellValue(i, "prc_prog_sts_cd")=="I"){
   								sheetObjects[0].SetCellEditable(i,"prc_ctrt_cust_tp_cd",1);
   							}else{
   								sheetObjects[0].SetCellEditable(i,"prc_ctrt_cust_tp_cd",0);
   							}
   						}	
   						break;
   					case 'A': 
   						ComBtnDisable("btn_Save");
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");   						
   						ComBtnDisable("btn_Accept");
   						ComBtnDisable("btn_AcceptCancel");   					
   						break;   						
   					case 'Q':						
   						ComBtnDisable("btn_Save");
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");
   						if (aproUsrFlg == "true"){
   							ComBtnEnable("btn_Accept");
   							ComBtnEnable("btn_AcceptCancel");
   						}else{
   							ComBtnDisable("btn_Accept");
   							ComBtnDisable("btn_AcceptCancel");							
   						}
   						for (var i=1; i <= sheetObjects[0].RowCount();i++){
   							sheetObjects[0].SetCellEditable(i,"prc_ctrt_cust_tp_cd",0);
   						}						
   						break;
   					case 'R':  // Returned
   						ComBtnDisable("btn_Save");
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");   						
   						if(reqUsrFlg == "true"){
   							ComBtnDisable("btn_Accept");
   							ComBtnDisable("btn_AcceptCancel");
   						}   						
   						if (aproUsrFlg == "true"){
   							ComBtnEnable("btn_Accept");
   							ComBtnEnable("btn_AcceptCancel");
   						}
   						for (var i=1; i <= sheetObjects[0].RowCount();i++){
   							sheetObjects[0].SetCellEditable(i,"prc_ctrt_cust_tp_cd",0);
   						}
   						break;
   					case 'F': // Filed
   						ComBtnDisable("btn_Save");
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");   						
   						ComBtnDisable("btn_Accept");
   						ComBtnDisable("btn_AcceptCancel");
   						break;
   					case 'C': //  // Cancled
   						ComBtnDisable("btn_Save");   						
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");   						
   						ComBtnDisable("btn_Accept");
   						ComBtnDisable("btn_AcceptCancel");
   						break;
   					default:
   	    				showButton("btn_Amend");
   	    				showButton("btn_AmendCancel");
   	    				ComBtnEnable("btn_Accept");
   	    				ComBtnEnable("btn_AcceptCancel");
   						break;
   				} 		
   		} catch (e) {
   			if (e == "[object Error]") {
   				ComShowMessage(OBJECT_ERROR);
   			} else {
   				ComShowMessage(e.message);
   			}
   		}
   	}   
   /**
    * checking validation process of inputed form data <br>
    */
     function validateForm(sheetObj,formObj,sAction){
  		switch (sAction) {
  			case IBSEARCH: // retrieve
  				if (formObj.amdt_seq.value == "" || formObj.prop_no.value == "") {
  					return false;
  				}
  				break;  				
  			case IBSAVE: // save
  				if (formObj.amdt_seq.value == "" || formObj.prop_no.value == "") {
  					return false;
  				}
  				if (sheetObj.IsDataModified()!= true){
  					return false;
  				}  				
  				break;	  				
  		}
  		return true;
   }
/**
 * checking Customer Type change <br>
 */    
 function checkCustomerType(){
     var formObj=document.form;
     var sheetObj=sheetObjects[0];
     var rValue="N";
     var custTpOri=sheetObj.GetCellValue(1, "prc_ctrt_cust_tp_cd");
     if (custTpOri != sheetObj.GetCellValue(2, "prc_ctrt_cust_tp_cd")){
     	rValue="Y"
     }
     return rValue;     
 }           
