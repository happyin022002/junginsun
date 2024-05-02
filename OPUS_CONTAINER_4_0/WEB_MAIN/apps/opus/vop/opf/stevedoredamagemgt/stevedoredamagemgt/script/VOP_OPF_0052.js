/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_OPF_0052.js
*@FileTitle  : Damage Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19 
=========================================================*/   	
/* Developer performance	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var uploadObjects=new Array();
	var uploadCnt=0;
    var approvalFlag=false;
	//Approval permission Set..
	var approvalCheck="";
    var gVpsEtbEtdDt;
    var addFlg=true;
    var userId="";
    var ofcCd="";
    var pageId="OPF0052";
    var stvDmgAtchFileTpCd=""
    var stvDmgProcCd="D";
    var noVpsPortCd = "";
    //var old_cd = "";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick() {
    	
    	var sheetObject1=sheetObjects[0];
         /*******************************************************/
        var formObject=document.form;
        var prefix="sheet1_";
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false; 
            switch(srcName) {
            	case "btn_SDR":
            		if(ComIsBtnEnable("btn_SDR")){
//            			var sUrl = "VOP_OPF_1052.do?pageId=OPF0052&stvDmgNo="+sheetObject1.GetCellValue(sheetObject1.SetSelectRow, "sheet1_stv_dmg_no")+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=SDR&vslCd="+formObject.vsl_cd.value;
//            			ComOpenPopup(sUrl, 505, 350, "setFileUpload", "none", true, "","''","''","''","Damage_Creation");
            			stvDmgAtchFileTpCd = "SDR";
            			showHideLayers(stvDmgAtchFileTpCd);
            		}
            		break;
            	case "btn_Picture":
            		if(ComIsBtnEnable("btn_Picture")){
            			stvDmgAtchFileTpCd="PIC";
            			showHideLayers(stvDmgAtchFileTpCd);
//            			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF0052&stvDmgNo="+sheetObject1.GetCellValue(sheetObject1.SetSelectRow, "sheet1_stv_dmg_no")+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=PIC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", 0, "","","","","Damage_Creation");
            		}
            		break;
            	case "btn_Document":
            		if(ComIsBtnEnable("btn_Document")){
            			stvDmgAtchFileTpCd="DOC";
            			showHideLayers(stvDmgAtchFileTpCd);
//            			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF0052&stvDmgNo="+sheetObject1.GetCellValue(sheetObject1.SetSelectRow, "sheet1_stv_dmg_no")+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=DOC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", 0, "","","","","Damage_Creation");
            		}
            		break;
	            case "vsl_cd_pop":
	            	if(!(formObject.vsl_cd.readOnly)){
	            		var sUrl="";
	                	var vsl_cd=formObject.vsl_cd.value;
	                	if(isNull(vsl_cd)){
	                		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
	                		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
	                	}else{
	                		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
	                		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
	                	}
	            	}
	            	break;
	            case "clm_hndl_ofc_cd_pop":
	            	if(!(formObject.clm_hndl_ofc_cd.readOnly)){
		            	ComOpenPopup("COM_ENS_071.do", 750, 470, "clm_hndl_ofc_cd_pop_event", "0,0", true);
	            	}
	            	break;
	            case "req_skd_voy_dir_pop":
	            	if(!(formObject.stv_dmg_req_cate_cd[2].checked)
	            		&& !(formObject.req_skd_voy_dir.readOnly))
	            	{
		            	//ComOpenPopup("VOP_VSK_0230.do?op=0230", 300, 360, "req_skd_voy_dir_pop_event", "0,0", true);
		            	var vsl_cd=formObject.vsl_cd.value;
		            	if(isNull(vsl_cd)){
		            		//ComShowMessage("Vessel Code is not exist.");
		            		ComShowCodeMessage("OPF50009", "Vessel Code");
		            		//ComSetFocus(formObject.vsl_cd);
		            		formObject.vsl_cd.focus();
		            	}
		            	else{
		            		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
	                		ComOpenPopup(sUrl, 335, 420, "req_skd_voy_dir_pop_event", "0,0", true);
		            	}
	            	}
	            	break;
            	case "btn_stv_dmg_evnt_dt":
            		if(!(formObject.stv_dmg_evnt_dt.readOnly)){
                		var cal=new ComCalendar();
                    	cal.select(form.stv_dmg_evnt_dt, 'yyyy-MM-dd');
            		}
            		break;
            	case "btn_req_eta_dt":
            		if(!(formObject.stv_dmg_req_cate_cd[2].checked)
            			&& !(formObject.req_eta_dt.readOnly))
            		{
                		var cal=new ComCalendar();
                    	cal.select(form.req_eta_dt, 'yyyy-MM-dd');
            		}
            		break;
            	case "btn_Prev":
            		if(ComIsBtnEnable("btn_Prev")
            				&& (sheetObject1.GetRowStatus(sheetObject1.GetSelectRow())=="R"
            				|| validateForm(sheetObject1,formObject)))
            		{
    					moveScreen(sheetObject1, formObject, -1);
            		}
					break;
            	case "btn_Next":
            		if(ComIsBtnEnable("btn_Next")
            				&& (sheetObject1.GetRowStatus(sheetObject1.GetSelectRow())=="R"
            				|| validateForm(sheetObject1,formObject)))
            		{
            			moveScreen(sheetObject1, formObject, 1);
            		}
					break;
				case "btn_Add":
					if(ComIsBtnEnable("btn_Add")){
						if(!validateForm(sheetObject1,formObject)){
							return false;
						}
						initDefaultSheet(sheetObject1, formObject, "A");
						dataClear(formObject, "add");
						setScreenreadOnly(false, formObject, sheetObject1);
					}
					break;
				case "btn_Delete":
					var stvDmgNo=formObject.stv_dmg_no.value;
					var resultXml1=sheetObject1.GetSearchData("VOP_OPF_0052GS.do?f_cmd="+COMMAND02+"&stv_dmg_no="+stvDmgNo);
					var delCheckInd=ComGetEtcData(resultXml1, "del_check_ind");
					if (delCheckInd !="0"){
						ComShowCodeMessage("OPF50026", stvDmgNo);
						return false;
					}
					if(ComIsBtnEnable("btn_Delete")){
						if(sheetObject1.GetRowStatus(sheetObject1.GetSelectRow())=="I"){
							for(var sh=1; sh<=3; sh++) {
								for(var i=sheetObjects[sh].LastRow(); i>=sheetObjects[sh].HeaderRows(); i--) {
									if( sheetObjects[sh].GetCellValue(i, "sheet"+(sh+1)+"_stv_dmg_no") == sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_stv_dmg_no") ){
				        				sheetObjects[sh].SetRowStatus(i,"D");
				        			}
				        		}
							}
							sheetObject1.SetRowStatus(sheetObject1.GetSelectRow(),"D");
							moveScreen(sheetObject1, formObject, 0);
						}
						else{
							if(ComShowCodeConfirm("OPF50002", "the sequence")){
								sheetObject1.SetRowStatus(sheetObject1.GetSelectRow(),"D");
							}
						}
					}
					if(ComIsBtnEnable("btn_Save"))
					{
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						if(sheetObject1.RowCount()<1){
							initDefaultSheet(sheetObject1, formObject);
							dataClear(formObject);
						}
					}					
					break;
				case "btnApproval":
					if(ComIsBtnEnable("btnApproval")){
						doActionIBSheet(sheetObject1,formObject,IBSAVE, "Approval");
					}
					break;
				case "btn_Retrieve":
					ComUploadRemoveFile(upload1, "", true);
					if(!searchValidation(formObject)){
						return false;
					}
					if(formObject.stv_dmg_no.value != ""){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH,"File");
					}else{
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					var stvDmgNo=formObject.stv_dmg_no.value;
					var resultXml1=sheetObject1.GetSearchData("VOP_OPF_0052GS.do?f_cmd="+COMMAND02+"&stv_dmg_no="+stvDmgNo);
					var delCheckInd=ComGetEtcData(resultXml1, "del_check_ind");
					if (delCheckInd == 0) 	ComBtnEnable("btn_Delete");
					else 					ComBtnDisable("btn_Delete");
					formObject.stv_dmg_no.focus();
					break;
				case "btn_New":
					if(ComIsBtnEnable("btn_New"))
					{
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					}
					break;
				case "btn_Save":
					if(ComIsBtnEnable("btn_Save"))
					{
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						if(sheetObject1.RowCount()<1){
							initDefaultSheet(sheetObject1, formObject);
							dataClear(formObject);
						}
					}
					break;
				case "btn_Mail":
					//ComOpenPopup("VOP_OPF_2052.do", 700, 530, "", "0,0", true);
					formObject.com_templateMrdArguments.value="/rp ["+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_stv_dmg_no")+"]";
					ComSendMailModal();
					break;
				case "btn_fileAdd1":
					if(sheet2.GetCellValue(sheet2.LastRow(), "sheet2_file_sav_id") == ""){
						return;
					}
					sheet2.DataInsert(-1);
					break;
				case "btn_fileAdd2":
					if(sheet3.GetCellValue(sheet3.LastRow(), "sheet3_file_sav_id") == ""){
						return;
					}
					sheet3.DataInsert(-1);
					break;
				case "btn_fileAdd3":
					if(sheet4.GetCellValue(sheet4.LastRow(), "sheet4_file_sav_id") == ""){
						return;
					}
					sheet4.DataInsert(-1);
					break;
				case "btn_fileDel1":
					deleteRow(sheet2);
					setFileUpload(stvDmgAtchFileTpCd, stvDmgProcCd);
					break;
				case "btn_fileDel2":
					deleteRow(sheet3);
					setFileUpload(stvDmgAtchFileTpCd, stvDmgProcCd);
					break;
				case "btn_fileDel3":
					deleteRow(sheet4);
					setFileUpload(stvDmgAtchFileTpCd, stvDmgProcCd);
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
     * registering IBMultiCombo Object as list <br>
     * defining list on the top of source and this  method called automatically by creating IBMultiCombo object by {@link CoObject#ComComobject} <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * register IBUpload Object created on page to uploadObjects array <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObj.AutoConfirm="UP_OVERWRITE_YES DELETE_YES";
		uploadObjects[uploadCnt++]=uploadObj;
	}
	/**
     * setting Combo
     * set item of Combo
     */
	function initCombo(comboObj) {
    	with(comboObj) {
    		switch(comboObj.options.id) {
    		    case "vps_port_cd":
	  				SetEnable(1);
	  				SetDropHeight(230);
	  				SetMultiSelect(0);
	  				SetColWidth(0, "60");
	  				SetColWidth(1, "120");
	  				SetColWidth(2, "60");
	  				SetMultiSeparator("|");
	  				SetEditable(true);
	  				ValidChar(2,1);
	  				SetUseAutoComplete(true);
	  				break
		        case "vsl_oshp_cntr_blk_tp_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
		            break;
		        case "stv_dmg_prt_cate_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
		            break;
		        case "stv_dmg_prt_cd":
	            	SetTitle("Code|Part");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
		            break;
		        case "stv_dmg_tp_cd":
	            	SetTitle("Code|Damage");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
		            break;
		        case "stv_dmg_qttn_rsn_desc":
	            	SetTitle("Code|Description");
					SetColWidth(0, "45");
					SetColWidth(1, "140");
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
		            break;
		        case "stv_dmg_respb_desc":
	            	SetTitle("Code|Description");
					SetColWidth(0, "45");
					SetColWidth(1, "185");
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
		            break;
		    }
    	}
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(strUsrId, strOfcCd) {
		for(i=0;i<sheetObjects.length;i++){
			//change start configuration method name 
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//add last configuration method 
			ComEndConfigSheet(sheetObjects[i]);
		}
		//initializing Combo 
    	for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k]);
        }
		//UPLOAD configuration
        for(var i=0;i<uploadObjects.length;i++){
		    //1. basic configuration
		    ComConfigUpload(uploadObjects[i], "/opuscntr/VOP_OPF_0052GS.do");
		}
		userId=strUsrId;
		ofcCd=strOfcCd;
		initControl();
		initDefaultSheet(sheetObjects[0], document.form, "Y");
		initApprovalPermission(sheetObjects[0], document.form);
		ComSetFocus(document.form.vsl_cd);
		initUpload();
		setSequence(sheet2);
		setSequence(sheet3);
		setSequence(sheet4);
	}
    /**
     * Loading event of HTML Control in page dynamically <br>
     * initializing IBSheet by calling {@link #loadPage}Method <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 
     **/
    function initControl(){
    	//axon_event.addListenerForm  ('blur',      'obj_deactivate', form); 
    	axon_event.addListenerFormat('blur',      'obj_deactivate', document.form); 
        axon_event.addListenerFormat('focus',     'obj_activate',   document.form); 
       
    	// in case of inputting HTML data, Data Set on Hidden Grid
    	axon_event.addListener  ('blur'  , 'blur_event' , 'skd_dir_cd', 'stv_dmg_no' , 'vsl_cd', 'skd_voy_no' , 'stv_dmg_ref_no', 'clm_hndl_ofc_cd' , 'stv_dmg_loc_desc' , 'cntr_no', 'stv_dmg_rmk', 'req_skd_voy_dir'  , 'stv_dmg_respb_desc_dtl');
    	axon_event.addListener  ('click'  , 'click_event', 'stv_dmg_prt_cd', 'cntr_dmg_flg', 'cgo_dmg_flg', 'stv_dmg_req_cate_cd', 'stv_dmg_respb_pty_kwn_flg');
    	axon_event.addListener  ('change'  , 'change_event', 'vsl_cd' , 'skd_voy_no', 'skd_dir_cd' , 'stv_dmg_ref_no'  , 'stv_dmg_evnt_dt' , 'stv_dmg_loc_desc'  , 'cntr_no' , 'stv_dmg_rmk' , 'req_skd_voy_dir'  , 'req_port_cd' , 'stv_dmg_respb_desc_dtl', 'stv_dmg_rpt_atch_flg', 'stv_dmg_pict_atch_flg', 'stv_dmg_doc_atch_flg' , 'req_reason_desc', 'res_reason_desc');
    	axon_event.addListener  ('focus'  , 'focus_event', 'vsl_cd' , 'skd_voy_no' , 'skd_dir_cd' , 'stv_dmg_no', 'stv_dmg_ref_no' , 'clm_hndl_ofc_cd' , 'stv_dmg_loc_desc' , 'cntr_no' , 'stv_dmg_rmk'	 , 'req_skd_voy_dir'  , 'stv_dmg_respb_desc_dtl');
    }
    /**
     * function move page of Prev/Next button <br>
     **/
    function moveScreen(sheetObj, formObj, moveSeq) {
        if( moveSeq==-1 && sheetObj.GetSelectRow()==1 ){
        	//ComShowMessage("No more Previous Page.");
        	setSubButton();
        	return false;
        }
        else if( moveSeq==1 && sheetObj.GetSelectRow()==sheetObj.LastRow()){
        	//ComShowMessage("No more Next Page.");
        	setSubButton();
        	return false;
        }
        sheetObj.SetSelectRow(sheetObj.GetSelectRow()+ moveSeq);
        setSubButton();
        //Set Grid Data on page 
        var prefix="sheet1_";
        var thisRow=sheetObj.GetSelectRow();
        //ComBkgXml2ComboItem2(sXml, cnt_cd, "cnt_cd", "cnt_nm" );
        //VVD CD
		formObj.vsl_cd.value=sheetObj.GetCellValue(thisRow, prefix+"vsl_cd"); 
		formObj.skd_voy_no.value=sheetObj.GetCellValue(thisRow, prefix+"skd_voy_no");
		formObj.skd_dir_cd.value=sheetObj.GetCellValue(thisRow, prefix+"skd_dir_cd");
		//port
		var dmgPrtCd = sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_prt_cd");
		
//		comboObj.GetSelectCode();
//        sheetObj.SetCellValue(thisRow, prefix+"stv_dmg_prt_cd") = cateCodeValue;
		
//		alert(cateCodeValue);
//		formObj.stv_dmg_prt_cd.value = sheetObj.GetCellValue(thisRow, prefix+sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_prt_cd"));
		
//		formObj.vps_port_cd.value=sheetObj.GetCellValue(thisRow, prefix+"vps_port_cd");
		//Damage Date
		formObj.stv_dmg_evnt_dt.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_evnt_dt"); 
		//	Report No. (If any at SDR)
		formObj.stv_dmg_ref_no.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_ref_no");
		//Claim Handling Office
		formObj.clm_hndl_ofc_cd.value=sheetObj.GetCellValue(thisRow, prefix+"clm_hndl_ofc_cd");
		//Damage

		comboObjects[4].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_tp_cd"),false);
		//Location / Size / Qty
		formObj.stv_dmg_loc_desc.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_loc_desc");
		if(sheetObj.GetCellValue(thisRow, prefix+"cntr_dmg_flg")=="Y"){
        	formObj.cntr_dmg_flg.checked=true;
        }else{
        	formObj.cntr_dmg_flg.checked=false;
        }
		
		//Vessel Category
		comboObjects[1].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"vsl_oshp_cntr_blk_tp_cd"), true);
		//Damage Category
		comboObjects[2].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_prt_cate_cd"), true);
		
		comboObjects[3].SetSelectCode(dmgPrtCd,true);
		
		if(sheetObj.GetCellValue(thisRow, prefix+"cgo_dmg_flg")=="Y"){
        	formObj.cgo_dmg_flg.checked=true;
        }else{
        	formObj.cgo_dmg_flg.checked=false;
        }
		//CNTR No.
		formObj.cntr_no.value=sheetObj.GetCellValue(thisRow, prefix+"cntr_no");
		//Time Loss (Hours)
		formObj.fm_tm_lss_dt.value=sheetObj.GetCellValue(thisRow, prefix+"fm_tm_lss_dt");
		formObj.to_tm_lss_dt.value=sheetObj.GetCellValue(thisRow, prefix+"to_tm_lss_dt");
		
        formObj.time_loss_hours.value="";
		if( !isNull(sheetObj.GetCellValue(thisRow, prefix+"fm_tm_lss_dt"))
		&& !isNull(sheetObj.GetCellValue(thisRow, prefix+"to_tm_lss_dt")))
        {
        	//var lossHour = getDateHoursBetween(sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt"), sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt"));
        	//if(lossHour==false){ lossHour = ""; }
        	//formObj.time_loss_hours.value = lossHour
			formObj.time_loss_hours.value=getDateHoursBetween(sheetObj.GetCellValue(thisRow, prefix+"fm_tm_lss_dt"), sheetObj.GetCellValue(thisRow, prefix+"to_tm_lss_dt"));
        }
		formObj.stv_dmg_rmk.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_rmk");
        comboObjects[5].SetSelectIndex("",false);
        comboObjects[6].SetSelectIndex("",false);
        formObj.req_reason_desc.value="";
        formObj.res_reason_desc.value="";
        if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="R")
        {
        	formObj.stv_dmg_req_cate_cd[0].checked=true;
        }
        else if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="S")
        {
        	formObj.stv_dmg_req_cate_cd[1].checked=true;
        }
        else if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="Q")
        {
        	formObj.stv_dmg_req_cate_cd[2].checked=true;
			comboObjects[5].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_qttn_cd"),false);
			formObj.req_reason_desc.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_qttn_rsn_desc");
        }
        formObj.req_skd_voy_dir.value=sheetObj.GetCellValue(thisRow, prefix+"req_skd_voy_no") + sheetObj.GetCellValue(thisRow, prefix+"req_skd_dir_cd");
//		setVVDPortCombo(sheetObj, formObj, "Voy", false);
        formObj.req_port_cd.value=sheetObj.GetCellValue(thisRow, prefix+"req_port_cd");
//        comboObjects[6].Code2 				= sheetObj.CellValue(thisRow, prefix+"req_port_cd");
        formObj.req_eta_dt.value=sheetObj.GetCellValue(thisRow, prefix+"req_eta_dt");
        if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_flg")=="Y"){
        	formObj.stv_dmg_respb_pty_kwn_flg[0].checked=true;
        	formObj.stv_dmg_respb_desc_dtl.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_desc");
        }else{
        	formObj.stv_dmg_respb_pty_kwn_flg[1].checked=true;
        	formObj.stv_dmg_respb_desc_dtl.value="";
        	comboObjects[6].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_cd"),false);
        	formObj.res_reason_desc.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_desc");
        }
        
	//	formObj.stv_dmg_prt_cd.value=dmgPrtCd ;
	//	alert("cateCodeValue "+dmgPrtCd);
		
        if(sheetObj.GetCellValue(thisRow, prefix+"dmg_auth_sts_cd")=="N")
        {
    		formObj.dmg_auth_sts_cd.className="input2_red";
			document.getElementById("btnApproval").style.color="red";
        	if(approvalFlag){
        		ComBtnEnable("btnApproval");
        	}
        	else{
        		ComBtnDisable("btnApproval");
        	}
    	}
        else{
    		formObj.dmg_auth_sts_cd.className="input2";
			document.getElementById("btnApproval").style.color="#c0c0c0";
        	ComBtnDisable("btnApproval");
        }
		formObj.dmg_auth_sts_cd.value=sheetObj.GetCellValue(thisRow, prefix+"dmg_auth_sts_cd");
		formObj.auth_usr_id.value=sheetObj.GetCellValue(thisRow, prefix+"auth_usr_id");
		
		if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_flg")!="Y"){
			formObj.auth_dt.value=sheetObj.GetCellValue(thisRow, prefix+"auth_dt");
		}
				
		formObj.stv_dmg_rpt_atch_flg.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_rpt_atch_knt");
		formObj.stv_dmg_pict_atch_flg.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_pict_atch_knt");
		formObj.stv_dmg_doc_atch_flg.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_doc_atch_knt");
        setDisplaySeq(formObj, sheetObj);
        if(sheetObj.GetRowStatus(thisRow)=="R"){
        	setScreenreadOnly(true, formObj, sheetObj);
        }
        else{
        	setScreenreadOnly(false, formObj, sheetObj);
        	if(isNull(comboObjects[2].GetSelectCode())){
            	comboObjects[3].SetEnable(0);
            }else{
            	comboObjects[3].SetEnable(1);
            }
        }
        initApprovalPermission(sheetObj, formObj);
    }
    /**
     * setting Disable/Enable of Sub button <br>
     **/
    function setSubButton(){        
    	if ( (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) !="I")&&(sheetObjects[0].RowCount()> 0) && (approvalCheck == '1' || userId == sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_cre_usr_id"))) {
			ComBtnEnable("btn_Delete");
		} else {
			ComBtnDisable("btn_Delete");
		}
 		ComBtnEnable("btn_Save");
 		ComBtnEnable("btn_New");
    }
    /**
     * prohibit modifying retrieved data of HTML Control <br>
     **/
    function setScreenreadOnly(disableFlag, formObj, sheetObj) {
    	if(disableFlag){
    		formObj.vsl_cd.readOnly=true;
            formObj.vsl_cd.className="input2";
            formObj.skd_voy_no.readOnly=true;
            formObj.skd_voy_no.className="input2";
            formObj.skd_dir_cd.readOnly=true;
            formObj.skd_dir_cd.className="input2";
            formObj.stv_dmg_evnt_dt.readOnly=true;
            formObj.stv_dmg_evnt_dt.className="input2";
            //formObj.vps_port_cd.readOnly=true;
            //formObj.vps_port_cd.className="input2";
//            comboObjects[1].Enable = false;
            
            comboObjects[0].SetEnable(0);//Port
            comboObjects[1].SetEnable(0);// vessel category
            comboObjects[2].SetEnable(0);// damage category
            /************** Header *****************************/
//            formObj.stv_dmg_ref_no.readOnly = true;
//            formObj.stv_dmg_ref_no.className = "input2";
//            formObj.clm_hndl_ofc_cd.readOnly = true;
//            formObj.clm_hndl_ofc_cd.className = "input2";
//            
//            comboObjects[3].Enable = false;
//            comboObjects[4].Enable = false;
//            formObj.stv_dmg_loc_desc.readOnly = true;
//            formObj.stv_dmg_loc_desc.className = "input2";
//            ComBtnDisable("btn_SDR");
//            ComBtnDisable("btn_Picture");
//            ComBtnDisable("btn_Document");
//            formObj.stv_dmg_rpt_atch_flg.className = "input2";
//            formObj.stv_dmg_pict_atch_flg.className = "input2";
//            formObj.stv_dmg_doc_atch_flg.className = "input2";
//            formObj.cntr_dmg_flg.disabled = true;
//            formObj.cgo_dmg_flg.disabled = true;
//            formObj.cntr_no.readOnly = true;
//            formObj.cntr_no.className = "input2";
//            formObj.fm_tm_lss_dt.readOnly = true;
//            formObj.fm_tm_lss_dt.className = "input2";
//            formObj.to_tm_lss_dt.readOnly = true;
//            formObj.to_tm_lss_dt.className = "input2";
//            formObj.stv_dmg_rmk.readOnly = true;
//            formObj.stv_dmg_rmk.className = "input2";
//            formObj.stv_dmg_req_cate_cd[0].disabled = true;
//            formObj.stv_dmg_req_cate_cd[1].disabled = true;
//            formObj.stv_dmg_req_cate_cd[2].disabled = true;
//            formObj.req_skd_voy_dir.readOnly = true;
//            formObj.req_skd_voy_dir.className = "input2";
//            formObj.req_port_cd.readOnly = true;
//            formObj.req_port_cd.className = "input2";
//            formObj.req_eta_dt.readOnly = true;
//            formObj.req_eta_dt.className = "input2";
//            formObj.stv_dmg_respb_pty_kwn_flg[0].disabled = true;
//            formObj.stv_dmg_respb_pty_kwn_flg[1].disabled = true;
//            formObj.stv_dmg_respb_desc_dtl.readOnly = true;
//            formObj.stv_dmg_respb_desc_dtl.className = "input2";
//            comboObjects[5].Enable = false;
//            comboObjects[6].Enable = false;
//            formObj.req_reason_desc.readOnly = true;
//            formObj.req_reason_desc.className = "input2";
//            formObj.res_reason_desc.readOnly = true;
//            formObj.res_reason_desc.className = "input2";
    	}
    	else{
    		if(isNull(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_no"))){
    			formObj.vsl_cd.readOnly=false;
                formObj.vsl_cd.className="input1";
                formObj.skd_voy_no.readOnly=false;
                formObj.skd_voy_no.className="input1";
                formObj.skd_dir_cd.readOnly=false;
                formObj.skd_dir_cd.className="input1";
                //formObj.vps_port_cd.readOnly=false;
                //formObj.vps_port_cd.className="input1";   
                //formObj.vps_port_cd.className="input1";                 
//                comboObjects[1].Enable = true;
                comboObjects[0].SetEnable(1);
                comboObjects[1].SetEnable(1);
                comboObjects[2].SetEnable(1);
    		}
    		else{
    			formObj.vsl_cd.readOnly=true;
                formObj.vsl_cd.className="input2";
                formObj.skd_voy_no.readOnly=true;
                formObj.skd_voy_no.className="input2";
                formObj.skd_dir_cd.readOnly=true;
                formObj.skd_dir_cd.className="input2";
                //formObj.vps_port_cd.readOnly=true;
                //formObj.vps_port_cd.className="input2";               
//                comboObjects[1].Enable = false;
                comboObjects[0].SetEnable(0);
                comboObjects[1].SetEnable(0);
                comboObjects[2].SetEnable(0);
    		}
            formObj.stv_dmg_evnt_dt.readOnly=false;
            formObj.stv_dmg_evnt_dt.className="input1";
            formObj.stv_dmg_ref_no.readOnly=false;
            formObj.stv_dmg_ref_no.className="input";
            formObj.clm_hndl_ofc_cd.readOnly=false;
            formObj.clm_hndl_ofc_cd.className="input1";
//            comboObjects[2].Enable = true;
            comboObjects[4].SetEnable(1);
            formObj.stv_dmg_loc_desc.readOnly=false;
            formObj.stv_dmg_loc_desc.className="input";
            ComBtnEnable("btn_SDR");
            ComBtnEnable("btn_Picture");
            ComBtnEnable("btn_Document");
            formObj.stv_dmg_rpt_atch_flg.className="input";
            formObj.stv_dmg_pict_atch_flg.className="input";
            formObj.stv_dmg_doc_atch_flg.className="input";
            formObj.cntr_dmg_flg.disabled=false;
            formObj.cgo_dmg_flg.disabled=false;
            formObj.cntr_no.readOnly=false;
            formObj.cntr_no.className="input";
            formObj.fm_tm_lss_dt.readOnly=false;
            formObj.fm_tm_lss_dt.className="input";
            formObj.to_tm_lss_dt.readOnly=false;
            formObj.to_tm_lss_dt.className="input";
            formObj.stv_dmg_rmk.readOnly=false;
            formObj.stv_dmg_rmk.className="input";
            formObj.stv_dmg_req_cate_cd[0].disabled=false;
            formObj.stv_dmg_req_cate_cd[1].disabled=false;
            formObj.stv_dmg_req_cate_cd[2].disabled=false;
            formObj.req_skd_voy_dir.readOnly=false;
            formObj.req_skd_voy_dir.className="input";
            formObj.req_port_cd.readOnly=false;
            formObj.req_port_cd.className="input";
//            comboObjects[6].Enable = true;
            formObj.req_eta_dt.readOnly=false;
            formObj.req_eta_dt.className="input";
            formObj.stv_dmg_respb_pty_kwn_flg[0].disabled=false;
            formObj.stv_dmg_respb_pty_kwn_flg[1].disabled=false;
            formObj.stv_dmg_respb_desc_dtl.readOnly=false;
            formObj.stv_dmg_respb_desc_dtl.className="input1";
            var thisRow=sheetObj.GetSelectRow();
            var prefix="sheet1_";
            if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="R"
            	|| sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="S")
            {
            	formObj.req_skd_voy_dir.readOnly=false;
    			formObj.req_port_cd.readOnly=false;
    			formObj.req_eta_dt.readOnly=false;
            	formObj.req_skd_voy_dir.className="input";
    			formObj.req_port_cd.className="input";
    			formObj.req_eta_dt.className="input";
//    			comboObjects[6].Enable = true;
    			comboObjects[5].SetSelectIndex("",false);
    			comboObjects[5].SetEnable(0);
    			formObj.req_reason_desc.value="";
    			formObj.req_reason_desc.readOnly=true;
    			formObj.req_reason_desc.className="input2";
            }
            else if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="Q")
            {
            	formObj.req_skd_voy_dir.value="";
    			formObj.req_port_cd.value="";
    			formObj.req_eta_dt.value="";
    			formObj.req_skd_voy_dir.readOnly=true;
    			formObj.req_port_cd.readOnly=true;
    			formObj.req_eta_dt.readOnly=true;
            	formObj.req_skd_voy_dir.className="input2";
    			formObj.req_port_cd.className="input2";
    			formObj.req_eta_dt.className="input2";
//    			comboObjects[6].Index2 = "";
//    			comboObjects[6].Enable = false;
    			comboObjects[5].SetEnable(1);
    			if(comboObjects[5].GetSelectCode()=="TXT"){
        			formObj.req_reason_desc.readOnly=false;
        			formObj.req_reason_desc.className="input1";
    			}
            }
			formObj.req_skd_voy_dir.value=sheetObj.GetCellValue(thisRow, prefix+"req_skd_voy_no") + sheetObj.GetCellValue(thisRow, prefix+"req_skd_dir_cd");
			formObj.req_port_cd.value=sheetObj.GetCellValue(thisRow, prefix+"req_port_cd");
//            comboObjects[6].Code2 = sheetObj.CellValue(thisRow, prefix+"req_port_cd");
			formObj.req_eta_dt.value=sheetObj.GetCellValue(thisRow, prefix+"req_eta_dt");
			if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_flg")=="Y"){
            	formObj.stv_dmg_respb_desc_dtl.readOnly=false;
            	formObj.stv_dmg_respb_desc_dtl.className="input1";
    			comboObjects[6].SetSelectIndex("",false);
    			comboObjects[6].SetEnable(0);
    			formObj.res_reason_desc.readOnly=true;
    			formObj.res_reason_desc.className="input2";
            }else{
            	formObj.stv_dmg_respb_desc_dtl.value="";
    			formObj.stv_dmg_respb_desc_dtl.readOnly=true;
            	formObj.stv_dmg_respb_desc_dtl.className="input2";
    			comboObjects[6].SetEnable(1);
    			if(comboObjects[6].GetSelectCode()=="TXT"){
        			formObj.res_reason_desc.readOnly=false;
        			formObj.res_reason_desc.className="input1";
    			}
            }
            formObj.stv_dmg_ref_no.focus();
            //ComSetFocus(formObj.stv_dmg_ref_no);
    	}
    }
    /**
     * input only english and number on onKeypress of HTML Control<br>
     **/
//    function engnum_keypress() {
//        if(event.srcElement.name=="skd_voy_no")
//        {
//        	//input only number
//        	ComKeyOnlyNumber(event.srcElement);
//        }
//        else if(//event.srcElement.name=="vsl_cd"|| 
//        		event.srcElement.name=="skd_dir_cd"
//        	    || event.srcElement.name=="clm_hndl_ofc_cd")
//        	    //|| event.srcElement.name=="req_port_cd")
//        {
//        	//input only capital
//        	ComKeyOnlyAlphabet('upper');
//        }
//        else{
//        	//capital & input only number
//            ComKeyOnlyAlphabet('uppernum');
//        }
//        if(event.keyCode==13 && (event.srcElement.name=="stv_dmg_no")){
//        	blur_event();
//        	ComKeyEnter();
//        }
//    }
    /**
     * in case of inputting Max Length of certain data, change focus . <br>
     **/
//    function obj_keyup() {
//       	// Focus change..
//       	ComKeyEnter('LengthNextFocus');
//    }
    /**
     * Input only number in onkeypress event of HTML Control <br>
     **/
//    function obj_keypress(){
//    	ComKeyOnlyNumber(event.srcElement);
//    }
    /**
     * delete mask separator in onfocus event of HTML Control <br>
     **/
    function obj_activate(){
    	if(event.srcElement.readOnly==false){
	        ComClearSeparator(event.srcElement);
	        event.srcElement.select();
    	}
    }
    /**
     *checking validation on onblur event of HTML Control<br>
     **/
    function obj_deactivate(){
    	var elementObj=event.srcElement;
    	var formObj=document.form;
    	var prefix="sheet1_";
    	if(elementObj.readOnly==false){
    		// year, month, date dataformat Validation Check!
        	if(!isNull(event.srcElement.value) 
        		&& !ComChkObjValid(event.srcElement))
        	{
        		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+elementObj.name,"");
        		event.srcElement.value="";
        		event.srcElement.focus();
        		//ComSetFocus(event.srcElement);
        		return false;
        	}
        	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+elementObj.name,elementObj.value);
        	if(elementObj.name=="fm_tm_lss_dt" || elementObj.name=="to_tm_lss_dt"){
        		if(isNull(formObj.fm_tm_lss_dt.value) || isNull(formObj.to_tm_lss_dt.value)){
        			formObj.time_loss_hours.value="";
         		}
        		else{
            		formObj.time_loss_hours.value=getDateHoursBetween(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
            	}
        	}
    	}
    }
    /**
     * setting block in case of set focus on Text Form Object <br>
     **/
    function focus_event() {
    	var elementObj=event.srcElement;
    	//ComSetFocus(elementObj);
    	if(elementObj.readOnly == false){
    		elementObj.select();
    	}
    }
    /**
     * in case of inputting, set data applicable on Hidden Grid <br>
     **/
    function change_event() {
    	var elementObj=event.srcElement;
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	var prefix="sheet1_";
    	if(elementObj.name=="vsl_cd"){
    		var vVsl_cd=formObj.vsl_cd.value;
    		/* Vsl validation check */

    		if (doActionIBSheet(sheetObj,formObj,COMMAND01,"VSL|MAIN")){ /* VSL CODE is valid */    		
	    		//if( sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) == "" ){
	    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
	    		//}else{
	    			doActionIBSheet(sheetObj,formObj,IBCLEAR);
	    		//}
	    		//sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
	    		formObj.vsl_cd.value=vVsl_cd;
	    		formObj.skd_voy_no.value="";
	    		formObj.skd_dir_cd.value="";
	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"skd_voy_no","");
	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"skd_dir_cd","");
	    		formObj.skd_voy_no.focus();
    		} else {
        			doActionIBSheet(sheetObj,formObj,IBCLEAR);
        			ComShowCodeMessage("OPF50004", vVsl_cd);
        			return false;
        		}
    	}
    	else if(elementObj.name=="skd_voy_no"){
    		var vVsl_cd=formObj.vsl_cd.value;
    		var vSkd_voy_no=formObj.skd_voy_no.value;
    		//if( sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) == "" ){
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
    		//}else{
    			doActionIBSheet(sheetObj,formObj,IBCLEAR);
    		//}
    		//sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    		formObj.vsl_cd.value=vVsl_cd;
    		formObj.skd_voy_no.value=vSkd_voy_no;
    		formObj.skd_dir_cd.value="";
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"skd_dir_cd","");
    		formObj.skd_dir_cd.focus();
    	}
    	else if(elementObj.name=="skd_dir_cd"){
    		/* VVD validation check */
    		var vVsl_cd=formObj.vsl_cd.value;
    		var vSkd_voy_no=formObj.skd_voy_no.value;
    		var vSkd_dir_cd=formObj.skd_dir_cd.value;    		
    		if (doActionIBSheet(sheetObj,formObj,COMMAND01,"VVD|MAIN")){ /* VSL CODE is valid */      		
    		//if( sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) == "" ){
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
    		//}else{
    			doActionIBSheet(sheetObj,formObj,IBCLEAR);
        		formObj.vsl_cd.value=vVsl_cd;
        		formObj.skd_voy_no.value=vSkd_voy_no;
        		formObj.skd_dir_cd.value=vSkd_dir_cd;
        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"vsl_cd",vVsl_cd);
        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"skd_voy_no",vSkd_voy_no);
        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"skd_dir_cd",vSkd_dir_cd);
        		// 2.get Lane Code 
        		setLaneCode(formObj, sheetObj);
        		
        		setPortCombo(sheetObj, formObj)
 	  	    	
    		//}    	
    		} /* end of vvd validation */ 
    		else {
    			doActionIBSheet(sheetObj,formObj,IBCLEAR);
    			ComShowCodeMessage("OPF50004", vVsl_cd+vSkd_voy_no+vSkd_dir_cd);
    			return false;
    		}
    	}else if(elementObj.name=="req_skd_voy_dir"){
    		if(!isNull(elementObj.value) && elementObj.value.length != elementObj.maxLength)
  			{
		    	ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
  				elementObj.focus();
  				return false;
  			}
		    else{
		    	if (doActionIBSheet(sheetObj,formObj,COMMAND01,"VVD|SUB")){ /* VSL CODE is valid */  
		    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"req_skd_voy_no",elementObj.value.substring(0,4));
		    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"req_skd_dir_cd",elementObj.value.substring(4));
		    		formObj.req_port_cd.focus();
		    	} else{
	    			ComShowCodeMessage("OPF50004", formObj.vsl_cd.value+elementObj.value);
	    			formObj.req_skd_voy_dir.value="";
		    		formObj.req_skd_voy_dir.focus();
	    			return false;		    		
		    	}
    		}
//    	}
//    	else if (elementObj.name=="vps_port_cd"){ /* vps_port_cd */
//    		var vpsPortCd=formObj.vps_port_cd.value ;
//    		if(doActionIBSheet(sheetObj,formObj,COMMAND01,"PORT|MAIN")){
//    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_vps_port_cd",vpsPortCd);
//    			//ETB date Default
//    			if (gVpsEtbEtdDt.length > 0){
//    				var vpsEtbEtdDt=gVpsEtbEtdDt.split("|");
//    				for (var i=0; i<vpsEtbEtdDt.length; i++){
//    					vpsEtbEtdDt[i]=vpsEtbEtdDt[i].split(",");
//    				}
//    				//formObj.stv_dmg_evnt_dt.value=vpsEtbEtdDt[0][0];
//    				formObj.stv_dmg_evnt_dt.value=transDateYMD(vpsEtbEtdDt[0][0]);
//    			}
//    			formObj.stv_dmg_evnt_dt.focus();
//    		} else {
//    			ComShowCodeMessage("OPF50004", vpsPortCd);
//    			formObj.vps_port_cd.value="";
//	    		formObj.vps_port_cd.focus();
//    		}
    	}else if (elementObj.name == "stv_dmg_evnt_dt"){//damage date
    		var evntDt=ComReplaceStr(formObj.stv_dmg_evnt_dt.value,'-','');
    		ComSetObjValue(formObj.stv_dmg_evnt_dt,  transDateYMD(evntDt)  );	//transDateYMD(evntDt) 
    		
//    		formObj.stv_dmg_evnt_dt.focus();
    		
//    		var evntDt=ComReplaceStr(formObj.stv_dmg_evnt_dt.value,-'-','');
//    		var bOK=true;
//    		if (gVpsEtbEtdDt.length > 0 && evntDt.length > 0){
//				var vpsEtbEtdDt=gVpsEtbEtdDt.split("|");
//				for (var i=0; i<vpsEtbEtdDt.length; i++){
//					vpsEtbEtdDt[i]=vpsEtbEtdDt[i].split(",");
//					if (ComChkPeriod(vpsEtbEtdDt[i][0], evntDt) >= 1 && ComChkPeriod(evntDt, vpsEtbEtdDt[i][1]) >= 1){
//						bOK=true;
//						break;
//					}else{
//						bOK=false;
//					}    				
//				}
//    		}
//    		if (!bOK){
//    			ComShowCodeMessage("OPF50027");
//    			formObj.stv_dmg_evnt_dt.value="";
//    			formObj.stv_dmg_evnt_dt.focus();
//    		}
    	}
    	else if (elementObj.name=="req_port_cd") {/* req_port_cd */
    		if (doActionIBSheet(sheetObj,formObj,COMMAND01,"PORT|SUB")){
	         		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_req_port_cd",elementObj.value);
	    			//doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "reqPortCd");
	    			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "etaDate");
    		} else {
    			ComShowCodeMessage("OPF50004", elementObj.value);
    			elementObj.value="";
    			document.form.req_port_cd.focus();
    		}
    	}   	
    	else if(elementObj.name=="stv_dmg_respb_desc_dtl")
    	{
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"stv_dmg_respb_desc",elementObj.value);
    	}
    	else if(elementObj.name=="stv_dmg_respb_desc")
    	{
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"stv_dmg_respb_desc",elementObj.value);
    	}
    	else if(elementObj.name=="stv_dmg_rpt_atch_flg"
    			|| elementObj.name=="stv_dmg_pict_atch_flg"
    			|| elementObj.name=="stv_dmg_doc_atch_flg")
    	{
    		if(elementObj.value > 0){
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,"Y");
    		}else{
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,"N");
    		}
    	}
    	else if(elementObj.name=="req_reason_desc"){
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_qttn_rsn_desc",elementObj.value);
    	}
    	else if(elementObj.name=="res_reason_desc"){
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_respb_desc",elementObj.value);
    	}
    	else{
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
    	}
    }
    /**
     * in case of clicking Radio button, set data applicableon hidden gird and change field editable. <br>
     **/
    function click_event() {
    	var formObj=document.form;
    	var elementObj=event.srcElement;
    	var prefix="sheet1_";
    	if(elementObj.name=="cntr_dmg_flg"
			|| elementObj.name=="cgo_dmg_flg")
    	{
    		var dataValue="N";
        	if(elementObj.checked){
        		dataValue="Y";
        	}
        	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+elementObj.name,dataValue);
    	}
    	else if(elementObj.name=="stv_dmg_req_cate_cd"){
    		if(elementObj.value=="Q"){
    			formObj.req_skd_voy_dir.value="";
    			formObj.req_port_cd.value="";
    			formObj.req_eta_dt.value="";
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"req_vsl_cd","");
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"req_skd_voy_no","");
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"req_skd_dir_cd","");
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"req_port_cd","");
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"req_eta_dt","");
    			formObj.req_skd_voy_dir.readOnly=true;
    			formObj.req_port_cd.readOnly=true;
    			formObj.req_eta_dt.readOnly=true;
    			formObj.req_skd_voy_dir.className="input2";
        		formObj.req_port_cd.className="input2";
        		formObj.req_eta_dt.className="input2";
//        		comboObjects[6].RemoveAll();
//        		comboObjects[6].Enable = false;
    			comboObjects[5].SetEnable(1);
    			if(comboObjects[5].GetSelectCode()=="TXT"){
    				formObj.req_reason_desc.readOnly=false;
        			formObj.req_reason_desc.className="input1";
    			}
    		}else{
    			formObj.req_skd_voy_dir.readOnly=false;
    			formObj.req_port_cd.readOnly=false;
    			formObj.req_eta_dt.readOnly=false;
        		formObj.req_skd_voy_dir.className="input";
        		formObj.req_port_cd.className="input";
        		formObj.req_eta_dt.className="input";
//        		comboObjects[6].Enable = true;
        		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"req_vsl_cd",formObj.vsl_cd.value);
    			formObj.stv_dmg_qttn_rsn_desc.value="";
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"stv_dmg_qttn_rsn_desc","");
    			comboObjects[5].SetSelectIndex("");
    			comboObjects[5].SetEnable(0);
    			formObj.req_reason_desc.readOnly=true;
    			formObj.req_reason_desc.className="input2";
    		}
        	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+elementObj.name,elementObj.value);
    	}
    	else if(elementObj.name=="stv_dmg_respb_pty_kwn_flg"){
    		if(elementObj.value=="Y"){
    			formObj.stv_dmg_respb_desc_dtl.readOnly=false;
    			formObj.stv_dmg_respb_desc_dtl.className="input1";
    			formObj.stv_dmg_respb_desc.value="";
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"stv_dmg_respb_desc","");
    			comboObjects[6].SetSelectIndex(-1);
    			comboObjects[6].SetEnable(0);
    			formObj.res_reason_desc.readOnly=true;
    			formObj.res_reason_desc.className="input2";
        		formObj.dmg_auth_sts_cd.className="input2";
				document.getElementById("btnApproval").style.color="#c0c0c0";
    			formObj.dmg_auth_sts_cd.value="X";
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"dmg_auth_sts_cd","X");
    			formObj.auth_dt.value="";
    			ComBtnDisable("btnApproval");
    		}
    		else{
    			formObj.stv_dmg_respb_desc_dtl.value="";
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"stv_dmg_respb_desc","");
    			formObj.stv_dmg_respb_desc_dtl.readOnly=true;
    			formObj.stv_dmg_respb_desc_dtl.className="input2";
    			comboObjects[6].SetEnable(1);
    			if(comboObjects[6].GetSelectCode()=="TXT"){
    				formObj.res_reason_desc.readOnly=false;
        			formObj.res_reason_desc.className="input1";
    			}
        		formObj.dmg_auth_sts_cd.className="input2_red";
				document.getElementById("btnApproval").style.color="red";
    			formObj.dmg_auth_sts_cd.value="N";
				sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+"dmg_auth_sts_cd","N");
				if(approvalFlag){
    				ComBtnEnable("btnApproval");
    			}
				else{
					ComBtnDisable("btnApproval");
				}
    		}
        	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), prefix+elementObj.name,elementObj.value);
    	}
    }
    /**
     * ymd 포맷 '-' 변환
     */
	function transDateYMD(pYmd){
        var year  = pYmd.substring(0,4);
        var month = pYmd.substring(4,6);
        var day   = pYmd.substring(6,8);
        
        var rslt = "";
        if(pYmd.length == 8){
        	rslt = year+'-'+month+'-'+day;
        }else{
        	rslt = year+month+day;
        }
        
        return rslt;
	}
	
    /**
     * get ETA data in case of selecting req_port_cd Combo Data <br>
     **/
    function req_port_cd_OnChange(comboObj, idx_cd, text) {
     	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_req_port_cd",comboObj.GetSelectCode());
    	if(!isNull(comboObj.GetSelectCode())){
			//doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "reqPortCd");
			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "etaDate");
		}
    	document.form.req_port_cd.focus();
    }
    /**
     * set data applicable on Hidden Grid in case of selecting vps_port_cd Combo Data. <br>
     **/
//    function vps_port_cd_OnChange(comboObj, idx_cd, text) {
//    	var formObj=document.form;
//    	var sheetObj=sheetObjects[0];
//    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_vps_port_cd",comboObj.GetSelectCode());
//    }
    /**
     * set data applicable on Part Combo List in case of selecting Category Combo Data <br>
     **/
    function stv_dmg_prt_cate_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//    	stv_dmg_prt_cate_cd_text.value = newCode;
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_prt_cate_cd",comboObj.GetSelectCode());
    	
    	if(!isNull(comboObj.GetSelectCode())){
	    	formObj.f_cmd.value=SEARCH03;
	    	var categoryPartXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do" , FormQueryString(formObj));
	    	var categoryPart=ComGetEtcData(categoryPartXml, "catePart");
	    	if(categoryPart==null || categoryPart.length<1){
	    		//ComShowMessage("Part Code not exist.");
    			ComShowCodeMessage("OPF50009", "Part Code");
	    		comboObjects[3].RemoveAll();
	    		return false;
	    	}else{
	    		setComboItem2(comboObjects[3], categoryPart);
	    		formObj.stv_dmg_prt_cate_cd.focus();
	    		//ComSetFocus(formObj.stv_dmg_prt_cate_cd);
	    	}
    	}else{
    		comboObjects[3].RemoveAll();
    		formObj.stv_dmg_prt_cate_cd.focus();
    		//ComSetFocus(formObj.stv_dmg_prt_cate_cd);
    	}
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_prt_cd","");
		comboObjects[3].SetEnable(1);
    }
    /**
     *set data applicable on Damage Combo List in case of selecting Part Combo Data <br>
     **/
    function stv_dmg_prt_cd_OnBlur(comboObj, idx_cd, text) {
    	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_stv_dmg_prt_cd",comboObj.GetSelectCode());
    }
    /**
     * set data applicable on Hidden Grid in case of selecting Damage Combo Data <br>
     **/
    function stv_dmg_tp_cd_OnChange(comboObj, idx_cd, text) {
    	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_stv_dmg_tp_cd",comboObj.GetSelectCode());
    	document.form.stv_dmg_tp_cd.focus();
    	//ComSetFocus(document.form.stv_dmg_tp_cd);
    }
    /**
     * set data applicable on Hidden Grid in case of selecting Combo Data <br>
     **/
    function stv_dmg_qttn_rsn_desc_OnChange(comboObj, idx_cd, text) {
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_qttn_cate_cd") = comboObj.GetText(comboObj.Code, 0);
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_qttn_cd",comboObj.GetText(comboObj.GetSelectCode(), 0));
    	if(comboObj.GetSelectCode()=="TXT"){
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_qttn_rsn_desc","");
    		formObj.req_reason_desc.value="";
    		formObj.req_reason_desc.className="input1";
    		formObj.req_reason_desc.readOnly=false;
    		formObj.req_reason_desc.focus();
    	}
    	else{
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_qttn_rsn_desc",comboObj.GetText(comboObj.GetSelectCode(), 1));
    		
        	if(comboObj.GetSelectCode()==""){
        		formObj.req_reason_desc.value="";
        	}else{
        		formObj.req_reason_desc.value=comboObj.GetText(comboObj.GetSelectCode(), 1);
        	}
        	
    		formObj.req_reason_desc.className="input2";
    		formObj.req_reason_desc.readOnly=true;
        	formObj.stv_dmg_qttn_rsn_desc.focus();
    	}
    }
    /**
     * set data applicable on Hidden Grid in case of selecting Combo Data <br>
     **/
    function stv_dmg_respb_desc_OnChange(comboObj, idx_cd, text) {
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_cate_cd") = comboObj.GetText(comboObj.Code, 0);
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_respb_cd",comboObj.GetText(comboObj.GetSelectCode(), 0));
    	if(comboObj.GetSelectCode()=="TXT"){
        	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_respb_desc","");
    		formObj.res_reason_desc.value="";
    		formObj.res_reason_desc.className="input1";
    		formObj.res_reason_desc.readOnly=false;
    		formObj.res_reason_desc.focus();
    	}
    	else{
        	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_respb_desc",comboObj.GetText(comboObj.GetSelectCode(), 1));
        	if(comboObj.GetSelectCode()==""){
        		formObj.res_reason_desc.value="";
        	}else{
        		formObj.res_reason_desc.value=comboObj.GetText(comboObj.GetSelectCode(), 1);
        	}
    		
    		formObj.res_reason_desc.className="input2";
    		formObj.res_reason_desc.readOnly=true;
        	formObj.stv_dmg_respb_desc.focus();
    	}
    }
    /**
     * in case of inputting, set data applicable on Hidden Grid <br>
     **/
    function blur_event() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var elementObj=event.srcElement;
    	var prefix="sheet1_";
    	if(elementObj.readOnly==false){
//        		formObj.stv_dmg_no.value = sdms01 + sdms02;
        		if(elementObj.name=="stv_dmg_no"){
        			//ComSetFocus(formObj.stv_dmg_ref_no);
        			formObj.stv_dmg_ref_no.focus();
        		}
        	else if(elementObj.name=="clm_hndl_ofc_cd"){
   				sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
        	}
        	elementObj.value=elementObj.value;
    	}
    }
    /**
     * Popup Data Validation Check. <br>
     **/
    function clm_hndl_ofc_cd_pop_event(aryPopupData) {
    	document.form.clm_hndl_ofc_cd.value=aryPopupData[0][3];
    	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_clm_hndl_ofc_cd",aryPopupData[0][3]);
    }
    /**
  	 * Setting data received from VSL Code Help (Pop-Up)<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setCallBackVSL(aryPopupData) {
		document.form.vsl_cd.value=aryPopupData[0][1];
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_vsl_cd",aryPopupData[0][1]);
		document.form.skd_voy_no.focus();
		//ComSetFocus(document.form.skd_voy_no);
  	} 
    /**
  	 * setting data received from VVD Code Hepl(Pop-Up)<br>
  	 * @param {arry} obj
  	 */
  	function setCallBackVVD(aryPopupData) {
  		var formObj=document.form;
  		var sheetObj = sheetObjects[0];
  		
		document.form.skd_voy_no.value=aryPopupData[0][2];
		document.form.skd_dir_cd.value=aryPopupData[0][3];
		document.form.slan_cd.value=aryPopupData[0][5];
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_vsl_cd",aryPopupData[0][1]);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_skd_voy_no",aryPopupData[0][2]);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_skd_dir_cd",aryPopupData[0][3]);
		//document.form.vps_port_cd.focus();
		//ComSetFocus(document.form.vps_port_cd);
//		setVVDPortCombo(sheetObjects[0], document.form, "Vsl", true);
		
		
		// 2.get Lane Code 
		setLaneCode(formObj, sheetObj);
		
		setPortCombo(sheetObj, formObj)
  	}
  	/**
   	 * setting data received from VVD Code Hepl(Pop-Up)<br>
   	 * @param {arry} obj
   	 */
   	function req_skd_voy_dir_pop_event(aryPopupData) {
 		document.form.req_skd_voy_dir.value=aryPopupData[0][2]+aryPopupData[0][3];
 		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_req_vsl_cd",aryPopupData[0][1]);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_req_skd_voy_no",aryPopupData[0][2]);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_req_skd_dir_cd",aryPopupData[0][3]);
 		document.form.req_port_cd.focus();
 		//ComSetFocus(document.form.req_port_cd);
//		setVVDPortCombo(sheetObjects[0], document.form, "Voy", true);
   	}
  	/**
     * retrieve VVD info
     */
    function searchVVDInfo() {
    	var formObj=document.form;
    	formObj.f_cmd.value=SEARCH05;
 	   	var sXml=sheetObjects[0].GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
    }
    /**
	 * add files chosen to upload on pop-up IBSheet to IBUpload
	 * File Upload..
	 **/
	function setFileUpload(stvDmgAtchFileTpCd, stvDmgProcCd) {
		var formObj=document.form;
		var uploadObj=uploadObjects[0];
		var sheetObj;
		var prefix;
		var stvDmgAtchFlg="";
		if(stvDmgAtchFileTpCd == "SDR"){
			sheetObj=sheetObjects[1];
			prefix="sheet2_";
			stvDmgAtchFlg="stv_dmg_rpt_atch";
		}else if(stvDmgAtchFileTpCd == "PIC"){
			sheetObj=sheetObjects[2];
			prefix="sheet3_";
			stvDmgAtchFlg="stv_dmg_pict_atch";
		}else if(stvDmgAtchFileTpCd == "DOC"){
			sheetObj=sheetObjects[3];
			prefix="sheet4_";
			stvDmgAtchFlg="stv_dmg_doc_atch";
		}
//		if(popSheetObj.RowCount()> 0 ){
//			for(var j=popSheetObj.HeaderRows(); j<=popSheetObj.LastRow(); j++ ){
//				var addRow=sheetObj.DataInsert(-1);
//				for(var cnt=0 ; cnt < 12 ; cnt++){
//					sheetObj.SetCellValue(addRow, cnt,popSheetObj.GetCellValue(j, cnt));
//				}
//			}
//		}
		var file_cnt=0;
		
		for(var rowIdx=1 ; rowIdx <= sheetObj.LastRow()-sheetObj.HeaderRows(); rowIdx++){
			if(sheetObj.GetCellValue(rowIdx, prefix+"file_sav_id") != ""){
				file_cnt++;
			}
		}
		
		//formObj.stv_dmg_rpt_atch_flg.value = file_cnt;
		//eval("formObj."+stvDmgAtchFlg+"_flg").value=file_cnt;
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_"+stvDmgAtchFlg+"_knt",file_cnt);
		if(file_cnt > 0){
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"sheet1_"+stvDmgAtchFlg+"_flg","Y");
		}else{
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_"+stvDmgAtchFlg+"_flg","N");
		}
		// Filed Style Set.
		if(file_cnt > 0){
			eval("formObj."+stvDmgAtchFlg+"_flg").className="input3"
    	}else{
    		eval("formObj."+stvDmgAtchFlg+"_flg").className="input"
    	}
		return; 
	}
    /**
	 * add files chosen to upload on pop-up IBSheet to IBUpload
	 * SDR File Upload..
	 **/
	function setFileUpload_1(popSheetObj) {
		var formObj=document.form;
		var sheetObj=sheetObjects[1];
		var uploadObj=uploadObjects[0];
		var prefix="sheet2_";
		if(popSheetObj.RowCount()> 0 ){
			if(sheetObj.RowCount()> 0){
				for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++ ){
					if(sheetObj.GetCellValue(i, prefix+"stv_dmg_no") == popSheetObj.GetCellValue(1, "stv_dmg_no")){
						sheetObj.RowDelete(i, false);
					}
				}
			}
			for(var j=popSheetObj.HeaderRows(); j<=popSheetObj.LastRow(); j++ ){
				var addRow=sheetObj.DataInsert(-1);
				for(var cnt=0 ; cnt < 12 ; cnt++){
					sheetObj.SetCellValue(addRow, cnt,popSheetObj.GetCellValue(j, cnt));
				}
			}
		}
		var file_cnt=0;
		for (var rowIdx=1; rowIdx<=popSheetObj.LastRow(); rowIdx++){
			var delFlag=popSheetObj.GetCellValue(rowIdx, "deleteFlag");
			var ibFlag=popSheetObj.GetRowStatus(rowIdx);
			var sFile=popSheetObj.GetCellValue(rowIdx, "file_nm");
			if (sFile==""){
    			ComShowCodeMessage("OPF50009", "File name");
    		}
			if(delFlag == 'Y'){
				with(sheetObj){
					if(GetRowStatus(rowIdx)=="I"){
						var sFile=GetCellValue(rowIdx, "file_nm");
		        		uploadObjects[0].DeleteFile(sFile);
		    			SetRowStatus(rowIdx,"D");
		    		}
		    		else{
		    			if(GetRowStatus(rowIdx)=="U"){
		    				var sFile=GetCellValue(rowIdx, "file_nm");
		            		uploadObjects[0].DeleteFile(sFile);
		    			}
		    			SetRowStatus(rowIdx,"D");
		    		}
		    	}
			}
			else{
				if(ibFlag=='I' || ibFlag=='U'){
					var ret=uploadObj.AddFile(sFile);
				}
				file_cnt++;
			}
		}
		formObj.stv_dmg_rpt_atch_flg.value=file_cnt;
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_sdr_cnt",file_cnt);
		if(file_cnt > 0){
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"sheet1_stv_dmg_rpt_atch_flg","Y");
		}else{
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_stv_dmg_rpt_atch_flg","N");
		}
		// Filed Style Set.
		if(file_cnt > 0){
    		formObj.stv_dmg_rpt_atch_flg.className="input3"
    	}else{
    		formObj.stv_dmg_rpt_atch_flg.className="input"
    	}
		return; 
	}
	/**
	 * get Hidden IBSheet Info for uploading.
	 **/
	function getFileUpload(strFlag, stvDmgProcCd) {
		if(strFlag=="SDR"){
			return sheetObjects[1];
		}
		else if(strFlag=="PIC"){
			return sheetObjects[2];
		}
		else if(strFlag=="DOC"){
			return sheetObjects[3];
		}
	}
	/**
     * in case of inputting VVD Code Data , Lane Code Set. <br>
     **/
    function setLaneCode(formObj, sheetObj) {
    	formObj.f_cmd.value=SEARCH02;
    	var laneXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do" , FormQueryString(formObj));
    	var strLaneCode=ComGetEtcData(laneXml, "laneCode");
    	if(isNull(strLaneCode)){
			//ComShowCodeMessage("OPF07004");
    		formObj.slan_cd.value="";
    		formObj.slan_cd.focus();
    		return true;
    	}else{
    		formObj.slan_cd.value=strLaneCode;
    		//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_slan_cd") = strLaneCode;
    	}
    	//formObj.vps_port_cd.focus();
    	//ComSetFocus(formObj.vps_port_cd);
    }
    
    function setPortCombo(sheetObj, formObj) {
    
    	var sParam=Array();
	  	sParam[0]="vsl_cd="+ComGetObjValue(document.form.vsl_cd);
	  	sParam[1]="skd_voy_no="+ComGetObjValue(document.form.skd_voy_no);
	  	sParam[2]="skd_dir_cd="+ComGetObjValue(document.form.skd_dir_cd);
	  	sParam[3]="f_cmd="+SEARCH10;
	  	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	  	comboObjects[0].RemoveAll();
		var arrCombo=ComXml2ComboString(sXml, "loc_cd", "loc_nm");
    	if(arrCombo != null && arrCombo.length > 0) {
    		var loc_cds=ComScgXml2Array(sXml, "loc_cd");
    		var loc_nms=ComScgXml2Array(sXml, "loc_nm");
    		var clptIndSeqs=ComScgXml2Array(sXml, "clpt_ind_seq");
    		var turnPortIndCds=ComScgXml2Array(sXml, "turn_port_ind_cd");
    		var skdCngStsCd=ComScgXml2Array(sXml, "skd_cng_sts_cd");
    		var vtAddCallFlg=ComScgXml2Array(sXml, "vt_add_call_flg"); 
    		var newPolIdx=0;
    		
    		for(var arrIdx=0; arrIdx<loc_cds.length; arrIdx++) {
    			if(loc_cds[arrIdx] != null && loc_cds[arrIdx] != '' && vtAddCallFlg[arrIdx] != 'Y') {
	    			if(turnPortIndCds[arrIdx] != 'D' && turnPortIndCds[arrIdx] != 'V' && turnPortIndCds[arrIdx] != 'F') { 	  		    				
	    				comboObjects[0].InsertItem(newPolIdx++
	    						, loc_cds[arrIdx]+"|"+ loc_nms[arrIdx] + "|" + portInfo(arrIdx, skdCngStsCd[arrIdx], loc_cds[arrIdx])
//		    						, loc_cds[arrIdx]+""+clptIndSeqs[arrIdx]);
	    						, loc_cds[arrIdx]);
	    			}
    			}
    		}
    		//ComSetFocus(vps_port_cd);
    	} else {
    		comboObjects[0].RemoveAll();
    	}
    }
    /**
     * in case of inputting VVD Code Data , VVD Port Combo Data Set. <br>
     **/
    function setVVDPortCombo(sheetObj, formObj, gubun, isUpdate) {
    	var prefix="sheet1_";
    	var comboObj=null;
    	if(gubun=="Vsl"){
//    		comboObj = comboObjects[1];
    		//formObj.slan_cd.value = "";    		
    	}
    	else if(gubun=="Voy"){
    		comboObj=comboObjects[5];
    	}
    	formObj.f_cmd.value=SEARCH01;
    	var portXml=null;
    	if(gubun=="Vsl"){
    		portXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq" , FormQueryString(formObj));
    	}
    	else if(gubun=="Voy"){
    		var voyNo=formObj.req_skd_voy_dir.value.substring(0,4);
    		var dirCd=formObj.req_skd_voy_dir.value.substring(4);
    		portXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq&skd_voy_no="+voyNo+"&skd_dir_cd="+dirCd , FormQueryString(formObj));
    	}
    	var strPortCdList=ComGetEtcData(portXml, "vvdPortComboList");
		if(gubun=="Vsl"){
			if(isUpdate){
    	    	comboObj.SetSelectIndex("-1");
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"vps_port_cd","");
			}
    		setComboItem(comboObj,strPortCdList);
    		formObj.vps_port_cd.focus();
    		//ComSetFocus(formObj.vps_port_cd);
		}
		else if(gubun=="Voy"){
			if(isUpdate){
    	    	comboObj.SetSelectIndex("-1");
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"req_port_cd","");
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"req_eta_dt","");
    			formObj.req_eta_dt.value="";
			}
    		setComboItem(comboObj,strPortCdList);
    		formObj.req_port_cd.focus();
    		//ComSetFocus(formObj.req_port_cd);
		}
    	return true;
    }
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(sheetObj, formObj) {
    	var categoryXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do" , FormQueryString(formObj));
    	//Category Combo List Set..
    	var vslCateCode=ComGetEtcData(categoryXml, "vslCategory");
    	setComboItem(comboObjects[1], vslCateCode);
    	//Category Combo List Set..
    	var categoryCode=ComGetEtcData(categoryXml, "categoryCode");
    	setComboItem(comboObjects[2], categoryCode);
    	//Damage Combo List Set..
    	var damageCode=ComGetEtcData(categoryXml, "damageCode");
    	setComboItem2(comboObjects[4], damageCode);
    	// Requirement - Damage Reason Combo List.
    	var reqReasonCode=ComGetEtcData(categoryXml, "reqReasonCode");
    	setComboItem3(comboObjects[5], reqReasonCode);
    	// Responsible - Damage Reason Combo List.
    	var resReasonCode=ComGetEtcData(categoryXml, "resReasonCode");
    	setComboItem3(comboObjects[6], resReasonCode);
		//Approval permission Set..		
      	if(ComGetEtcData(categoryXml, "approvalPermission")=="1"){
			approvalCheck="1";
		}else{
//			approvalCheck="";
			approvalCheck="1"; //임시적으로 풀어준다. 
		}		
    }
    /**
     * adding data on combo field
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList=comboItems.split("|");
    	for (var i=0 ; i < dataList.length ; i++) {
    		var comboItem=dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
    	}
    }
    /**
     * adding data on combo field
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList=comboItems.split("|");
    	for (var i=0 ; i < dataList.length ; i++) {
    		var comboItem=dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
    	}
    }
    /**
     * adding data on combo field
     */	
    function setComboItem3(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList=comboItems.split("|");
    	for (var i=0 ; i < dataList.length ; i++) {
    		var comboItem=dataList[i].split(",");
    		//comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[1]);
    		comboObj.InsertItem(i, comboItem[1]+"|"+comboItem[2], comboItem[1]);
    	}
    }
    /**
     * initialize IBSheet Grid 
     */
    function initDefaultSheet(sheetObj, formObj, firstFlag){
    	var prefix="sheet1_";
    	var sdmsNo="";
    	if(firstFlag=="A"){
    		var beforeNo=sheetObj.GetCellValue(sheetObj.LastRow(), prefix+"stv_dmg_no");
        	if(!isNull(beforeNo)){
        		var newSeq=(parseInt(beforeNo.substring(9,11))+1)+"";
        		if(newSeq.length==1){
        			newSeq="0"+newSeq;
        		}
        		sdmsNo=beforeNo.substring(0,9) + newSeq;
        	}
    	}else{
    		sheetObj.RemoveAll();
    		sheetObjects[1].RemoveAll();
    		sheetObjects[2].RemoveAll();
    		sheetObjects[3].RemoveAll();
    	}
    	var row=sheetObj.DataInsert(-1);
    	sheetObj.SetCellValue(row, prefix+"stv_dmg_no",sdmsNo);
    	sheetObj.SetCellValue(row, prefix+"cntr_dmg_flg","N");
    	sheetObj.SetCellValue(row, prefix+"cgo_dmg_flg","N");
    	sheetObj.SetCellValue(row, prefix+"stv_dmg_req_cate_cd","R");
    	sheetObj.SetCellValue(row, prefix+"stv_dmg_respb_pty_kwn_flg","Y");
    	sheetObj.SetCellValue(row, prefix+"stv_dmg_rpt_atch_flg","N");
    	sheetObj.SetCellValue(row, prefix+"stv_dmg_pict_atch_flg","N");
    	sheetObj.SetCellValue(row, prefix+"stv_dmg_doc_atch_flg","N");
    	sheetObj.SetCellValue(row, prefix+"dmg_auth_sts_cd","X");
    	sheetObj.SetCellValue(row, prefix+"auth_usr_id",formObj.auth_usr_id.value);
		sheetObj.SetCellValue(row, prefix+"auth_dt",formObj.auth_dt.value);
		sheetObj.SetCellValue(row, prefix+"stv_dmg_rpt_atch_knt","0");
		sheetObj.SetCellValue(row, prefix+"stv_dmg_pict_atch_knt","0");
		sheetObj.SetCellValue(row, prefix+"stv_dmg_doc_atch_knt","0");
    	comboObjects[5].SetEnable(0);
    	comboObjects[6].SetEnable(0);
    	formObj.req_reason_desc.readOnly=true;
		formObj.req_reason_desc.className="input2";
    	formObj.res_reason_desc.readOnly=true;
		formObj.res_reason_desc.className="input2";
    	if(firstFlag=="Y"){
    		// Default Combo Data Set!!
    		setDefaultComboData(sheetObj, formObj);
        	formObj.vsl_cd.focus();
        	//ComSetFocus(formObj.vsl_cd);
    	}
    	else if(firstFlag=="A"){
    		sheetObj.SetCellValue(row, prefix+"vsl_cd",formObj.vsl_cd.value);
    		sheetObj.SetCellValue(row, prefix+"skd_voy_no",formObj.skd_voy_no.value);
    		sheetObj.SetCellValue(row, prefix+"skd_dir_cd",formObj.skd_dir_cd.value);
//    		sheetObj.CellValue(row, prefix+"vps_port_cd") = comboObjects[1].Code;
    		//sheetObj.SetCellValue(row, prefix+"vps_port_cd",formObj.vps_port_cd.value);
    		sheetObj.SetCellValue(row, prefix+"vps_port_cd",comboObjects[0].GetSelectCode());
    		sheetObj.SetCellValue(row, prefix+"stv_dmg_evnt_dt",formObj.stv_dmg_evnt_dt.value);
    		//sheetObj.CellValue(row, prefix+"slan_cd") = formObj.slan_cd.value;
    		sheetObj.SetCellValue(row, prefix+"vsl_oshp_cntr_blk_tp_cd",comboObjects[1].GetSelectCode());
    		//sheetObj.CellValue(row, prefix+"req_vsl_cd") = formObj.vsl_cd.value;
    	}
    	if(isNull(comboObjects[2].GetSelectCode())){
        	comboObjects[3].SetEnable(0);
        }else{
        	comboObjects[3].SetEnable(1);
        }
    	setDisplaySeq(formObj, sheetObj);
    	setSubButton();
    }
    /**
     * Display Sequence Set. <br>
     */
    function setDisplaySeq(formObj, sheetObj){
    	formObj.seq.value=sheetObj.GetSelectRow();
    	formObj.seq_total.value=sheetObj.RowCount();
    }
    /**
     * initialize data value <br>
     */
    function dataClear(formObj, strFlag){
    	if(strFlag != "add"){
    		formObj.vsl_cd.value="";
    		formObj.skd_voy_no.value="";
    		formObj.skd_dir_cd.value="";
    		formObj.stv_dmg_evnt_dt.value="";    		
    		formObj.slan_cd.value="";
        	//initialize Port Combo 
    		//formObj.vps_port_cd.value="";
    		comboObjects[0].RemoveAll();
//        	comboObjects[1].RemoveAll();
        	comboObjects[1].SetSelectIndex("",true);
        	formObj.stv_dmg_no.value="";
//        	formObj.sdms_no_1.value="";
//        	formObj.sdms_no_2.value="";
    	}
    	//initialize Category Part Combo 
    	comboObjects[3].RemoveAll();
    	comboObjects[3].SetEnable(0);
    	formObj.stv_dmg_ref_no.value="";
    	formObj.clm_hndl_ofc_cd.value="";
    	comboObjects[2].SetSelectIndex("",false);
    	comboObjects[4].SetSelectIndex("",false);
    	formObj.stv_dmg_loc_desc.value="";
    	formObj.stv_dmg_rpt_atch_flg.value="0";
    	formObj.stv_dmg_pict_atch_flg.value="0";
    	formObj.stv_dmg_doc_atch_flg.value="0";
    	formObj.cntr_dmg_flg.checked=false;
    	formObj.cgo_dmg_flg.checked=false;
    	formObj.cntr_no.value="";
    	formObj.time_loss_hours.value="";
    	formObj.fm_tm_lss_dt.value="";
    	formObj.to_tm_lss_dt.value="";
    	formObj.stv_dmg_rmk.value="";
    	formObj.stv_dmg_req_cate_cd[0].checked=true;
    	formObj.req_skd_voy_dir.value="";
    	formObj.req_port_cd.value="";
//    	comboObjects[6].RemoveAll();
    	formObj.req_eta_dt.value="";
    	formObj.req_skd_voy_dir.readOnly=false;
    	formObj.req_port_cd.readOnly=false;
    	formObj.req_eta_dt.readOnly=false;
    	formObj.req_skd_voy_dir.className="input";
    	formObj.req_port_cd.className="input";
    	formObj.req_eta_dt.className="input";
    	comboObjects[5].SetSelectIndex("",false);
    	formObj.req_reason_desc.value="";
		formObj.stv_dmg_respb_pty_kwn_flg[0].checked=true;
		formObj.stv_dmg_respb_desc_dtl.value="";
		formObj.stv_dmg_respb_desc_dtl.readOnly=false;
		formObj.stv_dmg_respb_desc_dtl.className="input1";
		comboObjects[6].SetSelectIndex("",false);
		formObj.res_reason_desc.value="";
		formObj.dmg_auth_sts_cd.value="";
		formObj.auth_usr_id.value="";
		formObj.auth_dt.value="";
		initApprovalPermission(sheetObjects[0], formObj);
    }
    /**
      * set File number and style 
      */
    function setFileField(formObj){
    	var arrowCnt = 0;
    	
    	if(sheetObjects[1].RowCount()> 0){
    		arrowCnt = 0;
    		var sRow = sheetObjects[1].FindStatusRow("R|I|U");
    		arrowCnt = setRowSplit(sRow);
    		formObj.stv_dmg_rpt_atch_flg.value=arrowCnt;
    		formObj.stv_dmg_rpt_atch_flg.className="input3"
    	}else{
    		formObj.stv_dmg_rpt_atch_flg.value=0;
    		formObj.stv_dmg_rpt_atch_flg.className="input"
    	}
    	if(sheetObjects[2].RowCount()> 0){
    		arrowCnt = 0;
			var sRow = sheetObjects[2].FindStatusRow("R|I|U");
			arrowCnt = setRowSplit(sRow);
    		formObj.stv_dmg_pict_atch_flg.value=arrowCnt;
    		formObj.stv_dmg_pict_atch_flg.className="input3"
    	}else{
    		formObj.stv_dmg_pict_atch_flg.value=0;
    		formObj.stv_dmg_pict_atch_flg.className="input"
    	}
    	if(sheetObjects[3].RowCount()> 0){
    		arrowCnt = 0;
			var sRow = sheetObjects[3].FindStatusRow("R|I|U");
			arrowCnt = setRowSplit(sRow);
    		formObj.stv_dmg_doc_atch_flg.value=arrowCnt;
    		formObj.stv_dmg_doc_atch_flg.className="input3"
    	}else{
    		formObj.stv_dmg_doc_atch_flg.value=0;
    		formObj.stv_dmg_doc_atch_flg.className="input"
    	}
    }

	 /**
     * set Row Split
     */
	  function setRowSplit(sRow){
		    var  arrowCnt = 0;
		    var arrow = sRow.split(";");
	   		    arrowCnt = arrow.length;
				
	   		if(arrow[0] == ""){
	   			arrowCnt = 0;
	   		}
	   	    return arrowCnt;
	  } 	   
    
     /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
		             var HeadTitle="|Seq|STV_DMG_NO|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VPS_PORT_CD|STV_DMG_EVNT_DT|VSL_OSHP_CNTR_BLK_TP_CD|STV_DMG_REF_NO|";
		             HeadTitle += "CLM_HNDL_OFC_CD|STV_DMG_PRT_CATE_CD|STV_DMG_PRT_CD|STEVEDORE DAMAGE TYPE CODE|STV_DMG_LOC_DESC|STV_DMG_RPT_ATCH_FLG|";
		             HeadTitle += "STV_DMG_PICT_ATCH_FLG|STV_DMG_DOC_ATCH_FLG|CNTR_DMG_FLG|CGO_DMG_FLG|CNTR_NO|FM_TM_LSS_DT|TO_TM_LSS_DT|STV_DMG_RMK|";
		             HeadTitle += "STV_DMG_REQ_CATE_CD|REQ_VSL_CD|REQ_SKD_VOY_NO|REQ_SKD_DIR_CD|REQ_PORT_CD|REQ_ETA_DT|STV_DMG_QTTN_CD|STV_DMG_QTTN_RSN_DESC|";
		             HeadTitle += "STV_DMG_RESPB_PTY_KWN_FLG|STV_DMG_RESPB_CD|STV_DMG_RESPB_DESC|DMG_AUTH_STS_CD|cre_usr_id|cre_usr_ofc|AUTH_USR_ID|AUTH_DT|step_cnt|";
		             HeadTitle += "stv_dmg_rpt_atch_knt|stv_dmg_pict_atch_knt|stv_dmg_doc_atch_knt"
		             var headCount=ComCountHeadTitle(HeadTitle);
		             var prefix="sheet1_";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"skd_voy_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"skd_dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vps_port_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_evnt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_oshp_cntr_blk_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"clm_hndl_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_prt_cate_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_prt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_loc_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_rpt_atch_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_pict_atch_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_doc_atch_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_dmg_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cgo_dmg_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"fm_tm_lss_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"to_tm_lss_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_req_cate_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"req_vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"req_skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"req_skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"req_port_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"req_eta_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_qttn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_qttn_rsn_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_respb_pty_kwn_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_respb_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_respb_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"dmg_auth_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cre_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cre_usr_ofc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"auth_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"auth_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"step_cnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_rpt_atch_knt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_pict_atch_knt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_doc_atch_knt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(150);
                   }
                break;
            case "sheet2":
                with(sheetObj){
		              var HeadTitle="||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="sheet2_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"strSeq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_atch_file_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"PopupEdit", Hidden:0,  Width:230,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_sav_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_proc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_atch_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"deleteFlag",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_serial",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetShowButtonImage(2);
		              SetFocusAfterProcess(0);
		              SetWaitImageVisible(0);
		              SetVisible(false);
		              SetSheetHeight(162);
                    }
                break;
            case "sheet3":
                with(sheetObj){
		             var HeadTitle="||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
		             var headCount=ComCountHeadTitle(HeadTitle);
		             var prefix="sheet3_";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                 {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"strSeq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_atch_file_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"PopupEdit", Hidden:0,  Width:230,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_sav_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_proc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_atch_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"deleteFlag",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             	 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_serial",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		             
		             InitColumns(cols);
		             SetEditable(1);
		             SetShowButtonImage(2);
		             SetFocusAfterProcess(0);
		             SetWaitImageVisible(0);
		             SetVisible(false);
		             SetSheetHeight(162);
                }
                break;
            case "sheet4":
                with(sheetObj){
		             var HeadTitle="||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
		             var headCount=ComCountHeadTitle(HeadTitle);
		             var prefix="sheet4_";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                 {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"strSeq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_atch_file_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"PopupEdit", Hidden:0,  Width:230,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_sav_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_proc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_atch_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"deleteFlag",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_serial",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetShowButtonImage(2);
		             SetFocusAfterProcess(0);
		             SetWaitImageVisible(0);
		             SetVisible(false);
		             SetSheetHeight(162);
                    }
                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction, strFlag) {
  	  sheetObj.ShowDebugMsg(false);
  	    switch(sAction) {
  	    case IBCLEAR:
  	    	sheetObj.RemoveAll();
  	    	sheetObjects[1].RemoveAll();
  	    	sheetObjects[2].RemoveAll();
  	    	sheetObjects[3].RemoveAll();
  	    	initDefaultSheet(sheetObj, formObj);
  	    	dataClear(formObj);
  	    	setScreenreadOnly(false, formObj, sheetObj);
  	    	//formObj.vsl_cd.focus();
  	    	//ComSetFocus(comboObjects[0]);
  	    	break;
  	    case IBSEARCH:      //Retrieve
            formObj.f_cmd.value=SEARCH;
            sheetObj.RemoveAll();
  	    	sheetObjects[1].RemoveAll();
  	    	sheetObjects[2].RemoveAll();
  	    	sheetObjects[3].RemoveAll();
  	    	//uploadObjects[0].Files=""; 
  	    	sheetObj.DoSearch("VOP_OPF_0052GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
			var sXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
 			sheetObj.LoadSearchData(sXml,{Sync:1} );
  	    	if(sheetObj.RowCount()==0)
  	        {
  	        	initDefaultSheet(sheetObj, formObj);
  	        	dataClear(formObj);
  	        	setScreenreadOnly(false, formObj, sheetObj);
  	        	formObj.com_content.value=formObj.default_content.value;
  	        	ComShowCodeMessage("COM130401");
  	        }
  	        else{
					moveScreen(sheetObj, formObj, 0);
  	        	// Port Code Data Set.
//      	    		setVVDPortCombo(sheetObj, formObj, "Vsl", false);
//      	    		comboObjects[1].Code2 = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vps_port_cd");
					formObj.vps_port_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vps_port_cd");
      	        doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "MailContentPic");
  	        }
            	if(strFlag=="File"){
	              	formObj.f_cmd.value=SEARCH05;
	              	sheetObjects[1].DoSearch("VOP_OPF_0052GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") + "&stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=SDR&stv_dmg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_no"), {Sync:1});
	              	sheetObjects[2].DoSearch("VOP_OPF_0052GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_") + "&stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_no"), {Sync:1});
	              	sheetObjects[3].DoSearch("VOP_OPF_0052GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet4_") + "&stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_no"), {Sync:1});
//	              	setFileField(formObj);
            	}
            	break;
  	    case IBROWSEARCH:
  	    	  if(strFlag=="dmgDate"){
  	    		  formObj.f_cmd.value=SEARCH06;
  	    		  var dateXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do" , FormQueryString(formObj));
  	    		  var etaDate=ComGetEtcData(dateXml, "eta_date");
  	    		  var etdDate=ComGetEtcData(dateXml, "etd_date");
  	    		  if(!isNull(etaDate) && !isNull(etdDate)){
//  	    			  var dateChk1 = ComGetDaysBetween(etaDate, formObj.stv_dmg_evnt_dt.value);
//  	    			  var dateChk2 = ComGetDaysBetween(formObj.stv_dmg_evnt_dt.value, etdDate);
//  	    			  if(dateChk1 < 0 || dateChk2 < 0){
//  	    				  ComShowCodeMessage("OPF07002", "Damage Date", "ETA Date("+etaDate+")");
//  	    				  ComShowCodeMessage("OPF50018", etaDate, etdDate);
  	    				  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_evnt_dt",etaDate);
      	    			  formObj.stv_dmg_evnt_dt.value=etaDate;
      	    			  formObj.stv_dmg_evnt_dt.focus();
//      	    			  return false;
      	    			  return true;
//  	    			  }
  	    		  }
  	    	  }
  	    	  if(strFlag=="etaDate"){
  	    		  formObj.f_cmd.value=SEARCH06;
  	    		  var voyNo=formObj.req_skd_voy_dir.value.substring(0,4);
  	    		  var dirCode=formObj.req_skd_voy_dir.value.substring(4);
  	    		  var port=formObj.req_port_cd.value;
//  	    		  var port = comboObjects[6].Code;
  	    		  var dateXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?skd_voy_no="+voyNo+"&skd_dir_cd="+dirCode+"&vps_port_cd="+port , FormQueryString(formObj));
  	    		  var etaDate=ComGetEtcData(dateXml, "eta_date");
  	    		   if(!isNull(etaDate)){	    		 
  	    				  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_req_eta_dt",etaDate);
  	    				  formObj.req_eta_dt.value=etaDate;
							  }
  	    	  }
  	    	  else if(strFlag=="ClmHndlOfc"){
  	    		  formObj.f_cmd.value=SEARCH07;
  	    		  //var ofcXml = sheetObj.GetSearchXml("COM_ENS_071GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
  	    		  var ofcXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
  	    		  var ofcArr=ComOpfXml2Array(ofcXml, "ofc_cd");
  	    		  if(isNull(ofcArr) || ofcArr.length < 1){
  	      			  ComShowCodeMessage("OPF50004", "Data");
  	    			  formObj.clm_hndl_ofc_cd.value="";
  	    			  formObj.clm_hndl_ofc_cd.focus();
  	    			  //ComSetFocus(formObj.clm_hndl_ofc_cd);
						  return false;
  	    		  }
  	    	  }
  	    	  else if(strFlag=="MailContentPic"){
  	    		  formObj.f_cmd.value=SEARCH08;
  	    		  var Xml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
  	    		  var mailContentCic=ComGetEtcData(Xml, "mail_content_pic");
  	    		  formObj.com_content.value=formObj.default_content.value+ mailContentCic;
  	    	  }    	    	  
  	    	  break;
  	      case IBSAVE:        //save
  	    	  var vDeleteFlag=false;
  	    	  if(!validateForm(sheetObj,formObj,sAction)){
  	    		  return false;
  	    	  }
  	    	  if(strFlag=="Approval"){
  	    		  if(isNull(formObj.stv_dmg_no.value)){
  	    			return false;  
  	    		  }
  	    		  
  	    		  var stvDmgNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_no");
  	    		  formObj.f_cmd.value=MODIFY01;
  	    		  formObj.dmg_auth_sts_cd.value="Y";
  	    		  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_dmg_auth_sts_cd","Y");
  	    		  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_auth_usr_id",formObj.auth_usr_id.value);
  	    		  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_auth_dt",formObj.auth_dt.value);
        	      sheetObj.DoAllSave("VOP_OPF_0052GS.do?stv_dmg_no="+stvDmgNo+"&auth_usr_id="+formObj.auth_usr_id.value+"&auth_dt="+formObj.auth_dt.value, FormQueryString(formObj));
        	      initApprovalPermission(sheetObj, formObj);
        	          //break;
  	    	  }
  	    	  else{
  	    		  formObj.f_cmd.value=MULTI;
  	    		  var sParam=ComGetSaveString(sheetObj);
  	    		  
  	    		  var arrSheet = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3]);
  	    		  var arrPrefix = new Array("sheet2_file_serial", "sheet3_file_serial", "sheet4_file_serial");
 // 	    		  var fParam = ComGetFileSaveString(arrSheet, upload1, arrPrefix, true);
  	    		  var fParam1=ComGetSaveString(sheetObjects[1], true);
  	    		  var fParam2=ComGetSaveString(sheetObjects[2], true);
  	    		  var fParam3=ComGetSaveString(sheetObjects[3], true);
  	    		  
  	    		  if(sheetObj.RowCount("D") == formObj.seq_total.value ){
  	    			  vDeleteFlag=true;
  	    		  }
  	    		  var uploadObj=uploadObjects[0];
  	    		  if(fParam1=="" && fParam2=="" && fParam3==""){
  	    			  if(sParam==""){
      	    			  return false;
      	    		  }
  	    			  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet1_");
  	    			  var saveXml=sheetObj.GetSaveData("VOP_OPF_0052GS.do", sParam);
      	    		  setStvDmgNo(sheetObj, ComGetEtcData(saveXml, "stvDmgNoList"));
      	    		  if (ComOpfGetMessageFromXml(saveXml).indexOf("OPF00001") !=-1){
      	    			  sheetObj.LoadSaveData(saveXml);
      	    			  break;
      	    		  }
      	    		  sheetObj.LoadSaveData(saveXml);
      	    	
  	    		  }
  	    		  else{
  	    			  var prefixs=new Array("sheet1_","sheet2_","sheet3_","sheet4_");
      	    		  if(upload1.GetList().length == 0){
      	    			  sParam += "&" + fParam1;
      	    			  sParam += "&" + fParam2;
      	    			  sParam += "&" + fParam3;
        	    		  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
      	    			  //1. in case of not existing file to upload => change only DB Info
      	    			  var saveXml=sheetObj.GetSaveData("VOP_OPF_0052GS.do", sParam);
          	    		  setStvDmgNo(sheetObj, ComGetEtcData(saveXml, "stvDmgNoList"));
          	    		  sheetObj.LoadSaveData(saveXml);
          	    		  //** in case of existing VVD CD/Port/DamageDate Info duplication check, initialize.
          	    		  if( ComOpfGetMessageFromXml(saveXml).indexOf("OPF00003") != -1 ){
          	    			  vDeleteFlag=true;
          	    		  }
          	    		  saveXml=ComDeleteMsg(saveXml);
           	    		  sheetObjects[1].LoadSaveData(saveXml);
           	    		  sheetObjects[2].LoadSaveData(saveXml);
           	    		  sheetObjects[3].LoadSaveData(saveXml);
      	    		  }
      	    		  else{
      	    			  var fParam = ComGetFileSaveString(arrSheet, upload1, arrPrefix, true);
      	    			  sParam += "&" + fParam;
        	    		  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
      	    			  //1. in case of existing file to upload => change DB Info and upload file.
          	    		  paramToForm(sParam);
          	    		  upload1.SaveStatus();
      	    		  }
      	    		  sheetObjects[1].RemoveAll();
      	    		  sheetObjects[2].RemoveAll();
      	    		  sheetObjects[3].RemoveAll();
      	    		  setScreenreadOnly(true, formObj, sheetObj);
  	    		  }
  	    		  //ComOpenWait(false);	
        	          //break;
  	    	  }
  	    	  if(vDeleteFlag){
  	    		  doActionIBSheet(sheetObj,formObj,IBCLEAR);
  	    	  }else{
  	    		  if(document.form.stv_dmg_no.value != "") {
  	    			  doActionIBSheet(sheetObj,formObj,IBSEARCH);
  	    		  }
  	    	  }    	    	  
  	    	  break;
  	      case IBDELETE:
  	    	  formObj.f_cmd.value=REMOVE;
  	    	  var deleteParam=ComGetSaveString(sheetObj);
  	    	  deleteParam=deleteParam +"&"+ FormQueryString(formObj);
  	    	  var saveXml=sheetObj.GetSaveData("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_no"), deleteParam);
  	    	  //sheetObj.DoSave("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj), -1,false);
  	    	  break;
  	      case COMMAND01:
  	    	  formObj.f_cmd.value=COMMAND01;
  	    	  var str_tmp=strFlag.split("|");
  	    	  var vsl_cd="";
  	    	  var voy_no="";
  	    	  var dir_cd="";
  	    	  var port_cd="";
  	    	  var lane_cd="";
  	    	  var result="";
  	    	  if (str_tmp[1] =='MAIN'){
  	    		  vsl_cd=formObj.vsl_cd.value;
  	    		  voy_no=formObj.skd_voy_no.value;
  	    		  dir_cd=formObj.skd_dir_cd.value;
  	    		  port_cd=comboObjects[0].GetSelectCode();
  	    		  lane_cd=formObj.slan_cd.value;    	    		  
  	    	  } else { /* sub */
  	    		  vsl_cd=formObj.vsl_cd.value;
  	      		  voy_no=formObj.req_skd_voy_dir.value.substring(0,4);
  	    		  dir_cd=formObj.req_skd_voy_dir.value.substring(4);
  	    		  port_cd=formObj.req_port_cd.value;
  	    	  }
   	    	  var resultXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?f_cmd="+COMMAND01+"&auto_skd_cng_flg="+str_tmp[0]+"&vsl_cd="+vsl_cd+"&skd_voy_no="+voy_no+"&skd_dir_cd="+dir_cd+"&vps_port_cd="+port_cd+"&slan_cd="+lane_cd);
   	    	  //alert(resultXml);
  	    	  result=ComGetEtcData(resultXml, "result_chk");
  	    	  if (str_tmp[0] == "PORT" && str_tmp[1] == "MAIN"){
  	    		  gVpsEtbEtdDt=ComGetEtcData(resultXml, "VPS_ETB_DT");
  	    	  }
  	    	  if (result==null ||result =="null"|| result=="" || result==undefined){
  	    		  return false;
  	    	  } else {
  	    		  return true;
  	    	  }
  	    	  break;
  	    }
  	}
        /**
         * get stc_dmg_no after saving..
         */
        function setStvDmgNo(sheetObj, stvDmgNoList){
        	if(!isNull(stvDmgNoList)){
        		var stvDmgNoS=stvDmgNoList.split("|");
            	for(i=1,j=0; i<=sheetObj.RowCount(); i++){
            		if(sheetObj.GetRowStatus(i)=="I"){
                		sheetObj.SetCellValue(i, "sheet1_stv_dmg_no",stvDmgNoS[j++],0);
                		sheetObj.SetCellValue(i, "sheet1_cre_usr_id",userId,0);
                		sheetObj.SetCellValue(i, "sheet1_cre_usr_ofc",ofcCd,0);
                	}
            	}
//            	document.form.sdms_no_1.value = stvDmgNoS[0].substring(0,4);
//            	document.form.sdms_no_2.value = stvDmgNoS[0].substring(4,11);
            	document.form.stv_dmg_no.value=stvDmgNoS[0];
        	}
        }
        /**
         * handling process for input validation
         */
        function searchValidation(formObj){
        	if(isNull(formObj.stv_dmg_no.value)){
        		ComShowCodeMessage("COM130404", "SDMS No.", "SDMS No.");
        		return false;
        	}
        	else if(formObj.stv_dmg_no.value.length!=11){
        		//ComShowMessage("Data Length 4.");
    			ComShowCodeMessage("OPF50007", "SDMS No.", "11");
        		formObj.stv_dmg_no.focus();
        		//ComSetFocus(formObj.sdms_no_1);
        		return false;
        	}
        	return true;
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	 var prefix="sheet1_";
        	 if(sheetObj.GetRowStatus(sheetObj.GetSelectRow())!="R"){
				 if(isNull(formObj.vsl_cd.value)){
					 ComShowCodeMessage("OPF50009", "VVD CD");
					 formObj.vsl_cd.focus();
					 return false;
				 }
				 else if(isNull(formObj.skd_voy_no.value)){
					 ComShowCodeMessage("OPF50009", "VVD CD");
					 formObj.skd_voy_no.focus();
					 return false;
				 }
				 else if(isNull(formObj.skd_dir_cd.value)){
					 ComShowCodeMessage("OPF50009", "VVD CD");
					 formObj.skd_dir_cd.focus();
					 return false;
				 }
				 else{
//					//retrieve VVD Code validation
//	               	 formObj.f_cmd.value = SEARCH01;
//	               	 var portXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq" , FormQueryString(formObj));
//	               	 
//	               	 var strPortCdList = ComGetEtcData(portXml, "vvdPortComboList");
//	               	 if(isNull(strPortCdList)){
//	           			ComShowCodeMessage("OPF50004", "Data");
//	               		formObj.vsl_cd.value = "";
//	               		formObj.skd_voy_no.value = "";
//	               		formObj.skd_dir_cd.value = "";
//	               		formObj.vps_port_cd.value ="";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"vsl_cd") = "";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = "";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_voy_no") = "";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_dir_cd") = "";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"vps_port_cd") = "";
////	               		comboObjects[1].RemoveAll();
//
//	               		formObj.vsl_cd.focus();
//	               		//ComSetFocus(formObj.vsl_cd);
//	               		return false;
//	               	 }
				 }
//        		 if(isNull(comboObjects[1].Code)){
        		 if(isNull(comboObjects[0].GetSelectCode())){
      				//ComShowMessage("\'Port\' is mandatory item.");
         			ComShowCodeMessage("OPF50009", "Port");
//      				formObj.vps_port_cd.focus();
      				return false;
          		 }
        		 if(isNull(formObj.stv_dmg_evnt_dt.value)){
        			 ComShowCodeMessage("OPF50009", "Damage Date");
        			 formObj.stv_dmg_evnt_dt.focus();
        			 return false;
             	 }
        		 else{
        			 var isDmgDate=doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "dmgDate");
        			 if(isNull(isDmgDate+"")) {isDmgDate=true;}
        			 if(!isDmgDate){
        				 return false;
        			 }
        		 }
        		 if(isNull(comboObjects[1].GetSelectCode())){
                  	//ComShowMessage("\'Vessel Category\' is mandatory item.");
         			ComShowCodeMessage("OPF50009", "Vessel Category");
                  	formObj.vsl_oshp_cntr_blk_tp_cd.focus();
                  	return false;
                 }
        		 if(isNull(formObj.clm_hndl_ofc_cd.value)){
        			 ComShowCodeMessage("OPF50009", "Claim Handling Office");
        			 formObj.clm_hndl_ofc_cd.focus();
                   	 return false;
        		 }
        		 else{
        			 var isOfcCd=doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "ClmHndlOfc");
        			 if(isNull(isOfcCd+"")) {isOfcCd=true;}
        			 if(!isOfcCd){
        				 return false;
        			 }
         		 }
                 if(isNull(comboObjects[2].GetSelectCode())){
                  	//ComShowMessage("\'Category\' is mandatory item.");
         			ComShowCodeMessage("OPF50009", "Category");
                  	formObj.stv_dmg_prt_cate_cd.focus();
                  	return false;
                 }
                 else if(isNull(comboObjects[3].GetSelectCode())){
                  	//ComShowMessage("\'Part\' is mandatory item.");
         			ComShowCodeMessage("OPF50009", "Part");
                  	formObj.stv_dmg_prt_cd.focus();
                  	return false;
                 }
        		 // Loss Time(Hours) Data Validation Check!
        		 var chkLossDate=checkDateHours(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
    			 if(isNull(chkLossDate+"")) {chkLossDate=true;}
    			 if(!chkLossDate){
    				 return false;
    			 }
                 if(formObj.stv_dmg_req_cate_cd[2].checked){
         			if(isNull(comboObjects[5].GetSelectCode()))
         			{
         				//ComShowMessage("\'Requirement- Reason\' is mandatory item.");
            			ComShowCodeMessage("OPF50009", "Requirement- Reason");
         				formObj.stv_dmg_qttn_rsn_desc.focus();
         				return false;
         			}
         			else if(comboObjects[5].GetSelectCode()=="TXT" && isNull(formObj.req_reason_desc.value)){
         				ComShowCodeMessage("OPF50009", "Requirement- Reason Description");
         				formObj.req_reason_desc.focus();
         				return false;
         			}
         		 }
                 else{
         			if(isNull(formObj.req_skd_voy_dir.value))
         			{
            			//ComShowCodeMessage("OPF50009", "Requirement- Voyage No.");
         				//return ;
         			}
         			else{
         				//retrieve Voyage No. data
//    	    	    	formObj.f_cmd.value = SEARCH01;
//    		    		var voyNo = formObj.req_skd_voy_dir.value.substring(0,4);
//    		    		var dirCd = formObj.req_skd_voy_dir.value.substring(4);
//    		    		var portXml2 = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq&skd_voy_no="+voyNo+"&skd_dir_cd="+dirCd , FormQueryString(formObj));
//    		    		
//    	    	    	var strPortCdList2 = ComGetEtcData(portXml2, "vvdPortComboList");
//    	    	    	if(isNull(strPortCdList2)){
//    		    			ComShowCodeMessage("OPF50004", "Data");
//    		    			formObj.req_skd_voy_dir.value = "";
//    		    			formObj.req_port_cd.value="";
////    		    			comboObjects[6].RemoveAll();
//    		    			formObj.req_eta_dt.value = "";
//    		    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_voy_no") = "";
//    		    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_dir_cd") = "";
//    		    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
//    		    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
//    		    			formObj.req_skd_voy_dir.focus();
//    	    	    		return false;
//    	    	    	}
         			}
         			//if(isNull(comboObjects[6].Code))
         			//{
            		//	ComShowCodeMessage("OPF50009", "Port");
         			//	formObj.req_port_cd.focus();
         			//	return false;
         			//}
         		}
         		if(formObj.stv_dmg_respb_pty_kwn_flg[0].checked){
         			if(isNull(formObj.stv_dmg_respb_desc_dtl.value))
         			{
         				//ComShowMessage("\'Responsible Party- Details\' is mandatory item.");
            			ComShowCodeMessage("OPF50009", "Responsible Party- Details");
         				formObj.stv_dmg_respb_desc_dtl.focus();
         				return false;
         			}
         		}else{
         			if(isNull(comboObjects[6].GetSelectCode()))
         			{
         				//ComShowMessage("\'Responsible Party- Reason\' is mandatory item.");
            			ComShowCodeMessage("OPF50009", "Responsible Party- Reason");
         				formObj.stv_dmg_respb_desc.focus();
         				return false;
         			}
         			else if(comboObjects[6].GetSelectCode()=="TXT" && isNull(formObj.res_reason_desc.value)){
         				ComShowCodeMessage("OPF50009", "Responsible- Reason Description");
         				formObj.res_reason_desc.focus();
         				return false;
         			}
         		}
        	 }
             return true;
        }
        /**
         * checking Null in window form input value
         */
        function isNull(itemValue){
            if(itemValue==null || itemValue=="" || itemValue=="undefined"){
            	return true;
            }
            else{
            	return false;
            }
        }
         /**
          * time calculation method of page DateTime input value.
          */
         function getDateHoursBetween(fromTime, toTime){
        	 if(isNull(fromTime) || isNull(toTime)){
        		 return "";
        	 }
        	 else{
             	 fromTime=fromTime.replace(/-/g,"");
             	 fromTime=fromTime.replace(/:/g,"");
             	 fromTime=fromTime.replace(/ /g,"");
             	 toTime=toTime.replace(/-/g,"");
             	 toTime=toTime.replace(/:/g,"");
             	 toTime=toTime.replace(/ /g,"");
         		 var dayTime=ComGetDaysBetween(fromTime.substring(0,8), toTime.substring(0,8)) * 24;
         		 if(fromTime.substring(10) >= toTime.substring(10)){
         			 dayTime=dayTime - (fromTime.substring(8,10) - toTime.substring(8,10));
         		 }
         		 else{
         			 dayTime=dayTime + (toTime.substring(8,10) - fromTime.substring(8,10));
         		 }
         		 var minute=0;
         		 if(fromTime.substring(10) > toTime.substring(10)){
 					 dayTime=dayTime - 1;
 					 minute=(fromTime.substring(10) - toTime.substring(10)) / 60;
 				 }
 				 else if(fromTime.substring(10) < toTime.substring(10)){
 					 minute=(toTime.substring(10) - fromTime.substring(10)) / 60;
 				 }
         		 var returnTime="";
         		 if(minute>0){
         			 returnTime=(dayTime+minute).toFixed(2);
         		 }else{
         			 returnTime=dayTime;
         		 }
         		 return returnTime;
        	 }
         }
         /**
          * validation check method of page DateTime input value.
          */
         function checkDateHours(fromTime, toTime){
        	 var formObj=document.form;
        	 if(isNull(formObj.fm_tm_lss_dt.value) && !isNull(formObj.to_tm_lss_dt.value))
     		 {
     			 ComShowCodeMessage("OPF50009", "From Loss Hour");
     			 formObj.fm_tm_lss_dt.focus();
     			 return false;
     		 }
     		 else if(!isNull(formObj.fm_tm_lss_dt.value) && isNull(formObj.to_tm_lss_dt.value))
     		 {
     			 ComShowCodeMessage("OPF50009", "To Loss Hour");
     			 formObj.to_tm_lss_dt.focus();
     			 return false;
     		 }
     		 else if(!isNull(formObj.fm_tm_lss_dt.value) && !isNull(formObj.to_tm_lss_dt.value))
     		 {
     			 var lossTime=getDateHoursBetween(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
     			 if(lossTime <= 0){
	   				 ComShowCodeMessage("OPF50013", "To Loss Hour", "From Loss Hour");
	   				 formObj.fm_tm_lss_dt.focus();
	   				 return false;
	   			 }
     		 }
         }
        /**
         * Approval permission Check.
         */
        function initApprovalPermission(sheetObj, formObj){
        	var prefix="sheet1_";
        	if(isNull(sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"dmg_auth_sts_cd"))){
        		formObj.dmg_auth_sts_cd.value="X";
            	sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"dmg_auth_sts_cd","X");
    		}
    		else{
    			formObj.dmg_auth_sts_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"dmg_auth_sts_cd");
    		}
        	if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"dmg_auth_sts_cd")=="N"){
        		formObj.dmg_auth_sts_cd.className="input2_red";
				document.getElementById("btnApproval").style.color="red";
    		}
    		else{
    			formObj.dmg_auth_sts_cd.className="input2";
				document.getElementById("btnApproval").style.color="#c0c0c0";
    		}
    		if(approvalCheck=="1")
        	{
    			approvalFlag=true;
    			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"dmg_auth_sts_cd")=="N"){
    				ComBtnEnable("btnApproval");
            		formObj.auth_usr_id.value=userId;
            		
            		if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"stv_dmg_respb_pty_kwn_flg")!="Y"){
            			formObj.auth_dt.value=ComGetNowInfo("ymd");
            		}

    			}
    			else{
    				ComBtnDisable("btnApproval");
    			}
        	}
        	else{
        		ComBtnDisable("btnApproval");
        		formObj.auth_usr_id.value="";
        		formObj.auth_dt.value="";
        	}
    		ComSetFocus(formObj.auth_dt);
        }
        
       function vsl_oshp_cntr_blk_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	    	var formObj=document.form;
	    	var sheetObj=sheetObjects[0];
	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_vsl_oshp_cntr_blk_tp_cd",comboObj.GetSelectCode());
	    	//sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_vsl_oshp_cntr_blk_tp_cd") = comboObj.Code;
 	   }
 	   	   
	   function stv_dmg_prt_cate_cd_OnBlur(comboObj) {
		   //stv_dmg_prt_cate_cd_text.value = comboObj.GetSelectCode();
	   }
	   
	   function showHideLayers(stvDmgAtchFileTpCd) {
//		   var focusNum1 = $(uploadLayer1).attr("id").split("uploadLayer")[1];
//		   var focusNum2 = $(uploadLayer2).attr("id").split("uploadLayer")[1];
//		   var focusNum3 = $(uploadLayer3).attr("id").split("uploadLayer")[1];
		   
		   switch(stvDmgAtchFileTpCd) {
	           case "SDR":
	        	   $(uploadLayer2).css({visibility:"hidden", zIndex:-1});
	        	   $(uploadLayer3).css({visibility:"hidden", zIndex:-1});
	        	   sheet2.SetVisible(false);
	        	   sheet3.SetVisible(false);
//	        	   $("#Grid" + focusNum2 + "FocusCursors, #Grid" + focusNum3 + "FocusCursors").css("visibility","hidden");
	        	   
	        	   if($(uploadLayer1).css("visibility") == "visible"){
	        		   $(uploadLayer1).css({visibility:"hidden", zIndex:-1});
	        		   sheet2.SetVisible(false);
//	        		   $("#Grid" + focusNum1 + "FocusCursors").css("visibility","hidden");
		   	       }else{
		   	            $(uploadLayer1).css({visibility:"visible",zIndex:999});
		   	            sheet2.SetVisible(true);
//		   	            $("#Grid" + focusNum1 + "FocusCursors").css("visibility","visible");
		   	        }
	        	   break;
	           case "PIC":
	        	   $(uploadLayer1).css({visibility:"hidden", zIndex:-1});
	        	   $(uploadLayer3).css({visibility:"hidden", zIndex:-1});
	        	   sheet2.SetVisible(false);
	        	   sheet4.SetVisible(false);
//	        	   $("#Grid" + focusNum1 + "FocusCursors, #Grid" + focusNum3 + "FocusCursors").css("visibility","hidden");
	        	   
	        	   if($(uploadLayer2).css("visibility") == "visible"){
	        		   $(uploadLayer2).css({visibility:"hidden", zIndex:-1});
	        		   sheet3.SetVisible(false);
//	        		   $("#Grid" + focusNum2 + "FocusCursors").css("visibility","hidden");
		   	       }else{
		   	            $(uploadLayer2).css({visibility:"visible", zIndex:999});
		   	            sheet3.SetVisible(true);
//		   	            $("#Grid" + focusNum2 + "FocusCursors").css("visibility","visible");
		   	        }
	        	   break;
	           case "DOC":
	        	   $(uploadLayer1).css({visibility:"hidden", zIndex:-1});
	        	   $(uploadLayer2).css({visibility:"hidden", zIndex:-1});
	        	   sheet2.SetVisible(false);
	        	   sheet3.SetVisible(false);
//	        	   $("#Grid" + focusNum1 + "FocusCursors, #Grid" + focusNum2 + "FocusCursors").css("visibility","hidden");
	        	   
	        	   if($(uploadLayer3).css("visibility") == "visible"){
	        		   $(uploadLayer3).css({visibility:"hidden",zIndex:-1});
	        		   sheet4.SetVisible(false);
//	        		   $("#Grid" + focusNum3 + "FocusCursors").css("visibility","hidden");
		   	       }else{
		   	            $(uploadLayer3).css({visibility:"visible", zIndex:999});
		   	            sheet4.SetVisible(true);
//		   	            $("#Grid" + focusNum3 + "FocusCursors").css("visibility","visible");
		   	        }
	        	   break;
	           }
		   
		   		setFileField(document.form);
		   }
	   
	    function initUpload(){
	    	upload1.Initialize({
				SaveUrl:'/opuscntr/VOP_OPF_0052GS.do',
				ShowButtonArea: true,
				ExtraForm:'upLoadForm',
				AddSaveButton: function(ibup){
					
				},
				AfterSaveStatus : function(result) {
					var code = result.code;
					ComUploadRemoveFile(upload1, "", true);
					
		      		if( code == 0) {
		      			var files = result.files;
		      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
		      			sXml = convert2ibsheet7(sXml);
		      			setStvDmgNo(sheetObjects[0], ComGetEtcData(sXml, "stvDmgNoList"));
		      			sheetObjects[0].LoadSaveData(sXml);
		      			saveXml=ComDeleteMsg(sXml);
		      			sheetObjects[1].LoadSaveData(saveXml);
		      			sheetObjects[2].LoadSaveData(saveXml);
		      			sheetObjects[3].LoadSaveData(saveXml);
		      		}else {
						ComShowMessage(result.msg);
					}
				},			
				BeforeSaveStatus : function(result) {
//				     for (var rowIdx=1; rowIdx<=sheetObj.LastRow(); rowIdx++){
//							if(delFlag == 'Y'){
//								with(sheetObj){
//									if(GetRowStatus(rowIdx)=="I"){
//										var sFile=GetCellValue(rowIdx, "file_nm");
//						    			SetRowStatus(rowIdx,"D");
//						    		}
//						    		else{
//						    			if(GetRowStatus(rowIdx)=="U"){
//						    				var sFile=GetCellValue(rowIdx, "file_nm");
//						    			}
//						    			SetRowStatus(rowIdx,"D");
//						    		}
//						    	}
//							}
//						}
				   return true;
				},
				AfterAddFile : function(result) {
					var formObject = document.form;
					var files = upload1.GetList();
					var fileName=files[files.length-1].GetFileName();
					var serialNo = files[files.length-1].GetSerialNo();
					var sheetObj;
					var prefix;
					
					if(stvDmgAtchFileTpCd == "SDR"){
						sheetObj=sheetObjects[1];
						prefix="sheet2_";
					}else if(stvDmgAtchFileTpCd == "PIC"){
						sheetObj=sheetObjects[2];
						prefix="sheet3_";
					}else if(stvDmgAtchFileTpCd == "DOC"){
						sheetObj=sheetObjects[3];
						prefix="sheet4_";
					}
					
					var row = sheetObj.GetSelectRow();
					var strSeq;		
					var fileSeq;		
			    	 for( var i = 0; i < files.length; i++) {
						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix+"file_sav_id") == files[i].GetSerialNo()){
							upload1.RemoveOneFile(files[i].GetSerialNo());
						}
			    	 }
			    	 if(sheetObj.RowCount() == 1){
			    		 fileSeq=1;
			    	 }
			    	 if(sheetObj.RowCount() > 1 && sheetObj.GetRowStatus(row) == "I"){
	 					fileSeq=parseInt(sheetObj.GetCellValue(sheetObj.RowCount()-sheetObj.HeaderRows(), prefix+"stv_dmg_atch_file_seq"))+1;
			    	 }
			    	 if(addFlg){
		    		 	var row=sheetObj.GetSelectRow();
		    		 	sheetObj.SetCellValue(row, prefix+"stv_dmg_no",sheet1.GetCellValue(sheet1.GetSelectRow(), "sheet1_stv_dmg_no"),0);
		    		 	sheetObj.SetCellValue(row, prefix+"stv_dmg_proc_cd",stvDmgProcCd,0);
		    		 	sheetObj.SetCellValue(row, prefix+"stv_dmg_atch_file_tp_cd",stvDmgAtchFileTpCd,0);
		    		 	sheetObj.SetCellValue(row, prefix+"vsl_cd",formObject.vsl_cd.value,0);
		    		 	sheetObj.SetCellValue(row, prefix+"stv_dmg_atch_file_seq",fileSeq,0);
		 			}
				 			
		 			if(fileName) {
		 				with(sheetObj) {
		 					SetCellValue(GetSelectRow(), prefix+"file_sav_id",serialNo,0);//set file path
		 					SetCellValue(GetSelectRow(), prefix+"file_serial",serialNo,0);//set file path
		 					SetCellValue(GetSelectRow(), prefix+"file_set_yn","Y",0);//set whether select localfile or not
		 					SetCellValue(GetSelectRow(), prefix+"cre_usr_id",userId,0);
		 					SetCellValue(GetSelectRow(), prefix+"cre_dt",ComGetNowInfo("ymd"),0);
		 					SetCellValue(GetSelectRow(), prefix+"file_nm",fileName,0);//set file name
		 					
		 					GetCellFontUnderline(SetSelectRow, prefix+"file_nm", 0);//remove download link
		 				}
		 			}
		 			else{
		 				if(addFlag){
		 					sheetObj.SetRowStatus(sheet2.GetSelectRow(),"D");
		 				}
		 			}
				},
				BeforeAddFile : function(result){
					return true;
				},
				AfterOnload : function() {
				}
			});
	    }
	    
	    function sheet2_OnDblClick(sheetObj,Row,Col,Value){		
	    	if (sheetObj.ColSaveName(Col) != "sheet2_file_nm") 
				return;
			parent.location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "sheet2_file_sav_id");
			return;
		}	
	    
	    function sheet3_OnDblClick(sheetObj,Row,Col,Value){		
			if (sheetObj.ColSaveName(Col) != "sheet3_file_nm") 
				return;
			parent.location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "sheet3_file_sav_id");
			return;
		}	
	    
	    function sheet4_OnDblClick(sheetObj,Row,Col,Value){		
	    	if (sheetObj.ColSaveName(Col) != "sheet4_file_nm") 
				return;
			parent.location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "sheet4_file_sav_id");
			return;
		}	
	    function sheet2_OnMouseMove(){
	    	var row = sheet2.MouseRow(),
	        col = sheet2.MouseCol(),
	        info = null;
	             
	        if (row > 0 &&col == 4) {
	        	prow = row;
	        	info = sheet2.GetCellElement(row, col, 1);
	        	upload1.SetFileUploadElement(info);
	        } 
	    }
	    
	    function sheet3_OnMouseMove(){
	    	var row = sheet3.MouseRow(),
	        col = sheet3.MouseCol(),
	        info = null;
	             
	        if (row > 0 &&col == 4) {
	        	prow = row;
	        	info = sheet3.GetCellElement(row, col, 1);
	        	upload1.SetFileUploadElement(info);
	        } 
	    }
	    
	    function sheet4_OnMouseMove(){
	    	var row = sheet4.MouseRow(),
	        col = sheet4.MouseCol(),
	        info = null;
	             
	        if (row > 0 &&col == 4) {
	        	prow = row;
	        	info = sheet4.GetCellElement(row, col, 1);
	        	upload1.SetFileUploadElement(info);
	        } 
	    }
	   /**
	     * delete line chosen
	     */
	    function deleteRow(sheetObj){
	    	var prefix="";
	    	switch(sheetObj.id) {
	            case "sheet2":
	            	prefix = "sheet2_";
	            break;
	            case "sheet3":
	            	prefix = "sheet3_";
	            break;
	            case "sheet4":
	            	prefix = "sheet4_";
	            break;
	    	}
	    	var files = upload1.GetList();
			var row = sheetObj.GetSelectRow();
			
			var sheet_serial = sheetObj.GetCellValue(row, prefix+"file_sav_id");
	    	ComUploadRemoveFile(upload1, sheet_serial, false);

	    	sheetObj.SetRowStatus(row,"D");
	    	
	    	if(sheetObj.GetRowStatus(row) != "I"){
	    		sheetObj.SetRowStatus(row,"D");
		    	sheetObj.SetRowHidden(row,true);
	    	}
	    	// resetting Sequence 
			setSequence(sheetObj);
	    }
	    /**
	     * Sequence Update <br>
	     * @param {ibsheet} sheetObj    IBSheet Object
	     **/
		function setSequence(sheetObj){
	    	// resetting Sequence .
			var seq=1;
			var beforeStatus="";
			for(var i=1; i<=sheetObj.LastRow(); i++){
				if(sheetObj.GetCellValue(i, "deleteFlag") != "Y"){
				//if(sheetObj.RowStatus(i)!="D"){
					beforeStatus=sheetObj.GetRowStatus(i);
					sheetObj.SetCellValue(i,"strSeq",seq++,0);
					sheetObj.SetRowStatus(i,beforeStatus);
				}
			}
	    }
		
		function sheet1_OnSaveEnd(sheetObj, errMsg, code){
			doActionIBSheet(sheetObj,document.form,IBSEARCH,"File");
		}
		
		// skip port인 경우 | SKIP, 운하(EGSCA, PAPCA)인 경우 | CANAL
	    function portInfo(index, status, value) {
	    	var desc = "";
	    	// clear
			if(index == 0) {
				noVpsPortCd = "";
			}
	    	if(status == 'S') {
				desc = "SKIP";
			}
			if(value == 'EGSCA' || value == 'PAPCA') {
				desc = "CANAL";
			}	    	
			if(desc != '') {
				noVpsPortCd = noVpsPortCd + value + "." + desc + "," ;
			}
			return desc;
	    }

	    
	    
	    function vps_port_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	    	var arrVpsPortCd = noVpsPortCd.split(',');
			if(arrVpsPortCd != '') {
		    	for(var i=0;i<arrVpsPortCd.length-1;i++) {
		    		var value = arrVpsPortCd[i].split('.');
		    		if(value[0] == newCode) {
		    			ComShowCodeMessage('OPF50030', newCode + " [" + value[1] + "]");
		    			comboObjects[0].SetSelectIndex("",false);
		    			return false;
		    		}
		    	}
			}
    	
    		var formObj=document.form;
    		var sheetObj=sheetObjects[0];
    		var vpsPortCd=newCode ;
    		if(doActionIBSheet(sheetObj,formObj,COMMAND01,"PORT|MAIN")){
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_vps_port_cd",vpsPortCd, 0);
    			//ETB date Default
    			if (gVpsEtbEtdDt.length > 0){
    				var vpsEtbEtdDt=gVpsEtbEtdDt.split("|");
    				for (var i=0; i<vpsEtbEtdDt.length; i++){
    					vpsEtbEtdDt[i]=vpsEtbEtdDt[i].split(",");
    				}
    				//formObj.stv_dmg_evnt_dt.value=vpsEtbEtdDt[0][0];
    				formObj.stv_dmg_evnt_dt.value=transDateYMD(vpsEtbEtdDt[0][0]);
    			}
    			formObj.stv_dmg_evnt_dt.focus();
    		} else {
    			ComShowCodeMessage("OPF50004", vpsPortCd);
    			comboObjects[0].SetSelectIndex("",false);
    		}
	    }
