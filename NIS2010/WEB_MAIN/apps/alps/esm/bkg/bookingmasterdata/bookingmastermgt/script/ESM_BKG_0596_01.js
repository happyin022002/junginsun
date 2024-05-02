/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0596_01.js
 *@FileTitle : Manual BDR
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2009.05.21 김기종
 * 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.09.01 김영철 [CHM-201004943-01] BDR 로직보완 ( Manual BDR이 되면 DB에 로그를 남김 )
* 2011.05.18 김봉균 [CHM-201110697-01] BDR Open 권한 변경(checkBdrUser함수 추가 / 조회시 bdr open권한 여부에 따라 버튼 (비)활성화관련 로직 추가)
* 2012.09.21 김보배 [CHM-201220220] [BKG] Manual BDR 화면 POL display 순서 변경 요청
* 2014.04.01 신규정 [CHM-201429292 ]  Manual BDR 권한 설정 메뉴 신규 개발
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
 * @class esm_bkg_0596 : esm_bkg_0596 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	function esm_bkg_059601() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	// bdr open 권한 여부
	var bdrAuth ="";
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_CheckAll":
					sheetObject.CheckAll2("Check") = 1;
					break;
				case "btn_UncheckAll":
					sheetObject.CheckAll2("Check") = 0;
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;
				case "btn_BKGBDR":
					doActionIBSheet(sheetObject, formObject, IBSAVE);
					break;
				case "btn_C_BKGBDR":
					doActionIBSheet(sheetObject, formObject, REMOVE);
					break;
				case "btn_board_date":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.from_dt, formObject.to_dt,'yyyy-MM-dd');
				 	break;
				case "btn_down_excel":
					doActionIBSheet(sheetObject,formObject,COMMAND01);
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		// 로그인유저의 BDR권한 유무를 체크한다.
		checkBdrUser();
		 
		// 		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	}
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		ComBtnDisable("btn_C_BKGBDR");
//		ComBtnDisable("btn_C_VVDBDR");
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetId = sheetObj.id;
		switch (sheetId) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 382;
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
					InitRowInfo(1, 1, 19, 100);
					var HeadTitle1 = "|Sel.|No.|Booking No.|Booking No.|B/L No.|BDR Open Reason|BDR Open Reason Remark|BDR Open User|BDR Open Date|T. VVD|T. Lane|POL|POD|ETD|+@|BDR Date\n(BKG POL Local Time)|BDR|By|Office|BKG By|BKG Office|VVD By|VVD Office|VSL Cd|Skd Voy No.|Skd Dir Cd|VPS PORT CD|Total Booking|BDR Booking|Obl Iss Flag";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "Check", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "Seq");
					InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "bkg_no", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "bkg_sts_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bl_no", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,150, daCenter, false, "bdr_rsn_cd",false,"",dfNone, 0, true,  true);
					InitDataProperty(0,	cnt++, dtData,200,	daCenter,false,	"bdr_rsn_rmk",false,"",dfNone,0,true,	true);
					InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "bdr_cxl_usr_id", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 105, daCenter, false, "bdr_cxl_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "vvd_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "slan_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pol_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pod_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "etd_dt", false, "", dfUserFormat2, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bdr_dys", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "bdr_date", false, "", dfUserFormat2, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "bdr_flg", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "upd_usr_id", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "ofc_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bkg_bdr_usr_id", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "bkg_ofc_cd", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "vvd_bdr_usr_id", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "vvd_ofc_cd", false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "vsl_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 120, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "skd_dir_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "vps_port_cd", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "tot_booking_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 120, daCenter, false, "btr_booking_cnt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "obl_iss_flag", false, "", dfNone, 0, false, true);
					
					InitUserFormat2(0, "etd_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, "bdr_date", "####-##-## ##:##", "-|:");
					//CountPosition = 0;
				}
				break;
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: //조회
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = SEARCH;
					ComBtnDisable("btn_BKGBDR");
//					ComBtnDisable("btn_VVDBDR");
					ComBtnDisable("btn_C_BKGBDR");
//					ComBtnDisable("btn_C_VVDBDR");
//					sheetObj.DoSearch("ESM_BKG_0596_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
//					ComSetObjValue(formObj.vvd_bdr, sheetObj.EtcData("vvd_bdr"));
//					ComSetObjValue(formObj.tot_booking_cnt, sheetObj.EtcData("total_booking_cnt"));
//					ComSetObjValue(formObj.btr_booking_cnt, sheetObj.EtcData("btr_booking_cnt"));
					
					var rXml = sheetObj.GetSearchXml("ESM_BKG_0596_01GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return;
					}
					var arrXml = rXml.split("|$$|");
					if(arrXml.length == 2){
						// xml array
						var shtXml  = arrXml[0];
						var rsnXml  = arrXml[1];
						
						var arrData = ComBkgXml2ComboString(rsnXml, "val", "multidesc");
					    arrData[1] =" \t |"+ arrData[1].replace("|A","|A");
					    arrData[0] =" |"+ arrData[0];
					    sheetObjects[0].InitDataCombo(0,"bdr_rsn_cd", arrData[1], arrData[0]);
						// shtXml sheet
						sheetObjects[0].LoadSearchXml(shtXml, false);
					}
					// bdr open권한 여부에 따라 버튼 (비)활성화
//					if (bdrAuth == "Y") {
//						ComBtnEnable("btn_C_BKGBDR");
////						ComBtnEnable("btn_C_VVDBDR");
//					} else {
//						ComBtnDisable("btn_C_BKGBDR");
////						ComBtnDisable("btn_C_VVDBDR");					
//					}
//					if (bdrAuth == "0,0") { // 권한 없음
//						ComBtnDisable("btn_C_BKGBDR");
////						ComBtnDisable("btn_C_VVDBDR");
//						ComBtnDisable("btn_BKGBDR");
////						ComBtnDisable("btn_VVDBDR");
//						
//					} else if(bdrAuth == "0,1") { // CLOSE 권한만
//						if(ComGetObjValue(formObj.bdr_flg) == "N"){ // 조회조건 BDR = "NO"
//							if (sheetObj.RowCount > 0) {
//								ComBtnEnable("btn_BKGBDR");
//							}
//							sheetObj.CellEditable(1, "bdr_rsn_cd") = false;
//							sheetObj.CellEditable(1, "bdr_rsn_rmk") = false;
//						}
//						
//					} else if(bdrAuth == "1,0") { // OPEN 권한만
//						if(ComGetObjValue(formObj.bdr_flg) == "Y"){ // 조회조건 BDR = "YES"
//							if (sheetObj.RowCount > 0) {
//								ComBtnEnable("btn_C_BKGBDR");
//							} else {
//								ComBtnDisable("btn_C_BKGBDR");
//							}
//							sheetObj.CellEditable(1, "bdr_rsn_cd") = true;
//							sheetObj.CellEditable(1, "bdr_rsn_rmk") = true;
//						}
//						
//						
//					} 
//					
//					else { // OPEN / CLOSE 권한 모두
//						
					if(ComGetObjValue(formObj.bdr_flg) == "N"){ // 조회조건 BDR = "NO"
						if (sheetObj.RowCount > 0) {
							ComBtnEnable("btn_BKGBDR");
						} else {
							ComBtnDisable("btn_BKGBDR");
						}
						sheetObj.CellEditable(1, "bdr_rsn_cd") = false;
						sheetObj.CellEditable(1, "bdr_rsn_rmk") = false;
						
					} else if(ComGetObjValue(formObj.bdr_flg) == "Y"){ // 조회조건 BDR = "YES"
						if (sheetObj.RowCount > 0) {
							ComBtnEnable("btn_C_BKGBDR");
						} else {
							ComBtnDisable("btn_C_BKGBDR");
						}
						sheetObj.CellEditable(1, "bdr_rsn_cd") = true;
						sheetObj.CellEditable(1, "bdr_rsn_rmk") = true;
						
					}
//							
//						
//					}
					
					
				}
				break;
			case IBSAVE: //BKG_BDR
				if (ComIsBtnEnable("btn_BKGBDR") == false) {
					break;
					return;
				}
				if (validateForm(sheetObj, formObj, sAction)) {
					//1개씩만 process 타도록 
					var cnt = 0;
					for (var i=sheetObj.HeaderRows; i<=sheetObj.RowCount; i++) {
						if ("1"==sheetObj.CellValue(i,"Check")) {
							cnt = cnt+1;
						}
						if(cnt>1){
							alert("Not allowed to check multi BKGs.");
							return false;
						}
					}

					if (ComShowCodeConfirm("BKG80841")) {
						formObj.f_cmd.value = MULTI01;
						sheetObj.DoSave("ESM_BKG_0596_01GS.do", FormQueryString(formObj), -1, false);
					}
				}
				break;
			case REMOVE: //BKG_BDR CANCEL
				if (ComIsBtnEnable("btn_C_BKGBDR") == false) {
					break;
					return;
				}
				if (validateForm(sheetObj, formObj, sAction)) {
					
					//Reason이 ET일 때 remark가 10자 이상
					var bdrRsnRmk = sheetObj.CellValue(1, "bdr_rsn_rmk");
					var bdrRsnCd  = sheetObj.CellText(1, "bdr_rsn_cd");
					if(bdrRsnCd == "ET" && bdrRsnRmk.trim().length<10){
						alert("Please input BDR Open Reason Remark at least 10 Characters.");
						return false;
					}
					//Reason이 없으면 block
					if(bdrRsnCd.trim() == "" && bdrRsnCd.trim().length<1){
						alert("Please select BDR Open Reason.");
						return false;
					}
					
					//1개씩만 process 타도록 
					var cnt = 0;
					for (var i=sheetObj.HeaderRows; i<=sheetObj.RowCount; i++) {
						if ("1"==sheetObj.CellValue(i,"Check")) {
							cnt = cnt+1;
						}
						if(cnt>1){
							alert("Not allowed to check multi BKGs.");
							return false;
						}
					}
					
					if (ComShowCodeConfirm("BKG80843")) {
						formObj.f_cmd.value = MULTI03;
						sheetObj.DoSave("ESM_BKG_0596_01GS.do", FormQueryString(formObj), -1, false);
					}
				}
				break;
			case COMMAND01:
    			if (0<sheetObj.RowCount) {
    				sheetObj.SpeedDown2Excel(1);
    			} else {
    				ComShowCodeMessage("BKG00155");
    			}
    			break;	
		}
	}
	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		with (sheetObj) {
			if (RowCount > 0){
				ComSetObjValue(formObj.vsl_cd,CellValue(1, "vsl_cd"));
				ComSetObjValue(formObj.skd_voy_no,CellValue(1, "skd_voy_no"));
				ComSetObjValue(formObj.skd_dir_cd,CellValue(1, "skd_dir_cd"));
				ComSetObjValue(formObj.vps_port_cd,CellValue(1, "vps_port_cd"));
			}else{
				ComSetObjValue(formObj.vsl_cd,"");
				ComSetObjValue(formObj.skd_voy_no,"");
				ComSetObjValue(formObj.skd_dir_cd,"");
				ComSetObjValue(formObj.vps_port_cd,"");
			}
			
			for ( var i = 1; i <= LastRow; i++) {
				if (CellValue(i, "bdr_flg") == "Y") {
					CellValue2(i, "Check") = "Y";
					CellValue2(i, "ibflag") = "R";
					CellEditable(i, "Check") = false;
				}
				if (ComGetObjValue(formObj.bdr_flg) == "Y") {
					CellValue2(i, "Check") = "";
					CellValue2(i, "ibflag") = "R";
					CellEditable(i, "Check") = true;
				}
				
				DataLinkMouse("bkg_no") = true;
				ColFontUnderline("bkg_no") = true;
				ColFontColor("bkg_no") = RgbColor(2,126,148);
			}
		}
	}
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
		if (sheetObj.EtcData("TRANS_RESULT_KEY") == 'S') {
	 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 	 	
    }
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
 		var formObj = document.form;
 		
 		var colName = sheetObj.ColSaveName(Col);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(Value);
 		}
 	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		if (ComGetObjValue(formObj.bkg_no) == "" && ComGetObjValue(formObj.from_dt) == "" && ComGetObjValue(formObj.to_dt) == "") {
			alert("Mandatory item is missing. Please check it again. (BKG NO. or Period)");
			return false;
		}
		if (!ComChkValid(formObj))
			return false;
		return true;
	}
	
    /**
     * Login 한 User Check : 유저가 BDR권한을 가지고 있는지 체크한다.(결과값이 1:OPEN/CLOSE, 2:CLOSE, N:권한 무)
     */
    function checkBdrUser(){
    	var output_text ="";
    	var param = "f_cmd=" + SEARCH09;
		var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
		bdrAuth = ComGetEtcData(sXml, "output_text");
   }
    
	/* 개발자 작업  끝 */