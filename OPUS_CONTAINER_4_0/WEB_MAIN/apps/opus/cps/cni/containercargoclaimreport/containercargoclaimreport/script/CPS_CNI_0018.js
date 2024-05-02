/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0018.js
*@FileTitle  : [CPS_CNI_0018] Status 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/
/**
 * [CPS_CNI_0018] Status
 * 
 * @extends
 * @class Status 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
// common global variables
//IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
//HTML Form
var frm=null;
var frm2=null;
//IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
var area_cd="";//area cd
var mainCode="";
var locationCode="";
//By Area Setting
var byAreaHeadTitle="|seq|cgo_clm_div_cd|cgo_clm_no|clm_area_cd|hdlr_ofc_cd|cgo_clm_sts_cd|lit|hdlr_usr_id1|hpd|nhp|prlm_clm_ntc_dt|fmal_clm_rcv_dt|upd_dt|clmt_clm_tp_cd|clm_pty_abbr_nm1|trnk_ref_vvd_no|cgo_clm_ref_bl_no|crr_term_cd|por_cd|pol_cd|pod_cd|del_cd|fvd|n1st_pre_ts_loc_cd|n1st_pst_ts_loc_cd|clm_cgo_tp_nm|cgo_clm_tp_cd|mjr_clm_dmg_lss_cd|minr_clm_dmg_lss_cd|clmt_usd_amt|cgo_clm_stl_tp_cd|cgo_clm_stl_dt|cgo_clm_stl_usd_amt|labl_pty_rcvr_usd_amt";
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * registering IBCombo Object as list
 * @param comboObj
 **/
function setComboObject(comboObj){
	comboObjects[comboCnt++]=comboObj;
}
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var frm=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn1_Inquiry by Class":
				var url="CPS_CNI_0019.do";
				var display="0,0,1,1,0,1,1,1,1,0,1,1";
				var win1=ComOpenWindowCenter(url, "ClassWin", 600, 560, "", display);
				win1.focus();
				break;
			case "btn_Retrieve":
				sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
				break;
			case "btn1_New":
				//if (ComShowCodeConfirm("CNI00015") ) { // "CNI00015=Do you want to initialize?"
				ComResetAll();
				ComSetObjValue(frm.from_period,ComGetNowInfo("yy") + "-01-01");
				ComSetObjValue(frm.to_period,ComGetNowInfo());
				ComSetObjValue(period,"DON");
				ComSetObjValue(vt, "G");
				ComSetObjValue(combo_status, "All");
				ComSetObjValue(area, area_cd);
				// By Area 선택 (전체 컬럼중에서 Inquery By Class 중 )
				setTemplate("63", "By Area",  byAreaHeadTitle);
				//}	
				break;
			case "btn1_DownExcel":
				if(sheet1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
					}else{
						sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
					}
				break;
			case "btn1_Print":
				frm.page_no.value=""; //페이지 번호 삭제
				doActionIBSheet(PRINT);
				break;
			case "btn1_Cargo":
				popupMainMiscView("15");
				break;
			case "btn1_TOC":
				popupMainMiscView("11");
				break;
			case "btn1_CODL1":
				popupMainMiscView("02");
				break;
			case "btn1_CODL2":
				popupMainMiscView("05");
				break;
			case "btn1_POI":
				popupMainMiscView("14");
				break;
			case "btn1_POR":
				//공통팝업 Location호출
				var locCd=frm.por_cd.value;
				locationCode="POR";
				popupLocation(locCd);
				break;
			case "btn1_DEL":
				//공통팝업 Location호출
				var locCd=frm.del_cd.value;
				locationCode="DEL";
				popupLocation(locCd);
				break ;	 
			case "btn1_Liable_Party":
			case "btn1_Surveyor":
			case "btn1_Claimant": 
			case "btn1_Claimant_Agent":
			case "btn1_Salvager":
			case "btn1_Insurer":
				mainCode=srcName.replace("btn1_", "").toLowerCase();
				popupMainCodeInquiry();
				break;	
			case "btn1_Approver":
				ComOpenPopupWithTarget("COM_ENS_091.do", 780, 560, "usr_id:clm_stl_auth_usr_id", "1,0,1,1,1", true);
				break;
			case "btn1_Handler":
				ComOpenPopupWithTarget("COM_ENS_091.do", 780, 560, "usr_id:hdlr_usr_id", "1,0,1,1,1", true);
				break;
			case "btns_from_period":
			case "btns_to_period":
				var result=srcName.replace("btns_", "");
			    calObj=eval("frm." + result );
				var vCal=new ComCalendar();
				vCal.setDisplayType('date');
				vCal.select(calObj, 'yyyy-MM-dd');
				break;
			case "btns_hndl_ofc_cd":
				popupOfficeCode();
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;	
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	frm=document.form;
	frm2=document.form2;
	sheet1=sheetObjects[0];
	sheetCnt=sheetObjects.length;
	// sheet initial
	for ( var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// By Area 선택 (전체 컬럼중에서 Inquery By Class 중 )
	setTemplate("63", "By Area",  byAreaHeadTitle);
	// IBMultiComboinitializing
	comboCnt=comboObjects.length;
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	initComboBoxValue();
	//registering initial event 
	initControl();
	//Period 기간 초기값 셋팅(GMT기준)
	var sXml2=document.form2.sXml.value;
	var arrXml=sXml2.split("|$$|");
	var vCurDate=ComGetEtcData(arrXml[0], "CurrentDate");	
	if (ComIsDate(vCurDate)){
		ComSetObjValue(frm.from_period, vCurDate.substring(0,4) + "-01-01");
		ComSetObjValue(frm.to_period, vCurDate);
	}
	// 포커싱
	ComSetFocus(period);
}
/**
  * Combobox Initialize, Header Definition 
  * @param {object} comboObj Mandatory, IBMultiCombo Object
  * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
  **/
function initCombo(comboObj, comboNo) {
 	with (comboObj) {
 		comboObj.SetMultiSelect(0);
 //no support[check again]CLT 		comboObj.UseCode=true;
 //no support[check again]CLT 		comboObj.LineColor="#ffffff";
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
 		comboObj.SetMultiSeparator(",");
 		comboObj.SetDropHeight(175);
 		if (comboNo > 3){
		    comboObj.SetBackColor("#FFFFFF");
		} else {
			comboObj.SetBackColor("#CCFFFD");
		}
 	}
} 
 /**
 * 초기 콤보 설정
 **/
function initComboBoxValue() {
	var sXml2=document.form2.sXml.value;	
	var arrXml=sXml2.split("|$$|");
	var idx=0;
	setMultiComboBox("period" ,  arrXml[idx] ); //Type of Period Date(36)
	ComSetObjValue(period, "DON");
	idx++;
	setMultiComboBox("area" ,  arrXml[idx] ); //2. Area(09)
	idx++;
 	setMultiComboBox("combo_status" ,  arrXml[idx] ); //3. Status Type(08)
	idx++;
	setMultiComboBox("vt" ,  arrXml[idx] ); //4. Type of Claim class(39)
	idx++;
	setMultiComboBox("cgo_clm_stl_tp_cd" ,  arrXml[idx] ); //5.Type of Settlement(07)
	idx++;
	setMultiComboBox("crr_term_cd" ,  arrXml[idx] ); //6.Carriage Term (06)
	idx++;
	setMultiComboBox("inci_plc_tp_cd" ,  arrXml[idx] ); //7.Place of Incident(14)
	idx++;
	setMultiComboBox("cgo_clm_tp_cd" ,  arrXml[idx] ); //8.Place of Incident(11)
	idx++;
 	// Area Cd Setting
 	var dataCount=ComGetTotalRows(arrXml[idx]);
 	if (dataCount > 0) {
 		var list=SheetXml2ListMap(arrXml[idx]);	
 		var listVO=list[0];
 		clmAreaCd=listVO["clm_area_cd"];
 		area_cd=clmAreaCd;
 		ComSetObjValue(area, clmAreaCd);
 		ComSetObjValue(frm.usr_area, clmAreaCd);
	} 
 	//ComSetObjValue(vt, "G");
} 
/**
* registering initial event 
**/
function initControl() {
//	axon_event.addListenerForm('keypress',        'obj_keypress', frm);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
//	axon_event.addListenerForm('keyup',			   'obj_keyup', frm); 
	//keydown
//	axon_event.addListener  ('keydown', 'ComKeyEnter', 'form');
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj Mandatory IBSheet Object
  * adding case as numbers of counting sheets
  */
function initSheet(sheetObj,sheetNo) {
   var cnt=0;
   switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
	                var HeadTitle1="|Seq.|Class|Claim No.|A|HOFC|ROFC|Handler|Manager|STS|LIT|DOC|HPD|NHP|DON|DOF|DOU|" +
	                "T|Claimant|Claimant’s Agent|Lane|VVD|B/L No.|CNTR No.|TP/SZ|CNT|CT|POR|DOR|POL|POD|DEL|" +
	                "DDL|DOTB|LP DOTB|FVD|PRE_POT|ON_POT|Cargo|TOC|CODL1|CODL2|Claim Amount|" +
	                "DOAK|DOFF|TOS|DOS|Settled Amount|POI|Liable Party|LP HOFC|LP DOF|LP CAMT|LP DOR|LP RAMT|Insurer|INS DOF|INS CAMT|INS DOR|INS RAMT|" +
	                "Surveyor|DOSV|Survey Fee|Salvager|DOSL|SL Amount|Applicant|APOFC|DOAP|Approver|AVSTS|AVOFC|DOAV|Approval No.|" +
	                "Plaintiff|PL Attorney|Court|Case No.|DOSSV|Defendant|Def. Attorney|DODAA|Legal Costs|" +
	                "INC No.|VOC No.|Period 1|Period 2|Period 3|Period 4|Period 5|Period 6|DUMY";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                    {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fmal_clm_rcv_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"lit",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cs_clz_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoAvg",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"hpd",                     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoAvg",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"nhp",                     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"prlm_clm_ntc_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"fmal_clm_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"clmt_clm_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:"clm_pty_abbr_nm1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"clm_pty_abbr_nm2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trnk_ref_vvd_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_cntr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tp_sz",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cnt",                     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"crr_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rct_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"de_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"clm_tm_bar_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"labl_tm_bar_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fvd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pre_ts_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pst_ts_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"clm_cgo_tp_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"mjr_clm_dmg_lss_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"minr_clm_dmg_lss_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"clmt_usd_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_acknak_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"fact_fnd_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_stl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_stl_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cgo_clm_stl_usd_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inci_plc_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"labl_clm_pty_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hndl_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"labl_pty_fmal_clm_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"labl_pty_dmnd_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"labl_pty_rcvr_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"labl_pty_rcvr_usd_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"insur_pty_abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"insur_fmal_clm_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"insur_dmnd_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ins_dor",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"insur_rcvr_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"svey_clm_pty_abbr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"svey_inp_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"svyr_fee_usd_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"slaver_clm_pty_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"slv_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"slv_usd_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"applicant",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"apofc",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"doap",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"approver",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"avsts",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"avofc",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"doav",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"approval_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"plt_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agn_clm_pty_abbr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crt_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crt_cs_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"smns_sve_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"deft_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"clm_pty_abbr_nm3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"deft_atty_apnt_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"legal_costs",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_inci_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crm_voc_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoAvg",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"period1",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoAvg",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"period2",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoAvg",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"period3",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoAvg",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"period4",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoAvg",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"period5",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"AutoAvg",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"period6",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ,
	                    {Type:"AutoAvg",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"DUMY",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
	                    ];

	                InitColumns(cols);
	
	                SetEditable(0);
	                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                SetSheetHeight(242);
               }
                break;
   }
}
 /**
  * row double click 시 CPS_CNI_0003 팝업창 띄움
  * @param {IBSheet} sheet
  * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
  * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
  */
function sheet1_OnDblClick(sheet, row, col) {
var cgoClmNo=sheet1.GetCellValue(row , "cgo_clm_no");
 	var sUrl = "CPS_CNI_0003_01.do?pgmNo=CPS_CNI_0003&ENU=Y&popupYn=Y&cgo_clm_no="+cgoClmNo; //메뉴없는 창 띄울때	
 //	var sUrl="/opuscntr/opusMain.screen?parentPgmNo=CPS_CNI_M001&pgmUrl=^opus^CPS_CNI_0003.do&mainPage=true&pgmNo=CPS_CNI_0003&cgo_clm_no="+cgoClmNo;
 	var winName="CPS_CNI_0003";
  	var reqWin=ComOpenWindow(sUrl,winName,"width=1224,height=700, resizable=yes, scrollbars=yes, status=no");
 }
function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if (sheet.RowCount()<= 0) {
		ComShowCodeMessage("CNI00013");//msgs["CNI00013"]="There is no data to search.";
	}
}
//method change[check again]CLT function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
//	frm.page_no.value=PageNo;
//	doActionIBSheet(SEARCHLIST01);
//}   
//focus in
function obj_activate(){
	obj=ComGetEvent();
	if (obj.getAttribute("readOnly")) return;
	ComClearSeparator(obj);
} 
// focus out
function obj_deactivate(){
	obj=ComGetEvent();
	ComChkObjValid(obj);
	if (obj.name == "clm_cgo_tp_cd")  {
		if (ComIsNull(obj.value)) {
			ComSetObjValue(frm.clm_cgo_tp_nm,"");
		}
		return;
	}
	if (ComIsNull(obj.value)) {
		return;
	}
}

// Handling Sheet's process
function doActionIBSheet(sAction) {
	frm.f_cmd.value=sAction;
	switch (sAction) {
		case SEARCHLIST01: // Retrieve
			if (validateForm(sAction)) {
				var from_period=ComGetObjValue(frm.from_period);
				var to_period=ComGetObjValue(frm.to_period);
				var from_clmt_usd_amt=ComGetObjValue(frm.from_clmt_usd_amt);
				var to_clmt_usd_amt=ComGetObjValue(frm.to_clmt_usd_amt);
				var from_cgo_clm_stl_usd_amt=ComGetObjValue(frm.from_cgo_clm_stl_usd_amt);
				var to_cgo_clm_stl_usd_amt=ComGetObjValue(frm.to_cgo_clm_stl_usd_amt);
				// Form Object Mask Clear
				ComClearSeparator(frm.from_period);
				ComClearSeparator(frm.to_period);
				ComClearSeparator(frm.from_clmt_usd_amt);
				ComClearSeparator(frm.to_clmt_usd_amt);
				ComClearSeparator(frm.from_cgo_clm_stl_usd_amt);
				ComClearSeparator(frm.to_cgo_clm_stl_usd_amt);
				// Form Object Data 
				var vFormData=FormQueryString(frm);
				ComSetObjValue(frm.from_period,from_period);
				ComSetObjValue(frm.to_period,to_period);
				ComSetObjValue(frm.from_clmt_usd_amt,from_clmt_usd_amt);
				ComSetObjValue(frm.to_clmt_usd_amt,to_clmt_usd_amt);
				ComSetObjValue(frm.from_cgo_clm_stl_usd_amt,from_cgo_clm_stl_usd_amt);
				ComSetObjValue(frm.to_cgo_clm_stl_usd_amt,to_cgo_clm_stl_usd_amt);
				//페이지 번호 셋팅
				// Request
				var sXml=sheet1.GetSearchData("CPS_CNI_0018GS.do", vFormData ,"",true );
				//에러 체크
			    sheet1.SetSumText(1, "TOTAL");
				if (getErrorMsg(sheet1,sXml)) {
					return;
				}
				var list=SheetXml2ListMap(sXml);
				if (list.length == 0) {
					ComShowCodeMessage("CNI00013");
				} else {
				    sheet1.LoadSearchData(sXml,{Append:1 , Sync:0} );
				}  
			}
			break;
		case PRINT:
			if (validateForm(sAction)) {
				var from_period=ComGetObjValue(frm.from_period);
				var to_period=ComGetObjValue(frm.to_period);
				var from_clmt_usd_amt=ComGetObjValue(frm.from_clmt_usd_amt);
				var to_clmt_usd_amt=ComGetObjValue(frm.to_clmt_usd_amt);
				var from_cgo_clm_stl_usd_amt=ComGetObjValue(frm.from_cgo_clm_stl_usd_amt);
				var to_cgo_clm_stl_usd_amt=ComGetObjValue(frm.to_cgo_clm_stl_usd_amt);
				// Form Object Mask Clear
				ComClearSeparator(frm.from_period);
				ComClearSeparator(frm.to_period);
				ComClearSeparator(frm.from_clmt_usd_amt);
				ComClearSeparator(frm.to_clmt_usd_amt);
				ComClearSeparator(frm.from_cgo_clm_stl_usd_amt);
				ComClearSeparator(frm.to_cgo_clm_stl_usd_amt);
				ComSetObjValue(frm.com_mrdArguments, "");
				ComSetObjValue(frm.com_mrdBodyTitle, "");
				ComSetObjValue(frm.com_mrdPath, "");
				// Form Object Data 
				var vFormData=FormQueryString(frm);
				ComSetObjValue(frm.from_period,from_period);
				ComSetObjValue(frm.to_period,to_period);
				ComSetObjValue(frm.from_clmt_usd_amt,from_clmt_usd_amt);
				ComSetObjValue(frm.to_clmt_usd_amt,to_clmt_usd_amt);
				ComSetObjValue(frm.from_cgo_clm_stl_usd_amt,from_cgo_clm_stl_usd_amt);
				ComSetObjValue(frm.to_cgo_clm_stl_usd_amt,to_cgo_clm_stl_usd_amt);
				frm.page_no.value="";//전건조회를 위해 실처리는 DAO 에서 함.
				//리포트 프로그램ID
				var report_id=ComGetObjValue(frm.report_id);
				//리포트 타이틀명
				var report_title=ComGetObjValue(frm.report_title)
				var rf="/rf ["+ RDServerIP + "/CPS_CNI_0063.do]";
				var rpost="/rpost ["+ vFormData +"]";
				var rpaper="/rpaper [A4]";
				if (frm.usr_area.value == "A") {
					rpaper="/rpaper [LETTER]";
				}
				var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]" + getCondAllValue();
				frm.com_mrdArguments.value=rf + " " + rv + " " + rpost + " " + rpaper;
				frm.com_mrdBodyTitle.value="Container Cargo Claim List by " + report_title;		
				frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaimreport/containercargoclaimreport/report/CPS_CNI_00" + report_id  + ".mrd";
				//var feature = "resizable=yes,width=1000,height=600";
				popupRd(1000,600);
				//ComOpenRDPopup(feature); 
			}
			break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sAction) {
	 if (ComGetObjValue(period) == "") {
		 ComShowCodeMessage("CNI00003", "period");
		 period.focus();
		 return false; 
	 }
	 if (ComGetObjValue(period)!= "" && ComGetObjValue(frm.from_period) == "") {
		 ComShowCodeMessage("CNI00003", "period date"); 
		 frm.from_period.focus();
		 return false;
	 }
	 if (ComGetObjValue(period) != "" && ComGetObjValue(frm.from_period) == "") {
		 ComShowCodeMessage("CNI00003", "period date");
		 frm.to_period.focus();
		 return false;
	 }
	 var from_clmt_usd_amt=ComReplaceStr(ComGetObjValue(frm.from_clmt_usd_amt).trim(),",","");
	 var to_clmt_usd_amt=ComReplaceStr(ComGetObjValue(frm.to_clmt_usd_amt).trim(),",","");
	 if (!ComIsNull(from_clmt_usd_amt) && !ComIsNull(to_clmt_usd_amt) && 
	      parseFloat(from_clmt_usd_amt) >= parseFloat(to_clmt_usd_amt)){
		 ComShowCodeMessage("CNI00036");
		 frm.to_clmt_usd_amt.focus();
		 return false;
	 }
	 var from_cgo_clm_stl_usd_amt=ComReplaceStr(ComGetObjValue(frm.from_cgo_clm_stl_usd_amt).trim(),",","");
	 var to_cgo_clm_stl_usd_amt=ComReplaceStr(ComGetObjValue(frm.to_cgo_clm_stl_usd_amt).trim(),",","");
	 if (!ComIsNull(from_cgo_clm_stl_usd_amt) && !ComIsNull(to_cgo_clm_stl_usd_amt) && 
	      parseFloat(from_cgo_clm_stl_usd_amt) >= parseFloat(to_cgo_clm_stl_usd_amt)){
		  ComShowCodeMessage("CNI00036");
		  frm.to_cgo_clm_stl_usd_amt.focus();
		  return false;
	 }
	 if (ComGetObjValue(frm.clmt_clm_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.clmt_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clmt_clm_agn_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.clmt_clm_agn_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.insur_clm_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.insur_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clm_liable_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.labl_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.slv_clm_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.slv_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clm_surveyor_pty_abbr_nm).trim() == "") {
	 	 ComSetObjValue(frm.svey_clm_pty_no, ""); 
	 }
	 return true;
}
function setTemplate(reportId, reportTitle, sheetHeadTitle){
	//선택한 템플릿 셋팅
	ComSetObjValue(frm.report_id, reportId);
	ComSetObjValue(frm.report_title, reportTitle);
	if (reportId == "75" || reportId == "74") {
		ComSetObjValue(period,"DOF");
	}	  
	var vSaveColName=sheetHeadTitle.split('|');
    var vColCount=vSaveColName.length;
    var vSheetColCount=sheet1.LastCol()+1;
    sheet1.RenderSheet(0);
    for(var idx=1;idx<=vSheetColCount;idx++){
    	sheet1.SetColHidden(idx,0);
    }
    sheet1.RenderSheet(1);
    sheet1.RemoveAll();
    for(var idx=1; idx<vColCount; idx++){
    	if (sheet1.SaveNameCol((vSaveColName[idx].toLowerCase())) > 0) {
    	    sheet1.MoveColumnPos(vSaveColName[idx].toLowerCase(),idx);
    	} 
    }
    sheet1.RenderSheet(0);
    for(var jdx=vColCount;jdx<=vSheetColCount;jdx++){
    	sheet1.SetColHidden(jdx,1);
    }
    sheet1.RenderSheet(1);
}
/**
* setting IBMultiComboBox
* @param {select box} combo object
* @param {xml} code , name xml
* @param {String} selected initial Code 
*/ 
function setMultiComboBox(pComboObjId, pXML) {
	var vComboObj=null; // IBMultiComboBox
	var vArrayListData=""; 
	var vListData="";
	var vCaptionText="";
	vComboObj=getComboObject(pComboObjId);
	if (vComboObj == null || pXML == null ) {
		return;
	}
	var vArrayListData=SheetXml2ListMap(pXML);
	var j = 0;
	for (var idx=0; idx < vArrayListData.length; idx++) {
	    vListData=vArrayListData[idx];
//		vCaptionText=vListData["code"] + " |" + vListData["name"];
		   if (vListData != undefined && vListData != null) {
			   vCaptionText = vListData['code'] + "|" + vListData["name"];
		    	vComboObj.InsertItem(j++, vCaptionText, vListData["code"]);
		    }
//		vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
	} //end for
	if (pComboObjId == "combo_status") {
		vComboObj.InsertItem(0, "ALL|All Status", "All");
		vComboObj.SetSelectIndex(0);
	} else if (pComboObjId == "area") {
		vComboObj.InsertItem(0, "ALL|All Area", "All");
		vComboObj.SetSelectIndex(-1);
	} else {
		vComboObj.InsertItem(0, "", "");
		vComboObj.SetSelectIndex(0);
	}	
}
/**
* combo id 로 해당 comboObject를 찾아 반환한다.
* @param comboId
**/
function getComboObject(pComboObjId){
	var vCnt=comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].options.id== pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}

function combo_status_OnChange(comboObj,Index_Code, Text){
	//var objVal = ComGetObjValue(combo_status);
	document.form.status.value = comboObj.GetSelectCode();
}


function setMainCodeInquiry(partyVo) {
	switch(mainCode){
		case "claimant":
			frm.clmt_clm_pty_no.value=partyVo.clm_pty_no;
			frm.clmt_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			break;
		case "claimant_agent":
			frm.clmt_clm_agn_pty_no.value=partyVo.clm_pty_no;
			frm.clmt_clm_agn_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			break;	
		case "insurer":
			frm.insur_clm_pty_no.value=partyVo.clm_pty_no;
			frm.insur_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			break;
		case "liable_party":
			frm.labl_clm_pty_no.value=partyVo.clm_pty_no;
			frm.clm_liable_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			break;
		case "salvager":
			frm.slv_clm_pty_no.value=partyVo.clm_pty_no;
			frm.slv_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
		 	break;
		case "surveyor":
			frm.svey_clm_pty_no.value=partyVo.clm_pty_no;
			frm.clm_surveyor_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			break;
	}
} 
//Miscellaneous 팝업창에서 호출한 함수
function setMiscCode(miscCdVO){
	var clss_clm_misc_cd=miscCdVO.clss_clm_misc_cd;
	switch(clss_clm_misc_cd){
		case "02":
			frm.mjr_clm_dmg_lss_cd.value=miscCdVO.clm_misc_cd;
			break;
		case "05":
			frm.minr_clm_dmg_lss_cd.value=miscCdVO.clm_misc_cd;
			break;
		case "11":
			cgo_clm_tp_cd.value=miscCdVO.clm_misc_cd;
			break;
		case "14":
			inci_plc_tp_cd.value=miscCdVO.clm_misc_cd;
			break;
		case "15":
			frm.clm_cgo_tp_cd.value=miscCdVO.clm_misc_cd;
			frm.clm_cgo_tp_nm.value=miscCdVO.clm_misc_nm;
			break;	
	}
}
/**
 * 리포터 파라메터 값 전달을 위한 문자열 처리 
 * @return
 */
function getCondAllValue(){
	var vObjects=frm.elements;
	var vCondStr="";
	for ( var kdx=0; kdx < vObjects.length; kdx++) {
		var vObj=vObjects[kdx];
		var vObjTp=vObj.type;
		var vObjNm=vObj.name;
		if (typeof(vObjNm) == "undefined" || vObjNm == "" || vObjTp == "hidden"){
			continue;
		}
		vCondStr += "p_" + vObjNm + "[" +  ComGetObjValue(vObj) + "]";
	} //end for
	return vCondStr;
}
/**
 * 공통팝업 Location Setting
 * @param rowArray
 * @return
 */
function setLocation(rowArray) { 
 	if (locationCode == "POR"){
        frm.por_cd.value=rowArray[0][3];
    } else if ( locationCode == "DEL") {
        frm.del_cd.value=rowArray[0][3]; 
    }	    
}
/**
 * Handler Office Code Setting
 * 팝업창 결과 처리
 * @param ofcCd
 * @return 없음
 */ 
function setOfficeCode(ofcCd){
	frm.hndl_ofc_cd.value=ofcCd;
}
 /**
 * Common error-handling function
 * @class IAfter the Search IBSheet Exception message shows that when 
 * @param {IBSheet} pSheetObj it's IBSheet
 * @param {string} pXml XML on the server, the query results
 * @throws
 * @author 정행룡
 * @since 2009.11.12
 */
function getErrorMsg(pSheetObj, pXml){
	var vErrorMsg=ComGetEtcData(pXml,"Exception");
	if (vErrorMsg != undefined && vErrorMsg != null && vErrorMsg != "" ) {
		pSheetObj.LoadSearchData(pXml,{Sync:1} );
		return true;
	}
	return false;
} 
