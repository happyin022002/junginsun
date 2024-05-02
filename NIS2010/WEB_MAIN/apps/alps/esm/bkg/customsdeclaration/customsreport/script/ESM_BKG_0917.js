/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0917.js
*@FileTitle : Receive History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.04.16 박상훈
* 1.0 Creation
* 2011.11.15 변종건[CHM-201114372-01] 한국지역 적하목록 사전 제출 관련 SYS보완 요청
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0917()
{
	this.processButtonClick			= processButtonClick;
	this.funcChangeSearchOption		= funcChangeSearchOption;
	this.setSheetObject				= setSheetObject;
	this.loadPage					= loadPage;
	this.initSheet					= initSheet;
	this.doActionIBSheet			= doActionIBSheet;
	this.setComboObject				= setComboObject;
	this.initCombo					= initCombo;
	this.cboMsgTp_OnChange			= cboMsgTp_OnChange;
	this.cboTp_OnChange				= cboTp_OnChange;
	this.validateForm				= validateForm;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var comboObject1 = comboObjects[0];
	var comboObject2 = comboObjects[1];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;

		case "btn_new":
			sheetObject1.RemoveAll();
			formObject.reset();
			funcChangSearchOption(formObject, "date");
			formObject.from_dt.value = ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
			formObject.to_dt.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
			comboObject1.Code = "5CD";
			comboObject2.Code = "D";
			break;

		case "vvd":
			if( formObject.cboMsgTp.Code == "SCA" || formObject.cboMsgTp.Code == "5LI" || formObject.cboMsgTp.Code == "5LK"){
				funcChangSearchOption(formObject, "vvd");
			}
			break;
		case "bl_no":
			if( formObject.cboMsgTp.Code == "SCA" || formObject.cboMsgTp.Code == "5LI" || formObject.cboMsgTp.Code == "5LK"){
				funcChangSearchOption(formObject, "bl_no");
			}
			break;
		case "smt_no":
			if( formObject.cboMsgTp.Code == "SCA" || formObject.cboMsgTp.Code == "5LI" || formObject.cboMsgTp.Code == "5LK"){
				funcChangSearchOption(formObject, "smt_no");
			}
			break;
		case "from_dt":
			funcChangSearchOption(formObject, "date");
			break;
		case "to_dt":
			funcChangSearchOption(formObject, "date");
			break;
		 case "btn_calendar1":
 			var cal = new ComCalendarFromTo(); 
 			funcChangSearchOption(formObject, "date");
 			cal.select(formObject.from_dt,formObject.to_dt, 'yyyy-MM-dd'); 
 			break;
         case "btn_view":            	
        	doActionIBSheet(sheetObject1, formObject, SEARCH11);
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
 * 검색 조건 변경 처리
 * @param formObj
 * @param op
 * @return
 */
function funcChangSearchOption(formObj, op)
{
	switch(op) {
	case "date":
		formObj.vvd.value='';
		formObj.bl_no.value='';
		formObj.smt_no.value='';
		formObj.vvd.disabled=true;
		formObj.bl_no.disabled=true;
		formObj.smt_no.disabled=true;
		formObj.vvd.className = "input2";
		formObj.bl_no.className = "input2";
		formObj.smt_no.className = "input2";
		formObj.from_dt.className = "input1";
		formObj.to_dt.className = "input1";
		formObj.from_dt.disabled=false;
		formObj.to_dt.disabled=false;
		formObj.search_type[3].checked = true;
		break;
	case "vvd":
		formObj.vvd.value='';
		formObj.bl_no.value='';
		formObj.smt_no.value='';
		formObj.vvd.disabled=false;
		formObj.bl_no.disabled=true;
		formObj.smt_no.disabled=true;
		formObj.vvd.className = "input1";
		formObj.bl_no.className = "input2";
		formObj.smt_no.className = "input2";
		formObj.from_dt.className = "input2";
		formObj.to_dt.className = "input2";
		formObj.from_dt.disabled=true;
		formObj.to_dt.disabled=true;
		formObj.search_type[0].checked = true;
		formObj.vvd.focus();
		break;
	case "bl_no":
		formObj.vvd.value='';
		formObj.bl_no.value='';
		formObj.smt_no.value='';
		formObj.vvd.disabled=true;
		formObj.bl_no.disabled=false;
		formObj.smt_no.disabled=true;
		formObj.vvd.className = "input2";
		formObj.bl_no.className = "input1";
		formObj.smt_no.className = "input2";
		formObj.from_dt.className = "input2";
		formObj.to_dt.className = "input2";
		formObj.from_dt.disabled=true;
		formObj.to_dt.disabled=true;
		formObj.search_type[1].checked = true;
		formObj.bl_no.focus();
		break;
	case "smt_no":
		formObj.vvd.value='';
		formObj.bl_no.value='';
		formObj.smt_no.value='';
		formObj.vvd.disabled=true;
		formObj.bl_no.disabled=true;
		formObj.smt_no.disabled=false;
		formObj.vvd.className = "input2";
		formObj.bl_no.className = "input2";
		formObj.smt_no.className = "input1";
		formObj.from_dt.className = "input2";
		formObj.to_dt.className = "input2";
		formObj.from_dt.disabled=true;
		formObj.to_dt.disabled=true;
		formObj.search_type[2].checked = true;
		formObj.smt_no.focus();
		break;
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

	var formObject = document.form;
	
	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++) {
        initCombo(comboObjects[k],k+1);
    }
	
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 
    funcChangSearchOption(formObject, "date");
    
    formObject.from_dt.value = ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
	formObject.to_dt.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
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
	case "sheet1":      //sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 400;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = false;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 1, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(21, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false)

		var HeadTitle1 = "|Seq.|MSG|Receive Date|VVD|POL|POD|Office|B/L No.|MRN/ Submit No.|MSG STS|관련문서번호|수신정보|송진정보|호출부호|입항연도|입항횟수|MSG TEXT|User ID| ";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,	  	 0,    daCenter,    false,  "Status");
		InitDataProperty(0, cnt++ , dtDataSeq,	 	 	30,    daCenter,    true,     "Seq",     		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      		40,    daCenter,    true,     "msg_log_tp_cd", 	false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData, 	  	   150,    daCenter,    true,     "rcv_dt",    	 	false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      		90,    daCenter,    true,     "vvd",  			false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData, 		 	60,    daCenter,    true,     "pol_cd",    		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,   	 		40,    daCenter,	true,     "pod_cd",      	false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData, 	 	 	60,    daCenter,    true,     "ofc_cd",    		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      		90,    daCenter,    true,     "bl_no",  		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	   135,    daLeft,    	true,     "smt_amd_no",		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,     	   140,    daLeft,    	true,     "msg_sts",   		false,    "",      dfNone, 		0,     false,		false);
		
		InitDataProperty(0, cnt++ , dtData,     	   180,    daLeft,   	true,     "cstms_ref_nm",  		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,     	   180,    daLeft,    	true,     "edi_rcvr_nm",   		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,     	    90,    daCenter,    true,     "tml_cd",   			false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,     	    90,    daCenter,    true,     "kr_vsl_call_sgn_cd", false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,     	    90,    daCenter,    true,     "arr_yr",   			false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,     	    60,    daCenter,    true,     "call_knt",   		false,    "",      dfNone, 		0,     false,		false);
				
		InitDataProperty(0, cnt++ , dtData,      	   180,    daLeft,    	true,     "msg_text",   	false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      		80,    daCenter,    true,     "user_id",   		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtHidden,      		0,    daCenter,    true,     "rcv_seq",   		false,    "",      dfNone, 		0,     false,		false);
		InitDataProperty(0, cnt++ , dtHidden,      		0,    daCenter,    true,     "flt_file_ref_no",   		false,    "",      dfNone, 		0,     false,		false);

	}
	break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0917GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		break;

	case SEARCH11:      // Detail View
     	var Row = sheetObj.selectRow;
     	if (Row > 0) {
            	var param = "msg_log_tp_id="+sheetObj.CellValue(Row, "msg_log_tp_cd");
            		param = param + "&rcv_dt="+sheetObj.CellValue(Row, "rcv_dt")
            		      + "&smt_amd_no="+sheetObj.CellValue(Row, "smt_amd_no")
            		      + "&rcv_seq="+sheetObj.Cellvalue(Row, "rcv_seq")
            		      + "&flt_file_ref_no=" +sheetObj.Cellvalue(Row, "flt_file_ref_no")
            		      + "&pgmNo=ESM_BKG_0994";
            	ComOpenWindow("ESM_BKG_0994.do?"+param, "ESM_BKG_0994", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=660,height=520");
     	}
		break;
	}

}

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	  comboObjects[comboCnt++] = combo_obj;
}

/**
 * 콤보 초기화
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch(comboObj.id) {
	case "cboMsgTp":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("60|300");
			DropHeight = 400;
			ShowCol = 0;
			SetTitle("Type|Description");
			MultiSelect = false;
			MaxSelect = 1 ;			
			InsertItem(cnt ++, "SCA|수출 적하목록 정정 (CUSMOD)", 	"SCA");
			InsertItem(cnt ++, "5LI|수입 적하목록 정정 (IFTMOD)", 	"5LI");
			InsertItem(cnt ++, "5LK|하선 신고 정정     (CUSDMR)", 	"5LK");
			InsertItem(cnt ++, "5VJ|적하목록 취하신청서 송신     (PORTAL)", 	"5VJ");
			InsertItem(cnt ++, "6GB|항만시설사용신고필증", 	"6GB");
			InsertItem(cnt ++, "6G9|항만시설사용신고반려서", 	"6G9");
			InsertItem(cnt ++, "6TB|외항 위험물반입확인서", 	"6TB");
			InsertItem(cnt ++, "6TV|내항 위험물반입확인서", 	"6TV");
			InsertItem(cnt ++, "6G2|외항 위험물반입반려서", 	"6G2");
			InsertItem(cnt ++, "6G3|내항 위험물반입반려서", 	"6G3");
			Code = "SCA";
		}
		break;
	case "cboTp":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|100");
			DropHeight = 400;
			ShowCol = 0;
			SetTitle("Type|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "A|미주 LOCAL", "A");
			InsertItem(cnt ++, "B|아/구주 LOCAL", "B");
			InsertItem(cnt ++, "C|T/S", "C");
			InsertItem(cnt ++, "D|A+B+C+M", "D");
			InsertItem(cnt ++, "M|eMpty Local", "M");
			Code = "D";
		}
		break;    	            
	}
}

/**
 * MSG 콤보 변경 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboMsgTp_OnChange(comboObj,value,text) {
//	document.form.msg_log_tp_id.value = value;
	if( value == "5VJ"||value == "6GB"||value == "6G9"||value == "6TB"||value == "6TV"||value == "6G2"||value == "6G3" ){
		sheetObjects[0].RemoveAll();
		document.form.reset();
		funcChangSearchOption(document.form, "date");
		document.form.from_dt.value = ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
		document.form.to_dt.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
//		comboObjects[0].Code = "5VJ";
		comboObjects[1].Code = "D";
		
		for( var idx=0;idx<document.form.search_type.length;idx++ ){
			document.form.search_type[idx].disabled = true;
		}
		
		document.form.cboTp.enable = false;
		document.form.pol_cd.disabled = true;
		document.form.pol_cd.className = "input2";
		document.form.pod_cd.disabled = true;
		document.form.pod_cd.className = "input2";
		document.form.ofc_cd.disabled = true;
		document.form.ofc_cd.className = "input2";
		document.form.user_id.disabled = true;
		document.form.user_id.className = "input2";
		
		if( value == "5VJ" ){
			
			sheetObjects[0].ColHidden("cstms_ref_nm") = true;
			sheetObjects[0].ColHidden("edi_rcvr_nm") = true;
			sheetObjects[0].ColHidden("tml_cd") = true;
			sheetObjects[0].ColHidden("kr_vsl_call_sgn_cd") = true;
			sheetObjects[0].ColHidden("arr_yr") = true;
			sheetObjects[0].ColHidden("call_knt") = true;
			
			sheetObjects[0].ColHidden("vvd") = false;
			sheetObjects[0].ColHidden("pol_cd") = false;
			sheetObjects[0].ColHidden("pod_cd") = false;
			sheetObjects[0].ColHidden("ofc_cd") = false;
			sheetObjects[0].ColHidden("bl_no") = false;
			sheetObjects[0].ColHidden("smt_amd_no") = false;
			sheetObjects[0].ColHidden("msg_sts") = false;
			
		} else {
			
			sheetObjects[0].ColHidden("cstms_ref_nm") = false;
			sheetObjects[0].ColHidden("edi_rcvr_nm") = false;
			sheetObjects[0].ColHidden("tml_cd") = false;
			sheetObjects[0].ColHidden("kr_vsl_call_sgn_cd") = false;
			sheetObjects[0].ColHidden("arr_yr") = false;
			sheetObjects[0].ColHidden("call_knt") = false;
			
			sheetObjects[0].ColHidden("vvd") = true;
			sheetObjects[0].ColHidden("pol_cd") = true;
			sheetObjects[0].ColHidden("pod_cd") = true;
			sheetObjects[0].ColHidden("ofc_cd") = true;
			sheetObjects[0].ColHidden("bl_no") = true;
			sheetObjects[0].ColHidden("smt_amd_no") = true;
			sheetObjects[0].ColHidden("msg_sts") = true;
			
		}		
	} else{
		
		for( var idx=0;idx<document.form.search_type.length;idx++ ){
			document.form.search_type[idx].disabled = false;
		}
		sheetObjects[0].RemoveAll();
		document.form.reset();
		funcChangSearchOption(document.form, "date");
		document.form.from_dt.value = ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
		document.form.to_dt.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
		
		document.form.cboTp.enable = true;
		document.form.cboTp.disabled = false;
		document.form.pol_cd.disabled = false;
		document.form.pol_cd.className = "input";
		document.form.pod_cd.disabled = false;
		document.form.pod_cd.className = "input";
		document.form.ofc_cd.disabled = false;
		document.form.ofc_cd.className = "input";
		document.form.user_id.disabled = false;
		document.form.user_id.className = "input";
		
		sheetObjects[0].ColHidden("cstms_ref_nm") = true;
		sheetObjects[0].ColHidden("edi_rcvr_nm") = true;
		sheetObjects[0].ColHidden("tml_cd") = true;
		sheetObjects[0].ColHidden("kr_vsl_call_sgn_cd") = true;
		sheetObjects[0].ColHidden("arr_yr") = true;
		sheetObjects[0].ColHidden("call_knt") = true;
		
		sheetObjects[0].ColHidden("vvd") = false;
		sheetObjects[0].ColHidden("pol_cd") = false;
		sheetObjects[0].ColHidden("pod_cd") = false;
		sheetObjects[0].ColHidden("ofc_cd") = false;
		sheetObjects[0].ColHidden("bl_no") = false;
		sheetObjects[0].ColHidden("smt_amd_no") = false;
		sheetObjects[0].ColHidden("msg_sts") = false;
	}
}

/**
 * Type 콤보 변경 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboTp_OnChange(comboObj,value,text) {
	document.form.tp_cd.value = value;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		
	}

	return true;
}

function sheet1_OnDblClick(sheetObj, Row, Col){
	doActionIBSheet(sheetObj, document.form, SEARCH11); 	
}
