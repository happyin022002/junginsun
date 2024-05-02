/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESS_DMT_3004.js
*@FileTitle  : Charge Inquiry by Office Or VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
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
	var COMMON_TARIFF_CD="common_tariff_cd";
	var USER_TARIFF_TYPE="user_tariff_type"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	var USR_TRF_TP;
	var IBDELCANCEL=96;
	var DEF_SHEET_HEIGHT = 380;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 165;
	
	//멀티콤보 이벤트 처리를 위한 전역변수
	var selComboIndex, selComboCode;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
          /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
          var sheetObj=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
          try {
        	  var srcObj=ComGetEvent();
        	  var srcName=srcObj.getAttribute("name");
        	  if(!ComIsBtnEnable(srcName)) return;
        	  switch(srcName) {
        	  	case "btns_calendar":
					var cal=new ComCalendarFromTo();
					cal.select(formObj.fm_mvmt_dt1, formObj.to_mvmt_dt1, 'yyyy-MM-dd');             		
					break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObj,formObj,IBSEARCH);
 					break;
 				case "btn_New":
 					doInit();
 					break;
 				case "btn_Minimize":
 					var schCondDiv=document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'inline') {
 						schCondDiv.style.display='none';
 						sheetObj.SetSheetHeight(MAX_SHEET_HEIGHT);
 					} else {
 						schCondDiv.style.display='inline';
 						sheetObj.SetSheetHeight(DEF_SHEET_HEIGHT);
 					}
 					break;
 				case "btn_DELCancel":
 					doActionIBSheet(sheetObj,formObj,IBDELCANCEL);
 					break;
 				case "btn_DownExcel":
 					if(sheetObj.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
 					}
 					break;
 				/*default:
 					doProcessPopup(srcName);
 					break;*/
 				case "btn_ByBKG":
 				case "btn_ByCNTR":
 				case "btn_MVMTInq":
 				case "btn_ExceptionInq":
 				case "m_bkg_no":
 				case "m_bl_no":
 				case "m_cntr_no": 
 					doProcessPopup(srcName);
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
	    var formObj=document.form;
//	    var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
//	    if(usrRhqOfcCd == 'SELHO' || usrRhqOfcCd == 'NYCNA') {
//	    	ComSetDisplay('cs_webmt_chk', true);
//			SHEET_HEIGHT = 340;
//		}
   	  	for(var i=0;i<sheetObjects.length;i++){
   	  		ComConfigSheet (sheetObjects[i] );
   	  		initSheet(sheetObjects[i],i+1);
   	  		ComEndConfigSheet(sheetObjects[i]);
   	  	}
	 	for(var k=0;k<comboObjects.length;k++){
	 		initCombo(comboObjects[k],k+1);
	 	}

		initControl();
		sheet1_OnLoadFinish();
	}
	
	function doInit() {
  		var formObj=document.form;
  		sheetObjects[0].CheckAll("chk",0);
  		ComResetAll();
  		doEnableCondObj("date");
  		comboObjects[2].SetSelectCode("F");
  		initBtns();
  	}
	function initControl() {
		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); 
//		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); 
		axon_event.addListenerFormat('keypress','obj_keypress', document.form);
//		axon_event.addListener('click', 'condType_click', 'cond_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//axon_event.addListener('mouseover', 'obj_mouseover',	'tdGB');
		//axon_event.addListener('mouseout',	'obj_mouseout',		'tdGB');
	}
    function obj_mouseover() {
    	var msg='';
    	switch(event.srcElement.id){
     		case 'tdGB':
     			msg="General/Balance Charge Type";
     			break;
    	}
    	var bak='lightyellow';
   	 	var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
   	 	var x=event.x+document.body.scrollLeft;
		var y=event.y+document.body.scrollTop;
		var skn=document.all("topdeck").style;
		skn.left=x-10;
		skn.top=y+10;
		document.all("topdeck").innerHTML=content;
		skn.visibility='visible';
    }
	function obj_mouseout() {
		var skn=document.all("topdeck").style;
		skn.visibility='hidden';
	}
     function condType_click() {
    	 doEnableCondObj(ComGetEvent("value"));
     }
     function doEnableCondObj(condType) {
    	 var formObj=document.form;    
    	 with (formObj) {
	    	 switch(condType){
	    	 	case "date":
	    	 		ComEnableManyObjects(true, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd, dem_type);	//VVD CD: Disable
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);		//CNTR: Disable
	    	 		DmtComSetClassManyObjects('input2', vvd_cd, tmnl_cd, bkg_no, bl_no, cntr_no, dem_type);
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].SetEnable(1);//Date YD
	    	 		//comboObjects[4].Enable = false; //VVD CD YD
	    	 		ComSetObjValue(yard_fmto, "yard_fm");
	    	 		ComClearManyObjects(vvd_cd, tmnl_cd, dem_type);		//VVD CD
	    	 		//comboObjects[4].RemoveAll();						//VVD CD
	    	 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		//CNTR
	    	 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
	    	 		break;
	    	 	case "vvd_cd":
	    	 		ComEnableManyObjects(false, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(true, vvd_cd, tmnl_cd, dem_type);
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);
	    	 		DmtComSetClassManyObjects('input1', vvd_cd); 			
	    	 		DmtComSetClassManyObjects('input2', yd_cd, bkg_no, bl_no, cntr_no);
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].SetEnable(0);//Date YD
	    	 		//comboObjects[4].Enable = false;	//VVD CD YD
	    	 		comboObjects[3].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, bkg_no, bl_no, cntr_no);	//CNTR
	    	 		setDemType();
	    	 		break;
	    	 	case "cntr":
	    	 		ComEnableManyObjects(false, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd, dem_type);
	    	 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no);
	    	 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, cntr_no); 
	    	 		DmtComSetClassManyObjects('input2', yd_cd, vvd_cd, tmnl_cd, dem_type);
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].SetEnable(0);//Date YD
	    	 		//comboObjects[4].Enable = false;	//VVD CD YD
	    	 		comboObjects[3].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, vvd_cd, tmnl_cd, dem_type);	//VVD CD
	    	 		//comboObjects[4].RemoveAll();							//VVD CD
	    	 		break;
	    	 }
	    	 if(condType == 'date') {
	    		 ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1);
	    		 document.form.btns_calendar.disabled = false;
	    		 DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);	    		 
	    		 var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObj);	    		 
	    		 var fmMvmtDt=ComGetDateAdd(ofcCurrDate, "D", -15);
	    		 var toMvmtDt=ofcCurrDate;
	    		 ComSetObjValue(fm_mvmt_dt1, fmMvmtDt);
	    		 ComSetObjValue(to_mvmt_dt1, toMvmtDt);	    		 
	    		 
	    	 } else {
	    		 ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1);
	    		 document.form.btns_calendar.disabled = true;
	    		 DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1);
	    		 ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1);
	    	 }
	    	 if(condType == 'cntr') {
	    		 ComEnableManyObjects(true, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 } else {
	    		 ComEnableManyObjects(false, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 }
    	 }
     }
     
	function setStatusCombo(condType) {
    	 var comboObj=comboObjects[2];
    	 var orgCode=comboObj.GetSelectCode();
    	 if(condType=='date') {
    		 if(comboObj.GetItemCount() != 5) {
    			 comboObj.RemoveAll();
    			 initCombo(comboObj, 3);
    		 }
    	 } else {
    		 if(comboObj.GetItemCount() != 4) {
    			 comboObj.RemoveAll();
    			 initCombo(comboObj, 4);
    			 if(orgCode.indexOf('R') != -1) {
    				 orgCode=ComReplaceStr(orgCode, 'R', 'L');
    				 if(orgCode == 'F,E,N,D,U,C,I,L')
    					 orgCode='A,F,E,N,D,U,C,I,L';
    			 }
    		 }
    	 }
    	 comboObj.SetSelectCode(orgCode);
	}
	function initBtns() {
		DmtComEnableManyBtns(false, "btn_DELCancel", "btn_ByBKG", "btn_ByCNTR", "btn_MVMTInq", "btn_DownExcel");
	}
	
   	// IBMultiCombo Office initializing
   	function initComboValue_office() {
   		comboObjects[0].SetEnable(1);
   		comboObjects[0].SetSelectCode(ComGetObjValue(document.form.usr_ofc_cd));
   	}
   	
   	// IBMultiCombo Tariff Type initializing
   	function initComboValue_tariff_type() {
   		comboObjects[1].SetEnable(1);
   		comboObjects[1].SetSelectCode(USR_TRF_TP);
   		ComSetObjValue(document.form.usr_trf_tp, USR_TRF_TP);
   	}
   	
   	// IBMultiCombo Status initializing
   	function initComboValue_status_combo() {
   		comboObjects[2].SetEnable(1);
		comboObjects[2].SetSelectCode("F");
   	}
	// IBMultiCombo YardCode2 initializing
   	function initComboValue_yd_cd2() {
   		comboObjects[3].RemoveAll();
   	}
	function doInclSubOfc() {
		var formObj=document.form;
		if(formObj.chk_sub_ofc.checked) {	// Sub Office included
			if( ComIsEmpty(comboObjects[0].GetSelectCode()) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked=false;
				return;
			}
			formObj.ofc_cd.value=ComGetObjValue(comboObjects[0]);
			formObj.tmp_ofc_cd.value=ComGetObjValue(comboObjects[0]);
			doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], COMMAND01)
		} else {
	   		comboObjects[0].SetSelectCode(ComGetObjValue(formObj.tmp_ofc_cd));
		}
	}
     function obj_blur(){
    	 var obj=event.srcElement;
    	 if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
    	 } else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
    		 if(obj.value.length > 0 && obj.value.length < 5) {
     			var cdDiv=(obj.name == 'yd_cd') ? 'Yard' : 'Location';
 	 			ComShowCodeMessage('DMT00110', cdDiv);
 	 		 }
    	 } else {
    		 ComChkObjValid(obj);
    	 }
     }
     /**
      * HTML Control Foucs in
      */
     function obj_focus(){
    	 var obj=event.srcElement;
         ComClearSeparator(obj);
         if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
     }
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup2":
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
	function obj_keyup() {
		var srcObj=event.srcElement;
		checkLocYdCd(srcObj);
	}
	function checkLocYdCd(srcObj) {
		var formObj=document.form;
		var cd=ComTrim(ComGetObjValue(srcObj));
		if (cd.length == 5) {
			//var comboObj = (srcObj.name == 'yd_cd') ? comboObjects[3]:comboObjects[4];
			var comboObj=comboObjects[3];
			if(srcObj.name == 'yd_cd') {
				formObj.yd_cd1.value=cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCH14, srcObj);
				if(comboObj.GetItemCount() == 0) {
					formObj.loc_cd.value=cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, formObj.tmnl_cd);
				}
			} else {
				formObj.loc_cd.value=cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, srcObj);
			}
		}
	}
   /**
      * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
      */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      // sheet1 init
				with(sheetObj){		        	
		        	//no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		        	//no support[check again]CLT MultiSelection=true;
		        	SetSelectionMode(smSelectionList);
		        	var HeadTitle1=" ||Seq.|STS|CNTR No.|T/S|Office|From YD|To YD|Fm|To|Tariff|F/T|Over|From DT|To DT|MT DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT";
		        	HeadTitle1 += "|Billable AMT|BKG No.|B/L No.|VVD CD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|G/B|S.O.C|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O|Invoice No|ISS DT";
		        	HeadTitle1 += "|INV Cur.|Billing AMT|A/R|Payer CD|Payer Name|SHPR CD|Shipper Name|CNEE CD|Cosignee Name|NTFY CD|Notify Name";
		        	HeadTitle1 += "|A/R Cust.|A/R Actual Payer Name|S/P CD|Service Provider Name|Remark(s)";
		        	HeadTitle1 += "|svr_id|chg_seq|cntr_cyc_no|dmdt_chg_loc_div_cd";
		 			HeadTitle1 += "|CNTR Cust.|CNTR Cust CD|CNTR Cust Sales Rep|CNTR Cust Sales OFC|Shipper Sales Rep|Shipper Sales OFC|Consignee Sales Rep|Consignee Sales OFC|Service Scope";
		        	var headCount=ComCountHeadTitle(HeadTitle1);
		        	(headCount, 0, 0, true);

		        	SetConfig( { SearchMode:2, FrozenCol:SaveNameCol("cntr_tpsz_cd"), MergeSheet:5, Page:20, DataRowMerge:1 } );

		        	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        	InitHeaders(headers, info);

		        	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		        	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
		        	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		        	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Actual MT Movement Date"},
		        	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"General/Balance Charge Type"},
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"li",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Local/Intransit DEM Type"},
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ch",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Carrier's Haulage"},
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d_o",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Cargo Release"},
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlse_ofc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Cargo Release Office"},
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"clt_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ofc_trns_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Office Transferred"},
		        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"roll_ovr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Roll Over due to Carrier Schedule Change"},
		        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_ar_if_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"payer_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"shipper_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shipper_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ar_act_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ar_act_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_provdr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"svc_provdr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"corr_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, ToolTip:1},
		        	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_srep_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ob_srep_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ob_sls_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ib_srep_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ib_sls_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		        		InitColumns(cols);

		        		SetEditable(1);
		        		SetEllipsis(1);
		        		//FrozenCols=SaveNameCol("cntr_tpsz_cd");
		      //no support[check again]CLT 					
		        		ToolTipOption="balloon:true;width:50;";
		        		SetSheetHeight(DEF_SHEET_HEIGHT);
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
   	    var formObj=document.form;
   	    switch(comboObj.options.id) {  
   	    	case "office": 
   	    		with (comboObj) { 
   					SetMultiSelect(1);
   					SetUseAutoComplete(1);
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "65");
   					SetColWidth(1, "310");
  					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					ValidChar(2, 2);	
   		    	}
   			break;
   			
   	    	case "tariff_type":   	    		  
   	    		with (comboObj) { 
   					SetMultiSelect(1);
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "50");
   					SetColWidth(1, "310");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
   		    	}
   			break;
   			
   	    	case "status_combo":
   	    		with (comboObj) { 
   	    			if(comboNo==3) {
	   					SetMultiSelect(1);
	   					SetColAlign(0, "left");
	   					SetColAlign(1, "left");
	   					SetColWidth(0, "110");
	   					SetColWidth(1, "150");
						SetDropHeight(190);
						SetColBackColor(0,"#CCFFFD");
	  					SetColBackColor(1,"#CCFFFD");
						addComboItem(comboObj, comboNo);
						//Code = "F";
   	    			} else {
   	    				SetMultiSelect(1);
   	    				SetColAlign(0, "left");
   	    				SetColWidth(0, "120");
   						SetDropHeight(170);
   						SetColBackColor(0,"#CCFFFD");
   						addComboItem(comboObj, comboNo);
   						//Code = "F";
   	    			}
   		    	}
   	    	break;
   	    	
   	    	case "yd_cd2":
   	    		with (comboObj) { 
   	    			SetMultiSelect(0);
  					SetUseAutoComplete(1);
  					SetColAlign(0, "left");
  					SetColWidth(0, "50");
  					SetDropHeight(160);
   		    	}
   	    	break;
   	     }
   	}
   	/**
   	 * Sheet processing-related processes
   	 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      
            	if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;
            	formObj.ofc_cd.value=comboObjects[0].GetSelectText();
            	//Tariff Type
            	var trf_tp=comboObjects[1].GetSelectCode();
            	if(trf_tp.indexOf('All') != -1)
            		trf_tp=ComReplaceStr(trf_tp, "All,", "");
            	var chgStsCd=comboObjects[2].GetSelectCode();
            	if(chgStsCd.indexOf('A') != -1)
            		chgStsCd=ComReplaceStr(chgStsCd, "A,", "");
            	formObj.dmdt_trf_cd.value=trf_tp;
            	formObj.dmdt_chg_sts_cd.value=chgStsCd;
            	if(formObj.fx_ft_ovr_dys.value == '') formObj.fx_ft_ovr_dys.value='0';
//parameter changed[check again]CLT             	
            	sheetObj.DoSearch("EES_DMT_3004GS.do", FormQueryString(formObj));	// + "&" + ComGetPrefixParam(prefix) );
            	ComOpenWait(false);
            	break;
            case IBDELCANCEL:	// Delete Cancel
            	if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
				formObj.f_cmd.value=MULTI01;
				sheetObj.DoSave("EES_DMT_3004GS.do", FormQueryString(formObj), "chk");
				ComOpenWait(false);
				break;
         }
     }
     function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
    	 sheetObj.ShowDebugMsg(false);
    	 sheetObj.SetWaitImageVisible(0);
    	 formObj.f_cmd.value=formCmd;
//parameter changed[check again]CLT     	 
    	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 switch(comboObj.options.id) {
 	       case "office":
 	    	   if(formCmd == SEARCHLIST02) {
	 	    	   	// Office List
					var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
					var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
					if (ofc_cds != undefined && ofc_cds != '') {
						var comboCodeArr=ofc_cds.split("|");
			    	    var comboTextArr=ofc_nms.split("|");
		    	  		var usr_ofc_cd=formObj.usr_ofc_cd.value;
		    	  		var idx=0; 
			    	    if(ofc_cds.indexOf(usr_ofc_cd) == -1) {
			    	    	comboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
			    	    	idx=1;
			    	    }
			    	    for (var i=0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
			    	    comboObj.SetSelectCode(usr_ofc_cd);
					}
 	    	   } else { // formCmd == COMMAND01 (Incl. Sub Office)
 	    		   	var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
 	    	   		if (subOfcCds != undefined && subOfcCds != '') {
 	    	   			var arrOfcCd=subOfcCds.split(',');
 	    	   			var str='';
 	    	   			for(var i=0; i<arrOfcCd.length; i++) {
//parameter changed[check again]CLT  	    	   				
 	    	   				var idx=comboObj.FindItem(arrOfcCd[i], 0);
 	    	   				if(idx != -1)
 	    	   					str=str + ',' + arrOfcCd[i];
 	    	   			}
 	    	   			str=str.substring(1);
 	    	   			var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
 	    	   			if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
 	    	   				str=usrOfcCd + ',' + str;
 	    	   			}
 	    	   			comboObj.SetSelectCode(str);
 	    			 }
 	    	   }
    	 		break;
 	        case "tariff_type": 	        	  	
 		 		// Tariff type comboList
 				var data=ComGetEtcData(sXml, COMMON_TARIFF_CD); 				
 				if (data != undefined && data != '') {
 					var comboItems=data.split(ROWMARK);
 					addComboItem(comboObj, comboItems);
 				}
 				// search Tariff Type Set-Up by User
 				var data2=ComGetEtcData(sXml, USER_TARIFF_TYPE);
 				// Tariff Type Set-Up by User is not exists -->set Default value .
 				if(data2 == '') data2='CTIC,DMIF';
 				if (data2.indexOf('All') == -1) {
 	 				// Tariff Type IBMultiCombo initializing
 	 				comboObj.SetSelectCode(data2);
 				} 		
 				
 				USR_TRF_TP=data2;
 				formObj.usr_trf_tp.value=data2;

 				break;
 	        case "yd_cd2":
 	        //case "tmnl_cd2":
 	        	var comboDatas;
 	        	var chkObj;
 	        	var condType=ComGetObjValue(formObj.cond_type);
 	        	if(srcObj.name == 'yd_cd') {
	 	        	comboObj.RemoveAll();
	 	        	chkObj=formObj.chk_yd_cd;
	 	        	comboDatas=ComGetEtcData(sXml, "YD");
 	        	} else {
 	        		if(condType == 'date')
 	        			chkObj=formObj.chk_yd_cd;
 	        		else
 	        			chkObj=formObj.chk_loc_cd;
 	        		comboDatas=ComGetEtcData(sXml, "LOC_CD");
 	        	}
				if (comboDatas != undefined && comboDatas != '') {
					ComSetObjValue(chkObj, "Y");
					if(srcObj.name == 'yd_cd') {
						comboItems=comboDatas.split(ROWMARK);
						addComboItem(comboObj, comboItems);
					}
				} else {
					if(srcObj.name == 'yd_cd') {
						sheetObj.SetWaitImageVisible(1);
						return;
					}
					ComSetObjValue(chkObj, "N");
					ComShowCodeMessage('DMT00110', "Location");
					srcObj.focus();
				}
 	        	break;
         }
         sheetObj.SetWaitImageVisible(1);
     }
     /**
      * Data in the field adds a combo
      */	
  	function addComboItem(comboObj,comboItems) {
  		
  		switch(comboObj.options.id) {  
  			case "tariff_type":
		  		comboObj.InsertItem(0, "All|All", "All");
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}		  		
		  		break;
  			case "status_combo":
  				if(comboItems == 3) {
	  				comboObj.InsertItem(0, "All", "A");
	  				comboObj.InsertItem(1, "Finished|To Date", "F");
	  				comboObj.InsertItem(2, "Long Staying|From Date", "L");
	  				comboObj.InsertItem(3, "System Error|From Date", "E");
	  				comboObj.InsertItem(4, "No Charge|To Date", "N");
	  				comboObj.InsertItem(5, "Deleted|From Date", "D");
	  				comboObj.InsertItem(6, "Unfinished|From Date", "U");
	  				comboObj.InsertItem(7, "Confirmed|To Date", "C");
	  				comboObj.InsertItem(8, "Invoiced|To Date", "I");
	  				comboObj.InsertItem(9, "All Long Staying|Regardless of Date", "R");
  				} else {
  					comboObj.InsertItem(0, "All", "A");
  	  				comboObj.InsertItem(1, "Finished", "F");
  	  				comboObj.InsertItem(2, "Long Staying", "L");
  	  				comboObj.InsertItem(3, "System Error", "E");
	  	  			comboObj.InsertItem(4, "No Charge", "N");
	  				comboObj.InsertItem(5, "Deleted", "D");
	  				comboObj.InsertItem(6, "Unfinished", "U");
	  				comboObj.InsertItem(7, "Confirmed", "C");
	  				comboObj.InsertItem(8, "Invoiced", "I");
  				}
  				break;
  			case "yd_cd2":
  			case "tmnl_cd2":
  				for (var i=0 ; i < comboItems.length ; i++) {
  		    		var comboItem=comboItems[i].split(FIELDMARK);
  					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
  		    	}
  				break;
  		}
  	}
  	function setDemType() {
  		var formObj=document.form;
  		with(formObj) {
	  		if(ComGetObjValue(cond_type) != 'vvd_cd') return;
	  		var trf_tp=comboObjects[1].GetSelectCode();
	  		if(trf_tp.indexOf('DMIF') != -1 || trf_tp.indexOf('DMOF') != -1) {
	  			ComEnableObject(dem_type, true);
	  			dem_type.className='input';
	  			ComClearObject(dem_type);
	  		} else {
	  			ComEnableObject(dem_type, false);
	  			dem_type.className='input2';
	  			ComClearObject(dem_type);
	  		}
  		}
  	}
	//Multi Combo click event
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
	    setDemType();
	}
	function status_combo_OnCheckClick(comboObj, index, code) {
		var codes  = comboObj.GetSelectCode();
		var allchk = comboObj.GetItemCheck(0);		

		if (codes.indexOf('L') != -1 && codes.indexOf('R') != -1) {
			ComShowCodeMessage('DMT01067');
			comboObj.SetItemCheck(index, 0, false);
			return;
		}

		if (index == 0) {
			// All 항목이 선택된 경우
			if (allchk) {
				comboObj.SetItemCheck('R', false, false);
				comboObj.SetSelectCode('A,F,L,E,N,D,U,C,I', false);
			}
			// All 항목이 해제된 경우
			else {
				comboObj.SetItemCheck('A', false, false);
				comboObj.SetItemCheck('F', false, false);
				comboObj.SetItemCheck('L', false, false);
				comboObj.SetItemCheck('E', false, false);
				comboObj.SetItemCheck('N', false, false);
				comboObj.SetItemCheck('D', false, false);
				comboObj.SetItemCheck('U', false, false);
				comboObj.SetItemCheck('C', false, false);
				comboObj.SetItemCheck('I', false, false);
			}
		}		
		else {
			// Finished, Long Staying, System Error 가 선택된 경우, All 항목을 선택해준다.
			if (codes.indexOf('F') != -1 && codes.indexOf('L') != -1 
				&& codes.indexOf('E') != -1 && codes.indexOf('N') != -1 
				&& codes.indexOf('D') != -1 && codes.indexOf('U') != -1
				&& codes.indexOf('C') != -1 && codes.indexOf('I') != -1 ) {
				comboObj.SetItemCheck(0, true, false);
			}
			// Finished, Long Staying, System Error 중 한 항목이라도 선택되지 않았다면, All 항목을 선택해제해준다.
			else if (codes.indexOf('F') == -1 || codes.indexOf('L') == -1 
					|| codes.indexOf('E') == -1 || codes.indexOf('N') == -1 
					|| codes.indexOf('D') == -1 || codes.indexOf('U') == -1
					|| codes.indexOf('C') == -1 || codes.indexOf('I') == -1 ) {
				comboObj.SetItemCheck(0, false, false);
			}
		}		

		if (codes == '' || codes == 'R') {	
			ComEnableManyObjects(false, document.form.fm_mvmt_dt1, document.form.to_mvmt_dt1);
			document.form.btns_calendar.disabled = true;
			DmtComSetClassManyObjects('input2', document.form.fm_mvmt_dt1, document.form.to_mvmt_dt1);
		} 
		else {
			if (ComGetObjValue(document.form.cond_type) == 'date') {
				ComEnableManyObjects(true, document.form.fm_mvmt_dt1, document.form.to_mvmt_dt1);
				document.form.btns_calendar.disabled = false;
				DmtComSetClassManyObjects('input1', document.form.fm_mvmt_dt1, document.form.to_mvmt_dt1);
			}
		}
	}
  //no support[check again]CLT 	
	function sheet1_OnLoadFinish() {
  		var formObj=document.form
  		var sheetObj=sheetObjects[0];
		//sheetObjects[0].WaitImageVisible = false;
  		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST02);
		doActionIBCombo(sheetObj, formObj, comboObjects[1], SEARCHLIST);
		doInit();
        //sheetObjects[0].WaitImageVisible = true;
		var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
//		if(usrRhqOfcCd != 'NYCNA') {
//			with(sheetObj) {
//				ColHidden("mt_dt")			= true;
//				ColHidden("web_ind_flg")	= true;
//				ColHidden("web_cre_dt")		= true;
//				ColHidden("web_mty_dt")		= true;
//				ColHidden("web_ntfy_pic_nm")= true;
//			}
//		}
  	}
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "chk") {
                var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                	for (i=0; i<arr.length; i++) {
                        if (GetCellEditable(arr[i], "chk")) {
                        	SetCellValue(arr[i], "chk",(GetCellValue(arr[i], "chk") == '0') ? "1" : "0",0);
                        }
                    }
                    SetHeaderCheck(0, "chk",(CheckedRows("chk") == RowCount()));
                }
            } else {
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
  	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
  		if(ErrMsg != '') return;
		var formObj=document.form;
		with(formObj) {
			sheetObj.CheckAll("chk",0);
        	if(sheetObj.SearchRows()== 0) {
        		initBtns();
        	} else {
    			DmtComEnableManyBtns(true, "btn_DELCancel", "btn_ByBKG", "btn_ByCNTR", "btn_MVMTInq", "btn_DownExcel");
    			var rolePermit=sheetObj.GetEtcData("ROLE_PERMIT");
    			var roleAuth=sheetObj.GetEtcData("ROLE_AUTH");
    			ComSetObjValue(role_permit, rolePermit);
    			ComSetObjValue(role_auth,	roleAuth);
  			}
		} // with end
  	}
//	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
//		with(sheetObj){
//			Row=MouseRow();
//			Col=MouseCol();
//			if (Row >= 0) {
//				var ttText = sheetObj.GetToolTipText(0,Col);
//				var colSaveNm = ColSaveName(Col);
//				if (colSaveNm == 'corr_rmk') {	
//					var corrRmk = GetCellValue(Row, "corr_rmk");
//					if(corrRmk == '') return;
//					ttText=corrRmk;
//				}
//				SetToolTipText(Row, Col, ttText);
//			} 
//			else {
//				SetToolTipText(Row, Col, '');
//			}
//		}
//	}
	/**
     * handling after save
     */
    function sheet1_OnSaveEnd(sheetObj, code, ErrMsg){
		 if(ErrMsg != '') {	// save error
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
			 // Retrieve run
			 doActionIBSheet(sheetObj,document.form,IBSEARCH);
		 }
    }
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;
		doProcessPopup('btn_ByCNTR', Row);
	}
//	// Multi Combo Click Event Catch
// 	function office_OnCheckClick(comboObj, index, code) {
//		var formObj=document.form;
//   		if(formObj.chk_sub_ofc.checked) {
//   			if(comboObj.GetItemCheck(index))
//   				comboObj.SetItemCheck(index,0);
//   			else
//   				comboObj.SetItemCheck(index,1);
//   			ComShowCodeMessage('DMT00107');
//   		}
// 	}
// 	// Multi Combo KeyDown Event Catch
// 	function office_OnKeyDown(comboObj, keycode, shift) {
//		var formObj=document.form;
//   		if(formObj.chk_sub_ofc.checked) {
//   			ComShowCodeMessage('DMT00107');
//   		}
// 	}
	function office_OnSelect(comboObj, index, text, code) {
		selComboIndex = index;
		selComboCode  = code;
	}
    function office_OnChange(comboObj) {
        DmtComMultiCombo_OnChange(comboObj, selComboIndex, selComboCode, document.form.chk_sub_ofc);
    }
    
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value=aryPopupData[0][3];
    }
    function getSvcProvdr(aryPopupData) {
    	document.form.svc_provdr.value=aryPopupData[0][2];
    }
    function getDmt_Multi(rArray, return_val) {
    	var targObj=eval("document.form." + return_val);
    	var retStr=rArray.toString().toUpperCase();
    	ComSetObjValue(targObj, retStr);
    }
  	function doProcessPopup(srcName, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		var sScroll='no';
  		var sIframe=true;
  		with(sheetObj) {
	  		switch(srcName) {  
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "1,0,1,1,1,1,1", true);
	  				return;
					break;
	  			case 'svc_provdr':	// Service Provider Popup
	  				ComOpenPopup('COM_ENS_0C1.do', 700, 488, "getSvcProvdr", "1,0,1,1,1,1,0", true);
	  				return;
					break;
	  			case 'm_bkg_no':		
	  			case 'm_bl_no':		
	  			case 'm_cntr_no':	
	  				var flag=ComReplaceStr(srcName,"m_","");
	  				var returntitle='';
	  				var sWidth  = 0;
	  				var sHeight = 415;	  				
	  				if (flag == 'bkg_no') {
	  					returntitle='BKG No.';
	  					sWidth = 425;
	  				}
	  				else if(flag == 'bl_no') {
	  					returntitle='B/L No.';
	  					sWidth = 420;
	  				}
	  				else if(flag == 'cntr_no') {
	  					returntitle='CNTR No.';
	  					sWidth = 437;
	  				}	  				
	  				var param="?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, sWidth, sHeight, "getDmt_Multi", "1,0", true);
	  				return;
					break;
	  			case 'btn_ByBKG':
	  				var chkRow=GetSelectRow();
	  				var bkgNo=GetCellValue(chkRow , "bkg_no");
	  				var blNo=GetCellValue(chkRow , "bl_no");
	  				var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
	  				var chgStsCd=GetCellValue(chkRow , "dmdt_chg_sts_cd");
		  			var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				sUrl='EES_DMT_3002P.do' + paramVal;
		  			} else {
		  				sUrl='EES_DMT_3005P.do' + paramVal;
		  			}
	  				sWidth='1280';
	          		sHeight='700';
	  				break;
	  			case 'btn_ByCNTR':
	  				var chkRow=GetSelectRow();
	  				var svrId=GetCellValue(chkRow , "svr_id");
	  				var cntrNo=GetCellValue(chkRow , "cntr_no");
	  				var cntrCycNo=GetCellValue(chkRow , "cntr_cyc_no");
	  				var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
	  				var chgLocDivCd=GetCellValue(chkRow , "dmdt_chg_loc_div_cd");
	  				var chgSeq=GetCellValue(chkRow , "chg_seq");
		  			var paramVal="?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
		  			if(ComGetObjValue(formObj.role_permit) == 'Y') {
		  				sUrl='EES_DMT_3003P.do' + paramVal;
		  			} else {
		  				sUrl='EES_DMT_3006P.do' + paramVal;
		  			}
	  				sWidth='1150';
	          		sHeight='700';
	  				break;
	  			case 'btn_MVMTInq':
	  				if(SearchRows()== 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');  //DMT06001
	         			return;
	         		}
	  				var inqRow=0;
	  				if(CheckedRows("chk") > 0) {
	  					var chkRows=FindCheckedRow("chk").split("|");
	  					inqRow=chkRows[0];
	  				} else if(GetSelectRow()> 0) {
	  					inqRow=GetSelectRow();
	  				}
	  				var cntrNo=GetCellValue(inqRow , "cntr_no");
	  				var cntrTpszCd=GetCellValue(inqRow , "cntr_tpsz_cd");
	  				var paramVal="?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl='EES_CTM_0408_POP.do' + paramVal;
					sWidth='1020';
					sHeight='680';
					sIframe=false;
	  				break;
	  		} // switch-end
  		} // with-end

  		if(sUrl != '') {
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			//ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, sIframe, sScroll);  
  			ComOpenPopup(sUrl, sWidth, sHeight, "callbackProc", "0,1", true);
  		}
//		var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
//		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  	}
  	
  	function callbackProc(rtnVal) {
  		//.....
  	}
  	
     /**
      * Screen input form validation process for handling
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
             	case IBSEARCH:      
             		// Office Combo Check
             		if(comboObjects[0].GetSelectText()== '') {
             			ComShowCodeMessage('COM12113', "Office");
             			return false;
             		}
             		// Tariff Type Combo Check
             		if(comboObjects[1].GetSelectCode()== '') {
             			ComShowCodeMessage('COM12113', "Tariff Type");
             			return false;
             		}
             		// Status Combo Check
             		if(comboObjects[2].GetSelectCode()== '') {
             			ComShowCodeMessage('COM12113', "Status");
             			return false;
             		}
             		ComSetObjValue(fm_mvmt_yd_cd, '');
             		ComSetObjValue(to_mvmt_yd_cd, '');
             		var condType=ComGetObjValue(cond_type);
             		if(condType == 'date') {
             			if(!ComIsDate(fm_mvmt_dt1)) {
             				ComAlertFocus(fm_mvmt_dt1, ComGetMsg('COM12134', 'Period From Date'));
             				return false;
             			}
             			if(!ComIsDate(to_mvmt_dt1)) {
             				ComAlertFocus(to_mvmt_dt1, ComGetMsg('COM12134', 'Period To Date'));
             				return false;
             			}
             			var startDt=ComGetUnMaskedValue(fm_mvmt_dt1, 'ymd');
             			var endDt=ComGetUnMaskedValue(to_mvmt_dt1, 'ymd');
                        if (ComChkPeriod(startDt, endDt) == 0) {
                        	ComShowCodeMessage("DMT01020");
                        	return false;
                        }
                        var limitDt=ComGetDateAdd(startDt, "M", 1);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", "1 month");
                        	return false;
                        }
                        ComSetObjValue(fm_mvmt_dt, startDt);
                        ComSetObjValue(to_mvmt_dt, endDt);
                        var yardCd=ComGetObjValue(yd_cd);
                        if((yardCd != '' && yardCd.length < 5) || (yardCd.length == 5 && ComGetObjValue(chk_yd_cd) == "N")) {
                        	ComShowCodeMessage('DMT00110', 'Yard');
        					return false;
        	       		} else if(yardCd.length == 5) {
        	       			var yardFmto=ComGetObjValue(yard_fmto);
             				if(yardFmto == 'yard_fm') {
             					ComSetObjValue(fm_mvmt_yd_cd, yardCd);
             					ComSetObjValue(to_mvmt_yd_cd, '');
             				} else {
             					ComSetObjValue(fm_mvmt_yd_cd, '');
             					ComSetObjValue(to_mvmt_yd_cd, yardCd);
             				}
        	       		}
             			var yardCd2=ComGetObjValue(comboObjects[3]);
             			if(yardCd2 != '') {
             				var yardFmto=ComGetObjValue(yard_fmto);
             				if(yardFmto == 'yard_fm') {
             					ComSetObjValue(fm_mvmt_yd_cd, yardCd2);
             					ComSetObjValue(to_mvmt_yd_cd, '');
             				} else {
             					ComSetObjValue(fm_mvmt_yd_cd, '');
             					ComSetObjValue(to_mvmt_yd_cd, yardCd2);
             				}
             			}
             			// System performance can be slow with "No Charge" included.
             			// Do you want to proceed?
             			var stsCd=comboObjects[2].GetSelectCode();
             			if(stsCd.indexOf('N') != -1) {
             				if(!ComShowCodeConfirm('DMT01142'))
             					return false;
             			}
             		} else if(condType == 'vvd_cd') {
             			if( ComChkLen(vvd_cd, 9) != 2) {	
             				//ComShowCodeMessage('DMT00102', "VVD CD");
             				ComAlertFocus(vvd_cd, ComGetMsg('DMT00119', 'VVD CD', '9'));
         					return false;
             			}
             			ComSetObjValue(pod_cd, "");
             			ComSetObjValue(pol_cd, "");
             			var tmnlCd=ComGetObjValue(tmnl_cd);
             			if(tmnlCd != '') {
             				if( tmnlCd.length < 5 || tmnlCd.length == 5 && ComGetObjValue(chk_loc_cd) == "N" ) {	
             					//ComAlertFocus(tmnl_cd, ComGetMsg('DMT00110', 'Location'));
             					ComShowCodeMessage('DMT00110', 'Location');
            	       			return false;
             				}
             				var trf_cd=comboObjects[1].GetSelectCode();
             				if(trf_cd.indexOf('I') != -1)	// Inbound
             					ComSetObjValue(pod_cd, tmnlCd);
             				if(trf_cd.indexOf('O') != -1)	// Outbound
             					ComSetObjValue(pol_cd, tmnlCd);
             			}
             		} else {
         				if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(cntr_no)) {
             				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
                 			return false;
         				}
             			var bkgNo=ComGetObjValue(bkg_no);
             			if(bkgNo != '') {
             				var arrBkgNo=bkgNo.split(',');
             				for(var i=0; i<arrBkgNo.length; i++) {
             					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
             						ComAlertFocus(bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
    	                 			return false;
             					}
             				}
             			}
             			var blNo=ComGetObjValue(bl_no);
             			if(blNo != '') {
             				var arrBlNo=blNo.split(',');
             				for(var i=0; i<arrBlNo.length; i++) {
             					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
             						ComAlertFocus(bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
    	                 			return false;
             					}
             				}
             			}
             			var cntrNo=ComGetObjValue(cntr_no);
             			if(cntrNo != '') {
             				var arrCntrNo=cntrNo.split(',');
             				for(var i=0; i<arrCntrNo.length; i++) {
             					if(ComChkLen(arrCntrNo[i], 14) == 0) {	
             						ComAlertFocus(cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
    	                 			return false;
             					}
             				}
             			}
             		}
             		if(svc_provdr.value != '') {
             			if(!ComIsNumber(svc_provdr)) {
             				ComAlertFocus(svc_provdr, ComGetMsg('COM12122', 'Service Provider'));
             				return false;
             			}
             			if(ComChkLen(svc_provdr, 6) != 2) {
         					ComAlertFocus(svc_provdr, ComGetMsg('DMT00120', 'Service Provider', '6'));
         					return false;
         				}
             		}
             		break;
             	case IBDELCANCEL:
             		if(ComGetObjValue(formObj.role_permit) != 'Y') {           		
             			ComShowCodeMessage('DMT01145', 'DEL Cancel');
             			return false;
             		}
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('DMT01042');
             			return false;
             		}
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts != 'D') {
         					ComShowCodeMessage('DMT01042');
         					sheetObj.SetSelectRow(chkRows[i]);
         					return false;
         				}
             		}
             		if(!ComShowCodeConfirm('DMT01063'))
             			return false;
             		break;
        	 } // switch-end
         } // with-end
         return true;
     }
     
 	function isTariffAllCheck(comboObj) {
		var allTariffCnt = comboObj.GetItemCount();
		var selTariffCnt = 0;
		for (var i = 1; i < allTariffCnt; i++) {	// All 항목은 제외
			if (comboObj.GetItemCheck(i)) selTariffCnt++;
		}
		
		return selTariffCnt == allTariffCnt-1;		// 선택항목에서 All 항목은 제외
	}	
	/* Developer's task end */
