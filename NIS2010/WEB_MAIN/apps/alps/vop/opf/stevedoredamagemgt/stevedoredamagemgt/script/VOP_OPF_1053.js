/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_1053.js
*@FileTitle : Stevedore Damage Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : �̼���
*@LastVersion : 1.0
* 2009.06.08 �̼���
* 1.0 Creation
* 2010.06.08 K.H.U btn_Save �� �ּ��ڵ� �̻��� ���� checkShiftReasonNoMsg
* 2010.10.26 ������ [CHM-201006565-01] SDMS Creation �� inquiry &update ȭ�� ����
* 2010.12.15 �̻�� [CHM-201007482-01] SDMS delete & save logic ����
* 2011.01.12 �������� [CHM-201108239-01] SDMS�� demage date�� ���� ���� ���� ��û ��
* 2011.01.25 �������� [CSR���ݿ�] Requirement�� Quotation�� ���� Reason �ʼ��Է�
* 2011.04.01 ��â�� [CHM-201109535-01] SDMS Damage Creation ���� ��û����
* 2011.06.08 ��ȣ�� [CHM-201111329-01] [VOP-SDMS] Tap ���� �ο� Role ����
* 2011.10.21 ��ξ� [CHM-201113609-01] SDMS �ż� ó���� ���� Auto mailing ��� �߰� - ����� ���� ��� �߰� �� Auto mailing ��� �߰�
* 2011.11.21 ��ξ� [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD �� Port ���� ��� ����
* 2011.11.25 ��ξ� [CHM-201114738-01] Responsible Party Unknown �� ��� Completed Save �� Unsettled Inter-Office Account No. �ʼ��Է� ���� ó��
* 2011.12.23 ��ξ� [CHM-201115395-01] [OPF] SDMS Detail ���̵��� ���忩�� üũ���� ����
* 2012.02.03 ��ξ� [CHM-201215702-01] [VOP-OPF] SDMS3 No. ���� �� Į�� ���� : SDMS No. ���� �� Report No. ����
=========================================================*/
/****************************************************************************************
  �̺�Ʈ ���� �ڵ�: [�ʱ�ȭ]INIT=0; [�Է�]ADD=1; [��ȸ]SEARCH=2; [����Ʈ��ȸ]SEARCHLIST=3;
					[����]MODIFY=4; [����]REMOVE=5; [����Ʈ����]REMOVELIST=6 [����ó��]MULTI=7
					��Ÿ ������ ���ڻ��  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------���� �ڵ�� JSDoc�� �� ����� ���ؼ� �߰��� �ڵ��� ------------------*/
   /**
     * @fileoverview �������� �������� ����ϴ� �ڹٽ�ũ��Ʈ���Ϸ� �޷� ���� �Լ��� ���ǵǾ� �ִ�.
     * @author �����ؿ�
     */

    /**
     * @extends 
     * @class vop_opf_1053 : vop_opf_1053 ������ ���� ȭ�鿡�� ����ϴ� ���� ��ũ��Ʈ�� �����Ѵ�.
     */
    function vop_opf_1053() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initTab				= initTab;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	//this.dmgValidateForm 		= dmgValidateForm;
    	//this.dtlValidateForm 		= dtlValidateForm;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_activate			= obj_activate;
    	this.obj_keypress			= obj_keypress;
    	this.engnum_keypress		= engnum_keypress;
    	this.obj_keyup				= obj_keyup;
//    	this.dmg_change_event		= dmg_change_event;
    	this.dtl_change_event		= dtl_change_event;
    	this.rpr_change_event		= rpr_change_event;
    	this.cmpn_change_event		= cmpn_change_event;
    	this.stl_change_event		= stl_change_event;
    	this.change_event_checkbox	= change_event_checkbox;
    	this.change_event_radio		= change_event_radio;
    	this.setVVDPortCombo		= setVVDPortCombo;
    	this.blur_event				= blur_event;
    	this.pop_event				= pop_event;
    	//this.popEvent_req_port_cd	= popEvent_req_port_cd;
    	this.initCombo				= initCombo;
    	
    	this.isNull					= isNull;
    	this.setComboItem			= setComboItem;
    	this.setComboItem2			= setComboItem2;
    	this.setComboItem3			= setComboItem3;
    	this.vps_port_cd_OnChange	= vps_port_cd_OnChange;
    	this.setDefaultComboData	= setDefaultComboData;
    	this.setDamageReasonComboS	= setDamageReasonComboS;
    	this.setDisplaySeq			= setDisplaySeq;
    	this.moveScreen				= moveScreen;
    	//this.searchValidation		= searchValidation;
    	this.stv_dmg_prt_cate_cd_OnChange	= stv_dmg_prt_cate_cd_OnChange;
    	this.stv_dmg_prt_cd_OnChange		= stv_dmg_prt_cd_OnChange;
    	this.stv_dmg_tp_cd_OnChange			= stv_dmg_tp_cd_OnChange;
    	this.stv_dmg_qttn_rsn_desc_OnChange	= stv_dmg_qttn_rsn_desc_OnChange;
    	this.stv_dmg_respb_desc_OnChange	= stv_dmg_respb_desc_OnChange;
    	this.getDateHoursBetween			= getDateHoursBetween;
    	//this.setApprovalPermission			= setApprovalPermission;
    	this.setDisplayData			= setDisplayData;
    	this.setRprDisplayData		= setRprDisplayData;
    	this.setCmpnDisplayData		= setCmpnDisplayData;
    	this.setStlDisplayData		= setStlDisplayData;
    	this.initDefaultSheet		= initDefaultSheet;
    	this.cmpn_curr_cd_OnChange	= cmpn_curr_cd_OnChange;
    	//this.click_event			= click_event;
    	this.dmgFormObjControl		= dmgFormObjControl;
    	this.rprFormObjControl		= rprFormObjControl;
    	this.cmpnFormObjControl		= cmpnFormObjControl;
    	this.isUpdate				= isUpdate;
    	this.authPermission			= authPermission;
    	this.rprValidateForm 		= rprValidateForm;
    	this.cmpnValidateForm 		= cmpnValidateForm;
    	this.setStlDatareadOnly		= setStlDatareadOnly;
    }
    
   	/* ������ �۾�	*/

    // ������������
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var uploadObjects = new Array();
	var uploadCnt = 0;    
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var beforeSheet = 1;
    var firstTabFlag = true;
    
    var userId = "";
    var userNm = "";
    var officeCd = "";
    var dfCurrency = "";
    var approvalFlag = false;
    
    var ofcAuth = "";
    
    var changeFlag = false;
    var loadFlag = false;
    
    var opf01 = false;
    var opf04 = false;
    var opf05 = false;
    var opf06 = false;
    var claimHandlingOfc = false;
    var claimed = false;
    
    //Responsible Party �� UnKnown üũ ����
    var unKnownFlg = false;
    //load �߻�
    var firstLoad = true;
    
    var firstReqPortComboList = "";
    
    //var old_cd = "";

    // ��ưŬ���̺�Ʈ�� �޾� ó���ϴ� �̺�Ʈ�ڵ鷯 ���� */
    document.onclick = processButtonClick;

    // ��ư �������� �����Ͽ� ���μ����� �б�ó���ϴ� �̺�Ʈ�ڵ鷯 */
    function processButtonClick(){
         /***** �Ǵ� ��Ʈ�� 2�� �̻��� ��쿣 �߰� ��Ʈ���� �����Ͽ� ����Ѵ� *****/
	         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
         //var prefix = "sheet1_";

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
            	case "btn_SDR":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=SDR&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
            	case "btn_Picture":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=PIC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
            	case "btn_Document":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=DOC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
            	case "btn_t2Result":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=R&stvDmgAtchFileTpCd=RES&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
            	case "btn_t2Invoice":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=R&stvDmgAtchFileTpCd=INV&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;

            	case "btn_t2PIC":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=R&stvDmgAtchFileTpCd=PIC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;

            	case "btn_t2Document":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=R&stvDmgAtchFileTpCd=DOC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;

            	case "btn_t4Invoice":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=S&stvDmgAtchFileTpCd=INV&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;

            	case "btn_t4Document":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=S&stvDmgAtchFileTpCd=DOC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
	            case "clm_hndl_ofc_cd_pop":
	            	if(!formObject.clm_hndl_ofc_cd_pop.disabled){
	            		ComOpenPopup("COM_ENS_071.do", 750, 480, "clm_hndl_ofc_cd_pop_event", "1,0,1", true);
            		}
	            	break;
	            	
	            case "req_skd_voy_dir_pop":
	            	//if(authPermission(0) && !(formObject.stv_dmg_req_cate_cd[2].checked))
	            	if(!(formObject.stv_dmg_req_cate_cd[2].checked))	
	            	{
		            	var vsl_cd = formObject.vsl_cd.value;
	            		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 420, "req_skd_voy_dir_pop_event", "0,0", true);
	            	}
	            	break;

	            case "rpr_port_cd_pop":
	            	if((formObject.stv_dmg_rpr_proc_sts_cd[1].checked)){
	            		ComOpenPopup("VOP_VSK_0043.do", 422, 520, "popEvent_rpr_port_cd", "0,0", true);
	            	}
	            	break;
	            	
            	case "btn_stv_dmg_evnt_dt":
            		if(!(formObject.stv_dmg_evnt_dt.readOnly)){
            			var cal = new ComCalendar();
                    	cal.select(form.stv_dmg_evnt_dt, 'yyyy-MM-dd');
            		}
            		break;
            		
            	case "btn_req_eta_dt":
            		if(!(formObject.stv_dmg_req_cate_cd[2].checked)
            			&& !(formObject.req_eta_dt.readOnly)){
            			var cal = new ComCalendar();
                    	cal.select(form.req_eta_dt, 'yyyy-MM-dd');
            		}
            		break;
            		
            	case "btn_rpr_dt":
            		if((formObject.stv_dmg_rpr_proc_sts_cd[1].checked)){
            			var cal = new ComCalendar();
                    	cal.select(form.rpr_dt, 'yyyy-MM-dd');
            		}
            		break;
            		
            	case "btn_stv_dmg_cmpn_dt":
            		if(formObject.stv_dmg_cmpn_proc_sts_cd[5].checked){
            			var cal = new ComCalendar();
                    	cal.select(form.stv_dmg_cmpn_dt, 'yyyy-MM-dd');
            		}
            		break;
            		
            	case "btn_pay_dt":
            		var cal = new ComCalendar();
                	cal.select(form.pay_dt, 'yyyy-MM-dd');
                	break;
					
            	case "rpr_seq_prev":
            		moveScreen(sheetObjects[2], formObject, -1);
            		break;
            		
            	case "rpr_seq_next":
                	moveScreen(sheetObjects[2], formObject, 1);
            		break;
            		
            	case "rpr_seq_delete":
            		if(ComIsBtnEnable("rpr_seq_delete")){
            			// ���Ӱ� Add�� Data�� Delete ������.
            			if(sheetObjects[2].RowCount > 1 
            				&& sheetObjects[2].RowStatus(sheetObjects[2].SelectRow)=="I")
            			{
            				sheetObjects[2].RowStatus(sheetObjects[2].SelectRow) = "D";
                			moveScreen(sheetObjects[2], formObject, 0);
            			}
            		}
            		break;
                	
				case "btn_Approval":
					if(ComIsBtnEnable("btn_Approval")){
						doActionIBSheet(sheetObject1,formObject,IBSAVE, "Approval");
					}
					break;
					
				case "btn_Save":
					if(ComIsBtnEnable("btn_Save")){
						changeFlag = true;
						
						var sheet1 = sheetObjects[0].RowStatus(sheetObjects[0].SelectRow);
						var sheetIdx = tabObjects[0].SelectedIndex+1;

						if(ComShowConfirm(ComGetMsg("OPF50001", "Data"))){

							//alert(sheet1+"||"+isUpdate(sheetIdx));
							if(sheet1=="U"){// || checkClaimHandlingUser()
								return doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
							}

							if(isUpdate(sheetIdx) || checkClaimHandlingUser())
							{
			    				// Repair�� ù��° ������ Update�Ǹ� Settlement������ �Բ� Update�Ѵ�.
			    				if(sheetIdx==2)
			    				{
			    					if(isTrue(doActionIBSheet(sheetObjects[sheetIdx],formObject,IBSAVE))
			    						&& sheetObjects[4].RowCount>0 
			    						&& sheetObjects[sheetIdx].RowStatus(1)=="U")
			    					{
			    					    doActionIBSheet(sheetObjects[4],formObject,IBSAVE);
			    					}
			    				}
			    				else{
			    				    doActionIBSheet(sheetObjects[sheetIdx],formObject,IBSAVE);
			    				}
			    			}
						}else{
							return false;
						}
					}
					break;
					
				case "btn_Print":
					rdOpen();
					break;
					
				case "btn_Mail":
			    	formObject.com_templateMrdArguments.value = "/rp ["+formObject.stv_dmg_no.value+"]";
			    	ComSendMailModal();
					break;
					
				case "btn_Close":
					self.close();
					var opener = window.dialogArguments;
					opener.call_1053();
					break;
				case "btn_Delete":
					var stvDmgNo = formObject.stv_dmg_no.value;

//					var resultXml1 = sheetObject1.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND02+"&stv_dmg_no="+stvDmgNo);
//
//					var delCheckInd = ComGetEtcData(resultXml1, "del_check_ind");
//					
//					if (delCheckInd !="0"){
//						ComShowCodeMessage("OPF50026", stvDmgNo);
//						return false;
//					}
					//2011.01.06 delete ������ save�� �����ϰ� ����
					var tabName = "";
					var msgName = "";
		    	     if(tabObjects[0].SelectedIndex == 0){
		    	    	 tabName = "Damage";
		    	    	 msgName = "SDMS";
		    	     }else if(tabObjects[0].SelectedIndex == 1){
		    	    	 tabName = "Repair";
		    	    	 msgName = "repair data";
		    	     }else if(tabObjects[0].SelectedIndex == 2){
		    	    	 tabName = "Compensation";
		    	    	 msgName = "compensation data";
		    	     }else if(tabObjects[0].SelectedIndex == 3){
		    	    	 tabName = "Settlement";
		    	    	 msgName = "settlement data";
		    	     }
		    	     /*
					var resultXml1 = sheetObjects[0].GetSearchXml("VOP_OPF_1053GS.do?f_cmd="+COMMAND01+"&tab_name="+tabName+"&stv_dmg_no="+stvDmgNo);
					var saveChkInd = ComGetEtcData(resultXml1, "save_check_ind");
					if (saveChkInd !="Y"){
						ComShowCodeMessage("OPF50026", stvDmgNo);
						return false;
					}
					*/
					if(ComShowCodeConfirm("OPF50002", msgName)){
						doActionIBSheet(sheetObject1,formObject,IBDELETE, "");
						if(tabName == "Damage"){
							self.close();
						}else{
							dataSearch();
						}
					}

//					if(ComIsBtnEnable("btn_Delete")){
//						// ���� Row ���� ��  ȭ�� �̵�.
//						if(sheetObject1.RowStatus(sheetObject1.SelectRow)=="I"){
//			        		//SDR, PIC, DOC ��Ʈ sheet1_stv_dmg_no�� ���� ���� ����
//							for(var sh=1; sh<=3; sh++) {
//								for(var i=sheetObjects[sh].LastRow; i>=sheetObjects[sh].HeaderRows; i--) {
//				        			if( sheetObjects[sh].CellValue(i, "sheet"+(sh+1)+"_stv_dmg_no") == sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_stv_dmg_no") ){
//				        				sheetObjects[sh].RowStatus(i) = "D";
//				        			}
//				        			
//				        		}
//							}
//							
//							sheetObject1.RowStatus(sheetObject1.SelectRow) = "D";
//							moveScreen(sheetObject1, formObject, 0);
//						}
//						else{
//							if(ComShowCodeConfirm("OPF50002", "the sequence")){
//								sheetObject1.RowStatus(sheetObject1.SelectRow) = "D";
//							}
//						}
//					}
					
					
					var opener = window.dialogArguments;
					opener.call_1053();
					
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    //RD ���� �˾�  
    function rdOpen(){
    	var formObject = document.form;
    	var rdParam = "/rp ["+formObject.stv_dmg_no.value+"]";
    	var strPath = "apps/alps/vop/opf/stevedoredamagemgt/stevedoredamagemgt/report/VOP_OPF_1153.mrd";

    	formObject.com_mrdPath.value = strPath;
    	formObject.com_mrdArguments.value = rdParam;
    	ComOpenRDPopupModal();
    }
    
    /**
     * IBSheet Object�� �迭�� ���
     * ���� �ٸ� �׸���� �ϰ�ó���� �ʿ䰡 ���� �� �迭�� ��� ���μ����� �߰��� �� �ִ�
     * �迭�� �ҽ� ��ܿ� ����
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * �������� ������ IBMultiCombo Object�� comboObjects �迭�� ����Ѵ�. <br>
     * comboObjects �迭�� �������������� ��ܿ� �����ϰ�, �� �Լ��� {@link CoObject#ComComboObject} �Լ��� ���ؼ� IBMultiCombo Object�� �����Ǹ鼭 �ڵ� ȣ��ȴ�. <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){
    	//alert(comboCnt);
       comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * �������� ������ IBUpload Object�� uploadObjects �迭�� ����Ѵ�. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObj.AutoConfirm = "UP_OVERWRITE_YES DELETE_YES";
		uploadObjects[uploadCnt++] = uploadObj;
	}
	
    /**
     * IBTab Object�� �迭�� ���
     * ���� �ٸ� �׸���� �ϰ�ó���� �ʿ䰡 ���� �� �迭�� ��� ���μ����� �߰��� �� �ִ�
     * �迭�� �ҽ� ��ܿ� ����
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }
    
    /**
     * Combo �⺻ ����
     * Combo�� �׸��� �����Ѵ�.
     */
    function initCombo(comboObj) {
    	with(comboObj) {
    		switch(id) {
	    		case "vps_port_cd":
	            	SetTitle("Port");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
	            	ValidChar(2,0);
	            	MaxLength = 5;
		            break;
		            
		        case "vsl_oshp_cntr_blk_tp_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "stv_dmg_prt_cate_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "stv_dmg_prt_cd":
	            	SetTitle("Code|Part");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "stv_dmg_tp_cd":
	            	SetTitle("Code|Damage");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
		        case "req_port_cd":
	            	SetTitle("Port");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	//BackColor = "#CCFFFD";
	            	ValidChar(2,0);
	            	MaxLength = 5;
		            break;
		            
		        case "combo_req_port_cd":
		        	SetTitle("Port|Calling Seq.");
		        	SetColWidth("60|90");
		        	SetColAlign("left|center");
		        	DropHeight = 230;
		        	break;
		            
		        case "stv_dmg_qttn_rsn_desc":
	            	SetTitle("Code|Description");
	            	SetColWidth("45|140")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "stv_dmg_respb_desc":
	            	SetTitle("Code|Description");
	            	SetColWidth("45|185")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "qttn_locl_curr_cd":
	            	SetTitle("Currency");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
	            	ValidChar(2,0);
	            	MaxLength = 3;
		            break;
		            
		        case "cmpn_curr_cd":
	            	SetTitle("Currency");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
	            	ValidChar(2,0);
	            	MaxLength = 3;
		            break;
		    }
    	}
	}
    
    /**
     * Tab �⺻ ����
     * ���� �׸��� �����Ѵ�.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Damage" , -1 );
                    InsertTab( cnt++ , "Repair" , -1 );
                    InsertTab( cnt++ , "Compensation" , -1 );
                    InsertTab( cnt++ , "Settlement" , -1 );

                }
             break;

         }
    }
    
    /**
     * Tab Ŭ���� �̺�Ʈ ����
     * ������ ���� ��Ұ� Ȱ��ȭ �ȴ�.
     */
    function tab1_OnChange(tabObj , nItem)
    {
    	if(firstTabFlag){
            var objs = document.all.item("tabLayer");

        	objs[beforetab].style.display = "none";
        	objs[nItem].style.display = "Inline";

        	//--------------- ��Ⱑ �߿� --------------------------//
        	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        	//------------------------------------------------------//
        	beforetab= nItem;
        	
        	beforeSheet = beforetab+1;
        	firstTabFlag = false;
        	changeFlag = false;
        	
        	//setSubButton(nItem);
    	}
    }
    
    /**
     * Tab Ŭ���� �̺�Ʈ ����
     * ������ ���� ��Ұ� Ȱ��ȭ �ȴ�.
     * 2010.12.15 nItem�� tabIdx�� �ǹ��Ѵ�.
     */
    function tab1_OnClick(tabObj , nItem)
    {
    	 // Tab �̵��� ���� �۾��� �����͸� ������ ������ ���� Ȯ��.
    	var formObject = document.form;
    	var sheet1 = sheetObjects[0].RowStatus(sheetObjects[0].SelectRow);
    	//2010.12.15 �̻�� ���� - ���� tabName�� beforetab���� tabName�� �����Ͽ���. ��) beforeta==0 tabName="Damage"
    	//���� ���Ǵ� �ǵ��� �Һи��ϰ� ���� ������ �ʾ� �ϱ�� ���� ����
    	//tabName�� ���� tabName�� �ǹ�. nItem�� ���� tabIdx�� �ǹ���
    	var tabName = "";
    	     if(nItem == 0) tabName = "Damage";
    	else if(nItem == 1) tabName = "Repair";
    	else if(nItem == 2) tabName = "Compensation";
    	else if(nItem == 3) tabName = "Settlement";
    	//var prefix = "sheet"+(beforeSheet+1)+"_";
    	//Damage Sheet(sheet1)�� ���°� U Ȥ�� ��Sheet�� update�� ���¶��
    	if(sheet1=="U" || isUpdate(beforeSheet)){
    		
    		//save������ ����-authPermission- �̰� ����޽����� yes ���¶��
    		if(ComIsBtnEnable("btn_Save") && ComShowConfirm(ComGetMsg("OPF50003"))){
    			if(sheet1=="U"){
        			if( !isTrue(doActionIBSheet(sheetObjects[0],formObject,IBSAVE)) )
        			{
        				tabObj.SelectedIndex = beforetab;
        				return false;
        			}
    			}
    			
    			if(isUpdate(beforeSheet)){
    				
    				// Repair�� ù��° ������ Update�Ǹ� Settlement������ �Բ� Update�Ѵ�.
    				if(beforeSheet==2 && sheetObjects[beforeSheet].RowStatus(1)=="U")
    				{
    					if( !isTrue(doActionIBSheet(sheetObjects[beforeSheet],formObject,IBSAVE)) )
            			{
    						tabObj.SelectedIndex = beforetab;
            				return false;
            			}
    					// ���� Settlement ������ �����Ҷ��� Update�Ѵ�.
    					if(sheetObjects[4].RowCount>0 && sheetObjects[4].RowStatus(1)!="I")
    					{
    						if( !isTrue(doActionIBSheet(sheetObjects[4],formObject,IBSAVE)) )
                			{
        						tabObj.SelectedIndex = beforetab;
                				return false;
                			}
                			//doActionIBSheet(sheetObjects[4],formObject,IBSAVE,"Refresh");
    					}
    				}
    				else{
    					if( !isTrue(doActionIBSheet(sheetObjects[beforeSheet],formObject,IBSAVE)) )
            			{
    						tabObj.SelectedIndex = beforetab;
            				return false;
            			}
    				}
    			}
    		}
    		else{
    			if(sheet1=="U"){
        			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    			}
    			if(isUpdate(beforeSheet)){
    				
        			doActionIBSheet(sheetObjects[beforeSheet],formObject,IBSEARCH);
        			if(beforeSheet==2){

        				doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
        			}
    			}
    		}
    	}
    	
    	//if(!firstTabFlag){b 
	    	if(!loadFlag){
	    		tabObj.SelectedIndex = beforetab;
    			return false;
			}
    		else if(beforetab==0 && formObject.dmg_auth_sts_cd.value=="N"){
    			//ComShowMessage("No approval from PUSCOV yet for the unknown responsible party.\n Please request PUSCOV to give confirmation for this damage case \n before proceeding to the next process.");
    			ComShowCodeMessage("OPF50017");
    			tabObj.SelectedIndex = beforetab;
    			return false;
    		}
    		else{
    			var objs = document.all.item("tabLayer");

            	objs[beforetab].style.display = "none";
            	objs[nItem].style.display = "Inline";

            	//--------------- ��Ⱑ �߿� --------------------------//
            	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
            	//------------------------------------------------------//
            	beforetab= nItem;
            	
            	beforeSheet = beforetab+1;
            	changeFlag = false;
            	
            	setSubButton(nItem);
            	
            	if(nItem==0 && authPermission(nItem)){
            		formObject.clm_hndl_ofc_cd.readOnly = false;
            		formObject.clm_hndl_ofc_cd.className = "input1";
            	}
            	else{
            		formObject.clm_hndl_ofc_cd.readOnly = true;
            		formObject.clm_hndl_ofc_cd.className = "input2";
            	}
    		}
    	//}
     
    	// �Ʒ��� ������ ���� ��Ű�� authPermission �Լ� �ȿ��� ó��.
    	authPermission(nItem);
    	/*
    	//2010.12.15 �̻�� �߰� [CHM-201007482-01] delete�� save ��ư�� enable/disable ���¸� �����Ѵ�
    	//Save ��ư�� enable ������ ������ �Ǿ� �ϱ� method�� �����ϰ� üũ��
    	var stvDmgNo = formObject.stv_dmg_no.value;
		var resultXml1 = sheetObjects[0].GetSearchXml("VOP_OPF_1053GS.do?f_cmd="+COMMAND01+"&tab_name="+tabName+"&stv_dmg_no="+stvDmgNo);
		var saveChkInd = ComGetEtcData(resultXml1, "save_check_ind");

		// 2011.01.04 �������� �߰�. authPermission method �����ϰ� üũ��.
    	if(saveChkInd == 'Y' && authPermission(nItem)){
    		ComBtnEnable("btn_Save");
    	}else{
    		ComBtnDisable("btn_Save");
    	}
    	
    	// 2011.01.06 �������� delete������ save�� �����ϵ���
    	if ((userId == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cre_usr_id") || officeCd == "PUSCOV") && saveChkInd == 'Y'){
    		 ComBtnEnable("btn_Delete");
    	} else {
    		 ComBtnDisable("btn_Delete");
    	}
    	*/
    	
    	if(nItem == 1 && formObject.stv_dmg_rpr_proc_sts_cd[3].checked){// Repair Tab && Completed
    		
    		setClaimHandlingUserProcChange("R");
    	}else{
    		setClaimHandlingUserProcChange("D");
    	}
    	
    	if(nItem == 0 && comboObjects[6].Code == "U"){
    		setResponsiblePartyBehind("OnChange", true);
    	}
    	
    }
     
     //2011.01.04 �������� �������� save ��ư�� enable/disable �� �����Ѵ�.
     //2011.05.26 ��ȣ��    OPF01,04,05,06, Claimed �� ClaimHandling Office �Ҽ� ���� ���� ������ 
     //                  Delete, Save Button �� Enable/Disable �� �����ϵ��� ����
     //2013.09.16 roll code ����
    function authPermission(nItem){
    	var formObj = document.form;

    	var rVal = false;
    	
    	switch(nItem){
    		case 0:
    			rVal = true;
    			break;
    		case 1:
    			rVal = true;
    			break;
    		case 2:
    			rVal = true;  //( opf01 || opf06 || ( !claimed && claimHandlingOfc ) ? true : false );
    			break;
    		case 3:
    			rVal = true;
    			break;
    	}
    	// �ٱ����� �ٽ� �����ϴ� �� ������  �ش� �Լ� �ȿ��� ó�� ��. 
		if ( rVal ) {
			ComBtnEnable ( "btn_Delete" );
			ComBtnEnable ( "btn_Save" );
			
			
			if(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_stv_dmg_respb_pty_kwn_cd") != "U") {
				//Claim Handling User ����
				sheetObjects[17].RowDelete(1, false);
				sheetObjects[17].DataInsert(-1);
				sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#CCFFFD");
				setClaimHandlingUser(sheetObjects[17]);
			}
		}else {
			ComBtnDisable ( "btn_Delete" );
			ComBtnDisable ( "btn_Save" );
			
			//Claim Handling User ����
			sheetObjects[17].RowDelete(1, false);
		}

    	return rVal;
    }
     
     /**
      * Sub Button�� Disable/Enable ����. <br>
      **/
     function setSubButton(nItem){
    	 var formObject = document.form;
    	 
    	 if(authPermission(nItem)){
    		 // ComBtnEnable("btn_Save"); -- authPermission �Լ� �ȿ��� ó��
    		 
    		 /* [2009-11-26] ����ȣ ����� ��û���� �ּ�
    		 ComBtnEnable("btn_SDR");
    		 ComBtnEnable("btn_Picture");
    		 ComBtnEnable("btn_Document");
    		 ComBtnEnable("btn_t2Result");
    		 ComBtnEnable("btn_t2Invoice");
    		 ComBtnEnable("btn_t2PIC");
    		 ComBtnEnable("btn_t2Document");
    		 
    		 if(sheetObjects[4].RowCount > 0){
    			ComBtnEnable("btn_t4Invoice");
    		 	ComBtnEnable("btn_t4Document");
    	 	 }else{
         		 ComBtnDisable("btn_t4Invoice");
    	   		 ComBtnDisable("btn_t4Document");
    	 	 }*/
    	 
    		 
    		 
    		 
    		 if(sheetObjects[2].RowStatus(sheetObjects[2].SelectRow)=="I"){
        		 ComBtnEnable("rpr_seq_delete");
    		 }else{
    			 ComBtnDisable("rpr_seq_delete");
    		 }
     	 }
     	 else{
     		 // ComBtnDisable("btn_Save");  -- authPermission �Լ� �ȿ��� ó��
    		 
     		 /* [2009-11-26] ����ȣ ����� ��û���� �ּ�
     		 ComBtnDisable("btn_SDR");
     		 ComBtnDisable("btn_Picture");
     		 ComBtnDisable("btn_Document");
     		 ComBtnDisable("btn_t2Result");
     		 ComBtnDisable("btn_t2Invoice");
     		 ComBtnDisable("btn_t2PIC");
     		 ComBtnDisable("btn_t2Document");
     		 ComBtnDisable("btn_t4Invoice");
	   		 ComBtnDisable("btn_t4Document");*/

     		 ComBtnDisable("rpr_seq_delete");
     	 }
//    	 alert(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cre_usr_id"));
//    	 alert(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet0_cre_usr_id"));
//    	 if('0315362A' == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cre_usr_id")) {
//    		 alert("yes");
//    	 } else if('0315362A' == sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_cre_usr_id")) {
//    		 alert("yesyes");
//    	 } else{
//    		 alert("nonono");
//    	 }
//    	 alert("8804820 : "+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cre_usr_id"));
//    	 if(userId == '8804820'){
//    		 alert(1);
//    	 }
//    	 if(userId == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cre_usr_id")){
//    		 alert(2);
//    	 }

//2011.01.06 �������� delete logic -> save�� �����ϵ���.

//		var stvDmgNo    = formObject.stv_dmg_no.value;
//		var resultXml1  = sheetObjects[0].GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND02+"&stv_dmg_no="+stvDmgNo);
//		var delCheckInd = ComGetEtcData(resultXml1, "del_check_ind");

		//2010.12.15 WED �ּ�ó�� PUSCOV �������� ��û
		//if ((   userId == '8804820'||
		//		userId == '8701113'||
		//		userId == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cre_usr_id")) 
		//	&& delCheckInd =="0"){
			
		//2010.12.15. WED ���� PUSCOV �������� ��û : (������ or PUSCOV) and �����⺻����
//		if ((userId == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cre_usr_id") || officeCd == "PUSCOV") && delCheckInd =="0")
//		{			
//    		 ComBtnEnable("btn_Delete");
//    	 } else {
//    		 ComBtnDisable("btn_Delete");
//    	 }
     }
    
    /**
     * Grid Update Check <br>
     **/
    function isUpdate(sheetIdx) {
    	var updateStatus = false;
    	//var prefix = "sheet"+(sheetIdx+1)+"_";
    	for(i=1; i <= sheetObjects[sheetIdx].RowCount; i++){
    		
    		var shtStatus = sheetObjects[sheetIdx].RowStatus(i);
    		if(shtStatus=="I")
    		{
    			if(sheetIdx==2){
    				if(changeFlag
    					|| sheetObjects[sheetIdx].RowCount > 1)
    				{
    					updateStatus = true;
    				}
    			}
    			else if(sheetIdx==3 && sheetObjects[sheetIdx].RowCount==1){
    				if(changeFlag){
    					updateStatus = true;
    				}
    			}
    			else{
    				updateStatus = true;
    			}
    		}
    		else if(shtStatus=="U" || shtStatus=="D"){
    			updateStatus = true;
    		}
    	}
    	return updateStatus;
    }
    
//2011.01.04 update ������ office -> auth �� ����. authPermission function���� ��ü.
//    /**
//     * Office�� Update ���� Check. <br>
//     **/
//    function officePermission(tabIdx) {
//    	var updatableFlag = false;
//    	
//    	if(tabIdx==0){
//    		//if( ((sheetObjects[3].RowCount>0 && sheetObjects[3].RowStatus(1)=="I" ) || document.form.stv_dmg_cmpn_proc_sts_cd[0].checked)
//    		if( (sheetObjects[3].RowCount > 0 && document.form.stv_dmg_cmpn_proc_sts_cd[0].checked)
//    	    		&& (officeCd=="PUSCOV" || officeCd=="NYCNA" || officeCd=="HAMUR" || officeCd=="SINWA"))
//	    	{
//	    		updatableFlag = true;
//	    	}
//    	}
//    	
////    	else if(tabIdx==1){
//    	//2010.12.15 �����/�̻�� ���� - OfficePermission�� ��� ������ �����Ѵ�
////		if( (sheetObjects[3].RowCount > 0 && document.form.stv_dmg_cmpn_proc_sts_cd[0].checked)
////    				&& officeCd=="HJSM" )
////	    	{
////	    		updatableFlag = true;
////	    	}
////    	}
//		if( (sheetObjects[3].RowCount > 0 && document.form.stv_dmg_cmpn_proc_sts_cd[0].checked) &&
//			(officeCd=="PUSCOV" || officeCd=="NYCNA" || officeCd=="HAMUR" || officeCd=="SINWA" || officeCd=="HJSM") ){
//			updatableFlag = true;
//		}
//    	else if(tabIdx==2){
//    		updatableFlag = true;
//    	}
//    	else if(tabIdx==3){
//    		//2010.12.15 �����/�̻�� ���� - OfficePermission�� ��� ������ �����Ѵ�
////    		if(officeCd=="SELCDF"){
////    			updatableFlag = true;
////    		}
//			if(officeCd=="PUSCOV" || officeCd=="NYCNA" || officeCd=="HAMUR" || officeCd=="SINWA" || officeCd=="SELCDF") updatableFlag = true;
//    	}
//    	return updatableFlag;
//    }
    
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(comboXml) {
    	//var comboXml = sheetObj.GetSearchXml("VOP_OPF_1053GS.do" , FormQueryString(formObj));
    	
    	//Port Combo List Set..
//    	var strPortCdList = ComGetEtcData(comboXml, "vvdPortComboList");
//    	setComboItem(comboObjects[A],strPortCdList);
    	//Vessel Category Combo List Set..
    	var vslCateCode = ComGetEtcData(comboXml, "vslCategory");
    	setComboItem(comboObjects[0], vslCateCode);
    	//Category Combo List Set..
    	var categoryCode = ComGetEtcData(comboXml, "categoryCode");
    	setComboItem(comboObjects[1], categoryCode);
    	//Damage Combo List Set..
    	var damageCode = ComGetEtcData(comboXml, "damageCode");
    	setComboItem2(comboObjects[3], damageCode);
    	// Requirement - Damage Reason Combo List.
    	var reqReasonCode = ComGetEtcData(comboXml, "reqReasonCode");
    	setComboItem3(comboObjects[5], reqReasonCode);
    	
    	// Responsible Party Combo List.
    	var responsiblePartyCode = ComGetEtcData(comboXml, "responsiblePartyCode");
    	setComboItem(comboObjects[6], responsiblePartyCode);
    	
    	// Responsible - Damage Reason Combo List.
    	var resReasonCode = ComGetEtcData(comboXml, "resReasonCode");
    	setComboItem3(comboObjects[7], resReasonCode);
    	
    	//Currency Code Combo List Set..
    	var strCurrencyCdList = ComGetEtcData(comboXml, "currencyCode");
    	setComboItem(comboObjects[8], strCurrencyCdList);
    	setComboItem(comboObjects[9], strCurrencyCdList);
    }

    /**
     * Sheet �⺻ ���� �� �ʱ�ȭ
     * body �±��� onLoad �̺�Ʈ�ڵ鷯 ����
     * ȭ���� ���������� �ε��� �Ŀ� ��ó���ؾ� �ϴ� ����� �߰��Ѵ�
     */
    function loadPage(strUsrId, strUsrNm, strOffcCd) {
        //ComOpenWait(true);
		for(i=0;i<sheetObjects.length;i++){

			//khlee-���� ȯ�� ���� �Լ� �̸� ����
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-������ ȯ�� ���� �Լ� �߰�
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		
		ComOpenWait(true);
		//Combo �ʱ�ȭ
    	for(var m=0; m<comboObjects.length; m++){
        	initCombo(comboObjects[m]);
        }

		//UPLOAD ȯ�� ����
        for(var i=0;i<uploadObjects.length;i++){
		    //1. �⺻ ȯ�� ����
		    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_OPF_1053GS.do");
		}
        
		userId = strUsrId;
		userNm = strUsrNm;
		officeCd = strOffcCd;
		
		initControl();
		
		dataSearch();
		
		//setSubButton(0);
		
		document.form.stv_dmg_prt_cate_cd.focus();
		ofcAuth = document.form.clm_hndl_ofc_cd.value;
		
    	var formObj = document.form;	
    	
		if ( formObj.clm_hndl_ofc_cd.value == officeCd ) claimHandlingOfc = true; 
		if ( formObj.stv_dmg_cmpn_proc_sts_cd[1].checked ) claimed = true;
		
		//���� üũ
		/*
    	var stvDmgNo = document.form.stv_dmg_no.value;
    	var tabName = "Damage";
		var resultXml1 = sheetObjects[0].GetSearchXml("VOP_OPF_1053GS.do?f_cmd="+COMMAND01+"&tab_name="+tabName+"&stv_dmg_no="+stvDmgNo);
		var saveChkInd = ComGetEtcData(resultXml1, "save_check_ind");
		if((userId == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_cre_usr_id") || officeCd == "PUSCOV") && saveChkInd == 'Y'){
			ComBtnEnable("btn_Delete");
    	}else{
    		ComBtnDisable("btn_Delete");
    	}
    	*/
		authPermission(0);
		
		// ȭ�� �ε��� �Ϸ�Ǿ����� ���θ� ǥ���ϴ� Flag.
		loadFlag = true;
		//[PIC of Claim Handling Office] ������.
        //doActionIBSheet(sheetObjects[5],document.form, IBROWSEARCH, "MailContentPic");
        //ComOpenWait(false);
		
		firstLoad = false;
	}
     
    /**
     * �������� �ִ� HTML Control�� �̺�Ʈ�� �������� �ε��Ѵ�. <br>
     * {@link #loadPage}�Լ����� �� �Լ��� ȣ���Ͽ� IBSheet Object�� �ʱ�ȭ �Ѵ�. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects �迭���� ����
     **/
    function initControl(){
    	//axon_event.addListenerForm  ('blur',      'obj_deactivate', form); //- form ��ü ��Ʈ�� ��� ��Ʈ���� OnBeforeDeactivate(blur)�̺�Ʈ�� �ڵ� ó��
    	axon_event.addListenerFormat('blur',      'obj_deactivate', document.form); //- form ��ü ��Ʈ�� �� dataformat �Ӽ��� �ִ� ��� ��Ʈ���� OnBeforeDeactivate(blur)�̺�Ʈ�� �ڵ� ó��
        axon_event.addListenerFormat('focus',     'obj_activate',   document.form); //- form ��ü ��Ʈ�� �� dataformat �Ӽ��� �ִ� ��� ��Ʈ���� OnBeforeActivate(focus)�̺�Ʈ�� �ڵ� ó��
        axon_event.addListenerFormat('keypress',  'obj_keypress',   document.form); //- form ��ü ��Ʈ�� �� dataformat �Ӽ��� �ִ� ��� ��Ʈ���� onkeypress�̺�Ʈ�� �ڵ� ó��
        
    	//Code �Է� �� ���� �빮�ڸ� �Է��ϱ�
    	axon_event.addListener  ('keypress', 'engnum_keypress' , 'clm_hndl_ofc_cd'
    															, 'clm_hndl_ofc_cd_cmpn'
    															, 'cntr_no'
    															, 'req_skd_voy_dir'
    															, 'req_port_cd'
    															, 'rpr_port_cd'
    															, 'bil_inv_no'
    															, 'pay_curr_cd');
    	
    	axon_event.addListener  ('keyup', 'obj_keyup' , 'req_skd_voy_dir'
														, 'fm_tm_lss_dt'
														//, 'fm_tm_lss_dt_hour'
														, 'to_tm_lss_dt');
    	
    	axon_event.addListener  ('click'  , 'change_event_checkbox', 'cntr_dmg_flg'
																	, 'cgo_dmg_flg');
    	
    	axon_event.addListener  ('click'  , 'change_event_radio', 'stv_dmg_req_cate_cd'
//				   												, 'stv_dmg_respb_pty_kwn_cd'
				   												, 'stv_dmg_cmpn_proc_sts_cd'
				   												, 'stv_dmg_rpr_proc_sts_cd');
    	
    	
    	axon_event.addListener  ('change'  , 'dtl_change_event', 'stv_dmg_loc_desc'
															   , 'cntr_no'
															   , 'stv_dmg_rmk'
															   , 'req_skd_voy_dir' 
															   , 'req_port_cd'
															   , 'stv_dmg_respb_desc_dtl'
															   , 'req_reason_desc'
															   , 'res_reason_desc'
															   , 'stv_dmg_rpt_atch_knt'
															   , 'stv_dmg_pict_atch_knt'
															   , 'stv_dmg_doc_atch_knt');
    	
    	axon_event.addListener  ('change'  , 'rpr_change_event', 'qttn_cost_usd_amt'
															   , 'qttn_cost_locl_amt' 
															   , 'rpr_port_cd'
															   , 'rpr_vndr_nm'
															   , 'ustl_acct_no'
															   , 'run_rpr_acct_no'
															   , 'rpr_cost_usd_amt'
															   , 'rpr_rmk');
    	
    	axon_event.addListener  ('change'  , 'stl_change_event', 'shp_ownr_co_nm'
															   , 'bil_inv_no'
															   , 'pay_curr_cd'
															   , 'pay_locl_amt' 
															   , 'pay_usd_amt'
															   , 'stl_rmk');
    	
    	axon_event.addListener  ('change'  , 'cmpn_change_event', 'clm_hndl_ofc_cd_cmpn'
															   , 'clm_hndl_usr_id'
															   , 'stv_dmg_respb_pty_co_nm'
															   , 'stv_dmg_respb_pty_pic_nm' 
															   , 'stv_dmg_respb_pty_pic_tit_nm'
															   , 'cmpn_cost_locl_amt'
															   , 'cmpn_cost_usd_amt'
															   , 'cmpn_acct_no'
															   , 'cmpn_rmk');
    	
    	axon_event.addListener  ('focus'  , 'focus_event', 'clm_hndl_ofc_cd'
														 , 'stv_dmg_loc_desc'
														 , 'cntr_no'
														 , 'stv_dmg_rmk'
														 , 'req_skd_voy_dir' 
														 , 'stv_dmg_respb_desc_dtl'
														 , 'rpr_port_cd'
														 , 'rpr_vndr_nm'
														 , 'ustl_acct_no'
														 , 'run_rpr_acct_no'
														 , 'rpr_rmk');
    	
    	axon_event.addListener  ('blur'  , 'blur_event', 'clm_hndl_ofc_cd'
														 , 'stv_dmg_loc_desc'
														 , 'cntr_no'
														 , 'stv_dmg_rmk'
														 , 'req_skd_voy_dir' 
														 , 'stv_dmg_respb_desc_dtl'
														 , 'rpr_port_cd'
														 , 'rpr_vndr_nm'
														 , 'ustl_acct_no'
														 , 'run_rpr_acct_no'
														 , 'rpr_rmk');
    }
    
    /**
     * Grid Data ȭ�鿡 Setting. <br>
     **/
    function setDisplayData(formObj, gubun, strReqPortComboList){
    	
    	var sheetObj = null;
    	var thisRow = null;
    	var prefix = "";
    	
//		if(officePermission(0)){
    	if(authPermission(0)){
			formObj.clm_hndl_ofc_cd.readOnly = false;
			formObj.clm_hndl_ofc_cd.className = "input1";
    	}
    	else{
    		formObj.clm_hndl_ofc_cd.readOnly = true;
    		formObj.clm_hndl_ofc_cd.className = "input2";
    	}
    	
    	if(gubun!="Dtl"){
    		//** OPF_STV_DMG Data Set..
        	sheetObj = sheetObjects[0];
        	thisRow = sheetObj.SelectRow;
        	prefix = "sheet1_";
        	
        	formObj.vsl_cd.value 				= sheetObj.CellValue(thisRow, prefix+"vsl_cd");
            formObj.skd_voy_no.value 			= sheetObj.CellValue(thisRow, prefix+"skd_voy_no");
            formObj.skd_dir_cd.value 			= sheetObj.CellValue(thisRow, prefix+"skd_dir_cd");
            // Lane Code Set..
            formObj.f_cmd.value = SEARCH02;
        	var laneXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
        	var strLaneCode = ComGetEtcData(laneXml, "laneCode");
        	//alert(strLaneCode);
        	if(isNull(strLaneCode)){
        		formObj.slan_cd.value = "";
        	}else{
        		formObj.slan_cd.value = strLaneCode;
        	}
            // Port Code Set..
//            setVVDPortCombo(sheetObj, formObj, "Vsl", false);
//            comboObjects[A].Code2				= sheetObj.CellValue(thisRow, prefix+"vps_port_cd");
        	formObj.vps_port_cd.value 			= sheetObj.CellValue(thisRow, prefix+"vps_port_cd");
            formObj.stv_dmg_evnt_dt.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_evnt_dt");
            comboObjects[0].Code2 				= sheetObj.CellValue(thisRow, prefix+"vsl_oshp_cntr_blk_tp_cd");
            formObj.clm_hndl_ofc_cd.value 		= sheetObj.CellValue(thisRow, prefix+"clm_hndl_ofc_cd");
            
            
            // Approval Permission Set..
            if(sheetObj.CellValue(thisRow, prefix+"dmg_auth_sts_cd")=="N")
            {
            	formObj.dmg_auth_sts_cd.className = "input2_red";
            	document.getElementById("btnApproval").style.color="red";
            	
            	if(approvalFlag){
        			ComBtnEnable("btn_Approval");
            	}
            	else{
        			ComBtnDisable("btn_Approval");
            	}
        	}
            else{
            	formObj.dmg_auth_sts_cd.className = "input2";
            	document.getElementById("btnApproval").style.color="#c0c0c0";
            	
            	ComBtnDisable("btn_Approval");
            }
            formObj.dmg_auth_sts_cd.value 		= sheetObj.CellValue(thisRow, prefix+"dmg_auth_sts_cd");
            formObj.auth_usr_id.value 			= sheetObj.CellValue(thisRow, prefix+"auth_usr_id");
            formObj.auth_dt.value 				= sheetObj.CellValue(thisRow, prefix+"auth_dt");
    	}
        if(gubun!="Dmg"){
        	//** OPF_STV_DMG_DTL Data Set..
            sheetObj = sheetObjects[1];
        	thisRow = sheetObj.SelectRow;
        	prefix = "sheet2_";
        	
            var cateCodeValue = sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cd");
            comboObjects[1].Code2 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cate_cd");
            stv_dmg_prt_cate_cd_OnChange(comboObjects[1], sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cate_cd"), "");
            comboObjects[2].Code2 				= cateCodeValue;
            sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cd") = cateCodeValue;
            comboObjects[3].Code2 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_tp_cd");
            formObj.stv_dmg_loc_desc.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_loc_desc");
           
            formObj.stv_dmg_rpt_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_rpt_atch_knt");
            formObj.stv_dmg_pict_atch_knt.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_pict_atch_knt");
            formObj.stv_dmg_doc_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_doc_atch_knt");
            
            if(sheetObj.CellValue(thisRow, prefix+"cntr_dmg_flg")=="Y"){
            	formObj.cntr_dmg_flg.checked = true;
            }else{
            	formObj.cntr_dmg_flg.checked = false;
            }
            if(sheetObj.CellValue(thisRow, prefix+"cgo_dmg_flg")=="Y"){
            	formObj.cgo_dmg_flg.checked = true;
            }else{
            	formObj.cgo_dmg_flg.checked = false;
            }
            formObj.cntr_no.value 	= sheetObj.CellValue(thisRow, prefix+"cntr_no");
            
        	formObj.fm_tm_lss_dt.value 		= sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt");
        	formObj.to_tm_lss_dt.value 		= sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt");
            
            formObj.time_loss_hours.value = "";
            if( !isNull(sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt"))
            	&& !isNull(sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt")))
            {
            	formObj.time_loss_hours.value = getDateHoursBetween(sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt"), sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt"));
            }
            
            formObj.stv_dmg_rmk.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_rmk");
            
            formObj.req_skd_voy_dir.value 		= sheetObj.CellValue(thisRow, prefix+"req_skd_voy_no") + sheetObj.CellValue(thisRow, prefix+"req_skd_dir_cd");
            
            if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="Q")
            {
            	formObj.stv_dmg_req_cate_cd[2].checked = true;
    			comboObjects[5].Code2 = sheetObj.CellValue(thisRow, prefix+"stv_dmg_qttn_cd");
    			formObj.req_reason_desc.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_qttn_rsn_desc");
            }
            else if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="R"){
            	formObj.stv_dmg_req_cate_cd[0].checked = true;
        	}
        	else if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="S"){
        		formObj.stv_dmg_req_cate_cd[1].checked = true;
        	}
            
            
			if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="U"){
				comboObjects[6].index = 2;
    			comboObjects[7].Code2 = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_cd");
    			formObj.res_reason_desc.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_desc");
			}else{				

				if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="T"){
					comboObjects[6].index = 0;
				}
				if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="S"){
					comboObjects[6].index = 1;
				}
				
            	formObj.stv_dmg_respb_desc_dtl.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_desc");
			}
			
			// Damage ȭ���� �Է°��� �ʵ� ����.
            dmgFormObjControl(formObj, sheetObj, false);
			
            //Requirement Port ����
            var tempReqPortCd = sheetObj.CellValue(thisRow, prefix+"req_port_cd");
            var tempReqEtaDt = sheetObj.CellValue(thisRow, prefix+"req_eta_dt");
            
            setReqPortCombo(strReqPortComboList);
            if(strReqPortComboList != ""){
        		for(var i=0 ; i < comboObjects[4].GetCount() ; i++){
        			if(tempReqPortCd == comboObjects[4].GetIndexText(i, 0) && tempReqEtaDt == comboObjects[4].GetIndexText(i, 2)){
        				formObj.req_port_cd.value = tempReqPortCd;
        				formObj.req_eta_dt.value = tempReqEtaDt;
        				comboObjects[4].Index2 = i;
        				combo_req_port_cd_OnChange(comboObjects[4], tempReqPortCd, tempReqPortCd);
        				break;
        			}
        		}
            } else {
            	formObj.req_port_cd.value = tempReqPortCd;
                formObj.req_eta_dt.value = tempReqEtaDt;
            }
	
            formObj.dmg_upd_dt.value 			= sheetObj.CellValue(thisRow, prefix+"upd_dt");
            formObj.dmg_upd_usr_id.value		= sheetObj.CellValue(thisRow, prefix+"upd_usr_id");
        }
        setSubButton(0);
    }
    
    /**
     * HTML Control�� onkeypress�̺�Ʈ���� ���� �빮�ڸ� �Է� ó���Ѵ�. <br>
     **/
    function engnum_keypress() {
    	var elementObj = event.srcElement;
    	
    	if(elementObj.name=="clm_hndl_ofc_cd"
    		|| elementObj.name=="clm_hndl_ofc_cd_cmpn"){
    		//���빮�ڸ� �Է�.
            ComKeyOnlyAlphabet('upper');
    	}
    	else{
    		//���빮�� �ڵ���ȯ
            ComKeyOnlyAlphabet('uppernum');
    	}
    }
    
    /**
     * Ư�� Data�� Max Length �Է½�, ��Ŀ�� �̵�. <br>
     **/
    function obj_keyup() {
    	ComKeyEnter('LengthNextFocus');
    	
    }

    /**
     * HTML Control�� onkeypress�̺�Ʈ���� ���ڸ� �Էµǰ� �Ѵ�. <br>
     **/
    function obj_keypress(){
    	ComKeyOnlyNumber(event.srcElement, '.');
    }
    
    /**
     * HTML Control�� onfocus�̺�Ʈ���� ����ũ �����ڸ� �����Ѵ�. <br>
     **/
    function obj_activate(){
    	 if(event.srcElement.readOnly==false){
    		 ComClearSeparator(event.srcElement);
    	     //event.srcElement.focus();
    	     event.srcElement.select();
    	 }
    }
    
    /**
     * HTML Control�� onblur�̺�Ʈ���� Validation�� üũ�Ѵ�. <br>
     **/
    function obj_deactivate(){
    	 if(event.srcElement.readOnly==false){
    		  // dataformat Validation Check!
    		 	//ComChkObjValid(event.srcElement);
    	    	var vChkObjValidFlg = ComChkObjValid(event.srcElement);
    	    	var elementObj = event.srcElement;
    	    	var formObj = document.form;
    	    	
    	    	if(elementObj.name=="stv_dmg_evnt_dt"){
    	    		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_"+elementObj.name) = elementObj.value;
    	    	}
    	    	else if(elementObj.name=="req_eta_dt")
    	    	{
    	    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_"+elementObj.name) = elementObj.value;
    	    	}
    	    	if(elementObj.name=="fm_tm_lss_dt" || elementObj.name=="to_tm_lss_dt"){
            		if(isNull(formObj.fm_tm_lss_dt.value) || isNull(formObj.to_tm_lss_dt.value)){
             			
            			formObj.time_loss_hours.value = "";
             		}
            		else{
                		formObj.time_loss_hours.value = getDateHoursBetween(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
                	}
            		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_"+elementObj.name) = elementObj.value;
            	}
    	    	else if(elementObj.name=="rpr_dt"){
    	    		//[2009-10-14] ������ ���� Damage Date ���� �۰� üũ
    	    		//sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_"+elementObj.name) = elementObj.value;
    	    		if(vChkObjValidFlg && (elementObj.value != "")){
    	    			if( ComTrimAll(formObj.stv_dmg_evnt_dt.value, "-") <= ComTrimAll(elementObj.value, "-")){
    	    				sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_"+elementObj.name) = elementObj.value;
    	    			}else{
    	    				ComShowCodeMessage("OPF50013", "Repair Date", "Damage Date");
    	    				elementObj.value = "";
    	    				ComSetFocus(elementObj);
    	    			}
    	    		}
    	    	}
    	    	else if(elementObj.name=="stv_dmg_cmpn_dt"){
    	    		sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "sheet4_"+elementObj.name) = elementObj.value;
    	    	}
    	    	else if(elementObj.name=="pay_dt"){
    	    		sheetObjects[4].CellValue(sheetObjects[4].SelectRow, "sheet5_"+elementObj.name) = elementObj.value;
    	    	}
    	 }
    }
    
    /**
     * Data �Է½� Hidden Grid�� �ش� Data Set. <br>
     **/
    function dtl_change_event() {
    	//alert("dtl_change_event");
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	var prefix = "sheet2_";
    	//alert(elementObj.name+"/"+elementObj.value);
    	
    	if(elementObj.name=="stv_dmg_respb_desc_dtl")
    	{
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = elementObj.value;
    	}
    	else if(elementObj.name=="stv_dmg_respb_desc")
    	{
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = elementObj.value;
    	}
    	else if(elementObj.name=="stv_dmg_rpt_atch_knt"
    			|| elementObj.name=="stv_dmg_pict_atch_knt"
    			|| elementObj.name=="stv_dmg_doc_atch_knt")
    	{
    		if(elementObj.value > 0){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "Y";
    			elementObj.className = "input3"
    		}else{
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "N"
    			elementObj.className = "input"
    		}
    	}
    	else if(elementObj.name=="req_reason_desc"){
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_qttn_rsn_desc") = elementObj.value;
    	}
    	else if(elementObj.name=="res_reason_desc"){
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = elementObj.value;
    	}
    	
    	
    	else if (elementObj.name=="req_port_cd") {/* req_port_cd */
    		//alert("-- : "+elementObj.value);
    		if (doActionIBSheet(sheetObj,formObj,COMMAND01,"PORT|SUB")&&!isNull(elementObj.value)){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = elementObj.value;
	         	
	    			//doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "reqPortCd");
	        		// Request Port Code �Է½�, DB���� ETA Date �����´�.
	    			//doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "etaDate");
	        	
    		} else {
    			ComShowCodeMessage("OPF50004", elementObj.value);
    			elementObj.value ="";
    			document.form.req_port_cd.focus();
    			return false;	
    			
    		}
    	}
    	else if(elementObj.name=="req_skd_voy_dir"){
    		comboObjects[4].RemoveAll();
			document.all.item("comboReqPortCd").style.display = "none";
			document.all.item("inputReqPortCd").style.display = "inline"; 
			formObj.req_port_cd.value = "";
			formObj.req_eta_dt.readOnly = false;
			formObj.req_eta_dt.className = "input";
			formObj.req_eta_dt.value = ""
  		  
		    if(!isNull(elementObj.value) && elementObj.value.length != elementObj.maxLength) {
		    	ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
  				elementObj.focus();
  				return false;
  			} else if(isNull(elementObj.value)) {
		    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_vsl_cd") = "";
		    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = "";
	    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = "";
	    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_port_cd") = "";
	    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_eta_dt") = "";
		    } else {
		    	if (doActionIBSheet(sheetObjects[1],formObj,COMMAND01,"VVD|SUB")){ /* VSL CODE�� ��ȿ�ϸ� */
		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_vsl_cd") = formObj.vsl_cd.value;
		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = elementObj.value.substring(0,4);
		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = elementObj.value.substring(4);
		    		
		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_port_cd") = "";
		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_eta_dt") = "";
		    		
//		    		formObj.req_port_cd.focus();
		    	} else {
	    			ComShowCodeMessage("OPF50004", formObj.vsl_cd.value+elementObj.value);
	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_vsl_cd") = "";
			    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = "";
		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = "";
		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_port_cd") = "";
		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_eta_dt") = "";
	    			formObj.req_skd_voy_dir.value = "";
		    		formObj.req_skd_voy_dir.focus();
	    			return false;		    		
		    	}
		    	
		    	//Requirement Port ��ȸ�Ͽ� �����ϱ�
	    		doActionIBSheet(sheetObj,formObj,COMMAND05);
	    	}
	  }
//  	  else if(elementObj.name=="req_skd_voy_dir"){
////		  alert("elementObj.value : "+elementObj.value);
////		  if(isNull(elementObj.value)){
////			 alert("null"); 
////		  }
////		  if(!isNull(elementObj.value)){
////			alert("not null");  
////		  }
//		    if(!isNull(elementObj.value) && elementObj.value.length != elementObj.maxLength)
//  			{
////		    	alert("if : ");
//		    	ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
//  				elementObj.focus();
//  				return false;
//  			}
//		    else{
////		    	alert("else : ");
//		    	if (doActionIBSheet(sheetObjects[1],formObj,COMMAND01,"VVD|SUB")){ /* VSL CODE�� ��ȿ�ϸ� */  
//		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = elementObj.value.substring(0,4);
//		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = elementObj.value.substring(4);
//		    		formObj.req_port_cd.focus();
//		    	} else if(!isNull(elementObj.value)){
//	    			ComShowCodeMessage("OPF50004", formObj.vsl_cd.value+elementObj.value);
//	    			formObj.req_skd_voy_dir.value = "";
//		    		formObj.req_skd_voy_dir.focus();
//	    			return false;		    		
//		    	}
//		    	
//		    	// 1. Port Code Combo Data �����´�.
////	      		var portFlag = setVVDPortCombo(sheetObjects[1], document.form, "Voy", true);
////	  			if(!portFlag){ return false; }
////	  			
////	  			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = elementObj.value.substring(0,4);
////	  			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = elementObj.value.substring(4);
//  			}
//	  }
    	else{
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    	}
    	
    	changeFlag = true;
    }
    
    /**
     * Checkbox Data Ŭ���� Hidden Grid�� �ش� Data Set. <br>
     **/
    function change_event_checkbox() {
    	//alert("change_event_checkbox");
    	var elementObj = event.srcElement;
    	var dataValue = "N";
    	//alert(elementObj.name+"/"+elementObj.checked);
    	if(elementObj.checked){
    		dataValue = "Y";
    	}
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_"+elementObj.name) = dataValue;
    }
    
    /**
     * Radio Button Ŭ���� �Է°��� �ʵ� ���� �� Hidden Grid�� �ش� Data Set. <br>
     **/
    function change_event_radio() {
    	//alert("change_event_radio");
    	var formObj = document.form;
    	var sheetObj = sheetObjects[1];
    	var elementObj = event.srcElement;
    	var prefix = "sheet2_";
    	
    	if(elementObj.name=="stv_dmg_req_cate_cd"){
    		
    		// Damage ȭ���� �Է� ���� �ʵ� ����.
    		dmgFormObjControl(formObj, sheetObj, true);
    		
    		// ȭ�鿡 �Է��� Data�� Grid�� Set!
        	sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    	}
    	else if(elementObj.name=="stv_dmg_respb_pty_kwn_cd"){
    		
    		// Damage ȭ���� �Է� ���� �ʵ� ����.
    		dmgFormObjControl(formObj, sheetObj, true);
    		// ȭ�鿡 �Է��� Data�� Grid�� Set!
        	sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    		
    		if(elementObj.value=="Y"){
    			if(formObj.dmg_auth_sts_cd.value != "Y"){
    				formObj.dmg_auth_sts_cd.value = "X";
        			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_dmg_auth_sts_cd") = "X";
        			
        			formObj.dmg_auth_sts_cd.className = "input2";
        			document.getElementById("btnApproval").style.color="#c0c0c0";
        			
        			if(approvalFlag){
        				formObj.auth_usr_id.value = "";
        				formObj.auth_dt.value = "";
        				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_auth_usr_id") = "";
        				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_auth_dt") = "";
        				ComBtnDisable("btn_Approval");
        			}
    			}
    			formObj.stv_dmg_respb_desc_dtl.focus();
    		}
    		else{
    			if(formObj.dmg_auth_sts_cd.value != "Y"){
    				formObj.dmg_auth_sts_cd.value = "N";
    				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_dmg_auth_sts_cd") = "N";
    				
    				formObj.dmg_auth_sts_cd.className = "input2_red";
    				document.getElementById("btnApproval").style.color="red";
    				
    				if(approvalFlag){
    					formObj.auth_usr_id.value = userId;
        				formObj.auth_dt.value = ComGetNowInfo("ymd");
        				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_auth_usr_id") = userId;
        				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_auth_dt") = ComGetNowInfo("ymd");
        				ComBtnEnable("btn_Approval");
        			}
    			}
				formObj.stv_dmg_respb_desc.focus();
    		}
    		
    	}
    	else if(elementObj.name=="stv_dmg_rpr_proc_sts_cd"){
    		
//    		alert(""+sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_"+elementObj.name) +" : "+
//    				sheetObjects[2].RowStatus(sheetObjects[2].SelectRow));
    		
        	//[2009-10-14] ������ ���� Ordered �ʱ� üũ
        	if((sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_"+elementObj.name) == "O" 
        		|| sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_"+elementObj.name) == "Q" )
        		&& sheetObjects[2].RowStatus(sheetObjects[2].SelectRow) == "I")
        	{        		
        		if(formObj.stv_dmg_rpr_proc_sts_cd[2].checked == true || formObj.stv_dmg_rpr_proc_sts_cd[3].checked == true){
		       		ComShowCodeMessage("OPF50038", "Quotation", "Ordered");        		
	        		formObj.stv_dmg_rpr_proc_sts_cd[0].checked = true;
	        		return false;
        		}
        	}        	
        		
    		changeFlag = true;
    		// ȭ�鿡 �Է��� Data�� Grid�� Set!
    		sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_"+elementObj.name) = elementObj.value;
    		// Status�� �Է� ���� �ʵ� ����.
    		rprFormObjControl(formObj);
    		
    		var procStsCd = elementObj.value;
        	if(tabObjects[0].SelectedIndex == 1 && procStsCd == "C"){// Repair Tab && Completed
        		setClaimHandlingUserProcChange("R");
        	}else{
        		setClaimHandlingUserProcChange("D");
        	}
    		
    	}
    	else if(elementObj.name=="stv_dmg_cmpn_proc_sts_cd"){
    		
        	//[2009-10-14] ������ ���� Ordered �ʱ� üũ
        	
    		// === 2010.12.15 WED ����� �ּ�ó�� ===
    		//if(sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "sheet4_"+elementObj.name) == "R" && sheetObjects[3].RowStatus(sheetObjects[3].SelectRow) == "I"){
        	//	ComShowCodeMessage("OPF50020", "Ready");        		
        	//	formObj.stv_dmg_cmpn_proc_sts_cd[0].checked = true;
        	//	return false;
        	//}
    		
    		// ȭ�鿡 �Է��� Data�� Grid�� Set!
    		sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "sheet4_"+elementObj.name) = elementObj.value;
    		// Status�� �Է� ���� �ʵ� ����.
    		cmpnFormObjControl(formObj);
    	}
    }
    
    /**
     * ���콺�� Sheet ������ ������ �� �߻��ϴ� Event function <br>
     * Sheet�� � �����̵� ���콺�� �̵� ���� �� Event�� �߻��Ѵ�.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj �ʼ� IBSheet Object
     * @param {Integer} Button �ʼ� ���콺��ư ����, 1:����, 2:������
     * @param {Integer} Shift �ʼ� ShiftŰ�� ���� ��� 1, CtrlŰ�� ���� ��� 2, �׿�0
     * @param {Long} X �ʼ� X ��ǥ
     * @param {Long} Y �ʼ� Y ��ǥ
     * @return ����
     * @version 2011.10.06
     */
	function sheet0_OnMouseMove(sheetObj, Button, Shift, X, Y)  {
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		if(Row == 1 && Col == 1) {
			sheetObj.ToolTipText(Row, Col) = sheetObj.CellText(Row, "clm_hndl_usr_nm");
		}
	}
    
    function sheet0_OnPopupClick(sheetObj, Row, Col, Value) {
 	    var formObj = document.form;
 	    
		var ofc_cd = formObj.clm_hndl_ofc_cd.value;
    	var usr_id = sheetObj.CellValue(Row, "clm_hndl_usr_id");
		var sUrl = "/hanjin/VOP_OPF_9052.do?ofc_cd=" + ofc_cd + "&usr_id=" + usr_id;
		var rtnVal = ComOpenPopup(sUrl, 1000, 500, "", "0,0", true);
		if(rtnVal == "O"){
            //Groupware �� Office Code �� 6�ڸ����� Ŭ ��� �����ϰ� �����Ѵ� 
        	for(var i=0 ; i<sheetObjects[15].RowCount ; i++){
        		if(sheetObjects[15].CellValue(i, "sheet20_clm_hndl_ofc_cd").length > 6){
        			sheetObjects[15].RowDelete(i, false);
        		}
        	}
			setClaimHandlingUser(sheetObj);
		}
    }
     
     function stv_dmg_respb_pty_kwn_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj = document.form;
 		var sheetObj = sheetObjects[0];
     	var prefix = "sheet2_";     	
     	
     	// ȭ�鿡 �Է��� Data�� Grid�� Set!
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_stv_dmg_respb_pty_kwn_cd") = comboObj.Code;
		//sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) = "U";
		if(comboObj.Code=="U"){
			formObj.stv_dmg_respb_desc_dtl.value = "";
			if(formObj.dmg_auth_sts_cd.value != "Y"){
				formObj.dmg_auth_sts_cd.value = "N";
				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_dmg_auth_sts_cd") = "N";
				
				formObj.dmg_auth_sts_cd.className = "input2_red";
				document.getElementById("btnApproval").style.color="red";
				
				if(approvalFlag){
					formObj.auth_usr_id.value = userId;
    				formObj.auth_dt.value = ComGetNowInfo("ymd");
    				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_auth_usr_id") = userId;
    				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_auth_dt") = ComGetNowInfo("ymd");
    				ComBtnEnable("btn_Approval");
    			}
			}
			
			//2011.11.10 UnKnown �� ��� ó��
			setResponsiblePartyBehind("OnChange", true);
			
			formObj.stv_dmg_respb_desc.focus();
		}
		else{
			formObj.stv_dmg_respb_desc_dtl.readOnly = false;
			formObj.stv_dmg_respb_desc_dtl.className = "input";
			formObj.stv_dmg_respb_desc.value = "";
			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = "";
			comboObjects[7].Index = "";
			comboObjects[7].Enable = false;
			formObj.res_reason_desc.readOnly = true;
			formObj.res_reason_desc.className = "input2";
			if(formObj.dmg_auth_sts_cd.value != "Y"){
				formObj.dmg_auth_sts_cd.value = "X";
    			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_dmg_auth_sts_cd") = "X";
    			
    			formObj.dmg_auth_sts_cd.className = "input2";
    			document.getElementById("btnApproval").style.color="#c0c0c0";
    			
    			if(approvalFlag){
    				formObj.auth_usr_id.value = "";
    				formObj.auth_dt.value = "";
    				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_auth_usr_id") = "";
    				sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_auth_dt") = "";
    				ComBtnDisable("btn_Approval");
    			}
			}
			//ȭ�� �ε�� ����ó��
			if(!firstLoad && unKnownFlg){
				//2011.11.10 UnKnown �� �ƴ� ��� ó��
				setResponsiblePartyBehind("OnChange", false);
			}
			formObj.stv_dmg_respb_desc_dtl.focus();
		} 
		
		// Damage ȭ���� �Է� ���� �ʵ� ����.
		dmgFormObjControl(formObj, sheetObj, true);		
     } 
     
 	/* Responsible Party ���� ���� Claim Handling Office, Claim Handling User �ļ� �۾�
 	 * 
 	 */
 	function setResponsiblePartyBehind(event, flg) {
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
// 		alert("event:"+event+"flg:"+flg);
 		switch(event) {
 			case "Search":
 				if(flg) {
 					sheetObjects[17].Editable = false;
 					sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#F3F2F8");//E9E9E9
 				}else {
 					sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#CCFFFD");
 				}
 				
 				break;
 			case "OnChange":
 				sheetObjects[17].Editable = true;
 				if(flg) {
 					formObj.clm_hndl_ofc_cd.value = "";
 					formObj.clm_hndl_ofc_cd.className = "input2";
 					sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = "";
 					sheetObjects[17].RemoveAll();
 					sheetObjects[15].RemoveAll();
 					sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#F3F2F8");
 					btnImgEnable(formObj.clm_hndl_ofc_cd_pop, false);
 				}else {
 					if(doActionIBSheet(sheetObj,formObj,COMMAND03)){
 						//Claim Handling User
 		   				if(formObj.clm_hndl_ofc_cd.value != "" && unKnownFlg){
 		   					sheetObjects[17].RowDelete(1, false);
 		   					sheetObjects[17].DataInsert(-1);
 		   					sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#CCFFFD");
 		   				}
 		   				btnImgEnable(formObj.clm_hndl_ofc_cd_pop, true);
 					}
 				}
 				break;
 		}
 		unKnownFlg = flg;
 		return;
 	}
 	
    /**
     * �̹����� �� ��ư�� Ȱ��, ��Ȱ��ȭ �Ѵ�.<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, gb);
     * </pre>
     */ 
   function btnImgEnable(obj, gb) {
       if(obj.constructor == String){
           obj = document.getElementsByName(obj)[0];        
       }
       var btnStyle = obj.style;
       
       if (gb){
           obj.Enable = true;
           btnStyle.cursor = "hand";
           btnStyle.filter="";
           obj.disabled = false;
       } else {
           obj.Enable = false;        
           btnStyle.cursor = "auto";
           btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
           obj.disabled = true;
       }
   }
    
    /**
     * vsl_oshp_cntr_blk_tp_cd Combo Data ���ý� Hidden Grid�� �ش� Data Set. <br>
     **/
    function vsl_oshp_cntr_blk_tp_cd_OnChange(comboObj, idx_cd, text) {
    	//alert("vsl_oshp_cntr_blk_tp_cd_OnChange");
    	
    	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_vsl_oshp_cntr_blk_tp_cd") = comboObj.Code;
    }
    
    /**
     * vps_port_cd Combo Data ���ý� Hidden Grid�� �ش� Data Set. <br>
     **/
    function vps_port_cd_OnChange(comboObj, idx_cd, text) {
    	//alert("vps_port_cd_OnChange");
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vps_port_cd") = comboObj.Code;
    	
    }
    
    /**
     * Category Combo Data ���ý� Part Combo List�� �ش� Data Set. <br>
     **/
    function stv_dmg_prt_cate_cd_OnChange(comboObj, idx_cd, text) {
    	//alert("stv_dmg_prt_cate_cd_OnChange");
    	var formObj = document.form;
    	var sheetObj = sheetObjects[1];
    	
    	sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_prt_cate_cd") = comboObj.Code;
    	
    	if(!isNull(comboObj.Code)){

	    	// ���õ� Category�� �ش��ϴ� Part Code ��������.
	    	formObj.f_cmd.value = SEARCH03;
	    	var categoryPartXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
	    	var categoryPart = ComGetEtcData(categoryPartXml, "catePart");
	    	
	    	if(categoryPart==null || categoryPart.length<1){
	    		//ComShowMessage("Part Code not exist.");
    			ComShowCodeMessage("OPF50009", "Part Code");
	    		comboObjects[2].RemoveAll();
	    		return false;
	    	}else{
	    		setComboItem2(comboObjects[2], categoryPart);
	    		formObj.stv_dmg_prt_cate_cd.focus();
	    		//ComSetFocus(formObj.stv_dmg_prt_cate_cd);
	    	}
    	}else{
    		comboObjects[2].RemoveAll();
    		formObj.stv_dmg_prt_cate_cd.focus();
    		//ComSetFocus(formObj.stv_dmg_prt_cate_cd);
    	}
		sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_prt_cd") = "";
    	//formObj.stv_dmg_prt_cd.focus();
    }
    
    /**
     * Part Combo Data ���ý� Hidden Grid�� �ش� Data Set. <br>
     **/
    function stv_dmg_prt_cd_OnBlur(comboObj, idx_cd, text) {
    	//alert("stv_dmg_prt_cd_OnBlur");
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_stv_dmg_prt_cd") = comboObj.Code;
    	////alert(text);
    	//document.stv_dmg_prt_cd.focus();
    }
     
    
    /**
     * Damage Combo Data ���ý� Hidden Grid�� �ش� Data Set. <br>
     **/
    function stv_dmg_tp_cd_OnChange(comboObj, idx_cd, text) {
    	//alert("stv_dmg_tp_cd_OnChange");
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_stv_dmg_tp_cd") = comboObj.Code;
    	document.form.stv_dmg_tp_cd.focus();
    	//ComSetFocus(document.form.stv_dmg_tp_cd);
    }
    
    /**
     * Combo Data ���ý� Hidden Grid �� �ش� Data Set. <br>
     **/
    function stv_dmg_qttn_rsn_desc_OnChange(comboObj, idx_cd, text) {
    	//alert("stv_dmg_qttn_rsn_desc_OnChange");
    	var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_qttn_cate_cd") = comboObj.GetText(comboObj.Code, 0);
    	sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_qttn_cd") = comboObj.GetText(comboObj.Code, 0);
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_qttn_rsn_desc") = comboObj.GetText(comboObj.Code, 1);
    	if(comboObj.Code=="TXT"){
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_qttn_rsn_desc") = "";
    		formObj.req_reason_desc.value = "";
    		formObj.req_reason_desc.className = "input1";
    		formObj.req_reason_desc.readOnly = false;
    		formObj.req_reason_desc.focus();
    	}
    	else{
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_qttn_rsn_desc") = comboObj.GetText(comboObj.Code, 1);
    		formObj.req_reason_desc.value = comboObj.GetText(comboObj.Code, 1);
    		formObj.req_reason_desc.className = "input2";
    		formObj.req_reason_desc.readOnly = true;
        	formObj.stv_dmg_qttn_rsn_desc.focus();
    	}
    }
    
    /**
     * Combo Data ���ý� Hidden Grid �� �ش� Data Set. <br>
     **/
    function stv_dmg_respb_desc_OnChange(comboObj, idx_cd, text) {
    	//alert("stv_dmg_respb_desc_OnChange");
    	var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_cate_cd") = comboObj.GetText(comboObj.Code, 0);
    	sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_respb_cd") = comboObj.GetText(comboObj.Code, 0);
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_respb_desc") = comboObj.GetText(comboObj.Code, 1);
    	if(comboObj.Code=="TXT"){
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_respb_desc") = "";
    		formObj.res_reason_desc.value = "";
    		formObj.res_reason_desc.className = "input1";
    		formObj.res_reason_desc.readOnly = false;
    		formObj.res_reason_desc.focus();
    	}
    	else{
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_respb_desc") = comboObj.GetText(comboObj.Code, 1);
    		formObj.res_reason_desc.value = comboObj.GetText(comboObj.Code, 1);
    		formObj.res_reason_desc.className = "input2";
    		formObj.res_reason_desc.readOnly = true;
        	formObj.stv_dmg_respb_desc.focus();
    	}
    }
    
    function combo_req_port_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj = document.form;
    	
    	formObj.req_port_cd.value = comboObj.Code;
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_port_cd") = formObj.req_port_cd.value;
    	formObj.req_eta_dt.value = comboObj.GetIndexText(comboObj.Index, 2);
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_eta_dt") = formObj.req_eta_dt.value;
    }
    
     /**
      * Popup Data Validation Check. <br>
      **/
     function clm_hndl_ofc_cd_pop_event(aryPopupData) {
    	 //alert("clm_hndl_ofc_cd_pop_event");
     	document.form.clm_hndl_ofc_cd.value = aryPopupData[0][3];
     	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_clm_hndl_ofc_cd") = aryPopupData[0][3];
     }
      
     /**
 	 * VVD Code Help (Pop-Up)���� ���� ����Ÿ ����.<br>
 	 * @param {arry} obj
 	 */
 	function req_skd_voy_dir_pop_event(aryPopupData) {
 		//alert("req_skd_voy_dir_pop_event");
		document.form.req_skd_voy_dir.value = aryPopupData[0][2]+aryPopupData[0][3];
		
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_vsl_cd") = aryPopupData[0][1];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = aryPopupData[0][2];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = aryPopupData[0][3];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_port_cd") = "";
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_eta_dt") = "";
		
		var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	
		comboObjects[4].RemoveAll();
		document.all.item("comboReqPortCd").style.display = "none";
		document.all.item("inputReqPortCd").style.display = "inline"; 
		formObj.req_port_cd.value = "";
		formObj.req_eta_dt.readOnly = false;
		formObj.req_eta_dt.className = "input";
		formObj.req_eta_dt.value = ""
		
		//Requirement Port ��ȸ�Ͽ� �����ϱ�
		doActionIBSheet(sheetObj,formObj,COMMAND05);
		
//		document.form.req_port_cd.focus();
		//ComSetFocus(document.form.req_port_cd);
		
		//Voyage Dir Code �Է½� req Port Code Combo Data �����´�.
//		setVVDPortCombo(sheetObjects[1], document.form, "Voy", true);
 	}
     
     /**
      * Text Form Object�� Focus������ �� ����. <br>
      **/
     function focus_event() {
    	 var elementObj = event.srcElement;
    	 if(elementObj.readOnly==false){
    	     elementObj.select();
    	 }
     }
     
     /**
      * Text Form Object�� Focus������ �� ����. <br>
      **/
     function blur_event() {
    	  var elementObj = event.srcElement;
    	  var formObj = document.form;
    	  
    	  if(elementObj.name=="clm_hndl_ofc_cd"){
    		  
    		  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_clm_hndl_ofc_cd") = elementObj.value;
    		    
	      }
//    	  else if(elementObj.name=="req_skd_voy_dir"){
////    		  alert("elementObj.value : "+elementObj.value);
////    		  if(isNull(elementObj.value)){
////    			 alert("null"); 
////    		  }
////    		  if(!isNull(elementObj.value)){
////    			alert("not null");  
////    		  }
//    		    if(!isNull(elementObj.value) && elementObj.value.length != elementObj.maxLength)
//	  			{
////    		    	alert("if : ");
//    		    	ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
//	  				elementObj.focus();
//	  				return false;
//	  			}
//    		    else{
////    		    	alert("else : ");
//    		    	if (doActionIBSheet(sheetObjects[1],formObj,COMMAND01,"VVD|SUB")){ /* VSL CODE�� ��ȿ�ϸ� */  
//    		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = elementObj.value.substring(0,4);
//    		    		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = elementObj.value.substring(4);
//    		    		formObj.req_port_cd.focus();
//    		    	} else if(!isNull(elementObj.value)){
//    	    			ComShowCodeMessage("OPF50004", formObj.vsl_cd.value+elementObj.value);
//    	    			formObj.req_skd_voy_dir.value = "";
//    		    		formObj.req_skd_voy_dir.focus();
//    	    			return false;		    		
//    		    	}
//    		    	
//    		    	// 1. Port Code Combo Data �����´�.
////    	      		var portFlag = setVVDPortCombo(sheetObjects[1], document.form, "Voy", true);
////    	  			if(!portFlag){ return false; }
////    	  			
////    	  			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = elementObj.value.substring(0,4);
////    	  			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = elementObj.value.substring(4);
//	  			}
//    	  }
    	  else if(elementObj.name=="rpr_port_cd"){
    		  //alert(0);
    		  if(!isNull(elementObj.value) && elementObj.value.length != elementObj.maxLength)
	  			{
    			  //alert(1);
  		    		ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
	  				elementObj.select();
	  				return false;
	  			}
  		    	else{
  		    		//alert(2);
  		    		sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_"+elementObj.name) = elementObj.value;
  		    	}
	      }
    	  elementObj.value = elementObj.value;
     }
    
    /**
     * VVD Code Data �Է½� VVD Port Combo Data Set. <br>
     **/
    function setVVDPortCombo(sheetObj, formObj, gubun, isUpdate) {
    	//alert("setVVDPortCombo");
    	//Combo ������ �ʱ�ȭ.
    	var prefix = null;
    	var comboObj = null;
//    	if(gubun=="Vsl"){
//    		prefix = "sheet1_"
//    		comboObj = comboObjects[A];
//    		//formObj.slan_cd.value = "";
//    	}
//    	else if(gubun=="Voy"){
//    		prefix = "sheet2_"
//    		comboObj = comboObjects[44];
//    	}
    	//Combo ������ ��ȸ.
    	formObj.f_cmd.value = SEARCH01;
    	var portXml = null;
    	if(gubun=="Vsl"){
    		portXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq" , FormQueryString(formObj));
    	}
    	else if(gubun=="Voy"){
    		var voyNo = formObj.req_skd_voy_dir.value.substring(0,4);
    		var dirCd = formObj.req_skd_voy_dir.value.substring(4);
    		portXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq&skd_voy_no="+voyNo+"&skd_dir_cd="+dirCd , FormQueryString(formObj));
    	}
    	var strPortCdList = ComGetEtcData(portXml, "vvdPortComboList");
    		if(gubun=="Vsl"){
    			if(isUpdate){
    				comboObj.Index = "-1";
        			sheetObj.CellValue(sheetObj.SelectRow, prefix+"vps_port_cd") = "";
    			}
        		setComboItem(comboObj,strPortCdList);
        		formObj.vps_port_cd.focus();
        		return;
    		}
    		else if(gubun=="Voy"){
    			if(isUpdate){
    				comboObj.Index = "-1";
        			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
        			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
        			formObj.req_eta_dt.value = "";
    			}
        		setComboItem(comboObj,strPortCdList);
        		formObj.req_port_cd.focus();
        		return;
    		}
    }
    
    /**
     * �޺��ʵ忡 �����͸� �߰����ش�.
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList = comboItems.split("|");
        	
        	for (var i = 0 ; i < dataList.length ; i++) {
        		
        		var comboItem = dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
        	}
    	}
    }
    
    /**
     * �޺��ʵ忡 �����͸� �߰����ش�.
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList = comboItems.split("|");
        	
        	for (var i = 0 ; i < dataList.length ; i++) {
        		
        		var comboItem = dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
        	}
    	}
    }
    
    /**
     * �޺��ʵ忡 �����͸� �߰����ش�.
     */	
    function setComboItem3(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList = comboItems.split("|");
        	
        	for (var i = 0 ; i < dataList.length ; i++) {
        		
        		var comboItem = dataList[i].split(",");
        		//comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[1]);
        		comboObj.InsertItem(i, comboItem[1]+"|"+comboItem[2], comboItem[1]);
        	}
    	}
    }
    

	/**
	 * �˾� IBSheet�� ���ε��ϰ��� ������ ���ϵ��� IBUpload�� �߰��Ѵ�.
	 * File Upload..
	 **/
	function setFileUpload(popSheetObj, stvDmgAtchFileTpCd, stvDmgProcCd) {

		var formObj = document.form;
		var uploadObj = uploadObjects[0];
		var mastSheetObj;		
		var mastPrefix;
		var sheetObj;
		var prefix;
		var stvDmgAtchFlg= "";
		
		if(stvDmgProcCd == "D"){
			
			//RowStatus ���� I�� �ƴϸ� �⺻���� U ����
			if(sheetObjects[1].RowStatus(1) != "I"){
				sheetObjects[1].RowStatus(1) = "U";
			}
			
			if(stvDmgAtchFileTpCd == "SDR"){
				mastSheetObj = sheetObjects[1];
				mastPrefix = "sheet2_";
				sheetObj = sheetObjects[6];
				prefix ="sheet7_";
				stvDmgAtchFlg = "stv_dmg_rpt_atch";
			}else if(stvDmgAtchFileTpCd == "PIC"){
				mastSheetObj = sheetObjects[1];
				mastPrefix = "sheet2_";
				sheetObj  = sheetObjects[7];
				prefix="sheet8_";
				stvDmgAtchFlg = "stv_dmg_pict_atch";
			}else if(stvDmgAtchFileTpCd == "DOC"){
				mastSheetObj = sheetObjects[1];
				mastPrefix = "sheet2_";
				sheetObj  = sheetObjects[8];
				prefix="sheet9_";
				stvDmgAtchFlg = "stv_dmg_doc_atch";
			}		
		}else if(stvDmgProcCd == "R"){
			if(stvDmgAtchFileTpCd == "RES"){
				mastSheetObj = sheetObjects[2];
				mastPrefix = "sheet3_";
				sheetObj = sheetObjects[9];
				prefix ="sheet10_";
				stvDmgAtchFlg = "rpr_rslt_rpt_atch";
			}else if(stvDmgAtchFileTpCd == "INV"){
				mastSheetObj = sheetObjects[2];
				mastPrefix = "sheet3_";
				sheetObj = sheetObjects[10];
				prefix ="sheet11_";
				stvDmgAtchFlg = "rpr_inv_atch";
			}else if(stvDmgAtchFileTpCd == "PIC"){
				mastSheetObj = sheetObjects[2];
				mastPrefix = "sheet3_";
				sheetObj = sheetObjects[11];
				prefix ="sheet12_";
				stvDmgAtchFlg = "rpr_pict_atch";
			}else if(stvDmgAtchFileTpCd == "DOC"){
				mastSheetObj = sheetObjects[2];
				mastPrefix = "sheet3_";
				sheetObj = sheetObjects[12];
				prefix ="sheet13_";
				stvDmgAtchFlg = "rpr_doc_atch";
			}			
		}else if(stvDmgProcCd == "S"){
			
			//RowStatus ���� I�� �ƴϸ� �⺻���� U ����
			if(sheetObjects[4].RowStatus(1) != "I"){
				sheetObjects[4].RowStatus(1) = "U";
			}
			
			if(stvDmgAtchFileTpCd == "INV"){
				mastSheetObj = sheetObjects[4];
				mastPrefix = "sheet5_";
				sheetObj = sheetObjects[13];
				prefix ="sheet14_";
				stvDmgAtchFlg = "stl_inv_atch";
			}else if(stvDmgAtchFileTpCd == "DOC"){
				mastSheetObj = sheetObjects[4];
				mastPrefix = "sheet5_";
				sheetObj = sheetObjects[14];
				prefix ="sheet15_";
				stvDmgAtchFlg = "stl_doc_atch";
			}			
		}
		
		//stv_dmg_no ���� �ڵ� ����
		if(popSheetObj.RowCount > 0 ){
			/*if(sheetObj.RowCount > 0){
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++ ){
					if(sheetObj.CellValue(i, prefix+"stv_dmg_no") == popSheetObj.CellValue(1, "stv_dmg_no")){
						sheetObj.RowDelete(i, false);
					}
				}
			}
			//�޾ƿ� ����Ÿ ����
			for(var j=popSheetObj.HeaderRows; j<=popSheetObj.LastRow; j++ ){
				var addRow = sheetObj.DataInsert(-1);
				for(var cnt=0 ; cnt < 12 ; cnt++){
					sheetObj.CellValue(addRow, cnt) = popSheetObj.CellValue(j, cnt);
				}
			}*/
			sheetObj.RemoveAll();  
    		var sXml = IBS_GetDataSearchXml(popSheetObj);
			sheetObj.LoadSearchXml(sXml);			
		}
		
		var file_cnt = 0;
		for (var rowIdx=1; rowIdx<=popSheetObj.LastRow; rowIdx++){ 

			var delFlag   = popSheetObj.CellValue(rowIdx, "deleteFlag");
			var ibFlag    = popSheetObj.RowStatus(rowIdx);
			//alert(ibFlag);
			//���� ��� ��������
			var sFile = popSheetObj.CellValue(rowIdx, "file_sav_id");
			if (sFile==""){
    			ComShowCodeMessage("OPF50009", "File name");
			}

			if(delFlag == 'Y'){
				with(sheetObj){
		    		if(RowStatus(rowIdx)=="I"){
		    			var sFile = CellValue(rowIdx, "file_sav_id");
		        		uploadObjects[0].DeleteFile(sFile);
		        		
		    			RowStatus(rowIdx) = "D";
		    		}
		    		else{
		    			if(RowStatus(rowIdx)=="U"){
		    				var sFile = CellValue(rowIdx, "file_sav_id");
		            		uploadObjects[0].DeleteFile(sFile);
		    			}
		    			RowStatus(rowIdx) = "D";
		    		}
		    	}
			}
			else{
			//if(ibFlag != 'D'){
				if(ibFlag=='I' || ibFlag=='U'){
					//IBUpload�� ���� �߰��ϱ�
					var ret = uploadObj.AddFile(sFile);
				}
				file_cnt++;
			}
		}
		
		// ���� ���� ����
		eval("formObj."+stvDmgAtchFlg+"_knt").value = file_cnt;
		mastSheetObj.CellValue(mastSheetObj.SelectRow, mastPrefix + stvDmgAtchFlg+"_knt") = file_cnt;

		if(file_cnt > 0){
			mastSheetObj.CellValue(mastSheetObj.SelectRow, mastPrefix + stvDmgAtchFlg+"_flg") = "Y";
		}else{
			mastSheetObj.CellValue(mastSheetObj.SelectRow, mastPrefix + stvDmgAtchFlg+"_flg") = "N";
		}
		
		// Filed Style Set.
		if(file_cnt > 0){
			eval("formObj."+stvDmgAtchFlg+"_knt").className = "input3"
    	}else{
    		eval("formObj."+stvDmgAtchFlg+"_knt").className = "input"
    	}
		
		return; 
	}
	
	/**
	 * ���ε�� Hidden IBSheet�� ������ �����´�.
	 **/
	function getFileUpload(strFlag, stvDmgProcCd) {
		if(stvDmgProcCd == "D"){
			if(strFlag=="SDR"){
				return sheetObjects[6];
			}else if(strFlag=="PIC"){
				return sheetObjects[7];
			}else if(strFlag=="DOC"){
				return sheetObjects[8];
			}
		}else if(stvDmgProcCd == "R"){
			if(strFlag=="RES"){
				return sheetObjects[9];
			}else if(strFlag=="INV"){
				return sheetObjects[10];
			}else if(strFlag=="PIC"){
				return sheetObjects[11];
			}else if(strFlag=="DOC"){
				return sheetObjects[12];
			}
		}else if(stvDmgProcCd == "S"){
			if(strFlag=="INV"){
				return sheetObjects[13];
			}else if(strFlag=="DOC"){
				return sheetObjects[14];
			}			
		}
	}    
    
    
    /**
     * ��Ʈ �ʱ⼳����, ��� ����
     * param : sheetObj ==> ��Ʈ������Ʈ, sheetNo ==> ��Ʈ������Ʈ �±��� ���̵� ���� �Ϸù�ȣ
     * ��Ʈ�� �ټ��� ��� ��Ʈ ����ŭ case�� �߰��Ͽ� ��Ʈ �ʱ�ȭ����� �����Ѵ�
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    //���� ����
                    style.height = 100;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VPS_PORT_CD|STV_DMG_EVNT_DT|VSL_OSHP_CNTR_BLK_TP_CD|STV_DMG_REF_NO|CLM_HNDL_OFC_CD|DMG_AUTH_STS_CD|AUTH_USR_ID|AUTH_DT|UPD_USR_ID|UPD_DT|CRE_USR_ID";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet1_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vsl_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"skd_voy_no",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"skd_dir_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vps_port_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_evnt_dt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vsl_oshp_cntr_blk_tp_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_ref_no",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_ofc_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"dmg_auth_sts_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"auth_usr_id",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"auth_dt",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cre_usr_id",			false,	"",		dfNone,		0,	true,	true);
                    
				}
                break;
                
            case "sheet2":
                with (sheetObj) {

                    // ���� ����
                    style.height = 100;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|STV_DMG_PRT_CATE_CD|STV_DMG_PRT_CD|STEVEDORE DAMAGE TYPE CODE|STV_DMG_LOC_DESC|STV_DMG_RPT_ATCH_FLG|STV_DMG_PICT_ATCH_FLG";
                    HeadTitle += "|STV_DMG_DOC_ATCH_FLG|CNTR_DMG_FLG|CGO_DMG_FLG|CNTR_NO|FM_TM_LSS_DT|TO_TM_LSS_DT|STV_DMG_RMK|STV_DMG_REQ_CATE_CD|REQ_VSL_CD|REQ_SKD_VOY_NO";
                    HeadTitle += "|REQ_SKD_DIR_CD|REQ_PORT_CD|REQ_ETA_DT|STV_DMG_QTTN_CD|STV_DMG_QTTN_RSN_DESC|STV_DMG_RESPB_PTY_KWN_CD|STV_DMG_RESPB_CD|STV_DMG_RESPB_DESC|UPD_USR_ID|UPD_DT";
                    HeadTitle += "|stv_dmg_rpt_atch_knt|stv_dmg_pict_atch_knt|stv_dmg_doc_atch_knt";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet2_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_prt_cate_cd",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_prt_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_tp_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_loc_desc", 		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_rpt_atch_flg", 	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_pict_atch_flg",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_doc_atch_flg", 	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cntr_dmg_flg",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cgo_dmg_flg",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cntr_no",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"fm_tm_lss_dt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"to_tm_lss_dt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_rmk",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_req_cate_cd",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_vsl_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_skd_voy_no",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_skd_dir_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_port_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_eta_dt",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_qttn_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_qttn_rsn_desc", false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_pty_kwn_cd",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_cd",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_desc",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",  				false,	"",		dfNone,		0,	true,	true);

                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_rpt_atch_knt",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_pict_atch_knt",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_doc_atch_knt",	false,	"",		dfNone,		0,	true,	true);
				}
                break;
                
            case "sheet3":
                with (sheetObj) {

                    // ���� ����
                    style.height = 150;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|STV_DMG_RPR_SEQ|STV_DMG_RPR_PROC_STS_CD|QTTN_LOCL_CURR_CD|QTTN_COST_LOCL_AMT|QTTN_COST_USD_AMT|RPR_PORT_CD|RPR_DT";
                    HeadTitle += "|RPR_VNDR_NM|USTL_ACCT_NO|RUN_RPR_ACCT_NO|RPR_COST_USD_AMT|RPR_RSLT_RPT_ATCH_FLG|RPR_INV_ATCH_FLG|RPR_PICT_ATCH_FLG|RPR_DOC_ATCH_FLG";
                    HeadTitle += "|RPR_RMK|UPD_USR_ID|UPD_DT";
                    HeadTitle += "|rpr_rslt_rpt_atch_knt|rpr_inv_atch_knt|rpr_pict_atch_knt|rpr_doc_atch_knt";
                    
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet3_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtDataSeq,	30,	daCenter,	false,	prefix+"stv_dmg_rpr_seq");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_rpr_proc_sts_cd",  	false,	"",		dfNone,		0,	true,	true);
                    //InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_cost_usd_amt",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"qttn_locl_curr_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"qttn_cost_locl_amt",  		false,	"",		dfFloat,	2,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"qttn_cost_usd_amt",  		false,	"",		dfFloat,	2,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_port_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_dt",  					false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_vndr_nm",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"ustl_acct_no",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"run_rpr_acct_no",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_cost_usd_amt",  		false,	"",		dfFloat,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_rslt_rpt_atch_flg",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_inv_atch_flg",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_pict_atch_flg",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_doc_atch_flg",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_rmk",  					false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",  					false,	"",		dfNone,		0,	true,	true);
                    
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_rslt_rpt_atch_knt",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_inv_atch_knt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_pict_atch_knt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_doc_atch_knt",  		false,	"",		dfNone,		0,	true,	true);
                    
				}
                break;
                
            case "sheet4":
                with (sheetObj) {

                    // ���� ����
                    style.height = 100;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|STV_DMG_CMPN_PROC_STS_CD|CLM_HNDL_OFC_CD|CLM_HNDL_USR_ID|CLM_HNDL_USR_NM|STV_DMG_RESPB_PTY_CO_NM|STV_DMG_RESPB_PTY_PIC_NM|STV_DMG_RESPB_PTY_PIC_TIT_NM|STV_DMG_CMPN_DT|CMPN_CURR_CD|CMPN_COST_LOCL_AMT|CMPN_COST_USD_AMT|CMPN_ACCT_NO|CMPN_RMK|UPD_USR_ID|UPD_DT";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet4_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  					false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_cmpn_proc_sts_cd",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_ofc_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_usr_id",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_usr_nm",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_pty_co_nm",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_pty_pic_nm",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_pty_pic_tit_nm",  false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_cmpn_dt",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_curr_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_cost_locl_amt",  			false,	"",		dfFloat,		2,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_cost_usd_amt",  			false,	"",		dfFloat,		2,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_acct_no",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_rmk",  					false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",  					false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",  						false,	"",		dfNone,		0,	true,	true);
                    
				}
                break;
                
            case "sheet5":
                with (sheetObj) {

                    // ���� ����
                    style.height = 100;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|SHP_OWNR_CO_NM|USTL_ACCT_NO|RUN_RPR_ACCT_NO|BIL_INV_NO|PAY_DT|PAY_CURR_CD|PAY_LOCL_AMT|PAY_USD_AMT|STL_INV_ATCH_FLG|STL_DOC_ATCH_FLG|STL_RMK|UPD_USR_ID|UPD_DT|stl_inv_atch_knt|stl_doc_atch_knt";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet5_";
                    InitDataProperty(0, cnt++ , dtStatus, 30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"shp_ownr_co_nm",	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"ustl_acct_no",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"run_rpr_acct_no",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"bil_inv_no",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"pay_dt",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"pay_curr_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"pay_locl_amt",		false,	"",		dfFloat,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"pay_usd_amt",		false,	"",		dfFloat,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stl_inv_atch_flg",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stl_doc_atch_flg",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stl_rmk",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stl_inv_atch_knt",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stl_doc_atch_knt",	false,	"",		dfNone,		0,	true,	true);
				}
                break;
                
            case "sheet7":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet7_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;
                
            case "sheet8":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet8_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;                

            case "sheet9":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet9_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;                

            case "sheet10":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet10_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;                
                
            case "sheet11":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet11_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;                
                
            case "sheet12":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet12_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;                
                
            case "sheet13":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet13_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;                

            case "sheet14":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet14_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;                
                
            case "sheet15":
                with (sheetObj) {
                	// ���� ����
                    style.height = 130;
                    //��ü �ʺ� ����
                    SheetWidth = mainTable.clientWidth;

                    //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //��üMerge ���� [����, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //��üEdit ��� ���� [����, Default false]
                    Editable = true;

                    //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                    InitHeadMode(true, true, false, true, false,false);

                    //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //�����ͼӼ�    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet15_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;                
                
         	case "sheet0":	//Claim Handling User
         		with (sheetObj) {
                     // ���� ����
                     style.height = 25;
                     //��ü �ʺ� ����
                     SheetWidth = mainTable.clientWidth;

                     //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //��üMerge ���� [����, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //��üEdit ��� ���� [����, Default false]
                     Editable = true;

                     //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 1, 100);

                     var HeadTitle = "|Name";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                     InitHeadMode(false, true, true, true, false,false);

                     //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, false, true);

					 //�����ͼӼ�    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,40,		daCenter,	false,		"ibflag");
					 InitDataProperty(0, cnt++ , dtPopup,  		130,    daLeft,		false,      "clm_hndl_usr_nm", 	true,    	"",	dfNone,	0,	false);
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"stv_dmg_no");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"stv_dmg_proc_cd");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"stv_dmg_eml_snd_seq");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"clm_hndl_ofc_cd");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"clm_hndl_usr_id");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"clm_hndl_usr_eml");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"eml_snd_no");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"eml_snd_dt");
					 
					 ToolTipOption = "balloon:true;width:1000;icon:1;title:Name";
					 
					 ShowButtonImage = 1;
					 CountPosition = 0;
					 AutoRowHeight = false;
					 WaitImageVisible = false;

         		}
              	break;
              	
         	case "sheet20":	//Claim Handling User
         		with (sheetObj) {
                     // ���� ����
                     style.height = 100;
                     //��ü �ʺ� ����
                     SheetWidth = mainTable.clientWidth;

                     //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //��üMerge ���� [����, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //��üEdit ��� ���� [����, Default false]
                     Editable = true;

                     //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle = "|Name|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                     InitHeadMode(true, true, false, true, false,false);

                     //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

					 //�����ͼӼ�    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     var prefix="sheet20_";
					 InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	false,		prefix+"ibflag");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_no");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_proc_cd");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_eml_snd_seq");
					 InitDataProperty(0, cnt++ , dtData,  		20,		daCenter,   false,      prefix+"clm_hndl_usr_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_ofc_cd");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_ofc_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"grd_eng_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_usr_eml");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"eml_snd_no");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"eml_snd_dt");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_eml_snd_seq");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"cre_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"cre_dt");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"upd_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"upd_dt");
					 
					 ShowButtonImage = 1;
					 CountPosition = 0;
					 AutoRowHeight = false;
					 WaitImageVisible = false;

         		}
              	break;
              	
         	case "sheet21":	//Claim Handling User
         		with (sheetObj) {
                     // ���� ����
                     style.height = 100;
                     //��ü �ʺ� ����
                     SheetWidth = mainTable.clientWidth;

                     //Host���� ����[�ʼ�][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //��üMerge ���� [����, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //��üEdit ��� ���� [����, Default false]
                     Editable = true;

                     //����������[�ʼ�][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle = "|Name|1|2|3|4|5|6|7|8|9|10|11|12|13|14";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //�÷���������[�ʼ�][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // �ش����� ó���� �� �ִ� ���� ����� �����Ѵ�
                     InitHeadMode(true, true, false, true, false,false);

                     //�ش�������[�ʼ�][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

					 //�����ͼӼ�    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     var prefix="sheet20_";
					 InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	false,		prefix+"ibflag");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_no");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_proc_cd");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_eml_snd_seq");
					 InitDataProperty(0, cnt++ , dtData,  		20,		daCenter,   false,      prefix+"clm_hndl_usr_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_ofc_cd");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_ofc_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_usr_eml");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"eml_snd_no");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"eml_snd_dt");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_eml_snd_seq");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"cre_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"cre_dt");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"upd_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"upd_dt");
					 
					 ShowButtonImage = 1;
					 CountPosition = 0;
					 AutoRowHeight = false;
					 WaitImageVisible = false;

         		}
              	break;
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction, strFlag) {
    	  sheetObj.ShowDebugMsg = false;
    	    switch(sAction) {
    	    	case COMMAND01:
	    	    	formObj.f_cmd.value = COMMAND01;
					var str_tmp = strFlag.split("|");//str_tmp[0]:VSL,VVD,PORT,LANE�� ������ str_tmp[1] : port���� 
					var vsl_cd="";
					var voy_no="";
					var dir_cd="";
					var port_cd="";
					var lane_cd="";
					var result="";
					if (str_tmp[1] =='MAIN'){
						vsl_cd = formObj.vsl_cd.value;
						voy_no = formObj.skd_voy_no.value;
						dir_cd = formObj.skd_dir_cd.value;
						port_cd = formObj.vps_port_cd.value;
						lane_cd = formObj.slan_cd.value;    	    		  
					} else { /* sub */
						vsl_cd = formObj.vsl_cd.value;
						voy_no = formObj.req_skd_voy_dir.value.substring(0,4);
						dir_cd = formObj.req_skd_voy_dir.value.substring(4);
						port_cd = formObj.req_port_cd.value;
					}
					//  	    	  alert("dd");
					var resultXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND01+"&auto_skd_cng_flg="+str_tmp[0]+"&vsl_cd="+vsl_cd+"&skd_voy_no="+voy_no+"&skd_dir_cd="+dir_cd+"&vps_port_cd="+port_cd+"&slan_cd="+lane_cd);
					 
					result = ComGetEtcData(resultXml, "result_chk");
					//  	    	  alert(result);
					if (result==null ||result =="null"|| result=="" || result==undefined){					
						return false;
					} else {
						return true;
					}
					break;
					
    	      case COMMAND03:
    	    	  var port_cd = formObj.vps_port_cd.value;
    	    	  formObj.f_cmd.value = COMMAND03;
    	    	  var resultXml = sheetObj.GetSearchXml("VOP_OPF_1053GS.do?f_cmd="+COMMAND03+"&vps_port_cd="+port_cd);
    	    	  var ofcCd = ComGetEtcData(resultXml, "ofcCd");
    	    	  //Claim Handling Office
    	    	  if(ofcCd != null){
					  formObj.clm_hndl_ofc_cd.value = ofcCd;
					  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = ofcCd;
	    	    	  return true;
    	    	  }
    	    	  break;
    	    	  
  			case COMMAND05:
				formObj.f_cmd.value = COMMAND05;
				var vsl_cd = formObj.vsl_cd.value;
   	    	 	var voy_no = formObj.req_skd_voy_dir.value.substring(0, 4);
   	    	 	var dir_cd = formObj.req_skd_voy_dir.value.substring(4);
				var resultXml = sheetObj.GetSearchXml("VOP_OPF_1053GS.do?f_cmd="+COMMAND05+"&vsl_cd="+vsl_cd+"&voy_no="+voy_no+"&dir_cd="+dir_cd);
				var strReqPortComboList = ComGetEtcData(resultXml, "reqPortComboList");
				
				// Requirment Port Code ��������
				setReqPortCombo(strReqPortComboList);
				break;
  	    	  
    	      case IBSEARCH:      //��ȸ
    	    	  var sheetID = sheetObj.id;
    	    	  
    	    	  if(strFlag=="All"){
    	    		  	formObj.f_cmd.value = SEARCH;
    	    		  	
    	    		  	uploadObjects[0].Files=""; // ���������� ��� �����.
    	    		  	
    	    	    	var aryPrefix = new Array("sheet1_","sheet2_","sheet3_","sheet4_","sheet5_", "sheet7_", "sheet8_", "sheet9_", "sheet10_", "sheet11_", "sheet12_", "sheet13_", "sheet14_", "sheet15_", "sheet20_");
    	  	    		var sXml = sheetObj.GetSearchXml("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&stv_dmg_proc_cd=D" + "&" + ComGetPrefixParam(aryPrefix));
    	  	    		var arrXml = sXml.split("|$$|");
    	              	
    	              	if (arrXml.length > 0) {
    	              		sheetObjects[0].LoadSearchXml(arrXml[0]);
    	              		firstReqPortComboList = ComGetEtcData(arrXml[0], "reqPortComboList");
    	              	}
    	              	if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
    	              	if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
    	              	if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);
    	              	if (arrXml.length > 4) sheetObjects[4].LoadSearchXml(arrXml[4]);
    	              	
    	              	if (arrXml.length > 5) sheetObjects[6].LoadSearchXml(arrXml[5]);
    	              	if (arrXml.length > 6) sheetObjects[7].LoadSearchXml(arrXml[6]);
    	              	if (arrXml.length > 7) sheetObjects[8].LoadSearchXml(arrXml[7]);

    	              	if (arrXml.length > 8) sheetObjects[9].LoadSearchXml(arrXml[8]);
    	              	if (arrXml.length > 9) sheetObjects[10].LoadSearchXml(arrXml[9]);
    	              	if (arrXml.length > 10) sheetObjects[11].LoadSearchXml(arrXml[10]);
    	              	if (arrXml.length > 11) sheetObjects[12].LoadSearchXml(arrXml[11]);

    	              	if (arrXml.length > 12) sheetObjects[13].LoadSearchXml(arrXml[12]);
    	              	if (arrXml.length > 13) sheetObjects[14].LoadSearchXml(arrXml[13]);
    	              	
    	              	//Default ComboData Set..
    	              	setDefaultComboData(arrXml[0]);
    	              	
    	              	//Claim Handling User ����
    	              	if (arrXml.length > 14) {
    	              		sheetObjects[15].LoadSearchXml(arrXml[14]);
    	              		sheetObjects[16].LoadSearchXml(arrXml[14]);
    	              		
    	   					//2011.11.10 UnKnown �� ��� ó��
    	  					if(sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_respb_pty_kwn_cd") == "U") {
    	  						setResponsiblePartyBehind("Search", true);
    	  					}else {
    	  						sheetObjects[17].RowDelete(1, false);
    	  	   					sheetObjects[17].DataInsert(-1);
    	  	   					
    	  						setResponsiblePartyBehind("Search", false);
    	  					}
    	              		
    	              		setClaimHandlingUser(sheetObjects[17]);
    	              	}
    	              	
    	              	//Approval permission Set..
    	              	//if(ComGetEtcData(arrXml[0], "approvalPermission")=="1"){
    	              	//if(userId=="8804820" || userId=="8803631"){
    	              	if(userId=="8804820" || userId=="8701113"){    	              		
    	              		approvalFlag = true;
    	              	}
    	              	//Repair Default Currency Set..
    	              	dfCurrency = ComGetEtcData(arrXml[0], "defaultCurrency");
    	    	  }
    	    	  else if(sheetID=="sheet1"){
    	    		  //alert("222"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH01;
    	    		  sheetObjects[0].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
    	    		  setDisplayData(formObj, "Dmg", "");
    	    	  }
    	    	  else if(sheetID=="sheet2"){
    	    		  //alert("333"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH02;
    	    		  var sXml = sheetObjects[1].GetSearchXml("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
    	    		  sheetObjects[1].LoadSearchXml(sXml);
    	    		  
    	    		  setDisplayData(formObj, "Dtl", "");
    	    	  }
    	    	  else if(sheetID=="sheet3"){
    	    		  //alert("444"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH03;
    	    		  sheetObjects[2].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
    	    		  if(sheetObjects[2].RowCount > 0){
        	    		  setRprDisplayData(formObj);
    	    		  }else{
    	    			  initDefaultSheet(formObj, "Rpr");
    	    			  // Grid Data�� ȭ�鿡 Set..
    	                  setRprDisplayData(formObj);
    	    		  }
    	    	  }
    	    	  else if(sheetID=="sheet4"){
    	    		  //alert("555"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH04;
    	    		  sheetObjects[3].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet4_"));
    	    		  if(sheetObjects[3].RowCount > 0){
    	    			  setCmpnDisplayData(formObj);
    	    		  }else{
    	    			  initDefaultSheet(formObj, "Cmpn");
    	    			  // Grid Data�� ȭ�鿡 Set..
    	    			  setCmpnDisplayData(formObj);
    	    		  }
    	    	  }
    	    	  else if(sheetID=="sheet5"){
    	    		  //alert("666"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH05;
    	    		  sheetObjects[4].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet5_"));
    	    		  if(sheetObjects[4].RowCount > 0){
    	    			  setStlDisplayData(formObj);
    	    		  }
    	    		  else{
    	    			  //initDefaultSheet(formObj, "Stl");
    	    			  setStlDatareadOnly(formObj);
    	    		  }
    	    	  }
    	        break;
    	        
    	      case IBROWSEARCH:
    	    	  if(strFlag=="dmgDate"){
    	    		  formObj.f_cmd.value = SEARCH06;
    	    		  var dateXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
    	    		  
    	    		  var etdDate = ComGetEtcData(dateXml, "etd_date");
    	    		  
    	    		  if(isNull(etdDate)){
    	    			  //ComShowMessage("ETD DB Data is not exist.");
    	      			  ComShowCodeMessage("OPF50009", "ETD DB Data");
  						  return;
    	    		  }else{
    	    			  var dateFlag = ComGetDaysBetween(formObj.stv_dmg_evnt_dt.value, etdDate);
    	    			  if(dateFlag < 0){
    	    				  //ComShowMessage("Damage Date must be earlier than ETD Date("+etdDate+").");
        	      			  ComShowCodeMessage("OPF50013", "ETD Date("+etdDate+")", "Damage Date");
    	    				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_evnt_dt") = "";
        	    			  formObj.stv_dmg_evnt_dt.value = "";
        	    			  formObj.stv_dmg_evnt_dt.focus();
        	    			  return false;
    	    			  }
    	    			  else{
    	    				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_evnt_dt") = formObj.stv_dmg_evnt_dt.value;
    	    				  formObj.vsl_oshp_cntr_blk_tp_cd.focus();
    	    			  }
    	    		  }
    	    	  }
//    	    	  if(strFlag=="etaDate"){
//    	    		  formObj.f_cmd.value = SEARCH06;
//    	    		  var voyNo = formObj.req_skd_voy_dir.value.substring(0,4);
//    	    		  var dirCode = formObj.req_skd_voy_dir.value.substring(4);
//    	    		  //var port = formObj.req_port_cd.value;
//    	    		  var port = comboObjects[44].Code;
//    	    		  var dateXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?skd_voy_no="+voyNo+"&skd_dir_cd="+dirCode+"&vps_port_cd="+port , FormQueryString(formObj));
//    	    		  
//    	    		  var etaDate = ComGetEtcData(dateXml, "eta_date");
//    	    		  
//    	    		  if(isNull(etaDate)){
//    	    			  //ComShowMessage("ETA DB Data is not exist.");
//    	      			  //ComShowCodeMessage("OPF07001", "ETA DB Data");
//  						  return;
//    	    		  }else{
//    	    				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_req_eta_dt") = etaDate;
//    	    				  formObj.req_eta_dt.value = etaDate;
//    	    		  }
//    	    	  }
    	    	  else if(strFlag=="ClmHndlOfc"){
    	    		  formObj.f_cmd.value = SEARCH07;
    	    		  //var ofcXml = sheetObj.GetSearchXml("COM_ENS_071GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
    	    		  var ofcXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
    	    		  //alert(ofcXml);
    	    		  var ofcArr = ComOpfXml2Array(ofcXml, "ofc_cd");
    	    		  //alert(ofcArr);
    	    		  if(isNull(ofcArr) || ofcArr.length < 1){
    	    			  //ComShowMessage("��ϵ��� ���� Office CD �Դϴ�.");
    	      			  ComShowCodeMessage("OPF50004", "Data");
    	      			  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_clm_hndl_ofc_cd") = "";
    	    			  formObj.clm_hndl_ofc_cd.value = "";
    	    			  formObj.clm_hndl_ofc_cd.focus();
  						  return false;
    	    		  }
    	    	  }
    	    	  else if(strFlag=="MailContentPic"){
    	    		  formObj.f_cmd.value = SEARCH08;
    	    		  var Xml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
    	    		  var mailContentCic = ComGetEtcData(Xml, "mail_content_pic");
    	    		  formObj.com_content.value = formObj.default_content.value+ mailContentCic;
    	    	  }      	    	  
    	    	  break;
    	    	  
    	    	  //2011.1.7 �������� delete ���� ����
    	      case IBDELETE:
    	    	  formObj.f_cmd.value = REMOVE;
    	    	  var deleteParam = ComGetSaveString(sheetObj);
    	    	  deleteParam = deleteParam +"&"+ FormQueryString(formObj);
    	    	  var tabNo = tabObjects[0].SelectedIndex;
//    	    	  var saveXml = sheetObj.GetSaveXml("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), deleteParam);
    	    	  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", "del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no") + "&tabNo=" + tabNo + deleteParam);//"&fcmd=REMOVE");
    	    	  //sheetObj.DoSave("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj), -1,false);
    	    	  break;

    	 
    	        
    	      case IBSAVE:        //����
    	    	  if(strFlag=="Approval"){
    	    		  var stvDmgNo = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no");
    	    		  
    	    		  formObj.dmg_auth_sts_cd.value = "Y";
    	    		  formObj.auth_usr_id.value     = userId;
      				  formObj.auth_dt.value         = ComGetNowInfo("ymd");
      				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_dmg_auth_sts_cd") = "Y";
      				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_auth_usr_id")     = userId;
      				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_auth_dt")         = ComGetNowInfo("ymd");
    	    		  
    	    		  formObj.f_cmd.value = MODIFY01;
          	          sheetObj.DoAllSave("VOP_OPF_0052GS.do?stv_dmg_no="+stvDmgNo, FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet1_"));
      				  formObj.dmg_auth_sts_cd.className = "input2";
      				  document.getElementById("btnApproval").style.color="#c0c0c0";
                	  
          	          break;
    	    	  }
    	    	  else{
    	    		  var sheetID = sheetObj.id;
    	    		  
    	    		  var uploadObj = uploadObjects[0];
    	    		  
    	    		  if(sheetID=="sheet1"){
    	    			  if(isTrue(validateForm(sheetObj,formObj))){
    	    				  // �ϴ��� Update UserID/Date Setting.............................................//
                  	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_upd_usr_id") = userId;
          	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_upd_dt")     = ComGetNowInfo("ymd");
          	                  formObj.dmg_upd_usr_id.value		= userId;
          	    	    	  formObj.dmg_upd_dt.value 			= ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.dmg_upd_dt);
          	    	    	  //...............................................................................//
    	    				  
          	    	    	  setClaimHandlingUserStatus("I");
          	    	    	  
    	    				  formObj.f_cmd.value = MULTI01;
    	    				  var prefixs = new Array("sheet1_","sheet2_","sheet20_");
    	    				  var sParam = ComGetSaveString(sheetObj);
    	    				  sParam += "&" + ComGetSaveString(sheetObjects[1], true);
    	    	    		  sParam += "&" + ComGetSaveString(sheetObjects[15], true);
    	    	    		  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
//                  	          sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs), -1,false);
    	    				  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
    	    				  sheetObj.LoadSaveXml(saveXml);
    	    				  saveXml = ComDeleteMsg(saveXml);//����Ϸ� �޼��� ���� 
    	    	              sheetObjects[1].LoadSaveXml(saveXml);
    	    				  
    	    				  //Claim Handling User ����
    	    				  setClaimHandingUserSheetSync("R");
    	    				  setClaimHandlingUser(sheetObjects[17]);
    	    				  
    	    	    	  }
    	    			  else{
    	    				  return false;
    	    			  }
        	    	  }
        	    	  else if(sheetID=="sheet2"){
        	    		  if(isTrue(validateForm(sheetObj,formObj))){
        	    			  setClaimHandlingUserStatus("I");

        	    			  formObj.f_cmd.value = MULTI02;
        	    			  var sParam = ComGetSaveString(sheetObj);
            	    		  var fParam1 = ComGetSaveString(sheetObjects[6], true);
            	    		  var fParam2 = ComGetSaveString(sheetObjects[7], true);
            	    		  var fParam3 = ComGetSaveString(sheetObjects[8], true);
            	    		  var fParam4 = ComGetSaveString(sheetObjects[15], true);

        	    			  var prefixs = new Array("sheet2_","sheet7_","sheet8_","sheet9_","sheet20");
        	    			  // Upload Sheet Data�� Query String�� �߰�..
        	    			  sParam += "&" + fParam1;
        	    			  sParam += "&" + fParam2;
        	    			  sParam += "&" + fParam3;
        	    			  sParam += "&" + fParam4;
        	    			  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);

        	    			  //���� ���ε� �߰�, ���� ����
        	    			  var fileUploadCount = sheetObjects[6].RowCount("I") + sheetObjects[6].RowCount("D");
        	    			  fileUploadCount += sheetObjects[7].RowCount("I") + sheetObjects[7].RowCount("D");
        	    			  fileUploadCount += sheetObjects[8].RowCount("I") + sheetObjects[8].RowCount("D");
        	    			   
        	    			  // �ϴ��� Update UserID/Date Setting.............................................//
                  	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet2_upd_usr_id") = userId;
          	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet2_upd_dt")     = ComGetNowInfo("ymd");
          	                  formObj.dmg_upd_usr_id.value		= userId;
          	    	    	  formObj.dmg_upd_dt.value 			= ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.dmg_upd_dt);
          	    	    	  //...............................................................................//
          	    	    	  
            	    		  if(uploadObj.LocalFiles==""){ 
        	    			  //if( fileUploadCount == 0) {
            	    			  //1. ���ε��� ������ ������=> DB������ ����.
            	    			  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
                	    		  sheetObj.LoadSaveXml(saveXml);
                	    		  
                	    		  saveXml = ComDeleteMsg(saveXml);
            	    		  }
            	    		  else{
            	    			  //1. ���ε��� ������ ������=> ���Ͼ��ε� & DB���� ����.
                	    		  uploadObj.ExtendParam = sParam;
                       		      uploadObj.ParamDecoding = true;
                       		      
                       		      var saveXml = uploadObj.DoUpload(true);
                	    		  sheetObj.LoadSaveXml(saveXml);
                	    		  ComDeleteMsg(saveXml);
                	    		  uploadObjects[0].Files=""; // ���������� ��� �����.
            	    		  }        	    			  
            	              formObj.f_cmd.value = SEARCH09;
                    	      sheetObjects[6].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=SDR&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet7_"));
                    	      sheetObjects[7].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet8_"));
                    	      sheetObjects[8].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet9_"));
                    	      
                    	      //Claim Handling User ����
    	    				  setClaimHandingUserSheetSync("R");
    	    				  setClaimHandlingUser(sheetObjects[17]);
        	    			  
            	    	  }
        	    		  else{
    	    				  return false;
    	    			  }
        	    	  }
        	    	  else if(sheetID=="sheet3"){
        	    		  if(isTrue(rprValidateForm(formObj))){
            	    		  //formObj.f_cmd.value = MULTI03;
            	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet3_"), -1,false);
            	    		  
        	    			  formObj.f_cmd.value = MULTI03;
        	    			  var sParam = ComGetSaveString(sheetObj);
            	    		  var fParam1 = ComGetSaveString(sheetObjects[9], true);
            	    		  var fParam2 = ComGetSaveString(sheetObjects[10], true);
            	    		  var fParam3 = ComGetSaveString(sheetObjects[11], true);
            	    		  var fParam4 = ComGetSaveString(sheetObjects[12], true);
            	    		  var fParam5 = ComGetSaveString(sheetObjects[15], true);

        	    			  var prefixs = new Array("sheet3_","sheet10_","sheet11_","sheet12_","sheet13_","sheet20_");
        	    			  // Upload Sheet Data�� Query String�� �߰�..
        	    			  sParam += "&" + fParam1;
        	    			  sParam += "&" + fParam2;
        	    			  sParam += "&" + fParam3;
        	    			  sParam += "&" + fParam4;
        	    			  sParam += "&" + fParam5;
        	    			  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);

        	    			  //���� ���ε� �߰�, ���� ����
        	    			  var fileUploadCount = sheetObjects[9].RowCount("I") + sheetObjects[9].RowCount("D");
        	    			  fileUploadCount += sheetObjects[10].RowCount("I") + sheetObjects[10].RowCount("D");
        	    			  fileUploadCount += sheetObjects[11].RowCount("I") + sheetObjects[11].RowCount("D");
        	    			  fileUploadCount += sheetObjects[12].RowCount("I") + sheetObjects[12].RowCount("D");
        	    			  
        	    			// �ϴ��� Update UserID/Date Setting.............................................//
                  	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet3_upd_usr_id") = userId;
          	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet3_upd_dt")     = ComGetNowInfo("ymd");
          	                  formObj.rpr_upd_usr_id.value		= userId;
          	    	    	  formObj.rpr_upd_dt.value 			= ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.rpr_upd_dt);
          	    	    	  //alert("uploadObj.LocalFiles:"+uploadObj.LocalFiles);
            	    		  if(uploadObj.LocalFiles==""){
        	    			  //if( fileUploadCount == 0) {
            	    			  //1. ���ε��� ������ ������=> DB������ ����.
            	    			  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
                	    		  sheetObj.LoadSaveXml(saveXml);
                	    		  
                	    		  saveXml = ComDeleteMsg(saveXml);
            	    		  }
            	    		  else{
            	    			  //1. ���ε��� ������ ������=> ���Ͼ��ε� & DB���� ����.
                	    		  uploadObj.ExtendParam = sParam;
                       		      uploadObj.ParamDecoding = true;
                       		      
                       		      var saveXml = uploadObj.DoUpload(true);
                	    		  sheetObj.LoadSaveXml(saveXml);
                	    		  ComDeleteMsg(saveXml);
                	    		  uploadObjects[0].Files=""; // ���������� ��� �����.
            	    		  } 
            	              formObj.f_cmd.value = SEARCH09;
                    	      sheetObjects[9].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=RES&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet10_"));
                    	      sheetObjects[10].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=INV&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet11_"));
                    	      sheetObjects[11].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet12_"));
                    	      sheetObjects[12].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet13_"));
                    	      

            	    		  
        	    		  }
        	    		  else{
    	    				  return false;
    	    			  }
        	    	  }
        	    	  else if(sheetID=="sheet4"){
        	    		  if(isTrue(cmpnValidateForm(formObj))){
            	    		  formObj.f_cmd.value = MULTI04;
            	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet4_"), -1,false);
            	    		  //setCmpnDisplayData(formObj);
            	    		  var sParam = ComGetSaveString(sheetObj);
            	    		  sParam = sParam +"&"+ FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet4_");
            	    		  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
            	    		  
            	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet4_clm_hndl_ofc_cd") = ComGetEtcData(saveXml, "clmHndlOfc");
            	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet4_clm_hndl_usr_id") = ComGetEtcData(saveXml, "clmHndlUsrId");
            	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet4_clm_hndl_usr_nm") = ComGetEtcData(saveXml, "clmHndlUsrNm");
            	    		  setCmpnDisplayData(formObj);
            	    		  // �ϴ��� Update UserID/Date Setting.............................................//
                  	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet4_upd_usr_id") = userId;
          	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet4_upd_dt")     = ComGetNowInfo("ymd");
          	                  formObj.cmpn_upd_usr_id.value		= userId;
          	    	    	  formObj.cmpn_upd_dt.value 		= ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.cmpn_upd_dt);
          	    	    	  //...............................................................................//
            	    		  
            	    		  sheetObj.LoadSaveXml(saveXml);
            	    		  
                    	      claimHandlingOfc = ( formObj.clm_hndl_ofc_cd.value == officeCd ? true : false );  
                    		  claimed = ( formObj.stv_dmg_cmpn_proc_sts_cd[1].checked ? true : false );
                    		  authPermission ( 2 );
        	    		  }
        	    		  else{
    	    				  return false;
    	    			  }
        	    	  }
        	    	  else if(sheetID=="sheet5"){
        	    		  //formObj.f_cmd.value = MULTI05;
        	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet5_"), -1,false);
       	    		  
    	    			  formObj.f_cmd.value = MULTI05;
    	    			  var sParam = ComGetSaveString(sheetObj);
        	    		  var fParam1 = ComGetSaveString(sheetObjects[13], true);
        	    		  var fParam2 = ComGetSaveString(sheetObjects[14], true);

    	    			  var prefixs = new Array("sheet5_","sheet14_","sheet15_");
    	    			  // Upload Sheet Data�� Query String�� �߰�..
    	    			  sParam += "&" + fParam1;
    	    			  sParam += "&" + fParam2;
    	    			  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);

    	    			  //���� ���ε� �߰�, ���� ����
    	    			  var fileUploadCount = sheetObjects[13].RowCount("I") + sheetObjects[13].RowCount("D");
    	    			  fileUploadCount += sheetObjects[14].RowCount("I") + sheetObjects[14].RowCount("D");

        	    		  // �ϴ��� Update UserID/Date Setting.............................................//
              	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet5_upd_usr_id") = userId;
      	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet5_upd_dt")     = ComGetNowInfo("ymd");
      	                  formObj.stl_upd_usr_id.value		= userId;
      	    	    	  formObj.stl_upd_dt.value 			= ComGetNowInfo("ymd");
      	    	    	  ComAddSeparator(formObj.stl_upd_dt);
      	    	    	  //...............................................................................//
      	    	    	  
        	    		  if(uploadObj.LocalFiles==""){
    	    			  //if( fileUploadCount == 0) {
        	    			  //1. ���ε��� ������ ������=> DB������ ����.
        	    			  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
            	    		  sheetObj.LoadSaveXml(saveXml);
            	    		  
            	    		  saveXml = ComDeleteMsg(saveXml);
        	    		  }
        	    		  else{
        	    			  //sheetObjects[4].RowStatus(1) = "U";
        	    			  
        	    			  //1. ���ε��� ������ ������=> ���Ͼ��ε� & DB���� ����.
            	    		  uploadObj.ExtendParam = sParam;
                   		      uploadObj.ParamDecoding = true;
                   		      
                   		      var saveXml = uploadObj.DoUpload(true);
            	    		  sheetObj.LoadSaveXml(saveXml);
            	    		  ComDeleteMsg(saveXml);
            	    		  uploadObjects[0].Files=""; // ���������� ��� �����.
            	    	  }
        	              formObj.f_cmd.value = SEARCH09;
                	      sheetObjects[13].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=S&stv_dmg_atch_file_tp_cd=INV&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet14_"));
                	      sheetObjects[14].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=S&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet15_"));

        	    	  }
          	          break;
    	    	  }
     	         
    	    }
    	}

    /**
     * ȭ�� ���Է°��� ���� ��ȿ������ ���μ��� ó��
     */
    function validateForm(sheetObj,formObj){
    	//alert("validation");
		
    	if(isNull(formObj.clm_hndl_ofc_cd.value)){
    		//2011.11.10 unKnown �� �ƴ� ��츸 üũ
			 if(!unKnownFlg){
				 ComShowCodeMessage("OPF50009", "Claim Handling Office");
				 formObj.clm_hndl_ofc_cd.focus();
	          	 return false;
			 }
		 }
		 else{
			 var isOfcCd = doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "ClmHndlOfc");
			 if(isNull(isOfcCd+"")) {isOfcCd = true;}
			 if(!isOfcCd){
				 return false;
			 }
		 }
    	
    	var prefix = "sheet2_";
		 
        if(isNull(comboObjects[1].Code)){
         	//ComShowMessage("\'Category\' is mandatory item.");
			ComShowCodeMessage("OPF50009", "Category");
         	formObj.stv_dmg_prt_cate_cd.focus();
         	return false;
        }
        
        if(!unKnownFlg && sheetObjects[17].CellValue(1, "clm_hndl_usr_nm").length == 0){
			 ComShowCodeMessage("OPF50009", "Claim Handling User");
			 sheetObjects[17].SelectCell(1, "clm_hndl_usr_nm");
          	 return false;
		 }
        
        if(isNull(comboObjects[2].Code)){
         	//ComShowMessage("\'Part\' is mandatory item.");
			ComShowCodeMessage("OPF50009", "Part");
         	formObj.stv_dmg_prt_cd.focus();
         	return false;
        }
		 
		// Loss Time(Hours) Data Validation Check!
		var chkLossDate = checkDateHours(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
		if(isNull(chkLossDate+"")) {chkLossDate = true;}
		if(!chkLossDate){
			return false;
		}
        
		// �Է� ���ǿ� ���� �����Ǵ� �ʼ��Է� ������ üũ.
        if(formObj.stv_dmg_req_cate_cd[2].checked){
			if(isNull(comboObjects[5].Code))
			{
				//ComShowMessage("\'Requirement- Reason\' is mandatory item.");
				ComShowCodeMessage("OPF50009", "Requirement- Reason");
				formObj.stv_dmg_qttn_rsn_desc.focus();
				return false;
			}
			else if(comboObjects[5].Code=="TXT" && isNull(formObj.req_reason_desc.value)){
				ComShowCodeMessage("OPF50009", "Requirement- Reason Description");
				formObj.req_reason_desc.focus();
				return false;
			}
		}
        else{
			if(isNull(formObj.req_skd_voy_dir.value))
			{
				//ComShowCodeMessage("OPF50009", "Requirement- Voyage No.");
				//formObj.req_skd_voy_dir.focus();
				//return false;
			}
			else{
				
//				//Voyage No. ������ ��ȸ.
//				formObj.f_cmd.value = SEARCH01;
//	    		var voyNo = formObj.req_skd_voy_dir.value.substring(0,4);
//	    		var dirCd = formObj.req_skd_voy_dir.value.substring(4);
//
//	    		var portXml2 = sheetObjects[1].GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq&skd_voy_no="+voyNo+"&skd_dir_cd="+dirCd , FormQueryString(formObj));
//	    		//alert("asdf");
//	   	    	var strPortCdList2 = ComGetEtcData(portXml2, "vvdPortComboList");
//	   	    	if(isNull(strPortCdList2)){
//	    			//ComShowMessage("�����ٿ� ��ϵ��� ���� Voyage No.�Դϴ�.");
//	    			ComShowCodeMessage("OPF50004", "Data");
//	    			formObj.req_skd_voy_dir.value = "";
//	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_skd_voy_no") = "";
//	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_skd_dir_cd") = "";
//	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_port_cd") = "";
//	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_skd_voy_dir") = "";
////	    			comboObjects[44].RemoveAll();
//	    			formObj.req_skd_voy_dir.focus();
//	   	    		return false;
//	   	    	}
				
			}
			
//			if(isNull(comboObjects[44].Code))
//			{
//				//ComShowCodeMessage("OPF50009", "Port");
//				//formObj.req_port_cd.focus();
//				//return false;
//			}
			
			if(isNull(formObj.req_eta_dt.value))
			{
				//ComShowCodeMessage("OPF50009", "ETA");
				//formObj.req_eta_dt.focus();
				//return false;
			}
			else{
				
//				var dateFlag = ComGetDaysBetween(formObj.stv_dmg_evnt_dt.value, formObj.req_eta_dt.value);
//	  			if(dateFlag <= 0){
//	  				 //ComShowMessage("ETA Date must be later than Damage Date.");
//        			 ComShowCodeMessage("OPF50013", "ETA Date", "Damage Date");
//	  				 sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_eta_dt") = "";
//		    		 formObj.req_eta_dt.value = "";
//		    		 formObj.req_eta_dt.select();
//		    		 return false;
//	  			}
				
			}
		}
        
		

        //return true;
    }

    /**
     * �Էµ� ���� True/False ���� ����.
     */
    function isTrue(strValue)
    {
    	if(strValue+""=="false"){
    		return false;
    	}
    	else{
    		return true;
    	}
    }

    /**
     * ȭ�� ���Է°��� Null Check
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
     * ȭ�� From Date/ To Date �� Validation Check.
     */
    function checkDate(fromDate, toDate){
    	fromDate = fromDate.replace(/-/g,"");
    	toDate = toDate.replace(/-/g,"");
    	if(isNull(fromDate) || isNull(toDate)){
    		return true;
    	}
    	else{
    		//var dayTime = ComGetDaysBetween(fromDate, toDate);
    		var dayTime = getDateHoursBetween(fromDate, toDate);
        	if(dayTime < 0){
        		//ComShowMessage("[To Date] must be later than [From Date]");
    			ComShowCodeMessage("OPF50013", "ETA Date", "Damage Date");
        		return false;
        	}else{
        		return true;
        	}
    	}
    }
    
    /**
     * ȭ�� DateTime �Է� ���� �ð� ��� �Լ�.
     */
    function getDateHoursBetween(fromTime, toTime){
   	 
	   	 if(isNull(fromTime) || isNull(toTime)){
	   		 return "";
	   	 }
	   	 else{
        	 fromTime = fromTime.replace(/-/g,"");
        	 fromTime = fromTime.replace(/:/g,"");
        	 fromTime = fromTime.replace(/ /g,"");
        	 toTime = toTime.replace(/-/g,"");
        	 toTime = toTime.replace(/:/g,"");
        	 toTime = toTime.replace(/ /g,"");
        	 
    		 var dayTime = ComGetDaysBetween(fromTime.substring(0,8), toTime.substring(0,8)) * 24;
    		 
    		 if(fromTime.substring(10) >= toTime.substring(10)){
    			 dayTime = dayTime - (fromTime.substring(8,10) - toTime.substring(8,10));
    		 }
    		 else{
    			 dayTime = dayTime + (toTime.substring(8,10) - fromTime.substring(8,10));
    		 }
    		 
    		 var minute = 0;
    		 if(fromTime.substring(10) > toTime.substring(10)){
				 dayTime = dayTime - 1;
				 minute = (fromTime.substring(10) - toTime.substring(10)) / 60;
			 }
			 else if(fromTime.substring(10) < toTime.substring(10)){
				 minute = (toTime.substring(10) - fromTime.substring(10)) / 60;
			 }
    		 
    		 var returnTime = "";
    		 if(minute>0){
    			 // �Ҽ��� ��°�ڸ� ���� �ݿø� ó��.
    			 returnTime = (dayTime+minute).toFixed(2);
    		 }else{
    			 returnTime = dayTime;
    		 }
    		 return returnTime;
	   	 }
    }
     
    /**
     * ȭ�� DateTime �Է� ���� ��ȿ�� üũ �Լ�.
     */
    function checkDateHours(fromTime, toTime){
	   	 var formObj = document.form;
	   	 
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
			 var lossTime = getDateHoursBetween(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
			 if(lossTime <= 0){
  				 ComShowCodeMessage("OPF50013", "To Loss Hour", "From Loss Hour");
  				 formObj.fm_tm_lss_dt.focus();
  				 return false;
  			 }
		 }
    }
    
    /**
     * Damage Data Form Object Enable/Disable Control. <br>
     */
    function dmgFormObjControl(formObj, sheetObj, clickFlag){
    	var prefix = "sheet2_";
    	
    	if(formObj.stv_dmg_req_cate_cd[2].checked){
    		
    		if(clickFlag){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_voy_no") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_dir_cd") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
    		}
    		formObj.req_skd_voy_dir.value = "";
    		formObj.req_port_cd.value = "";
    		formObj.req_eta_dt.value = "";
    		formObj.req_skd_voy_dir.readOnly = true;
    		formObj.req_port_cd.readOnly = true;
    		formObj.req_eta_dt.readOnly = true;
    		formObj.req_skd_voy_dir.className = "input2";
    		formObj.req_port_cd.className = "input2";
    		formObj.req_eta_dt.className = "input2";
    		comboObjects[5].Enable = true;
    		if(comboObjects[5].Code=="TXT"){
    			formObj.req_reason_desc.readOnly == false;
        		formObj.req_reason_desc.className = "input1";
    		}
    		//formObj.stv_dmg_qttn_rsn_desc.focus();
    	}
    	else{
    		if(clickFlag){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = formObj.vsl_cd.value;
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_qttn_cd") = "";
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_qttn_rsn_desc") = "";
    		}
    		formObj.req_skd_voy_dir.readOnly = false;
    		formObj.req_eta_dt.readOnly = false;
    		formObj.req_skd_voy_dir.className = "input";
    		formObj.req_eta_dt.className = "input";
    		comboObjects[5].Index2 = "";
    		comboObjects[5].Enable = false;
    		formObj.req_reason_desc.value = "";
    		formObj.req_reason_desc.readOnly == true;
    		formObj.req_reason_desc.className = "input2";
    	}
    	
       	if(comboObjects[6].Code == "U"){

    		comboObjects[7].Enable = true;
    		 
			if(comboObjects[7].Code=="TXT"){
		
				formObj.res_reason_desc.readOnly = false;
	    		formObj.res_reason_desc.className = "input1"; // �Ķ�.
			}
			else {
				formObj.res_reason_desc.readOnly = true;
	    		formObj.res_reason_desc.className = "input2"; // ȸ��.
			}
    		
    		formObj.stv_dmg_respb_desc_dtl.value = "";
    		formObj.stv_dmg_respb_desc_dtl.readOnly = false;
    		formObj.stv_dmg_respb_desc_dtl.className = "input2"; //ȸ��.			
    		
    	}
    	else
    	{	
    		formObj.res_reason_desc.value = "";
    		formObj.res_reason_desc.readOnly = true;
    		formObj.res_reason_desc.className = "input2";		//ȸ��.
    		    		
    		formObj.stv_dmg_respb_desc_dtl.readOnly = false;
    		formObj.stv_dmg_respb_desc_dtl.className = "input"; //���
    		
			comboObjects[7].Enable = false;			

			if(clickFlag){
				sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = "";
    		}			
    	}
    	
    	
    }
    
    // Repair Tab Control Start! ==========================================================//
    /**
     * ��ȸ�� ������ ������ �ش� Grid �� ȭ�� �ʱ�ȭ. <br>
     **/
    function initDefaultSheet(formObj, sheetFlag){
    	var sheetObj = null;
    	var row = null;
    	if(sheetFlag=="Rpr"){
    		sheetObj = sheetObjects[2];
    		//sheetObj.RemoveAll();
    		row = sheetObj.DataInsert(-1);
    		sheetObj.CellValue(row, "sheet3_stv_dmg_no") = formObj.stv_dmg_no.value;
    		sheetObj.CellValue(row, "sheet3_stv_dmg_rpr_proc_sts_cd") = "O";
    		rprFormObjControl(formObj);
    		
    		comboObjects[8].Code = dfCurrency;
    		sheetObj.CellValue(row, "sheet3_qttn_locl_curr_cd") = dfCurrency;
    		sheetObj.CellValue(row, "sheet3_rpr_rslt_rpt_atch_flg") = "N";
    		sheetObj.CellValue(row, "sheet3_rpr_inv_atch_flg") = "N";
    		sheetObj.CellValue(row, "sheet3_rpr_pict_atch_flg") = "N";
    		sheetObj.CellValue(row, "sheet3_rpr_doc_atch_flg") = "N";
    		
    		setDisplaySeq(formObj, sheetObj);
    	}
    	else if(sheetFlag=="Cmpn"){
    		sheetObj = sheetObjects[3];
    		sheetObj.RemoveAll();
    		row = sheetObj.DataInsert();
    		sheetObj.CellValue(row, "sheet4_stv_dmg_no") = formObj.stv_dmg_no.value;
    		sheetObj.CellValue(row, "sheet4_stv_dmg_cmpn_proc_sts_cd") = "R";
    		
    		comboObjects[9].Code = dfCurrency;
    		//sheetObj.CellValue(row, "sheet4_cmpn_curr_cd") = dfCurrency;
    		
    		cmpnFormObjControl(formObj);
    	}
    }
    /**
     * Grid Data ȭ�鿡 Setting. <br>
     **/
    function setRprDisplayData(formObj){
    	var sheetObj = sheetObjects[2];
    	var thisRow = sheetObj.SelectRow;
    	var prefix = "sheet3_";
    	
    	var statusCode = sheetObj.CellValue(thisRow, prefix+"stv_dmg_rpr_proc_sts_cd");
    	
    	if(statusCode=="O"){
    		formObj.stv_dmg_rpr_proc_sts_cd[1].checked = true;
    		////[2009-10-14] ������ ���� Ordered ���� �� ����
    		//formObj.stv_dmg_rpr_proc_sts_cd[1].disabled = true;
    		//formObj.stv_dmg_rpr_proc_sts_cd[2].disabled = true;
    		//formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = true;
    	}else if(statusCode=="R"){
    		formObj.stv_dmg_rpr_proc_sts_cd[2].checked = true;
    	}else if(statusCode=="C"){
    		formObj.stv_dmg_rpr_proc_sts_cd[3].checked = true;
    	}else if(statusCode=="Q"){
    		formObj.stv_dmg_rpr_proc_sts_cd[0].checked = true;
    	}
    	// Status�� �Է� ���� �ʵ� ����.
    	rprFormObjControl(formObj);
    	
    	formObj.rpr_cost_usd_amt.value 	= sheetObj.CellText(thisRow, prefix+"rpr_cost_usd_amt");
    	comboObjects[8].Code2			= sheetObj.CellValue(thisRow, prefix+"qttn_locl_curr_cd");
    	formObj.qttn_cost_locl_amt.value= sheetObj.CellText(thisRow, prefix+"qttn_cost_locl_amt");
    	formObj.qttn_cost_usd_amt.value = sheetObj.CellText(thisRow, prefix+"qttn_cost_usd_amt");
    	formObj.rpr_port_cd.value 		= sheetObj.CellValue(thisRow, prefix+"rpr_port_cd");
    	formObj.rpr_dt.value 			= sheetObj.CellValue(thisRow, prefix+"rpr_dt");
    	formObj.rpr_vndr_nm.value 		= sheetObj.CellValue(thisRow, prefix+"rpr_vndr_nm");
    	formObj.ustl_acct_no.value 		= sheetObj.CellValue(thisRow, prefix+"ustl_acct_no");
    	formObj.run_rpr_acct_no.value 	= sheetObj.CellValue(thisRow, prefix+"run_rpr_acct_no");
    	formObj.rpr_cost_usd_amt.value 	= sheetObj.CellText(thisRow, prefix+"rpr_cost_usd_amt");
    	formObj.rpr_rmk.value 			= sheetObj.CellValue(thisRow, prefix+"rpr_rmk");
    	formObj.rpr_upd_usr_id.value 	= sheetObj.CellValue(thisRow, prefix+"upd_usr_id");
    	formObj.rpr_upd_dt.value 		= sheetObj.CellValue(thisRow, prefix+"upd_dt");
    	
    	formObj.rpr_rslt_rpt_atch_knt.value = sheetObj.CellValue(thisRow, prefix+"rpr_rslt_rpt_atch_knt");
    	formObj.rpr_inv_atch_knt.value 		= sheetObj.CellValue(thisRow, prefix+"rpr_inv_atch_knt");
    	formObj.rpr_pict_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"rpr_pict_atch_knt");
    	formObj.rpr_doc_atch_knt.value 		= sheetObj.CellValue(thisRow, prefix+"rpr_doc_atch_knt");
    	
    	setDisplaySeq(formObj, sheetObj);
    	setRprTotalAmt(formObj, sheetObj);
    	
    	setSubButton(1);
    }

    /**
     * Display Sequence Set. <br>
     */
    function setDisplaySeq(formObj, sheetObj){
    	formObj.stv_dmg_rpr_seq.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet3_stv_dmg_rpr_seq");
    	formObj.stv_dmg_rpr_seq_total.value = sheetObj.RowCount;
    }
    
    /**
     * Prev/Next ��ư�� ȭ���̵� ���. <br>
     **/
    function moveScreen(sheetObj, formObj, moveSeq) {
    	
    	if( moveSeq==-1 && sheetObj.SelectRow==1 ){
        	//ComShowMessage("No more Previous Page.");
        	return false;
        }
        else if( moveSeq==1 && sheetObj.SelectRow==sheetObj.LastRow ){
        	
        	// �ѹ��� �ִ� 1�� �̻� Add �Ұ���.
        	var addFlag = true;
        	for(var i=1; i<=sheetObj.RowCount; i++){
        		//alert(sheetObj.RowStatus(i));
        		if(sheetObj.RowStatus(i)=="I"){
        			addFlag = false;
        		}
        	}
        	
        	if( ComIsBtnEnable("btn_Save")
        		&& addFlag
        		//&& isTrue(rprValidateForm(formObj))
        		//&& ComShowConfirm(ComGetMsg("OPF07011"))
        		)
        	{
        		//sheetObj.DataInsert();
        		initDefaultSheet(document.form, "Rpr");
        		// Grid Data�� ȭ�鿡 Set..
                setRprDisplayData(formObj);
        	}else{
        		return false;
        	}
        }
        else{
        	//if(isTrue(rprValidateForm(formObj))){
        		sheetObj.SelectRow = sheetObj.SelectRow + moveSeq;
                // Grid Data�� ȭ�鿡 Set..
                setRprDisplayData(formObj);
        	//}
        }
    }
    
    /**
     * Data �Է½� Hidden Grid�� �ش� Data Set. <br>
     **/
    function rpr_change_event() {

    	changeFlag = true;
    	
    	var elementObj = event.srcElement;
    	var formObj = document.form;
    	var sheetObj = sheetObjects[2];
    	var prefix = "sheet3_";
    	
    	if(elementObj.name=="rpr_cost_usd_amt"){
    		// ȭ�鿡 �Է��� Data�� Grid�� Set!
        	sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
        	
    		setRprTotalAmt(document.form, sheetObj);
    	}
    	else if(elementObj.name=="rpr_rslt_rpt_atch_flg"
				|| elementObj.name=="rpr_inv_atch_flg"
				|| elementObj.name=="rpr_pict_atch_flg"
				|| elementObj.name=="rpr_doc_atch_flg")
		{
			if(elementObj.value > 0){
				sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "Y";
			}else{
				sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "N"
			}
		}
    	else if(elementObj.name=="ustl_acct_no" || elementObj.name=="run_rpr_acct_no")
    	{
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    		
    		// ù��° Seq�� InterOfficeAccountNo�� RunRepairAccountNo �� ����Ǹ� Settlement Tab�� Data�� �Բ� ����.
    		if(sheetObj.SelectRow==1 && sheetObjects[4].RowCount>0){
    			sheetObjects[4].CellValue(1, "sheet5_ustl_acct_no")    = elementObj.value;
    			sheetObjects[4].CellValue(1, "sheet5_run_rpr_acct_no") = elementObj.value;
    			document.form.ustl_acct_no_stl.value    = elementObj.value;
    			document.form.run_rpr_acct_no_stl.value = elementObj.value;
    		}
    	}
    	else{
    		// ȭ�鿡 �Է��� Data�� Grid�� Set!
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    	}
    	
    	if(elementObj.name=="qttn_cost_locl_amt" && comboObjects[8].Code != "")
    	{
    		setRepair_usd_amt(comboObjects[8].Code, elementObj.value, formObj.qttn_cost_usd_amt);
    	}
    }
    
    /**
     * qttn_locl_curr_cd Combo Data ���ý� Hidden Grid�� �ش� Data Set. <br>
     **/
    function qttn_locl_curr_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj = document.form;
    	if(loadFlag){
    		sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_qttn_locl_curr_cd") = comboObj.Code;
    		setRepair_usd_amt(comboObj.Code, document.form.qttn_cost_locl_amt, formObj.qttn_cost_usd_amt);
    	}
    }

    /* Repair - USD AMT ������ 
     * curr_cd   : Curr Code
     * local_amt : Local Amt
     * obj       : ���� �� set ��ġ
     */
	function setRepair_usd_amt(curr_cd, local_amt, obj){
	    var formObj = document.form;
    	formObj.f_cmd.value = SEARCH07;
		var sXml = sheetObjects[5].GetSearchXml("VOP_OPF_1053GS.do", FormQueryString(formObj));
		obj.value = ComGetEtcData(sXml, "usdAmt");
		
		sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_qttn_cost_usd_amt") = obj.value;
	}
	
    /* Compensation - USD AMT ������ 
     * curr_cd   : Curr Code
     * local_amt : Local Amt
     * obj       : ���� �� set ��ġ
     */
	function setCompensation_usd_amt(curr_cd, local_amt, obj){
		var formObj = document.form;
	   	formObj.f_cmd.value = SEARCH08;
		var sXml = sheetObjects[5].GetSearchXml("VOP_OPF_1053GS.do", FormQueryString(formObj));
		obj.value = ComGetEtcData(sXml, "usdAmt");
		
		sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "sheet4_cmpn_cost_usd_amt") = obj.value;
	}    
    
     /**
      * req_port_cd Combo Data ���ý� Hidden Grid�� �ش� Data Set. <br>
      **/
     function req_port_cd_OnChange(comboObj, idx_cd, text) {
     	var formObj = document.form;
     	var sheetObj = sheetObjects[1];
     	
     	sheetObj.CellValue(sheetObj.SelectRow, "sheet2_req_port_cd") = comboObj.Code;
     	
//     	if(!isNull(comboObj.Code)){
//			doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "etaDate");
//		}
     	formObj.req_port_cd.focus();
     }
    
    /**
     * Popup Data Validation Check. <br>
     **/
    function popEvent_rpr_port_cd(aryPopupData) {
    	
    	document.form.rpr_port_cd.value = aryPopupData[0][2];
    	sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_rpr_port_cd") = aryPopupData[0][2];
    }
    
    /**
     * Repair Total Amount calculate. <br>
     **/
    function setRprTotalAmt(formObj, sheetObj){
    	var amtTotal = 0;
    	for(i=1; i<= sheetObj.RowCount; i++){
    		//alert(sheetObj.CellValue(i, prefix+elementObj.name)+"|"+sheetObj.RowCount);
    		amtTotal += parseFloat(sheetObj.CellValue(i, "sheet3_rpr_cost_usd_amt"));
    		// �Ҽ��� ��°�ڸ� ���� �ݿø� ó��.
    		//amtTotal = amtTotal.toFixed(2);
    	}
    	//alert(amtTotal);
    	formObj.rpr_cost_usd_amt_total.value = amtTotal;
    	ComAddSeparator(formObj.rpr_cost_usd_amt_total);
    }
    
    /**
     * Repair Data Form Object Enable/Disable Control. <br>
     **/
    function rprFormObjControl(formObj)
    {
    	if(formObj.stv_dmg_rpr_proc_sts_cd[1].checked)
    	{
    		//[2009-11-16 ������ ����] Ordered�� ���Ordered, Repairing, Quotation���ð���, Completed���� �Ұ�
    		formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = true;
    		
			comboObjects[8].Enable = false;
			formObj.qttn_cost_locl_amt.readOnly = true;
			//formObj.qttn_cost_usd_amt.readOnly = true;
			formObj.qttn_cost_locl_amt.className  = "input2";
			//formObj.qttn_cost_usd_amt.className = "input2";
			
			formObj.rpr_port_cd.readOnly = false;
			formObj.rpr_dt.readOnly = false;
			formObj.rpr_vndr_nm.readOnly = false;
			formObj.rpr_port_cd.className  = "input1";
			formObj.rpr_dt.className  = "input1";
			formObj.rpr_vndr_nm.className  = "input1";
			
			formObj.ustl_acct_no.readOnly = true;
			formObj.run_rpr_acct_no.readOnly = true;
			formObj.rpr_cost_usd_amt.readOnly = true;
			formObj.ustl_acct_no.className  = "input2";
			formObj.run_rpr_acct_no.className  = "input2";
			formObj.rpr_cost_usd_amt.className  = "input2";	
		}
    	else if(formObj.stv_dmg_rpr_proc_sts_cd[2].checked 
        		|| formObj.stv_dmg_rpr_proc_sts_cd[3].checked)
    	{
    		
    		//[2009-11-16 ������ ����] Completed�� Repairing������ ���ð���
   			formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = false;
    		
			comboObjects[8].Enable = false;
			formObj.qttn_cost_locl_amt.readOnly = true;
			//formObj.qttn_cost_usd_amt.readOnly = true;
			formObj.qttn_cost_locl_amt.className  = "input2";
			//formObj.qttn_cost_usd_amt.className = "input2";
			
			formObj.rpr_port_cd.readOnly = true;
			formObj.rpr_dt.readOnly = true;
			formObj.rpr_vndr_nm.readOnly = true;
			formObj.rpr_port_cd.className  = "input2";
			formObj.rpr_dt.className  = "input2";
			formObj.rpr_vndr_nm.className  = "input2";
			

			if(sheetObjects[1].CellValue(1, "sheet2_stv_dmg_respb_pty_kwn_cd")=="U"){
				formObj.ustl_acct_no.readOnly = true;
				formObj.run_rpr_acct_no.readOnly = false;
				formObj.ustl_acct_no.className  = "input2";
				formObj.run_rpr_acct_no.className  = "input";
			}
			else{
//				formObj.ustl_acct_no.readOnly = true;
//				formObj.run_rpr_acct_no.readOnly = false;
//				formObj.ustl_acct_no.className  = "input2";
//				formObj.run_rpr_acct_no.className  = "input";
				
				formObj.ustl_acct_no.readOnly = false;
				formObj.run_rpr_acct_no.readOnly = true;
				formObj.ustl_acct_no.className  = "input1";
				formObj.run_rpr_acct_no.className  = "input2";
			}
			formObj.rpr_cost_usd_amt.readOnly = false;
			formObj.rpr_cost_usd_amt.className  = "input1";
		}	
    	else if(formObj.stv_dmg_rpr_proc_sts_cd[0].checked)
    	{
    		//[2009-11-16 ������ ����] Completed�� Repairing������ ���ð���
    		formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = true;    		
    		
			comboObjects[8].Enable = true;
			formObj.qttn_cost_locl_amt.readOnly = false;
			//formObj.qttn_cost_usd_amt.readOnly = false;
			formObj.qttn_cost_locl_amt.className  = "input1";
			//formObj.qttn_cost_usd_amt.className = "input1";
			
			formObj.rpr_port_cd.readOnly = true;
			formObj.rpr_dt.readOnly = true;
			formObj.rpr_vndr_nm.readOnly = true;
			formObj.rpr_port_cd.className  = "input2";
			formObj.rpr_dt.className  = "input2";
			formObj.rpr_vndr_nm.className  = "input2";
			
			formObj.ustl_acct_no.readOnly = true;
			formObj.run_rpr_acct_no.readOnly = true;
			formObj.rpr_cost_usd_amt.readOnly = true;
			formObj.ustl_acct_no.className  = "input2";
			formObj.run_rpr_acct_no.className  = "input2";
			formObj.rpr_cost_usd_amt.className  = "input2";
		}

    }
    
    /**
     * Repair ȭ�� ���Է°��� ���� ��ȿ������ ���μ��� ó��
     */
    function rprValidateForm(formObj){
    	 var sheetObj = sheetObjects[2];
    	 var prefix = "sheet3_";
    	 
    	 for(var i=1; i<= sheetObj.LastRow; i++)
    	 {
    		 var moveRow = i - sheetObj.SelectRow;
    		 
    		 //[2009-10-13] ������ ����
    		 //if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="O" || sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="C")
   			 if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="O")	 
    		 {
    			 if(isNull(sheetObj.CellValue(i, prefix+"rpr_port_cd")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Port");
    				 formObj.rpr_port_cd.focus();
    				 return false;
    			 }
    			 else{
    				 // Repair Port Code Validation Check!
    				 formObj.f_cmd.value = COMMAND13;
	   	    		 var polXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do?op=0043&loc_cd="+sheetObj.CellValue(i, prefix+"rpr_port_cd") , FormQueryString(formObj));
	   	    		 var strPolCd = ComGetEtcData(polXml, "port_name");
	   	    		 if(isNull(strPolCd)){
		   	      		  if(moveRow != 0){
	       					  moveScreen(sheetObj, formObj, moveRow);
	       				  }
	   	      			  ComShowCodeMessage("OPF50004", "Data");
	   	    			  sheetObj.CellValue(i, "sheet3_rpr_port_cd") = "";
	   	    			  formObj.rpr_port_cd.value = "";
	   	    			  formObj.rpr_port_cd.focus();
	 					  return false;
	   	    		 }
    			 }
    			 if(isNull(sheetObj.CellValue(i, prefix+"rpr_dt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Date");
    				 formObj.rpr_dt.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.CellValue(i, prefix+"rpr_vndr_nm")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Vendor");
    				 formObj.rpr_vndr_nm.focus();
    				 return false;
    			 }
    		 }
    		 else if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="R")
    		 {
    	         if( formObj.ustl_acct_no.className  == "input1" ){
        			 if(isNull(sheetObj.CellValue(i, prefix+"ustl_acct_no")))
        			 {
        				 if(moveRow != 0){
        					 moveScreen(sheetObj, formObj, moveRow);
        				 } 
        				 ComShowCodeMessage("OPF50009", "Unsettled Inter-Office Account No.");//
        				 formObj.ustl_acct_no.focus();
        				 return false;
        			 }
    	         }
    			 if(isNull(sheetObj.CellValue(i, prefix+"rpr_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Repair Total Amount");
    				 formObj.rpr_cost_usd_amt.focus();
    				 return false;
    			 }
    		 }
    		 //[2009-10-13] ������ ����
    		 else if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="C")
    		 {
    			 if( formObj.ustl_acct_no.className  == "input1" ){
	    			 if(isNull(sheetObj.CellValue(i, prefix+"ustl_acct_no")))
	    			 {
	    				 if(moveRow != 0){
	    					 moveScreen(sheetObj, formObj, moveRow);
	    				 }
	    				 ComShowCodeMessage("OPF50009", "Unsettled Inter-Office Account No.");
	    				 formObj.ustl_acct_no.focus();
	    				 return false;
	    			 }
    			 }
    			 if(isNull(sheetObj.CellValue(i, prefix+"rpr_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Repair Total Amount");
    				 formObj.rpr_cost_usd_amt.focus();
    				 return false;
    			 }
    		 }
   			 
    		 else if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="Q")
    		 {
    			 if(isNull(sheetObj.CellValue(i, prefix+"qttn_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation USD Amount");
    				 formObj.qttn_cost_usd_amt.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.CellValue(i, prefix+"qttn_locl_curr_cd")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation Local Currency");
    				 formObj.qttn_locl_curr_cd.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.CellValue(i, prefix+"qttn_cost_locl_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation Local Amount");
    				 formObj.qttn_cost_locl_amt.focus();
    				 return false;
    			 }
    		 }
    	 }
    	
    }
    // Repair Tab Control End! ============================================================//
    
    // Compensation Tab Control Start! =======================================================//
    /**
     * Grid Data ȭ�鿡 Setting. <br>
     **/
    function setCmpnDisplayData(formObj){
    	var sheetObj = sheetObjects[3];
    	var thisRow = sheetObj.SelectRow;
    	var prefix = "sheet4_";
    	
    	var statusCode = sheetObj.CellValue(thisRow, prefix+"stv_dmg_cmpn_proc_sts_cd");
    	
    	if(statusCode=="R"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[0].checked = true;
    	}else if(statusCode=="C"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[1].checked = true;
    	}else if(statusCode=="N"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[2].checked = true;
    	}else if(statusCode=="A"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[3].checked = true;
    	}else if(statusCode=="J"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[4].checked = true;
    	}else if(statusCode=="P"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[5].checked = true;
    	}else if(statusCode=="E"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[6].checked = true;
    	}
    	if(sheetObjects[3].RowStatus(sheetObjects[3].SelectRow)=="R")
    	{
    		if(formObj.stv_dmg_cmpn_proc_sts_cd[0].checked){
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
        	}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[1].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[2].checked){
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[3].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[4].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[5].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[6].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		}
    	}
    	else{
    		/*formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = false;
    		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = true;*/
    	}
    	formObj.clm_hndl_ofc_cd_cmpn.value 			= sheetObj.CellValue(thisRow, prefix+"clm_hndl_ofc_cd");
    	formObj.clm_hndl_usr_id.value 				= sheetObj.CellValue(thisRow, prefix+"clm_hndl_usr_id");
    	formObj.clm_hndl_usr_name.value 			= sheetObj.CellValue(thisRow, prefix+"clm_hndl_usr_nm");
    	formObj.stv_dmg_respb_pty_co_nm.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_co_nm");
    	formObj.stv_dmg_respb_pty_pic_nm.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_pic_nm");
    	formObj.stv_dmg_respb_pty_pic_tit_nm.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_pic_tit_nm");
    	formObj.stv_dmg_cmpn_dt.value 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_cmpn_dt");
    	//formObj.cmpn_curr_cd.value 			= sheetObj.CellValue(thisRow, prefix+"cmpn_curr_cd");
    	comboObjects[9].Code2				= sheetObj.CellValue(thisRow, prefix+"cmpn_curr_cd");
    	formObj.cmpn_cost_locl_amt.value 	= sheetObj.CellText(thisRow, prefix+"cmpn_cost_locl_amt");
    	formObj.cmpn_cost_usd_amt.value 	= sheetObj.CellText(thisRow, prefix+"cmpn_cost_usd_amt");
    	formObj.cmpn_acct_no.value 		= sheetObj.CellValue(thisRow, prefix+"cmpn_acct_no");
    	formObj.cmpn_rmk.value 			= sheetObj.CellValue(thisRow, prefix+"cmpn_rmk");
    	formObj.cmpn_upd_usr_id.value 	= sheetObj.CellValue(thisRow, prefix+"upd_usr_id");
    	formObj.cmpn_upd_dt.value 		= sheetObj.CellValue(thisRow, prefix+"upd_dt");
    	
    	// Status�� �Է� ���� �ʵ� ����.
    	cmpnFormObjControl(formObj);
    	
    	setSubButton(2);
    }
    
    /**
     * Data �Է½� Hidden Grid�� �ش� Data Set. <br>
     **/
    function cmpn_change_event() {
    	var formObj = document.form;
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[3];
    	var prefix = "sheet4_";
    	
    	sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    	changeFlag = true;
    	
    	if(elementObj.name=="cmpn_cost_locl_amt") // && comboObjects[8].Code != "")
    	{
    		setCompensation_usd_amt(comboObjects[9].Code, elementObj.value, formObj.cmpn_cost_usd_amt);
    	}
    }
    
    /**
     * cmpn_curr_cd Combo Data ���ý� Hidden Grid�� �ش� Data Set. <br>
     **/
    function cmpn_curr_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj = document.form;
    	changeFlag = true;
    	if(loadFlag){
    		sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "sheet4_cmpn_curr_cd") = comboObj.Code;
    		setCompensation_usd_amt(comboObj.Code, document.form.cmpn_cost_locl_amt, formObj.cmpn_cost_usd_amt);
    	}
    }

    /**
     * Compensation Data Form Object Enable/Disable Control. <br>
     **/
    function cmpnFormObjControl(formObj){
    	
    	if(formObj.stv_dmg_cmpn_proc_sts_cd[2].checked
			|| formObj.stv_dmg_cmpn_proc_sts_cd[3].checked
			|| formObj.stv_dmg_cmpn_proc_sts_cd[4].checked)
    	{
    		formObj.stv_dmg_respb_pty_co_nm.readOnly = false;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly = false;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly = false;
    		formObj.stv_dmg_respb_pty_co_nm.className = "input1";
    		formObj.stv_dmg_respb_pty_pic_nm.className = "input1";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className = "input1";
    		
    		comboObjects[9].Enable = false;
    		formObj.stv_dmg_cmpn_dt.readOnly = true;
    		formObj.cmpn_cost_locl_amt.readOnly = true;
    		//formObj.cmpn_cost_usd_amt.readOnly = true;
    		formObj.cmpn_acct_no.readOnly = true;
    		formObj.stv_dmg_cmpn_dt.className = "input2";
    		formObj.cmpn_cost_locl_amt.className = "input2";
    		//formObj.cmpn_cost_usd_amt.className = "input2";
    		formObj.cmpn_acct_no.className = "input2";
    	}
    	else if(formObj.stv_dmg_cmpn_proc_sts_cd[5].checked){
    		
    		formObj.stv_dmg_respb_pty_co_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_co_nm.className = "input2";
    		formObj.stv_dmg_respb_pty_pic_nm.className = "input2";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className = "input2";
    		
    		comboObjects[9].Enable = true;
    		formObj.stv_dmg_cmpn_dt.readOnly = false;
    		formObj.cmpn_cost_locl_amt.readOnly = false;
    		//formObj.cmpn_cost_usd_amt.readOnly = false;
    		formObj.cmpn_acct_no.readOnly = false;
    		formObj.stv_dmg_cmpn_dt.className = "input1";
    		formObj.cmpn_cost_locl_amt.className = "input1";
    		//formObj.cmpn_cost_usd_amt.className = "input1";
    		formObj.cmpn_acct_no.className = "input1";
    	}
    	else{
    		formObj.stv_dmg_respb_pty_co_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_co_nm.className = "input2";
    		formObj.stv_dmg_respb_pty_pic_nm.className = "input2";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className = "input2";
    		
    		comboObjects[9].Enable = false;
    		formObj.stv_dmg_cmpn_dt.readOnly = true;
    		formObj.cmpn_cost_locl_amt.readOnly = true;
    		//formObj.cmpn_cost_usd_amt.readOnly = true;
    		formObj.cmpn_acct_no.readOnly = true;
    		formObj.stv_dmg_cmpn_dt.className = "input2";
    		formObj.cmpn_cost_locl_amt.className = "input2";
    		//formObj.cmpn_cost_usd_amt.className = "input2";
    		formObj.cmpn_acct_no.className = "input2";
    		
    	}
    }
    
    /**
     * Compensation ȭ�� ���Է°��� ���� ��ȿ������ ���μ��� ó��
     */
    function cmpnValidateForm(formObj){
        
        if(formObj.stv_dmg_cmpn_proc_sts_cd[0].checked
        	|| formObj.stv_dmg_cmpn_proc_sts_cd[1].checked
        	|| formObj.stv_dmg_cmpn_proc_sts_cd[6].checked)
        {
		}
        else if(formObj.stv_dmg_cmpn_proc_sts_cd[2].checked
        		|| formObj.stv_dmg_cmpn_proc_sts_cd[3].checked
        		|| formObj.stv_dmg_cmpn_proc_sts_cd[4].checked)
        {
        	if(isNull(formObj.stv_dmg_respb_pty_co_nm.value))
			{
				//ComShowMessage("[Company] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Company");
				formObj.stv_dmg_respb_pty_co_nm.focus();
				//ComSetFocus(formObj.stv_dmg_respb_pty_co_nm);
				return false;
			}
        	else if(isNull(formObj.stv_dmg_respb_pty_pic_nm.value))
			{
				//ComShowMessage("[Name] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Name");
				formObj.stv_dmg_respb_pty_pic_nm.focus();
				//ComSetFocus(formObj.stv_dmg_respb_pty_pic_nm);
				return false;
			}
        	else if(isNull(formObj.stv_dmg_respb_pty_pic_tit_nm.value))
			{
				//ComShowMessage("[Title] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Title");
				formObj.stv_dmg_respb_pty_pic_tit_nm.focus();
				//ComSetFocus(formObj.stv_dmg_respb_pty_pic_tit_nm);
				return false;
			}
        }
        else if(formObj.stv_dmg_cmpn_proc_sts_cd[5].checked){
        	if(isNull(formObj.stv_dmg_cmpn_dt.value))
			{
				//ComShowMessage("[Compensation Date] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation Date");
				formObj.stv_dmg_cmpn_dt.focus();
				//ComSetFocus(formObj.stv_dmg_cmpn_dt);
				return false;
			}
        	else if(isNull(comboObjects[9].Code))
			{
				//ComShowMessage("[Compensation Local Currency] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation Local Currency");
				formObj.cmpn_curr_cd.focus();
				//ComSetFocus(formObj.cmpn_curr_cd);
				return false;
			}
        	else if(isNull(formObj.cmpn_cost_locl_amt.value))
			{
				//ComShowMessage("[Compensation Local Amount] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation Local Amount");
				formObj.cmpn_cost_locl_amt.focus();
				return false;
			}
        	else if(isNull(formObj.cmpn_cost_usd_amt.value))
			{
				//ComShowMessage("[Compensation USD Amount] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation USD Amount");
				formObj.cmpn_cost_usd_amt.focus();
				//ComSetFocus(formObj.cmpn_cost_usd_amt);
				return false;
			}
        	else if(isNull(formObj.cmpn_acct_no.value))
			{
				//ComShowMessage("[Compensation Inter-Office No] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation Inter-Office No");
				formObj.cmpn_acct_no.focus();
				//ComSetFocus(formObj.cmpn_acct_no);
				return false;
			}
        }
        //return true;
    }
    // Compensation Tab Control End! =========================================================//
    
    // Settlement Tab Control Start! ==========================================================//
    /**
     * Grid Data ȭ�鿡 Setting. <br>
     **/
    function setStlDisplayData(formObj){
    	var sheetObj = sheetObjects[4];
    	var thisRow = sheetObj.SelectRow;
    	var prefix = "sheet5_";
    	
    	formObj.shp_ownr_co_nm.value 		= sheetObj.CellValue(thisRow, prefix+"shp_ownr_co_nm");
    	formObj.ustl_acct_no_stl.value 		= sheetObj.CellValue(thisRow, prefix+"ustl_acct_no");
    	formObj.run_rpr_acct_no_stl.value 	= sheetObj.CellValue(thisRow, prefix+"run_rpr_acct_no");
    	formObj.bil_inv_no.value 			= sheetObj.CellValue(thisRow, prefix+"bil_inv_no");
    	formObj.pay_dt.value 				= sheetObj.CellValue(thisRow, prefix+"pay_dt");
    	formObj.pay_curr_cd.value 			= sheetObj.CellValue(thisRow, prefix+"pay_curr_cd");
    	formObj.pay_locl_amt.value 		= sheetObj.CellText(thisRow, prefix+"pay_locl_amt");
    	formObj.pay_usd_amt.value 		= sheetObj.CellText(thisRow, prefix+"pay_usd_amt");
    	formObj.stl_inv_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"stl_inv_atch_knt");
    	formObj.stl_doc_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"stl_doc_atch_knt");
    	formObj.stl_rmk.value 			= sheetObj.CellValue(thisRow, prefix+"stl_rmk");
    	formObj.stl_upd_dt.value 		= sheetObj.CellValue(thisRow, prefix+"upd_dt");
    	formObj.stl_upd_usr_id.value 	= sheetObj.CellValue(thisRow, prefix+"upd_usr_id");
    	
    	setSubButton(3);
    }
    
    /**
     * Data �Է½� Hidden Grid�� �ش� Data Set. <br>
     **/
    function stl_change_event() {
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[4];
    	var prefix = "sheet5_";
    	
    	if(elementObj.name=="stl_inv_atch_flg"
			|| elementObj.name=="stl_doc_atch_flg")
    	{
    		if(elementObj.value > 0){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "Y";
    		}else{
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "N"
    		}
    	}
    	else{
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    	}
    	
    }
    
    /**
     * ��ȸ�� Data ������ Form Object readOnly ó��. <br>
     **/
    function setStlDatareadOnly(formObj) {
    	
    	formObj.pay_curr_cd.readOnly = true;
    	formObj.pay_locl_amt.readOnly = true;

        ComBtnDisable("btn_Save");
    }
    // Settlement Tab Control End! ============================================================//

    	
    /**
     * data ��ü ��ȸ. <br>
     **/
    function dataSearch(){
		// ��ȸ.
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "All");
		
		//[PIC of Claim Handling Office] ������.
        doActionIBSheet(sheetObjects[5],document.form, IBROWSEARCH, "MailContentPic");
		ComOpenWait(false);
		
		// OPF_STV_DMG ���� Update ���� ���� ����.
//		comboObjects[A].Enable = false;
		comboObjects[0].Enable = false;
		comboObjects[1].Enable = false;
		
		if(sheetObjects[2].RowCount > 0){
			setRprDisplayData(document.form);
		}else{
			initDefaultSheet(document.form, "Rpr");
			// Grid Data�� ȭ�鿡 Set..
            setRprDisplayData(document.form);
		}
		if(sheetObjects[3].RowCount > 0){
			setCmpnDisplayData(document.form);
		}else{
			initDefaultSheet(document.form, "Cmpn");
			// Grid Data�� ȭ�鿡 Set..
			setCmpnDisplayData(document.form);
		}
		if(sheetObjects[4].RowCount > 0){
			setStlDisplayData(document.form);
		}else{
			//initDefaultSheet(document.form, "Stl");
			setStlDatareadOnly(document.form);
		}
		
		// ������ Data ȭ�鿡 Set.
		setDisplayData(document.form, "", firstReqPortComboList);
    }
    
	/**
	 * Sheet Data�� XML���·� ��ȯ�Ͽ� �Ѱ��ش�. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheet Index No
	 * @version 2011.10.06
	 */
    function getSheetXml() {
    	var sXml = ComOpfSheet2Xml(sheetObjects[15]);
//        alert("�θ�âgetSheetXml:"+sXml);
        return sXml;
    }
    
	/**
	 * XML������ ����Ÿ�� Sheet�� Load�Ѵ�. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheet Index No
	 * @version 2011.10.06
	 */
    function setSheetXml(sXml) {
//    	alert("�θ�âsetSheetXml:"+sXml);
		sheetObjects[15].LoadSearchXml(sXml);
		var tempStr = sheetObjects[0].CellValue(1, "sheet1_stv_dmg_no");
		for(var i=1 ; i<=sheetObjects[15].RowCount ; i++){
			sheetObjects[15].CellValue2(i, "sheet20_stv_dmg_no") = tempStr;
			sheetObjects[15].CellValue2(i, "sheet20_stv_dmg_proc_cd") = "D";
			sheetObjects[15].RowStatus(i) = "I";
		}
    }
    
	/**
	 * ��ȸ�� Sheet�� Claim Handling User ����Ÿ�� Name�� Setting�Ѵ�. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @version 2011.10.06
	 */
    function setClaimHandlingUser(sheetObj){
 	    var usrName = "";
		for(var i=1 ; i<=sheetObjects[15].RowCount ; i++){
			if(i == sheetObjects[15].RowCount)
				usrName = usrName + sheetObjects[15].CellValue(i, "sheet20_clm_hndl_usr_nm");
			else
				usrName = usrName + sheetObjects[15].CellValue(i, "sheet20_clm_hndl_usr_nm")+", ";
		}
		sheetObj.CellValue2(1, "clm_hndl_usr_nm") = usrName;
    }
    
	/**
	 * Claim Handling User �� Update ������ �Ǻ��Ѵ�. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @version 2011.10.06
	 */
    function checkClaimHandlingUser(){
    	var sheetObj15 = sheetObjects[15];
    	var sheetObj16 = sheetObjects[16];
    	var sheet15Rc = sheetObj15.RowCount;
    	var sheet16Rc = sheetObj16.RowCount;
    	if(sheet15Rc != sheet16Rc){
    		return true;
    	}
    	for(var i=1 ; i<=sheet15Rc ; i++){
    		var val15 = sheetObj15.CellValue(i, "sheet20_clm_hndl_usr_id");
    		var idx = sheetObj16.FindText("sheet20_clm_hndl_usr_id", val15);
    		if(idx == -1){
    			return true;
    		}
    	}
    	return false;    	
    }
    
	/**
	 * Claim Handling User �� hidden sheet �� ����ȭ�Ѵ�. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @version 2011.10.06
	 */
    function setClaimHandingUserSheetSync(sts){
    	var sheetObj15 = sheetObjects[15];
    	for(var i=1 ; i<=sheetObj15.RowCount ; i++){
    		sheetObj15.RowStatus(i) = sts;
    	}
    	var sXml = getSheetXml();
    	sheetObjects[16].LoadSearchXml(sXml);
    }
    
	/**
	 * Tab �� ���� Claim Handling User �� hidden sheet �ʵ� ���� �����Ѵ�. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @version 2011.10.06
	 */
    function setClaimHandlingUserProcChange(procCd){
    	var sheetObj15 = sheetObjects[15];
    	for(var i=1 ; i<=sheetObj15.RowCount ; i++){
    		sheetObj15.CellValue2(i, "sheet20_stv_dmg_proc_cd") = procCd;
    	}
    	setClaimHandingUserSheetSync("I");
    }
    
    /**
     * Port ComboObject ����
     * @param strReqPortComboList
     * @return
     */
    function setReqPortCombo(strReqPortComboList){
    	var formObj = document.form;
 		if(strReqPortComboList != ""){
         	var dataList = strReqPortComboList.split("|");
         	for (var i = 0 ; i < dataList.length ; i++) {   
         		var comboItem = dataList[i].split(",");			
             		comboObjects[4].InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[0]);
         	}
  			document.all.item("inputReqPortCd").style.display = "none"; 
  			document.all.item("comboReqPortCd").style.display = "inline";
  			formObj.req_eta_dt.readOnly = true;
  			formObj.req_eta_dt.className = "input2";
  		 }else{
  			//���� �Է�
  			document.all.item("comboReqPortCd").style.display = "none";
     		document.all.item("inputReqPortCd").style.display = "inline";
     		formObj.req_eta_dt.readOnly = false;
     		formObj.req_eta_dt.className = "input";
  		 }
    }
    
    function setClaimHandlingUserStatus(sts){
		//Claim Handling User ���� ���� Ÿ ���� ������ ����
		if(!checkClaimHandlingUser()){
			for(var i=1 ; i<=sheetObjects[15].RowCount ; i++){
	   			sheetObjects[15].RowStatus(i) = sts;
	   		}
		}
	}
	/* ������ �۾�  �� */