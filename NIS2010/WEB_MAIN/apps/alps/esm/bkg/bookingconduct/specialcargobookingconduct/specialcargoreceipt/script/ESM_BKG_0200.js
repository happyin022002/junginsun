/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0200.js
 *@FileTitle : Criteria for out guage calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 이병규
 *@LastVersion : 1.0
 * 2009.06.08 이병규
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.10.12 김영철 [CHM-201006332-01] PSA AUTO EDI 수정 요청 (Special Cargo 정보 자동 전송 및 WARNING 메세지 추가)
 2011.04.06 변종건 [CHM-201109633-01] DG Approval Pending - CNTR#부재시 입력 가능
 2011.05.11 변종건 [CHM-201110122-01] [AK, RF] CNTR#부재상태의 Approval Pending시 CNTR#입력가능
 2011.10.14 변종건 [CHM-201113595-01] US Rail DG bkg에 대한 warning msg 요청 - DG Cargo Validation Check 추가
 2011.10.21 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청
 2011.11.16 변종건 [선처리] DG Cargo의 SUB Label와 Packing Group 코드에 따른 메시지 처리 로직 수정
 2011.12.20 변종건 [CHM-201114816-01] 위험물  입력 관련 로직 변경 추가 요청 검토(추가 요청 사항)
 2012.01.12 변종건 [CHM-201215424-01] Booking DG Application Cargo 필수입력 조건 변경 요청
 2012.02.01 변종건 [CHM-201215892-01] DG Remark 추가 에러 사항 개선 요청
 2012.02.07 채창호 [CHM-201216063-01] [DG] 각 CNTR에 대한 Cargo Seq 부정합- 조치요청
 2012.02.28 변종건 [CHM-201216422-01] SPECIAL CARGO 기능 보완 요청
 2013.08.22 김보배 [CHM-201326216] DG Application => Segregation Group 선택 로직 수정 요청
 2013.11.01 김보배 [CHM-201326836] [dg cargo application] E-MAIL 주소 입력 컬럼 추가
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class esm_bkg_0200 : esm_bkg_0200 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0200() {
	this.processButtonClick 	= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl 			= initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
	this.setComboObject 		= setComboObject;
	this.hzd_ctnt_OnChange		= hzd_ctnt_OnChange;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var comboObjects = new Array();
var comboCnt = 0;
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;

// var reqFlag = "";
var saveEnd = "";

var retFlag = "";
var rsltVal = "";
var saveFlg = "";
var requestFlg = "";
var cancelFlg = "";
var reqCancelFlg = "";
var messageFlg = "";
var chkFlg = "";
var pendingSaveFlg = "Y"	//Approval이 Pending 상태일 때는 Container No를 제외한 나머지 모든 값은 신규 또는 수정이 되지 않게 상태 확인하는 Flag
var unNoCngFlg = "N";
var continueWarnMsgFlg = "N";	// Validation 을 무시하고 request를 계속 진행할지 여부 flag 

//임시 번호저장 
var temp_imdg_un_no = '';

//var saveEnd = "";
//var rsltVal = "";
	
//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
//ComComboObject생성자 메소드에서 호출됨
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	var sheetObject5 = sheetObjects[4];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName != "btn_splitPop") {
			if (layList.style.display == "") {
				layList.style.display = "none";
			}
		}
		switch (srcName) {
			//split 조회
			case "btn_splitPop":
				doActionIBSheet(sheetObject1, formObject, COMMAND04);
				break;
	
			//조회
			case "btn_retrieve":
				if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
				break;
	
			//첨부화일
			case "btn_attach":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("ESM_BKG_0207.do?bkg_no=" + document.getElementById("bkg_no").value + "&ridr_tp_cd=D", 525, 520, "", "0,0,1,1,1,1,1", true);
				}
				break;
	
			//저장
			case "btn_save":
				if(unNoCngFlg == "Y" && 
						(document.getElementById("spcl_cgo_auth_cd").value != ""
							&& document.getElementById("spcl_cgo_auth_cd").value != null)){
					btn_request.fireEvent("onclick");
				} else {
					if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
						messageFlg = "save";
						retFlag = "N";
						saveChkFlg = "Y";
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
						if (retFlag == "Y") {
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						}
					}
				}
				break;
	
			//request
			case "btn_request":
				document.getElementById("button").value = "N";
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var reqCnt = 0;
					for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
						if (sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") != "C") {
							//cancel이 아닌 row의 갯수를 구한다.
							reqCnt++;
						}
						if (sheetObjects[3].CellValue(i, "imdg_un_no_seq") == "") {
							ComShowCodeMessage("BKG02090");
							chkFlg = "Y";
							return;
						} 
					}
					
					// cancel이 아닌 row의 갯수가 0이면 에러메세지를 보여준다.
					if (reqCnt < 1 && reqCancelFlg != "Y") {
						ComShowMessage(ComGetMsg("BKG08107"));
						return;
					}
	
					//request로직을 수행중인지 알기 위해 messageFlg를 전역변수로 설정...
					messageFlg = "request";
	
					//retrieve로직일 경우 retFlag = Y...
	
					retFlag = "N";
					//시트에서 insert, update, delete된 데이터의 갯수를 구하고, cntR > 0이면 저장로직을 먼저 수행한후, request 로직을 수행한다.
					var cntR = 0;
	
					for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
						if (sheetObjects[3].CellValue(i, "ibflag") != "R") {
							cntR++;
						}
					}
	
					// BDR 이후 저장시 Blocking
					if (cntR > 0 && sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "bdr_flg") == "Y") {
						ComShowMessage(ComGetMsg("BKG00004"));
						chkFlg = "Y";
						return;
					}
					
					//cntR > 0일 경우... 저장후, request로직을 수행한다.
					if (cntR > 0) {
						// chkFlg = N일 경우, 저장 체크로직에서 에러가 발생하지 않은 것이다.
						chkFlg = "N";
						// saveChkFlg = Y이면 저장 체크로직을 수행한다.
						saveChkFlg = "Y";
						// requestFlg = Y이면 저장로직이 끝나고, 저장 성공 메세지가 나타나지 않는다.
						requestFlg = "Y";
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	
						//저장로직 수행후 에러가 발생하지 않으면 request로직을 탄다.
						if (chkFlg == "N") {
							
							rsltVal = "Y";
							requestFlg = "Y";
							var layerUrl = "VOP_SCG_0069.do?pop_type=B2";
							var contents = "<iframe id=\"preCheckFrm\" src=\"" + layerUrl + "\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"1\" height=\"1\"></iframe>";
							progressPop.innerHTML = contents;
						}		
					} 
					//cntR < 1일 경우... 저장로직을 수행하지 않고, request로직을 수행한다.
					else {
						
						//2011.10.14 변종건 [CHM-201113595-01] US Rail DG bkg에 대한 warning msg 요청 - DG Cargo Validation Check 추가
						var un_rail_chk_cnt = 0;
						for( var i=1;i<=sheetObjects[3].RowCount;i++ ){
							if( (formObject.pod_cd.value.substr(0,2) == "US" || formObject.del_cd.value.substr(0,2) == "US")
							&& (formObject.dest_trns_mod_cd.value == "R" || formObject.dest_trns_mod_cd.value == "A")
							&& sheetObjects[3].CellValue(i, "imdg_un_no") == "1402"
							&& sheetObjects[3].CellValue(i, "imdg_clss_cd") == "4.3" ){
								un_rail_chk_cnt++;
							}
							
							//2011.10.21 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청 ( Hazardous Contents, Properties 및 Storage Temp Validation Check )
							for ( var j = 1; j <= sheetObjects[1].RowCount; j++) {
								if (sheetObjects[3].CellValue(i, "cntr_no") == sheetObjects[1].CellValue(j, "cntr_no") && sheetObjects[3].CellValue(i, "dg_cntr_seq") == sheetObjects[1].CellValue(j, "dg_cntr_seq")) {
									var seq = sheetObjects[1].CellValue(j, "seq");
								}
							}
							var cntr_cgo_seq = sheetObjects[3].CellValue(i, "cntr_cgo_seq");
							
							if( sheetObjects[3].CellValue(i, "stwg_temp_ctnt")=="" ){
								ComShowCodeMessage("BKG02100", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							
							if( sheetObjects[3].CellValue(i, "spcl_provi_no") != "" ){
								var spcl_provi_arr = sheetObjects[3].CellValue(i, "spcl_provi_no").split("/");								
								for(var idx=0;idx<spcl_provi_arr.length;idx++){
									if( spcl_provi_arr[idx]== "274" || spcl_provi_arr[idx]== "318" ){										
										if( sheetObjects[3].CellValue(i, "hzd_desc") == "" ){
											if( !ComShowCodeConfirm("BKG02099", "[" + seq + "." + cntr_cgo_seq + "]" + "\nDo you want to continue ?") ){
												chkFlg = "Y";
												return;
											}
										}
										if( sheetObjects[3].CellValue(i, "hzd_ctnt") == "" ){
											ComShowCodeMessage("BKG02099", "[" + seq + "." + cntr_cgo_seq + "]");
											chkFlg = "Y";
											return;
										}
									}
								}
							}
						}
						
						if( un_rail_chk_cnt > 0 ){
							if( !ComShowCodeConfirm("BKG02097","Do you want to continue ?") ){
								chkFlg = "Y";
								return;
							}
						}					
						
						rsltVal = "Y";
						requestFlg = "Y";
						var layerUrl = "VOP_SCG_0069.do?pop_type=B2";
						var contents = "<iframe id=\"preCheckFrm\" src=\"" + layerUrl + "\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"1\" height=\"1\"></iframe>";
						progressPop.innerHTML = contents;
					}
				}
				break;
	
			//request cancel 로직...
			case "btn_cancel":
				document.getElementById("button").value = "Y";
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
	
					//request cancel로직을 수행중인지 알기 위해 messageFlg를 전역변수로 설정...
					messageFlg = "requestCancel";
	
					//선택된 row의 apro_cd 상태가 cancel 상태이면... 로직이 수행되지 않는다.
					if (cancelFlg == "Y") {
						return;
					}
	
					//조회로직이 아니면 retFlag = N으로 설정...
					retFlag = "N";
	
					//시트에서 insert, update, delete된 데이터의 갯수를 구하고, cntR > 0이면 저장로직을 먼저 수행한후, request cancel 로직을 수행한다.
					var cntR = 0;
	
					for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
						if (sheetObjects[3].CellValue(i, "ibflag") != "R") {
							cntR++;
						}
					}
	
					//저장할 데이터가 있을경우, 저장로직을 수행한다.
					if (cntR > 0) {
						// saveChkFlg = Y이면 저장 체크로직을 수행한다.
						saveChkFlg = "Y";
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	
						//저장할 데이터가 없을 경우, request cancel 로직을 수행한다.	
					} else {
						rsltVal = "Y";
						requestFlg = "Y";
						reqCancelFlg = "Y";
						var layerUrl = "VOP_SCG_0069.do?pop_type=B2";
						var contents = "<iframe id=\"preCheckFrm\" src=\"" + layerUrl + "\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"1\" height=\"1\"></iframe>";
						progressPop.innerHTML = contents;
					}
				}
				break;
	
			//e-mail 전송
			case "btn_email":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					sendMail();
				}
	
				break;
	
			//rd 프린트
			case "btn_print":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					goPrint();
				}
				break;
	
			//remark 팝업
			case "btn_Remark":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var url = "ESM_BKG_0757.do";
					ComOpenWindowCenter(url, "ESM_BKG_0757", 420, 350, true);
				}
				break;
	
			//sheet row 추가
			case "row_add":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					
					if (document.getElementById("spcl_cgo_auth_cd").value == "P"){
						ComShowMessage(ComGetMsg("BKG00500"));
						return;
					}					
					rowAdd();
				}
				break;
	
			//hidden sheet row와 Html 셀렉트박스 value 추가...
			case "btn_add":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					checkAdd();
				}
				break;
	
			// unNo 팝업...
			case "imdg_class_button":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + formObject.imdg_un_no.value + "&bkg_no=" + formObject.bkg_no.value, 920, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
				}
				break;
	
			// sheet 데이터 copy 팝업...
			case "btn_copy1":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					if (document.getElementById("spcl_cgo_auth_cd").value == "P"){
						ComShowMessage(ComGetMsg("BKG00500"));
						return;
					}					
					var url = "ESM_BKG_0735.do?copyFlg=Y";
					ComOpenWindowCenter(url, "ESM_BKG_0735", 415, 200, true);
				}
				break;
	
			//hidden sheet row와 Html 셀렉트박스 value copy...
			case "btn_copy2":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var url = "ESM_BKG_0735.do?copyFlg=N";
					ComOpenWindowCenter(url, "ESM_BKG_0735", 415, 500, true);
				}
				break;
	
			//package 팝업...
			case "pkg_qty_type":	
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var in_imdg_pck_cd1 = document.getElementById("in_imdg_pck_cd1").value;
					var in_imdg_pck_cd2 = document.getElementById("in_imdg_pck_cd2").value;
					var intmd_imdg_pck_cd1 = document.getElementById("intmd_imdg_pck_cd1").value;
					var intmd_imdg_pck_cd2 = document.getElementById("intmd_imdg_pck_cd2").value;
					var out_imdg_pck_cd1 = document.getElementById("out_imdg_pck_cd1").value;
					var out_imdg_pck_cd2 = document.getElementById("out_imdg_pck_cd2").value;
					var in_imdg_pck_desc1 = document.getElementById("in_imdg_pck_desc1").value;
					var in_imdg_pck_desc2 = document.getElementById("in_imdg_pck_desc2").value;
					var intmd_imdg_pck_desc1 = document.getElementById("intmd_imdg_pck_desc1").value;
					var intmd_imdg_pck_desc2 = document.getElementById("intmd_imdg_pck_desc2").value;
					var out_imdg_pck_desc1 = document.getElementById("out_imdg_pck_desc1").value;
					var out_imdg_pck_desc2 = document.getElementById("out_imdg_pck_desc2").value;
					var in_imdg_pck_qty1 = document.getElementById("in_imdg_pck_qty1").value;
					var in_imdg_pck_qty2 = document.getElementById("in_imdg_pck_qty2").value;
					var intmd_imdg_pck_qty1 = document.getElementById("intmd_imdg_pck_qty1").value;
					var intmd_imdg_pck_qty2 = document.getElementById("intmd_imdg_pck_qty2").value;
					var out_imdg_pck_qty1 = document.getElementById("out_imdg_pck_qty1").value;
					var out_imdg_pck_qty2 = document.getElementById("out_imdg_pck_qty2").value;
					var hcdg_intmd_bc_rstr_desc = document.getElementById("hcdg_intmd_bc_rstr_desc").value;
					var hcdg_pck_rstr_desc = document.getElementById("hcdg_pck_rstr_desc").value;
					var hcdg_tnk_rstr_desc = document.getElementById("hcdg_tnk_rstr_desc").value;
					var ltd_qty = document.getElementById("ltd_qty").value;
					var imdg_expt_qty_cd = document.getElementById("imdg_expt_qty_cd").value;
					var grs_wgt = document.getElementById("grs_wgt").value;
					var net_wgt = document.getElementById("net_wgt").value;
					var grs_capa_qty = document.getElementById("grs_capa_qty").value;
					var dcgo_sts_cd = document.getElementById("dcgo_sts_cd").value;
					var imdg_lmt_qty_flg = document.getElementById("imdg_lmt_qty_flg").value;
					ComOpenPopup("ESM_BKG_0206.do?in_imdg_pck_cd1=" + in_imdg_pck_cd1 
							+ "&in_imdg_pck_cd2=" + in_imdg_pck_cd2 
							+ "&intmd_imdg_pck_cd1=" + intmd_imdg_pck_cd1 
							+ "&intmd_imdg_pck_cd2=" + intmd_imdg_pck_cd2 
							+ "&out_imdg_pck_cd1=" + out_imdg_pck_cd1 
							+ "&out_imdg_pck_cd2=" + out_imdg_pck_cd2 
							+ "&in_imdg_pck_desc1=" + in_imdg_pck_desc1 
							+ "&in_imdg_pck_desc2=" + in_imdg_pck_desc2 
							+ "&intmd_imdg_pck_desc1=" + intmd_imdg_pck_desc1 
							+ "&intmd_imdg_pck_desc2=" + intmd_imdg_pck_desc2 
							+ "&out_imdg_pck_desc1=" + out_imdg_pck_desc1 
							+ "&out_imdg_pck_desc2=" + out_imdg_pck_desc2 
							+ "&in_imdg_pck_qty1=" + in_imdg_pck_qty1 
							+ "&in_imdg_pck_qty2=" + in_imdg_pck_qty2 
							+ "&intmd_imdg_pck_qty1=" + intmd_imdg_pck_qty1 
							+ "&intmd_imdg_pck_qty2=" + intmd_imdg_pck_qty2 
							+ "&out_imdg_pck_qty1=" + out_imdg_pck_qty1 
							+ "&out_imdg_pck_qty2=" + out_imdg_pck_qty2 
							+ "&hcdg_intmd_bc_rstr_desc=" + hcdg_intmd_bc_rstr_desc 
							+ "&hcdg_pck_rstr_desc=" + hcdg_pck_rstr_desc 
							+ "&hcdg_tnk_rstr_desc=" + hcdg_tnk_rstr_desc 
							+ "&ltd_qty=" + ltd_qty 
							+ "&imdg_expt_qty_cd=" + imdg_expt_qty_cd 
							+ "&grs_wgt=" + grs_wgt 
							+ "&net_wgt=" + net_wgt 
							+ "&grs_capa_qty=" + grs_capa_qty 
							+ "&dcgo_sts_cd=" + dcgo_sts_cd
							+ "&imdg_lmt_qty_flg=" + imdg_lmt_qty_flg, 
							710, 560, "getCOM_PKG_QTY_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0206");
				}
				break;
	
			//emer_no 팝업
			case "btn_emer_info":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("ESM_BKG_0770.do?imdg_emer_no=" + formObject.ems_no.value + "&emer_rspn_gid_no=" + formObject.emer_rspn_gid_no.value + "&emer_rspn_gid_chr_no=" + formObject.emer_rspn_gid_chr_no.value + "&ctrl_temp_ctnt=" + formObject.ctrl_temp_ctnt.value + "&emer_temp_ctnt=" + formObject.emer_temp_ctnt.value, 500, 220, "getCOM_EMER_NO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
							"ESM_BKG_0770");
				}
				break;
	
			//sheet row 삭제
			case "row_delete":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					rowDelete();
				}
				break;
	
			//hidden sheet row와 Html 셀렉트박스 value 삭제...
			case "btn_delete":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					deleteRows();
				}
				break;
	
			//Route Detail 팝업
			case "ts_route_vvd_btn":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("ESM_BKG_1069.do?bkg_no=" + formObject.bkg_no.value, 700, 460, "", "1,0,1,1,1", true);
				}
				break;
	
			//
			case "btn_approval":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("VOP_SCG_1015.do?scg_flg=DG&bkg_no=" + formObject.bkg_no.value, 1000, 490, "", '0,0', true);
				}
				break;
	
			//un information
			case "un_information_btn":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var imdg_un_no = document.getElementById("imdg_un_no").value;//sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "imdg_un_no");
					var imdg_un_no_seq = document.getElementById("imdg_un_no_seq").value;//sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "imdg_un_no_seq");	 								
					ComOpenWindowCenter("VOP_SCG_0001.do?pop_mode=Y&imdg_un_no=" + imdg_un_no + "&imdg_un_no_seq=" + imdg_un_no_seq, "winUnInformation", "1000", "645", true);
				}
				break;
	
			//restrictions
			case "restrictions_btn":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					var bkg_no = document.getElementById("bkg_no").value;
					var imdg_un_no = document.getElementById("imdg_un_no").value;//sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "imdg_un_no");
					var imdg_un_no_seq = document.getElementById("imdg_un_no_seq").value;//sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "imdg_un_no_seq");
					var pol_cd = document.getElementById("pol_cd").value;
					var pod_cd = document.getElementById("pod_cd").value;
					var vsl_cd = document.getElementById("vsl_cd").value.substring(0, 4);
					var skd_voy_no = document.getElementById("vsl_cd").value.substring(4, 8);
					var skd_dir_cd = document.getElementById("vsl_cd").value.substring(8, 9);
					var slan_cd = document.getElementById("slan_cd").value;
	
					ComOpenWindowCenter("VOP_SCG_0021.do?bkg_no=" + bkg_no + "&imdg_un_no=" + imdg_un_no + "&imdg_un_no_seq=" + imdg_un_no_seq + "&pol_cd=" + pol_cd + "&pod_cd=" + pod_cd + "&vsl_cd=" + vsl_cd + "&skd_voy_no=" + skd_voy_no + "&skd_dir_cd=" + skd_dir_cd + "&slan_cd=" + slan_cd, "VOP_SCG_0021", 1020, 660, true);
				}
				break;
	
			//pre-checking reports	
			case "pre_checking_reports_btn":
				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("VOP_SCG_0069.do?pop_type=SR", 940, 910, "VOP_SCG_0069", "0,0,1,1,1,1,1", true, null, null, null, null, null, "yes");
				}
				break;
		    //irregulars_list
			case "srch_irregulars_list":
				var imdg_un_no = document.getElementById("imdg_un_no").value;
	 	    	if(document.getElementById("srch_irregulars_list").style.color != 'red') imdg_un_no = "";
	 	    	ComOpenWindowCenter("VOP_SCG_0012Pop.do?pgmNo=VOP_SCG_0012&pop_mode=Y&f_cmd=&imdg_un_no="+imdg_un_no, "winIrrList", "1025", "700", true);
	 	    	break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

// VOP_SCG_0069에서 opener로 호출... pre-checking시 필요.
function getCgoSheet() {
	return sheetObjects[3];
}

// pre-checking...
function setPreChkRslt(rslt) {
	if (requestFlg == "Y") {
		if (rslt == "P") {
			rsltVal = "N";
			requestFlg = "N";
			// pre-checking 팝업
			ComOpenPopup("VOP_SCG_0069.do", 940, 950, "VOP_SCG_0069", "0,0,1,1,1,1,1", true);
		} else {
			rsltVal = "Y";
			saveChkFlg = "N";
		}
	}
}

// request...
function spRequest(pSheetObj) {
	for ( var k = 1; k <= sheetObjects[3].RowCount; k++) {
		if (sheetObjects[3].CellValue(i, "ibflag") != "D") {
			sheetObjects[3].CellValue2(i, "spcl_rqst_flg") = "N";
		}
	}

	for ( var i = 2; i <= pSheetObj.RowCount + 1; i++) {
		var bkg_cntr_seq = pSheetObj.CellValue(i, "spcl_cntr_seq") + pSheetObj.CellValue(i, "spcl_cgo_seq");
		var row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, -1);

		sheetObjects[3].CellValue2(row, "spcl_rqst_desc") = pSheetObj.CellValue(i, "reason");
		sheetObjects[3].CellValue2(row, "spcl_rqst_flg") = "Y";
		sheetObjects[3].CellValue2(row, "apro_cd") = sheetObjects[3].CellValue(row, "spcl_cgo_apro_cd");
		if (pSheetObj.CellValue(i, "reason") != "") {
			rsltVal = "Y";
			saveChkFlg = "N";
		}
	}

	closeProgressPop();
}

function closeProgressPop() {
	if (rsltVal == "Y") {
		rsltVal = "N";

		var iCnt = 0;
		var uCnt = 0;
		var dCnt = 0;
		if (sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") != "") {
			ComShowMessage(ComGetMsg("BKG08076"));
			return;
		}
		iCnt = sheetObjects[3].FindText("ibflag", "I", 0, 2);
		uCnt = sheetObjects[3].FindText("ibflag", "U", 0, 2);
		dCnt = sheetObjects[3].FindText("ibflag", "D", 0, 2);

		if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
			if (sheetObjects[2].CellValue(1, "bdr_flg") != "Y" && sheetObjects[2].CellValue(1, "corr_no") == "") {
				//if(ComShowConfirm(ComGetMsg("BKG00824"))){ 	
				requestFlg = "N";
				saveChkFlg == "N";
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				//}else{
				//	return;
				//} 					 				
			}
			if (sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "vsl_pre_pst_cd") != "") {
				ComShowMessage(ComGetMsg("BKG08074"));
				return;
			}
			if (sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "vsl_pre_pst_cd") == "") {
				ComShowMessage(ComGetMsg("BKG08075"));
				return;
			}
		} else {
			saveEnd = "Y";
		}
		var ncCnt = 0;
		var rCnt = 0;
		var yCnt = 0;

		for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
			if (sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") == "P") {
				ComShowMessage(ComGetMsg("BKG00500"));
				return;
			}
//			if ((document.getElementById("pol_cd").value).indexOf("CN") == "0") {
//				if (sheetObjects[3].CellValue(i, "imdg_clss_cd") == "5.1" || sheetObjects[3].CellValue(i, "imdg_clss_cd") == "5.2") {
//					ComShowMessage(ComGetMsg("BKG00963"));
//					return;
//				}
//			}
			if (sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") == "C") {
				ncCnt++;
			}
			if (sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") == "R") {
				rCnt++;
			}
			if (sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") == "Y") {
				yCnt++;
			}
		}
		if (saveEnd == "Y") {
			
			// 2017.06.05 iylee Validation Check
			if (reqCancelFlg != "Y") {
				continueWarnMsgFlg = doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
				if(continueWarnMsgFlg == "N"){
					return;
				}

			}
			if (ncCnt > 0) {
				if(reqCancelFlg == "Y"){
					if (ComShowConfirm(ComGetMsg("BKG08244"))) {
					} else {
						return;
					}
				} else {
					if (ComShowConfirm(ComGetMsg("BKG00521"))) {
					} else {
						return;
					}
				}
			}
			if (rCnt > 0) {
				if(reqCancelFlg != "Y"){
					if (confirm(ComGetMsg("BKG00522", document.getElementById("bkg_no").value))) {
					} else {
						return;
					}
				}
			}
			if (yCnt > 0) {
				if(reqCancelFlg != "Y"){
					if (ComShowConfirm(ComGetMsg("BKG00523", document.getElementById("bkg_no").value))) {
					} else {
						return;
					}
				}
			}

			var reqCnt = 0;

			if (reqCancelFlg != "Y") {
				for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
					if (sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") != "C") {
						sheetObjects[3].CellValue2(i, "apro_cd") = "R";
						reqCnt++;
					}
				}
				if (reqCnt > 0) {
					
					// manageSpclCgoApro
					doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
					
					
				} else {
					ComShowMessage(ComGetMsg("BKG08107"));
					return;
				}
			} else {
				reqCancelFlg = "N";
				var Row = sheetObjects[3].FindText("DelChk", "1", 0, 2);
				sheetObjects[3].CellValue2(Row, "apro_cd") = "C";
				// manageSpclCgoApro
				doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			}

		}
		if (retFlag == "Y") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
}

/**
 * Making parameter of Pre-Checking
 */
function makePreChkParam() {
	var sheetObj2 = sheetObjects[3];
	var sParam = "";
	for ( var i = sheetObj2.HeaderRows; i <= sheetObj2.LastRow; i++) {
		if (sheetObj2.RowStatus(i) != 'D') {
			for ( var j = 0; j <= sheetObj2.LastCol; j++) {
				if (sheetObj2.ColSaveName(j) != "") {
					sParam += sheetObj2.ColSaveName(j) + "=" + sheetObj2.CellValue(i, j) + "&";
				}
			}
		}
	}
	sParam += "rgn_shp_opr_cd=";
	sParam += "cgo_opr_cd=HJS";
	sParam += "&bkg_no=" + document.getElementById("bkg_no").value;
	sParam += "&vsl_cd=" + document.getElementById("vsl_cd").value.substring(0, 4);
	sParam += "&skd_voy_no=" + document.getElementById("vsl_cd").value.substring(4, 8);
	sParam += "&skd_dir_cd=" + document.getElementById("vsl_cd").value.substring(8, 9);
	sParam += "&crr_cd=" + document.getElementById("crr_cd").value;
	sParam += "&slan_cd=";
	sParam += "&pol_cd=" + document.getElementById("pol_cd").value;
	sParam += "&pod_cd=" + document.getElementById("pod_cd").value;
	return sParam;
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
 
 /**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboId) {
    var formObject = document.form
    if( comboId == "hzd_ctnt" ){
    	comboObj.DropHeight = 200; 
    	initCombo_hzd_ctnt();
    }
}
 
function initCombo_hzd_ctnt() {
	with (form.hzd_ctnt) {
 		MultiSelect = true; 
 		MultiSeparator="|";

		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	} 
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	//처음 페이지가 로드되는 순간, irregular list를 가져와서 컬럼에 넣어줌
	ComSetObjValue(document.form.irregular_list, searchIrrForUnNo());

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].BaseColor = "#F3F2F8";
	}
	
	//MultiCombo초기화 
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    
	if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}

	//------------------------------------------------>
	//setInquiryDisableButton 이벤트 호출
	if (ComGetObjValue(document.form.isInquiry) == "Y") {
		setInquiryDisableButton();
	}
	
	initControl();
}

function sendMail() {
	var iCnt = sheetObjects[3].FindText("ibflag", "I", 0, 2);
	var uCnt = sheetObjects[3].FindText("ibflag", "U", 0, 2);
	var dCnt = sheetObjects[3].FindText("ibflag", "D", 0, 2);

	if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
		ComShowMessage(ComGetMsg("BKG00178"));
		return;
	}
	var date = new Date();
	var content = "";
	content = "SM LINE<br><br>[ Dangerous Cargo ]<br>"
			+ date.toString()
			+ "<br>Booking Number : " 
			+ document.getElementById("bkg_no").value 
			+ "<br>B/L Number : " 
			+ document.getElementById("bl_no").value 
			+ "<br>POL : " 
			+ document.getElementById("pol_cd").value 
			+ "<br>POD : " 
			+ document.getElementById("pod_cd").value 
			+ "<br>VVD/VESSEL NAME : " 
			+ document.getElementById("vsl_cd").value + " / "
			+ document.getElementById("vessel_nm").value 
			+ "<br>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";
	for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
		if (sheetObjects[3].CellValue(i, "spcl_apro_cd") != "C") {
			content += "1.  Container SEQ           : " + sheetObjects[3].CellValue(i, "spcl_cntr_seq") + "<br>";
			content += "2.  Container No.           : " + sheetObjects[3].CellValue(i, "cntr_no") + "<br>";
			content += "3.  EQ Type/Size            : " + sheetObjects[3].CellValue(i, "eq_tpsz") + "<br>";
			content += "4.  Cargo SEQ               : " + sheetObjects[3].CellValue(i, "spcl_cgo_seq") + "<br>";
			content += "5.  UN No.                  : " + sheetObjects[3].CellValue(i, "imdg_un_no") + "<br>";
			content += "6.  IMO Class               : " + sheetObjects[3].CellValue(i, "imdg_clss_cd") + "<br>";
			content += "7.  Net WGT/KG              : " + sheetObjects[3].CellText(i, "net_wgt") + "<br>";
			content += "8.  Grs WGT/KG              : " + sheetObjects[3].CellText(i, "grs_wgt") + "<br>";
			content += "9.  Proper Ship Name        : " + sheetObjects[3].CellValue(i, "prp_shp_nm") + "<br>";
			content += "10. HAZ. Contents           : " + sheetObjects[3].CellValue(i, "hzd_desc") + "<br>";
			content += "11. Flash Point/Cel         : " + sheetObjects[3].CellValue(i, "flsh_pnt_cdo_temp") + "<br>";
			content += "12. Packing GRP             : " + sheetObjects[3].CellValue(i, "imdg_pck_grp_cd") + "<br>";
			if (sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd1") == "" && sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd2") == "" && sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd3") == "" && sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd4") == "") {
				content += "13. Sub Label                : <br>"
			} else {
				content += "13. Sub Label                : " + sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd1") + " / " + sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd2") + " / " + sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd3") + " / " + sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd4") + "<br>";
			}
			content += "14. Control Temp./Cel       : " + sheetObjects[3].CellValue(i, "ctrl_temp_ctnt") + "<br>";
			content += "15. Emergency Temp./Cel     : " + sheetObjects[3].CellValue(i, "emer_temp_ctnt") + "<br>";
			content += "16. PSA GRP                 : " + sheetObjects[3].CellValue(i, "psa_no") + "<br>";
			content += "17. Limited Quantity        : " + sheetObjects[3].CellValue(i, "imdg_lmt_qty_flg") + "<br>";
			content += "18. Excepted Quantity       : " + sheetObjects[3].CellValue(i, "imdg_expt_qty_flg") + "<br>";
			content += "19. Marine Pollutant        : " + sheetObjects[3].CellValue(i, "mrn_polut_flg") + "<br>";
			content += "20. Cargo Status            : " + sheetObjects[3].CellValue(i, "dcgo_sts_cd") + "<br>";
			content += "21. EMS No                  : " + sheetObjects[3].CellValue(i, "ems_no") + "<br>";
			content += "22. ERG                     : " + sheetObjects[3].CellValue(i, "emer_rspn_gid_no") + sheetObjects[3].CellValue(i, "emer_rspn_gid_chr_no") +  "<br>";
			content += "23. Emergency Contact       : " + sheetObjects[3].CellValue(i, "emer_cntc_phn_no_ctnt") + "<br>";
			content += "24. Outer Pack              : " ;
			if(sheetObjects[3].CellValue(i, "out_imdg_pck_qty1") != 0){
				content += sheetObjects[3].CellValue(i, "out_imdg_pck_qty1") + " X "+  sheetObjects[3].CellValue(i, "out_imdg_pck_desc1");
			}
			if(sheetObjects[3].CellValue(i, "out_imdg_pck_qty2") != 0){
				content += "<br>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp;" + sheetObjects[3].CellValue(i, "out_imdg_pck_qty2") + " X "+  sheetObjects[3].CellValue(i, "out_imdg_pck_desc2") ;
			}
			content += "<br>";
			content += "25. Inner Pack              : ";
			if(sheetObjects[3].CellValue(i, "in_imdg_pck_qty1") != 0){
				content += sheetObjects[3].CellValue(i, "in_imdg_pck_qty1") + " X "+  sheetObjects[3].CellValue(i, "in_imdg_pck_desc1");
			}
			if (sheetObjects[3].CellValue(i, "in_imdg_pck_qty2") != 0){
				content += "<br>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp;" + sheetObjects[3].CellValue(i, "in_imdg_pck_qty2") + " X "+  sheetObjects[3].CellValue(i, "in_imdg_pck_desc2") ;
			}
			content += "<br>";
			content += "26. Net Explosive Weight/kg : " + sheetObjects[3].CellText(i, "net_explo_wgt") + "<br>";
			content += "27. Remarks                 : " + sheetObjects[3].CellText(i, "diff_rmk") + "<br>";
			content += "<br>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";

		}
	}
	document.form.com_content.value = content;

	ComSendMailModal();
}

function initControl() {
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)    	
	axon_event.addListenerForm('click', 'obj_click', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	
	//Irregulars List 버튼을 위한 listner
//	axon_event.addListener    ('click',   'img_click',   	"srch_irregulars_list");
	applyShortcut();
}

function obj_click() {
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
	var find_row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, -1);
	switch (event.srcElement.name) {

	case "grs_wgt":
		if (sheetObjects[3].CellValue(find_row, "grs_wgt") == "0") {
			document.getElementById("grs_wgt").value = "";
		}
		break;

	case "net_wgt":
		if (sheetObjects[3].CellValue(find_row, "net_wgt") == "0") {
			document.getElementById("net_wgt").value = "";
		}
		break;
	}
}

function getCOM_UNNO_POPUP(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
	var opener_row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, -1);

	unNoCngFlg = "Y";
	
	document.getElementById("imdg_un_no").value = colArray[2];
	document.getElementById("imdg_un_no_seq").value = colArray[3];
	document.getElementById("imdg_clss_cd").value = colArray[4];
	document.getElementById("imdg_comp_grp_cd").value = colArray[5];
	document.getElementById("prp_shp_nm").value = colArray[7];
	document.getElementById("imdg_subs_rsk_lbl_cd1").value = colArray[9];
	document.getElementById("imdg_subs_rsk_lbl_cd2").value = colArray[10];
	document.getElementById("imdg_subs_rsk_lbl_cd3").value = colArray[11];
	document.getElementById("imdg_subs_rsk_lbl_cd4").value = colArray[12];
	document.getElementById("psa_no").value = colArray[14];
	//document.getElementById("imdg_lmt_qty_flg").value = colArray[19];   	       
	document.getElementById("imdg_pck_grp_cd").value = colArray[6];
	document.getElementById("ems_no").value = colArray[16];
	document.getElementById("emer_rspn_gid_no").value = colArray[17];
	document.getElementById("emer_rspn_gid_chr_no").value = colArray[18];
	document.getElementById("crr_cd").value = colArray[25];
	document.getElementById("hzd_desc").value = colArray[8];
	document.getElementById("ltd_qty").value = colArray[19];
	document.getElementById("hcdg_pck_rstr_desc").value = colArray[26];
	document.getElementById("hcdg_intmd_bc_rstr_desc").value = colArray[27];
	document.getElementById("hcdg_tnk_rstr_desc").value = colArray[28];
	document.getElementById("ctrl_temp_ctnt").value = colArray[29];
	document.getElementById("emer_temp_ctnt").value = colArray[30];
	document.getElementById("imdg_expt_qty_cd").value = colArray[20];
	document.form.hzd_ctnt.text2 = colArray[32];
	sheetObjects[3].CellValue2(opener_row, "imdg_un_no") = colArray[2];
	sheetObjects[3].CellValue2(opener_row, "imdg_un_no_seq") = colArray[3];
	sheetObjects[3].CellValue2(opener_row, "imdg_clss_cd") = colArray[4];
	sheetObjects[3].CellValue2(opener_row, "imdg_comp_grp_cd") = colArray[5];
	sheetObjects[3].CellValue2(opener_row, "prp_shp_nm") = colArray[7];
	sheetObjects[3].CellValue2(opener_row, "imdg_subs_rsk_lbl_cd1") = colArray[9];
	sheetObjects[3].CellValue2(opener_row, "imdg_subs_rsk_lbl_cd2") = colArray[10];
	sheetObjects[3].CellValue2(opener_row, "imdg_subs_rsk_lbl_cd3") = colArray[11];
	sheetObjects[3].CellValue2(opener_row, "imdg_subs_rsk_lbl_cd4") = colArray[12];
	sheetObjects[3].CellValue2(opener_row, "psa_no") = colArray[14];
	sheetObjects[3].CellValue2(opener_row, "ltd_qty") = colArray[19];
	sheetObjects[3].CellValue2(opener_row, "imdg_expt_qty_cd") = colArray[20];
	sheetObjects[3].CellValue2(opener_row, "imdg_pck_grp_cd") = colArray[6];
	sheetObjects[3].CellValue2(opener_row, "imdg_spcl_provi_no") = colArray[23];
	//sheetObjects[3].CellValue2(opener_row, "imdg_crr_rstr_expt_cd") = colArray[24]; 
	sheetObjects[3].CellValue2(opener_row, "imdg_mrn_polut_cd") = colArray[15];
	sheetObjects[3].CellValue2(opener_row, "ems_no") = colArray[16];
	sheetObjects[3].CellValue2(opener_row, "emer_rspn_gid_no") = colArray[17];
	sheetObjects[3].CellValue2(opener_row, "emer_rspn_gid_chr_no") = colArray[18];
	sheetObjects[3].CellValue2(opener_row, "crr_cd") = colArray[25];
	sheetObjects[3].CellValue2(opener_row, "hcdg_pck_rstr_desc") = colArray[26];
	sheetObjects[3].CellValue2(opener_row, "hcdg_intmd_bc_rstr_desc") = colArray[27];
	sheetObjects[3].CellValue2(opener_row, "hcdg_tnk_rstr_desc") = colArray[28];
	sheetObjects[3].CellValue2(opener_row, "ctrl_temp_ctnt") = colArray[29];
	sheetObjects[3].CellValue2(opener_row, "emer_temp_ctnt") = colArray[30];
	sheetObjects[3].CellValue2(opener_row, "hzd_desc") = colArray[8];
	sheetObjects[3].CellValue2(opener_row, "hzd_ctnt") = colArray[32];
	
	if (colArray[21] == "Y") {
		document.getElementById("hcdg_flag").value = "HCDG";
		sheetObjects[3].CellValue2(opener_row, "hcdg_flg") = "Y";
	} else {
		document.getElementById("hcdg_flag").value = "";
		sheetObjects[3].CellValue2(opener_row, "hcdg_flg") = "N";
	}
	if (colArray[15] == "P") {
		document.getElementById("mrn_polut_flg").value = "Y";
		sheetObjects[3].CellValue2(opener_row, "mrn_polut_flg") = "Y";
	} else {
		document.getElementById("mrn_polut_flg").value = "N";
		sheetObjects[3].CellValue2(opener_row, "mrn_polut_flg") = "N";
	}
/*	if (colArray[4].indexOf("3") == "0" || colArray[9].indexOf("3") == "0" || colArray[10].indexOf("3") == "0" || colArray[11].indexOf("3") == "0" || colArray[12].indexOf("3") == "0") {
		document.getElementById("flsh_pnt_cdo_temp").disabled = false;
	} else {
		document.getElementById("flsh_pnt_cdo_temp").disabled = true;
	}*/
	if (colArray[19] == "" || colArray[19] == "0") {

		document.getElementById("imdg_lmt_qty_flg").value = "N";
		sheetObjects[3].CellValue2(opener_row, "imdg_lmt_qty_flg") = "N";
	}

	if (colArray[20] == "" || colArray[20] == "E0") {

		document.getElementById("imdg_expt_qty_flg").value = "N";
		sheetObjects[3].CellValue2(opener_row, "imdg_expt_qty_flg") = "N";
	}
	if (colArray[25] != "") {
		sheetObjects[3].CellValue2(opener_row, "imdg_crr_rstr_expt_cd") = "R";
	}
	//임시 번호저장 
	temp_imdg_un_no = document.getElementById("imdg_un_no").value;
	
	doActionIBSheet(sheetObjects[3], document.form, SEARCH02);
	sheetObjects[3].CellValue2(opener_row, "spcl_provi_no") = document.getElementById("spcl_provi_no").value;
		
	//spcl_provi_no 번호에 따른 hzd_ctnt 콤보 활성화 여부 판단( spcl_provi_no가 274와 318 활성화 , 디폴트 Segregation Group이 없는 대상에 한해 활성화  ) - Start abc///////
	if( document.form.hzd_ctnt.text.length > 0 ){
		document.form.hzd_combo_disable_flg.value = "Y";
	}else{
		document.form.hzd_combo_disable_flg.value = "N";
	}
	
	if( document.getElementById("spcl_provi_no").value != "" ){
		var spcl_provi_arr = document.getElementById("spcl_provi_no").value.split("/");
		
		for(var idx=0;idx<spcl_provi_arr.length;idx++){
			if( spcl_provi_arr[idx]== "274" || spcl_provi_arr[idx]== "318" ){
				document.form.hzd_combo_disable_flg.value = "N";
			}
		}
	}
	//spcl_provi_no 번호에 따른 hzd_ctnt 콤보 활성화 여부 판단( spcl_provi_no가 274와 318 활성화 , 디폴트 Segregation Group이 없는 대상에 한해 활성화  ) - End ///////
}

function bkgSplitNoList(split_list) {
	document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
	layList.style.display = "none";
}

function getCOM_EMER_NO_POPUP(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
	var row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, -1);
	if (document.getElementById("ems_no").value != colArray[4]) {
		sheetObjects[3].CellValue2(row, "modifyaproflg") = "Y";
	}
	document.getElementById("ems_no").value = colArray[4];
	document.getElementById("emer_rspn_gid_no").value = colArray[6];
	document.getElementById("emer_rspn_gid_chr_no").value = colArray[7];
	document.getElementById("ctrl_temp_ctnt").value = colArray[5];
	document.getElementById("emer_temp_ctnt").value = colArray[8];
	sheetObjects[3].CellValue(row, "ems_no") = colArray[4];
	sheetObjects[3].CellValue(row, "emer_rspn_gid_no") = colArray[6];
	sheetObjects[3].CellValue(row, "emer_rspn_gid_chr_no") = colArray[7];
	sheetObjects[3].CellValue(row, "ctrl_temp_ctnt") = colArray[5];
	sheetObjects[3].CellValue(row, "emer_temp_ctnt") = colArray[8];
}

function getCOM_PKG_QTY_POPUP(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
	var row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, -1);

	if (document.getElementById("out_imdg_pck_cd1").value != colArray[8]) {
		sheetObjects[3].CellValue2(row, "modifyaproflg") = "Y";
	}
	if (document.getElementById("out_imdg_pck_qty1").value != colArray[7]) {
		sheetObjects[3].CellValue2(row, "modifyaproflg") = "Y";
	}

	document.getElementById("in_imdg_pck_cd1").value = colArray[20];
	document.getElementById("in_imdg_pck_cd2").value = colArray[23];
	document.getElementById("out_imdg_pck_cd1").value = colArray[8];
	document.getElementById("out_imdg_pck_cd2").value = colArray[11];
	document.getElementById("in_imdg_pck_desc1").value = colArray[21];
	document.getElementById("in_imdg_pck_desc2").value = colArray[24];
	document.getElementById("out_imdg_pck_desc1").value = colArray[9];
	document.getElementById("out_imdg_pck_desc2").value = colArray[12];
	document.getElementById("in_imdg_pck_qty1").value = colArray[19];
	document.getElementById("in_imdg_pck_qty2").value = colArray[22];
	document.getElementById("out_imdg_pck_qty1").value = colArray[7];
	document.getElementById("out_imdg_pck_qty2").value = colArray[10];
	document.getElementById("intmd_imdg_pck_cd1").value = colArray[14];
	document.getElementById("intmd_imdg_pck_cd2").value = colArray[17];
	document.getElementById("intmd_imdg_pck_qty1").value = colArray[13];
	document.getElementById("intmd_imdg_pck_qty2").value = colArray[16];
	document.getElementById("intmd_imdg_pck_desc1").value = colArray[15];
	document.getElementById("intmd_imdg_pck_desc2").value = colArray[18];
//	document.getElementById("hcdg_intmd_bc_rstr_desc").value = colArray[26];
//	document.getElementById("hcdg_pck_rstr_desc").value = colArray[25];
//	document.getElementById("hcdg_tnk_rstr_desc").value = colArray[27];
//	document.getElementById("ltd_qty").value = colArray[28];
	document.getElementById("grs_capa_qty").value = colArray[29];
//	document.getElementById("imdg_expt_qty_cd").value = colArray[41];
//	document.getElementById("imdg_lmt_qty_flg").value = colArray[42];	
	
	sheetObjects[3].CellValue2(row, "in_imdg_pck_cd1") = colArray[20];
	sheetObjects[3].CellValue2(row, "in_imdg_pck_cd2") = colArray[23];
	sheetObjects[3].CellValue2(row, "out_imdg_pck_cd1") = colArray[8];
	sheetObjects[3].CellValue2(row, "out_imdg_pck_cd2") = colArray[11];
	sheetObjects[3].CellValue2(row, "in_imdg_pck_desc1") = colArray[21];
	sheetObjects[3].CellValue2(row, "in_imdg_pck_desc2") = colArray[24];
	sheetObjects[3].CellValue2(row, "out_imdg_pck_desc1") = colArray[9];
	sheetObjects[3].CellValue2(row, "out_imdg_pck_desc2") = colArray[12];
	sheetObjects[3].CellValue2(row, "in_imdg_pck_qty1") = colArray[19];
	sheetObjects[3].CellValue2(row, "in_imdg_pck_qty2") = colArray[22];
	sheetObjects[3].CellValue2(row, "out_imdg_pck_qty1") = colArray[7];
	sheetObjects[3].CellValue2(row, "out_imdg_pck_qty2") = colArray[10];
	sheetObjects[3].CellValue2(row, "intmd_imdg_pck_cd1") = colArray[14];
	sheetObjects[3].CellValue2(row, "intmd_imdg_pck_cd2") = colArray[17];
	sheetObjects[3].CellValue2(row, "intmd_imdg_pck_qty1") = colArray[13];
	sheetObjects[3].CellValue2(row, "intmd_imdg_pck_qty2") = colArray[16];
	sheetObjects[3].CellValue2(row, "intmd_imdg_pck_desc1") = colArray[15];
	sheetObjects[3].CellValue2(row, "intmd_imdg_pck_desc2") = colArray[18];
//	sheetObjects[3].CellValue2(row, "hcdg_intmd_bc_rstr_desc") = colArray[26];
//	sheetObjects[3].CellValue2(row, "hcdg_pck_rstr_desc") = colArray[25];
//	sheetObjects[3].CellValue2(row, "hcdg_tnk_rstr_desc") = colArray[27];
//	sheetObjects[3].CellValue2(row, "ltd_qty") = colArray[28];
	sheetObjects[3].CellValue2(row, "grs_capa_qty") = colArray[29];
//	sheetObjects[3].CellValue2(row, "imdg_expt_qty_cd") = colArray[41];
//	sheetObjects[3].CellValue2(row, "imdg_lmt_qty_flg") = colArray[42];
}

function obj_keydown() {
	if (event.keyCode == 13) { // Enter Key  			
		switch (event.srcElement.name) {

		case "bkg_no":
			document.getElementById("bkg_no").value = (document.getElementById("bkg_no").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "bl_no":
			document.getElementById("bl_no").value = (document.getElementById("bl_no").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "imdg_un_no":
			ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + document.getElementById("imdg_un_no").value + "&bkg_no=" + document.getElementById("bkg_no").value, 900, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
			break;
		}
	}
}

function obj_blur() {
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
	var find_row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, -1);
	switch (event.srcElement.name) {

	case "rada_amt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("rada_amt").value = sheetObjects[3].CellText(find_row, "rada_amt")
		}
		break;

	case "net_explo_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("net_explo_wgt").value = sheetObjects[3].CellText(find_row, "net_explo_wgt")
		}
		break;

	case "certi_no":
		if (document.getElementById("bkg_no").value != "") {
			var certi_no = document.getElementById("certi_no").value;
			if (certi_no.length == "15") {
				sheetObjects[3].CellValue2(find_row, "certi_no") = document.getElementById("certi_no").value;
			}
			if (certi_no.length == "13") {
				document.getElementById("certi_no").value = certi_no.substr(0, 4) + "-" + certi_no.substr(4, 4) + "-" + certi_no.substr(8, 5);
				sheetObjects[3].CellValue2(find_row, "certi_no") = document.getElementById("certi_no").value;
			}
		}
		break;

	case "net_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("net_wgt").value = sheetObjects[3].CellText(find_row, "net_wgt");
			if (Number(document.getElementById("grs_wgt").value.replaceStr(",")) < Number(document.getElementById("net_wgt").value.replaceStr(","))) {
				ComAlertFocus(document.getElementById("net_wgt"), ComGetMsg("BKG00491"));
				document.getElementById("net_wgt").value = document.getElementById("temp_net_wgt").value;
				sheetObjects[3].CellValue(find_row, "net_wgt") = document.getElementById("temp_net_wgt").value;
			} else {
				document.getElementById("temp_net_wgt").value = sheetObjects[3].CellText(find_row, "net_wgt");
			}
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
		}
		break;

	case "grs_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("grs_wgt").value = sheetObjects[3].CellText(find_row, "grs_wgt");
			if (Number(document.getElementById("grs_wgt").value.replaceStr(",")) < Number(document.getElementById("net_wgt").value.replaceStr(","))) {
				ComAlertFocus(document.getElementById("grs_wgt"), ComGetMsg("BKG00491"));
				document.getElementById("grs_wgt").value = document.getElementById("temp_grs_wgt").value;
				sheetObjects[3].CellValue(find_row, "grs_wgt") = document.getElementById("temp_grs_wgt").value;
			} else {
				document.getElementById("temp_grs_wgt").value = sheetObjects[3].CellText(find_row, "grs_wgt")
			}
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
		}
		break;
		
	case "imdg_un_no":
		// 기본값이 다른경우 강제로 팝업을 띄워준다. 
		if ( temp_imdg_un_no  != document.getElementById("imdg_un_no").value) {
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0204.do?imdg_un_no=" + document.getElementById("imdg_un_no").value + "&bkg_no=" + document.getElementById("bkg_no").value, 900, 450, "getCOM_UNNO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
			}
		}
		//Irregular List의 UN NO 유효성 체크
//		if(document.getElementById("imdg_un_no").value!=''){
//			if( !ComChkObjValid(document.form.imdg_un_no) ){
//  				return;
//	        }else{
//	            doActionIBSheet(sheetObjects[5], formObj,IBSEARCH_ASYNC01);                         
//	        }			
//		}
		break;		
	}
	
}

function obj_keypress() {
	switch (event.srcElement.name) {
		case "grs_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "net_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "rada_amt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "net_explo_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "flsh_pnt_cdo_temp":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "imdg_un_no":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	}
}

function obj_change() {
	var row = sheetObjects[1].SelectRow;
	var imdg_clss_cd = document.getElementById("imdg_clss_cd").value;
	var imdg_subs_rsk_lbl_cd1 = document.getElementById("imdg_subs_rsk_lbl_cd1").value;
	var imdg_subs_rsk_lbl_cd2 = document.getElementById("imdg_subs_rsk_lbl_cd2").value;
	var imdg_subs_rsk_lbl_cd3 = document.getElementById("imdg_subs_rsk_lbl_cd3").value;
	var imdg_subs_rsk_lbl_cd4 = document.getElementById("imdg_subs_rsk_lbl_cd4").value;
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
	var find_row = 0;
	for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
		if (bkg_cntr_seq == sheetObjects[3].CellValue(i, "bkg_cntr_seq")) {
			find_row = i;
		}
	}
	switch (event.srcElement.name) {
		case "cntr_cgo_seq":
			for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
				sheetObjects[3].CellValue2(i, "DelChk") = "0";
			}
			sheetObjects[3].CellValue2(find_row, "DelChk") = "1";
			document.getElementById("cntr_cgo_seq").value = sheetObjects[3].CellValue(find_row, "cntr_cgo_seq");
			document.getElementById("imdg_clss_cd").value = sheetObjects[3].CellValue(find_row, "imdg_clss_cd");
			document.getElementById("imdg_comp_grp_cd").value = sheetObjects[3].CellValue(find_row, "imdg_comp_grp_cd");
			document.getElementById("imdg_un_no").value = sheetObjects[3].CellValue(find_row, "imdg_un_no");
			document.getElementById("imdg_un_no_seq").value = sheetObjects[3].CellValue(find_row, "imdg_un_no_seq");
			document.getElementById("grs_wgt").value = sheetObjects[3].CellText(find_row, "grs_wgt");
			document.getElementById("net_wgt").value = sheetObjects[3].CellText(find_row, "net_wgt");
			document.getElementById("temp_grs_wgt").value = sheetObjects[3].CellText(find_row, "grs_wgt");
			document.getElementById("temp_net_wgt").value = sheetObjects[3].CellText(find_row, "net_wgt");
			document.getElementById("prp_shp_nm").value = sheetObjects[3].CellValue(find_row, "prp_shp_nm");
			document.getElementById("hzd_desc").value = sheetObjects[3].CellValue(find_row, "hzd_desc");
//			document.getElementById("hzd_ctnt").value = sheetObjects[3].CellValue(find_row, "hzd_ctnt");
			document.form.hzd_ctnt.text2 = sheetObjects[3].CellValue(find_row, "hzd_ctnt");
			document.getElementById("stwg_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "stwg_temp_ctnt");
			document.getElementById("dflt_segr_grp_nm").value = sheetObjects[3].CellValue(find_row, "dflt_segr_grp_nm");
			document.getElementById("flsh_pnt_cdo_temp").value = sheetObjects[3].CellValue(find_row, "flsh_pnt_cdo_temp");
			document.getElementById("imdg_pck_grp_cd").value = sheetObjects[3].CellValue(find_row, "imdg_pck_grp_cd");
			document.getElementById("psa_no").value = sheetObjects[3].CellValue(find_row, "psa_no");
			document.getElementById("imdg_lmt_qty_flg").value = sheetObjects[3].CellValue(find_row, "imdg_lmt_qty_flg");
			document.getElementById("imdg_expt_qty_flg").value = sheetObjects[3].CellValue(find_row, "imdg_expt_qty_flg");
			
			//Cargo Seq.가 바뀔 때 Irregulars List 색 변환을 위해
			changeColorIrrButton(document.getElementById("irregular_list").value);
			
			if (sheetObjects[3].CellValue(find_row, "hcdg_flg") == "Y") {
				document.getElementById("hcdg_flag").value = "HCDG"
			} else {
				document.getElementById("hcdg_flag").value = "";
			}
			if (sheetObjects[3].RowCount > 0 && sheetObjects[3].CellValue(find_row, "diff_rmk").length > 1) {
				document.getElementById("btn_Remark").style.color = "blue";
			} else {
				document.getElementById("btn_Remark").style.color = "";
			}
			if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "Y") {
				document.getElementById("approved").style.color = "black";
				document.getElementById("approved").innerHTML = "approved";
			} else if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "N") {
				document.getElementById("approved").style.color = "red";
				document.getElementById("approved").innerHTML = "Rejected";
			} else if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "R") {
				document.getElementById("approved").style.color = "blue";
				document.getElementById("approved").innerHTML = "Requested";
			} else if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "P") {
				document.getElementById("approved").style.color = "black";
				document.getElementById("approved").innerHTML = "Pending";
			} else if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "C") {
				document.getElementById("approved").style.color = "black";
				document.getElementById("approved").innerHTML = "Canceled";
			} else {
				document.getElementById("approved").innerHTML = "";
			}
			document.getElementById("imdg_subs_rsk_lbl_cd1").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd1");
			document.getElementById("imdg_subs_rsk_lbl_cd2").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd2");
			document.getElementById("imdg_subs_rsk_lbl_cd3").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd3");
			document.getElementById("imdg_subs_rsk_lbl_cd4").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd4");
			document.getElementById("dcgo_sts_cd").value = sheetObjects[3].CellValue(find_row, "dcgo_sts_cd");
			document.getElementById("mrn_polut_flg").value = sheetObjects[3].CellValue(find_row, "mrn_polut_flg");
			document.getElementById("emer_cntc_phn_no_ctnt").value = sheetObjects[3].CellValue(find_row, "emer_cntc_phn_no_ctnt");
			document.getElementById("emer_cntc_pson_nm").value = sheetObjects[3].CellValue(find_row, "emer_cntc_pson_nm");
			document.getElementById("dcgo_rqst_grp_eml1").value = sheetObjects[3].CellValue(find_row, "dcgo_rqst_grp_eml1");
			document.getElementById("dcgo_rqst_grp_eml2").value = sheetObjects[3].CellValue(find_row, "dcgo_rqst_grp_eml2");
			document.getElementById("certi_no").value = sheetObjects[3].CellValue(find_row, "certi_no");
			document.getElementById("cnee_dtl_desc").value = sheetObjects[3].CellValue(find_row, "cnee_dtl_desc");
			document.getElementById("net_explo_wgt").value = sheetObjects[3].CellValue(find_row, "net_explo_wgt");
			document.getElementById("rada_skd_no").value = sheetObjects[3].CellValue(find_row, "rada_skd_no");
			document.getElementById("rada_amt").value = sheetObjects[3].CellValue(find_row, "rada_amt");
			document.getElementById("rada_ut_cd").value = sheetObjects[3].CellValue(find_row, "rada_ut_cd");
			document.getElementById("rada_trsp_no").value = sheetObjects[3].CellValue(find_row, "rada_trsp_no");
			document.getElementById("crr_cd").value = sheetObjects[3].CellValue(find_row, "crr_cd");
			document.getElementById("in_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_cd1");
			document.getElementById("in_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_cd2");
			document.getElementById("intmd_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_cd1");
			document.getElementById("intmd_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_cd2");
			document.getElementById("out_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_cd1");
			document.getElementById("out_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_cd2");
			document.getElementById("in_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_desc1");
			document.getElementById("in_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_desc2");
			document.getElementById("intmd_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_desc1");
			document.getElementById("intmd_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_desc2");
			document.getElementById("out_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_desc1");
			document.getElementById("out_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_desc2");
			document.getElementById("in_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_qty1");
			document.getElementById("in_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_qty2");
			document.getElementById("intmd_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_qty1");
			document.getElementById("intmd_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_qty2");
			document.getElementById("imdg_expt_qty_cd").value = sheetObjects[3].CellValue(find_row, "imdg_expt_qty_cd");
			document.getElementById("out_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_qty1");
			document.getElementById("out_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_qty2");
			document.getElementById("max_in_pck_qty").value = sheetObjects[3].CellValue(find_row, "max_in_pck_qty");
			document.getElementById("max_in_pck_tp_cd").value = sheetObjects[3].CellValue(find_row, "max_in_pck_tp_cd");
			document.getElementById("hcdg_intmd_bc_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_intmd_bc_rstr_desc");
			document.getElementById("hcdg_pck_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_pck_rstr_desc");
			document.getElementById("hcdg_tnk_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_tnk_rstr_desc");
			document.getElementById("ltd_qty").value = sheetObjects[3].CellValue(find_row, "ltd_qty");
			document.getElementById("ems_no").value = sheetObjects[3].CellValue(find_row, "ems_no");
			document.getElementById("emer_rspn_gid_no").value = sheetObjects[3].CellValue(find_row, "emer_rspn_gid_no");
			document.getElementById("emer_rspn_gid_chr_no").value = sheetObjects[3].CellValue(find_row, "emer_rspn_gid_chr_no");
			document.getElementById("ctrl_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "ctrl_temp_ctnt");
			document.getElementById("emer_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "emer_temp_ctnt");
			document.getElementById("diff_rmk").value = sheetObjects[3].CellValue(find_row, "diff_rmk");
			document.getElementById("clod_flg").value = sheetObjects[3].CellValue(find_row, "clod_flg");
			document.getElementById("rc_flg").value = sheetObjects[3].CellValue(find_row, "rc_flg");
			document.getElementById("awk_cgo_flg").value = sheetObjects[3].CellValue(find_row, "awk_cgo_flg");
			document.getElementById("bb_cgo_flg").value = sheetObjects[3].CellValue(find_row, "bb_cgo_flg");
			document.getElementById("hcdg_flg").value = sheetObjects[3].CellValue(find_row, "hcdg_flg");
			document.getElementById("meas_qty").value = sheetObjects[3].CellValue(find_row, "meas_qty");
			document.getElementById("hcdg_dpnd_qty_flg").value = sheetObjects[3].CellValue(find_row, "hcdg_dpnd_qty_flg");
			document.getElementById("dcgo_seq").value = sheetObjects[3].CellValue(find_row, "dcgo_seq");
			document.getElementById("aply_no").value = sheetObjects[3].CellValue(find_row, "aply_no");
			document.getElementById("grs_capa_qty").value = sheetObjects[3].CellValue(find_row, "grs_capa_qty");
/*			if (document.getElementById("imdg_clss_cd").value.indexOf("3") == "0" || document.getElementById("imdg_subs_rsk_lbl_cd1").value.indexOf("3") == "0" || document.getElementById("imdg_subs_rsk_lbl_cd2").value.indexOf("3") == "0" || document.getElementById("imdg_subs_rsk_lbl_cd3").value.indexOf("3") == "0" || document.getElementById("imdg_subs_rsk_lbl_cd4").value.indexOf("3") == "0") {
				document.getElementById("flsh_pnt_cdo_temp").disabled = false;
			} else {
				document.getElementById("flsh_pnt_cdo_temp").disabled = true;
			}*/
			if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "C" || sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "") {
				document.getElementById("btn_cancel_left").className = "btn2_left";
				document.getElementById("btn_cancel").className = "btn2_1";
				document.getElementById("btn_cancel_right").className = "btn2_right";			
				cancelFlg = "Y";
			} else {
				document.getElementById("btn_cancel_left").className = "btn1_left";
				document.getElementById("btn_cancel").className = "btn1";
				document.getElementById("btn_cancel_right").className = "btn1_right";
				cancelFlg = "N";
			}
			//임시 번호저장 
			temp_imdg_un_no = document.getElementById("imdg_un_no").value;
			
			//spcl_provi_no 번호에 따른 hzd_ctnt 콤보 활성화 여부 판단( spcl_provi_no가 274와 318 활성화 , 디폴트 Segregation Group이 없는 대상에 한해 활성화  ) - Start abc///////
			if( document.getElementById("dflt_segr_grp_nm").value != "" ){
				document.form.hzd_combo_disable_flg.value = "Y";
			}else{
				document.form.hzd_combo_disable_flg.value = "N";
			}
			
			if( document.getElementById("spcl_provi_no").value != "" ){
				var spcl_provi_arr = document.getElementById("spcl_provi_no").value.split("/");
				
				for(var idx=0;idx<spcl_provi_arr.length;idx++){
					if( spcl_provi_arr[idx]== "274" || spcl_provi_arr[idx]== "318" ){
						document.form.hzd_combo_disable_flg.value = "N";
					}
				}
			}
			//spcl_provi_no 번호에 따른 hzd_ctnt 콤보 활성화 여부 판단( spcl_provi_no가 274와 318 활성화 , 디폴트 Segregation Group이 없는 대상에 한해 활성화  ) - End ///////
			break;
	
		case "imdg_lmt_qty_flg":
			if (sheetObjects[3].CellValue(find_row, "ltd_qty") == "" || sheetObjects[3].CellValue(find_row, "ltd_qty") == "0") {
				if (document.getElementById("imdg_lmt_qty_flg").value == "Y") {
					ComShowMessage(ComGetMsg("BKG00543"));
					document.getElementById("imdg_lmt_qty_flg").value = "N";
					sheetObjects[3].CellValue2(find_row, "imdg_lmt_qty_flg") = "N";
				} else {
					sheetObjects[3].CellValue2(find_row, "imdg_lmt_qty_flg") = document.getElementById("imdg_lmt_qty_flg").value;
				}
			} else {
				sheetObjects[3].CellValue2(find_row, "imdg_lmt_qty_flg") = document.getElementById("imdg_lmt_qty_flg").value;
			}
			break;
	
		case "imdg_expt_qty_flg":
			if (sheetObjects[3].CellValue(find_row, "imdg_expt_qty_cd") == "" || sheetObjects[3].CellValue(find_row, "imdg_expt_qty_cd") == "E0") {
				if (document.getElementById("imdg_expt_qty_flg").value == "Y") {
					ComShowMessage(ComGetMsg("BKG00544"));
					document.getElementById("imdg_expt_qty_flg").value = "N";
					sheetObjects[3].CellValue2(find_row, "imdg_expt_qty_flg") = "N";
				} else {
					sheetObjects[3].CellValue2(find_row, "imdg_expt_qty_flg") = document.getElementById("imdg_expt_qty_flg").value;
				}
			} else {
				sheetObjects[3].CellValue2(find_row, "imdg_expt_qty_flg") = document.getElementById("imdg_expt_qty_flg").value;
			}
			break;
	
		case "imdg_clss_cd":
/*			if (imdg_clss_cd.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd1.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd2.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd3.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd4.indexOf("3") == "0") {
				document.getElementById("flsh_pnt_cdo_temp").disabled = false;
			} else {
				document.getElementById("flsh_pnt_cdo_temp").disabled = true;
			}*/
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			unNoCngFlg = "Y";
			break;
	
		case "imdg_un_no":
			sheetObjects[3].CellValue2(find_row, "imdg_un_no") = document.getElementById("imdg_un_no").value;
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			unNoCngFlg = "Y";
			break;
	
		case "imdg_subs_rsk_lbl_cd1":
/*			if (imdg_clss_cd.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd1.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd2.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd3.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd4.indexOf("3") == "0") {
				document.getElementById("flsh_pnt_cdo_temp").disabled = false;
			} else {
				document.getElementById("flsh_pnt_cdo_temp").disabled = true;
			}*/
			break;
	
		case "imdg_subs_rsk_lbl_cd2":
/*			if (imdg_clss_cd.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd1.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd2.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd3.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd4.indexOf("3") == "0") {
				document.getElementById("flsh_pnt_cdo_temp").disabled = false;
			} else {
				document.getElementById("flsh_pnt_cdo_temp").disabled = true;
			}*/
			break;
	
		case "imdg_subs_rsk_lbl_cd3":
/*			if (imdg_clss_cd.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd1.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd2.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd3.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd4.indexOf("3") == "0") {
				document.getElementById("flsh_pnt_cdo_temp").disabled = false;
			} else {
				document.getElementById("flsh_pnt_cdo_temp").disabled = true;
			}*/
			break;
	
		case "imdg_subs_rsk_lbl_cd4":
/*			if (imdg_clss_cd.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd1.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd2.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd3.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd4.indexOf("3") == "0") {
				document.getElementById("flsh_pnt_cdo_temp").disabled = false;
			} else {
				document.getElementById("flsh_pnt_cdo_temp").disabled = true;
			}*/
			break;
	
		case "mrn_polut_flg":
			if (sheetObjects[3].CellValue(find_row, "mrn_polut_flg") == "Y" && sheetObjects[3].CellValue(find_row, "imdg_mrn_polut_cd") == "P") {
				var imdg_un_no = sheetObjects[3].CellValue(find_row, "imdg_un_no");
				ComShowCodeMessage("BKG08039", imdg_un_no);
				document.getElementById("mrn_polut_flg").value = "Y";
				sheetObjects[3].CellValue2(find_row, "mrn_polut_flg") = "Y";
			} else {
				sheetObjects[3].CellValue2(find_row, "mrn_polut_flg") = document.getElementById("mrn_polut_flg").value;
				sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			}
			break;
	
		case "bkg_no":
			document.getElementById("bkg_no").value = (document.getElementById("bkg_no").value).toUpperCase();
			break;
	
		case "bl_no":
			document.getElementById("bl_no").value = (document.getElementById("bl_no").value).toUpperCase();
			break;
	
		case "dcgo_sts_cd":
			sheetObjects[3].CellValue2(find_row, "dcgo_sts_cd") = document.getElementById("dcgo_sts_cd").value;
			break;
	
		case "hzd_desc":
			sheetObjects[3].CellValue2(find_row, "hzd_desc") = document.getElementById("hzd_desc").value;
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			break;
			
		case "hzd_ctnt":
			sheetObjects[3].CellValue2(find_row, "hzd_ctnt") = document.getElementById("hzd_ctnt").text;
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			break;
			
		case "stwg_temp_ctnt":
			document.getElementById("stwg_temp_ctnt").value = (document.getElementById("stwg_temp_ctnt").value).toUpperCase();
			sheetObjects[3].CellValue2(find_row, "stwg_temp_ctnt") = document.getElementById("stwg_temp_ctnt").value;
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			break;
	
		case "cnee_dtl_desc":
			sheetObjects[3].CellValue2(find_row, "cnee_dtl_desc") = document.getElementById("cnee_dtl_desc").value;
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			break;
	
		case "prp_shp_nm":
			sheetObjects[3].CellValue2(find_row, "prp_shp_nm") = document.getElementById("prp_shp_nm").value;
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			break;
	
		case "net_explo_wgt":
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			break;
	
		case "rada_skd_no":
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			break;
	
		case "rada_amt":
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			break;
	
		case "rada_ut_cd":
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			sheetObjects[3].CellValue2(find_row, "rada_ut_cd") = document.getElementById("rada_ut_cd").value;
			break;
	
		case "rada_trsp_no":
			formObj = document.form;
			sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
			sheetObjects[3].CellValue2(find_row, "rada_trsp_no") = document.getElementById("rada_trsp_no").value;
			if(isNaN(document.getElementById("rada_trsp_no").value)){
				ComShowMessage(ComGetMsg("BKG08176"));
				ComSetFocus(formObj.rada_trsp_no);
			}
			break;
	
		case "imdg_pck_grp_cd":
			sheetObjects[3].CellValue2(find_row, "imdg_pck_grp_cd") = document.getElementById("imdg_pck_grp_cd").value;
			break;
	}
}

function obj_keyup() {
	pendingSaveFlg = "N"; //Approval이 Pending 상태일 때는 Container No를 제외한 나머지 모든 값은 신규 또는 수정이 되지 않게 상태 확인하는 Flag
	
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
	var row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, -1);
	switch (event.srcElement.name) {
		case "cntr_cgo_seq":
			sheetObjects[3].CellValue(row, "cntr_cgo_seq") = document.getElementById("cntr_cgo_seq").value;
			break;
	
		case "imdg_clss_cd":
			sheetObjects[3].CellValue(row, "imdg_clss_cd") = document.getElementById("imdg_clss_cd").value;
			break;
	
		case "imdg_comp_grp_cd":
			sheetObjects[3].CellValue(row, "imdg_comp_grp_cd") = document.getElementById("imdg_comp_grp_cd").value;
			break;
	
		case "imdg_un_no":
			sheetObjects[3].CellValue(row, "imdg_un_no") = document.getElementById("imdg_un_no").value;
			break;
	
		case "grs_wgt":
			if (document.getElementById("grs_wgt").value.length > 7) {
				if (document.getElementById("grs_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("grs_wgt").value = document.getElementById("grs_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[3].CellValue2(row, "grs_wgt") = document.getElementById("grs_wgt").value;
			break;
	
		case "net_wgt":
			if (document.getElementById("net_wgt").value.length > 7) {
				if (document.getElementById("net_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("net_wgt").value = document.getElementById("net_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[3].CellValue2(row, "net_wgt") = document.getElementById("net_wgt").value;
			break;
	
		case "prp_shp_nm":
			sheetObjects[3].CellValue2(row, "prp_shp_nm") = document.getElementById("prp_shp_nm").value;
			break;
	
		case "hzd_desc":
			sheetObjects[3].CellValue2(row, "hzd_desc") = document.getElementById("hzd_desc").value;
			break;
			
		case "hzd_ctnt":
			sheetObjects[3].CellValue2(row, "hzd_ctnt") = document.getElementById("hzd_ctnt").text;
			break;
			
		case "stwg_temp_ctnt":
			document.getElementById("stwg_temp_ctnt").value = (document.getElementById("stwg_temp_ctnt").value).toUpperCase();
			sheetObjects[3].CellValue2(row, "stwg_temp_ctnt") = document.getElementById("stwg_temp_ctnt").value;
			break;
	
		case "flsh_pnt_cdo_temp":
			sheetObjects[3].CellValue2(row, "flsh_pnt_cdo_temp") = document.getElementById("flsh_pnt_cdo_temp").value;
			break;

/*		case "imdg_pck_grp_cd":		  		    	
			sheetObjects[3].CellValue(row, "imdg_pck_grp_cd") = document.getElementById("imdg_pck_grp_cd").value; 
		break;
		 */
		case "psa_no":
			sheetObjects[3].CellValue2(row, "psa_no") = document.getElementById("psa_no").value;
			break;
	
		case "imdg_lmt_qty_flg":
			sheetObjects[3].CellValue2(row, "imdg_lmt_qty_flg") = document.getElementById("imdg_lmt_qty_flg").value;
			break;
	
		case "imdg_expt_qty_flg":
			sheetObjects[3].CellValue2(row, "imdg_expt_qty_flg") = document.getElementById("imdg_expt_qty_flg").value;
			break;
	
		case "hcdg_flag":
			sheetObjects[3].CellValue2(row, "hcdg_flg") = document.getElementById("hcdg_flag").value;
			break;
	
		case "imdg_subs_rsk_lbl_cd1":
			sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd1") = document.getElementById("imdg_subs_rsk_lbl_cd1").value;
			break;
	
		case "imdg_subs_rsk_lbl_cd2":
			sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd2") = document.getElementById("imdg_subs_rsk_lbl_cd2").value;
			break;
	
		case "imdg_subs_rsk_lbl_cd3":
			sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd3") = document.getElementById("imdg_subs_rsk_lbl_cd3").value;
			break;
	
		case "imdg_subs_rsk_lbl_cd4":
			sheetObjects[3].CellValue2(row, "imdg_subs_rsk_lbl_cd4") = document.getElementById("imdg_subs_rsk_lbl_cd4").value;
			break;
	
		case "dcgo_sts_cd":
			sheetObjects[3].CellValue2(row, "dcgo_sts_cd") = document.getElementById("dcgo_sts_cd").value;
			break;
	
		case "mrn_polut_flg":
			sheetObjects[3].CellValue2(row, "mrn_polut_flg") = document.getElementById("mrn_polut_flg").value;
			break;
	
		case "emer_cntc_phn_no_ctnt":
			sheetObjects[3].CellValue2(row, "emer_cntc_phn_no_ctnt") = document.getElementById("emer_cntc_phn_no_ctnt").value;
			break;
	
		case "emer_cntc_pson_nm":
			sheetObjects[3].CellValue2(row, "emer_cntc_pson_nm") = document.getElementById("emer_cntc_pson_nm").value;
			break;
			
		case "dcgo_rqst_grp_eml1":
			sheetObjects[3].CellValue2(row, "dcgo_rqst_grp_eml1") = document.getElementById("dcgo_rqst_grp_eml1").value;
			break;
			
		case "dcgo_rqst_grp_eml2":
			sheetObjects[3].CellValue2(row, "dcgo_rqst_grp_eml2") = document.getElementById("dcgo_rqst_grp_eml2").value;
			break;
	
		case "certi_no":
			sheetObjects[3].CellValue2(row, "certi_no") = document.getElementById("certi_no").value;
			break;
	
		case "cnee_dtl_desc":
			sheetObjects[3].CellValue2(row, "cnee_dtl_desc") = document.getElementById("cnee_dtl_desc").value;
			break;
	
		case "net_explo_wgt":
			sheetObjects[3].CellValue2(row, "net_explo_wgt") = document.getElementById("net_explo_wgt").value;
			break;
	
		case "rada_skd_no":
			sheetObjects[3].CellValue2(row, "rada_skd_no") = document.getElementById("rada_skd_no").value;
			break;
	
		case "rada_amt":
			sheetObjects[3].CellValue2(row, "rada_amt") = document.getElementById("rada_amt").value;
			break;
	
		case "rada_ut_cd":
			sheetObjects[3].CellValue2(row, "rada_ut_cd") = document.getElementById("rada_ut_cd").value;
			break;
	
		case "rada_trsp_no":
			 sheetObjects[3].CellValue2(row, "rada_trsp_no") = document.getElementById("rada_trsp_no").value;
			if (document.getElementById("rada_trsp_no").value != '' && !ComIsNumber(document.getElementById("rada_trsp_no").value,".")){
				 ComShowMessage(ComGetMsg("BKG08176"));
				 document.getElementById("rada_trsp_no").value = '';
				return;
			 }else{
//				 document.getElementById("rada_trsp_no").value = Number(document.getElementById("rada_trsp_no").value);
				 sheetObjects[3].CellValue2(row, "rada_trsp_no") = document.getElementById("rada_trsp_no").value;
			 }
			break;
	}
}

function rowAdd() {
	if (document.getElementById("bkg_no").value != "") {
		var Row1 = sheetObjects[1].DataInsert(-1);
		var Row2 = sheetObjects[3].DataInsert(-1);

		sheetObjects[1].CellValue2(Row1, "cntr_no") = "";
		sheetObjects[1].CellValue2(Row1, "bkg_no") = document.getElementById("bkg_no").value;
		sheetObjects[1].CellValue2(Row1, "cntr_cgo_seq") = "1";
		sheetObjects[1].CellValue2(Row1, "meas_qty") = "0";
		sheetObjects[1].CellValue2(Row1, "clod_flg") = "N";
		sheetObjects[1].CellValue2(Row1, "mrn_polut_flg") = "Y";
		sheetObjects[1].CellValue2(Row1, "rc_flg") = "N";
		sheetObjects[1].CellValue2(Row1, "awk_cgo_flg") = "N";
		sheetObjects[1].CellValue2(Row1, "bb_cgo_flg") = "N";
		sheetObjects[1].CellValue2(Row1, "hcdg_flg") = "N";
		sheetObjects[1].CellValue2(Row1, "hcdg_dpnd_qty_flg") = "N";
		sheetObjects[1].CellValue2(Row1, "imdg_expt_qty_flg") = "N";
		sheetObjects[1].CellValue2(Row1, "cntr_vol_qty") = "1";
		var dg_cntr_seq = Number(sheetObjects[1].CellValue(1, "dg_cntr_seq"));
		var dcgo_seq = Number(sheetObjects[3].CellValue(1, "dcgo_seq"));
		for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
			if (dg_cntr_seq < Number(sheetObjects[1].CellValue(i, "dg_cntr_seq"))) {
				dg_cntr_seq = Number(sheetObjects[1].CellValue(i, "dg_cntr_seq"));
			}
		}
		for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
			if (dcgo_seq < Number(sheetObjects[3].CellValue(i, "dcgo_seq"))) {
				dcgo_seq = Number(sheetObjects[3].CellValue(i, "dcgo_seq"));
			}
		}
		sheetObjects[1].CellValue2(Row1, "dg_cntr_seq") = Number(dg_cntr_seq) + 1;
		sheetObjects[3].CellValue2(Row2, "cntr_cgo_seq") = "1";
		sheetObjects[3].CellValue2(Row2, "spcl_cgo_seq") = "1";
		sheetObjects[3].CellValue2(Row2, "bkg_no") = document.getElementById("bkg_no").value;
		sheetObjects[3].CellValue2(Row2, "meas_qty") = "0";
		sheetObjects[3].CellValue2(Row2, "clod_flg") = "N";
		sheetObjects[3].CellValue2(Row2, "mrn_polut_flg") = "Y";
		sheetObjects[3].CellValue2(Row2, "rc_flg") = "N";
		sheetObjects[3].CellValue2(Row2, "awk_cgo_flg") = "N";
		sheetObjects[3].CellValue2(Row2, "bb_cgo_flg") = "N";
		sheetObjects[3].CellValue2(Row2, "hcdg_flg") = "N";
		sheetObjects[3].CellValue2(Row2, "imdg_expt_qty_flg") = "N";
		sheetObjects[3].CellValue2(Row2, "imdg_expt_qty_cd") = "";
		sheetObjects[3].CellValue2(Row2, "hcdg_dpnd_qty_flg") = "N";
		sheetObjects[3].CellValue2(Row2, "spcl_rqst_flg") = "N";
		sheetObjects[3].CellValue2(Row2, "cntr_vol_qty") = "1";
		sheetObjects[3].CellValue2(Row2, "dg_cntr_seq") = Number(dg_cntr_seq) + 1;
		sheetObjects[3].CellValue2(Row2, "spcl_cntr_seq") = Number(dg_cntr_seq) + 1;
		sheetObjects[3].CellValue2(Row2, "dcgo_seq") = Number(dcgo_seq) + 1;
		sheetObjects[3].CellValue2(Row2, "max_in_pck_qty") = "0";
		sheetObjects[3].CellValue2(Row2, "aply_no") = "";

	}
	cntrChk();
	htmlSheetSync();
	document.getElementById("temp_grs_wgt").value = "0";
	document.getElementById("temp_net_wgt").value = "0";
	var cntr_name = "";
	var cntr_val = "";
	for ( var j = 1; j <= sheetObjects[4].RowCount; j++) {
		if (sheetObjects[4].CellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[4].CellValue(j, "name") + "|";
			cntr_val += sheetObjects[4].CellValue(j, "val") + "|";
		}
	}
	cntr_val = cntr_val.substr(0, cntr_val.length - 1);
	cntr_name = cntr_name.substr(0, cntr_name.length - 1);
	var checkCntr = sheetObjects[4].FindText("DelChk", "0", 0, 2);
	if (checkCntr > 0) {
		sheetObjects[1].CellComboItem(Row1, "cntr_no", " |" + cntr_name, " |" + cntr_val);
	} else {
		sheetObjects[1].CellComboItem(Row1, "cntr_no", " ", " ");
	}
}

function checkAdd() {
	var row = sheetObjects[3].DataInsert(-1);
	sheetObjects[3].CellValue2(row, "cntr_no") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cntr_no");
	sheetObjects[3].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cntr_tpsz_cd");
	sheetObjects[3].CellValue2(row, "cntr_vol_qty") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cntr_vol_qty");
	sheetObjects[3].CellValue2(row, "meas_qty") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "meas_qty");
	sheetObjects[3].CellValue2(row, "clod_flg") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "clod_flg");
	sheetObjects[3].CellValue2(row, "mrn_polut_flg") = "Y";
	sheetObjects[3].CellValue2(row, "rc_flg") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rc_flg");
	sheetObjects[3].CellValue2(row, "awk_cgo_flg") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "awk_cgo_flg");
	sheetObjects[3].CellValue2(row, "bb_cgo_flg") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "bb_cgo_flg");
	sheetObjects[3].CellValue2(row, "hcdg_flg") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "hcdg_flg");
	sheetObjects[3].CellValue2(row, "hcdg_dpnd_qty_flg") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "hcdg_dpnd_qty_flg");
	sheetObjects[3].CellValue2(row, "spcl_rqst_flg") = "N";
	sheetObjects[3].CellValue2(row, "dg_cntr_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "dg_cntr_seq");
	sheetObjects[3].CellValue2(row, "spcl_cntr_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "dg_cntr_seq");
	sheetObjects[3].CellValue2(row, "imdg_expt_qty_flg") = "N";
	sheetObjects[3].CellValue2(row, "bkg_no") = document.getElementById("bkg_no").value;
	sheetObjects[3].CellValue2(row, "CntrChk") = "1";
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "spcl_cgo_apro_cd") = "";
	sheetObjects[3].CellValue2(row, "DelChk") = "1";
	sheetObjects[3].CellValue2(row, "max_in_pck_qty") = "0";
	var cnt = 0;
	var dcgo_seq = Number(sheetObjects[3].CellValue(1, "dcgo_seq"));
	for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
		if (sheetObjects[3].CellValue(i, "CntrChk") == "1" && sheetObjects[3].CellValue(i, "ibflag") != "D") {
			cnt++;
			sheetObjects[3].CellValue2(i, "cntr_cgo_seq") = cnt;
			sheetObjects[3].CellValue2(i, "spcl_cgo_seq") = cnt;
		}
		if (dcgo_seq < Number(sheetObjects[3].CellValue(i, "dcgo_seq"))) {
			dcgo_seq = Number(sheetObjects[3].CellValue(i, "dcgo_seq"));
		}
	}
	sheetObjects[3].CellValue2(row, "dcgo_seq") = Number(dcgo_seq) + 1;
	cntrChk();
	document.getElementById("cntr_cgo_seq").value = cnt;
	document.getElementById("dg_cntr_seq").value = "";
	document.getElementById("imdg_clss_cd").value = "";
	document.getElementById("imdg_comp_grp_cd").value = "";
	document.getElementById("imdg_un_no").value = "";
	document.getElementById("grs_wgt").value = "";
	document.getElementById("net_wgt").value = "";
	document.getElementById("prp_shp_nm").value = "";
	document.getElementById("hzd_desc").value = "";
//	document.getElementById("hzd_ctnt").value = "";
	document.form.hzd_ctnt.text2 = "";
	document.getElementById("stwg_temp_ctnt").value = "";
	document.getElementById("dflt_segr_grp_nm").value = "";
	document.getElementById("flsh_pnt_cdo_temp").value = "";
	document.getElementById("imdg_pck_grp_cd").value = "";
	document.getElementById("psa_no").value = "";
	document.getElementById("imdg_lmt_qty_flg").value = "";
	document.getElementById("imdg_expt_qty_flg").value = "";
	document.getElementById("hcdg_flag").value = "";
	document.getElementById("imdg_subs_rsk_lbl_cd1").value = "";
	document.getElementById("imdg_subs_rsk_lbl_cd2").value = "";
	document.getElementById("imdg_subs_rsk_lbl_cd3").value = "";
	document.getElementById("imdg_subs_rsk_lbl_cd4").value = "";
	document.getElementById("dcgo_sts_cd").value = "";
	document.getElementById("mrn_polut_flg").value = "";
	document.getElementById("emer_cntc_phn_no_ctnt").value = "";
	document.getElementById("emer_cntc_pson_nm").value = "";
	document.getElementById("dcgo_rqst_grp_eml1").value = "";
	document.getElementById("dcgo_rqst_grp_eml2").value = "";
	document.getElementById("certi_no").value = "";
	document.getElementById("cnee_dtl_desc").value = "";
	document.getElementById("net_explo_wgt").value = "";
	document.getElementById("rada_skd_no").value = "";
	document.getElementById("rada_amt").value = "";
	document.getElementById("rada_ut_cd").value = "";
	document.getElementById("rada_trsp_no").value = "";
	document.getElementById("temp_cntr_no").value = "";
	document.getElementById("in_imdg_pck_cd1").value = "";
	document.getElementById("in_imdg_pck_cd2").value = "";
	document.getElementById("intmd_imdg_pck_cd1").value = "";
	document.getElementById("intmd_imdg_pck_cd2").value = "";
	document.getElementById("out_imdg_pck_cd1").value = "";
	document.getElementById("out_imdg_pck_cd2").value = "";
	document.getElementById("in_imdg_pck_desc1").value = "";
	document.getElementById("in_imdg_pck_desc2").value = "";
	document.getElementById("intmd_imdg_pck_desc1").value = "";
	document.getElementById("intmd_imdg_pck_desc2").value = "";
	document.getElementById("out_imdg_pck_desc1").value = "";
	document.getElementById("out_imdg_pck_desc2").value = "";
	document.getElementById("in_imdg_pck_qty1").value = "";
	document.getElementById("in_imdg_pck_qty2").value = "";
	document.getElementById("intmd_imdg_pck_qty1").value = "";
	document.getElementById("intmd_imdg_pck_qty2").value = "";
	document.getElementById("out_imdg_pck_qty1").value = "";
	document.getElementById("out_imdg_pck_qty2").value = "";
	document.getElementById("out_imdg_pck_qty2").value = "";
	document.getElementById("imdg_expt_qty_cd").value = "";
	document.getElementById("max_in_pck_qty").value = "";
	document.getElementById("max_in_pck_tp_cd").value = "";
	document.getElementById("hcdg_intmd_bc_rstr_desc").value = "";
	document.getElementById("hcdg_pck_rstr_desc").value = "";
	document.getElementById("hcdg_tnk_rstr_desc").value = "";
	document.getElementById("ltd_qty").value = "";
	document.getElementById("ems_no").value = "";
	document.getElementById("emer_rspn_gid_no").value = "";
	document.getElementById("emer_rspn_gid_chr_no").value = "";
	document.getElementById("ctrl_temp_ctnt").value = "";
	document.getElementById("emer_temp_ctnt").value = "";
	document.getElementById("aply_no").value = "";
	htmlSheetSync();
	document.getElementById("temp_grs_wgt").value = "0";
	document.getElementById("temp_net_wgt").value = "0";
	var dcgo_seq = Number(sheetObjects[3].CellValue(1, "dcgo_seq"));
	for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
		if (dcgo_seq < Number(sheetObjects[3].CellValue(i, "dcgo_seq"))) {
			dcgo_seq = Number(sheetObjects[3].CellValue(i, "dcgo_seq"));
		}
		if (sheetObjects[3].CellValue(i, "DelChk") == "1") {
			sheetObjects[3].CellValue2(i, "DelChk") = "0";
		}
	}
	sheetObjects[3].CellValue2(row, "DelChk") = "1";
}

function rowDelete() {
	for ( var k = 1; k <= sheetObjects[3].RowCount; k++) {
		if (sheetObjects[1].CellValue(k, "DelChk") == "1") {
			if (sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "P" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "R" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "Y" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "N") {
				ComShowMessage(ComGetMsg("BKG00525"));
				return;
			}
		}
	}
	var sRow = sheetObjects[1].FindCheckedRow("DelChk");
	var arrRow = sRow.split("|");
	for (idx = 0; idx < arrRow.length - 1; idx++) {
		for ( var j = 1; j <= sheetObjects[3].RowCount; j++) {
			if (sheetObjects[1].CellValue(arrRow[idx], "cntr_no") == sheetObjects[3].CellValue(j, "cntr_no") && sheetObjects[1].CellValue(arrRow[idx], "dg_cntr_seq") == sheetObjects[3].CellValue(j, "dg_cntr_seq")) {
				sheetObjects[3].CellValue2(j, "CntrChk") = "1";
			}
		}
		for ( var k = 1; k <= sheetObjects[4].RowCount; k++) {
			if (sheetObjects[1].CellValue(arrRow[idx], "cntr_no") == sheetObjects[4].CellValue(k, "val")) {
				sheetObjects[4].CellValue2(k, "DelChk") = "0";
			}
		}
	}
	var find_row = sheetObjects[1].FindText("DelChk", "1", 0, 2);
	if (find_row > 0) {
		ComRowHideDelete(sheetObjects[1], "DelChk");
		ComRowHideDelete(sheetObjects[3], "CntrChk");
	}
	var cntr_name = "";
	var cntr_val = "";
	for ( var j = 1; j <= sheetObjects[4].RowCount; j++) {
		if (sheetObjects[4].CellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[4].CellValue(j, "name") + "|";
			cntr_val += sheetObjects[4].CellValue(j, "val") + "|";
		}
	}
	cntr_val = cntr_val.substr(0, cntr_val.length - 1);
	cntr_name = cntr_name.substr(0, cntr_name.length - 1);
	var cntr_no = "";
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		cntr_no = sheetObjects[1].CellValue(i, "cntr_no");
		sheetObjects[1].CellComboItem(i, "cntr_no", " |" + cntr_no + "|" + cntr_name, " |" + cntr_no + "|" + cntr_val);
		sheetObjects[1].CellValue2(i, "cntr_no") = cntr_no;
	}
	var row_find = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "ibflag") == "D") {
			row_find++;
		} else {
			sheetObjects[1].SelectCell(i, 0, false);
			cntrChk();
			htmlSheetSync();
			return;
		}
	}
	if (row_find == sheetObjects[1].RowCount) {
		document.getElementById("dg_cntr_seq").value = "";
		document.getElementById("cntr_cgo_seq").value = "";
		document.getElementById("imdg_clss_cd").value = "";
		document.getElementById("imdg_comp_grp_cd").value = "";
		document.getElementById("imdg_un_no").value = "";
		document.getElementById("grs_wgt").value = "";
		document.getElementById("net_wgt").value = "";
		document.getElementById("prp_shp_nm").value = "";
		document.getElementById("hzd_desc").value = "";
//		document.getElementById("hzd_ctnt").value = "";
		document.form.hzd_ctnt.text2 = "";
		document.getElementById("stwg_temp_ctnt").value = "";
		document.getElementById("dflt_segr_grp_nm").value = "";
		document.getElementById("flsh_pnt_cdo_temp").value = "";
		document.getElementById("imdg_pck_grp_cd").value = "";
		document.getElementById("psa_no").value = "";
		document.getElementById("imdg_lmt_qty_flg").value = "";
		document.getElementById("imdg_expt_qty_flg").value = "";
		document.getElementById("hcdg_flag").value = "";
		document.getElementById("imdg_subs_rsk_lbl_cd1").value = "";
		document.getElementById("imdg_subs_rsk_lbl_cd2").value = "";
		document.getElementById("imdg_subs_rsk_lbl_cd3").value = "";
		document.getElementById("imdg_subs_rsk_lbl_cd4").value = "";
		document.getElementById("dcgo_sts_cd").value = "";
		document.getElementById("mrn_polut_flg").value = "";
		document.getElementById("emer_cntc_phn_no_ctnt").value = "";
		document.getElementById("emer_cntc_pson_nm").value = "";
		document.getElementById("dcgo_rqst_grp_eml1").value = "";
		document.getElementById("dcgo_rqst_grp_eml2").value = "";
		document.getElementById("certi_no").value = "";
		document.getElementById("cnee_dtl_desc").value = "";
		document.getElementById("net_explo_wgt").value = "";
		document.getElementById("rada_skd_no").value = "";
		document.getElementById("rada_amt").value = "";
		document.getElementById("rada_ut_cd").value = "";
		document.getElementById("rada_trsp_no").value = "";
		document.getElementById("temp_cntr_no").value = "";
		document.getElementById("in_imdg_pck_cd1").value = "";
		document.getElementById("in_imdg_pck_cd2").value = "";
		document.getElementById("intmd_imdg_pck_cd1").value = "";
		document.getElementById("intmd_imdg_pck_cd2").value = "";
		document.getElementById("out_imdg_pck_cd1").value = "";
		document.getElementById("out_imdg_pck_cd2").value = "";
		document.getElementById("in_imdg_pck_desc1").value = "";
		document.getElementById("in_imdg_pck_desc2").value = "";
		document.getElementById("intmd_imdg_pck_desc1").value = "";
		document.getElementById("intmd_imdg_pck_desc2").value = "";
		document.getElementById("out_imdg_pck_desc1").value = "";
		document.getElementById("out_imdg_pck_desc2").value = "";
		document.getElementById("in_imdg_pck_qty1").value = "";
		document.getElementById("in_imdg_pck_qty2").value = "";
		document.getElementById("intmd_imdg_pck_qty1").value = "";
		document.getElementById("intmd_imdg_pck_qty2").value = "";
		document.getElementById("out_imdg_pck_qty1").value = "";
		document.getElementById("out_imdg_pck_qty2").value = "";
		document.getElementById("imdg_expt_qty_cd").value = "";
		document.getElementById("max_in_pck_qty").value = "";
		document.getElementById("max_in_pck_tp_cd").value = "";
		document.getElementById("hcdg_intmd_bc_rstr_desc").value = "";
		document.getElementById("hcdg_pck_rstr_desc").value = "";
		document.getElementById("hcdg_tnk_rstr_desc").value = "";
		document.getElementById("ltd_qty").value = "";
		document.getElementById("ems_no").value = "";
		document.getElementById("emer_rspn_gid_no").value = "";
		document.getElementById("emer_rspn_gid_chr_no").value = "";
		document.getElementById("ctrl_temp_ctnt").value = "";
		document.getElementById("emer_temp_ctnt").value = "";
		document.getElementById("temp_grs_wgt").value = "";
		document.getElementById("temp_net_wgt").value = "";
		document.getElementById("aply_no").value = "";
	}
}

function deleteRows() {
	for ( var k = 1; k <= sheetObjects[3].RowCount; k++) {
		if (sheetObjects[3].CellValue(k, "DelChk") == "1") {
			if (sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "P" || sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "R" || sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "Y" || sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "N") {
				ComShowMessage(ComGetMsg("BKG00525"));
				return;
			}
		}
	}
	ComRowHideDelete(sheetObjects[3], "DelChk");
	var cnt = 0;
	document.getElementById("cntr_cgo_seq").options.length = 0;
	for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
		if (sheetObjects[3].CellValue(i, "CntrChk") == "1" && sheetObjects[3].CellValue(i, "ibflag") != "D") {
			cnt++;
			sheetObjects[3].CellValue2(i, "cntr_cgo_seq") = cnt;
			sheetObjects[3].CellValue2(i, "spcl_cgo_seq") = cnt;
			var cntr_cgo_seq = sheetObjects[3].CellValue(i, "cntr_cgo_seq");
			document.getElementById("cntr_cgo_seq").options[cnt - 1] = new Option(cntr_cgo_seq, cntr_cgo_seq);
		}
		sheetObjects[3].CellValue2(i, "bkg_cntr_seq") = sheetObjects[3].CellValue(i, "dg_cntr_seq") + sheetObjects[3].CellValue(i, "cntr_cgo_seq");
	}
	document.getElementById("cntr_cgo_seq_sum").value = cnt;
	if (cnt > 0) {
		document.getElementById("cntr_cgo_seq").value = cnt;
		cntrChk();
		htmlSheetSync();

	} else {
		var dg_cntr_seq = document.getElementById("dg_cntr_seq").value;
		var find_cntr_no = sheetObjects[1].FindText("dg_cntr_seq", dg_cntr_seq, 0, 2);
		sheetObjects[1].CellValue2(find_cntr_no, "DelChk") = "1";
		ComRowHideDelete(sheetObjects[1], "DelChk");
	}
	var row_find = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			sheetObjects[1].SelectCell(i, 0, true);
			cntrChk();
			htmlSheetSync();
			return;
		} else {
			row_find++;
		}
	}
	if (row_find == sheetObjects[1].RowCount) {
		document.getElementById("temp_seq").value = "";
		document.getElementById("cntr_cgo_seq").value = "";
		document.getElementById("imdg_clss_cd").value = "";
		document.getElementById("imdg_comp_grp_cd").value = "";
		document.getElementById("imdg_un_no").value = "";
		document.getElementById("grs_wgt").value = "";
		document.getElementById("net_wgt").value = "";
		document.getElementById("prp_shp_nm").value = "";
		document.getElementById("hzd_desc").value = "";
//		document.getElementById("hzd_ctnt").value = "";
		document.form.hzd_ctnt.text2 = "";
		document.getElementById("stwg_temp_ctnt").value = "";
		document.getElementById("dflt_segr_grp_nm").value = "";
		document.getElementById("flsh_pnt_cdo_temp").value = "";
		document.getElementById("imdg_pck_grp_cd").value = "";
		document.getElementById("psa_no").value = "";
		document.getElementById("imdg_lmt_qty_flg").value = "";
		document.getElementById("imdg_expt_qty_flg").value = "";
		document.getElementById("hcdg_flag").value = "";
		document.getElementById("imdg_subs_rsk_lbl_cd1").value = "";
		document.getElementById("imdg_subs_rsk_lbl_cd2").value = "";
		document.getElementById("imdg_subs_rsk_lbl_cd3").value = "";
		document.getElementById("imdg_subs_rsk_lbl_cd4").value = "";
		document.getElementById("dcgo_sts_cd").value = "";
		document.getElementById("mrn_polut_flg").value = "";
		document.getElementById("emer_cntc_phn_no_ctnt").value = "";
		document.getElementById("emer_cntc_pson_nm").value = "";
		document.getElementById("dcgo_rqst_grp_eml1").value = "";
		document.getElementById("dcgo_rqst_grp_eml2").value = "";
		document.getElementById("certi_no").value = "";
		document.getElementById("cnee_dtl_desc").value = "";
		document.getElementById("net_explo_wgt").value = "";
		document.getElementById("rada_skd_no").value = "";
		document.getElementById("rada_amt").value = "";
		document.getElementById("rada_ut_cd").value = "";
		document.getElementById("rada_trsp_no").value = "";
		document.getElementById("temp_cntr_no").value = "";
		document.getElementById("in_imdg_pck_cd1").value = "";
		document.getElementById("in_imdg_pck_cd2").value = "";
		document.getElementById("intmd_imdg_pck_cd1").value = "";
		document.getElementById("intmd_imdg_pck_cd2").value = "";
		document.getElementById("out_imdg_pck_cd1").value = "";
		document.getElementById("out_imdg_pck_cd2").value = "";
		document.getElementById("in_imdg_pck_desc1").value = "";
		document.getElementById("in_imdg_pck_desc2").value = "";
		document.getElementById("intmd_imdg_pck_desc1").value = "";
		document.getElementById("intmd_imdg_pck_desc2").value = "";
		document.getElementById("out_imdg_pck_desc1").value = "";
		document.getElementById("out_imdg_pck_desc2").value = "";
		document.getElementById("in_imdg_pck_qty1").value = "";
		document.getElementById("in_imdg_pck_qty2").value = "";
		document.getElementById("intmd_imdg_pck_qty1").value = "";
		document.getElementById("intmd_imdg_pck_qty2").value = "";
		document.getElementById("out_imdg_pck_qty1").value = "";
		document.getElementById("out_imdg_pck_qty2").value = "";
		document.getElementById("imdg_expt_qty_cd").value = "";
		document.getElementById("max_in_pck_qty").value = "";
		document.getElementById("max_in_pck_tp_cd").value = "";
		document.getElementById("hcdg_intmd_bc_rstr_desc").value = "";
		document.getElementById("hcdg_pck_rstr_desc").value = "";
		document.getElementById("hcdg_tnk_rstr_desc").value = "";
		document.getElementById("ltd_qty").value = "";
		document.getElementById("ems_no").value = "";
		document.getElementById("emer_rspn_gid_no").value = "";
		document.getElementById("emer_rspn_gid_chr_no").value = "";
		document.getElementById("ctrl_temp_ctnt").value = "";
		document.getElementById("emer_temp_ctnt").value = "";
		document.getElementById("temp_grs_wgt").value = "";
		document.getElementById("temp_net_wgt").value = "";
		document.getElementById("aply_no").value = "";
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 102;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 4, 100);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(4, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false)
				var HeadTitle1 = "TP/SZ|BKG Q'ty|DG Q'ty";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daRight, true, "op_cntr_qty", false, "", dfFloat, 2, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "dcgo_qty", false, "", dfFloat, 2, true, true);
				InitDataProperty(0, cnt++, dtHidden, 40, daRight, false, "eq_tpsz", false, "", dfFloat, 2, true, true);
				CountPosition = 0;
			}
			break;
	
		case 2: //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = 142;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 4, 100);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(61, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)
				var HeadTitle1 = "|Seq||Container No.|TS|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no|dg_cgo_seq" + "|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm|hzd_desc"
						+ "|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|hcdg_flag|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4" + "|dcgo_sts_cd|mrn_polut_flg|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|dcgo_rqst_grp_eml1|dcgo_rqst_grp_eml2|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt|rada_ut_cd"
						+ "|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk||meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_dpnd_qty_flg|spcl_rqst_flg|spcl_rqst_desc|rc_seq|awk_cgo_seq|bb_cgo_seq|dg_cntr_seq|grs_capa_qty";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "DelChk");
				InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
				InitDataProperty(0, cnt++, dtHiddenStatus, 20, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtCombo, 95, daCenter, true, "cntr_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, true, true, 2);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "cntr_vol_qty", false, "", dfFloat, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "spcl_cgo_apro_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cargo_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cargo_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bkg_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dg_cgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cntr_cgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_clss_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_comp_grp_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_un_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_un_no_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "grs_wgt", false, "", dfFloat, 2, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "wgt_ut_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "net_wgt", false, "", dfFloat, 2, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "prp_shp_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hzd_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "flsh_pnt_cdo_temp", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_pck_grp_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "psa_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_lmt_qty_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_expt_qty_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd3", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd4", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "mrn_polut_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_cntc_phn_no_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_cntc_pson_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_rqst_grp_eml1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_rqst_grp_eml2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "certi_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cnee_dtl_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "net_explo_wgt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_skd_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_amt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_ut_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_trsp_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "clod_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cgo_lcl_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "diff_rmk", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "meas_qty", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rc_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "awk_cgo_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bb_cgo_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_dpnd_qty_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_rqst_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_rqst_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rc_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "awk_cgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bb_cgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dg_cntr_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "approved", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "grs_capa_qty", false, "", dfNone, 0, false, true);
				//InitDataCombo(0, "ContainNo1", "HJCU1234567|HJCU1234568|HJCU1234569", "HJCU1234567|HJCU1234568|HJCU1234569");
				CountPosition = 0;
			}
			break;
	
		case 3: //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 4, 100);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(22, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false)
				var HeadTitle1 = "bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|del_cd|bkg_sts_cd|corr_n1st_dt||bdr_flg||||||dest_trns_mod_cd||||";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, false);
				//데이터속성    [  ROW, COL,  DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 	70, daCenter,false, "bkg_no", 			false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "bl_no", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "vsl_cd", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "pol_cd", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "pol_nod_cd", 		false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "pod_cd", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "pod_nod_cd", 		false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "del_cd", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "bkg_sts_cd", 		false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "corr_n1st_dt", 	false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "corr_no", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "bdr_flg", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "vsl_pre_pst_cd",	false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "flex_hgt_flg", 	false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "slan_cd", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "vessel_nm", 		false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtHidden,40, daRight, false, "img_flg", 			false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 	40, daRight, false, "dest_trns_mod_cd", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtHidden,40, daRight, false, "crr_pre_chk_cd", 	false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtHidden,40, daRight, false, "opr_pre_chk_cd", 	false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtHidden,40, daRight, false, "pck_pre_chk_cd", 	false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtHidden,40, daRight, false, "segr_pre_chk_cd", 	false, "", dfNone, 2, true, true);
				CountPosition = 0;
			}
			break;
	
		case 4: //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 4, 100);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(108, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false)
				var HeadTitle1 = "|||Seq|Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no" + "|dg_cgo_seq|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|spcl_provi_no|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm"
						+ "|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3" + "|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_mrn_polut_cd|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|dcgo_rqst_grp_eml1|dcgo_rqst_grp_eml2|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt"
						+ "|rada_ut_cd|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk|bkg_cntr_seq|in_imdg_pck_cd1|in_imdg_pck_cd2|out_imdg_pck_cd1" + "|out_imdg_pck_cd2|||in_imdg_pck_desc1|in_imdg_pck_desc2|||out_imdg_pck_desc1|out_imdg_pck_desc2|in_imdg_pck_qty1|in_imdg_pck_qty2|||out_imdg_pck_qty1|out_imdg_pck_qty2|max_in_pck_qty"
						+ "|max_in_pck_tp_cd|hcdg_intmd_bc_rstr_desc|hcdg_pck_rstr_desc|hcdg_tnk_rstr_desc|ltd_qty|ems_no|emer_rspn_gid_no|emer_rspn_gid_chr_no|ctrl_temp_ctnt|emer_temp_ctnt"
						+ "|dcgo_seq|modifyaproflg|dg_cntr_seq|meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_flg|hcdg_qty|hcdg_dpnd_qty_flg|imdg_spcl_provi_no|imdg_crr_rstr_expt_cd|spcl_rqst_flg|spcl_rqst_desc|imdg_expt_qty_cd|crr_cd|por_cd|del_cd|rcv_term_cd|de_term_cd|spcl_cgo_seq|spcl_cntr_seq|apro_cd|||hzd_ctnt|stwg_temp_ctnt|dflt_segr_grp_nm|grs_capa_qty";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "CntrChk");
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "DelChk");
				InitDataProperty(0, cnt++, dtStatus, 20, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_vol_qty", false, "", dfFloat, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "spcl_cgo_apro_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bkg_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dg_cgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cntr_cgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_clss_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_comp_grp_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_un_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_un_no_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "spcl_provi_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "grs_wgt", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "wgt_ut_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "net_wgt", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "prp_shp_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hzd_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "flsh_pnt_cdo_temp", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_pck_grp_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "psa_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_lmt_qty_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_expt_qty_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd3", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_subs_rsk_lbl_cd4", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "mrn_polut_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_mrn_polut_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_cntc_phn_no_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_cntc_pson_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dcgo_rqst_grp_eml1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dcgo_rqst_grp_eml2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "certi_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cnee_dtl_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "net_explo_wgt", false, "", dfFloat, 1, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_skd_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_amt", false, "", dfFloat, 2, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_ut_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rada_trsp_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "clod_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cgo_lcl_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "diff_rmk", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bkg_cntr_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_cd1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_cd2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_cd1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_cd2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_cd1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_cd2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_desc1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_desc2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_desc1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_desc2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_desc1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_desc2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_qty1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "in_imdg_pck_qty2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_qty1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "intmd_imdg_pck_qty2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_qty1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "out_imdg_pck_qty2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "max_in_pck_qty", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "max_in_pck_tp_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_intmd_bc_rstr_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_pck_rstr_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_tnk_rstr_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ltd_qty", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ems_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_rspn_gid_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_rspn_gid_chr_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ctrl_temp_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "emer_temp_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "dcgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "modifyaproflg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dg_cntr_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "meas_qty", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rc_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "awk_cgo_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bb_cgo_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_qty", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "hcdg_dpnd_qty_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_spcl_provi_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_crr_rstr_expt_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_rqst_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_rqst_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "imdg_expt_qty_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "crr_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "por_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "del_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rcv_term_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "de_term_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_cgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "spcl_cntr_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "apro_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "eq_tpsz", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "aply_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "hzd_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "stwg_temp_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "dflt_segr_grp_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "grs_capa_qty", false, "", dfNone, 0, false, true);
				CountPosition = 0;
			}
			break;
	
		case 5: //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle1 = "|value|name||";
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(5, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, false, "DelChk");
				InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "val", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "name", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_vol_qty", false, "", dfNone, 0, true, true);
			}
			break;
		case 6:      //t2sheet6 init, Irregular List를 위한 히든시트
     		with (sheetObj) {
     			// 높이 설정
     			style.height = 0;
     			style.width  = 0;		          
     			//전체 너비 설정
     			SheetWidth = mainTable.clientWidth;
	
     			//Host정보 설정[필수][HostIp, Port, PagePath]
     			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
     			//전체Merge 종류 [선택, Default msNone]
     			MergeSheet = msHeaderOnly;
	
     			//전체Edit 허용 여부 [선택, Default false]
     			Editable = false;
	
     			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     			InitRowInfo(1, 1, 1, 100);
	
     			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     			InitColumnInfo(8, 0, 0, true);
	
     			// 해더에서 처리할 수 있는 각종 기능을 설정한다
     			InitHeadMode(true, true, true, true, false )
	
     			var HeadTitle1 = "|Type|Port Code|Required|Explanation";
	
     			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
     			InitHeadRow(0, HeadTitle1, false, true);
	
     			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     			InitDataProperty(0, cnt++ , dtData,	        60,	    	daCenter,	true,		"crr_cd1",		false,           "",      dfNone, 			0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,		    60,		    daCenter,	true,		"crr_cd2",	    false,           "",      dfNone, 			0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,		    60,	        daCenter,	true,		"crr_cd3",		false,           "",      dfNone, 			0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,			60,	        daCenter,	true,		"crr_cd4",      false,           "",      dfNone, 			0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,			60,		    daCenter,	true,		"crr_cd5",	    false,           "",      dfNone, 			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,         60,         daCenter,   true,       "crr_cd6",      false,           "",      dfNone,           0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,         60,         daCenter,   true,       "crr_cd7",      false,           "",      dfNone,           0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,         60,         daCenter,   true,       "crr_cd8",      false,           "",      dfNone,           0,     true,       true);
							
                //선택된 행의 하이라이트를 안준다.
                SelectHighLight = false;

                ShowButtonImage = 1;
				//DataLinkMouse = true;
				CountPosition = 0;
						
		    }
     		break; 
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
//			if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value = SEARCH;
			unNoCngFlg = "N";
			var resultXml = sheetObj.GetSearchXml("ESM_BKG_0200GS.do", FormQueryString(formObj));	
			var arrXml = resultXml.split("|$$|");
			if (arrXml.length == 6) {
				var etcXml = arrXml[0];
				//Irregulars List 색 변경을 위해 먼저 값을 불러옴
				if (ComGetEtcData(etcXml, "imdg_un_no") == "null" || ComGetEtcData(etcXml, "imdg_un_no") == "") {
					document.getElementById("imdg_un_no").innerText = "";
				} else {
					document.getElementById("imdg_un_no").innerText = ComGetEtcData(etcXml, "imdg_un_no");
				}
				if (ComGetEtcData(etcXml, "rqst_dt") == "null" || ComGetEtcData(etcXml, "rqst_dt") == "") {
					document.getElementById("rqst_dt").innerText = "";
					document.getElementById("rqst_usr_id").innerText = "";
				} else {
					document.getElementById("rqst_dt").innerText = ComGetEtcData(etcXml, "rqst_dt");
					document.getElementById("rqst_usr_id").innerText = ComGetEtcData(etcXml, "rqst_usr_id");
				}
				if (ComGetEtcData(etcXml, "rqst_gdt") == "null" || ComGetEtcData(etcXml, "rqst_gdt") == "") {
					document.getElementById("rqst_gdt").innerText = "";
				} else {
					document.getElementById("rqst_gdt").innerText = ComGetEtcData(etcXml, "rqst_gdt");
				}
				if (arrXml[4].indexOf("TOTAL='0'") < 1) {
					var arrCombo = ComXml2ComboString(arrXml[4], "val", "name");
					sheetObjects[1].InitDataCombo(0, "cntr_no", arrCombo[0], arrCombo[1], "");
				}
				sheetObjects[0].LoadSearchXml(arrXml[2], false);
				sheetObjects[1].LoadSearchXml(arrXml[0], false);
				sheetObjects[2].LoadSearchXml(arrXml[3], false);
				sheetObjects[3].LoadSearchXml(arrXml[1], false);
				sheetObjects[4].LoadSearchXml(arrXml[4], false);
				if (document.getElementById("bkg_no").value == "") {
					document.getElementById("bkg_no").value = sheetObjects[2].CellValue(1, "bkg_no");
				}
				document.getElementById("bl_no").value = sheetObjects[2].CellValue(1, "bl_no");
				document.getElementById("vsl_cd").value = sheetObjects[2].CellValue(1, "vsl_cd");
				document.getElementById("pol_cd").value = sheetObjects[2].CellValue(1, "pol_cd");
				document.getElementById("pod_cd").value = sheetObjects[2].CellValue(1, "pod_cd");
				document.getElementById("del_cd").value = sheetObjects[2].CellValue(1, "del_cd");
				document.getElementById("dest_trns_mod_cd").value = sheetObjects[2].CellValue(1, "dest_trns_mod_cd");
				document.getElementById("pol_nod_cd").value = sheetObjects[2].CellValue(1, "pol_nod_cd");
				document.getElementById("pod_nod_cd").value = sheetObjects[2].CellValue(1, "pod_nod_cd");
				document.getElementById("slan_cd").value = sheetObjects[2].CellValue(1, "slan_cd");
				document.getElementById("vessel_nm").value = sheetObjects[2].CellValue(1, "vessel_nm");
//				document.getElementById("crr_pre_chk_cd").value = sheetObjects[2].CellValue(1, "crr_pre_chk_cd");
//				document.getElementById("opr_pre_chk_cd").value = sheetObjects[2].CellValue(1, "opr_pre_chk_cd");
				if(sheetObjects[2].CellValue(1, "crr_pre_chk_cd") == 'R'){
		            document.getElementById("crr_pre_chk_cd").value = "△";
		            document.getElementById("crr_pre_chk_cd").style.color = "blue";
				}else if(sheetObjects[2].CellValue(1, "crr_pre_chk_cd") == 'X'){
		            document.getElementById("crr_pre_chk_cd").value = sheetObjects[2].CellValue(1, "crr_pre_chk_cd");
		            document.getElementById("crr_pre_chk_cd").style.color = "red";
				}else{
		            document.getElementById("crr_pre_chk_cd").value = sheetObjects[2].CellValue(1, "crr_pre_chk_cd");
		            document.getElementById("crr_pre_chk_cd").style.color = "black";
				}
				if(sheetObjects[2].CellValue(1, "opr_pre_chk_cd") == 'R'){
		            document.getElementById("opr_pre_chk_cd").value = "△";
		            document.getElementById("opr_pre_chk_cd").style.color = "blue";
				}else if(sheetObjects[2].CellValue(1, "opr_pre_chk_cd") == 'X'){
		            document.getElementById("opr_pre_chk_cd").value = sheetObjects[2].CellValue(1, "opr_pre_chk_cd");
		            document.getElementById("opr_pre_chk_cd").style.color = "red";
				}else{
		            document.getElementById("opr_pre_chk_cd").value = sheetObjects[2].CellValue(1, "opr_pre_chk_cd");
		            document.getElementById("opr_pre_chk_cd").style.color = "black";
				} 
 

				document.getElementById("pck_pre_chk_cd").value = sheetObjects[2].CellValue(1, "pck_pre_chk_cd");
				document.getElementById("segr_pre_chk_cd").value = sheetObjects[2].CellValue(1, "segr_pre_chk_cd");
	
				for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
					if (Number(sheetObjects[0].CellValue(i, "dcgo_qty")) < 1) {
						for ( var j = 1; j <= sheetObjects[1].RowCount; j++) {
							if (sheetObjects[0].CellValue(i, "cntr_tpsz_cd") == sheetObjects[1].CellValue(j, "cntr_tpsz_cd")) {
								sheetObjects[1].CellValue2(j, "cntr_vol_qty") = Number(sheetObjects[0].CellValue(i, "dcgo_qty"));
							}
						}
					}
				}
				var cntSeq = 0;
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					sheetObjects[1].CellValue2(i, "ibflag") = "I";
					if (sheetObjects[1].CellValue(i, "rc_seq") != "") {
						sheetObjects[1].CellValue2(i, "cargo_nm") = "RF";
						sheetObjects[1].CellValue2(i, "cargo_seq") = sheetObjects[1].CellValue(i, "rc_seq");
					} else if (sheetObjects[1].CellValue(i, "awk_cgo_seq") != "") {
						sheetObjects[1].CellValue2(i, "cargo_nm") = "AWK";
						sheetObjects[1].CellValue2(i, "cargo_seq") = sheetObjects[1].CellValue(i, "awk_cgo_seq");
					} else if (sheetObjects[1].CellValue(i, "bb_cgo_seq") != "") {
						sheetObjects[1].CellValue2(i, "cargo_nm") = "BB";
						sheetObjects[1].CellValue2(i, "cargo_seq") = sheetObjects[1].CellValue(i, "bb_cgo_seq");
					} else {
						cntSeq++;
					}
				}
				if (cntSeq == sheetObjects[1].RowCount) {
					sheetObjects[1].ColHidden("cargo_nm") = true;
					sheetObjects[1].ColHidden("cargo_seq") = true;
				} else {
					sheetObjects[1].ColHidden("cargo_nm") = false;
					sheetObjects[1].ColHidden("cargo_seq") = false;
				}
				//sheetObjects[1].CellValue2(1, "DelChk") = "1";  					
				for ( var j = 1; j <= sheetObjects[1].RowCount; j++) {
					var cntr_no = sheetObjects[1].CellValue(j, "cntr_no");
					if (cntr_no != "") {
						var find_row = sheetObjects[4].FindText("name", cntr_no, 0, 2);
						sheetObjects[4].CellValue2(find_row, "DelChk") = "1";
					}
				}
	
				cntrChk();
	
				for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
					sheetObjects[3].CellValue2(i, "spcl_cgo_seq") = sheetObjects[3].CellValue(i, "cntr_cgo_seq");
					sheetObjects[3].CellValue2(i, "spcl_cntr_seq") = sheetObjects[3].CellValue(i, "dg_cntr_seq");
	
					if (sheetObjects[3].CellValue(i, "crr_cd") != "") {
						sheetObjects[3].CellValue2(i, "imdg_crr_rstr_expt_cd") = "R";
					}
				}
				var cnt = 0;
				var sum = 0;
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "Y") {
						cnt++;
					}
					var tpszN2 = 0;
					var tpszP2 = 0;
					var tpszR2 = 0;
					var tpszY2 = 0;
					var tpszC2 = 0;
					for ( var k = 1; k <= sheetObjects[3].RowCount; k++) {
						if (sheetObjects[1].CellValue(i, "cntr_no") == sheetObjects[3].CellValue(k, "cntr_no") && sheetObjects[1].CellValue(i, "dg_cntr_seq") == sheetObjects[3].CellValue(k, "dg_cntr_seq")) {
							if (sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "Y") {
								tpszY2++;
							} else if (sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "N") {
								tpszN2++;
							} else if (sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "P") {
								tpszP2++;
							} else if (sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "R") {
								tpszR2++;
							} else if (sheetObjects[3].CellValue(k, "spcl_cgo_apro_cd") == "C") {
								tpszC2++;
							} else {
							}
						}
					}
					if (tpszN2 > 0) {
						sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "N";
					}
					if (tpszP2 > 0 && tpszN2 == "0") {
						sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "P";
					}
					if (tpszR2 > 0 && tpszN2 == "0" && tpszP2 == "0") {
						sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "R";
					}
					if (tpszY2 > 0 && tpszR2 == "0" && tpszN2 == "0" && tpszP2 == "0") {
						sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "Y";
					}
					if (tpszY2 == 0 && tpszR2 == 0 && tpszN2 == 0 && tpszP2 == 0) {
						sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "";
					}
					if (tpszC2 > 0 && tpszY2 == 0 && tpszR2 == 0 && tpszN2 == 0 && tpszP2 == 0) {
						sheetObjects[1].CellValue2(i, "spcl_cgo_apro_cd") = "C";
					}
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "N") {
						sheetObjects[1].CellFontColor(i, "spcl_cgo_apro_cd") = sheetObjects[1].RgbColor(255, 0, 0);
						sheetObjects[1].CellFont("FontBold", i, "spcl_cgo_apro_cd") = true;
					}
				}
				for ( var j = 1; j <= sheetObjects[0].RowCount; j++) {
					if (sheetObjects[0].CellValue(j, "cntr_tpsz_cd").indexOf("Q") == -1) {
						sum += Number(sheetObjects[0].CellValue(j, "dcgo_qty"));
					}
				}
				var tpszN = sheetObjects[1].FindText("spcl_cgo_apro_cd", "N", 0, 2);
				var tpszP = sheetObjects[1].FindText("spcl_cgo_apro_cd", "P", 0, 2);
				var tpszR = sheetObjects[1].FindText("spcl_cgo_apro_cd", "R", 0, 2);
				var tpszY = sheetObjects[1].FindText("spcl_cgo_apro_cd", "Y", 0, 2);
				if (tpszN > 0) {
					document.getElementById("spcl_cgo_auth_cd").value = "N";
					document.getElementById("spcl_cgo_auth_cd").style.color = "red";
				} else if (tpszP > 0 && tpszN < 0) {
					document.getElementById("spcl_cgo_auth_cd").style.color = "black";
					document.getElementById("spcl_cgo_auth_cd").value = "P";
					
					for(var idx=1;idx<=sheetObjects[1].RowCount;idx++){
						if(sheetObjects[1].CellValue(idx,"cntr_no") != ""){
							sheetObjects[1].CellEditable(idx, "cntr_no") = false;
						}
					}
					
				} else if (tpszR > 0 && tpszN < 0 && tpszP < 0) {
					document.getElementById("spcl_cgo_auth_cd").style.color = "black";
					document.getElementById("spcl_cgo_auth_cd").value = "R";
				} else if (tpszY > 0 && tpszR < 0 && tpszN < 0 && tpszP < 0) {
					document.getElementById("spcl_cgo_auth_cd").style.color = "black";
					document.getElementById("spcl_cgo_auth_cd").value = "Y";
				} else if (tpszY < 0 && tpszR < 0 && tpszN < 0 && tpszP < 0) {
					document.getElementById("spcl_cgo_auth_cd").style.color = "black";
					document.getElementById("spcl_cgo_auth_cd").value = "";
				} else {
					document.getElementById("spcl_cgo_auth_cd").style.color = "";
					document.getElementById("spcl_cgo_auth_cd").value = "";
				}
				htmlSheetSync();
				
				for ( var a = 1; a <= sheetObjects[3].RowCount; a++) {
					sheetObjects[3].CellValue2(a, "ibflag") = "R";
				}
				if (sheetObjects[1].RowCount < 1 && document.getElementById("bl_no").value != "") {
					rowAdd();
				} else if (sheetObjects[1].RowCount < 1 && document.getElementById("bl_no").value == "") {
					ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
					return;
				}
			}
			//------------------------------------------------>
			//setInquiryDisableButton 이벤트 호출
			if (ComGetObjValue(document.form.isInquiry) == "Y") {
				setInquiryDisableButton();
			}
			document.getElementById("imdg_pck_grp_cd").disabled = true;
			
			pendingSaveFlg = "Y";	//조회 시 Flag 초기화 
	
			// pre-checking status 조회	
//		 	var sParam = makePreChkParam();
//			formObj.f_cmd.value = SEARCH04;
//	
//			var sXml = sheetObj.GetSearchXml("VOP_SCG_0069GS.do?f_cmd="+formObj.f_cmd.value, sParam);
//			var arrXml = sXml.split("|$$|");
//	        var arrData = ComScgXml2Array(arrXml[0], "crr_flg|port_flg|seg_flg|expt_qty_flg|ltd_qty_flg|pi_flg|spcl_cntr_seq|spcl_cgo_seq");
//	
//	        if(arrData != null){
//		        for(i = 0; i < arrData.length; i++){
//		        	if(arrData[i][6] == formObj.dg_cntr_seq.value && arrData[i][7] == formObj.cntr_cgo_seq.value){
//		        		if(arrData[i][0] == "X"){
//				        	ComSetObjValue(formObj.pre_crr, "X");
//				        }else{
//				        	ComSetObjValue(formObj.pre_crr, "O");
//				        }
//				        if(arrData[i][1] == "X"){
//				        	ComSetObjValue(formObj.pre_opr, "X");
//				        }else{
//				        	ComSetObjValue(formObj.pre_opr, "O");
//				        }
//				        if(arrData[i][2] == "X"){
//				        	ComSetObjValue(formObj.pre_sgr, "X");
//				        }else{
//				        	ComSetObjValue(formObj.pre_sgr, "O");
//				        }
//				        if(arrData[i][3] == "X" || arrData[i][4] == "X" || arrData[i][5] == "X" ){ 
//				        	ComSetObjValue(formObj.pre_pck, "X");
//				        }else if( arrData[i][3] == "M" || arrData[i][4] == "M" || arrData[i][5] == "M" ){
//				        	ComSetObjValue(formObj.pre_pck, "M");
//				        }else{
//				        	ComSetObjValue(formObj.pre_pck, "O");
//				        }
//		        	}
//		        }
//	        }
			
			//
//			ComSetObjValue(formObj.irregular_list, searchIrrForUnNo());
//			formObj.irregular_list.value = searchIrrForUnNo();
//			alert(formObj.irregular_list.value);
			break;
	
		case COMMAND04: //booking split no조회 
			formObj.f_cmd.value = COMMAND03;
			var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
			var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
			bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 25);
	
			break;
	
		case COMMAND05: // Validation Check
			formObj.f_cmd.value = COMMAND05;
			var param = "&f_cmd=" + COMMAND05 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0200GS.do", param);
			// 2017.06.05 iylee Validation Check 결과에 따른 진행여부를 판단 
			if(ComGetEtcData(sXml, "warn_msg") != "" && ComGetEtcData(sXml, "warn_msg") != undefined){
				var warnMsg = ComGetEtcData(sXml,"warn_msg");
				/*if (ComShowConfirm(warnMsg)) {
					continueWarnMsgFlg = "Y";
				} else {
					continueWarnMsgFlg = "N";
				}				
				return continueWarnMsgFlg;*/
				ComShowMessage(warnMsg);
				return  "N";
			} else {
				return  "Y";
			}
			
			break;
			
		case IBSAVE: //저장	
			var cntrNo = "";
			var oldCntrNo = "";
			var dgChkFlg = "N";
			var limitQtyFlg = "N";
	
			if (validateForm(sheetObj, formObj, sAction)) {
				//BDR 이후 저정 Blocking
				if (sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "bdr_flg") == "Y") {
					ComShowMessage(ComGetMsg("BKG00004"));
					chkFlg = "Y";
					return;
				}

/*				if (sheetObjects[3].CellValue(1, "imdg_un_no_seq") == "") {
					ComShowCodeMessage("BKG02090", "[" + seq + "." + cntr_cgo_seq + "]");
					chkFlg = "Y";
					return;
				} */			
				
				if (saveChkFlg == "Y") {
					var cntR = 0;
					var cntHCDG = 0;
					for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
						if (sheetObjects[3].CellValue(i, "ibflag") != "R") {
							cntR++;
						}
					}
					if (cntR < 1) {
						ComShowMessage(ComGetMsg("BKG00501"));
						saveEnd = "Y";
						return;
					}
	
					for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
						//삭제일 경우 Validate Skip
						if( sheetObjects[3].RowHidden(i) || sheetObjects[3].CellValue(i, "ibflag") == "D"){
							continue;
						}
											
						if (sheetObjects[3].CellValue(i, "apro_cd") != "C" || sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") != "C" || sheetObjects[3].CellValue(i, "ibflag") != "D") {
							if (sheetObjects[3].CellValue(i, "spcl_cgo_apro_cd") == "P" && pendingSaveFlg == "N") {
								ComShowMessage(ComGetMsg("BKG00500"));
								chkFlg = "Y";
								return;
							}
							for ( var j = 1; j <= sheetObjects[1].RowCount; j++) {
								if (sheetObjects[3].CellValue(i, "cntr_no") == sheetObjects[1].CellValue(j, "cntr_no") && sheetObjects[3].CellValue(i, "dg_cntr_seq") == sheetObjects[1].CellValue(j, "dg_cntr_seq")) {
									var seq = sheetObjects[1].CellValue(j, "seq");
								}
							}
							var cntr_cgo_seq = sheetObjects[3].CellValue(i, "cntr_cgo_seq");
							if (document.getElementById("bkg_no").value != sheetObjects[3].CellValue(i, "bkg_no")) {
								ComShowCodeMessage("BKG00048", sheetObjects[3].CellValue(i, "bkg_no"), document.getElementById("bkg_no").value);
								chkFlg = "Y";
								return;
							}
	
							if (sheetObjects[3].CellValue(i, "cntr_tpsz_cd") == "") {
								ComShowCodeMessage("BKG08126", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								for ( var j = 1; j <= sheetObjects[1].RowCount; j++) {
									if (sheetObjects[1].CellValue(j, "cntr_tpsz_cd") == "") {
										sheetObjects[1].SelectCell(j, "cntr_tpsz_cd");
									}
								}
								return;
							}
							//IMDG Class Valid
							if (sheetObjects[3].CellValue(i, "imdg_clss_cd") == "") {
								ComShowCodeMessage("BKG00445", " IMDG Class [" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;							
							}
							
							var prp_shp_nm = (sheetObjects[3].CellValue(i, "prp_shp_nm")).toUpperCase();
							if (prp_shp_nm.indexOf(" OR ") > -1) {
								ComShowCodeMessage("BKG00539", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
	
							if (prp_shp_nm.indexOf(" NOS") > -1 || prp_shp_nm.indexOf(" N.O.S") > -1) {
								if (sheetObjects[3].CellValue(i, "hzd_desc") == "") {
									ComShowCodeMessage("BKG00761", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg = "Y";
									return;
								}
							}
							
							if (sheetObjects[3].CellValue(i, "imdg_clss_cd") == "3" || sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd1") == "3" || sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd2") == "3" || sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd3") == "3" || sheetObjects[3].CellValue(i, "imdg_subs_rsk_lbl_cd4") == "3") {
								if (sheetObjects[3].CellValue(i, "flsh_pnt_cdo_temp") == "") {
									ComShowCodeMessage("BKG00540", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg = "Y";
									return;
								}
								if (sheetObjects[3].CellValue(i, "imdg_pck_grp_cd") == "3") {
									if (sheetObjects[3].CellValue(i, "flsh_pnt_cdo_temp") >= 23 && sheetObjects[3].CellValue(i, "flsh_pnt_cdo_temp") <= 60) {
									} else{
										if( !ComShowCodeConfirm("BKG00541", "[" + seq + "." + cntr_cgo_seq + "]" + "\nDo you want to continue ?") ){
											return;
										}
									}
								}
								if (sheetObjects[3].CellValue(i, "imdg_pck_grp_cd") == "1" || sheetObjects[3].CellValue(i, "imdg_pck_grp_cd") == "2") {
									if (sheetObjects[3].CellValue(i, "flsh_pnt_cdo_temp") < 23) {
									} else {
										if( !ComShowCodeConfirm("BKG00542", "[" + seq + "." + cntr_cgo_seq + "]" + "\nDo you want to continue ?") ){
											return;
										}
									}
								}
							}else{
								if (sheetObjects[3].CellValue(i, "flsh_pnt_cdo_temp") != "") {
									ComShowCodeMessage("BKG00601", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg = "Y";
									return;
								}
							}
	
							if (sheetObjects[3].CellValue(i, "imdg_lmt_qty_flg") == "Y") {
								if (sheetObjects[3].CellValue(i, "ltd_qty") == "0" || sheetObjects[3].CellValue(i, "ltd_qty") == "") {
									ComShowCodeMessage("BKG00543", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg = "Y";
									return;
								}
							}
							
							if (sheetObjects[3].CellValue(i, "imdg_expt_qty_flg") == "Y") {
								if (sheetObjects[3].CellValue(i, "imdg_expt_qty_cd") == "0" || sheetObjects[3].CellValue(i, "imdg_expt_qty_cd") == "") {
									ComShowCodeMessage("BKG00544", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg = "Y";
									return;
								}
							}
	
							if (sheetObjects[3].CellValue(i, "cntr_cgo_seq") == "") {
								ComShowCodeMessage("BKG00578", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "imdg_un_no") == "") {
								ComShowCodeMessage("BKG00579", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							
							if (sheetObjects[3].CellValue(i, "emer_cntc_phn_no_ctnt") == "") {
								ComShowCodeMessage("BKG00580", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "emer_cntc_pson_nm") == "") {
								ComShowCodeMessage("BKG00691", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "out_imdg_pck_qty1") == "" || sheetObjects[3].CellValue(i, "out_imdg_pck_qty1") == "0") {
								ComShowCodeMessage("BKG00581", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "out_imdg_pck_cd1") == "") {
								ComShowCodeMessage("BKG00582", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "grs_wgt") == "" || sheetObjects[3].CellValue(i, "grs_wgt") == "0") {
								ComShowCodeMessage("BKG00585", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "net_wgt") == "" || sheetObjects[3].CellValue(i, "net_wgt") == "0") {
								ComShowCodeMessage("BKG00586", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "dcgo_sts_cd") == "") {
								ComShowCodeMessage("BKG00587", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "imdg_spcl_provi_no") == "274" && sheetObjects[3].CellValue(i, "hzd_desc") == "") {
								ComShowCodeMessage("BKG00761", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if (sheetObjects[3].CellValue(i, "imdg_crr_rstr_expt_cd") == "R") {
								var unNo = sheetObjects[3].CellValue(i, "imdg_un_no");
								var crrCd = sheetObjects[3].CellValue(i, "crr_cd");
								ComShowCodeMessage("BKG00762", crrCd, unNo);
							}
							if (sheetObjects[3].CellValue(i, "imdg_lmt_qty_flg") == "") {
								ComShowCodeMessage("BKG00589", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							if ((sheetObjects[3].CellValue(i, "imdg_clss_cd")).indexOf("1") == "0") {
								if (sheetObjects[3].CellValue(i, "cnee_dtl_desc") == "" || sheetObjects[3].CellValue(i, "net_explo_wgt") == "0" || sheetObjects[3].CellValue(i, "net_explo_wgt") == "") {
									ComShowCodeMessage("BKG00559", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg = "Y";
									return;
								}
							}
							if ((sheetObjects[3].CellValue(i, "imdg_clss_cd")).indexOf("7") == "0") {
								if (sheetObjects[3].CellValue(i, "rada_skd_no") == "" || sheetObjects[3].CellValue(i, "rada_trsp_no") == "" || sheetObjects[3].CellValue(i, "rada_amt") == "") {
									ComShowCodeMessage("BKG00560", "[" + seq + "." + cntr_cgo_seq + "]");
									chkFlg = "Y";
									return;
								}
/*								if (!ComIsNumber(sheetObjects[3].CellValue(i, "rada_trsp_no"))){ alert('not num');
									 ComShowMessage(ComGetMsg("BKG08176"));
										chkFlg = "Y";
										return;
								 }*/
							}
							if (sheetObjects[3].CellValue(i, "hcdg_flg") == "Y" && sheetObjects[3].CellValue(i, "hcdg_qty") == "1") {
								cntHCDG++;
							}
							/* Transportation Index 가  실수 일때만 저장 */
//							sheetObjects[3].CellValue2(i, "rada_trsp_no") = document.getElementById("rada_trsp_no").value;
							if(isNaN(sheetObjects[3].CellValue(i, "rada_trsp_no"))){
								ComShowMessage(ComGetMsg("BKG08176"));
								return;
							}
	
							// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
							cntrNo = sheetObjects[3].CellValue(i, "cntr_no");
							oldCntrNo = sheetObjects[3].CellSearchValue(i, "cntr_no");
							if ( dgChkFlg == "N" && cntrNo != oldCntrNo ) {
								dgChkFlg = "Y";
							}
							
							//2011.10.14 변종건 [CHM-201113595-01] US Rail DG bkg에 대한 warning msg 요청 - DG Cargo Validation Check 추가
							var un_rail_chk_cnt = 0;
							if( (formObj.pod_cd.value.substr(0,2) == "US" || formObj.del_cd.value.substr(0,2) == "US")
							&& (formObj.dest_trns_mod_cd.value == "R" || formObj.dest_trns_mod_cd.value == "A")
							&& sheetObjects[3].CellValue(i, "imdg_un_no") == "1402"
							&& sheetObjects[3].CellValue(i, "imdg_clss_cd") == "4.3" ){
								un_rail_chk_cnt++;
							}						
							
							//2011.10.21 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청 ( Hazardous Contents, Properties 및 Storage Temp Validation Check )
							if( sheetObjects[3].CellValue(i, "stwg_temp_ctnt")=="" ){
								ComShowCodeMessage("BKG02100", "[" + seq + "." + cntr_cgo_seq + "]");
								chkFlg = "Y";
								return;
							}
							
							if( sheetObjects[3].CellValue(i, "spcl_provi_no") != "" ){
								var spcl_provi_arr = sheetObjects[3].CellValue(i, "spcl_provi_no").split("/");								
								for(var idx=0;idx<spcl_provi_arr.length;idx++){
									if( spcl_provi_arr[idx]== "274" || spcl_provi_arr[idx]== "318" ){									
										if( sheetObjects[3].CellValue(i, "hzd_desc") == "" ){
											if( !ComShowCodeConfirm("BKG02099", "[" + seq + "." + cntr_cgo_seq + "]" + "\nDo you want to continue ?") ){
												chkFlg = "Y";
												return;
											}
										}
										if( sheetObjects[3].CellValue(i, "hzd_ctnt") == "" ){
											ComShowCodeMessage("BKG02099", "[" + seq + "." + cntr_cgo_seq + "]");
											chkFlg = "Y";
											return;
										}
									}
								}
							}						
	
		    				if(sheetObjects[3].CellValue(i, "imdg_lmt_qty_flg") == "Y" && limitQtyFlg == "N"){
		    					// Net Weight / Inner package Q'TY 가 packing 팝업 하단의 LTD QTY의 중량(용량)을 초과하는 경우
					        	var ltd_qty = sheetObjects[3].CellValue(i, "ltd_qty");
			    				var n_out_imdg_pck_qty = sheetObjects[3].CellValue(i, "out_imdg_pck_qty1").replace(",", "");
			    				var n_in_imdg_pck_qty  = sheetObjects[3].CellValue(i, "in_imdg_pck_qty1").replace(",", "");
			    				var n_grs_wgt 		   = sheetObjects[3].CellValue(i, "grs_wgt").replace(",", "");
			    				var n_net_wgt 		   = sheetObjects[3].CellValue(i, "net_wgt").replace(",", "");
			    				var n_grs_capa_qty 	   = sheetObjects[3].CellValue(i, "grs_capa_qty").replace(",", "");
			    				if(n_out_imdg_pck_qty == "") n_out_imdg_pck_qty = "0";
			    				if(n_in_imdg_pck_qty  == "") n_in_imdg_pck_qty = "0";
			    				if(n_grs_wgt 		  == "") n_grs_wgt = "0";
			    				if(n_net_wgt 		  == "") n_net_wgt = "0";
			    				if(n_grs_capa_qty 	  == "") n_grs_capa_qty = "0";	
			    				
		    					// capacity에 입력값이 있으면 LTD QTY의 단위가 ML혹은 L일 경우 capacity / inner packing q'ty로 적용. 
			    				if(n_in_imdg_pck_qty != null && Number(n_in_imdg_pck_qty) > 0){    					
			    		        	if(Number(n_grs_capa_qty) > 0 && ltd_qty.indexOf("L") > -1){
			    		        		ltd_qty = ltd_qty.replace("K", "").replace("G", "").replace("L", "").replace("M", "").replace(",", "");
							    		if(Number(n_grs_capa_qty) / Number(n_in_imdg_pck_qty) > Number(ltd_qty)){
							    			if( ComShowCodeConfirm("BKG08268","Do you want to continue ?") ){
							    				limitQtyFlg = "Y";
							    			} else {
							    				return;
							    			}
							    		}
			    		        	}
			    					//  Capacity 입력값이 없을 경우 Net Weight / Inner package Q'TY 값 적용
			    		        	else {
			    		        		ltd_qty = ltd_qty.replace("K", "").replace("G", "").replace("L", "").replace("M", "").replace(",", "");
							    		if(Number(n_net_wgt) / Number(n_in_imdg_pck_qty) > Number(ltd_qty)){
							    			if( ComShowCodeConfirm("BKG08268","Do you want to continue ?") ){
							    				limitQtyFlg = "Y";
							    			} else {
							    				return;
							    			}
							    		}
				    		    	}
			    		    	}		    	
		    				}
						}				
					}
	
					//2011.10.14 변종건 [CHM-201113595-01] US Rail DG bkg에 대한 warning msg 요청 - DG Cargo Validation Check 추가
					if( un_rail_chk_cnt > 0 ){
						if( !ComShowCodeConfirm("BKG02097","Do you want to continue ?") ){
							chkFlg = "Y";
							return;
						}
					}
					
					if (cntHCDG > 0) {
						if (ComShowConfirm(ComGetMsg("BKG00563"))) {
						} else {
							chkFlg = "Y";
							return;
						}
					}
	
					var cntSum = 0;
					var rcnt = 0;
					var find_tpsz_cd = "";
					var cnt_tpsz = 0;
					var qtyCnt = 0;
					var dcgo_qty = 0;
					var fhFlg = sheetObjects[2].CellValue(1, "flex_hgt_flg");
					var d4d5CntBkg = 0;
					var d4d5CntDg = 0;
					var tpszBkg = "";
					var tpszDg = "";
					if (sheetObjects[0].RowCount > 0) {
						for ( var j = 1; j <= sheetObjects[0].RowCount; j++) {
							tpszBkg = sheetObjects[0].CellValue(j, "cntr_tpsz_cd");
							
							if(fhFlg == "Y" && (tpszBkg == "D4" || tpszBkg == "D5")) {
								d4d5CntBkg += Number(sheetObjects[0].CellValue(j, "dcgo_qty"));
							}
							cntSum = 0;
							for ( var m = 1; m <= sheetObjects[1].RowCount; m++) {
								tpszDg = sheetObjects[1].CellValue(m, "cntr_tpsz_cd");
	 
								if (sheetObjects[1].CellValue(m, "ibflag") != "D" && sheetObjects[1].CellValue(m, "spcl_cgo_apro_cd") != "C") {
									if(tpszBkg == tpszDg) {
										cntSum += Number(sheetObjects[1].CellValue(m, "cntr_vol_qty"));
										cntSum = parseFloat(cntSum.toFixed(2));
										if(fhFlg == "Y" && (tpszDg == "D4" || tpszDg == "D5")) {
											d4d5CntDg += Number(sheetObjects[1].CellValue(m, "cntr_vol_qty"));
											d4d5CntDg = parseFloat(d4d5CntDg.toFixed(2));
										}
									}
		
									var find_tpsz_row = sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(m, "cntr_tpsz_cd"), 0, 2);
									if (!(fhFlg == "Y" && (tpszDg == "D4" || tpszDg == "D5")) && find_tpsz_row < 0) {
										rcnt++;
										find_tpsz_cd += sheetObjects[1].CellValue(m, "cntr_tpsz_cd") + ",";
									}
								}
							}
							if (rcnt > 0) {
								find_tpsz_cd = find_tpsz_cd.substr(0, find_tpsz_cd.length - 1);
								ComShowCodeMessage("BKG08023", find_tpsz_cd);
								chkFlg = "Y";
								return;
							}
							var find_tpsz_cd = sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].CellValue(j, "cntr_tpsz_cd"), 0, 2);
							if (!(fhFlg == "Y" && (tpszBkg == "D4" || tpszBkg == "D5")) && find_tpsz_cd > 0) {
								if (Number(sheetObjects[0].CellValue(j, "dcgo_qty")) > cntSum) {
									qtyCnt++;
									cntSum = 0;
								}
								if (Number(sheetObjects[0].CellValue(j, "dcgo_qty")) == cntSum) {
									cntSum = 0;
								}
								if (Number(sheetObjects[0].CellValue(j, "dcgo_qty")) < cntSum) {
									ComShowCodeMessage("BKG00679", "DG");
									chkFlg = "Y";
									return;
								}
							}
						}
						
						if(fhFlg == "Y") {
							if (d4d5CntBkg > d4d5CntDg) {
								qtyCnt++;
							}
							if (d4d5CntBkg < d4d5CntDg) {
								ComShowCodeMessage("BKG00679", "DG");
								chkFlg = "Y";
								return;
							}
						}				
						if (qtyCnt > 0) {
							if (confirm(ComGetMsg("BKG00678", "DG"))) {
							} else {
								chkFlg = "Y";
								return;
							}
						}
					} else {
						ComShowMessage(ComGetMsg("BKG00502", "DG"));
						chkFlg = "Y";
						return;
					}

					if (messageFlg == "save") {
						formObj.f_cmd.value = MULTI;
						var sParam = FormQueryString(formObj);
						// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
						sParam = sParam + "&" + "dg_chk_flg=" + dgChkFlg;
						var sParamSheet3 = sheetObjects[3].GetSaveString();
						sParam = sParam + "&sheet3_" + sParamSheet3.replace(/&/g, '&sheet3_');

						// make parameter for pre checking
						var sheetObj2 = sheetObjects[3];
						var sParamForPreChk = "";
						for ( var i = sheetObj2.HeaderRows; i <= sheetObj2.LastRow; i++) {
							if (sheetObj2.RowStatus(i) != 'D') {
								for ( var j = 0; j <= sheetObj2.LastCol; j++) {
									if (sheetObj2.ColSaveName(j) != "") {
										sParamForPreChk += "&sheet4_" + sheetObj2.ColSaveName(j) + "=" + sheetObj2.CellValue(i, j) + "&";
									}
								}
							}
						}
						sParamForPreChk += "&sheet4_rgn_shp_opr_cd=";
						sParamForPreChk += "&sheet4_cgo_opr_cd=HJS";
						sParamForPreChk += "&sheet4_bkg_no=" + document.getElementById("bkg_no").value;
						sParamForPreChk += "&sheet4_vsl_cd=" + document.getElementById("vsl_cd").value.substring(0, 4);
						sParamForPreChk += "&sheet4_skd_voy_no=" + document.getElementById("vsl_cd").value.substring(4, 8);
						sParamForPreChk += "&sheet4_skd_dir_cd=" + document.getElementById("vsl_cd").value.substring(8, 9);
						sParamForPreChk += "&sheet4_crr_cd=" + document.getElementById("crr_cd").value;
						sParamForPreChk += "&sheet4_slan_cd=";
						sParamForPreChk += "&sheet4_pol_cd=" + document.getElementById("pol_cd").value;
						sParamForPreChk += "&sheet4_pod_cd=" + document.getElementById("pod_cd").value;

						var rXml = sheetObj.GetSaveXml("ESM_BKG_0200GS.do", sParam + sParamForPreChk);	
						var rMsg = ComResultMessage(rXml);
						var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
						// DG 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
						if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
							var errMsg01 = ComGetEtcData(rXml,"psaValCode");							
							/*
							 * 2010.10.13 경종윤 추가 
							 * null 문제
							 * if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") { }
							 */
							if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {							
						    	var rmsg = errMsg01.split("<||>");
						    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
						    		ComShowCodeMessage("BKG06125");
						    	}else if ( rmsg[1] != "BKG95025" ){
						    		ComShowMessage(rmsg[3]);
						    	}
							}
						}
						if (rMsg == '' && messageFlg == "save") {
							ComShowMessage(ComGetMsg("BKG00166"));
							retFlag = "Y";
						} else {
							sheetObj.LoadSearchXml(rXml);
							chkFlg = "Y";
							return;
						}		
					}
				}

				if (requestFlg == "N" && saveChkFlg == "N") {
					requestFlg = "N";
					saveEnd = "Y";
					formObj.f_cmd.value = MULTI;
					var sParam = FormQueryString(formObj);
					// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
					sParam = sParam + "&" + "dg_chk_flg=" + dgChkFlg;
					var sParamSheet3 = sheetObjects[3].GetSaveString();
					sParam = sParam + "&sheet3_" + sParamSheet3.replace(/&/g, '&sheet3_');

					// make parameter for pre checking
					var sheetObj2 = sheetObjects[3];
					var sParamForPreChk = "";
					for ( var i = sheetObj2.HeaderRows; i <= sheetObj2.LastRow; i++) {
						if (sheetObj2.RowStatus(i) != 'D') {
							for ( var j = 0; j <= sheetObj2.LastCol; j++) {
								if (sheetObj2.ColSaveName(j) != "") {
									sParamForPreChk += "&sheet4_" + sheetObj2.ColSaveName(j) + "=" + sheetObj2.CellValue(i, j) + "&";
								}
							}
						}
					}
					sParamForPreChk += "&sheet4_rgn_shp_opr_cd=";
					sParamForPreChk += "&sheet4_cgo_opr_cd=HJS";
					sParamForPreChk += "&sheet4_bkg_no=" + document.getElementById("bkg_no").value;
					sParamForPreChk += "&sheet4_vsl_cd=" + document.getElementById("vsl_cd").value.substring(0, 4);
					sParamForPreChk += "&sheet4_skd_voy_no=" + document.getElementById("vsl_cd").value.substring(4, 8);
					sParamForPreChk += "&sheet4_skd_dir_cd=" + document.getElementById("vsl_cd").value.substring(8, 9);
					sParamForPreChk += "&sheet4_crr_cd=" + document.getElementById("crr_cd").value;
					sParamForPreChk += "&sheet4_slan_cd=";
					sParamForPreChk += "&sheet4_pol_cd=" + document.getElementById("pol_cd").value;
					sParamForPreChk += "&sheet4_pod_cd=" + document.getElementById("pod_cd").value;

					var rXml = sheetObj.GetSaveXml("ESM_BKG_0200GS.do", sParam + sParamForPreChk);
					var rMsg = ComResultMessage(rXml);
					var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
					
					// DG 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
					if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
						var errMsg01 = ComGetEtcData(rXml,"psaValCode");
				    	var rmsg = errMsg01.split("<||>");
				    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
				    		ComShowCodeMessage("BKG06125");
				    	}else if ( rmsg[1] != "BKG95025" ){
				    		ComShowMessage(rmsg[3]);
				    	}	
					}
					if (rMsg == '') {
	
					} else {
						sheetObj.LoadSearchXml(rXml);
						return;
					}
				}
			}	
			break;
	
		case COMMAND01: // manageSpclCgoApro
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value = COMMAND01;

			var sParam = FormQueryString(formObj);
			var sParamSheet1 = sheetObjects[3].GetSaveString();
			if (sParamSheet1 != "") {
				sParam = sParam + "&sheet3_" + sParamSheet1.replace(/&/g, '&sheet3_');
			}
			var rXml = sheetObj.GetSaveXml("ESM_BKG_0200GS.do", sParam);
			var rMsg = ComResultMessage(rXml);
			var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
			
			// DG 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
			if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
				var errMsg01 = ComGetEtcData(rXml,"psaValCode");
		    	var rmsg = errMsg01.split("<||>");
		    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
		    		ComShowCodeMessage("BKG06125");
		    	}else if ( rmsg[1] != "BKG95025" ){
		    		ComShowMessage(rmsg[3]);
		    	}	
			}

			if (rMsg == '' && messageFlg == "save") {
				retFlag = "Y";
				//ComShowMessage(ComGetMsg("BKG00166"));
			} else if (rMsg == '' && messageFlg == "request") {
				retFlag = "Y";
				ComShowMessage(ComGetMsg("BKG08102"));
			} else if (rMsg == '' && messageFlg == "requestCancel") {
				retFlag = "Y";
				ComShowMessage(ComGetMsg("BKG08103"));
			} else {
				sheetObj.LoadSearchXml(rXml);
				return;
			}
			break;
	
		case COMMAND02: // 미사용?
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value = COMMAND01;
			var sParam = FormQueryString(formObj);
			var sParamSheet1 = sheetObjects[3].GetSaveString();
			if (sParamSheet1 != "") {
				sParam = sParam + "&sheet3_" + sParamSheet1.replace(/&/g, '&sheet3_');
			}
			var rXml = sheetObj.GetSaveXml("ESM_BKG_0200GS.do", sParam);
			var rMsg = ComResultMessage(rXml);
			var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
			if (rMsg == '' && messageFlg == "save") {
				retFlag = "Y";
				//ComShowMessage(ComGetMsg("BKG00166"));
			} else if (rMsg == '' && messageFlg == "request") {
				retFlag = "Y";
				ComShowMessage(ComGetMsg("BKG08102"));
			} else if (rMsg == '' && messageFlg == "requestCancel") {
				retFlag = "Y";
				ComShowMessage(ComGetMsg("BKG08103"));
			} else {
				sheetObj.LoadSearchXml(rXml);
				return false;
			}
			break;
			
		case SEARCH01:
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0200GS.do", FormQueryString(formObj));			
			var arrXml = sXml.split("|$$|");			
		  	ComXml2ComboItem(arrXml[0], formObj.elements["hzd_ctnt"], "imdg_segr_grp_nm", "imdg_segr_grp_nm");
			break;
			
		case SEARCH02:
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value = SEARCH02;			
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0200GS.do", "f_cmd="+formObj.f_cmd.value+"&imdg_un_no="+formObj.imdg_un_no.value +"&imdg_un_no_seq="+formObj.imdg_un_no_seq.value); 
			document.getElementById("spcl_provi_no").value = ComGetEtcData(sXml, "spcl_provi_no");
			break;
			
		//Irregular List를 위한 UN NO 체크로직	
		case IBSEARCH_ASYNC01:  //CheckUnNumber
            formObj.f_cmd.value = SEARCH01;
            var param =  FormQueryString(formObj) ;
            var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
            var sTotal = ComScgGetTotalValue(sXml);
            if( sTotal == "0"){
         	    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
         	    formObj.imdg_un_no.value = "";
         	    formObj.imdg_un_no.focus();
            }else{
       	     	formObj.imdg_un_no_seq.focus();
       	     	
           	    var isChk = false;
          	    if(unData != null && unData.length > 0) {
         	 	    for(var arrIdx=0; arrIdx<unData.length; arrIdx++) {
         	 	    	if(formObj.imdg_un_no.value == unData[arrIdx]) isChk = true;
         	 	    }
          	    } 
          	    
          	    if(isChk) document.getElementById("srch_irregulars_list").style.color = "red";
          	    else document.getElementById("srch_irregulars_list").style.color = "#737373";
            }
            break;		
	}
}

function cntrChk() {
	Row = sheetObjects[1].SelectRow;
	var cnt = 0;
	document.getElementById("cntr_cgo_seq").options.length = 0;
	for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
		if (sheetObjects[1].CellValue(Row, "cntr_no") != "") {
			if (sheetObjects[1].CellValue(Row, "cntr_no") == sheetObjects[3].CellValue(i, "cntr_no") && sheetObjects[3].CellValue(i, "dg_cntr_seq") == sheetObjects[1].CellValue(Row, "dg_cntr_seq") && sheetObjects[3].CellValue(i, "ibflag") != "D") {
				sheetObjects[3].CellValue2(i, "CntrChk") = "1";
			} else {
				sheetObjects[3].CellValue2(i, "CntrChk") = "0";
			}
		} else {
			if (sheetObjects[1].CellValue(Row, "cntr_no") == "" && sheetObjects[1].CellValue(Row, "cntr_no") == sheetObjects[3].CellValue(i, "cntr_no") && sheetObjects[3].CellValue(i, "dg_cntr_seq") == sheetObjects[1].CellValue(Row, "dg_cntr_seq") && sheetObjects[3].CellValue(i, "ibflag") != "D") {
				sheetObjects[3].CellValue2(i, "CntrChk") = "1";
			} else {
				sheetObjects[3].CellValue2(i, "CntrChk") = "0";
			}
		}
		if (sheetObjects[3].CellValue(i, "CntrChk") == "1") {
			var cntr_cgo_seq = sheetObjects[3].CellValue(i, "cntr_cgo_seq");
			document.getElementById("cntr_cgo_seq").options[cnt] = new Option(cntr_cgo_seq, cntr_cgo_seq);
			cnt++;
		}
		sheetObjects[3].CellValue2(i, "bkg_cntr_seq") = sheetObjects[3].CellValue(i, "dg_cntr_seq") + sheetObjects[3].CellValue(i, "cntr_cgo_seq");
	}
	document.getElementById("cntr_cgo_seq_sum").value = cnt;
}

function htmlSheetSync() {
	Row = sheetObjects[1].SelectRow;
	var cnt = 0;
	for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
		if (sheetObjects[1].CellValue(Row, "cntr_no") != "") {
			if (sheetObjects[1].CellValue(Row, "cntr_no") == sheetObjects[3].CellValue(i, "cntr_no") && sheetObjects[1].CellValue(Row, "cntr_cgo_seq") == sheetObjects[3].CellValue(i, "cntr_cgo_seq")) {
				sheetObjects[3].CellValue2(i, "DelChk") = "1";
			} else {
				sheetObjects[3].CellValue2(i, "DelChk") = "0";
			}
		} else {
			if (sheetObjects[1].CellValue(Row, "dg_cntr_seq") == sheetObjects[3].CellValue(i, "dg_cntr_seq") && sheetObjects[1].CellValue(Row, "cntr_cgo_seq") == sheetObjects[3].CellValue(i, "cntr_cgo_seq")) {
				sheetObjects[3].CellValue2(i, "DelChk") = "1";
			} else {
				sheetObjects[3].CellValue2(i, "DelChk") = "0";
			}
		}
	}

	document.getElementById("dg_cntr_seq").value = sheetObjects[1].CellValue(Row, "dg_cntr_seq");
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
    
	var find_row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, -1);
	for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
		if (sheetObjects[3].CellValue(find_row, "ibflag") == "D") {
			if (sheetObjects[3].CellValue(i, "ibflag") != "D") {
				find_row = i;
				break;
			}
		}
	}
	document.getElementById("cntr_no").value = sheetObjects[3].CellValue(find_row, "cntr_no");
	document.getElementById("cntr_tpsz_cd").value = sheetObjects[1].CellValue(Row, "cntr_tpsz_cd");
	document.getElementById("cntr_cgo_seq").value = sheetObjects[3].CellValue(find_row, "cntr_cgo_seq");
	document.getElementById("imdg_clss_cd").value = sheetObjects[3].CellValue(find_row, "imdg_clss_cd");
	document.getElementById("imdg_comp_grp_cd").value = sheetObjects[3].CellValue(find_row, "imdg_comp_grp_cd");
	document.getElementById("imdg_un_no").value = sheetObjects[3].CellValue(find_row, "imdg_un_no");

	
	document.getElementById("grs_wgt").value = sheetObjects[3].CellText(find_row, "grs_wgt");
	document.getElementById("temp_grs_wgt").value = sheetObjects[3].CellText(find_row, "grs_wgt");

	document.getElementById("net_wgt").value = sheetObjects[3].CellText(find_row, "net_wgt");
	document.getElementById("temp_net_wgt").value = sheetObjects[3].CellText(find_row, "net_wgt");

	document.getElementById("prp_shp_nm").value = sheetObjects[3].CellValue(find_row, "prp_shp_nm");
	document.getElementById("hzd_desc").value = sheetObjects[3].CellValue(find_row, "hzd_desc");
//	document.getElementById("hzd_ctnt").value = sheetObjects[3].CellValue(find_row, "hzd_ctnt");
	document.form.hzd_ctnt.text2 = sheetObjects[3].CellValue(find_row, "hzd_ctnt");
	document.getElementById("stwg_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "stwg_temp_ctnt");
	document.getElementById("dflt_segr_grp_nm").value = sheetObjects[3].CellValue(find_row, "dflt_segr_grp_nm");
	document.getElementById("flsh_pnt_cdo_temp").value = sheetObjects[3].CellValue(find_row, "flsh_pnt_cdo_temp");
	document.getElementById("imdg_pck_grp_cd").value = sheetObjects[3].CellValue(find_row, "imdg_pck_grp_cd");
	document.getElementById("psa_no").value = sheetObjects[3].CellValue(find_row, "psa_no");
	document.getElementById("imdg_lmt_qty_flg").value = sheetObjects[3].CellValue(find_row, "imdg_lmt_qty_flg");
	document.getElementById("imdg_expt_qty_flg").value = sheetObjects[3].CellValue(find_row, "imdg_expt_qty_flg");
	document.getElementById("grs_capa_qty").value = sheetObjects[3].CellValue(find_row, "grs_capa_qty");
	if (sheetObjects[3].CellValue(find_row, "hcdg_flg") == "Y") {
		document.getElementById("hcdg_flag").value = "HCDG";
	} else {
		document.getElementById("hcdg_flag").value = "";
	}
	if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "Y") {
		document.getElementById("approved").style.color = "black";
		document.getElementById("approved").innerHTML = "approved";
	} else if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "N") {
		document.getElementById("approved").style.color = "red";
		document.getElementById("approved").innerHTML = "Rejected";
	} else if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "R") {
		document.getElementById("approved").style.color = "blue";
		document.getElementById("approved").innerHTML = "Requested";
	} else if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "P") {
		document.getElementById("approved").style.color = "black";
		document.getElementById("approved").innerHTML = "Pending";
	} else if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "C") {
		document.getElementById("approved").style.color = "black";
		document.getElementById("approved").innerHTML = "Canceled";
	} else {
		document.getElementById("approved").innerHTML = "";
	}
	if (sheetObjects[3].RowCount > 0 && sheetObjects[3].CellValue(find_row, "diff_rmk").length > 1) {
		document.getElementById("btn_Remark").style.color = "blue";
	} else {
		document.getElementById("btn_Remark").style.color = "";
	}
	document.getElementById("imdg_subs_rsk_lbl_cd1").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd1");
	document.getElementById("imdg_subs_rsk_lbl_cd2").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd2");
	document.getElementById("imdg_subs_rsk_lbl_cd3").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd3");
	document.getElementById("imdg_subs_rsk_lbl_cd4").value = sheetObjects[3].CellValue(find_row, "imdg_subs_rsk_lbl_cd4");
	document.getElementById("dcgo_sts_cd").value = sheetObjects[3].CellValue(find_row, "dcgo_sts_cd");
	document.getElementById("mrn_polut_flg").value = sheetObjects[3].CellValue(find_row, "mrn_polut_flg");
	document.getElementById("emer_cntc_phn_no_ctnt").value = sheetObjects[3].CellValue(find_row, "emer_cntc_phn_no_ctnt");
	document.getElementById("emer_cntc_pson_nm").value = sheetObjects[3].CellValue(find_row, "emer_cntc_pson_nm");
	document.getElementById("dcgo_rqst_grp_eml1").value = sheetObjects[3].CellValue(find_row, "dcgo_rqst_grp_eml1");
	document.getElementById("dcgo_rqst_grp_eml2").value = sheetObjects[3].CellValue(find_row, "dcgo_rqst_grp_eml2");
	document.getElementById("certi_no").value = sheetObjects[3].CellValue(find_row, "certi_no");
	document.getElementById("cnee_dtl_desc").value = sheetObjects[3].CellValue(find_row, "cnee_dtl_desc");
	document.getElementById("net_explo_wgt").value = sheetObjects[3].CellValue(find_row, "net_explo_wgt");
	document.getElementById("rada_skd_no").value = sheetObjects[3].CellValue(find_row, "rada_skd_no");
	document.getElementById("rada_amt").value = sheetObjects[3].CellValue(find_row, "rada_amt");
	document.getElementById("rada_ut_cd").value = sheetObjects[3].CellValue(find_row, "rada_ut_cd");
	document.getElementById("rada_trsp_no").value = sheetObjects[3].CellValue(find_row, "rada_trsp_no");
	document.getElementById("temp_cntr_no").value = sheetObjects[3].CellValue(find_row, "cntr_no");
	document.getElementById("in_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_cd1");
	document.getElementById("in_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_cd2");
	document.getElementById("intmd_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_cd1");
	document.getElementById("intmd_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_cd2");
	document.getElementById("out_imdg_pck_cd1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_cd1");
	document.getElementById("out_imdg_pck_cd2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_cd2");
	document.getElementById("in_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_desc1");
	document.getElementById("in_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_desc2");
	document.getElementById("intmd_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_desc1");
	document.getElementById("intmd_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_desc2");
	document.getElementById("out_imdg_pck_desc1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_desc1");
	document.getElementById("out_imdg_pck_desc2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_desc2");
	document.getElementById("in_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_qty1");
	document.getElementById("in_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "in_imdg_pck_qty2");
	document.getElementById("intmd_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_qty1");
	document.getElementById("intmd_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "intmd_imdg_pck_qty2");
	document.getElementById("imdg_expt_qty_cd").value = sheetObjects[3].CellValue(find_row, "imdg_expt_qty_cd");
	document.getElementById("out_imdg_pck_qty1").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_qty1");
	document.getElementById("out_imdg_pck_qty2").value = sheetObjects[3].CellValue(find_row, "out_imdg_pck_qty2");
	document.getElementById("max_in_pck_qty").value = sheetObjects[3].CellValue(find_row, "max_in_pck_qty");
	document.getElementById("max_in_pck_tp_cd").value = sheetObjects[3].CellValue(find_row, "max_in_pck_tp_cd");
	document.getElementById("hcdg_intmd_bc_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_intmd_bc_rstr_desc");
	document.getElementById("hcdg_pck_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_pck_rstr_desc");
	document.getElementById("hcdg_tnk_rstr_desc").value = sheetObjects[3].CellValue(find_row, "hcdg_tnk_rstr_desc");
	document.getElementById("ltd_qty").value = sheetObjects[3].CellValue(find_row, "ltd_qty");
	document.getElementById("hzd_desc").value = sheetObjects[3].CellValue(find_row, "hzd_desc");
	document.getElementById("ems_no").value = sheetObjects[3].CellValue(find_row, "ems_no");
	document.getElementById("emer_rspn_gid_no").value = sheetObjects[3].CellValue(find_row, "emer_rspn_gid_no");
	document.getElementById("emer_rspn_gid_chr_no").value = sheetObjects[3].CellValue(find_row, "emer_rspn_gid_chr_no");
	document.getElementById("ctrl_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "ctrl_temp_ctnt");
	document.getElementById("emer_temp_ctnt").value = sheetObjects[3].CellValue(find_row, "emer_temp_ctnt");
	document.getElementById("diff_rmk").value = sheetObjects[3].CellValue(find_row, "diff_rmk");
	var imdg_clss_cd = document.getElementById("imdg_clss_cd").value;
	var imdg_subs_rsk_lbl_cd1 = document.getElementById("imdg_subs_rsk_lbl_cd1").value;
	var imdg_subs_rsk_lbl_cd2 = document.getElementById("imdg_subs_rsk_lbl_cd2").value;
	var imdg_subs_rsk_lbl_cd3 = document.getElementById("imdg_subs_rsk_lbl_cd3").value;
	var imdg_subs_rsk_lbl_cd4 = document.getElementById("imdg_subs_rsk_lbl_cd4").value;
	document.getElementById("clod_flg").value = sheetObjects[3].CellValue(find_row, "clod_flg");
	document.getElementById("rc_flg").value = sheetObjects[3].CellValue(find_row, "rc_flg");
	document.getElementById("awk_cgo_flg").value = sheetObjects[3].CellValue(find_row, "awk_cgo_flg");
	document.getElementById("bb_cgo_flg").value = sheetObjects[3].CellValue(find_row, "bb_cgo_flg");
	document.getElementById("hcdg_flg").value = sheetObjects[3].CellValue(find_row, "hcdg_flg");
	document.getElementById("meas_qty").value = sheetObjects[3].CellValue(find_row, "meas_qty");
	document.getElementById("hcdg_dpnd_qty_flg").value = sheetObjects[3].CellValue(find_row, "hcdg_dpnd_qty_flg");
	document.getElementById("spcl_rqst_flg").value = sheetObjects[3].CellValue(find_row, "spcl_rqst_flg");
	document.getElementById("imdg_un_no_seq").value = sheetObjects[3].CellValue(find_row, "imdg_un_no_seq");
	document.getElementById("spcl_provi_no").value = sheetObjects[3].CellValue(find_row, "spcl_provi_no");
	document.getElementById("crr_cd").value = sheetObjects[3].CellValue(find_row, "crr_cd");
	document.getElementById("dcgo_seq").value = sheetObjects[3].CellValue(find_row, "dcgo_seq");
	document.getElementById("aply_no").value = sheetObjects[3].CellValue(find_row, "aply_no");
	document.getElementById("grs_capa_qty").value = sheetObjects[3].CellValue(find_row, "grs_capa_qty");

/*	if (imdg_clss_cd.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd1.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd2.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd3.indexOf("3") == "0" || imdg_subs_rsk_lbl_cd4.indexOf("3") == "0") {
		document.getElementById("flsh_pnt_cdo_temp").disabled = false;
	} else {
		document.getElementById("flsh_pnt_cdo_temp").disabled = true;
	}*/
	if (sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "C" || sheetObjects[3].CellValue(find_row, "spcl_cgo_apro_cd") == "") {
		document.getElementById("btn_cancel_left").className = "btn2_left";
		document.getElementById("btn_cancel").className = "btn2_1";
		document.getElementById("btn_cancel_right").className = "btn2_right";		
		cancelFlg = "Y";
	} else {
		document.getElementById("btn_cancel_left").className = "btn1_left";
		document.getElementById("btn_cancel").className = "btn1";
		document.getElementById("btn_cancel_right").className = "btn1_right";
		cancelFlg = "N";
	}
	//임시 번호저장 
	temp_imdg_un_no = document.getElementById("imdg_un_no").value;	
	
	//spcl_provi_no 번호에 따른 hzd_ctnt 콤보 활성화 여부 판단( spcl_provi_no가 274와 318 활성화 , 디폴트 Segregation Group이 없는 대상에 한해 활성화  ) - Start abc///////
	if( document.getElementById("dflt_segr_grp_nm").value != "" ){
		document.form.hzd_combo_disable_flg.value = "Y";
	}else{
		document.form.hzd_combo_disable_flg.value = "N";
	}
	
	if( document.getElementById("spcl_provi_no").value != "" ){
		var spcl_provi_arr = document.getElementById("spcl_provi_no").value.split("/");
		
		for(var idx=0;idx<spcl_provi_arr.length;idx++){
			if( spcl_provi_arr[idx]== "274" || spcl_provi_arr[idx]== "318" ){
				document.form.hzd_combo_disable_flg.value = "N";
			}
		}
	}
	//spcl_provi_no 번호에 따른 hzd_ctnt 콤보 활성화 여부 판단( spcl_provi_no가 274와 318 활성화 , 디폴트 Segregation Group이 없는 대상에 한해 활성화  ) - End ///////
	//Irregulars list 색변환을 위해 싱크 맞춰줌.
//	searchIrrForUnNo(document.getElementById("imdg_un_no").value);
	changeColorIrrButton(document.getElementById("irregular_list").value);
}

/**
 * Sheet관련 컬럼 fnCntrComboItem 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
function fnCntrComboItem(sheetObj, row, col, val) {
	var cntr_name = "";
	var cntr_val = "";
	for ( var j = 1; j <= sheetObjects[4].RowCount; j++) {
		if (sheetObjects[4].CellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[4].CellValue(j, "name") + "|";
			cntr_val += sheetObjects[4].CellValue(j, "val") + "|";
		}
	}
	
	cntr_val = cntr_val.substr(0, cntr_val.length - 1);
	cntr_name = cntr_name.substr(0, cntr_name.length - 1);
	var checkCntr = sheetObjects[4].FindText("DelChk", "0", 0, 2);
	var i = row;
	if (checkCntr > 0) {
		if (val != "") {
			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_name, " |" + sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_val);
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = false;
			sheetObjects[1].CellEditable(i, "cntr_vol_qty") = false;
		} else {
			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + cntr_name, " |" + cntr_val);
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = true;
			sheetObjects[1].CellEditable(i, "cntr_vol_qty") = true;
		}
	} else {
		if (val != "") {
			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].CellValue(i, "cntr_no"), " |" + sheetObjects[1].CellValue(i, "cntr_no"));
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = false;
			sheetObjects[1].CellEditable(i, "cntr_vol_qty") = false;
		} else {
			sheetObjects[1].CellComboItem(i, "cntr_no", " ", " ");
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = true;
			sheetObjects[1].CellEditable(i, "cntr_vol_qty") = true;
		}
	}
}

/**
 * Sheet관련 컬럼 sheet2_OnClick 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
function sheet2_OnClick(sheetObj, row, col, val) {
	var col_name = sheetObj.ColSaveName(col);
	cntrChk();
	htmlSheetSync();
	
	switch (col_name) {
	case "cntr_no":
		fnCntrComboItem(sheetObj, row, col, val);
		break;
	}
}

/**
 * Sheet관련 컬럼 sheet2_OnChange 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
function sheet2_OnChange(sheetObj, row, col, val) {
	var col_name = sheetObj.ColSaveName(col);
	switch (col_name) {
	case "cntr_no":
		for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
			if (sheetObjects[1].CellValue(row, "dg_cntr_seq") == sheetObjects[3].CellValue(i, "dg_cntr_seq")) {
				sheetObjects[3].CellValue2(i, "cntr_no") = sheetObjects[1].CellValue(row, "cntr_no");
			}
		}
		if (sheetObjects[1].CellValue(row, "cntr_no") != "") {
			var temp_cntr_no = document.getElementById("temp_cntr_no").value;
			var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].CellValue(temp_find_row, "DelChk") = "0";
			}
			var cntr_no = sheetObjects[1].CellValue(row, "cntr_no");
			var find_row = sheetObjects[4].FindText("name", cntr_no, 0, 2);
			if (sheetObjects[1].CellValue(row, "cntr_no") != "" && sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != "" && sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd")) {
				if (ComShowConfirm(ComGetMsg("BKG00570"))) {
					sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
					document.getElementById("cntr_tpsz_cd").value = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
				} else {
					sheetObjects[1].CellValue2(row, "cntr_no") = "";
					cntr_no = "";
				}
			} else if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd") == "") {
				sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
				document.getElementById("cntr_tpsz_cd").value = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
			}
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = sheetObjects[4].CellValue(find_row, "cntr_vol_qty");
			for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
				if (sheetObjects[1].CellValue(row, "dg_cntr_seq") == sheetObjects[3].CellValue(i, "dg_cntr_seq")) {
					sheetObjects[3].CellValue2(i, "cntr_tpsz_cd") = document.getElementById("cntr_tpsz_cd").value;
					sheetObjects[3].CellValue2(i, "cntr_vol_qty") = sheetObjects[4].CellValue(find_row, "cntr_vol_qty");
				}
			}
			if (cntr_no != "") {
				sheetObjects[4].CellValue2(find_row, "DelChk") = "1";
			}
		} else {
			var temp_cntr_no = document.getElementById("temp_cntr_no").value;
			if (temp_cntr_no != "") {
				var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
				sheetObjects[4].CellValue(temp_find_row, "DelChk") = "0";
			}
		}
		break;

	case "cntr_vol_qty":
		if (Number(sheetObjects[1].CellValue(row, "cntr_vol_qty")) > 1) {
			ComShowMessage(ComGetMsg("BKG08013"));
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = "";
		}
		for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
			if (sheetObjects[1].CellValue(row, "dg_cntr_seq") == sheetObjects[3].CellValue(i, "dg_cntr_seq") && sheetObjects[1].CellValue(row, "cntr_no") == sheetObjects[3].CellValue(i, "cntr_no")) {
				sheetObjects[3].CellValue2(i, "cntr_vol_qty") = sheetObjects[1].CellValue(row, "cntr_vol_qty");
			}
		}
		break;

	case "cntr_tpsz_cd":
		sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = (sheetObjects[1].CellValue(row, "cntr_tpsz_cd")).toUpperCase();
		var tpsz_row1 = sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), 0, 2);
		var tpsz_row2 = sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), 0, 2);
		var sum = 0;
		if (sheetObjects[1].CellValue(row, "cntr_vol_qty") == "" || sheetObjects[1].CellValue(row, "cntr_vol_qty") == "0") {
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = sheetObjects[0].CellValue(tpsz_row2, "dcgo_qty");
		}
		for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
			if (sheetObjects[1].CellValue(row, "dg_cntr_seq") == sheetObjects[3].CellValue(i, "dg_cntr_seq") && sheetObjects[1].CellValue(row, "cntr_no") == sheetObjects[3].CellValue(i, "cntr_no")) {
				sheetObjects[3].CellValue2(i, "cntr_tpsz_cd") = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");
			}
		}
		for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
			if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == sheetObjects[1].CellValue(row, "cntr_tpsz_cd")) {
				sum += Number(sheetObjects[1].CellValue(i, "cntr_vol_qty"))
			}
		}
		break;
	}
}




// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColBackColor("RFQTY") = RgbColor(204, 255, 253);
	}
}

//조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		/* Image Storage 에 AK 항목에 해당 image 가 한건이라도 첨부 되어 있으면 버튼 색상 변경 추가 */
		if(sheetObjects[2].RowCount > 0){
			if(sheetObjects[2].CellValue(1,"img_flg") =='Y'){
				document.getElementById('btn_attach').style.color = 'blue';
			}else{
				document.getElementById('btn_attach').style.color = '';
			}
		}
	}
//	searchIrrForUnNo(document.getElementById("imdg_un_no").value);
	changeColorIrrButton(document.getElementById("irregular_list").value);
}

//
//function sheet3_OnLoadFinish(sheetObj) {
//	document.getElementById("imdg_un_no").value = sheetObjects[3].CellValue(15, "imdg_un_no");
//	alert(document.getElementById("imdg_un_no").value);
//	if (document.getElementById("imdg_un_no").value != "") {
//		searchIrrForUnNo(document.getElementById("imdg_un_no").value);
//	}
//}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Class 1 Only", -1);
			InsertTab(cnt++, "Class 7 Only", -1);
		}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	beforetab = nItem;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}

/*
 * RD 프린터 함수
 * @param string : 없음
 * @author 김기종
 * @version 2009.09.14
 */

function goPrint() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var rdPath = "apps/alps/esm/bkg/bookingconduct/specialcargobookingconduct/specialcargoreceipt/repoort/ESM_BKG_5004.mrd";
	var where = "";
	var param = new Array("bkg_no");
	var strTitle = "Dangerous Cargo Information";

	if (param == "") {
		ComShowCodeMessage("BKG00495");
	}
	where = getParam(param);

	formObj.com_mrdPath.value = rdPath;
	formObj.com_mrdArguments.value = "/rv " + where;
	//formObj.com_mrdDisableToolbar.value = strToolbar;
	formObj.com_mrdTitle.value = strTitle;
	formObj.com_mrdBodyTitle.value = "<span style='color:red'>" + strTitle + "</span>";
	ComOpenRDPopup();
}

/*
 * RD 프린터 넘겨주는 파라미터 가져오는 함수
 * @param string : 넘겨줄 Param Name
 * @return string : RD로 넘겨줄 RV방식의 PARAM 
 * @author 김기종
 * @version 2009.09.14
 */
function getParam(param) {
	var formObj = document.form;
	var rParam = "";
	for (i = 0; i < param.length; i++) {
		rParam += param[i] + "[" + ComGetObjValue(eval("document.form." + param[i])) + "] ";
	}
	return rParam;
}

/**
 * setInquiryDisableButton 이벤트 호출 .<br>
 * ComBtnDisable 을 했을경우 비활성화
 * @param 
 */
function setInquiryDisableButton() {
	ComBtnDisable("btn_attach");
	ComBtnDisable("btn_save");
	ComBtnDisable("btn_request");
	ComBtnDisable("btn_email");
	ComBtnDisable("btn_print");
	ComBtnDisable("pre_checking_reports_btn");
}
 
 /**
  * 콤보1 변경시 처리
  * @param comboObj
  * @param value
  * @param text
  * @return
  */
function hzd_ctnt_OnCheckClick(comboObj,value,text) {
	var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
	var find_row = 0;
	for ( var idx = 1; idx <= sheetObjects[3].RowCount; idx++) {
		if( bkg_cntr_seq == sheetObjects[3].CellValue(idx, "bkg_cntr_seq") ){
			find_row = idx;
		}
	}
	
	if( document.form.hzd_combo_disable_flg.value == "Y" ){
		document.getElementById("hzd_ctnt").text = sheetObjects[3].CellValue(find_row, "hzd_ctnt");
	} else{
		sheetObjects[3].CellValue2(find_row, "hzd_ctnt") = document.getElementById("hzd_ctnt").text;
		sheetObjects[3].CellValue2(find_row, "modifyaproflg") = "Y";
	}
}

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 Array형태로 변환한다. <br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = ComScgXml2Array(xmlStr, &quot;user_id|user_nm|status&quot;);
 * 
 * 결과: 35X 3 크기의 결과 Array.
 * </pre>
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열
 * @param {string} colList 필수, XML문자열에서 추출하고자하는 컬럼명(Savename). "|"로 연결한다.
 * @return array   [조회된row수 X 컬럼수] 크기의 string array.
 */
function ComScgXml2Array(xmlStr, colList) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "" || colList == null || colList == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChileNodes = dataNode.childNodes;
		if (dataChileNodes == null) {
			return;
		}

		var colListArr = colList.split("|");
		var colListIdx = Array();
		for ( var i = 0; i < colListArr.length; i++) {
			for ( var j = 0; j < colArr.length; j++) {
				if (colListArr[i] == colArr[j]) {
					colListIdx[i] = j;
					break;
				}
			}
		}

		for ( var i = 0; i < dataChileNodes.length; i++) {
			if (dataChileNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

			var subDataArr = new Array();
			for ( var j = 0; j < colListIdx.length; j++) {
				subDataArr[j] = arrData[colListIdx[j]];
			}
			rtnArr[i] = (subDataArr);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;	 	
}

/**
 * Irregular List for Un No. 조회
 */
function searchIrrForUnNo() {
	var unData;
	var formObj  = document.form;
	var sheetObj = sheetObjects[5];
	formObj.f_cmd.value = SEARCH07;
   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0012GS.do", FormQueryString(formObj)); 	
    unData = ComScgXml2Array(sXml, "imdg_un_no");
//    var isChk = false;
//    if(unData != null && unData.length > 0) {
//    	for(var arrIdx=0; arrIdx<unData.length; arrIdx++) {
//    		if(imdg_un_no == unData[arrIdx]) isChk = true;
//    	}
//    } 
//    if(isChk) document.getElementById("srch_irregulars_list").style.color = "red";
//    else document.getElementById("srch_irregulars_list").style.color = "#737373";
    return unData;
}

/**
 *  Irregular List 와 비교해서 Irregular 팝업창 색 변경
 *  위의 searchIrrForUnNo 함수에서 빼고 따로 changeColorIrrButton 함수를 만든 이유는 
 *  BKG_Main에서 팝업으로 열릴 때 컬럼 클릭이 원활하게 되지 않기 때문
 */
function changeColorIrrButton(unData){	
	var array = new Array();
	var isChk = false;
	array = unData.toString().split(",");
	if (array != null && array.length > 0) {
		for ( var arrIdx = 0; arrIdx < array.length; arrIdx++) {
			if (document.getElementById("imdg_un_no").value == array[arrIdx])
				isChk = true;
		}
	}
	if (isChk)
		document.getElementById("srch_irregulars_list").style.color = "red";
	else
		document.getElementById("srch_irregulars_list").style.color = "#737373";
}
/* 개발자 작업  끝 */