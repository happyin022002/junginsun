/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0220.js
*@FileTitle  : Information Input for SKD Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class vop_vsk_0220 : business script for vop_vsk_0220
	 */
	function vop_vsk_0220() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
    	this.initCombo=initCombo;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//
	var glbEtbDyCdArr=new Array();
	var glbSkdDirCdArr=new Array();
	var glbClptSeqArr=new Array();
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
                case "btn_calendar":
                    var cal=new ComCalendar();
                    cal.select(formObject.vps_etb_dt, 'yyyy-MM-dd');
                    break;
                case "btn_pf_lane_help":
					var sUrl="/opuscntr/VOP_VSK_0212_POP.do?vsl_slan_cd="+formObject.vsl_slan_cd.value;
					ComOpenPopup(sUrl, 500, 450, "getPfLaneHelp", "0,0", true);
                    break;
                case "btn_ok":
                	doMakeReturnData(sheetObject, formObject);
                    break;
                case "btn_close":
                	ComClosePopup(); 
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
    	//============== TEST =================>>>
//    	document.form.vsl_slan_cd.value = "FEX";
    	//============== TEST =================<<<
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
        initControl();
        document.form.slan_stnd_flg.value="Y";
        doActionIBSheet(sheetObjects[0],document.form, SEARCH);
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
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
             var HeadTitle="||||||||";

             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:450,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_dy_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
              
             InitColumns(cols);
             SetVisible(false);
             SetEditable(1);
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
   	    	case "port_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "60");
   					SetColWidth(1, "30");
   					SetColWidth(2, "50");
  					SetDropHeight(160);
  //no support[check again]CLT 					UseCode=false;
   		    	}
   	    		break;
   	     }
   	}
   	// handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//alert( "search...." );
        sheetObj.ShowDebugMsg(false);
        //alert( "search....2" );
        switch(sAction) {
           	case SEARCH:      // combo Retrieve
				formObj.f_cmd.value=SEARCH;
                var sParam=FormQueryString(formObj);
                //alert( "search....3" );
                var sXml=sheetObj.GetSearchData("VOP_VSK_0220GS.do", sParam);
				formObj.etb_dy_cd.value="";
				//alert( "search....5" );
				showSheetData(sheetObj, formObj, sXml);
				//alert( "search....6" );
                break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
       		case COMMAND01:      // combo Retrieve
       			var startPort=getComboObject("port_cd").GetSelectText();
       			
       			var startDay=formObj.etb_dy_cd.value;
       			var vpsEtbDt=formObj.vps_etb_dt.value;
       			if(startPort == null || startPort == undefined || startPort == ""){
       				ComShowCodeMessage("VSK00021", "Start Port");
       				//getComboObject("port_cd").focus();
       				return;
       			}
       			
       			if(startDay == null || startDay == undefined || startDay == ""){
       				ComShowCodeMessage("VSK00021", "Start Day");
       				formObj.etb_dy_cd.focus();
       				return;
       			}
       			
       			if(vpsEtbDt == null || vpsEtbDt == undefined || vpsEtbDt == ""){
       				ComShowCodeMessage("VSK00021", "Start Port ETB Date");
       				formObj.vps_etb_dt.focus();
       				return;
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
    	setGlbFormData(sXml);
		//var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		//xmlDoc.loadXML(sXml);
		
		var rootNode=VskGetXmlRootNode(sXml);
		//var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
		var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
		
		//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
		if(dataNode){
			var totValue=dataNode;
			if(totValue > 0){
				var portCdArr=ComGetEtcData(sXml, "port_cd").split("|");
				var clptSeqArr=ComGetEtcData(sXml, "clpt_seq").split("|");
				var dirCdArr=ComGetEtcData(sXml, "skd_dir_cd").split("|");
				appendMultiComboItem(getComboObject("port_cd"), portCdArr, clptSeqArr, dirCdArr, "", "DEF");
				formObj.slan_stnd_flg.value="";
				var vslSlanNm=ComGetEtcData(sXml, "vsl_slan_nm");
				var pfSvcTpCd=ComGetEtcData(sXml, "pf_svc_tp_cd");
				if(vslSlanNm != null && vslSlanNm != undefined && vslSlanNm != ""){
					formObj.vsl_slan_nm.value=vslSlanNm;
				}
				if(pfSvcTpCd != null && pfSvcTpCd != undefined && pfSvcTpCd != ""){
					formObj.pf_svc_tp_cd.value=pfSvcTpCd;
				}
			}else{
				var comboObj=getComboObject("port_cd");
				comboObj.SetSelectIndex(0,false);
				comboObj.RemoveAll();
				formObj.pf_svc_tp_cd.value="";
				formObj.etb_dy_cd.value="";
				ComShowCodeMessage("VSK00043");
			}
		}else{
			sheetObj.LoadSearchData(sXml,{Sync:1} );
		}
    }
	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	function port_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		if(glbEtbDyCdArr != null && glbEtbDyCdArr.length > 0){
    		formObj.etb_dy_cd.value=glbEtbDyCdArr[newIndex];
    	}
    	if(glbSkdDirCdArr != null && glbSkdDirCdArr.length > 0){
    		formObj.skd_dir_cd.value=glbSkdDirCdArr[newIndex];
    	}
    	if(glbClptSeqArr != null && glbClptSeqArr.length > 0){
    		formObj.clpt_seq.value=glbClptSeqArr[newIndex];
    	}
	}
	/*
	 * =====================================================================
	 * registering initial event
	 * =====================================================================
	 */
    function initControl() {
    	axon_event.addListenerForm('change', 'obj_change', form);
    	axon_event.addListenerForm('keypress', 'obj_keypress', form);
    	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	}
    function obj_change(){
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
                case "pf_svc_tp_cd":
                	doActionIBSheet(sheetObjects[0],formObject, SEARCH);
                	break;
                case "vps_etb_dt":
                	formObject.vps_etb_dt.value=ComGetMaskedValue(formObject.vps_etb_dt.value, "ymd");
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
    function obj_keypress(){
		switch (event.srcElement.name) {
		    case "vps_etb_dt":
		    	ComKeyOnlyNumber(document.form.vps_etb_dt);
				break;
		    case "pf_svc_tp_cd":
		    	ComKeyOnlyNumber(document.form.pf_svc_tp_cd);
				break;
		}
    }
	function obj_keyup(){
		var eleObj=event.srcElement;
		var formObj=document.form;
		switch (eleObj.name) {
		    case "pf_svc_tp_cd":
		    	if(eleObj.value.length == 4){
		    		getComboObject("port_cd").focus();
		    	}
				break;
		}
	}
    /**
     * Open P/F TYPE Key Help
     * @return
     */
    function getPfLaneHelp(rtnObjs){
  
    	var sheetobj = sheetObjects[0];
    	var formObject=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObject.pf_svc_tp_cd.value=rtnObjs;
					doActionIBSheet(sheetObjects[0], formObject , SEARCH);
					
				}
			}
    	}
    }
    /**
     * Adding item to Mutil Combo
     * 
     * @param comboObj
     * @param optionCdArr
     * @param optionDescArr
     * @param selCode
     * @param sFlag
     * @return
     */
	function appendMultiComboItem(comboObj, portCdArr, clptSeqArr, dirCdArr, selCode, sFlag){
		comboObj.SetSelectIndex(0,false);portCdArr, clptSeqArr, dirCdArr
		comboObj.RemoveAll();
		if(sFlag == "DEF"){
			for(var i=0; i<portCdArr.length; i++) {
				comboObj.InsertItem(i, portCdArr[i]+"|"+clptSeqArr[i]+"|"+dirCdArr[i], portCdArr[i]);
			}
//		}else{
//			for(var i=0; i<optionCdArr.length; i++) {
//				comboObj.InsertItem(i, optionDescArr[i], portCdArr[i]);
//			}
		}
		comboObj.SetSelectCode(selCode,false);
	}
	/**
	 * Setting Direction Code List, Etb Dy Cd List
	 * 
	 * @param sXml
	 * @return
	 */
    function setGlbFormData(sXml){
		if(sXml == null  || sXml == "") return;
		var xmlEtcData="";
		xmlEtcData=ComGetEtcData(sXml, "skd_dir_cd");
		if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
			glbSkdDirCdArr=xmlEtcData.split("|");
		}else{
			glbSkdDirCdArr=null;
		}
		xmlEtcData=ComGetEtcData(sXml, "etb_dy_cd");
		if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
			glbEtbDyCdArr=xmlEtcData.split("|");
		}else{
			glbEtbDyCdArr=null;
		}
		xmlEtcData=ComGetEtcData(sXml, "clpt_seq");
		if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
			glbClptSeqArr=xmlEtcData.split("|");
		}else{
			glbClptSeqArr=null;
		}
    }
    /**
     * Transmitting Data to Parent screen
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
	function doMakeReturnData(sheetObj, formObj){
		var prefix=sheetObj.id + "_";
		if(validateForm(sheetObj,formObj,COMMAND01)){
			with (sheetObj) {
				DataInsert(-1);
//no support[check again]CLT 				getComboObject("port_cd").UseCode=true;
				SetCellValue(1, prefix+"vsl_slan_cd",formObj.vsl_slan_cd.value,0);
				SetCellValue(1, prefix+"vsl_slan_nm",formObj.vsl_slan_nm.value,0);
				SetCellValue(1, prefix+"pf_svc_tp_cd",formObj.pf_svc_tp_cd.value,0);
				SetCellValue(1, prefix+"port_cd",getComboObject("port_cd").GetSelectCode(),0);
				SetCellValue(1, prefix+"skd_dir_cd",formObj.skd_dir_cd.value,0);
				SetCellValue(1, prefix+"etb_dy_cd",formObj.etb_dy_cd.value,0);
				SetCellValue(1, prefix+"vps_etb_dt",formObj.vps_etb_dt.value,0);
				SetCellValue(1, prefix+"clpt_seq",formObj.clpt_seq.value,0);
			}
			comPopupOK();
		}
	}
    /**
     * Returning comboObject with comboId
     * 
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
