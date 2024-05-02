/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : BCM_CCD_0028.js
*@FileTitle  : Vessel service lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
			   MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
			   OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class BCM_CCD_0028 : BCM_CCD_0028 on the screen for creating the script defines the task using.
     */

    /** Common global variable */
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var prefix="sheet1_";
    /** Event handler processing by button click event */
    document.onclick=processButtonClick;
    /** Event handler processing by button name */
    function processButtonClick(){
        var formObj=document.form;
        
        try {
            var srcName=ComGetEvent("name");
            
            switch(srcName) {
            case "btn_History":
            	var tblNo = 'MDM_VSL_SVC_LANE';
	        	var vslslanCd = formObj.vsl_slan_cd.value;
	        	var mstKey = nullToBlank(vslslanCd);
	        	
				if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Vessel Service Lane");
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
            case "btn_Create":
            	doActionIBSheet(sheetObjects[0],formObj,IBCREATE);
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
            case "btn_Row_Add":
            	//addRow();
            	doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
            	break;
            case "btn_Row_Delete":
            	deleteRow();
            	break;
            case "btn_Calendar1":
				var cal=new ComCalendar();
				cal.select(formObj.st_eff_dt, 'yyyy-MM-dd');
            	break;
            case "btn_Calendar2":
				var cal=new ComCalendar();
				cal.select(formObj.end_eff_dt, 'yyyy-MM-dd');
            	break;
            case "btns_search1":
            	if(ComGetEvent().style.cursor == "default") return;
		      	var formObj=document.form;
		      	var sUrl="/hanjin/COM_ENS_081.do?mdm_yn="+formObj.mdm_yn.value+"&vsl_slan_cd=" + formObj.vsl_slan_cd.value + "&main_page=" + "false";
 		        var rVal=ComOpenPopup(sUrl, 770, 420, "vslSlanCodeHelp", "1,0,1,1,1,1,1,1", true);
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
     * registering IBSheet Object as list
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
    	document.form.ibflag.value="I";
    	
    	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
        
        doActionIBCombo(sheetObjects[0], formObj, SEARCH01);
        
        //doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
        
        //vsl_tp_cd.SetSelectCode("C");
        
        // 2014.12.04 set Company Code disabled
        //co_cd.SetSelectCode("H");
        //co_cd.SetEnable(false);
        formObj.co_cd.Code = "H";
        
		//delt_flg.SetSelectCode("N");
        
		formObj.edi_if_flg.value = "N";
    	// auth_tp_cd retrieve
    	//doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
		
    	var authTpCd=G_AHTU_TP_CD;
    	var rqstNo=formObj.rqst_no.value;
    	if(G_MDAA_CHK == 'Y')
    		formObj.delt_flg.enable=true;
    	else
    		formObj.delt_flg.enable=false;
    	
    	
    	//ComBtnDisable('btn_History');
    	ComBtnDisable('btn_Save');
    	ComBtnDisable("btn_Row_Add");
		ComBtnDisable("btn_Row_Delete");
    	
    	
    	// If the Process Status screen call, in the Detail PopUp
    	if(rqstNo != '') {
    		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);

    		//ComSetDisplay('btn_Close', true);
    		
    		var procTpCd=formObj.proc_tp_cd.value;
    		var rqstUsrChk=formObj.rqst_usr_chk.value;
    		ComEnableObject(formObj.btns_search1, false);
    		// Process Type is 'Reject' and AuthType is not 'Approval'(possible modifications and ReOpen)
    		if(procTpCd == 'R' &&  ( ((authTpCd == 'R' || authTpCd == 'S') && rqstUsrChk == 'Y') || G_MDAA_CHK == 'Y') ) {
    			//ComSetDisplay('btn_Request', true);
    			ComGetObject("btn_Request").style.setProperty("color", "#FF0000", "important");
    			//ComSetDisplay('btn_Retrieve', true);
    			//ComSetDisplay('btn_Save', true);
    			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    		} else if(procTpCd == 'A') {
    			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    			ComEnableObject(formObj.btns_search1, false);
    			//ComSetDisplay('btn_Retrieve', false);
    			//ComSetDisplay('btn_Save', false);
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
    	}
    }
    
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	
    	switch(sheetObj.id){
    	case "sheet1":
    		with(sheetObj){

    			  style.height = 300;
	    		  
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
			      InitColumnInfo(9, 0, 0, true);
			      
			      FocusEditMode = -1;
			      
			      //헤더기능 ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
			      InitHeadMode(false, true, true, false, false, false);

		      	  var HeadTitle = "|Sel.|Vessel Service Lane Direction|Sequence|DETCreUserID|DETCreDT|DETUpdUserID|DETUpdDT|DETDelFlg";

		      	  //헤더초기화(Row, HeadText, [RowMerge], [Hidden]) 
		      	  InitHeadRow(0, HeadTitle, true);

                  //데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		      	  InitDataProperty(0, cnt++, dtHiddenStatus, 28, daCenter, false, prefix + "ibflag", false, "", dfNone, 0, true , true);
		      	  
		      	
		      	  //InitDataProperty2(0, cnt++ , dtDelCheckEx,  "width=28; save-name = sheet1_delt_chk; all-check=false;update-edit=true;data-align=daCenter");
		      	  InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, prefix + "_sel_chk");
		      	  
		      	  InitDataProperty(0, cnt++, dtComboEdit, 200, daCenter, true,  prefix +"vsl_slan_dir_cd",  true, "", dfEngUpKey, 0, true, true);
		      	  InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix +"vsl_slan_dir_seq", false, "", dfInteger, 0, false, true);
		      	  
		      	  //InitDataProperty(0, cnt++, dtData, 180, daCenter, true, prefix +"det_cre_usr_id", false, "", dfEngUpKey, 0, true, false);
		      	  InitDataProperty(0, cnt++, dtData, 160, daCenter, true, prefix +"cre_usr_id", false, "", dfEngUpKey, 0, false, false);
		      	  
		      	  //InitDataProperty(0, cnt++, dtData, 160, daCenter, true, prefix +"det_cre_dt", false, "", dfDateYmd, 0,  false, false);
		      	  InitDataProperty(0, cnt++, dtData, 160, daCenter, true, prefix +"cre_dt", false, "", dfDateYmd, 0,  false, false);
		      	  
		      	  //InitDataProperty(0, cnt++, dtData, 180, daCenter, true, prefix +"det_updusr_id", false, "", dfNone, 0,  false, false);
		      	  InitDataProperty(0, cnt++, dtData, 160, daCenter, true, prefix +"upd_usr_id", false, "", dfNone, 0,  false, false);
		      	  
		      	  //InitDataProperty(0, cnt++, dtData, 160, daCenter, true, prefix +"det_upd_dt", false, "", dfDateYmd, 0,  false, false);
		      	  InitDataProperty(0, cnt++, dtData, 160, daCenter, true, prefix +"upd_dt", false, "", dfDateYmd, 0,  false, false);
		      	  
		      	  //InitDataProperty(0, cnt++, dtComboEdit, 90, daCenter, true, prefix +"det_del_flg", false, "", dfNone, 0,  false, true);
		      	  InitDataProperty(0, cnt++, dtComboEdit, 100, daCenter, true, prefix +"dir_delt_flg", false, "", dfNone, 0,  true, true);
		      	  
		      	  InitDataCombo(0, prefix + "dir_delt_flg", "N|Y", "N|Y");
	        }
    		break;
    	}
        
    }
    /**
     * All the combo box query
     */
    	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
    		switch (sAction) {
    			case SEARCH01: // load page
    				
    				//var sXml=sheetObj.GetSearchData("BCM_CCD_0028GS.do", "f_cmd=" + SEARCH01);	//GetSearchData > GetSearchXml 
    				var sXml=sheetObj.GetSearchXml("BCM_CCD_0028GS.do", "f_cmd=" + SEARCH01);	//GetSearchData > GetSearchXml
					var rtnValue=sXml.split("|$$|");
					
					// 2015.01.14 rtnValue legnth is not equal combo objects count 
					var comboIndex = 0;
					for(var i=0; i < rtnValue.length; i++){

						var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
						
						if(i==3) { // Company Code
							//formObj.co_cd.value=getValueForCombo(ComXmlString(rtnValue[i], "cd"));
							//formObj.co_nm.value=getValueForCombo(ComXmlString(rtnValue[i], "cd_desc"));
							//continue;
						}

						if(comboXml != undefined){

							var cdnames = "|" + comboXml[0];
							var cdvalues = "|" + comboXml[1];
							
							//var cdName=comboXml[0].split("|");
							//var cdValue=comboXml[1].split("|");
							var cdName = cdnames.split("|");
							var cdValue = cdvalues.split("|");
							
							
							for (var j=0; j < cdName.length; j++) {
								if(i < 4){
									comboObjects[comboIndex].InsertItem(j, cdName[j], cdValue[j]);
								}
				        	}
							
							if(i == 5){

								var arrDirName = comboXml[0].split("|");
								var arrDirCode = comboXml[1].split("|");
								var vesselSlanDirComboData = "";
									
								for(var k=0; k<arrDirName.length; k++){
									vesselSlanDirComboData += arrDirCode[k] + " - " + arrDirName[k];
									if(k != (arrDirName.length - 1))
										vesselSlanDirComboData += "|"; 
								}

								//sheetObj.InitDataCombo(0, prefix+"vsl_slan_dir_cd", " |" + comboXml[0], " |" + comboXml[0],"", "", 0);
								sheetObj.InitDataCombo(0, prefix+"vsl_slan_dir_cd", " |" + vesselSlanDirComboData, " |" + comboXml[1],"", "", 0);
								
							}else if(i == 6){
								//sheetObj.SetColProperty(prefix+"dir_delt_flg", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
							}else if(i == 7){
								//sheetObj.SetColProperty(prefix+"modi_vsl_slan_dir_cd", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
							}
							comboIndex ++;
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

	        	sheetObj.RemoveAll();
	        	sheetObj.RemoveEtcData();
        	
	    		var sParam=FormQueryString(formObj);
	    		var prefixArr=new Array("", prefix);

	    		//var sXml=sheetObj.GetSearchData("BCM_CCD_0028GS.do", sParam	+ "&" + ComGetPrefixParam(prefixArr));
	    		var sXml=sheetObj.GetSearchXml("BCM_CCD_0028GS.do", sParam + "&" + ComGetPrefixParam(prefixArr));
	    		var rtnValue=sXml.split("|$$|");
	    		
	    		var sav=ComGetEtcData(rtnValue[0], "TRANS_RESULT_KEY");
	    		var rqstNo=ComGetEtcData(rtnValue[0], "RQST_NO");
	    		
	    		if (rqstNo == "undefined"){
 	    			rqstNo="";
 	    		}
	    		
				ComSetObjValue(formObj.rqst_no, rqstNo);
				
				if(sav != "S" ){
	        		ComOpenWait(false);
	        		return;
	    		}
	    		
	    		
	    		if(ComXmlString(rtnValue[0], "delt_flg") == null || ComXmlString(rtnValue[0], "delt_flg") == ""){
	    			ComOpenWait(false);
	    			formObj.creflag.value="Y";
	    			formObj.vsl_slan_cd.readOnly=true;
	    			
	    			ComBtnEnable("btn_Save");
	    			ComBtnEnable("btn_Row_Add");
    	    		ComBtnEnable("btn_Row_Delete");
    	    		formObj.vsl_slan_nm.focus();

    	    		if(G_AHTU_TP_CD=="A"){
        	    		ComShowCodeMessage("CCD00034", "Vessel Service Lane Code");
        	    		doActionIBSheet(sheetObj, formObj, IBCLEAR);
        	    	}else{
        	    		if(!ComShowConfirm(ComGetMsg("CCD00034", "Vessel Service Lane Code"))){
        	    			doActionIBSheet(sheetObj, formObj, IBCLEAR);
        	    		}
        	    	}
	    			return;
	    		}else{
	    			formObj.creflag.value="N";
	    			formObj.delt_flg.value = ComXmlString(rtnValue[0], "delt_flg");
	    		}
	    		
	    		formObj.add_flg.value="U";
	    		
	    		formObj.vsl_slan_cd.value = ComXmlString(rtnValue[0], "vsl_slan_cd");
	    		formObj.vsl_slan_nm.value=ComXmlString(rtnValue[0], "vsl_slan_nm");
	    		formObj.vsl_tp_cd.Code = ComXmlString(rtnValue[0], "vsl_tp_cd");
	    		formObj.vsl_svc_tp_cd.Code = ComXmlString(rtnValue[0], "vsl_svc_tp_cd");
	    		formObj.fdr_div_cd.Code = ComXmlString(rtnValue[0], "fdr_div_cd");
	    		formObj.st_eff_dt.value = ComXmlString(rtnValue[0], "st_eff_dt");
	    		formObj.end_eff_dt.value = ComXmlString(rtnValue[0], "end_eff_dt");
	    		//formObj.co_cd.value = ComXmlString(rtnValue[0], "co_cd");
	    		formObj.co_cd.Code = ComXmlString(rtnValue[0], "co_cd");
	    		formObj.delt_flg.Code = ComXmlString(rtnValue[0], "delt_flg");
	    		formObj.modi_vsl_slan_cd.value=ComXmlString(rtnValue[0], "modi_vsl_slan_cd");
	    		formObj.old_modi_vsl_slan_cd.value=ComXmlString(rtnValue[0], "modi_vsl_slan_cd");
	    		formObj.modi_cost_ctr_cd.value = ComXmlString(rtnValue[0], "modi_cost_ctr_cd");
	    		//formObj.modi_vsl_slan_cd2.value=ComXmlString(rtnValue[0], "modi_vsl_slan_cd2");
	    		formObj.modi_vip_team_cd.value=ComXmlString(rtnValue[0], "modi_vip_team_cd");
	    		formObj.cre_usr_id.value=ComXmlString(rtnValue[0], "cre_usr_id");
	    		formObj.cre_dt.value=ComXmlString(rtnValue[0], "cre_dt");
	    		formObj.upd_usr_id.value=ComXmlString(rtnValue[0], "upd_usr_id");
	    		formObj.upd_dt.value=ComXmlString(rtnValue[0], "upd_dt");
	    		
	    		//sheetObj.LoadSearchData(rtnValue[1],{Sync:1} );
	    		if(ComXmlString(rtnValue[1], "sheet1_vsl_slan_dir_cd") != "")
	    			sheetObj.LoadSearchXml(rtnValue[1]);
	    		
	    		formObj.creflag.value="N";
	    		formObj.ibflag.value="U";
	    		
                ComBtnDisable("btn_Create");
                //ComBtnDisable("btn_Retrieve");
                ComBtnEnable("btn_Save");
    		
	    		ComOpenWait(false);
	    		//formObj.vsl_slan_cd.readOnly=true;
	    		
	    		ComBtnEnable("btn_Row_Add");
	    		ComBtnEnable("btn_Row_Delete");
    		}
    		break;
    	case MULTI01:				//save
    		if (validateForm(sheetObj, formObj, sAction)) {
    			if( formObj.creflag.value == "N" && formObj.rqst_no.value == ''){
    				formObj.f_cmd.value=MULTI01;
    				document.form.ibflag.value="U";
    	 		}else{
    	 			formObj.f_cmd.value=MULTI02;
    	 			ComEnableObject(formObj.btns_search1, false);
    	 		}
    			var tmpMsg="";
    			
    			if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
    				//tmpMsg="CCD00035";
    				tmpMsg="CCD00075";
    			}else{
    				tmpMsg="COM130101";
    			}
    			
	    		if(ComShowConfirm(ComGetMsg(tmpMsg, "Vessel Service Lane Code"))){
    			//if(ComShowCodeConfirm(tmpMsg, "Data")){	

	    			//sheetObj.SetWaitImageVisible(0);
		        	ComOpenWait(true);
		    		var sParam=FormQueryString(formObj);
		    		sParam += "&" + sheetObj.GetSaveString(false, true, prefix+"ibflag");
		    		
		    		var sXml = sheetObj.GetSaveXml("BCM_CCD_0028GS.do", sParam);
	    			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	    			
		    		if(sav == "S" ){					//Saved after a successful re-viewed
		    			if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
	    					ComShowCodeMessage("CCD00060", "created");
	    				} else {
	    					ComShowCodeMessage("COM130102", "Data");
	    				}
		        	}else{
		        		ComShowCodeMessage("COM132103", "Data");
			        }
		    		var rqstNo=ComGetEtcData(sXml, "RQST_NO");
					ComSetObjValue(formObj.rqst_no, rqstNo);
					doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
		    		ComOpenWait(false);
	    		}
    		}
    		break;
    	case IBCLEAR:
    		
    		formObj.reset();
    		formObj.rqst_no.value = "";
    		//formObj.co_nm.value = "NYK";
    		
    		//formObj.co_cd.value = "";
    		
    		formObj.vsl_slan_cd.readOnly=false;	
    		
    		//formObj.dist_ut_cd.text="";
    		formObj.vsl_svc_tp_cd.text = "";
    		formObj.vsl_tp_cd.text = "";
    		formObj.fdr_div_cd.text = "";
    		formObj.co_cd.text = "";
    		
    		//delt_flg.SetSelectCode("N");
    		formObj.old_modi_vsl_slan_cd.value = "";
    		formObj.edi_if_flg.value = "N";

    		//co_cd.SetSelectCode("H");
    		
    		sheetObj.RemoveAll();
        	sheetObj.RemoveEtcData();
        	
    		ComBtnDisable("btn_Row_Add");
            ComBtnDisable("btn_Row_Delete");
            ComBtnDisable("btn_Save");
            
            ComEnableObject(formObj.btns_search1, true);
    		formObj.add_flg.value="I";
    		break;
    	case IBCREATE:
    		formObj.ibflag.value="I";
			formObj.creflag.value="Y";
    		ComBtnDisable("btn_Retrieve");
    		ComBtnEnable("btn_Save");
    		break;
    	case SEARCH10: // MDM AUTH_TP_CD query
			var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=SCVL';
			
			//var sXml=sheetObj.GetSearchData("BCM_CCD_2002GS.do", sParam);
			var sXml=sheetObj.GetSearchXml("BCM_CCD_2002GS.do", sParam);
			
			// global var sestting
			//G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
			//G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
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
			
		case IBINSERT:
			
			//sheetObj
			var idx = sheetObj.DataInsert(-1);
            sheetObj.SelectCell(sheetObj.SelectRow, prefix+"vsl_slan_dir_cd", true);
            sheetObj.CellValue(idx, prefix+"det_del_flg") = "N";
            
            //alert(idx);
            
            sheetObj.CellValue(idx, prefix+"vsl_slan_dir_seq") = "1";
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
	    		if(formObj.vsl_slan_cd.value == "" || formObj.vsl_slan_cd.value == null || ComTrimAll(formObj.vsl_slan_cd.value).length < 3 ){
	    			ComShowCodeMessage("CCD00001", "Service Lane Code");
	    			formObj.vsl_slan_cd.focus();
	    			return false;
	    		}
    		}
    		break;
    	case MULTI01:
    		
    		if(ComTrimAll(formObj.vsl_slan_cd.value) == "" || formObj.vsl_slan_cd.value == null || ComTrimAll(formObj.vsl_slan_cd.value).length < 3){
    			ComShowCodeMessage("CCD00001", "Service Lane Code");
    			formObj.vsl_slan_cd.focus();
    			return false;
    		}

    		
    		if(ComTrimAll(formObj.vsl_slan_nm.value) == "" || formObj.vsl_slan_nm.value == null){
    			ComShowCodeMessage("CCD00001", "Name");
    			formObj.vsl_slan_nm.focus();
    			return false;
    		}
    		

    		
    		
    		//if(vsl_svc_tp_cd.GetSelectCode()== "" || vsl_svc_tp_cd.GetSelectCode()== null){
    		if(formObj.vsl_svc_tp_cd.Code == "" || formObj.vsl_svc_tp_cd.Code == null){
    			ComShowCodeMessage("CCD00001", "Lane Service Type");
    			formObj.vsl_svc_tp_cd.focus();
    			return false;
    		}
    		

    		
    		//if(vsl_tp_cd.GetSelectCode()== "" || vsl_tp_cd.GetSelectCode()== null){
    		if(formObj.vsl_tp_cd.Code == "" || formObj.vsl_tp_cd.Code == null){
    			ComShowCodeMessage("CCD00001", "Vessel Type");
//    			formObj.vsl_tp_cd.focus();
    			return false;
    		}
    		

    		
    		
    		//if(fdr_div_cd.GetSelectCode()== "" || fdr_div_cd.GetSelectCode()== null){
    		if(formObj.fdr_div_cd.Code == "" || formObj.fdr_div_cd.Code == null){
    			ComShowCodeMessage("CCD00001", "Feeder/Trunk");
//    			formObj.fdr_div_cd.focus();
    			return false;
    		}
    		
    		
    		
//    		if(co_cd.GetSelectCode()== "" || co_cd.GetSelectCode()== null){
//				ComShowCodeMessage("CCD00001", "Company Code");
//    			formObj.co_cd.focus();
//    			return false;
//    		}
    		
    		if(formObj.st_eff_dt.value != ""){
    			//Check the date format is correct
				if(!checkDateValue(formObj.st_eff_dt)){
					return false;
				}
    		}
    		if(formObj.end_eff_dt.value != ""){
    			//Check the date format is correct
				if(!checkDateValue(formObj.end_eff_dt)){
					return false;
				}
    		}
    		if((formObj.st_eff_dt.value != "") && (formObj.end_eff_dt.value != "")){
    			if(ComGetDaysBetween(formObj.st_eff_dt, formObj.end_eff_dt) < 0){
    				ComShowCodeMessage("CCD00005", "Expire Date", "Effect Date");
//    				formObj.end_eff_dt.focus();
    				return false;
    			}
    		}
    		
    		/*
    		if(ComTrimAll(formObj.modi_vsl_slan_cd.value) == "" || formObj.modi_vsl_slan_cd.value == null){
    			ComShowCodeMessage("CCD00001", "VIP Code");
//    			formObj.vsl_slan_nm.focus();
    			return false;
    		}
    		
    		if(ComTrimAll(formObj.modi_vsl_slan_cd2.value) == "" || formObj.modi_vsl_slan_cd2.value == null){
    			ComShowCodeMessage("CCD00001", "Legacy Code");
//    			formObj.vsl_slan_nm.focus();
    			return false;
    		}
    		
    		if(ComTrimAll(formObj.modi_cost_ctr_cd.value) == "" || formObj.modi_cost_ctr_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Sakura CTR Code");
//    			formObj.vsl_slan_nm.focus();
    			return false;
    		}
    		
    		if(ComTrimAll(formObj.modi_vip_team_cd.value) == "" || formObj.modi_vip_team_cd.value == null){
			    if (fdr_div_cd.GetSelectCode() == "T") {
					ComShowCodeMessage("CCD00001", "VIP Team Code");
					return false;
			    }
            }
    		
    		*/
    		
    		var cnt=0;
    		for(i=1; i <= sheetObj.RowCount; i++){
    			
    			//if("U" == sheetObj.GetCellValue(i, prefix+"ibflag") || "I" == sheetObj.GetCellValue(i, prefix+"ibflag") || "D" == sheetObj.GetCellValue(i, prefix+"ibflag")){
    			if("U" == sheetObj.CellValue(i,prefix+"ibflag") || "I" == sheetObj.CellValue(i,prefix+"ibflag") || "D" == sheetObj.CellValue(i,prefix+"ibflag")){
    				cnt++;
    			}
    		}
    		
			if(cnt>0 && !(sheetObj.GetSaveString(false, true, prefix+"ibflag"))){
				return false;
			}
			

			if (formObj.modi_vsl_slan_cd.value != formObj.old_modi_vsl_slan_cd.value) {
   	    	 	formObj.edi_if_flg.value = "Y";
   	     	} else {
   	     		formObj.edi_if_flg.value = "N";
   	     	}
    		break;
    	}
    	return true;
    }
    function delt_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	if(comboObj.GetSelectCode()== "Y"){
     		  if(!ComShowCodeConfirm("COM130301", "data")) comboObj.SetSelectCode("N",false);
        }
    }
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerForm('focus', 'obj_focus', form);
		axon_event.addListenerForm('blur', 'obj_change', form);
//		axon_event.addListenerForm('keypress', 'obj_keypress', form);
//		axon_event.addListenerForm('keyup', 'obj_keyup', form);
//		axon_event.addListenerForm('keydown', 'obj_keydown', form);
//		axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
		axon_event.addListenerForm("propertychange", "obj_propertychange", formObj);
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
	}
   /**
   * HTML Object OnKeyPress event handling
   */
   /*function obj_keypress(event) {
	   obj=event.srcElement;
	   keyValidation(obj);
       var formObj=document.form;
       var eleObj=window.event.srcElement;
       var srcName=eleObj.getAttribute("name");
       switch(srcName) {
          case "st_eff_dt":						//Check the date format is correct
          	checkDateForm(formObj.st_eff_dt);
          break;
          case "end_eff_dt":					//Check the date format is correct
          	checkDateForm(formObj.end_eff_dt);
          break;
      }
   }*/
    /**
    * If the data field to be the change event
    */
   function obj_change(){
	   	var formObj=document.form;
	   	try {
	   		var srcName=ComGetEvent("name");
	   		
	           switch(srcName) {
	           	case "vsl_slan_cd":
	           		if(formObj.vsl_slan_cd.value.length>0){
	           			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
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
	 * sheet1 add row handling
	 * add row.
	 */
	function addRow() {
		with (sheetObjects[0]) {
			var nowRow=GetSelectRow();
	     	nowRow=DataInsert(-1);
	     	//SetCellValue(nowRow, prefix+"dir_delt_flg","N",0);
	     	//SetCellValue(nowRow, prefix+"flg","Y",0);
	     	return true;
	    }
	}
	 /**
	  * sheet1 delete row
	  * delete row.
	  */
	function deleteRow() {
		
		with (sheetObjects[0]) {
			var nRow = CheckedRows(prefix + "_sel_chk");
			
			if(nRow <= 0){
				ComShowCodeMessage("COM12114", "Sel.");
				return false;			
			}
			
			ComRowHideDelete(sheetObjects[0], prefix + "_sel_chk");
		}
	}
	  /**
	   * Sheet1 OnSearchEnd event handling
	   */
	  function sheet_OnSearchEnd(sheetObj, ErrMsg) {
	     var frmObj=document.form;
	     for (i=1; i <= sheetObj.LastRow(); i++ ) {
	    	 if(sheetObj.GetCellValue(i, prefix+"dir_delt_flg") == "" || sheetObj.GetCellValue(i, prefix+"dir_delt_flg") == null){
	   		  sheetObj.RowDelete(i, false);
	         }
	      }
	  }
	/**
	 * Sheet1 OnChange  event handling
	 */
	function sheet_OnChange(sheetObj, Row, Col, Value) {
         with (sheetObj) {
             switch(ColSaveName(Col)) {
             case prefix+"vsl_slan_dir_cd":
            	 for(i=1; i <= LastRow(); i++){
            		 if(i != Row){
            			 if(GetCellValue(i, prefix+"vsl_slan_dir_cd") == Value){
	            			 ComShowCodeMessage("CCD00006");
	            			 SetCellValue(Row, prefix+"vsl_slan_dir_cd","",0);
	            			 SelectCell(Row, Col);
	            			 return;
	            		 }
            		 }
            	 }
            	 break;
             }
         }
	}
	
	function fdr_div_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj = document.form;
		if(newCode == "T"){
			formObj.modi_vip_team_cd.className = "input1";
		}else{
			formObj.modi_vip_team_cd.className = "input";
		}
		
	}

	 /**
     * Set selected value in the  vessel Lane code Inquiry pop-up.
     * 
     * @param rtnObjs
     * @param row
     * @param col
     * @param sheetIdx
     * @return
     */
    function vslSlanCodeHelp(rtnObjs, row, col, sheetIdx) {
    	var formObj=document.form;
    	formObj.vsl_slan_cd.value=rtnObjs[0][3];
		if(formObj.vsl_slan_cd.value.length>0){
			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
		}
    }
	  function getValueForCombo(obj) {
		  if (Object.prototype.toString.call(obj) === '[object Array]') {
			  var str = obj[0];
			  return str.split('|')[0];
		  }
		  return obj;
	  }  