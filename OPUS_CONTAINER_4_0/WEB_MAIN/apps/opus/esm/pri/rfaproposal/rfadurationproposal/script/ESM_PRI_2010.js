/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2010.js
*@FileTitle  : Duration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/
 // Common Global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var rData="N";
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return N/A
  * @author 
  * @version 2009.04.17
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
     /**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
     * registering IBCombo Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory IBCombo Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
  	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);             
         }
 	    //IBMultiCombo Initialization
 	     for(var k=0; k < comboObjects.length; k++){
 	         initCombo(comboObjects[k], k + 1);
 	     }
 	     doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10); 	   
// 	     var formObj=document.form;
  	     var svcScpCd=document.form.svc_scp.value;
  	     if (svcScpCd != "" && svcScpCd != null &&  svcScpCd !="null" ){
  		     if (comboObjects[0].GetItemCount() > 0 ){
  		    	comboObjects[0].SetSelectText(svcScpCd, false);
      			 svc_scp_cd_OnBlur(comboObjects[0])  
  		     }
  	     }else{
  		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
  	     }
     }
   	/**
   	 * Implementating body TAG's unonLoad event handler<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *     unloadPage();
   	 * </pre>
   	 * @return N/A
   	 * @author 
   	 * @version 2009.08.17
   	 */      
 	 function unloadPage(){
 		 window.returnValue=rData;
 	 }     
     /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var amdt_seq=document.form.amdt_seq.value;
         var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {
                 var HeadTitle="|sel|propno|amdtseq|Duration|Duration|Effective Date|Expiry Date|Source|Source|Status|Status|||||||||";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                 var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);
                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_eff_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 if (amdt_seq == "0"){
                	 cols.push({Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_exp_dt",         KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                 }else{
                	 cols.push({Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_exp_dt",         KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 }
                 cols.push({Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 });
                 cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mn_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mn_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sp_dur_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sp_dur_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dur_dup_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 InitColumns(cols);
                 SetEditable(1);
                 SetWaitImageVisible(0);
                 SetCountPosition(0);
                 SetColHidden("chk",1);
                 resizeSheet(); //SetSheetHeight(95);
                }
                 break;
         }
     }
     
     function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
 
     /**
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj, 1);
     * </pre>
     * @param {ibcombo} sheetObj Mandatory IBSheet Object
     * @param {int} ComboNo Mandatory IBCombo Object Tag's ID Serial No
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
  	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "svc_scp_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	                SetUseAutoComplete(1);
//no support[check again]CLT 	            	IMEMode=0;
	                ValidChar(2);
	            	SetMaxLength(3);
	            }
	            break;
	    }
	}      
     /**
      * Handling Sheet's process <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {form} formObj Mandatory html form object
      * @param {int} sAction Mandatory ,process constant variable
      * @return N/A
      * @author 
      * @version 2009.04.17
      */
      function doActionIBSheet(sheetObj,formObj,sAction) {
    	  try{
              switch(sAction) {
              case IBSEARCH_ASYNC10: // Retrieving service scope when loading screen
  				comboObjects[0].RemoveAll();
  				formObj.f_cmd.value=COMMAND37;
  				var sParam=FormQueryString(formObj) + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value;
  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
 				sheetObj.SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
 				//	status
 				sheetObj.SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
  				break;
              case IBSEARCH:      
              	ComOpenWait(true); //->waiting->start
  				if (!validateForm(sheetObjects[0],document.form,sAction)) {
  					ComShowCodeMessage('PRI08001');
  					return false;
  				}				
  				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESM_PRI_2010GS.do", FormQueryString(formObj) );
  				ComOpenWait(false); //->waiting->End
  				
  				break;
   			 case IBSAVE:        	
   			 	 ComOpenWait(true); //->waiting->start
  	             if ( !ComPriConfirmSave()) {
  	                 return false;
  	             }  			 	
   			 	var scpName=ComTrim(formObj.svc_scp_nm.value);
   			 	var pRow = getValidRowCount(sheetObj);
   			 	var msgChk=false;
   			 	var sParamSheet=sheetObjects[0].GetSaveString();
   			 	if (!sheetObj.IsDataModified()&& sParamSheet==""){
   			 		ComShowCodeMessage("PRI00301");   			 		
   			 		return false;
   			 	}
   			 	if (sParamSheet == ""){
   			 		return false;
   			 	}
   			 	if (sheetObj.GetCellValue(pRow, "ctrt_exp_dt") < sheetObj.GetCellValue(pRow, "eff_dt") ){
  			 		ComShowCodeMessage("PRI01104");
  			 		return false;
  			 	}
   			 	var sParam="";
   			 	var sXml="";
   			 	var scpSave="";
   			 	if (scpName == ""){
   			 		if (formObj.amend_flg.value !="N"){
   	  			 		formObj.f_cmd.value=SEARCH01;
   	  			 		sParam=FormQueryString(formObj)+"&ctrt_exp_dt="+sheetObj.GetCellValue(sheetObj.RowCount(),"ctrt_exp_dt");
   	  			 		if ( pRow == "2"){
   	  	 					//Retrieving scope with main DURATION=EXPIRE DATE
   	  			 			sXml=sheetObj.GetSearchData("ESM_PRI_2010GS.do", sParam);
   	  	 					var arrData=ComPriXml2Array(sXml, "chk_dur");
   	  	 					if (arrData != null && arrData.length > 0) {
   	  	 						if (arrData.length == 2){
   	  	 							//cancelling to save all if user cancel in case of stoping extending scope duration
   	  	 							if (!ComShowCodeConfirm("PRI01109")){
   	  	 								ComShowCodeMessage("PRI01026");
   	  	 								return ;
   	  	 							}else{
   	  	 								scpSave="&scp_save=true"
   	  	 							}
   	  	 						}else{
   	  	 							//cancelling to save all if user cancel in case of stoping extending scope duration
   	  	 							if (arrData[0]=="DECREASE"){
   	  	 								if (!ComShowCodeConfirm("PRI01109")){
   	  	 	 								ComShowCodeMessage("PRI01026");
   	  	 	 								return ;
   	  	 								} 								
   	  	 								scpSave="&scp_save=true"
   	  	 							}else{
   	  	 								if (!ComShowCodeConfirm("PRI01109")){
   	  	 									//Extending proposal duration if user cancel in case of extending scope duration automatically
   	  	 									//proposal duration만 늘린다.
   	  	 									scpSave="&scp_save=false"
   	  	 									msgChk=true;	
   	  	 								}else{  	  	 								
   	  	 									scpSave="&scp_save=true"
   	  	 								}
   	  	 							}						
   	  	 						}
   	  	 					} 	
   	  					}
   			 		}
   			 	}else{
   			 		if (sheetObj.GetCellValue(pRow,"ctrt_exp_dt") > sheetObj.GetCellValue(pRow,"sp_dur_exp_dt")){
   			 			ComShowCodeMessage("PRI01003",ComGetMaskedValue(sheetObj.GetCellValue(pRow,"sp_dur_eff_dt"),"ymd","-"),ComGetMaskedValue(sheetObj.GetCellValue(pRow,"sp_dur_exp_dt"),"ymd","-"),"RFA");
  						return false;
  					}
  					scpSave="&scp_save=expchange"
   			 	}
     			formObj.f_cmd.value=MULTI;
     			sParam=FormQueryString(formObj)+ scpSave;
     			sParamSheet=sheetObjects[0].GetSaveString();
     			sXml=sheetObj.GetSaveData("ESM_PRI_2010GS.do", sParam + "&" + sParamSheet);
   				if (msgChk == true && scpName ==""){
     				ComShowCodeMessage("PRI01077");
     			}
   				sheetObj.LoadSaveData(sXml);
   				ComOpenWait(false); //->waiting->End
                 break;
   			 case MODIFY01:        //accept
			 	 ComOpenWait(true); //->waiting->start   			 
   			 	var scpName=ComTrim(formObj.svc_scp_nm.value);
   			 	if (!ComShowCodeConfirm("PRI00008")) {
  	            	return false;
  	            }  		
   			 	/////////////////////////////////////////////////////////////////
   			 	if (!acceptValidation(sheetObj,formObj)) {
   			 		return false;
   			 	}
   			 	////////////////////////////////////////////////////////////////
   	  			if (scpName == ""){
   	  			    //Retrieving scope with same main's expire date
   	  				aData=checkAutoChangeAcceptData();
 	   		       if (aData != null && aData.length > 0) {
 	  	  				if (ComShowCodeConfirm("PRI01112")) {	  	  			 	
 	  	  				    formObj.scp_accept.value="Y"; 	  				    
 	  	 	            }	   		    	   
 	   		       }  	
   			 	}
  				formObj.f_cmd.value=MODIFY01;
  				var rVal=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2010GS.do");
  				if (rVal){
  					if (formObj.scp_accept.value == "Y"){
   	  				    formObj.scp_accept.value="";
  					} 					
  				} 				
  				ComOpenWait(false); //->waiting->End
  				break;		
   			 case MODIFY02:        //accept cancel
			 	 ComOpenWait(true); //->waiting->start
  	            if (!ComShowCodeConfirm("PRI00009")) {
  	            	return false;
  	            } 			 
  				formObj.f_cmd.value=MODIFY02;
  				var rVal=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2010GS.do");
  				ComOpenWait(false); //->waiting->End
  				break;		
   			 case MODIFY03:        //amend
  				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
  				if(chkArr.length > 0){
  					if(chkArr.length > 1){					
  						ComShowCodeMessage("PRI00310");
  					}else{						
  						sheetAmendRow(sheetObj,formObj,chkArr[0],"M", "ctrt_exp_dt");						
  					}
  				}else{ 					
  					sheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "ctrt_exp_dt");
  				}
   			    sheetObj.SelectCell(2,"ctrt_exp_dt");
   			    formObj.amend_flg.value="Y";
  				break;	 	
   			 case MODIFY04:        //amend cancel
  				if (!validateForm(sheetObjects[0],document.form,sAction)) { 					
  					return false;
  				}	
   			 	var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
  				if(chkArr.length > 0){
  					if(chkArr.length > 1){					
  						ComShowCodeMessage("PRI00310");
  					}else{
  						sheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "ctrt_exp_dt");		
  					}
  				}else{ 
  					sheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "ctrt_exp_dt");
  				}	
   			 	formObj.amend_flg.value="N";
  				break;
             }    		  
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
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,process constant variable
     * @returns bool <br>
     *          true  : Valid<br>
     *          false : Invalid
     * @author 
     * @version 2009.04.17
     */
      function validateForm(sheetObj,formObj,sAction){
   			switch (sAction) {
	  			case IBSEARCH: 
	  				if (formObj.amdt_seq.value == "" || formObj.prop_no.value == "") {
	  					return false;
	  				}
	  				break;
	  			case MODIFY04: // AMEND CANCEL
	  				if (formObj.amdt_seq.value == "" || formObj.prop_no.value == "") {
	  					return false;
	  				}	  				
	  				var formObj=document.form;
	  				var scpName=ComTrim(formObj.svc_scp_nm.value);
	  				if (scpName !=""){
	  					return true;
	  				}
	  				if (sheetObj.GetSelectRow()== 2){
		  				document.form.f_cmd.value=SEARCH02;
			  		    var sParam=FormQueryString(document.form);
			  		    var sParamSheet=sheetObjects[0].GetSaveString(true);
			  		    var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2010GS.do", sParam+"&"+sParamSheet);
			  		    var arrData=ComPriXml2Array(sXml, "svc_scp_cd");
			  		    if (arrData != null && arrData.length > 0) {
			  		    	ComShowCodeMessage("PRI01075", arrData[0][0]);
			  		    	return false;
			  		    }
	  				}	  			
	  				break;	  				
	  			case IBSAVE: 
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
   * Calling function in case of Onchange Event <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
   * @param {int} code Mandatory
   * @param {int} text Mandatory
   * @return N/A
   * @author 
   * @version 2009.04.17
   */  	
 	function svc_scp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
  		var formObj=document.form;
//  		var arrText=text.split("|");
//  		if (arrText != null && arrText.length > 1) {
  			formObj.svc_scp_nm.value=comboObj.GetSelectCode();
  			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//  		}
  	}           
   /**
    * svc_scp_cd IBMulti Combo's onBlur event<br>
    * Setting Combo의 text to Html Object,Retrieving by modified scope<br>
    * <br><b>Example :</b>
    * <pre>
    *    ssvc_scp_cd_OnBlur(comboObj);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 	    
    function svc_scp_cd_OnBlur(comboObj) {
		var formObj=document.form;		
		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != null && code != "") {
			var text=comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		}
	}          
    /**
     * calling function in case of OnSearchEnd event <br>
     * Setting value of Sheet to Html Object and setting Font Style
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory from server
     * @return N/A
     * @author 
     * @version 2009.05.20
     */ 		
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var amdt_seq=document.form.amdt_seq.value;
		var formObj=document.form;
		var maxRow=sheetObj.RowCount();
		//Setting main eff_dt,exp_dt
		if (sheetObj.RowCount()> 0){
			formObj.eff_dt.value=sheetObj.GetCellValue(maxRow,"mn_eff_dt");
			formObj.exp_dt.value=sheetObj.GetCellValue(maxRow,"mn_exp_dt");
			formObj.pre_exp_dt.value=ComGetDateAdd(sheetObj.GetCellValue(maxRow,"mn_eff_dt"), "D", -1);
		}
        var sCols="ctrt_exp_dt";
        searchEndFontChange(sheetObj, sCols);
        buttonControl();
	}

     /**
     * Calling function in case of OnSaveEnd Event <br>
     * Setting update flag to "Y" after saving <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory from server
     * @return N/A
     * @author 
     * @version 2009.04.17
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			 rData="Y";
			 ComOpenWait(true);
			 if(!opener) opener=parent;
			 opener.setReturnValue(rData);
			 ComOpenWait(false);
			 ComClosePopup();
		}
	}        
     /**
     * Calling function in case of Onchange Event <br>
     * Validating Sheet's "ctrt_exp_dt" column <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.04.17
     */       
  	function sheet1_OnChange(sheetObj, Row, Col)
 	{
 		var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
       	switch(colName)
       	{
   	    	case "ctrt_exp_dt":
   	    		if (sheetObj.GetCellValue(Row, "ctrt_eff_dt") >= sheetObj.GetCellValue(Row, "ctrt_exp_dt") ){
   	    			ComShowCodeMessage("PRI01024");
   	    			sheetObj.SetCellValue(Row,"ctrt_exp_dt","",0);
   	    			sheetObj.SelectCell(Row,"ctrt_exp_dt");
   	    			break;
   	    		}else{
   	    			sheetObj.SetCellValue(Row,"exp_dt",sheetObj.GetCellValue(Row, "ctrt_exp_dt"),0);
   	    		}
   	    		if (sheetObj.GetCellValue(Row, "ctrt_exp_dt") < sheetObj.GetCellValue(Row, "eff_dt") ){
			 		ComShowCodeMessage("PRI01104");			 		
			 		sheetObj.SelectCell(Row,"ctrt_exp_dt");
   			 	}
   	    		break; 
       	   }
 	  }        
     /**
      * Calling function in case of OnSelectCell event <br>
      * <br><b>Example :</b>
      * <pre>
      *		
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} OldRow Mandatory previous Selected Cell's Row Index
      * @param {int} OldCol Mandatory previous Selected Cell's Column Index
      * @param {int} NewRow Mandatory current Selected Cell's Row Index
      * @param {int} NewCol Mandatory current Selected Cell's Column Index
      * @return N/A
      * @author 
      * @version 2009.04.17
      */        	
   	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
          if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
          }
   	}       
//	/**
//    * Calling function on parent screen <br>
//    * Modifying term's summary table by calling a funciton of parent screen in case of modifying data
//    * <br><b>Example :</b>
//    * <pre>
//    * buttonControl()
//    * </pre>
//    * @param N/A
//    * @return N/A
//    * @author 
//    * @version 2009.04.17
//    */ 
//	function updateProposalStatusSummary(){
//		 var scpCd = ComTrim(comboObjects[0].Code);
//		 if (scpCd ==""){
//			 dialogArguments.comUpdateProposalStatusSummary("01", "");
//		 }else{
//			 dialogArguments.comUpdateProposalStatusSummary("11", scpCd);
//		 }
//	}
	/**
     * Controlling authority of button<br>
     * <br><b>Example :</b>
     * <pre>
     * buttonControl()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
     function buttonControl(){
			var formObj=document.form;
			var req_usr_flg=formObj.req_usr_flg.value;
			var apro_usr_flg=formObj.apro_usr_flg.value;
			var amdt_seq=formObj.amdt_seq.value;
			var sts=formObj.prop_sts_cd.value;
			var eRowIdx = sheetObjects[0].LastRow();
			if (apro_usr_flg == "false" && req_usr_flg == "false"){
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Amend");
				ComBtnDisable("btn_AmendCancel");
				ComBtnDisable("btn_Accept");
				ComBtnDisable("btn_AcceptCancel");
				for (var i=1; i <= sheetObjects[0].RowCount();i++){
					sheetObjects[0].SetCellEditable(i,"ctrt_exp_dt",0);
				}	
				return;
			}
			if(amdt_seq == 0) {
				hiddenButton("btn_Amend");
				hiddenButton("btn_AmendCancel");
			} else {
				showButton("btn_Amend");
				showButton("btn_AmendCancel");	
			}	
			
			//activate for ctrt_exp_dt field
			for (var i=1; i <= eRowIdx;i++){
				var srcInfoCd = sheetObjects[0].GetCellValue(i, "src_info_cd");
				var prcProgStsCd = sheetObjects[0].GetCellValue(i, "prc_prog_sts_cd");
				if(sts == "I" && srcInfoCd=="AM" && prcProgStsCd=="I"){
					sheetObjects[0].SetCellEditable(i,"ctrt_exp_dt",1);
				} else {
					sheetObjects[0].SetCellEditable(i,"ctrt_exp_dt",0);
				}
			}
			
			try{
				switch(sts) { 				
					case 'I':   // Initial								
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						break;
					case 'A': // Disable  Approval
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");						
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						break;
					case 'Q':// Requested  : approver can modified in case of C/Offer
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
						}else{
							ComBtnDisable("btn_Accept");
							ComBtnDisable("btn_AcceptCancel");							
						}						
						break;
					case 'R':  // Returned
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");						
						if(req_usr_flg == "true"){
							ComBtnDisable("btn_Accept");
							ComBtnDisable("btn_AcceptCancel");
						}
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
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
//     /**
//     * Checking if Main Duration  exp_dt< Scope's exp_dt <br>
//     * Disable to save in case of Return ="Y"
//     * <br><b>Example :</b>
//     * <pre>
//     *         checkScopeDuration
//     * </pre>
//     * @param N/A
//     * @return {string} <br>
//     *                   Y : Main Duration  exp_dt< Scope's exp_dt
//     *                   N : Main Duration  exp_dt> Scope's exp_dt
//     * @author 
//     * @version 2009.04.17
//     */     
//    function checkScopeDuration(){
//       document.form.f_cmd.value = SEARCH03;
//       var rMsg = "";
//       var rValue = "Y"; //Prohibiting from saving
//       var sParam = FormQueryString(document.form);
//       var sParamSheet = sheetObjects[0].GetSaveString();
//       
//       var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2010GS.do",  sParam+"&"+sParamSheet);
//       var arrData = ComPriXml2Array(sXml, "cnt");
//       
//       if (arrData != null && arrData.length > 0) {
//           if (arrData[0][0] == "0"){
//               rValue = "N";
//           } 
//       }
//       if (rValue =="Y"){
//           ComShowCodeMessage("PRI01083");
//       }
//       return rValue;
//    }    
    /**
    * Amending row<br>
    * sheetObj    : sheet object
    * formObj     : form object
    * sRow        :  Row
    * sAction     : M : Update Amend, D : Delete Amend
    * sCols       : column to be copied except n1st_cmnc_dt, src_info_cd, prc_prog_sts_cd. combination with "|" delimitor
    *          ex) comSheetAmendRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
    * @return {string}
    * @author 
    * @version 2009.05.29
    */
   function sheetAmendRow(sheetObj,formObj,sRow,sAction, sCols){
       var prop_no=formObj.prop_no.value;
       var amdt_seq=formObj.amdt_seq.value;
       var pre_amdt_seq=formObj.pre_amdt_seq.value;
       var eff_dt=formObj.eff_dt.value;
       var exp_dt=formObj.exp_dt.value;
       var pre_exp_dt=formObj.pre_exp_dt.value;
       var arrCols=sCols.split("|");
       var dur_dup_flg=formObj.dur_dup_flg.value;
       sheetObj.SetCellValue(sRow,"chk",0);
       if(sheetObj.GetCellValue(sRow,"amdt_seq")!= amdt_seq || sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq")== amdt_seq){
           ComShowCodeMessage("PRI00313");
           return false;
       }
       // Setting sRow to set base old row
       sheetObj.SetSelectRow(sRow);
       var idx=sheetObj.DataCopy();     // new row
       var idx2=idx-1;                  // old row
       sheetObj.SetCellValue(idx,"eff_dt",eff_dt,0);
       sheetObj.SetCellValue(idx,"n1st_cmnc_amdt_seq",amdt_seq,0);
       sheetObj.SetCellValue(idx,"prc_prog_sts_cd","I",0);
       sheetObj.SetCellValue(idx,"src_info_cd","AM",0);
//       sheetObj.CellValue2(idx,"ibflag")="U";
       sheetObj.SetRowStatus(idx,"U");
       for(x=0;x<arrCols.length;x++){
           sheetObj.SetCellEditable(idx,arrCols[x],1);
       }
       sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
       sheetObj.SetCellFont("FontStrike", idx2, 1, idx2, sheetObj.LastCol(), true);
       if(dur_dup_flg=="Y"){
           sheetObj.SetCellValue(idx2,"exp_dt",pre_exp_dt,0);
       }
       sheetObj.SetCellValue(idx2,"amdt_seq",pre_amdt_seq,0);
       sheetObj.SetRowEditable(idx2,0);
       // Update new row in case of D, A
       if(sAction=="D"){
           sheetObj.SetCellValue(idx,"src_info_cd","AD",0);
           for(z=0;z<arrCols.length;z++){
               sheetObj.SetCellEditable(idx,arrCols[z],0);
           }
       }
       sheetObj.SetRowStatus(idx2,"R");// Changing old row's status to "R"
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
       return true;
   }
  /**
   * Handling Amend Cancel
   * sheetObj    : sheet object
   * formObj     : form object
   * sRow        : Row
   * sAction     : A : Insert Amend, M : Update Amend, D : Delete Amend
   * sCols       : column to be copied except n1st_cmnc_dt, src_info_cd, prc_prog_sts_cd. combination with "|" delimitor
   *           ex) sheetAmendCancelRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
   * @return {string}
   * @author 
   * @version 2009.05.29
   */
   function sheetAmendCancelRow(sheetObj,formObj,sRow,sAction, sCols){
	   var amdt_seq=formObj.amdt_seq.value;
       var eff_dt=formObj.eff_dt.value;
       var exp_dt=formObj.exp_dt.value;
       var arrCols=sCols.split("|");
       var pre_amdt_seq=formObj.pre_amdt_seq.value;
       var dur_dup_flg=formObj.dur_dup_flg.value;
       sheetObj.SetCellValue(sRow,"chk",0);
       if(sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
           ComShowCodeMessage("PRI00313");
           return false;
       }
       var idx=sRow-1;
       var idx2=sRow;
       if(sAction=="A"&&(sheetObj.GetCellValue(sRow,"src_info_cd")=="NW"||sheetObj.GetCellValue(sRow,"src_info_cd")=="GM"||sheetObj.GetCellValue(sRow,"src_info_cd")=="GC")){
//           sheetObj.CellValue(sRow,"ibflag")="D";
           sheetObj.SetRowStatus(sRow,"D");
           sheetObj.SetRowEditable(sRow,0);
           sheetObj.SetRowHidden(sRow,1);
           return false;
       }else{
    	   if(sheetObj.GetCellValue(sRow,"src_info_cd")!="AD"&&sheetObj.GetCellValue(sRow,"src_info_cd")!="AM"){
               ComShowCodeMessage("PRI01002");
               return false;
           }
    	   sheetObj.SetCellValue(idx,"exp_dt",sheetObj.GetCellValue(idx,"ctrt_exp_dt"),0);
    	   sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(), false);
    	   sheetObj.SetCellFont("FontItalic", idx, 1, idx, sheetObj.LastCol(),0);
    	   sheetObj.SetCellValue(idx,"amdt_seq",sheetObj.GetCellValue(idx2,"amdt_seq"),0);
           sheetObj.SetCellValue(idx2,"amdt_seq",pre_amdt_seq,0);
           sheetObj.SetRowEditable(idx,1);
           sheetObj.SelectCell(idx,"chk");
//           sheetObj.CellValue(idx,"ibflag")="U";
           sheetObj.SetRowStatus(idx,"U");
           sheetObj.RowDelete(idx2, false);
//           sheetObj.CellValue2(idx,"exp_dt") = sheetObj.CellValue(idx,"ctrt_exp_dt");           
//           sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol())=false;
//           sheetObj.CellFont("FontItalic", idx, 1, idx, sheetObj.LastCol())=false;
//           sheetObj.CellValue2(idx,"amdt_seq")= sheetObj.CellValue(idx2,"amdt_seq");
//           sheetObj.CellValue2(idx2,"amdt_seq")= pre_amdt_seq;
//           sheetObj.RowEditable(idx) = true;
//           sheetObj.CellValue(idx2,"ibflag")="D";
//           sheetObj.RowEditable(idx2)=false;
//           sheetObj.RowHidden(idx2) = true;
//           sheetObj.SelectCell(idx,"chk");
//           sheetObj.CellValue(idx,"ibflag")="U";
       }
       return true;
   }      
     /**
     * finding scope with same expire data when accepting Main Duration<br>
     * <br><b>Example :</b>
     * <pre>
     *         checkAutoChangeAcceptData();
     * </pre>
     * @param N/A
     * @return string  Scope code array with same Main' Expire date
     * @author 
     * @version 2009.04.17
     */     
   function checkAutoChangeAcceptData(){
       var formObj=document.form;
       var sheetObj=sheetObjects[0]
       var rValue="N";            
       formObj.f_cmd.value=SEARCH04;
       var sXml=sheetObj.GetSearchData("ESM_PRI_2010GS.do" , FormQueryString(formObj));
       var arrData=ComPriXml2Array(sXml, "cd");
       return arrData;      
   }      
   /**
    * Accept Validation
    * sheetObj    :  sheet object
    * formObj     :  form object
    *           ex) acceptValidation(sheetObjects[1],document.form);
    * @return {string}
    * @author 
    * @version 2009.05.29
    */
    function acceptValidation(sheetObj,formObj){
    	var amdt_seq=formObj.amdt_seq.value;
        var prop_sts_cd=formObj.prop_sts_cd.value;
        if(prop_sts_cd == "R") {
            var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
            if(chkArr.length == 0){
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
                chkArr[0]=sheetObj.GetSelectRow();
            }
            for(i=0;i<chkArr.length;i++){
            	if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="R" || sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                    sheetObj.SetCellValue(chkArr[i],"chk","0",0);
                    ComShowCodeMessage("PRI00313");
                    return false;
                }
            }
        } else {
	        var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")	
	        if(chkArr.length == 0){
	            sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
	            chkArr[0]=sheetObj.GetSelectRow();
	        }
	        for(i=0;i<chkArr.length;i++){
	        	if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I"){
	                sheetObj.SetCellValue(chkArr[i],"chk","0",0);
	                ComShowCodeMessage("PRI01037");
	                return false;
	            }
	        	if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
	                sheetObj.SetCellValue(chkArr[i],"chk","0",0);
	                ComShowCodeMessage("PRI00313");
	                return false;
	            }
	        }
	    }
	    return true;
    }