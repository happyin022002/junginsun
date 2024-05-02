/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0247.js
*@FileTitle  : SHA Loadable weight 계산/조회
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var glbPortCds=new Array();
	var glbVslCds=new Array();
	var glbSkdVoyNos=new Array();
	var glbSkdDirCds=new Array();
	var glbClptIndSeqs=new Array();
	var glbInitHeaderTitle="|||||||";
	var arrTitle="Calculation Cargo Weight for the ARR. Draft";
	var depTitle="Calculation Cargo Weight for the DEP. Draft";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];   //t1sheet1
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_calculaton":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
				case "rdo_tran":
					doActionIBSheet(sheetObject, formObject, COMMAND02);
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
    /**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage(){
		var formObj=document.form;
		for(i=0; i<sheetObjects.length; i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		document.all.item("titleLayer").innerHTML=arrTitle;
		initControl();
		initCallBaseData(formObj);
		//Setting post_type = "ARRIVAL" 
		formObj.post_type.value="ARRIVAL";
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
//	var leftHeaders = [{Text:"Start Date|Vessel Code|Start Voy. No.|P/F SKD Type|Out", Align:"Left"}];
	var LeftHeadTitle=[{Text:"BSA|Loadable Cargo Weight|Loaded Cargo Weight|Actual Loadable Weight", Align:"Left"}];
    function initSheet(sheetObj, sheetNo) {
        var cnt		= 0;
        var sheetID	= sheetObj.id;
		var prefix	= sheetID + "_";
		
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	                var HeadTitle=glbInitHeaderTitle;
	//                var LeftHeadTitle="BSA|Loadable Cargo Weight|Loaded Cargo Weight|Actual Loadable Weight"
//	                InitHeadColumn(0, LeftHeadTitle);
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:0 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ 
	                           	{Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"left_title", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"col01",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"col02",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"col03",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"col04",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"col05",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"col06",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:prefix+"col07",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                InitColumns(cols);
	                InitHeadColumn(LeftHeadTitle,sheetObj);
	                SetEditable(0);
	                SetSheetHeight(160);
                }
                break;
		}
    }
	/**
   	 * setting combo initial values and header 
   	 * param : comboObj, comboNo
   	 * adding case as numbers of counting combos 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form;
   	    switch(comboObj.id) {
	    	case "wgt_port_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColAlign(2, "left");
					SetColWidth(0, "24");
					SetColWidth(1, "50");
					SetColWidth(2, "40");
  					SetDropHeight(160);
   		    	}
   	    		break;
   	     }
   	}
	/**
	 * handling sheet process
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetID=sheetObj.id;
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj, formObj, sAction)){
					if (sheetID == "sheet1"){
						formObj.f_cmd.value	= SEARCH;
						var sParam	= FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
						var sXml	= sheetObj.GetSearchData("VOP_VSK_0247GS.do", sParam);
						showSheetData(sheetObj, formObj, sXml);
					}
				}
				break;
			case SEARCH01:        //Open(Call Indicator Retrieve).
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=SEARCH01;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0247GS.do", sParam);
					return sXml;
				}
				break;
			case COMMAND02:        //[ARRIVAL / DEPARTURE] Radio Button
				clearAllData(sheetObj, formObj);
				if(formObj.rdo_tran[0].checked){
					formObj.post_type.value="ARRIVAL";
					document.all.item("titleLayer").innerHTML=arrTitle;
				}else{
					formObj.post_type.value="DEPARTURE";
					document.all.item("titleLayer").innerHTML=depTitle;
				}
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//	        if (!isNumber(formObj.iPage)) {
//	            return false;
//	        }
		}
		return true;
	}
	/**
     * process after retrieve.
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
	function showSheetData(sheetObj, formObj, sXml){

		var title		= ComGetEtcData(sXml, "title");
		var vslClass	= ComGetEtcData(sXml, "vsl_class");
		var lightShip	= ComGetEtcData(sXml, "light_ship");
		var fuelOil		= ComGetEtcData(sXml, "fuel_oil");
		var dieselOil	= ComGetEtcData(sXml, "diesel_oil");
		var freshWater	= ComGetEtcData(sXml, "fresh_water");
		var ballast		= ComGetEtcData(sXml, "ballast");
		var draft		= ComGetEtcData(sXml, "draft");
		var tpc			= ComGetEtcData(sXml, "tpc");
		var displacement= ComGetEtcData(sXml, "displacement");
		var cargoWeight	= ComGetEtcData(sXml, "cargo_weight");
		
		if(vslClass != null && vslClass != undefined && vslClass != ""){
			formObj.vsl_class.value=vslClass;
		}
		if(lightShip != null && lightShip != undefined && lightShip != ""){
			formObj.light_ship.value=ComAddComma(lightShip);
		}
		if(fuelOil != null && fuelOil != undefined && fuelOil != ""){
			formObj.fuel_oil.value=ComAddComma(fuelOil);
		}
		if(dieselOil != null && dieselOil != undefined && dieselOil != ""){
			formObj.diesel_oil.value=ComAddComma(dieselOil);
		}
		if(freshWater != null && freshWater != undefined && freshWater != ""){
			formObj.fresh_water.value=ComAddComma(freshWater);
		}
		if(ballast != null && ballast != undefined && ballast != ""){
			formObj.ballast.value=ComAddComma(ballast);
		}
		if(draft != null && draft != undefined && draft != "" && draft != "null"){
			formObj.draft.value=ComAddComma(draft) + "M";
		}
		if(tpc != null && tpc != undefined && tpc != ""){
			formObj.tpc.value=ComAddComma(tpc);
		}
		if(displacement != null && displacement != undefined && displacement != ""){
			formObj.displacement.value=ComAddComma(displacement);
		}
		if(cargoWeight != null && cargoWeight != undefined && cargoWeight != ""){
			formObj.cargo_weight.value=ComAddComma(cargoWeight);
		}
//		if(displacement != null && displacement != undefined && displacement != ""){
//			var constant = formObj.constant.value;
//			var sumWt = Number(ComGetUnMaskedValue(ComNullToZero(lightShip), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(constant), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(fuelOil), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(dieselOil), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(freshWater), "float"))
//						+ Number(ComGetUnMaskedValue(ComNullToZero(ballast), "float"))
//						;
//			
//			formObj.cargo_weight.value = ComAddComma(displacement - sumWt);
//		}
		

		glbInitHeaderTitle	= '|'+title;
		
		//sheetObj = sheetObj.Reset();
		ComConfigSheet (sheetObj);
		initSheet(sheetObj, 1);
		ComEndConfigSheet(sheetObj);
		
		//sheetObj.RenderSheet(0);
		sheetObj.LoadSearchData(sXml, {Sync:0});
	}
	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	function wgt_port_cd_OnChange(comboObj, Code, Text) {
//		comboObj.UseCode = true;
		var formObj=document.form;
		for(var i=0; i<glbPortCds.length; i++){
			if(Text == glbSkdDirCds[i] + "|" + glbPortCds[i] + "|" + glbClptIndSeqs[i]){
				formObj.wgt_vsl_cd.value=glbVslCds[i];
				formObj.wgt_skd_voy_no.value=glbSkdVoyNos[i];
				formObj.wgt_skd_dir_cd.value=glbSkdDirCds[i];
				formObj.wgt_clpt_ind_seq.value=glbClptIndSeqs[i];
				break;
			}
		}
	}
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
	function initControl() {
    	axon_event.addListenerForm('change', 'obj_change', form); 	
    	//axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
//    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'skd_rmk');
	}
	function obj_change(){
		var formObject=document.form;
	    var sheetObj=sheetObjects[0];
	    try {
			var srcName=ComGetEvent("name");
	        switch(srcName) {
	            case "test":
	            	break;
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	/**
     * Initializing screen
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    //no support[implemented common]CLT 	sheetObj.InitHeadRow(0, glbInitHeaderTitle, true);
    	sheetObj.RemoveAll();
    	formObj.vsl_class.value="";
		formObj.fuel_oil.value="";
		formObj.light_ship.value="";
		formObj.diesel_oil.value="";
		formObj.draft.value="";
		formObj.tpc.value="";
		formObj.fresh_water.value="";
		formObj.cargo_weight.value="";
		formObj.constant.value="";
		formObj.ballast.value="";
		formObj.displacement.value="";
//    	formObj.constant.focus();
    }
	/**
	 * Getting Selected Base Data from parent screen
	 * 
	 * @param formObj
	 * @return
	 */
	function initCallBaseData(formObj){
		var opner=window.dialogArguments;
		var pSheetObj=getParentSheet();
		var prefix=pSheetObj.id + "_";
		var selRow=pSheetObj.GetSelectRow();
		var headRow=pSheetObj.HeaderRows();
		
		formObj.vsl_cd.value=pSheetObj.GetCellValue(selRow, prefix+"vsl_cd");
		formObj.skd_voy_no.value=pSheetObj.GetCellValue(selRow, prefix+"skd_voy_no");
		formObj.skd_dir_cd.value=pSheetObj.GetCellValue(selRow, prefix+"skd_dir_cd");
		formObj.loc_cd.value=pSheetObj.GetCellValue(selRow, prefix+"vps_port_cd");
		formObj.vps_port_cd.value=pSheetObj.GetCellValue(selRow, prefix+"vps_port_cd");
		formObj.clpt_ind_seq.value=pSheetObj.GetCellValue(selRow, prefix+"clpt_ind_seq");
		formObj.vps_eta_dt.value=Usr_GetDateTimeSet(pSheetObj.GetCellValue(selRow, prefix+"vps_eta_dt"));
		formObj.vps_etd_dt.value=Usr_GetDateTimeSet(pSheetObj.GetCellValue(selRow, prefix+"vps_etd_dt"));
		var clptSeq=pSheetObj.GetCellValue(selRow, prefix+"clpt_ind_seq");
		var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
		var callIndCds=ComGetEtcData(sXml, "call_ind_cd").split("|");
		var callIndNms=ComGetEtcData(sXml, "call_ind_nm").split("|");
		if(callIndCds){
			for(var i=0; i<callIndCds.length; i++){
				if(clptSeq == callIndCds[i]){
					formObj.call_ind_cd.value=clptSeq;
					formObj.call_ind_nm.value=callIndNms[i];
					break;
				}
			}
		}
		//pre Port
		var sVslCd=ComGetEtcData(sXml, "vsl_cd_list");
		if(sVslCd != null && sVslCd != undefined && sVslCd != ""){
			//Port List(Select Element) Setting...
			var comboObj=getComboObject("wgt_port_cd");
//			ComClearCombo(comboObj);
			comboObj.RemoveAll();
			glbVslCds=ComGetEtcData(sXml, "vsl_cd_list").split("|");
			glbSkdVoyNos=ComGetEtcData(sXml, "skd_voy_no_list").split("|");
			glbSkdDirCds=ComGetEtcData(sXml, "skd_dir_cd_list").split("|");
			glbPortCds=ComGetEtcData(sXml, "vps_port_cd_list").split("|");
			glbClptIndSeqs=ComGetEtcData(sXml, "clpt_ind_seq_list").split("|");
			formObj.wgt_vsl_cd.value=glbVslCds[0];
			formObj.wgt_skd_voy_no.value=glbSkdVoyNos[0];
			formObj.wgt_skd_dir_cd.value=glbSkdDirCds[0];
			formObj.wgt_clpt_ind_seq.value=glbClptIndSeqs[0];
			for(var i=0; i<glbPortCds.length; i++){
//				ComAddComboItem(comboObj, glbPortCds[i], glbPortCds[i]);
				comboObj.InsertItem(i, glbSkdDirCds[i]+"|"+glbPortCds[i]+"|"+glbClptIndSeqs[i], glbPortCds[i]);
			}
			comboObj.SetSelectCode(glbPortCds[0],false);
		}
	}
	/**
	 * Getting activated sheet from parent screen
	 * @return
	 */
	function getParentSheet(){
		var opner=window.dialogArguments;
		if (!opner)  opner=window.opener;  //이 코드 추가할것
		if (!opner) opner=parent; //이 코드 추가할것 

		if(opner.sheetObjects){
			if(opner.sheetObjects.length > 0){
				for(var i=0; i<opner.sheetObjects.length; i++){
					if(opner.document.form.rdo_tran[i].checked){
						return opner.sheetObjects[i];
					}
				}
			}else{
				return opner.sheetObjects[0];
			}
		}
		return null;
	}
    /**
     * Returning comboObject by comboId
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt=comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].options.id== comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	return null;
    }
	/**
	 * 
	 * @param sDate
	 * @return
	 */
	function Usr_GetDateTimeSet(sDate){
		var ymd="";
		var hm="";
		if(ComIsDateTime2(sDate, "ymdhm")){
			ymd=ComGetMaskedValue(sDate.substring(0, 8), "ymd");
			hm=ComGetMaskedValue(sDate.substring(8, 12), "hm");
		}else{
			return "";
		}
		return ymd + " " + hm;
	}

	function sheet1_OnSearchEnd(sheetObj , code , msg ){
		
	   if( sheetObj.RowCount() < 1){
	        InitHeadColumn(LeftHeadTitle,sheetObj);
	    } else {
	    	//InitHeadText(LeftHeadTitle,sheetObj);
	   }
	}
	