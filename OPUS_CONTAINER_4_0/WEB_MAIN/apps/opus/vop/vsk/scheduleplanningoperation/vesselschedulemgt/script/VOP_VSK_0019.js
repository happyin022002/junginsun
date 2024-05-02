/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0019.js
*@FileTitle  : VSL SKD Inquiry by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Color public variable
	var glbBrthFontColor=null;
	var glbDepFontColor=null;
	var focusObj=null;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;  
            switch(srcName) {
				case "btn_retrieve":
				case "btn_retrieve_pop":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break;
				case "btn_vvd_search":
					var vslCd=formObject.vsl_cd.value;
                	var sUrl="";
                	if(vslCd == ""){
                		sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd=" + vslCd;
                		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
                	}else{
                		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
                		ComOpenPopup(sUrl, 340, 420, "getVvdData", "0,0", true);
                	}
					break;
				case "btn_print":
					callRDOpen(sheetObject1, formObject);
					break;
				case "btn_test":
				case "btn_test_pop":
//					var vsl_cd = formObject.vsl_cd.value;
//					var skd_voy_no = formObject.skd_voy_no.value;
//					var skd_dir_cd = formObject.skd_dir_cd.value;
//					
//					sUrl = "/opuscntr/VOP_VSK_0019.do?vsl_cd="+vsl_cd+"&skd_voy_no="+skd_voy_no+"&skd_dir_cd="+skd_dir_cd;
//					ComOpenPopup(sUrl, 1024, 630, "", "0,0", false);
//					formObject.skd_rmk.value = "retyuiop";
					break;
				case "btn_close":
					ComClosePopup(); 
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
        // Color Setting...
        glbBrthFontColor="#FF0000";
        glbDepFontColor="#0000FF";
        
        var formObj = document.form;
        initFormMake(sheetObjects[0], formObj);
        document.form.vsl_cd.focus();
//        document.getElementById("top_tr").style.display="none";
//		document.getElementById("main_layer").style.display="block";
		
//		formObj.vsl_cd.value = "CLEH";
//		formObj.skd_voy_no.value = "7777";
//		formObj.skd_dir_cd.value = "E";
//        if( formObj.vsl_cd.value != "" && formObj.skd_voy_no.value!="" && formObj.skd_dir_cd.value!=""){
//        	//doActionSearch(sheetObjects[0], formObj);
//        	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
//        }
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {		      
//		        (20, 0, 0, true);
			        var HeadTitle="|Seq|DIR|Port|TMNL\nCode|Consortium Voyage|Consortium Voyage|P/F SKD|P/F SKD|Change\nStatus|Port Status|ETA|ETB|ETD|Remark(s)" +
			        "|CreateUserID|CreateDate|UpdateUserID|UpdateDate|SKD_CNG_STS_CD";
			        var HeadTitle2="|Seq|DIR|Port|TMNL\nCode|Arr Ext Voy Ref|Dep Ext Voy Ref|ETB|ETD|Change\nStatus|Port Status|ETA|ETB|ETD|Remark(s)" +
			        "|CreateUserID|CreateDate|UpdateUserID|UpdateDate|SKD_CNG_STS_CD";
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
				               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               
				               {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cssm_voy_no", keyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:10},
					           {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_cssm_voy_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:10 },
				               
				               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"etb_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"etd_dy_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_cng_sts_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skd_sts_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:0,  Width:45,   Align:"Left",    ColMerge:1,   SaveName:prefix+"win_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
				               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_cng_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skd_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			         
			        InitColumns(cols);
			        SetEditable(0);		
			        resizeSheet();
				}
				break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj, formObj, sAction)){
					doActionSearch(sheetObj, formObj);
				}
				break;
			case SEARCH01:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH01;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0019GS.do", sParam);
					return sXml;
				}
				break;
		}
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		setFormData(sheetObj, 2, 1);
		var prefix = "sheet1_";
		var formObj = document.form;
		var headCnt=sheetObj.HeaderRows();
		var totCnt=sheetObj.LastRow();
	
	
		for(var i=headCnt; i<=totCnt; i++) {
			// Setting Skip Port Hidden
			if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"){
    			fontColorChangeBySkip(sheetObj, i);
			}else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "B"){
    			sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbBrthFontColor);
     			sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbBrthFontColor);
     			sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbBrthFontColor);
			}else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "D"){
     			sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbDepFontColor);
    			sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDepFontColor);
    			sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDepFontColor);
    		}
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
    	switch(sAction) {
			case IBSEARCH:      //Retrieve
//				if(ComIsNull(formObj.vsl_cd.value) || ComIsNull(formObj.skd_voy_no.value) || ComIsNull(formObj.skd_dir_cd.value)){
//					ComShowCodeMessage('VSK00027', "Direction Code");
//					return false;
//				}
				if(ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if(ComIsNull(formObj.skd_voy_no.value)){
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.focus();
					return false;
				} else if(ComIsNull(formObj.skd_dir_cd.value)){
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				}
				break;
    	}
        with(formObj){
//	            if (!isNumber(formObj.iPage)) {
//	                return false;
//	            }
        }
        return true;
    }
    /**
     * 해당 목록을 Retrieve
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionSearch(sheetObj, formObj){
    	var prefix=sheetObj.id + "_";
    	formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("VOP_VSK_0019GS.do", sParam);
		ComOpenWait(false);
		
		var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
		//alert( dataNode );
		if(dataNode > 0 ){
			sheetObj.LoadSearchData(sXml,{Sync:1} );
//			var headCnt=sheetObj.HeaderRows();
//			var totCnt=sheetObj.LastRow();
//		
//		
//			for(var i=headCnt; i<=totCnt; i++) {
//				// Setting Skip Port Hidden
//				if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"){
//	    			fontColorChangeBySkip(sheetObj, i);
//				}else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "B"){
//	    			sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbBrthFontColor);
//	     			sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbBrthFontColor);
//	     			sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbBrthFontColor);
//				}else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "D"){
//	     			sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbDepFontColor);
//	    			sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDepFontColor);
//	    			sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDepFontColor);
//	    		}
//			}
			
		
			var vslSlanCd=ComGetEtcData(sXml, "vsl_slan_cd");
			
			if(vslSlanCd != null && vslSlanCd != undefined){
				formObj.vsl_slan_cd.value=vslSlanCd;
			}
			var pfSkdTpCd =ComGetEtcData(sXml, "pf_skd_tp_cd");
			if(pfSkdTpCd != null && pfSkdTpCd != undefined){
				formObj.pf_skd_tp_cd.value = pfSkdTpCd;
			}
			
			var skdRmk=ComGetEtcData(sXml, "skd_rmk");
			if(VskIsNotNull(skdRmk)){
				formObj.skd_rmk.value=skdRmk;
			}else{
				formObj.skd_rmk.value="";
			}
			
//			setFormData(sheetObj, 2, 1);
			
			
	    }else{

			sheetObj.LoadSearchData(sXml,{Sync:1} );
	    }
    }
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	function sheet1_OnClick(sheetObj, Row, Col) {
		if(Row > 1 && Col > 0){
			setFormData(sheetObj, Row, Col);
			var prefix=sheetObj.id + "_";
			var formObj=document.form;
			var headCnt=sheetObj.HeaderRows();
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"win_rmk"){
				var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + escape(sheetObj.GetCellValue(Row, prefix+"vps_rmk"));
//				if(sheetObj.RowEditable(Row) == false){
					sUrl=sUrl + "&readonly=true";
//				}
				var rVal=ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
//				if(rVal || rVal == ""){
//					sheetObj.CellValue2(Row, prefix+"vps_rmk") = rVal;
//					sheetObj.CellValue2(Row, prefix+"win_rmk") = rVal.replace(/\n/g, "").replace(/\r/g, "");
//				}
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
//    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
//    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
//    	axon_event.addListenerForm('keydown', 'obj_keydown', form);
//    	axon_event.addListenerForm('focus', 'obj_focus', form);
    	if (document.form.pop_mode == "N") {
        	$(document.form.vsl_cd).on('blur', function(){
        		obj_change();
        	});
    	}
	}
	function obj_change(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
		try {
			var srcName=ComGetEvent("name");
	        switch(srcName) {
	            case "vsl_cd":
	            	codeChangedRemove(sheetObj, formObj);
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		formObj.skd_voy_no.focus();
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
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
		var eleObj=ComGetEvent();
		var formObj=document.form;
		switch (eleObj.name) {    
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break; 
		    case "skd_voy_no":
		    	ComKeyOnlyNumber(document.form.skd_voy_no);
				break;
		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;
		}
	}
	function obj_keyup(){
		var eleObj=ComGetEvent();
		var formObj=document.form;
		switch (eleObj.name) {
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_voy_no.focus();
		    	}
				break;
		    case "skd_voy_no":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_dir_cd.focus();
		    	}
				break;
		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		formObj.vsl_slan_cd.focus();
//		    		document.getElementById("btn_retrieve").focus();
		    	}
				break;
		}
	}
	function obj_keydown(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(focusObj=="vsl_cd"){
			var ctrl=event.ctrlKey;
			var code=event.keyCode;
			if(ctrl && code == 86){ 
				var clipData=window.clipboardData.getData('Text');
				if(clipData!=null && clipData.length==9){
					clipData=clipData.toUpperCase();
					formObj.vsl_cd.value=clipData.substring(0, 4);
					if(isCheckVslCd(sheetObj, formObj)){
						formObj.skd_voy_no.value=clipData.substring(4, 8);
						formObj.skd_dir_cd.value=clipData.substring(8, 9);
					}
				}
				event.returnValue=false;
			}
		}
	}
	function obj_focus(){
		var eleObj=ComGetEvent();
		var formObj=document.form;
		if(eleObj.name){
			focusObj=eleObj.name;
		}else{
			focusObj="";
		}
	}
	/**
	 * Setting form by popup
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function initFormMake(sheetObj, formObj){
		var popMode=formObj.pop_mode.value;
		if(popMode == "Y"){
			//Pop-up Mode
//			document.getElementById("top_table").className="popup";
//			document.getElementById("top_tr").style.display="block";
//			document.getElementById("top_td").className="top";
//			document.getElementById("pop_layer").style.display="block";
			var titleName="Vessel Schedule Inquiry by V.V.D(Pop-up)";
//			var titleHtml="<table width='100%' border='0'>" +
//					"<tr><td class='title'><img src='img/icon_title_dot.gif' align='absmiddle'>&nbsp;"+titleName+"</td></tr>" +
//					"</table>";
//			document.getElementById("main_title").innerHTML=titleHtml;
			if(ComIsNull(formObj.vsl_cd.value) || ComIsNull(formObj.skd_voy_no.value) || ComIsNull(formObj.skd_dir_cd.value)){
				// Logic Null
			}else{
				doActionSearch(sheetObj, formObj);
			}
			formObj.vsl_cd.className="input2";
			formObj.vsl_cd.readOnly=true;
			formObj.skd_voy_no.className="input2";
			formObj.skd_voy_no.readOnly=true;
			formObj.skd_dir_cd.className="input2";
			formObj.skd_dir_cd.readOnly=true;
		}
		else{
			//Main Mode
//			document.getElementById("top_tr").style.display="none";
//			document.getElementById("main_layer").style.display="block";
//			var titleHtml = "<table width='100%' border='0' cellpadding='0' cellspacing='0' class='title'>" +
//					"<tr><td class='history'><img src='img/icon_history_dot.gif' align='absmiddle'><span id='navigation'></span></td></tr>" +
//					"<tr><td class='title'><img src='img/icon_title_dot.gif' align='absmiddle'><span id='title'></span></td></tr>" +
//					"</table>";
		}
	}
	/**
	 * Settnig selected row to form
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
    function setFormData(sheetObj, Row, Col){
    	var formObj=document.form;
    	//var prefix=sheetObj.id + "_";
    	var prefix = "sheet1_";
    	if( sheetObj.GetCellValue(Row, prefix+"cre_usr_id") != -1 ){
		formObj.cre_usr_id.value=sheetObj.GetCellValue(Row, prefix+"cre_usr_id");
		formObj.cre_dt.value=VskReplaceUserDate(sheetObj.GetCellValue(Row, prefix+"cre_dt"));
		formObj.upd_usr_id.value=sheetObj.GetCellValue(Row, prefix+"upd_usr_id");
		formObj.upd_dt.value=VskReplaceUserDate(sheetObj.GetCellValue(Row, prefix+"upd_dt"));
    	}else{
    		formObj.cre_usr_id.value="";
    		formObj.cre_dt.value="";
    		formObj.upd_usr_id.value="";
    		formObj.upd_dt.value="";
    	}
    }
    /**
	 * Setting font color of skip port
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function fontColorChangeBySkip(sheetObj, sRow){
		var prefix=sheetObj.id + "_";
//		setSheetFontToBackColor(sheetObj, sRow, prefix+"skd_dir_cd");
//		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_port_cd");
//		setSheetFontToBackColor(sheetObj, sRow, prefix+"tml_cd");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"etb_dy_cd");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"etd_dy_cd");
//		setSheetFontToBackColor(sheetObj, sRow, prefix+"skd_cng_sts_desc");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"port_skd_sts_desc");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_eta_dt");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_etb_dt");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_etd_dt");
		setSheetFontToBackColor(sheetObj, sRow, prefix+"vps_rmk");
	}
	/**
	 * Changing Font Color to Back Color
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetFontToBackColor(sheetObj, Row, Col){
//		sheetObj.CellFontColor(Row, Col) = sheetObj.CellBackColor(Row, Col);
 		sheetObj.SetCellFontColor(Row, Col,"#FFFFFF");
	}
    function codeChangedRemove(sheetObj, formObj){
    	formObj.skd_voy_no.value="";
    	formObj.skd_dir_cd.value="";
    	formObj.vsl_slan_cd.value="";
    	
    	formObj.pf_skd_tp_cd.value = "";
    	
    	formObj.cre_dt.value="";
    	formObj.cre_usr_id.value="";
    	formObj.upd_dt.value="";
    	formObj.upd_usr_id.value="";
    	formObj.skd_rmk.value="";
    	sheetObj.RemoveAll();
    }
    function getVslCdData(obj){
    	
    	if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value=rtnDatas[1];
				}
			}
    	}
    }
	function getVvdData(obj){
    	if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value=rtnDatas[2];
					document.form.skd_dir_cd.value=rtnDatas[3];
				}
			}
    	}
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
		var sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
		var chkVslCd=ComGetEtcData(sXml, "vsl_chk");
		if(chkVslCd == "Y"){
    		return true;
    	}else{
    		sheetObj.LoadSearchData(sXml,{Sync:1} );
    		formObj.vsl_cd.value="";
    		return false;
    	}
	}
	/**
	 * RD Viewer call
	 * 
	 * @param formObj
	 * @return
	 */
	function callRDOpen(sheetObj, formObj){
		var rdParam=setQueryStr(sheetObj, formObj);
		if(VskIsNull(rdParam)){
			return;
		}else{
			formObj.com_mrdPath.value      = "apps/opus/vop/vsk/scheduleplanningoperation/vesselschedulemgt/report/VOP_VSK_0019.mrd";
			//formObj.com_mrdPath.value="rpt/report/VOP_VSK_0019.mrd";
		    formObj.com_mrdArguments.value=rdParam;
		    formObj.com_mrdBodyTitle.value="Vessel Schedule by VVD Report";
			formObj.com_mrdSaveDialogFileName.value="Vessel Schedule by VVD Report";
			var sFeatures="dialogWidth:980px;dialogHeight:690px;status:no";
			ComOpenRDPopupModal(sFeatures);
		}
	}
	/**
	 * Parameter Setting to RD
	 * 
	 * @param formObj
	 * @return
	 */
	function setQueryStr(sheetObj, formObj){
		var qryStr="";
		if(sheetObj.RowCount()< 1){
			qryStr="";
		}else{
			qryStr += "/rv vsl_cd[" + formObj.vsl_cd.value + "]";
			qryStr += " skd_voy_no[" + formObj.skd_voy_no.value + "]";
			qryStr += " skd_dir_cd[" + formObj.skd_dir_cd.value + "]";
//			qryStr += " vps_port_cd[" + formObj.loc_cd.value + "]";
//			qryStr += " clpt_ind_seq[" + formObj.clpt_ind_seq.value + "]";
			qryStr += " this_time[" + VskRdPrintDate() + "]";
		}
        return qryStr;
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
