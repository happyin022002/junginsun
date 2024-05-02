/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0070.jsp
 *@FileTitle : Segregation Group - Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0070 : business script for vop_scg_0070 
     */
    function vop_scg_0070() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var prefixs=new Array("sheet1_","sheet2_");  
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick() {
		/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified. *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var formObj=document.form; 
		/*******************************************************/
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn2_Row_Add":
					sheetObject1.DataInsert(-1,0);								//create at last row[Sheet1]
					initCell(sheetObject1, sheetObject1.GetSelectRow(), 2, false);	//selected cell initialize
					break;
				case "btn2_Row_Add2":
					sheetObject2.DataInsert(-1,0);								//create at last row[Sheet2]
					copySheetCell();											//copy group NO
					initCell(sheetObject2, sheetObject2.GetSelectRow(), 4, false);	//selected cell initialize
					break;
				case "btn2_Row_Insert":
					sheetObject1.DataInsert();									//create below selected row[Sheet1]
					initCell(sheetObject1, sheetObject1.GetSelectRow(), 2, false);	//selected cell initialize
					break;
				case "btn2_Row_Insert2":
					sheetObject2.DataInsert();									//create below selected row[Sheet2]
					copySheetCell();											//copy group NO
					initCell(sheetObject2, sheetObject2.GetSelectRow(), 4, false);	//selected cell initialize
					break;
				case "btn2_Row_Copy":
					sheetObject1.DataCopy();									//copy below selected row[Sheet1]
					initCell(sheetObject1, sheetObject1.GetSelectRow(), 2, false);	//selected cell initialize
					break;
				case "btn2_Row_Copy2":
					sheetObject2.DataCopy();									//create below selected row[Sheet2]
					initCell(sheetObject2, sheetObject2.GetSelectRow(), 4, false);	//selected cell initialize
					break;
				case "btn2_Row_Delete":
					deletRowCheck(formObj, sheetObject1, sheetObject2, prefixs[0]+"del_chk");
					ComRowHideDelete(sheetObject1, prefixs[0]+"del_chk");					
					break;
				case "btn2_Row_Delete2":
					ComRowHideDelete(sheetObject2, prefixs[1]+"del_chk");
					break;
				case "btn1_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn1_Save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
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
     * Copy selected Segregation Group No[Sheet1 --> Sheet2]
     */
    function copySheetCell() {
    	var groupNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), prefixs[0]+"imdg_segr_grp_no");
    	if(groupNo == '') {
    		ComShowCodeMessage('SCG50013');	//'You have to add a new segregation group first.'
    		sheetObjects[1].RowDelete(sheetObjects[1].GetSelectRow(),false);	//input Segregation Group No first to create Heavy metals and their salts.
    	} else {
    		//@@SelectRow -> GetSelectRow()
    		//copy Segregation Group No
    		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), prefixs[1]+"imdg_segr_grp_no",groupNo,0);
    	}
    }
    /**
     * Initialize selected cell and move focus
     */
    function initCell(sheetObj, Row, Col, valDel) {
    	if(valDel) sheetObj.SetCellValue(Row,Col,"",0);
		sheetObj.SelectCell(Row,Col);
    }
    /**
     * move focus when deleting Row
     */
    function deletRowCheck(formObj, sheetObj1, sheetObj2, col) {
    	//SaveName  -> Index
		col=ComIsNumber(col)?ComParseInt(col):sheetObj1.SaveNameCol(col);
		var sRow=sheetObj1.FindCheckedRow(col);
		var arrRow=sRow.split("|");
    	var idxStr;
    	for(var idx=0; idx<arrRow.length; idx++) {
    		idxStr=arrRow[idx];
    		if(idxStr == sheetObj1.GetSelectRow()) {
    			var ibflag, nearRow, continueYn;	    			
    			for(var rowIdx=sheetObj1.HeaderRows(); rowIdx<=sheetObj1.LastRow(); rowIdx++) {
    				ibflag=sheetObj1.GetCellValue(rowIdx,prefixs[0]+"ibflag");
    				if(ibflag != 'D') {
    					var grpNo=sheetObj1.GetCellValue(rowIdx,prefixs[0]+"imdg_segr_grp_no");
    					if(idxStr == rowIdx) {
    						if(nearRow != undefined) {
    							break;
    						} else {
    							continueYn='Y';
    							continue;
    						}
    					} else if(continueYn != undefined) {
    						if(nearRow != undefined) {
    							break;
    						}
    					}
    					if(sRow.indexOf(rowIdx+"|") == -1) {
    						nearRow=rowIdx;
    					}
    				}
    			}
    			if(nearRow != undefined) {
    				sheetObj1.SelectCell(nearRow,prefixs[0]+"imdg_segr_grp_nm");
					setSubMaterial(formObj, sheetObj1, sheetObj2, nearRow);
    			} else {
	    			//Remove title of Heavy metals and their salts
	    			setSubTitle("");
					sheetObj2.RemoveAll();
    			}
				return;
    		}
    	}
    }
    /**
     * Below list title setting
     */
    function setSubTitle(val) {
    	document.getElementById("subTitle").innerText=val;
    }
    /**
     * Group Key setting - use when retrieving below list
     */
    function setGroupKey(sheetObj, Row) {
    	document.form.imdg_segr_grp_no.value=sheetObj.GetCellValue(Row,prefixs[0]+"imdg_segr_grp_no");
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);		
        }        
        resizeSheet();
    
    /**
     * Handling sheet1 OnLoadFinish Event
     * param : sheetObj ==> sheetvobject, ErrMsg ==> result Message
     * 
     */
    //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {	
    	//Initial Segregation Group List retrieve
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        //doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        	case "sheet1":      //sheet1 init
               with (sheetObj) {
                    //setting height
        		
        		var HeadTitle1="|Sel.|No.|Segregation Groups";
        		var headCount=ComCountHeadTitle(HeadTitle1);
//        		(headCount, 0, 0, true);

        		SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

        		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        		InitHeaders(headers, info);

        		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[0]+"ibflag" },
        		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Int",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[0]+"imdg_segr_grp_no", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
        		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefixs[0]+"imdg_segr_grp_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
        		 
        		InitColumns(cols);
        		SetSheetHeight(535);//440
        		SetEditable(1);
				}
                break;
			case "sheet2":      //sheet2 init
               with (sheetObj) {
                    //setting height
				
				var HeadTitle1="||Sel.|No.|UN No.";
				var headCount=ComCountHeadTitle(HeadTitle1);
				(headCount, 0, 0, true);

				SetConfig( { SearchMode:0, MergeSheet:1, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefixs[1]+"ibflag" },
				             {Type:"dtHidden",  Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"imdg_segr_grp_no", KeyField:1,   CalcLogic:"" },
				             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefixs[1]+"dtSeq",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefixs[1]+"imdg_un_no",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 } ];
				 
				InitColumns(cols);
				SetSheetHeight(510);//430
				SetEditable(1);
//				SetGetCountPosition()(0);
				}
                break;
        }
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
        ComResizeSheet(sheetObjects[1]);
    }
    /**
     * Handling Sheet1 Grid Change Event
     * param : sheetObj ==> sheet object, Row ==> Grid Row, Col ==> Grid Col, Value ==> Grid Cell Value
     * adding case as numbers of counting sheets
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	//codeDupCheck(sheetObj,Row, Col, Value, "2");	//imdg_segr_grp_no Value Duplication Check
   	}
    /**
     * Handling Sheet1 Grid AfterEdit Event
     * param : sheetObj ==> sheet object, Row ==> Grid Row, Col ==> Grid Col
     * adding case as numbers of counting sheets
     */
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {    	
    	if(Col == "3") {
    		setSubTitle(sheetObj.GetCellValue(Row,prefixs[0]+"imdg_segr_grp_nm"));
    	} else if(Col == "2") {
    		setGroupKey(sheetObj, Row);
    	}
   	}
    /**
     * Handling Sheet2 Grid Change Event
     * param : sheetObj ==> sheet object, Row ==> Grid Row, Col ==> Grid Col, Value ==> Grid Cell Value
     * adding case as numbers of counting sheets
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
    	//codeDupCheck(sheetObj,Row, Col, Value, "4");	//imdg_un_no Value Duplication Check -
    	if(Col == "4") codeValidCheck(sheetObj,Row, Col, Value);
   	}
    /**
     * Handling Sheet1, Sheet2 Duplication
     * param : sheetObj ==> sheet object, Row ==> Grid Row, Col ==> Grid Col, Value ==> Grid Cell Value, chkCol ==> Duplication Check Col
     * adding case as numbers of counting sheets
     */
    function codeDupCheck(sheetObj, Row, Col, Value, chkCol) {
    	if(Col == chkCol) {
	    	var dupRow=sheetObj.ColValueDup(chkCol,true);
	    	if(dupRow != -1 && sheetObj.GetCellValue(dupRow,chkCol) != '') {
	    		ComShowCodeMessage('SCG50005', 'Data');   //'{?msg1} is duplicated.'
	    		initCell(sheetObj, Row, Col, false);
	    		return false;
	    	} else {
	    		if(sheetObj.id == 'sheet2') {
	    			if(!codeValidCheck(sheetObj,Row, Col, Value)) return false;
	    		}
	    	} 
    	}
    	return true;
    }
    /**
     * Handling Sheet2 UN No. Validation
     * param : sheetObj ==> sheet object, Row ==> Grid Row, Col ==> Grid Col, Value ==> Grid Cell Value
     * adding case as numbers of counting sheets
     */
    function codeValidCheck(sheetObj, Row, Col, Value) {
    	var unData=checkValidUN(sheetObj, Value);
		if(unData == null) {
			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
			initCell(sheetObj, Row, Col, true);
			return false;
		}
    	return true;
    }
    /**
     * United Nations(UN) Number validation check
     */
    function checkValidUN(sheetObj, Value)  {
    	var formObj=document.form;
    	formObj.f_cmd.value=SEARCH03;						
 		var sXml=sheetObj.GetSearchData("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") + "&imdg_un_no=" + Value, false);
		var unData=ComScgXml2Array(sXml, prefixs[1]+"imdg_un_no");
		return unData;
	} 
    /**
     * Handling Sheet1 Cell Select Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected Row ==> NewRow, selected Col ==> NewCol
     * 
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObj, sheetObjects[1], OldRow, NewRow, OldCol);
	} 	
    /**
     * Handling Sheet1 Cell Select Event
     * param : sheet1 ==> sheet object, sheet2 ==> sheet object, OldRow ==> before selecting Row, selected Row ==> NewRow, OldCol ==> before selecting Col
     */
    var isCallBack=false;
 	function doRowChange(sheet1, sheet2, OldRow, NewRow, OldCol) {
 		var formObj=document.form;
		if (!isCallBack && OldRow != NewRow) {
			var valTrue=true;
			if (OldRow != 0 && sheet2.IsDataModified()) {
				if (ComShowCodeConfirm("SCG50003")) {	//'Data was changed. Do you want to save it?'
					valTrue=doActionIBSheet(sheet1, formObj, IBSAVE);
					if(valTrue != null && !valTrue) {
						isCallBack=true;
						sheet1.SelectCell(OldRow, OldCol, false);
						return;
					}
				}
			}
			setSubMaterial(formObj, sheet1, sheet2, NewRow);
		}
		isCallBack=false;
		return;
	}
 	/**
     * Heavy metals and their salts : list
     */
    function setSubMaterial(formObj, sheet1, sheet2, NewRow) {
    	setSubTitle(sheet1.GetCellValue(NewRow,prefixs[0]+"imdg_segr_grp_nm"));
		setGroupKey(sheet1, NewRow);
		var ibflag=sheet1.GetCellValue(NewRow,prefixs[0]+"ibflag");
//		if(ibflag != 'I') {	
			doActionIBSheet(sheet2,formObj,IBSEARCH);
//		} else {
//			sheet2.RemoveAll();
//		}
    }
 	/**
     * Handling Sheet related Transaction Event
     * param : sheetObj ==> sheet object, formObj ==> form object, sAction ==> Event
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieve
				//Segregation Group retrieve
				if (sheetObj.id == "sheet1"){
					formObj.f_cmd.value=SEARCH01;						
 					sheetObj.DoSearch("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(new Array("sheet1_","sheet2_")) );
				}
				//Heavy metals and their salts retrieve
				else if ( sheetObj.id == "sheet2") {
					formObj.f_cmd.value=SEARCH02;
 				  	sheetObj.DoSearch("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
			    }				
                break;
			case IBSAVE:        //save			
				if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'
				if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
        			return false;
        		}
				if(!validateForm(sheetObjects[0],formObj,sAction)) {
            		return false;
            	}		
            	if(!validateForm(sheetObjects[1],formObj,sAction)) {
            		return false;
            	}
            	
            	formObj.f_cmd.value=MULTI;
            	var sParam=ComGetSaveString(sheetObjects);
			    if (sParam == "") return false;
			    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(new Array("sheet1_","sheet2_"));
 			    var sXml=sheetObjects[0].GetSaveData("VOP_SCG_0070GS.do", sParam);
			    sheetObjects[0].LoadSaveData(sXml);
			    //ComScgSaveCompleted();
			    doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
                break;
        }
		return true;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
    	var dupChkIdx="2";
    	if(sheetObj.id == 'sheet2') dupChkIdx="4";
    	var ibflag;
    	var sVal1;
    	var sVal2;
    	for(var rowIdx1=1; rowIdx1<sheetObj.RowCount(); rowIdx1++) {
    		ibflag=sheetObj.GetCellValue(rowIdx1,0);
    		sVal1=sheetObj.GetCellValue(rowIdx1, dupChkIdx);
			if(ibflag != 'D' && sVal1 != '') {				
	    		for(var rowIdx2=rowIdx1+1; rowIdx2<=sheetObj.RowCount(); rowIdx2++) {
	    			ibflag=sheetObj.GetCellValue(rowIdx1,0);
	    			sVal2=sheetObj.GetCellValue(rowIdx2, dupChkIdx);
					if(ibflag != 'D' && sVal2 != '' && sVal2 > -1) {	//> -1 추가 
		    			if(sVal1 == sVal2) {
		    				ComShowCodeMessage('SCG50005', 'Data');   //'{?msg1} is duplicated.'    				
		    				initCell(sheetObj, rowIdx2, dupChkIdx, false);
		    				return false;
		    			}
		    		}
				}
			}
    	}
        return true;
    }
