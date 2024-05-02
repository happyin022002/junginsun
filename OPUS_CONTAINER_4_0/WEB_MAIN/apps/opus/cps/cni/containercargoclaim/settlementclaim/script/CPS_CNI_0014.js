/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0014.jsp
*@FileTitle  : Settlement - Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/**
 * [CPS_CNI_0014] Settlement Claim
 * @extends
 * @class Settlement 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */

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
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
//IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
var combo1=null;
// html form
var frm=null;
var frm2=null;
var roeType=null;
var gwWin=null;
var is_btns_cgo_clm_stl_dt=true;
var is_btns_currency=true;
var is_btns_roe=true;
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
    //조회조건 멀티콤보용
    frm2=document.form2;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
	// IBMultiComboinitializing
	combo1=comboObjects[0];
	comboCnt=comboObjects.length;	
	for(var j=0; j<comboCnt; j++){				
		initCombo(comboObjects[j],j+1);
	}
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);   
    }
	initComboBox();
    initControl();
    //ClaimNo 가 없을경우 권한
	setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn1_Cancel,btn1_Approval,btn1_Reject");
    if(frm.cgo_clm_no.value.length == 10){
		doActionIBSheet(SEARCHLIST01);
	}
}
/**
 * 초기 콤보 설정
 **/
function initComboBox() {
	 	var sXml2=frm2.sXml.value;
	 	var arrXml=sXml2.split("|$$|");	 		 
	 	setMultiComboBox("combo1" ,  arrXml[0] ); //07		
	 	combo1.InsertItem(0, "", "");
	 	
	 	var dataCount=ComGetTotalRows(arrXml[1]);
	 	if (dataCount > 0) {
	 		var list=SheetXml2ListMap(arrXml[1]);	
	 		var listVO=list[0];
	 		clmAreaCd=listVO["clm_area_cd"];
	 		ComSetObjValue(frm.clm_area_cd,clmAreaCd );
		} else {
			var popwin=popupClientDefault(); //calling setup display not existing Area Code
			popwin.focus();
		}
}
 /**
 * IBMultiComboBox 설정<br>
 * @param {select box} 콤보 객체
 * @param {xml} code , name의 xml
 * @param {String} 초기 선택 Code 
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
// 	for ( var idx=1; idx < vArrayListData.length; idx=idx+2) {
 	for ( var idx=0; idx < vArrayListData.length; idx++) {
 	    vListData=vArrayListData[idx];
 		vCaptionText=vListData.code + "|" + vListData.name;
 		vComboObj.InsertItem(idx, vCaptionText, vListData.code);
 	}//end for
 }
 function initCombo(comboObj, comboNo) {
		with (comboObj) {
			comboObj.SetMultiSelect(0);
//no support[check again]CLT 			comboObj.UseCode=true;
//no support[check again]CLT 			comboObj.LineColor="#ffffff";			
			comboObj.SetMultiSeparator(",");
			comboObj.SetDropHeight(190);
			comboObj.SetBackColor("#CCFFFD");
			if(comboNo==3){
				comboObj.SetColAlign(0, "right");
				comboObj.SetColAlign(1, "right");
			}
		}
	} 
function combo1_OnChange(comboObj,Index_Code, Text){  	
	if(frm.cgo_clm_no.value.length == 10){	
		setDisplayAction();
		//setDosAndAmtClear();
	}
} 
/**
 * registering IBTab Object as list 
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
*/
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
*/
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
		with (tabObj) {
			var cnt=0 ;
			InsertItem( "Opinion on Settlement" , "");
			InsertItem( "Prevention" , "");
			InsertItem( "Approver's Comment" , "");
		}
		break;
	}
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
*/
function tab1_OnChange(tabObj , nItem){
	var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab=nItem;
}
/**
* registering initial event 
*/
function initControl() {
   //keypress
   //axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   //keydown
   //axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
   //key up
   axon_event.addListenerForm('keyup', 'obj_keyup', frm); 
   // focus in
//   axon_event.addListenerForm('blur', 'obj_deactivate',  frm);
   // focus out
//   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
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
            if (location.hostname != "") {
            }
            var HeadTitle1="";
            var headCount=ComCountHeadTitle(HeadTitle1);
            (headCount, 0, 0, true);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
             
            InitColumns(cols);
            SetWaitImageVisible(0);
            SetEditable(1);
            SetVisible(0);
			break;		
		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
/**
 * setting Location
 */
 function setCurrency(rowArray) { 
    frm.cgo_clm_stl_locl_curr_cd.value=rowArray[0][2];
	if(rowArray[0][2] == "USD"){
		frm.cgo_clm_stl_xch_rt.value="1.00000";
	}
	frm.cgo_clm_stl_xch_rt.focus;
 }
// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal=new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
}
  /**
   *  팝업에서 Call 하는 함수
   */
  function setMainCodeInquiry(partyVo) {
  	frm.clm_pty_no.value=partyVo.clm_pty_no;
  	frm.clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
  	frm.pty_nm.value=partyVo.pty_nm;
   } 
function addComma2(obj,sFormat)
{
	try {
		//첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
		var sVal=getArgValue(obj);
		switch(sFormat)
		{
			case "#,###" :
					return ComAddComma(sVal);
			case "#,###.0" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".0";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".00";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00000" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".00000";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}
/**
* ROE 입력후 cgo_clm_stl_usd_amt 설정
* USD 항목에 계산값 Setup = ( Survey Fee / R.O.E )
* 소수점 세자리에서 반올림.
* onblur / enter / save 버튼 눌렀을때
*/
function setStlUsdAmt() { 
	var cgo_clm_stl_locl_amt=frm.cgo_clm_stl_locl_amt.value;
	var cgo_clm_stl_xch_rt=frm.cgo_clm_stl_xch_rt.value;
	var tmpUsdAmt="";
	var tmpUsdAmt2="";
	
	if( cgo_clm_stl_xch_rt.indexOf('.0')==0 || cgo_clm_stl_locl_amt.indexOf('.0')==0 ){
		return;
	}
	if(cgo_clm_stl_xch_rt != "" && cgo_clm_stl_xch_rt != "0"){
		var floatLoclAmt=parseFloat(ComReplaceStr(cgo_clm_stl_locl_amt,",",""));//콤마제거
      var floatXchRt=parseFloat(ComReplaceStr(cgo_clm_stl_xch_rt,",",""));
		tmpUsdAmt=roundPrecision(floatLoclAmt / floatXchRt,2);
		frm.cgo_clm_stl_usd_amt.value=tmpUsdAmt;
		tmpUsdAmt2=ComAddComma2(frm.cgo_clm_stl_usd_amt.value,"#,###.00");//변수에 comma를 처리하려고 했으나 안됨.
		frm.cgo_clm_stl_usd_amt.value=tmpUsdAmt2;//콤마 format 적용.
		//frm.cgo_clm_stl_xch_rt.value = "";
		//frm.cgo_clm_stl_xch_rt.value = ComAddComma2(cgo_clm_stl_xch_rt,"#,###.00");
	}else{
		
		frm.cgo_clm_stl_usd_amt.value="";
	}
}
/**
* ROE 팝업에서 호출하는 함수
*/
function setCurrencyROE(xchRtVo) {
	frm.cgo_clm_stl_locl_curr_cd.value=xchRtVo.curr_cd;
	frm.cgo_clm_stl_xch_rt.value=xchRtVo.usd_locl_xch_rt;
	setStlUsdAmt();	
} 
function setCurrRt() { 
	if(frm.cgo_clm_stl_locl_curr_cd.value == "USD"){
		frm.cgo_clm_stl_xch_rt.value="1.00000";
		setStlUsdAmt();
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
				var cgoClmNo=frm.cgo_clm_no.value;
				if (ComIsNull(cgoClmNo)) {
					//msgs["CNI00018"] = "Please select {?msg1}";
					ComShowCodeMessage("CNI00009" , "Claim No");
					ComSetFocus(frm.cgo_clm_no);
					return;
				}
				doActionIBSheet(SEARCHLIST01);			
				break;	
			case "btn1_New":
				//CNI00015 Do you want to initialize?
				if (ComShowCodeConfirm("CNI00015") ) {
					setDosAndAmt(true,true);
					combo1.SetEnable(1);
					ComResetAll();
					resetHiddenField(frm);
					frm.cgo_clm_no.value="";
					ComSetFocus(frm.cgo_clm_no);
				}
				break;
			case "btn1_Save":
				if(!validateForm(sheet1,frm,MULTI)) return;
				frm.f_cmd.value=MULTI;
				if(combo1.GetSelectCode()==''){
					ComShowCodeMessage("CNI00018" , "TOS");
					ComSetFocus(combo1);
					return;
				}							
				if(ComChkValid(frm)) {
					//CNI00012(Do you want to save changes?)
					if (ComShowCodeConfirm("CNI00012")) {
						doActionIBSheet(MULTI);
					}
				}			
				break;
			case "btn1_Approval":
				frm.clm_stl_auth_cd.value="Y";	// Approval		
				if(ComChkValid(frm)) {
					//msgs["CNI00014"] = "Do you want to execute?";
					if (ComShowCodeConfirm("CNI00014")) {
						doActionIBSheet(MULTI02);
					}
				}			
				break; 	
			case "btn1_Reject":
				frm.clm_stl_auth_cd.value="N";   // Reject
				if(ComChkValid(frm)) {
					//msgs["CNI00014"] = "Do you want to execute?";
					if (ComShowCodeConfirm("CNI00014")) {
						doActionIBSheet(MULTI02);
					}
				}			
				break; 					
			case "btn1_File_Upload":				
				var cgoClmNo=frm.cgo_clm_no.value;
				if (ComIsNull(cgoClmNo)) {
					//ComShowCodeMessage("CNI00009" , "Claim No.");
					ComShowMessage("Please use after retrieve or save");//CNI00103
				}else{
					popupFileUpload("001501" , cgoClmNo);
				}
				break;
			case "btn1_Cancel":
				if(ComChkValid(frm)) {
					//CNI09025(Do you really want to cancel this?)
					if (ComShowCodeConfirm("CNI09025")) {
						doActionIBSheet(MULTI01);
					}
				}			
				break;	
			case "btn1_Payment":
				var cgoClmNo=frm.cgo_clm_no.value;	
				popupPayment(cgoClmNo);
				break;
			case "btn1_Handler":
				var cgoClmNo=frm.cgo_clm_no.value;	
				popupHandlerHistory(cgoClmNo);
				break;
			case "btns_liable_party":
				popupMainCodeInquiry();
				break;	
			case "btns_hndl_ofc_cd":
				popupOfficeCode();
				break;		
			case "btns_style":
				
				
				var clmPtyNo=frm.clm_pty_no.value;
				if (ComIsNull(clmPtyNo)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "");
					ComSetFocus(frm.clm_pty_abbr_nm);
					return;
				}else{
					popupMainCodeView(clmPtyNo);
				}
				break;	
			case "btns_currency":
				//공통팝업 Currency 호출
				var display="1,0,1,1,1";
				if(is_btns_currency){
					ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 700, 450, "setCurrency", display);
				}
				setStlUsdAmt();
				break;
			case "btns_roe":
				if(! is_btns_roe)  return;
				var curr_cd=frm.cgo_clm_stl_locl_curr_cd.value;
				if (ComIsNull(curr_cd)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Currency Code");
					ComSetFocus(frm.cgo_clm_stl_locl_curr_cd);
					return;
				}
				var sts=frm.clm_misc_cd.value;
				var tos=combo1.GetSelectCode();
				var stl_dt=frm.cgo_clm_stl_dt.value;
				if( sts!='V' || tos=='CM'|| tos=='PD' ){
				}else{
						if (ComIsNull(stl_dt)) {
							//msgs["CNI00009"] = "Please input {?msg1}";
							ComShowCodeMessage("CNI00009" , "DOS");
							ComSetFocus(frm.cgo_clm_stl_dt);
							return;
						}
				}
				//공통팝업 ROE 호출
				var yrMon='';
				if(stl_dt!=''){
				   yrMon=ComReplaceStr(frm.cgo_clm_stl_dt.value,"-","").substring(0,6);
				}
				roeType=1;
				popupRateOfExchange(curr_cd, yrMon);
				setStlUsdAmt();
				break;	
			//-----------------[달력 Start]------------------//		
			case "btns_cgo_clm_stl_dt":
				if(is_btns_cgo_clm_stl_dt){
					calendarDisplay(frm.cgo_clm_stl_dt);
				}
	            break;
	        //-----------------[달력 End]------------------//         
		} // end switch
}
/**
 * HTML Control KeyPress event
 */
function obj_keypress() {
    switch (ComGetEvent("name")) {		
		case "cgo_clm_stl_xch_rt":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "cgo_clm_stl_locl_curr_cd":
			ComKeyOnlyAlphabet('upper');
			break;	
	}
}
 /**
  * HTML Control KeyDowm event
  */
 function obj_keydown() {
	  if((ComGetEvent("keycode") >= 37)&&(ComGetEvent("keycode") <= 40)) return;
	  switch (ComGetEvent("name")) {  
 		case "cgo_clm_no":
 			break;
 	}
 }
  /**
   * HTML Control KeyUp event
   */
  function obj_keyup() {
	   if((ComGetEvent("keycode") >= 37)&&(ComGetEvent("keycode") <= 40)) return;
	   switch (ComGetEvent("name")) {    
  		case "cgo_clm_no":
  			if(frm.cgo_clm_no.value.length == 10){
  				doActionIBSheet(SEARCHLIST01);
  			}
  			break;	
  	}
  }  
 /**
  * HTML Control Focus out
  **/
 function obj_deactivate() {	 
 	var frm=document.form;
 	switch (ComGetEvent("name")) {
 	case "cgo_clm_stl_locl_amt":	
 		if( frm.cgo_clm_stl_xch_rt.value.indexOf('.0')==0 || 
 				frm.cgo_clm_stl_locl_amt.value.indexOf('.0')==0){  			
 			return;
 		}
 		setStlUsdAmt();
 		ComAddSeparator(frm.cgo_clm_stl_locl_amt,"float");
 		break;
 	case "cgo_clm_stl_xch_rt":	
 		if( frm.cgo_clm_stl_xch_rt.value.indexOf('.0')==0 || 
 				frm.cgo_clm_stl_locl_amt.value.indexOf('.0')==0){  			
 			return;
 		}
 		
 		setStlUsdAmt();
 		ComAddSeparator(frm.cgo_clm_stl_locl_amt,"float");
 		break;		
 	default:
 		ComChkObjValid(ComGetEvent());
 	}
 }
/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(ComGetEvent());
}
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case SEARCHLIST01:
			frm.f_cmd.value=SEARCHLIST01;
 			var sXml=sheet1.GetSearchData("CPS_CNI_0014GS.do", FormQueryString(frm),"",true);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) {			
				var list=SheetXml2ListMap(arrXml[0]);	
				if (list.length > 0) {
					for (var j=0;j<list.length;j++)
					{
						if(list[j]!=undefined){
							var dataVO=list[j];
							break;
						}
					}
					frm.clm_stl_auth_cd.value=dataVO["clm_stl_auth_cd"];
					frm.clm_misc_cd.value=dataVO["clm_misc_cd"];
					// ComSetObjValue 호출 위치 주의
					ComSetObjValue(combo1, dataVO["cgo_clm_stl_tp_cd"]);
					frm.combo1_text.value=dataVO["cgo_clm_stl_tp_cd"];
					setDisplayAction();
					frm.cgo_clm_no.value=dataVO["cgo_clm_no"];
					frm.clm_area_cd.value=dataVO["clm_area_cd"];
					frm.hdlr_ofc_cd.value=dataVO["hdlr_ofc_cd"];
					frm.hdlr_usr_id.value=dataVO["hdlr_usr_id"];
					frm.upd_dt.value=dataVO["upd_dt"];
					frm.cgo_clm_inci_no.value=dataVO["cgo_clm_inci_no"];
					frm.crm_voc_no.value=dataVO["crm_voc_no"];
					frm.clm_misc_nm.value=dataVO["clm_misc_nm"];
					frm.hpc.value=dataVO["hpc"];
					frm.nhp.value=dataVO["nhp"];					
					frm.clm_tm_bar_dt.value=dataVO["clm_tm_bar_dt"];
					frm.smns_sve_dt.value=dataVO["smns_sve_dt"];
					frm.cgo_clm_tp_cd.value=dataVO["cgo_clm_tp_cd"];
					frm.tm_bar_dt.value=dataVO["tm_bar_dt"];										
					frm.mjr_clm_dmg_lss_cd.value=dataVO["mjr_clm_dmg_lss_cd"];
					frm.minr_clm_dmg_lss_cd.value=dataVO["minr_clm_dmg_lss_cd"];
					frm.inci_plc_tp_cd.value=dataVO["inci_plc_tp_cd"];
					frm.inci_occr_dt.value=dataVO["inci_occr_dt"];					
					frm.clm_cgo_tp_cd.value=dataVO["clm_cgo_tp_cd"];				
					frm.cgo_qlty_desc.value=dataVO["cgo_qlty_desc"];
					frm.clmt_locl_amt.value=ComAddComma2(dataVO["clmt_locl_amt"],"#,###.00");	
					frm.clmt_locl_curr_cd.value=dataVO["clmt_locl_curr_cd"];
					frm.fmal_clm_rcv_dt.value=dataVO["fmal_clm_rcv_dt"];
					frm.clmt_locl_xch_rt.value=addComma2( dataVO["clmt_locl_xch_rt"],"#,###.00000");
					frm.clmt_usd_amt.value=ComAddComma2(dataVO["clmt_usd_amt"],"#,###.00");	
					frm.cgo_clm_stl_locl_amt.value=ComAddComma2( dataVO["cgo_clm_stl_locl_amt"],"#,###.00");					
					frm.cgo_clm_stl_dt.value=dataVO["cgo_clm_stl_dt"];					
					frm.cgo_clm_stl_usd_amt.value=ComAddComma2(dataVO["cgo_clm_stl_usd_amt"],"#,###.00");	
					frm.clm_pty_no.value=dataVO["clm_pty_no"];										
					frm.clm_pty_abbr_nm.value=dataVO["clm_pty_abbr_nm"];				
					frm.pty_nm.value=dataVO["pty_nm"];		
					frm.labl_pty_dmnd_amt.value=ComAddComma2( dataVO["labl_pty_dmnd_amt"],"#,###.00");
					frm.labl_pty_dmnd_curr_cd.value=dataVO["labl_pty_dmnd_curr_cd"];								
					frm.labl_pty_fmal_clm_dt.value=dataVO["labl_pty_fmal_clm_dt"];				
					frm.labl_pty_xch_rt.value=addComma2( dataVO["labl_pty_xch_rt"],"#,###.00000");							
					frm.labl_pty_dmnd_usd_amt.value=ComAddComma2( dataVO["labl_pty_dmnd_usd_amt"],"#,###.00");
					frm.labl_pty_rcvr_locl_amt.value=ComAddComma2( dataVO["labl_pty_rcvr_locl_amt"],"#,###.00");
					frm.labl_pty_rcvr_locl_curr_cd.value=dataVO["labl_pty_rcvr_locl_curr_cd"];								
					frm.labl_pty_rcvr_dt.value=dataVO["labl_pty_rcvr_dt"];				
					frm.labl_pty_rcvr_locl_xch_rt.value=addComma2( dataVO["labl_pty_rcvr_locl_xch_rt"],"#,###.00000");									
					frm.labl_pty_rcvr_usd_amt.value=ComAddComma2( dataVO["labl_pty_rcvr_usd_amt"],"#,###.00");
//					frm.cgo_clm_stl_rmk.value=dataVO["cgo_clm_stl_desc"];
					frm.cgo_clm_stl_desc.value=dataVO["cgo_clm_stl_desc"];
					ComSetObjValue(frm.cgo_clm_stl_locl_curr_cd, dataVO["cgo_clm_stl_locl_curr_cd"]);
					frm.cgo_clm_stl_xch_rt.value=addComma2( dataVO["cgo_clm_stl_xch_rt"],"#,###.00000");	
					frm.insur_rcvr_usd_amt.value=dataVO["insur_rcvr_usd_amt"];	
					//frm.clm_stl_auth_cd_nm.value =  dataVO["clm_stl_auth_cd_nm"];
					//frm.clm_stl_auth_no.value = dataVO["clm_stl_auth_no"];
					frm.clm_stl_auth_rmk.value=dataVO["clm_stl_auth_rmk"];
					frm.clm_stl_appl_dt.value=dataVO["clm_stl_appl_dt"];
					frm.clm_stl_appl_usr_id.value=dataVO["clm_stl_appl_usr_id"];
					frm.clm_stl_appl_ofc_cd.value=dataVO["clm_stl_appl_ofc_cd"];
					frm.clm_stl_auth_dt.value=dataVO["clm_stl_auth_dt"];
					frm.clm_stl_auth_usr_id.value=dataVO["clm_stl_auth_usr_id"];
					frm.clm_stl_auth_ofc_cd.value=dataVO["clm_stl_auth_ofc_cd"];
//					frm.cgo_clm_stl_desc.value=dataVO["cgo_clm_stl_rmk"];
					frm.cgo_clm_stl_rmk.value=dataVO["cgo_clm_stl_rmk"];
					frm.clm_stl_appl_dt2.value=dataVO["clm_stl_appl_dt"];
					frm.clm_stl_appl_usr_id2.value=dataVO["clm_stl_appl_usr_id"];
					frm.clm_stl_appl_ofc_cd2.value=dataVO["clm_stl_appl_ofc_cd"];
					frm.clm_stl_auth_dt2.value=dataVO["clm_stl_auth_dt"];
					frm.clm_stl_auth_usr_id2.value=dataVO["clm_stl_auth_usr_id"];
					frm.clm_stl_auth_ofc_cd2.value=dataVO["clm_stl_auth_ofc_cd"];
					frm.clm_stl_appl_dt3.value=dataVO["clm_stl_appl_dt"];
					frm.clm_stl_appl_usr_id3.value=dataVO["clm_stl_appl_usr_id"];
					frm.clm_stl_appl_ofc_cd3.value=dataVO["clm_stl_appl_ofc_cd"];
					frm.clm_stl_auth_dt3.value=dataVO["clm_stl_auth_dt"];
					frm.clm_stl_auth_usr_id3.value=dataVO["clm_stl_auth_usr_id"];
					frm.clm_stl_auth_ofc_cd3.value=dataVO["clm_stl_auth_ofc_cd"];
					var clm_stl_auth_cd=frm.clm_stl_auth_cd.value;
					// Role
					setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn1_Cancel,btn1_Approval,btn1_Reject");
					if (clm_stl_auth_cd == "Y" || clm_stl_auth_cd == "N") {
						ComBtnDisable("btn1_Cancel");
						ComBtnDisable("btn1_Approval");
						ComBtnDisable("btn1_Reject");
					}
					var sts=frm.clm_misc_cd.value;
					if( sts != 'A' && sts != 'J'){
						ComBtnDisable("btn1_Cancel");
						ComBtnDisable("btn1_Approval");
						ComBtnDisable("btn1_Reject");
					}
					if (sts == "C" || sts == "X") {
						ComBtnDisable("btn1_Approval");
						ComBtnDisable("btn1_Reject");
						ComBtnDisable("btn1_Save");
						ComBtnDisable("btn1_Cancel");
					} 
				} else {
					ComResetAll();
					if(frm.cgo_clm_no.value == ""){
						//msgs["CNI00013"] = "There is no data to search.";
						ComShowCodeMessage("CNI00013");
					}
					ComBtnDisable("btn1_Approval");
					ComBtnDisable("btn1_Reject");
				}
	        }
			break;
		case MULTI:
			frm.f_cmd.value=MULTI;
			setStlUsdAmt();
			frm.cgo_clm_stl_tp_cd.value=combo1.GetSelectCode();
			//sepatator 제거
			frm.cgo_clm_stl_dt.value=ComReplaceStr(frm.cgo_clm_stl_dt,'-','');
			frm.clm_stl_appl_dt.value=ComReplaceStr(frm.clm_stl_appl_dt,'-','');
			frm.clm_stl_auth_dt.value=ComReplaceStr(frm.clm_stl_auth_dt,'-','');
			frm.cgo_clm_stl_usd_amt.value=ComReplaceStr(frm.cgo_clm_stl_usd_amt,',','');
			frm.cgo_clm_stl_locl_amt.value=ComReplaceStr(frm.cgo_clm_stl_locl_amt,',','');			
			frm.cgo_clm_stl_xch_rt.value=ComReplaceStr(frm.cgo_clm_stl_xch_rt,',','');
			frm.labl_pty_dmnd_usd_amt.value=ComReplaceStr(frm.labl_pty_dmnd_usd_amt,',','');
			frm.labl_pty_rcvr_usd_amt.value=ComReplaceStr(frm.labl_pty_rcvr_usd_amt,',','');
			frm.insur_rcvr_usd_amt.value=ComReplaceStr(frm.insur_rcvr_usd_amt,',','');
			//amt 디폴트값세팅
			if(frm.cgo_clm_stl_usd_amt.value == ""){
				frm.cgo_clm_stl_usd_amt.value="0";
			}
			if(frm.cgo_clm_stl_locl_amt.value == ""){
				frm.cgo_clm_stl_locl_amt.value="0.00";
			}
			if(frm.labl_pty_dmnd_usd_amt.value == ""){
				frm.labl_pty_dmnd_usd_amt.value="0";
			}
			if(frm.labl_pty_rcvr_usd_amt.value == ""){
				frm.labl_pty_rcvr_usd_amt.value="0";
			}
			if(frm.insur_rcvr_usd_amt.value == ""){
				frm.insur_rcvr_usd_amt.value="0";
			}
			var param="";
			param += FormQueryString(frm);			
			var saveString=sheet1.GetSaveString();
			/*
			if (sheet1.IsDataModified()&& ComIsNull(saveString))  {
				return;
			}
			if (ComIsNull(saveString))  { 
			   //msgs["CNI00022"] = "There is no contents to save.";
			   ComShowCodeMessage("CNI00022");
			   return;
			}
			*/
			param += "&" + saveString;	
 			var sXml=sheet1.GetSaveData("CPS_CNI_0014GS.do", param);
 			sheet1.LoadSaveData(sXml);
			//main에 없는 clm_no 를 입력하려고 할경우 에러처리하고 재조회하지 않는다.
			var manageStr="";
			manageStr=ComGetEtcData(sXml, "MANAGE_STR");	
			if(manageStr == "N"){
				ComResetAll();
			}
			if(manageStr == "Y"){
				//재조회
				doActionIBSheet(SEARCHLIST01);
			}
			break;
		case MULTI01:    // CANCEL
			frm.f_cmd.value=MULTI01;
			var param="";
			param += FormQueryString(frm);
			var saveString=sheet1.GetSaveString();
			param += "&" + saveString;	
 			var sXml=sheet1.GetSaveData("CPS_CNI_0014GS.do", param);
 			sheet1.LoadSaveData(sXml);
			var errorStr="";
			errorStr=ComGetEtcData(sXml, "ERROR");	
			doActionIBSheet(SEARCHLIST01);
			break;
		case MULTI02:    // Application
			frm.f_cmd.value=MULTI02;
 			var sXml=sheet1.GetSearchData("CPS_CNI_0014GS.do", FormQueryString(frm),"",true);
 			sheet1.LoadSaveData(sXml);
			var errorStr="";
			errorStr=ComGetEtcData(sXml, "ERROR");	
			doActionIBSheet(SEARCHLIST01);
			break;		
	} //end of switch
}
function setOfficeCode(ofcCd){
	frm.hndl_ofc_cd.value=ofcCd;
}
function setDisplayAction() {
	var sts=frm.clm_misc_cd.value;
	var tos=combo1.GetSelectCode();
	var clm_stl_auth_cd=frm.clm_stl_auth_cd.value;
	if( sts=='N'||sts=='F'||sts=='L'||sts=='A'||sts=='J' ){
		if( tos=='RP'||tos=='TB'||tos=='WD'||tos=='TD'||tos=='DS'){
			setDosAndAmt(true,false);
			combo1.SetEnable(1);
			setSettledClear();
		}else{
			setDosAndAmt(false,true);
			combo1.SetEnable(1);
			setSettledClear();
		}
	}else if( sts=='V'){
		if( tos=='CM'||tos=='PD'){
			setDosAndAmt(true,false);	
			combo1.SetEnable(0);
		}else{
			setDosAndAmt(false,false);	
			combo1.SetEnable(0);
		}
	}else if( sts=='R' ){
		if( clm_stl_auth_cd == 'Y'){
				setDosAndAmt(false,false);
				combo1.SetEnable(0);
		}else{
			if( tos=='RP'||tos=='TB'||tos=='WD'||tos=='TD'||tos=='DS'){
				setDosAndAmt(true,false);
				combo1.SetEnable(1);
				setSettledClear();
			}else{
				setDosAndAmt(false,true);
				combo1.SetEnable(1);
				setSettledClear();
			}
		}
	}else{
		setDosAndAmt(false,false);
		combo1.SetEnable(0);
	}	
}
function setDosAndAmt(sign1,sign2){
	// DOS 
	if(sign1){
		frm.cgo_clm_stl_dt.readOnly=false;
		is_btns_cgo_clm_stl_dt=true;
		frm.cgo_clm_stl_dt.className="input1";
		frm.cgo_clm_stl_dt.setAttribute("required","");
	}else{
		frm.cgo_clm_stl_dt.readOnly=true;
		is_btns_cgo_clm_stl_dt=false;		
		frm.cgo_clm_stl_dt.className="input2";
		frm.cgo_clm_stl_dt.removeAttribute("required");
		frm.cgo_clm_stl_dt.value=''; 
	}
	// Amount
	if(sign2){
		frm.cgo_clm_stl_locl_amt.readOnly=false;
		frm.cgo_clm_stl_locl_curr_cd.readOnly=false;
		is_btns_currency=true;
		frm.cgo_clm_stl_xch_rt.readOnly=false;
		is_btns_roe=true;
		frm.cgo_clm_stl_locl_amt.className="input1";
		frm.cgo_clm_stl_locl_curr_cd.className="input1";
		frm.cgo_clm_stl_xch_rt.className="input1";
		frm.cgo_clm_stl_locl_amt.setAttribute("required","");
		frm.cgo_clm_stl_locl_curr_cd.setAttribute("required","");
		frm.cgo_clm_stl_xch_rt.setAttribute("required","");
	}else{
		frm.cgo_clm_stl_locl_amt.readOnly=true;
		frm.cgo_clm_stl_locl_curr_cd.readOnly=true;
		is_btns_currency=false;
		frm.cgo_clm_stl_xch_rt.readOnly=true;
		is_btns_roe=false;
		frm.cgo_clm_stl_locl_amt.className="input2";
		frm.cgo_clm_stl_locl_curr_cd.className="input2";
		frm.cgo_clm_stl_xch_rt.className="input2";
		frm.cgo_clm_stl_locl_amt.removeAttribute("required");
		frm.cgo_clm_stl_locl_curr_cd.removeAttribute("required");
		frm.cgo_clm_stl_xch_rt.removeAttribute("required");
//		frm.cgo_clm_stl_locl_amt.value = '0';
//		frm.cgo_clm_stl_locl_curr_cd.value = '';
//		frm.cgo_clm_stl_xch_rt.value = '0';
	}
}
function setSettledClear(){
	frm.cgo_clm_stl_locl_amt.value='0.00';
	frm.cgo_clm_stl_locl_curr_cd.value='';
	frm.cgo_clm_stl_xch_rt.value='0';
	frm.cgo_clm_stl_usd_amt.value='0';
}
function setDosAndAmtClear(){	
	frm.cgo_clm_stl_dt.value='';
	frm.cgo_clm_stl_locl_amt.value='0.00';
	frm.cgo_clm_stl_locl_curr_cd.value='';
	frm.cgo_clm_stl_xch_rt.value='0';
}
/**
* Amount, currency, date, and the exchange rate at the input of the other three input fields, checking whether all
*/
function chkAmount(objLoclAmt, objCurrCd, objXchRt, msg1, msg2) {
	    var loclAmt=cniParseFloat(objLoclAmt);
	 	var xchRt=cniParseFloat(objXchRt);
		var currCd=objCurrCd.value.trim();
		if (loclAmt == 0 && ComIsNull(currCd) && xchRt == 0) {
			return true;
		} else if (loclAmt != 0 && !ComIsNull(currCd) && xchRt != 0) {
			return true;
		} else {
			if (loclAmt == 0) {
		    	ComAlertFocus(objLoclAmt, ComGetMsg('CNI09028',msg1));
				return false;
	       	} else if (ComIsNull(currCd)) {
		    	ComAlertFocus(objCurrCd, ComGetMsg('CNI09028',msg1+"(Currency)"));
				return false;
	       	} else if (xchRt == 0) {
		    	ComAlertFocus(objXchRt, ComGetMsg('CNI09028',msg1+"(R.O.E)"));
				return false;
	       	} 
		}
		return true;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (sAction == MULTI) {
			if (!chkAmount(frm.cgo_clm_stl_locl_amt, frm.cgo_clm_stl_locl_curr_cd, frm.cgo_clm_stl_xch_rt, "Settled Amount", "Settled Date")) return;
		}
	}
	return true;
}
