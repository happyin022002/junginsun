/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_399.js
*@FileTitle  : NVOCC House B/L Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ESM_BKG_399 : business script for ESM_BKG_399
     */
    function ESM_BKG_0399() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    /* developer job	*/
    // common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var callback_func='';
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	// Event handler processing by button name
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_RowAdd":
					var nRow=sheetObject1.DataInsert(-1);
					sheetObject1.SetCellValue(nRow, "ofc_cd",formObject.ofc_cd.value,0);
					setCMInfo(sheetObject1.GetSelectRow());
				break;
				case "btn_Delete":
					//
					ComRowHideDelete(sheetObject1, "sel", true);
					//
					var sRow=sheetObject1.FindStatusRow("U|I|R");
					if(sRow == ''){
						sheetObject2.RemoveAll();
					}else{
						var arRow=sRow.split(";");
						var curIdx=arRow[arRow.length-2];
						sheetObject1.SelectCell(curIdx, 2, false);
						setCMInfo(curIdx);
					}					
				break;
				case "btn_RowAdd2":
					var pSeq=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "prof_seq");
					if(pSeq == '' || pSeq == ' '){
						if(confirm(ComGetMsg("BKG08010"))){
							doActionIBSheet(sheetObject1,formObject,IBSAVE) ;
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						}else{
							return;
						}
					}else{
						var nRow=sheetObject2.DataInsert(-1);
						sheetObject2.SetCellValue(nRow, "ofc_cd",formObject.ofc_cd.value,0);
						sheetObject2.SetCellValue(nRow, "prof_seq",pSeq,0);
					}
					ComRenumberSeq(sheetObject2, "seq");
				break;
				case "btn_Delete2":
					ComRowHideDelete(sheetObject2, "sel");
					ComRenumberSeq(sheetObject2, "seq");
				break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				case "btn_New":
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
				break;
				case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE) ;
				break;
			    case "btn_CheckSelect":
					// target
					var rd_target='';
					var rdObj=formObject.rd_target;
					for(rn=0;rn<rdObj.length;rn++){
						if(rdObj[rn].checked) rd_target=rdObj[rn].value;
					}
					// Customer Grid
					var rnarr=ComFindText(sheetObject1, "sel", 1);
					var cstm_arr=new Array(0);
					if(rnarr.length == 0){
						//ComShowMessage(ComGetMsg("BKG00733"));
						//return;
					}else if(rnarr.length == 1){
						cstm_arr.push(chekcSpecialValue(sheetObject1.GetCellValue(rnarr[0], "act_shpr_nm")));
						cstm_arr.push(chekcSpecialValue(sheetObject1.GetCellValue(rnarr[0], "act_shpr_addr")));
						cstm_arr.push(chekcSpecialValue(sheetObject1.GetCellValue(rnarr[0], "ulti_cnee_nm")));
						cstm_arr.push(chekcSpecialValue(sheetObject1.GetCellValue(rnarr[0], "ulti_cnee_addr")));
					}else{
						ComShowMessage(ComGetMsg("BKG00733"));
						return;
					}
					// Description for Customs
					var rxarr=ComFindText(sheetObject2, "sel", 1);
					var desc_cstm_arr=new Array(rxarr.length);
					for(rx=0;rx<rxarr.length;rx++){
						var arr=ComGetRowData(sheetObject2, rxarr[rx], "cstms_desc,hamo_trf_cd");
						desc_cstm_arr[rx]=arr;
					}
					var localopener = (opener || parent);
					if(callback_func != ''){
						eval('localopener.'+callback_func)(rd_target, cstm_arr, desc_cstm_arr);
					}
				//break;
				case "btn_Close":
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
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
		// search init-data
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
		axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListenerForm('change', 'form1_change', document.form);
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
        with(sheetObj){

			var HeadTitle1="|Sel.|Seq.|Office|ProfSeq.|Shipper Name|Shipper Address|Consignee Name|Consignee Address|Reference";
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
			{Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd" },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"prof_seq" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:70, AcceptKeys:"E|N", InputCaseSensitive:1  },
			{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:105, AcceptKeys:"E|N", InputCaseSensitive:1  },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ulti_cnee_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, AcceptKeys:"E|N", InputCaseSensitive:1  },
			{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ulti_cnee_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 , AcceptKeys:"E|N", InputCaseSensitive:1 },
			{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
			 
			InitColumns(cols);
			
			SetEditable(1);
			SetAutoRowHeight(0);
            SetSheetHeight(200);
			}
			break;
        	
        case 2:      //sheet1 init
			with(sheetObj){
			
			var HeadTitle1="|Sel.|Seq.|Office|ProfSeq.|SubSeq.|Description for Customs|HTS Code|HTS Code";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"DummyCheck", Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
			{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd" },
			{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prof_seq" },
			{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prof_sub_seq" },
			{Type:"Text",      Hidden:0,  Width:470,  Align:"Left",    ColMerge:0,   SaveName:"cstms_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
			{Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"HTCPop" } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetShowButtonImage(2);
			SetAutoRowHeight(0);
			SetSheetHeight(100);
			}
			break;

        }
    }
 // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      // retrieving
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					ComOpenWait(true); 
 					var rXml=sheetObj.GetSearchData("ESM_BKG_0399GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
                    var arrXml=rXml.split("|$$|");
                    //alert("xml count : " + arrXml.length);
					if(arrXml.length==2){
						var custTmpltXml=arrXml[0];
						var cmTmpltXml=arrXml[1];
						// CM Container Info
						sheetObjects[0].LoadSearchData(custTmpltXml,{Sync:1} );
						// CM Cntr MF Info
						sheetObjects[1].LoadSearchData(cmTmpltXml,{Sync:1} );
						// filtering
						if(sheetObjects[0].GetTotalRows()> 0){
							setCMInfo(1);
						}
						ComOpenWait(false); 
					}else{
						//alert("SEARCH xml : " + arrXml.length);
						return;
					}
				}
			break;
			case IBSAVE:        // saving
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true); 
					formObj.f_cmd.value=MULTI;
					// form param
					var sParam=FormQueryString(formObj);
					// Sheet1 param
					var sParamSheet1=sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}
					// Sheet2 param
					var sParamSheet2=sheetObjects[1].GetSaveString();
					if (sParamSheet2 != "") {
						sParam=sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
					}
					// return xML
 					var rXml=sheetObj.GetSaveData("ESM_BKG_0399GS.do", sParam);
					var rMsg=ComResultMessage(rXml);
					ComOpenWait(false); 
					if(rMsg == ''){
						sheetObjects[0].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
 						sheetObjects[1].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						/* OK Message */
						//ComShowMessage(ComGetMsg("BKG00166"));
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
					}
				}
			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case IBSEARCH:      // retrieving
				if(formObj.shpr_nm.value == '' && formObj.cnee_nm.value == ''){
					ComShowMessage(ComGetMsg("BKG00804"));
					return false;
				}
			break;
			case IBSAVE:      //조회
				if(formObj.ofc_cd.value == ''){
					ComShowMessage(ComGetMsg("BKG00806"));
					return false;
				}
				//
				var rcnt=sheetObjects[0].RowCount();
				var isChekcSpecialValue = false;
				for (rn=1; rn <= rcnt; rn++) {
					if(sheetObjects[0].GetCellValue(rn, "act_shpr_nm") == '' || sheetObjects[0].GetCellValue(rn, "ulti_cnee_nm") == ''){
						 ComShowMessage(ComGetMsg("BKG00888", "[SHPR_NM or CNEE_NM]"));
						 return false;
					}
					if(sheetObjects[0].GetCellValue(rn, "act_shpr_nm").length != chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "act_shpr_nm")).length
							||sheetObjects[0].GetCellValue(rn, "act_shpr_addr").length != chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "act_shpr_addr")).length
							||sheetObjects[0].GetCellValue(rn, "ulti_cnee_nm").length != chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "ulti_cnee_nm")).length
							||sheetObjects[0].GetCellValue(rn, "ulti_cnee_addr").length != chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "ulti_cnee_addr")).length){
						isChekcSpecialValue = true;
					}
				}
				
				if(isChekcSpecialValue){
					for (rn=1; rn <= rcnt; rn++) {
						if(sheetObjects[0].GetCellValue(rn, "act_shpr_nm").length != chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "act_shpr_nm")).length){
							sheetObjects[0].SetCellValue(rn, "act_shpr_nm", chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "act_shpr_nm")), 0);
						}
						if(sheetObjects[0].GetCellValue(rn, "act_shpr_addr").length != chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "act_shpr_addr")).length){
							sheetObjects[0].SetCellValue(rn, "act_shpr_addr", chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "act_shpr_addr")), 0);
						}
						if(sheetObjects[0].GetCellValue(rn, "ulti_cnee_nm").length != chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "ulti_cnee_nm")).length){
							sheetObjects[0].SetCellValue(rn, "ulti_cnee_nm", chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "ulti_cnee_nm")), 0);
						}
						if(sheetObjects[0].GetCellValue(rn, "ulti_cnee_addr").length != chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "ulti_cnee_addr")).length){
							sheetObjects[0].SetCellValue(rn, "ulti_cnee_addr", chekcSpecialValue(sheetObjects[0].GetCellValue(rn, "ulti_cnee_addr")), 0);
						}
					}
				}
				var xcnt=sheetObjects[1].RowCount();
				for (xn=1; xn <= xcnt; xn++) {
					if(sheetObjects[1].GetCellValue(xn, "cstms_desc") == ''){
						 ComShowMessage(ComGetMsg("BKG00888", "[CSTMS_DESC]"));
						 return false;
					}
				}
			break;
		}
        return true;
    }
	/* --------------------------------------------------------------------
	 * Process Event 
	 ---------------------------------------------------------------------- */
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}
    function form1_blur(){
		//ComChkObjValid(event.srcElement);
    }
	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//ComKeyEnter("search");
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
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){              
                	event.keyCode=keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}			
	}
    function form1_change(){
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
    }
	function sheet1_OnClick(sheetObj, row, col, val) {
		setCMInfo(row);
        var col_name=sheetObj.ColSaveName(col);
		if(col_name == "act_shpr_nm") {
//			ComShowBkgMemoPad(sheetObj, row, col, false, 400, 200, 70, false, "");
			ComShowBkgMemoPad(sheetObj, row, col, false, 300, 200, 70, false, "");
		}else 
		if(col_name == "act_shpr_addr") {
//			ComShowBkgMemoPad(sheetObj, row, col, false, 400, 200, 105, false, "");
			ComShowBkgMemoPad(sheetObj, row, col, false, 300, 200, 105, false, "");
		}else 
		if(col_name == "ulti_cnee_nm") {
//			ComShowBkgMemoPad(sheetObj, row, col, false, 400, 200, 70, false, "");
			ComShowBkgMemoPad(sheetObj, row, col, false, 300, 200, 70, false, "");
		}else 
		if(col_name == "ulti_cnee_addr") {
//			ComShowBkgMemoPad(sheetObj, row, col, false, 400, 200, 105, false, "");
			ComShowBkgMemoPad(sheetObj, row, col, false, 300, 200, 105, false, "");
		}
	}
	function sheet1_OnChange(sheetObj, row, col, val){
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
	}
	function sheet2_OnPopupClick(sheetObj, row, col){
		var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "HTCPop":
				//var hts_cd = sheetObj.CellValue(row, "hamo_trf_cd");
				//var url = "ESM_BKG_0607.do?hamo_trf_cd="+hts_cd;
				//ComOpenWindowCenter(url, "ESM_BKG_0607" , 1024, 530, false);
				comBkgCallPop0607("callBackHTSCode", 'T', sheetObj.GetCellValue(row, "hamo_trf_cd"));
			break;
		} // end switch
	}
	function sheet2_OnChange(sheetObj, row, col, val){
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
	}
	function sheet2_OnAfterEdit(sheetObj, Row, Col){
        var col_name=sheetObj.ColSaveName(Col);
		switch(col_name) {
			case "cstms_desc":
				var str = sheetObj.GetCellValue(Row, col_name);
				sheetObj.SetCellValue(Row, col_name, chekcSpecialValue(str), 0);
			break;
		}
	}
	
	/* --------------------------------------------------------------------
	 * User Defained Functions
	 ---------------------------------------------------------------------- */
	function setCMInfo(row){
		//alert(row + ". BkgNo : " + sheetObjects[0].CellValue(row, "bkg_no"));
		if(row > 0) {
			// retrieve CM
			ComShowAndHideSheet(sheetObjects[1], "prof_seq", sheetObjects[0].GetCellValue(row, "prof_seq"));
			ComRenumberSeq(sheetObjects[1], "seq");
		}
	}
	function callBackHTSCode(aryPopupData) {
		//alert(aryPopupData);
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "hamo_trf_cd",aryPopupData[0][3],0);
	}


	/* end developer job*/
