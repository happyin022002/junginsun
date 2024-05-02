/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2039.js
*@FileTitle  : RFA Proposal Creation - Draft
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/

	var sheetObjects=new Array();
	var sheetCnt=0;    
	var prop_srep_cd="";
    document.onclick=processButtonClick;
    function processButtonClick(){
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					rdOpen(viewer, document.form);
					break;
				case "btn_print":
					viewer.print({isServerSide:true});
					break;
				case "btn_close":
					ComClosePopup(); 
					break;					
//				case "btn_search":
//					rdObjects[0].FindDialog();
//					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}        
    }
    function loadPage() {
    	initSheet(sheetObjects[0], 1);
    	initRdConfig(viewer);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
    function initRdConfig(rdObject){
    }
    
    function rdOpen(rdObject,formObj){
    	if(formObj.ret_tp_rdo[0].checked == true){
    		path="apps/opus/esm/pri/rfareport/rfareport/report/ESM_PRI_2039.mrd";
    	}else{
    		path="apps/opus/esm/pri/rfareport/rfareport/report/ESM_PRI_2062.mrd";
    	}
    	var param="/rp [" + formObj.prop_no.value + "] ["+formObj.amdt_seq_t.value + "]";
    	var df_save_nm="";
    	if(formObj.rfa_no.value == '' || formObj.rfa_no.value == null ) {
    		df_save_nm=formObj.prop_no.value;
    	} else {
    		df_save_nm=formObj.rfa_no.value+"_"+formObj.amdt_seq_t.value;
    	}
    	viewer.openFile(RD_path + path, RDServer + param, {timeout:3000});
    	viewer.bind('report-finished', function(e){
    		controlBtn(true);
    		controlRdobtn(false);
    	});
    }
	/**
	 * setting sheet initial values and header 
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
			with (sheetObj) {
                var HeadTitle="status";
                SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
                InitColumns(cols);
                SetVisible(0);
			}
			break;
		}
	}    
	// Handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: // when screen loading Tab Count retreving
				formObj.f_cmd.value=SEARCH01;
				var sParam="&prop_no="+formObj.prop_no.value;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2039GS.do", FormQueryString(document.form)+sParam);
				var arrText=ComPriXml2Array(sXml, "rfa_no|prop_no|amdt_seq");
		    	if(arrText==""||arrText==undefined){
		    		ComShowCodeMessage("PRI00013");
		    		return;
		    	}					
				formObj.rfa_no.value=arrText[0][0];
				formObj.prop_no_t.value=arrText[0][1];
				formObj.amdt_seq_t.value=arrText[0][2];
				if(arrText[0][2]=="0"){
					formObj.ret_tp_rdo[1].disabled=true;					
				}
				rdOpen(viewer, document.form);
				break;
		}
	}	
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}