/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : ESM_BKG_1501.js
*@FileTitle : Advance Cargo Information Download & Transmit
*Open Issues :
*Change history :
*	Hannah Lee [CHM-201430566] JAFR ATD후의 CMR 5, 1  전송 조건 개선 요청
* 	Hannah Lee [CHM-201430708] JAFR의 AMR, CMR 에서 T/S VVD일 경우 Transmit 기능을 제한
*	2017.09.07 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.08.08
*@LastModifier : 하대성
*@LastVersion : 1.1
* 2013.06.28 김상수
* 1.0 Creation
* 1.3 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCH=3;
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
	 * @class ESM_BKG_1501 : ESM_BKG_1501 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_1501() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
		this.frmObj_OnChange    = frmObj_OnChange;
	}

/* 개발자 작업 */


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var backEndJobKey = "";
	var ExptAll111Rows = new Array();    // sheet2_OnSearchEnd에서 사용
	var ExptAll108Rows = new Array();    // sheet2_OnSearchEnd에서 사용
	var ExptErrRows = new Array();    // sheet2_OnSearchEnd에서 사용
	var ExptErr111Rows = new Array();    // sheet2_OnSearchEnd에서 사용
	var ExptErr108Rows = new Array();    // sheet2_OnSearchEnd에서 사용

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var shtObj1 = sheetObjects[0];
		var shtObj2 = sheetObjects[1];
		var frmObj = document.form;

//		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {

				case "btn_retrieve":
					frmObj.vvd.value = "";
					frmObj.pol_cd.value = "";
					doActionIBSheet(shtObj1, frmObj, SEARCH);
					break;

				case "vvd_date_div":
					if (frmObj.vvd_date_div[0].checked) {
						frmObj.vvd_hdr.readOnly = false;
						frmObj.vvd_hdr.className = "input1";
						frmObj.vvd_hdr.setAttribute("required", "");
						frmObj.date_fm.value = "";
						frmObj.date_fm.removeAttribute("required");
						frmObj.date_fm.className = "input2";
						frmObj.date_fm.readOnly = true;
						frmObj.date_to.value = "";
						frmObj.date_to.removeAttribute("required");
						frmObj.date_to.className = "input2";
						frmObj.date_to.readOnly = true;
						frmObj.pol_cd_hdr.removeAttribute("required");
						frmObj.pol_cd_hdr.className = "input";
					} else {
						frmObj.date_fm.readOnly = false;
						frmObj.date_fm.className = "input1";
						frmObj.date_fm.setAttribute("required", "");
						frmObj.date_to.readOnly = false;
						frmObj.date_to.className = "input1";
						frmObj.date_to.setAttribute("required", "");
						frmObj.vvd_hdr.value = "";
						frmObj.vvd_hdr.removeAttribute("required");
						frmObj.vvd_hdr.className = "input2";
						frmObj.vvd_hdr.readOnly = false;
						frmObj.vps_dt_div.fireEvent("onchange");
					}
					break;

				case "btn_calendar":    // 캘린더 호출
					if (window.event.srcElement.disabled) return;
					var cal = new ComCalendarFromTo();
					cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
					break;

				case "btn_send_email":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					doActionIBSheet(shtObj2, frmObj, REPLY);
					break;

				case "btn_bl_inquiry":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					var chkdRows = shtObj2.FindCheckedRow("chk")
					// 선택된 row들의 bl_no 비교 (ColMerge 때문)
					var blNo = shtObj2.CellValue(chkdRows.split("|")[0], "bl_no");
					var sameRows = ComFindAll(shtObj2, "bl_no", blNo) + "|";
					if (chkdRows != sameRows) {
						ComShowCodeMessage("BKG01134");    // You should select one B/L
						return;
					}
					var tCmrKind = shtObj2.CellValue(chkdRows.split("|")[0], "t_cmr_kind");
					var polSplitNo = shtObj1.CellValue(shtObj1.FindCheckedRow("chk").split("|")[0], "pol_split_no");
					var podSplitNo = frmObj.pod_split_no.value;
					// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
					ComOpenPopup("ESM_BKG_1502.do?pop_mode=Y&bl_no=" + blNo + "&t_cmr_kind=" + tCmrKind + "&pol_split_no=" + polSplitNo + "&pod_split_no=" + podSplitNo, 1024, 585, "", "1,0", true);
					break;

				case "btn_detail":
					doActionIBSheet(shtObj2, frmObj, SEARCH01);
					break;

				case "btn_new":
					ExptErrRows = new Array();    // 전역변수 초기화
					frmObj.vvd_date_div[0].fireEvent("onclick");    // 강제로 OnClick이벤트 발생
					ComResetAll();
					break;

				case "btn_data_download":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					with (shtObj2) {
						var chkdRowArray = FindCheckedRow("chk").split("|");
						chkdRowArray.pop();    // Array에서 마지막 빈 값 삭제
						// t_s_type이 AMR이고 SAS111에 Clear, " "를 제외한 error 메세지가 있는 경우 return
						for (var k in chkdRowArray) {
							if (CellValue(chkdRowArray[k], "t_s_type") == "AMR" &&
							   (CellValue(chkdRowArray[k], "sa111_rst") != "Clear" && CellValue(chkdRowArray[k], "sa111_rst") != " ")) {
								ComShowMessage("Your booking [" + CellValue(chkdRowArray[k], "bl_no") + "] has been rolled over.\n\nPlease, DEL Transmit a manifest attached to the previous vessel first.");
								SelectCell(chkdRowArray[k], "sa111_rst");
								return;
							} else if (CellValue(chkdRowArray[k], "mst_bl") == "E") {
								ComShowMessage("Simple/Console indicator is not selected. Please, select the right one.");
								shtObj2.SelectCell(chkdRowArray[k], "mst_bl");
								return;
							} else if (CellValue(chkdRowArray[k], "cntr_no") == "") {
								ComShowMessage("Booking doesn't have a container to file. Please, check and complete documentation and redownload.");
								shtObj2.SelectCell(chkdRowArray[k], "cntr_no");
								return;
							}
						}
					}
					doActionIBSheet(shtObj2, frmObj, MULTI01);
					break;

				case "btn_down_excel":
					ComOpenWait(true);
					shtObj2.Down2Excel(-1);
					ComOpenWait(false);
					break;

				case "btn_transmit":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					var chkdRowArray = shtObj2.FindCheckedRow("chk").split("|");
					chkdRowArray.pop();    // Array에서 마지막 빈 값 삭제
					for (var k in chkdRowArray) {    //    "9|2|5|1||");   //9|2|5|1|| 에서 //9|2|5|1| | 로 바꾸고 진행해도 공백을 인식을 하지 못하는 특성으로 인해 "" 추가함
						if (shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == " "||shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "") {
							ComShowCodeMessage("BKG08006", "Selected B/L is already transmitted and declared successfully.");    // You can't select the data [{?msg1}].
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						} else if (shtObj2.CellValue(chkdRowArray[k], "a_cmr_kind") == "9" &&
						           shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "9" &&
						           shtObj2.CellValue(chkdRowArray[k], "samr_rst") == " ") {
							ComShowMessage("Please, wait for customs response thru SAMR before you send AMR again.");
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						} else if (shtObj2.CellValue(chkdRowArray[k], "a_cmr_kind") == "2" &&
						           shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "2" &&
						           shtObj2.CellValue(chkdRowArray[k], "scmr_rst") == " ") {
							ComShowMessage("Please, wait for customs response thru SCMR before you send CMR again.");
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						}
					}
					frmObj.del_trasmit_flag.value = "";
					
					// 2014.06.13 Hannah Lee - Start
					if(!validateForm(shtObj2,frmObj,COMMAND01)) {
						return false;
					}
					// 2014.06.13 Hannah Lee - End
					
					doActionIBSheet(shtObj2, frmObj, COMMAND01);
					break;

				case "btn_del_transmit":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					var chkdRowArray = shtObj2.FindCheckedRow("chk").split("|");
					chkdRowArray.pop();    // Array에서 마지막 빈 값 삭제
					for (var k in chkdRowArray) {
						if (shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "9") {
							ComShowCodeMessage("BKG08006", "'AMR' Transmit Status");    // You can't select the data [{?msg1}].
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						}
					}
					
					frmObj.del_trasmit_flag.value = "Y";
					
					// 2014.06.24 Hannah Lee - Start
					if(!validateForm(shtObj2,frmObj,COMMAND01)) {
						frmObj.del_trasmit_flag.value = "";
						return false;
					}
					// 2014.06.24 Hannah Lee - End
					
					doActionIBSheet(shtObj2, frmObj, COMMAND01);
					break;

				//	2017.07.30 Daesung Ha - Start				
					
				case "btn_new_transmit":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					var chkdRowArray = shtObj2.FindCheckedRow("chk").split("|");
					chkdRowArray.pop();    // Array에서 마지막 빈 값 삭제
					for (var k in chkdRowArray) {    //    "9|2|5|1||");   //9|2|5|1|| 에서 //9|2|5|1| | 로 바꾸고 진행해도 공백을 인식을 하지 못하는 특성으로 인해 "" 추가함
						if (shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == " "||shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "") {
							ComShowCodeMessage("BKG08006", "Selected B/L is already transmitted and declared successfully.");    // You can't select the data [{?msg1}].
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						} else if (shtObj2.CellValue(chkdRowArray[k], "a_cmr_kind") == "9" &&
						           shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "9" &&
						           shtObj2.CellValue(chkdRowArray[k], "samr_rst") == " ") {
							ComShowMessage("Please, wait for customs response thru SAMR before you send AMR again.");
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						} else if (shtObj2.CellValue(chkdRowArray[k], "a_cmr_kind") == "2" &&
						           shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "2" &&
						           shtObj2.CellValue(chkdRowArray[k], "scmr_rst") == " ") {
							ComShowMessage("Please, wait for customs response thru SCMR before you send CMR again.");
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						}
					}
					frmObj.del_new_trasmit_flag.value = "";
					
					if(!validateForm(shtObj2,frmObj,COMMAND02)) {
						return false;
					}
					
					var rtnVal;
					for (var k in chkdRowArray) {
						if(shtObj2.CellValue(chkdRowArray[k], "t_s_type") == "CMR" &&
						   shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "1") {
							if(rtnVal == null) {
								var sUrl = "ESM_BKG_1501_1.do?bl_no="
								rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_1501_1", 370, 160, true);
								if(rtnVal == null) {
									return;
								} else {
									shtObj2.CellValue(chkdRowArray[k], "del_cd") = rtnVal.del_cd;
									shtObj2.CellValue(chkdRowArray[k], "del_reason") = rtnVal.del_reason;
								}
							} else {
								shtObj2.CellValue(chkdRowArray[k], "del_cd") = rtnVal.del_cd;
								shtObj2.CellValue(chkdRowArray[k], "del_reason") = rtnVal.del_reason;
							}							
						}
					}

					doActionIBSheet(shtObj2, frmObj, COMMAND02);
					break;

				case "btn_del_new_transmit":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					var chkdRowArray = shtObj2.FindCheckedRow("chk").split("|");
					chkdRowArray.pop();    // Array에서 마지막 빈 값 삭제
					for (var k in chkdRowArray) {
						if (shtObj2.CellValue(chkdRowArray[k], "t_cmr_kind") == "9") {
							ComShowCodeMessage("BKG08006", "'AMR' Transmit Status");    // You can't select the data [{?msg1}].
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						}
					}
					
					frmObj.del_new_trasmit_flag.value = "Y";
					
					if(!validateForm(shtObj2,frmObj,COMMAND02)) {
						frmObj.del_new_trasmit_flag.value = "";
						return false;
					}

					var sUrl = "ESM_BKG_1501_1.do?bl_no=";
					var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_1501_1", 370, 160, true);
					if(rtnVal == null) {
						return;
					} else {
						for (var k in chkdRowArray) {
							shtObj2.CellValue(chkdRowArray[k], "del_cd") = rtnVal.del_cd;
							shtObj2.CellValue(chkdRowArray[k], "del_reason") = rtnVal.del_reason;
						}
					}
						
					
									
					doActionIBSheet(shtObj2, frmObj, COMMAND02);
					break;					
					
				//	2017.07.30 Daesung Ha - End				
					
				case "btn_view_file":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					var chkdRows = shtObj2.FindCheckedRow("chk")
					// 선택된 row들의 bl_no 비교 (ColMerge 때문)
					var blNo = shtObj2.CellValue(chkdRows.split("|")[0], "bl_no");
					var sameRows = ComFindAll(shtObj2, "bl_no", blNo) + "|";
					if (chkdRows != sameRows) {
						ComShowCodeMessage("BKG01134");    // You should select one B/L
						return;
					}
					if (ComTrim(shtObj2.CellValue(chkdRows.split("|")[0], "s_dt")) == "") {
						ComShowCodeMessage("BKG08278");    // FlatFile not Transmit!
						return;
					}

					// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
					ComOpenPopup("ESM_BKG_1506.do?bl_no=" + blNo + "&snd_dt=" + shtObj2.CellValue(chkdRows.split("|")[0], "s_dt"), 600, 335, "", "1,0", true);
					break;

			} // end switch

//		} catch(e) {
//			if (e == "[object Error]") {
//				ComShowMessage(OBJECT_ERROR);
//			} else {
//				ComShowMessage(e);
//			}
//		}
	}


	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}


	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();

		ComBtnDisable("btn_send_email");
		ComBtnDisable("btn_bl_inquiry");
		ComBtnDisable("btn_data_download");
		ComBtnDisable("btn_transmit");
		ComBtnDisable("btn_del_transmit");
		ComBtnDisable("btn_new_transmit");
		ComBtnDisable("btn_del_new_transmit");
		ComBtnDisable("btn_view_file");

		// sheet2_OnLoadFinish 메서드 반드시 참조
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// Enter키를 눌렀을때 Tab키처럼 작동
			EditEnterBehavior = "tab";

			WaitImageVisible = false;
			CountPosition = 0;


			switch (shtObj.id) {

				case "sheet1":
					var cnt = 0;
					// 높이 설정
					style.height = 150;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(0, 1, 13, 500);
					document.form.pagerows.value = 500;

					// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, false, false, true, false, false);

					// 컬럼 헤더타이틀
					var HeadTitle  = "|SEQ|SEL|VVD|ETA/ETD|V/POL|ATD Receive|SATD|Relaxed|POL Call Seq.|v/pod";

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    false,    "ibflag");    // [필수]
					InitDataProperty(0, cnt++, dtDataSeq,      30,    daCenter,    false,    "seq");
					InitDataProperty(0, cnt++, dtRadioCheck,   30,    daCenter,    false,    "chk");
					InitDataProperty(0, cnt++, dtData,         65,    daCenter,    false,    "vvd",            false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         95,    daCenter,    false,    "vps_dt",         false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    false,    "pol_cd",         false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         95,    daCenter,    false,    "rcv_dt",         false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         50,    daCenter,    false,    "atd_rst",        false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtCheckBox,     60,    daCenter,    false,    "rlx_div",        false,    "",    dfNone,    0,    false,    false);
					InitDataProperty(0, cnt++, dtCombo,        75,    daCenter,    false,    "pol_split_no");

					InitDataProperty(0, cnt++, dtHidden,       45,    daCenter,    false,    "pod_cd",         false,    "",    dfNone,    0,    false,    false);

					InitDataCombo(0, "pol_split_no", " |1|2|3|4|5|6|7|8|9", " |1|2|3|4|5|6|7|8|9", "", "");
					ShowButtonImage = 4;

					SelectHighLight = false;

					break;


				case "sheet2":
					var cnt = 0;
					// 높이 설정
					style.height = GetSheetHeight(14);

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(2, 1, 13, 500);

					// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(false, false, true, true, false, false);

					// 컬럼 헤더타이틀
					var HeadTitle0  = "|SEQ|SEL|B/L No.|H B/L|B/POL|V/POL|V/POD|B/POD|B/DEL" +
					                  "|Trasmit Status|Trasmit Status|Trasmit Status|Trasmit Status|S.Date" +
					                  "|Customs Results|Customs Results|Customs Results|Customs Results|Customs Results|Customs Results|Customs Results|Customs Results" +
					                  "|Shipper|Shipper|Shipper|Shipper|Shipper|Cnee|Cnee|Cnee|Cnee|Cnee|Notify|Notify|Notify|Notify|Notify" +
					                  "|E-Mail|E-Mail|CMDT|HS CD|M & N|PKG|PKG\nUnit|G/WT|WT\nUnit|MEA|MEA\nUnit|IMDG|UN No.|Container No."+
					                  "|pod_div|rvis_cntr_cust_tp_cd|sc108_rst_dtl|s_info|bkg_pod_cd|bb_cgo_flag|del_cd|del_reason";    // Hidden column

					var HeadTitle1  = "|SEQ||B/L No.|H B/L|B/POL|V/POL|V/POD|B/POD|B/DEL" +
					                  "|Current|Current|Next|Next|S.Date" +
					                  "|SAMR|R.Date|SAS111|R.Date|SCMR|R.Date|SAS108|R.Date" +
					                  "|NM|ADD|CNT CD|PHN|VIA|NM|ADD|CNT CD|PHN|VIA|NM|ADD|CNT CD|PHN|VIA" +
					                  "|E-Mail|E-Mail|CMDT|HS CD|M & N|PKG|PKG\nUnit|G/WT|WT\nUnit|MEA|MEA\nUnit|IMDG|UN No.|Container No."+
					                  "|pod_div|rvis_cntr_cust_tp_cd|sc108_rst_dtl|s_info|bkg_pod_cd|bb_cgo_flag|del_cd|del_reason";    // Hidden column

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 14, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);

					// 데이터속성 [ROW,  COL,    DATATYPE,    WIDTH,  DATAALIGN, COLMERGE,  SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    true,    "ibflag");    // [필수]
					InitDataProperty(0, cnt++, dtData,         30,    daCenter,    true,    "seq",            false,    "",         dfNone,    0,        false,      false);    // 전체 seq
					InitDataProperty(0, cnt++, dtDummyCheck,   30,    daCenter,    true,    "chk");

					InitDataProperty(0, cnt++, dtData,         90,    daCenter,    true,    "bl_no",          false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "mst_bl",         false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "bkg_pol_cd",     false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "pol_cd",         false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "pod_cd",         false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "bkg_pod_cd",         false,    "",     dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "bkg_del_cd",     false,    "",         dfNone,    0,        false,      false);

					InitDataProperty(0, cnt++, dtData,         30,    daCenter,    true,    "a_s_type",       false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtCombo,        30,    daCenter,    true,    "a_cmr_kind",     false,    "",         dfNone,    0,        false,      false);

					var editableYN = false;
					if (strUsrId.substring(0, 4) == "TES_") editableYN = true;    // Test용
					InitDataProperty(0, cnt++, dtData,         30,    daCenter,    true,    "t_s_type",       false,    "",         dfNone,    0,        editableYN, editableYN);
					InitDataProperty(0, cnt++, dtCombo,        30,    daCenter,    true,    "t_cmr_kind",     false,    "",         dfNone,    0,        editableYN, editableYN);
					InitDataProperty(0, cnt++, dtData,         100,   daCenter,    true,    "s_dt",           false,    "",         dfNone,    0,        false,      false);

					InitDataProperty(0, cnt++, dtData,         50,    daCenter,    true,    "samr_rst",       false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         100,   daCenter,    true,    "samr_dt",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         50,    daCenter,    true,    "sa111_rst",      false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         100,   daCenter,    true,    "sa111_dt",       false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         50,    daCenter,    true,    "scmr_rst",       false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         100,   daCenter,    true,    "scmr_dt",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         70,    daCenter,    true,    "sc108_rst",      false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         100,   daCenter,    true,    "sc108_dt",       false,    "",         dfNone,    0,        false,      false);

					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "shpr_nm",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "shpr_addr",      false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "shpr_cnt_cd",    false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "shpr_phn_no",    false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "shpr_via",       false,    "",         dfNone,    0,        false,      false);

					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "cnee_nm",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "cnee_addr",      false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "cnee_cnt_cd",    false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "cnee_phn_no",    false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "cnee_via",       false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "ntfy_nm",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "ntfy_addr",      false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "ntfy_cnt_cd",    false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "ntfy_phn_no",    false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "ntfy_via",       false,    "",         dfNone,    0,        false,      false);
					
					InitDataProperty(0, cnt++, dtData,         150,   daLeft,      true,    "usr_eml",        false,    "",         dfNone,    0,        true,       true,     200);    // 사용자 입력 email
					InitDataProperty(0, cnt++, dtData,         150,   daLeft,      true,    "old_usr_eml",    false,    "",         dfNone,    0,        false,      false);

					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "cmdt_cd",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "cmdt_hs_cd",     false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "mk_desc",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "pck_qty",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "pck_tp_cd",      false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "act_wgt",        false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "wgt_ut_cd",      false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "meas_qty",       false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "meas_ut_cd",     false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "imdg_cls",       false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "un_no",          false,    "",         dfNone,    0,        false,      false);

					InitDataProperty(0, cnt++, dtData,         85,    daCenter,    true,    "cntr_no",        false,    "",         dfNone,    0,        false,      false);

					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,    true,    "pod_div");
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,    true,    "rvis_cntr_cust_tp_cd");
					InitDataProperty(0, cnt++, dtHidden,       80,    daCenter,    true,    "sc108_rst_dtl");
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,    true,    "s_info");
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,    true,    "bkg_pod_cd");
					InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,    true,    "bb_cgo_flg");
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "del_cd",         false,    "",         dfNone,    0,        false,      false);
					InitDataProperty(0, cnt++, dtData,         45,    daCenter,    true,    "del_reason",     false,    "",         dfNone,    0,        false,      false);

					ColHidden("del_cd") = true;
					ColHidden("del_reason") = true;
					
					ColIndent("usr_eml") = 2;

					// 입력제한
					InitDataValid(0, "usr_eml" , vtEngOther, "1234567890@;.-_ ");
					InitDataCombo(0, "a_cmr_kind",  "Reg|Add|Cor|Del| |","9|2|5|1||");         
					InitDataCombo(0, "t_cmr_kind",  "Reg|Add|Cor|Del| |","9|2|5|1||");   //9|2|5|1|| 에서 //9|2|5|1| | 로 바꾸고 진행해도 공백을 인식을 하지 못하는 특성 있음

					HeadRowHeight = 20;//19; // 18;
					SelectHighLight = false;

					ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";

					// Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
					EditableColorDiff = false;

					break;
			}
		}
	}


	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		// 기본 OnKeyPress 이벤트 (키입력)  - CoBkg.js에 정의
		axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);
		// OnChange 이벤트
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {

			case SEARCH:    // Header - 조회
				if (!ComChkValid(frmObj)) return;
				if (frmObj.vvd_date_div[0].checked) {
					if (ComTrim(frmObj.pol_cd_hdr) == "" && ComTrim(frmObj.pod_postfix) == "" && ComTrim(frmObj.bkg_ofc_cd) == "") {
						ComShowCodeMessage("COM12138", "POL or POD", "BKG OFC");    // Please enter {?msg1} or {?msg2}.
						ComSetFocus(frmObj.pol_cd_hdr);
						return;
					}
				} else {
					if (ComGetDaysBetween(frmObj.date_fm.value, frmObj.date_to.value) > 3) {
						ComShowCodeMessage("COM132001","Period","4 days");    // {?msg1} exceeds maximum duration {?msg2}.
						ComSetFocus(frmObj.date_to);
						return;
					}
				}
				ComOpenWait(true);
				frmObj.call_sgn_no.value = "";
				shtObj.RemoveAll();
				shtObj.RemoveEtcData();
				var shtObj2 = sheetObjects[1];
				shtObj2.RemoveAll();
				shtObj2.RemoveEtcData();
				shtObj2.HeadCheck(1, "chk") = false;
				document.getElementById("disp_ttl_bl").value = "";
				document.getElementById("disp_hjs_err_bl").value = "";
				document.getElementById("disp_miss_bl").value = "";
				document.getElementById("disp_snt_scc_bl").value = "";
				document.getElementById("disp_snt_err_bl").value = "";
				document.getElementById("disp_dnl").value = "";
				document.getElementById("disp_dnu").value = "";
				document.getElementById("disp_spd").value = "";
				document.getElementById("disp_hld").value = "";

				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1501GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;

			case SEARCH01:    // Detail - 조회 (Back End Job)
				if (!ComChkValid(frmObj)) return;
				if (sheetObjects[0].CheckedRows("chk") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return;
				}
				ComOpenWait(true);
				shtObj.RemoveAll();
				shtObj.RemoveEtcData();
				shtObj.HeadCheck(1, "chk") = false;
				document.getElementById("disp_ttl_bl").value = "";
				document.getElementById("disp_hjs_err_bl").value = "";
				document.getElementById("disp_miss_bl").value = "";
				document.getElementById("disp_snt_scc_bl").value = "";
				document.getElementById("disp_snt_err_bl").value = "";
				document.getElementById("disp_dnl").value = "";
				document.getElementById("disp_dnu").value = "";
				document.getElementById("disp_spd").value = "";
				document.getElementById("disp_hld").value = "";

				frmObj.f_cmd.value = SEARCH01;
				var xmlStr = shtObj.GetSearchXml("ESM_BKG_1501GS.do", FormQueryString(frmObj));
				if (frmObj.vvd_date_div[0].checked) {
				}
				var callSgnNo = ComGetEtcData(xmlStr, "call_sgn_no");    // call_sgn_no setting
				if (callSgnNo != undefined) {
					//조회된 ETC데이터를 Form내 오브젝트에 setting
					frmObj.call_sgn_no.value = callSgnNo;
				}
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != "") {
					shtObj.RequestTimeOut = 20000;
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
				break;

			case REPLY:    // Detail - Send Email
				if (!ComShowCodeConfirm("BKG01081")) return;    // Do you want to send email ?
				with (shtObj) {
					ComOpenWait(true);
					var chkdRowArray = FindCheckedRow("chk").split("|");
					chkdRowArray.pop();    // Array에서 마지막 배열(빈값이므로) 삭제
					for (var k=0; k<chkdRowArray.length; k++) {
						if (k < chkdRowArray.length && CellValue(chkdRowArray[k], "bl_no") != CellValue(chkdRowArray[k + 1], "bl_no")) {    // 중복 BL No. skip
							var usrEmlArray = CellValue(chkdRowArray[k], "usr_eml").split(";");
							for (var i=0; i<usrEmlArray.length; i++) {
								if (!ComIsEmailAddr(ComTrim(usrEmlArray[i]))) {
									ComOpenWait(false);
									ComShowCodeMessage("BKG00366");    // E-mail Address is missing or not correct format
									SelectCell(chkdRowArray[k], "usr_eml");
									return;
								}
							}
						}
					}
					frmObj.f_cmd.value = REPLY;
					var saveString = ComSetPrifix(GetSaveString(false, true, "chk"), "sheet2_");
					var xmlStr = GetSaveXml("ESM_BKG_1501GS.do", FormQueryString(frmObj) + "&" + saveString);
					ComOpenWait(false);
					// 본 js에서는 Back End Job 함수 관련으로 인하여 sheet2_OnSaveEnd 이벤트를 사용하지 않으므로 아래와 같이 처리
					if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "S") {
						ComShowCodeMessage("BKG00497");    // E-mail was sent successfully.
						doActionIBSheet(shtObj, document.form, SEARCH01);
					} else {
						LoadSaveXml(xmlStr);
					}
				}
				break;

			case MULTI01:    // Detail - Data Download
				if (!ComShowCodeConfirm("COM130101", "data")) return;    // "Do you want to save {?msg1}?"
				ComOpenWait(true);
				frmObj.f_cmd.value = MULTI01;
				var saveString = ComSetPrifix(shtObj.GetSaveString(false, true, "chk"), "sheet2_");
				var xmlStr = shtObj.GetSaveXml("ESM_BKG_1501GS.do", FormQueryString(frmObj) + "&" + saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != "") {
					shtObj.RequestTimeOut = 20000;
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
				break;

			case COMMAND01:    // Detail - EDI Transmit
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND01;
				var saveString = ComSetPrifix(shtObj.GetSaveString(false, true, "chk"), "sheet2_");
				var xmlStr = shtObj.GetSaveXml("ESM_BKG_1501GS.do", FormQueryString(frmObj) + "&" + saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != "") {
					shtObj.RequestTimeOut = 20000;
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
				break;
			
			// 2017.07.30 Daesung Ha Start		
			case COMMAND02:
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND02;
				var saveString = ComSetPrifix(shtObj.GetSaveString(false, true, "chk"), "sheet2_");
				var xmlStr = shtObj.GetSaveXml("ESM_BKG_1501GS.do", FormQueryString(frmObj) + "&" + saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != "") {
					shtObj.RequestTimeOut = 20000;
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}

				break;
			// 2017.07.30 Daesung Ha End	
		}
	}


	/**
	 * Back End Job 호출함수
	 */
	function getBackEndJobStatus() {
		var shtObj2 = sheetObjects[1];
		var xmlStr = shtObj2.GetSearchXml("ESM_BKG_1501GS.do", "f_cmd=" + SEARCH02 + "&backEndJob_Key=" + backEndJobKey);
		var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");

		if (jbStsFlg == "3") {
			var frmObj = document.form;
			if (frmObj.f_cmd.value == SEARCH01) {
				shtObj2.DoSearch4Sax("ESM_BKG_1501View_GS.do", "f_cmd=" + SEARCH03 + "&backEndJob_Key=" + backEndJobKey);
				clearInterval(timer);
				backEndJobKey = "";
				ComOpenWait(false);
				// HTML Object의 disabled는 ComOpenWait(false)이후에 동작하므로, sheet2_OnSeachEnd가 아닌 여기에 위치
				ComBtnEnable("btn_view_file");
				if (frmObj.search_div.value == "BL") {
					ComBtnDisable("btn_send_email");
					ComBtnDisable("btn_bl_inquiry");
					ComBtnEnable("btn_data_download");
					ComBtnDisable("btn_transmit");
					ComBtnDisable("btn_del_transmit");
					ComBtnDisable("btn_new_transmit");
					ComBtnDisable("btn_del_new_transmit")
				} else {
					ComBtnEnable("btn_send_email");
					ComBtnEnable("btn_bl_inquiry");
					ComBtnDisable("btn_data_download");
					ComBtnEnable("btn_transmit");
					ComBtnEnable("btn_del_transmit");
					ComBtnEnable("btn_new_transmit");
					ComBtnEnable("btn_del_new_transmit");
				}
				return;

			} else if (frmObj.f_cmd.value == MULTI01) {
				xmlStr = "";
				xmlStr = shtObj2.GetSaveXml("ESM_BKG_1501GS.do", "f_cmd=" + MULTI03 + "&backEndJob_Key=" + backEndJobKey);
				frmObj.del_trasmit_flag.value = "";
				frmObj.del_new_trasmit_flag.value = "";
				clearInterval(timer);
				backEndJobKey = "";
				ComOpenWait(false);
				// 저장 후 재조회 (sheet2_OnSaveEnd에서 재조회를 하게 되면 backEndJob의 ComOpenWait이 정상작동하지 않음으로, 여기에 위치)
				frmObj.search_div.value = "DN";
				if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "S") {
					ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
					doActionIBSheet(shtObj2, frmObj, SEARCH01);
				} else {
					shtObj2.LoadSaveXml(xmlStr);
				}

			} else if (frmObj.f_cmd.value == COMMAND01) {
				xmlStr = "";
				xmlStr = shtObj2.GetSaveXml("ESM_BKG_1501GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey);
				frmObj.del_trasmit_flag.value = "";
				clearInterval(timer);
				backEndJobKey = "";
				ComOpenWait(false);
				// 저장 후 재조회 (sheet2_OnSaveEnd에서 재조회를 하게 되면 backEndJob의 ComOpenWait이 정상작동하지 않음으로, 여기에 위치)
				frmObj.search_div.value = "DN";
				if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "S") {
//					ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
					ComShowMessage("Data was transmitted successfully.\n\nResult confirmation after 10 minutes.");
					doActionIBSheet(shtObj2, frmObj, SEARCH01);
				} else {
					shtObj2.LoadSaveXml(xmlStr);
				}
			}
			
			// 2017.07.30 Daesung Ha Start		
		
			else if (frmObj.f_cmd.value == COMMAND02) {
				xmlStr = "";
				xmlStr = shtObj2.GetSaveXml("ESM_BKG_1501GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey);
				frmObj.del_new_trasmit_flag.value = "";
				clearInterval(timer);
				backEndJobKey = "";
				ComOpenWait(false);
				// 저장 후 재조회 (sheet2_OnSaveEnd에서 재조회를 하게 되면 backEndJob의 ComOpenWait이 정상작동하지 않음으로, 여기에 위치)
				frmObj.search_div.value = "DN";
				if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "S") {
//					ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
					ComShowMessage("Data was transmitted successfully.\n\nResult confirmation after 10 minutes.");
					doActionIBSheet(shtObj2, frmObj, SEARCH01);
				} else {
					shtObj2.LoadSaveXml(xmlStr);
				}
			}

			// 2017.07.30 Daesung Ha End		
			
		} else if (jbStsFlg == "4") {
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);
			ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.
		}
	}


	/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function sheet1_OnSearchEnd(shtObj, ErrMsg) {
		if (ErrMsg != "" || shtObj.RowCount < 1)  return;
		document.form.pol_split_no.value = "";
		document.form.pod_split_no.value = "";
		with (shtObj) {
			ReDraw = false;
			for (var i=HeaderRows; i<=LastRow; i++) {
				if (CellValue(i, "atd_rst") == "Error") {
					CellFontColor(i, "atd_rst") = RgbColor(255, 60, 60);
					CellFont("FontBold", i, "atd_rst") = true;
					CellFontUnderline(i, "atd_rst") = true;
				}
			}
			ReDraw = true;
		}
	}


	/**
	 * IBSeet상에서 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Button} Integer : 마우스버튼 방향, 1:왼쪽, 2:오른쪽
	 * @param {Shift} Integer : Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	 */
	function sheet1_OnMouseMove(shtObj, Button, Shift) {
		with (shtObj) {
			switch (ColSaveName(MouseCol)) {
				case "atd_rst":
					if (CellValue(MouseRow, MouseCol) == "Error") MousePointer = "Hand";
				break;
			}
		}
	}


	/**
	 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */
	function sheet1_OnClick(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "atd_rst":
					if (Value == "Error") {
						var param = "?jp_msg_tp_id=SATD&vvd=" + CellValue(Row, "vvd");
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_1505.do" + param, 750, 350, "", "1,0", true);
					}
					break;
			}
		}
	}


	/**
	 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet셀 명
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */
	function sheet1_OnChange(shtObj, Row, Col, Value) {
		var frmObj = document.form;
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "chk":
					frmObj.vvd.value = CellValue(Row, "vvd");
					frmObj.pol_cd.value = CellValue(Row, "pol_cd");
					frmObj.rlx_div.value = CellValue(Row, "rlx_div");
					break;

				case "rlx_div":
					frmObj.rlx_div.value = Value;
					break;

				case "pol_split_no":
					frmObj.pol_split_no.value = Value;
					break;
			}
		}
	}


	/**
	 * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 */
	function sheet1_OnDblClick(shtObj, Row, Col){
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "vvd":
				case "vps_dt":
				case "pol_cd":
				case "rcv_dt":
					CellValue(Row, "chk") = "1";    // sheet1_OnChange 이벤트 호출
					
					document.form.hid_rcv_dt.value = shtObj.CellValue(Row, "rcv_dt"); // 2014.06.13 Add. Hannah Lee
					
					doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
					break;
			}
		}
	}


	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet2_OnLoadFinish(shtObj) {
		shtObj.ColHidden("usr_eml") = true;
	}


	/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function sheet2_OnSearchEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		if (shtObj.RowCount > 0) {
			with (shtObj) {
				// 화면에 Display하기위한 input에 value setting
				document.getElementById("disp_ttl_bl").value = EtcData("disp_ttl_bl");
				document.getElementById("disp_hjs_err_bl").value = EtcData("disp_hjs_err_bl");
				document.getElementById("disp_miss_bl").value = EtcData("disp_miss_bl");
				document.getElementById("disp_snt_scc_bl").value = EtcData("disp_snt_scc_bl");
				document.getElementById("disp_snt_err_bl").value = EtcData("disp_snt_err_bl");
				document.getElementById("disp_dnl").value = EtcData("disp_dnl");
				document.getElementById("disp_dnu").value = EtcData("disp_dnu");
				document.getElementById("disp_spd").value = EtcData("disp_spd");
				document.getElementById("disp_hld").value = EtcData("disp_hld");
			}

			var frmObj = document.form;
			var editableYN = false;
			if (frmObj.search_div.value == "DN") {
				editableYN = true;
				shtObj.ColHidden("usr_eml") = false;
				shtObj.ColHidden("old_usr_eml") = true;
			} else {
				shtObj.ColHidden("usr_eml") = true;
				shtObj.ColHidden("old_usr_eml") = false;
			}
			sheetObjects[0].ReDraw = false;
			for (var jj=sheetObjects[0].HeaderRows; jj<=sheetObjects[0].LastRow; jj++) {
				sheetObjects[0].CellEditable(jj, "rlx_div") = editableYN;
			}
			sheetObjects[0].ReDraw = true;
		}
	}


	/**
	 * IBSeet상에서 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Button} Integer : 마우스버튼 방향, 1:왼쪽, 2:오른쪽
	 * @param {Shift} Integer : Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	 */
	function sheet2_OnMouseMove(shtObj, Button, Shift) {
		with (shtObj) {
			if (MouseRow == 1) {
				switch (ColSaveName(MouseCol)) {
					case "sa111_rst":
						MouseToolTipText = "Advance Notice of Risk Assessment Result.";
					break;
					case "sc108_rst":
						MouseToolTipText = "Discrepancy Inforamtion of Advance Filing(non-Government).";
					break;
					default:
						MouseToolTipText = "";
					break;
				}

			} else {
				MouseToolTipText = "";
				var rcvRst = CellValue(MouseRow, MouseCol);
				switch (ColSaveName(MouseCol)) {
					case "samr_rst":
					case "scmr_rst":
					case "sc108_rst":
						if (rcvRst != "Success" && rcvRst != " ") MousePointer = "Hand";
					break;
					case "sa111_rst":
						if (rcvRst != "Clear" && rcvRst != " ") MousePointer = "Hand";
					break;
				}
			}
		}
	}


	/**
	 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Row} Long : 해당 셀의 Row Index
	 * @param {Col} Long : 해당 셀의 Column Index
	 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 */
	function sheet2_OnClick(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "chk":
					var check = (Value==0 ? 1 : 0);
					// 선택된 row의 seq와 같은 row index를 검색 (ColMerge 때문)
					var blNo = CellValue(Row, "bl_no");
					var sameRows = ComFindAll(shtObj, "bl_no", blNo).toString().split("|");    // return값이 하나일경우 숫자형이므로 "|"으로 split되지 않음에 유의
					ReDraw = false;
					// 검색된 row index들에 대한 처리
					for (var i in sameRows) {
						if (Row != sameRows[i]) CellValue(sameRows[i], "chk") = check;
					}
					ReDraw = true;
					break;

				case "samr_rst":
				case "scmr_rst":
					if (Value == "Error") {
						var param = "?jp_msg_tp_id=" + CellText(1, ColSaveName(Col)) + "&bl_no=" + CellValue(Row, "bl_no");
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_1505.do" + param, 750, 350, "", "1,0", true);
					}
					break;
				case "sc108_rst":
					if (Value != "Success" && Value != " ") {
						var param = "?jp_msg_tp_id=" + CellText(1, ColSaveName(Col)) + "&sc108_rst_dtl=" + ComTrim(CellValue(Row, "sc108_rst_dtl"));
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_1505.do" + param, 750, 350, "", "1,0", true);
					}
					break;
				case "sa111_rst":
					if (Value != "Clear" && Value != " ") {
						var param = "?jp_msg_tp_id=" + CellText(1, ColSaveName(Col)) + "&bl_no=" + CellValue(Row, "bl_no") + "&err_cd=" + Value;
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_1505.do" + param, 750, 350, "", "1,0", true);
					}
					break;
			}
		}
	}


	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var elementName = window.event.srcElement.getAttribute("name");
		switch (elementName) {
			case "vps_dt_div":
				var frmObj = document.form;
				if (frmObj.vvd_date_div[1].checked) {
					if (frmObj.vps_dt_div.value == "ETD") {
						frmObj.pol_cd_hdr.className = "input1";
						frmObj.pol_cd_hdr.setAttribute("required", "");
					} else {
						frmObj.pol_cd_hdr.removeAttribute("required");
						frmObj.pol_cd_hdr.className = "input";
					}
				}
				break;
		}
	}


	
	// 2014.06.13 Add. Hannah Lee
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	    switch (sAction) {
		    case COMMAND01: //When Transmit or DEL Transmit button is clicked
		    	
		    	// count of header line = 2 , so the data line start 
		    	for(var i=2 ; i<=sheetObj.RowCount+1 ; i++){
		    		
		    		// DEL Transmit Button is clicked
		    		if(formObj.del_trasmit_flag.value == "Y" && sheetObj.CellValue(i, "chk") == "1" ){
		    			
		    			if(document.form.hid_rcv_dt.value!="")
			    		{
			    			var sas = ComTrim(sheetObj.CellValue(i, "sa111_rst"));
			    			
			    			if(sas=="")
			    			{	
			    				ComShowCodeMessage("BKG06156"); //"There is no SAS111. Please check it again."
				    			sheetObj.SelectCell(i, "sa111_rst");
			    				return false;
			    			}
			    		}
		    		} 
		    		else if(sheetObj.CellValue(i, "chk") == "1") //Transmit Button is clicked 
					{
		    			// Don't transmit when the Booking is break bulk 
		    			if(sheetObj.CellValue(i,"bb_cgo_flg") =="Y"){
		    				ComShowCodeMessage("BKG06158", sheetObj.CellValue(i,"bl_no")); // You can't transmit the Break Bulk B/L [ {?msg1} ].
		    				return false;
		    			}
		    			
		    			// Is BKG POD equal to VVD POD?
		    			if( sheetObj.CellValue(i, "pod_cd").substr(0,2) != "JP" && (sheetObj.CellValue(i, "pod_cd") != sheetObj.CellValue(i, "bkg_pod_cd"))) {
		    				
		    				ComShowCodeMessage("BKG06157");
		    				return false;
		    			}
		    			
		    			// When type is "CMR5", dose SAS111 exist?
		    			if(sheetObj.CellValue(i, "t_s_type")=="CMR" && sheetObj.CellValue(i, "t_cmr_kind")=="5")
			    		{
			    			if(document.form.hid_rcv_dt.value!="")
			    			{
			    				var sas = ComTrim(sheetObj.CellValue(i, "sa111_rst"));
			    				
			    				if(sas=="")
			    				{	
			    					ComShowCodeMessage("BKG06156"); //"There is no SAS111. Please check it again."
				    				sheetObj.SelectCell(i, "sa111_rst");
			    					return false;
			    				}
			    			}
			    		}
		    		}
		    		
		    	}
		    	
		    	break;
	    
			//	2007.07.30 Daesung Ha - Start				
		   
		    case COMMAND02: //When New Transmit or New DEL Transmit button is clicked
		    	
		    	// count of header line = 2 , so the data line start 
		    	for(var i=2 ; i<=sheetObj.RowCount+1 ; i++){
		    		
		    		// New DEL Transmit Button is clicked
		    		if(formObj.del_new_trasmit_flag.value == "Y" && sheetObj.CellValue(i, "chk") == "1" ){
		    			
		    			if(document.form.hid_rcv_dt.value!="")
			    		{
			    			var sas = ComTrim(sheetObj.CellValue(i, "sa111_rst"));
			    			
			    			if(sas=="")
			    			{	
			    				ComShowCodeMessage("BKG06156"); //"There is no SAS111. Please check it again."
				    			sheetObj.SelectCell(i, "sa111_rst");
			    				return false;
			    			}
			    		}
		    		} 
		    		else if(sheetObj.CellValue(i, "chk") == "1") //New Transmit Button is clicked 
					{
		    			// Don't transmit when the Booking is break bulk 
		    			if(sheetObj.CellValue(i,"bb_cgo_flg") =="Y"){
		    				ComShowCodeMessage("BKG06158", sheetObj.CellValue(i,"bl_no")); // You can't transmit the Break Bulk B/L [ {?msg1} ].
		    				return false;
		    			}
		    			
		    			// Is BKG POD equal to VVD POD?
		    			if( sheetObj.CellValue(i, "pod_cd").substr(0,2) != "JP" && (sheetObj.CellValue(i, "pod_cd") != sheetObj.CellValue(i, "bkg_pod_cd"))) {
		    				
		    				ComShowCodeMessage("BKG06157");
		    				return false;
		    			}
		    			
		    			// When type is "CMR5", dose SAS111 exist?
		    			if(sheetObj.CellValue(i, "t_s_type")=="CMR" && sheetObj.CellValue(i, "t_cmr_kind")=="5")
			    		{
			    			if(document.form.hid_rcv_dt.value!="")
			    			{
			    				var sas = ComTrim(sheetObj.CellValue(i, "sa111_rst"));
			    				
			    				if(sas=="")
			    				{	
			    					ComShowCodeMessage("BKG06156"); //"There is no SAS111. Please check it again."
				    				sheetObj.SelectCell(i, "sa111_rst");
			    					return false;
			    				}
			    			}
			    		}
		    		}
		    		
		    	}
		    	
		    	break;
	    
	    }

	    return true;
	}
	
	function sheet2_OnChange(shtObj, Row, Col, Value) {
		var frmObj = document.form;
		var col_nm = shtObj.ColSaveName(Col);
		switch (col_nm) {
			case "t_s_type":
			case "t_cmr_kind":
				//@ TES_계정으로 로그인 했을 경우 테스트를 위해 머지 된 셀들을 처리 한다. 
                var bl_no     = shtObj.CellValue(Row,"bl_no");
                var sameRows  = ComFindAll(shtObj, "bl_no", bl_no).toString().split("|");    // return값이 하나일경우 숫자형이므로 "|"으로 split되지 않음에 유의
				shtObj.ReDraw = false;
				// 검색된 row index들에 대한 처리
				for (var i in sameRows) {
					if (Row != sameRows[i]) shtObj.CellValue2(sameRows[i], col_nm) = Value;
				}
				shtObj.ReDraw = true;
				break;
		}
	}
	 
/* 개발자 작업 끝 */
