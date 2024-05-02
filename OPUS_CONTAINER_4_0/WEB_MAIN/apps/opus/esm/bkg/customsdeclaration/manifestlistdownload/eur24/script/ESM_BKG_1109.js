/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1109.js
*@FileTitle  : Europe Advanced Manifest - ENS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    //global variable
    var intervalId="";
    
    // Event handler processing by button click event */
 	document.onclick=processButtonClick;
 	// Event handler processing by button name */
     function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
 	     var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
     	//try {
     	 var srcName=ComGetEvent("name");
             switch(srcName) {
 			 	case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 			 	case "btn_New":
 			 		sheetObject1.RemoveAll();
 	                formObject.reset();
 	                break;
 			 	case "btn_Save":
 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
 					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
				case "btn_RowDelete":
					var iCheckRow=sheetObject1.FindCheckedRow("sel");
					var arrRow=iCheckRow.split("|");
					//alert(arrRow);
					if (iCheckRow == "") {
						ComShowCodeMessage('COM12189');
						return;
					}
					ComRowHideDelete(sheetObject1, "sel");
					break;
              } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
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
     * IBMulti Combo Object array
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	      //MultiComboInitialization 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
		initControl();
	}
     function initControl() {
     	var formObject=document.form;
         axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- focus in     
         axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- focus out
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
         axon_event.addListenerForm ('change', 'bkg_change', formObject);
         //axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
     }
 	/**
 	 * set Combo
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject=document.form
			initComboEditable(comboObj, comboId)
 	}
	/** 
	* set MultiCombo<br> 
	*/ 
	function initComboEditable(combo, comboId) {
		with (combo) {
			SetMultiSelect(0);
			SetUseEdit(0);
		}
	} 	
/** ********************* KEY EVENT START ******************* */ 	 
	
	var preVvd;
	var prePodCd;
	/**
     * onBlur control.
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "p_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
    		case "p_to_dt":
    			ComClearSeparator(event.srcElement);
				break;  		
			default:
				break;
	    }
    }           
	/**
	 * onFocus event Validation check. <br>
	 **/
	function bkg_focus(){
		//input Validation check
		switch(event.srcElement.name){	
	    	case "p_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "p_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
					break;
		}
	}  
    /**
     * form field change event
     * 
     * @return
     */
    function bkg_change(){
	    switch (ComGetEvent("name")) {
	    	case "p_cnt_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
				break;
			default:
				break;
	    }
    }
    /*############################# combo onchage start ########################*/
    /**
	 * MultiCombo insert Event Handling.
	 * @param comboObj
	 * @return
	 */
	function p_port_OnChange(comboObj) {
		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
	}
    /**
     * when enter retrieve creteria, handling
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if ((srcName == "p_vvd" || srcName == "p_pol" || srcName == "p_pod") && ComChkLen(srcValue, srcMaxLength) == "2") {
    		//ComSetNextFocus();
    	}
    }
    /**
     * sheet1 click Event Handling
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	/*
	    	var rowCnt=sheetObj.RowCount();
	        var colSaveName=sheetObj.ColSaveName(col);
	        switch(colSaveName) {
		    	case "port_cd" :
if(sheetObj.GetCellValue(row, "ibflag") == "I") return;
		    		//alert(sheetObj.CellValue(row, "ports_cd"));
		    		//sheetObj.InitDataCombo(0,"port_cd",sheetObj.CellValue(row, "ports_cd"),
		    		//sheetObj.InitDataCombo(0,"port_cd",sheetObj.CellValue(row, "ports_cd"),sheetObj.CellValue(row, "ports_cd"), "", "",0);
		    		break;
		    	case "tml_cd" :
if(sheetObj.GetCellValue(row, "ibflag") == "I") return;
		    		//alert(sheetObj.CellValue(row, "ports_cd"));
		    		//sheetObj.InitDataCombo(0,"port_cd",sheetObj.CellValue(row, "ports_cd"),
		    		//sheetObj.CellComboItem(row,"tml_cd",sheetObj.CellValue(row, "tmls_cd"),sheetObj.CellValue(row, "tmls_cd"));
		    		break;
	        } // end switch
	        */
    }
      /**
      *  sheet1 Search End Event Handling
      * @param sheetObj Sheet
      * @param ErrMsg String
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     /*	
			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				sheetObj.CellComboItem(i,"port_cd", {ComboText:sheetObj.CellValue(i, ComboCode:"ports_cd")} );
sheetObj.SetCellValue(i,"port_cd",sheetObj.GetCellValue(i, "port_cd"));
				sheetObj.CellComboItem(i,"tml_cd", {ComboText:sheetObj.CellValue(i, ComboCode:"tmls_cd")} );
			}
			*/
     }	    
     /**
      * Booking Creation screen move
      * @param sheetObj Sheet
      * @param Row Row Index
      * @param Col Col Index
      */
     function sheet1_OnDblClick(sheetObj, row, col) {
	        var colSaveName=sheetObj.ColSaveName(col);
	        switch(colSaveName) {
	        	case "bl_no" :
	        		ComBkgCall0079(sheetObj.GetCellValue(row, "bkg_no"));
		    	break;
	        } // end switch
     }	     
 	
    /**
     * handling sheet process<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH : // Retrieve
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
				sheetObj.RemoveAll();
				
				var sXml=sheetObj.GetSearchData("ESM_BKG_1109GS.do", FormQueryString(formObj)); 
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				
				sheetObj.SetWaitImageVisible(0);
				break;
			case IBINSERT: // insert					
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				sheetObj.DataInsert(-1);
				break;
			case IBSAVE:
				if (!sheetObj.IsDataModified())return;
				
				if(!ComShowCodeConfirm("BKG00350")) {
			       	return false;
			    }
				
				var sParam=sheetObj.GetSaveString(true);
				if(sParam =="" )return;
				if (!validateForm(sheetObj, formObj, sAction)) return;
				formObj.f_cmd.value=MULTI;
		
				var sXml=sheetObj.GetSaveData("ESM_BKG_1109GS.do", sParam+"&f_cmd="+formObj.f_cmd.value);
				var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if ( State == "F" ) {
					var errMsg=ComGetEtcData(sXml,"Exception")
			    	var rmsg=errMsg.split("<||>");
			    	if(rmsg[3] != undefined && rmsg[3].length > 0) {
			    		ComShowMessage(rmsg[3]);
			    	}else{
//parameter changed[check again]CLT 			    		
			    		sheetObjects[0].LoadSaveData(sXml);
			    	}				    	
				}else{
//parameter changed[check again]CLT 					
					sheetObj.LoadSaveData(sXml);
					formObj.f_cmd.value=SEARCH; //research
					sParam += "&" + FormQueryString(formObj);
//parameter changed[check again]CLT 					
					sXml=sheetObj.GetSaveData("ESM_BKG_1109GS.do", sParam);
//parameter changed[check again]CLT 					
					sheetObj.LoadSaveData(sXml);
				}
				break;
			case SEARCH01 : // p_port retrieve
				formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT 				
				var sXml=sheetObj.GetSearchData("ESM_BKG_1109GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, p_port, "port_cd", "port_cd");
				break;
			case SEARCH02 : // Terminal retrieve
				formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT 				
				var sXml=sheetObj.GetSearchData("ESM_BKG_1109GS.do", FormQueryString(formObj));   
				ComXml2ComboItem(sXml, p_tml, "yd_cd", "yd_cd");
				break;
        }
    }
	   /**
     * Validation Check <br>
     */ 	
	function sheet1_OnValidation(sheetObj,rowIdx,colIdx,value) {
		if(sheetObj.GetCellValue(rowIdx, "ibflag") == 'D' || sheetObj.GetCellValue(rowIdx, "ibflag") == 'R' ) return;
		if(colIdx == sheetObj.SaveNameCol("ct_email")){
			if (!ComIsNull(value) && !ComIsEmailAddr(value)) {
				ComShowCodeMessage("BKG95001"," enter correct 'Email Address'",""); 
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(rowIdx, colIdx);
			}
		}
	  /*
	  else if(colIdx == sheetObj.SaveNameCol("ct_tel")){
			if (!ComIsNull(value) && !ComIsNumber(value, "-"))  {
				ComShowCodeMessage("BKG95001"," enter correct 'Tel No'","(Format:123-1234-1234)"); 
                sheetObj.ValidateFail(true);
                sheetObj.SelectCell(rowIdx, colIdx);
			}
		}else if(colIdx == sheetObj.SaveNameCol("ct_fax")){
			if (!ComIsNull(value) && !ComIsNumber(value, "-"))  {
				ComShowCodeMessage("BKG95001"," enter correct 'Fax No'","(Format:123-1234-1234)"); 
				sheetObj.ValidateFail(true);
				sheetObj.SelectCell(rowIdx, colIdx);
			}
		}
		*/
     }
	
	function sheet1_OnChange(sheetObj, row, col, val) {
		var formObject=document.form;
		var col_save_name=sheetObj.ColSaveName(col);
		
		    // 대문자처리
			if(col_save_name=="port_cd"||col_save_name=="tml_cd"||col_save_name=="customs_cd"){
				sheetObj.SetCellValue(row, col, val.toUpperCase(),0);
			}

	}	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
	    	case IBSEARCH:
				break;
	    	case IBSAVE:
				if (sheetObj.RowCount("I") + sheetObj.RowCount("U") == 0) {
					return true;
				}
				var duprow=sheetObj.ColValueDup("port_cd|tml_cd", false);
				if(duprow > 0){
					ComShowCodeMessage("COM131302","Port Code("+sheetObj.GetCellValue(duprow,"port_cd")+"),Terminal("+sheetObj.GetCellValue(duprow,"tml_cd")+")");
					sheetObj.SelectCell(duprow, "tml_cd");
					return false;
				}
				var statusCode="";
				var temp_term_cd="";
				for ( var index=sheetObj.HeaderRows(); index <= sheetObj.LastRow(); index++) {
					statusCode=sheetObj.GetCellValue(index, "ibflag");
					if (statusCode == "D" || statusCode == "R") continue;
					if(statusCode == "I" && ComTrim(sheetObj.GetCellValue(index, "port_cd")).length != 5){
						ComShowCodeMessage("BKG95018","Port("+sheetObj.GetCellValue(index, "port_cd")+")","5");
						sheetObj.SelectCell(index, "port_cd");
						return false;
					}
					temp_term_cd=ComTrim(sheetObj.GetCellValue(index, "tml_cd"));
					if(temp_term_cd != "ALL" && temp_term_cd.length != 7 ){
						ComShowCodeMessage("BKG95018","Terminal("+temp_term_cd+")","7( or 'ALL')");
						sheetObj.SelectCell(index, "tml_cd");
						return false;
					}
				}
				for ( var index=sheetObj.HeaderRows(); index <= sheetObj.LastRow()-1; index++) {
					statusCode=sheetObj.GetCellValue(index, "ibflag");
					if (statusCode == "D") continue;
					if(dupAllCheckTmlcd(sheetObj, sheetObj.GetCellValue(index, "port_cd"),ComTrim(sheetObj.GetCellValue(index, "tml_cd")), index)){
						sheetObj.SelectCell(index, "tml_cd");
						return false;
					}
				}
				break;
	    }
        return true;
    }
    /**
     * Port Code,Terminal dup check
     */
    function dupAllCheckTmlcd(sheetObj, p_port_cd,p_tml_cd, p_index) {
		var statusCode="";
		var temp_term_cd="";
		for(var i=p_index +1; i<= sheetObj.LastRow(); i++) {
			statusCode=sheetObj.GetCellValue(i, "ibflag");
			if (statusCode == "D")continue;
				temp_term_cd=ComTrim(sheetObj.GetCellValue(i, "tml_cd"));
				if( p_tml_cd == "ALL" && p_port_cd == sheetObj.GetCellValue(i, "port_cd") ||
				temp_term_cd == "ALL" && p_port_cd == sheetObj.GetCellValue(i, "port_cd")
			   ){
				ComShowCodeMessage("COM131302","Port Code("+p_port_cd+"),Terminal(ALL - Terminal must not exists but 'ALL')");
				return true;
			}
		}
		return false;
    }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
		        
				      var HeadTitle1="|Seq.|Sel.|Country|Port|Terminal|Customs Code|Customs Name|SVC|SVC|SVC|SVC|Contact Info|Contact Info|Contact Info|Contact Info|Contact Info|ports_cd|tmls_cd";
				      var HeadTitle2="|Seq.|Sel.|Country|Port|Terminal|Customs Code|Customs Name|EXS|ENS|A/N|D/R|Name|Position|Email|Tel|Fax|ports_cd|tmls_cd";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      headCount=ComCountHeadTitle(HeadTitle1);
				      //(headCount, 7, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"sel",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tml_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
				             {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:1,   SaveName:"customs_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"customs_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"svc_exs_yn" ,KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"svc_ens_yn" ,KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"svc_an_yn" ,KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"svc_dr_yn" ,KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ct_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ct_position",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ct_email",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ct_tel",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,AcceptKeys:"N|[-]" },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ct_fax",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35,AcceptKeys:"N|[-]" },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ports_cd" },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tmls_cd" } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetCountPosition(0);
				      SetSheetHeight(452);
				      
				}
				break;
		}//end switch
 	}     
    /* Developer Work End */
