/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_5003.js
*@FileTitle  : Invoice Interface to A/R - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code added code to make a good  JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business calendar-related functions are defined as.
     * @author Hanjin Shipping
     */
    /**
     * @extends 
     * @class EES_DMT_5003 : EES_DMT_5003 on the screen for creating the script defines the task using.
     */
   	/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var IBARIF=52;	
 	//Event handler processing by button click event */
	document.onclick=processButtonClick;
 	//Event handler processing by button name */
	function processButtonClick(){
 	 /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
		var sheetObject1=sheetObjects[0];
 	 /*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;	
			var srcObj=window.event.srcElement;
			switch(srcName) {
 				case "btn_hold":
 					if(ComIsBtnEnable(srcName)) {
 	 					openPopupWindow(sheetObject1, formObj, srcName);
					}
 				break;
 				
	 			case "btn_arif":
	 				if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1, formObj, IBARIF);
					}
 				break;
 				
	 			case "btn_detail":
	 				if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObj, srcName);
					}
	 			break;
	 			
	 			case "btn_downexcel":
	 				if (sheetObj.RowCount() < 1) {//no data
	 					ComShowCodeMessage("COM132501");
	 				}
	 				else {
	 					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	 				}
	 			break;
	 			
	 			case "btn_close":
	 				ComPopUpReturnValue("Y");
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
     * IRegister as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
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
	 	 /*********************************************
          * Defined as a pop-up calls handled by the Title
          **********************************************/
//		 var spanObj = document.getElementById("title");
//		 spanObj.innerText = "  Invoice Interface to A/R - Detail";
		 for(i=0;i<sheetObjects.length;i++){
			 //khlee-Preferences change the name of the function to start
			 ComConfigSheet (sheetObjects[i] );
			 initSheet(sheetObjects[i],i+1);
			 //khlee-The final configuration functions added
			 ComEndConfigSheet(sheetObjects[i]);
		 }
		//html control event initialization
		initControl();
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	//Init Control
	function initControl() {
        axon_event.addListenerForm  ('blur'     , 'obj_blur'      , document.form ); //- focus out
        axon_event.addListenerFormat('focus'    , 'obj_focus'     , document.form ); //- focus in
		axon_event.addListenerFormat('keypress' , 'obj_keypress'  , document.form);  //- input with keyboard
	}
	//JavaScript event handling tasks OnKeyPress
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// upper case + numbers 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup2":
		    	// upper case + numbers + Exception letters
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //only numbers
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
	}
	function obj_blur(){
         //Input Validation to check + Inserting separator mask
         var obj=event.srcElement;
	}
	function obj_focus() {
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}
	/**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
	function initSheet(sheetObj,sheetNo) {
		 var cnt=0;
		 switch(sheetNo) {
		 	case 1:      // sheet1 init
		 	    with(sheetObj){
		        
				      SetSelectionMode(smSelectionList);
				      var HeadTitle="||Seq.|INV No.|A/R|Over Days|Cur.|Billing AMT|TAX AMT|Payable AMT|Type|BKG No.|B/L No.|Reference No.|DmdtSubInvNo|DMDT_INV_STS_CD";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      //(headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk_box" },
				             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_inv_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_ar_if_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"over_days",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"inv_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"inv_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"tax_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cr_inv_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dmdt_sub_inv_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dmdt_inv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
		
				      		SetEditable(1);
				            SetToolTipText(0,"over_days","Over Days from Invoice Issued date");
				            SetToolTipText(0,"cr_inv_no","Reference Invoice No for Credit Note");
				            SetSheetHeight(450);
		      }


		 		break;
	        }
	}
	function retAftARIF(){
		//After completion of processing re-viewed
		ComSetObjValue(formObj.chk_hold, "Y");
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	// Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	 		case IBSEARCH:      //retrieving			
		 		//ComOpenWait Start
				sheetObj.SetWaitImageVisible(0);
		        ComOpenWait(true);
 				formObj.f_cmd.value=SEARCH;
 	 			sheetObj.DoSearch("EES_DMT_5003GS.do",	FormQueryString(formObj) );
	 			//ComOpenWait End
				ComOpenWait(false);
	 			break;
	 		case IBARIF:
        		setParameters(COMMAND01);
        		if(!validateForm(sheetObj,formObj,sAction)) return;
        		//confirm handling...Do you want to interface the selected invoices?
        		if(!ComShowCodeConfirm('DMT00186'))
                return false;
        		//ComOpenWait Start
				sheetObj.SetWaitImageVisible(0);
		        ComOpenWait(true);
				var sParam=sheetObjects[0].GetSaveString(false) +"&" + FormQueryString(formObj);
 				var sXml=sheetObj.GetSaveData("EES_DMT_5003GS.do", sParam);
				//ComOpenWait End
				ComOpenWait(false);
				//3.Save and processing results
 				sheetObj.LoadSaveData(sXml);
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				//After completion of treatment countercheck
				ComSetObjValue(formObj.chk_hold, "Y");
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        		break;     	
		}
	}
	/**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
				case IBARIF:
					if(sheetObj.CheckedRows("chk_box") == 0) {
	    				ComShowCodeMessage('DMT00140', 'invoice');  
	         			return;
		     		}
					//Grid Check
					var selectedCnt=0;
					for (var i=1 ; i < sheetObj.GetTotalRows()+ 1; i++) {
if(sheetObj.GetCellValue(i, "chk_box") == 1) {
							//Invoice no Check the required input
if(sheetObj.GetCellValue(i, "dmdt_inv_sts_cd") == "I" || sheetObj.GetCellValue(i, "dmdt_inv_sts_cd") == "C") {
if(sheetObj.GetCellValue(i, "dmdt_ar_if_cd") == "Y") {
									ComShowCodeMessage("DMT02002", "Invoice No.");
									return false;
								}
							}else{
								ComShowCodeMessage("DMT02002", "Invoice No.");
								return false;
							}
							//2010.03.19 - Can not handle more than 100.
							selectedCnt++
							if(selectedCnt > 100){
								ComShowCodeMessage("DMT01141"); //Limited up to 100 invoices at a time
								return false;
							} 
						}
					}
					break;
    		}
        }
        return true;
    }	
	/*
	 * Lookup fields to enter information on the screen is stored in a lookup field values.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		//Retrieve Setting
		ComSetObjValue(formObj.f_cmd, sAction);							//Command
	}
    /**
	 * IBSheet lookup function lookup is complete, caused by an Event
	 */
	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
		if(ErrMsg == '') {
			var formObj=document.form;
			var fCmd=formObj.f_cmd.value;
			if(fCmd == SEARCH) {
				//check Release
				sheetObj.CheckAll("chk_box",0);
 				sheetObj.SetSumText(0, "seq","TTL");
				var invQty=0;
				var billAmt=0;
				var taxAmt=0;
				var payAmt=0;
				formObj.inv_chg_amt.value=ComAddComma2(ComRound(billAmt, 2)+'', "#,###.00");
				formObj.tax_amt.value=ComAddComma2(ComRound(taxAmt, 2)+'', "#,###.00");
				formObj.inv_amt.value=ComAddComma2(ComRound(payAmt, 2)+'', "#,###.00");
				formObj.inv_qty.value=invQty;
			}
		}
	}
    /**
     * IBSeet mouse click in the data area that occurs when cells Event<br>
     * @param {sheetObj} String : IBSheet Cells name
     * @param {Row} Long : Row Index of Cell
     * @param {Col} Long : 해당 셀의 Column Index of Cell
     * @param {Value} String : modified value, Format does not apply the values ​​to be used when saving
     * @param {CellX} Long : X coordinate of Cell
     * @param {CellY} Long : Y coordinate of Cell
     * @param {CellW} Long : width of Cell
     * @param {CellH} Long : height of Cell
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
        with(sheetObj) {
            if (ColSaveName(Col) != "chk_box") {
                // Check Box Check that row when clicked
                // "/" As separator import times by connecting the selected row, result:"3/4/5"
                var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (GetCellEditable(arr[i], "chk_box")) {
                        	// Toggle
                        	if(GetCellValue(arr[i], "chk_box") == '0'){
                        		SetCellValue(arr[i], "chk_box",'1',0);
                        	} else {
                        		SetCellValue(arr[i], "chk_box",'0',0);
                        	}
                        } //if (GetCellEditable(arr[i], "chk_box")) {
                    } //for (i=0; i<arr.length; i++) {
                    // AllCheck box State synchronization
                    if (CheckedRows("chk_box") == RowCount()) {
                    	SetHeaderCheck(0, "chk_box",1);
                    } else {
                    	SetHeaderCheck(0, "chk_box",0);
                    }
                }
            } else {
            	//AllCheck box when you click Check box synchronization processing conditions
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
		//After the calculation logic toggle reprocessing.
        setSelectedTotal(sheetObj);
    }  
   /**
    * Amount calculated when you click Detail Sheet check box
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnChange (sheetObj, Row, Col, Value) {
		//After the calculation logic toggle reprocessing.
        setSelectedTotal(sheetObj);
	}
	
	//After the calculation logic toggle reprocessing.
	function setSelectedTotal(sheetObj) {
		var formObj		 = document.form;
		
        var invChgAmtSum = 0;
		var taxAmtSum    = 0;
		var invAmtSum    = 0;        
		var iCnt         = sheetObj.CheckedRows("chk_box");
		var arrChkRowStr = sheetObj.FindCheckedRow("chk_box");

		if (arrChkRowStr != "") {
			var arrChkRow = arrChkRowStr.split("|");

	        for(var i=0; i < iCnt; i++) {
	        	var iRow      = arrChkRow[i];
	        	
	        	var invChgAmt = sheetObj.GetCellValue(iRow, "inv_chg_amt");
	        	var taxAmt    = sheetObj.GetCellValue(iRow, "tax_amt");
	        	var invAmt	  = sheetObj.GetCellValue(iRow, "inv_amt");
	        	
				//Billing AMT
	        	if (invChgAmt != "") 
	        		invChgAmtSum += parseFloat(invChgAmt);
				//Tax AMT
	        	if (taxAmt != "")
	        		taxAmtSum += parseFloat(taxAmt);
				//Payable AMT
	        	if (invAmt != "")
	        		invAmtSum += parseFloat(invAmt);
	        }
		}
		ComSetObjValue(formObj.inv_chg_amt, DmtComSetComma(invChgAmtSum));
		ComSetObjValue(formObj.tax_amt,     DmtComSetComma(taxAmtSum));
		ComSetObjValue(formObj.inv_amt,     DmtComSetComma(invAmtSum));
		ComSetObjValue(formObj.inv_qty,     iCnt);		
	}
	
    // Number comma format settings : ComAddComma2(ComRound(totAmt, 2)+'', "#,###.00");
	function setComma(){
    	var formObj=document.form;
    	var invChgAmt=ComAddComma2(ComRound(ComGetObjValue(formObj.inv_chg_amt), 2)+'' ,"#,###.00");
		var taxAmt=ComAddComma2(ComRound(ComGetObjValue(formObj.tax_amt), 2)+''     ,"#,###.00");
		var invAmt=ComAddComma2(ComRound(ComGetObjValue(formObj.inv_amt), 2)+''     ,"#,###.00");
		ComSetObjValue(formObj.inv_chg_amt, invChgAmt);
		ComSetObjValue(formObj.tax_amt, taxAmt);
		ComSetObjValue(formObj.inv_amt, invAmt);
    }
	/*
	 * Double-click pop-up(5003)
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		
		//체크박스 더블클릭시에는 팝업호출 제외(의도치않게 선택과 해제시에 팝업이 뜨는 현상을 방지하기 위함)
		if (sheetObj.ColSaveName(Col) == "chk_box") return;
		
		 // Invoice or Manual Invoice 팝업화면을 띄워준다.
		 openInvoiceCreationIssueBooking(sheetObj, document.form);		
	}
	
	function findCommodity(rtnVal) {
  		var formObj = document.form;
        if(rtnVal == "Y") {
        	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}
   }
	/**
	 * Pop-up call
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		
		 if (srcName == "btn_detail") {
			 // Invoice or Manual Invoice 팝업화면을 띄워준다.
			 openInvoiceCreationIssueBooking(sheetObj, formObj);
		 }// End of the "btn_detail" action
		 else if(srcName == "btn_hold") {
			var dmdtInvNo="";
			for(var i=1; i <= sheetObj.RowCount(); i++) {
				if(sheetObj.GetCellValue(i, "chk_box") == "1"){
					dmdtInvNo += ","+sheetObj.GetCellValue(i,  "dmdt_inv_no");
				}			
			}
			dmdtInvNo=dmdtInvNo.substring(1);
			if(dmdtInvNo == ''){
				ComShowCodeMessage('DMT00140', 'invoice');  
     			return;
			}
			ComOpenPopupWithTarget('EES_DMT_5101.do?invoiceNo='+dmdtInvNo, "540", "360", "", "0,1", true);
		 }
	} 
	
	function fnCallProc(rtnVal) {
		if (rtnVal == "Y") {
			ComSetObjValue(document.form.chk_hold, "Y");
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	function openInvoiceCreationIssueBooking(sheetObj, formObj) {

		var subInvType=sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "dmdt_sub_inv_no");
		
		 if (subInvType == 'R' || subInvType == 'T') {
			//4002
			var url="EES_DMT_4002.do"
				+"?group_by=1"
				+"&chg_type="
				+"&ofc_cd="+ComGetObjValue(formObj.ofc_cd)
				+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
				+"&dmdt_trf_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "dmdt_trf_cd")
				+"&invoice_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "dmdt_inv_no")
				+"&cntr_no="
				+"&invoice_issue=2"	
				;
			ComOpenPopup(url, "1050", "700", "fnCallProc", "0,1", true);
		} 
		 else if (subInvType == 'M') {
			//4004
			var url="EES_DMT_4004P.do"
				+"?dmdt_inv_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "dmdt_inv_no")
				+"&caller=5003"
				;
			ComOpenPopup(url, "1100", "700", "fnCallProc", "0,1", true);
		}		
	}
	/* developers work end */
