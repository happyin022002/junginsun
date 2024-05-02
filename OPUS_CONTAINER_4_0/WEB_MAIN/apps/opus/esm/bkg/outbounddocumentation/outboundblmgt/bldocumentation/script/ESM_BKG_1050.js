/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1050.js
*@FileTitle  : Container Vol. Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// public variable
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var callback_func = '';
	var before_edit_val = '';
	
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		 var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Ok":
					var rflag=doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    if(rflag)  ComClosePopup(); 
                break;																				
				case "btn_close":
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
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }
		// init data
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		// add listener
    }
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
                    var HeadTitle1="|Cntr No.|Booking No.|Vol.|Container Vol.|Container Vol.|S/O|Special CGO";
                    var HeadTitle2="|Cntr No.|Booking No.|Vol.|Current|Adjusted|S/O|Special CGO";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                                    { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bkg_vol",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"adj_vol_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"spcl_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"so_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetSheetHeight(240);
                }
			    break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
                    //sheetObj.DoSearch("ESM_BKG_1051GS.do", FormQueryString(formObj));
                     var rXml=sheetObj.GetSearchData("ESM_BKG_1050GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return false;
					if(rXml.substring(1, 6) == "ERROR"){
						ComShowMessage(ComResultMessage(rXml));
						return false;
					}
					sheetObj.LoadSearchData(rXml);
				}else{
					return false;
				}
			break;
			case IBSAVE:        //save
				if(validateForm(sheetObj,formObj,sAction)) {
					var cntr_no=formObj.cntr_no.value;
					var returnArr=new Array();
					for(ir=sheetObj.HeaderRows();ir<=sheetObj.LastRow();ir++){
						var rowArr=new Array();
						for(ic=0 ;ic<=sheetObj.LastCol();ic++){
                            rowArr.push(sheetObj.GetCellValue(ir, ic));
						}
						returnArr.push(rowArr);
					}
					//alert("check.4\n\n" + returnArr);
					if(callback_func != ''){
					    if (ComFuncCheck("opener." + callback_func)) ComFunc(cntr_no, returnArr);
                        else if (ComFuncCheck("parent." + callback_func)) ComFunc(cntr_no, returnArr);
					}
				}else{
					return false;
				}
			break;
		}
		return true;
    }
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		for(ir=sheetObj.HeaderRows();ir<=sheetObj.LastRow();ir++){
            if(formObj.bkg_no.value == sheetObj.GetCellValue(ir, "bkg_no")){
				sheetObj.SelectCell(ir, "adj_vol_qty", true, formObj.cntr_vol.value);
				break;
			}
		}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:      //retrieve
			break;
			case IBSAVE:        //save
				var ttl=ComColumnSum(sheetObj, "adj_vol_qty");
				//alert("total : " + ttl);
				if(ttl != 1){
					ComShowMessage(ComGetMsg("BKG08009"));
					return false;
				}
				//
				for(ir=sheetObj.HeaderRows();ir<=sheetObj.LastRow();ir++){
                    if(sheetObj.GetCellValue(ir, "adj_vol_qty") == '0' && !confirm(ComGetMsg("BKG08012", sheetObj.GetCellValue(ir, "bkg_no")))) {
						return false;
					}
				}
			break;
		}
        return true;
    }
	/* --------------------------------------------------------------------
	 * Event handling
	 ---------------------------------------------------------------------- */
	function sheet1_OnBeforeEdit(sheetObj, row, col, val) {
		//alert("OnBeforeEdit -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col));
        before_edit_val=sheetObj.GetCellValue(row, col);
	}
	function sheet1_OnAfterEdit(sheetObj, row, col, val) {
		//alert("OnAfterEdit -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col))
	}
	function sheet1_OnChange(sheetObj, row, col, val) {
				//
		var col_save_name=sheetObj.ColSaveName(col);
		if(col_save_name == "adj_vol_qty"){
			/*
			 * 1. Values ​​of 0-1 can be entered - If not, [BKG08013] 
			 * 2. If Special Flag is  Y, can't input 0. 
			 * 3. If S/O is  Y, can't input 0
			*/
			// 0 <= vol <= 1
			if(val < 0 || val > 1 ){
				ComShowMessage(ComGetMsg("BKG08013"));
				sheetObj.SetCellValue(row, "adj_vol_qty",before_edit_val,0);
				sheetObj.SelectCell(row, "adj_vol_qty");
				return false;
			}
			//
            if(sheetObj.GetCellValue(row, "spcl_flg") == 'Y' && val == 0){
				sheetObj.SetCellValue(row, "adj_vol_qty",before_edit_val,0);
				sheetObj.SelectCell(row, "adj_vol_qty");
				return false;
			}
			//
            if(sheetObj.GetCellValue(row, "so_flg") == 'Y' && val == 0){
				sheetObj.SetCellValue(row, "adj_vol_qty",before_edit_val,0);
				sheetObj.SelectCell(row, "adj_vol_qty");
				return false;
			}
		}
	}
