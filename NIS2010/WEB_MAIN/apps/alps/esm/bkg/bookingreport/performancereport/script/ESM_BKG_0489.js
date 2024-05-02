/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0489.js
 *@FileTitle : booking report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.15
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.06.15 강동윤
 * 1.0 Creation
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
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
	 * @class esm_bkg_0489 : esm_bkg_0489 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function esm_bkg_0489() {
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
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	/**
	 * 콤보 초기설정값
	 * @param {IBMultiCombo} comboObj  comboObj
	 */
	function initCombo(comboObj) {
		comboObj.DropHeight = 300;
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
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
		    initCombo(comboObjects[k]);
		}
		document.form.sr_due_dt.value = getCalculatedDate(0, 0, -1, "-");
		doActionIBSheet(sheetObjects[1], document.form, INIT);
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_transfer");
//		ComBtnDisable("btn_sitrans");
		ComBtnDisable("btn_match");
		setAmend();
		initControl();
	}
	function checkClosePage(){
		var transChkCnt = 0;
		var sheetObj = sheetObjects[1];
		var formObject = document.form;
		
		if (ComGetObjValue(formObject.sr_mtch_sts_cd) == "T"){
			return true;
		}
		if (sheetObjects[1].RowCount == 0){
			doActionIBSheet(sheetObjects[1], document.form, COMMAND04);
		}
		return true;
	}
	/**
	 * 조회조건 입력할 때 처리
	 */
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
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
//		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); //- 포커스 나갈때
		axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');//Enter key 처리
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		//window.attachEvent("onbeforeunload",checkClosePage);

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
					style.height = 0;
					//전체 너비 설정
					SheetWidth = 0;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
					var HeadTitle1 = "|Message";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					//데이터속성    [ROW, 	COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, true, "Status");
					InitDataProperty(0, cnt++, dtData, 			210, 	daCenter, true, "Massage", false, "", dfNone, 0, true, true);
				}
				break;
			case 2: //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 200;
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
					InitRowInfo(1, 1, 3, 100);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(38, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					var HeadTitle = "|Seq.|Urgency|SI Kind|Booking No.|Page(s)|VVD|POL|POD|Split|Due Date|Customer Addr|Transferred|Message||||||||||||||||||||||||";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					//데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, true, 	"ibflag");
					InitDataProperty(0, cnt++, dtSeq, 			40, 	daCenter, false, 	"Seq");
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, false, 	"sr_urg_nm", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, false, 	"sr_amd_tp_nm", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			120, 	daCenter, false, 	"bkg_no", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, false, 	"img_pg_no", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, false, 	"vvd", 			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, false, 	"pol_cd", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, false, 	"pod_cd", 		false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, false, 	"split", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, false, 	"sr_due_dt", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, false, 	"fnt_ofc_eml", 		false, "", dfNone, 0, false, true);
					
					InitDataProperty(0, cnt++, dtData, 			120, 	daCenter, false, 	"sr_wrk_sts_dt", false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 			150, 	daCenter, false, 	"diff_rmk", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 		70, 	daCenter, false, 	"split_flg", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 		70, 	daCenter, false, 	"bl_split_no", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 		70, 	daCenter, false, 	"bl_split_ttl_knt", 		false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"sr_amd_seq");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"sr_amd_rsn_tp_cd");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"sr_amd_rsn_cd");
					
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"sr_wrk_sts_cd");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"sr_wrk_sts_usr_id");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"sr_wrk_sts_usr_nm");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"sr_mtch_sts_cd");
					
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"img_file_path_ctnt");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"img_file_nm");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, 	"img_file_real_path");
					
					InitDataProperty(0, cnt++, dtHidden, 		100, 	daCenter, false, 	"sr_urg_cd");
					InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, false, 	"sr_amd_tp_cd");
					
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"sr_no");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"sr_knd_cd");
					//InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"sr_amd_seq");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"rcv_ofc_cd");
					
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"fnt_ofc_sndr_id");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"fnt_ofc_sndr_nm");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"fnt_ofc_cd");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"fax_log_ref_no");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"tot_pg_knt");
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, false, 	"fax_svr_ofc_cd");
					
					
					
					//InitUserFormat2(0, "RECEIVE", "####-##-## ##:##", "-|:" ); 
					CountPosition = 0;
					//WordWrap = true;
				}
				break;
		}
	}
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
					break;
				case "btn_new":
					//ComResetAll();
					ComSetObjValue(formObj.img_pg_no,"");
					ComSetObjValue(formObj.bkg_no,"");
					ComSetObjValue(formObj.sr_urg_cd,"N");
					ComSetObjValue(formObj.sr_amd_tp_cd,"");
					
					document.form.sr_knd_cd.value = 'F';
					ComBtnDisable("btn_del");
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_transfer");
//					ComBtnDisable("btn_sitrans");
					setAmend();
					break;
				case "btn_match":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND03);
					break;
				case "btn_del":
					doActionIBSheet(sheetObjects[1], document.form, REMOVE);
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
					break;
				case "btn_transfer":
					doActionIBSheet(sheetObjects[1], document.form, MULTI01);
					break;					
				case "btn_open":
					var downloadLocation = "";
					var downloadFileName = "";
					var url = "";
					
					if (sheetObjects[1].RowCount > 0){
						downloadLocation = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "img_file_real_path");
						downloadFileName = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "img_file_nm");
					}else{
						downloadLocation = document.form.downloadLocation.value;
						downloadFileName = document.form.downloadFileName.value;
					}
					var url = "hanjin/FileDownload?downloadLocation="+downloadLocation + "&downloadFileName="+downloadFileName;
					var host = "http://" + location.host+"/";
					
					if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
						url = "http://alpsdev.hanjin.com:9300/"+url;
					}else{
						url = host +url;
					}
					//url = "/hanjin/FileDownload?downloadLocation=c://@DUS105842700ANR107140001.tif&downloadFileName=/@DUS105842700ANR107140001.tif";
					hiddenFrame.location.href = url;
					break;
//				case "btn_transfer":
//					doActionIBSheet(sheetObjects[1], document.form, COMMAND05);
					break;
				case "btn_add":
					doActionIBSheet(sheetObjects[1], document.form, ADD);
					break;
				case "btn_chk_bkg":
					doActionIBSheet(sheetObjects[1], document.form, COMMAND02);
					break;
				case "btn_open_bkg":
					openBkg();
					break;
				case "btn_Close":
					if (checkClosePage() == false) return;
					window.close();
					break;
				case "btn_calendar":
					var cal = new ComCalendar();
					cal.select(formObject.sr_due_dt, 'yyyy-MM-dd');
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
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {
			case INIT: //open
				
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH;
				var searchXml = sheetObj.GetSearchXml("ESM_BKG_0489GS.do", FormQueryString(formObj));
			
				var arrXml = searchXml.split("|$$|");
				sheetObj.LoadSearchXml(arrXml[0]);
				
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.sr_amd_tp_cd, "val", "val|name");
				
				formObj.sr_amd_tp_cd.DropHeight = 300;
				
				formObj.fax_ip.value = sheetObj.EtcData("searchDpcsIp");
				formObj.usr_grp_cd.value = sheetObj.EtcData("usrGrpCd");
				formObj.dpcs_wrk_prt_cd.value = sheetObj.EtcData("usrRptCd");
				formObj.dpcs_wrk_svr_cd.value = sheetObj.EtcData("usrSvrCd");
				formObj.isFilePath.value = sheetObj.EtcData("isFilePath");
				
				formObj.sr_no.value 			= sheetObj.EtcData("sr_no");
				formObj.sndr_fax_no.value 		= sheetObj.EtcData("sndr_fax_no_ctnt");
				formObj.rcv_dt.value 			= sheetObj.EtcData("rcv_dt");
				formObj.transferer.value 		= sheetObj.EtcData("rcv_ofc_cd") + "/" + sheetObj.EtcData("rcv_nm");
				formObj.tot_pg_knt.value 		= sheetObj.EtcData("ttl_pg_knt");
				formObj.sr_knd_cd.value 		= sheetObj.EtcData("sr_knd_cd");
				formObj.downloadLocation.value 	= sheetObj.EtcData("img_file_real_path");
				formObj.downloadFileName.value 	= sheetObj.EtcData("img_file_nm");
				formObj.img_file_nm.value = sheetObj.EtcData("img_file_nm");
				formObj.img_file_path_ctnt.value = sheetObj.EtcData("img_file_path_ctnt");
				formObj.rcv_ofc_cd.value = sheetObj.EtcData("rcv_ofc_cd");
				formObj.fax_svr_ofc_cd.value = sheetObj.EtcData("fax_svr_ofc_cd");
								
				if (formObj.isFilePath.value == "F"){
					formObj.sr_no.className = "input_1";
				}
				break;
			case COMMAND01: //retrieve
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH01;
				var searchXml = sheetObj.GetSearchXml("ESM_BKG_0489GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveXml(searchXml);
				break;
			case COMMAND02: //check booking
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				formObj.f_cmd.value = SEARCH02;
				var searchXml = sheetObj.GetSearchXml("ESM_BKG_0489GS.do", FormQueryString(formObj));
				var check = ComGetEtcData(searchXml, "check");
				
				if (check == 'F'){
					ComShowCodeMessage("BKG00426");//Booking No is no available
					formObj.bkg_no.focus();
					return;
				}
				
				/*if (check == 'N' && ComGetObjValue(formObj.sr_amd_tp_cd) == 'A'){
					alert("This bkg no is Amend");
				}else if (check == 'A' && ComGetObjValue(formObj.sr_amd_tp_cd) != 'A'){
					alert("This bkg no is New");
				}else{
					ComShowCodeMessage("BKG08095");
				}	*/
				
				formObj.chk_bkg_no.value = formObj.bkg_no.value;
				if (check == "S"){  //SPLIT_FLG
					ComSetObjValue(formObj.sr_amd_tp_cd,"T");
				}else if (check == "C"){	//OBL_ISS_FLG
					ComSetObjValue(formObj.sr_amd_tp_cd,"B");
				}else{
					ComSetObjValue(formObj.sr_amd_tp_cd,check);
				}	
				ComSetObjValue(formObj.vvd,ComGetEtcData(searchXml, "vvd"));
				ComSetObjValue(formObj.pol_cd,ComGetEtcData(searchXml, "pol_cd"));
				ComSetObjValue(formObj.pod_cd,ComGetEtcData(searchXml, "pod_cd"));
				
				setAmend();
				ComShowCodeMessage("BKG08095");
				break;
			case COMMAND03: //Matching Complete
				if (sheetObj.RowCount <= 0)
					ComShowCodeMessage("BKG08015");//NOT Complete
				for ( var i = 1; i <= sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i, "sr_wrk_sts_dt") == ''){
						ComShowCodeMessage("BKG08018");//NOT Transfer to DC
						formObj.bkg_no.focus();
						return false;
						break;
					}
				}
				formObj.f_cmd.value = MODIFY01;
				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0489GS.do", FormQueryString(formObj));
				saveSuccessAfter(sheetObj,SaveXml,"M");
				
				
				break;
			case ADD: // ADD
				if (!chkProcess(sheetObj, formObj))
					return;
				for ( var i = 0; i <= sheetObj.RowCount; i++) {
					if (formObj.bkg_no.value == sheetObj.CellValue(i, "bkg_no")){
						ComShowCodeMessage("BKG00280");
						formObj.bkg_no.focus();
						return;
					}
					if (formObj.bkg_no.value == sheetObj.CellValue(i, "bkg_no") && formObj.img_pg_no.value == sheetObj.CellValue(i, "img_pg_no")) {
						ComShowCodeMessage("BKG08016");//The Page number you input exists on the add list. \nCheck the number and try again
						formObj.bkg_no.focus();
						return;
					}
				}
				
				//SR KIND = 'A' Reason check
				if (chkAmendValue(formObj) == false) return;
				
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.DataInsert(-1);
					for (var col = 0 ; col <= sheetObj.LastCol; col ++){
						var colName = sheetObj.ColSaveName(col);
						if (colName == "sr_urg_nm"){
							sheetObj.CellValue2(sheetObj.RowCount, colName) = formObj.sr_urg_cd[formObj.sr_urg_cd.selectedIndex].text;
						}else if (colName == "sr_amd_tp_nm"){
							sheetObj.CellValue2(sheetObj.RowCount, colName) = formObj.sr_amd_tp_cd.Text;
						}else if (colName == "sr_amd_seq"){	
							sheetObj.CellValue2(sheetObj.RowCount, colName) = "";
						}else if (colName == "split"){	
							sheetObj.CellValue2(sheetObj.RowCount, colName) = formObj.bl_split_no.value+"/"+formObj.bl_split_ttl_knt.value;
						}else if (colName == "split_flg"){	
 
							sheetObj.CellValue2(sheetObj.RowCount, colName) = formObj.sr_split.checked? 'S':'';
						}else if (colName == "fnt_ofc_eml"){	
							 
							sheetObj.CellValue2(sheetObj.RowCount, colName) = formObj.sr_customer_eml.value;
					
						}else if (eval("formObj."+colName) != undefined){
							sheetObj.CellValue2(sheetObj.RowCount, colName) = ComGetObjValue(eval("formObj."+colName))
						}
					}
					setAmendValue(formObj,sheetObj,sheetObj.RowCount);
					ComBtnEnable("btn_save");
					ComBtnDisable("btn_transfer");
					
				}	
				break;
			case IBSAVE: // Save
				/*if (!chkProcess(sheetObj, formObj))
					return;*/
				
				if (sheetObj.RowCount("I") < 1){
					return;
				}
				if (ComShowCodeConfirm("BKG95006") == false) {
					return;
				}
				if(validateForm(sheetObj,formObj,sAction)){
					var SaveStr = sheetObj.GetSaveString(false);
					if (sheetObj.IsDataModified && SaveStr == "") return;
					
					var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0489GS.do?f_cmd="+MULTI, SaveStr);
					saveSuccessAfter(sheetObj,SaveXml,"S");
				}
				break;
			case MULTI01: // Transfer to DC

				if (ComShowCodeConfirm("BKG01081") == false) {
					return;
				}
//				if(validateForm(sheetObj,formObj,sAction)){
//					var SaveStr = sheetObj.GetSaveString(true);
//					if (sheetObj.IsDataModified && SaveStr == "") return;
//					
//					var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0489GS.do?f_cmd="+MULTI01, SaveStr);
//					saveSuccessAfter(sheetObj,SaveXml,""); //?? 
// 				}
				var SaveStr = sheetObj.GetSaveString(true);

				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0489GS.do?f_cmd="+MULTI01, SaveStr+"&"+FormQueryString(formObj));	
				saveSuccessAfter(sheetObj,SaveXml,""); //?? 
				break;				
			case REMOVE: // delete
				
				if (sheetObj.CellValue(sheetObj.SelectRow , "sr_wrk_sts_dt") == ''){
					null;
				}else  if (sheetObj.CellValue(sheetObj.SelectRow , "sr_wrk_sts_dt") != ''
					&& (sheetObj.CellValue(sheetObj.SelectRow , "sr_wrk_sts_cd") == 'T'
						|| sheetObj.CellValue(sheetObj.SelectRow , "sr_wrk_sts_cd") == 'X')){ 
					null;
				}else{
					ComShowCodeMessage("BKG08119");
					return;
				}
				if (ComShowCodeConfirm("BKG00535") == false) {
					return;
				}
				
				formObj.f_cmd.value = REMOVE;
				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0489GS.do", FormQueryString(formObj));
				saveSuccessAfter(sheetObj,SaveXml,"D");
				break;
			case COMMAND04: //Close ==> W
				formObj.f_cmd.value = MODIFY04;
				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0489GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveXml(SaveXml);
				saveSuccessAfter(sheetObj,SaveXml,"W");
				break;	
//			case COMMAND05: //TRANSFER : 선택된  sheet 데이터만 처리 
//				if (ComGetObjValue(formObj.bkg_no) == ""){
//					ComShowCodeMessage("BKG00249");
//					return;
//				}
//				if (sheetObj.CellValue(sheetObj.SelectRow , "sr_wrk_sts_dt") != ''){
//					ComShowCodeMessage("BKG08037");
//					return;
//				}
//				formObj.f_cmd.value = MODIFY05;
//				var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0489GS.do", FormQueryString(formObj));
//				
//				saveSuccessAfter(sheetObj,SaveXml,"T");
//				
//				break;		
		}
	}
	function saveSuccessAfter(sheetObj,SaveXml,eventType){
		if (SaveXml != ""){
			sheetObj.LoadSaveXml(SaveXml);
		}
		
		if (sheetObj.EtcData("TRANS_RESULT_KEY") == 'S') {
			doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
			var selectedRow = ComFindAll(sheetObj, "bkg_no",formObj.bkg_no.value );
			
			if (eventType == "D" && sheetObj.RowCount > 0){
				selectedRow =  1;
			}
			sheetObjects[1].SelectCell(selectedRow,1); 
			sheet2_OnClick(sheetObjects[1], selectedRow, 1, '');
			if (eventType == 'S'){
				ComBtnDisable("btn_save");
				ComBtnEnable("btn_transfer");
//				ComBtnEnable("btn_sitrans");
			}	
			setOpenerData(SaveXml,eventType);
			if (eventType == "M"){
				if (checkClosePage() == true) window.close();
			}
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		if (formObj.sr_no.value == '') {
			ComShowCodeMessage("BKG08096"); //You Must Input S/R NO
			formObj.bkg_no.focus();
			return false;
		}
		
		with(formObj){
	      	switch(sAction) {
		     	case ADD: // 조회시 확인
			  		if (!ComChkValid(formObj)) return false;
			  		if (formObj.sr_split.checked ==true) {
			  			
			  			if(ComIsNull(formObj.bl_split_no.value) || ComIsNull(formObj.bl_split_ttl_knt.value) ) {
			  				ComShowCodeMessage("BKG00884");
			  				return false;
			  			}
			  		}
			  		
//			  		if(ComIsNull(formObj.sr_customer_eml.value)  ) {
//		  				ComShowMessage(ComGetMsg('BKG00445','Customer Addr'));		
//		  				return false;
//		  			}
			  		
			  		break;
		     	case IBSAVE: // 저장시 확인
			  		//if (!ComChkValid(formObj)) return false;
			  		break;	
	      	}	
	    }		
		return true;
	}
	/**
	 * 날짜,시간설정  
	 */
	function setCctValue(row, col, value) {
		document.form.rcv_dt.value = value;
	}
	/**
	 * open booking  
	 */
	function openBkg() {
		
		var formObj = document.form;
		var param = "?pgmNo=ESM_BKG_0079&bkg_no=" + formObj.bkg_no.value;
		ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do"+param, "ESM_BKG_0079", 1024,710, true);
	}
	/**
	 * 선택리스트 정보 입력  
	 */
	function setDocInfo(sheetObj, formObj, Row) {
		formObj.bkg_no.value = sheetObj.CellValue(Row, "bkg_no");
		formObj.chk_bkg_no.value = sheetObj.CellValue(Row,"bkg_no");
		formObj.img_pg_no.value = sheetObj.CellValue(Row, "img_pg_no");
		formObj.diff_rmk.value = sheetObj.CellValue(Row, "diff_rmk");
		formObj.sr_amd_seq.value = sheetObj.CellValue(Row, "sr_amd_seq");
		formObj.transferer.value = sheetObj.CellValue(Row, "sr_wrk_sts_usr_nm");
		formObj.sr_mtch_sts_cd.value = sheetObj.CellValue(Row, "sr_mtch_sts_cd");
		ComSetObjValue(formObj.sr_urg_cd,sheetObj.CellValue(Row, "sr_urg_cd"));
		ComSetObjValue(formObj.sr_amd_tp_cd,sheetObj.CellValue(Row, "sr_amd_tp_cd"));
		ComSetObjValue(formObj.sr_customer_eml,sheetObj.CellValue(Row, "fnt_ofc_eml"));
		
		setAmend();
		
		var amdTpCd = sheetObj.CellValue(Row, "sr_amd_rsn_tp_cd");
		var amdCd = sheetObj.CellValue(Row, "sr_amd_rsn_cd");
		var tempTpCd = amdTpCd.split(",");
		var tempCd = amdCd.split(",");
		
		for ( var i = 0; i < formObj.sr_amd_rsn.length; i++) {
			formObj.sr_amd_rsn[i].checked = false;
			for ( var j = 0; j < tempTpCd.length; j++) {
				if (tempTpCd[j] + "_" + tempCd[j] == formObj.sr_amd_rsn[i].value) {
					formObj.sr_amd_rsn[i].checked = true;
					break;
				}
			}
		}
		if (Row < 0){
			ComBtnDisable("btn_del");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_transfer");
//			ComBtnDisable("btn_sitrans");
			ComBtnDisable("btn_match");
			
		}else{
			ComBtnEnable("btn_del");
			ComBtnEnable("btn_transfer");
//			ComBtnEnable("btn_sitrans");
			ComBtnEnable("btn_match");
		}
		
		if (sheetObj.CellValue(Row, "sr_wrk_sts_dt") != ""){
			ComBtnDisable("btn_transfer");
		}
		
		if (sheetObj.CellValue(Row, "sr_amd_seq") == "" || sheetObj.CellValue(Row, "sr_mtch_sts_cd") == "T"){
			ComBtnDisable("btn_transfer");
			ComBtnDisable("btn_match");
		}
	}
	function sheet2_OnClick(sheetObj, Row, Col, Value) {
		formObj = document.form;
		setDocInfo(sheetObj, formObj, Row);
	}
	function sheet2_OnSaveEnd(sheetObj, ErrMsg) {	
		
	}
	
	function sr_amd_tp_cd_OnChange(comboObj) {
		var formObject = document.form; 
		setAmend();
	}	
	/**
	 * Amend Kind 선택  
	 */
	function setAmend() {
		formObj = document.form;
		if (ComGetObjValue(formObj.sr_amd_tp_cd) == 'A') {
			for ( var i = 0; i < formObj.sr_amd_rsn.length; i++) {
				formObj.sr_amd_rsn[i].disabled = false;
				formObj.sr_amd_rsn[i].checked = false;
			}
		} else {
			for ( var i = 0; i < formObj.sr_amd_rsn.length; i++) {
				formObj.sr_amd_rsn[i].disabled = true;
				formObj.sr_amd_rsn[i].checked = false;
			}
		}
	}
	/**
	 * Amend value setting
	 */
	function setAmendValue(formObj,sheetObj,row) {
		
		if (ComGetObjValue(formObj.sr_amd_tp_cd) == 'N') {
			//formObj.sr_amd_rsn_tp_cd.value = '';
			sheetObj.CellValue2(row,"sr_amd_rsn_tp_cd") = "";
		} else {
			var tempValue = '';
			for ( var i = 0; i < formObj.sr_amd_rsn.length; i++) {
				if (formObj.sr_amd_rsn[i].checked == true) {
					tempValue = tempValue + ":" + formObj.sr_amd_rsn[i].value;
				}
			}
			sheetObj.CellValue2(row,"sr_amd_rsn_tp_cd") = tempValue;
		}
	}
	/**
	 * Amend value check
	 */
	function chkAmendValue(formObj) {
		if (ComGetObjValue(formObj.sr_amd_tp_cd) == 'A') {
			var tempValue = '';
			for ( var i = 0; i < formObj.sr_amd_rsn.length; i++) {
				if (formObj.sr_amd_rsn[i].checked == true) {
					tempValue = tempValue + ":" + formObj.sr_amd_rsn[i].value;
				}
			}
			if (tempValue == ""){
				ComShowCodeMessage("BKG08115");
				formObj.sr_amd_rsn[0].focus();
				return false;
			}
		} 
		return true;
	}
	/**
	 * save, add validation check
	 */
	function chkProcess(sheetObj, formObj) {
		/*Page(s) check*/
		var tot_pg_knt = formObj.tot_pg_knt.value;
		var img_pg_no = ComReplaceStr(formObj.img_pg_no, "-", ",");
		
		var arrVal = img_pg_no.split(",");
		if (formObj.img_pg_no.value == '') {
			ComShowCodeMessage("BKG08022");//You Must Input page(s)
			formObj.img_pg_no.focus();
			return false;
		}
		if (arrVal.length > 2){
			ComShowCodeMessage("BKG08016");//Dose Not exist page
			formObj.img_pg_no.select();
			formObj.img_pg_no.focus();
			return false;
		}

		// 1-3 => 2
		// 2   => 1-3
		for ( var row = 1; row < sheetObj.Rows  ; row++) {
			var arrIsPg = (sheetObj.CellValue(row,"img_pg_no")).split("-");
			
			for ( var inx = 0; inx < arrVal.length; inx++) {
				
				var selectedRow = ComFindAll(sheetObj, "img_pg_no",arrVal[inx] );
				if (selectedRow > 0) {
					ComShowCodeMessage("BKG08016");//The Page number you input exists on the add list. Check the number and try again
					formObj.img_pg_no.select();
					formObj.img_pg_no.focus();
					return false;
				}
				       
				if (ComParseInt(arrVal[inx]) > ComParseInt(tot_pg_knt)) {
					ComShowCodeMessage("BKG08016");//Dose Not exist page
					formObj.img_pg_no.select();
					formObj.img_pg_no.focus();
					return false;
				}
				
				if (arrIsPg.length ==2){
					if (ComParseInt(arrIsPg[0]) <= ComParseInt(arrVal[inx]) 
							&& ComParseInt(arrIsPg[1]) >= ComParseInt(arrVal[inx])  ){
						ComShowCodeMessage("BKG08016");//The Page number you input exists on the add list. Check the number and try again
						formObj.img_pg_no.select();
						formObj.img_pg_no.focus();
						return false;
					}
				}else if (arrIsPg.length ==1){
					if (ComParseInt(arrVal[0]) <= ComParseInt(arrIsPg[inx]) 
							&& ComParseInt(arrVal[1]) >= ComParseInt(arrIsPg[inx])  ){
						ComShowCodeMessage("BKG08016");//The Page number you input exists on the add list. Check the number and try again
						formObj.img_pg_no.select();
						formObj.img_pg_no.focus();
						return false;
					}
				}
			}
		}	
		
		if (formObj.bkg_no.value == '') {
			ComShowCodeMessage("BKG00425");//Please Input B/L No or BKG No
			formObj.bkg_no.focus();
			return false;
		}
		if (formObj.bkg_no.value != formObj.chk_bkg_no.value) {
			ComShowCodeMessage("BKG08019");//Please, Check Booking No
			formObj.bkg_no.focus();
			return false;
		}
		return true;
	}
	function setOpenerData(SaveXml,eventType) {
		var opener = window.dialogArguments;
		opener.setValFromPop(SaveXml,eventType);
	}
	/**
	 * 날짜 계산 함수
	 */
	function getCalculatedDate(iYear, iMonth, iDay, seperator) {
		//현재 날짜 객체를 얻어옴
		var gdCurDate = new Date();
		//현재 날짜에 날짜 계산
		gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
		gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
		gdCurDate.setDate(gdCurDate.getDate() + iDay);
		//실제 사용할 연,월,일 변수 받기
		var giYear = gdCurDate.getFullYear();
		var giMonth = gdCurDate.getMonth() + 1;
		var giDay = gdCurDate.getDate();
		//월,일의 자릿수를 2자리로 맞춘다.
		giMonth = "0" + giMonth;
		giMonth = giMonth.substring(giMonth.length - 2, giMonth.length);
		giDay = "0" + giDay;
		giDay = giDay.substring(giDay.length - 2, giDay.length);
		//alert(giYear + seperator + giMonth + seperator + giDay);
		//display 형태 맞추기
		return giYear + seperator + giMonth + seperator + giDay;
	}  
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
        var formObj = document.form;
        switch (event.srcElement.getAttribute("name")) {
            case "sr_due_dt":
                ComAddSeparator(event.srcElement);
            break;
 
        }
    }	
    /**
     * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
     **/
    function bkg_activate() {
        //입력Validation 확인하기
        switch (event.srcElement.name) {
            case "sr_due_dt":
                ComClearSeparator(event.srcElement);
            break;
 
        }
    }    
	/* 개발자 작업  끝 */