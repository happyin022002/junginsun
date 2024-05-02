/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0047.js
*@FileTitle : spaceallocationmanage
*Open Issues :
*@LastModifyDate : 2009.09.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.03 한상훈
* 1.0 Creation
*Change history :
*2008-02-18 김원섭 CSR : N200801300018 - Alloc 입력화면에서 History data 저장 
*    - Office/POL 레벨 Tree 모양 변경
*    - Office/POL 레벨 저장 가능하도록 상태(RowStatus) 변경 조정
*    - Forecast/Booking 저장 되도록 컬럼명 변경
*    - Trade/Sub Trade 컬럼 추가
* 2008-02-28 김원섭 CSR : N200802260009   Load target만 있는 office 조회 
*   - IBSheet 컬럼 머지 기능 변경에 따라 기능 추가(msPrevColumnMerge + msHeaderOnly)
*   - Tree 컬럼 위치 변경
* 2008-03-04 김원섭 - Summarize 기능 개선
* 2008-04-02 서관영 CSR : N200803280003  e-NIS 본사 및 RHQ Alloc. 화면 개발요청
*  - 하단 Control Option 좌측 VVD,Week,Loadable(TEU) 컬럼 추가
*  - Control Option중에 Booking(firm) enable, Customer Guarantee hidden 
* 2008-04-30 서관영 CSR : N200804280004 - aloc maximum 100000까지
* 2008-10-14 서관영 CSR : N200810020013 - Allocation Control 2/3차 화면의 remark 기능 추가요청
* 2008-10-29 임옥영 CSRNO:N200810240577 단축키 설정으로 인해 추가된 FUNCTION line 1052이후부터 끝까지
* 2008-11-13 임옥영 CSR:N200811120012 -단축키 추가사항 반영(toggle 및 적용 화면추가, focus)
* 2008-12-12 CSR:N200812080003 Total TEU 컬럼 추가
* 2008-12-26 임옥영 CSR:N200812230019 BKG의 TEU->Total TEU로 변경
* 2010.07.05 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - [프로젝트] 53FT 관련 필드 추가
* 2011.07.05 이석준 [CHM-201111880] control by HO 화면 보완 - IPC, TS 관련
* 2011.07.20 김민아 [CHM-201112347-01] Control by HO/ RHQ 화면 QTA 및 CMPB 정보 보완 - 조회 필드 QTA CMB 및 CM Per Ton 항목 추가
* 2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 1차 - 주차별 CMB 항목 조회되도록 수정
* 2011.08.16 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - SaveName 수정
* 2011.08.25 김종준 [CHM-201113071] control by HO/RHQ 화면과 COA 링크 팝업 추가
* 2011.09.15 이행지 [CHM-201113449-01] COA 링크 화면 보완 - IOC여부에 따라 팝업띄우던 것을 모두 띄우도록 변경
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2011.10.18 김종준 [CHM-201114035-01] Forecast Total Qty 변수의 불필요한 공란 제거
* 2012.01.02 김종준 [CHM-201110709-01] OP/OC/VL  추가
* 2012.02.16 김성훈 [CHM-201216142-01] DownExcel 시 Weekly CMB/CNTR Movement 항목도 Excel Down 되도록 Data Type 변경
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - TTL 라인 COA 팝업 연결
* 2013.05.03 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - Save 후 상위 grid에 aloc 반영되도록 수정
* 2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
* 2015.03.24 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가(Control option 과 동일하게 적용 시켜줌)
* 2015.06.03 김성욱 Edit 기능에 Desync 기능 추가, Control Option Reg의 By Aloc등 9개 항목 Reset
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
* 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
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
 * @class ESM_SPC_0047 : ESM_SPC_0047 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0047() { 
	this.processButtonClick	= tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initControl		= initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.setTabObject 		= setTabObject;
	this.validateForm 		= validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var comObjects   = new Array();
var sheetCnt     = 0;
var comboCnt     = 0;

var sheetResizeCount = 2;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var sheet1_selRow = 0;
var order         = "C";
var popParam      = "";

var init_year     = '';
var init_week     = '';
var init_duration = '';


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject  = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	/*******************************************************/
	var formObject = document.form;
	
//	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		if(    srcName == ""
			|| (document.getElementsByName(srcName) == null
			|| (window.event.srcElement.tagName == "IMG" && document.getElementsByName(srcName)[0].Enable != undefined && !document.getElementsByName(srcName)[0].Enable))){
			return;
		}
		
		switch(srcName) {
			case "btn_retrieve":
				cancelControlOption(sheetObject);
				enableButtons(false);
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			
			case "btn_new":
				if(checkModifiedSheet(sheetObjects[1])){
					if(ComShowConfirm (getMsg("SPC90001")) != 1){
						return;
					}
				}
				
				resetAll();
				//단축키설정 42번과 동일하게 아래 hiddenTypeSize, hiddenWeight주석처리
				//hiddenTypeSize(sheetObject1);
				cancelControlOption(sheetObject);
				enableButtons(false);
				hiddenMasterCols(sheetObject, formObject, "INIT");
				//hiddenWeight(sheetObject1);
				formObject.year.value     = init_year;
				formObject.week.value     = init_week;
				formObject.duration.value = init_duration;
				SpcSearchOptionWeek("week",false,document.form.year.value);
				SpcSearchOptionTrade("trade", true, true);
				SpcSearchOptionSubTrade("subtrade", true, true);
				SpcSearchOptionLane("lane"); // 0207 SHKIM
				break;
			
			case "btn_save":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
			
			case "btn_downexcel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				break;
			
			case "btng_temp":
				var frow  = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
				var vvd   = sheetObject.CellValue(frow, "VVD");
				var param = "";
				param = param + "&rlane_cd="   + sheetObject.CellValue(frow, "rlane_cd");
				param = param + "&dir_cd="     + sheetObject.CellValue(frow, "dir_cd");
				param = param + "&vsl_cd="     + vvd.substring(0, 4);
				param = param + "&skd_voy_no=" + vvd.substring(4, 8);
				param = param + "&skd_dir_cd=" + vvd.substring(8);
				
				var url = "ESM_SPC_0065.do?"+param;
				var rtn = window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:"+600+"px;dialogHeight:"+400+"px")
				
				if(rtn == "OK"){
					sheet1_OnDblClick(sheetObject, frow, 1);
				}
				break;
			
			case "btng_bottleneck":
				var frow  = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
				var vvd   = sheetObject.CellValue(frow, "VVD");
				var param = "";
				param = param + "&year1=" + sheetObject.CellValue(frow, "WEEK").substring(0, 4);
				param = param + "&week1=" + sheetObject.CellValue(frow, "WEEK").substring(4);
				param = param + "&lane="  + sheetObject.CellValue(frow, "rlane_cd");
				param = param + "&bound=" + sheetObject.CellValue(frow, "dir_cd");
				param = param + "&vvd="   + vvd;
				param = param + "&popupcheck=Y";
				
				var url = "ESM_SPC_0045.do?"+param;
				var rtn = window.open(url, "BOTTLENECK", "height=550px,width=980px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
				break;
			
			case "btng_skd":
//				var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
//				spcPopup("VVD", "vvd_cd="+sheetObject.CellValue(frow, "VVD"), 770, 470, "getVVD", "1,0,1,1,1,1,1,1");
				var frow  = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
				var param = "&vvd=" + sheetObject.CellValue(frow, "VVD");
				var url   = "ESM_SPC_0071.do?"+param;
				
				window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:"+700+"px;dialogHeight:"+450+"px")
				break;
			
			case "btng_bsa":
				var frow  = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
				var vvd   = sheetObject.CellValue(frow, "VVD");
				var param = "";
				param = param + "&txtYear="       + sheetObject.CellValue(frow, "WEEK").substring(0, 4);
				param = param + "&txtFmWeek="     + sheetObject.CellValue(frow, "WEEK").substring(4);
				param = param + "&txtToWeek="     + sheetObject.CellValue(frow, "WEEK").substring(4);
				param = param + "&selDir="        + sheetObject.CellValue(frow, "dir_cd");
				param = param + "&txtVsl_cd="     + vvd.substring(0, 4);
				param = param + "&txtSkd_voy_no=" + vvd.substring(4, 8);
				param = param + "&txtDir_cd="     + vvd.substring(8);
				param = param + "&hSearchYN=Y";
				
				var url = "ESM_BSA_0104.do?"+param;
				var rtn = window.open(url, "BSA", "height=720px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
				break;
			
			case "btng_controlEdit":
				editControlOption(sheetObject);
				break;
			
			case "btng_controlSave":
				if( ComShowConfirm (getMsg("SPC90010")) == 1 ){
					var rtn = saveControlOption(sheetObject);
					if(rtn == "OK"){
						var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
						sheetObject.CellValue2(frow, "desync_flg") = "";
						sheet1_OnDblClick(sheetObject, frow, 1);
					}
				}
				break;
			
			case "btng_controlCancel":
				cancelControlOption(sheetObject);
				break;
			
			case "btng_cust_grp":
    	    	window.showModalDialog("ESM_SPC_0031.do?"+popParam, null, "dialogHeight:310px;dialogWidth:910px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
    	    	break;
			
			// add 2012.10.30 - Allocation Copy 기능 추가 : Req. by CDO 신혜성 차장님
			case "btng_copy":
				var rowIndex = sheet1_SelectedRow+2;
				var vvd      = sheetObject.CellValue(rowIndex, "VVD");
				var vsl_cd   = sheetObject.CellValue(rowIndex, "vsl_cd");
				
				var param = "";
				param = param + "f_cmd="       + SEARCHLIST02;
				param = param + "&office="     + formObject.office.value;
				param = param + "&lane="       + sheetObject.CellValue(rowIndex, "rlane_cd");
				param = param + "&bound="      + sheetObject.CellValue(rowIndex, "dir_cd");
				param = param + "&vvd="        + vvd;
				param = param + "&trade="      + sheetObject.CellValue(rowIndex, "TRADE");
				param = param + "&subtrade="   + sheetObject.CellValue(rowIndex, "STRADE");
				param = param + "&year="       + sheetObject.CellValue(rowIndex, "WEEK").substring(0, 4);
				param = param + "&week="       + sheetObject.CellValue(rowIndex, "WEEK").substring(4);
				param = param + "&fcast="      + formObject.fcast.value;
				param = param + "&vsl_cd="	   + vsl_cd;
				param = param + "&skd_voy_no=" + sheetObject.CellValue(rowIndex, "skd_voy_no");
				param = param + "&skd_dir_cd=" + sheetObject.CellValue(rowIndex, "skd_dir_cd");
				param = param + "&duration="   + formObject.duration.value;
				param = param + "&acct_ctrl="  + formObject.acctCtrl.value;
				param = param + "&div="        + "RHQ";
				
				var url = "ESM_SPC_0046.do?"+param;
				var rtn = window.open(url, "SPC", "height=400px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
				break;
				
			case "btng_cmpl_firm" :
				var obj = document.getElementById("office");
				var selOfc = obj.options[obj.selectedIndex].value;
				var param = "vvd_no=" + document.getElementById("idTxtVVD").value+"&origin="+selOfc; // sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "VVD" )+"&origin="+selOfc;
				var url = "ESM_SPC_0116.do?" + param;
				var rtn = window.open(url, "SPC", "height=720px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
				break;
		} // end switch
//		}catch(e) {
//			if( e == "[object Error]") {
//				ComShowCodeMessage("COM12111");
//			} else {
//				ComShowMessage(e);
//			}
//		}
}

function getVVD(){
	
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
*/
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj){
	comObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	SpcSearchOptionYear("year");
	SpcSearchOptionWeek("week");
	SpcSearchOptionDuration("duration", 5, 5);
	SpcSearchOptionTrade("trade", true, true);
	SpcSearchOptionSubTrade("subtrade", true, true);
	SpcSearchOptionLane("lane");
	SpcSearchOptionBound("bound",false,true,false,true);
	
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	var sheetResizeFull = true;
	document_onresize();
	
	enableButtons(false);
	document.form.year.focus();
	var formObject = document.form;
	comObjects[0].Enable = false;
	
	//탭관련 설정
	if(document.getElementById("trade").Enable == false) document.getElementById("trade").tabIndex = 1;
	//if(formObject.office.value != "SELHO"){
	//	formObject.office.disabled = true;
	//}
	
	init_year     = formObject.year.value;		//년 초기화용
	init_week     = formObject.week.value;		//주차 초기화용
	init_duration = formObject.duration.value;	//Duration 초기화용
	
	hiddenSelectionField(sheetObjects[1]);
	ComBtnDisable("btng_cmpl_firm");
	
	if (document.form.popup_flg.value =='Y') { //PopUp으로 호출되었으면
		var sheetObject  = sheetObjects[0];
		document.form.vvd.value     = document.form.popup_vvd.value;
		document.form.year.value     = document.form.popup_year.value;
		document.form.week.options.value    = document.form.popup_week.value;
		document.form.duration.value = document.form.popup_duration.value;
		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	}
}

function enableButtons(enable){
	if(enable){
		ComBtnEnable("btng_copy");
		ComBtnEnable("btng_temp");
		ComBtnEnable("btng_controlEdit");
		ComBtnEnable("btng_bottleneck");
		ComBtnEnable("btng_skd");
		ComBtnEnable("btng_bsa");
		if(document.form.acctCtrl.value == "Y"){
			ComBtnEnable("btng_cust_grp");
		}else{
			ComBtnDisable("btng_cust_grp");
		}
	} else {
		ComBtnDisable("btng_cust_grp");
		ComBtnDisable("btng_copy");
		ComBtnDisable("btng_temp");
		ComBtnDisable("btng_controlEdit");
		ComBtnDisable("btng_bottleneck");
		ComBtnDisable("btng_skd");
		ComBtnDisable("btng_bsa");
		ComBtnDisable("btng_aloc_confirm");
	}
}

var txtDelem = "|";
var HeadTail = "";
var txtHeadItem = new Array("CMB Trend(+/-)", "Weekly CMB", "Guide", "Forecast", "Allocation", "Booking (TTL)","CNTR Movement", "BASE","Booking(VGM)", "Booking(Standby)");
var HeadVolume  = new Array("Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",
		                    "Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",//booking D2,D4, RD 추가
		                    "Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)", 
		                    "TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT",
		                    "OP|OC|VL",
		                    "TEU|WGT",
		                    "Guide",
		                   "Volume|WT\n(M/T)",//vgm - preColName       
		                    "Volume|WT\n(M/T)"
		                    ) ;

var HeadTypeSize = new Array("TEU|D2|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)",//alloc
		                     "Total TEU|20'|D2|40'|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)", //booking D2,D4, RD 추가
		                     "Total TEU|TEU|D2|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)",//forecast
		                     "CMB WK1|CMB WK2|CMB WK3|CMB WK4|CMB WK1|CMB WK2|CMB WK3|CMB WK4",
		                     "OP|OC|VL",
							 "TEU|WGT",
							 "Guide",
							 "Total TEU|WT\n(M/T)",//vgm - preColName       
			                 "Total TEU|WT\n(M/T)"
							 ) ;

var preColName  = new Array("trend", "cmb", "guide", "fcast", "asgn", "usd_bkg","cm", "base", "vgm", "bs");
var sizeColName = new Array(new Array("_ttl_qty", "_d2_qty", "_d4_qty","_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_rd_qty","_ttl_wgt"), //allocation - preColName
        new Array("_ttl_qty", "_20ft_qty", "_d2_qty", "_40ft_qty","_d4_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty","_rd_qty", "_ttl_wgt"), //bkg - preColName 
        new Array("_ttl_teu_qty", "_ttl_qty","_d2_qty", "_d4_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty","_rf_qty", "_rd_qty", "_ttl_wgt"), //fcast - preColName
        new Array("1", "2", "3", "4","_wgt1", "_wgt2", "_wgt3", "_wgt4"), //cmb - preColName
        new Array("_op", "_oc", "_vl"), //cm - preColName
        new Array("_qty", "_wgt"),//trend - preColName
        new Array(""),//guide - preColName
        new Array("_vol","_wgt"),
        new Array("_teu","_wgt"));

// 항목에 보여야 하는 Tp/Sz 컬럼을 어떤 것을 사용하는지 index (sizeColName의 index)
var colSizeIdx = new Array(5, 3, 6, 2, 0, 1, 4, 0, 7,8);
// 항목이 Type/Size, Weight control option에 따라 조절되어야 하는 항목인지 여부
var syncTarget = new Array(false, false, false, true, true, true, false, false,true,true);
// 항목이 화면에 보이는 control 대상인지 여부 
var controlCols = new Array(false, false, false, true, true, true, false, false,true,true);
// DataSelect에 나타나는 Item별 check box name 
var dataSelectionItemName = new Array("", "chkWKCMB", "", "", "", "", "", "","");

// Local/IPI, Account, DEST 추가
var MasterCnt    = 16;
var TailCnt      = 29;
var ColumnCnt    = 0;

var cmbTrendIdx  = 0;
var weeklyCmbIdx = 1;
var guideIdx     = 2;
var fcastIdx     = 3;
var alocIdx      = 4;
var bkgTtlIdx    = 5;
var cntrMoveIdx  = 6;
var baseIdx      = 7;
        
// 상단 sheet에서 weight컬럼 목록
var weightCols = new Array(8, 10, 19, 21, 23, 28, 30, 32, 34, 36, 38,40,42);
// 상단 sheet에서 ocn컬럼 목록
var ocnCols = new Array(16, 18, 19, 27, 28, 33, 34, 39, 40 )
// 상단 sheet에서 ipc컬럼 목록
var ipcCols = new Array(17, 20, 21, 29, 30, 35, 36, 41, 42);
// 상단 sheet에서 TS컬럼 목록
var tsCols = new Array(22,23,31,32,37,38,43,44);
// 검색 조건 Forecast QTY View의 기존 검색시의 값
// 하단 sheet 검색시 사용하기 위해 상단 검색시에 저장
var fcastType = null;

// Weekly CMB 4주차를 위한 Hearder
var headWeek = "";

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var acctCtrl = document.form.acctCtrl.value;
	
	switch(sheetNo) {
		case 1:	  //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = getSheetHeight(10) ;
				//전체 너비 설정
				SheetWidth = mainTable1.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				FocusEditMode = default_edit_mode;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 3, 1, 9, 100);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;
				
				var Head1 = "SEQ|Rep.\nTrade|Sub\nTrade|Lane|BD|Week|VVD|";
				var Head2 = "|vsl_cd|skd_voy_no|skd_dir_cd|ctrl_spc_flg|ctrl_lvl_cd|ctrl_40ft_hc_flg|ctrl_45ft_hc_flg|ctrl_53ft_flg|ctrl_d2_flg|ctrl_d4_flg|ctrl_rd_flg|ctrl_ecc_flg|ctrl_loc_flg|ctrl_usa_svc_mod_flg|ctrl_acct_flg|ctrl_dest_lvl_cd|ctrl_rf_flg|ctrl_wgt_flg|smp|fixed|flag|ibflag|mty|dataSeq|edit_flg|mnl_flg|";

				var HeadTitle0 = Head1+"BSA|BSA|Loadable|Loadable|Loadable|Loadable|Loadable|Full&|Full&|Load|Load|F'CAST|F'CAST|F'CAST|F'CAST|F'CAST|F'CAST|L/F\n(%)|L/F\n(%)|Empty\nPlan|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|BKG|BKG|BKG|BKG|BKG|BKG|Booking VGM|Booking VGM|Booking VGM|Booking VGM|Booking VGM|Booking VGM|Standby BKG|Standby BKG|CNTR Movement|CNTR Movement|CNTR Movement|Un\nAllocated\nSpace|Un\nAllocated\nWeight"+Head2;
				var HeadTitle1 = Head1+"VOL|WGT|VOL|WGT|HC|45|RF|Down|Down|QTA|QTA|OCN|OCN|IPC|IPC|TS|TS|TEU\n(F'cast)|WGT\n(BKG)|Empty\nPlan|OCN|OCN|IPC|IPC|TS|TS|OCN|OCN|IPC|IPC|TS|TS|OCN|OCN|IPC|IPC|TS|TS|TEU|WGT|OP|OC|VL|Un\nAllocated\nSpace|Un\nAllocated\nWeight"+Head2;
				var HeadTitle2 = Head1+"VOL|WGT|VOL|WGT|HC|45|RF|VOL|WGT|OCN|IPC|VOL|WGT|VOL|WGT|VOL|WGT|TEU\n(F'cast)|WGT\n(BKG)|Empty\nPlan|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|TEU|WGT|OP|OC|VL|Un\nAllocated\nSpace|Un\nAllocated\nWeight"+Head2;

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//				InitColumnInfo(68, 7 , 0, true);
				InitColumnInfo(ComCountHeadTitle(HeadTitle2), 7 , 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				InitHeadRow(2, HeadTitle2, false);
				
				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,   true,	"SEQ",				false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daCenter,   true,	"TRADE",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daCenter,   true,	"STRADE",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			45,	daCenter,   true,	"rlane_cd",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter,   true,	"dir_cd",			false,	"",	dfNone,		0,	true,	true);
				
				InitDataProperty(0, cnt++ , dtData,			55,	daCenter,   true,	"WEEK",				false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			70,	daCenter,   true,	"VVD",				false,	"",	dfNone,  	0,	true,	true);
				//BSA
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				//Loadable
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "lod_vol",			false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "lod_wgt",			false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "lod_hc",			false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "lod_45",			false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "lod_rf",			false,	"",	dfInteger,	0,	true,	true);
				//Full & Down
				InitDataProperty(0, cnt++ , dtHidden,		40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				//BKG Quota
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				//Forecast
				InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				//L/F
				InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,   "",					false,	"",	dfFloat,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			50,	daRight,	true,   "",					false,	"",	dfFloat,	1,	true,	true);
				//Empty Plan
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				//Alloc
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "alloc_ocn_vol",	false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "alloc_ocn_wgt",	false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "alloc_ipc_vol",	false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "alloc_ipc_wgt",	false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "alloc_ts_vol",		false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "alloc_ts_wgt",		false,	"",	dfInteger,	1,	true,	true);
				//BKG
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				//BKG VGM				
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				//Standby BKG
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "bkg_bs_vol",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "bkg_bs_wgt",					false,	"",	dfInteger,	1,	true,	true);
				// CNTR Movement
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			40,	daRight,	true,   "",					false,	"",	dfInteger,	1,	true,	true);
				// UnAllocated
				InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			60,	daRight,	true,   "",					false,	"",	dfInteger,	0,	true,	true);
				
				InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	true,   "vsl_cd",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	true,   "skd_voy_no",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	true,   "skd_dir_cd",		false,	"",	dfNone,		0,	true,	true);
				
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,		30,	daCenter,   true,   "ctrl_spc_flg",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,		30,	daCenter,   true,   "ctrl_lvl_cd",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,		30,	daCenter,   true,   "ctrl_40ft_hc_flg",	false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,		30,	daCenter,   true,   "ctrl_45ft_hc_flg",	false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,		30,	daCenter,   true,   "ctrl_53ft_flg",	false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,	    30,	daCenter,	true,	"ctrl_d2_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"ctrl_d4_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"ctrl_rd_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"ctrl_ecc_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"ctrl_loc_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"ctrl_usa_svc_mod_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"ctrl_acct_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"ctrl_dest_lvl_cd",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,		30,	daCenter,   true,   "ctrl_rf_flg",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,		30,	daCenter,   true,   "ctrl_wgt_flg",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"acct_grp_ctrl_flg",	false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_fx_rt_flg",		false,	"",	dfNone,			0,	true,	true);				
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,			30,	daCenter,   true,   "flag",				false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , isDevMode?dtStatus:dtHiddenStatus,	40,	daCenter,   true,   "ibflag",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,			40,	daRight,	true,	"mty",				false,	"",	dfInteger,	1,	true,	true);
				InitDataProperty(0, cnt++ , dtSeq,							40,	daCenter,	true,	"dataSeq",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"edit_flg",		    false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,		30,	daCenter,	true,	"mnl_flg",		    false,	"",	dfNone,			0,	true,	true);
//				InitDataProperty(0,	cnt++ ,	dtHidden,		40,	daCenter,	true,	"desync_flg",	false,	"",	dfNone,			0,	true,	true); //2015.06.03 김성욱 Edit 기능에 desync 기능 추가, Control Option Reg의 By Aloc등 9개 항목 Reset
				InitDataProperty(0, cnt++ , dtData,			1,	daRight,	true,	"",					false,	"",	dfNone,		0,	false,	false);
				
				ColHidden("dataSeq") = true;
				HeadRowHeight        = 10;
				
				var backColor = RgbColor(222, 251, 248);
				
				RangeBackColor(1,  7, 2, 13) = backColor;
				RangeBackColor(2, 14, 2, 17) = backColor;
				RangeBackColor(1, 18, 2, 21) = backColor;
				RangeBackColor(1, 24, 2, 31) = backColor;
			}
			break;
			
		case 2:	  //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = getSheetHeight(15) ;
				//전체 너비 설정
				SheetWidth = mainTable2.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				FocusEditMode = default_edit_mode;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( acctCtrl=="Y"?5:3, 1, 9, 100);
				// 2014.07.25 Aloc, Fcst, BKG 각각 D2, D4, RD type추가 컬럼 +9
				// BSA : 2, LOAD : 5, 
				var HeadTitle0 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |QTA|QTA|CMB|CMB|Blank";
				var HeadTitle1 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load|CMB|" + (acctCtrl=="Y"?"AVG":"TEU") + "|WGT|Blank";
				var HeadTitle2 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load|CMB|" + (acctCtrl=="Y"?"A CMPB":"TEU") + "|WGT|Blank";
				var HeadTitle3 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load|CMB|B CMPB|WGT|Blank";
				var HeadTitle4 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load|CMB|C CMPB|WGT|Blank";
				
				ColumnCnt = MasterCnt + TailCnt;
				
				if(headWeek != ""){
					HeadTypeSize[3] = headWeek;
				}
				
				for(var k = 0 ; k < txtHeadItem.length ; k++){
					var colNames = sizeColName[colSizeIdx[k]];
					for(var i = 0 ; i < colNames.length ; i++){
						HeadTitle0 = HeadTitle0 + txtDelem + txtHeadItem[k];
						ColumnCnt = ColumnCnt + 1;
					}
					
					HeadTitle1 = HeadTitle1 + txtDelem + HeadVolume[colSizeIdx[k]];
					HeadTitle2 = HeadTitle2 + txtDelem + HeadTypeSize[colSizeIdx[k]];
					HeadTitle3 = HeadTitle3 + txtDelem + HeadTypeSize[colSizeIdx[k]];
					HeadTitle4 = HeadTitle4 + txtDelem + HeadTypeSize[colSizeIdx[k]];
				}
				
				var HeadHidden = "|flg|status|lane|bound|V|V|D|TS|MNG|OFC|lvl1|lvl2|lvl3|lvl4|lvl5|child|leaf|pol|lvl|ts|trd|sub_trd|rowIoc|rowDest|rowOfc|Remark|Remark|Remark";
				 
				HeadTitle0 = HeadTitle0 + HeadTail;
				HeadTitle1 = HeadTitle1 + HeadTail + HeadHidden;
				HeadTitle2 = HeadTitle2 + HeadTail + HeadHidden;
				HeadTitle3 = HeadTitle3 + HeadTail + HeadHidden;
				HeadTitle4 = HeadTitle4 + HeadTail + HeadHidden;
				log(HeadTitle0);
				log(HeadTitle1);
				log(HeadTitle2);
				log(HeadTitle3);
				log(HeadTitle4);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				ColumnCnt += 1; // 컬럼 마지막에 물량의 원본 저장 컬럼 추가 하면서 필요-김성욱 //2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				InitColumnInfo(ColumnCnt , MasterCnt - 1 , 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				InitHeadRow(2, HeadTitle2, false);
				if(acctCtrl=="Y") {
					InitHeadRow(3, HeadTitle3, true);
					InitHeadRow(4, HeadTitle4, true);
				}
				
				ImageList(0) = "img/nolines_plus.gif";
				ImageList(1) = "img/nolines_minus.gif";
				
				//[ROW, COL,  DATATYPE, WIDTH,		DATAALIGN,  COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtData,		30,	daCenterTop,	true,	"ioc_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		45,	daCenterTop,	true,	"sls_rhq_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"sls_ofc_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"cust_ctrl_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"us_mod",	    false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,	55,	daCenterTop,	true,	"account_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daLeftTop,		true,	"account_nm",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"pol_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"pod_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"del_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,	42,	daCenter,		true,	"",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		true,	"bkg_quota",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		true,	"bkg_qta_cmb",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daRight,		true,	"cmb",			false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		true,	"cmb_wgt",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,	40,	daRight,		true,	"",				false,	"",	dfInteger,	0,	false,	false);
				
				for(var m = 0 ; m < txtHeadItem.length ; m++){
					var colNames = sizeColName[colSizeIdx[m]];
					var dtType = false;
					
					if(controlCols[m] || preColName[m] == "cm" || preColName[m] == "cmb" || preColName[m] ==  "trend" || preColName[m] ==  "guide"){
						dtType = true;
					}
					for(var n = 0 ; n < colNames.length ; n++){
						InitDataProperty(0,	cnt++,	dtType?dtData:dtHidden,	defaultWidth,	daRight,	true,	preColName[m]+colNames[n],	false,	"",	dfInteger,	1,	(m==alocIdx),	(m==alocIdx));
					}
				}
				
				InitDataProperty(0,	cnt++,	dtHidden,		20,		daCenter,	true,	"mode",						false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	20,		daCenter,	true,	"ibflag",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"rlane_cd",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"dir_cd",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"vsl_cd",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"skd_voy_no",				false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"skd_dir_cd",				false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"ts_flg",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"mnl_flg",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"spc_ctrl_ofc_cd",			false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"lvl1",						false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"lvl2",						false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"lvl3",						false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"lvl4",						false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"lvl5",						false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"child_cnt",				false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"leaf_cnt",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"pol_cnt",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"lvl",						false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"tsedit",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"trd_cd",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"sub_trd_cd",				false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,   true,	"rowIoc",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"rowDest",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,   true,	"rowOfc",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			100,	daLeft,		true,	"spc_ctrl_aloc_rmk",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			100,	daLeft,		true,	"spc_ctrl_aloc_pol_rmk",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			100,	daLeft,		true,	"spc_ctrl_aloc_pod_rmk",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			1,		daRight,	true,	"",							false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,			1,		daRight,	true,	"aloc_mdfy",				false,	"",	dfNone,	0,	false,	false); //2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				
				HeadRowHeight  = 10;
				
				var backColor = RgbColor(222, 251, 248);
				RangeBackColor(1, MasterCnt - 1, 2, ColumnCnt - TailCnt - 1) = backColor;
				//2014.07.21 +3
				InitTreeInfo(10, "sLevel", RgbColor(0,0,255), false);
				ClipPasteMode = 1;
				
				//EditableColorDiff = false;
				EditableColor	= RgbColor(255,255,128);	//Default:255,255,255, 흰색 Edit 가능 데이터 배경색
				UnEditableColor	= RgbColor(255,255,255);	//Default:239,235,239, 회색 Edit 불가능 데이터 배경색
				
				//Allocation
				for(var q = 0 ; q < sizeColName[colSizeIdx[alocIdx]].length + 1 ; q++){
					MinimumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][q]) = 0;
					MaximumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][q]) = 100000;
				}
				
				if(acctCtrl=="N") {
					ColHidden("cust_ctrl_cd") = true;
					ColHidden("guide")        = true;
				} else {
					ColHidden("cust_ctrl_cd") = false;
					ColHidden("guide")        = false;
				}
			}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
		case IBSEARCH:	  //조회
			if(!validateForm(sheetObj,formObj,sAction)){
				return false;
			}
			
			formObj.f_cmd.value = SEARCHLIST01;
			sheetObj.ReDraw=false;
			sheetObj.RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.chkTS.checked = true;
			
			var param = SpcFormString(formObj,"f_cmd,year,week,duration,vvd,fcast,trade,subtrade,lane,bound,office");
			
			//첫번째 시트 조회 후 검색조건의 주차를 이용하여 하단 분의 Weekly CMB 4주차를 표현하기 위해 ETC로 담아오는 부분을 위해 GetSearchXml로 변경
			var sXml = sheetObj.GetSearchXml("ESM_SPC_0047GS.do", param);			
			if (sXml != ""){
				sheetObj.LoadSearchXml(sXml);
				headWeek = ComGetEtcData(sXml, "headerWeek");
			}
			fcastType = formObj.fcast.value;
			hiddenMasterCols(sheetObj, formObj, "INIT");
			sheetObj.ReDraw=true;
			// 조회된 데이터가 1건인 경우 하단 데이터를 바로 조회하도록 처리
			if(sheetObj.RowCount == 1){
				sheet1_OnDblClick(sheetObj, sheetObj.HeaderRows, 1);
			}
			break;
			
		case IBSAVE:		//저장
			if(!validateForm(sheetObj,formObj,sAction)){
				return false;
			}
			
			if(formObj.acctCtrl.value == "Y"){
				formObj.f_cmd.value = MULTI02;    					
			} else {
				formObj.f_cmd.value = MULTI;    					
			}
			var rows = sheetObj.GetTransColText("U", "mode");
			var rowArr = rows.split(";");
			var rowCnt = rowArr.length;
			var chekport = formObj.chkPort.value;
			
			for(var i = 0 ; i < rowCnt ; i++){
				var rowInfo = rowArr[i].split("=");
				if(sheetObj.CellValue(rowInfo[0]*1, "lvl")*1 < 6){
					sheetObj.RowStatus(rowInfo[0]*1) = "I";
				} else if(rowInfo[1] == "I"){
					log("Change Status : " + rowArr[i]);
					sheetObj.RowStatus(rowInfo[0]*1) = "I";
				}
			}
			
			var param = SpcFormString(formObj,"f_cmd");
			param += "&ctrl_lvl="+formObj.chkPort.value;
			if( formObj.chkWT.checked )
				param += "&ctrl_wt=Y";
			else
				param += "&ctrl_wt=N";
			
			var rtn = doSaveSheet(sheetObj, "ESM_SPC_0047GS2.do", param);
			
			var rData = rtn.split(":");
			
			if(rData[0] == "OK"){
//			if(rtn.indexOf("OK") > 0 ){
//				var frow  = sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
//				sheet1_OnDblClick(sheetObjects[0], frow, 1);
				//저장한 후 가져온 결과값을 sheet에 세팅.
				if( rData[1] != "null" ){
					var ary = rData[1].split("|");
					if( ary.length > 0 ) {
						for( var xx=0 ; xx<ary.length ; xx++ ) {
							var ary2 = ary[xx].split(",");
							if( ary2.length > 1 && ary2[0] != "" && ary2[1] != null && ary2[1] != "" ) { 
								var rRow = ary2[0]*1;
								if( rRow > 0 ){
									var ov = sheetObj.CellValue( rRow , "bs_teu" )*1; //bs_wgt
									var dv = ary2[3]*1;
									var dif = dv - ov;
									var ctrl_lvl = sheetObj.CellValue(rRow,"lvl");
									var yield = sheetObj.CellValue(rRow,"sls_ofc_cd");
									var oit = sheetObj.CellValue(rRow,"ioc_cd");
									
									//WGT 계산
									var wov = sheetObj.CellValue( rRow , "bs_wgt" )*1; //bs_wgt
									var wdv = ary2[4]*1;
									var wdif = wdv - wov;
									
									sheetObjects[0].CellValue2( sheet1_selRow ,"bkg_bs_vol") = parseInt( sheetObjects[0].CellValue( sheet1_selRow ,"bkg_bs_vol") ) + dif ;//위쪽 sheet의 standby 변경
									sheetObjects[0].CellValue2( sheet1_selRow ,"bkg_bs_wgt") = parseInt( sheetObjects[0].CellValue( sheet1_selRow ,"bkg_bs_wgt") ) + dif ;//위쪽 sheet의 standby 변경
									
									changValueStandby(sheetObj, rRow, '', dif , "", yield, oit , wdif);
								}
							}
						}
//						getSheet2Total();
					}
				}
				for(var j = 0 ; j < rowCnt ; j++){
					var rowInfo = rowArr[j].split("=");
					if(rowInfo[1] == "I"){
						log("Update Status : " + rowArr[j]);
						sheetObj.CellValue2(rowInfo[0]*1, "mode") = "R";
						sheetObj.RowStatus(rowInfo[0]*1) = "R";
						log("Updated Status : " + rowInfo[0]*1);
					}
				}
				var cnt   = sizeColName[colSizeIdx[alocIdx]].length - 1;
				var frow   = sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
				var sumArr = getSum(sheetObj, ":OCN:T-OCN:", preColName[alocIdx], formObj);
				sheetObjects[0].CellValue2(frow, "alloc_ocn_vol") = sumArr[0];
				sheetObjects[0].CellValue2(frow, "alloc_ocn_wgt") = sumArr[cnt];
				sheetObjects[0].RowStatus(frow) = "R";
				
				var trow = 0;
				for(var r = 0 ; r < Flags.length ; r++){
					trow = totalRows[Flags[r]];
					if(trow == undefined){
						continue;
					}
					setTotalRowColor(sheetObj, trow);
				}
				
				var frow  = sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
//				sheet1_OnDblClick(sheetObjects[0], frow, 1);
			}
			break;
			
		case IBDOWNEXCEL:		//엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
			break;
	}
}

var selectedCell_OldValue = 0;
function sheet2_OnSelectCell(sheetObj, orow, ocol, row, col){
	selectedCell_OldValue = sheetObj.CellValue(row, col)*1;
}

function sheet2_OnChange(sheetObj, row, col, value){

	var formObj = document.form;
	log("sheet2_OnChange1 : " + row + " - " + col);
	var colName  = sheetObj.ColSaveName(col);
	var idx      = colName.indexOf("_");
	var pre      = colName.substring(0, idx);
	var sizeName = colName.substring(idx);
	value = value * 1;
	var level = sheetObj.CellValue(row, "lvl") * 1;
	log("sheet2_OnChange3 : " + colName + " - " + pre + " - " + sizeName + " - " + row + " - " + level);
	
	/////////////////CNEP0054E	
	var regexp = /^asgn_|_qty$/ig;
	if(colName.search(regexp) > -1) {
		if(formObj.chkPort.value == "L" && formObj.pol_dbl_port_chk.value == "Y") {
			sheetObj.CellValue2(row, col) = selectedCell_OldValue;
			ComShowMessage("In case of Double Calling Lane(Route) touching two different tmnl within one port or one port several times,\nPlease allocate space with 'POL/POD' control option.");
			return false;
		}
	}
	
	if(pre == preColName[alocIdx]){
		orgValue = sheetObj.CellValue(row, preColName[baseIdx]+sizeName) * 1;

		if(level == 1){
			// 첫 값으로 바꿈 OTHERS가 없는 경우 있음
			frow  = sheetObj.FindText("lvl", "2", row + 1 );
			new_row  = sheetObj.FindText("lvl", "3", frow + 1);
			sheetObj.CellValue2(frow, pre + sizeName)= value; ;
			sheetObj.CellValue(new_row, pre + sizeName)= value;  
			//allocateByOffice(sheetObj, new_row, pre, sizeName, preColName[baseIdx], value, orgValue);
			if( sheetObj.CellEditable(row, col) && sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장
				sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
			}
			 
		}
		if(level == 2){
			//Account level에서 입력 할때 
			oldGrpValue_2 = selectedCell_OldValue;
			new_row  = sheetObj.FindText("account_cd", "OTHERS", row + 1);
			sheetObj.CellValue(new_row, pre + sizeName)= value; 
			if(sheetObj.CellEditable(row, col)){
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_2, level);
				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}
			
		}
		if(level == 3){
			oldGrpValue_3 = selectedCell_OldValue;
			allocateByOffice(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
			if(sheetObj.CellEditable(row, col)){
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_3, level);
				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}
		}
		if(level == 4){
			oldValue = selectedCell_OldValue;
			oldGrpValue_4 = selectedCell_OldValue;
			allocateByPol(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
			if(sheetObj.CellEditable(row, col)){
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_4, level);
				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}
		}
		if(level == 5){
			oldValue = selectedCell_OldValue;
			oldGrpValue_5 = selectedCell_OldValue;
			allocateByPod(sheetObj, row, pre, sizeName, preColName[baseIdx], value, oldValue);
			if(sheetObj.CellEditable(row, col)){
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_5, level);
				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}	
			var ioc_cd       = sheetObj.CellValue(row, "ioc_cd");
			var cust_ctrl_cd = sheetObj.CellValue(row, "cust_ctrl_cd");
			var rowOfc       = sheetObj.CellValue(row, "rowOfc");
			
			if(document.form.acctCtrl.value == "Y") {
				changeOfcTotalValue(sheetObj, rowOfc, col, pre, value, oldValue);
				changeGroupTotalValue(sheetObj, ioc_cd, cust_ctrl_cd, col, pre, value, oldValue);
			}
		}
		if(level == 6){
			oldValue = selectedCell_OldValue;
			oldGrpValue_6 = selectedCell_OldValue;
			if (sheetObj.CellEditable(row, col)) {
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_6, level);
				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}
			
			var ioc_cd       = sheetObj.CellValue(row, "ioc_cd");
			var cust_ctrl_cd = sheetObj.CellValue(row, "cust_ctrl_cd");
			var rowOfc       = sheetObj.CellValue(row, "rowOfc");
			var del_cd       = sheetObj.CellValue(row, "del_cd");
			
			changeTotalValue(sheetObj, ioc_cd, col, pre, value, selectedCell_OldValue);
			// 2014.10.06 DEST별 Total추가
			changeDestTotalValue(sheetObj, ioc_cd, del_cd, col, pre,value, oldValue);
			if(document.form.acctCtrl.value == "Y" && sheetObj.CellEditable(row, col)) {
				changeOfcTotalValue(sheetObj, rowOfc, col, pre, value, oldValue);
				changeGroupTotalValue(sheetObj, ioc_cd, cust_ctrl_cd, col, pre, value, oldValue);
			}
		}
	}
	
	selectedCell_OldValue = value;
	var formObj = document.form;
	
	// SMP 일 경우 Remark 처리
    if(!sheetObj.ColHidden("cust_ctrl_cd")) {
    	var ioc_cd       = sheetObj.cellValue(row, "ioc_cd");
    	var sls_area_cd  = sheetObj.cellValue(row, "sls_area_cd");
    	var sls_ofc_cd   = sheetObj.cellValue(row, "sls_ofc_cd");
    	var cust_ctrl_cd = sheetObj.cellValue(row, "cust_ctrl_cd");
    	var pol_cd       = sheetObj.cellValue(row, "pol_cd");
    	var pod_cd       = sheetObj.cellValue(row, "pod_cd");
    	
    	switch(colName){
    		case "spc_ctrl_aloc_rmk":
    			for(var i=row + 1; i<sheetObj.TotalRows + 5; i++) {
    				if(    ioc_cd       == sheetObj.cellValue(i, "ioc_cd")
    					&& sls_area_cd  == sheetObj.cellValue(i, "sls_area_cd")
    					&& sls_ofc_cd   == sheetObj.cellValue(i, "sls_ofc_cd")
    					&& cust_ctrl_cd == sheetObj.cellValue(i, "cust_ctrl_cd") ) {
    					
    					// Office Level 에서 Remark 입력시 하위 POD 에 Remark 입력  
    					if(sheetObj.cellValue(i, "pod_cd").length == 7) {
    						sheetObj.cellValue(i, col) = sheetObj.cellValue(row, "spc_ctrl_aloc_rmk");
    					}
    					
    				} else {
    					break;
    				}	
    			}
    			break;
    		
    		case "spc_ctrl_aloc_pol_rmk":
    			for(var i=row + 1; i<sheetObj.TotalRows + 5; i++) {
    				if(    ioc_cd       == sheetObj.cellValue(i, "ioc_cd")
    					&& sls_area_cd  == sheetObj.cellValue(i, "sls_area_cd")
    					&& sls_ofc_cd   == sheetObj.cellValue(i, "sls_ofc_cd")
    					&& cust_ctrl_cd == sheetObj.cellValue(i, "cust_ctrl_cd")
    					&& pol_cd       == sheetObj.cellValue(i, "pol_cd") ) {
    					
    					// POL Level 에서 Remark 입력시 하위 POD 에 Remark 입력  
    					if(sheetObj.cellValue(i, "pod_cd").length == 7) {
    						sheetObj.cellValue(i, col) = sheetObj.cellValue(row, "spc_ctrl_aloc_pol_rmk");
    					}
    					
    				} else {
    					break;
    				}	
    			}
    			break;
    		case "spc_ctrl_aloc_pod_rmk":
				for(var i=row + 1; i<sheetObj.TotalRows + 5; i++) {
					if(    ioc_cd       == sheetObj.cellValue(i, "ioc_cd")
						&& sls_area_cd  == sheetObj.cellValue(i, "sls_area_cd")
						&& sls_ofc_cd   == sheetObj.cellValue(i, "sls_ofc_cd")
						&& cust_ctrl_cd == sheetObj.cellValue(i, "cust_ctrl_cd")
						&& pol_cd       == sheetObj.cellValue(i, "pol_cd") 
						&& pod_cd       == sheetObj.cellValue(i, "pod_cd") ) {
						
						// POL Level 에서 Remark 입력시 하위 POD 에 Remark 입력
						if(sheetObj.cellValue(i, "del_cd").length > 1) {
							sheetObj.cellValue(i, col) = sheetObj.cellValue(row, "spc_ctrl_aloc_pod_rmk");
						}
					
					} else {
						break;
					}
				}
				break;
    	}
    }
}

function sheet2_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "cust_ctrl_cd":
		case "account_cd":
		case "us_mod":
		case "pol_cd":
		case "pod_cd":
		case "del_cd":
			var mark   = sheetObj.CellValue(row, col);
			var status = sheetObj.RowStatus(row);
			
			if(mark == "0"){
				sheetObj.RowExpanded(row)     = true;
				sheetObj.CellValue2(row, col) = "1";
				sheetObj.RowStatus(row)       = status;
			} else if(mark == "1"){
				sheetObj.RowExpanded(row)     = false;
				sheetObj.CellValue2(row, col) = "0";
				sheetObj.RowStatus(row)       = status;
			}
			break;
	}
}

function sheet1_OnDblClick(sheetObj, row, col){
	var sheetObj1    = sheetObjects[1];
	var formObj      = document.form;
	
	formObj.acctCtrl.value = sheetObj.CellValue(row, "acct_grp_ctrl_flg"); //acct->acct_grp_ctrl_flg
	
	sheet1_selRow    = row;
	sheetObj1.Enable = false;
	sheetObj1.ReDraw = false;
	sheetObj1.RemoveAll();
	// control option이 edit 상태이면 cancel 상태로 변경
	cancelControlOption(sheetObj);
	// 상단 sheet의 현재 선택된 row를 지정
	setSelectetRow(sheetObj, row);
	
	popParam = "week="        + sheetObj.CellValue(row, "WEEK")
             + "&trd_cd="     + sheetObj.CellValue(row, "TRADE")
             + "&sub_trd_cd=" + sheetObj.CellValue(row, "STRADE")
             + "&vvd="        + sheetObj.CellValue(row, "VVD") ;
	
	var paramWeekly = "f_cmd="     + SEARCH
	                + "&lane="     + sheetObj.CellValue(row, "rlane_cd")
	                + "&bound="    + sheetObj.CellValue(row, "dir_cd")
	                + "&vvd="      + sheetObj.CellValue(row, "VVD")
	                + "&trade="    + sheetObj.CellValue(row, "TRADE")
	                + "&subtrade=" + sheetObj.CellValue(row, "STRADE")
	                + "&year="     + sheetObj.CellValue(row, "WEEK").substring(0, 4)
	                + "&week="     + sheetObj.CellValue(row, "WEEK").substring(4);
	
	var weekXml = sheetObj1.GetSearchXml("ESM_SPC_0047GS.do", paramWeekly);
	sheetObj1.LoadSearchXml(weekXml);
	headWeek = ComGetEtcData(weekXml, "headerWeek");
	
	sheetObj1.Enable = false;
	sheetObj1.ReDraw = false;
	sheetObj1.RemoveAll();
	initSheet(sheetObj1, 2);
	
	// 하단 sheet를 검색하기 위한 검색 조건 생성
	var param = makeDetailParam(sheetObj, row);
	param = param + "&fcast="      + fcastType;
	param = param + "&year="       + sheetObj.CellValue(row, "WEEK").substring(0, 4);
	param = param + "&vsl_cd="     + sheetObj.CellValue(row, "vsl_cd");
	param = param + "&skd_voy_no=" + sheetObj.CellValue(row, "skd_voy_no");
	param = param + "&skd_dir_cd=" + sheetObj.CellValue(row, "skd_dir_cd");
	param = param + "&order="      + order;
	
	sheetObj1.DoSearch4Post("ESM_SPC_0047GS.do", param);
	
	setVVDValue(sheetObj.CellValue(row, "VVD"));
	setWeekValue(sheetObj.CellValue(row, "WEEK"));
	setLod_volValue(sheetObj.CellValue(row, "lod_vol"));
	
	formObj.pol_dbl_port_chk.value = sheetObj1.EtcData("DBL_CALL_CHK"); // double calling 확인

	// 검색 결과에 따라 control option을 체크 해준다.
	checkControlOption();
	// data selection 항목의 IOC 구분 관련 check box 체크
	checkSelectionOption(sheetObj1, formObj.acctCtrl.value);
	hiddenMasterCols(sheetObj, formObj, sheetObj.CellValue(row, "TRADE").substring(0, 1));
	hiddenSelectionField(sheetObj1);
	// data selection에 따른 row hidden 처리
	controlRowFilter(sheetObj1);
	checkPortcontrolTree(sheetObj1)
	//CNTR Movement op,oc,vl
	//hiddenCntrMovementCols(sheetObj1, document.form);
	//ShowTreeLevel(6);
	enableButtons(true);
	sheetObj1.ReDraw = true;
	sheetObj1.Enable = true;
	
	var bs_teu = sheetObj.CellValue(row , "bkg_bs_vol");
	if( bs_teu > 0 ) {
		ComBtnEnable("btng_cmpl_firm");
		document.getElementById("btng_cmpl_firm").style.color = "red";
	} else {
		ComBtnDisable("btng_cmpl_firm");
		document.getElementById("btng_cmpl_firm").style.color = "gray";
		
	}
}

function sheet2_OnDblClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	var rhq     = "";
	var param   = "";
	var sheet1  = sheetObjects[0];
	var sheet2  = sheetObjects[1];
	var sUrl    = "/hanjin/ESM_SPC_0049.do";
	
	if(colName == "usd_bkg_ttl_qty" || colName == "vgm_vol"){
		var cnt = eval(sheetObj.CellValue(row, col));
		var ctrt_no = sheet2.CellValue(row, "account_cd");
		if( cnt > 0 ){//&& ComTrim(sheet2.CellValue(row, "sls_ofc_cd")) != "TTL"){
			var rhq = "";
			if(ComTrim(sheet2.CellValue(row, "sls_ofc_cd"))=="TTL"){
				rhq = document.form.office.value;
			}else{
				rhq = sheet2.CellValue(row, "sls_rhq_cd");
			}
			param = "?f_cmd="       + SEARCHLIST
			      + "&trade="       + sheet2.CellValue(row, "trd_cd")
			      + "&subtrade="    + sheet2.CellValue(row, "sub_trd_cd")
			      + "&lane="        + sheet1.CellValue(sheet1_selRow, "rlane_cd")
			      + "&bound="       + sheet1.CellValue(sheet1_selRow, "dir_cd")
			      + "&year="        + sheet1.CellValue(sheet1_selRow, "WEEK").substring(0, 4)
			      + "&week="        + sheet1.CellValue(sheet1_selRow, "WEEK").substring(4)
			      + "&vvd="         + sheet1.CellValue(sheet1_selRow, "VVD")
			      + "&ioc_cd="      + sheet2.CellValue(row, "ioc_cd")
			      + "&sls_area_cd=" + rhq
			      + "&sls_ofc_cd="  + sheet2.CellValue(row, "sls_ofc_cd")
			      + "&pol_cd="      + sheet2.CellValue(row, "pol_cd")
			      + "&pod_cd="      + sheet2.CellValue(row, "pod_cd")
			      + "&cust_ctrl="   + ComTrim(sheet2.CellValue(row, "cust_ctrl_cd"));
			// Account에 계약이 오는 경우 COA popup에 해당 값 setting
			if (ctrt_no.length == 9){
				param = param + "&sc_no=" + ctrt_no;
			} else if (ctrt_no.length == 10){
				param = param + "&rfa_no="+ ctrt_no;
			} 
			var leftpos = (screen.width - 1024) / 2;
			if (leftpos < 0)
				leftpos = 0;
			
			var toppos = (screen.height - 540) / 2;
			if (toppos < 0)
				toppos = 0;
			
			var rtn = window.open(sUrl+param, "none", "height=540px,width=1024px,status=no,toolbar=no,menubar=no,location=no,resizable=yes,Left="+leftpos + ",dialogTop:" + toppos)
		}
	}
	
	if(colName == "sls_ofc_cd" && ComTrim(sheetObj.CellValue(row, col)) != "" && ComTrim(sheetObj.CellValue(row, col)) != "TTL" && document.form.acctCtrl.value == "Y"){
		var param = "week="        + document.getElementById("idTxtWeek").value
		          + "&trd_cd="     + sheetObj.CellValue(row, "trd_cd")
		          + "&sub_trd_cd=" + sheetObj.CellValue(row, "sub_trd_cd")
		          + "&ofc_cd="     + sheetObj.CellValue(row, "sls_ofc_cd") ;
		
		window.showModalDialog("ESM_SPC_0032.do?"+param, null, "dialogHeight:650px;dialogWidth:970px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
	}
	
	//Compulsory firm 화면으로 이동, orgin, pol_cd, pod_cd 를 동반하여 넘김.
	if( colName == "bs_teu" ) {
		var val = sheetObj.CellValue( row, colName );
		if( val != "0" ){
			sUrl = "/hanjin/ESM_SPC_0116.do";
			var obj = document.getElementById("office");
			var selOfc = obj.options[obj.selectedIndex].value;
			var ofc = sheetObj.CellValue( row , "sls_ofc_cd" );
			if( ofc.indexOf("TTL")>0)
				ofc = "";
			var param = "origin=" + selOfc 
			    + "&trade="		+ sheetObj.CellValue(row, "trd_cd")
			    + "&rlane_cd="		+ sheetObj.CellValue(row, "rlane_cd")
				+ "&pol_cd=" + sheetObj.CellValue( row , "pol_cd" )
				+ "&pod_cd=" + sheetObj.CellValue( row , "pod_cd" )
				+ "&del_cd=" + sheetObj.CellValue( row , "del_cd" )
				+ "&cust_ctrl_cd=" + sheetObj.CellValue( row , "cust_ctrl_cd" )
				+ "&ofc_vw=" + ofc
				+ "&ioc_cd="		+ sheet2.CellValue(row, "ioc_cd")
				+ "&usa_bkg_mod_cd="		+ sheet2.CellValue(row, "us_mod")
				+ "&vvd_no=" + document.getElementById("idTxtVVD").value;
			ComOpenWindow( sUrl + "?" + param, 'SB BKG Firm', "height=720px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
		}		
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
			case IBSEARCH:	  //조회
				if(comObjects[0].Enable && formObj.vvd.value == "" && comObjects[0].Code == ""){
					ComShowMessage(getMsg("SPC90114", "Trade"));
					comObjects[0].focus();
					return false;
				}
				
				if(formObj.vvd.value == "" && comObjects[1].Code == ""){
					ComShowMessage(getMsg("SPC90114", "SubTrade"));
					formObj.year.focus();
					comObjects[1].focus();
					return false;
				}
				
				if(formObj.vvd.value != "" && formObj.vvd.value.length < 9){
					ComShowCodeMessage("COM12174", "VVD", "9");
					formObj.vvd.focus();
					return false;
				}
				
				//순서변
				if(formObj.office.value == ""){
					ComShowMessage(getMsg("SPC90114", "ORG"));
					if(!formObj.office.disabled){
						formObj.office.focus();
					}
					return false;
				}
				break;
				
			case IBSAVE:		//저장
				var frow = sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
				
				if(frow <= 0){
					return false;
				}
				
				var models = new Array( sheetObjects[0].CellValue(frow, "lod_vol") * 1 - sheetObjects[0].CellValue(frow, "mty") * 1,
						 				0,
						 				0,
						 				sheetObjects[0].CellValue(frow, "lod_hc") * 1,
						 				sheetObjects[0].CellValue(frow, "lod_45") * 1,
						 				0, 												// sheetObjects[0].CellValue(frow, "lod_53") * 1,
						 				sheetObjects[0].CellValue(frow, "lod_rf") * 1,
						 				0,
						 				sheetObjects[0].CellValue(frow, "lod_wgt") * 1
						              );
				
				var rtn = validAllocationLoadable(sheetObj, formObj, ":OCN:T-OCN:", models, false);
				
				if(rtn >= 0){
					return false;
				}
				
				// 0042 주석 참조
//				rtn = validAllocation(sheetObj, formObj, ":IPC:T-IPC:T/S:T-T/S:", true);
//				
//				if(rtn >= 0){
//					return false;
//				}
				return true;
				break;
				
			case IBINSERT:	  // 입력
				break;
				
			case IBDOWNEXCEL:		//엑셀 다운로드
				break;
				
			case IBLOADEXCEL:		//엑셀 업로드
				break;
		}
	}
	return true;
}

function trade_OnChange(comObj,value,text ){
	//sub_trade의 초기화
	comObjects[1].Index2 = 0;
	//lane의 초기화
	comObjects[2].Index2 = 0;
	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);	// 0207 SHKIM
	SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
}

function subtrade_OnChange(comObj,value,text ){
	var arrTrade = text.split("|");
	if(arrTrade.length > 1) {
		comObjects[0].Code2 = arrTrade[0];
		comObjects[2].Code2 = '';
	} else {
		comObjects[0].Code2 = comObj.GetText(value,0);
		comObjects[2].Code2 = '';
	}
	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
}

function lane_OnChange(comObj,value,text ){
	if(value == "" ) return;
	var repTrade = comObj.GetText(value,0);
	var subTrade = comObj.GetText(value,1);
	comObjects[0].Code2 = repTrade;
	comObjects[1].Code2 = subTrade;
}

function setVVDValue(vvd){
	document.getElementById("idTxtVVD").value = vvd;
}

function setWeekValue(WEEK){
	document.getElementById("idTxtWeek").value = WEEK;
}

function setLod_volValue(lod_vol){
	var formObj = document.form;
	formObj.fm_load.value = lod_vol;
	
	/*
	 * addComma(입력값을 콤마가 포함된 문자열로 변환하여 리턴 ex)1234 => 1,234  CoFormControl.js)
	 */
	//ComAddComma(formObj.fm_load);
	ComChkObjValid(formObj.fm_load);
}

function checkPortcontrolTree(sheetObj){
	var formObj = document.form;
	var sts1    = formObj.chkOfc.checked;
	var sts2    = formObj.chkPol.checked;
	var sts3    = formObj.chkPod.checked;
	
	if((sts1==true)&& (sts2==true) && (sts3==true)){
		sheetObj.ColHidden("spc_ctrl_aloc_rmk")     = true;
		sheetObj.ColHidden("spc_ctrl_aloc_pol_rmk") = true;
		sheetObj.colhidden("spc_ctrl_aloc_pod_rmk") = false;
	}
	
	if((sts1==true) && (sts2 == false) &&(sts3 == false)){
		sheetObj.colhidden("spc_ctrl_aloc_rmk")     = false;
		sheetObj.ColHidden("spc_ctrl_aloc_pol_rmk") = true;
		sheetObj.ColHidden("spc_ctrl_aloc_pod_rmk") = true;
	}
	
	if((sts1==true) && (sts2 == true) &&(sts3 == false)){
		sheetObj.ColHidden("spc_ctrl_aloc_pol_rmk") =false;
		sheetObj.ColHidden("spc_ctrl_aloc_rmk")     =true;
		sheetObj.ColHidden("spc_ctrl_aloc_pod_rmk") =true;
	}
}

// trade 종류에 따라 상단 sheet의 OCN/IPC 선택 display
function hiddenMasterCols(sheetObj, formObj, trade){
	var checked = formObj.chkWT.checked || trade == "INIT";
	for(var i = 0 ; checked && i < weightCols.length ; i++){
		sheetObj.ColHidden(weightCols[i]) = !checked;
	}
	
	checked = formObj.chkOCN.checked || trade == "INIT";
	for(var j = 0 ; j < ocnCols.length ; j++){
		sheetObj.ColHidden(ocnCols[j]) = !checked;
	}
	
	checked = formObj.chkIPC.checked || trade == "INIT";
	for(var k = 0 ; k < ipcCols.length ; k++){
		sheetObj.ColHidden(ipcCols[k]) = !checked;
	}
	
	checked = formObj.chkWT.checked || trade == "INIT";
	for(var m = 0 ; !checked && m < weightCols.length ; m++){
		sheetObj.ColHidden(weightCols[m]) = !checked;
	}
	
	checked = formObj.chkTS.checked || trade == "INIT";
	for(var k = 0 ; k < tsCols.length ; k++){
		sheetObj.ColHidden(tsCols[k]) = !checked;
	}
	
	checked = formObj.chkWT.checked || trade == "INIT";
	for(var m = 0 ; !checked && m < weightCols.length ; m++){
		sheetObj.ColHidden(weightCols[m]) = !checked;
	} 
}

//CNTR Movement col hidden
function hiddenCntrMovementCols(sheetObj, formObj, trade){
	var checked = formObj.chkCNTRMOVE.checked;
	sheetObj.ColHidden("cm_op") = !checked;
	sheetObj.ColHidden("cm_oc") = !checked;
	sheetObj.ColHidden("cm_vl") = !checked;
}

function initDataValue_trade(){
	var sheetObj = document.getElementById("trade");
	with(sheetObj){
		Index2 = 0;
	}
}

function initDataValue_subtrade(){
	var sheetObj = document.getElementById("subtrade");
	with(sheetObj){
		Index2 = 0;
	}
}

function initDataValue_lane(){
	var sheetObj = document.getElementById("lane");
	with(sheetObj){
		Index2 = 0;
	}
}

function initDataValue_office(){
	var sheetObj = document.getElementById("office");
	with(sheetObj){
		Index2 = 0;
	}
}

/**
 * Start Week 의 year 변경시
 * Start Week 의 year 변경시 주차 변경
 */
function checkWeek(){
	SpcSearchOptionWeek("week",false,document.form.year.value);
}

/**
 * CMPB 클릭시 해당 정보로 Order By 하여 재조회
 */
function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y){
	var header = "";
	
	if(sheetObj.MouseRow > 0){
		header = ComTrim(sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol));
		
		if((header == "AVG" || header == "A CMPB" || header == "B CMPB" || header == "C CMPB") && sheetObj.DataRows > 0 ){
			order = header=="AVG"?"":header.substr(0,1);
			var frow  = sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
			sheet1_OnDblClick(sheetObjects[0], frow, 1);
		}
	}
}

/**
 * 마우스가 이동될 때 이벤트 처리 
 * 
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y){
	var header = ComTrim(sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol));
	
	if((header == "AVG" || header == "A CMPB" || header == "B CMPB" || header == "C CMPB") && sheetObj.DataRows > 0 ){
		sheetObj.MousePointer = "Hand";
	}else if (sheetObj.ColSaveName(sheetObj.MouseCol) == "sls_ofc_cd" && document.form.acctCtrl.value == "Y" && header != "" && header != "TTL" && sheetObj.MouseRow + 1> sheetObj.HeaderRows ){
		sheetObj.MousePointer = "Hand";
	} else {
		sheetObj.MousePointer = "Default";
	}
}


function chkAllPol() {
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var formObj = document.form;

	if (sheetObj2.SearchRows > 0) {
		sheet1_OnDblClick(sheetObj1, sheet1_selRow, 1);
	}
}

/////////////////
/**
 * Standby 값 변경 되면 하위 레벨 값, total 값 변경해야 함.
 * sheetObj : 적용 sheet
 * row : 변경된 row 번호
 * col : 변경된 col
 * dif : 변경된 값(원래값에 변경된값을 뺀거)
 * ctrl_lvl : 현재 vvd 의 control level
 * yield : 현 vvd가 smp 인 경우 변경 한 row 의 yield group
 * oit : 변경한 row 의 OCN/IPC/TS 
 */
function changValueStandby(sheetObj, row, col, dif , ctrl_lvl, yield, oit, wdif ){
	var endRow = sheetObj.CellValue( row , "rowOfc" );//현재 row 가 속한 L.OFC 의 끝 Row 번호 (L.OFC는 같은 값인 경우 하나의 ROW가 되므로 범위의 끝값을 rowOfc 컬럼이 가지고 있다.)
	endRow = endRow + sheetObj.HeaderRows;
	
	//현 row의 값을 증가 시키면서 같거나 작은 level값이 나올때 까지 혹은 비교한 값 다음 값이 이전값보다 작을때 까지(즉, 계속 증가만 한다. 작아지면 종료)
	//현 level 값 보다 큰값을 변경
	//level = 6 인경우(Dest) 동일한 dest가 있을수 있는데 이때는 other로 된것을 변경시킴.
	var oldRowVal = -1;
	var nowRowVal = 0;
	var orgRowVal = sheetObj.CellValue( row , "lvl" ); //변경한 level 값
	sheetObj.CellValue2( row , "bs_teu" ) = parseInt( sheetObj.CellValue( row , "bs_teu" ) ) + dif; //현재 값 변경
	sheetObj.CellValue2( row , "bs_wgt" ) = parseInt( sheetObj.CellValue( row , "bs_wgt" ) ) + wdif; //현재 값 변경
	
	//row 값 증가 시키면서 pol, pod, dest 의 row  증가시키기.
	for( var rowNum = row ; rowNum<endRow ; rowNum++ ) {
		if( oldRowVal == -1 ) {
			oldRowVal = orgRowVal;
		}
		nowRowVal = sheetObj.CellValue( rowNum , "lvl" );
		
		if( rowNum != row && orgRowVal <= nowRowVal ) { //처음 시작하는 row가 아닌 경우
		
			if( nowRowVal > orgRowVal && oldRowVal <= nowRowVal ) { //지금 row의 lvl값이 이전 보다 크다,, 즉, 계속 증가 하고 있다.
				
				if( nowRowVal == 6 && sheetObj.CellValue( rowNum , "del_cd" ) == "OTHERS") {//현재 row가 dest고 여러개 있는 경우 OTHERS 라면
					sheetObj.CellValue2( rowNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rowNum , "bs_teu" ) ) + dif; //값 변경
					sheetObj.CellValue2( rowNum , "bs_wgt" ) = parseInt( sheetObj.CellValue( rowNum , "bs_wgt" ) ) + wdif; //값 변경
					
				} else if( nowRowVal < 6 ) { //row의 lvl 이 증가 중이면서( 감소된적 없음, 감소되었을때는 위 쪽 if 문에서 걸러줌)
					sheetObj.CellValue2( rowNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rowNum , "bs_teu" ) ) + dif;
					sheetObj.CellValue2( rowNum , "bs_wgt" ) = parseInt( sheetObj.CellValue( rowNum , "bs_wgt" ) ) + wdif;
					
				}else if( nowRowVal == 6 && sheetObj.CellValue( rowNum , "del_cd" ) != "OTHERS")
					continue;
				else
					break;
			} else {
				break;
			}
		}
		oldRowVal = nowRowVal;
	}
	//현재 row 가 속한 Yield, L.OFC 범위 내 TTL 값 변경,
	var fRow = sheetObj.FindText( "rowOfc", sheetObj.CellValue( row, "rowOfc" ) );
	var nextVal = orgRowVal-1; //변경한 level 값
	for( var rowNum = row ; rowNum>=fRow ; rowNum-- ) {
		nowRowVal = sheetObj.CellValue( rowNum , "lvl" );
		if( orgRowVal > nowRowVal && nextVal == nowRowVal && row != rowNum ) {//현재 row가 아니고 현재 row의 lvl 보다 작은 값만 변경
			sheetObj.CellValue2( rowNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rowNum , "bs_teu" ) ) + dif;
			nextVal -= 1;
		}
	}
	
	var startRow = 0;
	var oit_cd = oit.substring(0,1);
	if( oit_cd == "I" ){
		startRow = sheetObj.FindText( "ioc_cd" , "IPC" , 0 );
		endRow = sheetObj.FindText( "ioc_cd" , "T/S" );
	} else if( oit_cd == "T" ) {
		startRow = sheetObj.FindText( "ioc_cd" , "T/S" , 0 );
		endRow = sheetObj.RowCount;
	} else {
		endRow = sheetObj.FindText( "ioc_cd" , "IPC" );
		if( endRow == -1 )
			sheetObj.FindText( "ioc_cd" , "T/S" , 0 );
		if( endRow == -1 )
			endRow = sheetObj.RowCount;
	}
	startRow = startRow + sheetObj.HeaderRows;
	endRow = endRow + sheetObj.HeaderRows;
	//O/I/T 의 control level이 dest 인경우 TTL, dest TTL 모두 변경
	//SMP 인경우 TTL의 yield group 값 변경 ==> if(formObj.acctCtrl.value == "Y"){
	var isSMP = document.getElementById( "acctCtrl" ).value;
	startRow = sheetObj.FindText( "sls_ofc_cd" , " TTL" , startRow );
	if( isSMP == "Y" ) { //SMP인 경우 TTS 의 Yield Group 에 변경한 row의 yield 와 동일한 TTL 변경
		for( var rNum=startRow ; rNum<endRow ; rNum++ ) {
			var lofc = sheetObj.CellValue( rNum , "sls_ofc_cd" );
			var ioc = sheetObj.CellValue( rNum , "ioc_cd" );
			var nCCC = sheetObj.CellValue( rNum , "cust_ctrl_cd" );
			if( rNum == startRow ){ //TTL 값
				sheetObj.CellValue2( rNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rNum , "bs_teu" ) ) + dif;
				
			} else if( nCCC == yield ) { //변경한 row 의 Cust Control Cd와 동일한것.
				sheetObj.CellValue2( rNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rNum , "bs_teu" ) ) + dif;
				
			} else if( lofc == " DEST TTL" ) {
				sheetObj.CellValue2( rNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rNum , "bs_teu" ) ) + dif;
			} else if( oit != ioc )
				break;
		}
	} else {
		for( var rNum=startRow ; rNum<endRow ; rNum++ ) {
			sheetObj.CellValue2( rNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rNum , "bs_teu" ) ) + dif;
		}
	}
}
/* 개발자 작업  끝 */
