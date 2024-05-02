/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0054.js
 *@FileTitle : LRS SKD Creation(CCA)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.05.20
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.07.08 유혁
 * 1.0 Creation
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
 * @class LRS Creation : LRS Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0054() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var dataStartRow = 6;
var dataSetCnt = 4;

var bkgVVDs = new Array();
var virVVDs = new Array();
var bkgVirVVDs = new Array();
var nonBkgVVDs = new Array();
var vvdDeleteReason = "";

var HeadCol1 = ""; // SKD_DIR_CD
var HeadCol2 = ""; // VPS_PORT_CD
var HeadCol3 = ""; // ETB_DY_CD/ETD_DY_CD
var HeadCol4 = ""; // ETB_TM_HRMNT/ETD_TM_HRMNT
var HeadCol5 = ""; // P/F CLPT_SEQ
var HeadCol6 = ""; // YARD_CD

var backObj = null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btns_search1":
			var sUrl = "/hanjin/VOP_VSK_0202.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 428, 470, "sheet1_vsl_slan_cd:vsl_slan_cd", "0,0", true);
			
			if(!rVal){
				break;
			}
			
			// 팝업에서 선택한 값이 기존에 있던 값과 다른경우 재조회해야함.
			if(formObj.vsl_slan_cd.value!="" &&
					formObj.tmp_vsl_slan_cd.value!=formObj.vsl_slan_cd.value){
				
				var vsl_slan_cd = formObj.vsl_slan_cd.value;
				initPage();
				formObj.tmp_vsl_slan_cd.value = vsl_slan_cd;
				formObj.vsl_slan_cd.value = vsl_slan_cd;
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}
			break;

		case "btns_calendar1":
			var cal = new ComCalendar();
			cal.select(formObj.end_date, 'yyyy-MM-dd');
			break;

		case "btn_New":
			initPage();
			break;

		case "btn_Save":
			var check = valid(sheetObject1, formObj, "SAVE");
			if(check){
				// VOP_VSK_0249 화면을 호출. Booking VVD 삭제 사유를 등록한다.
				if(bkgVVDs.length + virVVDs.length + bkgVirVVDs.length > 0){
					var sUrl = "/hanjin/VOP_VSK_0249.do?tp=1";
					
					for(var i=0; i<bkgVVDs.length; i++){
						sUrl = sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + bkgVVDs[i].vslSlanCd + "&bkg_vvd=" + bkgVVDs[i].vslCd + bkgVVDs[i].skdVoyNo + bkgVVDs[i].skdDirCd;
					}
					for(var i=0; i<virVVDs.length; i++){
						sUrl = sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + virVVDs[i].vslSlanCd + "&bkg_vvd=" + virVVDs[i].vslCd + virVVDs[i].skdVoyNo + virVVDs[i].skdDirCd;
					}
					for(var i=0; i<bkgVirVVDs.length; i++){
						sUrl = sUrl + "&turn_voy=&turn_dir=&his_vvd=&lane_vvd=" + bkgVirVVDs[i].vslSlanCd + "&bkg_vvd=" + bkgVirVVDs[i].vslCd + bkgVirVVDs[i].skdVoyNo + bkgVirVVDs[i].skdDirCd;
					}
					
					var rVal = ComOpenPopupWithTarget(sUrl, 524, 342, "", "0,0", true);
					
					if(rVal){
						vvdDeleteReason = rVal;
					}else{
						// VOP_VSK_0249 화면을 그냥 Close 한 경우
						vvdDeleteReason = null;
					}
				}
				if(vvdDeleteReason!=null){
					doActionIBSheet(sheetObject2,document.form,IBSAVE);
				}
			}
			break;

		case "btn_Simulation":
			formObj.op_type.value = "btn_Simulation";
			var check = valid(sheetObject1, formObj, "SIMULATION");
			
			bkgVVDs = new Array();
			virVVDs = new Array();
			bkgVirVVDs = new Array();
			nonBkgVVDs = new Array();
			
			if(check){
				
				var vessels = new Array();
				var sheetObj = sheetObjects[0];
				
				if(!checkPeriod(sheetObj, formObj)){
					ComShowCodeMessage("VSK00105", "2 year");
					return false;
				}
				
				// vessel code 별로 voyage 를 체크한다.
				for(var i=1,k=0; i<sheetObj.LastCol; i++){
					if(sheetObj.CellValue(2, i)!=""){
						var obj = new Object();
						obj.startDate = sheetObj.CellValue(1, i);
						obj.vslCd = sheetObj.CellValue(2, i);
						obj.skdVoyNo = sheetObj.CellValue(3, i);
						
						obj.voyNo = "";
						obj.skdDirCd1 = "";
						obj.skdDirCd2 = "";
						obj.duration = "";
						
						vessels[k++] = obj;
					}
				}
				
				for(var i=0; i<vessels.length; i++){
					
					//var sUrl = "/hanjin/VOP_VSK_0211.do?vsl_cd=" + vessels[i].vsl_cd + "&skd_voy_no=" + vessels[i].skd_voy_no + "&start_eta=";
					var sUrl = "/hanjin/VOP_VSK_0211.do";
					sUrl = sUrl + "?vsl_cd=" + vessels[i].vslCd 
								   + "&skd_voy_no=" + vessels[i].skdVoyNo 
								   + "&start_date=" + vessels[i].startDate
								   + "&end_date=" + formObj.end_date.value
								   + "&vsl_cnt=" + formObj.initVslCnt.value
								   + "&voy_no_type=0" // NORMAL 
								   + "&skd_dir_cd_1=" + formObj.skdDirCd1.value
								   + "&skd_dir_cd_2=" + formObj.skdDirCd2.value 
								   + "&duration=" + formObj.svc_dur_dys.value;
					
					var rVal = ComOpenPopupWithTarget(sUrl, 506, 527, "", "0,0", true);
					
					if(rVal){
						bkgVVDs = bkgVVDs.concat(rVal.bkgVVDs);
						virVVDs = virVVDs.concat(rVal.virVVDs);
						bkgVirVVDs = bkgVirVVDs.concat(rVal.bkgVirVVDs);
						nonBkgVVDs = nonBkgVVDs.concat(rVal.nonBkgVVDs);
						continue;
					}else{
						return false;
					}
					
				}
				
				doActionIBSheet(sheetObject2,formObj,SEARCH02);	
			}
				
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		
	}
	// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	
	initControl();

	// 현재년도설정
	var today = new Date();
	var nowDate = ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
	with (formObj) {
		end_date.value = ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
		vsl_slan_cd.focus();
	}

	setColHidden(sheetObjects[0], parseInt(formObj.vsl_cnt.value));
	sheetObjects[0].ViewRows = 4;

}

/** 
 * 페이지를 초기화한다.
 */
function initPage() {
	var formObj = document.form;
	sheetObjects[2].RemoveAll();

    HeadCol1 = "";
    HeadCol2 = "";
    HeadCol3 = "";
    HeadCol4 = "";
    HeadCol5 = "";
    HeadCol6 = "";
    
    sheetObjects[0].Redraw = false;
    sheetObjects[0].Reset();
	ComConfigSheet (sheetObjects[0]);
	initSheet(sheetObjects[0],1);
	ComEndConfigSheet(sheetObjects[0]);
	sheetObjects[0].Redraw = true;
    
	sheetObjects[1].Redraw = false;
	sheetObjects[1].Reset();
	ComConfigSheet (sheetObjects[1]);
	initSheet(sheetObjects[1],2);
	ComEndConfigSheet(sheetObjects[1]);
	sheetObjects[1].Redraw = true;
	
	setColHidden(sheetObjects[0],0);
    sheetObjects[0].ViewRows = 4;
    
    formObj.vsl_slan_cd.value = "";
	formObj.tmp_vsl_slan_cd.value = "";
	formObj.brth_itval_dys.value = "";
	formObj.vsl_cnt.value = "";
	formObj.initVslCnt.value = "";
	formObj.pf_svc_tp_cd.value = "";
	formObj.slan_stnd_flg.value = "Y";

	// 현재년도설정
//	var today = new Date();
	var nowDate = ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
	with (formObj) {
//		start_date.value = ComGetMaskedValue(today.getFullYear() + "0101","ymd");
//		end_date.value = ComGetMaskedValue(today.getFullYear() + "0331", "ymd");
		end_date.value = ComGetMaskedValue(getQuarterEndDate(nowDate), "ymd");
		vsl_slan_cd.focus();
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;
	var formObj = document.form;
	
	switch (sheetId) {
	case 'sheet1': // sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 영문입력모드
			style.imeMode = "inactive";

			var headCount = parseInt(formObj.vsl_cnt.value);
			// 높이 설정
			style.height = 90;
			// 전체 너비 설정
			
			ScrollBar = 0;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 4, 4, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(21, 0, 1, false);

			// 해더기능([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize],
			// [RowMove],[Head3D])
			InitHeadMode(false, false, false, false, false, false);

			var HeadTitle1 = "||||||||||||||||||||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			
			ImageList(0) = "/hanjin/img/btns_calendar.gif";
			ImageList(1) = "/hanjin/img/btns_search.gif";

			for ( var i = 0; i < 4; i++) {
				InitDataProperty(i, 0, dtData, 90, daCenter, false, "left",
						false, "", dfNone, 0, false, false);

				// for(var j = 1 ; j<=formObj.vsl_cnt.value ; j++){
				for ( var j = 1; j < 20; j++) {
					if (i == 0) {
						InitDataProperty(i, j, dtPopupEditFormat, 95, daCenter, false,
								"Vsl_" + j, false, "", dfDateYmd, 0, true, true); // Start Date
//						InitDataProperty(i, j, dtData, 70, daLeft, false,
//								"Vsl_" + j, false, "", dfDateYmd, 0, true, true); // Start Date
						PopupButtonImage(i, j) = 0;
					} else if (i == 1) {
						InitDataProperty(i, j, dtData, 95, daLeft, false,
								"Vsl_" + j, false, "", dfNone, 0, true, true, 4); // Vessel Code
						InitDataValid(i, j, vtEngUpOther, "0123456789");
					} else if (i == 2) {
						InitDataProperty(i, j, dtData, 95, daLeft, false,
								"Vsl_" + j, false, "", dfNone, 0, true, true, 4); // Voy No
						InitDataValid(i, j, vtNumericOnly);
						
//						VVD 체크로직 사용할때 
//						InitDataProperty(i, j, dtPopupEdit, 95, daLeft, false,
//								"Vsl_" + j, false, "", dfNone, 0, true, true, 4); // Voy No
//						InitDataValid(i, j, vtNumericOnly);
//						PopupButtonImage(i, j) = 1;
						
					} else if (i == 3) {
						InitDataProperty(i, j, dtPopupEdit, 95, daLeft, false,
								"Vsl_" + j, false, "", dfNone, 0, true, true, 4); // P/F SKD Type
						InitDataValid(i, j, vtEngUpOther, "0123456789");
						PopupButtonImage(i, j) = 1;
					}
				}
				InitDataProperty(i, j, dtHiddenStatus, 0, daCenter, false,"ibflag");
			}
			
            ShowButtonImage = 2;

			// dfDateYmd

			CountPosition = 0;
			// 해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
			InitHeadColumn("left",
					"Start Date|Vessel Code|Start Voy. No.|P/F SKD Type|Out",
					daLeft);
			// setColHidden(headCount);

			WaitImageVisible = false;
		}
		break;

	case 'sheet2': // sheet2 init
		
		with (sheetObj) {
			// 높이 설정
			style.height = 345;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			UnEditableColor = RgbColor(255, 255, 255);

            //행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
            // dataSetCnt = 1 일때, VPS_ET 또는 SKIP
            // dataSetCnt = 2 일때, INIT_ET
            // dataSetCnt = 3 일때, PF_ET
            // dataSetCnt = 4 일때, SKIP에 해당하는 VPS_ET 백업 또는 각종 상태코드(A 등)
            InitRowInfo(dataStartRow, dataSetCnt, 4, 100);

//			var HeadTitle1 = "|Port|Port|Port" + HeadCol1 + "|Remark||";
			var HeadTitle1 = "| | | " + HeadCol1 + "|Remark(s)";
//			var HeadTitle2 = "|Vessel|Voyage|Direction" + HeadCol2 + "|Remark(s)";
//			var HeadTitle3 = "|Vessel|Voyage|Direction" + HeadCol3 + "|Remark(s)";
//			var HeadTitle4 = "|Vessel|Voyage|Direction" + HeadCol4 + "|Remark(s)";
			var HeadTitle2 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol2+"|Remark(s)";
			var HeadTitle3 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol3+"|Remark(s)";
			var HeadTitle4 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol4+"|Remark(s)";
			var HeadTitle5 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol5+"|Remark(s)";
			var HeadTitle6 = "|VSL\nCD|VOY.\nNO.|DIR"+HeadCol6+"|Remark(s)";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);
            InitHeadRow(2, HeadTitle3, false);
            InitHeadRow(3, HeadTitle4, false);
            InitHeadRow(4, HeadTitle5, false, true);
            InitHeadRow(5, HeadTitle6, true);
			
			var portNum = parseInt(ComCountHeadTitle(HeadCol1) - 1) / 2;

			for ( var i = 0; i < dataSetCnt; i++) {
				cnt = 0;

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(i, cnt++, dtHiddenStatus, 30, daCenter, true,
						"ibflag");
				// InitDataProperty(i, cnt++ , dtStatus, 30, daCenter, true,
				// "Status");
				InitDataProperty(i, cnt++, dtData, 40, daCenter, true, "VVD1",
						false, "", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 40, daCenter, true, "VVD2",
						false, "", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 40, daCenter, true, "VVD3",
						false, "", dfNone, 0, false, false);
				
				for ( var j = 0; j < portNum; j++) {
					if (i == 0) {
						InitDataProperty(i, cnt++, dtData, 33, daLeft, false,
								"ETB" + j, false, "", dfNone, 0, false, false);
						InitDataProperty(i, cnt++, dtData, 33, daLeft, false,
								"ETD" + j, false, "", dfNone, 0, false, false);
					} else {
						InitDataProperty(i, cnt++, dtData, 33, daLeft, false,
								"ETB" + j, false, "", dfNone, 0, false, false);
						InitDataProperty(i, cnt++, dtData, 33, daLeft, false,
								"ETD" + j, false, "", dfNone, 0, false, false);
					}
				}
				InitDataProperty(i, cnt++, dtData, 200, daLeft, true, "skd_rmk",
						false, "", dfNone, 0, false, false);
			}

			CountPosition = 0;
			
			RowHeight(1) = 20;
			RowHeight(2) = 20;
			RowHeight(3) = 20;
			RowHeight(4) = 20;
			RowHeight(5) = 20;
			
//			// 헤더의 Port와 Yard 컬럼을 2개씩 merge 한다.
//			var etbStartIdx = 4;
//			for(var i=0; i<portNum*2; i=i+2){
//				
//				SetMergeCell(1, etbStartIdx+i, 1, 2); // Port Row
//				SetMergeCell(5, etbStartIdx+i, 1, 2); // Yard Row
//			}
			
			MultiSelection = false;
			

		}
		break;
		
		case 'sheet3' : 	// P/F SKD 정보
			with(sheetObj) {
				
				tabIndex = -1;
				
				// 높이 설정
				style.height = 0;
				
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				UnEditableColor = RgbColor(255, 255, 255);

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
				
				var HeadTitle = "|vsl_slan_cd|skd_dir_cd|port_cd|yd_cd|clpt_seq|call_yd_ind_seq|port_rotn_seq|turn_port_flg|turn_port_ind_cd|etb_dy_cd|etb_dy_no|etb_tm_hrmnt|etd_dy_cd|etd_dy_no|etd_tm_hrmnt|mnvr_in_hrs|mnvr_out_hrs"
				var headCount = ComCountHeadTitle(HeadTitle);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, false, false, false);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(i, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(i, cnt++, dtData, 30, daCenter,	true, "ibflag");
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "vsl_slan_cd"			,false,"", dfNone, 0, true, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "skd_dir_cd"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "port_cd"				,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "yd_cd"					,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "clpt_seq"				,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "call_yd_ind_seq"	,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "port_rotn_seq"		,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "turn_port_flg"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "turn_port_ind_cd"	,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etb_dy_cd"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etb_dy_no"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etb_tm_hrmnt"		,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etd_dy_cd"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etd_dy_no"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "etd_tm_hrmnt"		,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "mnvr_in_hrs"			,false,"", dfNone, 0, false, false);
				InitDataProperty(i, cnt++, dtData, 60, daCenter, 	true, "mnvr_out_hrs"		,false,"", dfNone, 0, false, false);
			}
			break;
	} // end of switch
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCH;
		if ( sheetObj.id == "sheet1"){
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0054GS.do" , sParam);
			
			if(ComGetEtcData(sXml, "vsl_slan_nm")){
				sheetObj.ScrollBar = 1;
				formObj.vsl_cnt.value = ComGetEtcData(sXml, "vsl_count");
				formObj.initVslCnt.value = ComGetEtcData(sXml, "vsl_count");
				formObj.pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
				formObj.brth_itval_dys.value = ComGetEtcData(sXml, "brth_itval_dys");
				formObj.svc_dur_dys.value = ComGetEtcData(sXml, "svc_dur_dys");
				
				// Lane Code를 변경했을때 가져오는 정보는 Stand Type이다.
				formObj.stnd_pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
			
				sheetObj.LoadSearchXml(sXml);
				
				sheetObjects[2].LoadSearchXml(sXml);
				
				formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
				setColHidden(sheetObjects[0],parseInt(formObj.vsl_cnt.value));
				formObj.end_date.focus();
			}else{
				sheetObjects[2].LoadSearchXml(sXml);
				initPage();
				formObj.tmp_vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
			}
						
		}
		break;

	case IBSAVE: // 저장
		formObj.f_cmd.value = MULTI;
		if (validateForm(sheetObj, formObj, sAction)){
			var sParam = FormQueryString(formObj)+ "&HeadTitle1=" + HeadCol1 + "&HeadTitle2=" + HeadCol2 + "&HeadTitle3=" + HeadCol3 + "&HeadTitle4=" + HeadCol4 + "&HeadTitle5=" + HeadCol5 + "&HeadTitle6=" + HeadCol6;
			sParam = sParam + vvdDeleteReason;
			var param = "";
			
			for(var i=0; i<bkgVVDs.length; i++){
				param = param + "&bkg_ibflag=I";
				param = param + "&bkg_vsl_slan_cd=" + bkgVVDs[i].vslSlanCd;
				param = param + "&bkg_vsl_cd=" + bkgVVDs[i].vslCd;
				param = param + "&bkg_skd_voy_no=" + bkgVVDs[i].skdVoyNo;
				param = param + "&bkg_skd_dir_cd=" + bkgVVDs[i].skdDirCd;
				param = param + "&bkg_turn_skd_voy_no=" + bkgVVDs[i].turnSkdVoyNo;
				param = param + "&bkg_turn_skd_dir_cd=" + bkgVVDs[i].turnSkdDirCd;
			}
			
			for(var i=0; i<virVVDs.length; i++){
				param = param + "&vir_ibflag=I";
				param = param + "&vir_vsl_slan_cd=" + virVVDs[i].vslSlanCd;
				param = param + "&vir_vsl_cd=" + virVVDs[i].vslCd;
				param = param + "&vir_skd_voy_no=" + virVVDs[i].skdVoyNo;
				param = param + "&vir_skd_dir_cd=" + virVVDs[i].skdDirCd;
				param = param + "&vir_turn_skd_voy_no=" + virVVDs[i].turnSkdVoyNo;
				param = param + "&vir_turn_skd_dir_cd=" + virVVDs[i].turnSkdDirCd;
			}
			
			for(var i=0; i<bkgVirVVDs.length; i++){
				param = param + "&bkg_vir_ibflag=I";
				param = param + "&bkg_vir_vsl_slan_cd=" + bkgVirVVDs[i].vslSlanCd;
				param = param + "&bkg_vir_vsl_cd=" + bkgVirVVDs[i].vslCd;
				param = param + "&bkg_vir_skd_voy_no=" + bkgVirVVDs[i].skdVoyNo;
				param = param + "&bkg_vir_skd_dir_cd=" + bkgVirVVDs[i].skdDirCd;
				param = param + "&bkg_vir_turn_skd_voy_no=" + bkgVirVVDs[i].turnSkdVoyNo;
				param = param + "&bkg_vir_turn_skd_dir_cd=" + bkgVirVVDs[i].turnSkdDirCd;
			}
			
			for(var i=0; i<nonBkgVVDs.length; i++){
				param = param + "&non_bkg_ibflag=I";
				param = param + "&non_bkg_vsl_slan_cd=" + nonBkgVVDs[i].vslSlanCd;
				param = param + "&non_bkg_vsl_cd=" + nonBkgVVDs[i].vslCd;
				param = param + "&non_bkg_skd_voy_no=" + nonBkgVVDs[i].skdVoyNo;
				param = param + "&non_bkg_skd_dir_cd=" + nonBkgVVDs[i].skdDirCd;
				param = param + "&non_bkg_turn_skd_voy_no=" + nonBkgVVDs[i].turnSkdVoyNo;
				param = param + "&non_bkg_turn_skd_dir_cd=" + nonBkgVVDs[i].turnSkdDirCd;
			}
			
			// 스케쥴 sheet는 항상 입력상태로 유지해준다.
			for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
//				sheetObj.CellValue2(i, "ibflag") = "I";
				sheetObj.RowStatus(i) = "I";
			}
			
			var sParamSheet2 = ComGetSaveString(sheetObjects[1]);
			if(sParamSheet2 != ""){
				sParam = sParam + "&" + sParamSheet2;
			}
			
			var sParamSheet3 = ComGetSaveString(sheetObjects[2]);
			if(sParamSheet3 != ""){
				sParam = sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
			}
			
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0054GS.do" , sParam + param);
			sheetObj.LoadSaveXml(sXml);
			
			if(!VskGetErrorXml(sXml)){
				// 스케쥴이 정상적으로 생성 되었으면 작업했던 스케쥴을 모두 삭제
				initPage();
				//ComBtnDisable("btn_Save");
			}

		}
		break;

	case SEARCH02: // simulation
		formObj.f_cmd.value = SEARCH02;
		
		var sParam = FormQueryString(formObj)+ "&" + ComGetSaveString(sheetObjects[0]);
		var sParamSheet3 = ComGetSaveString(sheetObjects[2]);
		if(sParamSheet3 != ""){
			sParam = sParam + "&" + ComSetPrifix(sParamSheet3, "sheet3_");
		}
		
		sheetObj.WaitImageVisible = true;
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0010_1GS.do" , sParam, "", true);
		
		HeadCol1 = ComGetEtcData(sXml, "HeadTitle1");
        HeadCol2 = ComGetEtcData(sXml, "HeadTitle2");
        HeadCol3 = ComGetEtcData(sXml, "HeadTitle3");
        HeadCol4 = ComGetEtcData(sXml, "HeadTitle4");
        HeadCol5 = ComGetEtcData(sXml, "HeadTitle5");
        HeadCol6 = ComGetEtcData(sXml, "HeadTitle6");
        
        if(!HeadCol1){
        	HeadCol1 = "";
        	HeadCol2 = "";
        	HeadCol3 = "";
        	HeadCol4 = "";
        	HeadCol5 = "";
        	HeadCol6 = "";
        }

        sheetObj.Reset();
        ComConfigSheet (sheetObj);
        initSheet(sheetObj,2);
        ComEndConfigSheet(sheetObj);
		sheetObj.LoadSearchXml(sXml);
		break;
	
	case SEARCH07:	// search vessel code
		//formObj.f_cmd.value = SEARCH;
		formObj.f_cmd.value = COMMAND16;
		var sParam = FormQueryString(formObj);
		//var sXml = sheetObj.GetSearchXml("VSK_GLOGS.do?op_=0219", sParam);
		var sXml = sheetObj.getSearchXml("VSK_GLOGS.do", sParam);
		var vsl_eng_nm = ComGetEtcData(sXml, "vsl_eng_nm");
		return vsl_eng_nm;
//		var fdr_div_cd = ComGetEtcData(sXml, "fdr_div_cd");
//		if(fdr_div_cd=="T"){
//			return fdr_div_cd;
//		}else{
//			return vsl_eng_nm;
//		}
		break;
		
	case SEARCH08:	// search P/F Type Code
		formObj.slan_stnd_flg.value = "N";
		formObj.f_cmd.value = SEARCH;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0054GS.do" , sParam);
		
		if(ComGetEtcData(sXml, "pf_svc_tp_cd")){
			//formObj.vsl_cnt.value = ComGetEtcData(sXml, "vsl_count");
			formObj.pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
			formObj.brth_itval_dys.value = ComGetEtcData(sXml, "brth_itval_dys");
			formObj.svc_dur_dys.value = ComGetEtcData(sXml, "svc_dur_dys");
		
			//sheetObj.LoadSearchXml(sXml);
			
			sheetObjects[2].LoadSearchXml(sXml);
			
			formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
			setColHidden(sheetObjects[0],parseInt(formObj.vsl_cnt.value));
			
//			formObj.start_date.focus();
			
			return true;
		}else{
			sheetObjects[2].LoadSearchXml(sXml);
			initPage();
			return false;
		}
		
		break;
		
	case SEARCH09: // P/F Type을 바꿨을때 발생하는 부분

		formObj.f_cmd.value = SEARCH;
		if(formObj.stnd_pf_svc_tp_cd.value==formObj.pf_svc_tp_cd.value){
			formObj.slan_stnd_flg.value = 'Y';
		}else{
			formObj.slan_stnd_flg.value = 'N';
		}
		
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0054GS.do" , sParam);
		
		if(VskGetErrorXml(sXml)){
			initPage();
			sheetObj.LoadSearchXml(sXml);
			formObj.tmp_vsl_slan_cd.value = "";
			formObj.vsl_slan_cd.value = "";
			//ComChkObjValid(formObj.start_date);
			ComChkObjValid(formObj.end_date);
			formObj.vsl_slan_cd.focus();
			
		}else{
			//formObj.vsl_cnt.value = ComGetEtcData(sXml, "vsl_count");
			formObj.pf_svc_tp_cd.value = ComGetEtcData(sXml, "pf_svc_tp_cd");
			formObj.brth_itval_dys.value = ComGetEtcData(sXml, "brth_itval_dys");
			formObj.svc_dur_dys.value = ComGetEtcData(sXml, "svc_dur_dys");
		
			sheetObj.LoadSearchXml(sXml);
			
			sheetObjects[2].LoadSearchXml(sXml);
			
			formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
			setColHidden(sheetObjects[0],parseInt(formObj.vsl_cnt.value));
			
//			formObj.start_date.focus();
		}
						
		break;
		
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function valid(sheetObj, formObj, action) {
	
	switch(action){
		case "SIMULATION":
			// P/F Duration이 소숫점으로 되어 있으면 오류
			if(formObj.svc_dur_dys.value.indexOf(".")>-1){
				ComShowCodeMessage("VSK00096", "Duration");
				return false;
			}
			break;
	}

	if(formObj.vsl_slan_cd.value==""){
		ComShowCodeMessage('VSK00027', 'Lane CD');
		formObj.vsl_slan_cd.focus();
		return false;
	}else if(formObj.vsl_cnt.value=="" || formObj.vsl_cnt.value=="0"){
		ComShowCodeMessage('VSK00027', 'Vessel No');
		formObj.vsl_cnt.focus();
		return false;
	}
	
	var check = true;
	for(var i=1; i<=4; i++){
		for(var k=1; k<=formObj.vsl_cnt.value; k++){
			if(sheetObj.CellValue(i, "Vsl_" + k)==''){
				check=false;
				if(i==1){
					ComShowCodeMessage('VSK00027', 'Start Date');
				}else if(i==2){
					ComShowCodeMessage('VSK00027', 'Vessel Code');
				}else if(i==3){
					ComShowCodeMessage('VSK00027', 'Start Voy No');
				}else if(i==4){
					ComShowCodeMessage('VSK00027', 'P/F SKD Type');
				}
				break;
			}
		}
		if(!check){
			break;
		}
	}
	return check;
}

/**
 * VSL No. 에 따른 컬럼 히든처리를 위한 함수
 */
function setColHidden(sheetObj, viewCols) {
	if (!viewCols) {
		viewCols = 0;
	}

	// 전체 false
	for ( var i = 1; i <= sheetObj.LastCol; i++) {
		sheetObj.ColHidden(i) = true;
	}

	// 필요한부분만 true
	for ( var i = 1; i <= viewCols; i++) {
		sheetObj.ColHidden(i) = false;
	}

	// 시트 넓이 조정
	var width = 95*(viewCols)+95;
	if(viewCols<=9){
		sheetObj.SheetWidth = width;
		sheetObj.ViewRows = 4;
	}else{
		sheetObj.SheetWidth = 95*(9)+95;
		sheetObj.ViewRows = 5;
	}
}

//이벤트 등록
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('beforedeactivate', "obj_beforedeactivate", formObj);
	
	axon_event.addListenerForm('blur', "obj_deactivate", formObj);
	axon_event.addListenerForm('focus', "obj_activate", formObj);
	
	axon_event.addListenerForm('change', 'obj_change', formObj); 			// - 변경데이타 처리
	axon_event.addListenerForm('keypress', 'eng_keypress', formObj); 	// - 영문자 입력하기
	axon_event.addListenerForm('keypress', 'num_keypress', formObj); 	// - 숫자 입력하기
	axon_event.addListenerForm('keypress', 'enter_keypress', formObj); 	// - Enter키 처리
	axon_event.addListenerForm('keyup', "VskKeyFocus", formObj); 		// - 자동포커스 처리
}

/**
 * 변경이벤트 처리
 */
function obj_change() {
	var formObj = document.form;
	switch (event.srcElement.name) {
	}
}

/**
 * 영문자 입력하기
 */
function eng_keypress() {
	var formObj = document.form;
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
		case "vsl_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * 숫자 입력하기
 */
function num_keypress() {
	var formObj = document.form;
	switch (event.srcElement.name) {
		case "start_date":
		case "end_date":
		case "vsl_cnt":
		case "brth_itval_dys":
			ComKeyOnlyNumber();
			break;
	}
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}

/**
 * HTML Control의 포커스를 잃었을때 발생하는 이벤트를 처리한다.
 */
function obj_deactivate() {
	var formObj = document.form;
	var obj = event.srcElement;
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
			if(obj.value=="" || ComChkLen(obj.value, 3)!=2){
				break;
			}
			if(formObj.tmp_vsl_slan_cd.value != obj.value){
				sheetObj = sheetObjects[1];
				formObj.pf_svc_tp_cd.value='';
//				rowCount = sheetObj.Rows;
				sheetObj.RemoveAll();
					
				if(sheetObj.LastCol > 6){
					for(var i=sheetObj.SaveNameCol("VVD3")+1; i<sheetObj.SaveNameCol("skd_rmk"); i++){
						sheetObj.ColHidden(i) = true;
					}
				}
					
				sheetObj = sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		break;
	}

}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 */
function obj_beforedeactivate() {
	var formObj = document.form;
	var obj = event.srcElement;
	switch (event.srcElement.name) {
		case "start_date":
		case "end_date":
			ComChkObjValid(event.srcElement);
		break;
		
		case "vsl_cnt":
			
			if(backObj==null || backObj==event.srcElement.value){
				return;
			}
			
			var vsl_cnt = formObj.vsl_cnt.value;
			var brth_itval_dys = formObj.brth_itval_dys.value;
			
			if(formObj.vsl_slan_cd.value==""){
        		ComShowCodeMessage('VSK00021', "Lane Code");
        		formObj.vsl_cnt.value="";
        		formObj.vsl_slan_cd.focus();
        		return false;
        	}
			
			if(vsl_cnt>=20){
				ComShowCodeMessage('VSK00077');
				formObj.vsl_cnt.value=backObj;
				formObj.vsl_cnt.focus();
				return false;
			}
			
			if(vsl_cnt!="1" && !checkFrequency()){
				formObj.vsl_cnt.value = backObj;
				formObj.vsl_cnt.focus();
				return false;
			}
			
			changeVessel("vsl_cnt");
			formObj.initVslCnt.value = vsl_cnt;
			
		break;
		
		case "brth_itval_dys":
			
			if(backObj==null || backObj==event.srcElement.value){
				return;
			}
			
			var vsl_cnt = formObj.vsl_cnt.value;
			var brth_itval_dys = formObj.brth_itval_dys.value;
			
			if(formObj.vsl_slan_cd.value==""){
				ComShowCodeMessage('VSK00021', "Lane Code");
        		formObj.brth_itval_dys.value="";
        		formObj.vsl_slan_cd.focus();
        		return false;
        	}
			
			if(vsl_cnt!="1" && !checkFrequency()){
				formObj.brth_itval_dys.value = backObj;
				formObj.brth_itval_dys.focus();
				return false;
			}
			
			changeVessel("brth_itval_dys");
        	
		break;
	}
}

function changeVessel(srcElement){
	var formObj = document.form;
	var sheetObj;
	var vsl_cnt = formObj.vsl_cnt.value;
	var brth_itval_dys = formObj.brth_itval_dys.value;
	
	HeadCol1 = "";
	HeadCol2 = "";
	HeadCol3 = "";
	HeadCol4 = "";
	HeadCol5 = "";
	HeadCol6 = "";
	
	sheetObj = sheetObjects[1];
	sheetObj.Reset();
    ComConfigSheet (sheetObj);
    initSheet(sheetObj,2);
    ComEndConfigSheet(sheetObj);

    sheetObj = sheetObjects[0];
	
    switch(srcElement){
		case "vsl_cnt":
			sheetObj.RemoveAll();
		break;
		case "brth_itval_dys":
		break;
	}
	
	//var start_date = formObj.start_date.value;
	var start_date = ComGetNowInfo();
    setColHidden(sheetObj, vsl_cnt);
    
    for(var i=1; i <= vsl_cnt; i++){
   		sheetObj.CellValue2(1,"Vsl_" + i) = ComGetDateAdd(start_date, "D", (i-1)*brth_itval_dys);
   		sheetObj.CellValue2(4,"Vsl_" + i) = formObj.pf_svc_tp_cd.value;
   		
   		sheetObj.CellAlign(1, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(2, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(3, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(4, "Vsl_" + i) = daCenter;
   		
    }
    
}

/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_activate() {
	// 마스크구분자 없애기
	switch (event.srcElement.name) {
		case "start_date":
		case "end_date":
			ComClearSeparator(event.srcElement);
			break;
		case "vsl_cnt":
		case "brth_itval_dys":
			backObj = event.srcElement.value;
			break;
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	var formObj = document.form;
	if(Row==1){
	    //if (sheetObj.ColSaveName(col) != "start_date") return;
	    var cal = new ComCalendarGrid("myCal");
	    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}else if(Row==3){
		// TODO
		// Voyage Check 팝업화면
		
		
		
		
	}else if(Row==4){
		var sUrl = "/hanjin/VOP_VSK_0212.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
		 ComOpenPopupWithTarget(sUrl, 306, 408, "sheet1_pf_svc_tp_cd:pf_svc_tp_cd", "0,0", true);
		 if(formObj.pf_svc_tp_cd.value!=""){
			 for(var i=1; i<sheetObj.LastCol; i++){
				sheetObj.CellValue2(4, i) = formObj.pf_svc_tp_cd.value; 
			}
			// 바뀐 P/F type 으로 P/F 다시 조회해야함
			doActionIBSheet(sheetObj, formObj, SEARCH09);
		 }
		 
		HeadCol1 = "";
		HeadCol2 = "";
		HeadCol3 = "";
		HeadCol4 = "";
		HeadCol5 = "";
		HeadCol6 = "";
		initSheet(sheetObjects[1], 2);
		formObj.vsl_slan_cd.focus();
	}
}

function sheet2_OnDblClick(sheetObj, Row, Col){
	if(Row<4) return;
	// Remark 입력을 위한 창을 띄운다.
	if(Col==sheetObj.LastCol){
		var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + sheetObj.CellValue(Row, Col);
		var rVal = ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
		if(rVal || rVal==''){
			sheetObj.CellValue(Row, Col) = rVal;
		}
	}
}

function sheet1_OnSearchEnd(sheetObj,ErrMsg)
{
    var formObj = document.form;
    //var start_date = formObj.start_date.value;
    var start_date = ComGetNowInfo();
    var brth_itval_dys = formObj.brth_itval_dys.value;
    
    for(var i=1; i <= formObj.vsl_cnt.value; i++){
   		sheetObj.CellValue2(1,"Vsl_" + i) = ComGetDateAdd(start_date, "D", (i-1)*brth_itval_dys);
   		sheetObj.CellValue2(4,"Vsl_" + i) = formObj.pf_svc_tp_cd.value;
   		
   		sheetObj.CellAlign(1, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(2, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(3, "Vsl_" + i) = daCenter;
   		sheetObj.CellAlign(4, "Vsl_" + i) = daCenter;
   		
    }
    
    if(ErrMsg != ""){
    	formObj.vsl_slan_cd.value = '';
    	formObj.vsl_slan_cd.select();
    }	
	
}

function sheet1_OnChange(sheetObj , Row, Col, Value){
	if(!Value || Value==""){
		return false;
	}
	var formObj = document.form;
	
	if(Row==2){	// Vessel Code 수정한 경우
		formObj.vsl_cd.value = Value;
    	var vsl_eng_nm = doActionIBSheet(sheetObj, formObj, SEARCH07);
    	if(!vsl_eng_nm){ // undefined
    		ComShowCodeMessage('VSK00021', Value);
    		sheetObj.SelectCell(Row, Col);
    		sheetObj.CellValue2(Row, Col) = "";
    	}else{
    		sheetObj.ToolTipText(Row, Col) = vsl_eng_nm;
//    		 Vessel의 타입(Trunk/Feeder) 고려하지 않음
//    		if(vsl_eng_nm=="T"){
//    			ComShowCodeMessage('VSK00053', Value);
//        		sheetObj.SelectCell(Row, Col);
//        		sheetObj.CellValue2(Row, Col) = "";
//    		}else{
//    			sheetObj.ToolTipText(Row, Col) = vsl_eng_nm;
//    		}
    	}	
	}else if(Row==3){ // Voyage No 수정한 경우
		if(parseInt(Value)==0){
			Value = "1";
		}
		sheetObj.CellValue2(Row, Col) = Value.lpad(4, "0");
	}else if(Row==4){ // P/F Skd Type
		formObj.pf_svc_tp_cd.value = Value;
		if(doActionIBSheet(sheetObj, formObj, SEARCH08)){
			for(var i=1; i<sheetObj.LastCol; i++){
				sheetObj.CellValue2(4, i) = Value;	
			}
		}else{
//			for(var i=1; i<sheetObj.LastCol; i++){
//				sheetObj.CellValue2(4, i) = "";
//			}
			initPage();
		}
		HeadCol1 = "";
		HeadCol2 = "";
		HeadCol3 = "";
		HeadCol4 = "";
		HeadCol5 = "";
		HeadCol6 = "";
		initSheet(sheetObjects[1], 2);
		formObj.vsl_slan_cd.focus();
	}
	
}

function sheet1_OnDblClick(sheetObj, Row, Col){
	var formObj = document.form;
	if(Row==4){	// PF Skd Type Code 수정
		var sUrl = "/hanjin/VOP_VSK_0212.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
		 ComOpenPopupWithTarget(sUrl, 306, 408, "sheet1_pf_svc_tp_cd:pf_svc_tp_cd", "0,0", true);
		 if(formObj.pf_svc_tp_cd.value!=""){
			 for(var i=1; i<sheetObj.LastCol; i++){
				sheetObj.CellValue2(4, i) = formObj.pf_svc_tp_cd.value; 
			}
			// 바뀐 P/F type 으로 P/F 다시 조회해야함
			doActionIBSheet(sheetObj, formObj, SEARCH09);
		 }
		 
		HeadCol1 = "";
		HeadCol2 = "";
		HeadCol3 = "";
		HeadCol4 = "";
		HeadCol5 = "";
		HeadCol6 = "";
		initSheet(sheetObjects[1], 2);
		formObj.vsl_slan_cd.focus();
		 
	}else if(Row==1){
		sheetObj.SelectCell(Row, Col);
	}
}

function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj = document.form;
//	Feeder는 Delay 체크하지 않음
//	if(NewRow==2){
//		if(sheetObj.CellValue(NewRow, NewCol)==""){
//			var sUrl = "/hanjin/VOP_VSK_0217.do";
//			var rVal = ComOpenPopupWithTarget(sUrl, 256, 171, "", "0,0", true);
//			var delay = null;
//			if(rVal){
//				delay = rVal;
//			}else{
//				delay = 0;
//			}
//			sheetObj.SelectCell(NewRow, NewCol, true, "");
//		}
//	}
}

/**
 * 주어진 날짜의 분기말 일자를 반환한다.
 * 1분기 : 년도 + "0331" 반환
 * 2분기 : 년도 + "0631" 반환
 * 3분기 : 년도 + "0930" 반환
 * 4분기 : 년도 + "1231" 반환
 * 
 * @param date
 * @return
 */
function getQuarterEndDate(date){
	
	var year = date.substring(0, 4);
	var month_date = date.substring(4, 8);
	
	if(month_date <= "0331"){
		return year + "0331";
	}else if(month_date <= "0630"){
		return year + "0630";
	}else if(month_date <= "0930"){
		return year + "0930";
	}else{
		return year + "1231";
	}
}

function checkFrequency(){
	var formObj = document.form;
	if(formObj.brth_itval_dys.value=="" || formObj.brth_itval_dys.value=="0"){
		ComShowCodeMessage('VSK00017');
		return false;
	}
	return true;
}

function sheet3_OnSearchEnd(sheetObj,ErrMsg)
{
	var formObj = document.form;
	
    if(ErrMsg != ""){
    	return;
    }
    
    if(sheetObj.RowCount > 0){
    	formObj.skdDirCd1.value = sheetObj.CellValue(1, "skd_dir_cd");
    	formObj.skdDirCd2.value = sheetObj.CellValue(sheetObj.RowCount, "skd_dir_cd");
    }
}

function checkPeriod(sheetObj, formObj){
	var startDate = ComReplaceStr(sheetObj.CellValue(1, "Vsl_1"), "-", "");
	var endDate = ComReplaceStr(formObj.end_date.value, "-", "");
	var tmpDate = ComGetDateAdd(startDate, "Y", 2);// 2년 이내의 기간만 허용
	if(ComChkPeriod(endDate, tmpDate)==1){
		return true;
	}else{
		return false;
	}
}