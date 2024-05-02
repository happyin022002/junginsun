/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : GeoHierarchyManageDBDAO.java
*@FileTitle : Geographic Hierarchy 정보관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : kimyoungchul
*@LastVersion : 1.0 
* 2006-08-30 kimyoungchul
* 1.0 최초 생성
* N200903020010 2009-03-02 'Geographical Inquiry' 화면 변경 요청
* 2009.07.01 alps framework 구조로 변경 Noh Seung Bae
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	var param ;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		/****************************
             enterKey 처리
            *****************************/
		var srcObj=window.event.srcElement.nodeName;
		var keyObj=window.event.keyCode;
		if(srcObj =='INPUT' && keyObj ==13) {
			srcName ='btn_retrieve';
		//                ComShowMessage(srcName+':srcName')
		}
		/****************************/
		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_new":
				sheetObject.RemoveAll();
			
				var opts = formObject.select2;
				  for(var i=opts.length-1; i>0 ; i--) {
				   opts[i].parentNode.removeChild(opts[i]);
				  }

				formObject.reset();
				
				break;

			case "btn_location":
				param = '?classId=COM_ENS_051&loc_cd='+formObject.location_code.value;
				ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getLocation', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				break;
                    
			case "btn_country":
				param = '?classId=COM_ENS_051&cnt_cd='+formObject.country_code.value;
				ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e);
		}
	}
}

function getCountry(rowArray) {
	var colArray = rowArray[0];
	document.form.country_code.value = colArray[3];
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

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keypress', 'PrdComKeyEnter' , 'country_code', 'region_code', 'location_code');

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:      //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				style.height = 140 ;
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(37, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "No.|Continent|Continent|Sub Continent|Sub Continent|Country Code|Country Code|Country Code|Region|Region|Location|Location|Remarks|"+
				"SteCd|SteNm|UnLocFlg|UnLocCd|LocGrdNo|RccCd|LccCd|EccCd|SccCd|LocChrCd|"+
				"SlsOfcCd|EqCtrlOfcCd|FincCtrlOfcCd|SenEqOfcCd|BkgBlPfxCd|ComercialZone|"+
				"Customers|RepZdnCd|EqRtnYdCd|LocAmsPortCd|GmtHrs|PortInlndCd|CallPortFlg" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,       30,   daCenter,  true,    "",                false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      30,   daCenter,  true,    "conti_cd"      ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    "conti_nm"      ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      30,   daCenter,  true,    "sconti_cd"     ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      90,   daLeft,    true,    "sconti_nm"     ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      30,   daCenter,  true,    "cnt_cd"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      70,   daLeft,    true,    "cnt_nm"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  true,    "bsel_co"       ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      30,   daCenter,  true,    "rgn_cd"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,     125,   daLeft,    true,    "rgn_nm"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "loc_cd"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  true,    "loc_nm"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "remark"       ,  false,     "",       dfNone,       0,        false,      false);

				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "ste_cd"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "ste_nm"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "unloc_flg"     ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "unloc_cd"      ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "loc_grd_no"     ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "rcc_cd"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "lcc_cd"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "ecc_cd"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "scc_cd"        ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "loc_chr_cd"     ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "sls_ofc_cd"     ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "eq_ctrl_ofc_cd"  ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "finc_ctrl_ofc_cd",  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "sen_eq_ofc_cd"   ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "bkg_bl_pfx_cd"   ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "comercial_zone",  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "customers"    ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "rep_zn_cd"     ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "eq_rtn_yd_cd"    ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "loc_ams_port_cd" ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "gmt_hrs"       ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "port_inlnd_cd"  ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "call_port_flg"  ,  false,     "",       dfNone,       0,        false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    30,   daCenter,  true,    "mty_pkup_yd_cd"  ,  false,     "",       dfNone,       0,        false,      false);

				}
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	var sXml ;
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			form_clear();
			if(formObj.subconti_code.value=='' && formObj.country_code.value=='' && formObj.region_code.value=='' && formObj.location_code.value==''){
				ComShowMessage(ComGetMsg("PRD90001"));
				
				// TODO 코드메시지가 작동하면 풀자
				return;
			}
			if(validateForm(sheetObj,formObj,sAction))
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_PRD_0001GS.do", PrdFQString(formObj));
			break;

		case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction))
				break;

		case IBINSERT:      // 입력
			if(validateForm(sheetObj,formObj,sAction))
				sheetObj.DataInsert();
			break;

		case IBCOPYROW:        //행 복사
			sheetObj.DataCopy();
			break;

		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
			break;

		case IBLOADEXCEL:        //엑셀 업로드
			sheetObj.LoadExcel();
			break;
           
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid=ESD_PRD_0001&check_data="+validateData+"&"+PrdFQString(formObj));
              
			sheetObj.LoadSearchXml(sXml,true, -1, true);
			retValidate = sheetObjects[0].EtcData("rowCount");
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		//            if (!isNumber(iPage)) {
		//
		//                return false;
		//            }
	}

	return true;
}

/*
     * * N200903020010 2009-03-02 'Geographical Inquiry' 화면 변경 요청
     */
function sheet1_OnDblClick(sheetObj, row, col, value) {
	var formObj  = document.form ;
	formObj.g_cnti_cd.value    = sheetObj.cellValue(row, "conti_cd");
	formObj.g_cnti_nm.value    = sheetObj.cellValue(row, "conti_nm");
	formObj.g_ste_cd.value     = sheetObj.cellValue(row, "ste_cd");
	formObj.g_ste_nm.value     = sheetObj.cellValue(row, "ste_nm");
	formObj.g_subcnti_cd.value = sheetObj.cellValue(row, "sconti_cd");
	formObj.g_subcnti_nm.value = sheetObj.cellValue(row, "sconti_nm");
	formObj.g_loc_cd.value     = sheetObj.cellValue(row, "loc_cd");
	formObj.g_loc_nm.value     = sheetObj.cellValue(row, "loc_nm");
	formObj.g_cntr_cd.value    = sheetObj.cellValue(row, "cnt_cd");
	formObj.g_cntr_nm.value    = sheetObj.cellValue(row, "cnt_nm");
	formObj.g_un_flag.value    = sheetObj.cellValue(row, "unloc_flg");
	formObj.g_un_cd.value      = sheetObj.cellValue(row, "unloc_cd");
	formObj.g_rgn_cd.value     = sheetObj.cellValue(row, "rgn_cd");
	formObj.g_rgn_nm.value     = sheetObj.cellValue(row, "rgn_nm");
	formObj.loc_grid.value     = sheetObj.cellValue(row, "loc_grd_no");
	formObj.sls_ofc.value      = sheetObj.cellValue(row, "sls_ofc_cd");
	formObj.rcc_cd.value       = sheetObj.cellValue(row, "rcc_cd");
	formObj.bl_frefix.value    = sheetObj.cellValue(row, "bkg_bl_pfx_cd");
	formObj.cms_zone.value     = sheetObj.cellValue(row, "comercial_zone");
	formObj.eq_ofc.value       = sheetObj.cellValue(row, "eq_ctrl_ofc_cd");
	formObj.lcc_cd.value       = sheetObj.cellValue(row, "lcc_cd");
	formObj.custms.value       = sheetObj.cellValue(row, "customers");
	formObj.rep_zn_cd.value   = sheetObj.cellValue(row, "rep_zn_cd");
	formObj.fin_ofc.value      = sheetObj.cellValue(row, "finc_ctrl_ofc_cd");
	formObj.ecc_cd.value       = sheetObj.cellValue(row, "ecc_cd");
	formObj.loc_char.value     = sheetObj.cellValue(row, "loc_chr_cd");
	formObj.refre_cy.value     = sheetObj.cellValue(row, "eq_rtn_yd_cd");
	formObj.sen_ofc.value      = sheetObj.cellValue(row, "sen_eq_ofc_cd");
	formObj.scc_cd.value       = sheetObj.cellValue(row, "scc_cd");
	formObj.gmt.value          = sheetObj.cellValue(row, "gmt_hrs");
	formObj.ams_cd.value       = sheetObj.cellValue(row, "loc_ams_port_cd");
	formObj.port_cd.value      = sheetObj.cellValue(row, "port_inlnd_cd");
	formObj.coll_port.value    = sheetObj.cellValue(row, "call_port_flg");
	formObj.mty_pkup_yd_cd.value    = sheetObj.cellValue(row, "mty_pkup_yd_cd");
}

//////////////////////////////////////////////////////////////

function changeContinent() {
	var list = document.form.select1;
	var c_code = list.options[list.selectedIndex].value;
	if(c_code!='0'){
		document.form.f_cmd.value = SEARCH19;
		document.form.conti_code.value = c_code ;
		document.form.subconti_code.value = '' ;
		document.form.action = "ESD_PRD_COM_0002.do";
		document.form.target = "HiddenFrame";
		document.form.submit();
	} else {
		document.form.conti_code.value = '' ;
		document.form.subconti_code.value = '' ;
		var opts = document.form.select2;
		  for(var i=opts.length-1; i>0 ; i--) {
		   opts[i].parentNode.removeChild(opts[i]);
		  }
	}
}

function changeSubContinent() {
	var list = document.form.select2;
	var c_code = list.options[list.selectedIndex].value;
	if(c_code!='0'){
		document.form.f_cmd.value = '101';
		document.form.subconti_code.value = c_code ;
	}else{
		document.form.subconti_code.value = '' ;
	}
}

// location input 에서 찾기 팝업 실행에서 호출
function getLocation(rowArray) {
	var colArray = rowArray[0];
	document.form.location_code.value = colArray[3];
}


function form_clear() {
	var formObj  = document.form ;
	formObj.g_cnti_cd.value    = "";
	formObj.g_cnti_nm.value    = "";
	formObj.g_ste_cd.value     = "";
	formObj.g_ste_nm.value     = "";
	formObj.g_subcnti_cd.value = "";
	formObj.g_subcnti_nm.value = "";
	formObj.g_loc_cd.value     = "";
	formObj.g_loc_nm.value     = "";
	formObj.g_cntr_cd.value    = "";
	formObj.g_cntr_nm.value    = "";
	formObj.g_un_flag.value    = "";
	formObj.g_un_cd.value      = "";
	formObj.g_rgn_cd.value     = "";
	formObj.g_rgn_nm.value     = "";
	formObj.loc_grid.value     = "";
	formObj.sls_ofc.value      = "";
	formObj.rcc_cd.value       = "";
	formObj.bl_frefix.value    = "";
	formObj.cms_zone.value     = "";
	formObj.eq_ofc.value       = "";
	formObj.lcc_cd.value       = "";
	formObj.custms.value       = "";
	formObj.rep_zn_cd.value   = "";
	formObj.fin_ofc.value      = "";
	formObj.ecc_cd.value       = "";
	formObj.loc_char.value     = "";
	formObj.refre_cy.value     = "";
	formObj.sen_ofc.value      = "";
	formObj.scc_cd.value       = "";
	formObj.gmt.value          = "";
	formObj.ams_cd.value       = "";
	formObj.port_cd.value      = "";
	formObj.coll_port.value    = "";
}       	