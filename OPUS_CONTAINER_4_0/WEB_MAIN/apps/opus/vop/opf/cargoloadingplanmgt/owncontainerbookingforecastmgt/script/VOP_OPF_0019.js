/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0019.js
*@FileTitle  : CBF for Own Booking (Creation) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
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
 * @class vop_opf_0019 : vop_opf_0019 business script for
 */
	/* Developer performance */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var prefix1="sheet1_";
	var prefix2="sheet2_";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event handler processing by button name */
	function processButtonClick() { 
		var sheetObj1=sheetObjects[0]; // t1sheet1
		var sheetObj2=sheetObjects[1]; // t1sheet2
		var tabObj=tabObjects[0];
		var comboObj=comboObjects[0];
		var formObj=document.form;
		var selTabIdx=tabObj.GetSelectedIndex();
		/** **************************************************** */
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {	
				case "btn_Retrieve":					
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH);
					break;
				case "btn_BookingClosingStatus":
					openBCSPopup(formObj);
					break;
				case "btn_Display":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBBATCH);
					break;
				case "btn_SummaryPreview":
					openSPPopup(formObj);	
					break;
				case "btn_DownExcel":
					if(sheetObjects[selTabIdx].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	sheetObjects[selTabIdx].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[selTabIdx]), SheetDesign:1,Merge:1 });
	        	    }
					break;
				case "btn_New":
					ComResetAll();
					comboObj.RemoveAll();
					//button deactivated
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_SaveAsXML");
					ComBtnDisable("btn_BookingClosingStatus");
					ComBtnDisable("btn_Display");
					ComBtnDisable("btn_SummaryPreview");
					ComBtnDisable("btn_DownExcel");
					//initial focus state
					ComSetFocus(formObj.vsl_cd);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBDELETE);
					break;	
				case "btn_Save":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE);					
					break;
				case "btn_vvd":
					var vslCd=ComGetObjValue(formObj.vsl_cd);
					var sUrl="";
					if (vslCd == "") {
						sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 460, 500, "setCallBackVSL", "0,0", true);
					} else {
						sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslCd;
						ComOpenPopup(sUrl, 460, 500, "setCallBackVVD", "0,0", true);
					}
					break;
			}
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
		}
	}
	/** 
	 * in case of clicking Booking Closing Status, call pop-up
	 */
	function openBCSPopup(formObj) {
		var vslCd=ComGetObjValue(formObj.vsl_cd);
		var skdVoyNo=ComGetObjValue(formObj.skd_voy_no);
		var skdDirCd=ComGetObjValue(formObj.skd_dir_cd);
		var ydCd=yd_cd.GetText(yd_cd.GetSelectCode(),0);
		var polCd=ydCd.substring(0, 5);
		var paramStr="";
		paramStr += 'vsl_cd=' + vslCd + skdVoyNo + skdDirCd + '&pol_cd=' + polCd+"&flag=true";
		//ComOpenPopup('/opuscntr/ESM_BKG_0587POP.do?pgmNo=ESM_BKG_0587&' + paramStr, 1025, 670, '', "0,1,1,1,1,1,1", true);
		ComOpenWindowCenter("/opuscntr/ESM_BKG_0587POP.do?pgmNo=ESM_BKG_0587&" + paramStr, "VOP_OPF_0019", 1030, 610, true);
	}
	/** 
	 * in case of clicking Summary Preview, call pop-up
	 */
	function openSPPopup(formObj) {	
		var vslCd=ComGetObjValue(formObj.vsl_cd);
		var skdVoyNo=ComGetObjValue(formObj.skd_voy_no);
		var skdDirCd=ComGetObjValue(formObj.skd_dir_cd);
		var ydCd=comboObjects[0].GetSelectCode();
		var ydNm=ComGetObjValue(formObj.yd_nm);
		var cbfIndFlg=formObj.cbf_ind_flg[0].checked?formObj.cbf_ind_flg[0].value:formObj.cbf_ind_flg[1].value
		var vslSlanCd=ComGetObjValue(formObj.slan_cd);
		var paramStr="";
		paramStr += 'vsl_cd=' + vslCd + '&skd_voy_no=' + skdVoyNo + '&skd_dir_cd=' + skdDirCd;
		paramStr += '&yd_cd=' + ydCd + '&yd_nm=' + ydNm + '&cbf_ind_flg=' + cbfIndFlg;
		paramStr += "&vsl_slan_cd=" + vslSlanCd + "&crr_cd="+ConstantMgr.getCompanyCode()+"&bkg_shpr_ownr_flg=Y";	
		ComOpenWindowCenter("VOP_OPF_2019.do?" + paramStr, "win2", "1000", "580", true, "yes");
	}
	/**
     * Sheet1 OnSearchEnd Event 
     * param : sheetObj, ErrMsg ==> result Message
     * 
     */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		var tabObj=tabObjects[0];
		var selTabIdx=tabObj.GetSelectedIndex();
		var cbfRmkEditable=false;
		//1. Retrieve
		if(ComGetObjValue(formObj.f_cmd) == SEARCH) {
			with (sheetObj) {
				if(RowCount()> 0) {
					for (var radioCt=0; radioCt<2; radioCt++) {
						
						//1. CBF(Pre, Final) 
						//if (GetCellValue(LastRow(), prefix1+"cbf_ind_flg") == formObj.cbf_ind_flg[radioCt].value) {
						//	formObj.cbf_ind_flg[radioCt].checked=true;
						//}
						
						//2. Booking Status 
						if (GetCellValue(LastRow(), prefix1+"cbf_bkg_sts_cd") == formObj.cbf_bkg_sts_cd[radioCt].value) {
							formObj.cbf_bkg_sts_cd[radioCt].checked=true;
						}						
					}
					
					//1. CBF(Pre, Final) 
					if(GetCellValue(LastRow(), prefix1+"cbf_ind_flg") == "P"){
						formObj.cbf_ind_flg[0].checked	= true;		//:for Pre CBF://
					}else if(GetCellValue(LastRow(), prefix1+"cbf_ind_flg") == "F"){
						formObj.cbf_ind_flg[1].checked	= true;		//:for Final CBF://
					}else{
						formObj.cbf_ind_flg[0].checked	= true;		//:for Pre CBF://
					}					
					
					
					//3. Actual Cntr Flg 
					if (GetCellValue(LastRow(), prefix1+"ac_cntr_flg") == "C") {
						formObj.ac_cntr_flg.checked=true;
					} else {
						formObj.ac_cntr_flg.checked=false;
					}
					//3. activating related button
					ComBtnEnable("btn_Delete");
					ComBtnEnable("btn_Save");
					//ComBtnEnable("btn_SaveAsXML");
					ComBtnEnable("btn_SummaryPreview");
					if(selTabIdx == 0) ComBtnEnable("btn_DownExcel");
					//4.setting Last Created 
					ComSetObjValue(formObj.upd_usr_id, GetCellValue(LastRow(), prefix1+"upd_usr_id"));
					ComSetObjValue(formObj.upd_dt, GetCellValue(LastRow(),  prefix1+"upd_dt"));
				} else {					
					formObj.cbf_ind_flg[0].checked=true;
					formObj.cbf_bkg_sts_cd[0].checked=true;
					ComSetObjValue(formObj.upd_usr_id, "");
					ComSetObjValue(formObj.upd_dt, "");
					//5.related button deactivated
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_SaveAsXML");
					ComBtnDisable("btn_SummaryPreview");
					if(selTabIdx == 0) ComBtnDisable("btn_DownExcel");
				}
				//6.activating Display button
				ComBtnEnable("btn_Display");	
				//7. deciding Booking Status 
				ComSetObjValue(formObj.bk_st, formObj.cbf_bkg_sts_cd[0].checked?formObj.cbf_bkg_sts_cd[0].value:formObj.cbf_bkg_sts_cd[1].value);
			}
	    //2. Display
		} else {
			with (sheetObj) {
				if(RowCount()> 0) {
					ComBtnEnable("btn_Save");
					//ComBtnEnable("btn_SaveAsXML");
					ComBtnEnable("btn_DownExcel");
					ComBtnDisable("btn_SummaryPreview");
					ComShowCodeMessage("OPF50014");	//'Booking data was imported successfully.'
				} else {
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_SaveAsXML");
					ComBtnDisable("btn_DownExcel");
				}
				ComBtnDisable("btn_Delete");
			}
			cbfRmkEditable=true;
		}
		doColEditable(sheetObjects[1], cbfRmkEditable);
	}
    /**
     * Sheet1 OnSearchEnd Event 
     * param : sheetObj, ErrMsg ==> result Message
     * 
     */
 	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		var tabObj=tabObjects[0];
		var selTabIdx=tabObj.GetSelectedIndex();
 		with (sheetObj) {
			if(RowCount()> 0) {
				if(selTabIdx == 1) ComBtnEnable("btn_DownExcel");
			} else {
				if(selTabIdx == 1) ComBtnDisable("btn_DownExcel");
			}
 		}
 	}
    /**
     * t2sheet1 OnClick Event 
     * param : sheetObj, Row, Col
     * 
     */
    function t2sheet1_OnClick(sheetObj, Row, Col, Val) {
     	with(sheetObj) {
     		if(SaveNameCol(prefix2 + "prp_shp_nm") == Col || SaveNameCol(prefix2 + "hzd_desc") == Col) {
     			if(Val != '') ComShowMemoPad(sheetObj, Row, Col, true, 250, 100);
     		}
     	}
    }
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items  
	 * 
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
		if(sheetObjects[nItem].RowCount()> 0) ComBtnEnable("btn_DownExcel");
			else ComBtnDisable("btn_DownExcel");
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag 
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
			initSheet(sheetObjects[i], i + 1);	
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		resizeSheet(); 
		
		//button deactivated
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_SaveAsXML");
		ComBtnDisable("btn_BookingClosingStatus");
		ComBtnDisable("btn_Display");
		ComBtnDisable("btn_SummaryPreview");
		ComBtnDisable("btn_DownExcel");
		//register Axon Event Listener 
		initControl();
		//initial focus state
		ComSetFocus(document.form.vsl_cd);
		
	}
	/**
	 * initialize IBCOMBO. <br>
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "yd_cd":
				with (comboObj) {
					SetBackColor("#CCFFFF");
					SetDropHeight(230);
					SetMultiSelect(0);
					SetMaxSelect(1);
					SetUseAutoComplete(1);
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
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
		// axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
	}
	/**
	 * handling next focus OnKeyUp event automatically after required input <br>
	 **/
//	function obj_keyup() {
//		 if(event.keyCode != 9) obj_nextfocus(event.srcElement);
//	}
	//change focus to next HTML Tag(object) of HTML Tag(object) received as factor
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
	 * work javascript OnFocusOut event <br>
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
	 * retrieve VVD info <br>
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
			var sXml=sheetObj.GetSearchData("VOP_OPF_0019GS.do", FormQueryString(formObj));
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
			ComSetObjValue(formObj.upd_usr_id, "");
			ComSetObjValue(formObj.upd_dt,     "");
		}
		//Common
		for (var radioCt=0; radioCt<2; radioCt++) {
			formObj.cbf_ind_flg[radioCt].checked=false;
			formObj.cbf_bkg_sts_cd[radioCt].checked=false;
		}
		for (var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {	
			sheetObjects[sheetCt].RemoveAll();
		}
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_SaveAsXML");
		ComBtnDisable("btn_BookingClosingStatus");
		ComBtnDisable("btn_Display");
		ComBtnDisable("btn_SummaryPreview");
		ComBtnDisable("btn_DownExcel");
	}
	/**
	 * in case of selecting POL combo data <br>
	 **/
	function yd_cd_OnChange(comboObj, Code, Text) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		//initializing related item
		resetForCondition(formObj, "vvd-pol");
		if(Code != '') {		
			//get POL Info 
			formObj.f_cmd.value=SEARCH02;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("VOP_OPF_0019GS.do", FormQueryString(formObj));
			sheetObj.SetWaitImageVisible(1);
			var sPol=ComGetEtcData(sXml, "sPol");
			if (sPol != undefined) {
				var arrPol=sPol.split("|");
				ComSetObjValue(formObj.loc_nm, arrPol[0]);
				ComSetObjValue(formObj.yd_nm,  arrPol[1]);
				ComSetObjValue(formObj.eta,    arrPol[2]);
				ComBtnEnable("btn_BookingClosingStatus");
				ComSetFocus(formObj.cbf_ind_flg[0]);
			}
		}
	}
	/**
	 * in case of inputting retrieve condition, validation <br>
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
	 * in case of updating VVD  data <br>
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
	 * Setting data received from VSL Code Help (Pop-Up)<br>
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
	 * setting data received from VVD Code Hepl(Pop-Up)<br>
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
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
			case 1: // t1sheet1 init
			    with(sheetObj){
				      var HeadTitle1="|No.|BKG No.|CNTR No.|POD|MLB|OPR|TP|WGP|F/E|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Special Cargo|STWG|CN GR WT\n(kg)|BKG\nStatus|CBF DP CD|UPD USR ID|UPD DT|VSL CD|SKD VOY NO|SKD DIR CD|BKG SHPR OWNR FLG|YD CD|POL_CLPT_IND_SEQ|POD_CLPT_IND_SEQ|CBF SMRY SEQ|SPCL CGO SEQ|FWRD OVR DIM LEN|BKWD OVR DIM LEN|HGT OVR DIM LEN|CBF IND FLG|Booking Status|ActCntrFlg|RD ST|HIDDEN|SLAN CD|";
				      var HeadTitle2="|No.|BKG No.|CNTR No.|POD|MLB|OPR|TP|WGP|F/E|DG|RF|AK|BB|ST|STWG|CN GR WT\n(kg)|BKG\nStatus|";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"No." },
				             {Type:"Text",      Hidden:0,  Width:111,  Align:"Center",    ColMerge:1,   SaveName:prefix1+"bkg_ref_no_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:1,   SaveName:prefix1+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"mlb_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"crr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"cntr_wgt_grp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"full_mty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"dcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"rc_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"awk_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"bb_cgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"stwg_cgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"stwg_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"cntr_grs_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cbf_dp_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_usr_id" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_dt" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"vsl_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_voy_no" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_dir_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"bkg_shpr_ownr_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"yd_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pol_clpt_ind_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pod_clpt_ind_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cbf_smry_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"spcl_cgo_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"fwrd_ovr_dim_len" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"bkwd_ovr_dim_len" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"hgt_ovr_dim_len" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cbf_ind_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cbf_bkg_sts_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ac_cntr_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"rd_st" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"hid" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"slan_cd" },
				             {Type:"Seq",       Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"hseq" },
				             {Type:"Text",      Hidden:1,  Width:90,  Align:"Left",    ColMerge:1,   SaveName:prefix1+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             ];
				      InitColumns(cols);
				      SetEditable(0);
				      SetHeaderRowHeight(20);
				      SetColHidden(prefix1 + "hseq",1);
				      SetHighlightAfterSort(1);
				      //SetSheetHeight(342);
					}
				break;
				
			case 2: // sheet2 init
			    with(sheetObj){
				      var HeadTitle1="|No.|BKG No.|CNTR No.|POD|MLB|CGO\nOPR|TP|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Special Cargo|Seq.|Seq.|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|PSN|TN|SRL|MP|PG|LQ|EQ|FP\n(°C)|Reefer\nTemp.(°C)|Commodity|OverAll(cm)|OverAll(cm)|OverAll(cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Post\n Extd.|STWG|APVL|APVL Ref. No.|Remark(s)|CBF DP CD|||||||||||CBF IND FLG|Booking Status|RD ST|HIDDEN|SLAN CD|";
				      var HeadTitle2="|No.|BKG No.|CNTR No.|POD|MLB|CGO\nOPR|TP|DG|RF|AK|BB|ST|CNTR|CGO|CN GR WT\n(kg)|CGO GR WT\n(kg)|IMO|UN No.|PSN|TN|SRL|MP|PG|LQ|EQ|FP\n(°C)|Reefer\nTemp.(°C)|Commodity|L|W|H|FWD|AFT|Left|Right|Height|Post\n Extd.|STWG|APVL|APVL Ref. No.|Remark(s)|||||||||||||||||";
				      var headCount=ComCountHeadTitle(HeadTitle2);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"No." },
				             {Type:"Text",      Hidden:0, Width:111,   Align:"Center",    ColMerge:1,   SaveName:prefix2+"bkg_ref_no_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:86,   Align:"Center",    ColMerge:1,   SaveName:prefix2+"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"mlb_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"crr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"dcgo_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"rc_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"awk_cgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"bb_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"stwg_cgo_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
				             {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cgo_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"cntr_grs_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"cgo_grs_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"imdg_clss_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"imdg_un_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix2+"prp_shp_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix2+"hzd_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"imdg_subs_rsk_lbl_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"imdg_mrn_polut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"pck_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"lmt_qty_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"expt_qty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"fdo_temp",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cdo_temp",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"cbf_cmdt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"dim_len",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"dim_wdt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"dim_hgt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"ovr_fwd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"ovr_aft",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"ovr_lft",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"ovr_rgt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"ovr_hgt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"crn_pst_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"stwg_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"spcl_cgo_auth_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"apro_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix2+"cbf_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cbf_dp_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"upd_usr_id" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"upd_dt" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"vsl_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"skd_voy_no" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"skd_dir_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"bkg_shpr_ownr_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"yd_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pol_clpt_ind_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"pod_clpt_ind_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cbf_smry_seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cbf_ind_flg" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"cbf_bkg_sts_cd" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"rd_st" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"hid" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"slan_cd" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"hseq" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix2+"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
				             ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetImageList(0,"img/opus/button/btns_multisearch.gif");
				      SetImageList(1,"img/opus/button/btng_minus.gif");
				      SetEditableColorDiff(0);
				      SetCellBackColor(1,0,"#C1C4E8");
				      SetColHidden(prefix2 + "hseq",1);
				      SetHighlightAfterSort(1);
				      SetHeaderRowHeight(20);
				      SetFocusEditMode(-1);
				      //SetSheetHeight(410);
		      		}
				break;
		}
	}
	
    function resizeSheet(){    	
    	for (i=0; i<sheetObjects.length; i++){
    		ComResizeSheet2(sheetObjects[i]);
        }
    }
    
	// Sheet Redraw
	function doRenderSheet(how) {
		for(var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {
			sheetObjects[sheetCt].RenderSheet(how);
		}
	}
	// Sheet ColEditable
	function doColEditable(sheetObj, how) {
		//sheetObj.InitDataProperty(0, sheetObj.SaveNameCol(prefix2+"cbf_rmk"), dtData, 150, daLeft, true, prefix2+"cbf_rmk", false, "", dfNone, 0, how, how);
	}
	//Booking Status 
	function rollBackBkgStaus(formObj) {
		for (var radioCt=0; radioCt<2; radioCt++) {
			if (ComGetObjValue(formObj.bk_st) == formObj.cbf_bkg_sts_cd[radioCt].value) {
				formObj.cbf_bkg_sts_cd[radioCt].checked=true;
			}
		}
	}
	// handling process related Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {	
			case IBSEARCH: // Retrieve
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
					//evincive Creation parameter
					var formParams="";
					formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
					formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
					formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
					formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
					formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
					formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
					formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
					formParams += "&yd_cd="             +comboObjects[0].GetSelectCode();
					formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
					formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
					formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
					formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);

					ComOpenWait(true);
					setTimeout(function(){
						var sXml=sheetObj.GetSearchData("VOP_OPF_0019GS.do", formParams+"&"+ComGetPrefixParam(new Array(prefix1, prefix2)));
						var arrXml=sXml.split("|$$|");
						var arrCt=arrXml.length;
						if (arrXml != null && arrCt > 0) {
							for (var sRstCt=arrCt; sRstCt>0; sRstCt--) {
								sheetObjects[sRstCt-1].LoadSearchData(arrXml[sRstCt-1],{Sync:1} );
							}
						}	
						ComOpenWait(false);
					},300);	

				}
				break;
			case IBBATCH: // Display
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				//Booking Status 
				ComSetObjValue(formObj.bk_st, formObj.cbf_bkg_sts_cd[0].checked?formObj.cbf_bkg_sts_cd[0].value:formObj.cbf_bkg_sts_cd[1].value);
				formObj.f_cmd.value=REPLY;
				//evincive Creation parameter
				var formParams="";
				formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
				formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
				formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
				formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
				formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
				formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
				formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
				formParams += "&yd_cd="             +comboObjects[0].GetSelectCode();
				formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
				formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
				formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
				
				ComOpenWait(true);
				setTimeout(function(){
					var sXml=sheetObj.GetSearchData("VOP_OPF_0019GS.do", formParams+"&"+ComGetPrefixParam(new Array(prefix1, prefix2)));
					var arrXml=sXml.split("|$$|");
					var arrCt=arrXml.length;
					if (arrXml != null && arrCt > 0) {
						for (var bRstCt=arrCt; bRstCt>0; bRstCt--) {
							sheetObjects[bRstCt-1].LoadSearchData(arrXml[bRstCt-1],{Sync:1} );
						}
					}					
					ComOpenWait(false);
					
					displayTab1MinusWeight(sheetObjects[0]);
				},300);	
	

				break;
			case IBDELETE:        
	    		if(!ComShowCodeConfirm('OPF50002', 'data')) return false;	//'Do you want to delete {?msg1}?'
	     	    formObj.f_cmd.value=REMOVE;
	     	    //evincive Creation parameter
				var formParams="";
				formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
				formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
				formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
				formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
				formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
				formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
				formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
				formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
				formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
				formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
				formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
				formParams += "&yd_cd="             +comboObjects[0].GetSelectCode();
				formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
				formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
				formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
				formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
				ComOpenWait(true);
				setTimeout(function(){
					var sXml=sheetObj.GetSaveData("VOP_OPF_0019GS.do", formParams);
//					sheetObj.LoadSaveData(sXml);
					sheetObj.LoadSaveData(sXml, {Sync:1});
//		 		    document.all.btn_New.fireEvent('onclick');
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		 		    ComBtnDisable("btn_Delete");
					ComOpenWait(false);
				},300);	

	            break;  
	            
			case IBSAVE: // Save
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				if(ComGetObjValue(formObj.f_cmd) == SEARCH) {					
					var sheetObj2=sheetObjects[1];
					var sParam=ComGetSaveString(sheetObj2);
					if(sParam == "") {
						
						if(sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(), prefix1+"cbf_ind_flg") == ComGetObjValue(formObj.cbf_ind_flg)) return;
						if (!ComShowCodeConfirm("OPF50019")) return;
						rollBackBkgStaus(formObj);
						formObj.f_cmd.value=MULTI;
						//evincive Creation parameter
						var formParams="";
						formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
						formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
						formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
						formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
						formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
						formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
						formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
						formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
						formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
						formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
						formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
						formParams += "&yd_cd="             +comboObjects[0].GetSelectCode();
						formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
						formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
						formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
						formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
						ComOpenWait(true);
						setTimeout(function(){
							var sXml=sheetObj2.GetSaveData("VOP_OPF_0019GS.do", formParams);
							sheetObj.LoadSaveData(sXml, {Sync:1});	
							ComOpenWait(false);
						},300);	
						
//						var sXml=sheetObj2.GetSaveData("VOP_OPF_0019GS.do", formParams);
//						sheetObj2.LoadSaveData(sXml);
					} else {
						if (!ComShowCodeConfirm("OPF50019")) return;
						formObj.f_cmd.value=MULTI;
						//evincive Creation parameter
						var formParams="";
						formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
						formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
						formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
						formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
						formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
						formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
						formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
						formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
						formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
						formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
						formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
						formParams += "&yd_cd="             +comboObjects[0].GetSelectCode();
						formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
						formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
						formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
						formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
						ComOpenWait(true);
						setTimeout(function(){
							sheetObj2.DoSave("VOP_OPF_0019GS.do", formParams, -1, false);	
							ComOpenWait(false);
						},300);	
						
					}					
					formObj.f_cmd.value=SEARCH;
				} else {
					var fCmd=formObj.f_cmd.value;
					formObj.f_cmd.value=SEARCH06;
					//evincive Creation parameter
					var formParams="";
					formParams += "bk_st="              +ComGetObjValue(formObj.bk_st);
					formParams += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
					formParams += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
					formParams += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					formParams += "&pagerows="          +ComGetObjValue(formObj.pagerows);
					formParams += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					formParams += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					formParams += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					formParams += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
					formParams += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
					formParams += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
					formParams += "&yd_cd="             +comboObjects[0].GetSelectCode();
					formParams += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
					formParams += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
					formParams += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
					formParams += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
					var sXml=sheetObj.GetSearchData("VOP_OPF_0019GS.do", formParams);
					
					var sCBFCount=ComGetEtcData(sXml, "sCBFCount");
					if (sCBFCount > 0) {
						if (!ComShowCodeConfirm("OPF50019")) {
							formObj.f_cmd.value=fCmd;
							return;
						}
					} 
					var creDt=ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");					
					ComSetObjValue(formObj.cre_dt, creDt)
					rollBackBkgStaus(formObj);
					formObj.f_cmd.value=MULTI;
					
					//evincive Creation parameter
					var sParam="";
					sParam += "bk_st="              +ComGetObjValue(formObj.bk_st);
					sParam += "&bkg_shpr_ownr_flg=" +ComGetObjValue(formObj.bkg_shpr_ownr_flg);
					sParam += "&cre_dt="            +ComGetObjValue(formObj.cre_dt);
					sParam += "&crr_cd="            +ComGetObjValue(formObj.crr_cd);
					sParam += "&pagerows="          +ComGetObjValue(formObj.pagerows);
					sParam += "&vsl_cd="            +ComGetObjValue(formObj.vsl_cd);
					sParam += "&skd_dir_cd="        +ComGetObjValue(formObj.skd_dir_cd);
					sParam += "&skd_voy_no="        +ComGetObjValue(formObj.skd_voy_no);
					sParam += "&slan_cd="           +ComGetObjValue(formObj.slan_cd);
					sParam += "&upd_dt="            +ComGetObjValue(formObj.upd_dt);
					sParam += "&upd_usr_id="        +ComGetObjValue(formObj.upd_usr_id);
					sParam += "&yd_cd="             +comboObjects[0].GetSelectCode();
					sParam += "&ac_cntr_flg="       +ComGetObjValue(formObj.ac_cntr_flg);	
					sParam += "&cbf_bkg_sts_cd="    +ComGetObjValue(formObj.cbf_bkg_sts_cd);
					sParam += "&cbf_ind_flg="       +ComGetObjValue(formObj.cbf_ind_flg);
					sParam += "&f_cmd="             +ComGetObjValue(formObj.f_cmd);
//					var sParam1 = sheetObjects[0].GetSaveString();
//					var sParam2 = sheetObjects[1].GetSaveString();
					sParam += "&"+ getAllSaveText(sheetObjects[0]);				
					sParam += "&"+ getAllSaveText(sheetObjects[1]);
//					var sParam = sheetObjects[0].GetSaveString(false);
		     		//var sParam = ComCgmGetAllSaveText(sheetObjects[0], true);
//					alert(sParam);
//					alert(4);
//					sParam += "&" +sParam1;
//					sParam += "&" +sParam2;
					ComOpenWait(true);
					setTimeout(function(){
						var sXml=sheetObj.GetSaveData("VOP_OPF_0019GS.do", sParam);
						sheetObj.LoadSaveData(sXml);	
						ComOpenWait(false);
					},300);	
					
//					sheetObj.LoadSaveData(sXml, {Sync:1});
					ComBtnEnable("btn_Delete");
					ComBtnEnable("btn_SummaryPreview");
					formObj.f_cmd.value=SEARCH;
					var sheet1Ct=sheetObjects[0].RowCount();
					var sheetObj2=sheetObjects[1];
					for(var upCt=sheetObj2.HeaderRows(); upCt<=sheetObj2.LastRow(); upCt++) {
						sheetObj2.SetCellValue(upCt, prefix2+"cbf_smry_seq",++sheet1Ct,0);
						sheetObj2.SetCellValue(upCt, prefix2+"cbf_ind_flg",ComGetObjValue(formObj.cbf_ind_flg),0);
						sheetObj2.SetCellValue(upCt, prefix2+"cbf_bkg_sts_cd",ComGetObjValue(formObj.cbf_bkg_sts_cd),0);
						sheetObj2.SetRowStatus(upCt,"R");
					}
					ComSetObjValue(formObj.upd_usr_id, userId);
					ComSetObjValue(formObj.upd_dt, creDt);
				}
				sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(), prefix1+"cbf_ind_flg",ComGetObjValue(formObj.cbf_ind_flg),0);
				break;
		}
	}
	//Making string to save
	function getAllSaveText(sheetObj) {		
		var arrSave=new Array();
		for (var i=0; i<=sheetObj.LastCol(); i++ ) {
			arrSave[i]=sheetObj.ColSaveName(i);
		}
		
		var str=sheetObj.GetRangeText(sheetObj.HeaderRows(), 0, sheetObj.LastRow(), sheetObj.LastCol(), "|", "^");

		str=str.replace(/\,/gi, "");
		
		var arrStr=str.split("^");
		for (var i=0 ; i < arrStr.length; i++) {
			var arrCol=arrStr[i].split("|");
			for (var j=0 in arrCol) {
				arrCol[j]=arrSave[j]+"="+arrCol[j];
			}
			arrStr[i]=arrCol.join("&");
		}
		return  arrStr.join("&");
	}
	
	/*******************************************************************************
	 * Validation start *
	 ******************************************************************************/
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH:
			//checking validation of all control in form object
			if (!ComChkValid(formObj, true, false, false)) return false;
			//Check requirement of POL
	    	if(ComGetObjValue(document.all.yd_cd) == '') {
	    		ComAlertFocus(document.all.yd_cd, "'POL' " +Msg_Required);	    		
	    		return false;
	    	}
			break;
		case IBSAVE:
			//Check requirement of CBF
			var chkRslt=false;
			for(var chkCt=0; chkCt < formObj.cbf_ind_flg.length; chkCt++) {
				if(formObj.cbf_ind_flg[chkCt].checked) chkRslt=true;
			}
			if(!chkRslt) {
				ComAlertFocus(formObj.cbf_ind_flg[0], "'CBF' " +Msg_Required);
			 if (document.all.cbf_ind_flg[i].checked == true) 
				return false;
			}
				 num_temp = document.form.cbf_ind_flg.length;
				 for (i=0;i<num_temp ;i++) { 
					 //alert(document.form.cbf_ind_flg[i].checked);
					  if (document.form.cbf_ind_flg[i].checked == true) {
						  break; 
					  } 
					  if (i == num_temp) 
					  { 
						  ComAlertFocus('', "'CBF' " +Msg_Required);
					  } 
					  return true;
				 } 
			//checking validation of all control in form object
			if (!ComChkValid(formObj, true, false, false)) return false;
			//Check requirement of POL
	    	if(ComGetObjValue(document.all.yd_cd) == '') {
	    		ComAlertFocus(document.all.yd_cd, "'POL' " +Msg_Required);	    		
	    		return false;
	    	}
			break;
		}
		return true;
	}
	
	function displayTab1MinusWeight(sheetObj) {
		with (sheetObj) {
			for (var i = 0; i <= RowCount(); i++) {
				if (GetCellValue(i, prefix1+"cntr_grs_wgt") < 0) {
					SetCellFontColor(i, prefix1+"cntr_grs_wgt", "#FF0000"); // RED
				}
			}
		}
	}
/* Developer performance end */