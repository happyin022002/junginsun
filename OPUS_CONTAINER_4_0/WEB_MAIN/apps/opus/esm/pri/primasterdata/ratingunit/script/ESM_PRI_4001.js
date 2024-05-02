/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4001.js
*@FileTitle  : Rating Unit Information Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
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
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                 case "btn_add":
                	doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
   					break;
                 case "btn_del":
                	doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
   					break;
                 case "btn_retrieve":
                	 if (validateForm(sheetObjects[1],document.form,IBSEARCH)) {
                		 doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                	 }
      				 break;
                 case "btn_new":
                	 removeAll(document.form);
       				 break;
                 case "btn_save":
                	if (validateForm(sheetObjects[1],document.form,IBSAVE)) {
       					doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
       				}	
       				break;                    
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
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
         for(i=0;i<sheetObjects.length;i++){
        	 //Modify Environment Setting Function's name
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //Add Environment Setting Function
             ComEndConfigSheet(sheetObjects[i]);
             
         }
         
//         doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
// 		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
         
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
         sheet1_OnLoadFinish(sheetObjects[1]);
     }
     /**
      * It calls at LoadFinish event triggered. <br>
      * <br><b>Example :</b>
      * <pre>
      *     
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function sheet1_OnLoadFinish(sheetObj) {
    	 sheetObj.SetWaitImageVisible(0);
    	 doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
 		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
//    	 sheetObj.WaitImageVisible = true; 
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
	         case "sheet0":      //hidden 
	        	 with(sheetObj){
	        	 //SetConfig( { SearchMode:2, DataRowMerge:0 } );

		           //var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		           //var headers = [ ];
		           //InitHeaders(headers, info);

		           //var cols = [  ];
		            
		           //InitColumns(cols);
	        	 SetVisible(0);
	           }
	           break;

	         case "sheet1":      //hidden 
	        	    with(sheetObj){
	             
	           
	           var HeadTitle="|Sel.|Del Check|Seq.|Unit|Description|Character|Size|SC/RFA\nRate Only|Creation Date|Update Date|Del. Mark ";

	           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

	           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	           var headers = [ { Text:HeadTitle, Align:"Center"} ];
	           InitHeaders(headers, info);

	           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                  {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                  {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                  {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"rat_ut_desc",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                  {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_grp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Combo",     Hidden:0, Width:220,  Align:"Left",    ColMerge:0,   SaveName:"cntr_sz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"CheckBox",  Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_use_ony_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:1 } ];
	            
	           InitColumns(cols);

	           SetEditable(1);
	           SetWaitImageVisible(0);
	           SetColProperty(0 ,"rat_ut_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	           SetColHidden("chk",1);
	           SetColHidden("del_chk",1);
	           resizeSheet();//SetSheetHeight(585);
	           }


                 break;
         }
     }
     function resizeSheet(){
     	ComResizeSheet(sheetObjects[1]);
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
         switch(sAction) {
	       case IBCLEAR:
	          // Common - Character Retrieve
   			  formObj.f_cmd.value=SEARCH19;
   			  formObj.cd.value="CD01731";
   			  var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			  setIBCombo(sheetObjects[1], sXml, "rat_ut_grp_cd", true, 0);
			  // size combo
   			  formObj.f_cmd.value=SEARCH12;
   			  sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			  setIBCombo(sheetObjects[1], sXml, "cntr_sz_cd", true, 0);	
			  break;	
           case IBSEARCH:      //Retrieving
        	   try {
        		    sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
	        	    formObj.f_cmd.value=SEARCH;
	 			    //alert(FormQueryString(formObj));
	        	    sheetObj.DoSearch("ESM_PRI_4001GS.do", FormQueryString(formObj), {Sync:2} );
	 				ComOpenWait(false);
				 } catch (e) {
      	            if (e == "[object Error]") {
      	                ComShowMessage(OBJECT_ERROR);
      	            } else {
      	                ComShowMessage(e);
      	            }
      	       } finally {
      	    	   ComOpenWait(false);
      	       }	
 			  break;
           case IBSAVE:        
        	   formObj.f_cmd.value=MULTI;
				var sParam=FormQueryString(formObj);
				
				var sParamSheet1=sheetObjects[1].GetSaveString();
				if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
					return;
				}
				sParam += "&" + sParamSheet1;
				if (!ComPriConfirmSave()) {
					return false;
				}
				
				
				try {
					ComOpenWait(true);
					var sXml=sheetObjects[1].GetSaveData("ESM_PRI_4001GS.do", sParam);
					
					sheetObjects[1].LoadSaveData(sXml,{Sync:1});
					ComOpenWait(false);
					
				} catch (e) {
      	            if (e == "[object Error]") {
      	                ComShowMessage(OBJECT_ERROR);
      	            } else {
      	                ComShowMessage(e);
      	            }
      	       } finally {
      	    	   ComOpenWait(false);
      	       }	
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
       		 break;
         case IBINSERT: // Row Add
       		//sheetObj.DataAutoTrim = false;
        	var idx=sheetObj.DataInsert();
       		break;
       	 case IBDELETE: // Delete
       		//alert(sheetObj.id);
       		deleteRowCheck(sheetObj, "chk", true);
       		break;	 
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
      * @return bool <br>
      *          true  : valid<br>
      *          false : inValid
      * @author 
      * @version 2009.04.17
      */
     function validateForm(sheetObj,formObj,sAction){
       switch (sAction) {
       	case IBSEARCH:      //Retrieving
     		if (sheetObjects[1].IsDataModified()) {
     			if (ComShowCodeConfirm("PRI00006")) {
     				if (validateForm(sheetObjects[1],document.form,IBSAVE)) {
       					doActionIBSheet(sheetObjects[1], formObj, IBSAVE);       					
       				}
     				return false;
     			}
     		}
       		break;
     	case IBSAVE: // Saving
     		if (sheetObj.IsDataModified()) {
     			clearTooltip();
     			//Mandatory item check
     			var mandatory_check=sheetObj.GetSaveString(false);
     			if(mandatory_check ==""){
     				return false;
     			}
				 var rowM=sheetObj.ColValueDup("rat_ut_cd",false);
				 if (rowM >= 0) {
					 var msg=ComGetMsg("PRI00302");
					 for (var i=sheetObj.LastRow(); i >= 0; i--) {
						 if(sheetObj.GetCellValue(i,"rat_ut_cd") == sheetObj.GetCellValue(rowM,"rat_ut_cd")) {
			             	add2Tooltip(i, "rat_ut_cd", msg);
			             }
			         }
					 alert(msg);
				     return false;
			     }
				 
				 // Duplication Code Check
				 formObj.f_cmd.value=SEARCH02;
				 
	             var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
	             var sXml=sheetObjects[0].GetSearchData("ESM_PRI_4001GS.do", sParam);
	             var arrErr=ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
	             if (arrErr != null && arrErr.length > 0) {
	            	 var msg=ComGetMsg("PRI00302");
	            	 
	            	 for (var i=0; i < arrErr.length; i++) {
	            		 add2Tooltip(parseInt(ComGetValidRow(sheetObj, "rat_ut_cd", arrErr[i][2])), arrErr[i][1], msg);
	            	 }
	            	 alert(msg);
	            	 return false;
	             }
			} else {
				ComShowCodeMessage("PRI00301");
				return false;
			}
     		return true;
     		break;
     	}
         return true;
     }
     /**
      * Discard tooltip. <br>
      * <br><b>Example :</b>
      * <pre>
      *     clearTooltip()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function clearTooltip() {
     	var sheetObj=sheetObjects[1];
     	for (var i=sheetObj.HeaderRows(), n=sheetObj.HeaderRows()+sheetObj.RowCount(); i < n; i++) {
     		for (var j=0; j <= sheetObj.LastCol(); j++) {
     			sheetObj.SetCellBackColor(i, j,sheetObj.GetEditableColor());
     			sheetObj.SetToolTipText(i, j,"");
     		}
     	}
     }
     /**
      * Create tooltip. <br>
      * <br><b>Example :</b>
      * <pre>
      *     add2Tooltip(row, col, msg)
      * </pre>
      * @param {int} row
      * @param {int} col
      * @param {String} msg 
      * @return void
      * @author 
      * @version 2009.04.17
      */
     function add2Tooltip(row, col, msg) {
     	var sheetObj=sheetObjects[1];
     	sheetObj.SetCellBackColor(row, col,"#FF0000");
     	sheetObj.SetToolTipText(row, col ,  msg);
     }
     /**
      * Reset Whole objects in screen.<br>
      * Save in case of modified data.
      * <br><b>Example :</b>
      * <pre>
      *     searchConditionReset(formObj,gubun)
      * </pre>
      * @param {form} formObj 
      * @param {String} gubun    
      * @return void
      * @author 
      * @version 2009.06.10
      */
 	function removeAll(formObj) {
 		if (sheetObjects[1].IsDataModified()) {
 			if (ComShowCodeConfirm("PRI00006")) {
 				doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
 			} else {
 				formObj.reset();
		 		sheetObjects[1].RemoveAll();
 			}
 		} else {	
 			formObj.reset();
	 		sheetObjects[1].RemoveAll();
 		}
	}
 	/**
     * Execute when sheet clicked. <br>
     * make unchecked the Checkbox
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnClick(sheetObj, Row, Col, Value)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row 
     * @param {int} Col   
     * @param {String} Value   
     * @return void
     * @author 
     * @version 2009.06.10
     */
 	function sheet1_OnClick(sheetObj, Row, Col, Value)  {
 		var colName=sheetObj.ColSaveName(Col);
 		if (colName == "chk") {
 			if (Value == "0") {
 				sheetObj.SetCellValue(Row, "del_chk","0");
 			}
 		}	
 	}
 	/**
     * calling function in case of OnSaveEnd event.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {String} ErrMsg    
     * @return void
     * @author 
     * @version 2009.06.10
     */
 	function sheet1_OnSaveEnd(sheetObj, Code ,  ErrMsg)  {
 		if (ErrMsg == "") {
 			ComPriSaveCompleted();
 			//doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
 		}
 	}
