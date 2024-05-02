/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0047.js
*@FileTitle  : Control by RHQ
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/06
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
    /**
     * @extends 
     * @class ESM_SPC_0047 : business script for ESM_SPC_0047
     */
//    function ESM_SPC_0047() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    //var sheetResizeFull = true;
    var sheetResizeCount=2;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    	function processButtonClick(){
    		 /***** setting additional sheet value in case of more 2 sheet per tab *****/
    		 var sheetObject=sheetObjects[0];
    		 var sheetObject1=sheetObjects[1];
    		 /*******************************************************/
    		 var formObject=document.form;
//    		try {
    			var srcName=ComGetEvent("name");
    			if(ComGetBtnDisable(srcName)) return false;
    			if(srcName == "" || 
    				(document.getElementsByName(srcName) == null || 
    				(window.event.srcElement.tagName == "IMG" && 
    					document.getElementsByName(srcName)[0].GetEnable()!= undefined &&
    					!document.getElementsByName(srcName)[0].GetEnable()))){
    				return;
    			}
    			switch(srcName) {
    				case "btn_retrieve":
    					cancelControlOption(sheetObject);
    					enableButtons(false);
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				case "btn_new":
    					if(checkModifiedSheet(sheetObjects[1])){
    						if(ComShowConfirm (getMsg("SPC90001")) != 1){
    							return;
    						}
    					}  				
    					resetAll();
    					cancelControlOption(sheetObject);
    					enableButtons(false);
    					hiddenMasterCols(sheetObject, formObject, "INIT");
    					break;
    				case "btn_save":
    					doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					break;
    				case "btn_downexcel":
    					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    					break;
    				case "btng_bottleneck":
    					var param="";
    					var frow=sheetObject.FindText("dataSeq", sheet1_SelectedRow);
    					var vvd=sheetObject.GetCellValue(frow, "VVD");
    					param=param + "&year1="+sheetObject.GetCellValue(frow, "WEEK").substring(0, 4);
    					param=param + "&week1="+sheetObject.GetCellValue(frow, "WEEK").substring(4);
    					param=param + "&lane="+sheetObject.GetCellValue(frow, "rlane_cd");
    					param=param + "&bound="+sheetObject.GetCellValue(frow, "dir_cd");
    					param=param + "&vvd="+vvd;
    					param=param + "&popupcheck=Y";
    					var url="ESM_SPC_0045.do?"+param;
    		    		var rtn=window.open(url, "BOTTLENECK", "height=550px,width=980px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
    					break;
    				case "btng_skd":
    					var frow=sheetObject.FindText("dataSeq", sheet1_SelectedRow);
    					var param="&vvd=" + sheetObject.GetCellValue(frow, "VVD");
            	    	var url="ESM_SPC_0071.do?"+param;
    		    		 ComOpenWindow(url,  window,  "scroll:no;status:no;help:no;dialogWidth:"+700+"px;dialogHeight:"+450+"px" , true);
            	        break;
    				case "btng_bsa":
            	    	var param="";
            	    	var frow=sheetObject.FindText("dataSeq", sheet1_SelectedRow);
            	    	var vvd=sheetObject.GetCellValue(frow, "VVD");
            	    	param=param + "&txtYear="+sheetObject.GetCellValue(frow, "WEEK").substring(0, 4);
            	    	param=param + "&txtFmWeek="+sheetObject.GetCellValue(frow, "WEEK").substring(4);
            	    	param=param + "&txtToWeek="+sheetObject.GetCellValue(frow, "WEEK").substring(4);
            	    	param=param + "&selDir="+sheetObject.GetCellValue(frow, "dir_cd");
    					param=param + "&txtVsl_cd="+vvd.substring(0, 4);
    					param=param + "&txtSkd_voy_no="+vvd.substring(4, 8);
    					param=param + "&txtDir_cd="+vvd.substring(8);
    					param=param + "&hSearchYN=Y";
            	    	var url="ESM_BSA_0104.do?"+param;
    		    		var rtn=window.open(url, "BSA", "height=720px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
    					break;
    				case "btng_copymodel":
    					doActionIBSheet(sheetObject1, formObject,IBCOPYROW);
    					break;
    				case "btng_controlEdit":
    					editControlOption(sheetObject);
    					break;
    				case "btng_controlSave":
    					var rtn=saveControlOption(sheetObject);
    					if(rtn == "OK"){
    						var frow=sheetObject.FindText("dataSeq", sheet1_SelectedRow);
    						sheet1_OnDblClick(sheetObject, frow, 1);
    					}
    					break;
    				case "btng_controlCancel":
    					cancelControlOption(sheetObject);
    					break;
    				case "maxi":
    					toggleSheetSize("zoomarea");
    					break;
    			} // end switch
//    		}catch(e) {
//    			if( e == "[object Error]") {
//    				ComShowCodeMessage("COM12111");
//    			} else {
//    				ComShowMessage(e);
//    			}
//    		}
    	}
    	function getVVD(){
    	}
    	/**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    	function setSheetObject(sheet_obj){
    	   sheetObjects[sheetCnt++]=sheet_obj;
    	}
    	function setComboObject(combo_obj){
    	   comObjects[comboCnt++]=combo_obj;
    	}
    	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    	function loadPage() {
    		optionSetting();
    		for(i=0;i<sheetObjects.length;i++){
    			// change the name of start environment setting funtion
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			// Adding last environment setting funtion
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		var sheetResizeFull=true;
    		document_onresize();
    		enableButtons(false);
    		document.form.year.focus();
    		var formObject=document.form;
    		comObjects[0].SetEnable(0);
    		if(document.getElementById("trade").SetEnable== 0) document.getElementById("trade").tabIndex(1);
    		if(isDevMode){
    		}
    	}
    	function enableButtons(enable){
    		if(enable){
    			ComBtnEnable("btng_controlEdit");
    			ComBtnEnable("btng_bottleneck");
    			ComBtnEnable("btng_skd");
    			ComBtnEnable("btng_bsa");
    		} else {
    			ComBtnDisable("btng_controlEdit");
    			ComBtnDisable("btng_bottleneck");
    			ComBtnDisable("btng_skd");
    			ComBtnDisable("btng_bsa");
    		}
    	}
    	var HeadMaster1="OCN\nIPC\nT/S|RHQ|Load\nOffice|POL|POD| |Load\nQTA|CMB|Forecast";
    	var HeadMaster2="OCN\nIPC\nT/S|RHQ|Load\nOffice|POL|POD| |Load\nQTA|CMB|CMB";
    	var txtDelem="|";
    	var HeadTail="";
    	var HeadTypeSize=new Array("TEU|HC|45'|53'|Reefer|WT\n(M/T)",
    								 "Total TEU|20'|40'|HC|45'|53'|Reefer|WT\n(M/T)") ;
    	var HeadVolume=new Array("Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",
    							   "Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)") ; 
    	var txtHeadItem=new Array("Forecast", "Final load", "Model", "Allocation", "Booking(Firm)", "Booking(TTL)", "Customer\nGuarantee","Base");
    	var preColName=new Array("fcast", "fnl", "bkg", "asgn", "bkg_aval", "usd_bkg", "gnt", "base");
    	var sizeColName=new Array(new Array("_ttl_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt"),
    								new Array("_ttl_qty", "_20ft_qty", "_40ft_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt"));
    	var sizeColType=new Array(new Array("dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger"),
    								new Array("dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger"),
    								new Array("dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger"));
    	// index of shown Tp/S (index of sizeColName)
    	var colSizeIdx=new Array(0, 0, 0, 0, 1, 1, 0, 0);
    	// index of shown the index of Number type (index of sizeColType)
    	var colTypeIdx=new Array(2, 2, 2, 0, 1, 1, 0, 0);
    	//Checking if the item is adjusted or not according to Type/Size and weight control option
    	var syncTarget=new Array(false, true, false, true, false, false, false);
    	//Checking if the item is controled or not 
    	var controlCols=new Array(true, true, false, true, true, true, true, false);
    	// check box name by item shown on data select 
    	var dataSelectionItemName=new Array("", "chkUSG", "", "", "chkBKGF", "", "chkCUS");
    	var MasterCnt=9;
    	var TailCnt=23;
    	var ColumnCnt=MasterCnt + TailCnt;
    	var fcastIdx=0;
    	var finalIdx=1;
    	var modelIdx=2;
    	var alocIdx=3;
    	var bkgFirmIdx=4;
    	var bkgTtlIdx=5;
    	var guarIdx=6;
    	var baseIdx=7;
    	// weight column list in the top sheet
    	var weightCols=new Array(8, 10, 19, 21, 25, 27, 29, 31, 33);
    	//  ocn column list in the top sheet
    	var ocnCols=new Array(16, 18, 19, 24, 25, 28, 29);
    	//  ipc column list in the top sheet
    	var ipcCols=new Array(17, 20, 21, 26, 27, 30, 31);
    	// existing searching value of Forecast QTY View
    	var fcastType=null;
      /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    	function initSheet(sheetObj,sheetNo) {
    		var cnt=0;
    		switch(sheetNo) {
    		case 1:	  //sheet1 init
 			   with (sheetObj) {
	    			    SetFocusEditMode(default_edit_mode);
	    			    var Head1="SEQ|Rep.\nTrade|Sub\nTrade|Lane|BD|Week|VVD|";
	    			    var HeadTitle0=Head1+"BSA|BSA|Loadable|Loadable|Loadable|Loadable|Loadable|Full&|Full&|Load|Load|F'CAST|F'CAST|F'CAST|F'CAST|L/F\n(%)|Empty\nPlan|Alloc|Alloc|Alloc|Alloc|BKG|BKG|BKG|BKG|Un\nAllocated\nSpace|Un\nAllocated\nWeight";
	    			    var HeadTitle1=Head1+"VOL|WGT|VOL|WGT|HC|45|RF|Down|Down|QTA|QTA|OCN|OCN|IPC|IPC|L/F\n(%)|Empty\nPlan|OCN|OCN|IPC|IPC|OCN|OCN|IPC|IPC|Un\nAllocated\nSpace|Un\nAllocated\nWeight";
	    			    var HeadTitle2=Head1+"VOL|WGT|VOL|WGT|HC|45|RF|VOL|WGT|OCN|IPC|VOL|WGT|VOL|WGT|L/F\n(%)|Empty\nPlan|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|Un\nAllocated\nSpace|Un\nAllocated\nWeight| v |v|d|vol|port|hc|45|53'|rf|wgt|flag|status";
	
	    			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:0 } );
	
	    			    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			    var headers = [ { Text:HeadTitle0, Align:"Center"},
	    			                  { Text:HeadTitle1, Align:"Center"},
	    			                  { Text:HeadTitle2, Align:"Center"} ];
	    			    InitHeaders(headers, info);
	
	    			    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"TRADE",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"STRADE",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"WEEK",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"VVD",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lod_vol",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lod_wgt",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lod_hc",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lod_45",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"lod_rf",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"alloc_ocn_vol",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"alloc_ocn_wgt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"alloc_ipc_vol",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"alloc_ipc_wgt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1,Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_spc_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1,Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_lvl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_40ft_hc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1,Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_45ft_hc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1,Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_53ft_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1,Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_rf_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1,Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_wgt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1,Width:30,   Align:"Center",  ColMerge:1,   SaveName:"flag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Status", Hidden:isDevMode?0:1,Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text", Hidden:isDevMode?0:1,Width:40,   Align:"Right",   ColMerge:1,   SaveName:"mty",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dataSeq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			              {Type:"Text",      Hidden:0,  Width:1,    Align:"Right",   ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    			     
	    			    InitColumns(cols);
	
	    			    SetEditable(0);
	    			    SetColHidden("dataSeq",1);
	    			    SetHeaderRowHeight(10);
	    			    var backColor="#555555";
	    			    SetRangeBackColor(1, 7, 2, 13,backColor);
	    			    SetRangeBackColor(2, 14, 2, 17,backColor);
	    			    SetRangeBackColor(1, 18, 2, 21,backColor);
	    			    SetRangeBackColor(1, 24, 2, 31,backColor);
	    			    SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
 			   }
 				break;
    			case 2:	  //sheet2 init
     			   with (sheetObj) {
     			  
     			    SetFocusEditMode(default_edit_mode);
     			    var HeadTitle0=HeadMaster1;
     			    var HeadTitle1=HeadMaster2;
     			    var HeadTitle2=HeadMaster2;
     			    HeadTitle0=HeadTitle0 + "|Forecast";
     			    HeadTitle1=HeadTitle1 + "|Volume";
     			    HeadTitle2=HeadTitle2 + "|Total TEU";
     			    for(var k=0 ; k < txtHeadItem.length ; k++){
	     			    var colNames=sizeColName[colSizeIdx[k]];
	     			    for(var i=0 ; i < colNames.length ; i++){
			     			    HeadTitle0=HeadTitle0 + txtDelem + txtHeadItem[k];
			     			    ColumnCnt=ColumnCnt + 1;
		     			    }
		     			    HeadTitle1=HeadTitle1 + txtDelem + HeadVolume[colSizeIdx[k]];
		     			    HeadTitle2=HeadTitle2 + txtDelem + HeadTypeSize[colSizeIdx[k]];
     			    }
     			    HeadTitle0=HeadTitle0 + HeadTail;
     			    HeadTitle1=HeadTitle1 + HeadTail;
     			    HeadTitle2=HeadTitle2 + HeadTail+"|flg|status|lane|bound|V|V|D|TS|MNG|OFC|lvl1|lvl2|child|leaf|pol|lvl|ts|trd|sub_trd|Remark|Remark |Remark  ";
//     			    log(HeadTitle0);
//     			    log(HeadTitle1);
//     			    log(HeadTitle2);

     			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:MasterCnt-1, DataRowMerge:0 } );

     			    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
     			    var headers = [ { Text:HeadTitle0, Align:"Center"},
     			                  { Text:HeadTitle1, Align:"Center"},
     			                  { Text:HeadTitle2, Align:"Center"} ];
     			    InitHeaders(headers, info);

     			    var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"sls_rhq_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Text",      Hidden:1, Width:42,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
     			              {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
     			     
     			 
	 			    SetImageList(0,"img/nolines_plus.gif");
	 			    SetImageList(1,"img/nolines_minus.gif");
	 			    sizeColType=new Array(
     			    		new Array("Integer", "Integer", "Integer", "Integer", "Integer", "Integer"),
 	    					new Array("Integer", "Integer", "Integer", "Integer", "Integer", "Integer", "Integer", "Integer"),
 	    					new Array("Integer", "Integer", "Integer", "Integer", "Integer", "Integer")
     			    );


     		            
     					for(var m = 0 ; m < txtHeadItem.length ; m++){
     						var colNames = sizeColName[colSizeIdx[m]];
     						var colTypes = sizeColType[colTypeIdx[m]];
     						for(var n = 0 ; n < colNames.length ; n++){
     							cols.push({Type:"controlCols[m]?dtData:(isDevMode?dtData:dtHidden)", Hidden:0, Width:defaultWidth, Align:"Right", ColMerge:1, SaveName:(preColName[m] + colNames[n]), KeyField:0, CalcLogic: "", Format:colTypes[n], PointCount:1, UpdateEdit:(m==alocIdx), InsetEdit:(m==alocIdx)});
     						}
     					}
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mode",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtStatus:dtHiddenStatus",   Hidden:isDevMode?0:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ts_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mnl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spc_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl1",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl2",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"child_cnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"leaf_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pol_cnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"tsedit",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"isDevMode?dtData:dtHidden",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
     					cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
     					cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_pol_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
     					cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_pod_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
     					cols.push({Type:"Text",      Hidden:0,  Width:1,    Align:"Right",   ColMerge:1,   SaveName:"",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

     					
//     					cols.concat([
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mode",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Status",    Hidden:isDevMode?0:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ts_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mnl_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spc_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl1",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl2",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"child_cnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"leaf_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pol_cnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"tsedit",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_pol_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_pod_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//     					             {Type:"Text",      Hidden:0,  Width:1,    Align:"Right",   ColMerge:1,   SaveName:"",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }]);

     					SetHeaderRowHeight(10);
     				    InitColumns(cols);
        			    SetEditable(1);	
        			    SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
//     					var backColor = RgbColor(222, 251, 248);
     					 var backColor="#555555";
     					SetRangeBackColor(1, MasterCnt - 1, 2, ColumnCnt - TailCnt - 1,backColor);

//     					InitTreeInfo(5, "sLevel", RgbColor(0,0,255), false);
     					ClipPasteMode = 1;
     					
     					EditableColor	= "#FFFFFF";//RgbColor(255,255,128);//Default:255,255,255, White (Editable data background)
     					UnEditableColor	= "#E2E2E2";//RgbColor(255,255,255);   //Default:255,255,255, Gray(non Editable data background)
     					//Allocation
     					for(var q = 0 ; q < sizeColName[colSizeIdx[alocIdx]].length + 1 ; q++){
     						SetMinimumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][q],0);
     						SetMaximumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][q],100000);
     					}
     					
     					for(var w = 0 ; w < sizeColName[colSizeIdx[finalIdx]].length + 1 ; w++){
     						sheetObjects[1].SetColHidden(preColName[finalIdx]+sizeColName[colSizeIdx[finalIdx]][w],1);
     					}
     					for(var e = 0 ; e < sizeColName[colSizeIdx[modelIdx]].length + 1 ; e++){
     						sheetObjects[1].SetColHidden(preColName[modelIdx]+sizeColName[colSizeIdx[modelIdx]][e],1);
     					}
     					for(var r = 0 ; r < sizeColName[colSizeIdx[bkgFirmIdx]].length + 1 ; r++){
     						sheetObjects[1].SetColHidden(preColName[bkgFirmIdx]+sizeColName[colSizeIdx[bkgFirmIdx]][r],1);
     					}
     					for(var t = 0 ; t < sizeColName[colSizeIdx[guarIdx]].length + 1 ; t++){
     						sheetObjects[1].SetColHidden(preColName[guarIdx]+sizeColName[colSizeIdx[guarIdx]][t],1);
     					}
//     					  SetSheetHeight(getSheetHeight(15) );
     				
     			   }
     				break;
    		}
    	}
     // Handling the process related with sheet
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg(false);
    		switch(sAction) {
    		   case IBSEARCH:	  //Retrieve
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
    				formObj.f_cmd.value=SEARCHLIST01;
    				sheetObj.ReDraw=false;
    				sheetObj.RemoveAll();
    				sheetObjects[1].RemoveAll();
    				formObj.chkTS.checked=true;
    				var param=SpcFormString(formObj,"f_cmd,year,week,duration,vvd,fcast,trade,subtrade,lane,bound,office");
     				sheetObj.DoSearch("ESM_SPC_0047GS.do", param );
    				fcastType=formObj.fcast.value;
    				hiddenMasterCols(sheetObj, formObj, "INIT");
    				//Retrieving the bottom data instantly in case numbers of retrieved data counting is 1
    				if(sheetObj.RowCount()== 1){
    					sheet1_OnDblClick(sheetObj, sheetObj.HeaderRows(), 1);
    				}
    				sheetObj.ReDraw=true;
    				break;
    			case IBSAVE:		//save
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
    				formObj.f_cmd.value=MULTI;
    //no support[check again]CLT 				var rows=sheetObj.GetTransColText("U", "mode");
    				var rowArr=rows.split(";");
    				var rowCnt=rowArr.length;
    				var chekport=formObj.chkPort.value;
    				for(var i=0 ; i < rowCnt ; i++){
    					var rowInfo=rowArr[i].split("=");
    					log("Changed Row : " + rowArr[i]);
    					if(sheetObj.GetCellValue(rowInfo[0]*1, "lvl")*1 < 3){
    						sheetObj.SetRowStatus(rowInfo[0]*1,"I");
    					}
    					else if(rowInfo[1] == "I"){
    						log("Change Status : " + rowArr[i]);
    						sheetObj.SetRowStatus(rowInfo[0]*1,"I");
    					}
    				}
    				var param=SpcFormString(formObj,"f_cmd");
    				var rtn=doSaveSheet(sheetObj, "ESM_SPC_0047GS.do", param);
    				if(rtn == "OK"){
    					for(var j=0 ; j < rowCnt ; j++){
    						var rowInfo=rowArr[j].split("=");
    						if(rowInfo[1] == "I"){
    							log("Update Status : " + rowArr[j]);
    							sheetObj.SetCellValue(rowInfo[0]*1, "mode","R",0);
    							sheetObj.SetRowStatus(rowInfo[0]*1,"R");
    							log("Updated Status : " + rowInfo[0]*1);
    						}
    					}
    					var cnt=sizeColName[colSizeIdx[alocIdx]].length - 1;
    					var frow=sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
    					var sumArr=getSum(sheetObj, ":OCN:T-OCN:", preColName[alocIdx]);
    					sheetObjects[0].SetCellValue(frow, "alloc_ocn_vol",sumArr[0],0);
    					sheetObjects[0].SetCellValue(frow, "alloc_ocn_wgt",sumArr[cnt],0);
    					sheetObjects[0].SetRowStatus(frow,"R");
    					var trow=0;
    					for(var r=0 ; r < Flags.length ; r++){
    						trow=totalRows[Flags[r]];
    						if(trow == undefined){
    							continue;
    						}
    						setTotalRowColor(sheetObj, trow);
    					}
    				}
    				break;
    			case IBCOPYROW:		// Row copy
    				ComOpenWaitCallFunc("copyModelDataToAlloc()", true);
    				break;
    		   case IBDOWNEXCEL:		//Excel download
    			   if(sheetObj.RowCount() < 1){//no data
              		 ComShowCodeMessage("COM132501");
	          		}else{
	     			  sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
	          		}
    			  break;
    		}
    	}
    	function copyModelDataToAlloc(){
    		var sheetObj=sheetObjects[1];
    		var rowCnt=sheetObj.RowCount();
    		var cols=TypeSizeCnt + 1;
    		var vals=new Array(new Array(), new Array());
    		var frow=-1;
    		var sRow=sheetObj.HeaderRows();
    		var eRow=sRow + rowCnt - 1;
            frow=sheetObj.FindText("ioc_cd", "T-", 0, 0);
            if(frow >= 0){
            	eRow=frow - 1;
            }
            frow=-1;
    		var sCols="";
            var eCols1="";
            var eCols2="";
    		for(var c=0 ;  c < cols ; c++){
                sCols += "|"+preColName[modelIdx]+sizeColName[c];
    			eCols1 += "|base"+sizeColName[c];
    			eCols2 += "|"+preColName[alocIdx]+sizeColName[c];
    		}
    		sCols=sCols.substring(1);
    		eCols1=eCols1.substring(1);
    		eCols2=eCols2.substring(1);
    		copyData(sheetObj, sRow, eRow, sCols, eCols1, false);
    		copyData(sheetObj, sRow, eRow, sCols, eCols2, false);
    		for(var r=sRow ; r <= eRow ; r++){
    			setWarnColorTEU(sheetObj, r, preColName[alocIdx], preColName[guarIdx]);
    		}
    		frow=-1;
    		while((frow=sheetObj.FindText("lvl", "-1", frow + 1)) > 0){
    			setTotalRowColor(sheetObj, frow);
    		}
    	}
    	var selectedCell_OldValue=0;
    	function sheet2_OnSelectCell(sheetObj, orow, ocol, row, col){
    		selectedCell_OldValue=sheetObj.GetCellValue(row, col)*1;
    	}
    	 function sheet2_OnChange(sheetObj, row, col, value){
    		var colName=sheetObj.ColSaveName(col);
    		var idx=colName.indexOf("_");
    		var pre=colName.substring(0, idx);
    		var sizeName=colName.substring(idx);
    		var orgValue=0;
    		value=value * 1;
    		var level=sheetObj.GetCellValue(row, "lvl") * 1;
    		if(pre == preColName[alocIdx]){
    			orgValue=sheetObj.GetCellValue(row, preColName[baseIdx]+sizeName) * 1;
    			if(level == 1){
    				allocateByOffice(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
    			}
    			else if(level == 2){
    				oldValue=selectedCell_OldValue;
    				allocateByPol(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
    				if(sheetObj.GetCellEditable(row, col)){
    					var rtn=changeSuperiorValue(sheetObj, row, col, pre, value, oldValue);
    					setWarnColorTEU(sheetObj, rtn[0], sizeName);
    				}
    			}
    			else if(level == 3){
    				if(sheetObj.GetCellEditable(row, col)){
    					var rtn=changeSuperiorValue(sheetObj, row, col, pre, value, selectedCell_OldValue);
    					setWarnColorTEU(sheetObj, rtn[0], sizeName);
    					setWarnColorTEU(sheetObj, rtn[1], sizeName);
    				}
    				var ioc_cd=sheetObj.GetCellValue(row, "ioc_cd");
    				changeTotalValue(sheetObj, ioc_cd, col, pre, value, selectedCell_OldValue);
    				setWarnColorTEU(sheetObj, totalRows[ioc_cd], sizeName);
    			}
    			setWarnColorTEU(sheetObj, row, sizeName);
    		}
    		selectedCell_OldValue=value;
    		var formObj=document.form;
        }
    	function sheet2_OnClick(sheetObj, row, col){
    		switch(sheetObj.ColSaveName(col)){
    		case "pol_cd":
    		case "pod_cd":
    			var mark=sheetObj.GetCellValue(row, col);
    			var status=sheetObj.GetRowStatus(row);
    			if(mark == "0"){
       				sheetObj.SetRowExpanded(row,1);
       				sheetObj.SetCellValue(row, col,"1",0);
       				sheetObj.SetRowStatus(row,status);
    			}
    			else if(mark == "1"){
       				sheetObj.SetRowExpanded(row,0);
       				sheetObj.SetCellValue(row, col,"0",0);
       				sheetObj.SetRowStatus(row,status);
    			}
    			break;
    		}
    	}
    	function sheet1_OnDblClick(sheetObj, row, col){
    		var sheetObj1=sheetObjects[1];
    		var formObj=document.form;
    		sheetObj1.SetEnable(0);
    		sheetObj1.ReDraw=false;
    		sheetObj1.RemoveAll();
    		// Changing  cancel status in case of control option is on edit status
    		cancelControlOption(sheetObj);
    		// setting selected current row of the top sheet
    		setSelectetRow(sheetObj, row);
    		// creating searching condition to search the bottom sheet
    		var param=makeDetailParam(sheetObj, row);
    		param=param + "&fcast="+fcastType;
    		param=param + "&year="+sheetObj.GetCellValue(row, "WEEK").substring(0, 4);
    		param=param + "&vsl_cd="+sheetObj.GetCellValue(row, "vsl_cd");
    		param=param + "&skd_voy_no="+sheetObj.GetCellValue(row, "skd_voy_no");
    		param=param + "&skd_dir_cd="+sheetObj.GetCellValue(row, "skd_dir_cd");
    		param=param + "&office="+comObjects[3].GetSelectCode();
    		sheetObj1.DoSearch("ESM_SPC_0047GS.do", param );
    		setVVDValue(sheetObj.GetCellValue(row, "VVD"));
    		setWeekValue(sheetObj.GetCellValue(row, "WEEK"));
    		setLod_volValue(sheetObj.GetCellValue(row, "lod_vol"));
    		// Checking control option according to the result of searching
    		checkControlOption();
    		// Checking check box related with IOC division of data selection item
    		checkSelectionOption(sheetObj1);
    		hiddenMasterCols(sheetObj, formObj, sheetObj.GetCellValue(row, "TRADE").substring(0, 1));
    		hiddenSelectionField(sheetObj1);
    		// Handling row hidden according to data selection
    		controlRowFilter(sheetObj1);
    		checkPortcontrolTree(sheetObj1)
    		// Displaying model performance time on Header
    		var model_dt=txtHeadItem[modelIdx];
            var colNames=sizeColName[colSizeIdx[modelIdx]]; 
    		var cnt=colNames.length;
    		var color=sheetObj1.GetCellBackColor(0, preColName[modelIdx]+colNames[0]);
    		for(var i=0 ; i < cnt ; i++){
    			sheetObj1.SetCellText(0, preColName[modelIdx]+sizeColName[i] ,model_dt);
    		}
    		enableButtons(true);
    		sheetObj1.ReDraw=true;
    		sheetObj1.SetEnable(1);
    	}
       /**
    	 * handling process for input validation
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    			switch(sAction) {
    				case IBSEARCH:	  //Retrieve
    					if(comObjects[0].GetEnable()&& formObj.vvd.value == "" && comObjects[0].GetSelectCode()== ""){
    						ComShowMessage(getMsg("SPC90114", "Trade"));
//    			            comObjects[0].focus();
    						return false;
    					}
    			        if(formObj.vvd.value == "" && comObjects[1].GetSelectCode()== ""){
    			            ComShowMessage(getMsg("SPC90114", "SubTrade"));
    			            formObj.year.focus();
//    			            comObjects[1].focus();
    			            return false;
    			        }
    			        if(formObj.vvd.value != "" && formObj.vvd.value.length < 9){
    			        	ComShowCodeMessage("COM12174", "VVD", "9");
    			            formObj.vvd.focus();
    			            return false;
    			        }
    			        if(comObjects[3].GetSelectCode()== ""){
    			            ComShowMessage(getMsg("SPC90114", "ORG"));
//    			            comObjects[3].focus();
    			            return false;
    			        }
    					break;
    				case IBSAVE:		//save
        				var lod_vol=0;
        				var lod_wgt=0;
        				var frow=sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
        				if(frow <= 0){
        					return false;
        				}
						lod_vol=sheetObjects[0].GetCellValue(frow, "lod_vol") * 1;
						lod_wgt=sheetObjects[0].GetCellValue(frow, "lod_wgt") * 1;
    					var models=new Array(
							sheetObjects[0].GetCellValue(frow, "lod_vol") * 1 - sheetObjects[0].GetCellValue(frow, "mty") * 1,
							sheetObjects[0].GetCellValue(frow, "lod_hc") * 1,
							sheetObjects[0].GetCellValue(frow, "lod_45") * 1,
							sheetObjects[0].GetCellValue(frow, "lod_53") * 1,
							sheetObjects[0].GetCellValue(frow, "lod_rf") * 1,
							sheetObjects[0].GetCellValue(frow, "lod_wgt") * 1
    					);
    					var rtn=validAllocationLoadable(sheetObj, formObj, ":OCN:T-OCN:", models, false);
    					if(rtn >= 0){
    						return false;
    					}
    					rtn=validAllocation(sheetObj, formObj, ":IPC:T-IPC:T/S:T-T/S:", true);
    					if(rtn >= 0){
    						return false;
    					}
        				return true;
    					break;
    				case IBINSERT:	  // Insert
    					break;
    				case IBCOPYROW:		// Row copy
    					break;
    				case IBDOWNEXCEL:		//Excel download
    					break;
    				case IBLOADEXCEL:		// Excel upload
    					break;
    			}
    		}
    		return true;
    	}
    function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	if(value == "") return;
    	// sub_trade initialization
    	comObjects[1].SetSelectIndex(0,false);
    	// lane initialization
    	comObjects[2].SetSelectIndex(0,false);
    }   
    function subtrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	if(newCode == "") return;
    	comObjects[0].SetSelectCode(comObj.GetText(newText,0),false);
    	// lane initialization
    	comObjects[2].SetSelectIndex(0,false);
    } 
    function lane_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	if(newText == "" ) return;
    	var repTrade=comObj.GetText(newText,0);  
    	var subTrade=comObj.GetText(newText,1);
    	comObjects[0].SetSelectCode(repTrade,false);
    	comObjects[1].SetSelectCode(subTrade,false);
    }
    function setVVDValue(vvd){
    	document.getElementById("idTxtVVD").value=vvd;
    }
    function setWeekValue(WEEK){
    	document.getElementById("idTxtWeek").value=WEEK;
    }
    function setLod_volValue(lod_vol){
    	var formObj=document.form;
    	formObj.fm_load.value=lod_vol;
        /*
         * addComma(Returning it after converting  input value to String including comma ex)1234 => 1,234  CoFormControl.js) 
         */	 
    	ComChkObjValid(formObj.fm_load);
    }
    function checkPortcontrolTree(sheetObj){
    	var formObj=document.form;
    	var sts1=formObj.chkOfc.checked;
    	var sts2=formObj.chkPol.checked;
    	var sts3=formObj.chkPod.checked;
    	if((sts1==true)&& (sts2==true) && (sts3==true)){
    	    sheetObj.SetColHidden("spc_ctrl_aloc_rmk",1);
    	    sheetObj.SetColHidden("spc_ctrl_aloc_pol_rmk",1);
    	    sheetObj.colhidden("spc_ctrl_aloc_pod_rmk")=false;
    	}
    	if((sts1==true) && (sts2 == false) &&(sts3 == false)){
    	    sheetObj.colhidden("spc_ctrl_aloc_rmk")=false;
    	    sheetObj.SetColHidden("spc_ctrl_aloc_pol_rmk",1);
    	    sheetObj.SetColHidden("spc_ctrl_aloc_pod_rmk",1);
    	}
    	if((sts1==true) && (sts2 == true) &&(sts3 == false)){
    	    sheetObj.colhidden("spc_ctrl_aloc_pol_rmk")=false;
    	    sheetObj.SetColHidden("spc_ctrl_aloc_rmk",1);
    	    sheetObj.SetColHidden("spc_ctrl_aloc_pod_rmk",1);
    	}
    }
    // Displaying selected OCN/IPC of the top sheet according to trade kind
    function hiddenMasterCols(sheetObj, formObj, trade){
    	var checked=formObj.chkWT.checked || trade == "INIT";
    	for(var i=0 ; checked && i < weightCols.length ; i++){
    		sheetObj.SetColHidden(weightCols[i],!checked);
    	}
    	checked=formObj.chkOCN.checked || trade == "INIT";
    	for(var j=0 ; j < ocnCols.length ; j++){
    		sheetObj.SetColHidden(ocnCols[j],!checked);
    	}
    	checked=formObj.chkIPC.checked || trade == "INIT";
    	for(var k=0 ; k < ipcCols.length ; k++){
    		sheetObj.SetColHidden(ipcCols[k],!checked);
    	}
    	checked=formObj.chkWT.checked || trade == "INIT";
    	for(var m=0 ; !checked && m < weightCols.length ; m++){
    		sheetObj.SetColHidden(weightCols[m],!checked);
    	}
    }
    function initDataValue_trade(){
    	var sheetObj=document.getElementById("trade");
    	with(sheetObj){
    		Index2=0;
    	}
    }
    function initDataValue_subtrade(){
    	var sheetObj=document.getElementById("subtrade");
    	with(sheetObj){
    		Index2=0;
    	}
    }
    function initDataValue_lane(){
    	var sheetObj=document.getElementById("lane");
    	with(sheetObj){
    		Index2=0;
    	}
    }
    function initDataValue_office(){
    	var sheetObj=document.getElementById("office");
    	with(sheetObj){
    		Index2=0;
    	}
    }
    function optionSetting() {
    	SpcSearchOptionYear("year");
    	SpcSearchOptionWeek("week");
    	SpcSearchOptionDuration("duration", 5, 5);
    	SpcSearchOptionTrade("trade", true, true);
    	SpcSearchOptionSubTrade("subtrade", true, true);
    	SpcSearchOptionLane("lane");
    	SpcSearchOptionBound("bound");
    	SpcSearchOptionRhq("office");
    }
