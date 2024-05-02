/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_6001.js
*@FileTitle  : Current Collection Status by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* Developer's task	*/
	// common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
	function processButtonClick(){
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
    	try {
    		var srcObj=ComGetEvent();
    		var srcName=srcObj.getAttribute("name");
				switch(srcName) {
					case "btns_calendar":
//						if(srcObj.style.cursor == "hand") {
		                    var cal = new ComCalendarFromTo();
		                    cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
//						}
		            break;
					
					case "btn_Retrieve":
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;
					
					case "btn_New":
						doInit();						
						sheetObj.RemoveAll();
					break;
					
					case "btn_Minimize":
						var schCondDiv=document.getElementById("sch_cond_div");
//	 					if(schCondDiv.style.display == 'block') {
	// 						schCondDiv.style.display='none';
//no support[check again]CLT 	 						
	 //						sheetObj.style.height=sheetObj.GetSheetHeight(23);	//sheetObj.GetSheetHeight(23); //300+145;
	 	//				} else {
	// 						schCondDiv.style.display='block';
//no support[check again]CLT 	 						
	 //						sheetObj.style.height=sheetObj.GetSheetHeight(17);	//sheetObj.GetSheetHeight(14); //300;
	 	//				}
	 					
	 					if(schCondDiv.style.display == 'block') {
	 						schCondDiv.style.display='none';
	 						sheetObj.SetSheetHeight(300+145);
	 					} else {
	 						schCondDiv.style.display='block';
	 						sheetObj.SetSheetHeight(300);
	 					}	 					
 					break;
 					
					case "btn_Detail":
					case "btn_DetailA":
					case "btn_DetailB":
					case "btn_DetailC":
						doProcessPopup(srcName);
					break;
					
					case "btn_DownExcel":
//method change[check again]CLT 						
						if (sheetObj.RowCount() < 1) {
							ComShowCodeMessage("COM132501");
						}
						else {
							sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
						}						
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
        
        var formObj=document.form
		sheetObjects[0].SetWaitImageVisible(0);
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[1], SEARCHLIST);
      	sheetObjects[0].SetWaitImageVisible(1);
        doInit();
    }
    
	function initControl() {
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//		axon_event.addListener('blur',	'obj_blur',	'to_mvmt_mon', 'fm_dt', 'to_dt'); 
// 		axon_event.addListener('focus',	'obj_focus', 'to_mvmt_mon', 'fm_dt', 'to_dt');
// 		axon_event.addListenerFormat('keypress','obj_keypress', document.form); 
// 		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
// 		axon_event.addListener('mouseover', 'obj_mouseover',	'btn_DetailA', 'btn_DetailB', 'btn_DetailC');
//		axon_event.addListener('mouseout',	'obj_mouseout',		'btn_DetailA', 'btn_DetailB', 'btn_DetailC');
// 		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
// 		axon_event.addListener('click', 'dt_flg_click', 'dt_flg');
	}
	function keyPress() {
        var eventKey=window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
	function doInit() {
		var formObj = document.form;
		ComResetAll();
		dt_flg_click();
		ofc_flg_click();
	}
	
 	function obj_mouseover() {
 		var msg='';  
 		var x=event.x+document.body.scrollLeft;
 		var y=event.y+document.body.scrollTop;
 		x=x-255;
		y=y-20;
     	switch(ComGetEvent("id")) {
      		case 'btn_DetailA':
      			msg="Detail for Incurred CNTR not A/R interfaced";
      			break;
      		case 'btn_DetailB':
      			msg="Detail for Billable CNTR not A/R interfaced";
      			break;
      		case 'btn_DetailC':
      			msg="Detail for Invoiced CNTR not A/R interfaced";
      			break;
     	}
 		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR=lightyellow"
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
	
	function dt_flg_click() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(formObj) {
			var dtFlg = ComGetObjValue(dt_flg);
			var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
			if (dtFlg == 'M') {
				ComEnableObject(to_mvmt_mon, true);
				ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar);
				DmtComSetClassManyObjects('input1', to_mvmt_mon);
    	 		DmtComSetClassManyObjects('input2', fm_dt, to_dt);
    	 		//ComSetObjValue(to_mvmt_mon, ComGetNowInfo("ym"));
    	 		ComSetObjValue(to_mvmt_mon, ofcCurrDate.substring(0, 7));
				ComClearManyObjects(fm_dt, to_dt);
			} else {
				ComEnableObject(to_mvmt_mon, false);
				ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar);
				DmtComSetClassManyObjects('input1', fm_dt, to_dt);
    	 		DmtComSetClassManyObjects('input2', to_mvmt_mon);
				var fmDt = ComGetDateAdd(ofcCurrDate, "M", -1);
				var toDt = ofcCurrDate;
				ComSetObjValue(fm_dt, fmDt);
				ComSetObjValue(to_dt, toDt);
				ComClearManyObjects(to_mvmt_mon);
			}
		} // with-end
	}
	
	function ofc_flg_click() {
		var formObj=document.form;
		var ofcFlg=ComGetObjValue(formObj.ofc_flg);
		var comboObj=comboObjects[0];
		
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
			var headOffice=ComGetObjValue(formObj.head_office);
			//if(usrRhqOfcCd == 'SELHO')
			if(usrRhqOfcCd == headOffice)
	   			usrRhqOfcCd="All";
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
//	   		ComEnableObject(formObj.grp_flg, true);
	   		formObj.grp_flg.disabled = false;
		} else {
			// Office
			doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
			ComEnableObject(formObj.chk_sub_ofc, true);
			//ComEnableObject(formObj.grp_flg, false);
			formObj.grp_flg.disabled = true;
			formObj.grp_flg.className='input2';
		}
	}
	
    function obj_blur(){
    	var obj = ComGetEvent();
    	ComChkObjValid(obj);
	}
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
    	var obj=ComGetEvent();
    	ComClearSeparator(obj);
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
    
	function obj_keypress() {
    	 switch(ComGetEvent("dataformat")){
         	/*
    	 	case "engup":
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	*/
         	default:
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
	
	function doInclSubOfc() {
		var formObj=document.form;
		var comboObj=comboObjects[0];
		
		if (formObj.chk_sub_ofc.checked) {	// Sub Office included
			
			if (ComIsEmpty(comboObj.GetSelectCode())) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked=false;
				return;
			}
			
			formObj.ofc_cd.value=ComGetObjValue(comboObj);
			formObj.tmp_ofc_cd.value=ComGetObjValue(comboObj);
			
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
		} else {
			comboObj.SetSelectIndex(-1);
			comboObj.SetSelectCode(formObj.tmp_ofc_cd.value, false);			
		}
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
                	//no support[check again]CLT style.height=GetSheetHeight(17); //260;
            	//	no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            		var HeadTitle1=" ||Seq.|Office|Tariff|Cur.|Incurred|Incurred|CMDT Exception|CMDT Exception|Exception|Exception|Discount|Discount|Billable|Billable|Invoiced|Invoiced|Collected|Collected|Collection AMT|Collection AMT|Collection AMT";
            		var HeadTitle2=" ||Seq.|Office|Tariff|Cur.|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|vs Incurred(A) (%)|vs Billable(B) (%)|vs Invoiced(C) (%)";
            		

            		//SetConfig( { SearchMode:2, FrozenCol:SaveNameCol("curr_cd"), MergeSheet:7, Page:20, DataRowMerge:0 } );
            		SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:0 } );
            		
            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
            		             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"incr_cntr",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"DEM/DET Incurrence per Basic Tariff"},
            		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"incr_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"DEM/DET Incurrence per Basic Tariff"},
            		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cmdt_cntr",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Exception per Commodity Exception Tariff"},
            		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cmdt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Exception per Commodity Exception Tariff"},
            		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"expt_cntr",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Exception per S/C Exception Tariff/Before Booking"},
            		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Exception per S/C Exception Tariff/Before Booking"},
            		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"dc_cntr",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Discount per After Booking"},
            		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dc_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Discount per After Booking"},
            		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bill_cntr",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Billable AMT = Incurred - CMDT EXPT - Exception - Discount AMT"},
            		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bill_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Billable AMT = Incurred - CMDT EXPT - Exception - Discount AMT"},
            		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"inv_cntr",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Invoiced up to now"},
            		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Invoiced up to now"},
            		             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"coll_cntr",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Collected up to now"},
            		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"coll_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Collected up to now"},
            		             {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"coll_rto_a",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"coll_rto_b",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"coll_rto_c",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetSheetHeight(455);
            		//SetCountPosition(2);
            		FrozenCols = SaveNameCol("curr_cd");
              //no support[check again]CLT 					
            		//ToolTipOption="balloon:true;width:50;";
            		ShowSubSum([{StdCol:"ofc_cd", SumCols:"incr_cntr|incr_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1,
            			OtherColText:"ofc_cd=%s;seq=S.TTL;coll_rto_a=Round(|coll_amt|/|incr_amt|, AvgCols:4)*100;coll_rto_b=Round(|coll_amt|/|bill_amt|,4)*100;coll_rto_c=Round(|coll_amt|/|inv_amt|,4)*100"}]);
            
            		
            	}
                break;
        }
    }
	// Sheet processing-related processes
	function doActionIBSheet(sheetObj, formObj, sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	       case IBSEARCH:      

	       		if(!validateForm(sheetObj,formObj,sAction)) return;
	       		sheetObj.SetWaitImageVisible(0);
	       		ComSetObjValue(formObj.f_cmd, SEARCH);
	       		
       			ComOpenWait(true);
	            var sXml = sheetObj.GetSearchData("EES_DMT_6001GS.do", FormQueryString(formObj));
	            sheetObj.LoadSearchData(sXml, {Sync:1});		       		
	       		ComOpenWait(false);
	       	break;
	    }
	}
	
	/**
	 * Combo basic setting 
	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
	 * If the number of combo a combo by adding the number of case sheets to initialize the module configuration
	 */ 
	function initCombo(comboObj, comboNo) {
		var formObj=document.form;
	    switch(comboObj.options.id) {  
	    	case "office": 
	    		with (comboObj) {
	    			//SetColWidth(0, "100");
					//MultiSelect = false;
	    			SetUseAutoComplete(0);
	    			SetColAlign(0, "left");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
					
					//MaxLength = 6;
			    }
		    break;
		    
	    	case "tariff_type":
   	    		with (comboObj) { 
   					SetMultiSelect(1);
   					SetColAlign(0, "left");
   					SetColWidth(0, "100");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
   		    	}
  			break;
  			
	    	case "cntr_type":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetColAlign(0, "left");
   					SetColWidth(0, "120");
					SetDropHeight(160);
					//ColBackColor(0) = "#CCFFFD";
   		    	}
   	    		comboObj.InsertItem(0, "All",		"A");
   	    		comboObj.InsertItem(1, "Dry",		"D");
   	    		comboObj.InsertItem(2, "Reefer",	"R");
   	    		comboObj.InsertItem(3, "Special",	"S");
   			break;
	    }
	}
	
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
    	 sheetObj.ShowDebugMsg(false);
    	 sheetObj.SetWaitImageVisible(0);
    	 formObj.f_cmd.value=formCmd;
    	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 switch(formCmd) {
    	 	case SEARCHLIST:	// tariff type
    	 	// Tariff type comboList
    	 		var data = ComGetEtcData(sXml, "common_tariff_cd");
    	 		if (data != undefined && data != '') {
					var comboItems = data.split("|");
					for(var i=0; i < comboItems.length; i++) {
						var item = comboItems[i].split("=");
						comboObj.InsertItem(i+1, item[0], item[0]);	
					}
    	 			comboObj.InsertItem(0, "All", "All");
				}
			break;
			
    	 	case COMMAND06:	// RHQ
    	 		with (comboObj) { 
	    	 		RemoveAll();
					SetMultiSelect(0);
					SetColWidth(0, "80");
					ValidChar(2);	
					//MaxLength = 6;
    	 		}
    	 		var data=ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems=data.split("|");
					comboObj.InsertItem(0, "All", "All");
					for (var i=0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
				}
			break;
			
    	 	case SEARCHLIST02: // Office
    	 		with (comboObj) { 
	    	 		RemoveAll();
					SetMultiSelect(1);
					SetColWidth(0, "95");
					ValidChar(2, 2); 
    	 		}
				var data=ComGetEtcData(sXml, "OFC_CD");
				if (data != undefined && data != '') {
					var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
 					var idx=0;  
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx=1;
 					}
 		    	    var comboItems=data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
 		    	   
	    	  		comboObj.SetSelectCode(usrOfcCd, false);
				}
    	    break;
	    	    
    	 	case COMMAND01:	// Incl. Sub Office
    	 		var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
    	 		if (subOfcCds != undefined && subOfcCds != '') {
    	 			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					if (comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd) == -1) {
						subOfcCds = usrOfcCd + ',' + subOfcCds;
					}
					comboObj.SetSelectCode(subOfcCds, false);
		 		}
    	 	break;
    	 }
	}
	 /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
      			case IBSEARCH:
      				var dtFlg=ComGetObjValue(dt_flg);
      				if(dtFlg == 'M') {
      					if(!ComIsDate(to_mvmt_mon, "ym")) {
             				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'To MVMT Date Month'));
             				return false;
             			}
      					var toMvmtMon=ComGetUnMaskedValue(to_mvmt_mon, 'ym');
      					var lastDay=ComGetLastDay(ComParseInt(toMvmtMon.substring(0, 4)), ComParseInt(toMvmtMon.substring(4)));
      					var startDt=toMvmtMon + '01';
      					var endDt=toMvmtMon + '' + lastDay;
      					ComSetObjValue(start_dt, startDt);
      					ComSetObjValue(end_dt, endDt);
      				} else {
      					if(!ComIsDate(fm_dt)) {
             				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
             				return false;
             			}
             			if(!ComIsDate(to_dt)) {
             				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
             				return false;
             			}
      					var startDt=ComGetUnMaskedValue(fm_dt, 'ymd');
             			var endDt=ComGetUnMaskedValue(to_dt, 'ymd');
             			/*
             			ComChkPeriod(fromDate, toDate)
             			0 : fromDate > toDate
             			1 : fromDate < toDate
             			2 : fromDate=toDate
             			*/
                        if (ComChkPeriod(startDt, endDt) == 0) {
                        	ComShowCodeMessage("DMT01020");
                        	return false;
                        }
                        var limitDt=ComGetDateAdd(startDt, "M", 1);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", "1 month");
                        	return false;
                        }
      					ComSetObjValue(start_dt, startDt);
      					ComSetObjValue(end_dt, endDt);
      				}
                    // DEM/DET Office
                    var ofcCd=comboObjects[0].GetSelectCode();
                    if(ComIsEmpty(ofcCd)) {
                    	ComShowCodeMessage('COM12113', "DEM/DET Office");
             			return false;
                    }
                    ComSetObjValue(ofc_cd, ofcCd);
                    // Tariff Type
                    var trfCd=comboObjects[1].GetSelectCode();
                    if(ComIsEmpty(trfCd)) {
                    	ComShowCodeMessage('COM12113', "Tariff Type");
             			return false;
                    }
                    if(trfCd.indexOf('All') != -1)
                    	trfCd=ComReplaceStr(trfCd, "All,", "");
                    ComSetObjValue(dmdt_trf_cd, trfCd);
                    // CNTR Type
                    var cntrType=comboObjects[2].GetSelectCode();
                    if(ComIsEmpty(cntrType)) {
                    	ComShowCodeMessage('COM12113', "CNTR Type");
             			return false;
                    }
                    if(cntrType == 'A')
                    	cntrType="D,R,S";
                    ComSetObjValue(dmdt_cntr_tp_cd, cntrType);
      				break;
       	 	} // switch - end
        } // with(formObj) - end
        return true;
    }
  	function doProcessPopup(srcName) {
  		var sheetObj=sheetObjects[0];
   		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		var paramVal='';
  		with(sheetObj) {
			if(CheckedRows("chk") == 0) {
     			ComShowCodeMessage('COM12114', 'Detail Charge');
     			return;
     		}
     		var chkCnt=0;
     		var chkRows=FindCheckedRow("chk").split("|");
     		var prevOfcCd=GetCellValue(chkRows[0], "ofc_cd");
     		var chkTrfCd='';

     		for(var i=0; i < chkRows.length; i++) {
     			var currOfcCd=GetCellValue(chkRows[i], "ofc_cd");
     			if(currOfcCd != prevOfcCd) {
     				ComShowCodeMessage('DMT01066');
 					return;
     			}
     			var trfCd=GetCellValue(chkRows[i], "dmdt_trf_cd");
     			chkTrfCd += ',' + trfCd; 
     		}
     		chkTrfCd=chkTrfCd.substring(1);
     		var startDt=ComGetObjValue(formObj.start_dt);
 			var endDt=ComGetObjValue(formObj.end_dt);
     		var grpFlg=ComGetObjValue(formObj.grp_flg);
     		var cntrTp=ComGetObjValue(formObj.dmdt_cntr_tp_cd);
     		paramVal="?start_dt=" + startDt + "&end_dt=" + endDt + "&grp_flg=" + grpFlg
     					+ "&ofc_cd=" + prevOfcCd + "&dmdt_trf_cd=" + chkTrfCd + "&dmdt_cntr_tp_cd=" + cntrTp;
     		var dtlFlg='';
  			switch(srcName) {
	  			case 'btn_Detail':
	  				break;
	  			case 'btn_DetailA':
	  				dtlFlg='A';
	  				break;
	  			case 'btn_DetailB':
	  				dtlFlg='B';
	  				break;
	  			case 'btn_DetailC':
	  				dtlFlg='C';
	  				break;
	  		}
  		}
  		sUrl='EES_DMT_6002.do' + paramVal + "&dtl_flg=" + dtlFlg;
  		sWidth='1020';
  		sHeight='555';

  		var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  	}
	// Office IBMultiCombo initializing
	function initComboValue_tariff_type() {
		ComSetObjValue(comboObjects[1], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
	}
	
	// CNTR Type IBMultiCombo initializing
	function initComboValue_cntr_type() {
		ComSetObjValue(comboObjects[2], "A");
	}
	
 	function office_OnCheckClick(comboObj, index, code) {
 		var formObj=document.form;
		if (formObj.chk_sub_ofc.checked) {
			if (comboObj.GetItemCheck(index)) {
				comboObj.SetItemCheck(index, 0, false);
			}
			else {
				comboObj.SetItemCheck(index, 1, false);
			}
			ComShowCodeMessage('DMT00107');
		}	
 	}
	// multi combo KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
   		if (formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	
	//Tariff Type IBMultiCombo click event handling
	function tariff_type_OnCheckClick(comboObj, index, code) {
		var codes = comboObj.GetSelectCode();
	    if (index == 0) {
	    	var bChk=comboObj.GetItemCheck(index);
    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    			comboObj.SetItemCheck(i, bChk, false);
	    	}
	    } 
	    else if (comboObj.GetItemCheck(0)) {
			comboObj.SetItemCheck(0, 0, false);
	    } 
	    else if (isTariffAllCheck(comboObj)) {
	    	comboObj.SetItemCheck(0, 1, false);
	    }
	}    

	function isTariffAllCheck(comboObj) {
		var allTariffCnt = comboObj.GetItemCount();
		var selTariffCnt = 0;
		for (var i = 1; i < allTariffCnt; i++) {	// All 항목은 제외
			if (comboObj.GetItemCheck(i)) selTariffCnt++;
		}
		
		return selTariffCnt == allTariffCnt-1;		// 선택항목에서 All 항목은 제외
	}
	
    function sheet1_OnSearchEnd(sheetObj, code, msg, stCode, stMsg) {
    	
    	with(sheetObj){

    		var row=LastRow();
    		//parameter changed[check again]CLT     		
    		SetSumText(0, "chk","Total / Average");
    		//parameter changed[check again]CLT     		
    		SetSumText(0, "seq","Total / Average");
    		//parameter changed[check again]CLT     		
    		SetSumText(0, "ofc_cd","Total / Average");
    		//parameter changed[check again]CLT     		
    		SetSumText(0, "dmdt_trf_cd","Total / Average");
    		//parameter changed[check again]CLT 
    		SetSumText(0, "curr_cd",GetCellValue(row - 1, "curr_cd"));
    		var sumA='0';
    		var sumB='0';
    		var sumC='0';
    		//parameter changed[check again]CLT 
    		if(GetSumValue(0, "incr_amt") != '0')
    		//parameter changed[check again]CLT //parameter changed[check again]CLT 
    			sumA=ComRound(GetSumValue(0, "coll_amt")/GetSumValue(0, "incr_amt"), 4)*100;
    		//parameter changed[check again]CLT 
    		if(GetSumValue(0, "bill_amt") != '0')
    		//parameter changed[check again]CLT //parameter changed[check again]CLT 
    			sumB=ComRound(GetSumValue(0, "coll_amt")/GetSumValue(0, "bill_amt"), 4)*100;
    		//parameter changed[check again]CLT 
    		if(GetSumValue(0, "inv_amt") != '0')
    		//parameter changed[check again]CLT //parameter changed[check again]CLT 
    			sumC=ComRound(GetSumValue(0, "coll_amt")/GetSumValue(0, "inv_amt"), 4)*100;
    		//parameter changed[check again]CLT     		
    		SetSumValue(0, "coll_rto_a",sumA);
    		//parameter changed[check again]CLT     		
    		SetSumValue(0, "coll_rto_b",sumB);
    		//parameter changed[check again]CLT     		
    		SetSumValue(0, "coll_rto_c",sumC);
    		SetMergeCell(LastRow(), 1, 1, 4);
    		SetCellAlign(row, "chk","Right");
    	}
    }
	/* Developer's task end */
