/*=========================================================
 **Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_SPC_0042.js
 *@FileTitle : Allocation Change by VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 최윤성
 *@LastVersion : 1.0
 * 2009.07.29 최윤성  1.0 Creation
 * 2010.06.22 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - [프로젝트] 53FT 관련 필드 추가
 * 2011.04.07 이석준 [CHM-201109823] 0021 UI에서 호출할때 자동 Retrieve 해주는 부분 추가
 * 2011.07.05 이석준 [CHM-201111880] control by HO 화면 보완 - IPC, TS 관련
 * 2011.07.20 김민아 [CHM-201112347-01] Control by HO/ RHQ 화면 QTA 및 CMPB 정보 보완 - 조회 필드 QTA CMB 및 CM Per Ton 항목 추가
 * 2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 1차 - 주차별 CMB 항목 조회되도록 수정
 * 2011.08.16 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAF 노선에 대한 Allocation 팝업 추가, RHQ(HAMRU,NYCRA) 항목 더블 클릭했을시 팝업뜨도록 수정
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
 * 2013.08.08 진마리아 [선처리] Allocation 추가요건 - 성수기 ofc별 total 색 추가, Yield Group 전체 열고 닫고, Guide 더블클릭시 Daily Forecast Status 팝업
 * 2013.09.17 진마리아 [CHM-201326446] Allocation Control 화면 보완 요청 - Fcast, BKG Total TEU 컬럼에 색깔 넣기(TP/SZ Control Option 열렸을때만)
 * 2013.11.26 진마리아 [선처리] IPC,TS 의 경우 ALL_POL 체크 후 조회시 (등록된 POL + SKD상 POD) pair 모두 조회 [IAS SECTOR 판매 활성화를 위한 TF]
 * 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면에서 팝업 호출시 사용되는 로직 추가
 * 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
 * 2015.01.30 신자영 [CHM-201533793] Control by H/O 상 Remark 입력 관련 오류 관련 확인 작업
 * 2015.03.18 김성욱 Booking(standby) 추가, TP/SZ(BKG) 추가,SB_FLG추가
 * 2015.03.24 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가(Control option 과 동일하게 적용 시켜줌)
 * 2015.06.03 김성욱 Edit 기능에 Async 기능 추가, Control Option Reg의 By Aloc등 9개 항목 Reset
 * 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
 * 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
 * 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
 * 2016.08.22 IAS Trade Alloc Confirm 기능 활성화
========================================================*/ 
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
 * @class ESM_SPC_0042 : ESM_SPC_0042 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0042() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}
 
/* 개발자 작업	*/
var sheetObjects     = new Array();
var comObjects       = new Array();
var sheetCnt         = 0;
var comboCnt         = 0;
var sheetResizeCount = 2;

// 항목에 보여야 하는 Tp/Sz 컬럼을 어떤 것을 사용하는지 index (sizeColName의 index)
//var colSizeIdx = new Array(5, 3, 6, 2, 0, 1, 7, 4, 0);
var colSizeIdx = new Array(5, 3, 6, 2, 0, 1, 7, 4, 0,8); //PreColName 의 Index 위치와 동일, 각 index의 값은 sizeColName 의 index값. 

// 항목이 화면에 보이는 control 대상인지 여부
var controlCols  = new Array(false, false, false, true, true, true, true, false, false,true);
var cmbTrendIdx  = 0;
var weeklyCmbIdx = 1;
var guideIdx     = 2;
var fcastIdx     = 3;
var alocIdx      = 4;
var bkgTtlIdx    = 5;
var bsIdx    = 6; //의미 없는 코드........ 낸주 삭제 해도 됨.
var cntrMoveIdx  = 7;
//baseIdx 화면에 없음. 무슨 기준인지 정의 필요
var baseIdx      = 8;
//2014.10.16 Master : detail의 Guide까지 column 갯수, Tail : mode부터 끝까지 column 갯수
var MasterCnt = 16;
var TailCnt   = 31;
var ColumnCnt = 0;

//Sheet2 저장 여부 
//var SHT2_SAVEAFTER = false;

var txtHeadItem = new Array("CMB Trend(+/-)", "Weekly CMB", "Guide","Forecast", "Allocation", "Booking (TTL)","Booking(VGM)", "CNTR Movement", "BASE","Booking(Standby)"); //2015.03.18 김성욱 Booking(standby) 추가, TP/SZ(BKG) 추가,
var HeadVolume = new Array("Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",
						   "Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",
		                   "Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",
		                   "TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT",
		                   "OP|OC|VL",
		                   "TEU|WGT",
		                   "Guide",
		                   "Volume|WT\n(M/T)", //sheet 2 의 가운데 헤더 2015.03.18 김성욱 Booking(standby) 추가, TP/SZ(BKG) 추가,
						   "Volume|WT\n(M/T)"
		                   );
var HeadTypeSize = new Array("TEU|D2|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)", // allocation
                             "Total TEU|20'|D2|40'|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)",// booking
                             "Total TEU|TEU|D2|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)",
		                     "CMB WK1|CMB WK2|CMB WK3|CMB WK4|CMB WK1|CMB WK2|CMB WK3|CMB WK4",
		                     "OP|OC|VL", 
		                     "TEU|WGT",
                             "Guide",
		                     "Total TEU|WT\n(M/T)",//sheet2 의 최하단 헤더 2015.03.18 김성욱 Booking(standby) 추가, TP/SZ(BKG) 추가,
							 "Total TEU|WT\n(M/T)"
                             );

var preColName  = new Array("trend", "cmb", "guide", "fcast", "asgn", "usd_bkg", "vgm","cm", "base", "bs"); //save_name 의 pre txt, 아래 sizeColName의 index 값.
var sizeColName = new Array(new Array("_ttl_qty", "_d2_qty", "_d4_qty","_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_rd_qty","_ttl_wgt"), //allocation - preColName
							new Array("_ttl_qty", "_20ft_qty", "_d2_qty", "_40ft_qty","_d4_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty","_rd_qty", "_ttl_wgt"), //bkg - preColName 
							new Array("_ttl_teu_qty", "_ttl_qty","_d2_qty", "_d4_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty","_rf_qty", "_rd_qty", "_ttl_wgt"), //fcast - preColName
							new Array("1", "2", "3", "4","_wgt1", "_wgt2", "_wgt3", "_wgt4"), //cmb - preColName
							new Array("_op", "_oc", "_vl"), //cm - preColName
							new Array("_qty", "_wgt"),//trend - preColName
							new Array(""),//guide - preColName
							new Array("_vol","_wgt"),
							new Array("_teu","_wgt"));// Sheet 2의 column [Booking] 이 추가됨. save_name 꺼 2015.03.18 김성욱 Booking(standby) 추가, TP/SZ(BKG) 추가,


var txtDelem = "|";
var HeadTail = "";
// 항목이 Type/Size, Weight control option에 따라 조절되어야 하는 항목인지 여부
var syncTarget = new Array(false, false, false, true, true, true, false, false);
// DataSelect에 나타나는 Item별 check box name
var dataSelectionItemName = new Array("", "chkWKCMB", "", "", "", "", "", "", "", "");
// 상단 sheet에서 weight컬럼 목록
//var weightCols = new Array(8, 10, 17, 19, 21, 24, 26, 28, 30, 32, 34)
var weightCols = new Array(8, 10, 17, 19, 21, 25, 27, 29, 31, 33, 35, 37, 39, 41);
// 상단 sheet에서 ocn컬럼 목록
//var ocnCols = new Array(14, 16, 17, 23, 24, 29, 30)
var ocnCols = new Array(14, 16, 17, 24, 25, 30, 31, 36, 37);
// 상단 sheet에서 ipc컬럼 목록
//var ipcCols = new Array(15, 18, 19, 25, 26, 31, 32)
var ipcCols = new Array(15, 18, 19, 26, 27, 32, 33, 38, 39);
//var tsCols = new Array(20, 21, 27, 28, 33, 34)
var tsCols = new Array(20, 21, 28, 29, 34, 35, 40, 41);

// 검색 조건 Forecast QTY View의 기존 검색시의 값
// 하단 sheet 검색시 사용하기 위해 상단 검색시에 저장
var fcastType = null;

// Weekly CMB 4주차를 위한 Hearder
var headWeek      = "";
var sheet1_selRow = 0;
var order         = "C";
var popParam      = "";

document.onclick = processButtonClick;

var init_year     = ''; 
var init_week     = ''; 
var init_duration = '';

function processButtonClick(){
	var sheetObject  = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject   = document.form;
	
	var srcName = window.event.srcElement.getAttribute("name");
	
	if(    srcName == ""
		|| (document.getElementsByName(srcName) == null || (    window.event.srcElement.tagName == "IMG"
			                                                 && document.getElementsByName(srcName)[0].Enable != undefined
			                                                 && !document.getElementsByName(srcName)[0].Enable))){
		return;
	}
	
	switch(srcName) {
		case "btn_retrieve":
			cancelControlOption(sheetObject);
			enableButtons(false);
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		
		case "btn_new":
			if(checkModifiedSheet(sheetObjects[1])){
				if(ComShowConfirm (getMsg("SPC90001")) != 1){
					return;
				}
			}
			
			resetAll();
			cancelControlOption(sheetObject);
			enableButtons(false);
			hiddenMasterCols(sheetObject, formObject, "INIT");
			
			formObject.year.value     = init_year;
			formObject.week.value     = init_week;
			formObject.duration.value = init_duration;
			SpcSearchOptionWeek("week",false,document.form.year.value);
			SpcSearchOptionLane("lane");
			break;
		
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		
		case "btn_downexcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
			break;
		
//		case "btng_temp":
//			var frow  = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
//			var vvd   = sheetObject.CellValue(frow, "VVD");
//			var param = "";
//			param = param + "&rlane_cd="   + sheetObject.CellValue(frow, "rlane_cd");
//			param = param + "&dir_cd="     + sheetObject.CellValue(frow, "dir_cd");
//			param = param + "&vsl_cd="     + vvd.substring(0, 4);
//			param = param + "&skd_voy_no=" + vvd.substring(4, 8);
//			param = param + "&skd_dir_cd=" + vvd.substring(8);
//			
//			var url = "ESM_SPC_0065.do?"+param;
//			var rtn = window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:" + 600 + "px;dialogHeight:" + 400 + "px")
//			
//			if(rtn == "OK"){
//				sheet1_OnDblClick(sheetObject, frow, 1);
//			}
//			break;
		
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
			
			var url = "ESM_SPC_0045.do?" + param;
			var rtn = window.open(url, "BOTTLENECK", "height=750px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
			break;
		
		case "btng_skd":
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
			
			var url = "ESM_BSA_0104.do?" + param;
			var rtn = window.open(url, "BSA", "height=720px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
			break;
		
		case "btng_controlEdit":
			editControlOption(sheetObject);
			break;
		
		case "btng_controlSave":
			if( ComShowConfirm (getMsg("SPC90010")) == 1 ){
				var rtn = saveControlOption(sheetObject);
				log("btng_controlSave - rtn : "+rtn);
				if(rtn || rtn == "OK"){
					var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
					sheetObject.CellValue2(frow, "desync_flg") = "";
					log("btng_controlSave - frow : "+frow);
					sheet1_OnDblClick(sheetObject, frow, 1);
				}
			}
			break;
		
		case "btng_controlCancel":
			cancelControlOption(sheetObject);
			break;
		
		case "btng_cust_grp":
			window.showModalDialog("ESM_SPC_0031.do?"+popParam, null, "dialogHeight:350px;dialogWidth:910px;center:yes;resizable:yes;scroll:no;status:no;unadorned:yes;");
			break;
		
		// add 2012.10.30 - Allocation Copy 기능 추가 : Req. by CDO 신혜성 차장님
		case "btng_copy":
			var rowIndex = sheet1_SelectedRow+2;
			var vvd      = sheetObject.CellValue(rowIndex, "VVD");
			var vsl_cd   = sheetObject.CellValue(rowIndex, "vsl_cd");
			
			var param    = "";
			param = param + "f_cmd="	   + SEARCHLIST02;
			param = param + "&office="	   + formObject.office.value;
			param = param + "&lane="	   + sheetObject.CellValue(rowIndex, "rlane_cd");
			param = param + "&bound="	   + sheetObject.CellValue(rowIndex, "dir_cd");
			param = param + "&vvd="		   + vvd;
			param = param + "&trade="	   + sheetObject.CellValue(rowIndex, "TRADE");
			param = param + "&subtrade="   + sheetObject.CellValue(rowIndex, "STRADE");
			param = param + "&year="	   + sheetObject.CellValue(rowIndex, "WEEK").substring(0, 4);
			param = param + "&week="	   + sheetObject.CellValue(rowIndex, "WEEK").substring(4);
			param = param + "&fcast="	   + formObject.fcast.value;
			param = param + "&vsl_cd="	   + vsl_cd;
			param = param + "&skd_voy_no=" + sheetObject.CellValue(rowIndex, "skd_voy_no");
			param = param + "&skd_dir_cd=" + sheetObject.CellValue(rowIndex, "skd_dir_cd");
			param = param + "&duration="   + formObject.duration.value;
			param = param + "&acct_ctrl="  + formObject.acctCtrl.value;
			param = param + "&div="        + "HO";
			
			var url = "ESM_SPC_0046.do?"+param;
			var rtn = window.open(url, "SPC", "height=400px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
			break;
			
	    // Allocation Confirm 
		case "btng_aloc_confirm":
			doActionIBSheet(sheetObject1, formObject, IBCREATE);
			
			break;
					
		// Accum. Guide Performance 팝업 호출
		case "btng_accum":
			accumGuidePfmc();
			break;
			
		case "btng_season_grp":
			yieldGrpPopup();
			break;
			
		case "btng_cmpl_firm" :
			var obj = document.getElementById("office");
			var selOfc = obj.options[obj.selectedIndex].value;
			var param = "vvd_no=" + document.getElementById("idTxtVVD").value+"&origin="+selOfc; // sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "VVD" )+"&origin="+selOfc;
			var url = "ESM_SPC_0116.do?" + param;
			var rtn = window.open(url, "SPC", "height=720px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
			break;
	}
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
	
	enableButtons(false);
	document.form.year.focus();
	comObjects[0].Enable = false;
	
	var formObject = document.form;
	if(document.getElementById("trade").Enable == false) document.getElementById("trade").tabIndex = 1;
	if(document.getElementById("subtrade").Enable == false) document.getElementById("subtrade").tabIndex = 1;
	
	var sheetResizeFull = true;
	document_onresize();
	
	if (document.form.popup_flg.value =='Y') { //PopUp으로 호출되었으면
		var sheetObject  = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var formObject   = document.form;
		
		// 0057 에서 호출시 적용
		if (document.form.type.value == 'Y') {
			toggleSheetSizeMax();
		}
		
		cancelControlOption(sheetObject);
		enableButtons(false);
		
		comObjects[2].Code = document.form.popup_rlane_cd.value;
		document.form.vvd.value     = document.form.popup_vvd.value;
		document.form.year.value     = document.form.popup_year.value;
		document.form.week.options.value    = document.form.popup_week.value;
		document.form.duration.value = document.form.popup_duration.value;
    
		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	}
	
	init_year     = formObject.year.value;	//년 초기화용
	init_week     = formObject.week.value;	//주차 초기화용
	init_duration = formObject.duration.value;	//Duration 초기화용
	
	hiddenSelectionField(sheetObjects[1]);
	ComBtnDisable("btng_cmpl_firm");
//	document.form.week.value = 18;
//	document.form.duration.value = 1;
//	comObjects[0].Code = 'TPS';
//	comObjects[1].Code = 'AW';
//	comObjects[2].Code = 'AWTTP';
//	document.form.vvd.value = 'NNTS0022E'; //'SI0034E'; 
}

function enableButtons(enable){
	if(enable){
		ComBtnEnable("btng_copy");
//		ComBtnEnable("btng_temp");
		ComBtnEnable("btng_controlEdit");
		ComBtnEnable("btng_bottleneck");
		ComBtnEnable("btng_skd");
		ComBtnEnable("btng_bsa");
				
		if(document.form.acctCtrl.value == "Y"){
			ComBtnEnable("btng_accum");
			ComBtnEnable("btng_cust_grp");
			ComBtnEnable("btng_season_grp");
		}else{
			ComBtnDisable("btng_accum");
			ComBtnDisable("btng_cust_grp");
			ComBtnDisable("btng_season_grp");
		}
	} else {
		ComBtnDisable("btng_cust_grp");
		ComBtnDisable("btng_copy");
//		ComBtnDisable("btng_temp");
		ComBtnDisable("btng_controlEdit");
		ComBtnDisable("btng_bottleneck");
		ComBtnDisable("btng_skd");
		ComBtnDisable("btng_bsa");
		ComBtnDisable("btng_accum");
		ComBtnDisable("btng_season_grp");
		
		ComBtnDisable("btng_aloc_confirm");
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt      = 0;
	var acctCtrl = document.form.acctCtrl.value;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = getSheetHeight(10) ;
				// 전체 너비 설정
				SheetWidth = mainTable1.clientWidth;
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				FocusEditMode = default_edit_mode;
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 3, 1, 9, 100);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;
				
				var Head1      = "SEQ|Rep.\nTrade|Sub\nTrade|Lane|BD|Week|VVD|";
				var Head2      = "|vsl_cd|skd_voy_no|skd_dir_cd|ctrl_spc_flg|ctrl_lvl_cd|ctrl_40ft_hc_flg|ctrl_45ft_hc_flg|ctrl_53ft_flg|ctrl_rf_flg|ctrl_d2_flg|ctrl_d4_flg|ctrl_rd_flg|ctrl_ecc_flg|ctrl_loc_flg|ctrl_usa_svc_mod_flg|ctrl_acct_flg|ctrl_dest_lvl_cd|ctrl_wgt_flg|smp|fixed|flag|ibflag|mty|dataSeq|edit_flg|mnl_flg|sb_flg|";
				var HeadTitle0 = Head1 + "BSA|BSA|Loadable|Loadable|Loadable|Loadable|Loadable|Load|Load|F'CAST|F'CAST|F'CAST|F'CAST|F'CAST|F'CAST|L/F\n(%)|L/F\n(%)|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|BKG|BKG|BKG|BKG|BKG|BKG|Booking VGM|Booking VGM|Booking VGM|Booking VGM|Booking VGM|Booking VGM|Standby BKG|Standby BKG|CNTR Movement|CNTR Movement|CNTR Movement|Un\nAllocated\nSpace" + Head2;
				var HeadTitle1 = Head1 + "VOL|WGT|VOL|WGT|HC|45|RF|QTA|QTA|OCN|OCN|IPC|IPC|TS|TS|TEU\n(F'cast)|WGT\n(BKG)|OCN|OCN|IPC|IPC|TS|TS|OCN|OCN|IPC|IPC|TS|TS|OCN|OCN|IPC|IPC|TS|TS|TEU|WGT|OP|OC|VL|Un\nAllocated\nSpace" + Head2;
				var HeadTitle2 = Head1 + "VOL|WGT|VOL|WGT|HC|45|RF|OCN|IPC|VOL|WGT|VOL|WGT|VOL|WGT|TEU\n(F'cast)|WGT\n(BKG)|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|TEU|WGT|OP|OC|VL|Un\nAllocated\nSpace" + Head2;
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				// D2, D4, RD 추가에 따라 +3
//				InitColumnInfo(64, 7 , 0, true);
				InitColumnInfo(ComCountHeadTitle(HeadTitle2), 7 , 0, true);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				InitHeadRow(2, HeadTitle2, true);
				
				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ ,	dtDataSeq,		30,	daCenter,	true,	"SEQ",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daCenter,	true,	"TRADE",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daCenter,	true,	"STRADE",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			45,	daCenter,	true,	"rlane_cd",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			45,	daCenter,	true,	"dir_cd",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			55,	daCenter,	true,	"WEEK",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"VVD",				false,	"",	dfNone,			0,	true,	true);
				//BSA
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		1,	true,	true);
				//Loadable
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"lod_vol",			false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"lod_wgt",			false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"lod_hc",			false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"lod_45",			false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"lod_rf",			false,	"",	dfInteger,		0,	true,	true);
				//load
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		1,	true,	true);
				//F'Cast
				InitDataProperty(0,	cnt++ ,	dtData,			50,	daRight,	true,	"",					false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			50,	daRight,	true,	"",					false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		1,	true,	true);
				//L/F(%)
				InitDataProperty(0,	cnt++ ,	dtData,			50,	daRight,	true,	"",					false,	"",	dfNullFloat,	1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			50,	daRight,	true,	"",					false,	"",	dfNullFloat,	1,	true,	true);
				//Allocation
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"alloc_ocn_vol",	false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"alloc_ocn_wgt",	false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"alloc_ipc_vol",	false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"alloc_ipc_wgt",	false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"alloc_ts_vol",		false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"alloc_ts_wgt",		false,	"",	dfInteger,		1,	true,	true);
//				//Booking
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ocn_vol",					false,	"",	dfInteger,		0,	true,	true);//ocn
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ocn_wgt",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ipc_vol",					false,	"",	dfInteger,		0,	true,	true);//ipc
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ipc_wgt",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ts_vol",					false,	"",	dfInteger,		0,	true,	true);//ts
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ts_wgt",					false,	"",	dfInteger,		1,	true,	true);
				//Booking VGM
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ocn_vol_vgm",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ocn_wgt_vgm",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ipc_vol_vgm",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ipc_wgt_vgm",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ts_vol_vgm",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"ts_wgt_vgm",					false,	"",	dfInteger,		1,	true,	true);
				//Standby BKG - 2015.04.13, 김성욱 추가.
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"bkg_bs_vol",					false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"bkg_bs_wgt",					false,	"",	dfInteger,		1,	true,	true);
				
				// CNTR Movement
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtData,			40,	daRight,	true,	"",					false,	"",	dfInteger,		1,	true,	true);
				
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			80,	daRight,	true,	"",						false,	"",	dfInteger,		0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"vsl_cd",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"skd_voy_no",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"skd_dir_cd",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_spc_flg",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_lvl_cd",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_40ft_hc_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_45ft_hc_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_53ft_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_rf_flg",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_d2_flg",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_d4_flg",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_rd_flg",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_ecc_flg",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_loc_flg",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_usa_svc_mod_flg",	false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_acct_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_dest_lvl_cd",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_wgt_flg",			false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"acct_grp_ctrl_flg",	false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"ctrl_fx_rt_flg",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"flag",					false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtStatus:dtHiddenStatus,	40,	daCenter,	true,	"ibflag",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			40,	daRight,	true,	"mty",					false,	"",	dfInteger,		1,	true,	true);
				InitDataProperty(0,	cnt++ ,	dtSeq,							20,	daCenter,	true,	"dataSeq",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"edit_flg",		    	false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			40,	daCenter,	true,	"mnl_flg",				false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			40,	daCenter,	true,	"sb_flg",				false,	"",	dfNone,			0,	true,	true); //2015.03.18 김성욱 Booking(standby) 추가, TP/SZ(BKG) 추가,SB_FLG추가

				//				InitDataProperty(0,	cnt++ ,	dtHidden,		40,	daCenter,	true,	"desync_flg",	false,	"",	dfNone,			0,	true,	true); //2015.06.03 김성욱 Edit 기능에 Desync 기능 추가, Control Option Reg의 By Aloc등 9개 항목 Reset
				InitDataProperty(0,	cnt++ ,	dtData,		1,	daRight,	true,	"",					false,	"",	dfNone,			0,	false,	false);
				
				ColHidden("dataSeq") = true;
				HeadRowHeight = 10;
				
				var backColor = RgbColor(222, 251, 248);
				RangeBackColor(1,  7, 2, 13) = backColor;
				RangeBackColor(2, 14, 2, 15) = backColor;
				RangeBackColor(1, 16, 2, 28) = backColor;
			}
			break;
		
		case 2:      //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = getSheetHeight(15) ;
				// 전체 너비 설정
				SheetWidth = mainTable2.clientWidth;
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				FocusEditMode = default_edit_mode;
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(acctCtrl=="Y"?5:3, 1, 9, 100);
				
				var HeadTitle0 = "OCN\nIPC\nT/S|Area\nRHQ|Load\nOffice|Yield\nGroup|LOCAL\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |QTA|QTA|CMB|CMB|Blank";
				var HeadTitle1 = "OCN\nIPC\nT/S|Area\nRHQ|Load\nOffice|Yield\nGroup|LOCAL\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load|CMB|" + (acctCtrl=="Y"?"AVG":"TEU") + "|WGT|Blank";
				var HeadTitle2 = "OCN\nIPC\nT/S|Area\nRHQ|Load\nOffice|Yield\nGroup|LOCAL\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load|CMB|" + (acctCtrl=="Y"?"A CMPB":"TEU") + "|WGT|Blank";
				var HeadTitle3 = "OCN\nIPC\nT/S|Area\nRHQ|Load\nOffice|Yield\nGroup|LOCAL\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load|CMB|B CMPB|WGT|Blank";
				var HeadTitle4 = "OCN\nIPC\nT/S|Area\nRHQ|Load\nOffice|Yield\nGroup|LOCAL\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load|CMB|C CMPB|WGT|Blank";
				
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
				
				var HeadHidden = "|flg|status|rhq|lane|bound|V|V|D|TS|MNG|OFC|lvl1|lvl2|lvl3|lvl4|lvl5|child|leaf|pol|lvl|ts|trd|sub_trd|rowIoc|rowDest|rowOfc|Remark|Remark|Remark|";//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				
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
				
				ColumnCnt += 1; //컬럼 마지막에 hidden 정보때문에 1 증가 시킴.-김성욱 //2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ColumnCnt , MasterCnt - 1 , 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				InitHeadRow(2, HeadTitle2, false);
				if(acctCtrl=="Y") {
					InitHeadRow(3, HeadTitle3, true);
					InitHeadRow(4, HeadTitle4, true);
				}
				
				ImageList(0) = "img/nolines_plus.gif";
				ImageList(1) = "img/nolines_minus.gif";
				
				// [ROW, COL,  DATATYPE, WIDTH,        DATAALIGN,  COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtData,		30,	daCenterTop,	true,	"ioc_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"sls_area_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"sls_ofc_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"cust_ctrl_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"us_mod",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,	    55,	daCenterTop,	true,	"account_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daLeftTop,		true,	"account_nm",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"pol_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"pod_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		55,	daCenterTop,	true,	"del_cd",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,	42,	daCenter,		true,	"",						false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		true,	"bkg_quota",			false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		true,	"bkg_qta_cmb",			false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		50,	daRight,		true,	"cmb",					false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		true,	"cmb_wgt",				false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,	60,	daRight,		true,	"",						false,	"",	dfInteger,	0,	false,	false);
				//InitDataProperty(0,	cnt++,	dtData,		60,	daRight,		true,	"fcast_ttl_teu_qty",	false,	"",	dfInteger,	0,	false,	false);

				
				for(var k = 0 ; k < txtHeadItem.length ; k++){
					var colNames = sizeColName[colSizeIdx[k]];
					var dtType   = false;
					
					if(controlCols[k] || preColName[k] == "cm" || preColName[k] == "cmb" || preColName[k] ==  "trend" || preColName[k] ==  "guide"){
						dtType = true;
					}
					
					for(var i = 0 ; i < colNames.length ; i++){
						InitDataProperty(0,	cnt++,	dtType?dtData:dtHidden,	defaultWidth,	daRight,	true,	preColName[k]+colNames[i],	false,	"",	dfInteger,	1,	(k==alocIdx),	(k==alocIdx));
					}
				}
				
				InitDataProperty(0,	cnt++,	dtHidden,		20,		daCenter,	true,	"mode",						false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	20,		daCenter,	true,	"ibflag",					false,	"",	dfNone,	0,	false,	true);
				
				InitDataProperty(0,	cnt++,	dtHidden,		45,		daCenter,	true,	"sls_rhq_cd",				false,	"",	dfNone,	0,	false,	false);
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
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"rowIoc",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"rowDest",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"rowOfc",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			100,	daLeft,		true,	"spc_ctrl_aloc_rmk",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			100,	daLeft,		true,	"spc_ctrl_aloc_pol_rmk",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			100,	daLeft,		true,	"spc_ctrl_aloc_pod_rmk",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtHidden,		20,		daCenter,	true,	"mode_rmk",					false,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			1,		daRight,	true,	"",							false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,			1,		daRight,	true,	"aloc_mdfy",				false,	"",	dfNone,	0,	false,	false); //2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				
				HeadRowHeight  = 10;
				
				var backColor = RgbColor(222, 251, 248);
				// header aqua색 
				RangeBackColor(1, MasterCnt - 1, 2, ColumnCnt - TailCnt - 1) = backColor;
				//2014.07.17 Local/IPI, Account, DEST추가로 + 2 --DEST는 하위단으로 제외, Name 추가
				InitTreeInfo(10, "sLevel", RgbColor(0,0,255), false);
				ClipPasteMode = 1;
				
				EditableColor   = RgbColor(255,255,128);		//Default:255,255,255, 흰색 Edit 가능 데이터 배경색
				UnEditableColor = RgbColor(255,255,255);		//Default:239,235,239, 회색 Edit 불가능 데이터 배경색
				
				for(var i = 0 ; i < sizeColName[colSizeIdx[alocIdx]].length + 1 ; i++){
					MinimumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][i]) = 0;
					MaximumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][i]) = 100000;
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
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)){
				return false;
			}
			formObj.f_cmd.value = SEARCHLIST01;
			sheetObj.ReDraw = false;
			sheetObj.RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.chkTS.checked = true;
			
			var param = SpcFormString(formObj,"f_cmd,year,week,duration,vvd,fcast,trade,subtrade,lane,bound,office,type");
			//첫번째 시트 조회 후 검색조건의 주차를 이용하여 하단 분의 Weekly CMB 4주차를 표현하기 위해 ETC로 담아오는 부분을 위해 GetSearchXml로 변경
			var sXml = sheetObj.GetSearchXml("ESM_SPC_0042GS.do", param);			
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
		
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)){
				return false;
			}
			
			if(formObj.acctCtrl.value == "Y"){
				formObj.f_cmd.value = MULTI02; //SMP
			} else {
				formObj.f_cmd.value = MULTI;
			}
			
			var rows     = sheetObj.GetTransColText("U", "mode");
			var rowArr   = rows.split(";");
			var rowCnt   = rowArr.length;
			var chekport = formObj.chkPort.value;
			
			for(var i = 0 ; i < rowCnt ; i++){
				var rowInfo = rowArr[i].split("=");
				// 3개 level up
//				if(sheetObj.CellValue(rowInfo[0]*1, "lvl")*1 < 3){
				if(sheetObj.CellValue(rowInfo[0]*1, "lvl")*1 < 6){
					sheetObj.RowStatus(rowInfo[0]*1) = "I";
				}
				else if(rowInfo[1] == "I"){
					sheetObj.RowStatus(rowInfo[0]*1) = "I";
				}
				
				if(chekport == "O" && sheetObj.cellValue(i, "mode_rmk") == 'UPD'){
					if(   sheetObj.cellValue(i, "sub_trd_cd")!= 'IA'
						&& (sheetObj.cellValue(i, "ioc_cd") == 'IPC' || sheetObj.cellVAlue(i, "ioc_cd") == 'T/S')){
						sheetObj.cellValue2(i, "spc_ctrl_aloc_rmk") = "";
					}
				}
				
				if(chekport == "L" && sheetObj.cellValue(i, "mode_rmk") == 'UPD'){
					if(   sheetObj.cellValue(i, "sub_trd_cd")!= 'IA'
						&& (sheetObj.cellValue(i, "ioc_cd") == 'IPC' || sheetObj.cellVAlue(i, "ioc_cd") == 'T/S')){
						sheetObj.cellValue2(i, "spc_ctrl_aloc_pol_rmk") = "";
					}
				}
			}
			var param = SpcFormString(formObj,"f_cmd,chkPort");
			param += "&ctrl_lvl="+formObj.chkPort.value;
			if( formObj.chkWT.checked )
				param += "&ctrl_wt=Y";
			else
				param += "&ctrl_wt=N";
			var rtn = doSaveSheet(sheetObj, "ESM_SPC_0042GS.do", param);
			
			//저장하고 난 다음 변경된 값을 가져온다.
			var rData = rtn.split(":");
			
			if(rData[0] == "OK"){
				//저장한 후 가져온 결과값을 sheet에 세팅.
				if( rData[1] != "null" ){
					var ary = rData[1].split("|");
					if( ary.length > 0 ) {
						for( var xx=0 ; xx<ary.length ; xx++ ) {
							var ary2 = ary[xx].split(",");
							if( ary2.length > 1 && ary2[0] != "" && ary2[1] != null && ary2[1] != "" ) { 
								var rRow = ary2[0]*1;
								if( rRow > 0 ){
									//TEU 계산
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
									
									
									changValueStandby(sheetObj, rRow, '', dif , "", yield, oit , wdif );
								}
							}
						}
//						getSheet2Total();
					}
				}
				for(var i = 0 ; i < rowCnt ; i++){
					var rowInfo = rowArr[i].split("=");
				
					if(rowInfo[1] == "I"){
						sheetObj.CellValue2(rowInfo[0]*1, "mode") = "R";
						sheetObj.RowStatus(rowInfo[0]*1)          = "R";
					}
				}
				
				var cnt    = sizeColName[colSizeIdx[alocIdx]].length - 1;
				var frow   = sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
				var sumArr = getSum(sheetObj, ":OCN:T-OCN:", preColName[alocIdx], formObj);
				
				sheetObjects[0].CellValue2(frow, "alloc_ocn_vol") = sumArr[0];
				sheetObjects[0].CellValue2(frow, "alloc_ocn_wgt") = sumArr[cnt];
				
				var sumArr = getSum(sheetObj, ":IPC:T-IPC:", preColName[alocIdx], formObj);
				sheetObjects[0].CellValue2(frow, "alloc_ipc_vol") = sumArr[0];
				sheetObjects[0].CellValue2(frow, "alloc_ipc_wgt") = sumArr[cnt];
				
				var sumArr = getSum(sheetObj, ":T/S:T-T/S:", preColName[alocIdx], formObj);
				sheetObjects[0].CellValue2(frow, "alloc_ts_vol") = sumArr[0];
				sheetObjects[0].CellValue2(frow, "alloc_ts_wgt") = sumArr[cnt];
				sheetObjects[0].RowStatus(frow) = "R";
				
				var trow = 0;
				for(var r = 0 ; r < Flags.length ; r++){
					trow = totalRows[Flags[r]];
					
					if(trow == undefined){
						continue;
					}
					
					setTotalRowColor(sheetObj, trow);
				}
				
//				ComShowMessage("saved successfully.");
				ComShowMessage(getMsg("SPC90149"));
				
//				SHT2_SAVEAFTER = true;
//				sheet1_OnDblClick(sheetObjects[0], sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow), 1);
			} 
			
			
			
			break;
		
		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
//			sheetObjects[0].CellValue2( sheet1_selRow ,"bkg_bs_vol") = parseInt( sheetObjects[0].CellValue( sheet1_selRow ,"bkg_bs_vol") ) + (-5) ;//위쪽 sheet의 standby 변경
//			changValueStandby(sheetObj, 172, '', -5 , "", "C", "OCN" );
			break;
					

		case IBCREATE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)){
				return false;
			}

            ComOpenWait(true);
			var rowIndex = sheetObj.HeaderRows;			
		//	var vsl_cd   = sheetObj.CellValue(rowIndex, "vsl_cd");
			
		//	alert(rowIndex+"-----"+sheetObj.CellValue(rowIndex, "vsl_cd"));
		
			var param    = "";
			param = param + "f_cmd="	   + MULTI03;
			param = param + "&rlane_cd="   + sheetObj.CellValue(rowIndex, "rlane_cd");
			param = param + "&trd_cd="	   + sheetObj.CellValue(rowIndex, "trd_cd");
			param = param + "&vsl_cd="	   + sheetObj.CellValue(rowIndex, "vsl_cd");
			param = param + "&skd_voy_no=" + sheetObj.CellValue(rowIndex, "skd_voy_no");
			param = param + "&org_ofc=" + document.form.office.value;
			param = param + "&skd_dir_cd=" + sheetObj.CellValue(rowIndex, "skd_dir_cd");
						
 			var sParamSheet =sheetObj.GetSaveString(true);
 			
 			if (sParamSheet != "") {
 				param = param + "&" + sParamSheet;
			}
 			
 			var sXml = sheetObj.GetSaveXml("ESM_SPC_0042GS.do", param);                    	
             
 			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){   
 				ComShowMessage(getMsg("SPC90150"));
 				
 				//btn disable
 				ComBtnDisable("btng_aloc_confirm");
			}          
              
            ComOpenWait(false);
            break;
	}
}

/*
 * 저장후 호출
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	if(sheetObj.EtcData("status") != "OK"){
		ComShowMessage(errMsg);
	}
}

var setTotal;
//저장 후 재 검색 하면 나오는 Total 값을 상단 sheet의 Total 에 넣는 작업
function getSheet2Total() {
	var bkg_ocn_teu = 0;
	var bkg_ocn_wgt = 0;
	var bkg_ipc_teu = 0;
	var bkg_ipc_wgt = 0;
//	var bkg_eq_teu = 0;
//	var bkg_eq_wgt = 0;
	var bkg_ts_teu = 0;
	var bkg_ts_wgt = 0;
	
	var bs_teu_val = 0;
	var bs_wgt_val = 0;
	
	var sRow = totalRows["OCN"]
	if( sRow > 0 ) {
		bkg_ocn_teu = parseInt( sheetObjects[1].CellValue( sRow , "usd_bkg_ttl_qty" ) );
		bkg_ocn_wgt = parseInt( sheetObjects[1].CellValue( sRow , "usd_bkg_ttl_wgt" ) );

		bs_teu_val = parseInt( sheetObjects[1].CellValue( sRow , "bs_teu" ) );
		bs_wgt_val = parseInt( sheetObjects[1].CellValue( sRow , "bs_wgt" ) );
	}
	sRow = totalRows["IPC"];
	if( sRow > 0 ) {
		bkg_ipc_teu = parseInt( sheetObjects[1].CellValue( sRow , "usd_bkg_ttl_qty" ) );
		bkg_ipc_wgt = parseInt( sheetObjects[1].CellValue( sRow , "usd_bkg_ttl_wgt" ) );
	}
	sRow = totalRows["T/S"];
	if( sRow > 0 ) {
		bkg_ts_teu = parseInt( sheetObjects[1].CellValue( sRow , "usd_bkg_ttl_qty" ) );
		bkg_ts_wgt = parseInt( sheetObjects[1].CellValue( sRow , "usd_bkg_ttl_wgt" ) );
	}
	
	sRow =  sheetObjects[0].HeaderRows + sheet1_SelectedRow -1;
//	alert( sheet1_SelectedRow +":"+ sRow  +"//////"+ bkg_ocn_teu +":"+ bs_teu_val);
//	sheetObjects[0].CellValue2( sRow , "ocn_vol" ) = bkg_ocn_teu;
//	sheetObjects[0].CellValue2( sRow , "ocn_wgt" ) = bkg_ocn_wgt;
//	sheetObjects[0].CellValue2( sRow , "ipc_vol" ) = bkg_ipc_teu;
//	sheetObjects[0].CellValue2( sRow , "ipc_wgt" ) = bkg_ipc_wgt;
//	sheetObjects[0].CellValue2( sRow , "ts_vol" ) = bkg_ts_teu;
//	sheetObjects[0].CellValue2( sRow , "ts_wgt" ) = bkg_ts_wgt;
//	sheetObjects[0].CellValue2( sRow , "bkg_bs_vol" ) = bs_teu_val;
//	sheetObjects[0].CellValue2( sRow , "bkg_bs_wgt" ) = bs_wgt_val;
 }

var selectedCell_OldValue = 0;
function sheet2_OnSelectCell(sheetObj, orow, ocol, row, col){
	selectedCell_OldValue = sheetObj.CellValue(row, col)*1;
}
/*
function sheet2_OnChange(sheetObj, Row, Col,Value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(Col);
	
	/////////////////CNEP0054E
	
	if(colName == "asgn_ttl_qty") {
		if(formObj.chkPort.value == "L" && formObj.por_dbl_port_chk.value == "Y") {
			
			ComShowMessage("In case of Double Calling Lane(Route) touching two different tmnl within one port or one port several times,\nPlease allocate space with 'POL/POD' control option.");
			sheetObj.CellValue(Row, Col) = selectedCell_OldValue;
		//	sheetObj.SelectCell(Row, 0, false);
			//return false;
		}
	}
}
*/
// detail 값 변경 시
function sheet2_OnChange(sheetObj, row, col, value) {
	var colName = sheetObj.ColSaveName(col);

	var formObj = document.form;
	var idx = colName.indexOf("_");
	var pre = colName.substring(0, idx);
	var sizeName = colName.substring(idx);
	value = value * 1;
	var level = sheetObj.CellValue(row, "lvl") * 1;
		
	/////////////////CNEP0054E	
	var regexp = /^asgn_|_qty$/ig;
	if(colName.search(regexp) > -1) {
		if(formObj.chkPort.value == "L" && formObj.pol_dbl_port_chk.value == "Y") {
			sheetObj.CellValue2(row, col) = selectedCell_OldValue;
			ComShowMessage("In case of Double Calling Lane(Route) touching two different tmnl within one port or one port several times,\nPlease allocate space with 'POL/POD' control option.");
			return false;
		}
	}
	
	
	if (pre == preColName[alocIdx]) {
		orgValue = sheetObj.CellValue(row, preColName[baseIdx] + sizeName) * 1;
		// office level이 account 일 때.
		// 여기서 그럼 account 와 local IPI는 모두 Others로 가정해야 함
		if (level == 1) {
			// 첫 값으로 바꿈 OTHERS가 없는 경우 있음
			// frow = sheetObj.FindText("us_mod", "OTHERS", row + 1);
			// new_row = sheetObj.FindText("account_cd", "OTHERS", frow + 1);
			frow = sheetObj.FindText("lvl", "2", row + 1);
			new_row = sheetObj.FindText("lvl", "3", frow + 1);
			sheetObj.CellValue2(frow, pre + sizeName) = value;
			sheetObj.CellValue(new_row, pre + sizeName) = value;
			// allocateByOffice(sheetObj, new_row, pre, sizeName,
			// preColName[baseIdx], value, orgValue);

		}
		if (level == 2) {
			// Account level에서 입력 할때
			oldGrpValue_2 = selectedCell_OldValue;
			new_row = sheetObj.FindText("account_cd", "OTHERS", row + 1);
			sheetObj.CellValue(new_row, pre + sizeName) = value;
			if (sheetObj.CellEditable(row, col)) {
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_2, level);

				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장 
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}

		}
		if (level == 3) {
			oldGrpValue_3 = selectedCell_OldValue;
			allocateByOffice(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
			if (sheetObj.CellEditable(row, col)) {
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_3, level);
				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장 
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}
		}
		if (level == 4) {
			// oldGrpValue는 changeSuperiorValue에 이전 값 SETTING
			oldValue = selectedCell_OldValue;
			oldGrpValue_4 = selectedCell_OldValue;
			allocateByPol(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
			if (sheetObj.CellEditable(row, col)) {
				// alert("value = " + value + "oldGrpValue = " + oldGrpValue_4);
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_4, level);
				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장 
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}
		}
		if (level == 5) {
			oldValue = selectedCell_OldValue;
			oldGrpValue_5 = selectedCell_OldValue;
			allocateByPod(sheetObj, row, pre, sizeName, preColName[baseIdx],value, oldValue);
			if (sheetObj.CellEditable(row, col)) {
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_5, level);
				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장 
					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
				}
			}

			var ioc_cd = sheetObj.CellValue(row, "ioc_cd");
			var cust_ctrl_cd = sheetObj.CellValue(row, "cust_ctrl_cd");
//			var del_cd = sheetObj.CellValue(row, "del_cd");
			var rowOfc = sheetObj.CellValue(row, "rowOfc");
			// changeTotalValue(sheetObj, ioc_cd, col, pre, value, oldValue);
			// 2014.10.06 DEST별 Total추가
//			changeDestTotalValue(sheetObj, ioc_cd, del_cd, col, pre,value, oldValue);
			if (document.form.acctCtrl.value == "Y") {
				changeOfcTotalValue(sheetObj, rowOfc, col, pre, value, oldValue);
				changeGroupTotalValue(sheetObj, ioc_cd, cust_ctrl_cd, col, pre,value, oldValue);
			}
		}
		if (level == 6) {
			oldValue = selectedCell_OldValue;
			oldGrpValue_6 = selectedCell_OldValue;
			if (sheetObj.CellEditable(row, col)) {
				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value,
						oldGrpValue_6, level);
			}

			var ioc_cd = sheetObj.CellValue(row, "ioc_cd");
			var cust_ctrl_cd = sheetObj.CellValue(row, "cust_ctrl_cd");
			var del_cd = sheetObj.CellValue(row, "del_cd");
			var rowOfc = sheetObj.CellValue(row, "rowOfc");

			changeTotalValue(sheetObj, ioc_cd, col, pre, value, selectedCell_OldValue);
			// 2014.10.06 DEST별 Total추가
			changeDestTotalValue(sheetObj, ioc_cd, del_cd, col, pre,value, oldValue);
			if (document.form.acctCtrl.value == "Y" && sheetObj.CellEditable(row, col)) {
				changeOfcTotalValue(sheetObj, rowOfc, col, pre, value, oldValue);
				changeGroupTotalValue(sheetObj, ioc_cd, cust_ctrl_cd, col, pre,value, oldValue);	
			}
		}
	}
	
	selectedCell_OldValue = value;
	
	var formObj  = document.form;
	var chekport = formObj.chkPort.value;
	var ioc_cd = sheetObj.CellValue(row, "ioc_cd");
	var ibflag = sheetObj.CellValue(row, "ibflag");
	
	if(chekport == "O"){
		if(    sheetObj.cellValue(row, "sub_trd_cd")!= 'IA'
			&& (sheetObj.cellValue(row, "ioc_cd") == 'IPC' || sheetObj.cellVAlue(row, "ioc_cd") == 'T/S')){
			sheetObj.cellValue2(row, "spc_ctrl_aloc_pod_rmk") = sheetObj.cellValue(row, "spc_ctrl_aloc_rmk");
			sheetObj.cellValue2(row, "mode_rmk") = "UPD";
		}
	}
	
	if(chekport == "L"){
		if(    sheetObj.cellValue(row, "sub_trd_cd")!= 'IA'
			&& (sheetObj.cellValue(row, "ioc_cd") == 'IPC' || sheetObj.cellVAlue(row, "ioc_cd") == 'T/S')){
			sheetObj.cellValue2(row, "spc_ctrl_aloc_pod_rmk") = sheetObj.cellValue(row, "spc_ctrl_aloc_pol_rmk");
			sheetObj.cellValue2(row, "mode_rmk") = "UPD";
		}
	}
	
	if(chekport == "D"){
		if(    sheetObj.cellValue(row, "sub_trd_cd")!= 'IA'
			&& (sheetObj.cellValue(row, "ioc_cd") == 'IPC' || sheetObj.cellVAlue(row, "ioc_cd") == 'T/S')){
			sheetObj.cellValue2(row, "mode_rmk") = "UPD";
		}
	}
	
	// SMP 일 경우 Remark 처리
// 2015.01.29 SMP가 아닌 경우 remark만  입력 시 저장이 안되는 현상 수정 위해 아래 조건 막음
//	if(!sheetObj.ColHidden("cust_ctrl_cd")) {
		var ioc_cd       = sheetObj.cellValue(row, "ioc_cd");
		var sls_area_cd  = sheetObj.cellValue(row, "sls_area_cd");
		var sls_ofc_cd   = sheetObj.cellValue(row, "sls_ofc_cd");
		var cust_ctrl_cd = sheetObj.cellValue(row, "cust_ctrl_cd");
		var pol_cd       = sheetObj.cellValue(row, "pol_cd");
		var pod_cd       = sheetObj.cellValue(row, "pod_cd");
		var del_cd       = sheetObj.cellValue(row, "del_cd");
		var account_cd   = sheetObj.cellValue(row, "account_cd");
		var us_mod       = sheetObj.cellValue(row, "us_mod");

		
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
//	}
}

function sheet2_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "cust_ctrl_cd":
		case "account_cd":
		case "account_nm":
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
//	alert( row );
	var sheetObj1 = sheetObjects[1];
	var formObj   = document.form;

	formObj.acctCtrl.value = sheetObj.CellValue(row, "acct_grp_ctrl_flg"); //acct->acct_grp_ctrl_flg로 변경

	if(formObj.acctCtrl.value!="Y"){
		formObj.chkACCTCTRL.checked = false;
		divChkACCTCTRL.style.display = "none";
	}else{
		formObj.chkACCTCTRL.checked = true;
		divChkACCTCTRL.style.display = "";
	}
		
	if(formObj.allPol.checked){
		formObj.all_pol.value = "Y";
	}else{
		formObj.all_pol.value = "N";
	}
	sheet1_selRow =  row;
//	sheetObj1.ShowDebugMsg = true;
	sheetObj1.Enable = false;
	sheetObj1.ReDraw = false;
	sheetObj1.RemoveAll();
	
	// control option이 edit 상태이면 cancel 상태로 변경
	cancelControlOption(sheetObj);
	setLod_volValue(sheetObj.CellValue(row, "lod_vol"));
	// 상단 sheet의 현재 선택된 row를 지정
	setSelectetRow(sheetObj, row);
	
	// 하단 sheet를 검색하기 위한 검색 조건 생성
	var param = makeDetailParam(sheetObj, row);
	param = param + "&fcast="+fcastType + "&order=" + order+ "&all_pol=" + formObj.all_pol.value + "&type=" + formObj.type.value;
	
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
	
	var weekXml = sheetObj1.GetSearchXml("ESM_SPC_0042GS2.do", paramWeekly);
	sheetObj1.LoadSearchXml(weekXml);
	
	headWeek = ComGetEtcData(weekXml, "headerWeek");

	
	sheetObj1.Enable = false;
	sheetObj1.ReDraw = false;
	sheetObj1.RemoveAll();
	
	initSheet(sheetObj1, 2);
	
//	sheetObj1.DoSearch4Post("ESM_SPC_0042GS2.do", param);
	
	// Weekly CMB의 주차를 표현하기 위해 2번째 시트 초기화
	selRlane = sheetObj.CellValue(row, "rlane_cd");
	var sXml = sheetObj1.GetSearchXml("ESM_SPC_0042GS2.do", param);
	var saqExistFlg = "";
	
	if (sXml != ""){
		sheetObj1.LoadSearchXml(sXml);
		headWeek = ComGetEtcData(sXml, "headerWeek");
		saqExistFlg = ComGetEtcData(sXml, "saqExistFlg");

		formObj.pol_dbl_port_chk.value = ComGetEtcData(sXml, "DBL_CALL_CHK"); // double calling 확인
	
//		if( SHT2_SAVEAFTER ){
//			setTotal = setInterval( function(){ getSheet2Total() } , 2000);
//		}
	}

/*	intra 구간도 alloc confirm 가능하도록 처리
	if(sheetObj.CellValue(row, "TRADE")=="IAS" || sheetObj.CellValue(row, "TRADE")=="IES" || sheetObj.CellValue(row, "TRADE")=="IMS"){
		ComBtnDisable("btng_aloc_confirm");
	}else {
			if(saqExistFlg=="N"){
				//btn enable
				ComBtnEnable("btng_aloc_confirm");		
			}else{
				//btn disable
				ComBtnDisable("btng_aloc_confirm");
			}
	}
*/	
	if(saqExistFlg=="N"){
		//btn enable
		ComBtnEnable("btng_aloc_confirm");		
	}else{
		//btn disable
		ComBtnDisable("btng_aloc_confirm");
	}
	
	
	setVVDValue(sheetObj.CellValue(row, "VVD"));
	setWeekValue(sheetObj.CellValue(row, "WEEK"));
	setLod_volValue(sheetObj.CellValue(row, "lod_vol"));
	// 검색 결과에 따라 control option을 체크 해준다.
	checkControlOption();
	// data selection 항목의 IOC 구분 관련 check box 체크
	checkSelectionOption(sheetObj1, formObj.acctCtrl.value);
	// trade 종류에 따라 상단 sheet의 OCN/IPC 선택 display
	hiddenMasterCols(sheetObj, formObj, sheetObj.CellValue(row, "TRADE").substring(0, 1));
	// control option에 따라 syncTarget에 대한 항목의 Type/Size별 컬럼 display 설정
	hiddenSelectionField(sheetObj1);
	// data selection에 따른 row hidden 처리
	controlRowFilter(sheetObj1);
	checkPortcontrolTree(sheetObj1)
	//CNTR Movement op,oc,vl
//	hiddenCntrMovementCols(sheetObj1, document.form);
	//Forecast Total TEU, Alloc TEU, Booking Total TEU 컬럼 색 칠하기
	//컬러 다시 확인
	if(formObj.chkTYP_ALL.checked){
		for(var i=sheetObj1.HeaderRows; i<sheetObj1.HeaderRows+sheetObj1.RowCount; i++){
			var cellColor = sheetObj1.CellBackColor(i, sheetObj1.SaveNameCol("fcast_ttl_teu_qty"));
			if(cellColor==sheetObj1.RGBColor(255,255,255) || cellColor==0){
				sheetObj1.CellBackColor(i, sheetObj1.SaveNameCol("fcast_ttl_teu_qty")) = sheetObj1.RGBColor(164, 250, 139);
				sheetObj1.CellBackColor(i, sheetObj1.SaveNameCol("usd_bkg_ttl_qty")) = sheetObj1.RGBColor(164, 250, 139);
			}
		}
	} else if( formObj.chkTYP_BKG.checked ) {
		for(var i=sheetObj1.HeaderRows; i<sheetObj1.HeaderRows+sheetObj1.RowCount; i++){
			var cellColor = sheetObj1.CellBackColor(i, sheetObj1.SaveNameCol("usd_bkg_ttl_qty"));
			if(cellColor==sheetObj1.RGBColor(255,255,255) || cellColor==0){
				sheetObj1.CellBackColor(i, sheetObj1.SaveNameCol("usd_bkg_ttl_qty")) = sheetObj1.RGBColor(164, 250, 139);
			}
		}
	}
	// 하단 sheet 아래의 버튼 enable
	enableButtons(true);
	
	// 0057 에서 호출시 적용
	if (formObj.type.value == 'Y') {
		btn_save.parentNode.parentNode.parentNode.parentNode.style.display = "none";			// Save 버튼 숨김
		btn_retrieve.parentNode.parentNode.parentNode.parentNode.style.display = "none";
		btn_new.parentNode.parentNode.parentNode.parentNode.style.display = "none";
		btng_aloc_confirm.parentNode.parentNode.parentNode.parentNode.style.display = "none";	// Alloc Confirm 버튼 숨김
		btng_accum.parentNode.parentNode.parentNode.parentNode.style.display = "none";			// Accum. Guide 버튼 숨김
		btng_cust_grp.parentNode.parentNode.parentNode.parentNode.style.display = "none";		// Status by Customer Group 버튼 숨김
		btng_copy.parentNode.parentNode.parentNode.parentNode.style.display = "none";			// Alloc Copy&Paste 버튼 숨김
//		btng_temp.parentNode.parentNode.parentNode.parentNode.style.display = "none";			// Temp. Input버튼 숨김
		btng_skd.parentNode.parentNode.parentNode.parentNode.style.display = "none";			// SKD Inquiry 버튼 숨김
		btng_bsa.parentNode.parentNode.parentNode.parentNode.style.display = "none";			// BSA Mgmt. 버튼 숨김
		controlOptionButton1.style.display = "none";	// Edit 버튼 숨김
		sheetObj1.Editable = false;						// Sheet Edit 불가
	}
	
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

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
			case IBSEARCH:      //조회
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
				break;
			
			case IBSAVE:        //저장
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
				return true;
				break;
			
			case IBINSERT:      // 입력
				break;
			
			case IBDOWNEXCEL:        //엑셀 다운로드
				break;
			
			case IBLOADEXCEL:        //엑셀 업로드
				break;
		}
	}
	return true;
}

function trade_OnChange(comObj,value,text ){
	if(value == "") return;
	
	//sub_trade의 초기화
	comObjects[1].Index2 = 0;
	//lane의 초기화
	comObjects[2].Index2 = 0;
	
	var formObj = document.form;
	SpcSearchOptionSubTradeCombo("subtrade", "N", "N", true, value);
}

function checkPortcontrolTree(sheetObj){
	var formObj = document.form;
	var sts1    = formObj.chkOfc.checked;
	var sts2    = formObj.chkPol.checked;
	var sts3    = formObj.chkPod.checked;
	var sts4    = formObj.chkDest.checked;
	
	if((sts1 == true)&& (sts2 == true) && (sts3 == true)){
		sheetObj.ColHidden("spc_ctrl_aloc_rmk")     = true;
		sheetObj.ColHidden("spc_ctrl_aloc_pol_rmk") = true;
		sheetObj.colhidden("spc_ctrl_aloc_pod_rmk") = false;
	}
	
	if((sts1 == true) && (sts2 == false) &&(sts3 == false) &&(sts4 == false)){
		sheetObj.colhidden("spc_ctrl_aloc_rmk")     = false;
		sheetObj.ColHidden("spc_ctrl_aloc_pol_rmk") = true;
		sheetObj.ColHidden("spc_ctrl_aloc_pod_rmk") = true;
		
		for(var idx =0; idx<=sheetObj.RowCount; idx++) {
			if(    sheetObj.cellValue(idx, "sub_trd_cd")!= 'IA'
				&& (sheetObj.cellValue(idx, "ioc_cd") == 'IPC' || sheetObj.cellVAlue(idx, "ioc_cd") == 'T/S')){
				
				sheetObj.cellValue2(idx, "spc_ctrl_aloc_rmk") = sheetObj.cellValue(idx, "spc_ctrl_aloc_pod_rmk");
				sheetObj.cellValue2(idx, "ibflag")="";
			}
		}
	}
	
	if((sts1 == true) && (sts2 == true) &&(sts3 == false)){
		sheetObj.colhidden("spc_ctrl_aloc_pol_rmk") = false;
		sheetObj.ColHidden("spc_ctrl_aloc_rmk")     = true;
		sheetObj.ColHidden("spc_ctrl_aloc_pod_rmk") = true;
		
		for(var idx =0; idx<=sheetObj.RowCount; idx++) {
			if(    sheetObj.cellValue(idx, "sub_trd_cd")!= 'IA'
				&& (sheetObj.cellValue(idx, "ioc_cd") == 'IPC' || sheetObj.cellVAlue(idx, "ioc_cd") == 'T/S')){
				
				sheetObj.cellValue2(idx, "spc_ctrl_aloc_pol_rmk") = sheetObj.cellValue(idx, "spc_ctrl_aloc_pod_rmk");
				sheetObj.cellValue2(idx, "ibflag")="";
			}
		}
	}
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
	
	// 선택된 Sub Trade에 해당하는 Lane 정보만 가져오도록 함.
	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);
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
	 *  ComChkObjValid => CoFormControl.js)
	 */
	ComChkObjValid(formObj.fm_load);
}

// trade 종류에 따라 상단 sheet의 OCN/IPC 선택 display
function hiddenMasterCols(sheetObj, formObj, trade){
	var checked = formObj.chkWT.checked || trade == "INIT";
	for(var i = 0 ; checked && i < weightCols.length ; i++){
		sheetObj.ColHidden(weightCols[i]) = !checked;
	}
	
	checked = formObj.chkOCN.checked || trade == "INIT";
	for(var j = 0 ;  j < ocnCols.length ; j++){
		sheetObj.ColHidden(ocnCols[j]) = !checked;
	}
	
	checked = formObj.chkIPC.checked || trade == "INIT";
	for(var k = 0 ;  k < ipcCols.length ; k++){
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

function sheet2_OnDblClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	var rhq     = "";
	var param   = "";
	var sheet1  = sheetObjects[0];
	var sheet2  = sheetObjects[1];
	var sUrl    = "/hanjin/ESM_SPC_0048.do";
	
	if(selRlane == "WAFIE"){
		if(colName == "sls_area_cd"){
			rhq = (sheetObj.CellValue(row, col)).trim();
			
			if(rhq == "HAMRU" || rhq == "NYCRA"){
				param = "?f_cmd="    + SEARCHLIST
				      + "&trade="    + sheet1.CellValue(sheet1_selRow, "TRADE")
				      + "&subtrade=" + sheet1.CellValue(sheet1_selRow, "STRADE")
				      + "&lane="     + sheet1.CellValue(sheet1_selRow, "rlane_cd")
				      + "&bound="    + sheet1.CellValue(sheet1_selRow, "dir_cd")
				      + "&year="     + sheet1.CellValue(sheet1_selRow, "WEEK").substring(0, 4)
				      + "&week="     + sheet1.CellValue(sheet1_selRow, "WEEK").substring(4)
				      + "&vvd="      + sheet1.CellValue(sheet1_selRow, "VVD");
				
				ComOpenWindowCenter(sUrl+param, "WAF Allocation", "600", "600", true);
			}
		}
	}
	
	//Booking(TTL) TOtal TEU 물량이 있을시
	if(colName == "usd_bkg_ttl_qty"||colName == "vgm_vol"){
		sUrl = "/hanjin/ESM_SPC_0049.do";
		var cnt = eval(sheetObj.CellValue(row, col));
		var ctrt_no = sheet2.CellValue(row, "account_cd");
		
		if( cnt > 0 ){// && ComTrim(sheet2.CellValue(row, "sls_ofc_cd")) != "TTL"){
			param = "?f_cmd="		+ SEARCHLIST
			      + "&trade="		+ sheet2.CellValue(row, "trd_cd")
			      + "&subtrade="	+ sheet2.CellValue(row, "sub_trd_cd")
			      + "&lane="		+ sheet1.CellValue(sheet1_selRow, "rlane_cd")
			      + "&bound="		+ sheet1.CellValue(sheet1_selRow, "dir_cd")
			      + "&year="		+ sheet1.CellValue(sheet1_selRow, "WEEK").substring(0, 4)
			      + "&week="		+ sheet1.CellValue(sheet1_selRow, "WEEK").substring(4)
			      + "&vvd="			+ sheet1.CellValue(sheet1_selRow, "VVD")
			      + "&ioc_cd="		+ sheet2.CellValue(row, "ioc_cd")
			      + "&sls_area_cd="	+ (ComTrim(sheet2.CellValue(row, "sls_area_cd"))==""?document.form.office.value:ComTrim(sheet2.CellValue(row, "sls_area_cd")))
			      + "&sls_ofc_cd="	+ sheet2.CellValue(row, "sls_ofc_cd")
			      + "&pol_cd="		+ sheet2.CellValue(row, "pol_cd")
			      + "&pod_cd="		+ sheet2.CellValue(row, "pod_cd")
			      + "&usa_bkg_mod_cd="		+ sheet2.CellValue(row, "us_mod")
			      + "&cust_ctrl="	+ ComTrim(sheet2.CellValue(row, "cust_ctrl_cd"));
			      
			// Account에 계약이 오는 경우 COA popup에 해당 값 setting
			if (ctrt_no.length == 9){
				param = param + "&sc_no=" + ctrt_no;
			} else if (ctrt_no.length == 10){
				param = param + "&rfa_no="+ ctrt_no;
			} 
			if( document.getElementById("chkIPI").checked ){
			      param +=  "&usa_bkg_mod_cd="	+ sheet2.CellValue(row, "us_mod");
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
		
		window.showModalDialog("ESM_SPC_0032.do?"+param, null, "dialogHeight:650px;dialogWidth:970px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;maximize:yes;");
	}
	
	if(colName == "guide" && ComTrim(sheetObj.CellValue(row, col)) != "" && ComTrim(sheetObj.CellValue(row, "sls_ofc_cd")) != "TTL" && ComTrim(sheetObj.CellValue(row, "sls_rhq_cd"))!=""){
		var param = "year="         + document.getElementById("idTxtWeek").value.substring(0, 4)
	 	          + "&week="        + document.getElementById("idTxtWeek").value.substring(4)
	 	          + "&duration="    + "1" 
	 	          + "&trade="       + sheetObj.CellValue(row, "trd_cd")
	 	          + "&sub_trade="   + sheetObj.CellValue(row, "sub_trd_cd")
	 	          + "&rlane_cd="    + sheetObj.CellValue(row, "rlane_cd")
	 	          + "&rhq="         + sheetObj.CellValue(row, "sls_rhq_cd")
	 	          + "&rgn_cd="      + sheetObj.CellValue(row, "sls_ofc_cd")
	 	          + "&src=0042";
	 	
	 	ComOpenWindow("ESM_SPC_0021.do?" + param, 'daily forecast status',"height=650,width=1024,status=0,resizable=yes");
	}
	
	//Compulsory firm 화면으로 이동, orgin, pol_cd, pod_cd 를 동반하여 넘김.
	if( colName == "bs_teu" ) {
		var val = sheetObj.CellValue( row, colName );
		if( val != "0" ){
			sUrl = "/hanjin/ESM_SPC_0116.do";
			var ofc = sheetObj.CellValue( row , "sls_ofc_cd" );
//			if( ofc == "" )
//				ofc = sheetObj.CellValue( row, "sls_ofc_cd" ) ;
			if( ofc.indexOf("TTL")>0)
				ofc = "";
			var param = "origin=" + document.form.office.value //sheetObj.CellValue( row, "sls_ofc_cd" ) 
			    + "&trade="		+ sheetObj.CellValue(row, "trd_cd")
			    + "&rlane_cd="		+ sheetObj.CellValue(row, "rlane_cd")
				+ "&pol_cd=" + sheetObj.CellValue( row , "pol_cd" )
				+ "&pod_cd=" + sheetObj.CellValue( row , "pod_cd" )
				+ "&del_cd=" + sheetObj.CellValue( row , "del_cd" )
				+ "&cust_ctrl_cd=" + sheetObj.CellValue( row , "cust_ctrl_cd" )
				+ "&ofc_vw=" + ofc
				+ "&ioc_cd="		+ sheet2.CellValue(row, "ioc_cd")
				+ "&usa_bkg_mod_cd="		+ sheet2.CellValue(row, "us_mod")
				+ "&acct_cd="		+ sheet2.CellValue(row, "account_cd")
				+ "&vvd_no=" + document.getElementById("idTxtVVD").value;
			ComOpenWindow( sUrl + "?" + param, 'SB BKG Firm', "height=720px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
		}		
	}
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

/**
 * Accum. Guide Performance 팝업 호출(ESM_SPC_0108)
 */
function accumGuidePfmc() {
	var formObj = document.form;
	var sheet1  = sheetObjects[0];
	
	var param = "year="             + sheet1.CellValue(sheet1_selRow, "WEEK").substring(0, 4)
	param = param + "&week="        + sheet1.CellValue(sheet1_selRow, "WEEK").substring(4)
	param = param + "&trade="       + sheet1.CellValue(sheet1_selRow, "TRADE");
	param = param + "&rhqCd="       + formObj.office.value;
	
	ComOpenWindow("ESM_SPC_0108.do?" + param, "Accumulated Guide PFMC", "height=550,width=800,status=0");
}

/**
 * Yield Group 팝업 호출(ESM_SPC_0094)
 */
function yieldGrpPopup() {
	var formObj = document.form;
	var sheet1  = sheetObjects[0];
	
	var param = "yrwk="   + sheet1.CellValue(sheet1_selRow, "WEEK");
	param = param + "&trd_cd=" + sheet1.CellValue(sheet1_selRow, "TRADE");
	
	ComOpenWindow("ESM_SPC_0094.do?" + param, "Yield Group", "height=300,width=450,status=0");
}

function changeAcctCtrl(){
	var sheetObj = sheetObjects[1];
	var formObj = document.form;
	if(sheetObj.SearchRows==0){
		return;
	}
	if(formObj.acctCtrl.value=="N"){
		return;
	}
	if(formObj.chkACCTCTRL.checked){
		var pol = formObj.chkPol.checked;
		var pod = formObj.chkPod.checked;
		var dest = formObj.chkDest.checked;
		var level = -1;
		if(pol&&pod){
			level = -1;
		}else if(pol){
			level = 2;
		}else if(pod){
			level = 3;
		}else if(dest){
			level = 4;
		}else{
			level = 1;
		}
		sheetObj.ShowTreeLevel(level);
	}else{
		sheetObj.ShowTreeLevel(0);
	}
//	var col = "cust_ctrl_cd";
//	for(var row=sheetObj.HeaderRows; row<sheetObj.HeaderRows+sheetObj.RowCount; row++){
//		var status = sheetObj.RowStatus(row);
//		if(formObj.chkACCTCTRL.checked){
//			sheetObj.ColHidden(col)       = false;
//			sheetObj.RowExpanded(row)     = true;
//			sheetObj.CellValue2(row, col) = "1";
//			sheetObj.RowStatus(row)       = status;
//		}else{
//			sheetObj.ColHidden(col)       = true;
//			sheetObj.RowExpanded(row)     = false;
//			sheetObj.CellValue2(row, col) = "0";
//			sheetObj.RowStatus(row)       = status;
//		}
//	}
}

function chkAllPol(){
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var formObj = document.form;
	
	if(sheetObj2.SearchRows>0){
		sheet1_OnDblClick(sheetObj1, sheet1_selRow, 1);
	}
}
/*
 * 0057 에서 호출시 적용
 * Sheet 확대
 */
function toggleSheetSizeMax(){
	var obj = document.form.maxi[1];
	var status = "M";
	var sheetId = obj.sheetId;
	var type = obj.type;
	if(sheetId == undefined || type == undefined) return;
	var sheetObj = document.getElementById(sheetId);
	var isSheet = (sheetObj.tagName == "OBJECT");
	var curRow = 0;
	if(isSheet){
		curRow = sheetObj.SelectRow;
	}
	var area = obj;
	while((area.tagName != "TABLE" || area.className != "search") && area != document){
		area = area.parentElement;
	}
	if(area.parentElement.tagName == "DIV"){
		area = area.parentElement;
	}
	var main = area.parentElement;
	var tables = main.children;
	var titleArea = tables[1];
	var posTop = 0;
	for(var i = 0 ; i < tables.length ; i++){
		if(tables[i].className == "title" || tables[i].className == "button"){
			posTop = posTop + tables[i].offsetHeight;
			continue;
		}
		if(tables[i] == area){
			continue;
		}		
		if(status == "M"){
			tables[i].orgDisplay = tables[i].style.display;
			tables[i].style.display = "none";
		}
		else{
			tables[i].style.display = tables[i].orgDisplay;
		}
	}
	if(status == "M"){
		var etcHeight = area.offsetHeight - sheetObj.offsetHeight;
		var copyArea = main.parentElement.parentElement.parentElement;
		var sizeHeight = document.body.clientHeight - posTop - etcHeight - 20;
		area.sheetHeight = sheetObj.style.height;
		sheetObj.style.height = sizeHeight;
		obj.maxStatus = "M";
		obj.src = "/hanjin/img/bu_prev01.gif";
	}
	else{
		sheetObj.style.height = area.sheetHeight;
		obj.maxStatus = "N";
		obj.src = "/hanjin/img/bu_next01.gif";
	}	currSheet = sheetObj;
		
	if(isSheet){
		setTimeout("scrollToCurRow()", 1);
	}
	
	obj.parentNode.style.display = "none";	// Sheet 확대/축소 버튼 숨김
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
function changValueStandby(sheetObj, row, col, dif , ctrl_lvl, yield, oit , wdif ){
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
				
				if( nowRowVal == 6 && sheetObj.CellValue( rowNum , "del_cd" ) == "OTHERS") { //현재 row가 dest고 여러개 있는 경우 OTHERS 라면
					sheetObj.CellValue2( rowNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rowNum , "bs_teu" ) ) + dif; //값 변경
					sheetObj.CellValue2( rowNum , "bs_wgt" ) = parseInt( sheetObj.CellValue( rowNum , "bs_wgt" ) ) + wdif; //값 변경
					
				} else if( nowRowVal < 6 ) { //row의 lvl 이 증가 중이면서( 감소된적 없음, 감소되었을때는 위 쪽 if 문에서 걸러줌)
					sheetObj.CellValue2( rowNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rowNum , "bs_teu" ) ) + dif;
					sheetObj.CellValue2( rowNum , "bs_wgt" ) = parseInt( sheetObj.CellValue( rowNum , "bs_wgt" ) ) + wdif;
					
				} else if( nowRowVal == 6 && sheetObj.CellValue( rowNum , "del_cd" ) != "OTHERS")
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
//	var fRow = sheetObj.FindText( "rowOfc" , endRow );
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
