/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_1053.js
*@FileTitle  : Stevedore Damage Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends
     * @class vop_opf_1053 : vop_opf_1053 business script for
     */
   	/* Developer performance	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var uploadObjects=new Array();
	var uploadCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var beforeSheet=1;
    var firstTabFlag=true;
    var userId="";
    var userNm="";
    var officeCd="";
    var dfCurrency="";
    var approvalFlag=false;
    var ofcAuth="";
    var changeFlag=false;
    var loadFlag=false;
    var aryPrefix =["sheet1_","sheet2_","sheet3_","sheet4_","sheet5_", "sheet7_", "sheet8_", "sheet9_", "sheet10_", "sheet11_", "sheet12_", "sheet13_", "sheet14_", "sheet15_"];
	var aryStvDmgProcCd = ["D", "D", "D", "R", "R", "R", "R", "S", "S"];
	var aryStvDmgAtchFileTpCd = ["SDR", "PIC", "DOC", "RES", "INV", "PIC", "DOC", "INV", "DOC"];
	var saveSheetId = "";

    //var old_cd = "";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
       　
    	var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
         //var prefix = "sheet1_";
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false; 
            switch(srcName) {
            	case "btn_SDR":
            	case "btn_Picture":
            	case "btn_Document":
            	case "btn_t2Result":
            	case "btn_t2Invoice":
            	case "btn_t2PIC":
            	case "btn_t2Document":
            	case "btn_t4Invoice":
            	case "btn_t4Document":
            		showUploadLayer(srcName);
            		break;
	            case "clm_hndl_ofc_cd_pop":
	            	//if(authPermission(0)){
	            	//if(!(formObject.clm_hndl_ofc_cd.readOnly)){
	            		ComOpenPopup("COM_ENS_071.do", 750, 480, "clm_hndl_ofc_cd_pop_event", "1,0,1", true);
	            	//}
	            	break;
	            case "req_skd_voy_dir_pop":
	            	//if(authPermission(0) && !(formObject.stv_dmg_req_cate_cd[2].checked))
	            	if(!(formObject.stv_dmg_req_cate_cd[2].checked))
	            	{
		            	var vsl_cd=formObject.vsl_cd.value;
	            		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 420, "req_skd_voy_dir_pop_event", "0,0", true);
	            	}
	            	break;
	            case "rpr_port_cd_pop":
	            	if((formObject.stv_dmg_rpr_proc_sts_cd[0].checked)){
	            		ComOpenPopup("VOP_VSK_0043.do", 422, 520, "popEvent_rpr_port_cd", "0,0", true);
	            	}
	            	break;
            	case "btn_stv_dmg_evnt_dt":
            		if(!(formObject.stv_dmg_evnt_dt.readOnly)){
            			var cal=new ComCalendar();
                    	cal.select(form.stv_dmg_evnt_dt, 'yyyy-MM-dd');
            		}
            		break;
            	case "btn_req_eta_dt":
            		if(!(formObject.stv_dmg_req_cate_cd[2].checked)){
            			var cal=new ComCalendar();
                    	cal.select(form.req_eta_dt, 'yyyy-MM-dd');
            		}
            		break;
            	case "btn_rpr_dt":
            		if((formObject.stv_dmg_rpr_proc_sts_cd[0].checked)){
            			var cal=new ComCalendar();
                    	cal.select(form.rpr_dt, 'yyyy-MM-dd');
            		}
            		break;
            	case "btn_stv_dmg_cmpn_dt":
            		if(formObject.stv_dmg_cmpn_proc_sts_cd[5].checked){
            			var cal=new ComCalendar();
                    	cal.select(form.stv_dmg_cmpn_dt, 'yyyy-MM-dd');
            		}
            		break;
            	case "btn_pay_dt":
            		var cal=new ComCalendar();
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
            		    var row = sheetObjects[2].GetSelectRow();
            			if(sheetObjects[2].RowCount()> 1&& sheetObjects[2].GetRowStatus(row)=="I"){
            				sheetObjects[2].SetRowStatus(row,"D");
                			moveScreen(sheetObjects[2], formObject, 0);
            			}
            		}
            		break;
				case "btnApproval":
					if(ComIsBtnEnable("btnApproval")){
						doActionIBSheet(sheetObject1,formObject,IBSAVE, "Approval");
					}
					break;
				case "btn_Save":
					if(ComIsBtnEnable("btn_Save")){
						changeFlag=true;
						var sheet1=sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow());
						var sheetIdx=tabObjects[0].GetSelectedIndex()+1;
//						if(ComShowConfirm(ComGetMsg("OPF50001", "Data"))){
							if(sheet1=="U"){
								return doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
							}
							if(isUpdate(sheetIdx))
							{
			    				if(sheetIdx==2)
			    				{
			    					if(isTrue(doActionIBSheet(sheetObjects[sheetIdx],formObject,IBSAVE))
			    						&& sheetObjects[4].RowCount()>0
			    						&& sheetObjects[sheetIdx].GetRowStatus(1)=="U")
			    					{
			    					    doActionIBSheet(sheetObjects[4],formObject,IBSAVE);
			    					}
			    				}
			    				else{
			    				    doActionIBSheet(sheetObjects[sheetIdx],formObject,IBSAVE);
			    				}
			    			}
//						}else{
//							return false;
//						}
					}
					break;
				case "btn_Print":
					rdOpen();
					break;
				case "btn_Mail":
			    	formObject.com_templateMrdArguments.value="/rp ["+formObject.stv_dmg_no.value+"]";
			    	ComSendMailModal();
			    	//ComSendMail();
			    	//ComOpenWindowCenter("COM_MAIL_COMMON_POPUP_MODAL.do", null, 770,560, true);  
					break;
				case "btn_Close":
					var opener=window.dialogArguments;
					if (!opener) opener=parent;	
					opener.call_1053();
					
					ComClosePopup();

					break;
				case "btn_Delete":
					var stvDmgNo=formObject.stv_dmg_no.value;
//					var resultXml1 = sheetObject1.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND02+"&stv_dmg_no="+stvDmgNo);
//
//					var delCheckInd = ComGetEtcData(resultXml1, "del_check_ind");
//
//					if (delCheckInd !="0"){
//						ComShowCodeMessage("OPF50026", stvDmgNo);
//						return false;
//					}
					var tabName="";
					var msgName="";
		    	     if(tabObjects[0].GetSelectedIndex()== 0){
		    	    	 tabName="Damage";
		    	    	 msgName="SDMS"
		    	     }else if(tabObjects[0].GetSelectedIndex()== 1){
		    	    	 tabName="Repair";
		    	    	 msgName="repair data";
		    	     }else if(tabObjects[0].GetSelectedIndex()== 2){
		    	    	 tabName="Compensation";
		    	    	 msgName="compensation data";
		    	     }else if(tabObjects[0].GetSelectedIndex()== 3){
		    	    	 tabName="Settlement";
		    	    	 msgName="settlement data";
		    	     }
 					var resultXml1=sheetObjects[0].GetSearchData("VOP_OPF_1053GS.do?f_cmd="+COMMAND01+"&tab_name="+tabName+"&stv_dmg_no="+stvDmgNo);
					var saveChkInd=ComGetEtcData(resultXml1, "save_check_ind");
					if (saveChkInd !="Y"){
						ComShowCodeMessage("OPF50026", stvDmgNo);
						return false;
					}
					if(ComShowCodeConfirm("OPF50002", msgName)){
						doActionIBSheet(sheetObject1,formObject,IBDELETE, "");
						if(tabName == "Damage"){
							ComClosePopup();
						}
					}
//					if(ComIsBtnEnable("btn_Delete")){
//
//						if(sheetObject1.RowStatus(sheetObject1.SelectRow)=="I"){
//
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
					var opener=window.dialogArguments;
					if (!opener) opener=parent;		
					opener.call_1053();
					break;
            } // end switch

            //file upload 관련 버튼
    		if (srcName.indexOf("btn_fileAdd") >= 0 ){
    			fileAdd(srcName);
    		} else if (srcName.indexOf("btn_fileDel") >= 0 ){
    			fileDel(srcName);
    		} else if (srcName.indexOf("btn_fileClose") >= 0 ){
    			hideUploadLayer();
    		}

    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    //RD common popup
    function rdOpen(){
    	var formObject=document.form;
    	var rdParam="/rp ["+formObject.stv_dmg_no.value+"]";
    	var strPath="apps/opus/vop/opf/stevedoredamagemgt/stevedoredamagemgt/report/VOP_OPF_1153.mrd";
    	formObject.com_mrdPath.value=strPath;
    	formObject.com_mrdArguments.value=rdParam;
    	ComOpenRDPopupModal();
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
		//uploadObj.AutoConfirm="UP_OVERWRITE_YES DELETE_YES";
		uploadObjects[uploadCnt++]=uploadObj;
	}
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * setting Combo
     * set item of Combo
     */
    function initCombo(comboObj) {
    	with(comboObj) {
    		switch(comboObj.options.id) {
	    		case "vps_port_cd":
	            	SetTitle("Port");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetBackColor("#CCFFFD");
 	            	ValidChar(2);
	            	SetMaxLength(5);
		            break;
		        case "vsl_oshp_cntr_blk_tp_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetBackColor("#CCFFFD");
		            break;
		        case "stv_dmg_prt_cate_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetBackColor("#CCFFFD");
		            break;
		        case "stv_dmg_prt_cd":
	            	SetTitle("Code|Part");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetBackColor("#CCFFFD");
		            break;
		        case "stv_dmg_tp_cd":
	            	SetTitle("Code|Damage");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
		            break;
		        case "req_port_cd":
	            	SetTitle("Port");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	//BackColor = "#CCFFFD";
 	            	ValidChar(2);
	            	SetMaxLength(5);
		            break;
		        case "stv_dmg_qttn_rsn_desc":
	            	SetTitle("Code|Description");
	            	SetColWidth(0, "45");
	            	SetColWidth(1, "140");
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetBackColor("#CCFFFD");
		            break;
		        case "stv_dmg_respb_desc":
	            	SetTitle("Code|Description");
	            	SetColWidth(0, "45");
	            	SetColWidth(1, "185");
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetBackColor("#CCFFFD");
		            break;
		        case "qttn_locl_curr_cd":
	            	SetTitle("Currency");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetBackColor("#CCFFFD");
 	            	ValidChar(2);
	            	SetMaxLength(3);
		            break;
		        case "cmpn_curr_cd":
	            	SetTitle("Currency");
	            	//SetColWidth("100|50|200")
	            	SetDropHeight(230);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetBackColor("#CCFFFD");
 	            	ValidChar(2);
	            	SetMaxLength(3);
		            break;
		    }
    	}
	}
    /**
     * Setting Tab
     * Set item of Tab
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "Damage" , "");
                    InsertItem( "Repair" , "");
                    InsertItem( "Compensation" , "");
                    InsertItem( "Settlement" , "");
                }
             break;
         }
    }
    /**
     * In case of clicking Tab event relation
     * activate element of Tab chosen
     */
    function tab1_OnChange(tabObj , nItem)
    {
    	if(firstTabFlag){
            var objs=document.all.item("tabLayer");
        	objs[beforetab].style.display="none";
        	objs[nItem].style.display="Inline";
        	//--------------- important --------------------------//
        	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
        	//------------------------------------------------------//
        	beforetab=nItem;
        	beforeSheet=beforetab+1;
        	firstTabFlag=false;
        	changeFlag=false;
        	//setSubButton(nItem);
    	}
    }
    /**
     * In case of clicking Tab event relation
     * activate element of Tab chosen
     *.
     */
    function tab1_OnClick(tabObj , nItem)
    {
    	var formObject=document.form;
    	var sheet1=sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow());
    	var aryTab = ["Damage", "Repair", "Compensation", "Settlement"];
    	var tabName=aryTab[nItem];

    	//var prefix = "sheet"+(beforeSheet+1)+"_";
    	if(sheet1=="U" || isUpdate(beforeSheet)){
    		if(ComIsBtnEnable("btn_Save") && ComShowConfirm(ComGetMsg("OPF50003"))){
    			if(sheet1=="U"){
        			if( !isTrue(doActionIBSheet(sheetObjects[0],formObject,IBSAVE)) )
        			{
        				tabObj.SetSelectedIndex(beforetab);
        				return false;
        			}
    			}
    			if(isUpdate(beforeSheet)){
    				if(beforeSheet==2 && sheetObjects[beforeSheet].GetRowStatus(1)=="U")
    				{
    					if( !isTrue(doActionIBSheet(sheetObjects[beforeSheet],formObject,IBSAVE)) )
            			{
    						tabObj.SetSelectedIndex(beforetab);
            				return false;
            			}
    					if(sheetObjects[4].RowCount()>0 && sheetObjects[4].GetRowStatus(1)!="I")
    					{
    						if( !isTrue(doActionIBSheet(sheetObjects[4],formObject,IBSAVE)) )
                			{
        						tabObj.SetSelectedIndex(beforetab);
                				return false;
                			}
                			//doActionIBSheet(sheetObjects[4],formObject,IBSAVE,"Refresh");
    					}
    				}
    				else{
    					if( !isTrue(doActionIBSheet(sheetObjects[beforeSheet],formObject,IBSAVE)) )
            			{
    						tabObj.SetSelectedIndex(beforetab);
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
    	if(!loadFlag){
    		tabObj.SetSelectedIndex(beforetab);
			return false;
		}
		else if(beforetab==0 && formObject.dmg_auth_sts_cd.value=="N"){
			ComShowCodeMessage("OPF50017");
			tabObj.SetSelectedIndex(beforetab);
			return false;
		}
		else{
			var objs=document.all.item("tabLayer");
        	objs[beforetab].style.display="none";
        	objs[nItem].style.display="Inline";
        	//--------------- important --------------------------//
        	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
        	//------------------------------------------------------//
        	beforetab=nItem;
        	beforeSheet=beforetab+1;
        	changeFlag=false;
        	setSubButton(nItem);
        	if(nItem==0 && authPermission(nItem)){
        		formObject.stv_dmg_ref_no.readOnly=false;
        		formObject.stv_dmg_ref_no.className="input";
        		formObject.clm_hndl_ofc_cd.readOnly=false;
        		formObject.clm_hndl_ofc_cd.className="input1";
        	}
        	else{
        		formObject.stv_dmg_ref_no.readOnly=true;
        		formObject.stv_dmg_ref_no.className="input2";
        		formObject.clm_hndl_ofc_cd.readOnly=true;
        		formObject.clm_hndl_ofc_cd.className="input2";
        	}
		}
    	var stvDmgNo=formObject.stv_dmg_no.value;
 		var resultXml1=sheetObjects[0].GetSearchData("VOP_OPF_1053GS.do?f_cmd="+COMMAND01+"&tab_name="+tabName+"&stv_dmg_no="+stvDmgNo);
		var saveChkInd=ComGetEtcData(resultXml1, "save_check_ind");
    	if(saveChkInd == 'Y' && authPermission(nItem)){
    		ComBtnEnable("btn_Save");
    	}else{
    		ComBtnDisable("btn_Save");
    	}
//    	if ((userId == sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_cre_usr_id") || OfficeCodeMgr.checkContainOfficeCode("000001", "OPF", officeCd)) && saveChkInd == 'Y'){
    	if (userId == sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_cre_usr_id") && saveChkInd == 'Y'){
    		 ComBtnEnable("btn_Delete");
    	 } else {
    		 ComBtnDisable("btn_Delete");
    	 }
    }
    function authPermission(nItem){
    	var formObj=document.form;
    	var authArr=formObj.user_auth;
    	var rVal=false;
    	switch(nItem){
    		case 0:
    			for(var i=0; i<authArr.length; i++){
    				if(authArr[i].value=='OPF01' || authArr[i].value=='OPF04'){
    					rVal=true;
    					break;
    				}else{
    					rVal=false;
    				}
    			}
    			break;
    		case 1:
    			for(var i=0; i<authArr.length; i++){
    				if(authArr[i].value=='OPF01' || authArr[i].value=='OPF05'){
    					rVal=true;
    					break;
    				}else{
    					rVal=false;
    				}
    			}
    			break;
    		case 2:
    			for(var i=0; i<authArr.length; i++){
    				if(authArr[i].value=='OPF01' || authArr[i].value=='OPF06'){
    					rVal=true;
    					break;
    				}else{
    					rVal=false;
    				}
    			}
    			break;
    		case 3:
    			for(var i=0; i<authArr.length; i++){
    				if(authArr[i].value=='OPF01'){
    					rVal=true;
    					break;
    				}else{
    					rVal=false;
    				}
    			}
    			if(rVal && officeCd == ofcAuth){
    				rVal=true;
    			}else{
    				rVal=false;
    			}
    			break;
    	}
//    	return rVal;
    	return true;
    }
     /**
      * setting Disable/Enable of Sub Button . <br>
      **/
     function setSubButton(nItem){
    	 var formObject=document.form;
    	 if(authPermission(nItem)){
    		 ComBtnEnable("btn_Save");
             if(sheetObjects[2].GetRowStatus(sheetObjects[2].GetSelectRow())=="I"){
        		 ComBtnEnable("rpr_seq_delete");
    		 }else{
    			 ComBtnDisable("rpr_seq_delete");
    		 }
     	 }
     	 else{
     		 ComBtnDisable("btn_Save");
     		 ComBtnDisable("rpr_seq_delete");
     	 }
     }
    /**
     * Grid Update Check <br>
     **/
    function isUpdate(sheetIdx) {
    	var updateStatus=false;
    	//var prefix = "sheet"+(sheetIdx+1)+"_";
    	for(i=1; i <= sheetObjects[sheetIdx].RowCount(); i++){
    		var shtStatus=sheetObjects[sheetIdx].GetRowStatus(i);
    		if(shtStatus=="I")
    		{
    			if(sheetIdx==2){
    				if(changeFlag
    					|| sheetObjects[sheetIdx].RowCount()> 1)
    				{
    					updateStatus=true;
    				}
    			}
    			else if(sheetIdx==3 && sheetObjects[sheetIdx].RowCount()==1){
    				if(changeFlag){
    					updateStatus=true;
    				}
    			}
    			else{
    				updateStatus=true;
    			}
    		}
    		else if(shtStatus=="U" || shtStatus=="D"){
    			updateStatus=true;
    		}
    	}
    	return updateStatus;
    }
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(comboXml) {
    	//var comboXml = sheetObj.GetSearchXml("VOP_OPF_1053GS.do" , FormQueryString(formObj));
    	//Port Combo List Set..
//    	var strPortCdList = ComGetEtcData(comboXml, "vvdPortComboList");
//    	setComboItem(comboObjects[A],strPortCdList);
    	//Vessel Category Combo List Set..
    	var vslCateCode=ComGetEtcData(comboXml, "vslCategory");
    	setComboItem(comboObjects[0], vslCateCode);
    	//Category Combo List Set..
    	var categoryCode=ComGetEtcData(comboXml, "categoryCode");
    	setComboItem(comboObjects[1], categoryCode);
    	//Damage Combo List Set..
    	var damageCode=ComGetEtcData(comboXml, "damageCode");
    	setComboItem2(comboObjects[3], damageCode);
    	// Requirement - Damage Reason Combo List.
    	var reqReasonCode=ComGetEtcData(comboXml, "reqReasonCode");
    	setComboItem3(comboObjects[4], reqReasonCode);
    	// Responsible - Damage Reason Combo List.
    	var resReasonCode=ComGetEtcData(comboXml, "resReasonCode");
    	setComboItem3(comboObjects[5], resReasonCode);
    	//Currency Code Combo List Set..
    	var strCurrencyCdList=ComGetEtcData(comboXml, "currencyCode");
    	setComboItem(comboObjects[6], strCurrencyCdList);
    	setComboItem(comboObjects[7], strCurrencyCdList);
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(strUsrId, strUsrNm, strOffcCd) {
        //ComOpenWait(true);
		for(i=0;i<sheetObjects.length;i++){
			//change start configuration method name
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//add last configuration method
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
		ComOpenWait(true);
    	for(var m=0; m<comboObjects.length; m++){
        	initCombo(comboObjects[m]);
        }
		//UPLOAD configuration
        for(var i=0;i<uploadObjects.length;i++){
		    //1. basic configuration
        	initUpload();
		    ComConfigUpload(uploadObjects[i], "/opuscntr/VOP_OPF_1053GS.do");
		}
		userId=strUsrId;
		userNm=strUsrNm;
		officeCd=strOffcCd;
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "All");
		//get [PIC of Claim Handling Office]         doActionIBSheet(sheetObjects[5],document.form, IBROWSEARCH, "MailContentPic");
		//doActionIBSheet(sheetObjects[5],document.form, IBROWSEARCH, "MailContentPic");
		ComOpenWait(false);
//		comboObjects[A].Enable = false;
		comboObjects[0].SetEnable(0);
		comboObjects[1].SetEnable(0);
		if(sheetObjects[2].RowCount()> 0){
			setRprDisplayData(document.form);
		}else{
			initDefaultSheet(document.form, "Rpr");
			// set Grid Data on page
            setRprDisplayData(document.form);
		}
		if(sheetObjects[3].RowCount()> 0){
			setCmpnDisplayData(document.form);
		}else{
			initDefaultSheet(document.form, "Cmpn");
			// set Grid Data on page
			setCmpnDisplayData(document.form);
		}
		if(sheetObjects[4].RowCount()> 0){
			setStlDisplayData(document.form);
		}else{
			//initDefaultSheet(document.form, "Stl");
			setStlDatareadOnly(document.form);
		}
		setDisplayData(document.form);
		//setSubButton(0);
		document.form.stv_dmg_prt_cate_cd.focus();
		ofcAuth=document.form.clm_hndl_ofc_cd.value;
		//check authority
    	var stvDmgNo=document.form.stv_dmg_no.value;
    	var tabName="Damage";
 		var resultXml1=sheetObjects[0].GetSearchData("VOP_OPF_1053GS.do?f_cmd="+COMMAND01+"&tab_name="+tabName+"&stv_dmg_no="+stvDmgNo);
		var saveChkInd=ComGetEtcData(resultXml1, "save_check_ind");
//		if((userId == sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_cre_usr_id") || OfficeCodeMgr.checkContainOfficeCode("000001", "OPF", officeCd) ) && saveChkInd == 'Y'){
		if(userId == sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_cre_usr_id") && saveChkInd == 'Y'){
			ComBtnEnable("btn_Delete");
    	}else{
    		ComBtnDisable("btn_Delete");
    	}
		// Flag which indicates whether page loading is done or not.
		loadFlag=true;
		//get [PIC of Claim Handling Office]
        doActionIBSheet(sheetObjects[5],document.form, IBROWSEARCH, "MailContentPic");
        //ComOpenWait(false);
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
//        axon_event.addListenerFormat('keypress',  'obj_keypress',   document.form);
//    	axon_event.addListener  ('keypress', 'engnum_keypress' , 'clm_hndl_ofc_cd'
//    															, 'clm_hndl_ofc_cd_cmpn'
//    															, 'cntr_no'
//    															, 'req_skd_voy_dir'
//    															, 'req_port_cd'
//    															, 'rpr_port_cd'
//    															, 'bil_inv_no'
//    															, 'pay_curr_cd');
//    	axon_event.addListener  ('keyup', 'obj_keyup' , 'req_skd_voy_dir'
//														, 'fm_tm_lss_dt'
//														//, 'fm_tm_lss_dt_hour'
//														, 'to_tm_lss_dt');
    	axon_event.addListener  ('click'  , 'change_event_checkbox', 'cntr_dmg_flg'
																	, 'cgo_dmg_flg');
    	axon_event.addListener  ('click'  , 'change_event_radio', 'stv_dmg_req_cate_cd'
				   												, 'stv_dmg_respb_pty_kwn_flg'
				   												, 'stv_dmg_cmpn_proc_sts_cd'
				   												, 'stv_dmg_rpr_proc_sts_cd');
    	axon_event.addListener  ('change'  , 'dmg_change_event', 'stv_dmg_ref_no'
	    													   //, 'clm_hndl_ofc_cd'
	    													   );
    	axon_event.addListener  ('change'  , 'dtl_change_event', 'stv_dmg_loc_desc'
															   , 'cntr_no'
															   , 'stv_dmg_rmk'
															   //, 'req_skd_voy_dir'
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
//    	axon_event.addListener  ('focus'  , 'focus_event', 'stv_dmg_ref_no'
//														 , 'clm_hndl_ofc_cd'
//														 , 'stv_dmg_loc_desc'
//														 , 'cntr_no'
//														 , 'stv_dmg_rmk'
//														 , 'req_skd_voy_dir'
//														 , 'stv_dmg_respb_desc_dtl'
//														 , 'rpr_port_cd'
//														 , 'rpr_vndr_nm'
//														 , 'ustl_acct_no'
//														 , 'run_rpr_acct_no'
//														 , 'rpr_rmk');
    	axon_event.addListener  ('blur'  , 'blur_event', 'stv_dmg_ref_no'
														 , 'clm_hndl_ofc_cd'
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
     *  Setting on Grid Data page  <br>
     **/
    function setDisplayData(formObj, gubun){
    	var sheetObj=null;
    	var thisRow=null;
    	var prefix="";
//		if(officePermission(0)){
    	if(authPermission(0)){
			formObj.stv_dmg_ref_no.readOnly=false;
			formObj.stv_dmg_ref_no.className="input";
			formObj.clm_hndl_ofc_cd.readOnly=false;
			formObj.clm_hndl_ofc_cd.className="input1";
    	}
    	else{
    		formObj.stv_dmg_ref_no.readOnly=true;
    		formObj.stv_dmg_ref_no.className="input2";
    		formObj.clm_hndl_ofc_cd.readOnly=true;
    		formObj.clm_hndl_ofc_cd.className="input2";
    	}
    	if(gubun!="Dtl"){
    		//** OPF_STV_DMG Data Set..
        	sheetObj=sheetObjects[0];
        	thisRow=sheetObj.GetSelectRow();
        	prefix="sheet1_";
        	formObj.vsl_cd.value=sheetObj.GetCellValue(thisRow, prefix+"vsl_cd");
        	formObj.skd_voy_no.value=sheetObj.GetCellValue(thisRow, prefix+"skd_voy_no");
        	formObj.skd_dir_cd.value=sheetObj.GetCellValue(thisRow, prefix+"skd_dir_cd");
            // Lane Code Set..
            formObj.f_cmd.value=SEARCH02;
         	var laneXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do" , FormQueryString(formObj));
        	var strLaneCode=ComGetEtcData(laneXml, "laneCode");
        	if(isNull(strLaneCode)){
        		formObj.slan_cd.value="";
        	}else{
        		formObj.slan_cd.value=strLaneCode;
        	}
            // Port Code Set..
//            setVVDPortCombo(sheetObj, formObj, "Vsl", false);
//            comboObjects[A].Code2				= sheetObj.CellValue(thisRow, prefix+"vps_port_cd");
        	formObj.vps_port_cd.value=sheetObj.GetCellValue(thisRow, prefix+"vps_port_cd");
			formObj.stv_dmg_evnt_dt.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_evnt_dt");
			comboObjects[0].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"vsl_oshp_cntr_blk_tp_cd"),false);
			comboObjects[1].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_prt_cate_cd"),false);
			formObj.stv_dmg_ref_no.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_ref_no");
			formObj.clm_hndl_ofc_cd.value=sheetObj.GetCellValue(thisRow, prefix+"clm_hndl_ofc_cd");
            // Approval Permission Set..
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
			formObj.auth_dt.value=sheetObj.GetCellValue(thisRow, prefix+"auth_dt");
    	}
        if(gubun!="Dmg"){
        	//** OPF_STV_DMG_DTL Data Set..
            sheetObj=sheetObjects[1];
        	thisRow=sheetObj.GetSelectRow();
        	prefix="sheet2_";
        	var cateCodeValue=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_prt_cd");
        	comboObjects[1].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_prt_cate_cd"),false);
        	stv_dmg_prt_cate_cd_OnChange(comboObjects[1], sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_prt_cate_cd"), "");
            comboObjects[2].SetSelectCode(cateCodeValue,false);
            sheetObj.SetCellValue(thisRow, prefix+"stv_dmg_prt_cd",cateCodeValue);
            comboObjects[3].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_tp_cd"),false);
            formObj.stv_dmg_loc_desc.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_loc_desc");
//            formObj.stv_dmg_rpt_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_rpt_atch_knt");
//            formObj.stv_dmg_pict_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_pict_atch_knt");
//            formObj.stv_dmg_doc_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_doc_atch_knt");
            
            formObj.stv_dmg_rpt_atch_knt.value	= sheetObjects[5].RowCount();
            formObj.stv_dmg_pict_atch_knt.value	= sheetObjects[6].RowCount();
            formObj.stv_dmg_doc_atch_knt.value	= sheetObjects[7].RowCount();
            
            if(sheetObj.GetCellValue(thisRow, prefix+"cntr_dmg_flg")=="Y"){
            	formObj.cntr_dmg_flg.checked=true;
            }else{
            	formObj.cntr_dmg_flg.checked=false;
            }
            if(sheetObj.GetCellValue(thisRow, prefix+"cgo_dmg_flg")=="Y"){
            	formObj.cgo_dmg_flg.checked=true;
            }else{
            	formObj.cgo_dmg_flg.checked=false;
            }
            formObj.cntr_no.value=sheetObj.GetCellValue(thisRow, prefix+"cntr_no");
            formObj.fm_tm_lss_dt.value=sheetObj.GetCellValue(thisRow, prefix+"fm_tm_lss_dt");
            formObj.to_tm_lss_dt.value=sheetObj.GetCellValue(thisRow, prefix+"to_tm_lss_dt");
            formObj.time_loss_hours.value="";
            if( !isNull(sheetObj.GetCellValue(thisRow, prefix+"fm_tm_lss_dt"))
            		&& !isNull(sheetObj.GetCellValue(thisRow, prefix+"to_tm_lss_dt")))
            {
            	formObj.time_loss_hours.value=getDateHoursBetween(sheetObj.GetCellValue(thisRow, prefix+"fm_tm_lss_dt"), sheetObj.GetCellValue(thisRow, prefix+"to_tm_lss_dt"));
            }
            formObj.stv_dmg_rmk.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_rmk");
            formObj.req_skd_voy_dir.value=sheetObj.GetCellValue(thisRow, prefix+"req_skd_voy_no") + sheetObj.GetCellValue(thisRow, prefix+"req_skd_dir_cd");
            formObj.req_port_cd.value=sheetObj.GetCellValue(thisRow, prefix+"req_port_cd");
            // Voyage Port Code Set..
//            setVVDPortCombo(sheetObj, formObj, "Voy", false);
//            comboObjects[44].Code2				= sheetObj.CellValue(thisRow, prefix+"req_port_cd");
            formObj.req_eta_dt.value=sheetObj.GetCellValue(thisRow, prefix+"req_eta_dt");
            if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="Q")
            {
            	formObj.stv_dmg_req_cate_cd[2].checked=true;
            	comboObjects[4].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_qttn_cd"),false);
            	formObj.req_reason_desc.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_qttn_rsn_desc");
            }
            else if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="R"){
            	formObj.stv_dmg_req_cate_cd[0].checked=true;
        	}
            else if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="S"){
        		formObj.stv_dmg_req_cate_cd[1].checked=true;
        	}
            if(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_flg")=="Y"){
            	formObj.stv_dmg_respb_pty_kwn_flg[0].checked=true;
            	formObj.stv_dmg_respb_desc_dtl.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_desc");
            	formObj.auth_dt.value="";
            }else{
            	formObj.stv_dmg_respb_pty_kwn_flg[1].checked=true;
            	comboObjects[5].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_cd"),false);
            	formObj.res_reason_desc.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_desc");
            }
            dmgFormObjControl(formObj, sheetObj, false);
            formObj.dmg_upd_dt.value=sheetObj.GetCellValue(thisRow, prefix+"upd_dt");
            formObj.dmg_upd_usr_id.value=sheetObj.GetCellValue(thisRow, prefix+"upd_usr_id");
        }
        setSubButton(0);
    }
    /**
     * Input only capital in onkeypress event of HTML Control <br>
     **/
//    function engnum_keypress() {
//    	var elementObj=event.srcElement;
//    	if(elementObj.name=="clm_hndl_ofc_cd"
//    		|| elementObj.name=="clm_hndl_ofc_cd_cmpn"){
//            ComKeyOnlyAlphabet('upper');
//    	}
//    	else{
//            ComKeyOnlyAlphabet('uppernum');
//    	}
//    }
    /**
     * change focus, in case of inputting Max Length of certain data . <br>
     **/
//    function obj_keyup() {
//    	ComKeyEnter('LengthNextFocus');
//    }
    /**
     * Input only number in onkeypress event of HTML Control <br>
     **/
//    function obj_keypress(){
//    	ComKeyOnlyNumber(event.srcElement, '.');
//    }
    /**
     * delete mask separator in onfocus event of HTML Control <br>
     **/
    function obj_activate(){
    	 if(event.srcElement.readOnly==false){
    		 ComClearSeparator(event.srcElement);
    	     //event.srcElement.focus();
    	     event.srcElement.select();
    	 }
    }
    /**
     *checking validation on onblur event of HTML Control<br>
     **/
    function obj_deactivate(){
    	 if(event.srcElement.readOnly==false){
    		  // dataformat Validation Check!
    		 	//ComChkObjValid(event.srcElement);
    	    	var vChkObjValidFlg=ComChkObjValid(event.srcElement);
    	    	var elementObj=event.srcElement;
    	    	var formObj=document.form;
    	    	if(elementObj.name=="stv_dmg_evnt_dt"){
    	    		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_"+elementObj.name,elementObj.value);
    	    	}
    	    	else if(elementObj.name=="req_eta_dt")
    	    	{
    	    		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_"+elementObj.name,elementObj.value);
    	    	}
    	    	if(elementObj.name=="fm_tm_lss_dt" || elementObj.name=="to_tm_lss_dt"){
            		if(isNull(formObj.fm_tm_lss_dt.value) || isNull(formObj.to_tm_lss_dt.value)){
            			formObj.time_loss_hours.value="";
             		}
            		else{
                		formObj.time_loss_hours.value=getDateHoursBetween(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
                	}
            		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_"+elementObj.name,elementObj.value);
            	}
    	    	else if(elementObj.name=="rpr_dt"){
    	    		//sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_"+elementObj.name) = elementObj.value;
    	    		if(vChkObjValidFlg && (elementObj.value != "")){
    	    			if( ComTrimAll(formObj.stv_dmg_evnt_dt.value, "-") <= ComTrimAll(elementObj.value, "-")){
    	    				sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "sheet3_"+elementObj.name,elementObj.value);
    	    			}else{
    	    				ComShowCodeMessage("OPF50013", "Repair Date", "Damage Date");
    	    				elementObj.value="";
    	    				ComSetFocus(elementObj);
    	    			}
    	    		}
    	    	}
    	    	else if(elementObj.name=="stv_dmg_cmpn_dt"){
    	    		sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "sheet4_"+elementObj.name,elementObj.value);
    	    	}
    	    	else if(elementObj.name=="pay_dt"){
    	    		sheetObjects[4].SetCellValue(sheetObjects[4].GetSelectRow(), "sheet5_"+elementObj.name,elementObj.value);
    	    	}
    	 }
    }
    /**
     * in case of inputting, set data applicable on Hidden Grid <br>
     **/
    function dmg_change_event() {
    	var elementObj=event.srcElement;
    	var sheetObj=sheetObjects[0];
    	var prefix="sheet1_";
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
    	changeFlag=true;
    }
    /**
     * in case of inputting, set data applicable on Hidden Grid <br>
     **/
    function dtl_change_event() {
    	var elementObj=event.srcElement;
    	var sheetObj=sheetObjects[1];
    	var formObj=document.form;
    	var prefix="sheet2_";
    	if(elementObj.name=="stv_dmg_respb_desc_dtl")
    	{
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"stv_dmg_respb_desc",elementObj.value);
    	}
    	else if(elementObj.name=="stv_dmg_respb_desc")
    	{
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"stv_dmg_respb_desc",elementObj.value);
    	}
    	else if(elementObj.name=="stv_dmg_rpt_atch_knt"
    			|| elementObj.name=="stv_dmg_pict_atch_knt"
    			|| elementObj.name=="stv_dmg_doc_atch_knt")
    	{
    		if(elementObj.value > 0){
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,"Y");
    			elementObj.className="input3";
    		}else{
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,"N");
    			elementObj.className="input";
    		}
    	}
    	else if(elementObj.name=="req_reason_desc"){
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"stv_dmg_qttn_rsn_desc",elementObj.value);
    	}
    	else if(elementObj.name=="res_reason_desc"){
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"stv_dmg_respb_desc",elementObj.value);
    	}
    	else if (elementObj.name=="req_port_cd") {/* req_port_cd */
    		if (doActionIBSheet(sheetObj,formObj,COMMAND01,"PORT|SUB")&&!isNull(elementObj.value)){
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"req_port_cd",elementObj.value);
	    			//doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "reqPortCd");
	    			//doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "etaDate");
    		} else {
    			ComShowCodeMessage("OPF50004", elementObj.value);
    			elementObj.value="";
    			document.form.req_port_cd.focus();
    			return false;
    		}
    	}
    	else{
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
    	}
    	changeFlag=true;
    }
    /**
     * in case of clicking Checkbox Data, set data applicable on Hidden Grid<br>
     **/
    function change_event_checkbox() {
    	var elementObj=event.srcElement;
    	var dataValue="N";
    	if(elementObj.checked){
    		dataValue="Y";
    	}
    	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_"+elementObj.name,dataValue);
    }
    /**
     * in case of clicking Radio button, set data applicableon hidden gird and change field editable. <br>
     **/
    function change_event_radio() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[1];
    	var elementObj=event.srcElement;
    	var prefix="sheet2_";
		
    	if(elementObj.name=="stv_dmg_req_cate_cd"){
    		dmgFormObjControl(formObj, sheetObj, true);
        	sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
    	}
    	else if(elementObj.name=="stv_dmg_respb_pty_kwn_flg"){
    	    var row = sheetObjects[0].GetSelectRow();
    		dmgFormObjControl(formObj, sheetObj, true);
        	sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
    		if(elementObj.value=="Y"){
    			if(formObj.dmg_auth_sts_cd.value != "Y"){
    				formObj.dmg_auth_sts_cd.value="X";
        			sheetObjects[0].SetCellValue(row, "sheet1_dmg_auth_sts_cd","X");
        			formObj.dmg_auth_sts_cd.className="input2";
        			document.getElementById("btnApproval").style.color="#c0c0c0";
        			if(approvalFlag){
        				formObj.auth_usr_id.value="";
        				formObj.auth_dt.value="";
        				sheetObjects[0].SetCellValue(row, "sheet1_auth_usr_id","");
        				sheetObjects[0].SetCellValue(row, "sheet1_auth_dt","");
        				ComBtnDisable("btnApproval");
        			}
    			}
    			formObj.stv_dmg_respb_desc_dtl.focus();
    		}
    		else{
    			if(formObj.dmg_auth_sts_cd.value != "Y"){
    				formObj.dmg_auth_sts_cd.value="N";
    				sheetObjects[0].SetCellValue(row, "sheet1_dmg_auth_sts_cd","N");
    				formObj.dmg_auth_sts_cd.className="input2_red";
    				document.getElementById("btnApproval").style.color="red";
    				if(approvalFlag){
    					formObj.auth_usr_id.value=userId;
        				formObj.auth_dt.value=ComGetNowInfo("ymd");
        				sheetObjects[0].SetCellValue(row, "sheet1_auth_usr_id",userId);
        				sheetObjects[0].SetCellValue(row, "sheet1_auth_dt",ComGetNowInfo("ymd"));
        				ComBtnEnable("btnApproval");
        			}
    			}
				formObj.stv_dmg_respb_desc.focus();
    		}
    	}
    	else if(elementObj.name=="stv_dmg_rpr_proc_sts_cd"){
    	    var row = sheetObjects[2].GetSelectRow();
    		if(sheetObjects[2].GetCellValue(row, "sheet3_"+elementObj.name) == "O" && sheetObjects[2].GetRowStatus(row) == "I"){
        		ComShowCodeMessage("OPF50020", "Ordered");
        		formObj.stv_dmg_rpr_proc_sts_cd[0].checked=true;
        		return false;
        	}
    		changeFlag=true;
    		sheetObjects[2].SetCellValue(row, "sheet3_"+elementObj.name,elementObj.value);
    		rprFormObjControl(formObj);
    	}
    	else if(elementObj.name=="stv_dmg_cmpn_proc_sts_cd"){
    		//if(sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "sheet4_"+elementObj.name) == "R" && sheetObjects[3].RowStatus(sheetObjects[3].SelectRow) == "I"){
        	//	ComShowCodeMessage("OPF50020", "Ready");
        	//	formObj.stv_dmg_cmpn_proc_sts_cd[0].checked = true;
        	//	return false;
        	//}
    		sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "sheet4_"+elementObj.name,elementObj.value);
    		cmpnFormObjControl(formObj);
    	}
    }
    /**
     * in case of selecting vsl_oshp_cntr_blk_tp_cd Combo Data, set data applicable on hidden grid  <br>
     **/
    function vsl_oshp_cntr_blk_tp_cd_OnChange(comboObj, idx_cd, text) {
    	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_vsl_oshp_cntr_blk_tp_cd",comboObj.GetSelectCode());
    }
    /**
     * set data applicable on Hidden Grid in case of selecting vps_port_cd Combo Data. <br>
     **/
    function vps_port_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_vps_port_cd",comboObj.GetSelectCode());
    }
    /**
     * set data applicable on Part Combo List in case of selecting Category Combo Data <br>
     **/
    function stv_dmg_prt_cate_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[1];
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet2_stv_dmg_prt_cate_cd",comboObj.GetSelectCode());
    	if(!isNull(comboObj.GetSelectCode())){
	    	formObj.f_cmd.value=SEARCH03;
 	    	var categoryPartXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do" , FormQueryString(formObj));
	    	var categoryPart=ComGetEtcData(categoryPartXml, "catePart");
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
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet2_stv_dmg_prt_cd","");
    	//formObj.stv_dmg_prt_cd.focus();
    }
    /**
     * set data applicable on Hidden Grid in case of selecting Part Combo Data  <br>
     **/
    function stv_dmg_prt_cd_OnBlur(comboObj, idx_cd, text) {
    	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_stv_dmg_prt_cd",comboObj.GetSelectCode());
    }
    /**
     * set data applicable on Hidden Grid in case of selecting Damage Combo Data <br>
     **/
    function stv_dmg_tp_cd_OnChange(comboObj, idx_cd, text) {
    	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_stv_dmg_tp_cd",comboObj.GetSelectCode());
    	document.form.stv_dmg_tp_cd.focus();
    	//ComSetFocus(document.form.stv_dmg_tp_cd);
    }
    /**
     * set data applicable on Hidden Grid in case of selecting Combo Data <br>
     **/
    function stv_dmg_qttn_rsn_desc_OnChange(comboObj, idx_cd, text) {
    	var sheetObj=sheetObjects[1];
    	var formObj=document.form;
    	var row = sheetObj.GetSelectRow();
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_qttn_cate_cd") = comboObj.GetText(comboObj.Code, 0);
    	sheetObj.SetCellValue(row, "sheet2_stv_dmg_qttn_cd",comboObj.GetText(comboObj.GetSelectCode(), 0));
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_qttn_rsn_desc") = comboObj.GetText(comboObj.Code, 1);
    	if(comboObj.GetSelectCode()=="TXT"){
    		sheetObj.SetCellValue(row, "sheet2_stv_dmg_qttn_rsn_desc","");
    		formObj.req_reason_desc.value="";
    		formObj.req_reason_desc.className="input1";
    		formObj.req_reason_desc.readOnly=false;
    		formObj.req_reason_desc.focus();
    	}
    	else{
    		sheetObj.SetCellValue(row, "sheet2_stv_dmg_qttn_rsn_desc",comboObj.GetText(comboObj.GetSelectCode(), 1));
    		formObj.req_reason_desc.value=comboObj.GetText(comboObj.GetSelectCode(), 1);
    		formObj.req_reason_desc.className="input2";
    		formObj.req_reason_desc.readOnly=true;
        	formObj.stv_dmg_qttn_rsn_desc.focus();
    	}
    }
    /**
     * set data applicable on Hidden Grid in case of selecting Combo Data <br>
     **/
    function stv_dmg_respb_desc_OnChange(comboObj, idx_cd, text) {
    	var sheetObj=sheetObjects[1];
    	var formObj=document.form;
    	var row = sheetObj.GetSelectRow();
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_cate_cd") = comboObj.GetText(comboObj.Code, 0);
    	sheetObj.SetCellValue(row, "sheet2_stv_dmg_respb_cd",comboObj.GetText(comboObj.GetSelectCode(), 0));
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_respb_desc") = comboObj.GetText(comboObj.Code, 1);
    	if(comboObj.GetSelectCode()=="TXT"){
    		sheetObj.SetCellValue(row, "sheet2_stv_dmg_respb_desc","");
    		formObj.res_reason_desc.value="";
    		formObj.res_reason_desc.className="input1";
    		formObj.res_reason_desc.readOnly=false;
    		formObj.res_reason_desc.focus();
    	}
    	else{
    		sheetObj.SetCellValue(row, "sheet2_stv_dmg_respb_desc",comboObj.GetText(comboObj.GetSelectCode(), 1));
    		formObj.res_reason_desc.value=comboObj.GetText(comboObj.GetSelectCode(), 1);
    		formObj.res_reason_desc.className="input2";
    		formObj.res_reason_desc.readOnly=true;
        	formObj.stv_dmg_respb_desc.focus();
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
 	 * setting data received from VVD Code Hepl(Pop-Up)<br>
 	 * @param {arry} obj
 	 */
 	function req_skd_voy_dir_pop_event(aryPopupData) {
		document.form.req_skd_voy_dir.value=aryPopupData[0][2]+aryPopupData[0][3];
		var row = sheetObjects[1].GetSelectRow();
		sheetObjects[1].SetCellValue(row, "sheet2_req_skd_voy_no",aryPopupData[0][2]);
		sheetObjects[1].SetCellValue(row, "sheet2_req_skd_dir_cd",aryPopupData[0][3]);
		document.form.req_port_cd.focus();
		//ComSetFocus(document.form.req_port_cd);
		//in case of inputing Voyage Dir Code, get req Port Code Combo Data
		setVVDPortCombo(sheetObjects[1], document.form, "Voy", true);
 	}
     /**
      * setting block in case of set focus on Text Form Object <br>
      **/
     function focus_event() {
    	 var elementObj=event.srcElement;
    	 if(elementObj.readOnly==false){
    	     elementObj.select();
    	 }
     }
     /**
      * setting block in case of set focus on Text Form Object <br>
      **/
     function blur_event() {
    	  var elementObj=event.srcElement;
    	  var formObj=document.form;
    	  if(elementObj.name=="clm_hndl_ofc_cd"){
    		  sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_clm_hndl_ofc_cd",elementObj.value);
	      }
    	  else if(elementObj.name=="req_skd_voy_dir"){
    		    if(!isNull(elementObj.value) && elementObj.value.length != elementObj.maxLength)
	  			{
    		    	ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
	  				elementObj.focus();
	  				return false;
	  			}
    		    else{
    		    	if (doActionIBSheet(sheetObjects[1],formObj,COMMAND01,"VVD|SUB")){ /* VSL CODE is valid */
    		    		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_req_skd_voy_no",elementObj.value.substring(0,4));
    		    		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_req_skd_dir_cd",elementObj.value.substring(4));
    		    		formObj.req_port_cd.focus();
    		    	} else if(!isNull(elementObj.value)){
    	    			ComShowCodeMessage("OPF50004", formObj.vsl_cd.value+elementObj.value);
    	    			formObj.req_skd_voy_dir.value="";
    		    		formObj.req_skd_voy_dir.focus();
    	    			return false;
    		    	}
    		    	// 1. get Port Code Combo Data
//    	      		var portFlag = setVVDPortCombo(sheetObjects[1], document.form, "Voy", true);
//    	  			if(!portFlag){ return false; }
//
//    	  			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_voy_no") = elementObj.value.substring(0,4);
//    	  			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_skd_dir_cd") = elementObj.value.substring(4);
	  			}
    	  }
    	  else if(elementObj.name=="rpr_port_cd"){
    		  if(!isNull(elementObj.value) && elementObj.value.length != elementObj.maxLength)
	  			{
  		    		ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
	  				elementObj.select();
	  				return false;
	  			}
  		    	else{
  		    		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "sheet3_"+elementObj.name,elementObj.value);
  		    	}
	      }
    	  elementObj.value=elementObj.value;
     }
    /**
     * in case of inputting VVD Code Data , VVD Port Combo Data Set. <br>
     **/
    function setVVDPortCombo(sheetObj, formObj, gubun, isUpdate) {
    	//initialize Combo data
    	var prefix=null;
    	var comboObj=null;
//    	if(gubun=="Vsl"){
//    		prefix = "sheet1_"
//    		comboObj = comboObjects[A];
//    		//formObj.slan_cd.value = "";
//    	}
//    	else if(gubun=="Voy"){
//    		prefix = "sheet2_"
//    		comboObj = comboObjects[44];
//    	}
    	//retrieve Combo data
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
    	var row = sheetObj.GetSelectRow();
		if(gubun=="Vsl"){
			if(isUpdate){
				comboObj.SetSelectIndex("-1");
    			sheetObj.SetCellValue(row, prefix+"vps_port_cd","");
			}
    		setComboItem(comboObj,strPortCdList);
    		formObj.vps_port_cd.focus();
    		return;
		}
		else if(gubun=="Voy"){
			if(isUpdate){
				comboObj.SetSelectIndex("-1");
    			sheetObj.SetCellValue(row, prefix+"req_port_cd","");
    			sheetObj.SetCellValue(row, prefix+"req_eta_dt","");
    			formObj.req_eta_dt.value="";
			}
    		setComboItem(comboObj,strPortCdList);
    		formObj.req_port_cd.focus();
    		return;
		}
    }
    /**
     * adding data on combo field
     */
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList=comboItems.split("|");
        	for (var i=0 ; i < dataList.length ; i++) {
        		var comboItem=dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
        	}
    	}
    }
    /**
     * adding data on combo field
     */
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList=comboItems.split("|");
        	for (var i=0 ; i < dataList.length ; i++) {
        		var comboItem=dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
        	}
    	}
    }
    /**
     * adding data on combo field
     */
    function setComboItem3(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList=comboItems.split("|");
        	for (var i=0 ; i < dataList.length ; i++) {
        		var comboItem=dataList[i].split(",");
        		//comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[1]);
        		comboObj.InsertItem(i, comboItem[1]+"|"+comboItem[2], comboItem[1]);
        	}
    	}
    }
	/**
	 * add files chosen to upload on pop-up IBSheet to IBUpload
	 * File Upload..
	 **/
	function setFileUpload() {
		var popSheetObj = sheetObjects[showedLayer+5];
		var popPrefix = aryPrefix[showedLayer+5];
		var stvDmgAtchFileTpCd = aryStvDmgAtchFileTpCd[showedLayer]
		var stvDmgProcCd = aryStvDmgProcCd[showedLayer]
		var formObj=document.form;
		var mastSheetObj, mastPrefix;
		var stvDmgAtchFlg="";

		if(stvDmgProcCd == "D"){
			mastSheetObj=sheetObjects[1];
			mastPrefix="sheet2_";
			//if RowStatus value isn't I, set as 'U'
			if(mastSheetObj.GetRowStatus(1) != "I"){
				mastSheetObj.SetRowStatus(1,"U");
			}

			switch(stvDmgAtchFileTpCd) {
				case "SDR": stvDmgAtchFlg="stv_dmg_rpt_atch"; break;
				case "PIC": stvDmgAtchFlg="stv_dmg_pict_atch"; break;
				case "DOC": stvDmgAtchFlg="stv_dmg_doc_atch"; break;
			}
		}else if(stvDmgProcCd == "R"){
			mastSheetObj=sheetObjects[2];
			mastPrefix="sheet3_";
			switch(stvDmgAtchFileTpCd) {
				case "RES": stvDmgAtchFlg="rpr_rslt_rpt_atch"; break;
				case "INV": stvDmgAtchFlg="rpr_inv_atch"; break;
				case "PIC": stvDmgAtchFlg="rpr_pict_atch"; break;
				case "DOC": stvDmgAtchFlg="rpr_doc_atch"; break;
			}
		}else if(stvDmgProcCd == "S"){
			mastSheetObj=sheetObjects[4];
			mastPrefix="sheet5_";
			//if RowStatus value isn't I, set as 'U'
			if(mastSheetObj.GetRowStatus(1) != "I"){
				mastSheetObj.SetRowStatus(1,"U");
			}
			switch(stvDmgAtchFileTpCd) {
				case "INV": stvDmgAtchFlg="stl_inv_atch"; break;
				case "DOC": stvDmgAtchFlg="stl_doc_atch"; break;
			}
		}

		var file_cnt=0;
		for (var rowIdx=1; rowIdx<=popSheetObj.LastRow(); rowIdx++){
			if (popSheetObj.GetCellValue(rowIdx, popPrefix+"file_nm")!="" &&  !popSheetObj.GetRowHidden(rowIdx)){
				file_cnt++;
			}
		}

		// setting file number
		var iRow = mastSheetObj.GetSelectRow();
		mastSheetObj.SetCellValue(iRow, mastPrefix + stvDmgAtchFlg+"_knt",file_cnt);
		eval("formObj."+stvDmgAtchFlg+"_knt").value=file_cnt;

		if(file_cnt > 0){
			mastSheetObj.SetCellValue(iRow, mastPrefix + stvDmgAtchFlg+"_flg","Y");
			eval("formObj."+stvDmgAtchFlg+"_knt").className="input3"
		}else{
			mastSheetObj.SetCellValue(iRow, mastPrefix + stvDmgAtchFlg+"_flg","N");
			eval("formObj."+stvDmgAtchFlg+"_knt").className="input"
		}

		return;
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
		              var HeadTitle="|STV_DMG_NO|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VPS_PORT_CD|STV_DMG_EVNT_DT|VSL_OSHP_CNTR_BLK_TP_CD|STV_DMG_REF_NO|CLM_HNDL_OFC_CD|DMG_AUTH_STS_CD|AUTH_USR_ID|AUTH_DT|UPD_USR_ID|UPD_DT|CRE_USR_ID";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="sheet1_";

		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);

		              var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"skd_voy_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"skd_dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vps_port_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_evnt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_oshp_cntr_blk_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"clm_hndl_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"dmg_auth_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"auth_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"auth_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

		              InitColumns(cols);

		              SetEditable(1);
		              SetSheetHeight(100);
                    }
                break;
            case "sheet2":
                with(sheetObj){
		              var HeadTitle="|STV_DMG_NO|STV_DMG_PRT_CATE_CD|STV_DMG_PRT_CD|STEVEDORE DAMAGE TYPE CODE|STV_DMG_LOC_DESC|STV_DMG_RPT_ATCH_FLG|STV_DMG_PICT_ATCH_FLG";
		              HeadTitle += "|STV_DMG_DOC_ATCH_FLG|CNTR_DMG_FLG|CGO_DMG_FLG|CNTR_NO|FM_TM_LSS_DT|TO_TM_LSS_DT|STV_DMG_RMK|STV_DMG_REQ_CATE_CD|REQ_VSL_CD|REQ_SKD_VOY_NO";
		              HeadTitle += "|REQ_SKD_DIR_CD|REQ_PORT_CD|REQ_ETA_DT|STV_DMG_QTTN_CD|STV_DMG_QTTN_RSN_DESC|STV_DMG_RESPB_PTY_KWN_FLG|STV_DMG_RESPB_CD|STV_DMG_RESPB_DESC|UPD_USR_ID|UPD_DT";
		              HeadTitle += "|stv_dmg_rpt_atch_knt|stv_dmg_pict_atch_knt|stv_dmg_doc_atch_knt";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="sheet2_";

		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);

		              var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_rpt_atch_knt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_pict_atch_knt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_doc_atch_knt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

		              InitColumns(cols);

		              SetEditable(1);
		              SetSheetHeight(100);
                    }
                break;
            case "sheet3":
                with(sheetObj){
		              var HeadTitle="|STV_DMG_NO|STV_DMG_RPR_SEQ|STV_DMG_RPR_PROC_STS_CD|QTTN_LOCL_CURR_CD|QTTN_COST_LOCL_AMT|QTTN_COST_USD_AMT|RPR_PORT_CD|RPR_DT";
		              HeadTitle += "|RPR_VNDR_NM|USTL_ACCT_NO|RUN_RPR_ACCT_NO|RPR_COST_USD_AMT|RPR_RSLT_RPT_ATCH_FLG|RPR_INV_ATCH_FLG|RPR_PICT_ATCH_FLG|RPR_DOC_ATCH_FLG";
		              HeadTitle += "|RPR_RMK|UPD_USR_ID|UPD_DT";
		              HeadTitle += "|rpr_rslt_rpt_atch_knt|rpr_inv_atch_knt|rpr_pict_atch_knt|rpr_doc_atch_knt";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="sheet3_";

		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);

		              var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"stv_dmg_rpr_seq" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_rpr_proc_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"qttn_locl_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"qttn_cost_locl_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"qttn_cost_usd_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_port_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ustl_acct_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"run_rpr_acct_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_cost_usd_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_rslt_rpt_atch_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_inv_atch_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_pict_atch_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_doc_atch_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_rslt_rpt_atch_knt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_inv_atch_knt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_pict_atch_knt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rpr_doc_atch_knt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

		              InitColumns(cols);

		              SetEditable(1);
		              SetSheetHeight(150);
                    }
                break;
            case "sheet4":
                with(sheetObj){
		              var HeadTitle="|STV_DMG_NO|STV_DMG_CMPN_PROC_STS_CD|CLM_HNDL_OFC_CD|CLM_HNDL_USR_ID|CLM_HNDL_USR_NM|STV_DMG_RESPB_PTY_CO_NM|STV_DMG_RESPB_PTY_PIC_NM|STV_DMG_RESPB_PTY_PIC_TIT_NM|STV_DMG_CMPN_DT|CMPN_CURR_CD|CMPN_COST_LOCL_AMT|CMPN_COST_USD_AMT|CMPN_ACCT_NO|CMPN_RMK|UPD_USR_ID|UPD_DT";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="sheet4_";

		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);

		              var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_cmpn_proc_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"clm_hndl_ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"clm_hndl_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"clm_hndl_usr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_respb_pty_co_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_respb_pty_pic_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_respb_pty_pic_tit_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_cmpn_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cmpn_curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cmpn_cost_locl_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cmpn_cost_usd_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cmpn_acct_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cmpn_rmk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

		              InitColumns(cols);

		              SetEditable(1);
		              SetSheetHeight(100);
                    }
                break;
            case "sheet5":
                with(sheetObj){
		              var HeadTitle="|STV_DMG_NO|SHP_OWNR_CO_NM|USTL_ACCT_NO|RUN_RPR_ACCT_NO|BIL_INV_NO|PAY_DT|PAY_CURR_CD|PAY_LOCL_AMT|PAY_USD_AMT|STL_INV_ATCH_FLG|STL_DOC_ATCH_FLG|STL_RMK|UPD_USR_ID|UPD_DT|stl_inv_atch_knt|stl_doc_atch_knt";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="sheet5_";

		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);

		              var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stv_dmg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"shp_ownr_co_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ustl_acct_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"run_rpr_acct_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bil_inv_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pay_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pay_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pay_locl_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pay_usd_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stl_inv_atch_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stl_doc_atch_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stl_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stl_inv_atch_knt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"stl_doc_atch_knt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

		              InitColumns(cols);

		              SetEditable(1);
		              SetSheetHeight(100);
                    }
                break;
            case "sheet7":	//IBUpload와연결된 IBSheet 9개
            case "sheet8":
            case "sheet9":
            case "sheet10":
            case "sheet11":
            case "sheet12":
            case "sheet13":
            case "sheet14":
            case "sheet15":
                with(sheetObj){
		             var HeadTitle="|Seq.|stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|serial_no";
		             var headCount=ComCountHeadTitle(HeadTitle);

		             var prefix=aryPrefix[sheetNo-1];

		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		             var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);

		             var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                          {Type:"Seq",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"strSeq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_atch_file_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"PopupEdit", Hidden:0,  Width:230,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"file_sav_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_proc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_atch_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                          {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"serial_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

		             InitColumns(cols);

		             SetEditable(1);
		             SetDataLinkMouse(prefix+"file_nm", true);
		             SetShowButtonImage(2);
		             SetSheetHeight(ComGetSheetHeight(sheetObj, 6));
		             SetVisible(false);
                  }
                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction, strFlag) {
	    switch(sAction) {
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
					port_cd=formObj.vps_port_cd.value;
					lane_cd=formObj.slan_cd.value;
				} else { /* sub */
					vsl_cd=formObj.vsl_cd.value;
					voy_no=formObj.req_skd_voy_dir.value.substring(0,4);
					dir_cd=formObj.req_skd_voy_dir.value.substring(4);
					port_cd=formObj.req_port_cd.value;
				}
				var resultXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?f_cmd="+COMMAND01+"&auto_skd_cng_flg="+str_tmp[0]+"&vsl_cd="+vsl_cd+"&skd_voy_no="+voy_no+"&skd_dir_cd="+dir_cd+"&vps_port_cd="+port_cd+"&slan_cd="+lane_cd);
				result=ComGetEtcData(resultXml, "result_chk");
				if (result==null ||result =="null"|| result=="" || result==undefined){
					return false;
				} else {
					return true;
				}
				break;
	      case IBSEARCH:      //Retrieve
	    	  var sheetID=sheetObj.id;
	    	  if(strFlag=="All"){
	    		  	formObj.f_cmd.value=SEARCH;
	    		  	ComUploadRemoveFile(upload1, "", true);

 	  	    		var sXml=sheetObj.GetSearchData("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	  	    		var arrXml=sXml.split("|$$|");
	  	    		for(var i=0; i<arrXml.length; i++){
	  	    		    sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
	  	    		}
	  	    		/*
	              	if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	              	if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
	              	if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
	              	if (arrXml.length > 3) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
	              	if (arrXml.length > 4) sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
	              	if (arrXml.length > 5) sheetObjects[5].LoadSearchData(arrXml[5],{Sync:1} );
	              	if (arrXml.length > 6) sheetObjects[6].LoadSearchData(arrXml[6],{Sync:1} );
	              	if (arrXml.length > 7) sheetObjects[7].LoadSearchData(arrXml[7],{Sync:1} );
	              	if (arrXml.length > 8) sheetObjects[8].LoadSearchData(arrXml[8],{Sync:1} );
	              	if (arrXml.length > 9) sheetObjects[9].LoadSearchData(arrXml[9],{Sync:1} );
	              	if (arrXml.length > 10) sheetObjects[10].LoadSearchData(arrXml[10],{Sync:1} );
	              	if (arrXml.length > 11) sheetObjects[11].LoadSearchData(arrXml[11],{Sync:1} );
	              	if (arrXml.length > 12) sheetObjects[12].LoadSearchData(arrXml[12],{Sync:1} );
	              	*/

	              	//Default ComboData Set..
	              	setDefaultComboData(arrXml[0]);
	              	//Approval permission Set..
	              	if(ComGetEtcData(arrXml[0], "approvalPermission")=="1"){
	              		approvalFlag=true;
					}else{
						approvalFlag=false;
					}
	              	//Repair Default Currency Set..
	              	dfCurrency=ComGetEtcData(arrXml[0], "defaultCurrency");
	    	  }
	    	  else if(sheetID=="sheet1"){
	    		  formObj.f_cmd.value=SEARCH01;
 	    		  sheetObjects[0].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
	    	  }
	    	  else if(sheetID=="sheet2"){
	    		  formObj.f_cmd.value=SEARCH02;
 	    		  sheetObjects[1].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
	    	  }
	    	  else if(sheetID=="sheet3"){
	    		  formObj.f_cmd.value=SEARCH03;
 	    		  sheetObjects[2].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_") );
	    	  }
	    	  else if(sheetID=="sheet4"){
	    		  formObj.f_cmd.value=SEARCH04;
 	    		  sheetObjects[3].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet4_") );
	    	  }
	    	  else if(sheetID=="sheet5"){
	    		  formObj.f_cmd.value=SEARCH05;
 	    		  sheetObjects[4].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet5_") );
	    	  } 
	        break;
	      case IBROWSEARCH:
	    	  if(strFlag=="dmgDate"){
	    		  formObj.f_cmd.value=SEARCH06;
 	    		  var dateXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do" , FormQueryString(formObj));
	    		  var etdDate=ComGetEtcData(dateXml, "etd_date");
	    		  if(isNull(etdDate)){
	    			  //ComShowMessage("ETD DB Data is not exist.");
	      			  ComShowCodeMessage("OPF50009", "ETD DB Data");
					  return;
	    		  }else{
	    			  var dateFlag=ComGetDaysBetween(formObj.stv_dmg_evnt_dt.value, etdDate);
	    			  if(dateFlag < 0){
	    				  //ComShowMessage("Damage Date must be earlier than ETD Date("+etdDate+").");
    	      			  ComShowCodeMessage("OPF50013", "ETD Date("+etdDate+")", "Damage Date");
	    				  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_evnt_dt","");
    	    			  formObj.stv_dmg_evnt_dt.value="";
    	    			  formObj.stv_dmg_evnt_dt.focus();
    	    			  return false;
	    			  }
	    			  else{
	    				  sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_evnt_dt",formObj.stv_dmg_evnt_dt.value);
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
	    		  formObj.f_cmd.value=SEARCH07;
	    		  //var ofcXml = sheetObj.GetSearchXml("COM_ENS_071GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
 	    		  var ofcXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
	    		  var ofcArr=ComOpfXml2Array(ofcXml, "ofc_cd");
	    		  if(isNull(ofcArr) || ofcArr.length < 1){
	      			  ComShowCodeMessage("OPF50004", "Data");
	      			  sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_clm_hndl_ofc_cd","");
	    			  formObj.clm_hndl_ofc_cd.value="";
	    			  formObj.clm_hndl_ofc_cd.focus();
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
	      case IBDELETE:
	    	  formObj.f_cmd.value=REMOVE;
	    	  var deleteParam=ComGetSaveString(sheetObj);
	    	  deleteParam=deleteParam +"&"+ FormQueryString(formObj);
	    	  var tabNo=tabObjects[0].GetSelectedIndex();
//    	    	  var saveXml = sheetObj.GetSaveXml("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), deleteParam);
	    	  var saveXml = sheetObj.GetSaveData("VOP_OPF_1053GS.do", "del_stv_dmg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_stv_dmg_no") + "&tabNo=" + tabNo + deleteParam);//"&fcmd=REMOVE");
	    	  //sheetObj.DoSave("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj), -1,false);
	    	  break;
	      case IBSAVE:        //save
    	      var row = sheetObj.GetSelectRow();
	    	  if(strFlag=="Approval"){
	    		  var stvDmgNo=sheetObj.GetCellValue(row, "sheet1_stv_dmg_no");
	    		  formObj.dmg_auth_sts_cd.value="Y";
	    		  formObj.auth_usr_id.value=userId;
  				  formObj.auth_dt.value=ComGetNowInfo("ymd");
  				  sheetObj.SetCellValue(row, "sheet1_dmg_auth_sts_cd","Y");
  				  sheetObj.SetCellValue(row, "sheet1_auth_usr_id",userId);
  				  sheetObj.SetCellValue(row, "sheet1_auth_dt",ComGetNowInfo("ymd"));
	    		  formObj.f_cmd.value=MODIFY01;
      	          sheetObj.DoAllSave("VOP_OPF_0052GS.do?stv_dmg_no="+stvDmgNo, FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet1_"));
  				  formObj.dmg_auth_sts_cd.className="input2";
  				  document.getElementById("btnApproval").style.color="#c0c0c0";
      	          break;
	    	  }
	    	  else{
	    		  var sheetID=sheetObj.id;
	    		  if(sheetID=="sheet1"){
	    			  if(isTrue(validateForm(sheetObj,formObj))){
	    				  formObj.f_cmd.value=MULTI01;
              	          sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet1_"), -1,false);
              	          sheetObj.SetCellValue(row, "sheet1_upd_usr_id",userId,0);
      	    		      sheetObj.SetCellValue(row, "sheet1_upd_dt",ComGetNowInfo("ymd"),0);
      	                  formObj.dmg_upd_usr_id.value=userId;
      	    	    	  formObj.dmg_upd_dt.value=ComGetNowInfo("ymd");
      	    	    	  ComAddSeparator(formObj.dmg_upd_dt);
	    	    	  }
	    			  else{
	    				  return false;
	    			  }
    	    	  }
    	    	  else if(sheetID=="sheet2"){
    	    		  if(isTrue(validateForm(sheetObj,formObj))){
    	    			  formObj.f_cmd.value=MULTI02;
    	    			  var sParam=ComGetSaveString(sheetObj);
    	    			  var prefixs=new Array("sheet2_","sheet7_","sheet8_","sheet9_");
    	    			  // add Upload Sheet Data to Query String
    	    			  var sParam2= FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
    	    			  
                          var arySheets = new Array(sheetObjects[5], sheetObjects[6], sheetObjects[7]);
                          var aryPrefixs = new Array("sheet7_serial_no","sheet8_serial_no","sheet9_serial_no");

    	    			  if (upload1.GetList().length == 0) {
            	    		  var fParam=ComGetSaveString(arySheets, true);
        	    			  sParam += "&" + fParam;
        	    			  sParam += "&" + sParam2;
                              //1. in case of not existing file to upload => change only DB Info
                              var saveXml=sheetObj.GetSaveData("VOP_OPF_1053GS.do", sParam);
                              sheetObj.LoadSaveData(saveXml);
                              saveXml=ComDeleteMsg(saveXml);
                          }
                          else{
        	    			  saveSheetId=sheetID;
                              //1. in case of existing file to upload => change DB Info and upload file.
                              var fParam = ComGetFileSaveString(arySheets, upload1, aryPrefixs, true);
        	    			  sParam += "&" + fParam;
        	    			  sParam += "&" + sParam2;
    		                  paramToForm(sParam);
    		                  upload1.SaveStatus();
                          }

                          if (upload1.GetList().length == 0) {
            	              formObj.f_cmd.value=SEARCH09;
        	                  var sParam = FormQueryString(formObj);
                              var stvDmgNo = sheetObjects[0].GetCellValue(row, "sheet1_stv_dmg_no");
                     	      sheetObjects[5].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=SDR&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet7_") );
                     	      sheetObjects[6].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet8_") );
                     	      sheetObjects[7].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet9_") );
                  	          sheetObj.SetCellValue(row, "sheet2_upd_usr_id",userId,0);
          	    		      sheetObj.SetCellValue(row, "sheet2_upd_dt",ComGetNowInfo("ymd"),0);
          	                  formObj.dmg_upd_usr_id.value=userId;
          	    	    	  formObj.dmg_upd_dt.value=ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.dmg_upd_dt);
          	    	      }

        	    	  }
    	    		  else{
	    				  return false;
	    			  }
    	    	  }
    	    	  else if(sheetID=="sheet3"){
    	    		  if(isTrue(rprValidateForm(formObj))){
        	    		  //formObj.f_cmd.value = MULTI03;
        	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet3_"), -1,false);
    	    			  formObj.f_cmd.value=MULTI03;
    	    			  var sParam=ComGetSaveString(sheetObj);
    	    			  var prefixs=new Array("sheet3_","sheet10_","sheet11_","sheet12_","sheet13_");
    	    			  var sParam2 = FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
                          var arySheets = new Array(sheetObjects[8], sheetObjects[9], sheetObjects[10], sheetObjects[11]);
        	    		  if (upload1.GetList().length == 0) {
        	    			  //1. in case of not existing file to upload => change only DB Info
            	    		  var fParam=ComGetSaveString(arySheets, true);
        	    			  sParam += "&" + fParam;
        	    			  sParam += "&" + sParam2;

         	    			  var saveXml=sheetObj.GetSaveData("VOP_OPF_1053GS.do", sParam);
             	    		  sheetObj.LoadSaveData(saveXml);
            	    		  saveXml=ComDeleteMsg(saveXml);
        	    		  }
        	    		  else{
        	    			  saveSheetId=sheetID;
                              //1. in case of existing file to upload => change DB Info and upload file.
                              var aryPrefixs = new Array("sheet10_serial_no","sheet11_serial_no","sheet12_serial_no","sheet13_serial_no");
                              var fParam = ComGetFileSaveString(arySheets, upload1, aryPrefixs,true);
        	    			  sParam += "&" + fParam;
        	    			  sParam += "&" + sParam2;
    		                  paramToForm(sParam);
    		                  upload1.SaveStatus();
        	    		  }

        	    		  if (upload1.GetList().length == 0) {
            	              formObj.f_cmd.value=SEARCH09;
        	                  var sParam = FormQueryString(formObj);
                              var stvDmgNo = sheetObjects[0].GetCellValue(row, "sheet1_stv_dmg_no");
                     	      sheetObjects[8].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=RES&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet10_") );
                     	      sheetObjects[9].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=INV&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet11_") );
                     	      sheetObjects[10].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet12_") );
                     	      sheetObjects[11].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet13_") );
                  	          sheetObj.SetCellValue(row, "sheet3_upd_usr_id",userId,0);
          	    		      sheetObj.SetCellValue(row, "sheet3_upd_dt",ComGetNowInfo("ymd"),0);
          	                  formObj.rpr_upd_usr_id.value=userId;
          	    	    	  formObj.rpr_upd_dt.value=ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.rpr_upd_dt);
          	    	      }
    	    		  }
    	    		  else{
	    				  return false;
	    			  }
    	    	  }
    	    	  else if(sheetID=="sheet4"){
    	    		  if(isTrue(cmpnValidateForm(formObj))){
        	    		  formObj.f_cmd.value=MULTI04;
        	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet4_"), -1,false);
        	    		  //setCmpnDisplayData(formObj);
        	    		  var sParam=ComGetSaveString(sheetObj);
        	    		  sParam=sParam +"&"+ FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet4_");
         	    		  var saveXml=sheetObj.GetSaveData("VOP_OPF_1053GS.do", sParam);
        	    		  sheetObj.SetCellValue(row, "sheet4_clm_hndl_ofc_cd",ComGetEtcData(saveXml, "clmHndlOfc"));
        	    		  sheetObj.SetCellValue(row, "sheet4_clm_hndl_usr_id",ComGetEtcData(saveXml, "clmHndlUsrId"));
        	    		  sheetObj.SetCellValue(row, "sheet4_clm_hndl_usr_nm",ComGetEtcData(saveXml, "clmHndlUsrNm"));
        	    		  setCmpnDisplayData(formObj);
              	          sheetObj.SetCellValue(row, "sheet4_upd_usr_id",userId,0);
      	    		      sheetObj.SetCellValue(row, "sheet4_upd_dt",ComGetNowInfo("ymd"),0);
      	                  formObj.cmpn_upd_usr_id.value=userId;
      	    	    	  formObj.cmpn_upd_dt.value=ComGetNowInfo("ymd");
      	    	    	  ComAddSeparator(formObj.cmpn_upd_dt);
         	    		  sheetObj.LoadSaveData(saveXml);
    	    		  }
    	    		  else{
	    				  return false;
	    			  }
    	    	  }
    	    	  else if(sheetID=="sheet5"){
    	    		  //formObj.f_cmd.value = MULTI05;
    	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet5_"), -1,false);
	    			  formObj.f_cmd.value=MULTI05;
	    			  var sParam=ComGetSaveString(sheetObj);
	    			  var prefixs=new Array("sheet5_","sheet14_","sheet15_");
	    			  //add Upload Sheet Data to Query String
	    			  var sParam2 = FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
                      var arySheets = new Array(sheetObjects[12], sheetObjects[13]);
    	    		  if(uploadObj.LocalFiles==""){
        	    		  var fParam=ComGetSaveString(arySheets, true);
    	    			  sParam += "&" + fParam;
    	    			  sParam += "&" + sParam2;
    	    			  //1. in case of not existing file to upload => change only DB Info
     	    			  var saveXml=sheetObj.GetSaveData("VOP_OPF_1053GS.do", sParam);
         	    		  sheetObj.LoadSaveData(saveXml);
        	    		  saveXml=ComDeleteMsg(saveXml);
    	    		  }
    	    		  else{
    	    			  saveSheetId=sheetID;
                          //1. in case of existing file to upload => change DB Info and upload file.
                          var aryPrefixs = new Array("sheet14_serial_no","sheet15_serial_no");
                          var fParam = ComGetFileSaveString(arySheets, upload1, aryPrefixs,true);
    	    			  sParam += "&" + fParam;
    	    			  sParam += "&" + sParam2;
		                  paramToForm(sParam);
		                  upload1.SaveStatus();
        	    	  }
        	    	  if(uploadObj.LocalFiles==""){
        	              formObj.f_cmd.value=SEARCH09;
        	              var sParam = FormQueryString(formObj);
                          var stvDmgNo = sheetObjects[0].GetCellValue(row, "sheet1_stv_dmg_no");
                 	      sheetObjects[12].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=S&stv_dmg_atch_file_tp_cd=INV&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet14_") );
                 	      sheetObjects[13].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=S&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet15_") );
              	          sheetObj.SetCellValue(row, "sheet5_upd_usr_id",userId,0);
      	    		      sheetObj.SetCellValue(row, "sheet5_upd_dt",ComGetNowInfo("ymd"),0);
      	                  formObj.stl_upd_usr_id.value=userId;
      	    	    	  formObj.stl_upd_dt.value=ComGetNowInfo("ymd");
      	    	    	  ComAddSeparator(formObj.stl_upd_dt);
      	    	      }
    	    	  }
      	          break;
	    	  }
	    }
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (document.form.f_cmd.value!=SEARCH01) return;
        setDisplayData(document.form, "Dmg");
    }
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        if (document.form.f_cmd.value!=SEARCH02) return;
        setDisplayData(formObj, "Dtl");
    }
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        if (formObj.f_cmd.value!=SEARCH03) return;
        if(sheetObj.RowCount()> 0){
            setRprDisplayData(formObj);
        }else{
            initDefaultSheet(formObj, "Rpr");
            setRprDisplayData(formObj);
        }
    }
    function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        if (formObj.f_cmd.value!=SEARCH04) return;
        if(sheetObj.RowCount()> 0){
            setCmpnDisplayData(formObj);
        }else{
            initDefaultSheet(formObj, "Cmpn");
            setCmpnDisplayData(formObj);
        }
    }
    function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        if (formObj.f_cmd.value!=SEARCH05) return;
        if(sheetObj.RowCount()> 0){
            setStlDisplayData(formObj);
        }else{
            //initDefaultSheet(formObj, "Stl");
            setStlDatareadOnly(formObj);
        }
    }


    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj){
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
    	var prefix="sheet2_";
        if(isNull(comboObjects[1].GetSelectCode())){
         	//ComShowMessage("\'Category\' is mandatory item.");
			ComShowCodeMessage("OPF50009", "Category");
         	formObj.stv_dmg_prt_cate_cd.focus();
         	return false;
        }
        else
        if(isNull(comboObjects[2].GetSelectCode())){
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
			if(isNull(comboObjects[4].GetSelectCode()))
			{
				ComShowCodeMessage("OPF50009", "Requirement- Reason");
				formObj.stv_dmg_qttn_rsn_desc.focus();
				return false;
			}
			else if(comboObjects[4].GetSelectCode()=="TXT" && isNull(formObj.req_reason_desc.value)){
				ComShowCodeMessage("OPF50009", "Requirement- Reason Description");
				formObj.req_reason_desc.focus();
				return false;
			}
		}
		if(formObj.stv_dmg_respb_pty_kwn_flg[0].checked){
			if(isNull(formObj.stv_dmg_respb_desc_dtl.value))
			{
				ComShowCodeMessage("OPF50009", "Responsible Party- Details");
				formObj.stv_dmg_respb_desc_dtl.focus();
				return false;
			}
		}else{
			if(isNull(comboObjects[5].GetSelectCode()))
			{
				ComShowCodeMessage("OPF50009", "Responsible Party- Reason");
				formObj.stv_dmg_respb_desc.focus();
				return false;
			}
			else if(comboObjects[5].GetSelectCode()=="TXT" && isNull(formObj.res_reason_desc.value)){
				ComShowCodeMessage("OPF50009", "Responsible- Reason Description");
				formObj.res_reason_desc.focus();
				return false;
			}
		}
        //return true;
    }
    /**
     * return whether True/False of value input
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
     * check validation of page From Date/ To Date
     */
    function checkDate(fromDate, toDate){
    	fromDate=fromDate.replace(/-/g,"");
    	toDate=toDate.replace(/-/g,"");
    	if(isNull(fromDate) || isNull(toDate)){
    		return true;
    	}
    	else{
    		//var dayTime = ComGetDaysBetween(fromDate, toDate);
    		var dayTime=getDateHoursBetween(fromDate, toDate);
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
     * Damage Data Form Object Enable/Disable Control. <br>
     */
    function dmgFormObjControl(formObj, sheetObj, clickFlag){
    	var prefix="sheet2_";
    	var row = sheetObj.GetSelectRow();
    	if(formObj.stv_dmg_req_cate_cd[2].checked){
    		if(clickFlag){
    			sheetObj.SetCellValue(row, prefix+"req_vsl_cd","");
        		sheetObj.SetCellValue(row, prefix+"req_skd_voy_no","");
        		sheetObj.SetCellValue(row, prefix+"req_skd_dir_cd","");
        		sheetObj.SetCellValue(row, prefix+"req_port_cd","");
        		sheetObj.SetCellValue(row, prefix+"req_eta_dt","");
        		sheetObj.SetCellValue(row, prefix+"req_port_cd","");
//        		comboObjects[44].RemoveAll();
//        		comboObjects[44].Index = "";
    		}
    		formObj.req_skd_voy_dir.value="";
    		formObj.req_port_cd.value="";
    		formObj.req_eta_dt.value="";
    		formObj.req_skd_voy_dir.readOnly=true;
    		formObj.req_port_cd.readOnly=true;
    		formObj.req_eta_dt.readOnly=true;
    		formObj.req_skd_voy_dir.className="input2";
    		formObj.req_port_cd.className="input2";
    		formObj.req_eta_dt.className="input2";
//    		comboObjects[44].Enable = false;
//    		comboObjects[4].Enable = true;
    		if(comboObjects[4].GetSelectCode()=="TXT"){
    			formObj.req_reason_desc.readOnly == false;
        		formObj.req_reason_desc.className="input1";
    		}
    		//formObj.stv_dmg_qttn_rsn_desc.focus();
    	}
    	else{
    		if(clickFlag){
    			sheetObj.SetCellValue(row, prefix+"req_vsl_cd",formObj.vsl_cd.value);
    			sheetObj.SetCellValue(row, prefix+"stv_dmg_qttn_cd","");
    			sheetObj.SetCellValue(row, prefix+"stv_dmg_qttn_rsn_desc","");
    		}
    		formObj.req_skd_voy_dir.readOnly=false;
    		//formObj.req_port_cd.readOnly = false;
    		formObj.req_eta_dt.readOnly=false;
    		formObj.req_skd_voy_dir.className="input";
    		//formObj.req_port_cd.className = "input1";
    		formObj.req_eta_dt.className="input";
//    		comboObjects[44].Enable = true;
    		comboObjects[4].SetSelectIndex("",false);
    		comboObjects[4].SetEnable(0);
    		formObj.req_reason_desc.value="";
    		formObj.req_reason_desc.readOnly == true;
    		formObj.req_reason_desc.className="input2";
    		//formObj.req_skd_voy_dir.focus();
    	}
    	if(formObj.stv_dmg_respb_pty_kwn_flg[0].checked){
        	formObj.stv_dmg_respb_desc_dtl.readOnly=false;
    		formObj.stv_dmg_respb_desc_dtl.className="input1";
    		comboObjects[5].SetSelectIndex("",false);
    		comboObjects[5].SetEnable(0);
    		formObj.res_reason_desc.value="";
    		formObj.res_reason_desc.readOnly == true;
    		formObj.res_reason_desc.className="input2";
    	}
    	else{
			formObj.stv_dmg_respb_desc_dtl.value="";
			formObj.stv_dmg_respb_desc_dtl.readOnly=true;
			formObj.stv_dmg_respb_desc_dtl.className="input2";
			comboObjects[5].SetEnable(1);
			if(comboObjects[5].GetSelectCode()=="TXT"){
    			formObj.res_reason_desc.readOnly == false;
        		formObj.res_reason_desc.className="input1";
    		}
			if(clickFlag){
				sheetObj.SetCellValue(row, prefix+"stv_dmg_respb_desc","");
    		}
    	}
    }
    // Repair Tab Control Start! ==========================================================//
    /**
     * in case of not existing data, initialize page and Grid chosen  <br>
     **/
    function initDefaultSheet(formObj, sheetFlag){
    	var sheetObj=null;
    	var row=null;
    	if(sheetFlag=="Rpr"){
    		sheetObj=sheetObjects[2];
    		//sheetObj.RemoveAll();
    		row=sheetObj.DataInsert(-1);
    		sheetObj.SetCellValue(row, "sheet3_stv_dmg_no",formObj.stv_dmg_no.value);
    		sheetObj.SetCellValue(row, "sheet3_stv_dmg_rpr_proc_sts_cd","O");
    		rprFormObjControl(formObj);
    		comboObjects[6].SetSelectCode(dfCurrency);
    		sheetObj.SetCellValue(row, "sheet3_qttn_locl_curr_cd",dfCurrency);
    		sheetObj.SetCellValue(row, "sheet3_rpr_rslt_rpt_atch_flg","N");
    		sheetObj.SetCellValue(row, "sheet3_rpr_inv_atch_flg","N");
    		sheetObj.SetCellValue(row, "sheet3_rpr_pict_atch_flg","N");
    		sheetObj.SetCellValue(row, "sheet3_rpr_doc_atch_flg","N");
    		setDisplaySeq(formObj, sheetObj);
    	}
    	else if(sheetFlag=="Cmpn"){
    		sheetObj=sheetObjects[3];
    		sheetObj.RemoveAll();
    		row=sheetObj.DataInsert();
    		sheetObj.SetCellValue(row, "sheet4_stv_dmg_no",formObj.stv_dmg_no.value);
    		sheetObj.SetCellValue(row, "sheet4_stv_dmg_cmpn_proc_sts_cd","R");
    		comboObjects[7].SetSelectCode(dfCurrency);
    		//sheetObj.CellValue(row, "sheet4_cmpn_curr_cd") = dfCurrency;
    		cmpnFormObjControl(formObj);
    	}
    }
    /**
     * Setting Grid Data page . <br>
     **/
    function setRprDisplayData(formObj){
    	var sheetObj=sheetObjects[2];
    	var thisRow=sheetObj.GetSelectRow();
    	var prefix="sheet3_";
var statusCode=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_rpr_proc_sts_cd");
    	if(statusCode=="O"){
    		formObj.stv_dmg_rpr_proc_sts_cd[0].checked=true;
    		//formObj.stv_dmg_rpr_proc_sts_cd[1].disabled = true;
    		//formObj.stv_dmg_rpr_proc_sts_cd[2].disabled = true;
    		//formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = true;
    	}else if(statusCode=="R"){
    		formObj.stv_dmg_rpr_proc_sts_cd[1].checked=true;
    	}else if(statusCode=="C"){
    		formObj.stv_dmg_rpr_proc_sts_cd[2].checked=true;
    	}else if(statusCode=="Q"){
    		formObj.stv_dmg_rpr_proc_sts_cd[3].checked=true;
    	}
    	rprFormObjControl(formObj);
    	formObj.rpr_cost_usd_amt.value=sheetObj.GetCellText(thisRow, prefix+"rpr_cost_usd_amt");
    	comboObjects[6].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"qttn_locl_curr_cd"),false);
    	formObj.qttn_cost_locl_amt.value=sheetObj.GetCellText(thisRow, prefix+"qttn_cost_locl_amt");
    	formObj.qttn_cost_usd_amt.value=sheetObj.GetCellText(thisRow, prefix+"qttn_cost_usd_amt");
    	formObj.rpr_port_cd.value=sheetObj.GetCellValue(thisRow, prefix+"rpr_port_cd");
    	formObj.rpr_dt.value=sheetObj.GetCellValue(thisRow, prefix+"rpr_dt");
    	formObj.rpr_vndr_nm.value=sheetObj.GetCellValue(thisRow, prefix+"rpr_vndr_nm");
    	formObj.ustl_acct_no.value=sheetObj.GetCellValue(thisRow, prefix+"ustl_acct_no");
    	formObj.run_rpr_acct_no.value=sheetObj.GetCellValue(thisRow, prefix+"run_rpr_acct_no");
    	formObj.rpr_cost_usd_amt.value=sheetObj.GetCellText(thisRow, prefix+"rpr_cost_usd_amt");
		formObj.rpr_rmk.value=sheetObj.GetCellValue(thisRow, prefix+"rpr_rmk");
		formObj.rpr_upd_usr_id.value=sheetObj.GetCellValue(thisRow, prefix+"upd_usr_id");
		formObj.rpr_upd_dt.value=sheetObj.GetCellValue(thisRow, prefix+"upd_dt");
		formObj.rpr_rslt_rpt_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"rpr_rslt_rpt_atch_knt");
		formObj.rpr_inv_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"rpr_inv_atch_knt");
		formObj.rpr_pict_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"rpr_pict_atch_knt");
		formObj.rpr_doc_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"rpr_doc_atch_knt");
    	setDisplaySeq(formObj, sheetObj);
    	setRprTotalAmt(formObj, sheetObj);
    	setSubButton(1);
    }
    /**
     * Display Sequence Set. <br>
     */
    function setDisplaySeq(formObj, sheetObj){
    	formObj.stv_dmg_rpr_seq.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet3_stv_dmg_rpr_seq");
    	formObj.stv_dmg_rpr_seq_total.value=sheetObj.RowCount();
    }
    /**
     * function moving page of Prev/Next button <br>
     **/
    function moveScreen(sheetObj, formObj, moveSeq) {
    	if( moveSeq==-1 && sheetObj.GetSelectRow()==1 ){
        	//ComShowMessage("No more Previous Page.");
        	return false;
        }
        else if( moveSeq==1 && sheetObj.GetSelectRow()==sheetObj.LastRow()){
        	var addFlag=true;
        	for(var i=1; i<=sheetObj.RowCount(); i++){
        		if(sheetObj.GetRowStatus(i)=="I"){
        			addFlag=false;
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
                setRprDisplayData(formObj);
        	}else{
        		return false;
        	}
        }
        else{
        	//if(isTrue(rprValidateForm(formObj))){
        		sheetObj.SetSelectRow(sheetObj.GetSelectRow()+ moveSeq);
                setRprDisplayData(formObj);
        	//}
        }
    }
    /**
     * in case of inputting, set data applicable on Hidden Grid <br>
     **/
    function rpr_change_event() {
    	changeFlag=true;
    	var elementObj=event.srcElement;
    	var formObj=document.form;
    	var sheetObj=sheetObjects[2];
    	var prefix="sheet3_";
    	var row = sheetObj.GetSelectRow();
    	if(elementObj.name=="rpr_cost_usd_amt"){
        	sheetObj.SetCellValue(row, prefix+elementObj.name,elementObj.value);
    		setRprTotalAmt(document.form, sheetObj);
    	}
    	else if(elementObj.name=="rpr_rslt_rpt_atch_flg"
				|| elementObj.name=="rpr_inv_atch_flg"
				|| elementObj.name=="rpr_pict_atch_flg"
				|| elementObj.name=="rpr_doc_atch_flg")
		{
			if(elementObj.value > 0){
				sheetObj.SetCellValue(row, prefix+elementObj.name,"Y");
			}else{
				sheetObj.SetCellValue(row, prefix+elementObj.name,"N");
			}
		}
    	else if(elementObj.name=="ustl_acct_no" || elementObj.name=="run_rpr_acct_no")
    	{
    		sheetObj.SetCellValue(row, prefix+elementObj.name,elementObj.value);
    		// in case of changing  InterOfficeAccountNo and RunRepairAccountNo of first Seq , modify data of Settlement Tab too.
    		if(row==1 && sheetObjects[4].RowCount()>0){
    			sheetObjects[4].SetCellValue(1, "sheet5_ustl_acct_no",elementObj.value);
    			sheetObjects[4].SetCellValue(1, "sheet5_run_rpr_acct_no",elementObj.value);
    			document.form.ustl_acct_no_stl.value=elementObj.value;
    			document.form.run_rpr_acct_no_stl.value=elementObj.value;
    		}
    	}
    	else{
    		sheetObj.SetCellValue(row, prefix+elementObj.name,elementObj.value);
    	}
    	if(elementObj.name=="qttn_cost_locl_amt" && comboObjects[6].GetSelectCode()!= "")
    	{
    		setRepair_usd_amt(comboObjects[6].GetSelectCode(), elementObj.value, formObj.qttn_cost_usd_amt);
    	}
    }
    /**
     * in case of selecting qttn_locl_curr_cd Combo Data , set data applicalbe on Hidden Grid <br>
     **/
    function qttn_locl_curr_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj=document.form;
    	if(loadFlag){
    		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "sheet3_qttn_locl_curr_cd",comboObj.GetSelectCode());
    		setRepair_usd_amt(comboObj.GetSelectCode(), document.form.qttn_cost_locl_amt, formObj.qttn_cost_usd_amt);
    	}
    }
    /* get Repair - USD AMT
     * curr_cd   : Curr Code
     * local_amt : Local Amt
     * obj       : state of calculated value set
     */
	function setRepair_usd_amt(curr_cd, local_amt, obj){
	    var formObj=document.form;
    	formObj.f_cmd.value=SEARCH07;
 		var sXml=sheetObjects[5].GetSearchData("VOP_OPF_1053GS.do", FormQueryString(formObj));
		obj.value=ComGetEtcData(sXml, "usdAmt");
		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "sheet3_qttn_cost_usd_amt",obj.value);
	}
    /* get Compensation - USD AMT
     * curr_cd   : Curr Code
     * local_amt : Local Amt
     * obj       : state of calculated value set
     */
	function setCompensation_usd_amt(curr_cd, local_amt, obj){
		var formObj=document.form;
	   	formObj.f_cmd.value=SEARCH08;
 		var sXml=sheetObjects[5].GetSearchData("VOP_OPF_1053GS.do", FormQueryString(formObj));
		obj.value=ComGetEtcData(sXml, "usdAmt");
		sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "sheet4_cmpn_cost_usd_amt",obj.value);
	}
     /**
      * in case of selecting req_port_cd Combo Data, set data applicalbe on Hidden Grid <br>
      **/
     function req_port_cd_OnChange(comboObj, idx_cd, text) {
     	var formObj=document.form;
     	var sheetObj=sheetObjects[1];
     	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet2_req_port_cd",comboObj.GetSelectCode());
//     	if(!isNull(comboObj.Code)){
//			doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "etaDate");
//		}
     	formObj.req_port_cd.focus();
     }
    /**
     * Popup Data Validation Check. <br>
     **/
    function popEvent_rpr_port_cd(aryPopupData) {
    	document.form.rpr_port_cd.value=aryPopupData[0][2];
    	sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "sheet3_rpr_port_cd",aryPopupData[0][2]);
    }
    /**
     * Repair Total Amount calculate. <br>
     **/
    function setRprTotalAmt(formObj, sheetObj){
    	var amtTotal=0;
    	for(i=1; i<= sheetObj.RowCount(); i++){
    		amtTotal += parseFloat(sheetObj.GetCellValue(i, "sheet3_rpr_cost_usd_amt"));
    		//amtTotal = amtTotal.toFixed(2);
    	}
    	formObj.rpr_cost_usd_amt_total.value=amtTotal;
    	ComAddSeparator(formObj.rpr_cost_usd_amt_total);
    }
    /**
     * Repair Data Form Object Enable/Disable Control. <br>
     **/
    function rprFormObjControl(formObj)
    {
    	if(formObj.stv_dmg_rpr_proc_sts_cd[0].checked)
    	{
    		formObj.stv_dmg_rpr_proc_sts_cd[2].disabled=true;
			comboObjects[6].SetEnable(0);
			formObj.qttn_cost_locl_amt.readOnly=true;
			//formObj.qttn_cost_usd_amt.readOnly = true;
			formObj.qttn_cost_locl_amt.className="input2";
			//formObj.qttn_cost_usd_amt.className = "input2";
			formObj.rpr_port_cd.readOnly=false;
			formObj.rpr_dt.readOnly=false;
			formObj.rpr_vndr_nm.readOnly=false;
			formObj.rpr_port_cd.className="input1";
			formObj.rpr_dt.className="input1";
			formObj.rpr_vndr_nm.className="input1";
			formObj.ustl_acct_no.readOnly=true;
			formObj.run_rpr_acct_no.readOnly=true;
			formObj.rpr_cost_usd_amt.readOnly=true;
			formObj.ustl_acct_no.className="input2";
			formObj.run_rpr_acct_no.className="input2";
			formObj.rpr_cost_usd_amt.className="input2";
		}
    	else if(formObj.stv_dmg_rpr_proc_sts_cd[1].checked
        		|| formObj.stv_dmg_rpr_proc_sts_cd[2].checked)
    	{
   			formObj.stv_dmg_rpr_proc_sts_cd[2].disabled=false;
			comboObjects[6].SetEnable(0);
			formObj.qttn_cost_locl_amt.readOnly=true;
			//formObj.qttn_cost_usd_amt.readOnly = true;
			formObj.qttn_cost_locl_amt.className="input2";
			//formObj.qttn_cost_usd_amt.className = "input2";
			formObj.rpr_port_cd.readOnly=true;
			formObj.rpr_dt.readOnly=true;
			formObj.rpr_vndr_nm.readOnly=true;
			formObj.rpr_port_cd.className="input2";
			formObj.rpr_dt.className="input2";
			formObj.rpr_vndr_nm.className="input2";
			if(sheetObjects[1].GetCellValue(1, "sheet2_stv_dmg_respb_pty_kwn_flg")=="Y"){
				formObj.ustl_acct_no.readOnly=false;
				formObj.run_rpr_acct_no.readOnly=true;
				formObj.ustl_acct_no.className="input1";
				formObj.run_rpr_acct_no.className="input2";
			}
			else{
				formObj.ustl_acct_no.readOnly=true;
				formObj.run_rpr_acct_no.readOnly=false;
				formObj.ustl_acct_no.className="input2";
				formObj.run_rpr_acct_no.className="input";
			}
			formObj.rpr_cost_usd_amt.readOnly=false;
			formObj.rpr_cost_usd_amt.className="input1";
		}
    	else if(formObj.stv_dmg_rpr_proc_sts_cd[3].checked)
    	{
    		formObj.stv_dmg_rpr_proc_sts_cd[2].disabled=true;
			comboObjects[6].SetEnable(1);
			formObj.qttn_cost_locl_amt.readOnly=false;
			//formObj.qttn_cost_usd_amt.readOnly = false;
			formObj.qttn_cost_locl_amt.className="input1";
			//formObj.qttn_cost_usd_amt.className = "input1";
			formObj.rpr_port_cd.readOnly=true;
			formObj.rpr_dt.readOnly=true;
			formObj.rpr_vndr_nm.readOnly=true;
			formObj.rpr_port_cd.className="input2";
			formObj.rpr_dt.className="input2";
			formObj.rpr_vndr_nm.className="input2";
			formObj.ustl_acct_no.readOnly=true;
			formObj.run_rpr_acct_no.readOnly=true;
			formObj.rpr_cost_usd_amt.readOnly=true;
			formObj.ustl_acct_no.className="input2";
			formObj.run_rpr_acct_no.className="input2";
			formObj.rpr_cost_usd_amt.className="input2";
		}
    }
    /**
     * Repair handling process for input validation
     */
    function rprValidateForm(formObj){
    	 var sheetObj=sheetObjects[2];
    	 var prefix="sheet3_";
    	 for(var i=1; i<= sheetObj.LastRow(); i++)
    	 {
    		 var moveRow=i - sheetObj.GetSelectRow();
    		 //if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="O" || sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="C")
    		 if(sheetObj.GetCellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="O")
    		 {
    			 if(isNull(sheetObj.GetCellValue(i, prefix+"rpr_port_cd")))
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
    				 formObj.f_cmd.value=COMMAND13;
 	   	    		 var polXml=sheetObj.GetSearchData("VOP_VSK_0043GS.do?op=0043&loc_cd="+sheetObj.GetCellValue(i, prefix+"rpr_port_cd") , FormQueryString(formObj));
	   	    		 var strPolCd=ComGetEtcData(polXml, "port_name");
	   	    		 if(isNull(strPolCd)){
		   	      		  if(moveRow != 0){
	       					  moveScreen(sheetObj, formObj, moveRow);
	       				  }
	   	      			  ComShowCodeMessage("OPF50004", "Data");
	   	    			  sheetObj.SetCellValue(i, "sheet3_rpr_port_cd","");
	   	    			  formObj.rpr_port_cd.value="";
	   	    			  formObj.rpr_port_cd.focus();
	 					  return false;
	   	    		 }
    			 }
    			 if(isNull(sheetObj.GetCellValue(i, prefix+"rpr_dt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Date");
    				 formObj.rpr_dt.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.GetCellValue(i, prefix+"rpr_vndr_nm")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Vendor");
    				 formObj.rpr_vndr_nm.focus();
    				 return false;
    			 }
    		 }
    		 else if(sheetObj.GetCellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="R")
    		 {
    	         if( formObj.ustl_acct_no.className  == "input1" ){
    	        	 if(isNull(sheetObj.GetCellValue(i, prefix+"ustl_acct_no")))
        			 {
        				 if(moveRow != 0){
        					 moveScreen(sheetObj, formObj, moveRow);
        				 }
        				 ComShowCodeMessage("OPF50009", "Unsettled Inter-Office Account No.");//
        				 formObj.ustl_acct_no.focus();
        				 return false;
        			 }
    	         }
    	         if(isNull(sheetObj.GetCellValue(i, prefix+"rpr_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Repair Total Amount");
    				 formObj.rpr_cost_usd_amt.focus();
    				 return false;
    			 }
    		 }
    		 else if(sheetObj.GetCellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="C")
    		 {
    			 if(isNull(sheetObj.GetCellValue(i, prefix+"ustl_acct_no")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Unsettled Inter-Office Account No.");
    				 formObj.ustl_acct_no.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.GetCellValue(i, prefix+"rpr_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Repair Total Amount");
    				 formObj.rpr_cost_usd_amt.focus();
    				 return false;
    			 }
    		 }
    		 else if(sheetObj.GetCellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="Q")
    		 {

    			 if(isNull(sheetObj.GetCellValue(i, prefix+"qttn_locl_curr_cd")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation Local Currency");
    				 formObj.qttn_locl_curr_cd.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.GetCellValue(i, prefix+"qttn_cost_locl_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation Local Amount");
    				 formObj.qttn_cost_locl_amt.focus();
    				 return false;
    			 }
    			  else if(isNull(sheetObj.GetCellValue(i, prefix+"qttn_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation USD Amount");
    				 formObj.qttn_cost_usd_amt.focus();
    				 return false;
    			 }
    			 
    		 }
    	 }
    }
    // Repair Tab Control End! ============================================================//
    // Compensation Tab Control Start! =======================================================//
    /**
     *  Setting on Grid Data  <br>
     **/
    function setCmpnDisplayData(formObj){
    	var sheetObj=sheetObjects[3];
    	var thisRow=sheetObj.GetSelectRow();
    	var prefix="sheet4_";
    	var statusCode=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_cmpn_proc_sts_cd");
    	if(statusCode=="R"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[0].checked=true;
    	}else if(statusCode=="C"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[1].checked=true;
    	}else if(statusCode=="N"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[2].checked=true;
    	}else if(statusCode=="A"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[3].checked=true;
    	}else if(statusCode=="J"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[4].checked=true;
    	}else if(statusCode=="P"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[5].checked=true;
    	}else if(statusCode=="E"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[6].checked=true;
    	}
    	if(sheetObjects[3].GetRowStatus(sheetObjects[3].GetSelectRow())=="R")
    	{
    		if(formObj.stv_dmg_cmpn_proc_sts_cd[0].checked){
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled=true;
        	}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[1].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled=false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled=true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[2].checked){
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled=false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled=false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled=true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[3].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled=false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled=true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[4].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled=true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[5].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled=true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[6].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled=false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled=true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled=true;
    		}
    	}
    	else{
    		/*formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled=false;
    		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled=true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled=true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled=true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled=true;
			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled=true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled=true;*/
    	}
    	formObj.clm_hndl_ofc_cd_cmpn.value=sheetObj.GetCellValue(thisRow, prefix+"clm_hndl_ofc_cd");
		formObj.clm_hndl_usr_id.value=sheetObj.GetCellValue(thisRow, prefix+"clm_hndl_usr_id");
		formObj.clm_hndl_usr_name.value=sheetObj.GetCellValue(thisRow, prefix+"clm_hndl_usr_nm");
		formObj.stv_dmg_respb_pty_co_nm.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_pty_co_nm");
		formObj.stv_dmg_respb_pty_pic_nm.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_pty_pic_nm");
		formObj.stv_dmg_respb_pty_pic_tit_nm.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_respb_pty_pic_tit_nm");
		formObj.stv_dmg_cmpn_dt.value=sheetObj.GetCellValue(thisRow, prefix+"stv_dmg_cmpn_dt");
    	//formObj.cmpn_curr_cd.value 			= sheetObj.CellValue(thisRow, prefix+"cmpn_curr_cd");
		comboObjects[7].SetSelectCode(sheetObj.GetCellValue(thisRow, prefix+"cmpn_curr_cd"),false);
    	formObj.cmpn_cost_locl_amt.value=sheetObj.GetCellText(thisRow, prefix+"cmpn_cost_locl_amt");
    	formObj.cmpn_cost_usd_amt.value=sheetObj.GetCellText(thisRow, prefix+"cmpn_cost_usd_amt");
		formObj.cmpn_acct_no.value=sheetObj.GetCellValue(thisRow, prefix+"cmpn_acct_no");
		formObj.cmpn_rmk.value=sheetObj.GetCellValue(thisRow, prefix+"cmpn_rmk");
		formObj.cmpn_upd_usr_id.value=sheetObj.GetCellValue(thisRow, prefix+"upd_usr_id");
		formObj.cmpn_upd_dt.value=sheetObj.GetCellValue(thisRow, prefix+"upd_dt");
    	cmpnFormObjControl(formObj);
    	setSubButton(2);
    }
    /**
     * in case of inputting, set data applicable on Hidden Grid <br>
     **/
    function cmpn_change_event() {
    	var formObj=document.form;
    	var elementObj=event.srcElement;
    	var sheetObj=sheetObjects[3];
    	var prefix="sheet4_";
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+elementObj.name,elementObj.value);
    	changeFlag=true;
    	if(elementObj.name=="cmpn_cost_locl_amt") // && comboObjects[6].GetSelectCode()!= "")
    	{
    		setCompensation_usd_amt(comboObjects[7].GetSelectCode(), elementObj.value, formObj.cmpn_cost_usd_amt);
    	}
    }
    /**
     * in case of selecting cmpn_curr_cd Combo Data, set data applicable on Hidden Grid <br>
     **/
    function cmpn_curr_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj=document.form;
    	changeFlag=true;
    	if(loadFlag){
    		sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "sheet4_cmpn_curr_cd",comboObj.GetSelectCode());
    		setCompensation_usd_amt(comboObj.GetSelectCode(), document.form.cmpn_cost_locl_amt, formObj.cmpn_cost_usd_amt);
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
    		formObj.stv_dmg_respb_pty_co_nm.readOnly=false;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly=false;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly=false;
    		formObj.stv_dmg_respb_pty_co_nm.className="input1";
    		formObj.stv_dmg_respb_pty_pic_nm.className="input1";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className="input1";
    		comboObjects[7].SetEnable(0);
    		formObj.stv_dmg_cmpn_dt.readOnly=true;
    		formObj.cmpn_cost_locl_amt.readOnly=true;
    		formObj.cmpn_cost_usd_amt.readOnly=true;
    		formObj.cmpn_acct_no.readOnly=true;
    		formObj.stv_dmg_cmpn_dt.className="input2";
    		formObj.cmpn_cost_locl_amt.className="input2";
    		formObj.cmpn_cost_usd_amt.className="input2";
    		formObj.cmpn_acct_no.className="input2";
    	}
    	else if(formObj.stv_dmg_cmpn_proc_sts_cd[5].checked){
    		formObj.stv_dmg_respb_pty_co_nm.readOnly=true;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly=true;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly=true;
    		formObj.stv_dmg_respb_pty_co_nm.className="input2";
    		formObj.stv_dmg_respb_pty_pic_nm.className="input2";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className="input2";
    		comboObjects[7].SetEnable(1);
    		formObj.stv_dmg_cmpn_dt.readOnly=false;
    		formObj.cmpn_cost_locl_amt.readOnly=false;
    		formObj.cmpn_cost_usd_amt.readOnly=false;
    		formObj.cmpn_acct_no.readOnly=false;
    		formObj.stv_dmg_cmpn_dt.className="input1";
    		formObj.cmpn_cost_locl_amt.className="input1";
    		formObj.cmpn_cost_usd_amt.className="input1";
    		formObj.cmpn_acct_no.className="input1";
    	}
    	else{
    		formObj.stv_dmg_respb_pty_co_nm.readOnly=true;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly=true;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly=true;
    		formObj.stv_dmg_respb_pty_co_nm.className="input2";
    		formObj.stv_dmg_respb_pty_pic_nm.className="input2";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className="input2";
    		comboObjects[7].SetEnable(0);
    		formObj.stv_dmg_cmpn_dt.readOnly=true;
    		formObj.cmpn_cost_locl_amt.readOnly=true;
    		formObj.cmpn_cost_usd_amt.readOnly=true;
    		formObj.cmpn_acct_no.readOnly=true;
    		formObj.stv_dmg_cmpn_dt.className="input2";
    		formObj.cmpn_cost_locl_amt.className="input2";
    		formObj.cmpn_cost_usd_amt.className="input2";
    		formObj.cmpn_acct_no.className="input2";
    	}
    }
    /**
     * Compensation handling process for input validation
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
        	else if(isNull(comboObjects[7].GetSelectCode()))
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
     * Setting on Grid Data page. <br>
     **/
    function setStlDisplayData(formObj){
    	var sheetObj=sheetObjects[4];
    	var thisRow=sheetObj.GetSelectRow();
    	var prefix="sheet5_";
    	formObj.shp_ownr_co_nm.value=sheetObj.GetCellValue(thisRow, prefix+"shp_ownr_co_nm");
		formObj.ustl_acct_no_stl.value=sheetObj.GetCellValue(thisRow, prefix+"ustl_acct_no");
		formObj.run_rpr_acct_no_stl.value=sheetObj.GetCellValue(thisRow, prefix+"run_rpr_acct_no");
		formObj.bil_inv_no.value=sheetObj.GetCellValue(thisRow, prefix+"bil_inv_no");
		formObj.pay_dt.value=sheetObj.GetCellValue(thisRow, prefix+"pay_dt");
		formObj.pay_curr_cd.value=sheetObj.GetCellValue(thisRow, prefix+"pay_curr_cd");
    	formObj.pay_locl_amt.value=sheetObj.GetCellText(thisRow, prefix+"pay_locl_amt");
    	formObj.pay_usd_amt.value=sheetObj.GetCellText(thisRow, prefix+"pay_usd_amt");
		formObj.stl_inv_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"stl_inv_atch_knt");
		formObj.stl_doc_atch_knt.value=sheetObj.GetCellValue(thisRow, prefix+"stl_doc_atch_knt");
		formObj.stl_rmk.value=sheetObj.GetCellValue(thisRow, prefix+"stl_rmk");
		formObj.stl_upd_dt.value=sheetObj.GetCellValue(thisRow, prefix+"upd_dt");
		formObj.stl_upd_usr_id.value=sheetObj.GetCellValue(thisRow, prefix+"upd_usr_id");
    	setSubButton(3);
    }
    /**
     * in case of inputting, set data applicable on Hidden Grid <br>
     **/
    function stl_change_event() {
    	var elementObj=event.srcElement;
    	var sheetObj=sheetObjects[4];
    	var prefix="sheet5_";
    	var row = sheetObj.GetSelectRow();
    	if(elementObj.name=="stl_inv_atch_flg"
			|| elementObj.name=="stl_doc_atch_flg")
    	{
    		if(elementObj.value > 0){
    			sheetObj.SetCellValue(row, prefix+elementObj.name,"Y");
    		}else{
    			sheetObj.SetCellValue(row, prefix+elementObj.name,"N");
    		}
    	}
    	else{
    		sheetObj.SetCellValue(row, prefix+elementObj.name,elementObj.value);
    	}
    }
    /**
     * in case of not existing data, handling Form Object readOnly  <br>
     **/
    function setStlDatareadOnly(formObj) {
    	formObj.pay_curr_cd.readOnly=true;
    	formObj.pay_locl_amt.readOnly=true;
        ComBtnDisable("btn_Save");
    }
    // Settlement Tab Control End! ============================================================//

    // Upload Control Start! ============================================================//
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/VOP_OPF_1053GS.do',
 			AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			ComUploadRemoveFile(upload1, "", true);
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);

                    var formObj = document.form;
                    var sheetObj;
                    switch(saveSheetId) {
                        case "sheet2":  sheetObj = sheetObjects[1]; break;
                        case "sheet3":  sheetObj = sheetObjects[2]; break;
                        case "sheet5":  sheetObj = sheetObjects[3]; break;
                    }
                    sheetObj.LoadSaveData(sXml);
                    ComDeleteMsg(sXml);

                    formObj.f_cmd.value=SEARCH09;
                    var sParam = FormQueryString(formObj);
                    var row = sheetObj.GetSelectRow();
                    var stvDmgNo = sheetObjects[0].GetCellValue(row, "sheet1_stv_dmg_no");

                    switch(saveSheetId) {
                        case "sheet2":
                            sheetObjects[5].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=SDR&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet7_") );
                            sheetObjects[6].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet8_") );
                            sheetObjects[7].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet9_") );
                            sheetObj.SetCellValue(row, "sheet2_upd_usr_id",userId,0);
                            sheetObj.SetCellValue(row, "sheet2_upd_dt",ComGetNowInfo("ymd"),0);
                            formObj.dmg_upd_usr_id.value=userId;
                            formObj.dmg_upd_dt.value=ComGetNowInfo("ymd");
                            ComAddSeparator(formObj.dmg_upd_dt);
                            break;
                        case "sheet3":
                            formObj.f_cmd.value=SEARCH09;
                            sheetObjects[8].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=RES&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet10_") );
                            sheetObjects[9].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=INV&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet11_") );
                            sheetObjects[10].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet12_") );
                            sheetObjects[11].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet13_") );
                            sheetObj.SetCellValue(row, "sheet3_upd_usr_id",userId,0);
                            sheetObj.SetCellValue(row, "sheet3_upd_dt",ComGetNowInfo("ymd"),0);
                            formObj.rpr_upd_usr_id.value=userId;
                            formObj.rpr_upd_dt.value=ComGetNowInfo("ymd");
                            ComAddSeparator(formObj.rpr_upd_dt);
                            break;
                        case "sheet5":
                            formObj.f_cmd.value=SEARCH09;
                            sheetObjects[12].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=S&stv_dmg_atch_file_tp_cd=INV&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet14_") );
                            sheetObjects[13].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=S&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+stvDmgNo, sParam + "&" + ComGetPrefixParam("sheet15_") );
                            sheetObj.SetCellValue(row, "sheet5_upd_usr_id",userId,0);
                            sheetObj.SetCellValue(row, "sheet5_upd_dt",ComGetNowInfo("ymd"),0);
                            formObj.stl_upd_usr_id.value=userId;
                            formObj.stl_upd_dt.value=ComGetNowInfo("ymd");
                            ComAddSeparator(formObj.stl_upd_dt);
                            break;
                    }
                    saveSheetId = "";
	      		}else {
					ComShowMessage(result.msg);
				}
 			},
	 		AfterDelFile:function(result){
	 		},
	 		AfterAddFile:function(result){
	 			var sheetObj = sheetObjects[showedLayer+5];
			    var prefix = aryPrefix[showedLayer+5];
	 			var files = result.files;
	 			var fileName = files[files.length-1].GetFileName();
			    var serialNo = files[files.length-1].GetSerialNo();
			    var row = sheetObj.GetSelectRow();

			    var sheet_serial = sheetObj.GetCellValue(row, prefix+"serial_no");
			    if (sheet_serial!="") {
			    	ComUploadRemoveFile(upload1, sheet_serial, false);
			    }

 				with(sheetObj) {
 					SetCellValue(row, prefix+"serial_no",serialNo,0);//set file path
 					SetCellValue(row, prefix+"file_set_yn","Y",0);//set whether select localfile or not
 					SetCellValue(row, prefix+"file_nm",fileName,0);//set file name
 					SetCellFontUnderline(row, prefix+"file_nm", 0);//remove download link
 				}
			}
 		});
 	}

    function fileAdd(btnName) {
    	var idx = ComParseInt(btnName.substring("btn_fileAdd".length))-1;
    	var sheetObj = sheetObjects[idx+5];
    	var prefix = aryPrefix[idx+5];
    	var formObject = document.form;
    	var fileSeq = 1;
    	if (sheetObj.RowCount()>0) {
    		var iLast = sheetObj.LastRow();
    		if (sheetObj.GetRowStatus(iLast)=="I" && sheetObj.GetCellText(iLast, prefix+"serial_no")=="") return;
    	    fileSeq = ComParseInt(sheetObj.GetCellValue(iLast, prefix+"stv_dmg_atch_file_seq"))+1;
    	}
    	
    	var row=sheetObj.DataInsert(-1);
		sheetObj.SetCellValue(row, prefix+"stv_dmg_no",formObject.stv_dmg_no.value,0);
		sheetObj.SetCellValue(row, prefix+"vsl_cd",formObject.vsl_cd.value,0);
		sheetObj.SetCellValue(row, prefix+"stv_dmg_proc_cd",aryStvDmgProcCd[idx],0);
		sheetObj.SetCellValue(row, prefix+"stv_dmg_atch_file_tp_cd",aryStvDmgAtchFileTpCd[idx],0);
		sheetObj.SetCellValue(row, prefix+"cre_usr_id",userId,0);
		sheetObj.SetCellValue(row, prefix+"cre_dt",ComGetNowInfo("ymd"),0);
		sheetObj.SetCellValue(row, prefix+"stv_dmg_atch_file_seq",fileSeq,0);
		sheetObj.FitColWidth();
    }

    function fileDel(btnName) {
    	var idx = ComParseInt(btnName.substring("btn_fileDel".length))-1;
    	var sheetObj = sheetObjects[idx+5];
    	var prefix = aryPrefix[idx+5];
		var row =sheetObj.GetSelectRow();
		
		if (row<0) return;

	    //ibsheet에 이미 업로드된 파일이 있으면 해당 serial의 파일을 삭제한다.
		var sheet_serial = sheetObj.GetCellValue(row, prefix+"serial_no");
	    if (sheet_serial!="") {
	    	ComUploadRemoveFile(upload1, sheet_serial, false);
	    }

	    sheetObj.SetRowHidden(row,true);
    	sheetObj.SetRowStatus(row,"D");
    }

    var showedLayer = -1;
    function showUploadLayer(btnName) {
 	    var uLayer=document.all.item("uploadLayer");
 	    var aryBtn = ["btn_SDR","btn_Picture","btn_Document","btn_t2Result","btn_t2Invoice","btn_t2PIC","btn_t2Document","btn_t4Invoice","btn_t4Document"];

 	    //기존 레이어 닫기
 	    if (showedLayer != -1){
 	    	hideUploadLayer();
 	    }

 	    //새로 레이어 열기
 	 	var btnObj = ComGetObject(btnName);
 	    for (var i=0; i<aryBtn.length; i++){
 	    	if (aryBtn[i] == btnName) {
 	    		showedLayer = i;
// 	    		var iTop = AnchorPosition_getPageOffsetTop(btnObj) + 25;
 	    		var iTop = btnObj.offsetTop + 25;
 	    		var iLeft = AnchorPosition_getPageOffsetLeft(btnObj);
 	    		var iWidth = 450;
 	    		
    			// 넓이초과
    			if (iLeft + iWidth > document.body.clientWidth) {
    				iLeft = document.body.clientWidth - iWidth;
    				if (iLeft < 0) iLeft = 0;
    			}

 	    		uLayer[i].style.top  = iTop + "px";
 	    		uLayer[i].style.left = iLeft + "px";
 	    		uLayer[i].style.height = "250px";
 	    		uLayer[i].style.visibility="visible";
 	    		sheetObjects[showedLayer+5].SetVisible(true);
 	    		break;
 	    	}
 	    }
    }

    function hideUploadLayer(){
 	    if (showedLayer == -1)  return;
		setFileUpload();
 	    var uLayer=document.all.item("uploadLayer");
    	uLayer[showedLayer].style.visibility="hidden";
    	uLayer[showedLayer].style.height="0px";
    	sheetObjects[showedLayer+5].SetVisible(false);
    	showedLayer = -1;
    }

    function connectSheet2Upload(){
		var sheetObj = sheetObjects[showedLayer+5];
		var prefix = aryPrefix[showedLayer+5];
    	var row = sheetObj.MouseRow(), col = sheetObj.MouseCol();
        
        if (row <= 0 || sheetObj.ColSaveName(col) != prefix+"file_nm") return;
        
    	var info = sheetObj.GetCellElement(row, col, 1);
    	upload1.SetFileUploadElement(info);
    }

    function sheet7_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    function sheet8_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    function sheet9_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    function sheet10_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    function sheet11_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    function sheet12_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    function sheet13_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    function sheet14_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    function sheet15_OnMouseMove(sheetObj){
    	connectSheet2Upload();
    }
    
    function fileDownload(Row,Col, Value){
		var sheetObj = sheetObjects[showedLayer+5];
		var prefix = aryPrefix[showedLayer+5];
		
        if (Row <= 0 	|| sheetObj.ColSaveName(Col) != prefix+"file_nm") return;
        if (Value == "" || sheetObj.GetRowStatus(Row) == "I") return;

        parent.location.href = "/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
        return;
    }
    
	function sheet7_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
	function sheet8_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
	function sheet9_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
	function sheet10_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
	function sheet11_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
	function sheet12_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
	function sheet13_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
	function sheet14_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
	function sheet15_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(Row,Col, Value);
	}	
    
	function setFileLink(sheetNo){
		var sheetObj = sheetObjects[sheetNo+5];
		var prefix = aryPrefix[sheetNo+5];
		var col =  sheetObj.SaveNameCol(prefix+"file_nm");
		ComSetRangeFont(sheetObj, "FontUnderline", true, sheetObj.HeaderRows(), col, sheetObj.LastRow(), col);
	}
	
    function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(0);
    }
    function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(1);
    }
    function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(2);
    }
    function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(3);
    }
    function sheet11_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(4);
    }
    function sheet12_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(5);
    }
    function sheet13_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(6);
    }
    function sheet14_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(7);
    }
    function sheet15_OnSearchEnd(sheetObj, ErrMsg) {
    	setFileLink(8);
    }

	/* Developer performance  end */
