/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0020.js
*@FileTitle  : CBF for Partner Line’s Booking (Creation) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================
*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ---------------IN---*/
/**
 * @extends
 * @class vop_opf_0020 : business script for  vop_opf_0020
 */
	/* Developer performance	*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var prefix1="t1sheet1_";
	var prefix2="t2sheet1_";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {	 
		var sheetObj1=sheetObjects[0]; // t1sheet1
		var sheetObj2=sheetObjects[1]; // t2sheet1
		var tabObj=tabObjects[0];
		var comboObj=comboObjects[0];
		var formObj=document.form;
		var selTabIdx=tabObj.GetSelectedIndex();
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH); // tab1
					break;
				case "btn_New":
					ComResetAll();
					comboObj.RemoveAll();
					//button deactivate
					ComBtnDisable("btn_LoadFile");
					ComBtnDisable("btn_SummaryPreview");
					ComBtnDisable("t1btn_RowAdd");
					ComBtnDisable("t1btn_RowInsert");
					ComBtnDisable("t1btn_Delete");
					ComBtnDisable("t1btn_LoadFileTemplate");
					ComBtnDisable("t1btn_WGPCalcu");
					ComBtnDisable("t2btn_RowAdd");
					ComBtnDisable("t2btn_CntrAdd");
					ComBtnDisable("t2btn_CgoAdd");
					ComBtnDisable("t2btn_RowCopy");
					ComBtnDisable("t2btn_Delete");
					ComBtnDisable("t2btn_LoadFileTemplate");
					//site of initial focus
					ComSetFocus(formObj.vsl_cd);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);					
					break;
				case "btn_vvd":
					var vslCd=ComGetObjValue(formObj.vsl_cd);
					var sUrl="";
					if (vslCd == "") {
						sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
					} else {
						sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslCd;
						ComOpenPopup(sUrl, 335, 425, "setCallBackVVD", "0,0", true);
					}
					break;
				case "btn_opr":
					//ComOpenPopupWithTarget('/opuscntr/COM_ENS_0N1.do', 800, 500, "crr_cd:crr_cd", "1,0,1,1,1", true);
					ComOpenPopup('/opuscntr/COM_ENS_0N1.do', 800, 500, "setCrrCd", "1,0,1,1,1", true);
					break;
				case "btn_LoadFile":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBLOADEXCEL);
					break;
				case "btn_SummaryPreview":
					openSPPopup(formObj);
					break;
				case "t1btn_RowAdd":
					var row=sheetObj1.DataInsert(-1);
					sheetObj1.SetCellValue(row, prefix1+"vsl_cd",ComGetObjValue(formObj.vsl_cd),0);
					sheetObj1.SetCellValue(row, prefix1+"skd_voy_no",ComGetObjValue(formObj.skd_voy_no),0);
					sheetObj1.SetCellValue(row, prefix1+"skd_dir_cd",ComGetObjValue(formObj.skd_dir_cd),0);
					sheetObj1.SetCellValue(row, prefix1+"bkg_shpr_ownr_flg","N",0);
					sheetObj1.SetCellValue(row, prefix1+"crr_cd",ComGetObjValue(formObj.crr_cd),0);
					sheetObj1.SetCellValue(row, prefix1+"yd_cd",yd_cd.GetSelectText(),0);
					sheetObj1.SetCellValue(row, prefix1+"pol_clpt_ind_seq",yd_cd.GetSelectCode().substring(yd_cd.GetSelectCode().length-1, yd_cd.GetSelectCode().length),0);
					sheetObj1.SetCellValue(row, prefix1+"slan_cd",ComGetObjValue(formObj.slan_cd),0);
					sheetObj1.SetCellValue(row, prefix1+"cbf_dp_cd","V",0);
					sheetObj1.SelectCell(row, prefix1+"pod_cd");
					break;
				case "t1btn_RowInsert":
					var row=sheetObj1.DataInsert();
					sheetObj1.SetCellValue(row, prefix1+"vsl_cd",ComGetObjValue(formObj.vsl_cd),0);
					sheetObj1.SetCellValue(row, prefix1+"skd_voy_no",ComGetObjValue(formObj.skd_voy_no),0);
					sheetObj1.SetCellValue(row, prefix1+"skd_dir_cd",ComGetObjValue(formObj.skd_dir_cd),0);
					sheetObj1.SetCellValue(row, prefix1+"bkg_shpr_ownr_flg","N",0);
					sheetObj1.SetCellValue(row, prefix1+"crr_cd",ComGetObjValue(formObj.crr_cd),0);
					sheetObj1.SetCellValue(row, prefix1+"yd_cd",yd_cd.GetSelectText(),0);
					sheetObj1.SetCellValue(row, prefix1+"pol_clpt_ind_seq",yd_cd.GetSelectCode().substring(yd_cd.GetSelectCode().length-1, yd_cd.GetSelectCode().length),0);
					sheetObj1.SetCellValue(row, prefix1+"slan_cd",ComGetObjValue(formObj.slan_cd),0);
					sheetObj1.SetCellValue(row, prefix1+"cbf_dp_cd","V",0);
					sheetObj1.SelectCell(row, prefix1+"pod_cd");
					break;
				case "t1btn_RowCopy":
					var row=sheetObj1.DataCopy();
					sheetObj1.SetCellValue(row, prefix1+"cbf_smry_seq","",0);
					sheetObj1.SelectCell(row, prefix1+"pod_cd");
					break;
				case "t1btn_Delete":
					ComRowHideDelete(sheetObj1, prefix1+"del_chk");
					break;
				case "t2btn_RowAdd":
					var row=sheetObj2.DataInsert(-1);
					sheetObj2.SetCellValue(row, prefix2+"cntr_seq",1,0);
					sheetObj2.SetCellValue(row, prefix2+"cgo_seq",1,0);
					sheetObj2.SetCellValue(row, prefix2+"vsl_cd",ComGetObjValue(formObj.vsl_cd),0);
					sheetObj2.SetCellValue(row, prefix2+"skd_voy_no",ComGetObjValue(formObj.skd_voy_no),0);
					sheetObj2.SetCellValue(row, prefix2+"skd_dir_cd",ComGetObjValue(formObj.skd_dir_cd),0);
					sheetObj2.SetCellValue(row, prefix2+"bkg_shpr_ownr_flg","N",0);
					sheetObj2.SetCellValue(row, prefix2+"crr_cd",ComGetObjValue(formObj.crr_cd),0);
					sheetObj2.SetCellValue(row, prefix2+"yd_cd",yd_cd.GetSelectText(),0);
					sheetObj2.SetCellValue(row, prefix2+"pol_clpt_ind_seq",yd_cd.GetSelectCode().substring(yd_cd.GetSelectCode().length-1, yd_cd.GetSelectCode().length),0);
					sheetObj2.SetCellValue(row, prefix2+"slan_cd",ComGetObjValue(formObj.slan_cd),0);
					sheetObj2.SetCellValue(row, prefix2+"cbf_dp_cd","S",0);
					sheetObj2.SelectCell(row, prefix2+"prnr_bkg_ref_no");
					break;
				case "t2btn_CntrAdd":
					if (sheetObj2.RowCount()> 0) {
						var row=sheetObj2.DataCopy();
						//1. initializing Container no.
						sheetObj2.SetCellValue(row, prefix2+"prnr_cntr_ref_no","",0);
						//2. Increase Container Seq 
						sheetObj2.SetCellValue(row, prefix2+"cntr_seq",parseInt(sheetObj2.GetCellValue(row, prefix2+"cntr_seq")) + 1,0);
						sheetObj2.SetCellValue(row, prefix2+"cgo_seq",1,0);
						//3. Delete Cargo Info
						for(var colCt=sheetObj2.SaveNameCol(prefix2+"cntr_grs_wgt"); colCt<=sheetObj2.SaveNameCol(prefix2+"cbf_rmk"); colCt++) {
							sheetObj2.SetCellValue(row, colCt,"",0);
						}
						sheetObj2.SetCellValue(row, prefix2+"cbf_smry_seq","",0);
						sheetObj2.SelectCell(row, prefix2+"prnr_cntr_ref_no");
					}
					break;
				case "t2btn_CgoAdd":
					if (sheetObj2.RowCount()> 0) {
						var row=sheetObj2.DataCopy();
						//1. Increase Container Seq 
						sheetObj2.SetCellValue(row, prefix2+"cgo_seq",parseInt(sheetObj2.GetCellValue(row, prefix2+"cgo_seq")) + 1,0);
						//2.  Delete Cargo Info
						for(var colCt=sheetObj2.SaveNameCol(prefix2+"cntr_grs_wgt"); colCt<=sheetObj2.SaveNameCol(prefix2+"cbf_rmk"); colCt++) {
							sheetObj2.SetCellValue(row, colCt,"",0);
						}
						sheetObj2.SetCellValue(row, prefix2+"cbf_smry_seq","",0);
						sheetObj2.SelectCell(row, prefix2+"cntr_grs_wgt");
					}
					break;
				case "t2btn_RowCopy":
					var row=sheetObj2.DataCopy();
					sheetObj2.SetCellValue(row, prefix2+"cbf_smry_seq","",0);
					sheetObj2.SelectCell(row, prefix2+"prnr_bkg_ref_no");
					break;
				case "t2btn_Delete":
					ComRowHideDelete(sheetObj2, prefix2+"del_chk");
					break;
				case "t1btn_LoadFileTemplate":
        	    	var str = sheetObj2.GetSearchData("apps/opus/vop/opf/cargoloadingplanmgt/owncontainerbookingforecastmgt/jsp/VOP_OPF_0020.xml");
       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
        	    	sheetObj2.Down2Excel({ HiddenColumn:1,DownRows:'0',DownCols:'1' , ReportXML :str});
					break;
				case "t2btn_LoadFileTemplate":
        	    	var str = sheetObj2.GetSearchData("apps/opus/vop/opf/cargoloadingplanmgt/owncontainerbookingforecastmgt/jsp/VOP_OPF_0020_01.xml");
       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
        	    	sheetObj2.Down2Excel({ HiddenColumn:1,DownRows:'0',DownCols:'1' , ReportXML :str});
					break;
				case "t1btn_WGPCalcu":
					if (validateForm(sheetObj1, formObj, IBSEARCH)) {
						calculateWGP(sheetObj1, formObj, true);
					}
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * Setting data from VSL Code Help (Pop-Up)<br>
	 */
	function setCallBackVSL(rtnObjs) {
		var formObj=document.form;
		if (rtnObjs) {
			var rtnDatas=rtnObjs[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
					// changing focus
					ComSetFocus(formObj.skd_voy_no);
				}
			}
		}
	}
	/**
	 * Setting data from VVD Code Help (Pop-Up).<br>
	 */
	function setCallBackVVD(obj) {
		var formObj=document.form;
		var comboObj=comboObjects[0];
		if (obj) {
			var rtnDatas=obj[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
					ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
					//Get VVD Info 
					searchVVDInfo();
				}
			}
		}
	}
	/** 
	 * In case of clicking Summary Preview , call pop-up
	 */
	function openSPPopup(formObj) {	
		var vslCd=ComGetObjValue(formObj.vsl_cd);
		var skdVoyNo=ComGetObjValue(formObj.skd_voy_no);
		var skdDirCd=ComGetObjValue(formObj.skd_dir_cd);
		var ydCd=comboObjects[0].GetSelectCode();
		var ydNm=ComGetObjValue(formObj.yd_nm);
		var crrCd=ComGetObjValue(formObj.crr_cd);
		var vslSlanCd=ComGetObjValue(formObj.slan_cd);
		var paramStr="";
		paramStr += 'vsl_cd=' + vslCd + '&skd_voy_no=' + skdVoyNo + '&skd_dir_cd=' + skdDirCd;
		paramStr += '&yd_cd=' + ydCd + '&yd_nm=' + ydNm + '&cbf_ind_flg=F';
		paramStr += "&vsl_slan_cd=" + vslSlanCd + "&crr_cd=" + crrCd + "&bkg_shpr_ownr_flg=N";	
		ComOpenWindowCenter("VOP_OPF_2019.do?" + paramStr, "win2", "1000", "620", false, "yes");
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {	
		sheetObjects[sheetCnt++]=sheet_obj;	
	}
	/**
	 * registering IBMultiCombo Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj) {	
		comboObjects[comboCnt++]=combo_obj;	
	}
	/**
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		// initializing IBMultiCombo
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		//initializing IBTab
		for (k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		//initializing IBSheet
		for (i=0; i < sheetObjects.length; i++) {	
			ComConfigSheet(sheetObjects[i]);	
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		resizeSheet()
		
		//button deactivating
		ComBtnDisable("btn_LoadFile");
		ComBtnDisable("btn_SummaryPreview");
		ComBtnDisable("t1btn_RowAdd");
		ComBtnDisable("t1btn_RowInsert");
		ComBtnDisable("t1btn_Delete");
		ComBtnDisable("t1btn_LoadFileTemplate");
		ComBtnDisable("t1btn_WGPCalcu");
		ComBtnDisable("t2btn_RowAdd");
		ComBtnDisable("t2btn_CntrAdd");
		ComBtnDisable("t2btn_CgoAdd");
		ComBtnDisable("t2btn_RowCopy");
		ComBtnDisable("t2btn_Delete");
		ComBtnDisable("t2btn_LoadFileTemplate");
		//Handling Axon Event Listener 
		initControl();
		
		t1sheet1_OnLoadFinish(sheetObjects[0]);
	}
    /**
     * Handling sheet1 OnLoadFinish Event 
     * param : sheetObj ==> sheetobject, ErrMsg ==> result Message
     * 
     */
    function t1sheet1_OnLoadFinish(sheetObj) {
    	//initializing Sheet Combo 
    	initSheetCombos(sheetObj);
    }
	//initializing Sheet Combo 
	function initSheetCombos(sheetObj) {
		var sheetObj1=sheetObj;
		var sheetObj2=sheetObjects[1];
		var formObj=document.form;
		//Get Combo List used on sheet : TP, FM, CGO, IMO, POSTEXTD, STWG
		sheetObj1.SetWaitImageVisible(0);
		formObj.f_cmd.value=SEARCHLIST03;
		var sXml=sheetObj1.GetSearchData("VOP_OPF_0020GS.do", FormQueryString(formObj));
		sheetObj1.SetWaitImageVisible(1);
		var arrXml=sXml.split("|$$|");
		//TP
		var arrCombo1=ComXml2ComboString(arrXml[0], "val", "name");
		if (arrCombo1 != null) {			
			var arrVal=arrCombo1[0].split("|");
			var arrName=arrCombo1[1].split("|");
			var itemNm="";
			for ( var j=0; j < arrVal.length; j++) {
				if (j == 0) itemNm=itemNm + arrVal[j]	+ "\t" + arrName[j];
				else itemNm=itemNm + "|" + arrVal[j] + "\t" + arrName[j];
			}
			sheetObj1.SetColProperty(prefix1+"cntr_tpsz_cd", {ComboText:"|"+itemNm, ComboCode:"|"+arrCombo1[0]} );
			sheetObj2.SetColProperty(prefix2+"cntr_tpsz_cd", {ComboText:"|"+itemNm, ComboCode:"|"+arrCombo1[0]} );
		}
		//FM
		var arrCombo2=ComXml2ComboString(arrXml[1], "val", "name");
		if (arrCombo2 != null) {
			var arrVal=arrCombo2[0].split("|");
			var arrName=arrCombo2[1].split("|");
			var itemNm="";
			for ( var j=0; j < arrVal.length; j++) {
				if (j == 0) itemNm=itemNm + arrVal[j] + "\t" + arrName[j];
				else itemNm=itemNm + "|" + arrVal[j] + "\t" + arrName[j];
			}
			sheetObj1.SetColProperty(prefix1+"full_mty_cd", {ComboText:"|"+itemNm, ComboCode:"|"+arrCombo2[0]} );
		}
		//CGO
		var arrCombo3=ComXml2ComboString(arrXml[2], "intg_cd_val_ctnt", "intg_cd_val_ctnt");
		//IMO
		var arrCombo4=ComXml2ComboString(arrXml[3], "val", "name");
		if (arrCombo4 != null) {
			var arrVal=arrCombo4[0].split("|");
			var arrName=arrCombo4[1].split("|");
			var itemNm="";
			for ( var j=0; j < arrVal.length; j++) {
				if (j == 0) itemNm=itemNm + arrVal[j] + "\t" + arrName[j];
				else itemNm=itemNm + "|" + arrVal[j] + "\t" + arrName[j];
			}
			sheetObj2.SetColProperty(prefix2+"imdg_mrn_polut_cd", {ComboText:"|Y", ComboCode:"|Y"} );
			sheetObj2.SetColProperty(prefix2+"lmt_qty_flg", {ComboText:"|Y", ComboCode:"|Y"} );
			sheetObj2.SetColProperty(prefix2+"expt_qty_flg", {ComboText:"|Y", ComboCode:"|Y"} );
		}
		//POSTEXTD
		var arrCombo5=ComXml2ComboString(arrXml[4], "val", "name");		
		if (arrCombo5 != null) {
			sheetObj2.SetColProperty(prefix2+"crn_pst_sts_cd", {ComboText:"|"+arrCombo5[1], ComboCode:"|"+arrCombo5[0]} );
		}
		//STWG
		var arrCombo6=ComXml2ComboString(arrXml[5], "val", "name");		
		if (arrCombo6 != null) {
			var arrVal=arrCombo6[0].split("|");
			var arrName=arrCombo6[1].split("|");
			var itemNm="";
			for ( var j=0; j < arrVal.length; j++) {
				if (j == 0) itemNm=itemNm + arrVal[j] + "\t" + arrName[j];
				else itemNm=itemNm + "|" + arrVal[j] + "\t" + arrName[j];
			}
			sheetObj2.SetColProperty(prefix2+"stwg_cd", {ComboText:"|"+itemNm, ComboCode:"|"+arrCombo6[0]} );
		}
		//site of initial focus
		ComSetFocus(document.form.vsl_cd);	
	}
	/**
	 * Loading event of HTML Control in page dynamically <br>
	 * initializing IBSheet by calling {@link #loadPage}Method  <br>
	 */
	function initControl() {
		// axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		// axon_event.addListenerForm  ('keyup',    'obj_keyup',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
		// axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
	}
	/**
	 * In case of modifying VVD data <br>
	 **/
	function obj_change() {
		var formObj=document.form;		
		with (ComGetEvent()) {
			switch (name) {
				case "vsl_cd": case "skd_voy_no":	
					if(name == 'vsl_cd') ComSetObjValue(formObj.skd_voy_no, "");
					ComSetObjValue(formObj.skd_dir_cd, "");
					//initializing related item					
					//resetForCondition(formObj, "vvd");
					break;
			}
		}
	}
	/**
	 * Handling next focus OnKeyUp event automatically after required input <br>
	 **/
//	function obj_keyup() {
//		 if(event.keyCode != 9) obj_nextfocus(ComGetEvent());
//	}
	//change focus to next HTML Tag(object) of HTML Tag(object) received as factor
	function obj_nextfocus(obj) {
		var formObj=document.form;
		var objMaxLength=obj.getAttribute("maxlength");
		var objValue=obj.getAttribute("value");
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else if(obj.name != 'crr_cd') ComSetNextFocus(obj);
			if (obj.name == 'vsl_cd') {
				ComSetObjValue(formObj.skd_voy_no, "");
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if (obj.name == 'skd_voy_no') {
				ComSetObjValue(formObj.skd_dir_cd, "");
			}
		}
	}
	/**
	 * Handling work java script OnFocusOut Event  <br>
	 **/
	var beforeCrrCd;
	var beforeActiveObj=null;
	function obj_blur() {
		pastEventNum=0;
		var formObj=document.form;
		var tabObj=tabObjects[0];
		var selTabIdx=tabObj.GetSelectedIndex();
		with (ComGetEvent()) {	
			switch (name) {	
				case "skd_dir_cd":	
					if (value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {						
						//Get VVD Info 
						searchVVDInfo();
					}		
					break;
				case "crr_cd":	
					if(beforeCrrCd != value) {
						if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
							if (ComShowCodeConfirm("OPF50003")) {
								ComSetObjValue(ComGetEvent(), beforeCrrCd);
								//save						
								doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);							
								ComSetFocus(ComGetEvent());
								return;
							}
						}
			    		if(value != '' && document.activeElement.id != 'crr_cd' && beforeActiveObj != document.activeElement.id) {	
			    			beforeActiveObj=document.activeElement.id;		    			
			    	      	var sheetObj=sheetObjects[(selTabIdx==1?0:1)];
			    	      	var sParam=Array();
			    	  	  	sParam[0]="crr_cd="+value;
			    	  	  	sParam[1]="f_cmd="+SEARCH01;
			    	  	  	if(sParam.join("").length > 18) {  
			    	  	  		sheetObj.SetWaitImageVisible(0);
			    	  	  		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
			    	  	    	sheetObj.SetWaitImageVisible(1);
			    	  	    	var crrData=ComOpfXml2Array(sXml, "crr_cd");
			    	  		   	if(crrData == null) {
			    	  			    ComShowCodeMessage("OPF50004",'Data');	//'{?msg1} is invalid.'
			    	  			    ComSetObjValue(ComGetEvent(), ""); 	
			    	 	 		    ComSetFocus(ComGetEvent());
			    	  		   	} 
			    	  			if (crrData == ConstantMgr.getCompanyCode()) {
			    	  				ComShowCodeMessage("OPF50029", "");
			    	  				formObj.crr_cd.value = "";
			    	  				return false;
			    	  			}
			    	  	  	} else {
			    	  	  		ComChkObjValid(obj, true);
			    	  	  	}
			    		}
			    		beforeCrrCd=value;
					}
		        	break;
				default:
					break;
			}
		}
		beforeActiveObj=null;
	}
	/**
	 * In case of inputting retrieve condition Validation <br>
	 **/
//	function obj_keypress() {	
//		switch (ComGetEvent().dataformat) {
//			case "engup":
//				switch (ComGetEvent().name) {
//					case "vsl_cd":
//						//Inputting capital
//						ComKeyOnlyAlphabet('uppernum');
//						break;
//					case "skd_voy_no":
//						//Inputting number
//						ComKeyOnlyNumber(ComGetEvent());
//						break;
//					case "skd_dir_cd":
//						//Inputting capital
//						ComKeyOnlyAlphabet('upper');
//						break;
//					case "crr_cd":
//						//Inputting capital
//						ComKeyOnlyAlphabet('upper');
//						break;
//					default:
//						//Recognizing number and capital :  common standard
//						ComKeyOnlyAlphabet("num");
//						break;
//				}
//				break;
//			default:
//				//Recognizing number and capital :  common standard
//				ComKeyOnlyAlphabet("num");
//				break;
//		}
//	}
	/**
	 * Retrieve VVD Info <br>
	 **/
	function searchVVDInfo() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var comboObj=comboObjects[0];
		//initializing related item
		resetForCondition(formObj, "vvd");
		formObj.f_cmd.value=SEARCH05;
		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		var vvdData=ComOpfXml2Array(sXml, "vsl_eng_nm|vsl_slan_cd|vsl_slan_nm");
		if (vvdData == null) {
			ComShowCodeMessage("OPF50004", 'Data');
			//initializing related item
			resetForCondition(formObj, "vvd");
			ComSetObjValue(formObj.vsl_cd,     "");
			ComSetObjValue(formObj.skd_voy_no, "");
			ComSetObjValue(formObj.skd_dir_cd, "");
			//chage focus
			ComSetFocus(formObj.vsl_cd);
		} else {
			ComSetObjValue(formObj.vsl_eng_nm,  vvdData[0][0]);
			ComSetObjValue(formObj.slan_cd,     vvdData[0][1]);
			ComSetObjValue(formObj.slan_nm,     vvdData[0][2]);
			//Get POL 
			formObj.f_cmd.value=SEARCH01;
			//evincive Creation parameter 
 			var formParams="";
     		formParams += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
     		formParams += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
     		formParams += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
     		formParams += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd);     		
     		var sXml=sheetObj.GetSearchData("VOP_OPF_0019GS.do", formParams);
			var sPol=ComGetEtcData(sXml, "sPol");
			if (sPol != undefined) {
				var arrPol=sPol.split("|");
				var polCd=""; //yd_code + clpt_ind_seq
				for (var cCt=0; cCt<arrPol.length; cCt++) {
					polCd=arrPol[cCt];
					if(polCd != '') polCd=polCd.substring(0, polCd.length-1); 
					comboObj.InsertItem(cCt, polCd, arrPol[cCt]);
				}
			}
			//change focus
			ComSetFocus(yd_cd);
		}
		sheetObj.SetWaitImageVisible(1);
	}
	/**
	 * initializing related item in case of changing VVD/POL  <br>
	 **/
	function resetForCondition(formObj, what) {
		var comboObj=comboObjects[0];
		//VVD
		if(what.indexOf("vvd") != -1) {
			if(what.indexOf("pol") == -1) {
				ComSetObjValue(formObj.vsl_eng_nm, "");
				ComSetObjValue(formObj.slan_cd,    "");
				ComSetObjValue(formObj.slan_nm,    "");			
				comboObj.RemoveAll();
			}
			ComSetObjValue(formObj.loc_nm,     "");
			ComSetObjValue(formObj.yd_nm,      "");
			ComSetObjValue(formObj.eta,        "");
			ComSetObjValue(formObj.upd_usr_id, "");
			ComSetObjValue(formObj.upd_dt,     "");
			ComSetObjValue(formObj.crr_cd,     "");
		}
		for (var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {	
			sheetObjects[sheetCt].RemoveAll();
		}
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_LoadFile");
		ComBtnDisable("btn_SummaryPreview");
		ComBtnDisable("t1btn_RowAdd");
		ComBtnDisable("t1btn_RowInsert");
		ComBtnDisable("t1btn_Delete");
		ComBtnDisable("t1btn_LoadFileTemplate");
		ComBtnDisable("t1btn_WGPCalcu");
		ComBtnDisable("t2btn_RowAdd");
		ComBtnDisable("t2btn_CntrAdd");
		ComBtnDisable("t2btn_CgoAdd");
		ComBtnDisable("t2btn_RowCopy");
		ComBtnDisable("t2btn_Delete");
		ComBtnDisable("t2btn_LoadFileTemplate");
	}
	/**
	 * initializing IBCOMBO  <br>
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
			case "yd_cd":
				with (comboObj) {
					SetBackColor("#CCFFFF");
					SetDropHeight(200);
					SetMultiSelect(0);
					SetMaxSelect(1);
				}
				break;
		}
	}
	/**
	 * In case of selecting POL combo data <br>
	 **/
	var beforeYdCd;
	function yd_cd_OnChange(comboObj, Code, Text) {
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var comboObj=comboObjects[0];
		if (sheetObj1.IsDataModified()|| sheetObj2.IsDataModified()) {
			if (ComShowCodeConfirm("OPF50003")) {
				var tabObj=tabObjects[0];
				var selTabIdx=tabObj.GetSelectedIndex();
				//save						
				doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);
				//restore to previous state 
				comboObj.SetSelectText(beforeYdCd,false);
				return;
			}
		}
		//maintain previous POL value
		beforeYdCd=Text;
		//initializing related item
		resetForCondition(formObj, "vvd-pol");
		if(Code != '') {		
			//Get POL Info 
			formObj.f_cmd.value=SEARCH02;
			sheetObj1.SetWaitImageVisible(0);
 
			//evincive Creation parameter
 			var formParams="";
     		formParams += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
     		formParams += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
     		formParams += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
     		formParams += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd); 
     		formParams += "&yd_cd="      +comboObjects[0].GetSelectCode();
     		var sXml=sheetObj1.GetSearchData("VOP_OPF_0019GS.do", formParams);
			sheetObj1.SetWaitImageVisible(1);
			var sPol=ComGetEtcData(sXml, "sPol");
			if (sPol != undefined) {
				var arrPol=sPol.split("|");
				ComSetObjValue(formObj.loc_nm, arrPol[0]);
				ComSetObjValue(formObj.yd_nm,  arrPol[1]);
				ComSetObjValue(formObj.eta,    arrPol[2]);
			}
			//Get POD 
			var polCd=Text.substring(0, 5);
			var sParam=Array();
			sParam[0]="vsl_cd="     + ComGetObjValue(formObj.vsl_cd);
			sParam[1]="skd_voy_no=" + ComGetObjValue(formObj.skd_voy_no);
			sParam[2]="skd_dir_cd=" + ComGetObjValue(formObj.skd_dir_cd);
			sParam[3]="f_cmd="      + SEARCH10;
			sheetObj1.SetWaitImageVisible(0);
			var sXml=sheetObj1.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
			sheetObj1.SetWaitImageVisible(1);
			var arrCombo=ComXml2ComboString(sXml, "loc_cd", "loc_nm");
			if (arrCombo != null && arrCombo.length > 0) {
				var locCds=ComOpfXml2Array(sXml, "loc_cd");
				var clptSeqs=ComOpfXml2Array(sXml, "clpt_seq");
				var clptIndSeqs=ComOpfXml2Array(sXml, "clpt_ind_seq");
				var podCombo=new Array();
				var podCombo1=new Array();
				var podCombo2=new Array();
				var podCombo3=new Array();
				var polClptSeq="0";
				var newPodIdx=0;
				for ( var arrIdx1=0; arrIdx1 < locCds.length; arrIdx1++) {
					if (locCds[arrIdx1] == polCd) polClptSeq=clptSeqs[arrIdx1];
				}
				for ( var arrIdx2=0; arrIdx2 < locCds.length; arrIdx2++) {
					if (locCds[arrIdx2] != null && locCds[arrIdx2] != '') {
						if (parseInt(clptSeqs[arrIdx2]) > parseInt(polClptSeq)) {
							podCombo[newPodIdx]=locCds[arrIdx2];
							podCombo1[newPodIdx]=locCds[arrIdx2]+clptIndSeqs[arrIdx2];
							newPodIdx++;
						}
					}
				}
				podCombo2=podCombo.join('|');
				podCombo3=podCombo1.join('|');
				sheetObj1.SetColProperty(prefix1+"pod_cd", {ComboText:"|"+podCombo2, ComboCode:"|"+podCombo3} );
				sheetObj2.SetColProperty(prefix2+"pod_cd", {ComboText:"|"+podCombo2, ComboCode:"|"+podCombo3} );
			} else {
				sheetObj1.SetColProperty(prefix1+"pod_cd", {ComboText:"", ComboCode:""} );
				sheetObj2.SetColProperty(prefix2+"pod_cd", {ComboText:"", ComboCode:""} );
			}
			ComSetFocus(formObj.crr_cd);
		}
	}
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * 　 adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
			case 1: // sheet1 init
			    with(sheetObj){
				      var HeadTitle="|No.||POD|MLB|CNTR No.|CGO OPR|TP|WGP|F/E|Q'ty|CN GR WT (kg)|||||||||||CBF DP CD|HIDDEN";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"No." },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"mlb_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix1+"prnr_cntr_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"crr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"cntr_tpsz_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"cntr_wgt_grp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"full_mty_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"cntr_qty",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"cntr_grs_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_usr_id" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_dt" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"vsl_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_voy_no" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_dir_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"yd_cd"},
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pol_clpt_ind_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"bkg_shpr_ownr_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cbf_smry_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"slan_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cbf_dp_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"hid" } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetHeaderRowHeight(20);
				      //SetSheetHeight(340);
					}
				break;
			case 2: // sheet2 init
			    with(sheetObj){
				      var HeadTitle1="|No.||BKG Ref. No.|CNTR No.|POD|MLB|CGO\nOPR|TP|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Seq.|Seq.|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|SRL|MP|PG|LQ|EQ|FP\n(°C)|Reefer\nTemp.(°C)|Commodity|OverAll (cm)|OverAll (cm)|OverAll (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\n Extd.|STWG|APVL Ref. No.|Remark(s)||||||||||||";
				      var HeadTitle2="|No.||BKG Ref. No.|CNTR No.|POD|MLB|CGO\nOPR|TP|DG|RF|AK|BB|ST|CNTR|CGO|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|SRL|MP|PG|LQ|EQ|FP\n(°C)|Reefer\nTemp.(°C)|Commodity|L|W|H|FWD|AFT|Left|Right|Height|Post\n Extd.|STWG|APVL Ref. No.|Remark(s)||||||||||||";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"No." },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"del_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,HeaderCheck:1},
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix2+"prnr_bkg_ref_no",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				             {Type:"Text",      Hidden:0,  Width:86,   Align:"Left",    ColMerge:1,   SaveName:prefix2+"prnr_cntr_ref_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"CeVOP_OPF_0021nter",  ColMerge:1,   SaveName:prefix2+"pod_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"mlb_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"crr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cntr_tpsz_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"dcgo_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 ,TrueValue:"Y",FalseValue:"N",HeaderCheck:0},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"rc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 ,TrueValue:"Y",FalseValue:"N",HeaderCheck:0},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"awk_cgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 ,TrueValue:"Y",FalseValue:"N",HeaderCheck:0},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"bb_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 ,TrueValue:"Y",FalseValue:"N",HeaderCheck:0},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"stwg_cgo_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 ,TrueValue:"Y",FalseValue:"N",HeaderCheck:0},
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cntr_seq",             KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
				             {Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cgo_seq",              KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"cntr_grs_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"cgo_grs_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"imdg_clss_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"imdg_un_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"imdg_subs_rsk_lbl_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"imdg_mrn_polut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pck_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"lmt_qty_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"expt_qty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"fdo_temp",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cdo_temp",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"cbf_cmdt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"dim_len",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"dim_wdt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"dim_hgt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
				             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"fwrd_ovr_dim_len",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"bkwd_ovr_dim_len",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"lf_sd_ovr_dim_len",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"rt_sd_ovr_dim_len",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"hgt_ovr_dim_len",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				             {Type:"Combo",     Hidden:0, Width:45,   Align:"Left",    ColMerge:1,   SaveName:prefix2+"crn_pst_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"stwg_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"apro_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"cbf_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"upd_usr_id" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"upd_dt" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"vsl_cd",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"skd_voy_no" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"skd_dir_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"bkg_shpr_ownr_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"yd_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pol_clpt_ind_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cbf_smry_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cbf_dp_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"prp_shp_nm" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"hid" } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetImageList(0,"img/opus/button/btns_multisearch.gif");
				      SetImageList(1,"img/opus/button/btng_minus.gif");
				      SetFocusEditMode(-1);
				      SetHeaderRowHeight(20);
				      //SetSheetHeight(420);
				      SetHeaderCheck(0, 2, 1);
		      		}
				break;
		}
	}
	
    function resizeSheet(){    	
    	for (i=0; i<sheetObjects.length; i++){
    		ComResizeSheet2(sheetObjects[i]);
        }
    }
    
	/**
	 * handle after Retrieving t1sheet1 
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		var tabObj=tabObjects[0];		
		var selTabIdx=tabObj.GetSelectedIndex();
		with (sheetObj) {
			if(RowCount()> 0) {
				ColumnSort(prefix1+"upd_dt");
				ComSetObjValue(formObj.upd_usr_id, GetCellValue(LastRow(), prefix1+"upd_usr_id"));
				ComSetObjValue(formObj.upd_dt,     GetCellValue(LastRow(), prefix1+"upd_dt"));
				ColumnSort(prefix1+"pod_cd|"+prefix1+"cntr_tpsz_cd|"+prefix1+"prnr_cntr_ref_no");
				ComBtnEnable("btn_SummaryPreview");	
			}
		}
		sheetObj.SetHeaderCheck(0, 2,0);
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_LoadFile");
		ComBtnEnable("t1btn_RowAdd");
		ComBtnEnable("t1btn_RowInsert");
		ComBtnEnable("t1btn_Delete");
		ComBtnEnable("t1btn_LoadFileTemplate");
		ComBtnEnable("t1btn_WGPCalcu");
	}
	/**
	 * handle after uploading t1sheet1 excel
	 */
	function t1sheet1_OnLoadExcel(sheetObj) {
		var formObj=document.form;
		var comboObj=comboObjects[0];
		//Setting data basic information loaded
		if (sheetObj.RowCount()> 0) {
			sheetObj.RenderSheet(0);
			for (var rowCt=sheetObj.HeaderRows(); rowCt <= sheetObj.LastRow(); rowCt++) {
				if (sheetObj.GetRowStatus(rowCt) != "D") {
					sheetObj.SetCellValue(rowCt, prefix1+"crr_cd",ComGetObjValue(formObj.crr_cd),0);
					sheetObj.SetCellValue(rowCt, prefix1+"vsl_cd",ComGetObjValue(formObj.vsl_cd),0);
					sheetObj.SetCellValue(rowCt, prefix1+"skd_voy_no",ComGetObjValue(formObj.skd_voy_no),0);
					sheetObj.SetCellValue(rowCt, prefix1+"skd_dir_cd",ComGetObjValue(formObj.skd_dir_cd),0);
					sheetObj.SetCellValue(rowCt, prefix1+"yd_cd", yd_cd.GetSelectText(),0);
					sheetObj.SetCellValue(rowCt, prefix1+"pol_clpt_ind_seq",yd_cd.GetSelectCode().substring(yd_cd.GetSelectCode().length-1, yd_cd.GetSelectCode().length),0);
					sheetObj.SetCellValue(rowCt, prefix1+"pod_clpt_ind_seq",sheetObj.GetCellValue(rowCt, prefix1+"pod_clpt_ind_seq") + "1",0);
					sheetObj.SetCellValue(rowCt, prefix1+"bkg_shpr_ownr_flg","N",0);
					sheetObj.SetCellValue(rowCt, prefix1+"cbf_dp_cd","V",0);
					sheetObj.SetCellValue(rowCt, prefix1+"hid","V",0);
					for (var colCt=0; colCt <= sheetObj.LastCol(); colCt++) {
						sheetObj.SelectCell(rowCt, colCt);
					}
				}
			}
			sheetObj.RenderSheet(1);
		}
	}
	/**
	 *  handle after Retrieving t2sheet1 
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		var tabObj=tabObjects[0];		
		var selTabIdx=tabObj.GetSelectedIndex();
		with (sheetObj) {
			if(RowCount()> 0) {
				ColumnSort(prefix2+"upd_dt");
				if(ComGetObjValue(formObj.upd_dt) != '') {
					var updDt1=ComGetObjValue(formObj.upd_dt);
					var updDt2=GetCellValue(LastRow(), prefix2+"upd_dt");
					updDt1=updDt1.replaceStr("-", "").replaceStr(" ", "").replaceStr(":", "");
					updDt2=updDt2.replaceStr("-", "").replaceStr(" ", "").replaceStr(":", "");
					if(parseInt(updDt1) < parseInt(updDt2)) {
						ComSetObjValue(formObj.upd_usr_id, GetCellValue(LastRow(), prefix2+"upd_usr_id"));
						ComSetObjValue(formObj.upd_dt,     GetCellValue(LastRow(), prefix2+"upd_dt"));
					}
				} else {
					ComSetObjValue(formObj.upd_usr_id, GetCellValue(LastRow(), prefix2+"upd_usr_id"));
					ComSetObjValue(formObj.upd_dt,     GetCellValue(LastRow(), prefix2+"upd_dt"));
				}
				ColumnSort(prefix2+"pod_cd|"+prefix2+"mlb_cd|"+prefix2+"cntr_tpsz_cd"+prefix2+"cntr_seq|"+prefix2+"cgo_seq|"+prefix2+"prnr_bkg_ref_no|"+prefix2+"prnr_cntr_ref_no");
				for (var rowCt=HeaderRows(); rowCt <= LastRow(); rowCt++) {
					isEditCol(sheetObj, rowCt);
					SetRowStatus(rowCt,"R");
				}
				ComBtnEnable("btn_SummaryPreview");	
			}
		}
		sheetObj.SetHeaderCheck(0, 2,0);
		sheetObj.SetHeaderCheck(1, 2,0);
		ComBtnEnable("t2btn_RowAdd");
		ComBtnEnable("t2btn_CntrAdd");
		ComBtnEnable("t2btn_CgoAdd");
		ComBtnEnable("t2btn_RowCopy");
		ComBtnEnable("t2btn_Delete");
		ComBtnEnable("t2btn_LoadFileTemplate");
	}
	/**
	 * handle after uploading t2sheet1 excel
	 */
	function t2sheet1_OnLoadExcel(sheetObj) {
		var formObj=document.form;
		var comboObj=comboObjects[0];
		//setting data basic information loaded
		if (sheetObj.RowCount()> 0) {
			sheetObj.RenderSheet(0);
			for (var rowCt=sheetObj.HeaderRows(); rowCt <= sheetObj.LastRow(); rowCt++) {
				if (sheetObj.GetRowStatus(rowCt) != "D") {
					sheetObj.SetCellValue(rowCt, prefix2+"crr_cd",ComGetObjValue(formObj.crr_cd),0);
					sheetObj.SetCellValue(rowCt, prefix2+"vsl_cd",ComGetObjValue(formObj.vsl_cd),0);
					sheetObj.SetCellValue(rowCt, prefix2+"skd_voy_no",ComGetObjValue(formObj.skd_voy_no),0);
					sheetObj.SetCellValue(rowCt, prefix2+"skd_dir_cd",ComGetObjValue(formObj.skd_dir_cd),0);
					sheetObj.SetCellValue(rowCt, prefix2+"yd_cd",yd_cd.GetSelectText(),0);
					sheetObj.SetCellValue(rowCt, prefix2+"pol_clpt_ind_seq",yd_cd.GetSelectCode().substring(yd_cd.GetSelectCode().length-1, yd_cd.GetSelectCode().length),0);
					sheetObj.SetCellValue(rowCt, prefix2+"pod_clpt_ind_seq",sheetObj.GetCellValue(rowCt, prefix2+"pod_clpt_ind_seq") + "1",0);
					sheetObj.SetCellValue(rowCt, prefix2+"bkg_shpr_ownr_flg","N",0);
					sheetObj.SetCellValue(rowCt, prefix2+"cbf_dp_cd","S",0);
					sheetObj.SetCellValue(rowCt, prefix2+"hid","S",0);
					//except from Un No. related item upload
//					sheetObj.SetCellValue(rowCt, prefix2+"imdg_un_no","",0);
//					sheetObj.SetCellValue(rowCt, prefix2+"imdg_clss_cd","",0);
//					sheetObj.SetCellValue(rowCt, prefix2+"prp_shp_nm","",0);
//					sheetObj.SetCellValue(rowCt, prefix2+"imdg_subs_rsk_lbl_cd","",0);
//					sheetObj.SetCellValue(rowCt, prefix2+"pck_grp_cd","",0);
//					for (var colCt=0; colCt <= sheetObj.LastCol(); colCt++) {
//						if(colCt>=sheetObj.SaveNameCol(prefix2+"imdg_mrn_polut_cd") &&
//						   colCt<=sheetObj.SaveNameCol(prefix2+"stwg_cd")           &&
//						   colCt!=sheetObj.SaveNameCol(prefix2+"pck_grp_cd"))
//						{
//							sheetObj.SetCellEditable(rowCt, colCt,1);
//						}
//						sheetObj.SelectCell(rowCt, colCt);
//					}
					//Setting edit item by Cargo
//					isEditCol(sheetObj, rowCt);
				}
			}
			sheetObj.RenderSheet(1);
		}	
	}
	/**
	 * Setting edit item by Cargo
	 */
	function isEditCol(sheetObj, row) {		
		with(sheetObj) {
			var dcgoFlg=GetCellValue(row, prefix2+"dcgo_flg");
			var rcFlg=GetCellValue(row, prefix2+"rc_flg");
			var awkCgoFlg=GetCellValue(row, prefix2+"awk_cgo_flg");
			var bbCgoFlg=GetCellValue(row, prefix2+"bb_cgo_flg");
			var stwgCgoFlg=GetCellValue(row, prefix2+"stwg_cgo_flg");
			var dgBool=false;
			var rfBool=false;
			var abBool=false;
			var akBool=false;
			var stBool=false;
			var alBool=false;
			if(dcgoFlg == '1' || dcgoFlg == 'Y') {
				dgBool=true;
				alBool=true;
			}
			if(rcFlg == '1' || rcFlg == 'Y') {
				rfBool=true;
				alBool=true;
			}
			if(awkCgoFlg == '1' || awkCgoFlg == 'Y' || bbCgoFlg == '1' || bbCgoFlg == 'Y') {
				abBool=true;
				alBool=true;
				if(awkCgoFlg == '1' || awkCgoFlg == 'Y') akBool=true;
			}
			if(stwgCgoFlg == '1' || stwgCgoFlg == 'Y') {
				stBool=true;
				alBool=true;
			}
			//DG
			if(!dgBool) {
				SetCellValue(row, prefix2+"imdg_clss_cd","",0);
				SetCellValue(row, prefix2+"imdg_un_no","",0);
				SetCellValue(row, prefix2+"imdg_subs_rsk_lbl_cd","",0);
				SetCellValue(row, prefix2+"imdg_mrn_polut_cd","",0);
				SetCellValue(row, prefix2+"pck_grp_cd","",0);
				SetCellValue(row, prefix2+"lmt_qty_flg","",0);
				SetCellValue(row, prefix2+"expt_qty_flg","",0);
				SetCellValue(row, prefix2+"fdo_temp","",0);
				SetCellValue(row, prefix2+"prp_shp_nm","",0);
			}
			SetCellEditable(row, prefix2+"imdg_un_no",dgBool);
			SetCellEditable(row, prefix2+"imdg_mrn_polut_cd",dgBool);
			SetCellEditable(row, prefix2+"lmt_qty_flg",dgBool);
			SetCellEditable(row, prefix2+"expt_qty_flg",dgBool);
			SetCellEditable(row, prefix2+"fdo_temp",dgBool);
			//RF
			if(!rfBool) {
				SetCellValue(row, prefix2+"cdo_temp","",0);
			}
			SetCellEditable(row, prefix2+"cdo_temp",rfBool);
			//AK, BB
			if(!abBool) {
				SetCellValue(row, prefix2+"dim_len","",0);
				SetCellValue(row, prefix2+"dim_wdt","",0);
				SetCellValue(row, prefix2+"dim_hgt","",0);
			}
			SetCellEditable(row, prefix2+"dim_len",abBool);
			SetCellEditable(row, prefix2+"dim_wdt",abBool);
			SetCellEditable(row, prefix2+"dim_hgt",abBool);
			//AK
			if(!akBool) {
				SetCellValue(row, prefix2+"fwrd_ovr_dim_len","",0);
				SetCellValue(row, prefix2+"bkwd_ovr_dim_len","",0);
				SetCellValue(row, prefix2+"lf_sd_ovr_dim_len","",0);
				SetCellValue(row, prefix2+"rt_sd_ovr_dim_len","",0);
				SetCellValue(row, prefix2+"hgt_ovr_dim_len","",0);
				SetCellValue(row, prefix2+"crn_pst_sts_cd","",0);
			}
			SetCellEditable(row, prefix2+"fwrd_ovr_dim_len",akBool);
			SetCellEditable(row, prefix2+"bkwd_ovr_dim_len",akBool);
			SetCellEditable(row, prefix2+"lf_sd_ovr_dim_len",akBool);
			SetCellEditable(row, prefix2+"rt_sd_ovr_dim_len",akBool);
			SetCellEditable(row, prefix2+"hgt_ovr_dim_len",akBool);
			SetCellEditable(row, prefix2+"crn_pst_sts_cd",akBool);
			//ST
			if(!stBool) {
				SetCellValue(row, prefix2+"stwg_cd","",0);
			}
			SetCellEditable(row, prefix2+"stwg_cd",stBool);
			//common
			if(!alBool) {
				SetCellValue(row, prefix2+"cbf_cmdt_nm","",0);
			}
			SetCellEditable(row, prefix2+"cbf_cmdt_nm",alBool);
		}
	}
	/**
	 * decide Weight Group state
	 */
	function fixWeightGroup(formObj, sheetObj, row, weitImgFlg) {			
		with(sheetObj) {	
			RenderSheet(0);
				if (GetRowStatus(row) != "D" && GetRowStatus(row) != "R") {
				var cntrGrsWgtVal=GetCellValue(row, prefix1+"cntr_grs_wgt");
				var cntrQtyVal=GetCellValue(row, prefix1+"cntr_qty");
				var fullMtyCdVal=GetCellValue(row, prefix1+"full_mty_cd");
				var cntrTpszCdVal=GetCellValue(row, prefix1+"cntr_tpsz_cd");
				var cntrTpszCdVal2=cntrTpszCdVal.substring(1, 2);
				if (fullMtyCdVal == 'F' && (cntrQtyVal != "" && cntrQtyVal != "0") && (cntrTpszCdVal2 == "2" || cntrTpszCdVal2 == "3" || cntrTpszCdVal2 == "4" || cntrTpszCdVal2 == "5" || cntrTpszCdVal2 == "7")
				) {
					if (cntrGrsWgtVal == "0") {
						if(GetCellValue(row, prefix1+"cntr_wgt_grp_cd") != "Ultra Light") SetCellValue(row, prefix1+"cntr_wgt_grp_cd","Ultra Light",0);
					} else {
						ComSetObjValue(formObj.cntr_grs_wgt, cntrGrsWgtVal);
						ComSetObjValue(formObj.cntr_tpsz_cd, cntrTpszCdVal);
						ComSetObjValue(formObj.cntr_qty,     cntrQtyVal);
						SetWaitImageVisible(weitImgFlg);
						formObj.f_cmd.value=SEARCH19;
						var sXml=GetSearchData("VOP_OPF_0020GS.do", FormQueryString(formObj));
						var sWGP=ComGetEtcData(sXml, "sWGP");						
						SetWaitImageVisible(1);
						if (typeof sWGP == "undefined" || sWGP == "") {	
							if(GetCellValue(row, prefix1+"cntr_wgt_grp_cd") != '') SetCellValue(row, prefix1+"cntr_wgt_grp_cd","",0);
						} else {
							if(GetCellValue(row, prefix1+"cntr_wgt_grp_cd") != sWGP) SetCellValue(row, prefix1+"cntr_wgt_grp_cd",sWGP,0);
						}
					}
				} else {
					if(GetCellValue(row, prefix1+"cntr_wgt_grp_cd") != '') SetCellValue(row, prefix1+"cntr_wgt_grp_cd","",0);
				}
			}
			RenderSheet(1);
		}
	}
	/**
	 * calculate Weight Group 
	 */
	function calculateWGP(sheetObj, formObj, weitImgFlg) {
		//1. check mandatory item necessary for calculation
		var sParam=ComGetSaveString(sheetObj, false, true);
 		if (sParam == "") return;
		//2. check Container Qty quantity
		if (validateForm(sheetObj, formObj, IBROWSEARCH)) {	 			
			for (var rowCt=sheetObj.HeaderRows(); rowCt <= sheetObj.LastRow(); rowCt++) {
				fixWeightGroup(formObj, sheetObj, rowCt, weitImgFlg);
			}
		}
	}
	/**
	 * Sheet1 OnChange Event
	 */
	function t1sheet1_OnChange(sheetObj, row, col, value) {			
		with(sheetObj) {
			if (ColSaveName(col) == prefix1+"full_mty_cd"  ||
				ColSaveName(col) == prefix1+"cntr_tpsz_cd" ||
				ColSaveName(col) == prefix1+"cntr_qty"     ||
				ColSaveName(col) == prefix1+"cntr_grs_wgt") {
				fixWeightGroup(document.form, sheetObj, row, false);		
			}
		}
	}
	/**
	 * Sheet2 OnChange Event
	 */
	function t2sheet1_OnChange(sheetObj, row, col, value) {

		 with(sheetObj) {
			if (ColSaveName(col) == prefix2+"dcgo_flg"     ||
				ColSaveName(col) == prefix2+"rc_flg"       ||
				ColSaveName(col) == prefix2+"awk_cgo_flg"  ||
				ColSaveName(col) == prefix2+"bb_cgo_flg"   ||
				ColSaveName(col) == prefix2+"stwg_cgo_flg")
			{		
				isEditCol(sheetObj, row);		
			} else if (row >= HeaderRows()&& ColSaveName(col) == prefix2+"imdg_un_no") {
				//var len = GetEditText().length;
				var len = GetCellValue(row, col).length;
				if (len >=4) {
					checkUNNo(sheetObj, row, col);
				} else {
					if(GetCellValue(row, col) != "") {
						ComShowCodeMessage("OPF50004",'Data');	//'{?msg1} is invalid.'
						SetCellValue(row, prefix2+"imdg_un_no","",0);
						SelectCell(row, col);
					}
					// initializing Sheet Row 
					SetCellValue(row, prefix2+"imdg_clss_cd","",0);
					SetCellValue(row, prefix2+"prp_shp_nm","",0);
					SetCellValue(row, prefix2+"imdg_subs_rsk_lbl_cd","",0);
					SetCellValue(row, prefix2+"pck_grp_cd","",0);
				}
			}
		}

	}
	// handling process related Sheet
	function doActionIBSheet(sheetObj, formObj, sAction, col, row) {
	 	sheetObj.ShowDebugMsg(false);
	 	switch (sAction) {
	 		case IBSEARCH: //Retrieve
	 			if (!validateForm(sheetObj, formObj, sAction)) return false;
	 			
	 			ComOpenWait(true);
				setTimeout(function(){
		 			sheetObj.RenderSheet(1);
			 		var prefixs=new Array(prefix1, prefix2);
			 		formObj.f_cmd.value=SEARCHLIST01;
			 		var sXml=sheetObj.GetSearchData("VOP_OPF_0020GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs));
		 			var arrXml=sXml.split("|$$|");
		 			if (arrXml.length > 1) {
		 				for ( var i=0; i < arrXml.length; i++) {
		 					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
		 				}
		 			}
		 			sheetObj.RenderSheet(1);				
					ComOpenWait(false);
				},300);	
				

	 			break;
	 		case IBSAVE: //save
		 		var sParam=ComGetSaveString(sheetObjects);
		 		if (sParam == "") return;
		 		if (validateForm(sheetObj, formObj, sAction)) {	 
		 			//Weight Group calculation1 - check Container Qty '0' quantity
		 			if (!validateForm(sheetObj, formObj, IBROWSEARCH)) return;
		 			//Weight Group calculation2
			 		calculateWGP(sheetObjects[0], formObj, false);			 		
			 		sParam=ComGetSaveString(sheetObjects);
			 		ComOpenWait(true);
					setTimeout(function(){
				 		sheetObj.RenderSheet(0);
			 			formObj.f_cmd.value=MULTI;	
			 			sParam += "&" + FormQueryString(formObj);
			 			var sXml=sheetObj.GetSaveData("VOP_OPF_0020GS.do", sParam);
			 			if(ComGetEtcData(sXml, 'Exception') == '') {
			 				var start = sXml.indexOf('<MESSAGE>');
			 				var end = sXml.indexOf('</MESSAGE>');
			 				ComShowMessage(sXml.substring(start+18, end-4));
			 			}					
						ComOpenWait(false);
					},300);	
					

//		 			sheetObj.LoadSaveData(sXml);
//		 			doActionIBSheet(sheetObj, formObj, IBSEARCH); 
//		 			sheetObj.RenderSheet(1);
		 		}
		 		break;	
	 		case IBLOADEXCEL: // load excel
	 			switch (sheetObj.id) {
 				case "t1sheet1":
// 					sheetObj.RemoveAll();	// reset
 					sheetObj.SetWaitImageVisible(0);
 					formObj.f_cmd.value=SEARCH06;
 					var sXml=sheetObj.GetSearchData("VOP_OPF_0020GS.do", FormQueryString(formObj));
 					sheetObj.SetWaitImageVisible(1);
 					var sCBFCount=ComGetEtcData(sXml, "sPCBFCount");
 					var mappingCol="|||1|2|3||4||5|6|7";
 					sheetObj.RenderSheet(0);
 					if (sCBFCount > 0) {
		 				if (ComShowCodeConfirm("OPF50019")) {
		 					sheetObj.CheckAll(prefix1+"del_chk",1);
		 					var rslt = sheetObj.LoadExcel({ Mode:"HeaderSkip",StartRow:"2",Append:true,ColumnMapping:mappingCol});
		 					ComRowHideDelete(sheetObj , "t1sheet1_del_chk");
//		 					if(rslt) {
//		 						//change original data to delete state	 						
//		 						ComRowHideDelete(sheetObj, prefix1+"del_chk");			 						
//		 					} else {
//		 						sheetObj.CheckAll(prefix1+"del_chk",0);
//		 					}
		 					sheetObj.SetHeaderCheck(0, 2,0);
		 				}
		 			} else {		
		 				sheetObj.CheckAll(prefix1+"del_chk",1);
		 				var rslt = sheetObj.LoadExcel({ Mode:"HeaderSkip",StartRow:"2",Append:true,ColumnMapping:mappingCol});
		 				if(rslt) {
		 					//change original data to delete state 						
		 					ComRowHideDelete(sheetObj, prefix1+"del_chk");	
		 				} else {
		 					sheetObj.CheckAll(prefix1+"del_chk",0);
		 				}
		 				sheetObj.SetHeaderCheck(0, 2,0);
		 			}	 					
 					sheetObj.RenderSheet(1);
 					break;
 				case "t2sheet1":
 					sheetObj.RemoveAll();	// reset
 					sheetObj.SetWaitImageVisible(0);
 					formObj.f_cmd.value=SEARCH07;
 					var sXml=sheetObj.GetSearchData("VOP_OPF_0020GS.do", FormQueryString(formObj));
 					sheetObj.SetWaitImageVisible(1);
 					var sCBFCount=ComGetEtcData(sXml, "sPCBFCount");
 					var mappingCol="|||1|2|3|4||5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36";
 					sheetObj.RenderSheet(0);
 					if (sCBFCount > 0) {
 						if (ComShowCodeConfirm("OPF50019")) {
 							sheetObj.CheckAll(prefix2+"del_chk",1);
 							var rslt = sheetObj.LoadExcel({ Mode:"HeaderSkip",StartRow:"2",Append:true,ColumnMapping:mappingCol});
 							if(rslt) {
 								//change original data to delete state
 								ComRowHideDelete(sheetObj, prefix2+"del_chk");
 							} else {
 								sheetObj.CheckAll(prefix2+"del_chk",0);
 							}
 							sheetObj.SetHeaderCheck(0, 2,0);
 							sheetObj.SetHeaderCheck(1, 2,0);
 						}
		 			} else {
		 				sheetObj.CheckAll(prefix2+"del_chk",1);
		 				var rslt = sheetObj.LoadExcel({ Mode:"HeaderSkip",StartRow:"2",Append:true,ColumnMapping:mappingCol});
		 				if(rslt) {
								//change original data to delete state
								ComRowHideDelete(sheetObj, prefix2+"del_chk");
							} else {
								sheetObj.CheckAll(prefix2+"del_chk",0);
							}
							sheetObj.SetHeaderCheck(0, 2,0);
							sheetObj.SetHeaderCheck(1, 2,0);
		 			}	 					
 					sheetObj.RenderSheet(1);
		 			break;
 			}
	 			break;
	 	}
	}
	/**
	 * Setting Tab 
	 * Set item of Tab
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0;
				InsertItem( "Volume/Weight", "");
				InsertItem( "Special Cargo", "");
			}
			break;
		}
		tabObj.SetSelectedIndex(0);
	}
	/**
	 * In case of clicking Tab event relation 
	 * activate element of Tab chosen
	 */
	function tab1_OnChange(tabObj, nItem) {
		formObject = document.form;
	   	var objs=document.all.item("tabLayer");
	   	objs[nItem].style.display="Inline";
	    for(var i = 0; i< objs.length; i++){
	       	  if(i != nItem){
		        	   objs[i].style.display="none";
		        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       	  }
	   	}
	    resizeSheet(); 
	   	beforetab=nItem;
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		//1.basic check - checking validation of form field such as maxlength, mandatory item
		switch (sAction) {
			case IBSEARCH:
				if (comboObjects[0].GetSelectCode()== "") {
					ComShowCodeMessage("COM130404", "POL", "POL");
					formObj.yd_cd.focus();
					return false;
				}
				//checking validation of all control in form object 
				if (!ComChkValid(formObj, true, false, false))
					return false;
				break;
			case IBROWSEARCH:	
				var sheetObj1=sheetObjects[0];				
				//check Volume Container Qty '0' quantity
				if (sheetObj1.RowCount()> 0) {
					for (var rowCt=sheetObj1.HeaderRows(); rowCt <= sheetObj1.LastRow(); rowCt++) {
						if(sheetObj1.GetRowStatus(rowCt) != 'D') {
							if ((parseInt(sheetObj1.GetCellValue(rowCt, prefix1+"cntr_qty"))) == 0) {
								ComShowCodeMessage("OPF50009", "Q'ty");	//'Please input {?msg1}.'
								tabObjects[0].SetSelectedIndex(0);
								sheetObj1.SelectCell(rowCt, prefix1+"cntr_qty");
								return false;
							}
						}
					}
				}
				break;
			case IBSAVE:
				var sheetObj1=sheetObjects[0];
				var sheetObj2=sheetObjects[1];
				//checking Volume duplication 
				for (var rowCt1=sheetObj1.HeaderRows(); rowCt1 < sheetObj1.LastRow(); rowCt1++) {
					if(sheetObj1.GetRowStatus(rowCt1) != 'D') {
						var prnrCntrRefNo1=sheetObj1.GetCellValue(rowCt1, prefix1+"prnr_cntr_ref_no");
						var cntrQty1=sheetObj1.GetCellValue(rowCt1, prefix1+"cntr_qty");
						for (var rowCt2=rowCt1 + 1; rowCt2 <= sheetObj1.LastRow(); rowCt2++) {
							if(sheetObj1.GetRowStatus(rowCt2) != 'D') {
								var prnrCntrRefNo2=sheetObj1.GetCellValue(rowCt2, prefix1+"prnr_cntr_ref_no");
								var cntrQty2=sheetObj1.GetCellValue(rowCt2, prefix1+"cntr_qty");
								if (prnrCntrRefNo1 != "" && prnrCntrRefNo2 != "" && cntrQty1 != "" && cntrQty2 != "" && (prnrCntrRefNo1 == prnrCntrRefNo2)  ) {
									ComShowCodeMessage("OPF50005", "CNTR No.");
									tabObjects[0].SetSelectedIndex(0);
									sheetObj1.SelectCell(rowCt2, prefix1+"prnr_cntr_ref_no", true);
									return false;
								}
							}
						}
					}
				}
				//checking Special Cargo type mandatory item 
				for (var rowCt=sheetObj2.HeaderRows(); rowCt < sheetObj2.LastRow(); rowCt++) {
					if(sheetObj2.GetRowStatus(rowCt) != 'D') {
						if ((sheetObj2.GetCellValue(rowCt, prefix2+"dcgo_flg") != "1")    && (sheetObj2.GetCellValue(rowCt, prefix2+"rc_flg") != "1") && (sheetObj2.GetCellValue(rowCt, prefix2+"awk_cgo_flg") != "1") && (sheetObj2.GetCellValue(rowCt, prefix2+"bb_cgo_flg") != "1") && (sheetObj2.GetCellValue(rowCt, prefix2+"stwg_cgo_flg") != "1"))
						{
							ComShowCodeMessage("OPF50009", "Special Cargo Type");	//'Please input {?msg1}.'
							tabObjects[0].SetSelectedIndex(1);
							sheetObj2.SelectCell(rowCt, prefix2+"dcgo_flg");
							return false;
						}
					}
				}
				for (var rowCt1=sheetObj2.HeaderRows(); rowCt1 < sheetObj2.LastRow(); rowCt1++) {
					if(sheetObj2.GetRowStatus(rowCt1) != 'D') {
						var prnrBkgRefNo1=sheetObj2.GetCellValue(rowCt1, prefix2+"prnr_bkg_ref_no");
						var prnrCntrRefNo1=sheetObj2.GetCellValue(rowCt1, prefix2+"prnr_cntr_ref_no");
						var cntrSeq1=sheetObj2.GetCellValue(rowCt1, prefix2+"cntr_seq");
						var cgoSeq1=sheetObj2.GetCellValue(rowCt1, prefix2+"cgo_seq");
						var mlbCd1=sheetObj2.GetCellValue(rowCt1, prefix2+"mlb_cd");
						var uniqA=prnrBkgRefNo1 + prnrCntrRefNo1 + cntrSeq1 + cgoSeq1 + mlbCd1;
						for (var rowCt2=rowCt1 + 1; rowCt2 <= sheetObj2.LastRow(); rowCt2++) {
							if(sheetObj2.GetRowStatus(rowCt2) != 'D') {
								var prnrBkgRefNo2=sheetObj2.GetCellValue(rowCt2, prefix2+"prnr_bkg_ref_no");
								var prnrCntrRefNo2=sheetObj2.GetCellValue(rowCt2, prefix2+"prnr_cntr_ref_no");
								var cntrSeq2=sheetObj2.GetCellValue(rowCt2, prefix2+"cntr_seq");
								var cgoSeq2=sheetObj2.GetCellValue(rowCt2, prefix2+"cgo_seq");
								var mlbCd2=sheetObj2.GetCellValue(rowCt2, prefix2+"mlb_cd");
								var uniqB=prnrBkgRefNo2 + prnrCntrRefNo2 + cntrSeq2 + cgoSeq2 + mlbCd2;
								if (uniqA == uniqB) {
									ComShowCodeMessage("OPF50005", "BKG Ref. No. + CNTR No. + CNTR SEQ + CGO SEQ + MLB");
									tabObjects[0].SetSelectedIndex(1);
									sheetObj2.SelectCell(rowCt2, prefix2+"prnr_bkg_ref_no", true);
									return false;
								}
							}
						}
					}
				}
				//checking Stwage mandatory item
				for (var rowCt=sheetObj2.HeaderRows(); rowCt < sheetObj2.LastRow(); rowCt++) {
					if(sheetObj2.GetRowStatus(rowCt) != 'D') {
						if ((sheetObj2.GetCellValue(rowCt, prefix2+"stwg_cgo_flg") == "1") && (sheetObj2.GetCellValue(rowCt, prefix2+"stwg_cd") == "")) {
							ComShowCodeMessage("OPF50009", "STWG");
							tabObjects[0].SetSelectedIndex(1);
							sheetObj2.SelectCell(rowCt, prefix2+"stwg_cd");
							return false;
						}
					}
				}
				break;
		}
		return true;
	}
	/**
	 * handling Sheet1 OnKeyUp Event 
	 * param : sheetObj,  Row, Col
	 * 
	 */
	function t2sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
		with (sheetObj) {
			var len=GetEditText().length;
			if (ColSaveName(Col) == prefix2+"imdg_un_no") {
				if (len == 4 && KeyCode != 229 && KeyCode != 67 && KeyCode != 17) {
					sheetObj.SelectCell(Row, prefix2+"imdg_mrn_polut_cd");
				}
			}
		}
	}
	/**
	 * UN No. Validation
	 */
	function checkUNNo(sheetObj, Row, Col) {
		var formObj=document.form;
		var imdgUnNo=sheetObj.GetCellValue(Row, prefix2+"imdg_un_no");
		sheetObjects[1].SetWaitImageVisible(0);
		formObj.f_cmd.value=SEARCH01;	
		var sXml=sheetObjects[1].GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj) + "&imdg_un_no=" + imdgUnNo);
		sheetObjects[1].SetWaitImageVisible(1);
		var sTotal=ComOpfGetTotalValue(sXml);
		// initializing Sheet Row
		sheetObj.SetCellValue(Row, prefix2+"imdg_un_no","",0);
		sheetObj.SetCellValue(Row, prefix2+"imdg_clss_cd","",0);
		sheetObj.SetCellValue(Row, prefix2+"prp_shp_nm","",0);
		sheetObj.SetCellValue(Row, prefix2+"imdg_subs_rsk_lbl_cd","",0);
		sheetObj.SetCellValue(Row, prefix2+"pck_grp_cd","",0);
		if (sTotal == "0") {
			ComShowCodeMessage("OPF50004",'Data');	//'{?msg1} is invalid.'
			sheetObj.SelectCell(Row, Col);
		} else {
			ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdgUnNo, 940, 397, "setCallBackUNNo", "0,0,1,1,1,1,1,1,1,1", true, false, Row, Col, 0);
		}
	}
	/**
	 * handling Sheet2 Popup Click Event 
	 *param : sheetObj, Row, Col
	 * 
	 */
	function t2sheet1_OnPopupClick(sheetObj, Row, Col) {
		with (sheetObj) {
			var formObj=document.form;
			var imdgUnNo=sheetObj.GetCellValue(Row, prefix2+"imdg_un_no");
			ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdgUnNo, 940, 397, "setCallBackUNNo", "0,0,1,1,1,1,1,1,1,1", true, false, Row, Col, 0);
		}
	}
	/**
	 * callback method about Sheet1 OnPopupClick ImdgUnNoSeq event handling 
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param seetIdx 
	 * @return
	 */
	function setCallBackUNNo(aryPopupData, row, col, seetIdx) {		
		var sheetObj=sheetObjects[1];
		sheetObj.SetCellValue(row, prefix2+"imdg_un_no",aryPopupData[0][2],0);
		sheetObj.SetCellValue(row, prefix2+"imdg_clss_cd",aryPopupData[0][4],0);
		sheetObj.SetCellValue(row, prefix2+"imdg_subs_rsk_lbl_cd",aryPopupData[0][8],0);
		sheetObj.SetCellValue(row, prefix2+"pck_grp_cd",aryPopupData[0][9],0);
	}
	
	function setCrrCd(obj) {
		var formObj=document.form;
		var rtnDatas=obj[0];

		if (rtnDatas[3] == ConstantMgr.getCompanyCode()) {
			ComShowCodeMessage("OPF50029", "");
			formObj.crr_cd.value = "";
			return false;
		}
		formObj.crr_cd.value = rtnDatas[3];
	}	
	
	
	
	