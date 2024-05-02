/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_01.js
*@FileTitle  :  
*@author     : CUONGLE
*@version    : 1.0
*@since      : 2014/05/15  
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* Developer Work	*/
        
    // global variable
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var beforetab_sub = 1;
    var beforetab_trob = 1;
    var comboObjects = new Array();
    var comboCnt = 0; 
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var isShowOrgBlNo = true;
	var befQty = "";
	var oldPolYdCd = "";
	var oldPodYdCd = "";
	
	var precheckFlag="";
	var tmpPreCheckFlag = "";
	var oldBkgMailContents = "N";
	var newStsCd = "R";
	var svcScpCd = "";
	
	var checkConfirm = false;
	var checkConfirmMsg = 'User should transmit the 301&310 EDI again MANUALLY.';
	
	/* 사용자가 Auto EDI Hold 체크 여부 */
	var userEdiHldFlgCheck = false;
	var esdPrd0080 = false;
	
    // Event handler processing by button click event */
//  document.onclick = processButtonClick;		//'target' undefined error		
	document.onclick = checkLoad;
	function checkLoad(){
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
    // Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets다. *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
         /*******************************************************/
        var formObj=document.form;
		var bkgNo=ComGetObjValue(formObj.bkg_no);
		var blNo=ComGetObjValue(formObj.bl_no);
		var caFlg=ComGetObjValue(formObj.ca_flg);
		var bdrFlag="";
		if(formObj.bdr_flg.checked){
			bdrFlag=ComGetObjValue(formObj.bdr_flg);
		}else{
			bdrFlag="N";
		}
		var bkgTrunkVvd=ComGetObjValue(formObj.bkg_trunk_vvd);
		var porCd=ComGetObjValue(formObj.bkg_por_cd);
		var porYdCd=ComGetObjValue(formObj.bkg_por_yd_cd);
		var polCd=ComGetObjValue(formObj.bkg_pol_cd);
		var polYdCd=ComGetObjValue(formObj.bkg_pol_yd_cd);
		var podCd=ComGetObjValue(formObj.bkg_pod_cd);
		var podYdCd=ComGetObjValue(formObj.bkg_pod_yd_cd);
		var delCd=ComGetObjValue(formObj.bkg_del_cd);
		var delYdCd=ComGetObjValue(formObj.bkg_del_yd_cd);
		var oldBkgNo=ComGetObjValue(formObj.old_bkg_no);
		var sCustCntCd=ComGetObjValue(formObj.s_cust_cnt_cd);
		var sCustSeq=ComGetObjValue(formObj.s_cust_seq);
		var fCustCntCd=ComGetObjValue(formObj.f_cust_cnt_cd);
		var fCustSeq=ComGetObjValue(formObj.f_cust_seq);		
		var cCustCntCd=ComGetObjValue(formObj.c_cust_cnt_cd);
		var cCustSeq=ComGetObjValue(formObj.c_cust_seq);
		
		var bkgPtyCntCd=ComGetObjValue(formObj.bkg_pty_cnt_cd);
		var bkgPtyCustSeq=ComGetObjValue(formObj.bkg_pty_cust_seq);	
		
		var bkgCtrlPtyCustCntCd=ComGetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd);
		var bkgCtrlPtyCustSeq=ComGetObjValue(formObj.bkg_ctrl_pty_cust_seq);
		
		var bkgStsCd = ComGetObjValue(formObj.bkg_sts_cd);
		var lodgDueDt = ComGetObjValue(formObj.lodg_due_dt);
		
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		if(srcName != "btn_splitPop" && layList.style.display == "") layList.style.display="none";

    		/** tab BKG Creation (S) **/
            switch(srcName) {      
				case "btn_splitPop":			
					doActionIBSheet(sheetObject3,formObj,COMMAND03);					
					break;
				case "btn_OrgBlPop":
					if(isShowOrgBlNo){
						blNoSet();
						isShowOrgBlNo=false;
					}else{
						blNoHide();
						isShowOrgBlNo=true;
					}					
					break;
				case "btn_t1RouteDetail":
					if(polCd != ""){
						
						var podClptIndSeq = null;
						var polClptIndSeq = null;
						
	    				if(sheetObjects[1].RowCount() > 0){
	    					podClptIndSeq = sheetObjects[1].GetCellValue(1, "pod_clpt_ind_seq");
	    					polClptIndSeq = sheetObjects[1].GetCellValue(1, "pol_clpt_ind_seq");
	    				}
	    				
	    				if(sheetObjects[1].RowCount()< 2){
	    					if(sheetObjects[1].RowCount()< 1){
	    						sheetObjects[1].DataInsert(-1);
	    					}
	    					sheetObjects[1].SetCellValue(1, "vsl_pre_pst_cd","T");
	    					sheetObjects[1].SetCellValue(1, "vsl_seq","0");
	    					sheetObjects[1].SetCellValue(1, "pol_cd",polCd);
	    					sheetObjects[1].SetCellValue(1, "pol_yd_cd",polYdCd);
	    					sheetObjects[1].SetCellValue(1, "pod_cd",podCd);
	    					sheetObjects[1].SetCellValue(1, "pod_yd_cd",podYdCd);
	    					sheetObjects[1].SetCellValue(1, "bkg_vvd_cd",ComGetObjValue(formObj.bkg_trunk_vvd));
	    				}
	    				console.log(bkgNo, bkgTrunkVvd, caFlg, "1", podClptIndSeq, polClptIndSeq);
						comBkgCallPop0092("callBack0092", bkgNo, bkgTrunkVvd, caFlg, "1", podClptIndSeq, polClptIndSeq);
					}else{
						ComShowCodeMessage("BKG00136");
						ComSetFocus(form.pol_cd);
					}
					break;
				case "btn_allocation":
					if(bkgTrunkVvd==null||bkgTrunkVvd.length<9){
	       				ComShowCodeMessage("BKG00051", bkgTrunkVvd);		//VVD Check	
						ComSetFocus(formObj.bkg_trunk_vvd);
        				return;
        			}
					var usr_ofc_cd=formObj.usr_ofc_cd.value;					
					if(usr_ofc_cd==null||usr_ofc_cd.length<5){
	       				ComShowCodeMessage("BKG00104", "L.OFC");		//VVD Check
						return;
					}
					var param="?pgmNo=ESM_SPC_0044";
					param=param + "&vvd="+bkgTrunkVvd + "&office=" + usr_ofc_cd;
		       		window.open("ESM_SPC_0044.do"+param);
					break;
				case "btn_t1RowAdd":
					var iRow = sheetObjects[0].DataInsert(-1);
					sheetObjects[0].SelectCell(iRow, "cntr_tpsz_cd", true);
					ComSetObjValue(formObj.qty_modify_flag, "Y");
					ComSetObjValue(formObj.modify_flag, "Y");
					break;
				case "btn_t1Delete":
					var delTpSz=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "cntr_tpsz_cd");
					for(var i=sheetObject4.LastRow();i>=sheetObject4.HeaderRows();i--){
						if(delTpSz==sheetObject4.GetCellValue(i, "cntr_tpsz_cd")){
							sheetObject4.RowDelete(i,false);
						}
					}
					sheetObject1.RowDelete(sheetObject1.GetSelectRow(),false);
					disabledFH(sheetObject1, formObj);
					ComSetObjValue(formObj.qty_modify_flag, "Y");
					ComSetObjValue(formObj.modify_flag, "Y");					
					manageHaveRouteFlag("N");
					break;
				case "btn_t1TPSZ":
					comBkgCallPop0080("callBack0080","");
					break;
				case "btn_EqDetail":
					if(chkCntrTpSz()){
						comBkgCallPop0890("callBack0890","N");						
					}
					break;    					
				case "btn_t1Danger":
					if(ComGetObjValue(formObj.dcgo_flg_old)!="Y"){
						ComShowCodeMessage("BKG02048");						
						break;
					}
					if(bkgNo != "" && bkgNo.length > 10){
//						comBkgCallPop0200(bkgNo, caFlg);
						
						var url="ESM_BKG_0200_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
						ComOpenWindowCenter(url, "ESM_BKG_0200_POP", 1260, 625, false);
//						ComOpenWindowCenter("ESM_BKG_0200.do?pgmNo=ESM_BKG_0200&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1010, 570, true);
//						doActionIBSheet(sheetObjects[2],formObj,SEARCH);
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}    	
					break;
					
				case "btn_t1Reefer":
					if(ComGetObjValue(formObj.rc_flg_old)!="Y"){
						ComShowCodeMessage("BKG02048");						
						break;
					}
					if(bkgNo != "" && bkgNo.length >= 11){
						if(bkgNo != "" && bkgNo.length > 10){
//							ComOpenWindowCenter("ESM_BKG_0498_POP.do?pgmNo=ESM_BKG_0498&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1020, 670, true);
//							doActionIBSheet(sheetObjects[2],formObj,SEARCH);
							var url="ESM_BKG_0498_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
							ComOpenWindowCenter(url, "ESM_BKG_0498_POP", 1260, 625, false);
						}else{
							ComShowCodeMessage("BKG00255");
							ComSetFocus(formObj.bkg_no);
						}    							
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}    					
					break;
				case "btn_t1Awkward":
					if(ComGetObjValue(formObj.awk_cgo_flg_old)!="Y"){
						ComShowCodeMessage("BKG02048");						
						break;
					}
					if(bkgNo != "" && bkgNo.length > 10){
//						ComOpenWindowCenter("ESM_BKG_0055.do?pgmNo=ESM_BKG_0055&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1020, 580, true);
//						doActionIBSheet(sheetObjects[2],formObj,SEARCH);
						var url="ESM_BKG_0055_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
						ComOpenWindowCenter(url, "ESM_BKG_0055_POP", 1260, 625, false);
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}    		
					break;
				case "btn_t1BreakBulk":
					if(ComGetObjValue(formObj.bb_cgo_flg_old)!="Y"){
						ComShowCodeMessage("BKG02048");						
						break;
					}
					if(bkgNo != "" && bkgNo.length >= 11){						
						// bkgNo, caFlg
//						ComOpenWindowCenter("ESM_BKG_0106.do?pgmNo=ESM_BKG_0106&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0106", 1020, 635, true);
//						doActionIBSheet(sheetObjects[2],formObj,SEARCH);
						
						var url="ESM_BKG_0106_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
						ComOpenWindowCenter(url, "ESM_BKG_0106_POP", 1260, 625, false);
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}
					break;
				case "btn_t1Stowage":
					comBkgCallPop0090("callBack0090", ComGetObjValue(formObj.stwg_cd), ComGetObjValue(formObj.stwg_rmk));
					break;
				case "btn_t1Hanger":
					if(bkgNo != "" && bkgNo.length > 10){
						comBkgCallPop0081("callBack0081","0");
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}      					
					break;
				case "btn_t1StopOffCargo":
					comBkgCallPop0658("callBack0658");
					break;
				case "btn_t1Constraints":
					comBkgCallPop0998("",bkgNo);
					break;
				case "btn_t1SVCModeRoute":
					comBkgCallPop0972("",bkgNo);
					break;
				case "btn_t1ReferenceNo":    		
					if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG01010");
					}else{    					
    					if(bkgNo != "" && bkgNo.length >= 11){
    						comBkgCallPop0097("callBack0097",bkgNo, caFlg);
    					}else{
    						ComShowCodeMessage("BKG00255");
    						ComSetFocus(formObj.bkg_no);
    					}    	      
					}
					break;
				case "btn_t1CargoClosingTime":
					if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG01009");
					}else{
    					if(bkgNo != "" && bkgNo.length >= 11){
    						comBkgCallPop0721("",bkgNo);
    					}else{
    						ComShowCodeMessage("BKG00255");
    						ComSetFocus(formObj.bkg_no);
    					}    
					}
					break;
				case "btn_t1RollOverInformation":
					if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG01011");
					}else{    					
    					if(bkgNo != "" && bkgNo.length >= 11){
    						ComOpenPopup("ESM_BKG_0724.do?pgmNo=ESM_BKG_0724&bkg_no="+bkgNo, 1000, 450, "","0,1,1,1,1", true);
//    						ComOpenPopup("ESM_BKG_0724.do?pgmNo=ESM_BKG_0724&bkg_no="+bkgNo, 1024, 660, "","1,0,1,1,1", false); 
    					}else{
    						ComShowCodeMessage("BKG00255");
    						ComSetFocus(formObj.bkg_no);
    					}
					}
					break;					
            	case "btn_t1retrieve":
            		if(bkgNo != null && bkgNo.length > 0){
            			//ComResetAll();
            			ComSetObjValue(formObj.bkg_no,bkgNo);
            			doActionIBSheet(sheetObjects[2], formObj, SEARCH);            			
            		}else if(blNo != null && blNo.length > 0){
            			//ComResetAll();
            			ComSetObjValue(formObj.bl_no,blNo);
            			doActionIBSheet(sheetObjects[2], formObj, SEARCH);               			
            		}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);            			
            		}
                	break;
            	case "btn_t1New":
            		if(ComGetObjValue(formObj.modify_flag) == "Y"){
            			if(ComShowCodeConfirm("BKG00350")){
                    		if(validateForm(formObj, COMMAND01)){
                    			doActionIBSheet(sheetObject3, formObj, COMMAND01);
                    			return;
                    		}
            			}
    	    		}
            		if(formObj.ca_new_creation_flag.value=="Y"){
            			location.href="ESM_BKG_0079_01_C.do?mainPage=true&pid=ESM_BKG_M020&MENU=Y&pgmNo=ESM_BKG_0079_01_C&parentPgmNo=ESM_BKG_M001&mainMenuLinkFlag=true&menuflag=true&mainPage=true";
            		} else {
            			location.href="ESM_BKG_0079_01.do";
            		}
                	break;
            	case "btn_t1Save":            		
            		if(validateForm(formObj, COMMAND01)){
            			if(formObj.data_yn.value == "Y" && formObj.bkg_no.value == ""){
    						ComShowCodeMessage("BKG06126");
    						ComSetFocus(formObj.bkg_no);
    						break;
            			}
            			if(formObj.ca_new_creation_flag.value == "Y"){
            				formObj.ca_rsn_cd.value=null;
							comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.bkg_no), "C");
							//if(ComIsNull(formObj.ca_rsn_cd.value)){
							//	return false;
							//}
							// setCAReasonCallBack 에서 COMMAND01 호출
            			}else{
            				doActionIBSheet(sheetObject3, formObj, COMMAND01);
            			}
            		}
                	break;
            	case "btn_t1GoIBCS":
            		if(bkgNo != null && bkgNo.length > 0){
            			var sUrl="";
            			if(podCd.substring(0,2)=="US"){
            				sUrl="ESM_BKG_0668_01_POP.do?pgmNo=ESM_BKG_0668-01&bkg_no="+bkgNo;
            			} else {
            				sUrl="ESM_BKG_0292_POP.do?pgmNo=ESM_BKG_0292&bkg_no="+bkgNo;
            			}
            			ComOpenPopup(sUrl, 1024, 660, "","1,0,1,1,1", false);            			
            		}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);                     			
            		}
                	break;                	
              case "btn_t1BKGCancel":
					if(validateForm(formObj, MODIFY06)){
						doActionIBSheet(sheetObject3, formObj, MODIFY06);
					}   
                	break;
            	case "btn_t1Copy":
            		//UI_BKG_0077
            		if(validateForm(formObj, COMMAND02)){
            			if(formObj.bkg_no.value == ""){
    						ComShowCodeMessage("BKG06126");
    						ComSetFocus(formObj.bkg_no);
    						break;
            			}
    	            	var sUrl="ESM_BKG_0077.do?pgmNo=ESM_BKG_0077&bkg_no="+bkgNo;
    	            	sUrl += "&bdr_flg="+bdrFlag;
    	            	sUrl += "&bkg_sts_cd="+ComGetObjValue(formObj.bkg_sts_cd);
    	            	sUrl += "&bkg_wt_chk_flg="+ComGetObjValue(formObj.bkg_wt_chk_flg);
    	            	sUrl += "&ca_flg="+ComGetObjValue(formObj.ca_flg);
    	            	sUrl += "&edi_hld_flg="+ComGetObjValue(formObj.edi_hld_flg);
            			ComOpenPopup(sUrl, 720, 550, "","1,0,1,1,1", true);
            		}
                	break;
              case "btn_t1FaxEDI":
            	  	// UI_BKG_0095
					if(bkgNo != "" && bkgNo.length >= 11){
						ComOpenPopup("ESM_BKG_0095.do?pgmNo=ESM_BKG_0095&bkg_no="+bkgNo+"&pol_cd="+polCd, 950, 550, "","0,1,1,1,1", true);
					}else{					
						ComSetFocus(formObj.bkg_no);
					}
                	break;
              case "btn_t1Holding":
            	  if (validateForm(formObj, MODIFY04)) {
            		  if (ComGetObjValue(formObj.modify_flag) == "Y" && !ComIsNull(formObj.old_bkg_no)) {
            			  ComShowMessage('Data was changed. Please proceed after Save.');
            			  return;
            		  } else {
            			  doActionIBSheet(sheetObject3, formObj, MODIFY04);
            		  }
            	  }           	  
            	  break;
              case "btn_t1Waiting":
					if(validateForm(formObj, MODIFY05)){
						doActionIBSheet(sheetObject3, formObj, MODIFY05);
					}                   	  
              	break;
              case "btn_t1Split":
            	  	var params="&bkg_no="+bkgNo+"&popUpFlag=Y";
	            	params += "&pgmNo=ESM_BKG_0099";	  
	            	ComOpenPopup("/opuscntr/ESM_BKG_0099_P.do?mainPage=false" + params, 1200, 600, "searchData", "0,1,1,1,1", false);
	            	//ComOpenPopup(sUrl, 1024, 850, "","0,1,1,1,1", false);
                	break;
        	case "btn_0019Pop":
        		if(sheetObjects[1].LastRow()>=2){
        			var trunkRow=sheetObjects[1].FindText("vsl_pre_pst_cd","T");
        			polCd=sheetObjects[1].GetCellValue(trunkRow, "pol_cd");
        			podCd=sheetObjects[1].GetCellValue(trunkRow, "pod_cd");
        		}
        		comBkgCallPop0019('callBack0019', bkgTrunkVvd, polCd, podCd);
				break;    				
        	case "btn_0083PorPop": //node search
        		comBkgCallPop0083('callBack0083','POR',porCd,porYdCd,ComGetObjValue(rcv_term_cd));
        		break;    		
        	case "btn_0083PolPop": //node search
        		comBkgCallPop0083('callBack0083','POL',polCd,polYdCd,ComGetObjValue(rcv_term_cd));
        		break;    		
        	case "btn_0083PodPop": //node search
        		comBkgCallPop0083('callBack0083','POD',podCd,podYdCd,ComGetObjValue(de_term_cd));
        		break;    		
        	case "btn_0083DelPop": //node search
        		comBkgCallPop0083('callBack0083','DEL',delCd,delYdCd,ComGetObjValue(de_term_cd));                    		
				break;    	
        	case "btn_0744Pop": // ams filer no
				if(ComIsNull(oldBkgNo)){
					ComShowCodeMessage("BKG00255");
				} else {
					comBkgCallPop0744('',bkgNo, caFlg, bdrFlag);
				}
				break;    		    					
        	case "btn_0652ShprPop": //customer inquiry
        		comBkgCallPop0652('callBack0652','S',sCustCntCd,sCustSeq, "");
        		break;    		
        	case "btn_0652PtyPop": //customer inquiry
        		comBkgCallPop0652('callBack0652','P',bkgPtyCntCd,bkgPtyCustSeq, "");
        		break;  
        	case "btn_0652FwdrPop": //customer inquiry
        		comBkgCallPop0652('callBack0652','F',fCustCntCd,fCustSeq, "");
        		break;
        		
        	case "btn_ComEns041Pop": // com customer pop-up
        		var custCd=cCustCntCd+cCustSeq;
        		ComOpenPopup("COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd="+ cCustCntCd+cCustSeq, 770, 500, "callBackComEns041", '0,1,1,1,1,1,1', true);
				break;    			  
        	case "btn_RfaNo":
        		if(formObj.rfa_no.value != '' && bkgCtrlPtyCustCntCd == '' && bkgCtrlPtyCustSeq == ''){
        			var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&rfa_no=" + formObj.rfa_no.value);
        			bkgCtrlPtyCustCntCd = ComGetEtcData(sXml, "cust_cnt_cd");
        			bkgCtrlPtyCustSeq = ComGetEtcData(sXml, "cust_seq");
        			ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, bkgCtrlPtyCustCntCd);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, bkgCtrlPtyCustSeq);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, ComGetEtcData(sXml, "cust_lgl_eng_nm"));
        		}
        		comBkgCallPop0654('callBack0654',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq,lodgDueDt,bkgStsCd);
				break;    	
        	case "btn_ScNo":
        		if(formObj.sc_no.value != '' && bkgCtrlPtyCustCntCd == '' && bkgCtrlPtyCustSeq == ''){
        			var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&sc_no=" + formObj.sc_no.value);
        			bkgCtrlPtyCustCntCd = ComGetEtcData(sXml, "cust_cnt_cd");
        			bkgCtrlPtyCustSeq = ComGetEtcData(sXml, "cust_seq");
        			ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, bkgCtrlPtyCustCntCd);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, bkgCtrlPtyCustSeq);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, ComGetEtcData(sXml, "cust_lgl_eng_nm"));
        		}
        		
        		comBkgCallPop0655('callBack0655',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq,lodgDueDt,bkgStsCd);
				break;    	  
        	case "btn_TaaNo":
        		
        		if(formObj.taa_no.value != '' && bkgCtrlPtyCustCntCd == '' && bkgCtrlPtyCustSeq == ''){
        			var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&taa_no=" + formObj.taa_no.value);
        			bkgCtrlPtyCustCntCd = ComGetEtcData(sXml, "cust_cnt_cd");
        			bkgCtrlPtyCustSeq = ComGetEtcData(sXml, "cust_seq");
        			ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, bkgCtrlPtyCustCntCd);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, bkgCtrlPtyCustSeq);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, ComGetEtcData(sXml, "cust_lgl_eng_nm"));
        		}
        		comBkgCallPop1062('callBack1062',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq,lodgDueDt,bkgStsCd);
				break;    					
        	case "btn_CmdtPop":
        		var rfaNo=ComGetObjValue(formObj.rfa_no);
        		var scNo=ComGetObjValue(formObj.sc_no);
        		var taaNo=ComGetObjValue(formObj.taa_no);
        		var cmdtCd=ComGetObjValue(formObj.cmdt_cd);
        		var repCmdtCd=ComGetObjValue(formObj.rep_cmdt_cd);
        		var rfaNo1="";
        		if(!ComIsNull(rfaNo) && rfaNo.length > 2){
        			rfaNo1=rfaNo.substring(0,3);
        		}
        		var scNo1="";
        		if(!ComIsNull(scNo) && scNo.length > 2){
        			scNo1=scNo.substring(0,3);
        		}        		
        		var taaNo1="";
        		if(!ComIsNull(taaNo) && taaNo.length > 2){
        			taaNo1=taaNo.substring(0,3);
        		}             		

        		if(formObj.chkTaaRfaNo[1].checked){
            		if(scNo1 == "DUM" || rfaNo1 == "DUM"){
            			comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
            		}else{
            			if(rfaNo.length > 7){
            				comBkgCallPop0656('callBack0656',rfaNo,bkgNo,bkgTrunkVvd,porCd,delCd);        			
            			}else if(scNo.length > 7){
                			comBkgCallPop0657('callBack0657',scNo,bkgNo,bkgTrunkVvd,porCd,delCd);
                		}else{
                			comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
                		}        			
            		}        			
        		}else{
            		if(scNo1 == "DUM" || taaNo1 == "DUM"){
            			comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
            		}else{
            			if(taaNo.length > 9){
            				comBkgCallPop1078('callBack1078',taaNo,bkgNo,bkgTrunkVvd,porCd,delCd);        			
            			}else if(scNo.length > 7){
                			comBkgCallPop0657('callBack0657',scNo,bkgNo,bkgTrunkVvd,porCd,delCd);
                		}else{
                			comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
                		}        			
            		}        			
        		}
//        		checkNigeriaCmdt(podCd, delCd);
				break;    		    		
        	case "btns_MtDorArrCalendar":
        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	        		if(!formObj.mty_dor_arr_dt.disabled){
	    	            var cal=new ComCalendar();
	    	            cal.select(formObj.mty_dor_arr_dt, 'yyyy-MM-dd');    
	        		}       
        		}
				break;        					
        	case "btns_LodgDueCalendar":
        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
		            var cal=new ComCalendar();
		            cal.select(formObj.lodg_due_dt, 'yyyy-MM-dd');         
        		}
				break;        		
        	case "btns_DeDueCalendar":
        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){        		
		            var cal=new ComCalendar();
		            cal.select(formObj.de_due_dt, 'yyyy-MM-dd');    
        		}
				break;    
        	case "btns_MtPickUpCalendar":
        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){        		
		            var cal=new ComCalendar();
		            cal.select(formObj.mty_pkup_dt, 'yyyy-MM-dd'); 
        		}
				break;        			
        	case "btn_0082Pop": //mty pkup inquiry
        		var mtyPkupYdCd;
        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	        		if(ComChkLen(formObj.mty_pkup_yd_cd.value, 7) == "2"){                			
	        			mtyPkupYdCd=formObj.mty_pkup_yd_cd.value;
	        		}else{
	        			if (porCd != "") {
		        			mtyPkupYdCd=porCd+porYdCd;	        				
	        			}else{
		        			mtyPkupYdCd=formObj.mty_pkup_yd_cd.value;	        				
	        			}
	        		}	        		
	        		comBkgCallPop0082('callBack0082','0',mtyPkupYdCd.toUpperCase());
        		}
        		break;    	    		
        	case "btn_0088Pop": //full rtn inquiry
        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){        		
	        		var r0088;
	        		if(ComChkLen(formObj.full_rtn_yd_cd.value, 7) == "2"){                			
	        			r0088=ComGetObjValue(formObj.full_rtn_yd_cd);
	        		}else{
	        			r0088=porCd+porYdCd;
	        		}                		
	        		comBkgCallPop0088('callBack0088',r0088);
        		}
        		break;    	       
        	case "btn_0976Pop": // remark template
        		comBkgCallPop0976('callBack0976');
				break;
        	case "btn_Trs0982Pop": // Trs Remark
        		comTrsCallPop0982('callBack0982');
        		break;
        	case "btn_t1RmkSave": // Cust Remark
        		doActionIBSheet(sheetObject3, formObj, MODIFY07);
        		break;
        		
/** tab BKG Creation (E) **/
            } // end switch
    	}catch(e) {
//    		if( e == "[object Error]") {
    		if( e.name == "TypeError") {
    			return false;
//    			ComShowCodeMessage("COM12111"); 
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
     * Set Combo 
     * @param {IBMultiCombo} comboObj  comboObj
     */
     function initCombo(comboObj) {
     	comboObj.SetMultiSelect(0);
     	comboObj.SetColAlign(0, "left");
     	comboObj.SetColAlign(1, "left");
     	comboObj.SetMultiSeparator("|");
     	switch(comboObj.options.id){
     		case "rcv_term_cd":
     		case "de_term_cd":
     			comboObj.SetDropHeight(250);
     			comboObj.SetColWidth(0, "20");
     			comboObj.SetColWidth(1, "80");
     			break;
     		case "rail_blk_cd":
     			comboObj.SetColWidth(0, "20");
     			comboObj.SetColWidth(1, "150");
     			break;
     	}
     	
     }
     /**
      * Set IBCombo Object In comboObjects array
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
      function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
      }
      /**
       * IBTab Object regist array
       * adding process for list in case of needing batch processing with other items 
       * defining list on the top of source
       */
      function setTabObject(tab_obj){
          tabObjects[tabCnt++]=tab_obj;
      }
      /**
       * initializing Tab
       * Setting Tab items.
       */
      function initTab(tabObj , tabNo) {
          with (tabObj) {
              InsertItem("BKG contact" , "");
              InsertItem("S/I contact" , ""); // contact
              SetSelectedIndex(0);
          }
                  
      }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
   	    // IBMultiComboInitialization
   	    for(var j=0; j<comboObjects.length; j++){
   	        initCombo(comboObjects[j]);
   	    }

   	    for(k=0;k<tabObjects.length;k++){            	
            initTab(tabObjects[k],k+1);                
        }
   	    
		ComSetObjValue(formObj.act_wgt, makeComma("0")); 
        if(formObj.old_bkg_no.value == ""){            	
        	doActionIBSheet(sheetObjects[2],formObj,INIT);
        }else{
        	doActionIBSheet(sheetObjects[2],formObj,SEARCH);
        } 
        initControl();
        ComSetUIItem(sheetObjects[0],document.form, "BKG", "ESM_BKG_0079_01");
		CofigIframe();
		
		
    }
    /**
     * Set Init Control. <br>
     */
    function initControl() {
    	var formObj=document.form;
    	axon_event.addListenerForm  ("change", 			"form_onChange", 		formObj);
        //axon_event.addListenerFormat('keypress', 		'bkg007901_keypress',   formObj); //- When typing the keyboard
        //axon_event.addListenerFormat('keyup',			'bkg007901_keyup',    	formObj); 
        axon_event.addListenerForm('blur', 	'bkg007901_blur', formObj); //- Focus Out
        //axon_event.addListenerFormat('beforeactivate', 	'bkg007901_activate',   formObj); //- Focus In
        axon_event.addListenerForm('click', 			'bkg007901_click',    	formObj); //- Click
        axon_event.addListenerForm('keydown', 'check_Enter', document.form);
        applyShortcut();
        inputEngSet();
    }
    
	function check_Enter() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (event.keyCode == 13) {
			if(ComGetEvent("name") == "xter_rmk") return;
			if(ComGetEvent("name") == "inter_rmk") return;
			if(ComGetEvent("name") == "bkg_no"){
				doActionIBSheet(sheetObjects[2], formObj, SEARCH);
			}
		}
	}
    
    var inputEngSet = function(){
        $("[data-eng='on']").keyup(function(event){
    	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
    	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
    		                                 var inputVal = $(this).val();
    	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
    	                                 }
                             });
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
			case "t1sheet1":
				with(sheetObj){
					var HeadTitle="|TP/SZ|Vol.|EQ Sub(Incl. R/D)|EQ Sub(Incl. R/D)|EQ Sub(Incl. R/D)|S.O.C";
	
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
					             {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_subst_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
					             {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"eq_subst_cgo_qty",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					             {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"rd_cgo_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"soc_qty",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_sgl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_dbl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_tpl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mer_hngr_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
					 
					InitColumns(cols);
	
					SetCountPosition(0);
					//SetSheetWidth(510);
					SetWaitImageVisible(0);
					SetSheetHeight(ComGetSheetHeight(sheetObj, 4));
				}
				break;
				case "t1sheet2":
                    with(sheetObj){
						var HeadTitle="|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq";
						
						SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
						
						var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vsl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pol_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pod_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						
						InitColumns(cols);
						
						SetWaitImageVisible(0);
	                    SetVisible(0);
					}
					
					break;
				case "t1sheet3":
                    with(sheetObj){
						var HeadTitle="|";
						
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
						
						var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						{Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
						
						InitColumns(cols);
						SetWaitImageVisible(0);
	                    SetVisible(0);
					}

	             case "t1sheet4":
                     with(sheetObj){
						var HeadTitle1="|TP/SZ|DR|DG|RF|AK|BB|S/HGR|D/HGR|T/HGR|M/HGR|EQ SUB TP/SZ|SOC|R|D|VOL";
						
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
						
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						InitHeaders(headers, info);
						
						var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
										{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
										{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dry_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crr_hngr_sgl_bar_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"crr_hngr_dbl_bar_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"crr_hngr_tpl_bar_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mer_hngr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_subst_cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
										{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"soc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
										{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
										{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
										{Type:"Text",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
						
						InitColumns(cols);
						SetCountPosition(0);
						SetVisible(0);
						SetWaitImageVisible(0);
						SetSheetHeight(ComGetSheetHeight(sheetObj, 4));
	             	}
	 				break;  				
            }
        }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        	case INIT:      //Default
        		var sXml=ComGetObjValue(formObj.sXml);
        		formObj.sXml.value=null;
        		var arrXml=sXml.split("|$$|");    
        		// Combo setting
				if (arrXml.length > 0){//r term
    				ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
				}     	        		
				if (arrXml.length > 1){//d term
    				ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");			
				}  				
				if (arrXml.length > 2){//usa filer
					ComBkgXml2ComboItem(arrXml[2], comboObjects[2], "val", "name");
					comboObjects[2].InsertItem(0,"","");
				}				
				if (arrXml.length > 3){//canada filer
					ComBkgXml2ComboItem(arrXml[3], comboObjects[3], "val", "name");
					comboObjects[3].InsertItem(0,"","");
				}   			
				if (arrXml.length > 4){//weight
					ComBkgXml2ComboItem(arrXml[4], comboObjects[4], "val", "val");
				}    				
				if (arrXml.length > 5){//rail bulk
					ComBkgXml2ComboItem(arrXml[5], comboObjects[5], "val", "name");
				}       
				
				// Default value setting
				var rcvTermCd=ComGetEtcData(arrXml[0],"rcv_term_cd");
				if(rcvTermCd != ""){
					comboObjects[0].SetSelectCode(rcvTermCd);
				}else{
					comboObjects[0].SetSelectCode("Y");
				}
				if(rcvTermCd != "D"){					
					document.form.mty_dor_arr_dt.disabled=true;
				}								
				var deTermCd=ComGetEtcData(arrXml[0],"de_term_cd");
				if(deTermCd != ""){
					comboObjects[1].SetSelectCode(deTermCd);
				}else{
					comboObjects[1].SetSelectCode("Y");
				}
				formObj.mty_pkup_yd_cd.value=ComGetEtcData(arrXml[0],"mty_pkup_yd_cd");
				if("Y"==ComGetEtcData(arrXml[0],"auto_edi_hld_flg")){
					formObj.edi_hld_flg.checked=true;
				} else {
					formObj.edi_hld_flg.checked=false;					
				}
				// Qty setting
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetColBackColor("cntr_tpsz_cd","#CCFFFD");
				sheetObjects[0].SetColBackColor("op_cntr_qty","#CCFFFD");
				if(ComGetEtcData(arrXml[0],"cntr_tpsz_cd") != ""){					
					sheetObjects[0].SetCellValue(1,"cntr_tpsz_cd",ComGetEtcData(arrXml[0],"cntr_tpsz_cd"));
				}
				if(ComGetEtcData(arrXml[0],"wgt_ut_cd") != ""){
					comboObjects[4].SetSelectCode(ComGetEtcData(arrXml[0],"wgt_ut_cd"),false);
				}else{
					comboObjects[4].SetSelectCode("KGS",false);
				}				
				formObj.chkTaaRfaNo[1].checked=true;				
				document.all.item("taaNoDiv").style.display="none";
				document.all.item("rfaNoDiv").style.display="inline";
				btn007901Control(false, "btn_t1GoIBCS");
				btn007901Control(false, "btn_t1FaxEDI");
				btn007901Control(false, "btn_t1Holding");
				btn007901Control(false, "btn_t1Waiting");
	    	    ComSetObjValue(formObj.modify_flag, 		"N");
	        	ComSetObjValue(formObj.customer_modify_flag,"N");
	        	ComSetObjValue(formObj.contact_modify_flag, "N");
	    	    ComSetObjValue(formObj.qty_modify_flag, 	"N");
	    	    ComSetObjValue(formObj.close_bkg_flag, 		"N");
	    	    ComSetObjValue(formObj.cbf_bkg_flag, 		"N");
				manageHaveRouteFlag("Y");
				if(ComGetObjValue(formObj.isInquiry) == "Y"){
					setInquiryDisableButton();
				} else if(ComGetObjValue(formObj.ca_new_creation_flag) == "Y"){
					btn007901Control(false, "btn_t1retrieve");
					btn007901Control(false, "btn_t1Split");
					ComGetObject("bkg_no").className="input2";
					ComGetObject("bl_no").className="input2";
//					ComGetObject("bkg_trunk_vvd").className="input1";
				}
				sheetObjects[0].SetBlur();
				ComSetFocus(document.form.bkg_no);
		    	formObj.sXml.value=null;
                break;
        	case SEARCH:        //Retrieve
				if(ComIsNull(formObj.bkg_no.value) && ComIsNull(formObj.bl_no.value)){
					ComShowCodeMessage("BKG00426");
					return false; 					
				}    		
    
				BkgEnableObject(formObj.dcgo_flg,    true);
	        	BkgEnableObject(formObj.rc_flg,      true);
	        	BkgEnableObject(formObj.awk_cgo_flg, true);
	        	BkgEnableObject(formObj.bb_cgo_flg,  true);
	        	
				if(ComGetObjValue(formObj.modify_flag) == "Y"&&!ComIsNull(formObj.old_bkg_no)){
        			if(ComShowCodeConfirm("BKG00350")){
        				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
        				if(validateForm(formObj, COMMAND01)){
        					doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
        				}
        			}else{
        				search(formObj, sheetObj);
        			}
        		}else{
        			search(formObj, sheetObj);
        		}	
				
				if(formObj.bkg_no != ""){
					formObj.bkg_wt_chk_flg.disabled = true;
				}
				
//				waitChecked();
		    	break;
        	case COMMAND01:        //save
	    		if(ComGetObjValue(formObj.isInquiry) == "Y"){
	    			return;
	    		}
	    		
	    		ComOpenWait(true);
	    		
	    		setTimeout("saveDataComand01();", 100);
	    		
//	    		if(precheckFlag == "Y"){
//	    			comBkgCallPop0200(formObj.bkg_no.value, formObj.ca_flg.value);
//	    		}
	    		
        		break;
			case COMMAND03:      //booking split no Retrieve 
				ComSetObjValue(formObj.f_cmd, COMMAND03);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd="+COMMAND03+"&bkg_no="+formObj.bkg_no.value);
				var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
				bkgSplitNoListPop(formObj.bkg_no,bkg_split_no_list,-15);         	
				break;
			case MODIFY04:      //Waiting -> Firm
				ComSetObjValue(formObj.f_cmd, MODIFY04);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var bkgWtChkFlg = formObj.bkg_wt_chk_flg.value;
				var ediHldFlg = formObj.edi_hld_flg.value;
				var bkgpolCd = formObj.bkg_pol_cd.value;
				var qtyModifyFlag = formObj.qty_modify_flag.value;
				var param = "newStsCd=" + newStsCd + "&f_cmd="+MODIFY04+"&bkg_no="+formObj.bkg_no.value + "&bkg_wt_chk_flg=" + bkgWtChkFlg + "&edi_hld_flg=" + ediHldFlg + "&bkg_pol_cd=" + bkgpolCd
				 + "&qty_modify_flag=" + qtyModifyFlag + "&his_ui_nm=ESM_BKG_0079_01";
				var sXml=sheetObj.GetSaveData("ESM_BKG_0079_01GS.do", param);
				ComOpenWait(false); 
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				
				if(ComGetEtcData(sXml, "psaValCode") != "Y" && ComGetEtcData(sXml, "psaValCode") != undefined){
					var errMsg01 = ComGetEtcData(sXml,"psaValCode");
					//alert("errMsg01 : " + errMsg01);
					/*
					 * if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") { }
					 */
					if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {
				    	var rmsg = errMsg01.split("<||>");
				    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
				    		ComShowCodeMessage("BKG06125");
				    	}else if ( rmsg[1] != "BKG95025" ){
				    		ComShowMessage(rmsg[3]);
				    	}
					}
				}	
				
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComGetObject("btn_t1Waiting").style.display="inline";
					ComGetObject("btn_t1Holding").style.display="none";		
					ComBkgSaveCompleted();
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				
				break;			
			case MODIFY05:      //Firm -> Waiting
				ComSetObjValue(formObj.f_cmd, MODIFY05);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0079_01GS.do?newStsCd=P", "f_cmd="+MODIFY05+"&bkg_no="+formObj.bkg_no.value);
				ComOpenWait(false); 
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComGetObject("btn_t1Waiting").style.display="none";
					ComGetObject("btn_t1Holding").style.display="inline";		
					ComBkgSaveCompleted();
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				break;
			case MODIFY06:      //Cancel
//				var sXml = sheetObj.GetSaveData("ESM_BKG_0620GS.do", "f_cmd="+SEARCH01 + "&bkg_no="+formObj.bkg_no.value +"&type=B");
//				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
//					if(ComGetEtcData(sXml, "CNT") > 0){
						comBkgCallPop0620('setCallBack0620');
						return;
//					}
//				}
//				cancelFuncion('');
				break;
			case MODIFY07:
				if(ComGetObjValue(formObj.modify_flag) == "N"){
	    			ComShowCodeMessage("BKG00233");
	    			return false;
	    		}
				var sXml = sheetObj.GetSaveData("ESM_BKG_0079_01GS.do", "f_cmd="+MODIFY07 + "&bkg_no=" + formObj.bkg_no.value + "&xter_rmk=" + formObj.xter_rmk.value + "&ca_flg=" + formObj.ca_flg.value);
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					formObj.modify_flag.value = 'N';
					ComBkgSaveCompleted();
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				break;
        }
    }
    
    function setCallBack0620(message){
    	cancelFuncion(message);
    }
    
    function cancelFuncion(message){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[2];
    	ComSetObjValue(formObj.f_cmd, MODIFY06);
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);		
		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_01GS.do", "f_cmd="+MODIFY06+
															   "&bkg_no="+formObj.bkg_no.value+
															   "&ca_flg="+formObj.ca_flg.value+
															   "&close_bkg_flag="+formObj.close_bkg_flag.value+
															   "&cbf_bkg_flag="+formObj.cbf_bkg_flag.value+
															   "&xter_bkg_rqst_cd="+formObj.xter_bkg_rqst_cd.value+
															   "&xter_rmk="+formObj.xter_rmk.value+
															   "&bkg_ofc_cd="+formObj.bkg_ofc_cd.value+
															   "&bkg_cntc_pson_eml="+formObj.bkg_cntc_pson_eml.value+
															   "&xter_bkg_rqst_ref_no="+formObj.xter_bkg_rqst_ref_no.value+
															   "&message="+message
		);
		ComOpenWait(false); 
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		if(ComGetEtcData(sXml, "closeBkgFlag") =="Y"){
			var firstVvd=ComGetEtcData(sXml, "first_vvd");
			if(ComShowCodeConfirm("BKG00312",firstVvd)){
				ComSetObjValue(formObj.close_bkg_flag, "Y");
				doActionIBSheet(sheetObjects[2], formObj, MODIFY06);
				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
            		var subject="BKG Change Notice";            		
				}
			} else {
				ComSetObjValue(formObj.close_bkg_flag, "N");	
				return;
			}		
		}else if(ComGetEtcData(sXml, "cbfBkgFlag") =="Y"){
			if(ComShowCodeConfirm("BKG02069")){
				ComSetObjValue(formObj.cbf_bkg_flag, "Y");
				doActionIBSheet(sheetObjects[2], formObj, MODIFY06);
				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
            		var subject="BKG Change Notice";            		
				}
			} else {
				ComSetObjValue(formObj.cbf_bkg_flag, "N");	
				return;
			}	
		}else{
			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
				ComShowCodeMessage("BKG00590");
				doActionIBSheet(sheetObj, formObj, SEARCH);
			}									
		} 
    }
    
    function saveDataComand01(){
    	resetQtyDetail();
    	
    	var formObj = document.form;
    	ComSetObjValue(formObj.xter_rmk, chekcSpecialValue(ComGetObjValue(formObj.xter_rmk)));
    	ComSetObjValue(formObj.vndr_rmk, chekcSpecialValue(ComGetObjValue(formObj.vndr_rmk)));
    	ComSetObjValue(formObj.inter_rmk, chekcSpecialValue(ComGetObjValue(formObj.inter_rmk)));
    	
    	var sheetObj = sheetObjects[2];
		// Black List Check
		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do?f_cmd="+COMMAND04, FormQueryString(formObj));
		var black_cust_flag=ComGetEtcData(sXml, "black_cust_flag");
		var black_cust_list=ComGetEtcData(sXml, "black_cust_list");
		if(black_cust_flag == "Y"){
			if(!ComShowCodeConfirm("BKG02070", black_cust_list)){
				ComOpenWait(false);
				return false;
			}
		}
		var oldBkgNo=ComGetObjValue(formObj.old_bkg_no);
		var haveRouteFlag=ComGetObjValue(formObj.have_route_flag);
		var qtyModifyFlag=ComGetObjValue(formObj.qty_modify_flag);
		//var precheckFlag="";
		if(ComIsNull(oldBkgNo)){
			if(haveRouteFlag == "N"){
				ComSetObjValue(formObj.f_cmd, MULTI01);	// Create Without Route
			}else{
				ComSetObjValue(formObj.f_cmd, MULTI02);	// Create With Route
			}
		}else{
			if(haveRouteFlag == "N"){
				ComSetObjValue(formObj.f_cmd, MULTI03);	// Modify Without Route
				ComSetObjValue(formObj.pctl_no, "");
			}else{
				ComSetObjValue(formObj.f_cmd, MULTI04);	// Modify With Route
			}        			
		}        		
		if(ComGetObjValue(formObj.ca_flg) == "Y" && sheetObjects[1].LastRow()>=5){
			ComSetObjValue(formObj.f_cmd, MULTI03);	// Modify With Route        			
		}
		setBookingEditable(true);
		var isFlexHgtFlg=false;
		if(formObj.flex_hgt_flg.disabled){
			formObj.flex_hgt_flg.disabled=false;
			isFlexHgtFlg=true;
		}
		formObj.act_wgt.value=formObj.act_wgt.value.replace(/,/g, "");
		var params=FormQueryString(formObj);				
		if(isFlexHgtFlg){
			formObj.flex_hgt_flg.disabled=true;
		}
		ComSetObjValue(formObj.act_wgt, makeComma(ComGetObjValue(formObj.act_wgt)));
		params=params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true),"t1sheet4_");
		params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true),"t1sheet1_");
		params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true),"t1sheet2_");
		var sXml="";
		var IsPctlNoPop="";
		var coVVD = formObj.bkg_trunk_vvd.value;
		var prdPopChk = true;
		if(coVVD != ""){
			coVVD = coVVD.substring(0,4);
			if(coVVD == "COXX"|| coVVD == "COYY" || coVVD == "COZZ"){
				prdPopChk = false;
			}
		}
		if(formObj.f_cmd.value == "183" && prdPopChk){
			IsPctlNoPop = "YM"; //MULTI 03 Modify Without Route
		} else if(formObj.f_cmd.value == "181" && prdPopChk){
			IsPctlNoPop = "YC"; // MULTI 01, MULTI 02 Create Without Route
		} else if(formObj.inter_rmk.value == "PRD POP" && prdPopChk){
			IsPctlNoPop="YC";
			formObj.inter_rmk.value="";
		} else {
			var dcgo = formObj.dcgo_flg.checked==1?'Y':'N';
			var rc = formObj.rc_flg.checked==1?'Y':'N';
			var awk = formObj.awk_cgo_flg.checked==1?'Y':'N';
			var bb_cgo = formObj.bb_cgo_flg.checked==1?'Y':'N';
			
			if(!esdPrd0080 && formObj.bkg_sts_cd.value != '' && formObj.dcgo_flg_old.value != dcgo && prdPopChk){
				IsPctlNoPop="YM";
			}else if(!esdPrd0080 && formObj.bkg_sts_cd.value != '' && formObj.rc_flg_old.value != rc && prdPopChk){
				IsPctlNoPop="YM";
			}else if(!esdPrd0080 && formObj.bkg_sts_cd.value != '' && formObj.awk_cgo_flg_old.value != awk && prdPopChk){
				IsPctlNoPop="YM";
			}else if(!esdPrd0080 && formObj.bkg_sts_cd.value != '' && formObj.bb_cgo_flg_old.value != bb_cgo && prdPopChk){
				IsPctlNoPop="YM";
			}else{
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sXml = sheetObj.GetSaveData("ESM_BKG_0079_01GS.do", params);
				if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
					setBookingEditable(false);
				}else{
					setBookingEditable(true);
				}					
				ComOpenWait(false);	 
				var arrXml=sXml.split("|$$|");
				IsPctlNoPop=ComGetEtcData(sXml, "IsPctlNoPop");
				
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S" && formObj.bkg_wt_chk_flg.checked && !formObj.bkg_wt_chk_flg.disabled){
					if(formObj.bkg_no.value == "") formObj.bkg_no.value = ComGetEtcData(sXml, "bkg_no");
					sheetObj.GetSaveData("ESM_BKG_0079_01GS.do?newStsCd=P", "f_cmd="+MODIFY05+"&bkg_no="+formObj.bkg_no.value);
				};
				esdPrd0080 = false;
			}
		}
		if(ComGetEtcData(sXml, "closeBkgFlag") =="Y"){
			var firstVvd=ComGetEtcData(sXml, "first_vvd");
			if(ComShowCodeConfirm("BKG00312",firstVvd)){
				ComSetObjValue(formObj.close_bkg_flag, "Y");
				ComSetObjValue(formObj.mail_open_flag, "Y");
				doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
					//bkg close mail open
					//=========================================================================================
					var subject=ComIsNull(oldBkgNo)?"BKG Creation Notice":"BKG Change Notice";
					var closeBkgMsg=ComGetEtcData(sXml, "closeBkgMsg");
					if(ComIsNull(oldBkgNo)){ 
//						closeBkgMsg="BKG No : " + formObj.bkg_no.value + "<BR>" + closeBkgMsg.substring(13);
						closeBkgMsg= closeBkgMsg.substring(13);
						oldBkgMailContents = "Y";
					}
					//=========================================================================================
 		        	document.form.com_subject.value=subject + " after VVD closed - BKG No : "+ formObj.bkg_no.value;;
 		        	document.form.com_content.value=closeBkgMsg;
// 		        	ComSendMailModal();
				}        				
			} else {
				ComSetObjValue(formObj.close_bkg_flag, "N");
				ComSetObjValue(formObj.mail_open_flag, "N");
				//break;
				ComOpenWait(false);
				return;
			}
		} else if(ComGetEtcData(sXml, "cbfBkgFlag") =="Y"){
			if(ComShowCodeConfirm("BKG02069")){
				ComSetObjValue(formObj.cbf_bkg_flag, "Y");
				doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
					//bkg close mail open
					//=========================================================================================
					var subject=ComIsNull(oldBkgNo)?"BKG Creation Notice":"BKG Change Notice";
					var closeBkgMsg=ComGetEtcData(sXml, "closeBkgMsg");
					if(ComIsNull(oldBkgNo)){ 
						closeBkgMsg="BKG No : " + formObj.bkg_no.value + "<BR>" + closeBkgMsg.substring(13);
					}
					//=========================================================================================
				}        				
			} else {
				ComSetObjValue(formObj.cbf_bkg_flag, "N");	
				//break;
				ComOpenWait(false);
				return;
			}
		} else if(IsPctlNoPop == "YC" || IsPctlNoPop == "YM"){
			var url="";
			if(IsPctlNoPop == "YC"){
				url="ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=B";
			}else if(IsPctlNoPop == "YM"){
				url="ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=R";
				url=url + "&bkg_no=" +	ComGetObjValue(formObj.bkg_no);
			} else {
				url="ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=B";						
			}
			url=url + "&por="   + ComGetObjValue(formObj.bkg_por_cd);
			if(ComGetObjValue(formObj.bkg_por_yd_cd) != null && ComGetObjValue(formObj.bkg_por_yd_cd).length > 1)
				url=url + "&por_n=" + ComGetObjValue(formObj.bkg_por_cd) + ComGetObjValue(formObj.bkg_por_yd_cd);
			url=url + "&pol="   + ComGetObjValue(formObj.bkg_pol_cd);
			if(ComGetObjValue(formObj.bkg_pol_yd_cd)!= null && ComGetObjValue(formObj.bkg_pol_yd_cd).length > 1)
				url=url + "&pol_n=" + ComGetObjValue(formObj.bkg_pol_cd) + ComGetObjValue(formObj.bkg_pol_yd_cd);
			url=url + "&pod="   + ComGetObjValue(formObj.bkg_pod_cd);
			if(ComGetObjValue(formObj.bkg_pod_yd_cd)!= null && ComGetObjValue(formObj.bkg_pod_yd_cd).length > 1)
			url=url + "&pod_n=" + ComGetObjValue(formObj.bkg_pod_cd) + ComGetObjValue(formObj.bkg_pod_yd_cd);
			url=url + "&del="   + ComGetObjValue(formObj.bkg_del_cd);
			if(ComGetObjValue(formObj.bkg_del_yd_cd)!= null && ComGetObjValue(formObj.bkg_del_yd_cd).length > 1)
			url=url + "&del_n=" + ComGetObjValue(formObj.bkg_del_cd) + ComGetObjValue(formObj.bkg_del_yd_cd);
		//	url=url + "&t_vvd=" + ComGetObjValue(formObj.bkg_trunk_vvd);
			url=url + "&t_vvd="
			for(i=1 ; i <= sheetObjects[1].LastRow(); i++){
				url=url + "&pol" + i + "="   + sheetObjects[1].GetCellValue(i, "pol_cd");
				if(sheetObjects[1].GetCellValue(i, "pol_yd_cd")!= null && sheetObjects[1].GetCellValue(i, "pol_yd_cd").length > 1)
					url=url + "&pol" + i + "_n=" + sheetObjects[1].GetCellValue(i, "pol_cd") + sheetObjects[1].GetCellValue(i, "pol_yd_cd");
				url=url + "&pol" + i + "_c=" + sheetObjects[1].GetCellValue(i, "pol_clpt_ind_seq");
				url=url + "&pod" + i + "="   + sheetObjects[1].GetCellValue(i, "pod_cd");
				if(sheetObjects[1].GetCellValue(i, "pod_yd_cd")!= null  && sheetObjects[1].GetCellValue(i, "pod_yd_cd").length > 1)
					url=url + "&pod" + i + "_n=" + sheetObjects[1].GetCellValue(i, "pod_cd") + sheetObjects[1].GetCellValue(i, "pod_yd_cd");
				url=url + "&pod" + i + "_c=" + sheetObjects[1].GetCellValue(i, "pod_clpt_ind_seq");
				url=url + "&vvd" + i + "="   + sheetObjects[1].GetCellValue(i, "bkg_vvd_cd");
			} 
			url=url + "&rcv_t=" + ComGetObjValue(rcv_term_cd);
			url=url + "&del_t=" + ComGetObjValue(de_term_cd);
			url=url + "&shpr="  + ComGetObjValue(formObj.s_cust_cnt_cd)+ComGetObjValue(formObj.s_cust_seq);
			url=url + "&cngn="  + ComGetObjValue(formObj.c_cust_cnt_cd)+ComGetObjValue(formObj.c_cust_seq);
			url=url + "&com="     + ComGetObjValue(formObj.cmdt_cd);
			url=url + "&rep_com=" + ComGetObjValue(formObj.rep_cmdt_cd);
			url=url + "&wgt="     + ComGetObjValue(formObj.act_wgt).replace(/,/g, "");
			url=url + "&wgt_un="  + ComGetObjValue(wgt_ut_cd);
			url=url + "&bkg_ofc=" + ComGetObjValue(formObj.bkg_ofc_cd);
			url=url + "&org_sal_ofc=" + ComGetObjValue(formObj.ob_sls_ofc_cd);
			url=url + "&m_pu="        + ComGetObjValue(formObj.mty_pkup_yd_cd);
			url=url + "&mt_pkup_dt="  + changeDateFormat(ComGetObjValue(formObj.mty_pkup_dt));
			url=url + "&f_rt="  + ComGetObjValue(formObj.full_rtn_yd_cd);						
			url=url + "&ld_dt=" + changeDateFormat(ComGetObjValue(formObj.lodg_due_dt));
			url=url + "&dr_dt=" + changeDateFormat(ComGetObjValue(formObj.de_due_dt));
			url=url + "&org_trns_mode="  + changeTransMode(ComGetObjValue(formObj.org_trns_mod_cd));
			url=url + "&dest_trns_mode=" + changeTransMode(ComGetObjValue(formObj.dest_trns_mod_cd));
			if(!ComIsNull(ComGetObjValue(formObj.rfa_no))){
				url=url + "&rfa=" + ComGetObjValue(formObj.rfa_no);
			}
			if(!ComIsNull(ComGetObjValue(formObj.sc_no))){
				url=url + "&sc=" + ComGetObjValue(formObj.sc_no);						
			}
			for(i=1 ; i <= sheetObjects[0].LastRow() ; i++){
				url=url + "&c_tpsz="+sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd");
				url=url + "&c_qty="+sheetObjects[0].GetCellValue(i, "op_cntr_qty");
			}					
			if(formObj.bkg_cgo_tp_cd.checked){
				url=url + "&cgo_tp=R"; 
			}else{
				url=url + "&cgo_tp=F";
			}
			if(formObj.dcgo_flg.checked){
				url=url + "&dg_f=Y";
			}else{
				url=url + "&dg_f=N";
			}			
			if(formObj.rc_flg.checked){
				url=url + "&rf_f=Y";
			}else{
				url=url + "&rf_f=N";
			}	
			if(formObj.awk_cgo_flg.checked){
				url=url + "&ak_f=Y";
			}else{
				url=url + "&ak_f=N";
			}			
			if(formObj.bb_cgo_flg.checked){
				url=url + "&bb_f=Y";
			}else{
				url=url + "&bb_f=N";
			}						
			if(formObj.hot_de_flg.checked){
				url=url + "&pm_f=Y";
			}else{
				url=url + "&pm_f=N";
			}
			if(formObj.flex_hgt_flg.checked){
				url=url + "&flex_hgt_flg=Y";
			}else{
				url=url + "&flex_hgt_flg=N";
			}						
			url=url + "&rd_f="  + ComGetObjValue(formObj.rd_cgo_flg);
			url=url + "&hg_f="  + ComGetObjValue(formObj.hngr_flg);
			url=url + "&soc_f=" + ComGetObjValue(formObj.soc_flg);
			url=url + "&sub_f=" + ComGetObjValue(formObj.eq_subst_flg);
			ComSetObjValue(formObj.pctl_no, "");
 	    	manageHaveRouteFlag("N");
 	    	if(ComGetEtcData(sXml, "pre_checking")!=undefined && ComGetEtcData(sXml, "pre_checking")!=null){
				tmpPreCheckFlag = ComGetEtcData(sXml, "pre_checking");
			}
 	    	ComOpenPopup(url, 1100, 600, "callBackEsdPrd0080",	"1,0,1,1,1", true); 
		}else{
			if(ComGetEtcData(arrXml[0], "Toyota") == 'Y'){
				if(ComShowConfirm('Would you like to create Booking for For 10-digit BL No.?')){
					formObj.bkg_ty_flg.checked = 1;
				}else{
					formObj.usr_toyota_check.value = "Y";
				}
				saveDataComand01();
			}else{
				if (arrXml.length > 0){
					sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
				}      		 
				if(ComGetEtcData(sXml, "psaValCode") != "Y" && ComGetEtcData(sXml, "psaValCode") != undefined){
					var errMsg01=ComGetEtcData(sXml,"psaValCode");
					//alert("errMsg01 : " + errMsg01);
					/*
					 * if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") { }
					 */
					if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {
				    	var rmsg=errMsg01.split("<||>");
				    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
				    		ComShowCodeMessage("BKG06125");
				    	}else if ( rmsg[1] != "BKG95025" ){
				    		ComShowMessage(rmsg[3]);
				    	}
					}
				}	
				if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
					
					if(checkConfirm){
						checkConfirm = false;
						ComShowMessage(checkConfirmMsg);
					}
					
					ComBkgSaveCompleted();
					if(ComGetEtcData(sXml, "bkg_no") != undefined){
						//ComResetAll();
						formObj.bkg_no.value=ComGetEtcData(sXml, "bkg_no");
					}
					
					ComSetObjValue(formObj.modify_flag, "N");
					precheckFlag=ComGetEtcData(sXml, "pre_checking");
					doActionIBSheet(sheetObj, formObj, SEARCH);

					//add 2015/01/16
					if(precheckFlag == "Y"){
						comBkgCallPop0200(formObj.bkg_no.value, formObj.ca_flg.value);
					}
					
					/* CAIssue ConFirm 체크 로직 */
					//saveCAIssueConFirmCheck();
				}			
			}
		}		
		ComOpenWait(false);
    }
    
    /**
     * handling process for input validation(Save) 
     */
    function validateForm(formObj, sAction){
    	var bkgNo=formObj.bkg_no.value;
        switch(sAction) {
    		case COMMAND01:      // Save   
    			
    			if(formObj.bl_no_ck.value != '' && (formObj.bl_no_ck.value != formObj.bl_no.value)){
    				ComShowMessage("You can't change the number of B/L.");
        			return false;
        		}
    			
    			var searchSoStatusCheck = false;
    			if(formObj.por_cd_old.value != "" && formObj.por_cd_old.value != formObj.bkg_por_cd.value){
    				searchSoStatusCheck = true;
    			}else if(formObj.pol_cd_old.value != "" && formObj.pol_cd_old.value != formObj.bkg_pol_cd.value){
    				searchSoStatusCheck = true;
    			}else if(formObj.rcv_term_cd_old.value != "" && formObj.rcv_term_cd_old.value != formObj.rcv_term_cd_text.value){
    				searchSoStatusCheck = true;
    			}
    			
    			/* POR or POL or R/D Term 변경되었을 경우 호출 */
//    			if(searchSoStatusCheck){
//    				var sXml = sheetObjects[0].GetSearchData("ESM_Booking_UtilGS.do?f_cmd=" + SEARCH15, FormQueryString(formObj));
//    				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F'){
//    					ComShowMessage('S/O has been already issued. Please cancel S/O.');
//    					return false;
//    				}
//    			}
    			
	    		if(ComGetObjValue(formObj.modify_flag) == "N"){
	    			ComShowCodeMessage("BKG00233");
	    			return false;
	    		}
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking 시
    				ComShowCodeMessage("BKG00005");
    				return false;
    			}
    			if(formObj.mnl_bkg_no_flg.value == "Y" && ComIsNull(formObj.old_bkg_no.value)){
    				var mnlBkgNo=ComGetObjValue(formObj.bkg_no);
    				if(mnlBkgNo.length != 10 && mnlBkgNo.length != 12){
        				ComShowCodeMessage("BKG00255");
    					ComSetFocus(formObj.bkg_no);
        				return false;
    				}
    			}  			
    			if(ComGetObjValue(formObj.mnl_bkg_no_flg) != "Y"||ComIsNull(formObj.mnl_bkg_no_flg)){
	    			if(ComGetObjValue(formObj.old_bkg_no) != bkgNo){	
	    				ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
						ComSetFocus(formObj.bkg_no);
	    				return false;    				
	    			}
				}
    			if(parseFloat(ComGetObjValue(formObj.act_wgt),10) <= 0){	// Weight '0' insert
    				ComShowCodeMessage("BKG00014");
					ComSetFocus(formObj.act_wgt);
    				return false;
    			}
    			var wgtUtCd=comboObjects[4].GetSelectCode();
    			if(ComTrim(wgtUtCd) == ""){							// Weight Unit 
    				ComShowCodeMessage("BKG00015");
    				return false;    				
    			}
    			if (ComChkLen(formObj.cmdt_cd, 6) != 2){	
					ComShowCodeMessage("BKG00010");		
    				ComSetFocus(formObj.cmdt_cd);
    				return false;    			    				
    			}
    			if (ComIsNull(formObj.cmdt_desc)){	
					ComShowCodeMessage("BKG00010");		
    				ComSetFocus(formObj.cmdt_cd);
    				return false;    			    				
    			}
    			if(!ComIsNull(formObj.rep_cmdt_cd) && ComChkLen(formObj.rep_cmdt_cd, 4) != 2){	
    				ComShowCodeMessage("BKG00011");		
    				return false;    			    				    				
    			}
    			var rfaNo=ComGetObjValue(formObj.rfa_no);
    			var scNo=ComGetObjValue(formObj.sc_no);
    			var taaNo=ComGetObjValue(formObj.taa_no);
    			if(rfaNo.length < 1 && scNo.length < 1 && taaNo.length<1){
    				ComShowCodeMessage("BKG00016");		
					ComSetFocus(formObj.sc_no);
    				return false;    		    				
    			}
    			if((scNo.length>0&&scNo.substring(0,3)!="DUM")||
					(rfaNo.length>0&&rfaNo.substring(0,3)!="DUM")||
					(taaNo.length>0&&taaNo.substring(0,3)!="DUM")){
    				if((scNo.length>0&&scNo.substring(0,3)=="DUM")||
						(rfaNo.length>0&&rfaNo.substring(0,3)=="DUM")||
						(taaNo.length>0&&taaNo.substring(0,3)=="DUM")){
    					ComShowCodeMessage("BKG02050");
    					return false;
    				}
    			}
    			if(!ComIsNull(rfaNo)&&!ComIsNull(taaNo)){
					ComShowCodeMessage("BKG00016");    				
    				return false;
    			}
		    	if(scNo.substring(0,3) == "DUM0000001" || rfaNo.substring(0,3) == "DUM000001" || taaNo.substring(0,3) == "DUM000001"){
		    		ComSetObjValue(formObj.ctrt_ofc_cd,ComGetObjValue(formObj.ob_sls_ofc_cd));
		    		ComSetObjValue(formObj.ctrt_srep_cd,ComGetObjValue(formObj.ob_srep_cd));
		    	}   			
    			if(ComIsNull(formObj.s_cust_cnt_cd)){		
    				if(!ComIsNull(formObj.s_cust_seq)){
        				ComShowCodeMessage("BKG00008");	
    					ComSetFocus(formObj.s_cust_cnt_cd);	
        				return false;    	    					
    				}
    			}else{
    				if(ComChkLen(formObj.s_cust_cnt_cd, 2) != 2){	
    					ComShowCodeMessage("BKG00008");		
						ComSetFocus(formObj.s_cust_cnt_cd);
        				return false;    	      					
    				}
    				if(ComIsNull(formObj.s_cust_seq) || ComGetObjValue(formObj.s_cust_seq) == "0"){	
        				ComShowCodeMessage("BKG00008");	
						ComSetFocus(formObj.s_cust_seq);	
        				return false;    	        					
    				}    					
    			}
    			if(ComIsNull(formObj.f_cust_cnt_cd)){		
    				if(!ComIsNull(formObj.f_cust_seq)){
        				ComSetFocus(formObj.f_cust_cnt_cd);	
        				ComShowCodeMessage("BKG00293");	
    					return false;    	    					
    				}
    			}else{
    				if(ComChkLen(formObj.f_cust_cnt_cd, 2) != 2){	
    					ComShowCodeMessage("BKG00293");		
    					ComSetFocus(formObj.f_cust_cnt_cd);
    					return false;    	      					
    				}
    				if(ComIsNull(formObj.f_cust_seq) || ComGetObjValue(formObj.f_cust_seq) == "0"){	
    					ComShowCodeMessage("BKG00293");		
    					ComSetFocus(formObj.f_cust_seq);
    					return false;    	        					
    				}   				
    			}    		
    			
    			if(ComIsNull(formObj.bkg_pty_cnt_cd)){		
    				if(!ComIsNull(formObj.bkg_pty_cust_seq)){
        				ComSetFocus(formObj.bkg_pty_cnt_cd);	
        				ComShowCodeMessage("BKG08339");	
    					return false;    	    					
    				}
    			}else{
    				if(ComChkLen(formObj.bkg_pty_cnt_cd, 2) != 2){	
    					ComShowCodeMessage("BKG08339");		
    					ComSetFocus(formObj.bkg_pty_cnt_cd);
    					return false;    	      					
    				}
    				if(ComIsNull(formObj.bkg_pty_cust_seq) || ComGetObjValue(formObj.bkg_pty_cust_seq) == "0"){	
    					ComShowCodeMessage("BKG08339");		
    					ComSetFocus(formObj.bkg_pty_cust_seq);
    					return false;    	        					
    				}   				
    			}    		
    			
    			if(ComIsNull(formObj.c_cust_cnt_cd)){		
    				if(!ComIsNull(formObj.c_cust_seq)){
        				ComShowCodeMessage("BKG00009");
    					ComSetFocus(formObj.c_cust_seq);	
        				return false;    	    					
    				}
    			}else{
    				if(ComChkLen(formObj.c_cust_cnt_cd, 2) != 2){	
    					ComShowCodeMessage("BKG00009");		
						ComSetFocus(formObj.c_cust_cnt_cd);	
        				return false;    	      					
    				}
    			}
    			if(ComIsNull(formObj.s_cust_cnt_cd) && ComIsNull(formObj.f_cust_cnt_cd)){		
    				ComShowCodeMessage("BKG01012");		
    				ComSetFocus(formObj.s_cust_cnt_cd);	
    				return false;    	        	    				
    			}
    			if(!chkCntrTpSz()){
    				return false;
    			}
    			var tpSzA=false;
    			var tpSzQ=true;
    			
    			/* 컨테이너 타입 사이즈 D and R 일경우 Awkward 체크 할수 없음 , true 일때 체크 가능 false 일때 체크 불가능 */
    			var tdSzAwkCheck = false;
//    			var tdSzD7Check = false;
    			for(i=1 ; i <= sheetObjects[0].LastRow() ; i++){
    				tpSz=sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd");
    				if("D"==sheetObjects[0].GetRowStatus(i)){
    					continue;
    				}
    				
//    				if(tpSz == 'D7') tdSzD7Check = true;
    				
    				if(tpSz.substring(0,1) == 'R' && !tdSzAwkCheck){
    					tdSzAwkCheck = false;
    				}else{
    					tdSzAwkCheck = true;
    				}
    				
    				if(tpSz != "Q2" && tpSz != "Q4"){
    					tpSzQ=false;
    				}
    				if(tpSz == "A2" || tpSz == "A4"){
    					tpSzA=true;
    				}
    				if(sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") == ""){
        				ComShowCodeMessage("BKG00062", " ");		
        				return false;    	            					
    				}
    				if(sheetObjects[0].GetCellValue(i, "op_cntr_qty") == 0){
        				ComShowCodeMessage("BKG00013");		
        				return false;    	            					
    				}
    				if(sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd") != "" && BkgParseFloat(sheetObjects[0].GetCellValue(i, "eq_subst_cgo_qty")) <= 0 ){
    					ComShowCodeMessage("BKG02010");		
    					return false;    	            					
    				}
    			}	
    			
    			/* 컨테이너 타입 사이즈 D and R 일경우 Awkward 체크 할수 없음 , true 일때 체크 가능 false 일때 체크 불가능 */
    			if(!tdSzAwkCheck && formObj.awk_cgo_flg.checked){
    				ComShowMessage("Awkward cannot be selected if the cargo is Dry or Reefer.");
    				return false;
    			}
    			
    			if(tpSzQ){
    				ComShowCodeMessage("BKG01013");		
    				return false;    	        	     				
    			}
    			if(ComChkLen(formObj.bkg_por_cd, 5) != 2){
    				ComShowCodeMessage("BKG00006");		
					ComSetFocus(formObj.bkg_por_cd);	
    				return false;    	    				
    			}
//    			if(ComChkLen(formObj.bkg_pol_cd, 5) != 2){
//    				ComShowCodeMessage("BKG00288");		
//					ComSetFocus(formObj.bkg_pol_cd);	
//    				return false;    	    				
//    			}
    			if(ComChkLen(formObj.bkg_del_cd, 5) != 2){
    				ComShowCodeMessage("BKG00290");		
					ComSetFocus(formObj.bkg_del_cd);	
    				return false;    	    				
    			}    	 
    			if(ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="US" || ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="PR"){
        			if(ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)!="CA"){
	    				if(ComGetObjValue(formObj.befUsaCstmsFileCd)==null||ComGetObjValue(formObj.befUsaCstmsFileCd).length<1){
	        				ComShowCodeMessage("BKG00283");		
	        				return false; 
	    				}
        			}
    			}   
    			if(ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)=="CA"){
    				if(ComGetObjValue(formObj.cnd_cstms_file_cd)==null||ComGetObjValue(formObj.cnd_cstms_file_cd).length<1){
        				ComShowCodeMessage("BKG00284");		
        				return false; 
    				}
				}

    			if(ComIsNull(formObj.pre_rly_port_cd) && ComIsNull(formObj.pst_rly_port_cd)){
//    				if(ComGetObjValue(formObj.bkg_pol_cd) == ComGetObjValue(formObj.bkg_pod_cd)){
    				if(!ComIsNull(formObj.bkg_pol_cd)){
    					if(ComGetObjValue(formObj.bkg_pol_cd) == ComGetObjValue(formObj.bkg_pod_cd)){
	        				ComShowCodeMessage("BKG00053");		
	        				return false;    	    				    					
    					}
    				}
    			}
	
    			var rcvTerm=ComGetObjValue(rcv_term_cd);
    			var delTerm=ComGetObjValue(de_term_cd);
    			if(rcvTerm == "T" || rcvTerm == "I"){
    				if(ComGetObjValue(formObj.bkg_por_cd) != ComGetObjValue(formObj.bkg_pol_cd)){
        				ComShowCodeMessage("BKG00270");		
    					ComSetFocus(formObj.bkg_por_cd);	
        				return false;      					
    				}
    			}
    			if(delTerm == "T" || delTerm == "O"){
    				if(ComGetObjValue(formObj.bkg_pod_cd) != ComGetObjValue(formObj.bkg_del_cd)){
        				ComShowCodeMessage("BKG00271");		
    					ComSetFocus(formObj.bkg_pod_cd);	
        				return false;      					
    				}
    			}

//    			if(sheetObjects[1].RowCount()> 0){
//    				if(!ComIsNull(formObj.bkg_trunk_vvd.value) && formObj.bkg_trunk_vvd.value != sheetObjects[1].GetCellValue(sheetObjects[1].FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd")){
//	    				ComShowCodeMessage("BKG00022", ComGetObjValue(formObj.bkg_trunk_vvd));	
//						ComSetFocus(formObj.bkg_trunk_vvd);		
//	    				return false;      		    				
//	    			}    			
//    			}
    			for(i=1 ; i <= sheetObjects[1].LastRow() ; i++){
    				if(!ComIsNull(sheetObjects[1].GetCellValue(i, "bkg_vvd_cd")) && ComChkLen(sheetObjects[1].GetCellValue(i, "bkg_vvd_cd"), 9) != 2){
    					ComShowCodeMessage("BKG00051", sheetObjects[1].GetCellValue(i, "bkg_vvd_cd"));
						ComSetFocus(formObj.bkg_trunk_vvd);
        				return false;       					
    				}
    			}    			
    			if(ComIsNull(formObj.bkg_trunk_vvd)){
        			if(formObj.ca_new_creation_flag == "Y"){
    					ComShowCodeMessage("BKG00051");
    					return false;        				
        			}
    				if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y"){
    					ComShowCodeMessage("BKG00051");
    					return false;
    				}
    				if(ComIsNull(formObj.mty_dor_arr_dt) && ComIsNull(formObj.lodg_due_dt)){
    					ComShowCodeMessage("BKG00017");	
						ComSetFocus(formObj.lodg_due_dt);
        				return false;
    				}
    			}else{
    				if(ComChkLen(formObj.bkg_trunk_vvd, 9) != 2){
        				ComShowCodeMessage("BKG00051", ComGetObjValue(formObj.bkg_trunk_vvd));		
						ComSetFocus(formObj.bkg_trunk_vvd);
        				return false;      					
    				}
    				var pseudoVvd=ComGetObjValue(formObj.bkg_trunk_vvd).substring(0,4);
    				if(pseudoVvd == "COXX" || pseudoVvd == "COYY" || pseudoVvd == "COZZ"){
        				if(ComIsNull(formObj.mty_dor_arr_dt) && ComIsNull(formObj.lodg_due_dt)){
        					if(formObj.psdo_bkg_flg.value == "Y"){
        						ComSetObjValue(formObj.lodg_due_dt, ComGetDateAdd(ComGetNowInfo(),"D", +15))
        					} else {
	            				ComShowCodeMessage("BKG00017");
	    						ComSetFocus(formObj.mty_dor_arr_dt);
	            				return false;
        					}
        				}    					
    				}    				
    			}
    			if(formObj.rc_flg.checked){
    				if((sheetObjects[0].FindText("cntr_tpsz_cd","R",0,0) < 0) && (sheetObjects[0].FindText("cntr_tpsz_cd","T2",0) < 0) && (sheetObjects[0].FindText("cntr_tpsz_cd","T4",0) < 0)){
    						ComShowCodeMessage("BKG00054");
        				return false;      	    					
    				}
    			}
    			for(i=1 ; i <= sheetObjects[0].LastRow() ; i++){
    				if(sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd").substring(0,1) == "R" && (sheetObjects[0].GetCellValue(i, "rd_cgo_flg") != "RD" || sheetObjects[0].GetCellValue(i, "op_cntr_qty") != sheetObjects[0].GetCellValue(i, "eq_subst_cgo_qty"))){
        				if(!formObj.rc_flg.checked){
            				ComShowCodeMessage("BKG01015");
            				return false;      	    					
        				}    			    					
    				}    
    			}
    			if (!chkReeferDry()) {
    				ComShowCodeMessage("BKG02066");
    				return false;
    			}
    			if(ComIsNull(formObj.ob_sls_ofc_cd) || ComIsNull(formObj.ob_srep_cd)){
    				if(!ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){
    					comBkgCallPop0652('callBack0652_save','F', ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "");
    					return false;
    				} else {
    					comBkgCallPop0652('callBack0652_save','S', ComGetObjValue(formObj.s_cust_cnt_cd), ComGetObjValue(formObj.s_cust_seq), "");
    					return false;
    				}
    				if(ComIsNull(formObj.s_cust_nm)){
        				return false;
    				}       					
				}
    			if(ComChkLen(formObj.ob_srep_cd, 5) != 2){
    				ComShowCodeMessage("BKG00044");		
    				return false;    				
    			}
    			if(ComGetObjValue(formObj.carge_detail_pop)!="Y" || checkAutoCaluate(formObj)){
    				resetQtyDetail();
    			}
    			// RD,SOC,EQ SUB Flag Setting
    			setRdSocEqSubFlg(formObj);
    			if(ComGetObjValue(formObj.carge_detail_pop) != "Y"){
	    			if(ComGetObjValue(formObj.rcv_term_cd_old) != "M" && ComGetObjValue(rcv_term_cd) == "M"){
	    				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
	    			}
	    			if(ComGetObjValue(formObj.de_term_cd_old) != "M" && ComGetObjValue(de_term_cd) == "M"){
	    				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
	    			}    			
	    			if(ComGetObjValue(formObj.dcgo_flg_old) != BkgNullToString(ComGetObjValue(formObj.dcgo_flg),"N")){
	    				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
	    			}        	
	    			if(ComGetObjValue(formObj.rc_flg_old) != BkgNullToString(ComGetObjValue(formObj.rc_flg),"N")){
	    				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
	    			}        	
	    			if(ComGetObjValue(formObj.awk_cgo_flg_old) != BkgNullToString(ComGetObjValue(formObj.awk_cgo_flg),"N")){
	    				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
	    			}        	
	    			if(ComGetObjValue(formObj.bb_cgo_flg_old) != BkgNullToString(ComGetObjValue(formObj.bb_cgo_flg),"N")){
	    				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
	    			}        	    
    			}
    			if(ComGetObjValue(formObj.cgo_dtl_auto_flg) != "Y"){
        			if(!checkAutoCaluate(formObj)){
        				ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");
        				comBkgCallPop0890("callBack0890","Y");
        				//ComOpenPopup(url, 1024, 730, "callBack0890",	"1,0,1,1,1", true);
        				return false;
        			}    				
    			}
    			for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow() ; i++){
    				var sumSingle=0;
    				var sumDouble=0;
    				var sumTriple=0;
    				var sumMer=0;
    				var eqSubVol=0;
    				var sumEqDtlVol=0;
    				
    				for(var j=sheetObjects[3].HeaderRows(); j <= sheetObjects[3].LastRow() ; j++){
    					if(sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[3].GetCellValue(j, "cntr_tpsz_cd")){
    						if(sheetObjects[3].GetCellValue(j, "crr_hngr_sgl_bar_use_flg") == 1){
    							sumSingle=sumSingle + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
    						}
    						if(sheetObjects[3].GetCellValue(j, "crr_hngr_dbl_bar_use_flg") == 1){
    							sumDouble=sumDouble + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
    						}
    						if(sheetObjects[3].GetCellValue(j, "crr_hngr_tpl_bar_use_flg") == 1){
    							sumTriple=sumTriple + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
    						}
    						if(sheetObjects[3].GetCellValue(j, "mer_hngr_flg") == 1){
    							sumMer=sumMer + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
    						}				
    						if(sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
    							if(sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd") == sheetObjects[3].GetCellValue(j, "eq_subst_cntr_tpsz_cd")){
    								eqSubVol=eqSubVol + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
    							}    							
    						}	
    						sumEqDtlVol=sumEqDtlVol + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
    						
    						/* Special 선택되어있지 않으면 팝업 오픈 */
    						if(sheetObjects[3].GetCellValue(j, "dry_cgo_flg")==0 && sheetObjects[3].GetCellValue(j, "dcgo_flg")==0 && sheetObjects[3].GetCellValue(j, "rc_flg")==0 && sheetObjects[3].GetCellValue(j, "awk_cgo_flg")==0 && sheetObjects[3].GetCellValue(j, "bb_cgo_flg")==0){
    							sumEqDtlVol = 1000;
    						}
    						
    					}				
    				}    				
    				if(BkgParseFloat(sheetObjects[0].GetCellValue(i, "crr_hngr_sgl_bar_qty")) != sumSingle){
    					ComShowCodeMessage("BKG02007");
    					return false;
    				}
    				if(BkgParseFloat(sheetObjects[0].GetCellValue(i, "crr_hngr_dbl_bar_qty")) != sumDouble){
    					ComShowCodeMessage("BKG02007");
    					return false;
    				}
    				if(BkgParseFloat(sheetObjects[0].GetCellValue(i, "crr_hngr_tpl_bar_qty")) != sumTriple){
    					ComShowCodeMessage("BKG02007");
    					return false;
    				} 
    				if(BkgParseFloat(sheetObjects[0].GetCellValue(i, "mer_hngr_qty")) != sumMer){
    					ComShowCodeMessage("BKG02007");
    					return false;
    				}    			
    				if(BkgParseFloat(sheetObjects[0].GetCellValue(i, "eq_subst_cgo_qty")) != eqSubVol){
    					ComShowCodeMessage("BKG02008", sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
    					return false;    					
    				}
    				
//    				if(BkgParseFloat(sheetObjects[0].GetCellValue(i, "op_cntr_qty")) != sumEqDtlVol){
//    					ComShowCodeMessage("BKG03009", sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"), sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
//    					comBkgCallPop0890("callBack0890","Y");
//    					return false;    					
//    				}    				
    			}		
    			
    			/* */
    			var mainVol = 0;
    			var subVol = 0;
    			for (var i = 0; i < sheetObjects[0].RowCount(); i++) {
    				mainVol = parseFloat(mainVol) + parseFloat(sheetObjects[0].GetCellValue((i+1), 'op_cntr_qty'));
				}
    			for (var i = 0; i < sheetObjects[3].RowCount(); i++) {
    				subVol = parseFloat(subVol) + parseFloat(sheetObjects[3].GetCellValue((i+1), 'op_cntr_qty'));
				}
    			mainVol = mainVol * 100;
    			subVol = subVol * 100;
    			if(parseInt(Math.round(mainVol)) != parseInt(Math.round(subVol))){
    				formObj.btn_EqDetail.click();
    				return false;
    			}
    			
				formObj.partial_vvd_assign_flg.value="N";
    			if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y" && ComGetObjValue(formObj.partial_vvd_opened_flg) != "Y" && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
    				comBkgCallPop1024("callBack1024_save", bkgNo);
    				return false;
    			}
    			if(tpSzA){
    				ComShowCodeMessage("BKG00304");		     	     				
    			}    	
//    			if(delTerm == "S"){
//    				if(rcvTerm == "Y" || rcvTerm == "D" || rcvTerm == "H"){
//    					ComShowCodeMessage("BKG00302");		
//    				}
//    			}
    			if(formObj.rc_flg.checked){
    				if(rcvTerm != "Y" && delTerm != "Y"){
    					ComShowCodeMessage("BKG00303");		
    				}
    			}
    			
    			return true;
				break;                
        	case COMMAND02:      // Copy        		
    			return true;        		
        		break;
        	case MODIFY04:      // Waiting -> Firm        
    			if(ComIsNull(formObj.old_bkg_no)||ComIsNull(formObj.bkg_no)){
    				ComShowCodeMessage("BKG00835");
					ComSetFocus(formObj.bkg_no);
    				return false;    	    				
    			}        		
    			if(ComGetObjValue(formObj.old_bkg_no) != bkgNo){	
    				ComShowCodeMessage("BKG00835");
					ComSetFocus(formObj.bkg_no);
    				return false;    				
    			}        		
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		
    				ComShowCodeMessage("BKG00005");
    				return false;
    			}
    			return true;        		
        		break;        		
        	case MODIFY05:      // Waiting -> Firm        
    			if(ComIsNull(formObj.old_bkg_no)||ComIsNull(formObj.bkg_no)){
    				ComShowCodeMessage("BKG00835");
					ComSetFocus(formObj.bkg_no);
    				return false;    	    				
    			}        		
    			if(formObj.old_bkg_no.value != bkgNo){	
    				ComShowCodeMessage("BKG00835");
					ComSetFocus(formObj.bkg_no);
    				return false;    				
    			}        		
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		
    				ComShowCodeMessage("BKG00005");
    				return false;
    			}
    			return true;        		
        		break;      
        	case MODIFY06:      // cancel        
    			if(ComIsNull(formObj.old_bkg_no)){
    				ComShowCodeMessage("BKG00255");
    				return false;    	    				
    			}        		
    			if(formObj.old_bkg_no.value != bkgNo){	
    				ComShowCodeMessage("BKG00048");
    				return false;    				
    			}        		
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		
    				ComShowCodeMessage("BKG00005");
    				return false;
    			}        		
    			if(ComGetObjValue(formObj.cntr_flg) == "Y"){		
    				if(ComShowCodeConfirm("BKG02054")){
    					return true;
    				}
    			} else {
					if(ComShowCodeConfirm("BKG00670")){
						return true
					}
    			}
    			return false;    		
        		break;    
        }
    }
	function chkReeferDry() {
		var isReturn=true;
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if (sheetObj) {
			with (sheetObj) {
				for (var i=HeaderRows(); i<=RowCount(); i++) {
					if (0==GetCellValue(i,"cntr_tpsz_cd").indexOf("R") && formObj.rc_flg.checked) {
						if (Number(GetCellValue(i,"op_cntr_qty")) > Number(GetCellValue(i,"eq_subst_cgo_qty"))) {
							isReturn=true;
							break;
						} else if (Number(GetCellValue(i,"op_cntr_qty")) == Number(GetCellValue(i,"eq_subst_cgo_qty"))) {
							if("RD"==GetCellValue(i,"rd_cgo_flg")) {
								isReturn=false;  //error
								continue;
							} else {
								isReturn=true;
								break;
							}
						}
					}
				}
			}
		}
		return isReturn;
	}
	//Action In 0079
    function checkModify(){
		var formObj=document.form;
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
			if(ComShowCodeConfirm("BKG00350")){
				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
        		if(validateForm(formObj, COMMAND01)){
					doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
				}
			}
		}	
    }
    //Action In 0079
    function searchData(bkgNo){
    	if(ComIsNull(bkgNo)) return;
		var formObj=document.form;
		ComSetObjValue(formObj.bkg_no,bkgNo);
		ComSetObjValue(formObj.modify_flag,"N");
		doActionIBSheet(sheetObjects[2], formObj, SEARCH);        
    }
     /**
      * Event when clicking Tab
      * activating selected tab items.
      */
     function t1tab1_OnChange(tabObj , nItem){
         var objs=document.all.item("t1tabLayer");
     	objs[nItem].style.display="inline";
     	objs[beforetab].style.display="none";
     	//--------------- important ------------------------------//
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	//--------------------------------------------------------//
     	beforetab=nItem;
     }
	// t1sheet On Search End Event Handling
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){		
		var formObj=document.form;
		if(ErrMsg == ""){
			setTotalVol(sheetObj);
			disabledFH(sheetObj, formObj);
		}
		sheetObj.SetColBackColor("cntr_tpsz_cd","#CCFFFD");
		sheetObj.SetColBackColor("op_cntr_qty","#CCFFFD");
	}
	// t1sheet On After Edit Event Handling
	function t1sheet1_OnAfterEdit(sheetObj, Row, Col){
		var formObj=document.form;
		setTotalVol(sheetObj);
		if(sheetObj.GetCellValue(Row, "ibflag") != "R"){
			ComSetObjValue(formObj.modify_flag, "Y");
			ComSetObjValue(formObj.carge_detail_pop, "N");
			ComSetObjValue(formObj.qty_modify_flag, "Y");
		}
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"||sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
			manageHaveRouteFlag("N");
		}
	}	
	function t1sheet1_OnBeforeEdit(sheetObj, Row, Col, Value){		
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
			befQty=sheetObj.GetCellValue(Row, Col);
		}
	}
	function t1sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		if(KeyCode==9){
			if(Row==sheetObj.LastRow()){
				if(sheetObj.ColSaveName(Col) == "soc_qty"){
					ComSetFocus(document.form.act_wgt);
				}			
			}
		}
	}
	function t1sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj=document.form;
		setTotalVol(sheetObj);
		disabledFH(sheetObj, formObj);
		var tpVol=0;
		var eqSub=0;
		var soc=0;
		if(ComIsNumber(sheetObj.GetCellValue(Row,"op_cntr_qty"), ".")){
			tpVol=parseFloat(sheetObj.GetCellValue(Row,"op_cntr_qty"));
		}
		if(ComIsNumber(sheetObj.GetCellValue(Row,"eq_subst_cgo_qty"), ".")){
			eqSub=parseFloat(sheetObj.GetCellValue(Row,"eq_subst_cgo_qty"));
		}
		if(ComIsNumber(sheetObj.GetCellValue(Row,"soc_qty"), ".")){
			soc=parseFloat(sheetObj.GetCellValue(Row,"soc_qty"));
		}			
		if(tpVol < eqSub){
			ComShowCodeMessage("BKG01007");
			sheetObj.SetCellValue(Row, Col,"",0);
			return;
		}
		if(tpVol < soc){
			ComShowCodeMessage("BKG01008");
			sheetObj.SetCellValue(Row, Col,"",0);
			return;
		}
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
			if(parseFloat(sheetObj.GetCellValue(Row,"op_cntr_qty")) < parseFloat(sheetObj.GetCellValue(Row,"crr_hngr_qty"))+parseFloat(sheetObj.GetCellValue(Row,"mer_hngr_qty"))){
				ComShowCodeMessage("BKG00258");
				//sheetObj.CellValue2(Row, Col) = sheetObj.CellSearchValue(Row, "op_cntr_qty");	
				sheetObj.SetCellValue(Row, Col,befQty,0);
				return;
			}			
		}
		if(sheetObj.GetCellValue(Row,"eq_subst_cntr_tpsz_cd") != "" && (sheetObj.GetCellValue(Row,"cntr_tpsz_cd") == sheetObj.GetCellValue(Row,"eq_subst_cntr_tpsz_cd"))){
			ComShowCodeMessage("BKG02002");
			sheetObj.SetCellValue(Row, Col,"",0);
			return false;
		}
		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "eq_subst_cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "op_cntr_qty" || sheetObj.ColSaveName(Col) == "eq_subst_cgo_qty" || sheetObj.ColSaveName(Col) == "soc_qty"){
			if(sheetObj.GetCellValue(Row, Col) != sheetObj.CellSearchValue(Row, Col)){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
			}else{
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");		
			}			
		}
		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
			checkCntrTpszCd(sheetObj, Row);
		}
		if(!dupChkCntrTpSz()){
			sheetObj.SetCellValue(Row, Col,"");
			return false;
		}
	}		
	//  t3sheet On Save End Event Handling
	function t1sheet3_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg != ""){
			ComBkgSaveCompleted();
		}
	}	
	// RD Term Change
	function rcv_term_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Code){
		var formObj=document.form;
		if(Code != "D"){
			formObj.mty_dor_arr_dt.disabled=true;
			ComSetObjValue(formObj.mty_dor_arr_dt, "");
		}else{
			formObj.mty_dor_arr_dt.disabled=false;
		}		
		ComSetObjValue(formObj.route_modify_flag, "Y");
		ComSetObjValue(formObj.modify_flag, "Y");
	    manageHaveRouteFlag("N");
		ComSetObjValue(formObj.bkg_por_yd_cd, "");
		if(Code == "M"){
			ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
		}
		ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");
	}
	// RD Term Change
	function de_term_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Code){
		var formObj=document.form;
		ComSetObjValue(formObj.route_modify_flag, "Y");
		ComSetObjValue(formObj.modify_flag, "Y");
	    manageHaveRouteFlag("N");
		ComSetObjValue(formObj.bkg_del_yd_cd, "");
		if(Code == "M"){
			ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
		}		
		ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
	}
	
	// Filer USA Change
	function usa_cstms_file_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Code){
		var formObj=document.form;
		if(Text == "1"){
			var befUsaCstmsFileCd=ComGetObjValue(formObj.befUsaCstmsFileCd);
			if(befUsaCstmsFileCd == "2" || befUsaCstmsFileCd == "3"){
				ComShowCodeMessage("BKG00286");
			}
		}
		ComSetObjValue(formObj.modify_flag, "Y");
		ComSetObjValue(formObj.befUsaCstmsFileCd, Text);
	}	
	function usa_cstms_file_cd_OnKeyDown(comboObj,keycode,shift){
		if(keycode == 9) ComSetFocus(ComGetObject("s_cust_cnt_cd"));
	}
	// Filer CA Change
	function cnd_cstms_file_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Code){
		var formObj=document.form;
		ComSetObjValue(formObj.modify_flag, "Y");
	}
	function cnd_cstms_file_cd_OnKeyDown(comboObj,keycode,shift){
		if(keycode == 9) ComSetFocus(ComGetObject("c_cust_seq"));
	}
	// Weight Change
	function wgt_ut_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Code){	
		var formObj=document.form;
		ComSetObjValue(formObj.modify_flag, "Y");
	}	
	// Rail Bulk Change
	function rail_blk_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Code){
		var formObj=document.form;		
		ComSetObjValue(formObj.modify_flag, "Y");		
	}		
	function por_pol_change(formObj){
		if(oldPolYdCd == formObj.bkg_por_cd.value + formObj.bkg_por_yd_cd.value){
			if(!ComIsNull(oldPolYdCd) && !ComIsNull(formObj.bkg_por_yd_cd.value)
					&& oldPolYdCd.trim() != "" && formObj.bkg_por_yd_cd.value.trim() != ""){
				formObj.bkg_por_cd.value=formObj.bkg_pol_cd.value;
				formObj.bkg_por_yd_cd.value=formObj.bkg_pol_yd_cd.value;
			}
		}			
		oldPolYdCd=formObj.bkg_pol_cd.value + formObj.bkg_pol_yd_cd.value;
		tooltipLoad('bkg_por_cd', 'POR', ComGetObjValue(formObj.bkg_por_cd) + ComGetObjValue(formObj.bkg_por_yd_cd));
		tooltipLoad('bkg_pol_cd', 'POL', ComGetObjValue(formObj.bkg_pol_cd) + ComGetObjValue(formObj.bkg_pol_yd_cd));
	}
    function pod_del_change(formObj){
		if(oldPodYdCd == formObj.bkg_del_cd.value + formObj.bkg_del_yd_cd.value){
			if(!ComIsNull(oldPodYdCd) && !ComIsNull(formObj.bkg_del_yd_cd.value)
					&& oldPodYdCd.trim() != "" && formObj.bkg_del_yd_cd.value.trim() != ""){
				formObj.bkg_del_cd.value=formObj.bkg_pod_cd.value;
				formObj.bkg_del_yd_cd.value=formObj.bkg_pod_yd_cd.value;
			}
		}			
		oldPodYdCd=formObj.bkg_pod_cd.value + formObj.bkg_pod_yd_cd.value;
		tooltipLoad('bkg_pod_cd', 'POD', ComGetObjValue(formObj.bkg_pod_cd) + ComGetObjValue(formObj.bkg_pod_yd_cd));
		tooltipLoad('bkg_del_cd', 'DEL', ComGetObjValue(formObj.bkg_del_cd) + ComGetObjValue(formObj.bkg_del_yd_cd));
	}

	 /**
	 * Key Up Event Handling
	 */
    function bkg007901_keyup(){
    	var srcName=ComGetEvent("name");
    	var formObj=document.form;
		if(ComGetEvent("keycode") != 9) return true;
		switch(srcName){
			case "s_cust_cnt_cd":
				ComSetFocus(ComGetObject("rcv_term_cd"));
				break;
			case "act_wgt":
				goFocusQty();			
				break;
			case "scac_cd":
				ComSetFocus(ComGetObject("usa_cstms_file_cd"));
				break;
		}
	}              
	 /**
	 * Mouse Out Event Handling
	 */
    function bkg007901_blur() {
    	var formObj=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=ComGetEvent("maxlength");
    	var srcValue=ComGetEvent("value");
    	if(srcName == "bkg_no"){
			if((!ComIsNull(formObj.old_bkg_no.value)&&ComIsNull(srcValue))
				||(!ComIsNull(formObj.old_bkg_no.value)&&ComGetObjValue(formObj.old_bkg_no) != srcValue)
				){
        		ComSetObjValue(formObj.old_bkg_no,"");
        		ComSetObjValue(formObj.bl_no,     "");
        		ComSetObjValue(formObj.old_bl_no, "");
        		ComSetObjValue(formObj.pctl_no,   "");
        		ComSetObjValue(formObj.si_flg,    "");
        		ComGetObject("split_flg").style.display="none";
        		ComSetObjValue(formObj.partial_vvd_opened_flg, "N");
        		ComSetObjValue(formObj.partial_vvd_assign_flg, "N");
        		ComSetObjValue(formObj.route_modify_flag,"Y");
        		ComSetObjValue(formObj.modify_flag,"Y");
     	    	manageHaveRouteFlag("N");
    		} 
    	} else if(srcName == "bl_no"){
			if((!ComIsNull(formObj.old_bl_no.value)&&ComIsNull(srcValue))
				||(!ComIsNull(formObj.old_bl_no.value)&&ComGetObjValue(formObj.old_bl_no) != srcValue)
				){
				ComSetObjValue(formObj.bkg_no,    "");
        		ComSetObjValue(formObj.old_bkg_no,"");
        		ComSetObjValue(formObj.old_bl_no, "");
        		ComSetObjValue(formObj.pctl_no,   "");
        		ComSetObjValue(formObj.si_flg,    "");
        		ComGetObject("split_flg").style.display="none";
        		ComSetObjValue(formObj.partial_vvd_opened_flg, "N");
        		ComSetObjValue(formObj.partial_vvd_assign_flg, "N");
        		ComSetObjValue(formObj.route_modify_flag,"Y");
        		ComSetObjValue(formObj.modify_flag,"Y");
     	    	manageHaveRouteFlag("N");
    		} 
    	}else if(srcName == "s_cust_cnt_cd"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.s_cust_cnt_cd_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
				if(ComGetObjValue(formObj.s_cust_cnt_cd).length != 2){
					ComSetObjValue(formObj.s_cust_nm,"");					
				}
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.c_cust_cnt_cd))){
					ComSetObjValue(formObj.c_cust_nm,"");
				}
			}
    	}else if(srcName == "s_cust_seq"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.s_cust_seq_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.s_cust_cnt_cd))){
					ComSetObjValue(formObj.s_cust_nm,"");
				}
				if(ComGetObjValue(formObj.s_cust_seq).length == 0){
					ComSetObjValue(formObj.s_cust_nm,"");					
				}
				if(!ComIsNull(srcValue)){
					ComSetObjValue(formObj.s_cust_seq,ComLpad(srcValue,6,"0"));
					if(ComChkLen(formObj.s_cust_cnt_cd, 2) == "2"){
						if(ComGetObjValue(formObj.s_cust_cnt_cd) != ComGetObjValue(formObj.s_cust_cnt_cd_old) 
							|| ComGetObjValue(formObj.s_cust_seq) != ComLpad(ComGetObjValue(formObj.s_cust_seq_old),6,"0")){
							searchCustNm(formObj, ComGetObjValue(formObj.s_cust_cnt_cd), ComGetObjValue(formObj.s_cust_seq), "S");
						}
					}
					if(ComGetObjValue(formObj.s_cust_exist_flg) == "Y"){
						if(ComGetObjValue(formObj.s_cust_cnt_cd) != ComGetObjValue(formObj.s_cust_cnt_cd_old) 
							|| ComGetObjValue(formObj.s_cust_seq) != ComLpad(ComGetObjValue(formObj.s_cust_seq_old),6,"0")){
							if(ComShowCodeConfirm("BKG00343")){
								ComSetObjValue(formObj.s_cust_subst_flg, "Y");
							}else{
								ComSetObjValue(formObj.s_cust_subst_flg, "N");
							}
						}
					}
				}
			} else {
				if(!ComIsNull(ComGetObjValue(formObj.s_cust_seq_old)) && !ComIsNull(ComGetObjValue(formObj.s_cust_cnt_cd))){
//					ComSetObjValue(formObj.s_cust_nm,"");
				}else{
					ComSetObjValue(formObj.s_cust_nm,"");
				}
			}
    	}else if(srcName == "f_cust_cnt_cd"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_cnt_cd_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
				if(ComGetObjValue(formObj.f_cust_cnt_cd).length != 2){
					ComSetObjValue(formObj.f_cust_nm,"");					
				}
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){
					ComSetObjValue(formObj.f_cust_nm,"");
				}
			}
    	}else if(srcName == "f_cust_seq"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_seq_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){
					ComSetObjValue(formObj.f_cust_nm,"");
				}
				if(ComGetObjValue(formObj.f_cust_seq).length == 0){
					ComSetObjValue(formObj.f_cust_nm,"");					
				}
				if(!ComIsNull(srcValue)){
					ComSetObjValue(formObj.f_cust_seq,ComLpad(srcValue,6,"0"));
					if(ComChkLen(formObj.f_cust_cnt_cd, 2) == "2"){
						if(ComGetObjValue(formObj.f_cust_cnt_cd) != ComGetObjValue(formObj.f_cust_cnt_cd_old) 
							|| ComGetObjValue(formObj.f_cust_seq) != ComLpad(ComGetObjValue(formObj.f_cust_seq_old),6,"0")){
							searchCustNm(formObj, ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "F");
						}
					}
					if(ComGetObjValue(formObj.f_cust_exist_flg) == "Y"){
						if(ComGetObjValue(formObj.f_cust_cnt_cd) != ComGetObjValue(formObj.f_cust_cnt_cd_old) 
							|| ComGetObjValue(formObj.f_cust_seq) != ComLpad(ComGetObjValue(formObj.f_cust_seq_old),6,"0")){
							if(ComShowCodeConfirm("BKG00343")){
								ComSetObjValue(formObj.f_cust_subst_flg, "Y");
							}else{
								ComSetObjValue(formObj.f_cust_subst_flg, "N");
							}
						}
					}
		    		if(ComIsNull(formObj.s_cust_nm)){
			    		ComSetObjValue(formObj.s_cust_cnt_cd, ComGetObjValue(formObj.f_cust_cnt_cd));
			    		ComSetObjValue(formObj.s_cust_seq,    ComGetObjValue(formObj.f_cust_seq));
			    		ComSetObjValue(formObj.s_cust_nm,     ComGetObjValue(formObj.f_cust_nm));	    			
		    		}
				}
			}
    	}else if(srcName == "c_cust_cnt_cd"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_cnt_cd_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");	
				if(ComGetObjValue(formObj.c_cust_cnt_cd).length != 2){
					ComSetObjValue(formObj.c_cust_nm,"");					
				}
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.c_cust_cnt_cd))){
					ComSetObjValue(formObj.c_cust_nm,"");
				}
			}
    	}else if(srcName == "c_cust_seq"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.c_cust_seq_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");	
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.c_cust_cnt_cd))){
					ComSetObjValue(formObj.c_cust_nm,"");
				}
				if(ComGetObjValue(formObj.c_cust_seq).length == 0){
					ComSetObjValue(formObj.c_cust_nm,"");					
				}
				if(!ComIsNull(srcValue)){
					ComSetObjValue(formObj.c_cust_seq,ComLpad(srcValue,6,"0"));
					if(ComChkLen(formObj.c_cust_cnt_cd, 2) == "2"){
						if(ComGetObjValue(formObj.c_cust_cnt_cd) != ComGetObjValue(formObj.c_cust_cnt_cd_old) 
							|| ComGetObjValue(formObj.c_cust_seq) != ComLpad(ComGetObjValue(formObj.c_cust_seq_old),6,"0")){
							searchCustNm(formObj, ComGetObjValue(formObj.c_cust_cnt_cd), ComGetObjValue(formObj.c_cust_seq), "C");
						}
					}
					if(ComGetObjValue(formObj.c_cust_exist_flg) == "Y"){
						if(ComGetObjValue(formObj.c_cust_cnt_cd) != ComGetObjValue(formObj.c_cust_cnt_cd_old) 
							|| ComGetObjValue(formObj.c_cust_seq) != ComLpad(ComGetObjValue(formObj.c_cust_seq_old),6,"0")){
							if(ComShowCodeConfirm("BKG00343")){
								ComSetObjValue(formObj.c_cust_subst_flg, "Y");
							}else{
								ComSetObjValue(formObj.c_cust_subst_flg, "N");
							}
						}
					}
				}
			}		
    	}else if(srcName == "bkg_pty_cust_seq"){
    		if(ComGetObjValue(formObj.bkg_pty_cust_seq).length == 0){
				ComSetObjValue(formObj.bkg_pty_cust_nm,"");					
			}
    		if(!ComIsNull(srcValue)){
    			ComSetObjValue(formObj.bkg_pty_cust_seq,ComLpad(srcValue,6,"0"));
    			if(ComChkLen(formObj.bkg_pty_cnt_cd, 2) == "2"){
    				searchCustNm(formObj, ComGetObjValue(formObj.bkg_pty_cnt_cd), ComGetObjValue(formObj.bkg_pty_cust_seq), "P");
    			}
    		}
    	}else if(srcName == "cmdt_cd"){
			if(ComGetObjValue(formObj.cmdt_cd_old) != srcValue){
	    		if(!ComIsNull(srcValue)){
	    			ComSetObjValue(formObj.cmdt_cd, ComLpad(srcValue,6,"0"));
					validatePrecaution(formObj);    		    	
		    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
		    		ComSetObjValue(formObj.modify_flag,"Y");  
	    		} else {
	    			ComSetObjValue(formObj.cmdt_desc,"");
	    			ComSetObjValue(formObj.rep_cmdt_cd,"");
    			}    			
	    		ComSetObjValue(formObj.cmdt_cd_old,ComGetObjValue(formObj.cmdt_cd));
	    		goFocusQty();
    		}
    	}else if(srcName == "mty_dor_arr_dt"){
	    	ComAddSeparator(event.srcElement);
    		if(ComGetObjValue(formObj.mty_dor_arr_dt_old) != ComGetObjValue(formObj.mty_dor_arr_dt)){
    			ComSetObjValue(formObj.modify_flag, "Y");
     	    	formObj.mty_dor_arr_dt_old.value=srcValue;
    		}       
    	}else if(srcName == "lodg_due_dt"){
//	    	ComAddSeparator(event.srcElement);
    		if(ComGetObjValue(formObj.lodg_due_dt_old) != ComGetObjValue(formObj.lodg_due_dt)){
    			ComSetObjValue(formObj.route_modify_flag, "Y");
    			ComSetObjValue(formObj.modify_flag, "Y");
     	    	manageHaveRouteFlag("N");
     	    	formObj.lodg_due_dt_old.value=srcValue;
    		}
    	}else if(srcName == "de_due_dt"){
    		ComAddSeparator(event.srcElement);
			if(ComGetObjValue(formObj.de_due_dt_old) != ComGetObjValue(formObj.de_due_dt)){
				ComSetObjValue(formObj.modify_flag, "Y");
     	    	formObj.de_due_dt_old.value=srcValue;
			}
    		if(srcValue.length > 0 && ComChkPeriod(formObj.lodg_due_dt.value, srcValue) < 1){
    			ComShowCodeMessage("BKG00176");
    			ComSetObjValue(formObj.de_due_dt, "");
    			ComSetFocus(formObj.de_due_dt);
    		}
    	}else if(srcName == "mty_pkup_dt"){
    		if(ComGetObjValue(formObj.mty_pkup_dt_old) != ComGetObjValue(formObj.mty_pkup_dt)){
				ComAddSeparator(event.srcElement);
				ComSetObjValue(formObj.route_modify_flag, "Y");
    			ComSetObjValue(formObj.modify_flag, "Y");
	 	    	manageHaveRouteFlag("N");
    		}
    	}else if(srcName == "act_wgt"){
    		var actWgt=formObj.act_wgt.value.replace(",", "");
    		for(var i=0;actWgt.length;i++){
    			if(actWgt.length==0){
    				break;
    			} else if(actWgt.substring(0, 1)=="0"){
    				actWgt=actWgt.substring(1, actWgt.length);
    			} else {
    				break;
    			}
    		}
    		ComSetObjValue(formObj.act_wgt, makeComma(actWgt));  	
			ComSetObjValue(formObj.modify_flag, "Y");	    		    		
    	}else if(srcName == "bkg_cntc_pson_eml"){
    		if(formObj.bkg_cntc_pson_eml.value.length == 0) return;
    		
    		if(!ComIsEmailAddr(formObj.bkg_cntc_pson_eml.value)){
				ComShowCodeMessage("BKG00366");
				ComSetObjValue(formObj.bkg_cntc_pson_eml, "");
				ComSetFocus(formObj.bkg_cntc_pson_eml);
			}
    	}else if(srcName == "si_cntc_pson_eml"){
    		if(formObj.si_cntc_pson_eml.value.length == 0) return;
    		
    		if(!ComIsEmailAddr(formObj.si_cntc_pson_eml.value)){
				ComShowCodeMessage("BKG00366");
				ComSetObjValue(formObj.si_cntc_pson_eml, "");
				ComSetFocus(formObj.si_cntc_pson_eml);
			}
    	}
    }	

	 /**
	 * Click Event Handling
	 */    
	function bkg007901_click(){
    	var formObj=document.form;
    	var srcName=ComGetEvent("name");
    	if(srcName == "dcgo_flg"||srcName == "rc_flg"||srcName == "awk_cgo_flg"||srcName == "bb_cgo_flg"){
    		ComSetObjValue(formObj.modify_flag,      "Y");
			ComSetObjValue(formObj.carge_detail_pop, "N");   		
    	}else if(srcName == "prct_flg"){
    		if(formObj.prct_flg.checked){
    			ComShowCodeMessage("BKG00256");
    			setPrecaution(formObj, "Y")
    		}else{
    			// BKG00256
    			if(ComGetObjValue(formObj.validPrecaution) == "Y"){
    				ComShowCodeMessage("BKG00256");
    				formObj.prct_flg.checked=true;
    			}else{
    				ComSetObjValue(formObj.modify_flag, "Y");
    			}    			    	
    		}      		
    	}else if(srcName == "si_flg"){
    		if(ComIsNull(formObj.xter_si_cd.value)){
    			formObj.xter_si_cd.value="OFF";
    		}
    		ComSetObjValue(formObj.modify_flag, "Y");    		
    	}else if(srcName == "hot_de_flg"||srcName == "spcl_hide_flg"||srcName == "fd_grd_flg"||
    			srcName == "bkg_cgo_tp_cd"||srcName == "edi_hld_flg"){
    		ComSetObjValue(formObj.modify_flag, "Y");
    	}else if(srcName == "mnl_bkg_no_flg"){
    		ComSetObjValue(formObj.modify_flag, "Y");
    		if(ComIsNull(formObj.mnl_bkg_no_flg.value)||formObj.mnl_bkg_no_flg.value=="N"){
    			formObj.mnl_bkg_no_flg.value="Y";
    		} else {
    			formObj.mnl_bkg_no_flg.value="N";
    		}
    	}
	}
	function form_onChange(evt,el) {
	  	var formObj = document.form;
	  	var xml="";
	  	var srcName;
	  	var srcValue;
	  	if (el) {
	  		srcName=el.getAttribute("name");
	  		srcValue=el.getAttribute("value");
	  	} else {
	  		srcName=ComGetEvent("name");
	  		srcValue=ComGetEvent("value");
	  	}
	  	if(srcName != "bkg_no"){
	  		ComSetObjValue(formObj.modify_flag, "Y");
	  	}
	 	if(srcName == "rfa_no"){
	 		svcScpCd = "";
	 		if(srcValue == "DUM"){
	 			ComSetObjValue(formObj.rfa_no,"DUM0000001");
	 			ComSetObjValue(formObj.ctrt_ofc_cd,ComGetObjValue(formObj.ob_sls_ofc_cd));
	 			ComSetObjValue(formObj.ctrt_srep_cd,ComGetObjValue(formObj.ob_srep_cd));
	 		}else{
	 			if(srcValue.length>=10){
         			// validateRfaAvailable() Call
         			formObj.f_cmd.value=SEARCHLIST12;
         			sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?rfa_no="+srcValue, "f_cmd="+SEARCHLIST12+"&bkg_no="+formObj.bkg_no.value+"&rfa_no="+formObj.rfa_no.value);
     				changeObjectColor(ComGetEtcData(sXml,"rfa_available"), "N", "rfa_no", "red", "input");
     				if(!ComIsNull(formObj.sc_no)  && ComGetObjValue(formObj.sc_no).substring(0,3)  == "DUM") ComSetObjValue(formObj.sc_no, "");
     				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.taa_no, "");	
	 			} else {
     				changeObjectColor("N", "N", "rfa_no", "red", "input");	 				
	 			}
	 		}
	 		
	 		if(srcValue.indexOf("DUM") > -1 || srcValue == ""){
 				clearContractParty();
 			}
			ComSetObjValue(formObj.ctrt_modify_flag,"Y");  
	 		ComSetObjValue(formObj.rfa_no_old,ComGetObjValue(formObj.rfa_no));
	 		
	 		if(srcValue != "" && srcValue.indexOf("DUM") < 0){
    			if(ComGetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd) == ""){
    				var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&rfa_no=" + formObj.rfa_no.value);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, ComGetEtcData(sXml, "cust_cnt_cd"));
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, ComGetEtcData(sXml, "cust_seq"));
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, ComGetEtcData(sXml, "cust_lgl_eng_nm"));
    			}
    		}
	 		
	 	}else if(srcName == "sc_no"){
	 		svcScpCd = "";
	 		if(srcValue == "DUM"){
	 			ComSetObjValue(formObj.sc_no,"DUM000001");
	 			ComSetObjValue(formObj.ctrt_ofc_cd,ComGetObjValue(formObj.ob_sls_ofc_cd));
	 			ComSetObjValue(formObj.ctrt_srep_cd,ComGetObjValue(formObj.ob_srep_cd));
	 			srcValue = formObj.sc_no.value;
	 		}
	 		
 			if(srcValue.length >= 8){
     			// validateScAvailable() Call
     			formObj.f_cmd.value=SEARCHLIST13;
     			sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?sc_no="+srcValue, "f_cmd="+SEARCHLIST13+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+formObj.sc_no.value);
 				changeObjectColor(ComGetEtcData(sXml,"sc_available"), "N", "sc_no", "red", "input");     				
 				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.rfa_no, "");
 				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.taa_no, "");	
 			} else {
 				changeObjectColor("N", "N", "sc_no", "red", "input");	 
 			}
	 	
 			if(srcValue.indexOf("DUM") > -1 || srcValue == ""){
 				clearContractParty();
 			}
			ComSetObjValue(formObj.ctrt_modify_flag,"Y");
			
			if(srcValue != "" && srcValue.indexOf("DUM") < 0){
    			if(formObj.bkg_ctrl_pty_cust_cnt_cd.value == "" && formObj.bkg_ctrl_pty_cust_seq.value == ""){
    				var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&sc_no=" + formObj.sc_no.value);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, ComGetEtcData(sXml, "cust_cnt_cd"));
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, ComGetEtcData(sXml, "cust_seq"));
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, ComGetEtcData(sXml, "cust_lgl_eng_nm"));
    			}
    		}
    	}else if(srcName == "taa_no"){
    		if(srcValue == "DUM"){
    			ComSetObjValue(formObj.taa_no,"DUM0000001");
	 			ComSetObjValue(formObj.ctrt_ofc_cd,ComGetObjValue(formObj.ob_sls_ofc_cd));
	 			ComSetObjValue(formObj.ctrt_srep_cd,ComGetObjValue(formObj.ob_srep_cd));
    		}else if(srcValue.length>=10){
     			// validatetTaaAvailable() Call
     			formObj.f_cmd.value=SEARCH06;
     			sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?taa_no="+srcValue, "f_cmd="+SEARCH06+"&bkg_no="+formObj.bkg_no.value+"&taa_no="+formObj.taa_no.value);
 				changeObjectColor(ComGetEtcData(sXml,"taa_available"), "N", "taa_no", "red", "input"); 				
 				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.rfa_no, "");
 				if(!ComIsNull(formObj.sc_no) && ComGetObjValue(formObj.sc_no).substring(0,3) == "DUM") ComSetObjValue(formObj.sc_no, "");
 			} else {
 				changeObjectColor("N", "N", "taa_no", "red", "input");	 
 			}
    		
    		if(srcValue.indexOf("DUM") > -1 || srcValue == ""){
 				clearContractParty();
 			}
    		ComSetObjValue(formObj.ctrt_modify_flag,"Y"); 
    		
       		if(srcValue != "" && srcValue.indexOf("DUM") < 0){
    			if(formObj.bkg_ctrl_pty_cust_cnt_cd.value == "" && formObj.bkg_ctrl_pty_cust_seq.value == ""){
    				var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&taa_no=" + formObj.taa_no.value);
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, ComGetEtcData(sXml, "cust_cnt_cd"));
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, ComGetEtcData(sXml, "cust_seq"));
    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, ComGetEtcData(sXml, "cust_lgl_eng_nm"));
    			}
    		}
	 	} else if(srcName == "bkg_cntc_pson_nm"||srcName == "bkg_cntc_pson_phn_no"||srcName == "bkg_cntc_pson_eml"||
	 			srcName == "bkg_cntc_pson_mphn_no"||srcName == "bkg_cntc_pson_fax_no"){
	     	ComSetObjValue(formObj.contact_modify_flag, "Y");
	 	}else if(srcName == "si_cntc_pson_nm"||srcName == "si_cntc_pson_phn_no"||srcName == "si_cntc_pson_eml"||
	 			srcName == "si_cntc_pson_mphn_no"||srcName == "si_cntc_pson_fax_no"){
	     	ComSetObjValue(formObj.contact_modify_flag, "Y");
    	// TrunkVvd Check
	 	} else if(srcName == "bkg_trunk_vvd"){
			ComSetObjValue(formObj.route_modify_flag,"Y");
			manageHaveRouteFlag("N");            		
    		if(srcValue.substring(0,4) == "COXX" || srcValue.substring(0,4) == "COYY" || srcValue.substring(0,4) == "COZZ"){
    			ComSetObjValue(formObj.psdo_bkg_flg,"Y");
    		}else{
    			ComSetObjValue(formObj.psdo_bkg_flg,"N");
    		}  
    		var sBkgTrunkVvdOld = ComGetObjValue(formObj.bkg_trunk_vvd_old);
    		for(var i=sheetObjects[1].LastRow()  ; i >= sheetObjects[1].HeaderRows(); i-- ){
    			if(sBkgTrunkVvdOld== sheetObjects[1].GetCellValue(i, "bkg_vvd_cd")){
    				sheetObjects[1].SetCellValue(i, "bkg_vvd_cd",srcValue);
    			}
    		}
        	if(ComIsNull(srcValue)){
	   			sheetObjects[1].RemoveAll();
        	}
			ComSetObjValue(formObj.bkg_pol_yd_cd,"");
			ComSetObjValue(formObj.bkg_pod_yd_cd,"");
	    	por_pol_change(formObj);
 	    	pod_del_change(formObj);
 	    	if(formObj.bkg_sts_cd.value != "" && formObj.bkg_trunk_vvd.value != "" && sBkgTrunkVvdOld != formObj.bkg_trunk_vvd.value){
 	    		if(sheetObjects[1].RowCount() > 1){
 	    			document.getElementById('btn_t1RouteDetail').click();
 	    		} 
 	    	}else{
 	    		tooltipLoad('bkg_trunk_vvd', 'VVD', ComGetObjValue(formObj.bkg_trunk_vvd));
 	    	}
    	}else if(srcName == "bkg_por_cd"){        		
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.bkg_por_yd_cd,"");
 	    	manageHaveRouteFlag("N");
			if(ComIsNull(srcValue)){
	   			sheetObjects[1].RemoveAll();
				clearPrePostRelay(formObj);
			}		        		
			ComSetObjValue(formObj.mty_pkup_yd_cd,"");
			ComSetObjValue(formObj.mty_pkup_dt,   "");
			ComSetObjValue(formObj.full_rtn_yd_cd,"");
			ComSetObjValue(formObj.org_trns_mod_cd, "");
			por_pol_change(formObj);
    	}else if(srcName == "bkg_por_yd_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
 	    	por_pol_change(formObj);
    	}else if(srcName == "bkg_pol_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
			ComSetObjValue(formObj.bkg_pol_yd_cd,"");
 	    	sheetObjects[1].SetCellValue(sheetObjects[1].HeaderRows(),"pol_cd",srcValue);
 	    	sheetObjects[1].SetCellValue(sheetObjects[1].HeaderRows(),"pol_yd_cd","");
			pod_del_change(formObj);
			if(ComIsNull(srcValue)){
	   			sheetObjects[1].RemoveAll();
				clearPrePostRelay(formObj);
			}			
			ComSetObjValue(formObj.mty_pkup_yd_cd,"");
			ComSetObjValue(formObj.mty_pkup_dt,   "");
			ComSetObjValue(formObj.full_rtn_yd_cd,"");
			ComSetObjValue(formObj.org_trns_mod_cd, "");
			por_pol_change(formObj);
    	}else if(srcName == "bkg_pol_yd_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
 	    	if(sheetObjects[1].LastRow()>=1){
 	    		sheetObjects[1].SetCellValue(1,"pol_yd_cd",srcValue);
 	    	}
 	    	por_pol_change(formObj);
    	}else if(srcName == "bkg_pod_cd"){

    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
			ComSetObjValue(formObj.bkg_pod_yd_cd,"");
			sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(),"pod_cd", srcValue);
			sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(),"pod_yd_cd", ""); 
			pod_del_change(formObj);
			if(ComIsNull(srcValue)){
				sheetObjects[1].RemoveAll();
				clearPrePostRelay(formObj);
			}	        			        		
			ComSetObjValue(formObj.dest_trns_mod_cd, "");
			pod_del_change(formObj);
    	}else if(srcName == "bkg_pod_yd_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N"); 	    	
 	    	sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(),"pod_yd_cd",srcValue);  
 	    	pod_del_change(formObj);
    	}else if(srcName == "bkg_del_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
			ComSetObjValue(formObj.bkg_del_yd_cd,"");
 	    	manageHaveRouteFlag("N");
			if(ComGetObjValue(formObj.premium_available_flg) == "Y"&&"USLGB"==srcValue){
//	    		formObj.hot_de_flg.disabled=false; 
			}else{
				formObj.hot_de_flg.checked=false;
	    		formObj.hot_de_flg.disabled=true;   		
	    	} 		        		
        	if(ComIsNull(srcValue)){
        		sheetObjects[1].RemoveAll();
        		clearPrePostRelay(formObj);
        	}
			ComSetObjValue(formObj.dest_trns_mod_cd, "");
			pod_del_change(formObj);
    	}else if(srcName == "bkg_del_yd_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
 	    	pod_del_change(formObj);
    	}else if(srcName == "rep_cmdt_cd"){
    		if(ComIsNull(srcValue)){
    			ComSetObjValue(formObj.cmdt_desc,"");
    		}    		
    	}else if(srcName == "mty_pkup_yd_cd"){
    		formObj.mty_pkup_yd_cd.value = formObj.mty_pkup_yd_cd.value.toUpperCase();
			ComSetObjValue(formObj.route_modify_flag, "Y");
 	    	manageHaveRouteFlag("N");
    	}else if(srcName == "full_rtn_yd_cd"){	
    		formObj.full_rtn_yd_cd.value = formObj.full_rtn_yd_cd.value.toUpperCase();
			ComSetObjValue(formObj.route_modify_flag, "Y");
 	    	manageHaveRouteFlag("N");
    	}else if(srcName == "flex_hgt_flg"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
	 	}
	}	 
    function makeComma(srcValue){
    	var arrVal=srcValue.split(".");
    	if(arrVal.length > 1){
	    	if(arrVal[1].length > 3){
	    		arrVal[1]=arrVal[1].substring(0,3);
	    	}			
			srcValue=makeCommaRun(arrVal[0])+"."+ComRpad(arrVal[1], 3, "0");    		
    	}else{
    		srcValue=makeCommaRun(arrVal[0]) + ".000";
    	}
		return  srcValue;
    }
    function makeCommaUp(srcValue){
    	var arrVal=srcValue.split(".");
    	if(arrVal.length > 1){
	    	if(arrVal[1].length > 3){
	    		arrVal[1]=arrVal[1].substring(0,3);
	    	}			
			srcValue=makeCommaRun(arrVal[0])+"."+arrVal[1];    		
    	}else{
    		srcValue=makeCommaRun(arrVal[0]);
    	}
		return  srcValue;
    }    
    function makeCommaRun(srcValue){    	
    	srcValue=srcValue.replace(/\D/g,"");
    	if(srcValue.length > 9){
    		srcValue=srcValue.substring(0,9);
    	}
		l=srcValue.length-3;
		while(l > 0) {
			srcValue=srcValue.substr(0,l)+","+srcValue.substr(l);
			l-=3;
		}    		
    	return srcValue;
    }
	// Staff Information 
	function msgmove(){
		var obj = document.form.usr_nm;
		var stop = document.body.clientTop + obj.offsetParent.offsetTop + obj.offsetTop + obj.offsetParent.offsetHeight + obj.offsetHeight + 360;
		var sleft = document.body.clientLeft + obj.offsetParent.offsetLeft + obj.offsetLeft + obj.offsetParent.offsetLeft + obj.offsetLeft + 630; 
		msg.style.left = sleft + "px";
		msg.style.top = stop + "px";
	}
	function msgset(strmsg){
		text='<table width=240 bgcolor=#FFFFCC style="border:1 black solid; font-family: Tahoma, Arial, dotum, gulim; font-size: 12px;"><tr><td>' + strmsg + '</td></tr></table>';
		msg.innerHTML = text;
	}
	function msghide(){
//		msg.innerHTML='';
	}	
	// BlNo Information 
	function blNoSet(){
		var obj=document.form.bl_no;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+5	;
		var sleft=document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetLeft+7; 
		var obj1 = $("#bl_no").offset();
		$("#orgBlNo").css({
			   "position" : "absolute",
			   "top" : (obj1.top  + 28) +"px",
			   "left" : obj1.left + "px"
			});
//		orgBlNo.style.left=sleft;
//		orgBlNo.style.top=stop;	
		var strMsg=document.form.orgBlNo.value;
		if(strMsg != ""){
			var text = '<table width=130  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;">'; 
			text += '<tbody><tr>'; 
			text += '<td id="ContainerList"><select name="" size="5" multiple="">'; 
			text += '<option value="' + strMsg + '">' + strMsg + '</option>'; 
			text += '</select>'; 
			text += '</td>'; 
			text += '</tr>'; 
			text += '</tbody></table>'; 
//			text='<table  width=115  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strMsg + '</td></tr></table>';
			orgBlNo.innerHTML=text;
		}
	}
	function blNoHide(){
		orgBlNo.innerHTML='';
	}		
    /**
     * precaution info Retrieve
     */       
    function validatePrecaution(formObj){
    	formObj.f_cmd.value=SEARCHLIST11;
    	var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCHLIST11+"&cmdt_cd="+formObj.cmdt_cd.value);
		sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
		ComSetObjValue(formObj.rep_cmdt_cd, ComGetEtcData(sXml,"rep_cmdt_cd"));		
		ComSetObjValue(formObj.cmdt_desc, ComGetEtcData(sXml,"cmdt_nm"));
		setPrecaution(formObj, ComGetEtcData(sXml,"rep_imdg_lvl_cd"));
		ComSetObjValue(formObj.validPrecaution, "Y");
    }    
    function setPrecaution(formObj, precaution){		
		if(precaution == "P"){
			var isChecked=true;
			if(formObj.dcgo_flg.checked || formObj.rc_flg.checked || formObj.awk_cgo_flg.checked || formObj.bb_cgo_flg.checked){
				isChecked=false;
			}
			var isSoc=true;
			for ( i=1 ; i <= sheetObjects[0].LastRow() ; i++ ){				
				if(sheetObjects[0].GetCellValue(i, "soc_qty" ) != "" && sheetObjects[0].GetCellValue(i, "soc_qty" ) > 0){
					isSoc=false;
					break;
				}
			}				
			if(isChecked && isSoc){
				ComShowCodeMessage("BKG00256");
			}				
			formObj.prct_flg.checked=true;				
		}    	
    }

  	function checkNigeriaCmdt(podCd, delCd){
  		if(podCd.substring(0, 2)=="NG"||delCd.substring(0, 2)=="NG"){
  			if(ComShowConfirm(ComGetMsg("BKG02051"))) {
  				ComOpenWindow("http://www.customs.gov.ng/ProhibitionList/import.php", "", "", false);
  			}
  		}
  	}
	// Total Volumen print
	function setTotalVol(sheetObj){
		var totalVol = "";
		for(i=1 ; i <= sheetObj.LastRow() ; i++){
			// RD setting
			setRdCgoFlg(sheetObj, i);
			// Total Volumn
			if(i > 1){
				totalVol=totalVol + "," + sheetObj.GetCellValue(i, "cntr_tpsz_cd") + "X" + sheetObj.GetCellValue(i, "op_cntr_qty");
			}else{
				totalVol=sheetObj.GetCellValue(i, "cntr_tpsz_cd") + "X" + sheetObj.GetCellValue(i, "op_cntr_qty");
			}
		}
		ComSetObjValue(document.form.total_vol, totalVol);		
	}
	function chkCntrTpSz(){
		if(sheetObjects[0].FindText("cntr_tpsz_cd","",-1) > 0){
			ComShowCodeMessage("BKG01013");		
			return false;    				
		}
		return dupChkCntrTpSz();
	}
    function dupChkCntrTpSz(){
		var dupCntrTp = sheetObjects[0].ColValueDupRows("cntr_tpsz_cd", false, true);
		if (dupCntrTp != null && dupCntrTp != "") {	
			ComShowCodeMessage("BKG00038",sheetObjects[0].GetCellValue(dupCntrTp.split("|")[0],"cntr_tpsz_cd"));
			return false;    	        	  
		}     
		return true;
    }
	// RD,SOC,EQ SUB Flag Setting //저장될 flag setting
     function setRdSocEqSubFlg(formObj){
    	 var rdCnt=0;
    	 var socCnt=0;
    	 var eqCnt=0;
    	 for(i=1 ; i <= sheetObjects[0].LastRow() ; i++){
    		 if(sheetObjects[0].GetCellValue(i, "rd_cgo_flg") == "RD"){
				rdCnt++;
			}
    		 if(sheetObjects[0].GetCellValue(i, "soc_qty") != "" && sheetObjects[0].GetCellValue(i, "soc_qty" ) > 0){
				socCnt++;
			}    		
    		 if(sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
				eqCnt++;
			}    	    				
    	 }    			
		 if(rdCnt > 0){
			ComSetObjValue(formObj.rd_cgo_flg, "Y");    				
		 }else{
			ComSetObjValue(formObj.rd_cgo_flg, "N");
		 }
		 if(socCnt > 0){
			ComSetObjValue(formObj.soc_flg, "Y");    				
		 }else{
			ComSetObjValue(formObj.soc_flg, "N");
		 }
		 if(eqCnt > 0){
			ComSetObjValue(formObj.eq_subst_flg, "Y");    				
		 }else{
			ComSetObjValue(formObj.eq_subst_flg, "N");
		 }    	    	 
     }
	// RD Cgo print
	function setRdCgoFlg(sheetObj, Row){
		var isChange=false;
		if(sheetObj.GetCellValue(Row, "cntr_tpsz_cd") != "" && sheetObj.GetCellValue(Row, "eq_subst_cntr_tpsz_cd") != ""){
			var cntrTpszCd=sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
			var eqTpszCd=sheetObj.GetCellValue(Row, "eq_subst_cntr_tpsz_cd");
			if(cntrTpszCd == "R2" || cntrTpszCd == "R4" || cntrTpszCd == "R5"){
				if(eqTpszCd == "D2" || eqTpszCd == "D4" || eqTpszCd == "D5"){
					isChange=true;						
				}
			}
		}
		if(isChange){
			sheetObj.SetCellValue(Row, "rd_cgo_flg","RD",0);
			sheetObj.SetColFontColor("rd_cgo_flg","#FF00FF");
		}else{
			sheetObj.SetCellValue(Row, "rd_cgo_flg","",0);
			//sheetObj.ColFontColor("rd_cgo_flg") = "#FFFFFF";				
		}		
	}
	// Flexible Height
	function disabledFH(sheetObj, formObj){
		var isDisAble=true;
		for(i=1 ; i <= sheetObj.LastRow() ; i++){
			if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D4" || sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D5"){
				isDisAble=false;
				break;
			}
		}		
		formObj.flex_hgt_flg.disabled=isDisAble;
		if(isDisAble==true){
			formObj.flex_hgt_flg.checked=false;
		}
	}
	// Auto Calculate
	function checkAutoCaluate(formObj){
		var autoCalCnt=0;
		var rfCnt=0;
		var sheetObj=sheetObjects[0];
		var awkCnt=0;		
		if(ComGetObjValue(formObj.dcgo_flg) == "Y" && sheetObjects[3].RowCount()> 1){
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
				cntrTpSz=sheetObj.GetCellValue(i, "cntr_tpsz_cd");
				drdgCnt=0;
				for(var k=sheetObjects[3].HeaderRows(); k <= sheetObjects[3].LastRow() ; k++){
					if(sheetObjects[3].GetCellValue(k, "dry_cgo_flg") == 1){
							drdgCnt=drdgCnt+1;
						}
					if(sheetObjects[3].GetCellValue(k, "dcgo_flg") == 1){
							drdgCnt=drdgCnt+1;
						}						
				}
				if(drdgCnt > 1){
					return false;
				}							
			}
		}
		// Hanger Value Exist,
		if(ComGetObjValue(formObj.hngr_flg) == "Y"){
			for(var i=sheetObj.HeaderRows(); i < sheetObj.HeaderRows()+sheetObj.RowCount() ; i++){
				if(ComIsNumber(sheetObj.GetCellValue(i,"eq_subst_cgo_qty"), ".") && parseFloat(sheetObj.GetCellValue(i,"eq_subst_cgo_qty")) > 0){
					if(parseFloat(sheetObj.GetCellValue(i,"op_cntr_qty")) !=  parseFloat(sheetObj.GetCellValue(i,"eq_subst_cgo_qty"))){
						return false;
					}
				}				
				if(ComIsNumber(sheetObj.GetCellValue(i,"soc_qty"), ".") && parseFloat(sheetObj.GetCellValue(i,"soc_qty")) > 0){
					if(parseFloat(sheetObj.GetCellValue(i,"op_cntr_qty")) !=  parseFloat(sheetObj.GetCellValue(i,"soc_qty"))){
						return false;
					}
				}		
				if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
					if(parseFloat(sheetObj.GetCellValue(i,"op_cntr_qty")) == (parseFloat(sheetObj.GetCellValue(i,"crr_hngr_qty"))+parseFloat(sheetObj.GetCellValue(i,"mer_hngr_qty")))){
						return false;
					}
				}				
			}
		}
		// Special Cargo Check 
		if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
			autoCalCnt++;
		}
		if(ComGetObjValue(formObj.rc_flg) == "Y"){
			rfCnt++;
		}
		if(ComGetObjValue(formObj.awk_cgo_flg) == "Y"){
			autoCalCnt++;
			awkCnt++;
		}
		if(ComGetObjValue(formObj.bb_cgo_flg) == "Y"){
			autoCalCnt++;
		}	
		//awkward Exist,
		if(awkCnt>0){
			var dryCnt=0;
			for(var i=sheetObj.HeaderRows(); i <= sheetObjects[0].LastRow() ; i++){
				if(sheetObj.GetCellValue(i, "cntr_tpsz_cd").substring(0,1)=="D"){
					dryCnt++;
				}
			}			
			if(dryCnt>0){
				autoCalCnt++;
			}
		}
		// EQ Sub, SOC, RD Check
		var eqSubCnt=0;	
		var socCnt=0;		
		var rdCnt=0;
		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++){
			if(eqSubCnt < 1){
				if(sheetObj.GetCellValue(i,"eq_subst_cntr_tpsz_cd") != "" && sheetObj.GetCellValue(i,"rd_cgo_flg") == ""){
					if(ComIsNumber(sheetObj.GetCellValue(i,"eq_subst_cgo_qty"), ".") && parseFloat(sheetObj.GetCellValue(i,"eq_subst_cgo_qty")) > 0){
						if(parseFloat(sheetObj.GetCellValue(i,"op_cntr_qty")) !=  parseFloat(sheetObj.GetCellValue(i,"eq_subst_cgo_qty"))){
							eqSubCnt++;
						}
					}					
				}				
			}			
			if(socCnt < 1){
				if(ComIsNumber(sheetObj.GetCellValue(i,"soc_qty"), ".") && parseFloat(sheetObj.GetCellValue(i,"soc_qty")) > 0){
					if(parseFloat(sheetObj.GetCellValue(i,"op_cntr_qty")) !=  parseFloat(sheetObj.GetCellValue(i,"soc_qty"))){
						socCnt++;
					}
				}			
			}	
			if(rdCnt < 1){
				if(sheetObj.GetCellValue(i,"rd_cgo_flg") != ""){
					rdCnt++;
				}				
			}					
		}		
		// R/D Term Validation
		if(ComGetObjValue(rcv_term_cd) == "M" || ComGetObjValue(de_term_cd) == "M"){
			autoCalCnt=autoCalCnt + 2;;
		}
		if(autoCalCnt+eqSubCnt+socCnt+rfCnt+rdCnt > 1){
			if(autoCalCnt+eqSubCnt+socCnt < 1){
				return true;
			}else{
				if(autoCalCnt+rfCnt+rdCnt == 0 && eqSubCnt+socCnt == 2){
					return true;
				}else{
					return false;
				}
			}			
		}else{
			return true;
		}
	}
   function resetQtyDetail(){
	   var formObj=document.form;
	   if(checkAutoCaluate(formObj)){
		   var qtyDtlRow;
		   sheetObjects[3].RemoveAll();
		   for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].RowCount() ; i++ ){
			   cntrQty=sheetObjects[0].GetCellValue(i, "op_cntr_qty");
			   eqSubSameQty=false;
			   socSameQty=false;
			   if(sheetObjects[0].GetCellValue(i, "eq_subst_cgo_qty") > 0){
				   if(sheetObjects[0].GetCellValue(i, "op_cntr_qty") == sheetObjects[0].GetCellValue(i, "eq_subst_cgo_qty")){
					   eqSubSameQty=true;
					   existEqSub=false;
				   }else{
					   existEqSub=true;
				   }
			   }else{
				   existEqSub=false;
			   }
			   if(sheetObjects[0].GetCellValue(i, "soc_qty") > 0){
				   if(sheetObjects[0].GetCellValue(i, "op_cntr_qty") == sheetObjects[0].GetCellValue(i, "soc_qty")){
					   socSameQty=true;
				   }
			   }
			   if(existEqSub){
				   cntrQty=cntrQty-sheetObjects[0].GetCellValue(i, "eq_subst_cgo_qty");
				   qtyDtlRow=sheetObjects[3].DataInsert(-1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[0].GetCellValue(i, "eq_subst_cgo_qty"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(de_term_cd));
				   if(isVolDetailAutoChk()){
					   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, sheetObjects[0].GetCellValue(i, "rd_cgo_flg"), sheetObjects[0], "N");
				   }
			   }
			   if(sheetObjects[0].GetCellValue(i, "soc_qty") > 0 && sheetObjects[0].GetCellValue(i, "op_cntr_qty") != sheetObjects[0].GetCellValue(i, "soc_qty")){
				   existSocQty=true;
			   }else{
				   existSocQty=false;
			   }			   
			   if(existSocQty){
				   cntrQty=cntrQty-sheetObjects[0].GetCellValue(i, "soc_qty");
				   qtyDtlRow=sheetObjects[3].DataInsert(-1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "soc_flg",1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[0].GetCellValue(i, "soc_qty"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(de_term_cd));
				   if(isVolDetailAutoChk()){
					   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "N");
				   }
			   }			   
			   if( sheetObjects[0].GetCellValue(i, "crr_hngr_sgl_bar_qty") > 0){
				   cntrQty=cntrQty-sheetObjects[0].GetCellValue(i, "crr_hngr_sgl_bar_qty");
				   qtyDtlRow=sheetObjects[3].DataInsert(-1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg",1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[0].GetCellValue(i, "crr_hngr_sgl_bar_qty"));
				   if(eqSubSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
				   }				
				   if(socSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "soc_flg",1);
				   }						   
				   sheetObjects[3].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(de_term_cd));
				   if(isVolDetailAutoChk()){
					   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "Y");
				   }
			   }
			   if( sheetObjects[0].GetCellValue(i, "crr_hngr_dbl_bar_qty") > 0){
				   cntrQty=cntrQty-sheetObjects[0].GetCellValue(i, "crr_hngr_dbl_bar_qty");
				   qtyDtlRow=sheetObjects[3].DataInsert(-1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg",1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[0].GetCellValue(i, "crr_hngr_dbl_bar_qty"));
				   if(eqSubSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
				   }						  
				   if(socSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "soc_flg",1);
				   }					   
				   sheetObjects[3].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(de_term_cd));
				   if(isVolDetailAutoChk()){
					   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "Y");
				   }
			   }				
			   if( sheetObjects[0].GetCellValue(i, "crr_hngr_tpl_bar_qty") > 0){
				   cntrQty=cntrQty-sheetObjects[0].GetCellValue(i, "crr_hngr_tpl_bar_qty");
				   qtyDtlRow=sheetObjects[3].DataInsert(-1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg",1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[0].GetCellValue(i, "crr_hngr_tpl_bar_qty"));
				   if(eqSubSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
				   }				
				   if(socSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "soc_flg",1);
				   }					   
				   sheetObjects[3].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(de_term_cd));
				   if(isVolDetailAutoChk()){
					   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "Y");
				   }
			   }			
			   if( sheetObjects[0].GetCellValue(i, "mer_hngr_qty") > 0){
				   cntrQty=cntrQty-sheetObjects[0].GetCellValue(i, "mer_hngr_qty");
				   qtyDtlRow=sheetObjects[3].DataInsert(-1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "mer_hngr_flg",1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "op_cntr_qty",sheetObjects[0].GetCellValue(i, "mer_hngr_qty"));
				   if(eqSubSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
				   }						   
				   if(socSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "soc_flg",1);
				   }					   
				   sheetObjects[3].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(de_term_cd));
				   if(isVolDetailAutoChk()){
					   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "Y");
				   }
			   }	
			   
			   if(cntrQty > 0 || sheetObjects[3].RowCount() == 0){		
				   qtyDtlRow=sheetObjects[3].DataInsert(-1);
				   sheetObjects[3].SetCellValue(qtyDtlRow, "cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "op_cntr_qty",cntrQty);
				   if(eqSubSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd",sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd"));
				   }			
				   if(socSameQty){
					   sheetObjects[3].SetCellValue(qtyDtlRow, "soc_flg",1);
				   }					   
				   sheetObjects[3].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd));
				   sheetObjects[3].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(de_term_cd));
				   if(isVolDetailAutoChk()){
					   var rd_cgo_flg = sheetObjects[3].GetCellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd");
					   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, rd_cgo_flg, sheetObjects[0], "N");
				   }
			   }
		   }
	   }else{
	   }
   }   
    /**
     * CA Referesh call<br>
     */ 
    function CARefresh() {
    }
     /**
      *Route Flag Change Event Handling<br>
      */      
     function manageHaveRouteFlag(haveRouteFlg){
    	 var formObj=document.form;
    	 ComSetObjValue(formObj.have_route_flag, haveRouteFlg);
    	 if (haveRouteFlg == "N"){
    		 ComSetObjValue(formObj.pctl_no, "");
     		changeObjectColor("Y", "Y", "btn_t1Save", "red", "btn2");    			
 		 } else {		 
     		changeObjectColor("Y", "Y", "btn_t1Save", "black", "btn2");
    	 }
     }
   // Booking Creation Screen Button Control
      function btn007901Control(isEnable, btnName){
      	if(isEnable){
      		ComBtnEnable(btnName);
      	}else{
      		ComBtnDisable(btnName);
      	}
      }
     function setInquiryDisableButton(){
    	 btn007901Control(false, "btn_t1Save");    	 
    	 changeObjectColor("Y", "Y", "btn_t1Save", "#c0c0c0", "btn1");		
    	 btn007901Control(false, "btn_t1BKGCancel");
    	 btn007901Control(false, "btn_t1Copy");
    	 btn007901Control(false, "btn_t1Split");
		 btn007901Control(false, "btn_t1Holding");						
		 btn007901Control(false, "btn_t1Waiting");	    	 
     }
     function clearPrePostRelay(formObj){
 		ComSetObjValue(formObj.pre_rly_port_cd,		"");
		ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
		ComSetObjValue(formObj.pre_vvd_cd, 			"");
		ComSetObjValue(formObj.pst_rly_port_cd,		"");
		ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
		ComSetObjValue(formObj.pst_vvd_cd, 			"");    	 
     }
     // Editable Handling
     function setBookingEditable(isEnable){
    	 var formObj=document.form;
    	 BkgEnableObject(formObj.mnl_bkg_no_flg, isEnable);
//    	 BkgEnableObject(formObj.bkg_trunk_vvd, isEnable);
    	 BkgEnableObject(formObj.bkg_por_cd, 	isEnable);
    	 BkgEnableObject(formObj.bkg_por_yd_cd, isEnable);
    	 if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "Y"){
        	 BkgEnableObject(formObj.bkg_pol_cd,	false);
        	 BkgEnableObject(formObj.bkg_pol_yd_cd, false);
        	 if(formObj.bkg_pod_cd.value.substring(0, 2)==formObj.usr_cnt_cd.value){
        	 } else {
        	 }
    	 }else{
        	 BkgEnableObject(formObj.bkg_pol_cd, 	isEnable);
        	 BkgEnableObject(formObj.bkg_pol_yd_cd, isEnable);
        	 BkgEnableObject(formObj.bkg_pod_cd, 	isEnable);
        	 BkgEnableObject(formObj.bkg_pod_yd_cd, isEnable);
    	 }
    	 BkgEnableObject(formObj.bkg_del_cd, 	isEnable);
    	 BkgEnableObject(formObj.bkg_del_yd_cd, isEnable);
    	 BkgEnableObject(formObj.s_cust_cnt_cd, isEnable);
    	 BkgEnableObject(formObj.s_cust_seq, 	isEnable);
    	 BkgEnableObject(formObj.scac_cd, 		isEnable);
    	 BkgEnableObject(formObj.f_cust_cnt_cd, isEnable);
    	 BkgEnableObject(formObj.f_cust_seq, 	isEnable);
    	 BkgEnableObject(formObj.rfa_no, 		isEnable);
    	 BkgEnableObject(formObj.taa_no, 		isEnable);
    	 BkgEnableObject(formObj.c_cust_cnt_cd, isEnable);
    	 BkgEnableObject(formObj.c_cust_seq, 	isEnable);
    	 BkgEnableObject(formObj.sc_no, 		isEnable);
    	 BkgEnableObject(formObj.cmdt_cd, 		isEnable);
    	 sheetObjects[0].SetEditable(isEnable);
    	 if(!isEnable){
    		 BkgEnableObject(formObj.flex_hgt_flg, 	isEnable);
    	 } else {
    		 disabledFH(sheetObjects[0], formObj);
    	 }
    	 BkgEnableObject(formObj.act_wgt, 		isEnable);
    	 BkgEnableObject(formObj.prct_flg, 		isEnable);
    	 BkgEnableObject(formObj.twn_so_no, 	isEnable);
    	 BkgEnableObject(formObj.ocp_cd, 		isEnable);
    	 BkgEnableObject(formObj.spcl_hide_flg, isEnable);
    	 if(!isEnable){
        	 BkgEnableObject(formObj.hot_de_flg, 	 isEnable);
        	 BkgEnableObject(formObj.mty_dor_arr_dt, isEnable);
    	 }   
    	 BkgEnableObject(formObj.fd_grd_flg, 	isEnable);
    	 BkgEnableObject(formObj.bkg_cgo_tp_cd, isEnable);
    	 BkgEnableObject(formObj.lodg_due_dt, 	isEnable);
    	 BkgEnableObject(formObj.de_due_dt, 	isEnable);
    	 BkgEnableObject(formObj.mty_pkup_yd_cd,isEnable);
    	 BkgEnableObject(formObj.mty_pkup_dt,	isEnable);
    	 BkgEnableObject(formObj.full_rtn_yd_cd,isEnable);
    	 rcv_term_cd.SetEnable(isEnable);
    	 de_term_cd.SetEnable(isEnable);
    	 usa_cstms_file_cd.SetEnable(isEnable);
    	 cnd_cstms_file_cd.SetEnable(isEnable);
    	 wgt_ut_cd.SetEnable(isEnable);
    	 rail_blk_cd.SetEnable(isEnable);
    	 btn007901Control(isEnable, "btn_t1RowAdd");
    	 btn007901Control(isEnable, "btn_t1Delete");
    	 btn007901Control(isEnable, "btn_t1BKGCancel");
    	 btn007901Control(isEnable, "btn_t1Holding");
    	 btn007901Control(isEnable, "btn_t1Waiting");
		 if(ComGetObjValue(formObj.ca_flg) == "Y"){
			 btn007901Control(false, "btn_t1Split");
		 }else{
			 btn007901Control(true, "btn_t1Split");
		 }
		 ComGetObject("btn_t1RmkSave").style.display = "none";
    	 if(!isEnable){
        	 BkgEnableObject(formObj.dcgo_flg,    isEnable);
        	 BkgEnableObject(formObj.rc_flg,      isEnable);
        	 BkgEnableObject(formObj.awk_cgo_flg, isEnable);
        	 BkgEnableObject(formObj.bb_cgo_flg,  isEnable);
    	 }else{
			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){
				ComGetObject("btn_t1RmkSave").style.display = "inline";
				btn007901Control(false, "btn_t1Save");
				changeObjectColor("Y", "Y", "btn_t1Save", "#c0c0c0", "btn1");	
				btn007901Control(false, "btn_t1Holding");						
				btn007901Control(false, "btn_t1Waiting");	
			}else if(ComGetObjValue(formObj.bkg_sts_cd) == "S"){
				btn007901Control(false, "btn_t1Holding");						
				btn007901Control(false, "btn_t1Waiting");		
			}else if(ComGetObjValue(formObj.bkg_sts_cd) != "F" && ComGetObjValue(formObj.bkg_sts_cd) != "W"){
				btn007901Control(false, "btn_t1Holding");
				btn007901Control(false, "btn_t1Waiting");							
			}else{
				btn007901Control(true, "btn_t1Save");
				if(ComGetObjValue(formObj.have_route_flag)=="Y"){
					changeObjectColor("Y", "Y", "btn_t1Save", "black", "btn1");
				}
				btn007901Control(true, "btn_t1BKGCancel");
				btn007901Control(true, "btn_t1Holding");						
				btn007901Control(true, "btn_t1Waiting");		
			}
			btn007901Control(true, "btn_t1Copy"); 
			ComGetObject("bkg_por_cd").className="input1";
			ComGetObject("bkg_del_cd").className="input1";
			ComGetObject("s_cust_cnt_cd").className="input1";
			ComGetObject("s_cust_seq").className="input1";
			ComGetObject("f_cust_cnt_cd").className="input1";
			ComGetObject("f_cust_seq").className="input1";
			ComGetObject("rfa_no").className="input1";
			ComGetObject("sc_no").className="input1";
			ComGetObject("taa_no").className="input1";
			ComGetObject("cmdt_cd").className="input1";			
			ComGetObject("act_wgt").className="input1";
			ComGetObject("lodg_due_dt").className="input1";
    	 }
     }
    // TAA No, RFA No Check
	function chkTaaRfa(val){
		var formObj = document.form;
		if(val == 'T'){
			formObj.rfa_no.value = "";
			document.all.item("taaNoDiv").style.display="inline";
			document.all.item("rfaNoDiv").style.display="none";
			
		}else{
			document.all.item("taaNoDiv").style.display="none";
			document.all.item("rfaNoDiv").style.display="inline";	
			formObj.taa_no.value = "";
		}
	}	     
	
    function searchCustNm(formObj, custCntCd, custSeq, custTp){
    	if (isNaN(custSeq) || !$.isNumeric(custSeq)) {
    		ComShowMessage("[" + custSeq + "] is not a number");
    		if(formObj.s_cust_seq.value ==  custSeq){
    			formObj.s_cust_seq.value = "";
    			ComSetFocus(formObj.s_cust_seq);
    		}else if(formObj.c_cust_seq.value ==  custSeq){
    			formObj.c_cust_seq.value = "";
    			ComSetFocus(formObj.c_cust_seq);
    		}else if(formObj.f_cust_seq.value ==  custSeq){
    			formObj.f_cust_seq.value = "";
    			ComSetFocus(formObj.f_cust_seq);
    		}
    	}else{
    		formObj.f_cmd.value=SEARCHLIST14;
    		var param="f_cmd="+ SEARCHLIST14 + "&cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq;
    		var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0079_01GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq, param);
    		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" && ComGetEtcData(sXml,"cust_nm") != ""){
    			if(custTp == "S"){
    				ComSetObjValue(formObj.s_cust_nm,ComGetEtcData(sXml,"cust_nm"));
    			}else if(custTp == "C"){
    				ComSetObjValue(formObj.c_cust_nm,ComGetEtcData(sXml,"cust_nm"));
    			}else if(custTp == "P"){
    				ComSetObjValue(formObj.bkg_pty_cust_nm,ComGetEtcData(sXml,"cust_nm"));
    			}else{
    				ComSetObjValue(formObj.f_cust_nm,ComGetEtcData(sXml,"cust_nm"));
    				ComSetObjValue(formObj.fmc_no,ComGetEtcData(sXml,"fmc_cd"));
    			}			
    		}else{
    			ComShowMessage("invalid cunstomer code.");
    			if(custTp == "S"){
    				ComSetObjValue(formObj.s_cust_nm,"");
    				ComSetObjValue(formObj.s_cust_cnt_cd,"");
    				ComSetObjValue(formObj.s_cust_seq,"");
    				ComSetFocus(formObj.s_cust_cnt_cd);
    			}else if(custTp == "C"){
    				ComSetObjValue(formObj.c_cust_cnt_cd,"");
    				ComSetObjValue(formObj.c_cust_seq,"");
    				ComSetObjValue(formObj.c_cust_nm,"");
    				ComSetFocus(formObj.c_cust_cnt_cd);
    			}else if(custTp == "P"){
    				ComSetObjValue(formObj.bkg_pty_cust_nm,"");
    				ComSetObjValue(formObj.bkg_pty_cnt_cd,"");
    				ComSetObjValue(formObj.bkg_pty_cust_seq,"");
    				ComSetFocus(formObj.bkg_pty_cnt_cd);
    			}else{
    				ComSetObjValue(formObj.f_cust_nm,"");
    				ComSetObjValue(formObj.f_cust_seq,"");
    				ComSetObjValue(formObj.f_cust_cnt_cd,"");
    				ComSetFocus(formObj.f_cust_cnt_cd);
    			}
    		}		
    	}
    	return;
    }
    
    function goFocusQty(){
    	var formObj=document.form;
    	var have_route_flag=formObj.have_route_flag.value;
    	ComSetFocus(sheetObjects[0]);    	
    	if(sheetObjects[0].LastRow()==0){
	    	var nRow=sheetObjects[0].DataInsert(-1);
			sheetObjects[0].SelectCell(nRow, "op_cntr_qty");
		} else {
			sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(), "op_cntr_qty");
		}    	
		formObj.have_route_flag.value=have_route_flag;
    }
    /**
     * Save Value that recevied data from MT PickUp CY Inquiry
     */
    function callBack0019(rArray){    	
    	var formObj=document.form;
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	    	if(rArray != null){
	    		ComSetObjValue(formObj.bkg_trunk_vvd,rArray[0][3]);
	    		ComSetObjValue(formObj.bkg_pol_yd_cd,"");
	    		ComSetObjValue(formObj.bkg_pod_yd_cd,"");
	    		por_pol_change(formObj);
	    		pod_del_change(formObj);
	    		ComSetObjValue(formObj.route_modify_flag, "Y");
	    		ComSetObjValue(formObj.modify_flag, "Y");
	    		manageHaveRouteFlag("N");
	    		if(rArray[0][3].substring(0,4) == "COXX" || rArray[0][3].substring(0,4) == "COYY" || rArray[0][3].substring(0,4) == "COZZ"){
	    			ComSetObjValue(formObj.psdo_bkg_flg, "Y");
	    		}else{
	    			ComSetObjValue(formObj.psdo_bkg_flg, "N");
	    		}    		
				if(sheetObjects[1].RowCount()== 1){
					sheetObjects[1].SetCellValue(1, "vsl_pre_pst_cd","T");
					sheetObjects[1].SetCellValue(1, "vsl_seq","0");
					sheetObjects[1].SetCellValue(1, "bkg_vvd_cd",rArray[0][3]);
				}
	    	}
    	}
    }
    /**
     * Save Value that recevied data from Container Type/Size
     */
    function callBack0080(rArray){    
    	 var formObj=document.form;
    	 if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){ 
    		 if(rArray != null){
    			 sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cntr_tpsz_cd",rArray[0][2]);
    			 var Col = sheetObjects[0].SaveNameCol("cntr_tpsz_cd");
    			 t1sheet1_OnAfterEdit(sheetObjects[0], sheetObjects[0].GetSelectRow(), Col);
    		 }
    	 }
    }          
    /**
     * Hanger Installation Order Select Popup Call. <br>
     */
    function comBkgCallPop0081(callback_func,callSheetIdx){
    	ComOpenPopup("ESM_BKG_0081.do?pgmNo=ESM_BKG_0081&callSheetIdx="+callSheetIdx, 500, 290, callback_func,	"1,0,1,1,1", true);
    }        
     /**
      * Hanger Installation Order End Evnet Handling <br>
      */
     function callBack0081(hngrFlg){ 
     	var formObj=document.form;
     	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){ 
	     	ComSetObjValue(formObj.modify_flag, "Y");    
	  		ComSetObjValue(formObj.carge_detail_pop, "Y"); 
	  		ComSetObjValue(formObj.qty_modify_flag, "Y");
	     	ComSetObjValue(formObj.hngr_flg, hngrFlg);
	     	ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		
	     	changeObjectColor(hngrFlg, "Y", "btn_t1Hanger", "blue", "btn2");	    
     	}
     }   
     /**
      * Save Value that recevied data from MT PickUp CY Inquiry
      */
     function callBack0082(rArray){    	
     	var formObj=document.form;
     	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){      	
	     	if(rArray != null){
	     		ComSetObjValue(formObj.mty_pkup_yd_cd, rArray[0][2]);
	     		ComSetObjValue(formObj.route_modify_flag, "Y");
	     		ComSetObjValue(formObj.modify_flag, "Y");
	     		manageHaveRouteFlag("N");
	     	}
     	}
     }     
     /**
      * Save Value that recevied data from Node Search
      */
     function callBack0083(locTp, tab, rArray){
     	var formObj=document.form;
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     	
	     	if(rArray != null){
	     		if(tab == 1){
		 	    	if(locTp == "POR"){
		 	    		ComSetObjValue(formObj.bkg_por_cd, rArray[0][2]);
		 	    		form_onChange(null,formObj.bkg_por_cd);
		 	    		ComSetObjValue(formObj.bkg_por_yd_cd, "");
		 	    		form_onChange(null,formObj.bkg_por_yd_cd);
		 	    	}else if(locTp == "POL"){
		 	    		ComSetObjValue(formObj.bkg_pol_cd, rArray[0][2]);
		 	    		form_onChange(null,formObj.bkg_pol_cd);
		 	    		ComSetObjValue(formObj.bkg_pol_yd_cd, "");
		 	    		form_onChange(null,formObj.bkg_pol_yd_cd);
		 	    		por_pol_change(formObj);
		 	    	}else if(locTp == "POD"){
		 	    		ComSetObjValue(formObj.bkg_pod_cd, rArray[0][2]);
		 	    		form_onChange(null,formObj.bkg_pod_cd);
		 	    		ComSetObjValue(formObj.bkg_pod_yd_cd, "");
		 	    		form_onChange(null,formObj.bkg_pol_yd_cd);
		 	    		pod_del_change(formObj);
		 	    	}else{
		 	    		ComSetObjValue(formObj.bkg_del_cd, rArray[0][2]);
		 	    		form_onChange(null,formObj.bkg_del_cd);
		 	    		ComSetObjValue(formObj.bkg_del_yd_cd, "");
		 	    		form_onChange(null,formObj.bkg_del_yd_cd);
		 	    	}		  
	     		}else{
		 	    	if(locTp == "POR"){
		 	    		ComSetObjValue(formObj.bkg_por_cd, rArray[0][4].substring(0,5));
		 	    		form_onChange(null,formObj.bkg_por_cd);
		 	    		ComSetObjValue(formObj.bkg_por_yd_cd, rArray[0][4].substring(5,7));
		 	    		form_onChange(null,formObj.bkg_por_yd_cd);
		 	    	}else if(locTp == "POL"){
		 	    		ComSetObjValue(formObj.bkg_pol_cd, rArray[0][4].substring(0,5));
		 	    		form_onChange(null,formObj.bkg_pol_cd);
		 	    		ComSetObjValue(formObj.bkg_pol_yd_cd, rArray[0][4].substring(5,7));
		 	    		form_onChange(null,formObj.bkg_pol_yd_cd);
		 	    		por_pol_change(formObj);
		 	    	}else if(locTp == "POD"){
		 	    		ComSetObjValue(formObj.bkg_pod_cd, rArray[0][4].substring(0,5));
		 	    		form_onChange(null,formObj.bkg_pod_cd);
		 	    		ComSetObjValue(formObj.bkg_pod_yd_cd, rArray[0][4].substring(5,7));
		 	    		form_onChange(null,formObj.bkg_pod_yd_cd);
//		 	    		checkEgyptDeTerm(rArray[0][4].substring(0,5));
		 	    		pod_del_change(formObj)
		 	    	}else{
		 	    		ComSetObjValue(formObj.bkg_del_cd, rArray[0][4].substring(0,5));
		 	    		form_onChange(null,formObj.bkg_del_cd);
		 	    		ComSetObjValue(formObj.bkg_del_yd_cd, rArray[0][4].substring(5,7));	
		 	    		form_onChange(null,formObj.bkg_del_yd_cd);
		 	    	}		     			
	     		}    	
	 	    	ComSetObjValue(formObj.route_modify_flag, "Y");
	 	    	ComSetObjValue(formObj.modify_flag, "Y");
	 	    	manageHaveRouteFlag("N");
	     	}
    	}
     }     
     /**
      * Save Value that recevied data from Full Return CY 
      */
     function callBack0088(rArray){    	
     	var formObj=document.form;
     	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	     	if(rArray != null){
	     		ComSetObjValue(formObj.full_rtn_yd_cd, rArray[0][2]);
	     		ComSetObjValue(formObj.route_modify_flag, "Y");
	     		ComSetObjValue(formObj.modify_flag, "Y");
	 	    	manageHaveRouteFlag("N");
	     	}
     	}
     } 
      /**
       * Save Value that recevied data from Special Stowage Request
       */
      function comBkgCallPop0090(callback_func, stwgCd){
    	  //ComOpenPopup("ESM_BKG_0090.do?pgmNo=ESM_BKG_0090&stwg_cd="+stwgCd, 420, 530, callback_func,"0,1", true);
    	  if (ComGetObjValue(document.form.bkg_no)==""){
    		  ComShowCodeMessage("BKG01129");
    	  }else{
    		  ComOpenPopup("ESM_BKG_0090.do?pgmNo=ESM_BKG_0090&stwg_cd="+stwgCd, 1000, 550, callback_func,"0,1", true);
    	  }
      }            
      /**
       * Save Value that recevied data from Special Stowage Request 
       */
      function callBack0090(rArray){    	
      	var formObj=document.form;
      	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){         	
  	    	if(rArray != null){
  	    		ComSetObjValue(formObj.stwg_cd, rArray[0]);
  	    		ComSetObjValue(formObj.stwg_rmk, rArray[1]);
  	    		ComSetObjValue(formObj.modify_flag, "Y");
  	    		if(ComGetObjValue(formObj.stwg_cd) != ""){
  	        		ComSetObjValue(formObj.stwg_flg, "Y");
  	        		changeObjectColor("Y", "Y", "btn_t1Stowage", "blue", "btn2");    			
  	    		}else{
  	        		ComSetObjValue(formObj.stwg_flg, "N");
  	        		changeObjectColor("N", "Y", "btn_t1Stowage", "blue", "btn2");    			
  	    		}
  	    	}
      	}
      }           
    /**
     * route detail Popup Call. <br>
     */
    function comBkgCallPop0092(callback_func, bkgNo, bkgTrunkVvd, caFlg, callSheetIdx, podClptIndSeq, polClptIndSeq){	
    	var formObj=document.form;    	 
    	var url="ESM_BKG_0092.do?pgmNo=ESM_BKG_0092&bkg_no="+bkgNo+"&bkgTrunkVvd="+bkgTrunkVvd+"&ca_flg="+caFlg+"&callSheetIdx="+callSheetIdx + "&pod_clpt_ind_seq=" + podClptIndSeq + "&pol_clpt_ind_seq=" + polClptIndSeq;
    	if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
    		url=url + "&displayOnly=Y";
    	} else if(ComGetObjValue(formObj.is_vl_flg) == "Y"){
    		url=url + "&displayOnly=1";
    	}
    	ComOpenPopup(url, 700, 510, callback_func,"0,1,1,1,1", true);
    }        
     /**
      * Route Detail Handling <br>
      */
     function callBack0092(){    	
     	var formObj=document.form;
     	var sheetObj=sheetObjects[1];
     	var row;
     	clearPrePostRelay(formObj);
     	if(sheetObj.RowCount()> 0){
     		if(sheetObj.GetCellValue(sheetObj.FindText("vsl_pre_pst_cd","T"), "bkg_vvd_cd") != ComGetObjValue(formObj.bkg_trunk_vvd)){
     			ComSetObjValue(formObj.bkg_trunk_vvd, "");
     		}
//     		ComSetObjValue(formObj.bkg_trunk_vvd, sheetObj.GetCellValue(sheetObj.FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd"));
         	if(sheetObj.FindText("vsl_pre_pst_cd","T") > 1){
         		row = sheetObj.FindText("vsl_pre_pst_cd","T")-1;
         		ComSetObjValue(formObj.pre_rly_port_cd,    sheetObj.GetCellValue(row,"pod_cd"));
         		ComSetObjValue(formObj.pre_rly_port_yd_cd, sheetObj.GetCellValue(row,"pod_yd_cd"));
         		ComSetObjValue(formObj.pre_vvd_cd,         sheetObj.GetCellValue(row,"bkg_vvd_cd"));
         	}
         	if(sheetObj.FindText("vsl_pre_pst_cd","T")+1 <= sheetObj.LastRow()){
         		row = sheetObj.FindText("vsl_pre_pst_cd","T")+1;
         		ComSetObjValue(formObj.pst_rly_port_cd,    sheetObj.GetCellValue(row,"pol_cd"));
         		ComSetObjValue(formObj.pst_rly_port_yd_cd, sheetObj.GetCellValue(row,"pol_yd_cd"));
         		ComSetObjValue(formObj.pst_vvd_cd,         sheetObj.GetCellValue(row,"bkg_vvd_cd"));
         	}
         	row = sheetObj.LastRow();
         	ComSetObjValue(formObj.bkg_pol_cd,    sheetObj.GetCellValue(1,"pol_cd"));
         	ComSetObjValue(formObj.bkg_pol_yd_cd, sheetObj.GetCellValue(1,"pol_yd_cd"));
         	ComSetObjValue(formObj.bkg_pod_cd,    sheetObj.GetCellValue(row,"pod_cd"));
         	ComSetObjValue(formObj.bkg_pod_yd_cd, sheetObj.GetCellValue(row,"pod_yd_cd"));
     	}
 		ComSetObjValue(formObj.route_modify_flag, "Y");
 		ComSetObjValue(formObj.modify_flag, "Y");
     	manageHaveRouteFlag("N");
 		if(formObj.bkg_trunk_vvd.value.length > 4){
 			var pseudoVvd=ComGetObjValue(formObj.bkg_trunk_vvd).substring(0,4);
 			if(pseudoVvd == "COXX" || pseudoVvd == "COYY" || pseudoVvd == "COZZ"){
 				ComSetObjValue(formObj.psdo_bkg_flg, "Y");
 			}else{
 				ComSetObjValue(formObj.psdo_bkg_flg, "N");
 			}
 		}
 		por_pol_change(formObj);
 		pod_del_change(formObj);
 		tooltipLoad('bkg_trunk_vvd', 'VVD', ComGetObjValue(formObj.bkg_trunk_vvd));
     }         
    /**
     * Reference Popup Call. <br>
     */
    function comBkgCallPop0097(callback_func, bkgNo,  caFlg){
    	ComOpenPopup("ESM_BKG_0097.do?pgmNo=ESM_BKG_0097&bkg_no="+bkgNo+"&ca_flg="+caFlg, 500, 390, callback_func,"0,1,1,1,1", true);
    }     
    /**
     * Save Value that Recevied Data From Reference Popup <br>
     */
    function callBack0097(memo){    
    	var formObj=document.form;
    	if(memo != null && memo.length > 0){
    		if(ComIsNull(formObj.xter_rmk)){
    			ComSetObjValue(formObj.xter_rmk,memo);
    		}else{
    			ComSetObjValue(formObj.xter_rmk,ComGetObjValue(formObj.xter_rmk)+"\n"+memo);
    		}
	    	ComSetObjValue(formObj.modify_flag, "Y");
    	}
    }                
     /**
      * danger Popup open  <br>
      */
    function comBkgCallPop0200(bkgNo, caFlg){	
    	var formObj=document.form;
//		ComOpenWindowCenter("ESM_BKG_0200_POP.do?pgmNo=ESM_BKG_0200&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1250, 570, true);
		ComOpenWindowCenter("ESM_BKG_0200_POP.do?pgmNo=ESM_BKG_0200&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1260, 625, true);
		doActionIBSheet(sheetObjects[2],formObj,SEARCH);
    }
	 /**
     * Save Value that Recevied Data From Customer Popup
     */
    function callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){
    	var formObj=document.form;
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	    	if(rArray1 != null){
	    		if(rArray1[0][2] == "PREMIUM"){
	    			ComSetObjValue(formObj.premium_available_flg, "Y");
//	    			formObj.hot_de_flg.disabled=false;
	    		}
		    	if(bkgCustTpCd == "S"){
		    		ComSetObjValue(formObj.s_cust_cnt_cd, rArray1[0][10].substring(0,2));
		    		ComSetObjValue(formObj.s_cust_seq,    ComLpad(rArray1[0][11],6,"0"));
		    		ComSetObjValue(formObj.s_cust_nm,     rArray1[0][4]);
		    		if(ComGetObjValue(formObj.s_cust_exist_flg) == "Y"){
		    			if(ComGetObjValue(formObj.s_cust_cnt_cd) != ComGetObjValue(formObj.s_cust_cnt_cd_old) || ComGetObjValue(formObj.s_cust_seq) != ComLpad(ComGetObjValue(formObj.s_cust_seq_old),6,"0")){
		    				ComSetObjValue(formObj.s_cust_subst_flg, "Y");
		    				if(ComShowCodeConfirm("BKG00343")){
		    					ComSetObjValue(formObj.s_cust_subst_flg, "Y");
		    				}else{
		    					ComSetObjValue(formObj.s_cust_subst_flg, "N");
		    				}
		    			}
		    		}    			    		
		    		if(rArray2 != null){
	    				if(rArray2[0][8] != ""){
	    		    		ComSetObjValue(formObj.f_cust_cnt_cd, rArray2[0][8].substring(0,2));
	    		    		ComSetObjValue(formObj.f_cust_seq,    ComLpad(rArray2[0][8].substring(2),6,"0"));				    					
	    				}else{
	    				}
		    			if(ComGetObjValue(formObj.f_cust_exist_flg) == "Y"){
			    			if(ComGetObjValue(formObj.f_cust_cnt_cd) != ComGetObjValue(formObj.f_cust_cnt_cd_old) || ComGetObjValue(formObj.f_cust_seq) != ComLpad(ComGetObjValue(formObj.f_cust_seq_old),6,"0")){
			    				if(ComShowCodeConfirm("BKG00343")){
			    					ComSetObjValue(formObj.f_cust_subst_flg, "Y");
			    				}else{
			    					ComSetObjValue(formObj.f_cust_subst_flg, "N");
			    				}
			    			}		    		    		
			    			searchCustNm(formObj, ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "F");		    				
		    			} else {
		    				if(rArray2[0][8] != ""){
		    					searchCustNm(formObj, ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "F");
		    				}
		    			}
		    		}
					 ComSetObjValue(formObj.ob_sls_ofc_cd, lOfc);
					 ComSetObjValue(formObj.ob_srep_cd,    lRep);
		    	}else if(bkgCustTpCd == "F"){
		    		ComSetObjValue(formObj.f_cust_cnt_cd, rArray1[0][10].substring(0,2));
		    		ComSetObjValue(formObj.f_cust_seq,    ComLpad(rArray1[0][11],6,"0"));
		    		ComSetObjValue(formObj.f_cust_nm,     rArray1[0][4]);  
		    		ComSetObjValue(formObj.fmc_no,        rArray1[0][7]);	
		    		if(ComGetObjValue(formObj.s_cust_exist_flg) != "Y" && ComIsNull(formObj.s_cust_nm)){
			    		ComSetObjValue(formObj.s_cust_cnt_cd, rArray1[0][10].substring(0,2));
			    		ComSetObjValue(formObj.s_cust_seq,    ComLpad(rArray1[0][11],6,"0"));
			    		ComSetObjValue(formObj.s_cust_nm,     rArray1[0][4]);	    			
		    		}
		    		if(ComGetObjValue(formObj.f_cust_exist_flg) == "Y"){
		    			if(ComGetObjValue(formObj.f_cust_cnt_cd) != ComGetObjValue(formObj.f_cust_cnt_cd_old) || ComGetObjValue(formObj.f_cust_seq) != ComLpad(ComGetObjValue(formObj.f_cust_seq_old),6,"0")){
		    				if(ComShowCodeConfirm("BKG00343")){
		    					ComSetObjValue(formObj.f_cust_subst_flg, "Y");
		    				}else{
		    					ComSetObjValue(formObj.f_cust_subst_flg, "N");
		    				}
		    			}
		    		}    				    		
		    		if(ComIsNull(formObj.ob_srep_cd)){
		    			ComSetObjValue(formObj.ob_sls_ofc_cd, lOfc);
						ComSetObjValue(formObj.ob_srep_cd,    lRep);
		    		}
		    	}else if(bkgCustTpCd == "P"){
		    		ComSetObjValue(formObj.bkg_pty_cnt_cd, rArray1[0][10].substring(0,2));
		    		ComSetObjValue(formObj.bkg_pty_cust_seq,    ComLpad(rArray1[0][11],6,"0"));
		    		ComSetObjValue(formObj.bkg_pty_cust_nm,     rArray1[0][4]);
		    	}
		    	
		    	ComSetObjValue(formObj.modify_flag,          "Y");
		    	ComSetObjValue(formObj.customer_modify_flag, "Y");
	    	}
	    	// BKG,S/I Contact insert
			 if(rArray2 != null){
				 for(i=0 ; i < rArray2.length ; i++){
					 if(rArray2[i][2] == "AL" || rArray2[i][2] == ""){
						 // BKG Contact,S/I Contact All insert
						ComSetObjValue(formObj.bkg_cntc_pson_nm,     rArray2[i][3]);
						ComSetObjValue(formObj.bkg_cntc_pson_phn_no, rArray2[i][4]);
						ComSetObjValue(formObj.bkg_cntc_pson_eml,    rArray2[i][7]);
						ComSetObjValue(formObj.bkg_cntc_pson_mphn_no,rArray2[i][5]);
						ComSetObjValue(formObj.bkg_cntc_pson_fax_no, rArray2[i][6]);			
						ComSetObjValue(formObj.si_cntc_pson_nm,      rArray2[i][3]);
						ComSetObjValue(formObj.si_cntc_pson_phn_no,  rArray2[i][4]);
						ComSetObjValue(formObj.si_cntc_pson_eml,     rArray2[i][7]);
						ComSetObjValue(formObj.si_cntc_pson_mphn_no, rArray2[i][5]);
						ComSetObjValue(formObj.si_cntc_pson_fax_no,  rArray2[i][6]);							
					}else if(rArray2[i][2] == "SI"){
						// S/I Contact insert
						ComSetObjValue(formObj.si_cntc_pson_nm,      rArray2[i][3]);
						ComSetObjValue(formObj.si_cntc_pson_phn_no,  rArray2[i][4]);
						ComSetObjValue(formObj.si_cntc_pson_eml,     rArray2[i][7]);
						ComSetObjValue(formObj.si_cntc_pson_mphn_no, rArray2[i][5]);
						ComSetObjValue(formObj.si_cntc_pson_fax_no,  rArray2[i][6]);
					}else{
						// BKG Contact insert
						ComSetObjValue(formObj.bkg_cntc_pson_nm,     rArray2[i][3]);
						ComSetObjValue(formObj.bkg_cntc_pson_phn_no, rArray2[i][4]);
						ComSetObjValue(formObj.bkg_cntc_pson_eml,    rArray2[i][7]);
						ComSetObjValue(formObj.bkg_cntc_pson_mphn_no,rArray2[i][5]);
						ComSetObjValue(formObj.bkg_cntc_pson_fax_no, rArray2[i][6]);							
					}
				 }
				 ComSetObjValue(formObj.contact_modify_flag, "Y");
			 }
    	}
    }       
    
    function callBack0652_save(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){
    	if(lOfc == '' || lRep == '') {
    		ComShowMessage('Sales REP not exists');
    	}
		callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep);
    	var formObj = document.form;
    	if(validateForm(formObj, COMMAND01)){
    		doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
    	}
    }     
    
     /**
      * CMDT Info Save Function. <br>
      */    
 	function callBack0653(arrVal){
     	 var formObj=document.form;
     	 if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){         	 
 			if(arrVal != null){				
 				ComSetObjValue(formObj.cmdt_cd,     arrVal[0][3]);
 				ComSetObjValue(formObj.rep_cmdt_cd, arrVal[0][5]);
 				ComSetObjValue(formObj.cmdt_desc,   arrVal[0][4]);		
 				if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
 					var precaution=arrVal[0][7];
 					setPrecaution(formObj, precaution);
    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
 					ComSetObjValue(formObj.validPrecaution, "Y");		
 					ComSetObjValue(formObj.modify_flag, "Y");   	
 					ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][3]);				
 				}
 			}
     	 }
 	}    	
      /**
       * RFA Search Info Save Function. <br>
       */    
  	function callBack0654(arrVal){
    	var formObj=document.form;   
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){   
	  		if(arrVal != null){	  			
	  			ComSetObjValue(formObj.rfa_no,     arrVal[0][5]);
	  			ComSetObjValue(formObj.rfa_no_old, arrVal[0][5]);
	  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
		  		ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
		  		ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, arrVal[0][4]);
	  			ComSetObjValue(formObj.modify_flag,      "Y");   	
	  			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
				changeObjectColor("Y", "N", "rfa_no", "red", "input");
				svcScpCd = arrVal[0][7];
	  		}
    	}
  	}              
     /**
      * S/C Search Info Save Function. <br>
      */    
 	function callBack0655(arrVal){
        var formObj=document.form;
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     
	 		if(arrVal != null){	 			
	 			ComSetObjValue(formObj.sc_no,     arrVal[0][5]);
	  			ComSetObjValue(formObj.sc_no_old, arrVal[0][5]);
  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
	  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
	  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, arrVal[0][4]);
	 			ComSetObjValue(formObj.modify_flag,      "Y");   	
	 			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
	  			changeObjectColor("Y", "N", "sc_no", "red", "input");
	  			svcScpCd = arrVal[0][7];
	 		}
    	}
 	}       
       /**
       * RFA Commodity Popup Info Save Function. <br>
       */    
  	function callBack0656(arrVal){
      	 var formObj=document.form;
      	 if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){  
  			if(arrVal != null){		
   		    	var scpCd=arrVal[0][7];
   		    	
				if(arrVal[0][8] == "0000"||arrVal[0][3]=="000000"){
					comBkgCallPop0653('callBack0653',"","");
				} else if(arrVal[0][5] == "REP"){
					comBkgCallPop0653('callBack0653',"",arrVal[0][3]);					
				} else {			
					ComSetObjValue(formObj.cmdt_cd, arrVal[0][6]);
					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
  						validatePrecaution(formObj);
  	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
  						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck Validation.		
  						ComSetObjValue(formObj.modify_flag, "Y");   	
  						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][6]);
					}
				}	
  			}
      	 }
  	}             
   /**
   * S/C Commodity Popup Info Save Function. <br>
   */    
   	function callBack0657(arrVal){
       	var formObj=document.form;
       	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
   			if(arrVal != null){		
   		    	var scpCd=arrVal[0][7];
   				if(scpCd =="TPE"|| scpCd =="ACE"|| scpCd =="MXE"){
   					ComSetObjValue(formObj.cmdt_cd, arrVal[0][3]);
   					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
   						validatePrecaution(formObj);
   	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
   						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck Validation.		
   						ComSetObjValue(formObj.modify_flag,     "Y");   	
   						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][3]);	
   					}		
   				} else if(arrVal[0][5] == "0000"){
   					comBkgCallPop0653('callBack0653',"","");
   				} else if(arrVal[0][4]=="000000"){
   					comBkgCallPop0653('callBack0653',"","");
   				} else {					
   					ComSetObjValue(formObj.cmdt_cd, arrVal[0][3]);
   					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
   						validatePrecaution(formObj);
   	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
   						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck Validation.		
   						ComSetObjValue(formObj.modify_flag,     "Y");   	
   						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][3]);	
   					}		
   				}
   			}
       	}
   	}          
    /**
     * Stop Off Cargo Order Popup Call. <br>
     */
    function comBkgCallPop0658(callback_func){
    	ComOpenPopup("ESM_BKG_0658.do?pgmNo=ESM_BKG_0658",540, 300, callback_func,"1,0,1,1,1", true);
    }               
     /**
      * Stop Off Cargo Info Save Function. <br>
      */    
 	function callBack0658(arrVal){
 		var formObj=document.form;    	 
 		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     		
 			if(arrVal != null){
 				ComSetObjValue(formObj.stop_off_loc_cd, arrVal[0]);
 				ComSetObjValue(formObj.stop_off_cntc_phn_no, arrVal[1]);
 				ComSetObjValue(formObj.stop_off_cntc_pson_nm, arrVal[2]);
 				ComSetObjValue(formObj.stop_off_diff_rmk, arrVal[3]);
 				ComSetObjValue(formObj.modify_flag, "Y");   	
 				ComSetObjValue(formObj.stop_off_flg, "Y");
 				changeObjectColor("Y", "Y", "btn_t1StopOffCargo", "blue", "btn2");	    	
 			}else{
 				ComSetObjValue(formObj.modify_flag, "Y");   	
 				ComSetObjValue(formObj.stop_off_flg, "N");
 				changeObjectColor("N", "Y", "btn_t1StopOffCargo", "blue", "btn2");			
 			}
 		}
 	}    
    /**
     * Direct NVO-AMS File No Popup Call. <br>
     */
    function comBkgCallPop0744(callback_func, bkgNo,  caFlg, bdrFlg){
    	ComOpenPopup("ESM_BKG_0744.do?pgmNo=ESM_BKG_0744&bkg_no="+bkgNo+"&ca_flg="+caFlg + "&bdr_flg="+bdrFlg, 500, 375, callback_func,"1,0,1,1,1", true);
    }         
     /**
      * Cargo Detail Information Popup Call. <br>
      */
     function comBkgCallPop0890(callback_func, autoFlag){
    	 var formObj=document.form;
		 if(ComGetObjValue(formObj.carge_detail_pop)!="Y" || checkAutoCaluate(formObj)){ 
			 resetQtyDetail();
		 }
		 // RD,SOC,EQ SUB Flag Setting
		 setRdSocEqSubFlg(formObj);    	 
    	 var url="&bkg_no="+ComGetObjValue(formObj.bkg_no)+"&ca_flg="+ComGetObjValue(formObj.ca_flg);
    	 url=url+"&dcgo_flg="+BkgNullToString(ComGetObjValue(formObj.dcgo_flg),"N");
    	 url=url+"&rc_flg="+BkgNullToString(ComGetObjValue(formObj.rc_flg),"N");
    	 url=url+"&awk_cgo_flg="+BkgNullToString(ComGetObjValue(formObj.awk_cgo_flg),"N");
    	 url=url+"&bb_cgo_flg="+BkgNullToString(ComGetObjValue(formObj.bb_cgo_flg),"N");
    	 url=url+"&hngr_flg="+BkgNullToString(ComGetObjValue(formObj.hngr_flg),"N");
    	 url=url+"&eq_subst_flg="+BkgNullToString(ComGetObjValue(formObj.eq_subst_flg),"N");
    	 url=url+"&soc_flg="+BkgNullToString(ComGetObjValue(formObj.soc_flg),"N");
    	 url=url+"&rcv_term_cd="+BkgNullToString(ComGetObjValue(rcv_term_cd),"");    
    	 url=url+"&de_term_cd="+BkgNullToString(ComGetObjValue(de_term_cd),"");
    	 url=url+"&bdr_flg="+BkgNullToString(ComGetObjValue(formObj.bdr_flg),"");
    	 if(ComGetObjValue(rcv_term_cd) == "M" || ComGetObjValue(de_term_cd) == "M"){
    		 url=url+"&mixed_flg=Y";	 
    	 }else{
    		 url=url+"&mixed_flg=N";
    	 }
    	 if(ComGetObjValue(formObj.isInquiry) == "Y"){
    		 rtnValue=ComOpenPopup("ESM_BKG_0890.do?pgmNo=ESM_BKG_0890&callTp=A&bkg_no="+ComGetObjValue(formObj.bkg_no), 650, 400, callback_func,"1,0,1,1,1", true);
    	 }else{
    		 rtnValue=ComOpenPopup("ESM_BKG_0890.do?pgmNo=ESM_BKG_0890&callTp=B&auto_flg="+autoFlag+"&callSheetIdx1=3&callSheetIdx2=0"+url, 650, 400, callback_func,"1,0,1,1,1", true);
    	 }   	 
    	 //ComOpenPopup(url, 1024, 730, "callBackEsdPrd0080",	"1,0,1,1,1", true);
    	 //callBack0890(rtnValue);
     }       
      /**
      * Carge Detail Information Save Function. <br>
      */    
  	function callBack0890(autoFlg){
  		var formObj=document.form;
  		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     
	  		ComSetObjValue(formObj.modify_flag,      "Y");
	  		ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");
	  		ComSetObjValue(formObj.carge_detail_pop, "Y"); 
	  		ComSetObjValue(formObj.qty_modify_flag,  "Y");  	
	  		//pop0890.close();
	  		if(autoFlg == "Y"){
	      		if(validateForm(formObj, COMMAND01)){
	     			doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
	      		}			
	  		}
  		}
  	}   
    /**
     * Service Mode & Route Popup Call. <br>
     */
    function comBkgCallPop0972(callback_func, bkgNo){
    	ComOpenPopup("ESM_BKG_0972.do?pgmNo=ESM_BKG_0972&bkg_no="+bkgNo,800, 220, callback_func,"1,0,1,1,1", true);
    }       
    /**
     * Constraint Popup Call. <br>
     */
    function comBkgCallPop0998(callback_func, bkgNo){
   		var formObj=document.form;
		var url="ESD_PRD_0082.do?f_cmd="+SEARCHLIST+"&pctl_no="+ComGetObjValue(formObj.pctl_no);
		ComOpenPopup(url, 755, 480, "",	"1,0,1,1,1", true);
    }        
    /**
     * Remark Template Popup Call. <br>
     */
    function comBkgCallPop0976(callback_func){
    	ComOpenPopup("ESM_BKG_0976.do?pgmNo=ESM_BKG_0976", 800, 310, callback_func,"0,1,1,1,1", true);
    }    
    function comTrsCallPop0982(callback_func){
    	var formObj=document.form;
		var bkgNo=ComGetObjValue(formObj.bkg_no);
		var interRmkCd = "B";		
		formObj.f_cmd.value=SEARCH01;
		if(bkgNo != null && bkgNo.length > 0){
			var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCH01+"&bkg_no="+bkgNo);
			var cntrArray = new Array();
			cntrArray = ComBkgXml2Array(sXml, "cntr_no");
			var cntrStr ="";
			if(cntrArray != null && cntrArray.length > 0){
				for(i=1;i < cntrArray.length ;i=i+2){
					cntrStr += cntrArray[i];
					if(i != cntrArray.length-1){
						cntrStr += "|";
					}
				}
			}
			ComOpenPopup("ESD_TRS_0982.do?pgmNo=ESD_TRS_0982&bkg_no="+bkgNo+"&eq_no="+cntrStr+"&inter_rmk_cd="+interRmkCd, 1000, 570, callback_func,"0,1,1,1,1", true);
    	}else{
    		ComShowCodeMessage("BKG00255");
    		ComSetFocus(formObj.bkg_no);  
    	}
    }
    /**
     * PRD Popup Call <br>
     */
    function comPrdCallPop0080(callback_func,url){
    	//ComOpenPopup("ESM_BKG_0976.do?pgmNo=ESM_BKG_0976", 800, 340, callback_func,"0,1,1,1,1", true);
    	//ComOpenPopup(url, 1024, 730, "callBackEsdPrd0080",	"1,0,1,1,1", true);
    	ComOpenPopup(url, 1024, 650, callback_func,	"1,0,1,1,1", true);
    }     
     /**
      * Remark Template Popup Value Save <br>
      */
     function callBack0976(rArray){    	
     	var formObj=document.form;
     	var interRmk=ComGetObjValue(formObj.inter_rmk);
     	var xterRmk=ComGetObjValue(formObj.xter_rmk);
     	var vndrRmk=ComGetObjValue(formObj.vndr_rmk);
     	if(rArray != null){
     		for(i=0 ; i < rArray.length ; i++){
     			if(rArray[i][2] == "I"){
     				if(ComIsNull(interRmk)){
     					interRmk=rArray[i][4];
     				}else{
     					interRmk=interRmk + "\n" + rArray[i][4];
     				}     				
     			}else if(rArray[i][2] == "X"){
     				if(ComIsNull(xterRmk)){
     					xterRmk = rArray[i][4];
     				}else{
     					xterRmk = xterRmk + "\n" + rArray[i][4];
     				}        				
     			}else{
     				if(ComIsNull(vndrRmk)){
     					vndrRmk=rArray[i][4];
     				}else{
     					vndrRmk=vndrRmk + "\n" + rArray[i][4];
     				}        				
     			}
     		}     		
     		ComSetObjValue(formObj.inter_rmk, interRmk);
     		ComSetObjValue(formObj.xter_rmk, xterRmk);
     		ComSetObjValue(formObj.vndr_rmk, vndrRmk);    		
     		ComSetObjValue(formObj.modify_flag, "Y");
     	}
     }          
     /**
      * VVD Change for partial container booking Popup Call. <br>
      */
     function comBkgCallPop1024(callback_func, bkgNo){
     	ComOpenPopup("ESM_BKG_1024.do?pgmNo=ESM_BKG_1024&bkg_no="+bkgNo, 800, 540, callback_func,"0,1,1,1,1", true);
     }
      /**
       * VVD Change for partial container booking Popup Call <br>
       */
      function callBack1024_save(){    	
    	   var formObj=document.form;
    	   if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){           	
    		   ComSetObjValue(formObj.modify_flag, "Y");
    		   ComSetObjValue(formObj.partial_vvd_opened_flg, "Y");
    	   }
    	   doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
      }        
    /**
     * After TAA Search, Return Value Save Function. <br>
     */    
	function callBack1062(arrVal){
	  	var formObj=document.form;   
	  	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){   
	  		if(arrVal != null){	  			
	  			ComSetObjValue(formObj.taa_no,     arrVal[0][5]);
	  			ComSetObjValue(formObj.taa_no_old, arrVal[0][5]);
//	  			if(arrVal[0][1] == "S" || arrVal[0][1] == "P" ){
	  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
		  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
		  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, arrVal[0][4]);
//	  			}else{
//	  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, '');
//		  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, '');
//		  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_nm, '');
//	  			}
	  			ComSetObjValue(formObj.modify_flag,      "Y");   	
	  			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
	  			changeObjectColor("Y", "N", "taa_no", "red", "input");
	  		}
	  	}
	}            
    /**
     * TAA Commodity Popup Call, Return Value Save Function. <br>
     */    
	function callBack1078(arrVal){
    	 var formObj=document.form;
    	 if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){  
			if(arrVal != null){
   		    	var scpCd=arrVal[0][5];
//   				if(arrVal[0][1]=="000004"){
//					ComSetObjValue(formObj.cmdt_cd, arrVal[0][1]);
//					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
//						validatePrecaution(formObj);
//						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck Validation.		
//						ComSetObjValue(formObj.modify_flag,     "Y");   	
//						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][1]);
//					}
//				} else 
				if(arrVal[0][6] == "0000"||arrVal[0][1]=="000000"){
					comBkgCallPop0653('callBack0653',"","");
				} else if(arrVal[0][3] == "REP"){
					comBkgCallPop0653('callBack0653',"",arrVal[0][1]);					
				} else {
					ComSetObjValue(formObj.cmdt_cd, arrVal[0][1]);
					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
						validatePrecaution(formObj);
						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck Validation.		
						ComSetObjValue(formObj.modify_flag, "Y");   	
						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][1]);
					}
				}	
			}
    	 }
	}    
    /**
     * Customer Inquiry(CommonPopup) Call, Return Value Save Function. <br>
     */    	
    function callBackComEns041(rArray){
   		var formObj=document.form;
   		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	   		if(rArray != null){
	   			ComSetObjValue(formObj.c_cust_cnt_cd, rArray[0][3].substring(0,2));
	   			ComSetObjValue(formObj.c_cust_seq, ComLpad(rArray[0][3].substring(2),6,"0"));
	   			ComSetObjValue(formObj.c_cust_nm, rArray[0][4]);
	   			ComSetObjValue(formObj.modify_flag, "Y");   	
		    	ComSetObjValue(formObj.customer_modify_flag, "Y");		
	    		if(ComGetObjValue(formObj.c_cust_exist_flg) == "Y"){
	    			if(ComGetObjValue(formObj.c_cust_cnt_cd) != ComGetObjValue(formObj.c_cust_cnt_cd_old) || ComGetObjValue(formObj.c_cust_seq) != ComLpad(ComGetObjValue(formObj.c_cust_seq_old),6,"0")){
	    				if(ComShowCodeConfirm("BKG00343")){
	    					ComSetObjValue(formObj.c_cust_subst_flg, "Y");
	    				}else{
	    					ComSetObjValue(formObj.c_cust_subst_flg, "N");
	    				}
	    			}
	    		}    			   			
	   		}  		    	 
   		}
     }	
 	/**
     * CA Reason End Handling : CaReasonModify
     */ 
     function setCAReasonCallBack(arrPopupData) {
        var formObj=document.form;
     	//01. CA ReasonCd, Remark insertinfo ,
     	var strRsnCd=nullToBlank(arrPopupData[0][2]);
     	var strRemark=nullToBlank(arrPopupData[0][3]);
     	//02. modifyCaReason(e) call
         formObj.ca_rsn_cd.value=strRsnCd;
         formObj.ca_remark.value=strRemark;
         
         if(!ComIsNull(formObj.ca_rsn_cd.value)){
        	 doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
		 }
     }
 	// ESD_PRD_018 Call Return Value.(PCTL_NO)
 	function callBackEsdPrd0080(pctlNo){
 		var formObj=document.form;
 		if(ComIsNull(pctlNo)){
 			pctlNo=""; 			
 		    manageHaveRouteFlag("N");
 		} else {
 			ComSetObjValue(formObj.pctl_no,pctlNo);
 		    manageHaveRouteFlag("Y");
 		    
 		    if(tmpPreCheckFlag!=undefined && tmpPreCheckFlag!=null && tmpPreCheckFlag!=""){
 		    	precheckFlag = tmpPrecheckFlag;
 		    }
 		    tmpPrecheckFlag = "";
 		    esdPrd0080 = true;
			doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
 		}
 	}   
 	
// 	function callBackEsdPrd0080-2(tmpPrecheckFlag){
// 		var formObj=document.form;
//	    if(ComIsNull(formObj.pctl_no.value)){
//		} else {
//			precheckFlag=ComGetEtcData(sXml, "pre_checking");
//			doActionIBSheet(sheetObjects[2], formObj, COMMAND01);//mds
//		}
// 	} 
     /**
     *SC Inquiry  Call. <br>
     */
    function comBkgCallPopEsmPri0004(){   	
    	   var formObj=document.form;
    	   var isPop=true;
    	   if(ComIsNull(formObj.sc_no)){
    		   isPop=false;
    	   }
    	   if(isPop && ComGetObjValue(formObj.sc_no).length > 3){
    		   if(ComGetObjValue(formObj.sc_no).substring(0,3) == "DUM"){
    			   isPop=false;
    		   }
    	   }else{
    		   isPop=false;
    	   }
    	   if(isPop){
    		      var pgmNo="ESM_PRI_0004";
    		      var pgmUrl="/opuscntr/ESM_PRI_0004.do";
    		      var params="&sc_no_p=" + ComGetObjValue(formObj.sc_no).substring(0,3) + "&sc_no_s=" + ComGetObjValue(formObj.sc_no).substring(3); // =======>S/C No.
    		      var parentPgmNo=pgmNo.substring(0, 8) + 'M001';   
    		      var src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
    		      var winObj=window.open(pgmUrl + "?parentPgmNo=" + parentPgmNo + src);      
    	   }   
    }        	
     /**
     *RFA Inquiry  Call. <br>
     */
    function comBkgCallPopEsmPri2019(){   	
    	   var formObj=document.form;
    	   var isPop=true;
    	   if(ComIsNull(formObj.rfa_no)){
    		   isPop=false;
    	   }
    	   if(isPop && ComGetObjValue(formObj.rfa_no).length > 3){
    		   if(ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM"){
    			   isPop=false;
    		   }
    	   }else{
    		   isPop=false;
    	   }
    	   if(isPop){
    	      var pgmNo="ESM_PRI_2019";
    	      var pgmUrl="/opuscntr/ESM_PRI_2019.do";
    	      var params="&s_rfa_no=" + ComGetObjValue(formObj.rfa_no);  //==> RFA No.
    	      var parentPgmNo=pgmNo.substring(0, 8) + 'M001';   
    	      var src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
    	      var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
    	      var winObj=window.open(pgmUrl + "?parentPgmNo=" + parentPgmNo + src);			   
    	   }   
    }         
     /**
         *TAA  Inquiry  Call. <br>
         * @version 2009.05.14
         */
        function comBkgCallPopEsmPri3007(){   	
     	   var formObj=document.form;
     	   var isPop=true;
     	   if(ComIsNull(formObj.taa_no)){
     		   isPop=false;
     	   }
     	   if(isPop){
     		   var pgmNo="ESM_PRI_3007";        // TAA Main Program No
     		    var pgmUrl="/opuscntr/ESM_PRI_3007.do"        // TAA Main screen url
     		    var params="&cond_taa_no=" + ComGetObjValue(formObj.taa_no);   
     		    var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
     		    var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
     		    var sUrl=pgmUrl + "?parentPgmNo=" + parentPgmNo + src;
     		    ComOpenWindow(sUrl);	   
     	   }   
        }    
        
    	function getMakeBrCust(obj) {
    		var formObj=document.form;
    		var arrVal = formObj.xter_rmk.value.split("\n");
    		var strVal = "";
    		if (arrVal.length > 0) {
    	        for (var i=0; i < arrVal.length; i++) {
    	          	var cnt = Math.ceil(arrVal[i].length / 70);
    	            if (cnt > 1) {
    	            	for (var j=0; j < cnt; j++) {
    		            	strVal = strVal + arrVal[i].substring((j*70),(j*70)+70) + "\n";	            		
    	            	}
    	            }else{
    	            	if (arrVal[i].length > 0) strVal = strVal + arrVal[i] + "\n";
    	            }
    	        }
    		}
    		formObj.xter_rmk.value = byteCheck(strVal);
    	}

    	function getMakeBrVndr(obj) {
    		var formObj=document.form;
    		var arrVal = formObj.vndr_rmk.value.split("\n");
    		var strVal = "";
    		if (arrVal.length > 0) {
    	        for (var i=0; i < arrVal.length; i++) {
    	          	var cnt = Math.ceil(arrVal[i].length / 70);
    	            if (cnt > 1) {
    	            	for (var j=0; j < cnt; j++) {
    		            	strVal = strVal + arrVal[i].substring((j*70),(j*70)+70) + "\n";	            		
    	            	}
    	            }else{
    	            	if (arrVal[i].length > 0) strVal = strVal + arrVal[i] + "\n";
    	            }
    	        }
    		}
    		
    		formObj.vndr_rmk.value = byteCheck(strVal);	
    	}
    	
    	function clearContractParty(){
    		var formObj=document.form;
    		formObj.bkg_ctrl_pty_cust_cnt_cd.value = '';
    		formObj.bkg_ctrl_pty_cust_seq.value = '';
    		formObj.bkg_ctrl_pty_cust_nm.value = '';
    	}
    	
    	function byteCheck(value){
    		var returnValue = "";
    		var str = new String(value);
    		var _byte = 0;
    		if(str.length != 0){
    			for (var i=0; i < str.length; i++){
    				var str2 = str.charAt(i);
    				_byte += charByteSize(str2);
    				if(_byte >= 3999) break;
    				returnValue += str2;
    			}
    		}
    		return returnValue;
        }
    	
    	function charByteSize(ch) {
			if (ch == null || ch.length == 0) {
				return 0;
			}
		
			var charCode = ch.charCodeAt(0);
		
			if (charCode <= 0x00007F) {
				return 1;
			} else if (charCode <= 0x0007FF) {
				return 2;
			} else if (charCode <= 0x00FFFF) {
				return 3;
			} else {
				return 4;
			}
    	}
    	
    	function search(formObj, sheetObj){
    		var bkgNo=ComGetObjValue(formObj.bkg_no);
    		var blNo=ComGetObjValue(formObj.bl_no);
    		var caNewCreationFlag=ComGetObjValue(formObj.ca_new_creation_flag);
    		if(bkgNo != null && bkgNo.length > 0){
    			ComResetAll();
    			ComSetObjValue(formObj.bkg_no,bkgNo);
    		}else if(blNo != null && blNo.length > 0){
    			ComResetAll();
    			ComSetObjValue(formObj.bl_no,blNo);
    		}
    		formObj.f_cmd.value=SEARCH;        		
    		ComOpenWait(true);
    		var param="f_cmd="+SEARCH + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value;
    		
    		$.ajax({
    		    type: "POST",
    		    url: 'ESM_BKG_0079_01GS.do',
    		    async: true,
    		    dataType: "text",
    		    data: param,
    		    success: function(sXml){
//    		    	var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
    	    		var arrXml=sXml.split("|$$|");  
    	    		// Combo setting
    	    		if (arrXml.length > 0){	// RD Term
    	    			ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");    				
    	    			sheetObjects[2].LoadSearchData(arrXml[0]);
    	    		}             		
    	    		if (arrXml.length > 1){	// RD Term
    	    			ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");		
    	    		}             						
    	    		if (arrXml.length > 2){	// Filer US		
    	    			ComBkgXml2ComboItem(arrXml[2], comboObjects[2], "val", "name");
    	    			comboObjects[2].InsertItem(0,"","");
    	    		}				
    	    		if (arrXml.length > 3){	// Filer CA
    	    			ComBkgXml2ComboItem(arrXml[3], comboObjects[3], "val", "name");
    	    			comboObjects[3].InsertItem(0,"","");
    	    		}     				
    	    		if (arrXml.length > 4){	// Weight Unit
    	    			ComBkgXml2ComboItem(arrXml[4], comboObjects[4], "val", "val");
    	    		}     				
    	    		if (arrXml.length > 5){	// Rail Bulk
    	    			ComBkgXml2ComboItem(arrXml[5], comboObjects[5], "val", "name");
    	    		}					
    	    		if (arrXml.length > 6){	// VSK info
    	    			sheetObjects[1].LoadSearchData(arrXml[6] );
    	    		}       
    	    		if (arrXml.length > 7){	// Quantity info
    	    			sheetObjects[0].LoadSearchData(arrXml[7]);
    	    		}       				
    	    		if (arrXml.length > 8){	// QtyDtl info
    	    			sheetObjects[3].LoadSearchData(arrXml[8]);
    	    		}
    	    		BkgEtcDataXmlToForm(arrXml[0], formObj);		// Booking Basic info
    	    		var bkgDelYdCd = ComGetEtcData(arrXml[0], "bkg_del_yd_cd");
    	    		if(bkgDelYdCd != undefined)
    	    			ComSetObjValue(formObj.bkg_del_yd_cd, bkgDelYdCd);
    	    		ComSetObjValue(formObj.pctl_no, ComGetEtcData(arrXml[0], "pctl_no"));
    	    		ComSetObjValue(formObj.xter_bkg_rqst_ref_no, ComGetEtcData(arrXml[0], "xter_bkg_rqst_ref_no"));

    	    		// Route Detail Btn Color Change
    	    		changeObjectColor(ComGetEtcData(arrXml[0], "vvd_flag"), "N", "btn_t1RouteDetail", "red", "btn2");
    	    		// RFA NO Color Change
    	    		changeObjectColor(ComGetEtcData(arrXml[0], "rfa_available"), "N", "rfa_no", "red", "input");
    	    		// SC NO Color Change
    	    		changeObjectColor(ComGetEtcData(arrXml[0], "sc_available"), "N", "sc_no", "red", "input");
    	    		//  SC NO Color Change
    	    		changeObjectColor(ComGetEtcData(arrXml[0], "taa_available"), "N", "taa_no", "red", "input");
    	    		// Split Flag print				
    	    		if(formObj.adv_shtg_cd.value=="A"){
    	    			formObj.split_info.value="Adv.";
    	    		} else if(formObj.adv_shtg_cd.value=="S"){
    	    			formObj.split_info.value="Sh.";
    	    		} else if(formObj.split_rsn_cd.value=="M"){
    	    			formObj.split_info.value="Memo";
    	    		} else if(ComGetEtcData(arrXml[0], "split_flg")== "Y"){
    	    			formObj.split_info.value="Split";
    	    		} else {
    	    			formObj.split_info.value="";
    	    		}
    	    		if(formObj.split_info.value.length>0){
    	    			ComGetObject("split_flg").style.display="inline"
    	    			formObj.split_info.style.color="blue";					
    	    			formObj.split_info.style.background="#F3F2F8";					
    	    		} else {
    	    			ComGetObject("split_flg").style.display="none";
    	    		}
//    	    		    				var fmcNo = ComGetEtcData(arrXml[0], "fmc_no");
    	    		// Wait Reason print
    	    		var waitRsn=ComGetEtcData(arrXml[0], "wait_rsn");
    	    		if(waitRsn != undefined){
    	    			newStsCd = "F";
    	    			ComGetObject("wait_rsn").innerHTML=waitRsn;
    	    		}
    	    		// Booking User info
    	    		var userInfo="ID : "     + ComGetEtcData(arrXml[0], "doc_usr_id") + "<br>" + 
    	    					   "TEL : "    + ComGetEtcData(arrXml[0], "xtn_phn_no") + "<br>" + 
    	    					   "E-mail : " + ComGetEtcData(arrXml[0], "usr_eml");
    	    		formObj.userInfo.value=userInfo;
    	    		ComGetObject("btn_t1Danger").style.color=getSpclCgoBtnColor(ComGetEtcData(arrXml[0], "dg_flg"));
    	    		ComGetObject("btn_t1Reefer").style.color=getSpclCgoBtnColor(ComGetEtcData(arrXml[0], "rf_flg"));
    	    		ComGetObject("btn_t1Awkward").style.color=getSpclCgoBtnColor(ComGetEtcData(arrXml[0], "awk_flg"));
    	    		ComGetObject("btn_t1BreakBulk").style.color=getSpclCgoBtnColor(ComGetEtcData(arrXml[0], "bb_flg"));

    	    		// Stowage info Exist, Red Color Display
    	    		if(ComGetEtcData(arrXml[0], "stwg_flg") == "Y"){
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "stwg_flg"), "Y", "btn_t1Stowage", "blue");	
    	    		}else{
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "stwg_flg"), "N", "btn_t1Stowage", "black");
    	    		}				
    	    		// Hanger info Exist, Red Color Display
    	    		if(ComGetEtcData(arrXml[0], "hngr_flg") == "Y"){
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "hngr_flg"), "Y", "btn_t1Hanger", "blue");
    	    		}else{
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "hngr_flg"), "N", "btn_t1Hanger", "black");
    	    		}
    	    		// Stop Off Cargo info Exist, Red Color Display
    	    		if(ComGetEtcData(arrXml[0], "stop_off_flg") == "Y"){
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "stop_off_flg"), "Y", "btn_t1StopOffCargo", "blue");
    	    		}else{
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "stop_off_flg"), "N", "btn_t1StopOffCargo", "black");
    	    		}				
    	    		// Constraint info Exist, Red Color Display
    	    		if(ComGetEtcData(arrXml[0], "constraint_flag") == "Y"){
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "constraint_flag"), "Y", "btn_t1Constraints", "red");
    	    		}else{
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "constraint_flag"), "N", "btn_t1Constraints", "black");
    	    		}
    	    		// Reference info Exist, Red Color Display
    	    		if(ComGetEtcData(arrXml[0], "ref_flg") == "Y"){
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "ref_flg"), "Y", "btn_t1ReferenceNo", "blue");
    	    		}else{
    	    			changeObjectColor(ComGetEtcData(arrXml[0], "ref_flg"), "N", "btn_t1ReferenceNo", "black");
    	    		}

    	    		// Firm,Waiting Btn Handling
    	    		var bkgStsCd=ComGetEtcData(arrXml[0], "bkg_sts_cd");
    	    		var irrBlNoFlg = ComGetEtcData(arrXml[0], "irr_bl_no_flg");
    	    		var blNo = ComGetEtcData(arrXml[0], "bl_no");
    	    		
    	    		formObj.bl_no_ck.value = blNo;
    	    		
    	    		if(irrBlNoFlg == 'Y'){
    	    			formObj.bkg_ty_flg.checked = 1;
    	    		}
    	    		
    	    		changeObjectColor(bkgStsCd, "X", "bkg_sts_cd", "red", "input2");
    	    		changeObjectColor(bkgStsCd, "W", "bkg_sts_cd", "red", "input2");
    	    		if(bkgStsCd == "F"){
    	    			ComGetObject("btn_t1Waiting").style.display="inline";
    	    			ComGetObject("btn_t1Holding").style.display="none";
    	    		}else if(bkgStsCd == "W"){
    	    			ComGetObject("btn_t1Holding").style.display="inline";
    	    			ComGetObject("btn_t1Waiting").style.display="none";
    	    		}

    	    		//////////////////////////////////////////////////////// RollOvr수 체크해서 버튼색깔 변경.(20091125) 
    	    		if(BkgParseInt(ComGetEtcData(arrXml[0], "roll_ovr_cnt")) > 1){
    	    			changeObjectColor("Y", "Y", "btn_t1RollOverInformation", "blue", "btn1");
    	    		}else{
    	    			changeObjectColor("N", "Y", "btn_t1RollOverInformation", "#c0c0c0", "btn1");
    	    		}	

    	    		if(ComGetEtcData(arrXml[0], "rcv_term_cd") != "D"){					
    	    			formObj.mty_dor_arr_dt.disabled=true;
    	    		}	
    	    		// Original Bl No save
    	    		var orgBlNo=ComGetEtcData(arrXml[0], "OrgBlNo");
    	    		if(orgBlNo != undefined && orgBlNo != ""){
    	    			formObj.orgBlNo.value=orgBlNo;
    	    			ComGetObject("btn_OrgBlPop").style.display="inline";
    	    		}else{
    	    			ComGetObject("btn_OrgBlPop").style.display="none";
    	    		}
    	    		if(ComGetEtcData(arrXml[0], "act_wgt") != undefined){
    	    			formObj.act_wgt.value=makeComma(ComGetEtcData(arrXml[0], "act_wgt"));
    	    		}
    	    		tabObjects[0].SetSelectedIndex(0);
    	    		if(caNewCreationFlag == "Y"){					
    	    			ComBtnDisable("btn_t1Save");	
    	    		} else {
    	    			// Button Enable/Disable
    	    			if(ComGetEtcData(arrXml[0], "DataYn") == "Y"){
    	    				formObj.data_yn.value="Y";
    	    				btn007901Control(true, "btn_t1Save");
    	    				btn007901Control(true, "btn_t1GoIBCS");
    	    				btn007901Control(true, "btn_t1BKGCancel");
    	    				btn007901Control(true, "btn_t1FaxEDI");
    	    				btn007901Control(true, "btn_t1Holding");
    	    				btn007901Control(true, "btn_t1Waiting");
    	    			}else{
    	    				btn007901Control(false, "btn_t1Save");
    	    				btn007901Control(false, "btn_t1GoIBCS");
    	    				btn007901Control(false, "btn_t1BKGCancel");
    	    				btn007901Control(false, "btn_t1FaxEDI");
    	    				btn007901Control(false, "btn_t1Holding");
    	    				btn007901Control(false, "btn_t1Waiting");
    	    				btn007901Control(false, "btn_t1Split");
    	    				changeObjectColor("Y", "Y", "btn_t1Save", "#c0c0c0", "btn1");
    	    				parent.initCAControl("", "N", "N", "N", "");
    	    				ComOpenWait(false);
    	    			}
    	    			if(ComGetEtcData(arrXml[0], "bdr_flg") == "Y"){
    	    				btn007901Control(false, "btn_t1BKGCancel");
    	    				btn007901Control(false, "btn_t1Holding");
    	    				btn007901Control(false, "btn_t1Waiting");					
    	    			} else {
    	    				btn007901Control(true, "btn_t1BKGCancel");
    	    			}
    	    		}
    	    		// Premium Disable
    	    		if(ComGetObjValue(formObj.premium_available_flg) == "Y"&&"USLGB"==ComGetObjValue(formObj.bkg_del_cd)){
//    	    		    		    		formObj.hot_de_flg.disabled=false; 
    	    		}else{
    	    			formObj.hot_de_flg.checked=false;
    	    			formObj.hot_de_flg.disabled=true;   		
    	    		}				
    	    		if(ComGetEtcData(arrXml[0], "bdr_flg") == "Y" && ComGetEtcData(arrXml[0], "ca_flg") == "N"){
    	    			setBookingEditable(false);
    	    		}else{
    	    			setBookingEditable(true);
    	    		}
    	    		if(ComIsNull(formObj.taa_no) && !ComIsNull(formObj.rfa_no)){
    	    			formObj.chkTaaRfaNo[1].checked=true;				
    	    			document.all.item("taaNoDiv").style.display="none";
    	    			document.all.item("rfaNoDiv").style.display="inline";		
    	    		}else if(!ComIsNull(formObj.taa_no) && ComIsNull(formObj.rfa_no)){
    	    			formObj.chkTaaRfaNo[0].checked=true;					
    	    			document.all.item("taaNoDiv").style.display="inline";
    	    			document.all.item("rfaNoDiv").style.display="none";						
    	    		}else if(ComIsNull(formObj.taa_no) && ComIsNull(formObj.rfa_no)){ 
    	    			if(ComGetObjValue(formObj.bkg_por_cd).substring(0,2)=="US" || 
    	    			   ComGetObjValue(formObj.bkg_pol_cd).substring(0,2)=="US" ||
    	    				(!ComIsNull(formObj.bkg_pod_cd) && ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)=="US") ||
    	    				ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="US" ){
    	    				formObj.chkTaaRfaNo[0].checked=true;					
    	    				document.all.item("taaNoDiv").style.display="inline";
    	    				document.all.item("rfaNoDiv").style.display="none";											
    	    			} else {
    	    				formObj.chkTaaRfaNo[1].checked=true;				
    	    				document.all.item("taaNoDiv").style.display="none";
    	    				document.all.item("rfaNoDiv").style.display="inline";								
    	    			}
    	    		}
    	    		if("Y"==ComGetEtcData(arrXml[0],"mnl_bkg_no_flg")){
    	    			formObj.mnl_bkg_no_flg.checked=true;
    	    		} else {
    	    			formObj.mnl_bkg_no_flg.checked=false;					
    	    		}
    	    		oldPolYdCd=formObj.bkg_pol_cd.value + formObj.bkg_pol_yd_cd.value;
    	    		oldPodYdCd=formObj.bkg_pod_cd.value + formObj.bkg_pod_yd_cd.value;
    	    		ComSetObjValue(formObj.modify_flag, 			"N");
    	    		ComSetObjValue(formObj.cgo_dtl_auto_flg, 		"Y");
    	    		ComSetObjValue(formObj.carge_detail_pop, 		"Y");				
    	    		ComSetObjValue(formObj.partial_vvd_opened_flg, 	"N");
    	    		ComSetObjValue(formObj.route_modify_flag, 		"N");
    	    		ComSetObjValue(formObj.customer_modify_flag, 	"N");
    	    		ComSetObjValue(formObj.contact_modify_flag, 	"N");
    	    		ComSetObjValue(formObj.qty_modify_flag, 		"N");
    	    		ComSetObjValue(formObj.close_bkg_flag,			"N");
    	    		ComSetObjValue(formObj.cbf_bkg_flag,			"N");
    	    		manageHaveRouteFlag("Y");
    	    		if(ComGetObjValue(formObj.isInquiry) == "Y"){
    	    			setInquiryDisableButton();
    	    		}	
    	    		// C/A Btn Control
    	    		if(formObj.ca_new_creation_flag.value != "Y" && parent && parent.initCAControl){
    	    			parent.initCAControl(ComGetEtcData(arrXml[0], "bkg_no"), ComGetEtcData(arrXml[0], "ca_flg"), ComGetEtcData(arrXml[0], "bdr_flg"), ComGetEtcData(arrXml[0], "ca_exist_flg"), ComGetEtcData(arrXml[0], "bl_no"));
    	    		}
    	    		if(ComGetObjValue(formObj.ca_flg)=="Y"){
    	    			ComGetObject("bkg_no").className="input2";
    	    			ComGetObject("bl_no").className="input2";		
    	    		}
    	    		// Weight Code Setting
    	    		if(ComGetEtcData(arrXml[0],"wgt_ut_cd") != ""){
    	    			wgt_ut_cd.SetSelectCode(ComGetEtcData(arrXml[0],"wgt_ut_cd"));
    	    		}else{
    	    			wgt_ut_cd.SetSelectCode("KGS");
    	    		}

    	    		//Check Flex hgt check box
    	    		if(ComGetEtcData(arrXml[0], "flex_hgt_flg")== "Y"){
    	    			formObj.flex_hgt_flg.checked = true;
    	    		}

    	    		tmpPrecheckFlag = "";
    	    		formObj.sXml.value=null;

    	    		ComSetObjValue(formObj.modify_flag, "N");
    	    		ComOpenWait(false);

    	    		/* 메일 창 오픈 */
    	    		var oldBkgNo = ComGetObjValue(formObj.old_bkg_no);
    	    		var comCont  = document.form.com_content.value;
    	    		var endArr  = parseInt(0,10); 
    	    		var comContTmpList = "";
    	    		var comContList = "";

    	    		if(ComGetObjValue(formObj.mail_open_flag) == 'Y'){
    	    			//Input BKG No. for New Booking Creation with closed VVD 
    	    			if(oldBkgMailContents == "Y"){
    	    				document.form.com_subject.value = document.form.com_subject.value + formObj.bkg_no.value;
    	    				comCont = "BKG No : " + formObj.bkg_no.value + "<BR>"+ comCont;
    	    			}
    	    			//Remove last statements for Booking Creation ro change with closed VVD 
    	    			comContTmpList = comCont.split("<BR>");
    	    			for(var i = 0; i < comContTmpList.length; i++){
    	    				if(comContTmpList[i] == "<br><br>" ){
    	    					endArr = i-1;
    	    				}
    	    			}
    	    			for(var j = 0; j < parseInt(endArr,10); j++){
    	    				comContList = comContList + comContTmpList[j] + "<br>";
    	    			}
    	    			
    	    			document.form.com_content.value = comContList;
    	    			ComSendMail();
    	    			oldBkgMailContents = "N";
    	    			ComSetObjValue(formObj.mail_open_flag, "N");
    	    		}
    	    		
    	    		tooltipLoad('bkg_trunk_vvd', 'VVD', ComGetObjValue(formObj.bkg_trunk_vvd));
    	    		tooltipLoad('bkg_por_cd', 'POR', ComGetObjValue(formObj.bkg_por_cd) + ComGetObjValue(formObj.bkg_por_yd_cd));
    	    		tooltipLoad('bkg_pol_cd', 'POL', ComGetObjValue(formObj.bkg_pol_cd) + ComGetObjValue(formObj.bkg_pol_yd_cd));
    	    		tooltipLoad('bkg_pod_cd', 'POD', ComGetObjValue(formObj.bkg_pod_cd) + ComGetObjValue(formObj.bkg_pod_yd_cd));
    	    		tooltipLoad('bkg_del_cd', 'DEL', ComGetObjValue(formObj.bkg_del_cd) + ComGetObjValue(formObj.bkg_del_yd_cd));
    	    		
    	    		tooltipLoad('pre_rly_port_cd', 'PRE', ComGetObjValue(formObj.pre_rly_port_cd) + ComGetObjValue(formObj.pre_rly_port_yd_cd));
    	    		tooltipLoad('pre_vvd_cd', 'VVD', ComGetObjValue(formObj.pre_vvd_cd));
    	    		
    	    		tooltipLoad('pst_rly_port_cd', 'POST', ComGetObjValue(formObj.pst_rly_port_cd) + ComGetObjValue(formObj.pst_rly_port_yd_cd));
    	    		tooltipLoad('pst_vvd_cd', 'VVD', ComGetObjValue(formObj.pst_vvd_cd));
    	    		ComOpenWait(false);
    		    },
    		    error: function(xhr){ 
    		    	ComOpenWait(false);
    		    }
    		});
    		
    	}
    	
    	function waitChecked(){
    		var formObj = document.form;
    		formObj.modify_cargo_flg.value = 'Y';
    		
    		if(formObj.dcgo_flg.checked == true || formObj.rc_flg.checked == true || formObj.awk_cgo_flg.checked == true || formObj.bb_cgo_flg.checked == true || formObj.bkg_sts_cd.value != ""){
    			formObj.bkg_wt_chk_flg.disabled = true;
    		}else{
    			formObj.bkg_wt_chk_flg.disabled = false;
    		}
    		
    		if(formObj.bkg_sts_cd.value == "" && formObj.bkg_wt_chk_flg.disabled){
    			if((parent.eur_flg != 'Y' || formObj.bkg_sts_cd.value != "") && formObj.bkg_wt_chk_flg.checked)
    				formObj.edi_hld_flg.checked = false;
    			
    			formObj.bkg_wt_chk_flg.checked = false;
    		}
    		
    		if(parent.eur_flg != 'Y' || formObj.bkg_sts_cd.value != "") return;
    		
    		if(formObj.dcgo_flg.checked == true || formObj.rc_flg.checked == true || formObj.awk_cgo_flg.checked == true || formObj.bb_cgo_flg.checked == true || formObj.bkg_sts_cd.value != ""){
    			formObj.edi_hld_flg.checked = true;
    		}else{
    			if(!userEdiHldFlgCheck)
    				formObj.edi_hld_flg.checked = false;
    		}
    		
    		/* Auto EDI Hold 체크 여부 */
//    		ediHldFlgChecked();
    	}
    	
    	/**
    	 * Auto EDI Hold 체크 여부
    	 */
    	function ediHldFlgChecked(){
    		var formObj = document.form;
    		
    		if(parent.eur_flg != 'Y') return;
    		
    		/* Wait 체크 되어있는 상태인가 */
    		if(!userEdiHldFlgCheck){
    			formObj.edi_hld_flg.checked = formObj.bkg_wt_chk_flg.checked;
    		}
    	}
    	
    	/**
    	 * 사용자가 Auto EDI Hold 체크 하였을 경우 Wait 체크 및 Special Cargo 체크시에 edi_hld_flg 체크를 하지 않는다.
    	 */
    	function userCheck(){
    		var formObj = document.form;
    		userEdiHldFlgCheck = formObj.edi_hld_flg.checked;

    	}
    	
    	/**
    	 * 
    	 */
    	function comBkgCloseCallPop0092(){
    		var formObj = document.form;
    		if(formObj.bkg_trunk_vvd.value != ComGetObjValue(formObj.bkg_trunk_vvd_old) && ComGetObjValue(formObj.bkg_sts_cd) != ""){
    			for(var i = sheetObjects[1].LastRow(); i >= sheetObjects[1].HeaderRows(); i-- ){
        			if(formObj.bkg_trunk_vvd.value == sheetObjects[1].GetCellValue(i, "bkg_vvd_cd")){
        				sheetObjects[1].SetCellValue(i, "bkg_vvd_cd", ComGetObjValue(formObj.bkg_trunk_vvd_old));
        			}
        		}
    			formObj.bkg_trunk_vvd.value = ComGetObjValue(formObj.bkg_trunk_vvd_old);
    		}
    	}
    	
    	/**
    	 * 
    	 * @returns {String}
    	 */
    	function getSvcScpCd(){
    		return svcScpCd;
    	}
    	
    	/**
    	 * 
    	 * @param sheetObj
    	 * @param Row
    	 */
    	function checkCntrTpszCd(sheetObj, Row){
    		var cntrTpszCd = sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
    		
    		if(cntrTpszCd == '') return;
    		
    		var sXml = sheetObj.GetSearchData("ESM_BKG_0000_3GS.do?f_cmd=" + SEARCH13 + "&cntr_tpsz_cd=" + cntrTpszCd);
    		var count = ComGetEtcData(sXml, "count");
    		if(count == 0){
    			ComShowCodeMessage("BKG00062", cntrTpszCd);
    			sheetObj.SetCellValue(Row, "cntr_tpsz_cd", "");
    		}
    	}
    	
    	/**
    	 * 
    	 */
    	function toyotaClick(){
    		var formObj = document.form;
    		if(formObj.bkg_ty_flg.checked && formObj.bkg_sts_cd.value == ''){
    			if(!ComShowConfirm('Would you like to create Booking for For 10-digit BL No.?')) formObj.bkg_ty_flg.checked = 0;
    		}
    		else if(formObj.bkg_sts_cd.value != ''){
    			var checked = false;
    			var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do?f_cmd=" + SEARCH04, FormQueryString(formObj));
    			var check_seq = ComGetEtcData(sXml, "check_seq");
    			if(check_seq == '0'){
    				checkConfirm = true;
    			}
    			else if(check_seq == '1'){
    				ComShowMessage('Please remove charges for this BL.');
    			}
    			else if(check_seq == '2'){
    				ComShowMessage('Please cancel BL Issuance First.');
    			}
    			else if(check_seq == '3'){
    				ComShowMessage('Please remove the download data first in Customs Manifest.');
    			}
    			else if(check_seq == '4'){
    				ComShowMessage('The B/L has been already issued to Customer in INV module.');
    			}
    			else if(check_seq == '5'){
    				ComShowMessage('The DMT Invoice related to the B/L has already been issued.');
    			}
    			else if(check_seq == '6' && ComShowConfirm('There is DMT charge for the B/L. Please check after this work.')){
    				checkConfirm = true;
    			}
    			
    			if((formObj.bl_no.value.length == 10||formObj.bl_no.value.length == 11) && checkConfirm){
    				if(ComShowConfirm('Would you like to change For 10-digit BL No. to General B/L?')){
    					formObj.bl_no.value = formObj.bkg_no.value;
    					formObj.bl_no_ck.value = formObj.bkg_no.value;
    					formObj.bkg_ty_flg.checked = 0;
    				}else{
    					formObj.bkg_ty_flg.checked = 1;
    				}
    			}
    			else if(checkConfirm && (check_seq == '6' || check_seq == '0')){
        			/* 도요타 B/L 변경 */
        			if(formObj.bl_no.value.length == 12 || formObj.bl_no.value.length == 13){
        				checked = ComShowConfirm('Would you like to change General B/L to For 10-digit BL No.?');
        				if(checked){
        					var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do?f_cmd="+SEARCH03, null);
        					var toyota_bl_no = ComGetEtcData(sXml, "toyota_bl_no");
        					formObj.bl_no.value = toyota_bl_no;
        					formObj.bl_no_ck.value = toyota_bl_no;
        					
        				}
        			}else{
        				checked =  true;
        			}
        			
        			if(checked){
        				formObj.bkg_ty_flg.checked = 1;
        			}else{
        				formObj.bkg_ty_flg.checked = 0;
        			}
    			}
    			else{
    				if(formObj.bkg_ty_flg.checked) formObj.bkg_ty_flg.checked = 0;
    				else formObj.bkg_ty_flg.checked = 1;
    			}
    		}
    	}
    	

    	function tooltipLoad(obj_id, obj_type, value){
    		$("#" + obj_id).attr("title", "");
    		if(value == undefined || value == '') return;
    		if(obj_type == 'vvd' || obj_type == 'VVD'){
    			tooltipSearchAsync('ESM_Booking_UtilGS.do', 'f_cmd=' + SEARCH19 + '&vvd=' + value, obj_id, obj_type, tooltip);
    		}else{
    			if(value != undefined && value.length == 7)
    				tooltipSearchAsync('ESM_Booking_UtilGS.do', 'f_cmd=' + SEARCH20 + '&loc_cd=' + value, obj_id, obj_type, tooltip);
    		}
    	}

    	function tooltip(obj_id, obj_type, sXml){
    		var title = "";
    		if(obj_type == 'vvd' || obj_type == 'VVD'){
    			title = ComGetEtcData(sXml, "VSL_ENG_NM");
    		}else {
    			title = ComGetEtcData(sXml, "LOC_NM");
    		}
    		$("#" + obj_id).attr("title", title);
    	}

    	function tooltipSearchAsync(url, paeameters, obj_id, obj_type, callbackfunction){
    		$.ajax({
    		    type: "POST",
    		    url: url,
    		    async: true,
    		    dataType: "text",
    		    data: paeameters,
    		    success: function(data){
    		    	if(callbackfunction != undefined && callbackfunction != null)
    		    		callbackfunction(obj_id, obj_type, data);
    		    }
    		});
    	}
	/* Developer Work End */