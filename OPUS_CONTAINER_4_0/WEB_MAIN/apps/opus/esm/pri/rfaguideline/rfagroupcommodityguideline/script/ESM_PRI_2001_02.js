/*=========================================================
*1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2001_02.js
*@FileTitle  : RFA Guideline Creation - Commodity Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group :business script for Commodity Group 
     */
    // Common Global Variable
    var sheetObjects=new Array();
 	var sheetCnt=0;
 	 var enableFlag=true;
 // Event handler processing by button click event*/
 	document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.04.16
     */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          var sheetObject3=sheetObjects[2];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case "btn_Save":				
					if (validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					break;	
				case "btn_downexcel":
					if (validateForm(sheetObject3,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
					}
					break;
				case "btn_Add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;					
				case "btn_Add2":
					doActionIBSheet(sheetObject2,formObject,IBINSERT);
					break;					
				case "btn_Del":			
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;					
				case "btn_Del2":			
					doActionIBSheet(sheetObject2,formObject,IBDELETE);
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
      * registering IBSheet Object as list <br>
      * adding process for list in case of needing batch processing with other items<br>
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
         resizeSheet();
         toggleButtons("CLEAR");
         parent.loadTabPage();
     }
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets  <br>
      * <br><b>Example :</b>
      * <pre>
      *     initSheet(sheetObj,1);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
      * @return N/A
      * @author 
      * @version 2009.04.17
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id; 		 
         switch(sheetID) {
             case "sheet1":
                 with(sheetObj){
		                 
		              var HeadTitle="|Sel.|Seq.|svcscpcd|glineseq|grp_cmdtseq|Group\nCode|Description";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                  {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd",    KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:5 },
		                  {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc",  KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:100, ExceptKeys:"[/]" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetShowButtonImage(2);
		              resizeSheet(); //SetSheetHeight(380);
              }
                 break;
             case "sheet2":
                 with(sheetObj){
		                 
		              var HeadTitle="|Sel.|Seq.|svcscpcd|glineseq|Commodity\nType|grpcmdtseq|grpcmdtdtlseq|Commodity\nCode" +
		              "|Description|cre_dt";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                  {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
		                  {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_cmdt_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_dtl_seq" },
		                  {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                  {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetColProperty("prc_cmdt_tp_cd", {ComboText:COMODITY_TYPE2[1] ,ComboCode: COMODITY_TYPE2[0]} );
		              SetShowButtonImage(2);
		              resizeSheet(); //SetSheetHeight(380);
              }
                 break;
             case "sheet3":
                 with(sheetObj){
	                
	             var HeadTitle="|Seq.|Group Code|Group Description|Code|Description";
	             var headCount=ComCountHeadTitle(HeadTitle);
	             (headCount, 0, 0, true);
	
	             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	              {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	              {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd" },
	              {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc" },
	              {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd" },
	              {Type:"Text",     Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm" } ];
	              
	             InitColumns(cols);
	
	             SetEditable(1);
	             SetWaitImageVisible(0);
	             SetSheetHeight(260);
             }
                 break;                 
         }
     }
     
     function resizeSheet() {
   	   	ComResizeSheet(sheetObjects[0]);
   		ComResizeSheet(sheetObjects[1]);
   	}
     
     /**
      * Handling sheet's processes <br>
      * <br><b>Example :</b>
      * <pre>
      *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {form} formObj Mandatory html form object
      * @param {int} sAction Mandatory ,Process Flag constant variable
      * @return N/A
      * @author 
      * @version 2009.04.17
      */
      function doActionIBSheet(sheetObj,formObj,sAction) {
    	  try {
	          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {		  		  		
	 				case IBSEARCH:      
						if (validateForm(sheetObj,document.form,sAction)) {
			  				ComOpenWait(true);
							sheetObjects[0].RemoveAll();
							sheetObjects[1].RemoveAll();
							formObj.f_cmd.value=SEARCH01;
							sheetObj.DoSearch("ESM_PRI_2001_02GS.do", FormQueryString(formObj) );
						} else {
							ComShowCodeMessage('PRI08001');
						}	 
	 					break;
	 				case IBSEARCHAPPEND: // Retrieving
						if (validateForm(sheetObj,document.form,sAction)) {
			  				ComOpenWait(true);
							formObj.f_cmd.value=SEARCH02;
							sheetObj.DoSearch("ESM_PRI_2001_02GS.do", FormQueryString(formObj) );
						}
						break;
	 				case IBSAVE:        
		 				if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
							return false;
						}
						if (!supressConfirm && !ComPriConfirmSave()) {
							return false;
						}
		  				ComOpenWait(true);
						formObj.f_cmd.value=MULTI;
						var sParam=FormQueryString(formObj);
						var sParamSheet1=sheetObjects[0].GetSaveString();
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
						var sParamSheet2=sheetObjects[1].GetSaveString();
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
						var sXml=sheetObj.GetSaveData("ESM_PRI_2001_02GS.do", sParam);
						sheetObjects[1].LoadSaveData(sXml);
						sXml=ComDeleteMsg(sXml);
						sheetObjects[0].LoadSaveData(sXml);
						if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
							return false;
						} else {
							if (getValidRowCount(sheetObjects[1]) <= 0) {
								doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), false);
							}
							parent.setTabStyle();
							return true;
						}
						break;
	 				case IBDOWNEXCEL:
	 					if (validateForm(sheetObj,document.form,sAction)) {
			  				ComOpenWait(true);
	 						formObj.f_cmd.value=SEARCH03;
	 						sheetObj.DoSearch("ESM_PRI_2001_02GS.do", FormQueryString(formObj) );
	 						//sheetObj.Down2Excel({ HiddenColumn:-1});
	 					} else {
	 						ComShowCodeMessage('PRI08001');
	 					}
	 					break;
					case IBINSERT:      
						if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
							return false;
						}
						if (sheetObj.id == "sheet1") {
							var idx=doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol, true);
							var maxCode=0;
							if (idx < 0) {
								return false;
							}
							sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
							sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value,0);
							sheetObjects[1].RemoveAll();
							sheetObj.SetCellValue(idx, "grp_cmdt_seq",parseInt(ComPriGetMax(sheetObj, "grp_cmdt_seq")) + 1,0);
							maxCode=parseInt(groupCodeGetMax(sheetObj, "prc_grp_cmdt_cd")) + 1;
							sheetObj.SetCellValue(idx,"prc_grp_cmdt_desc","Group "+ maxCode,0);
							maxCode=ComLpad(maxCode,   4, "0");
							sheetObj.SetCellValue(idx,"prc_grp_cmdt_cd","G"+ maxCode,0);
							sheetObj.SelectCell(idx, "prc_grp_cmdt_desc", false);
						}
						if (sheetObj.id == "sheet2") {
							var idx=sheetObj.DataInsert();
							sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
							sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value,0);
							var grp_cmdt_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_cmdt_seq");
							sheetObj.SetCellValue(idx, "grp_cmdt_seq",grp_cmdt_seq,0);
							sheetObj.SetCellValue(idx, "grp_cmdt_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_cmdt_dtl_seq")) + 1,0);
							sheetObj.SelectCell(idx, "prc_cmdt_def_cd", false);
						}
						break;	
					case IBDELETE: // Delete	
						if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
							return false;
						}				
			        	if (sheetObj.CheckedRows("chk") <= 0) {
			        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1",0);
			        	}
						if (sheetObj.id == "sheet1") {
							if(!checkUseDataExist(sheetObj, formObj)) {
								return false;
							}
						}
						if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
							sheetObjects[1].RemoveAll();
						}
			        	var delCnt=deleteRowCheck(sheetObj, "chk");
			        	if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
							sheetObjects[1].RemoveAll();
						}
						//checking in case of deleting all rows of DETAIL
						if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
							if(ComShowCodeConfirm('PRI00021')){
				  				ComOpenWait(true);
				  				//Unchecking checked data on MASTER
								sheetObjects[0].CheckAll("chk",0,1);
								//Checking in use on RATE screen.if yes, retrieving again
								if(!checkUseDataExist(sheetObjects[0], formObj)) {
									formObj.grp_cmdt_seq.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_cmdt_seq");
									doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
									return false;
								} else {								
									if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "chk") == "1") {
										sheetObjects[1].RemoveAll();
									}
									var delCnt=deleteRowCheck(sheetObjects[0], "chk");
											if (delCnt > 0 && sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) == "D") {
										sheetObjects[1].RemoveAll();
									}
								}
							}
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
   * Return false in case of using group code to be deleted in rate<br>
   * <br><b>Example :</b>
   * <pre>
   *     checkUseDataExist(sheetObj, formObj);
   * </pre>
   * @param {ibsheet} sheetObj Mandatory IBSheet Object
   * @param {form} formObj Mandatory html form object
   * @return boolean
   * @author 
   * @version 2010.02.16
   */
   	function checkUseDataExist(sheetObj, formObj) {
   		if (sheetObj.CheckedRows("chk") <= 0) {
   			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1",0);
       	}
   		var arrChecked=sheetObj.FindCheckedRow("chk").split("|");
		for (var i=0; arrChecked != null && i < arrChecked.length; i++) {
			if (arrChecked[i] == null || arrChecked[i] == "" || arrChecked == undefined) {
				continue;
			}
			formObj.f_cmd.value=SEARCH11;
			var sParam=FormQueryString(formObj) + "&prc_grp_cmdt_cd=" + sheetObj.GetCellValue(arrChecked[i], "prc_grp_cmdt_cd");
			var sXml=sheetObj.GetSearchData("ESM_PRI_2001_02GS.do", sParam);
			var arrTemp=ComPriXml2Array(sXml, "etc1");
			if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
				var cntInUse=parseInt(arrTemp[0][0]);
				if (cntInUse > 0) {
					ComShowCodeMessage("PRI08017");
					return false;
				}
			} else {
				return false;
			}
		}
   		return true;
   	}
  /**
   * Calling Function in case of OnBeforeCheck event <br>
   * for all check of sheet1<br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
   * @param {int} Row Mandatory Onclick ,Cell's Row Index
   * @param {int} Col Mandatory Onclick ,Cell's Column Index
   * @return N/A
   * @author 
   * @version 2009.05.19
   */	
  	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
    /**
    * Calling Function in case of OnBeforeCheck event <br>
    * for all check of sheet2<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.19
    */
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}      
    /**
     * Calling Function in case of OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} OldRow Mandatory ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory ,current selected cell's Row Index
     * @param {int} NewCol Mandatory ,current selected cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.04.17
     */  	
 	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol, flag)  {
 		if(flag == undefined){
 			doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
 		}
 		//sheet2.RemoveAll();
 	}
    /**
    * Calling Function in case of OnChange event <br>
    * showing Description<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory ,Cell's Value
    * @return N/A
    * @author 
    * @version 2009.04.17
    */  	
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {
    	var colname=sheetObj.ColSaveName(Col);
    	var formObj=document.form
    	switch(colname)
    	{
	    	case "prc_cmdt_def_cd":	    		
	    		if (Value.length==6){
	    			formObj.f_cmd.value=SEARCH08;
	    			formObj.cd.value=Value;
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != ""){
  						sheetObj.SetCellValue(Row,"loc_des",arrData[1],0);
  						sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","C",0);
  					}else{
  						sheetObj.SetCellValue(Row,"loc_des","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
  					}	  				
	    		} else if (Value.length==4){
	    			formObj.f_cmd.value=COMMAND29;
	    			formObj.cd.value=Value;
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != ""){
  						sheetObj.SetCellValue(Row,"loc_des",arrData[1],0);
  						sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","R",0);
  					}else{
  						sheetObj.SetCellValue(Row,"loc_des","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
  					}	  				
	    		} else {	  
	    			sheetObj.SetCellValue(Row,"loc_des","",0);
  					sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
  					sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","",0);
  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
	    		}
	    		break;
    	}
    }    		
    /**
    * Calling Function in case of OnPopupClick event <br>
    * Calling Location PopUp <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
    * @param {int} Col Mandatory OnPopupClick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.07
    */  	      	 
	function sheet2_OnPopupClick(sheetObj, Row, Col)
	{
    	var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		var tpCd="C";
		var prcCmdtTpCd=sheetObj.GetCellValue(Row,"prc_cmdt_tp_cd");
		if (colName == "prc_cmdt_def_cd"){
			var sUrl="/opuscntr/ESM_PRI_4027.do?prc_cmdt_tp_cd="+ prcCmdtTpCd + "&commodity_cmd=CR&grp_cd="+PRI_RG;
			ComOpenPopup(sUrl, 700, 345, "findCommodity", "1,0,1,1,1,1,1", true);
		}
	}
	
	function findCommodity(rtnVal){
		var formObj = document.form;
		var sheetObj=sheetObjects[1];
		
		if (rtnVal != null){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol() + 1,rtnVal.nm,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prc_cmdt_tp_cd",rtnVal.tp,0);
		}
	}
	
	var isFiredNested=false;
	var supressConfirm=false;
   /**
    * Calling funciton in case of clicking sheet's row<br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM Mandatory HTMLtag(Object) Object
    * @param {ibsheet} sheetD Mandatory HTMLtag(Object) Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @param {string} appendRow Mandatory 
    * @return N/A
    * @author 
    * @version 2009.05.19
    */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested=true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (sheetD.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				var rslt=false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm=true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
					var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm=false;
				}
				if (rslt) {
					isFiredNested=true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (appendRow) {
				isFiredNested=true;
				var idx=sheetM.DataInsert();
				isFiredNested=false;
				return idx;
			} else {
				formObj.grp_cmdt_seq.value=sheetM.GetCellValue(adjNewRow, "grp_cmdt_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
		}
	}   
    /**
    * handling process for input validation <br>
    * <br><b>Example :</b>
    * <pre>
    *     if (validateForm(sheetObj,document.form,IBSAVE)) {
    *         handling logic;
    *     }
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,Process Flag constant variable
    * @returns bool <br>
    *          true  : valid<br>
    *          false : invalid
    * @author 
    * @version 2009.04.17
    */
     function validateForm(sheetObj,formObj,sAction){
  		switch (sAction) {
			case IBSEARCH: // Retrieving
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
 	     			if (ComShowCodeConfirm("PRI00006")) {
 	     				doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 	     				return false;
	 	     		}
				}
				break;
			case IBSEARCHAPPEND: // Retrieving
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;				
			case IBDOWNEXCEL: // Excel Download
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;		
			case IBSAVE: // Saving
				if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
					if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
						return false;
					}
					if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
						return false;
					}	
					if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
						&& getValidRowCount(sheetObjects[1]) <= 0) {
						ComShowCodeMessage("PRI00319", "Commodity Group");
						return false;
					}
					var rowM=sheetObjects[0].ColValueDup("prc_grp_cmdt_cd", false);
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet1", rowM);
						return false;
					}					
					var rowD=sheetObjects[1].ColValueDup("prc_cmdt_tp_cd|grp_cmdt_seq|prc_cmdt_def_cd", false);
					if (rowD >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet2", rowD);
						return false;
					}					
				} else {
					ComShowCodeMessage("PRI00301");
					return false;
				}	
				break;
			case IBINSERT: // Row Add
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				if (sheetObj.id == "sheet2" && getValidRowCount(sheetObjects[0]) == 0) {
					ComShowCodeMessage("PRI01004");
					return false;					
				}
				break;
			case IBDELETE: // Delete
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				if (getValidRowCount(sheetObj) == 0) {
					return false;					
				}
				break;
		}
  		return true;
     }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj=document.form;
		if( sheetObj.SearchRows()> 0){
			document.form.yn_data.value="Y"
		}else{
			document.form.yn_data.value="N"
		}
	}   
    /**
     * Calling function in case of OnSaveEnd event <br>
     * showing message in case of sucessful saving <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2009.06.22
     */ 
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)
	{
		//Sorting
		sheetObjects[1].ColumnSort("prc_cmdt_tp_cd|prc_cmdt_def_cd","DESC","DESC|ASC");
		if( sheetObj.RowCount()> 0){
			document.form.yn_data.value="Y"
		}else{
			document.form.yn_data.value="N"
		}
		parent.setTabStyle();
	}    
    /**
    * Getting Max value<br>
    *
    * @param {object} sheetObj Mandatory, IBSheet Object.
    * @param {string} sCol Mandatory,
    * @return int Max
     * @author 
     * @version 2009.04.22
    */
	 function groupCodeGetMax(sheetObj, sCol) {
       var max=0;
       for (var i=0; i <= sheetObj.RowCount(); i++) {
    	   if (parseInt(sheetObj.GetCellValue(i, sCol).substr(1,4),10) > max) {
    		   max=parseInt(sheetObj.GetCellValue(i, sCol).substr(1,4),10);
           }
       }
       return max;
    }	
    /**
     * controlling buttons <br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {string} mode setting value
     * @return N/A
     * @author 
     * @version 2009.05.22
     */	
 	function toggleButtons(mode) {
 		switch (mode) {
 		case "CLEAR":
 			ComBtnDisable("btn_Retrieve");
 			ComBtnDisable("btn_Save");
 			ComBtnDisable("btn_downexcel");
 			ComBtnDisable("btn_Add");
 			ComBtnDisable("btn_Add2");
 			ComBtnDisable("btn_Del");
 			ComBtnDisable("btn_Del2");
 			break;
 		case "INIT":
 			ComBtnEnable("btn_Retrieve");
 			ComBtnEnable("btn_Save");
 			ComBtnEnable("btn_downexcel");
 			ComBtnEnable("btn_Add");
 			ComBtnEnable("btn_Add2");
 			ComBtnEnable("btn_Del");
 			ComBtnEnable("btn_Del2");
 			break;
 		case "READONLY":
 			ComBtnEnable("btn_Retrieve");
 			ComBtnDisable("btn_Save");
 			ComBtnEnable("btn_downexcel");
 			ComBtnDisable("btn_Add");
 			ComBtnDisable("btn_Add2");
 			ComBtnDisable("btn_Del");
 			ComBtnDisable("btn_Del2");
 			break;
 		}
 	}
    /**
    * Calling function in case of clicking a tab on parent screen<br>
    * <br><b>Example :</b>
    * <pre>
    * tabLoadSheet("ACE", "1")
    * </pre>
    * @param {string} sSvcScpCd Mandatory svc_scp_cd
    * @param {string} sGlineSeq Mandatory gline_seq
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			if(enableFlag && (isAproUsr == "true" || isAproUsr)) {
				toggleButtons("INIT");
			} else {
				enableFlag=false;
				tabEnableSheet(enableFlag);
				toggleButtons("READONLY");
			}	
		}
	}
    /**
    * clearing controls on tab screen on parent screen<br>
    * <br><b>Example :</b>
    * <pre>
    * tabClearSheet()
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2009.04.17
    */ 	 	 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		toggleButtons("CLEAR");
	}     	 
    /**
     * Calling function from main<br>
     * if Confirmation= YES, diable to add,delete,modify<br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from main screen
     * @return N/A
     * @author 
     * @version 2009.04.17
     */ 			
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		
	}   

	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1,KeyFieldMark:0 });
	}    
	
	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
	     sheetObj.ReNumberSeq();    
	}
	
	function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
	     sheetObj.ReNumberSeq();    
	}	