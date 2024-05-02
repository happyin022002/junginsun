/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4104.jsp
*@FileTitle  : DEM/DET Payer Info & Fax/E-mail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var ROWMARK="|";
	var FIELDMARK="=";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		/***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
	    		case "btn_rowadd":
		        	if(ComIsBtnEnable(srcName)) {
		        		doActionIBSheet(sheetObject1,formObject,IBINSERT);
		        	}
				break;
				
//	    		case "btn_rowcopy":
//		        	if(ComIsBtnEnable(srcName)) {
//		        		doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
//		        	}
//					break;
				case "btn_rowdel":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
				break;
				
				case "btn2_save":
					if(ComIsBtnEnable(srcName)) {
		        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
		        			ComShowCodeMessage("DMT01145", "Save");
		        			return;
		        		}
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
				break;
				
                case "btn2_new":
                	initControl();
                break;
                
                case "btn2_close":
                	unLoadPage();
                	ComClosePopup();
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
	 * IBCombo Object set to an array
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
    	var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
     
        initControl();
    }
    
	/**
   	 * Initializing Combo 
   	 * param : comboObj , comboNo
   	 *  adding case as numbers of counting Combos
   	 * 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form;
   	    switch(comboObj.options.id) {  
   	    	case "payer_name": 
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(0);
					SetColAlign(0, "0");
					SetColAlign(0, "1");
					SetColAlign(0, "2");
					SetDropHeight(160);
  					SetMaxLength(45);
   		    	}
   	    		doActionIBCombo(sheetObjects[1],formObj,IBSEARCH,SEARCHLIST01,"PAYER_NAME",comboObj);
   				break; 
   	    	case "payer_addr":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(0);
					//SetColAlign("left|left");        
					//SetColWidth("130|600");
					SetColAlign(0, "0");
					SetColAlign(0, "1");
					SetColAlign(0, "2");
					SetColAlign(0, "3");
					SetDropHeight(160);
   		    	}
   	    		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH,SEARCHLIST02, "PAYER_ADDR",comboObj);
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
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
            	    var HeadTitle="|Seq.|ATTN|Tel.|Fax|E-mail|Sheet|cust_cntc_pnt_seq";
            	    var headCount=ComCountHeadTitle(HeadTitle);
            	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
            	    var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	    var headers=[ { Text:HeadTitle, Align:"Center"} ];
            	    InitHeaders(headers, info);
            	    var cols=[ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	    {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
            	    {Type:"ComboEdit", Hidden:0, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:45 },
            	    {Type:"ComboEdit", Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_phn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	    {Type:"ComboEdit", Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_fax_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	    {Type:"ComboEdit", Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"payr_cntc_pnt_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
            	    {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sheet",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	    {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cntc_pnt_seq" } ];
            	    InitColumns(cols);
            	    SetEditable(1);
            	    SetEllipsis(1);
            	    SetSheetHeight(142);
                }
                break;
             case 2:
             	with (sheetObj) {
            	 	SetVisible(false);
                 }
                 break;
        }
    }
    /**
     * 예)doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST01,"PAYER_NAME",comboObj);	//Multi combo
     *    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST03,"PAYER_CNTC_PNT_NM");		//Grid combo
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @param sComboAction
     * @param sComboKey
     * @param sObj
     * @return
     */
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
    	sheetObj.ShowDebugMsg(false);
    	sheetObj.SetWaitImageVisible(0);
    	var formObj=document.form;
    	switch(sAction) {
    		case IBSEARCH:
    			if (sheetObj.id == "sheet2") {
					//3.After handling Retrieving results
					var comboDatas;
					var comboItems;
    				switch(sComboAction) {
						case SEARCHLIST01:	//PAYR_NAME LIST
		    				//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
							//2.retrievie according to conditions					
							var sXml=sheetObj.GetSearchData("EES_DMT_4104GS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem(sObj,comboItems);						
						break;
						
						case SEARCHLIST02:	//PAYR_ADDRESS LIST
		    				//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, SEARCHLIST02);
							//2.retrievie according to conditions					
							var sXml=sheetObj.GetSearchData("EES_DMT_4104GS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem2(sObj,comboItems);						
						break;	
    				}
    			}
    			else if (sheetObj.id == "sheet1") {
					//3.After handling Retrieving results
					var comboDatas;
					var comboItems;
    				switch(sComboAction) {
						case SEARCHLIST03:	//ATTN	
		    				//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, SEARCHLIST03);
							//2.retrievie according to conditions					
							var sXml=sheetObj.GetSearchData("EES_DMT_4104GS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							addCellComboItem(sheetObj,comboDatas,"payr_cntc_pnt_nm");
						break;
						
						case SEARCHLIST04:	//TEL
		    				//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, SEARCHLIST04);
							//2.retrievie according to conditions					
							var sXml=sheetObj.GetSearchData("EES_DMT_4104GS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							addCellComboItem(sheetObj,comboDatas,"payr_cntc_pnt_phn_no");
						break;

						case SEARCHLIST05:	//FAX
		    				//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, SEARCHLIST05);
							//2.retrievie according to conditions					
							var sXml=sheetObj.GetSearchData("EES_DMT_4104GS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							addCellComboItem(sheetObj,comboDatas,"payr_cntc_pnt_fax_no");
						break;
						
						case SEARCHLIST06:	//EMAIL
		    				//1.Setting parametor condition, before retrieving
							ComSetObjValue(formObj.f_cmd, SEARCHLIST06);
							//2.retrievie according to conditions					
							var sXml=sheetObj.GetSearchData("EES_DMT_4104GS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							addCellComboItem(sheetObj,comboDatas,"payr_cntc_pnt_eml");
						break;
    				}
    			}
    		break;
    	}
    	sheetObj.SetWaitImageVisible(1);
    }
	/**
     * Data in the field adds a combo.
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[2]);	
    	}   		
	}
	/**
     * Data in the field adds a combo.
     */	
	function addComboItem1(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[1]);
    	}   		
	}
	function addComboItem2(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[2]);
    	}   		
	}
	/**
	 * Grid Data in the field adds a combo.
	 * @param sheetObj		SHEET
	 * @param comboDatas	ETCDATA
	 * @param colName		
	 * @return
	 */
	function addCellComboItem(sheetObj,comboDatas, colName){
		var comboTxt="";
		var comboVal="";
		var tempVal="";
		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
			comboItems=comboDatas.split(ROWMARK);
			for (var i=0 ; i < comboItems.length ; i++) {
				comboItem=comboItems[i].split(FIELDMARK);//data space,space,space
				if (comboItem[0] == undefined || comboItem[0] == ""){
					comboTxt += " \t \t";
					comboVal += " ";
				}else{
					comboTxt += comboItem[0] + "\t" + comboItem[1] + "\t" + comboItem[2];
					comboVal += comboItem[2];
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}
			}
		}else{
			comboTxt += " \t \t";
			comboVal += " ";
		}
		
		sheetObj.SetColProperty(colName, {ComboText:comboTxt , ComboCode:comboVal, ShowCol:2} );
	}
	
	//Payer  event
	function payer_addr_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		ComSetObjValue(dmdt_payr_addr, comboObj.GetSelectCode());
	}
	// Process of SheetS
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					if (validateForm(sheetObj,formObj,sAction)) {

	 					//조회를 동기방식으로 전환함. 2014.08.25
	 					//sheetObj.DoSearch("EES_DMT_4104GS.do", FormQueryString(formObj));
	 					var sXml = sheetObj.GetSearchData("EES_DMT_4104GS.do", FormQueryString(formObj));
	 					if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});
						
						ComEtcDataToForm(formObj, sheetObj);
						//DEFALUT CHECK - SHEET, SEND(ATTN, TEL, FAX, E-MAIL
						var attn=ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm);
						var tel=ComGetObjValue(formObj.dmdt_payr_phn_no);
						var fax=ComGetObjValue(formObj.dmdt_payr_fax_no);
						var email=ComGetObjValue(formObj.dmdt_payr_n1st_eml);
						// Values ??passed in front of the screen
						var p_attn=ComGetObjValue(formObj.s_attn);
						var p_tel=ComGetObjValue(formObj.s_telno);
						var p_fax=ComGetObjValue(formObj.s_faxno);
						var p_email=ComGetObjValue(formObj.s_email);
						var checkOk=false;
						for(var i=1; i < sheetObj.GetTotalRows()+1 ; i++) {
							if(p_attn == sheetObj.GetCellValue(i, "payr_cntc_pnt_nm")
								&& p_tel == sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no")
								&& p_fax == sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no")
								&& p_email == sheetObj.GetCellValue(i, "payr_cntc_pnt_eml")) {
								sheetObj.SetCellValue(i, "sheet",1,0);
								//sheetObj.CellValue2(i, "send") = 1;
								checkOk=true;
								break;
							}
						}
						if(!checkOk) {
							for(var i=1; i < sheetObj.GetTotalRows()+1 ; i++) {
								if(attn == sheetObj.GetCellValue(i, "payr_cntc_pnt_nm")
									&& tel == sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no")
									&& fax == sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no")
									&& email == sheetObj.GetCellValue(i, "payr_cntc_pnt_eml")) {
									sheetObj.SetCellValue(i, "sheet",1,0);
									//sheetObj.CellValue2(i, "send") = 1;
									break;
								}
							}
						}
					}
				}
			break;
			
        	case IBINSERT:	//Row Add
				if (sheetObj.id == "sheet1") { 
					sheetObj.DataInsert(-1);
					//sheetObj.CellValue2(sheetObj.SelectRow, "send") = 1;
				}        		
        	break;
        	
//			case IBCOPYROW:	//Row Copy
//				if (sheetObj.id == "sheet1") {
//					var row = sheetObj.DataCopy();
//					sheetObj.CellValue(row, "sheet") 	= "0";
//					sheetObj.CellValue(row, "send") 	= "0";
//					sheetObj.RowStatus(row) = "I";
//				} 
//				break;
			case IBDELETE:	//Row Delete
				if (sheetObj.id == "sheet1") {
					if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet") == "1") {
						ComShowCodeMessage("DMT00187");
						return;
					}
					if (sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == 'I') {
						sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
					}
					else {
						sheetObj.SetRowStatus(sheetObj.GetSelectRow(),'D');
						sheetObj.SetRowHidden(sheetObj.GetSelectRow(), 1);
					}
				}
			break;
			
			case IBSAVE:
				ComSetObjValue(formObj.f_cmd, MULTI);
				setParameters(MULTI);
				if(!validateForm(sheetObj,formObj,sAction)) return;
				var attn="";
				var tel="";
				var fax="";
				var email="";
				for(var i=1; i< sheetObj.RowCount()+1; i++ ){
					if(sheetObj.GetCellValue(i, "sheet") == "1") {
						attn=sheetObj.GetCellValue(i, "payr_cntc_pnt_nm");
						tel=sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no");
						fax=sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no");
						email=sheetObj.GetCellValue(i, "payr_cntc_pnt_eml");
						break;
					}
				}
				ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, attn);
				ComSetObjValue(formObj.dmdt_payr_phn_no, tel);
				ComSetObjValue(formObj.dmdt_payr_fax_no, fax);
				ComSetObjValue(formObj.dmdt_payr_n1st_eml, email);
				//var send_check = new Array();
				//for(var i = 1; i< sheetObj.RowCount +1; i++ ){
				//	send_check[i-1] = sheetObj.CellValue(i, "send");
				//}
				var sParam1=sheetObj.GetSaveString(true);
				var sParam=sParam1 + "&"+FormQueryString(formObj);
                //ComOpenWait Start
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
				//sheetObj.DoAllSave("EES_DMT_4104GS.do", sParam, false);
                var sXml=sheetObj.GetSaveData("EES_DMT_4104GS.do", sParam);
				//3.Save and processing results
                sheetObj.LoadSaveData(sXml,{Sync:1});
                //ComOpenWait End
                ComOpenWait(false);
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				if(ComGetObjValue(formObj.success_yn) == "Y") {
					initControl();
					var attn=ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm);
					var tel=ComGetObjValue(formObj.dmdt_payr_phn_no);
					var fax=ComGetObjValue(formObj.dmdt_payr_fax_no);
					var email=ComGetObjValue(formObj.dmdt_payr_n1st_eml);
					for(var i=1; i < sheetObj.GetTotalRows()+1 ; i++) {
						if(attn == sheetObj.GetCellValue(i, "payr_cntc_pnt_nm")
							&& tel == sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no")
							&& fax == sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no")
							&& email == sheetObj.GetCellValue(i, "payr_cntc_pnt_eml")) {
							sheetObj.SetCellValue(i, "sheet",1,0);
							//sheetObj.CellValue2(i, "send") = 1;
							break;
						}
					}			
					//send setting
					//for(var i = 1; i < sheetObj.TotalRows+1 ; i++) {
					//	sheetObj.CellValue2(i, "send") = send_check[i - 1];
					//}
				}
			break;		
        }
    }
	/*
	 * Lookup fields to enter information on the screen is stored in a lookup field values.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		if(sAction == MULTI) {
			ComSetObjValue(formObj.dmdt_payr_nm, comboObjects[0].GetSelectText());
		}
	}
	/*
	 * initializing
	 */
	function initControl(){
		var formObj=document.form;
		//combo initializing
		comboObjects[0].SetSelectCode("-1");
        comboObjects[0].RemoveAll();
        comboObjects[1].SetSelectCode("-1");
        comboObjects[1].RemoveAll();
        doActionIBCombo(sheetObjects[0], formObj,IBSEARCH,SEARCHLIST03,"PAYER_CNTC_PNT_NM");
        doActionIBCombo(sheetObjects[0], formObj,IBSEARCH,SEARCHLIST04,"PAYER_PHN_NO");
        doActionIBCombo(sheetObjects[0], formObj,IBSEARCH,SEARCHLIST05,"PAYER_FAX_NO");
        doActionIBCombo(sheetObjects[0], formObj,IBSEARCH,SEARCHLIST06,"PAYER_EMAIL");
        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
	 	// IBMultiCombo initializing 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
        comboObjects[0].SetSelectText(ComGetObjValue(formObj.dmdt_payr_nm));
        comboObjects[1].SetSelectCode(ComGetObjValue(formObj.dmdt_payr_addr));
        //ofc_cd setting
        ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.s_ofc_cd));
//        for(var i = 1; i < sheetObjects[0].TotalRows+1 ; i++) {
//			if(sheetObjects[0].CellValue(i, "payr_cntc_pnt_fax_no") != ""  
//					|| sheetObjects[0].CellValue(i, "payr_cntc_pnt_eml") != "" 
//					) {
//				
//				sheetObjects[0].CellValue2(i, "send") = 1;
//			}
//		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSAVE:
    				//1. ATTN, TEL, FAX, EMAIL are same --> error
    				for( var i=1; i < sheetObj.RowCount()+ 1; i++) {
						var pnt_nm=sheetObj.GetCellValue(i, "payr_cntc_pnt_nm");
						var phn_no=sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no");
						var fax_no=sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no");
						var eml=sheetObj.GetCellValue(i, "payr_cntc_pnt_eml");
    					for( j=i+1 ; j < sheetObj.RowCount()+ 1 ; j++) {
							if(pnt_nm == sheetObj.GetCellValue(j, "payr_cntc_pnt_nm")
								&& phn_no == sheetObj.GetCellValue(j, "payr_cntc_pnt_phn_no")
								&& fax_no == sheetObj.GetCellValue(j, "payr_cntc_pnt_fax_no")
								&& eml    == sheetObj.GetCellValue(j, "payr_cntc_pnt_eml")
    									) {
    							ComShowCodeMessage("DMT00188", j);
    							return false;
    						}
    					}
    				}
    				//1. ATTN, TEL, FAX, EMAILare same --> error
//    				var dupRow = sheetObj.ColValueDup("payr_cntc_pnt_nm|payr_cntc_pnt_phn_no|payr_cntc_pnt_fax_no|payr_cntc_pnt_eml", false);
//    				
//    				if(dupRow != -1 ) {
//    					ComShowCodeMessage("DMT00188", dupRow);
//    					return false;
//    				}
    				//2. ADDR check
    				if(ComGetLenByByte(ComGetObjValue(formObj.dmdt_payr_addr)) > 100) {
    					ComShowCodeMessage("COM131901", "Address");
    					return false;
    				}
    				//3. ATTN, TEL, FAX, EMAIL are blank ,  skip save.
    				for( var i=1; i < sheetObj.RowCount()+ 1; i++) {
						if(sheetObj.GetCellValue(i, "payr_cntc_pnt_nm") == ""
							&& sheetObj.GetCellValue(i, "payr_cntc_pnt_phn_no") == ""
							&& sheetObj.GetCellValue(i, "payr_cntc_pnt_fax_no") == ""
							&& sheetObj.GetCellValue(i, "payr_cntc_pnt_eml") == ""
    							) {
							sheetObj.SetRowStatus(i,"R");
    					}
    				}
    				break;
    		}
        }		
        return true;
    }
	function unLoadPage() {
		if ( document.form.jspno.value == "EES_DMT_4002" ||
			document.form.jspno.value == "EES_DMT_3109" ||
			document.form.jspno.value == "EES_DMT_3108" ||
			document.form.jspno.value == "EES_DMT_4004" ||
			document.form.jspno.value == "EES_DMT_4011" ||
			document.form.jspno.value == "EES_DMT_4016-1"
		) {
     		if(document.form.success_yn.value == "Y") {
                
     			var opener=window.dialogArguments;
     			if (!opener) opener = parent;
                
                var rtnValFax="";
                var rtnValEmail="";
                var cntc_pnt_nm="";
                var cntc_pnt_seq="";
                var fax_cnt=0;
                var email_cnt=0;
                for ( var i=1 ; i < sheetObjects[0].RowCount()+1 ; i++ ) {
                	var cntc_fax_no=ComTrim(sheetObjects[0].GetCellValue( i ,  "payr_cntc_pnt_fax_no" ));
                	var cntr_email_no=ComTrim(sheetObjects[0].GetCellValue( i ,  "payr_cntc_pnt_eml" ));
             	   //email, fax setting
//                    if ( sheetObjects[0].CellValue( i , "send" ) == 1 ) {
//                        if(cntc_fax_no != "") {
//                     	   if(fax_cnt > 0) {
//                     		   rtnValFax +=";";
//                     	   }
//                        	   rtnValFax 	+= cntc_fax_no;
//                        	   fax_cnt++;
//                     	   //rtnValFax 	+= ";";
//                        }
//                        if(cntr_email_no != "") {
//                     	   if(email_cnt > 0) {
//                     		   rtnValEmail +=";";
//                     	   }
//                            rtnValEmail 	+= cntr_email_no;
//                            email_cnt++;
//                     	   //rtnValEmail 	+= ";";
//                        }
//                    }
                	if ( sheetObjects[0].GetCellValue( i , "sheet" ) == 1 ) {
                		cntc_pnt_nm=sheetObjects[0].GetCellValue( i , "payr_cntc_pnt_nm" );
                		cntc_pnt_seq=sheetObjects[0].GetCellValue( i , "cust_cntc_pnt_seq" );
                    }
                }
                opener.getPayerInfoData(rtnValFax, rtnValEmail, cntc_pnt_nm, cntc_pnt_seq);
     		}
         }
     }

