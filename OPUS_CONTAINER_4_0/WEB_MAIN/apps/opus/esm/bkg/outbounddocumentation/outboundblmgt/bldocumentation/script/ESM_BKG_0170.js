/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0170.js
*@FileTitle  : Container Copy And Move
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // Common global variable
    var sheetObjects = new Array();
    var sheetCnt = 0;
	var before_edit_val = '';
	var callback_func = '';

    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
         /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
				break;
                case "btn_Del":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
				break;
				case "radio_gubun":
					//var sheetObj = sheetObjects[0];
					//if(sheetObj.RowCount > 0){
					//	if(event.srcElement.value == 'C'){
					//		sheetObj.CellEditable(1, "tgt_cntr_vol") = true; 
					//	}else{
					//		sheetObj.CellValue2(1, "tgt_cntr_vol") = 0;
					//		sheetObj.CellEditable(1, "tgt_cntr_vol") = false; 
					//	}
					//}
					//
					if(ComGetEvent("value") == 'M'){
						formObject.cntr_vol.value=0;
						formObject.cntr_vol.readOnly=true;
					}else{
						formObject.cntr_vol.readOnly=false;
					}
					// calculate
					calculateVolumn();
				    break;
                case "btn_Apply":
					//alert("isCopy ? " + formObject.radio_gubun[0].checked);
					var rvol=0;
					var rcopy='';
					var rflag=false;
					if(formObject.radio_gubun[0].checked){
                        rvol=formObject.cntr_vol.value;//sheetObject1.GetCellValue(1, "tgt_cntr_vol");
						rcopy='C';
						rflag=doActionIBSheet(sheetObject1,formObject,MULTI01);
					}else{
						rcopy='M';
                    	rflag=doActionIBSheet(sheetObject1,formObject,MULTI02);
					}
					if(!rflag) return false;
					if(callback_func != ''){
                        if (ComFuncCheck("opener." + callback_func)) ComFunc(rcopy, rvol);
                        else if (ComFuncCheck("parent." + callback_func)) ComFunc(rcopy, rvol);
					}					
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
            //khlee- Preferences change the name of the function to start
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee- The final configuration functions added
            ComEndConfigSheet(sheetObjects[i]);
        }
        //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        //add listener
		axon_event.addListenerForm('change', 'form1_change', document.form);
		// initialize 
		var cntr_vol=document.form.cntr_vol.value;
		document.form.cntr_vol.value=ComAddComma3(cntr_vol, "#,###.00");
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
                    var HeadTitle1="|Sel.|Target Booking No.|Vol.|Org";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
                                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"tgt_bkg_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"tgt_cntr_vol",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:1, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"origin_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
                    
                    InitColumns(cols);
                    SetEditable(1);
                    SetSheetHeight(122);
                }
			break;
        }
    }
  // Sheet handling process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case MULTI01:      // copy
			case MULTI02:      // move
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=sAction;
					//sheetObj.DoSave("ESM_BKG_0170GS.do", FormQueryString(formObj));
 					var rXml=sheetObj.GetSaveData("ESM_BKG_0170GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString());
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
						/* Transaction state initialization */
						sheetObj.LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						// show message
						var cstms_download=ComGetEtcData(rXml, "USA_CSTMS_DOWNLOAD");
						if(cstms_download == 'true'){
							ComShowMessage(ComGetMsg("BKG00166") + '\n\n' + ComGetMsg("BKG00087"));
						}else{
							ComShowMessage(ComGetMsg("BKG00166"));
						}
					} else {
						ComShowMessage(rMsg);
						return false;
					}		
				}else{
					return false;
				}
			break;
			case IBINSERT:     
				var newRow=sheetObj.DataInsert(-1);
				if(formObj.radio_gubun[1].checked){
					sheetObj.SetCellValue(newRow, "tgt_cntr_vol",formObj.cntr_vol.value,0);
					// calculate
					calculateVolumn();
				}
			break;
			case IBDELETE:      
				//ComRowHideDelete(sheetObj, "sel");
				ComRowDeleteComplete(sheetObj, "sel", 1);
			break;
        }
		return true;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case MULTI01:      // copy
			case MULTI02:      // move
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00183"));
						return false;
					}
					if(ComIsEmpty(cntr_no.value)){
						ComShowMessage(ComGetMsg("BKG00753"));
						return false;
					}					
					var par_sum=ComColumnSum(sheetObj, "tgt_cntr_vol") + BkgParseFloat(cntr_vol.value);
					if(par_sum <= 0 || par_sum > 1){
						ComShowMessage(ComGetMsg("BKG08129", par_sum));
						return false;
					}
				}
				if(sheetObj.RowCount()< 1){
					return false;
				}
				// check SheetData
				var initRow=1;
				for(rn=initRow ;rn<=sheetObj.LastRow();rn++){
                    if(ComIsEmpty(sheetObj.GetCellValue(rn, "tgt_bkg_no"))){
						ComShowMessage(ComGetMsg("BKG00183"));
						return false;
					}
                    if(sheetObj.GetCellValue(rn, "tgt_cntr_vol") <= 0 || sheetObj.GetCellValue(rn, "tgt_cntr_vol") > 1){
						ComShowMessage(ComGetMsg("BKG08013"));
						return false;
					}
				}
			break;
        }
        return true;
    }
	/* --------------------------------------------------------------------
	 * Event Processing
	 ---------------------------------------------------------------------- */
	function sheet1_OnBeforeEdit(sheetObj, row, col, val) {
		//alert("OnBeforeEdit -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col));
        before_edit_val=sheetObj.GetCellValue(row, col);
	}
	function sheet1_OnChange(sheetObj, row, col, val){
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
            sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase());
		}
		var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "sel":
				//sheetObj.RowStatus(row) = (val == 1) ? 'I' : 'R';
			break;
			case "tgt_cntr_vol":
				if(val <= 0 || val > 1){
					ComShowMessage(ComGetMsg("BKG08013"));
					sheetObj.SetCellValue(row, col,before_edit_val);
					sheetObj.SelectCell(row, col);
					return false;
				}
				// calculate
				calculateVolumn();
			break;		
		}
	}
    function form1_change(){
        var srcName=ComGetEvent("name");
        switch(srcName){
            case "cntr_vol":
				var vol=BkgParseFloat(ComGetEvent("value"));
				if(vol <0 || vol >= 1){
					ComShowMessage(ComGetMsg("BKG08013"));
					ComGetEvent().select();
					return false;
				}
				// calculate
				calculateVolumn();
            break;
        }
    }
	function calculateVolumn(){
		//alert("Copy ? " + document.form.radio_gubun[0].checked);
		var sum_vol=ComColumnSum(sheetObjects[0], "tgt_cntr_vol") + BkgParseFloat(document.form.cntr_vol.value);
		//alert("sum_vol : " + sum_vol);
		sum_vol=Math.round(sum_vol*100)/100;
		//alert("sum_vol : " + sum_vol);
		document.getElementById("td_sum_vol").value=ComAddComma3(''+sum_vol, "#,###.00");
	}
