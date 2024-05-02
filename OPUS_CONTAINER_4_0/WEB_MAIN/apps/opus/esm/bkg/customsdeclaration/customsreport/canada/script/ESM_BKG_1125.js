/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESM_BKG_1125.js
 *@FileTitle : CANADA ACI : ACI Monitoring
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.07.13
 *@LastModifier : 김봉균
 *@LastVersion : 1.0
 * 2011.07.13 김봉균
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var combo1=null;
var comboCnt=0; 
// 전역변수
var intervalId="";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_New":
			formObject.reset();
			document.getElementById("p_pol_ofc").style.display="inline";
			document.getElementById("p_bkg_ofc").style.display="none";
			document.form.rhq.index=-1;
			div_init();
			break;
		case "btn_DownExcel": 	
			if(sheetObject1.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
                return;
            }
			sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
			break;
		case "btn_date":
			var cal=new ComCalendarFromTo();
			cal.setEndFunction("endDateSet");
			cal.select(formObject.p_from_dt, formObject.p_to_dt, 'yyyy-MM-dd');
			break;
	} // end switch
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * 콤보 Object를 comboObjects 배열에 등록
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    //initializing MultiCombo
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    
    initControl();
}

function initControl() {

    var formObject=document.form;
    axon_event.addListenerForm  ('click', 'bkg_click',  formObject); //- onClick     
    axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
    axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
    axon_event.addListenerForm  ('change', 'bkg_change', formObject);
    axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
    axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
    axon_event.addListenerFormat('keyup', 'obj_KeyUp', formObject); //- 키보드 입력할때
    axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
    // IBMultiCombo초기화
    for(var k=0; k<comboObjects.length; k++){
        initCombo(comboObjects[k]);
    }
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}

/**
 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * 
 * @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
 * @param {String} comboId 필수,combo ID
 * @return 없음.
 */
function initCombo(comboObj, comboId) {
	comboObj.SetDropHeight(150);
}

/**
 * HTML Control의 onBlur을 제어한다.
 */
function bkg_blur() {
	var formObj=document.form;
	switch (ComGetEvent("name")) {
	case "p_from_dt":
		ComAddSeparator(event.srcElement);
		break;
	case "p_to_dt":
		ComAddSeparator(event.srcElement);
		break;
	default:
		break;
	}
}
/**
 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
 */
function bkg_focus() {
	// 입력Validation 확인하기
	switch (event.srcElement.name) {
	case "p_from_dt":
		ComClearSeparator(event.srcElement);
		break;
	case "p_to_dt":
		ComClearSeparator(event.srcElement);
		break;
	}
}

function div_init() {
	
    sheetObjects[0].RemoveAll();
    if (document.form.p_rhq_gb[0].checked) {
		sheetObjects[0].SetCellValue(0, "bkg_ofc",'POL OFC');
		sheetObjects[0].SetCellValue(1, "bkg_ofc",'POL OFC');
	} else if (document.form.p_rhq_gb[1].checked) {
		sheetObjects[0].SetCellValue(0, "bkg_ofc",'BKG OFC');
		sheetObjects[0].SetCellValue(1, "bkg_ofc",'BKG OFC');
	}
    
	form.div_total_bl_cnt.value="";
	form.div_acc_bl_cnt.value="";
	form.div_rej_bl_cnt.value="";
	form.div_nrcv_bl_cnt.value="";
	form.div_donld_bl_cnt.value="";
	form.div_rlse_bl_cnt.value="";
	form.div_unsent_bl_cnt.value="";
	form.div_podirr_bl_cnt.value="";
	form.div_total_cms_cnt.value="";
	form.div_total_shaas_ens.value="";
	form.div_total_nycna_ens.value="";
	form.div_total_hamur_ens.value="";
	form.div_total_sinwa_ens.value="";
	form.div_total_vvd_cnt.value="";
	form.div_total_mcf_amt.value="";
	form.div_total_shaas_mcf.value="";
	form.div_total_nycna_mcf.value="";
	form.div_total_hamur_mcf.value="";
	form.div_total_sinwa_mcf.value="";
	form.div_total_amd_cnt.value="";
}

function bkg_click() {
	switch (event.srcElement.name) {
	case "p_rhq_gb":
		if (document.form.p_rhq_gb[0].checked) {
			// 초기화
			div_init();
			document.getElementById("p_pol_ofc").style.display="inline";
			document.getElementById("p_bkg_ofc").style.display="none";
			
		} else if (document.form.p_rhq_gb[1].checked) {
			// 초기화
			div_init();
			document.getElementById("p_pol_ofc").style.display="none";
			document.getElementById("p_bkg_ofc").style.display="inline";
		}
		break;
	}
}

/**
 * 조회후 이벤트 처리 >>> 폰트 칼라변경
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var redColor="#FF0000";
		for ( var i=HeaderRows(); i <= LastRow(); i++) {
			if (GetCellValue(i, "rejected") != "0") {
				SetCellFontColor(i, "rejected",redColor);
			}
			if (GetCellValue(i, "not_received") != "0") {	
				SetCellFontColor(i, "not_received",redColor);
			}
			if (GetCellValue(i, "unsent") != "0") {		
				SetCellFontColor(i, "unsent",redColor);
			}
		}
		ColumnSort("1|2|3|4|5|6|7|8|9");
	}// end width
}

/**
 * 컬럼이동 전 validation 처리 >>> 이동취소
 */
function sheet1_OnBeforeColumnMove(sheetObj, Col, NewPos) {
	with (sheetObj) {
		if (NewPos > 9) {
			MoveColumnFail(true);
		}
		if (Col > 9) {
			MoveColumnFail(true);
		}
	}
}

/**
 * 컬럼이동 후 이벤트 처리 >>> 재소트
 */
function sheet1_OnAfterColumnMove(sheetObj, Col, NewPos) {
	with (sheetObj) {
		var colNo="";
		for ( var i=NewPos; i < LastCol(); i++) {
			colNo=colNo + "|" + i;
		}
		ColumnSort(colNo);
	}
}


function endDateSet() {
	if (ComIsNull(form.p_from_mt)) {
		form.p_from_mt.value="00:00";
	}
	if (ComIsNull(form.p_to_mt)) {
		form.p_to_mt.value="23:59";
	}
}

/**
 * Sheet관련 프로세스 처리<br>
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBCLEAR: // 화면 로딩시 코드 조회
		formObj.f_cmd.value=COMMAND01;
		var sXml = sheetObj.GetSearchData("ESM_BKG_1125GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], rhq, "val", "name");
		formObj.rhq.index=-1;
		break;
	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.RenderSheet(0);
		sheetObj.SetWaitImageVisible(1);
		formObj.f_cmd.value=SEARCH;
		sheetObj.RemoveAll();
		
		var sXml=sheetObj.GetSearchData("ESM_BKG_1125GS.do", FormQueryString(formObj));
		sheetObj.LoadSearchData(sXml,{Sync:0} );
		
		if (ComGetEtcData(sXml, "total_bl_cnt") == undefined) {
			formObj.div_total_bl_cnt.value="0";
			formObj.div_acc_bl_cnt.value="0";
			formObj.div_rej_bl_cnt.value="0";
			formObj.div_nrcv_bl_cnt.value="0";
			formObj.div_donld_bl_cnt.value="0";
			formObj.div_rlse_bl_cnt.value="0";
			formObj.div_unsent_bl_cnt.value="0";
			formObj.div_podirr_bl_cnt.value="0";
			formObj.div_total_cms_cnt.value="0";
			formObj.div_total_shaas_ens.value="0";
			formObj.div_total_nycna_ens.value="0";
			formObj.div_total_hamur_ens.value="0";
			formObj.div_total_sinwa_ens.value="0";
			formObj.div_total_vvd_cnt.value="0";
			formObj.div_total_mcf_amt.value="0";
			formObj.div_total_shaas_mcf.value="0";
			formObj.div_total_nycna_mcf.value="0";
			formObj.div_total_hamur_mcf.value="0";
			formObj.div_total_sinwa_mcf.value="0";
			formObj.div_total_amd_cnt.value="0";
		} else {
			formObj.div_total_bl_cnt.value=ComGetEtcData(sXml, "total_bl_cnt");
			formObj.div_acc_bl_cnt.value=ComGetEtcData(sXml, "acc_bl_cnt");
			formObj.div_rej_bl_cnt.value=ComGetEtcData(sXml, "rej_bl_cnt");
			formObj.div_nrcv_bl_cnt.value=ComGetEtcData(sXml, "nrcv_bl_cnt");
			formObj.div_donld_bl_cnt.value=ComGetEtcData(sXml, "donld_bl_cnt");
			formObj.div_rlse_bl_cnt.value=ComGetEtcData(sXml, "rlse_bl_cnt");
			formObj.div_unsent_bl_cnt.value=ComGetEtcData(sXml, "unsent_bl_cnt");
			formObj.div_podirr_bl_cnt.value=ComGetEtcData(sXml, "podirr_bl_cnt");
			formObj.div_total_cms_cnt.value=ComGetEtcData(sXml, "total_cms_cnt");
			formObj.div_total_shaas_ens.value=ComGetEtcData(sXml, "total_shaas_ens");
			formObj.div_total_nycna_ens.value=ComGetEtcData(sXml, "total_nycna_ens");
			formObj.div_total_hamur_ens.value=ComGetEtcData(sXml, "total_hamur_ens");
			formObj.div_total_sinwa_ens.value=ComGetEtcData(sXml, "total_sinwa_ens");
			formObj.div_total_vvd_cnt.value=ComGetEtcData(sXml, "total_vvd_cnt");
			formObj.div_total_mcf_amt.value=ComGetEtcData(sXml, "total_mcf_amt");
			formObj.div_total_shaas_mcf.value=ComGetEtcData(sXml, "total_shaas_mcf");
			formObj.div_total_nycna_mcf.value=ComGetEtcData(sXml, "total_nycna_mcf");
			formObj.div_total_hamur_mcf.value=ComGetEtcData(sXml, "total_hamur_mcf");
			formObj.div_total_sinwa_mcf.value=ComGetEtcData(sXml, "total_sinwa_mcf");
			formObj.div_total_amd_cnt.value=ComGetEtcData(sXml, "total_amd_cnt");
		}
		sheetObj.RenderSheet(1);
		sheetObj.SetWaitImageVisible(0);

		break;
	}// end switch
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		// 기본포멧체크
		if (ComIsNull(formObj.p_vvd)) {
			if (ComIsNull(formObj.p_from_dt)) {
				ComShowCodeMessage('BKG00104', 'From Date'); // "Mandatory item is missing. Please enter ({?msg1})"
				formObj.p_from_dt.focus();
				return false;
			}
			if (ComIsNull(formObj.p_to_dt)) {
				ComShowCodeMessage('BKG00104', 'To Date'); // "Mandatory item is missing. Please enter ({?msg1})"
				formObj.p_to_dt.focus();
				return false;
			}
			if (ComGetDaysBetween(formObj.p_from_dt, formObj.p_to_dt) < 0) {
				ComShowMessage(msgs['BKG00818']); // "From Date couldn't be greater than ToDate."
				return false;
			}
		}
		if ((!ComIsNull(formObj.p_from_dt) && !ComIsNull(formObj.p_to_dt))) {
			if (ComGetDaysBetween(formObj.p_from_dt.value, formObj.p_to_dt.value) + 1 > 31) {
				ComShowCodeMessage('COM132001', 'Send/Received Date', '31 Days'); // '{?msg1} exceeds maximum duration {?msg2}.'
				formObj.p_from_dt.focus();
				return false;
			}
			return true;
		}
		break;
	}
	return true;
}
/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	
	if ((srcName == "p_vvd" || srcName == "p_pol") && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	
    switch (sheetID) {
    case "sheet1": //sheet1 init
        with(sheetObj){
    		var HeadTitle1="";
			var HeadTitle2="";
			if (document.form.p_rhq_gb[0].checked) {
				HeadTitle1="|VVD|LANE|RHQ|POL OFC|POL|POD|BL\nTYPE|BL Count|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Unsent|Amend\ncount|Surcharge|Surcharge";
				HeadTitle2="|VVD|LANE|RHQ|POL OFC|POL|POD|BL\nTYPE|BL Count|Acpt\n(06)|Rej\n(44)|DNL\n(37)|Release\n(01)|POD\nHold\n(21)|Do not\nunload\n(48)|Not\nRcvd|Unsent|Amend\ncount|CMS+SMC|MCF";
			
			} else if (document.form.p_rhq_gb[1].checked) {
				HeadTitle1="|VVD|LANE|RHQ|BKG OFC|POL|POD|BL\nTYPE|BL Count|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Sent Status|Unsent|Amend\ncount|Surcharge|Surcharge";
				HeadTitle2="|VVD|LANE|RHQ|BKG OFC|POL|POD|BL\nTYPE|BL Count|Acpt\n(06)|Rej\n(44)|DNL\n(37)|Release\n(01)|POD\nHold\n(21)|Do not\nunload\n(48)|Not\nRcvd|Unsent|Amend\ncount|CMS+SMC|MCF";
			}
			var headCount = ComCountHeadTitle(HeadTitle1);
		
			SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"},
			                { Text:HeadTitle2, Align:"Center"} ];
            
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"lane",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rhq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bl_type",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bl_count",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"accepted",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rejected",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dnl",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"released",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_hold",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"do_not_unload",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"not_received",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"unsent",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"amend_cnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cms_smc_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mcf_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            
	        InitColumns(cols);
	        SetEditable(1);
	        SetSheetHeight(390);
        }
    break;
    }
}
