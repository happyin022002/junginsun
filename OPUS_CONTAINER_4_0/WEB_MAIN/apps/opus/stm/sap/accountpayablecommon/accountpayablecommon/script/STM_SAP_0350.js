/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0350.js
*@FileTitle  : AP Vendor
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
					//comboObjects[0].RemoveAll();
	    	    	break;					
 				case "btn_save":
 					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 					break;	
 				case "btns_search_supplier":
					var param="?vndr_seq=" + formObj.vndr_no.value + "&delt_flg=";
					ComOpenPopup("STM_SAP_0002.do" + param, 900, 420, "setSupplier", "0,0", true, false);
					break;		
 				case "btn_RowAdd":
 					var row=sheetObjects[0].DataInsert(-1);
 					sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"ibflag","I");
 					break;
 				case "btn_RowDelete":
 					rowRemove(sheetObjects[0]);
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
				       //SetColAlign("left");
					   //DropHeight = 160;
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
			      var HeadTitle1="|Del|Supplier Code|Supplier Name|Liability Account|Liability Account|Liability Account|Liability Account|Liability Account|Liability Account|Liability SEQ|Prepayment Account|Prepayment Account|Prepayment Account|Prepayment Account|Prepayment Account|Prepayment Account|Prepayment SEQ|Priority";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
			             {Type:"PopupEdit", Hidden:0, Width:150,   Align:"Center",  ColMerge:1,   SaveName:"vndr_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"PopupEdit", Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"l_company_code",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"l_region_code",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"l_center_code",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"l_account_code",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"l_intercompany_code",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"l_vvd_code",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"liab_cd_cmb_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p_company_code",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p_region_code",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"p_center_code",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"p_account_code",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p_intercompany_code",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"p_vvd_code",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pay_cd_cmb_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pay_prio_cd",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 } ];
			      InitColumns(cols);
			      SetEditable(1);
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
		    	// pop office Information
		    	if (formObj.popOfcCd.value != "") {
		    		formObj.ofc_cd.value=formObj.popOfcCd.value;
		    	} else { 
			    	// Login-user's AP office Information
			    	formObj.ofc_cd.value=SapGetLoginAPOfc(sheetObj);
		    	}
		    	// Bank Account Type Combo
		 		var bankTpComboItems=SapGetComboItems(sheetObjects[0], "BANK ACCOUNT TYPE(L)", "");
		 		SapAddComboItem(comboObjects[0], bankTpComboItems, "2", " ", " "); 
		    	break;
			case IBSEARCH: //RETRIEVE
				//search start 
				formObj.f_cmd.value=SEARCH;			
 				var sXml=sheetObj.GetSearchData("STM_SAP_0350GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				break;
			case IBSAVE: // SAVE
				formObj.f_cmd.value=MULTI01;
				//checking mandatory
				var sParam1=ComGetSaveString(sheetObjects[0], true, true);
				if(sParam1 == "" ){
					return;
				}
				var str = FormQueryString(formObj).replace("vndr_no=&","");
				str = str.replace("vndr_nm=&","");
				var sParam=sParam1 + "&" + str;
				ComOpenWait(true);
				setTimeout( function () {
					var sXml=sheetObj.GetSaveData("STM_SAP_0350GS.do", sParam);
	 				sheetObj.LoadSaveData(sXml);
	 				SapOpenWait(false,true); 
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") {
			            return;  
			        } 
					ComShowCodeMessage("COM130102", "Data"); 
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				} , 100);				
 				
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
		    		ComShowCodeMessage("SAP00015", " to Save."); // There is no data msg.
		    		return false;
		    	}

	 		    for(var i=1; i <=sheetObj.RowCount(); i++ ) {
					if ("I" == sheetObj.GetCellValue(i, "ibflag") || "U" == sheetObj.GetCellValue(i, "ibflag")) {
						var company=sheetObj.GetCellValue(i, "l_company_code");
						var region=sheetObj.GetCellValue(i, "l_region_code");
						var center=sheetObj.GetCellValue(i, "l_center_code");
						var account=sheetObj.GetCellValue(i, "l_account_code");
						var intercom=sheetObj.GetCellValue(i, "l_intercompany_code");
						var vvd=sheetObj.GetCellValue(i, "l_vvd_code");
	                	var coa_seq=SapGetCOAInfo(sheetObj, company, region, center, account, intercom, vvd);
	                	if (coa_seq == "" || coa_seq == "NO_DATA") {
			    			 var cmb_chk = SapAddCCID(sheetObj, company, region, center, account, intercom, vvd);
	                		 var cmb_msg = cmb_chk[0];
	                		 var cmb_seq = cmb_chk[1];
	                		 
	                		 if (cmb_msg != "OK") {
	                			 ComShowMessage(cmb_msg);
	                			 return false;
	                		 } else {
	                			 sheetObj.SetCellValue(i, "liab_cd_cmb_seq",cmb_seq);
	                		 }
	                	} else {
	                		sheetObj.SetCellValue(i, "liab_cd_cmb_seq",coa_seq);
	                	}
						var p_company=sheetObj.GetCellValue(i, "p_company_code");
						var p_region=sheetObj.GetCellValue(i, "p_region_code");
						var p_center=sheetObj.GetCellValue(i, "p_center_code");
						var p_account=sheetObj.GetCellValue(i, "p_account_code");
						var p_intercom=sheetObj.GetCellValue(i, "p_intercompany_code");
						var p_vvd=sheetObj.GetCellValue(i, "p_vvd_code");
	                	var p_coa_seq=SapGetCOAInfo(sheetObj, p_company, p_region, p_center, p_account, p_intercom, p_vvd);
	                	if (p_coa_seq == "" || p_coa_seq == "NO_DATA") {
	                		 var cmb_chk = SapAddCCID(sheetObj, p_company, p_region, p_center, p_account, p_intercom, p_vvd);
	                		 var cmb_msg = cmb_chk[0];
	                		 var cmb_seq = cmb_chk[1];
	                		 
	                		 if (cmb_msg != "OK") {
	                			 ComShowMessage(cmb_msg);
	                			 return false;
	                		 } else {
	                			 //return cmb_seq;
	                			 sheetObj.SetCellValue(i, "pay_cd_cmb_seq",cmb_seq);
	                		 }
	                	} else {
	                		sheetObj.SetCellValue(i, "pay_cd_cmb_seq",p_coa_seq);
	                	}
		    		}
				}
	 		    	
		    	//checking mandatory
				var sParam1=ComGetSaveString(sheetObj, true, true);
				if(sParam1 == "" ){
					return false;
				}
					
		    	// Check Duplicate Supplier Code
				var dupRow=sheetObj.ColValueDup("vndr_no");
	            if(dupRow != -1) {
	            	ComShowCodeMessage("COM131302", "Supplier Code");
	            	sheetObj.SetSelectRow(dupRow);
	            	return false;
	            }
		    	break;
		}
		return true;
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
	 * control keyboard input  onkeypress event of HTML Control
	 **/
//	function obj_keypress() {
//		switch(ComGetEvent().dataformat){
//			case "engup":
//				ComKeyOnlyAlphabet('uppernum');
//				break;
//			case "engnum":
//				//English to enter uppercase letters, uppercase letters+number
//	            ComKeyOnlyAlphabet('uppernum');
//				break;	
//		}
//	}   
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
        with (sheetObj) {
            switch (ColSaveName(Col)) {
            	case "vndr_no":    		// vndr_no
            		var vndr_no=sheetObj.GetCellValue(Row, "vndr_no") ;
                	var vendorParam="&delt_flg=N&vndr_seq=" + vndr_no;
                 	var sXml2=sheetObj.GetSearchData("STM_SAP_0002GS.do", "f_cmd=" + SEARCH + vendorParam);
                	if (SAPDecideErrXml(sheetObj, sXml2)) {
        				return;
        			} else {      
        				if ("NO_DATA" == ComGetEtcData(sXml2, "vndr_nm") ) {        					
        					ComShowCodeMessage("COM132201", "Supplier Code" );  
        					sheetObj.SetCellValue(Row, "vndr_no", "");
        					sheetObj.SelectCell(Row, "vndr_no", true, "");
        					return false;				
        				} else { 
	        				//clear
		                	sheetObj.SetCellValue(Row, "vndr_nm","",0);
		                	//setting
		                	sheetObj.SetCellValue(Row, "vndr_nm",ComGetEtcData(sXml2, "vndr_lgl_eng_nm"));
        				}
                	}
                	break;
            	case "l_account_code":    		// Liability Account
            		var l_account_code=sheetObj.GetCellValue(Row, "l_account_code") ;
            		var thisAcctNum=l_account_code.substring(0,1);
            		if ( "2" != thisAcctNum) {
        				ComShowCodeMessage("SAP00007", "Liability Account", "2"); 
        				sheetObj.SetCellValue(Row, "l_account_code","");
        				sheetObj.SelectCell(Row, "l_account_code", true);
        				break;
        			}  
                	break;	
            	case "p_account_code":    		// Prepayment Account
            		var p_account_code=sheetObj.GetCellValue(Row, "p_account_code") ;
            		var thisAcctNum=p_account_code.substring(0,1);
            		if ( "1" != thisAcctNum) {
        				ComShowCodeMessage("SAP00007", "Prepayment Account", "1");   
        				sheetObj.SetCellValue(Row, "p_account_code","");
        				sheetObj.SelectCell(Row, "p_account_code", true);
        				break;
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
		with (sheetObj) {
            switch (ColSaveName(Col)) {
                case  "vndr_nm":    //Supplier Name
                	var param="?vndr_lgl_eng_nm="+ encodeURIComponent(sheetObj.GetCellValue(Row, Col)) + "&delt_flg=N";
					ComOpenPopup("STM_SAP_0002.do" + param, 900, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  "vndr_no":    //Supplier code
                	var param="?vndr_seq=" + sheetObj.GetCellValue(Row, Col) + "&delt_flg=N";
					ComOpenPopup("STM_SAP_0002.do" + param, 900, 420, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  "l_vvd_code":    //Liability Account
					var company=sheetObj.GetCellValue(Row, "l_company_code");
					var region=sheetObj.GetCellValue(Row, "l_region_code");
					var center=sheetObj.GetCellValue(Row, "l_center_code");
					var account=sheetObj.GetCellValue(Row, "l_account_code");
					var intercom=sheetObj.GetCellValue(Row, "l_intercompany_code");
					var vvd=sheetObj.GetCellValue(Row, "l_vvd_code");
            		var param="?account_type=2%&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;  
            		param += "&lineType=MAIN";            		
                	ComOpenPopup("STM_SAP_0021.do"+param, 450, 300, "setPopupData", "0,0", true, false, Row, Col, 0);
                	break;
                case  "p_vvd_code":    //Payment Account
					var company=sheetObj.GetCellValue(Row, "p_company_code");
					var region=sheetObj.GetCellValue(Row, "p_region_code");
					var center=sheetObj.GetCellValue(Row, "p_center_code");
					var account=sheetObj.GetCellValue(Row, "p_account_code");
					var intercom=sheetObj.GetCellValue(Row, "p_intercompany_code");
					var vvd=sheetObj.GetCellValue(Row, "p_vvd_code");
            		var param="?account_type=2%&company=" + company +"&region=" + region +"&center=" + center  +"&account=" + account  +"&intercom=" + intercom  +"&vvd=" + vvd;  
            		param += "&lineType=PREPAY_ITEM";            		
                	ComOpenPopup("STM_SAP_0021.do"+param, 450, 300, "setPopupData", "0,0", true, false, Row, Col, 0);
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
            	var prefix=sheetObjects[ShtIdx].id + "_";
                switch (ColSaveName(Col)) {
                   	case "vndr_nm":
                   	case "vndr_no":	
                    	//clear
                   		sheetObj.SetCellValue(Row, "vndr_no","",0);
                    	sheetObj.SetCellValue(Row, "vndr_nm","",0);
                    	//setting
                    	sheetObj.SetCellValue(Row, "vndr_no",aryPopupData[0][1]);
                    	sheetObj.SetCellValue(Row, "vndr_nm",aryPopupData[0][2]);
                    	break;
                    case "l_vvd_code":
                    	//clear
                    	sheetObj.SetCellValue(Row, "l_company_code","",0);
                    	sheetObj.SetCellValue(Row, "l_region_code","",0);
                    	sheetObj.SetCellValue(Row, "l_center_code","",0);
                    	sheetObj.SetCellValue(Row, "l_account_code","",0);
                    	sheetObj.SetCellValue(Row, "l_intercompany_code","",0);
                    	sheetObj.SetCellValue(Row, "l_vvd_code","",0);
                    	sheetObj.SetCellValue(Row, "liab_cd_cmb_seq","",0);
                    	//setting
                    	sheetObj.SetCellValue(Row, "l_company_code",aryPopupData[0][1]);
                    	sheetObj.SetCellValue(Row, "l_region_code",aryPopupData[0][2]);
                    	sheetObj.SetCellValue(Row, "l_center_code",aryPopupData[0][3]);
                    	sheetObj.SetCellValue(Row, "l_account_code",aryPopupData[0][4]);
                    	sheetObj.SetCellValue(Row, "l_intercompany_code",aryPopupData[0][5]);
                    	sheetObj.SetCellValue(Row, "l_vvd_code",aryPopupData[0][6]);
						/*var company=sheetObj.GetCellValue(Row, "l_company_code");
						var region=sheetObj.GetCellValue(Row, "l_region_code");
						var center=sheetObj.GetCellValue(Row, "l_center_code");
						var account=sheetObj.GetCellValue(Row, "l_account_code");
						var intercom=sheetObj.GetCellValue(Row, "l_intercompany_code");
						var vvd=sheetObj.GetCellValue(Row, "l_vvd_code");
                    	var coa_seq=SapGetCOAInfo(sheetObj, company, region, center, account, intercom, vvd);
                    	if (coa_seq == "" || coa_seq == "NO_DATA") {
                    		ComShowCodeMessage("COM132201", "Liability Account");
			    			break;
                    	} else {
                    		sheetObj.SetCellValue(Row, "liab_cd_cmb_seq",coa_seq);
                    	}*/
                    	break;	
                    case "p_vvd_code":
                    	//clear
                    	sheetObj.SetCellValue(Row, "p_company_code","",0);
                    	sheetObj.SetCellValue(Row, "p_region_code","",0);
                    	sheetObj.SetCellValue(Row, "p_center_code","",0);
                    	sheetObj.SetCellValue(Row, "p_account_code","",0);
                    	sheetObj.SetCellValue(Row, "p_intercompany_code","",0);
                    	sheetObj.SetCellValue(Row, "p_vvd_code","",0);
                    	sheetObj.SetCellValue(Row, "pay_cd_cmb_seq","",0);
                    	//setting
                    	sheetObj.SetCellValue(Row, "p_company_code",aryPopupData[0][1]);
                    	sheetObj.SetCellValue(Row, "p_region_code",aryPopupData[0][2]);
                    	sheetObj.SetCellValue(Row, "p_center_code",aryPopupData[0][3]);
                    	sheetObj.SetCellValue(Row, "p_account_code",aryPopupData[0][4]);
                    	sheetObj.SetCellValue(Row, "p_intercompany_code",aryPopupData[0][5]);
                    	sheetObj.SetCellValue(Row, "p_vvd_code",aryPopupData[0][6]);
						/*var company=sheetObj.GetCellValue(Row, "p_company_code");
						var region=sheetObj.GetCellValue(Row, "p_region_code");
						var center=sheetObj.GetCellValue(Row, "p_center_code");
						var account=sheetObj.GetCellValue(Row, "p_account_code");
						var intercom=sheetObj.GetCellValue(Row, "p_intercompany_code");
						var vvd=sheetObj.GetCellValue(Row, "p_vvd_code");
                    	var coa_seq=SapGetCOAInfo(sheetObj, company, region, center, account, intercom, vvd);
                    	if (coa_seq == "" || coa_seq == "NO_DATA") {
                    		ComShowCodeMessage("COM132201", "Payment Account");
			    			break;
                    	} else {
                    		sheetObj.SetCellValue(Row, "pay_cd_cmb_seq",coa_seq);
                    	}*/
                    	break;		
                    default:
                        SetCellValue(Row, Col,aryPopupData[0][1]);
                        break;
                }
            }
        }
    }	
    /**
     * Setting supplier by popup
     */
    function setSupplier(aryPopupData) {
    	document.form.vndr_no.value=aryPopupData[0][1];
    	document.form.vndr_nm.value=aryPopupData[0][2];
    } 
    /**
     * initialize vendor name
     */ 
    function vndr_no_onchange() {
    	//document.form.vndr_nm.value = "";
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var vndr_no=formObj.vndr_no.value;
    	document.form.vndr_nm.value=SapGetSupplierName(sheetObj,vndr_no,"","" );
    }
    /**
     * Removing IBSheet Row
     **/
    function rowRemove(sheetObj){
    	ComRowHideDelete(sheetObj, "del_chk");
    }   
    
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}   
