/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESM_COA_0152.js
*@FileTitle  : Unit Price management for MRI Freight revenue
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
     * @class ESM_COA_0152 : ESM_COA_0152 Business script for the UI
     */
   	/* Developer's task	*/
    /* Grobal Variable */
  //var calPop = new calendarPopupGrid();
  var curTab=1;
  var beforetab=0;
  var sheetObjects=new Array();
  var sheetCnt=0;
  var comboObjects=new Array();
  var comboCnt=0;
  var loadingMode=false;
  var sRow=0;                // In case of changing Trade 
//  var EXCEL_LOAD_FLG=false;	//check excell loading
  /* Event handler processing by button click event */
  document.onclick=processButtonClick;
  	/* Event handler processing by button name */
  	function processButtonClick(){
  		/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
  		var sheetObject=sheetObjects[0];
  		var formObject=document.form;
  		try {
  			var srcName=ComGetEvent("name");
  			if(ComGetBtnDisable(srcName)) return false;
  			switch(srcName) {
      			case "btn_Retrieve":
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
      			case "btn_rowdelete":
      				doActionIBSheet(sheetObject,formObject,IBDELETE);
      			    break;
				case "btn_LoadExcel":
					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
					break; 
  			} // end switch
  		} catch(e) {
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg(OBJECT_ERROR));
  			} else {
  				ComShowMessage(e.message);
  			}
  		} finally {
  			ComOpenWait(false);
  		}
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
  		loadingMode=true;
  		
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        // handling multi-combo object
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode=false;
	    //Axon event Initialize
	    initControl();
  		formObj.f_rev_yrmon.value=ComGetNowInfo("yy")+"-"+ fillZero(ComGetNowInfo("mm"), 2, "0", "left") ;       
        addDash(formObj.f_rev_yrmon , 4);                       
        ComSetFocus(formObj.f_rev_yrmon);   
  	}
  	/**
     * Setting multicombo items
     */
     function initCombo(comboObj, comboId) {
    	 with (comboObj) {
	    	 SetDropHeight(300);
	    	 comboObj.InsertItem(0, 'All' ,''); 
	    	 Index=0;
	    	 SetSelectIndex(0);
	    	 //SJH.20150105.ADD
	    	 ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고	
//	    	 SetUseAutoComplete(1);
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
  			case 1:		//sheet2 init
  			    with(sheetObj){
  		      //  (11, 5, 0, true);//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  		      var HeadTitle="Sel.|STS|YYYY-MM|Trade|Lane|Bound|AMT|Vol|Per Unit ORG|Per Unit|save per unit" ;
	
	  		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight:350 } );
	
	  		      var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
	  		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	  		      InitHeaders(headers, info);
	
	  		      var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
	  		             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	  		             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",       KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	  		             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"trd_ttl_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
	  		             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"trd_ttl_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
	  		             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ut_rev_amt_org",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1 },
	  		             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"etc_ut_rev_amt",  KeyField:0,   CalcLogic:"|trd_ttl_amt|/|trd_ttl_qty|",Format:"Float",       PointCount:4,   UpdateEdit:0,   InsertEdit:0 },
	  		             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"etc_ut_rev_amt1", KeyField:0,   CalcLogic:"|trd_ttl_amt|/|trd_ttl_qty|",Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	  		       
	  		      InitColumns(cols);
	
	  		      SetEditable(1);//Editkind[optional,Defaultfalse]
	  		     // SetGCountPosition()(0);
	  		      SetWaitImageVisible(0);
//	  		      SetSheetHeight(430);
				  resizeSheet();
  		            }


  				break;
  		}
  	}
    /**
     * For the Axon event<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param nothing
     * @return nothing
     */ 	    
     function initControl() {
    	 //Axon event handling 1. event catch
         axon_event.addListenerForm ('click', 'obj_onClick', document.form);
     }
     /**
      * onClick event <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param 없음
      * @return nothing
      */  
  	function obj_onClick(){
  		var formObj=document.form;
  		var sheetObj=sheetObjects[0];
  	 	var eleName=event.srcElement.name;
  	 	if (eleName == "istrade"){
  	 		f_trd_cd.SetSelectIndex(0);
  	 		if(ComGetObjValue(formObj.istrade) == "YES") {
  	 			//In case of selection radio
  	 			sheetObj.SetColHidden("rlane_cd", 1);  	 			
  	 			doActionIBSheet(sheetObj,document.form,SEARCHLIST10);
  	 			f_rlane_cd.SetEnable(0);									//SJH.20141222.ADD
  	 			sheetObj.SetColProperty(0 ,"rlane_cd", {KeyField:false});	//SJH.20150105.ADD
  	 		} else {
  	 			sheetObj.SetColHidden("rlane_cd", 0);
  	 			f_rlane_cd.SetEnable(1);									//SJH.20141222.ADD
  	 			sheetObj.SetColProperty(0 ,"rlane_cd", {KeyField:true});	//SJH.20150105.ADD
  	 		}
  		}
  	}	
  	function sheet1_OnChange(sheetObj, Row, Col, value){
  	    var formObj=document.form;
  	    var param="";
  	    // Change rlane in case of changing trade
  	    if(sheetObj.ColSaveName(Col) == "trd_cd" && ComGetObjValue(formObj.istrade) == "NO"){
  	    	param=param+"&f_cmd="+SEARCHLIST11;
  	    	param=param+"&f_trd_cd="+sheetObj.GetCellValue(Row,Col);
 			var sXml=sheetObj.GetSearchData("ESM_COA_0152GS.do", param);
			var arrXml=sXml.split("|$$|");
			if (ComGetTotalRows(arrXml[0]) > 0) {
				ComCoaSetIBCombo(sheetObj, arrXml[0], "rlane_cd",true,0,Row);
			} else {
 				sheetObj.CellComboItem(Row,"rlane_cd", {ComboText:"", ComboCode:""} );
 			}  
  	    }
  	}
  	// Handling process about the sheet object
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  			case IBCLEAR:          //Inquiry
				ComOpenWait(true);

				var sXml=document.form.sXml.value; 
				var arrXml=sXml.split("|$$|");
				//var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				var State=ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key); 
				if(State != "S"){ 
					//ComShowMessage(OBJECT_ERROR);
					ComOpenWait(false);
					return;
				}	
				
				//var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_trd_cd, "code", "code");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_rlane_cd, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], f_dir_cd, "code", "code");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "trd_cd", true, 0);
				if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "rlane_cd",true,0);
				if (arrXml.length > 2)
					ComCoaSetIBCombo(sheetObj, arrXml[2], "dir_cd",true,0);
				document.form.sXml.value="";
				ComOpenWait(false);				
				break;
  			case SEARCHLIST10:
  				formObj.f_cmd.value=SEARCHLIST10;
 				var sXml=sheetObj.GetSearchData("ESM_COA_0152GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "code");
				initCombo(f_rlane_cd,f_rlane_cd.id);				//SJH.20141230.ADD
				f_rlane_cd.SetSelectIndex(0);
				break;
  			case SEARCHLIST13:
  				formObj.f_cmd.value=SEARCHLIST13;
 				var sXml=sheetObj.GetSearchData("ESM_COA_0152GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					ComCoaSetIBCombo(sheetObj, arrXml[0], "rlane_cd", true, 0);
				}
				break;
  			case IBSEARCH://Inquiry
  				if(!validateForm(sheetObj,formObj,sAction)){
  					return false;
  				}
				// Prohibit button click when a business transaction is processing 
				ComOpenWait(true);
				sheetObj.Redraw = false;
          		if (formObj.istrade[0].checked){
              		sheetObj.SetColHidden("rlane_cd",1);
              		sheetObj.SetColProperty("rlane_cd", {ComboText:"XXXXX", ComboCode:"XXXXX"} );
          		} else {
              		sheetObj.SetColHidden("rlane_cd",0);
              		doActionIBSheet(sheetObj,document.form,SEARCHLIST13);
          		}  
  	    		formObj.f_cmd.value=SEARCH;
   	    		sheetObj.DoSearch("ESM_COA_0152GS.do", coaFormQueryString(formObj) );
 				// Initialize
  	            //initVariable();
  	            sheetObj.Redraw = true;
//  	            ComOpenWait(false);
  				break;
  			case IBSAVE:	//Save
  				ComOpenWait(true);
  				if(!validateForm(sheetObj,formObj,sAction)){
  					return false;
  				}
  								
				if(!ComShowCodeConfirm("COA10061")) {
  					return false;
  				}
				formObj.f_cmd.value=MULTI;  	
				sheetObj.DoSave("ESM_COA_0152GS.do", coaFormQueryString(formObj), -1, false);
				
 				ComOpenWait(false);
  				break;
  			case IBINSERT:	//Add row
  				var row=sheetObj.DataInsert(-1);
  				sheetObj.SetCellValue(row, "rev_yrmon",formObj.f_rev_yrmon.value.replace("-",""),0);
  				if(sheetObj.GetColHidden("rlane_cd")) {
  					sheetObj.SetCellValue(row, "rlane_cd","XXXXX",0);
  				}  				
  				break;
			case IBDELETE: // Delete
				var iCheckRow=sheetObj.FindCheckedRow("sel");
				if(iCheckRow == ""){
					sheetObj.SetCellValue(sheetObj.GetSelectRow(),"sel","1",0);
				}
				iCheckRow=sheetObj.FindCheckedRow("sel");
				if(iCheckRow != "") {
					ComRowHideDelete(sheetObj, "sel");
				}				
				break;
  			case IBDOWNEXCEL:	// Excell download
				selectDownExcelMethod(sheetObj);
//				
  				break;
        	case IBLOADEXCEL:	        	
	        	if(ComGetObjValue(formObj.istrade) == "YES") {
	  	 			sheetObj.SetColHidden("rlane_cd",1);
	  	 		} else {
	  	 			sheetObj.SetColHidden("rlane_cd",0);
	  	 		}
	        	//Getting lane code
	        	doActionIBSheet(sheetObj,document.form,SEARCHLIST13);
	        	
        		//20150716.MOD/ADD/DEL
        		sheetObj.SetWaitImageVisible(0);
	        	sheetObj.RemoveAll();
	        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
        
  				if(ComGetObjValue(formObj.istrade) == "YES") {
  					for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
  						sheetObj.SetCellValue(i, "rlane_cd","XXXXX",0);
  					}  					
  				}
				break;				
  		}
  	}
  	
  	function callBackExcelMethod(excelType) {
  		var sheetObj = sheetObjects[0];
  		if(sheetObj.RowCount() < 1){//no data
  			ComShowCodeMessage("COM132501");
  			return;
  		}
  		switch (excelType) {
	        case "AY":
	            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	            break;
	        case "AN":
		    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
	        case "DY":
	        	sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	        	break;
	        case "DN":
		    	sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
  		}
  	}

    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		ComOpenWait(false);
    }			
	 /**
	 * Display R.Lane by ifram
	 */
	function f_trd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if (loadingMode == true)
			return;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if (formObj.istrade[1].checked){
			if (comboObj.GetSelectText()!= "") {
				 doActionIBSheet(sheetObj,document.form,SEARCHLIST10);
			}
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
				if(!isValidYYYYMM(formObj.f_rev_yrmon , false, '-', false)){
					return false;
		  		}		
				break;
	  		case IBSAVE: 	
	  			if(!isValidYYYYMM(formObj.f_rev_yrmon , false, '-', false)){
					return false;
		  		}
/*	  			if(EXCEL_LOAD_FLG) {
	  				if(!checkValidationAllData(sheetObj)) {  					
	  					return false;
	  				}
	  			}*/
	  			//SJH.20150105.MOD : TRADE, LANE에 따라..
	  			if (formObj.istrade[0].checked){
		  			var dr=sheetObj.ColValueDup("rev_yrmon|trd_cd|dir_cd");
	    			if(dr>0){				
	    				ComShowCodeMessage('COM12115', 'YYYY-MM, Trade, Bound');
	    				sheetObj.SelectCell(dr,"rev_yrmon");
	    				return false;
	    			}
	  			} else {
		  			var dr=sheetObj.ColValueDup("rev_yrmon|trd_cd|rlane_cd|dir_cd");
	    			if(dr>0){				
	    				ComShowCodeMessage('COM12115', 'YYYY-MM, Trade, Lane, Bound');
	    				sheetObj.SelectCell(dr,"rev_yrmon");
	    				return false;
	    			}	  				
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
/*	function checkValidationAllData(sheetObj) {
		var formObj=document.form;
		var check=0;
		//Check items value validation of the window
		check += validateSheetData(sheetObj);
		// DB validation check
		if(ComGetObjValue(formObj.istrade) == "NO") {
			check += checkDBCodeExist(sheetObj);
		}
		if(check > 0) {
			return false;
		} else {
			return true;
		}
	}*/
	/**
* Function that check a validation on the window <br>
	 * Return values of check action in case of catching validation <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @return check
	 */		
/*	function validateSheetData(sheetObj) {
		var check=0;				
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
if (sheetObj.GetCellValue(i, "trd_cd") == "") {
				sheetObj.SetCellText(i, "trd_cd" ,"");
				check ++;
			}
if (sheetObj.GetCellValue(i, "rlane_cd") == "") {
				sheetObj.SetCellText(i, "rlane_cd" ,"");
				check ++;
			}
if (sheetObj.GetCellValue(i, "dir_cd") == "") {
				sheetObj.SetCellText(i, "dir_cd" ,"");
				check ++;
			}		
		}
		return check;
	}*/
	/**
	 * Function that validate DB after excell file is  loaded <br>
	 * If there is a fault data, changing the color of it <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		checkDBCodeExist(sheetObj, formObj);
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @return check
	 */
/*	function checkDBCodeExist(sheetObj) {
		var formObj=document.form;
		var check=0;
		var sParam="f_cmd=" + COMMAND01;	
		var sParamSheet=sheetObj.GetSaveString(true); //validate Sheet data :  mandatory check
		if (sParamSheet != "") {
			sParam=sParam + "&" + sParamSheet;
		}
 		var sXml=sheetObj.GetSearchData("ESM_COA_0152GS.do", sParam);
		var arrErr=ComCoaXml2Array(sXml, "key|code|name");
        if (arrErr != null && arrErr.length > 0) {
        	for (var i=0; i<arrErr.length; i++) {
        		sheetObj.SetCellValue(parseInt(arrErr[i][0]) + sheetObj.HeaderRows(), "rlane_cd","",0);
        		check ++;
        	}
        	//Shows Unconditionally message if there is a error data
        	sheetObj.GetSaveString();
        }
		return check;
	}*/
	/**
	 * Function to initialize global variable <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		initVariable();
	 * </pre>
	 * @return nothing
	 */
//	function initVariable() {
//		EXCEL_LOAD_FLG=false;
//		document.form.istrade[0].disabled=false;
//		document.form.istrade[1].disabled=false;
//	}

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
    
    //SJH.20150105.ADD
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
	/* Developer's task ends */
    