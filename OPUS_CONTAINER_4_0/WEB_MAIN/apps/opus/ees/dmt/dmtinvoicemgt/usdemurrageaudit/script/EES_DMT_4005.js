/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4005.js
*@FileTitle  : 3rd Party DEM/DET Collection Audit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var IBLOADEXCEL=10000;
	var IBAUDIT=10001;
    var COMMON_TARIFF_CD="common_tariff_cd"; 
    var ROWMARK="|";
    var FIELDMARK="=";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return;
			switch(srcName) {
 				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break; 					
 				case "btn_loadexcel":
 					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
 					break;
 				case "btn_audit":
 					doActionIBSheet(sheetObject1, formObject, IBAUDIT);
					break;
 				case "btn_downexcel":
 					if(sheetObject1.RowCount() < 1){//no data						
 						ComShowCodeMessage("COM132501");
 					}else{
 						if(sheetObject1.RowCount() < 1){//no data
 							ComShowCodeMessage("COM132501");
 							}else{
 								sheetObject1.Down2Excel({ HiddenColumn:{HiddenColumn:true}});
 							}
 					}
 					break;
 					//alert("[btn_downexcel]"+sheetObject1.RowCount);
 					/*if(sheetObject1.RowCount()== 0){
 						//SAMPLE SHEET
 						sheetObject1.DataInsert();
 						var loadOpt=formObject.load_opt_input.value;
 						if(loadOpt == '1'){  							
//parameter changed[check again]CLT  							sheetObject1.Down2Excel({ HiddenColumn:{HiddenColumn:true});
							//"seq|audit_result|cntr_tpsz_cd|cal_from_dt|cal_to_dt|cal_ft_end|cal_over|cal_from_dt|curr_cd|cal_collection|fm_mvmt_yd_cd|ft_cmnc_dt|ft_dys|sc_no|rfa_no|exception_amt|aft_expt_amt|bkg_no|bl_no|dmdt_chg_sts_cd");
 						} else if(loadOpt == '2'){  							
//parameter changed[check again]CLT  							sheetObject1.Down2Excel({ HiddenColumn:{HiddenColumn:true});
							//"seq|audit_result|cntr_tpsz_cd|cal_from_dt|cal_to_dt|cal_ft_end|cal_over|cal_from_dt|curr_cd|cal_collection|fm_mvmt_yd_cd|ft_cmnc_dt|ft_dys|sc_no|rfa_no|exception_amt|aft_expt_amt|vvd|bkg_no|dmdt_chg_sts_cd");
 						} else if(loadOpt == '3'){  							
//parameter changed[check again]CLT  							sheetObject1.Down2Excel({ HiddenColumn:{HiddenColumn:true});
							//"seq|audit_result|cntr_tpsz_cd|cal_from_dt|cal_to_dt|cal_ft_end|cal_over|cal_from_dt|curr_cd|cal_collection|fm_mvmt_yd_cd|ft_cmnc_dt|ft_dys|sc_no|rfa_no|exception_amt|aft_expt_amt|vvd|bl_no|dmdt_chg_sts_cd");
 						}
 						sheetObject1.RemoveAll();
 					} else {  						
//parameter changed[check again]CLT  						sheetObject1.Down2Excel({ HiddenColumn:{HiddenColumn:true}});
 					}					
 					break;*/		
 				case "btn_ofc":
 					openPopup('by_ofc');
 					break;	
 				case "btn_bkg":
 					openPopup('by_bkg');
 					break;
 				case "btn_cntr":
 					openPopup('by_cntr');
 					break;
 				case "btn_mvmt":
 					openPopup('mvmt_inq');
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
      * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
      */
	function setSheetObject(sheet_obj){
    	  sheetObjects[sheetCnt++]=sheet_obj;
	}
    /** 
   	 * Register as an array IBCombo Object
  	 * param : combo_obj ==> combo object
  	 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
  	 * Array defined at the top of the source
   	 */ 
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++]=combo_obj;
  	}
     /**
      * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
      */
	function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
  		for(var k=0;k<comboObjects.length;k++){
  			initCombo(comboObjects[k],k+1);
  		}
		initControl();
  		buttonMode("NEW");
  //no support[check again]CLT 		sheet1_OnLoadFinish();
  		combo1.SetBackColor("#CCFFFD");
  		combo2.SetBackColor("#CCFFFD");
  		//comboObjects[1].Enable = false;
	}
    function initControl() {
//		axon_event.addListenerFormat('keypress','obj_keypress', document.form);
		axon_event.addListener('mouseover', 'obj_mouseover',	'btn_ofc');	
		axon_event.addListener('mouseout',	'obj_mouseout',		'btn_ofc');	
	}  
    function obj_mouseover() {
 		var msg='';
 		var x=event.x+document.body.scrollLeft;
 		var y=event.y+document.body.scrollTop;
     	switch(event.srcElement.id){
      		case 'btn_ofc':
      			msg="Retrieve Coincidence only in Charge Calculation by Office/VVD";
      			x=x;
      			y=y-20;
      			break;
     	}
 		var bak='lightyellow';
 		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
 						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
 		var skn=document.all("topdeck").style;
	 		skn.left=x;
	 		skn.top=y;
	 		document.all("topdeck").innerHTML=content;
	 		skn.visibility='visible';
	}
    function obj_mouseout() {
		var skn=document.all("topdeck").style;
		skn.visibility='hidden';
	}
	/**
	  * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
	  */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
		var sheetID=sheetObj.id;
	    switch(sheetID) {	
	    	case "sheet1":
	    	    with(sheetObj){			            
                var HeadTitle="||Seq.|Audit Result|CNTR No.|T/S|T From DT|T To DT|T F/Time End|T Over|Collection|From Date|To Date|F/Time End|Over|Cur.|Billable AMT|From Yard|F/Time CMNC|F/T|S/C No.|RFA No.|Exception AMT|Discount AMT|VVD CD|BKG No.|B/L No.|STS";
                HeadTitle += "|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq";
                HeadTitle += "|p_load_opt_input|p_ofc_cd|p_dmdt_trf_cd|p_fm_mvmt_yd_cd";
                var headCount=ComCountHeadTitle(HeadTitle);
                SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:5, Page:20, DataGetGetRowMerge:1 } );
                var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers=[ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"chk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"audit_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"t_from_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"t_to_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"t_ft_end",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"t_over",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"t_collection",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cal_from_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cal_to_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cal_ft_end",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cal_over",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"cal_collection",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"exception_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p_load_opt_input",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p_dmdt_trf_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p_fm_mvmt_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                InitColumns(cols);
                FrozenCols=SaveNameCol("cntr_tpsz_cd");
                var color_show="#4F93E8";
                //SetConfig( { SearchMode:2, FrozenCol:savenamecol("cntr_tpsz_cd"), DataRowMerge:0 } );
                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ ];
                InitHeaders(headers, info);
                var cols = [  ];
                InitColumns(cols);
                SetEditable(0);
                SetCellBackColor(0,"cntr_no",color_show);
                SetCellBackColor(0,"t_from_dt",color_show);
                SetCellBackColor(0,"t_to_dt",color_show);
                SetCellBackColor(0,"t_ft_end",color_show);
                SetCellBackColor(0,"t_over",color_show);
                SetCellBackColor(0,"t_collection",color_show);
                SetCellBackColor(0,"vvd",color_show);
                SetSheetHeight(430);
	          	}
	    		break;
	     }
	}
	/**
  	 * Combo basic setting 
  	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
  	 * If the number of combo a combo by adding the number of case sheets to initialize the module configuration
  	 */ 
	function initCombo(comboObj, comboNo) {
  	    var formObject=document.form
  	    switch(comboNo) { 
  	    	case 1: 
	        	with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "0");
					SetColAlign(0, "1");
//					SetColWidth(0, "0");
//					SetColWidth(0, "1");
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
					SetDropHeight(160);
					ValidChar(2);		
					//no support[check again]CLT 					IMEMode=0;
		    	}  	        	  
	        	//alert("[office comboList]"+comboNo+comboObj.id);
				//doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
				break;   	    
  	    	case 2: 
  	        	with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "0");
					SetColAlign(0, "1");
					SetColWidth(0, "0");
					SetColWidth(0, "1");
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
					SetDropHeight(160);
					ValidChar(2);		
					//no support[check again]CLT 					IMEMode=0;
  		    	}
  	        	//alert("[tariff comboList]"+comboNo+comboObj.id);
  	        	//doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC02,comboObj);
  	        	break;
  	    	case 3:
   	    		with (comboObj) { 
   	    			SetMultiSelect(0);
  					SetUseAutoComplete(0);
					SetColAlign(0, "0");
					SetColWidth(0, "0");
	    			SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					SetDropHeight(160);
  					//no support[check again]CLT 					IMEMode=0;
  					ValidChar(2,1);	
					SetMaxLength(2);
   		    	}
   	    		break;
  	     } 
	//no support[check again]CLT 	
//no support[check again]CLT 	function sheet1_OnLoadFinish() {
  		var formObj=document.form
  		sheetObjects[0].SetWaitImageVisible(0);
  		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
  		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);
        sheetObjects[0].SetWaitImageVisible(1);
  	}   
// 	function obj_keyup() {
// 		var srcObj=event.srcElement;
// 		checkLocYdCd(srcObj);
// 	}
	function checkLocYdCd(srcObj) {
 		var formObj=document.form;
 		var cd=ComTrim(ComGetObjValue(srcObj));
 		if (cd.length == 5) {
 			var comboObj=comboObjects[2];
 			formObj.yd_cd1.value=cd;
 			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03, comboObj);
 		}
 	}
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		var loadOptInput=formObj.load_opt_input.value;
        switch(sAction) {
    		//Office comboList	
    		case IBSEARCH_ASYNC01:    
				formObj.f_cmd.value=SEARCHLIST02;				 	    	    
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    sComboObj.RemoveAll();
	    	    if (sXml != undefined && sXml != '') {
		    	    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
		    	    var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
		    	    var comboCodeArr=ofc_cds.split("|");			    	    
		    	    var comboTextArr=ofc_nms.split("|");
		    	    for (var i=0 ; i < comboTextArr.length ; i++) {
		    	    	sComboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
		         	}
	    	    }
	    	    if(loadOptInput == '1'){
	    	  		var usr_ofc_cd=formObj.usr_ofc_cd.value;
	    	  		sComboObj.SetSelectCode(usr_ofc_cd);
	    	  		if(sComboObj.GetSelectCode()!= usr_ofc_cd) {
	    	  			sComboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
	    	  			sComboObj.SetSelectCode(usr_ofc_cd);
	    	  		}
	    	    }
	    	    break;
	    	//Tariff type comboList
    		case IBSEARCH_ASYNC02:     
				formObj.f_cmd.value=SEARCHLIST; 				
				var xmlStr=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				sComboObj.RemoveAll();
				var data=ComGetEtcData(xmlStr, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems=data.split(ROWMARK);
					addComboItem(sComboObj,comboItems);
					comboItem=comboItems[0].split(FIELDMARK);
				}	
				sComboObj.SetSelectText('DMIF');
				break;	
			//From Yard Code comboList
    		case IBSEARCH_ASYNC03:  
    			formObj.f_cmd.value=SEARCH14; 	    	    
    			var xmlStr=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
    			sComboObj.RemoveAll();
    			var comboDatas=ComGetEtcData(xmlStr, "YD");
 	        	if (comboDatas != undefined && comboDatas != '') {
					comboItems=comboDatas.split(ROWMARK);
					addComboItem(sComboObj, comboItems);
				} else {
					sheetObj.SetWaitImageVisible(1);
					ComShowCodeMessage('DMT00110', "Yard");
					formObj.yd_cd.focus();
					return;
				}
    			break;
        }
		sheetObj.SetWaitImageVisible(1);
    }	
	function addComboItem(comboObj,comboItems) {
		var comboID=comboObj.options.id;
		switch(comboID) {		
			case "combo2":
			   	for (var i=0 ; i < comboItems.length ; i++) {
			   		var comboItem=comboItems[i].split(FIELDMARK);
					comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
			   	}   
			   	break;
			case "combo3":
				for (var i=0 ; i < comboItems.length ; i++) {
  		    		var comboItem=comboItems[i].split(FIELDMARK);
  					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
  		    	}
  				break;			   	
		}			   	
	}			
   /**
    * Sheet processing-related processes
    */		
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
    	switch(sAction){
    		case IBCLEAR:        
    			initSearchControls("NEW");
				buttonMode("NEW");
				break;
    		case IBLOADEXCEL:        
    			if(!validateForm(sheetObj,formObj,sAction)) return;
    			//ComOpenWait Start
				sheetObj.SetWaitImageVisible(0);
		        ComOpenWait(true);
		        sheetObj.RemoveAll();
		        sheetObj.LoadExcel();
    			//ComOpenWait End
				ComOpenWait(false);
    			var totRowCnt=sheetObj.RowCount();
    			if(totRowCnt > 0){
    				buttonMode("LOAD_EXCEL");
    			} 
				break;
    		case IBAUDIT:
    			if(!validateForm(sheetObj,formObj,sAction)) return;
    			//ComOpenWait Start
				sheetObj.SetWaitImageVisible()(0);
		        ComOpenWait(true);
    			formObj.f_cmd.value=MULTI;
    			//sheetObj.ShowDebugMsg = true;
				sheetObj.DoAllSave("EES_DMT_4005GS.do", FormQueryString(formObj));
	   			//sheetObj.ShowDebugMsg = false;
				//ComOpenWait End
				ComOpenWait(false);
				buttonMode("AUDIT");
				break;
    	}
	}
	function initSearchControls(mode) {
		var formObj=document.form;
		if(mode == "NEW"){
			formObj.tot_cntr.value="";
			formObj.tot_amt.value="";
			formObj.c_cntr.value="";
			formObj.c_amt.value="";
			formObj.d_cntr.value="";
			formObj.d_amt.value="";
			sheetObjects[0].RemoveAll();
			formObj.load_opt.value='1';
			load_change();
		}
	}    
	/**
	 * BUTTON MODE
	 */
	function buttonMode(mode) {
		 var formObj=document.form;
		 if(mode == "NEW"){
			with (formObj) {
				ComEnableManyObjects(true, load_opt, yd_cd);
				ComEnableManyObjects(false, result_opt);
				comboObjects[0].SetEnable(1);
				comboObjects[1].SetEnable(1);
				comboObjects[2].SetEnable(1);
				DmtComEnableManyBtns(true,  "btn_new", "btn_loadexcel", "btn_downexcel");
				DmtComEnableManyBtns(false, "btn_audit", "btn_ofc", "btn_bkg", "btn_cntr", "btn_mvmt");
				ComSetObjValue(button_mode, "NEW");
				ComSetObjValue(result_opt,  "All");
				formObj.load_opt.className='input1';
				formObj.yd_cd.className='input';
			}
		 } else if(mode == "LOAD_EXCEL"){
			 with (formObj) {
					ComEnableManyObjects(false, load_opt, yd_cd, result_opt);
					comboObjects[0].SetEnable(0);
					comboObjects[1].SetEnable(0);
					comboObjects[2].SetEnable(0);
					DmtComEnableManyBtns(true, 	 "btn_new", "btn_audit", "btn_downexcel");	
					DmtComEnableManyBtns(false,  "btn_loadexcel", "btn_downexcel", "btn_ofc", "btn_bkg", "btn_cntr", "btn_mvmt");
					ComSetObjValue(button_mode, "LOAD_EXCEL");
					formObj.load_opt.className='input1';
					//회색바탕 readOnly
					formObj.yd_cd.className='input2';
				}
		 } else if(mode == "AUDIT"){
			 with (formObj) {
					ComEnableManyObjects(false, load_opt, yd_cd);
					ComEnableManyObjects(true, result_opt);
					comboObjects[0].SetEnable(0);
					comboObjects[1].SetEnable(0);
					comboObjects[2].SetEnable(0);
					DmtComEnableManyBtns(true, 	 "btn_new", "btn_downexcel", "btn_ofc", "btn_bkg", "btn_cntr", "btn_mvmt");	
					DmtComEnableManyBtns(false,  "btn_audit", "btn_loadexcel");
					ComSetObjValue(button_mode, "AUDIT");
					formObj.load_opt.className='input1';
					//회색바탕 readOnly
					formObj.yd_cd.className='input2';
					formObj.result_opt.className='input';    
				}
		 }
	} 
	/**
      * Screen input form validation process for handling
      */
	function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
			ComSetObjValue(ofc_cd, 			comboObjects[0].GetSelectCode());
			ComSetObjValue(dmdt_trf_cd, 	comboObjects[1].GetSelectText());
			ComSetObjValue(fm_mvmt_yd_cd, 	ComGetObjValue(yd_cd)+comboObjects[2].GetSelectText());
			var ofcCd=ComGetObjValue(ofc_cd);
			var dmdtTrfCd=ComGetObjValue(dmdt_trf_cd);
			var fmMvmtYdCd=ComGetObjValue(fm_mvmt_yd_cd);
			var loadOptInput=ComGetObjValue(load_opt_input);
			if(loadOptInput == 1 || loadOptInput == 2 || loadOptInput == 3){
				if(ofcCd == ''){
					ComShowCodeMessage('DMT02002', 'Office');
					sheetObjects[0].RemoveAll();
					buttonMode("NEW");
					return false;
				}
				if(dmdtTrfCd == ''){
					ComShowCodeMessage('DMT02002', 'Tariff Type');
					sheetObjects[0].RemoveAll();
					buttonMode("NEW");
					return false;
				}
			} 
//			if(loadOptInput == 1){
//				if(fmMvmtYdCd == ''){
//					ComShowCodeMessage('DMT02002', 'From Yard');
//					sheetObjects[0].RemoveAll();
//					buttonMode("NEW");
//					return false;
//				}
//			} 
			switch(sAction) {
				case IBAUDIT:
					var totRowCnt=sheetObj.RowCount();
					if(totRowCnt == 0) return false;
					ComOpenWait(true);
					for(var i=1; i <= totRowCnt; i++) {
						if(loadOptInput == 1){
							if( sheetObj.GetGetCellValue(i, "cntr_no") == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'Container No');
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
//							if( sheetObj.CellValue(i, "t_collection")      == '' ){
//								ComShowCodeMessage('DMT03033', 'Collection');
//								sheetObjects[0].RemoveAll();
//								buttonMode("NEW");
//								return false; 
//							}
							if( sheetObj.GetGetCellValue(i, "vvd") == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'VVD');
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
						} else if(loadOptInput == 2){
							if( sheetObj.GetGetCellValue(i, "cntr_no") == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'Container No');
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
//							if( sheetObj.CellValue(i, "t_collection")      == '' ){
//								ComShowCodeMessage('DMT03033', 'Collection');
//								sheetObjects[0].RemoveAll();
//								buttonMode("NEW");
//								return false; 
//							}
							if( sheetObj.GetGetCellValue(i, "bl_no") == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'B/L No');
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
						} else if(loadOptInput == 3){
							if( sheetObj.GetGetCellValue(i, "cntr_no") == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'Container No');
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
//							if( sheetObj.CellValue(i, "t_collection")      == '' ){
//								ComShowCodeMessage('DMT03033', 'Collection');
//								sheetObjects[0].RemoveAll();
//								buttonMode("NEW");
//								return false; 
//							}
							if( sheetObj.GetGetCellValue(i, "bkg_no") == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'BKG No');
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
						}
						sheetObj.SetCellValue(i, "p_load_opt_input",loadOptInput);
						sheetObj.SetCellValue(i, "p_ofc_cd",ofcCd);
						sheetObj.SetCellValue(i, "p_dmdt_trf_cd",dmdtTrfCd);
						sheetObj.SetCellValue(i, "p_fm_mvmt_yd_cd",fmMvmtYdCd);
					} //End of for Loop
					ComOpenWait(false);
					break;
			} // End of the switch
    	  } // End of the with clause
    	  return true;
	}
	function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg){
		ComOpenWait(false);// always exist at first line
		 if(Code == 0){
		  ComShowCodeMessage("COM132601");
		}
		if(ErrMsg != ''){
			return;
		}
		//ComOpenWait(true);
		var formObject=document.form;
		var totCntr=0;
		var totAmt=0;
		var cCntr=0;
		var cAmt=0;
		var dCntr=0;
		var dAmt=0;
		with(sheetObj){
			var color_show="#4F93E8";
			for(var i=sheetObj.GetGetTopRow()(); i <= sheetObj.SearchRows()(); i++) {
				var auditResult="";
						if(sheetObj.GetGetCellValue(i, "t_from_dt") != ''){
						if(sheetObj.GetGetCellValue(i, "t_from_dt") != sheetObj.GetGetCellValue(i, "cal_from_dt")){
						SetCellBackColor(i, "t_from_dt",color_show);
						if(auditResult == ''){
							auditResult="Discrepancy";
						}
					}
				}
						if(sheetObj.GetGetCellValue(i, "t_to_dt") != ''){
						if(sheetObj.GetGetCellValue(i, "t_to_dt") != sheetObj.GetGetCellValue(i, "cal_to_dt")){
						SetCellBackColor(i, "t_to_dt",color_show);
						if(auditResult == ''){
							auditResult="Discrepancy";
						}
					}
				}
						if(sheetObj.GetGetCellValue(i, "t_from_dt") != ''){
						if(sheetObj.GetGetCellValue(i, "t_from_dt") != sheetObj.GetGetCellValue(i, "cal_from_dt")){
						SetCellBackColor(i, "t_from_dt",color_show);
						if(auditResult == ''){
							auditResult="Discrepancy";
						}
					}
				}
						if(sheetObj.GetGetCellValue(i, "t_ft_end") != ''){
						if(sheetObj.GetGetCellValue(i, "t_ft_end") != sheetObj.GetGetCellValue(i, "cal_ft_end")){
						SetCellBackColor(i, "t_ft_end",color_show);
						if(auditResult == ''){
							auditResult="Discrepancy";
						}
					}
				}
						if(sheetObj.GetGetCellValue(i, "t_over") != ''){
						if(sheetObj.GetGetCellValue(i, "t_over") != sheetObj.GetGetCellValue(i, "cal_over")){
						SetCellBackColor(i, "t_over",color_show);
						if(auditResult == ''){
							auditResult="Discrepancy";
						}
					}
				}
						if(sheetObj.GetGetCellValue(i, "t_collection") != ''){
						if(sheetObj.GetGetCellValue(i, "t_collection") != sheetObj.GetGetCellValue(i, "cal_collection")){
						SetCellBackColor(i, "t_collection",color_show);
						if(auditResult == ''){
							auditResult="Discrepancy";
						}
					}
				}
				if(auditResult == ''){
					auditResult="Coincidence";
				}
					sheetObj.SetCellValue(i, "audit_result",auditResult);
					if(sheetObj.GetGetCellValue(i, "audit_result") == "Coincidence" ){
					totAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
					cAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
					totCntr	+= 1;
					cCntr 	+= 1;
				}else if(sheetObj.GetGetCellValue(i, "audit_result") == "Discrepancy" ){
				totAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
				dAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
					totCntr	+= 1;
					dCntr 	+= 1;
				}
				formObject.tot_amt.value=ComAddComma2(ComRound(totAmt, 2)+'', "#,###.00");
				formObject.tot_cntr.value=totCntr;
				formObject.c_amt.value=ComAddComma2(ComRound(cAmt, 2)+'', "#,###.00");
				formObject.c_cntr.value=cCntr;
				formObject.d_amt.value=ComAddComma2(ComRound(dAmt, 2)+'', "#,###.00");
				formObject.d_cntr.value=dCntr;
			} //End of the for loop
		}		
	}
	function sub_load_opt01() {
	    var optColor=document.createElement("OPTION");
	    optColor.text="VVD CD";
	    optColor.value="1";
	    document.form.load_opt.add(optColor);
	}
	function sub_load_opt02() {	
	    var optColor=document.createElement("OPTION");
	    optColor.text="B/L No";
	    optColor.value="2";	    
	    document.form.load_opt.add(optColor);	
	}
	function sub_load_opt03() {	
	    var optColor=document.createElement("OPTION");
	    optColor.text="BKG No";
	    optColor.value="3";	    
	    document.form.load_opt.add(optColor);	
	}
	function sub_load_delAll() {
	    if ( eval(document.form.load_opt.options.length) > 0 ) {
	        for (i=0 ; eval(document.form.load_opt.options.length) ; i++)
	        {
	            var selCh=document.form.load_opt.children(0);
	            document.form.load_opt.removeChild(selCh);
	        }
	    }
	}
	function load_change(){   
    	var formObj=document.form;
    	var loadOpt=formObj.load_opt.value;
    	if(loadOpt == '1'){
    		sheetObjects[0].RemoveAll();
			load_option_grid('1');
			formObj.load_opt_input.value="1";
			resetSearchControls(loadOpt);
		} 
    } 
    function resetSearchControls(load_status){   
    	var formObj=document.form;
    	//office code reset
    	formObj.ofc_cd.value="";
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
		//tariff type code reset
		formObj.dmdt_trf_cd.value="";
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);
		//yard code reset
		formObj.yd_cd.value="";
		formObj.yd_cd1.value="";
		formObj.fm_mvmt_yd_cd.value="";
		comboObjects[2].RemoveAll();
    }
    function result_opt_change(){   
    	var formObj=document.form;
    	var result_opt=formObj.result_opt.value;
    	var totCntr=0;
		var totAmt=0;
		var cCntr=0;
		var cAmt=0;
		var dCntr=0;
		var dAmt=0;
    	var sheetObj=sheetObjects[0];
		with(sheetObj)
		{
			for(var i=1; i <= sheetObj.RowCount(); i++) {
				if(result_opt == 'All'){
					//alert(result_opt);
					sheetObj.SetRowHidden(i,0);
					if(sheetObj.GetGetCellValue(i, "audit_result") == "Coincidence" ){
					totAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
					cAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
						totCntr	+= 1;
						cCntr 	+= 1;
						}else if(sheetObj.GetGetCellValue(i, "audit_result") == "Discrepancy" ){
						totAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
						dAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
						totCntr	+= 1;
						dCntr 	+= 1;
					}
				} else if(sheetObj.GetGetCellValue(i, "audit_result") != result_opt){
					//alert(result_opt);
					sheetObj.SetRowHidden(i,1);
					totAmt 	+= 0;
					cAmt 	+= 0;
					totCntr	+= 0;
					cCntr 	+= 0;
				} else {
					//alert(result_opt);
					sheetObj.SetRowHidden(i,0);
					if(sheetObj.GetGetCellValue(i, "audit_result") == "Coincidence" ){
					totAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
					cAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
						totCntr	+= 1;
						cCntr 	+= 1;
				}else if(sheetObj.GetGetCellValue(i, "audit_result") == "Discrepancy" ){
				totAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
				dAmt 	+= parseFloat(sheetObj.GetGetCellValue(i, "t_collection"));
						totCntr	+= 1;
						dCntr 	+= 1;
					}
				} 
				formObj.tot_amt.value=ComAddComma2(ComRound(totAmt, 2)+'', "#,###.00");
				formObj.tot_cntr.value=totCntr;
				formObj.c_amt.value=ComAddComma2(ComRound(cAmt, 2)+'', "#,###.00");
				formObj.c_cntr.value=cCntr;
				formObj.d_amt.value=ComAddComma2(ComRound(dAmt, 2)+'', "#,###.00");
				formObj.d_cntr.value=dCntr;
			} //End of the for loop
		}
    } 	
    function load_opt_change(){   
    	sheetObjects[0].RemoveAll();
    	var formObj=document.form;
        var loadOption=formObj.load_opt.value;   
        formObj.load_opt_input.value=loadOption;
        load_option_grid(loadOption);
    }    
    function load_option_grid(loadOption){   
    	var color_show="#4F93E8";
    	var color_hide="#000000";
    	if(loadOption == '1'){
    		//alert("load_option_grid01");
    		sheetObjects[0].SetCellBackColor(0, "vvd",color_show);
			sheetObjects[0].SetCellBackColor(0, "bl_no",color_hide);
			sheetObjects[0].SetCellBackColor(0, "bkg_no",color_hide);
    	} else if(loadOption == '2'){
    		//alert("load_option_grid02");
    		sheetObjects[0].SetCellBackColor(0, "vvd",color_hide);
			sheetObjects[0].SetCellBackColor(0, "bl_no",color_show);
			sheetObjects[0].SetCellBackColor(0, "bkg_no",color_hide);
    	} else if(loadOption == '3'){
    		//alert("load_option_grid03");
    		sheetObjects[0].SetCellBackColor(0, "vvd",color_hide);
			sheetObjects[0].SetCellBackColor(0, "bl_no",color_hide);
			sheetObjects[0].SetCellBackColor(0, "bkg_no",color_show);
    	}
    } 
  	function openPopup(flag, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		var fStatusCnt=0;
  		var cntr_nos='';
  		with(sheetObj) {
	  		switch(flag) {
	  		case 'by_ofc':
	  			formObj.cntr_nos.value="";
	  			var sheetObj=sheetObjects[0];
	  			with(sheetObj)
	  			{
	  				for(var i=1; i <= sheetObj.RowCount(); i++) {
						var cntrNo=GetGetCellValue(i, "cntr_no");
						var chgStsCd=GetGetCellValue(i, "dmdt_chg_sts_cd");
						var auditResult=GetGetCellValue(i, "audit_result");
	  					if(auditResult == "Coincidence" && chgStsCd == 'F'){
	  						fStatusCnt 	+= 1;
	  						if(i == sheetObj.RowCount()){
	  							cntr_nos	+= cntrNo;
	  						} else {
	  							cntr_nos	+= cntrNo +",";	  							
	  						}
	  					}
	  				} //End of the for loop
	  			}
	  			formObj.cntr_nos.value=cntr_nos;
	  			if(fStatusCnt == 0) {
	  				ComShowCodeMessage('DMT00156');
	  				return;
	  			}
	  			if(fStatusCnt > 1000) {
	  				ComShowCodeMessage('DMT00157');
	  				return;
	  			}
	  			var trfCd=formObj.dmdt_trf_cd.value;
	  			var ofcCd=formObj.ofc_cd.value;
	  			var paramVal="?call_flag=P&cntr_no=&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=F&ofc_cd=" + ofcCd;
	  			sUrl='EES_DMT_3001P.do' + paramVal
          		sWidth='1010';
          		sHeight='680';
  				break;
	  			case 'by_bkg':
	  				var chkRow=0;
	  				if(GetGetSelectRow()()> 0) {
	  					chkRow=GetGetSelectRow()();
	  				}
					var bkgNo=GetGetCellValue(chkRow , "bkg_no");
					var blNo=GetGetCellValue(chkRow , "bl_no");
		  			var trfCd=formObj.dmdt_trf_cd.value;
		  			var chgStsCd=GetGetCellValue(chkRow , "dmdt_chg_sts_cd");
		  			if(bkgNo == '' && blNo == ''){
		  				ComShowCodeMessage('DMT02030');
		  				return;
		  			}
		  			var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
	  				sUrl='EES_DMT_3002P.do' + paramVal;
	          		sWidth='1010';
	          		sHeight='680';
	  				break;
	  			case 'by_cntr':
	  				var chkRow=0;
	  				if(GetGetSelectRow()()> 0) {
	  					chkRow=GetGetSelectRow()();
	  				}
					var svrId=GetGetCellValue(chkRow , "svr_id");
					var cntrNo=GetGetCellValue(chkRow , "cntr_no");
					var cntrCycNo=GetGetCellValue(chkRow , "cntr_cyc_no");
					var trfCd=GetGetCellValue(chkRow , "dmdt_trf_cd");
					var chgLocDivCd=GetGetCellValue(chkRow , "dmdt_chg_loc_div_cd");
					var chgSeq=GetGetCellValue(chkRow , "chg_seq");
		  			if(svrId == '' || cntrNo == '' || cntrCycNo == '' || trfCd == '' 
		  				|| chgLocDivCd == '' || chgSeq == '' ){
		  				ComShowCodeMessage('DMT02029');
		  				return;
		  			}
		  			var paramVal="?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
	  				sUrl='EES_DMT_3003P.do' + paramVal;
	          		sWidth='1010';
	          		sHeight='680';
	  				break;
	  			case 'mvmt_inq':
	  				if(SearchRows()()== 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');  //DMT06001
	         			return;
	         		}
	  				var inqRow=0;
	  				if(GetGetSelectRow()()> 0) {
	  					inqRow=GetGetSelectRow()();
	  				}
					var cntrNo=GetGetCellValue(inqRow , "cntr_no");
					var cntrTpszCd=GetGetCellValue(inqRow , "cntr_tpsz_cd");
	  				if(cntrNo == ''){
		  				ComShowCodeMessage('DMT02002', 'Cntr No');
		  				return;
		  			}
	  				if(cntrTpszCd == ''){
		  				ComShowCodeMessage('DMT02002', 'Tariff Type Size Code');
		  				return;
		  			}
	  				var paramVal="?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl='pop_mode=Y.do' + paramVal;
					sWidth='1020';
					sHeight='680';
	  				break;
	  		} // switch-end
  		} // with-end
  		if(sUrl.indexOf('.do') != -1) {
  			//var sWinName = ComReplaceStr(sUrl, '.do', '');
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		} 
  		else if(sUrl != '') {
  			ComOpenWindow(sUrl, "", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=" + sWidth + ",height=" + sHeight + ",left=0,top=0");
  		}
  	}
	/* Developer's task end */
