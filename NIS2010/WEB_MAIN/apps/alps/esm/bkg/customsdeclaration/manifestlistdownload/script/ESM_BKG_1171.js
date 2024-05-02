/*=========================================================
 *Copyright(c)2009 CyberLogitec
 *@FileName : esm_bkg_1171.js
 *@FileTitle : A/N with MRNs (FI)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.29
 *@LastModifier : 조원주
 *@LastVersion : 1.1
 * 1.0 Creation
 * ------------------------------------------------------
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
 * @class esm_bkg_1171 : esm_bkg_1171 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1171() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
var comboObjects = new Array();
var comboCnt = 0;

// 공통전역변수
var IBDOWNLOAD = "IBDOWNLOAD";
var sheetObjects = new Array();
var sheetCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// POFE에 mapping되는 YD_CD를 담아내는 배열 : form_cstms_yd_cd property에 mapping된다!
var eu_1st_port_yd_cd = new Array();



// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH); //Main
			doActionIBSheet(sheetObject1, formObject, SEARCH01); //Grid
			break;

		case "btn_new":
			doActionIBSheet(sheetObject1, formObject, IBINSERT); //Main
			sheetObject2.RemoveAll();                            //Grid
			break;
			
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
			
		case "btn_downExcel":
   	    	if(validateForm(formObject, IBDOWNLOAD)){
   	    		sheetObject2.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "0");
   	    	}
   	        break;
   	        
		case "btn_transmit":
			doActionIBSheet(sheetObject1, formObject, MULTI01);
			break;
			
		case "btn_History":
			  var row1 = sheetObject1.SelectRow;
		      var row2 = sheetObject2.SelectRow;
		      var p_vvd = sheetObject1.CellValue(row1, "vvd");	     
		      var p_pod_cd = sheetObject2.CellValue(row2, "pod");
		      var p_bl_no  = sheetObject2.CellValue(row2, "bl_no");
		      
		      ComOpenWindowCenter("/hanjin/ESM_BKG_1172.do?pgmNo=ESM_BKG_1172&p_vvd=" + p_vvd + "&p_pod_cd=" + p_pod_cd+ "&p_bl_no=" + p_bl_no, "1172", 900, 500, false);
		      
		      break;     
		      
	    case "btn_viewMsg":
	    	 var row1 = sheetObject1.SelectRow;
	    	 var row2 = sheetObject2.SelectRow;
		      if (ComIsNull(sheetObject2.CellValue(row2,"ens_result"))) {
    				ComShowCodeMessage('BKG00442');
 					return;    
		      }
		       var edi_rcv_dt = sheetObject2.CellValue(row2, "edi_rcv_dt");
		       var edi_rcv_seq = sheetObject2.CellValue(row2, "edi_rcv_seq");
		       var cnt_cd = sheetObject2.CellValue(row2, "pod").substring(0,2);
		      
		       ComOpenWindowCenter("/hanjin/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1171", 540, 600, false);//
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}

	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form);
	SetButtonStatus();
}
 /**
 * 화면 로드 시 버튼 처리
 */
function SetButtonStatus(){
	 
	
	 if(document.form.vvd.value == ''){
		ComBtnDisable("btn_transmit");
	}else{
	
//		if(document.form.form_crr_cd.value == 'SML' ){ // 2013.09.23 김인성씨 유선으로 알려줌
			
			if(document.form.form_an_edi_svc_flg.value == 'Y'){
				
				ComBtnEnable("btn_transmit");
			}else{
				ComBtnDisable("btn_transmit");
			}
//   	 	}else{
//   	 		ComBtnDisable("btn_transmit");
//   	 	}
    }
	
} 
/**
 * 화면 로딩 완료 후 이벤트
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	var formObj = document.form;
	initSheetData(sheetObjects[0], formObj);
	ComSetFocus(formObj.form_vvd_cd);
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
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
			InitRowInfo(1, 1, 3, 100);

			// var HeadTitle1 = "| |Harmonized Tariff
			// Code|Description|Category";
			var HeadTitle1 = "| |vvd|cvy_ref_no|cvy_ref_no_hidden|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|lloyd_no|piclb_desc|cstms_port_cd|eta_dt|etd_dt|n1st_port_ofc_cd|tml_cd|tml_nm|lst_clpt_cd|nxt_clpt_cd|rgst_no|rgst_dt|rgst_port_cd|grs_rgst_tong_wgt|net_rgst_tong_wgt|cre_usr_id|cre_dt|upd_usr_id|upd_dt|snd_usr_id|snd_dt|snd_ofc_cd|ack|result|cstms_yd_cd|edi_rcv_dt|edi_rcv_seq|edi_rcv_dt_msg|crr_cd|init_eta_dt|an_edi_svc_flg|port_net_no";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vvd",               false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cvy_ref_no",        false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cvy_ref_no_hidden", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vsl_cd",            false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "skd_voy_no",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "skd_dir_cd",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "vsl_eng_nm",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "lloyd_no",            false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "piclb_desc",          false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cstms_port_cd",       false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "eta_dt",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "etd_dt",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "n1st_port_ofc_cd",    false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "tml_cd",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "tml_nm",              false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "lst_clpt_cd",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "nxt_clpt_cd",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "rgst_no",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "rgst_dt",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "rgst_port_cd",       false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "grs_rgst_tong_wgt",  false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "net_rgst_tong_wgt",  false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cre_usr_id",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cre_dt",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "upd_usr_id",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "upd_dt",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "snd_usr_id",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "snd_dt",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "snd_ofc_cd",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "ack", 			   false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "result",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cstms_yd_cd",        false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "edi_rcv_dt",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "edi_rcv_seq",        false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "edi_rcv_dt_msg",     false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "crr_cd",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "init_eta_dt",        false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "an_edi_svc_flg",     false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "port_net_no",     false, "", dfNone, 0, false, false);
			
			CountPosition = 0;

			WaitImageVisible = false;
		}
		break;
		
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 280;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
			MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle1 = "|Seq.|Sel.|Transmit\nType|B/L No|POL|POD|B/POL|B/POD|DEL|CNTR No|Ack.Status|result2|Sent Time(GMT)|ENS MRN|Received Time(GMT)||edi_rcv_seq|edi_rcv_dt|bkg_no";
	        var headCount = ComCountHeadTitle(HeadTitle1);
			
			
			headCount = ComCountHeadTitle(HeadTitle1);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 5, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
			InitHeadMode(false, false, true, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			//InitHeadRow(1, HeadTitle2, true);
			
	           //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,  true,  "dt_seq",	  false,  "",  dfNone,	0,  false,  false);
			InitDataProperty(0, cnt++,  dtCheckBox,     40, daCenter,  true,  "sel",      false,  "",  dfNone,  0,  true,   false);
			InitDataProperty(0, cnt++ , dtData,  80,  daCenter,  true,  "bl_status",      false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  100, daCenter,  true,  "bl_no",          false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pol",            false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "pod",            false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "bpol",           false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "bpod",           false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  60,  daCenter,  true,  "del",            false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  80,  daCenter,  true,  "cntr_cntr_no",   false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "ens_result",     false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtHidden,  80,  daCenter,  true,  "result2",      false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  120, daCenter,  true,  "sent_time",      false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  140, daCenter,  true,  "edi_mrn",        false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtData,  120, daCenter,  true,  "received_time",  false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtHidden,100, daCenter,  true,  "dr_yn",    	  false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtHidden,100, daCenter,  true,  "edi_rcv_seq",    false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtHidden,100, daCenter,  true,  "edi_rcv_dt",     false,  "",  dfNone,  0,  false,  false);
			InitDataProperty(0, cnt++ , dtHidden,100, daCenter,  true,  "bkg_no",    	  false,  "",  dfNone,  0,  false,  false);
			
			CountPosition = 0;
			
			//InitDataCombo(0, "bl_status",	 "Original|Amendment","Original|Amendment");
			
			SetSortDialog(false	);
			//ActionMenu = "Check selected|Unheck selected"
			SelectHighLight= true;
		    MultiSelection = true;
		    SelectionMode = smSelectionRow;
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		
		formObj.f_cmd.value = SEARCH;
		
//		if(form.p_type.Code == "ENS") {
//			formObj.vvd.value = formObj.form_vvd.value;
//			formObj.cvy_ref_no.value = formObj.form_cvy_ref_no.value;
//			var cstms_yd_cd = formObj.form_cstms_yd_cd.value;
//			formObj.cstms_yd_cd.value = formObj.form_cstms_yd_cd.value;
//			
//			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1171GS.do",	FormQueryString(formObj));
//			var valResult = ComGetEtcData(sXml, "data");
//			sheetObjects[0].LoadSearchXml(sXml);
//			
//			var vvd = sheetObjects[0].CellValue(1, "vvd");
//			
//			if(vvd == "CSGP0071W" || vvd == "CSHI0074W" || vvd == "COLH0178W" || vvd == "CHKG0079W" ||  vvd == "CHAM0076W" 
//					 || vvd == "CRTM0069W" ||  vvd == "CQIN0083W"){
//				var oldDt = sheetObjects[0].CellValue(1, "init_eta_dt");
//				var timeDt = oldDt.substr(10,6);
//				var newDt = ComGetDateAdd(oldDt, "D", -1)+timeDt;
//				sheetObjects[0].CellValue2(1, "init_eta_dt") = newDt;	
//			}
//			
//			if (sheetObj.RowCount == 1) {
//				IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
//				if (cstms_yd_cd != '' && cstms_yd_cd != undefined)
//					formObj.form_cstms_yd_cd.value = cstms_yd_cd;
//			} else {
//				ComShowCodeMessage('BKG00095', "VSL Code");
//				initSheetData(sheetObj, formObj);
//				ComSetFocus(formObj.form_vvd);
//			}
		//} else { // Finland (IE344)
		    formObj.vvd.value = formObj.form_fi_vvd.value;
			formObj.port_net_no.value = formObj.form_fi_cvy_ref_no.value;
			var cstms_yd_cd = formObj.form_fi_cstms_yd_cd.value;
			formObj.cstms_yd_cd.value = formObj.form_fi_cstms_yd_cd.value;
			formObj.eur_edi_msg_tp_id.value = "347";
			var sParam = ""; 
			sParam += "cstms_port_cd="	+ formObj.form_fi_cstms_yd_cd.value	+ "&"
					//+ "p_type="			+ formObj.p_type.Code				+ "&"
					+ FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1171GS.do", sParam);
			var valResult = ComGetEtcData(sXml, "data");
			sheetObjects[0].LoadSearchXml(sXml);
			
			var vvd = sheetObjects[0].CellValue(1, "vvd");
				//sheetObj.RowCount == 1
			if (vvd != "") {
				IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
				if (cstms_yd_cd != '' && cstms_yd_cd != undefined)
					formObj.form_fi_cstms_yd_cd.value = cstms_yd_cd;
					//formObj.form_fi_eta_dt.value = formObj.form_eta_dt.value;
					//formObj.form_fi_etd_dt.value = formObj.form_etd_dt.value;
					formObj.form_fi_cvy_ref_no.value = sheetObjects[0].CellValue(1, "port_net_no");
			} else {

				ComShowCodeMessage('BKG00095');
				initSheetData(sheetObjects[0], formObj);
				ComSetFocus(formObj.form_fi_vvd);
//				formObj.form_fi_vvd.value = "";
//				formObj.form_fi_eta_dt.value = "";
//				formObj.form_fi_etd_dt.value = "";
//				//formObj.form_fi_cvy_ref_no.value = "";
//				ComSetFocus(formObj.form_fi_vvd);
			}

	//}
		SetButtonStatus();

		break;
		
		case SEARCH01: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
			formObj.f_cmd.value = SEARCH01;

		    formObj.vvd.value = formObj.form_fi_vvd.value;
			//formObj.cvy_ref_no.value = formObj.form_fi_cvy_ref_no.value;
			var cstms_yd_cd = formObj.form_fi_cstms_yd_cd.value;
			formObj.cstms_yd_cd.value = formObj.form_fi_cstms_yd_cd.value;
			formObj.eur_edi_msg_tp_id.value = "347";
			var sParam = ""; 
			sParam += "cstms_port_cd="	+ formObj.form_fi_cstms_yd_cd.value	+ "&"
					//+ "p_type="			+ formObj.p_type.Code				+ "&"
					+ FormQueryString(formObj); 
			var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_1171GS.do", sParam);
			var valResult = ComGetEtcData(sXml, "data");
			sheetObjects[1].LoadSearchXml(sXml);
		
		    SetButtonStatus();
		break;
		
	case IBINSERT: // 초기화
		initSheetData(sheetObjects[0], formObj);
		formObj.form_fi_vvd.value = "";
		formObj.form_fi_cvy_ref_no.value = "";
		ComSetFocus(formObj.form_fi_vvd);
		
		break;
	case IBSAVE: // 저장,수정
	if (!validateForm(sheetObj, formObj, sAction))
		return;
//	if(form.p_type.Code == "ENS") {
//		formObj.form_cstms_port_cd.value = comboObjects[1].Text;
//	} else { // Finland (IE344)
		formObj.form_cstms_port_cd.value = formObj.form_fi_cstms_yd_cd.value;
		formObj.form_cstms_yd_cd.value = sheetObjects[0].CellValue(1, "tml_cd");
		formObj.form_port_net_no.value = formObj.form_fi_cvy_ref_no.value; 
//	}
	IBS_CopyFormToRow(formObj, sheetObj, 1, "form_");
	ComOpenWait(true);
	formObj.f_cmd.value = MULTI;
	sheetObj.DoSave("ESM_BKG_1171GS.do", FormQueryString(formObj));
	ComOpenWait(false);
	break;
		
	case MULTI01: // 전송	
	
		if (!validateForm(sheetObj, formObj, sAction))
				return;
		
		if (sheetObjects[1].CheckedRows("sel") <= 0 ) {
	        ComShowCodeMessage("COM12189");
	        return;
	    }
		
        var sParam = ""; 

		formObj.vvd.value = formObj.form_fi_vvd.value;
		formObj.form_cstms_port_cd.value = formObj.form_fi_cstms_yd_cd.value;
	//	formObj.form_cstms_yd_cd.value = sheetObjects[0].CellValue(1, "tml_cd");
		formObj.form_port_net_no.value = formObj.form_fi_cvy_ref_no.value; 

			var arrRow = ComFindText(sheetObjects[1], "sel", 1);
			var tempBlno = "";
			
			for(var i= 0; i< arrRow.length; i++) {
				if (tempBlno == sheetObjects[1].CellValue(arrRow[i], "bl_no")) continue; //BL 같은 거 있으면 건너 뜀 (merge 기능때문에)

				    sParam += "&" +  "ibflag=U"     +"&bl_no="       +sheetObjects[1].CellValue(arrRow[i], "bl_no") 
				             +"&pod_cd="       +sheetObjects[1].CellValue(arrRow[i], "pod") 
				             +"&cstms_port_cd="	+ formObj.form_fi_cstms_yd_cd.value	
					         + "&"+ "p_type="	   +"FI"+"&";
				    formObj.f_cmd.value = MULTI01;
				    sParam += "&" + FormQueryString(formObj);

				    tempBlno = sheetObjects[1].CellValue(arrRow[i], "bl_no");
			}
			var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_1171GS.do", sParam);
			var valResult = ComGetEtcData(sXml, "flatFile");
			formObj.flatfile.value = valResult;
			var state = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
			if (state != "S"){
				ComShowCodeMessage("BKG00099"); // Failed to transmit ED!!
			}else{
				ComShowCodeMessage("BKG00101"); // Data Transmitted Successfully!!
			}
			doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
	
    

		ComOpenWait(false);
		break;

	}
 }

// 시트 데이터 초기화
function initSheetData(sheetObj, formObj) {
	
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	
	if(sheetObj.CellValue(1, "vvd_cd") != ""){
	IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: { 

			if (formObj.form_fi_vvd.value == "") {
				ComShowCodeMessage("BKG00115"); // "Please, input VVD!"
				ComSetFocus(formObj.form_fi_vvd);
				return false;
			}
		
		break;
	}
	
		
	case MULTI01: {
		
		if (!ComChkValid(formObj))	return false;

	
		if (formObj.form_n1st_port_ofc_cd.value == "") {
			ComShowCodeMessage('BKG01131');
			ComSetFocus(formObj.form_n1st_port_ofc_cd);
			return false;
		}
		
		
	}
	} // end switch
	return true;
}

/**
 * 저장 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (document.form.f_cmd.value == MULTI
				&& document.form.f_cmd_detail.value != "D") {
			ComShowCodeMessage('BKG00102');
			return false;
		}
		if (document.form.f_cmd_detail.value == "D") {
			ComShowCodeMessage('BKG00593');
			return false;
		}
	}
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

 
 
 
 /**
  * 조회후  이벤트 처리 >>> 폰트 칼라변경
  */
 function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
     
	 var formObj = document.form;
	 with (sheetObj) {
    	 
    	var rfsFlg = "N";
    	var rfsBls = "";
    	var rfsCnt = 0;  // RFS 신고 대상 개수 2개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
    	var tempBl = "";
    	var rfsBlArray = new Array();
    	 
    	  //pod별로 그룹을 묶어 pod를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
    	 MessageText("SubSum") = "POD";
         ShowSubSum("pod", "dr_yn", 0, false, false, SaveNameCol("bl_status"));
    	 
         var redColor  = RgbColor(255, 0, 0);
         var blueColor  = RgbColor(0, 0, 255);
         for(var i= HeaderRows; i<= LastRow; i++) {

                if (CellValue(i,"result2") == "DNL" || CellValue(i,"result2") == "R" || CellValue(i,"result2") == "H") {
                	CellFontColor(i,"ens_result") = redColor;
                	CellFontUnderline(i,"ens_result") = true;	
                }else if(CellValue(i,"rcv_msg") != "" || CellValue(i,"result2") == "L"){
                	CellFontColor(i,"ens_result") = blueColor;		                	
                }
  

                //if (ComGetObjValue(form.p_data_cd) == "BL") {
                	ColFontUnderline("bl_no") = true;
                	ColFontColor("bl_no") = blueColor;
                //}
                
                if (CellValue(i,"trsm_blck_flg")=="Y"){
            		CellBackColor(i,"sel") =  RgbColor(239, 240, 243);
            		// 해당 bl_no 랑 bl_status 컬럼에 가운데 줄
                    CellFont("FontStrikethru", i,"bl_status") = true;
                    CellFont("FontStrikethru", i,"bl_no") = true;
        		}
                
//                if(ComGetObjValue(formObj.p_pod_cd_temp).substring(0,5) != "FIKTK" && formObj.p_type.Code == "ENS"){
//                	if (CellValue(i,"rfs_yn") == "Y"){
//						rfsFlg = "Y";
//            			if(rfsBlArray[CellValue(i, "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
//            				rfsBlArray[CellValue(i, "bl_no")] = CellValue(i, "bl_no");
//							
//            				rfsCnt++;
//							if(rfsCnt <= 2)
//								rfsBls += CellValue(i, "bl_no")+", ";
//						}
//    				}
//					if (tempBl== CellValue(i, "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
//					tempBl = CellValue(i, "bl_no");
//                }
         }
         
         if(rfsFlg == "Y" && rfsCnt > 0){
        	 rfsBls = rfsCnt > 2 ? rfsBls+"..etc.":rfsBls.substring(0,rfsBls.length-1);
        	 // BKGs via FIKTK are selected, "BKG NO, BKG NO, ..."
        	 // Do not miss to send ENS to second POFE “FIKTK”.
//        	 second POFE alert msg 제거
//        	 ComShowCodeMessage('BKG06147',rfsBls);
         }
         
     }//end width
     pagedMaxCnt = sheetObj.LastRow;
     
     // 체크박스 초기화
     sheetObj.CheckAll2("sel") = 0;
 }	
 
 

/**
 * 폼 필드 변경시 이벤트
 * 
 * @return
 */
function obj_change() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "cstms_port_cd") {
		var comboIndex = comboObjects[1].Index;
	}
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	/*
	 * if(srcName == "form_vvd_cd" && ComChkLen(srcValue, srcMaxLength)== "2"){
	 * ComSetNextFocus(); }
	 */
}

/**
 * 컨테이너 리스트 콤보 변경시 이벤트
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cstms_port_cd_OnChange(comboObj, value, text) {
	var formObj = document.form;
	var index = comboObj.Index;
	formObj.form_cstms_yd_cd.value = eu_1st_port_yd_cd[index];
}

/**
 * Type 콤보 이벤트 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */ 
//function p_type_OnChange(comboObj, value, text){
//	if(form.p_type.Code == "ENS") {
//		document.getElementById("ensView").style.display = "Inline";
//		document.getElementById("fiView").style.display = "none";
//		ComSetDisplay("ensEtaView", true);
//		ComSetDisplay("fiEtaView", false);
//		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
//		document.form.eur_edi_msg_tp_id.value = "ARN"
//	} else if (form.p_type.Code == "FI") {
//		document.getElementById("ensView").style.display = "none";
//		document.getElementById("fiView").style.display = "Inline";
//		ComSetDisplay("ensEtaView", false);
//		ComSetDisplay("fiEtaView", true);
//		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
//		document.form.eur_edi_msg_tp_id.value = "347"
//	}
//	document.form.reset();
//	sheetObjects[0].RemoveAll();
//}
 

 /**
  * 시트를 행 다중선택 시 처리
  */
 function sheet2_OnSelectMenu(sheetObj, sAction) {

 	 //메뉴에 대한 처리 Check selected|Unheck selected|-|Check all|Uncheck all
 	  switch(sAction){
 	    case "Check selected" :
 	      var sRowStr = sheetObj.GetSelectionRows("/");
 		  
 	      //자바 스크립트 배열로 만들기
 	      var arr = sRowStr.split("/");
 	      for (i=0; i<arr.length; i++) {
 	    	  if(arr[i] < 2) continue;//header 부분
 	    	  if(sheetObj.CellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
 	    	  
 	    	  if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
 	    		  	var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(arr[i],"dt_seq"));
	  		    		for(var j =0; j <= sameRows.length ; j++) {
	  		    			if(sameRows[j] == undefined || sameRows[j] == "") continue;
	  		    			sheetObj.CellValue2(sameRows[j], "sel") = 1;		  			    		
	  		    		}
	  		    		
 	    	  }else
 	    		  sheetObj.CellValue2(arr[i], "sel") = 1;
 	      }
 	      break;
 	    case "Unheck selected" :
 	    	var sRowStr = sheetObj.GetSelectionRows("/");
 	    	
 	    	//자바 스크립트 배열로 만들기
 	    	var arr = sRowStr.split("/");
 	    	for (i=0; i<arr.length; i++) {
 	    		if(arr[i] < 2) continue;//header 부분
 	    		if(sheetObj.CellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
 	    		
 	    		if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
 	    			var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(arr[i],"dt_seq"));
 	    			for(var j =0; j <= sameRows.length ; j++) {
 	    				if(sameRows[j] == undefined || sameRows[j] == "") continue;
 	    				sheetObj.CellValue2(sameRows[j], "sel") = 0;		  			    		
 	    			}
 	    			
 	    		}else
 	    			sheetObj.CellValue2(arr[i], "sel") = 0;
 	    	}
 	      
 	      break;

 	    case "Check all" :
 	    	sheetObj.CheckAll2("sel") = 1;  break;
 	    case "Uncheck all" :
 	    	sheetObj.CheckAll2("sel") = 0;  break;
 	  }
 	  
 }
 
 var startSelectedRow =0 ; //shift + 마우스 클릭 으로 체크시키기  위함.
 /**
  * sheet1 All 체크시 체크플래그 세팅
  * @param sheetObj 시트오브젝트
  * @param Button 마우스버튼 방향
  * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
  * @param X X 좌표
  * @param Y Y 좌표
  */
 function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
 	if(Shift == 0){
 		startSelectedRow = sheetObj.FindText("dt_seq",sheetObj.CellValue(sheetObj.MouseRow,"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
 		
 		var colSaveName = sheetObj.ColSaveName(sheetObj.MouseCol);
	        var check = sheetObj.CellValue(startSelectedRow,"sel") == 0?1:0;//down일때 아직 체크박스가 바뀌기 전이므로 미리 바꾸어 놓는다.
	        var keySeq = sheetObj.CellValue(startSelectedRow,"dt_seq");
	        
	        switch(colSaveName) {
		    	case "sel" :
		    		if(startSelectedRow < 2) return;
		    		//alert(startSelectedRow +" "+check+" "+keySeq);
		    		for(i=startSelectedRow ; i<= sheetObj.LastRow ; i++) {
		    			if(eval(keySeq) < eval(sheetObj.CellValue(i, "dt_seq")) ) break;
		    				
			    		if(keySeq == sheetObj.CellValue(i, "dt_seq")) {
		    				sheetObj.CellValue(i, "sel") = check;
		    			}
		    			//alert(i+" " + keySeq+" "+sheetObj.CellValue(i, "dt_seq"));
		    		}
		    		break;
			       
	        } // end switch
 		
 	}else{
 		var endSelectedRow = sheetObj.FindText("dt_seq",sheetObj.CellValue(sheetObj.MouseRow,"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.;
 		startSelectedRow = startSelectedRow ==0 ? endSelectedRow:startSelectedRow;
	    		if(startSelectedRow > endSelectedRow){
	    			endSelectedRow = startSelectedRow;
	    			startSelectedRow = sheetObj.FindText("dt_seq",sheetObj.CellValue(sheetObj.MouseRow,"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
	    		}
	    		
	    		for (var i=startSelectedRow; i <= endSelectedRow; i++) {
	    	    	  if(i < sheetObj.HeaderRows) continue;//header 부분
	    	    	  if(sheetObj.CellValue(i,"bl_no") == "") continue;//subsum 행이면
	    	    	  
	    	    	  if(i== endSelectedRow){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
 	    		  		var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(i,"dt_seq"));
 	    		  		
 	    		  		if(sheetObjects[0].CellValue(i,"trsm_blck_flg")=="Y"){
		    	    		  sheetObj.CellValue2(i, "sel") = 0;		  			    		
		    	    		} else {
	    	    		  		for(var j =0; j <= sameRows.length ; j++) {
 	    		  				if(sameRows[j] == undefined || sameRows[j] == "") continue;
 	    		  				sheetObj.CellValue2(sameRows[j], "sel") = 1;  		
		    	    		  	}
		    	    	  }
	    	    	  }else{
	    	    		  if(sheetObjects[0].CellValue(i,"trsm_blck_flg")=="N"){
	    	    			  sheetObj.CellValue2(i, "sel") = 1;		  			    		
	    	    		  } else {
	    	    			  sheetObj.CellValue2(i, "sel") = 0;		  			    		
	    	    		  }
	    	    	  }
	    	      }
 	}//shift end
 }//method end
 
 
 /**
  * 시트를 클릭했을 때 처리 0127참조
  */
 function sheet2_OnClick(sheetObj, row, col) {
 	
 	var colSaveName = sheetObj.ColSaveName(col);
     switch(colSaveName) {
	    	case "sel" :
	    		if(sheetObj.CellValue(row,"bl_no") == "") return;//subsum 행이면
		        var check = sheetObj.CellValue(row,"sel") == 1 ?0:1;
	    		sheetObj.CellValue2(row, "sel") = check;//mousedown 에서 처리한것을 다시 역으로 처리하므로 이것을 다시 역으로 바꿔준다.
	    		break;
	    		
	    	case "ens_result":

	    	var row2 = sheetObjects[1].SelectRow;
            
	    	if (sheetObj.CellValue(row,"result2") != "R" && sheetObj.CellValue(row,"result2") != "DNL" ) {
             	return;
             }	                
	    		 
 			 //ComShowMemoPad(sheetObj, row, "rcv_msg", true, 300, 150);	//편집불가능
	    	 
		       var edi_rcv_dt  = sheetObj.CellValue(row, "edi_rcv_dt");
		       var edi_rcv_seq = sheetObj.CellValue(row, "edi_rcv_seq");
		       //var cnt_cd      = sheetObj.CellValue(row, "eu_1st_port").substring(0,2);
		       var cnt_cd = sheetObjects[1].CellValue(row2, "pod").substring(0,2);
		       ComOpenWindowCenter("/hanjin/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1171", 540, 600, false);
		       break;   
		       
     } // end switch
     
 }
 
 /**
  * Booking Creation 화면 이동
  * @param sheetObj Sheet
  * @param Row Row Index
  * @param Col Col Index
  */
 function sheet2_OnDblClick(sheetObj, row, col) {
        var colSaveName = sheetObjects[1].ColSaveName(col);
        switch(colSaveName) {
        	case "bl_no" :
//        		if (ComGetObjValue(form.p_data_cd) == "DL") {
//		            return;
//	    		}
        		ComBkgCall0079(sheetObjects[1].CellValue(row, "bkg_no"));
	    	break;
        } // end switch
 	
 }	 
/* 개발자 작업  끝 */