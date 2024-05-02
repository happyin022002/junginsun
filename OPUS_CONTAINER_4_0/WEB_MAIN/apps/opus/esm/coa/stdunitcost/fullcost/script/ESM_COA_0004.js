/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0004.js
*@FileTitle  : Node Cost (PA/RA) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // Grobla Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    	// Event handler processing by button name */
    	function processButtonClick(){
    		/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    		var sheetObject=sheetObjects[0];
    		var sheetObject1=sheetObjects[1];
    		/*******************************************************/
    		var formObject=document.form;
    		try {
    			var srcName=ComGetEvent("name");
    			if(ComGetBtnDisable(srcName)) return false;
    			switch(srcName) {
    				case "btn_new":
    					formObject.reset();
    					sheetObject.RemoveAll();
    					break;
    				case "btn_Retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				case "btn_Retrieve3":
    					if(initSheet2Condition(formObject)) {
    						doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
    					}
    					break;
    				case "btn_DownExcel":
    					if(sheetObject.RowCount() < 1){//no data
    						ComShowCodeMessage("COM132501");
    					}else{
    						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//        					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
    					}
    					break;
    				case "bu_zoom_in":
    					if(sheetObject1.RowCount()>10){
    						sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, sheetObject1.RowCount()+ 2));
    						div_zoom_out.style.display="inline";
    						div_zoom_in.style.display="none";	
    					}
    					break;
    				case "bu_zoom_out":
    					if(sheetObject1.RowCount()>10){
    						sheetObject1.SetSheetHeight(ComGetSheetHeight(sheetObject1, 10));
    						div_zoom_in.style.display="inline";
    						div_zoom_out.style.display="none";
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
			* initializing sheet
			* implementing onLoad event handler in body tag
			* adding first-served functions after loading screen.
    	*/
    	function loadPage() {
    		for(i=0;i<sheetObjects.length;i++){
    			//Sheet configuration setting function(start)
    			ComConfigSheet (sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//Sheet configuration setting function(end)
    			ComEndConfigSheet(sheetObjects[i]);
    		}  
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            // handling multi-combo object
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
    		ComSetFocus(document.form.f_loc_cd);
    	}
     /**
      * Function to initialize the IBCOMBO <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
			* @param {ibsheet} comboObj mandatory IBMultiCombo Object
			* @param {int} comboNo mandatory  The order of the IBMultiCombo
      * @return nothing
      */ 
       function initCombo(comboObj, comboId) {
      	 switch(comboObj.options.id) {
  	        case "f_act_grp_cd":
  	            with(comboObj) {
//  	            	SetDropHeight(500);
  	            	SetMultiSelect(0);
  	            	SetMaxSelect(1);
  	            	SetMaxLength(30);
  	            	SetUseAutoComplete(1);
  	            	ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
  	            	SetSelectIndex(0);
  	            }
  	            break;
  	        case "f_cntr_tpsz_cd":
  	            with(comboObj) {
//  	            	SetDropHeight(500);
  	            	SetMultiSelect(0);
  	            	SetMaxSelect(1);
  	            	SetMaxLength(3);
  	            	SetUseAutoComplete(1);
  	            	ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
  	            	SetSelectIndex(0);
  	            }
  	            break;
  	        case "f_cost_loc_grp_cd":
  	            with(comboObj) {
//  	            	SetDropHeight(500);
  	            	SetMultiSelect(0);
  	            	SetMaxSelect(1);
  	            	SetMaxLength(4);
  	            	SetUseAutoComplete(1);
  	            	ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
  //no support[check again]CLT 	            	ValidChar(2, 0);	//Upper case
  	            	SetSelectIndex(4);
//  	            	DeleteItem(5);				//20160303.DEL : 요청
//  	            	DeleteItem(2);
  	            	
  	            }
  	            break;	 
  	    }
    }	
    	/**
				* setting sheet initial values and header
				* param : sheetObj, sheetNo
				* adding case as numbers of counting sheets
    	*/
    	function initSheet(sheetObj,sheetNo) {
    		var cnt=0;
    		if(sheetNo==1) {
    		    with(sheetObj){
    		    	//no support[check again]CLT 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//setting Host information[mandatory][HostIp, Port, PagePath]
    		    	var HeadTitle="Yard|Yard Name|Lane|B/D|Select" ;
    		    	

    		    	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );

    		    	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    		    	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		    	InitHeaders(headers, info);

    		    	var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		    	             {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"yd_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		    	             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slan_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		    	             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		    	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel_check",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"  } ];
    		       
    		    	InitColumns(cols);

    		    	SetEditable(0);//Editkind[optional,Defaultfalse]
    		    	SetCountPosition(0);
    		    	SetWaitImageVisible(0);
    		    	//SetSheetHeight(200);
    		    	SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
    		    	InitComboNoMatchText(1,"",1);

    		            //no support[check again]CLT 				style.height=GetSheetHeight(8) ;
    		    }
    		} else if(sheetNo==2) {
    		    with(sheetObj){
    		    	//no support[check again]CLT 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//setting Host information[mandatory][HostIp, Port, PagePath]
    		    	var HeadTitle="A/G|Cost Element/Cost Code|Ctrt/Avg|Curr.|Cost|Speical|Location\nHierarchy|Lvl" ;

//    		    	SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
					SetConfig( { SearchMode:2, Page:100, DataRowMerge:0, MergeSheet:7  } );

    		    	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    		    	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		    	InitHeaders(headers, info);

    		    	var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"grp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//    		    	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   TreeCol:1 ,  LevelSaveName:"" },
    		    	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
    		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_ass_bse_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"locl_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		    	             {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cost",             KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"spcl",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_type",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, 
    		    	  			 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lvl" } ];
       		       
    		    	InitColumns(cols);

    		    	SetEditable(0);//Editkind[optional,Defaultfalse]
    		    	SetCountPosition(0);
    		    	SetWaitImageVisible(0);
    		    	//SetSheetHeight(200);
//    		    	SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
    		    	resizeSheet();
    		    	InitComboNoMatchText(1,"",1);
    		        //    InitTreeInfo(1, "", "#0000FFNAN";
    		      //no support[check again]CLT 				style.height=GetSheetHeight(10) ;
    		    }
    		} else if(sheetNo==3) {
    		    with(sheetObj){
    		    	//no support[check again]CLT 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//setting Host information[mandatory][HostIp, Port, PagePath]
    		    	var HeadTitle="A/G|Cost Element/Cost Code|Ctrt/Avg|Curr.|Cost|Speical|Location\nHierarchy|Lvl" ;

//    		    	SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
					SetConfig( { SearchMode:2, Page:100, DataRowMerge:0, MergeSheet:7  } );

    		    	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    		    	var headers = [ { Text:HeadTitle, Align:"Center"} ];
    		    	InitHeaders(headers, info);

    		    	var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"grp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//    		    	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   TreeCol:1 ,  LevelSaveName:"" },
    		    	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
    		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_ass_bse_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"locl_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		    	             {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cost",             KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"spcl",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_type",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, 
    		    	  			 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lvl" } ];
       		       
    		    	InitColumns(cols);

//    		    	SetEditable(0);//Editkind[optional,Defaultfalse]
//    		    	SetCountPosition(0);
//    		    	SetWaitImageVisible(0);
//    		    	//SetSheetHeight(200);
////    		    	SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
//    		    	resizeSheet();
//    		    	InitComboNoMatchText(1,"",1);
    		        //    InitTreeInfo(1, "", "#0000FFNAN";
    		      //no support[check again]CLT 				style.height=GetSheetHeight(10) ;
    		    }
    		}
    	}
    	/**
    	* Setting a search condition of the bottom tab by default
    	* fobj: Form object
    	*/
    	function initSheet2Condition(fobj){
    	    var rt=true;
    		if(fobj.f_cost_yrmon.value == "") {
    			ComShowCodeMessage('COA10002','YYYY-MM');
    			ComSetFocus(fobj.f_cost_yrmon);
    			rt=false;
    		} else {
    		}		
    		return rt;
    	}
    	/**
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
    	*/
    	function setSheetObject(sheet_obj){
    		sheetObjects[sheetCnt++]=sheet_obj;
    	}
    	/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++]=combo_obj;
        }
        function sheet1_OnSearchEnd(shtObj, ErrMsg) {
    		ComOpenWait(false);
        }			
    	/**
    	* Details are viewed by double-clicking on sheet1
    	*/
    	function sheet1_OnDblClick(sheetObj , row, col){
    		var sheetObject1=sheetObjects[1];
    		//Setting current date
    		var formObject=document.form;
    		formObject.f_cost_yrmon.value=ComGetNowInfo("ym");
    		sheetObj.SetCellValue(row,"sel_check",1,0);
    		//Initialize others check box except row selected
    		var crCnt=sheetObj.CheckedRows("sel_check");
    		if(crCnt>0){
    			var chRow=sheetObj.FindCheckedRow("sel_check");
     			var ckArr=chRow.split("|");
    			for(var k=0; k<ckArr.length; k++) {
    				if(ckArr[k] != row) {
    					sheetObj.SetCellValue(ckArr[k],"sel_check",0,0);
    				}
     			}
    		}
    		if(initSheet2Condition(formObject))	doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
    	}
    	/**
    	* Display total of the sub cost per the group after sheet1 detail inquiry
    	*/
    	function sheet2_OnSearchEnd(sheetObj, errMessge) {
    		ComOpenWait(false);
    		for (i=1;i<=sheetObj.RowCount();i++) {
    			if (sheetObj.GetCellValue(i,"lvl") == "1") {
    				sheetObj.SetCellValue(i,"cost_nm", "+ " + sheetObj.GetCellValue(i,"cost_nm"));
    			} else if (sheetObj.GetCellValue(i,"lvl") == "2") {		//child 데이터는 ' -'를 앞에 달고, 최초에는 숨기기
    				sheetObj.SetCellValue(i,"cost_nm", "  └ " + sheetObj.GetCellValue(i,"cost_nm"));
    				sheetObj.SetRowHidden(i,1);
    			}
    		}
//    		sheetObj.ShowTreeLevel(0, 1);
            sheetObj.SetSumText(0,0, "TOTAL");
			sheetObj.SetDataMerge();
    	}
    	/**
    	* Display total of the sub cost per the group after sheet1 detail inquiry
    	*/
    	function sheet3_OnSearchEnd(sheetObj, errMessge) {
    		for (i=1;i<=sheetObj.RowCount();i++) {
    			if (sheetObj.GetCellValue(i,"lvl") == "2") {		//child 데이터는 ' -'를 앞에 달고, 최초에는 숨기기
    				sheetObj.SetCellValue(i,"cost_nm", "  - " + sheetObj.GetCellValue(i,"cost_nm"));
    				sheetObj.SetRowHidden(i,1);
    			}
    		}
//    		sheetObj.ShowTreeLevel(0, 1);
            sheetObj.SetSumText(0,0, "TOTAL");
			sheetObj.SetDataMerge();
    	}
    	/**
    	* Handling sheet process 1
    	*/
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg(false);
    		switch(sAction) {
	    		case IBCLEAR:		        	
					ComOpenWait(true);
					var sXml=formObj.sXml.value; 					
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0) {
						ComXml2ComboItem(arrXml[0],f_cntr_tpsz_cd, "code", "code");
					}
					if (arrXml.length > 1) {
						ComXml2ComboItem(arrXml[1], f_act_grp_cd, "code", "name");
						comboObjects[1].InsertItem(0, 'All', '');
					}
					if (arrXml.length > 2) {
						ComXml2ComboItem(arrXml[2],f_cost_loc_grp_cd, "code", "name");
					}
					ComSetObjValue(formObj.sXml, "");
					ComOpenWait(false);
					break;	
    			case IBSEARCH:		//Inquiry
    				if(validateForm(sheetObj,formObj,sAction)){
    					// Prohibit button click when a business transaction is processing 
    					ComOpenWait(true);
    					formObj.f_cmd.value=SEARCH01;
    					//initSheet2Condition(formObj);
    					sheetObj.DoSearch("ESM_COA_0004GS.do", coaFormQueryString(formObj));
    					sheetObjects[1].RemoveAll();
    					ComOpenWait(false);
    				}
    				break;
    			case IBDOWNEXCEL:	// Excell download
//    					downloadExcelProc(sheetObj);
    					var excelType=selectDownExcelMethod(sheetObj, "0");
    				break;
    		}
    	}
    	/**
    	* Handling sheet process 2
    	*/
    	function doActionIBSheet2(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg(false);
    		switch(sAction) {
    			case IBSEARCH:		//Inquiry
    				if(validateForm(sheetObj,formObj,sAction)){
    					if(sheetObjects[0].RowCount()>0){		//When there are data on the sheet
    						if(sheetObjects[0].CheckedRows("sel_check")>0){		//If the rows are checked
    							// Prohibit button click when a business transaction is processing 
    							ComOpenWait(true);
    							formObj.f_cmd.value=SEARCH02;    							
//method change[check again]CLT    							
    							sheetObj.DoSearch("ESM_COA_0004GS2.do", coaFormQueryString(formObj) +"&" + sheetObjects[0].GetSaveString(false, true, "sel_check"));							
    							sheetObjects[2].DoSearch("ESM_COA_0004GS2.do", coaFormQueryString(formObj) +"&" + sheetObjects[0].GetSaveString(false, true, "sel_check"));
//    							ComOpenWait(false);
    						} else {
    							ComShowCodeMessage('COM12113', 'Sheet1 Select CheckBox');
    						}
    					} else {
    						ComShowCodeMessage('COA10005', 'Sheet1');
    					}
    				}
    				break;
    			case IBDOWNEXCEL:	// Excell download
//    				downloadExcelProc(sheetObj);
    				var excelType=selectDownExcelMethod(sheetObj);    				
    				break;
    		}
    	}
    	
    	/**
    	* Download Excel
    	*/
    	function callBackExcelMethod(excelType){    	
	    	callBackExcelMethod2(excelType[0], excelType[1]);
	   	}
    	
//    	function sheet1_OnDownFinish(downloadType, result) {
//    		var sheetObject1=sheetObjects[1];
//			selectDownExcelMethod(sheetObject1, "1");
//    	}
    	
    	function callBackExcelMethod2(excelType, shtNo){
//    		if (shtNo == "1") {
//    			shtNo = "2";
//    		}
//    	    var sheetObj = sheetObjects[shtNo];
    	    switch (excelType) {
	            case "AY":
	            	sheetObjects[0].Down2ExcelBuffer(true);
	                sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	                sheetObjects[2].Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	            	sheetObjects[0].Down2ExcelBuffer(false);
	                break;
	            case "AN":
	            	sheetObjects[0].Down2ExcelBuffer(true);
	            	sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	            	sheetObjects[2].Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	            	sheetObjects[0].Down2ExcelBuffer(false);
			    	break;
	            case "DY":
	            	sheetObjects[0].Down2ExcelBuffer(true);
//	            	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
	            	sheetObjects[0].Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	            	sheetObjects[2].Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	            	sheetObjects[0].Down2ExcelBuffer(false);
	            	break;
	            case "DN":
	            	sheetObjects[0].Down2ExcelBuffer(true);
//			    	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
			    	sheetObjects[0].Down2Excel({HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
			    	sheetObjects[2].Down2Excel({HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	            	sheetObjects[0].Down2ExcelBuffer(false);
			    	break;

    		}
	   	}
    	
    	/**
    	* Handling process for form object input validation
    	*/
    	function validateForm(sheetObj,formObj,sAction){    		
    		var rt=false;    		
    		if(formObj.f_loc_cd.value == "") {
    			ComShowCodeMessage('COA10002', 'Location');    			
    			ComSetFocus(formObj.f_loc_cd);
    			rt=false;
    		} else {
    			rt=true;
    		}
    		return rt;
    	}
    	/**
    	* Deactivate Activity Group Combo when the Empty selected
    	*/
    	function hideActGrpCombo(){
    		f_act_grp_cd.Setdisabled(true);
    	}
    	/**
    	* Activate Activity Group Combo when the Full selected
    	*/
    	function showActGrpCombo(){
    		f_act_grp_cd.SetDisabled(false);
    	}
    	
    	
        function sheet2_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "cost_nm":
        		var mark=sheetObj.GetCellValue(row, "lvl");
        		var status=sheetObj.GetRowStatus(row);
        		if(mark == "3"){
					var startRow = row + 1;
					var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
					sheetObj.SetCellValue(row,"lvl","1");
    				sheetObj.SetCellValue(row,"cost_nm", "+"+sheetObj.GetCellValue(row,"cost_nm").substr(1));
					for(;startRow <= endRow;startRow++){
						sheetObj.SetRowHidden(startRow,1);
					}
        		}
        		else if(mark == "1"){
					var startRow = row + 1;
					var endRow = sheetObj.GetMergedEndCell(row+1, "lvl").split(",")[0];
					for(;startRow <= endRow;startRow++){
						sheetObj.SetRowHidden(startRow,0);
					}
    				sheetObj.SetCellValue(row,"cost_nm", "-"+sheetObj.GetCellValue(row,"cost_nm").substr(1));
       				sheetObj.SetCellValue(row, "lvl", "3");
        		}
    			sheetObj.SetDataMerge();
        		break;
        	}
        }

        function resizeSheet(){
       	 ComResizeSheet(sheetObjects[1]);
        }
