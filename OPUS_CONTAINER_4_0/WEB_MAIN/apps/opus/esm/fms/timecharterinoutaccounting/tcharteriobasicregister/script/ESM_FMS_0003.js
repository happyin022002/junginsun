/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0003.js
*@FileTitle  : Account Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
 event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Account Code : Account Code definition of biz script for creation screen
     */

	//  common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name  */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
       var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
          	switch(srcName) {
            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
//					ComRemoveAll();
	             	sheetObject.RemoveAll();
                break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
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
        for(i=0;i<sheetObjects.length;i++){
           ComConfigSheet (sheetObjects[i] );
           initSheet(sheetObjects[i],i+1);
           ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="/";
        //Axon Event Handling1. Event catch
    	//axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);
    	
     	if(!CoFmsInitConfirm(sheetObjects[0])) return;
     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
            		var HeadTitle = "|Seq|Item Name|Account\nCode|Account Name|";
            		HeadTitle += "Item List Setup per screen|Item List Setup per screen|Item List Setup per screen|Item List Setup per screen|";
            		HeadTitle += "*Setup contract item account|*Setup contract item account|*Setup contract item account|*Setup contract item account|";
            		HeadTitle += "*Setup advance\npayment account\nof T/C in hire|";
            		HeadTitle += "|||||||||||||||||";//18
            		
		            var HeadTitle2 = "|Seq|Item Name|Account\nCode|Account Name|";
		            HeadTitle2 += "Other EXP|Account \nManagement|Off-hire EXP|Bunker Data\nManagement|";
		            HeadTitle2 += "T/C Out\nhire|T/C In\nhire|Add.\nComm.|Brokerage|";
		            HeadTitle2 += "*Setup advance\npayment account\nof T/C in hire";
		            HeadTitle2 += "|||||||||||||||||";//18
		            /*
            		var HeadTitle="|Seq|Item Name|Account Code|Account Name|Other EXP|Account \nManagement|Off-hire EXP|Bunker|Prepayment|Hire|Address\nCommission|Brokerage|";
		            HeadTitle +="chk_owner|chk_prepayments|chk_manual_slip|chk_vvd_required|";
		            HeadTitle +="acct_itm_seq|prev_other_exp|prev_charterer|prev_off_hire|prev_bodbor_if|";
		            HeadTitle +="prev_prepaymentp|prev_hire|prev_address|prev_brokerage|prev_owner|";
		            HeadTitle +="prev_prepayments|prev_manual_slip|prev_vvd_required";*/
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:0,   SaveName:"acct_itm_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:0,   SaveName:"acct_eng_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     
		                     {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chk_other_exp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chk_charterer",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chk_off_hire",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chk_bodbor_if",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},

		                     {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chk_hire_revenue",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chk_hire",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chk_address",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chk_brokerage",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     
		                     {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chk_prepaymentp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     
		                     {Type:"Text",  	Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"chk_owner",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		                     {Type:"Text",  	Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_prepayments",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		                     {Type:"Text",  	Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_manual_slip",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		                     {Type:"Text",  	Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chk_vvd_required",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"acct_itm_seq" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_other_exp" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_charterer" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_off_hire" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_bodbor_if" },
		                     
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_hire" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_hire_revenue" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_address" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_brokerage" },		                     
		                     
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_prepaymentp" },
		                     
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_owner" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_prepayments" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_manual_slip" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prev_vvd_required" } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetSelectionMode(smSelectionRow);
		              SetShowButtonImage(2);
//		              SetSheetHeight(550);
		              resizeSheet();
              }
                break;
         }
     }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/   
    function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:     
        		formObj.f_cmd.value=SEARCH;
        		sheetObj.DoSearch("ESM_FMS_0003GS.do", FormQueryString(formObj) );
                break;
           	case IBSAVE:  
           		if(!isValidCheckSetupData(sheetObj)) return;
	 			formObj.f_cmd.value=MULTI;
	 			sheetObj.DoSave("ESM_FMS_0003GS.do", FormQueryString(formObj));
	 			ComOpenWait(false);
                break;
        }
    }
    
    function isValidCheckSetupData(sheetObj){
    	var varChkHireRevenueRows 	= sheetObj.FindCheckedRow("chk_hire_revenue");
    	var varChkHireRows 			= sheetObj.FindCheckedRow("chk_hire");
    	var varChkAddressRows 		= sheetObj.FindCheckedRow("chk_address");
    	var varChkBrokerageRows 	= sheetObj.FindCheckedRow("chk_brokerage");
    	var varChkPrepaymentpRows 	= sheetObj.FindCheckedRow("chk_prepaymentp");
    	
    	var arrRowHireRevenue 		= varChkHireRevenueRows.split("|");
    	var arrRowHire 				= varChkHireRows.split("|");
    	var arrRowAddress 			= varChkAddressRows.split("|");
    	var arrRowBrokerage 		= varChkBrokerageRows.split("|");
    	var arrRowPrepaymentp 		= varChkPrepaymentpRows.split("|");
    	
    	//T/C Out Hire
    	if(arrRowHireRevenue.length != 1 || arrRowHireRevenue[0] == "" ){
    		ComShowCodeMessage("FMS20007","T/C Out Hire");
    		return false;
    	}
    	//T/C In Hire
    	if(arrRowHire.length != 1 || arrRowHire[0] == "" ){
    		ComShowCodeMessage("FMS20007","T/C In Hire");
    		return false;
    	}
    	//Address Commission
    	if(arrRowAddress.length != 1 || arrRowAddress[0] == ""){
    		ComShowCodeMessage("FMS20007","Add. Comm.");
    		return false;
    	}
    	//Brokerage
    	if(arrRowBrokerage.length != 1 || arrRowBrokerage[0] == ""){
    		ComShowCodeMessage("FMS20007","Brokerage");
    		return false;
    	}
    	//Setup advance payment account of T/C in hire
    	if(arrRowPrepaymentp.length != 1 || arrRowPrepaymentp[0] == ""){
    		ComShowCodeMessage("FMS20007","Setup advance payment account of T/C in hire");
    		return false;
    	}
    		
    	return true;
    	
    }	
    /**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setInitSetupData(sheetObj);
	}
	
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
		setInitSetupData(sheetObj);
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue, RaiseFlag) { 
		if(Value == OldValue) return;
		var colName = sheetObj.ColSaveName(Col);
		switch(colName){
			case "chk_hire_revenue":
			case "chk_hire":
			case "chk_address":
			case "chk_brokerage":
			case "chk_prepaymentp":
				if(Value == "1"){
					//선택된 것만 남기고 나머지는 Edit = false;
					setInitSetupEditable(sheetObj, Row, colName, true);
				}else{
					//전체를 Edit = true;
					setInitSetupEditable(sheetObj, Row, colName, false);
				}
				break;
		}
		
		
	}

    
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        sText = sheetObj.GetCellText(Row,selColName)
    	if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }        
    }
    
    function setInitSetupEditable(sheetObj, selRow, colName, isEdit){
    	if(isEdit){
    		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
	    		if(i != selRow){
	    			sheetObj.SetCellEditable(i, colName, 0);
	    		}else{
	    			sheetObj.SetCellEditable(i, colName, 1);
	    		}
	    	}
    	}else{
	    	for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
	    		sheetObj.SetCellEditable(i, colName, 1);
	    	}
    	}
    }
    
    function setInitSetupData(sheetObj){
    	var iChkHireRevenue 	= sheetObj.CheckedRows("chk_hire_revenue");
		var iChkHire 			= sheetObj.CheckedRows("chk_hire");
		var iChkAddress 		= sheetObj.CheckedRows("chk_address");
		var iChkBrokerage 		= sheetObj.CheckedRows("chk_brokerage");
		var iChkPrePayment 		= sheetObj.CheckedRows("chk_prepaymentp");
		
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
			
			if(iChkHireRevenue == 1){				
				if(sheetObj.GetCellValue(i,"chk_hire_revenue") == "1"){
					sheetObj.SetCellEditable(i, "chk_hire_revenue", 1);
				}else{
					sheetObj.SetCellEditable(i, "chk_hire_revenue", 0);
				}				
			}else{
				sheetObj.SetCellEditable(i, "chk_hire_revenue", 1);
			}	
			
			if(iChkHire == 1){				
				if(sheetObj.GetCellValue(i,"chk_hire") == "1"){
					sheetObj.SetCellEditable(i, "chk_hire", 1);
				}else{
					sheetObj.SetCellEditable(i, "chk_hire", 0);
				}				
			}else{
				sheetObj.SetCellEditable(i, "chk_hire", 1);
			}	
			
			if(iChkAddress == 1){				
				if(sheetObj.GetCellValue(i,"chk_address") == "1"){
					sheetObj.SetCellEditable(i, "chk_address", 1);
				}else{
					sheetObj.SetCellEditable(i, "chk_address", 0);
				}				
			}else{
				sheetObj.SetCellEditable(i, "chk_address", 1);
			}
			
			if(iChkBrokerage == 1){				
				if(sheetObj.GetCellValue(i,"chk_brokerage") == "1"){
					sheetObj.SetCellEditable(i, "chk_brokerage", 1);
				}else{
					sheetObj.SetCellEditable(i, "chk_brokerage", 0);
				}				
			}else{
				sheetObj.SetCellEditable(i, "chk_brokerage", 1);
			}
			
			if(iChkPrePayment == 1){				
				if(sheetObj.GetCellValue(i,"chk_prepaymentp") == "1"){
					sheetObj.SetCellEditable(i, "chk_prepaymentp", 1);
				}else{
					sheetObj.SetCellEditable(i, "chk_prepaymentp", 0);
				}				
			}else{
				sheetObj.SetCellEditable(i, "chk_prepaymentp", 1);
			}
		}
    }

    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }    