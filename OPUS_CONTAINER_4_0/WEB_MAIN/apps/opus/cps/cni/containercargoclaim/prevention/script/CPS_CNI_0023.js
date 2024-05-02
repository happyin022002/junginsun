/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0023.js
*@FileTitle  : Prevention-Register
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/08/18
=========================================================*/
/**
 * [CPS_CNI_0023] Prevention
 * @extends
 * @class Prevention 대상 검색 및 금액 입력화면
 */
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
// Main Code Inquiry 팝업 타입
var type="";
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/*
 * registering IBCombo Object as list
 * @param comboObj
 */
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
function loadPage(year) {
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
    //registering initial event 
    initControl();
    var sXml=frm.sXml.value;
	setComboBox(frm.clm_prve_div_cd , sXml ,"G");
	var clmPrveNo=frm.clm_prve_no.value;
	ComBtnDisable("btn1_File_Upload");	
	if (!ComIsNull(clmPrveNo)) {
		doActionIBSheet(SEARCHLIST01);		
	} 
	if(frm.clm_area_cd.value == ""){
		var popwin=popupClientDefault(); //calling setup display not existing Area Code
		popwin.focus();
	}
	
	var usrId=frm.usr_id.value;
	setRollBtnCtlPrevention(usrId, "btn1_save,btn1_File_Upload");
	//초기 focus();
	frm.clm_prve_div_cd.focus();
}
/**
* registering initial event 
*/
function initControl() {
	//axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
	//axon_event.addListener('keyup', 'keypressClmPrveNo', 'clm_prve_no');
	//axon_event.addListener ('keydown', 'keydownEnter', 'form');
	// focus out
   // axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
   // axon_event.addListenerFormat('focus',   'obj_activate',    frm);
}
/**
* Combobox Initialize, Header Definition 
* @param {object} comboObj Mandatory, IBMultiCombo Object
* @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
**/
function initCombo(comboObj) {
	with (comboObj) {
		comboObj.SetMultiSelect(0);
//no support[check again]CLT 		comboObj.UseCode=true;
//no support[check again]CLT 		comboObj.LineColor="#ffffff";
		comboObj.SetColAlign(0, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(190);
		//comboObj.LineColor = "#ffffff";
		comboObj.SetBackColor("#CCFFFD");
	}
} 
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
    	    //setting Host information [mandatory][HostIp, Port, PagePath]
//no support[check again]CLT 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		     break;
		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {
		case "btn1_Retrieve":
			if (ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST01);			
			}
			break;
		case "btn1_save":
			if (ComChkValid(frm)) {
				if (ComIsNull(frm.clm_prve_no.value)) {
					doActionIBSheet(ADD);
				} else {
					doActionIBSheet(MODIFY);
				}							
			}
			break;
		case "btn1_close":
			ComClosePopup(); 
			break;
		case "btn1_File_Upload":
			var clmPrveNo=frm.clm_prve_no.value;
			if (!ComIsNull(clmPrveNo)) {
				popupFileUpload("002301",clmPrveNo);
			}else{
				ComShowCodeMessage("CNI00103");//Please use after retrieve or save
			}
			
			break;
		case "btn1_Print":
			var clmPrveNo=frm.clm_prve_no.value;
			if (!ComIsNull(clmPrveNo)) {
				doActionIBSheet(PRINT);
			} 
			break;			
	    case "btn1_New":
	    	//msgs["CNI00015"] = "Do you want to initialize?";
	    	if (ComShowCodeConfirm("CNI00015")) {
	    		ComResetAll();
	    		frm.clm_prve_div_cd.value="G";
	    		frm.clm_prve_no.value="";
	    		frm.clm_prve_div_cd.focus();
	    	}	    	
	        break;				
	}
}
/**
 * HTML Control KeyPress event
 */
function keypressClmPrveNo() {
 	var obj=ComGetEvent();
    switch(ComGetEvent("name")) {    
    case "clm_prve_no":
    	if (obj.value.length == 10) {
    		//doActionIBSheet(SEARCHLIST01);
    		focusOut();
    	}
    	break;
	}
}
//업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	obj=ComGetEvent();
   if(obj.dataformat == null) return;
   window.defaultStatus=obj.dataformat;
   switch(ComGetEvent("name")) {
       case "clm_prve_no":
       	ComKeyOnlyAlphabet('uppernum');
    	break;          	
   }
}
  /**
   * HTML Control Foucs in
   */
  function obj_activate(){
      ComClearSeparator(ComGetEvent());    
  }
  /**
   * HTML Control Focus out
   **/
  function obj_deactivate() {
  	switch (ComGetEvent("name")) {  	  		
  	case "eff_dt":  		
  		ComChkObjValid(ComGetEvent());
  		break;
  	}
  }  
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {		
		frm.f_cmd.value=SEARCHLIST01;
 		var sXml=sheet1.GetSearchData("CPS_CNI_0023GS.do", FormQueryString(frm));
		var list=SheetXml2ListMap(sXml);
		if (list.length > 0) {
			var vo=list[0];
			frm.clm_prve_no.value=vo["clm_prve_no"];
			frm.clm_prve_div_cd.value=vo["clm_prve_div_cd"];			
			var effDt=vo["eff_dt"];
			frm.eff_dt.value=fmDate(vo["eff_dt"]);
			var expDt=vo["exp_dt"];			
			var effYyyy=effDt.substring(0,4);
			var expYyyy=expDt.substring(0,4);
			var diff=parseInt(expYyyy , 10) -  parseInt(effYyyy , 10) ;
			if (diff == 1) {
				frm.exp_dt.value="1";
			} else if(diff == 3) {
				frm.exp_dt.value="3";
			} else if(diff == 5) {
				frm.exp_dt.value="5";
			} else if(diff == 10) {
				frm.exp_dt.value="10";
			} else {
				frm.exp_dt.value="P";
			}
			frm.cre_ofc_cd.value=vo["cre_ofc_cd"];
			frm.clm_prve_subj_nm.value=vo["clm_prve_subj_nm"];
			frm.clm_prve_desc.value=vo["clm_prve_desc"];			
			frm.cre_usr_id.value=vo["cre_usr_id"];			
			frm.clm_area_cd.value=vo["clm_area_cd"];
		}
		var clmPrveNo=frm.clm_prve_no.value;
		if (!ComIsNull(clmPrveNo)) {
			ComBtnEnable("btn1_File_Upload");
		} else {
			ComBtnDisable("btn1_File_Upload");
		}
	} else if (sAction == ADD) {
		frm.f_cmd.value=ADD;
 		var sXml=sheet1.GetSearchData("CPS_CNI_0023GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:1} );
		var clmPrveNo=ComGetEtcData( sXml, "clm_prve_no");
		frm.clm_prve_no.value=clmPrveNo;
		doActionIBSheet(SEARCHLIST01);
	} else if (sAction == MODIFY) {
		frm.f_cmd.value=MODIFY;
 		var sXml=sheet1.GetSearchData("CPS_CNI_0023GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:1} );
		doActionIBSheet(SEARCHLIST01);
	} else if (sAction == PRINT) {
		frm.f_cmd.value = PRINT;
		var rf = "/rf [" + RDServerIP + "/CPS_CNI_0093.do]";
		var rpost = "/rpost [" + FormQueryString(frm) + "]";
		var rpaper = "/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		var rv = "/rv NgmSsoName [JSESSIONID] NgmSsoData [" + frm.jsession.value + "]";
		frm.com_mrdArguments.value = rv + " " + rf + " " + " " + rpost + " " + rpaper;
		frm.com_mrdBodyTitle.value = "Prevention-Print";
		frm.com_mrdPath.value = "apps/opus/cps/cni/containercargoclaim/prevention/report/CPS_CNI_0093.mrd";
//		var feature = "resizable=yes,width=1000,height=600";
		popupRd(1000, 600);
	}
}
