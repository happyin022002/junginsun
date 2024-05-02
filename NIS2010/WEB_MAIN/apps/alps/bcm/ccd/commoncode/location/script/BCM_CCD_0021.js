/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : BCM_CCD_0021.js
 *@FileTitle  : zone
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/03
=========================================================*/ 
/** Common global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button name */
function processButtonClick(){
	/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;

	try {
		var srcName=ComGetEvent("name");

		switch(srcName) {
			case "btn_History":
				var tblNo = 'MDM_ZONE';
				var znCd = formObject.zn_cd.value;
				var mstKey = nullToBlank(znCd);
				if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Zone Code");
					return false;
				}
				comMdmCallPop(tblNo, mstKey);
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObject1, formObject, IBCLEAR);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
			case "btn_Create":
				doActionIBSheet(sheetObject1, formObject, IBCREATE);
				break;
			case "btn_Close":
				self.close(); 
				break;
			case "btn_Request":
				doActionIBSheet(sheetObjects[0], document.form, MULTI03); 
				break;
			case "btns_search1":
				var formObj=document.form;
				var sUrl="/hanjin/COM_ENS_061.do?mdm_yn="+formObj.mdm_yn.value+"node_cd=" + formObj.rep_yd_cd.value +"&main_page=&mode=yard&mode_only=Y";
				var rVal=ComOpenPopup(sUrl, 800, 430, "ydCodeHelp", "0,0", true);
				break;
			case "btns_search2":
	//			alert(event.srcElement.className);
				if((event.srcElement.style.cursor) == "default") return;
				var formObj=document.form;
				var sUrl="/hanjin/COM_ENS_061.do?node_cd=" + formObj.zn_cd.value +"&main_page=&mode=zone&mode_only=Y&mdm_yn="+ formObj.mdm_yn.value;
				var rVal=ComOpenPopup(sUrl, 800, 430, "znCodeHelp", "0,0", true);
				break;
			case "btn_RowAdd":
				addRow();
				break;
			case "btn_RowDelete":
				deleteRow();
				break;
		} // end switch
	} catch(e) {
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
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++]=combo_obj;  
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */                
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k]);
	}

	initControl();
	document.form.ibflag.value="I";
	doActionIBCombo(sheetObjects[0], document.form, SEARCH01);
	ComBtnDisable("btn_RowAdd");
	ComBtnDisable("btn_RowDelete");
	ComSetDisplay("btn_RowDelete_set", false);
	var formObj=document.form;
	// auth_tp_cd retrieve
	doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
	var authTpCd=G_AHTU_TP_CD;
	var rqstNo=formObj.rqst_no.value;
	if(G_MDAA_CHK == 'Y') {
		ComEnableObject(formObj.delt_flg, true);
	} else {
		ComEnableObject(formObj.delt_flg, false);
	}
	ComBtnDisable('btn_Save');
	ComSetDisplay('btn_Retrieve', true);
	// MDM Authority is not Approval('A') or MDDA
	if( authTpCd == 'R' || authTpCd == 'S' || G_MDAA_CHK == 'Y') {
		ComSetDisplay('btn_New', true);
		ComSetDisplay('btn_Save', true);
	} else {
		//General User if you do not have MDM Authority
		ComSetDisplay('btn_New', true);
	}
}
/**
 *Define an event control
 */
function initControl() {
	var formObj=document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', document.form);
	axon_event.addListenerForm('change', 'formObj_OnChange', document.form);
	//axon_event.addListenerForm('focus', 'obj_focus', formObj);
//	axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
//	axon_event.addListenerForm  ('change', 'obj_change', form);
//	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);     //- focust out "
//	ComClearSeparator (document.form.zn_cd,"eng"); //Only English 
//	ComClearSeparator (document.form.zn_nm,"eng"); //Only English
//	ComClearSeparator (document.form.cgo_hndl_tm_hrs,"eng"); //Only English
//	ComClearSeparator (document.form.rep_yd_cd,"eng"); //Only English
}
/**
 * The default setting Combo
 * If the number of combo a combo by adding the number of case sheets to initialize the module configuration. 
 */ 
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
}
/**
 * The initial setting sheet, Header definition
 * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
 * If the number of seats a case by adding the number of sheets sheets should initialize the module configuration
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;

	switch(sheetID) {
		case "sheet1":      //sheet1 init
			with(sheetObj){ 
				// 높이 설정
				style.height = 312;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth
		
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
		
				// 전체 Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				// 행정보설정[필수][HEADROWS, DATASROWS, VIEWROWS, ONEPAGEROWS=100]
				initRowInfo(1, 1, 2, 100);
		
				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTDEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(12, 0, 0, false);
		
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
		
				var HeadTitle="|Del|Seq|znseq|Postal Code|District|Delete Flag|Create User|Create Date/Time|Last Update User|Last Update Date/Time";
		
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true)
				var prefix="sheet1_";
		
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT,
				// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
				// FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,   30, daCenter, false, prefix + "ibflag"    , false, "", dfNone, 0, true , true);
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, prefix + "del");
				InitDataProperty(0, cnt++, dtSeq,      30, daCenter, true, prefix + "seq");
				InitDataProperty(0, cnt++, dtHidden,   80, daCenter, true, prefix + "zn_seq"    , false, "", dfNone, 0, true , true , 12);
				InitDataProperty(0, cnt++, dtData,    190, daCenter, true, prefix + "zip_cd"    , true , "", dfNone, 0, true , true , 10);
				InitDataProperty(0, cnt++, dtData,    190, daLeft,   true, prefix + "dstr_nm"   , false, "", dfNone, 0, true , true , 50);
				InitDataProperty(0, cnt++, dtCombo,    80, daCenter, true, prefix + "delt_flg"  , false, "", dfNone, 0, true , true );
				InitDataProperty(0, cnt++, dtData,     80, daCenter, true, prefix + "cre_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,    150, daCenter, true, prefix + "cre_dt"    , false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,    110, daCenter, true, prefix + "upd_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,    150, daCenter, true, prefix + "upd_dt"    , false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,   80, daCenter, true, prefix + "flg"       , false, "", dfNone, 0, true , true );
		
				InitDataCombo(0, prefix + "delt_flg", "N|Y", "N|Y");
		
				ColHidden(prefix + "del") = true;
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
			var sXml=sheetObj.GetSearchXml("BCM_CCD_0021GS.do", "f_cmd=" + SEARCH01);
			var rtnValue=sXml.split("|$$|");
			for(var i=0; i<rtnValue.length; i++){
				var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
				if(comboXml!=null){
					var cdName=comboXml[0].split("|");
					var cdValue=comboXml[1].split("|");
					if(cdName[1] == "K") {
						cdName[1] = "Km";
					} 
					if(cdName[2] == "M") {
						cdName[2] = "Mile";
					}
					for (var j=0; j < cdName.length; j++) {
						comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
					}
				}
			}
			break;
	}
}
//Sheet processing-related processes
function doActionIBSheet(sheetObj,formObj,sAction) {
	var prefix="sheet1_";
		switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
		//			formObj.f_cmd.value=SEARCH05;
					var zn_cd=formObj.zn_cd.value;
					var sParam=FormQueryString(formObj);
					var prefixArr=new Array("", prefix);
					var sXml=sheetObj.GetSearchXml("BCM_CCD_0021GS.do", sParam + "&" + ComGetPrefixParam(prefixArr));              
					var rtnValue=sXml.split("|$$|");     
					var sav=ComGetEtcData(rtnValue[0], "TRANS_RESULT_KEY");
					var rqstNo=ComGetEtcData(rtnValue[0], "RQST_NO");
					var chkNod = ComGetEtcData(rtnValue[0], "CHK_NOD");
					var lseYdNm = ComGetEtcData(rtnValue[0], "LSE_YD_NM");
					ComSetObjValue(formObj.rqst_no, rqstNo);
					if(sav != "S" ){
						return;
					}
		
					if(ComXmlString(rtnValue[0], "delt_flg") == null || ComXmlString(rtnValue[0], "delt_flg") == ""){
						//if(v_delt_jflg == ""){
						formObj.reset();
						formObj.creflag.value="Y";
						formObj.zn_cd.value=zn_cd;
						formObj.dist_ut_cd.text="";
						formObj.ibflag.value="I";
						if(ComIsBtnEnable("btn_Create")) {
							if(ComShowConfirm(ComGetMsg("CCD00034", "Zone Code"))) {
								if(chkNod != "") {
									ComShowCodeMessage("CCD00069");
									ComResetAll();
									return;
								} else if(lseYdNm != "") {
									ComShowCodeMessage("CCD00071");
									ComResetAll();
									return;
								}
								
								formObj.creflag.value="Y";
								formObj.ibflag.value="I";
								ComBtnDisable("btn_Create");
								ComBtnDisable("btn_Retrieve");
								ComBtnEnable("btn_Save");
								ComEnableObject(formObj.btns_search2, false);
							} else {
								doActionIBSheet(sheetObj, formObj, IBCLEAR);
							}
						} else {
							if(chkNod != "") {
								ComShowCodeMessage("CCD00069");
								ComResetAll();
								return;
							} else if(lseYdNm != "") {
								ComShowCodeMessage("CCD00071");
								ComResetAll();
								return;
							}							
						} 
					} else {
						if(ComIsBtnEnable("btn_Create")) {
							formObj.creflag.value="N";
							formObj.zn_cd.value=ComXmlString(rtnValue[0], "zn_cd");
							formObj.zn_nm.value=ComXmlString(rtnValue[0], "zn_nm");
							formObj.cgo_hndl_tm_hrs.value=ComXmlString(rtnValue[0], "cgo_hndl_tm_hrs");
							formObj.tztm_hrs.value=ComXmlString(rtnValue[0], "tztm_hrs");
							formObj.rep_yd_cd.value=ComXmlString(rtnValue[0], "rep_yd_cd");
							formObj.lnk_dist.value=ComXmlString(rtnValue[0], "lnk_dist");                   
							formObj.delt_flg.value=ComXmlString(rtnValue[0], "delt_flg");
							formObj.dist_ut_cd.Code = ComXmlString(rtnValue[0], "dist_ut_cd");
							formObj.ibflag.value="U";
							formObj.zn_cd.readOnly=true;
							formObj.zn_cd.style.backgroundColor="#E8E7EC";
							sheetObj.LoadSearchXml(rtnValue[1]);
							formObj.tztm_hrs.value=ComAddComma2(formObj.tztm_hrs.value ,"#,###.00");
							formObj.lnk_dist.value=ComAddComma2(formObj.lnk_dist.value ,"#,###");
							formObj.cre_usr_id.value=ComXmlString(rtnValue[0], "cre_usr_id");
							formObj.cre_dt.value=ComXmlString(rtnValue[0], "cre_dt");
							formObj.upd_usr_id.value=ComXmlString(rtnValue[0], "upd_usr_id");
							formObj.upd_dt.value=ComXmlString(rtnValue[0], "upd_dt");
							formObj.rep_zn_flg.value = ComXmlString(rtnValue[0], "rep_zn_flg");
							ComBtnEnable("btn_Save");
							document.form.onchange_flag.value = "N";
						} else {
							ComShowCodeMessage("CCD00056");
							ComResetAll();
							return false;                     		
						}
					}
					ComBtnEnable("btn_RowAdd");
					ComBtnEnable("btn_RowDelete");
				}
				break;
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)){
					if(formObj.onchange_flag.value != "Y" && !sheetObj.IsDataModified) {
						ComShowCodeMessage("COM130503");
						return;
					}
					if( formObj.creflag.value == "Y" && formObj.rqst_no.value == ''){
						formObj.f_cmd.value=MULTI;
					}else{
						formObj.f_cmd.value=MULTI;
						ComEnableObject(formObj.btns_search2, false);
					}
					var sParam=FormQueryString(formObj);
					var tmpMsg="";
					if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
						tmpMsg="CCD00062";
					}else{
						tmpMsg="COM130101";
					}
					if(ComShowCodeConfirm(tmpMsg, "Data")){
						var sParam=FormQueryString(formObj);
						sParam += "&" + sheetObj.GetSaveString(false, true, prefix+"ibflag");
		
						var sXml=sheetObj.GetSaveXml("BCM_CCD_0021GS.do", sParam);
						var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
						if(result != "F"){
							if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
								ComShowCodeMessage("CCD00031");
							} else {
								ComShowCodeMessage("COM130102", "Data");
							}
						}else{
							ComShowCodeMessage("COM130103", "Data");
						}
						var rqstNo=ComGetEtcData(sXml, "RQST_NO");
						ComSetObjValue(formObj.rqst_no, rqstNo);
						ComBtnEnable("btn_Create");
						ComBtnEnable("btn_Retrieve");
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
				}
				break;
			case IBCREATE:
				doActionIBSheet(sheetObj, formObj, IBCLEAR);
				formObj.ibflag.value="I";
				formObj.creflag.value="Y";
				ComBtnDisable("btn_Create");
				ComBtnDisable("btn_Retrieve");
				ComBtnEnable("btn_Save");
				ComEnableObject(formObj.btns_search2, false);
				break;
			case SEARCH02:      //Rep.CY check
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH02;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSearchXml("BCM_CCD_0021GS.do", sParam);
					var result=ComGetEtcData(sXml, "result");
					if(result==""){
						ComShowCodeMessage("COM130402", "Rep.CY Code");
						formObj.rep_yd_cd.value="";
						ComSetFocus(formObj.rep_yd_cd);
					}
					ComOpenWait(false);
				}
				break;
			case SEARCH10: // MDM AUTH_TP_CD query
				var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=ZONE';
				/*          권한 인증 부분 주석 Start (2018.01.12)
		 			var sXml=sheetObj.GetSearchXml("BCM_CCD_2002GS.do", sParam);
		            // global var sestting
		            G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
		            G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
		   			권한 인증 부분 주석 End (2018.01.12)*/            
				/* 인증키 임시로 부여 Ha ds (S) */            
				G_MDAA_CHK = 'Y';
				G_AHTU_TP_CD = 'R';
				/* 인증키 임시로 부여 (E) */            
				break;
			case MULTI03:   // Request
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
			case IBCLEAR:
				clearAllData(sheetObj, formObj);
				ComEnableObject(formObj.btns_search2, true);
				formObj.zn_cd.style.backgroundColor="#CCFFFD";
				ComBtnEnable("btn_Create");	
				ComBtnEnable("btn_Retrieve");
				ComBtnDisable("btn_Save");
				break;
			case SEARCH08:		//Zone Code : Location Validation of the previous five-digit code
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH08;
				var sParam="f_cmd="+formObj.f_cmd.value+"&loc_cd="+formObj.zn_cd.value.substring(0,5);
				var sXml=sheetObj.GetSearchXml("BCM_CCD_0021GS.do", sParam);
				var result=ComGetEtcData(sXml, "result");
				ComOpenWait(false);
				return result;
				break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:      //retrieve
			if( formObj.rqst_no.value == ''){
				if(formObj.zn_cd.value == ""){
					ComShowCodeMessage("CCD00001", "Zone Code");
					ComSetFocus(formObj.zn_cd);
					return false;
				} else if(doActionIBSheet(sheetObj, formObj, SEARCH08)==""){
					ComShowCodeMessage("CCD00013", formObj.zn_cd.value.substring(0,5));
					formObj.zn_cd.value="";
					ComSetFocus(formObj.zn_cd);
					return false;
				}
			}
			break;
		case IBSAVE:        //save
			if(formObj.zn_cd.value == ""){
				ComShowCodeMessage("CCD00001", "Zone Code");
				ComSetFocus(formObj.zn_cd);
				return false;
			}else if(formObj.zn_cd.value.length != 7){
				ComShowCodeMessage("CCD00057", "Zone Code", "7");
				ComSetFocus(formObj.zn_cd);
				return false;
			}else if(formObj.zn_nm.value == ""){
				ComShowCodeMessage("CCD00001", "Zone Name");
				ComSetFocus(formObj.zn_nm);
				return false;
			}else if(formObj.cgo_hndl_tm_hrs.value == ""){
				ComShowCodeMessage("CCD00001", "Cargo Handling Time(Hours)");
				ComSetFocus(formObj.cgo_hndl_tm_hrs);
				return false;
			}else if(formObj.tztm_hrs.value == ""){
				ComShowCodeMessage("CCD00001", "Transit Time(Hours)");
				ComSetFocus(formObj.tztm_hrs);
				return false;
			}else if(formObj.rep_yd_cd.value == ""){
				ComShowCodeMessage("CCD00001", "Rep.CY");
				ComSetFocus(formObj.rep_yd_cd);
				return false;
			}else if(formObj.rep_zn_flg.value == "") {
				ComShowCodeMessage("CCD00001", "Rep.Zone");
				ComSetFocus(formObj.rep_zn_flg);
				return false;
			}
	
			// 중복 row check
			for (var i=1; i<=sheetObj.RowCount; i++) {
				var cd=sheetObj.CellValue(i,"sheet1_zip_cd");
				if (cd ==""){
					ComShowCodeMessage("CCD00001", "Postal Code");
					sheetObj.SelectCell(i,3);
					return false;
				}
				for (var j=1; j<=sheetObj.RowCount; j++) {
					var cdj=sheetObj.CellValue(j,"sheet1_zip_cd");
					if (j != i && cd == cdj) {
						ComShowCodeMessage("CCD00004", cd);
						sheetObj.SelectCell(i,3);
						return false;
					}
				}
			}   
			//remove comma
			delComma(document.form.tztm_hrs);
			delComma(document.form.lnk_dist);
			break;
	}
	return true;
}
function delComma(obj){
	if(!obj) return;
	obj.value=obj.value.replace(",","");
}
/**
 *If the data field to be the CHANGE Event
 */
function obj_change(){
	var formObject=document.form;
	/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "zn_cd":
				if(formObject.zn_cd.value.length>0){
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				}
				break;
			case "rep_yd_cd":
				if(formObject.rep_yd_cd.value.length>0){
					doActionIBSheet(sheetObject1, formObject, SEARCH02);
				}
				break;
			case "delt_flg" :
				if(formObject.delt_flg.value == "Y") {
					if(!ComShowCodeConfirm("COM130301", "data")) formObject.delt_flg.value="N";
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
/*
 * 
 */
function clearAllData(sheetObj, formObj){
	formObj.reset();
	formObj.rqst_no.value="";
	formObj.dist_ut_cd.text="";
	formObj.delt_flg.value="N";
	formObj.ibflag.value="I";
	formObj.zn_cd.readOnly=false;
	sheetObjects[0].RemoveAll();
	ComBtnDisable("btn_RowAdd");
	ComBtnDisable("btn_RowDelete");
}
function ydCodeHelp(rowArray) {
	var formObj=document.form;
	var colArray=rowArray[0];   
	formObj.rep_yd_cd.value=colArray[3];
	formObj_OnChange();
}
function znCodeHelp(rowArray) {
	var formObj=document.form;
	var colArray=rowArray[0];      
	if (colArray[3] != 'Node Code') {
		formObj.zn_cd.value=colArray[3];
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	/*        
        if(rowArray != "") {
        	formObj.zn_cd.value=colArray[3];
        } else {
        	formObj.zn_cd.value="Node Code";
        }    
        if(formObj.zn_cd.value.length>0){    	
        	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
	 */     
}
/**
 * sheet1 add row
 */
function addRow() {
	with (sheetObjects[0]) {
		var nowRow=SelectRow;
		var prefix="sheet1_";
		nowRow=DataInsert(-1);
		CellValue(nowRow, prefix+"delt_flg") = "N";
		CellValue(nowRow, prefix+"flg") = "Y";
		CellValue(nowRow, prefix+"zn_seq") =CellValue(nowRow, prefix+"seq");
		return true;
	}
}
/**
 * sheet1 delete row
 */
function deleteRow() {
	with (sheetObjects[0]) {
		var prefix="sheet1_";
		var sRowStr=FindCheckedRow(prefix+"del");
		var arr=sRowStr.split("|");
		var j=0;
		for (var i=0; i<arr.length-1; i++) {
			if (CellValue(arr[i]-j, prefix+"flg") == "Y") {
				RowDelete(arr[i]-j, false);
				j++;
			} else{
				RowStatus(arr[i]) = "D";
				RowHidden(arr[i]) = true;
			}
		}
	}         
}
//function getValueForCombo(obj) {
//if (Object.prototype.toString.call(obj) === '[object Array]') {
//var str = obj[0];
//return str.split('|')[0];
//}
//return obj;
//}         
function sheet1_OnSort(sheetObj ,Col, SortArrow){
	sheetObj.ReNumberSeq();   
}

function formObj_OnChange() {
	document.form.onchange_flag.value = "Y";
}

function dist_ut_cd_OnChange() {
	document.form.onchange_flag.value = "Y";
}
