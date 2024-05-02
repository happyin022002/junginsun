/*=========================================================
  **Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0965.js
*@FileTitle  :   ESM_BKG_0965
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG_0965 : business script for ESM_BKG_0965 
 */
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var nextSearchIdx=0; // for searching Filter (next index)
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn2_RowAdd":
			var row=sheetObject2.DataInsert(-1);
			//alert("row : " + row);
			sheetObject2.SetCellEditable(row, "bl_no",1);
			sheetObject2.SetCellEditable(row, "pol_cd",1);
			sheetObject2.SetCellEditable(row, "pod_cd",1);
			sheetObject2.SetCellEditable(row, "cntr_no",1);
			// setting search condition value to hidden variable 
			setSearchCond(sheetObject2, formObject);
			break;
		case "btn2_Delete":
			doActionIBSheet(sheetObject2, formObject, COMMAND02);
			break;
		case "btn1_BayPlan":	// Bay-Plan pop up button
			formObject.currMainPageListCnt.value=sheetObject2.RowCount();
			var retObj=openBayPlanPop(formObject, "2", false);
			if(retObj != undefined && retObj.length > 0 && sheetObject2.RowCount()> 0) {
				// Cell Position setting
				setCellPnsNoByCntrNo(sheetObject2,retObj);
			}
			break;
		case "btn_Retrieve":
			var visibleFlag=formObject.bay_plan_upload_check.disabled;
			var checkFlag=formObject.bay_plan_upload_check.checked;
			var bayPlnId="";
			// Bay-Plan Upload Required -> opening Bay_Plan Popup in case of checking
			if (!visibleFlag && checkFlag) {
				var rtnVal=openBayPlanPop(formObject, "1", true);				
				if (rtnVal != null) {
					formObject.bay_pln_id.value=rtnVal.cd;
				} else {
					formObject.bay_pln_id.value="";
					break;
				}
			}
			doActionIBSheet(sheetObject1, formObject, SEARCH02);
			break;
		case "btn1_Close_SCG": 
		case "btn1_Open_SCG": 
			doActionIBSheet(sheetObject1, formObject, MODIFY);
			break;
		case "btn1_Append_Retrieve":  // appending to grid with retrieved booking data
			doActionIBSheet(sheetObject1, formObject, SEARCH14);
			break;
		case "btn1_New":
			pageReset(formObject);
			// Declaration init
			initDeclarationType(formObject.init_d_type.value);
			break;
		case "btn1_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn1_EDITransmit":
			doActionIBSheet(sheetObject2, formObject, MULTI01);
			break;
		case "btn1_EDICancel":
			doActionIBSheet(sheetObject2, formObject, MULTI02);
			break;
		case "btn1_SentResult":
			openDetail(sheetObject2, sheetObject2.GetSelectRow());
			break;
		case "btn1_DownExcel":
			doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
			// sheetObject2.SpeedDown2Excel(-1);
			break;
		case "btn1_Filter" :	// BL_NO, CNTR_NO FILTER
			doActionIBSheet(sheetObject2, formObject, COMMAND01);
			break;
		case "btn1_Filter2" :	// BL_NO, CNTR_NO FILTER
			doActionIBSheet(sheetObject2, formObject, COMMAND03);
			break;
		case "d_type1": // when selecting Declration (Discharging)
		case "d_type2": // when selecting Declration (Trasit)
		case "d_type3": // when selecting Declration (Loading)
		case "d_type4": // when selecting Declration (Pre-Carriage)
		case "d_type5": // when selecting Declration (On-Carriage)
			var dTypeVal=declarationCheckValue();  // getting value of selected check box
			dTypeCheckValidate(dTypeVal,srcName);	// validation
			if(formObject.d_type.value != "" && formObject.vvd_cd.value != "" && formObject.port_cd != "") {
				doActionIBSheet(sheetObject1, formObject, SEARCH06); // DG List Copy (activating/deactivating check box according to data)
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01); //Bay-Plan Upload Required (activating/deactivating check box according to data)
			}
			// barge CheckBox (activating/deactivating check box according to data) 
			if(formObject.d_type.value != "P" && formObject.d_type.value != "O") {
				formObject.barge_check.disabled=true;
				formObject.barge_check.checked=false;
				formObject.barge_flag.value="N";
			} else {
				formObject.barge_check.disabled=false;
			}
			break;
		case "filter_bl_no" : 
			visibleFalse("1");
			break;
		case "filter_cntr_no" : 
			visibleFalse("2");
			break;
			
		case "btn2_history":
			var dType=declarationCheckValue();
			var vvdCd=formObject.vvd_cd.value;
			var portCd=formObject.port_cd.value;
			var blNo="";
			var cntrNo="";
			var polCd="";
			var podCd="";
			var row=sheetObjects[1].GetSelectRow();
			if(row > 0){
				blNo=sheetObjects[1].GetCellValue(row, "bl_no");
				cntrNo=sheetObjects[1].GetCellValue(row, "cntr_no");
				polCd=sheetObjects[1].GetCellValue(row, "pol_cd");
				podCd=sheetObjects[1].GetCellValue(row, "pod_cd");
			}
			
			var url= "ESM_BKG_1605.do?pgmNo=ESM_BKG_1605"
					+"&dType="+dType
					+"&vvdCd="+vvdCd
					+"&portCd="+portCd
					+"&blNo="+blNo
					+"&cntrNo="+cntrNo
					+"&polCd="+polCd
					+"&podCd="+podCd
					+"&originPgm=ESM_BKG_0965";
			ComOpenWindowCenter(url, "ESM_BKG_1605", 1120, 600, true);
			break;			
			
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * setting Cell Position of each container with values from Bay-Plan Detail Popup
 * @param sheetObj
 * @param arrObj
 * @return
 */
function setCellPnsNoByCntrNo(sheetObj, arrObj) {
	var mainCntrNo="";
	var sheetLength=sheetObj.RowCount();
	var arrObjLength=arrObj.length;
	var arrSubObj=null;
	var changeCnt=0;
	ComOpenWait(true);
	for(var i=1; i <= sheetLength; i++) {
		mainCntrNo=sheetObj.GetCellValue(i, "cntr_no");
		for(var j=0; j < arrObjLength; j++) {
			arrSubObj=arrObj[j].split("|");
			if(mainCntrNo == arrSubObj[0]) {
				sheetObj.SetCellValue(i, "cell_psn_no",arrSubObj[1],0);
				sheetObj.SetCellBackColor(i, "cell_psn_no","#000000");
				changeCnt++;
			} else {
				continue;
			}
		} // end for(j)
	} // end for(i)
	ComOpenWait(false);
	ComShowMessage("[" + changeCnt + "] Changed");
}
/**
 * initializing page
 * @param formObject
 * @return
 */
function pageReset(formObject) {
	ComResetAll();
	formObject.ack_rcv_sts_cd_name.style.backgroundColor="white";
}
/**
 * filter condition visible
 * @param searchType ("1" : activating B/L No., "2" : activating Container No. )
 * @return
 */
function visibleFalse(searchType) {
	var formObject=document.form;
	if(searchType == "1") {
		formObject.filter_bl_no.readOnly=false;
		formObject.filter_cntr_no.readOnly=true;
		formObject.filter_cntr_no.value="";
//		formObject.filter_cgo_opr.readOnly=true;
//		formObject.filter_cgo_opr.value="";
	} else if(searchType == "2") {
		formObject.filter_cntr_no.readOnly=false;
		formObject.filter_bl_no.readOnly=true;
		formObject.filter_bl_no.value="";
//		formObject.filter_cgo_opr.readOnly=true;
//		formObject.filter_cgo_opr.value="";
//	} else {
//		formObject.filter_cgo_opr.readOnly=false;
//		formObject.filter_bl_no.readOnly=true;
//		formObject.filter_bl_no.value="";
//		formObject.filter_cntr_no.readOnly=true;
//		formObject.filter_cntr_no.value="";
	}
}
/**
 * returning selected declaration field value
 * 
 * @return
 */
function declarationCheckValue() {
	var formObj=document.form;
	var retVal="";
	for ( var i=1; i <= 5; i++) {
		var dTypeFlag = "formObj.d_type" + i + ".checked";		
		var dTypeValue = "formObj.d_type" + i + ".value";
		if (eval(dTypeFlag)) {
			retVal += eval(dTypeValue);
		}
	} // end for(i)
	return retVal;
}
/**
 * setting Agent or Agent Forwarder Combo
 * 
 * @return
 */
function settingAgent(dTypeVal) {
	var formObj=document.form;
	//alert(dTypeVal);
	switch (dTypeVal) {	// setting Agent or Agent Forwarder Combo
		case "LP": // Loading + On-carriage
		case "P": // Pre-carriage
		case "O": // On-Carriage
			anr_role_div_cd.SetSelectCode("DF");// Forward
			break;
		case "DO": // Discharging + Pre-carriage
			anr_role_div_cd.SetSelectCode("BO");// Forward
			break;
		default:
			anr_role_div_cd.SetSelectCode("DA");// Agent
			break;
	} // end switch
}
/**
 * checking Validation of Declaration 
 * @return
 */
function dTypeCheckValidate(dTypeVal, srcName) {
	var formObj=document.form;
	//alert("srcName : " + srcName + "\ndTypeVal : " + dTypeVal);
	switch (srcName) {
		case "d_type1" :	// Discharging 
			switch (dTypeVal) {
				case "DT" :
				case "DL" :
				case "DP" :
				case "DLP" :
					formObj.d_type1.checked=false;
			}
			break;
		case "d_type2" : 	// Transit
			switch (dTypeVal) {
				case "DT" :
				case "TL" :
				case "TP" :
				case "TO" :
				case "TLP" :
				case "DTO" :
					formObj.d_type2.checked=false;
			}
			break;
		case "d_type3" : 	// Loading
			switch (dTypeVal) {
				case "DL" :
				case "TL" :
				case "LO" :
				case "DLO" :
					formObj.d_type3.checked=false;
			}
			break;
		case "d_type4" : 	// Pre-Carriage
			switch (dTypeVal) {
				case "DP" :
				case "TP" :
				case "PO" :
				case "DPO" :
					formObj.d_type4.checked=false;
			}
			break;
		case "d_type5" : 	// On-Carriage
			switch (dTypeVal) {
				case "TO" :
				case "LO" :
				case "PO" :
				case "LPO" :
					formObj.d_type5.checked=false;
			}
			break;
		default : 
			formObj.d_type1.checked=false;
			break;
	} // end switch
	var newType=declarationCheckValue();
	formObj.d_type.value=(newType == "LP") ? "PL" : newType;
	var viewText=new Array();
	viewText[0]="Vessel Name"; 
	viewText[1]="Barge Name"; 
	if(formObj.d_type.value == "P" || formObj.d_type.value == "O") {
		layoutView.innerText=viewText[1];
	} else {
		layoutView.innerText=viewText[0];
	}
	setCrrDtHeader(formObj.d_type.value);
	settingAgent(newType);
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
  * registering IBCombo Object as list
  * adding process for list in case of needing batch processing with other items
  * defining list on the top of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
 */
function loadPage(dType) {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	// Declaraion Init
	initDeclarationType(dType);
	var comboObjMaxLen=comboObjects.length;
	for (i=0; i < comboObjMaxLen; i++) {
		// initializing IBCombo 
		initCombo(comboObjects[i], i + 1);
	}
	// setting Agent or Agent Forwarder Combo
	settingAgent();
	ComSetDisplay("btn1_Close_SCG", true);	
	ComSetDisplay("btn1_Open_SCG", false);	
	ComBtnDisable("btn1_EDITransmit");
	ComBtnDisable("btn1_EDICancel");
	ComBtnDisable("btn1_Append_Retrieve");
	ComBtnDisable("btn1_Close_SCG");
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	axon_event.addListenerForm('click', 'obj_click', document.form); // click
	
	doActionIBSheet(sheetObjects[0], formObj, COMMAND11);

}
/**
 *  initializing Declaration field
 * @return
 */
function initDeclarationType(dType) {
	var formObj=document.form;
	if (dType == "D") {
		formObj.d_type1.checked=true;
		formObj.d_type.value="D"; 
	} else if (dType == "T") {
		formObj.d_type2.checked=true;
		formObj.d_type.value="T"; 
	} else if (dType == "L") {
		formObj.d_type3.checked=true;
		formObj.d_type.value="L"; 
	} else if (dType == "P") {
		formObj.d_type4.checked=true;
		formObj.d_type.value="P"; 
	} else if (dType == "O") {
		formObj.d_type5.checked=true;
		formObj.d_type.value="O"; 
	} else {
		formObj.d_type1.checked=true;
		formObj.d_type.value="D"; 
	}
	setCrrDtHeader(formObj.d_type.value);
}
/**
 * changing sheet header(Carriage Date) title
 * @param dType
 */
function setCrrDtHeader(dType) {
	if(dType == "PL" || dType == "P") {
		sheetObjects[1].SetCellValue(0, "crr_dt","Pre-Carriage Date",0);
	} else {
		sheetObjects[1].SetCellValue(0, "crr_dt","On-Carriage Date",0);
	}
}

/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // master information
	    with(sheetObj){
		        
		      if (location.hostname != "")
		      var HeadTitle1="|d_type|vvd_cd|port_cd|eta_d|eta_t|etd_d|etd_t|yd_cd|loc_nm|auto_snd_tp_cd|vsl_cd|vsl_nm|vsl_cnt_cd|lloyd_no|call_sgn_no" +
		      "|anr_role_div_cd|ssr_no|ack_rslt_id|local_db_yn";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"d_type",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eta_d",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eta_t",            KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"etd_d",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"etd_t",            KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"brth_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"yd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"auto_snd_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lloyd_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"call_sgn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"anr_role_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"svc_rqst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ack_rcv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"local_db_yn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"spcl_cgo_prnr_clz_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);		
		      SetEditable(1);		      
		      InitViewFormat(0, "eta_d", "yyyymmdd");
		      InitViewFormat(0, "eta_t", "hhmm");
		      InitViewFormat(0, "etd_d", "yyyymmdd");
		      InitViewFormat(0, "etd_t", "hhmm");
		      SetSheetHeight(100);
	      }
		break;
	case "sheet2":
	    with(sheetObj){
		        
		      if (location.hostname != "")
		      var HeadTitle1="|merge_bl_no|Sel.|Seq.|Setup\nFlag|Cargo\nOper.|bkg_no|B/L No.|POL|POD|Container No.|TP/SZ|DG\nInquiry|Cell Position|Class|Compati\n-bility|UN No.|S.D/G|Flash\nPoint|Package\nGroup|Forwarder\nCode|Carriage\nType|On-Carriage Date|SSR\n(Feeder)|Vessel Name\n(Feeder)|Lloyd No\n(Feeder)|VVD\n(Feeder)"
		      +"|Outer\nQty|Outer\nCode|EMS|Net Weight|Gross Weight|Net Exp Weight|Packages|Substance|Technical Name|cntr_cgo_seq|in_imdg_pck_qty1|in_imdg_pck_cd1|in_pck_desc|out_pck_desc|Send Type|Send Type\nto Original"
		      +"|Msg Snd No|First Msg Snd No|Scr File No|group_cnt|DG_SHORT_NM_CNT|CNTR_CNT|IMDG_UN_NO_SEQ|Container No.";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      
//		      SetConfig( { SearchMode:2, FrozenCol:11, MergeSheet:7, Page:20,DataRowMerge:0} );
		      SetConfig( { SearchMode:2, FrozenCol:11, MergeSheet:7, Page:20,DataRowMerge:0, PrevColumnMergeMode:0} );
		
		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"merge_bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"check" },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stup_flg",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cgo_opr_cd",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, 	EditLen:3, 	AcceptKeys:"E", 	InputCaseSensitive:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12, AcceptKeys:"E|N" , InputCaseSensitive:1  },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12, AcceptKeys:"E|N" , InputCaseSensitive:1  },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5, AcceptKeys:"E" , InputCaseSensitive:1  },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5, AcceptKeys:"E" , InputCaseSensitive:1  },
//		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14, AcceptKeys:"E|N" , InputCaseSensitive:1  },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14, AcceptKeys:"E|N" , InputCaseSensitive:1  },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, 	AcceptKeys:"E|N", 	InputCaseSensitive:1 },
		             {Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dg",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cell_psn_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7, AcceptKeys:"E|N" , InputCaseSensitive:1  },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"N" , InputCaseSensitive:1  },
		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dg_short_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_cdo_temp",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 ,   AcceptKeys:"N" , InputCaseSensitive:1},
		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fwrd_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 , AcceptKeys:"E|N" , InputCaseSensitive:1 },
		             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"c_type",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"crr_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"fdr_svc_rqst_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14, AcceptKeys:"N" , InputCaseSensitive:1  },
		             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fdr_vsl_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fdr_vsl_lloyd_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fdr_vvd_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"out_imdg_pck_qty1",      KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"out_imdg_pck_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ems_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"net_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",                KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"net_explo_wgt",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"packages",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prp_shp_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:130,   Align:"Left",    ColMerge:0,   SaveName:"hzd_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntr_cgo_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"in_imdg_pck_qty1",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"in_imdg_pck_cd1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"in_pck_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"out_pck_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"send_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"DummyCheck", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"send_type_check_orgin" },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"msg_snd_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"first_msg_snd_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"scr_file_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"group_cnt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dg_short_nm_cnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_cnt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no_old",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(1);
		      SetWaitImageVisible(0);		      
		      SetEllipsis(1);
		      SetColProperty("c_type", {ComboText:"|TBN|ROAD|RAIL|BARGE|MARINTIME", ComboCode:"|X|T|R|B|V"} );
		      SetColProperty("dg_short_nm", {ComboText:"|AMN|SPR|ZTG", ComboCode:"|AMN|SPR|ZTG"} );
		      SetColProperty("imdg_pck_grp_cd", {ComboText:"|I|II|III|N", ComboCode:"|1|2|3|N"} );
		      SetShowButtonImage(1);
		      FrozenCols=9;
		      SetSelectionMode(smSelectionList);
		      SetSheetHeight(300);
		      SetCountPosition(0);
      }
		break;
	}
}
/**
 * initializing Combo Object
 * 
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comNo) {
	// alert("comboObj ID : " + comboObj.id);
	var i=0;
	switch (comboObj.options.id) {
		
//		case "anr_role_div_cd": {
//			ComBkgTextCode2ComboItem(anr_role_div_cd_Code,anr_role_div_cd_Text, comboObj);
//			comboObj.SetSelectIndex(0);//
//			break;
//		}
//		case "reason_resending": {
//			ComBkgTextCode2ComboItem(reason_resending_Code,reason_resending_Text, comboObj);
//			break;
//		}
		
		case "anr_role_div_cd": {
			i = 0;

			with (comboObj) {
				InsertItem(i++, "Agent", "DA");
				InsertItem(i++, "Agent and Forwarder", "BO");
				InsertItem(i++, "Forwarder", "DF");
				Code = "0";
			}
			break;
		}

		case "reason_resending": {
			i = 0;

			with (comboObj) {
				InsertItem(i++, "", "");
				InsertItem(i++, "Mistake in previous notification", "CAM");
				InsertItem(i++, "Operation not carried out", "CAO");
				InsertItem(i++, "Change of dates of stay of truck/train/barge in the port", "CHD");
				InsertItem(i++, "Change of means of transport", "CHM");
				InsertItem(i++, "Change of name of vessel", "CHV");
				InsertItem(i++, "Specify TBN-container", "TBC");
				InsertItem(i++, "Specify TBN-forwarder", "TBF");
				InsertItem(i++, "Specify TBN-vessel/barge name", "TBN");

				Code = "";
			}
			break;
		}
//		case "port_cd":{
//
//			with (comboObj) {
//				BackColor = "#CCFFFD";
//				Style = 1;//0 -편집 가능,1 -편집 불가능
//			}
//			break;
//		}		
	} // end switch
}
/**
 * handling process for Sheet
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction, row, col) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case COMMAND02 :
			if (!validateForm(sheetObj, formObj, sAction))	return;
			if(ComShowCodeConfirm('BKG03037')){
				var sRowStr=sheetObj.GetSelectionRows("/");
				var arrSelectionRows=sRowStr.split("/");
				var maxLength=arrSelectionRows.length;
//				for (var i=0; i<maxLength; i++) {
				for (i=maxLength-1; 0<=i; i--) { //If status "I" is deleted, index changes. So start deletion from largest index.
					sheetObj.SetRowHidden(arrSelectionRows[i],1);// hiding selected row
					//sheetObj.cellValue2(arrSelectionRows[i], "ibflag") = "D"; // 
					sheetObj.SetRowStatus(arrSelectionRows[i],"D");// setting delete flag('D') at selected row
				}
			}
			break;
		case SEARCH01: // Bay-Plan Upload Required 
			if (!validateForm(sheetObj, formObj, sAction))	return;
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var crntCellPsnNoYn=ComGetEtcData(sXml, "crntCellPsnNoYn");
			if (crntCellPsnNoYn == "N") {
				// activating bay_plan_upload_check field
				formObj.bay_plan_upload_check.disabled=false;
			} else {
				// deactivating bay_plan_upload_check field
				formObj.bay_plan_upload_check.disabled=true; 
			}
			break;
		case SEARCH02: // retrieve
			if(!validateForm(sheetObj,formObj,sAction))return;
			formObj.f_cmd.value=SEARCH02;
			if(!formObj.dg_list_copy_check.disabled) {
				if(formObj.dg_list_copy_check.checked) {
					formObj.dg_list_copy_flag.value='Y';
				} else {
					formObj.dg_list_copy_flag.value='N';
				}				
			} else {
				formObj.dg_list_copy_flag.value='N';
			}
			if(!formObj.barge_check.disabled) {
				if(formObj.barge_check.checked) {
					formObj.barge_flag.value='Y';
				} else {
					formObj.barge_flag.value='N';
				}
			} else {
				formObj.barge_flag.value='N';
			}
			ComOpenWait(true);
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var arrXml=sXml.split("|$$|");
			formObj.cntr_cnt.value=""; // initializing Total Container field
			formObj.dg_list_local_yn.value=ComGetEtcData(arrXml[0], "dgListLocalYn");
			var sentStatus=ComGetEtcData(arrXml[0], "ediSentStatus");
			if (ComBkgErrMessage(sheetObj, sXml)) {
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
				if(formObj.dg_list_local_yn.value == "N") { // when retrieving Booking data 
					// 
					sheetObjects[1].SetColBackColor("dg","#C0C0C0");
					if(sheetObjects[1].RowCount()> 0 && sheetObjects[1].GetCellValue(1,"dg_short_nm_cnt") != "0") {
						// Attention: this VVD contains SPECIAL DG (ZTG/AMN/SPR)
						ComShowCodeMessage('BKG06117'); 
					}
				} else { // when retrieving customs data 
				}
				if (sheetObjects[1].RowCount()> 0) {
					// setting Total Count of container
					formObj.cntr_cnt.value=sheetObjects[1].GetCellValue(1,"cntr_cnt");
				}
			}
			IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_");
			if (sheetObjects[0].RowCount()== 1) {
				formObj.frm_eta_d.value=ComGetMaskedValue(
						formObj.frm_eta_d.value, "ymd");
				formObj.frm_eta_t.value=ComGetMaskedValue(
						formObj.frm_eta_t.value, "hm");
				formObj.frm_etd_d.value=ComGetMaskedValue(
						formObj.frm_etd_d.value, "ymd");
				formObj.frm_etd_t.value=ComGetMaskedValue(
						formObj.frm_etd_t.value, "hm");
			}
			setSentStatusFiledColor(sheetObjects[1], sentStatus); // changing color of Sent Status field
			formObj.bay_pln_id.value="";
			sheetObjects[1].CheckAll("check",0,1);
			if(formObj.dg_list_local_yn.value == "N") { 
				// deactivating  EDI Transmit, EDI  Cancel button in case of retrieving Booking data
				ComBtnDisable("btn1_EDITransmit");
				ComBtnDisable("btn1_EDICancel");
				ComBtnDisable("btn1_Append_Retrieve");
				ComBtnDisable("btn1_Close_SCG");
			} else {
				// activating  EDI Transmit, EDI  Cancel button in case of retrieving Local data
				ComBtnEnable("btn1_EDITransmit");
				ComBtnEnable("btn1_EDICancel");
				ComBtnEnable("btn1_Append_Retrieve");
				if (formObj.frm_spcl_cgo_prnr_clz_flg.value == "N") {
					ComSetDisplay("btn1_Close_SCG", true);	
					ComSetDisplay("btn1_Open_SCG", false);	
					ComBtnEnable("btn1_Close_SCG");
				}else{
					ComSetDisplay("btn1_Close_SCG", false);	
					ComSetDisplay("btn1_Open_SCG", true);	
					ComBtnEnable("btn1_Open_SCG");
				}
			}
			// setting hidden value with search condition value
			setSearchCond(sheetObjects[1], formObj);
			break;
		case SEARCH03 : // searching Vessel Name with Vessel Code.
			//if (!validateForm(sheetObj, formObj, sAction))	return;
			formObj.f_cmd.value=SEARCH03;
			ComOpenWait(true);
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var vesselName=ComGetEtcData(sXml, "vesselName");
			//alert("vesselName : " + vesselName );
			formObj.frm_vsl_eng_nm.value=(vesselName == undefined) ? "" : vesselName;
			break;
		case SEARCH04 : // searching Name with Berth Code
			//if (!validateForm(sheetObj, formObj, sAction))	return;
			formObj.f_cmd.value=SEARCH04;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var yardName=ComGetEtcData(sXml, "yardName");
			//alert("yardName : " + yardName );
			formObj.frm_yd_nm.value=(yardName == undefined) ? "" : yardName;
			break;
		case SEARCH05: // checking if there are data at DB table of Local Danger with vvd, port
			if (!validateForm(sheetObj, formObj, sAction))	return;
			formObj.f_cmd.value=SEARCH05;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var retVal=ComGetEtcData(sXml, "retVal");
			 //alert("retVal : " +retVal);
			formObj.bay_plan_upload_check.checked=false;
			if (retVal == "Y") {
				formObj.bay_plan_upload_check.disabled=true; // activating bay_plan_upload_check field
			} else {
				formObj.bay_plan_upload_check.disabled=false; // deactivating bay_plan_upload_check field
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			}
			break;
		case SEARCH06 : // activating/deactivating copy checkbox in case of checking Declaration
			formObj.f_cmd.value=SEARCH06;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var dgListCopyYn=ComGetEtcData(sXml, "dgListCopyYn");
			//alert("dgListCopyYn : " + dgListCopyYn + "\nformObj.dg_list_copy_check.checked : " + formObj.dg_list_copy_check.checked);
			formObj.dg_list_copy_check.checked=false;
			if(dgListCopyYn == "Y") {
				formObj.dg_list_copy_check.disabled=false;
			} else {
				formObj.dg_list_copy_check.disabled=true;
			}
			break;
		case IBSAVE: // 
			if(!validateForm(sheetObj,formObj,sAction))return;
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			var vslInfoLocalYn=sheetObjects[0].GetCellValue(1, "local_db_yn");
			var dgListLocalYn=formObj.dg_list_local_yn.value;
			var shee2RowSize=sheetObjects[1].RowCount();
			//alert("vslInfoLocalYn : " + vslInfoLocalYn + "\ndgListLocalYn : " + dgListLocalYn);
			if (vslInfoLocalYn == "N") {
				//sheetObjects[0].CellValue2(1, "ibflag") = "I";
				sheetObjects[0].SetRowStatus(1,"I");
			}
			if (dgListLocalYn == "N") {
				for ( var i=1; i <= shee2RowSize; i++) {
					//if(sheetObjects[1].CellValue(i, "ibflag") == "D") continue;
					if(sheetObjects[1].GetRowStatus(i) == "D") continue;
					//sheetObjects[1].CellValue2(i, "ibflag") = "I";
					sheetObjects[1].SetRowStatus(i,"I");
				} // end for(i)
			}
			formObj.f_cmd.value=MULTI;
			var sParam="";
			var sParamSheet1=sheetObjects[0].GetSaveString();
			if (sParamSheet1 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
			}
			//alert("sParamSheet1 : " + sParamSheet1);
			var sParamSheet2=sheetObjects[1].GetSaveString();
			//alert("sParamSheet2 : " + sParamSheet2);
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
			} else {
				if(vslInfoLocalYn != "Y" && dgListLocalYn != "Y") {
					return false;
				}
			}
			if (sParam == "") {
				ComShowCodeMessage('BKG00260');
				return;
			}
			sParam += "&" + FormQueryString(formObj);
			//alert(sParam);
            if(!ComShowCodeConfirm("BKG00350")) {
            	return false;
            }
			ComOpenWait(true);
			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0965GS.do", sParam);
			ComOpenWait(false);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	        if(State != "S"){
	            ComShowMessage(ComResultMessage(sXml));
	        }else if(State == "S"){
	            ComShowCodeMessage('BKG00166');
	            doActionIBSheet(sheetObj, formObj, SEARCH02);        
	        }
			break;
		case MODIFY:  
			if(!validateForm(sheetObj,formObj,sAction))return;
			formObj.f_cmd.value=MODIFY;			
			if(!formObj.dg_list_copy_check.disabled) {
				if(formObj.dg_list_copy_check.checked) {
					formObj.dg_list_copy_flag.value='Y';
				} else {
					formObj.dg_list_copy_flag.value='N';
				}				
			} else {
				formObj.dg_list_copy_flag.value='N';
			}
			if(!formObj.barge_check.disabled) {
				if(formObj.barge_check.checked) {
					formObj.barge_flag.value='Y';
				} else {
					formObj.barge_flag.value='N';
				}
			} else {
				formObj.barge_flag.value='N';
			}
			if (formObj.frm_spcl_cgo_prnr_clz_flg.value == "N") {
				formObj.frm_spcl_cgo_prnr_clz_flg.value = "Y";
			}else{
				formObj.frm_spcl_cgo_prnr_clz_flg.value = "N";			
			}
			ComOpenWait(true);
			var sXml= sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	        if(State != "S"){
	            ComShowMessage(ComResultMessage(sXml));
	        }else if(State == "S"){
	            ComShowCodeMessage('BKG00166');
	            doActionIBSheet(sheetObj, formObj, SEARCH02);        
	        }
			break;					
		case IBDOWNEXCEL: // 
			if(!validateForm(sheetObj,formObj,sAction))return;
			ComOpenWait(true);
			sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
			ComOpenWait(false);
			break;
		case COMMAND01 : // BL_NO, CNTR_NO Filter
			if(!validateForm(sheetObj,formObj,sAction))return;
			var searchText="";
			var idx=-1;
			var currRowIdx=0;
			if(nextSearchIdx == 0) {
				currRowIdx=sheetObjects[1].GetSelectRow();
			} else {
				currRowIdx=nextSearchIdx;
			}
			//alert("currRowIdx : " + currRowIdx);
			if(!formObj.filter_bl_no.readOnly) {
				searchText=formObj.filter_bl_no.value;			
				idx=sheetObjects[1].FindText("bl_no", searchText, currRowIdx, 2, false);
			} else {
				searchText=formObj.filter_cntr_no.value;			
				idx=sheetObjects[1].FindText("cntr_no", searchText, currRowIdx, 2, false);
			}
			if(idx == -1) {
				//ComShowMessage("No Search [" + searchText + "]");
				ComShowCodeMessage(ComGetMsg("BKG06101", searchText));
				nextSearchIdx=0;
			} else {
				if(!formObj.filter_bl_no.readOnly) {
					sheetObjects[1].SelectCell(idx, "bl_no", false);
				} else {
					sheetObjects[1].SelectCell(idx, "cntr_no", false);
				}
//no support[implemented common]CLT 				sheetObjects[1].SelectFontBold=true;
//no support[implemented common]CLT 				sheetObjects[1].SelectBackColor="#FFFFC0";
				nextSearchIdx=idx + 1;
			}
			break;
		case COMMAND03 : // Cgo Opr Filter
			if(!validateForm(sheetObj,formObj,sAction))return;
	        var sheetObj=sheetObjects[0];
	        var formObj=document.form;
	        var cgoOprCd = formObj.filter_cgo_opr.value;
			sheetObjects[1].CheckAll("check",0,1);
	        for (var i=sheetObjects[1].HeaderRows();i<=sheetObjects[1].LastRow();i++){
	        	if (cgoOprCd == "") {
	        		sheetObjects[1].SetRowHidden(i, 0);
	        	}else if (cgoOprCd == sheetObjects[1].GetCellValue(i, "cgo_opr_cd")) {
	        		sheetObjects[1].SetRowHidden(i, 0);
	        	}else{
	        		sheetObjects[1].SetRowHidden(i, 1);
	        	}
	        }  

			break;
		case MULTI01: // creating Flat File and transmitting EDI
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			if(sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true) {
				ComShowCodeMessage('BKG06098');
				return;
			}
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value=MULTI01;
			formObj.trans_type.value="ORIGIN_SEND";
			if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
            	// initializing as status of retrieving send type
            	initSearchValue(sheetObjects[1], "send_type", "AC");
            	sheetObjects[1].CheckAll("check",0,1);
				return false;
            }
			var rowCnt=sheetObjects[1].RowCount();
			for(var i=1; i<=rowCnt; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
					if (sheetObjects[1].GetCellValue(i, "stup_flg") == "V" || (sheetObjects[1].GetCellValue(i, "stup_flg") == "C" && sheetObjects[1].GetCellValue(i, "cgo_opr_cd") == "NYK")) {
						sheetObjects[1].SetRowStatus(i,"I");
						/*
						 * Send Type to Oringinal 체크시 Send Type 을 최초 전송 상태로 변경 한다.(double calling 문제로 추가)
						 */
						if(sheetObj.GetCellValue(i, "send_type_check_orgin") == 1) {
							sheetObj.SetCellValue(i, "send_type","",0);
						}
					}					
				} else {
					sheetObjects[1].SetRowStatus(i,"");
				}
			} // end for(i)
			var sParam="";
			var sParamSheet=sheetObjects[1].GetSaveString();
			if (sParamSheet != "") {
				sParam += "&" + sParamSheet;
			}
			sParam += "&" + FormQueryString(formObj);
			ComOpenWait(true);
			var sXml=sheetObjects[1].GetSaveData("ESM_BKG_0965GS.do", sParam);
			sheetObjects[1].LoadSaveData(sXml);
			ComOpenWait(false);
			break;
		case MULTI02: // creating Flat File and transmitting EDI(CANCEL transmit)
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			if(sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true) {
				ComShowCodeMessage('BKG06098');
				return;
			}
			if(!validateForm(sheetObj,formObj,sAction))return;
			formObj.f_cmd.value=MULTI01;
			formObj.trans_type.value="CANCEL_SEND";
   			if(!ComShowConfirm(ComGetMsg("BKG95003", "[EDI Cancel Transmit]"))) {
            	return false;
            }
			var sParam="";
            var rowCnt=sheetObjects[1].RowCount();
			for(var i=1; i<=rowCnt; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
					if (sheetObjects[1].GetCellValue(i, "stup_flg") == "V" || (sheetObjects[1].GetCellValue(i, "stup_flg") == "C" && sheetObjects[1].GetCellValue(i, "cgo_opr_cd") == "NYK")) {					
						//sheetObjects[1].CellValue2(i,"ibflag") = "I";
						sheetObjects[1].SetRowStatus(i,"I");
					}
				} else {
					//sheetObjects[1].CellValue2(i,"ibflag") = "";
					sheetObjects[1].SetRowStatus(i,"");
				}
			}
			var sParamSheet=sheetObjects[1].GetSaveString();
			if (sParamSheet != "") {
				//sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
				sParam += "&" + sParamSheet;
			}
			if (sParam == "") {
				ComShowCodeMessage('BKG00743');
				return;
			}
			sParam += "&" + FormQueryString(formObj);
			//alert(sParam);
			ComOpenWait(true);
			var sXml=sheetObjects[1].GetSaveData("ESM_BKG_0965GS.do", sParam);
			sheetObjects[1].LoadSaveData(sXml);
			ComOpenWait(false);
			break;
		case SEARCH11 : //  input validation (bl_no / pol_cd / pod_cd)
			formObj.f_cmd.value=SEARCH11;
			ComOpenWait(true);
			var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var retVal=ComGetEtcData(sXml, "retVal");
			var cond_type=formObj.cond_type.value;
			//alert("retVal : " + retVal );
			if(retVal == "0") { // not existing 
				if(cond_type == "bl_no") {
					ComShowCodeMessage('BKG06012', "[B/L No.]");
				} else if(cond_type == "pol_cd") {
					ComShowCodeMessage('BKG06012', "[POL]");
				} else if(cond_type == "pod_cd") {
					ComShowCodeMessage('BKG06012', "[POD]");
				}
				sheetObjects[1].SetCellValue(row, col,"",0);
				sheetObjects[1].SelectCell(row, col);
			} else {
				if(cond_type == "bl_no") {
					var runFlag=true;
					for(var i=1; i < row; i++) {
						if(formObj.cond_value.value == sheetObjects[1].GetCellValue(i, "bl_no")) {
							runFlag=false;
							break;
						}
					}
					if(runFlag) {
						doActionIBSheet(sheetObjects[1],formObj,SEARCH13, row, col); // input validation
					} else {
//						ComShowCodeMessage('BKG06099');
//						sheetObjects[1].CellValue2(row, "bl_no") = "";
//						return false;
					}
				}
			}
			break;
		case SEARCH12 : //  input validation (cntr_no)
			formObj.f_cmd.value=SEARCH12;
			ComOpenWait(true);
			var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			var retVal=ComGetEtcData(sXml, "retVal");
			var cond_type=formObj.cond_type.value;
			//alert("retVal : " + retVal );
			if(retVal == "0") {
				if(cond_type == "cntr_no") {
					ComShowCodeMessage('BKG06012', "[Container No.]");
				}
				sheetObjects[1].SetCellValue(row, col,"",0);
				sheetObjects[1].SelectCell(row, col);
			}
			break;
		case SEARCH13 : //  retrieving data with B/L No.
			formObj.f_cmd.value=SEARCH13;
			formObj.bl_no.value=formObj.cond_value.value;
			ComOpenWait(true);
			var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			sheetObjects[1].RowDelete(row, false);
			// appending with retrieved data
			sheetObjects[1].LoadSearchData(sXml,{Append:1 , Sync:1} );
			//sheetObjects[1].RowDelete(sheetObjects[1].RowCount, false);
			formObj.bl_no.value="";
			for(var i=row; i <=  sheetObjects[1].RowCount(); i++) {
				sheetObjects[1].SetCellValue(i, "seq","",0);
				//sheetObjects[1].CellValue2(i, "ibflag") = "I";
				sheetObjects[1].SetRowStatus(i,"I");
			} // end for(i)
			break;
		case SEARCH14 : //  retrieving dg data of booking to add
			IBS_CopyFormToRow(formObj, sheetObjects[0], 1, "frm_");
			if(sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true) {
				ComShowCodeMessage('BKG06098');
				return;
			}
   			if(!ComShowConfirm(ComGetMsg("BKG95003", "[append from BKG data]"))) {
            	return false;
            }
			formObj.f_cmd.value=SEARCH14;
//			formObj.bl_no.value=formObj.cond_value.value;
			ComOpenWait(true);
			var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			//sheetObjects[1].RowDelete(row, false);
			var appendRow=sheetObjects[1].RowCount()+ 1;
			// appending with retrieved data
			sheetObjects[1].LoadSearchData(sXml,{Append:1 , Sync:1} );
			//sheetObjects[1].RowDelete(sheetObjects[1].RowCount, false);
			formObj.bl_no.value="";
			for(var i=appendRow; i <=  sheetObjects[1].RowCount(); i++) {
				sheetObjects[1].SetCellValue(i, "seq","A",0);
				sheetObjects[1].SetRowStatus(i,"I");
				sheetObjects[1].SetCellBackColor(i, "seq","#FFFF00");
			} // end for(i)
			break;
		case SEARCH07: // Feeder Name, Lloyd No Combo setting
			formObj.f_cmd.value=SEARCH07;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0965GS.do", FormQueryString(formObj));
			var feederName="";
			var feederLloydNo="";
			var displayTextOffeederNameLloyNo="";
			var oldLloyd=sheetObjects[1].GetCellValue(row, "fdr_vsl_lloyd_no");
			var oldName=sheetObjects[1].GetCellValue(row, "fdr_vsl_nm");
			// Feeder Name, Lloyd No Combo Setting
			if(sheetObjects[1].RowCount()> 0) {
				feederName=ComGetEtcData(sXml, "feederName");
				feederLloydNo=ComGetEtcData(sXml, "feederLloydNo");
				displayTextOffeederNameLloyNo=ComGetEtcData(sXml, "displayTextOffeederNameLloyNo");
				// Feeder Name, Lloyd No Combo Setting
				sheetObjects[1].CellComboItem(row,"fdr_vsl_nm", {ComboText:displayTextOffeederNameLloyNo, ComboCode:feederName} );
				sheetObjects[1].CellComboItem(row,"fdr_vsl_lloyd_no", {ComboText:displayTextOffeederNameLloyNo, ComboCode:feederLloydNo} );
//				sheetObjects[1].CellValue2(row, "fdr_vsl_lloyd_no") = oldLloyd;
//				sheetObjects[1].CellValue2(row, "fdr_vsl_nm") = oldName;
			}
			break;
			
		case COMMAND11 : //  PORT 조회

			formObj.f_cmd.value = SEARCH11;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchData("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
			ComXml2ComboItem(sXml, port_cd, "pod_cd", "pod_cd");
//			port_cd.Index2=0;
			port_cd.SetSelectIndex(0, false);
			ComOpenWait(false);

			break;
			
	}
	if(sAction == SEARCH02) { // when clicking SEARCH button
		for ( var i=1; i <= sheetObjects[1].RowCount(); i++) {
			// changing color as yellow if value is null
			if(sheetObjects[1].GetCellValue(i, "dg_short_nm") == "") {
				sheetObjects[1].SetCellBackColor(i, "dg_short_nm","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "c_type") == "") {
				sheetObjects[1].SetCellBackColor(i, "c_type","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "fdr_svc_rqst_no") == "") {
				sheetObjects[1].SetCellBackColor(i, "fdr_svc_rqst_no","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "imdg_clss_cd") == "") {
				sheetObjects[1].SetCellBackColor(i, "imdg_clss_cd","#FFFF00");
			}		
			if(sheetObjects[1].GetCellValue(i, "flsh_pnt_cdo_temp") == "" || sheetObjects[1].GetCellValue(i, "flsh_pnt_cdo_temp") == "0") {
				if(sheetObjects[1].GetCellValue(i, "imdg_clss_cd") == "3" ) {
					sheetObjects[1].SetCellBackColor(i, "flsh_pnt_cdo_temp","#FF8040");
				} 
			}
			if(sheetObjects[1].GetCellValue(i, "cell_psn_no") == "") {
				sheetObjects[1].SetCellBackColor(i, "cell_psn_no","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "imdg_un_no") == "") {
				sheetObjects[1].SetCellBackColor(i, "imdg_un_no","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "imdg_pck_grp_cd") == "") {
				sheetObjects[1].SetCellBackColor(i, "imdg_pck_grp_cd","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "dcgo_mrn_polut_cd") == "") {
				sheetObjects[1].SetCellBackColor(i, "dcgo_mrn_polut_cd","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "imdg_lmt_qty_flg") == "") {
				sheetObjects[1].SetCellBackColor(i, "imdg_lmt_qty_flg","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "ems_no") == "") {
				sheetObjects[1].SetCellBackColor(i, "ems_no","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "net_wgt") == "") {
				sheetObjects[1].SetCellBackColor(i, "net_wgt","#FFFF00");
			}
			if(sheetObjects[1].GetCellValue(i, "grs_wgt") == "") {
				sheetObjects[1].SetCellBackColor(i, "grs_wgt","#FFFF00");
			}
			if(formObj.dg_list_local_yn.value == "N" || sheetObjects[1].GetCellValue(i, "seq") == "A" || sheetObjects[1].GetCellValue(i, "cgo_opr_cd") != "NYK") { // Container NO. able to change after Booking data retrieve
			//if(formObj.dg_list_local_yn.value == "N") { // Container No. is to be modified in case of retrieving Booking data
				sheetObjects[1].SetCellEditable(i, "cntr_no",1);
			} else {
				sheetObjects[1].SetCellEditable(i, "cntr_no",0);
			}
			if(sheetObjects[1].GetCellValue(i, "c_type") == "V") { // Carriage Type == Marintime
				setMandatoryFeederInfo(i, true);
			} else {
				setMandatoryFeederInfo(i, false);
			}
		} // end for(i)
	}
}
/**
 * 
 * @param flag
 * @return
 */
function setMandatoryFeederInfo(row, flag) {
	sheetObjects[1].SetCellEditable(row,"fdr_svc_rqst_no",flag);
	sheetObjects[1].SetCellEditable(row,"fdr_vsl_nm",flag);
	sheetObjects[1].SetCellEditable(row,"fdr_vsl_lloyd_no",flag);
	sheetObjects[1].SetCellEditable(row,"fdr_vvd_id",flag);
	if(!flag) {
		sheetObjects[1].SetCellValue(row,"fdr_svc_rqst_no","",0);
		sheetObjects[1].SetCellValue(row,"fdr_vsl_nm","",0);
		sheetObjects[1].SetCellValue(row,"fdr_vsl_lloyd_no","",0);
		sheetObjects[1].SetCellValue(row,"fdr_vvd_id","",0);
	}
}
/**
 * changing value of send_type, msg_snd_no with retrieved value in the row which is send_type = "AC" 
 * @param sheetObj
 * @param colName
 * @param targetValue
 * @return
 */
function initSearchValue(sheetObj, colName, targetValue) {
	var rowCnt=sheetObj.RowCount();
	// 
	ComOpenWait(true);
	for(var i=1; i<=rowCnt; i++) {
		if(sheetObj.GetCellValue(i,"send_type") == targetValue) {
			sheetObj.SetCellValue(i,"send_type",sheetObj.CellSearchValue(i,"send_type"),0);
			sheetObj.SetCellValue(i,"msg_snd_no",sheetObj.CellSearchValue(i,"msg_snd_no"),0);
		}
	}
	ComOpenWait(false);
}
/**
 * changing color of Sent Status
 * 
 * @return
 */
function setSentStatusFiledColor(sheetObj, sentStatus) {
	var formObj=document.form;
	//var sentStatus = formObj.frm_ack_rcv_sts_cd.value
	var obj=formObj.ack_rcv_sts_cd_name;
	var maxCnt=sheetObj.RowCount();
	var nullSendTypeCnt=0;
	for(var i=1; i <= maxCnt; i++) {
if(sheetObj.GetCellValue(i, "send_type") == "") nullSendTypeCnt++;
	} // end for(i)
	obj.style.color="white";
	if(nullSendTypeCnt == maxCnt) {
		formObj.ack_rcv_sts_cd_name.value="All not sent";
		obj.style.backgroundColor="gray";
	} else {
		if (sentStatus == "FAIL") { // Fail
			formObj.ack_rcv_sts_cd_name.value="FAIL";
			c
		} else { // SUCCESS
			formObj.ack_rcv_sts_cd_name.value="SUCCESS";
			obj.style.backgroundColor="blue";
		}
	}
}
/**
 * attaching PREFIX in case of multi saving
 * 
 * @param sStr
 * @param sPrefix
 * @return
 */
function ComSetPrifix(sStr, sPrefix) {
	if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
		return sStr;
	}
	var regexp=RegExp(/&/g);
	sStr=sPrefix + sStr.replace(regexp, "&" + sPrefix);
	return sStr;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case COMMAND02 : // Row Delete
			if(sheetObj.RowCount()== 0) {
        		ComShowCodeMessage('BKG00095');
        		return false;
			}
			break;
		case SEARCH02:
		case SEARCH04:
			if(!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd) || !ComChkObjValid(formObj.port_cd)) return false;
			break;
		case SEARCH01:
		case SEARCH03:
		case SEARCH05:
			if(formObj.d_type.value != "" && formObj.vvd_cd.value != "" && port_cd.value != "") {
				if(!ComChkObjValid(formObj.d_type) || !ComChkObjValid(formObj.vvd_cd) || !ComChkObjValid(formObj.port_cd)) return false;
			}
			break;
		case IBSAVE:
			var sheet1RowCnt=sheetObjects[1].RowCount();
			if(sheet1RowCnt == 0) return false;
			if (!ComChkValid(formObj)) return false;
			// checking whether to exist changed search condition value
			if(formObj.hid_d_type.value != formObj.d_type.value ||
					formObj.hid_vvd_cd.value != formObj.vvd_cd.value ||
					formObj.hid_port_cd.value!= formObj.port_cd.value ) {
				ComShowCodeMessage("BKG06118", formObj.hid_d_type.value +","+ formObj.hid_vvd_cd.value+","+formObj.hid_port_cd.value, formObj.d_type.value+","+formObj.vvd_cd.value+","+formObj.port_cd.value);
				return false;
			}
			for(var i=1; i<=sheet1RowCnt; i++) {
				//if(sheetObjects[1].CellValue(i, "ibflag") == "D") continue;
				if(sheetObjects[1].GetRowStatus(i) == "D") continue;
				if(sheetObjects[1].GetCellValue(i, "imdg_clss_cd") == "3" &&
						(sheetObjects[1].GetCellValue(i, "flsh_pnt_cdo_temp") == "" || sheetObjects[1].GetCellValue(i, "flsh_pnt_cdo_temp") == "0") ) {
					ComShowCodeMessage("BKG00540", "[Container No. : " + sheetObjects[1].GetCellValue(i, "cntr_no") + "]");
	        		sheetObjects[1].SelectCell(i, "flsh_pnt_cdo_temp");
	        		return false;
				}
				// mandatory filed in case of Carriage Ttype = "MARITIME" : SSR(Feeder), Vessel Name(Feeder), Lloy No(Feeder), VVd(Feeder)
				if(sheetObjects[1].GetCellValue(i,"c_type") == "V") {
					// fdr_ssr is mandatory
					if(sheetObjects[1].GetCellValue(i,"fdr_svc_rqst_no") == "" ) {
						ComShowCodeMessage('BKG01101', "[SSR(Feeder)]");
						sheetObjects[1].SelectCell(i, "fdr_svc_rqst_no");
						return false;
					}
					if(sheetObjects[1].GetCellValue(i,"fdr_vsl_nm") == "" ) {
						ComShowCodeMessage('BKG01101', "[Vessel Name(Feeder)]");
						sheetObjects[1].SelectCell(i, "fdr_vsl_nm");
						return false;
					}
					if(sheetObjects[1].GetCellValue(i,"fdr_vsl_lloyd_no") == "" ) {
						ComShowCodeMessage('BKG01101', "[Lloyd No(Feeder)]");
						sheetObjects[1].SelectCell(i, "fdr_vsl_lloyd_no");
						return false;
					}
					if(sheetObjects[1].GetCellValue(i,"fdr_vvd_id") == "" ) {
						ComShowCodeMessage('BKG01101', "[VVD(Feeder)]");
						sheetObjects[1].SelectCell(i, "fdr_vvd_id");
						return false;
					}
				}
			} // end for(i)
			break;
		case IBDOWNEXCEL:
			if(sheetObj.RowCount()== 0) {
        		ComShowCodeMessage('BKG00109');
        		return false;
			}
			break;
		case COMMAND01 : // Filter
			var filterBlNo=formObj.filter_bl_no.value;
			var filterCntrNo=formObj.filter_cntr_no.value;
			if(filterBlNo == "" && filterCntrNo == "") {
				ComShowCodeMessage('BKG06095');
				ComSetFocus(formObj.filter_bl_no);
				return false;
			}
			if(sheetObj.RowCount()== 0) {
        		ComShowCodeMessage('BKG00095');
        		return false;
			}
			break;
		case COMMAND03 : // Filter
			if(sheetObj.RowCount()== 0) {
        		ComShowCodeMessage('BKG00095');
        		return false;
			}
			break;
		case MULTI01 :
		case MULTI02 : //creating Flat File and transmitting EDI(including CANCEL transmit) validation
			var currBlNo="";
			var preBlNo="";
			var sheet1RowCnt=sheetObjects[1].RowCount();
			if(sheet1RowCnt == 0) {
        		//no data to transmit
        		ComShowCodeMessage("BKG01096");
        		return false;
			}
			// checking whether to exist changed search condition value
			if(formObj.hid_d_type.value != formObj.d_type.value ||
					formObj.hid_vvd_cd.value != formObj.vvd_cd.value ||
					formObj.hid_port_cd.value!= formObj.port_cd.value ) {
				ComShowCodeMessage("BKG06118", formObj.hid_d_type.value +","+ formObj.hid_vvd_cd.value+","+formObj.hid_port_cd.value, formObj.d_type.value+","+formObj.vvd_cd.value+","+formObj.port_cd.value);
				return false;
			}
			var checkCnt=0;
			var cancelCheckCnt=0;
			var firstCheckCnt=0;
			var updateCheckCnt=0;
	        for(var i=1; i <= sheet1RowCnt; i++) {
	        	if(sheetObj.GetCellValue(i, "check") == "1") {
	        		currBlNo=sheetObj.GetCellValue(i, "bl_no");
					if(sAction == MULTI01) { // EDI Transmit button click
						if(sheetObj.GetCellValue(i, "out_imdg_pck_qty1") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[Quter Qty]");
	    	        		sheetObj.SelectCell(i, "out_imdg_pck_qty1")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "out_imdg_pck_cd1") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[Outer Code]");
	    	        		sheetObj.SelectCell(i, "out_imdg_pck_cd1")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "ems_no") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[EMS]");
	    	        		sheetObj.SelectCell(i, "ems_no")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "net_wgt") == "0") {
	    	        		ComShowCodeMessage("BKG01101", "[Net Weight]");
	    	        		sheetObj.SelectCell(i, "net_wgt")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "grs_wgt") == "0") {
	    	        		ComShowCodeMessage("BKG01101", "[Cross Weight]");
	    	        		sheetObj.SelectCell(i, "grs_wgt")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "packages") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[Packages]");
	    	        		sheetObj.SelectCell(i, "packages")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "cell_psn_no") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[Cell Position]");
	    	        		sheetObj.SelectCell(i, "cell_psn_no")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "imdg_pck_grp_cd") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[Package Guoup]");
	    	        		sheetObj.SelectCell(i, "imdg_pck_grp_cd")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "imdg_un_no") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[UN No.]");
	    	        		sheetObj.SelectCell(i, "imdg_un_no")
	    					return false;
	        			}
						if(sheetObj.GetCellValue(i, "stup_flg") == "") {
			        		ComShowCodeMessage("BKG01101", "[Setup Flag]");
			        		sheetObj.SelectCell(i, "stup_flg")
							return false;
		    			}	
						if(sheetObj.GetCellValue(i, "c_type") == "V") {
							if(sheetObjects[1].GetCellValue(i,"c_type") == "V") {
	        					// fdr_ssr is mandatory
								if(sheetObjects[1].GetCellValue(i,"fdr_svc_rqst_no") == "" ) {
	        						ComShowCodeMessage('BKG01101', "[SSR(Feeder)]");
	        						sheetObjects[1].SelectCell(i, "fdr_svc_rqst_no");
	        						return false;
	        					}
								if(sheetObjects[1].GetCellValue(i,"fdr_vsl_nm") == "" ) {
	        						ComShowCodeMessage('BKG01101', "[Vessel Name(Feeder)]");
	        						sheetObjects[1].SelectCell(i, "fdr_vsl_nm");
	        						return false;
	        					}
								if(sheetObjects[1].GetCellValue(i,"fdr_vsl_lloyd_no") == "" ) {
	        						ComShowCodeMessage('BKG01101', "[Lloyd No(Feeder)]");
	        						sheetObjects[1].SelectCell(i, "fdr_vsl_lloyd_no");
	        						return false;
	        					}
								if(sheetObjects[1].GetCellValue(i,"fdr_vvd_id") == "" ) {
	        						ComShowCodeMessage('BKG01101', "[VVD(Feeder)]");
	        						sheetObjects[1].SelectCell(i, "fdr_vvd_id");
	        						return false;
	        					}
	        				}
	        			}
	        			if((anr_role_div_cd.GetSelectCode()== "BO" && formObj.d_type.value == "PL")
	        				|| formObj.d_type.value == "P"
	        				|| (anr_role_div_cd.GetSelectCode()== "BO" && formObj.d_type.value == "DO")
	        				|| formObj.d_type.value == "O" ) {
	        				if(sheetObjects[1].GetCellValue(i,"crr_dt") == "") {
	        					ComShowCodeMessage('BKG01101', sheetObjects[1].GetCellValue(0,"crr_dt"));
        						sheetObjects[1].SelectCell(i, "crr_dt");
        						return false;
	        				}
	        			}
	        		}		        	
		        	if(currBlNo == preBlNo) continue;
		        	checkCnt++;
	        		//if(sheetObj.CellValue(i, "send_type") == "C") cancelCheckCnt++;
	        		//if(sheetObj.CellValue(i, "send_type") == "") firstCheckCnt++;
		        	if(sheetObj.GetCellValue(i, "send_type") == "O" || sheetObj.GetCellValue(i, "send_type") == "U") updateCheckCnt++;
		        	if(sAction == MULTI02 && sheetObj.GetCellValue(i, "send_type") == "") {
	        			//there is B/L No. of first transmission
	        			//"Unable to send cancel message without original sent message."
	        			ComShowCodeMessage("BKG06096");
	        			sheetObj.SetSelectRow(i);
	    	        	return false;
	        		}
		        	if(sAction == MULTI02 && sheetObj.GetCellValue(i, "send_type") == "C") {
	        			//there is B/L No. which is already canceled
		        		ComShowCodeMessage("BKG06097", sheetObj.GetCellValue(i, "bl_no"));
	        			sheetObj.SetSelectRow(i);
	    	        	return false;
	        		}
					if(sAction == MULTI01) { // EDI Transmit button click (skipping duplicated container)
						if(sheetObj.GetCellValue(i, "cntr_no") == "") {
	    	        		ComShowCodeMessage("BKG01101", "[Container No.]");
	    	        		sheetObj.SelectCell(i, "cntr_no")
	    					return false;
	        			}
					}
	        		preBlNo=currBlNo;
	        	}
	        }
	        if(checkCnt == 0) {
	        	//"Please check Select box of the target B/L No"
        		ComShowCodeMessage("BKG01097");
	        	return false;
	        } else {
	        	if(anr_role_div_cd.GetSelectCode()== "") {
	        		ComShowCodeMessage("BKG01101", "[Agent or Agent Forwader]");
					ComSetFocus(formObj.anr_role_div_cd);   
					return false;
	        	}
	        	if(sAction == MULTI02) { // EDI Cancel button click
	        		// checking together same  first_msg_snd_no
	        		if(!groupCheck("", "BKG06110")) return false;
        		} else { // EDI Transmit button click
        			if(updateCheckCnt > 0) {
	        			// checking together same  first_msg_snd_no. setting Flag with "AC"
		        		if(!groupCheck("AC", "BKG06111")) return false;
        			}
        		}
	        }
			break;
	} // end switch
	return true;
}
/**
 * setting search condition value to hidden variable
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function setSearchCond(sheetObj, formObj) {
	if(sheetObj.RowCount()> 0) {
		formObj.hid_d_type.value=formObj.d_type.value;
		formObj.hid_vvd_cd.value=formObj.vvd_cd.value;
		formObj.hid_port_cd.value=formObj.port_cd.value;
	}
}
/**
 * checking check box by group of first_msn_snd_no
 * 
 * @param autoCancelFlag
 * @param confirmMsgCode
 * @return
 */
function groupCheck(autoCancelFlag, confirmMsgCode) {
	var currBlNo="";
	var preBlNo="";
	var subCurrBlNo="";
	var subPreBlNo="";
	var msgSndNo="";
	var subMsgSndNo="";
	var firstMsgSndNo="";
	var subFirstMsgSndNo="";
	var groupCnt=0;
	var sheetObj=sheetObjects[1]
	var sheet1RowCnt=sheetObj.RowCount();
	var bLList="";
	var sendType="";
	var subSendType="";
	for(var i=1; i <= sheet1RowCnt; i++) {
		currBlNo=sheetObj.GetCellValue(i, "bl_no");
    	if(currBlNo == preBlNo) continue;
    	if(sheetObj.GetCellValue(i, "check") == "1") {
    		firstMsgSndNo=sheetObj.GetCellValue(i, "first_msg_snd_no");
    		sendType=sheetObj.GetCellValue(i, "send_type");
	msgSndNo=sheetObj.GetCellValue(i, "msg_snd_no");
    		subCurrBlNo="";
    		subPreBlNo="";
    		// 
    		for(var j=i ; j<=sheet1RowCnt; j++) {
    			subCurrBlNo=sheetObj.GetCellValue(j, "bl_no");
    			subSendType=sheetObj.GetCellValue(j, "send_type");
    			if(sendType == "C") {
    				continue;
    			}
    			subFirstMsgSndNo=sheetObj.GetCellValue(j, "first_msg_snd_no");
        		//alert("after" + "\nsubCurrBlNo : "+ subCurrBlNo + "\nfirstMsgSndNo : " + firstMsgSndNo + "\nsubFirstMsgSndNo : " + subFirstMsgSndNo);
    			if(subFirstMsgSndNo != "" && firstMsgSndNo == subFirstMsgSndNo) {
    				if(sheetObj.GetCellValue(j, "check") == "0" && subSendType != "C") {
    					if(autoCancelFlag != "") {
    						sheetObj.SetCellValue(j, "send_type","AC",0);// setting AUTO CACNCEL FLAG 셋팅
    						sheetObj.SetCellValue(j, "msg_snd_no",msgSndNo,0);// assigning first_msn_snd_no which is object of 'AUTO CANCEL' with same value
    					}
    					if(subPreBlNo != subCurrBlNo) {
    						bLList += subCurrBlNo + ",";
    					}
    					sheetObj.SetCellValue(j, "check",1,0);
    				}
    			} else {
    				continue;
    			}
    			subPreBlNo=subCurrBlNo; 
    		} // end for(j)
    		subCurrBlNo="";
    		subPreBlNo="";
    		subFirstMsgSndNo="";
    		// 
    		for(var j=i ; j>0; j--) {
    			subCurrBlNo=sheetObj.GetCellValue(j, "bl_no");
    			subSendType=sheetObj.GetCellValue(j, "send_type");
    			if(sendType == "C") {
    				continue;
    			}    			
    			subFirstMsgSndNo=sheetObj.GetCellValue(j, "first_msg_snd_no");
        		//alert("before" + "\nsubCurrBlNo : "+ subCurrBlNo + "\nfirstMsgSndNo : " + firstMsgSndNo + "\nsubFirstMsgSndNo : " + subFirstMsgSndNo);
    			if(subFirstMsgSndNo != "" && firstMsgSndNo == subFirstMsgSndNo) {
    				if( sheetObj.GetCellValue(j, "check") == "0" && subSendType != "C") {
    					if(autoCancelFlag != "") {
    						sheetObj.SetCellValue(j, "send_type","AC",0);// setting AUTO CACNCEL FLAG
    						sheetObj.SetCellValue(j, "msg_snd_no",msgSndNo,0);// assigning first_msn_snd_no which is object of 'AUTO CANCEL' with same value
    					}
    					if(subPreBlNo != subCurrBlNo) { 
    						bLList += subCurrBlNo + ",";
    					}
    					sheetObj.SetCellValue(j, "check",1,0);
    				}
    			} else {
    				continue;
    			}    
    			subPreBlNo=subCurrBlNo; 
    		} // end for(j)
    	}
    	//bLList += "\n";
    	preBlNo=currBlNo;
	 } // end for(i)
	if(bLList != "") {
		bLList=bLList.substring(0, bLList.lastIndexOf(","));
		if(autoCancelFlag != "AC") { // EDI Cancel button click
			if(!ComShowConfirm(ComGetMsg(confirmMsgCode) + "\n\n" + "Auto Check B/L No. List \n\n" + bLList)) {
            	// check box checked 해제 
            	sheetObjects[1].CheckAll("check",0,1);
            	return false;
		    }
		} else { // Auto Cancel
			if(!ComShowConfirm(ComGetMsg(confirmMsgCode) + "\n\n" + "Auto Cancel B/L No. List \n\n" + bLList)) {
            	// initializing as status of retrieving send type
            	initSearchValue(sheetObjects[1], "send_type", "AC");
            	// unchecking check box  
            	sheetObjects[1].CheckAll("check",0,1);
            	return false;
		    }
		}
	}
	return true;
}
/**
 * pop up button click event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	var formObj=document.form;
	with (sheetObj) {
		var sName=ColSaveName(Col);
		switch (sName) {
		case "fwrd_id":
			var sUrl="/opuscntr/ESM_BKG_0969.do";
			var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0969", 700, 500, false);
//			ComOpenPopup(sUrl, 650, 400, 'setCallBackFwrd', '1,0', false);
			if (rtnVal != null) {
				sheetObj.SetCellValue(Row, 'fwrd_id',rtnVal.cd,0);
				// sheetObj.CellValue2(Row, 'fwrd_nm') = rtnVal.nm;
			}
			break;
		case "dg":
			if(formObj.dg_list_local_yn.value == "Y") { // opening pop up window in case of existing data at customs DG table 
				sUrl="ESM_BKG_0967.do?";
				sParam="callGubun=ESM_BKG_0965" 
					+ "&d_type="+formObj.d_type.value
					+ "&vvd_cd="+formObj.vvd_cd.value
					+ "&port_cd="+formObj.port_cd.value
					+ "&bl_no="+sheetObj.GetCellValue(Row, 'bl_no')
					+ "&bkg_no="+sheetObj.GetCellValue(Row, 'bkg_no')
					+ "&cntr_no="+sheetObj.GetCellValue(Row, 'cntr_no')
					+ "&cntr_cgo_seq="+sheetObj.GetCellValue(Row, 'cntr_cgo_seq')
				    + "&berth_cd="+formObj.frm_brth_yd_cd.value
				    + "&berth_nm="+formObj.frm_yd_nm.value;
				//alert(sUrl + sParam);
				rtnVal=ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_0967", 1024, 720, false);
				//alert("rtnVal : " + rtnVal);
				if (rtnVal != "N") {
					doActionIBSheet(sheetObjects[0], formObj, SEARCH02); // 
				}
			} else {
				//ComShowMessage("You can open DG Inquiry only after pressing [Save] button");
				ComShowCodeMessage("BKG06100");
			}
			break;
		case "fdr_vsl_nm" :
		case "fdr_vsl_lloyd_no" :
//			var sUrl="/opuscntr/ESM_BKG_1097.do";
//			var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_1097", 800, 410, true);
//			if (rtnVal != null) {
//				sheetObj.SetCellValue(Row, 'fdr_vsl_lloyd_no',rtnVal.cd,0);
//				sheetObj.SetCellValue(Row, 'fdr_vsl_nm',rtnVal.nm,0);
//			}
			comBkgCallPop1097("setFdrVslPopup");
			break;
		case "imdg_un_no" :
			//ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + sheetObj.CellValue(Row, 'imdg_un_no') + "&bkg_no=" + sheetObj.CellValue(Row, 'bkg_no'), 920, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
			//ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + sheetObj.CellValue(Row, 'imdg_un_no') + "&bkg_no=" + sheetObj.CellValue(Row, 'bkg_no'), 920, 450, "setSheet", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
			ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + sheetObj.GetCellValue(Row, 'imdg_un_no') + "&bkg_no=" + sheetObj.GetCellValue(Row, 'bkg_no'), 920, 450, "setSheet", '1,0,1,1,1,1,1', true, false, Row, Col, 1);
			break;
		} // end switch
	} // end with
}
/**
 * ESM_BKG_0969 Pop up에서 읽기. <br>
 * 
 * @param {arry}
 *            popupData
 * @return 없음
 * @see
 * @author 백형인
 * @version 2014.10.14
 */ 
function setCallBackFwrd(aryPopupData) {
	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(),sheetObjects[1].SaveNameCol("fwrd_id"),aryPopupData.cd) 
//	var form=document.form;
//	form.cust_seq.value=aryPopupData[0][3].substring(2,8);
//	form.cust_cnt_cd.value=aryPopupData[0][3].substring(0,2);
} 
/**
 * change event of form field
 * 
 * @return
 */
function obj_change() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.ComGetEvent("maxlength");
	var srcValue=window.ComGetEvent("value");
	if (srcName == "vvd_cd" || srcName == "port_cd") {
		ComOpenWait(true);
		var dType=formObject.d_type.value;
		var vvdCd=formObject.vvd_cd.value;
		var portCd=formObject.port_cd.value;
		if(srcName == "vvd_cd") { // setting Vessel Code in case of changing vvd_cd(1-4 of vvd_cd)
			formObject.frm_vsl_cd.value=srcValue.substr(0, 4);
		}
		// checking if there are data at DB table of Local Danger with vvd, port
		doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
		if(formObject.frm_vsl_cd.value != "") { //searching Vessel Name with Vessel Code in case of changing vvd field
			doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
		}
		ComOpenWait(false);
		if(dType != "" && vvdCd != "" && portCd != "") {
			doActionIBSheet(sheetObjects[0], formObject, SEARCH06); // DG List Copy activating/deactivating check box according to data
		}		
		//ComSetFocus(formObject.bay_plan_upload_check);
		eval("formObject." + srcName + ".focus()");
	} else if(srcName == "frm_vsl_cd") { // in case of changing Vessel Code
		ComOpenWait(true);
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
		ComOpenWait(false);
	} else if(srcName == "frm_brth_yd_cd") { // in case of changing Berth Code 
		//alert("frm_brth_yd_cd");
		ComOpenWait(true);
		doActionIBSheet(sheetObjects[0], document.form, SEARCH04);
		ComOpenWait(false);
	} else if(srcName == "filter_bl_no" || srcName == "filter_bl_no" ) { // in case of changing filter_bl_no, filter_cntr_no
		if(sheetObjects[1].RowCount()> 0) {
			nextFilterIdx=0;
			sheetObjects[1].selectRow=1;
		}
	} 
}
/**
 * when inputting search condition 
 */
//function obj_KeyUp() {
//	var formObject=document.form;
//	var srcName=ComGetEvent("name");
//	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	var srcValue=window.event.srcElement.getAttribute("value");
//	if ((srcName == "vvd_cd" || srcName == "port_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
//		ComSetNextFocus();
//	}
//}
/**
 * onClick event
 */
function sheet2_OnClick(sheetObj, row, col) {
	var rowCnt=sheetObj.RowCount();
var check=sheetObj.GetCellValue(row, "check");
var mergeBlNo=sheetObj.GetCellValue(row, "merge_bl_no");
var sendTypeCheckOrgin=sheetObj.GetCellValue(row, "send_type_check_orgin");
	var colSaveName=sheetObj.ColSaveName(col);
	/* setting default value of font and color of Row Focus  */
//no support[implemented common]CLT 	sheetObj.SelectFontBold=false;
//no support[implemented common]CLT 	sheetObj.SelectBackColor="16186087";
	switch(colSaveName) {
		/* applying MemoPad function in case of long sentences */
		case "packages" :
		case "prp_shp_nm" :
		case "hzd_desc" :
			ComShowMemoPad(sheetObj, null, null, false, 250, 80);
			break;
		/* when clicking Check Box */
		case "check" :
			for ( var i=row; i <= rowCnt; i++) {
				if (check == 1) {
					if (i == row) continue;
					if (mergeBlNo == sheetObj.GetCellValue(i, "merge_bl_no")) {
						sheetObj.SetCellValue(i, "check",0,0);
					}
				} else if (check == 0) {
					if (i == row) continue;
					if (mergeBlNo == sheetObj.GetCellValue(i, "merge_bl_no")) {
						sheetObj.SetCellValue(i, "check",1,0);
					}
				}
			} // end for(i)
			break;
			/* Send Type to Original 클릭시*/
		case "send_type_check_orgin" :
			for ( var i=1; i <= rowCnt; i++) {
				if (sendTypeCheckOrgin == 1) {
					if (i == row) continue;
					if (mergeBlNo == sheetObj.GetCellValue(i, "merge_bl_no")) {
						sheetObj.SetCellValue(i, "send_type_check_orgin",0,0);
					}
				} else if (sendTypeCheckOrgin == 0) {
					if (i == row) continue;
					if (mergeBlNo == sheetObj.GetCellValue(i, "merge_bl_no")) {
						sheetObj.SetCellValue(i, "send_type_check_orgin",1,0);
					}
				}
			} // end for(i)
			break;
		case "fdr_vsl_nm" :
		case "fdr_vsl_lloyd_no" :
			break;
	} // end switch
}
/**
 * sheet2 Change event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, row, col, value) {
	var rowCnt=sheetObj.RowCount();
	var colSaveName=sheetObj.ColSaveName(col);
	var formObj=document.form;
	switch(colSaveName) {
		case "imdg_clss_cd":
		case "imdg_un_no":
//		case "fwrd_id":
		case "dg_short_nm":
		//case "agent":
//		case "c_type":
			if(value == "V") { // Carriage Type=Marintime
				setMandatoryFeederInfo(row,true);
			} else {
				setMandatoryFeederInfo(row,false);
			}
			break;
		case "bl_no" :
			formObj.cond_type.value="bl_no";
			formObj.cond_value.value=value;
			doActionIBSheet(sheetObjects[1],formObj,SEARCH11, row, col); // input validation
			break;
		case "pol_cd" : 
			formObj.cond_type.value="pol_cd";
			formObj.cond_value.value=value;
			doActionIBSheet(sheetObjects[1],formObj,SEARCH11, row, col); // input validation
			break;
		case "pod_cd" : 
			formObj.cond_type.value="pod_cd";
			formObj.cond_value.value=value;
			doActionIBSheet(sheetObjects[1],formObj,SEARCH11, row, col); // input validation
			break;
		case "cntr_no" :			
			formObj.cond_type.value="cntr_no";
			formObj.cond_value.value=value;
			if (sheetObj.GetCellValue(row, "cgo_opr_cd") == "NYK") {
				doActionIBSheet(sheetObjects[1],formObj,SEARCH12, row, col); // input validation
			}
			break;
//		case "fdr_vsl_nm" :
//		case "fdr_vsl_lloyd_no" :
//			var sName=sheetObj.GetComboInfo(row, "fdr_vsl_nm", "Code");
//			var sCode=sheetObj.GetComboInfo(row, "fdr_vsl_lloyd_no", "Code");
//			var arrName=sName.split("|");
//			var arrCode=sCode.split("|");
//			var idx=sheetObj.GetComboInfo(row, colSaveName, "SelectedIndex");
//			//alert(arrName[idx] + "||" + arrCode[idx]);
//			if(colSaveName == "fdr_vsl_nm") {
//				sheetObj.SetCellValue(row, "fdr_vsl_lloyd_no",arrCode[idx],0);
//			} else {
//				sheetObj.SetCellValue(row, "fdr_vsl_nm",arrName[idx],0);
//			}
//			break;
//		case "crr_dt" :
//			var preKey="";
//			var currKey="";
//			var nextKey="";
//			var blNo=sheetObj.GetCellValue(row, "bl_no");
//			if(blNo != "") {
//				currKey=blNo;
//				// copying crr_dt value in case of same key value when changing crr_dt field
//				for(var i=row; i <= rowCnt; i++) {
//					//currKey = sheetObj.CellValue(i, "bl_no");
//					nextKey=sheetObj.GetCellValue(i+1, "bl_no");
//					if(currKey == nextKey) {
//						sheetObj.SetCellValue(i+1, "crr_dt",value,0);
//					} else {
//						break;
//					}
//				} // end for(i)
//				// copying crr_dt value in case of same key value when changing crr_dt field
//				for(var i=row; i >= 1; i--) {
//					preKey=sheetObj.GetCellValue(i-1, "bl_no");
//					//currKey = sheetObj.CellValue(i, "bl_no");
//					if(preKey == currKey) {
//						sheetObj.SetCellValue(i-1, "crr_dt",value,0);
//					} else {
//						break;
//					}
//				} // end for(i)
//			}
//			break;

		case "cell_psn_no" :
			copyCellValueSheet2(sheetObj, rowCnt, row, "cell_psn_no", value);
			break;
		case "cntr_tpsz_cd" :
			copyCellValueSheet2(sheetObj, rowCnt, row, "cntr_tpsz_cd", value);
			break;
		case "fwrd_id":
			copyCellValueSheet2(sheetObj, rowCnt, row, "fwrd_id", value);
			break;
		case "fdr_svc_rqst_no":
			copyCellValueSheet2(sheetObj, rowCnt, row, "fdr_svc_rqst_no", value);
			break;
		case "fdr_vsl_nm":
			copyCellValueSheet2(sheetObj, rowCnt, row, "fdr_vsl_nm", value);
			break;
		case "fdr_vsl_lloyd_no":
			copyCellValueSheet2(sheetObj, rowCnt, row, "fdr_vsl_lloyd_no", value);
			break;
		case "fdr_vvd_id":
			copyCellValueSheet2(sheetObj, rowCnt, row, "fdr_vvd_id", value);
			break;
		case "c_type":
			copyCellValueSheet2(sheetObj, rowCnt, row, "c_type", value);
			break;
		case "crr_dt" :
			copyCellValueSheet2(sheetObj, rowCnt, row, "crr_dt", value);
			break;
	}
}	
/**
 * opening detail
 * 
 * @return
 */
function openDetail(sheetObj,Row) {
	if(sheetObj.RowCount()== 0) {
		ComShowCodeMessage('BKG00095');
		return false;
	}
    var formObj=document.form;
	var sUrl="ESM_BKG_0970_P.do?";
	var sParam="callGubun=ESM_BKG_0965&mainPage=false" 
	+ "&d_type="+formObj.d_type.value
	+ "&vvd_cd="+formObj.vvd_cd.value
	+ "&port_cd="+formObj.port_cd.value
	+ "&bl_no="+sheetObj.GetCellValue(Row, 'bl_no')
	+ "&cntr_no="+sheetObj.GetCellValue(Row, 'cntr_no')
	+ "&cntr_cgo_seq="+sheetObj.GetCellValue(Row, 'cntr_cgo_seq');
	//alert(sUrl + sParam);
	rtnVal=ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_0970_P", 1050, 700, false);
}
/**
 * double click event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnDblClick(sheetObj,Row,Col) {
	var colSaveName=sheetObj.ColSaveName(Col);
	switch(colSaveName) {
		case "seq" :
		case "bl_no" :
		case "pol_cd" :
		case "pod_cd" :
		case "cntr_no" :
			if(!sheetObj.GetCellEditable(Row, colSaveName)) {
				//alert("colSaveName : " + colSaveName + "\n editable : " + sheetObj.CellEditable(Row, colSaveName) + "\nsheetObj.MouseRow : " + sheetObj.MouseRow );
				openDetail(sheetObj,sheetObj.MouseRow());
			}
			break;
	} // end switch()
}
/**
 * callback function from un_no pop up window
 * @param aryPopupData
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function setSheet(aryPopupData, row, col, sheetIdx) {
 	var sheetObj=sheetObjects[sheetIdx];
 	var formObj=document.form;
 	var colArray=aryPopupData[0];
 	var imdgUnNo=colArray[2];
 	var imdgUnNoSeq=colArray[3];
 	var imdgClssCd=colArray[4]; 
 	var imdgCompGrpCd=colArray[5];
 	var imdgPckGrpCd=colArray[6];
 	var prpShpNm=colArray[7];
 	var emsNo=colArray[17];
//	alert(row + "/"+ col + "/"+ sheetIdx);
//	alert(imdgUnNo + "/" + imdgUnNoSeq);
 	if(imdgPckGrpCd==""){
 		imdgPckGrpCd = "N";
 	}
 	sheetObj.SetCellValue(row, "imdg_un_no",imdgUnNo,0);
 	sheetObj.SetCellValue(row, "imdg_un_no_seq",imdgUnNoSeq,0);
 	sheetObj.SetCellValue(row, "imdg_clss_cd",imdgClssCd,0);
 	sheetObj.SetCellValue(row, "imdg_comp_grp_cd",imdgCompGrpCd,0);
 	sheetObj.SetCellValue(row, "ems_no",emsNo,0);
 	sheetObj.SetCellValue(row, "imdg_pck_grp_cd",imdgPckGrpCd,0);
}

function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
 	var formObj=document.form;
	var state=sheetObj.GetEtcData("TRANS_RESULT_KEY");    	
	if (state == "S") {
		if (formObj.f_cmd.value == MULTI01 || formObj.f_cmd.value == MULTI02) {
			ComShowCodeMessage('BKG00101');
			doActionIBSheet(sheetObjects[1], formObj, SEARCH02); 
		}
	}
}
function copyCellValueSheet2(sheetObj, rowCnt, row, col, value) {
	var blNo=sheetObj.GetCellValue(row, "bl_no");
	var cntrNo=sheetObj.GetCellValue(row, "cntr_no");
	
	// copy same cell position value in case of next row key value is equal when Cell Position value change
	if(blNo != "" && cntrNo != ""){
		for(var i=1; i <= rowCnt; i++) {
			if(sheetObj.GetCellValue(i, "bl_no")==blNo && sheetObj.GetCellValue(i, "cntr_no")==cntrNo){
				sheetObj.SetCellValue(i, col, value, 0);

				if(col=="c_type"){
					if(value == "V") { // Carriage Type=Marintime
						setMandatoryFeederInfo(i,true);
					} else {
						setMandatoryFeederInfo(i,false);
					}				
				}			
			}
		}
	}
}
function setFdrVslPopup(rowArray) {
	var row = sheetObjects[1].GetSelectRow();
	sheetObjects[1].SetCellValue(row, "fdr_vsl_nm", rowArray.fdr_vsl_nm, 1);
	sheetObjects[1].SetCellValue(row, "fdr_vsl_lloyd_no", rowArray.fdr_vsl_lloyd_no, 1);
}