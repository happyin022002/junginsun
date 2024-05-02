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
                
	             var HeadTitle1="|Sel.|Seq|Country Code|Conditions|Conditions|Conditions|Conditions|Clause|User ID|Update Date";
	             var HeadTitle2="|Sel.|Seq|Country Code|POR|POL|POD|DEL|Clause|User ID|Update Date";
	
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	             InitHeaders(headers, info);
	             
	             var cols = [ 
	                 {Type:"Status",		Hidden:1, Width:20,   Align:"Center",	ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"DummyCheck",	Hidden:0, Width:30,   Align:"Center",	ColMerge:0,   SaveName:"sel" },
		             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"itm_seq" },
	                 {Type:"Text",			Hidden:0, Width:100,  Align:"Center",	ColMerge:0,   SaveName:"org_cnt_cd",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
	                 {Type:"CheckBox",		Hidden:0, Width:80,   Align:"Center",	ColMerge:0,   SaveName:"por_appl_flg",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:""},
	                 {Type:"CheckBox",		Hidden:0, Width:80,   Align:"Center",	ColMerge:0,   SaveName:"pol_appl_flg",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:""},
	                 {Type:"CheckBox",		Hidden:0, Width:80,   Align:"Center",	ColMerge:0,   SaveName:"pod_appl_flg",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:""},
	                 {Type:"CheckBox",		Hidden:0, Width:80,   Align:"Center",	ColMerge:0,   SaveName:"del_appl_flg",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:""},
	                 {Type:"Text",			Hidden:0, Width:395,  Align:"Left",		ColMerge:0,   SaveName:"cmdt_desc",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:4000,  MultiLineText:1, InputCaseSensitive:1},
		             {Type:"Text",			Hidden:0, Width:100,  Align:"Center",	ColMerge:0,   SaveName:"upd_usr_id",	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",			Hidden:0, Width:120,    Align:"Center",	ColMerge:0,   SaveName:"upd_dt",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		             ]; 
	             InitColumns(cols);
	             SetSheetHeight(520);
	             SetHighlightAfterSort(0);
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
					sheetObj.DoSearch("ESM_BKG_1606GS.do", FormQueryString(formObj) );
					// checking whether data is changed
					formObj.dirty_flag.value='N';
				}
			break;
			case IBSAVE:        //
				if(validateForm(sheetObj,formObj,sAction)) {
					
					formObj.f_cmd.value=MULTI;
					var sParam="f_cmd=" + formObj.f_cmd.value + "&" + sheetObj.GetSaveString();
					var rXml=sheetObj.GetSaveData("ESM_BKG_1606GS.do", sParam);
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
						sheetObj.LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						// show message
						ComShowMessage(ComGetMsg("BKG00166"));
						// checking whether data is changed
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					} else {
						ComShowMessage(rMsg);
						return false;
					}
                }else{
					return false;					
				}
			break;
			case IBINSERT:      //INSERT
				var newRow=sheetObj.DataInsert(-1);
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
				for(ix=idxArr.length-1;0<=ix;ix--){
					if(idxArr[ix] == '') continue;
					sheetObj.SetRowHidden(idxArr[ix],1);
					sheetObj.SetRowStatus(idxArr[ix],'D');
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
				
				var rowCount=sheetObj.RowCount();
								
				for(var i=rIdx ; i < rIdx + rCnt ; i++ ){
					if(sheetObj.GetCellValue(i, "org_cnt_cd")==""){
						ComShowMessage(ComGetMsg("BKG00545", "Country Code"));
						sheetObj.SelectCell(i, "org_cnt_cd");
						return false;
					}else if(sheetObj.GetCellValue(i, "org_cnt_cd").length==1){
						ComShowMessage(ComGetMsg("BKG06012", "Country Code"));
						sheetObj.SelectCell(i, "org_cnt_cd");
						return false;
					}
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

		// checking whether data is changed
		document.form.dirty_flag.value='Y';
		var data_type=sheetObj.GetCellProperty(row, col, "type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
		
	}
