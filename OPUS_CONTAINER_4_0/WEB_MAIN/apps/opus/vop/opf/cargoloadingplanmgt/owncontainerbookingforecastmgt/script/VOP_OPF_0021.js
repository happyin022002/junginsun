/*
=========================================================
Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0021.js
*@FileTitle  : Own Container Booking Forecast Management 
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
/*------------------For JSDoc ------------------*/
/**
 * @extends
 * @class VOP_OPF_0021 : VOP_OPF_0021 business script for
 */
	/* Developer performance	*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var headerList=new Array();
	var stwgNmList;
	var comboObjects=new Array();
	var comboCnt=0;
	var IBSEARCH02=30;
	var IBSEARCH03=33;
	
//	var sheetObj1=sheetObjects[0]; // t1sheet1
//	var sheetObj2=sheetObjects[1]; // t2sheet1
//	var sheetObj3=sheetObjects[2]; // t2sheet2
//	var sheetObj4=sheetObjects[3]; // t2sheet3
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick; 
	// Event handler processing by button name */
	function processButtonClick() {
		
		var tabObj=tabObjects[0];
		var formObj=document.form;
		var selTabIdx=tabObj.GetSelectedIndex();
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {	
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH02);
					doActionIBSheet(sheetObjects[3], formObj, IBSEARCH02);
					doActionIBSheet(sheetObjects[2], formObj, IBSEARCH03);
					break;
				case "btn_BookingClosingStatus":
					openBCSPopup(formObj);
					break;
				case "btn_WeightGroup":
					openBGPopup(formObj);
					break;
				case "btn_DownExcel1":
					if(sheetObjects[0].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1, DownRows:"Visible" });
	        	    }
					break;
				case "btn_DownExcel2":
					if(sheetObjects[1].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1, DownRows:"Visible" });
	        	    }
					break;
				case "btn_DownExcel3":
					if(sheetObjects[2].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1, DownRows:"Visible" });
	        	    }
					break;
				case "btn_DownExcel4":
					if(sheetObjects[3].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObjects[3].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[3]), SheetDesign:1,Merge:1, DownRows:"Visible" });
	        	    }
					break;
				case "btn_New":
					ComResetAll();
					resetForCondition(formObj, "vvd");
					ComSetFocus(formObj.vsl_cd);
					break;
				case "btn_Print":
					var wh = 550;
					var ht = 490;
					ComOpenPopup("/opuscntr/VOP_OPF_1021.do?" + FormQueryString(formObj), wh, ht, "setCallBackPort", "0,0,1,1,1,1,1", true);
					break;
				case "btn_vvd":
					var vslCd=ComGetObjValue(formObj.vsl_cd);
					var sUrl="";
					if (vslCd == "") {
						sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 520, 500, "setCallBackVSL", "0,0", true);
					} else {
						sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslCd;
						ComOpenPopup(sUrl, 370, 425, "setCallBackVVD", "0,0", true);
					}
					break;
			} // end switch
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
		}
	}
	/** 
	 * Calling Pop-Up in case of clicking Weight Group (Creation) button
	 */
	function openBGPopup(formObj) {	
		var vSlanCd=ComGetObjValue(formObj.slan_cd);
		var vSkdDirCd=ComGetObjValue(formObj.skd_dir_cd);
		var vYdCd= formObj.yd_cd_text.value
		var vPolCd=vYdCd.substr(0, 5);
		sUrl="/opuscntr/VOP_OPF_2021_POP.do?slan_cd=" + vSlanCd + "&skd_dir_cd=" + vSkdDirCd + "&pol_cd=" + vPolCd;
		var wt = 800;
		var ht = 500;
		ComOpenPopup(sUrl, wt, ht, "yd_cd:yd_cd", "0,0", true);
	}
	/** 
	 * Calling Pop-Up in case of clicking Booking Closing Status button
	 */
	function openBCSPopup(formObj) {	
		var vslCd=ComGetObjValue(formObj.vsl_cd);
		var skdVoyNo=ComGetObjValue(formObj.skd_voy_no);
		var skdDirCd=ComGetObjValue(formObj.skd_dir_cd);
		var ydCd= formObj.yd_cd_text.value
		var polCd=ydCd.substring(0, 5);
		var paramStr="";
		paramStr += 'vsl_cd=' + vslCd + skdVoyNo + skdDirCd + '&pol_cd=' + polCd;
		ComOpenWindowCenter("/opuscntr/ESM_BKG_0587POP.do?pgmNo=ESM_BKG_0587&" + paramStr, "VOP_OPF_0019", 1025, 675, true);
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
	 * registering IBSheet Object as list
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
		//initializing IBMultiCombo
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
			initSheet(sheetObjects[i], i + 1, new Array('OWN','OTH'));
			ComEndConfigSheet(sheetObjects[i]);
		}
		//button deactivated
		ComBtnDisable("btn_Retrieve");
		ComBtnDisable("btn_Print");
		ComBtnDisable("btn_BookingClosingStatus");
		ComBtnDisable("btn_DownExcel1");
		ComBtnDisable("btn_DownExcel2");
		ComBtnDisable("btn_DownExcel3");
	    ComBtnDisable("btn_DownExcel4");
		//register Axon Event Listener 
		initControl();
		//initial focus state
		ComSetFocus(document.form.vsl_cd);
	}
	/**
	 * initializing IBCOMBO <br>
	 **/
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
			case "yd_cd":
				var i=0;
				with (comboObj) {
					SetDropHeight(230);
				}
				break;
			case "crr_cd":
				with (comboObj) {
					SetDropHeight(230);
					SetEnable(0);
					InsertItem(0, 'ALL', ' ');
					Text2="ALL";
				}
				break;
			case "pod_cd":
				with (comboObj) {
					SetDropHeight(230);
					SetEnable(0);
					InsertItem(0, 'ALL', ' ');
					Text2="ALL";
				}
				break;
			case "mlb_cd":
				with (comboObj) {
					Width=50;
					SetDropHeight(230);
					SetEnable(0);
					InsertItem(0, 'ALL', ' ');
					Text2="ALL";
				}
				break;	
		}
	}
	/**
	 * Loading event of HTML Control in page dynamically <br>
	 * initializing IBSheet by calling {@link #loadPage}Method <br>
	 **/
	function initControl() {
		// axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		// axon_event.addListenerForm  ("keyup",    'obj_keyup',    form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);
		axon_event.addListenerForm  ('click',    'obj_click',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		// axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
	}
	/**
	 * handling next focus OnKeyUp event automatically after required input  <br>
	 **/
//	function obj_keyup() {
//		if(event.keyCode != 9) obj_nextfocus(event.srcElement);
//	}
	function obj_nextfocus(obj) {
		var formObj=document.form;
		var objMaxLength=obj.getAttribute("maxlength");
		var objValue=obj.getAttribute("value");
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else ComSetNextFocus(obj);
			if (obj.name == 'vsl_cd') {
				ComSetObjValue(formObj.skd_voy_no, "");
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if (obj.name == 'skd_voy_no') {
				ComSetObjValue(formObj.skd_dir_cd, "");
			}
		}
	}
	/**
	 * handling work java script OnFocusOut event <br>
	 **/
	function obj_blur() {
		var formObj=document.form;
		with (event.srcElement) {	
			switch (name) {	
				case "skd_dir_cd":	
					if (value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {						
						//get VVD Info 
						searchVVDInfo();
					}		
					break;
				default:
					break;
			}
		}
	}
	/**
	 * retrieve VVD Info <br>
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
			//change focus 
			ComSetFocus(formObj.vsl_cd);
		} else {
			ComSetObjValue(formObj.vsl_eng_nm,  vvdData[0][0]);
			ComSetObjValue(formObj.slan_cd,     vvdData[0][1]);
			ComSetObjValue(formObj.slan_nm,     vvdData[0][2]);
			//get POL
			formObj.f_cmd.value=SEARCH01;
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
			ComSetFocus(formObj.yd_cd);
		}
		sheetObj.SetWaitImageVisible(1);
	}
	/**
	 * in case of changing VVD/POL initializing related item <br>
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
			ComSetObjValue(formObj.cbf_ind_flg,    "");
			ComSetObjValue(formObj.cbf_bkg_sts_cd, "");
			ComSetObjValue(formObj.upd_usr_id, "");
			ComSetObjValue(formObj.upd_dt,     "");	
			for (var comboCt=1; comboCt<comboObjects.length; comboCt++) {	
				comboObjects[comboCt].RemoveAll();
				comboObjects[comboCt].InsertItem(0, 'ALL', ' ');
				comboObjects[comboCt].SetSelectText("ALL",false);
				comboObjects[comboCt].SetEnable(0);
			}
		}
		for (var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {	
			sheetObjects[sheetCt].RemoveAll();
		}
		ComBtnDisable("btn_Retrieve");
		ComBtnDisable("btn_Print");
		ComBtnDisable("btn_BookingClosingStatus");
		ComBtnDisable("btn_DownExcel1");
		ComBtnDisable("btn_DownExcel2");
		ComBtnDisable("btn_DownExcel3");
		ComBtnDisable("btn_DownExcel4");
	}
	/**
	 * In case of selecting POL combo data <br>
	 **/
	
	function yd_cd_OnChange(obj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
		var formObj=document.form;
		
//		var sheetObj1=sheetObjects[0];
//		var sheetObj2=sheetObjects[1];
//		var sheetObj3=sheetObjects[2];
		//initializing related item
		resetForCondition(formObj, "vvd-pol");
		if(obj.GetSelectCode() != '') {		
			//get POL Info 
			formObj.f_cmd.value=SEARCH02;
			sheetObjects[0].SetWaitImageVisible(0);
 			var formParams="";
     		formParams += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
     		formParams += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
     		formParams += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
     		formParams += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd); 
     		formParams += "&yd_cd="      +comboObjects[0].GetSelectCode();
     		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0019GS.do", formParams);
     		sheetObjects[0].SetWaitImageVisible(1);
			var sPol=ComGetEtcData(sXml, "sPol");
			if (sPol != undefined) {
				var arrPol=sPol.split("|");
				ComSetObjValue(formObj.loc_nm, arrPol[0]);
				ComSetObjValue(formObj.yd_nm,  arrPol[1]);
				ComSetObjValue(formObj.eta,    arrPol[2]);
				sheetObjects[0].SetWaitImageVisible(0);
				//1. retrieve CBF, Booking Status state 
				formObj.f_cmd.value=SEARCH07;
				//evincive Creation parameter
	 			var formParams2="";
	     		formParams2 += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
	     		formParams2 += "&vsl_cd="     +ComGetObjValue(formObj.vsl_cd);
	     		formParams2 += "&skd_voy_no=" +ComGetObjValue(formObj.skd_voy_no);
	     		formParams2 += "&skd_dir_cd=" +ComGetObjValue(formObj.skd_dir_cd); 
	     		formParams2 += "&yd_cd="      +comboObjects[0].GetSelectCode();
	     		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0019GS.do", formParams2);
				var sCbf=ComGetEtcData(sXml, "sCbf");
				if (sCbf != undefined) {
					var arrCbf=sCbf.split("|");
					if ((arrCbf[0] != null) && (arrCbf[0] != '')) {
						ComSetObjValue(formObj.cbf_ind_flg, arrCbf[0]=='null'?"":arrCbf[0]);
					} else {
						ComSetObjValue(formObj.cbf_ind_flg, "");
					}
					if ((arrCbf[1] != null) && (arrCbf[1] != '')) {
						ComSetObjValue(formObj.cbf_bkg_sts_cd, arrCbf[1]=='null'?"":arrCbf[1]);
					} else {
						ComSetObjValue(formObj.cbf_bkg_sts_cd, "");
					}
					if ((arrCbf[2] != null) && (arrCbf[2] != '')) {
						ComSetObjValue(formObj.upd_usr_id, arrCbf[2]=='null'?"":arrCbf[2]);
					} else {
						ComSetObjValue(formObj.upd_usr_id, "");
					}
					if ((arrCbf[3] != null) && (arrCbf[3] != '')) {
						ComSetObjValue(formObj.upd_dt, arrCbf[3]=='null'?"":arrCbf[3]);
					} else {
						ComSetObjValue(formObj.upd_dt, "");
					}
				}
				//2. creating OPR, POD, MLB combo
				formObj.f_cmd.value=SEARCH11;
				var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0021GS.do", FormQueryString(formObj));
				var sOpr=ComGetEtcData(sXml, "sOpr");	
				var isOpr=false;
				var isCt=0;
				if (sOpr != undefined) {
					var arrOpr=sOpr.split("|");
					for (var i=0; i < arrOpr.length; i++) {
						if(ComTrim(arrOpr[i]) != '') {
							comboObjects[1].InsertItem(i+1, arrOpr[i], arrOpr[i]);
							isCt++;
						}
					}

					if(isCt>0) {
						comboObjects[1].SetEnable(1);
						//3. construct dynamic header
						
						sheetObjects[0] = sheetObjects[0].Reset();
						ComConfigSheet(sheetObjects[0]);						
						initSheet(sheetObjects[0], 1, arrOpr);						
						ComEndConfigSheet(sheetObjects[0]);
						sheetObjects[1] = sheetObjects[1].Reset();
						ComConfigSheet(sheetObjects[1]);						
						initSheet(sheetObjects[1], 2, arrOpr);						
						ComEndConfigSheet(sheetObjects[1]);
						sheetObjects[2] = sheetObjects[2].Reset();
						ComConfigSheet(sheetObjects[2]);						
						initSheet(sheetObjects[2], 3, arrOpr);						
						ComEndConfigSheet(sheetObjects[2]);
						isOpr=true;
						
					}
				}
				var sPod=ComGetEtcData(sXml, "sPod");	
				if (sPod != undefined) {
					var arrPod=sPod.split("|");	
					var podCd=""; //yd_code + clpt_ind_seq
					for (var i=0; i < arrPod.length; i++) {
						podCd=arrPod[i];
						if(podCd != '') podCd=podCd.substring(0, podCd.length-1); 
						comboObjects[2].InsertItem(i+1, podCd, arrPod[i]);
					}
					if(arrPod.length>0) comboObjects[2].SetEnable(1);
				}
				var sMlb=ComGetEtcData(sXml, "sMlb");	
				isCt=0;
				if (sMlb != undefined) {
					var arrMlb=sMlb.split("|");					
					for (var i=0; i < arrMlb.length; i++) {
						if(ComTrim(arrMlb[i]) != '') {
							comboObjects[3].InsertItem(i+1, arrMlb[i], arrMlb[i]);
							isCt++;
						}
					}
					if(isCt>0) comboObjects[3].SetEnable(1);
				}
				sheetObjects[0].SetWaitImageVisible(1);
				if(isOpr) {
					//ComBtnEnable("btn_Retrieve");
					ComBtnEnable("btn_Print");
				}
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_BookingClosingStatus");
			}
		}
	}
	/**
	 * in case of selecting OPR combo data. <br>
	 **/
//	function crr_cd_OnChange(comboObj, Code, Text) {
	function crr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var sheetObj3=sheetObjects[2];
		
		var headerList=new Array();
		if(newCode != ' ') {
			headerList[0] = newText;		
		} else {
			for(var comboCt=1; comboCt<comboObj.GetItemCount(); comboCt++) {
				headerList[comboCt-1] = comboObj.GetText(comboCt, 0);
			}
		}
		
//		if(comboObj.GetSelectCode() != '') {
//			headerList[0]=comboObj.GetSelectText();
//		} else {
//			for(var comboCt=1; comboCt<comboObj.GetItemCount(); comboCt++) {
//				headerList[comboCt-1]=comboObj.GetText(comboCt, 0);
//				if(headerList[comboCt-1]=="ALL"){
//				}else{
		
					if(headerList.length > 0) {
						sheetObjects[0] = sheetObjects[0].Reset();
						ComConfigSheet(sheetObjects[0]);						
						initSheet(sheetObjects[0], 1, headerList);						
						ComEndConfigSheet(sheetObjects[0]);
						
						sheetObjects[1] = sheetObjects[1].Reset();
						ComConfigSheet(sheetObjects[1]);						
						initSheet(sheetObjects[1], 2, headerList);						
						ComEndConfigSheet(sheetObjects[1]);
						
						sheetObjects[2] = sheetObjects[2].Reset();
						ComConfigSheet(sheetObjects[2]);						
						initSheet(sheetObjects[2], 3, headerList);						
						ComEndConfigSheet(sheetObjects[2]);
					}
					
//				}
//			}
//		}
		
	}
	/**
	 * in case of inputting retrieve condition Validation <br>
	 **/
//	function obj_keypress() {
//		switch (event.srcElement.dataformat) {
//			case "engup":
//				switch (event.srcElement.name) {
//					case "vsl_cd":
//						//inputting capital
//						ComKeyOnlyAlphabet('uppernum');
//						break;
//					case "skd_voy_no":
//						//inputting number
//						ComKeyOnlyNumber(event.srcElement);
//						break;
//					case "skd_dir_cd":
//						//inputting capital
//						ComKeyOnlyAlphabet('upper');
//						break;
//					case "crr_cd":
//						//inputting capital
//						ComKeyOnlyAlphabet('upper');
//						break;
//					case "yd_cd":
//						//inputting capital
//						ComKeyOnlyAlphabet('upper');
//						break;
//				}
//				break;
//			default:
//				//common standard: recognization only number, english
//				ComKeyOnlyAlphabet("num");
//				break;
//		}
//	}
	/**
	 * in case of modifying VVD  data <br>
	 **/
	function obj_change() {
		var formObj=document.form;		
		with (event.srcElement) {
			switch (name) {
				case "vsl_cd": case "skd_voy_no":	
					if(name == 'vsl_cd') ComSetObjValue(formObj.skd_voy_no, "");
					ComSetObjValue(formObj.skd_dir_cd, "");
					//initializing related item					
					resetForCondition(formObj, "vvd");
					break;
			}
		}
	}
	/**
	 * setting data received from VSL Code Help (Pop-Up)<br>
	 */
	function setCallBackVSL(rtnObjs) {
		var formObj=document.form;
		if (rtnObjs) {
			var rtnDatas=rtnObjs[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
					// change focus 
					ComSetFocus(formObj.skd_voy_no);
				}
			}
		}
	}
	/**
	 * setting data received from VVD Code Help (Pop-Up)<br>
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
					//get VVD Info 
					searchVVDInfo();
				}
			}
		}
	}	
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * 　 adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo, cgoOprList) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var formObj=document.form;
		switch (sheetID) {	
			case "t1sheet1":
			    with(sheetObj){
				      var HeadTitle1="|  |  |  |  ";
				      var HeadTitle2="|POD >>|MLB  |Weight Group >>|Weight Group >>";
				      var cgoOprVal="";
				      for (var cgoOprCt=0; cgoOprCt<cgoOprList.length; cgoOprCt++) {
				      cgoOprVal=cgoOprList[cgoOprCt];
				      HeadTitle1=HeadTitle1 + "|OPR|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal;
				      HeadTitle2=HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'|TEU";
				      }
				      HeadTitle1=HeadTitle1 + "|Total|Total|Total|Total|Total|Total|Total|Full Units Av.Weight (Ton)|Full Units Av.Weight (Ton)||";
				      HeadTitle2=HeadTitle2 + "|20'|20HC|40'|40HC|45'|TTL|TEU|20|40||";
				      //var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:1, Page:100, DataRowMerge:0} ); 
				      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ 
				             {Type:"Status",    Hidden:1, 	Width:0,  	Align:"Center",  ColMerge:0,   SaveName:"hdnStauts" },
				             {Type:"Text",      Hidden:0,  	Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pod",  KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, 	Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mlb",  KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  	Width:104,  Align:"Left",    ColMerge:0,   SaveName:"fm",   KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, 	Width:60,   Align:"Left",    ColMerge:0,   SaveName:"wg",   KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              for (var cgoOprCt=1; cgoOprCt<=cgoOprList.length; cgoOprCt++) {
					      cols.push({Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"opr"+cgoOprCt,        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr"+cgoOprCt+"_qty_2",	KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr"+cgoOprCt+"_qty_2h",	KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr"+cgoOprCt+"_qty_4",	KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr"+cgoOprCt+"_qty_4h",	KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"opr"+cgoOprCt+"_qty_45",	KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"opr"+cgoOprCt+"_teu", 	KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      }
				      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"tot_qty_2",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"tot_qty_2h",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"tot_qty_4",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"tot_qty_4h",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"tot_qty_45",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tot_ttl",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tot_teu",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Float",     Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"av_wgt_2",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Float",     Hidden:0,  Width:61,   Align:"Right",   ColMerge:0,   SaveName:"av_wgt_4",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id" });
				      cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt" });
				      InitColumns(cols);
				      SetEditable(0);
				      SetRangeBackColor(1,0,1,28,"#555555");
				      //SetSheetHeight(340);
				      resizeSheet();
		            }
				break;
			case "t2sheet1": // sheet2 init
			    with(sheetObj){
				      var HeadTitle0="|  |  ";
				      var HeadTitle1="|  |  ";
				      var HeadTitle2="|POD >>|MLB";
				      var cgoOprVal="";
				      for (var cgoOprCt=0; cgoOprCt<cgoOprList.length; cgoOprCt++) {
					      cgoOprVal=cgoOprList[cgoOprCt];
					      HeadTitle0=HeadTitle0 + "|OPR|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "";
					      HeadTitle0=HeadTitle0 + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "";
					      HeadTitle0=HeadTitle0 + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "|" + cgoOprVal + "";
					      HeadTitle0=HeadTitle0 + "|" + cgoOprVal + "|" + cgoOprVal + "";
					      
					      HeadTitle1=HeadTitle1 + "|OPR|DG|DG|DG|DG|DG";
					      HeadTitle1=HeadTitle1 + "|RF|RF|RF|RF|RF";
					      HeadTitle1=HeadTitle1 + "|AK|AK|AK|AK";
					      HeadTitle1=HeadTitle1 + "|BB|BB";
					      
					      HeadTitle2=HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'";
					      HeadTitle2=HeadTitle2 + "|20'|20HC|40'|40HC|45'";
					      HeadTitle2=HeadTitle2 + "|20'|40'|40HC|45'";
					      HeadTitle2=HeadTitle2 + "|20'|40'";
				      }
				      
//				      HeadTitle0=HeadTitle0 + "|OPR|Total|Total|Total|Total|Total";
//				      HeadTitle0=HeadTitle0 + "|Total|Total|Total|Total|Total";
//				      HeadTitle0=HeadTitle0 + "|Total|Total|Total|Total";
//				      HeadTitle0=HeadTitle0 + "|Total|Total";
				      HeadTitle0 = HeadTitle0 + "|OPR|Total|Total|Total|Total|Total";
						HeadTitle0 = HeadTitle0 + "|Total|Total|Total|Total|Total";
						HeadTitle0 = HeadTitle0 + "|Total|Total|Total|Total";
						HeadTitle0 = HeadTitle0 + "|Total|Total";
				      
				      HeadTitle1=HeadTitle1 + "|OPR|DG|DG|DG|DG|DG";
				      HeadTitle1=HeadTitle1 + "|RF|RF|RF|RF|RF";
				      HeadTitle1=HeadTitle1 + "|AK|AK|AK|AK";
				      HeadTitle1=HeadTitle1 + "|BB|BB";
				      
				      HeadTitle2=HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'";
				      HeadTitle2=HeadTitle2 + "|20'|20HC|40'|40HC|45'";
				      HeadTitle2=HeadTitle2 + "|20'|40'|40HC|45'";
				      HeadTitle2=HeadTitle2 + "|20'|40'";
				      
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 }; 
				      var headers = [ { Text:HeadTitle0, Align:"Center"},
					                  { Text:HeadTitle1, Align:"Center"},
					                  { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hdnStauts" },
					             {Type:"Text",      Hidden:0,  Width:64,   Align:"Left",    ColMerge:1,   SaveName:"pod",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mlb",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				      for (var cgoOprCt=1; cgoOprCt<=cgoOprList.length; cgoOprCt++) {
					      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"opr"+cgoOprCt,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_20_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_2h_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_40_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_4h_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_45_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_20_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_2h_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_40_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_4h_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_45_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_20_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_40_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_4h_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_45_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"bb_20_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"bb_40_opr"+cgoOprCt,       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      }
				      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"opr"+(cgoOprList.length+2),KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_20_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_2h_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_40_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_4h_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"dg_45_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_20_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_2h_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_40_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_4h_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"rf_45_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_20_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_40_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_4h_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"ak_45_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"bb_20_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"bb_40_tot",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				      InitColumns(cols);
				      SetEditable(0);
				      SetImageList(0,"img/btng_minus.gif");
				      SetImageList(1,"img/btng_plus.gif");
				      SetMergeCell(0, 1, 2, 2);
				      SetRangeBackColor(1,1,1,52,"#555555");
				      SetRangeBackColor(2,1,2,55,"#555555");
				      SetSheetHeight(362);
					}
				break;		
			case "t2sheet2":
			    with(sheetObj){
				      formObj.f_cmd.value=SEARCH16;
				      var headerXml="";
				      var stwgStr="";
				      if(ComGetObjValue(formObj.vsl_cd) != '') {
				    	  headerXml=sheetObj.GetSearchData("VOP_OPF_2019GS.do", FormQueryString(formObj));
				    	  stwgStr=ComGetEtcData(headerXml, "stwgCdList");
				      }
				      var stwgList=stwgStr.split("|");
				      var headTitles=new Array();	//header 1,2,3 level
				      var stParams=new Array();	//Stowage parameter list
				      var stFields=new Array();	//Stowage list by OPR
				      var stFiledCt=0;
				      var stDup=false;
				      var stCt=0;
				      var stwgNmCt=0;
				      stwgNmList = new Array();
				      headTitles[0]="|  |  ";
				      if(ComTrim(stwgStr) != "") {
				    	  headTitles[1]="|  |  ";
				    	  headTitles[2]="|POD >>|MLB";
				    	  var colCt=0;
				    	  for (var cgoOprCt=0; cgoOprCt<cgoOprList.length; cgoOprCt++) {
						      cgoOprVal=cgoOprList[cgoOprCt];
						      headTitles[0] += "|OPR";
						      headTitles[1] += "|OPR";
						      headTitles[2] += "|OPR";
						      stFields[cgoOprCt]=new Array();
						      stFiledCt=0;
						      for (; colCt < stwgList.length;) {
						    	  var stwgCd=stwgList[colCt].split("+")[1];
						    	  stwgNmList[stwgNmCt++]=stwgList[colCt].split("+")[1]+"+"+stwgList[colCt].split("+")[2];
						    	  if(cgoOprVal == stwgList[colCt].split("+")[0]) {
						    		  headTitles[0] += "|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"";
						    		  headTitles[1] += "|" + stwgCd + "|" + stwgCd + "|" + stwgCd + "|" + stwgCd + "|" + stwgCd;
						    		  headTitles[2] += "|20'|20HC|40'|40HC|45'";
						    		  stDup=false;
						    		  for(var stCts=0; stCts<stParams.length; stCts++) {
						    			  if(stwgCd == stParams[stCts]) stDup=true;
						    		  }
						    		  if(!stDup) stParams[stCt++]=stwgCd;
						    		  stFields[cgoOprCt][stFiledCt++]=stwgCd;
						    	  } else {
						    		  break;
						    	  }
						    	  colCt++;
						      }
				    	  }
				    	  var headers = [ { Text:headTitles[0], Align:"Center"},{ Text:headTitles[1], Align:"Center"},{ Text:headTitles[2], Align:"Center"} ];	
				      	} else {
				      		headTitles[1]="|POD >>|MLB";
				      		for (var cgoOprCt=0; cgoOprCt<cgoOprList.length; cgoOprCt++) {
				      			cgoOprVal=cgoOprList[cgoOprCt];
				      			headTitles[0] += "|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"|"+cgoOprVal+"";
				      			headTitles[1] += "|OPR|20'|20HC|40'|40HC|45'";
				      		}
				      		var headers = [ { Text:headTitles[0], Align:"Center"},{ Text:headTitles[1], Align:"Center"} ];	
				      	}
				      cgoOprCt=0;
				      for(stCt=0; stCt<15; stCt++) {
				    	  if(stCt<stParams.length) {
				    		  ComSetObjValue(eval("formObj.st_"+(stCt+1)), stParams[stCt]);
				    		  for(var cgoOprCt2=0; cgoOprCt2<stFields.length; cgoOprCt2++) {
				    			  for(stFiledCt=0; stFiledCt<stFields[cgoOprCt2].length; stFiledCt++) {
				    				  if(stParams[stCt] == stFields[cgoOprCt2][stFiledCt]) stFields[cgoOprCt2][stFiledCt]=stCt+1;
				    			  }
				    		  }
				    	  } else {
				    		  ComSetObjValue(eval("formObj.st_"+(stCt+1)), "");
				    	  }
				      	}
				      var headCount=ComCountHeadTitle(headTitles[0]);
				      for(var headCt=0; headCt<headTitles.length; headCt++) {
				    	  
				      }
				      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				      
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hdnStauts" },
					             {Type:"Text",      Hidden:0,  Width:64,   Align:"Left",    ColMerge:1,   SaveName:"pod",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mlb",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				      if(ComTrim(stwgStr) != "") {
				    	  for (var cgoOprCt=1; cgoOprCt<=cgoOprList.length; cgoOprCt++) {
				    		  cgoOprVal=cgoOprList[cgoOprCt-1];
				    		  cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"opr"+cgoOprCt,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				    		  for ( colCt=1; stFields[cgoOprCt-1] != null && colCt <= stFields[cgoOprCt-1].length; colCt++) {
				    			  var fieldIdx=stFields[cgoOprCt-1][colCt-1];
							      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+fieldIdx+"_20_opr"+cgoOprCt,KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
							      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+fieldIdx+"_2h_opr"+cgoOprCt,KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
							      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+fieldIdx+"_40_opr"+cgoOprCt,KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
							      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+fieldIdx+"_4h_opr"+cgoOprCt,KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
							      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st"+fieldIdx+"_45_opr"+cgoOprCt,KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
						      }
				    	  }
				      } else {
				    	  for (var cgoOprCt=1; cgoOprCt<=cgoOprList.length; cgoOprCt++) {
				    		  cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"opr"+cgoOprCt,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				    		  cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_20_opr"+cgoOprCt,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
						      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_2h_opr"+cgoOprCt,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
						      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_40_opr"+cgoOprCt,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
						      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_4h_opr"+cgoOprCt,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
						      cols.push({Type:"Int",       Hidden:0,  Width:49,   Align:"Right",   ColMerge:0,   SaveName:"st1_45_opr"+cgoOprCt,        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				    	  	}
				      }
				      
				      if(ComTrim(stwgStr) != "") {
				    	  SetMergeCell(0, 1, 2, 2);
				      }
				      InitColumns(cols);
				      SetEditable(0);
				      SetImageList(0,"img/btng_minus.gif");
				      SetImageList(1,"img/btng_plus.gif");
				      SetSheetHeight(342);
				      
		      }
			break;
			case "t2sheet3":
			    with(sheetObj){
			      var HeadTitle1="|No.|BKG No.|CNTR No.|POD|MLB|CGO\nOPR|TP|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Seq.|Seq.|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|PSN|TN|SRL|MP|PG|LQ|EQ|FP\n(°C)|Reefer\nTemp.(°C)|Commodity|OverAll(cm)|OverAll(cm)|OverAll(cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\n Extd.|STWG|APVL|APVL Ref. No.|Remark(s)|CBF DP CD||||||||||CBF IND FLG|Booking Status|RD ST|HIDDEN|SLAN CD|";
			      var HeadTitle2="|No.|BKG No.|CNTR No.|POD|MLB|CGO\nOPR|TP|DG|RF|AK|BB|ST|CNTR|CGO|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|PSN|TN|SRL|MP|PG|LQ|EQ|FP\n(°C)|Reefer\nTemp.(°C)|Commodity|L|W|H|FWD|AFT|Left|Right|Height|Post\n Extd.|STWG|APVL|APVL Ref. No.|Remark(s)||||||||||||||||";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"No." },
				             {Type:"Text",      Hidden:0,  Width:96,   Align:"Left",    ColMerge:1,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:86,   Align:"Left",    ColMerge:1,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mlb_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"stwg_cgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seq",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"cntr_grs_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"cgo_grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"prp_shp_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"hzd_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"imdg_mrn_polut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"pck_grp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"lmt_qty_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"expt_qty_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fdo_temp",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"cdo_temp",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cbf_cmdt_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"dim_len",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"dim_wdt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"dim_hgt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ovr_fwd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ovr_aft",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ovr_lft",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ovr_rgt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ovr_hgt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"crn_pst_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stwg_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"apro_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cbf_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cbf_dp_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_shpr_ownr_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cbf_smry_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cbf_ind_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cbf_bkg_sts_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rd_st" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hid" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hseq" } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetImageList(0,"img/opus/button/btns_multisearch.gif");
			      SetImageList(1,"img/opus/button/btng_minus.gif");
			      SetColHidden("hseq",1);
			      SetHighlightAfterSort(1);
			      SetHeaderRowHeight(20);
			      SetRangeBackColor(1,8,1,14,"#555555");
			      SetRangeBackColor(1,28,1,36,"#555555");
			      SetSheetHeight(260);
		      }
			break;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}

	
	/**
	 * Handling after retrieving t1sheet1 
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {		
		with (sheetObj) {
			if (RowCount()> 0) {
				var grandRow=FindText("fm", "Grand Total");
				for (var colCt=SaveNameCol("opr1_qty_2"); grandRow!=-1 && colCt<SaveNameCol("tot_qty_2"); colCt++) {
				}
				//change color of Sub Total line
				var subRow=FindText("fm", "Sub Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow();) {
					SetRowBackColor(checkRow++,"#F7E1EC");
					SetRowBackColor(checkRow,"#F7E1EC");
					subRow=FindText("fm", "Sub Total", checkRow);
					if(subRow != -1) {
						checkRow=subRow;
					} else {
						checkRow=LastRow()+1;
					}
				}				
				//change color Grand line
				SetRowBackColor(grandRow,"#F7E1EC");
				SetRowBackColor(++grandRow,"#F7E1EC");
				//hide MLB, WG column
				SetColHidden("mlb",1);
				SetColHidden("wg",1);
				//setting  POD unfolded direction indicator
				SetCellValue(1,"pod",GetCellValue(1,"pod").replaceStr("<", ">"),0);
				SetCellValue(1,"fm",GetCellValue(1,"fm").replaceStr("<", ">"),0);
				SetCellValue(1,"wg",GetCellValue(1,"wg").replaceStr("<", ">"),0);
				//construct basic folded form 
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if (GetCellValue(checkRow, "fm") == "Full Total" || GetCellValue(checkRow, "fm") == "Empty Total" || GetCellValue(checkRow, "fm") == "Sub Total"  || GetCellValue(checkRow, "fm") == "Sub Weight"  || (GetCellValue(checkRow, "pod") == "Grand Total" && GetCellValue(checkRow, "fm") == "Full"  && GetCellValue(checkRow, "wg") == "Total") || (GetCellValue(checkRow, "pod") == "Grand Total" && GetCellValue(checkRow, "fm") == "Empty" && GetCellValue(checkRow, "wg") == "Total") || GetCellValue(checkRow, "fm") == "Grand Total"  || GetCellValue(checkRow, "fm") == "Grand Weight") {
						
					} else {
						SetRowHidden(checkRow,1);
					}	
				}
				ComBtnEnable("btn_DownExcel1");
			} else {
				ComBtnDisable("btn_DownExcel1");
			}
			sheetObj.RenderSheet(1);
		}
	}
	/**
	 * handling after retrieving t2sheet1 
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 with (sheetObj) {
			if (RowCount()> 0) {
				//hide column which is 'G.Total is 0'
				var gRow=FindText("pod", "G.Total");
				for (var colCt=SaveNameCol("dg_20_opr1"); gRow!=-1 && colCt<=SaveNameCol("bb_40_opr1"); colCt++) {
				}
				//folded state
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if(SetCellValue(checkRow, "pod") != "G.Total" && GetCellValue(checkRow, "mlb") != "S.Total") GetRowHidden(checkRow,"pod");
				}
				//hide MLB column
				SetColHidden("mlb",1);
				//setting  POD unfolded direction indicator
				SetCellValue(2, "pod",GetCellValue(2, "pod").replaceStr("<", ">"),0);
				//change color G.Total line
				SetRowBackColor(gRow,"#F7E1EC");
				//activating excel down button
				ComBtnEnable("btn_DownExcel2");
			} else {
				ComBtnDisable("btn_DownExcel2");
			}
		}
	}
	/**
	 * handling after retrieving t2sheet2 
	 */
	function t2sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		 with (sheetObj) {
			if (RowCount()> 0) {
				//hide column which is 'G.Total is 0'
				var gRow=FindText("pod", "G.Total");
				for (var colCt=SaveNameCol("st1_20_opr1"); gRow!=-1 && colCt<=LastCol(); colCt++) {
				}
				//folded state
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if(SetCellValue(checkRow, "pod") != "G.Total" && GetCellValue(checkRow, "mlb") != "S.Total") GetRowHidden(checkRow,"pod");
				}
				//hide MLB column
				SetColHidden("mlb",1);
				//Setting POD unfolded direction indicator
				SetCellValue(HeaderRows()-1, "pod",GetCellValue(HeaderRows()-1, "pod").replaceStr("<", ">"),0);
				//change color G.Total line
				SetRowBackColor(gRow,"#F7E1EC");
				//activating excel down button
				ComBtnEnable("btn_DownExcel3");	
				var rowC =sheetObj.RowCount();
				for(var i=2 ; rowC+2 > i;i++){
					 if( (i % 2) == 1){
						sheetObj.SetRowHidden(i, 1);
					 }
				}
				
//				sheetObj.SetRowHidden("1|3|5|", 1);
				
			} else {
				ComBtnDisable("btn_DownExcel3");
			}
		}
	}
 /**
	 * handling after retrieving t2sheet3 
	 */
	function t2sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		 with (sheetObj) {
			if (RowCount()> 0) {
				//activating excel down button
				ComBtnEnable("btn_DownExcel4");
			} else {
				ComBtnDisable("btn_DownExcel4");
			}
		}
	}
	// handing work javascript OnClick event
	function obj_click() {
		var formObj=document.form;
		switch (event.srcElement.name) {
			case "dcgo_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked=false;
				}
				break;
			case "rc_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked=false;
				}
				break;
			case "awk_cgo_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked=false;
				}
				break;
			case "bb_cgo_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked=false;
				}
				break;
			case "stwg_cgo_flg":
				if (formObj.all_flg.checked) {
					formObj.all_flg.checked=false;
				}
				break;
			case "all_flg":
				if (formObj.all_flg.checked) {
					formObj.dcgo_flg.checked=false;
					formObj.rc_flg.checked=false;
					formObj.awk_cgo_flg.checked=false;
					formObj.bb_cgo_flg.checked=false;
					formObj.stwg_cgo_flg.checked=false;
				}
				break;
		}
	}
	// handling process related Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg(false);
		var comboObj=comboObjects[1];
		switch (sAction) {
			case IBSEARCH: //Volume Summary
				if (!validateForm(sheetObj, formObj, sAction)) return;						
				//1. construct OPR parameter
				var paramQty="";	
				var qtyVal="";
				for(var qtyCt=1; qtyCt<=5; qtyCt++) {
					if(qtyCt < comboObj.GetItemCount()) {
						if(comboObj.GetSelectText()== 'ALL'){
							qtyVal = comboObj.GetText(qtyCt,0);
						}else if(qtyCt == 1) {
							qtyVal=comboObj.GetSelectText();
						}else {
							qtyVal="";
						}
					} else {
						qtyVal="";
					}
					paramQty=paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
				}
				//2. Retrieve Volume Summary 
//				sheetObj.RenderSheet(0);
				formObj.f_cmd.value=SEARCH;						
//				var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0021GS.do", FormQueryString(formObj) + paramQty);
//		 		if (sXml != "") sheetObjects[0].LoadSearchData(sXml,{Sync:1});
				sheetObj.DoSearch("VOP_OPF_0021GS.do", FormQueryString(formObj) + paramQty);
//				if(ComGetTotalRows(sXml) > 0){
//					sheetObjects[0].LoadSearchData(sXml,{Sync:1});
//				}
				
				break;
				
			case IBSEARCH02: //Special Cargo Summary
				switch (sheetObj.id) {
					case "t2sheet1":
						if (!validateForm(sheetObj, formObj, sAction)) return;
						//1. construct OPR parameter
						var paramQty="";	
						var qtyVal="";
						for(var qtyCt=1; qtyCt<=5; qtyCt++) {
							if(qtyCt < comboObj.GetItemCount()) {
								if(comboObj.GetSelectText()== 'ALL'){
									qtyVal = comboObj.GetText(qtyCt,0);
								}else if(qtyCt == 1) {
									qtyVal=comboObj.GetSelectText();
								}else {
									qtyVal="";
								}
							} else {
								qtyVal="";
							}
							paramQty=paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
						}						
						/*for(var qtyCt=1; qtyCt<=5; qtyCt++) {
							if(qtyCt < comboObj.GetItemCount()) {
								if(comboObj.SetSelectText== 'ALL') qtyVal(comboObj.GetText(qtyCt, 0));
								else if(qtyCt == 1) qtyVal=comboObj.GetSelectText();
								else qtyVal="";
							} else {
								qtyVal="";
							}
							paramQty=paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
						}*/
						//sheetObj.RenderSheet(0);
						formObj.f_cmd.value=SEARCH02; 
						sheetObj.DoSearch("VOP_OPF_0021GS.do", FormQueryString(formObj) + paramQty );
						break;
						
					case "t2sheet3":
						if (!validateForm(sheetObj, formObj, sAction)) return;
						var paramQty="";	
						var qtyVal="";
//						for(var qtyCt=1; qtyCt<=5; qtyCt++) {
//							if(qtyCt < comboObj.GetItemCount()) {
//								if(comboObj.SetSelectText== 'ALL') qtyVal(comboObj.GetText(qtyCt, 0));
//								else if(qtyCt == 1) qtyVal=comboObj.GetSelectText();
//								else qtyVal="";
//							} else {
//								qtyVal="";
//							}
//							paramQty=paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
//						}
						for(var qtyCt=1; qtyCt<=5; qtyCt++) {
							if(qtyCt < comboObj.GetItemCount()) {
								if(comboObj.GetSelectText()== 'ALL'){
									qtyVal = comboObj.GetText(qtyCt,0);
								}else if(qtyCt == 1) {
									qtyVal=comboObj.GetSelectText();
								}else {
									qtyVal="";
								}
							} else {
								qtyVal="";
							}
							paramQty=paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
						}	
						formObj.f_cmd.value=SEARCH11;
						//evincive Creation parameter
			 			var formParams="";
			     		formParams += "f_cmd="        +ComGetObjValue(formObj.f_cmd);
			     		formParams += "&pagerows="    +ComGetObjValue(formObj.pagerows);
			     		formParams += "&all_flg="     +ComGetObjValue(formObj.all_flg);
			     		formParams += "&dcgo_flg="    +ComGetObjValue(formObj.dcgo_flg);
			     		formParams += "&rc_flg="      +ComGetObjValue(formObj.rc_flg);
			     		formParams += "&awk_cgo_flg=" +ComGetObjValue(formObj.awk_cgo_flg);
			     		formParams += "&bb_cgo_flg="  +ComGetObjValue(formObj.bb_cgo_flg);
			     		formParams += "&stwg_cgo_flg="+ComGetObjValue(formObj.stwg_cgo_flg);
			     		formParams += "&mlb_cd="      +ComGetObjValue(mlb_cd);
			     		formParams += "&pod_cd="      +ComGetObjValue(pod_cd);
			     		formParams += "&vsl_cd="      +ComGetObjValue(formObj.vsl_cd);
			     		formParams += "&skd_voy_no="  +ComGetObjValue(formObj.skd_voy_no);
			     		formParams += "&skd_dir_cd="  +ComGetObjValue(formObj.skd_dir_cd); 
			     		formParams += "&yd_cd="       +ComGetObjValue(formObj.yd_cd);
			     		sheetObj.DoSearch("VOP_OPF_0019GS.do", formParams + paramQty );
						break;
				}
				break;
				
			case IBSEARCH03:
				if (!validateForm(sheetObj, formObj, sAction)) return;
				var paramQty="";	
				var qtyVal="";
//				for(var qtyCt=1; qtyCt<=5; qtyCt++) {
//					if(qtyCt < comboObj.GetItemCount()) {
//						if(comboObj.SetSelectText== 'ALL') qtyVal(comboObj.GetText(qtyCt, 0));
//						else if(qtyCt == 1) qtyVal=comboObj.GetSelectText();
//						else qtyVal="";
//					} else {
//						qtyVal="";
//					}
//					paramQty=paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
//				}
				for(var qtyCt=1; qtyCt<=5; qtyCt++) {
					if(qtyCt < comboObj.GetItemCount()) {
						if(comboObj.GetSelectText()== 'ALL'){
							qtyVal = comboObj.GetText(qtyCt,0);
						}else if(qtyCt == 1) {
							qtyVal=comboObj.GetSelectText();
						}else {
							qtyVal="";
						}
					} else {
						qtyVal="";
					}
					paramQty=paramQty + "&" + "qty" + qtyCt + "=" + qtyVal;
				}	
				formObj.f_cmd.value=SEARCH13;
				sheetObj.DoSearch("VOP_OPF_2019GS.do", FormQueryString(formObj) + paramQty );
				break;	
		}
	}
	/**
	 * expand Sheet1 MLB column
	 * @param sheetObj
	 * @param what
	 */
	function spreadMlbCols(sheetObj) {
		with(sheetObj) {
			var podVal="", mlbVal="", fmVal="", wgVal="";
			var colVal1=GetCellValue(1, "pod");
			var colVal2=GetCellValue(1, "fm");
			var foldYn=false;
			//RenderSheet(0);
			if(colVal1.indexOf(">") != -1) {	//in case of state folded					
				SetCellValue(1,"pod",colVal1.replaceStr(">", "<"),0);
			} else {
				foldYn=true;
				SetCellValue(1,"pod",colVal1.replaceStr("<", ">"),0);
			}	
			SetColHidden("mlb",foldYn);
            if(colVal2.indexOf("<") != -1) {
            	for(var rowCt=HeaderRows(); rowCt<=LastRow(); rowCt++) {
					podVal=GetCellValue(rowCt, "pod");
					mlbVal=GetCellValue(rowCt, "mlb");
					fmVal=GetCellValue(rowCt, "fm");
					wgVal=GetCellValue(rowCt, "wg");
	            	if (mlbVal == "Sub WG" || (podVal == "Grand Total" && wgVal == "Total")) 	
					{
						SetRowHidden(rowCt,!foldYn);
					}
	            	if ((mlbVal != "Sub WG" && (fmVal == "Full" ||  fmVal == "Empty")  && wgVal != "Total" && wgVal != "Total Weight") ||	
	            		//(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal != "Total" && wgVal != "Total Weight") || 
	            		(fmVal == "Total" || fmVal == "Total Weight" ) ||  
	            		(fmVal == "Full Total" || fmVal == "Empty Total") 
	            		|| (podVal == "Grand Total" &&  fmVal == "Empty" && wgVal == "")
	            		)	        
					{
						SetRowHidden(rowCt,foldYn);
					}
	            	/*if ((podVal == "Grand Total" && (fmVal == "Full" || fmVal == "Empty")  && wgVal != "Total" && wgVal != "Total Weight")) {	
	            		SetRowHidden(rowCt,0);
	            	}*/
            	}
            //in case of closing Weight Group column
            } else {
				//1. fold and unfold MLB column
				for(var rowCt=HeaderRows(); rowCt<=LastRow(); rowCt++) {
					podVal=GetCellValue(rowCt, "pod");
					mlbVal=GetCellValue(rowCt, "mlb");
					fmVal=GetCellValue(rowCt, "fm");
					wgVal=GetCellValue(rowCt, "wg");
                	if ((podVal != "Grand Total" && fmVal == "Full"  && wgVal == "Total") || (podVal != "Grand Total" && fmVal == "Empty" && wgVal == "Total") || (mlbVal != "" && fmVal == "Total" ) || (mlbVal != "" && fmVal == "Total Weight" ))
					{
						SetRowHidden(rowCt,foldYn);
					}
                	if (foldYn && (fmVal == "Total" || fmVal == "Total Weight")) {	//hide all Total, Total Weight item(in case of folding)
	            		SetRowHidden(rowCt,1);
	            	}
				}	
            }
			//RenderSheet(1);
		}
	}
	/**
	 * expand Sheet1 Weight Group column
	 * @param sheetObj
	 * @param what
	 */
	function spreadWGCols(sheetObj) {
		with(sheetObj) {
			var podVal="", mlbVal="", fmVal="", wgVal="";
			var colVal1=GetCellValue(1, "pod");
			var colVal2=GetCellValue(1, "fm");
			var foldYn=false;
			//RenderSheet(0);
			if(colVal2.indexOf(">") != -1) {					
				SetCellValue(1,"fm",colVal2.replaceStr(">", "<"),0);
				SetCellValue(1,"wg",colVal2.replaceStr(">", "<"),0);
			} else {
				foldYn=true;
				SetCellValue(1,"fm",colVal2.replaceStr("<", ">"),0);
				SetCellValue(1,"wg",colVal2.replaceStr("<", ">"),0);
			}	
			SetColHidden("wg",foldYn);
			for (var rowCt=HeaderRows(); rowCt<=LastRow(); rowCt++) {
				podVal=GetCellValue(rowCt, "pod");
				mlbVal=GetCellValue(rowCt, "mlb");
				fmVal=GetCellValue(rowCt, "fm");
				wgVal=GetCellValue(rowCt, "wg");
                if(colVal1.indexOf(">") != -1) {	
                	if ((podVal == "Grand Total" && (fmVal == "Full" ||  fmVal == "Empty") && wgVal == "Total") || (fmVal == "Full Total" ) ||	(fmVal == "Empty Total" )) 		
                	{						
						SetRowHidden(rowCt,!foldYn);
					}
					if (mlbVal == "Sub WG" ||	
					   (podVal == "Grand Total" && (fmVal == "Full" ||  fmVal == "Empty") && wgVal != "Total" && wgVal != "Total Weight")) 		
					{
						SetRowHidden(rowCt,foldYn);
					}
					
                } else {							
                	if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal == "Total")  ||	
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal == "Total"))		
					{
						SetRowHidden(rowCt,!foldYn);
					}
					if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight") ||	
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal != "Total" && wgVal != "Total Weight"))	
					{
						SetRowHidden(rowCt,foldYn);
					}
                }
			}	
			//sheetObj.RenderSheet(1);
		}
	}
	/**
	 * t1sheet1_OnMouseDown
	 */
	function t1sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		with (sheetObj) {
			if(MouseCol()== SaveNameCol("pod") && MouseRow()== (HeaderRows()-1)) {
				spreadMlbCols(sheetObj);
			} else if((MouseCol()== SaveNameCol("fm") || MouseCol()== SaveNameCol("wg")) && MouseRow()== (HeaderRows()-1)) {
				spreadWGCols(sheetObj);
			}
		}
	}
	/**
	 * t2sheet1_OnMouseDown
	 */
	function t2sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		 with(sheetObj) {
			if(MouseCol()== SaveNameCol("pod") && MouseRow()== (HeaderRows()-1)) {
				RenderSheet(0);
				var foldYn=false;		
				var colVal=GetCellValue(2, "pod");
				if(colVal.indexOf(">") != -1) {
					SetCellValue(2, "pod",colVal.replaceStr(">", "<"),0);
				} else {
					foldYn=true;
					SetCellValue(2, "pod",colVal.replaceStr("<", ">"),0);
				}
				SetColHidden("mlb",foldYn);
				//fold, unfold by MLB
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if(SetCellValue(checkRow, "pod") != "G.Total" && GetCellValue(checkRow, "mlb") != "S.Total") GetRowHidden(checkRow,foldYn);
				}
				var subRow=FindText("mlb", "S.Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow();) {
					if(foldYn) SetRowBackColor(checkRow++,"#FFFFFF");
					else SetRowBackColor(checkRow++,"#F7E1EC");
					subRow=FindText("mlb", "S.Total", checkRow);
					if(subRow != -1) {
						checkRow=subRow;
					} else {
						checkRow=LastRow()+1;
					}
				}
				//RenderSheet(1);
			}
		}
	}
	/**
	 * t2sheet3_OnMouseDown
	 */
	function t2sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		 with (sheetObj) {
			if(MouseCol()== SaveNameCol("pod") && MouseRow()== (HeaderRows()-1)) {
				//RenderSheet(0);
				var foldYn=false;		
				var colVal=GetCellValue(HeaderRows()-1, "pod");
				if(colVal.indexOf(">") != -1) {
					SetCellValue(HeaderRows()-1, "pod",colVal.replaceStr(">", "<"),0);
					//show
					var rowC =sheetObj.RowCount();
					for(var i=2 ; rowC+2 > i;i++){
						 if( (i % 2) == 1){
							sheetObj.SetRowHidden(i, 0);
						 }
					}
				} else {
					foldYn=true;
					SetCellValue(HeaderRows()-1, "pod",colVal.replaceStr("<", ">"),0);
					//hidden
					var rowC =sheetObj.RowCount();
					for(var i=2 ; rowC+2 > i;i++){
						 if( (i % 2) == 1){
							sheetObj.SetRowHidden(i, 1);
						 }
					}
				}
				SetColHidden("mlb",foldYn);
				//fold, unfold by MLB
				for (var checkRow=HeaderRows(); checkRow<=LastRow(); checkRow++) {
					if(SetCellValue(checkRow, "pod") != "G.Total" && GetCellValue(checkRow, "mlb") != "S.Total") GetRowHidden(checkRow,foldYn);
				}
				var subRow=FindText("mlb", "S.Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow();) {
					if(foldYn) SetRowBackColor(checkRow++,"#FFFFFF");
					else SetRowBackColor(checkRow++,"#F7E1EC");
					subRow=FindText("mlb", "S.Total", checkRow);
					if(subRow != -1) {
						checkRow=subRow;
					} else {
						checkRow=LastRow()+1;
					}
				}
				
				//RenderSheet(1);
			}
			
			
		}
	}
	/**
     * handling Sheet1 OnMouseMove Event 
     * param : sheetObj
     * 
     */
    function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
    	with (sheetObj) {
	     	if (MouseRow()== (HeaderRows()-1) && (MouseCol()== SaveNameCol("pod") || MouseCol()== SaveNameCol("fm") || MouseCol()== SaveNameCol("wg"))) {
	     		SetMousePointer("Hand");
	     	} else {
	     		SetMousePointer("Default");
	     	}
    	}
    }
    /**
     * handling Sheet2 OnMouseMove Event 
     * param : sheetObj
     * 
     */
    function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
      	with (sheetObj) {
  	     	if (MouseRow()== (HeaderRows()-1) && MouseCol()== SaveNameCol("pod")) {
  	     		SetMousePointer("Hand");
  	     	} else {
  	     		SetMousePointer("Default");
  	     	}
      	}
    }
    /**
     * handling Sheet3 OnMouseMove Event 
     * param : sheetObj
     * 
     */
    function t2sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
      	with (sheetObj) {
  	     	if (MouseRow()== (HeaderRows()-1) && MouseCol()== SaveNameCol("pod")) {
  	     		SetMousePointer("Hand");
  	     	} else {
  	     		SetMousePointer("Default");
  	     	}
  	     	if (MouseRow()== 1 && MouseCol()> SaveNameCol("mlb")) {
  	     		for(var i=0; i<stwgNmList.length; i++) {
  	     			if(GetCellText(MouseRow(), MouseCol()) == stwgNmList[i].split("+")[0]) {
  	     				break;
  	     			}
  	     		}
  	     	}

      	}
    }
    /**
     * handling t2sheet1 OnClick Event 
     * param : sheetObj, Row, Col
     * 
     */
    function t2sheet3_OnClick(sheetObj, Row, Col, Val) {
      	with(sheetObj) {
      		if(SaveNameCol("prp_shp_nm") == Col || SaveNameCol("hzd_desc") == Col) {
      			if(Val != '') ComShowMemoPad(sheetObj, Row, Col, true, 250, 100);
      		}
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
	   	beforetab=nItem;
	   	if(beforetab == 1){
			ComEnableObject(formObject.all_flg, true);
	   		ComEnableObject(formObject.dcgo_flg, true);
	   		ComEnableObject(formObject.rc_flg, true);
	   		ComEnableObject(formObject.awk_cgo_flg, true);
	   		ComEnableObject(formObject.bb_cgo_flg, true);
	   		ComEnableObject(formObject.stwg_cgo_flg, true);
	   	} else{ 
			ComEnableObject(formObject.all_flg, false);
	   		ComEnableObject(formObject.dcgo_flg, false);
	   		ComEnableObject(formObject.rc_flg, false);
	   		ComEnableObject(formObject.awk_cgo_flg, false);
	   		ComEnableObject(formObject.bb_cgo_flg, false);
	   		ComEnableObject(formObject.stwg_cgo_flg, false);
	   	}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {	
			case IBSEARCH:
				//checking validation of all control in form object
				if (!ComChkValid(formObj, true, false, false))
					return false;
				if (comboObjects[0].GetSelectCode()== "") {
					ComShowCodeMessage("COM130404", "POL", "POL");					
					formObj.yd_cd.focus();
					return false;
				}
				break;
		}
		return true;
	}
/* Developer performance  end */