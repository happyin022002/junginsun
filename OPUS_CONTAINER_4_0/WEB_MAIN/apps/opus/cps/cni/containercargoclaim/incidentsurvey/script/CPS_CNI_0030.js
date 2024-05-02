/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0030.js
*@FileTitle  : Incident-Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // initializing       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
var combo1=null;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
 /**
  * registering IBCombo Object as list
  * @param comboObj
  **/
 function setComboObject(comboObj){
 	comboObjects[comboCnt++]=comboObj;
 }
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage() {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);   
    }
	// IBMultiComboinitializing
	combo1=comboObjects[0];
	comboCnt=comboObjects.length;
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	initComboBox();
    //registering initial event 
    initControl();
    if(frm.cgo_clm_inci_no.value == ""){
    	setRollBtnCtl(frm.cre_usr_id.value, frm.clm_area_cd.value, frm.cre_ofc_cd.value, "btn1_Save","Y");
    }else{
    	setRollBtnCtl(frm.cre_usr_id.value, frm.clm_area_cd.value, frm.cre_ofc_cd.value, "btn1_Save","N");
    }
	if(frm.cgo_clm_inci_no.value != ""){
		doActionIBSheet(SEARCHLIST01);
	}
	//Default값은 MVS.
	combo1.SetSelectCode("MVS");
	frm.inci_plc_tp_cd.value="MVS";//실제DB입력할 hidden 값.
    //화면을 open하면 Cursor가 poi 입력란에 위치.
	//combo1 Default값 세팅후에 위치해야함.
	ComSetFocus(combo1);
}
/**
* registering initial event 
*/
function initControl() {
   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
 //  axon_event.addListenerFormat('beforeactivate',  'obj_activate',    frm);
   axon_event.addListenerForm('keyup', 'obj_keyup',frm);
   axon_event.addListener  ('change'  , 'vvd_change', 'inci_ref_vvd_no');//- VVD 입력 후 입력된 정보 체크하기
   axon_event.addListener  ('change'  , 'loc_change', 'inci_loc_cd');//- Location 입력 후 입력된 정보 체크하기
}
 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {
 	var sXml2=frm.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
 	setMultiComboBox("combo1" ,  arrXml[0] ); //14
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
            var HeadTitle1="";
            var headCount=ComCountHeadTitle(HeadTitle1);
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
            InitColumns(cols);
            SetWaitImageVisible(0);
            SetEditable(1);
			break;
		}
	}
}
/**
 * Combobox Initialize, Header Definition 
 * @param {object} comboObj Mandatory, IBMultiCombo Object
 * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
 **/
function initCombo(comboObj, comboNo) {
	with (comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetBackColor("#CCFFFD");
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(190);
	}
} 
// ===================================================================================
// Private function
// ===================================================================================
/**
 * setting Location
 */
 function setLocation(rowArray) { 
    frm.inci_loc_cd.value=rowArray[0][3];
 }
// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal=new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
}
/*
 * 데이터 포맷
 */
function setFormatData(pObj, pRawData, pDataFormat){
    switch (pDataFormat) {
		case "ymd":    //yyyy-mm-dd
		case "ymdhms": //yyyy-mm-dd hh:mm:ss
		case "ymdhm":  //yyyy-mm-dd hh:mm
			ComAddSeparator(pObj, pDataFormat);
			break;
		case "int":
			pObj.value=ComAddComma2(pRawData, "#,###");
			break;
		case "float":
			pObj.value=ComAddComma2(pRawData, "#,###.00");
			break;
		default:
			pObj.value=pRawData;
			break;
	}
}
function setVvdSkd(vvdSkdVo){
	frm.inci_ref_vvd_no.value=vvdSkdVo.vvd;
}
/**
* Vvd Code/Name 입력부분.<br>
* @param {arry} vvdVo
*/
function setVvdCd(vvdVo){
	frm.inci_ref_vvd_no.value=vvdVo.vvd_cd;
}
/**
 * VVD 입력시 입력된 정보 체크한다. <br>
 **/
function vvd_change() {
	if (form.inci_ref_vvd_no.value != "") {
		doActionIBSheet(IBROWSEARCH, 'inci_ref_vvd_no');
	}
}
/**
* Location 입력시 입력된 정보 체크한다. <br>
**/
function loc_change() {
	if (form.inci_loc_cd.value != "") {
		doActionIBSheet(IBROWSEARCH, 'inci_loc_cd');
	}
}
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn1_Retrieve":
				var cgoClmInciNo=frm.cgo_clm_inci_no.value;
				if (ComIsNull(cgoClmInciNo) || cgoClmInciNo.length != 13) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Incident No 13 characters");
					ComSetFocus(frm.cgo_clm_inci_no);
					return;
				}
				doActionIBSheet(SEARCHLIST01);			
				break;	
			case "btn1_New":
				//CNI00015 Do you want to initialize?
				if (ComShowCodeConfirm("CNI00015") ) {
					ComResetAll();
					combo1.SetSelectCode("MVS");
					frm.inci_plc_tp_cd.value="MVS";//실제DB입력할 hidden 값.
					ComSetFocus(combo1);
					frm.cgo_clm_inci_no.value="";
					setRollBtnCtl(frm.cre_usr_id.value, frm.clm_area_cd.value, frm.cre_ofc_cd.value, "btn1_Save","Y");
				}
				break;
			case "btn1_Save":
				frm.f_cmd.value=MULTI;	
				if(ComChkValid(frm)) {
					if(validateForm()){
						//CNI00012(Do you want to save changes?)
						if (ComShowCodeConfirm("CNI00012")) {
							doActionIBSheet(MULTI);
						}
					}
				}
				break; 
			case "btns_location":
				//공통팝업 Location호출
				var locCd=frm.inci_loc_cd.value;
				popupLocation(locCd);
				break;
			case "btns_vvd":
				//VVD 팝업호출
//				var vvdNo =  frm.inci_ref_vvd_no.value;
//				popupVvdSkd(vvdNo);	//CCC Vvd 호출시 
				popupVvdCd();//DWC Vvd 호출(CPS_CNI_0306.do)로 변경함.(CPS_CNI_0301.js 참고)
				break;
			case "btn1_Print":
				if ( frm.cgo_clm_inci_no_old.value == "" ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 
			case "btn1_File_Upload":
				var cgoClmInciNo=frm.cgo_clm_inci_no_old.value;
			    var dispCgoClmInciNo=frm.cgo_clm_inci_no.value;
				if (ComIsNull(cgoClmInciNo) || dispCgoClmInciNo.length != 13) {
					ComShowCodeMessage("CNI00103");//Please use after retrieve or save
				}else{
					popupFileUpload("003001" ,  cgoClmInciNo);
				}
				break;
			case "btns_date_cal":
				calendarDisplay(frm.inci_occr_dt);
				break;
		} // end switch
}
/**
 * HTML Control KeyPress event
 */
/**
 * HTML Control KeyDowm event
 */
function obj_keydown() {
	 if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;
  	 if (event.keyCode != 13) {
  		 return;
  	 }
    switch (ComGetEvent("name")) {  
		case "cgo_clm_inci_no":
				if (frm.cgo_clm_inci_no.value.length == 13) {
					doActionIBSheet(SEARCHLIST01);
				}else{
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Incident No 13 characters");
					ComSetFocus(frm.cgo_clm_inci_no);
					return;
				}
			break;
	}
}
/**
 * HTML Control KeyUp event
 */
function obj_keyup() {
	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return; 
    switch (ComGetEvent("name")) {    
		case "cgo_clm_inci_no":
			if(frm.cgo_clm_inci_no.value.length == 13){
				doActionIBSheet(SEARCHLIST01);
			}
			break;
	}
}
function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text) {
	var formObj=document.form;
	formObj.inci_plc_tp_cd.value=ComGetObjValue(comboObj);
	if(ComGetObjValue(comboObj) == "MVS" || ComGetObjValue(comboObj) == "FVS"){
//		formObj.inci_ref_vvd_no.focus();	
	}
}
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * sheet1_OnSearchEnd
 * @param {IBSheet} sheet
 * @param {ErrMsg} ErrMsg
 */
 /*
 function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount()<= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}
 }
 */
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction, Col) {
	//sheetObj.ShowDebugMsg = false;
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;
 		var sXml=sheet1.GetSearchData("CPS_CNI_0030GS.do", FormQueryString(frm),"",true);
		var arrXml=sXml.split("|$$|");
		if (sXml.length > 0) {			
			var list=SheetXml2ListMap(arrXml[0]);	
			if (list.length > 0) {
				var InciCreationVO=list[0];
				frm.cgo_clm_inci_no.value=InciCreationVO["cgo_clm_inci_no"];
				frm.cgo_clm_inci_no_old.value=InciCreationVO["cgo_clm_inci_no"];//file upload 위한 old값.
				frm.clm_area_cd.value=InciCreationVO["clm_area_cd"];
				frm.inci_plc_tp_cd.value=InciCreationVO["inci_plc_tp_cd"];
				ComSetObjValue(combo1, InciCreationVO["inci_plc_tp_cd"]);
				frm.inci_occr_dt.value=InciCreationVO["inci_occr_dt"];
				frm.inci_loc_cd.value=InciCreationVO["inci_loc_cd"];
				frm.inci_subj_nm.value=InciCreationVO["inci_subj_nm"];
				frm.inci_ref_vvd_no.value=InciCreationVO["inci_ref_vvd_no"];
				frm.inci_dev_desc.value=InciCreationVO["inci_dev_desc"];
				frm.cre_ofc_cd.value=InciCreationVO["cre_ofc_cd"];
				frm.cre_usr_id.value=InciCreationVO["cre_usr_id"];
				frm.cre_dt.value=InciCreationVO["cre_dt"];
				frm.upd_dt.value=InciCreationVO["upd_dt"];
				frm.cre_ofc_cd.value=InciCreationVO["cre_ofc_cd"];
				setFormatData(frm.cre_dt, "", "ymd");
				setFormatData(frm.upd_dt, "", "ymd");
				setFormatData(frm.inci_occr_dt, "", "ymd");
				//권한
				setRollBtnCtl(frm.cre_usr_id.value, frm.clm_area_cd.value, frm.cre_ofc_cd.value, "btn1_Save");
			}else{
				var tempInciNo=frm.cgo_clm_inci_no.value;
				ComResetAll();//조회건이 없으면 form reset.
				frm.cgo_clm_inci_no.value=tempInciNo;//insert 하려는 경우를 위해 inci_no는 다시 세팅한다.
				//msgs["CNI00013"] = "There is no data to search.";
				ComShowCodeMessage("CNI00013");
			}
        }
//		//frm.inci_subj_nm.focus();
	} else if (sAction == MULTI) {
		frm.f_cmd.value=MULTI;
		//sepatator 제거
		ComClearSeparator(frm.inci_occr_dt);
		var param="";
		param += FormQueryString(frm);
		var saveString=sheet1.GetSaveString();
		param += "&" + saveString;	
 		var sXml=sheet1.GetSaveData("CPS_CNI_0030GS.do", param);
 		sheet1.LoadSaveData(sXml);
		//main에 없는 clm_no 를 입력하려고 할경우 에러처리하고 재조회하지 않는다.
		var etcClmInciNo="";
		etcClmInciNo=ComGetEtcData(sXml, "ETC_CLM_INCI_NO");	
		//재조회
		frm.cgo_clm_inci_no.value=etcClmInciNo;
		doActionIBSheet(SEARCHLIST01);
	} else if (sAction == PRINT) {		
		frm.f_cmd.value=PRINT;
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0088.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]";
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
//		var rv="";
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]";
		frm.com_mrdArguments.value=rv+ " " + rf + " " + rpost + " " + rpaper;	
		frm.com_mrdBodyTitle.value="Incident Report-Print";		
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaim/incidentsurvey/report/CPS_CNI_0088.mrd";
		popupRd(1000,600);
	} else if(sAction == IBROWSEARCH){
		if (Col == "inci_loc_cd") {//Location 조회
			var obj=eval("document.form."+Col);
    			var sXml=sheet1.GetSearchData("CPS_CNI_0030GS.do" , "&f_cmd="+SEARCH01+"&loc_cd="+obj.value);
   			var result=ComGetEtcData(sXml, "loc_cd");
   			if(typeof result == "undefined" || result == "" ) {
				ComShowCodeMessage("CNI00001" , "Location");
				ComSetFocus(document.form.inci_loc_cd);
				document.form.inci_loc_cd.value="";
				return;
			} 
		} else if (Col == "inci_ref_vvd_no") {//VVD 조회
			var obj=eval("document.form."+Col);
    			var sXml=sheet1.GetSearchData("CPS_CNI_0030GS.do" , "&f_cmd="+SEARCH02+"&vvd_no="+obj.value);
   			var result=ComGetEtcData(sXml, "vsl_cd");
   			if(typeof result == "undefined" || result == "" ) {
				ComShowCodeMessage("CNI00001" , "VVD");
				ComSetFocus(document.form.inci_ref_vvd_no);
				document.form.inci_ref_vvd_no.value="";
				return;
			} 
		}
	}
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
	for ( var idx=0; idx < vArrayListData.length; idx++) {
	    vListData=vArrayListData[idx];
	    if(vListData != undefined){
			vCaptionText=vListData["code"] + "|" + vListData["name"];
			vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
	    }
	}//end for
}
/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
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
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
		if (comboObjects[0].GetSelectCode()== "") {
			//msgs["CNI00018"] = "Please select {?msg1}";
			ComShowCodeMessage("CNI00018" , "POI");
			ComSetFocus(combo1);
			return false;
		}
        //POI가 MVS이거나 FVS인 경우 VVD를 반드시 입력하도록 
		if(comboObjects[0].GetSelectCode()== "MVS" || comboObjects[0].GetSelectCode()== "FVS"){
			if(frm.inci_ref_vvd_no.value == ""){
				//msgs["CNI00009"] = "Please input {?msg1}";
				ComShowCodeMessage("CNI00009" , "VVD");
				ComSetFocus(frm.inci_ref_vvd_no);
				return false;
			}
		}
		//POI가 VVD이거나 FVD인 경우를 제외하고 Location을 반드시 입력하도록 
		if(comboObjects[0].GetSelectCode()!= "MVS" && comboObjects[0].GetSelectCode()!= "FVS"){
			if(frm.inci_loc_cd.value == ""){
				//msgs["CNI00009"] = "Please input {?msg1}";
				ComShowCodeMessage("CNI00009" , "Location");
				ComSetFocus(frm.inci_loc_cd);
				return false;
			}
		}
	return true;
}

