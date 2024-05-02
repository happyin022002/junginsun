/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0707.js
*@FileTitle  :Mark And Description for C/M
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var callback_func='';
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_OK":
					var pck_cmdt_desc=formObject.pck_cmdt_desc.value;
					var cntr_cmdt_desc=formObject.cntr_cmdt_desc.value;
					var dg_cmdt_desc=formObject.dg_cmdt_desc.value;
					var cm_cstms_desc='';
					if(formObject.cntr_knt.value == 1 && sheetObjects[0].RowCount()== 1){
						cm_cstms_desc=sheetObjects[0].GetCellValue(1, "cntr_mf_gds_desc");
					}
					if (!opener) opener=parent;
					if(callback_func != ''){
						eval('opener.'+callback_func)(pck_cmdt_desc, cntr_cmdt_desc, dg_cmdt_desc, cm_cstms_desc);
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
		// set init-data for sheets
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH) ;
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
			    with(sheetObj){
			      var HeadTitle="|Seq.|CntrNo|PckQty|PckTp|WgtQty|WgtUt|Desc";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(0);
		       }

			break;
		}
	}
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_BKG_0707GS.do", FormQueryString(formObj) );
				}
			break;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrCode , ErrMsg){

		var formObj=document.form;
		formObj.pck_cmdt_desc.value=sheetObj.GetEtcData("pck_cmdt_desc");
		formObj.cntr_cmdt_desc.value=sheetObj.GetEtcData("cntr_cmdt_desc");
		formObj.cntr_knt.value=sheetObj.GetEtcData("cntr_knt");
		formObj.dg_cmdt_desc.value=getGoodsDesc();

	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
	function getGoodsDesc(){
		var sheetObj=sheetObjects[0];
		var goodsDesc='';
		var rCnt=sheetObj.RowCount();
		if(rCnt == 0) {
			// do nothing!
		} else if(rCnt == 1) {
			goodsDesc += sheetObj.GetCellValue(1, "cntr_no") + ": \n";
			goodsDesc += ComLpad(sheetObj.GetCellValue(1, "pck_qty"), 7, " ") + " " +
			sheetObj.GetCellValue(1, "pck_tp_cd") + " / " +
			sheetObj.GetCellValue(1, "cntr_mf_wgt") + " " +
			sheetObj.GetCellValue(1, "wgt_ut_cd") + ", " +
			sheetObj.GetCellValue(1, "cntr_mf_gds_desc").split('\n').join('') + "\n"
		} else {
			var tmpCntr='';
			for(ir=1;ir<=rCnt;ir++){
				if(tmpCntr!=sheetObj.GetCellValue(ir, "cntr_no")){
					goodsDesc += sheetObj.GetCellValue(ir, "cntr_no") + ": \n";
					tmpCntr=sheetObj.GetCellValue(ir, "cntr_no");
				}
			goodsDesc += ComLpad(sheetObj.GetCellValue(ir, "pck_qty"), 7, " ") + " " +
			sheetObj.GetCellValue(ir, "pck_tp_cd") + " / " +
			sheetObj.GetCellValue(ir, "cntr_mf_wgt") + " " +
			sheetObj.GetCellValue(ir, "wgt_ut_cd") + ", " +
			sheetObj.GetCellValue(ir, "cntr_mf_gds_desc").split('\n').join('') + "\n"
			}
		}
		return goodsDesc;
	}
