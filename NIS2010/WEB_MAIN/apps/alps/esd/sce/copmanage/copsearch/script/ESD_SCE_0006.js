function ESD_SCE_0006() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
}

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObj = sheetObjects[0];
	// documentation tab 주석 처리
	// var sheetObj1 = sheetObjects[1];
	var sheetObj2 = sheetObjects[1];
	var sheetObj3 = sheetObjects[2];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		formObj.clickBtnNm.value = srcName;
		formObj.cntr_no.value = formObj.cntr_no_v.value;
		switch (srcName) {

		case "btn_retrieve":
			if (validateForm(null, formObj, IBSEARCH)) {
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				// documentation tab 주석 처리
				// doActionIBSheet(sheetObj1,formObj,IBSEARCH);
				doActionIBSheet(sheetObj2, formObj, IBSEARCH);
				doActionIBSheet(sheetObj3, formObj, IBSEARCH);
			}
			break;
			
		case "btn_so_cnddt_creation":
			
				var soStsFlg = false;
				
				if( sheetObj2.CheckedRows("ibflag") < 1 ) {
					ComShowMessage(ComGetMsg('COM12176'));
					return false;
				} else {
					
					if(sheetObj2.CheckedRows("ibflag") > 0) {
						var iCheckRow = sheetObj2.FindCheckedRow("ibflag");
						//가져온 행을 배열로 반든다.
						var arrRow = iCheckRow.split("|");
			
						for (idx=0; idx<arrRow.length-1; idx++) {
							if(!(sheetObj2.CellValue(arrRow[idx], "trsp_so_sts_cd") == "D" || sheetObj2.CellValue(arrRow[idx], "trsp_so_sts_cd") == "N" )) {
								ComShowMessage(ComGetMsg('SCE90063'));
								soStsFlg = true;
								break;	
							}
						}
					}					
					
					if(!soStsFlg && confirm("Are you sure you want to proceed?") ) {
							formObj.f_cmd.value = SEARCHLIST05;
	//						formObj.target = "_self";
							sheetObj2.DoSave("ESD_SCE_0006GS.do", SceFrmQryString(formObj), "ibflag", false, true);
							doActionIBSheet(sheetObj2, formObj, IBSEARCH);					
					}
				}
				break;

		case "btn_new":
			sheetObj.RemoveAll();
			formObj.reset();
			formObj.cntr_no.value = "";
			formObj.cntr_no_v.value = "";
			formObj.cop_mst_bkg.value = "";
			comboObjects[0].RemoveAll();
			// for(i=0; i<formObj.bkg_no_tmp.options.length; i++){
			// formObj.bkg_no_tmp.options[i]=null;
			// }
			sheetObj.RemoveAll();
			// documentation tab 주석 처리
			// sheetObj1.RemoveAll();
			sheetObj2.RemoveAll();
			sheetObj3.RemoveAll();

			break;

		case "btn_copchange":

			if (!ComIsEmpty(formObj.cop_no)) {
				// COP Inqiry 화면과 validation 맞추기 위해 추가
				if (formObj.cop_sub_sts_cd.value == "R"
						&& formObj.cop_sts_cd.value == "F") {

				} else {
					if (formObj.cop_sts_cd.value == "X") {
						ComShowMessage(ComGetMsg('SCE90047'));
						return;
					} else if (ComIsEmpty(formObj.act_cd.value)) {
						ComShowMessage(ComGetMsg('SCE90012'));
						return;
					}
				}

				openESD_SCE_0053(formObj);
			} else {
				ComShowMessage(ComGetMsg('COM12114', 'COP No'));
			}
			break;

		case "t1btng_save":
			doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;

		case "btn_manualclose":
			/*
			 * 유저의 요청으로 20070927에 막음 if(validateForm(null,formObj,IBSEARCH)){
			 * if(confirm(ComGetMsg('SCE90038'))) {
			 * doActionIBSheet(sheetObj,formObj,IBSEARCH);
			 * doActionIBSheet(sheetObj1,formObj,IBSEARCH);
			 * doActionIBSheet(sheetObj2,formObj,IBSEARCH); } }
			 */
			break;
		// minestar - cop_history start
		case "btn_history":
			if (!ComIsEmpty(formObj.cop_no)) {
				// window.open
				// ("ESD_SCE_0071.do?pgmNo=ESD_SCE_0071&cop_no="+formObj.cop_no.value
				// , "list",
				// "scrollbars=no,fullscreen=no,width=800,height=600,resizable");
				openESD_SCE_0071(formObj);
			}
			break;
		// minestar - cop_history end
		case "btn_bkginfo":
			if (validateForm(null, formObj, IBSEARCH)) {
				setCopValues();
				// var newWin = window.open("","bkg_info_win",
				// "toolbar=0,location=0,statusbar=yes,directories=0,status=0,menubar=0,resizable=0,scrollbars=0,width=810,height=425,left=100,top=100");
				var paramUrl = "pgmNo=ESD_SCE_0915&cop_no="
						+ formObj.cop_no.value + "&bkg_no="
						+ formObj.bkg_no.value;
				var newWin = window
						.showModalDialog(
								"ESD_SCE_0915.do?" + paramUrl,
								"bkg_info_win",
								"scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:415px");
				// formObj.action = "ESD_SCE_0915.do" ;
				// formObj.target = "bkg_info_win" ;
				// formObj.submit() ;
				// newWin.focus() ;
			}
			break;

		case "btn_clm":
			goESD_SCE_0044(sheetObj);
			break;

		case "btn_downexcel":
			doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e);
		}
	}
}

// function openESD009Screen(openStr){
// window.open (openStr, "list2", "
// scrollbars=no,fullscreen=no,width=1020,height=550");

// }
function openESD009Screen(url, copNo, boundName, iscompled, isnodchg, nodcd,
		isfrmchg, frmcd, bkg_no, cop_sts_cd) {
	// window.open(openStr, "list2",
	// "scrollbars=no,fullscreen=no,width=1020,height=560");
	newForm = "<form name='form1' method='post'>";
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0009'>";
	newForm += "  <input type='hidden' name='cop_no' value='" + copNo + "'>";
	newForm += "  <input type='hidden' name='bound_name'  value='" + boundName
			+ "'>";
	newForm += "  <input type='hidden' name='iscompled'  value='" + iscompled
			+ "'>";
	newForm += "  <input type='hidden' name='isnodchg'  value='" + isnodchg
			+ "'>";
	newForm += "  <input type='hidden' name='nodcd'  value='" + nodcd + "'>";
	newForm += "  <input type='hidden' name='isfrmchg'  value='" + isfrmchg
			+ "'>";
	newForm += "  <input type='hidden' name='frmcd'  value='" + frmcd + "'>";
	newForm += "  <input type='hidden' name='bkg_no'  value='" + bkg_no + "'>";
	newForm += "  <input type='hidden' name='cop_sts_cd'  value='" + cop_sts_cd
			+ "'>";
	newForm += "</form>"

	document.all.new_form.innerHTML = newForm;
	// var formObj = document.form1 ;
	var formObj = document.all.new_form.document.form1;
	var paramUrl = "pgmNo=ESD_SCE_0009&cop_no=" + copNo + "&bound_name="
			+ boundName + "&iscompled=" + iscompled + "&isnodchg=" + isnodchg
			+ "&nodcd=" + nodcd + "&isfrmchg=" + isfrmchg + "&frmcd=" + frmcd
			+ "&bkg_no=" + bkg_no + "&cop_sts_cd=" + cop_sts_cd;
	// var newWin = window.open("","cop_manual_change", "width=1020,height=560,"
	// + getCenterXY(1020, 560));
	var newWin = window
			.showModalDialog(
					"ESD_SCE_0009.do?" + paramUrl,
					window,
					"scroll:no;status:no;resizable:yes;help:no;dialogWidth:1020px;dialogHeight:560px");
	// formObj.method = "post";
	// formObj.action = url ;
	// formObj.target = "cop_manual_change" ;
	// formObj.submit() ;

}

function researchScreen() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObj = sheetObjects[0];
	// documentation tab 주석 처리
	// var sheetObj1 = sheetObjects[1];
	var sheetObj2 = sheetObjects[1];
	var sheetObj3 = sheetObjects[2];
	/** **************************************************** */
	var formObj = document.form;

	try {
		// if(validateForm(null,formObj,IBSEARCH)){
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		// documentation tab 주석 처리
		// doActionIBSheet(sheetObj1,formObj,IBSEARCH);
		doActionIBSheet(sheetObj2, formObj, IBSEARCH);
		doActionIBSheet(sheetObj3, formObj, IBSEARCH);
		// } // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
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

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
	if (formObject.bkg_no.value != "") {
		comboObjects[0].Text = formObject.bkg_no.value;
	}

}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // IBSheet1 init
		with (sheetObj) {
			style.height = 310;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(21, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			var HeadTitle = "STS|SEQ|COP DTL SEQ|Activities\nCode|Activity|VVD|Location|Planned\nDate / Time|Planned\nDate / Time|Inland Planned \nDate / Time|Inland Planned \nDate / Time|Estimated\nDate / Time|Estimated\nDate / Time|Actual\nDate / Time|Actual\nDate / Time|Actual Data\nSource|Exception NO|Exception\nType Code";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 툴팁
			var sTipPln = "[COP for Full Route]"
					+ "\nPlanned Date/Time : Date and Time are set for Full Route when BKG is created in reference to P/C";
			var sTipFxPln = "[COP for Inland transportation]"
					+ "\nInland Planned Date/Time : Date and Time are set for Inland Transportation excluding OCN Route."
					+ "\nFor O/B Inland transportation, 'Inland Planned Date/Time' is the same as 'Planned Date/Time'."
					+ "\nFor I/B Inland transportation, 'Inland Planned Date/Time' is set when VD's actual time is created."

			// 데이터속성 [ ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 25, daCenter, false,
					"dt_sts", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtSeq, 45, daCenter, false, "seq",
					false, "", dfNone, 0, false, true);
			// InitDataProperty(0, cnt++ , dtImage, 40, daCenter, false,
			// "cop_expt_sts", false, "", dfNone, 0, false, true);
			// InitDataProperty(0, cnt++ , dtHidden, 0, daCenter, false,
			// "r_cop_grp_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false,
					"cop_dtl_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false,
					"act_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 220, daLeft, false, "act_nm",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "vvd",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "nod_cd",
					false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "pln_date",
					false, "", dfDateYmd, 0, false, true, -1, false, true,
					sTipPln);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pln_time",
					false, "", dfTimeHms, 0, false, true, -1, false, true,
					sTipPln);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false,
					"fx_pln_date", false, "", dfDateYmd, 0, false, true, -1,
					false, true, sTipFxPln);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false,
					"fx_pln_time", false, "", dfTimeHms, 0, false, true, -1,
					false, true, sTipFxPln);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false,
					"estm_date", false, "", dfDateYmd, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"estm_time", false, "", dfTimeHms, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "act_date",
					false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "act_time",
					false, "", dfTimeHms, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false,
					"act_rcv_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false,
					"cop_expt_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false,
					"cop_expt_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false,
					"rail_rcv_coff_fm_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false,
					"act_sts_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false,
					"expt_info", false, "", dfNone, 0, false, true);

			ImageList(0) = "/hanjin/img/alps/ico_b.gif";
			ImageList(1) = "/hanjin/img/alps/ico_g.gif";
			ImageList(2) = "/hanjin/img/alps/ico_r.gif";
			ToolTipOption = "balloon:true; width:600; backcolor:#ffffff; forecolor:#14358B; icon:0;";
			CountPosition = 0;

		}
		break;
	// case 2: //IBSheet2 init
	// with (sheetObj) {
	// //전체 너비 설정
	// style.height = 310 ;
	// SheetWidth = mainTable.clientWidth;
	//
	// //Host정보 설정[필수][HostIp, Port, PagePath]
	// if (location.hostname != "") InitHostInfo(location.hostname,
	// location.port, page_path);
	//
	// //전체Merge 종류 [선택, Default msNone]
	// MergeSheet = msHeaderOnly;
	//
	// //전체Edit 허용 여부 [선택, Default false]
	// Editable = true;
	//
	// //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	// InitRowInfo( 1, 1, 9, 100);
	//
	// //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	// InitColumnInfo(5, 0, 0, true);
	//
	// // 해더에서 처리할 수 있는 각종 기능을 설정한다
	// InitHeadMode(false, true, false, true, false,false)
	//
	// var HeadTitle = "Seq.|Activity|Status|Event Date / Time|Event Date /
	// Time" ;
	//
	// //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	// InitHeadRow(0, HeadTitle, true);
	//
	// //데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
	// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	// InitDataProperty(0, cnt++ , dtSeq, 45, daCenter, false, "", false, "",
	// dfNone, 0, false, false);
	// InitDataProperty(0, cnt++ , dtData, 400, daLeft, false, "act_nm", false,
	// "", dfNone, 0, false, false);
	// InitDataProperty(0, cnt++ , dtImage, 120, daCenter, false, "except",
	// false, "", dfNone, 0, false, false);
	// InitDataProperty(0, cnt++ , dtData, 90, daCenter, false, "occ_date",
	// false, "", dfDateYmd, 0, false, false);
	// InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "occ_time",
	// false, "", dfTimeHm, 0, false, false);
	//            	 	
	// CountPosition = 0;
	//
	// ImageList(0) = "/hanjin/img/alps/ico_w1.gif" ;
	// ImageList(1) = "/hanjin/img/alps/ico_b1.gif" ;
	// }
	// break;
	case 2: // IBSheet3 init
		with (sheetObj) {
			// 전체 너비 설정
			style.height = 310;
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 9, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			// InitColumnInfo(6, 0, 0, true);
			InitColumnInfo(20, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			// var HeadTitle = "Seq.|Activity Group|Service Provider|S/O
			// Status|Planned Cost(USD)|Estimated Cost(USD)" ;
			var HeadTitle = "Seq.|Activity Group|S/O Office|Planned S/P|Actual S/P|S/O Status|S/O Status|W/O No.|W/O Update Date|S/O No.|From - To|S/O Update Date|S/O Update User Name|S/P Contact No.|Internal Remark|Invoice Remark|Special Instruction|cop_no|cost_act_grp_seq|trsp_so_cd";
			// var HeadTitle = "Seq.|Activity Group|S/O Office|Service
			// Provider|S/O Status|S/O No" ;
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtSeq, 45, daCenter, false, "", false,
					"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false,
					"cost_act_grp_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false,
					"ctrl_ofc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false,
					"vndr_abbr_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false,
					"vndr_abbr_nm_act", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false,
					"trsp_so_sts", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++ , dtCheckBox,  20,	daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "wo_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "wo_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "so_num",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 200, daCenter, false, "fm_to",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "so_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "user_nm",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "sp_h_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daLeft, false, "so_rmk1",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daLeft, false, "so_rmk2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daLeft, false, "so_rmk3",
					false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++ , dtHidden, 100, daRight, false, "cop_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++ , dtHidden, 100, daRight, false, "cost_act_grp_seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daLeft, false, "trsp_so_sts_cd", 
					false, "", dfNone, 0, false, false);
			//InitDataProperty(0, cnt++ , dtHidden, 140, daRight, false, "",
			//false, "", dfInteger, 0, false, false);
			// InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight, false, "",
			// false, "", dfInteger, 0, true, true);

			CountPosition = 0;

			
		}
		break;

	case 3: // IBSheet4 init
		with (sheetObj) {
			// 전체 너비 설정
			style.height = 310;
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 9, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			// InitColumnInfo(6, 0, 0, true);
			InitColumnInfo(13, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			// var HeadTitle = "Seq.|Activity Group|Service Provider|S/O
			// Status|Planned Cost(USD)|Estimated Cost(USD)" ;
			var HeadTitle = "Activity|Movement|Location|Planned|Planned|Estimated|Estimated|Actual|Actual|Actual Source|COP||";
			// var HeadTitle = "Seq.|Activity Group|S/O Office|Service
			// Provider|S/O Status|S/O No" ;
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 170, daLeft, false, "act_nm",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "sts_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "nod_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "pln_dt1",
					false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pln_dt2",
					false, "", dfTimeHms, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "estm_dt1",
					false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "estm_dt2",
					false, "", dfTimeHms, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "act_dt1",
					false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "act_dt2",
					false, "", dfTimeHms, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false,
					"edi_msg_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "copyn",
					false, "", dfNone, 0, false, false);
			// InitDataProperty(0, cnt++ , dtHidden, 140, daCenter, false, "",
			// false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 140, daCenter, false,
					"cop_dtl_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 140, daCenter, false,
					"sort_dt", false, "", dfNone, 0, false, false);
			// InitDataProperty(0, cnt++ , dtAutoSum, 150, daRight, false, "",
			// false, "", dfInteger, 0, true, true);
			// InitDataProperty(0, cnt++ , dtAutoSum, 100, daRight, false, "",
			// false, "", dfInteger, 0, true, true);

			CountPosition = 0;

		}
		break;

	}
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "bkg_no_tmp":
		with (comboObj) {
			DropHeight = 260;
			MultiSelect = false;
			MaxSelect = 1;
			UseAutoComplete = true;
			MaxLength = 3;
			IMEMode = 0;
			ValidChar(2, 0);
			SetColWidth("50|200");
		}
		break;
	}
}

function bkg_no_tmp_OnChange(comboObj, code, text) {
	var formObj = document.form;
	setCopValues();
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var formObj = document.form;
	switch (sAction) {

	case IBSEARCH_ASYNC01: // 콤보 조회
		comboObjects[0].RemoveAll();
		formObj.f_cmd.value = SEARCHLIST;
		var sXml = sheetObj.GetSearchXml("ESD_SCE_0006GS.do",
				FormQueryString(formObj));
		ComSceXml2ComboItem(sXml, formObj.bkg_no_tmp, "code", "bkg_no");
		comboObjects[0].InsertItem(0, '');
		break;

	case IBSEARCH: // 조회
		// sheetObj.DoSearch("data_006.htm");
		if (sheetObj.id == "t1sheet1") {

			formObj.f_cmd.value = SEARCHLIST01;
			formObj.target = "_self";
			sheetObj.DoSearch4Post("ESD_SCE_0006GS.do",
					SceFrmQryString(formObj));

			ComEtcDataToForm(formObj, sheetObj); // ETC_DATA 넣어주는 함수.

			// sheetObj.DoSearch("apps/alps/esd/sce/copmanage/jsp/data_006.htm");
			// etcDataToForm(formObj, sheetObj);
			// setCopExptSts(sheetObj);
			changeColor(sheetObj);

		} else if (sheetObj.id == "t2sheet1") {
			formObj.f_cmd.value = SEARCHLIST02;
			formObj.target = "_self";
			sheetObj.DoSearch4Post("ESD_SCE_0006GS.do",
					SceFrmQryString(formObj));
		} else if (sheetObj.id == "t3sheet1") {
			formObj.f_cmd.value = SEARCHLIST03;
			formObj.target = "_self";
			sheetObj.DoSearch4Post("ESD_SCE_0006GS.do",
			SceFrmQryString(formObj));
		} else if (sheetObj.id == "t4sheet1") {
			// sheetObj.ShowDebugMsg = true;
			formObj.f_cmd.value = SEARCHLIST04;
			formObj.target = "_self";
			sheetObj.DoSearch4Post("ESD_SCE_0006GS.do",
					SceFrmQryString(formObj));
		}
		break;

	case IBSAVE: // 저장

		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MODIFY;
			formObj.target = "_self";
			formObj.estm_act_dt.value = sheetObj.CellEditable(1, "estm_date") ? "E"
					: "A";
			sheetObj.doSave("ESD_SCE_0006U.do", SceFrmQryString(formObj));
		}
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.Down2Excel(-1, false, false, true);
		break;

	case IBDOWNEXCEL:
		sheetObj.Down2Excel(-1, false, false, true);
		break;

	}
}

// function contents_cp() 콤보 박스로 인한 삭제
// {
// if (window.event)
// {
//       	
// if(navigator.appName.indexOf("Microsoft")!=-1){
// window.event.returnValue = true;
// window.setTimeout('attach_kinref()', 25);
// }
//
// }
// }
// function attach_kinref()
// {
// if (window.clipboardData) // IE
// {
// // get data from clipboard
// var txt =
// document.form.bkg_no_tmp.options[document.form.bkg_no_tmp.selectedIndex].text;
// // set data to clibboard
// var result = window.clipboardData.setData('Text', txt);
// }
// }

function goESD_SCE_0044(sheetObj) {

	var formObj = document.form;

	if (formObj.cntr_no.value == "") {
		ComShowMessage(ComGetMsg('SCE90018'));
		return;
	}
	var cntrNO = formObj.cntr_no.value;
	var tpszCd = formObj.cntr_tpsz_cd.value;
	newForm = "<form name='form1' method='post'>";
	newForm += "<input type='hidden' name='cntr_no' value='" + cntrNO + "'>";
	newForm += "<input type='hidden' name='tpsz_cd' value='" + tpszCd + "'>";
	newForm += "</form>"

	document.all.new_form.innerHTML = newForm;

	var formObj = document.form1;

	var paramUrl = "cntr_no=" + cntrNO + "&tpsz_cd=" + tpszCd;
	var newWin = window
			.showModalDialog(
					"ESD_SCE_0044.do?" + paramUrl,
					"clm_win",
					"scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:525px");
	// var newWin = window.open("","clm_win", "width=771,height=525," +
	// getCenterXY(755, 500));
	// var newWin = window.open("","clm_win",
	// "width="+screen.width+",height=525," + getCenterXY(screen.width, 500));
	// var newWin = window.open("","clm_win", "width="+800+",height=525," +
	// getCenterXY(screen.width, 500));

	// formObj.action = "ESD_SCE_0044.do" ;
	// formObj.target = "clm_win" ;
	// formObj.submit() ;

	// newWin.focus() ;

}

function getCenterXY(w, h) {

	var height = screen.availHeight;
	var width = screen.availWidth;

	var leftpos = width / 2 - w / 2;
	var toppos = height / 2 - h / 2;
	if (leftpos < 0)
		leftpos = 0;
	if (toppos < 0)
		toppos = 0;

	return "left=" + leftpos + ", top=" + toppos;
}

function changeColor(sheetObj) {
	var rowCnt = sheetObj.RowCount;
	for (i = 0; i < rowCnt; i++) {
		if (sheetObj.CellValue(i, 6) != '') {
			if (i != 0) {
				// sheetObj.RowBackColor(i) = sheetObj.RgbColor(200,245,255);
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(200, 245, 255);
			}
		}
	}

	if (rowCnt > 0) {
		sheetObj.SelectCell(0, 11);
	}
}

/*
 * sheetObj.CellBackColor(i,"r_act_nm") = sheetObj.RgbColor(230,240,240);
 * sheetObj.CellBackColor(i,"r_vvd") = sheetObj.RgbColor(230,240,240);
 * sheetObj.CellBackColor(i,"r_nod_cd") = sheetObj.RgbColor(230,240,240);
 * sheetObj.CellBackColor(i,"r_pln_date") = sheetObj.RgbColor(230,240,240);
 * sheetObj.CellBackColor(i,"r_pln_time") = sheetObj.RgbColor(230,240,240);
 */

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {

	var cnt = 0;

	switch (tabNo) {
	case 1:
		with (tabObj) {

			InsertTab(cnt++, "Transportation", -1);
			// Documentation 주석 처리
			// InsertTab( cnt++, "Documentation" , -1 );
			InsertTab(cnt++, "  TRS S/O Info  ", -1);
			InsertTab(cnt++, "  Actual Information  ", -1);

		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;

}

function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SumText(0, 0) = "";
	sheetObj.SumText(0, 2) = "Total Cost(USD)";
	sheetObj.ColFontColor("so_num") = sheetObj.RgbColor(0, 0, 255);
	sheetObj.ColFontUnderline("so_num") = true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var result = true;

	switch (sAction) {
	case IBSEARCH:
		// if(ComIsEmpty(formObj.cntr_no)){
		// ComShowMessage(ComGetMsg('COM12114', 'CNTR No')) ;
		// formObj.cntr_no.focus() ;
		// return false ;
		// }
		// else if(!ComChkObjValid(formObj.cntr_no, 11)){
		// ComShowMessage(ComGetMsg('SCE90026', 'CNTR No', 11)) ;
		// formObj.cntr_no.focus() ;
		// return false ;
		// }

		if (ComIsEmpty(formObj.cntr_no) && formObj.bkg_no_tmp.text == "") {
			ComShowMessage(ComGetMsg('COM12114', 'CNTR No'));
			// formObj.cntr_no.focus() ;
			return false;
		} else if (!ComIsEmpty(formObj.cntr_no)
				&& formObj.bkg_no_tmp.text == "") {
			ComShowMessage(ComGetMsg('COM12113', 'BKG No'));
			formObj.bkg_no_tmp.focus();
			return false;
		}
		return true;
		break;
	case IBSAVE:

		var updateRows = sheetObj.FindStatusRow("U").split(";");
		var updateCnt = updateRows.length - 1;

		if (updateCnt == 0) {
			ComShowMessage(ComGetMsg('SCE90008', 'CNTR No'));
			result = false;
		} else if (updateCnt > 1) {
			ComShowMessage(ComGetMsg('SCE90009', 'CNTR No'));
			result = false;
		}

		return result;

		break;

	}
}

function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		var formObj = document.form;
		var message = formObj.estm_act_dt.value == "E" ? "Estimate Date/Time"
				: "Actual Date/Time";
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		ComShowMessage(ComGetMsg('COM12156', message));
	}
}

// S/O Link
function t3sheet1_OnDblClick(sheetObj, row, col) {
	var formObj = document.form;

	if (col == sheetObj.SaveNameCol("so_num")) {
		if (sheetObj.CellValue(row, 'so_num') !== "") {
			formObj.f_cmd.value = "";
			formObj.target = "_self";
			formObj.action = "ESD_TRS_0019.do?pgmNo=ESD_TRS_0019&sowonumber="
					+ sheetObj.CellValue(row, 'so_num');
			formObj.submit();
		}
	}
}

function t1sheet1_OnDblClick(sheetObj, row, col) {

	if (col == 2 && sheetObj.CellValue(row, col) != -1) {
		var formObj = document.form;
		var copNo = formObj.cop_no.value;
		var cntrNo = formObj.cntr_no.value;

		var copExptNo = sheetObj.CellValue(row, "cop_expt_no");
		var copExptTpCD = sheetObj.CellValue(row, "cop_expt_tp_cd");

		newForm = "<form name='form1' method='post'>";
		newForm += "  <input type='hidden' name='cop_expt_no'    value='"
				+ copExptNo + "'>";
		newForm += "  <input type='hidden' name='cop_expt_tp_cd' value='"
				+ copExptTpCD + "'>";
		newForm += "  <input type='hidden' name='cop_no'		 value='" + copNo
				+ "'>";
		newForm += "  <input type='hidden' name='cntr_no'		 value='" + cntrNo
				+ "'>";
		newForm += "  <input type='hidden' name='pgmNo'		 value='ESD_SCE_0012'>";

		newForm += "</form>";

		document.all.new_form.innerHTML = newForm;

		var formObj = document.form1;
		formObj.action = "ESD_SCE_0012.do";
		formObj.submit();

	}
}

// function setCopExptSts(sheetObj){
// var startRow = 1;
// if(sheetObj.TotalRows > 0){
// for(var i=startRow; i<=sheetObj.TotalRows; i++){
// if(sheetObj.CellValue(i, "expt_info") == '##'){
// sheetObj.CellValue(i, "expt_info") = '';
// }
// var valArray = sheetObj.CellValue(i, "expt_info").split("#") ;
// sheetObj.CellImage(i, "cop_expt_sts") = (valArray.length==3?valArray[1]
// ==("O")?"02":"01":"");
// sheetObj.RowStatus(i) = "R";
// }
// }
// }

function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
	var formObj = document.form;

	if (Col == 12 || Col == 13) {
		// if(Col == 11 || Col == 12 || Col == 13 || Col == 14){

		if (formObj.cntr_no.value == '') {
			sheetObj.CellEditable(Row, Col) = false;
			sheetObj.CellEditable(Row, Col) = false;
		}
	}
}

function t1sheet1_OnMouseMove(sheetObj, button, shift, x, y) {
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;
	var value = sheetObj.CellValue(row, col);

	if (row > 0 && col == 2 && value != "-1") {
		sheetObj.MousePointer = "Hand";
	} else {
		sheetObj.MousePointer = "Default";
	}
}

function keyAction() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	formObj.cntr_no_v.value = formObj.cntr_no_v.value.toUpperCase();
	formObj.cntr_no.value = formObj.cntr_no_v.value;
	// if(event.keyCode == 13){
	// alert('keyAction');
	/*
	 * if(ComIsEmpty(formObj.cntr_no)){ ComShowMessage(ComGetMsg('COM12114',
	 * 'CNTR No')) ; formObj.cntr_no.focus() ; return ; } else
	 * if(!ComChkObjValid(formObj.cntr_no, 11)){
	 * ComShowMessage(ComGetMsg('SCE90026', 'CNTR No', 11)) ;
	 * formObj.cntr_no.focus() ; return false ; } //}
	 */

	if (ComChkObjValid(formObj.cntr_no, 11)
			&& formObj.cntr_no.value.length == 11) {
		if (formObj.cntr_no.value == 'SMCU0000000') {
			alert("Invalid Container No!");
			return;
		}
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		comboObjects[0].Index = 1;
	}

}

function setCopValues() {
	var formObj = document.form;
	var values = formObj.bkg_no_tmp.Code.split("@");
	formObj.bkg_no.value = values[1];
	formObj.cop_no.value = values[0];
	if (values[3] != undefined) {
		formObj.cop_sts.value = values[3]; // 막혀있었음
	}
	if (values[2] != undefined) {
		formObj.cop_mst_bkg.value = values[2];
	}
	// var values = object.value.split("|")
	//
	// formObj.bkg_no.value = values[0];
	// //formObj.bkg_no_split.value = values[1];
	// formObj.cop_no.value = values[1];
	// formObj.cop_sts.value = values[2]; // 막혀있었음
	// if( values[3] != undefined){
	// formObj.cop_mst_bkg.value = values[3];}
}

function t1sheet1_OnSelectCell(sheetObj, oldRow, oldCol, newRow, newCol) {
	var oldColName = sheetObj.ColSaveName(oldCol);
	var newColName = sheetObj.ColSaveName(newCol);
	var rowCnt = sheetObj.Rows;
	// minestar - Actual Date 만 수정 가능하도록 수정 - estmt 가 수정되게 되어있는데, 안ㄷ되게 바꿈...

	/*
	 * if(newColName=="r_estm_date" || newColName=="r_estm_time"){ for(i=1; i<rowCnt;
	 * i++){ //alert(i); sheetObj.CellEditable(i, "r_estm_date") = true ;
	 * sheetObj.CellEditable(i, "r_estm_time") = true ;
	 * if(sheetObj.CellValue(i,7) != ''){ sheetObj.CellBackColor(i,"r_estm_date" ) =
	 * sheetObj.RgbColor(0,0,0); sheetObj.CellBackColor(i,"r_estm_time" ) =
	 * sheetObj.RgbColor(0,0,0); } sheetObj.CellEditable(i, "r_act_date") =
	 * false ; sheetObj.CellEditable(i, "r_act_time") = false ;
	 * if(sheetObj.CellValue(i,7) != ''){ sheetObj.CellBackColor(i,"r_act_date" ) =
	 * sheetObj.RgbColor(200,245,255); sheetObj.CellBackColor(i,"r_act_time" ) =
	 * sheetObj.RgbColor(200,245,255); } sheetObj.ReturnCellData(i,
	 * "r_act_date") ; sheetObj.ReturnCellData(i, "r_act_time") ;
	 * 
	 * if(document.form.cntr_no_v.value ==
	 * 'SMCU0000000'||document.form.cntr_no_v.value ==''){
	 * sheetObj.CellEditable(i, "r_estm_date") = false ; }
	 * if(document.form.cntr_no_v.value ==
	 * 'SMCU0000000'||document.form.cntr_no_v.value =='')
	 * sheetObj.CellEditable(i, "r_estm_time") = false ; } } else
	 * if(newColName=="r_act_date" || newColName=="r_act_time"){ for(i=1; i<rowCnt;
	 * i++){ sheetObj.CellEditable(i, "r_estm_date") = false ;
	 * sheetObj.CellEditable(i, "r_estm_time") = false ;
	 * if(sheetObj.CellValue(i,7) != ''){ sheetObj.CellBackColor(i,"r_estm_date" ) =
	 * sheetObj.RgbColor(200,245,255); sheetObj.CellBackColor(i,"r_estm_time" ) =
	 * sheetObj.RgbColor(200,245,255); } sheetObj.CellEditable(i, "r_act_date") =
	 * true ; sheetObj.CellEditable(i, "r_act_time") = true ;
	 * if(sheetObj.CellValue(i,7) != ''){ sheetObj.CellBackColor(i,"r_act_date" ) =
	 * sheetObj.RgbColor(0,0,0); sheetObj.CellBackColor(i,"r_act_time" ) =
	 * sheetObj.RgbColor(0,0,0); }
	 * 
	 * sheetObj.ReturnCellData(i, "r_estm_date") ; sheetObj.ReturnCellData(i,
	 * "r_estm_time") ;
	 * 
	 * if(document.form.cntr_no_v.value == 'SMCU0000000')
	 * sheetObj.CellEditable(i, "r_act_date") = false ;
	 * if(document.form.cntr_no_v.value == 'SMCU0000000')
	 * sheetObj.CellEditable(i, "r_act_time") = false ;
	 *  } }
	 */
}

function CheckDigit(obj) {
	var rtnval = cntrCheckDigit(obj);
	obj.value = rtnval;
}

function t1sheet1_OnSearchEnd(sheetObj) {
	if (sheetObj.TotalRows > 0) {
		sheetObj.EtcData("rail_rcv_coff_fm_dt") = sheetObj.CellValue(
				sheetObj.TotalRows, "rail_rcv_coff_fm_dt");
		document.form.rail_rcv_coff_fm_dt.value = sheetObj.CellValue(
				sheetObj.TotalRows, "rail_rcv_coff_fm_dt");
	}
}

function onEnterKey(textname) {
	if (event.keyCode == 13) {
		keyAction();
	}
}

/**
 * cop change 팝업 호출
 * 
 * @param formObj
 * @return
 */
function openESD_SCE_0053(formObj) {
	var cop_no = formObj.cop_no.value;
	newForm = "<form name='form1' method='post'>";
	newForm += "  <input type='hidden' name='cop_no'       value='" + cop_no
			+ "'>";
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0053'>";
	newForm += "</form>"
	document.all.new_form.innerHTML = newForm;
	var formObj = document.form1;
	var paramUrl = "pgmNo=ESD_SCE_0053&cop_no=" + formObj.cop_no.value;
	var newWin = window
			.showModalDialog(
					"ESD_SCE_0053.do?" + paramUrl,
					window,
					"scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:195px");
	// var newWin = window.open("","cop_change", "width=400,height=195," +
	// getCenterXY(400, 195));
	// formObj.action = "ESD_SCE_0053.do" ;
	// formObj.target = "cop_change" ;
	// formObj.submit() ;
}

/**
 * cop history 팝업 호출
 * 
 * @param formObj
 * @return
 */
function openESD_SCE_0071(formObj) {
	var cop_no = formObj.cop_no.value;
	newForm = "<form name='form1' method='post'>";
	newForm += "  <input type='hidden' name='cop_no'       value='" + cop_no
			+ "'>";
	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0071'>";
	newForm += "</form>"
	document.all.new_form.innerHTML = newForm;
	var formObj = document.form1;
	var paramUrl = "pgmNo=ESD_SCE_0071&cop_no=" + cop_no;
	var newWin = window
			.showModalDialog(
					"ESD_SCE_0071.do?" + paramUrl,
					"cop_history",
					"scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:600px");
	// var newWin = window.open("","cop_history",
	// "resizable,width=800,height=600," + getCenterXY(800, 600));
	// formObj.action = "ESD_SCE_0071.do" ;
	// formObj.target = "cop_history" ;
	// formObj.submit() ;
}

function fun_chkInlandPlan() {
	if (document.form.chk_inland_plan.checked == true) {
		sheetObjects[0].ColHidden("fx_pln_date") = false;
		sheetObjects[0].ColHidden("fx_pln_time") = false;
	} else {
		sheetObjects[0].ColHidden("fx_pln_date") = true;
		sheetObjects[0].ColHidden("fx_pln_time") = true;
	}
}