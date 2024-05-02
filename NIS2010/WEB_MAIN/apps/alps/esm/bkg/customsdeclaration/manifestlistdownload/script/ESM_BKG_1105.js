/*=========================================================
*Copyright(c)2010 CyberLogitec
*@FileName : esm_bkg_1105.js
*@FileTitle : esm_bkg_1105
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.07
*@LastModifier : 계기훈
*@LastVersion : 1.0
* 1.0 Creation
* 1.1 2015.12.02 [CHM-201538926] [ENS] WAND1543N 항차 / POFE calling seq 적용 로직 테스트
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
 * @class esm_bkg_1105 : esm_bkg_1105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1105(){
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
	/* 개발자 작업	*/
var comboObjects = new Array();
var comboCnt = 0;
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj; 
}

  /**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo){
    switch(comboObj.id){
    }
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try{
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName){
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_new":
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;  
			case "btn_transmit":
				doActionIBSheet(sheetObject1, formObject, MULTI01);
				break;
			case "btn_viewMsg":
				var row = sheetObject1.SelectRow;
				var edi_rcv_dt_msg = sheetObject1.CellValue(row, "edi_rcv_dt_msg");
				ComOpenWindowCenter(	"/hanjin/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" +  edi_rcv_dt_msg + "&edi_rcv_seq=" + sheetObject1.CellValue(row, "edi_rcv_seq"), "1105", 500, 650, true);
				break;   	
		} // end switch
	}catch(e){
		if( e == "[object Error]"){
			ComShowMessage(OBJECT_ERROR);
		} else{
			ComShowMessage(e);
		}
	}
}
     

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(){
	var formObj = document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    
	for(i = 0; i < comboObjects.length; i++ ){
		initCombo(comboObjects[i], i+1);
	}
	
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	SetButtonStatus();
}

 /**
  * 화면 로드 시 버튼 처리
  */
function SetButtonStatus(){
	if(document.form.vvd.value == ''){
		ComBtnDisable("btn_transmit");
	}else{
		if(document.form.form_crr_cd.value == 'SML'){
			if(document.form.form_dvs_rqst_edi_svc_flg.value == 'Y'){
				ComBtnEnable("btn_transmit");
			}else{
				ComBtnDisable("btn_transmit");
			}
    	 }else{
    		 ComBtnDisable("btn_transmit");
    	 }
     }
} 
 
/**
 * 화면 로딩 완료 후 이벤트
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj){
	var formObj = document.form;
	initSheetData(sheetObjects[0], formObj);
	ComSetFocus(formObj.form_vvd_cd);
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo){
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch(sheetID){
		case "sheet1":
			with(sheetObj){
				// 높이 설정
				style.height = 302;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if(location.hostname != "")InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				//var HeadTitle1 = "| |Harmonized Tariff Code|Description|Category";
				var HeadTitle1 = "| |vvd|cvy_ref_no|cvy_ref_no_hidden|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|lloyd_no|piclb_desc|cstms_port_cd|n1st_port_ofc_cd|rvis_n1st_clpt_cd|n1st_port_ofc_cd_new|eta_dt|lst_clpt_cd|nxt_clpt_cd|cre_usr_id|cre_dt|upd_usr_id|upd_dt|upd_dt_gmt|snd_usr_id|snd_dt|snd_dt_gmt|snd_ofc_cd|first_eu_port|ack|result|cstms_yd_cd|edi_rcv_dt|edi_rcv_seq|rvis_cstms_yd_cd|crr_cd|dvs_rqst_smt_flg|upd_ofc_cd|edi_rcv_dt_gmt|edi_rcv_dt_msg|init_eta_dt|dvs_edi_svc_flg|dvs_rqst_edi_svc_flg";
				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ , dtHiddenStatus,			30,	daCenter,		true,		"ibflag");
				InitDataProperty(0,	cnt++ , dtSeq,	50,	daCenter,	true,	"Seq");
				InitDataProperty(0,	cnt++ , dtData,	50,	daCenter,	true,	"vvd",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daCenter,	true,	"cvy_ref_no",		false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daCenter,	true,	"cvy_ref_no_hidden",false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daCenter,	true,	"vsl_cd",			false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"skd_voy_no",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"skd_dir_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"vsl_eng_nm",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"lloyd_no",		false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"piclb_desc",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"cstms_port_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"n1st_port_ofc_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"rvis_n1st_clpt_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"n1st_port_ofc_cd_new",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"eta_dt",			false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"lst_clpt_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"nxt_clpt_cd",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"cre_usr_id",		false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"cre_dt",			false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"upd_usr_id",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"upd_dt",			false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"upd_dt_gmt",			false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"snd_usr_id",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"snd_dt",			false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"snd_dt_gmt",			false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"snd_ofc_cd",			false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"first_eu_port",	false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"ack",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"result",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"cstms_yd_cd",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"edi_rcv_dt",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"edi_rcv_seq",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"rvis_cstms_yd_cd",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"crr_cd",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"dvs_rqst_smt_flg",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"upd_ofc_cd",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"edi_rcv_dt_gmt",				false, "", dfNone, 0, false, false);
				InitDataProperty(0,	cnt++ , dtData,	50,	daLeft,		true,	"edi_rcv_dt_msg",				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "init_eta_dt",						false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "dvs_edi_svc_flg",						false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "dvs_rqst_edi_svc_flg",						false, "", dfNone, 0, false, false);
				CountPosition = 0;

				WaitImageVisible=false;
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
function doActionIBSheet(sheetObj,formObj,sAction){
	sheetObj.ShowDebugMsg = false;
	switch(sAction){
		case IBSEARCH :	//조회
			if(!validateForm(sheetObj,formObj,sAction))return false;

			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			formObj.vvd.value = formObj.form_vvd.value;
			formObj.cvy_ref_no.value = formObj.form_cvy_ref_no.value;
			formObj.cstms_port_cd.value = comboObjects[0].Code;
			var cstms_yd_cd = formObj.form_cstms_yd_cd.value;
			formObj.cstms_yd_cd.value = formObj.form_cstms_yd_cd.value;
			
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1105GS.do", FormQueryString(formObj));
			//alert(sXml);
			sheetObjects[0].LoadSearchXml(sXml);
			
			var vvd = sheetObjects[0].CellValue(1, "vvd");
			
			if(vvd == "CSGP0071W" || vvd == "CSHI0074W" || vvd == "COLH0178W" || vvd == "CHKG0079W" ||  vvd == "CHAM0076W" 
					 || vvd == "CRTM0069W" ||  vvd == "CQIN0083W"){
				var oldDt = sheetObjects[0].CellValue(1, "init_eta_dt");
				var timeDt = oldDt.substr(10,6);
				var newDt = ComGetDateAdd(oldDt, "D", -1)+timeDt;
				sheetObjects[0].CellValue2(1, "init_eta_dt") = newDt;	
			}
			
			if(sheetObj.RowCount >= 1){
				IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
				if(formObj.form_cstms_port_cd.value=="")
					formObj.form_cstms_port_cd.value = cstms_yd_cd;
				ComBtnEnable("btn_save");
			}else{
				SetButtonStatus();
				ComOpenWait(false);
				ComShowCodeMessage("BKG00889"); // No Data Found
				ComBtnDisable("btn_save");
				return;
			}
			
			if(comboObjects[0].Code != '' && formObj.form_rvis_n1st_clpt_cd.value == ''){
				formObj.form_rvis_n1st_clpt_cd.value = comboObjects[0].Code;
			}
			
			if(formObj.form_rvis_n1st_clpt_cd.value != ''){
				formObj.form_rvis_n1st_clpt_cd_old.value = formObj.form_rvis_n1st_clpt_cd.value;
			}
			
			if(formObj.form_rvis_n1st_clpt_cd.value != '' && formObj.form_rvis_n1st_clpt_cd.value != comboObjects[0].Code){
				formObj.form_rvis_n1st_clpt_cd.style.backgroundColor = "red";
			}else{
				formObj.form_rvis_n1st_clpt_cd.style.backgroundColor = "white";
			}
			
			if(cstms_yd_cd != '' && cstms_yd_cd != undefined) {
				formObj.form_cstms_yd_cd.value = cstms_yd_cd;
			}
			if(formObj.form_crr_cd.value == 'SML'){
				formObj.form_dvs_rqst_smt_flg.disabled = true;
			}else{
				formObj.form_dvs_rqst_smt_flg.disabled = false;
			}
			
			//alert(sheetObjects[0].CellValue(1, "dvs_rqst_smt_flg") + " : " + formObj.form_dvs_rqst_smt_flg.value + " : " + formObj.dvs_rqst_smt_flg.value);
			if(sheetObjects[0].CellValue(1, "dvs_rqst_smt_flg") == 'Y'){
				formObj.form_dvs_rqst_smt_flg.checked = true;
			}else{
				formObj.form_dvs_rqst_smt_flg.checked = false;
			}
			doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
			
			SetButtonStatus();
			ComOpenWait(false);
			break;
		case IBINSERT :	// 초기화
			initSheetData(sheetObj, formObj);
			comboObjects[0].RemoveAll();
			comboObjects[1].RemoveAll();
			ComSetFocus(formObj.form_vvd);
			formObj.form_rvis_n1st_clpt_cd.style.backgroundColor = "white";
			formObj.cstms_port_clpt_ind_seq.value ="";
			break;
		case IBSAVE :	// 저장,수정
			if(!validateForm(sheetObj,formObj,sAction))return;

			IBS_CopyFormToRow(formObj, sheetObj, 1, "form_");
			sheetObj.CellValue(1,"cstms_port_cd") =  comboObjects[0].Code;
			if(formObj.form_dvs_rqst_smt_flg.checked){
				formObj.dvs_rqst_smt_flg.value = 'Y';
			}else{
				formObj.dvs_rqst_smt_flg.value = 'N';
			}
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			formObj.rvis_cstms_yd_cd.value = comboObjects[1].Code;
			sheetObj.CellValue(1,"rvis_cstms_yd_cd") = comboObjects[1].Code;
			sheetObj.DoSave("ESM_BKG_1105GS.do", FormQueryString(formObj));
			formObj.form_rvis_n1st_clpt_cd_old.value = formObj.form_rvis_n1st_clpt_cd.value
			ComOpenWait(false);
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			break;
		case MULTI01: // 전송
			if(!validateForm(sheetObj,formObj,sAction)) return;
			
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI01;
			formObj.vvd.value = formObj.form_vvd.value;
			formObj.cvy_ref_no.value = formObj.form_cvy_ref_no.value;
			sheetObj.CellValue(1,"rvis_cstms_yd_cd") = comboObjects[1].Code;
			
			if(location.href.indexOf('alpsdev') != -1 && formObj.form_ibflag.value == 'I'){
				//POFE 입력이 안되어 있는 경우 ENS정보가 없는 것으로 판단한다!
				ComShowCodeMessage("BKG01129");//Please Save First!
//				if(formObj.form_cstms_port_cd.value == ''){
//					ComShowCodeMessage("BKG01128");//No ENS data Found!
//				}else{
//				}
			}else{
				//IBFLAG가 U인데 hidden값과 입력대상 값이 다른 경우는 저장이 안된 경우로 판단한다.
				if(formObj.form_rvis_n1st_clpt_cd_old.value != formObj.form_rvis_n1st_clpt_cd.value){
					ComShowCodeMessage("BKG01129");//Please Save First!
				}else{
					var sXml = sheetObj.GetSearchXml("ESM_BKG_1105GS.do", FormQueryString(formObj));
					
					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
					if(State == "S"){
						ComShowCodeMessage("BKG00101"); // Data Transmitted Successfully!!
					}else{
						ComShowCodeMessage("BKG00099"); // Failed to transmit ED!!
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			}
			
			ComOpenWait(false);
			break;
		case SEARCH02: // VVD Combo setting
			formObj.f_cmd.value = SEARCH02;
			formObj.p_vvd_cd.value = formObj.form_vvd.value;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1105GS.do", FormQueryString(formObj));
			if(sXml.length > 0){
				ComBkgXml2ComboItem(sXml, comboObjects[0], "eu_1st_port", "eu_1st_port|eu_1st_port_yd_cd|eu_1st_port_clpt_seq", true);
				var arr = new Array();
				arr = ComBkgXml2ComboString(sXml, "eu_1st_port", "eu_1st_port");
				if(arr == undefined || arr == ''){
					ComShowCodeMessage("BKG01144"); // No Data Found
					formObj.form_cstms_yd_cd.readOnly  = false;
					formObj.form_cstms_yd_cd.className ="input";
					return;
				}
				
				formObj.form_cstms_yd_cd.readOnly  = true;
				formObj.form_cstms_yd_cd.className ="input2";
				
				arr =  ComBkgXml2ComboString(sXml, "eu_1st_port_yd_cd", "eu_1st_port_yd_cd");
				eu_1st_port_yd_cd = arr[0].split("|");
				
				formObj.form_cstms_yd_cd.value = eu_1st_port_yd_cd[0].substring(5);
				
				// Add.
				arr =  ComBkgXml2ComboString(sXml, "eu_1st_port_clpt_seq", "eu_1st_port_clpt_seq");
				eu_1st_port_clpt_seq = arr[0].split("|");
				
				formObj.cstms_port_clpt_ind_seq.value = eu_1st_port_clpt_seq[0];
				// End.
				
				comboObjects[0].Index = 0;
			}
		break;
		
		case SEARCH03: // YARD Combo setting
			formObj.f_cmd.value = SEARCH03;
			formObj.rvis_n1st_clpt_cd.value = formObj.form_rvis_n1st_clpt_cd.value;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1105GS.do", FormQueryString(formObj));
			if(sXml.length > 0){
				ComBkgXml2ComboItem(sXml, comboObjects[1], "tml_cd", "tml_cd|n1st_port_ofc_cd_new", true);
				var arr = new Array();
				arr = ComBkgXml2ComboString(sXml, "tml_cd", "tml_cd");
				if(arr == undefined || arr == ''){
					//ComShowCodeMessage("BKG00889"); // No Data Found
					formObj.form_n1st_port_ofc_cd_new.value = '';
					n1st_port_ofc_cd_new = new Array();
					ComBkgXml2ComboItem('', comboObjects[1], "tml_cd", "tml_cd|n1st_port_ofc_cd_new", true);
					return;
				}else{
					var ydIndex = 0;
					if(formObj.form_rvis_cstms_yd_cd.value == ''){
						comboObjects[1].Index = 0;
					}else{
						arr =  ComBkgXml2ComboString(sXml, "tml_cd", "tml_cd");
						rvis_cstms_yd_cd = arr[0].split("|");
						
						for(var i = 0; i < rvis_cstms_yd_cd.length; i++){
							if(rvis_cstms_yd_cd[i] == formObj.form_rvis_cstms_yd_cd.value) ydIndex = i;
						}
						comboObjects[1].Index = ydIndex;
					}
					arr =  ComBkgXml2ComboString(sXml, "n1st_port_ofc_cd_new", "n1st_port_ofc_cd_new");
					n1st_port_ofc_cd_new = arr[0].split("|");
					formObj.form_n1st_port_ofc_cd_new.value = n1st_port_ofc_cd_new[ydIndex];
				}
			}
		break;
	}
}
var eu_1st_port_yd_cd = new Array();
var n1st_port_ofc_cd_new = new Array();
var rvis_cstms_yd_cd = new Array();
var eu_1st_port_clpt_seq = new Array();

// 시트 데이터 초기화
function initSheetData(sheetObj, formObj){
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);	
	
	IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");		
}

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case IBSEARCH:{ // 조회
			if(formObj.form_vvd.value == "" && formObj.form_cvy_ref_no.value == "") {
				//ComShowMessage("VVD또는 CRN No.중 반드시 1개 이상 입력해야합니다.");
				ComShowCodeMessage("BKG01090", "VVD", "CRN No.");
				ComSetFocus(formObj.form_vvd);
				return false;
			}
			break;
		}
		
		case IBSAVE:{ // 입력
			//기본포멧체크
			
			if(formObj.form_rvis_n1st_clpt_cd.value == ""){
				ComShowCodeMessage('BKG00715', "New Country & Port");
				ComSetFocus(formObj.form_rvis_n1st_clpt_cd);
				return false;
			}
			
			//if(formObj.form_n1st_port_ofc_cd_new.value == ""){
			//	ComShowCodeMessage('BKG00715', "New First Office");
			//	ComSetFocus(formObj.form_n1st_port_ofc_cd_new);
			//	return false;
			//}
			
			//if(formObj.form_n1st_port_ofc_cd.value == formObj.form_n1st_port_ofc_cd_new.value){
			//	ComShowCodeMessage('BKG01132');
			//	ComSetFocus(formObj.form_cstms_port_cd);
			//	return false;
			//}
			
			if(!ComChkValid(formObj))return false;

			//alert(comboObjects[0].Code + " : " + port);
			if(formObj.form_vvd.value == ""){
				ComShowCodeMessage('BKG00715', "VSL Code");
				ComSetFocus(formObj.form_vvd);
				return false;
			}


			var port = comboObjects[0].Code;
			if(port != undefined && port != ''){
				port = port.substring(0,2);
			}
			
			if(port == 'NL' && formObj.form_cvy_ref_no.value == ""){
				ComShowCodeMessage('BKG00715', "CRN No.");
				ComSetFocus(formObj.form_cvy_ref_no);
				return false;
			}

			break;
		}
		
		case REMOVE :{ // 삭제
			//기본포멧체크
			if(!ComChkValid(formObj))return false;
			
			if(sheetObj.RowCount == 0){
				ComShowCodeMessage('BKG00889');
				return false;
			}
			
			if(sheetObj.RowCount == 1){
				if(sheetObj.CellValue(1,"vvd_cd")== "" || sheetObj.CellValue(1,"pod_cd")== ""){
					ComShowCodeMessage('BKG00889');
					return false;
				}
			}
			break;
		}
		
		case MULTI01:{
			//기본포멧체크
			if(!ComChkValid(formObj)) return false;
			
			var port = comboObjects[0].Code;
			if(port != undefined && port != ''){
				port = port.substring(0,2);
			}
			
			if(port == 'NL' && formObj.form_cvy_ref_no.value == ""){
				ComShowCodeMessage('BKG00715', "CRN No.");
				ComSetFocus(formObj.form_cvy_ref_no);
				return false;
			}
			
			if(formObj.form_cstms_port_cd.value == ""){
				ComShowCodeMessage('BKG01128', "Original Port doen't exist. Pleas register.");
				ComSetFocus(formObj.form_cstms_port_cd);
				return false;
			}
			
			if(formObj.form_n1st_port_ofc_cd_new.value == "" || formObj.form_n1st_port_ofc_cd.value == ""){
				ComShowCodeMessage('BKG01131');
				ComSetFocus(formObj.form_n1st_port_ofc_cd_new);
				return false;
			}
			
			if(formObj.form_n1st_port_ofc_cd.value == formObj.form_n1st_port_ofc_cd_new.value){
				ComShowCodeMessage('BKG01132');
				ComSetFocus(formObj.form_cstms_port_cd);
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
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	if(ErrMsg == ""){
		if(document.form.f_cmd.value == MULTI && document.form.f_cmd_detail.value != "D"){
			ComShowCodeMessage('BKG00102');
			return false;
		} 
		
		if(document.form.f_cmd_detail.value == "D"){
			ComShowCodeMessage('BKG00593');
			return false;
		}
	} 
}

/**
 * 조회 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	
//		if(ErrMsg == ""){
//
//			if(sheetObj.Rowcount == 0){
//				ComShowCodeMessage('BKG00800');
//			}
//			
//		} 
}
	
/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp(){
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
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
	if(srcName == "form_rvis_n1st_clpt_cd"){
		if(formObj.form_rvis_n1st_clpt_cd.value != comboObjects[0].Code){
			formObj.form_rvis_n1st_clpt_cd.style.backgroundColor = "red";
		}else{
			formObj.form_rvis_n1st_clpt_cd.style.backgroundColor = "white";
		}
		doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
	}else if(srcName == "form_vvd"){
		var temp_vvd = formObj.form_vvd.value;
		doActionIBSheet(sheetObjects[0],formObj,IBINSERT);
		formObj.form_vvd.value = temp_vvd;
		formObj.p_vvd_cd.value = temp_vvd;
		doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
	}else if(srcName == "form_rvis_n1st_clpt_cd"){		//form_rvis_n1st_clpt_cd
		doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
	}else if(srcName == "form_cstms_yd_cd"){		
		var formObject = document.form;  

		// 사용자 입력값을 uppercase로 변경  
   	 	var comboText =  formObj.form_cstms_yd_cd.value.substring(0,5);
   	 	 
   	 	// 선택 또는 입력한  값이 콤보에 있으면 리턴
   	 	if (comboObjects[0].FindIndex(comboText, 0) != -1) { 
   	 		return; 
   	 	} 

   	   comboObjects[0].InsertItem(0, comboText, comboText); 
	   comboObjects[0].Text2 = comboText;  // 입력값이 선택되게 한다.
	}
}
 
 /**
  * 컨테이너 리스트 콤보 변경시 이벤트
  * @param comboObj
  * @param value
  * @param text
  * @return
  */
 function form_first_eu_port_OnChange(comboObj,value,text) {
		var formObj = document.form;
	 	var index = comboObj.Index;
	 	formObj.form_cstms_yd_cd.value = eu_1st_port_yd_cd[index];
	 	formObj.cstms_port_clpt_ind_seq.value = eu_1st_port_clpt_seq[index]; // Add.2015.12.02
 }
 
 /**
  * 컨테이너 리스트 콤보 변경시 이벤트
  * @param comboObj
  * @param value
  * @param text
  * @return
  */
 function form_tml_cd_OnChange(comboObj, value, text) {
	var formObj = document.form;
 	var index = comboObj.Index;
 	if(index < 0){
 		formObj.form_n1st_port_ofc_cd_new.value = '';
 		return;
 	}
 	formObj.form_n1st_port_ofc_cd_new.value = n1st_port_ofc_cd_new[index];
 } 
/* 개발자 작업  끝 */