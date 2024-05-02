/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SCO_0200.js
*@FileTitle  : AP Cost Activity Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick() {
		/*******************************************************/
		var formObj=document.form;
		
		var sheetID = sheetObjects[0].id;
		var prefix = sheetID + "_";
		
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					break;
	    	    case "btn_new" :
	    	    	formObj.reset();
	    	    	sheetObjects[0].RemoveAll();
					comboObjects[0].RemoveAll();
					doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
	    	    	break;					
 				case "btn_save":
 					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 					break;	
 				
 				case "btn_RowAdd":
 					var row=sheetObjects[0].DataInsert(-1);
 					sheetObjects[0].SetCellValue(row,prefix+"enbl_flg","0");
 					break;
 					
 				case "btn_downexcel":
	    	    	if(sheetObjects[0].RowCount() < 1){//no data	
	    	    		ComShowCodeMessage("COM132501");
	    	    	}else{	
	    	    		sheetObjects[0].Down2Excel({ HiddenColumn:1, Merge:1});
	    	    	}	
	    	    	break;
 				case "btn_RowDelete":
 					var row = sheetObjects[0].GetSelectRow();	
 					if (sheetObjects[0].GetCellValue(row, prefix+"ibflag") == "I") { 
 						sheetObjects[0].SetRowHidden(row,1);
						sheetObjects[0].SetRowStatus(row,"D");
 					} else {
 						ComShowCodeMessage("COM130302", ""); 
 					}
					
 					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage(OBJECT_ERROR);
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/** 
	 * registering IBCombo Object as list
	 * param : combo_obj
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
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
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
	    initControl();
	    
	    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	    
	    ComSetObjValue(src_mdl_cd,  " ");   
	    
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboObj.options.id) {
			   default :
		           with (comboObj) {
					   SetTitle("Code|Desc");
				   	   SetTitleVisible(true);
				   	   SetColAlign(0, "left");
				   	   SetColAlign(1, "left");
				   	   SetColWidth(0, "50");
				   	   SetColWidth(1, "150");
					   SetDropHeight(160);
			       }
	           break;
	     }
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:   
			    with(sheetObj){		       
			      var HeadTitle1="|Del|Source Module|Cost Code|Account|Code Description|Activity Date|Activity Place|Accrual Flag";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   	Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			                   {Type:"CheckBox",  Hidden:0, Width:0,    	Align:"Center",  ColMerge:1,   SaveName:prefix+"enbl_flg" },
			                   {Type:"Combo", 	  Hidden:0, Width:120,   	Align:"Center",  ColMerge:1,   SaveName:prefix+"src_mdl_cd",       KeyField:1,   CalcLogic:"",   Format:"",	   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
			                   {Type:"Text", 	  Hidden:0, Width:100,  	Align:"Left",    ColMerge:1,   SaveName:prefix+"act_cost_cd",	   KeyField:1,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
			                   {Type:"PopupEdit", Hidden:0, Width:100,  	Align:"Center",  ColMerge:1,   SaveName:prefix+"conv_acct_cd",	   KeyField:1,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
			                   {Type:"Text",      Hidden:0, Width:400,   	Align:"Left",  	 ColMerge:1,   SaveName:prefix+"act_cost_nm",      KeyField:1,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
			                   {Type:"Combo",     Hidden:0, Width:150,   	Align:"Left",    ColMerge:1,   SaveName:prefix+"act_dt_nm",        KeyField:1,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			                   {Type:"Combo",     Hidden:0, Width:150,   	Align:"Left",    ColMerge:1,   SaveName:prefix+"act_plc_nm",       KeyField:1,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			                   {Type:"Combo",     Hidden:0, Width:60,   	Align:"Center",  ColMerge:1,   SaveName:prefix+"accl_flg",         KeyField:1,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      
			      SetColProperty(prefix+"accl_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
			      ScoInitDataCombo(sheetObj, prefix + "src_mdl_cd", "2", " " , " ", "AP SOURCE MODULE" , "") ;
				  ScoInitDataCombo(sheetObj, prefix + "act_dt_nm", "2", " " , " ", "AP ACTIVITY DATE" , "") ;
				  ScoInitDataCombo(sheetObj, prefix + "act_plc_nm", "2", " " , " ", "AP ACTIVITY PLACE" , "") ;
				  SetColProperty(0 ,prefix + "act_cost_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      
				  InitComboNoMatchText(true);
			        
			      //SetSheetHeight(430);
				  resizeSheet();
				  
		         }
			    break;
	    }
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		switch (sAction) {
		    case COMMAND01: // when form open
		    	//Condition - Source Module
		 		var comboItems = ScoGetLookupComboItems(sheetObjects[0], "AP SOURCE MODULE");
		 		ScoAddComboItem2(comboObjects[0], comboItems, "2", "ALL", " "); 
		 		
				break;
			case IBSEARCH: //RETRIEVE
				//search start 
				formObj.f_cmd.value=SEARCH;			
 				var sXml=sheetObj.GetSearchData("STM_SCO_0200GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
 				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;
			case IBSAVE: // SAVE
				formObj.f_cmd.value=MULTI01;
				//checking mandatory
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					return;
				}

				var sParam=sParam1 + "&" +  FormQueryString(formObj);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("STM_SCO_0200GS.do", sParam);
 				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") {
		            return;  
		        } 
				ComShowCodeMessage("COM130102", "Data"); 
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
				break;	
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		    case IBSEARCH: //retrieve
				break;
				
		    case IBSAVE:	//save
		    	if (sheetObj.IsDataModified()== false) {
		    		ComShowCodeMessage("SCO00008", " to Save."); // There is no data msg.
		    		return false;
		    	}
	 		   
		    	//checking mandatory
				var sParam1=ComGetSaveString(sheetObj, true, true);
				if(sParam1 == "" ){
					return false;
				}

		    	break;
		}
		return true;
	}
	
	/**
	 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
	 * @param {sheetObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		if (Value == "") return;
		var sheetID=sheetObj.id;
		var formObj=document.form;
		var prefix=sheetID + "_";
	    with (sheetObj) {
	        switch (ColSaveName(Col)) {
		        case  prefix + "conv_acct_cd":    //Account
		        	var sXml=sheetObj.GetSearchData("STM_SAP_0010GS.do", "f_cmd=" + COMMAND05 + "&value0=" + Value);
		        	var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		        	if(result != "F"){
		            	if ( Value != ComGetEtcData(sXml, "acct_cd") ) {
		           			ComShowCodeMessage("COM132201", "Account" ); 
		           			sheetObj.SetCellValue(Row,Col,"");
	     					sheetObj.SelectCell(Row,Col, true, "");
	     					break;		
		           		}
		            }  
		    		break;
	        }
	    }
	}	
	
	/**
	 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
	 * @param {sheetObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */	
	function sheet1_OnPopupClick(sheetObj, Row, Col){
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		var param="";
		var linetype = "ITEM";
		with (sheetObj) {
	        switch (ColSaveName(Col)) {
	            case prefix + "conv_acct_cd":    //Account
	            	var param="?acct_cd="+ encodeURIComponent(sheetObj.GetCellValue(Row, prefix + "conv_acct_cd"))+"&line_type="+linetype;
	            	ComOpenPopup("STM_SAP_0450.do" + param, 500, 400, "setPopupData", "0,0", true, false, Row, Col, 0);
	            	break;
	        }
	    }
	}
	
	/**
	 * Pop-Up Return Value 처리 부분<br>
	 * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
	 * @param ShtIdx : 대상IBSheet의 Sheet Array index
	 */
	function setPopupData(aryPopupData, Row, Col, ShtIdx) {
	    if (aryPopupData.length > 0 ) {
	        with (sheetObjects[ShtIdx]) {
	        	var sheetObj=sheetObjects[ShtIdx];
	            switch (ColSaveName(Col)) {
	                default:
	                    SetCellValue(Row, Col,aryPopupData[0][1]);
	                    break;
	            }
	        }
	    }
	}
	
	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		var formObj=document.form;
	    //handling Axon event. event catch
		//axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
	   // axon_event.addListenerFormat('keyup'   , 'obj_keyup'  , formObj);
	    axon_event.addListenerFormat('focus'   , 'obj_activate', formObj);
	    axon_event.addListenerFormat ('blur', 'obj_deactivate', formObj);  //beforedeactivate   deactivate
	    axon_event.addListener('change', 'vndr_no_onchange', 'vndr_no', '');	
	}
   
	/** 
	 * handling Keypress event of Object  <br>
	 * checking validation of input value by dataformat of object  <br>
	 */ 
	function obj_keyup(){
	}  
	/** 
	 * handling work javascript OnFocus event  <br>
	 */    
	function obj_activate() {
	   	//delete mask separator
        ComClearSeparator(ComGetEvent());     
	}
	/** 
	 * handling work javascript OnBlur event  <br>
	 */    
	function obj_blur(){
		// ComChkObjValid(ComGetEvent());
	}    
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
	 **/
	function obj_deactivate(){
		ComChkObjValid(ComGetEvent());
	}
	
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}	
  
