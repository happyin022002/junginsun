/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0106.js
*@FileTitle  : Rate Creation - Commodity 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
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
 var opener;
 // Event handler processing by button click event*/
 document.onclick=processButtonClick;
 
//다음의 화면들에서 호출됨
//ESM_PRI_0001_06
 
 /**
  * Event handler processing by button name  <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return N/A
  * @author 
  * @version 2009.05.07
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
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
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.05.07
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
     * initializing sheet</b>
     * implementing onLoad event handler in body tag</b>
     * adding first-served functions after loading screen.</b>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.07
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
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2009.05.07
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
              case "sheet1":
                 with (sheetObj) {
	                  var HeadTitle="|Sel.|Seq.|1|2|3|4|5|CMDT Type|CMDT Code|Commodity Description";
	                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	                  var cols = [ 
	                         {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                         {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                  InitColumns(cols);
	                  SetEditable(1);
	                  resizeSheet();
//	                  SetSheetHeight(120);
	                  SetShowButtonImage(2);
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
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Flag constant variable
     * @return N/A
     * @author 
     * @version 2009.05.07
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg(false);
          switch(sAction) {
 			case IBCLEAR: // when loading			
				//common cmdt type
 				sheetObj.SetColProperty("prc_cmdt_tp_cd", {ComboText:COMODITY_TYPE1[1], ComboCode:COMODITY_TYPE1[0]} );
 				break;
			case IBSEARCH:
				var sXml=opener.getSheetXml(3);
				sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
				sheetGetRowHidden(sheetObjects[0]);
	         	break; 				
 			case IBINSERT:      
 			    //sheetObj.DataAutoTrim = false;
 		        var idx=sheetObj.DataInsert();
				sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
				sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
				sheetObj.SetCellValue(idx, "prc_cust_tp_cd",formObj.prc_cust_tp_cd.value);
				sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
				sheetObj.SetCellValue(idx, "cmdt_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_seq"))+ 1);
				sheetObj.SelectCell(idx, "prc_cmdt_def_cd");
 				break;
 			case IBDELETE: // Delete
 				deleteRowCheck(sheetObj, "chk", true);
 				break;			
			case IBSAVE:      
				sheetObjects[0].ColumnSort("prc_cmdt_tp_cd|prc_cmdt_def_cd","ASC","DESC|ASC");
				var sXml=ComPriSheet2Xml(sheetObjects[0]);
				opener.setSheetXml(sXml, 3);
	            break; 				
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
       * @version 2009.05.07
       */
     function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
	  		case IBSEARCH: 
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} else {
					return true;
				}
				break;    	  
    	  	case IBSAVE: 
	        	//if (!ComChkValid(formObj)) return false;	    	
				if (sheetObjects[0].IsDataModified()) {
	 		  		var sParamSheet1=sheetObjects[0].GetSaveString();
	 		  		if (sParamSheet1==""){
	 		  			return ; 		  			
	 		  		} 					
					 var rowM=sheetObjects[0].ColValueDup("prc_cmdt_tp_cd|prc_cmdt_def_cd", false);
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
      *  Showing description in case of selecting Multi ComboBox <br>
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
      * @version 2009.05.07
      */  	    
   function sheet1_OnChange(sheetObj, Row, Col, Value)
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
  					sheetObj.SetCellValue(Row, "prc_cmdt_tp_cd", "C", 0);
 					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm", arrData[1], 0);
  				}else{
  					locationCellClear(sheetObj,Row);
  				}
    		}else if (Value.length == 5) {
    			formObj.f_cmd.value=SEARCH10;
    			formObj.cd.value=Value;
    			var param="&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.gline_seq.value + "&etc3=" + formObj.prc_cust_tp_cd.value;	
   				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	
  				if (arrData[1]!=""){
  					sheetObj.SetCellValue(Row, "prc_cmdt_tp_cd", "G", 0);
 					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm", arrData[1], 0);
  				}else{
  					locationCellClear(sheetObj,Row);
  				}
    		}else{
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
       * @param {ibsheet} sheetObj Mandatory IBSheet Object
       * @param {int} Row Mandatory
       * @return N/A
       * @author 
       * @version 2009.05.07
       */  	    
    	function locationCellClear(sheetObj,Row){
    		sheetObj.SetCellValue(Row,"prc_cmdt_def_nm","",0);
    		sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
    		sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
    	}      
  	 /**
	    * Function to hide deleted row in case of moving delete row between sheet<br>
	    * <br><b>Example :</b>
	    * <pre>
	    * 		sheetRowHidden (sheetObj)
	    * </pre>
	    * @param {ibsheet} sheetObj Mandatory IBSheet Object
	    * @return N/A
	    * @author 
	    * @version 2009.05.07
	    */     
  	function sheetGetRowHidden( sheetObj){
 		for (i=sheetObj.RowCount(); i > 0; i-- ){
 			if (sheetObj.GetCellValue( i, "ibflag") == "D" ){
 				sheetObj.SetRowHidden(i,1);
 			}
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
  	var popupRow=0;
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var colName=sheetObj.ColSaveName(Col);
		popupRow=Row;
		var formObj=document.form;
		var prcCmdtTpCd=sheetObj.GetCellValue(Row,"prc_cmdt_tp_cd");
		if (colName == "prc_cmdt_def_cd"){
			var sUrl="ESM_PRI_4027.do?prc_cmdt_tp_cd="+ prcCmdtTpCd + "&commodity_cmd=CG&grp_cd="+PRI_SG+"&svc_scp_cd="+formObj.svc_scp_cd.value+"&gline_seq="+formObj.gline_seq.value+"&prc_cust_tp_cd="+formObj.prc_cust_tp_cd.value;
			ComOpenPopup(sUrl, 700, 350, "SetCommodity", "1,0,1,1,1,1,1", false);
			
		}
	}
	
	 function SetCommodity (rtnVal) {
		 var tpCd="C";
		 if (rtnVal != null){
			sheet1.SetCellValue(popupRow, "prc_cmdt_def_cd", rtnVal.cd, 0);
			sheet1.SetCellValue(popupRow, "prc_cmdt_def_nm", rtnVal.nm, 0);
			//Changing Commodity Type
			if (rtnVal.cd.length == 5){
				tpCd="G";
			}
			sheet1.SetCellValue(popupRow,"prc_cmdt_tp_cd",tpCd ,0);
		}
	 }
	
