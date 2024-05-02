/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0490.js
 *@FileTitle : ESM_BKG-0490
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.03
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
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
 * @class ESM_BKG-0490 : ESM_BKG-0490 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0490() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;

		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;

				case "btn_ViewResponse":
					var sUrl = "/hanjin/ESM_BKG_0492.do?pgmNo=ESM_BKG_0492&sr_sts_cd="+formObject.sr_sts_cd.value+"&rgst_dt="+formObject.rgst_dt.value
					+"&rjct_dt="+formObject.rjct_dt.value+"&vsl_auth_no="+formObject.vsl_auth_no.value+"&sr_sts_desc="+escape(formObject.sr_sts_desc.value)
					+"&sr_cmt_desc="+escape(formObject.sr_cmt_desc.value)+"&decl_bl_qty="+formObject.decl_bl_qty.value;
					ComOpenWindowCenter(sUrl, "ESM_BKG_0492", 400, 390, false);
				break;

				case "btn_Transmit_CTS":
					formObject.ver_flg.value = "N";
					//doActionIBSheet(sheetObject1,formObject, IBSAVE);
					if( beforetab == 0 ){
						doActionIBSheet(sheetObject1,formObject, IBSAVE);
					} else{
						doActionIBSheet(sheetObject2,formObject, IBSAVE);
					}
				break;
				
				
				case "btn_Transmit_ASYCUDA":
					formObject.ver_flg.value = "O";
					//doActionIBSheet(sheetObject1,formObject, IBSAVE);
					if( beforetab == 0 ){
						doActionIBSheet(sheetObject1,formObject, IBSAVE);
					} else{
						doActionIBSheet(sheetObject2,formObject, IBSAVE);
					}
				break;

				case "btn_MtRemoval":
					formObject.edi_mt_removal.value = "M";
					//doActionIBSheet(sheetObject1, formObject, IBSAVE);
					if( beforetab == 0 ){
						doActionIBSheet(sheetObject1,formObject, IBSAVE);
					} else{
						doActionIBSheet(sheetObject2,formObject, IBSAVE);
					}					
				break;
			} // end switch

		} catch(e) {
			if( e == "[object Error]") {
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
		for (i=0;i<sheetObjects.length;i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i], i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		for (k=0;k<tabObjects.length;k++) {
			initTab(tabObjects[k], k+1);
		}

		axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
		ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_MtRemoval");
		
		
		// 라디오 버튼 조건 체크
		for (var i = 0; i < document.form.port_flg.length; i++) {
			if (document.form.port_flg[i].checked == true) {
				document.form.port_flg[i].click();
			}
		}
	}


	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj, sheetNo) {
		var sheetID = sheetObj.id;
		var cnt = 0;

		switch(sheetID) {
			case "t1sheet1":      // t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 260;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly + msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Seq.|Sel.|B/L No.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking" +
					                 "|vsl_cd|skd_voy_no|skd_dir_cd|vvd_number|vsl_nm|carrier_no|cstms_ofc_cd|reg_no|call_port|auth_no|edi_mt_removal|crr_nm|lloyd_cd|io_bnd_cd|vvd_pol|vvd_pod";
					var HeadTitle2 = "|Seq.||B/L No.|POL|POD|DEL|Package|Package|Weight|Weight|Measure|Measure"  +
					                 "|vsl_cd|skd_voy_no|skd_dir_cd|vvd_number|vsl_nm|carrier_no|cstms_ofc_cd|reg_no|call_port|auth_no|edi_mt_removal|crr_nm|lloyd_cd|io_bnd_cd|vvd_pol|vvd_pod";

					//컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle2), 0, 0, true);

					// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
					InitHeadMode(true, true, true, true, false, false)

					//해더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++,  dtDummyCheck,	30,		daCenter,	true,	"chk");
					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,	"bl_no",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"pol_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"pod_cd",		false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"del_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			85,		daRight,	true,	"pck_qty",		false,	"",	dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"pck_tp_cd",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"act_wgt",		false,	"",	dfFloat,	3,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"wgt_ut_cd",	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"meas_qty",		false,	"",	dfFloat,	3,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"meas_ut_cd",	false,	"",	dfNone,		0,	false,	false);
					// Hidden
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"vvd_number");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"vsl_nm");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"carrier_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"customs_office_code");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"reg_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"call_port");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"auth_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"edi_mt_removal");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"crr_nm");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"lloyd_cd");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"io_bnd_cd");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"vvd_pol");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"vvd_pod");

					WaitImageVisible = false;
					// Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
					EditableColorDiff = false;
				}
				break;

			case "t2sheet1":      // t2sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 260;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly + msPrevColumnMerge;
					//MergeSheet =  msPrevColumnMerge;
					//MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Seq.|B/L No.|Sel.|Container|Container|Container|Container|Container|Container|Container|Container|Container" +
	                 					"|vsl_cd|skd_voy_no|skd_dir_cd|vvd_number|vsl_nm|carrier_no|cstms_ofc_cd|reg_no|call_port|auth_no|edi_mt_removal|crr_nm|lloyd_cd|pol_cd|io_bnd_cd|vvd_pol|vvd_pod|pod";
					var HeadTitle2 = "|Seq.|B/L No.||Container No.|CNTR TP|SEAL No.|Package|Package|Weight|Weight|Measure|Measure"+
	                 					"|vsl_cd|skd_voy_no|skd_dir_cd|vvd_number|vsl_nm|carrier_no|cstms_ofc_cd|reg_no|call_port|auth_no|edi_mt_removal|crr_nm|lloyd_cd|pol_cd|io_bnd_cd|vvd_pol|vvd_pod|pod";

					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false)

					//해더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"seq",			false,	"",	dfNone,		0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	true,	"bl_no",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++,  dtDummyCheck,	30,		daCenter,	false,	"chk");
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	true,	"cntr_no",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"cntr_tpsz_cd",	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,	"cntr_seal_no",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			85,		daRight,	true,	"pck_qty",		false,	"",	dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"pck_tp_cd",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"cntr_wgt",		false,	"",	dfFloat,	3,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"wgt_ut_cd",	false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"meas_qty",		false,	"",	dfFloat,	3,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"meas_ut_cd",	false,	"",	dfNone,		0,	false,	false);
					
					// Hidden
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"vvd_number");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"vsl_nm");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"carrier_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"customs_office_code");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"reg_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"call_port");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"auth_no");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"edi_mt_removal");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"crr_nm");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"lloyd_cd");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"pol_cd");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"io_bnd_cd");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"vvd_pol");
					InitDataProperty(0, cnt++ , dtHidden,			80,		daCenter,	true,	"vvd_pod");
					InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	"pod_cd"	);
					
				                             
					WaitImageVisible = false;
				}
				break;
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				ComOpenWait(true);
				sheetObj.HeadCheck(1, "chk") = false;
				formObj.total_cntr.value = "";
				formObj.total_bl.value = "";
				formObj.f_cmd.value = SEARCH;
				formObj.vsl_cd.value = formObj.vvd_number.value.substring(0, 4);
				formObj.skd_voy_no.value = formObj.vvd_number.value.substring(4, 8);
				formObj.skd_dir_cd.value = formObj.vvd_number.value.substring(8);
				formObj.skd_dir_cd.value = formObj.vvd_number.value.substring(8);
				if(beforetab == 0) {
					formObj.pgNo.value = "esm0490";
				} else {
					formObj.pgNo.value = "esm0490_1";
				}

				sXml = sheetObj.GetSearchXml("ESM_BKG_0490GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");

				if (arrXml.length > 0) sheetObj.LoadSearchXml(arrXml[0]);
				if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
				ComOpenWait(false);
			break;

			case IBSAVE:        //전송
				if (sheetObj.CheckedRows("chk") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return;
				}
				formObj.f_cmd.value = MULTI;
				ComOpenWait(true);
			
				var vslCd = formObj.vvd_number.value.substring(0, 4);
				var skdVoyNo = formObj.vvd_number.value.substring(4, 8);
				var skdDirCd = formObj.vvd_number.value.substring(8);
				var io_bnd_cd = "";
				
				if (formObj.pol_cd.value == "") {
					io_bnd_cd = "I";
				}else{
					io_bnd_cd = "O";
				}
				
				with (sheetObj) {
					var chkdRowArray = FindCheckedRow("chk").split("|");
					chkdRowArray.pop();    // Array에서 마지막 빈 값 삭제
					for (var k in chkdRowArray) {
						CellValue2(chkdRowArray[k], "vsl_cd") = vslCd;
						CellValue2(chkdRowArray[k], "skd_voy_no") = skdVoyNo;
						CellValue2(chkdRowArray[k], "skd_dir_cd") = skdDirCd;
						CellValue2(chkdRowArray[k], "vvd_number") = formObj.vvd_number.value;
						CellValue2(chkdRowArray[k], "vsl_nm") = formObj.vsl_nm.value;
						CellValue2(chkdRowArray[k], "carrier_no") = formObj.carrier_no.value;
						CellValue2(chkdRowArray[k], "customs_office_code") = formObj.customs_office_code.value;
						CellValue2(chkdRowArray[k], "reg_no") = formObj.reg_no.value;
						CellValue2(chkdRowArray[k], "call_port") = formObj.call_port.value;
						CellValue2(chkdRowArray[k], "auth_no") = formObj.auth_no.value;
						CellValue2(chkdRowArray[k], "edi_mt_removal") = formObj.edi_mt_removal.value;
						CellValue2(chkdRowArray[k], "crr_nm") = formObj.crr_nm.value;
						CellValue2(chkdRowArray[k], "lloyd_cd") = formObj.lloyd_cd.value;
						CellValue2(chkdRowArray[k], "io_bnd_cd") = io_bnd_cd;
				//		CellValue2(chkdRowArray[k], "vvd_pol") = formObj.pol_cd.value;  // form 입력 값은 vvd pol pod 로 들어감
				//		CellValue2(chkdRowArray[k], "vvd_pod") = formObj.pod_cd.value;
					}
				}
				
				for(var i = 1; i <= sheetObjects[1].RowCount; i++){
					sheetObjects[1].CellValue2(i, "io_bnd_cd") = io_bnd_cd;
				//	sheetObjects[1].CellValue2(i, "vvd_pol") = formObj.pol_cd.value;
			//		sheetObjects[1].CellValue2(i, "vvd_pod") = formObj.pod_cd.value;
				}

				formObj.beforetab.value = beforetab;

				var sParam ="";
				var sParamSheet2 = sheetObj.GetSaveString(false, true, "chk");
				if (sParamSheet2 != "") sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0490GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				sXml = ComDeleteMsg(sXml);
				
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				ComOpenWait(false);
			break;
		}
	}


	/**
	* IBTab Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}


	/**
	* Tab 기본 설정
	* 탭의 항목을 설정한다.
	*/
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;
					InsertTab( cnt++ , "B/L Info." , -1 );
					InsertTab( cnt++ , "CNTR Info." , -1 );
				}
			break;
		}
	}


	/**
	* Tab 클릭시 이벤트 관련
	* 선택한 탭의 요소가 활성화 된다.
	*/
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}


	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj, formObj, sAction){
		switch (sAction) {
			case IBSEARCH: // 조회
				if (formObj.vvd_number.value == "" ) {
					ComShowCodeMessage('BKG00208');
					formObj.vvd_number.focus();
					return false;
				}
				if ( formObj.call_port.value == "" && formObj.pol_cd.value =="") {
					ComShowCodeMessage('BKG00207');
					formObj.call_port.focus();
					return false;
				}
				if (formObj.vvd_number.value.length > 0 && formObj.vvd_number.value.length < 9) {
					ComShowCodeMessage('BKG00208');
					formObj.vvd_number.focus();
					return false;
				}
				if (formObj.pod_cd.value.length > 0 && formObj.pod_cd.value.length < 5) {
					ComShowCodeMessage('BKG00208');
					formObj.pod_cd.focus();
					return false;
				}
				if (formObj.call_port.value.length > 0 && formObj.call_port.value.length < 5) {
					ComShowCodeMessage('BKG00207');
					formObj.call_port.focus();
					return false;
				}
			break;
		}
		return true;
	}

	/**
	 * Enter 이벤트
	 * @return
	 */
	function obj_ComKeyEnter() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		if(srcName != "") ComKeyEnter();
	}


		/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg != "" || sheetObj.RowCount < 1)  return;
		ComEtcDataToForm(document.form, sheetObj);
		sheetObj.HeadCheck(1, "chk") = false;
//		if (document.form.cgo_tp_cd.value == "M") {
//			ComBtnDisable("btn_Transmit");
//		} else {
//			ComBtnEnable("btn_Transmit");
//		}
		ComBtnEnable("btn_Transmit");
		ComBtnEnable("btn_MtRemoval");
	}


	/**
	 * HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
	 **/
	function obj_KeyUp() {
			var formObject = document.form;
			var srcName = window.event.srcElement.getAttribute("name");
			var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
			var srcValue = window.event.srcElement.getAttribute("value");
			if (ComChkLen(srcValue, srcMaxLength) == "2") {
				ComSetNextFocus();
			}
	}

	/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			SumText(0, "Seq") = "";
			SumText(0, "BLNo") = "CNTR Total";
			CellValue(LastRow, "ContainNo") = 58;
		}
	}
	
	/**
     * 조회조건 입력할 때 처리
     */
	function obj_Clicked() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if(srcName == "port_flg"){
			if (srcValue == "pol") {
				document.form.pod_cd.value = "";
				document.form.call_port.value = "";
				document.form.del_cd.value = "";
				document.form.pod_cd.disabled = true;
				document.form.pod_cd.readonly = true;
				document.form.pol_cd.disabled = false;
				document.form.pol_cd.readonly = false;
				
				document.form.call_port.disabled = true;
				document.form.call_port.readonly = true;
				
				document.form.call_port.className = "input2";
				document.form.pol_cd.className = "input1";
				document.form.pod_cd.className = "input2";
			} else {
				document.form.pol_cd.value = "";
				document.form.del_cd.value = "LKCMB";
				document.form.pol_cd.disabled = true;
				document.form.pol_cd.readonly = true;
				document.form.pod_cd.disabled = false;
				document.form.pod_cd.readonly = false;
				
				document.form.call_port.disabled = false;
				document.form.call_port.readonly = false;
				
				document.form.call_port.className = "input1";
	    		document.form.pol_cd.className = "input2";
	    		document.form.pod_cd.className = "input1";
			}

    	}
    } 
