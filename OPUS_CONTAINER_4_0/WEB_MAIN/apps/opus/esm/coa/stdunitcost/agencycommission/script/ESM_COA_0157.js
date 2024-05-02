/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0157.js
*@FileTitle  : Agent Other Commission Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
     */
    /**
     * @extends 
     * @class ESM_COA_0157 : ESM_COA_0157 Business script for the UI
     */
   /* function ESM_COA_0157() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.sheet1_OnChange=sheet1_OnChange;
    	this.doActionIBSheet=doActionIBSheet;
    	this.f_loc_cd_OnChange=f_loc_cd_OnChange;
    	this.divideCheckZero=divideCheckZero;
    	this.validateForm=validateForm;
    }*/
 // Grobla Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet_height=20; // sheet height
    var comboObjects=new Array();
    var comboCnt=0;
    var loadingMode=false;
    var EXCEL_LOAD_FLG=false;	//check excell loading
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    	function processButtonClick(){
    		/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    		var sheetObject=sheetObjects[0];
    		/*******************************************************/
    		var formObject=document.form;
    		try {
    			var srcName=ComGetEvent("name");
    			if(ComGetBtnDisable(srcName)) return false;
    			switch(srcName) {
    				case "btn_Retrieve":
    					if(sheetObject.IsDataModified()){
    						doActionIBSheet(sheetObject,formObject,IBSAVE);
    					}
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				case "btn_DownExcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;
    				case "btng_Save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;
    			    case "btng_RowAdd":
        				doActionIBSheet(sheetObject,formObject,IBINSERT);
        			    break;
        			case "bu_zoom_in":
        				if ( sheetObject.RowCount() < 1 ) return;
                        sheetObject.SetSheetHeight( sheetObject.GetSheetHeight(sheet_height) * 2 );
                        div_zoom_in.style.display="none";
                        div_zoom_out.style.display="inline";					   
		                if (parent && parent.syncHeight) {
		                    parent.syncHeight();
		                }    					   
        				break;
        			case "bu_zoom_out":
                        if ( sheetObject.RowCount() < 1 ) return;
                        resizeSheet();
                        div_zoom_in.style.display="inline";
                        div_zoom_out.style.display="none";
                        if (parent && parent.syncHeight) {
                            parent.syncHeight();
                        }
        				break;
    				case "btn_LoadExcel":
    					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
    					break; 
    					
    				case "btn_Creation":
    					var strUrl="ESM_COA_4011.do" + "?f_cost_yrmon="+formObject.f_cost_yrmon.value+"&f_cost_type=acm_oth";
    					ComOpenPopup(strUrl, '380', '260', '', '0,0', true);
    					break;
    					break; 
    			} // end switch
    		}catch(e) {
    			if( e == "[object Error]") {
    				ComShowCodeMessage(OBJECT_ERROR);
    			} else {
    			ComShowMessage(e.message);
    			}
    		} finally {
    			ComOpenWait(false);
    		}
    	}
    	/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++]=combo_obj;
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
    	*/
    	function loadPage() {
    		var formObj=document.form;
    		for(i=0;i<sheetObjects.length;i++){
    			//Sheet configuration setting function(start)
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//Sheet configuration setting function(end)
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		formObj.f_cost_yrmon.value=ComGetNowInfo("yy")+"-"+ fillZero(ComGetNowInfo("mm"), 2, "0", "left") ;       
            addDash(formObj.f_cost_yrmon , 4);                       
            ComSetFocus(formObj.f_cost_yrmon);
    		
    		loadingMode=true;
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
            loadingMode=false;
    	}
    	/**
         * Setting multicombo items
         */
         function initCombo(comboObj, comboId) {
        	 with (comboObj) {
    	    	 SetDropHeight(300);
    	    	 Index=0;
    	    	 SetSelectIndex(0);
    	    	 SetUseAutoComplete(1);
        	 }
         }	
    	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
    	*/
    	function initSheet(sheetObj,sheetNo) {
    		var cnt=0;
    		switch(sheetNo) {
    			case 1:	//sheet2 init
                    with(sheetObj){
								            //        (10, 3, 0, true);//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
								var HeadTitle="Del.|STS|YYYY-MM|Location|SO Code|SO Code|UOM|Total AMT|QTY|Per Unit" ;
								
								SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
								
								var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
								var headers = [ { Text:HeadTitle, Align:"Center"} ];
								InitHeaders(headers, info);
								
								var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
								{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon",          KeyField:1,   CalcLogic:"",   Format:"Ym",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"comm_loc_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
								{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"coa_cost_src_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:200,   Align:"Left",    ColMerge:0,   SaveName:"coa_cost_src_cd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"otr_comm_ttl_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:27 },
								{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"bkg_ttl_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
								{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"stnd_cost_usd_amt",   KeyField:0,   CalcLogic:"|otr_comm_ttl_amt|/|bkg_ttl_qty|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
								
								InitColumns(cols);
								
								SetEditable(1);//Editkind[optional,Defaultfalse]
								//SetCountPosition()(0);
				                SetColProperty(0 ,"comm_loc_cd" , {AcceptKeys:"N|E" , InputCaseSensitive:1});	//20151209.MOD : AcceptKeys E->N,E
								SetWaitImageVisible(0);
//								SetSheetHeight(430);
								resizeSheet();
                     }


    				break;
    		}
    	}
    	function sheet1_OnChange(sheetObj, Row,Col, Value) {
    		var sName=sheetObj.ColSaveName(Col);
    		if ( sName == "bkg_ttl_qty") {
    			sheetObj.SetCellValue(Row, "stnd_cost_usd_amt",divideCheckZero(sheetObj.GetCellValue(Row,"otr_comm_ttl_amt") , Value),0);
    		} else if( sName == "otr_comm_ttl_amt"){	
    			sheetObj.SetCellValue(Row, "stnd_cost_usd_amt",divideCheckZero(Value, sheetObj.GetCellValue(Row, "bkg_ttl_qty")),0);
    		}
    	}
    	// Handling process about the sheet object
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg(false);
    		switch(sAction) {
    			case IBCLEAR:          //Inquiry
					ComOpenWait(true);
					formObj.f_cmd.value=INIT;
 					var sXml=sheetObj.GetSearchData("ESM_COA_0157GS.do", coaFormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0) {
						ComXml2ComboItem(arrXml[0], f_comm_loc_cd, "code", "name");
					}
					if (arrXml.length > 1) {
						ComCoaSetIBCombo(sheetObj, arrXml[1], "coa_cost_src_cd", true, 0, 0,"","", true);
					}
					if (arrXml.length > 2) {
						ComCoaSetIBCombo(sheetObj, arrXml[2], "cntr_tpsz_cd", true, 0);
					}
					ComOpenWait(false);
					break
    			case IBSEARCH:	//Inquiry
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
    				//initializing
      	            initVariable();
					// Prohibit button click when a business transaction is processing 
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_COA_0157GS.do", coaFormQueryString(formObj) );
//					ComOpenWait(false);				
    				break;
      			case IBSAVE:	//Save
      				ComOpenWait(true);
      				if(!validateForm(sheetObj,formObj,sAction)){
      					return false;
      				}
      				if(EXCEL_LOAD_FLG) {  					
      					if(!ComShowCodeConfirm("COA10061")) {
      	  					return false;
      	  				}
      					formObj.f_cmd.value=MULTI;  	
      					sheetObj.DoSave("ESM_COA_0157GS.do", coaFormQueryString(formObj), -1, false);
      					if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
      						initVariable(); //Initialize global variable when Save action is completed 
      					}  					
      				} else {
      					formObj.f_cmd.value=MULTI;
      					sheetObj.DoSave("ESM_COA_0157GS.do", coaFormQueryString(formObj), -1, true);
      				}      				
     				ComOpenWait(false);
      				break;
    			case IBINSERT:	//Add row
    			    if(formObj.f_cost_yrmon.value == "") {
    			        ComShowCodeMessage('COA10039');
    			    } else {			    
        				var row=sheetObj.DataInsert(-1);
        				if(row > 1) {
        					sheetObj.SetCellValue(row, "cost_yrmon",sheetObj.GetCellValue(row-1, "cost_yrmon"),0);
        				} else {
        				    sheetObj.SetCellValue(row, "cost_yrmon",formObj.f_cost_yrmon.value.replace("-",""),0);
        			    }
        			    sheetObj.SetCellValue(row, "cntr_tpsz_cd","TEU");
    			    }
    				break;
    			case IBDOWNEXCEL:	// Excell download
    				var excelType=selectDownExcelMethod(sheetObj);
    				break;
            	case IBLOADEXCEL:	        	
            		//20150716.MOD/ADD/DEL
            		sheetObj.SetWaitImageVisible(0);
    	        	sheetObj.RemoveAll();
    	        	EXCEL_LOAD_FLG = sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
    	        	if(!EXCEL_LOAD_FLG) {    	        		
    	        		initVariable();
    	        	}
    				break;				
    		}
    	}
    	
    	function callBackExcelMethod(excelType){
    		var sheetObj = sheetObjects[0];
    		 switch (excelType) {
		            case "AY":
		                sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		                break;
		            case "AN":
				    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
				    	break;
		            case "DY":
		            	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		            	break;
		            case "DN":
				    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
				    	break;
    		 }
    	}    	

        function sheet1_OnSearchEnd(shtObj, ErrMsg) {
    		ComOpenWait(false);
        }
        
       	function f_comm_loc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	    sheetObjects[0].RemoveAll();
    	    comboObj.ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
    	}
        function divideCheckZero(vNum, vDen) {
            var vRtn=0;
            if(parseFloat(vDen) == 0) {
                vRtn=0;
            } else {
                vRtn=parseFloat(vNum) / parseFloat(vDen);
            }
            return vRtn;
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
		*          true  : Form input values �뗢�are valid<br>
		*          false : Form input values �뗢�are not valid
    */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH: // 議고쉶
				if(!isValidYYYYMM(formObj.f_cost_yrmon , false, '-', false)){
					return false;
		  		}
				break;
	  		case IBSAVE: 	
	  			if(!isValidYYYYMM(formObj.f_cost_yrmon , false, '-', false)){
					return false;
		  		}
	  			if(EXCEL_LOAD_FLG) {
	  				if(!checkValidationAllData(sheetObj)) {  					
	  					return false;
	  				}
	  			}
	  			var dr=sheetObj.ColValueDup("cost_yrmon|comm_loc_cd|coa_cost_src_cd|coa_cost_src_cd_nm|cntr_tpsz_cd");
    			if(dr>0){				
    				ComShowCodeMessage('COM12115', 'YYYY-MM, Location, SO Code, UOM');
    				sheetObj.SelectCell(dr,"cost_yrmon");
    				return false;
    			}
				break;
		}
		return true;
	}
   /**
	* Function to check in case of saving the upload data<br>
	* <br><b>Example :</b>
	* <pre>
	* 
	* </pre>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @return nothing
	*/
	function checkValidationAllData(sheetObj) {
		var formObj=document.form;
		//validation check
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "coa_cost_src_cd") == "") {
				sheetObj.SetCellText(i, "coa_cost_src_cd" ,"");
				sheetObj.SetCellValue(i, "coa_cost_src_cd_nm","");
			}
			if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "") {
				sheetObj.SetCellText(i, "cntr_tpsz_cd" ,"");
			}			
		}
    	//Shows Unconditionally message if there is a error data
    	if(sheetObj.GetSaveString() == "") {
    		return false;
    	}
		return true;
	}
	/**
	 * Function to initialize global variable <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		initVariable();
	 * </pre>
	 * @return nothing
	 */
	function initVariable() {
		EXCEL_LOAD_FLG=false;
	}
    /**
     * Function is called when the onChange event occurs  <br>
     * Display contents of description when the Multi ComboBox is selected  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
			* @param {int} Row mandatory : Row Index in those cells where the Onclick event occurred
			* @param {int} Col mandatory : Column Index in those cells where the Onclick event occurred
			* @param {string} Value mandatory : A value in those cells where the event occurred
     * @return nothing
     */  
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		switch(colName)
     	{
 			case "coa_cost_src_cd":
 	    		if (Value != ""){
 	    			// setting DESC
 	    			var sText=sheetObj.GetComboInfo(Row, Col, "Text");
 	    			var arrText=sText.split("|"); 	    			
 	    			var sIdx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
 	    			var sDesc=arrText[sIdx].split("\t");
 	    			sheetObj.SetCellValue(Row, "coa_cost_src_cd_nm",sDesc[1],0);
 	    		} else {
 	    			sheetObj.SetCellValue(Row, "coa_cost_src_cd_nm","",0);
 	    		} 	    		
 	    		break;
     	}
	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
    
    //SJH.20121223.ADD : 저장후 메시지 추가
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if(ErrMsg == ""){
            // [COM130102] : Success
        	ComShowMessage(ComGetMsg("COM130102","Data"));
        }else{
            ComShowMessage(ComGetMsg("COM132101"));
        }	
        doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }  
    
    //SJH.20150507.ADD : LOADEXCEL OPTION
    function sheet1_OnLoadExcel(sheetObj, result, code, msg) {	
    	ComOpenWait(false);									//20150716.MOD
    	if(isExceedMaxRow(msg)) return;
    }    
    
    //20150716.ADD
    function sheet1_OnLoadFileSelect(sheetObj){
        ComOpenWait(true);
    }   
