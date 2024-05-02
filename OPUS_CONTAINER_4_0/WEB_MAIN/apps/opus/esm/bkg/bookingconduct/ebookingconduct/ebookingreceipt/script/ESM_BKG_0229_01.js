/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_01.js
*@FileTitle  : e-Booking & SI Process Detail(BOOKING) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	//var isPctlNoPop = "";
	var oldPolYdCd="";
	var oldPodYdCd="";
	var valYn="N";	
	/* 사용자가 Auto EDI Hold 체크 여부 */
	var userEdiHldFlgCheck = false;
	var eur_flg = null;
	var svcScpCd = "";
	var arrXml = null;
	var esdPrd0080 = false;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event handler processing by button name */
	function processButtonClick() {
		/** ***  Tab ->two or more sheet : sheet  a variable assignment **** */
		/** **************************************************** */
		var formObj=document.form;
		var bkgNo=formObj.bkg_no.value;
		var blNo=formObj.bl_no.value;
		var caFlg=formObj.ca_flg.value;
		var bkgTrunkVvd=formObj.bkg_trunk_vvd.value;
		var porCd=formObj.bkg_por_cd.value;
		var porYdCd=formObj.bkg_por_yd_cd.value;
		var polCd=formObj.bkg_pol_cd.value;
		var polYdCd=formObj.bkg_pol_yd_cd.value;
		var podCd=formObj.bkg_pod_cd.value;
		var podYdCd=formObj.bkg_pod_yd_cd.value;
		var delCd=formObj.bkg_del_cd.value;
		var delYdCd=formObj.bkg_del_yd_cd.value;
		var oldBkgNo=formObj.old_bkg_no.value;
		var sCustCntCd=formObj.s_cust_cnt_cd.value;
		var sCustSeq=formObj.s_cust_seq.value;
		var fCustCntCd=formObj.f_cust_cnt_cd.value;
		var fCustSeq=formObj.f_cust_seq.value;
		
		var bkgStsCd = ComGetObjValue(formObj.bkg_sts_cd);
		var lodgDueDt = ComGetObjValue(formObj.lodg_due_dt);
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			/** * Tab Main (S) ** */			
			case "btn_find_bkg":
				if(bkgNo == null){
					break;
				}
				doActionIBSheet(sheetObjects[0], document.form, SEARCH04);
				break;			
			case "btn_0019Pop": //vvd select
				if(sheetObjects[1].LastRow() > 2){
					var trunkRow=sheetObjects[2].FindText("vsl_pre_pst_cd","T");
					polCd=sheetObjects[2].GetCellValue(trunkRow, "pol_cd");
					podCd=sheetObjects[2].GetCellValue(trunkRow, "pod_cd");
				}
				comBkgCallPop0019('callBack0019', bkgTrunkVvd, polCd, podCd);
				break;
			case "btn_gotobkg":
				ComBkgCall0079(bkgNo);
				break;
			case "btn_0652ShprPop": 
				comBkgCallPop0652('callBack0652', 'S', sCustCntCd, sCustSeq, (ComIsNull(sCustSeq)?(formObj.s_cust_nm.value.substring(0,50)):""));
				break;
			case "btn_0652FwdrPop":
				comBkgCallPop0652('callBack0652', 'F', fCustCntCd, fCustSeq, (ComIsNull(fCustSeq)?(formObj.f_cust_nm.value.substring(0,50)):""));
				break;
			case "btn_t1RouteDetail": // route detail
				if (polCd != "") {
					
					var podClptIndSeq = null;
					var polClptIndSeq = null;
					
    				if(sheetObjects[2].RowCount() > 0){
    					podClptIndSeq = sheetObjects[2].GetCellValue(1, "pod_clpt_ind_seq");
    					polClptIndSeq = sheetObjects[2].GetCellValue(1, "pol_clpt_ind_seq");
    				}
    				
					if(sheetObjects[2].RowCount()< 2){
						if(sheetObjects[2].RowCount()< 1){
							sheetObjects[2].DataInsert(-1);
						}
						
						sheetObjects[2].SetCellValue(1, "vsl_pre_pst_cd","T");
    					sheetObjects[2].SetCellValue(1, "vsl_seq","0");
    					sheetObjects[2].SetCellValue(1, "pol_cd",polCd);
    					sheetObjects[2].SetCellValue(1, "pol_yd_cd",polYdCd);
    					sheetObjects[2].SetCellValue(1, "pod_cd",podCd);
    					sheetObjects[2].SetCellValue(1, "pod_yd_cd",podYdCd);
    					sheetObjects[2].SetCellValue(1, "bkg_vvd_cd",ComGetObjValue(formObj.bkg_trunk_vvd));
    					
//						sheetObjects[2].SetCellValue(1, "vsl_pre_pst_cd","T");
//						sheetObjects[1].SetCellValue(1, "vsl_seq","0");
//						sheetObjects[2].SetCellValue(1, "pol_cd",polCd);
//						sheetObjects[2].SetCellValue(1, "pol_yd_cd",polYdCd);
//						sheetObjects[2].SetCellValue(1, "pod_cd",podCd);
//						sheetObjects[2].SetCellValue(1, "pod_yd_cd",podYdCd);
//						if(bkgTrunkVvd.length==9){
//							sheetObjects[2].SetCellValue(1, "bkg_vvd_cd",bkgTrunkVvd);
//						}
					}
					comBkgCallPop0092("callBack0092", bkgNo, bkgTrunkVvd, caFlg, "2", podClptIndSeq, polClptIndSeq);
				} else {
					ComShowCodeMessage("BKG00136");
					ComSetFocus(formObj.bkg_pol_cd);
				}
				break;
			case "btn_allocation":
//				if(bkgTrunkVvd==null||bkgTrunkVvd.length<9){
//	   				ComShowCodeMessage("BKG00051", bkgTrunkVvd);		//VVD 9-digit check
//					ComSetFocus(formObj.bkg_trunk_vvd);
//					return;
//				}
				var usr_ofc_cd=formObj.usr_ofc_cd.value;					
				if(usr_ofc_cd==null||usr_ofc_cd.length<5){
					return;
				}
				var param="?pgmNo=ESM_SPC_0044";
				param=param + "&vvd="+bkgTrunkVvd + "&office=" + usr_ofc_cd;
	       		ComOpenWindowCenter("/opuscntr/ESM_SPC_0044.do"+param, "ESM_SPC_0044", 1024, 660, false, "yes");
				break;
			case "btn_0083PorPop":
				comBkgCallPop0083('callBack0083', 'POR', "", "", comboObjects[0].GetSelectCode());
				break;
			case "btn_0083PolPop":
				comBkgCallPop0083('callBack0083', 'POL', "", "", comboObjects[0].GetSelectCode());
				break;
			case "btn_0083PodPop":
				comBkgCallPop0083('callBack0083', 'POD', "", "", comboObjects[1].GetSelectCode());
				break;
			case "btn_0083DelPop":
				comBkgCallPop0083('callBack0083', 'DEL', "", "", comboObjects[1].GetSelectCode());
				break;
			case "btn_RfaNo":
				if(bkgTrunkVvd.length==9){
					comBkgCallPop0654('callBack0654', bkgNo, bkgTrunkVvd, porCd, delCd, sCustCntCd, sCustSeq, '', '',ComGetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd), ComGetObjValue(formObj.bkg_ctrl_pty_cust_seq),lodgDueDt,bkgStsCd);
				} else {
					comBkgCallPop0654('callBack0654', bkgNo, "", porCd, delCd, sCustCntCd, sCustSeq, '', '',ComGetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd), ComGetObjValue(formObj.bkg_ctrl_pty_cust_seq),lodgDueDt,bkgStsCd);
				}
				break;
			case "btn_ScNo":
				if(bkgTrunkVvd.length==9){
					comBkgCallPop0655('callBack0655', bkgNo, bkgTrunkVvd, porCd, delCd, sCustCntCd, sCustSeq, '', '',ComGetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd), ComGetObjValue(formObj.bkg_ctrl_pty_cust_seq),lodgDueDt,bkgStsCd);
				} else {
		    		comBkgCallPop0655('callBack0655', bkgNo, "", porCd, delCd, sCustCntCd, sCustSeq, '', '',ComGetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd), ComGetObjValue(formObj.bkg_ctrl_pty_cust_seq),lodgDueDt,bkgStsCd);
				}
	    		break;
	    	case "btn_TaaNo":
				if(bkgTrunkVvd.length==9){
					comBkgCallPop1062('callBack1062',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,'','','', '',lodgDueDt,bkgStsCd);
				} else {
					comBkgCallPop1062('callBack1062',bkgNo,"", porCd,delCd,sCustCntCd,sCustSeq,'','','','',lodgDueDt,bkgStsCd);
				}
	    		break;
			case "btn_0656CmdtPop":
	    		var rfaNo=ComGetObjValue(formObj.rfa_no);
	    		var scNo=ComGetObjValue(formObj.sc_no);
	    		var taaNo=ComGetObjValue(formObj.taa_no);
	    		var cmdtCd=ComGetObjValue(formObj.cmdt_cd);
	    		var repCmdtCd=ComGetObjValue(formObj.rep_cmdt_cd);
	    		if(bkgTrunkVvd.length!=9) bkgTrunkVvd=""; 
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
	    		if(formObj.ctrt_type[1].checked){
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
				break;
			case "btns_DoorDate":
				var cal=new ComCalendar();
				cal.select(formObj.mty_dor_arr_dt, 'yyyy-MM-dd');
				break;
			case "btns_LoadingDate":
				var cal=new ComCalendar();
				cal.select(formObj.lodg_due_dt, 'yyyy-MM-dd');
				break;
			case "btns_DeliveryDate":
				var cal=new ComCalendar();
				cal.select(formObj.de_due_dt, 'yyyy-MM-dd');
				break;
			case "btns_PkupDate":
				var cal=new ComCalendar();
				cal.select(formObj.mty_pkup_dt, 'yyyy-MM-dd');
				break;
			case "btn_0082MtyPkupYdCd":
				var mtyPkupYdCd;
				if (ComChkLen(formObj.mty_pkup_yd_cd.value, 7) == "2") {
					mtyPkupYdCd=formObj.mty_pkup_yd_cd.value;
				} else {
					mtyPkupYdCd=porCd + porYdCd;
				}
				comBkgCallPop0082('callBack0082', '0', mtyPkupYdCd);
				break;
			case "btn_0088FullRtnYdCd":
				var r0088;
				if (ComChkLen(formObj.full_rtn_yd_cd.value, 7) == "2") {
					r0088=formObj.full_rtn_yd_cd.value;
				} else {
					r0088=porCd + porYdCd;
				}
				comBkgCallPop0088('callBack0088', r0088);
				break;
			case "btn_CctPop":
				comBkgCallPop0721();
				break;
			case "btn_copyloc":
				document.all.btn_canceloc.style.display="";
				document.all.btn_copyloc.style.display="none";
				copyCopyLocation("Y");
				break;
			case "btn_canceloc":
				document.all.btn_canceloc.style.display="none";
				document.all.btn_copyloc.style.display="";
				copyCopyLocation("N");
				break;
			case "btn_contact":
				showBkCntc();
				break;
			case "btn_docRequirement":
				showBkgDocReq();
				break;
			case "btn_docRequirement2":
				showXterDocReq();
				break;
			//2015.03.09 kimtaekyun Reference No Button			
			case "btn_ref_bkg":
				showBkgRef();
				break;
				
			//2015.03.09 kimtaekyun Reference No Button			
			case "btn_ref_xter":
				showXterRef();
				break;
				
			/** * Tab Main (E) ** */
			case "btn_add":
				var Row=sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetRowStatus(Row,"I");
				ComSetObjValue(formObj.modify_flag, "Y");					
				manageHaveRouteFlag("N");
				break;
			case "btn_del":
				sheetObjects[0].RowDelete(sheetObjects[0].GetSelectRow(),false);
				disabledFH(sheetObjects[0], formObj);
				ComSetObjValue(formObj.qty_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");					
				manageHaveRouteFlag("N");
				break;
			case "btn_EqDetail":
				if(chkCntrTpSz()){
					comBkgCallPop0890("callBack0890","N");
				}
				break;    		
				
			case "btn_vessel":
				formObj.vsl_eng_nm.value = formObj.vsl_nm2.value;
				break;    
			}
			// end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag 
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	    for(var j=0; j<comboObjects.length; j++){
	        initCombo(comboObjects[j]);
	    }
	    	    
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	    
		initControl();
	}

	
	/**
	 * HTML Control on the page  loaded dynamically  the event. <br>
	 * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects array  sequence number
	 */
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerForm  ('click', 'bkg0229_01_click', formObj);  
		axon_event.addListener      ("click", "ctrtType_OnClick", "ctrt_type");
		//	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //When typing the keyboard
		//	axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm  ("change", "form_onChange", formObj);
		axon_event.addListenerForm  ('blur', 'bkg0229_01_deactivate', formObj); // - out focus
//		axon_event.addListenerForm('blur', 'bkg0229_01_activate', formObj); // - in  focus 
		applyShortcut();
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items  
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * The initial setting combo
	 * 
	 * @param {IBMultiCombo}
	 *            comboObj comboObj
	 */
	function initCombo(comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator("|");
		if (comboObj.options.id=="rcv_term_cd" ) {
			comboObj.SetDropHeight(250);
			comboObj.SetColWidth(0, "20");
			comboObj.SetColWidth(1, "80");
		} else if (comboObj.options.id=="de_term_cd" ) {
			comboObj.SetDropHeight(250);
			comboObj.SetColWidth(0, "20");
			comboObj.SetColWidth(1, "80");
		}
	}
	/**
	 * registering IBCombo Object as list
	 * 
	 * @param {IBMultiCombo}
	 *            combo_obj IBMultiCombo Object
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	 /**
	  * setting sheet initial values and header 
	  * param : sheetObj, sheetNo
	  * adding case as numbers of counting sheets
	  */
	 function initSheet(sheetObj, sheetNo) {
	 	var cnt=0;
	 	switch (sheetNo) {
	 	case 1: // t1sheet1 init  
	 	      with(sheetObj){
		         var HeadTitle="|Del.|TP/SZ|Vol.|EQ Sub(Incl. R/D)|EQ Sub(Incl. R/D)|EQ Sub(Incl. R/D)|SOC";
		         var prefix="sheet1_";
		         SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"eq_subst_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"eq_subst_cgo_qty",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rd_cgo_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"soc_qty",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_sgl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_dbl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_tpl_bar_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mer_hngr_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(120);
		 		 SetColProperty(0, 2, {AcceptKeys:"E|N", InputCaseSensitive:1});
		 		 SetColProperty(0, 4, {AcceptKeys:"E|N", InputCaseSensitive:1});
		 		 SetExtendLastCol(false);
              }
	 		break;
	 	case 2: // t1sheet2 init //eBkg qty
	 	    with(sheetObj){
		        var HeadTitle="|TP/SZ|Vol.|EQ Sub|EQ Sub|EQ Sub|SOC";
		        var prefix="sheet2_";
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cntr_qty",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"eq_subst_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"eq_subst_cgo_qty",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"soc_qty",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		         
		        InitColumns(cols);
     			SetEditable(0);
     			SetSheetHeight(120);
     			SetExtendLastCol(false);
            }
	 		break;
	 	case 3: // t1sheet3 init //bkg vvd
	 	    with(sheetObj){
			      var HeadTitle="|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq";
			      var prefix="sheet3_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vsl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"pol_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"pod_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"bkg_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(false);
	            }
	 		break;
	 	case 4: // t1sheet4  (BKG_QTY_DTL)
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
				SetVisible(false);
	            }
			break;
	 	case 5: // t1sheet5 init
	 	    with(sheetObj){
			      var HeadTitle="ibflag|rqst_no|rqst_seq|sender_id";
			      var prefix="sheet4_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rqst_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rqst_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sender_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(false);
	            }
			break;
	 	}
	 }
	//Sheet handling process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH:  
			var sXml=formObj.sXml.value;
			arrXml=sXml.split("|$$|");
			// RCV Term
			if (arrXml.length > 0) ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");		
			// DE Term
			if (arrXml.length > 1) ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");		
			// FRT Term
			if (arrXml.length > 2) ComBkgXml2ComboItem(arrXml[2], comboObjects[2], "val", "name");		
			// AMS Filer
			if (arrXml.length > 3) ComBkgXml2ComboItem(arrXml[3], comboObjects[3], "val", "name");	
			comboObjects[3].InsertItem(0,"","");	
			// CA Filer
			if (arrXml.length > 4) ComBkgXml2ComboItem(arrXml[4], comboObjects[4], "val", "name");	
			comboObjects[4].InsertItem(0,"","");	
			// Weight Unit
			if (arrXml.length > 5) ComBkgXml2ComboItem(arrXml[5], comboObjects[5], "val", "name");
			// XTER QTY
			if (arrXml.length > 6) {
				sheetObjects[1].RemoveAll();
				sheetObjects[1].LoadSearchData(arrXml[6],{Sync:1} );
			}
			// VSL SKD
			if (arrXml.length > 7) {
				sheetObjects[2].RemoveAll();
				sheetObjects[2].LoadSearchData(arrXml[7],{Sync:1} );
			}
			// QTY
			if (arrXml.length > 8) {
				sheetObjects[0].RemoveAll();
				sheetObjects[0].LoadSearchData(arrXml[8],{Sync:1} );
			}	
			// QTY DTL
			if (arrXml.length > 9) {
				sheetObjects[3].RemoveAll();
				sheetObjects[3].LoadSearchData(arrXml[9],{Sync:1} );
			}
			var rcvTermCd=(ComGetEtcData(arrXml[0], "rcv_term")!=null)?ComGetEtcData(arrXml[0], "rcv_term"):ComGetEtcData(arrXml[0], "rcv_term_cd");
			var deTermCd=(ComGetEtcData(arrXml[0], "de_term") !=null)?ComGetEtcData(arrXml[0], "de_term") :ComGetEtcData(arrXml[0], "de_term_cd");
			var bkgWtChkFlg = ComGetEtcData(arrXml[0], "bkg_wt_chk_flg");
			var irrBlNoFlg = ComGetEtcData(arrXml[0], "irr_bl_no_flg");
			
			if (ComIsNull(rcvTermCd)) rcvTermCd=formObj.dflt_rcv_term_cd.value;
			if (ComIsNull(deTermCd)) deTermCd=formObj.dflt_de_term_cd.value;
			comboObjects[0].SetSelectCode(rcvTermCd,false);
			comboObjects[1].SetSelectCode(deTermCd,false);
			comboObjects[2].SetSelectCode(ComGetEtcData(arrXml[0], "frt_term_cd"),false);
			comboObjects[3].SetSelectCode(ComGetEtcData(arrXml[0], "usa_cstms_file_cd"));
			comboObjects[4].SetSelectCode(ComGetEtcData(arrXml[0], "cnd_cstms_file_cd"));
			comboObjects[5].SetSelectCode(ComGetEtcData(arrXml[0], "wgt_ut_cd"));
			if (formObj.wgt_ut_cd.value == null) formObj.wgt_ut_cd.value=formObj.dflt_wgt_ut_cd.value;
			if ("null"!=arrXml[0]) {
				BkgEtcDataXmlToForm(arrXml[0], formObj);		 
				formObj.is_opus_null.value == ComGetEtcData(arrXml[0],"DataYn")=="Y"?"N":"Y";
			}
			if(sheetObjects[0].RowCount() == 0){ //sheetObjects[0].LastRow() == 1
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetCellValue(1, "op_cntr_qty",ComGetEtcData(arrXml[0], "cntr_tpsz_cd"),0);
			}
			if(ComGetEtcData(arrXml[0], "rcv_term") != "D") {
				formObj.mty_dor_arr_dt.disabled=true;
			}
			if(ComGetEtcData(arrXml[0], "is_vl_flg")=="Y"&&ComGetEtcData(arrXml[0], "bdr_flg")!="Y"){
				formObj.bkg_pol_cd.disabled=true;
				formObj.bkg_pod_cd.disabled=true;
				if(sheetObjects[1].LastRow() == 2){ 
					formObj.bkg_trunk_vvd.disabled=true;
				} else {
					formObj.bkg_trunk_vvd.disabled=false;						
				}
			} else {
				formObj.bkg_pol_cd.disabled=false;
				formObj.bkg_pod_cd.disabled=false;
				formObj.bkg_trunk_vvd.disabled=false;
			}
			if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_nm")) {
				document.all.bkg_cntc_pson_nm.value=document.all.tmp_bkg_cntc_pson_nm.value=ComGetEtcData(arrXml[0], "bkg_cntc_pson_nm");
			}
			if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_phn_no")) {
				document.all.bkg_cntc_pson_phn_no.value=document.all.tmp_bkg_cntc_pson_phn_no.value=ComGetEtcData(arrXml[0], "bkg_cntc_pson_phn_no");	
			}
			if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_mphn_no")) {
				document.all.bkg_cntc_pson_mphn_no.value=document.all.tmp_bkg_cntc_pson_mphn_no.value=ComGetEtcData(arrXml[0], "bkg_cntc_pson_mphn_no");
			}
			if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_fax_no")) {
				document.all.bkg_cntc_pson_fax_no.value=document.all.tmp_bkg_cntc_pson_fax_no.value=ComGetEtcData(arrXml[0], "bkg_cntc_pson_fax_no");
			}
			if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_eml")) {
				document.all.bkg_cntc_pson_eml.value=document.all.tmp_bkg_cntc_pson_eml.value=ComGetEtcData(arrXml[0], "bkg_cntc_pson_eml");
			}
			if (ComGetEtcData(arrXml[0], "si_cntc_pson_nm")) {
				document.all.si_cntc_pson_nm.value=document.all.tmp_si_cntc_pson_nm.value=ComGetEtcData(arrXml[0], "si_cntc_pson_nm");
			}
			if (ComGetEtcData(arrXml[0], "si_cntc_pson_phn_no")) {
				document.all.si_cntc_pson_phn_no.value=document.all.tmp_si_cntc_pson_phn_no.value=ComGetEtcData(arrXml[0], "si_cntc_pson_phn_no");	
			}
			if (ComGetEtcData(arrXml[0], "si_cntc_pson_mphn_no")) {
				document.all.si_cntc_pson_mphn_no.value=document.all.tmp_si_cntc_pson_mphn_no.value=ComGetEtcData(arrXml[0], "si_cntc_pson_mphn_no");
			}
			if (ComGetEtcData(arrXml[0], "si_cntc_pson_fax_no")) {
				document.all.si_cntc_pson_fax_no.value=document.all.tmp_si_cntc_pson_fax_no.value=ComGetEtcData(arrXml[0], "si_cntc_pson_fax_no");
			}
			if (ComGetEtcData(arrXml[0], "si_cntc_pson_eml")) {
				document.all.si_cntc_pson_eml.value=document.all.tmp_si_cntc_pson_eml.value=ComGetEtcData(arrXml[0], "si_cntc_pson_eml");
			}
			if(formObj.bdr_flg.value=="Y"){
				formObj.bkg_no.style.color="blue"
			} else {
				formObj.bkg_no.style.color="#606060";
			}	
			// searchVslSkdAvailable result-> Route Detail button change color
			changeObjectColor(formObj.vvd_flg, "N", "btn_t1RouteDetail", "red", "btn2");
			// searchRfaAvailable result-> RFA NO change color
			changeObjectColor(ComGetEtcData(arrXml[0], "rfa_available"), "N", "rfa_no", "red", "input");
			// searchScAvailable result-> SC NO change color
			changeObjectColor(ComGetEtcData(arrXml[0], "sc_available"), "N", "sc_no", "red", "input");
			// searchTaaAvailable result-> SC NO change color
			changeObjectColor(ComGetEtcData(arrXml[0], "taa_available"), "N", "taa_no", "red", "input");
			if("Y"==ComGetEtcData(arrXml[0], "xter_rqst_auto_ntc_flg")){
				formObj.auto_notification.checked=true;
				formObj.auto_notification.value="Y";
			} else {
				formObj.auto_notification.checked=false;
				formObj.auto_notification.value="N";
			}
			changeObjectColor(formObj.bkg_sts_cd.value, "X", "bkg_sts_cd", "red", "input");
			changeObjectColor(formObj.xter_bkg_rqst_sts_cd.value, "X", "xter_bkg_rqst_sts_cd", "red", "input");
			if (formObj.opus2.value != "Yes") { 
			} else {
				if (ComTrim(formObj.fnl_dest_nm2.value) != null && ComTrim(formObj.fnl_dest_nm2.value).length > 0) {
					formObj.fnl_dest_nm.value=formObj.fnl_dest_nm2.value.toUpperCase();
				}
				updateRoutStyle(formObj.fnl_dest_nm); 
			}
			formObj.act_wgt.value=makeComma(formObj.act_wgt.value);
			
			if (formObj.wgt_ut_cd.value == null || formObj.wgt_ut_cd.value == "") {
				if (formObj.estm_wgt_ut_cd2.value != null && formObj.estm_wgt_ut_cd2.value != "") {
					comboObjects[5].SetSelectCode(formObj.estm_wgt_ut_cd2.value);					
				}else{
					comboObjects[5].SetSelectCode(formObj.dflt_wgt_ut_cd.value);					
				}
			}
			//2015.01.22 수정
			//formObj.estm_wgt2.value=makeComma(formObj.estm_wgt2.value);
			formObj.act_wgt_old.value=formObj.act_wgt.value;
			if ( formObj.doc_tp_cd.value == "S" && parseFloat(formObj.estm_wgt2.value) != .0) {
				// Weight QTY
				formObj.act_wgt.value=formObj.estm_wgt2.value;
				form_setEstWgtQty(formObj.estm_wgt2.value);
			}
			
			if(formObj.doc_tp_cd.value == "S"){
				formObj.tmp_radio2.checked = true;
				changeCntcLayer(1);
			}
			
			// Freight Term: PREPAID OR COLLECT
			if (formObj.frt_term_cd2.value == "P" ||
				formObj.frt_term_cd2.value == "PREPAID") {
				comboObjects[2].SetSelectCode("P");
			}
			else if (formObj.frt_term_cd2.value == "C" ||
				formObj.frt_term_cd2.value == "COLLECT") {
				comboObjects[2].SetSelectCode("C");
			} else if(ComIsNull(ComGetObjValue(frt_term_cd))){
				comboObjects[2].SetSelectCode("P");
			}
			if (formObj.auto_notification2.value == "Yes") {
				formObj.auto_notification.checked=true;
				formObj.auto_notification.value="Y";
			} else {
				formObj.auto_notification.checked=false;
				formObj.auto_notification.value="N";
			}
			if (formObj.bkg_upld_sts_cd.value == "F"){
				formObj.bkg_sts_nm.style.color="blue";
			} else if (formObj.bkg_upld_sts_cd.value == "R"){
				formObj.bkg_sts_nm.style.color="red";
			}
			// Button Enable/Disable Control
			top.setBtnEnableSts("btn_opusupload", true);
			if (formObj.bkg_sts_cd.value == "X" ) {
				top.setBtnEnableSts("btn_opusupload", false);
			} else {
				if (formObj.bkg_upld_sts_cd.value == "N" ||
					formObj.bkg_upld_sts_cd.value == "P" ||
					ComIsNull(formObj.bkg_upld_sts_cd.value)) {
					top.setBtnEnableSts("btn_opusupload", true);
				} else {
					top.setBtnEnableSts("btn_opusupload", false);
				}
			}	
			if (formObj.bkg_upld_sts_cd.value == "F" ||
				formObj.bkg_upld_sts_cd.value == "R" ||
				formObj.bkg_upld_sts_cd.value == "D") {
				top.setBtnEnableSts("btn_reinstate", true);
			} else {
				top.setBtnEnableSts("btn_reinstate", false);
			}

			formObj.dcgo_flg.checked="Y"==ComGetEtcData(arrXml[0],"dcgo_flg");
			formObj.dcgo_flg.value=ComGetEtcData(arrXml[0],"dcgo_flg") ? "Y": "N";
			formObj.rc_flg.checked="Y"==ComGetEtcData(arrXml[0],"rc_flg");
			formObj.rc_flg.value=ComGetEtcData(arrXml[0],"rc_flg") ? "Y": "N";
			formObj.awk_cgo_flg.checked="Y"==ComGetEtcData(arrXml[0],"awk_cgo_flg");
			formObj.awk_cgo_flg.value=ComGetEtcData(arrXml[0],"awk_cgo_flg") ? "Y": "N";
			formObj.bb_cgo_flg.checked="Y"==ComGetEtcData(arrXml[0],"bb_cgo_flg");
			formObj.bb_cgo_flg.value=ComGetEtcData(arrXml[0],"bb_cgo_flg") ? "Y": "N";
			formObj.awk_cgo_flg.checked="Y"==ComGetEtcData(arrXml[0],"awk_cgo_flg");
			formObj.awk_cgo_flg.value=ComGetEtcData(arrXml[0],"awk_cgo_flg") ? "Y": "N";
			formObj.soc_flg.value=ComGetEtcData(arrXml[0],"soc_flg") ? "Y": "N";
			formObj.spcl_hide_flg.checked="Y"==ComGetEtcData(arrXml[0],"spcl_hide_flg");
			formObj.spcl_hide_flg.value=ComGetEtcData(arrXml[0],"spcl_hide_flg") ? "Y": "N";
			formObj.prct_flg.checked="Y"==ComGetEtcData(arrXml[0],"prct_flg");
			formObj.prct_flg.value=ComGetEtcData(arrXml[0],"prct_flg") ? "Y": "N";
			formObj.fd_grd_flg.checked="Y"==ComGetEtcData(arrXml[0],"fd_grd_flg");
			formObj.fd_grd_flg.value=ComGetEtcData(arrXml[0],"fd_grd_flg") ? "Y": "N";
			formObj.flex_hgt_flg.checked="Y"==ComGetEtcData(arrXml[0],"flex_hgt_flg");
			formObj.flex_hgt_flg.value=ComGetEtcData(arrXml[0],"flex_hgt_flg") ? "Y": "N";
			
			formObj.mnl_bkg_no_flg.checked="Y"==ComGetEtcData(arrXml[0],"mnl_bkg_no_flg");
			
			if(ComGetEtcData(arrXml[0],"edi_hld_flg") == "Y"){
				formObj.edi_hld_flg.checked = true;
			}
				
			
			if(bkgWtChkFlg == 'Y')
				formObj.bkg_wt_chk_flg.checked = true;
			else
				formObj.bkg_wt_chk_flg.checked = false;
			
			if(irrBlNoFlg == 'Y')
				formObj.bkg_ty_flg.checked = true;
			else
				formObj.bkg_ty_flg.checked = false;
			
			ctrtType_OnClick();
			if("WEB"==formObj.xter_rqst_via_cd.value) {
				formObj.copy_esvc.checked=true;
			}
			doCopyEsvc();
			
			// Ref No Copy
			doCopyRefNo();
			
			if(formObj.sh_cust_seq2.value!=null) ComSetObjValue(formObj.sh_cust_seq2, ComLpad(formObj.sh_cust_seq2,6,"0"));
			if(formObj.ff_cust_seq2.value!=null) ComSetObjValue(formObj.ff_cust_seq2, ComLpad(formObj.ff_cust_seq2,6,"0"));
			if(formObj.sh_cust_seq2.value=="000000") ComSetObjValue(formObj.sh_cust_seq2, "");
			if(formObj.ff_cust_seq2.value=="000000") ComSetObjValue(formObj.ff_cust_seq2, "");
			if(formObj.save_rf_flag.value  == "Y") formObj.rc_flg.value="Y";
			if(formObj.save_dg_flag.value  == "Y") formObj.dcgo_flg.value="Y";
			if(formObj.save_ak_flag.value  == "Y") formObj.awk_cgo_flg.value="Y";
			
			if(formObj.tro_pkup_dt.value!=null && formObj.tro_pkup_dt.value!= ""){
				ComSetObjValue(formObj.mty_pkup_dt, formObj.tro_pkup_dt.value);
			}else if(formObj.mty_pkup_dt2.value!=null && formObj.mty_pkup_dt2.value!= ""){
				ComSetObjValue(formObj.mty_pkup_dt, formObj.mty_pkup_dt2.value);
			}
			
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
		    if(!ComIsNull(formObj.old_bkg_no.value)){
		    	manageHaveRouteFlag("Y");
		    } else {
			  	ComSetObjValue(formObj.route_modify_flag, "Y");
		    	manageHaveRouteFlag("N");	    	
		    }
			top.document.form.tabload1.value="LOAD";
			compareItem();
			compareQty();
			var xter_doc="N";
			if (!ComIsNull(document.all.wy_bl_flg.innerHTML) ) {
				xter_doc="Y";
			} else if (!ComIsNull(document.all.incl_rt_bl_knt.innerHTML)) {
				xter_doc="Y";
			} else if (!ComIsNull(document.all.xcld_rt_bl_knt.innerHTML)) {
				xter_doc="Y";
			} else if (!ComIsNull(document.all.bl_iss_loc_cd.innerHTML)) {
				xter_doc="Y";
			} else if (!ComIsNull(document.all.bl_iss_dt.innerHTML)) {
				xter_doc="Y";
			}
			oldPolYdCd=formObj.bkg_pol_cd.value + formObj.bkg_pol_yd_cd.value;
			oldPodYdCd=formObj.bkg_pod_cd.value + formObj.bkg_pod_yd_cd.value;
			getBtnObject("btn_docRequirement2").style.color=(xter_doc=="Y")?"blue":"#737373";
			var vslNm=ComGetEtcData(arrXml[0], "vsl_nm");
			if (vslNm) {
				formObj.vsl_eng_nm.value=vslNm;
			}
			formObj.bl_prf_shpr_flg.value = ComGetEtcData(arrXml[0], "bl_prf_shpr_flg");
			
			if (formObj.cmdt_cd2.value == "" && formObj.cmdt_cd.value !="") {
				formObj.cmdt_cd2.value = formObj.cmdt_cd.value;
			}

			if (!ComIsNull(document.all.wy_bl_flg.innerHTML)) {
				formObj.copy_esvc_doc.checked = true;
				docReqCopyEsvc();
			}
			if (ComGetEtcData(arrXml[0], "xml_yn") == "Y") {
				parent.document.form.btn_xmlview.disabled=false;				
			}else{
				parent.document.form.btn_xmlview.disabled=true;
			}
			
			var sParam = "f_cmd=" + SEARCH12 + "&ofc_cd=" + formObj.usr_ofc_cd.value;
  	    	var eur_flg_xml = sheetObj.GetSaveData("ESM_Booking_UtilGS.do", sParam);
  	    	eur_flg = ComGetEtcData(eur_flg_xml, "eur_flg");
			
			
			if(formObj.bkg_sts_cd.value != ""){
				formObj.bkg_wt_chk_flg.disabled = true;
				formObj.mnl_bkg_no_flg.disabled = true;
			}
			/* Wait 활성화 여부 */
			//waitChecked();
			
			if(ComGetEtcData(arrXml[0], "auto_edi_hld_flg") == 'Y'){
				formObj.edi_hld_flg.checked = 1;
				userEdiHldFlgCheck = true;
			}
			
			break;
		case SEARCH04://btn_find_bkg		
			var sXml=formObj.sXml.value;
			var params="";
			formObj.f_cmd.value=SEARCH04;
			sheetObj.SetWaitImageVisible(false);
			var param="f_cmd="+SEARCH04+"&bkg_no="+formObj.bkg_no.value;
			sXml=sheetObj.GetSaveData("ESM_BKG_0229_01GS.do", param, false);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}		
			top.document.form.bkg_no.value=formObj.bkg_no.value;
			top.reloadPage();
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
		case IBSEARCH_ASYNC02://Reinstate
			return true;
			break;
		case COMMAND03://cancel
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
		case COMMAND01: 
			
			/* Status가 new이고 BKG No 있을경우 체크 */
			if(formObj.bkg_sts_cd.value == '' && !formObj.mnl_bkg_no_flg.checked && formObj.bkg_no.value.length > 0 && formObj.xter_rqst_via_cd.value != 'WEB'){
				ComShowMessage('This BKG No. is inputted without Manual tick. Please delete BKG No. or tick manual.');
				return false;
			}
			
			if(formObj.rqst_iss_plc_nm.value.length > 20){
				ComShowMessage('Doc Requirement Issue Place must be shorter than 20 characters long.');
				showBkgDocReq();
    			return false;
			}
			
			if(formObj.bl_no_ck.value != '' && (formObj.bl_no_ck.value != formObj.bl_no.value)){
				ComShowMessage("You can't change the number of B/L.");
    			return false;
    		}
			
			var vvdName = "";
			if(formObj.por_nm.value.length > 25){
				vvdName = "POR";
				ComSetFocus(formObj.por_nm);
			}else if(formObj.pol_nm.value.length > 25){
				vvdName = "POL";
				ComSetFocus(formObj.pol_nm);
			}else if(formObj.pod_nm.value.length > 25){
				vvdName = "POD";
				ComSetFocus(formObj.pod_nm);
			}else if(formObj.del_nm.value.length > 25){
				vvdName = "DEL";
				ComSetFocus(formObj.del_nm);
			}
			
			if(vvdName != ''){
				ComShowMessage(vvdName + ' name must be shorter than 25 characters long.');
				return false;
			}
			
			/*var searchSoStatusCheck = false;
			if(formObj.por_cd_old.value != "" && formObj.por_cd_old.value != formObj.bkg_por_cd.value){
				searchSoStatusCheck = true;
			}else if(formObj.pol_cd_old.value != "" && formObj.pol_cd_old.value != formObj.bkg_pol_cd.value){
				searchSoStatusCheck = true;
			}else if(formObj.rcv_term_cd_old.value != "" && formObj.rcv_term_cd_old.value != formObj.rcv_term_cd_text.value){
				searchSoStatusCheck = true;
			}
			
			 POR or POL or R/D Term 변경되었을 경우 호출 
			if(searchSoStatusCheck){
				var sXml = sheetObjects[0].GetSearchData("ESM_Booking_UtilGS.do?f_cmd=" + SEARCH15, FormQueryString(formObj));
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F'){
					ComShowMessage('S/O has been already issued. Please cancel S/O.');
					return false;
				}
			}*/
			
			if(parent.window.frames["t7frame"].form == undefined || parent.window.frames["t7frame"].form.cntr_seq__1 == undefined){}
			else if(parent.window.frames["t7frame"].form != undefined && (parent.window.frames["t7frame"].form.cntr_seq__1 != undefined && !formObj.rc_flg.checked)){
				ComShowMessage("There is an information in Reefer CGO. Please check Special cargo.");
				return false;
			}
			if(parent.window.frames["t8frame"].form == undefined || parent.window.frames["t8frame"].form.cntr_seq__1 == undefined){}
			else if(parent.window.frames["t8frame"].form != undefined && (parent.window.frames["t8frame"].form.cntr_seq__1 != undefined && !formObj.dcgo_flg.checked)){
				ComShowMessage("There is an information in Danger CGO. Please check Special cargo.");
				return false;
			}
			if(parent.window.frames["t9frame"].form == undefined || parent.window.frames["t9frame"].form.cntr_seq__1 == undefined){}
			else if(parent.window.frames["t9frame"].form != undefined && (parent.window.frames["t9frame"].form.cntr_seq__1 != undefined && !formObj.awk_cgo_flg.checked)){
				ComShowMessage("There is an information in Awkward CGO. Please check Special cargo.");
				return false;
			}
			acceptText();	
			var bkgNo=formObj.bkg_no.value;
			if(bkgNo != '' && bkgNo.length != 12){
				ComShowCodeMessage("BKG00255");
				return false;
			}
			
			
			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking 
				ComShowCodeMessage("BKG00005");
				return false;
			}
			if(ComGetObjValue(formObj.bkg_sts_nm) == "Confirm"){
				ComShowCodeMessage("BKG02049");
				return false;
			}
			if(!ComIsNull(formObj.xter_rqst_acpt_cd.value)){
				if("R" == formObj.xter_rqst_acpt_cd.value){//rejected
					ComShowCodeMessage("BKG02056",formObj.xter_rqst_acpt_usr_nm.value);
					return false;
				}
			}
			if(formObj.mnl_bkg_no_flg.value == "Y" && ComIsNull(formObj.old_bkg_no.value)){
				var mnlBkgNo=ComGetObjValue(formObj.bkg_no);
				if(mnlBkgNo.length != 10 && mnlBkgNo.length != 12){
					ComShowCodeMessage("BKG00255");
					ComSetFocus(formObj.bkg_no);
					return false; 
				}
			}  			
			if(!ComIsNull(formObj.old_bkg_no) && ComGetObjValue(formObj.old_bkg_no) != ComGetObjValue(formObj.bkg_no)){	
				ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
				return false;    				
			}
			if(ComIsNull(formObj.act_wgt.value)){
				ComShowCodeMessage("BKG00014");
				ComSetFocus(formObj.act_wgt);
				return false;			
			}
			if(parseFloat(ComGetObjValue(formObj.act_wgt),10) <= 0){	// Weight:'0'
				ComShowCodeMessage("BKG00014");
				ComSetFocus(formObj.act_wgt);
				return false;
			}
			if(ComIsNull(formObj.wgt_ut_cd.value)){
				ComShowCodeMessage("BKG00015");
				return false;			
			}
			var wgtUtCd=ComGetObjValue(wgt_ut_cd)
			if(ComTrim(wgtUtCd) == ""){							
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
				ComSetFocus(formObj.cmdt_desc);
				return false;    			    				
			}
			if(!validatePrecaution(formObj)){
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
			if(!ComIsNull(formObj.rfa_no)&&!ComIsNull(formObj.taa_no)){
				ComShowCodeMessage("BKG00016");    				
				return false;
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
					ComShowCodeMessage("BKG00293");	
					ComSetFocus(formObj.f_cust_seq);		
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
			for(i=1 ; i < sheetObjects[0].LastRow() + 1; i++){
				tpSz=sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd");
				if("D"==sheetObjects[0].GetRowStatus(i)){
					//continue;
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
			if(tpSzQ){
				ComShowCodeMessage("BKG01013");		// Q2, Q4, only input 
				return false;    	        	     				
			}
			if(ComChkLen(formObj.bkg_por_cd, 5) != 2){
				ComShowCodeMessage("BKG00006");		// Less than POR 5-digit input
				ComSetFocus(formObj.bkg_por_cd);
				return false;    	    				
			}
//			if(ComChkLen(formObj.bkg_pol_cd, 5) != 2){
//				ComShowCodeMessage("BKG00288");		// Less than POL 5-digit input
//				ComSetFocus(formObj.bkg_pol_cd);
//				return false;    	    				
//			}
			if(ComChkLen(formObj.bkg_del_cd, 5) != 2){
				ComShowCodeMessage("BKG00290");		// Less than DEL 5-digit input
				ComSetFocus(formObj.bkg_del_cd);
				return false;    	    				
			}    
			/* AMS Validation */
			if(ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="US" || ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="PR"){
				if(ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)!="CA"){
					var usaFile=ComGetObjValue(usa_cstms_file_cd)
					if(ComIsNull(usaFile) && ComChkLen(usaFile, 1) !=2 ){
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
			if(ComIsNull(formObj.pre_rly_port_cd) || ComIsNull(formObj.pst_rly_port_cd)){
				if(!ComIsNull(formObj.bkg_pol_cd) && !ComIsNull(formObj.bkg_pod_cd)){
					if(ComGetObjValue(formObj.bkg_pol_cd) == ComGetObjValue(formObj.bkg_pod_cd)){
						ComShowCodeMessage("BKG00053");		
						ComSetFocus(formObj.bkg_pol_cd);
						return false;    	    				    					
					}
				}
			}
			var rcvTerm=ComGetObjValue(rcv_term_cd);
			if(rcvTerm.length < 1){ 
				ComShowCodeMessage("BKG00908");		
				return false;    		    		
			}
			var delTerm=ComGetObjValue(de_term_cd);
			if(delTerm.length < 1){ 
				ComShowCodeMessage("BKG00909");		
				return false;    		    		
			}
//			if(!checkEgyptDeTerm(ComGetObjValue(formObj.bkg_del_cd))){
//				ComSetFocus(formObj.bkg_del_cd);
//				return false;		// DEL -> 'EGALY','EGPSD'  DLV Term <> 'O'
//			}    			
			rcvTerm=ComGetObjValue(rcv_term_cd);
			delTerm=ComGetObjValue(de_term_cd);
			if(sheetObjects[0].RowCount()== 1){
				if(parseFloat(sheetObjects[0].GetCellValue(1,"op_cntr_qty")) <= 1){
					if(rcvTerm == "M" || delTerm == "M"){
						ComShowCodeMessage("BKG00298");		
						return false;    	     					
					}    	    					
				}			
			}    			
			if(rcvTerm == "T" || rcvTerm == "I"){
				if(ComGetObjValue(formObj.bkg_por_cd) != ComGetObjValue(formObj.bkg_pol_cd)){
					ComShowCodeMessage("BKG00270");		// RCV Trackle,Free In -> POR,POL  is the same
					return false;      					
				}
			}
			if(delTerm == "T" || delTerm == "O"){
				if(ComGetObjValue(formObj.bkg_pod_cd) != ComGetObjValue(formObj.bkg_del_cd)){
					ComShowCodeMessage("BKG00271");		// DLV Trackle,Free In -> POD,DEL s the same
					return false;      					
				}
			}
//			if(sheetObjects[2].RowCount()> 0){
//				if(!ComIsNull(formObj.bkg_trunk_vvd.value) && formObj.bkg_trunk_vvd.value != sheetObjects[2].GetCellValue(sheetObjects[2].FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd")){
//					ComShowCodeMessage("BKG00022", ComGetObjValue(formObj.bkg_trunk_vvd));		
//					ComSetFocus(formObj.bkg_trunk_vvd);
//					return false;      		    				
//				}    			
//			}
//			for(i=1 ; i < sheetObjects[2].LastRow(); i++){ //sheetObjects[1].LastRow() this one is incorrect.
//				var bkgVvdCd = sheetObjects[2].GetCellValue(i, "bkg_vvd_cd");
//				bkgVvdCd = bkgVvdCd == -1 ? "" : bkgVvdCd;
//				if(!ComIsNull(bkgVvdCd) && ComChkLen(bkgVvdCd, 9) != 2){
//					ComShowCodeMessage("BKG00051", bkgVvdCd);		//VVD Check the 9-digit
//					ComSetFocus(formObj.bkg_trunk_vvd);
//					return false;       					
//				}
//			}
			if(ComIsNull(formObj.bkg_trunk_vvd)){
				if(ComIsNull(formObj.mty_dor_arr_dt) && ComIsNull(formObj.lodg_due_dt)){
					ComShowCodeMessage("BKG00017");
					ComSetFocus(formObj.lodg_due_dt);
					return false;      		    					
				}
			}
			else {
//				if(ComChkLen(formObj.bkg_trunk_vvd, 9) != 2){
//					ComShowCodeMessage("BKG00051", ComGetObjValue(formObj.bkg_trunk_vvd));		//VVD Check the 9-digit
//					ComSetFocus(formObj.bkg_trunk_vvd);
//					return false;      					
//				}
				var pseudoVvd=ComGetObjValue(formObj.bkg_trunk_vvd).substring(0,4);
				if(pseudoVvd == "HJXX" || pseudoVvd == "HJYY" || pseudoVvd == "HJZZ"){
					if(ComIsNull(formObj.mty_dor_arr_dt) && ComIsNull(formObj.lodg_due_dt)){
	    				ComShowCodeMessage("BKG00017");
						ComSetFocus(formObj.logd_due_dt);
	    				return false;      		    					
					}    					
				}    				
			}
			if (rfaNo.length < 1 && scNo.length < 1&& taaNo.length < 1){
				ComSetFocus(formObj.scNo);
				ComShowCodeMessage("BKG00016");		
				return false;    		    				
			}
			if((scNo.length>0   && scNo.substring(0,3) !="DUM")||
				(rfaNo.length>0 && rfaNo.substring(0,3)!="DUM")||
				(taaNo.length>0 && taaNo.substring(0,3)!="DUM")){
				if((scNo.length>0   && scNo.substring(0,3) =="DUM")||
					(rfaNo.length>0 && rfaNo.substring(0,3)=="DUM")||
					(taaNo.length>0 && taaNo.substring(0,3)=="DUM")){
					ComShowCodeMessage("BKG02050");
					return false;
				}
			}
			if(formObj.rc_flg.checked){	// Reefer=> 'R2',;R4','R5' presence.
				
				if((sheetObjects[0].FindText("cntr_tpsz_cd","R",0,0) < 0) && (sheetObjects[0].FindText("cntr_tpsz_cd","T2",0) < 0) && (sheetObjects[0].FindText("cntr_tpsz_cd","T4",0) < 0)){
					ComShowCodeMessage("BKG00054");
					return false;      	    					
				}
			}
			for(i=1 ; i < sheetObjects[0].LastRow() ; i++){
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
			if(ComIsNull(formObj.ob_srep_cd)){
				/**2015.03.03 임재관수석 요청에 의한 변경
				if(!ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){
					valYn = "Y";
					comBkgCallPop0652('callBack0652', 'F', formObj.f_cust_cnt_cd.value, formObj.f_cust_seq.value, (ComIsNull(formObj.f_cust_seq.value)?(formObj.f_cust_nm.value.substring(0,10)):""));
				} else {
					valYn = "Y";
					comBkgCallPop0652('callBack0652', 'S', formObj.s_cust_cnt_cd.value, formObj.s_cust_seq.value, (ComIsNull(formObj.s_cust_seq.value)?(formObj.s_cust_nm.value.substring(0,10)):""));
				}
				**/
				valYn = "Y";
				comBkgCallPop0652('callBack0652', 'S', formObj.s_cust_cnt_cd.value, formObj.s_cust_seq.value, (ComIsNull(formObj.s_cust_seq.value)?(formObj.s_cust_nm.value.substring(0,10)):""));
				
				if(ComIsNull(formObj.ob_sls_ofc_cd)){
					return false;
				}
			}
			if(ComChkLen(formObj.ob_srep_cd, 5) != 2){
				ComShowCodeMessage("BKG00044");		
				return false;    				
			}
			//vol detail  logic
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
					return false;
				}    				
			}
			for(var i = sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow() ; i++){
				var sumSingle = 0;
				var sumDouble = 0;
				var sumTriple = 0;
				var sumMer = 0;
				var eqSubVol = 0;
				var sumEqDtlVol = 0;
				
				for(var j=sheetObjects[3].HeaderRows(); j <= sheetObjects[3].RowCount(); j++){
					if(sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[3].GetCellValue(j, "cntr_tpsz_cd")){
						if(sheetObjects[3].GetCellValue(j, "crr_hngr_sgl_bar_use_flg") == 1){
							sumSingle = sumSingle + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
						}
						if(sheetObjects[3].GetCellValue(j, "crr_hngr_dbl_bar_use_flg") == 1){
							sumDouble = sumDouble + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
						}
						if(sheetObjects[3].GetCellValue(j, "crr_hngr_tpl_bar_use_flg") == 1){
							sumTriple = sumTriple + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
						}
						if(sheetObjects[3].GetCellValue(j, "mer_hngr_flg") == 1){
							sumMer = sumMer + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
						}				
						if(sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
							if(sheetObjects[0].GetCellValue(i, "eq_subst_cntr_tpsz_cd") == sheetObjects[3].GetCellValue(j, "eq_subst_cntr_tpsz_cd")){
								eqSubVol = eqSubVol + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
							}    							
						}
						sumEqDtlVol = sumEqDtlVol + BkgParseFloat(sheetObjects[3].GetCellValue(j, "op_cntr_qty"));
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
				
//				if(BkgParseFloat(sheetObjects[0].GetCellValue(i, "op_cntr_qty")) != sumEqDtlVol){
//					ComShowCodeMessage("BKG03009", sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"), sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd"));
//					comBkgCallPop0890("callBack0890","Y");
//					return false;    					
//				}    				
			}		    
				
			if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y" && ComGetObjValue(formObj.partial_vvd_opened_flg) != "Y" && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
				comBkgCallPop1024("callBack1024", bkgNo);
				if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y" && ComGetObjValue(formObj.partial_vvd_opened_flg) != "Y" && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
					return false;
				}
			}
			
			if(tpSzA){
				ComShowCodeMessage("BKG00304");		// A2, A4 exist        	     				
			}    	
//			if(delTerm == "S"){
//				if(rcvTerm == "Y" || rcvTerm == "D" || rcvTerm == "H"){
//					ComShowCodeMessage("BKG00302");		// RCV ->'Y','D','H' and  DLV ->'S'
//				}
//			}
			if(formObj.rc_flg.checked){
				if(rcvTerm != "Y" && delTerm != "Y"){
					ComShowCodeMessage("BKG00303");		
				}
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

			if(mainVol != subVol){
				formObj.btn_EqDetail.click();
				return false;
			}
			
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0229_01GS.do?f_cmd="+COMMAND04, FormQueryString(formObj));
			var black_cust_flag=ComGetEtcData(sXml, "black_cust_flag");
			var black_cust_list=ComGetEtcData(sXml, "black_cust_list");
			if(black_cust_flag == "Y"){
				if(!ComShowCodeConfirm("BKG02070", black_cust_list)){
					return false;
				}
			}
		}
		return true;
	}
	
	 function validateForUpload() {
		formObj = document.form;
	 	if (validateForm(sheetObjects[0], formObj, COMMAND01) == false){
	 		return false;	
	 	}
	 	var oldBkgNo = ComGetObjValue(formObj.old_bkg_no);
		var haveRouteFlag = ComGetObjValue(formObj.have_route_flag);
		var qtyModifyFlag = ComGetObjValue(formObj.qty_modify_flag);
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
		}
		else{
			var dcgo = formObj.dcgo_flg.checked==1?'Y':'N';
			var rc = formObj.rc_flg.checked==1?'Y':'N';
			var awk = formObj.awk_cgo_flg.checked==1?'Y':'N';
			var bb_cgo = formObj.bb_cgo_flg.checked==1?'Y':'N';
			if(!esdPrd0080 && formObj.bkg_sts_cd.value != '' && formObj.dcgo_flg_old.value != dcgo){
				IsPctlNoPop="YC";
			}else if(!esdPrd0080 && formObj.bkg_sts_cd.value != '' && formObj.rc_flg_old.value != rc){
				IsPctlNoPop="YC";
			}else if(!esdPrd0080 && formObj.bkg_sts_cd.value != '' && formObj.awk_cgo_flg_old.value != awk){
				IsPctlNoPop="YC";
			}else if(!esdPrd0080 && formObj.bkg_sts_cd.value != '' && formObj.bb_cgo_flg_old.value != bb_cgo){
				IsPctlNoPop="YC";
			}
		}
		if(IsPctlNoPop == "YC" || IsPctlNoPop == "YM"){
			if(createPctlNo()){
	 			return true;
			} else {
				return false;
			}
		}else{
			esdPrd0080 = false;
			return true;
		}
	 }
	 
	 function getSaveStringForUpload() {
	 	var formObj=document.form;
	 	var oldBkgNo=ComGetObjValue(formObj.old_bkg_no);
	 	var haveRouteFlag=ComGetObjValue(formObj.have_route_flag);
	 	var qtyModifyFlag=ComGetObjValue(formObj.qty_modify_flag);
	 	if(ComIsNull(oldBkgNo)){
	 		if(haveRouteFlag == "N"){
	 			ComSetObjValue(formObj.f_cmd, MULTI01);	// Create Without Route
	 			formObj.route_modify_flag.value="Y";
	 		}else{
	 			ComSetObjValue(formObj.f_cmd, MULTI02);	// Create With Route
	 			formObj.route_modify_flag.value="Y";
	 		}
	 	}else{
	 		if(haveRouteFlag == "N"){
	 			ComSetObjValue(formObj.f_cmd, MULTI03);	// Modify Without Route
	 			formObj.route_modify_flag.value="Y";
	 		}else{
	 			ComSetObjValue(formObj.f_cmd, MULTI04);	// Modify With Route
	 		}        			
	 	}		
	 	doCopyUpdateEsvc();
	 	//doCopySoc(); 왜사용하는지 모름 문제발생 함수
	 	var sXml=formObj.sXml.value;
	 	formObj.sXml.value="";
	 	
	 	ComSetObjValue(formObj.por_nm, chekcSpecialValue(ComGetObjValue(formObj.por_nm)));
	 	ComSetObjValue(formObj.pol_nm, chekcSpecialValue(ComGetObjValue(formObj.pol_nm)));
	 	ComSetObjValue(formObj.pod_nm, chekcSpecialValue(ComGetObjValue(formObj.pod_nm)));
	 	ComSetObjValue(formObj.del_nm, chekcSpecialValue(ComGetObjValue(formObj.del_nm)));
	 	
	 	ComSetObjValue(formObj.xter_rmk, chekcSpecialValue(ComGetObjValue(formObj.xter_rmk)));
	 	ComSetObjValue(formObj.inter_rmk, chekcSpecialValue(ComGetObjValue(formObj.inter_rmk)));
	 	
	 	var params=FormQueryString(formObj);
	 	formObj.sXml.value=sXml;
	 	params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_"); // Bkg qty
	 	params=params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true), "sheet3_"); // VVD
	 	params=params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true), "sheet5_"); // QTY dtl
	 	return params;
	 }
	/**
	* organizing the values in the screen to save - setting the values from the form to the grid 
	*/     
	function acceptText() {
		var formObj=document.form;
		var oldBkgNo=ComGetObjValue(formObj.old_bkg_no);
		// showing that Booking is created from the eBKG
		if (formObj.doc_tp_cd.value == "B" || ComIsNull(oldBkgNo)) {
			formObj.xter_bkg_rqst_cd.value=formObj.xter_rqst_via_cd.value;
			formObj.xter_bkg_rqst_ref_no.value=formObj.rqst_no2.value;
		}
		// showing that SI is uploaded from eSI
		if (formObj.doc_tp_cd.value == "S") {
			formObj.si_flg.value="Y";
			formObj.xter_si_cd.value=formObj.xter_rqst_via_cd.value;
			formObj.xter_si_ref_no.value=formObj.rqst_no2.value;	
		}
		// semoving the comma before sending the weight value to server
		ComSetObjValue(formObj.act_wgt, ComGetObjValue(formObj.act_wgt).replace(/,/g, ""));
	}
	
	function createPctlNo() {
		var formObj=document.form;
		var isPctlNoPop="";
		var oldBkgNo=ComGetObjValue(formObj.old_bkg_no);		
		if(ComIsNull(oldBkgNo)){
			isPctlNoPop="YC";
		} else {
			isPctlNoPop="YM";
		}
		if(isPctlNoPop == "YC" || isPctlNoPop == "YM") {
			var url;
			if(isPctlNoPop == "YC"){
				url="ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=B";
			}
			else if(isPctlNoPop == "YM"){
				url="ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=R";
				url=url + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
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
//			url=url + "&t_vvd=" + ComGetObjValue(formObj.bkg_trunk_vvd);
			url=url + "&t_vvd="
			for(i=1 ; i <= sheetObjects[2].LastRow(); i++){
				url=url + "&pol" + i + "="   + sheetObjects[2].GetCellValue(i, "pol_cd");
				if(sheetObjects[2].GetCellValue(i, "pol_yd_cd")!= null && sheetObjects[2].GetCellValue(i, "pol_yd_cd").length > 1)
					url=url + "&pol" + i + "_n=" + sheetObjects[2].GetCellValue(i, "pol_cd") + sheetObjects[2].GetCellValue(i, "pol_yd_cd");
				url=url + "&pod" + i + "="   + sheetObjects[2].GetCellValue(i, "pod_cd");
				if(sheetObjects[2].GetCellValue(i, "pod_yd_cd")!= null  && sheetObjects[2].GetCellValue(i, "pod_yd_cd").length > 1)
					url=url + "&pod" + i + "_n=" + sheetObjects[2].GetCellValue(i, "pod_cd") + sheetObjects[2].GetCellValue(i, "pod_yd_cd");
				url=url + "&vvd" + i + "="   + sheetObjects[2].GetCellValue(i, "bkg_vvd_cd");
			}
			url=url + "&rcv_t=" + ComGetObjValue(rcv_term_cd);
			url=url + "&del_t=" + ComGetObjValue(de_term_cd);
			url=url + "&shpr="  + ComGetObjValue(formObj.s_cust_cnt_cd)+ComGetObjValue(formObj.s_cust_seq);
			url=url + "&com="     + ComGetObjValue(formObj.cmdt_cd);
			url=url + "&rep_com=" + ComGetObjValue(formObj.rep_cmdt_cd);
			url=url + "&wgt="     + ComGetObjValue(formObj.act_wgt).replace(/,/g, "");
			url=url + "&wgt_un="  + ComGetObjValue(wgt_ut_cd);
			url=url + "&bkg_ofc=" + ComGetObjValue(formObj.bkg_ofc_cd);
			url=url + "&org_sal_ofc=" + ComGetObjValue(formObj.ob_sls_ofc_cd);
			url=url + "&m_pu="  + ComGetObjValue(formObj.mty_pkup_yd_cd);
			url=url + "&f_rt="  + ComGetObjValue(formObj.full_rtn_yd_cd);
			url=url + "&ld_dt=" + changeDateFormat(ComGetObjValue(formObj.lodg_due_dt));
			url=url + "&dr_dt=" + changeDateFormat(ComGetObjValue(formObj.de_due_dt));
			url=url + "&org_trns_mode="  + changeTransMode(ComGetObjValue(formObj.org_trns_mod_cd));
			url=url + "&dest_trns_mode=" + changeTransMode(ComGetObjValue(formObj.dest_trns_mod_cd));
			if(!ComIsNull(ComGetObjValue(formObj.rfa_no))){
				url=url + "&rfa=" + ComGetObjValue(formObj.rfa_no);//ComGetObjValue(formObj.rfa_no1)+ComGetObjValue(formObj.rfa_no2);
			}
			if(!ComIsNull(ComGetObjValue(formObj.sc_no))){
				url=url + "&sc=" + ComGetObjValue(formObj.sc_no);//ComGetObjValue(formObj.sc_no1)+ComGetObjValue(formObj.sc_no2);
			}
			for(i=1 ; i <= sheetObjects[0].LastRow() ; i++){
				url=url + "&c_tpsz="+sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd");
				url=url + "&c_qty="+sheetObjects[0].GetCellValue(i, "op_cntr_qty");
			}
			url=url + "&cgo_tp=F";
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
			url=url + "&rd_f="  + ComGetObjValue(formObj.rd_cgo_flg);
			url=url + "&hg_f="  + ComGetObjValue(formObj.hngr_flg);
			url=url + "&soc_f=" + ComGetObjValue(formObj.soc_flg);
			url=url + "&sub_f=" + ComGetObjValue(formObj.eq_subst_flg);
			url=url + "&pm_f="  + ComGetObjValue(formObj.premium_available_flg);
			formObj.prd_params.value=url;
			ComSetObjValue(formObj.pctl_no, "");
			ComOpenPopup(url, 1100, 690, "callBackEsdPrd0080",	"1,0,1,1,1", true);
			if(ComIsNull(formObj.pctl_no.value)){
			} else {
	 	    	manageHaveRouteFlag("Y");
				return true;
			}			 		
		}
	}
	/**
	 * Showing save button to the red color in case of being called from p/c
	 */      
	function manageHaveRouteFlag(haveRouteFlg){
		var formObj=document.form;
		ComSetObjValue(formObj.have_route_flag, haveRouteFlg);
		if (haveRouteFlg == "N"){
			ComSetObjValue(formObj.pctl_no, "");
			top.setBtnColor("btn_opusupload", "red");
		} else {
			top.setBtnColor("btn_opusupload", "black");
		}
	}
	/**
	 * copying the e-svc data to opus in case of not existing the Booking information in OPUS
	 */
	function doDataCopy() {
		var formObj=document.form;
		if (formObj.rqst_no2.value != '') {
			formObj.bkg_no.value=top.document.form.bkg_no.value;
//			if(formObj.bl_no_ctnt2.value.length>4 && formObj.bl_no_ctnt2.value.substring(0,4)== "OPUS"){
//				formObj.bl_no.value=formObj.bl_no_ctnt2.value.substring(4);
//			} else {
//				formObj.bl_no.value=formObj.bl_no_ctnt2.value;
//			}
			if ( formObj.sh_cnt_cd2.value.length > 0 )
				form_setShprCustCntCd(formObj.sh_cnt_cd2.value);
			if (parseInt(formObj.sh_cust_seq2.value, 10) > 0)
				form_setShprCustSeq(formObj.sh_cust_seq2.value);
			formObj.s_cust_nm.value=formObj.sh_cust_nm2.value.toUpperCase();
			if ( formObj.ff_cnt_cd2.value.length > 0 )
				form_setFwdrCustCntCd(formObj.ff_cnt_cd2.value);
			if (parseInt(formObj.ff_cust_seq2.value, 10) > 0)
				form_setFwdrCustSeq(formObj.ff_cust_seq2.value);
			formObj.f_cust_nm.value=formObj.ff_cust_nm2.value.toUpperCase();
			if(ComIsNull(formObj.s_cust_cnt_cd) && ComIsNull(formObj.s_cust_seq)){
				if(formObj.ff_cnt_cd2.value.length != "" && formObj.ff_cnt_cd2.value.length != null && formObj.ff_cnt_cd2.value.length > 0 && parseInt(formObj.ff_cust_seq2.value, 10) > 0){
					//form_setShprCustCntCd(ComGetObjValue(formObj.f_cust_cnt_cd));
		    		//form_setShprCustSeq(ComGetObjValue(formObj.f_cust_seq));
		    		//ComSetObjValue(formObj.s_cust_nm, ComGetObjValue(formObj.f_cust_nm));
				}
			}
//			formObj.bkg_trunk_vvd.value=formObj.vvd2.value;
//			formObj.vsl_eng_nm.value=formObj.vsl_nm2.value.toUpperCase();
			formObj.bkg_por_cd.value=ComTrim(formObj.bkg_por_cd2.value);
			formObj.por_nm.value=ComTrim(formObj.por_nm2.value);
			formObj.bkg_pod_cd.value=ComTrim(formObj.bkg_pod_cd2.value);
			formObj.pod_nm.value=ComTrim(formObj.pod_nm2.value);
			formObj.bkg_pol_cd.value=ComTrim(formObj.bkg_pol_cd2.value);
			formObj.pol_nm.value=ComTrim(formObj.pol_nm2.value);
			formObj.bkg_del_cd.value=ComTrim(formObj.bkg_del_cd2.value);
			formObj.del_nm.value=ComTrim(formObj.del_nm2.value);
			formObj.fnl_dest_nm.value=formObj.fnl_dest_nm2.value.toUpperCase();
			// Receiving Term
			if (formObj.rcv_term2.value == "Door") 
				comboObjects[0].SetSelectCode("D",false);
			else if (formObj.rcv_term2.value == "CY")
				comboObjects[0].SetSelectCode("Y",false);
			else if (formObj.rcv_term2.value == "CFS")
				comboObjects[0].SetSelectCode("S",false);
			else if (formObj.rcv_term2.value == "Tackle")
				comboObjects[0].SetSelectCode("T",false);
			else if (formObj.rcv_term2.value == "Free In")
				comboObjects[0].SetSelectCode("I",false);
			else if (formObj.rcv_term2.value == "Mixed")
				comboObjects[0].SetSelectCode("M",false);
			// Delivery Term
			if (formObj.dlv_term2.value == "Door") 
				comboObjects[1].SetSelectCode("D",false);
			else if (formObj.dlv_term2.value == "CY")
				comboObjects[1].SetSelectCode("Y",false);
			else if (formObj.dlv_term2.value == "CFS")
				comboObjects[1].SetSelectCode("S",false);
			else if (formObj.dlv_term2.value == "Tackle")
				comboObjects[1].SetSelectCode("T",false);
			else if (formObj.dlv_term2.value == "Free Out")
				comboObjects[1].SetSelectCode("O",false);
			else if (formObj.dlv_term2.value == "Mixed")
				comboObjects[1].SetSelectCode("M",false);
			
			if(formObj.sc_rfa.value=="SC"){
				formObj.sc_no.value = formObj.ctrt_no2.value;
				if(formObj.ctrt_no2.value != "")
					searchBkgCtrlPtyCust("sc_no=" + formObj.ctrt_no2.value);
			} else {
				formObj.rfa_no.value = formObj.ctrt_no2.value;
				if(formObj.ctrt_no2.value != "")
					searchBkgCtrlPtyCust("rfa_no=" + formObj.ctrt_no2.value);
			}
			ctrtType_OnClick();
			formObj.twn_so_no.value=formObj.twn_so_no2.value;
			formObj.cmdt_cd.value=formObj.cmdt_cd2.value;
			formObj.cmdt_desc.value=formObj.cmdt_desc2.value;
			if (formObj.usa_cstms_file_ctnt2.value == "Carrier Filing NVOCC") {
				comboObjects[3].SetSelectCode("1");
			}
			else if (formObj.usa_cstms_file_ctnt2.value == "Self Filing NVO") {
				comboObjects[3].SetSelectCode("2");
			}
			else if (formObj.usa_cstms_file_ctnt2.value == "Not Applicable") {
				comboObjects[3].SetSelectCode("3");
			}
			else {
				comboObjects[3].SetSelectCode(formObj.usa_cstms_file_ctnt2.value);
			}
			if (formObj.cnd_cstms_file_cd2.value == "Carrier Filing NVOCC") {
				comboObjects[4].SetSelectCode("1");
			}
			else if (formObj.cnd_cstms_file_cd2.value == "Self Filing NVO") {
				comboObjects[4].SetSelectCode("2");
			}
			else if (formObj.cnd_cstms_file_cd2.value == "Not Applicable") {
				comboObjects[4].SetSelectCode("3");
			}
			else {
				comboObjects[4].SetSelectCode(formObj.cnd_cstms_file_cd2.value);
			}
			// Copying SCAC No
			formObj.scac_cd.value=ComTrim(formObj.scac_cd2.value);
			// Weight QTY
			if (parseFloat(formObj.estm_wgt2.value) != .0) {
				formObj.act_wgt.value=formObj.estm_wgt2.value;
				form_setEstWgtQty(formObj.estm_wgt2.value);
			}else if(parseFloat(formObj.net_wgt.value) != .0) {
				formObj.act_wgt.value = formObj.net_wgt.value;
				form_setEstWgtQty(formObj.estm_wgt2.value);
			}
			// Weight Unit
			if (formObj.estm_wgt_ut_cd2.value == null ||
				formObj.estm_wgt_ut_cd2.value == "" ||
				formObj.estm_wgt2.value == null ||
				formObj.estm_wgt2.value == "" ||
				parseFloat(formObj.estm_wgt2.value) == .0) {
				comboObjects[5].SetSelectCode(formObj.dflt_wgt_ut_cd.value);
			}
			else {
				comboObjects[5].SetSelectCode(formObj.estm_wgt_ut_cd2.value);
			}
			if (formObj.dcgo_flg2.checked) 		formObj.dcgo_flg.checked=1;
			if (formObj.rc_flg2.checked)    	formObj.rc_flg.checked=1;
			if (formObj.awk_cgo_flg2.checked) 	formObj.awk_cgo_flg.checked=1;
			if (formObj.bb_cgo_flg2.checked) 	formObj.bb_cgo_flg.checked=1;
			if (formObj.soc_flg2.checked) 		formObj.soc_flg.checked=1;
			formObj.mty_dor_arr_dt.value=formObj.return_dt2.value;
			formObj.lodg_due_dt.value=formObj.departure_dt2.value;
			formObj.de_due_dt.value=formObj.arrival_dt2.value;
			formObj.xter_rmk.value=formObj.rmk2.value;	
			
			if(formObj.tro_pkup_dt.value!=null && formObj.tro_pkup_dt.value!= ""){
				ComSetObjValue(formObj.mty_pkup_dt, formObj.tro_pkup_dt.value);
			}else{
				ComSetObjValue(formObj.mty_pkup_dt, formObj.mty_pkup_dt2.value);
			}
			
			document.all.bkg_cntc_pson_nm_span.innerHTML=document.all.bkg_cntc_pson_nm.value=formObj.cntc_nm2.value;
			document.all.bkg_cntc_pson_phn_no_span.innerHTML=document.all.bkg_cntc_pson_phn_no.value=formObj.tel2.value;
			document.all.bkg_cntc_pson_mphn_no_span.innerHTML=document.all.bkg_cntc_pson_mphn_no.value=formObj.mobile2.value;
			document.all.bkg_cntc_pson_fax_no_span.innerHTML=document.all.bkg_cntc_pson_fax_no.value=formObj.fax2.value;
			document.all.bkg_cntc_pson_eml_span.innerHTML=document.all.bkg_cntc_pson_eml.value=formObj.cntc_eml2.value;
			if (formObj.auto_notification2.value == "Yes") {
				formObj.auto_notification.checked=true;
				formObj.auto_notification.value="Y";
			} 
			if (sheetObjects[1].GetTotalRows()> 0) {
				sheetObjects[0].RemoveAll();
				for ( var i=1; i <= sheetObjects[1].GetTotalRows(); i++) {
					sheetObjects[0].DataInsert(-1);
					sheetObjects[0].SetCellValue(i, 0,sheetObjects[1].GetCellValue(i, 0));
					sheetObjects[0].SetCellValue(i, 2,sheetObjects[1].GetCellValue(i, 1));
					sheetObjects[0].SetCellValue(i, 3,sheetObjects[1].GetCellValue(i, 2));
					sheetObjects[0].SetCellValue(i, 4,sheetObjects[1].GetCellValue(i, 3));
					sheetObjects[0].SetCellValue(i, 5,sheetObjects[1].GetCellValue(i, 4));
					sheetObjects[0].SetCellValue(i, 7,sheetObjects[1].GetCellValue(i, 6));
				}
			}
			doCopyEsvc();
			
			// Ref No Copy
			doCopyRefNo();
			
			compareQty();
			ComSetObjValue(formObj.modify_flag, 			"Y");
	    	ComSetObjValue(formObj.route_modify_flag, 		"Y");
	    	ComSetObjValue(formObj.customer_modify_flag, 	"Y");
	    	ComSetObjValue(formObj.contact_modify_flag, 	"Y");
		    ComSetObjValue(formObj.qty_modify_flag, 		"Y");
		    manageHaveRouteFlag("N");
		}  
		/* Wait 활성화 체크 */
		waitChecked();
	}
	// Getting the location of eSVC
	function copyCopyLocation(copyOpt) {
		var formObj=document.form;
		var formObj2=document.form2;
		if (copyOpt == "Y") {
			formObj2.bkg_por_cd.value=formObj.bkg_por_cd.value;
			formObj2.por_nm.value=formObj.por_nm.value;
			formObj2.bkg_pol_cd.value=formObj.bkg_pol_cd.value;
			formObj2.pol_nm.value=formObj.pol_nm.value;
			formObj2.bkg_pod_cd.value=formObj.bkg_pod_cd.value;
			formObj2.pod_nm.value=formObj.pod_nm.value;
			formObj2.bkg_del_cd.value=formObj.bkg_del_cd.value;
			formObj2.del_nm.value=formObj.del_nm.value;
			if (formObj.incl_code.checked) {
				formObj.bkg_por_cd.value=formObj.bkg_por_cd2.value;
				formObj.por_nm.value=formObj.por_nm2.value;
				formObj.bkg_pol_cd.value=formObj.bkg_pol_cd2.value;
				formObj.pol_nm.value=formObj.pol_nm2.value;
				formObj.bkg_pod_cd.value=formObj.bkg_pod_cd2.value;
				formObj.pod_nm.value=formObj.pod_nm2.value;
				formObj.bkg_del_cd.value=formObj.bkg_del_cd2.value;
				formObj.del_nm.value=formObj.del_nm2.value;
				
				var route_modify = false;
				if(ComGetObjValue(formObj.por_yd_cd_old) != formObj.bkg_por_cd.value){
					route_modify = true;
				}else if(ComGetObjValue(formObj.pol_cd_old) != formObj.bkg_pol_cd.value){
					route_modify = true;
				}else if(ComGetObjValue(formObj.pod_cd_old) != formObj.bkg_pod_cd.value){
					route_modify = true;
				}else if(ComGetObjValue(formObj.del_cd_old) != formObj.bkg_del_cd.value){
					route_modify = true;
				}
				if(route_modify){
					ComSetObjValue(formObj.route_modify_flag,"Y");
		    		ComSetObjValue(formObj.modify_flag,"Y");
		 	    	manageHaveRouteFlag("N");
				}
				
			} else {
				formObj.por_nm.value=formObj.por_nm2.value;
				formObj.pol_nm.value=formObj.pol_nm2.value;
				formObj.pod_nm.value=formObj.pod_nm2.value;
				formObj.del_nm.value=formObj.del_nm2.value;
			}
		} else {
			formObj.bkg_por_cd.value=formObj2.bkg_por_cd.value;
			formObj.por_nm.value=formObj2.por_nm.value;
			formObj.bkg_pol_cd.value=formObj2.bkg_pol_cd.value;
			formObj.pol_nm.value=formObj2.pol_nm.value;
			formObj.bkg_pod_cd.value=formObj2.bkg_pod_cd.value;
			formObj.pod_nm.value=formObj2.pod_nm.value;
			formObj.bkg_del_cd.value=formObj2.bkg_del_cd.value;
			formObj.del_nm.value=formObj2.del_nm.value;
		}
	}
	//getting the contact person
	function doCopyEsvc() {
	    var formObj=document.form;
	    if (formObj.copy_esvc.checked) {
	    	document.all.bkg_cntc_pson_nm_span.innerHTML=formObj.bkg_cntc_pson_nm.value=""==formObj.cntc_nm2.value     ? formObj.bkg_cntc_pson_nm.value      : formObj.cntc_nm2.value    ;
	        document.all.bkg_cntc_pson_phn_no_span.innerHTML=formObj.bkg_cntc_pson_phn_no.value=""==formObj.tel2.value         ? formObj.bkg_cntc_pson_phn_no.value  : formObj.tel2.value        ;
	        document.all.bkg_cntc_pson_mphn_no_span.innerHTML=formObj.bkg_cntc_pson_mphn_no.value=""==formObj.mobile2.value      ? formObj.bkg_cntc_pson_mphn_no.value : formObj.mobile2.value     ;
	        document.all.bkg_cntc_pson_fax_no_span.innerHTML=formObj.bkg_cntc_pson_fax_no.value=""==formObj.fax2.value         ? formObj.bkg_cntc_pson_fax_no.value  : formObj.fax2.value        ;
	        document.all.bkg_cntc_pson_eml_span.innerHTML=formObj.bkg_cntc_pson_eml.value=""==formObj.cntc_eml2.value    ? formObj.bkg_cntc_pson_eml.value     : formObj.cntc_eml2.value   ;
	        document.all.si_cntc_pson_nm_span.innerHTML=formObj.si_cntc_pson_nm.value=""==formObj.si_cntc_nm2.value  ? formObj.si_cntc_pson_nm.value      : formObj.si_cntc_nm2.value ;
	        document.all.si_cntc_pson_phn_no_span.innerHTML=formObj.si_cntc_pson_phn_no.value=""==formObj.si_tel2.value      ? formObj.si_cntc_pson_phn_no.value  : formObj.si_tel2.value     ;
	        document.all.si_cntc_pson_mphn_no_span.innerHTML=formObj.si_cntc_pson_mphn_no.value=""==formObj.si_mobile2.value   ? formObj.si_cntc_pson_mphn_no.value : formObj.si_mobile2.value  ;
	        document.all.si_cntc_pson_fax_no_span.innerHTML=formObj.si_cntc_pson_fax_no.value=""==formObj.si_fax2.value      ? formObj.si_cntc_pson_fax_no.value  : formObj.si_fax2.value     ;
	        document.all.si_cntc_pson_eml_span.innerHTML=formObj.si_cntc_pson_eml.value=""==formObj.si_cntc_eml2.value ? formObj.si_cntc_pson_eml.value     : formObj.si_cntc_eml2.value;
	        ComSetObjValue(formObj.contact_modify_flag, "Y");
	    } else {
	        document.all.bkg_cntc_pson_nm_span.innerHTML=formObj.bkg_cntc_pson_nm.value=formObj.tmp_bkg_cntc_pson_nm.value     ;
	        document.all.bkg_cntc_pson_phn_no_span.innerHTML=formObj.bkg_cntc_pson_phn_no.value=formObj.tmp_bkg_cntc_pson_phn_no.value ;
	        document.all.bkg_cntc_pson_mphn_no_span.innerHTML=formObj.bkg_cntc_pson_mphn_no.value=formObj.tmp_bkg_cntc_pson_mphn_no.value;
	        document.all.bkg_cntc_pson_fax_no_span.innerHTML=formObj.bkg_cntc_pson_fax_no.value=formObj.tmp_bkg_cntc_pson_fax_no.value ;
	        document.all.bkg_cntc_pson_eml_span.innerHTML=formObj.bkg_cntc_pson_eml.value=formObj.tmp_bkg_cntc_pson_eml.value    ;
	        document.all.si_cntc_pson_nm_span.innerHTML=formObj.si_cntc_pson_nm.value=formObj.tmp_si_cntc_pson_nm.value      ;
	        document.all.si_cntc_pson_phn_no_span.innerHTML=formObj.si_cntc_pson_phn_no.value=formObj.tmp_si_cntc_pson_phn_no.value  ;
	        document.all.si_cntc_pson_mphn_no_span.innerHTML=formObj.si_cntc_pson_mphn_no.value=formObj.tmp_si_cntc_pson_mphn_no.value ;
	        document.all.si_cntc_pson_fax_no_span.innerHTML=formObj.si_cntc_pson_fax_no.value=formObj.tmp_si_cntc_pson_fax_no.value  ;
	        document.all.si_cntc_pson_eml_span.innerHTML=formObj.si_cntc_pson_eml.value=formObj.tmp_si_cntc_pson_eml.value     ;
	        ComSetObjValue(formObj.contact_modify_flag, "N");
	    }
	}
	
	//Ref No. Copy
	function doCopyRefNo() {
		
		var bkg_doc = "N";	
		var formObj = document.form;
		if (formObj.bkg_upld_sts_cd.value == "N" || formObj.bkg_upld_sts_cd.value == "P" || ComIsNull(formObj.bkg_upld_sts_cd.value)) {
			if (formObj.xter_inv_ref_no.value != "") {
				formObj.inv_ref_no.value = formObj.xter_inv_ref_no.value;
				bkg_doc = "Y";
			} else {
				formObj.inv_ref_no.value = formObj.bkg_inv_ref_no.value;
			}
			
			if (formObj.xter_bkg_ref_no.value != "") {
				formObj.bkg_ref_no.value = formObj.xter_bkg_ref_no.value;
				bkg_doc = "Y";
			} else {
				formObj.bkg_ref_no.value = formObj.bkg_bkg_ref_no.value;
			}
			
			if (formObj.xter_bkg_sh_ref_no.value != "") {
				formObj.bkg_sh_ref_no.value = formObj.xter_bkg_sh_ref_no.value;
				bkg_doc = "Y";
			} else {
				formObj.bkg_sh_ref_no.value = formObj.bkg_bkg_sh_ref_no.value;
			}
			
			if (formObj.xter_bkg_ff_ref_no.value != "") {
				formObj.bkg_ff_ref_no.value = formObj.xter_bkg_ff_ref_no.value;
				bkg_doc = "Y";
			} else {
				formObj.bkg_ff_ref_no.value = formObj.bkg_bkg_ff_ref_no.value;
			}
			
			if (formObj.xter_si_reference_no.value != "") {
				formObj.si_ref_no.value = formObj.xter_si_reference_no.value;
				bkg_doc = "Y";
			} else {
				formObj.si_ref_no.value =  formObj.bkg_si_ref_no.value;
			}
			
			if (formObj.xter_si_sh_ref_no.value != "") {
				formObj.si_sh_ref_no.value = formObj.xter_si_sh_ref_no.value;
				bkg_doc = "Y";
			} else {
				formObj.si_sh_ref_no.value = formObj.bkg_si_sh_ref_no.value;
			}
			
			if (formObj.xter_si_ff_ref_no.value != "") {
				formObj.si_ff_ref_no.value = formObj.xter_si_ff_ref_no.value;
				bkg_doc = "Y";
			} else {
				formObj.si_ff_ref_no.value = formObj.bkg_si_ff_ref_no.value;
			}
			
			if (formObj.xter_reg_bkg_no.value != "") {
				formObj.reg_bkg_no.value = formObj.xter_reg_bkg_no.value;
				bkg_doc = "Y";
			} else {
				formObj.reg_bkg_no.value = formObj.bkg_reg_bkg_no.value;
			}
			
			if (formObj.xter_ext_mrn_no.value != "") {
				formObj.ext_mrn_no.value = formObj.xter_ext_mrn_no.value;
				bkg_doc = "Y";
			} else {
				formObj.ext_mrn_no.value = formObj.bkg_ext_mrn_no.value;
			}
			
			document.getElementById("btn_ref_xter").style.cssText = (bkg_doc=="Y")?"color:blue !important;font-weight:normal;":"color:#737373 !important;font-weight:normal;";
			document.getElementById("btn_ref_bkg").style.cssText = (bkg_doc=="Y")?"color:blue !important;font-weight:normal;":"color:#737373 !important;font-weight:normal;";
		} 
		
		
	}	
	//getting Soc Flg value
	function doCopySoc() {
	 	var formObj=document.form;
		var socCnt=0;
		for(i=1 ; i < sheetObjects[0].RowCount() ; i++){
			if( sheetObjects[0].GetCellValue(i, "soc_qty" ) 
					!= null && sheetObjects[0].GetCellValue(i, "soc_qty" ) 
					!= "" && sheetObjects[0].GetCellValue(i, "soc_qty" ) > 0 ){
					socCnt++;
				}
		}
		if(socCnt > 0){
			formObj.soc_flg.value="Y";	
			formObj.soc_flg.checked=1;
		}else{
			formObj.soc_flg.value="N";
			formObj.soc_flg.checked=0;
		}
	}
	//copying the values of the contact person to the form
	function doCopyUpdateEsvc() {
		var formObj=document.form;
		formObj.bkg_cntc_pson_nm.value=document.all.bkg_cntc_pson_nm_span.innerHTML;
		formObj.bkg_cntc_pson_phn_no.value=document.all.bkg_cntc_pson_phn_no_span.innerHTML;
		formObj.bkg_cntc_pson_mphn_no.value=document.all.bkg_cntc_pson_mphn_no_span.innerHTML;
		formObj.bkg_cntc_pson_fax_no.value=document.all.bkg_cntc_pson_fax_no_span.innerHTML;
		formObj.bkg_cntc_pson_eml.value=document.all.bkg_cntc_pson_eml_span.innerHTML;
		formObj.si_cntc_pson_nm.value=document.all.si_cntc_pson_nm_span.innerHTML;
		formObj.si_cntc_pson_phn_no.value=document.all.si_cntc_pson_phn_no_span.innerHTML;
		formObj.si_cntc_pson_mphn_no.value=document.all.si_cntc_pson_mphn_no_span.innerHTML;
		formObj.si_cntc_pson_fax_no.value=document.all.si_cntc_pson_fax_no_span.innerHTML;
		formObj.si_cntc_pson_eml.value=document.all.si_cntc_pson_eml_span.innerHTML;
	}
	//getting the value of the contact person
	function autoNotification() {
		var formObj=document.form;
		if (formObj.auto_notification.checked) {
			formObj.auto_notification.value="Y";
		} else {
			formObj.auto_notification.value="N";
		}
	}
	//getting Doc Requirement
	function docReqCopyEsvc() {
		var bkg_doc="N";
		var formObj=document.form;
		if (formObj.copy_esvc_doc.checked) {
			if (!ComIsNull(document.all.wy_bl_flg.innerHTML) ) {
//				if ( document.all.wy_bl_flg.innerHTML == "WayBill" ) {
				if ( document.all.wy_bl_flg.innerHTML == "W" ) {
					document.all.rqst_bl_tp_cd.value="W";
					document.all.rqst_bl_tp_cd1.checked=true;
//				} else if ( document.all.wy_bl_flg.innerHTML == "O.B/L" ) {
				} else if ( document.all.wy_bl_flg.innerHTML == "O" ) {
					document.all.rqst_bl_tp_cd.value="O";
					document.all.rqst_bl_tp_cd2.checked=true;
				} else if ( document.all.wy_bl_flg.innerHTML == "S" ) {
					document.all.rqst_bl_tp_cd.value="S";
					document.all.rqst_bl_tp_cd3.checked=true;
				}
				bkg_doc="Y";
			}
			if (!ComIsNull(document.all.incl_rt_bl_knt.innerHTML)) {
				document.all.obl_rt_incl_knt.value=document.all.incl_rt_bl_knt.innerHTML;
				bkg_doc="Y";
			}
			if (!ComIsNull(document.all.xcld_rt_bl_knt.innerHTML)) {
				document.all.obl_rt_xcld_knt.value=document.all.xcld_rt_bl_knt.innerHTML;
				bkg_doc="Y";
			}
			if (!ComIsNull(document.all.bl_iss_loc_cd.innerHTML)) {
				document.all.rqst_iss_plc_nm.value=document.all.bl_iss_loc_cd.innerHTML;
				bkg_doc="Y";
			}
			if (!ComIsNull(document.all.bl_iss_dt.innerHTML)) {
				document.all.rqst_iss_dt.value=document.all.bl_iss_dt.innerHTML;
				bkg_doc="Y";
			}
			if (!ComIsNull(document.all.non_nego_rt_incl_knt2.innerHTML)) {
				document.all.non_nego_rt_incl_knt.value = document.all.non_nego_rt_incl_knt2.innerHTML;
				bkg_doc = "Y";
			}
			if (!ComIsNull(document.all.non_nego_rt_xcld_knt2.innerHTML)) {
				document.all.non_nego_rt_xcld_knt.value = document.all.non_nego_rt_xcld_knt2.innerHTML;
				bkg_doc = "Y";
			}		
			if (!ComIsNull(document.all.bl_cluz_desc.innerHTML)) {
				document.all.bl_doc_rqst_rmk.value = document.all.bl_cluz_desc.innerHTML;
				bkg_doc = "Y";
			}		
		} else {
			document.all.rqst_bl_tp_cd1.checked=false;
			document.all.rqst_bl_tp_cd2.checked=false;
			document.all.rqst_bl_tp_cd3.checked=false;
			if ( formObj.rqst_bl_tp_cd_old.value == "O"  ) 
				document.all.rqst_bl_tp_cd2.checked=true;
			else if ( formObj.rqst_bl_tp_cd_old.value == "W"  ) 
				document.all.rqst_bl_tp_cd1.checked=true;
			else if ( formObj.rqst_bl_tp_cd_old.value == "S"  ) 
				document.all.rqst_bl_tp_cd3.checked=true;
			document.all.rqst_bl_tp_cd.value=formObj.rqst_bl_tp_cd_old.value;
			document.all.obl_rt_incl_knt.value=formObj.obl_rt_incl_knt_old.value;
			document.all.obl_rt_xcld_knt.value=formObj.obl_rt_xcld_knt_old.value;
			document.all.rqst_iss_plc_nm.value=formObj.rqst_iss_plc_nm_old.value;
			document.all.rqst_iss_dt.value=formObj.rqst_iss_dt_old.value;
			
			document.all.non_nego_rt_incl_knt.value = formObj.non_nego_rt_incl_knt_old.value;
			document.all.non_nego_rt_xcld_knt.value = formObj.non_nego_rt_xcld_knt_old.value;
			
		}
		document.getElementById("btn_docRequirement").style.cssText = (bkg_doc=="Y")?"color:blue !important;font-weight:normal;":"color:#737373 !important;font-weight:normal;";
//		getBtnObject("btn_docRequirement").style.color=(bkg_doc=="Y")?"blue":"#737373";
	}
	
	function compareItem() {
		var formObj=document.form;
		if (!ComIsEmpty(formObj.act_wgt) && formObj.act_wgt.value!=formObj.estm_wgt2.value){
			formObj.act_wgt.style.color="Red"; 
			formObj.estm_wgt2.style.color="Red";
		} else {
			formObj.act_wgt.style.color="#606060";
			formObj.estm_wgt2.style.color="#606060";
		}	
		if (!ComIsEmpty(rcv_term_cd.GetSelectText()) && rcv_term_cd.GetSelectText()!= formObj.rcv_term2.value){
			rcv_term_cd.SetFontColor("Red");
			formObj.rcv_term2.style.color="Red";
		} else {
			rcv_term_cd.SetFontColor("#606060");
			formObj.rcv_term2.style.color="#606060";
		}
		if (!ComIsEmpty(de_term_cd.GetSelectText()) && de_term_cd.GetSelectText()!= formObj.dlv_term2.value){
			de_term_cd.SetFontColor("Red");
			formObj.dlv_term2.style.color="Red";
		} else {
			de_term_cd.SetFontColor("#606060");
			formObj.dlv_term2.style.color="#606060";
		}
		if (!ComIsEmpty(frt_term_cd.GetSelectText()) && frt_term_cd.GetSelectText().substring(0,1) != formObj.frt_term_cd2.value.substring(0,1)){
			frt_term_cd.SetFontColor("Red");
			formObj.frt_term_cd2.style.color="Red";
		} else {
			frt_term_cd.SetFontColor("#606060");
			formObj.frt_term_cd2.style.color="#606060";		
		}
		if (!ComIsEmpty(formObj.lodg_due_dt) && formObj.lodg_due_dt.value!=formObj.departure_dt2.value){
			formObj.lodg_due_dt.style.color="Red"; 
			formObj.departure_dt2.style.color="Red";
		} else {
			formObj.lodg_due_dt.style.color="#606060";
			formObj.departure_dt2.style.color="#606060";
		}	
		if (!ComIsEmpty(formObj.de_due_dt) && formObj.de_due_dt.value!=formObj.arrival_dt2.value){
			formObj.de_due_dt.style.color="Red"; 
			formObj.arrival_dt2.style.color="Red";
		} else {
			formObj.de_due_dt.style.color="#606060";
			formObj.arrival_dt2.style.color="#606060";
		}	
		if (!ComIsEmpty(formObj.mty_pkup_dt) && formObj.mty_pkup_dt.value!=formObj.mty_pkup_dt2.value){
			formObj.mty_pkup_dt.style.color="Red"; 
			formObj.mty_pkup_dt2.style.color="Red";
		} else {
			formObj.mty_pkup_dt.style.color="#606060";
			formObj.mty_pkup_dt2.style.color="#606060";
		}	
		setDiffCheckColor(formObj.s_cust_cnt_cd.value, 	formObj.sh_cnt_cd2.value, 		("sh_cnt_cd2"));
		setDiffCheckColor(formObj.s_cust_seq.value, 	formObj.sh_cust_seq2.value, 	("sh_cust_seq2"));
		setDiffCheckColor(formObj.s_cust_nm.value, 		formObj.sh_cust_nm2.value, 		("sh_cust_nm2"));
		setDiffCheckColor(formObj.f_cust_cnt_cd.value, 	formObj.ff_cnt_cd2.value, 		("ff_cnt_cd2"));
		setDiffCheckColor(formObj.f_cust_seq.value, 	formObj.ff_cust_seq2.value, 	("ff_cust_seq2"));
		setDiffCheckColor(formObj.f_cust_nm.value, 		formObj.ff_cust_nm2.value, 		("ff_cust_nm2"));
		setDiffCheckColor(formObj.ob_srep_cd.value,		formObj.srep_cd2.value,			("srep_cd2"));
//		setDiffCheckColor(formObj.bkg_trunk_vvd.value, 	formObj.vvd2.value, 			("vvd2"));
		setDiffCheckColor(formObj.vsl_eng_nm.value, 	formObj.vsl_nm2.value, 			("vsl_nm2"));
		setDiffCheckColor(formObj.bkg_por_cd.value, 	formObj.bkg_por_cd2.value, 		("bkg_por_cd2"));
		setDiffCheckColor(formObj.bkg_pol_cd.value, 	formObj.bkg_pol_cd2.value, 		("bkg_pol_cd2"));
		setDiffCheckColor(formObj.bkg_pod_cd.value, 	formObj.bkg_pod_cd2.value, 		("bkg_pod_cd2"));
		setDiffCheckColor(formObj.bkg_del_cd.value, 	formObj.bkg_del_cd2.value, 		("bkg_del_cd2"));
		setDiffCheckColor(formObj.por_nm.value, 		formObj.por_nm2.value, 			("por_nm2"));
		setDiffCheckColor(formObj.pol_nm.value, 		formObj.pol_nm2.value, 			("pol_nm2"));
		setDiffCheckColor(formObj.pod_nm.value, 		formObj.pod_nm2.value, 			("pod_nm2"));
		setDiffCheckColor(formObj.del_nm.value, 		formObj.del_nm2.value, 			("del_nm2"));
		setDiffCheckColor(formObj.fnl_dest_nm.value, 	formObj.fnl_dest_nm2.value, 	("fnl_dest_nm2"));
		setDiffCheckColor(formObj.twn_so_no.value, 		formObj.twn_so_no2.value, 		("twn_so_no2"));
		setDiffCheckColor(formObj.wgt_ut_cd.value, 		formObj.estm_wgt_ut_cd2.value, 	("estm_wgt_ut_cd2"));
		setDiffCheckColor(formObj.xter_rmk.value, 		formObj.rmk2.value, 			("rmk2"));
		
		var porCd=parent.frames["t1frame"].form.bkg_por_cd.value;
		if(ComIsNull(formObj.s_cust_cnt_cd.value) && !ComIsNull(porCd)){
			ComSetObjValue(formObj.s_cust_cnt_cd, porCd.substring(0,2));
		}			
		
		if(formObj.sc_no.value!=null){
			setDiffCheckColor(formObj.sc_no.value, 		formObj.ctrt_no2.value, 		("ctrt_no2"));
		}
		if(formObj.rfa_no.value!=null){
			setDiffCheckColor(formObj.rfa_no.value, 	formObj.ctrt_no2.value, 		("ctrt_no2"));
		}
	}
	function compareQty(){
		var formObj=document.form;
		var opusQtySheet=sheetObjects[0];
		var esvcQtySheet=sheetObjects[1];
		var sameTypeSize=false;
//		for(var i=1; i < opusQtySheet.RowCount()+1; i++){
//			sameTypeSize=false;
//			for(var j=1; j < esvcQtySheet.RowCount()+1; j++){
//				if(opusQtySheet.GetCellValue(i, "cntr_tpsz_cd") == esvcQtySheet.GetCellValue(j, "cntr_tpsz_cd")){
//					sameTypeSize=true;
//					if(opusQtySheet.GetCellValue(i, "op_cntr_qty") != esvcQtySheet.GetCellValue(j, "cntr_qty")){
//						opusQtySheet.SetCellFontColor(i, "op_cntr_qty","#FF0000");
//						esvcQtySheet.SetCellFontColor(j, "cntr_qty","#FF0000");
//					} else{
//						opusQtySheet.SetCellFontColor(i, "op_cntr_qty","#000000");
//						esvcQtySheet.SetCellFontColor(j, "cntr_qty","#000000");
//					}
//				}
//				if(sameTypeSize == false){
//					//opusQtySheet.SetCellFontColor(i, 2,"#FF0000");
//					//opusQtySheet.SetCellFontColor(i, 3,"#FF0000");
//				} 
//			 }
//			
//		}	
//		esvcQtySheet.SelectCell(0,1);
		for(var j=1; j < esvcQtySheet.RowCount()+1; j++){
			sameTypeSize=false;
			for(var i=1; i < opusQtySheet.RowCount()+1; i++){
				if(opusQtySheet.GetCellValue(i, "cntr_tpsz_cd") == esvcQtySheet.GetCellValue(j, "cntr_tpsz_cd")){
					sameTypeSize=true;
					if(opusQtySheet.GetCellValue(i, "op_cntr_qty") != esvcQtySheet.GetCellValue(j, "cntr_qty")){
						opusQtySheet.SetCellFontColor(i, "op_cntr_qty","#FF0000");
						esvcQtySheet.SetCellFontColor(j, "cntr_qty","#FF0000");
					} else{
						opusQtySheet.SetCellFontColor(i, "op_cntr_qty","#000000");
						esvcQtySheet.SetCellFontColor(j, "cntr_qty","#000000");
					}
					if(opusQtySheet.GetCellValue(i, "soc_qty") != esvcQtySheet.GetCellValue(j, "soc_qty")){
						opusQtySheet.SetCellFontColor(i, "soc_qty","#FF0000");
						esvcQtySheet.SetCellFontColor(j, "soc_qty","#FF0000");
					} else{
						opusQtySheet.SetCellFontColor(i, "soc_qty","#000000");
						esvcQtySheet.SetCellFontColor(j, "soc_qty","#000000");
					}
				}else{
					opusQtySheet.SetCellFontColor(i, "op_cntr_qty","#000000");
					esvcQtySheet.SetCellFontColor(j, "cntr_qty","#000000");					
					opusQtySheet.SetCellFontColor(i, "soc_qty","#000000");
					esvcQtySheet.SetCellFontColor(j, "soc_qty","#000000");
				}
			 }
			if(sameTypeSize == false){
				esvcQtySheet.SetCellFontColor(j, "cntr_tpsz_cd","#FF0000");
			}else{
				esvcQtySheet.SetCellFontColor(j, "cntr_tpsz_cd","#000000");				
			}
			
		}	
		esvcQtySheet.SelectCell(0,1);
		
	}
	/**
	 * in case of being mouseover event
	 */
	function bkg0229_01_activate() {
		// Input Validation to check
		switch (ComGetEvent("name")) {
		case "mty_dor_arr_dt":
			ComClearSeparator(ComGetEvent());
			break;
		case "lodg_due_dt":
			ComClearSeparator(ComGetEvent());
			break;
		case "de_due_dt":
			ComClearSeparator(ComGetEvent());
			break;
		case "mty_pkup_dt":
			ComClearSeparator(ComGetEvent());
			break;
		default:
			event.srcElement.onfocus=new Function("this.select()");
			break;
		}
	}
	/**
	 * in case of being mouseout event
	 */
	function bkg0229_01_deactivate() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		var srcMaxLength=ComGetEvent("maxlength");
		var srcValue=ComGetEvent("value");
		if (srcName == "bkg_no"){
			if(ComIsNull(srcValue)||ComGetObjValue(formObj.old_bkg_no) != srcValue){
				if(ComIsNull(srcValue)){
			    	ComSetObjValue(formObj.old_bkg_no,"");
				}
	    		ComSetObjValue(formObj.bl_no,"");
	    		ComSetObjValue(formObj.pctl_no,"");
	    		ComSetObjValue(formObj.si_flg,"");
	    		ComSetObjValue(formObj.partial_vvd_opened_flg, "N");
	    		ComSetObjValue(formObj.partial_vvd_assign_flg, "N");
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
	 	    	manageHaveRouteFlag("N");
			} 
		} else if (srcName == "bkg_trunk_vvd") {
			if(ComGetObjValue(formObj.bkg_trunk_vvd_old) != srcValue){
				ComSetObjValue(formObj.route_modify_flag,"Y");
				ComSetObjValue(formObj.modify_flag,"Y");
		     	manageHaveRouteFlag("N");
	    		if(srcValue.substring(0,4) == "HJXX" || srcValue.substring(0,4) == "HJYY" || srcValue.substring(0,4) == "HJZZ"){
	    			ComSetObjValue(formObj.psdo_bkg_flg,"Y");
	    		} else{
	    			ComSetObjValue(formObj.psdo_bkg_flg,"N");
	    		}  
	    		for(var i=sheetObjects[2].LastRow()  ; i >= sheetObjects[2].HeaderRows(); i-- ){
	    			if(ComGetObjValue(formObj.bkg_trunk_vvd_old)== sheetObjects[2].GetCellValue(i, "bkg_vvd_cd")){
	    				sheetObjects[2].SetCellValue(i, "bkg_vvd_cd",srcValue);
	    			}
	    		}
			}		        		
	    	por_pol_change(formObj);
		    pod_del_change(formObj);
			if(formObj.bkg_sts_cd.value != "" && formObj.bkg_trunk_vvd.value != "" && formObj.bkg_trunk_vvd_old.value != formObj.bkg_trunk_vvd.value){
		    	if(sheetObjects[2].RowCount() > 1){
 	    			document.getElementById('btn_t1RouteDetail').click();
 	    		} 
 	    	}
		} else if (srcName == "bkg_por_cd") {
			if(ComGetObjValue(formObj.por_yd_cd_old) != srcValue){
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
	 	    	manageHaveRouteFlag("N");
			}  
	    	if(ComIsNull(srcValue)){
	    		for(var i=sheetObjects[2].LastRow()  ; i >= sheetObjects[2].HeaderRows(); i-- ){
		   			sheetObjects[2].RowDelete(i,false);
		   		}	
	    		ComSetObjValue(formObj.pre_rly_port_cd,		"");
	    		ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
	    		ComSetObjValue(formObj.pst_rly_port_cd,		"");
	    		ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
	    	}
			ComSetObjValue(formObj.org_trns_mod_cd, "");
		} else if (srcName == "bkg_por_yd_cd") {
			if(ComGetObjValue(formObj.por_cd_old) != srcValue){
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
	    		ComSetObjValue(formObj.bkg_por_yd_cd,"");
	 	    	manageHaveRouteFlag("N");
			} 		        		
		} else if (srcName == "bkg_pol_cd") {
			if(ComGetObjValue(formObj.pol_cd_old) != srcValue){
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
	 	    	manageHaveRouteFlag("N");
				ComSetObjValue(formObj.bkg_pol_yd_cd,"");
	 	    	sheetObjects[2].SetCellValue(sheetObjects[2].HeaderRows(),"pol_cd",srcValue);
	 	    	sheetObjects[2].SetCellValue(sheetObjects[2].HeaderRows(),"pol_yd_cd","");
				por_pol_change(formObj);			
			}
			if(ComIsNull(srcValue)){
				for(var i=sheetObjects[2].LastRow()  ; i >= sheetObjects[2].HeaderRows(); i-- ){
					sheetObjects[2].RowDelete(i,false);
				}	
	    		ComSetObjValue(formObj.pre_rly_port_cd,		"");
	    		ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
	    		ComSetObjValue(formObj.pst_rly_port_cd,		"");
	    		ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
			}	
			ComSetObjValue(formObj.org_trns_mod_cd, "");
		} else if (srcName == "bkg_pol_yd_cd") {
			if(ComGetObjValue(formObj.pol_yd_cd_old) != srcValue){
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
	 	    	manageHaveRouteFlag("N"); 	
	 	    	sheetObjects[2].SetCellValue(sheetObjects[2].HeaderRows(),"pol_yd_cd",srcValue);
		    	por_pol_change(formObj);
			}
		} else if (srcName == "bkg_pod_cd") {
			if(ComGetObjValue(formObj.pod_cd_old) != srcValue){
//	    		checkEgyptDeTerm(srcValue);
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	 	    	manageHaveRouteFlag("N");		
				ComSetObjValue(formObj.bkg_pod_yd_cd,"");
				sheetObjects[2].SetCellValue(sheetObjects[2].LastRow() - 1, "pod_cd", srcValue);
				sheetObjects[2].SetCellValue(sheetObjects[2].LastRow() - 1, "pod_yd_cd", ""); 
	 	    	pod_del_change(formObj);
			}       			
			if(ComIsNull(srcValue)){
				 for(var i=sheetObjects[2].RowCount()  ; i >= sheetObjects[2].HeaderRows(); i-- ){
					sheetObjects[2].RowDelete(i,false);
				}	
				ComSetObjValue(formObj.pre_rly_port_cd,		"");
				ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
				ComSetObjValue(formObj.pst_rly_port_cd,		"");
				ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
			}
			ComSetObjValue(formObj.dest_trns_mod_cd, "");
		} else if (srcName == "bkg_pod_yd_cd") {
			if(ComGetObjValue(formObj.pod_yd_cd_old) != srcValue){
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
	 	    	manageHaveRouteFlag("N");
	 	    	sheetObjects[2].SetCellValue(sheetObjects[2].LastRow() - 1, "pod_yd_cd", srcValue);
	 	    	pod_del_change(formObj);
			}
		} else if (srcName == "bkg_del_cd") {
			if(ComGetObjValue(formObj.del_cd_old) != srcValue){
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
				ComSetObjValue(formObj.bkg_del_yd_cd,"");
	 	    	manageHaveRouteFlag("N");
	 	    	if(formObj.opus2.value == "No"){
		 	    	var t2formObj=parent.frames["t2frame"].document.form;
		 	    	if (t2formObj) {
			 			if(ComIsNull(t2formObj.cn_cust_seq.value) && !ComIsNull(srcValue)){
			 				ComSetObjValue(t2formObj.cn_cust_cnt_cd, srcValue.substring(0,2));
			 			}	
			 			if(ComIsNull(t2formObj.nf_cust_seq.value) && !ComIsNull(srcValue)){
			 				ComSetObjValue(t2formObj.nf_cust_cnt_cd, srcValue.substring(0,2));
			 			}
		 	    	}
				}
			}
			if(ComGetObjValue(formObj.premium_available_flg) == "Y"&&"USLGB"==srcValue){
				formObj.hot_de_flg.disabled=false; 
			}else{
				formObj.hot_de_flg.checked=false;
				formObj.hot_de_flg.disabled=true;   		
			} 		        		
			if(ComIsNull(srcValue)){
				for(var i=sheetObjects[2].LastRow()  ; i >= sheetObjects[2].HeaderRows(); i-- ){
		   			sheetObjects[2].RowDelete(i,false);
		   		}	
				ComSetObjValue(formObj.pre_rly_port_cd,		"");
				ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
				ComSetObjValue(formObj.pst_rly_port_cd,		"");
				ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
			}
			ComSetObjValue(formObj.dest_trns_mod_cd, "");
		} else if (srcName == "bkg_del_yd_cd") {
			if(ComGetObjValue(formObj.del_yd_cd_old) != srcValue){
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
	 	    	manageHaveRouteFlag("N");
			}  
		} else if (srcName == "s_cust_cnt_cd") {
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.s_cust_cnt_cd_old) != srcValue){
				formObj.customer_modify_flag.value="Y";
				formObj.modify_flag.value="Y";		
			}
			form_setShprCustCntCd(srcValue);
		} else if (srcName == "s_cust_seq") {
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.s_cust_seq_old) != srcValue){
				formObj.customer_modify_flag.value="Y";
				formObj.modify_flag.value="Y";		
				if(!ComIsNull(srcValue)){
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
			}
			form_setShprCustSeq(srcValue);
		} else if (srcName == "f_cust_cnt_cd") {
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_cnt_cd_old) != srcValue){
				formObj.customer_modify_flag.value="Y";
				formObj.modify_flag.value="Y";		
			}
			form_setFwdrCustCntCd(srcValue);
		} else if (srcName == "f_cust_seq") {
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_seq_old) != srcValue){
				formObj.customer_modify_flag.value="Y";
				formObj.modify_flag.value="Y";		
				if(!ComIsNull(srcValue)){
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
		    		if(ComIsNull(formObj.s_cust_cnt_cd) && ComIsNull(formObj.s_cust_seq)){
		    			form_setShprCustCntCd(ComGetObjValue(formObj.f_cust_cnt_cd));
			    		form_setShprCustSeq(ComGetObjValue(formObj.f_cust_seq));
			    		ComSetObjValue(formObj.s_cust_nm, ComGetObjValue(formObj.f_cust_nm));	    			
		    		}
				}
			}
			form_setFwdrCustSeq(srcValue);
		} else if (srcName == "rfa_no") {
			svcScpCd = "";
			if(srcValue == "DUM"){
				ComSetObjValue(formObj.rfa_no,"DUM000001");
			}else{
	 			if(srcValue.length>=10){
	    			if(srcValue != ComGetObjValue(formObj.rfa_no_old)){
	        			formObj.f_cmd.value=SEARCHLIST12;
	        			var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?rfa_no="+srcValue, "f_cmd="+SEARCHLIST12+"&bkg_no="+formObj.bkg_no.value+"&rfa_no="+formObj.rfa_no.value);
	     				changeObjectColor(ComGetEtcData(sXml,"rfa_available"), "N", "rfa_no", "red", "input");
	     				if(!ComIsNull(formObj.sc_no) && ComGetObjValue(formObj.sc_no).substring(0,3) == "DUM"){
	     					ComSetObjValue(formObj.sc_no, "");
	     				}
	     				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM"){
	     					ComSetObjValue(formObj.taa_no, "");
	     				}	     				
	     				ComSetObjValue(formObj.modify_flag,"Y");
	     				ComSetObjValue(formObj.ctrt_modify_flag,"Y"); 
	    			}   				
				}else{
					changeObjectColor(ComGetEtcData(sXml,"rfa_available"), "N", "rfa_no", "red", "input1");
				}
			}  
			if(formObj.rfa_no_old.value!=formObj.rfa_no.value){
				compareItem();
			}
			if((ComGetObjValue(formObj.rfa_no) != ComGetObjValue(formObj.rfa_no_old)) || srcValue == "") clearContractParty();
			ComSetObjValue(formObj.rfa_no_old,ComGetObjValue(formObj.rfa_no));
			
			if(srcValue != "" && srcValue.indexOf("DUM") < 0){
    			if(formObj.bkg_ctrl_pty_cust_cnt_cd.value == "" && formObj.bkg_ctrl_pty_cust_seq.value == ""){
    				searchBkgCtrlPtyCust("rfa_no=" + formObj.rfa_no.value);
//    				var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&rfa_no=" + formObj.rfa_no.value);
//    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, ComGetEtcData(sXml, "cust_cnt_cd"));
//    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, ComGetEtcData(sXml, "cust_seq"));
    			}
    		}
			
		} else if (srcName == "sc_no") {
			svcScpCd = "";
			if(srcValue == "DUM"){
				ComSetObjValue(formObj.sc_no,"DUM000001");
			}else{
	 			if(srcValue.length>=8){
	    			if(srcValue != ComGetObjValue(formObj.sc_no_old)){
	        			formObj.f_cmd.value=SEARCHLIST13;
	        			var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?sc_no="+srcValue, "f_cmd="+SEARCHLIST13+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+formObj.sc_no.value);
	     				changeObjectColor(ComGetEtcData(sXml,"sc_available"), "N", "sc_no", "red", "input");
	     				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM"){
	     					ComSetObjValue(formObj.rfa_no, "");
	     				}
	     				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM"){
	     					ComSetObjValue(formObj.taa_no, "");
	     				}	     			     		
	     				ComSetObjValue(formObj.modify_flag,"Y");
	     				ComSetObjValue(formObj.ctrt_modify_flag,"Y");  		
	    			}   		  			
				}else{
					changeObjectColor(ComGetEtcData(sXml,"sc_available"), "N", "sc_no", "red", "input");
				}
			}    
			if(formObj.sc_no_old.value!=formObj.sc_no.value){
				compareItem();
			}
			if((ComGetObjValue(formObj.sc_no) != ComGetObjValue(formObj.sc_no_old)) || srcValue == "") clearContractParty();
			ComSetObjValue(formObj.sc_no_old,ComGetObjValue(formObj.sc_no));
			
			if(srcValue != "" && srcValue.indexOf("DUM") < 0){
    			if(formObj.bkg_ctrl_pty_cust_cnt_cd.value == "" && formObj.bkg_ctrl_pty_cust_seq.value == ""){
    				searchBkgCtrlPtyCust("sc_no=" + formObj.sc_no.value);
//    				var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&sc_no=" + formObj.sc_no.value);
//    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, ComGetEtcData(sXml, "cust_cnt_cd"));
//    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, ComGetEtcData(sXml, "cust_seq"));
    			}
    		}
		}else if(srcName == "taa_no"){
			if(srcValue == "DUM"){
				ComSetObjValue(formObj.taa_no,"DUM0000001");
			}else if(srcValue.length>=10){
	 			if(srcValue != ComGetObjValue(formObj.taa_no_old)){
	     			// calling validatetTaavailable()
	     			formObj.f_cmd.value=SEARCH06;
	     			var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0000GS.do?taa_no="+srcValue, "f_cmd="+SEARCH06+"&bkg_no="+formObj.bkg_no.value+"&taa_no="+formObj.taa_no.value);
	 				changeObjectColor(ComGetEtcData(sXml,"taa_available"), "N", "taa_no", "red", "input");
	 				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM"){
	 					ComSetObjValue(formObj.rfa_no, "");
	 				}
	 				if(!ComIsNull(formObj.sc_no) && ComGetObjValue(formObj.sc_no).substring(0,3) == "DUM"){
	 					ComSetObjValue(formObj.sc_no, "");
	 				}
	 			}   		
				ComSetObjValue(formObj.modify_flag,"Y");
				ComSetObjValue(formObj.ctrt_modify_flag,"Y"); 
	 		}
			if(formObj.taa_no_old.value!=formObj.taa_no.value){
				compareItem();
			}
			if((ComGetObjValue(formObj.taa_no) != ComGetObjValue(formObj.taa_no_old)) || srcValue == "") clearContractParty();
	 		ComSetObjValue(formObj.taa_no_old,ComGetObjValue(formObj.taa_no));  
	 		
	 		if(srcValue != "" && srcValue.indexOf("DUM") < 0){
    			if(formObj.bkg_ctrl_pty_cust_cnt_cd.value == "" && formObj.bkg_ctrl_pty_cust_seq.value == ""){
    				searchBkgCtrlPtyCust("taa_no=" + formObj.taa_no.value);
//    				var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&taa_no=" + formObj.taa_no.value);
//    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, ComGetEtcData(sXml, "cust_cnt_cd"));
//    				ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, ComGetEtcData(sXml, "cust_seq"));
    			}
    		}
	 		
		} else if (srcName == "act_wgt") {
			var actWgt=formObj.act_wgt.value;
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
			return;
			ComSetObjValue(formObj.modify_flag, "Y");
			form_setEstWgtQty(formObj.act_wgt.value);
		} else if (srcName == "twn_so_no") {
			if (!ComIsNull(srcValue)) {
				formObj.modify_flag.value="Y";
			}
		} else if (srcName == "mty_dor_arr_dt") {
			ComAddSeparator(ComGetEvent());
			if(ComGetObjValue(formObj.mty_dor_arr_dt_old) != srcValue){
				ComSetObjValue(formObj.modify_flag, "Y");
			}       
		} else if (srcName == "lodg_due_dt") {
			ComAddSeparator(ComGetEvent());
			if(ComGetObjValue(formObj.lodg_due_dt_old) != srcValue){
				ComSetObjValue(formObj.route_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
	 	    	manageHaveRouteFlag("N");
			}
			if (formObj.lodg_due_dt.value!=formObj.departure_dt2.value) {
				compareItem();				
			}
		} else if (srcName == "de_due_dt") {
			ComAddSeparator(ComGetEvent());
			if(srcValue.length > 0 && ComChkPeriod(formObj.lodg_due_dt.value, srcValue) < 1){
				ComShowCodeMessage("BKG00176");
				ComSetObjValue(formObj.de_due_dt, "");
			}
			if(ComGetObjValue(formObj.de_due_dt_old) != srcValue){
				ComSetObjValue(formObj.modify_flag, "Y");
			}
			if (formObj.de_due_dt.value!=formObj.arrival_dt2.value) {
				compareItem();				
			}
		} else if (srcName == "mty_pkup_dt") {
			ComAddSeparator(ComGetEvent());
			if(ComGetObjValue(formObj.mty_pkup_dt_old) != srcValue){
				ComSetObjValue(formObj.route_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
	 	    	manageHaveRouteFlag("N");
			}
			if (formObj.mty_pkup_dt.value!=formObj.mty_pkup_dt2.value) {
				compareItem();
			}
		} else if (srcName == "mty_pkup_yd_cd") {
			if(ComGetObjValue(formObj.mty_pkup_yd_cd_old) != srcValue){
				ComSetObjValue(formObj.route_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
	 	    	manageHaveRouteFlag("N");
			}
		} else if (srcName == "full_rtn_yd_cd") {
	    	if(ComGetObjValue(formObj.full_rtn_yd_cd_old) != srcValue){
	    		ComSetObjValue(formObj.modify_flag, "Y");
	    	}
		}
		return true;
	}
	/**
	 * in case of being click event
	 */
	function bkg0229_01_click() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		if (srcName == "prct_flg") {
			if (formObj.prct_flg.checked) {
				ComShowCodeMessage("BKG00274");
				setPrecaution(formObj, "Y")
				formObj.prct_flg.value="Y";
			} else {
				if (formObj.validPrecaution.value == "Y") {
					ComShowCodeMessage("BKG00274");
					formObj.prct_flg.checked=true;
				} else {
					formObj.modify_flag.value="Y";
					formObj.prct_flg.value="N";
				}
			}
		} else if ("dcgo_flg"==srcName) {
			formObj.dcgo_flg.value=formObj.dcgo_flg.checked ? "Y" : "N";
		} else if ("rc_flg"==srcName) {
			formObj.rc_flg.value=formObj.rc_flg.checked ? "Y" : "N";
		} else if ("awk_cgo_flg"==srcName) {
			formObj.awk_cgo_flg.value=formObj.awk_cgo_flg.checked ? "Y" : "N";
		} else if ("bb_cgo_flg"==srcName) {
			formObj.bb_cgo_flg.value=formObj.bb_cgo_flg.checked ? "Y" : "N";
		} else if ("spcl_hide_flg"==srcName) {
			formObj.spcl_hide_flg.value=formObj.spcl_hide_flg.checked ? "Y" : "N";
		} else if ("prct_flg"==srcName) {
			formObj.prct_flg.value=formObj.prct_flg.checked ? "Y" : "N";
		} else if ("fd_grd_flg"==srcName) {
			formObj.fd_grd_flg.value=formObj.fd_grd_flg.checked ? "Y" : "N";
		} else if ("flex_hgt_flg"==srcName) {
			formObj.flex_hgt_flg.value=formObj.flex_hgt_flg.checked ? "Y" : "N";
		} else if ("edi_hld_flg"==srcName) {
			formObj.edi_hld_flg.value=formObj.edi_hld_flg.checked ? "Y" : "N";
		} 
	}
	function form_onChange() {
	 	var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
	 	var srcValue=ComGetEvent("value");
	 	var formObj=document.form;
	 	switch (srcName) {
		 	case "bkg_trunk_vvd" :
		 		//bkgVvdChanged();
		 		searchVslNm(srcValue);
				ComSetObjValue(formObj.route_modify_flag, "Y");
		 		manageHaveRouteFlag("N");
		 		break;	 		
		 	case "bkg_por_cd" :
		 		searchNupdateRoutNm(srcValue, formObj.por_nm);
				ComSetObjValue(formObj.route_modify_flag, "Y");
		 		manageHaveRouteFlag("N");
		 		break;	 		
		 	case "bkg_pol_cd" :
		 		searchNupdateRoutNm(srcValue, formObj.pol_nm);
				ComSetObjValue(formObj.route_modify_flag, "Y");
		 		manageHaveRouteFlag("N");
		 		break;	 		
		 	case "bkg_pod_cd" :
		 		searchNupdateRoutNm(srcValue, formObj.pod_nm);
				ComSetObjValue(formObj.route_modify_flag, "Y");
		 		manageHaveRouteFlag("N");
		 		break;	 		
		 	case "bkg_del_cd" :
		 		searchNupdateRoutNm(srcValue, formObj.del_nm);
				ComSetObjValue(formObj.route_modify_flag, "Y");
		 		manageHaveRouteFlag("N");
		 		break;	 		
		 	case "cmdt_cd":
				if(!ComIsNull(srcValue)){
					ComSetObjValue(formObj.cmdt_cd, ComLpad(srcValue,6,"0"));
					if(ComGetObjValue(formObj.cmdt_cd_old) != srcValue){
						validatePrecaution(formObj);			
		  	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);	
					}    			
				}else{
					ComSetObjValue(formObj.cmdt_desc,"");
					ComSetObjValue(formObj.rep_cmdt_cd,"");
				}
				ComSetObjValue(formObj.cmdt_cd_old,ComGetObjValue(formObj.cmdt_cd));    	
				ComSetObjValue(formObj.modify_flag,"Y");
				cmdtChange(srcValue);
		 		break;
		 	case "rep_cmdt_cd":
	    		if(ComIsNull(srcValue)){
	    			ComSetObjValue(formObj.cmdt_desc,"");
	    		}
		 		break;
	 	}
	 	compareItem();
		compareQty();
	 }
	function ctrtType_OnClick() {
		var formObj=document.form;
		if(formObj.rfa_no.value != "") {
			formObj.ctrt_type.value="RFA";
		} else if(formObj.taa_no.value != "") {
			formObj.ctrt_type.value="TAA";
		} else if(ComGetObjValue(formObj.bkg_por_cd).substring(0,2)=="US" || 
			ComGetObjValue(formObj.bkg_pol_cd).substring(0,2)=="US" ||
			(!ComIsNull(formObj.bkg_pod_cd) && ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)=="US") ||
			ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="US" ){
			formObj.ctrt_type.value="TAA";
		} else {
			formObj.ctrt_type.value="RFA";
		}	
		var ctrtType=formObj.ctrt_type.value;
		if (ComGetObjValue(formObj.ctrt_type) == "RFA") {
			document.all.item("rfa_no").style.display="";
			document.all.item("taa_no").style.display="none";
			document.all.item("btn_RfaNo").style.display="";
			document.all.item("btn_TaaNo").style.display="none";	
			formObj.ctrt_type[1].checked=true;		
		} else if (ComGetObjValue(formObj.ctrt_type) == "TAA") {
			document.all.item("rfa_no").style.display="none";
			document.all.item("taa_no").style.display="";
			document.all.item("btn_RfaNo").style.display="none";
			document.all.item("btn_TaaNo").style.display="";
			formObj.ctrt_type[0].checked=true;
		} else {
			document.all.item("rfa_no").style.display="";
			document.all.item("taa_no").style.display="none";
			document.all.item("btn_RfaNo").style.display="";
			document.all.item("btn_TaaNo").style.display="none";	
			formObj.ctrt_type[1].checked=true;		
		}
	}
	function changeBkgNoManual(obj) {
		if (obj.checked) {
			obj.value = 'Y';
		} else {
			obj.value = 'N';
		}
	}
	function rcv_term_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {	
		var formObj=document.form;
		if(newCode!="M"){
			if (parent.frames["t3frame"].document.form) {
				if ( parent.frames["t3frame"].document.form.fnl_cfm_flg.value != "Y" ) {
					var cntrSheet=parent.frames["t3frame"].sheetObjects[0];
					 for(i=cntrSheet.HeaderRows();i<=cntrSheet.LastRow();i++){
						cntrSheet.SetCellValue(i, "rcv_term_cd",value,0);
					}
					parent.frames["t3frame"].setCopyFlag("false");
					for ( var i=0; i < parent.frames["t3frame"].document.form.elements.length; i++) {
						if (parent.frames["t3frame"].document.form.elements[i].name.indexOf("rcv_term_cd") == 0) {
							parent.frames["t3frame"].document.form.elements[i].value=value;
							parent.frames["t3frame"].document.form.elements[i].disabled=true;
						}
					}
				}
			}		
		} else {
			if (parent.frames["t3frame"].document.form) {
				if ( parent.frames["t3frame"].document.form.fnl_cfm_flg.value != "Y" ) {
					for ( var i=0; i < parent.frames["t3frame"].document.form.elements.length; i++) {
						if (parent.frames["t3frame"].document.form.elements[i].name.indexOf("rcv_term_cd") == 0) {
							parent.frames["t3frame"].document.form.elements[i].disabled=false;
						}
					}
				}
			}
		}		
		document.form.bkg_por_yd_cd.value="";
		compareItem();
		ComSetObjValue(formObj.route_modify_flag, "Y");
		ComSetObjValue(formObj.modify_flag, "Y");
	    manageHaveRouteFlag("N");
	}
	
	function de_term_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {	
		var formObj=document.form;
		if(newCode!="M"){
			if (parent.frames["t3frame"].document.form) {
				if ( parent.frames["t3frame"].document.form.fnl_cfm_flg.value != "Y" ) {
					var cntrSheet=parent.frames["t3frame"].sheetObjects[0];
					for(i=cntrSheet.HeaderRows();i<=cntrSheet.LastRow();i++){
						cntrSheet.SetCellValue(i, "de_term_cd",value,0);
					}
					parent.frames["t3frame"].setCopyFlag("false");
					for ( var i=0; i < parent.frames["t3frame"].document.form.elements.length; i++) {
						if (parent.frames["t3frame"].document.form.elements[i].name.indexOf("de_term_cd") == 0) {
							parent.frames["t3frame"].document.form.elements[i].value=value;
							parent.frames["t3frame"].document.form.elements[i].disabled=true;
						}
					}
				}
			}		
		} else {
			if (parent.frames["t3frame"].document.form) {
				if ( parent.frames["t3frame"].document.form.fnl_cfm_flg.value != "Y" ) {
					for ( var i=0; i < parent.frames["t3frame"].document.form.elements.length; i++) {
						if (parent.frames["t3frame"].document.form.elements[i].name.indexOf("de_term_cd") == 0) {
							parent.frames["t3frame"].document.form.elements[i].disabled=false;
						}
					}
				}
			}
		}	
		document.form.bkg_del_yd_cd.value="";
		compareItem();
		ComSetObjValue(formObj.route_modify_flag, "Y");
		ComSetObjValue(formObj.modify_flag, "Y");
	    manageHaveRouteFlag("N");
	}
	function wgt_ut_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.wgt_ut_cd_text.value = newCode;
		if (parent.frames["t4frame"].document.form) {
			ComSetObjValue(parent.frames["t4frame"].document.form.wgt_ut_cd, newCode);
		}
		setDiffCheckColor(newCode, formObj.estm_wgt_ut_cd2.value, ("estm_wgt_ut_cd2"));
	}
	function frt_term_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if (parent.tabObjects[0].GetSelectedIndex()== 0) {
			if (document.form.is_rated_flg.value == "Y") {
				ComShowCodeMessage("BKG02065");
			}
		}
		if (parent.frames["t4frame"].document.form) {
//			ComSetObjValue(parent.frames["t4frame"].document.form.frt_term_cd, value);
			
			parent.frames["t4frame"].window.frt_term_cd.SetSelectCode(newCode, false);
		}
		compareItem();
	}
	function por_pol_change(formObj){
		if(oldPolYdCd == formObj.bkg_por_cd.value + formObj.bkg_por_yd_cd.value){
			if(!ComIsNull(oldPolYdCd) && !ComIsNull(formObj.bkg_por_yd_cd.value)
					&& oldPolYdCd.trim() != "" && formObj.bkg_por_yd_cd.value.trim() != ""){
				formObj.bkg_por_cd.value=formObj.bkg_pol_cd.value;
				formObj.bkg_por_yd_cd.value=formObj.bkg_pol_yd_cd.value;
				searchNupdateRoutNm(formObj.bkg_pol_cd.value, formObj.por_nm);
			}
		}			
		oldPolYdCd=formObj.bkg_pol_cd.value + formObj.bkg_pol_yd_cd.value;
	}
	function pod_del_change(formObj){
		if(oldPodYdCd == formObj.bkg_del_cd.value + formObj.bkg_del_yd_cd.value){
			if(!ComIsNull(oldPodYdCd) && !ComIsNull(formObj.bkg_del_yd_cd.value)
					&& oldPodYdCd.trim() != "" && formObj.bkg_del_yd_cd.value.trim() != ""){
				formObj.bkg_del_cd.value=formObj.bkg_pod_cd.value;
				formObj.bkg_del_yd_cd.value=formObj.bkg_pod_yd_cd.value;
				searchNupdateRoutNm(formObj.bkg_pod_cd.value, formObj.del_nm);
			}
		}			
		oldPodYdCd=formObj.bkg_pod_cd.value + formObj.bkg_pod_yd_cd.value;
	}
	function cmdtChange(cmdtCd){
		var formObj=document.form;
		var chang="N";
		if (parent.frames["t7frame"].document.form) {
			var t7formObj=parent.frames["t7frame"].document.form;
			var obj=null;
			for ( var i=0; i < t7formObj.elements.length; i++) {
				if ((t7formObj.elements[i].name).indexOf("__") > 0) {
					obj=(t7formObj.elements[i].name).split("__");
					if(obj[0] == "cmdt_cd"){
						if ( ComIsNull(t7formObj.elements[i].value) ) {
							t7formObj.elements[i].value=ComLpad(cmdtCd,6,"0");
							chang="Y";
						}
					} else if(obj[0] == "cmdt_desc"){
						if ( ComIsNull(t7formObj.elements[i].value) || chang == "Y" ) {
							t7formObj.elements[i].value=formObj.cmdt_desc.value;
							chang="N";
						}
					}
				}
			}		
		}
		chang="N";
		if (parent.frames["t9frame"].document.form) {
			var t9formObj=parent.frames["t9frame"].document.form;
			var obj=null;
			for ( var i=0; i < t9formObj.elements.length; i++) {
				if ((t9formObj.elements[i].name).indexOf("__") > 0) {
					obj=(t9formObj.elements[i].name).split("__");
					if(obj[0] == "cmdt_cd"){
						if ( ComIsNull(t9formObj.elements[i].value) ) {
							t9formObj.elements[i].value=ComLpad(cmdtCd,6,"0");
							chang="Y";
						}
					} else if(obj[0] == "cmdt_desc"){
						if ( ComIsNull(t9formObj.elements[i].value) || chang == "Y" ) {
							t9formObj.elements[i].value=formObj.cmdt_desc.value;
							chang="N";
						}
					}
				}
			}		
		}	
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){		
		var formObj=document.form;
		if(ErrMsg == ""){
			setTotalVol(sheetObj);
			disabledFH(sheetObj, formObj);
		}
		sheetObj.SetColBackColor("cntr_tpsz_cd","#CCFFFD");
		sheetObj.SetColBackColor("op_cntr_qty","#CCFFFD");
	}
	function sheet1_OnAfterEdit(sheetObj, Row, Col){
		var formObj=document.form;
		setTotalVol(sheetObj);
		if(sheetObj.GetCellValue(Row, "ibflag") != "R"){
			ComSetObjValue(formObj.modify_flag, "Y");
			ComSetObjValue(formObj.carge_detail_pop, "N");// being modified cargo detail
			ComSetObjValue(formObj.qty_modify_flag, "Y");
		}
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"||sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
			manageHaveRouteFlag("N");
		}
		compareQty();
	}	
	var befQty="";
	function sheet1_OnBeforeEdit(sheetObj, Row, Col, Value){		
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
			befQty=sheetObj.GetCellValue(Row, Col);
		}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var srcName = sheetObj.ColSaveName(Col);
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
				sheetObj.SetCellValue(Row, Col,befQty,0);
				return;
			}			
		}
		if (sheetObj.GetCellValue(Row,"eq_subst_cntr_tpsz_cd") != "" && (sheetObj.GetCellValue(Row,"cntr_tpsz_cd") == sheetObj.GetCellValue(Row,"eq_subst_cntr_tpsz_cd"))){
			ComShowCodeMessage("BKG02002");
			sheetObj.SetCellValue(Row, Col,"",0);
			return false;
		}
		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "eq_subst_cntr_tpsz_cd"){
			if(!dupChkCntrTpSz()){
				sheetObj.SetCellValue(Row, Col,"",0);
				return false;
			}
		}
		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "eq_subst_cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "op_cntr_qty" || sheetObj.ColSaveName(Col) == "eq_subst_cgo_qty" || sheetObj.ColSaveName(Col) == "soc_qty"){
			if(sheetObj.GetCellValue(Row, Col) != sheetObj.CellSearchValue(Row, Col)){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Opening Cargo Detail screen in case of saving
			} else{
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");		// not opening Cargo Detail screen in case of saving
			}			
		}	
		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
			checkCntrTpszCd(sheetObj, Row);
		}
	}		
	
	function disabledFH(sheetObj, formObj){
		var isDisAble=true;
		 for(i=1 ; i < sheetObj.LastRow() ; i++){
			if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D4" || sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D5"){
				isDisAble=false;
				break;
			}
		 }		
		formObj.flex_hgt_flg.disabled=isDisAble;
		if (isDisAble) {
			formObj.flex_hgt_flg.checked=false;
			formObj.flex_hgt_flg.value="N";
		}
	}
	// showing Total Volumn
	function setTotalVol(sheetObj){
		var totalVol;
		 for(i=1 ; i <= sheetObj.LastRow() ; i++){
			// setting RD
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
	// showing RD Cgo
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
		} else{
			sheetObj.SetCellValue(Row, "rd_cgo_flg","",0);
		}
	}
	function showBkCntc() {
		if (document.all.showBkCntc.style.display == "none") {
			document.all.showBkCntc.style.display="block";
			document.all.showBkCntc.style.visibility='visible';
			document.all.showBkCntc.style.top=(document.getElementById("btn_contact").offsetTop - 140)+"px";
			document.all.showBkCntc.style.left=(document.getElementById("btn_contact").offsetLeft + 5)+"px";
		} else {
			document.all.showBkCntc.style.display="none";
			document.all.showBkCntc.style.visibility='hidden';
		}
	}
	function showXterDocReq() {
		if (document.all.showXterDocReq.style.display == "none") {
			document.all.showXterDocReq.style.display="block";
			document.all.showXterDocReq.style.visibility='visible';
			document.all.showXterDocReq.style.top=(document.getElementById("btn_docRequirement").offsetTop - 116)+"px";
			document.all.showXterDocReq.style.left=(document.getElementById("div_right").offsetLeft + 14)+"px";
		} else {
			document.all.showXterDocReq.style.display="none";
			document.all.showXterDocReq.style.visibility='hidden';
		}
	}
	function showBkgDocReq() {
		if (document.all.showBkgDocReq.style.display == "none") {
			document.all.showBkgDocReq.style.display="block";
			document.all.showBkgDocReq.style.visibility='visible';
			document.all.showBkgDocReq.style.top=(document.getElementById("btn_docRequirement").offsetTop - 106)+"px";
			document.all.showBkgDocReq.style.left=(document.getElementById("btn_docRequirement").offsetLeft + 4)+"px";
		} else {
			document.all.showBkgDocReq.style.display="none";
			document.all.showBkgDocReq.style.visibility='hidden';
		}
	}
	
	//2015.03.09 Reference No Button
	function showXterRef() {
		if (document.all.showXterRef.style.display == "none") {
			document.all.showXterRef.style.display = "block";
			document.all.showXterRef.style.visibility = 'visible';
			document.all.showXterRef.style.top=(document.getElementById("btn_ref_bkg").offsetTop - 116)+"px";
			document.all.showXterRef.style.left=(document.getElementById("div_right").offsetLeft + 136)+"px";
			
		} else {
			document.all.showXterRef.style.display = "none";
			document.all.showXterRef.style.visibility = 'hidden';
		}
	}
	
	//2015.03.09 Reference No Button
	function showBkgRef() {
		if (document.all.showBkgRef.style.display == "none") {
			document.all.showBkgRef.style.display = "block";
			document.all.showBkgRef.style.visibility = 'visible';
			document.all.showBkgRef.style.top=(document.getElementById("btn_ref_bkg").offsetTop - 106)+"px";
			document.all.showBkgRef.style.left=(document.getElementById("btn_ref_bkg").offsetLeft + 4)+"px";
		} else {
			document.all.showBkgRef.style.display = "none";
			document.all.showBkgRef.style.visibility = 'hidden';
		}
	}

	function makeComma(srcValue) {
		srcValue = srcValue.split(" ").join("");
		var arrVal = srcValue.split(".");
		if (arrVal.length > 1) {
			if (arrVal[1].length > 2) {
				arrVal[1]=arrVal[1].substring(0, 2);
			}
			srcValue=makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
		} else {
			srcValue=makeCommaRun(arrVal[0]) + ".000";
		}
		return srcValue;
	}
	function makeCommaRun(srcValue) {
		srcValue=srcValue.replace(/\D/g, "");
		if (srcValue.length > 9) {
			srcValue=srcValue.substring(0, 9);
		}
		l=srcValue.length - 3;
		while (l > 0) {
			srcValue=srcValue.substr(0, l) + "," + srcValue.substr(l);
			l -= 3;
		}
		return srcValue;
	}
	function form_setEstWgtQty(value) {
		
		if (parent.frames["t4frame"].document.form) {
			parent.frames["t4frame"].document.form.act_wgt.value=makeComma(value);
			ComSetObjValue(parent.frames["t4frame"].document.form.wgt_ut_cd, document.form.wgt_ut_cd_text.value);
		}
		compareItem();
	}
	function form_setShprCustCntCd(value) {
		var formObj=document.form;
		formObj.s_cust_cnt_cd.value=value;
		if (parent.frames["t2frame"].document.form) {
			parent.frames["t2frame"].document.form.sh_cust_cnt_cd.value=value;
		}
		compareItem();
	}
	function form_setShprCustSeq(value) {
		var formObj=document.form;
		if(ComLpad(value,6,"0")!="000000"){
			ComSetObjValue(formObj.s_cust_seq,ComLpad(value,6,"0"));
		}
		if (parent.frames["t2frame"].document.form) {
			parent.frames["t2frame"].document.form.sh_cust_seq.value=formObj.s_cust_seq.value;
		}
		compareItem();
	}
	function form_setFwdrCustCntCd(value) {
		var formObj=document.form;
		formObj.f_cust_cnt_cd.value=value;
		if (parent.frames["t2frame"].document.form) {
			parent.frames["t2frame"].document.form.ff_cust_cnt_cd.value=value;
			parent.frames["t2frame"].setCopyFlag("false");
		}
		compareItem();
	}
	function form_setFwdrCustSeq(value) {
		var formObj=document.form;
		if(ComLpad(value,6,"0")!="000000"){
			ComSetObjValue(formObj.f_cust_seq,ComLpad(value,6,"0"));
		}
		if (parent.frames["t2frame"].document.form) {
			parent.frames["t2frame"].document.form.ff_cust_seq.value=formObj.f_cust_seq.value;
			parent.frames["t2frame"].setCopyFlag("false");
		}
		compareItem();
	}
	function bkgVvdChanged() {
		var formObj=document.form;
		var sheet3=sheetObjects[2];	
		var row=0;
		if (sheet3.RowCount()> 0) {
			row=sheet3.FindText("vsl_pre_pst_cd", "T");
		} else {
			row=sheet3.DataInsert(-1);
			sheet3.SetCellValue(row, "vsl_pre_pst_cd","T",0);
			sheet3.SetCellValue(row, "vsl_seq","0",0);
		}
		sheet3.SetCellValue(row, "bkg_vvd_cd",formObj.bkg_trunk_vvd.value,0);
		sheet3.SetCellValue(row, "pol_cd",formObj.bkg_pol_cd.value,0);
		sheet3.SetCellValue(row, "pol_yd_cd",formObj.bkg_pol_yd_cd.value,0);
		sheet3.SetCellValue(row, "pod_cd",formObj.bkg_pod_cd.value,0);
		sheet3.SetCellValue(row, "pod_yd_cd",formObj.bkg_pod_yd_cd.value,0);
		compareItem();
	}
	function searchCustNm(formObj, custCntCd, custSeq, custTp){
		formObj.f_cmd.value=SEARCHLIST14;
		var param="f_cmd="+ SEARCHLIST14 + "&cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq;
		var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0079_01GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq, param);
		if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
			if(custTp == "S"){
				ComSetObjValue(formObj.s_cust_nm,ComGetEtcData(sXml,"cust_nm"));
			}else if(custTp == "C"){
				ComSetObjValue(formObj.c_cust_nm,ComGetEtcData(sXml,"cust_nm"));
			}else{
				ComSetObjValue(formObj.f_cust_nm,ComGetEtcData(sXml,"cust_nm"));
				if (parent.frames["t2frame"].document.form) {
					parent.frames["t2frame"].document.form.ff_cust_lgl_eng_nm.value = ComGetEtcData(sXml,"cust_nm");
					parent.frames["t2frame"].document.form.fmc_cd.value = ComGetEtcData(sXml,"fmc_cd");
					parent.frames["t2frame"].document.form.ff_mdm_address.value = ComGetEtcData(sXml,"cust_addr");
				}
			}			
		} else{
			if(custTp == "S"){
				ComSetObjValue(formObj.s_cust_nm,"");
			}else if(custTp == "C"){
				ComSetObjValue(formObj.c_cust_nm,"");
			}else{
				ComSetObjValue(formObj.f_cust_nm,"");
			}
		}				    			    	
	}
	function searchNupdateRoutNmAll(){
		var formObj=document.form;
		formObj.f_cmd.value=SEARCHLIST17;
		var locCd=formObj.bkg_por_cd2.value + "|" + formObj.bkg_pol_cd2.value + "|" + formObj.bkg_pod_cd2.value + "|" + formObj.bkg_del_cd2.value;
		var sXml=sheetObjects[2].GetSearchData("ESM_Booking_UtilGS.do?input_text=" + escape(locCd), "f_cmd="+SEARCHLIST17);
		if (sXml != "") {
			var locNm=ComGetEtcData(sXml, "output_text").split("|");
			formObj.por_nm.value=locNm[0]==undefined?"":locNm[0];
			formObj.pol_nm.value=locNm[1]==undefined?"":locNm[1];
			formObj.pod_nm.value=locNm[2]==undefined?"":locNm[2];
			formObj.del_nm.value=locNm[3]==undefined?"":locNm[3];
			updateRoutStyle(formObj.por_nm);
			updateRoutStyle(formObj.pol_nm);
			updateRoutStyle(formObj.pod_nm);
			updateRoutStyle(formObj.del_nm);
		}
	}
	
	function searchNupdateRoutNm(locCd,elem) {
		var formObj=document.form;
		formObj.f_cmd.value=SEARCHLIST17;
		var sXml=sheetObjects[2].GetSearchData("ESM_Booking_UtilGS.do?input_text=" + escape(locCd), "f_cmd="+SEARCHLIST17);
		if (sXml != "") {
			elem.value=ComGetEtcData(sXml, "output_text");		
			updateRoutStyle(elem);
		}
	}
	
	function updateRoutStyle(elem) {
		var elemList=new Array(
			new Array("por_nm", 	"por_nm2"),
			new Array("pol_nm", 	"pol_nm2"),
			new Array("pod_nm", 	"pod_nm2"),
			new Array("del_nm", 	"del_nm2"),  
			new Array("fnl_dest_nm","fnl_dest_nm2"));
		for (var i=0; i < elemList.length; i++) {
			if (elemList[i][0] == elem.name) break;
		}
		if (i >= elemList.length) return;
		var orgElem=document.getElementsByName(elemList[i][1]);
		if (orgElem[0].value != elem.value) {
			orgElem[0].style.color="Red";
			elem.style.color="Blue";
		} else {
			orgElem[0].style.color="#606060";
			elem.style.color="#606060";
		}
	}
	
	function searchVslNm(bkgTrunkVvd) {
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH02;
		try {
			var sXml=sheetObjects[4].GetSearchData("ESM_BKG_0229_01GS.do", "f_cmd="+SEARCH02+"&bkg_trunk_vvd="+bkgTrunkVvd);
			var vslNm=ComGetEtcData(sXml, "vsl_nm");
			if (vslNm == 'null' || vslNm == '') {
				vslNm="";
			}
			formObj.vsl_eng_nm.value=vslNm;
		} catch (err) {
			ComShowCodeMessage("BKG00094");
		}
	}
	
	/**
	 * retrieving precaution in case of inputting cmdt_cd
	 */       
	function validatePrecaution(formObj){
		formObj.f_cmd.value=SEARCHLIST11;
    	var sXml = sheetObjects[2].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCHLIST11+"&cmdt_cd="+formObj.cmdt_cd.value);
		ComSetObjValue(formObj.cmdt_desc, ComGetEtcData(sXml,"cmdt_nm"));
//		sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
		ComSetObjValue(formObj.rep_cmdt_cd, ComGetEtcData(sXml,"rep_cmdt_cd"));		
		setPrecaution(formObj, ComGetEtcData(sXml,"rep_imdg_lvl_cd"));
		ComSetObjValue(formObj.validPrecaution, "Y");
		if(ComGetEtcData(sXml, "cmdt_nm") == '') return false;
		return true;
	} 
	
	function setPrecaution(formObj, precaution){
	 	if(precaution == "P"){
	 		var isChecked=true;
	 		if(formObj.dcgo_flg.checked || formObj.rc_flg.checked || formObj.awk_cgo_flg.checked || formObj.bb_cgo_flg.checked){
	 			isChecked=false;
	 		}
	 		var isSoc=true;
	 		for ( i=1 ; i < sheetObjects[0].RowCount() ; i++ ){				
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
	 function sendBkgCloseMail(subject, closeBkgMsg){
	 }
	 
//	function checkEgyptDeTerm(srcValue) {
//		if (srcValue == "EGALY" || srcValue == "EGPSD") {
//			if (comboObjects[1].GetSelectCode()!= "O") {
//				ComShowCodeMessage("BKG00020");
//				comboObjects[1].SetSelectCode("O");
//				return false;
//			}
//		}
//		return true;
//	}
	
	//showing the message in case of changing the cmdt when Nigeria is dest
	function checkNigeriaCmdt(podCd, delCd){
		if(podCd.substring(0, 2)=="NG"||delCd.substring(0, 2)=="NG"){
			if(ComShowConfirm(ComGetMsg("BKG02051"))) {
				ComOpenWindow("http://www.customs.gov.ng/ProhibitionList/import.php", "", "", false);
			}
		}
	}
	
	//checking whether CntrTpSz is inputted and duplicated or not
	function chkCntrTpSz(){
		// checking whether TP/SZ is inputted or not
		if(sheetObjects[0].FindText("cntr_tpsz_cd","",-1) > 0){
			ComShowCodeMessage("BKG01013");		
			return false;    				
		}
		return dupChkCntrTpSz();
	}
	
	function dupChkCntrTpSz(){
		var dupCntrTp = sheetObjects[0].ColValueDupRows("cntr_tpsz_cd", false, true);
		if (dupCntrTp != null && dupCntrTp != "") {	// in case of inputting the same TP/SZ twice or more
			if((dupCntrTp.split("|")[0],"cntr_tpsz_cd")!=null && (dupCntrTp.split("|")[0],"cntr_tpsz_cd")!=""){
				ComShowCodeMessage("BKG00038",sheetObjects[0].GetCellValue(dupCntrTp.split("|")[0],"cntr_tpsz_cd"));
				return false;
			}
		}     
		return true;
	}    
	
	function checkAutoCaluate(formObj){
		var autoCalCnt=0;
		var rfCnt=0;
		var sheetObj=sheetObjects[0];
		if(ComGetObjValue(formObj.dcgo_flg) == "Y" && sheetObjects[3].RowCount()> 1){
		for(var i=sheetObj.HeaderRows(); i < sheetObj.RowCount() ; i++){
			cntrTpSz=sheetObj.GetCellValue(i, "cntr_tpsz_cd");
			drdgCnt=0;
			 for(var k=sheetObjects[3].HeaderRows(); k < sheetObjects[3].RowCount() ; k++){
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
		// in case of being existed the Hanger value
		if(ComGetObjValue(formObj.hngr_flg) == "Y"){
			 for(var i=sheetObj.HeaderRows(); i < sheetObjects[0].RowCount() ; i++){
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
		// checking Special Cargo
		if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
			autoCalCnt++;
		}
		if(ComGetObjValue(formObj.rc_flg) == "Y"){
			rfCnt++;
		}
		if(ComGetObjValue(formObj.awk_cgo_flg) == "Y"){
			autoCalCnt++;
		}
		if(ComGetObjValue(formObj.bb_cgo_flg) == "Y"){
			autoCalCnt++;
		}		
		var eqSubCnt=0;			               
		var socCnt=0;		
		var rdCnt=0;
		for(var i=sheetObj.HeaderRows(); i < sheetObj.RowCount() ; i++){
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
				   			   sheetObjects[3].SetCellValue(qtyDtlRow, "rcv_term_cd",ComGetObjValue(formObj.rcv_term_cd));
				   			   sheetObjects[3].SetCellValue(qtyDtlRow, "de_term_cd",ComGetObjValue(formObj.de_term_cd));
				   			   if(isVolDetailAutoChk()){
				   				   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "N");
				   			   }
	   		   }			   
			   // Adding the row and calculating automatically in case of being existed Hanger
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
			   if(cntrQty > 0){		
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
		   // calculating from the popup in case of not to calculate automatically
	   }
	}   
	// RD,SOC,EQ SUB Flag Setting
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
	/**
	 * saving the delivered value from MT PickUp CY Inquiry
	 */
	function callBack0019(rArray) {
		var formObj=document.form;
		if (rArray != null) {
			formObj.bkg_trunk_vvd.value=rArray[0][3];
			formObj.vsl_eng_nm.value=rArray[0][4];
			formObj.route_modify_flag.value="Y";
			manageHaveRouteFlag("N");
			if (rArray[0][3].substring(0, 4) == "HJXX"
					|| rArray[0][3].substring(0, 4) == "HJYY"
					|| rArray[0][3].substring(0, 4) == "HJZZ") {
				formObj.psdo_bkg_flg.value="Y";
			} else {
				formObj.psdo_bkg_flg.value="N";
			}
			if(sheetObjects[2].RowCount()== 1){
				sheetObjects[2].SetCellValue(1, "vsl_pre_pst_cd","T");
				sheetObjects[2].SetCellValue(1, "vsl_seq","0");
				sheetObjects[2].SetCellValue(1, "bkg_vvd_cd",rArray[0][3]);
				sheetObjects[2].SetCellValue(1, "pol_clpt_ind_seq","1");
				sheetObjects[2].SetCellValue(1, "pod_clpt_ind_seq","1");
			}
			searchVslNm(formObj.bkg_trunk_vvd.value);
			bkgVvdChanged();
		}	
	}
	/**
	 * saving the delivered value from MT PickUp CY Inquiry
	 */
	function callBack0082(rArray) {
		var formObj=document.form;
		if (rArray != null) {
			formObj.mty_pkup_yd_cd.value=rArray[0][2];
			formObj.route_modify_flag.value="Y";
			formObj.modify_flag.value="Y";
	 		manageHaveRouteFlag("N");
		}
	}
	/**
	 * saving the delivered value from the popup of Node Search
	 */
	function callBack0083(locTp, tab, rArray){
		var formObj=document.form;
		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
			if(rArray != null){
				if(tab == 1){
					if(locTp == "POR"){
						ComSetObjValue(formObj.bkg_por_cd, rArray[0][2]);
						ComSetObjValue(formObj.por_nm, rArray[0][3]);
						ComSetObjValue(formObj.bkg_por_yd_cd, "");
					}else if(locTp == "POL"){
						ComSetObjValue(formObj.bkg_pol_cd, rArray[0][2]);
						ComSetObjValue(formObj.pol_nm, rArray[0][3]);
						ComSetObjValue(formObj.bkg_pol_yd_cd, "");
						por_pol_change(formObj);
					}else if(locTp == "POD"){
						ComSetObjValue(formObj.bkg_pod_cd, rArray[0][2]);
						ComSetObjValue(formObj.pod_nm, rArray[0][3]);
						ComSetObjValue(formObj.bkg_pod_yd_cd, "");
//						checkEgyptDeTerm(rArray[0][2]);
						pod_del_change(formObj);
					}else{
						ComSetObjValue(formObj.bkg_del_cd, rArray[0][2]);
						ComSetObjValue(formObj.del_nm, rArray[0][3]);
						ComSetObjValue(formObj.bkg_del_yd_cd, "");
						if(formObj.opus2.value == "No"){
							var t2formObj=parent.frames["t2frame"].document.form;
							if(ComIsNull(t2formObj.cn_cust_seq.value) && !ComIsNull(rArray[0][2])){
								ComSetObjValue(t2formObj.cn_cust_cnt_cd, rArray[0][2].substring(0,2));
							}
	 						if(ComIsNull(t2formObj.nf_cust_seq.value) && !ComIsNull(rArray[0][2])){
								ComSetObjValue(t2formObj.nf_cust_cnt_cd, rArray[0][2].substring(0,2));
							}
						}
					}
				} else {
					if(locTp == "POR"){
						ComSetObjValue(formObj.bkg_por_cd, rArray[0][4].substring(0,5));
						ComSetObjValue(formObj.por_nm, rArray[0][3]);
						ComSetObjValue(formObj.bkg_por_yd_cd, rArray[0][4].substring(5,7));
					}else if(locTp == "POL"){
						ComSetObjValue(formObj.bkg_pol_cd, rArray[0][4].substring(0,5));
						ComSetObjValue(formObj.pol_nm, rArray[0][3]);
						ComSetObjValue(formObj.bkg_pol_yd_cd, rArray[0][4].substring(5,7));
						por_pol_change(formObj);
					}else if(locTp == "POD"){
						ComSetObjValue(formObj.bkg_pod_cd, rArray[0][4].substring(0,5));
						ComSetObjValue(formObj.pod_nm, rArray[0][3]);
						ComSetObjValue(formObj.bkg_pod_yd_cd, rArray[0][4].substring(5,7));
						// showing the message in case of inputting 'EGALY' or 'EGPSD' in POD if DEL Term is not 'O' 
//						checkEgyptDeTerm(rArray[0][4].substring(0,5));
						pod_del_change(formObj);
					}else{
						ComSetObjValue(formObj.bkg_del_cd, rArray[0][4].substring(0,5));
						ComSetObjValue(formObj.del_nm, rArray[0][3]);
						ComSetObjValue(formObj.bkg_del_yd_cd, rArray[0][4].substring(5,7));
		 				if(formObj.opus2.value == "No"){
							var t2formObj=parent.frames["t2frame"].document.form;
							if(ComIsNull(t2formObj.cn_cust_seq.value) && !ComIsNull(rArray[0][4])){
								ComSetObjValue(t2formObj.cn_cust_cnt_cd, rArray[0][4].substring(0,2));
							}
	 						if(ComIsNull(t2formObj.nf_cust_seq.value) && !ComIsNull(rArray[0][4])){
								ComSetObjValue(t2formObj.nf_cust_cnt_cd, rArray[0][4].substring(0,2));
							}
						}
					}
				}
				ComSetObjValue(formObj.route_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
				manageHaveRouteFlag("N");
			}
		}
	}
	/**
	 * saving the delivered value from the popup of Full Return CY
	 */
	function callBack0088(rArray) {
		var formObj=document.form;
		if (rArray != null) {
			formObj.full_rtn_yd_cd.value=rArray[0][2];
			formObj.route_modify_flag.value="Y";
			formObj.modify_flag.value="Y";
	 		manageHaveRouteFlag("N");
		}
	}
	/**
	 * calling the popup of Route Detail
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
	 * handling Route Detail and running
	 */
	function callBack0092() {
		var formObj=document.form;
		var sheetObj=sheetObjects[2];
		var row;
		if(sheetObj.RowCount()> 0){
//     		ComSetObjValue(formObj.bkg_trunk_vvd, sheetObj.GetCellValue(sheetObj.FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd"));
         	if(sheetObj.FindText("vsl_pre_pst_cd","T") > 1){
         		row = sheetObj.FindText("vsl_pre_pst_cd","T")-1;
         		ComSetObjValue(formObj.pre_rly_port_cd,    sheetObj.GetCellValue(row,"pod_cd"));
         		ComSetObjValue(formObj.pre_rly_port_yd_cd, sheetObj.GetCellValue(row,"pod_yd_cd"));
         	}
         	if(sheetObj.FindText("vsl_pre_pst_cd","T")+1 <= sheetObj.LastRow()){
         		row = sheetObj.FindText("vsl_pre_pst_cd","T")+1;
         		ComSetObjValue(formObj.pst_rly_port_cd,    sheetObj.GetCellValue(row,"pol_cd"));
         		ComSetObjValue(formObj.pst_rly_port_yd_cd, sheetObj.GetCellValue(row,"pol_yd_cd"));
         	}
         	row = sheetObj.LastRow();
         	ComSetObjValue(formObj.bkg_pol_cd,    sheetObj.GetCellValue(1,"pol_cd"));
         	ComSetObjValue(formObj.bkg_pol_yd_cd, sheetObj.GetCellValue(1,"pol_yd_cd"));
         	ComSetObjValue(formObj.bkg_pod_cd,    sheetObj.GetCellValue(row,"pod_cd"));
         	ComSetObjValue(formObj.bkg_pod_yd_cd, sheetObj.GetCellValue(row,"pod_yd_cd"));
		} else {     		
		  	ComSetObjValue(formObj.pre_rly_port_cd, "");
	     	ComSetObjValue(formObj.pre_rly_port_yd_cd, "");
	     	ComSetObjValue(formObj.pst_rly_port_cd, "");
	     	ComSetObjValue(formObj.pst_rly_port_yd_cd, "");
		}
		formObj.route_modify_flag.value="Y";
		formObj.modify_flag.value="Y";
		formObj.have_route_flag.value="N";
		if (formObj.bkg_trunk_vvd.value.length > 4) {
			var pseudoVvd=formObj.bkg_trunk_vvd.value.substring(0, 4);
			if(pseudoVvd == "COXX" || pseudoVvd == "COYY" || pseudoVvd == "COZZ"){
				formObj.psdo_bkg_flg.value="Y";
			} else {
				formObj.psdo_bkg_flg.value="N";
				searchVslNm(formObj.bkg_trunk_vvd.value);
			}
		}
		por_pol_change(formObj);
	 	pod_del_change(formObj);
	}
	/**
	 * saving the delivered value from Customer Popup
	 */
	function callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){    	
		if(lOfc == '' || lRep == '') {
    		ComShowMessage('Sales REP not exists');
    	}
		var formObj=document.form;
		if(rArray1 != null){
			if(rArray1[0][2] == "PREMIUM"){
				ComSetObjValue(formObj.premium_available_flg, "Y");
				formObj.hot_de_flg.disabled=false;
			}
			if (bkgCustTpCd == "S"){		
				form_setShprCustCntCd(rArray1[0][10].substring(0,2));
				form_setShprCustSeq(ComLpad(rArray1[0][11],6,"0"));
				ComSetObjValue(formObj.s_cust_nm, rArray1[0][4]);
	    		if(ComGetObjValue(formObj.s_cust_exist_flg) == "Y"){
	    			if(ComGetObjValue(formObj.s_cust_cnt_cd) != ComGetObjValue(formObj.s_cust_cnt_cd_old) || ComGetObjValue(formObj.s_cust_seq) != ComLpad(ComGetObjValue(formObj.s_cust_seq_old),6,"0")){
	    				ComSetObjValue(formObj.s_cust_subst_flg, "Y");
	    			}
	    		}	
	    		if(rArray2 != null){
					if(rArray2[0][8] != ""){
						form_setFwdrCustCntCd(rArray2[0][8].substring(0,2));
						form_setFwdrCustSeq(ComLpad(rArray2[0][8].substring(2),6,"0"));				    					
					} else{
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
				callProcess();
	    		
	    		// IST 강제 이벤트 실행
	    		//parent.document.getElementById("btn_opusupload").click();
			} else if(bkgCustTpCd == "F"){
				form_setFwdrCustCntCd(rArray1[0][10].substring(0,2));
				form_setFwdrCustSeq(ComLpad(rArray1[0][11],6,"0"));
				ComSetObjValue(formObj.f_cust_nm, rArray1[0][4]);
	    		ComSetObjValue(formObj.fmc_no,    rArray1[0][7]);  
	    		if (parent.frames["t2frame"].document.form) {
	    			parent.frames["t2frame"].document.form.fmc_cd.value=rArray1[0][7];
	    			parent.frames["t2frame"].document.form.ff_mdm_address.value=rArray1[0][9];
	    		}
				if(ComIsNull(formObj.s_cust_nm)){
					form_setShprCustCntCd(rArray1[0][10].substring(0,2));
					form_setShprCustSeq(ComLpad(rArray1[0][11],6,"0"));
					ComSetObjValue(formObj.s_cust_nm, rArray1[0][4]);	  			
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
		    		// IST 강제 이벤트 실행
		    		//parent.document.getElementById("btn_opusupload").click();
	    		}
			}
			ComSetObjValue(formObj.modify_flag, "Y");
	    	ComSetObjValue(formObj.customer_modify_flag, "Y"); 
			callProcess();
	    }
		if (rArray2 != null){
			for(i=0 ; i < rArray2.length ; i++){
				 if(rArray2[i][2] == "AL"){
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
				} else if(rArray2[i][2] == "SI"){
					// inputting S/I Contact
					ComSetObjValue(formObj.si_cntc_pson_nm,      rArray2[i][3]);
					ComSetObjValue(formObj.si_cntc_pson_phn_no,  rArray2[i][4]);
					ComSetObjValue(formObj.si_cntc_pson_eml,     rArray2[i][7]);
					ComSetObjValue(formObj.si_cntc_pson_mphn_no, rArray2[i][5]);
					ComSetObjValue(formObj.si_cntc_pson_fax_no,  rArray2[i][6]);
				} else{
					// inputting BKG Contact
					ComSetObjValue(formObj.bkg_cntc_pson_nm,     rArray2[i][3]);
					ComSetObjValue(formObj.bkg_cntc_pson_phn_no, rArray2[i][4]);
					ComSetObjValue(formObj.bkg_cntc_pson_eml,    rArray2[i][7]);
					ComSetObjValue(formObj.bkg_cntc_pson_mphn_no,rArray2[i][5]);
					ComSetObjValue(formObj.bkg_cntc_pson_fax_no, rArray2[i][6]);							
				}
				document.all.bkg_cntc_pson_nm_span.innerHTML=ComGetObjValue(formObj.bkg_cntc_pson_nm);
				document.all.bkg_cntc_pson_phn_no_span.innerHTML=ComGetObjValue(formObj.bkg_cntc_pson_phn_no);
				document.all.bkg_cntc_pson_mphn_no_span.innerHTML=ComGetObjValue(formObj.bkg_cntc_pson_mphn_no);
				document.all.bkg_cntc_pson_fax_no_span.innerHTML=ComGetObjValue(formObj.bkg_cntc_pson_fax_no);
				document.all.bkg_cntc_pson_eml_span.innerHTML=ComGetObjValue(formObj.bkg_cntc_pson_eml);
				document.all.si_cntc_pson_nm_span.innerHTML=ComGetObjValue(formObj.si_cntc_pson_nm);
				document.all.si_cntc_pson_phn_no_span.innerHTML=ComGetObjValue(formObj.si_cntc_pson_phn_no);
				document.all.si_cntc_pson_mphn_no_span.innerHTML=ComGetObjValue(formObj.si_cntc_pson_mphn_no);
				document.all.si_cntc_pson_fax_no_span.innerHTML=ComGetObjValue(formObj.si_cntc_pson_fax_no);
				document.all.si_cntc_pson_eml_span.innerHTML=ComGetObjValue(formObj.si_cntc_pson_eml);
				ComSetObjValue(formObj.contact_modify_flag, "Y");
				callProcess();
			}		
		}
	}  
	
	function callProcess() { 
		if (valYn == "Y") {
			valYn = "N";
			// IST 강제 이벤트 실행 
			parent.document.getElementById("btn_opusupload").click();		
		}
	}
	/**
	* being returned after calling CMDT Screen
	*/    
	function callBack0653(arrVal){
		 var formObj=document.form;
	 	 if(arrVal != null){				
	 		 ComSetObjValue(formObj.cmdt_cd,     arrVal[0][3]);
	 		 ComSetObjValue(formObj.rep_cmdt_cd, arrVal[0][5]);
	 		 ComSetObjValue(formObj.cmdt_desc,   arrVal[0][4]);		
	 		 if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
	 			 var precaution=arrVal[0][7];
	 			 setPrecaution(formObj, precaution);
	 			 checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
	 			 ComSetObjValue(formObj.validPrecaution, "Y");	// the validation for in case of unchecked Precaution		
	 			 ComSetObjValue(formObj.modify_flag,     "Y");   	
	 			 ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][3]);
	 		 }
		     cmdtChange(formObj.cmdt_cd.value);
		}
	}   
	/**
	* being returned after searching RFA
	*/
	function callBack0654(arrVal) {
		var formObj=document.form;
		if (arrVal != null) {  	
  			ComSetObjValue(formObj.rfa_no,     arrVal[0][5]);
  			ComSetObjValue(formObj.rfa_no_old, arrVal[0][5]);
  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
	  		ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
  			ComSetObjValue(formObj.modify_flag,      "Y");   	
  			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
			changeObjectColor("Y", "N", "rfa_no", "red", "input");
			svcScpCd = arrVal[0][7];
		}
	}
	/**
	* being returned after S/C
	*/
	function callBack0655(arrVal) {
		var formObj=document.form;
		if (arrVal != null) {
			ComSetObjValue(formObj.sc_no,     arrVal[0][5]);
  			ComSetObjValue(formObj.sc_no_old, arrVal[0][5]);
  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
	  		ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
 			ComSetObjValue(formObj.modify_flag,      "Y");   	
 			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
  			changeObjectColor("Y", "N", "sc_no", "red", "input");
  			svcScpCd = arrVal[0][7];
		}
	}
	/**
	 * being returned after opening popup of RFA Commodity
	 */    
	function callBack0656(arrVal){
		var formObj=document.form;
		if(arrVal != null){		

			if(arrVal[0][8] == "0000"||arrVal[0][3]=="000000"){
				comBkgCallPop0653('callBack0653',"","");
			} else if(arrVal[0][5] == "REP"){
				comBkgCallPop0653('callBack0653',"",arrVal[0][3]);		
			} else {	
				ComSetObjValue(formObj.cmdt_cd, arrVal[0][6]);
				if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
					validatePrecaution(formObj);
	  	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
					ComSetObjValue(formObj.validPrecaution, "Y");	// The validation for in case of unchecked Precaution
					ComSetObjValue(formObj.modify_flag,     "Y");   	
					ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][6]);
				}
			}	
			cmdtChange(formObj.cmdt_cd.value);
		}
	}  
	/**
	 * being returned after opening popup of S/C Commodity
	 */
	function callBack0657(arrVal) {
		var formObj=document.form;
		if(arrVal != null){		
	    	var scpCd=arrVal[0][7];
			if(scpCd =="TPE"|| scpCd =="ACE"|| scpCd =="MXE"){
				ComSetObjValue(formObj.cmdt_cd, arrVal[0][3]);
				if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
					validatePrecaution(formObj);
	  	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
					ComSetObjValue(formObj.validPrecaution, "Y");	// The validation for in case of unchecked Precaution
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
					ComSetObjValue(formObj.validPrecaution, "Y");	// The validation for in case of unchecked Precaution
					ComSetObjValue(formObj.modify_flag,     "Y");   	
					ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][3]);	
				}		
			}
			cmdtChange(formObj.cmdt_cd.value);
		}
	}
	 /**
	  * caliing the popup of Cargo Detail Information
	  */
	 function comBkgCallPop0890(callback_func, autoFlag){
		 var formObj=document.form;
		 if(ComGetObjValue(formObj.carge_detail_pop)!="Y" || checkAutoCaluate(formObj)){ // recalculating in case of being changed
			 resetQtyDetail();
		 }
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
		 rtnValue=ComOpenPopup("ESM_BKG_0890.do?pgmNo=ESM_BKG_0890&callTp=B&auto_flg="+autoFlag+"&callSheetIdx1=3&callSheetIdx2=0"+url, 800, 400, callback_func,"1,0,1,1,1", true);
		 callBack0890(rtnValue);
	 }       
	  /**
	  * being returned after opening the popup of Carge Detail Information
	  */    
		function callBack0890(autoFlg){
			var formObj=document.form;
			if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     
		  		ComSetObjValue(formObj.modify_flag,      "Y");
		  		ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");
		  		ComSetObjValue(formObj.carge_detail_pop, "Y");   	
		  		ComSetObjValue(formObj.qty_modify_flag,  "Y");  	
		  		if(autoFlg == "Y"){
		      		if(validateForm(formObj, COMMAND01)){
		     			doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
		      		}			
		  		}
			}
		}   
	  /**
	   * calling the popup of VVD Change for partial container booking
	   */
	  function comBkgCallPop1024(callback_func, bkgNo){
	  	ComOpenPopup("ESM_BKG_1024.do?pgmNo=ESM_BKG_1024&bkg_no="+bkgNo, 800, 540, callback_func,"0,1,1,1,1", true);
	  }
	 /**
	  * calling the popup of VVD Change for partial container booking
	  */
	 function callBack1024(){    	
		var formObj=document.form;
		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){           	
			ComSetObjValue(formObj.modify_flag, "Y");
			ComSetObjValue(formObj.partial_vvd_opened_flg, "Y");
		}
	 }
	  /**
	   * Being returned after searching TAA
	   */    
		function callBack1062(arrVal){
		  	var formObj=document.form;   
		  	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){   
		  		if(arrVal != null){	  			
		  			ComSetObjValue(formObj.taa_no,     arrVal[0][5]);
		  			ComSetObjValue(formObj.taa_no_old, arrVal[0][5]);
		  			if(arrVal[0][1] == "S" || arrVal[0][1] == "P" ){
		  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, arrVal[0][2]);
			  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, arrVal[0][3]);
		  			}else{
		  				ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, '');
			  			ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, '');
		  			}
		  			ComSetObjValue(formObj.modify_flag,      "Y");   	
		  			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
		  			changeObjectColor("Y", "N", "taa_no", "red", "input");
		  		}
		  	}
		}    
	  /**
	   * Being returned after opening the popup of TAA Commodity
	   */    
	 function callBack1078(arrVal){
	  	 var formObj=document.form;
	  	 if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){  
			if(arrVal != null){		
//				if(arrVal[0][1]=="000004"){
//					ComSetObjValue(formObj.cmdt_cd, arrVal[0][1]);
//					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
//						validatePrecaution(formObj);
//	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
//						ComSetObjValue(formObj.validPrecaution, "Y");	
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
	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
						ComSetObjValue(formObj.validPrecaution, "Y");	
						ComSetObjValue(formObj.modify_flag, "Y");   	
						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][1]);
					}
				}	
			}
			cmdtChange(formObj.cmdt_cd.value);
	  	 }
	 }       
	 
	//Being returned the value after calling ESD_PRD_018
	 function callBackEsdPrd0080(pctlNo){
	 	var formObj=document.form;
	 	esdPrd0080 = true;
	 	if(ComIsNull(pctlNo)){
	 		pctlNo="";
			manageHaveRouteFlag("N");		
			ComSetObjValue(formObj.route_modify_flag, "Y");
	 	} else {
	 		ComSetObjValue(formObj.pctl_no, pctlNo);
			manageHaveRouteFlag("Y"); 		
    		// IST 강제 이벤트 실행
			valYn = 'Y';
			callProcess();
//    		parent.document.getElementById("btn_opusupload").click();
	 	}
	 	
	} 
	 /**
	 * calling SC Inquiry
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
			      var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			      var winObj=window.open("opusMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);      
		   }   
	}        	
	 /**
	 * calling RFA Inquiry
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
//		      var pgmNo="ESM_PRI_2019";
//		      var pgmUrl="/opuscntr/ESM_PRI_2019.do";
//		      var params="&s_rfa_no=" + ComGetObjValue(formObj.rfa_no);  //==> RFA No.
//		      var parentPgmNo=pgmNo.substring(0, 8) + 'M001';   
//		      var src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
//		      var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
//		      var winObj=window.open("opusMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);	
		      		      
		      var params="s_rfa_no=" + ComGetObjValue(formObj.rfa_no);  //==> RFA No.
		      var sUrl="/opuscntr/ESM_PRI_2019.do?" + params;
		      var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		      var winObj =  ComOpenWindowCenter(sUrl,  "",  sFeatures , true);
		      
		      
		   }   
	}         
 	/**
     * calling TAA  Inquiry
     */
    function comBkgCallPopEsmPri3007(){   	
 	   var formObj=document.form;
 	   var isPop=true;
 	   if(ComIsNull(formObj.taa_no)){
 		   isPop=false;
 	   }
 	   if(isPop){
 		   var pgmNo="ESM_PRI_3007";        // TAA Main Program No
 		    var pgmUrl="/opuscntr/ESM_PRI_3007.do"        // TAA Main url
 		    var params="&cond_taa_no=" + ComGetObjValue(formObj.taa_no);    // inputting TAA NO to retrieve
 		    var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
 		    var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
 		    var sUrl="opusMain.screen?parentPgmNo=" + parentPgmNo + src;
 		    var iWidth=1024;
 		    var iHeight=700;
 		    var leftpos=(screen.width - iWidth) / 2;
 		    if (leftpos < 0)
 		        leftpos=0;
 		    var toppos=(screen.height - iHeight) / 2;
 		    if (toppos < 0)
 		        toppos=0;
 		    var sFeatures="status=no, resizable=yes, scrollbars=yes, width="+iWidth+", height="+iHeight+", left="+leftpos+", top="+toppos;
 		    ComOpenWindow(sUrl, "", sFeatures);	   
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
	
	function changeCntcLayer(no) {
		document.getElementById("cntcLayer1").style.display=0==no ? "inline":"none";
		document.getElementById("cntcLayer2").style.display=1==no ? "inline":"none";
	}
	
	/*function usa_cstms_file_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		document.form.usa_cstms_file_cd_text.value = newCode;
	}
	
	function usa_cstms_file_cd_OnBlur(comboObj) {
		document.form.usa_cstms_file_cd_text.value = comboObj.GetSelectCode();
	}
	function cnd_cstms_file_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		document.form.cnd_cstms_file_cd_text.value = newCode;
	}
	
	function cnd_cstms_file_cd_OnBlur(comboObj) {
		document.form.cnd_cstms_file_cd_text.value = comboObj.GetSelectCode();
	}*/
	function getHeight() {
		//return $('.layout_wrap').height();
		return document.body.scrollHeight;
	}
	
	function getMakeBrExter(obj) {
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
		formObj.xter_rmk.value = strVal;	
	}

	function getMakeBrInter(obj) {
		var formObj=document.form;
		var arrVal = formObj.inter_rmk.value.split("\n");
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
		formObj.inter_rmk.value = strVal;	
	}      
	
	function clearContractParty(){
		var formObj=document.form;
		formObj.bkg_ctrl_pty_cust_cnt_cd.value = '';
		formObj.bkg_ctrl_pty_cust_seq.value = '';
	}
	
	/**
	 * Wait 활성화 사용여부
	 */
	function waitChecked(){
		var formObj = document.form;
		formObj.modify_cargo_flg.value = 'Y';
		
		if(formObj.dcgo_flg.checked == true || formObj.rc_flg.checked == true || formObj.awk_cgo_flg.checked == true || formObj.bb_cgo_flg.checked == true || formObj.bkg_sts_cd.value != ""){
			formObj.bkg_wt_chk_flg.disabled = true;
		}else{
			formObj.bkg_wt_chk_flg.disabled = false;
		}
		
		if(formObj.bkg_sts_cd.value == "" && formObj.bkg_wt_chk_flg.disabled){
			if((eur_flg != 'Y' || formObj.bkg_sts_cd.value != "") && formObj.bkg_wt_chk_flg.checked)
				formObj.edi_hld_flg.checked = false;
			
			formObj.bkg_wt_chk_flg.checked = false;
		}
		
		if(eur_flg != 'Y' || formObj.bkg_sts_cd.value != "") return;
		
		if(formObj.dcgo_flg.checked == true || formObj.rc_flg.checked == true || formObj.awk_cgo_flg.checked == true || formObj.bb_cgo_flg.checked == true || formObj.bkg_sts_cd.value != ""){
			formObj.edi_hld_flg.checked = true;
		}else{
			if(!userEdiHldFlgCheck)
				formObj.edi_hld_flg.checked = false;
		}

	}
	
	/**
	 * Auto EDI Hold 체크 여부
	 */
	function ediHldFlgChecked(){
		var formObj = document.form;
		/* Wait 체크 되어있는 상태인가 */
		
		if(eur_flg != 'Y') return;
		
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
	
	function AutoNotification(){
		var formObj = document.form;
//		if(formObj.auto_notification.checked){
//			formObj.auto_notification.checked = false;
//		}
	}
	
	/**
	 * 
	 * @returns {String}
	 */
	function getSvcScpCd(){
		return svcScpCd;
	}
	
	function comBkgCloseCallPop0092(){
		var formObj = document.form;
		if(formObj.bkg_trunk_vvd.value != ComGetObjValue(formObj.bkg_trunk_vvd_old) && ComGetObjValue(formObj.bkg_sts_cd) != ""){
			for(var i = sheetObjects[2].LastRow(); i >= sheetObjects[2].HeaderRows(); i-- ){
    			if(formObj.bkg_trunk_vvd.value == sheetObjects[2].GetCellValue(i, "bkg_vvd_cd")){
    				sheetObjects[2].SetCellValue(i, "bkg_vvd_cd", ComGetObjValue(formObj.bkg_trunk_vvd_old));
    			}
    		}
			formObj.bkg_trunk_vvd.value = ComGetObjValue(formObj.bkg_trunk_vvd_old);
			formObj.vsl_eng_nm.value = ComGetEtcData(arrXml[0], "vsl_nm");
		}
	}
	
	function internalRemarkCopy(rmk){
		var formObj = document.form;
		if(rmk != '' && formObj.rcv_term2.value == 'CY' && formObj.bkg_sts_cd.value == ''){
			formObj.inter_rmk.value = 'Empty Container pick-up location\n' + rmk;
		}
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
			
			if((formObj.bl_no.value.length == 10 || formObj.bl_no.value.length == 11) && checkConfirm){
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
	
	function searchBkgCtrlPtyCust(param){
		var formObj = document.form;
		var sXml = sheetObjects[3].GetSearchData("ESM_BKG_0079_01GS.do", "f_cmd=" + SEARCH02 + "&" + param);
		ComSetObjValue(formObj.bkg_ctrl_pty_cust_cnt_cd, ComGetEtcData(sXml, "cust_cnt_cd"));
		ComSetObjValue(formObj.bkg_ctrl_pty_cust_seq, ComGetEtcData(sXml, "cust_seq"));
	}