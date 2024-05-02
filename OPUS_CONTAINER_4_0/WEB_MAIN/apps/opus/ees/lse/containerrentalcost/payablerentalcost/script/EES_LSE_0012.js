/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0012.js
*@FileTitle  : Rental payable invoice inquiry and Cancel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_LSE_0012 :  business script for EES_LSE_0012
     */
    function EES_LSE_0012() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.setComboObject=setComboObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.obj_change=obj_change;
    	//this.obj_keypress=obj_keypress;
    	this.validateForm=validateForm;
    	this.loc_tp_OnChange=loc_tp_OnChange;
    	this.combo1_OnCheckClick=combo1_OnCheckClick;
    	this.combo1_OnBlur=combo1_OnBlur;
    	this.combo1_OnKeyDown=combo1_OnKeyDown;
    }
    /* developer job */
  // common global variables
  var sheetObjects=new Array();
  var sheetCnt=0;
  //Combo Object Array
  var comboObjects=new Array();
  var comboCnt=0;
  var now  ;
  var year ;
  var mon  ;
  var arrTpSz=new Array();
  var arrTpSz2=new Array();
  //Event handler processing by button click event */
  document.onclick=processButtonClick;
  function initControl() {
  	var formObj=document.form;
  	axon_event.addListenerForm('click','obj_click',formObj);         
  	axon_event.addListenerForm('change','obj_change',formObj);       
//  	axon_event.addListenerFormat('keypress','obj_keypress',formObj); 
  	axon_event.addListenerFormat('blur','obj_blur',formObj);         
//  	axon_event.addListenerFormat('focus','obj_focus',formObj);       
//  	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   
  }
  //Event handler processing by button name */
  function processButtonClick(){
  	/**********/
  	var sheetObject1=sheetObjects[0];
  	/*******************************************************/
  	var formObject=document.form;
  	try {
  		var srcObj=window.event.srcElement;
  		var srcName=ComGetEvent("name");
  		switch(srcName) {
  		case "btn_Retrieve":
  			if ( srcObj.style.filter == "" ) {
  				sheetObject1.RemoveAll();
  				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			}
  			break;
  		case "btn_Save":
  			if ( srcObj.style.filter == "" ) {
  			    doActionIBSheet(sheetObjects[0], document.form,IBSAVE);
  			}
  		break;
  		case "btn_New":
  			sheetObject1.RemoveAll();
  			formObject.search_tp[0].selected=true;
  			formObject.cost_st_month.value="";
  			formObject.cost_ed_month.value="";
  			formObject.invoice_st_month.value="";
  			formObject.invoice_ed_month.value="";
  			formObject.invoice_no.value="";
  			formObject.register_no.value="";
  			formObject.invoice_user.value="";
  	        var OBJ1=document.getElementById("fixLayer1");
			OBJ1.style.visibility="visible";
			var OBJ2=document.getElementById("fixLayer2");
			OBJ2.style.visibility="hidden";
            var OBJ3=document.getElementById("fixLayer3");
			OBJ3.style.visibility="hidden";
			var OBJ4=document.getElementById("fixLayer4");
			OBJ4.style.visibility="hidden";
//			var date = new Date();
//			var year = date.getFullYear();
//			var mon = date.getMonth();
			now=new Date();
		    year=now.getFullYear();
		    mon=(now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
            document.form.cost_st_month.value=year + "-" + mon;
		    document.form.cost_ed_month.value=year + "-" + mon;
		    //formObject.cost_st_month.focus();
			formObject.vndr_seq.value="";
			formObject.vndr_nm.value="";
			for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
		        comboObjects[0].SetItemCheck(i,0);
			}
			comboObjects[0].SetItemCheck(0,1);
			comboObjects[1].SetSelectIndex(0);
		    formObject.invoice_user.value="";
  			break;
  		case "btns_calendar1":
  			if ( srcObj.style.filter == "" ) {
  				var cal=new ComCalendar();
  				cal.setDisplayType('month');
  				cal.select(formObject.cost_st_month, "yyyy-MM");
  			}
  			break;
  		case "btns_calendar2":
  			if ( srcObj.style.filter == "" ) {
  				var cal=new ComCalendar();
  				cal.setDisplayType('month');
  				cal.select(formObject.cost_ed_month, "yyyy-MM");
  			}
  			break;
  		case "btns_calendar3":
  			if ( srcObj.style.filter == "" ) {
  				var cal=new ComCalendar();
  				cal.setDisplayType('month');
  				cal.select(formObject.invoice_st_month, "yyyy-MM");
  			}
  			break;
  		case "btns_calendar4":
  			if ( srcObj.style.filter == "" ) {
  				var cal=new ComCalendar();
  				cal.setDisplayType('month');
  				cal.select(formObject.invoice_ed_month, "yyyy-MM");
  			}
  			break;
  		case "btns_search2":     // lessor
  		if ( srcObj.style.filter == "" ) {
  			openPopup("2");
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
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
  */
  function setSheetObject(sheet_obj){
  	sheetObjects[sheetCnt++]=sheet_obj;
  }
  /**
  * registering IBMultiCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
  */
  function setComboObject(combo_obj){
  	comboObjects[comboCnt++]=combo_obj;
  }
  /**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
  */
  function loadPage() {
  	for(i=0;i<sheetObjects.length;i++){
  		ComConfigSheet (sheetObjects[i] );
  		initSheet(sheetObjects[i],i+1);
  		ComEndConfigSheet(sheetObjects[i]);
  	}
  	initControl();
  	/* initializing IBMultiCombo */
  	for ( var k=0 ; k < comboObjects.length ; k++ ) {
  		initCombo(comboObjects[k], k+1);
  	}
  	sheet1_OnLoadFinish(sheet1);
  }
  function sheet1_OnLoadFinish(){
  	/* IBMulti Combo Item Setting */
  	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);
	//ComBtnDisable("btn_Save");
  	var OBJ=document.getElementById("fixLayer1");
  	OBJ.style.visibility="visible";
  	comboObjects[0].SetItemCheck(0,1);
    now=new Date();
    year=now.getFullYear();
    mon=(now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
    document.form.cost_st_month.value=year + "-" + mon;
    document.form.cost_ed_month.value=year + "-" + mon;
    //document.form.cost_st_month.focus();
  }
  /**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
  */
  function initSheet(sheetObj,sheetNo) {
  	var cnt=0;
  	var sheetid=sheetObj.id;
  	switch(sheetid) {
  	case "sheet1":
  		with (sheetObj) {

	  	   var HeadTitle="sta|SEQ|Lessor|Pay Vendor|AGMT No.|Term|Payment Type|Invoice No|Register No|Issue Date|Receive Date|Cost Month|Charge Amount|Net Amount|V.A.Tax|W.H.Tax|Credit AMT|Total Amount|INV Month|INV Credit DT|User Name|Cancel|inv_sts_cd|";
	  	   var headCount=ComCountHeadTitle(HeadTitle);
	  	   //(headCount, 0, 0, true);
	
	  	   SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:0, Page:20, DataRowMerge:0 } );
	
	  	   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	  	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
	  	   InitHeaders(headers, info);
	
	  	   var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	  	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pay_vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"if_rgst_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_iss_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"chg_cost_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
	  	             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"pay_rntl_cost_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },	  	             
	  	             {Type:"Float",      Hidden:0, Width:120,  Align:"Right",  ColMerge:1,   SaveName:"inv_vat_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
		             {Type:"Float",      Hidden:0, Width:120,  Align:"Right",  ColMerge:1,   SaveName:"whld_tax_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
	  	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cr_ttl_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
	  	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_ttl_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_eff_yrmon",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"apro_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"apro_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"DelCheck",  Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"cancel_flag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	  	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	  	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"chg_tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
	  	    
	  	   InitColumns(cols);
	
	  	   SetEditable(1);
	  	   //SetSheetHeight(400);
	  	 resizeSheet();
  		}
  		break;
  	}
  }
  
  function resizeSheet(){      
      ComResizeSheet(sheetObjects[0]);  
  }
  //handling process for Sheet
  function doActionIBSheet(sheetObj,formObj,sAction) {
  	switch(sAction) {
	  	case IBSEARCH:      //조회
		  	if(validateForm(sheetObj,formObj,sAction)){
		  		if (sheetObj.id == "sheet1"){
		  			formObj.f_cmd.value=SEARCH;
		  			sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					sheetObj.DoSearch("EES_LSE_0012GS.do",FormQueryString(formObj) );
		  			
		  		}
		  	}
		  	break;
	  	case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
				if ( sheetObj.id == "sheet1") {
					formObj.f_cmd.value=MULTI;
					var sParam=sheetObj.GetSaveString();
					sParam += "&" + FormQueryString(formObj);
					ComOpenWait(true);
					var sXml=sheetObj.GetSaveData("EES_LSE_0012GS.do", sParam);
					ComOpenWait(false);
					sheetObj.LoadSaveData(sXml);
				}
			}
			break;
	  	case IBSEARCH_ASYNC03:
	  		/* Lease Term Form Combo Item Setting */
	  		ComSetObjValue(formObj.f_cmd, SEARCH01);
	  		sheetObj.SetWaitImageVisible(0);
	  		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
	  		if ( sXml != "" ) {
	  			comboObjects[0].InsertItem(0 , 'ALL','ALL');
	  			LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
	  		}
	  		vOrcLstmCd=ComGetEtcData(sXml, "lease_term_nm");
	  		
			formObj.f_cmd.value=SEARCH09;	
			var intgCdId='CD30090';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			if (xml != "") {
				var schargeType=ComGetEtcData(xml, "code_nm");
				var arrchargeType=schargeType.split("@");
				MakeComboObject(comboObjects[1], arrchargeType, 1, 0);
			}
			
	  		break;
	  	case IBSEARCH_ASYNC04:	//retrieving when input Form Lessor No.
		  	if ( validateForm(sheetObj, formObj, sAction) ) {
		  		var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		  		sheetObj.SetWaitImageVisible(0);
		  		var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
		  		if ( sXml != "" ) {
		  			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
		  				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
		  				//ComSetObjValue(formObj.abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
		  				ComSetFocus(formObj.vndr_nm);
		  			} else {
		  				ComShowCodeMessage("LSE01019");
		  				formObj.vndr_seq.value="";
		  				formObj.vndr_nm.value="";
		  				ComSetFocus(formObj.vndr_seq);
		  			}
		  		} else {
		  			ComShowCodeMessage("LSE01019");
		  			formObj.vndr_seq.value="";
		  			formObj.vndr_nm.value="";
		  			ComSetFocus(formObj.vndr_seq);
		  		}
		  	}
		  	break;
  	}
  }
  /**
  * handling process for input validation
  */
  function validateForm(sheetObj,formObj,sAction){
  	with(sheetObj){
  		with(formObj){
  			switch(sAction) {
  			case IBSEARCH:
  			if(document.form.search_tp.value == "01"  ){
  				var costStMonth=formObj.cost_st_month.value;
  				var costEdMonth=formObj.cost_ed_month.value;
  				if ( costStMonth == "" ) {
  					ComShowCodeMessage("LSE01010");
  					ComSetFocus(formObj.cost_st_month);
  					return false;
  					break;
  				}
  				if ( costEdMonth == "" ) {
  					ComShowCodeMessage("LSE01010");
  					ComSetFocus(formObj.cost_ed_month);
  					return false;
  					break;
  				}
  			}else if(document.form.search_tp.value == "02"  ){
  				var invoiceStMonth=formObj.invoice_st_month.value;
  				var invoiceEdMonth=formObj.invoice_ed_month.value;
  				if ( invoiceStMonth == "" ) {
  					ComShowCodeMessage("LSE01010");
  					ComSetFocus(formObj.invoice_st_month);
  					return false;
  					break;
  				}
  				if ( invoiceEdMonth == "" ) {
  					ComShowCodeMessage("LSE01010");
  					ComSetFocus(formObj.invoice_ed_month);
  					return false;
  					break;
  				}
  			}else if(document.form.search_tp.value == "03"  ){
  				if ( formObj.invoice_no.value == "" ) {
  					ComShowCodeMessage("LSE01104");
  					ComSetFocus(formObj.invoice_no);
  					return false;
  					break;
  				}
  			}else if(document.form.search_tp.value == "04"  ){
  				if ( formObj.register_no.value == "" ) {
  					ComShowCodeMessage("LSE01105");
  					ComSetFocus(formObj.register_no);
  					return false;
  					break;
  				}
  			}
  			break;
  			case IBSAVE:
  			    if(sheetObjects[0].RowCount()<= 0){
  			    	ComShowCodeMessage("LSE01048");
  			    	return false;
  					break;
  			    }else{
  			    	if(sheetObjects[0].CheckedRows("cancel_flag") <= 0){
  			    		ComShowCodeMessage("LSE01045");
  			    		return false;
  	  					break;
  			    	}
  			    }
  			break;
  			}
  		}
  	}
  	return true;
  }
  /**
  * handling Location blur event
  */
  function obj_blur(){
  	var obj=event.srcElement;
  	switch(ComGetEvent("name")){
  	case "btns_calendar3":
  		//checking number
  		ComChkObjValid(obj);
  		break;
  	case "vndr_seq":
  		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
  			document.form.vndr_nm.value="";
  			//document.form.abbr_nm.value = "";
  		}
  		break;
  	default:
  		//checking Validation
  	break;
  	}
  }
  /**
  * initializing IBMultiCombo
  */
  function initCombo(comboObj, comboNo) {
  	switch(comboObj.options.id) {
  	case "combo1":
  		with(comboObj) {
  			SetDropHeight(200);
  			SetMultiSelect(1);
  			//MaxSelect = 1;
  			SetMultiSeparator(",");
  			Style=0;
  			SetUseAutoComplete(1);
  			//only upper case, special characters, number - TP/SZ
  //no support[check again]CLT 			ValidChar(2,3);
  		}
  		break;
  	}
  }
  /**
   * handling event in case of OnCheckClick combo1
   * @return
   */
  //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

  function combo1_OnCheckClick(comboObj, index, code) {
	  if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
  }
  /**
   * combo1_OnBlur
   */
  function combo1_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
  	var formObj=document.form;
  	if( comboObj.GetItemCheck(0)){
  		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
  			comboObj.SetItemCheck(i,0);
  		}
  		formObj.lstm_cd.value="";
  	}else if(comboObj.GetSelectText()== ""){
  		comboObj.SetItemCheck(0,1);
  		formObj.lstm_cd.value="";
  	}else{
  	    formObj.lstm_cd.value=ComGetObjValue(comboObj);
  	}
  }
  /**
   * combo1_OnKeyDown
   */
  function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
      with(comboObj) {
          if ( KeyCode == 188 &&  comboObj.GetItemCheck(0)){
              comboObj.SetSelectText("");
  		  }else if(KeyCode == 13){
 		      sheetObjects[0].RemoveAll();
 			  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		  }
  	  }
  }
  /**
  * handing process Pop-up<br>
  * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
  * @param object
  * @param Row index
  */
  function openPopup(type, Row, Col) {
  	var formObj=document.form;
  	if ( type == "2") {
  		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
  	}
  }
  /**
  * handling process for Lessor(Service Provider) Pop-up Return Value<br>
  * @param Return value array
  * @param Row index
  * @param Col index
  * @param Sheet Array index
  */
  function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
  	var sheetObj=sheetObjects[SheetIdx];
  	var formObj=document.form;
  	if ( aryPopupData.length > 0 ) {
  		formObj.vndr_seq.value=ComLtrim(aryPopupData[0][2],"0");
  		formObj.vndr_nm.value=aryPopupData[0][4];
  		//formObj.abbr_nm.value  = aryPopupData[0][5];
  	}
  }
  /**
  * handling event in case of Change
  */
  function obj_change(){
  	var obj=event.srcElement;
  	var formObj=document.form;
  	switch(ComGetEvent("name")) {
  	case "vndr_seq":
  		if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
  		}
  	break;
  	case "search_tp":		//Location Code
  	formObj.cost_st_month.value="";
  	formObj.cost_ed_month.value="";
  	formObj.invoice_st_month.value="";
  	formObj.invoice_ed_month.value="";
  	formObj.invoice_no.value="";
  	formObj.register_no.value="";
  	if(document.form.search_tp.value == "01"  ){
  		var OBJ1=document.getElementById("fixLayer1");
  		OBJ1.style.visibility="visible";
  		var OBJ2=document.getElementById("fixLayer2");
  		OBJ2.style.visibility="hidden";
  		var OBJ3=document.getElementById("fixLayer3");
  		OBJ3.style.visibility="hidden";
  		var OBJ4=document.getElementById("fixLayer4");
  		OBJ4.style.visibility="hidden";
  		now=new Date();
	    year=now.getFullYear();
	    mon=(now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
        document.form.cost_st_month.value=year + "-" + mon;
	    document.form.cost_ed_month.value=year + "-" + mon;
        document.form.cost_st_month.value=year + "-" + mon;
	    document.form.cost_ed_month.value=year + "-" + mon;
  		//formObj.cost_st_month.focus();
  	}else if(document.form.search_tp.value == "02"  ){
  		var OBJ1=document.getElementById("fixLayer1");
  		OBJ1.style.visibility="hidden";
  		var OBJ2=document.getElementById("fixLayer2");
  		OBJ2.style.visibility="visible";
  		var OBJ3=document.getElementById("fixLayer3");
  		OBJ3.style.visibility="hidden";
  		var OBJ4=document.getElementById("fixLayer4");
  		OBJ4.style.visibility="hidden";
  		now=new Date();
	    year=now.getFullYear();
	    mon=(now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
        document.form.cost_st_month.value=year + "-" + mon;
	    document.form.cost_ed_month.value=year + "-" + mon;
        document.form.invoice_st_month.value=year + "-" + mon;
	    document.form.invoice_ed_month.value=year + "-" + mon;
  		//formObj.invoice_st_month.focus();
  	}else if(document.form.search_tp.value == "03"  ){
  		var OBJ1=document.getElementById("fixLayer1");
  		OBJ1.style.visibility="hidden";
  		var OBJ2=document.getElementById("fixLayer2");
  		OBJ2.style.visibility="hidden";
  		var OBJ3=document.getElementById("fixLayer3");
  		OBJ3.style.visibility="visible";
  		var OBJ4=document.getElementById("fixLayer4");
  		OBJ4.style.visibility="hidden";
  		formObj.invoice_no.focus();
  	}else if(document.form.search_tp.value == "04"  ){
  		var OBJ1=document.getElementById("fixLayer1");
  		OBJ1.style.visibility="hidden";
  		var OBJ2=document.getElementById("fixLayer2");
  		OBJ2.style.visibility="hidden";
  		var OBJ3=document.getElementById("fixLayer3");
  		OBJ3.style.visibility="hidden";
  		var OBJ4=document.getElementById("fixLayer4");
  		OBJ4.style.visibility="visible";
  		formObj.register_no.focus();
  	}
  	break;
  	case "cost_st_month":
  		if ( formObj.cost_ed_month.value != null && formObj.cost_ed_month.value != "" ) {
  			checkDatePeriod( formObj.cost_st_month , formObj.cost_ed_month , "ym") ;
  		}
  	break;
  	case "cost_ed_month":
  		checkDatePeriod( formObj.cost_st_month , formObj.cost_ed_month , "ym") ;
  	break;
  	case "invoice_st_month":
  		if ( formObj.invoice_ed_month.value != null && formObj.invoice_ed_month.value != "" ) {
  			checkDatePeriod( formObj.invoice_st_month , formObj.invoice_ed_month , "ym") ;
  		}
  	break;
  	case "invoice_ed_month":
  		checkDatePeriod( formObj.invoice_st_month , formObj.invoice_ed_month , "ym") ;
   	break;
  	}
  }
 
/**
* handling Location blur event
*/
function obj_blur(){
	var obj=event.srcElement;
	switch(ComGetEvent("name")){
	case "cost_st_month":
		//checking number
		ComChkObjValid(obj);
		break;
	case "cost_ed_month":
		//checking number
		ComChkObjValid(obj);
		break;
	case "invoice_st_month":
		//checking number
		ComChkObjValid(obj);
		break;
	case "invoice_ed_month":
		//checking number
		ComChkObjValid(obj);
		break;
		break;
	case "vndr_seq":
		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
			document.form.vndr_nm.value="";
			//document.form.abbr_nm.value = "";
		}
		break;
	default:
		//checking Validation
	break;
	}
}
/**
* handling event in case of Save-End sheet
*/
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if ( ErrMsg == "" ) {
		ComShowCodeMessage("LSE10001");
	} else {
		ComShowMessage(ErrMsg);
	}
}

/**
* Cancel Check 
*/
function  sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if(sheetObj.RowCount()> 0){
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
  				if(sheetObjects[0].GetCellValue( i , "inv_sts_cd") == "C" ||  sheetObjects[0].GetCellValue(i ,"inv_sts_cd") == "G" ||
  						sheetObjects[0].GetCellValue(i ,"inv_sts_cd") == "B" || sheetObjects[0].GetCellValue(i ,"inv_sts_cd") == "X"){
  						sheetObjects[0].SetCellEditable(i, "cancel_flag",1);
  				}else if(sheetObjects[0].GetCellValue( i , "inv_sts_cd") == "P" ||  sheetObjects[0].GetCellValue(i ,"inv_sts_cd") == "E" ){
  					//if(sheetObjects[0].CellValue(i ,"if_flg") == "E" ){
  					//	sheetObjects[0].CellEditable(i, "cancel_flag") = true;
  					//}else if( sheetObjects[0].CellValue(i ,"if_flg") == "Y" ){
  						//sheetObjects[0].CellEditable(i, "cancel_flag") = false;
  					//}else{
  						//sheetObjects[0].CellEditable(i, "cancel_flag") = false;
  					//}
  				}else{
  					sheetObjects[0].SetCellEditable(i, "cancel_flag",0);
  				}
	 		}
	}
	ComOpenWait(false);
}

/**
 * creating combo object(Spec No * Type/Size)
 */
function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0, "ALL", "ALL");
	for (var i=0; i<arrStr.length; i++) {
		var arrCode=arrStr[i].split("|");
		cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
	}
	cmbObj.SetSelectIndex(0 ,true);
}  
  /* end of developer job */
