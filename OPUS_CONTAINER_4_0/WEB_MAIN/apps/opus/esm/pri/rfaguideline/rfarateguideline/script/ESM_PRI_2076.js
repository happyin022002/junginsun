/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2076.js
*@FileTitle  : RFA Guideline Creation - Rate(Commodity)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends 
     * @class Commodity Group :business script for Commodity Group 
     */

 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var enableFlag=true;
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
  * @version 2009.08.07
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
//          var sheetObject2 = sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
	            case "btn_Ok":
					if (enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						ComPopUpReturnValue("O");
					}	            	
	                break;
	            case "btn_Close":  
	            	ComPopUpReturnValue("C");
	            	if (sheetObject1.IsDataModified()){
	            		if(ComShowCodeConfirm("PRI00006")){
	    					if (enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
	    						doActionIBSheet(sheetObject1,formObject,IBSAVE);
	    						ComPopUpReturnValue("O");
	    					}else{
	    						return;
	    					}
	            		}
	            	}
	            	ComClosePopup(); 
	                break;
	            case "btn_RowAdd":
					if (enableFlag && validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;		            	
	            case "btn_RowDel":
					if (enableFlag && validateForm(sheetObject1,formObject,IBDELETE)) { 
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
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
     * @version 2009.08.07
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
     * @version 2009.08.07
     */
     function loadPage() {
    	 
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
         for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
            sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
 		if (document.form.isEditable.value == "false") {
			sheetObjects[0].SetEditable(0);
			disableButton("btn_RowAdd");
			disableButton("btn_RowDel");
		}
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
     * @version 2009.08.07
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
              case "sheet1":
            	  with(sheetObj){

                var HeadTitle="|Sel.|Seq.|1|2|3|4|CMDT Type|CMDT Code|Commodity Description|Sort Order";
                var headCount=ComCountHeadTitle(HeadTitle);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"sort_order",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                 
                InitColumns(cols);
                SetColProperty(0 ,"prc_cmdt_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
                
                SetEditable(1);

                SetShowButtonImage(2);
                resizeSheet(); //SetSheetHeight(220);
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
     * @version 2009.08.07
     */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         try {
	          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {
	 			case IBCLEAR: 
	 				sheetObj.SetColProperty("prc_cmdt_tp_cd", {ComboText:COMODITY_TYPE3[1] , ComboCode:COMODITY_TYPE3[0]} );
	 				break;
				case IBSEARCH:      //Retrieving				
					var sXml=opener.getSheetXml(3);
					sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
					sheetGetRowHidden(sheetObjects[0]);
		         	break; 				
	 			case IBINSERT:      // Insert
	 			    //sheetObj.DataAutoTrim = false;
	 		        var idx=sheetObj.DataInsert();
					sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
					sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
					sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
					sheetObj.SetCellValue(idx, "cmdt_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_seq"))+ 1);
					sheetObj.SelectCell(idx, "prc_cmdt_def_cd", false);
	 				break;
	 			case IBDELETE: // Delete
	 	        	if (sheetObj.CheckedRows("chk") <= 0) {
	 	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	 	        	}
	 				deleteRowCheck(sheetObj, "chk");
	 				break;			
				case IBSAVE:        	
	        		//Transmitting data to main page after ordering
					for (var i = sheetObj.HeaderRows(); sheetObj.RowCount() > 0 && i <= sheetObj.LastRow(); i++) {
						var prevGetRowStatus=sheetObj.GetRowStatus(i);
						var cmdtTpCd=sheetObj.GetCellValue(i, "prc_cmdt_tp_cd");
						if (cmdtTpCd == "G") {
							sheetObj.SetCellValue(i, "sort_order",1,0);
						} else if (cmdtTpCd == "R") {
							sheetObj.SetCellValue(i, "sort_order",2,0);
						} else if (cmdtTpCd == "C") {
							sheetObj.SetCellValue(i, "sort_order",3,0);
						}
						sheetObj.SetRowStatus(i,prevGetRowStatus);
					}
					sheetObj.ColumnSort("sort_order|prc_cmdt_def_cd", "ASC", "ASC|ASC", true);
	//              // The method that sheet data move to opener window
					//if (sheetObj.RowCount != 0){
						var sXml=ComPriSheet2Xml(sheetObjects[0]);
						opener.setSheetXml(sXml, 3);
					//}
		            break;
	          }
         } catch (e) {
             if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         } finally {
         	ComOpenWait(false);
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
       * @version 2009.08.07
       */
     function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
	  		case IBSEARCH: // retrieving			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} else {
					return true;
				}
				break;    	  
    	  	case IBSAVE: // Saving   	
				if (sheetObjects[0].IsDataModified()) {
	 		  		var sParamSheet1=sheetObjects[0].GetSaveString();
	 		  		if (sParamSheet1==""){
	 		  			return ; 		  			
	 		  		} 					
					var rowM=sheetObjects[0].ColValueDup("prc_cmdt_tp_cd|prc_cmdt_def_cd");
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", rowM);
					    return false;
				    }	    		
				}
				break;
    		case IBINSERT: // Row Add
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				return false;
    			} else {
    				return true;
    			}
    			break;
    		case IBDELETE: // Delete
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				return false;
    			} else {
    				return true;
    			}
    			break;
    	  }
         return true;
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
      * @version 2009.08.07
      */  	    
   function sheet1_OnChange(sheetObj, Row, Col, Value)
   {
   	var colname=sheetObj.ColSaveName(Col);
   	var formObj=document.form
   	switch(colname)
   	{
    	case "prc_cmdt_def_cd":
    		if (Value.length == 6) {
    			formObj.f_cmd.value=SEARCH08;
    			formObj.cd.value=Value; 
   				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	  				
  				if (arrData[1] != ""){
 					/*sheetObj.Cellvalue2(Row, "prc_cmdt_def_nm")=arrData[1];
 					sheetObj.Cellvalue2(Row, "prc_cmdt_tp_cd")="C";*/
  					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm",arrData[1], 0);
 					sheetObj.SetCellValue(Row, "prc_cmdt_tp_cd","C", 0);
  				} else {
  					locationCellClear(sheetObj,Row);
  				}
    		} else if (Value.length == 5) {
    			formObj.f_cmd.value=SEARCH10;
    			formObj.cd.value=Value;
    			var param="&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value + "&nm=rg";	
   				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	
  				if (arrData[1]!=""){
 					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm", arrData[1], 0);
 					sheetObj.SetCellValue(Row, "prc_cmdt_tp_cd", "G", 0);
  				} else {
  					locationCellClear(sheetObj,Row);
  				}
    		} else if (Value.length == 4) {
    			formObj.f_cmd.value=COMMAND29;
    			formObj.cd.value=Value;	
  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	
  				if (arrData[1]!=""){
 					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm", arrData[1], 0);
 					sheetObj.SetCellValue(Row, "prc_cmdt_tp_cd", "R", 0);
  				} else {
  					locationCellClear(sheetObj,Row);
  				}
    		} else {
    			locationCellClear(sheetObj,Row);
    		}
    		break;
    	case "prc_cmdt_tp_cd": 	 
    		locationCellClear(sheetObj,Row);
    		break;
   		}
   }  
      /**
       * Initializing sheet's specific cell value <br>
       * <br><b>Example :</b>
       * <pre>
       * 		locationCellClear(sheetObj,Row)
       * </pre>
       * @param {ibsheet} sheetObj mandatory IBSheet Object
       * @param {int} Row Mandatory ,Cell Row Index    
       * @return void
       * @author 
       * @version 2009.08.07
       */  	    
    	function locationCellClear(sheetObj,Row){
    		sheetObj.SetCellValue(Row,"prc_cmdt_def_nm","",0);
    		sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
    		sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
    	}      
  	 /**
	    * Function which re-hiding sheet after transmitting deleted rows between sheets<br>
	    * Transmitting data between sheet
	    * <br><b>Example :</b>
	    * <pre>
	    * 		sheetRowHidden (sheetObj)
	    * </pre>
	    * @param {ibsheet} sheetObj mandatory IBSheet Object
	    * @return void
	    * @author 
	    * @version 2009.08.07
	    */     
  	function sheetGetRowHidden(sheetObj){
 		for (i = sheetObj.RowCount(); i > 0; i-- ){
 			if (sheetObj.GetCellValue( i, "ibflag") == "D" ){
 				sheetObj.SetRowHidden(i,1);
 			}
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
	    * @version 2009.08.07
	    */  	      	 
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		var tpCd="C";
		if (colName == "prc_cmdt_def_cd"){
			var sUrl="/opuscntr/ESM_PRI_4027.do?commodity_cmd=CRG&grp_cd="+PRI_RG+"&svc_scp_cd="+formObj.svc_scp_cd.value+"&gline_seq="+formObj.gline_seq.value + "&prc_cmdt_tp_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_cmdt_tp_cd");
			ComOpenPopup(sUrl, 700, 345, "findCommodity", "1,0", false);
			}
		}
	
	function findCommodity(rtnVal) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol() + 1,rtnVal.nm,0);
		//Changing Commodity Type
		if (rtnVal.cd.length == 4) {
			tpCd="R";
		} else if (rtnVal.cd.length == 5) {
			tpCd="G";
		} else if (rtnVal.cd.length == 6) {
			tpCd="C";
		}
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"prc_cmdt_tp_cd",tpCd ,0);
   }
