/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0061.js
*@FileTitle  : S/C Retrieval 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	var sheetObjects=new Array();
	var sheetCnt=0;    
	var apro_usr_flg="";
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
//				case "btn_saveas":
//					ComOpenPopup("rdSaveFile.do", 250, 150,"rdSaveFileCallBack", "1,0", false);
//					break;
				case "btn_close":
					ComClosePopup();
					break;					
//				case "btn_search":
//					viewer.FindDialog();
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
	/**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */	
    function loadPage() {
    	controlBtn(false);
    	controlRdobtn(true);
		initSheet(sheetObjects[0], 1);
	   	//RD
    	initRdConfig(viewer);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }  
	/**
	* initializing RD Viewer
	*/	    
    function initRdConfig(rdObject){
    }
	/**
	* initializing RD Viewer for specific RD file
	*/	    
    function rdOpen(rdObject,formObj){
    	controlBtn(false);
    	controlRdobtn(true);
    	var path="apps/opus/esm/pri/screport/screport/report/ESM_PRI_0061.mrd";
    	var param="/rp [" + formObj.prop_no.value + "] ["+formObj.amd_seq.value +"] [Y] [Y] ["+formObj.hd_scp_tp_cd.value +"] /rxlspagezoom [95]";
    	var df_save_nm="";
    	if(formObj.sc_no.value == '' || formObj.sc_no.value == null ) {
    		df_save_nm=formObj.prop_no.value;
    	} else {
    		df_save_nm=formObj.sc_no.value+"_"+formObj.amd_seq.value;
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
				with(sheetObj){
					var HeadTitle="status";
	
					SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
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
			case IBSEARCH: 
				formObj.f_cmd.value=SEARCH01;
				var sParam="&prop_no="+formObj.prop_no.value;
//parameter changed[check again]CLT
				var sXml=sheetObj.GetSearchData("ESM_PRI_0061GS.do", FormQueryString(document.form)+sParam);
				var arrText=ComPriXml2Array(sXml, "sc_no|amdt_seq|ctrt_eff_dt|ctrt_exp_dt|prop_ofc_cd|prc_ctrt_cust_tp_cd|apro_usr_flg");
		    	if(arrText==""||arrText==undefined){
		    		ComShowCodeMessage("PRI00013");
		    		return;
		    	}					
				formObj.sc_no.value=arrText[0][0];
				formObj.amd_seq.value=arrText[0][1];
				formObj.ctrt_eff_dt.value=arrText[0][2];
				formObj.ctrt_exp_dt.value=arrText[0][3];
				formObj.prop_ofc_cd.value=arrText[0][4];
				formObj.prc_ctrt_cust_tp_cd.value=arrText[0][5];
				apro_usr_flg=arrText[0][6];
				rdOpen(viewer, document.form);				
				break;
		}
	}	
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	* calling scp_tp_cd Radio Button's OnChange Event <br>
	*/	
	function scp_tp_cd_OnChange(scp_tp_cd){
		var formObject=document.form;
		if(formObject.hd_scp_tp_cd.value != scp_tp_cd.value){
			formObject.hd_scp_tp_cd.value=scp_tp_cd.value;
			rdOpen(viewer, document.form);
		}
	}
	/**
	* setting Radio Button's activation <br>
	*/	
	function controlRdobtn(flag){
		var formObject=document.form;
		document.all.scp_tp_cd[0].disabled=flag;
		document.all.scp_tp_cd[1].disabled=flag;
	}
	/**
	* setting Button 's activation<br>
	*/	
	function controlBtn(flag){
		var formObject=document.form;
		if(flag){
			ComBtnEnable("btn_print");
			ComBtnEnable("btn_retrieve");
//			ComBtnEnable("btn_saveas");
		}else{
			ComBtnDisable("btn_print");
			ComBtnDisable("btn_retrieve");
//			ComBtnDisable("btn_saveas");
		}
	}

