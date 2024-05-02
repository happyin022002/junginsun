/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0400.js
 *@FileTitle : O.B/L Surrender Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.07.20 이진서
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
 * @class ESM_BKG_0400 : ESM_BKG_0400 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0400() {
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
var rdObjects = new Array();
var rdCnt = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var URL_ESM_BKG = 'ESM_BKG_0400GS.do';
var prefix1 = "sheet1_";
var save_success = false;
var bf_frm_sheet1_diff_rmk = "";
var bf_frm_sheet1_obl_rdem_ofc_cd = "";
var bf_frm_sheet1_obl_rdem_usr_id = "";
var bf_frm_sheet1_obl_rdem_dt = "";
var bf_frm_sheet1_obl_rdem_knt = "";
var chgExpRqst = 'N';
window.onunload=function(){	if(save_success) try{ opener.bkg_search();} catch (ex) {} }

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	//rd print 기능 추가 
	initRdConfig(rdObjects[0]);
	//document.form.frm_sheet1_bkg_no.value = 'VLCY7290026A1';
	initControl();	
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	//2009.10.12 by 전성진  * Inbound에서 inquery_only='Y'로 호출하여 저장 비활성화	
	if('Y' == ComGetObjValue(document.form.inquery_only)){
		ComBtnDisable("btn_Save");
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
* initRdConfig init 함수<br>
* @param rdObject
*/
function initRdConfig(rdObject){
	var Rdviewer = rdObject ;
	Rdviewer.style.height = 0;
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.setbackgroundcolor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);
}
/**
* initControl init 함수<br>
* 초기 컨트롤 설정하기
* @param 
*/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj); // -포커스들어갈때
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj); // - 포커스나갈때
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //- 키보드 입력할때
	axon_event.addListener('keydown', 'check_Enter', 'form');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	try {

		switch (sheetNo) {

		case 1: //t1sheet1 init
			with (sheetObj) {

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

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(19, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				var HeadTitle1 = "|||||||||||||";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
				// ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix1 + "ibflag");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_no");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_no");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_rdem_ofc_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_rdem_dt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_rdem_knt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_rdem_usr_id");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "diff_rmk");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_srnd_flg");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_iss_knt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_rlse_flg");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bl_tp_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cust_to_ord_flg");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "del_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "bkg_sts_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_iss_dt");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "obl_iss_ofc_cd");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "do_isuue");
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix1 + "cnt_cd");
				CountPosition = 0;
			}
			break;
		}

	} catch (ex) {
		bkg_error_alert('initSheet', ex);
	}
}

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {

	var formObj = document.form;
	span_bkg_no.style.display="none";
	span_bl_no.style.display="none";
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		/** * POP UP BL ISSUE (S) ** */
		case "pop_bkg_no":
			fnSetSelectNumberBox('span_bkg_no', 'text_bkg_no');
			break;

		case "pop_bl_no":
			fnSetSelectNumberBox('span_bl_no', 'text_bl_no');
			break;
		
		/** * BUTTON BL ISSUE (r) ** */			
		case "btn_Retrieve":
			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_New":
			ComResetAll();
			break;

		case "btn_Save":
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bkg_no);
				return false;
			}
			ComSetObjValue(formObj.setupfocoblflag, 'Y');//  indicator set for inbound cargo release call
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_Cancel":
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bkg_no);
				return false;
			}
			// 2010.02.25 surrender creation office와 cancel office간의 일치 여부 확인
			if( ComGetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd) != ComGetObjValue(formObj.strOfc_cd)){
				ComShowCodeMessage("BKG08138"); //User office does not correspond with surrender creation office.
				ComSetFocus(formObj.frm_sheet1_bkg_no);
				return false
			}
			ComSetObjValue(formObj.setupfocoblflag, 'Y');//  indicator set for inbound cargo release call
			doActionIBSheet(sheetObjects[0], document.form, REMOVE);
			break;
			
		case "btn_Close":
			/*팝업에서 O.B/L Receive에 Type = 'B'로 하고 팝업에서 받은 No, Date, At, By로 설정함*/
			var obj = new Object();
			obj.obl_rdem_knt = ComGetObjValue(formObj.frm_sheet1_obl_rdem_knt); //No
			obj.obl_rdem_dt = ComGetObjValue(formObj.frm_sheet1_obl_rdem_dt); //Date
			obj.obl_rdem_ofc_cd = ComGetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd); //At
			obj.obl_rdem_usr_id = ComGetObjValue(formObj.frm_sheet1_obl_rdem_usr_id); //By
			try{
				window.returnValue = obj;//retVal 변수값 설정.
			}catch(e){}
			self.close();
			
			break;
			
		/** * BUTTON BL ISSUE (l) ** */
		case "btn_ClauseSetup":
			//1. Remark 변경 여부 확인 메시지 [BKG00430] 표시
			if(ComShowConfirm(ComGetMsg("BKG00430"))){
				//<EXCEPTION>1.a Yes를 선택한 경우 Remark를 아래 항목으로 대체
				var clause_msg = "FULL SET OF ORIGINAL B/L WERE SURRENDERED TO US BY SHIPPER.\n	PLEASE RELEASE CARGO WITHOUT OB/L PRESENTATION TO MANIFESTED \n CONSIGNEE WITH DUE FREIGHT COLLECTION.";
				formObj.frm_sheet1_diff_rmk.innerHTML  = clause_msg;
			}else{
				//<EXCEPTION>1.b No를 선택한 경우 리턴
				formObj.frm_sheet1_diff_rmk.innerHTML  = "";
				return;
			}
			break;

		case "btn_Preview":
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bkg_no);
				return false;
			}
			
			formObj.com_mrdTitle.value = "O.B/L Surrender Preview"; // 해더제목값입니다.
			formObj.com_mrdBodyTitle.value = "O.B/L Surrender Preview"; // 본문제목값입니다.
			formObj.com_mrdPath.value = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0866.mrd";
			formObj.com_mrdArguments.value = "/rp [" + ComGetObjValue(formObj.bkg_no) + "] [Y]";
			
			ComOpenRDPopup("width=800, height=620");
			break;
			 
		case "btn_Print":
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bkg_no);
				return false;
			}
			
			// RD Viewer 생성
			var Rdviewer = rdObjects[0];
			var rdParam = "";
			//3. Signature 삽입여부 선택 메시지 [BKG00431] 표시
			if(ComShowConfirm(ComGetMsg("BKG00431"))){
				rdParam = "/rp [" + ComGetObjValue(formObj.bkg_no) + "] [Y]";	
			}else{
				rdParam = "/rp [" + ComGetObjValue(formObj.bkg_no) + "] [N]";	
			}
			var strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0866.mrd";			
			Rdviewer.FileOpen(strPath, RDServer + rdParam);
			Rdviewer.CMPrint();			
			break;
			
		case "btn_FaxEmail":
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bkg_no);
				return false;
			}
			
			var _Width = '980'; var _Height='700';
			var param = 'f_cmd=SEARCH&bkg_no='+ComGetObjValue(formObj.bkg_no)+"&docType=S&signFlag=Y";
			var url = "ESM_BKG_0095.do?" + param;
			ComOpenWindow(url, "BKG_Win","scroll:;dialogWidth:"+_Width+"px; dialogHeight:"+_Height+"px", true)
			
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			bkg_error_alert('fnOnSearchEnd', e);
		} else {
			ComShowMessage(e);
		}
	}
}
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array(prefix1);
	
	if (!validateForm(sheetObj, formObj, sAction)) { return;
	}
	
	switch (sAction) {

	case IBSEARCH: //조회

		formClearAll();
	
		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.				
		ComSetObjValue(formObj.f_cmd, SEARCH);
		ComSetObjValue(formObj.application_date, ComGetObjValue(formObj.frm_sheet1_obl_rdem_dt).split('-').join(""));

		// 2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

		// 3.조회후 결과처리
		var arrXml = sXml.split("|$$|");
		var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
		if ( State == "S" ) {
			for ( var inx = 0; inx < arrXml.length; inx++) {
				sheetObjects[inx].LoadSearchXml(arrXml[inx]);
			}	
			fnOnSearchEnd();
		}else{
			fnExceptionMessage(sXml);
		}
		break;

	case IBSAVE: //저장

		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.				
		ComSetObjValue(formObj.frm_sheet1_obl_srnd_flg,"Y");
		//sheet에 변경된값 셋팅하기
		if (IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_")) {
		}

		// 2.저장조건으로 실행
		var sParam = FormQueryString(formObj); // hidden param value 문자열
		if(!ComShowConfirm(ComGetMsg("BKG00498"))){
			return;
		}

		// 3.OBS 존재여부를 체크
		ComSetObjValue(formObj.f_cmd, MULTI01);
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
		var existObs = ComGetEtcData(sXml, "existObsFlg");
		var currCd = ComGetEtcData(sXml, "curr_cd");
		var scgAmt = ComGetEtcData(sXml, "scg_amt");
		var existObsFlg = "N";
		if(existObs == "Y" && scgAmt != 0){
			if(confirm(ComGetMsg("BKG02081", currCd, scgAmt))){
				// OBS를 Add 할 것인지를 판단하는 Flag
				existObsFlg = "Y";
			}else {
				// No 를 선택하더라도 우선 I/F하고, Exemption Request 화면을 통해 면제요청을 하도록 한다.
				// 저장 이후  BCC(OBS, LBP) Exemption Request 팝업을 열어줌.
				// 단, -	POR/POL country가 US 이거나, POD/DEL Country가 US인 경우 제외
				
				var input_text = ComGetObjValue(formObj.bkg_no);
			 	var param = param + "&f_cmd=" + COMMAND17 + "&input_text=" + input_text;
			 	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			 	var por_cnt_cd = ComGetEtcData(sXml, "por_cnt_cd");
			 	var pol_cnt_cd = ComGetEtcData(sXml, "pol_cnt_cd");
			 	var pod_cnt_cd = ComGetEtcData(sXml, "pod_cnt_cd");
			 	var del_cnt_cd = ComGetEtcData(sXml, "del_cnt_cd");
				
				if(por_cnt_cd != 'US' && pol_cnt_cd != 'US' && pod_cnt_cd != 'US' && del_cnt_cd != 'US' ){
					existObsFlg = 'Y';
					chgExpRqst = 'Y';
				}
					
			}
		}
		
		// 3.저장후 결과처리
		ComSetObjValue(formObj.f_cmd, MULTI);
		var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열
		sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
		sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열
		sParam += "&exist_obs_flag=" + existObsFlg; // OBS를 Add 할 것인지를 판단하는 Flag

		// 저장
		sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
		
		var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {
			if(existObs == "Y" && existObsFlg == "Y" && chgExpRqst == "N"){
				ComShowMessage(ComGetMsg("BKG02083"));
			}
			ComShowMessage(ComGetMsg("BKG06071"));
			save_success =true;
			sheetObj.LoadSaveXml(sXml);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			
			// OBS Charge 면제요청을 위한 팝업 오픈
			if(chgExpRqst == 'Y'){

				var formObj = document.form;
				var _Width = '449';
				var _Height = '460';
				var pgmNo = "&pgmNo=ESM_BKG_1600";
				var param = "bkg_no="+ComGetObjValue(formObj.bkg_no)+"&chg_cd=OBS" ;
				var url = "ESM_BKG_1600.do?" + param + pgmNo;
				ComOpenWindowCenter(url, "BKG_Win", _Width , _Height, true,true);
				chgExpRqst = 'N'
				
			}
			
			// 저장 후 창 닫음.
			window.close();
		}else{
			fnExceptionMessage(sXml);
		}
		
		break;

	case REMOVE: //취소 Cancle  

		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.			
		ComSetObjValue(formObj.f_cmd, REMOVE);
		// 2.저장조건으로 실행
		var sParam = FormQueryString(formObj); // 변경된 sheet문자열
		if(!ComShowConfirm(ComGetMsg("BKG00575"))){
			return;
		}
		
		var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열
		sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
		sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열
		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);
		
		// 3.저장후 결과처리
		var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			ComShowMessage(ComGetMsg("BKG06071"));
			save_success =true;
			sheetObj.LoadSaveXml(sXml);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else{
			fnExceptionMessage(sXml);
		}

		break;
	}
}
/**
* 화면 폼입력값에 초기화 
*/
function formClearAll(){
	var formObj = document.form;
	
	ComSetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd, '');
	ComSetObjValue(formObj.frm_sheet1_obl_rdem_dt, '');
	ComSetObjValue(formObj.frm_sheet1_obl_rdem_knt, '');
	ComSetObjValue(formObj.frm_sheet1_obl_rdem_usr_id, '');
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction) {

	if (	ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' 
		&& 	ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
		//해당 화면의 경우 메뉴에서 여는 경우 있으므로 Please input message 제외 2010.01.15 by cateshin
		//ComShowCodeMessage("BKG00445");
		ComSetFocus(formObj.frm_sheet1_bkg_no);
		return false;
	}
	
	switch (sAction) {
	case IBSEARCH: // search   

		ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_sheet1_bkg_no));
		ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_sheet1_bl_no));
		
		break;
	case IBSAVE: // save
		/** =====================================
		 *  validation 체크 : 신자영 
		 *  ===================================== */ 
			if('W' == ComGetObjValue(formObj.frm_sheet1_bl_tp_cd)){
				ComShowCodeMessage("BKG00372");
				return false;
			}
		//1.a 조회하고자 하는 BKG 번호가 WAYBILL 로 이미 발행되었다면 메시지 [BKG00372]를 표시하고 저장 비활성화
			if('Y' != ComGetObjValue(formObj.frm_sheet1_obl_rlse_flg)){
				ComShowCodeMessage("BKG08081");
				return false;
			}
		//1.b Release가 안된 경우 메시지 [BKG00373]를 표시하고 저장 비활성화 OBL_RLSE_FLG = 'N' [frm_sheet1_obl_rlse_flg]
			if('N' == ComGetObjValue(formObj.frm_sheet1_obl_rlse_flg)){
				ComShowCodeMessage("BKG00373");
				return false;
			}
		//1.c Order B/L일 경우 메시지 [BKG00374]를 표시하고 저장 비활성화
			if('Y' == ComGetObjValue(formObj.frm_sheet1_cust_to_ord_flg)){
				ComShowCodeMessage("BKG00374");
				return false;
			}

		//[Save활성화] :BL_TP_CD = 'B' && CUST_TO_ORD_FLG = 'N' && OBL_RLSE_FLG = 'Y'
		//[frm_sheet1_bl_tp_cd], [frm_sheet1_cust_to_ord_flg] ,[frm_sheet1_obl_rlse_flg]
			if(
				'B' == ComGetObjValue(formObj.frm_sheet1_bl_tp_cd)
				&& 'N' == ComGetObjValue(formObj.frm_sheet1_cust_to_ord_flg)
				&& 'Y' == ComGetObjValue(formObj.frm_sheet1_obl_rlse_flg)
			){
				ComBtnEnable("btn_Save");
			}
		
		//1. 조회한 BKG no와 현재 화면의 BKG no를 비교
		//<EXCEPTION>1.a 비교결과 다를 경우 메시지 [BKG00048] 표시후 리턴
		//"Booking Number or B/L No is changed, You can not save this booking data";
			if( ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_sheet1_bkg_no)){
				ComShowCodeMessage("BKG00048");
				return false;
			}
		//2. 이전에 Surrender 정보 입력한 부서와 현재 유저 부서의 일치 여부확인
		//<EXCEPTION>2.a 일치하지 않을 경우 메시지 [BKG00382] 표시후 리턴처리    제외요청 by 신자영 2009.10.30
		//"This O/BL Surrender Infomation is created in XXXXX. So, can not modify this information in your office XXXXX";
			//if( ComGetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd) != ComGetObjValue(formObj.strOfc_cd)){
				//ComShowCodeMessage("BKG00382");
				//return false;
			//}
		//3. Office와 DEL의 country 비교
		//<EXCEPTION>3.a 동일한 경우 메시지 [BKG00435] 표시 후 리턴
		//"The office(%s)'s country code(%s) must be different from DEL's country code(%s)";
			if( ComGetObjValue(formObj.frm_sheet1_del_cd) == ComGetObjValue(formObj.strOfc_cd)){
				ComShowCodeMessage("BKG00435");
				return false;
			}
		
		// * 날짜사이의 값을 구한다.
			var today 	= ComGetNowInfo().split('-').join("");
			var valday 	= ComGetObjValue(formObj.frm_sheet1_obl_rdem_dt).split('-').join("");
			if (ComGetDaysBetween(valday, today) > 0) {
				ComShowCodeMessage("BKG00375");
				return false;
			}
			
		// 갯수가 다를경우 리턴 
			if(!frm_sheet1_obl_rdem_knt_onChange()){
				ComSetFocus(formObj.frm_sheet1_obl_rdem_knt);
				return false;
			}
			
		//4. Issuer를 로긴 유저 정보로 변경
			ComSetObjValue(formObj.frm_sheet1_obl_rdem_usr_id, ComGetObjValue(formObj.strUsr_id) );

					
			if(bf_frm_sheet1_diff_rmk == formObj.frm_sheet1_diff_rmk.value 
			   && bf_frm_sheet1_obl_rdem_ofc_cd == formObj.frm_sheet1_obl_rdem_ofc_cd.value
			   && bf_frm_sheet1_obl_rdem_usr_id == formObj.frm_sheet1_obl_rdem_usr_id.value
			   && bf_frm_sheet1_obl_rdem_dt == formObj.frm_sheet1_obl_rdem_dt.value 
			   && bf_frm_sheet1_obl_rdem_knt == formObj.frm_sheet1_obl_rdem_knt.value) {
				ComShowMessage(ComGetMsg("BKG00737"));
				return;
			}

		break;
		
	case REMOVE: // cancle   

		
			//1. 조회한 BKG no와 현재 화면의 BKG no를 비교
			//<EXCEPTION>1.a 비교결과 다를 경우 메시지 [BKG00429] 표시후 리턴
			if( ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_sheet1_bkg_no)){
				ComShowCodeMessage("BKG00429");
				return false;
			}
		break;
	}
	return true;
}

/**
 * fnOnSearchEnd  조회완료 후 이벤트 발생 
 * param :sheetObj, ErrMsg
 */
function fnOnSearchEnd() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	try {
		if (sheetObj.TotalRows == 0) return;
		/** =====================================
		 *  FORM VALUE BINDING
		 *  ===================================== */ 
		if (IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_")) {};
		//frm_sheet1_obl_rdem_ofc_cd  : 값이 없으면 default : strOfc_cd
		ComSetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd,fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_rdem_ofc_cd),ComGetObjValue(formObj.strOfc_cd)));
		//frm_sheet1_obl_rdem_usr_id  : 값이 없으면 default : strUsr_id
		ComSetObjValue(formObj.frm_sheet1_obl_rdem_usr_id,fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_rdem_usr_id),ComGetObjValue(formObj.strUsr_id)));
		//frm_sheet1_obl_rdem_dt  값이 없으면 default : ComGetNowInfo()
		ComSetObjValue(formObj.frm_sheet1_obl_rdem_dt, fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_rdem_dt),ComGetNowInfo())); 
		bf_frm_sheet1_diff_rmk = formObj.frm_sheet1_diff_rmk.value;
		bf_frm_sheet1_obl_rdem_ofc_cd = formObj.frm_sheet1_obl_rdem_ofc_cd.value;
		bf_frm_sheet1_obl_rdem_usr_id = formObj.frm_sheet1_obl_rdem_usr_id.value;
		bf_frm_sheet1_obl_rdem_dt = formObj.frm_sheet1_obl_rdem_dt.value;
		bf_frm_sheet1_obl_rdem_knt = formObj.frm_sheet1_obl_rdem_knt.value;
		// 추가 요구사항 [신자영]
		//Date , No. of O.B/L  무조건 공백과 오늘날짜로 표시  
		//ComSetObjValue(formObj.frm_sheet1_obl_rdem_knt, '');
		//ComSetObjValue(formObj.frm_sheet1_obl_rdem_dt, ComGetNowInfo());

		//2. Surrender 안된 경우 Save 및 Fax/E-mail 버튼 비활성화
		//2.a Print :OBL_SRND_FLG = 'Y' [frm_sheet1_obl_srnd_flg]
		//2.b Fax / E-mail :OBL_SRND_FLG = 'Y' [frm_sheet1_obl_srnd_flg] 
		if('Y' == ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg)){
			ComBtnEnable("btn_Print");
			ComBtnEnable("btn_FaxEmail");
		}else{
			ComBtnDisable("btn_Print");
			ComBtnDisable("btn_FaxEmail");
		}
		
	} catch (ex) {
		bkg_error_alert('fnOnSearchEnd', ex);
		return false;
	}
}
/**
* bkgSplitNoList BKG_목록_이벤트 
* param :split_list
*/
function bkgSplitNoList(split_list){
	document.form.frm_sheet1_bkg_no.value = split_list.options[split_list.selectedIndex].value;
	span_bkg_no.style.display="none";
}
/**
* blSplitNoList BKG_목록_이벤트 
* param :split_list
*/
function blSplitNoList(split_list){
	document.form.frm_sheet1_bl_no.value = split_list.options[split_list.selectedIndex].value;
	span_bl_no.style.display="none";
}

var Select_Bkg_No_Html = null;
var Select_Bl_No_Html = null;
/**
 * fnSetSelectNumberBox 테이블생성 이벤트 
 * param :formObj_id, formObj_value=변수값,데이터1값,데이터2값
 */

function fnSetSelectNumberBox(_name, _type) {
	var vobj = eval("document.all." + _name); // SELECT 박스 위치 ID값
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var html = "";

	try {
		switch (_type) {

		case 'text_bkg_no': //text

			if (ComIsEmpty(formObj.frm_sheet1_bkg_no.value)) {
				ComShowMessage(ComGetMsg("BKG00463"));
				formObj.frm_sheet1_bkg_no.focus();
				return false;
			}

			if (null == Select_Bkg_No_Html || ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_sheet1_bkg_no)) {

				var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_sheet1_bkg_no);
				var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
				Select_Bkg_No_Html = ComGetEtcData(rXml, "bkg_split_no_list");
				if (Select_Bkg_No_Html.indexOf("<option") < 0)
					return false;

			}

			var obj = formObj.frm_sheet1_bkg_no;
			var top = document.body.clientTop + obj.offsetParent.offsetTop + obj.offsetTop + obj.offsetParent.offsetHeight + 50;
			var left = document.body.clientLeft + obj.offsetParent.offsetLeft + obj.offsetLeft + 10;

			vobj.innerHTML = Select_Bkg_No_Html;
			vobj.style.top = top;
			vobj.style.left = left;
			vobj.style.display = "inline";

			return;
			break;
		case 'text_bl_no': //text

			if (ComIsEmpty(formObj.frm_sheet1_bl_no.value)) {
				ComShowMessage(ComGetMsg("BKG00609"));
				formObj.frm_sheet1_bl_no.focus();
				return false;
			}

			if (null == Select_Bl_No_Html || ComGetObjValue(formObj.bl_no) != ComGetObjValue(formObj.frm_sheet1_bl_no)) {
				fnSetBlNoStringCheck(ComGetObjValue(formObj.frm_sheet1_bl_no));
				var param = param + "&f_cmd=" + SEARCHLIST15 + "&input_text=" + ComGetObjValue(formObj.bl_no);
				var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
				var output_text = ComGetEtcData(sXml, "output_text");
				output_text = output_text + '^' + output_text;
				Select_Bl_No_Html = fnSetSelectString('fnSetBlNo', output_text);
			}

			var obj = formObj.frm_sheet1_bl_no;
			var top = document.body.clientTop + obj.offsetParent.offsetTop + obj.offsetTop + obj.offsetParent.offsetHeight + 50;
			var left = document.body.clientLeft + obj.offsetParent.offsetLeft + obj.offsetLeft + 10;

			vobj.innerHTML = Select_Bl_No_Html;
			vobj.style.top = top;
			vobj.style.left = left;
			vobj.style.display = "inline";

			break;
	
		}
	} catch (ex) {
		bkg_error_alert('fnSetSelectNumberBox', ex);
	}
}
/**
* fnSetBlNoStringCheck BL_Number 체크 
* ComGetObjValue(formObj.frm_t11sheet1_bl_no)
* param :
*/
function fnSetBlNoStringCheck(t_bl_no) {
	var formObj = document.form;
		if(t_bl_no.length>12){
			 ComSetObjValue(formObj.bl_no, t_bl_no.substr(0,12));
		}else{
			ComSetObjValue(formObj.bl_no, t_bl_no);
		}
}
/**
 * fnSetSelectString 테이블생성 이벤트 
 * param :formObj_id, formObj_value=변수값,데이터1값,데이터2값
 */
function fnSetSelectString(_name, _value) {
	var html = "";
	try {

		var aList = _value.split("^");
		var aCode, aName;
		var aCode = aList[0].split("$");
		var aName = aList[1].split("$");
		var len = aCode.length;
		if (len == 0)
			return;

		html = "<select style='width:120;' class='input' size=5 multiple onChange='javascript:blSplitNoList(this);' name='" + _name + "'>"
		for ( var z = 0; z < len; z++) {
			html += "<option value='" + aCode[z] + "'>" + aName[z] + "</option>";
		}
		html += "</table>";

	} catch (ex) {
		bkg_error_alert('fnSetSelectString', ex);
	}
	return html;
}
/*조회조건 에터키 이력시 조회*/
function check_Enter() {
	var formObj = document.form;
	
	if (event.keyCode == 13) {
		span_bkg_no.style.display="none";
		span_bl_no.style.display="none";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}
/**
* frm_sheet1_obl_rdem_knt_onChange <br>
* 1. No. of B/L Issued와 No. of O.B/L비교
* <EXCEPTION>
* 1.a 값이 상이할 경우 Alert 메시지 [BKG00376] 표시하고 Save 비활성화
* 1.b 같을 경우 Save 활성화
* param : obj
**/
function frm_sheet1_obl_rdem_knt_onChange(obj){
	var formObj = document.form;	
	var obl_rdem_knt = fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_rdem_knt),0); //No1
	var obl_iss_knt =  fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_obl_iss_knt),0); //No2
	if(obl_rdem_knt != obl_iss_knt){
		ComShowCodeMessage("BKG00376");
		return false; 
	}
	return true; 
}
/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_deactivate() {

	//입력Validation 확인하기
	switch (event.srcElement.name) {
		case "frm_sheet1_obl_rdem_dt":
			//1.a 현재일 보다 이전일로 변경하려 할 경우 메시지 [BKG00375]표시 후 focus 처리
			ComAddSeparator(event.srcElement);
			break;
		default:
			break;
	}
}
/**
* HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
**/
function obj_activate() {
	var formObj = document.form;
	//입력Validation 확인하기
	switch (event.srcElement.name) {
	
		case "frm_sheet1_obl_rdem_dt":
			ComClearSeparator(event.srcElement);
			break;
			
		default:
			break;
	}
}
/**
* fnNullToBlank
* null값인 경우 default값을 return한다.
* param : xval,yval
*/
function fnNullToBlank(xval, yval) {
	return (xval != null && xval != "") ? xval : yval;
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
 * bkg_error_alert 
 */
function bkg_error_alert(msg, ex) {
	alert('[ ' + msg + ' ] = [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
 /**
 * fnExceptionMessage 
 */
 function fnExceptionMessage(rXml){
	var formObj = document.form;
 	var rMsg = ComGetEtcData(rXml,"Exception")
 	var rmsg = rMsg.split("<||>");
 	if(rmsg[3] != undefined && rmsg[3].length > 0) {
 		ComShowMessage(rmsg[3]);
 	}else{
 		sheetObjects[0].LoadSaveXml(rXml);
 	}
 	ComResetAll();
	ComSetFocus(formObj.frm_sheet1_bkg_no);
	
 }
/* 개발자 작업  끝 */