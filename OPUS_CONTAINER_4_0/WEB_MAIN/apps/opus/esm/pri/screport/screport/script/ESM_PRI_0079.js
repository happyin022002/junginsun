/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0079.jsp
*@FileTitle  : S_C Print View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0079 : business script for ESM_PRI_0079 
     */
	var sheetObjects=new Array();
	var sheetCnt=0;    
	var comboObjects=new Array();
	var comboCnt=0;	
	var apro_usr_flg="";
	var amdt_seq_list=new Array();
    document.onclick=processButtonClick;
    function processButtonClick(){
        var formObject=document.form; 
        var comboObj=comboObjects[1];
        var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
				case "btns_back1":
					if(comboObj.GetSelectIndex()==0) return;
					comboObj.SetSelectIndex(0);
					break;
				case "btns_back2":
					if(comboObj.GetSelectIndex()==0) return;
					comboObj.SetSelectIndex(--comboObj.GetSelectIndex());
					break;
				case "btns_next1":
					if(comboObj.GetSelectIndex()== comboObj.GetItemCount()) return;
					comboObj.SetSelectIndex(++comboObj.GetSelectIndex());
					break;
				case "btns_next2":
					if(comboObj.GetSelectIndex()== comboObj.GetItemCount()) return;
					comboObj.SetSelectIndex(comboObj.GetItemCount()-1);
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
    
    function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}	
    
    /**
     * Initializing and setting Sheet basics<br> 
     * Setting body tag's onLoad event handler<br>
     * Adding pre-handling function after loading screen on the browser <br>
     */	    
    function loadPage() {
    	controlBtn(false);
    	controlChkbox(true);
    	
    	for(var k=0;k<comboObjects.length;k++){
      	    initCombo(comboObjects[k], k+1);
      	}
		initSheet(sheetObjects[0], 1);
	   	//RD
    	initRdConfig(viewer);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
    function initRdConfig(rdObject){
    }
	/**
	* initializing RD Viewer
	*/    
    function rdOpen(rdObject,formObj){
    	controlBtn(false);
    	controlChkbox(true);
    	var prop_no=formObj.prop_no.value;
    	var amdt_seq=formObj.amdt_seq.value;    	
    	var blpl_flg=formObj.blpl_flg.checked ? "Y" : "N";
    	var sign_flg=formObj.sign_flg.checked ? "Y" : "N";
    	// setting RD file to open 
    	var path="apps/opus/esm/pri/screport/screport/report/ESM_PRI_0079.mrd";
    	var param="/rp [" + prop_no + "] ["+ amdt_seq +"] ["+ blpl_flg +"] ["+ sign_flg +"] /rxlspagezoom [95]";
    	// showing full print in case of Proposal
    	if(amdt_seq=="0"){
    		path="apps/opus/esm/pri/screport/screport/report/ESM_PRI_0061.mrd";
    		param="/rp [" + prop_no + "] ["+ amdt_seq +"] ["+ blpl_flg +"] ["+ sign_flg +"] [A] /rxlspagezoom [95]";
    	}
//    	RD_path = "http://localhost:7001/opuscntr/";
    	var df_save_nm="";
    	if(formObj.sc_no.value == '' || formObj.sc_no.value == null ) {
    		df_save_nm=formObj.prop_no.value;
    	} else {
    		df_save_nm=formObj.sc_no.value+"_"+formObj.amdt_seq.value;
    	}    	
    	viewer.openFile(RD_path + path, RDServer + param, {timeout:3000});
    	viewer.bind('report-finished', function(e){
    		controlBtn(true);
    		controlChkbox(false);
    	});
    }
    
    function initCombo(comboObj, comboNo) {
        var formObject=document.form; 
        switch(comboObj.options.id) {  
            case "sc_no_list":  
                with (comboObj) { 
	            	 SetDropHeight(65);
	                 SetMultiSelect(0);
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
		switch (sheetID) {
		case "sheet1":
		    with(sheetObj){
	        	if (location.hostname != "")
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
	  /**
	   * Handling sheet process<br>
	   */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: 
				var comboObj=comboObjects[1]; 
				formObj.f_cmd.value=SEARCH01;
//				var sParam = "&f_cmd="+SEARCH01+"&prop_no=" + comboObj.Code + "&amdt_seq=" + amdt_seq_list[comboObjects[1].Index];
				var sParam = "&f_cmd="+SEARCH01+"&prop_no=" + comboObj.GetSelectCode()+ "&amdt_seq=" + amdt_seq_list[comboObjects[1].GetSelectIndex()];
 				var sXml=sheetObj.GetSearchData("ESM_PRI_0079GS.do", sParam);
				var arrText=ComPriXml2Array(sXml, "sc_no|amdt_seq|prop_no|eff_dt|exp_dt|file_dt|prop_ofc_cd|prop_srep_cd|prop_apro_ofc_cd|apro_usr_nm|cre_dt|apro_usr_flg|blpl_amdt_flg");
		    	if(arrText==""||arrText==undefined){
		    		ComShowCodeMessage("PRI00013");
		    		return;
		    	}
		    	var seq=comboObj.GetSelectIndex();
				formObj.sc_no.value=arrText[0][0];
				formObj.amdt_seq.value=arrText[0][1];
				formObj.prop_no.value=arrText[0][2];
				formObj.ctrt_eff_dt.value=arrText[0][3];
				formObj.ctrt_exp_dt.value=arrText[0][4];
				formObj.prop_file_dt.value=arrText[0][5];
				formObj.prop_ofc_cd.value=arrText[0][6];
				comboObjects[0].SetSelectText(arrText[0][7]);
				formObj.prop_srep_nm.value=comboObjects[0].GetSelectCode();
				formObj.apro_ofc_cd.value=arrText[0][8];
				formObj.apro_usr_nm.value=arrText[0][9];
				formObj.prop_cre_dt.value=arrText[0][10];
				apro_usr_flg=arrText[0][11];
//				formObj.blpl_flg.checked = arrText[0][12] == "Y" ? true : false;
				rdOpen(viewer, document.form);				
				break;
			case IBCLEAR: // adding combo items when initializing
				if (validateForm(sheetObj,document.form,sAction)) {
					formObj.f_cmd.value=SEARCH16;
					var sParam=FormQueryString(formObj);	
 					sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
					ComPriXml2ComboItem(sXml,prop_srep_cd, "nm", "cd");
				}		
				comboObjects[0].SetEnable(0);
				var arrPropNo=formObj.sParam.value.split(";");
				for(i=0;i<arrPropNo.length-1;i++){
					var arrItem=arrPropNo[i].split(":");
					var seq=i+1;
					comboObjects[1].InsertItem(i, seq+". "+(arrItem[1]=="" ? arrItem[0] : arrItem[1]), arrItem[0]);
					amdt_seq_list[i]=arrItem[2];
				}
				comboObjects[1].SetSelectIndex("0", true);
				break;
		}
	}	
	 /**
	 * checking validation process of inputed form data <br>
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: 
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBCLEAR: 
			return true;		
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			} else {
				return true;
			}
		break;			
		}
	}	
	
    /**                                                                                            
     * sc_no_list_OnChange event handler when changing combo selection<br>                                                                             
     */  
	function sc_no_list_OnChange(comboObj, code, text) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
	* setting activation of CheckBox <br>
	*/	
	function controlChkbox(flag){
		var formObject=document.form;
		document.all.blpl_flg.disabled=flag;
		document.all.sign_flg.disabled=flag;
	}
	/**
	* setting activation of Button <br>
	*/	
	function controlBtn(flag){
		var formObject=document.form;
		if(flag){
			ComBtnEnable("btn_print");
			ComBtnEnable("btn_retrieve");
//			ComBtnEnable("btn_saveas");
		}
		else{
			ComBtnDisable("btn_print");
			ComBtnDisable("btn_retrieve");
//			ComBtnDisable("btn_saveas");
		}
	}
	
	