/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_SCE_0161.js
 *@FileTitle : SCEM - Candidate Inquiry by Dwell Type -96hrs Terminal Dwell
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.15
 *@LastModifier : 채창호
 *@LastVersion : 1.0
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class ESD_SCE_0161 : ESD_SCE_0161 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

function ESD_SCE_0161() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var isFirstOnLoad = "false";
var isCopyAllRequested = false;
var saveFail = false;
var saveSuccess = true;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_copyemail":
			openEmailCopy();
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	 
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
}


/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	 

	var cnt = 0;

	switch (sheetNo) {
	case 1: 
		with (sheetObj) {
			// 높이 설정
			style.height = 380;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 4, 3000);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(43, 2, 0, true); //24

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "||SEQ|CNTR NO|Type & Size|Mode|BKG No|BL No|Lane|VVD|POD|"
							//+"DEL|Delivery Term|Rail Origin Yard|Rail Dest Yard|Movement/Yard|Movement date|Dwell Hours|Dwell Reasons|Fixed POD LFD|F|O|C|Customs Date|Customs location|Sent status|E-mailing list|Exception Status|"
				            +"DEL|Delivery Term|Rail Origin Yard|Rail Dest Yard|Movement/Yard|Movement date|Dwell Hours|Total Dwell Reasons|Dwell Reasons Type|Fixed POD LFD|F|O|C|Customs Date|Customs location|"
							//+"Shipper|E-mailing list|Sent status|Exception Status|Consignee|E-mailing list|Sent status|Exception Status|Notify|E-mailing list|Sent status|Exception Status|Batch Date|Dwell Type";
				            +"S/C No(BKG Main)(1)|S/C Customer(1)|E-mailing list(1)|Sent status(1)|Exception Status(1)|Consignee(2)|E-mailing list(2)|Sent status(2)|Exception Status(2)|Notify(3)|E-mailing list(3)|Sent status(3)|Exception Status(3)|Batch Date|Dwell Type|SEQ|TP_CD";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
		
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true, "chk"       , false,"", dfNone,     0, true , true );
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cntr_no"      , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "cntr_tpsz_cd" , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "so_mode"      , false,"", dfNone,     0, false , false);
		    InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "bkg_no"       , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "bl_no"        , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vsl_slan_cd"  , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vvd_cd"       , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pod_cd"       , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "del_cd"       , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "de_term_cd"   , false,"", dfNone,     0, false , false);
            InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "rail_org_yd_cd"    , false,"", dfNone,     0, false , false);
            InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "rail_dest_yd_cd"   , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "mvmt_sts_yd"      , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "cnmv_evnt_dt"     , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "dwll_hrs"          , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "dwll_rsn"           , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtCombo, 180, daLeft, true, "dwll_rsn_tp_cd"     , false,"", dfNone,     0, true , true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "ft_end_dt"         , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "frt_clt_flg"       , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "obl_rdem_flg"      , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cstms_clr_cd"      , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "cstms_clr_lst_dt" , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "cstms_loc_cd"     , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "sc_no"        , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "cust_cd_nm"    , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "eml_cnt"          , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "snd_sts"           , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "excp_sts"         , false,"", dfNone,     0, false , false);
			//InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "shpr_cust_cd_nm"    , false,"", dfNone,     0, false , false);
			//InitDataProperty(0, cnt++, dtData, 150, daCenter, false,  "shpr_eml_cnt"    , false,"", dfNone,     0, false , false);
			//InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "shpr_snd_sts"      , false,"", dfNone,     0, false , false);
			//InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "shpr_excp_sts"    , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "cnee_cust_cd_nm"    , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false,  "cnee_eml_cnt"    , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "cnee_snd_sts"      , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "cnee_excp_sts"    , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "ntfy_cust_cd_nm"    , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false,  "ntfy_eml_cnt"    , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "ntfy_snd_sts"      , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "ntfy_excp_sts"    , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "eml_snd_dt"      , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "dwll_tm_tp_cd_desc" , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "dwll_rsn_tp_cd1" , false,"", dfNone,     0, false , false);
			InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "dwll_tm_tp_cd" , false,"", dfNone,     0, false , false);
			
			DataLinkMouse('eml_cnt') = true;
			DataLinkMouse('shpr_eml_cnt') = true;
			DataLinkMouse('cnee_eml_cnt') = true;
			DataLinkMouse('ntfy_eml_cnt') = true;
			InitDataCombo (0 , "dwll_rsn_tp_cd",  "| |Demurrage Pending|Available for Pick up", "| |D|A");
              
//			WaitImageVisible=false;
		}
		break;
	}
}

function initControl() {
}




//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH:
		if( formObj.search_dt.value == "") return;
		//tab page 별로 시트데이터 데이터 로드 여부 체크
		if( parent.document.form.t1_load_flg.value == 'Y' ) return;
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH ;
		sheetObj.DoSearch("ESD_SCE_0161GS.do", SceFrmQryString(formObj));
		//메인페이지에 해당 tab의 데이터 load 여부를 'Y'로 입력
		parent.document.form.t1_load_flg.value = 'Y';
		//메인tab의 total count값을 set해줌.
		parent.setTabTotal(0, sheetObj.TotalRows);
		break;
	case IBDOWNEXCEL:        //엑셀 다운로드
//	    sheetObj.Down2Excel(-1, false, false, true);
	    ComOpenWait(true);
	    sheetObj.SpeedDown2Excel(1, false, false);
	    ComOpenWait(false);
		break;
		
	}
	
}

/**
 * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
 * 화면이 보여지며 조회를 한다.<br>
 */ 
function tabLoadSheet() {
	var formObject = document.form;
	var parentObject = parent.document.form;
	if( parentObject.search_dt.value != null && parentObject.search_dt.value != ""){
		formObject.search_dt.value = parentObject.search_dt.value;
	}else{
		formObject.search_dt.value = "";
	}
	if( parentObject.sc_no.Code != null && parentObject.sc_no.Code != ""){
		formObject.sc_no.value = parentObject.sc_no.Code;
	}else{
		formObject.sc_no.value = "";
	}
	if( parentObject.sc_no2.value != null && parentObject.sc_no2.value != ""){
		formObject.sc_no2.value = parentObject.sc_no2.value;
	}else{
		formObject.sc_no2.value = "";
	}
	if( parentObject.pod_cd.value != null && parentObject.pod_cd.value != ""){
		formObject.pod_cd.value = parentObject.pod_cd.value;
	}else{
		formObject.pod_cd.value = "";
	}
	if( parentObject.del_cd.value != null && parentObject.del_cd.value != ""){
		formObject.del_cd.value = parentObject.del_cd.value;
	}else{
		formObject.del_cd.value = "";
	}
	
	if( parentObject.rail_dest.value != null && parentObject.rail_dest.value != ""){
		formObject.rail_dest.value = parentObject.rail_dest.value;
	}else{
		formObject.rail_dest.value = "";
	}
	if( parentObject.vvd.value != null && parentObject.vvd.value != ""){
		formObject.vvd.value = parentObject.vvd.value;
	}else{
		formObject.vvd.value = "";
	}
    if( parentObject.rail_so_flg.value != null && parentObject.rail_so_flg.value != ""){
		formObject.rail_so_flg.value = parentObject.rail_so_flg.value;
	}else{
		formObject.rail_so_flg.value = "";
	}
	if( parentObject.bkg_no.value != null && parentObject.bkg_no.value != ""){
		formObject.bkg_no.value = parentObject.bkg_no.value;
	}else{
		formObject.bkg_no.value = "";
	}
	if( parentObject.bl_no.value != null && parentObject.bl_no.value != ""){
		formObject.bl_no.value = parentObject.bl_no.value;
	}else{
		formObject.bl_no.value = "";
	}
	if( parentObject.cntr_no.value != null && parentObject.cntr_no.value != ""){
		formObject.cntr_no.value = parentObject.cntr_no.value;
	}else{
		formObject.cntr_no.value = "";
	}
	
	if( parentObject.cntr_no.value != null && parentObject.cntr_no.value != ""){
		formObject.cntr_no.value = parentObject.cntr_no.value;
	}else{
		formObject.cntr_no.value = "";
	}
	if( parentObject.cust_cd.value != null && parentObject.cust_cd.value != ""){
		formObject.cust_cd.value = parentObject.cust_cd.value;
	
	}else{
		formObject.cust_cd.value = "";
	}

//	if( parentObject.sent.value != null && parentObject.sent.value != ""){
//		formObject.sent.value = parentObject.sent.value;
//	}else{
//		formObject.sent.value = "";
//	}
	if( parentObject.btn_action.value == 'R')
		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		

}

function tabClearSheet() {
	var formObject = document.form;
	formObject.f_cmd.value = "";
	formObject.search_dt.value = "";
	formObject.sc_no.value = "";
	formObject.sc_no2.value = "";
	formObject.rail_dest.value = "";
	formObject.vvd.value = "";
	formObject.rail_so_flg.value = "";
	formObject.bkg_no.value = "";
	formObject.bl_no.value = "";
	formObject.cntr_no.value = "";
	formObject.cust_cnt_cd.value = "";
	formObject.cust_seq.value = "";
	formObject.sent.value = "";
	sheetObjects[0].RemoveAll();
	parent.setTabTotal(0,-1);

}

function tabDownExcel() {
	doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
}

function tabDownText() {
	
	sheetObjects[0].Down2Text("", "\t", "", "96hrsDwell.txt", "", "");

}
function tabDownPrint() {
	sheetObjects[0].Down2Print(true, poLandscape , "96hrs Terminal Dwell", 1.5, 1.5);
}

/**
* sheet1에서 이미지버튼을 클릭한 경우 를 처리한다.
* @param sheetObj
* @param Row
* @param Col
* @return
*/
function sheet1_OnDblClick(sheetObj, Row, Col){
    var colName = sheetObj.ColSaveName(Col);
    var dtValue = sheetObj.CellValue(Row,Col);
    switch(colName) {
    case "eml_cnt":
//        if( sheetObj.CellValue(Row,  "eml_cnt") == "E-mailing History(SEQ:0)" ) return;
    	var sUrl = "/hanjin/ESD_SCE_0163.do";
    	var sc_no = sheetObj.CellValue(Row,  "sc_no");
    	var eml_snd_dt = sheetObj.CellValue(Row,  "eml_snd_dt");
    	var cntr_no = sheetObj.CellValue(Row,  "cntr_no");
    	var dwll_tm_tp_cd = document.form.dwll_tm_tp_cd.value;
    	var cust_cdarray = sheetObj.CellValue(Row, "cust_cd_nm").split("(")
      	var cust_cd = cust_cdarray[0];
     	var paramUrl = "pgmNo=ESD_SCE_0163";
    	//var param = "?"+paramUrl+"&sc_no="+sc_no+"&dwll_tm_tp_cd="+dwll_tm_tp_cd+"&eml_snd_dt="+eml_snd_dt+"&cntr_no="+cntr_no;
    	var param = "?"+paramUrl+"&sc_no="+sc_no+"&cntr_no="+cntr_no+"&cntr_tp="+dwll_tm_tp_cd+"&row=" + Row+"&cust_cd="+cust_cd+"&emailcnt_gubun=eml_cnt";
    	window.showModalDialog(sUrl + param, self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:480px");  
    	break;
//    case "shpr_eml_cnt":
////      if( sheetObj.CellValue(Row,  "eml_cnt") == "E-mailing History(SEQ:0)" ) return;
//  	var sUrl = "/hanjin/ESD_SCE_0145.do";
//  	var sc_no = sheetObj.CellValue(Row,  "sc_no");
//  	var eml_snd_dt = sheetObj.CellValue(Row,  "eml_snd_dt");
//  	var cntr_no = sheetObj.CellValue(Row,  "cntr_no");
//  	var dwll_tm_tp_cd = document.form.dwll_tm_tp_cd.value;
//  	var paramUrl = "pgmNo=ESD_SCE_0145";
//  	var param = "?"+paramUrl+"&sc_no="+sc_no+"&dwll_tm_tp_cd="+dwll_tm_tp_cd+"&eml_snd_dt="+eml_snd_dt+"&cntr_no="+cntr_no;
//  	window.showModalDialog(sUrl + param, self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:820px;dialogHeight:400px");  
//  	break;
    case "cnee_eml_cnt":
//      if( sheetObj.CellValue(Row,  "eml_cnt") == "E-mailing History(SEQ:0)" ) return;
  	var sUrl = "/hanjin/ESD_SCE_0163.do";
  	var sc_no = sheetObj.CellValue(Row,  "sc_no");
  	var eml_snd_dt = sheetObj.CellValue(Row,  "eml_snd_dt");
  	var cntr_no = sheetObj.CellValue(Row,  "cntr_no");
  	var dwll_tm_tp_cd = document.form.dwll_tm_tp_cd.value;
	var cust_cdarray = sheetObj.CellValue(Row, "cnee_cust_cd_nm").split("(")
  	var cust_cd = cust_cdarray[0];
  	var paramUrl = "pgmNo=ESD_SCE_0163";
  	if (cust_cd != ''){
  //	var param = "?"+paramUrl+"&sc_no="+sc_no+"&dwll_tm_tp_cd="+dwll_tm_tp_cd+"&eml_snd_dt="+eml_snd_dt+"&cntr_no="+cntr_no;
  	var param = "?"+paramUrl+"&sc_no="+sc_no+"&cntr_no="+cntr_no+"&cntr_tp="+dwll_tm_tp_cd+"&row=" + Row+"&cust_cd="+cust_cd+"&emailcnt_gubun=cnee_eml_cnt";
  	window.showModalDialog(sUrl + param, self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:480px"); 
  	}
  	break;
    case "ntfy_eml_cnt":
//      if( sheetObj.CellValue(Row,  "eml_cnt") == "E-mailing History(SEQ:0)" ) return;
  	var sUrl = "/hanjin/ESD_SCE_0163.do";
  	var sc_no = sheetObj.CellValue(Row,  "sc_no");
  	var eml_snd_dt = sheetObj.CellValue(Row,  "eml_snd_dt");
  	var cntr_no = sheetObj.CellValue(Row,  "cntr_no");
  	var dwll_tm_tp_cd = document.form.dwll_tm_tp_cd.value;
	var cust_cdarray = sheetObj.CellValue(Row, "ntfy_cust_cd_nm").split("(")
  	var cust_cd = cust_cdarray[0];
	if (cust_cd != ''){
  	var paramUrl = "pgmNo=ESD_SCE_0163";
  //	var param = "?"+paramUrl+"&sc_no="+sc_no+"&dwll_tm_tp_cd="+dwll_tm_tp_cd+"&eml_snd_dt="+eml_snd_dt+"&cntr_no="+cntr_no+"&emailcnt_gubun=cnee_eml_cnt";
	var param = "?"+paramUrl+"&sc_no="+sc_no+"&cntr_no="+cntr_no+"&cntr_tp="+dwll_tm_tp_cd+"&row=" + Row+"&cust_cd="+cust_cd+"&emailcnt_gubun=ntfy_eml_cnt";
  	window.showModalDialog(sUrl + param, self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:480px");
	}
  	break;
  	
    }
}


//CLM, CNTR History popup을 위하여 parent form에 현재 선택된 CNTR 정보를 SET 
function tabCntrSelect() {
	var parentObject = parent.document.form;
	if(sheetObjects[0].TotalRows > 0){
		parentObject.t_cntr_no.value = sheetObjects[0].cellValue(sheetObjects[0].SelectRow , "cntr_no");
		parentObject.t_cntr_tpsz_cd.value = sheetObjects[0].cellValue(sheetObjects[0].SelectRow, "cntr_tpsz_cd");
	}else{
		parentObject.t_cntr_no.value = "";
		parentObject.t_cntr_tpsz_cd.value = "";
	}

}

/**
 * E-Mailing List 항목에 대하여 Bold체, Blue 색상, 밑줄로 속성 지정
 * @param sheetObj
 * @return
 */

function sheet1_OnSearchEnd(sheetObj)
{    	
	var idx = coSceSaveNameCol(sheetObj, 'eml_cnt');
	var idx1 = coSceSaveNameCol(sheetObj, 'shpr_eml_cnt');
	var idx2 = coSceSaveNameCol(sheetObj, 'cnee_eml_cnt');
	var idx3 = coSceSaveNameCol(sheetObj, 'ntfy_eml_cnt');
	var rowcount = sheetObj.RowCount;
	
	sheetObj.ColFontUnderline('eml_cnt') = true;
	sheetObj.ColFontColor('eml_cnt')= sheetObj.RgbColor(0, 0, 255);
	sheetObj.RangeFontBold(1,idx,rowcount,idx)=true;
	
	sheetObj.ColFontUnderline('shpr_eml_cnt') = true;
	sheetObj.ColFontColor('shpr_eml_cnt')= sheetObj.RgbColor(0, 0, 255);
	sheetObj.RangeFontBold(1,idx1,rowcount,idx1)=true;
	
	sheetObj.ColFontUnderline('cnee_eml_cnt') = true;
	sheetObj.ColFontColor('cnee_eml_cnt')= sheetObj.RgbColor(0, 0, 255);
	sheetObj.RangeFontBold(1,idx2,rowcount,idx2)=true;
	
	sheetObj.ColFontUnderline('ntfy_eml_cnt') = true;
	sheetObj.ColFontColor('ntfy_eml_cnt')= sheetObj.RgbColor(0, 0, 255);
	sheetObj.RangeFontBold(1,idx3,rowcount,idx3)=true;
	
	for(var i=0 ; i < rowcount ; i++){
		if(sheetObj.cellValue(i , "excp_sts") == 'Y'){
			sheetObj.RowFontColor(i) = sheetObj.RgbColor(192,192,192);
		}
	}
	
//	ComOpenWait(false);
}

/**
 * Sheet Load 후처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.FrozenCols = coSceSaveNameCol(sheetObj, 'cntr_tpsz_cd');
}

//(POP UP 에서 호출한다.)
 function openEmailCopy(){
 	var sheetObject  = sheetObjects[0];
     var sheetObject1 = sheetObjects[1];
     var tabObject = tabObjects[0];
 	var formObject = document.form;
 	var tabIndex = tabObject.SelectedIndex;
 	var iCheckRow = sheetObjects[0].FindCheckedRow("chk");
 	alert(iCheckRow);
 	
 	window.open ("ESD_SCE_0164.do", null, "scroll=no, status=no, help=no ,width=500,height=200");
        
 	//window.open ("ESD_SCE_0164.do?dist="+dist+"&cntr_no="+cntr_no, "list", "scroll=no, status=no, help=no,width=500,height=380");
 	//var newWin = window.showModalDialog("ESD_SCE_0164.do?dist="+dist+"&cntr_no="+cntr_no, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
 }

  function sheet1_OnChange(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "dwll_rsn_tp_cd"){
			if (sheetObj.CellValue(Row,"dwll_rsn_tp_cd") =='A'){
				if (sheetObj.CellValue(Row,"frt_clt_flg") =='N' || sheetObj.CellValue(Row,"obl_rdem_flg") =='N' || sheetObj.CellValue(Row,"cstms_clr_cd") =='N'){
					sheetObj.CellValue2(Row, "dwll_rsn_tp_cd") = sheetObj.CellValue(Row,"dwll_rsn_tp_cd1");
				}
			}
			if (sheetObj.CellValue(Row,"dwll_rsn_tp_cd") != sheetObj.CellValue(Row,"dwll_rsn_tp_cd1")){
				var f_cmd = SEARCH04;
				sheetObj.DoRowSearch("ESD_SCE_0161GS1.do" ,"row=" + Row +"&eml_snd_dt=" + sheetObj.CellValue(Row,'eml_snd_dt')+"&dwll_tm_tp_cd=" + sheetObj.CellValue(Row,'dwll_tm_tp_cd')+"&cntr_no=" + sheetObj.CellValue(Row,'cntr_no')+"&bkg_no=" + sheetObj.CellValue(Row,'bkg_no')+"&dwll_rsn_tp_cd=" + sheetObj.CellValue(Row,'dwll_rsn_tp_cd')+"&f_cmd=" + f_cmd ,false);
					ComShowMessage(ComGetMsg("SCE90058"));
			 		sheetObj.CellValue2(Row,"dwll_rsn_tp_cd1") = sheetObj.CellValue(Row, "dwll_rsn_tp_cd");
		    }
        }	
	}
  
  function  sheet1_OnSaveEnd(sheetObj, errMsg){
      if(errMsg=='') ComShowMessage(ComGetMsg("SCE90058")); // 저장완료
   }
