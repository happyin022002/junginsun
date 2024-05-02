/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ESM_BKG_1075.js
 *@FileTitle : Booking Receipt Notice And Draft B/L Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ESM_BKG_1075 : business script for ESM_BKG_1075 
     */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	document.onclick=processButtonClick;
    function processButtonClick(){
         /* */
		 var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrieve":
					if(formObject.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00254"))){
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				case "btn_rowadd":
					if(ComIsBtnEnable("btn_rowadd")){
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
					}
				break;																	
				case "btn_rowdel":
					if(ComIsBtnEnable("btn_rowdel")){
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
					}
				break;																																				
            } // end switch
    	}catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
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
			//initSheet
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
	}
	/**
	 * initializing initCombo 
	 */
	function initCombo(comboObj, comboNo) {
		var arrData=org_cnt_nm_str.split("|");
		var arrTemp=null;
		for (i=0;i<arrData.length;i++) {
			if(arrData[i] == ''){
				continue;
			}else{
				arrTemp=arrData[i].split("\t");
				comboObj.InsertItem(i, arrTemp[0]+"|"+arrTemp[1], arrTemp[0]);
			}
		}
		//comboObj.Code = "  ";
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
            case "sheet1":      //sheet1 init
                with(sheetObj){
                
	             var HeadTitle1="|Sel.|Item|BKG OFC|Customer Code|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Booking Receipt Notice (Cut-off Time)|Draft B/L|Draft B/L|Draft B/L|Draft B/L|Draft B/L";
	             var HeadTitle2="|Sel.|Item|BKG OFC|Customer Code|M'ty P/Up CY|Return CY|Port|Rail Receiving|Documentation|Customs|Remark(P.S)|Call Sign|MRN|CRN|Exchange Rate|Remark";
	
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	             InitHeaders(headers, info);
	             
	             var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sel" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"itm_seq" },
	                 {Type:"Text",      Hidden:0, Width:55,   Align:"Left",    ColMerge:1,   SaveName:"bkg_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:6, AcceptKeys:"E|N", InputCaseSensitive:1 },
	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:8, AcceptKeys:"E|N", InputCaseSensitive:1 },
	                 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_yd_flg",  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"full_rtn_yd_flg",  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"port_coff_flg",    KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rail_rcv_flg",     KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"doc_coff_flg",     KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_coff_flg",    KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:"rct_ntc_rmk",      KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:1300,  MultiLineText:1},
	                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"call_sgn_flg",     KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mrn_flg",          KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crn_flg",          KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"xch_rt_flg",       KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
	                 {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1300 } ];
	              
	             InitColumns(cols);
	             SetSheetHeight(420);
            }
            break;
        }
    }
  // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_BKG_1075GS.do", FormQueryString(formObj) );
					// checking whether data is changed
					formObj.dirty_flag.value='N';
				}
			break;
			case IBSAVE:        //
				if(validateForm(sheetObj,formObj,sAction)) {
					
					formObj.f_cmd.value=MULTI;
					//sheetObj.DoSave("ESM_BKG_1075GS.do", FormQueryString(formObj), -1, false, true);
					var sParam="f_cmd=7&" + sheetObj.GetSaveString();
					var rXml=sheetObj.GetSaveData("ESM_BKG_1075GS.do", sParam);
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
						sheetObj.LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						// show message
						ComShowMessage(ComGetMsg("BKG00166"));
						// checking whether data is changed
						formObj.dirty_flag.value='N';
					} else {
						ComShowMessage(rMsg);
						return false;
					}
					doActionIBSheet(sheetObj,formObj,IBSEARCH);    
                }else{
					return false;					
				}
			break;
			case IBINSERT:      //retrieve
				var newRow=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(newRow, "bkg_ofc_cd",formObj.bkg_ofc_cd.value,0);
				sheetObj.SetCellValue(newRow, "cust_cd",formObj.cust_cd.value,0);
				sheetObj.SetTotalRows(newRow - 1);
				formObj.dirty_flag.value='Y';
			break;
			case IBDELETE:        //
				var selRows=sheetObj.FindCheckedRow("sel");
				if(selRows == ''){
					ComShowMessage(ComGetMsg("COM12189"));
					return false;
				}
				var idxArr=selRows.split("|");
				for(ix=0;ix<idxArr.length;ix++){
					if(idxArr[ix] == '') continue;
					sheetObj.SetRowStatus(idxArr[ix],'D');
					sheetObj.SetRowHidden(idxArr[ix],1);
				}
				formObj.dirty_flag.value='Y';
			break;
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
				if(formObj.dirty_flag.value != 'Y'){
					ComShowMessage(ComGetMsg("BKG00737"));
					return false;
				}
				var rIdx=sheetObj.HeaderRows();
				var rCnt=sheetObj.RowCount();
				var bkg_ofc_cd='';
				var cust_cd='';
				for(ir=0 ;ir<rCnt ;ir++ ){
					bkg_ofc_cd=sheetObj.GetCellValue(rIdx, "bkg_ofc_cd");
					cust_cd=sheetObj.GetCellValue(rIdx, "cust_cd");
					if(ComIsEmpty(bkg_ofc_cd)){
						ComShowMessage(ComGetMsg("BKG00545", "BKG OFC"));
						sheetObj.SelectCell(rIdx, "bkg_ofc_cd");
						return false;
					}
					
					if(cust_cd != '' && cust_cd.length < 3){
						ComShowMessage(ComGetMsg("BKG00545", "CUST_CD"));
						sheetObj.SelectCell(rIdx, "cust_cd");
						return false;
					}
					
					if(cust_cd !='' && !ComIsNumber(cust_cd.substr(2,6))){
						ComShowMessage(ComGetMsg("BKG00458"));
						return false;
					}
					
					rIdx++;
				}
			break;
        }
        return true;
    }
	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//number + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//number + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//number
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//number+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//capital English
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//number+capital English
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//capital English + number + space
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){
                	event.keyCode=keyValue + 65 - 97;
				}
			break;
		}	
	}

	function sheet1_OnChange(sheetObj, row, col, val) {
		with (sheetObj) {
			switch (ColSaveName(col)) {
				case "rct_ntc_rmk":
					
					val = rdParameterErrorCheckStr(val);
					
	        		var arrVal = val.split("\n");
	        		var strVal = "";
	        		if (arrVal.length > 0) {
	        	        for (var i=0; i < arrVal.length; i++) {
	        	          	var cnt = Math.ceil(arrVal[i].length / 70);
	        	            if (cnt > 1) {
	        	            	for (var j=0; j < cnt; j++) {
	        		            	strVal = strVal + arrVal[i].substring((j*70),(j*70)+70) + "\n";
	        	            	}
	        	            }else{
	        	            	if (arrVal[i].length > 0) strVal = strVal + arrVal[i] + "\n";
	        	            }
	        	        }
	        		}
	        		sheetObj.SetCellValue(row, col, strVal.trim(), 0);
        		break;
			}
		}
		// checking whether data is changed
		document.form.dirty_flag.value='Y';
		var data_type=sheetObj.GetCellProperty(row, col, "type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
		
	}
