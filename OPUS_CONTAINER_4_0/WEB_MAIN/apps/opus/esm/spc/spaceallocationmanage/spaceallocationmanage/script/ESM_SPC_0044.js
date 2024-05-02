/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0044.js
*@FileTitle  : Allocation Control by Main Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
    /**
     * @extends 
     * @class ESM_SPC_0044 : business script for ESM_SPC_0044
     */
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var sheetResizeCount=2; 
    var preColName=new Array("fcast", "fnl", "bokg", "usd_bkg", "asgn", "bkg_aval", "gnt","base");
    var sizeColName=new Array(new Array("_ttl_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt"),
    							new Array("_ttl_qty", "_20ft_qty", "_40ft_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt"));
    // index of shown Tp/S (index of sizeColName)
    var colSizeIdx=new Array(0, 0, 1, 1, 0, 0, 0, 0);
    // index of shown the index of Number type (index of sizeColType)
    var colTypeIdx=new Array(2, 2, 1, 1, 1, 0, 0, 0);
    //Checking if the item is adjusted or not according to Type/Size and weight control option
    var syncTarget=new Array(false, true, false, false, false, true, false, false);
    //Checking if the item is controled or not 
    var controlCols=new Array(true, true, true, true, true, true, true, false);
    // check box name by item shown on data select 
    var dataSelectionItemName=new Array("", "chkUSG", "chkBKGF", "", "", "", "chkCUS", "");
	var txtHeadItem=new Array("Forecast", "Final load", "Booking(Firm)", "Booking(TTL)", "HO/RHQ Alloc", "Office Alloc", "Volume Guarantee for Customer", "Base");
	var sizeColName=new Array(new Array("_ttl_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt"),
				new Array("_ttl_qty", "_20ft_qty", "_40ft_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt"));
    var colSizeIdx=new Array(0, 0, 1, 1, 0, 0, 0, 0);
    var MasterCnt=14;		//20160120.MOD : 9->14
    var TailCnt=23; // Adding 1 according to Adding Total TEU
    var ColumnCnt=MasterCnt + TailCnt;
    var fcastIdx=0;
    var finalIdx=1;
    var bkgFirmIdx=2;
    var bkgTtlIdx=3;
    var modelIdx=4;
    var alocIdx=5;
    var guarIdx=6;
    var baseIdx=7;
    var weightCols=new Array(13, 17);
    var controlWeightCols=new Array(8, 15);
	var rows= "";
	var rowArr= "";
    var rowCnt= "";
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    	function processButtonClick(){
    		/***** setting additional sheet value in case of more 2 sheet per tab *****/
    		var sheetObject=sheetObjects[0];
    		var sheetObject1=sheetObjects[1];
    		/*******************************************************/
    		var formObject=document.form;
    		//try {
    			var srcName=ComGetEvent("name");
//    			if(srcName == "" || (ComGetEvent("srcName")) == null || (ComGetEvent("tagName")) == "IMG" && document.getElementsByName(srcName)[0].GetEnable()!= undefined && !document.getElementsByName(srcName)[0].GetEnable()){
//    				return;
//    			}
    			if(ComGetBtnDisable(srcName)){
    				return false;
    			}
    			switch(srcName) {
    				case "btn_retrieve":
//            			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
    					sheet1.RemoveAll();
    					sheet2.RemoveAll();
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
    					enableButtons(false);
    					hiddenMasterCols(sheetObject, formObject, "INIT");
    					break;
    				case "btn_save":
    					doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					break;
    				case "btn_downexcel":
    					if(sheetObject1.RowCount() < 1){//no data
    						ComShowCodeMessage("COM132501");
    					}else{
    						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    					}
    					break;
    				case "btng_bottleneck":
    					var param="";
    					var frow=sheetObject.FindText("dataSeq", sheet1_SelectedRow+"");
    					var vvd=(sheetObject.GetCellValue(frow, "VVD") == -1?"":sheetObject.GetCellValue(frow, "VVD"));
						param=param + "&year1="+sheetObject.GetCellValue(frow, "WEEK").substring(0, 4);
						param=param + "&week1="+sheetObject.GetCellValue(frow, "WEEK").substring(4);
						param=param + "&lane="+sheetObject.GetCellValue(frow, "rlane_cd");
						param=param + "&bound="+sheetObject.GetCellValue(frow, "dir_cd");
    					param=param + "&vvd="+vvd
    					param=param + "&popupcheck=Y";
//    					var url="ESM_SPC_0045.do?" + param;
//    		    		var rtn=window.open(url, "BOTTLENECK", "height=750px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
    					ComOpenPopup('ESM_SPC_0045_POP.do?' + param,900, 600, "", "1,0", false);
            	        break;
    				case "btng_skd":
    					var frow=sheetObject.FindText("dataSeq", sheet1_SelectedRow+"");
    					var param="&vvd=" + (sheetObject.GetCellValue(frow, "VVD") == -1?"":sheetObject.GetCellValue(frow, "VVD"));
    					var url="ESM_SPC_0071.do?"+param;
//   		    		 	ComOpenWindow(url,  window, "height=600px,width=700px,status=no,toolbar=no,menubar=no,location=no,resizable=yes", false);
   		    		 	ComOpenWindow(url,  "", "height=600px,width=700px,status=no,toolbar=no,menubar=no,location=no,resizable=yes", false);
   		    		 	break; 
    				case "btng_bsa":
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
    						var frow=sheetObject.FindText("dataSeq", sheet1_SelectedRow+"");
    						sheet1_OnDblClick(sheetObject, frow, 1);
    					}
    					break;
    				case "btng_controlCancel":
    					cancelControlOption(sheetObject);
    					break;
    			} // end switch
    		//}catch(e) {
    		//	if( e == "[object Error]") {
    		//		ComShowCodeMessage("COM12111");
    		//	} else {
    		//		ComShowMessage(e);
    		//	}
    		//}
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
    		
    		// 속도개선 2014.09.02 (SetColHidden, SetRowHidden)
    		setColHiddenSheet1();
        	setColHiddenSheet2();
        	
    		var sheetResizeFull=true;
    		document_onresize();
    		enableButtons(false);
    		document.form.year.focus();
    		var formObject=document.form;
    		if(isDevMode){
    		}
    		// Using Inquiry by Sub Office popup  on Booking Creation page
            if(pop_vvd != "") {
            	var formObj=document.form;
            	formObj.vvd.value=pop_vvd;
            	formObj.office.value=pop_ofc;
            	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            	ComBtnDisable("btn_save");
            }
            divChkMT.style.display="none";
    	}
    	
        function setColHiddenSheet1(){
        	sheet1.RenderSheet(0);
        	sheet1.SetColHidden("dataSeq",1);
        	sheet1.RenderSheet(1);
        }
        
        function setColHiddenSheet2(){
        	sheet2.RenderSheet(0);
        	for(var p=0 ; p < sizeColName[colSizeIdx[finalIdx]].length + 1 ; p++){
        		sheet2.SetColHidden(preColName[finalIdx]+sizeColName[colSizeIdx[finalIdx]][p],1);
        	}
        	for(var q=0 ; q < sizeColName[colSizeIdx[bkgFirmIdx]].length + 1 ; q++){
        		sheet2.SetColHidden(preColName[bkgFirmIdx]+sizeColName[colSizeIdx[bkgFirmIdx]][q],1);
        	}
        	for(var w=0 ; w < sizeColName[colSizeIdx[guarIdx]].length + 1 ; w++){
        		sheet2.SetColHidden(preColName[guarIdx]+sizeColName[colSizeIdx[guarIdx]][w],1);
        	}
        	if( rmkFlg == "Y"){
        		sheet2.SetColHidden("spc_ctrl_aloc_rmk",0);
        		sheet2.SetColHidden("spc_ctrl_aloc_pol_rmk",0);
        		sheet2.SetColHidden("spc_ctrl_aloc_pod_rmk",0);
        	} else {
        		sheet2.SetColHidden("spc_ctrl_aloc_rmk",1);
        		sheet2.SetColHidden("spc_ctrl_aloc_pol_rmk",1);
        		sheet2.SetColHidden("spc_ctrl_aloc_pod_rmk",1);
        	}       	
        	sheet2.RenderSheet(1);
        }
    	function enableButtons(enable){
    		if(enable){
    			ComBtnEnable("btng_bottleneck");
    			ComBtnEnable("btng_skd");
    			ComBtnEnable("btng_bsa");
    		} else {
    			ComBtnDisable("btng_bottleneck");
    			ComBtnDisable("btng_skd");
    			ComBtnDisable("btng_bsa");
    		}
    	}
      /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    	function initSheet(sheetObj,sheetNo) {
    		var cnt=0;
        	var formObj=document.form;
    		switch(sheetNo) {
    			case 1:	  //sheet1 init
    			    with(sheetObj){
    		      var Head1="SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|";
    		      var HeadTitle0=Head1+"HO Alloc|HO Alloc|HO Alloc|HO Alloc|Load QTA|Load QTA|F'CAST|F'CAST|F'CAST|F'CAST|Office Alloc|Office Alloc|Office Alloc|Office Alloc|BKG|BKG|BKG|BKG|Unallocated\nSpace";
    		      var HeadTitle1=Head1+"VOL|WGT|TS|TS|VOL|CMPB|VOL|WGT|TS|TS|VOL|WGT|TS|TS|VOL|WGT|TS|TS|Unallocated\nSpace| v |v|d|vol|port|hc|45|53'|rf|wgt|flag|status";
    		      var HeadTitle2=Head1+"VOL|WGT| VOL|WGT|VOL|CMPB|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|Unallocated\nSpace| v |v|d|vol|port|hc|45|53'|rf|wgt|flag|status";

    		      //SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:0, PrevColumnMergeMode:0 } );
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
    		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"WEEK",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"VVD",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"alloced_vol",       KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"alloced_wgt",       KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"alloced_ts_vol",    KeyField:0,   CalcLogic:"",   Format:"Float", PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"alloced_ts_wgt",    KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             
    		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
    		             
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		             
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"alloc_vol",         KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"alloc_wgt",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"alloc_ts_vol",      KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"alloc_ts_wgt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		             
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"unallocated",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             
    		             {Type:"Text",      Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_spc_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_port_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_40ft_hc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_45ft_hc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_53ft_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_rf_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_wgt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:isDevMode?0:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"flag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Status",    Hidden:isDevMode?0:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Seq",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dataSeq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    		             {Type:"Text",      Hidden:0, Width:1,    Align:"Right",   ColMerge:0,  SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

    		      InitColumns(cols);
    		      SetHeaderRowHeight(8);
    		      SetFocusEditMode(default_edit_mode);
    		      SetEditable(0);
//    		      SetColHidden("dataSeq",1);
//    		      SetRangeBackColor(1, 2, 1, 36,"#777777");
//    		      SetRangeBackColor(1, 2, 2, 36,"#777777");
    		      SetSheetHeight(ComGetSheetHeight(sheetObj, 7));
    		      }

    				break;
    			case 2:	  //sheet2 init
    			    with(sheetObj){
			        	var HeadTitle0="OCN\nIPC\nT/S|RHQ|Load\nOffice|POL|POD|||||| |Load\nQTA|CMPB|Forecast|Forecast";	//20160120.ADD : 하위 추가
			        	var HeadTitle1="OCN\nIPC\nT/S|RHQ|Load\nOffice|POL|POD|||||| |Load\nQTA|CMPB|CMPB|Volume";
    		        	var HeadTitle2="OCN\nIPC\nT/S|RHQ|Load\nOffice|POL|POD|||||| |Load\nQTA|CMPB|CMPB|Total TEU";
    		        	

    		        	MasterCnt=14;		//20160120.MOD : 9->14
    		        	TailCnt=23; // Adding 1 according to Adding Total TEU
    		        	ColumnCnt=MasterCnt + TailCnt;
    		        	
    		        	var txtDelem="|";
    		            var HeadTypeSize=new Array("TEU|HC|45'|53'|Reefer|WT\n(M/T)","Total TEU|20'|40'|HC|45'|53'|Reefer|WT\n(M/T)") ;
    		            var HeadVolume=new Array("Volume|Volume|Volume|Volume|Volume|WT\n(M/T)", "Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)") ;
    		            
    		        	for(var k=0 ; k < txtHeadItem.length ; k++){
    		        		var colNames=sizeColName[colSizeIdx[k]];
    		        		for(var i=0 ; i < colNames.length ; i++){
    		        			HeadTitle0=HeadTitle0 + txtDelem + txtHeadItem[k];
    		        			ColumnCnt=ColumnCnt + 1;
    		        		}
    		        		HeadTitle1=HeadTitle1 + txtDelem + HeadVolume[colSizeIdx[k]];
    		        		HeadTitle2=HeadTitle2 + txtDelem + HeadTypeSize[colSizeIdx[k]];
    		        	}
    		        	HeadTitle2=HeadTitle2 + "|flg|status|lane|bound|V|V|D|TS|MNG|OFC|lvl1|lvl2|child|leaf|pol|lvl||||Remark|Remark|Remark";
		            	
//						SetConfig( { SearchMode:2, DataRowMerge:0, MergeSheet:7, Page:20 } );
						SetConfig( { SearchMode:2, MergeSheet:5 , DataRowMerge:0, Page:10 } );							//20160118.MOD

    		        	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    		        	var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
    		        	InitHeaders(headers, info);

    		        	var cols = [ //20160120.ADD
    		        	 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d_ioc_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"d_sls_rhq_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"d_sls_ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"d_pol_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"d_pod_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"sls_rhq_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             
    		             {Type:"Text",      Hidden:1, Width:42,   Align:"Center",  ColMerge:1,   SaveName:"",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Int",       Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Int",       Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",                          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fcast_ttl_teu_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 } ];
    		        	
    		        	colTypeIdx=new Array(2, 2, 1, 1, 1, 0, 0, 0);
		            	var sizeColType=new Array(new Array("Integer", "Integer", "Integer", "Integer", "Integer", "Integer"),
		            			new Array("Integer", "Integer", "Integer", "Integer", "Integer", "Integer", "Integer", "Integer"),
		            			new Array("Integer", "Integer", "Integer", "Integer", "Integer", "Integer"));
		            	controlCols=new Array(true, true, true, true, true, true, true, false);
		            	preColName=new Array("fcast", "fnl", "bokg", "usd_bkg", "asgn", "bkg_aval", "gnt","base");
		            	
    		            for(var j=0 ; j < txtHeadItem.length ; j++){
    		            	var colNames=sizeColName[colSizeIdx[j]];
    		            	var colTypes=sizeColType[colTypeIdx[j]];
    		            	for(var m=0 ; m < colNames.length ; m++){//1
    		            		if(controlCols[j]){
    		            			if(j==alocIdx){
     		            			   if(m==0){
     		            				   cols.push({Type:"Float",  Hidden:0, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
       		            			   	}else{	
       		            				   cols.push({Type:"Int",  Hidden:0, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
       		            			   	}
       		            			}else{
      		            			   if(m==0 && j!=fcastIdx){
     		            				   cols.push({Type:"Text",  Hidden:0, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:3,   UpdateEdit:0,   InsertEdit:0 });
       		            			   	}else{       		            				
       		            			   	   cols.push({Type:"Int",  Hidden:0, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
       		            			   	}
       		            			 }    		            		    
    		            		}else{
    		            			if(j==alocIdx){
      		            			   if(m==0){
     		            				   cols.push({Type:"Float",  Hidden:1, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
       		            			   	}else{    		            				
       		            			   		cols.push({Type:"Int",  Hidden:1, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
       		            			   	}
    		            			}else{
       		            			   if(m==0 && j!=fcastIdx){
     		            				   cols.push({Type:"Text",  Hidden:1, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:3,   UpdateEdit:0,   InsertEdit:0 });
       		            			   	}else{    		            				
       		            			   		cols.push({Type:"Int",  Hidden:1, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
       		            			   	}
    		            			}
    		            		}
    		            	}
    		            }		            	
		            	
		            	cols.push({Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mode",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ts_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mnl_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sls_rgn_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl1",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl2",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"child_cnt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"leaf_cnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pol_cnt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lvl",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"tsedit",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_pol_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spc_ctrl_aloc_pod_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,  InsertEdit:1 });
		                cols.push({Type:"Text",      Hidden:0,  Width:1,    Align:"Right",   ColMerge:1,   SaveName:"",                  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		                

    		            InitColumns(cols);
		            	for(var n=0 ; n < sizeColName[colSizeIdx[alocIdx]].length + 1 ; n++){
		            		SetMinimumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][n],0);
		            		SetMaximumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][n],100000);
		            	}


		            	SetEditable(1);
		            	SetImageList(0,"img/nolines_plus.gif");
		            	SetImageList(1,"img/nolines_minus.gif");
//		            	SetEditableColor("#FFFF80FFFFNAN");
		            	
//    		            SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
		            	resizeSheet();
    		            SetFocusEditMode(default_edit_mode);
    		            SetHeaderRowHeight(10);
    		            var backColor="#777777";
//    		            SetRangeBackColor(1, MasterCnt - 1, 2, ColumnCnt - TailCnt - 1,backColor);
//    		            SetRangeBackColor(1, 2, 2, 100,"#777777");
    		            SetClipPasteMode(1);
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
    				formObj.chkTS.checked=true;
    				var param=SpcFormString(formObj,"f_cmd,year,week,duration,vvd,trade,subtrade,lane,bound,office");
    				sheetObj.DoSearch("ESM_SPC_0044GS.do",param, {Sync:2} );
    	    		hiddenMasterCols(sheetObj, document.form, "INIT");
    				//if(sheetObj.RowCount() == 1){
    				//	sheet1_OnDblClick(sheetObj, sheetObj.HeaderRows(), 1);
    				//}
    				break;
    		   case IBSAVE:		//save
   			    if(!validateForm(sheetObj,formObj,sAction)){
   					return false;
   				}
   			    formObj.f_cmd.value=MULTI;
   			    
   			    rows, rowArr, rowCnt = "";
   			    rows = getTransactionColumnText(sheetObj, "U", "mode");
   				rowArr=rows.split(";");
   			    rowCnt=rowArr.length;
   				var chekport=formObj.chkPort.value;
   				for(var i=0 ; i < rowCnt ; i++){
   					var rowInfo=rowArr[i].split("=");
					if(sheetObj.GetCellValue(rowInfo[0]*1, "lvl")*1 < 3){
//						sheetObj.SetRowStatus(rowInfo[0]*1,"I");
//						sheetObj.SetCellValue(rowInfo[0]*1, "Status", "I", 0);
						sheetObj.SetCellValue(rowInfo[0]*1, "ibflag", "I", 0);
					}
   					else if(rowInfo[1] == "I"){
//   						sheetObj.SetRowStatus(rowInfo[0]*1,"I");
//						sheetObj.SetCellValue(rowInfo[0]*1, "Status", "I", 0);
   						sheetObj.SetCellValue(rowInfo[0]*1, "ibflag", "I", 0);
   					}
   				}
   				var param=SpcFormString(formObj,"f_cmd");
   				doSaveSheet(sheetObj, "ESM_SPC_0044GS.do", param);
   				
//   				if(rtn == 0){
//   					for(var j=0 ; j < rowCnt ; j++){
//   						var rowInfo=rowArr[j].split("=");
//   						if(rowInfo[1] == "I"){
//   							sheetObj.SetCellValue(rowInfo[0]*1, "mode","R",0);
//   							sheetObj.SetRowStatus(rowInfo[0]*1,"R");
//   						}
//   					}
//   					var cnt=sizeColName[colSizeIdx[alocIdx]].length - 1;
//   					var frow=sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow+"");
//   					var sumArr=getSum(sheetObj, ":OCN:IPC:T-OCN:T-IPC:", preColName[modelIdx]);
//   					sheetObjects[0].SetCellValue(frow, "alloc_vol",sumArr[0],0);
//   					sheetObjects[0].SetCellValue(frow, "alloc_wgt",sumArr[cnt],0);
//   					sheetObjects[0].SetRowStatus(frow,"R");
//   					var trow=0;
//   					for(var r=0 ; r < Flags.length ; r++){
//   						trow=totalRows[Flags[r]];
//   						if(trow == undefined){
//   							continue;
//   						}
//   						setTotalRowColor(sheetObj, trow);
//   					}
//   				}
   				break;
    			case IBCOPYROW:		// Row copy
    				ComOpenWaitCallFunc("copyModelDataToAlloc()", true);
    				break;
    		   case IBDOWNEXCEL:		//Excel download
    			   sheetObj.Down2Excel({ DownRows:"Visible", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
    			  break;
    		}
    	}
    	
//SAVE 이후 return value로 이후 로직 처리. 기존 로직에서 return value 받지 못해 분리 작업 2014.09.02  	
	    function sheet2_OnSaveEnd(sheet, code, msg) {
	    	if(code == 0){
				for(var j=0 ; j < rowCnt ; j++){
						var rowInfo=rowArr[j].split("=");
						if(rowInfo[1] == "I"){
							sheetObjects[1].SetCellValue(rowInfo[0]*1, "mode", "R", 0);
//							sheetObjects[1].SetRowStatus(rowInfo[0]*1, "R");
							sheetObjects[1].SetCellValue(rowInfo[0]*1, "Status", "R", 0);
						}
					}
					var cnt=sizeColName[colSizeIdx[alocIdx]].length - 1;
					var frow=sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow+"");
					var sumArr=getSum(sheetObjects[1], ":OCN:IPC:T-OCN:T-IPC:", preColName[alocIdx]);
					sheetObjects[0].SetCellValue(frow, "alloc_vol",sumArr[0],0);
					sheetObjects[0].SetCellValue(frow, "alloc_wgt",sumArr[cnt],0);
//					sheetObjects[0].SetRowStatus(frow,"R");
					sheetObjects[0].SetCellValue(frow, "ibflag", "R", 0);
					var trow=0;
				for(var r=0 ; r < Flags.length ; r++){
					trow=totalRows[Flags[r]];
					if(trow == undefined){
						continue;
					}
					setTotalRowColor(sheetObjects[1], trow);
				}
	    	}

            sheet1_OnDblClick(sheet2, sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow+""), 1);
	    }
    	/**
    	 * This method get a status of a transaction.
    	 * and it returns values of a column like below.
    	 * 1=this;3=that;5=Year
    	 * Created by JeongHoon, Kim.
    	 */
    	function getTransactionColumnText(sheetObj, transactionStatus, column){
    		var transactionRows = sheetObj.FindStatusRow(transactionStatus);
    		var arrayTransactionRows = transactionRows.split(";");
    		var returnValue = "";
    		for(i=0;i<arrayTransactionRows.length;i++){
    			var transactionRowNumber = arrayTransactionRows[i];
    			var transactionRowValue = sheetObj.GetCellValue(transactionRowNumber, column);
    			returnValue = returnValue + transactionRowNumber+"="+transactionRowValue+";"
    		}
    		return returnValue;
    	}
    	
    	function copyModelDataToAlloc(){
    		var sheetObj=sheetObjects[1];
    		var rowCnt=sheetObj.RowCount();
    		var cols=TypeSizeCnt + 1;
    		var vals=new Array(new Array(), new Array());
    		var frow=-1;
    		var sRow=sheetObj.HeaderRows();
    		var eRow=sRow + rowCnt - 1;
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
    			setWarnColorTEU(sheetObj, frow, preColName[alocIdx], preColName[guarIdx]);
    		}
    		frow=-1;
    		while((frow=sheetObj.FindText("lvl", "0", frow + 1)) > 0){
    			setTotalRowColor(sheetObj, frow);
            }
    	}
    	var selectedCell_OldValue=0;
    	function sheet2_OnSelectCell(sheetObj, orow, ocol, row, col){
    		if(row > 1){
    			selectedCell_OldValue=sheetObj.GetCellValue(row, col)*1;
    			var status=(sheetObj.GetCellValue(row, "ioc_cd") != null && sheetObj.GetCellValue(row, "ioc_cd").substring(0, 2) == "T-" &&
    					sheetObj.GetCellValue(row, "lvl") == "3" &&
    					sheetObj.GetCellValue(row, "sls_ofc_cd") == document.form.office.value);
//    			btnImgEnable("btng_temp", status);
    			if(status){
    				ComBtnEnable("btng_temp");
    			} else {
    				ComBtnDisable("btng_temp");
    			}
    		}
    	}
    	function sheet2_OnChange(sheetObj, row, col, value){
    		var colName=sheetObj.ColSaveName(col);
    		var pre="";
    		for(var i=0 ; i < preColName.length ; i++){
    			if(colName.substring(0, preColName[i].length) == preColName[i]){
    				pre=preColName[i];
    				break;
    			}
    		}
    		var sizeName=colName.substring(pre.length);
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
    	}
    	function sheet2_OnClick(sheetObj, row, col){
    		
    		var csName = sheetObj.ColSaveName(col);																	//20160120.ADD
    		switch(csName){																							//20160120.MOD
        	case "d_pol_cd":																						//20160120.MOD
        	case "d_pod_cd":
        		var chkpod=document.form.chkPod.checked;
        		var mark=sheetObj.GetCellValue(row, col);
        		var status=sheetObj.GetRowStatus(row);
        		if(mark == "+"){
					var startRow = row + 1;
//					var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
					var endRow = sheetObj.FindText("lvl",(csName == "d_pol_cd") ? "1" : "2" ,startRow,-1,1);		//20160120.MOD
					if(endRow==-1) endRow = sheetObj.LastRow();														//20160120.ADD
					for(;startRow <= endRow-1;startRow++){															//20160120.MOD : endRow-1
	                	sheetObj.SetRowHidden(startRow, 0);
	                	// data selection에서 pod가 선택되지 않은 경우 pol로 열고 닫을 때 풀림 현상 막음 : 20160120.MOD
	                	if (sheetObj.ColSaveName(col) == "d_pol_cd" && (sheetObj.GetCellValue(startRow, "d_pod_cd") == '+' || !chkpod)) {
	                        startRow = sheetObj.FindText("lvl", "2" ,startRow+1,-1,1);
	                        if(startRow==-1) startRow = sheetObj.LastRow();											//20160118.ADD
	                        startRow = startRow-1;
	                    }
					}
       				sheetObj.SetCellValue(row, col, "-", 0);
       				sheetObj.SetCellValue(row, "ibflag", status, 0);
        		}
        		else if(mark == "-"){
					var startRow = row + 1;
//					var endRow = sheetObj.GetMergedEndCell(row, col-1).split(",")[0];
					var endRow = sheetObj.FindText("lvl",(csName == "d_pol_cd") ? "1" : "2" ,startRow,-1,1);		//20160120.MOD
	                if(endRow==-1) endRow = sheetObj.LastRow();														//20160120.ADD
					for(;startRow <= endRow-1;startRow++){															//20160120.MOD
						if(sheetObj.GetCellValue(startRow, "lvl") > 0){												//20160120.ADD
							sheetObj.SetRowHidden(startRow,1);
						}
					}
       				sheetObj.SetCellValue(row, col, "+", 0);
       				sheetObj.SetCellValue(row, "ibflag", status, 0);
        		}
//                sheetObj.SetDataMerge();																			//20160120.MOD
        		break;
        	}
    	}
    	function sheet1_OnDblClick(sheetObj, row, col){
/*    		ComOpenWait(true);
    		setTimeout( function () {*/
	    		var formObj=document.form;
	    		//sheet2.SetEnable(0); 
	    		sheet2.RemoveAll();
	    	    // setting selected current row of the top sheet
	    		setSelectetRow(sheet1, row);
	    		var param=makeDetailParam(sheet1, row);
	    		param=param + "&vsl_cd="+sheet1.GetCellValue(row, "vsl_cd");
	    		param=param + "&skd_voy_no="+sheet1.GetCellValue(row, "skd_voy_no");
	    		param=param + "&skd_dir_cd="+sheet1.GetCellValue(row, "skd_dir_cd");
	    		param=param + "&office="+formObj.office.value;
	    		param=param + "&subtrade="+sheet1.GetCellValue(row, "STRADE");;
	    		sheet2.DoSearch("ESM_SPC_0044GS.do", param, {Sync:2} );
	    		// Checking control option according to the result of searching
	    		checkControlOption();
	    		checkSelectionOption(sheet2);
	    		var tradeParam = sheet1.GetCellValue(row, "TRADE");
	    		tradeParam = tradeParam.substring(0, 1);
	    		hiddenMasterCols(sheet1, formObj, tradeParam);
	    		
	    		hiddenSelectionField(sheet2);
	    		sheet2.RenderSheet(0);
	    		controlTree(sheet2, true);
	    		checkPortcontrolTree(sheet2);
	    		sheet2.RenderSheet(1);
//	    		sheet2.ShowTreeLevel(formObj.chkPort.selectedIndex , 1);
	    		
	    		enableButtons(true);
	    		//sheet2.SetEnable(1);
	    		divChkMT.style.display="none";
/*    	        ComOpenWait(false);
    	     } , 100);*/
    	}
       /**
    	 * handling process for input validation
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		 with(formObj){
    			switch(sAction) {
    				case IBSEARCH:	  //Retrieve
    					if(formObj.vvd.value == "" && comObjects[0].GetSelectText()== ""){
    						ComShowMessage(getMsg("SPC90114", "Trade"));
    			            if(comObjects[0].GetEnable()) comObjects[0].Focus();
    			            else comObjects[1].Focus();//Focusing on SubTrade in case of deactivating trade.
    						return false;
    					}
    			        if(formObj.vvd.value != "" && formObj.vvd.value.length < 9){
    			        	ComShowCodeMessage("COM12174", "VVD", "9");
    			            formObj.vvd.focus();
    			            return false;
    			        }
    	//		        
    			        if(formObj.office.value == ""){
    			            ComShowMessage(getMsg("SPC90114", "ORG"));
    			            if(!formObj.office.disabled){
    				            formObj.office.focus();
    				        }
    			            return false;
    			        }
    					break;
    				case IBSAVE:		//save
    					//POL 단위로 Allocation exceeds allocated volume 체크 
//    					for(var i=3 ; i < sheetObj.RowCount()+3 ; i++){   						
//    				    	if(sheetObj.GetCellValue(i, "lvl") == "2"){
//					    		var nAlocTot = 0;
//					    		var nEditTot = 0;    		
//					    		    						
//		    					for(var j=3 ; j < sheetObj.RowCount()+3 ; j++){
//		    						if(sheetObj.GetCellValue(i, "ioc_cd") == sheetObj.GetCellValue(j, "ioc_cd") && sheetObj.GetCellValue(i, "pol_cd") == sheetObj.GetCellValue(j, "pol_cd") && sheetObj.GetCellValue(j, "lvl") == "2"){
//		    							nAlocTot += sheetObj.GetCellValue(j, "asgn_ttl_qty"); 
//		    							nEditTot  += sheetObj.GetCellValue(j, "bkg_aval_ttl_qty");
//		    						}		    						
//		    					}
//					    		
//					    		if(nEditTot > nAlocTot){					    			
//						    		var strMsg = getMsg("SPC90131") + "[TEU]";
//						    		ComShowMessage(strMsg);
//						    		return false;
//					    		}
//					    	}
//					    }
					    
    				    var rtn=validAllocation(sheetObj, formObj, ":OCN:T-OCN:");
    					if(rtn >= 0){
    						return false;
    					}
    					rtn=validAllocation(sheetObj, formObj, ":IPC:T-IPC:T/S:T-T/S:");
    					if(rtn >= 0){
    						return false;
    					}
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
    function checkPortcontrolTree(sheetObj){
    	var formObj=document.form;
    	var sts1=formObj.chkOfc.checked;
    	var sts2=formObj.chkPol.checked;
    	var sts3=formObj.chkPod.checked;
    	if ( rmkFlg == "Y" ){
	    	if((sts1==true)&& (sts2==true) && (sts3==true) ){
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_rmk",1);
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_pol_rmk",1);
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_pod_rmk",0);
	    	}
	    	if((sts1==true) && (sts2 == false) &&(sts3 == false)){
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_rmk",0);
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_pol_rmk",1);
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_pod_rmk",1);
	    	}
	    	if((sts1==true) && (sts2 == true) &&(sts3 == false)){
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_pol_rmk",0);
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_rmk",1);
	    	    sheetObj.SetColHidden("spc_ctrl_aloc_pod_rmk",1);
	    	}
    	}
    }
        // Displaying selected OCN/IPC of the top sheet according to trade kind
        function hiddenMasterCols(sheetObj, formObj, trade){
        	if(trade != undefined){
        		if(trade == "I"){
        			formObj.chkOCN.checked=false;
        		}
        		else if(trade != "INIT"){
        			formObj.chkIPC.checked=false;
        		}
        	}
        	sheet1.RenderSheet(0);
        	var checked = formObj.chkWT.checked || trade == "INIT";
        	for(var i=0 ; checked && i < weightCols.length ; i++){
        		sheetObj.SetColHidden(weightCols[i],!checked);
        	}
//        	checked = formObj.chkWT.checked || trade == "INIT";
//        	for(var j=0 ; !checked && j < weightCols.length ; j++){
//        		sheetObj.SetColHidden(weightCols[j],!checked);
//        	}
        	checked = formObj.chkWGT.checked || trade == "INIT";
        	for(var k=0 ; k < controlWeightCols.length ; k++){
        		sheetObj.SetColHidden(controlWeightCols[k],!checked);
        	}
        	sheet1.RenderSheet(1);
        }

        function trade_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){  
        	if(newCode == "") return;
        	// sub_trade initialization
        	comObjects[1].SetSelectIndex(0,false);
        	// lane initialization
        	comObjects[2].SetSelectIndex(0,false);
        	
        	var formObj = document.form;
        	var trade = formObj.trade.value;
                	
        	if(trade != null && trade != ''){		
        		SpcSearchOptionSubTrade("subtrade",true,false, "", formObj.trade.value);			// 0207 SHKIM			
        		SpcSearchOptionLane("lane",true,true,'',formObj.trade.value,formObj.subtrade.value,true);	// 0207 SHKIM
        	}	           	
        }         
        function subtrade_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){  
        	if(newCode == "") return;
        	//comObjects[0].SetSelectCode(comObj.GetText(newCode, 0), false);
        	// lane initialization
        	comObjects[2].SetSelectIndex(0, false);
        	
    		var formObj = document.form;
    		var subtrade = formObj.subtrade.value;
    	
    		if(subtrade != null && subtrade != ''){		
    			SpcSearchOptionLane("lane",true,true,'',formObj.trade.value,formObj.subtrade.value,true);	// 0207 SHKIM
    		}	           	
        } 
        function lane_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
        	if(newCode == "" ) return;
        	var repTrade=comObj.GetText(newCode,0);  
        	var subTrade=comObj.GetText(newCode,1);
        	//comObjects[0].SetSelectCode(repTrade,false);
        	//comObjects[1].SetSelectCode(subTrade,false);
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
        function optionSetting() {
        	SpcSearchOptionYear("year");
        	SpcSearchOptionWeek("week");
        	SpcSearchOptionDuration("duration", 5, 5);
        	SpcSearchOptionTrade("trade", true, true);
        	SpcSearchOptionSubTrade("subtrade", true, true);
        	SpcSearchOptionLane("lane");
        	SpcSearchOptionBound("bound");
        } 
//        function toggleSheetSize_Edit(){
//        	var objID = document.getElementByID("mainTable1");
//        	if(objID == "mainTable1"){
//	        	var obj = ComGetEvent();
//	        	var status="N";
//	        	if(obj.maxStatus == undefined || obj.maxStatus == "N"){
//	        		status="M";
//	        	}
//	        	if(status == "M"){
//	    			//tables[i].orgDisplay=tables[i].style.display;
//	    			objID.style.display="none";
//	    			var sizeHeight=document.body.clientHeight - posTop - etcHeight - 20;
//	    			sheetObj.SetSheetHeight(sizeHesheet1_OnDblClick(sheetObj, sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow+""), 1);ight);
//	        		obj.maxStatus="M";
//	    		}
//	        	else{
//	        		sheetObj.SetSheetHeight(area.sheetHeight);
//	        		obj.maxStatus="N";
//	        	}
//        	}
//        	
////        	var obj = ComGetEvent();
////        	var status="N";
////        	if(obj.maxStatus == undefined || obj.maxStatus == "N"){
////        		status="M";
////        	}
////
////        	var sheetId=obj.getAttributeNode("sheetId").value;
////
////        	//var type=obj.type;
////        	//if(sheetId == undefined || type == undefined) return;
////        	if(sheetId == undefined ) return;
////        	var sheetObj=eval(sheetId);
////        	var isSheet=(( sheetObj) || ( sheetObj.IBSheetVersion)) ;
////        	var curRow=0;
////        	if(isSheet){
////        		curRow=sheetObj.GetSelectRow();
////        	}
////        	var area=obj;
////        	while((area.tagName != "TABLE" || area.className != "search") && area != document){
////        		area=area.parentElement;
////        	}
////        	if(area.parentElement.tagName == "DIV"){
////        		area=area.parentElement;
////        	}
////        	var main=area.parentElement;
////        	var tables=main.children;
////        	var titleArea=tables[1];
////        	var posTop=0;
////        	for(var i=0 ; i < tables.length ; i++){
////        		if(tables[i].className == "title" || tables[i].className == "button"){
////        			posTop=posTop + tables[i].offsetHeight;
////        			continue;
////        		}
////        		if(tables[i] == area){
////        			continue;
////        		}		
////        		if(status == "M"){
////        			tables[i].orgDisplay=tables[i].style.display;
////        			tables[i].style.display="none";
////        		}
////        		else{
////        			tables[i].style.display=tables[i].orgDisplay;
////        		}
////        	}
////        	if(status == "M"){
////        		var etcHeight=area.offsetHeight - sheetObj.offsetHeight;
////        		var copyArea=main.parentElement.parentElement.parentElement;
////        		var sizeHeight=document.body.clientHeight - posTop - etcHeight - 20;
////        		area.sheetHeight=sheetObj.GetSheetHeight();
////        		sheetObj.SetSheetHeight(sizeHeight);
////        		obj.maxStatus="M";
////        		obj.src="/opuscntr/img/bu_prev01.gif";
////        	}
////        	else{
////        		sheetObj.SetSheetHeight(area.sheetHeight);
////        		obj.maxStatus="N";
////        		obj.src="/opuscntr/img/bu_next01.gif";
////        	}	currSheet=sheetObj;
////        	if(isSheet){
////        		setTimeout("scrollToCurRow()", 1);
////        	}
//        }
        
        /**
         * This method counts numbers again.
         * @param Col
         * @param SortArrow
         */
        //2014.08.06 김용습 - 정렬시 SEQ. 무너지는 버그 해결하기 위해 추가한 메소드
        function sheet1_OnSort(Col, SortArrow){
        	sheet1.ReNumberSeq();
        }
        
        /**
         * Editable cell 배경색 변경 부분
         * @param row
         * 2014.09.05 김성욱
         */
        function sheet2_OnRowSearchEnd( row ) {
        	var colNum = sheet2.GetLastChildRow( row ); //해당 row의 column 갯수
        	//colNum = sheet2.GetChildNodeCount( row );
        	colNum = 90;
        	var rowNum = sheet2.RowCount(row);
        	rowNum += 3;
        	for( var x=0 ; x<colNum ; x++ ) {
        		var isEditable = sheet2.GetCellEditable( rowNum , x );//해당 셀이 수정 가능한지 //sheet2.GetColEditable( x ); //해당 컬럼이 수정 가능한지 
        		if( isEditable == 1 ) {
        			sheet2.SetCellBackColor( rowNum , x , "#FFFF00" );
        		}
        	}
        }
        // unallocated 물량 계산 
        function sheet1_OnSearchEnd( sheetObj , code , msg){
        	var formObj=document.form;
//        	fcastType=formObj.fcast.value;
        	
        	
			var cnt = sheetObj.RowCount();
			var cnt = cnt + 3;

			for(var i=3 ; i < cnt ; i++){
				var alloc_vol = sheetObj.GetCellValue(i, "alloc_vol")*1;
				var alloc_ts_vol = sheetObj.GetCellValue(i, "alloc_ts_vol")*1;
				var alloced_vol = sheetObj.GetCellValue(i, "alloced_vol")*1;
				var alloced_ts_vol = sheetObj.GetCellValue(i, "alloced_ts_vol")*1;
				var val = "";
				if(sheetObj.GetCellValue(i, "TRADE").substring(0, 1) == "I"){
					
					val = alloced_vol + alloced_ts_vol - alloc_vol - alloc_ts_vol;

				} else {
					val = alloced_vol - alloc_vol;
				}
				sheetObj.SetCellValue(i, "unallocated", val, 0);
            }
			hiddenMasterCols(sheetObj, formObj, "INIT");
			//Retrieving the bottom data instantly in case numbers of retrieved data counting is 1
			//if(sheetObj.RowCount()== 1){
			//	sheet1_OnDblClick(sheet1, sheet1.HeaderRows(), 1);
			//}
			
        }
        
        function resizeSheet(){
            ComResizeSheet(sheetObjects[1]);
        }