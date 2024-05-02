/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0025.js
*@FileTitle  : Proposal Affiliate Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0025 : ESM_PRI_0025 definition of biz script for creation screen
     */
 // global variables 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var rData="N";
 document.onclick=processButtonClick;
 /**
  * event handler to handling process by button names <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return 
  * @author 
  * @version 
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];          
          var formObject=document.form;          
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
	 			case "btn_RowAdd":				
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;	
				case "btn_Delete":					
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;	
				case "btn_Amend":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
					break;	
				case "btn_AmendCancel":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
					break;					
				case "btn_Accept":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
					break;					
				case "btn_AcceptCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
					break;	
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_AcceptAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY05);
					break;
				case "btn_CancelAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY06);
					break;
    			case "btn_DownExcel":
    				doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
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
      * Registering IBSheet Object by array<br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj);
      * </pre>
      * @param {ibsheet} sheet_obj mandatory IBSheet Object
      * @return N/A
      * @author 
      * @version 
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Initializing and setting Sheet basics<br> 
      * Setting body tag's onLoad event handler<br>
      * Adding pre-handling function after loading screen on the browser <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return N/A
      * @author 
      * @version 
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
   		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);  
		var formObj=document.form;
		formObj.hdr_eff_dt.focus();
		formObj.hdr_exp_dt.focus();
        buttonControl();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }
	/**
	 * Setting body tag's unonLoad event handler<br><br>
	 * Adding function when closing the screen<br>
	 * returning whether data editable or not <br>
      * @author 
      * @version 
      */     
  	 function unloadPage(){
  		ComPopUpReturnValue(rData);
  	 }      
  /**
   * handling OnKeyPress events<br>
  * @author 
  * @version 
  */     
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
		case "float":
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
		default:
			ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}
	/**
	   * handling OnBeforeActivate events<br>
	  * @author 
	  * @version 
	  */   
	function obj_activate() {
		//var formObject = document.form;
	    var srcName=ComGetEvent("name");
	    ComClearSeparator (event.srcElement);
	}
    /**
     * handling Onbefore deactivate events<br>
	  * @author 
	  * @version 
	  */    	
	function obj_deactivate() {
	    ComChkObjValid(event.srcElement);
	}     
	/**
	    * setting sheet initial values and header
	    * param : sheetObj, sheetNo
	    * adding case as numbers of counting sheets
	    */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         var amdt_seq=document.form.amdt_seq.value;
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
              with(sheetObj){
                 
              var HeadTitle="|Sel.|Seq.|propno|amdtseq|afilseq|Customer code|Customer code|Customer Name|Address|Location|Effective Date|Effective Date|Source|Status|||||||";
              var headCount=ComCountHeadTitle(HeadTitle);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                  {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                  {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"afil_seq",            KeyField:1,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              if (amdt_seq == "0"){// setting editable by amend seq
	              cols.push({Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 });
	              cols.push({Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"N", InputCaseSensitive:1 });
              }else{
	              cols.push({Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1  });
	              cols.push({Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6, AcceptKeys:"N", InputCaseSensitive:1 });
              }
              cols.push({Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 });
              cols.push({Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cust_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
              cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd_tmp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 });
              cols.push({Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq_tmp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
              cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
      
              InitColumns(cols);

              SetEditable(1);
              SetEllipsis(1);
              SetWaitImageVisible(0);
              SetShowButtonImage(2);
              SetSheetHeight(197);
              }
              break;
         }
     }
     /**
      * Handling sheet process<br>
      * @author
      * @version 
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
            switch(sAction) {
 			case IBSEARCH_ASYNC01: // combo setting 
 				sheetObj.SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
 				//	status
 				sheetObj.SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
 				break;	         
 			case IBINSERT: // Row Add			
 				var eff_dt=formObj.eff_dt.value;
 				var exp_dt=formObj.exp_dt.value;
 				var amdt_seq=formObj.amdt_seq.value;
 				if (validateForm(sheetObj,document.form,sAction)) {	
 	 				var idx=sheetObj.DataInsert();
 					sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
 					sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
 					sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value,0);
 					sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
 					sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value,0);
 					sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
 					sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
 					sheetObj.SetCellValue(idx, "afil_seq",parseInt(ComPriGetMax(sheetObj, "afil_seq")) + 1,0);
 					if(amdt_seq!=0){
  						sheetObj.SetCellFont("FontColor", idx, "chk", idx, "prc_prog_sts_cd","#FF0000");
 					}	
 					sheetObj.SelectCell(idx, "cust_cnt_cd");
 				}
 				break;    
 			case IBDELETE: // Delete
 				var amdt_seq=formObj.amdt_seq.value;
 				if(amdt_seq=="0"){	
 					if (validateForm(sheetObj,document.form,sAction)) {
 						var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
 						if(chkArr.length == 0) {
 							sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",1,0);
 							if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd")!="I"){
 								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",0,0);
 								ComShowCodeMessage("PRI01002");
 								return;
 							}
 						}else{
 							for(var i=0;i < chkArr.length;i++){							
 								if (sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd")!="I"){
 									ComShowCodeMessage("PRI01002");
 									return;
 								}
 							}
 						}
 						deleteRowCheck(sheetObj, "chk");
 					}
 				}else{
 					var eff_dt=formObj.eff_dt.value;
 					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 					if(chkArr.length > 0){			
 						for(i=0;i < chkArr.length;i++){
							if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq
							||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq
							&& (sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="NW"
							|| sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd")!="I"))){
 								ComShowCodeMessage("PRI01002");
 								return;
 							}
 						}
 						var sRow=0; 				
 						for(j=0;j < chkArr.length;j++){
 							if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
 								comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D","");
 								sRow++;
 							}else{
 								sheetObj.SetRowStatus(chkArr[j+sRow],"D");
 								sheetObj.SetRowEditable(chkArr[j]+sRow,0);
 								sheetObj.SetRowHidden(chkArr[j]+sRow,1);
 							} 							
 						} 						
 					}else{ 
						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!=amdt_seq
						|| ( sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq")==amdt_seq
						&& (sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd")!="NW"
						|| sheetObj.GetCellValue(sheetObj.GetSelectRow(),"prc_prog_sts_cd")!="I"))){
 							ComShowCodeMessage("PRI01002");
 							return;
 						}
						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq")!= amdt_seq){						
 							comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"D","");
 						}else{
 							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk",1);
 							deleteRowCheck(sheetObj, "chk", true);
 						}	
 					}					
 				}
 				break;					
 			case COMMAND01: // Amend			
 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var columns="";
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{
 						columns="cust_cnt_cd|cust_seq";
 						comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", columns);						
 					}
 				}else{
 					columns="cust_cnt_cd|cust_seq"; 			
 					comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", columns);
 				}
 				break;	
 			case COMMAND02: // Amend Cancel
 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var columns="";
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{
 						columns="cust_cnt_cd|cust_seq";
 						comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", columns);		
 					}
 				}else{ 
 					columns="cust_cnt_cd|cust_seq";
 					comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", columns);
 				}	
 				break;				
 			case MODIFY01: // Accept
 				ComOpenWait(true); //->waiting->start
 				if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            } 			
 				formObj.f_cmd.value=MODIFY01;
 				var rVal=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0025GS.do");
 				ComOpenWait(false); //->waiting->End
 				break; 	
 			case MODIFY02: // Accept Cancel
 				ComOpenWait(true); //->waiting->start
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value=MODIFY02;
 				var rVal=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0025GS.do");
 				ComOpenWait(false); //->waiting->End
 				break; 				
 			case IBSEARCH: 
 				formObj.f_cmd.value=SEARCH01;
 				ComOpenWait(true); //->waiting->start
  				sheetObj.DoSearch("ESM_PRI_0025GS.do", FormQueryString(formObj) );
 				ComOpenWait(false); //->waiting->End
 				break;				
 			case IBSAVE: 
 				ComOpenWait(true); //->waiting->start
 				if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}
 	            if (!ComPriConfirmSave()) {
 	                return false;
 	            }
 	        	for (var a=0; a <= 0; a++) {
 	        		for (var i=sheetObjects[a].HeaderRows(); i <= sheetObjects[a].LastRow(); i++) {
 	        			// after modified, changing GM(Guideline Modification) in case of Proposal step and src_info_cd is GC(Guideline Copy)
        				if (sheetObjects[a].GetRowStatus(i) == "U" && sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC") {
        					sheetObjects[a].SetCellValue(i, "src_info_cd","GM");
        				}
 	            		// after modified, changing PM(Previous Contract Modification) in case of Proposal step and src_info_cd is PC(Previous Contract)
        				if (sheetObjects[a].GetRowStatus(i) == "U" && sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC") {
 	            			sheetObjects[a].SetCellValue(i, "src_info_cd","PM");
 	            		}
 	        		}
 	        	}				
 		 		formObj.f_cmd.value=MULTI01;		 		
  				var sParam=FormQueryString(formObj);
  				var sParamSheet=sheetObj.GetSaveString();
   				var sXml=sheetObj.GetSaveData("ESM_PRI_0025GS.do", sParam+"&"+sParamSheet);
   				sheetObj.LoadSaveData(sXml, true);
  				ComOpenWait(false); //->waiting->End
  				buttonControl();
 		 		break;	
 			case MODIFY05: // Accept All
 				ComOpenWait(true); //->waiting->start
 				if (!ComShowCodeConfirm("PRI01015")){
 					return false;
 				}
 				formObj.f_cmd.value=MODIFY03;
 				formObj.sts_cd.value='A';
 				var rVal=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0025GS.do", true);
 				ComOpenWait(false); //->waiting->End
 				break;			
 			case MODIFY06: // Cancel All
 				ComOpenWait(true); //->waiting->start
 				if (!ComShowCodeConfirm("PRI01010")){
 					return false;
 				}			
 				formObj.f_cmd.value=MODIFY04;
 				formObj.sts_cd.value='I';
 				var rVal=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0025GS.do", true);
 				ComOpenWait(false); //->waiting->End
 				break;
			case IBDOWNEXCEL:
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					}
				break;
          }        	 
         } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
              } else {
                  ComShowMessage(e.message);
              }
          }finally{
          	if (sAction == COMMAND01 || sAction == COMMAND02 || sAction == IBINSERT
          			|| sAction == IBSEARCH_ASYNC01 || sAction == IBDELETE) {
          		return;
          	}
          	ComOpenWait(false); //->waiting->End
          }
     }
     /**
      * OnSearchEnd event function <br>
      * @author
      * @version 
      */   
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
		searchEndFontChange(sheetObj, "",document.form.lgcy_if_flg.value);	
		buttonControl();
	}  	 
      /**
      * OnSelectCell event function <br>
      * @author
      * @version 
      */         	
   	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
          if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
          }
   	} 
   	
   	/**
     * Calling function in case of Onclick event <br>
     * when specified cell of Sheet clicked, display the notepad window. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving 
     * @return void
     * @author 
     * @version 2015.04.02
     */  	           
     function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    var colname=sheetObj.ColSaveName(Col);
	    var readOnly=true;
	    if(colname == "cust_nm" || colname == "cust_addr") {
	    	
	    	var memo_width = sheetObj.GetColWidth("cust_addr") +
						    	sheetObj.GetColWidth("cust_loc_cd") +
						    	sheetObj.GetColWidth("eff_dt") +
						    	sheetObj.GetColWidth("exp_dt") +
						    	sheetObj.GetColWidth("src_info_cd");
	    	
	    	if(colname == "cust_nm") {
	    		memo_width += sheetObj.GetColWidth("cust_nm");
	    	}
	    	ComShowMemoPad(sheetObj, Row, Col, readOnly, memo_width, 130);
	    }
    }
   	
   	
   	
   	
   /**
     * checking validation process of inputted data <br>
     * @author 
     * @version 
     */
  	function validateForm(sheetObj, formObj, sAction) {
  		switch (sAction) {
  		case IBSEARCH: 
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
  				return false;
  			} else {
  				return true;
  			}
  			break;
  		case IBSAVE: 
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;
  			}
			var sParamSheet=sheetObj.GetSaveString();
			if (!sheetObj.IsDataModified()&& sParamSheet == "") {
				ComShowCodeMessage("PRI00301");
				return false;
			}	 		
  			for (i=1 ; i <= sheetObj.RowCount(); i++){
  				if (sheetObj.GetCellValue(i, "cust_cnt_cd") == "" || sheetObj.GetCellValue(i, "cust_seq") == ""){
  						ComShowCodeMessage("PRI01014", i);
  						sheetObj.SelectCell(i,"cust_cnt_cd");
  						return false;				
  				}
  			}
  			var preIbflag="";
  			for (var i=1; i<= sheetObj.RowCount(); i++){
  				preIbflag=sheetObj.GetRowStatus(i);
				sheetObj.SetCellValue(i, "cust_cnt_cd_tmp",ComTrim(sheetObj.GetCellValue(i, "cust_cnt_cd")),0);
				sheetObj.SetCellValue(i, "cust_seq_tmp",ComTrim(sheetObj.GetCellValue(i, "cust_seq")),0);
  				sheetObj.SetRowStatus(i,preIbflag);
  			}
			 var rowM=priAmendDupCheck(sheetObj, "cust_cnt_cd|cust_seq|cust_nm", formObj.amdt_seq.value)
			 if (rowM >= 0) {
				 ComShowCodeMessage("PRI00303", "Sheet", rowM);
				 sheetObj.SelectCell(rowM, "cust_nm");
			     return false;
		     }  
			 rowM=priAmendDupCheck(sheetObj, "cust_cnt_cd_tmp|cust_seq_tmp", formObj.amdt_seq.value)
			 if (rowM >= 0) {
				 ComShowCodeMessage("PRI00303", "Sheet", rowM);
				 sheetObj.SelectCell(rowM, "cust_cnt_cd");
			     return false;
		    }    	  			
  			return true;
  			break;
  		case IBINSERT: // Row Add
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;
  			}
  			if(sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != form.amdt_seq.value) { //prohibiting add when admending
				ComShowCodeMessage("PRI01002");		
				return false;
			}
  			return true;
  			break;
  		case IBDELETE: // Delete
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;
  			} else {
  				return true;
  			}
  			break;
  		}
  	}
	/**
     * button authority control function by button status<br>
     * 
     * @author 
     * @version 
     */
    function buttonControl(){
		var formObj=document.form;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		var amdt_seq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		if(amdt_seq == 0) {
			hiddenButton("btn_Amend");
			hiddenButton("btn_AmendCancel");
		} else {
			showButton("btn_Amend");
			showButton("btn_AmendCancel");	
		}	
		if (apro_usr_flg == "false" && req_usr_flg == "false"){
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_Amend");
			ComBtnDisable("btn_AmendCancel");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_AcceptCancel");
			ComBtnDisable("btn_AcceptAll");
			ComBtnDisable("btn_CancelAll");
			for (var i=1; i <= sheetObjects[0].RowCount();i++){
				sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
				sheetObjects[0].SetCellEditable(i,"cust_seq",0);
				sheetObjects[0].SetCellEditable(i,"cust_nm",0);
				sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
			}					
			return;
		}		
		try{
			switch(sts) { 				
				case 'I':   // Initial									
					ComBtnDisable("btn_AcceptAll");					
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");	
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						if (sheetObjects[0].GetCellValue(i, "prc_prog_sts_cd") =="A"){
							sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
							sheetObjects[0].SetCellEditable(i,"cust_seq",0);
							sheetObjects[0].SetCellEditable(i,"cust_nm",0);
							sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
							sheetObjects[0].SetCellEditable(i,"cust_addr",0);
						}
					}	
					break;
				case 'A': //  Approved X , but Rerieve, downexcel O
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");										
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");					
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_seq",0);
						sheetObjects[0].SetCellEditable(i,"cust_nm",0);
						sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_addr",0);
					}	
					break;
				case 'Q':// Requested  
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");					
					if (apro_usr_flg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_CancelAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_AcceptCancel");
					}else{						
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
					}						
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_seq",0);
						sheetObjects[0].SetCellEditable(i,"cust_nm",0);
						sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_addr",0);
					}						
					break;
				case 'R':  // Returned accept ONLY,
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_LoadExcel");	
					if(req_usr_flg == "true"){
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
					}
					if (apro_usr_flg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_CancelAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_AcceptCancel");
					}
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_seq",0);
						sheetObjects[0].SetCellEditable(i,"cust_nm",0);
						sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
					}	
					break;
				case 'F': // same as Filed  approved 
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					for (var i=1; i <= sheetObjects[0].RowCount();i++){
						sheetObjects[0].SetCellEditable(i,"cust_cnt_cd",0);
						sheetObjects[0].SetCellEditable(i,"cust_seq",0);
						sheetObjects[0].SetCellEditable(i,"cust_nm",0);
						sheetObjects[0].SetCellEditable(i,"cust_loc_cd",0);
					}
					break;
				case 'C': //  same as Cancled  approved 
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");					
					break;
				default:
    				showButton("btn_Amend");
    				showButton("btn_AmendCancel");
    				ComBtnEnable("btn_AcceptAll");
    				ComBtnEnable("btn_CancelAll");
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
    * Sheet's culumns editable or not control function <br>
	  * @author
	  * @version 
	  */       	
    function columnControl(){
    	var sheetObj=sheetObjects[0];
    	var amdt_seq=document.form.amdt_seq.value;
    	var eff_dt=document.form.eff_dt.value;
		//Customer code
 		for(i=1 ; i < sheetObj.RowCount(); i++){
 			if(sheetObj.GetCellValue(i, "amdt_seq") != amdt_seq){
    			sheetObj.SetCellEditable(i,"cust_cnt_cd",0);
    			sheetObj.SetCellEditable(i,"cust_seq",0);
			}
 			else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
 				if (sheetObj.GetCellValue(i, "src_info_cd") != "AD"){
    					sheetObj.SetCellEditable(i, "cust_cnt_cd",1);
            			sheetObj.SetCellEditable(i, "cust_seq",1);
            			sheetObj.SetCellEditable(i, "cust_nm",0);
            			sheetObj.SetCellEditable(i, "cust_loc_cd",0);
				}
			}
		}
		changeSheetMemoColor();
    }
    /**
    * Sheet's MemoPad color setting function <br>
      * @author
      * @version 
      */
    function changeSheetMemoColor(){
		var sheetObj=sheetObjects[0];
    	for (var i=1; i <= sheetObj.RowCount();i++){
    			sheetObj.SetRangeBackColor(i,10,i,10,sheetObj.GetRangeBackColor(i,9,i,9));
		}
    }    
    /**
    * calling function when occurring OnChange Event <br> 
    * @author 
    * @version 
    */
     function sheet1_OnChange(sheetObj, Row, Col, Value)
     {
     	var colname=sheetObj.ColSaveName(Col);
     	var formObj=document.form;
     	switch(colname)
     	{
 	    	case "cust_cnt_cd":
 	    		if (Value.length > 0){
 	    			if (sheetObj.GetCellValue(Row, "cust_seq") !=""){
 	 	    			formObj.f_cmd.value=SEARCH01;  
 	 	    			var param=FormQueryString(formObj)+"&nmd_cust_flg=N" +"&cust_cnt_cd="+sheetObj.GetCellValue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row,"cust_seq");
  	 	    			var sXml=sheetObj.GetSearchData("ESM_PRI_4014GS.do", param);
 	   	  				var arrData=ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
 	 					if (arrData != null){
 	 						sheetObj.SetCellValue(Row,"cust_nm",arrData[0][0], 1);
 	 						sheetObj.SetCellValue(Row,"cust_addr",arrData[0][1], 1);
 	 						sheetObj.SetCellValue(Row,"cust_loc_cd",arrData[0][2], 1);
 	 					}else{
 	 						ComShowCodeMessage("PRI00315");
 	 						locationCellClear(sheetObj,Row);
 	 					}
 	    			} 	    			
 	    		}	    		
 	    		break;	  	    		
 	    	case "cust_seq": 	    		
 	    		if (Value.length > 0){
 	    			formObj.f_cmd.value=SEARCH01;  
 	    			var param=FormQueryString(formObj)+"&nmd_cust_flg=N" +"&cust_cnt_cd="+sheetObj.GetCellValue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row,"cust_seq");
  	    			var sXml=sheetObj.GetSearchData("ESM_PRI_4014GS.do", param);
   	  				var arrData=ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
 					if (arrData != null){
 						sheetObj.SetCellValue(Row,"cust_nm",arrData[0][0],0);
 						sheetObj.SetCellValue(Row,"cust_addr",arrData[0][1],0);
 						sheetObj.SetCellValue(Row,"cust_loc_cd",arrData[0][2],0);
 						//putting '0' in front of CUST_SEQ
         	    		if (Value.length < 6 && Value.length != 0){	 	    		
        	 	    		sheetObj.SetCellValue(Row,"cust_seq",ComTrim(ComLpad(Value, 6, "0")),0);
        	 	    	}         	    		
 					}else{
 						ComShowCodeMessage("PRI00315");
 						locationCellClear(sheetObj,Row);
 					}	  				
 	    		}       		
 	    		break;	 
 	    	case "cust_loc_cd":
 	    			if (Value.length == 5) {		
 	    				formObj.f_cmd.value=SEARCH05;
 	    				formObj.cd.value=Value;
 						var sParam=FormQueryString(formObj);
  						var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 						var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
 						if (arrDesc != null && arrDesc.length > 0) {
 						} else {
 	 						sheetObj.SetCellValue(Row, "cust_loc_cd","",0);
 	 						sheetObj.SelectCell(Row, "cust_loc_cd");
 						}
 					}else{
 						sheetObj.SetCellValue(Row, "cust_loc_cd","",0);
 						sheetObj.SelectCell(Row, "cust_loc_cd");
 					}
 	    		break;
     	}
     }    

     /**
	 * sheet1 OnPopupClick event function <br>
	 * calling Location PopUp
	 * @author 
	 * @version 
    */  	 
    var popupRow = 0;
 	function sheet1_OnPopupClick(sheetObj, Row, Col)
 	{
 		var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		popupRow = Row;
       	switch(colName)
       	{
   	    	case "cust_seq":		
   	    		var sUrl="ESM_PRI_4014_POP.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.GetCellValue(Row, "cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row, "cust_seq");
   	    		ComOpenPopup(sUrl, 640, 465, "cust_seq_returnVal", "none", false);   	    		
   	    		break;
       	}
 	}
 	
 	function cust_seq_returnVal(rtnVal) {
 		if (rtnVal != null){
 			sheet1.SetCellValue(popupRow, "cust_cnt_cd", rtnVal.custCntCd,1);
 			
			if (rtnVal.custSeq.length < 6 && rtnVal.custSeq.length != 1){	 	    		
				sheet1.SetCellValue(popupRow,"cust_seq", ComLpad(rtnVal.custSeq, 6, "0"), 0);
			} else {
				sheet1.SetCellValue(popupRow, "cust_seq", rtnVal.custSeq, 0);
			} 
			sheet1.SetCellValue(popupRow, "cust_nm", rtnVal.custNm,1);
			sheet1.SetCellValue(popupRow, "cust_addr", rtnVal.Addr,1);
			sheet1.SetCellValue(popupRow, "cust_loc_cd", rtnVal.LocCd,1);
		}
 	}
    /**
	* calling function when occurring OnSaveEnd Event <br>
	* setting edit column after saving
	*
	* @author 
	* @version 
	*/	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			parent.comUpdateProposalStatusSummary("05", "");			
			rData="Y";
		}
		changeSheetMemoColor();
		sheetObj.ReNumberSeq();
	}      
    /**
     * initializing sheet's specific cell value funcion <br>
	* @author 
	* @version 
	*/	 	    
  	function locationCellClear(sheetObj,Row){    	 
    	sheetObj.SetCellValue(Row, "cust_seq","",0);
  		sheetObj.SetCellValue(Row, "cust_cnt_cd","",0);
  		sheetObj.SetCellValue(Row, "cust_nm","",0);
  		sheetObj.SetCellValue(Row, "cust_addr","",0);
  		sheetObj.SetCellValue(Row, "cust_loc_cd","",0);
  		sheetObj.SelectCell(Row, "cust_cnt_cd");
  	}        	     
      /**
       * checking duplication based on Amend in IBSheet
       * except having pre-Amend Sequence or Amend Delete(AD) row
       * retruning row Index when duplicated row exist or -1 , duplicated row not exist ( value > 0)  
	* @author 
	* @version 
	*/	
      function priAmendDupCheck(sheetObj, sCol, amdtSeq) {
          try {
              /*if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
                  return;
              }*/
              if (sCol == undefined || sCol == null || sCol == "") {
                  return;
              }
              if (sheetObj.RowCount()<= 0) {
                  return -1;
              }
              var dupRow = sheetObj.ColValueDupRows(sCol, false, true);
              if (dupRow == null || dupRow == "") {
                  return -1;
              }
              var arrCol=sCol.split("|");
              var arrTemp=dupRow.split("|");
              var arrBaseRow=arrTemp[0].split(",");
              var arrDesRow=arrTemp[1].split(",");
              for (var i=arrDesRow.length - 1; i >= 0; i--) {
            	  if (sheetObj.GetCellValue(arrDesRow[i], "amdt_seq") != amdtSeq
            			  || sheetObj.GetCellValue(arrDesRow[i], "src_info_cd") == "AD") {
                      arrDesRow.splice(i, 1);
                  }
              }
              for (var i=arrBaseRow.length - 1; i >= 0; i--) {
            	  if (sheetObj.GetCellValue(arrBaseRow[i], "amdt_seq") != amdtSeq
            			  || sheetObj.GetCellValue(arrBaseRow[i], "src_info_cd") == "AD") {
                      for (var j=0; j < arrDesRow.length; j++) {
                           var isSame=true;
                           for (var k=0; k < arrCol.length; k++) {
                        	   if (sheetObj.GetCellValue(arrBaseRow[i], arrCol[k]) != sheetObj.GetCellValue(arrDesRow[j], arrCol[k])) {
                                   isSame=false;
                                   break;
                               }
                           }
                           if (isSame) {
                               arrDesRow.splice(j, 1);
                               break;
                           }
                      }
                      arrBaseRow.splice(i, 1);
                  }
              }
              if (arrDesRow.length > 0) {
                  return arrDesRow[0];
              } else {
                  return -1;
              }
          } catch(err) { ComFuncErrMsg(err.message); }
      }      
