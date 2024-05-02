/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0422.js
 *@FileTitle : Queue List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.21 김경섭
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.05.11 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면에서 호출할 때 하단 버튼들 숨김
 * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면에서 호출할 때 (수정)
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
 * 2011.11.30 정선용 [CHM-201114554-01] DPCS-Correction 기능 보완 요청
 * 2012.04.06 변종건 [CHM-201217121-01] SI Turn Time Report 보완
 * 2012.01.07 조정민 [CHM-201221961] Email 접수 Draft B/L Correction 분류 시스템 개발
 * 2013.02.04 김진주 [CHM-201322653] Pending부킹에 한해 DPCS Queue List 상 Queue Details의 Retrieve 버튼 비활성화(삭제)
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
 * @extends 
 * @class esm_bkg_0422  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0422() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnKeyUp = sheet1_OnKeyUp;
	this.setComboObject = setComboObject;
}

/* 개발자 작업	*/
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// 공통전역변수
var rdObjects = new Array();
var rdCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;
var rowsPerPage = 50;

var prefix = "sheet1_";//IBSheet 구분자
var prefix2 = "sheet2_";//IBSheet 구분자

var bkgWinObj;

var grp_cd = "";//Current Queue 조회를 위한 전역변수  
var return_cd = "";//현재 bkg_no가 리턴 상태인지 여부  
var fo_flg = "";
var intervalId;
var intervalTime = 60000; // 1000 = 1초  60000 = 1분
var processCnt = 0;
var queueMap = new Array();

/*********************** EDTITABLE MULIT COMBO START ********************/
var comboCnt = 0;
var comboObjects = new Array();

var arrWindow = new Array(null,null); 

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
//ComComboObject생성자 메소드에서 호출됨
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/*********************** EDTITABLE MULIT COMBO END********************/
               
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
	//멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다

	var formObj = document.form;
	
	if (formObj.ui_id.value == "ESM_BKG_0067" || formObj.ui_id.value == 'ESM_BKG_0435' || formObj.ui_id.value == 'ESM_BKG_0079') {
		document.getElementById("table_btn").style.display = "none";
	}
    var formObj = document.form;
    // BKG Main에서 호출 
    if(formObj.ui_id.value == 'ESM_BKG_0079' && !ComIsNull(formObj.bkg_no.value)){
        var sheetObject2 = sheetObjects[1];
        doActionIBSheet(sheetObject2,formObj,SEARCH11);
        if (sheetObject2.RowCount < 1) {
            ComShowCodeMessage("BKG00495");
            return;
        }
    	formObj.sr_kind.value         =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"sr_kind_cd");
    	formObj.sr_no.value           =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"sr_no");
    	formObj.pnd_flg.value         =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"pnd_flg");
    	formObj.grp_cd.value          =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"grp_cd");
    	formObj.usr_id.value          =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"strUsr_id");
    	formObj.usr_nm.value          =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"strUsr_nm");
    	formObj.src_cd.value          =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"src_cd");
    	formObj.sr_crnt_info_cd.value =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"sr_crnt_info_cd");
    	formObj.sr_crnt_sts_cd.value  =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"sr_crnt_sts_cd");
    	formObj.xter_sndr_id.value    =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"xter_sndr_id");
    	formObj.sr_wrk_sts_cd.value   =sheetObject2.CellValue(sheetObject2.HeaderRows,prefix2+"sr_wrk_sts_cd");
    	formObj.row_idx.value         =1;
    }
//    document.getElementById("table_btn").style.display = ""; // ----------------- TEST Code
//    formObj.ui_id.value = 'ESM_BKG_0000';                    // ----------------- TEST Code
    
	inintSearch();
	
	//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	//form.p_vvd.focus();		    		    		   
	if (formObj.ui_id.value == "ESM_BKG_0079" || formObj.ui_id.value == "ESM_BKG_0067" || formObj.sr_wrk_sts_cd.value == "D") {
		fnBtnObjDisplay("" ,false);
		return;
	}

	if (formObj.sr_wrk_sts_cd.value == "W"  && ComGetObjValue(formObj.sr_wrk_sts_usr_id) != ComGetObjValue(formObj.usr_id)  ) {
		ComShowCodeMessage("COM12114", "STS"); //Please check {?msg1}
		//window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_cd") = "W";
		//window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_usr_id") = formObj.sr_wrk_sts_usr_id.value;
		ComSetObjValue(formObj.sr_wrk_sts_cd,"");
		window.close();
	} else {
		setStsCd("S");
	}
	
	initInterval();
	

}

function initInterval(){
    intervalId = setInterval(callIntervalAutoClose, intervalTime);
    processCnt = 0;	
}

/*
 * 화면 Open시  버튼 초기화 
 * */
function inintButton() {
	if (form.ui_id.value == "ESM_BKG_0425" || grp_cd == "" || grp_cd == "S") {
		ComBtnDisable("btn_bkg");
		//ComBtnDisable("btn_fax");	 		
		ComBtnDisable("btn_completed");
		ComBtnDisable("btn_return");
		ComBtnDisable("btn_pending");
		ComBtnDisable("btn_return_to_return");
	}
}

/**
 * 버튼 비활성화 
 * */

function ComBtnDisable(val) {
	eval(val + "_l").className = "btn2_left";
	eval(val + "_c").className = "btn2";
	eval(val + "_r").className = "btn2_right";
}

function fnBtnObjDisplay(obj,flag){
	if (obj == "") obj = new Array("div_bkg","div_fax","div_input_completed","div_rating_completed","div_qa_completed","div_return","div_return_to_return","div_unpending","div_pending","div_retrieve");
	for(i=0;i<obj.length;i++){
		ComSetDisplay(obj[i],flag);  
	}
}	
/*
 * 화면 Open시 조회 
 * */
function inintSearch() {

	var formObj = document.form;

	if (formObj.bkg_no.value == null || formObj.bkg_no.value == '') {
		ComShowCodeMessage('BKG00626', 'Booking No');
		form.bkg_no.focus();
		return;
	}
	fnBtnObjDisplay("" ,false);
	doActionIBSheet(sheetObjects[0], form, SEARCH01);
	doActionIBSheet(sheetObjects[0], form, SEARCH02);
	doActionIBSheet(sheetObjects[0], form, IBSEARCH);
}

function initControl() {
	var formObject = document.form;

	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- 키보드 입력할때
	axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate', formObject); //- 포커스 나갈때     
	axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); //- 포커스 들어갈때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/*********************** KEY EVENT START ********************/
function bkg_keypress() {
	switch (event.srcElement.dataformat) {
		case "ymd":
			//number
			ComKeyOnlyNumber(event.srcElement, "-");
			break;
		case "engup":
			//영문대문자
			ComKeyOnlyAlphabet('upper');
			break;
		case "engupnum":
			//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "num":
			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "custname":
			//숫자 입력하기
			ComKeyOnlyAlphabet('uppernum', '40|41|46|44|32|42|38|35|45');
			break;
		default:
	}
}

/**
 * HTML Control의 onBlur을 제어한다.
 **/
function bkg_deactivate() {

	var formObj = document.form;
	switch (event.srcElement.getAttribute("name")) {
		case "dura_from_dt":
			ComAddSeparator(event.srcElement);
			break;
		case "dura_to_dt":
			ComAddSeparator(event.srcElement);
			break;

		default:
			break;
	}
}

/**
 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
 **/
function bkg_activate() {
	//입력Validation 확인하기
	switch (event.srcElement.name) {
		case "dura_from_dt":
			ComClearSeparator(event.srcElement);
			break;
		case "dura_to_dt":
			ComClearSeparator(event.srcElement);
			break;
		default:
			break;
	}
}

/*********************** KEY EVENT END ********************/

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	var comboObject1 = comboObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {

		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_Retrieve":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], form, SEARCH03);
				doActionIBSheet(sheetObjects[0], form, SEARCH01);
				doActionIBSheet(sheetObjects[0], form, SEARCH02);
				doActionIBSheet(sheetObjects[0], form, IBSEARCH);

				break;
			case "btn_bkg":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], form, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				if (ComGetObjValue(formObject.sr_amd_tp_cd) == "B"){
					if (ComShowCodeConfirm("BKG01167") == true){
						ComSetObjValue(formObject.call_pgm_type,ComGetObjValue(formObject.sr_amd_tp_cd));
						doActionIBSheet(sheetObjects[0],formObject, MODIFY04);
						break;
					}
				}
				//BKG 정보를 조회 여부를 관리하는 전역변수
//				alert('src_cd:'+formObject.src_cd.value);
//				alert('xter_sndr_id:'+formObject.xter_sndr_id.value);
				if (formObject.src_cd.value == "E" || formObject.src_cd.value == "S" ||
						(formObject.src_cd.value == "M" &&  formObject.xter_sndr_id.value == "EML"   ) ||//2011.08.16 jsy||
						(formObject.src_cd.value == "U" &&  formObject.xter_sndr_id.value == "ULD"   )
				   ) {
					if (ComGetObjValue(formObject.sr_amd_tp_cd) == "E" 
							|| ComGetObjValue(formObject.sr_amd_tp_cd) == "C" 
								|| ComGetObjValue(formObject.sr_amd_tp_cd) == "I"){
						
						var pType = "";
						if (ComGetObjValue(formObject.sr_amd_tp_cd) == "E"){
							pType = "AES";	
						}else 	if (ComGetObjValue(formObject.sr_amd_tp_cd) == "C"){
							pType = "CAED";
						}else 	if (ComGetObjValue(formObject.sr_amd_tp_cd) == "I"){
							pType = "IE";
						}	
						if (ComShowCodeConfirm("BKG01168",pType) == true){
							ComSetObjValue(formObject.call_pgm_type,ComGetObjValue(formObject.sr_amd_tp_cd));
							doActionIBSheet(sheetObjects[0],formObject, MODIFY04);
							break;
						}
					}
						
					var param = "?bkg_no=" + encodeURIComponent(formObject.bkg_no.value) + "&pgmNo=ESM_BKG_0229";
					param += "&rqst_no=" + encodeURIComponent(formObject.xter_rqst_no.value);
					param += "&rqst_seq=" + encodeURIComponent(formObject.xter_rqst_seq.value);
					param += "&sender_id=" + encodeURIComponent(formObject.xter_sndr_id.value);
					param += "&fax_log_ref_no=" + encodeURIComponent(formObject.fax_log_ref_no.value);
					param += "&sr_knd_cd=" + encodeURIComponent(formObject.sr_knd_cd.value);
					param += "&tmplt_par_rto=" + encodeURIComponent(formObject.tmplt_par_rto.value);
					param += "&xter_rqst_via_cd="+ encodeURIComponent(formObject.xter_sndr_id.value);
					
//					var winIdx = openUploadWindowCheck();
//					if( winIdx > 0){
//						ComShowMessage(msgs['BKG95043']);
//						return false;
//					}else{
//						arrWindow[winIdx] = 
					
					    var _text = "";
					    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
					    for( var i=0; i < 5; i++ ) _text += possible.charAt(Math.floor(Math.random() * possible.length));
							
					    ComOpenWindowCenter("/hanjin/ESM_BKG_0229.do" + param, "PopupEsmBkgMain"+_text, 1025, 720, false, "yes");
//					}
				} else {

					var param = "?bkg_no=" + formObject.bkg_no.value + "&pgmNo=ESM_BKG_0079";
//					arrWindow[winIdx] = ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkgMain", 1025, 720, false, "yes");
					var _text = "";
				    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
				    for( var i=0; i < 5; i++ ) _text += possible.charAt(Math.floor(Math.random() * possible.length));
				    ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do" + param, "PopupEsmBkgMain"+_text, 1025, 720, false, "yes");
					
				}

				break;
			case "btn_fax":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				if (grp_cd == "" || grp_cd == "S")
					return;

				openUi();
				break;
			case "btn_input_completed":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				//if(grp_cd == "" ||grp_cd == "S" || return_cd =='R') return;
				
				//SR Kind=AES,CAED,IE의 경우에는 관련정보만 입력한 후에는 "Input Complete"클릭가능토록 하고
				if (formObject.us_inp_flg.value == "N" && formObject.ca_inp_flg.value == "N"){
					doActionIBSheet(sheetObjects[0], form, SEARCH03);
					if (formObject.input_flg.value == "N") {
						ComShowCodeMessage("BKG08116");//B/L data (Customer, M&D, C/M) is not available.
						return;
					}
				}
				if (formObject.bl_doc_inp_flg.value == "Y")
					return;
				formObject.com_flg.value = 'inp';
				doActionIBSheet(sheetObject1, formObject, MODIFY01);
				try{//조회용도로 팝업 띄울 때 opener 예외 처리
					window.opener.sheetObjects[0].CellValue(formObject.row_idx.value, "sheet1_bl_doc_inp_flg") = "Y";
				}catch(e){
				}
				break;
			case "btn_rating_completed":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				//if(grp_cd == "" ||grp_cd == "S" || return_cd =='R') return;
				doActionIBSheet(sheetObjects[0], form, SEARCH03);

				if (formObject.rate_flg.value == "N") {
					ComShowCodeMessage("BKG08117");//Charge data is not available.
					return;
				}

				if (formObject.bl_rt_flg.value == "Y")
					return;
				formObject.com_flg.value = 'rt';
				doActionIBSheet(sheetObject1, formObject, MODIFY01);
				try{//조회용도로 팝업 띄울 때 opener 예외 처리
					window.opener.sheetObjects[0].CellValue(formObject.row_idx.value, "sheet1_bl_rt_flg") = "Y";
				}catch(e){
				}
				break;
			case "btn_qa_completed":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				//if(grp_cd == "" ||grp_cd == "S" || return_cd =='R') return;
				doActionIBSheet(sheetObjects[0], form, SEARCH03);

				if (formObject.input_flg.value == "N") {
					ComShowCodeMessage("BKG08116");//B/L data (Customer, M&D, C/M) is not available.
					return;
				}

				if (formObject.bl_aud_flg.value == "Y")
					return;
				formObject.com_flg.value = 'qa';
				
				if (formObject.com_flg.value == "qa"){
					if (ComShowCodeConfirm("BKG01166") == true){
						ComSetObjValue(formObject.call_pgm_type,"QA");
					}
				}
				doActionIBSheet(sheetObject1, formObject, MODIFY01);
				try{//조회용도로 팝업 띄울 때 opener 예외 처리
					window.opener.sheetObjects[0].CellValue(formObject.row_idx.value, "sheet1_bl_aud_flg") = "Y";
				}catch(e){
				}
				break;
			case "btn_return":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				//if(grp_cd == "" ||grp_cd == "S" || return_cd == "R") return;

				var param = "?src_cd=" + formObject.src_cd.value + "&sr_no=" + formObject.sr_no.value + "&bkg_no=" + formObject.bkg_no.value + "&sr_kind=" + formObject.sr_kind.value + "&grp_cd=" + formObject.grp_cd.value + "&wrk_st_tm=" + form.wrk_st_tm.value;

				ComOpenWindowCenter2("/hanjin/ESM_BKG_0985.do" + param, "QueueDetailReturn", 650, 750, false, "scrollbars=yes,resizable=yes");
				break;
			case "btn_return_to_return":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				//if(grp_cd == "" ||grp_cd == "S") return;
				var param = "?src_cd=" + formObject.src_cd.value + "&sr_no=" + formObject.sr_no.value + "&bkg_no=" + formObject.bkg_no.value + "&sr_kind=" + formObject.sr_kind.value + "&grp_cd=" + formObject.grp_cd.value+ "&rtn_from=" + formObject.rtn_from.value + "&wrk_st_tm=" + form.wrk_st_tm.value;
				//     			 			alert(param);
				ComOpenWindowCenter2("/hanjin/ESM_BKG_0984.do" + param, "QueueReturnToReturn", 600, 200, false, "scrollbars=no,resizable=yes");
				break;
			case "btn_pending":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				if (grp_cd == "" || grp_cd == "S")
					return;
				if (form.pnd_flg.value == "P" || form.pnd_flg.value == "Y")
					return;
				formObject.com_flg.value = 'pn';
				doActionIBSheet(sheetObject1, formObject, MODIFY02);
				break;
			case "btn_fopending":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				if (grp_cd != "F")
					return;
				if (form.pnd_flg.value == "P" || form.pnd_flg.value == "Y")
					return;
				formObject.com_flg.value = 'pn';
				doActionIBSheet(sheetObject1, formObject, MODIFY02);
				break;	
			case "btn_unpending":
			    processCnt = 0;
				doActionIBSheet(sheetObjects[0], formObject, SEARCH05);
				if(fo_flg == "Y"){
					ComShowCodeMessage("BKG02214");
					return;
				}
				if (grp_cd == "" || grp_cd == "S")
					return;
				
				if (form.pnd_flg.value == "P" || form.pnd_flg.value == "F"  || form.pnd_flg.value == "Y") {
					doActionIBSheet(sheetObject1, formObject, MODIFY03);
				}
				break;	
			case "btn_Close":
				window.close();
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

function openUploadWindowCheck(){
	 for (var idx=0; idx< arrWindow.length ; idx++) {
		 if(arrWindow[idx] == null || arrWindow[idx].closed) 
			 return idx;
	 }
	 
	 return 99;
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

		case IBSEARCH: //조회

			formObj.f_cmd.value = SEARCH;

			sheetObj.RemoveAll();
			sheetObj.Redraw = false;
			sheetObj.WaitImageVisible = true;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0422_1GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			sheetObj.LoadSearchXml(sXml);
//			alert(formObj.src_cd.value +":"+ ComGetEtcData(sXml, "rqstInfo"));
			if (formObj.src_cd.value == "E" || formObj.src_cd.value == "S" ||
				(formObj.src_cd.value == "M" &&  formObj.xter_sndr_id.value == "EML"   ) ||//2011.08.16 jsy||
				(formObj.src_cd.value == "U" &&  formObj.xter_sndr_id.value == "ULD"   )
			   ) {

				var tempStr = ComGetEtcData(sXml, "rqstInfo");
				var tempArr = tempStr.split(",");
				formObj.xter_rqst_no.value = tempArr[0];
				formObj.xter_rqst_seq.value = tempArr[1];
				formObj.xter_sndr_id.value = tempArr[2];
			}

			sheetObj.WaitImageVisible = false;
			sheetObj.Redraw = true;

			sheetObj.SelectCell(0, 0, false);

			break;
		case SEARCH01: //권한조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0422GS.do", FormQueryString(formObj));
			grp_cd = ComGetEtcData(sXml, "grp_cd");
			formObj.grp_cd.value = grp_cd;
			break;
		case SEARCH02: //메타정보조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0422GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			if (isNullEtcData(sXml)) {
				break;
			}
			formObj.bkg_no.value = ComGetEtcData(sXml, "bkg_no");
			formObj.sr_kind_r.value = ComGetEtcData(sXml, "sr_kind");
			formObj.urgency.value = ComGetEtcData(sXml, "urgency");
			formObj.source.value = ComGetEtcData(sXml, "source");
			formObj.vvd.value = ComGetEtcData(sXml, "vvd");
			formObj.sr_no_r.value = ComGetEtcData(sXml, "sr_no");
			formObj.sr_no.value = ComGetEtcData(sXml, "sr_no");
			formObj.pol_cd.value = ComGetEtcData(sXml, "pol_cd");
			formObj.pod_cd.value = ComGetEtcData(sXml, "pod_cd");
			formObj.page.value = ComGetEtcData(sXml, "page");
			formObj.shipper_cnt_cd.value = ComGetEtcData(sXml, "shipper_cnt_cd");
			formObj.shipper_seq.value = ComGetEtcData(sXml, "shipper_seq");
			formObj.shipper_nm.value = ComGetEtcData(sXml, "shipper_nm");
			formObj.sr_crnt_info_cd.value = ComGetEtcData(sXml, "sr_crnt_info_cd");

			formObj.sr_wrk_sts_cd.value = ComGetEtcData(sXml, "sr_wrk_sts_cd");
			formObj.sr_wrk_sts_usr_id.value = ComGetEtcData(sXml, "sr_wrk_sts_usr_id");
			formObj.wrk_st_tm.value = ComGetEtcData(sXml, "wrk_st_tm");


			formObj.bl_doc_inp_flg.value = ComGetEtcData(sXml, "bl_doc_inp_flg");
			formObj.bl_rt_flg.value = ComGetEtcData(sXml, "bl_rt_flg");
			formObj.bl_aud_flg.value = ComGetEtcData(sXml, "bl_aud_flg");
			formObj.bl_drft_fax_out_flg.value = ComGetEtcData(sXml, "bl_drft_fax_out_flg");
			
			formObj.us_inp_flg.value = ComGetEtcData(sXml, "us_inp_flg");
			formObj.ca_inp_flg.value = ComGetEtcData(sXml, "ca_inp_flg");
			formObj.rtn_from.value = ComGetEtcData(sXml, "rtn_from");
			formObj.pnd_flg.value = ComGetEtcData(sXml, "pnd_flg");
			formObj.sr_amd_tp_cd.value = ComGetEtcData(sXml, "sr_amd_tp_cd");
			
			formObj.xter_rqst_no.value = ComGetEtcData(sXml, "xter_rqst_no");
			formObj.xter_rqst_seq.value = ComGetEtcData(sXml, "xter_rqst_seq");
			formObj.xter_sndr_id.value = ComGetEtcData(sXml, "xter_sndr_id");
			formObj.xter_si_cd.value = ComGetEtcData(sXml, "xter_si_cd");
			formObj.fax_log_ref_no.value = ComGetEtcData(sXml, "fax_log_ref_no"); // add 2011.09.05 
			formObj.sr_knd_cd.value = ComGetEtcData(sXml, "sr_knd_cd"); // add 2011.09.05 
			formObj.tmplt_par_rto.value = ComGetEtcData(sXml, "tmplt_par_rto");
			
			if (ComGetEtcData(sXml, "return_cd") == "R") {

				ComBtnDisable("btn_return");
				ComBtnEnable("btn_return_to_return");

				if (ComGetEtcData(sXml, "fnt_ofc_rtn_cd") == "I") {
					ComBtnEnable("btn_input_completed");
				} else if (ComGetEtcData(sXml, "fnt_ofc_rtn_cd") == "R") {
					ComBtnEnable("btn_rating_completed");
				} else if (ComGetEtcData(sXml, "fnt_ofc_rtn_cd") == "C") {
					ComBtnEnable("btn_qa_completed");
				} else if (ComGetEtcData(sXml, "fnt_ofc_rtn_cd") == "S") {
					ComBtnEnable("btn_input_completed");
					ComBtnEnable("btn_rating_completed");
					ComBtnEnable("btn_qa_completed");
				}
			} else {
				ComBtnEnable("btn_return");
				ComBtnDisable("btn_return_to_return");
			}
			
			if (ComGetEtcData(sXml, "bl_doc_inp_flg") == "Y") {
				ComBtnDisable("btn_input_completed");
			}

			if (ComGetEtcData(sXml, "bl_rt_flg") == "Y") {
				ComBtnDisable("btn_rating_completed");
			}

			if (ComGetEtcData(sXml, "bl_aud_flg") == "N") {
				//ComBtnDisable("btn_fax");								
			} else if (ComGetEtcData(sXml, "bl_aud_flg") == "Y") {
				ComBtnDisable("btn_qa_completed");
				//ComBtnEnable("btn_fax");
			}
			
			if (ComGetEtcData(sXml, "sr_wrk_sts_cd") != "P" && ComGetEtcData(sXml, "sr_wrk_sts_cd") != "F") {
				ComBtnDisable("btn_unpending");
			}else{
				ComBtnEnable("btn_unpending");
			}	
			 
			if (ComGetEtcData(sXml, "sr_crnt_sts_cd") == "XX" ) {
				fnBtnObjDisplay("" ,false);
				return;
			}	
			
			if (grp_cd == "F" || ComGetEtcData(sXml, "sr_wrk_sts_cd") == "P" || ComGetEtcData(sXml, "sr_wrk_sts_cd") == "F") {
				//ComBtnDisable("btn_pending");
				if (ComGetEtcData(sXml, "sr_wrk_sts_cd") == "P" || ComGetEtcData(sXml, "sr_wrk_sts_cd") == "F") {
					ComSetDisplay("div_unpending",true);
					fnBtnObjDisplay(new Array("div_pending","div_fopending","div_return_to_return") ,false);
				}else if (grp_cd == "F"){
					fnBtnObjDisplay(new Array("div_unpending","div_pending") ,false);
					fnBtnObjDisplay(new Array("div_fopending","div_return_to_return") ,true);
				}else{
					ComSetDisplay("div_pending",true);
					fnBtnObjDisplay(new Array("div_unpending","div_return_to_return") ,false);
				}	
				fnBtnObjDisplay(new Array("div_bkg","div_fax","div_input_completed","div_rating_completed","div_qa_completed","div_return","div_retrieve") ,false);
				
				if (grp_cd != "S" && formObj.usr_id.value != ComGetEtcData(sXml, "sr_wrk_sts_usr_id") && 'AUTO_PENDING' != ComGetEtcData(sXml, "sr_wrk_sts_usr_id") ){
					ComSetDisplay("div_unpending",false);
				}
			}else{
				fnBtnObjDisplay("" ,true);
				if (grp_cd != "S" && formObj.usr_id.value != ComGetEtcData(sXml, "sr_wrk_sts_usr_id") ){
					ComSetDisplay("div_unpending",false);
				}
					
			}
						
			//inintButton();
			break;
		case SEARCH03: //complete flg 조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0422GS.do", FormQueryString(formObj));
			formObj.input_flg.value = ComGetEtcData(sXml, "input_flg");
			formObj.rate_flg.value = ComGetEtcData(sXml, "rate_flg");
			break;
		case IBINSERT: // 입력
			sheetObj.DataInsert(-1);
			break;

		case MODIFY01: //저장 
			formObj.f_cmd.value = MODIFY01;
			var sParam = "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0422GS.do", sParam);
			if (ComGetEtcData(sXml, "success_yn") == "Y") {

				if (formObj.com_flg.value == "start" || formObj.com_flg.value == "end") {

					//window.opener.setSr_wrk_sts_cd(formObj.row_idx.value, "W");
					//window.opener.doActionIBSheet(window.opener.sheetObjects[0],window.opener.form,IBSEARCH);
					//doActionIBSheet(sheetObj,formObj,SEARCH02);
				} else {

					ComShowCodeMessage('COM130102', 'Data');
					window.opener.setSr_wrk_sts_cd(formObj.row_idx.value, "W");
					doActionIBSheet(sheetObj, formObj, SEARCH02);
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					if (formObj.sr_wrk_sts_cd.value == "Y") {
						window.opener.setSr_wrk_sts_cd(formObj.row_idx.value, "Y");
					}
				}

				if (formObj.com_flg.value == "qa") {
					if (ComShowCodeConfirm("BKG08087")) {//Would you like to send Draft B/L by Fax or by E-mail?
						openUi();
					}
				}

			} else {
				ComShowCodeMessage('COM130103', 'Data');
			}
			break;
		case MODIFY02: //수정2
			formObj.f_cmd.value = MODIFY02;
			//		if(!validateForm(sheetObj,formObj,sAction)) return;
			var sParam = "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0422GS.do", sParam);
			if (ComGetEtcData(sXml, "success_yn") == "Y") {
				ComShowCodeMessage('COM130102', 'Pending');
				//div_pending.style.display ="none";	
				btn_pending_l.className = "btn2_left";
				btn_pending_c.className = "btn2";
				btn_pending_r.className = "btn2_right";

				var step = "P"; 
				if (grp_cd == "F") step = "F";
				
				formObj.sr_wrk_sts_cd.value = step;
				formObj.pnd_flg.value = "Y";
				window.opener.setSr_wrk_sts_cd(formObj.row_idx.value, step);
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_usr_id") = formObj.usr_id.value;
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_usr_nm") = formObj.usr_nm.value;
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_pnd_flg") = "Y";
				window.opener.sheetObjects[0].RowFontColor(formObj.row_idx.value) = window.opener.sheetObjects[0].RgbColor(255, 0, 0);
//				doActionIBSheet(sheetObjects[0], form, IBSEARCH);
				doActionIBSheet(sheetObjects[0], form, SEARCH02);
				//								 		window.opener.doActionIBSheet(window.opener.sheetObjects[0],window.opener.form,IBSEARCH);
			} else {
				ComShowCodeMessage('COM130103', 'Pending');
			}
			break;
		case MODIFY03:
			formObj.f_cmd.value = MODIFY03;
			var sParam = "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0422GS.do", sParam);
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
				//div_pending.style.display ="none";	
				btn_pending_l.className = "btn2_left";
				btn_pending_c.className = "btn2";
				btn_pending_r.className = "btn2_right";
				//formObj.sr_wrk_sts_cd.value = "W";
				//formObj.pnd_flg.value = "N";
				//formObj.sr_wrk_sts_t.value = "N"
				window.opener.setSr_wrk_sts_cd(formObj.row_idx.value, "W");
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_usr_id") = formObj.usr_id.value;
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_usr_nm") = formObj.usr_nm.value;
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_pnd_flg") = "N";
				window.opener.sheetObjects[0].RowFontColor(formObj.row_idx.value) = window.opener.sheetObjects[0].RgbColor(0, 0, 0);
				doActionIBSheet(sheetObjects[0], form, IBSEARCH);
				doActionIBSheet(sheetObjects[0], form, SEARCH02);
			}
			break;
			
		case MODIFY04:
			formObj.f_cmd.value = MODIFY04;
			var sParam = "&" + FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0422GS.do", sParam);	
			ComBkgSaveCompleted();
			
			break;
			
		case SEARCH05: 
			formObj.f_cmd.value = SEARCH05;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0422GS.do", FormQueryString(formObj));
			fo_flg = ComGetEtcData(sXml, "fo_flg");
			
			break;
		
        case SEARCH11:  //bkg_no로 바로 조회할 경우, Queue List 조회 용도
            formObj.f_cmd.value = SEARCH;
            formObj.curr_page.value = 1;//PageNo를 초기화 하기 위함
            formObj.rows_per_page.value = rowsPerPage;
            sheetObj.RemoveAll();
            sheetObj.Redraw = false;
            sheetObj.WaitImageVisible = false;
        	ComOpenWait(true);  //대기이미지 표시
            var sXml = sheetObj.GetSearchXml("ESM_BKG_0421GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix2));
            sheetObj.LoadSearchXml(sXml);
            sheetObj.Redraw = true;
            ComOpenWait(false);  //대기이미지 표시
            break;
	}
}

/*
 *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
 * 초기값은 쉬트 헤더 개수
 */
var pagedMaxCnt = 2;
/**
 * 조회후  이벤트 처리
 */

function callIntervalAutoClose(){
	
	if (90==processCnt++) {  // 90분
		clearInterval(intervalId);
		
		var formObject = document.form;
		var rtnVal = ComOpenWindowCenter("/hanjin/ESM_BKG_0986.do" , "ESM_BKG_0986", 550, 158, true);
		if(rtnVal.proceed){ // false : Queue Detail 유지
			initInterval();
			return;
		}

		if(rtnVal.close){   // true : Queue Detail Close
			window.close();
		}
		return;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	
	if (formObj.pnd_flg.value == "P") {
		btn_pending_l.className = "btn2_left";
		btn_pending_c.className = "btn2";
		btn_pending_r.className = "btn2_right";
	}
}

/*
 *  Search Option or Item Option Modify
 */
function sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {

	if (colIdx == sheetObj.SaveNameCol(prefix + "read")) {
		if (sheetObj.CellValue(rowIdx, prefix + "read") == "0") {

			var downloadLocation = sheetObj.CellValue(rowIdx, prefix + "img_file_real_path");
			var downloadFileName = encodeURI(sheetObj.CellValue(rowIdx, prefix + "img_file_nm"));

			var url = "/hanjin/FileDownload?downloadLocation=" + downloadLocation + "&downloadFileName=" + downloadFileName;
			var host = location.host;
			if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
				url = "http://alpsdev.hanjin.com:9300/" + url;
			}
			location.href = url;
		}else if (sheetObj.CellValue(rowIdx, prefix + "read") == "2") {
			goEmlCtntPop(sheetObj,rowIdx);
		}else if (sheetObj.CellValue(rowIdx, prefix + "read") == "3") {
			rdOpen(sheetObj,rowIdx);
		} 
		
	} else if (colIdx == sheetObj.SaveNameCol(prefix + "msg_pop")) {
		if (sheetObj.CellValue(rowIdx, prefix + "msg_pop") == "0") {
			ComOpenWindowCenter2("", "DetailMessage", 600, 180, false, "scrollbars=no,resizable=yes");
			form2.message.value = sheetObj.CellValue(rowIdx, prefix + "message_all");
			form2.target = "DetailMessage";
			form2.action = "/hanjin/ESM_BKG_0983.do";
			form2.submit();
		}
	} else if (colIdx == sheetObj.SaveNameCol(prefix + "sr_kind2")) {
		if (sheetObj.CellValue(rowIdx, prefix + "sr_kind2") == "0") {
			var param = "?bkg_no=" + form.bkg_no.value;
			param += "&sr_no=" + sheetObj.CellValue(rowIdx, prefix + "sr_no");
			ComOpenWindowCenter2("/hanjin/ESM_BKG_1006.do" + param, "Amend Reason", 615, 270, false, "scrollbars=no,resizable=yes");
		}
	} else if (colIdx == sheetObj.SaveNameCol(prefix + "return_cd2")) {

		if (sheetObj.CellValue(rowIdx, prefix + "return_cd2") == "<<-") {
			var param = "?src_cd=" + form.src_cd.value + "&sr_no=" + form.sr_no.value + "&bkg_no=" + form.bkg_no.value + "&sr_kind=" + form.sr_kind.value + "&grp_cd=" + form.grp_cd.value + "&sr_his_seq=" + sheetObj.CellValue(rowIdx, prefix + "sr_his_seq") + "&wrk_st_tm=" + form.wrk_st_tm.value;
			ComOpenWindowCenter2("/hanjin/ESM_BKG_0985.do" + param, "QueueDetailReturn", 650, 750, false, "scrollbars=yes,resizable=yes");
			//ComOpenWindowCenter2("/hanjin/ESM_BKG_1007.do"+param, "Return Reason", 715,195,false,"scrollbars=no,resizable=yes");
		} else if (sheetObj.CellValue(rowIdx, prefix + "return_cd") == "T") {
			if (sheetObj.CellValue(rowIdx, prefix + "msg_pop") == "0") {
				ComOpenWindowCenter2("", "DetailMessage", 600, 180, false, "scrollbars=no,resizable=yes");
				form2.message.value = sheetObj.CellValue(rowIdx, prefix + "message_all");
				form2.target = "DetailMessage";
				form2.action = "/hanjin/ESM_BKG_0983.do";
				form2.submit();
			}

		}
	} /*else if (colIdx == sheetObj.SaveNameCol(prefix + "message")) {
		var param = "?sr_no=" + sheetObj.CellValue(rowIdx, prefix + "sr_no") + "&rcv_rmk=" + sheetObj.CellValue(rowIdx, prefix + "message");
		ComOpenWindow2("/hanjin/ESM_BKG_0988.do" + param, "open0988", "statebar=no,width=600,height=220,left=200,top=0");
	}*/
	else if(colIdx == sheetObj.SaveNameCol(prefix + "convert")) {
		
//		var formObject = document.form;
//		var sParam = "";
//		var sr_knd_cd = formObject.sr_knd_cd.value;
//		var sr_no = "";
//		if( !ComIsNull(formObject.xter_rqst_no.value)) {
//			
//			sr_no = formObject.xter_rqst_no.value;
//		} else if( !ComIsNull(formObject.sr_no.value)) {
//			sr_no = formObject.sr_no.value;
//			
//		}
//		var fax_log_ref_no = formObject.fax_log_ref_no.value;
//		var bkg_no = formObject.bkg_no.value;
//		sParam = "?&sr_knd_cd=" +sr_knd_cd + "&sr_no="+sr_no +"&fax_log_ref_no="+fax_log_ref_no+"&bkg_no="+bkg_no+"&conv_pdf_flg=Y";
////		sParam = "?&sr_knd_cd=" +sr_knd_cd + "&sr_no="+'PHX103220002' +"&fax_log_ref_no="+'4d88199a3fcfbbaf45d58e28'+"&bkg_no="+'PHX113523201';
		var date = new Date();
		var toDay = date.getYear() + "" + (date.getMonth() + 1) + ""
				+ date.getDate() + "" + date.getHours() + "" + date.getMinutes()
				+ "" + date.getSeconds();
		
		
//		if (sheetObj.CellValue(Row,prefix+"eml_subj_ctnt") == "") return;
		var sParam = "";
		var param   = new Array("sr_knd_cd","sr_no","fax_log_ref_no","bkg_no");
		sParam = getGetSheetRowParam(sheetObj, rowIdx ,prefix, param);
		
		winIdx = openUploadWindowCheck();
		arrWindow[winIdx] = ComOpenWindowCenter("/hanjin/ESM_BKG_0447.do" + sParam+"&conv_pdf_flg=Y", "ESM_BKG_0447"+toDay, 750, 480, false);

	}
}
function rdOpen(sheetObj,Row){
	var Rdviewer = rdObjects[0];
	var formObj = document.form;
	
	var rdParam = "/rv " + "frm1_sender_id["+sheetObj.CellValue(Row, prefix+"xter_sndr_id")+"] frm1_rqst_no["+sheetObj.CellValue(Row, prefix+"xter_rqst_no")+"] frm1_rqst_seq["+sheetObj.CellValue(Row, prefix+"xter_rqst_seq")+"] frm1_bkg_no["+sheetObj.CellValue(Row, prefix+"bkg_no")+"]";
	var rdUrl = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
	var rdFile = null;
	if ( sheetObj.CellValue(Row, prefix+"doc_tp_cd") == "B" ) rdFile = "ESM_BKG_0230B.mrd";
	else rdFile = "ESM_BKG_0230S.mrd";
	
	formObj.com_mrdPath.value = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/"+rdFile;
	formObj.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
	
	var iWidth = 1000;
	var	iHeight= 600;
	var leftpos = (screen.width - iWidth) / 2;
	if (leftpos < 0)
		leftpos = 0;
	var toppos = (screen.height - iHeight) / 2;
	if (toppos < 0)
		toppos = 0;
	
	ComOpenRDPopup('resizable=yes,width='+iWidth+',height='+iHeight+',left='+ leftpos + ',top=' + toppos);
		
}
function goEmlCtntPop(sheetObj,Row){
	if (sheetObj.CellValue(Row,prefix+"eml_subj_ctnt") == "") return;
	var sParam = "";
	var param   = new Array("sr_knd_cd","sr_no","fax_log_ref_no","bkg_no");
	sParam = getGetSheetRowParam(sheetObj, Row ,prefix, param);
	
	ComOpenWindowCenter("/hanjin/ESM_BKG_0447.do" + sParam, "ESM_BKG_0447", 750, 480, false);
}

function getGetSheetRowParam(sheetObj, Row, prefix, param){
	var sParam = "?";
	with (sheetObj) {
		for(i=0;i<param.length;i++){
			sParam += "&"+param[i]+"=" + CellValue(Row,prefix+param[i]);  
		}	
	}
	return sParam;
}
 /**
 *  Remark MemoPad 
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	if (sheetObj.ColSaveName(col) == "sheet1_message") {
		ComShowMemoPad(sheetObj, null,sheetObj.SaveNameCol("sheet1_message_all"), true, null, null, 1000);
	}
} 
/**
 * Go To Fax UI Open
 */

function openUi() {
	var param = "?src_cd=" + form.src_cd.value + "&sr_no=" + form.sr_no.value + "&bkg_no=" + form.bkg_no.value + "&sr_knd_cd=" + form.src_cd.value + "&grp_cd=" + form.grp_cd.value;
	ComOpenWindowCenter2("/hanjin/ESM_BKG_0095.do" + param, "Return Reason", 940, 660, false, "scrollbars=no,resizable=yes");
}

/**
 * input,rate complete check >>> Go to BKG 작업여부 체크 
 */
function chkCompleteFlg() {

	var formObj = document.form;
	if (bkgWinObj != "undefined" && bkgWinObj != null) {
		doActionIBSheet(sheetObjects[0], form, SEARCH03);
		if (formObj.input_flg.value == "N" || formObj.rate_flg.value == "N") {
			bkgWinObj = null;
			chkCompleteFlg();
		}
	} else {
		setTimeout('chkCompleteFlg()', 10000);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}

function isNullEtcData(xmlStr) {
	var rtn = false;
	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	xmlDoc.loadXML(xmlStr);

	var xmlRoot = xmlDoc.documentElement;
	if (xmlRoot == null)
		return true;

	var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	if (etcDataNode == null)
		return true;

	var etcNodes = etcDataNode.childNodes;
	if (etcNodes == null)
		return true;
	if (etcNodes.length == 0)
		rtn = true;

	return rtn;
}

/**
 * 화면 open/close 시 상태코드 변경 
 */
function setStsCd(type) {

	var formObj = document.form;
	if (formObj.ui_id.value == "ESM_BKG_0067") {
		return;
	}
	
	if (formObj.sr_wrk_sts_cd.value != "Y" && formObj.sr_wrk_sts_cd.value != "P" && formObj.sr_wrk_sts_cd.value != "F") {
		if (type == "S") {
			if (formObj.sr_wrk_sts_cd.value == "T") {
				formObj.sr_wrk_sts_t.value = "Y";
			}

			formObj.com_flg.value = "start";
			formObj.sr_wrk_sts_cd.value = "W";
			doActionIBSheet(sheetObjects[0], formObj, MODIFY01);
			//window.opener.setSr_wrk_sts_cd(formObj.row_idx.value, "W");
			try{//조회용도로 팝업 띄울 때 opener 예외 처리 
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_cd") = "W";
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_usr_id") = formObj.usr_id.value;
				window.opener.sheetObjects[0].CellValue(formObj.row_idx.value, "sheet1_sr_wrk_sts_usr_nm") = formObj.usr_nm.value;
			}catch(e){
			}
		} else {
			//if ((formObj.com_flg.value != '' && formObj.sr_wrk_sts_t.value == "N") || (formObj.com_flg.value != 'start' && formObj.sr_wrk_sts_t.vavlue == "Y")) {
			if (formObj.sr_wrk_sts_cd.value == "W") {
				formObj.com_flg.value = 'end';
				
				doActionIBSheet(sheetObjects[0], formObj, MODIFY01);
				try{//조회용도로 팝업 띄울 때 opener 예외 처리
					window.opener.setSr_wrk_sts_cd(formObj.row_idx.value, "");
				}catch(e){
				}
			}
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 330;

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
				InitRowInfo(1, 1, 3, rowsPerPage);

				var HeadTitle1 = "Seq.|Read|Conv|SRC|Kind|SI No.|Status|Return|To|Amend|Work Start Date|Work End Date|Update Date(GMT)|Actual Time\nElapsed|Biz. Hour\nElapsed|Over Time|Idling Actual\nTime Elapsed|Idling Biz.\nHour Elapsed|Idling \nOver Time|Holiday|PIC|PIC|Message|Message|SR_STS_CD|retrun|sr_kind|message_all|source|return_sr_no||bkg_no|fax_log_ref_no|xter_sndr_id|xter_rqst_no|xter_rqst_seq|doc_tp_cd";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 2, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(true, true, true, true, false, false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성      [ ROW,	COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,		30, daCenter,	false, prefix + "Seq", 					false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtImage, 	40, daCenter, 	false, prefix + "read", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtImage, 	40, daCenter, 	false, prefix + "convert", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 		40, daCenter, 	false, prefix + "xter_si_cd", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 		40, daCenter, 	false, prefix + "sr_amd_tp_cd", 		false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 	   110, daCenter, 	false, prefix + "sr_no", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 	   127, daLeft,  	false, prefix + "sr_sts", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtImageText, 50, daCenter, 	false, prefix + "return_cd2", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 	   130, daLeft, 	false, prefix + "rtn_to", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtImage,     50, daCenter, 	false, prefix + "sr_kind2", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData,     120, daCenter, 	false, prefix + "sr_proc_up_dt", 		false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData,     120, daCenter, 	false, prefix + "up_dt", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,   120, daCenter, 	false, prefix + "gmt_dt", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				
				InitDataProperty(0, cnt++, dtData,      80, daCenter, 	false, prefix + "sr_proc_hrs", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 		80, daCenter, 	false, prefix + "bl_doc_wrk_hrs", 		false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 		80, daCenter, 	false, prefix + "bl_doc_ovt_hrs", 		false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData,      80, daCenter, 	false, prefix + "sr_idle_hrs", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 		80, daCenter, 	false, prefix + "sr_wrk_tm_idle_hrs", 	false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 		80, daCenter, 	false, prefix + "sr_ovt_idle_hrs", 		false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 		50, daCenter, 	false, prefix + "hol_flg", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				
				InitDataProperty(0, cnt++, dtData, 	   150, daLeft, 	false, prefix + "pic_nm", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData, 		50, daCenter, 	false, prefix + "pic_ofc_cd", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,   100, daLeft, 	false, prefix + "message_all", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtData,     150, daLeft, 	false, prefix + "message", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden, 	30, daCenter, 	false, prefix + "msg_pop", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,   100, daCenter, 	false, prefix + "sr_sts_cd", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,   100, daCenter, 	false, prefix + "return_cd", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,   100, daCenter, 	false, prefix + "sr_kind", 				false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				
				InitDataProperty(0, cnt++, dtHidden,   100, daCenter, 	false, prefix + "sr_knd_cd", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				//InitDataProperty(0,		cnt++ , dtHidden,			100,	daCenter,	false,	prefix + "pnd_flg",			false,		"",		dfNone,	0,		false,		false,	0,	false,	false);
				InitDataProperty(0, cnt++, dtHidden,   100, daCenter, 	false, prefix + "return_sr_no", 		false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,   100, daCenter, 	false, prefix + "img_file_real_path", 	false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,   100, daCenter, 	false, prefix + "img_file_nm", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,   100, daCenter, 	false, prefix + "sr_his_seq", 			false, 		"", 		dfNone, 	0, 			false, 		false, 		0, 		false, 		false);
				InitDataProperty(0, cnt++, dtHidden,     0, daCenter, 	false, prefix + "bkg_no");
				InitDataProperty(0, cnt++, dtHidden,  	 0, daCenter, 	false, prefix + "fax_log_ref_no");
				
				InitDataProperty(0, cnt++, dtHidden,  	 0, daCenter, 	false, prefix + "xter_sndr_id");
                InitDataProperty(0, cnt++, dtHidden,  	 0, daCenter, 	false, prefix + "xter_rqst_no");
                InitDataProperty(0, cnt++, dtHidden,  	 0, daCenter, 	false, prefix + "xter_rqst_seq");
                InitDataProperty(0, cnt++, dtHidden,  	 0, daCenter, 	false, prefix + "doc_tp_cd");
                
                
				ShowButtonImage = 2;
				CountPosition = 0;

				ImageList(0) = "/hanjin/img/btns_search.gif";
				ImageList(1) = "/hanjin/img/blank.gif";
				ImageList(2) = "/hanjin/img/ico_attach.gif";
				ImageList(3) = "/hanjin/img/btns_note.gif";
				ImageList(4) = "/hanjin/img/btn_file.gif";
				
				//RowHeight = 20;
				SelectionMode = smSelectionFree;
				
			}

			break;
			
        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 100; //hidden
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, rowsPerPage);
                var HeadTitle = "|Sel|Seq.|Read|Ugt|SI Kind|Ver|Return|Freq.|R/F|To|SRC|SRC|Booking No.|Booking Staff|Split|Lane|VVD|I|R|Q|F|FO|STS|ESI|MF|POL|ETD Date|SI Transfer\nDate|DOC.Cut off|BKG OFC|S.OFC|S.Rep|Shipper|POD|PCT Date|Return Mail|PIC From|PIC|Est. BDR\nDate|Last Updated|Message|Email Subject"
                              + "|message_yn|sr_crnt_info_cd|sr_crnt_sts_cd|max_sr_no|crnt_usr_id|img_file_ip|img_file_path_ctnt|img_file_nm|img_file_real_path|bkg_sts_cd|pic_cng_id|rtn_fm_usr_id|rtn_to_usr_id|rtn_to_rtn_usr_id|sr_sts_cd|rtn_to_rtn_sts_cd|pnd_flg|sr_kind_cd|sr_knd_cd|src_cd|return_src|sr_wrk_sts_usr_id|sr_no|fax_log_ref_no|rtn_to_usr_remark|sr_wrk_sts_usr_nm|sr_amd_tp_cd|xter_sndr_id|xter_rqst_no|xter_rqst_seq|doc_tp_cd|rgn_ofc_cd";//hidden
                var headCount = ComCountHeadTitle(HeadTitle);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 14, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
                InitHeadMode(true, true, false, true, false,false)
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                //데이터속성    [ROW,   COL,    DATATYPE,           WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, true, 	prefix2+"ibflag");
                InitDataProperty(0, cnt++, dtCheckBox, 25,  daCenter, true,  prefix2+"sel",                 false, "", dfNone,        0, true,  true );
                InitDataProperty(0, cnt++, dtDataSeq,  30,  daCenter, true,  prefix2+"seq");
                InitDataProperty(0, cnt++, dtImage,    35,  daCenter, false, prefix2+"read",                false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix2+"urgency",             false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     115,  daCenter, false, prefix2+"sr_kind",             false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix2+"sr_amd_seq",          false, "", dfNone,        0, false, false);

                InitDataProperty(0, cnt++, dtData,     80,  daLeft, false, prefix2+"return_cd",           false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     35,  daCenter, false, prefix2+"rtn_freq",           false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix2+"rc_inp_flg",         false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix2+"return_to",          false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     40,  daCenter, false, prefix2+"xter_si_cd",         false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtHidden,   40,  daCenter, false, prefix2+"src",               false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     90,  daLeft,   false, prefix2+"bkg_no",             false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     90,  daLeft,   false, prefix2+"bkg_staff",             false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix2+"split_sts_cd",      false, "", dfEngUpKey,        0, true, true ,1); 
                InitDataProperty(0, cnt++, dtData,     40,  daCenter, false, prefix2+"slan_cd",           false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     70,  daCenter, false, prefix2+"vvd_cd",              false, "", dfNone,        0, false, false);
                
                InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix2+"bl_doc_inp_flg",      false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix2+"bl_rt_flg",           false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix2+"bl_aud_flg",          false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix2+"bl_drft_fax_out_flg", false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     20,  daCenter, false, prefix2+"bl_fnt_ofc_flg"     , false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     26,  daCenter, false, prefix2+"sr_wrk_sts_cd",       false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     26,  daCenter, false, prefix2+"bkg_upld_sts_cd",       false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     30,  daCenter, false, prefix2+"cstms_mf_tp_cd",      false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     45,  daCenter, false, prefix2+"pol_cd",              false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     80, daCenter, false, prefix2+"vps_etd_dt",         false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix2+"sr_date",             false, "", dfUserFormat2, 0, false, false);	
                InitDataProperty(0, cnt++, dtData,     80, daCenter, false, prefix2+"doc_cct",             false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix2+"bkg_ofc_cd",          false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix2+"ob_sls_ofc_cd",          false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     50,  daCenter, false, prefix2+"ob_srep_cd",          false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     180, daLeft,   false, prefix2+"shipper",             false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     45,  daCenter, false, prefix2+"pod_cd",              false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix2+"pct_date",            false, "", dfUserFormat2, 0, false, false);
                InitDataProperty(0, cnt++, dtData,     150, daLeft, false, prefix2+"rtn_to_usr_eml",      false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     100,  daLeft,   false, prefix2+"rtn_fm_usr_id",              false, "", dfNone,        0, false, false);  //rtn_to_usr_id
                InitDataProperty(0, cnt++, dtData,     100,  daLeft,   false, prefix2+"pic_id",              false, "", dfNone,        0, false, false);  //rtn_to_usr_id
                InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix2+"bdr_date",            false, "", dfUserFormat2, 0, false, false);
                InitDataProperty(0, cnt++, dtData,     100, daCenter, false, prefix2+"last_date",           false, "", dfUserFormat2, 0, false, false);
                InitDataProperty(0, cnt++, dtImage,    60,  daCenter, false, prefix2+"message_yn",          false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtData,     130, daLeft,   false, prefix2+"eml_subj_ctnt",       false, "", dfNone,        0, false, false);
                
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"message",             false, "", dfNone,        0, false, false);
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_crnt_info_cd"     );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_crnt_sts_cd"      );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"max_sr_no"           );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"crnt_usr_id"         );

                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"img_file_ip"         );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"img_file_path_ctnt"  );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"img_file_nm"         );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"img_file_real_path"  );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"bkg_sts_cd"          );

                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"pic_id"              );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"pic_cng_id"          );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"rtn_fm_usr_id"       );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"rtn_to_rtn_usr_id"   );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_sts_cd"           );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"rtn_to_rtn_sts_cd"   );

                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"pnd_flg"             );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_kind_cd"          );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_knd_cd"           );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"src_cd"              );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"return_src"          );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_wrk_sts_usr_id"   );

                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_no"               );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"fax_log_ref_no"      );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"rtn_to_usr_remark"      );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_wrk_sts_usr_nm"   );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"sr_amd_tp_cd"   );
                
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"xter_sndr_id"      );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"xter_rqst_no"   );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"xter_rqst_seq"   );
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"doc_tp_cd"   );
                //2011.12.08 rgn_ofc_cd 추가 kbj
                InitDataProperty(0, cnt++, dtHidden,   0,   daCenter, false, prefix2+"rgn_ofc_cd"   );
               
                
                InitUserFormat2(0, prefix2 + "pct_date",  "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, prefix2 + "bdr_date",  "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, prefix2 + "sr_date",   "####-##-## ##:##", "-|:" );
                InitUserFormat2(0, prefix2 + "last_date", "####-##-## ##:##", "-|:" );

                InitDataValid(0, prefix2+"split_sts_cd", vtEngUpOnly);
                
                ShowButtonImage = 2;

                ImageList(0) = "/hanjin/img/btns_search.gif";
                ImageList(1) = "/hanjin/img/blank.gif";
                ImageList(2) = "/hanjin/img/ico_attach.gif";
                ImageList(3) = "/hanjin/img/btns_note.gif";
//                FrozenCols = 15;
            }
        break;			

	}
}
 function sheet1_OnMouseMove(sheetObject, Button, Shift, X, Y) {
	 if (sheetObject.ColSaveName(sheetObject.MouseCol)  == (prefix + "read")
			 && (sheetObj.CellValue(sheetObject.MouseRow, prefix + "read") == "0"
				 || sheetObj.CellValue(sheetObject.MouseRow, prefix + "read") == "2"
					 || sheetObj.CellValue(sheetObject.MouseRow, prefix + "read") == "3"
				 ))  {
		 sheetObject.MousePointer = "Hand";
	 }else{
		 sheetObject.MousePointer = "Default";
	 }
 }
/* 개발자 작업  끝 */