/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0420.js
*@FileTitle : PSA Import Status I/F
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation 
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0420()
{
	this.processButtonClick		= processButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.initSheet				= initSheet;
	this.sheet1_OnDblClick		= sheet1_OnDblClick;
	this.doActionIBSheet		= doActionIBSheet;
	this.openSpecailInfo		= openSpecialInfo;
	this.validateForm			= validateForm;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_RowAdd":
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "dcgo_flg") = "N";
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "rc_flg") = "N";
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "awk_cgo_flg") = "N";
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bb_cgo_flg") = "N";
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "rd_cgo_flg") = "N";
			
			sheetObjects[0].CellEditable(sheetObjects[0].SelectRow, "bkg_no")= true;
			sheetObjects[0].CellEditable(sheetObjects[0].SelectRow, "cntr_no")= true;
			break;

		case "btn_Delete":
			if(ComShowCodeConfirm('BKG95003', 'delete')){ 
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
			}
			break;

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;

		case "btn_SpecialInfo":
			openSpecialInfo();
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;

		case "btn_DownExcel":
			var skipRows="";
			for(var i=1; i <= sheetObjects[0].RowCount; i++) {
				if (sheetObjects[0].CellValue(i, "sel")==0) skipRows = skipRows + "|" + i ;
			}
			sheetObjects[0].Down2Excel(-1, false, false, true, "", "", false, false, "", true, "sel|seq", skipRows);
			break;

		case "btn_PrintView":
			var checked = false;
			for(var i=1; i < sheetObjects[0].RowCount; i++) {
				if (sheetObjects[0].CellValue(i, "sel")==1) {
					checked = true;
					break;
				}
			}
			if (checked==false) {				
				ComShowCodeMessage("BKG00249");
			}else {
				// 정렬
				sheetObjects[0].ColumnSort("pol_cd|pod_cd");
				ComOpenWindowCenter("/hanjin/ESM_BKG_0884.do?pgmNo=ESM_BKG_0884", "0884", 1024, 700, false);
			}
			break;

		case "btn_PSAIF":
			formObject.receiver_id.value = "PSAIMP";
			doActionIBSheet(sheetObjects[1], formObject, COMMAND01);
			break;

		case "btn_JurongIF":
			formObject.receiver_id.value = "JURONGIMP";
			doActionIBSheet(sheetObjects[1], formObject, COMMAND01);
			break;

		} // end switch
	}catch(e) {
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
function setSheetObject(sheet_obj){

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);

		ComEndConfigSheet(sheetObjects[i]);

	}

	// Key 입력 처리
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch(sheetID) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 402;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Seq.|Sel.|SPC|SAV|Container No.|TP/SZ|Booking No.|SEAL No.|POL|POD|Weight|Vgm Weight|Vgm Ind|Vgm Method|Vgm Preson|Vgm No|Vgm Time|TP|RF|DG|AK|BB|RD|FM";
			    HeadTitle1 += "|Next VVD|Next VVD|Next VVD|PSA NAME|Voyage|Port|COP|IOP|OOP|Batch No.|Send Date";
			    
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 9, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,		"ibflag");
			InitDataProperty(0,		cnt++ , dtDataSeq,			30,		daCenter,		true,		"seq");
			InitDataProperty(0,		cnt++ , dtCheckBox,			45,		daCenter,		true,		"sel",				false,		"",		dfNone,					0,		true,	true);
			InitDataProperty(0,		cnt++ , dtCheckBox,			35,		daCenter,		true,		"spc",				false,		"",		dfNone,					0,		false,	false, 1, false, false, "", false);
			InitDataProperty(0,		cnt++ , dtData,				40,		daCenter,		true,		"sav",				false,		"",		dfNone,					0,		false,	false);
			InitDataProperty(0,		cnt++ , dtData,				95,		daCenter,		true,		"cntr_no",			true,		"",		dfEngUpKey,				0,		false,	false,	11);
			InitDataProperty(0,		cnt++ , dtData,				60,		daCenter,		true,		"cntr_tpsz_cd",		true,		"",		dfEngUpKey,				0,		true,	true,	2);
			InitDataProperty(0,		cnt++ , dtData,				90,		daCenter,		true,		"bkg_no",			true,		"",		dfEngUpKey,				0,		false,	false,	12);
			InitDataProperty(0,		cnt++ , dtData,				90,		daCenter,		true,		"seal_no",			false,		"",		dfEngUpKey,				0,		true,	true,	9);
			InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"pol_cd",			false,		"",		dfEngUpKey,				0,		true,	true,	5);
			InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"pod_cd",			false,		"",		dfEngUpKey,				0,		true,	true,	5);
			InitDataProperty(0,		cnt++ , dtData,				60,		daRight,		true,		"cntr_wgt",			false,		"",		dfInteger,				0,		true,	true,	12);
			InitDataProperty(0,		cnt++ , dtData,				80,		daRight,		true,		"vgm_wgt",			false,		"",		dfInteger,				0,		true,	true,	12);			
			InitDataProperty(0,		cnt++ , dtData,				60,		daCenter,		true,		"vgm_ind",			false,		"",		dfNone,					0,		false,	false);
			InitDataProperty(0,		cnt++ , dtCombo,			80,		daCenter,		true,		"vgm_mzd_tp_cd",	false,		"",		dfNone,					0,		true,	true,	3);
			InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		"vgm_vrfy_sig_ctnt",false,		"",		dfNone,					0,		true,	true,	50);
			InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		"vgm_ref_no",		false,		"",		dfNone,					0,		false,	false);
			InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		"vgm_vrfy_dt",		false,		"",		dfNone,					0,		false,	false);
			InitDataProperty(0,		cnt++ , dtCombo,			25,		daCenter,		true,		"ts_tp_cd",			false,		"",		dfEngUpKey,				0,		true,	true,	1);
			InitDataProperty(0,		cnt++ , dtCombo,			40,		daCenter,		true,		"rc_flg",			true,		"",		dfEngUpKey,				0,		true,	true,	1);
			InitDataProperty(0,		cnt++ , dtCombo,			40,		daCenter,		true,		"dcgo_flg",			true,		"",		dfEngUpKey,				0,		true,	true,	1);
			InitDataProperty(0,		cnt++ , dtCombo,			40,		daCenter,		true,		"awk_cgo_flg",		true,		"",		dfEngUpKey,				0,		true,	true,	1);
			InitDataProperty(0,		cnt++ , dtCombo,			40,		daCenter,		true,		"bb_cgo_flg",		true,		"",		dfEngUpKey,				0,		true,	true,	1);
			InitDataProperty(0,		cnt++ , dtCombo,			40,		daCenter,		true,		"rd_cgo_flg",		true,		"",		dfEngUpKey,				0,		true,	true,	1);
			InitDataProperty(0,		cnt++ , dtCombo,			40,		daCenter,		true,		"fm_cd",			false,		"",		dfEngUpKey,				0,		true,	true,	1);
			InitDataProperty(0,		cnt++ , dtData,				40,		daCenter,		true,		"next_vsl_cd",		false,		"",		dfEngUpKey,				0,		true,	true,	4);
			InitDataProperty(0,		cnt++ , dtData,				40,		daCenter,		true,		"next_skd_voy_no",	false,		"",		dfEngUpKey,				0,		true,	true,	4);
			InitDataProperty(0,		cnt++ , dtData,				20,		daCenter,		true,		"next_skd_dir_cd",	false,		"",		dfEngUpKey,				0,		true,	true,	1);
			InitDataProperty(0,		cnt++ , dtData,				120,	daLeft,			true,		"psa_vsl_nm",		false,		"",		dfEngUpKey,				0,		false,	false);
			InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"psa_voy_dir_cd",	false,		"",		dfEngUpKey,				0,		false,	false);
			InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"port_cd",			false,		"",		dfEngUpKey,				0,		true,	true,	5);
			InitDataProperty(0,		cnt++ , dtData,				35,		daCenter,		true,		"cop",				false,		"",		dfEngUpKey,				0,		true,	true,	2);
			InitDataProperty(0,		cnt++ , dtData,				35,		daCenter,		true,		"iop",				false,		"",		dfEngUpKey,				0,		true,	true,	2);
			InitDataProperty(0,		cnt++ , dtData,				35,		daCenter,		true,		"oop",				false,		"",		dfEngUpKey,				0,		true,	true,	2);
			InitDataProperty(0,		cnt++ , dtData,				90,		daCenter,		true,		"batch_no",			false,		"",		dfEngUpKey,				0,		true,	true);
			InitDataProperty(0,		cnt++ , dtData,				55,		daCenter,		true,		"snd_dt",			false,		"",		dfDateYmd,				0,		false,	false);

			CountPosition = 0;
			InitDataCombo(0, "ts_tp_cd", "T|L", "T|L");
			InitDataCombo(0, "rc_flg", "Y|N", "Y|N");
			InitDataCombo(0, "dcgo_flg", "Y|N", "Y|N");
			InitDataCombo(0, "awk_cgo_flg", "Y|N", "Y|N");
			InitDataCombo(0, "bb_cgo_flg", "Y|N", "Y|N");
			InitDataCombo(0, "rd_cgo_flg", "Y|N", "Y|N");
			InitDataCombo(0, "fm_cd", "F|M", "F|M");
			InitDataCombo(0, "vgm_mzd_tp_cd", " |SHP|SM1|SM2|DRF", " |SHP|SM1|SM2|DRF");
			InitDataValid(0, "vgm_vrfy_sig_ctnt",	vtEngUpOther,	"1234567890 ");
		}
		break;
	case "sheet2":
		with (sheetObj) {
			
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = 0;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle1 = "|Seq";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 9, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,		"ibflag");
			InitDataProperty(0,		cnt++ , dtDataSeq,			30,		daCenter,		true,		"seq");
			CountPosition = 0;
		}
		break;


	}
}
 
/**
 * Sheet1 더블 클릭 이벤트 처리 (Special Info 조회)
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	if (Col==3) openSpecialInfo();
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0420GS.do", FormQueryString(formObj));
			formObj.vsl_nm.value     = sheetObj.EtcData("vsl_nm");
			formObj.vsl_voyage.value = sheetObj.EtcData("vsl_voyage");
			for(var i=1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, "sav")=="+") sheetObj.RowStatus(i)="I";
			}
			sheetObj.CheckAll("sel") = 1;
			ComOpenWait(false);
		}
		break;
		
//	case IBSAVE:        //저장
//		if(validateForm(sheetObj,formObj,sAction)) {
//			if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
//				formObj.f_cmd.value = MULTI;		
//				sheetObj.WaitImageVisible = false;
//				ComOpenWait(true);
//				sheetObj.DoSave("ESM_BKG_0420GS.do",  FormQueryString(formObj), -1, false);
//				ComOpenWait(false);
//			}
//		}
//		break;				

	case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction)) {
			if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
				formObj.f_cmd.value = MULTI;	
				
			    if (! sheetObj.IsDataModified ){
			    	ComShowCodeMessage('BKG00358');
    	        	return;
    	        }
			    
				sheetObj.WaitImageVisible = false;
				
				var sParam = "";
//				sParam += sheetObj.GetSaveString(false, true, "sel");
				
				sParam += ComGetSaveString(sheetObj);
				if(sParam == "") return;
				sParam += "&" + FormQueryString(formObj);
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0420GS.do",  sParam);
//				var sXml = sheetObj.GetSaveXml("ESM_BKG_0420GS.do",  FormQueryString(formObj));
//				ComOpenWait(false);
				
				var key = ComGetEtcData(sXml, "KEY");
				
				if(key == null) {
					ComOpenWait(false);
					return;
				}
				
				ComOpenWait(true);
				intervalId = setInterval(
						"doActionValidationResult(sheetObjects[0], '" + key + "');",
						3000);	
			}
			
		}
		break;

	case IBDELETE:      // 삭제
		ComRowHideDelete(sheetObj,"sel");
		break;

	case COMMAND01:		// TRANSMIT
		if(validateForm(sheetObj,formObj,sAction)) {
			if(ComShowCodeConfirm('BKG95003', 'transmit')){   // Do you want to ...?
				formObj.f_cmd.value = COMMAND01;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObj.DataInsert(-1);
				var sXml = sheetObj.doSave("ESM_BKG_0420GS.do",  FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			}
		}
		break;
		
	}
}


/**
 * BackEndJob 실행결과조회.
 */
function doActionValidationResult(sheetObj, sKey) {
	 sheetObjects[0].WaitImageVisble = false;
	 var sXml = sheetObj.GetSearchXml("ESM_BKG_0420GS.do?f_cmd=" + SEARCH03
	   + "&key=" + sKey);
	 var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	 
	 // 에러가 발생했을 경우 대기사항을 종료한다.
	 if (!ComBkgErrMessage(sheetObj, sXml)) {
	  clearInterval(intervalId);
	  ComOpenWait(false);
	  return;
	 }
	 if (sJbStsFlg == "SUCCESS") {
	  clearInterval(intervalId);
	  ComOpenWait(false);
	  // 성공메시지 보여주고
//	  ComShowCodeMessage('BKG00166');
	  ComShowMessage(ComResultMessage(sXml));
	  //재조회
	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	  // ComShowMessage(ComResultMessage(sXml));
	  return;
	 } else if (sJbStsFlg == "FAIL") {
	  //에러
	  clearInterval(intervalId);
	  ComOpenWait(false);
	  // 에러메시지 보여주고
	  ComShowMessage(ComResultMessage(sXml));
	  return;
	 }
}


/**
 * Special Info 조회 팝업 
 * @return
 */
function openSpecialInfo()
{
	if (sheetObjects[0].SelectRow > 0) {
		if (validateForm(sheetObjects[0], document.form, IBSEARCH)) {
			var params = "?pgmNo=ESM_BKG_1012&cntr_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cntr_no")
			           + "&bkg_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "bkg_no")
			           + "&vsl_cd="+document.form.vsl_cd.value
			           + "&skd_voy_no="+document.form.skd_voy_no.value
			           + "&skd_dir_cd="+document.form.skd_dir_cd.value
			           + "&select_row="+sheetObjects[0].SelectRow;
			ComOpenPopup("/hanjin/ESM_BKG_1012.do?"+params, 715, 380, "0002", "1,0", false);
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSEARCH:
			// VVD 분해
			if (vvd.value.length < 9) {
				ComShowCodeMessage("BKG00115");
				vvd.focus();
				return false;
			}
			vsl_cd.value     = vvd.value.substring(0,4);
			skd_voy_no.value = vvd.value.substring(4,8);
			skd_dir_cd.value = vvd.value.substring(8,9);
			break;
			
		case IBSAVE:
			// VVD 분해
			if (vvd.value.length < 9) {
				ComShowCodeMessage("BKG00115");
				vvd.focus();
				return false;
			}

			vsl_cd.value     = vvd.value.substring(0,4);
			skd_voy_no.value = vvd.value.substring(4,8);
			skd_dir_cd.value = vvd.value.substring(8,9);
			break;
			
		case COMMAND01:
			// VVD 분해
			if (vvd.value.length < 9) {
				ComShowCodeMessage("BKG00115");
				vvd.focus();
				return false;
			}
			vsl_cd.value     = vvd.value.substring(0,4);
			skd_voy_no.value = vvd.value.substring(4,8);
			skd_dir_cd.value = vvd.value.substring(8,9);
			break;
		}
	}

	return true;
}
