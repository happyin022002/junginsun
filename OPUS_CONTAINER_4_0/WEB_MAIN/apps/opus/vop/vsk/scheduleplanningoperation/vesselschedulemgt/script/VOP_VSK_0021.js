/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0021.js
*@FileTitle  : VSL SKD Inquiry by Port
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class vop_vsk_0021 : business script for VOP_VSK_0021
	 */
//	function vop_vsk_0021() {
//		this.processButtonClick=tprocessButtonClick;
//		this.setSheetObject=setSheetObject;
//		this.loadPage=loadPage;
//		this.initSheet=initSheet;
//		this.initControl=initControl;
//		this.doActionIBSheet=doActionIBSheet;
//		this.setTabObject=setTabObject;
//		this.validateForm=validateForm;
//	}
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		 var sheetObject=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_port":
					doActionIBSheet(sheetObject,formObject,COMMAND01);
					break;
				case "btn_vsl_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND04);
					break;
				case "btn_lane_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND02);
					break;
				case "btn_carrier_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND03);
					break;
				case "btn_period":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
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
		//from today to 1 month after
		document.form.fm_dt.value=ComGetNowInfo();
		document.form.to_dt.value=ComGetDateAdd(null, "M", 1);
		document.form.vps_port_cd.focus();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	  /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetID) {
			case "sheet1":      // sheet1 init
				with (sheetObj) {	      
//			        (15, 0, 0, true);
			        var HeadTitle	= "VVD|Vessel Name|Lane\nCode|Consortium Voyage|Consortium Voyage|TMNL\nCode|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time|Cargo Closing Time\nfor VGM|Coastal SKD|Coastal SKD|Coastal SKD|Next Port|Next Port|P/F SKD|P/F SKD|Delay|Delay|Carrier\nCode|TMNL\nName";
			        var HeadTitle2	= "VVD|Vessel Name|Lane\nCode|Arr Ext Voy Ref|Dep Ext Voy Ref|TMNL\nCode|General|DG|Reefer|Awkward|Break Bulk|Cargo Closing Time\nfor VGM|ETA|ETB|ETD|Port|ETA|ETB|ETD|Berth|Dep|Carrier\nCode|TMNL\nName";	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols =[{Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_eng_nm",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd", 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cssm_voy_no", keyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:10},
					           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_cssm_voy_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:10},
				               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_tml_cd",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cgo_clz_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dcgo_clz_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rc_clz_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"awk_cgo_clz_dt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bb_cgo_clz_dt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               
				               {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vgm_clz_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_eta",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_etb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_etd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix+"next_port",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_eta",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_etb",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_etd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dely_etb_tm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dely_etd_tm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"carrier_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_yard_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			         
			        InitColumns(cols);
			        SetEditable(0);
			        resizeSheet();
			        
			        SetColProperty(prefix+"cgo_clz_dt", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"dcgo_clz_dt", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"rc_clz_dt", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"awk_cgo_clz_dt", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"bb_cgo_clz_dt", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"vgm_clz_dt", {Format:"####-##-## ##:##"} );
			        
			        SetColProperty(prefix+"pol_eta", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pol_etb", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pol_etd", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"next_eta", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pf_etb", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pf_etd", {Format:"####-##-## ##:##"} );
				}
				break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetID=sheetObj.id;
		var sUrl="";
		switch(sAction) {
		   case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("VOP_VSK_0021GS.do", sParam);
					ComOpenWait(false);
					showSheetData(sheetObj,formObj,sXml);
				}
				break;
			case SEARCH01:				//Port Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH01;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0021GS.do", sParam);
					return sXml;
				}
			case SEARCH02:				//Carrier Check
				if(validateForm(sheetObj,formObj,sAction)){
		        	formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj);
					var code=formObj.carrier_cd.value;
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0252GS.do?grd_nm=CD0XXXX&code="+code, sParam);
					return sXml;
				}
				break;
			case SEARCH03:				//Vessel Check
				if(validateForm(sheetObj,formObj,sAction)){
		        	formObj.f_cmd.value=SEARCH03;
					var sParam=FormQueryString(formObj);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0021GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH04:				//Lane Check
				if(validateForm(sheetObj,formObj,sAction)){
		        	formObj.f_cmd.value=SEARCH03;
					var sParam=FormQueryString(formObj);
 					var sXml=sheetObj.GetSearchData("VSK_COMGS.do", sParam);
					return sXml;
				}
				break;
			case IBDOWNEXCEL:        	//excel download
				if(sheetObj.RowCount() < 1){//no data
           		 ComShowCodeMessage("COM132501");
   	       		}else{
   	       			//sheetObj.Down2Excel({ HiddenColumn:1,Merge:true});
   	       			sheetObj.Down2Excel({HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
   	       		}
				break;
			case COMMAND01:      // Port Pop-up
				sUrl="/opuscntr/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
				break;
			case COMMAND02:      // Lane Pop-up
				sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenPopup(sUrl, 500, 470, "returnLaneCdHelp", "0,0", true);
				break;
			case COMMAND03:      // Carrier Pop-up
				sUrl="/opuscntr/VOP_VSK_0252.do?code_type=CD0XXXX&code_value="+formObj.carrier_cd.value;
				ComOpenPopup(sUrl, 500, 420, "returnCrrCdHelp", "0,0", true);
				
//				var rVal=ComOpenPopupWithTarget(sUrl, 500, 420, "", "0,0", true);
//				returnCrrCdHelp(rVal);
				break;
			case COMMAND04:      // Carrier Pop-up
				sUrl="/opuscntr/VOP_VSK_0219.do";
        		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
		case IBSEARCH:      //Retrieve
//			if(ComIsNull(formObj.vps_port_cd.value)){
//				ComShowCodeMessage('VSK00027', "Port");
//				formObj.vps_port_cd.focus();
//				return false;
//			}
			if (ComIsNull(formObj.fm_dt.value)) {
				ComShowCodeMessage('VSK00027', "Period(From)");
				formObj.fm_dt.focus();
				return false;
			}
			if (ComIsNull(formObj.to_dt.value)) {
				ComShowCodeMessage('VSK00027', "Period(To)");
				formObj.to_dt.focus();
				return false;
			}
			// Period Check(in 1 month).
			if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "Y")){
				ComShowCodeMessage("VSK00105", "1 year");
				return false;
			}
			// !(fm_dt < to_dt), error
			if(!checkPeriod(formObj.fm_dt, formObj.to_dt)){
				ComShowCodeMessage("VSK00025", "End date", "start date");
				return false;
			}
			break;
    	}
		return true;
	}
	/**
     * process after retrieve.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix=sheetObj.id + "_";
		if(sXml != null){
			var rootNode=VskGetXmlRootNode(sXml);
//			var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
			if(dataNode){
				var totValue=dataNode.value;
				if(totValue > 0){
					sheetObj.RenderSheet(0);
					var xmlYdKind=ComGetEtcData(sXml, "yd_kind");
					sheetObj.SetColProperty(prefix+"pol_tml_cd", {ComboText:xmlYdKind, ComboCode:xmlYdKind} );
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObj.RenderSheet(1);
				}else{
					sheetObj.RenderSheet(0);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObj.RenderSheet(1);
				}
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
    	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	}
	function obj_change(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
	    /*******************************************************/
		try {
			var eleObj=window.event.srcElement;
			var srcName=eleObj.getAttribute("name");
			checkObj(srcName);
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	

	function obj_keydown() {
		var keyValue=ComGetEvent('keycode');
		//Enter event
		if(keyValue == 13){
			var flg=0;
			var srcName=ComGetEvent("name");
			switch(srcName){
				case "fm_dt":
				case "to_dt":
				case "vps_port_cd":
				case "vsl_cd":
				case "vsl_slan_cd":
				case "carrier_cd":
					if(!checkObj(srcName)){
						flg=1;
					}
					break;
			}
			if(flg != 1){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		}
	}
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
	/**
	 * Calling from [Port] Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vps_port_cd.value=rtnDatas;
					formObj.loc_cd.value=rtnDatas;
					sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.vps_port_cd.value="";
						formObj.vps_port_cd.focus();
					}else{
						formObj.fm_dt.focus();
					}
				}
			}
		}
	}
	/**
	 * Calling from [Lane Code] Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnLaneCdHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
        if(jQuery.type(rtnObjs) === "string") {
            formObj.vsl_slan_cd.value=rtnObjs;
        }else{
            if(rtnObjs){
                var rtnDatas=rtnObjs[0];
                if(rtnDatas){
                    if(rtnDatas.length > 0){
                        formObj.vsl_slan_cd.value=rtnDatas[1];
                    }
                }
            }
        }
	}
	/**
	 * Handling data from VSL Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj=document.form;
    	
    	if(jQuery.type(rtnObjs) === "string") {
            formObj.vsl_cd.value=rtnObjs;
        }else{
            if(rtnObjs){
                var rtnDatas=rtnObjs[0];
                if(rtnDatas){
                    if(rtnDatas.length > 0){
                        formObj.vsl_cd.value=rtnDatas[1];
                    }
                }
            }
        }    	
    }
	/**
	 * Setting Carrier Code
	 * @param sCrrCd
	 * @return
	 */
	function returnCrrCdHelp(sCrrCd){
		var formObj=document.form;
		if(sCrrCd != null && sCrrCd != undefined && sCrrCd != ""){
			formObj.carrier_cd.value=sCrrCd;
		}else{
			formObj.carrier_cd.value="";
		}
		formObj.carrier_cd.value=formObj.carrier_cd.value.substring(0,3);
	}
	/**
     * Handling with Port Code
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	var chkPort=ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			if(!ComIsNull(formObj.loc_cd.value)){
				ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
				formObj.loc_cd.value="";
			}
		}
		return false;
    }
    /**
     * Checking Vessel Code is exist in MDM_VSL_CNTR
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
    	if(ComChkLen(formObj.vsl_cd, 4) == 2){
			var sXml=doActionIBSheet(sheetObj, formObj, SEARCH03);
			var chkVslCd=ComGetEtcData(sXml, "vsl_chk");
			if(chkVslCd == "Y"){
	    		return true;
	    	}else{
	    		sheetObj.LoadSearchData(sXml,{Sync:1} );
	    		formObj.vsl_cd.value="";
	    		return false;
	    	}
    	}else{
    		ComShowCodeMessage("COM12114", "Vessel Code");
    		formObj.vsl_cd.value="";
			return false;
    	}
	}
    /**
     * Checking Lane Code is valid
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslSlanCd(sheetObj, formObj){
    	if(formObj.vsl_slan_cd.value == null || formObj.vsl_slan_cd.value == undefined || formObj.vsl_slan_cd.value == "") return false;
    	if(ComChkLen(formObj.vsl_slan_cd, 3) == 2){
			var sXml=doActionIBSheet(sheetObj, formObj, SEARCH04);
			var chkLane=ComGetEtcData(sXml, "checkLane");
			if(chkLane == null || chkLane == undefined || chkLane == ""){
	    		sheetObj.LoadSearchData(sXml,{Sync:1} );
	    		formObj.vsl_slan_cd.value="";
	    		return false;
	    	}else{
	    		return true;
	    	}
    	}else{
    		ComShowCodeMessage("COM12114", "Lane Code");
    		formObj.vsl_slan_cd.value="";
			return false;
    	}
	}
    /**
     * Checking Carrier Code is valid
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckCarrierCd(sheetObj, formObj){
    	if(formObj.carrier_cd.value == null || formObj.carrier_cd.value == undefined || formObj.carrier_cd.value == "") return false;
    	if(ComChkLen(formObj.carrier_cd, 3) == 2){
    		var sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
    		var crrCd=ComGetEtcData(sXml, "crr_cd");
    		if(crrCd == null || crrCd == undefined || crrCd == ""){
    			ComShowCodeMessage('VSK00021', formObj.carrier_cd.value);
    			formObj.carrier_cd.value="";
    			return false;
    		}else{
    			return true;
    		}
		}else{
			ComShowCodeMessage("COM12114", "Carrier Code");
			formObj.carrier_cd.value="";
			return false;
		}
    }
    /**
     * Handling mouse move event 
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	var Row=sheetObj.MouseRow();
    	var Col=sheetObj.MouseCol();
    	var sText=sheetObj.GetCellText(Row, sheetObj.id + "_pol_yard_nm");
    	if(Col == sheetObj.SaveNameCol(sheetObj.id + "_pol_tml_cd")){
    //no support[check again]CLT 		sheetObj.MouseToolTipText=sText;	
    	}else{
    //no support[check again]CLT 		sheetObj.MouseToolTipText="";
    	}
    }
 	function checkObj(srcName){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
        switch(srcName) {
            case "vps_port_cd":
            	var portCd=formObj.vps_port_cd.value;
            	if(portCd != ""){
            		formObj.loc_cd.value=portCd;
					var sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.vps_port_cd.value="";
						formObj.vps_port_cd.focus();
						return false;
					}else{
						formObj.vsl_cd.focus();
						return true;
					}
            	}
            	break;
            case "vsl_cd":
            	if(isCheckVslCd(sheetObj, formObj)){
            		formObj.vsl_slan_cd.focus();
            		return true;
            	}else{
            		formObj.vsl_cd.focus();
            		return false;
            	}
            	break;
            case "vsl_slan_cd":
            	if(isCheckVslSlanCd(sheetObj, formObj)){
            		formObj.carrier_cd.focus();
            		return true;
            	}else{
            		formObj.vsl_slan_cd.focus();
            		return false;
            	}
            	break;
        	case "carrier_cd":
        		if(isCheckCarrierCd(sheetObj, formObj)){
        			formObj.type_cd[0].focus();
        			return true;
            	}else{
            		formObj.carrier_cd.focus();
            		return false;
            	}
        		break;
        	case "fm_dt":
        		var fmDt=ComGetMaskedValue(formObj.fm_dt.value, "ymd");
        		if(formObj.fm_dt.value == fmDt){
        			return true;
        		}else{
        			formObj.fm_dt.value=fmDt;
        			return false;
        		}
               	break;
            case "to_dt":
            	var toDt=ComGetMaskedValue(formObj.to_dt.value, "ymd")
            	if(formObj.to_dt.value == toDt){
        			return true;
        		}else{
        			formObj.to_dt.value=toDt;
        			return false;
        		}
               	break;
        } // end switch
	}
	function checkPeriod(fromDate, toDate){
		var fmDt=ComReplaceStr(fromDate.value, "-", "");
		var toDt=ComReplaceStr(toDate.value, "-", "");
		if(ComChkPeriod(fmDt, toDt) < 1){
			return false;
		}else{
			return true;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
