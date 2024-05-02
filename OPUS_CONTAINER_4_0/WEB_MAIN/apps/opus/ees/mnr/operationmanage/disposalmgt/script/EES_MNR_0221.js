/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0221.jsp
*@FileTitle  : Sold Creation File Import_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
    /* developer job	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var verifyCheck=false;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				//Verify
		        case "btn_Save":
	                doActionIBSheet(sheetObject, formObject, IBSAVE); 
	                break;        
		        case "btn_RowAdd":
	                doActionIBSheet(sheetObject, formObject, IBINSERT); 
	                break;        
		        case "btn_RowDel":
	                doActionIBSheet(sheetObject, formObject, IBDELETE); 
	                break;        
				case "btn_New":
					doActionIBSheet(sheetObject, formObject, IBCLEAR);
					break;
				case "btn_LoadExcel":
					doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
					break;
				case "btn_OK":
					doActionIBSheet(sheetObject, formObject, "doOK");
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {     
				ComFuncErrMsg(e);          
    		} else {      
				ComFuncErrMsg(e);    
    		}   
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	//setting button
    	MnrWaitControl(true);
    	// initializing IBSheet
    	for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }	
    	// initializing form
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
    }
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     * @param	{IBSheet}	sheetObj	initializing sheetObject 
     * @param	{String}	sheetNo		sheetObject tag serial number
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
                
		              var HeadTitle1="|Sel|Del|Seq|EQ No.|P/Up Yard|Sold DT|Verify Result";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"checkbox" },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_check" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inp_msg1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg3",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"inp_msg5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg4" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetEditableColorDiff(0);
		              SetCountPosition(0);
		              SetSelectionMode(smSelectionRow);
		              SetSheetHeight(202);
              		}

                break;  
        }
    }
	/** 
	 * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
	 * @param    {IBSheet}	sheet_obj	registering IBSheet Object as list
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**  
	 * Checkbox event
	 * setting Edit in case of unchecking Sel checkBox
	 * Sel checkBox:Edit  -> false
	 * All Column  :Edit  -> true
	 * Verfy Column:Value -> null
	 * BackColor          -> Edit
	 * @param	{IBSheet}		sheetObj	comboObject  
	 * @param 	{String} 			Row 		Row 
	 * @param 	{String} 			Col 		Col 
	 */  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){  
		if(sheetObj.ColSaveName(Col) == 'checkbox') {
			if(sheetObj.GetCellValue(Row,Col) == 1){
				//set Verify Columns Value null 
				sheetObj.SetCellValue(Row,"inp_msg4","");
				sheetObj.SetCellValue(Row,"inp_msg5","");
				//set All Columns Edit true without Sel-checkbox(false)	                              
				sheetObj.SetCellEditable(Row, "checkbox",0);
				sheetObj.SetCellEditable(Row, "inp_msg1",1);
				sheetObj.SetCellEditable(Row, "inp_msg2",1);
				//set BackColor
				sheetObj.SetRowBackColor(Row,"#FFFFFF");
			} 
		}				
	} 
  	/**
     * handling process sheet
     * @param	{IBSheet}	sheetObj	handling sheetObject 
     * @param	{Form}		formObj		handling formObject
     * @param	{Number}	sAction		Action constants  
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			//initializing
			case IBCLEAR:
				//setting button and progressing bar
				sheetObj.SetWaitImageVisible(0);
				MnrWaitControl(true);
		    	sheetObj.RemoveAll();
		    	verifyCheck=false;
				//setting button and progressing bar
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
			//Verify
			case IBSAVE:        
				if(validateForm(sheetObj,formObj,sAction)) {
	          		formObj.f_cmd.value=MULTI;
					var sParam=sheetObj.GetSaveString(true, true);
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj); 
				    var sXml=sheetObj.GetSaveData("EES_MNR_0221GS.do", sParam);
				    sheetObj.LoadSaveData(sXml);
				    verifyCheck=true;
				    doAfterSave();
				}
				break;
			//adding row
			case IBINSERT:
				var Row=sheetObj.DataInsert(-1);
				//set CheckBox(Sel) Edit(false) 	 
				sheetObj.SetCellEditable(Row,"checkbox",0);
				//set Focus 
				sheetObj.SelectCell(Row, "inp_msg1");
				break;
			//deleting row
			case IBDELETE:
				ComRowHideDelete(sheetObj, "del_check");
				break;
			//Load Excel
			case IBLOADEXCEL:
			    var columnMapping="1=>4|2=>5|3=>6"; 
			    sheetObj.LoadExcel({ Mode:"NoHeader",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false,ColumnMapping:"columnMapping"});
			 	
				break;
			//OK
			case "doOK":
				if(validateForm(sheetObj,formObj,sAction)) {
					comPopupOK();	
				}
				break;
        }
    }
  	/**
     * handling process for input validation
     * @param	{IBSheet}	sheetObj	checking sheetObject 
     * @param	{Form}		formObj		checking comboObject
     * @param	{Number}	sAction		Action constants  
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			// clicking Verify button
			if(sAction==IBSAVE) {
				// double check
				var Row=sheetObj.ColValueDup("inp_msg1");
				if(Row>0){
					ComShowCodeMessage("MNR00006",(Row) + " row ");
					sheetObj.SelectCell(Row, "inp_msg1", true);
					return false;
				}
			}
			//clickiing OK button
			else if(sAction=="doOK") {
				//checking whether Verify 
				if(!verifyCheck){  
					ComShowCodeMessage("MNR00157");
					return false;          		 	  
				}
				var selCnt=0;
				for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
					var selValue=sheetObj.GetCellValue(i, "checkbox");
					if(selValue == "1") {
						selCnt++;
					}
				}
				var insCnt=formObj.ins_cnt.value;
				if(insCnt < selCnt) {
					//Selected EQ number exceeds the number of EQ to input
					ComShowCodeMessage("MNR00266"); 
					return false;
				}
			}
        }
        return true;
    }
/* ********* User Functions ************* */
	/** 
	 * setting color and whether modifying after Verify
	 */
	function doAfterSave() {
		for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++ ) {
			var verifyResult=sheetObjects[0].GetCellValue(i, "inp_msg4");
			//success
			if(verifyResult == "SS") {
				sheetObjects[0].SetRowBackColor(i,"#FFFFFF");
				sheetObjects[0].SetCellEditable(i, "inp_msg1",0);
				sheetObjects[0].SetCellEditable(i, "inp_msg2",0);
			//error
			} else {
				sheetObjects[0].SetRowBackColor(i,"#FFFFFF");
				sheetObjects[0].SetCellEditable(i, "checkbox",0);
			}
		}
	}
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		//setting Sel Column Edit
	 	for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			sheetObj.SetCellEditable(i,"checkbox",0);
		}
	}
