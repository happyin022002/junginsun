/*--==============================================================================
'주  시 스 템 : ESD_TES_0034.jsp
'서브  시스템 : 자바스크립트
'프로그램 ID  : ESD_TES_0034.js
'프로그램 명  : Terminal / Storage Agreement Rate Input/List 각 이벤트 처리
'프로그램개요 : Terminal / Storage Agreement Rate Input/List 각 이벤트 처리
*@LastModifyDate : 2009.08.24
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.24 yOng hO lEE
* 2009-04-30 [N200904300360] : AGMT Mode Verify 통과 로직 변경
* 2016-01-04 [CHM-201539189]DG(NONE) 숨김처리
* 2016-01-25 [CHM-201539541]A5 Container Type/Size 추가
==============================================================================--*/
/****************************************************************************************
 * 1. Agreement Creation Function
 * 2. Agreement Rate List Input
 * 3. Agreement Terminal Rate List 데이터 및 조합 검증 처리
 * 4. Agreement Storage Rate List 데이터 및 조합 검증 처리
 * 
 ***************************************************************************************/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_TES_0034 : ESD_TES_0034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TES_0034() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.doActionIBSheet2 		= doActionIBSheet2;
    	this.doActionIBSheet3 		= doActionIBSheet3;
    	this.doActionIBSheet4 		= doActionIBSheet4;
    	this.doActionIBSheet5 		= doActionIBSheet5;
    	this.doActionIBSheet6 		= doActionIBSheet6;
    	this.doActionIBSheet7 		= doActionIBSheet7;
    	this.doActionIBSheet8 		= doActionIBSheet8;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
   
// 공통전역변수
var tabObjects	= new Array();
var tabCnt		= 0 ;
var beforetab	= 1;

var sheetObjects	= new Array();
var sheetCnt		= 0;

var comboObjects	= new Array();
var comboCnt		= 0 ;

var verifyObjects	= "";
var thrpCostFlg		= "";
var doActionIBSheet6SearchFlg  = "";
var tab2VerifyFlg	= true; ///"";
var tab4VerifyFlg	= true; // "";
var tab2VerifyCount	= "";
var tab4VerifyCount = "";
var costCodeT		= "";
var costCodeS		= "";

var lgsCostCDSheet  = "";
var terminalLgsCostCDSheet	= "";
var storageLgsCostCDSheet	= "";
var terminalLgsCostCDName	= "";
var storageLgsCostCDName	= "";

var tplgsCostCDSheet	= "";
var currCDSheet		= "";
var laneCDSheet1	= "";
var laneCDSheet2	= "";

var agmtNoCopy	= "";
var agmtVerCopy	= "";

var dataTerminalErrCount	= 0;
var dataStorageErrCount		= 0;

var agmtRegFlg		= "";
var hdrRetrieveFlg	= "";
var currCodeDef		= "";

var	arrCntrTpSz	= ["d2", "d4", "d5", "d7", "d8", "d9", "dw", "dx"
		, "r2", "r4", "r5", "r7", "r8", "r9"
		, "f2", "f4", "f5"
		, "o2", "o4", "o5", "o7"
		, "s2", "s4"
		, "t2", "t4"
		, "a2", "a4", "a5"
		, "p2", "p4"
		, "c2", "c4"];
/**
 * // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
 */
document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		var sheetObject5 = sheetObjects[5]; //t1sheet3
		var sheetObject6 = sheetObjects[6];
		var sheetObject7 = sheetObjects[7];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName	= window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					sheetObject2.RemoveAll();
					
					if (ComIsNull(formObject.yd_cd.value)){
						ComShowCodeMessage('TES10009');    //Please enter Yard Code.
						formObject.yd_cd.focus();
						return false;
					}
					
					if (ComIsNull(formObject.yd_cd_name.value)){
						ComShowCodeMessage('TES10010');     //There is no Yard Code Name.\n\n Please enter Yard Code again.
						formObject.yd_cd.focus();
						return false;
					}
					
					if (ComIsNull(formObject.vndr_seq.value)){
						ComShowCodeMessage('TES10011');    //Please enter Service Provider Code.
						formObject.vndr_seq.focus();
						return false;
					}
					
					if(formObject.inquiryFlg.value!="Y"){
						if (formObject.vndr_seq_name.value==""){
							ComShowCodeMessage('TES10011');  //Please enter Service Provider Code.
							return false;
						}
					}
					
					switch(tabObjects[0].selectedIndex) {
						case 0:
							formObject.tml_agmt_tp_cd.value	= "T";
							formObject.f_cmd.value			= SEARCH ;
							doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
							
							if(doActionIBSheet6SearchFlg != "NoData"){
								doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
							}
							formObject.tml_agmt_tp_cd.value	= "S";
							formObject.f_cmd.value			= SEARCH ;
							
							if(doActionIBSheet6SearchFlg!="NoData"){
								doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
							}
						break;
						
						case 1:
							formObject.tml_agmt_tp_cd.value	= "T";
							formObject.f_cmd.value			= SEARCH ;
							doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
							
							if(doActionIBSheet6SearchFlg != "NoData"){
								doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
							}
							formObject.tml_agmt_tp_cd.value	= "S";
							formObject.f_cmd.value			= SEARCH ;
							
							if(doActionIBSheet6SearchFlg != "NoData"){
								doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
							}
						break;
						case 2:
							formObject.tml_agmt_tp_cd.value	= "S";
							formObject.f_cmd.value			= SEARCH ;
							doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
							
							if(doActionIBSheet6SearchFlg != "NoData"){
								doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
							}
							formObject.tml_agmt_tp_cd.value	= "T";
							formObject.f_cmd.value			= SEARCH ;
							
							if(doActionIBSheet6SearchFlg!="NoData"){
								doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
							}
						break;
						case 3:
							formObject.tml_agmt_tp_cd.value	= "S";
							formObject.f_cmd.value			= SEARCH ;
							doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
							
							if(doActionIBSheet6SearchFlg != "NoData"){
								doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
							}
							formObject.tml_agmt_tp_cd.value	= "T";
							formObject.f_cmd.value			= SEARCH ;
							
							if(doActionIBSheet6SearchFlg != "NoData"){
								doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
							}
						break;
					}
				break;
				
				case "btn_new":
					agmt_no			= "";
					agmtRegFlg		= "";
					hdrRetrieveFlg	= "";
					formObject.reset();
					formObject.inquiryFlg.value		= "";
					formObject.tml_agmt_sts_cd.value= "";
					
					initFormValue();
					initFormDisabled();
					
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					sheetObject4.RemoveAll();
					sheetObject5.RemoveAll();
					
					formObject.yd_cd.readOnly		= false;
					formObject.vndr_seq.readOnly	= false;
					formObject.ctrt_ofc_cd.readOnly	= false;
					formObject.amend_flg[0].disabled= true;
					formObject.amend_flg[1].disabled= true;
				break;
				
				case "btn_delete":
					
					if((formObject.tml_agmt_ofc_cty_cd.value != "" || 
						formObject.tml_agmt_ofc_cty_cd.value != null) &&
						formObject.tml_agmt_ver_no.value != "" &&
						formObject.yd_cd.value != "" &&
						formObject.vndr_seq.value != "" )
					{
						if(ComShowConfirm(ComGetMsg('TES21055'))){
							window.showModalDialog("ESD_TES_9090.do?openerUIName=034", window, "dialogWidth:308px; dialogHeight:170px; help:no; status:no; resizable:yes;");
						}
					} else {
						ComShowCodeMessage('TES10003');    //There is no Agreement to be deleted.
					}
				break;
				
				case "btn_volcaam":
					window.showModalDialog("ESD_TES_9200.do", window, "dialogWidth:410px; dialogHeight:650px; help:no; status:no; resizable:yes;");
				break;
				
				// 비용지급 전표 결재 기능 - 3차 Contract Link 저장 - (4347-10-08)
				case "btn_contractsave":
					if ( chkAgmtNo(sheetObjects[5]) == true ) {
						// UPDATE Process
						doActionIBSheet6(sheetObject5, formObject, IBDELETE);
					}
					
				break;
				
				// 비용지급 전표 결재 기능 - 3차 Contract Link 삭제 - (4347-09-24)
				case "btn_contractdelete":
					if ( chkAgmtNo(sheetObjects[5]) == true ) {
						if ( ComShowConfirm(ComGetMsg('TES10134')) ) {
							formObject.agmt_doc_no.value = '';
							// DELETE UPDATE Process
							doActionIBSheet6(sheetObject5, formObject, IBDELETE);
						}
					}
					
					break;
					
				// 비용지급 전표 결재 기능 - 3차 Contract Link 추가 - (4347-09-24)	
				case "btn_contractlink":
					if ( chkAgmtNo(sheetObjects[5]) == false ) {
						return false;
					}
					
			    	// 비용지급 전표 결재 기능 - 3차
					var csrGwUrl = document.form.csr_gw_url.value;		// GroupWare URL
					// GW 호출
					callGwUrl(csrGwUrl, "CONTRACT");
					
				break;
					
				case "btn1_Attach_File":
					downform.submit();
				break;
					
				case "btn_yard":
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_061";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)
					
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 430, 'getYard', dispaly);
						
					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
				break;
				
				case "btn_vndr":
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_0C1";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)
					
                    // radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getVender', dispaly);
						
					} else {
						ComShowCodeMessage('TES10004'); //There is lack of data for pop-up display.
						return;
					}
				break;
				
				case "btns_calendar1":
					var cal = new ComCalendar();	//calendarPopup();
					cal.select(formObject.eff_fm_dt, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.select(formObject.eff_to_dt, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar3":
					var cal = new ComCalendar();
					cal.select(formObject.agmt_apro_dt, 'yyyy-MM-dd');
					
				break;				
				
				case "btns_calendar4":
					var cal = new ComCalendar();
					cal.select(formObject.agmt_cfm_dt, 'yyyy-MM-dd');
					
				break;			
				
				case "btn_save":
					var nowDate = ComGetNowInfo('ymd', '-');
					if(ComGetDaysBetween(nowDate, formObject.agmt_apro_dt.value)>0){
						ComShowCodeMessage('TES10137');		// "AGMT Approval Date must be inputted at earlier date than today.");
						ComSetFocus(formObject.agmt_apro_dt);
						return false;
					}
						
					if (ComIsNull(formObject.yd_cd.value)){
						ComShowCodeMessage('TES10009'); //Please enter Yard Code.
						return false;
					}

					if (ComIsNull(formObject.yd_cd_name.value)){
						ComShowCodeMessage('TES10010');   //There is no Yard Code Name.\n\n Please enter Yard Code again.
						return false;
					}
					
					if (ComIsNull(formObject.vndr_seq.value)){
						ComShowCodeMessage('TES10011');   //Please enter Service Provider Code.
						return false;
					}

					if (ComIsNull(formObject.ctrt_ofc_cd.value)){
						ComShowCodeMessage('TES10023');   // Please enter Contract Office.
						return false;
					}

					if(formObject.inquiryFlg.value != "Y" ){
						if (formObject.vndr_seq_name.value == "" ){
							ComShowCodeMessage('TES10011');     //Please enter Service Provider Code.
							return false;
						}
					}
					
					if(agmtRegFlg == "N"){
						ComShowCodeMessage('TES10095'); //These are saving canceled Yard code and vendor SEQ.\n\n Please check again.
						return false;
					}
					
					if(hdrRetrieveFlg != "Y"){
						ComShowCodeMessage('TES10096'); //Please check Agreement after Retrieve.
						return false;
					}
					
					if (ComIsNull(formObject.eff_fm_dt.value)){
						ComShowCodeMessage('TES10024');    //Please enter Effective Date.
						formObject.eff_fm_dt.focus();
						return false;
					}
					
					if (!ComIsDate(formObject.eff_fm_dt)){
						ComShowCodeMessage('TES10013');  //Date is not correct.
						formObject.eff_fm_dt.focus();
						return false;
					}
					
					if (!checkEffFormat(formObject.eff_fm_dt.value)){
						ComShowCodeMessage('TES10013');  //Date is not correct.
						formObject.eff_fm_dt.focus();
						return false;
					}
					
					if (ComIsNull(formObject.eff_to_dt.value)){
						ComShowCodeMessage('TES10013'); //Date is not correct.
						formObject.eff_to_dt.focus();
						return false;
					}
					
					if (!ComIsDate(formObject.eff_to_dt)){
						ComShowCodeMessage('TES10013');  //Date is not correct.
						formObject.eff_to_dt.focus();
						return false;
					}
					
					if (!checkEffFormat(formObject.eff_to_dt.value)){
						ComShowCodeMessage('TES10013');  //Date is not correct.
						formObject.eff_to_dt.focus();
						return false;
					}
					
					if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))){
						ComShowCodeMessage('TES10014');    //Please check Auto Ext.
						return false;
					}
					
					//20140408 추가됨
					if (ComIsNull(formObject.agmt_apro_dt.value)){
						ComShowCodeMessage('TES10135');		// "AGMT Approval Date is mandatory item for creation or update");
						formObject.agmt_apro_dt.focus();
						return false;
					}
					
					if (!ComIsDate(formObject.agmt_apro_dt)){
						ComShowCodeMessage('TES10136');		// "AGMT Approval Date is not correct.");
						formObject.agmt_apro_dt.focus();
						return false;
					}
					
					if (!checkEffFormat(formObject.agmt_apro_dt.value)){
						ComShowCodeMessage('TES10136');		// "AGMT Approval Date is not correct.");
						formObject.agmt_apro_dt.focus();
						return false;
					}
					
					//20140519 추가됨
					if (!ComIsNull(formObject.agmt_cfm_dt.value)){
						if (!ComIsDate(formObject.agmt_cfm_dt)){
							ComShowCodeMessage('TES10132');		// "AGMT Confirm Date is not correct.";
							formObject.agmt_cfm_dt.focus();
							return false;
						}
						
						if (!checkEffFormat(formObject.agmt_cfm_dt.value)){
							ComShowCodeMessage('TES10132');		// "AGMT Confirm Date is not correct.";
							formObject.agmt_cfm_dt.focus();
							return false;
						}
					}

					
					var agmtHdrRmkFlg = "";
					
					if(formObject.tml_agmt_sts_cd.value == "" ) {
  
						var iRow = 1;
						sheetObjects[5].RowStatus(iRow)	= "I";
						sheetObjects[5].CellValue2(iRow, "yd_cd")	= formObject.yd_cd.value;	// 3
						sheetObjects[5].CellValue2(iRow, "yd_nm")	= formObject.yd_cd_name.value;	// 4
						sheetObjects[5].CellValue2(iRow, "vndr_seq")= formObject.vndr_seq.value;		// 5
						sheetObjects[5].CellValue2(iRow, "vndr_lgl_eng_nm")	= formObject.vndr_seq_name.value;	// 6
						sheetObjects[5].CellValue2(iRow, "ctrt_ofc_cd")	= formObject.ctrt_ofc_cd.value;	// 7
						sheetObjects[5].CellValue2(iRow, "eff_fm_dt")	= formObject.eff_fm_dt.value;	// 8
						sheetObjects[5].CellValue2(iRow, "eff_to_dt")	= formObject.eff_to_dt.value;	// 9
						sheetObjects[5].CellValue2(iRow, "auto_xtd_flg")= getElementValue(formObject, 'radio', 'auto_xtd_flg');	// 10
						sheetObjects[5].CellValue2(iRow, "agmt_rmk")	= formObject.agmt_rmk.value;	// 12
						
						sheetObjects[5].CellValue2(iRow, "agmt_apro_dt")	= formObject.agmt_apro_dt.value;	// 9
						sheetObjects[5].CellValue2(iRow, "agmt_cfm_dt")	= formObject.agmt_cfm_dt.value;	// 


						if(agmtRegFlg == "Y" ) {
							topBtnSave_OnlyTopSave();
							agmtRegFlg  = "";
						}
						
					} else if(formObject.tml_agmt_sts_cd.value == "C") {

						// 8, 9, 10, 12
						if( sheetObjects[5].CellValue(1, "eff_fm_dt")	== formObject.eff_fm_dt.value &&
							sheetObjects[5].CellValue(1, "eff_to_dt")	== formObject.eff_to_dt.value &&
							sheetObjects[5].CellValue(1, "auto_xtd_flg")== getElementValue(formObject, 'radio', 'auto_xtd_flg') &&
							getElementValue(formObject, 'radio', 'amend_flg')	== "N" &&
							sheetObjects[5].CellValue(1, "agmt_rmk").trim()	!= formObject.agmt_rmk.value.trim() )
						{
							agmtHdrRmkFlg	= "Y";
							
						} else {
							agmtHdrRmkFlg	= "N";
						}
						
						if( agmtHdrRmkFlg == "Y" ) {
							topBtnSave_RmkSave();
							
						} else if( agmtHdrRmkFlg == "N" ) {
							topBtnSave_Confirm();
						}
						
					}else if(formObject.tml_agmt_sts_cd.value == "P"){
						topBtnSave_Process();
					}
				break;
				
				case "t1btng_retreive1":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
					
				case "t1btng_retreive2":
					doActionIBSheet2(sheetObject1,formObject,IBINSERT);
					break;
					
				case "t1btng_registertpcc":
					if( formObject.tml_agmt_sts_cd.value != "" ) {
						// 1, 2
//	                        if(sheetObjects[5].CellValue(1, 1) == "" || sheetObjects[5].CellValue(1, 2) == ""){
						if(sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") == "" ) {
							ComShowCodeMessage('TES10005');  //There is no mandatory item.\n\n Please check again.
							return false;
						}
						
						var display = "0,0,0, 0";
						ComOpenPopup('ESD_TES_9180.do?cost_cd='+document.form.lgs_cost_cd_t.value+'&agmt_no='+document.form.tml_agmt_ofc_cty_cd.value+'&agmt_ver_no='+document.form.tml_agmt_ver_no.value, 400, 430, '', display, true);
						
					} else {
						ComShowCodeMessage('TES10007');    //Agreement header information is not entered/saved.\n\n Please check again.
					}
				break;
				
				case "t1btng_agmtcopy":
					window.showModalDialog("ESD_TES_9070.do", window, "dialogWidth:510px; dialogHeight:500px; help:no; status:no; resizable:no; scrollbars:no;");
					break;
				case "t1btng_new":
					initformTerminalDTLs();
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					break;
				case "t1btng_save":
					var iRow = "1";
					sheetObjects[5].RowStatus(iRow)	= "U";	// 0
					sheetObjects[5].CellValue2(iRow, "lgs_cost_cd")			= formObject.lgs_cost_cd_t.value;	// 13
					sheetObjects[5].CellValue2(iRow, "auto_calc_flg")		= getElementValue(formObject, 'radio', 'auto_calc_flg');	//14
					sheetObjects[5].CellValue2(iRow, "tml_agmt_vol_ut_cd")	= formObject.tml_agmt_vol_ut_cd[1].value;	// 15
					sheetObjects[5].CellValue2(iRow, "curr_cd")				= formObject.curr_cd_t.value;	// 16
					sheetObjects[5].CellValue2(iRow, "cmnc_hrmnt")			= "T";	// 19
					
					if (comboObjects[0].Code=="" || comboObjects[0].Code == undefined){
						ComShowCodeMessage('TES10016');    //Please select Cost code.
						return false;
					}
					
					if (ComIsNull(formObject.tml_agmt_vol_ut_cd[1].value)){
						ComShowCodeMessage('TES10017'); //Please select Vol. UOM.
						return false;
					}

					if (ComIsNull(formObject.curr_cd_t.value)){
						ComShowCodeMessage('TES10018');   //Please select Currency.
						return false;
					}

					formObject.tml_agmt_tp_cd.value	= "T";
					formObject.tml_agmt_vol_ut_cd[0].value = formObject.tml_agmt_vol_ut_cd[1].value;
					formObject.curr_cd.value		= comboObjects[1].Code;
					formObject.lgs_cost_cd.value	= comboObjects[0].Code;
					
					if(formObject.tml_agmt_sts_cd.value != ""){
						if (comboObjects[0].Code.substring(0,2) == "TP") {
							formObject.f_cmd.value = SEARCH01 ;
							sheetObjects[6].DoSearch4Post("ESD_TES_ThrpccGS.do", tesFrmQryStr(formObject));
							
							var thrp_gb;
							
							if (formObject.thrpFlg.value != "Y") {
								thrp_gb = ComShowConfirm(ComGetMsg('TES10019')); //There is no registered Cost Code with the Throughput Rate.\n\n Do you want to register now?

								if(thrp_gb == true){
									var display = "0,0,0, 0";
									ComOpenPopup('ESD_TES_9180.do?cost_cd='+document.form.lgs_cost_cd_t.value+'&agmt_no='+document.form.tml_agmt_ofc_cty_cd.value+'&agmt_ver_no='+document.form.tml_agmt_ver_no.value, 400, 430, '', display, true);
								}

							} else {
								formObject.f_cmd.value = MULTI01;
								doActionIBSheet6(sheetObject5,formObject,IBSAVE);
							}
						} else {
							formObject.f_cmd.value = MULTI01;
							doActionIBSheet6(sheetObject5,formObject,IBSAVE);
						}
					} else {
						ComShowCodeMessage('TES10020');   //There is no Agreement header information.\n\n Please check again.
					}
					
					break;

				case "t1btng_apply":
					
					if (ComIsNull(formObject.yd_cd.value)){
						ComShowCodeMessage('TES10009');   //Please enter Yard Code.
						return false;
					}

					if (ComIsNull(formObject.vndr_seq.value)){
						ComShowCodeMessage('TES10011');    //Please enter Service Provider Code.
						return false;
					}

					if (ComIsNull(formObject.ctrt_ofc_cd.value)){
						ComShowCodeMessage('TES10023'); //Please enter Contract Office.
						return false;
					}

					if (ComIsNull(formObject.eff_fm_dt.value)){
						ComShowCodeMessage('TES10024');  //Please enter Effective Date.
						return false;
					}

					if (ComIsNull(formObject.eff_to_dt.value)){
						ComShowCodeMessage('TES10024'); //Please enter Effective Date.
						return false;
					}
                	
					if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))){
						ComShowCodeMessage('TES10014'); //Please check Auto Ext.
						return false;
					}
                	
					if (ComIsNull(formObject.lgs_cost_cd_t.value)){
						ComShowCodeMessage('TES10016');   //Please select Cost code.
						return false;
					}

					if (ComIsNull(formObject.tml_agmt_vol_ut_cd[1].value)){
						ComShowCodeMessage('TES10017');    //Please select Vol. UOM.
						return false;
					}
					
					if (ComIsNull(formObject.curr_cd_t.value)){
						ComShowCodeMessage('TES10018'); //Please select Currency.
						return false;
					}

					if(agreementVaildate(verifyObjects)){

						if (formObject.tml_agmt_vol_ut_cd[1].value == "C"){
							if (ComIsNull(getElementValue(formObject, 'radio', 'cntr_ts'))){
								ComShowCodeMessage('TES10026'); //Please select container Type/Size.
								return false;
							}
						}
						
						if (ComIsNull(formObject.agmt_rate.value)){
							ComShowCodeMessage('TES10027');    //Please enter Rate.
							return false;
						}
						
						sheetObject6.RemoveAll();
						if(formObject.lgs_cost_cd_t.value.substring(0,2)!="TP"){
							formObject.lgs_cost_cd.value = formObject.lgs_cost_cd_t.value ;
							doActionIBSheet7(sheetObject6,formObject,IBSEARCH);
						}
						
						// Terminal Rate Input To Terminal Rate List Data Insert ( ESD_TES_AGMTINPUTLIST.js )
						terminalRateInputList();
				
						tabObjects[0].selectedIndex = 1;
					}
					break;

				case "t2btng_rowadd":
					doActionIBSheet3(sheetObject2,formObject,IBINSERT);
					break;

				case "t2btng_save":
					if (ComIsNull(formObject.yd_cd.value)){
						ComShowCodeMessage('TES10009');  //Yard Code를 입력하세요.
						return false;
					}

					if (ComIsNull(formObject.yd_cd_name.value)){
						ComShowCodeMessage('TES10010');  //Yard Code Name이 없습니다. Yard Code를 다시 입력하세요.
						return false;
					}

					if (ComIsNull(formObject.vndr_seq.value)){
						ComShowCodeMessage('TES10011');   //Vendor Code를 입력하세요.
						return false;
					}

					if(formObject.inquiryFlg.value!="Y"){
						if (formObject.vndr_seq_name.value==""){
							ComShowCodeMessage('TES10011');  //Vendor Code를 입력하세요.
							return false;
						}
					}

					if(agmtRegFlg == "N"){
						ComShowCodeMessage('TES10095');  //SAVE처리가 CANCEL 된 Yard Code와 Vender Seq 입니다. 다시 확인하세요.
						return false;
					}

					if(hdrRetrieveFlg != "Y"){
						ComShowCodeMessage('TES10096');   //Retrieve를 실행하여 Agreement가 있는지 확인하세요.
						return false;
					}

					if (ComIsNull(formObject.eff_fm_dt.value)){
						ComShowCodeMessage('TES10012');    //Effective Date 입력하세요.
						formObject.eff_fm_dt.focus();
						return false;
					}

					if (!ComIsDate(formObject.eff_fm_dt)){
						ComShowCodeMessage('TES10013');   //날짜 입력이 잘못되었습니다.
						formObject.eff_fm_dt.focus();
						return false;
					}
					
					if (!checkEffFormat(formObject.eff_fm_dt.value)){
						ComShowCodeMessage('TES10013');    //날짜 입력이 잘못되었습니다.
						formObject.eff_fm_dt.focus();
						return false;
					}

					if (ComIsNull(formObject.eff_to_dt.value)){
						ComShowCodeMessage('TES10012');       ////Effective Date 입력하세요.
						formObject.eff_to_dt.focus();
						return false;
					}

					if (!ComIsDate(formObject.eff_to_dt)){
						ComShowCodeMessage('TES10013');    //Date is not correct.
						formObject.eff_to_dt.focus();
						return false;
					}

					if (!checkEffFormat(formObject.eff_to_dt.value)){
						ComShowCodeMessage('TES10013');  //Date is not correct.
						formObject.eff_to_dt.focus();
						return false;
					}

					if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))){
						ComShowCodeMessage('TES10014'); //Please check Auto Ext.
						return false;
					}
					
					//20140408 추가됨
					if (ComIsNull(formObject.agmt_apro_dt.value)){
						ComShowCodeMessage('TES10135');		// "AGMT Approval Date is mandatory item for creation or update");
						formObject.agmt_apro_dt.focus();
						return false;
					}
					
					if (!ComIsDate(formObject.agmt_apro_dt)){
						ComShowCodeMessage('TES10136');		// "AGMT Approval Date is not correct.";
						formObject.agmt_apro_dt.focus();
						return false;
					}
					
					if (!checkEffFormat(formObject.agmt_apro_dt.value)){
						ComShowCodeMessage('TES10136');		// "AGMT Approval Date is not correct.";
						formObject.agmt_apro_dt.focus();
						return false;
					}					
					
					//20140519 추가됨
					if (!ComIsNull(formObject.agmt_cfm_dt.value)){
						if (!ComIsDate(formObject.agmt_cfm_dt)){
							ComShowCodeMessage('TES10132');		// "AGMT Confirm Date is not correct.";
							formObject.agmt_cfm_dt.focus();
							return false;
						}
						
						if (!checkEffFormat(formObject.agmt_cfm_dt.value)){
							ComShowCodeMessage('TES10132');		// "AGMT Confirm Date is not correct.";
							formObject.agmt_cfm_dt.focus();
							return false;
						}
					}
					

					if(formObject.tml_agmt_sts_cd.value == ""){
						var iRow = 1;
						sheetObjects[5].RowStatus(iRow)		= "I";	// 0
						sheetObjects[5].CellValue2(iRow, "yd_cd")		= formObject.yd_cd.value;	// 3
						sheetObjects[5].CellValue2(iRow, "yd_nm")		= formObject.yd_cd_name.value;	// 4
						sheetObjects[5].CellValue2(iRow, "vndr_seq")	= formObject.vndr_seq.value;	// 5
						sheetObjects[5].CellValue2(iRow, "vndr_lgl_eng_nm")	= formObject.vndr_seq_name.value;	// 6
						sheetObjects[5].CellValue2(iRow, "ctrt_ofc_cd")	= formObject.ctrt_ofc_cd.value;	// 7
						sheetObjects[5].CellValue2(iRow, "eff_fm_dt")	= formObject.eff_fm_dt.value;	// 8
						sheetObjects[5].CellValue2(iRow, "eff_to_dt")	= formObject.eff_to_dt.value;	// 9
						sheetObjects[5].CellValue2(iRow, "auto_xtd_flg")= getElementValue(formObject, 'radio', 'auto_xtd_flg');	// 10
						sheetObjects[5].CellValue2(iRow, "agmt_rmk")	= formObject.agmt_rmk.value;	// 12
						
						sheetObjects[5].CellValue2(iRow, "agmt_apro_dt")	= formObject.agmt_apro_dt.value;	// 9
						sheetObjects[5].CellValue2(iRow, "agmt_cfm_dt")	= formObject.agmt_cfm_dt.value;	// 9
						
						
						
						topBtnSave_OnlyTopSave();
				  		
					} else if(formObject.tml_agmt_sts_cd.value == "C"){
						topBtnSave_Confirm();
                 			
					} else if(formObject.tml_agmt_sts_cd.value == "P"){
						topBtnSave_Process();
					}
					break;

				case "t2btng_new":
					sheetObject2.RemoveAll();
					break;

				case "t2btng_delete":
					var t2sheet1DelCount = 0;
            	  
					for(var i = 0; i < sheetObject2.RowCount; i++ ) {
            		  
						if(sheetObject2.CellValue(i+3,0)==1){
							t2sheet1DelCount++;
						}
					}

					if(t2sheet1DelCount > 0){
						rowDelete();
						delete_Process();
            		  
					} else {
						ComShowCodeMessage('TES10097');    //There is no date to delete.\n\n Please check again.
					}
					break;

				case "t2btng_downexcel":
					doActionIBSheet3(sheetObject2,formObject,IBDOWNEXCEL);
					break;

				case "t2btng_loadexcel":
					if(formObject.tml_agmt_sts_cd.value!="" && formObject.tml_agmt_ofc_cty_cd.value!="" && formObject.tml_agmt_ver_no.value!=""){
						window.showModalDialog("ESD_TES_9160.do", window, "dialogWidth:710px; dialogHeight:425px; help:no; status:no; resizable:yes;");
            		  
					} else {
						ComShowCodeMessage('TES10030');  //There is no data on Load EXCEL.\n\n Please check again.
					}
					break;

				case "t2btng_verify":
					var beforeibflag = new Array();

					if(formObject.tml_agmt_sts_cd.value!="" && formObject.tml_agmt_ofc_cty_cd.value!="" && formObject.tml_agmt_ver_no.value!="" && (sheetObjects[2].RowCount >0)){

						if(dupRowCheck('T')==false){
							return false;
						}

						sheetObjects[2].ColumnSort("3lgs_cost_cd|3io_bnd_cd|3ioc_cd|3tml_dy_aply_tp_cd|3lane_cd|3dcgo_aply_tp_cd|3tml_vol_aply_tp_cd|3fm_tr_vol_val|3to_tr_vol_val|3tml_ovt_shft_cd|3thc_tp_cd", "ASC");

						for(i=0;i<sheetObject2.RowCount;i++){
							beforeibflag[i] = sheetObject2.RowStatus(i+3);
            			  }

						doActionIBSheet8(sheetObject7,formObject,IBSEARCH);

						if(dataTerminalErrCount>0){
							ComShowCodeMessage('TES10031');   //Please modify Terminal Rate List Sheet Data.
            			  
						} else {
							tab2VerifyFlg = terminalRateListVerify_test1(beforeibflag);
            			  
							if(tab2VerifyFlg){
								ComShowCodeMessage('TES10032');    //Terminal Rate List Verify has been completed.
            				  
							} else {
								ComShowCodeMessage('TES10033');    //Please check Terminal Agreement again.
							}

							setTooltip(sheetObjects[2],3+'verify_result');
						}

					} else {
						ComShowCodeMessage('TES10034');   //There is no necessary data for Verify.\n\n Please check again.
					}
					break;

				case "t2btng_registeragree":

					agreementReg();
					break;

				case "t3btng_save":
					var iRow = 1;

					if (ComIsNull(formObject.tml_sto_agmt_tp_cd.value)){
						ComShowCodeMessage('TES10037');  //Please select SR AGMT Type.
						return false;
					}

					if (ComIsNull(formObject.lgs_cost_cd_s.value)){
						ComShowCodeMessage('TES10016');    //Please select Cost code.
						return false;
					}

					if (ComIsNull(formObject.tml_agmt_vol_ut_cd[2].value)){
						ComShowCodeMessage('TES10017');   //Please select Vol. UOM.
						return false;
					}

					if (ComIsNull(formObject.cmnc_hrmnt.value)){
						ComShowCodeMessage('TES10040');   //Please enter Commence Time.
						return false;
					}

					if (!isValidHHMM(formObject.cmnc_hrmnt)){
						ComShowCodeMessage('TES10041');   //Please enter Commence Time as HH:MM format.
						return false;
					}

					if (!checkCmncFormat(formObject.cmnc_hrmnt.value)){
						ComShowCodeMessage('TES10041');    //Please enter Commence Time as HH:MM format.
						return false;
					}

					if (ComIsNull(formObject.curr_cd_s.value)){
						ComShowCodeMessage('TES10018');  //Please select Currency.
						return false;
					}

					var storageAutoCalcFlg = formObject.vfsArray.value.split(",");
					sheetObjects[5].RowStatus(iRow)		= "I";	// 0
					sheetObjects[5].CellValue(iRow, "lgs_cost_cd")	= formObject.lgs_cost_cd_s.value; // 13
            	  
					if(storageAutoCalcFlg[0]=="Y"){
						sheetObjects[5].CellValue(iRow, "auto_calc_flg")	= "Y";	// 14
					}
					sheetObjects[5].CellValue(iRow, "tml_agmt_vol_ut_cd")	= formObject.tml_agmt_vol_ut_cd[2].value;	// 15
					sheetObjects[5].CellValue(iRow, "curr_cd")			= formObject.curr_cd_s.value;	// 16
					sheetObjects[5].CellValue(iRow, "thrp_cost_cd_flg")	= formObject.tml_sto_agmt_tp_cd.value;	// 17
					sheetObjects[5].CellValue(iRow, "tml_sto_agmt_tp_cd")	= formObject.cmnc_hrmnt.value.substr(0,2)+formObject.cmnc_hrmnt.value.substr(3,5);	// 18
					sheetObjects[5].CellValue(iRow, "cmnc_hrmnt")			= "S";	// 19
            	  
					formObject.f_cmd.value	= MULTI01;
            	  
					if(storageAutoCalcFlg[0] == "Y"){
						formObject.auto_calc_flg[0].disabled = false;
						formObject.auto_calc_flg[0].checked = true;
						formObject.auto_calc_flg[0].value = "Y";
					}
					formObject.curr_cd.value = formObject.curr_cd_s.value;

					formObject.tml_agmt_vol_ut_cd[0].value  = formObject.tml_agmt_vol_ut_cd[2].value;
					formObject.lgs_cost_cd.value = formObject.lgs_cost_cd_s.value;
					formObject.tml_agmt_tp_cd.value = "S";
					doActionIBSheet6(sheetObject5,formObject,IBSAVE);
					break;

				case "t3btng_retreive":
					doActionIBSheet4(sheetObject3,formObject,IBINSERT);
					break;

				case "t3btng_agmtcopy":
					window.showModalDialog("ESD_TES_9070.do", window, "dialogWidth:510px; dialogHeight:500px; help:no; status:no; resizable:no; scrollbars:no;");
					break;

				case "t3btng_new1":
					initformStorageFDDTLs();
					sheetObject3.RemoveAll();
					break;

				case "t3btng_apply1":

					if (ComIsNull(formObject.yd_cd.value)){
						ComShowCodeMessage('TES10009'); //Please enter Yard Code.
						return false;
					}
            	  
					if (ComIsNull(formObject.vndr_seq.value)){
						ComShowCodeMessage('TES10011');  //Please enter Service Provider Code.
						return false;
					}

					if (ComIsNull(formObject.ctrt_ofc_cd.value)){
						ComShowCodeMessage('TES10023');  //Please enter Contract Office.
						return false;
					}

					if (ComIsNull(formObject.eff_fm_dt.value)){
						ComShowCodeMessage('TES10024'); //Please enter Effective Date.
						return false;
					}

					if (ComIsNull(formObject.eff_to_dt.value)){
						ComShowCodeMessage('TES10024');    //Please enter Effective Date.
						return false;
					}
            	  
					if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))){
						ComShowCodeMessage('TES10014');  //Please check Auto Ext.
						return false;
					}
					if (ComIsNull(formObject.lgs_cost_cd_s.value)){
						ComShowCodeMessage('TES10014'); //Please check Auto Ext.
						return false;
					}

					if (ComIsNull(formObject.tml_agmt_vol_ut_cd[2].value)){
						ComShowCodeMessage('TES10017');    //Please select Vol. UOM.
						return false;
					}

					if (ComIsNull(formObject.cmnc_hrmnt.value)){
						ComShowCodeMessage('TES10040');   //Please enter Commence Time.
						return false;
					}

					if (!isValidHHMM(formObject.cmnc_hrmnt)){
						ComShowCodeMessage('TES10041');    //Please enter Commence Time as HH:MM format.
						return false;
					}

					if (!checkCmncFormat(formObject.cmnc_hrmnt.value)){
						ComShowCodeMessage('TES10041');    //Please enter Commence Time as HH:MM format.
						return false;
					}

					if (ComIsNull(formObject.curr_cd_s.value)){
						ComShowCodeMessage('TES10018'); //Please select Currency.
						return false;
					}

					if (formObject.storage_gb[0].checked == false && formObject.storage_gb[1].checked == false){
						ComShowCodeMessage('TES10042');    //Please select Free Days/Rate.
						return false;
					}

					if(formObject.storage_gb[0].checked == true){

//						if (ComIsNull(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD'))){
//							ComShowCodeMessage('TES10043'); //Please select DG Class.
//							return false;
//						}

						if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD') == "A"){
            			  
							if (ComIsNull(getElementValue(formObject, 'radio', 'dcgo_same_FD'))){
								ComShowCodeMessage('TES10044');  //Please select DG, NODG.
								return false;
							}
						}

						if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD') == "S"){
		                 		
							if (document.form.dcgo_n1st_clss_flg_FD.checked == false && document.form.dcgo_n2nd_clss_flg_FD.checked == false && document.form.dcgo_n3rd_clss_flg_FD.checked == false && document.form.dcgo_n4th_clss_flg_FD.checked == false && document.form.dcgo_n5th_clss_flg_FD.checked == false && document.form.dcgo_n6th_clss_flg_FD.checked == false && document.form.dcgo_n7th_clss_flg_FD.checked == false && document.form.dcgo_n8th_clss_flg_FD.checked == false && document.form.dcgo_n9th_clss_flg_FD.checked == false && document.form.dcgo_none_clss_flg_FD.checked == false ){
								ComShowCodeMessage('TES10045');  //Please check DG Class.
								return false;
							}
						}

						if (ComIsNull(formObject.ft_dys.value)){
							ComShowCodeMessage('TES10046');    //Please enter Days.
							return false;
						}
					}

					if(formObject.storage_gb[1].checked == true ) {
//						if (ComIsNull(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R'))){
//							ComShowCodeMessage('TES10043');    //Please select DG Class.
//							return false;
//						}

						if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "A"){
            			  
							if (ComIsNull(getElementValue(formObject, 'radio', 'dcgo_same_R'))){
								ComShowCodeMessage('TES10044');    //Please select DG, NODG.
								return false;
							}
						}

						if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "S"){
		              
							if (document.form.dcgo_n1st_clss_flg_FD.checked == false && document.form.dcgo_n2nd_clss_flg_R.checked == false && document.form.dcgo_n3rd_clss_flg_R.checked == false && document.form.dcgo_n4th_clss_flg_R.checked == false && document.form.dcgo_n5th_clss_flg_R.checked == false && document.form.dcgo_n6th_clss_flg_R.checked == false && document.form.dcgo_n7th_clss_flg_R.checked == false && document.form.dcgo_n8th_clss_flg_R.checked == false && document.form.dcgo_n9th_clss_flg_R.checked == false && document.form.dcgo_none_clss_flg_R.checked == false ){
								ComShowCodeMessage('TES10045');  //Please check DG Class.
								return false;
							}
						}

						if(sheetObjects[3].CheckedRows(0) == "0"){
							ComShowCodeMessage('TES10047');   //Please check No of Volume Tier.
							return false;
						}

						if (ComIsNull(formObject.agmt_ut_rt.value)){
							ComShowCodeMessage('TES10027');  //Please enter Rate.
							return false;
						}
					}

					if (formObject.tml_agmt_vol_ut_cd[2].value == "C"){
            		  
						if (ComIsNull(getElementValue(formObject, 'radio', 'cntr_ts'))){
							ComShowCodeMessage('TES10026'); //Please select container Type/Size.
							return false;
						}
					}

					storageRateInputList();
					tabObjects[0].selectedIndex = 3 ;
					break;

				case "t3btng_agmtcopy2":
					window.showModalDialog("ESD_TES_9070.do", window, "dialogWidth:510px; dialogHeight:500px; help:no; status:no; resizable:no; scrollbars:no;");
					break;

				case "t3btng_new2":
					initformStorageFPDTLs();
					break;

				case "t3btng_apply2":

					if (ComIsNull(formObject.yd_cd.value)){
						ComShowCodeMessage('TES10009');   //Please enter Yard Code.
						return false;
					}

					if (ComIsNull(formObject.vndr_seq.value)){
						ComShowCodeMessage('TES10011'); //Please enter Service Provider Code.
						return false;
					}

					if (ComIsNull(formObject.ctrt_ofc_cd.value)){
						ComShowCodeMessage('TES10023');  //Please enter Contract Office.
						return false;
					}

					if (ComIsNull(formObject.eff_fm_dt.value)){
						ComShowCodeMessage('TES10024'); //Please enter Effective Date.
						return false;
					}

					if (ComIsNull(formObject.eff_to_dt.value)){
						ComShowCodeMessage('TES10024');  //Please enter Effective Date.
						return false;
					}
					
					if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))){
						ComShowCodeMessage('TES10014'); //Please check Auto Ext.
						return false;
					}
					
					if (ComIsNull(formObject.lgs_cost_cd_s.value)){
						ComShowCodeMessage('TES10016');  //Please select Cost code.
						return false;
					}

					if (ComIsNull(formObject.tml_agmt_vol_ut_cd[2].value)){
						ComShowCodeMessage('TES10017');    //Please select Vol. UOM.
						return false;
					}

					if (ComIsNull(formObject.cmnc_hrmnt.value)){
						ComShowCodeMessage('TES10040');   //Please enter Commence Time.
						return false;
					}

					if (!isValidHHMM(formObject.cmnc_hrmnt)){
						ComShowCodeMessage('TES10041');    //Please enter Commence Time as HH:MM format.
						return false;
					}

					if (!checkCmncFormat(formObject.cmnc_hrmnt.value)){
						ComShowCodeMessage('TES10041');  //Please enter Commence Time as HH:MM format.
						return false;
            		  }

					if (ComIsNull(formObject.curr_cd_s.value)){
						ComShowCodeMessage('TES10018');   //Please select Currency.
						return false;
					}

					if (ComIsNull(getElementValue(formObject, 'radio', 'fp_calc_prd_cd'))){
						ComShowCodeMessage('TES10048');    //Please check Cal. Period.
						return false;
					}
            		  
					if (ComIsNull(formObject.fp_teu_qty.value)){
						ComShowCodeMessage('TES10049');   //Please enter FP TEU.
						return false;
					}
                 
					if (ComIsNull(formObject.agmt_ut_rt_fp.value)){
						ComShowCodeMessage('TES10027');   //Please enter Rate.
						return false;
					}

					storageRateInputList();
					tabObjects[0].selectedIndex = 3 ;
					break;

				case "t4btng_new":
					sheetObject4.RemoveAll();
					break;

				case "t4btng_rowadd":
					doActionIBSheet5(sheetObject4,formObject,IBINSERT);
					break;

				case "t4btng_delete":
					var t4sheet1DelCount = 0;
            	  
					for(var i=0;i<sheetObject4.RowCount;i++){
					
						if(sheetObject4.CellValue(i+3,0)==1){
							t4sheet1DelCount++;
						}
					}

					if(t4sheet1DelCount>0){
						rowDelete();
						delete_Process();
            		  
					}else{
						ComShowCodeMessage('TES10097');    //There is no date to delete.\n\n Please check again.
					}
					break;

				case "t4btng_save":
            	  
					if (ComIsNull(formObject.yd_cd.value)){
						ComShowCodeMessage('TES10009');
						return false;
					}

					if (ComIsNull(formObject.yd_cd_name.value)){
						ComShowCodeMessage('TES10010');
						return false;
					}

            	  if (ComIsNull(formObject.vndr_seq.value)){
            		  ComShowCodeMessage('TES10011');
            		  return false;
            	  }	

            	  if(formObject.inquiryFlg.value!="Y"){
            		
            		  if (formObject.vndr_seq_name.value==""){
            			  ComShowCodeMessage('TES10011');
            			  return false;
            		  }
            	  }

            	  if(agmtRegFlg=="N"){
            		  ComShowCodeMessage('TES10095');    //These are saving canceled Yard code and vendor SEQ.\n\n Please check again.
            		  return false;
            	  }

            	  if(hdrRetrieveFlg!="Y"){
            		  ComShowCodeMessage('TES10096');
            		  return false;
            	  }

            	  if (ComIsNull(formObject.eff_fm_dt.value)){
            		  ComShowCodeMessage('TES10024');
            		  formObject.eff_fm_dt.focus();
            		  return false;
            	  }

            	  if (!ComIsDate(formObject.eff_fm_dt)){
            		  ComShowCodeMessage('TES10013');
            		  formObject.eff_fm_dt.focus();
            		  return false;
            	  }

            	  if (!checkEffFormat(formObject.eff_fm_dt.value)){
            		  ComShowCodeMessage('TES10013');
            		  formObject.eff_fm_dt.focus();
            		  return false;
            	  }

            	  if (ComIsNull(formObject.eff_to_dt.value)){
            		  ComShowCodeMessage('TES10024');
            		  formObject.eff_to_dt.focus();
            		  return false;
            	  }

            	  if (!ComIsDate(formObject.eff_to_dt)){
            		  ComShowCodeMessage('TES10013');
            		  formObject.eff_to_dt.focus();
            		  return false;
            	  }
            	  
            	  if (!checkEffFormat(formObject.eff_to_dt.value)){
            		  ComShowCodeMessage('TES10013');
            		  formObject.eff_to_dt.focus();
            		  return false;
            	  }

            	  if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))){
            		  ComShowCodeMessage('TES10014');
            		  return false;
            	  }
            	  
				//20140408 추가됨
				if (ComIsNull(formObject.agmt_apro_dt.value)){
					ComShowCodeMessage('TES10135');		// "AGMT Approval Date is mandatory item for creation or update";
					formObject.agmt_apro_dt.focus();
					return false;
				}
				
				if (!ComIsDate(formObject.agmt_apro_dt)){
					ComShowCodeMessage('TES10136');		// "AGMT Approval Date is not correct.";
					formObject.agmt_apro_dt.focus();
					return false;
				}
				
				if (!checkEffFormat(formObject.agmt_apro_dt.value)){
					ComShowCodeMessage('TES10136');		// "AGMT Approval Date is not correct.";
					formObject.agmt_apro_dt.focus();
					return false;
				}
				
				//20140519 추가됨
				if (!ComIsNull(formObject.agmt_cfm_dt.value)){
					if (!ComIsDate(formObject.agmt_cfm_dt)){
						ComShowCodeMessage('TES10132');		// "AGMT Confirm Date is not correct.";
						formObject.agmt_cfm_dt.focus();
						return false;
					}
					
					if (!checkEffFormat(formObject.agmt_cfm_dt.value)){
						ComShowCodeMessage('TES10132');		// "AGMT Confirm Date is not correct.";
						formObject.agmt_cfm_dt.focus();
						return false;
					}
				}				
            	  
            	  if(formObject.tml_agmt_sts_cd.value == ""){
            		  var iRow = 1;
            		  sheetObjects[5].RowStatus(iRow)	= "I";	// 0
            		  sheetObjects[5].CellValue2(iRow, "yd_cd")	= formObject.yd_cd.value;	// 3
            		  sheetObjects[5].CellValue2(iRow, "yd_nm")	= formObject.yd_cd_name.value;	//4
            		  sheetObjects[5].CellValue2(iRow, "vndr_seq")	= formObject.vndr_seq.value;	// 5
            		  sheetObjects[5].CellValue2(iRow, "vndr_lgl_eng_nm")	= formObject.vndr_seq_name.value;	// 6
            		  sheetObjects[5].CellValue2(iRow, "ctrt_ofc_cd")	= formObject.ctrt_ofc_cd.value;	// 7
            		  sheetObjects[5].CellValue2(iRow, "eff_fm_dt")	= formObject.eff_fm_dt.value;	// 8
            		  sheetObjects[5].CellValue2(iRow, "eff_to_dt")	= formObject.eff_to_dt.value;	// 9
            		  sheetObjects[5].CellValue2(iRow, "auto_xtd_flg")	= getElementValue(formObject, 'radio', 'auto_xtd_flg');	// 10
            		  sheetObjects[5].CellValue2(iRow, "agmt_rmk")	= formObject.agmt_rmk.value;	// 12
            		  
            		  sheetObjects[5].CellValue2(iRow, "agmt_apro_dt")	= formObject.agmt_apro_dt.value;	// 9
            		  sheetObjects[5].CellValue2(iRow, "agmt_cfm_dt")		= formObject.agmt_cfm_dt.value;	// 
            		  
            		  topBtnSave_OnlyTopSave();
            		  
            	  }else if(formObject.tml_agmt_sts_cd.value =="C"){
            		  topBtnSave_Confirm();
            		  
            	  }else if(formObject.tml_agmt_sts_cd.value =="P"){
            		  topBtnSave_Process();
            	  }
            	  break;

				case "t4btng_downexcel":
					doActionIBSheet5(sheetObject4,formObject,IBDOWNEXCEL);
            	  break;

        	     case "t4btng_loadexcel":
        	  
        	    	 if(formObject.tml_agmt_sts_cd.value!="" && formObject.tml_agmt_ofc_cty_cd.value!="" && formObject.tml_agmt_ver_no.value!=""){
        	    		 window.showModalDialog("ESD_TES_9170.do", window, "dialogWidth:710px; dialogHeight:425px; help:no; status:no; resizable:yes;");
        	    	 }else{
        	    		 ComShowCodeMessage('TES10030'); //There is no data on Load EXCEL.\n\n Please check again.
        	    	 }
        	    	 break;

        	     case "t4btng_verify":
        	    	 var beforeibflag = new Array();

        	    	 if(formObject.tml_agmt_sts_cd.value != "" && formObject.tml_agmt_ofc_cty_cd.value != "" && formObject.tml_agmt_ver_no.value != "" && (sheetObjects[4].RowCount > 0)){
					
        	    		 if(dupRowCheck('S') == false ) {
        	    			 return false;
        	    		 }
            		  
        	    		 sheetObjects[4].ColumnSort("5lgs_cost_cd|5tml_vol_aply_tp_cd|5tml_sto_agmt_tp_cd|5io_bnd_cd|5ft_dys|5fm_tr_dys|5to_tr_dys", "ASC");

        	    		 for( i = 0; i < sheetObject4.RowCount; i++ ) {
        	    			 beforeibflag[i] = sheetObject4.RowStatus( i + 3 );
        	    		 }

        	    		 doActionIBSheet8(sheetObject7,formObject,IBSEARCH);

        	    		 if(dataStorageErrCount>0){
        	    			 ComShowCodeMessage('TES10103'); //Please modify Storage Rate List Sheet Data.
							
        	    		 } else {
        	    			 tab4VerifyFlg = storageRateListVerify_test1(beforeibflag);
            			  
        	    			 if(tab4VerifyFlg){
        	    				 ComShowCodeMessage('TES10104');    //Storage Rate List Verify has been completed.
								
        	    			 }else{
        	    				 ComShowCodeMessage('TES10105');   //Please check Storage Agreement again.
        	    			 }
        	    			 setTooltip(sheetObject4, 5 + 'verify_result');
        	    		 }

        	    	 }else{
        	    		 ComShowCodeMessage('TES10034');   //There is no necessary data for Verify.\n\n Please check again.
        	    	 }
        	    	 break;

        	     case "t4btng_registeragree":

        	    	 agreementReg();
        	    	 break;

			} // end switch
		}catch(e) {
    		
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');   //The service is not available now
			} else {
				ComShowMessage(e);
			}
		}
	}

    /**
     * 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한
     */
	function processChange(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    	/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
    		
				case "tml_sto_agmt_tp_cd":

					var invalue = formObject.tml_sto_agmt_tp_cd.options[formObject.tml_sto_agmt_tp_cd.selectedIndex].value;

					if ( invalue == "FD")
                    {
                        document.all.item("srLayer")[1].style.display = "none";
                        document.all.item("srLayer")[0].style.display = "Inline";

                        document.form.tml_agmt_vol_ut_cd[2].disabled = false;
                        document.form.tml_agmt_vol_ut_cd[2].value = "C";

                    }
                    if ( invalue == "FP")
                    {
                        document.all.item("srLayer")[0].style.display = "none";
                        document.all.item("srLayer")[1].style.display = "Inline";

                        document.form.tml_agmt_vol_ut_cd[2].value = "T";
                        document.form.tml_agmt_vol_ut_cd[2].disabled = true;
                        document.form.tml_agmt_vol_ut_cd[2].value = "T";
                     }

                    break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21025');   //The service is not available now
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    

    /**
     * IBSheet Object 를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * 
     * @param {ibsheet}  	sheet_obj	Sheet Object
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }



    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        for(p=0;p< comboObjects.length;p++){
//            initCombo(comboObjects[p],p+1, '','','','','','','');
            initCombo(comboObjects[p],p+1, '','','','','','','', '', '');
        }

        //각 TAB별 레이업 display 여부
        var objs = document.all.item("tabLayer");
      	objs[1].style.display = "none";
      	objs[2].style.display = "none";
      	objs[3].style.display = "none";
      	/**
      	//Mode 별 레이어 display 여부
        var obj_mode = document.all.item("modeLayer");
      	obj_mode[1].style.display = "none";
      	obj_mode[2].style.display = "none";
      	**/
      	
      	var formObject = document.form;

      	if(!ComIsNull(agmt_no)){
      		formObject.tml_agmt_ofc_cty_cd.value= agmt_no;
      		formObject.tml_agmt_ver_no.value	= agmt_ver_no;
      		formObject.tml_agmt_tp_cd.value		= "T";
      		formObject.f_cmd.value				= SEARCH ;

      		doActionIBSheet6(sheetObjects[5],formObject,IBSEARCH);

      		if(doActionIBSheet6SearchFlg != "NoData"){
      			doActionIBSheet3(sheetObjects[2],formObject,IBSEARCH);
      		}

      		formObject.tml_agmt_tp_cd.value	= "S";
      		formObject.f_cmd.value			= SEARCH ;

      		if(doActionIBSheet6SearchFlg != "NoData"){
      			doActionIBSheet5(sheetObjects[4],formObject,IBSEARCH);
      		}
      		
      	}else{
      		formObject.yd_cd.focus();
      	}

        sheetObjects[2].SelectHighLight = false;
        sheetObjects[4].SelectHighLight = false;
	        
    	tes_getInputValue('rhq_ofc_cd', SEARCHLIST09, 'acct_ofc_cd', 'rhqValidChk');
    	
    }


	/**
     * 시트 초기설정값, 헤더 정의
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * 
     * @param {sheetObj}  	sheetObj	Sheet Object
     * @param {sheetNo}  	sheetNo		Sheet Object 태그의 아이디에 붙인 일련번호
     */
     function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:   // t1sheet1(No of Volume Tier) init
            	with (sheetObj) {

                    //전체 너비 설정
            		SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle0 = " |Seq.|Tier Volume|Tier Volume";
                    var HeadTitle1 = " |Seq.|From|To";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,   DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  true,    "",     false,          "",       dfNone,   		0,     true,      true, 6);
                    InitDataProperty(0, cnt++ , dtDataSeq,     30,    daCenter,  true,    "",     false,          "",       dfNone,   		0,     true,      true, 6);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,   "",     false,          "",       dfNone,   		0,     true,      true, 7);
                    InitDataProperty(0, cnt++ , dtData,        50,    daCenter,  false,   "",     false,          "",       dfNone,   		0,     true,      true, 7);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,50,    daCenter,  false,   "",     false,          "",       dfNone,   		0,     true,      true, 1);

                    CellBackColor(1,2) = RgbColor(222, 251, 248);
                    CellBackColor(1,3) = CellBackColor(1,2);

                    CountPosition = 0 ;
                    sheetObj.InitDataValid(0, 2, vtNumericOnly);
                    sheetObj.InitDataValid(0, 3, vtNumericOther, "MAXmax");

                    style.height=GetSheetHeight(5);

                }
                break;
             case 2:	// t1sheet2(No of Overtime Shift)
                with (sheetObj) {

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Seq.|Overtime Shift";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  true,     "",     false,          "",       dfNone,          0,     true,      true);
                    InitDataProperty(0, cnt++ , dtDataSeq,     30,    daCenter,  true,     "",     false,          "",       dfNone,          0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,        90,    daLeft,    true,     "",     false,          "",       dfNone,   				0,     true,      true,					1);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,50,    daCenter,  false,    "",     false,          "",       dfNone,   				0,     true,      true, 				1);

		                InitDataValid(0, 2, vtEngUpOnly);
		                CountPosition = 0 ;
                    style.height=GetSheetHeight(4);

                }
                break;

             case 3:	// t2sheet1(Terminal Rate List Tab)
                with (sheetObj) {

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(79, 3, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, false, false, true, false,false)

                    var HeadTitle0 = " |STS|Cost Code|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "Applied Date|Applied Date|Applied Date|Applied Date|Lane|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|"
                    + "Tier Vol.|Tier Vol.|OT\nShift|THC|Volume \nUOM|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|Rate by Container T/S|"
                    + "Rate by Container T/S|Rate by Container T/S|"
                    + "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|Verify\nResult|Remark";

                    var HeadTitle1 = " |STS|Cost Code|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "WD|Sat|Sun|H/D|Lane|None|Same for all DG|Same for all DG|" 
                    + "Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "Fr|To|OT\nShift|THC|Volume \nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|Verify\nResult|Remark";

                    var HeadTitle2 = " |STS|Cost Code|Auto\nCal.\nY/N|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
                    + "WD|Sat|Sun|H/D|Lane|None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "Fr|To|OT\nShift|THC|Volume \nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTon|Verify\nResult|Remark";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, 										KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,   "" );
                    InitDataProperty(0, cnt++ , dtData,		  30,    daCenter,  true,	"" );
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,    sheetNo +"lgs_cost_cd"			, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"auto_calc_flg"		, false,          "",       dfNone,   		0,     true,      true);
                    

                    InitDataProperty(0, cnt++ , dtCombo,	  60,    daCenter,  true,    sheetNo +"curr_cd"				, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    sheetNo +"thrp_lgs_cost_cd"	, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"io_bnd_cd"			, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"ioc_cd"				, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"tml_trns_mod_cd"		, false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"wkdy_flg"			, false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"sat_flg"				, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"sun_flg"				, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,    sheetNo +"hol_flg"				, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,    sheetNo +"lane_cd"				, false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    sheetNo +"dg_none"				, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    sheetNo +"same_dg_none"		, false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    sheetNo +"same_dg"				, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,    sheetNo +"sep_dg_none"				, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n1st_clss_flg"	, false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n2nd_clss_flg"	, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n3rd_clss_flg"	, false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n4th_clss_flg"	, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n5th_clss_flg"	, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n6th_clss_flg"	, false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n7th_clss_flg"	, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n8th_clss_flg"	, false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      30,    daCenter,  true,    sheetNo +"dcgo_n9th_clss_flg"	, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"fm_tr_vol_val"		, false,          "",       dfNone, 			0,     true,      true, 7);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"to_tr_vol_val"		, false,          "",       dfNone,   		0,     true,      true, 7);

                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    sheetNo +"tml_ovt_shft_cd"		, false,          "",       dfNone,   		0,     true,      true, 1);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    sheetNo +"thc_tp_cd"			, false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,    sheetNo +"tml_agmt_vol_ut_cd"	, false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d5"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d7"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d8"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"d9"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"dw"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"dx"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r5"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r7"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r8"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"r9"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"f2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);                                                                                                      					 
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"f4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"f5"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"o2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"o4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"o5"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"o7"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"s2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);                                                                                                      					 
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"s4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"t2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"t4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"a2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"a4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18); 
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"a5"					, false,          "",       dfFloat,   	 	2,     true,      true, 18); //추가

                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"p2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"p4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"c2"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    sheetNo +"c4"					, false,          "",       dfFloat,   	 	2,     true,      true, 18);                  
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"teu_rate"			, false,          "",       dfFloat,     	2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"box_rate"			, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"move_rate"			, false,          "",       dfFloat,   	 	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    sheetNo +"gang_hour_rate"		, false,          "",       dfFloat,    	2,     true,      true, 18);
                    // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    sheetNo +"ton_rate"		, false,          "",       dfFloat,    	2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    sheetNo +"verify_result"		, false,          "",       dfNone,   		0,     false,     false);
                    
                    InitDataProperty(0, cnt++ , dtPopup,      100,   daCenter,  true,    sheetNo +"remark",							false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"tml_dy_aply_tp_cd",  false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"dcgo_aply_tp_cd",    false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"tml_vol_aply_tp_cd", false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"ts_rt",     					false,          "",       dfNone,   		0,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"agmt_dtl_rmk",     	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"vrfyflg",     				false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,    sheetNo +"tml_agmt_dtl_seq",   false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  true,    sheetNo +"ibflag" );
                    //InitDataProperty(0, cnt++ , dtStatus,30,    daCenter,  true,    sheetNo +"ibflag" );

                    RangeBackColor(1, 9, 1, 15) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(1, 15, 2, 27) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(1, 27, 1, 56) = RgbColor(222, 251, 248);   // ENIS

                    /*
                     * ALPS 임시 주석 2009-08-19
		            CellBackColor(0,2) = SubHeaderColor  ;
		            CellBackColor(0,4) = SubHeaderColor  ;
		            CellBackColor(0,6) = SubHeaderColor  ;
		            CellBackColor(0,8) = SubHeaderColor  ;
		            CellBackColor(0,10) = SubHeaderColor  ;
		            CellBackColor(0,15) = SubHeaderColor  ;
		            CellBackColor(0,30) = SubHeaderColor  ;
		            CellBackColor(0,32) = SubHeaderColor  ;
		            CellBackColor(0,58) = SubHeaderColor  ;
		            CellBackColor(0,60) = SubHeaderColor  ;
		            CellBackColor(0,62) = SubHeaderColor  ;*/

                    InitDataCombo( 0 , sheetNo +"lgs_cost_cd" 				, lgsCostCDSheet	, lgsCostCDSheet);
                    InitDataCombo( 0 , sheetNo +"thrp_lgs_cost_cd" 		, tplgsCostCDSheet, tplgsCostCDSheet);

                    InitDataCombo( 0 , sheetNo +"curr_cd" 						, currCDSheet			, currCDSheet);
                    InitDataCombo( 0 , sheetNo +"lane_cd" 						, laneCDSheet1			, laneCDSheet2);
                    InitDataCombo( 0 , sheetNo +"auto_calc_flg" 			, "Y|N"						,	"Y|N");
                    InitDataCombo( 0 , sheetNo +"tml_agmt_vol_ut_cd" 	, vol_ut_cdCode		, vol_ut_cdCode);
                    InitDataCombo( 0 , sheetNo +"io_bnd_cd" 					, io_bnd_cdText		, io_bnd_cdCode);
                    InitDataCombo( 0 , sheetNo +"ioc_cd" 							, ioc_cdText			, ioc_cdCode);
					/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 -  null값 제거 (CAHD 2015-06-25)  */
                    InitDataCombo( 0 , sheetNo +"tml_trns_mod_cd"			, "Same|Truck|Rail|Barge|Feeder|Mother|Other", "S|T|R|B|F|V|O");
                    InitDataCombo( 0 , sheetNo +"thc_tp_cd" 					, thc_tp_cdText		, thc_tp_cdCode);

                    InitDataCombo( 0 , sheetNo +"wkdy_flg" 					  , " |Y"  					, " |Y");
                    InitDataCombo( 0 , sheetNo +"sat_flg" 					  , " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"sun_flg" 					  , " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"hol_flg" 					  , " |Y"						, " |Y");

                    //InitDataCombo( 0 , sheetNo +"dg_none" 					  , " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg_none" 			  , " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg" 					  , " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"sep_dg_none" 			  , " |Y"						, " |Y");

                    InitDataCombo( 0 , sheetNo +"dcgo_n1st_clss_flg" 	, " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n2nd_clss_flg" 	, " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n3rd_clss_flg" 	, " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n4th_clss_flg" 	, " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n5th_clss_flg" 	, " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n6th_clss_flg" 	, " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n7th_clss_flg" 	, " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n8th_clss_flg" 	, " |Y"						, " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n9th_clss_flg" 	, " |Y"						, " |Y");

                    InitDataValid(0, sheetNo +"fm_tr_vol_val", vtNumericOnly);
                    InitDataValid(0, sheetNo +"to_tr_vol_val", vtNumericOther, "MAXmax");

                    InitDataValid(0, sheetNo+"tml_ovt_shft_cd", vtEngUpOnly);

                    CountFormat = "[SELECTDATAROW / ROWCOUNT]";

                    HeadRowHeight  = 21;
                    HeadRowHeight  = 20;

                    style.height=GetSheetHeight(20);
                }
                break;

            case 4:   // t3sheet1(Storage Rate Input Tab : No of Tier Days) init 
                with (sheetObj) {

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle0 = " |Seq.|Tier Volume|Tier Volume";
                    var HeadTitle1 = " |Seq.|From|To";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,  30,    daCenter,  true,    "",     false,          "",       dfNone,   		0,     true,      true, 6);
                    InitDataProperty(0, cnt++ , dtDataSeq,     30,    daCenter,  true,    "",     false,          "",       dfNone,   		0,     true,      true, 6);
                    InitDataProperty(0, cnt++ , dtData,        70,    daCenter,  false,   "",     false,          "",       dfNone,   		0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,        50,    daCenter,  false,   "",     false,          "",       dfNone,   		0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,50,    daCenter,  false,   "",     false,          "",       dfNone,   		0,     true,      true, 1);

                    CellBackColor(1,2) = RgbColor(222, 251, 248);
                    CellBackColor(1,3) = CellBackColor(1,2);

                    CountPosition = 0 ;
                    sheetObj.InitDataValid(0, 2, vtNumericOnly);
                    sheetObj.InitDataValid(0, 3, vtNumericOther, "MAXmax");


                    style.height=GetSheetHeight(5);
                    
                }
                break;

             case 5:   //t4sheet1( Storage Rate List Tab) init 
                with (sheetObj) {

                    style.height=GetSheetHeight(16);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(118, 3, 0, true);

                	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                	InitHeadMode(true, true, false, true, false,false)

                	// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                    var HeadTitle0 = " |STS|Cost Code|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|"
                    + "Exclude Date|Exclude Date|Exclude Date|"
                    + "DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|"
                    + "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|"
                    + "Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|"
                    + "Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|"
                    + "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Verify\nResult|Remark";

                    var HeadTitle1 = " |STS|Cost Code|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "None|Same for all DG|Same for all DG|"
                    + "Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "SA|SU|Ho|"
                    + "None|Same for all DG|Same for all DG|"
                    + "Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|Separate rate for DG Class|"
                    + "From|To|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|"
                    + "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Verify\nResult|Remark";

                    var HeadTitle2 = " |STS|Cost Code|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
                    + "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "SA|SU|Ho|"
                    + "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                    + "From|To|Cal.\nPeriod|Pool\nTEU|Volume\nUOM|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|"
                    + "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|R8|R9|F2|F4|F5|O2|O4|O5|O7|S2|S4|T2|T4|A2|A4|A5|P2|P4|C2|C4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTon|Verify\nResult|Remark";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,                             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,  true,	"" );
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,	"" );
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,   sheetNo+ "lgs_cost_cd",			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,   sheetNo+ "curr_cd",			false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,   sheetNo+ "tml_sto_agmt_tp_cd",		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "cmnc_hrmnt",			false,          "",       dfUserFormat,	0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "io_bnd_cd",			false,          "",       dfNone,       0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "ft_dys",			false,          "",       dfNone,   		0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "ft_dys",			false,          "",       dfNone,   		0,     true,      true, 1);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "io_bnd_cd",			false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter,  true,   sheetNo+ "dg_none_fd",			false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "same_dg_none_fd",		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "same_dg_fd",			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "sep_dg_none_fd",		false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n1st_clss_flg_fd",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n2nd_clss_flg_fd",	false,          "",       dfNone,   		0,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n3rd_clss_flg_fd",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n4th_clss_flg_fd",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n5th_clss_flg_fd",	false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n6th_clss_flg_fd",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n7th_clss_flg_fd",	false,          "",       dfNone,   		0,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n8th_clss_flg_fd",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n9th_clss_flg_fd",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "sat_flg_fd",			false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "sun_flg_fd",			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "hol_flg_fd",			false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter,  true,   sheetNo+ "dg_none_r",			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "same_dg_none_r",		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "same_dg_r",			false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,  true,   sheetNo+ "sep_dg_none_r",		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n1st_clss_flg_r",	false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n2nd_clss_flg_r",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n3rd_clss_flg_r",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n4th_clss_flg_r",	false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n5th_clss_flg_r",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n6th_clss_flg_r",	false,          "",       dfNone,   		0,     true,      true);

                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n7th_clss_flg_r",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n8th_clss_flg_r",	false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,      20,    daCenter,  true,   sheetNo+ "dcgo_n9th_clss_flg_r",	false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   sheetNo+ "fm_tr_dys",			false,          "",       dfNone,   		0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   sheetNo+ "to_tr_dys",			false,          "",       dfNone,   		0,     true,      true, 3);

                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,   sheetNo+ "fp_calc_prd_cd",		false,          "",       dfNone,   	0,     true,      true, 6);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   sheetNo+ "fp_teu_qty",			false,          "",       dfInteger,   	0,     true,      true, 6);
                    InitDataProperty(0, cnt++ , dtCombo,      65,    daCenter,  true,   sheetNo+ "tml_agmt_vol_ut_cd",		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d2_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d4_fd",			false,          "",       dfInteger,    0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d5_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d7_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d8_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d9_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "dw_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "dx_fd",			false,          "",       dfInteger,    0,     true,      true, 3);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r2_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r4_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r5_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r7_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r8_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r9_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f2_fd",			false,          "",       dfInteger,    0,     true,      true, 3);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f4_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f5_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o2_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o4_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o5_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o7_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "s2_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "s4_fd",			false,          "",       dfInteger,    0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "t2_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "t4_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a2_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a4_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a5_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "p2_fd",			false,          "",       dfInteger,    0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "p4_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "c2_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "c4_fd",			false,          "",       dfInteger,   	0,     true,      true, 3);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d2_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d4_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d5_r",			false,          "",       dfFloat,      2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d7_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d8_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "d9_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "dw_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "dx_r",			false,          "",       dfFloat,      2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r2_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r4_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r5_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r7_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r8_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "r9_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f2_r",			false,          "",       dfFloat,      2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f4_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "f5_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o2_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o4_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o5_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "o7_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "s2_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "s4_r",			false,          "",       dfFloat,      2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "t2_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "t4_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a2_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a4_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "a5_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "p2_r",			false,          "",       dfFloat,      2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "p4_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "c2_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       30,    daCenter,  true,   sheetNo+ "c4_r",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "teu_rate",			false,          "",       dfFloat,      2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "box_rate",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "move_rate",			false,          "",       dfFloat,   	  2,     true,      true, 18);
                    // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "ton_rate",			false,          "",       dfFloat,   	  2,     true,      true, 18);

                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   sheetNo+ "verify_result",		false,          "",       dfNone,   		0,     false,     false);
                    InitDataProperty(0, cnt++ , dtPopup,      70,    daCenter,  true,   sheetNo+ "remark",			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,   sheetNo+ "agmt_dtl_rmk",		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,   sheetNo+ "xcld_dy_aply_tp_cd",		false,          "",       dfNone,   		0,     true,      true);
                    //InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,   sheetNo+ "fp_calc_prd_cd",		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      250,    daCenter,  true,   sheetNo+ "ts_rt",			false,          "",       dfNone,   		0,     true,      true);
		    
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,   sheetNo +"vrfyflg",			false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,      1,    daCenter,  true,   sheetNo +"tml_agmt_dtl_seq",		false,          "",       dfNone,   		0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  true,    sheetNo +"ibflag" );
                    //InitDataProperty(0, cnt++ , dtStatus,30,    daCenter,  true,    sheetNo +"ibflag" );

                    CellBackColor(1,9) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(1, 10, 2, 21) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(1, 22, 1, 25) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(1, 26, 2, 37) = RgbColor(222, 251, 248);   // ENIS
                    RangeBackColor(1, 38, 1, 91) = RgbColor(222, 251, 248);   // ENIS

/*
 * ALPS 임시 주석 2009-08-19
		            CellBackColor(0,2) = SubHeaderColor  ;
		            CellBackColor(0,4) = SubHeaderColor  ;
		            CellBackColor(0,6) = SubHeaderColor  ;
		            CellBackColor(0,8) = SubHeaderColor  ;
		            CellBackColor(0,22) = SubHeaderColor  ;
		            CellBackColor(0,38) = SubHeaderColor  ;
		            CellBackColor(0,41) = SubHeaderColor  ;
		            CellBackColor(0,67) = SubHeaderColor  ;
		            CellBackColor(0,93) = SubHeaderColor  ;
		            CellBackColor(0,95) = SubHeaderColor  ;
*/
                    InitDataCombo( 0 , sheetNo+"lgs_cost_cd" , lgsCostCDSheet, lgsCostCDSheet);
                    InitDataCombo( 0 , sheetNo +"tml_agmt_vol_ut_cd" , vol_ut_cdCode, vol_ut_cdCode);
                    InitDataCombo( 0 , sheetNo +"io_bnd_cd" , io_bnd_cdText, io_bnd_cdCode);
                    InitDataCombo( 0 , sheetNo+"curr_cd" , currCDSheet, currCDSheet);
                    InitDataCombo( 0 , sheetNo+"tml_sto_agmt_tp_cd" , tml_sto_agmt_tp_cd_cdCode, tml_sto_agmt_tp_cd_cdCode);
                    InitDataCombo( 0 , sheetNo+"ft_dys" , " |F", " |F");
                    InitDataCombo( 0 , sheetNo+"fp_calc_prd_cd" , " |D|M", " |D|M");

                    InitDataCombo( 0 , sheetNo +"sat_flg_fd" 					, " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"sun_flg_fd" 					, " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"hol_flg_fd" 					, " |Y", " |Y");

                    //InitDataCombo( 0 , sheetNo +"dg_none_fd" 					, " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg_none_fd" 		, " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg_fd" 					, " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"sep_dg_none_fd" 			, " |Y", " |Y");

                    InitDataCombo( 0 , sheetNo +"dcgo_n1st_clss_flg_fd" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n2nd_clss_flg_fd" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n3rd_clss_flg_fd" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n4th_clss_flg_fd" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n5th_clss_flg_fd" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n6th_clss_flg_fd" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n7th_clss_flg_fd" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n8th_clss_flg_fd" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n9th_clss_flg_fd" , " |Y", " |Y");

                    //InitDataCombo( 0 , sheetNo +"dg_none_r" 					, " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg_none_r" 			, " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"same_dg_r" 					, " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"sep_dg_none_r" 			, " |Y", " |Y");

                    InitDataCombo( 0 , sheetNo +"dcgo_n1st_clss_flg_r" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n2nd_clss_flg_r" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n3rd_clss_flg_r" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n4th_clss_flg_r" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n5th_clss_flg_r" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n6th_clss_flg_r" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n7th_clss_flg_r" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n8th_clss_flg_r" , " |Y", " |Y");
                    InitDataCombo( 0 , sheetNo +"dcgo_n9th_clss_flg_r" , " |Y", " |Y");

                    InitDataValid(0, sheetNo +"fm_tr_dys", vtNumericOnly);
                    InitDataValid(0, sheetNo +"to_tr_dys", vtNumericOther, "MAXmax");

                    InitUserFormat(0 , sheetNo+ "cmnc_hrmnt", "##:##", ":" );
                    CountFormat = "[SELECTDATAROW / ROWCOUNT]";

                    HeadRowHeight  =21;
                    HeadRowHeight  =20;
                    style.height=GetSheetHeight(20);

                }
                break;

             case 6:   //t1sheet3 init	agmt info
                 with (sheetObj) {

                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1 , 5, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(30, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "STS|amgt no.|agmt ver|yard|yardnm|vender|vendnm|eff fm|eff to|auto ext|ctrt ofc|remark|sts cd|cost cd|auto cacl|vol uom|currency|thrp_cost_cd_flg|SR AGMT Type|Commence Time|agmt_tp|cre ofc|agmt approval date|agmt confirm date|agmt confirm flag|cre_usr_id|agmt_doc_no|agmt_doc_desc|agmt_doc_eff_fm_dt|agmt_doc_eff_to_dt";
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtStatus,	30,    daCenter,		true,     "ibflag");
                     InitDataProperty(0, cnt++ , dtData,		90,    daCenter,		true,     "tml_agmt_ofc_cty_cd",		false,          "",       dfNone,     	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daCenter,		true,     "tml_agmt_ver_no",			false,          "",       dfNone,       0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "yd_cd",						false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "yd_nm",						false,          "",       dfNone,   	0,     true,      true);
                     
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "vndr_seq",					false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "vndr_lgl_eng_nm",			false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "eff_fm_dt",					false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "eff_to_dt",						false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "auto_xtd_flg",					false,          "",       dfNone,   	0,     true,      true);
                     
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "ctrt_ofc_cd",					false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "agmt_rmk",					false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "tml_agmt_sts_cd",			false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "lgs_cost_cd",					false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "auto_calc_flg",				false,          "",       dfNone,   	0,     true,      true);
                     
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "tml_agmt_vol_ut_cd",		false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "curr_cd",						false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "thrp_cost_cd_flg",			false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "tml_sto_agmt_tp_cd",		false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "cmnc_hrmnt",					false,          "",       dfNone,   	0,     true,      true);
                     
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "tml_agmt_tp_cd",				false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "cre_ofc_cd",					false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "agmt_apro_dt",				false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "agmt_cfm_dt",				false,          "",       dfNone,   	0,     true,      true);
                     // AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27) 
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "agmt_cfm_flg",				false,          "",       dfNone,   	0,     true,      true);
                     
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "cre_usr_id",					false,          "",       dfNone,   	0,     true,      true);
                     // 비용지급 전표 결재 기능 - 3차 GW LINK 삭제 (4347-09-25) 
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "agmt_doc_no",				false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "agmt_doc_desc",				false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "agmt_doc_eff_fm_dt",		false,          "",       dfNone,   	0,     true,      true);
                     InitDataProperty(0, cnt++ , dtData,		90,    daLeft,			true,     "agmt_doc_eff_to_dt",		false,          "",       dfNone,   	0,     true,      true);

                     CountPosition = 0 ;
                     style.height=GetSheetHeight(4);

                 }
                 break;
             case 7:   //t1sheet4 init
                with (sheetObj) {

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "thrp_cost_cd";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, COLMERGE, 		SAVENAME, 					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,   			90,    daCenter,  true,     "thrp_lgs_cost_cd",     false,          "",       dfNone,       0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,    daCenter,  false,   	"",     								false,          "",       dfNone,   		0,     true,      true, 1);

                    CountPosition = 0 ;
                    style.height=GetSheetHeight(4);

                }
              	 break;

             case 8:   //t1sheet5 (Verify Flag Sheet) init	
                with (sheetObj) {

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "cost_cd|vrfy";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  true,     "",     false,          "",       dfNone,          0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,     90,    daLeft,    true,     "",     false,          "",       dfNone,   		0,     true,      true,1);

                    CountPosition = 0 ;
                    style.height=GetSheetHeight(4);

                }

                break;
        }
    }

     // Sheet tab1 tire vol 부분 및 Cost Code (yard code값에 따른) 관련 프로세스 처리
 	/**
 	 * Sheet관련 프로세스 처리. <br>
 	 * Sheet tab1 tire vol 부분 및 Cost Code (yard code값에 따른) 관련 프로세스 처리.<br>
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
 	 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;

    	 switch(sAction) {

    	 	case IBINSERT:

    	 		var count = formObj.all.cnt1.value;
    	 		sheetObj.RemoveAll();
    	 		
    	 		for ( i = 0 ; i < count ; i ++){
    	 			Row = sheetObj.DataInsert(0);
    	 		}

    	 		for ( i = 0 ; i < count ; i ++){
    	 			
    	 			if(i = 1 && count >= 1){
    	 				sheetObj.CellValue(i+1, 2) = "1";
    	 			}

    	 			if(i = (count-1)){
    	 				sheetObj.CellValue(i+2, 3) = "MAX";
    	 			}
    	 		}

    	 		if(count == 1) {
    	 			sheetObj.CellValue(2,0) = 1;
    	 			sheetObj.CellValue(2,2) = "1";
    	 			sheetObj.CellValue(2,3) = "MAX";

    	 		}
    	 		break;

    	 	case SEARCH05:      //조회
    	 		formObj.f_cmd.value = SEARCH05;

    	 		if(tabObjects[0].selectedIndex == 0 ){
    	 			formObj.lgs_cost_cd.value = formObj.lgs_cost_cd_t.value;
    	 		
    	 		} else if(tabObjects[0].selectedIndex == 2){
    	 			formObj.lgs_cost_cd.value = formObj.lgs_cost_cd_s.value;
    	 		}
    	 		sheetObj.DoSearch4Post("ESD_TES_0034Verify.do", tesFrmQryStr(formObj));
    	 		break;

    	 	case SEARCH07:      //조회 -- 어따써..?
    	 		formObj.f_cmd.value = SEARCH07;
    	 		sheetObj.DoSearch4Post("ESD_TES_0034Verify.do", tesFrmQryStr(formObj));
    	 		break;
    	 }
     }

 	/**
      * Sheet 관련 프로세스 처리
      * Sheet tab1 over Shift 부분 및 curr code, lane code, cntr type/size 가져오는 관련 프로세스 처리
      * 
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
      */
	function doActionIBSheet2(sheetObj,formObj,sAction,isAppend) {
		sheetObj.ShowDebugMsg = false;

        switch(sAction) {

        case IBINSERT:
        	var count = formObj.all.cnt2.value;
        	sheetObj.RemoveAll();
        	
        	for ( i = 0 ; i < count ; i ++)
        	{
        		Row = sheetObj.DataInsert(0);
        	}
        	break;

        case SEARCH04:
        	formObj.f_cmd.value	= SEARCH04;
        	sheetObj.DoSearch4Post("ESD_TES_0034Detail.do", tesFrmQryStr(formObj), "",isAppend);
        	break;
        }
	}

 	/**
     * Sheet관련 프로세스 처리
     * Sheet tab2 terminal list 관련 프로세스 처리
     * 
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
     */	
	function doActionIBSheet3(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

        switch(sAction) {
        	case IBSEARCH:	//조회
        		formObj.sheet_prefix.value	= "3";
        		formObj.f_cmd.value 		= SEARCH02;
        		sheetObj.DoSearch4Post("ESD_TES_0035GS.do", tesFrmQryStr(formObj));
        		break;

       		// 사용되는곳 안보임 2009-10-12 
        	case IBSAVE:	//저장
        		formObj.tml_agmt_tp_cd.value	= "T";
        		formObj.sheet_prefix.value 		= "3";
        		formObj.f_cmd.value 			= MULTI;
        		formObj.select_tab.value 		= tabObjects[0].selectedIndex;
        		sheetObj.DoSave("ESD_TES_0035GS.do", tesFrmQryStr(formObj),-1,false);
        		break;

        	case IBINSERT:
        		var Row = sheetObj.DataInsert();
        		
        		//[CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 2)선택된 UOM이외에 다른 칸은 Grey-Out되어서 blokcing 되도록 설정(CAH D 2015.12.08)
        		// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
        		sheet_Rate_Set("T", sheetObj, Row, "C", "detail");		
				
        		break;

        	case IBDOWNEXCEL:        //엑셀 다운로드
        		sheetObj.Down2Excel4FreeForm(-1, false,false,true, "");
        		break;

        	case IBLOADEXCEL:  //엑셀내려받기
        		sheetObj.LoadExcel();
        		break;
        }
	}

 	/**
     * Sheet관련 프로세스 처리
     * Sheet tab3 storage tier days관련 프로세스 처리
     * 
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
     */	
    function doActionIBSheet4(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

        case IBINSERT:
        	var count = formObj.all.cnt3.value;
        	sheetObj.RemoveAll();
        	
        	for ( i = 0 ; i < count ; i ++){
        		Row = sheetObj.DataInsert(0);
        	}

        	for ( i = 0 ; i < count ; i ++){
        		if(i=1 && count >= 1){

        			sheetObj.CellValue(i+1,2)="1";
        		}

        		if(i=(count-1)){
        			sheetObj.CellValue(i+2,3)="MAX";
        		}
        	}

        	if(count==1){

        		sheetObj.CellValue(2,0)=1;
        		sheetObj.CellValue(2,2)="1";
        		sheetObj.CellValue(2,3)="MAX";

        	}
        	break;

        }
    }

 	/**
     * Sheet관련 프로세스 처리
     * Sheet tab 4 storage list 관련 프로세스 처리
     * 
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
     */	
    function doActionIBSheet5(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {
    		case IBSEARCH:      //조회

    			formObj.f_cmd.value			= SEARCH;
            	formObj.sheet_prefix.value	= "5";
            	formObj.f_cmd.value			= SEARCH03;
            	sheetObj.DoSearch4Post("ESD_TES_0035GS.do", tesFrmQryStr(formObj));
            	break;

    		case IBSAVE:        //저장 ( 사용하는곳 안보임 (2009-10-19)

    			formObj.sheet_prefix.value	= "5";
    			formObj.f_cmd.value			= MULTI05;
    			formObj.select_tab.value	= tabObjects[0].selectedIndex;

    			sheetObj.DoSave("ESD_TES_0035GS.do", tesFrmQryStr(formObj),-1,false);
    			break;

    		case IBINSERT:

    			var Row = sheetObj.DataInsert();

                //[CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 2)선택된 UOM이외에 다른 칸은 Grey-Out되어서 blokcing 되도록 설정(CAH D 2015.12.08)
    			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
                sheet_Rate_Set("S", sheetObj, Row, "C", "detail");
				
    			break;

    		case IBDOWNEXCEL:        //엑셀 다운로드

    			//sheetObj.SpeedDown2Excel(-1);
    			sheetObj.Down2Excel4FreeForm(-1, false,false,true, "");
    			break;

    		case IBLOADEXCEL:  //엑셀내려받기

    			sheetObj.LoadExcel();
    			break;
    	}
    }
    
    /**
     * Sheet hidden sheet agmt hdr 정보 가져오는 관련 프로세스 처리. <br>
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
     **/
	function doActionIBSheet6(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:      //조회
				sheetObj.removeAll();
				sheetObj.DoSearch4Post("ESD_TES_0034GS.do", tesFrmQryStr(formObj));
				doActionIBSheet6SearchFlg	= "";
				doActionIBSheet6SearchFlg	= insertData();
				
				if(doActionIBSheet6SearchFlg != "NoData"){
					lane_Change();
					initformDTL();
				}
			break;
			
			case IBSAVE:        //저장
				if(sheetObj.selectedIndex == "0" && sheetObj.selectedIndex == "1"){
					formObj.tml_agmt_sts_cd.value	= "T";
					formObj.tml_agmt_tp_cd.value	= "T";
//					tml_agmt_tp_cd
					
				} else if(sheetObj.selectedIndex == "2" && sheetObj.selectedIndex == "3"){
					formObj.tml_agmt_sts_cd.value	= "S";
					formObj.tml_agmt_tp_cd.value	= "S";
				}
				// DoSave는 쉬트를 기본조건으로 해서 저장이 안되는 문제로 인하여  GetSaveXml 로 변경 ( 2009-10-23 )
//				sheetObj.DoSave("ESD_TES_0034GS.do", tesFrmQryStr(formObj), -1, false);
				var	sXml	= sheetObj.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObj));
				// GetSaveXml후에 OnSaveEnd Function 을 alert Message.. (2010-02-18)
				sheetObj.LoadSaveXml(sXml, true);
			break;
			
			case IBDELETE:			// 비용지급 전표 결재 기능 - 3차 GW LINK 삭제 (4347-09-25)
				if (sheetObj.selectedIndex == "0" && sheetObj.selectedIndex == "1") {
					formObj.tml_agmt_sts_cd.value	= "T";
					formObj.tml_agmt_tp_cd.value		= "T";

				} else if (sheetObj.selectedIndex == "2" && sheetObj.selectedIndex == "3") {
					formObj.tml_agmt_sts_cd.value	= "S";
					formObj.tml_agmt_tp_cd.value		= "S";
				}
                
				formObj.f_cmd.value	= MODIFY01;
                var saveXml = sheetObj.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObj) );
                sheetObj.LoadSaveXml(saveXml,true);
                break;
		}
	}

    /**
     * Sheet hidden sheet thrp code 정보 가져오는 관련 프로세스 처리. <br>
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
     **/
    function doActionIBSheet7(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

        	case IBSEARCH:      //조회
        		formObj.f_cmd.value	= SEARCH01;
        		sheetObj.DoSearch4Post("ESD_TES_ThrpccGS.do", tesFrmQryStr(formObj));
        		break;

        	case IBSAVE:        //저
        		if(sheetObj.selectedIndex == "1" && sheetObj.selectedIndex =="2"){
        			formObj.tml_agmt_sts_cd.value	= "T";
        			
        		}else if(sheetObj.selectedIndex == "3" && sheetObj.selectedIndex =="4") {
        			formObj.tml_agmt_sts_cd.value	= "S";
        		}
        		sheetObj.DoSave("ESD_TES_0034GS.do", tesFrmQryStr(formObj),-1,false);
        		break;
        }
    }

    /**
     * Sheet hidden sheet verify flag 정보 가져오는 관련 프로세스 처리. <br>
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
     **/
    function doActionIBSheet8(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

        switch(sAction) {

        	case IBSEARCH:
        		sheetObjects[7].RemoveAll();
        		formObj.select_tab.value	= tabObjects[0].selectedIndex;
        		formObj.f_cmd.value		= SEARCH07;
               	
        		if(tabObjects[0].selectedIndex == 1 ) {
        			var param = sheetObjects[2].GetSaveString(true);
					
        		} else if(tabObjects[0].selectedIndex == 3 ) {
        			var param = sheetObjects[4].GetSaveString(true);
        		}

        		var sXml = sheetObjects[7].GetSearchXml("ESD_TES_0034VerifyGS.do", param+'&'+tesFrmQryStr(formObj),"",true);
        		sheetObjects[7].LoadSearchXml(sXml);
        		break;
        }
    }

	/**
	 * t2sheet1 (Terminal Rate List Tab ) Sheet Popup Click 프로세스 처리. <br>
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {int,String}	row			Row Index
	 * @param {int,String}	col			Column Index
	 **/
	function t2sheet1_OnPopupClick(sheetObj , row , col )
	{
		var formObj = document.form;
		var myOption = "width=410,height=420,menubar=0,status=0,scrollbars=0,resizable=0";

		var myWin = window.open('', "popagmtcrermk1", myOption);
		myWin.focus();
		
		formObj.pop_cost_cd.value  = sheetObjects[2].CellValue(row, "3lgs_cost_cd");
		formObj.pop_sheetObj.value = "t2sheet1";
		formObj.pop_row.value      = row;
		formObj.pop_agmt_rmk.value = sheetObjects[2].CellValue(row, "3agmt_dtl_rmk");
		formObj.pop_mode.value     = "create"
		formObj.action			   = 'ESD_TES_9080.screen';
		formObj.target			   = 'popagmtcrermk1';
		
		formObj.submit();
    }

	/**
	 * t4sheet1 (Storage Rate List Tab ) Sheet Popup Click 프로세스 처리. <br>
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {int,String}	row			Row Index
	 * @param {int,String}	col			Column Index
	 **/
	function t4sheet1_OnPopupClick(sheetObj , row , col )
	{
		var formObj = document.form;
		var myOption = "width=410,height=420,menubar=0,status=0,scrollbars=0,resizable=0";

		var myWin = window.open('', "popagmtcrermk2", myOption);
		myWin.focus();
		
		formObj.pop_cost_cd.value  = sheetObjects[4].CellValue(row, "5lgs_cost_cd");
		formObj.pop_sheetObj.value = "t4sheet1";
		formObj.pop_row.value      = row;
		formObj.pop_agmt_rmk.value = sheetObjects[4].CellValue(row, "5agmt_dtl_rmk");
		formObj.pop_mode.value     = "create"
		formObj.action			   = 'ESD_TES_9080.screen';
		formObj.target			   = 'popagmtcrermk2';
		
		formObj.submit();
    }
    
    /**
     * IBTab Object 를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의. <br>
     * @param{tab_obj}		tab_obj		Tab Object
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

	/**
	 * Tab 기본 설정. <br>
	 * 탭의 항목을 설정한다. <br>
	 * @param{ibtab}		tab_obj		Tab Object
	 * @param{int,String}	tab No		Tab No
	 */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Terminal Rate Input", -1 );
                    InsertTab( cnt++ , "Terminal Rate List" , -1 );
                    InsertTab( cnt++ , "Storage Rate Input" , -1 );
                    InsertTab( cnt++ , "Storage Rate List"	, -1 );
                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련<br>
     * 선택한 탭의 요소가 활성화 된다.<br>
     * 
     * @param{ibTab}	tab_obj		Tab Object
     * @param{String}	nItem		Tab No
     */
    function tab1_OnChange(tabObj , nItem)
    {
      var objs = document.all.item("tabLayer");

    	objs[nItem].style.display		= "Inline";
    	objs[beforetab].style.display	= "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex	= objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab	= nItem;
    }

    
    /**
     * Yard 정보( Code, Name) 셋팅. <br>
     * 
     * @param{Array}		rowArray	rowArray
     */
    function getYard(rowArray) {
    	var colArray = rowArray[0];
    	document.all.yd_cd.value = colArray[3];
    	document.all.yd_cd_name.value = colArray[4];
		
    	// 1, 2
//    	if(sheetObjects[5].CellValue(1, 1)!= "" && sheetObjects[5].CellValue(1, 2)!= "" && sheetObjects[5].CellValue(1, 1)!= undefined && sheetObjects[5].CellValue(1, 2)!= undefined){
    	if(sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != undefined ){
    		lane_Change();
    	}
    }

    /**
     * Vendor 정보( Code, Name) 셋팅. <br>
     * 
     * @param{Array}		rowArray	rowArray
     */
    function getVender(rowArray) {
    	var colArray = rowArray[0];
    	document.all.vndr_seq.value = colArray[2];
    	document.all.vndr_seq_name.value = colArray[4];
    }

    /**
     * Agreement Copy 이전 정보 조회. <br>
     */
    function AgreementCopy_before() {
    	
    	// Terminal Rate Input 
    	if(tabObjects[0].selectedIndex == 0){
    		sheetObjects[2].RemoveAll();
    		document.form.tml_agmt_tp_cd.value	= "T";
    		tabObjects[0].selectedIndex			= 1;

    		document.form.f_cmd.value			= SEARCH ;
    		//doActionIBSheet6(sheetObjects[5],document.form,IBSEARCH);

    		doActionIBSheet3(sheetObjects[2],document.form,IBSEARCH);

//    		if (sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) !="" && sheetObjects[5].CellValue(1, 3) !=""){
    		if (sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].CellValue(1, "tml_agmt_ver_no" ) != "" ){
    			insertData();
    			document.form.ctrt_ofc_cd.value = document.form.cre_ofc_cd.value
    		}
    		
       	// Storage Rate Input 
    	}else if(tabObjects[0].selectedIndex==2){
    		sheetObjects[4].RemoveAll();
    		document.form.tml_agmt_tp_cd.value="S";
    		tabObjects[0].selectedIndex = 3;

    		document.form.f_cmd.value = SEARCH ;
    		//doActionIBSheet6(sheetObjects[5],document.form,IBSEARCH);

    		doActionIBSheet5(sheetObjects[4],document.form,IBSEARCH);
			
//    		if (sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) !="" && sheetObjects[5].CellValue(1, 3) !=""){
    		if (sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].CellValue(1, "tml_agmt_ver_no") ){
    			insertData();
    			document.form.ctrt_ofc_cd.value = document.form.cre_ofc_cd.value
    		}
    	}
    }

    /**
     * Agreement Rate 정보 Copy . <br>
     */
   	function AgreementCopy() {
   		sheetObjects[2].RemoveAll();
   		document.form.tml_agmt_tp_cd.value	= "T";
   		tabObjects[0].selectedIndex			= 1;

   		document.form.f_cmd.value			= SEARCH ;
   		doActionIBSheet3(sheetObjects[2],document.form,IBSEARCH);

   		for(var i =0;i<sheetObjects[2].RowCount;i++){
   			sheetObjects[2].RowStatus(i+3)	= "I";
   		}

   		sheetObjects[4].RemoveAll();
   		document.form.tml_agmt_tp_cd.value	= "S";
   		tabObjects[0].selectedIndex			= 3;
   		
   		document.form.f_cmd.value			= SEARCH ;
   		doActionIBSheet5(sheetObjects[4],document.form,IBSEARCH);

   		for(var i =0;i<sheetObjects[4].RowCount;i++){
   			sheetObjects[4].RowStatus(i+3) = "I";
   		}

//   		if (sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) !="" && sheetObjects[5].CellValue(1, 3) !=""){
   		if (sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].CellValue(1, "tml_agmt_ver_no") != "" ){
   			insertData();
   			document.form.ctrt_ofc_cd.value = sheetObjects[5].CellValue(1, "ctrt_ofc_cd");	// 7
   		}
   	}

    /**
     * t2sheet1 ( Terminal Rate List Tab ) Sheet에 있는 조회후 프로세스 처리. <br>
     * 
     * @param{ibsheet}		sheetObj	Sheet Object
     * @param{String}		errMsg		Error Message
     */
    function t2sheet1_OnSearchEnd(sheetObj,errMsg){
        var formObject = document.form;
        var tmpModeValue = "";
        var sheetNo  = 3;

        if(errMsg!=null){
            ComShowMessage(errMsg);
        }

        for(var i=0;i<sheetObj.RowCount;i++){
            if(sheetObj.CellValue(i+3,"3curr_cd") == "KRW" || sheetObj.CellValue(i+3, "3curr_cd") == "JPY"){
                currRateModRow('terminal',i+3, dfInteger);
            }
            if( sheetObj.CellValue(i+3,"3lgs_cost_cd")=="TMNDRF" || sheetObj.CellValue(i+3,"3lgs_cost_cd")=="TMNDRM" ) {
            	/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 -  null값 제거 (CAHD 2015-06-25)  */            	
//            	sheetObj.CellComboItem( i+3 , "3tml_trns_mod_cd", "|Rail", "|R");
            	sheetObj.CellComboItem( i+3 , "3tml_trns_mod_cd", "Same|Rail", "S|R");
        	}
            
			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
            sheet_Rate_Set ("T", sheetObj, i, sheetObj.CellValue(i+3, "3tml_agmt_vol_ut_cd"), "header");
        }
        
        setTooltip(sheetObj,sheetNo+'remark');
    }


    /**
     * Terminal / Storage Rate List Column CellEditable 설정
     * 
     * [CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 2)선택된 UOM이외에 다른 칸은 Grey-Out되어서 blokcing 되도록 설정(CAH D 2015.12.08)
     * CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
     * 
     * @param agmtType
     * @param sheetObj
     * @param i
     * @param UOM
     * @param mode(header : Title Header 포함, detail : Title Header 미포함
     */
    function sheet_Rate_Set(agmtType, sheetObj, iRow, UOM, mode) 
    {
    	var cntr_rate			= false;
    	var cntr_days		= false;
    	var teu_rate			= false;
    	var box_rate			= false;
    	var move_rate		= false;
    	var gang_hour_rate	= false;
    	var ton_rate			= false;
    	var row				= 0;
    	
    	if ( "header" == mode) {
    		row = iRow + 3;
    	} else {
    		row = iRow;
    	}
    	
    	if ( "C" == UOM ) {
    		if ( "S" == agmtType && sheetObj.CellValue(row, "5ft_dys")=="F") {
    			cntr_days = true;
    		} else {
    			cntr_rate = true;
    		}
    	} else if ( "T" == UOM ) {
    		teu_rate = true;
    	} else if ( "B" == UOM ) {
    		box_rate = true;
    	} else if ( "M" == UOM ) {
    		move_rate = true;
    	} else if ( "G" == UOM ) {
    		gang_hour_rate = true;
    	} else if ( "W" == UOM ) {
    		ton_rate = true;
    	}    	
    	
    	// Terminal Rate List
    	if ( "T" == agmtType) {
    		
    		for(var l=0; l<arrCntrTpSz.length; l++){
    			sheetObj.CellEditable(row, "3"+arrCntrTpSz[l]) = cntr_rate;
    		}
    		sheetObj.CellEditable(row, "3teu_rate")			= teu_rate;
    		sheetObj.CellEditable(row, "3box_rate")			= box_rate;
    		sheetObj.CellEditable(row, "3move_rate")		= move_rate;
    		sheetObj.CellEditable(row, "3gang_hour_rate")	= gang_hour_rate;
    		sheetObj.CellEditable(row, "3ton_rate")			= ton_rate;
    		
		// Storage Rate List
    	} else {
            //[CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 2)선택된 UOM이외에 다른 칸은 Grey-Out되어서 blokcing 되도록 설정(CAH D 2015.12.08)
			if( "C" == UOM ) {
				for(var l=0; l<arrCntrTpSz.length; l++){
					sheetObj.CellEditable(row, "5"+arrCntrTpSz[l]+"_fd") = cntr_days;
				}
				for(var l=0; l<arrCntrTpSz.length; l++){
					sheetObj.CellEditable(row, "5"+arrCntrTpSz[l]+"_r") = cntr_rate;
				}
			} else {
				for(var l=0; l<arrCntrTpSz.length; l++){
					sheetObj.CellEditable(row, "5"+arrCntrTpSz[l]+"_fd") = cntr_rate;
				}
				for(var l=0; l<arrCntrTpSz.length; l++){
					sheetObj.CellEditable(row, "5"+arrCntrTpSz[l]+"_r") = cntr_rate;
				}
			}
			sheetObj.CellEditable(row, "5teu_rate")		= teu_rate;
			sheetObj.CellEditable(row, "5box_rate")		= box_rate;
			sheetObj.CellEditable(row, "5move_rate")	= move_rate;			
			sheetObj.CellEditable(row, "5ton_rate")		= ton_rate;
    	}
    }
    
    
    /**
     * t4sheet1 Sheet에 있는 조회후 프로세스 처리. <br>
     * 
     * @param{ibsheet}		sheetObj	Sheet Object
     * @param{string}		errMsg		Error Message
     */
    function t4sheet1_OnSearchEnd(sheetObj,errMsg){
        var formObject = document.form;
        var sheetNo  = 5;

        if(errMsg!=null){
            ComShowMessage(errMsg);
        }

        for(var i=0;i<sheetObj.RowCount;i++){
            if(sheetObj.CellValue(i+3,"5curr_cd") == "KRW" || sheetObj.CellValue(i+3, "5curr_cd") == "JPY"){
                currRateModRow('storage',i+3, dfInteger);
            }
            
            //[CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 2)선택된 UOM이외에 다른 칸은 Grey-Out되어서 blokcing 되도록 설정(CAH D 2015.12.08)
            sheet_Rate_Set("S", sheetObj, i, sheetObj.CellValue(i+3, "5tml_agmt_vol_ut_cd"), "header");
        }
        setTooltip(sheetObj,sheetNo+'remark');
    }

    /**
     * Storage Rate List Column CellEditable 설정
     * 
     * [CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 2)선택된 UOM이외에 다른 칸은 Grey-Out되어서 blokcing 되도록 설정(CAH D 2015.12.08)
     * CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
     * 
     * @param sheetObj
     * @param i
     * @param UOM
     * @param mode(header : Title Header 포함, detail : Title Header 미포함
     */
    function t4sheet1_Rate_Set(sheetObj, i, UOM, mode) 
    {
    	var cntr_rate			= false;
    	var teu_rate			= false;
    	var box_rate			= false;
    	var move_rate		= false;
    	var gang_hour_rate	= false;
    	var ton_rate			= false;
    	var row				= 0;
    	
    	if ( "C" == UOM ) {
    		cntr_rate = true;
    	} else if ( "T" == UOM ) {
    		teu_rate = true;
    	} else if ( "B" == UOM ) {
    		box_rate = true;
    	} else if ( "M" == UOM ) {
    		move_rate = true;
    	} else if ( "G" == UOM ) {
    		gang_hour_rate = true;
    	} else if ( "W" == UOM ) {
    		ton_rate = true;
    	}    	
    	
    	if ( "header" == mode) {
    		row = i + 3;
    	} else {
    		row = i;
    	}
    	
		for ( j = 32 ; j < 63; j++) {
			sheetObj.CellEditable(row, j) = cntr_rate;
		}
		sheetObj.CellEditable(row, "3teu_rate")			= teu_rate;
		sheetObj.CellEditable(row, "3box_rate")			= box_rate;
		sheetObj.CellEditable(row, "3move_rate")		= move_rate;
		sheetObj.CellEditable(row, "3gang_hour_rate")	= gang_hour_rate;
		sheetObj.CellEditable(row, "3ton_rate")			= ton_rate;
    }
    /**
     * t1sheet2 (No of Overtime Shift) Sheet에 있는 조회후 프로세스 처리. <br>
     * Sheet 정보 설정.<br>
     * 
     * @param{ibsheet}		sheetObj	Sheet Object
     * @param{String}		errMsg		Error Message
     */
    function t1sheet2_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
            ComShowMessage(errMsg);
        }

        var lccvalue	= sheetObj.EtcData("lgsCostCDText");
        var tlccvalue	= sheetObj.EtcData("terminalLgsCostCDText");
        var slccvalue	= sheetObj.EtcData("storageLgsCostCDText");
        // CHM-201642291 Agreement/invoice에서 Cost Code Description 추가 (2016-07-20) 
        var tlccnmvalue	= sheetObj.EtcData("terminalLgsCostCDName");
        var tlccabnmvalue	= sheetObj.EtcData("terminalLgsCostCDAbbrName");
        var slccnmvalue	= sheetObj.EtcData("storageLgsCostCDName");
        var slccabnmvalue	= sheetObj.EtcData("storageLgsCostCDAbbrName");
        var cctvalue	= sheetObj.EtcData("currCDText");
        var cctDefvalue	= sheetObj.EtcData("currCDTextDef");
        var lctvalue	= sheetObj.EtcData("laneCDText");
        var cttvalue	= sheetObj.EtcData("cntrTPText");
        var cstvalue	= sheetObj.EtcData("cntrSZText");
        document.form.lane_cdString.value=lctvalue;
        currCodeDef		= cctDefvalue;

        lgsCostCDSheet  = sheetObj.EtcData("lgsCostCDSheet");
        terminalLgsCostCDSheet  = sheetObj.EtcData("terminalLgsCostCDSheet");
        storageLgsCostCDSheet  = sheetObj.EtcData("storageLgsCostCDSheet");
        terminalLgsCostCDName  = sheetObj.EtcData("terminalLgsCostCDName");
        storageLgsCostCDName  = sheetObj.EtcData("storageLgsCostCDName");
        sheetObjects[2].InitDataCombo(0, '3lgs_cost_cd'	,terminalLgsCostCDName,  terminalLgsCostCDSheet);
        sheetObjects[4].InitDataCombo(0, '5lgs_cost_cd'	,storageLgsCostCDName,  storageLgsCostCDSheet);

        tplgsCostCDSheet = " |"+sheetObj.EtcData("tplgsCostCDText");
        sheetObjects[2].InitDataCombo(0, '3thrp_lgs_cost_cd'	,tplgsCostCDSheet,  tplgsCostCDSheet);

        //currCDSheet  = " "+sheetObj.EtcData("currCDSheet");
        currCDSheet  = sheetObj.EtcData("currCDSheet");
        sheetObjects[2].InitDataCombo(0, '3curr_cd'	,currCDSheet,  currCDSheet);
        sheetObjects[4].InitDataCombo(0, '5curr_cd'	,currCDSheet,  currCDSheet);
        
        /* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 -  null값 제거 (CAHD 2015-06-25)  */
        laneCDSheet1	= "Same|OTH"+sheetObj.EtcData("laneCDSheet");
        laneCDSheet2	= "Sam|OTH"+sheetObj.EtcData("laneCDSheet");

        sheetObjects[2].InitDataCombo(0, '3lane_cd'	,laneCDSheet1,  laneCDSheet2);

        for(p=0;p< comboObjects.length;p++){
        	// CHM-201642291 Agreement/invoice에서 Cost Code Description 추가 (2016-07-20) 
        	initCombo (comboObjects[p],p+1, tlccvalue, slccvalue, cctvalue, lctvalue, cttvalue, cstvalue, cctDefvalue, tlccabnmvalue, slccabnmvalue);
        }
    }

    /**
     * Combo Box 초기 설정.<br>
     * 
     * @param{comboObj}		comboObj	Combo Object
     * @param{comboNo}		comboNo		Combo No
     * @param{tlccvalue}	tlccvalue	
     * @param{slccvalue}	slccvalue	
     * @param{cctvalue}		cctvalue	
     * @param{lctvalue}		lctvalue	
     * @param{cttvalue}		cttvalue	
     * @param{cstvalue}		cstvalue	
     * @param{cctDefvalue}	cctDefvalue	
     * @param{tlccabnmvalue}	tlccabnmvalue	
     * @param{slccabnmvalue}	slccabnmvalue	
     */
	// CHM-201642291 Agreement/invoice에서 Cost Code Description 추가 (2016-07-20) 
   	function initCombo (comboObj, comboNo, tlccvalue, slccvalue, cctvalue, lctvalue, cttvalue, cstvalue, cctDefvalue, tlccabnmvalue, slccabnmvalue) {
    	var cnt			= 0 ;
        var tlccArray	= tlccvalue.split("|");
        var tlccNmArray	= tlccabnmvalue.split("|");
        var slccArray	= slccvalue.split("|");
        var slccNmArray	= slccabnmvalue.split("|");
        var cctArray	= cctvalue.split("|");
        var lctArray	= lctvalue.split("|");
        var cttArray	= cttvalue.split("|");
        var cstArray	= cstvalue.split("|");

        var valueArray;
        var time;
        switch(comboNo) {
        	// Terminal Input Rate TAB CostCode Combobox
        	case 1:	// lgs_cost_cd_t
        		comboObj.RemoveAll();

        		with (comboObj) {
        			SetColAlign("left");
        			SetColWidth("70|300");
        			for(i=0 ;i<tlccArray.length;i++){
        				valueArray = tlccArray[i].split("--");
        				
        				if(valueArray[0] == ""){
        					break;
        				}
        				// CHM-201642291 Agreement/invoice에서 Cost Code Description 추가 (2016-07-20) 
        				InsertItem(cnt++, valueArray[0] + '|' + tlccNmArray[i], valueArray[0]);
        			}
        		}
        		break;

        	case 2:
        		comboObj.RemoveAll();
        		with (comboObj) {
        			SetColAlign("left");
        			SetColWidth("40")

        			for(i=0 ;i<cctArray.length;i++){
        				//valueArray = cctArray[i].split("--");
        				//InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
        				InsertItem(cnt++, cctArray[i], cctArray[i]);
        			}
        			Code = cctDefvalue;
        		}
        		break;

        	case 3:
        		comboObj.RemoveAll();
        		with (comboObj) {
        			SetColAlign("left");
        			SetColWidth("40")

        			//InsertItem(cnt++, '' + '|' + '', '');
        			InsertItem(cnt++, 'Same' + '|' + '', 'Sam');
        			InsertItem(cnt++, 'OTH' + '|' + '', 'OTH');
        			
        			for(i=0 ;i<lctArray.length;i++){
        				valueArray = lctArray[i].split("--");
        				
        				if(i == (lctArray.length-1)){
        					break;
        				}
        				InsertItem(cnt++,valueArray[1] + '|' +valueArray[0], valueArray[0]);
        			}
        		}
        		break;

        	case 4:
        		comboObj.RemoveAll();
        		with (comboObj) {
        			SetColAlign("left");
        			SetColWidth("40");

        			for(i=0 ;i<cttArray.length;i++){
        				valueArray = cttArray[i].split("--");
        				InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
        			}
        		}
        		break;

        	case 5:
        		comboObj.RemoveAll();
        		with (comboObj) {
        			SetColAlign("left");
        			SetColWidth("40")

        			for(i=0 ;i<cstArray.length;i++){
        				valueArray = cstArray[i].split("--");
        				InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
        			}
        		}
        		break;

       		// Storage Input Rate TAB CostCode Combobox
        	case 6:
        		comboObj.RemoveAll();

        		with (comboObj) {
        			SetColAlign("left");
        			SetColWidth("70|200");

        			for(i=0 ;i<slccArray.length;i++){
        				valueArray = slccArray[i].split("--");
			            
        				if(valueArray[0] == ""){
        					break;
        				}
        				// CHM-201642291 Agreement/invoice에서 Cost Code Description 추가 (2016-07-20) 
        				InsertItem(cnt++, valueArray[0] + '|' + slccNmArray[i], valueArray[0]);
        			}
        		}
        		break;

        	case 7:
        		comboObj.RemoveAll();
        		with (comboObj) {
        			SetColAlign("left");
        			SetColWidth("40")


        			for(i=0 ;i<cctArray.length;i++){
        				//valueArray = cctArray[i].split("--");
        				//InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
        				InsertItem(cnt++, cctArray[i], cctArray[i]);
        			}
        			Code = cctDefvalue;
        		}
        		break;

             case 8:
            	 comboObj.RemoveAll();
            	 with (comboObj) {
            		 SetColAlign("left");
            		 SetColWidth("40")

            		 for(i=0 ;i<cttArray.length;i++){
            			 valueArray = cttArray[i].split("--");
            			 InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
            		 }
            	 }
            	 break;

             case 9:
            	 comboObj.RemoveAll();
            	 with (comboObj) {
            		 SetColAlign("left");
            		 SetColWidth("40")
            		 
            		 for(i=0 ;i<cstArray.length;i++){
            			 valueArray = cstArray[i].split("--");
            			 InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);
            		 }
            	 }
            	 break;

             case 10:
            	 with (comboObj) {

            		 SetColAlign("left|left");
            		 SetColWidth("30|50");

            		 var tmp			= '';
            		 var tmp2			= '';
            		 var curr_def_val	= '';
            		 
            		 if (combo_val != null){
            			 tmp = combo_val.split('--');
            		 }
					
            		 for (var i=0; tmp!=null && i<tmp.length; i++){
            			 tmp2 = '';
            			 tmp2 = tmp[i].split('|');

            			 if (tmp2!=null){
            				 InsertItem(cnt++, new String(tmp[i]), new String(tmp2[0]));
							
            				 if (tmp2[0]!='USD'){
            					 curr_def_val = tmp2[0];
            				 }
									}
            		 }
            		 
            		 if (curr_def_val!=undefined && curr_def_val!=null && curr_def_val.trim()!=''){
            			 Code = curr_def_val;
            		 }
            	 }
            	 break;

        }

    }

    /**
     * ComboBox Object를 배열로 등록. <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다. <br>
     * 배열은 소스 상단에 정의. <br>
     * 
     * @param {combo_obj}  	combo_obj	Combo Object
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Terminal Rate Input Tab LGS Cost Code 변경시 프로세스 처리.<br>
     * 
     * @param {Object}  	comObj		ComboBox Object
     * @param {int,String}	index		index
     * @param {String}  	text		text
     */
    function lgs_cost_cd_t_OnChange(comObj,index,text)
    {
    	document.form.lgs_cost_cd_t.value = comObj.Code;
    	costCodeT = comObj.Code;

    	if( comObj.Code == "TPNDFL" || comObj.Code == "SVLDFL" ||
    		comObj.Code == "TMNDFL" || comObj.Code == "TMNDMT" ) {
    		document.form.tml_trns_mod_cd[0].disabled = false;
    		document.form.tml_trns_mod_cd[1].disabled = false;
    		var obj_mode = document.all.item("modeLayer");
	        obj_mode[0].style.display = "none";
	      	obj_mode[1].style.display = "inline";
	      	obj_mode[2].style.display = "none";
	      	
    	}else if(comObj.Code == "TPNDTS" || comObj.Code == "SVLDTS" || comObj.Code == "TMNDTS" ) {
    		document.form.tml_trns_mod_cd[0].disabled = false;
    		document.form.tml_trns_mod_cd[1].disabled = false;
    		var obj_mode = document.all.item("modeLayer");
	        obj_mode[0].style.display = "none";
	      	obj_mode[1].style.display = "none";
	      	obj_mode[2].style.display = "inline";
	      	
    	}else{
    		document.form.tml_trns_mod_cd[0].disabled = true;
    		document.form.tml_trns_mod_cd[1].disabled = true;
    	}

    	comboObjects[1].Code = currCodeDef;

    	document.form.command_h.value = "S";
    	
    	if(comboObjects[0].Code != ""){
    		doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
    	}
    }

    /**
     * Storage Rate Input Tab LGS Cost Code 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function lgs_cost_cd_s_OnChange(comObj,index,text)
    {
    	document.form.lgs_cost_cd_s.value = comObj.Code;
    	costCodeS = comObj.Code

    	document.form.command_h.value = "S";
    	if(comboObjects[5].Code !=""){
    		doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
    	}
    }

    /**
     * Terminal Rate Input Tab Currency Code 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function curr_cd_t_OnChange(comObj,index,text)
    {
       document.form.curr_cd_t.value	= comObj.Code;
       document.form.command_h.value	= "S";
    }

    /**
     * Storage Rate Input Tab Currency Code 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function curr_cd_s_OnChange(comObj,index,text)
    {
       document.form.curr_cd_s.value	= comObj.Code;
       document.form.command_h.value	= "S";
    }


    /**
     * Lane Code 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function lane_cd_OnChange(comObj,index,text)
    {
       document.form.lane_cd.value = comObj.Code;
       document.form.command_h.value = "S";
    }

    /**
     * Terminal Rate Input Tab Container Type 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function cntr_type_t_OnChange(comObj,index,text)
    {
       document.form.cntr_type_t.value = comObj.Code;
       document.form.command_h.value = "S";
    }
    
    /**
     * Storage Rate Input Tab Container Type 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function cntr_type_s_OnChange(comObj,index,text)
    {
       document.form.cntr_type_s.value = comObj.Code;
       document.form.command_h.value = "S";
    }

    /**
     * Terminal Rate Input Tab Container Size 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function cntr_size_t_OnChange(comObj,index,text)
    {
       document.form.cntr_size_t.value	= comObj.Code;
       document.form.command_h.value	= "S";
    }

    /**
     * Storage Rate Input Tab Container Size 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function cntr_size_s_OnChange(comObj,index,text)
    {
       document.form.cntr_size_s.value	= comObj.Code;
       document.form.command_h.value	= "S";
    }

    /**
     * Detail Lgs Cost Code 변경시 프로세스 처리.<br>
     * 
     * @param {comObj}  	comObj		ComboBox Object
     * @param {index}  		index		index
     * @param {text}  		text		text
     */
    function cost_code_dc_OnChange(comObj,index,text)
    {
       document.form.lgs_cost_dtl_cd.value	= comObj.Code;
       document.form.command_h.value	= "S";
    }

    
    /**
     * Lane 변경시 설정.<br>
     * 
     */
	function lane_Change()
	{
		document.form.command_h.value	= "S";
		doActionIBSheet2(sheetObjects[1], document.form, SEARCH04);
		
		comboObjects[0].Code2		= sheetObjects[5].CellValue(1, "lgs_cost_cd");	// 13
		//comboObjects[1].Code2		= sheetObjects[5].CellValue(1, 16);
      //}
	}



    /**
     * Agreement Header Info Validate.<br>
     * 
     * @param {formObject}  	formObject		Form Object
     */
	function hdr_validate(formObject){
		if (ComIsNull(formObject.yd_cd.value)){
			ComShowCodeMessage('TES10009');
			return false;
		}

		if (!ComChkLen(formObject.yd_cd, 7)){
			ComShowCodeMessage('TES10107');
			return false;
		}

		if (ComIsNull(formObject.vndr_seq.value)){
			ComShowCodeMessage('TES10011');
			return false;
		}

		if (!ComIsNumber(formObject.vndr_seq)){
			ComShowCodeMessage('TES10108');
			return false;
		}

		if (ComIsNull(formObject.ctrt_ofc_cd.value)){
			ComShowCodeMessage('TES10023');
			return false;
		}

		if (ComIsNull(formObject.eff_fm_dt.value)){
			ComShowCodeMessage('TES10012');
			return false;
		}

		if (!ComIsNull(formObject.eff_fm_dt.value)){
			
			if (!ComIsDate(formObject.eff_fm_dt)){
				ComShowCodeMessage('TES10013');
				return false;
			}
		}

		if (ComIsNull(formObject.eff_to_dt.value)){
			ComShowCodeMessage('TES10012');
			return false;
		}

		if (!ComIsNull(formObject.eff_to_dt.value)){
			
			if (!ComIsDate(formObject.eff_to_dt)){
				ComShowCodeMessage('TES10013');
				return false;
			}
		}

		if (ComIsNull(getElementValue(formObject, 'radio', 'auto_xtd_flg'))){
			ComShowCodeMessage('TES10014');
			return false;
		}

		return true;
	}


    /**
     * t1sheet1 (No of Volume Tier) Sheet에 있는 조회 결과를 화면에 보여준다.
     * 
     * @param {ibsheet} 	sheetObj	Sheet Object
     * @param {String}  	errMsg		Error Message
     */
	function t1sheet1_OnSearchEnd(sheetObj,errMsg){
	
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
		var verifystr	= sheetObj.EtcData("verifyText");
		var thrpFlg		= sheetObj.EtcData("thrpFlg");
		//ComShowMessage(verifystr);
		document.form.thrpFlg.value	= thrpFlg;

		var vfsArray	= verifystr.split("|");

		if(tabObjects[0].selectedIndex == 0){
			comboObjects[0].Code2	= costCodeT;
			comboObjects[5].Code2	= "";
		}
		else if(tabObjects[0].selectedIndex == 2){
			comboObjects[5].Code2	= costCodeS;
			comboObjects[0].Code2	= "";
		}

		initVerify(vfsArray);

//		if(sheetObjects[5].CellValue(1, 13)!=comboObjects[0].Code || sheetObjects[5].CellValue(1, 13)!=comboObjects[5].Code){
		if( sheetObjects[5].CellValue(1, "lgs_cost_cd") != comboObjects[0].Code ||
			sheetObjects[5].CellValue(1, "lgs_cost_cd") != comboObjects[5].Code){
		
			if(tabObjects[0].selectedIndex == 0) {
				comboObjects[1].Code	= currCodeDef;
			}
			else if(tabObjects[0].selectedIndex == 2) {
				comboObjects[6].Code	= currCodeDef;
			}
		}

		if(sheetObjects[5].CellValue(1, "cmnc_hrmnt") == ""){	// 19
			document.form.cmnc_hrmnt.value	=  "24:00";
		}

		//agreementVaildate(vfsArray);
		verifyObjects	= vfsArray;
		document.form.vfsArray.value	= vfsArray;
	}

    /**
     * Verify 정보 초기화.<br>
     * 
     * @param {Array} 	vfsArray	vfsArray
     */
	function initVerify(vfsArray){
		var tab_count	= 0;
		var terminal_tab_count	= 0;
		var storage_tab_count	= 0;

		initFormValue();
		initFormDisabled();

		for(var i = 1; i < 10; i++){
			
			if(vfsArray[i] == "Y"){
				tab_count++;
				terminal_tab_count++;
			}
		}

		for(var i = 10; i < 19; i++){
		
			if(vfsArray[i] == "Y"){
				storage_tab_count++;
			}
		}

		if(storage_tab_count > 0){
		
			if(tabObjects[0].selectedIndex == 0){
				ComShowCodeMessage('TES10052');
				comboObjects[0].Code2="";
				return false;
			}

			document.form.tml_agmt_vol_ut_cd[2].disabled = false;
			//document.form.tml_agmt_vol_ut_cd[2].value = sheetObjects[5].CellValue(1, 15);
			
			if(comboObjects[5].Code == sheetObjects[5].CellValue(1, "lgs_cost_cd")){	// 13
				document.form.tml_agmt_vol_ut_cd[2].value = sheetObjects[5].CellValue(1, "tml_agmt_vol_ut_cd");	// 15
				
			} else {
				document.form.tml_agmt_vol_ut_cd[2].value = "";
			}

			comboObjects[6].Enable  = true;
			
			if(sheetObjects[5].CellValue(1, "tml_agmt_vol_ut_cd") == "C" ) {	// 15
				document.form.cntr_ts[2].disabled = false;
				document.form.cntr_ts[3].disabled = false;
			}

		} else if(terminal_tab_count > 0) {
		
			if(tabObjects[0].selectedIndex == 2) {
				ComShowCodeMessage('TES10053');
				comboObjects[5].Code2	= "";
				return false;
			}

			document.form.tml_agmt_vol_ut_cd[1].disabled = false;
			
			if(comboObjects[0].Code == sheetObjects[5].CellValue(1, "lgs_cost_cd")){	// 13
				document.form.tml_agmt_vol_ut_cd[1].value = sheetObjects[5].CellValue(1, 15);
				
			} else {
				document.form.tml_agmt_vol_ut_cd[1].value = "";
			}

			comboObjects[1].Enable  = true;
			
			if(sheetObjects[5].CellValue(1, "tml_agmt_vol_ut_cd") == "C"){	// 15
				document.form.cntr_ts[0].disabled = false;
				document.form.cntr_ts[1].disabled = false;
			}
		}else{
			comboObjects[0].Code2	= "";
			comboObjects[5].Code2	= "";
			//ComShowMessage("Agreement Cost Code로 사용 할 수 없는 Cost code입니다.");
		}

		if(tabObjects[0].selectedIndex == 0) {
			document.form.tml_agmt_vol_ut_cd[1].value = "C";
			selectVolUOM();
		} else if(tabObjects[0].selectedIndex == 2) {
			document.form.tml_agmt_vol_ut_cd[2].value = "C";
			selectVolUOM();
		}

		// com_auto_calc_flg
		if(vfsArray[0] == "Y"){
			document.form.auto_calc_flg[0].checked	= false;
			document.form.auto_calc_flg[1].checked	= false;
			//document.form.auto_calc_flg[0].disabled=false;
			//document.form.auto_calc_flg[1].disabled=false;
			
			for(var i = 0; i < getElementCnt(document.form, 'radio', 'auto_calc_flg') ;i++){
				
				if(sheetObjects[5].CellValue(1, "auto_calc_flg") == "Y"){	// 14
					document.form.auto_calc_flg[i].checked		= true;
					document.form.auto_calc_flg[i+1].checked	= false;
					break;
				}
				else if(sheetObjects[5].CellValue(1, "auto_calc_flg") == "N"){	// 14
					document.form.auto_calc_flg[i].checked		= false;
					document.form.auto_calc_flg[i+1].checked	= true;
					break;
				}
			}
			document.form.auto_calc_flg[0].checked	= true;
			document.form.auto_calc_flg[1].checked	= false;
			document.form.auto_calc_flg.value		= vfsArray[0];
			
		} else if(vfsArray[0] == "N") {
			document.form.auto_calc_flg[0].checked	= false;
			document.form.auto_calc_flg[1].checked	= true;
			document.form.auto_calc_flg.value		= vfsArray[0];
		}

		// tml_thrp_cost_cd_flg
		if(vfsArray[1] == "Y"){
			//document.form.io_bnd_cd[1].disabled=false;
		}

		// tml_io_bnd_flg
		if(vfsArray[2] == "Y"){
			document.form.io_bnd_cd[1].disabled	= false;
			document.form.io_bnd_cd[1].value	= "S";
		}

		// tml_ioc_flg
		if(vfsArray[3] == "Y"){
			document.form.ioc_cd.disabled = false;
			document.form.ioc_cd.value = "S";
		}

		// tml_aply_dt_flg
		if(vfsArray[4] == "Y"){
			document.form.tml_dy_aply_tp_cd[0].disabled	= false;
			document.form.tml_dy_aply_tp_cd[1].disabled	= false;
			
			document.form.wkdy_flg.disabled				= false;
			document.form.sat_flg.disabled				= false;
			document.form.sun_flg.disabled				= false;
			document.form.hol_flg.disabled				= false;	

			document.form.tml_dy_aply_tp_cd[0].checked	= true;
			selectAplySame();
		}

		// tml_lane_flg
		if(vfsArray[5] == "Y"){
			//document.form.lane_cd.disable = false;
			comboObjects[2].Enable	= true;
			comboObjects[2].Code	= "Sam";
		}

		// tml_dcgo_aply_flg
		if(vfsArray[6] == "Y"){
			document.form.dcgo_aply_tp_cd[0].disabled	= false;
			document.form.dcgo_aply_tp_cd[1].disabled	= false;
			//[CHM-201539189]DG(NONE) 숨김처리
			//document.form.dcgo_aply_tp_cd[2].disabled	= false; 
			
			
			document.form.dcgo_n1st_clss_flg.disabled	= false;
			document.form.dcgo_n2nd_clss_flg.disabled	= false;
			document.form.dcgo_n3rd_clss_flg.disabled	= false;
			document.form.dcgo_n4th_clss_flg.disabled	= false;
			document.form.dcgo_n5th_clss_flg.disabled	= false;
			document.form.dcgo_n6th_clss_flg.disabled	= false;
			document.form.dcgo_n7th_clss_flg.disabled	= false;
			document.form.dcgo_n8th_clss_flg.disabled	= false;
			document.form.dcgo_n9th_clss_flg.disabled	= false;
			document.form.dcgo_none_clss_flg.disabled	= false;

			//document.form.dcgo_aply_tp_cd[0].checked	= true;
			selectDGNone('');
		}

		// tml_tr_vol_flg
		if(vfsArray[7] == "Y"){
			document.form.cnt1.disabled = false;
			document.form.cnt1.value = 1;
			var iRow = sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue2(iRow, 0)	= "1";
    		sheetObjects[0].CellValue2(iRow, 2)	= "1";
    		sheetObjects[0].CellValue2(iRow, 3)	= "MAX";
		}

		// tml_ovt_shft_flg
		if(vfsArray[8] == "Y"){
			document.form.cnt2.disabled = false;
			document.form.cnt2.value = 1;
		}

		// tml_thc_flg
		if(vfsArray[9] == "Y"){
			document.form.thc_tp_cd[0].disabled		= false;
			document.form.thc_tp_cd_flg.disabled	= false;
			document.form.thc_tp_cd[1].disabled		= false;
			document.form.thc_tp_cd[2].disabled		= false;

			document.form.thc_tp_cd[0].checked		= true;
		}

		// sto_com_agmt_tp_flg
		if(vfsArray[10] == "Y"){
			document.form.tml_sto_agmt_tp_cd.disabled	= false;
			document.form.ft_dys.disabled				= false;
			document.form.agmt_ut_rt.disabled			= false;
			
			document.form.tml_sto_agmt_tp_cd.value		= "FD";
		}

		// sto_com_cmnc_tm_flg
		if(vfsArray[11] == "Y"){
			document.form.cmnc_hrmnt.disabled		= false;
			document.form.ft_dys.disabled			= false;
			document.form.agmt_ut_rt.disabled		= false;
		}

		// sto_free_dy_io_bnd_flg
		if(vfsArray[12] == "Y"){
			document.form.io_bnd_cd[2].disabled		= false;
			document.form.io_bnd_cd[3].disabled		= false;
			document.form.ft_dys.disabled			= false;
			document.form.agmt_ut_rt.disabled		= false;
		}

		// sto_free_dy_flg
		if(vfsArray[13] == "Y"){
			//document.form.storage_gb[0].checked = true;
			//document.form.storage_gb[1].checked = false;
			document.form.storage_gb[0].disabled	= false;
			document.form.storage_gb[1].disabled	= false;
			document.form.ft_dys.disabled			= false;
			document.form.agmt_ut_rt.disabled		= false;
		}

		// sto_free_dy_dcgo_tm_flg
		if(vfsArray[14] == "Y"){
			document.form.dcgo_aply_tp_cd_FD[0].disabled = false;
			document.form.dcgo_aply_tp_cd_FD[1].disabled = false;
			//document.form.dcgo_aply_tp_cd_FD[2].disabled = false;

			document.form.dcgo_n1st_clss_flg_FD.disabled = false;
			document.form.dcgo_n2nd_clss_flg_FD.disabled = false;
			document.form.dcgo_n3rd_clss_flg_FD.disabled = false;
			document.form.dcgo_n4th_clss_flg_FD.disabled = false;
			document.form.dcgo_n5th_clss_flg_FD.disabled = false;
			document.form.dcgo_n6th_clss_flg_FD.disabled = false;
			document.form.dcgo_n7th_clss_flg_FD.disabled = false;
			document.form.dcgo_n8th_clss_flg_FD.disabled = false;
			document.form.dcgo_n9th_clss_flg_FD.disabled = false;
			document.form.dcgo_none_clss_flg_FD.disabled = false;
			
			selectDGNone('_FD');
		}

		// sto_free_dy_xcld_dt_flg
		if(vfsArray[15] == "Y"){
			document.form.sat_flg_FD.disable	= false;
			document.form.sun_flg_FD.disable	= false;
			document.form.hol_flg_FD.disable	= false;
		}

		// sto_free_dy_dcgo_rt_flg
		if(vfsArray[16] == "Y"){
			document.form.dcgo_aply_tp_cd_R[0].disabled = false;
			document.form.dcgo_aply_tp_cd_R[1].disabled = false;
			//document.form.dcgo_aply_tp_cd_R[2].disabled = false;

			document.form.dcgo_n1st_clss_flg_R.disabled = false;
			document.form.dcgo_n2nd_clss_flg_R.disabled = false;
			document.form.dcgo_n3rd_clss_flg_R.disabled = false;
			document.form.dcgo_n4th_clss_flg_R.disabled = false;
			document.form.dcgo_n5th_clss_flg_R.disabled = false;
			document.form.dcgo_n6th_clss_flg_R.disabled = false;
			document.form.dcgo_n7th_clss_flg_R.disabled = false;
			document.form.dcgo_n8th_clss_flg_R.disabled = false;
			document.form.dcgo_n9th_clss_flg_R.disabled = false;
			document.form.dcgo_none_clss_flg_R.disabled = false;
			
			selectDGNone('_R');
		}

		// sto_free_dy_tr_dy_flg
		if(vfsArray[17] == "Y"){
			document.form.cnt3.disable = false;
			document.form.cnt3.value = 1;
			var iRow = sheetObjects[3].DataInsert(-1);
			sheetObjects[3].CellValue2(iRow, 0)	= "1";
			sheetObjects[3].CellValue2(iRow, 2)	= "1";
			sheetObjects[3].CellValue2(iRow, 3)	= "MAX";
		}

		// sto_fp_calc_prd_flg
		if(vfsArray[18] == "Y"){
			document.form.fp_calc_prd_cd[0].disabled	= false;
			document.form.fp_calc_prd_cd[1].disabled	= false;
			document.form.agmt_ut_rt_fp.disabled		= false;
		}

		// sto_fp_teu_flg
		if(vfsArray[19] == "Y"){
			document.form.fp_teu_qty.disabled		= false;
			document.form.agmt_ut_rt_fp.disabled	= false;
		}

	}

    /**
     * Form Object Value 초기화.<br>
     * 
     */
	function initFormValue(){
		document.form.auto_calc_flg[1].checked		= false;
		document.form.tml_agmt_vol_ut_cd[0].value	= "";
		document.form.tml_agmt_vol_ut_cd[1].value	= "";
		document.form.tml_agmt_vol_ut_cd[2].value	= "";
		//comboObjects[0].Code2	= "-1";
		comboObjects[1].Code2	= "-1";

		document.form.io_bnd_cd[1].value			= "";
		document.form.ioc_cd.value					= "";
		document.form.tml_trns_mod_cd[0].value		= "";
		document.form.tml_trns_mod_cd[1].value		= "";
		
		document.form.tml_dy_aply_tp_cd[0].checked	= false;
		document.form.tml_dy_aply_tp_cd[1].checked	= false;
		
		document.form.wkdy_flg.checked				= false;
		document.form.sat_flg.checked				= false;
		document.form.sun_flg.checked				= false;
		document.form.hol_flg.checked				= false;
		
		comboObjects[2].Code2						= "-1";
		document.form.lane_cd.value					= "";
		
		document.form.dcgo_aply_tp_cd[0].checked	= false;
		document.form.dcgo_aply_tp_cd[1].checked	= false;
		//document.form.dcgo_aply_tp_cd[2].checked	= false;
		
		document.form.dcgo_same[0].checked			= false;
		document.form.dcgo_same[1].checked			= false;
		document.form.dcgo_n1st_clss_flg.checked	= false;
		document.form.dcgo_n2nd_clss_flg.checked	= false;
		document.form.dcgo_n3rd_clss_flg.checked	= false;
		document.form.dcgo_n4th_clss_flg.checked	= false;
		document.form.dcgo_n5th_clss_flg.checked	= false;
		document.form.dcgo_n6th_clss_flg.checked	= false;
		document.form.dcgo_n7th_clss_flg.checked	= false;
		document.form.dcgo_n8th_clss_flg.checked	= false;
		document.form.dcgo_n9th_clss_flg.checked	= false;
		document.form.dcgo_none_clss_flg.checked	= false;
		
		document.form.cnt1.disable			= false;
		document.form.cnt1.value			= 0;
		document.form.cnt2.disable			= false;
		document.form.cnt2.value			= 0;
		
		document.form.thc_tp_cd[0].checked	= false;
		document.form.thc_tp_cd_flg.checked	= false;
		document.form.thc_tp_cd[1].checked	= false;
		document.form.thc_tp_cd[2].checked	= false;
		
		document.form.cntr_ts[0].checked	= false;
		document.form.cntr_ts[1].checked	= false;
		document.form.agmt_rate.value		= "";
		comboObjects[3].Code2				= "-1";
		comboObjects[4].Code2				= "-1";
		document.form.agmt_rate.value		= "";
		
		document.form.tml_sto_agmt_tp_cd.value	= "";
		document.form.cmnc_hrmnt.value			= "";
		document.form.tml_agmt_vol_ut_cd[2].value	= "";
		//comboObjects[5].Code2="-1";
		comboObjects[6].Code2		= "-1";
		
		document.form.storage_gb[0].checked	= false;
		document.form.storage_gb[1].checked	= false;
		
		document.form.io_bnd_cd[2].value	= "";
		document.form.dcgo_aply_tp_cd_FD[0].checked	= false;
		document.form.dcgo_aply_tp_cd_FD[1].checked	= false;
		//document.form.dcgo_aply_tp_cd_FD[2].checked	= false;
		
		document.form.dcgo_same_FD[0].checked		= false;
		document.form.dcgo_same_FD[1].checked		= false;
		document.form.dcgo_n1st_clss_flg_FD.checked = false;
		document.form.dcgo_n2nd_clss_flg_FD.checked = false;
		document.form.dcgo_n3rd_clss_flg_FD.checked = false;
		document.form.dcgo_n4th_clss_flg_FD.checked = false;
		document.form.dcgo_n5th_clss_flg_FD.checked = false;
		document.form.dcgo_n6th_clss_flg_FD.checked = false;
		document.form.dcgo_n7th_clss_flg_FD.checked = false;
		document.form.dcgo_n8th_clss_flg_FD.checked = false;
		document.form.dcgo_n9th_clss_flg_FD.checked = false;
		document.form.dcgo_none_clss_flg_FD.checked = false;

		document.form.sat_flg_FD.checked	= false;
		document.form.sun_flg_FD.checked	= false;
		document.form.hol_flg_FD.checked	= false;

		document.form.ft_dys.value			= "";

		document.form.io_bnd_cd[3].value	= "";
		document.form.dcgo_aply_tp_cd_R[0].checked	= false;
		document.form.dcgo_aply_tp_cd_R[1].checked	= false;
		//document.form.dcgo_aply_tp_cd_R[2].checked	= false;
		
		document.form.dcgo_same_R[0].checked		= false;
		document.form.dcgo_same_R[1].checked		= false;
		document.form.dcgo_n1st_clss_flg_R.checked	= false;
		document.form.dcgo_n2nd_clss_flg_R.checked	= false;
		document.form.dcgo_n3rd_clss_flg_R.checked	= false;
		document.form.dcgo_n4th_clss_flg_R.checked	= false;
		document.form.dcgo_n5th_clss_flg_R.checked	= false;
		document.form.dcgo_n6th_clss_flg_R.checked	= false;
		document.form.dcgo_n7th_clss_flg_R.checked	= false;
		document.form.dcgo_n8th_clss_flg_R.checked	= false;
		document.form.dcgo_n9th_clss_flg_R.checked	= false;
		document.form.dcgo_none_clss_flg_R.checked	= false;
		
		document.form.cnt3.value	= 0;
		document.form.cnt3.disable	= false;
		
		document.form.agmt_ut_rt.value	= "";
		
		document.form.cntr_ts[2].checked	= false;
		document.form.cntr_ts[3].checked	= false;
		comboObjects[7].Code2	= "-1";
		comboObjects[8].Code2	= "-1";
		
		document.form.fp_calc_prd_cd[0].checked	= false;
		document.form.fp_calc_prd_cd[1].checked	= false;

		document.form.fp_teu_qty.value		= "";
		document.form.agmt_ut_rt_fp.value	= "";

	}

    /**
     * Form Object Disable 초기화.<br>
     * 
     */
	function initFormDisabled(){

		document.form.tml_agmt_vol_ut_cd[1].value	= "";
		document.form.tml_agmt_vol_ut_cd[2].value	= "";
		document.form.tml_agmt_vol_ut_cd[1].disabled= true;
		comboObjects[1].Enable						= false;

		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[3].RemoveAll();
		document.form.auto_calc_flg[0].disabled		= true;
		document.form.auto_calc_flg[1].disabled		= true;

		document.form.io_bnd_cd[1].disabled			= true;
		document.form.ioc_cd.disabled				= true;
		document.form.tml_dy_aply_tp_cd[0].disabled	= true;
		document.form.tml_dy_aply_tp_cd[1].disabled	= true;
		
		document.form.wkdy_flg.disabled	= true;
		document.form.sat_flg.disabled	= true;
		document.form.sun_flg.disabled	= true;
		document.form.hol_flg.disabled	= true;
		comboObjects[2].Enable			= false;

		document.form.dcgo_aply_tp_cd[0].disabled = true;
		document.form.dcgo_aply_tp_cd[1].disabled = true;
		//document.form.dcgo_aply_tp_cd[2].disabled = true;
		document.form.dcgo_same[0].disabled = true;
		document.form.dcgo_same[1].disabled = true;
		document.form.dcgo_n1st_clss_flg.disabled = true;
		document.form.dcgo_n2nd_clss_flg.disabled = true;
		document.form.dcgo_n3rd_clss_flg.disabled = true;
		document.form.dcgo_n4th_clss_flg.disabled = true;
		document.form.dcgo_n5th_clss_flg.disabled = true;
		document.form.dcgo_n6th_clss_flg.disabled = true;
		document.form.dcgo_n7th_clss_flg.disabled = true;
		document.form.dcgo_n8th_clss_flg.disabled = true;
		document.form.dcgo_n9th_clss_flg.disabled = true;
		document.form.dcgo_none_clss_flg.disabled = true;
		
		document.form.cnt1.value	= 0;
		document.form.cnt1.disabled	= true;
		document.form.cnt2.value	= 0;
		document.form.cnt2.disabled = true;
		
		document.form.thc_tp_cd[0].disabled		= true;
		document.form.thc_tp_cd_flg.disabled	= true;
		document.form.thc_tp_cd[1].disabled		= true;
		document.form.thc_tp_cd[2].disabled		= true;		

		document.form.cntr_ts[0].disabled	= true;
		document.form.cntr_ts[1].disabled	= true;
		comboObjects[3].Enable				= false;
		comboObjects[4].Enable				= false;
		document.form.agmt_rate.disabled	= true;

		document.form.tml_sto_agmt_tp_cd.disabled		= true;
		document.form.tml_agmt_vol_ut_cd[2].disabled	= true;
		document.form.cmnc_hrmnt.disabled				= true;
		comboObjects[6].Enable							= false;
		document.form.storage_gb[0].disabled			= true;
		document.form.storage_gb[1].disabled			= true;

		document.form.io_bnd_cd[2].disabled		= true;
		document.form.dcgo_aply_tp_cd_FD[0].disabled = true;
		document.form.dcgo_aply_tp_cd_FD[1].disabled = true;
		//document.form.dcgo_aply_tp_cd_FD[2].disabled = true;
		
		document.form.dcgo_same_FD[0].disabled	= true;
		document.form.dcgo_same_FD[1].disabled	= true;
		document.form.dcgo_n1st_clss_flg_FD.disabled = true;
		document.form.dcgo_n2nd_clss_flg_FD.disabled = true;
		document.form.dcgo_n3rd_clss_flg_FD.disabled = true;
		document.form.dcgo_n4th_clss_flg_FD.disabled = true;
		document.form.dcgo_n5th_clss_flg_FD.disabled = true;
		document.form.dcgo_n6th_clss_flg_FD.disabled = true;
		document.form.dcgo_n7th_clss_flg_FD.disabled = true;
		document.form.dcgo_n8th_clss_flg_FD.disabled = true;
		document.form.dcgo_n9th_clss_flg_FD.disabled = true;
		document.form.dcgo_none_clss_flg_FD.disabled = true;

		document.form.sat_flg_FD.disabled = true;
		document.form.sun_flg_FD.disabled = true;
		document.form.hol_flg_FD.disabled = true;
		document.form.ft_dys.disabled	= true;		

		document.form.io_bnd_cd[3].disabled=true;
		document.form.dcgo_aply_tp_cd_R[0].disabled = true;
		document.form.dcgo_aply_tp_cd_R[1].disabled = true;
		//document.form.dcgo_aply_tp_cd_R[2].disabled = true;
		document.form.dcgo_same_R[0].disabled = true;
		document.form.dcgo_same_R[1].disabled = true;
		document.form.dcgo_n1st_clss_flg_R.disabled = true;
		document.form.dcgo_n2nd_clss_flg_R.disabled = true;
		document.form.dcgo_n3rd_clss_flg_R.disabled = true;
		document.form.dcgo_n4th_clss_flg_R.disabled = true;
		document.form.dcgo_n5th_clss_flg_R.disabled = true;
		document.form.dcgo_n6th_clss_flg_R.disabled = true;
		document.form.dcgo_n7th_clss_flg_R.disabled = true;
		document.form.dcgo_n8th_clss_flg_R.disabled = true;
		document.form.dcgo_n9th_clss_flg_R.disabled = true;
		document.form.dcgo_none_clss_flg_R.disabled = true;

		document.form.cnt3.value	= 0;
		document.form.cnt3.disabled	= true;
		document.form.agmt_ut_rt.disabled	= true;	

		document.form.cntr_ts[2].disabled	= true;
		document.form.cntr_ts[3].disabled	= true;
		comboObjects[7].Enable	= false;
		comboObjects[8].Enable	= false;	

		document.form.fp_calc_prd_cd[0].disabled	= true;
		document.form.fp_calc_prd_cd[1].disabled	= true;
		document.form.fp_teu_qty.disabled			= true;
		document.form.agmt_ut_rt_fp.disabled		= true;
	}

    /**
     * Agreement Validate.<br>
     * @param{vfsArray}		vfsArray	vfsArray
     */
	function agreementVaildate(vfsArray){

		if(vfsArray[0] == "Y"){
			
			if(document.form.auto_calc_flg[0].checked == false && document.form.auto_calc_flg[1].checked == false)
			{
				ComShowCodeMessage('TES10055');
				return false;
			}
		}

		if(vfsArray[1] == "Y"){
			//document.form.io_bnd_cd[1].disabled=false;
		}

		if(vfsArray[2] == "Y"){
			
			if(ComIsNull(document.form.io_bnd_cd[1].value)){
				ComShowCodeMessage('TES10056');
				return false;
			}
		}

		if(vfsArray[3] == "Y"){
			
			if(ComIsNull(document.form.ioc_cd.value)){
				ComShowCodeMessage('TES10057');
				return false;
			}
		}

		if(vfsArray[4] == "Y"){
			
			if (ComIsNull(getElementValue(document.form, 'radio', 'tml_dy_aply_tp_cd'))){
				ComShowCodeMessage('TES10058');
				return false;
			}
		}
			/**
			if(vfsArray[5] == "Y"){
				if(ComIsNull(document.form.lane_cd.value)){
					ComShowCodeMessage('TES10059');
					return false;
				}
			}
			**/
		
		if(vfsArray[6] == "Y"){
			
//			if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd'))){
//				ComShowCodeMessage('TES10043');
//				return false;
//			}	

			if (getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd') == "A"){
				
				if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_same'))){
					ComShowCodeMessage('TES10044');
				  	return false;
				}
			}
			
			if (getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd') == "S"){
			
				if (document.form.dcgo_n1st_clss_flg.checked==false && document.form.dcgo_n2nd_clss_flg.checked==false && document.form.dcgo_n3rd_clss_flg.checked == false && document.form.dcgo_n4th_clss_flg.checked == false && document.form.dcgo_n5th_clss_flg.checked == false && document.form.dcgo_n6th_clss_flg.checked == false && document.form.dcgo_n7th_clss_flg.checked == false && document.form.dcgo_n8th_clss_flg.checked == false && document.form.dcgo_n9th_clss_flg.checked == false && document.form.dcgo_none_clss_flg.checked == false ){
					ComShowCodeMessage('TES10045');
					return false;
				}
			}
		}

		if(vfsArray[7] == "Y"){
		
			if(sheetObjects[0].CheckedRows(0) == "0"){
				ComShowCodeMessage('TES10047');
				return false;
			}else{
				
				if(sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow(0).substr(0,1),2)==""||sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow(0).substr(0,1),3)==""){
					ComShowCodeMessage('TES10062');
					return false;
				}
			}
		}

		if(vfsArray[8] == "Y"){
		
			if(sheetObjects[1].CheckedRows(0) == "0"){
				ComShowCodeMessage('TES10063');
				return false;
			
			}else{
				
				if(sheetObjects[1].CellValue(sheetObjects[1].FindCheckedRow(0).substr(0,1),2)==""){
					ComShowCodeMessage('TES10064');
					return false;
				}
			}
		}

		if(vfsArray[9] == "Y"){
			
			if (ComIsNull(getElementValue(document.form, 'radio', 'thc_tp_cd'))){
				ComShowCodeMessage('TES10065');
				return false;
			}
		}

		if(vfsArray[10] == "Y"){
		
			if(ComIsNull(document.form.tml_sto_agmt_tp_cd.value)){
				ComShowCodeMessage('TES10037');
				return false;
			}
		}

		if(vfsArray[11] == "Y"){
		
			if(ComIsNull(document.form.cmnc_hrmnt.value)){
				ComShowCodeMessage('TES10037');
				return false;
			}
		}

		if(vfsArray[12] == "Y"){
		
			if(document.form.storage_gb[0].checked == true){
			
				if(ComIsNull(document.form.io_bnd_cd[2].value)){
					ComShowCodeMessage('TES10056');
					return false;
				}
			}else if(document.form.storage_gb[1].checked == true){
		
				if(ComIsNull(document.form.io_bnd_cd[3].value)){
					ComShowCodeMessage('TES10056');
					return false;
				}
			}
		}

		if(vfsArray[13] == "Y"){
		
			if(document.form.storage_gb[0].checked == false && document.form.storage_gb[1].checked == false){
				ComShowCodeMessage('TES10042');
				return false;
			}
		}

		if(vfsArray[14] == "Y"){

//			if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd_FD'))){
//				ComShowCodeMessage('TES10043');
//				return false;
//			}

			if (getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd_FD') == "A"){
			
				if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_same_FD'))){
					ComShowCodeMessage('TES10044');
				  	return false;
				 }
			}

			if (getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd_FD') == "S"){
				
				if (document.form.dcgo_n1st_clss_flg_FD.checked == false && document.form.dcgo_n2nd_clss_flg_FD.checked == false && document.form.dcgo_n3rd_clss_flg_FD.checked == false && document.form.dcgo_n4th_clss_flg_FD.checked == false && document.form.dcgo_n5th_clss_flg_FD.checked == false && document.form.dcgo_n6th_clss_flg_FD.checked == false && document.form.dcgo_n7th_clss_flg_FD.checked == false && document.form.dcgo_n8th_clss_flg_FD.checked == false && document.form.dcgo_n9th_clss_flg_FD.checked == false && document.form.dcgo_none_clss_flg_FD.checked == false ){
					ComShowCodeMessage('TES10045');
					return false;
				}
			}
		}

			/**
			if(vfsArray[15] == "Y"){
				if (document.form.sat_flg_FD.checked == false && document.form.sun_flg_FD.checked == false && document.form.hol_flg_FD.checked == false){
					ComShowMessage("Exclude Date 선택하세요.");
					return false;
				}
			}
			**/

		if(vfsArray[16] == "Y"){
		
//			if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_aply_tp_cd_R'))){
//				ComShowCodeMessage('TES10043');
//				return false;
//			}

			if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "A"){
		
				if (ComIsNull(getElementValue(document.form, 'radio', 'dcgo_same_R'))){
					ComShowCodeMessage('TES10044');
				  	return false;
				}
			}

			if (getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R') == "S"){
			
				if (document.form.dcgo_n1st_clss_flg_R.checked == false && document.form.dcgo_n2nd_clss_flg_R.checked == false && document.form.dcgo_n3rd_clss_flg_R.checked == false && document.form.dcgo_n4th_clss_flg_R.checked == false && document.form.dcgo_n5th_clss_flg_R.checked == false && document.form.dcgo_n6th_clss_flg_R.checked == false && document.form.dcgo_n7th_clss_flg_R.checked == false && document.form.dcgo_n8th_clss_flg_R.checked == false && document.form.dcgo_n9th_clss_flg_R.checked == false && document.form.dcgo_none_clss_flg_R.checked == false ){
					ComShowCodeMessage('TES10045');
					return false;
				}
			}
		}
		/**
			if(vfsArray[17] == "Y"){
				if(sheetObjects[4].CheckedRows(0) == "0"){
					ComShowMessage("No of Tier Days 확인하세요.");
					return false;
				}else{
					if(sheetObjects[4].CellValue(sheetObjects[0].FindCheckedRow(0).substr(0,1),2)==""||sheetObjects[4].CellValue(sheetObjects[0].FindCheckedRow(0).substr(0,1),3)==""){
						ComShowMessage("No of Volume Days 값을 입력하세요.");
						return false;
					}
				}
			}
			**/
		
		if(vfsArray[18] == "Y"){
		
			if (document.form.fp_calc_prd_cd[0].checked == false || document.form.fp_calc_prd_cd[1].checked == false ){
				ComShowCodeMessage('TES10048');
				return false;
			}
		}

		if(vfsArray[19] == "Y"){
	
			if(ComIsNull(document.form.fp_teu_qty.value)){
				ComShowCodeMessage('TES10049');
				return false;
			}
		}

		return true;
	}


	/**
     * 시간 타입 Valid. <br>
     * @param {obj}    obj		Objcet
     **/
	function isValidHHMM ( obj ) {
        str = obj.value.replace(":","");
        //ComShowMessage(str);
        if (!isNumHHMM(obj)) {
            return false;
        }
        if (str.length != 4) {
            return false;
        }

        var hour  	= str.substring(0,2);
        var minute 	= str.substring(2,4);

        if ( parseInt( hour ) <= 23  && parseInt( minute ) <= 59 )
            return true;
        else if(parseInt( hour ) == 24  && parseInt( minute ) == 00){
            return true;
        }
        else {
        	obj.value="";
            return false;
        }
    }

	/**
     * 시간 타입 숫자만.. <br>
     * @param {obj}		obj		Object
     **/
    function isNumHHMM(obj) {
        var chars = ":0123456789";
        return ComIsContainsCharsOnly(obj,chars);
    }

	/**
     * Input Value Check. <br>
     * @param {obj}    Text Value
     **/
	function chkInput(obj) {
	//	ComShowMessage(obj.maxLength + ' / ' + obj.value.length);
	//	ComShowMessage('strleng: '+getStrLen(obj.value));
		if (obj.maxLength < getStrLen(obj.value))
		{
			obj.value = '';//substring(obj.value,0,obj.maxLength);
			obj.focus();
			return false;
		}
	}
		
	/**
     * 숫자만.. <br>
     * @param {obj}    Text Value
     **/
	function isNum(obj){
		//숫자만..
		if (!ComIsNumber(obj)){
			obj.value = '';
		}
	}

	/**
     * 숫자만.. <br>
     * @param {obj}    Text Value
     **/
	function isNum1(obj){
		//숫자만..
		if (!ComIsNumber(obj,'-')){
			obj.value = '';
		}
	}
	
	/**
     * 영문(대문자)과 숫자만.. <br>
     * @param {obj}    Text Value
     **/
	function isApNum(obj){
		if (!ComIsAlphabet(obj,'u')){
			obj.value = '';
		}
	}

	/**
     * 영문과 숫자만.. <br>
     * @param {obj}    Text Value
     **/
	function isApNum1(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,'n')){
			obj.value = '';
		}
		//obj.value = obj.value.toUpperCase();
	}

	/**
     * 영문과 숫자만.. <br>
     * @param {obj}    Text Value
     **/
	function isApNum2(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,'n')){
			obj.value = '';
		}
		obj.value = obj.value.toUpperCase();
	}

	/**
     * 한글 및 영문 str의 길이를 구함.. <br>
     * @param {src}    Text Value
     **/
	function getStrLen(src) {
		// 한글 및 영문 str의 길이를 구함
		src = new String(src);
		var byteLength = 0;
		for (var inx = 0; inx < src.length; inx++) {
			var oneChar = escape(src.charAt(inx));
			if (oneChar.length == 1) {
				byteLength ++;
			} else if (oneChar.indexOf("%u") != -1) {
				byteLength += 2;
			} else if (oneChar.indexOf("%") != -1) {
				byteLength += oneChar.length/3;
			}
		}
		return byteLength;
	}

	/**
     * Agreement Format Check. <br>
     * 0034에서 사용하는곳이 안보임
     * @param {dt}    Text Value
     **/
	function checkAgmtFormat(dt){
		var date_regexp = "^([A-Z]{3}\\d{5})$";
		if (dt.search(date_regexp) != -1){
			return true;
		} else {
			return false;
		}
	}

	/**
     * Commence Time as HH:MM format Check. <br>
     * @param {dt}    Text Value
     **/
	function checkCmncFormat(dt){
		var date_regexp = "^(\\d{2}:\\d{2})$";
		if (dt.search(date_regexp) != -1){
			return true;
		} else {
			return false;
		}
	}

	/**
     * Effective Date As Format Check. <br>
     * @param {dt}    dt	Text Value
     **/
	function checkEffFormat(dt){
		var date_regexp = "^(\\d{4}-\\d{2}-\\d{2})$";
		if (!checkFormat(dt, date_regexp)){
			return false;
		}
		/*
				var date_regexp = /(^\d{4}-\d{2}-\d{2}$)/;
				if (fm_prd_dt.search(date_regexp) != -1) {
					return true; //올바른 포맷 형식
				} else {
					return false;
				}
		*/
		return true;
	}

	/**
     * 주어진 값이 정규식에 일치하는지 확인하고 맞으면 true를 틀릴경우 false를 return한다. <br>
     * @param {object}    Text Value
     * @param {regexp}    정규표현식
     **/
	function checkFormat(object, regexp){
		// 주어진 값이 정규식에 일치하는지 확인하고 맞으면 true를 틀릴경우 false를 return한다.
		if (object == null || object == ""){
			return false;
		} else {
			re = new RegExp(regexp,"gi"); //'gi'는 case-insensitive global match를 위함이다
			if (!re.test(object)){
				return false;
			}
		}
		return true;
	}

	/**
     * Yard Code 유효성 검증. <br>
     **/
	function validateYardCode() {
		var formObj = document.form;
		if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim() == '')
		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			return false;
		}

		if ((formObj.yd_cd_hidden.value==null || formObj.yd_cd_hidden.value.trim()=='') || formObj.yd_cd.value.trim()!=formObj.yd_cd_hidden.value.trim())
		{
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			tes_getInputValue('is_valid_yd_cd', SEARCH05, 'yd_cd', 'checkValidYardCode');
		}
	}

	/**
     * Yard Code  Validate Check. <br>
     **/
	function checkValidYardCode(){
		var formObj = document.form;
		var tmp = '';
		
		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
			tmp = formObj.is_valid_yd_cd.value.split('|');
			
			if (tmp.length > 0){
				formObj.is_valid_yd_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				
				if (formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value == 'Y'){
					formObj.yd_cd_name.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
					formObj.yd_cd_hidden.value = formObj.yd_cd.value;
					
//					if(sheetObjects[5].CellValue(1, 1)!= "" && sheetObjects[5].CellValue(1, 2)!= "" && sheetObjects[5].CellValue(1, 1)!= undefined && sheetObjects[5].CellValue(1, 2)!= undefined){
					if(sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != undefined ){
						lane_Change();
					}
					/**
					formObj.yd_cd_deltflg.value = (tmp[9]!=undefined&&tmp[9]!=null?tmp[9]:'');

					if(formObj.yd_cd_deltflg.value=="Y"){
							ComShowCodeMessage('TES10129');
					}
					**/
					vndr_seq_Focus();
				} else {
					formObj.is_valid_yd_cd.value = '';
					formObj.yd_cd_hidden.value = '';
					//formObj.yd_cd.value = '';
					formObj.yd_cd_name.value = '';
					ComShowCodeMessage('TES10066');
				}
			} else {
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden.value = '';
				//formObj.yd_cd.value = '';
				formObj.yd_cd_name.value = '';
				ComShowCodeMessage('TES10066');
			}
		} else {
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden.value = '';
			//formObj.yd_cd.value = '';
			formObj.yd_cd_name.value = '';
			ComShowCodeMessage('TES10066');
		}
	}


	/**
     * Vendor Code  Validate. <br>
     **/
	function validateVendorCode() {
		var formObj = document.form;
		
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim() == '')
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}
		
		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}
		
		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim())
		{
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVendorCode');
		}
	}

	/**
     * Vendor Code  Validate Check. <br>
     **/
	function checkValidVendorCode(){
		var formObj = document.form;
		var tmp = '';
		
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_name.value = (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					cont_ofc_Focus();
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					//formObj.vndr_seq.value = '';
					formObj.vndr_seq_name.value = '';
					ComShowCodeMessage('TES10067');
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				//formObj.vndr_seq.value = '';
				formObj.vndr_seq_name.value = '';
				ComShowCodeMessage('TES10067');
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			//formObj.vndr_seq.value = '';
			formObj.vndr_seq_name.value = '';
			ComShowCodeMessage('TES10067');
		}
	}

	/**
     * Form Object Value Setting. <br>
     * Agreement Header Info t1sheet3. <br>
     * ALPS 변경으로 Sheet 컬럼인덱스에서 SaveName으로 변경 ( 2009-08-28 )
     **/
    function insertData(){
        var formObject		= document.form;
        var tml_agmt_sts_cd	= "";
        hdrRetrieveFlg		= "Y";
        agmt_no = "";
        //sheetObjects[5].CellValue(1, 1) : agmt_no
        //sheetObjects[5].CellValue(1, 2) : agmt_ver
        //sheetObjects[5].CellValue(1, 3) : yd_cd
        // && sheetObjects[5].CellValue(1, 3) != "" - 쿼리 수정으로 인해 if 구문에서 조건 제외 2009-08-28 
        if ( sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != "" 
        	&& sheetObjects[5].CellValue(1, "tml_agmt_ver_no") != "" ) {

        	//sheetObjects[5].CellValue(1, 21) : creation office
            if( sheetObjects[5].CellValue(1, "cre_ofc_cd") != formObject.cre_ofc_cd.value ) {
            	ComShowCodeMessage('TES50203');		// ComShowMessage('No authority to correct/delete the agreement - Creation office mismatch!');
                agmt_no  		= "";
                agmtRegFlg		= "";
                hdrRetrieveFlg  = "";
                formObject.reset();
                formObject.inquiryFlg.value			= "";
                formObject.tml_agmt_sts_cd.value	= "";
                initFormValue();
                initFormDisabled();
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                sheetObjects[4].RemoveAll();
                sheetObjects[5].RemoveAll();

                formObject.yd_cd.readOnly		= false;
                formObject.vndr_seq.readOnly	= false;
                formObject.ctrt_ofc_cd.readOnly	= false;
                formObject.amend_flg[0].disabled= true;
                formObject.amend_flg[1].disabled= true;
                
                return "NoData";
            }
            formObject.tml_agmt_ofc_cty_cd.value	= sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd");
            formObject.tml_agmt_ver_no.value		= sheetObjects[5].CellValue(1, "tml_agmt_ver_no");
            formObject.yd_cd.value						= sheetObjects[5].CellValue(1, "yd_cd");
            formObject.yd_cd_name.value				= sheetObjects[5].CellValue(1, "yd_nm");
            formObject.vndr_seq.value					= sheetObjects[5].CellValue(1, "vndr_seq");
            formObject.vndr_seq_name.value			= sheetObjects[5].CellValue(1, "vndr_lgl_eng_nm");
            formObject.eff_fm_dt.value					= sheetObjects[5].CellValue(1, "eff_fm_dt");
            formObject.eff_to_dt.value					= sheetObjects[5].CellValue(1, "eff_to_dt");
            formObject.agmt_apro_dt.value			= sheetObjects[5].CellValue(1, "agmt_apro_dt");
            formObject.agmt_cfm_dt.value				= sheetObjects[5].CellValue(1, "agmt_cfm_dt");
            // AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27) 
            formObject.agmt_cfm_flg.value			= sheetObjects[5].CellValue(1, "agmt_cfm_flg");
            formObject.auto_xtd_flg.value				= sheetObjects[5].CellValue(1, "auto_xtd_flg");
            formObject.ctrt_ofc_cd.value				= sheetObjects[5].CellValue(1, "ctrt_ofc_cd");
            formObject.tml_agmt_sts_cd.value			= sheetObjects[5].CellValue(1, "tml_agmt_sts_cd");
            tml_agmt_sts_cd								= sheetObjects[5].CellValue(1, "tml_agmt_sts_cd");
            formObject.agmt_rmk.value				= sheetObjects[5].CellValue(1, "agmt_rmk");
            //comboObjects[0].Code	 				= sheetObjects[5].CellValue(1, 13); //initformDTL()에서 넣어줌 스크립트 실행순서때문에 뒤쪽으로 배치
            //comboObjects[5].Code	 				= sheetObjects[5].CellValue(1, 13); sheetObjects[5].CellValue(1, 13) : cost_cd
            formObject.auto_calc_flg.value				= sheetObjects[5].CellValue(1, "auto_calc_flg");
            formObject.tml_agmt_vol_ut_cd[1].value	= sheetObjects[5].CellValue(1, "tml_agmt_vol_ut_cd");
            //comboObjects[1].Code	 				= sheetObjects[5].CellValue(1, 16); //initformDTL()에서 넣어줌 스크립트 실행순서때문에 뒤쪽으로 배치
            //comboObjects[6].Code	 				= sheetObjects[5].CellValue(1, 16); sheetObjects[5].CellValue(1, 16) : currency
            //formObject.tml_sto_agmt_tp_cd.value	= sheetObjects[5].CellValue(1, 18);
            //formObject.cmnc_hrmnt.value			= sheetObjects[5].CellValue(1, 19);
            // 비용지급 전표 결재 기능 - 3차  (4347-09-25)
            formObject.agmt_doc_no.value			= sheetObjects[5].CellValue(1, "agmt_doc_no");
            formObject.agmt_doc_desc.value			= sheetObjects[5].CellValue(1, "agmt_doc_desc");
//            formObject.agmt_doc_eff_fm_dt.value	= sheetObjects[5].CellValue(1, "agmt_doc_eff_fm_dt");
//            formObject.agmt_doc_eff_to_dt.value		= sheetObjects[5].CellValue(1, "agmt_doc_eff_to_dt");
            document.form.command_h.value		= "S";

            formObject.yd_cd.readOnly		= true;
            formObject.vndr_seq.readOnly	= true;
            formObject.ctrt_ofc_cd.readOnly	= true;
            
            for(var i = 0; i < getElementCnt(formObject, 'radio', 'auto_xtd_flg') ;i++){
                if(sheetObjects[5].CellValue(1, "auto_xtd_flg") == "Y"){
                    formObject.auto_xtd_flg[i].checked		= true;
                    formObject.auto_xtd_flg[i+1].checked	= false;
                    break;
                }else if(sheetObjects[5].CellValue(1, "auto_xtd_flg") =="N"){
                    formObject.auto_xtd_flg[i].checked		= false;
                    formObject.auto_xtd_flg[i+1].checked	= true;
                    break;
                }
            }

            for(var i=0; i<getElementCnt(formObject, 'radio', 'auto_xtd_flg') ;i++){
                if(formObject.tml_agmt_sts_cd.value == "P"){
                    formObject.auto_xtd_flg[i].disabled	= false;
                }
            }

            for(var i=0; i<getElementCnt(formObject, 'radio', 'amend_flg') ;i++){
                if(formObject.tml_agmt_sts_cd.value == "P"){
                    formObject.amend_flg[i].disabled	= true;
                }else if(formObject.tml_agmt_sts_cd.value == "C"){
                    formObject.amend_flg[i].disabled	= false;
                }
            }

            for(var i = 0; i < getElementCnt(formObject, 'radio', 'auto_calc_flg'); i++){
//                if(sheetObjects[5].CellValue(1, 14)=="Y"){
            	if( sheetObjects[5].CellValue(1, "auto_calc_flg") == "Y" ){
                    formObject.auto_calc_flg[i].checked		= true;
                    formObject.auto_calc_flg[i+1].checked	= false;
                    break;
                }else if(sheetObjects[5].CellValue(1, "auto_calc_flg" ) == "N" ){
                    formObject.auto_calc_flg[i].checked		= false;
                    formObject.auto_calc_flg[i+1].checked	= true;
                    break;
                }
            }

            document.form.auto_calc_flg.value	= sheetObjects[5].CellValue(1, "auto_calc_flg");	// 14 
            document.form.initFormDTLFlg.value	= "Y"

            if(tml_agmt_sts_cd == "C"){
                //ComShowMessage("Confirm 된 Agreement No. 입니다.");
                document.form.amend_flg[0].disabled	= false;
                document.form.amend_flg[1].disabled	= false;
                document.form.amend_flg[0].checked	= false;
                document.form.amend_flg[1].checked	= true;
            }else if(tml_agmt_sts_cd == "P"){
                //ComShowMessage("Save 중인 Agreement No. 입니다.");
            }else if(tml_agmt_sts_cd == "" || tml_agmt_sts_cd == null){
                document.form.initFormDTLFlg.value		= "N"
                document.form.tml_agmt_ofc_cty_cd.value	= "";
                document.form.tml_agmt_ver_no.value		= "";
                document.form.yd_cd.value				= "";
                document.form.yd_cd_name.value			= "";
                document.form.vndr_seq.value			= "";
                document.form.vndr_seq_name.value		= "";
                document.form.eff_fm_dt.value			= "";
                document.form.eff_to_dt.value			= "";
                document.form.auto_xtd_flg[0].checked	= false;
                document.form.auto_xtd_flg[1].checked	= false;
                document.form.amend_flg[0].checked		= false;
                document.form.amend_flg[1].checked		= false;
                document.form.agmt_rmk.value			= "";
            }

//        } else if(sheetObjects[5].CellValue(1, 1) == "" && sheetObjects[5].CellValue(1, 2) == ""){ 1: ofc_cd, 2:seq )
        // && sheetObjects[5].CellValue(1, 2) == "" - ALPS변경 쿼리 수정으로 인하여 if (seq) 구문 제외
        } else if(sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") == "" ) {
            //var hdr_gb = confirm("Agreement가 존재하지 않습니다. 신규 등록하시겠습니까?");
            var hdr_gb	= ComShowConfirm(ComGetMsg('TES10116'));
            if(hdr_gb == true){
                agmtRegFlg	= "Y";
                document.form.initFormDTLFlg.value		= "N"
                document.form.tml_agmt_ofc_cty_cd.value	= "";
                document.form.tml_agmt_ver_no.value		= "";
                initFormValue();
                initFormDisabled();
            }else{
                agmtRegFlg	= "N";
                //document.form.reset();
            }
            return "NoData"
//        } else if(sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) != "" && sheetObjects[5].CellValue(1, 3) == "" && sheetObjects[5].CellValue(1, 5) == ""){
        } else if(sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != "" && sheetObjects[5].CellValue(1, "tml_agmt_ver_no") != "" && sheetObjects[5].CellValue(1, "vndr_seq") == "" ){
        }
    }

	/**
     * Form Object Detail Value 초기화 Setting. <br>
     **/
	function initformDTL(){
		if(document.form.initFormDTLFlg.value == "Y"){

			document.form.tml_agmt_vol_ut_cd[1].value		= "";
			document.form.tml_agmt_vol_ut_cd[2].value		= "";
			document.form.tml_agmt_vol_ut_cd[1].disabled	= false;
			comboObjects[0].Enable	= true;
			comboObjects[1].Enable	= true;

			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[3].RemoveAll();

			document.form.auto_calc_flg[0].checked	= false;
			document.form.auto_calc_flg[1].checked	= false;
			
			if(tabObjects[0].selectedIndex == "0" || tabObjects[0].selectedIndex == "1"){
				comboObjects[0].Code	= sheetObjects[5].CellValue(1, "lgs_cost_cd");	// 13
				comboObjects[1].Code	= sheetObjects[5].CellValue(1, "curr_cd");	// 16
				document.form.auto_calc_flg.value			= sheetObjects[5].CellValue(1, "auto_calc_flg");	// 14
				document.form.tml_agmt_vol_ut_cd[1].value	= sheetObjects[5].CellValue(1, "tml_agmt_vol_ut_cd");	// 15
			}else if(tabObjects[0].selectedIndex == "2" || tabObjects[0].selectedIndex == "3"){
				comboObjects[5].Code	= sheetObjects[5].CellValue(1, "lgs_cost_cd");	// 13
				comboObjects[6].Code	= sheetObjects[5].CellValue(1, "curr_cd");	// 16
				document.form.tml_agmt_vol_ut_cd[2].value	= sheetObjects[5].CellValue(1, "tml_agmt_vol_ut_cd");	// 15
				document.form.tml_sto_agmt_tp_cd.value		= sheetObjects[5].CellValue(1, "tml_sto_agmt_tp_cd");	// 18
				document.form.cmnc_hrmnt.value				= sheetObjects[5].CellValue(1, "cmnc_hrmnt").substr(0,2)+":"+sheetObjects[5].CellValue(1, "cmnc_hrmnt").substr(2,4);	// 19
			}

			for(var i = 0; i < getElementCnt(document.form, 'radio', 'auto_calc_flg') ;i++){
				if(sheetObjects[5].CellValue(1, "auto_calc_flg") == "Y"){	// 14
					document.form.auto_calc_flg[i].checked		= true;
					document.form.auto_calc_flg[i+1].checked	= false;
					break;
				}
			else if(sheetObjects[5].CellValue(1, "auto_calc_flg") == "N"){	// 14
					document.form.auto_calc_flg[i].checked		= false;
					document.form.auto_calc_flg[i+1].checked	= true;
					break;
				}
			}
		}
	}
	
	/**
     * Form Object Detail Value 초기화 Setting. <br>
     **/
	function initformTerminalDTLs(){
		document.form.io_bnd_cd[1].value			= "";
		document.form.ioc_cd.value					= "";
		document.form.tml_trns_mod_cd.value			= "";
		document.form.tml_dy_aply_tp_cd[0].checked	= false;
		document.form.tml_dy_aply_tp_cd[1].checked	= false;
		document.form.wkdy_flg.checked				= false;
		document.form.sat_flg.checked				= false;
		document.form.sun_flg.checked				= false;
		document.form.hol_flg.checked				= false;
		comboObjects[2].Code						= -1;
		document.form.dcgo_aply_tp_cd[0].checked	= false;
		document.form.dcgo_aply_tp_cd[1].checked	= false;
		//document.form.dcgo_aply_tp_cd[2].checked	= false;
		document.form.dcgo_n1st_clss_flg.checked	= false;
		document.form.dcgo_n2nd_clss_flg.checked	= false;
		document.form.dcgo_n3rd_clss_flg.checked	= false;
		document.form.dcgo_n4th_clss_flg.checked	= false;
		document.form.dcgo_n5th_clss_flg.checked	= false;
		document.form.dcgo_n6th_clss_flg.checked	= false;
		document.form.dcgo_n7th_clss_flg.checked	= false;
		document.form.dcgo_n8th_clss_flg.checked	= false;
		document.form.dcgo_n9th_clss_flg.checked	= false;
		document.form.dcgo_none_clss_flg.checked	= false;
		document.form.cnt1.value					= 0;
		document.form.cnt2.value					= 0;
		document.form.thc_tp_cd[0].checked			= false;
		document.form.thc_tp_cd_flg.checked			= false;
		document.form.thc_tp_cd[1].checked			= false;
		document.form.thc_tp_cd[2].checked			= false;
		document.form.cntr_ts[0].checked			= false;
		document.form.cntr_ts[1].checked			= false;
		comboObjects[3].Code						= -1;
		comboObjects[4].Code						= -1;
		document.form.agmt_rate.value				= "";
	}

	/**
     * Form Object Storage FreeDay Detail Value 초기화 Setting. <br>
     **/
	function initformStorageFDDTLs(){
		document.form.storage_gb[0].checked				= false;
		document.form.storage_gb[1].checked				= false;
		document.form.io_bnd_cd[2].value				= "";
		document.form.sat_flg_FD.checked				= false;
		document.form.sun_flg_FD.checked				= false;
		document.form.hol_flg_FD.checked				= false;
		document.form.dcgo_aply_tp_cd_FD[0].checked		= false;
		document.form.dcgo_aply_tp_cd_FD[1].checked		= false;
		//document.form.dcgo_aply_tp_cd_FD[2].checked		= false;
		document.form.dcgo_same_R[0].checked			= false;
		document.form.dcgo_same_R[1].checked			= false;
		document.form.dcgo_same_R[0].disabled			= true;
		document.form.dcgo_same_R[1].disabled			= true;
		document.form.dcgo_n1st_clss_flg_FD.checked		= false;
		document.form.dcgo_n2nd_clss_flg_FD.checked		= false;
		document.form.dcgo_n3rd_clss_flg_FD.checked		= false;
		document.form.dcgo_n4th_clss_flg_FD.checked		= false;
		document.form.dcgo_n5th_clss_flg_FD.checked		= false;
		document.form.dcgo_n6th_clss_flg_FD.checked		= false;
		document.form.dcgo_n7th_clss_flg_FD.checked		= false;
		document.form.dcgo_n8th_clss_flg_FD.checked		= false;
		document.form.dcgo_n9th_clss_flg_FD.checked		= false;
		document.form.dcgo_none_clss_flg_FD.checked		= false;
		document.form.ft_dys.value						= "";
		document.form.io_bnd_cd[3].value				= "";
		document.form.dcgo_n1st_clss_flg_R.checked		= false;
		document.form.dcgo_n2nd_clss_flg_R.checked		= false;
		document.form.dcgo_n3rd_clss_flg_R.checked		= false;
		document.form.dcgo_n4th_clss_flg_R.checked		= false;
		document.form.dcgo_n5th_clss_flg_R.checked		= false;
		document.form.dcgo_n6th_clss_flg_R.checked		= false;
		document.form.dcgo_n7th_clss_flg_R.checked		= false;
		document.form.dcgo_n8th_clss_flg_R.checked		= false;
		document.form.dcgo_n9th_clss_flg_R.checked		= false;
		document.form.dcgo_none_clss_flg_R.checked		= false;
		document.form.cnt3.value						= 0;
		document.form.agmt_ut_rt.value					= "";
		document.form.cntr_ts[2].checked				= false;
		document.form.cntr_ts[3].checked				= false;
		comboObjects[7].Code							= -1;
		comboObjects[8].Code							= -1;
	}
	
	/**
     * Form Object Storage FreePool Detail Value 초기화 Setting. <br>
     **/
	function initformStorageFPDTLs(){
		document.form.fp_calc_prd_cd[0].checked	= false;
		document.form.fp_calc_prd_cd[1].checked	= false;
		document.form.fp_teu_qty.value			= "";
		document.form.agmt_ut_rt_fp.value		= "";
	}

	/**
     * Form Object Storage FreePool Detail Value 초기화 Setting. <br>
     **/
	function removeAgreementHDR(){
		document.form.f_cmd.value	= REMOVE;
		doActionIBSheet6(sheetObjects[5],document.form,IBSEARCH);
		document.form.reset();
		initFormValue();
		initFormDisabled();
		document.form.yd_cd.readOnly		= false;
		document.form.vndr_seq.readOnly		= false;
		document.form.ctrt_ofc_cd.readOnly	= false;
	}


	/**
     * Volume Unit Select CNTR Type / Size Setting. <br>
     **/
	function selectVolUOM(){
		if (document.form.tml_agmt_vol_ut_cd[1].value != "C"){
			document.form.cntr_ts[2].checked = false;
			document.form.cntr_ts[3].checked = false;
			
			for(var i=0; i<getElementCnt(document.form, 'radio', 'cntr_ts') ;i++){
				document.form.cntr_ts[0].disabled	= true;
				document.form.cntr_ts[1].disabled	= true;
			}
			comboObjects[3].Enable  = false;
			comboObjects[4].Enable  = false;
			
		} else if (document.form.tml_agmt_vol_ut_cd[1].value == "C"){
			document.form.cntr_ts[0].checked		= true;
			
			for(var i=0; i<getElementCnt(document.form, 'radio', 'cntr_ts') ;i++){
				document.form.cntr_ts[0].disabled	= false;
				document.form.cntr_ts[1].disabled	= false;
			}
		}
		
		if (document.form.tml_agmt_vol_ut_cd[2].value != "C"){
			document.form.cntr_ts[2].checked	= false;
			document.form.cntr_ts[3].checked	= false;
			
			for(var i=0; i<getElementCnt(document.form, 'radio', 'cntr_ts') ;i++){
				document.form.cntr_ts[2].disabled	= true;
				document.form.cntr_ts[3].disabled	= true;
			}
			comboObjects[7].Enable  = false;
			comboObjects[8].Enable  = false;
			
		} else if (document.form.tml_agmt_vol_ut_cd[2].value == "C"){
			document.form.cntr_ts[2].checked	= true;
			
			for(var i=0; i<getElementCnt(document.form, 'radio', 'cntr_ts') ;i++){
				document.form.cntr_ts[2].disabled	= false;
				document.form.cntr_ts[3].disabled	= false;
			}
		}
		document.form.agmt_rate.disabled	= false;
	}

	/**
     * Terminal Rate Input Tab Applied Date Same Selected CheckBox Setting. <br>
     **/
	function selectAplySame(){
		document.form.wkdy_flg.checked	= true;
		document.form.sat_flg.checked	= true;
		document.form.sun_flg.checked	= true;
		document.form.hol_flg.checked	= true;
		
		document.form.wkdy_flg.disabled	= true;
		document.form.sat_flg.disabled	= true;
		document.form.sun_flg.disabled	= true;
		document.form.hol_flg.disabled	= true;
	}

	/**
     * Terminal Rate Input Tab Applied Date Separate Selected CheckBox Setting. <br>
     **/
	function selectAplySep(){
		document.form.wkdy_flg.checked	= false;
		document.form.sat_flg.checked	= false;
		document.form.sun_flg.checked	= false;
		document.form.hol_flg.checked	= false;
	
		document.form.wkdy_flg.disabled	= false;
		document.form.sat_flg.disabled	= false;
		document.form.sun_flg.disabled	= false;
		document.form.hol_flg.disabled	= false;
	}


	/**
     * DG Class None Selected CheckBox Setting. <br>
     * @param{dg_gb}	DG Class 구분값 (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
     **/
	function selectDGNone(dg_gb){
	
		var cnt			= 0;
		var numOfEle	= document.form.elements.length;
		var element;
		
		for (var i = 0; i < numOfEle; i++){
			
			if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg" && dg_gb == ""){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked	= false;
	
			}else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_FD" && dg_gb == "_FD"){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked	= false;
				
			}else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_R" && dg_gb == "_R"){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked = false;
			}
		}
	
		for (var i = 0; i < numOfEle; i++){
			
			if (document.form.elements[i].name == "dcgo_same" && dg_gb == ""){
				document.form.elements[i].disabled = true;
				document.form.elements[i].checked = false;
		
			}else if (document.form.elements[i].name == "dcgo_same_FD"  && dg_gb == "_FD"){
				document.form.elements[i].disabled = true;
				document.form.elements[i].checked = false;
				
			}else if (document.form.elements[i].name == "dcgo_same_R" && dg_gb == "_R"){
				document.form.elements[i].disabled = true;
				document.form.elements[i].checked = false;
			}
		}
	}

	/**
     * DG Class Same Selected CheckBox Setting. <br>
     * @param{dg_gb}	DG Class 구분값 (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
     **/
	function selectDGSame(dg_gb){
		//document.form.dcgo_same.disabled=true;
		var cnt			= 0;
		var numOfEle	= document.form.elements.length;
		var element;
		
		for (var i = 0; i < numOfEle; i++){

			if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg" && dg_gb == ""){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked	= false;

			}else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_FD" && dg_gb == "_FD"){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked	= false;
				
			}else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_R" && dg_gb == "_R"){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked	= false;
			}
		}
	
		for (var i = 0; i < numOfEle; i++){
			if (document.form.elements[i].name == "dcgo_same" && dg_gb == ""){
				document.form.elements[i].disabled	= false;
	
			}else if (document.form.elements[i].name == "dcgo_same_FD"  && dg_gb == "_FD"){
				document.form.elements[i].disabled	= false;
	
			}else if (document.form.elements[i].name == "dcgo_same_R" && dg_gb == "_R"){
				document.form.elements[i].disabled	= false;
			}
		}
	}

	/**
     * DG Class Separate Selected CheckBox Setting. <br>
     * @param{dg_gb}	DG Class 구분값 (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
     **/
	function selectDGSep(dg_gb){
	
		var cnt			= 0;
		var numOfEle	= document.form.elements.length;
		var element;
		
		for (var i = 0; i < numOfEle; i++){
			if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg" && dg_gb == ""){
				document.form.elements[i].disabled	= false;
	
			}else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_FD" && dg_gb == "_FD"){
				document.form.elements[i].disabled	= false;
				
			}else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_R" && dg_gb == "_R"){
				document.form.elements[i].disabled	= false;
			}
		}
	
		for (var i = 0; i < numOfEle; i++){
			if (document.form.elements[i].name == "dcgo_same" && dg_gb == ""){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked	= false;
	
			}else if (document.form.elements[i].name == "dcgo_same_FD"  && dg_gb == "_FD"){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked	= false;
	
			}else if (document.form.elements[i].name == "dcgo_same_R" && dg_gb == "_R"){
				document.form.elements[i].disabled	= true;
				document.form.elements[i].checked	= false;
			}
		}
	}

	
	/**
     * DG Class Same DG Selected CheckBox Setting. <br>
     * @param{dg_gb}	DG Class 구분값 (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
     **/
	function same_dg(dg_gb){
	
		var cnt = 0;
		var element;
		var numOfEle = document.form.elements.length;
		
		for (var i = 0; i < numOfEle; i++){
			
			if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg" && dg_gb == ""){
	
				//document.form.elements[i].checked = true;
				if (document.form.elements[i].name.substr(4,6) == "_none_"){
					document.form.elements[i].checked	= false;
				}
	
			} else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_FD" && dg_gb == "_FD"){
				//document.form.elements[i].checked = true;
				if (document.form.elements[i].name.substr(4,6) == "_none_"){
					document.form.elements[i].checked	= false;
				}
			} else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_R" && dg_gb == "_R"){
				
				//document.form.elements[i].checked = true;
				if (document.form.elements[i].name.substr(4,6) == "_none_"){
					document.form.elements[i].checked	= false;
				}
			}
		}
	}

	/**
     * DG Class Same NODG Selected CheckBox Setting. <br>
     * @param{dg_gb}	DG Class 구분값 (_FD: Storage FreeDay, _R:Storage Rate, null:Terminal )
     **/
	function same_nodg(dg_gb){
		var cnt = 0;
		var element;
		var numOfEle = document.form.elements.length;
		
		for (var i = 0; i < numOfEle; i++){
			if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg" && dg_gb == ""){
				
				if (document.form.elements[i].name.substr(4,6) != "_none_"){
					document.form.elements[i].checked	= false;
				}
				
			}else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_FD" && dg_gb == "_FD"){
				
				if (document.form.elements[i].name.substr(4,6) != "_none_"){
					document.form.elements[i].checked	= false;
				}
				
			}else if (document.form.elements[i].name.substr(0,5) == "dcgo_" && document.form.elements[i].name.substr(9,12) == "_clss_flg_R" && dg_gb == "_R"){
				if (document.form.elements[i].name.substr(4,6) != "_none_"){
					document.form.elements[i].checked	= false;
				}
			}
		}
	}

	/**
     * CNTR Type/Size All Selected Setting. <br>
     * @param{i}	구분값 ( 0: Terminal, 1: Storage )
     **/
	function selectTSAll(i){
	
		if(i == 0){
			comboObjects[3].Code2	= "-1";
			comboObjects[4].Code2	= "-1";
	
			comboObjects[3].Enable	= false;
			comboObjects[4].Enable	= false;
			document.form.agmt_rate.disabled = false;
		}
	
		if(i == 1){
			comboObjects[7].Code2	= "-1";
			comboObjects[8].Code2	= "-1";
			
			comboObjects[7].Enable  = false;
			comboObjects[8].Enable  = false;
			document.form.agmt_ut_rt.disabled = false;
		}
	}


	/**
     * CNTR Type/Size By Type / Size Selected Setting. <br>
     * @param{i}	구분값 ( 0: Terminal, 1: Storage )
     **/
	function selectTS(i){

		if(i==0){
			comboObjects[3].Enable	= true;
			comboObjects[4].Enable	= true;
			document.form.agmt_rate.disabled	= false;
		}

		if(i==1){
			comboObjects[7].Enable	= true;
			comboObjects[8].Enable	= true;
			document.form.agmt_ut_rt.disabled	= false;
		}
	}

	/**
     * CNTR Type/Size By Type / Size Selected Setting. <br>
     * @param{i}	구분값 ( 0: Terminal, 1: Storage )
     **/
	function selectType(i){
	
		if(i==0){
			comboObjects[4].Code2	= "-1";
			comboObjects[4].Enable  = false;
		}
	
		if(i==1){
			comboObjects[8].Code2	= "-1";
			comboObjects[8].Enable  = false;
		}
	}

	/**
     * Add Dot. <br>
     * @param{obj}	Value
     **/
	function addDot(obj){
		var tem_val	= 0;
		tem_val		= obj.value;
		obj.value	= (tem_val==0?"0.00":tem_val);
		
		if(obj.value.indexOf(".") == -1)	obj.value += ".";
		var strLen	= getStrLen(obj.value.substr(obj.value.indexOf(".")+1,getStrLen(obj.value)));
		
		if(strLen < 2){
			for(var i = 0; i < (2-strLen); i++){
				obj.value += "0";
			}
		}
	}

	/**
     * Add Dot. <br>
     * @param{src}	Value
     **/
	function addDot2(src){
		var tem_val	= 0;
		tem_val		= src;
		src	= (tem_val==0?"0.00":tem_val);

		if(src.indexOf(".") == -1)	src += ".";
		var strLen	= getStrLen(src.substr(src.indexOf(".")+1,getStrLen(src)));
		
		if(strLen < 2){
			for(var i=0; i< (2-strLen); i++){
				src += "0";
			}
		}
		return src;
	}
	
	/**
     * Terminal Agreement Confirm. <br>
     **/
	function terminalAgreementConfirm(){
		formObject = document.form;
		formObject.sheet_prefix.value	= "3";
		formObject.f_cmd.value			= MULTI02;
	
		sheetObjects[5].RowStatus(1)	= "I";	// 0
		sheetObjects[5].CellValue(1, "tml_agmt_sts_cd")	= "C";	// 11
//		sheetObjects[5].DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));
		sheetObjects[5].DoAllSave("ESD_TES_0034Detail.do", tesFrmQryStr(formObject));
	}


	/**
     * Storage Agreement Confirm. <br>
     **/
	function storageAgreementConfirm(){
		formObject	= document.form;
		formObject.sheet_prefix.value	= "5";
		formObject.f_cmd.value			= MULTI02;

		sheetObjects[5].RowStatus(1)	= "I";	// 0
		sheetObjects[5].CellValue(1, "tml_agmt_sts_cd")	= "C";	// 11
		sheetObjects[5].DoAllSave("ESD_TES_0034Detail.do", tesFrmQryStr(formObject));
//		sheetObjects[5].DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));
	}

	/**
     * t1sheet3 After Save Execute. <br>
     * @param{ibsheet}	t1sheet3	Sheet Object
     * @param{String}	ErrMsg		Error Message
     **/
	function t1sheet3_OnSaveEnd(t1sheet3, ErrMsg){
		var srcName	= window.event.srcElement.getAttribute("name");
		var formObject = document.form;
		
		if (ErrMsg == ""){
			if(srcName=="btn_save"){
				ComShowCodeMessage('TES10069'); // Agreement header information Save has been completed. //Agreement 헤더정보 Save처리가 되었습니다.
				// 저장후 시트 재조회
				formObject.tml_agmt_tp_cd.value	= "T";
				formObject.f_cmd.value	= SEARCH ;

				doActionIBSheet6(sheetObjects[5], formObject, IBSEARCH);
				
			} else if(srcName=="t1btng_save"){
				ComShowCodeMessage('TES10070');   //Terminal Agreement 정보 중간Save처리가 되었습니다.
				
			} else if(srcName=="t3btng_save"){
				ComShowCodeMessage('TES10071');      //Storage Agreement 정보 중간Save처리가 되었습니다.
				
			} else {
				ComShowCodeMessage('TES10072');      //Agreement가 성공적으로 저장 되었습니다.
			
				document.form.tml_agmt_ver_no.value	= t1sheet3.EtcData("agmt_ver");
				
				formObject.tml_agmt_tp_cd.value		= "T";
				formObject.tml_agmt_ver_no.value	= "";
				formObject.f_cmd.value	= SEARCH ;

				doActionIBSheet6(sheetObjects[5], formObject, IBSEARCH);
			}
		} else{
		    ComShowCodeMessage('TES10077', ErrMsg);	// Save Fail {?msg1}
		}
	}

	/**
     * t1sheet4 After Save Execute. <br>
     * @param{ibsheet}	t1sheet4	Sheet Object
     * @param{String}	ErrMsg		Error Message
     **/
	function t1sheet4_OnSaveEnd(t1sheet4, ErrMsg){
		var srcName		= window.event.srcElement.getAttribute("name");
		var formObject	= document.form;
		
		if (ErrMsg == ""){
			ComShowCodeMessage('TES10072');

			document.form.tml_agmt_ver_no.value = t1sheet4.EtcData("agmt_ver");

			formObject.tml_agmt_tp_cd.value		= "T";
			formObject.tml_agmt_ver_no.value	= "";
			formObject.f_cmd.value				= SEARCH ;

			doActionIBSheet6(sheetObjects[5],formObject,IBSEARCH);

    		//doActionIBSheet3(sheetObjects[2],formObject,IBSEARCH);

		} else{
			ComShowCodeMessage('TES10077', ErrMsg);
		}
	}

	/**
	 * t1sheet5 (Verify Flag Sheet) After Search Execute. <br>
	 **/
	function t1sheet5_OnSearchEnd(){
		dataTerminalErrCount	= 0;
		dataStorageErrCount		= 0;
	
		if( tabObjects[0].selectedIndex == 1 ) {
			dataTerminalErrCount	= dataTerminalVerify();
			
		}else if( tabObjects[0].selectedIndex == 3 ) {
			dataStorageErrCount		= dataStorageVerify();
			//ComShowMessage("dataStorageErrCount : "+dataStorageErrCount);
		}
	}

	/**
     * Terminal Rate List Tab (t2sheet1) After Save Process Execute. <br>
     * @param{ibsheet}	t2sheet1	Sheet Object
     * @param{String}	ErrMsg		Error Message
     **/
	function t2sheet1_OnSaveEnd(t2sheet1, ErrMsg){
		var srcName	= window.event.srcElement.getAttribute("name");
		
		if (ErrMsg == ""){
			if(srcName == "t2btng_save") {
				ComShowCodeMessage('TES10110');
				
			} else if(srcName == "t2btng_registeragree") {
				ComShowCodeMessage('TES10074');
				
			} else if(srcName == "btn_save") {
				ComShowCodeMessage('TES10111');
				
			} else if(srcName == "t2btng_delete") {
				ComShowCodeMessage('TES10127');
			}
			tab2VerifyFlg = "";
			document.form.tml_agmt_ver_no.value = t2sheet1.EtcData("agmt_ver");
		} else{
			ComShowCodeMessage('TES10077', ErrMsg);
		}
	}

	/**
	 * Storage Rate List Tab (t4sheet1) After Save Process Execute. <br>
	 * @param {ibsheet}	t4sheet1	IBSheet Object
	 * @param {String}	ErrMsg		Error Message
	 * @return
	 */
	function t4sheet1_OnSaveEnd(t4sheet1, ErrMsg){
		var srcName = window.event.srcElement.getAttribute("name");
		if (ErrMsg == ""){
			if(srcName == "t4btng_save" ) {
				ComShowCodeMessage('TES10110');
			} else if(srcName == "t4btng_registeragree") {
				ComShowCodeMessage('TES10074');
			} else if(srcName == "btn_save" ) {
				ComShowCodeMessage('TES10111');
			} else if(srcName == "t4btng_delete") {
				ComShowCodeMessage('TES10128');
			}
			tab4VerifyFlg = "";
	
			document.form.tml_agmt_ver_no.value = t4sheet1.EtcData("agmt_ver");
		}
		else{
			ComShowCodeMessage('TES10077', ErrMsg);
		}
	}

	/**
	 * 
	 * @param {String}	gb  구분값
	 * @return
	 */
	function checkTHC(gb){
		if(gb == 1){
			document.form.thc_tp_cd_flg.checked = false;
			document.form.thc_tp_cd[1].checked = false;
			document.form.thc_tp_cd[2].checked = false;
	
			document.form.thc_tp_cd[1].disabled = true;
			document.form.thc_tp_cd[2].disabled = true;
		}else if(gb == 2){
			document.form.thc_tp_cd[0].checked = false;
			document.form.thc_tp_cd[1].checked = false;
			document.form.thc_tp_cd[2].checked = false;
	
			document.form.thc_tp_cd[1].disabled = false;
			document.form.thc_tp_cd[2].disabled = false;
		}
	}

	/**
	 * 
	 * @return
	 */
	function freeDays(){
		document.form.io_bnd_cd[3].value="";
		document.form.io_bnd_cd[3].disabled=true;
	
		document.form.io_bnd_cd[2].disabled=false;
		document.form.io_bnd_cd[2].value = "S";
	
		for(var i=0; i<getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_FD') ;i++){
				document.form.dcgo_aply_tp_cd_FD[i].disabled=false;
		}
	
		document.form.dcgo_n1st_clss_flg_FD.disabled=false;
		document.form.dcgo_n2nd_clss_flg_FD.disabled=false;
		document.form.dcgo_n3rd_clss_flg_FD.disabled=false;
		document.form.dcgo_n4th_clss_flg_FD.disabled=false;
		document.form.dcgo_n5th_clss_flg_FD.disabled=false;
		document.form.dcgo_n6th_clss_flg_FD.disabled=false;
		document.form.dcgo_n7th_clss_flg_FD.disabled=false;
		document.form.dcgo_n8th_clss_flg_FD.disabled=false;
		document.form.dcgo_n9th_clss_flg_FD.disabled=false;
		document.form.dcgo_none_clss_flg_FD.disabled=false;
	
		//document.form.dcgo_aply_tp_cd_FD[0].checked=true;
		selectDGNone('_FD');
	
		document.form.sat_flg_FD.disabled=false;
		document.form.sun_flg_FD.disabled=false;
		document.form.hol_flg_FD.disabled=false;
	
		document.form.ft_dys.disabled=false;
	
		for(var i=0; i<getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_R') ;i++){
				document.form.dcgo_aply_tp_cd_R[i].disabled=true;
		}
	
		document.form.dcgo_n1st_clss_flg_R.disabled=true;
		document.form.dcgo_n2nd_clss_flg_R.disabled=true;
		document.form.dcgo_n3rd_clss_flg_R.disabled=true;
		document.form.dcgo_n4th_clss_flg_R.disabled=true;
		document.form.dcgo_n5th_clss_flg_R.disabled=true;
		document.form.dcgo_n6th_clss_flg_R.disabled=true;
		document.form.dcgo_n7th_clss_flg_R.disabled=true;
		document.form.dcgo_n8th_clss_flg_R.disabled=true;
		document.form.dcgo_n9th_clss_flg_R.disabled=true;
		document.form.dcgo_none_clss_flg_R.disabled=true;
	
	
		for(var i=0; i<getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_R') ;i++){
				document.form.dcgo_aply_tp_cd_R[i].checked=false;
		}
	
		document.form.dcgo_n1st_clss_flg_R.checked=false;
		document.form.dcgo_n2nd_clss_flg_R.checked=false;
		document.form.dcgo_n3rd_clss_flg_R.checked=false;
		document.form.dcgo_n4th_clss_flg_R.checked=false;
		document.form.dcgo_n5th_clss_flg_R.checked=false;
		document.form.dcgo_n6th_clss_flg_R.checked=false;
		document.form.dcgo_n7th_clss_flg_R.checked=false;
		document.form.dcgo_n8th_clss_flg_R.checked=false;
		document.form.dcgo_n9th_clss_flg_R.checked=false;
		document.form.dcgo_none_clss_flg_R.checked=false;
	
		document.form.cnt3.disabled = true;
		document.form.cnt3.value = 0;
	
		//sheetObjects[3].RemoveAll();
		if(sheetObjects[3].RowCount == 1){
	
		}else if(sheetObjects[3].RowCount > 1){
				sheetObjects[3].RemoveAll();
				document.form.cnt3.value = 1;
				var iRow = sheetObjects[3].DataInsert(-1);
	   		sheetObjects[3].CellValue2(iRow, 0)= "1";
	  		sheetObjects[3].CellValue2(iRow, 2)= "1";
	  		sheetObjects[3].CellValue2(iRow, 3)= "MAX";
		}else{
				sheetObjects[3].RemoveAll();
		}
	
		document.form.agmt_ut_rt.value = "" ;
		document.form.agmt_ut_rt.disabled = true ;
	
	}

	/**
	 * 
	 * @return
	 */
	function rate(){
		document.form.io_bnd_cd[2].value="";
		document.form.io_bnd_cd[2].disabled=true;
	
		document.form.io_bnd_cd[3].disabled=false;
		document.form.io_bnd_cd[3].value = "S";
		if(sheetObjects[3].CellValue(2, 0) =="1" && sheetObjects[3].CellValue(2, 2)== "1" && sheetObjects[3].CellValue(2, 3)== "MAX" ){
				document.form.cnt3.value = 1;
				//document.form.cnt3.disabled = false;
		}
	
		for(var i=0; i<getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_R') ;i++){
				document.form.dcgo_aply_tp_cd_R[i].disabled=false;
		}
	
		document.form.dcgo_n1st_clss_flg_R.disabled=false;
		document.form.dcgo_n2nd_clss_flg_R.disabled=false;
		document.form.dcgo_n3rd_clss_flg_R.disabled=false;
		document.form.dcgo_n4th_clss_flg_R.disabled=false;
		document.form.dcgo_n5th_clss_flg_R.disabled=false;
		document.form.dcgo_n6th_clss_flg_R.disabled=false;
		document.form.dcgo_n7th_clss_flg_R.disabled=false;
		document.form.dcgo_n8th_clss_flg_R.disabled=false;
		document.form.dcgo_n9th_clss_flg_R.disabled=false;
		document.form.dcgo_none_clss_flg_R.disabled=false;
	
		//document.form.dcgo_aply_tp_cd_R[0].checked=true;
		selectDGNone('_R');
	
		document.form.cnt3.disabled = false;
		document.form.agmt_ut_rt.disabled = false;
	
		for(var i=0; i<getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_FD') ;i++){
				document.form.dcgo_aply_tp_cd_FD[i].disabled=true;
		}
		document.form.dcgo_n1st_clss_flg_FD.disabled=true;
		document.form.dcgo_n2nd_clss_flg_FD.disabled=true;
		document.form.dcgo_n3rd_clss_flg_FD.disabled=true;
		document.form.dcgo_n4th_clss_flg_FD.disabled=true;
		document.form.dcgo_n5th_clss_flg_FD.disabled=true;
		document.form.dcgo_n6th_clss_flg_FD.disabled=true;
		document.form.dcgo_n7th_clss_flg_FD.disabled=true;
		document.form.dcgo_n8th_clss_flg_FD.disabled=true;
		document.form.dcgo_n9th_clss_flg_FD.disabled=true;
		document.form.dcgo_none_clss_flg_FD.disabled=true;
	
		for(var i=0; i<getElementCnt(document.form, 'radio', 'dcgo_aply_tp_cd_FD') ;i++){
				document.form.dcgo_aply_tp_cd_FD[i].checked=false;
		}
		document.form.dcgo_n1st_clss_flg_FD.checked=false;
		document.form.dcgo_n2nd_clss_flg_FD.checked=false;
		document.form.dcgo_n3rd_clss_flg_FD.checked=false;
		document.form.dcgo_n4th_clss_flg_FD.checked=false;
		document.form.dcgo_n5th_clss_flg_FD.checked=false;
		document.form.dcgo_n6th_clss_flg_FD.checked=false;
		document.form.dcgo_n7th_clss_flg_FD.checked=false;
		document.form.dcgo_n8th_clss_flg_FD.checked=false;
		document.form.dcgo_n9th_clss_flg_FD.checked=false;
		document.form.dcgo_none_clss_flg_FD.checked=false;
	
		document.form.sat_flg_FD.disabled=true;
		document.form.sun_flg_FD.disabled=true;
		document.form.hol_flg_FD.disabled=true;
	
		document.form.sat_flg_FD.checked=false;
		document.form.sun_flg_FD.checked=false;
		document.form.hol_flg_FD.checked=false;
	
		document.form.ft_dys.value="";
		document.form.ft_dys.disabled=true;
	}

	/**
	 * 
	 * @param {String}	tml_agmt_ofc_cty_cd
	 * @param {String}	tml_agmt_ver_no
	 * @return
	 */
	function detailRetrieve(tml_agmt_ofc_cty_cd,tml_agmt_ver_no){
		document.form.tml_agmt_ofc_cty_cd.value=tml_agmt_ofc_cty_cd;
		document.form.tml_agmt_ver_no.value=tml_agmt_ver_no;
		document.form.f_cmd.value = SEARCH ;
	
		doActionIBSheet6(sheetObjects[5],document.form,IBSEARCH);
	}

	/**
	 * 
	 * @param {Object}		obj
	 * @param {String}		isChkFmt
	 * @param {int,String}	int_str
	 * @return
	 */
	function tes_cmnctime(obj, isChkFmt, int_str){
		if (isChkFmt==undefined || isChkFmt==null || isChkFmt.trim()==''){
			// 단순히 숫자와 ':'만 허용
			if (!isNumHHMM(obj)){obj.value = '';
			}
		} else if (isChkFmt!=undefined && isChkFmt!=null && isChkFmt=='Y'){
			var int_char = (int_str!=undefined&&int_str!=null&int_str.trim()!=''?int_str.trim():':');
			var src = obj.value;
			for (var i=0; src!=null && i<src.length; i++){
				if ((i!=2 && !ComIsNumber(src.charAt(i))) || ((i==2) && !isNumColon2(src.charAt(i)))){
					src = src.substring(0,i) + src.substring(i+1,src.length);
				} else {
					if ((i==2) && (src.charAt(i)!=int_char)){
						src = src.substring(0,i) + int_char + src.substring(i,src.length);
					}
				}
			}
			obj.value = src;
		}
		return true;
	}

	/**
	 * . <br>
	 * 
	 * @param {String}    Value     Text Value
	 **/
    function isNumColon2(val) {
        var chars = ":0123456789";
        return ComIsContainsCharsOnly(val,chars);
    }

	/**
	 * Form Vendor Code Focus 이동. <br>
	 **/
    function vndr_seq_Focus(){
     	document.form.vndr_seq.focus();
    }

	/**
	 * Form Contract Office Code Focus 이동. <br>
	 **/
    function cont_ofc_Focus(){
    	document.form.ctrt_ofc_cd.focus();
    }
	
	/**
	 * Form에서 Element 이름/유형 일치하는 갯수 파악. <br>
	 * 
	 * @param {Object}	formObject	Form Object
	 * @param {String}	eleTp		element Type
	 * @param {String}	eleNm		element Name
	 **/
	function getElementCnt(formObject, eleTp, eleNm) {
	
		var cnt = 0;
		var element;
		var numOfEle = formObject.elements.length;
		for (var i = 0; i < numOfEle; i++){
			if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
				cnt++;
			}
		}
	
		return cnt;
	}

	/**
	 * Form Object Value 조회. <br>
	 * 
	 * @param {Object}	formObject	Form Object
	 * @param {String}	eleTp		element Type
	 * @param {String}	eleNm		element Name
	 **/
	function getElementValue(formObject, eleTp, eleNm) {
	
		var element;
		var numOfEle	= formObject.elements.length;
		for (var i = 0; i < numOfEle; i++){
			
			if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
				
				if (formObject.elements[i].checked == true){
					var ele_value = formObject.elements[i].value;
					break;
				}
			}
		}
	
		return ele_value;
	}

	/**
	 * Form Object Check 조회. <br>
	 * 
	 * @param {Object}	formObject	Form Object
	 * @param {String}	eleTp		element Type
	 * @param {String}	eleNm		element Name
	 **/
	function getElementCheck(formObject, eleTp, eleNm) {
	
		var element;
		var numOfEle = formObject.elements.length;
		for (var i = 0; i < numOfEle; i++){
			if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm){
				if (formObject.elements[i].checked == true){
					return true;
				}else{
					return false;
				}
			}
		}
	}

	/**
	 * Date Validate. <br>
	 * 
	 * @param {Object}		obj		Object
	 **/
	function validateDateObj(obj){
		if (obj.readOnly==true){return false;}
		obj.value = obj.value.trim();
		
		if (obj.value==null || obj.value.trim()==''){return false;}
		
		if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value,'-')){
			ComShowCodeMessage('TES10013');
			obj.focus();
			return false;
		}
		
		var formObj = document.form;
		
		if (formObj.eff_fm_dt.value!=null && formObj.eff_fm_dt.value.trim()!='' &&
			formObj.eff_to_dt.value!=null && formObj.eff_to_dt.value.trim()!='' &&
			!isValFmTo(formObj.eff_fm_dt.value, formObj.eff_to_dt.value)){
			ComShowCodeMessage('TES10112');
			return false;
		}
	}

	/**
	 * From ~ To Date Validate. <br>
	 * 
	 * @param {String}		fmDt		From Date
	 * @param {String}		toDt		To Date
	 **/
	function isValFmTo(fmDt, toDt){
		if (fmDt==undefined || fmDt==null || fmDt.trim()=='' || toDt==undefined || toDt==null || toDt.trim()==''){
			return false;
		}
		var str_fmDt = fmDt.replace(/-/gi,'');
		var str_toDt = toDt.replace(/-/gi,'');
		
		if (isNaN(str_fmDt) || isNaN(str_toDt) || str_fmDt.trim().length!=8 || str_toDt.trim().length!=8) {
			return false;
		}
		
		if (parseInt(str_toDt,10) - parseInt(str_fmDt,10) <= 0){
			return false;
		}
		
		return true;
	}

	/**
	 * From ~ To Date Period Check Format. <br>
	 * 
	 * @param {String}		prd_dt		Period Date
	 **/
	function checkPeriodFormat(prd_dt){
		var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
		if (!tes_checkFormat2(prd_dt, date_regexp)){	return false;
		} else { return true;
		}
	}

	/**
	 * Header Info Remark Save.<br>
	 * 
	 **/	
	function topBtnSave_RmkSave(){
			var formObject = document.form;
			var sheetObject5  = sheetObjects[5];

			formObject.agmt_confirm_flg.value	= "agmtRmk";
			formObject.f_cmd.value	= MULTI03;
			
//			DoAllSave 사용시 sheet save name 와 form의 객체 이름이 동일할때 문제 발생.
//			GetSaveXml 로 바꿈 2009/12/22
//			sheetObject5.DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));
			var SaveStr = sheetObject5.GetSaveString(true);
			var sXml = sheetObject5.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
			sheetObject5.LoadSaveXml(sXml,true);			
	}

	/**
	 * Only Header Info Save.<br>
	 * 
	 **/	
	function topBtnSave_OnlyTopSave() {
		var formObject		= document.form;
		var sheetObject5	= sheetObjects[5];
		formObject.tml_agmt_ofc_cty_cd.value	= "";
		formObject.tml_agmt_ver_no.value		= "";
		formObject.tml_agmt_tp_cd.value			= "T";
		formObject.f_cmd.value	= SEARCH06;
		
		doActionIBSheet6(sheetObject5, formObject, IBSEARCH);
		
		// 1, 2 tml_agmt_ofc_cty_cd, tml_agmt_seq
//		if(sheetObjects[5].CellValue(1, 1) != "" && sheetObjects[5].CellValue(1, 2) != "" ) {
		if(sheetObjects[5].CellValue(1, "tml_agmt_ofc_cty_cd") != "" ) {
			ComShowCodeMessage('TES10113');		// There is registered Agreement with same Yard, Vendor.
		} else {
			
			if( agmtRegFlg == "Y" ) {
				
				// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27)
				if ( !checkHdrSaveCreUpdUser() ) {
					return false
				}	
				
				formObject.f_cmd.value	= ADD;
				doActionIBSheet6(sheetObject5,formObject,IBSAVE);
				formObject.f_cmd.value	= SEARCH;
				doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
				agmtRegFlg	= "";
			}
		}
	}
	
	/**
	 * Agreement Confirm Save.<br>
	 * 
	 **/	
	function topBtnSave_Confirm(){		 
		var formObject		= document.form;
		var sheetObject2	= sheetObjects[2];
		var sheetObject4	= sheetObjects[4];
		var sheetObject5	= sheetObjects[5];
		
		var sheet2TransCount	= 0;
		var sheet4TransCount	= 0;
		var modifyTop			= "N";
		var modifySheet			= "N";
		var remarkFlg			= "N";
		
		// 8, 9, 10
		if( sheetObjects[5].CellValue(1,"eff_fm_dt") == formObject.eff_fm_dt.value &&
			sheetObjects[5].CellValue(1,"eff_to_dt") == formObject.eff_to_dt.value &&
			sheetObjects[5].CellValue(1,"auto_xtd_flg") == getElementValue(formObject, 'radio', 'auto_xtd_flg') &&
			sheetObjects[5].CellValue(1,"agmt_apro_dt") == formObject.agmt_apro_dt.value &&
			sheetObjects[5].CellValue(1,"agmt_cfm_dt") == formObject.agmt_cfm_dt.value &&
			sheetObjects[5].CellValue(1, "agmt_cfm_flg") == formObject.agmt_cfm_flg.value
		)
		{
			modifyTop  = "N";
		}else{
			modifyTop  = "Y";
		}

		if(sheetObjects[5].CellValue(1,"agmt_rmk") != formObject.agmt_rmk.value ) {	// 12
            remarkFlg	= "Y";
        }

		if(tabObjects[0].selectedIndex == 1){
        	
			for(var i = 0; i < sheetObjects[2].RowCount; i++){
            	
				if( sheetObjects[2].CellValue(i+3,"3ibflag") == "U" ||
                	sheetObjects[2].CellValue(i+3,"3ibflag") == "D" ||
                	sheetObjects[2].CellValue(i+3,"3ibflag") == "I" ) {
                    sheet2TransCount	= sheet2TransCount + 1;
                }
            }

            if(sheet2TransCount > 0 ) {
                modifySheet = "Y";
            }
		}else if( tabObjects[0].selectedIndex == 3 ){
        	
            for(var i = 0; i < sheetObjects[4].RowCount; i++){
            	
                if( sheetObjects[4].CellValue(i+3,"5ibflag") == "U" ||
                	sheetObjects[4].CellValue(i+3,"5ibflag") == "D" ||
                	sheetObjects[4].CellValue(i+3,"5ibflag") == "I" ) {
                    sheet4TransCount = sheet4TransCount +1;
                }
            }

            if(sheet4TransCount>0){
            	modifySheet = "Y";
            }
		}else{
        	modifySheet = "N";
        }

		if((modifyTop == "Y" || getElementValue(formObject, 'radio', 'amend_flg') == "Y" ) && modifySheet == "Y" ) {
			ComShowCodeMessage('TES10114');		// Header 입력 데이터와 Agreement List 데이터가 동시에 변경되어 있습니다.
												// 상단 입력 데이터를 변경 적용시킨후 Agreement List 데이터를 수정하세요.
			return false;
		}

		if(modifyTop=="N" && getElementValue(formObject, 'radio', 'amend_flg')!="Y" && modifySheet=="N"){
			ComShowCodeMessage('TES10115');  //Header 입력 데이터와 Agreement List 데이터의 변경사항이 없습니다. 다시 확인하세요.
			return false;
		}
		
		if( getElementValue(formObject, 'radio', 'amend_flg') == "Y" && modifySheet == "N" ) {
			formObject.agmt_confirm_flg.value	= "level1";
			formObject.f_cmd.value	= MULTI03;
			
//			DoAllSave 사용시 sheet save name 와 form의 객체 이름이 동일할때 문제 발생.
//			GetSaveXml 로 바꿈 2009/12/22			
//			sheetObject2.DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));            
            var SaveStr = sheetObject2.GetSaveString(true);
            var sXml = sheetObject2.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
            sheetObject2.LoadSaveXml(sXml,true);
            
        } else if(modifyTop == "Y" && getElementValue(formObject, 'radio', 'amend_flg') != "Y" && modifySheet == "N"){
        	
			// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27)
			if ( !checkHdrSaveCreUpdUser() ) {
				return false
			}	
        	
            formObject.agmt_confirm_flg.value	= "level2";
            formObject.f_cmd.value	= MULTI03;

            var SaveStr = sheetObject2.GetSaveString(true);
            var sXml = sheetObject2.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
            sheetObject2.LoadSaveXml(sXml,true);
        } else if(modifyTop == "N" && getElementValue(formObject, 'radio', 'amend_flg') != "Y" && modifySheet == "Y"){
            formObject.agmt_confirm_flg.value = "sheet";

            if(tabObjects[0].selectedIndex == 1){
            	
                if(sheet2TransCount > 0){
                    formObject.tml_agmt_tp_cd.value	= "T";
                    formObject.sheet_prefix.value	= "3";
                    formObject.f_cmd.value			= MULTI03;
                    formObject.select_tab.value		= tabObjects[0].selectedIndex;
                    //sheetObject2.DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));
                    var SaveStr = sheetObject2.GetSaveString(true);
                    var sXml = sheetObject2.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
                    sheetObject2.LoadSaveXml(sXml,true);
                }
            }else if(tabObjects[0].selectedIndex == 3){
                if(sheet4TransCount > 0){
                    formObject.tml_agmt_tp_cd.value	= "S";
                    formObject.sheet_prefix.value	= "5";
                    formObject.f_cmd.value			= MULTI03;
                    formObject.select_tab.value		= tabObjects[0].selectedIndex;
                    var SaveStr = sheetObject4.GetSaveString(true);
                    var sXml = sheetObject4.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
                    sheetObject4.LoadSaveXml(sXml,true);
                }
            }
        }

        formObject.inquiryFlg.value	= "";
        newRetrieve();
    }
	
	/**
	 * Agreement Process Save.<br>
	 * 
	 **/	
	function topBtnSave_Process(){
		var formObject		= document.form;
		var sheetObject2	= sheetObjects[2];
		var sheetObject4	= sheetObjects[4];
		var sheetObject5	= sheetObjects[5];

		var sheet2TransCount = 0;
		var sheet4TransCount = 0;

		var modifyTop  = "N";
		// 8, 9, 10, 12
		if( sheetObjects[5].CellValue(1, "eff_fm_dt")			== formObject.eff_fm_dt.value &&
			sheetObjects[5].CellValue(1, "eff_to_dt")			== formObject.eff_to_dt.value &&
			sheetObjects[5].CellValue(1, "auto_xtd_flg")		== getElementValue(formObject, 'radio', 'auto_xtd_flg') &&
			sheetObjects[5].CellValue(1, "agmt_rmk")		== formObject.agmt_rmk.value &&
			sheetObjects[5].CellValue(1, "agmt_apro_dt")	== formObject.agmt_apro_dt.value &&
			sheetObjects[5].CellValue(1, "agmt_cfm_flg")		== formObject.agmt_cfm_flg.value &&
			sheetObjects[5].CellValue(1, "agmt_cfm_dt")		== formObject.agmt_cfm_dt.value 
		) {
			modifyTop	= "N";
		} else {
			modifyTop	= "Y";
		}

		// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27)
		if ( modifyTop == 'Y' && !checkHdrSaveCreUpdUser() ) {
			return false
		}	

		
		for(var i = 0; i < sheetObjects[2].RowCount; i++ ) {
			
			if( sheetObjects[2].CellValue(i+3,"3ibflag") == "U" ||
				sheetObjects[2].CellValue(i+3,"3ibflag") == "D" ||
				sheetObjects[2].CellValue(i+3,"3ibflag") == "I" ) {
				sheet2TransCount = sheet2TransCount +1;
			}
  		}
		
		for(var i = 0; i < sheetObjects[4].RowCount; i++ ) {
			
			if( sheetObjects[4].CellValue(i+3,"5ibflag") == "U" ||
				sheetObjects[4].CellValue(i+3,"5ibflag") == "D" ||
				sheetObjects[4].CellValue(i+3,"5ibflag") == "I" ) {
  				sheet4TransCount	= sheet4TransCount + 1;
			}
		}
		
		if( tabObjects[0].selectedIndex == 1 ) {
			
			if (modifyTop == "N" && sheet2TransCount == 0 && sheetObjects[2].RowCount > 0 ) {
				ComShowCodeMessage('TES10115');    //Header 입력 데이터와 Agreement List 데이터의 변경사항이 없습니다. 다시 확인하세요.
				return false;
			}
			
			formObject.tml_agmt_tp_cd.value	= "T";
			formObject.sheet_prefix.value		= "3";
			formObject.f_cmd.value 			= MULTI03;
			formObject.select_tab.value	 	= tabObjects[0].selectedIndex;
			
			var SaveStr = sheetObject2.GetSaveString(true);
			var sXml = sheetObject2.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
			
			sheetObject2.LoadSaveXml(sXml,true);
			
			newRetrieve();
			
		} else if(tabObjects[0].selectedIndex == 3 ) {
			
			if(modifyTop == "N" && sheet4TransCount == 0 && sheetObjects[4].RowCount > 0 ) {
				ComShowCodeMessage('TES10115');
				return false;
			}
			
			formObject.tml_agmt_tp_cd.value	= "S";
			formObject.sheet_prefix.value	 	= "5";
			formObject.f_cmd.value				= MULTI03;
			formObject.select_tab.value		= tabObjects[0].selectedIndex;
			var SaveStr = sheetObject4.GetSaveString(true);			
			var sXml = sheetObject4.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
			sheetObject4.LoadSaveXml(sXml,true);
			
			newRetrieve();
			
		}else if(tabObjects[0].selectedIndex == 0 || tabObjects[0].selectedIndex == 2 ) {
			formObject.f_cmd.value		= MULTI03;
			formObject.select_tab.value	= tabObjects[0].selectedIndex;
			
//			DoAllSave 사용시 sheet save name 와 form의 객체 이름이 동일할때 문제 발생.
//			GetSaveXml 로 바꿈 2009/12/22			
//			sheetObject5.DoAllSave("ESD_TES_0034GS.do", tesFrmQryStr(formObject));			
			var SaveStr = sheetObject5.GetSaveString(true);			
			var sXml = sheetObject5.GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
			sheetObject5.LoadSaveXml(sXml,true);
			
		}
	}

	/**
	 * Agreement Process Save.<br>
	 * 
	 **/
	function newRetrieve(){
		var formObject = document.form;
		var sheetObject2  = sheetObjects[2];
		var sheetObject4  = sheetObjects[4];
		var sheetObject5  = sheetObjects[5];
		switch(tabObjects[0].selectedIndex) {
			case 0:
				formObject.tml_agmt_tp_cd.value	= "T";
				formObject.f_cmd.value			= SEARCH ;
				doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
				
				if(doActionIBSheet6SearchFlg != "NoData" ) {
					doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
				}
				
				formObject.tml_agmt_tp_cd.value	= "S";
				formObject.f_cmd.value			= SEARCH ;
				
				if(doActionIBSheet6SearchFlg != "NoData" ) {
					doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
				}
				
				break;
				
			case 1:
				formObject.tml_agmt_tp_cd.value	= "T";
				formObject.f_cmd.value			= SEARCH ;
				doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
				if(doActionIBSheet6SearchFlg != "NoData" ) {
					doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
				}
				break;
				
			case 2:
				formObject.tml_agmt_tp_cd.value	= "S";
				formObject.f_cmd.value			= SEARCH ;
				doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
				
				if(doActionIBSheet6SearchFlg != "NoData" ) {
					doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
				}
				formObject.tml_agmt_tp_cd.value	= "T";
				formObject.f_cmd.value			= SEARCH ;
				if(doActionIBSheet6SearchFlg != "NoData"){
					doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
				}
				break;
			case 3:
				formObject.tml_agmt_tp_cd.value	= "S";
				formObject.f_cmd.value			= SEARCH ;
				doActionIBSheet6(sheetObject5,formObject,IBSEARCH);
				
				if(doActionIBSheet6SearchFlg != "NoData"){
					doActionIBSheet5(sheetObject4,formObject,IBSEARCH);
				}
				break;
		}
	}

	/**
	 * Sheet Duplicate Row Check.<br>
	 * @param{amgtGB}	amgtGB	Agreement Gubun Value ( T:Terminal, S:Storage )
	 **/	
	function dupRowCheck(amgtGB){
		var dupRowCount	= 0;
		
		if(amgtGB == "T" ) {
			var dupRowInfo	= sheetObjects[2].ColValueDupRows("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31", false, true);
			if(dupRowInfo != ""){
				var dupRow		= dupRowInfo.split("|");
				var dupRowNum	= dupRow[1].split(",");
				
				if(dupRowNum.length > 0){
					
					for(var i = 0 ; i < dupRowNum.length ; i++){
						
						if(sheetObjects[2].CellValue(dupRowNum[i],"3auto_calc_flg") == "Y" ){
							sheetObjects[2].RowBackColor(dupRowNum[i])	= sheetObjects[2].RgbColor(255,0,0);
							dupRowCount++;
						}
					}
					
					if(dupRowCount > 0 ) {
						ComShowCodeMessage('TES10119', dupRowCount);
						return false;
						
					} else {
						return true;
					}
					
				} else {
					return true;
				}
			}
			
		} else if(amgtGB == "S" ) {
			var dupRowInfo = sheetObjects[4].ColValueDupRows("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41", false, true);
			
			if(dupRowInfo != ""){
				var dupRow		= dupRowInfo.split("|");
				var dupRowNum	= dupRow[1].split(",");
				
				if(dupRowNum.length > 0){
					
					for(var i = 0 ; i < dupRowNum.length ;i++ ) {
						sheetObjects[4].RowBackColor(dupRowNum[i])	= sheetObjects[4].RgbColor(255,0,0);
					}
					ComShowCodeMessage('TES10119', dupRowNum.length);
					return false;
					
				} else {
					return true;
				}
			}
		}
	}

	/**
	 * Sheet Row Delete.<br>
	 * 
	 **/	
	function rowDelete(){
		var sheet = "";
		var k = 0;
		var prefix = "";
		if(tabObjects[0].selectedIndex==1){
			sheet = sheetObjects[2];
			prefix  = "3"
		} else if(tabObjects[0].selectedIndex == 3) {
			sheet = sheetObjects[4];
			prefix  = "5"
		}
		for(var i=0;i<sheet.RowCount;i++){
			if(sheet.CellValue(i+3,prefix+"ibflag") == "I" && sheet.CellValue(i+3,0) == 1) {
				sheet.RowDelete(i+3, false);
				k++;
				i= i-k;
			}
		}
	}

	/**
	 * Sheet Row Delete.<br>
	 * 
	 **/
	function delete_Process(){
		var formObject = document.form;
		var rowCheckCount = 0;
		var sheet = "";
		
		if(tabObjects[0].selectedIndex == 1){
			sheet = sheetObjects[2];
			
		}else if(tabObjects[0].selectedIndex == 3){
			sheet = sheetObjects[4];
		}
		var sRow = sheet.FindCheckedRow(0);
		var arrRow = sRow.split("|");
		
		if(arrRow.length > 1){
			
			if(tabObjects[0].selectedIndex==1){
				formObject.tml_agmt_tp_cd.value	= "T";
				formObject.sheet_prefix.value 	= "3";
				formObject.f_cmd.value 			= REMOVE01;
				formObject.select_tab.value 	= tabObjects[0].selectedIndex;
				var SaveStr = sheetObjects[2].GetSaveString(false, true, 0);
				var sXml = sheetObjects[2].GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
				sheetObjects[2].LoadSaveXml(sXml,true);
				
			} else if(tabObjects[0].selectedIndex == 3 ) {
				formObject.tml_agmt_tp_cd.value	= "S";
				formObject.sheet_prefix.value 	= "5";
				formObject.f_cmd.value 			= REMOVE01;
				formObject.select_tab.value 	= tabObjects[0].selectedIndex;
				var SaveStr = sheetObjects[4].GetSaveString(false, true, 0);
				var sXml = sheetObjects[4].GetSaveXml("ESD_TES_0034GS.do", tesFrmQryStr(formObject)+'&'+ SaveStr);
				sheetObjects[4].LoadSaveXml(sXml,true);
			}
			formObject.inquiryFlg.value = "";
		}
		newRetrieve();
	}

	/**
	 * Agreement Rate List Regist.<br>
	 * 
	 **/
	function agreementReg(){
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		var sheetObject5 = sheetObjects[5];
		var sheetObject6 = sheetObjects[6];
		var sheetObject7 = sheetObjects[7];
		var formObject  = document.form;
		var noTerminalReadCount = 0;
		var noStorageReadCount = 0;

		for(i=1;i<(sheetObject2.RowCount+1);i++){
			if(sheetObject2.RowStatus(i+2)!="R"){
				noTerminalReadCount++;
			}
		}
		
		for(i=1;i<(sheetObject4.RowCount+1);i++){
			if(sheetObject4.RowStatus(i+2)!="R"){
				noStorageReadCount++;
			}
		}
		
		if(sheetObject5.CellValue(1, "tml_agmt_sts_cd") == "P"){	// 11
			var thrpFlg = "N";
			var volACCFlg = "N";
			if(sheetObject2.RowCount>0){
				if(tab2VerifyFlg){
				}else{
					ComShowCodeMessage('TES10098'); //Terminal Rate List Verify가 완료 되지 않았었습니다.
					return false;
				}
			}
			
			if(sheetObject4.RowCount>0){
				if(tab4VerifyFlg){
				}else{
					ComShowCodeMessage('TES10106');    //Stroage Rate List Verify가 완료 되지 않았었습니다.
					return false;
				}
			}
			
			for(i = 1; i < (sheetObject2.RowCount + 1); i++ ) {
				if(sheetObject2.CellValue(i+2,"3thrp_lgs_cost_cd") != "") {
					thrpFlg  = "Y";
				}
				if(sheetObject2.CellValue(i+2,"3fm_tr_vol_val") > 0 && sheetObject2.CellValue(i+2,"3to_tr_vol_val") < 9999999){
					volACCFlg = "Y";
				}
			}
			
			//[CHM-201539052]Accumulated Vol. Method VS Agreement Detail UOM다를 시 저장 안되는 로직 추가 (2015-12-01 CAHD) -> 반영 안함 주석처리
			if(noTerminalReadCount == 0 && noStorageReadCount == 0 && (sheetObject2.RowCount > 0 || sheetObject4.RowCount > 0)){
				if(thrpFlg == "Y" || volACCFlg == "Y"){
					formObject.f_cmd.value		= MULTI04;
					formObject.select_tab.value	= 1;
					var param	= sheetObjects[2].GetSaveString(true);
					var sXml	= sheetObjects[3].GetSearchXml("ESD_TES_0034Detail.do", param+'&'+tesFrmQryStr(formObject),"",true);
					sheetObjects[3].LoadSearchXml(sXml);
					var regProcessFlg = sheetObjects[3].EtcData("regFlg").split("|");
				}else{
					var regProcessFlg  = ",";
				}
				if(regProcessFlg[0] == "N" && regProcessFlg[1] == "N"){
					ComShowCodeMessage('TES10099');
					return false;
				}else if(regProcessFlg[0] == "N"){
					ComShowCodeMessage('TES10100');
					return false;
				}else if(regProcessFlg[1] == "N"){
					ComShowCodeMessage('TES10101');
					return false;
				}
//					else if(regProcessFlg[2] == "N" ){
//					ComShowCodeMessage('TES10138');	//Please check the UOM with Accumulated Volume Metohd(BOX/TEU)
//					return false;
//				}
				
				// AGMT Confirm Date Mandatory Check - 4347.07.22
				// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27)
//				if ( !dateFormatCheck(formObject.agmt_cfm_dt, 'TES10132', 'TES10131', true) ) {
				var cfmFlg	= false;
				if ( sheetObjects[5].CellValue(1, "agmt_cfm_flg") == "Y" && sheetObjects[5].CellValue(1, "agmt_cfm_dt") != "" ) {
					cfmFlg = true;
				}
				
				if ( sheetObjects[5].CellValue(1, "agmt_cfm_flg") == "" && sheetObjects[5].CellValue(1, "agmt_cfm_dt") == "" ) {
					ComShowCodeMessage('TES10131');
				}
				
				if ( !cfmFlg ) {
					return false;
				}
				
				window.showModalDialog("ESD_TES_9090.do?openerUIName=035", window, "dialogWidth:308px; dialogHeight:170px; help:no; status:no; resizable:yes;");
			}else if(noTerminalReadCount>0 || noStorageReadCount>0){
				if(noTerminalReadCount>0 && noStorageReadCount>0){
					ComShowCodeMessage('TES10125');
					return false;
				}else if(noTerminalReadCount>0){
					ComShowCodeMessage('TES10102');
					return false;
				}else	if(noStorageReadCount>0){
					ComShowCodeMessage('TES10109');
					return false;
				}
			}else if(sheetObject2.RowCount==0 && sheetObject4.RowCount==0){
				ComShowCodeMessage('TES10126');	// There is no Rate List Data.\n\n Please check again.
				return false;
			}
		}else if(sheetObject5.CellValue(1, "tml_agmt_sts_cd") == "C"){	// 11
			if(noTerminalReadCount>0 && noStorageReadCount>0){
				ComShowCodeMessage('TES10125');	// Terminal/Storage Rate List Data have not been saved/modified.\n\n Please complete save/modify Data.
				return false;
			}else if(noTerminalReadCount>0){
				ComShowCodeMessage('TES10102');	// Saving/Modification of Terminal Rate List Data has not been completed.\n\n Please complete saving/modification the Data.
				return false;
			}else	if(noStorageReadCount>0){
				ComShowCodeMessage('TES10109');	// Saving/modification of Storage Rate List Data has not been completed.\n\n Please complete saving/modification the Data.
				return false;
			}
			ComShowCodeMessage('TES10036');	// This is Confirmed Terminal Rate List.
		}
	}

	/***
	 * 날자 Type, Format 값 체크
	 * @param sDate
	 * @returns {Boolean}
	 */
	function dateFormatCheck(sDate, msgCode, nullMsgCode, nullFlg)
	{
		var sVal	= getArgValue(sDate);
		if (!ComIsNull(sVal) ) {
			if ( !ComIsDate(sDate)) {
				ComShowCodeMessage(msgCode);
				sDate.focus();
				return false;
			}
		
			if ( !checkEffFormat(sVal) ) {
				ComShowCodeMessage(msgCode);
				sDate.focus();
				return false;
			}
		} else {
			if ( nullFlg ) {
				ComShowCodeMessage(nullMsgCode);
			}
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param {String}		gb
	 * @param {int,String}	Row
	 * @param {String}		dateGB
	 * @return
	 */
	function currRateModRow(gb, Row, dateGB){

		var pointCount  = 0;
		if(dateGB == dfInteger){
			pointCount = 0;
		}else if(dateGB == dfFloat){
			pointCount = 2;
		}

		if(gb=="terminal"){
			var sheetObj = sheetObjects[2];
			var sheetNo = 3;

			sheetObj.InitCellProperty (Row, 32, dtData, daCenter, sheetNo + "d2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, 33, dtData, daCenter, sheetNo + "d4", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, 34, dtData, daCenter, sheetNo + "d5", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, 35, dtData, daCenter, sheetNo + "d7", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, 36, dtData, daCenter, sheetNo + "d8", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, 37, dtData, daCenter, sheetNo + "d9", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "dw", dtData, daCenter, sheetNo + "dw", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "dx", dtData, daCenter, sheetNo + "dx", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "r2", dtData, daCenter, sheetNo + "r2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "r4", dtData, daCenter, sheetNo + "r4", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "r5", dtData, daCenter, sheetNo + "r5", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "r7", dtData, daCenter, sheetNo + "r7", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "r8", dtData, daCenter, sheetNo + "r8", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "r9", dtData, daCenter, sheetNo + "r9", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "f2", dtData, daCenter, sheetNo + "f2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "f4", dtData, daCenter, sheetNo + "f4", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "f5", dtData, daCenter, sheetNo + "f5", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "o2", dtData, daCenter, sheetNo + "o2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "o4", dtData, daCenter, sheetNo + "o4", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "o5", dtData, daCenter, sheetNo + "o5", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "o7", dtData, daCenter, sheetNo + "o7", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "s2", dtData, daCenter, sheetNo + "s2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "s4", dtData, daCenter, sheetNo + "s4", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "t2", dtData, daCenter, sheetNo + "t2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "t4", dtData, daCenter, sheetNo + "t4", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "a2", dtData, daCenter, sheetNo + "a2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "a4", dtData, daCenter, sheetNo + "a4", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "a5", dtData, daCenter, sheetNo + "a5", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "p2", dtData, daCenter, sheetNo + "p2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "p4", dtData, daCenter, sheetNo + "p4", "", dateGB, pointCount, 18);	
			sheetObj.InitCellProperty (Row, sheetNo + "c2", dtData, daCenter, sheetNo + "c2", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "c4", dtData, daCenter, sheetNo + "c4", "", dateGB, pointCount, 18);	

			sheetObj.InitCellProperty (Row, sheetNo + "teu_rate", dtData, daCenter, sheetNo + "teu_rate", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "box_rate", dtData, daCenter, sheetNo + "box_rate", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "move_rate", dtData, daCenter, sheetNo + "move_rate", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, sheetNo + "gang_hour_rate", dtData, daCenter, sheetNo + "gang_hour_rate", "", dateGB, pointCount, 18);
			
		}else if(gb=="storage"){
			var sheetObj = sheetObjects[4];

			sheetObj.InitCellProperty (Row, "5d2_r", dtData, daCenter, "5d2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5d4_r", dtData, daCenter, "5d4_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5d5_r", dtData, daCenter, "5d5_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5d7_r", dtData, daCenter, "5d7_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5d8_r", dtData, daCenter, "5d8_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5d9_r", dtData, daCenter, "5d9_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5dw_r", dtData, daCenter, "5dw_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5dx_r", dtData, daCenter, "5dx_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5r2_r", dtData, daCenter, "5r2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5r4_r", dtData, daCenter, "5r4_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5r5_r", dtData, daCenter, "5r5_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5r7_r", dtData, daCenter, "5r7_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5r8_r", dtData, daCenter, "5r8_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5r9_r", dtData, daCenter, "5r9_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5f2_r", dtData, daCenter, "5f2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5f4_r", dtData, daCenter, "5f4_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5f5_r", dtData, daCenter, "5f5_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5o2_r", dtData, daCenter, "5o2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5o4_r", dtData, daCenter, "5o4_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5o5_r", dtData, daCenter, "5o5_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5o7_r", dtData, daCenter, "5o7_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5s2_r", dtData, daCenter, "5s2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5s4_r", dtData, daCenter, "5s4_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5t2_r", dtData, daCenter, "5t2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5t4_r", dtData, daCenter, "5t4_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5a2_r", dtData, daCenter, "5a2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5a4_r", dtData, daCenter, "5a4_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5a5_r", dtData, daCenter, "5a5_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5p2_r", dtData, daCenter, "5p2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5p4_r", dtData, daCenter, "5p4_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5c2_r", dtData, daCenter, "5c2_r", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5c4_r", dtData, daCenter, "5c4_r", "", dateGB, pointCount, 18);

			sheetObj.InitCellProperty (Row, "5teu_rate", dtData, daCenter, "5teu_rate", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5box_rate", dtData, daCenter, "5box_rate", "", dateGB, pointCount, 18);
			sheetObj.InitCellProperty (Row, "5move_rate", dtData, daCenter, "5move_rate", "", dateGB, pointCount, 18);		
		}
	}
	
	/**
	 * 
	 * @param {ibsheet}		sheetObj
	 * @param {int,String}	row
	 * @param {int,String}	col
	 * @param {String}		Value
	 * @return
	 */
    function t2sheet1_OnChange(sheetObj, row, col, Value){
		var total_rate = "";
		var colName = sheetObj.ColSaveName(col);
		
		for(var l=0; l<arrCntrTpSz.length; l++){
			total_rate  = total_rate+"#"+sheetObjects[2].CellValue(row, "3"+arrCntrTpSz[l]);
		}
		//if (col >31 || col < 64){
			sheetObj.CellValue2(row,"3ts_rt") = total_rate;
		//}
		if(colName == "3to_tr_vol_val"){
			sheetObj.CellValue(row,"3to_tr_vol_val") = sheetObj.CellValue(row,"3to_tr_vol_val").toUpperCase();
			if(sheetObj.CellValue(row,"3to_tr_vol_val")!="MAX"){
				if(!ComIsNumber(sheetObj.CellValue(row,"3to_tr_vol_val"))){
					//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
					sheetObj.CellValue2(row,"3to_tr_vol_val")="";
				}
			}
		}
		
		if(colName == "3curr_cd"){
			if(sheetObj.CellValue(row,"3curr_cd")== "KRW" || sheetObj.CellValue(row,"3curr_cd")=="JPY"){
				currRateModRow('terminal',row, dfInteger);
			}else{
				currRateModRow('terminal',row, dfFloat);
			}
		}		
	
		if(colName == "3lgs_cost_cd"){
			if( sheetObj.CellValue(row,"3lgs_cost_cd")=="TMNDRF" || sheetObj.CellValue(row,"3lgs_cost_cd")=="TMNDRM" ) {
				sheetObj.CellComboItem( row , "3tml_trns_mod_cd", "Same|Rail", "Same|R");
			} else {
				sheetObj.CellComboItem( row , "3tml_trns_mod_cd", "Same|Truck|Rail|Barge|Feeder|Mother|Other", "S|T|R|B|F|V|O");		
			}
		}
		
		//[CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 2)선택된 UOM이외에 다른 칸은 Grey-Out되어서 blokcing 되도록 설정(CAH D 2015.12.08)
		if (colName == "3tml_agmt_vol_ut_cd") {			
			sheet_Rate_Set("T", sheetObj, row, sheetObj.CellValue(row, "3tml_agmt_vol_ut_cd"), "detail");
		}
		
		//[CHM-201640244]DG(None)숨김처리 이후 STorage Rate 저장시 Y 체크 안되는 현상(CAH D 2016.02.18)
		dg_Class_Set(sheetObj, "3", "", colName, row);
    }

	/**
	 * 
	 * @param {ibsheet}		sheetObj
	 * @param {int,String}	row
	 * @param {int,String}	col
	 * @param {String}		Value
	 * @return
	 */
    function t4sheet1_OnChange(sheetObj, row,col,Value){
        var total_rate = "";
        var daysTotalRate = 0;
        var rateTotalRate = 0;
        
        // Agreement Rate List 등록 수정시에 Days 와 Rate 중 한쪽만 입력해야 한다.
        // Sheet FTDay(ComboBox : '':Rate, 'F':Days ) Cell 에서 설정된 값을 가지고 Check.
        if(sheetObj.CellValue(row, "5ft_dys")=="F"){
            for(var l=0; l<arrCntrTpSz.length; l++){
                total_rate  = total_rate+"#"+sheetObj.CellValue(row, "5"+arrCntrTpSz[l]+"_fd");
                daysTotalRate = parseInt(sheetObj.CellValue(row, "5"+arrCntrTpSz[l]+"_fd"))+daysTotalRate;
            }

            //if (col >41 || col < 73){
                sheetObj.CellValue2(row,"5ts_rt") = total_rate;
            //}
        }

        if(sheetObj.CellValue(row, "5ft_dys")=="" || sheetObj.CellValue(row, "5ft_dys")==undefined){
            for(var l=0; l<arrCntrTpSz.length; l++){
                total_rate  = total_rate+"#"+sheetObj.CellValue(row, "5"+arrCntrTpSz[l]+"_r");
                rateTotalRate = parseInt(sheetObj.CellValue(row, "5"+arrCntrTpSz[l]+"_r"))+rateTotalRate;
            }

            //if (col >72 || col < 104){
                sheetObj.CellValue2(row,"5ts_rt") = total_rate;
            //}
        }

        if(sheetObj.CellValue(row,"5curr_cd")=="KRW" || sheetObj.CellValue(row,"5curr_cd")=="JPY" ){
            currRateModRow('storage',row, dfInteger);
        }else{
            currRateModRow('storage',row, dfFloat);
        }

        if(col==39){
            sheetObj.CellValue(row,"5to_tr_dys") = sheetObj.CellValue(row,"5to_tr_dys").toUpperCase();
            if(sheetObj.CellValue(row,"5to_tr_dys")!="MAX"){
                if(!ComIsNumber(sheetObj.CellValue(row,"5to_tr_dys"))){
                    //ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
                    sheetObj.CellValue2(row,"5to_tr_dys")="";
                }
            }
        }


        /**
         * commance time validation 기능 추가 -- 2007.10.09
         */
        if (sheetObj.ColSaveName(col) == "5cmnc_hrmnt"){
            var time = sheetObj.EditValue;
            var hour  	= time.substring(0,2);
            var minute 	= time.substring(2,4);

            if(parseInt(hour,10) < 10){
                hour = '0' + parseInt(hour,10);
            }
            if(parseInt(minute) == 0 || minute == '  '){
                minute = '00';
            }else if(parseInt(minute) < 10){
                minute = '0' + parseInt(minute);
            }

            if(parseInt( hour,10 ) <= 23  && parseInt( minute ) <= 59 ){
                sheetObj.CellValue2(row,'5cmnc_hrmnt') = hour + ':' + minute;
                return true;
            }else if(parseInt( hour,10 ) == 24  && parseInt( minute ) == 00){
                sheetObj.CellValue2(row,'5cmnc_hrmnt') = hour  + ':' +  minute;
                return true;
            }else{
            	ComShowCodeMessage('TES50102');		// ComShowMessage('Please insert correct time');
                sheetObj.CellValue2(row,'5cmnc_hrmnt') = '';
                return false;
            }
        }
        
        //[CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 2)선택된 UOM이외에 다른 칸은 Grey-Out되어서 blokcing 되도록 설정(CAH D 2015.12.08)
        // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
        sheet_Rate_Set("S", sheetObj, row, sheetObj.CellValue(row, "5tml_agmt_vol_ut_cd"), "detail");
        
        //[CHM-201640244]DG(None)숨김처리 이후 STorage Rate 저장시 Y 체크 안되는 현상(CAH D 2016.02.18)
        dg_Class_Set(sheetObj, "5", "_fd", sheetObj.ColSaveName(col), row);	
        dg_Class_Set(sheetObj, "5", "_r", sheetObj.ColSaveName(col), row);
    }
    
    /**
     * [CHM-201640244]DG(None)숨김처리 이후 STorage Rate 저장시 Y 체크 안되는 현상 해결을 위한 function(CAH D 2016.02.18)
     * dg 값이 변경이 되면 hidden으로 저장되어 있는 none_dg 값을 ""으로 변경한다.
     */  
    function dg_Class_Set(sheetObj, sheetNo, gb, colName, row){   
        if (colName == sheetNo + "same_dg_none" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "same_dg_none" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "same_dg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "same_dg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "sep_dg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "sep_dg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "sep_dg_none" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "sep_dg_none" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "dcgo_n1st_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n1st_clss_flg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "dcgo_n2nd_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n2nd_clss_flg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "dcgo_n3rd_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n3rd_clss_flg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "dcgo_n4st_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n4st_clss_flg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "dcgo_n5st_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n5st_clss_flg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}if (colName == sheetNo + "dcgo_n6st_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n6st_clss_flg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "dcgo_n7st_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n7st_clss_flg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "dcgo_n8st_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n8st_clss_flg" + gb) == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}
    	if (colName == sheetNo + "dcgo_n9st_clss_flg" + gb){
    		if(sheetObj.CellValue(row, sheetNo + "dcgo_n9st_clss_flg + gb") == "Y" && sheetObj.CellValue(row, sheetNo + "dg_none" + gb) == "Y"){
    			sheetObj.CellValue(row, sheetNo + "dg_none" + gb) = "";
    		}
    	}   
    }

    /*******************************************************************
     * 2. Agreement Rate List Input
     * 
     ******************************************************************/
    
	/**
	 * Terminal Rate Input To Terminal Rate List Data Insert 
	 */
	function terminalRateInputList(){	
	
		var formObject = document.form;	
		var	sheetNo	= "3";

		var k = sheetObjects[2].RowCount+1;  
		var eq_loop_count = 0; 
		
		var sheet1_parameters = new Array();
		sheet1_parameters = sheetObjects[0].FindCheckedRow(0).split("|"); 
		
		var sheet2_parameters = new Array();
		sheet2_parameters = sheetObjects[1].FindCheckedRow(0).split("|");		
			
		sheetObjects[2].DataInsert(-1);
						
		sheetObjects[2].CellValue(k+2, 0) = "";
		sheetObjects[2].CellValue(k+2, 1) = ""; 										
		sheetObjects[2].CellValue(k+2, sheetNo +"lgs_cost_cd") = comboObjects[0].Code;						
		sheetObjects[2].CellValue(k+2, sheetNo +"auto_calc_flg") = getElementValue(formObject, 'radio', 'auto_calc_flg'); //auto_calc_flg		
		sheetObjects[2].CellValue(k+2, sheetNo +"tml_agmt_vol_ut_cd") = formObject.tml_agmt_vol_ut_cd[1].value;             
		sheetObjects[2].CellValue(k+2, sheetNo +"curr_cd") = comboObjects[1].Code;	
		
		if(formObject.lgs_cost_cd_t.value.substring(0,2) == "TP"){
			sheetObjects[2].CellValue(k+2, sheetNo +"thrp_lgs_cost_cd")	= "";
		} else {
			sheetObjects[2].CellValue(k+2, sheetNo +"thrp_lgs_cost_cd")	= sheetObjects[6].CellValue(1, 0);                //tt_cd												
		}
		
		sheetObjects[2].CellValue(k+2, sheetNo +"io_bnd_cd")	= formObject.io_bnd_cd[1].value;
		sheetObjects[2].CellValue(k+2, sheetNo +"ioc_cd")	= formObject.ioc_cd.value;
		
		sheetObjects[2].CellValue(k+2, sheetNo +"tml_trns_mod_cd")	= formObject.tml_trns_mod_cd[0].value+formObject.tml_trns_mod_cd[1].value;
		
		if(formObject.wkdy_flg.checked == true){
			sheetObjects[2].CellValue(k+2, sheetNo +"wkdy_flg")	= formObject.wkdy_flg.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo +"wkdy_flg")	= "";
		}
		
		if(formObject.sat_flg.checked == true){
			sheetObjects[2].CellValue(k+2, sheetNo +"sat_flg")	= formObject.sat_flg.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo +"sat_flg")	= "";
		}
		
		if(formObject.sun_flg.checked==true){
			sheetObjects[2].CellValue(k+2, sheetNo +"sun_flg")=formObject.sun_flg.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo +"sun_flg")="";
		}
		
		if(formObject.hol_flg.checked==true){
			sheetObjects[2].CellValue(k+2, sheetNo +"hol_flg")=formObject.hol_flg.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo +"hol_flg")="";
		}																					
		
		if(formObject.lane_cd.value=="sam"){
				sheetObjects[2].CellValue(k+2, sheetNo +"lane_cd")	= "Same";
		}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"lane_cd")	= formObject.lane_cd.value;
		}
		
		if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd') == "N"){
			sheetObjects[2].CellValue(k+2, sheetNo +"dg_none")="Y"; 
		}else if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd') == "A"){
			if(getElementValue(formObject, 'radio', 'dcgo_same')=="Y"){
				sheetObjects[2].CellValue(k+2, sheetNo +"same_dg")="Y";								
			}else if(getElementValue(formObject, 'radio', 'dcgo_same')=="N"){
				sheetObjects[2].CellValue(k+2, sheetNo +"same_dg_none")="Y"; 
			}
		}else if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd')=="S"){ 
			if(formObject.dcgo_none_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"sep_dg_none")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"sep_dg_none")="";
			}
			
			if(formObject.dcgo_n1st_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n1st_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n1st_clss_flg")="";
			}	
			
			if(formObject.dcgo_n2nd_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n2nd_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n2nd_clss_flg")="";
			}
			
			if(formObject.dcgo_n3rd_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n3rd_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n3rd_clss_flg")="";
			}
			
			if(formObject.dcgo_n4th_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n4th_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n4th_clss_flg")="";
			}
			
			if(formObject.dcgo_n5th_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n5th_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n5th_clss_flg")="";
			}
			
			if(formObject.dcgo_n6th_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n6th_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n6th_clss_flg")="";
			}
			
			if(formObject.dcgo_n7th_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n7th_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n7th_clss_flg")="";
			}
			
			if(formObject.dcgo_n8th_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n8th_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n8th_clss_flg")="";
			}
			
			if(formObject.dcgo_n9th_clss_flg.checked==true){
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n9th_clss_flg")="Y"; 
			}else{
				sheetObjects[2].CellValue(k+2, sheetNo +"dcgo_n9th_clss_flg")="";
			}
		}							
		
		if(sheetObjects[0].CheckedRows(0) == "0"){
			sheetObjects[2].CellValue(k+2, sheetNo +"fm_tr_vol_val")="";
			sheetObjects[2].CellValue(k+2, sheetNo +"to_tr_vol_val")="";	
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo +"fm_tr_vol_val")=sheetObjects[0].CellValue(sheet1_parameters[0], 2);
			sheetObjects[2].CellValue(k+2, sheetNo +"to_tr_vol_val")=sheetObjects[0].CellValue(sheet1_parameters[0], 3);							
		}										
	
		if(sheetObjects[1].CheckedRows(0) == "0"){					
			sheetObjects[2].CellValue(k+2, sheetNo +"tml_ovt_shft_cd")="";
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo +"tml_ovt_shft_cd")=sheetObjects[1].CellValue(sheet2_parameters[0], 2);						
		}
		
		sheetObjects[2].CellValue(k+2, sheetNo +"thc_tp_cd")=getElementValue(formObject, 'radio', 'thc_tp_cd');
		
		if(formObject.tml_agmt_vol_ut_cd[1].value=="C"){
			if(formObject.cntr_ts[0].checked==true){							
				for(var l=0; l<arrCntrTpSz.length; l++)
				{ 							
					sheetObjects[2].CellValue(k+2, l)=formObject.agmt_rate.value;	
				}										
			}
			else if(formObject.cntr_ts[1].checked==true){
				
				if(comboObjects[3].Code == "All" && comboObjects[4].Code == "All"){
					for(var l=0; l<arrCntrTpSz.length; l++){
						sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;		
					}				
				} 		
				
				if(comboObjects[3].Code == "All" && (comboObjects[4].Code!="" || comboObjects[4].Code!=undefined)){		
					var typeName = comboObjects[3].Code;
					var sizeName = comboObjects[4].Code;						
	
					var cntr_type_list = new Array();
					cntr_type_list[0] = "D";
					cntr_type_list[1] = "R"; 
					cntr_type_list[2] = "F"; 
					cntr_type_list[3] = "O";
					cntr_type_list[4] = "S";
					cntr_type_list[5] = "T";
					cntr_type_list[6] = "A";
					cntr_type_list[7] = "P";  
					cntr_type_list[8] = "C";  
					
					for(var l=0; l<9 ; l++)
					{ 
						sheetObjects[2].CellValue(k+2, sheetNo +cntr_type_list[l].toLowerCase()+sizeName)=formObject.agmt_rate.value;										
					}					
				}
				
				if((comboObjects[3].Code!="" || comboObjects[3].Code!=undefined) && comboObjects[4].Code == "All"){				 
					var typeName = comboObjects[3].Code;
					var sizeName = comboObjects[4].Code;						
				
					var cntr_size_list = new Array();
					cntr_size_list[0] = "2";
					cntr_size_list[1] = "4"; 
					cntr_size_list[2] = "5"; 
					cntr_size_list[3] = "7";
					cntr_size_list[4] = "8";
					cntr_size_list[5] = "9";
					cntr_size_list[6] = "w";  				
					cntr_size_list[7] = "x";  
																				
					for(var l=0; l<8 ; l++)
					{		 							
						sheetObjects[2].CellValue(k+2, sheetNo +typeName.toLowerCase()+cntr_size_list[l])=formObject.agmt_rate.value;											
					}					
				}						
	
				if((formObject.cntr_type_t.value!="" && formObject.cntr_type_t.value!=undefined) && (formObject.cntr_size_t.value=="" || formObject.cntr_size_t.value==undefined)){	
					var typeName = formObject.cntr_type_t.value;						
					switch(typeName){										
						case "D":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "d"){
									sheetObjects[2].CellValue(k+2, sheetNo +arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo +arrCntrTpSz[l])=0;
								}
							}																	 									
							break;										
						case "R":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "r"){
									sheetObjects[2].CellValue(k+2, sheetNo +arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo +arrCntrTpSz[l])=0;
								}
							}										
							break;									
						case "F":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "f"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}																
							break;								
						case "O":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "o"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}																										
							break;
						case "S":		
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "s"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}											
							break;										
						case "T":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "t"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}									
							break; 								
						case "A":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "a"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}									
							break; 								
						case "P":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "p"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}									
							break;
						case "C":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 
								if(arrCntrTpSz[l].substring(1,1) == "c"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}									
							break;	
					}							
				}else if((formObject.cntr_type_t.value=="" || formObject.cntr_type_t.value==undefined) && (formObject.cntr_size_t.value!="" && formObject.cntr_size_t.value!=undefined)){
					switch(formObject.cntr_size_t.value){										
						case "2":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								if(arrCntrTpSz[l].substring(2,1) == "2"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}
							break;			
						case "4":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								if(arrCntrTpSz[l].substring(2,1) == "4"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}
							break;		
						case "5":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								if(arrCntrTpSz[l].substring(2,1) == "5"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}
							break;						
						case "7": 
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								if(arrCntrTpSz[l].substring(2,1) == "7"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}
							break;	
						case "8": 
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								if(arrCntrTpSz[l].substring(2,1) == "8"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}
							break;	
						case "9":
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								if(arrCntrTpSz[l].substring(2,1) == "9"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}
							break;	
						case "W": 
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								if(arrCntrTpSz[l].substring(2,1) == "w"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}								
							break;	
						case "X": 
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								if(arrCntrTpSz[l].substring(2,1) == "x"){
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=formObject.agmt_rate.value;
								}else{ 
									sheetObjects[2].CellValue(k+2, sheetNo + arrCntrTpSz[l])=0;
								}
							}							
							break;	
					}							
				}else if((formObject.cntr_type_t.value!="" && formObject.cntr_type_t.value!=undefined) && (formObject.cntr_size_t.value!="" && formObject.cntr_size_t.value!=undefined)){
					var typeName = comboObjects[3].Code;
					var sizeName = comboObjects[4].Code;	
										
					cntrTypeSize = typeName+sizeName;		
														
					sheetObjects[2].CellValue(k+2, sheetNo + cntrTypeSize.toLowerCase())=formObject.agmt_rate.value;
				}									
			}
		} 
		
		if(formObject.tml_agmt_vol_ut_cd[1].value=="T"){
			sheetObjects[2].CellValue(k+2, sheetNo + "teu_rate")=formObject.agmt_rate.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo + "teu_rate")=""; 
		}
		if(formObject.tml_agmt_vol_ut_cd[1].value=="B"){
			sheetObjects[2].CellValue(k+2, sheetNo + "box_rate")=formObject.agmt_rate.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo + "box_rate")=""; 
		}
		if(formObject.tml_agmt_vol_ut_cd[1].value=="M"){
			sheetObjects[2].CellValue(k+2, sheetNo + "move_rate")=formObject.agmt_rate.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo + "move_rate")=""; 
		} 
		if(formObject.tml_agmt_vol_ut_cd[1].value=="G"){
			sheetObjects[2].CellValue(k+2, sheetNo + "gang_hour_rate")=formObject.agmt_rate.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo + "gang_hour_rate")=""; 
		} 	
		if(formObject.tml_agmt_vol_ut_cd[1].value=="W"){
			sheetObjects[2].CellValue(k+2, sheetNo + "ton_rate")=formObject.agmt_rate.value; 
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo + "ton_rate")=""; 
		}  		
							
		sheetObjects[2].CellValue(k+2, sheetNo + "verify_result")="";
		sheetObjects[2].CellValue(k+2, sheetNo + "remark")="";
		sheetObjects[2].CellValue(k+2, sheetNo + "tml_dy_aply_tp_cd")=getElementValue(formObject, 'radio', 'tml_dy_aply_tp_cd'); 
		sheetObjects[2].CellValue(k+2, sheetNo + "dcgo_aply_tp_cd")=getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd');
		
		if(sheetObjects[0].CheckedRows(0) == "1" || sheetObjects[0].CellValue(sheet1_parameters[1], 2) == "1" || sheetObjects[0].CellValue(sheet1_parameters[1], 3) == "MAX"	){
			sheetObjects[2].CellValue(k+2, sheetNo+ "agmt_dtl_rmk")="N";
		}else{
			sheetObjects[2].CellValue(k+2, sheetNo+ "agmt_dtl_rmk")="S";	
		}
		
		sheetObjects[2].CellValue(k+2, sheetNo +"vrfyflg")=document.form.vfsArray.value;    
		
		eq_flg = sheetObjects[2].ColValueDup("1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65");
		
		comp_flg = sheetObjects[2].ColValueDup("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31"); //UOM 자리 이동 4->31, 30번까지만(OT Shift 까지만 비교했던 로직)
		
		if(eq_flg == -1 && comp_flg == -1){ 
			sheetObjects[2].RowStatus(k+2) = "I";
			k++;					
			//break;
		}else if(eq_flg == -1 && comp_flg > -1){
			terminalRateInputListComparison(k+2);  // Rate 조건 관련 비교
			
		}else{
			sheetObjects[2].RowDelete(k+2, false);						
			ComShowCodeMessage('TES10117');		// There is same condition rate.\n\n Please check the Agreement
	
		}
	}	

	/**
	 * Agreement Storage Rate Input > Rate List
	 * @return
	 */
	function storageRateInputList(){
		
		var formObject = document.form;
		var	sheetNo	= "5";
		
		var k = sheetObjects[4].RowCount+1;   
		var loop1 = 	sheetObjects[3].CheckedRows(0);
		if(loop1==0){
			loop1  = 1;
		}	
		
		if (formObject.tml_sto_agmt_tp_cd.value == "FP"){
			loop1  = 1;
		}
		
		var sheet1_parameters = new Array();
		sheet1_parameters = sheetObjects[3].FindCheckedRow(0).split("|"); 	
			
			
		if (formObject.tml_sto_agmt_tp_cd.value == "FD"){
		//sheetObjects[2].RemoveAll();
			for (var i=1; i<= loop1; i++){
			
					sheetObjects[4].DataInsert(-1);
											
					sheetObjects[4].CellValue(k+2, 0)="";
					sheetObjects[4].CellValue(k+2, 1)="";
					sheetObjects[4].CellValue(k+2, sheetNo+ "lgs_cost_cd")=formObject.lgs_cost_cd_s.Code; 						           
					sheetObjects[4].CellValue(k+2, sheetNo+ "curr_cd")=formObject.curr_cd_s.value;
					sheetObjects[4].CellValue(k+2, sheetNo+ "tml_sto_agmt_tp_cd")=formObject.tml_sto_agmt_tp_cd.value;
					sheetObjects[4].CellValue(k+2, sheetNo+ "cmnc_hrmnt")=formObject.cmnc_hrmnt.value;						
					if(formObject.storage_gb[0].checked==true){  
						sheetObjects[4].CellValue(k+2, sheetNo+ "ft_dys")="F";
						sheetObjects[4].CellValue(k+2, sheetNo+ "io_bnd_cd")=formObject.io_bnd_cd[2].value;							
					}else if(formObject.storage_gb[1].checked==true){
						sheetObjects[4].CellValue(k+2, sheetNo+ "ft_dys")="";
						sheetObjects[4].CellValue(k+2, sheetNo+ "io_bnd_cd")=formObject.io_bnd_cd[3].value; 
					}	

					if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD')=="N"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "dg_none_fd")="Y"; 
					}else if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD')=="A"){
						if(getElementValue(formObject, 'radio', 'dcgo_same_FD')=="Y"){
							sheetObjects[4].CellValue(k+2, sheetNo+ "same_dg_fd")="Y";								
						}else if(getElementValue(formObject, 'radio', 'dcgo_same_FD')=="N"){
							sheetObjects[4].CellValue(k+2, sheetNo+ "same_dg_none_fd")="Y"; 
						}
					}else if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_FD')=="S"){ 
						if(formObject.dcgo_none_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "sep_dg_none_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "sep_dg_none_fd")="";
						}
						if(formObject.dcgo_n1st_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n1st_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n1st_clss_flg_fd")="";
						}	
						if(formObject.dcgo_n2nd_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n2nd_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n2nd_clss_flg_fd")="";
						}	
						if(formObject.dcgo_n3rd_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n3rd_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n3rd_clss_flg_fd")="";
						}	
						if(formObject.dcgo_n4th_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n4th_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n4th_clss_flg_fd")="";
						}	
						if(formObject.dcgo_n5th_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n5th_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n5th_clss_flg_fd")="";
						}	
						if(formObject.dcgo_n6th_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n6th_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n6th_clss_flg_fd")="";
						}	
						if(formObject.dcgo_n7th_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n7th_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n7th_clss_flg_fd")="";
						}	
						if(formObject.dcgo_n8th_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n8th_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n8th_clss_flg_fd")="";
						}
						if(formObject.dcgo_n9th_clss_flg_FD.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n9th_clss_flg_fd")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n9th_clss_flg_fd")="";
						}
					}
					
					if(formObject.sat_flg_FD.checked==true){
						sheetObjects[4].CellValue(k+2, sheetNo+ "sat_flg_fd")=formObject.sat_flg_FD.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "sat_flg_fd")="";
					}
					if(formObject.sun_flg_FD.checked==true){
						sheetObjects[4].CellValue(k+2, sheetNo+ "sun_flg_fd")=formObject.sun_flg_FD.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "sun_flg_fd")="";
					}
					if(formObject.hol_flg_FD.checked==true){
						sheetObjects[4].CellValue(k+2, sheetNo+ "hol_flg_fd")=formObject.hol_flg_FD.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "hol_flg_fd")="";
					}		
											
					if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R')=="N"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "dg_none_r")="Y"; 
					}else if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R')=="A"){
						if(getElementValue(formObject, 'radio', 'dcgo_same_R')=="Y"){
							sheetObjects[4].CellValue(k+2, sheetNo+ "same_dg_r")="Y";								
						}else if(getElementValue(formObject, 'radio', 'dcgo_same_R')=="N"){
							sheetObjects[4].CellValue(k+2, sheetNo+ "same_dg_none_r")="Y"; 
						}
					}else if(getElementValue(formObject, 'radio', 'dcgo_aply_tp_cd_R')=="S"){ 
						if(formObject.dcgo_none_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "sep_dg_none_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "sep_dg_none_r")="";
						}
						if(formObject.dcgo_n1st_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n1st_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n1st_clss_flg_r")="";
						}	
						if(formObject.dcgo_n2nd_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n2nd_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n2nd_clss_flg_r")="";
						}	
						if(formObject.dcgo_n3rd_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n3rd_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n3rd_clss_flg_r")="";
						}	
						if(formObject.dcgo_n4th_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n4th_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n4th_clss_flg_r")="";
						}	
						if(formObject.dcgo_n5th_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n5th_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n5th_clss_flg_r")="";
						}	
						if(formObject.dcgo_n6th_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n6th_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n6th_clss_flg_r")="";
						}	
						if(formObject.dcgo_n7th_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n7th_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n7th_clss_flg_r")="";
						}	
						if(formObject.dcgo_n8th_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n8th_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n8th_clss_flg_r")="";
						}
						if(formObject.dcgo_n9th_clss_flg_R.checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n9th_clss_flg_r")="Y"; 
						}else{
							sheetObjects[4].CellValue(k+2, sheetNo+ "dcgo_n9th_clss_flg_r")="";
						}
					}														
						
					if(formObject.storage_gb[0].checked==true){
						sheetObjects[4].CellValue(k+2, sheetNo+ "fm_tr_dys")="";
						sheetObjects[4].CellValue(k+2, sheetNo+ "to_tr_dys")="";	
					}else if(formObject.storage_gb[1].checked==true){
						sheetObjects[4].CellValue(k+2, sheetNo+ "fm_tr_dys")=sheetObjects[3].CellValue(sheet1_parameters[i-1], 2);
						sheetObjects[4].CellValue(k+2, sheetNo+ "to_tr_dys")=sheetObjects[3].CellValue(sheet1_parameters[i-1], 3);							

					}									
										
					sheetObjects[4].CellValue(k+2, sheetNo+ "fp_teu_qty")=formObject.fp_teu_qty.value; 	
					
					//[CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 1) UOM Row를 CNTR TYPE SIZE바로 앞쪽으로 이동하여 가시성 확보(CAH D 2015.12.08)
					sheetObjects[4].CellValue(k+2, sheetNo+ "tml_agmt_vol_ut_cd")=formObject.tml_agmt_vol_ut_cd[2].value;  
					
					if(formObject.storage_gb[0].checked==true){	
						
						if(formObject.tml_agmt_vol_ut_cd[2].value=="U" || formObject.tml_agmt_vol_ut_cd[2].value=="M"){
							for(var l=0; l<arrCntrTpSz.length; l++)
							{
								sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
							}
						}			
						
						if(formObject.cntr_ts[2].checked==true){							
							for(var l=0; l<arrCntrTpSz.length; l++)
							{				
								sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;										
							}										
						}
						else if(formObject.cntr_ts[3].checked==true){
							
							if(comboObjects[7].Code == "All" && comboObjects[8].Code == "All"){
								for(var l=0; l<arrCntrTpSz.length; l++)
								{ 							
									sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;					
								}					
							} 		
							
							if(comboObjects[7].Code == "All" && (comboObjects[8].Code!="" || comboObjects[8].Code!=undefined)){		
								var typeName = comboObjects[7].Code;
								var sizeName = comboObjects[8].Code;	
								
								var cntr_type_list = new Array();
								cntr_type_list[0] = "D";
								cntr_type_list[1] = "R"; 
								cntr_type_list[2] = "F"; 
								cntr_type_list[3] = "O";
								cntr_type_list[4] = "S";
								cntr_type_list[5] = "T";
								cntr_type_list[6] = "A";
								cntr_type_list[7] = "P";  	
								cntr_type_list[8] = "C";
								
								for(var l=0; l<9 ; l++)
								{ 
									sheetObjects[4].CellValue(k+2, "5"+cntr_type_list[l].toLowerCase()+sizeName+"_fd")=formObject.ft_dys.value;											
								}					
							}
							
							if((comboObjects[7].Code!="" || comboObjects[8].Code!=undefined) && comboObjects[8].Code == "All"){				 
								var typeName = comboObjects[7].Code;
								var sizeName = comboObjects[8].Code;
								
								var cntr_size_list = new Array();
								cntr_size_list[0] = "2";
								cntr_size_list[1] = "4"; 
								cntr_size_list[2] = "5"; 
								cntr_size_list[3] = "6";
								cntr_size_list[4] = "7";
								cntr_size_list[5] = "8";
								cntr_size_list[6] = "9";
								cntr_size_list[7] = "w";  				
								cntr_size_list[8] = "x";  											
																							
								for(var l=0; l<9 ; l++)
								{		 							
									sheetObjects[4].CellValue(k+2, "5"+typeName.toLowerCase()+cntr_size_list[l]+"_fd")=formObject.ft_dys.value;										
								}					
							}
												
							if((formObject.cntr_type_s.value!="" && formObject.cntr_type_s.value!=undefined) && (formObject.cntr_size_s.value=="" || formObject.cntr_size_s.value==undefined)){	
								var typeName = formObject.cntr_type_s.value;						
								switch(typeName){										
									case "D":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "d"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}																	 									
										break;										
									case "R":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "r"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}										
										break;									
									case "F":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "f"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}															
										break;								
									case "O":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "o"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}																										
										break;
									case "S":		
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "s"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}											
										break;										
									case "T":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "t"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}									
										break; 								
									case "A":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "a"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}									
										break; 								
									case "P":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "p"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}									
										break;	
									case "C":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpsz.substring(1,1) == "c"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}									
										break;	
								}							
							}else if((formObject.cntr_type_s.value=="" || formObject.cntr_type_s.value==undefined) && (formObject.cntr_size_s.value!="" && formObject.cntr_size_s.value!=undefined)){
								switch(formObject.cntr_size_s.value){										
									case "2":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											if(arrCntrTpsz.substring(2,1) == "2"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}
										break;			
									case "4":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											if(arrCntrTpsz.substring(2,1) == "4"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}
										break;		
									case "5":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											if(arrCntrTpsz.substring(2,1) == "5"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}
										break;						
									case "7": 
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											if(arrCntrTpsz.substring(2,1) == "7"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}
										break;	
									case "8": 
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											if(arrCntrTpsz.substring(2,1) == "8"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}
										break;	
									case "9":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											if(arrCntrTpsz.substring(2,1) == "9"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}
										break;	
									case "W": 
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											if(arrCntrTpsz.substring(2,1) == "w"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}							
										break;	
									case "X": 
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											if(arrCntrTpsz.substring(2,1) == "x"){
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
											}else{ 
												sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_fd")=0;
											}
										}								
										break;	
								}							
							}else if((formObject.cntr_type_s.value!="" && formObject.cntr_type_s.value!=undefined)&& (formObject.cntr_size_s.value!="" && formObject.cntr_size_s.value!=undefined)){
									var typeName = comboObjects[7].Code;
									var sizeName = comboObjects[8].Code;	
														
									cntrTypeSize = typeName+sizeName;
									sheetObjects[4].CellValue(k+2, "5"+cntrTypeSize.toLowerCase()+"_fd")=formObject.ft_dys.value;		
							}																		
						}
				}
									
					if(formObject.storage_gb[1].checked==true){		
						if(formObject.tml_agmt_vol_ut_cd[2].value=="C"){
							if(formObject.cntr_ts[2].checked==true){
								for(var l=0; l<arrCntrTpSz.length; l++)
								{ 							
									sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;											
								}										
							}
							else if(formObject.cntr_ts[3].checked==true){ 
								
								if(comboObjects[7].Code == "All" && comboObjects[8].Code == "All"){
									for(var l=0; l<arrCntrTpSz.length; l++)
									{ 							
										sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;					
									}					
								} 		
								
								if(comboObjects[7].Code == "All" && (comboObjects[8].Code!="" || comboObjects[8].Code!=undefined)){		
										var typeName = comboObjects[7].Code;
										var sizeName = comboObjects[8].Code;	
										
										var cntr_type_list = new Array();
										cntr_type_list[0] = "D";
										cntr_type_list[1] = "R"; 
										cntr_type_list[2] = "F"; 
										cntr_type_list[3] = "O";
										cntr_type_list[4] = "S";
										cntr_type_list[5] = "T";
										cntr_type_list[6] = "A";
										cntr_type_list[7] = "P";
										cntr_type_list[8] = "C";
										
										for(var l=0; l<9 ; l++)
										{ 
											sheetObjects[4].CellValue(k+2, "5"+cntr_type_list[l].toLowerCase()+sizeName+"_r")=formObject.agmt_ut_rt.value;											
										}					
								}
								
								if((comboObjects[7].Code!="" || comboObjects[8].Code!=undefined) && comboObjects[8].Code == "All"){				 
										var typeName = comboObjects[7].Code;
										var sizeName = comboObjects[8].Code;
										
										var cntr_size_list = new Array();
										cntr_size_list[0] = "2";
										cntr_size_list[1] = "4"; 
										cntr_size_list[2] = "5"; 
										cntr_size_list[3] = "6";
										cntr_size_list[4] = "7";
										cntr_size_list[5] = "8";
										cntr_size_list[6] = "9";
										cntr_size_list[7] = "w";  				
										cntr_size_list[8] = "x";  											
																									
										for(var l=0; l<9 ; l++)
										{		 							
											sheetObjects[4].CellValue(k+2, "5"+typeName.toLowerCase()+cntr_size_list[l]+"_r")=formObject.agmt_ut_rt.value;										
										
										}					
								}	
																	
								if(formObject.cntr_type_s.value!="" && formObject.cntr_size_s.value==""){	
									var typeName = formObject.cntr_type_s.value;						
									switch(typeName){										
										case "D":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "d"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}																	 									
											break;										
										case "R":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "r"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}										
											break;									
										case "F":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "f"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}															
											break;								
										case "O":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "o"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}																										
											break;
										case "S":		
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "s"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}											
											break;										
										case "T":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "t"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}									
											break; 								
										case "A":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "a"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}									
											break; 								
										case "P":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "p"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}									
											break;	
										case "C":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpsz.substring(1,1) == "c"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}									
											break;		
									}							
								}else if(formObject.cntr_type_s.value=="" && formObject.cntr_size_s.value!=""){
									switch(formObject.cntr_size_s.value){										
										case "2":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{
												if(arrCntrTpsz.substring(2,1) == "2"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}
											break;			
										case "4":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{
												if(arrCntrTpsz.substring(2,1) == "4"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}
											break;		
										case "5":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{
												if(arrCntrTpsz.substring(2,1) == "5"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}
											break;						
										case "7": 
											for(var l=0; l<arrCntrTpSz.length; l++)
											{
												if(arrCntrTpsz.substring(2,1) == "7"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}
											break;	
										case "8": 
											for(var l=0; l<arrCntrTpSz.length; l++)
											{
												if(arrCntrTpsz.substring(2,1) == "8"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}
											break;	
										case "9":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{
												if(arrCntrTpsz.substring(2,1) == "9"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}
											break;	
										case "W": 
											for(var l=0; l<arrCntrTpSz.length; l++)
											{
												if(arrCntrTpsz.substring(2,1) == "w"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}							
											break;	
										case "X": 
											for(var l=0; l<arrCntrTpSz.length; l++)
											{
												if(arrCntrTpsz.substring(2,1) == "x"){
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
												}else{ 
													sheetObjects[4].CellValue(k+2, sheetNo+arrCntrTpSz[l]+"_r")=0;
												}
											}							
											break;	
									}																
								}else if(formObject.cntr_type_s.value!="" && formObject.cntr_size_s.value!=""){										
										var typeName = comboObjects[7].Code;
										var sizeName = comboObjects[8].Code;	
															
										cntrTypeSize = typeName+sizeName;
										sheetObjects[4].CellValue(k+2, "5"+cntrTypeSize.toLowerCase()+"_r")=formObject.agmt_ut_rt.value;													
									
								}																				
							}
						}
					}
							 
					if(formObject.tml_agmt_vol_ut_cd[2].value=="T"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "teu_rate")=formObject.agmt_ut_rt.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "teu_rate")=""; 
					}
					
					if(formObject.tml_agmt_vol_ut_cd[2].value=="B"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "box_rate")=formObject.agmt_ut_rt.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "box_rate")=""; 
					}
					
					if(formObject.tml_agmt_vol_ut_cd[2].value=="M"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "move_rate")=formObject.agmt_ut_rt.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "move_rate")=""; 
					} 
					
					if(formObject.tml_agmt_vol_ut_cd[2].value=="W"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "ton_rate")=formObject.agmt_ut_rt.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "ton_rate")=""; 
					} 
						
							
					sheetObjects[4].CellValue(k+2, sheetNo+ "verify_result")="";
					sheetObjects[4].CellValue(k+2, sheetNo+ "remark")="";
						
					if(formObject.storage_gb[0].checked==true){
						if(formObject.sat_flg_FD.disabled==false && formObject.sun_flg_FD.disabled==false && formObject.hol_flg_FD.disabled==false){
								if(formObject.sat_flg_FD.checked==true || formObject.sun_flg_FD.checked==true || formObject.hol_flg_FD.checked==true){									
									sheetObjects[4].CellValue(k+2, sheetNo+ "agmt_dtl_rmk")="S";  
								}else{
									sheetObjects[4].CellValue(k+2, sheetNo+ "agmt_dtl_rmk")="N";
								}
						}
					}else if(formObject.storage_gb[1].checked==true){
							sheetObjects[4].CellValue(k+2, sheetNo+ "agmt_dtl_rmk")="";
					}						
					
					eq_flg = sheetObjects[4].ColValueDup("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111");
					
					comp_flg = sheetObjects[4].ColValueDup("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|41");
					
					if(eq_flg == -1 && comp_flg == -1){ 
						sheetObjects[4].RowStatus(k+2) = "I";
						k++;					
						//break;
					}else if(eq_flg == -1 && comp_flg > -1){							
						storageRateInputListComparison(k+2);  // Rate 조건 관련 비교			
					}else{
						sheetObjects[4].RowDelete(k+2, false);						
						ComShowCodeMessage('TES10117');		// There is sane condition rate.\n\n Please check the Agreement.
					}						
				}
			}else if(formObject.tml_sto_agmt_tp_cd.value == "FP"){
	 
					sheetObjects[4].DataInsert(-1);					
											
					sheetObjects[4].CellValue(k+2, 0)="";
					sheetObjects[4].CellValue(k+2, 1)=""; 										
					sheetObjects[4].CellValue(k+2, sheetNo+ "lgs_cost_cd")=formObject.lgs_cost_cd_s.value;					           
					sheetObjects[4].CellValue(k+2, sheetNo+ "curr_cd")=formObject.curr_cd_s.value;
					sheetObjects[4].CellValue(k+2, sheetNo+ "tml_sto_agmt_tp_cd")=formObject.tml_sto_agmt_tp_cd.value;
					sheetObjects[4].CellValue(k+2, sheetNo+ "cmnc_hrmnt")=formObject.cmnc_hrmnt.value;												
					
					sheetObjects[4].CellValue(k+2, sheetNo+ "fp_calc_prd_cd")=getElementValue(formObject, 'radio', 'fp_calc_prd_cd');
					sheetObjects[4].CellValue(k+2, sheetNo+ "fp_teu_qty")=formObject.fp_teu_qty.value;
					
					//[CHM-201539081]UOM입력에 따른 위치이동(3건 통합) 1) UOM Row를 CNTR TYPE SIZE바로 앞쪽으로 이동하여 가시성 확보(CAH D 2015.12.08)
					sheetObjects[4].CellValue(k+2, sheetNo+ "tml_agmt_vol_ut_cd")=formObject.tml_agmt_vol_ut_cd[2].value;  
					
					if(formObject.tml_agmt_vol_ut_cd[2].value=="T"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "teu_rate")=formObject.agmt_ut_rt_fp.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "teu_rate")=""; 
					}
					
					if(formObject.tml_agmt_vol_ut_cd[2].value=="B"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "box_rate")=formObject.agmt_ut_rt_fp.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "box_rate")=""; 
					}
					
					if(formObject.tml_agmt_vol_ut_cd[2].value=="M"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "move_rate")=formObject.agmt_ut_rt_fp.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "move_rate")=""; 
					} 	
					
					if(formObject.tml_agmt_vol_ut_cd[2].value=="W"){
						sheetObjects[4].CellValue(k+2, sheetNo+ "ton_rate")=formObject.agmt_ut_rt_fp.value; 
					}else{
						sheetObjects[4].CellValue(k+2, sheetNo+ "ton_rate")=""; 
					} 
					
					eq_flg = sheetObjects[2].ColValueDup("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111");
					
					if(eq_flg > 0){ 
						sheetObjects[4].RowDelete(k+2, false);													
					}else{ 						
					sheetObjects[4].RowStatus(k+2) = "I";
					k++;	
					}											
			}
	}


	/**
	 * 
	 * @param {int,String}	sheetRowNum
	 * @return
	 */
	function terminalRateInputListComparison(sheetRowNum){
		var formObject  = document.form;
		var	sheetNo	= "3";
		
		var baseRowInfo = sheetObjects[2].CellValue(sheetRowNum,2)	+ sheetObjects[2].CellValue(sheetRowNum,3) 
						+ sheetObjects[2].CellValue(sheetRowNum,4)	+ sheetObjects[2].CellValue(sheetRowNum,5) 
						+ sheetObjects[2].CellValue(sheetRowNum,6)	+ sheetObjects[2].CellValue(sheetRowNum,7)
						+ sheetObjects[2].CellValue(sheetRowNum,8)	+ sheetObjects[2].CellValue(sheetRowNum,9)
						+ sheetObjects[2].CellValue(sheetRowNum,10)	+ sheetObjects[2].CellValue(sheetRowNum,11)  
						+ sheetObjects[2].CellValue(sheetRowNum,12)	+ sheetObjects[2].CellValue(sheetRowNum,13)  
						+ sheetObjects[2].CellValue(sheetRowNum,14)	+ sheetObjects[2].CellValue(sheetRowNum,15)
						+ sheetObjects[2].CellValue(sheetRowNum,16)	+ sheetObjects[2].CellValue(sheetRowNum,17)
						+ sheetObjects[2].CellValue(sheetRowNum,18)	+ sheetObjects[2].CellValue(sheetRowNum,19) 
						+ sheetObjects[2].CellValue(sheetRowNum,20)	+ sheetObjects[2].CellValue(sheetRowNum,21) 
						+ sheetObjects[2].CellValue(sheetRowNum,22)	+ sheetObjects[2].CellValue(sheetRowNum,23) 
						+ sheetObjects[2].CellValue(sheetRowNum,24)	+ sheetObjects[2].CellValue(sheetRowNum,25) 
						+ sheetObjects[2].CellValue(sheetRowNum,26)	+ sheetObjects[2].CellValue(sheetRowNum,27)               
						+ sheetObjects[2].CellValue(sheetRowNum,28)	+ sheetObjects[2].CellValue(sheetRowNum,29)
						+ sheetObjects[2].CellValue(sheetRowNum,30)	+ sheetObjects[2].CellValue(sheetRowNum,31);
	
		var compaRowInfo = "";	   
		             
		sheetObjects[2].RowDelete(sheetRowNum, false);
	
		for(var i=0;i<sheetObjects[2].RowCount;i++){
				compaRowInfo= sheetObjects[2].CellValue(i+3,2)	+ sheetObjects[2].CellValue(i+3,3) 
							+ sheetObjects[2].CellValue(i+3,4)	+ sheetObjects[2].CellValue(i+3,5) 
							+ sheetObjects[2].CellValue(i+3,6)	+ sheetObjects[2].CellValue(i+3,7)
							+ sheetObjects[2].CellValue(i+3,8)	+ sheetObjects[2].CellValue(i+3,9)
							+ sheetObjects[2].CellValue(i+3,10)	+ sheetObjects[2].CellValue(i+3,11)  
							+ sheetObjects[2].CellValue(i+3,12)	+ sheetObjects[2].CellValue(i+3,13)  
							+ sheetObjects[2].CellValue(i+3,14)	+ sheetObjects[2].CellValue(i+3,15)
							+ sheetObjects[2].CellValue(i+3,16)	+ sheetObjects[2].CellValue(i+3,17)
							+ sheetObjects[2].CellValue(i+3,18)	+ sheetObjects[2].CellValue(i+3,19) 
							+ sheetObjects[2].CellValue(i+3,20)	+ sheetObjects[2].CellValue(i+3,21) 
							+ sheetObjects[2].CellValue(i+3,22)	+ sheetObjects[2].CellValue(i+3,23) 
							+ sheetObjects[2].CellValue(i+3,24)	+ sheetObjects[2].CellValue(i+3,25) 
							+ sheetObjects[2].CellValue(i+3,26)	+ sheetObjects[2].CellValue(i+3,27)
							+ sheetObjects[2].CellValue(i+3,28)	+ sheetObjects[2].CellValue(i+3,29)
							+ sheetObjects[2].CellValue(i+3,30)	+ sheetObjects[2].CellValue(i+3,31);
				                                     
				if(baseRowInfo == compaRowInfo){
					if(formObject.tml_agmt_vol_ut_cd[1].value=="C"){
						if(formObject.cntr_ts[0].checked==true){							
							for(var l=0; l<arrCntrTpSz.length; l++)
							{ 							
								sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;					
							}										
						}
						else if(formObject.cntr_ts[1].checked==true){
							if(comboObjects[3].Code == "All" && comboObjects[4].Code == "All"){
								for(var l=0; l<arrCntrTpSz.length; l++)
								{ 							
									sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;					
								}					
							} 		
								
							if(comboObjects[3].Code == "All" && (comboObjects[4].Code!="" || comboObjects[4].Code!=undefined)){		
								var typeName = comboObjects[3].Code;
								var sizeName = comboObjects[4].Code;						
			
								var cntr_type_list = new Array();
								cntr_type_list[0] = "D";
								cntr_type_list[1] = "R"; 
								cntr_type_list[2] = "F"; 
								cntr_type_list[3] = "O";
								cntr_type_list[4] = "S";
								cntr_type_list[5] = "T";
								cntr_type_list[6] = "A";
								cntr_type_list[7] = "P";  
								cntr_type_list[8] = "C";  
								
								for(var l=0; l<9 ; l++)
								{ 
									sheetObjects[2].CellValue(i+3, "3"+cntr_type_list[l].toLowerCase()+sizeName)=formObject.agmt_rate.value;										
								}					
							}
								
							if((comboObjects[3].Code!="" || comboObjects[3].Code!=undefined) && comboObjects[4].Code == "All"){				 
								var typeName = comboObjects[3].Code;
								var sizeName = comboObjects[4].Code;						
							
								var cntr_size_list = new Array();
								cntr_size_list[0] = "2";
								cntr_size_list[1] = "4"; 
								cntr_size_list[2] = "5"; 
								cntr_size_list[3] = "7";
								cntr_size_list[4] = "8";
								cntr_size_list[5] = "9";
								cntr_size_list[6] = "w";  				
								cntr_size_list[7] = "x";  
																							
								for(var l=0; l<8 ; l++)
								{		 							
									sheetObjects[2].CellValue(i+3, "3"+typeName.toLowerCase()+cntr_size_list[l])=formObject.agmt_rate.value;											
								}					
							}						
																	
								if((formObject.cntr_type_t.value!="" && formObject.cntr_type_t.value!=undefined) && (formObject.cntr_size_t.value=="" || formObject.cntr_size_t.value==undefined)){	
									var typeName = formObject.cntr_type_t.value;						
									switch(typeName){	
										
									case "D":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "d"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}																	 									
										break;										
									case "R":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "r"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}										
										break;									
									case "F":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "f"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}																
										break;								
									case "O":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "o"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}																										
										break;
									case "S":		
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "s"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}											
										break;										
									case "T":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "t"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}									
										break; 								
									case "A":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "a"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}									
										break; 								
									case "P":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "p"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}									
										break;	
									case "C":
										for(var l=0; l<arrCntrTpSz.length; l++)
										{ 
											if(arrCntrTpSz.substring(1,1) == "c"){
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
											}else{ 
												sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
											}
										}									
										break;															
									}							
								}else if((formObject.cntr_type_t.value=="" || formObject.cntr_type_t.value==undefined) && (formObject.cntr_size_t.value!="" && formObject.cntr_size_t.value!=undefined)){
									switch(formObject.cntr_size_t.value){										
										case "2":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpSz.substring(2,1) == "2"){
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
												}else{ 
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
												}
											}	
											break;			
										case "4":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpSz.substring(2,1) == "4"){
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
												}else{ 
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
												}
											}
											break;		
										case "5":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpSz.substring(2,1) == "5"){
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
												}else{ 
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
												}
											}
											break;						
										case "7": 
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpSz.substring(2,1) == "7"){
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
												}else{ 
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
												}
											}
											break;	
										case "8": 
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpSz.substring(2,1) == "8"){
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
												}else{ 
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
												}
											}
											break;	
										case "9":
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpSz.substring(2,1) == "9"){
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
												}else{ 
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
												}
											}
											break;	
										case "W": 
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpSz.substring(2,1) == "w"){
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
												}else{ 
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
												}
											}							
											break;	
										case "X": 
											for(var l=0; l<arrCntrTpSz.length; l++)
											{ 
												if(arrCntrTpSz.substring(2,1) == "x"){
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=formObject.agmt_rate.value;
												}else{ 
													sheetObjects[2].CellValue(i+3, sheetNo+arrCntrTpSz[l])=0;
												}
											}								
											break;	
									}							
								}else if((formObject.cntr_type_t.value!="" && formObject.cntr_type_t.value!=undefined) && (formObject.cntr_size_t.value!="" && formObject.cntr_size_t.value!=undefined)){
									var typeName = comboObjects[3].Code;
									var sizeName = comboObjects[4].Code;	
															
									cntrTypeSize = typeName+sizeName;		
																			
									sheetObjects[2].CellValue(i+3, "3"+cntrTypeSize.toLowerCase())=formObject.agmt_rate.value;
									
								}									
						}
					} 
					if(formObject.tml_agmt_vol_ut_cd[1].value=="T"){
						sheetObjects[2].CellValue(i+3, sheetNo+ "teu_rate")=formObject.agmt_rate.value; 
					}else{
						sheetObjects[2].CellValue(i+3, sheetNo+ "teu_rate")=""; 
					}
					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
					if(formObject.tml_agmt_vol_ut_cd[1].value=="B"){
						sheetObjects[2].CellValue(i+3, sheetNo+ "box_rate")=formObject.agmt_rate.value; 
					}else{
						sheetObjects[2].CellValue(i+3, sheetNo+ "box_rate")=""; 
					}
					if(formObject.tml_agmt_vol_ut_cd[1].value=="M"){
						sheetObjects[2].CellValue(i+3, sheetNo+ "move_rate")=formObject.agmt_rate.value; 
					}else{
						sheetObjects[2].CellValue(i+3, sheetNo+ "move_rate")=""; 
					}
					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
					if (formObject.tml_agmt_vol_ut_cd[1].value == "W" ) {
						sheetObjects[2].CellValue(i+3, sheetNo+ "ton_rate") = formObject.agmt_rate.value; 
					} else {
						sheetObjects[2].CellValue(i+3, sheetNo+ "ton_rate") = ""; 
					} 				
				
				} 
				compaRowInfo = "";  
		}
	
	}

	/**
	 * 
	 * @param {int,String}	sheetRowNum
	 * @return
	 */
	function storageRateInputListComparison(sheetRowNum){	
		var formObject  = document.form;
		var	sheetNo	= "5";
		
		var baseRowInfo = sheetObjects[4].CellValue(sheetRowNum,2)+ sheetObjects[4].CellValue(sheetRowNum,3) 
		                + sheetObjects[4].CellValue(sheetRowNum,4)+ sheetObjects[4].CellValue(sheetRowNum,5) 
		                + sheetObjects[4].CellValue(sheetRowNum,6)+ sheetObjects[4].CellValue(sheetRowNum,7)
		                + sheetObjects[4].CellValue(sheetRowNum,8)+ sheetObjects[4].CellValue(sheetRowNum,9)
		                + sheetObjects[4].CellValue(sheetRowNum,10)+ sheetObjects[4].CellValue(sheetRowNum,11)  
		                + sheetObjects[4].CellValue(sheetRowNum,12)+ sheetObjects[4].CellValue(sheetRowNum,13)  
		                + sheetObjects[4].CellValue(sheetRowNum,14)+ sheetObjects[4].CellValue(sheetRowNum,15)
		                + sheetObjects[4].CellValue(sheetRowNum,16)+ sheetObjects[4].CellValue(sheetRowNum,17)
		                + sheetObjects[4].CellValue(sheetRowNum,18)+ sheetObjects[4].CellValue(sheetRowNum,19) 
		                + sheetObjects[4].CellValue(sheetRowNum,20)+ sheetObjects[4].CellValue(sheetRowNum,21) 
		                + sheetObjects[4].CellValue(sheetRowNum,22)+ sheetObjects[4].CellValue(sheetRowNum,23) 
		                + sheetObjects[4].CellValue(sheetRowNum,24)+ sheetObjects[4].CellValue(sheetRowNum,25) 
		                + sheetObjects[4].CellValue(sheetRowNum,26)+ sheetObjects[4].CellValue(sheetRowNum,27)               
		                + sheetObjects[4].CellValue(sheetRowNum,28)+ sheetObjects[4].CellValue(sheetRowNum,29)
		                + sheetObjects[4].CellValue(sheetRowNum,28)+ sheetObjects[4].CellValue(sheetRowNum,31) 
		                + sheetObjects[4].CellValue(sheetRowNum,30)+ sheetObjects[4].CellValue(sheetRowNum,33) 
		                + sheetObjects[4].CellValue(sheetRowNum,32)+ sheetObjects[4].CellValue(sheetRowNum,34)
		                + sheetObjects[4].CellValue(sheetRowNum,34)+ sheetObjects[4].CellValue(sheetRowNum,36)
		                + sheetObjects[4].CellValue(sheetRowNum,36)+ sheetObjects[4].CellValue(sheetRowNum,38) 
		                + sheetObjects[4].CellValue(sheetRowNum,38)+ sheetObjects[4].CellValue(sheetRowNum,39)
		                + sheetObjects[4].CellValue(sheetRowNum,40);
		
		var compaRowInfo = "";	   
		             
	  sheetObjects[4].RowDelete(sheetRowNum, false);
	
		for(var i=0;i<sheetObjects[4].RowCount;i++){
				
				compaRowInfo= sheetObjects[4].CellValue(i+3,2)+ sheetObjects[4].CellValue(i+3,3) 
		                + sheetObjects[4].CellValue(i+3,4)+ sheetObjects[4].CellValue(i+3,5) 
		                + sheetObjects[4].CellValue(i+3,6)+ sheetObjects[4].CellValue(i+3,7)
		                + sheetObjects[4].CellValue(i+3,8)+ sheetObjects[4].CellValue(i+3,9)
		                + sheetObjects[4].CellValue(i+3,10)+ sheetObjects[4].CellValue(i+3,11)  
		                + sheetObjects[4].CellValue(i+3,12)+ sheetObjects[4].CellValue(i+3,13)  
		                + sheetObjects[4].CellValue(i+3,14)+ sheetObjects[4].CellValue(i+3,15)
		                + sheetObjects[4].CellValue(i+3,16)+ sheetObjects[4].CellValue(i+3,17)
		                + sheetObjects[4].CellValue(i+3,18)+ sheetObjects[4].CellValue(i+3,19) 
		                + sheetObjects[4].CellValue(i+3,20)+ sheetObjects[4].CellValue(i+3,21) 
		                + sheetObjects[4].CellValue(i+3,22)+ sheetObjects[4].CellValue(i+3,23) 
		                + sheetObjects[4].CellValue(i+3,24)+ sheetObjects[4].CellValue(i+3,25) 
		                + sheetObjects[4].CellValue(i+3,26)+ sheetObjects[4].CellValue(i+3,27)               
		                + sheetObjects[4].CellValue(i+3,28)+ sheetObjects[4].CellValue(i+3,29)
		                + sheetObjects[4].CellValue(i+3,30)+ sheetObjects[4].CellValue(i+3,33) 
		                + sheetObjects[4].CellValue(i+3,32)+ sheetObjects[4].CellValue(i+3,34)
		                + sheetObjects[4].CellValue(i+3,34)+ sheetObjects[4].CellValue(i+3,36)
		                + sheetObjects[4].CellValue(i+3,36)+ sheetObjects[4].CellValue(i+3,38) 
		                + sheetObjects[4].CellValue(i+3,38)+ sheetObjects[4].CellValue(i+3,39)
		                + sheetObjects[4].CellValue(i+3,40);
			                                      
				if(baseRowInfo == compaRowInfo){
					
							if(formObject.storage_gb[0].checked==true){		
									if(formObject.tml_agmt_vol_ut_cd[2].value=="U" || formObject.tml_agmt_vol_ut_cd[2].value=="M"){
										for(var l=0; l<arrCntrTpSz.length; l++)
										{
											sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;
										}
									}									
								
									if(formObject.cntr_ts[2].checked==true){							
										for(var l=0; l<arrCntrTpSz.length; l++){ 							
											sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;										
										}										
									}
									else if(formObject.cntr_ts[3].checked==true){
										
										if(comboObjects[7].Code == "All" && comboObjects[8].Code == "All"){
											for(var l=0; l<arrCntrTpSz.length; l++)	
											{ 							
												sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;					
											}					
										} 		
										
										if(comboObjects[7].Code == "All" && (comboObjects[8].Code!="" || comboObjects[8].Code!=undefined)){		
												var typeName = comboObjects[7].Code;
												var sizeName = comboObjects[8].Code;	
												
												var cntr_type_list = new Array();
												cntr_type_list[0] = "D";
												cntr_type_list[1] = "R"; 
												cntr_type_list[2] = "F"; 
												cntr_type_list[3] = "O";
												cntr_type_list[4] = "S";
												cntr_type_list[5] = "T";
												cntr_type_list[6] = "A";
												cntr_type_list[7] = "P";  
												cntr_type_list[8] = "C";
												
												for(var l=0; l<9 ; l++)
												{ 
													sheetObjects[4].CellValue(i+3, "5"+cntr_type_list[l].toLowerCase()+sizeName+"_fd")=formObject.ft_dys.value;											
												}					
										}
										
										if((comboObjects[7].Code!="" || comboObjects[8].Code!=undefined) && comboObjects[8].Code == "All"){				 
												var typeName = comboObjects[7].Code;
												var sizeName = comboObjects[8].Code;
												
												var cntr_size_list = new Array();
												cntr_size_list[0] = "2";
												cntr_size_list[1] = "4"; 
												cntr_size_list[2] = "5"; 
												cntr_size_list[3] = "6";
												cntr_size_list[4] = "7";
												cntr_size_list[5] = "8";
												cntr_size_list[6] = "9";
												cntr_size_list[7] = "w";  				
												cntr_size_list[8] = "x";  													
																											
												for(var l=0; l<9 ; l++)
												{		 							
													sheetObjects[4].CellValue(i+3, "5"+typeName.toLowerCase()+cntr_size_list[l]+"_fd")=formObject.ft_dys.value;										
												}					
										}										
										 									
										if((formObject.cntr_type_s.value!="" && formObject.cntr_type_s.value!=undefined) && (formObject.cntr_size_s.value=="" || formObject.cntr_size_s.value==undefined)){	
											var typeName = formObject.cntr_type_s.value;						
											switch(typeName){										
												case "D":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "d"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}																	 									
													break;										
												case "R":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "r"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}										
													break;									
												case "F":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "f"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}														
													break;								
												case "O":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "o"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}																										
													break;
												case "S":		
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "s"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}											
													break;										
												case "T":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "t"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}									
													break; 								
												case "A":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "a"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}									
													break; 								
												case "P":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "p"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}									
													break;	
												case "C":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "c"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}									
													break;
											}							
										//}else if(formObject.cntr_size[1].value!=""){
										}else if((formObject.cntr_type_s.value=="" || formObject.cntr_type_s.value==undefined) && (formObject.cntr_size_s.value!="" && formObject.cntr_size_s.value!=undefined)){
											switch(formObject.cntr_size_s.value){										
												case "2":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "2"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}	
													break;			
												case "4":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "4"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}	
													break;		
												case "5":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "5"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}	
													break;						
												case "7": 
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "7"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}	
													break;	
												case "8": 
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "8"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}	
													break;	
												case "9":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "9"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}	
													break;	
												case "W": 
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "w"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}							
													break;	
												case "X": 
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "x"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_fd")=formObject.ft_dys.value;													
														}
													}								
													break;	
											}							
										}else if((formObject.cntr_type_s.value!="" && formObject.cntr_type_s.value!=undefined)&& (formObject.cntr_size_s.value!="" && formObject.cntr_size_s.value!=undefined)){
												var typeName = comboObjects[7].Code;
												var sizeName = comboObjects[8].Code;	
																	
												cntrTypeSize = typeName+sizeName;
												sheetObjects[4].CellValue(i+3, "5"+cntrTypeSize.toLowerCase()+"_fd")=formObject.ft_dys.value;	
											
										}																		
									}
								//}
							}
											
							if(formObject.storage_gb[1].checked==true){		
								if(formObject.tml_agmt_vol_ut_cd[2].value=="C"){
									if(formObject.cntr_ts[2].checked==true){							
										for(var l=0; l<arrCntrTpSz.length; l++) 	
										{
											sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;											
										}										
									}
									else if(formObject.cntr_ts[3].checked==true){ 
										
										if(comboObjects[7].Code == "All" && comboObjects[8].Code == "All"){
											for(var l=0; l<arrCntrTpSz.length; l++) 	
											{
												sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;											
											}				
										} 		
										
										if(comboObjects[7].Code == "All" && (comboObjects[8].Code!="" || comboObjects[8].Code!=undefined)){		
												var typeName = comboObjects[7].Code;
												var sizeName = comboObjects[8].Code;	
												
												var cntr_type_list = new Array();
												cntr_type_list[0] = "D";
												cntr_type_list[1] = "R"; 
												cntr_type_list[2] = "F"; 
												cntr_type_list[3] = "O";
												cntr_type_list[4] = "S";
												cntr_type_list[5] = "T";
												cntr_type_list[6] = "A";
												cntr_type_list[7] = "P";  	
												cntr_type_list[8] = "C"; 
												
												for(var l=0; l<9 ; l++)
												{ 
													sheetObjects[4].CellValue(i+3, "5"+cntr_type_list[l].toLowerCase()+sizeName+"_r")=formObject.agmt_ut_rt.value;											
												}					
										}
										
										if((comboObjects[7].Code!="" || comboObjects[8].Code!=undefined) && comboObjects[8].Code == "All"){				 
												var typeName = comboObjects[7].Code;
												var sizeName = comboObjects[8].Code;
												
												var cntr_size_list = new Array();
												cntr_size_list[0] = "2";
												cntr_size_list[1] = "4"; 
												cntr_size_list[2] = "5"; 
												cntr_size_list[3] = "6";
												cntr_size_list[4] = "7";
												cntr_size_list[5] = "8";
												cntr_size_list[6] = "9";
												cntr_size_list[7] = "w";  				
												cntr_size_list[8] = "x";  													
																											
												for(var l=0; l<9 ; l++)
												{		 							
													sheetObjects[4].CellValue(i+3, "5"+typeName.toLowerCase()+cntr_size_list[l]+"_r")=formObject.agmt_ut_rt.value;											
												}					
										}	
																			
										if(formObject.cntr_type_s.value!="" && formObject.cntr_size_s.value==""){	
											var typeName = formObject.cntr_type_s.value;						
											switch(typeName){										
												case "D":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "d"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}																	 									
													break;										
												case "R":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "r"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}										
													break;									
												case "F":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "f"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}
															sheetObjects[4].CellValue(i+3, 98)=formObject.agmt_ut_rt.value;																
													break;								
												case "O":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "o"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}																										
													break;
												case "S":		
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "s"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}											
													break;										
												case "T":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "t"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}									
													break; 								
												case "A":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "a"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}									
													break; 								
												case "P":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "p"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}									
													break;	
												case "C":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(1,1) == "c"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}									
													break;	
											}							
										//}else if(formObject.cntr_size[1].value!=""){
										}else if(formObject.cntr_type_s.value=="" && formObject.cntr_size_s.value!=""){
											switch(formObject.cntr_size_s.value){										
												case "2":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "2"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}	
													break;			
												case "4":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "4"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}
													break;		
												case "5":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "5"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}
													break;						
												case "7": 
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "7"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}
													break;	
												case "8": 
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "8"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}
													break;	
												case "9":
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "9"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}
													break;	
												case "W": 	
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "w"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}							
													break;	
												case "X": 
													for(var l=0; l<arrCntrTpSz.length; l++)
													{ 
														if(arrCntrTpSz.substring(2,1) == "x"){
															sheetObjects[4].CellValue(i+3, sheetNo+arrCntrTpSz[l]+"_r")=formObject.agmt_ut_rt.value;
														}
													}						
													break;	
											}																
										}else if(formObject.cntr_type_s.value!="" && formObject.cntr_size_s.value!=""){										
												var typeName = comboObjects[7].Code;
												var sizeName = comboObjects[8].Code;	
																	
												cntrTypeSize = typeName+sizeName;
												sheetObjects[4].CellValue(i+3, "5"+cntrTypeSize.toLowerCase()+"_r")=formObject.agmt_ut_rt.value;												
											
										}																				
									}
								}
							}	
				
				} 
				compaRowInfo = "";  
		}
	
	}    

    /*******************************************************************
     * 3. Agreement Terminal Rate List 데이터 및 조합 검증 처리
     * 
     ******************************************************************/

	/**
	 * Terminal Rate List Tab Data Verify. <br>
	 * @param{string}		beforeibflag	beforeibflag
	 **/
	function terminalRateListVerify_test1(beforeibflag){

		sheetObjects[2].ColumnSort("3auto_calc_flg", "DESC");
		var sheetNo = 3;
		var k = sheetObjects[2].RowCount+1;

		var count = 0;
		var n = 1;

		var costCodeKey = "";
		var costCodeVrfyFlg = "";

		verifyKey	= new Array();
		verifyKey_1	= new Array();
		verifyKey_2	= new Array();
		verifyKey_3	= new Array();
		verifyKey_4	= new Array();
		verifyKey_5	= new Array();
		verifyKey_6	= new Array();
		verifyKey_7	= new Array();
		verifyKey_8	= new Array();

		var costCount	= 0;
		var countkey	= 0;
		costCodeNcount	= new Array();

		for(i = 1; i < k; i++){
			if(sheetObjects[2].CellValue(i + 2, sheetNo + "auto_calc_flg") == "Y"){
				if(costCodeKey == ""){
					costCodeKey = sheetObjects[2].CellValue(i + 2, sheetNo + "lgs_cost_cd");
					costCodeVrfyFlg = sheetObjects[2].CellValue(i+2, sheetNo + "vrfyflg");
				}

				if(sheetObjects[2].CellValue(i + 3, sheetNo + "lgs_cost_cd") != ""){

					if(sheetObjects[2].CellValue(i + 2, sheetNo + "lgs_cost_cd") == sheetObjects[2].CellValue(i + 3, sheetNo + "lgs_cost_cd")){
						costCount++;
					} else if(sheetObjects[2].CellValue(i + 2, sheetNo + "lgs_cost_cd") != sheetObjects[2].CellValue(i + 3, sheetNo + "lgs_cost_cd")){
						costCodeNcount[countkey] = costCodeKey + "#" + (costCount + 1) + "#" + costCodeVrfyFlg;
						countkey++;
						costCodeKey 	= "";
						costCodeVrfyFlg	= "";
						costCount		= 0;
					}
				} else {
					break;
				}
			}
		}

		var rowStatus = new Array();

		var errCount = 0;
		var totalErrCount = 0;

		var local_count =0;
		var startRow = 0;
		var lastRow = 0;
		
		for(i = 0; i < costCodeNcount.length; i++) {

			var cost_code = "";
			var cost_code_flg = "";
			cost_code = costCodeNcount[i].split("#");
			cost_code_flg = cost_code[2].split("|");

			for(j = 0; j < cost_code[1]; j++) {
				// tml_dcgo_aply_flg
				if(cost_code_flg[6] == "Y"){
					//DG 구분용 비교 키
					verifyKey_1[j]	= sheetObjects[2].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "thc_tp_cd");
				}

				// tml_aply_dt_flg
				if(cost_code_flg[4] == "Y") {
					//applied day 구분용 키
					verifyKey_2[j]	= sheetObjects[2].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "thc_tp_cd");
				}

				// tml_io_bnd_flg
				if(cost_code_flg[2] == "Y") {
					//bound 구분용 키
					verifyKey_3[j]	= sheetObjects[2].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "thc_tp_cd");
				}

				// tml_ioc_flg
				if(cost_code_flg[3] == "Y"){
					//ioc 구분용 키
					verifyKey_4[j]	= sheetObjects[2].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "thc_tp_cd");
				}

				// tml_lane_flg
				if(cost_code_flg[5] == "Y"){
					//lane 구분용 키
					verifyKey_5[j]	= sheetObjects[2].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "thc_tp_cd");
				}

				// tml_thc_flg
				if(cost_code_flg[9] == "Y")  {
					//thc 구분용키
					verifyKey_6[j]	= sheetObjects[2].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd");
				}

				// tml_tr_vol_flg
				if(cost_code_flg[7] == "Y") {
					//Tier Vol 구분용키
					verifyKey_7[j]	= sheetObjects[2].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "thc_tp_cd");
				}

				// tml_trns_mod_flg
				if(cost_code_flg[25] == "Y") {
					//Trans Mode 구분용키
					verifyKey_8[j]	= sheetObjects[2].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(local_count + 3, sheetNo + "thc_tp_cd");
				}

				local_count++;
			}

			if(i == 0) {
				startRow = 3;
				lastRow	= local_count + 2;
			} else if(i > 0) {
				startRow = lastRow + 1;
				lastRow = local_count + 2;
			}

			for(jj = startRow; jj <= lastRow; jj++) {
				rowStatus[jj] = sheetObjects[2].CellValue(jj, sheetNo + "ibflag");
			}
			

			if(errCount == 0) {
				// tml_dcgo_aply_flg
				if(cost_code_flg[6] == "Y" ) {
					errCount = terminal_dg_class_verify(verifyKey_1, startRow, lastRow) + errCount;
					for(jj = 0; jj < verifyKey_1.length; jj++) {
						verifyKey_1 = Array();
					}
				}
			}

			if(errCount == 0) {
				// tml_thc_flg
				if(cost_code_flg[9] == "Y") {
					errCount = terminal_thc_verify(verifyKey_6, startRow, lastRow) + errCount;
					for(jj = 0; jj < verifyKey_6.length; jj++){
						verifyKey_6 = Array();
					}
				}
			}

			// tml_ovt_shft_flg
 			if(cost_code_flg[8] == "Y") {
 				//ovt_shft_verify(inputListData7, startRow, lastRow);
			}

			if(errCount == 0) {
				// tml_tr_vol_flg
				if(cost_code_flg[7] == "Y") {
					errCount = terminal_tr_vol_val_verify(verifyKey_7, startRow, lastRow) + errCount;
					for(jj = 0; jj < verifyKey_7.length; jj++) {
						verifyKey_7 = Array();
					}
				}
			}

//			if(errCount==0){
//					if(cost_code_flg[6]=="Y"){
//							errCount  = terminal_dg_class_verify(verifyKey_1, startRow, lastRow)+errCount;
//							for(jj=0;jj<verifyKey_1.length;jj++){
//				 					verifyKey_1 = Array();
//				 			}
//					}
//			}


			if(errCount == 0) {
				// tml_lane_flg
				if(cost_code_flg[5] == "Y") {
					errCount = terminal_lane_cd_verify(verifyKey_5, startRow, lastRow) + errCount;
					for(jj = 0; jj < verifyKey_5.length; jj++) {
						verifyKey_5 = Array();
					}
				}
			}


			if(errCount == 0) {
				// tml_aply_dt_flg
				if(cost_code_flg[4] == "Y") {
					errCount = terminal_aply_dy_verify(verifyKey_2, startRow, lastRow) + errCount;
					for(jj = 0; jj < verifyKey_2.length; jj++) {
						verifyKey_2 = Array();
					}
				}
			}

			if(errCount == 0) {
				// tml_trns_mod_flg
				if(cost_code_flg[25] == "Y") {
					errCount = terminal_mode_verify(verifyKey_8, startRow, lastRow) + errCount;
					for(jj = 0; jj < verifyKey_8.length; jj++) {
						verifyKey_8 = Array();
					}
				}
			}

			if(errCount == 0) {
				// tml_ioc_flg
				if(cost_code_flg[3] == "Y") {
					errCount = terminal_ioc_cd_verify(verifyKey_4, startRow, lastRow) + errCount;
					for(jj = 0; jj < verifyKey_4.length; jj++) {
						verifyKey_4 = Array();
					}
				}
			}

			if(errCount == 0) {
				// tml_io_bnd_flg
				if(cost_code_flg[2] == "Y") {
					errCount = terminal_io_bnd_cd_verify(verifyKey_3, startRow, lastRow) + errCount;
					for(jj = 0; jj < verifyKey_3.length; jj++) {
						verifyKey_3 = Array();
					}
				}
			}

			for(jj = 0; jj < verifyKey_1.length; jj++) {
				verifyKey_1 = Array();
			}

			for(jj = 0; jj < verifyKey_2.length; jj++) {
				verifyKey_2 = Array();
			}

			for(jj = 0; jj < verifyKey_3.length; jj++) {
				verifyKey_3 = Array();
			}

			for(jj = 0; jj < verifyKey_4.length; jj++) {
				verifyKey_4 = Array();
			}

			for(jj = 0; jj < verifyKey_5.length; jj++) {
				verifyKey_5 = Array();
			}

			for(jj = 0; jj < verifyKey_6.length; jj++) {
				verifyKey_6 = Array();
			}

			for(jj = 0; jj < verifyKey_7.length; jj++) {
				verifyKey_7 = Array();
			}

			totalErrCount = errCount + totalErrCount;

			errCount = 0;

			for(jj = startRow; jj <= lastRow; jj++) {
				sheetObjects[2].RowStatus(jj) = beforeibflag[jj - 3];
				if(sheetObjects[2].CellValue(jj, sheetNo + "verify_result") == "") {
					sheetObjects[2].CellBackColor(jj,1) = sheetObjects[2].RgbColor(0,0,255);
				} else if(sheetObjects[2].CellValue(jj, sheetNo + "verify_result") != "") {
					sheetObjects[2].CellBackColor(jj,1) = sheetObjects[2].RgbColor(255,0,0);
				}
			}
		}

		sheetObjects[2].ColumnSort("3lgs_cost_cd|3io_bnd_cd|3ioc_cd|3tml_dy_aply_tp_cd|3lane_cd|3dcgo_aply_tp_cd|3tml_vol_aply_tp_cd|3fm_tr_vol_val|3to_tr_vol_val|3tml_ovt_shft_cd|3thc_tp_cd", "ASC");
		sheetObjects[2].ColumnSort("3lgs_cost_cd", "DESC");
		if(totalErrCount > 0) {
			return false;
		} else if(totalErrCount == 0) {

			for(i = 1; i < k; i++) {
				if(sheetObjects[2].CellValue(i + 2, sheetNo+"auto_calc_flg") == "N") {
					sheetObjects[2].RowStatus(i + 2) = beforeibflag[i - 1];
					sheetObjects[2].CellBackColor(i + 2,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
			return true;
		}
		totalErrCount =0;
	}


	/**
	 * Terminal Rate List Tab Thc Data Verify. <br>
	 * @param{verifyKey_6}	verifyKey_6	verifyKey_6
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function terminal_thc_verify(verifyKey_6, startRow, lastRow){
		var i;
		var j=0;
		var sheetNo = 3;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i = 0; i < verifyKey_6.length; i++) {

			if(i == 0) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_6[i];
				j++
			}

			if(dupTempKey != verifyKey_6[i]) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_6[i];
				j++;
			}
		}

		var dupString		= new Array();
		var dupStringSheet	= new Array();
		var dupStringKey	= new Array();
		var seqDupRowKey	= new Array();
		var k = 0;
		//최초키값 만들기
		for(i = 0; i < dupkey.length; i++) {
			dupString[i]	= sheetObjects[2].CellValue(dupkey[i], sheetNo + "lgs_cost_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "auto_calc_flg")
							//+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "io_bnd_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "ioc_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_trns_mod_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "wkdy_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sat_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sun_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "hol_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "lane_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sep_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "fm_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "to_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd");

			k = 0;

			for(var j = startRow; j <= lastRow; j++) {
				dupStringSheet[j]	= sheetObjects[2].CellValue(j, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_ovt_shft_cd");

				//if(j!=dupkey[i]){
				if(dupString[i] == dupStringSheet[j]) {
					k++;
					dupStringKey[j] = sheetObjects[2].CellValue(j, sheetNo + "thc_tp_cd");
				}else{
					k++;
					dupStringKey[j] = "";
				}
				//}
			}
			var err_count = terminal_thcVerifyFun(dupStringKey, startRow);
			dupStringKey = Array();
		}

		return err_count;
	}

	/**
	 * Terminal Rate List Tab Thc Data Verify. <br>
	 * @param{dupStringKey}		dupStringKey	dupStringKey
	 * @param{startRow}			startRow		startRow
	 **/
	function terminal_thcVerifyFun(dupStringKey, startRow){
		var inputString = "";
		var err_count = 0;

		for(var i = startRow; i < dupStringKey.length; i++) {
			if(dupStringKey[i] != "") {
				inputString  = inputString + dupStringKey[i];
			}
		}

		if(inputString == "GL" || inputString == "LG" || inputString == "T"){
			err_count = 0;
		} else {
			err_count = 1;
		}

		if(err_count > 0) {

			err_count  = 0;
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != ""){
					sheetObjects[2].CellValue2(i,"3verify_result") = "THC Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
				}
			}
		} else if(err_count == 0) {
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != "") {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Io Bound Code Data Verify. <br>
	 * @param{verifyKey_3}	verifyKey_3	verifyKey_3
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function terminal_io_bnd_cd_verify(verifyKey_3, startRow, lastRow){
		var i;
		var j=0;
		var sheetNo = 3;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i = 0; i < verifyKey_3.length; i++) {

			if(i == 0) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_3[i];
				j++
			}

			if(dupTempKey != verifyKey_3[i]) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_3[i];
				j++;
			}
		}

		var dupString		= new Array();
		var dupStringSheet	= new Array();
		var dupStringKey	= new Array();
		var seqDupRowKey	= new Array();

		for(i = 0; i < dupkey.length; i++) {
			dupString[i]	= sheetObjects[2].CellValue(dupkey[i], sheetNo + "lgs_cost_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "auto_calc_flg")
							//+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "ioc_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_trns_mod_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "wkdy_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sat_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sun_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "hol_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "lane_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sep_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "fm_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "to_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "thc_tp_cd");

			k = 0;

			for(var j = startRow; j <= lastRow; j++) {
				dupStringSheet[j]	= sheetObjects[2].CellValue(j, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "thc_tp_cd");

				if(dupString[i] == dupStringSheet[j]) {
					k++;
					dupStringKey[j] = sheetObjects[2].CellValue(j, sheetNo + "io_bnd_cd");
				} else {
					k++;
					dupStringKey[j] =  "";
				}
			}
			var err_count = terminal_ioBoundFun(dupStringKey, startRow);
			dupStringKey = Array();
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Io Bound Data Verify. <br>
	 * @param{dupStringKey}		dupStringKey	dupStringKey
	 * @param{startRow}			startRow		startRow
	 **/
	function terminal_ioBoundFun(dupStringKey, startRow){
		var inputString = "";
		var err_count = 0;
		for(var i = startRow; i < dupStringKey.length; i++) {
			if(dupStringKey[i] != "") {
				inputString  = inputString + dupStringKey[i];
			}
		}

		if(inputString == "S" || inputString == "IO" || inputString == "OI") {
			err_count = 0;
		} else {
			err_count = 1;
		}

		if(err_count > 0){
			err_count = 0;
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i]!= ""){
					sheetObjects[2].CellValue2(i,"3verify_result") = "IO Bound Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
				}
			}
		} else if(err_count == 0) {
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != "") {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Ioc Code Data Verify. <br>
	 * @param{verifyKey_4}	verifyKey_4	verifyKey_4
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function terminal_ioc_cd_verify(verifyKey_4, startRow, lastRow){
		var i;
		var j=0;
		var sheetNo = 3;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i = 0; i < verifyKey_4.length; i++) {

			if(i == 0) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_4[i];
				j++
			}

			if(dupTempKey != verifyKey_4[i]){
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_4[i];
				j++;
			}
		}

		var dupString		= new Array();
		var dupStringSheet	= new Array();
		var dupStringKey	= new Array();
		var seqDupRowKey	= new Array();

		for(i = 0; i < dupkey.length; i++) {
			dupString[i]	= sheetObjects[2].CellValue(dupkey[i], sheetNo+"lgs_cost_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "auto_calc_flg")
							//+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "io_bnd_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_trns_mod_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "wkdy_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sat_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sun_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "hol_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "lane_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sep_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "fm_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "to_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "thc_tp_cd");
			k = 0;

			for(var j = startRow; j <= lastRow; j++) {
				dupStringSheet[j]	= sheetObjects[2].CellValue(j, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "auto_calc_flg")       			
									//+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "io_bnd_cd")           			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_trns_mod_cd")     			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "wkdy_flg")            			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sat_flg")             			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sun_flg")             			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "hol_flg")             			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "lane_cd")             			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dg_none")             			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg_none")        			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg")             			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sep_dg_none")         			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n1st_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n2nd_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n3rd_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n4th_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n5th_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n6th_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n7th_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n8th_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n9th_clss_flg")  			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "fm_tr_vol_val")       			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "to_tr_vol_val")       			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_ovt_shft_cd")     			
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "thc_tp_cd");          			

				if(dupString[i] == dupStringSheet[j]) {
					k++;
					dupStringKey[j] = sheetObjects[2].CellValue(j, sheetNo + "ioc_cd");
				} else {
					k++;
					dupStringKey[j] =  "";
				}
			}
			var err_count = terminal_iocFun(dupStringKey, startRow);
			dupStringKey = Array();
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Ioc Code Data Verify. <br>
	 * @param{startRow}		startRow	startRow
	 * @param{dupStringKey}		dupStringKey	dupStringKey
	 **/
	function terminal_iocFun(dupStringKey, startRow){
		var inputString = "";
		var err_count = 0;
		for(var i = startRow; i < dupStringKey.length; i++) {
			if(dupStringKey[i] != "") {
				inputString = inputString + dupStringKey[i];
			}
		}
		if(inputString == "S" || inputString == "IO" || inputString == "OI") {
			err_count = 0;
		} else {
			err_count = 1;
		}

		if(err_count > 0) {
			err_count  = 0;
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != "") {
					sheetObjects[2].CellValue2(i,"3verify_result") = "IPC/Ocean Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
				}
			}
		} else if(err_count == 0) {
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != "") {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Mode Data Verify. <br>
	 * @param{verifyKey_8}	verifyKey_8	verifyKey_8
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function terminal_mode_verify(verifyKey_8, startRow, lastRow){
		var i;
		var j=0;
		var sheetNo = 3;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i=0;i<verifyKey_8.length;i++){

			if(i==0){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_8[i];
				j++
			}

			if(dupTempKey!=verifyKey_8[i]){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_8[i];
				j++;
			}
		}

		var dupString 			= new Array();
		var dupStringSheet 	= new Array();
		var dupStringKey 		= new Array();
		var seqDupRowKey		= new Array();

		for(i=0;i<dupkey.length;i++){
			dupString[i]	= sheetObjects[2].CellValue(dupkey[i], sheetNo+"lgs_cost_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "auto_calc_flg")
							//+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "io_bnd_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "ioc_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "wkdy_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sat_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sun_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "hol_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "lane_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sep_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "fm_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "to_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "thc_tp_cd");
			k=0;

			for(var j=startRow;j<=lastRow;j++){
				dupStringSheet[j]	= sheetObjects[2].CellValue(j, sheetNo+"lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "wkdy_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sat_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sun_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "hol_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "thc_tp_cd");

				if(dupString[i] == dupStringSheet[j]) {
					k++;
					dupStringKey[j] = sheetObjects[2].CellValue(j, sheetNo+"tml_trns_mod_cd");
				} else {
					k++;
					dupStringKey[j] = "";
				}
			}
			var err_count = terminal_modeFun(dupStringKey, startRow, sheetObjects[2].CellValue(dupkey[i], sheetNo + "lgs_cost_cd"));
			dupStringKey = Array();
		}
		return err_count;
	}


	/**
	 * Terminal Rate List Tab Mode Data Verify. <br>
	 * @param{dupStringKey}		dupStringKey	dupStringKey
	 * @param{startRow}			startRow	startRow
	 * @param{lgsCostCd}		lgsCostCd	lgsCostCd
	 **/
	function terminal_modeFun(dupStringKey, startRow, lgsCostCd){
		var err_count = 0;
		var inputString = "";
		var tempArray = new Array();
		tempArray[0] = "";
		tempArray[1] = "";
		tempArray[2] = "";

		var j = 0;
		var originalModeCd="";
		var inputModeCd="";

		var inputModeString = "";
		var originalModeString = "";

		for(var i = startRow; i < dupStringKey.length; i++) {
			if(dupStringKey[i] != "") {        

				// Verify 통과 Logic 수정 - 2009-04-30 이경한과장 요청
				// Same인 경우
				if(dupStringKey[i] == "S") {
					tempArray[0] = "S"
				// Same이 아니고 공백이 아닌 경우 ( Same 이외 모드인 경우 )                       
				} else if(dupStringKey[i] != "S" && dupStringKey[i] != "") {
					tempArray[1] = "L"
				// 공백인 경우( Verify 넘어오기전에 걸러짐 )
				} else {
					tempArray[0] = "";
					tempArray[1] = "";
				}                       
			}
		}
	
		/**********************************************************************************
		 * Mode Verify 통과 하는 경우 로직 변경 - 2009-04-30 이경한과장 요청
		 * 기존 Other Mode 필수값에서 제외
		 * 1. Same(S)만 있거나
		 * 2. Same(S)가 없으면 다른 모드로만 구성하거나
		 **********************************************************************************/
		if ( tempArray[0] == "S" && tempArray[1] == "" ) {
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != "") {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		} else if(tempArray[0] == "" && tempArray[1] == "L" ) {
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != ""){
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		} else {
			for(var i = startRow; i < dupStringKey.length; i++) {
				sheetObjects[2].CellValue2(i,"3verify_result") = "Mode Column Error";
				sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
				err_count++;
			}
		}
    
		return err_count;
	}
	
	/**
	 * Terminal Rate List Tab Apply Date Data Verify. <br>
	 * @param{verifyKey_2}	verifyKey_2	verifyKey_2
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function terminal_aply_dy_verify(verifyKey_2, startRow, lastRow){
		var i;
		var j = 0;
		var sheetNo = 3;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i = 0; i < verifyKey_2.length; i++) {

			if(i == 0) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_2[i];
				j++
			}

			if(dupTempKey != verifyKey_2[i]) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_2[i];
				j++;
			}
		}

		var dupString		= new Array();
		var dupStringSheet	= new Array();
		var dupStringKey	= new Array();
		var seqDupRowKey	= new Array();
	
		for(i = 0; i < dupkey.length; i++) {
			dupString[i]	= sheetObjects[2].CellValue(dupkey[i], sheetNo + "lgs_cost_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "auto_calc_flg")
							//+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "io_bnd_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "ioc_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_trns_mod_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "lane_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "same_dg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "sep_dg_none")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "fm_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "to_tr_vol_val")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "tml_ovt_shft_cd")
							+ "|" + sheetObjects[2].CellValue(dupkey[i], sheetNo + "thc_tp_cd");

			k = 0;

			for(var j = startRow; j <= lastRow; j++) {
				dupStringSheet[j]	= sheetObjects[2].CellValue(j, sheetNo+"lgs_cost_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "io_bnd_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "ioc_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_trns_mod_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "lane_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "same_dg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "sep_dg_none")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n1st_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n2nd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n3rd_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n4th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n5th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n6th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n7th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n8th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "dcgo_n9th_clss_flg")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "fm_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "to_tr_vol_val")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "tml_ovt_shft_cd")
									+ "|" + sheetObjects[2].CellValue(j, sheetNo + "thc_tp_cd");
				
				if(dupString[i] == dupStringSheet[j]) {
					k++;
					dupStringKey[j] = sheetObjects[2].CellValue(j, sheetNo+"wkdy_flg")+"|"+sheetObjects[2].CellValue(j, sheetNo+"sat_flg")+"|"+sheetObjects[2].CellValue(j, sheetNo+"sun_flg")+"|"+sheetObjects[2].CellValue(j, sheetNo+"hol_flg");
				} else {
					k++;
					dupStringKey[j] =  "NaN";
				}
			}
			var err_count = terminal_aply_dyFun(dupStringKey, startRow);
			dupStringKey = Array();
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Apply Date Data Verify. <br>
	 * @param{startRow}		startRow	startRow
	 * @param{dupStringKey}		dupStringKey		lastRow
	 **/
	function terminal_aply_dyFun(dupStringKey, startRow){
		var inputString = "";
		var err_count = 0;
		var tempArray = "";	   		 //최초 저장 배열
		var tempArrayKey = "";	   	//임시 저장 배열로 최초 저장 배열과 Y or "" 비교 체크 배열
		var tempString = "";
		var tempstartRow = startRow;

		for(var i = startRow; i < dupStringKey.length; i++) {
			if(dupStringKey[i] != "NaN") {
				if(tempstartRow < i) {
					tempArrayKey = dupStringKey[i].split("|");
					for(var j = 0; j < 4; j++) {
						if(tempArray[j] == "Y" && tempArrayKey[j] == "Y") {
							tempArray[j] = "S";
						}else if((tempArray[j] == "" && tempArrayKey[j] == "Y") || (tempArray[j] == "Y" && tempArrayKey[j] == "")) {
							tempArray[j] = "Y";
						}else if(tempArray[j] == "" && tempArrayKey[j] == "") {
							tempArray[j] = "";
						}else if((tempArray[j] == "S" && tempArrayKey[j] == "Y") || (tempArray[j] == "S" && tempArrayKey[j] == "")) {
							tempArray[j] = "S";
						}
					}
				}else{
					tempArray= dupStringKey[i].split("|");
				}
			}else{
				tempstartRow  = tempstartRow +1;
			}
			tempArrayKey = "";
		}

		for(k = 0; k < 4; k++ ) {
			tempString = tempString + tempArray[k];
		}

		if(tempString != "YYYY") {
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != "NaN") {
					sheetObjects[2].CellValue2(i,"3verify_result") = "Applied Day Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
				}
			}
		}else if(tempString == "YYYY") {
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != "NaN") {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab DG Class Data Verify. <br>
	 * @param{verifyKey_1}	verifyKey_1	verifyKey_1
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function terminal_dg_class_verify(verifyKey_1, startRow, lastRow){
		var i;
		var j=0;
		var sheetNo = 3;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i = 0; i < verifyKey_1.length; i++) {

			if(i == 0) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_1[i];
				j++
			}

			if(dupTempKey != verifyKey_1[i]) {
				dupkey[j] = i + startRow;
				dupTempKey = verifyKey_1[i];
				j++;
			}
		}

		var dupString		= new Array();
		var dupStringSheet	= new Array();
		var dupStringKey	= new Array();
		var seqDupRowKey	= new Array();

		for(i = 0; i < dupkey.length; i++) {
			dupString[i]	= sheetObjects[2].CellValue(dupkey[i], sheetNo+"lgs_cost_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"auto_calc_flg")
										//+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"io_bnd_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"ioc_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_trns_mod_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"wkdy_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"sat_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"sun_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"hol_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"lane_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"fm_tr_vol_val")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"to_tr_vol_val")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_ovt_shft_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"thc_tp_cd");

			k=0;

			for(var j=startRow;j<=lastRow;j++){
				dupStringSheet[j]	= sheetObjects[2].CellValue(j, sheetNo+"lgs_cost_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"auto_calc_flg")
														//+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"io_bnd_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"ioc_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_trns_mod_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"wkdy_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sat_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sun_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"hol_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"lane_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"fm_tr_vol_val")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"to_tr_vol_val")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_ovt_shft_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"thc_tp_cd");

				if(dupString[i]==dupStringSheet[j]){
					k++;
					dupStringKey[j] = sheetObjects[2].CellValue(j, sheetNo+"dg_none")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"same_dg_none")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"same_dg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sep_dg_none")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n1st_clss_flg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n2nd_clss_flg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n3rd_clss_flg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n4th_clss_flg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n5th_clss_flg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n6th_clss_flg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n7th_clss_flg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n8th_clss_flg")
															+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n9th_clss_flg");
				}else{
					k++;
					dupStringKey[j] =  "NaN";
				}
			}
			var err_count = terminal_dg_classFun(dupStringKey, startRow, sheetObjects[2].CellValue(dupkey[i], sheetNo+"lgs_cost_cd"));
			dupStringKey = Array();
		}

		return err_count;
	}

	
	/**
	 * Terminal Rate List Tab DG Class Data Verify. <br>
	 * @param{dupStringKey}		dupStringKey	dupStringKey
	 * @param{startRow}			startRow		startRow
	 * @param{lgsCosdCd}		lgsCosdCd		lgsCosdCd
	 **/
	function terminal_dg_classFun(dupStringKey, startRow, lgsCosdCd){
		var inputString = "";
		var err_count = 0;
		var tempArrayHdr ="";	   		 						//최초 저장 배열
		var tempArrayDtl ="";	   		 						//최초 저장 배열
		var tempArrayHdrKey ="";	   						//임시 저장 배열로 최초 저장 배열과 Y or "" 비교 체크 배열
		var tempArrayDtlKey ="";	   						//임시 저장 배열로 최초 저장 배열과 Y or "" 비교 체크 배열
		var tempHdrString = "";
		var tempDtlString = "";
		var tempstartRow =  startRow;
		
		for(var i=startRow;i<dupStringKey.length;i++){
			if(dupStringKey[i]!="NaN"){
				    
				if(tempstartRow<i){
					tempArrayHdrKey = dupStringKey[i].split("|");
					for(var j=0;j<3;j++){

						if(tempArrayHdr[j]=="Y" && tempArrayHdrKey[j]=="Y"){
							tempArrayHdr[j]="S";
						}else if((tempArrayHdr[j]=="" && tempArrayHdrKey[j]=="Y") || (tempArrayHdr[j]=="Y" && tempArrayHdrKey[j]=="")){
							tempArrayHdr[j]="Y";
						}else if(tempArrayHdr[j]=="" && tempArrayHdrKey[j]==""){
							tempArrayHdr[j]="";
						}else if((tempArrayHdr[j]=="S" && tempArrayHdrKey[j]=="Y") || (tempArrayHdr[j]=="S" && tempArrayHdrKey[j]=="")){
							tempArrayHdr[j]="S";
						}
					}

					tempArrayDtlKey = dupStringKey[i].split("|");
					for(j=3;j<13;j++){
						if(tempArrayDtl[j]=="Y" && tempArrayDtlKey[j]=="Y"){
							tempArrayDtl[j]="S";
						}else if((tempArrayDtl[j]=="" && tempArrayDtlKey[j]=="Y") || (tempArrayDtl[j]=="Y" && tempArrayDtlKey[j]=="")){
							tempArrayDtl[j]="Y";
						}else if(tempArrayDtl[j]=="" && tempArrayDtlKey[j]==""){
							tempArrayDtl[j]="";
						}else if((tempArrayDtl[j]=="S" && tempArrayDtlKey[j]=="Y") || (tempArrayDtl[j]=="S" && tempArrayDtlKey[j]=="")){
							tempArrayDtl[j]="S";
						}
					}
				}else{
					tempArrayHdr= dupStringKey[i].split("|");
					tempArrayDtl= dupStringKey[i].split("|");
				}
			}else{
				tempstartRow  = tempstartRow +1;
			}
			tempArrayHdrKey = "";
			tempArrayDtlKey = "";
		}

		for(var k=0;k<3;k++){
			tempHdrString = tempHdrString+"|"+tempArrayHdr[k];
		}

		for(var k=3;k<13;k++){
			tempDtlString = tempDtlString+"|"+tempArrayDtl[k];
		}
		
		if(tempHdrString=="|Y||" && tempDtlString == "||||||||||"){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!="NaN"){
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}else if(tempHdrString=="||Y|Y" && tempDtlString=="||||||||||"){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!="NaN"){
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}else if(tempHdrString=="|||" && tempDtlString=="|Y|Y|Y|Y|Y|Y|Y|Y|Y|Y"){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!="NaN"){
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}else{
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!="NaN"){
					sheetObjects[2].CellValue2(i,"3verify_result") = "DG Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
				}
			}
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Lane Code Data Verify. <br>
	 * @param{verifyKey_5}	verifyKey_5	verifyKey_5
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function terminal_lane_cd_verify(verifyKey_5, startRow, lastRow){
		var i;
		var j=0;
		var sheetNo = 3;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i=0;i<verifyKey_5.length;i++){

			if(i==0){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_5[i];
				j++
			}

			if(dupTempKey!=verifyKey_5[i]){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_5[i];
				j++;
			}
		}

		var dupString 			= new Array();
		var dupStringSheet 	= new Array();
		var dupStringKey 		= new Array();
		var seqDupRowKey		= new Array();
		for(i=0;i<dupkey.length;i++){

			dupString[i]	= sheetObjects[2].CellValue(dupkey[i], sheetNo+"lgs_cost_cd")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"auto_calc_flg")
						//+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"io_bnd_cd")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"ioc_cd")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_trns_mod_cd")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"wkdy_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"sat_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"sun_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"hol_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dg_none")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"same_dg_none")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"same_dg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"sep_dg_none")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n1st_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n2nd_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n3rd_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n4th_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n5th_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n6th_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n7th_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n8th_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n9th_clss_flg")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"fm_tr_vol_val")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"to_tr_vol_val")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_ovt_shft_cd")
						+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"thc_tp_cd");


			k=0;

			for(var j=startRow;j<=lastRow;j++){
				dupStringSheet[j]	= sheetObjects[2].CellValue(j, sheetNo+"lgs_cost_cd")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"auto_calc_flg")
									//+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"io_bnd_cd")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"ioc_cd")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_trns_mod_cd")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"wkdy_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sat_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sun_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"hol_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dg_none")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"same_dg_none")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"same_dg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sep_dg_none")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n1st_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n2nd_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n3rd_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n4th_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n5th_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n6th_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n7th_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n8th_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n9th_clss_flg")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"fm_tr_vol_val")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"to_tr_vol_val")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_ovt_shft_cd")
									+"|"+ sheetObjects[2].CellValue(j, sheetNo+"thc_tp_cd");

				if(dupString[i]==dupStringSheet[j]){
					k++;
					dupStringKey[j] = sheetObjects[2].CellValue(j, sheetNo+"lane_cd");
				}else{
					k++;
					dupStringKey[j] =  "";
				}

			}
			var err_count = terminal_lane_cdFun(dupStringKey, startRow);
			dupStringKey = Array();
		}
		verifyKey_5="";
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Lane Code Data Verify. <br>
	 * @param{dupStringKey}		dupStringKey	dupStringKey
	 * @param{startRow}			startRow		startRow
	 **/
	function terminal_lane_cdFun(dupStringKey, startRow){
		var err_count = 0;
		var inputString = "";
		var tempArray = new Array();
		tempArray[0] = "";
		tempArray[1] = "";
		tempArray[2] = "";

		var j = 0;
		//laneCDSheet2
		var originalLaneCd="";
		var inputLaneCd="";
		var sameCodeCount=0;

		var inputLaneString = "";
		var originalLaneString = "";

		for(var i=startRow;i<dupStringKey.length;i++){
			if(dupStringKey[i]!=""){
				if(dupStringKey[i]=="Sam"){
					tempArray[0] = "S"
				}else if(dupStringKey[i]=="OTH"){
					tempArray[1] = "O"
				}else if(dupStringKey[i]!="Sam" && dupStringKey[i]!="OTH" && dupStringKey[i]!=""){
					tempArray[2] = "L"
						inputString = dupStringKey[i]+"|"+inputString;
				}else{
					tempArray[0] = "";
					tempArray[1] = "";
					tempArray[2] = "";
				}
			}
		}

		if(tempArray[0]=="S" && tempArray[1] == "" && tempArray[2] == ""){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}else if(tempArray[0]=="" && tempArray[1] == "O" &&  tempArray[2] == "L"){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}else if(tempArray[0]=="" && tempArray[1] == "" && tempArray[2] == "L"){
			originalLaneCd  = laneCDSheet2.split("|");
			inputLaneCd = inputString.split("|");
			for(var i=0;i<inputLaneCd.length;i++){
				for(j=2;j<originalLaneCd.length;j++){
					if(inputLaneCd[i]==originalLaneCd[j]){
						inputLaneCd[i]="";
						originalLaneCd[j]="";
					}
				}
			}

			for(var i=0;i<inputLaneCd.length;i++){
				inputLaneString  = inputLaneString +inputLaneCd[i];
			}

			for(j=2;j<originalLaneCd.length;j++){
				originalLaneString  = originalLaneString+originalLaneCd [j];
			}
			if(inputLaneString=="" && originalLaneString==""){
				for(var i=startRow;i<dupStringKey.length;i++){
					if(dupStringKey[i]!=""){
						sheetObjects[2].CellValue2(i,"3verify_result") = "";
						sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
					}
				}
			}else{
				for(var i=startRow;i<dupStringKey.length;i++){
					sheetObjects[2].CellValue2(i,"3verify_result") = "Lane Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
				}
			}
		}else{
			for(var i=startRow;i<dupStringKey.length;i++){
				sheetObjects[2].CellValue2(i,"3verify_result") = "Lane Colume Error";
				sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
				err_count++;
			}
		}
	/**
	if(sameCodeCount>1){
			for(var i=startRow;i<dupStringKey.length;i++){
					sheetObjects[2].CellValue2(i,"3verify_result") = "Lane Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
			}
	}
	**/

		return err_count;
	}

	/**
	 * Terminal Rate List Tab Tier Volume Value Data Verify. <br>
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 * @param{verifyKey_7}		verifyKey_7	verifyKey_7
	 **/
	function terminal_tr_vol_val_verify(verifyKey_7, startRow, lastRow){
		var i;
		var j=0;
		var sheetNo = 3;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i=0;i<verifyKey_7.length;i++){

			if(i==0){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_7[i];
				j++
			}

			if(dupTempKey!=verifyKey_7[i]){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_7[i];
				j++;
			}
		}

		var dupString 			= new Array();
		var dupStringSheet 	= new Array();
		var dupStringKey 		= new Array();
		var seqDupRowKey		= new Array();

		for(i=0;i<dupkey.length;i++){
			dupString[i]	= sheetObjects[2].CellValue(dupkey[i], sheetNo+"lgs_cost_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"auto_calc_flg")
										//+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"io_bnd_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"ioc_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_trns_mod_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"wkdy_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"sat_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"sun_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"hol_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"lane_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dg_none")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"same_dg_none")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"same_dg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"sep_dg_none")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n1st_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n2nd_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n3rd_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n4th_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n5th_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n6th_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n7th_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n8th_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"dcgo_n9th_clss_flg")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"tml_ovt_shft_cd")
										+"|"+ sheetObjects[2].CellValue(dupkey[i], sheetNo+"thc_tp_cd");

			k=0;

			for(var j=startRow;j<=lastRow;j++){
				dupStringSheet[j]	= sheetObjects[2].CellValue(j, sheetNo+"lgs_cost_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"auto_calc_flg")
														//+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"io_bnd_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"ioc_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_trns_mod_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"wkdy_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sat_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sun_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"hol_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"lane_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dg_none")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"same_dg_none")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"same_dg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"sep_dg_none")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n1st_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n2nd_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n3rd_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n4th_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n5th_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n6th_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n7th_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n8th_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"dcgo_n9th_clss_flg")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"tml_ovt_shft_cd")
														+"|"+ sheetObjects[2].CellValue(j, sheetNo+"thc_tp_cd");
				if(dupString[i]==dupStringSheet[j]){
					k++;
					dupStringKey[j] = sheetObjects[2].CellValue(j, sheetNo+"fm_tr_vol_val")+"|"+sheetObjects[2].CellValue(j, sheetNo+"to_tr_vol_val");
				}else{
					k++;
					dupStringKey[j] =  "";
				}
			}
			var err_count = terminal_tr_vol_valFun(dupStringKey, startRow);
			dupStringKey = Array();
		}

		return err_count;
	}

	/**
	 * Terminal Rate List Tab Tier Volume Value Data Verify. <br>
	 * @param{dupStringKey}		dupStringKey	dupStringKey
	 * @param{startRow}			startRow		startRow
	 **/
	function terminal_tr_vol_valFun(dupStringKey, startRow){
		var inputString = "";
		var err_count = 0;
		var tempArray ="";	   		 						//최초 저장 배열
		var tempArrayKey ="";	   							//임시 저장 배열로 최초 저장 배열과 Y or "" 비교 체크 배열
		var tempString = "";
		var tempstartRow = startRow;

		for(var i=startRow;i<dupStringKey.length;i++){
			if(dupStringKey[i]!=""){
				if(tempstartRow<i){

					tempArrayKey = dupStringKey[i].split("|");

					if(tempArray[1].toUpperCase()=="MAX"){
						tempArray[1]  = 9999999;
					}

					if(tempArrayKey[1].toUpperCase()=="MAX"){
						tempArrayKey[1]  = 9999999;
					}

					if(tempArray[0] < 1 || tempArrayKey[0] < 1){
						err_count = 1;
					}
					
					if(tempArray[0]==tempArrayKey[0]){
						err_count = 1;
					}

					if(tempArray[1]!=(parseInt(tempArrayKey[0])-1)){
						err_count = 1;
					}else if(tempArray[1]==(parseInt(tempArrayKey[0])-1)){
						tempArray[1] = tempArrayKey[1];
					}
				}else{
					tempArray= dupStringKey[i].split("|");
					if(tempArray[1].toUpperCase()=="MAX"){
						tempArray[1]  = 9999999;
					}
				}
			}else{
				tempstartRow  = tempstartRow +1;
			}

			tempArrayKey = "";
		}

		if(tempArray[0]==1 && tempArray[1]==9999999){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}
			}
		}else{
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[2].CellValue2(i,"3verify_result") = "Tier Vol. Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
				}
			}
		}

		if(err_count>0){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[2].CellValue2(i,"3verify_result") = "Tier Vol. Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					err_count++;
				}
			}
		}
		return err_count;
	}

	/**
	 * Terminal Rate List Tab Container Rate Data Verify. <br>
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function terminal_cntr_rate_verify(startRow, lastRow){
		var tr_rate = 0;
		var teu_rate = 0;
		var box_rate = 0;
		var move_rate = 0;
		var ganghour_rate = 0;
		var ton_rate = 0;
		var cntrRateErrCount =0;
		var i=0;
		var j=0;

		for(i=startRow;i<=lastRow;i++){
			for(j=32;j<63;j++){
				tr_rate = parseInt(sheetObjects[2].CellValue(i,j))+tr_rate ;
			}
			teu_rate  = sheetObjects[2].CellValue(i,"3teu_rate");
			box_rate  = sheetObjects[2].CellValue(i,"3box_rate");
			move_rate  = sheetObjects[2].CellValue(i,"3move_rate");
			ganghour_rate  = sheetObjects[2].CellValue(i,"3gang_hour_rate");
			ton_rate  = sheetObjects[2].CellValue(i,"3ton_rate");
			
			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
			if (sheetObjects[2].CellValue(i,"3tml_agmt_vol_ut_cd")=="C") {
				if (tr_rate > 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0 && ganghour_rate == 0 && ton_rate == 0 ) {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				} else {
					sheetObjects[2].CellValue2(i,"3verify_result") = "Rate by Container T/S Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					cntrRateErrCount++;
				}
			} else if (sheetObjects[2].CellValue(i,"3tml_agmt_vol_ut_cd")=="T") {
				if(tr_rate == 0 && teu_rate > 0 && box_rate == 0 && move_rate == 0 && ganghour_rate == 0 && ton_rate == 0 ) {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(0,0,255);
				}else{
					sheetObjects[2].CellValue2(i,"3verify_result") = "Rate by Container T/S Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					cntrRateErrCount++;
				}
			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
			} else if (sheetObjects[2].CellValue(i,"3tml_agmt_vol_ut_cd")=="B" ) {
				if(tr_rate == 0 && teu_rate == 0 && box_rate > 0 && move_rate == 0 && ganghour_rate == 0 && ton_rate == 0 ) {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
				}else{
					sheetObjects[2].CellValue2(i,"3verify_result") = "Rate by Container T/S Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					cntrRateErrCount++;
				}
			} else if (sheetObjects[2].CellValue(i,"3tml_agmt_vol_ut_cd")=="M" ) {
				if(tr_rate == 0 && teu_rate == 0 && box_rate == 0 && move_rate > 0 && ganghour_rate == 0 && ton_rate == 0 ) {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
				}else{
					sheetObjects[2].CellValue2(i,"3verify_result") = "Rate by Container T/S Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					cntrRateErrCount++;
				}
			}else if(sheetObjects[2].CellValue(i,"3tml_agmt_vol_ut_cd")=="G"){
				if(tr_rate == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0 && ganghour_rate > 0 && ton_rate == 0 ) {
					sheetObjects[2].CellValue2(i,"3verify_result") = "";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
				}else{
					sheetObjects[2].CellValue2(i,"3verify_result") = "Rate by Container T/S Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
					cntrRateErrCount++;
				}
			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
			} else if (sheetObjects[2].CellValue(i,"3tml_agmt_vol_ut_cd") == "W" ) {
				if ( tr_rate == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0 && ganghour_rate == 0 && ton_rate > 0 ) {
					sheetObjects[2].CellValue2(i, "3verify_result") = "";
					sheetObjects[2].CellBackColor(i, 1) = sheetObjects[2].RgbColor(255, 0, 0);
				} else {
					sheetObjects[2].CellValue2(i,"3verify_result") = "Rate by Container T/S Colume Error";
					sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255, 0, 0);
					cntrRateErrCount++;
				}
			}

			if(tr_rate == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0 && ganghour_rate == 0 && ton_rate == 0 ) {
				sheetObjects[2].CellValue2(i,"3verify_result") = "Rate by Container T/S Colume Error";
				sheetObjects[2].CellBackColor(i,1) = sheetObjects[2].RgbColor(255,0,0);
				cntrRateErrCount++;
			}
			tr_rate = 0;
		}
		return cntrRateErrCount;
	}
	
	/**
	 * Terminal Rate List Tab Data Verify. <br>
	 **/
	function dataTerminalVerify() {
		var k = sheetObjects[2].RowCount + 3;
		var dataErrCount	= 0;
		var vrfyFlg ;
		
		for(var i = 3; i < k; i++ ) {
			vrfyFlg = sheetObjects[7].CellValue(i-2, 1).split("|");
			sheetObjects[2].CellValue2(i,"3vrfyflg")	= sheetObjects[7].CellValue( i - 2, 1);
			sheetObjects[2].RowBackColor(i) = sheetObjects[2].RgbColor(255,255,255);
			
			if (vrfyFlg[0] != sheetObjects[2].CellValue(i, '3auto_calc_flg')){
				sheetObjects[2].CellBackColor(i,'3auto_calc_flg') = sheetObjects[2].RgbColor(255,0,0);
				dataErrCount++;
			}
			
			if(sheetObjects[2].CellValue(i, '3auto_calc_flg') == "Y") {
				
				if(sheetObjects[2].CellValue(i, '3lgs_cost_cd') != sheetObjects[7].CellValue(i-2,0)){
					sheetObjects[2].CellBackColor(i,'3lgs_cost_cd') = sheetObjects[2].RgbColor(255,0,0);
					dataErrCount++;
				}
				
				if(sheetObjects[2].CellValue(i, '3lgs_cost_cd') == ""){
					sheetObjects[2].CellBackColor(i,'3lgs_cost_cd') = sheetObjects[2].RgbColor(255,0,0);
					dataErrCount++;
				}
				
				// com_auto_calc_flg
				if (vrfyFlg[0] != sheetObjects[2].CellValue(i, '3auto_calc_flg')){
					sheetObjects[2].CellBackColor(i,'3auto_calc_flg') = sheetObjects[2].RgbColor(255,0,0);
					dataErrCount++;
				}
				
				// tml_io_bnd_flg
				if (vrfyFlg[2] == "Y"){
					
					if(sheetObjects[2].CellValue(i,'3io_bnd_cd') != "I" && sheetObjects[2].CellValue(i,'3io_bnd_cd') != "O" && sheetObjects[2].CellValue(i,'3io_bnd_cd') != "S"){
						sheetObjects[2].CellBackColor(i,'3io_bnd_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
					
				} else if (vrfyFlg[2] == "N") {
					/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 -  null값 제거 (CAHD 2015-06-25)  */
					/*N일때 Same으로 체크*/ 
//					if(sheetObjects[2].CellValue(i,'3io_bnd_cd') != "" ) {
					if(sheetObjects[2].CellValue(i,'3io_bnd_cd') != "S" ) {
						sheetObjects[2].CellBackColor(i,'3io_bnd_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// tml_ioc_flg
				if ( vrfyFlg[3] == "Y" ) {
					
					if(sheetObjects[2].CellValue(i,'3ioc_cd') != "I" && sheetObjects[2].CellValue(i,'3ioc_cd') != "O" && sheetObjects[2].CellValue(i,'3ioc_cd') != "S"){
						sheetObjects[2].CellBackColor(i,'3ioc_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
					
				} else if (vrfyFlg[3] == "N" ) {
					/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 -  null값 제거 (CAHD 2015-06-25)  */
					/*N일때 Same으로 체크*/ 
					
//					if(sheetObjects[2].CellValue(i,'3ioc_cd') != "" ){
					if(sheetObjects[2].CellValue(i,'3ioc_cd') != "S" ){
						sheetObjects[2].CellBackColor(i,'3ioc_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				if(sheetObjects[2].CellValue(i,'3curr_cd') == "" ){
					sheetObjects[2].CellBackColor(i,'3curr_cd') = sheetObjects[2].RgbColor(255,0,0);
					dataErrCount++;
				}
				
				// tml_aply_dt_flg
				if (vrfyFlg[4] == "Y"){
					
					if(sheetObjects[2].CellValue(i,'3wkdy_flg') == "" && sheetObjects[2].CellValue(i,'3sat_flg') == "" && sheetObjects[2].CellValue(i,'3sun_flg') == "" && sheetObjects[2].CellValue(i,'3hol_flg') == "" ){
						sheetObjects[2].CellBackColor(i,'3wkdy_flg') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3sat_flg') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3sun_flg') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3hol_flg') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
					
				} else if (vrfyFlg[4] == "N"){
					
					if(sheetObjects[2].CellValue(i,'3wkdy_flg') != "" || sheetObjects[2].CellValue(i,'3sat_flg') != "" || sheetObjects[2].CellValue(i,'3sun_flg') != "" || sheetObjects[2].CellValue(i,'3hol_flg') != "" ){
						sheetObjects[2].CellBackColor(i,'3wkdy_flg') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3sat_flg') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3sun_flg') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3hol_flg') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// tml_lane_flg
				if (vrfyFlg[5] == "Y"){
					if(sheetObjects[2].CellValue(i,'3lane_cd') == "" ){
						sheetObjects[2].CellBackColor(i,'3lane_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
					
				} else if (vrfyFlg[5] == "N"){
					/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 -  null값 제거 (CAHD 2015-06-25)  */
					/*N일때 Same으로 체크*/ 
//					if(sheetObjects[2].CellValue(i,'3lane_cd').trim() != "" ){
					if(sheetObjects[2].CellValue(i,'3lane_cd').trim() != "Sam" ){
						sheetObjects[2].CellBackColor(i,'3lane_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// tml_dcgo_aply_flg
				if (vrfyFlg[6] == "Y"){
					//[CHM-201539189]DG(NONE) 숨김처리로 값을 입력안하면 NONE DG를 선택한 것으로 본다.(CAH D 2015-12-30)
					if( sheetObjects[2].CellValue(i,'3dg_none')			== "" &&
							sheetObjects[2].CellValue(i,'3same_dg_none')		== "" &&
							sheetObjects[2].CellValue(i,'3same_dg')			== "" &&
							sheetObjects[2].CellValue(i,'3sep_dg_none')		== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n1st_clss_flg')== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n2nd_clss_flg')== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n3rd_clss_flg')== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n4th_clss_flg')== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n5th_clss_flg')== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n6th_clss_flg')== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n7th_clss_flg')== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n8th_clss_flg')== "" &&
							sheetObjects[2].CellValue(i,'3dcgo_n9th_clss_flg')== "" ) {
						sheetObjects[2].CellValue(i,'3dg_none') = "Y";
					}
					
					if( sheetObjects[2].CellValue(i,'3dg_none')			== "" &&
						sheetObjects[2].CellValue(i,'3same_dg_none')		== "" &&
						sheetObjects[2].CellValue(i,'3same_dg')			== "" &&
						sheetObjects[2].CellValue(i,'3sep_dg_none')		== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n1st_clss_flg')== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n2nd_clss_flg')== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n3rd_clss_flg')== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n4th_clss_flg')== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n5th_clss_flg')== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n6th_clss_flg')== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n7th_clss_flg')== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n8th_clss_flg')== "" &&
						sheetObjects[2].CellValue(i,'3dcgo_n9th_clss_flg')== "" ) {
						
						sheetObjects[2].CellBackColor(i,'3dg_none')			= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3same_dg_none')		= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3same_dg')			= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3sep_dg_none')		= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n1st_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n2nd_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n3rd_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n4th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n5th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n6th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n7th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n8th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n9th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
					
				} else if (vrfyFlg[6] == "N") {
					
					if( sheetObjects[2].CellValue(i,'3dg_none')			!= "" ||
						sheetObjects[2].CellValue(i,'3same_dg_none')		!= "" ||
						sheetObjects[2].CellValue(i,'3same_dg')			!= "" ||
						sheetObjects[2].CellValue(i,'3sep_dg_none')		!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n1st_clss_flg')!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n2nd_clss_flg')!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n3rd_clss_flg')!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n4th_clss_flg')!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n5th_clss_flg')!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n6th_clss_flg')!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n7th_clss_flg')!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n8th_clss_flg')!= "" ||
						sheetObjects[2].CellValue(i,'3dcgo_n9th_clss_flg')!= "" ) {
						
						sheetObjects[2].CellBackColor(i,'3dg_none')			= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3same_dg_none')		= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3same_dg')			= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3sep_dg_none')		= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n1st_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n2nd_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n3rd_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n4th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n5th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n6th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n7th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n8th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dcgo_n9th_clss_flg')= sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// tml_tr_vol_flg
				if (vrfyFlg[7] == "Y"){
					
					if(sheetObjects[2].CellValue(i,'3fm_tr_vol_val') == "" && sheetObjects[2].CellValue(i,'3to_tr_vol_val') == "" ){
						sheetObjects[2].CellBackColor(i,'3fm_tr_vol_val') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3to_tr_vol_val') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				} else if (vrfyFlg[7] == "N"){
					
					if(sheetObjects[2].CellValue(i,'3fm_tr_vol_val') != "" || sheetObjects[2].CellValue(i,'3to_tr_vol_val') != "" ){
						sheetObjects[2].CellBackColor(i,'3fm_tr_vol_val') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3to_tr_vol_val') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// tml_ovt_shft_flg
				if (vrfyFlg[8] == "Y"){
					
					if(sheetObjects[2].CellValue(i,'3tml_ovt_shft_cd') == "" ){
						sheetObjects[2].CellBackColor(i,'3tml_ovt_shft_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
					
				} else if (vrfyFlg[8] == "N"){
					
					if(sheetObjects[2].CellValue(i,'3tml_ovt_shft_cd') != "" ){
						sheetObjects[2].CellBackColor(i,'3tml_ovt_shft_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// tml_thc_flg
				if (vrfyFlg[9] == "Y"){
					
					if(sheetObjects[2].CellValue(i,'3thc_tp_cd') == "" ){
						sheetObjects[2].CellBackColor(i,'3thc_tp_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
					
				}else	if (vrfyFlg[9] != "Y"){
					
					if(sheetObjects[2].CellValue(i,'3thc_tp_cd') != "" ){
						sheetObjects[2].CellBackColor(i,'3thc_tp_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// rt_cntr_tpsz_flg
				if (vrfyFlg[20] == "N"){
					
					if( sheetObjects[2].CellValue(i,'3d2') > 0 || 
						sheetObjects[2].CellValue(i,'3d4') > 0 || 
						sheetObjects[2].CellValue(i,'3d5') > 0 || 
						sheetObjects[2].CellValue(i,'3d7') > 0 || 
						sheetObjects[2].CellValue(i,'3d8') > 0 || 
						sheetObjects[2].CellValue(i,'3d9') > 0 || 
						sheetObjects[2].CellValue(i,'3dw') > 0 || 
						sheetObjects[2].CellValue(i,'3dx') > 0 || 
						sheetObjects[2].CellValue(i,'3r4') > 0 || 
						sheetObjects[2].CellValue(i,'3r5') > 0 || 
						sheetObjects[2].CellValue(i,'3r7') > 0 || 
						sheetObjects[2].CellValue(i,'3r8') > 0 ||
						sheetObjects[2].CellValue(i,'3r9') > 0 ||
						sheetObjects[2].CellValue(i,'3f2') > 0 || 
						sheetObjects[2].CellValue(i,'3f4') > 0 || 
						sheetObjects[2].CellValue(i,'3o2') > 0 || 
						sheetObjects[2].CellValue(i,'3o4') > 0 || 
						sheetObjects[2].CellValue(i,'3o5') > 0 || 
						sheetObjects[2].CellValue(i,'3o7') > 0 ||
						sheetObjects[2].CellValue(i,'3s2') > 0 || 
						sheetObjects[2].CellValue(i,'3s4') > 0 || 
						sheetObjects[2].CellValue(i,'3t2') > 0 || 
						sheetObjects[2].CellValue(i,'3t4') > 0 || 
						sheetObjects[2].CellValue(i,'3a2') > 0 || 
						sheetObjects[2].CellValue(i,'3a4') > 0 || 
						sheetObjects[2].CellValue(i,'3a5') > 0 || 
						sheetObjects[2].CellValue(i,'3p2') > 0 || 
						sheetObjects[2].CellValue(i,'3p4') > 0 || 
						sheetObjects[2].CellValue(i,'3c2') > 0 || 
						sheetObjects[2].CellValue(i,'3c4') > 0 ||
						sheetObjects[2].CellValue(i,'3f5') > 0 ) {
						sheetObjects[2].CellBackColor(i,'3d2') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3d4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3d5') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3d7') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3d8') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3d9') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dw') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3dx') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3r4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3r5') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3r7') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3r8') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3r9') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3f2') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3f4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3o2') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3o4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3o5') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3o7') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3s2') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3s4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3t2') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3t4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3a2') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3a4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3a5') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3p2') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3p4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3c2') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3c4') = sheetObjects[2].RgbColor(255,0,0);
						sheetObjects[2].CellBackColor(i,'3f5') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// rt_teu_flg
				if (vrfyFlg[21] == "N"){
					
					if(sheetObjects[2].CellValue(i,'3teu_rate') > 0 ){
						sheetObjects[2].CellBackColor(i,'3teu_rate') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// rt_bx_flg
				if (vrfyFlg[22] == "N"){
					
					if(sheetObjects[2].CellValue(i,'3box_rate') > 0 ){
						sheetObjects[2].CellBackColor(i,'3box_rate') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// rt_mv_flg
				if (vrfyFlg[23] == "N"){
					
					if(sheetObjects[2].CellValue(i,'3move_rate') > 0 ){
						sheetObjects[2].CellBackColor(i,'3move_rate') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
				}
				
				// tml_trns_mod_flg
				if (vrfyFlg[25] == "Y"){
					
					if(sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') == "" ){
						sheetObjects[2].CellBackColor(i,'3tml_trns_mod_cd') = sheetObjects[2].RgbColor(255,0,0);
						dataErrCount++;
					}
					
				} else if(vrfyFlg[25] == "N"){
				    
					if((sheetObjects[2].CellValue(i, "3lgs_cost_cd")!= "TMFDMT")&&(sheetObjects[2].CellValue(i, "3lgs_cost_cd")!= "TMFDFL")){ // 2013.10.30 : TMFDMT에 대해서는 Mode(tml_trns_mod_flg)입력 할 수 있도록 수정함 -YSY 부장 요청(구주 Julian Matzner/HAMUOM 의 요청에 의함), TMFDFL도 예외 추가함(2013.11.18)
						/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 -  null값 제거 (CAHD 2015-06-25)  */
						/*N일때 Same으로 체크*/ 
//						if(sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') != "" ){
						if(sheetObjects[2].CellValue(i,'3tml_trns_mod_cd') != "S" ){
							sheetObjects[2].CellBackColor(i,'3tml_trns_mod_cd') = sheetObjects[2].RgbColor(255,0,0);
							dataErrCount++;
						}
					}
				}
				vrfyFlg  = "";
			}
		}
		return dataErrCount;
	}

	
	
	
    /*******************************************************************
     * 4. Agreement Storage Rate List 데이터 및 조합 검증 처리
     * 
     ******************************************************************/
	/**
	 * Storage Rate List Tab Data Verify. <br>
	 * @param{string}	beforeibflag	beforeibflag
	 **/
	function storageRateListVerify_test1(beforeibflag) {
		var sheetNo	= 5;
		var k		= sheetObjects[4].RowCount+1;

		var count	= 0;
		var n		= 1;

		var costCodeKey		= "";
		var costCodeVrfyFlg = "";

		verifyKey  	= new Array();
		verifyKey_1	= new Array();
		verifyKey_2	= new Array();
		verifyKey_3	= new Array();
		verifyKey_4	= new Array();

		var costCount	= 0;
		var countkey	= 0;
		costCodeNcount	= new Array();

		for( i = 1; i < k; i++ ) {
			if(costCodeKey == ""){
				costCodeKey		= sheetObjects[4].CellValue(i+2, sheetNo + "lgs_cost_cd");
				costCodeVrfyFlg	= sheetObjects[4].CellValue(i+2, sheetNo + "vrfyflg");
			}

			if(sheetObjects[4].CellValue(i+3, sheetNo+"lgs_cost_cd")!=""){

				if(sheetObjects[4].CellValue(i+2, sheetNo+"lgs_cost_cd") == sheetObjects[4].CellValue(i+3, sheetNo+"lgs_cost_cd")){
					costCount++;
				} else if(sheetObjects[4].CellValue(i+2, sheetNo+"lgs_cost_cd") != sheetObjects[4].CellValue(i+3, sheetNo+"lgs_cost_cd")){
					costCodeNcount[countkey]=costCodeKey+"#"+(costCount+1)+"#"+costCodeVrfyFlg;
					countkey++;
					costCodeKey  = "";
					costCodeVrfyFlg  = "";
					costCount	=0;
				}
			} else{
				break;
			}
		}//for..[]

		var rowStatus	= new Array();
		var rowAgmtType	= new Array();
		var rowFtDys	= new Array();

		var errCount	= 0;
		var totalErrCount	= 0;

		var local_count	= 0;
		var startRow	= 0;
		var lastRow		= 0;

		for(i=0;i<costCodeNcount.length;i++){

			var cost_code		= "";
			var cost_code_flg	= "";
			cost_code = costCodeNcount[i].split("#");
			cost_code_flg = cost_code[2].split("|");

			for( j = 0; j < cost_code[1]; j++ ) {
				// 14 : sto_free_dy_dcgo_tm_flg, 16 : sto_free_dy_dcgo_rt_flg
				if((cost_code_flg[14] == "Y" || cost_code_flg[16] == "Y") && 
					sheetObjects[4].CellValue(local_count+3, sheetNo+"tml_sto_agmt_tp_cd")=="FD"){
					//DG 구분용 비교 키
					verifyKey_1[j]	= sheetObjects[4].CellValue(local_count+3, sheetNo+"lgs_cost_cd")
									+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"tml_sto_agmt_tp_cd")
									+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"ft_dys")
									+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"io_bnd_cd")
									//+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"sat_flg_fd")
									//+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"sun_flg_fd")
									//+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"hol_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"fm_tr_dys")
									+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"to_tr_dys")
									+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo+"fp_teu_qty");
				}

				// 12 : sto_free_dy_io_bnd_flg
				if(cost_code_flg[12] == "Y" && sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") == "FD") {
					//bound 구분용 키
					verifyKey_2[j]	= sheetObjects[4].CellValue(local_count + 3, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "ft_dys")
									//+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo + "sat_flg_fd")
									//+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo + "sun_flg_fd")
									//+ "|" + sheetObjects[4].CellValue(local_count+3, sheetNo + "hol_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "sep_dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "sep_dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "fm_tr_dys")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "to_tr_dys")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "fp_teu_qty");
				}

				if(sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd") == "FD" ) {
					//FT Day 구분용 키
					verifyKey_3[j]	= sheetObjects[4].CellValue(local_count+3, sheetNo+"lgs_cost_cd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									//+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sat_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sun_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "hol_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "sep_dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "sep_dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "fm_tr_dys")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "to_tr_dys")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "fp_teu_qty");
				}

				if( cost_code_flg[17] == "Y" && 
					sheetObjects[4].CellValue(local_count+3, sheetNo+"ft_dys") == "" && 
					sheetObjects[4].CellValue(local_count+3, sheetNo+"tml_sto_agmt_tp_cd") == "FD") {
				//Tier Over Days 구분용 키
					verifyKey_4[j]	= sheetObjects[4].CellValue(local_count+3, sheetNo+"lgs_cost_cd")
			//						+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "tml_sto_agmt_tp_cd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "ft_dys")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "io_bnd_cd")
									//+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sat_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "sun_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(local_count + 3, sheetNo + "hol_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "sep_dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "same_dg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "sep_dg_none_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n1st_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n2nd_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n3rd_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n4th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n5th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n6th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n7th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n8th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "dcgo_n9th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(local_count + 3, sheetNo + "fp_teu_qty");
				}
				local_count++;
			}

			if( i == 0 ) {
				startRow	= 3;
				lastRow		= local_count + 2;
			}else if(i > 0){
				startRow	= lastRow + 1;
				lastRow		= local_count + 2;
			}
			
			for( jj = startRow; jj <= lastRow; jj++ ) {
				rowStatus[jj]	= sheetObjects[4].CellValue(jj, sheetNo + "ibflag");
				rowFtDys[jj]	= sheetObjects[4].CellValue(jj, sheetNo + "ft_dys");
				rowAgmtType[jj]	= sheetObjects[4].CellValue(jj, sheetNo + "tml_sto_agmt_tp_cd");
 			}

			// 20 : rt_cntr_tpsz_flg, 21 : rt_teu_flg, 22 : rt_bx_flg, 23 : rt_mv_flg
			if( cost_code_flg[20] == "Y" || cost_code_flg[21] == "Y" || 
				cost_code_flg[22] == "Y" || cost_code_flg[23] == "Y" ) {
				// STO_FP_TEU_FLG = 'Y' 인 COST CODE SRFDMT/SRNDMT의 경우  Agreement Type이 FP, free pool이 "0" 허용하도록 주석처리 (4347-08-28 YSY B)
//				errCount  = storage_cntr_rate_verify(startRow, lastRow) + errCount;
				errCount  = storage_cntr_rate_verify(startRow, lastRow, cost_code_flg) + errCount;
		 	}

			if(errCount == 0){
				// 14 : sto_free_dy_dcgo_tm_flg, 16 : sto_free_dy_dcgo_rt_flg
				if((cost_code_flg[14] == "Y" || cost_code_flg[16] == "Y") && verifyKey_1.length > 0){

					errCount = storage_dg_class_verify(verifyKey_1, startRow, lastRow, rowFtDys) + errCount;
					
					for(jj = 0;jj < verifyKey_1.length; jj++) {
						verifyKey_1 = Array();
					}
				}
			}

			if(errCount==0){
				if(cost_code_flg[12] == "Y" && verifyKey_2.length > 0){
					errCount  = storage_io_bnd_cd_verify(verifyKey_2, startRow, lastRow, rowFtDys)+errCount;
					for(jj=0;jj<verifyKey_2.length;jj++){
						verifyKey_2 = Array();
					}
				}
			}


			if(errCount==0){
				if(verifyKey_3.length>0){
					errCount  = storage_ft_day_verify(verifyKey_3, startRow, lastRow)+errCount;
					for(jj=0;jj<verifyKey_3.length;jj++){
						verifyKey_3 = Array();
					}
				}
			}

			if(errCount==0){
				if(cost_code_flg[17]=="Y" && verifyKey_4.length>0){
					errCount  = storage_tr_vol_val_verify(verifyKey_4, startRow, lastRow, rowFtDys)+errCount;
					for(jj=0;jj<verifyKey_4.length;jj++){
						verifyKey_4 = Array();
					}
				}
			}

			for(jj=0;jj<verifyKey_1.length;jj++){
				verifyKey_1 = Array();
			}	

			for(jj=0;jj<verifyKey_2.length;jj++){
				verifyKey_2 = Array();
			}

			for(jj=0;jj<verifyKey_3.length;jj++){
				verifyKey_3 = Array();
			}

			for(jj=0;jj<verifyKey_4.length;jj++){
				verifyKey_4 = Array();
			}

			totalErrCount = errCount + totalErrCount;

			errCount = 0;

			for(jj=startRow;jj<=lastRow;jj++){
				sheetObjects[4].RowStatus(jj) = beforeibflag[jj-3];
				if(sheetObjects[4].CellValue(jj, sheetNo+"verify_result")==""){
					sheetObjects[4].CellBackColor(jj,1) = sheetObjects[4].RgbColor(0,0,255);
				}else if(sheetObjects[4].CellValue(jj, sheetNo+"verify_result")!=""){
					sheetObjects[4].CellBackColor(jj,1) = sheetObjects[4].RgbColor(255,0,0);
				}
			}
			//rowStatus[jj] = Array();
			rowFtDys = Array();
		}
		
		if(totalErrCount>0){
			return false;
		}else if(totalErrCount==0){
			return true;
		}
		totalErrCount =0;
	}

	/**
	 * Storage Rate List Tab Io Bound Code Data Verify. <br>
	 * @param{verifyKey_2}	verifyKey_2	verifyKey_2
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 * @param{rowFtDys}		rowFtDys	rowFtDys
	 **/
	function storage_io_bnd_cd_verify(verifyKey_2, startRow, lastRow, rowFtDys){
		var i;
		var j=0;
		var sheetNo = 5;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i=0;i<verifyKey_2.length;i++){

			if(i==0){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_2[i];
				j++
			}

			if(dupTempKey!=verifyKey_2[i]){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_2[i];
				j++;
			}
		}

		var dupString		= new Array();
		var dupStringSheet	= new Array();
		var dupStringKey	= new Array();
		var seqDupRowKey	= new Array();

		for(i = 0; i < dupkey.length; i++) {
			dupString[i]	= sheetObjects[4].CellValue(dupkey[i], sheetNo + "lgs_cost_cd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "tml_agmt_vol_ut_cd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "tml_sto_agmt_tp_cd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "ft_dys")
							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo + "sat_flg_fd")
							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo + "sun_flg_fd")
							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo + "hol_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dg_none_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "same_dg_none_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "same_dg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "sep_dg_none_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg_fd")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dg_none_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "same_dg_none_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "same_dg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "sep_dg_none_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n1st_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n2nd_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n3rd_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n4th_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n5th_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n6th_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n7th_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n8th_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "dcgo_n9th_clss_flg_r")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "fm_tr_dys")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "to_tr_dys")
							+ "|" + sheetObjects[4].CellValue(dupkey[i], sheetNo + "fp_teu_qty");
			k = 0;

			for(var j = startRow; j <= lastRow; j++) {
				dupStringSheet[j]	= sheetObjects[4].CellValue(j, sheetNo + "lgs_cost_cd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "tml_agmt_vol_ut_cd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "tml_sto_agmt_tp_cd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "ft_dys")
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo + "sat_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo + "sun_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo + "hol_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "same_dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "same_dg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "sep_dg_none_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n1st_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n2nd_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n3rd_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n4th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n5th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n6th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n7th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n8th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n9th_clss_flg_fd")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dg_none_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "same_dg_none_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "same_dg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "sep_dg_none_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n1st_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n2nd_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n3rd_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n4th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n5th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n6th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n7th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n8th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "dcgo_n9th_clss_flg_r")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "fm_tr_dys")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "to_tr_dys")
									+ "|" + sheetObjects[4].CellValue(j, sheetNo + "fp_teu_qty");

				if(dupString[i] == dupStringSheet[j] && sheetObjects[4].CellValue(j, sheetNo + "ft_dys") == "F") {
					k++;
					dupStringKey[j] = sheetObjects[4].CellValue(j, sheetNo + "io_bnd_cd");
				} else {
					k++;
					dupStringKey[j] =  "";
				}
			}
			var err_count = storage_ioBoundFun(dupStringKey, startRow);
			dupStringKey = Array();
		}

		return err_count;
	}

	/**
	 * Storage Rate List Tab Io Bound Verify.<br>
	 * @param{dupStringKey}	dupStringKey	dupStringKey
	 * @param{startRow}		startRow		startRow
	 **/
	function storage_ioBoundFun(dupStringKey, startRow){
		var inputString = "";
		var err_count = 0;
		for(var i = startRow; i < dupStringKey.length; i++) {
			if(dupStringKey[i] != ""){
				inputString  = inputString + dupStringKey[i];
			}
		}

		if(inputString == "S" || inputString == "IO" || inputString == "OI"){
			err_count = 0;
		} else{
			err_count = 1;
		}

		if(err_count > 0){
			err_count  = 0;
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != ""){
					sheetObjects[4].CellValue2(i, "5verify_result") = "IO Bound Colume Error";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
					err_count++;
				}
			}
		} else if(err_count == 0){
			for(var i = startRow; i < dupStringKey.length; i++) {
				if(dupStringKey[i] != ""){
					sheetObjects[4].CellValue2(i, "5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				}
			}
		}
		return err_count;
	}

	/**
	 * Storage Rate List Tab Ft Day Data Verify. <br>
	 * @param{verifyKey_4}	verifyKey_4	verifyKey_4
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function storage_ft_day_verify(verifyKey_4, startRow, lastRow){
		var i;
		var j		= 0;
		var sheetNo	= 5;

		var dupString		= new Array();
		var dupStringSheet	= new Array();
		var dupStringKey	= new Array();
		var seqDupRowKey	= new Array();

		for(var j=startRow;j<=lastRow;j++){
			dupStringSheet[j]	= sheetObjects[4].CellValue(j, sheetNo+"lgs_cost_cd");
			k=0;
			if(sheetObjects[4].CellValue(j, sheetNo+"tml_sto_agmt_tp_cd")=="FD"){
				k++;
				dupStringKey[j] = sheetObjects[4].CellValue(j, sheetNo+"ft_dys");				
				if(sheetObjects[4].CellValue(j, sheetNo+"ft_dys")==""){
					dupStringKey[j] =  "NaN";					
				}
			}else{
				k++;
				dupStringKey[j] =  "NaN";				
			}
		}
		var err_count = storage_ft_dayFun(dupStringKey, startRow, lastRow);
		dupStringKey = Array();

		return err_count;
	}

	/**
	 * Storage Rate List Tab Ft Day Data. <br>
	 * @param{dupStringKey}	dupStringKey	dupStringKey
	 * @param{startRow}		startRow		startRow
	 * @param{lastRow}		lastRow			lastRow
	 **/
	function storage_ft_dayFun(dupStringKey, startRow, lastRow){
		var inputString = "";
		var err_count = 0;
		var countF = 0;
		var countNaN = 0;
		for(var i=startRow;i<dupStringKey.length;i++){
			if(dupStringKey[i]!=""){
				if(dupStringKey[i]=="F"){
					countF++;
				}else if(dupStringKey[i]=="NaN"){
					countNaN++;
				}
			}
		}
				
		if(countF>0 && countNaN>0){
			err_count = 0;
		}else{
			err_count = 1;
		}

		/**
		if(inputString == "FNaN"){
				err_count = 0;
		}else{
				err_count = 1;
		}
		**/

		if(err_count > 0){
			err_count  = 0;
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[4].CellValue2(i,"5verify_result") = "FT Day Colume Error";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
					err_count++;
				}
			}
		} else if(err_count == 0){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				}
			}
		}
		return err_count;
	}

	/**
	 * Storage Rate List Tab DG Class Data Verify. <br>
	 * @param{verifyKey_1}	verifyKey_1	verifyKey_1
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 * @param{rowFtDys}		rowFtDys	rowFtDys
	 **/
	function storage_dg_class_verify(verifyKey_1, startRow, lastRow, rowFtDys){
		var i;
		var j=0;
		var sheetNo = 5;
		var dupkey = new Array();
		var dupTempKey = "";
		var rowFtDys1 = new Array();

		for(i=0;i<verifyKey_1.length;i++){
			if(i==0){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_1[i];
				j++
			}

			if(dupTempKey!=verifyKey_1[i]){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_1[i];
				j++;
			}
		}

		var dupString 		= new Array();
		var dupStringSheet 	= new Array();
		var dupStringKey 	= new Array();
		var seqDupRowKey	= new Array();

		for(i=0;i<dupkey.length;i++){
			dupString[i]	= sheetObjects[4].CellValue(dupkey[i], sheetNo+"lgs_cost_cd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"tml_sto_agmt_tp_cd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"ft_dys")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"io_bnd_cd")
	
							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sat_flg_fd")
							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sun_flg_fd")
							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"hol_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"fm_tr_dys")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"to_tr_dys")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"fp_teu_qty");

			k=0;

			for(var j=startRow;j<=lastRow;j++){
				dupStringSheet[j]	= sheetObjects[4].CellValue(j, sheetNo+"lgs_cost_cd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"tml_sto_agmt_tp_cd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"ft_dys")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"io_bnd_cd")
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sat_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sun_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo+"hol_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"fm_tr_dys")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"to_tr_dys")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"fp_teu_qty");

				if(dupString[i]==dupStringSheet[j]){
					k++;
					if(rowFtDys[j]=="F"){
						dupStringKey[j] = sheetObjects[4].CellValue(j, sheetNo+"dg_none_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"same_dg_none_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"same_dg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sep_dg_none_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n1st_clss_flg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n2nd_clss_flg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n3rd_clss_flg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n4th_clss_flg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n5th_clss_flg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n6th_clss_flg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n7th_clss_flg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n8th_clss_flg_fd")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n9th_clss_flg_fd");
					}else if(rowFtDys[j]==""){
						dupStringKey[j] = sheetObjects[4].CellValue(j, sheetNo+"dg_none_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"same_dg_none_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"same_dg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sep_dg_none_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n1st_clss_flg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n2nd_clss_flg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n3rd_clss_flg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n4th_clss_flg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n5th_clss_flg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n6th_clss_flg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n7th_clss_flg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n8th_clss_flg_r")
										+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n9th_clss_flg_r");

					}

				}else{
					k++;
					dupStringKey[j] =  "NaN";
				}
			}
			var err_count = storage_dg_classFun(dupStringKey, startRow, rowFtDys);
			dupStringKey = Array();
		}
		return err_count;
	}

	/**
	 * Storage Rate List Tab DG Class Data Verify. <br>
	 * @param{dupStringKey}	dupStringKey	dupStringKey
	 * @param{startRow}		startRow	startRow
	 * @param{rowFtDys}		rowFtDys	rowFtDys
	 **/
	function storage_dg_classFun(dupStringKey, startRow, rowFtDys){
		var inputString = "";
		var err_count = 0;
		var tempArrayHdr ="";	   		 						//최초 저장 배열
		var tempArrayDtl ="";	   		 						//최초 저장 배열
		var tempArrayHdrKey ="";	   						//임시 저장 배열로 최초 저장 배열과 Y or "" 비교 체크 배열
		var tempArrayDtlKey ="";	   						//임시 저장 배열로 최초 저장 배열과 Y or "" 비교 체크 배열
		var tempHdrString = "";
		var tempDtlString = "";
		var tempstartRow =  startRow;

		for(var i=startRow;i<dupStringKey.length;i++){
			if(dupStringKey[i]!="NaN"){
				if(tempstartRow<i){
					tempArrayHdrKey = dupStringKey[i].split("|");
					for(var j=0;j<3;j++){
						if(tempArrayHdr[j]=="Y" && tempArrayHdrKey[j]=="Y"){
							tempArrayHdr[j]="S";
						}else if((tempArrayHdr[j]=="" && tempArrayHdrKey[j]=="Y") || (tempArrayHdr[j]=="Y" && tempArrayHdrKey[j]=="")){
							tempArrayHdr[j]="Y";
						}else if(tempArrayHdr[j]=="" && tempArrayHdrKey[j]==""){
							tempArrayHdr[j]="";
						}else if((tempArrayHdr[j]=="S" && tempArrayHdrKey[j]=="Y") || (tempArrayHdr[j]=="S" && tempArrayHdrKey[j]=="")){
							tempArrayHdr[j]="S";
						}
					}

					tempArrayDtlKey = dupStringKey[i].split("|");
					for(j=3;j<13;j++){
						if(tempArrayDtl[j]=="Y" && tempArrayDtlKey[j]=="Y"){
							tempArrayDtl[j]="S";
						}else if((tempArrayDtl[j]=="" && tempArrayDtlKey[j]=="Y") || (tempArrayDtl[j]=="Y" && tempArrayDtlKey[j]=="")){
							tempArrayDtl[j]="Y";
						}else if(tempArrayDtl[j]=="" && tempArrayDtlKey[j]==""){
							tempArrayDtl[j]="";
						}else if((tempArrayDtl[j]=="S" && tempArrayDtlKey[j]=="Y") || (tempArrayDtl[j]=="S" && tempArrayDtlKey[j]=="")){
							tempArrayDtl[j]="S";
						}
					}
				}else{
					tempArrayHdr= dupStringKey[i].split("|");
					tempArrayDtl= dupStringKey[i].split("|");
				}
			}else{
				tempstartRow  = tempstartRow +1;
			}
			tempArrayHdrKey = "";
			tempArrayDtlKey = "";
		}

		for(var k=0;k<3;k++){
			tempHdrString = tempHdrString+"|"+tempArrayHdr[k];
		}

		for(var k=3;k<13;k++){
			tempDtlString = tempDtlString+"|"+tempArrayDtl[k];
		}

		if(tempHdrString=="|Y||" && tempDtlString == "||||||||||"){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!="NaN"){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				}
			}
		}else if(tempHdrString=="||Y|Y" && tempDtlString=="||||||||||"){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!="NaN"){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				}
			}
		}else if(tempHdrString=="|||" && tempDtlString=="|Y|Y|Y|Y|Y|Y|Y|Y|Y|Y"){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!="NaN"){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				}
			}
		}else{
			/**
				if(rowFtDys[i-startRow]=="F"){
						for(var i=startRow;i<dupStringKey.length;i++){
								if(dupStringKey[i]!="NaN"){
										sheetObjects[4].CellValue2(i,"5verify_result") = "DG for Free Day Colume for Error";
										sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
										err_count++;
								}

						}
				}
				if(rowFtDys[i-startRow]==""){
						for(var i=startRow;i<dupStringKey.length;i++){
								if(dupStringKey[i]!="NaN"){
										sheetObjects[4].CellValue2(i,"5verify_result") = "DG for Rate Colume for Error";
										sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
										err_count++;
								}
						}
				}
			**/
			for(var i=startRow;i<dupStringKey.length;i++){
				if(rowFtDys[i]=="F"){
					if(dupStringKey[i]!="NaN"){
						sheetObjects[4].CellValue2(i,"5verify_result") = "DG for Free Day Colume for Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						err_count++;
					}
				}
				if(rowFtDys[i]==""){
					if(dupStringKey[i]!="NaN"){
						sheetObjects[4].CellValue2(i,"5verify_result") = "DG for Rate Colume for Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						err_count++;
					}
				}
			}
		}
		return err_count;
	}

	/**
	 * Storage Rate List Tab Tier Volume Value Data Verify. <br>
	 * @param{verifyKey_4}	verifyKey_4	verifyKey_4
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 * @param{rowFtDys}		rowFtDys	rowFtDys
	 **/
	function storage_tr_vol_val_verify(verifyKey_4, startRow, lastRow, rowFtDys){
		var i;
		var j=0;
		var sheetNo = 5;
		var dupkey = new Array();
		var dupTempKey = "";

		for(i=0;i<verifyKey_4.length;i++){

			if(i==0){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_4[i];
				j++
			}

			if(dupTempKey!=verifyKey_4[i]){
				dupkey[j]=i+startRow;
				dupTempKey = verifyKey_4[i];
				j++;
			}
		}

		var dupString 		= new Array();
		var dupStringSheet 	= new Array();
		var dupStringKey 	= new Array();
		var seqDupRowKey	= new Array();

		for(i=0;i<dupkey.length;i++){
			dupString[i]	= sheetObjects[4].CellValue(dupkey[i], sheetNo+"lgs_cost_cd")
//										+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"tml_agmt_vol_ut_cd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"tml_sto_agmt_tp_cd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"ft_dys")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"io_bnd_cd")

							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sat_flg_fd")
							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sun_flg_fd")
							//+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"hol_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dg_none_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"same_dg_none_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"same_dg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sep_dg_none_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n1st_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n2nd_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n3rd_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n4th_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n5th_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n6th_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n7th_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n8th_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n9th_clss_flg_fd")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dg_none_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"same_dg_none_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"same_dg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"sep_dg_none_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n1st_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n2nd_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n3rd_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n4th_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n5th_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n6th_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n7th_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n8th_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"dcgo_n9th_clss_flg_r")
							+"|"+ sheetObjects[4].CellValue(dupkey[i], sheetNo+"fp_teu_qty");

			k=0;

			for(var j=startRow;j<=lastRow;j++){
				dupStringSheet[j]	= sheetObjects[4].CellValue(j, sheetNo+"lgs_cost_cd")
//														+"|"+ sheetObjects[4].CellValue(j, sheetNo+"tml_agmt_vol_ut_cd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"tml_sto_agmt_tp_cd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"ft_dys")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"io_bnd_cd")
	
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sat_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sun_flg_fd")
									//+"|"+ sheetObjects[4].CellValue(j, sheetNo+"hol_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dg_none_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"same_dg_none_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"same_dg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sep_dg_none_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n1st_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n2nd_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n3rd_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n4th_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n5th_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n6th_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n7th_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n8th_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n9th_clss_flg_fd")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dg_none_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"same_dg_none_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"same_dg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"sep_dg_none_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n1st_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n2nd_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n3rd_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n4th_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n5th_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n6th_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n7th_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n8th_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"dcgo_n9th_clss_flg_r")
									+"|"+ sheetObjects[4].CellValue(j, sheetNo+"fp_teu_qty");
				if(dupString[i]==dupStringSheet[j] && sheetObjects[4].CellValue(j, sheetNo+"ft_dys")==""){
					k++;
					dupStringKey[j] = sheetObjects[4].CellValue(j, sheetNo+"fm_tr_dys")+"|"+sheetObjects[4].CellValue(j, sheetNo+"to_tr_dys");
				}else{
					k++;
					dupStringKey[j] =  "";
				}
			}
			var err_count = storage_tr_vol_valFun(dupStringKey, startRow, rowFtDys);
			dupStringKey = Array();
		}

		return err_count;
	}

	/**
	 * Storage Rate List Tab Tier Volume Value Data Verify. <br>
	 * @param{dupStringKey}	dupStringKey	dupStringKey
	 * @param{startRow}		startRow	startRow
	 * @param{rowFtDys}		rowFtDys	rowFtDys
	 **/
	function storage_tr_vol_valFun(dupStringKey, startRow, rowFtDys){
		var inputString = "";
		var err_count = 0;
		var tempArray ="";	   		 						//최초 저장 배열
		var tempArrayKey ="";	   							//임시 저장 배열로 최초 저장 배열과 Y or "" 비교 체크 배열
		var tempString = "";
		var tempstartRow = startRow;

		for(var i=startRow;i<dupStringKey.length;i++){
			if(dupStringKey[i]!=""){
				if(tempstartRow<i){

					tempArrayKey = dupStringKey[i].split("|");

					if(tempArray[1].toUpperCase()=="MAX"){
						tempArray[1]  = 999;
					}

					if(tempArrayKey[1].toUpperCase()=="MAX"){
						tempArrayKey[1]  = 999;
					}
					
					if(tempArray[0] < 1 || tempArrayKey[0] < 1){
						err_count = 1;
					}
					
					if(tempArray[0]==tempArrayKey[0]){
						err_count = 1;
					}
					
					if(tempArray[1]!=(parseInt(tempArrayKey[0])-1)){
						err_count = 1;
					}else if(tempArray[1]==(parseInt(tempArrayKey[0])-1)){
						tempArray[1] = tempArrayKey[1];
					}
				}else{
					tempArray= dupStringKey[i].split("|");
					if(tempArray[1].toUpperCase()=="MAX"){
						tempArray[1]  = 999;
					}
				}
			}else{
				tempstartRow  = tempstartRow +1;
			}

			tempArrayKey = "";
		}


		if(tempArray[0]==1 && tempArray[1]==999){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				}
			}
		}else{
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[4].CellValue2(i,"5verify_result") = "Tier Over Days Colume Error";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
					err_count++;
				}
			}
		}

		if(err_count>0){
			for(var i=startRow;i<dupStringKey.length;i++){
				if(dupStringKey[i]!=""){
					sheetObjects[4].CellValue2(i,"5verify_result") = "Tier Over Days Colume Error";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
					err_count++;
				}
			}
		}
		return err_count;
	}

	/**
	 * Storage Rate List Tab Container Rate Data Verify. <br>
	 * @param{startRow}		startRow	startRow
	 * @param{lastRow}		lastRow		lastRow
	 **/
	function storage_cntr_rate_verify(startRow, lastRow, cost_code_flg){
		var tr_rate = 0;
		var tr_days = 0;
		var tr_total = 0;
		var teu_rate = 0;
		var box_rate = 0;
		var move_rate = 0;
		var ton_rate = 0;
		var cntrRateErrCount =0;
		var i=0;
		var j=0;

		for(i=startRow;i<=lastRow;i++){
			for(var l=0; l<arrCntrTpSz.length; l++){
				tr_days = parseInt(sheetObjects[4].CellValue(i,"5"+arrCntrTpSz[l]+"_fd"))+tr_days ;
			}

			for(var l=0; l<arrCntrTpSz.length; l++){
				tr_rate = parseInt(sheetObjects[4].CellValue(i,"5"+arrCntrTpSz[l]+"_r"))+tr_rate ;
			}

			tr_total	= tr_rate + tr_days;
			teu_rate  = sheetObjects[4].CellValue(i,"5teu_rate");
			box_rate  = sheetObjects[4].CellValue(i,"5box_rate");
			move_rate  = sheetObjects[4].CellValue(i,"5move_rate");
			ton_rate  = sheetObjects[4].CellValue(i,"5ton_rate");

			if(sheetObjects[4].CellValue(i,"5tml_sto_agmt_tp_cd")=="FD" && sheetObjects[4].CellValue(i, '5ft_dys')==""){
				
				// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)	
				if(sheetObjects[4].CellValue(i,"5tml_agmt_vol_ut_cd")=="C"){
					if(teu_rate == 0 && box_rate == 0 && move_rate == 0 && ton_rate == 0) {
						sheetObjects[4].CellValue2(i,"5verify_result") = "";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
					}else{
						sheetObjects[4].CellValue2(i,"5verify_result") = "Days / Rate Colume Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						cntrRateErrCount++;
					}
				}else if(sheetObjects[4].CellValue(i,"5tml_agmt_vol_ut_cd")=="T"){
					if(tr_total == 0 && teu_rate > 0 && box_rate == 0 && move_rate == 0 && ton_rate == 0) {
						sheetObjects[4].CellValue2(i,"5verify_result") = "";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
					}else{
						sheetObjects[4].CellValue2(i,"5verify_result") = "Days / Rate Colume Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						cntrRateErrCount++;
					}
				// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)	
				}else if(sheetObjects[4].CellValue(i,"5tml_agmt_vol_ut_cd")=="B"){
					if(tr_total == 0 && teu_rate == 0 && box_rate > 0 && move_rate == 0 && ton_rate == 0) {
						sheetObjects[4].CellValue2(i,"5verify_result") = "";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
					}else{
						sheetObjects[4].CellValue2(i,"5verify_result") = "Days / Rate Colume Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						cntrRateErrCount++;
					}
				}else if(sheetObjects[4].CellValue(i,"5tml_agmt_vol_ut_cd")=="M"){
					if(tr_total == 0 && teu_rate == 0 && box_rate == 0 && move_rate > 0 && ton_rate == 0) {
						sheetObjects[4].CellValue2(i,"5verify_result") = "";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
					}else{
						sheetObjects[4].CellValue2(i,"5verify_result") = "Days / Rate Colume Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						cntrRateErrCount++;
					}
				// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)	
				} else if (sheetObjects[4].CellValue(i,"5tml_agmt_vol_ut_cd") == "W") {
					if(tr_total == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0 && ton_rate > 0) {
						sheetObjects[4].CellValue2(i,"5verify_result") = "";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
					}else{
						sheetObjects[4].CellValue2(i,"5verify_result") = "Days / Rate Colume Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						cntrRateErrCount++;
					}
				}
				/**
				if(tr_rate == 0 && tr_days == 0 && teu_rate == 0 && box_rate == 0 && move_rate == 0){
						sheetObjects[4].CellValue2(i,"5verify_result") = "Days / Rate Colume Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						cntrRateErrCount++;
				}
				**/

				if(sheetObjects[4].CellValue(i,"5ft_dys")=="" && sheetObjects[4].CellValue(i,"5tml_agmt_vol_ut_cd")=="C"){
					if(tr_days==0){
						sheetObjects[4].CellValue2(i,"5verify_result") = "";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
					}else if(tr_days>0){
						sheetObjects[4].CellValue2(i,"5verify_result") = "Days Colume Error";
						sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
						cntrRateErrCount++;
					}
				}
			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
			}else if(sheetObjects[4].CellValue(i,"5tml_sto_agmt_tp_cd")=="FD" && sheetObjects[4].CellValue(i, '5ft_dys')=="F"){
				if((tr_rate+move_rate+box_rate+teu_rate+ton_rate) > 0 ){
					sheetObjects[4].CellValue2(i,"5verify_result") = "Rate Colume Error";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
					cntrRateErrCount++;
				}else if(tr_days >0 ){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				}

			}else if(sheetObjects[4].CellValue(i,"5tml_sto_agmt_tp_cd")=="FP"){
				if((tr_rate+tr_days+move_rate+ton_rate)>0){
					sheetObjects[4].CellValue2(i,"5verify_result") = "Days / Rate Colume Error";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
					cntrRateErrCount++;
				}else if((tr_rate+tr_days+box_rate+move_rate+ton_rate)==0 && teu_rate>0){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				}
				if(sheetObjects[4].CellValue(i,"5fp_teu_qty")>0){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(0,0,255);
				// STO_FP_TEU_FLG = 'Y' 인 COST CODE SRFDMT/SRNDMT의 경우  Agreement Type이 FP, free pool이 "0" 허용하도록 주석처리 (4347-08-28 YSY B)
				}  else if(cost_code_flg[19] ='Y' && sheetObjects[4].CellValue(i,"5fp_teu_qty")==0){
					sheetObjects[4].CellValue2(i,"5verify_result") = "";
					sheetObjects[4].CellBackColor(i, 1) = sheetObjects[4].RgbColor(0, 0, 255);
				}  else if(sheetObjects[4].CellValue(i,"5fp_teu_qty")==0){
					sheetObjects[4].CellValue2(i,"5verify_result") = "Pool TEU Colume Error";
					sheetObjects[4].CellBackColor(i,1) = sheetObjects[4].RgbColor(255,0,0);
					cntrRateErrCount++;
				}
			}
			tr_rate  = 0;
			tr_days  = 0;
		}
		return cntrRateErrCount;
	}

	/**
	 * Storage Rate List Tab Data Verify. <br>
	 **/
	function dataStorageVerify() {
		var k = sheetObjects[4].RowCount+3;
		var dataErrCount 		= 0;
		var vrfyFlg ;
		var vrfyRateSum = 0;
		var vrfyDysSum 	= 0;

		for(var i=3;i<k;i++){
			vrfyFlg = sheetObjects[7].CellValue(i-2, 1).split("|");

			sheetObjects[4].CellValue2(i,"5vrfyflg") = sheetObjects[7].CellValue(i-2, 1);
			sheetObjects[4].RowBackColor(i) = sheetObjects[4].RgbColor(255,255,255);

			if(sheetObjects[4].CellValue(i, "5lgs_cost_cd") != sheetObjects[7].CellValue(i-2,0)){
				sheetObjects[4].CellBackColor(i,"5lgs_cost_cd") = sheetObjects[4].RgbColor(255,0,0);
				dataErrCount++;
			}

			if(sheetObjects[4].CellValue(i, "5lgs_cost_cd") == ""){
				sheetObjects[4].CellBackColor(i,"5lgs_cost_cd") = sheetObjects[4].RgbColor(255,0,0);
				dataErrCount++;
			}

			if(sheetObjects[4].CellValue(i, "5curr_cd") == ""){
				sheetObjects[4].CellBackColor(i,"5curr_cd") = sheetObjects[4].RgbColor(255,0,0);
				dataErrCount++;
			}

			vrfyDysSum	= parseInt(sheetObjects[4].CellValue(i,'5d2_fd'))	
						+ parseInt(sheetObjects[4].CellValue(i,'5d4_fd')) 
						+ parseInt(sheetObjects[4].CellValue(i,'5d5_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5d7_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5d8_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5d9_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5dw_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5dx_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5r4_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5r5_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5r7_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5r8_fd')) 
						+ parseInt(sheetObjects[4].CellValue(i,'5r9_fd')) 
						+ parseInt(sheetObjects[4].CellValue(i,'5f2_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5f4_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5o2_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5o4_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5o5_fd')) 
						+ parseInt(sheetObjects[4].CellValue(i,'5o7_fd')) 
						+ parseInt(sheetObjects[4].CellValue(i,'5s2_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5s4_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5t2_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5t4_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5a2_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5a4_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5a5_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5p2_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5p4_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5c2_fd'))  
						+ parseInt(sheetObjects[4].CellValue(i,'5c4_fd'))
						+ parseInt(sheetObjects[4].CellValue(i,'5f5_fd'));
			
			vrfyRateSum	= parseInt(sheetObjects[4].CellValue(i,'5d2_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5d4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5d5_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5d7_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5d8_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5d9_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5dw_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5dx_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5r4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5r5_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5r7_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5r8_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5r9_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5f2_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5f4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5o2_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5o4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5o5_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5o7_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5s2_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5s4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5t2_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5t4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5a2_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5a4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5a5_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5p2_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5p4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5c2_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5c4_r'))
						+ parseInt(sheetObjects[4].CellValue(i,'5f5_r'));

			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
			if( sheetObjects[4].CellValue(i, '5tml_agmt_vol_ut_cd') == "C" &&
				sheetObjects[4].CellValue(i, '5ft_dys') == "" ) {
				
				if(sheetObjects[4].CellValue(i, '5teu_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i,'5teu_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5box_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i,'5box_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5move_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i,'5move_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
					
				} else if(sheetObjects[4].CellValue(i, '5ton_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i,'5ton_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
				
			} else if(sheetObjects[4].CellValue(i, '5tml_agmt_vol_ut_cd') == "T" &&
					sheetObjects[4].CellValue(i, '5ft_dys') == "" ) {
				
				if(vrfyDysSum > 0 || vrfyRateSum > 0 ){
				} else if(sheetObjects[4].CellValue(i, '5teu_rate') == 0.00 ) {
					sheetObjects[4].CellBackColor(i,'5teu_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5box_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i,'5box_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5move_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i,'5move_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5ton_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i,'5ton_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
					
				}
			} else if(sheetObjects[4].CellValue(i, '5tml_agmt_vol_ut_cd') == "B" &&
					sheetObjects[4].CellValue(i, '5ft_dys') == "" ) {
				if(sheetObjects[4].CellValue(i, '5teu_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i,'5teu_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
					
				} else if(sheetObjects[4].CellValue(i, '5box_rate') == 0.00 ) {
					sheetObjects[4].CellBackColor(i,'5box_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5move_rate') > 0){
					sheetObjects[4].CellBackColor(i,'5move_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5ton_rate') > 0){
					sheetObjects[4].CellBackColor(i,'5ton_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
					
				}
			} else if(sheetObjects[4].CellValue(i, '5tml_agmt_vol_ut_cd') == "M" &&
					sheetObjects[4].CellValue(i, '5ft_dys') == "") {
				if(sheetObjects[4].CellValue(i, '5teu_rate') > 0){
					sheetObjects[4].CellBackColor(i,'5teu_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
									
				} else if(sheetObjects[4].CellValue(i, '5box_rate') > 0){
					sheetObjects[4].CellBackColor(i,'5box_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
					
				} else if(sheetObjects[4].CellValue(i, '5move_rate') == 0.00 ){
					sheetObjects[4].CellBackColor(i,'5move_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5ton_rate') > 0 ){
					sheetObjects[4].CellBackColor(i,'5ton_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
					
				}
			// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)				
			} else if (sheetObjects[4].CellValue(i, '5tml_agmt_vol_ut_cd') == "W" &&
						sheetObjects[4].CellValue(i, '5ft_dys') == "") {
				
				if (sheetObjects[4].CellValue(i, '5teu_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i, '5teu_rate') = sheetObjects[4].RgbColor(255, 0, 0);
					dataErrCount++;
					
				} else if (sheetObjects[4].CellValue(i, '5box_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i, '5box_rate') = sheetObjects[4].RgbColor(255, 0, 0);
					dataErrCount++;
					
				} else if (sheetObjects[4].CellValue(i, '5move_rate') > 0 ) {
					sheetObjects[4].CellBackColor(i, '5move_rate') = sheetObjects[4].RgbColor(255, 0, 0);
					dataErrCount++;
					
				} else if (sheetObjects[4].CellValue(i, '5ton_rate') == 0.00 ) {
					sheetObjects[4].CellBackColor(i, '5ton_rate') = sheetObjects[4].RgbColor(255, 0, 0);
					dataErrCount++;
					
				}
			}

			if(sheetObjects[4].CellValue(i, '5ft_dys') == "F"){
				
				if(sheetObjects[4].CellValue(i, '5teu_rate') > 0){
					sheetObjects[4].CellBackColor(i,'5teu_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
					
				} else if(sheetObjects[4].CellValue(i, '5box_rate') > 0){
					sheetObjects[4].CellBackColor(i,'5box_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;

				} else if(sheetObjects[4].CellValue(i, '5move_rate') > 0){
					sheetObjects[4].CellBackColor(i,'5move_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)					
				} else if (sheetObjects[4].CellValue(i, '5ton_rate') > 0) {
					sheetObjects[4].CellBackColor(i,'5ton_rate') = sheetObjects[4].RgbColor(255, 0, 0);
					dataErrCount++;
				}
			}

			// sto_com_cmnc_tm_flg
			if (vrfyFlg[11] == "Y"){
				if(sheetObjects[4].CellValue(i,'5cmnc_hrmnt') == ""){
					sheetObjects[4].CellBackColor(i,'5cmnc_hrmnt') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			} else if (vrfyFlg[11] == "N"){
				if(sheetObjects[4].CellValue(i,'5cmnc_hrmnt') != ""){
					sheetObjects[4].CellBackColor(i,'5cmnc_hrmnt') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}
			// sto_free_dy_io_bnd_flg
			if (vrfyFlg[12] == "Y" && sheetObjects[4].CellValue(i,'5tml_sto_agmt_tp_cd') == "FD"){
				if(sheetObjects[4].CellValue(i,'5io_bnd_cd') == ""){
					sheetObjects[4].CellBackColor(i,'5io_bnd_cd') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			} else if (vrfyFlg[12] == "N"){
				/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 -  null값 제거 (CAHD 2015-06-25)  */
				/*N일때 Same으로 체크*/ 
//				if(sheetObjects[4].CellValue(i,'5io_bnd_cd') != ""){
				if(sheetObjects[4].CellValue(i,'5io_bnd_cd') != "S"){
					sheetObjects[4].CellBackColor(i,'5io_bnd_cd') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}

			// sto_free_dy_flg
			if (vrfyFlg[13] == "Y"){
				if(sheetObjects[4].CellValue(i,'5tml_sto_agmt_tp_cd') != "FD" && sheetObjects[4].CellValue(i,'5tml_sto_agmt_tp_cd') != "FP"){
					sheetObjects[4].CellBackColor(i,'5tml_sto_agmt_tp_cd') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			} else if (vrfyFlg[13] == "N"){
				if(sheetObjects[4].CellValue(i,'5tml_sto_agmt_tp_cd') != ""){
					sheetObjects[4].CellBackColor(i,'5tml_sto_agmt_tp_cd') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}

			// sto_free_dy_dcgo_tm_flg
			if (sheetObjects[4].CellValue(i,'5ft_dys') == "F" && vrfyFlg[14] == "Y") {
				//[CHM-201539189]DG(NONE) 숨김처리로 값을 입력안하면 NONE DG를 선택한 것으로 본다.(CAH D 2015-12-30)
				if((sheetObjects[4].CellValue(i,'5dg_none_fd')				== "" &&
						sheetObjects[4].CellValue(i,'5same_dg_none_fd')			== "" &&
						sheetObjects[4].CellValue(i,'5same_dg_fd')				== "" &&
						sheetObjects[4].CellValue(i,'5sep_dg_none_fd')			== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n1st_clss_flg_fd')	== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n2nd_clss_flg_fd')	== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n3rd_clss_flg_fd')	== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n4th_clss_flg_fd')	== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n5th_clss_flg_fd')	== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n6th_clss_flg_fd')	== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n7th_clss_flg_fd')	== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n8th_clss_flg_fd')	== "" &&
						sheetObjects[4].CellValue(i,'5dcgo_n9th_clss_flg_fd')	== "" ) ||
						(sheetObjects[4].CellValue(i,'5same_dg_none_fd')== "Y" && 
						sheetObjects[4].CellValue(i,'5same_dg_fd')		== "Y")) {
					sheetObjects[4].CellValue(i,'5dg_none_fd') = "Y";
				}
				if((sheetObjects[4].CellValue(i,'5dg_none_fd')				== "" &&
					sheetObjects[4].CellValue(i,'5same_dg_none_fd')			== "" &&
					sheetObjects[4].CellValue(i,'5same_dg_fd')				== "" &&
					sheetObjects[4].CellValue(i,'5sep_dg_none_fd')			== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n1st_clss_flg_fd')	== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n2nd_clss_flg_fd')	== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n3rd_clss_flg_fd')	== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n4th_clss_flg_fd')	== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n5th_clss_flg_fd')	== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n6th_clss_flg_fd')	== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n7th_clss_flg_fd')	== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n8th_clss_flg_fd')	== "" &&
					sheetObjects[4].CellValue(i,'5dcgo_n9th_clss_flg_fd')	== "" ) ||
					(sheetObjects[4].CellValue(i,'5same_dg_none_fd')== "Y" && 
					sheetObjects[4].CellValue(i,'5same_dg_fd')		== "Y")) {

					sheetObjects[4].CellBackColor(i,'5dg_none_fd')				= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5same_dg_none_fd')			= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5same_dg_fd')				= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5sep_dg_none_fd')			= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n1st_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n2nd_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n3rd_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n4th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n5th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n6th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n7th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n8th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n9th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
				
			} else if (vrfyFlg[14] == "N"){
				if( sheetObjects[4].CellValue(i,'5dg_none_fd')				== "Y" ||
					sheetObjects[4].CellValue(i,'5same_dg_none_fd')			== "Y" || 
					sheetObjects[4].CellValue(i,'5same_dg_fd')				== "Y" || 
					sheetObjects[4].CellValue(i,'5sep_dg_none_fd')			== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n1st_clss_flg_fd')	== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n2nd_clss_flg_fd')	== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n3rd_clss_flg_fd')	== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n4th_clss_flg_fd')	== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n5th_clss_flg_fd')	== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n6th_clss_flg_fd')	== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n7th_clss_flg_fd')	== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n8th_clss_flg_fd')	== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n9th_clss_flg_fd')	== "Y" ) {

					sheetObjects[4].CellBackColor(i,'5dg_none_fd')				= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5same_dg_none_fd')			= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5same_dg_fd')				= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5sep_dg_none_fd')			= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n1st_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n2nd_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n3rd_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n4th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n5th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n6th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n7th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n8th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n9th_clss_flg_fd')	= sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}

			// sto_free_dy_dcgo_rt_flg
			if (sheetObjects[4].CellValue(i,'5ft_dys') == "" && vrfyFlg[16] == "Y"){
				//[CHM-201539189]DG(NONE) 숨김처리로 값을 입력안하면 NONE DG를 선택한 것으로 본다.(CAH D 2015-12-30)
				if((sheetObjects[4].CellValue(i,'5dg_none_r')			== "" &&
						sheetObjects[4].CellValue(i,'5same_dg_none_r')		== "" && 
						sheetObjects[4].CellValue(i,'5same_dg_r')			== "" && 
						sheetObjects[4].CellValue(i,'5sep_dg_none_r')		== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n1st_clss_flg_r')== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n2nd_clss_flg_r')== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n3rd_clss_flg_r')== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n4th_clss_flg_r')== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n5th_clss_flg_r')== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n6th_clss_flg_r')== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n7th_clss_flg_r')== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n8th_clss_flg_r')== "" && 
						sheetObjects[4].CellValue(i,'5dcgo_n9th_clss_flg_r')== "" ) ||
						(sheetObjects[4].CellValue(i,'5same_dg_none_r')	== "Y" && 
						sheetObjects[4].CellValue(i,'5same_dg_r')		== "Y") ) {
					sheetObjects[4].CellValue(i,'5dg_none_r') = "Y";
				}
				if((sheetObjects[4].CellValue(i,'5dg_none_r')			== "" &&
					sheetObjects[4].CellValue(i,'5same_dg_none_r')		== "" && 
					sheetObjects[4].CellValue(i,'5same_dg_r')			== "" && 
					sheetObjects[4].CellValue(i,'5sep_dg_none_r')		== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n1st_clss_flg_r')== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n2nd_clss_flg_r')== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n3rd_clss_flg_r')== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n4th_clss_flg_r')== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n5th_clss_flg_r')== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n6th_clss_flg_r')== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n7th_clss_flg_r')== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n8th_clss_flg_r')== "" && 
					sheetObjects[4].CellValue(i,'5dcgo_n9th_clss_flg_r')== "" ) ||
					(sheetObjects[4].CellValue(i,'5same_dg_none_r')	== "Y" && 
					sheetObjects[4].CellValue(i,'5same_dg_r')		== "Y") ) {

					sheetObjects[4].CellBackColor(i,'5dg_none_r')			= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5same_dg_none_r')		= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5same_dg_r')			= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5sep_dg_none_r')		= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n1st_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n2nd_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n3rd_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n4th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n5th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n6th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n7th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n8th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n9th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			} else if (vrfyFlg[16] == "N") {
				
				if( sheetObjects[4].CellValue(i,'5dg_none_r')			== "Y" ||
					sheetObjects[4].CellValue(i,'5same_dg_none_r')		== "Y" || 
					sheetObjects[4].CellValue(i,'5same_dg_r')			== "Y" || 
					sheetObjects[4].CellValue(i,'5sep_dg_none_r')		== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n1st_clss_flg_r')== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n2nd_clss_flg_r')== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n3rd_clss_flg_r')== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n4th_clss_flg_r')== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n5th_clss_flg_r')== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n6th_clss_flg_r')== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n7th_clss_flg_r')== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n8th_clss_flg_r')== "Y" || 
					sheetObjects[4].CellValue(i,'5dcgo_n9th_clss_flg_r')== "Y" ) {
					
					sheetObjects[4].CellBackColor(i,'5dg_none_r')			= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5same_dg_none_r')		= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5same_dg_r')			= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5sep_dg_none_r')		= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n1st_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n2nd_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n3rd_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n4th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n5th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n6th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n7th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n8th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dcgo_n9th_clss_flg_r')= sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}

			// sto_free_dy_tr_dy_flg
			if (vrfyFlg[17] == "Y" && 
				sheetObjects[4].CellValue(i,'5ft_dys') == "F" && 
				sheetObjects[4].CellValue(i,'5tml_sto_agmt_tp_cd') == "FD") {
				
				if( sheetObjects[4].CellValue(i,'5fm_tr_dys') != "" && 
					sheetObjects[4].CellValue(i,'5to_tr_dys') != "" ){
					
					sheetObjects[4].CellBackColor(i,'5fm_tr_dys') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5to_tr_dys') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
				
			} else if (vrfyFlg[17] == "Y" && 
					sheetObjects[4].CellValue(i,'5ft_dys') == "" && 
					sheetObjects[4].CellValue(i,'5tml_sto_agmt_tp_cd') == "FD" ) {
				
				if( sheetObjects[4].CellValue(i,'5fm_tr_dys') == "" || 
					sheetObjects[4].CellValue(i,'5to_tr_dys') == "" ){
					
					sheetObjects[4].CellBackColor(i,'5fm_tr_dys') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5to_tr_dys') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
				
			} else if (vrfyFlg[17] == "N"){
				if( sheetObjects[4].CellValue(i,'5fm_tr_dys') != "" || 
					sheetObjects[4].CellValue(i,'5to_tr_dys') != "" ) {
					
					sheetObjects[4].CellBackColor(i,'5fm_tr_dys') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5to_tr_dys') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}

			// sto_fp_calc_prd_flg
			if (vrfyFlg[18] == "Y" && sheetObjects[4].CellValue(i,'5tml_sto_agmt_tp_cd') == "FP" ) {
				if(sheetObjects[4].CellValue(i,'5fp_calc_prd_cd') == "" ){
					sheetObjects[4].CellBackColor(i,'5fp_calc_prd_cd') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
				
			} else if (vrfyFlg[18] == "N"){
				if(sheetObjects[4].CellValue(i,'5fp_calc_prd_cd') != "" ){
					sheetObjects[4].CellBackColor(i,'5fp_calc_prd_cd') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}

			// sto_fp_teu_flg
			if (vrfyFlg[19] == "Y" && sheetObjects[4].CellValue(i,'5tml_sto_agmt_tp_cd') == "FP") {
				// STO_FP_TEU_FLG = 'Y' 인 COST CODE SRFDMT/SRNDMT의 경우  Agreement Type이 FP, free pool이 "0" 허용하도록 주석처리 (4347-08-28 YSY B)
//				if(sheetObjects[4].CellValue(i,'5fp_teu_qty') == 0 ){
//					sheetObjects[4].CellBackColor(i,'5fp_teu_qty') = sheetObjects[4].RgbColor(255,0,0);
//					dataErrCount++;
//				} else 
				if(sheetObjects[4].CellValue(i,'5teu_rate') == 0 && sheetObjects[4].CellValue(i,'5box_rate') == 0 ) {
					sheetObjects[4].CellBackColor(i,'5teu_rate') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5box_rate') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			} else if (vrfyFlg[19] == "N"){
				if(sheetObjects[4].CellValue(i,'5fp_teu_qty') > 0 ){
					sheetObjects[4].CellBackColor(i,'5fp_teu_qty') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}

			if (sheetObjects[4].CellValue(i,'5ft_dys') == "F"){

			} else if(sheetObjects[4].CellValue(i,'5ft_dys') == "" ){
				if(vrfyDysSum > 0 ){
					sheetObjects[4].CellBackColor(i,'5d2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5d2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5d4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5d5_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5d7_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5d8_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5d9_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dw_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5dx_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5r2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5r4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5r5_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5r7_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5r8_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5r9_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5f2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5f4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5o2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5o4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5o5_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5o7_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5s2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5s4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5t2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5t4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5a2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5a4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5a5_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5p2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5p4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5c2_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5c4_fd') = sheetObjects[4].RgbColor(255,0,0);
					sheetObjects[4].CellBackColor(i,'5f5_fd') = sheetObjects[4].RgbColor(255,0,0);
					dataErrCount++;
				}
			}

			if(sheetObjects[4].CellValue(i, '5tml_sto_agmt_tp_cd') == "FP"){
				sheetObjects[4].CellValue(i,'5d2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5d4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5d5_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5d7_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5d8_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5d9_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5dw_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5dx_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5r2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5r4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5r5_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5r7_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5r8_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5r9_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5f2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5f4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5o2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5o4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5o5_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5o7_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5s2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5s4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5t2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5t4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5a2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5a4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5a5_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5p2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5p4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5c2_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5c4_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5f5_fd')	= 0.00;
				sheetObjects[4].CellValue(i,'5d2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5d4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5d5_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5d7_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5d8_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5d9_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5dw_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5dx_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5r2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5r4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5r5_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5r7_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5r8_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5r9_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5f2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5f4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5o2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5o4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5o5_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5o7_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5s2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5s4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5t2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5t4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5a2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5a4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5a5_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5p2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5p4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5c2_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5c4_r') 	= 0.00;
				sheetObjects[4].CellValue(i,'5f5_r') 	= 0.00;
			}
			vrfyFlg = "";
		}
		return dataErrCount;
	}
	 
 	 /** rhqValidChk()
	  * 
	  * @return
	  */
	function rhqValidChk(){
		if(document.form.rhq_ofc_cd.value !="Y"){
	    	ComShowMessage(ComGetMsg('TES50204'));
	    	location.href="ESD_TES_0039.do?pgmNo=ESD_TES_0039";
	    }
		return false;
	}
	

	/**
	 * checkAgmtConfirm
	 * 
	 * AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27) 
	 * Creation ID 와 Confirm ID 동일한지 비교
	 * 동일하면 처리 안되게하고 동일하지 않으면 Manager  Alert
	 * @param obj
	 * @returns {Boolean}
	 */
	function checkAgmtConfirm(obj)
	{
		// 생성, 수정시 ID 체크
		if ( "" == sheetObjects[5].CellValue(1, "cre_usr_id") || 
			document.form.cre_usr_id.value == sheetObjects[5].CellValue(1, "cre_usr_id") ) {
			return false;
		} else {
			ComShowMessage(ComGetMsg('TES10130'));	// It requests team/part leader\'s confirm
		}
		return false;
	}
	

	/**
	 * AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27)
	 * Creation ID 와 Confirm ID 동일한지 비교
	 * 동일하면 처리 안되게하고 동일하지 않으면 Manager  Alert
	 * 
	 */
	function checkHdrSaveCreUpdUser() 
	{
		
		if ( !ComIsNull(document.form.agmt_cfm_flg.value) ) {
			if ( "N" == document.form.agmt_cfm_flg.value || "Y" == document.form.agmt_cfm_flg.value ) {
				// creation/update User ID와 동일한 경우 허용안함
				if ( "" == sheetObjects[5].CellValue(1, "cre_usr_id") || 
					document.form.cre_usr_id.value == sheetObjects[5].CellValue(1, "cre_usr_id") ) {
					ComShowMessage(ComGetMsg('TES10133'));	// Creation ID is Same. Do Not Save.
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * GW에서 리턴된 값 화면 적용
	 * 계약서 입력 팝업에서 선택한 파일 ID를 받는다.
	 * 비용지급 전표 결재 기능 - 3차 (4347-09-24)
	 * @param msg
	 */
	function returnGwLink(msg) {
		msg = msg.split(",");
		/* IBTab 초기화 */
		var formObj	= document.form;
		var gw_no	= msg[0];
		var gw_desc	= msg[1];
	
		ComSetObjValue(formObj.agmt_doc_no, gw_no);
		ComSetObjValue(formObj.agmt_doc_desc, gw_desc);
	}
	