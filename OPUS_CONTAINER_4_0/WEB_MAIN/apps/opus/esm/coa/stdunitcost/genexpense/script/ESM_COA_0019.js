/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_COA_0019.js
*@FileTitle  : General Expense 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
     * @author
     */
    /**
     * @extends 
     * @class ESM_COA_0019 : ESM_COA_0019 Business script for the UI
     */
   	/* Developer's task	*/
	var sheetObjects=new Array();
	var sheetCnt=0;
	var failCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return nothing
     */
	function processButtonClick(){
        /***** Specify additional sheet variable in case of using more than two sheet per tab *****/
        var sheetObject=sheetObjects[0];
        var sheetObject3=sheetObjects[2];
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_New":
					doActionIBSheet(sheetObject,formObject,IBRESET);
					break;
				case "btn_Retrieve":
					//SJH.20141222.MOD : 자동저장안되게..
//					if(sheetObject.IsDataModified()){
//						doActionIBSheet(sheetObject,formObject,IBSAVE);
//					}
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					//SJH.20141222.MOD : 자동조회
					doActionIBSheet(sheetObject3,formObject,IBSEARCH);
					break;
				case "btn_Save":
					failCnt = 0;
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					doActionIBSheet(sheetObjects[2],formObject,IBSAVE);	
					doActionIBSheet(sheetObjects[3],formObject,IBSAVE);
					if(failCnt==0){
						ComShowCodeMessage('COM130102', 'Data');
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
					}
					failCnt =0;
					break;
				case "btn_Create":
					doActionIBSheet(sheetObject3,formObject,IBCREATE);
					break;
				case "btn_vslunitcost":
					doActionIBSheet(sheetObject3,formObject,IBSEARCH);
					break;
				//SJH.20141229.ADD
				case "btn_Save1":
					doActionIBSheet(sheetObjects[2],formObject,IBSAVE);				
					break;
				case "btn_Save2":
					doActionIBSheet(sheetObjects[3],formObject,IBSAVE);					
					break;
	            case "btn_Rowadd2":
	                doActionIBSheet(sheetObjects[3],formObject,IBINSERT);
	                break;						
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		} finally {
 			 ComOpenWait(false);
 		}
	}
  /**
	* Registering IBSheet Object as list <br>
	* adding process for list in case of needing batch processing with other items 
  * defining list on the top of source <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj mandatory IBSheet Object
	* @return nothing
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
   /**
    * Sheet default setting and Initialize <br>
    * implementing onLoad event handler in body tag
		* adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return nothing
    */
	function loadPage() {
		var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			//Sheet configuration setting function(start)
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//Sheet configuration setting function(end)
			if(i+1!=2)
				ComEndConfigSheet(sheetObjects[i]);
		}
		formObj.cost_yrmon.focus();
	}
    /**
     * Initialize sheet and define header info <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory Seq No. of the IBSheet Object tag ID
     * @return nothing
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var formObj=document.form;
     	switch(sheetID) {
         	case "sheet1":
         	    with(sheetObj){
	              var HeadTitle="";
	              HeadTitle=HeadTitle + formObj.cols_yrmon.value +"|";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              //(headCount, 0, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                           {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"uc_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:0,   EditLen:20 },
	                           {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"yrmon1",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                           {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"yrmon2",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                           {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"yrmon3",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                           {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"yrmon4",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                           {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"yrmon5",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                           {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"yrmon6",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                           {Type:"Float",     Hidden:1,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"yrmon7",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
	              SetSheetHeight(120);
	              SetWaitImageVisible(0);
	              SetCellBackColor(0, 1, "#F2CB61");
         		}
     	    break;
          	case "sheet2":
                with(sheetObj){
	             var HeadTitle="3-Month Average|aa";
	             var headCount=ComCountHeadTitle(HeadTitle);
	             //(headCount, 0, 0, true);
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	             var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	             var cols = [ {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"name",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Float",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"tot_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
	              
	             InitColumns(cols);
	             SetEditable(1);
	             SetWaitImageVisible(0);
	             SetRowHidden(0, 1);
	             DataInsert(-1);
	             SetCellValue(1,0,"3-Month Average",0);
	             SetCellValue(1,1,"0.00",0);
	             SetCountPosition(0);
	             SetSheetHeight(50);
//	             $(".GMFillRow").remove();
	             
             }
              	break;
         	case "sheet3":
         	    with(sheetObj){
	                var HeadTitle="ibflag|YYYY-MM|VSL|VSL Class|Unit Cost" ;
		              var headCount=ComCountHeadTitle(HeadTitle);
		             // (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              //SJH.20141229.MOD
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon3",    KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd3",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vsl_clss_capa3", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0, Width:130,  Align:"Right",   ColMerge:0,   SaveName:"dhir_amt3",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:0 } ];
		               
		              InitColumns(cols);	
		              SetEditable(1);
//		              SetSheetHeight(230);
					  resizeSheet();
		              SetWaitImageVisible(0);
                    }
              break;
	         	case "sheet4":
	         	    with(sheetObj){
		                var HeadTitle="Del.|ibflag|YYYY-MM|VSL Class|Unit Cost" ;
			              var headCount=ComCountHeadTitle(HeadTitle);
			              //(headCount, 0, 0, true);
		
			              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
			              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			              var headers = [ { Text:HeadTitle, Align:"Center"} ];
			              InitHeaders(headers, info);
			              //SJH.20141229.MOD
			              var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibDel" },
			                           {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					                   {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon4",    KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                   {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vsl_clss_capa4", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                   {Type:"Float",     Hidden:0, Width:130,  Align:"Right",   ColMerge:0,   SaveName:"dhir_amt4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
			               
			              InitColumns(cols);	
			              SetEditable(1);
//			              SetSheetHeight(230);
						  resizeSheet();
			              SetWaitImageVisible(0);
                    }
	         	break;
     	}
	}
  /**
   * Handling process about the sheet object <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {form} formObj mandatory html form object
   * @param {int} sAction mandatory process flag constant
   * @return nothing
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		sheetObj.ShowDebugMsg(false);
 		switch (sAction) {
 		    //SJH.20141229.ADD
 		    case IBINSERT:
 				var row = sheetObj.DataInsert();
 				break;
 			case IBSEARCH: // retrieve
 				if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				ComOpenWait(true);				
 				if(sheetObj == sheetObjects[0]) {
 		 			formObj.f_cmd.value=SEARCH;
 		 			var sXml=sheetObj.GetSearchData("ESM_COA_0019GS.do", FormQueryString(formObj));
 	  				var sCols=ComGetEtcData(sXml,"COL_YRMON");
 	  					
 	  				changeHeaderRow(sheetObj , 0 , sCols);
 	  				
 					sheetObj.LoadSearchData(sXml,{Sync:0} );
 				} else {
 					formObj.f_cmd.value=SEARCH01;
 					var sXml=sheetObj.GetSearchData("ESM_COA_0019GS.do", FormQueryString(formObj));
 	  				var arrXml=sXml.split("|$$|");
 	  				if (arrXml.length > 0) {
 						sheetObjects[2].LoadSearchData(arrXml[0],{Sync:0} );
 						sheetObjects[3].LoadSearchData(arrXml[1],{Sync:0} );
 					} 					
 				}  			
 				break;
 			case IBSAVE: // Save
 				if (!validateForm(sheetObj,document.form,sAction)) {
 					failCnt = failCnt +1;										//20150605.ADD
					return false;
				}				
//  				ComOpenWait(true);											//20150605.ADD
  				
  				//SJH.20141229.ADD
 	            if(sheetObj.id == "sheet1"){
 	                formObj.f_cmd.value=MULTI;
 	            } else if (sheetObj.id == "sheet3"){
 	                formObj.f_cmd.value=MULTI03;
 	            } else if (sheetObj.id == "sheet4"){
 	                formObj.f_cmd.value=MULTI04; 	                
 	            } else {
 	            	return false;
 	            } 	            
 				var sParam=sheetObj.GetSaveString(0); 				
 				if (!sheetObj.IsDataModified() && sParam == "") return;  // IsDataModified keyfield check
 				sParam= sParam + "&"+FormQueryString(formObj);
 				//SJH.20141229.MOD
 				var sXml=sheetObj.GetSaveData("ESM_COA_0019GS.do", sParam );
 				sheetObj.LoadSaveData(sXml, {Sync:1});							//SJH.20141229.ADD
 				if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
//					ComShowCodeMessage('COM130102', 'Data');
				}else{
					failCnt = failCnt +1;
				}
				//SJH.20141229.ADD
//				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//				doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
 				break;
 			case IBCREATE: // CREATE
 				if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
 				if (!ComShowCodeConfirm("COA10020")) {
 					return false;
 				}
  				ComOpenWait(true);
 				formObj.f_cmd.value=MULTI01;
 				var sXml=sheetObj.GetSaveData("ESM_COA_0019GS.do", FormQueryString(formObj));
 				//SJH.20141222.ADD : 저장후 메시지 자동조회
				if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
					ComShowCodeMessage('COM12116', 'Create');
				}	             
  				doActionIBSheet(sheetObj,formObj,IBSEARCH);
  				doActionIBSheet(sheetObjects[2],formObj,IBSEARCH);
 				break;
 		}
 	}
    /**
     * Handling process for form object input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         Logic;
     *     }
     * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {form} formObj mandatory html form object
    * @param {int} sAction mandatory process flag constant
     * @returns bool <br>
			*          true  : Form input values ​​are valid<br>
			*          false : Form input values ​​are not valid
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
 		case IBSEARCH: // retrieve
 			if(!isValidYYYYMM(formObj.cost_yrmon , false, '-', false)){
				return false;
	  		}
			break;
   		case IBSAVE:
   			if(!isValidYYYYMM(formObj.cost_yrmon , false, '-', false)){
				return false;
	  		}
			//SJH.20141229.ADD
            if(sheetObj.id == "sheet3"){
	  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {	  				
	  				if(sheetObj.GetCellValue(i, "ibflag") == "U" || sheetObj.GetCellValue(i, "ibflag") == "I") {
			  	  		if(ComTrimAll(sheetObj.GetCellText(i, "dhir_amt3")).length == 0) {
			  	  			ComShowMessage(ComGetMsg('COA10002','3 Sheet Unit Cost'));
			  	  			sheetObj.SelectCell(i, "dhir_amt3", true);
			  	  			return false; 	
			  	  			break;				  	  			
			  	  		}
			  	  	}
		  	  	}
            } else if (sheetObj.id == "sheet4"){
      			var dr = sheetObj.ColValueDup("cost_yrmon4|vsl_clss_capa4");
      			if(dr>0){
      				if (sheetObj.GetCellValue(dr, "ibflag") == "I") {
      					ComShowCodeMessage('COM12115', 'YYYY-MM, VSL Class');
      					sheetObj.SelectCell(dr, "vsl_clss_capa4", true);
      					return false;				
      				}
      			}
	  			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {	  				
	  				if(sheetObj.GetCellValue(i, "ibflag") == "U" || sheetObj.GetCellValue(i, "ibflag") == "I") {
			  	  		if(ComTrimAll(sheetObj.GetCellText(i, "cost_yrmon4")).length == 0) {
			  	  			ComShowMessage(ComGetMsg('COA10002','4 Sheet YYYY-MM'));
			  	  			sheetObj.SelectCell(i, "cost_yrmon4", true);
			  	  			return false; 	
			  	  			break;				  	  			
			  	  		}
			  	  		if(ComTrimAll(sheetObj.GetCellText(i, "vsl_clss_capa4")).length == 0) {
			  	  			ComShowMessage(ComGetMsg('COA10002','4 Sheet VSL Class'));
			  	  			sheetObj.SelectCell(i, "vsl_clss_capa4", true);
			  	  			return false; 	
			  	  			break;				  	  			
			  	  		}			  	  		
			  	  		if(ComTrimAll(sheetObj.GetCellText(i, "dhir_amt4")).length == 0) {
			  	  			ComShowMessage(ComGetMsg('COA10002','4 Sheet Unit Cost'));
			  	  			sheetObj.SelectCell(i, "dhir_amt4", true);
			  	  			return false; 	
			  	  			break;				  	  			
			  	  		}
			  	  	}
		  	  	}      			
            } else {
            	return true;
            }    			
 			break;
		case IBCREATE: // CREATE
			if(!isValidYYYYMM(formObj.cost_yrmon , false, '-', false)){
				return false;
	  		}
			break;
		}
 		return true;
 	}
 	/**
 	 * The function is called when an OnSearchEnd event occurs <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj mandatory IBSheet Object
 	 * @param {string} ErrMsg mandatory Message from a server
 	 * @return nothing
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj=document.form;
 		var avgMonth=((parseFloat(sheetObj.GetCellValue(1,1)) + parseFloat(sheetObj.GetCellValue(1,2)) + parseFloat(sheetObj.GetCellValue(1,3)))/3).toString();
 		// Setting 3 months data
 		sheetObjects[1].SetCellValue(1, 1,avgMonth,0);
 	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[2]);
   	 ComResizeSheet(sheetObjects[3]);
    }