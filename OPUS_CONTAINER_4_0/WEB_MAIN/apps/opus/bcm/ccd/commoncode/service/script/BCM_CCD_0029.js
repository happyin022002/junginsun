/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0029.js
*@FileTitle  : Vessel service scope
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
			   MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
			   OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class BCM_CCD_0029 : BCM_CCD_0029 on the screen for creating the script defines the task using.
     */
    function BCM_CCD_0029() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    /** Common global variable */    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var prefix1="sheet1_";
    var prefix2="sheet2_";
    var regionPopFlag=false; // Service Scope Limit use of the Region that the presence of settingsi Popup
    /** Event handler processing by button click event */
    document.onclick=processButtonClick;
    /** Event handler processing by button name */
    function processButtonClick(){
    	/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
				break;
            case "btn_New":
            	doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
            	break;
            case "btn_Save":
            	doActionIBSheet(sheetObjects[0],formObj,MULTI01);
            	break;
    		case "btn_Close":
    			ComClosePopup(); 
    			break;
    		case "btn_Request":
    			doActionIBSheet(sheetObjects[0], document.form, MULTI03); 
    			break;
            case "btn_row_addup":
            	addRow(sheetObjects[0]);
            	break;
            case "btn_row_deleteup":
            	deleteRow(sheetObjects[0]);
            	break;
            case "btn_row_adddn":
            	addRow(sheetObjects[1]);
            	break;
            case "btn_row_deletedn":
            	deleteRow(sheetObjects[1]);
            	break;
            case "btn_scp_search":
            	if(window.event.srcElement.style.cursor == "default") return;
            	var sUrl="/opuscntr/COM_ENS_0L1.do?mdm_yn="+formObj.mdm_yn.value+"&svc_scp_cd=" + formObj.svc_scp_cd.value +"&main_page=false";
               // var rVal = ComOpenPopup(sUrl, 770, 420, "get_spcCd", "1,0,1", true);
                var rVal=ComOpenPopup(sUrl, 700, 420, "get_spcCd", "1,0,1", true);
    			break;
            }
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
        var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        doActionIBCombo(sheetObjects[0], formObj, SEARCH01);
//        doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		svc_scp_bnd_cd.SetSelectCode("W");
		delt_flg.SetSelectCode("N");
		conf_flg.SetSelectCode("N");
		fmc_file_flg.SetSelectCode("N");
    	// auth_tp_cd retrieve
    	doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
    	var authTpCd=G_AHTU_TP_CD;
    	var rqstNo=formObj.rqst_no.value;
    	if(G_MDAA_CHK == 'Y')
    		formObj.delt_flg.enable=true;
    	else
    		formObj.delt_flg.enable=false;
    	// If the Process Status screen call, in the Detail PopUp
    	if(rqstNo != '') {
    		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    		ComSetDisplay('btn_Close', true);
    		var procTpCd=formObj.proc_tp_cd.value;
    		var rqstUsrChk=formObj.rqst_usr_chk.value;
    		ComEnableObject(formObj.btn_scp_search, false);
    		// Process Type is 'Reject' and AuthType is not 'Approval'(possible modifications and ReOpen)
    		if(procTpCd == 'R' &&  ( ((authTpCd == 'R' || authTpCd == 'S') && rqstUsrChk == 'Y') || G_MDAA_CHK == 'Y') ) {
    			ComSetDisplay('btn_Request', true);
    			ComGetObject("btn_Request").style.setProperty("color", "#FF0000", "important");
    			ComSetDisplay('btn_Retrieve', true);
    			ComSetDisplay('btn_Save', true);
    			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    		} else if(procTpCd == 'A') {
    			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    			ComEnableObject(formObj.btn_scp_search, false);
    		} else {
    			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    		}
    	} else {
    		ComSetDisplay('btn_Retrieve', true);
    		// MDM Authority is not Approval('A') or MDDA
    		if( authTpCd == 'R' || authTpCd == 'S' || G_MDAA_CHK == 'Y') {
    			ComSetDisplay('btn_New', true);
    			ComSetDisplay('btn_Save', true);
    		} else {
    			//General User if you do not have MDM Authority
    			ComSetDisplay('btn_New', true);
    		}
    	}
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;    	
    	var sheetId=sheetObj.id;
    	switch (sheetId) {
		case "sheet1":
		    with(sheetObj){
		      var HeadTitle="|Del.|Vessel Service Lane Code|Delete Flag|Create User|Create Date/Time|Last Update User|Last Update Date/Time";
	
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"del_chk",     KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"PopupEdit", Hidden:0, Width:500,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"vsl_slan_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		             {Type:"Combo",     Hidden:0, Width:300,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"delt_flg",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",    ColMerge:1,   SaveName:prefix1+"cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, },
                     {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",    ColMerge:1,   SaveName:prefix1+"cre_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:1,   SaveName:prefix1+"upd_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, },
                     {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",    ColMerge:1,   SaveName:prefix1+"upd_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		       
		      InitColumns(cols);
		      SetEditable(1);
		            //conversion of function[check again]CLT 	            InitDataValid(0,    prefix1+"vsl_slan_cd",  vtEngUpOnly);
		      //no support[check again]CLT 	            PopupImage="img/btns_search.gif";
		      SetShowButtonImage(1);
		      SetSheetHeight(175);
	      	}
	    	break;
		case "sheet2":
		    with(sheetObj){
		      var HeadTitle="|Del.|Region|ORG/DST|Scope Indicator|Delete Flag|Create User|Create Date/Time|Last Update User|Last Update Date/Time|";
	
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"del_chk",         KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"PopupEdit", Hidden:0, Width:300,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"rgn_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		             {Type:"Combo",     Hidden:0, Width:300,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"org_dest_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"svc_scp_ind_flg", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"delt_flg",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",    ColMerge:1,   SaveName:prefix2+"cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, },
                     {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",    ColMerge:1,   SaveName:prefix2+"cre_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:1,   SaveName:prefix2+"upd_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, },
                     {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",    ColMerge:1,   SaveName:prefix2+"upd_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		            //conversion of function[check again]CLT 	            InitDataValid(0,    prefix2+"rgn_cd",  vtEngUpOnly);
		      //no support[check again]CLT 	            PopupImage="img/btns_search.gif";
		      SetShowButtonImage(1);
		      SetSheetHeight(175);
		    }
	    	break;
        }
    }
    /**
     * All the combo box query
     */
    	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
    		switch (sAction) {
    			case SEARCH01: // load page 시
    				var sXml=sheetObj.GetSearchData("BCM_CCD_0029GS.do", "f_cmd=" + SEARCH01);
					var rtnValue=sXml.split("|$$|");
					for(var i=0; i < rtnValue.length; i++){
						var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
						var cdName=comboXml[0].split("|");
						var cdValue=comboXml[1].split("|");
						for (var j=0; j < cdName.length; j++) {
							if(i == 0){
								comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
							}else if(i == 1){
								comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
								comboObjects[i+1].InsertItem(j, cdName[j], cdValue[j]);
								comboObjects[i+2].InsertItem(j, cdName[j], cdValue[j]);
							}
			        	}
						if(i == 1){
							sheetObj.SetColProperty(prefix1+"delt_flg", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
							sheetObjects[1].SetColProperty(prefix2+"svc_scp_ind_flg", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
							sheetObjects[1].SetColProperty(prefix2+"delt_flg", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
						}else if(i == 2){
							sheetObjects[1].SetColProperty(prefix2+"org_dest_cd", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
						}
					}					
         		break;
         	}
    	}
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	switch(sAction) {
    	case SEARCH02:				//Retrieve
    		if (validateForm(sheetObj, formObj, sAction)) {
    			if( formObj.rqst_no.value == ''){
    				formObj.f_cmd.value=SEARCH02;
    	 		}else{
    	 			formObj.f_cmd.value=SEARCH05;
    	 		}
	    		sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
	        	sheetObj.RemoveAll();
	        	sheetObj.RemoveEtcData();
	        	sheetObjects[1].RemoveAll();
	        	sheetObjects[1].RemoveEtcData();
	    		var sParam=FormQueryString(formObj);
	    		var prefixArr=new Array("", prefix1, prefix2);
	    		var sXml=sheetObj.GetSearchData("BCM_CCD_0029GS.do", sParam
	    				+ "&" + ComGetPrefixParam(prefixArr));
	    		var rtnValue=sXml.split("|$$|");
	    		var sav=ComGetEtcData(rtnValue[0], "TRANS_RESULT_KEY");
	    		var rqstNo=ComGetEtcData(rtnValue[0], "RQST_NO");
				ComSetObjValue(formObj.rqst_no, rqstNo);
	    		if(sav != "S" ){
	        		ComOpenWait(false);
	        		return;
	    		}
	    		if(ComXmlString(rtnValue[0], "delt_flg") == null || ComXmlString(rtnValue[0], "delt_flg") == ""){
	    			ComOpenWait(false);
	    			formObj.svc_scp_cd.readOnly=true;
	    			ComBtnEnable("btn_row_addup");
    	    		ComBtnEnable("btn_row_deleteup");
    	    		ComBtnEnable("btn_row_adddn");
    	    		ComBtnEnable("btn_row_deletedn");
//    	    		formObj.svc_scp_nm.focus();
	    			formObj.creflag.value="Y";
	    			if(G_AHTU_TP_CD=="A"){
	    	    		ComShowCodeMessage("CCD00033", "Service Scope Code");
	    	    		doActionIBSheet(sheetObj, formObj, IBCLEAR);
	    	    	}else{
	    	    		if(!ComShowConfirm(ComGetMsg("CCD00034", "Service Scope Code"))){
	    	    			doActionIBSheet(sheetObj, formObj, IBCLEAR);
	    	    		}
	    	    	}
	    			return;
	    		}else{
	    			formObj.creflag.value="N";
	    		}
	    		formObj.ibflag.value="U";
	    		formObj.svc_scp_cd.value=getValueForCombo(ComXmlString(rtnValue[0], "svc_scp_cd"));
	    		formObj.svc_scp_nm.value=getValueForCombo(ComXmlString(rtnValue[0], "svc_scp_nm"));
	    		svc_scp_bnd_cd.SetSelectCode(getValueForCombo(ComXmlString(rtnValue[0], "svc_scp_bnd_cd")));
	    		conf_flg.SetSelectCode(getValueForCombo(ComXmlString(rtnValue[0], "conf_flg")));
	    		fmc_file_flg.SetSelectCode(getValueForCombo(ComXmlString(rtnValue[0], "fmc_file_flg")));
	    		formObj.trf_pfx_cd.value=getValueForCombo(ComXmlString(rtnValue[0], "trf_pfx_cd"));
	    		formObj.trf_no.value=getValueForCombo(ComXmlString(rtnValue[0], "trf_no"));
	    		delt_flg.SetSelectCode(getValueForCombo(ComXmlString(rtnValue[0], "delt_flg")));
	    		formObj.modi_cost_ctr_cd.value=getValueForCombo(ComXmlString(rtnValue[0], "modi_cost_ctr_cd"));
	    		formObj.cre_usr_id.value=getValueForCombo(ComXmlString(rtnValue[0], "cre_usr_id"));
	    		formObj.cre_dt.value=getValueForCombo(ComXmlString(rtnValue[0], "cre_dt"));
	    		formObj.upd_usr_id.value=getValueForCombo(ComXmlString(rtnValue[0], "upd_usr_id"));
	    		formObj.upd_dt.value=getValueForCombo(ComXmlString(rtnValue[0], "upd_dt"));
	    		
	    		formObj.modi_svc_grp_cd.value=getValueForCombo(ComXmlString(rtnValue[0], "modi_svc_grp_cd"));
	    		formObj.dmnt_flg.value=getValueForCombo(ComXmlString(rtnValue[0], "dmnt_flg"));
	    		
	    		//formObj.modi_svc_scp_lane.value=getValueForCombo(ComXmlString(rtnValue[0], "modi_svc_scp_lane"));
	    		sheetObj.LoadSearchData(rtnValue[1],{Sync:1} );
	    		sheetObjects[1].LoadSearchData(rtnValue[2],{Sync:1} );
	    		ComOpenWait(false);
	    		formObj.svc_scp_cd.readOnly=true;
	    		ComBtnEnable("btn_row_addup");
	    		ComBtnEnable("btn_row_deleteup");
	    		ComBtnEnable("btn_row_adddn");
	    		ComBtnEnable("btn_row_deletedn");
//	    		formObj.svc_scp_nm.focus()
    		}
    		break;
    	case MULTI01:				//save
    		if (validateForm(sheetObj, formObj, sAction)) {
    			if( formObj.creflag.value == "N" && formObj.rqst_no.value == ''){
    				formObj.f_cmd.value=MULTI01;
    	 		}else{
    	 			formObj.f_cmd.value=MULTI02;
    	 			ComEnableObject(formObj.btn_scp_search, false);
    	 		}
    			var tmpMsg="";
    			if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
    				tmpMsg="CCD00035";
    			}else{
    				tmpMsg="COM130101";
    			}
	    		if(ComShowConfirm(ComGetMsg(tmpMsg, "Data"))){
		    		sheetObj.SetWaitImageVisible(0);
		        	ComOpenWait(true);
		    		var sParam=FormQueryString(formObj);
		    		sParam += "&" + sheetObj.GetSaveString(false, true, prefix1+"ibflag");
		    		sParam += "&" + sheetObjects[1].GetSaveString(false, true, prefix2+"ibflag");
		    		var sXml=sheetObj.GetSaveData("BCM_CCD_0029GS.do", sParam);
	    			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		    		if(sav == "S" ){					//Saved after a successful re-viewed
		    			if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
	    					ComShowCodeMessage("CCD00031");
	    				} else {
	    					ComShowCodeMessage("COM130102", "Data");
	    				}
		        	}else{
		        		ComShowCodeMessage("COM132103", "Data");
			        	}
		    		ComOpenWait(false);
		    		var rqstNo=ComGetEtcData(sXml, "RQST_NO");
					ComSetObjValue(formObj.rqst_no, rqstNo);
		    		doActionIBSheet(sheetObj,formObj,SEARCH02);
	    		}
    		}
    		break;
    	case IBCLEAR:
    		formObj.reset();
    		formObj.rqst_no.value="";
    		//formObj.modi_svc_scp_lane.value="";
    		formObj.svc_scp_cd.readOnly=false;	
    		svc_scp_bnd_cd.SetSelectCode("W");
    		delt_flg.SetSelectCode("N");
    		conf_flg.SetSelectCode("N");
    		fmc_file_flg.SetSelectCode("N");
    		sheetObj.RemoveAll();
        	sheetObj.RemoveEtcData();
        	sheetObjects[1].RemoveAll();
        	sheetObjects[1].RemoveEtcData();
        	ComBtnDisable("btn_row_addup");
    		ComBtnDisable("btn_row_deleteup");
    		ComBtnDisable("btn_row_adddn");
    		ComBtnDisable("btn_row_deletedn");
    		ComEnableObject(formObj.btn_scp_search, true);
    		break;
    	case SEARCH10: // MDM AUTH_TP_CD query
			var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=SVSP';
			var sXml=sheetObj.GetSearchData("BCM_CCD_2002GS.do", sParam);
			// global var sestting
			G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
			G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
			break;
		case MULTI03:	// Request
			if (!ComShowCodeConfirm("CCD00030")) {
			    return;
			}
			var sParam='f_cmd=' + MULTI03 + '&rqst_no=' + ComGetObjValue(formObj.rqst_no) + '&rqst_ofc_cd=' + ComGetObjValue(formObj.rqst_ofc_cd) + '&proc_tp_cd=O';
			var sXml=sheetObj.GetSaveData("BCM_CCD_2002GS.do", sParam);
			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			if(sav == "S"  ){
				ComShowCodeMessage("CCD00031");
				ComPopUpReturnValue("Y");
				ComClosePopup(); 
			} else {
				ComShowCodeMessage("COM130103", "Data");
			}
			break;
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction) {
    	switch (sAction) {
    	case SEARCH02:
    		if( formObj.rqst_no.value == ''){
	    		if(formObj.svc_scp_cd.value == "" || formObj.svc_scp_cd.value == null){
	    			ComShowCodeMessage("CCD00001", "Service Scope Code");
//	    			formObj.vsl_slan_cd.focus();
	    			return false;
	    		}
    		}
    		break;
    	case MULTI01:
    		if(ComTrimAll(formObj.svc_scp_cd.value) == "" || formObj.svc_scp_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Service Scope Code");
//    			formObj.svc_scp_cd.focus();
    			return false;
    		}
    		if(ComTrimAll(formObj.svc_scp_nm.value) == "" || formObj.svc_scp_nm.value == null){
    			ComShowCodeMessage("CCD00001", "Name");
//    			formObj.svc_scp_nm.focus();
    			return false;
    		}
    		if(svc_scp_bnd_cd.GetSelectCode()== "" || svc_scp_bnd_cd.GetSelectCode()== null){
    			ComShowCodeMessage("CCD00001", "Bound");
//    			formObj.svc_scp_bnd_cd.focus();
    			return false;
    		}
    		if(conf_flg.GetSelectCode()== "" || conf_flg.GetSelectCode()== null){
    			ComShowCodeMessage("CCD00001", "Conference Status");
//    			formObj.conf_flg.focus();
    			return false;
    		}
    		if(fmc_file_flg.GetSelectCode()== "" || fmc_file_flg.GetSelectCode()== null){
				ComShowCodeMessage("CCD00001", "FMC File Status");
//    			formObj.fmc_file_flg.focus();
    			return false;
    		}
    		
    		if(ComTrimAll(formObj.modi_cost_ctr_cd.value) == "" || formObj.modi_cost_ctr_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Sakura CTR Code");
    			formObj.modi_cost_ctr_cd.focus();
    			return false;
    		}
    		
    		var cnt1=0;
    		for(i=1; i <= sheetObj.LastRow(); i++){
    			if("U" == sheetObj.GetCellValue(i, prefix1+"ibflag") || "I" == sheetObj.GetCellValue(i, prefix1+"ibflag") || "D" == sheetObj.GetCellValue(i, prefix1+"ibflag")){
    				cnt1++;
    			}
    		}    			
			if(cnt1 > 0 && !(sheetObj.GetSaveString(false, true, prefix1+"ibflag"))){
				return false;
			}			
			var cnt2=0;
    		for(i=1; i <= sheetObjects[1].LastRow(); i++){
    			if("U" == sheetObjects[1].GetCellValue(i, prefix2+"ibflag") || "I" == sheetObjects[1].GetCellValue(i, prefix2+"ibflag") || "D" == sheetObjects[1].GetCellValue(i, prefix2+"ibflag")){
    				cnt2++;
    			}
    		}    			
			if(cnt2 > 0 && !(sheetObjects[1].GetSaveString(false, true, prefix2+"ibflag"))){
				return false;
			}
    		break;
    	}
    	return true;
    }
	function initControl() {
		var formObj=document.form;
//		axon_event.addListenerForm('focus', 'obj_focus', form);
		axon_event.addListenerForm('change', 'obj_change', form); 	
//		axon_event.addListenerForm('keypress', 'obj_keypress', form);
//		axon_event.addListenerForm('keyup', 'obj_keyup', form); 	
//		axon_event.addListenerForm('keydown', 'obj_keydown', form);
//		axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
		axon_event.addListenerForm("propertychange", "obj_propertychange", formObj);
	}
	   /**
	   * HTML Object OnKeyPress event handling
	   */
	  function obj_keypress(event) {
	     	obj=event.srcElement;
	     	keyValidation(obj);
	   }
    /**
    * If the data field to be the change event
    */
   function obj_change(){
	   	var formObj=document.form;
	   	try {
	   		var srcName=ComGetEvent("name");
	           switch(srcName) {
	           	case "svc_scp_cd":
	           		if(formObj.svc_scp_cd.value.length>0){
	           			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
	           		}
	           	break;
	           	case "delt_flg":
	           		if(!ComShowCodeConfirm("COM130301", "data")) comObj.SetSelectCode("N",false);
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
	 * sheet1  add row handling
	 * add row
	 */
	function addRow(sheetObj) {
		 var sheetId=sheetObj.id;
    	switch (sheetId) {
		case "sheet1":
	    	with (sheetObj) {
				var nowRow=GetSelectRow();
		     	nowRow=DataInsert(-1);
		     	SetCellValue(nowRow, prefix1+"delt_flg","N",0);
		     	SetCellValue(nowRow, prefix1+"flg","Y",0);
	    	}
	    	break;
		case "sheet2":
	    	with (sheetObj) {
				var nowRow=GetSelectRow();
		     	nowRow=DataInsert(-1);
		     	SetCellValue(nowRow, prefix2+"delt_flg","N",0);
		     	SetCellValue(nowRow, prefix2+"flg","Y",0);
	    	}
	    	break;
    	}	    	
	}
	 /**
	  * sheet1  delete row handling
	  * delete row.
	  */
	function deleteRow(sheetObj) {
		var sheetId=sheetObj.id;
    	switch (sheetId) {
		case "sheet1":
	    	with (sheetObj) {
		        var sRowStr=FindCheckedRow(prefix1+"del_chk");
		        var arr=sRowStr.split("|");
		        var dbDataFlg=false;
		        for (var i=arr.length - 1; i >= 0; i--) {
		        	if (!GetRowHidden(arr[i])){
		        		if (GetCellValue(arr[i], prefix1+"flg") != "Y") {
			            	dbDataFlg=true; 
			            }
		        	}
		        }
		        if(dbDataFlg){
		        	if(ComShowCodeConfirm("COM130301", "data")){
//				        for (var i=arr.length - 1; i>=0; i--) {
//				        	if (GetCellValue(arr[i], prefix1+"flg") == "Y") {
//				                //Immediately remove the new line is created.
//				                RowDelete(arr[i], false);
//				            }else{
//					            SetRowStatus(arr[i],"D");
//					            SetRowHidden(arr[i],1);
//				            }
//			            }
				        var len = 0;
			            for (var i=0; i < arr.length; i++) {
			            	var idx = arr[i] - len;
			            	if (GetCellValue(idx, prefix1+"flg") == "Y") {
			                    RowDelete(idx, false);
			                    len++;
			                }else{
				            	SetRowStatus(idx,"D");
				            	SetRowHidden(idx,1);
			                }
			            }
		        	}
		        }else {
//			        for (var i=arr.length - 1; i>=0; i--) {
//			        	if (GetCellValue(arr[i], prefix1+"flg") == "Y") {
//			                //Immediately remove the new line is created
//			                RowDelete(arr[i], false);
//			            }
//			        }
		        	var len = 0;
		        	for (var i=0; i < arr.length; i++) {
		            	var idx = arr[i] - len;
		            	if (GetCellValue(idx, prefix1+"flg") == "Y") {
		                    RowDelete(idx, false);
		                    len++;
		                }
		            }
		        }
	    	}
	    	break;
		case "sheet2":
	    	with (sheetObj) {
		        var sRowStr=FindCheckedRow(prefix2+"del_chk");
		        var arr=sRowStr.split("|");
		        var dbDataFlg=false;
		        for (var i=arr.length - 1; i >= 0; i--) {
		        	if (!GetRowHidden(arr[i])){
		        		if (GetCellValue(arr[i], prefix2+"flg") != "Y") {
			            	dbDataFlg=true; 
			            }
		        	}
		        }
		        if(dbDataFlg){
		        	if(ComShowCodeConfirm("COM130301", "data")){
//				        for (var i=arr.length - 2; i>=0; i--) {
//				        	if (GetCellValue(arr[i], prefix2+"flg") == "Y") {
//				            	//Immediately remove the new line is created
//				                RowDelete(arr[i], false);
//				            }else{
//					            SetRowStatus(arr[i],"D");
//					            SetRowHidden(arr[i],1);
//				            }
//			            }
		        		var len = 0;
			            for (var i=0; i < arr.length; i++) {
			            	var idx = arr[i] - len;
			            	if (GetCellValue(idx, prefix2+"flg") == "Y") {
			                    RowDelete(idx, false);
			                    len++;
			                }else{
				            	SetRowStatus(idx,"D");
				            	SetRowHidden(idx,1);
			                }
			            }
		        	}
		        }else {
//			        for (var i=arr.length - 2; i>=0; i--) {
//			        	if (GetCellValue(arr[i], prefix2+"flg") == "Y") {
//			            	//Immediately remove the new line is created
//			                RowDelete(arr[i], false);
//			            }
//			        }
		        	
		        	var len = 0;
		        	for (var i=0; i < arr.length; i++) {
		            	var idx = arr[i] - len;
		            	if (GetCellValue(idx, prefix2+"flg") == "Y") {
		                    RowDelete(idx, false);
		                    len++;
		                }
		            }
		        }
	    	}
	    	break;
	    }         
	}
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		if (sheetObj.ColSaveName(Col) == prefix1+"vsl_slan_cd") {
		//+sheetObj.CellValue(Row,Col);
			var sUrl="/opuscntr/COM_ENS_081.do?vsl_slan_cd=" + sheetObj.GetCellValue(Row, Col);
		ComOpenPopup(sUrl, 780, 410, 'getVsl_slan_cd', '1,0,1', true, false, Row, Col, 0);		
		}			
	}
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		if (sheetObj.ColSaveName(Col) == prefix2+"rgn_cd") {
		//+sheetObj.CellValue(Row,Col);
			var sUrl="/opuscntr/COM_ENS_0J1.do?rgn_cd=" + sheetObj.GetCellValue(Row, Col);
		ComOpenPopup(sUrl, 780, 430, 'getRgn_cd', '0,1,1', true, false, Row, Col, 1);
		}			
	}
	/**
	 * Sheet1의 OnChange event handling
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            switch(ColSaveName(Col)) {
            case prefix1+"vsl_slan_cd":
            	var slanCd=Value;
            	sheetObj.SetWaitImageVisible(1);
	        	ComOpenWait(true);
	    		var sParam="f_cmd="+SEARCH03+"&vsl_slan_cd="+slanCd;
	    		var sXml=sheetObj.GetSearchData("BCM_CCD_0029GS.do", sParam);
	    		var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	    		if(sav != "S" ){
	        		ComOpenWait(false);
	        		return;
	    		}
	    		if(ComGetEtcData(sXml, "result") == null || ComGetEtcData(sXml, "result") == ""){
	    			sheetObj.SetCellValue(Row, Col,"",0);
	    			ComShowCodeMessage("COM130402", "Vessel Service Lane Code");
	    			ComOpenWait(false);
	    			return;
	    		}
	    		ComOpenWait(false);
	    		for(i=1; i <= LastRow(); i++){
	           		if(i != Row){
	           			if(GetCellValue(i, prefix1+"vsl_slan_cd") == Value){
	            			 ComShowCodeMessage("CCD00006");
	            			 SetCellValue(Row, prefix1+"vsl_slan_cd","",0);
	            			 SelectCell(Row, Col);
	            			 return;
	            		 }
		           	}
		        }
            	break;
            }
        }
	}
	/**
	 * Sheet2의 OnChange event handling
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            switch(ColSaveName(Col)) {
            case prefix2+"rgn_cd":
            	var rgnCd=Value;
            	sheetObj.SetWaitImageVisible(0);
	        	if(!regionPopFlag) ComOpenWait(true);
	    		var sParam="f_cmd="+SEARCH04+"&rgn_cd="+rgnCd;
	    		var sXml=sheetObj.GetSearchData("BCM_CCD_0029GS.do", sParam);
	    		var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	    		if(sav != "S" ){
	    			if(!regionPopFlag) ComOpenWait(false);
	        		return;
	    		}
	    		if(ComGetEtcData(sXml, "result") == null || ComGetEtcData(sXml, "result") == ""){
	    			sheetObj.SetCellValue(Row, Col,"",0);
	    			ComShowCodeMessage("COM130402", "Region Code");
	    			if(!regionPopFlag) ComOpenWait(false);
	    			return;
	    		}
	    		if(!regionPopFlag) ComOpenWait(false);
	    		for(i=1; i <= LastRow(); i++){
	           		if(i != Row){
						if(GetCellValue(i, prefix2+"rgn_cd") == GetCellValue(Row, prefix2+"rgn_cd")){
							if(GetCellValue(i, prefix2+"org_dest_cd") == GetCellValue(Row, prefix2+"org_dest_cd")){
		            			 ComShowCodeMessage("CCD00006");
		            			 SetCellValue(Row, Col,"",0);
		            			 SelectCell(Row, Col);
		            			 return;
	            			 }
	            		 }
		           	}
		        }
            	break;
            case prefix2+"org_dest_cd":
            	for(i=1; i <= LastRow(); i++){
	           		if(i != Row){
	           				if(GetCellValue(i, prefix2+"rgn_cd") == GetCellValue(Row, prefix2+"rgn_cd")){
	           					if(GetCellValue(i, prefix2+"org_dest_cd") == GetCellValue(Row, prefix2+"org_dest_cd")){
		            			 ComShowCodeMessage("CCD00006");
		            			 SetCellValue(Row, Col,"",0);
		            			 SelectCell(Row, Col);
		            			 return;
	            			 }
	            		 }
		           	}
		        }
            	break;
            }
        }
	}
	function get_spcCd(rowArray) {
	    var formObj=document.form;
	   	var colArray=rowArray[0];
		formObj.svc_scp_cd.value=colArray[3];
		if(formObj.svc_scp_cd.value.length>0){
			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
		}
	}
	function getVsl_slan_cd(rowArray, Row, Col) {
		var sheetObj=sheetObjects[0]
	    var formObj=document.form;
	   	var colArray=rowArray[0];
	   	sheetObj.SetCellValue(Row, Col,colArray[3]);
	}
	function getRgn_cd(rowArray, Row, Col) {
		var sheetObj=sheetObjects[1]
	    var formObj=document.form;
		regionPopFlag=true;
		sheetObj.SetWaitImageVisible(0);
		sheetObj.RenderSheet(0);
		ComOpenWait(true);
		for(var i=0 ; i < rowArray.length ; i++) {
		   	var colArray=rowArray[i];
		   	if(i!=0) {
		   		if(sheetObj.LastRow()< Row+i) {
			   		sheetObj.DataInsert(Row+i);
			   		sheetObj.SetCellValue(Row+i, prefix2+"delt_flg","N",0);
			   		sheetObj.SetCellValue(Row+i, prefix2+"flg","Y",0);
		   		}else if(sheetObj.GetCellValue(Row+i, prefix2+"rgn_cd") != "") {
		   			sheetObj.SetSelectRow(Row+i);
		   			sheetObj.DataCopy();
		   			sheetObj.SetCellValue(Row+i, prefix2+"delt_flg","N",0);
			   		sheetObj.SetCellValue(Row+i, prefix2+"flg","Y",0);
		   		}
		   	}
		   	sheetObj.SetCellValue(Row+i, Col,colArray[3]);
		}
		ComOpenWait(false);
		sheetObj.RenderSheet(1);
		regionPopFlag=false;
	}
	
	  function getValueForCombo(obj) {
		  if (Object.prototype.toString.call(obj) === '[object Array]') {
			  var str = obj[0];
			  return str.split('|')[0];
		  }
		  return obj;
	  }   
