/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_07.js
*@FileTitle  : SC Guideline Contract Clause
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0001_07 : business script for ESM_PRI_0001_07
     */
    function ESM_PRI_0001_07() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var enableFlg=true;
    var sChgCdVisiable="";
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
	  * Event handler processing by button name  <br>
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
                case "btn_retrieve":
                	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
				case "btn_RowAdd1":
					doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
					break;
				case "btn_Delete1":
					doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
					break;
				case "btn_RowAdd2":
					doActionIBSheet(sheetObjects[1],formObject,IBINSERT);
					break;
				case "btn_Delete2":
					doActionIBSheet(sheetObjects[1],formObject,IBDELETE);
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
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            resizeSheet();
//            doActionIBSheet(sheetObjects[0], document.form, IBCREATE);  
            //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
            toggleButtons("CLEAR");
            parent.loadTabPage();
            sheet2_OnLoadFinish(sheetObjects);
        }
        /**
         * calling function when occurring LoadFinish event <br>
         */
        function sheet2_OnLoadFinish(sheetObj) {
	       	 doActionIBSheet(sheetObjects[1], document.form, IBCREATE); 
	    }
        /**
         * setting sheet initial values and header <br>
         * adding case as numbers of counting sheets <br>
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		var sheetID=sheetObj.id;
            switch(sheetID) {
            case "sheet1":
                with(sheetObj){
              
             var HeadTitle="|Sel.|Del Check.|Seq.|Item|svc_scp_cd|gline_seq|ctrt_cluz_seq";
             var headCount=ComCountHeadTitle(HeadTitle);
             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Seq",       Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);
             resizeSheet(); //SetSheetHeight(380);
             SetEditable(1);
             SetWaitImageVisible(0);
             SetColHidden("del_chk",1);
             }


                break;
            case "sheet2":
                with(sheetObj){
               
              var HeadTitle="|Sel.|Del Check.|Seq.|Surcharge|Clause|svc_scp_cd|gline_seq|note_clss_cd|ctrt_cluz_dtl_seq";
              var headCount=ComCountHeadTitle(HeadTitle);
              (headCount, 0, 0, true);

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Seq",       Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                     {Type:"Combo", Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"chg_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_ctnt",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:200 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
              resizeSheet(); //SetSheetHeight(380);
              SetEditable(1);
              SetWaitImageVisible(0);
              SetColHidden("del_chk",1);
              //SetAutoRowHeight(0);
              }


                break;
            }
        }
        
        function resizeSheet() {
        	ComResizeSheet(sheetObjects[0]);
        	ComResizeSheet(sheetObjects[1]);
    	}
        
        /*function sheet1_OnClick(sheetObj, Row, Col, Value)  {
     		var colName=sheetObj.ColSaveName(Col);
     		if (colName == "chk") {
     			if (Value == "0") {
     				sheetObj.SetCellValue(Row, "del_chk","0");
     			}
     			var sCols="svc_scp_cd|gline_seq|ctrt_cluz_seq";
var sVals=sheetObj.GetCellValue(Row, "svc_scp_cd") + "|" +
sheetObj.GetCellValue(Row, "gline_seq")  + "|" +
sheetObj.GetCellValue(Row, "ctrt_cluz_seq");
     			var arrIdx=ComPriSheetFilterRows(sheetObjects[1], sCols, sVals);
     			if (arrIdx == null || arrIdx.length == 0) {
     				return;
     			}
     			for (var i=0; i < arrIdx.length; i++) {
     				sheetObjects[1].SetCellValue(arrIdx[i], "chk",Value);
     				if (Value == "0") {
     					sheetObjects[0].SetCellValue(arrIdx[i], "del_chk",Value);
     				}
     			}
     		}
     	}
     	function sheet2_OnClick(sheetObj, Row, Col, Value)  {
     		var colName=sheetObj.ColSaveName(Col);
     		if (colName == "chk") {
     			if (Value == "0") {
     				sheetObj.SetCellValue(Row, "del_chk","0");
     			}
     		}
     	}*/
        /**
         * occurring before clicking check button on the sheet <br>
         */
        function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
    		var colName=sheetObj.ColSaveName(Col);
    		if (colName == "chk") {
    			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
    		}
    	}
        /**
         * occurring before clicking check button on the sheet <br>
         */
    	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
    		var colName=sheetObj.ColSaveName(Col);
    		if (colName == "chk") {
    			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
    		}
    	}
    	/**
         * calling function when clicking sheet's cell <br>
         */
    	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
    	}
        var isFiredNested=false;
    	var supressConfirm=false;
    	/**
         * calling function when occurring sheet1_OnSelectCell event <br>
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
    				formObj.f_cmd.value=SEARCH02;
    				formObj.ctrt_cluz_seq.value=sheetM.GetCellValue(adjNewRow, "ctrt_cluz_seq");
    				if(formObj.ctrt_cluz_seq.value == "undefined" || ComIsEmpty(formObj.ctrt_cluz_seq.value)) {
    					formObj.ctrt_cluz_seq.value=sheetM.GetCellValue(sheetM.GetSelectRow(),"ctrt_cluz_seq");
                    }
    				// charge code
    				var sCd=sheetD.GetComboInfo(0,"chg_cd","Code");
    				var sNm=sheetD.GetComboInfo(0,"chg_cd","Text");
    				////////////////////////////////////////////////////////////////////////////////	
      				formObj.f_cmd.value=SEARCH02;
      				var sXml=sheetD.GetSearchData("ESM_PRI_0001_07GS.do", FormQueryString(formObj));
      				var arrData=ComPriXml2Array(sXml, "chg_cd");			
    				if (arrData != null && arrData.length > 0) {
    					for(var i=0; i<arrData.length; i++){
    						if (sCd.indexOf(arrData[i][0]) < 0) {
    							sCd += "|" + arrData[i][0];
    							sNm += "|" + arrData[i][0];
    						}
    					}					
    					sheetD.SetColProperty("chg_cd",{ComboText:sNm, ComboCode:sCd} );
    				}			
    				sheetD.LoadSearchData(sXml,{Sync:0} );
    			}
    		}
    	}
    	/**
         * setting surcharge combo hidden by selected item state<br>
         */
     	function setSurchargeCombo()  {
    		var formObj=document.form;
    		var note_clss_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"note_clss_cd");
     		//alert(note_clss_cd)
  	    	if(note_clss_cd == "S") {
  	    		sheetObjects[1].SetColHidden("chg_cd",0);
  	    	} else {
  	    		sheetObjects[1].SetColHidden("chg_cd",1);
  	    		//for(var k = 1; k<=sheetObjects[1].RowCount;k++){
  	    			//sheetObjects[1].InitDataCombo(0, "chg_cd", "|", "", "", "");
   	   		   // }
  	    		// Surcharge combo
//    			formObj.f_cmd.value = COMMAND12;
//    			formObj.etc1.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"note_clss_cd");
//				sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//				setIBCombo(sheetObjects[1],sXml,"chg_cd",true,0);
  	    	}
  	    	//////////////////////////////////////////////////////////////////////////		
    	}
     	/**
         * calling event when changing sheet data <br>
         */
     	function sheet1_OnChange(Row,Col,Value) {
     		//sheetObjects[1].RemoveAll();
     		setSurchargeCombo();
     	}
     	/**
         * calling event when changing sheet data <br>
         */
     	function sheet2_OnSearchEnd(ErrMsg) {
     		setSurchargeCombo();
     	}
     	/**
         * Handling sheet process <br>
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
	    		case IBCREATE: // when screen loading code retrieve
	    			//comon
	    			formObj.f_cmd.value=SEARCH19;
	    			formObj.cd.value="CD01711";
	    			sheetObjects[0].SetWaitImageVisible(0);
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
					setIBCombo(sheetObjects[0],sXml,"note_clss_cd",true,0);
//					// Surcharge combo
//	    			formObj.f_cmd.value = COMMAND12;
//					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//					setIBCombo(sheetObjects[1],sXml,"chg_cd",true,0);
					break;
	    		case IBSEARCH:      //retrieve
	    			if (validateForm(sheetObj,document.form,sAction)) {
	    				try {
	    					for (var i=0; i < sheetObjects.length; i++) {
	                        	sheetObjects[i].SetWaitImageVisible(0);
	                        }
		        		    ComOpenWait(true);
		   					if ( sheetObj.id == "sheet1") {
		   						for (var i=0; i < sheetObjects.length; i++) {
		   							sheetObjects[i].RemoveAll();
		   						}
		 	            	   	formObj.f_cmd.value=SEARCH01;
		 	            	   	sheetObjects[0].DoSearch("ESM_PRI_0001_07GS.do", FormQueryString(formObj) );
			       		    }	
		   					ComOpenWait(false);
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
	                break;
    			case IBSAVE:        //save
    				if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
    					return false;
    				}
    				formObj.f_cmd.value=MULTI01;
    				var sParam=FormQueryString(formObj);
    				var sParamSheet1=sheetObjects[0].GetSaveString();
	 				if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
	 					return;
	 				}
    				if (sParamSheet1 != "") {
    					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
    				}
    				var sParamSheet2=sheetObjects[1].GetSaveString();
    				if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
	 					return;
	 				}
    				if (sParamSheet2 != "") {
    					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
    				}
    				//alert(sParam);
    				if (!supressConfirm && !ComPriConfirmSave()) {
    					return false;
    				}
    				try {
        			    ComOpenWait(true);
        			    var sXml=sheetObj.GetSaveData("ESM_PRI_0001_07GS.do", sParam);
        			    sheetObjects[1].LoadSaveData(sXml);
        			    sheetObjects[0].LoadSaveData(sXml);
	    				ComOpenWait(false);
        		   } catch (e) {
        	            if (e == "[object Error]") {
        	                ComShowMessage(OBJECT_ERROR);
        	            } else {
        	                ComShowMessage(e.message);
        	            }
        	       } finally {
        	    	   ComOpenWait(false);
        	       }
    				if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
    					return false;
    				} else {
    					parent.setTabStyle();
    					ComPriSaveCompleted();
    					if (getValidRowCount(sheetObjects[0]) >= 1 && getValidRowCount(sheetObjects[1]) <= 0) {
							doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol(), false);
						}
    					return true;
    				}
    				break;
				case IBINSERT:       
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (sheetObj.id == "sheet1") {
						//var idx = doRowChange(sheetObj, sheetObjects[1], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, true);
						var idx=doRowChange(sheetObj, sheetObjects[1], sheetObj.GetSelectRow(), sheetObj.GetSelectRow()+ 1, sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), true);
						if (idx < 0) {
							return false;
						}
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
						sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
						sheetObj.SetCellValue(idx, "ctrt_cluz_seq",parseInt(ComPriGetMax(sheetObj, "ctrt_cluz_seq")) + 1);
						sheetObjects[1].RemoveAll();
						sheetObj.SelectCell(idx, "note_clss_cd");
					}
					if (sheetObj.id == "sheet2") {
						var idx=sheetObj.DataInsert();
						setSurchargeCombo();
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
						sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
						var ctrt_cluz_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ctrt_cluz_seq");
						sheetObj.SetCellValue(idx, "ctrt_cluz_seq",ctrt_cluz_seq);
						sheetObj.SetCellValue(idx, "ctrt_cluz_dtl_seq",parseInt(ComPriGetMax(sheetObj, "ctrt_cluz_dtl_seq")) + 1);
						if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "S") {
							sheetObj.SelectCell(idx, "chg_cd");
						} else {
							sheetObj.SelectCell(idx, "note_ctnt");
						}
					}
					break;
				case IBDELETE: // Delete
//					deleteRowCheck(sheetObj, "chk");
//					if (sheetObj.id == "sheet1") {
//						deleteRowCheck(sheetObjects[1], "chk");
//					} 
//					break;
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
		        	}
		        	var delCnt=deleteRowCheck(sheetObj, "chk");
					if (delCnt > 0 && sheetObj.id == "sheet1") {
						for (var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && i <= sheetObjects[1].LastRow(); i++) {
							sheetObjects[1].SetCellValue(i, "chk","1");
						}
						deleteRowCheck(sheetObjects[1], "chk");
					}
					break;
            }
        }
        /**
         * checking validation process of inputed form data <br>
         */
        function validateForm(sheetObj,formObj,sAction){
     		switch (sAction) {
    		case IBSEARCH: // retrieve
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				ComShowCodeMessage('PRI08001');
    				return false;
    			} 
    			return true;
    			break;
    		case IBSAVE: // save
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				ComShowCodeMessage('PRI08001');
    				return false;
    			} 
    			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
        			ComShowCodeMessage("PRI00301");
        			return false;
        		}
				if (sheetObjects[0].IsDataModified()) {
					 var rowM=sheetObjects[0].ColValueDup("svc_scp_cd|gline_seq|note_clss_cd",false);
					 if (rowM >= 0) {				 
						 ComShowCodeMessage("PRI00303", "Sheet1", rowM);
					     return false;
					 }
				}  
				if (sheetObjects[1].IsDataModified()) {
					 var rowM=sheetObjects[1].ColValueDup("svc_scp_cd|gline_seq|ctrt_cluz_seq|ctrt_cluz_dtl_seq",false);
					 if (rowM >= 0) {				 
						 ComShowCodeMessage("PRI00303", "Sheet2", rowM);
					     return false;
					 }
				}   
	       		if (sheetObjects[0].RowCount()<= 0 || sheetObjects[0].GetSelectRow()<= 0) {
	       			ComPriInputValueFailed("input","Item","");
	       			doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                    return false;
                }
	       		if (getValidRowCount(sheetObjects[0]) >= 1 && (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0)) {
	       			ComShowCodeMessage("PRI00319", "Clause");
	       			doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
    			return true;
    			break;
    		case IBINSERT: // Row Add
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				ComShowCodeMessage('PRI08001');
    				return false;
    			} else {
    				return true;
    			}
    			break;
    		case IBDELETE: // Delete
    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
    				ComShowCodeMessage('PRI08001');
    				return false;
    			} else {
    				return true;
    			}
    			break;
    		}        
            return true;
        }
    	/**
         * calling function when occurring OnClick Event <br>
         */  	           
         function sheet2_OnClick(sheetObj, Row, Col, Value) {
    	    //showing memopad when clicking desc cell (MemoPad editable)
    	    var colname=sheetObj.ColSaveName(Col);
         	switch(colname)
         	{
     	    	case "ctrt_cluz_ctnt":
     	    		ComShowMemoPad(sheetObj,Row,Col,false,678,200);
     	    		break;
         	}    	 
         }
         function toggleButtons(mode) {
     		switch (mode) {
     		case "CLEAR":
     			ComBtnDisable("btn_Retrieve");
     			ComBtnDisable("btn_Save");
     			ComBtnDisable("btn_RowAdd1");
     			ComBtnDisable("btn_Delete1");
     			ComBtnDisable("btn_RowAdd2");
     			ComBtnDisable("btn_Delete2");
     			break;
     		case "INIT":
     			ComBtnEnable("btn_Retrieve");
     			ComBtnEnable("btn_Save");
     			ComBtnEnable("btn_RowAdd1");
     			ComBtnEnable("btn_Delete1");
     			ComBtnEnable("btn_RowAdd2");
     			ComBtnEnable("btn_Delete2");
     			break;
     		case "READONLY":
     			ComBtnEnable("btn_Retrieve");
     			ComBtnDisable("btn_Save");
     			ComBtnDisable("btn_RowAdd1");
     			ComBtnDisable("btn_Delete1");
     			ComBtnDisable("btn_RowAdd2");
     			ComBtnDisable("btn_Delete2");
     			break;
     		}
     	}
//         function tabLoadSheet(sSvcScpCd, sGlineSeq) {
//     		var formObject = document.form;
//     		
//     		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
//     			formObject.svc_scp_cd.value = sSvcScpCd;
//     			formObject.gline_seq.value = sGlineSeq;
//     			
//     			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
//     			
//     			if (enableFlag) {
//     				toggleButtons("INIT");
//     			} else {
//     				toggleButtons("READONLY");
//     			}
//     		}
//     	}
//     	
//     	function tabClearSheet() {
//     		var formObject = document.form;
//     		
//     		formObject.svc_scp_cd.value = "";
//     		formObject.gline_seq.value = "";
//     		
//     		sheetObjects[0].RemoveAll();
//     		sheetObjects[1].RemoveAll();
//     		
//     		toggleButtons("CLEAR");
//     	}
//     	
//     	var enableFlag = true;
//     	function tabEnableSheet(flag) {
//     		var formObject = document.form;
//     		
//     		enableFlag = flag;
//     		
//     		sheetObjects[0].Editable = flag;
//     		sheetObjects[1].Editable = flag;
//     		
//     		if (enableFlag) {
//     			toggleButtons("INIT");
//     		} else {
//     			toggleButtons("READONLY");
//     		}
//     	}
         /**
          * calling from main<br>
          * setting tab screen with activate mode on main<br>
          */
         function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
     		var formObject=document.form;
     		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
     			formObject.svc_scp_cd.value=sSvcScpCd;
     			formObject.gline_seq.value=sGlineSeq;
     			// Surcharge combo
//     			formObject.f_cmd.value = COMMAND12;
//     			formObject.etc1.value = sSvcScpCd;
//     			
//				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObject));
//				setIBCombo(sheetObjects[1],sXml,"chg_cd",true,0,"","",true);
     			formObject.etc1.value=sSvcScpCd;
     			initComboChargeCode(sheetObjects[1], formObject);
				// Surcharge combo
     			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
     			if (enableFlag && isAproUsr) {
     				toggleButtons("INIT");
     			} else {
     				toggleButtons("READONLY");
     			}
     		}
     	}
         /**
          * initializing SURCHARGE code <br>
          * getting SURCHARGE list by SCOPE CODE <br>
          */
      	function initComboChargeCode(sheetObj, formObj) {
      		var sCd="";
      		var sNm="";
      		formObj.f_cmd.value=COMMAND12;
      		var tXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
      		var arrData=ComPriXml2ComboString(tXml, "cd", "nm");
      		if (arrData != null){
      		    var arrCode=arrData[0].split("|");
      		    var arrName=arrData[1].split("|");
      		    var conData="";
      		    for(i=0; i < arrName.length;i++){
      		        if(i==0){
      		            arrName[i]=arrCode[i]+"\t"+arrName[i];
      		        }else{
      		            arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
      		        }
      		        conData=conData.concat(arrName[i]);
      		    }
      		    arrData[1]=conData;
      		}
      		if (arrData != null){
      			sCd=" |" + arrData[0];
      			sNm=" |" + arrData[1];			        
      		} else {
      			sCd=" |";
      			sNm=" |";
      		}
      		sChgCdVisiable=sNm;
      		sheetObj.SetColProperty("chg_cd", {ComboText:sNm, ComboCode:sCd} );
      	}
      	/**
 	    * calling function when occurring OnChange Event <br>
 	    */  
 	    function sheet2_OnChange(sheetObj, Row, Col, Value) {
 			var colName=sheetObj.ColSaveName(Col);
 			var formObj=document.form;
 			switch(colName)
 	    	{
 				case "chg_cd":					
 					if (Value != null && Value != "" && Value.length == 3) {
 						var sCode=sheetObj.GetComboInfo(0, "chg_cd", "Code");
 						var sText=sheetObj.GetComboInfo(0, "chg_cd", "Text");
 						if (sChgCdVisiable.indexOf("|"+Value) < 0) {
 							formObj.f_cmd.value=COMMAND09;
 							formObj.etc1.value=Value;
 							sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
 							var arrData=ComPriXml2Array(sXml, "cd|nm");
 							if (arrData != null && arrData.length > 0) {
 								sCode += "|" + Value;
 								sText += "|" + Value;
 								sheetObj.SetColProperty("chg_cd", {ComboText:sText , ComboCode:sCode} );
 								ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
 							} else {
 								sheetObj.SetCellValue(Row, "chg_cd","",0);
 							}
 						}
 					} else {
 						sheetObj.SetCellValue(Row, "chg_cd","",0);
 					}
 					break;
 	    	}
 		}
         /**
          * calling from main<br>
          * initailizing tab screen <br>
          */
     	function tabClearSheet() {
     		var formObject=document.form;
     		formObject.svc_scp_cd.value="";
     		formObject.gline_seq.value="";
//     		formObject.grp_loc_seq.value = "";
     		sheetObjects[0].RemoveAll();
     		sheetObjects[1].RemoveAll();
     		toggleButtons("CLEAR");
     	}
     	var enableFlag=true;
     	/**
         * calling from main<br>
         * initailizing tab screen<br>
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
     	
     	function sheet1_OnSaveEnd(sheetObj, code, errMsg) {
     		sheetObj.ColumnSort();
	   	}      
     	
     	function sheet2_OnSaveEnd(sheetObj, code, errMsg) {
     		sheetObj.ColumnSort();
	   	}      

