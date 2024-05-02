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
            
            //if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            case "btn_History":
            	var tblNo = 'MDM_SVC_SCP';
	        	var vslslanCd = formObj.svc_scp_cd.value;
	        	var mstKey = nullToBlank(vslslanCd);
	        	
				if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Service Scope Code");
					return false;
				}
	        	comMdmCallPop(tblNo, mstKey);
            	break;
            case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
				break;
            case "btn_New":
            	doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
            	break;
            case "btn_Save":
            	doActionIBSheet(sheetObjects[0],formObj,MULTI01);
            	break;
            case "btn_Create":
            	doActionIBSheet(sheetObjects[0],formObj,IBCREATE);
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
            	var sUrl="/hanjin/COM_ENS_0L1.do?mdm_yn="+formObj.mdm_yn.value+"&svc_scp_cd=" + formObj.svc_scp_cd.value +"&main_page=false";
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
//      doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
        
        ComBtnDisable("btn_Save");
        
        formObj.svc_scp_bnd_cd.Code = ""
        formObj.conf_flg.value = "";
        formObj.fmc_file_flg.value = "";
        formObj.delt_flg.value = "N";
    	// auth_tp_cd retrieve
    	//doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
    	
    	var authTpCd=G_AHTU_TP_CD;
    	var rqstNo=formObj.rqst_no.value;
    	if(G_MDAA_CHK == 'Y')
    		formObj.delt_flg.enable=true;
    	else
    		formObj.delt_flg.enable=false;
    	
    	// If the Process Status screen call, in the Detail PopUp
    	if(rqstNo != '') {
    		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    		//ComSetDisplay('btn_Close', true);
    		var procTpCd=formObj.proc_tp_cd.value;
    		var rqstUsrChk=formObj.rqst_usr_chk.value;
    		ComEnableObject(formObj.btn_scp_search, false);
    		// Process Type is 'Reject' and AuthType is not 'Approval'(possible modifications and ReOpen)
    		if(procTpCd == 'R' &&  ( ((authTpCd == 'R' || authTpCd == 'S') && rqstUsrChk == 'Y') || G_MDAA_CHK == 'Y') ) {
    			//ComSetDisplay('btn_Request', true);
    			ComGetObject("btn_Request").style.setProperty("color", "#FF0000", "important");
    			//ComSetDisplay('btn_Retrieve', true);
    			//ComSetDisplay('btn_Save', true);
    			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    		} else if(procTpCd == 'A') {
    			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    			ComEnableObject(formObj.btn_scp_search, false);
    		} else {
    			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    		}
    	} else {
    		//ComSetDisplay('btn_Retrieve', true);
    		// MDM Authority is not Approval('A') or MDDA
    		if( authTpCd == 'R' || authTpCd == 'S' || G_MDAA_CHK == 'Y') {
    			//ComSetDisplay('btn_New', true);
    			//ComSetDisplay('btn_Save', true);
    		} else {
    			//General User if you do not have MDM Authority
    			//ComSetDisplay('btn_New', true);
    		}
    		
    		ComBtnDisable("btn_row_addup");
    		ComBtnDisable("btn_row_deleteup");
    		ComBtnDisable("btn_row_adddn");
    		ComBtnDisable("btn_row_deletedn");
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
    	var prefix = "";
    	switch (sheetId) {
		case "sheet1":
		    with(sheetObj){
		      
			  prefix = "sheet1_";
		      style.height = 130;
	  		  
	  		  // 전체 너비 설정
	      	  SheetWidth = mainTable.clientWidth
	      		
		      //Host정보 설정[필수][HostIp, Port, PagePath]
		      if (location.hostname != "") {
		       	InitHostInfo(location.hostname, location.port, page_path);
		      }
	      	  	
	      	  //전체Edit 허용 여부 [선택, Default false]
		      Editable = true;
		          
		      //전체 Merge 종류 [선택, Default msNone]
		      MergeSheet = msPrevColumnMerge + msHeaderOnly;
		        //msPrevColumnMerge : 2 
		        //msHeaderOnly : 5
		        //MergeSheet : 4 (?)
		          
		      //행정보설정[필수][HEADROWS, DATASROWS, VIEWROWS, ONEPAGEROWS=100]
		      InitRowInfo( 1, 1, 2, 100);
		        
		      //컬럼정보설정[필수][COLS, FROZENCOL, LEFTDEADCOLS=0, FROZENMOVE=false]
			  InitColumnInfo(4, 0, 0, true);
			      
			  FocusEditMode = -1;
			      
			  //헤더기능 ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
			  InitHeadMode(false, true, true, false, false, false);
			    
			    
			  //var HeadTitle="|Del.|Vessel Service Lane Code|Delete Flag|Create User|Create Date/Time|Last Update User|Last Update Date/Time";
			  var HeadTitle = "|Sel.|Lane Code|Delete Flag";
			    
			  //헤더초기화(Row, HeadText, [RowMerge], [Hidden]) 
		      InitHeadRow(0, HeadTitle, true);
		      
		      InitDataProperty(0, cnt++, dtHiddenStatus, 28, daCenter, false, prefix + "ibflag", false, "", dfNone, 0, true , true);
		      InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, prefix + "sel_chk");
		      InitDataProperty(0, cnt++, dtPopupEdit, 800, daCenter, true,  prefix +"vsl_slan_cd",  true, "", dfEngUpKey, 0, false, true, 3);
		      InitDataProperty(0, cnt++, dtComboEdit, 80, daCenter, true,  prefix +"delt_flg",  false, "", dfEngUpKey, 0, true, true);
		      
		      InitDataCombo(0, prefix + "delt_flg", "N|Y", "N|Y");
		      	
		      PopupImage  =  "img/btns_search.gif";
		      ShowButtonImage = 3; //Edit 가능할때 팝업 이미지 표시
	      	}
	    	break;
		case "sheet2":
		    with(sheetObj){

			  prefix = "sheet2_";
		      style.height = 130;
	  		  
	  		  // 전체 너비 설정
	      	  SheetWidth = mainTable.clientWidth
	      		
		      //Host정보 설정[필수][HostIp, Port, PagePath]
		      if (location.hostname != "") {
		       	InitHostInfo(location.hostname, location.port, page_path);
		      }
	      	  	
	      	  //전체Edit 허용 여부 [선택, Default false]
		      Editable = true;
		          
		      //전체 Merge 종류 [선택, Default msNone]
		      MergeSheet = msPrevColumnMerge + msHeaderOnly;
		        //msPrevColumnMerge : 2 
		        //msHeaderOnly : 5
		        //MergeSheet : 4 (?)
		          
		      //행정보설정[필수][HEADROWS, DATASROWS, VIEWROWS, ONEPAGEROWS=100]
		      InitRowInfo( 1, 1, 2, 100);
		        
		      //컬럼정보설정[필수][COLS, FROZENCOL, LEFTDEADCOLS=0, FROZENMOVE=false]
			  InitColumnInfo(7, 0, 0, true);
			      
			  FocusEditMode = -1;
			      
			  //헤더기능 ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
			  InitHeadMode(false, true, true, false, false, false);
			  var HeadTitle = "|Sel.|Sub Continent|Region|Scope Indicator|ORG/DST|Delete Flag";
			    
			  //헤더초기화(Row, HeadText, [RowMerge], [Hidden]) 
		      InitHeadRow(0, HeadTitle, true);
		      
		      InitDataProperty(0, cnt++, dtHiddenStatus, 28, daCenter, false, prefix + "ibflag", false, "", dfNone, 0, true , true);
		      InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, prefix + "sel_chk");
		      InitDataProperty(0, cnt++, dtPopupEdit, 200, daCenter, true,  prefix +"svc_scp_sconti",  false, "", dfEngUpKey, 0, true, true, 2);
		      InitDataProperty(0, cnt++, dtPopupEdit, 130, daCenter, true,  prefix +"rgn_cd",  true, "", dfEngUpKey, 0, false, true, 3);
		      InitDataProperty(0, cnt++, dtComboEdit, 200, daCenter, true,  prefix +"svc_scp_ind_flg",  true, "", dfEngUpKey, 0, true, true);
		      InitDataProperty(0, cnt++, dtComboEdit, 200, daCenter, true,  prefix +"org_dest_cd",  true, "", dfEngUpKey, 0, false, true);
		      InitDataProperty(0, cnt++, dtComboEdit, 80, daCenter, true,  prefix +"delt_flg",  false, "", dfEngUpKey, 0, true, true);
		      InitDataCombo(0, prefix + "svc_scp_ind_flg", "Y - Yes|N - No", "Y|N");
		      InitDataCombo(0, prefix + "org_dest_cd", "O - Orgin|D - Destination", "O|D");
		      InitDataCombo(0, prefix + "delt_flg", "N|Y", "N|Y");
		      	
		      PopupImage  =  "img/btns_search.gif";
		      ShowButtonImage = 3; //Edit 가능할때 팝업 이미지 표시
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
    				
    				//var sXml=sheetObj.GetSearchData("BCM_CCD_0029GS.do", "f_cmd=" + SEARCH01);
    				var sXml=sheetObj.GetSearchXml("BCM_CCD_0029GS.do", "f_cmd=" + SEARCH01);
					var rtnValue=sXml.split("|$$|");
					
					for(var i=0; i < rtnValue.length; i++){
						var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
						var cdName=comboXml[0].split("|");
						var cdValue=comboXml[1].split("|");
					
						var tempCdName = "";
						var tempCdValue = "";
						var combinedCdName = "";
						
						if(i == 0){
							tempCdName = "|" + comboXml[0];
							tempCdValue = "|" + comboXml[1];
							
							cdName = tempCdName.split("|");
							cdValue = tempCdValue.split("|");
							
							for(var k=0; k<cdName.length; k++){
								if(cdName[k].trim() != ""){
									combinedCdName += cdValue[k] + " - " + cdName[k];
								}
								
								if(k != cdName.length - 1)
									combinedCdName += "|";
							}
							
							cdName = combinedCdName.split("|");
						}
						
						
						for (var j=0; j < cdName.length; j++) {
							
							if(i == 0){
								comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
								//comboObjects[i].InsertItem(j, combinedCdName[j], cdValue[j]);
							}else if(i == 1){
								//comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
								//comboObjects[i+1].InsertItem(j, cdName[j], cdValue[j]);
								//comboObjects[i+2].InsertItem(j, cdName[j], cdValue[j]);
							}
			        	}

						if(i == 1){
							//sheetObj.SetColProperty(prefix1+"delt_flg", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
							//sheetObjects[1].SetColProperty(prefix2+"svc_scp_ind_flg", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
							//sheetObjects[1].SetColProperty(prefix2+"delt_flg", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
						}else if(i == 2){
							//sheetObjects[1].SetColProperty(prefix2+"org_dest_cd", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
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
	    		
    			//sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
	        	
	        	sheetObjects[0].RemoveAll();
	        	sheetObjects[0].RemoveEtcData();
	        	sheetObjects[1].RemoveAll();
	        	sheetObjects[1].RemoveEtcData();
	        	
	    		var sParam=FormQueryString(formObj);
	    		var prefixArr=new Array("", prefix1, prefix2);
	    		var sXml=sheetObj.GetSearchXml("BCM_CCD_0029GS.do", sParam
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
    	    		formObj.svc_scp_nm.focus();
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
	    		
	    		formObj.svc_scp_cd.value=ComXmlString(rtnValue[0], "svc_scp_cd");
	    		formObj.svc_scp_nm.value=ComXmlString(rtnValue[0], "svc_scp_nm");
	    		formObj.svc_scp_bnd_cd.Code = ComXmlString(rtnValue[0], "svc_scp_bnd_cd");
	    		formObj.conf_flg.value = ComXmlString(rtnValue[0], "conf_flg");
	    		formObj.fmc_file_flg.value = ComXmlString(rtnValue[0], "fmc_file_flg");
	    		formObj.trf_pfx_cd.value=ComXmlString(rtnValue[0], "trf_pfx_cd");
	    		formObj.trf_no.value= ComXmlString(rtnValue[0], "trf_no");
	    		formObj.delt_flg.value = ComXmlString(rtnValue[0], "delt_flg");
	    		formObj.cre_usr_id.value = ComXmlString(rtnValue[0], "cre_usr_id");
	    		formObj.cre_dt.value= ComXmlString(rtnValue[0], "cre_dt");
	    		formObj.upd_usr_id.value = ComXmlString(rtnValue[0], "upd_usr_id");
	    		formObj.upd_dt.value = ComXmlString(rtnValue[0], "upd_dt");
	    		
	    		//sheetObj.LoadSearchData(rtnValue[1],{Sync:1} );
	    		//sheetObjects[1].LoadSearchData(rtnValue[2],{Sync:1} );
	    		//prompt("rtnValue[1]", rtnValue[1]);
	    		//prompt("rtnValue[2]", rtnValue[2]);
	    		
	    		sheetObjects[0].LoadSearchXml(rtnValue[1]);
	    		sheetObjects[1].LoadSearchXml(rtnValue[2]);
	    		
	    		ComOpenWait(false);
	    		formObj.svc_scp_cd.readOnly=true;
	    		ComBtnEnable("btn_row_addup");
	    		ComBtnEnable("btn_row_deleteup");
	    		ComBtnEnable("btn_row_adddn");
	    		ComBtnEnable("btn_row_deletedn");
	    		ComBtnEnable("btn_Save");
//	    		formObj.svc_scp_nm.focus()
    		}
    		break;
    	case MULTI01:				//save
    		if (validateForm(sheetObj, formObj, sAction)) {

    			/*
    			if( formObj.creflag.value == "N" && formObj.rqst_no.value == ''){
    				formObj.f_cmd.value=MULTI01;
    	 		}else{
    	 			formObj.f_cmd.value=MULTI02;
    	 			ComEnableObject(formObj.btn_scp_search, false);
    	 		}
    	 		*/
    			
    			formObj.f_cmd.value=MULTI01;
    			
    			var tmpMsg="";
    			if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
    				tmpMsg="CCD00034";
    			}else{
    				tmpMsg="COM130101";
    			}
    			
    			
	    		if(ComShowConfirm(ComGetMsg(tmpMsg, "Service Scope Code"))){
		    		//sheetObj.SetWaitImageVisible(0);
		        	ComOpenWait(true);
		        	
		    		var sParam=FormQueryString(formObj);
		    		sParam += "&" + sheetObj.GetSaveString(false, true, prefix1+"ibflag");
		    		sParam += "&" + sheetObjects[1].GetSaveString(false, true, prefix2+"ibflag");
		    		
		    		var sXml=sheetObj.GetSaveXml("BCM_CCD_0029GS.do", sParam);
	    			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	    			
		    		if(sav == "S" ){					//Saved after a successful re-viewed
		    			if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
	    					//ComShowCodeMessage("CCD00031");
		    				ComShowCodeMessage("CCD00060", "created");
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
    		formObj.svc_scp_bnd_cd.Code = "";
    		formObj.delt_flg.value = "N";
    		formObj.conf_flg.value = "";
    		formObj.fmc_file_flg.value = "";
    		
    		sheetObj.RemoveAll();
        	sheetObj.RemoveEtcData();
        	sheetObjects[1].RemoveAll();
        	sheetObjects[1].RemoveEtcData();
        	
        	ComBtnDisable("btn_Save");
        	ComBtnDisable("btn_row_addup");
    		ComBtnDisable("btn_row_deleteup");
    		ComBtnDisable("btn_row_adddn");
    		ComBtnDisable("btn_row_deletedn");
    		ComBtnEnable("btn_Create");
			ComBtnEnable("btn_Retrieve");
    		
    		ComEnableObject(formObj.btn_scp_search, true);
    		break;
    	case IBCREATE:
    		doActionIBSheet(sheetObj, formObj, IBCLEAR);
			formObj.ibflag.value="I";
			formObj.creflag.value="Y";
			ComBtnDisable("btn_Create");
			ComBtnDisable("btn_Retrieve");
			ComBtnEnable("btn_Save");
    		break;
    	case SEARCH10: // MDM AUTH_TP_CD query
    		/*
			var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=SVSP';
			var sXml=sheetObj.GetSearchXml("BCM_CCD_2002GS.do", sParam);
			
			// global var sestting
			G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
			G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
			*/
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
    		if(formObj.svc_scp_cd.value == ""){
    			ComShowCodeMessage("CCD00001", "Service Scope Code");
    			formObj.svc_scp_cd.focus();
    			return false;
    		}
    		
    		if(formObj.svc_scp_nm.value == ""){
    			ComShowCodeMessage("CCD00001", "Name");
    			formObj.svc_scp_nm.focus();
    			return false;
    		}
    		
    		if(formObj.svc_scp_bnd_cd.Code == ""){
    			ComShowCodeMessage("CCD00001", "Bound");
    			formObj.svc_scp_bnd_cd.focus();
    			return false;
    		}
    	
    		if(formObj.conf_flg.value == ""){
    			ComShowCodeMessage("CCD00001", "Conference Status");
    			formObj.conf_flg.focus();
    			return false;
    		}
    		
    		if(formObj.fmc_file_flg.value == ""){
				ComShowCodeMessage("CCD00001", "FMC File Status");
				formObj.fmc_file_flg.focus();
    			return false;
    		}
    		
    		/*
    		if(ComTrimAll(formObj.modi_cost_ctr_cd.value) == "" || formObj.modi_cost_ctr_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Sakura CTR Code");
    			formObj.modi_cost_ctr_cd.focus();
    			return false;
    		}
    		*/
    		
    		var cnt1=0;
    		for(i=1; i <= sheetObj.RowCount; i++){
    			if("U" == sheetObj.CellValue(i, prefix1+"ibflag") || "I" == sheetObj.CellValue(i, prefix1+"ibflag") || "D" == sheetObj.CellValue(i, prefix1+"ibflag")){
    				cnt1++;
    			}
    		}
    		
			if(cnt1 > 0 && !(sheetObj.GetSaveString(false, true, prefix1+"ibflag"))){
				return false;
			}
			
			var cnt2=0;
    		for(i=1; i <= sheetObjects[1].RowCount; i++){
    			if("U" == sheetObjects[1].CellValue(i, prefix2+"ibflag") || "I" == sheetObjects[1].CellValue(i, prefix2+"ibflag") || "D" == sheetObjects[1].CellValue(i, prefix2+"ibflag")){
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
		axon_event.addListenerForm('change', 'obj_change', formObj); 	
		//axon_event.addListenerForm('keypress', 'obj_keypress', formObj);
//		axon_event.addListenerForm('keyup', 'obj_keyup', form); 	
//		axon_event.addListenerForm('keydown', 'obj_keydown', form);
//		axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
		//axon_event.addListenerForm("propertychange", "obj_propertychange", formObj);
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
	}
	   /**
	   * HTML Object OnKeyPress event handling
	   */
	/*
	  function obj_keypress(event) {
	     	obj=event.srcElement;
	     	keyValidation(obj);
	     	
	   }
	   */
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
	           		//if(!ComShowCodeConfirm("COM130301", "data")) comObj.SetSelectCode("N",false);
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
				prefix = "sheet1_";
		     	var idx = sheetObj.DataInsert(-1);
	            sheetObj.SelectCell(sheetObj.SelectRow, prefix+"vsl_slan_cd", true);
	            sheetObj.CellValue(idx, prefix+"delt_flg") = "N";
	    	}
	    	break;
		case "sheet2":
	    	with (sheetObj) {
				prefix = "sheet2_";
				var idx = sheetObj.DataInsert(-1);
	            //sheetObj.SelectCell(sheetObj.SelectRow, prefix+"sub_conti", true);
	            sheetObj.CellValue(idx, prefix+"delt_flg") = "N";
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
			
				var prefix = "sheet1";
				var nRow = CheckedRows(prefix + "_sel_chk");
				
				if(nRow <= 0){
					ComShowCodeMessage("COM12114", "Sel.");
					return false;			
				}
				
				ComRowHideDelete(sheetObjects[0], prefix + "_sel_chk");
	    	}
	    	break;
		case "sheet2":
	    	with (sheetObj) {
		
				var prefix = "sheet2_";
				var nRow = CheckedRows(prefix + "sel_chk");
				
				if(nRow <= 0){
					ComShowCodeMessage("COM12114", "Sel.");
					return false;			
				}
				
				ComRowHideDelete(sheetObjects[1], prefix + "sel_chk");
	    	}
	    	break;
	    }         
	}
	
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		if (sheetObj.ColSaveName(Col) == prefix1+"vsl_slan_cd") {
			//+sheetObj.CellValue(Row,Col);
			var sUrl="/hanjin/COM_ENS_081.do?vsl_slan_cd=" + sheetObj.CellValue(Row, Col);
			ComOpenPopup(sUrl, 780, 410, 'getVsl_slan_cd', '1,0,1', true, false, Row, Col, 0);		
		}
	}
	
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		if (sheetObj.ColSaveName(Col) == prefix2+"rgn_cd") {
			var sUrl="/hanjin/COM_ENS_0J1.do?rgn_cd=" + sheetObj.CellValue(Row, Col);
			ComOpenPopup(sUrl, 780, 430, 'getRgn_cd', '0,1,1', true, false, Row, Col, 1);
		}
		
		if (sheetObj.ColSaveName(Col) == prefix2+"svc_scp_sconti") {
			var sUrl="/hanjin/COM_ENS_0I1.do?sconti_cd=" + sheetObj.CellValue(Row, Col);
			ComOpenPopup(sUrl, 780, 430, 'getSconti_cd', '0,1,1', true, false, Row, Col, 1);
		}
	}
	
	/**
	 * Sheet1의 OnChange event handling
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		
        with (sheetObj) {
        	
        	var colName = ColSaveName(Col);

        	switch(colName) {
            case prefix1+"vsl_slan_cd":
            	
            	if(Value != ""){
            		var slanCd=Value;
                	//sheetObj.SetWaitImageVisible(1);
            		for(i=1; i <= RowCount; i++){
    	           		if(i != Row){
    	           			//if(GetCellValue(i, prefix1+"vsl_slan_cd") == Value){
    	           			if(CellValue(i, prefix1+"vsl_slan_cd") == Value){
    	            			 ComShowCodeMessage("CCD00006");
    	            			 //SetCellValue(Row, prefix1+"vsl_slan_cd","",0);
    	            			 //CellValue(Row, prefix1+"vsl_slan_cd","",0);
    	            			 CellValue(Row, prefix1+"vsl_slan_cd") = "";
    	            			 SelectCell(Row, prefix1+"vsl_slan_cd");
    	            			 return;
    	            		 }
    		           	}
    		        }
            		
    	        	ComOpenWait(true);
    	    		var sParam="f_cmd="+SEARCH03+"&vsl_slan_cd="+slanCd;
    	    		var sXml=sheetObj.GetSearchXml("BCM_CCD_0029GS.do", sParam);
    	    		var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
    	    		
    	    		if(sav != "S" ){
    	        		ComOpenWait(false);
    	        		return;
    	    		}
    	    		
    	    		if(ComGetEtcData(sXml, "result") == null || ComGetEtcData(sXml, "result") == ""){
    	    			sheetObj.CellValue(Row, Col) = "";
    	    			ComShowCodeMessage("COM130402", "Vessel Service Lane Code");
    	    			ComOpenWait(false);
    	    			return;
    	    		}
    	    		
    	    		ComOpenWait(false);
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
        	
        	var colName = ColSaveName(Col);
        	
        	switch(ColSaveName(Col)) {
           
            case prefix2+"svc_scp_sconti":
            	
            	if(Value != ""){	//Cell Check only 1 time.
	            	var svcScpSconti = Value;
	            	var sParam="f_cmd="+SEARCH06+"&svc_scp_sconti="+svcScpSconti;
	            	
	            	var sXml=sheetObj.GetSearchXml("BCM_CCD_0029GS.do", sParam);
	            	var delflg = ComGetEtcData(sXml, "delt_flg");
	            	var sav = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	            	
	            	if(sav != "S" || delflg != "N"){
	            		ComOpenWait(false);
	            		ComShowCodeMessage("COM130402", "Sub-Continent Code");
	            		CellValue(Row, Col) = "";
		    			return;
	            	} else {
	            		
	            	}
            	}
            	
            	break;
            case prefix2+"rgn_cd":
            	
            	if(Value != ""){	//Cell Check only 1 time.
	            	var rgnCd=Value;

		        	if(!regionPopFlag) ComOpenWait(true);
		    		var sParam="f_cmd="+SEARCH04+"&rgn_cd="+rgnCd;
		    		var sXml=sheetObj.GetSearchXml("BCM_CCD_0029GS.do", sParam);
		    		var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		    		
		    		if(sav != "S" ){
		    			if(!regionPopFlag) ComOpenWait(false);
		        		return;
		    		}
		    		
		    		if(ComGetEtcData(sXml, "result") == null || ComGetEtcData(sXml, "result") == ""){
		    			CellValue(Row, Col) = "";
		    			ComShowCodeMessage("COM130402", "Region Code");
		    			if(!regionPopFlag) ComOpenWait(false);
		    			return;
		    		}
		    		
		    		if(!regionPopFlag) ComOpenWait(false);
		    		
		    		for(i=1; i <= RowCount; i++){
		           		if(i != Row){
		           			
		           			var subContiCd = CellValue(i, prefix2+"svc_scp_sconti");
		           			var rgnCd = CellValue(i, prefix2+"rgn_cd");
		           			var scpIndFlg = CellValue(i, prefix2+"svc_scp_ind_flg");
		           			var orgDestCd = CellValue(i, prefix2+"org_dest_cd");
		           			
		           			if(CellValue(Row, prefix2+"rgn_cd") == rgnCd && CellValue(Row, prefix2+"svc_scp_ind_flg") == scpIndFlg && CellValue(Row, prefix2+"org_dest_cd") == orgDestCd) {
		           				ComShowCodeMessage("CCD00006");
		            			 CellValue(Row, Col) = "";
		            			 CellValue(Row, prefix2+"svc_scp_sconti") = "";
		            			 SelectCell(Row, Col);
		           			}
		            		
		            		/*	 
							if(CellValue(i, prefix2+"rgn_cd") == CellValue(Row, prefix2+"rgn_cd")){
								if(CellValue(i, prefix2+"org_dest_cd") == CellValue(Row, prefix2+"org_dest_cd")){
			            			 ComShowCodeMessage("CCD00006");
			            			 CellValue(Row, Col) = "";
			            			 SelectCell(Row, Col);
			            			 return;
		            			 }
		            		 }
		            		 */
			           	}
			        }
            	}
            	break;
            case prefix2+"org_dest_cd":
            	//for(i=1; i <= LastRow(); i++){
            	for(i=1; i<= RowCount; i++){
	           		if(i != Row){
	           			
	           			/*
	           			if(GetCellValue(i, prefix2+"rgn_cd") == GetCellValue(Row, prefix2+"rgn_cd")){
	           					if(GetCellValue(i, prefix2+"org_dest_cd") == GetCellValue(Row, prefix2+"org_dest_cd")){
		            			 ComShowCodeMessage("CCD00006");
		            			 SetCellValue(Row, Col,"",0);
		            			 SelectCell(Row, Col);
		            			 return;
	            			 }
	            		}
	            		*/
	           			
	           			if(CellValue(i, prefix2+"rgn_cd") == CellValue(Row, prefix2 + "rgn_cd")){
	           				
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

	   	//sheetObj.SetCellValue(Row, Col,colArray[3]);
	   	sheetObj.CellValue(Row, Col) = colArray[3];
	}
	function getRgn_cd(rowArray, Row, Col) {
		var sheetObj=sheetObjects[1]
	    var formObj=document.form;
		
		/*
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
		*/
		
		var colArray=rowArray[0];
		
		var sconti = colArray[6]
		var regionCd = colArray[3]
		
		sheetObj.CellValue(Row, prefix2+"svc_scp_sconti") = sconti;
		sheetObj.CellValue(Row, Col) = colArray[3];
	}
	
	function getSconti_cd(rowArray, Row, Col){
		var sheetObj=sheetObjects[1]
	    var formObj=document.form;
		var colArray=rowArray[0]; 
		sheetObj.CellValue(Row, Col) = colArray[3];
	}
	
	  function getValueForCombo(obj) {
		  if (Object.prototype.toString.call(obj) === '[object Array]') {
			  var str = obj[0];
			  return str.split('|')[0];
		  }
		  return obj;
	  }   
