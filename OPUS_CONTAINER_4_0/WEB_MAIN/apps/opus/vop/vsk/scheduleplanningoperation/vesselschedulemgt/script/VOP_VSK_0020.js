/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0020.js
*@FileTitle  : VSL SKD Inquiry by Port to Port
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
	 * @class vop_vsk_0020 : business script for VOP_VSK_0020
	 */
//	function vop_vsk_0020() {
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
				case "btn_pol":
					doActionIBSheet(sheetObject,formObject,COMMAND01);
					break;
				case "btn_pod":
					doActionIBSheet(sheetObject,formObject,COMMAND02);
					break;
				case "btn_lane_cd":
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
		//from first day of current month to today
		document.form.fm_dt.value=ComGetNowInfo("ym") + "-01";
		document.form.to_dt.value=ComGetNowInfo();
		document.form.pol_port.focus();
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
			        var HeadTitle1="Seq.|VVD|Lane\nCode|Consortium Voyage|Consortium Voyage|POL|POL|POL|POL|POD|POD|POD|POD|Delay\nDate|Carrier\nCode";
			        var HeadTitle2="Seq.|VVD|Lane\nCode|Arr Ext Voy Ref|Dep Ext Voy Ref|Port|ETA|ETB|ETD|Port|ETA|ETB|ETD|Delay\nDate|Carrier\nCode";
			        var HeadHiddenTitle="";
			        HeadTitle1=HeadTitle1 + HeadHiddenTitle;
			        HeadTitle2=HeadTitle2 + HeadHiddenTitle;
			        var headCount=ComCountHeadTitle(HeadTitle1);
//			        (headCount, 0, 0, true);	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq" },
				               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cssm_voy_no", keyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:10},
					           {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_cssm_voy_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:10}, 
				               //{Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_tml_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_yard",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               
				              
				               
				               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_eta",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_etb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_etd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               
				               //{Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_tml_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_yard",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               
				               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_eta",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_etb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_etd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"delay_date",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"carrier_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			         
			        InitColumns(cols);
			        SetEditable(0);
			        resizeSheet();
			        SetColProperty(prefix+"pol_eta", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pol_etb", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pol_etd", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pod_eta", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pod_etb", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"pod_etd", {Format:"####-##-## ##:##"} );
				}
				break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetID=sheetObj.id;
		switch(sAction) {
		   case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("VOP_VSK_0020GS.do", sParam);
					ComOpenWait(false);
					showSheetData(sheetObj,formObj,sXml);
				}	
				break;
			case SEARCH01:		//
				
				if(validateForm(sheetObj,formObj,sAction)){
					
					formObj.f_cmd.value=SEARCH01;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0020GS.do", sParam);
					
 					return sXml;
					
				}
				break;
			case IBDOWNEXCEL:
				if(sheetObj.RowCount() < 1){//no data
           		 ComShowCodeMessage("COM132501");
   	       		}else{
   	       			//sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
   	       			sheetObj.Down2Excel({HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
   	       		}
				break;
			case COMMAND01:      // Port(POL) Pop-up
				//sUrl = "/opuscntr/VOP_VSK_0043.do?op_=0043";
				sUrl="/opuscntr/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 550, 550, "returnPolHelp", "0,0", true);
				break;
			case COMMAND02:      // Port(POD) Pop-up
				//sUrl = "/opuscntr/VOP_VSK_0043.do?op_=0043";
				sUrl="/opuscntr/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 550, 550, "returnPodHelp", "0,0", true);
				break;
			case COMMAND03:      // Lane Pop-up
				//sUrl = "/opuscntr/VOP_VSK_0202.do?op_=0202";
				sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenPopup(sUrl, 500, 470, "returnLaneCdHelp", "0,0", true);
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(ComIsNull(formObj.pol_port.value)){
				ComShowCodeMessage('VSK00027', "POL");
				formObj.pol_port.focus();
				return false;
			} else if (ComIsNull(formObj.pod_port.value)) {
				ComShowCodeMessage('VSK00027', "POD");
				formObj.pod_port.focus();
				return false;
			} else if (ComIsNull(formObj.fm_dt.value)) {
				ComShowCodeMessage('VSK00027', "Period(From)");
				formObj.fm_dt.focus();
				return false;
			} else if (ComIsNull(formObj.to_dt.value)) {
				ComShowCodeMessage('VSK00027', "Period(To)");
				formObj.to_dt.focus();
				return false;
			}
			//By Hwang
			// Checking period
			if (ComChkPeriod(formObj.fm_dt, formObj.to_dt) < 1) {
				ComShowCodeMessage("VSK00025", "End date", "start date");
				formObj.fm_dt.focus();
				return false;
			}
			// Checking period
			if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
				ComShowCodeMessage("VSK00105", "1 month");
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
					var xmlPolKind=ComGetEtcData(sXml, "pol_yd_kind");
					var xmlPodKind=ComGetEtcData(sXml, "pod_yd_kind");
					sheetObj.SetColProperty(prefix+"pol_tml_cd", {ComboText:xmlPolKind, ComboCode:xmlPolKind} );
					sheetObj.SetColProperty(prefix+"pod_tml_cd", {ComboText:xmlPodKind, ComboCode:xmlPodKind} );
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					sheetObj.RenderSheet(1);
				}else{
					sheetObj.RenderSheet(0);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObj.RenderSheet(1);
				}
			}
		}
	}
	function initControl() {
    	axon_event.addListenerForm('activate', 'obj_activate', form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		
//    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
//    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	}
	function obj_change(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
	    /*******************************************************/
		try {
			var srcName=ComGetEvent("name");
	        switch(srcName) {
	            case "pol_port":
	            	var polCd=formObj.pol_port.value;
	            	if(polCd != ""){
		            	formObj.loc_cd.value=polCd;
						var sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
						if(!isCheckPortForm(sheetObj, formObj, sXml)){
							formObj.pol_port.value="";
							formObj.pol_port.focus();
						}else{
							formObj.pod_port.focus();
						}
	            	}
	            	break;
	            case "pod_port":
	            	var podCd=formObj.pod_port.value;
	            	if(podCd != ""){
		            	formObj.loc_cd.value=podCd;
						var sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
						if(!isCheckPortForm(sheetObj, formObj, sXml)){
							formObj.pod_port.value="";
							formObj.pod_port.focus();
						}else{
							formObj.vsl_slan_cd.focus();
						}
	            	}
	            	break;
	            case "vsl_slan_cd":
	            	var vslSlanCd=formObj.vsl_slan_cd.value;
	            	if(!ComIsNull(vslSlanCd)){
	            		if(vslSlanCd.length < 3){
	            			ComShowCodeMessage('VSK01018', vslSlanCd);
	            			formObj.vsl_slan_cd.value="";
	        				formObj.vsl_slan_cd.focus();
	        				return false;
	            		}
	            	}
	            	break;
                case "fm_dt":
                	formObj.fm_dt.value=ComGetMaskedValue(formObj.fm_dt.value, "ymd");
                	break;
                case "to_dt":
                	formObj.to_dt.value=ComGetMaskedValue(formObj.to_dt.value, "ymd");
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
	function obj_keypress(){
		var formObj=document.form;
		switch (ComGetEvent("name")) {
		    case "pol_port":
		    	ComKeyOnlyAlphabet('upper');
				break;
		    case "pod_port":
		    	ComKeyOnlyAlphabet('upper');
				break;
		    case "vsl_slan_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
		    case "fm_dt":
		    	ComKeyOnlyNumber(formObj.fm_dt);
				break;
		    case "to_dt":
		    	ComKeyOnlyNumber(formObj.to_dt);
				break;
		}
	}
	function obj_keyup(){
		var eleObj=ComGetEvent();
		var formObj=document.form;
		switch (eleObj.name) {
		    case "pol_port":
		    	if(eleObj.value.length == 5){
		    		formObj.pod_port.focus();
		    	}
				break; 
		    case "pod_port":
		    	if(eleObj.value.length == 5){
		    		formObj.vsl_slan_cd.focus();
		    	}
				break;
		    case "vsl_slan_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.fm_dt.focus();
		    	}
				break;
		}
	}
	function obj_activate() {
		var srcName=ComGetEvent("name");
		switch(srcName){
			case "fm_dt":
			case "to_dt":
				ComClearSeparator(ComGetEvent());
				event.srcElement.select();
				break;
		}
	}
	function obj_blur(){
		var srcName=ComGetEvent("name");
		switch(srcName){
			case "fm_dt":
			case "to_dt":
				ComChkObjValid(ComGetEvent());
				break;
		}
	}
	/**
	 * After [Port(POL)] Button Click, call from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnPolHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.pol_port.value=rtnDatas;
					formObj.loc_cd.value=rtnDatas;
					var sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						formObj.pol_port.value="";
						formObj.pol_port.focus();
					}else{
						formObj.pod_port.focus();
					}
				}
			}
		}
	}
	/**
	 * After [Port(POD)] Button Click, call from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnPodHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.pod_port.value=rtnDatas;
					formObj.loc_cd.value=rtnDatas;
					
					var sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
					
					if(!isCheckPortForm(sheetObj, formObj, sXml)){
						
						formObj.pod_port.value="";
						formObj.pod_port.focus();
					}else{
						
						formObj.vsl_slan_cd.focus();
					}
				}
			}
		}
	}
	/**
	 * After [Lane Code] Button Click, call from Pop-up
	 * @param rtnObjs
	 * @return
	 */

	function returnLaneCdHelp(rVal){
		var formObj=document.form;
		var rtnObjs  = rVal[0]
		if(rtnObjs){
				if(rtnObjs.length > 0){
					formObj.vsl_slan_cd.value=rtnObjs[1];
				}
		}
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
    	var prefix=sheetObj.id + "_";
    	var chkPort=ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
			formObj.loc_cd.value="";
		}
		return false;
    }
	/**
     * Handling with Port Code
     * 
     * @param sheetObj
     * @param sRow
     * @param sXml
     * @return
     */
    function isCheckPortSheet(sheetObj, sRow, sXml){
    	var prefix=sheetObj.id + "_";
    	var chkPort=ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("VSK00029", sheetObj.GetCellValue(sRow, prefix+"vps_port_cd"));
			sheetObj.SetCellValue(sRow, prefix+"vps_port_cd","",0);
			sheetObj.SelectCell(sRow, prefix+"vps_port_cd");
		}
		return false;
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
