/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0110.js
 *@FileTitle : (New)Settlement Target
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.29
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.07.29  민정호
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
 * @class fns_joo_0110 : fns_joo_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0110() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업   */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix="sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var itemComboCode = "S/H|OUS|R/F|OTH"

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	var srcName = window.event.srcElement.getAttribute("name");

	if (srcName == null) {
		return;
	}

	switch (srcName) {	
		case "btn_copy":
// 임시		
			if(sheetObject.RowCount > 0) {
				var row = sheetObject.DataInsert();
				
				sheetObjects[0].CellValue2(row, prefix+"rev_yrmon") = sheetObjects[0].CellValue(row-1, prefix+"rev_yrmon");
				sheetObjects[0].CellValue2(row, prefix+"trd_cd") = sheetObjects[0].CellValue(row-1, prefix+"trd_cd");
				sheetObjects[0].CellValue2(row, prefix+"crr_cd") = sheetObjects[0].CellValue(row-1, prefix+"crr_cd");
				sheetObjects[0].CellValue2(row, prefix+"rlane_cd") = sheetObjects[0].CellValue(row-1, prefix+"rlane_cd");
				sheetObjects[0].CellValue2(row, prefix+"re_divr_cd") = sheetObjects[0].CellValue(row-1, prefix+"re_divr_cd");
				sheetObjects[0].CellValue2(row, prefix+"vsl_cd") = sheetObjects[0].CellValue(row-1, prefix+"vsl_cd");
				sheetObjects[0].CellValue2(row, prefix+"skd_voy_no") = sheetObjects[0].CellValue(row-1, prefix+"skd_voy_no");
				sheetObjects[0].CellValue2(row, prefix+"skd_dir_cd") = sheetObjects[0].CellValue(row-1, prefix+"skd_dir_cd");
				sheetObjects[0].CellValue2(row, prefix+"rev_dir_cd") = sheetObjects[0].CellValue(row-1, prefix+"rev_dir_cd");
				sheetObjects[0].CellValue2(row, prefix+"vps_port_cd") = sheetObjects[0].CellValue(row-1, prefix+"vps_port_cd");
				sheetObjects[0].CellValue2(row, prefix+"tml") = sheetObjects[0].CellValue(row-1, prefix+"tml");
				sheetObjects[0].CellValue2(row, prefix+"yd_cd") = sheetObjects[0].CellValue(row-1, prefix+"yd_cd");
				sheetObjects[0].CellValue2(row, prefix+"clpt_ind_seq") = sheetObjects[0].CellValue(row-1, prefix+"clpt_ind_seq");
				sheetObjects[0].CellValue2(row, prefix+"vps_etd_dt") = sheetObjects[0].CellValue(row-1, prefix+"vps_etd_dt");
				sheetObjects[0].CellValue2(row, prefix+"acct_cd") = sheetObjects[0].CellValue(row-1, prefix+"acct_cd");
				sheetObjects[0].CellValue2(row, prefix+"jo_stl_jb_cd") = sheetObjects[0].CellValue(row-1, prefix+"jo_stl_jb_cd");
				sheetObjects[0].CellValue2(row, prefix+"jo_stl_itm_cd") = sheetObjects[0].CellValue(row-1, prefix+"jo_stl_itm_cd");
				sheetObjects[0].CellEditable(row, prefix+"jo_stl_itm_cd") = true;
				sheetObjects[0].CellValue2(row, prefix+"bsa_qty") = sheetObjects[0].CellValue(row-1, prefix+"bsa_qty");
				sheetObjects[0].CellValue2(row, prefix+"bsa_slt_prc") = sheetObjects[0].CellValue(row-1, prefix+"bsa_slt_prc");
				sheetObjects[0].CellValue2(row, prefix+"locl_curr_cd") = sheetObjects[0].CellValue(row-1, prefix+"locl_curr_cd");
				sheetObjects[0].CellValue2(row, prefix+"stl_rmk") = "copy";
				
				sheetObjects[0].CellValue2(row, prefix+"rf_scg_stl_tp_cd") = sheetObjects[0].CellValue(row-1, prefix+"rf_scg_stl_tp_cd");				
				sheetObjects[0].CellValue2(row, prefix+"rev_enbl_flg") = "0";
				sheetObjects[0].CellValue2(row, prefix+"n2nd_rev_enbl_flg") = "0";
				sheetObjects[0].CellValue2(row, prefix+"n3rd_rev_enbl_flg") = "0";
				sheetObjects[0].CellValue2(row, prefix+"rev_chk") = "0";
				sheetObjects[0].CellValue2(row, prefix+"n2nd_rev_enbl_flg") = "0";
				sheetObjects[0].CellValue2(row, prefix+"n3rd_rev_enbl_flg") = "0";
				sheetObjects[0].CellValue2(row, prefix+"rev_shw_flg") = "C";				// rev_shw_flg A:Row Add, C:Row Copy S:Sublet
			}else{
				ComShowMessage(ComGetMsg("JOO00011")); 
			}			

			break;
			
		case "btn_add":
			var inx = sheetObject.DataInsert(-1);						
			sheetObject.CellValue2(inx, prefix+"rev_yrmon") = "";
			sheetObject.CellValue2(inx, prefix+"trd_cd") = "";
			sheetObject.CellValue2(inx, prefix+"crr_cd") = "";
			sheetObject.CellValue2(inx, prefix+"rlane_cd") = "";
			sheetObject.CellValue2(inx, prefix+"re_divr_cd") = "";
			sheetObject.CellValue2(inx, prefix+"vsl_cd") = "";
			sheetObject.CellValue2(inx, prefix+"skd_voy_no") = "";
			sheetObject.CellValue2(inx, prefix+"skd_dir_cd") = "";
			sheetObject.CellValue2(inx, prefix+"rev_dir_cd") = "";
			sheetObject.CellValue2(inx, prefix+"vps_port_cd") = "";			
			sheetObject.CellValue2(inx, prefix+"tml") = "";
			sheetObject.CellValue2(inx, prefix+"yd_cd") = "";
			sheetObject.CellValue2(inx, prefix+"clpt_ind_seq") = "";
			sheetObject.CellValue2(inx, prefix+"vps_etd_dt") = "";
			sheetObject.CellValue2(inx, prefix+"acct_cd") = "";
			sheetObject.CellValue2(inx, prefix+"jo_stl_jb_cd") = "";
			sheetObject.CellValue2(inx, prefix+"jo_stl_itm_cd") = "";
			sheetObject.CellValue2(inx, prefix+"bsa_qty") = "";
			sheetObject.CellValue2(inx, prefix+"bsa_slt_prc") = "";			
			sheetObject.CellValue2(inx, prefix+"locl_curr_cd") = "";
			sheetObject.CellValue2(inx, prefix+"stl_rmk") = "row add";
			
			sheetObject.CellValue2(inx, prefix+"rf_scg_stl_tp_cd") = (document.form.re_divr_cd[0].checked ? "T" : "I");				
			
			sheetObject.CellValue2(inx, prefix+"rev_enbl_flg") = "0";
			sheetObject.CellValue2(inx, prefix+"n2nd_rev_enbl_flg") = "0";
			sheetObject.CellValue2(inx, prefix+"n3rd_rev_enbl_flg") = "0";
			sheetObject.CellValue2(inx, prefix+"rev_chk") = "0";
			sheetObject.CellValue2(inx, prefix+"n2nd_rev_enbl_flg") = "0";
			sheetObject.CellValue2(inx, prefix+"n3rd_rev_enbl_flg") = "0";				
			sheetObject.CellValue2(inx, prefix+"rev_shw_flg") = "A";			// rev_shw_flg A:Row Add, C:Row Copy S:Sublet
			
			sheetObject.CellEditable(inx, prefix+"rev_yrmon") = true;
			sheetObject.CellEditable(inx, prefix+"trd_cd") = true;
			sheetObject.CellEditable(inx, prefix+"crr_cd") = true;
			sheetObject.CellEditable(inx, prefix+"rlane_cd") = true;
			sheetObject.CellEditable(inx, prefix+"re_divr_cd") = true;
			sheetObject.CellEditable(inx, prefix+"vsl_cd") = true;
			sheetObject.CellEditable(inx, prefix+"skd_voy_no") = true;
			sheetObject.CellEditable(inx, prefix+"skd_dir_cd") = true;
			sheetObject.CellEditable(inx, prefix+"rev_dir_cd") = true;
			sheetObject.CellEditable(inx, prefix+"vps_port_cd") = true;	
			sheetObject.CellEditable(inx, prefix+"tml") = true;
			sheetObject.CellEditable(inx, prefix+"yd_cd") = true;
			sheetObject.CellEditable(inx, prefix+"clpt_ind_seq") = true;
			sheetObject.CellEditable(inx, prefix+"vps_etd_dt") = true;
			sheetObject.CellEditable(inx, prefix+"acct_cd") = true;
			sheetObject.CellEditable(inx, prefix+"jo_stl_jb_cd") = true;
			sheetObject.CellEditable(inx, prefix+"jo_stl_itm_cd") = true;
			sheetObject.CellEditable(inx, prefix+"bsa_qty") = true;
			sheetObject.CellEditable(inx, prefix+"bsa_slt_prc") = true;			
			sheetObject.CellEditable(inx, prefix+"locl_curr_cd") = true;
			sheetObject.CellEditable(inx, prefix+"stl_rmk") = true;			
			
			sheetObject.SelectCell(inx,prefix+"rev_yrmon",true);						
			break;
			
		case "btn_delete":
			var selRow = sheetObject.SelectRow;

			if(sheetObject.CellValue(selRow, prefix+"acct_yrmon").length == 0 ){
				sheetObject.RowDelete(selRow);
			}else{
				if(sheetObject.CellValue(selRow, prefix+"acct_yrmon") == '999912' &&
					sheetObject.CellValue(selRow, prefix+"rev_shw_flg") != 'Y'
					){
					sheetObject.RowHidden(selRow)= true;
					sheetObject.RowStatus(selRow)= "D";													
				}else{
					alert("It can not be deleted");			// Joo_Settlement에 저장되어 있으므로(정산) 삭제 하지 못한다.				
				}
			}			
			break;
			
		case "btn1_save": //SAVE			
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;

		case "btn1_sublet_save": //Sublet OUS/RF Save			
			doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
			break;
			
			
		case "btn1_Retrieve": //RETRIEVE
			if(formObject.page_no.value == ""){
				formObject.page_no.value = "1";
			}		
			
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
	
		case "btn1_New": //NEW
			UF_reset();
			reset_all();	// 페이지 초기화
			break;
	
		case "btn1_Down_Excel": //DownExcel
			sheetObjects[0].SpeedDown2Excel(-1, true, true);
			break;
																				
    		//Creation Date 달력
		case "btns_calendar1":				
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.rev_yrmon_fr, "yyyy-MM");
			break;

		case "btns_calendar2":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.rev_yrmon_to, "yyyy-MM");
			break;			
						
	} // end switch
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
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}		
	initControl();
	
	comboObjects[0].Index2 = 0;
	
	ComEnableObject(document.form.sublet_yn,false)
	ComBtnDisable("btn1_sublet_save");
	ComBtnDisable("btn_add");

}
/**
 * Combo 기본 설정
 * Combo의 항목을 설정한다.
 * @param comboObj 
 * @param comboIndex Number
 */
function initCombo(comboObj, comboNo) {
	var formObject = document.form

	switch (comboNo) {
		case 1: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("100");
				DropHeight = 220;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}
	
			comboObj.InsertItem(0, "S/H", "S/H");
			comboObj.InsertItem(1, "OUS, R/F, OTH", "OUS");
			break;
				
		case 2: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}
			if (ComTrim(gTrdCd) != ""){
				var comboItems = (" |"+gTrdCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break; 
			
		case 3: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("50");
				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
				MaxLength=5;
			}
			if (ComTrim(gRlaneCd) != ""){
				var comboItems = (" |"+gRlaneCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break;
						
		case 4: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}
			if (ComTrim(gJoCrrCd) != ""){
				var comboItems = (" |"+gJoCrrCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break;
		
	}
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {

	var formObject = document.form;

    axon_event.addListener('click', 're_divr_cd_click', 're_divr_cd');

	axon_event.addListenerForm('keypress', 'fnObjKeyPress', formObject);

	axon_event.addListenerFormat('blur', 'fnDeactivate', formObject);
	axon_event.addListenerFormat('focus', 'fnActivate', formObject);

	axon_event.addListener('click', 'ous_yn_click', 'ous_yn');
	axon_event.addListener('click', 'rf_yn_click', 'rf_yn');
	axon_event.addListener('click', 'dg_yn_click', 'dg_yn');
	axon_event.addListener('click', 'sublet_yn_click', 'sublet_yn');	
	
	fnBtnEnable("C", true);
}


function ous_yn_click(){
	var form = document.form;
	
	if (form.ous_yn.checked){
		form.ous_yn.value = "Y";
	}else{
		form.ous_yn.value = "N";		
	}
}

function rf_yn_click(){
	var form = document.form;
	
	if (form.rf_yn.checked){
		form.rf_yn.value = "Y";
	}else{
		form.rf_yn.value = "N";		
	}
}

function dg_yn_click(){
	var form = document.form;
	
	if (form.dg_yn.checked){
		form.dg_yn.value = "Y";
	}else{
		form.dg_yn.value = "N";		
	}
}

function sublet_yn_click(){
	var form = document.form;
	var sheetObj = sheetObjects[0];	
	
	if (form.sublet_yn.checked){
		form.sublet_yn.value = "Y";
				
		sheetObj.ColHidden(prefix+"rev_crr_cd") = false;
		sheetObj.ColHidden(prefix+"rev_bsa_qty") = false;
		sheetObj.ColHidden(prefix+"rev_bsa_slt_prc") = false;
		sheetObj.ColHidden(prefix+"rev_enbl_flg") = false;	   
		sheetObj.ColHidden(prefix+"n2nd_rev_crr_cd") = false;
		sheetObj.ColHidden(prefix+"n2nd_rev_bsa_qty") = false;
		sheetObj.ColHidden(prefix+"n2nd_rev_bsa_slt_prc") = false;
		sheetObj.ColHidden(prefix+"n2nd_rev_enbl_flg") = false;	   
		sheetObj.ColHidden(prefix+"n3rd_rev_crr_cd") = false;
		sheetObj.ColHidden(prefix+"n3rd_rev_bsa_qty") = false;
		sheetObj.ColHidden(prefix+"n3rd_rev_bsa_slt_prc") = false;
		sheetObj.ColHidden(prefix+"n3rd_rev_enbl_flg") = false;	   		
	}else{
		form.sublet_yn.value = "N";
		
		sheetObj.ColHidden(prefix+"rev_crr_cd") = true;
		sheetObj.ColHidden(prefix+"rev_bsa_qty") = true;
		sheetObj.ColHidden(prefix+"rev_bsa_slt_prc") = true;
		sheetObj.ColHidden(prefix+"rev_enbl_flg") = true;	   
		sheetObj.ColHidden(prefix+"n2nd_rev_crr_cd") = true;
		sheetObj.ColHidden(prefix+"n2nd_rev_bsa_qty") = true;
		sheetObj.ColHidden(prefix+"n2nd_rev_bsa_slt_prc") = true;
		sheetObj.ColHidden(prefix+"n2nd_rev_enbl_flg") = true;	   
		sheetObj.ColHidden(prefix+"n3rd_rev_crr_cd") = true;
		sheetObj.ColHidden(prefix+"n3rd_rev_bsa_qty") = true;
		sheetObj.ColHidden(prefix+"n3rd_rev_bsa_slt_prc") = true;
		sheetObj.ColHidden(prefix+"n3rd_rev_enbl_flg") = true;	   		
	}
}


function re_divr_cd_click(){
	UF_setCond("1");
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
		// 높이 설정
		style.height = 360;
		
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		
		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet =  msHeaderOnly;
		
		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;				
		
		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);
		
		var HeadTitle2 = "STS|Seq.|Target|Close|Revenue\nMonth" +
	    "|Trade|Carrier|RLANE|Rev/Exp" +
		"|VVD|VVD|VVD"+
		"|Fin\nDir|PORT|TML|Yard|IND"+
		"|ETD|Account\nCode|BSA\nType|Item"+								
		"|BSA|BSA|BSA\nto be Settled|BSA\nto be Settled" +
		"|1st Sublet BSA|1st Sublet BSA|1st Sublet BSA|1st Sublet BSA" +
		"|2nd Sublet BSA|2nd Sublet BSA|2nd Sublet BSA|2nd Sublet BSA" +
		"|3rd Sublet BSA|3rd Sublet BSA|3rd Sublet BSA|3rd Sublet BSA" +
		"|chk1|chk2|chk3" +
		"|Cur.|Amount|Settle\nAmount|Remark" +		
		"|RF TYPE|REV_YRMON_SEQ|REV_SEQ|ACCT_YRMON|STL_VVD_SEQ|STL_SEQ|stl_tgt_flg2|rev_shw_flg";								

		var HeadTitle3 = "STS|Seq.|Target|Close|Revenue\nMonth" +
		"|Trade|Carrier|RLANE|Rev/Exp" +
		"|VSL|VOY|DIR"+
	    "|Fin\nDir|PORT|TML|Yard|IND"+
	    "|ETD|Account\nCode|BSA\nType|Item"+							    
	    "|TEU|Slot\nPrice|TEU|Slot\nPrice" +
	    "|CRR|TEU|Slot\nPrice| |CRR|TEU|Slot\nPrice| |CRR|TEU|Slot\nPrice| |chk1|chk2|chk3" +
	    "|Cur.|Amount|Settle\nAmount|Remark" +	    
	    "|RF TYPE|REV_YRMON_SEQ|REV_SEQ|ACCT_YRMON|STL_VVD_SEQ|STL_SEQ|stl_tgt_flg2|rev_shw_flg";			
				
		var headCount = ComCountHeadTitle(HeadTitle2);
		
		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);
		
		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false)
						
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]				
		InitHeadRow(0, HeadTitle2, true);
		InitHeadRow(1, HeadTitle3, true);		
				
		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		
		// 임시
		InitDataProperty(0, cnt++, dtStatus ,30, 	daCenter,  true, prefix+"ibflag"  );		
		InitDataProperty(0, cnt++, dtHidden ,30, 	daCenter,  true, prefix+"seq_no", false, "", dfNone  , 0, false, false);		
		InitDataProperty(0, cnt++, dtCheckBox  ,60, daCenter,  true, prefix+"stl_tgt_flg");
		InitDataProperty(0, cnt++, dtCheckBox  ,60, daCenter,  true, prefix+"stl_clz_flg");			
		InitDataProperty(0, cnt++, dtData ,	60, 	daCenter,  true, prefix+"rev_yrmon", 	false, "", dfUserFormat2  , 0, false, false);
//---------------		
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"trd_cd", 		false, "", dfEngUpKey  , 0, false, false);
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"crr_cd", 		false, "", dfEngUpKey  , 0, false, false);
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"rlane_cd", 	false, "", dfEngUpKey  , 0, false, false);		
		InitDataProperty(0, cnt++, dtData ,60, daCenter,  true, prefix+"re_divr_cd", 	false, "", dfEngUpKey  , 0, false, false);
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"vsl_cd", 		false, "", dfEngUpKey  , 0, false, false,4);
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"skd_voy_no", 	false, "", dfNone  , 0, false, false,4);		
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"skd_dir_cd", 		false, "", dfEngUpKey  , 0, false, false,1);
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"rev_dir_cd", 		false, "", dfNone  , 0, false, false,1);		
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"vps_port_cd", 	false, "", dfNone  , 0, false, false,5);
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"tml", 				false, "", dfNone  , 0, false, false,2);		
		InitDataProperty(0, cnt++, dtHidden ,50, daCenter,  true, prefix+"yd_cd", 		false, "", dfNone  , 0, false, false,7);		
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"clpt_ind_seq", 	false, "", dfNone  , 0, false, false);
		InitDataProperty(0, cnt++, dtData ,110, daCenter,  true, prefix+"vps_etd_dt", 	false, "", dfUserFormat2  , 0, false, false);
		InitDataProperty(0, cnt++, dtData ,80, daCenter,  true, prefix+"acct_cd", 			false, "", dfNone  , 0, false, false);
		InitDataProperty(0, cnt++, dtCombo ,100, daLeft,  true, prefix+"jo_stl_jb_cd", 	false, "", dfNone  , 0, false, false);
		InitDataProperty(0, cnt++, dtCombo ,50, daCenter,  true, prefix+"jo_stl_itm_cd", false, "", dfNone  , 0, false, false);
							
		InitDataProperty(0, cnt++, dtData ,50, daRight,  true, prefix+"bsa_qty", false, "", dfNullFloat  , 2, false, false);
		InitDataProperty(0, cnt++, dtData ,50, daRight,  true, prefix+"bsa_slt_prc", false, "", dfNullFloat  , 2, false, false);
		InitDataProperty(0, cnt++, dtAutoSum ,100, daRight,  true, prefix+"fnl_bsa_qty", false, "", dfNullFloat  , 2, true, true);
		InitDataProperty(0, cnt++, dtAutoSum ,100, daRight,  true, prefix+"fnl_bsa_slt_prc", false, "", dfNullFloat  , 2, true, true);
		
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"rev_crr_cd", false, "", dfNone  , 0, true, true);		
		InitDataProperty(0, cnt++, dtData ,50, daRight,  true, prefix+"rev_bsa_qty", false, "", dfNullFloat  , 2, true, true);
		InitDataProperty(0, cnt++, dtData ,50, daRight,  true, prefix+"rev_bsa_slt_prc", false, "", dfNullFloat  , 2, true, true);
		InitDataProperty(0, cnt++, dtCheckBox  ,30, daCenter,  true, prefix+"rev_enbl_flg");
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"n2nd_rev_crr_cd", false, "", dfNone  , 0, true, true);		
		InitDataProperty(0, cnt++, dtData ,50, daRight,  true, prefix+"n2nd_rev_bsa_qty", false, "", dfNullFloat  , 2, true, true);
		InitDataProperty(0, cnt++, dtData ,50, daRight,  true, prefix+"n2nd_rev_bsa_slt_prc", false, "", dfNullFloat  , 2, true, true);
		InitDataProperty(0, cnt++, dtCheckBox  ,30, daCenter,  true, prefix+"n2nd_rev_enbl_flg");
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"n3rd_rev_crr_cd", false, "", dfNone  , 0, true, true);		
		InitDataProperty(0, cnt++, dtData ,50, daRight,  true, prefix+"n3rd_rev_bsa_qty", false, "", dfNullFloat  , 2, true, true);
		InitDataProperty(0, cnt++, dtData ,50, daRight,  true, prefix+"n3rd_rev_bsa_slt_prc", false, "", dfNullFloat  , 2, true, true);
		InitDataProperty(0, cnt++, dtCheckBox  ,30, daCenter,  true, prefix+"n3rd_rev_enbl_flg");
		
		InitDataProperty(0, cnt++, dtHidden ,50, daCenter,  true, prefix+"rev_chk", false, "", dfNone  , 0, false, false);
		InitDataProperty(0, cnt++, dtHidden ,50, daCenter,  true, prefix+"n2nd_rev_chk", false, "", dfNone  , 0, false, false);
		InitDataProperty(0, cnt++, dtHidden ,50, daCenter,  true, prefix+"n3rd_rev_chk", false, "", dfNone  , 0, false, false);		
		
		InitDataProperty(0, cnt++, dtData ,50, daCenter,  true, prefix+"locl_curr_cd", false, "", dfEngUpKey  , 0, false, false);
		InitDataProperty(0, cnt++, dtAutoSum ,150, daRight,  true, prefix+"stl_locl_amt", false, "|sheet1_fnl_bsa_qty|*|sheet1_fnl_bsa_slt_prc|", dfNullFloat  , 2, false, false);
		InitDataProperty(0, cnt++, dtHidden ,150, daRight,  true, prefix+"fnl_stl_locl_amt", false, "", dfNullFloat  , 2, false, false);		
		InitDataProperty(0, cnt++, dtData ,200, daLeft,  true, prefix+"stl_rmk", false, "", dfNone  , 0, true, true);		
		InitDataProperty(0, cnt++, dtHidden ,30, daCenter,  true, prefix+"rf_scg_stl_tp_cd", false, "", dfNone  , 0, true, true);		
		// 임시		
		InitDataProperty(0, cnt++, dtHidden ,50, 	daCenter,  false, prefix+"rev_yrmon_seq", false, "", dfNone  , 0, false, false);
		InitDataProperty(0, cnt++, dtHidden ,50, 	daCenter,  false, prefix+"rev_seq", 		false, "", dfNone  , 0, false, false);				
		InitDataProperty(0, cnt++, dtHidden ,50, 	daCenter,  false, prefix+"acct_yrmon", 	false, "", dfNone  , 0, false, false);
		InitDataProperty(0, cnt++, dtHidden ,50, 	daCenter,  false, prefix+"stl_vvd_seq", 	false, "", dfNone  , 0, false, false);		
		InitDataProperty(0, cnt++, dtHidden ,50, 	daCenter,  false, prefix+"stl_seq", 	false, "", dfNone  , 0, false, false);
		InitDataProperty(0, cnt++, dtHidden ,50, 	daCenter,  false, prefix+"stl_tgt_flg2", 	false, "", dfNone  , 0, false, false);		
		InitDataProperty(0, cnt++, dtHidden ,50, 	daCenter,  false, prefix+"rev_shw_flg", 	false, "", dfNone  , 0, false, false);		
		
		InitUserFormat2(0, prefix+"rev_yrmon" , "####-##", "-|:" );
        InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##:##", "-|:" );
        InitDataCombo(0,  prefix+"jo_stl_jb_cd", "JOINT OPERATION|LEASE|ADDITIONAL|Over Used|20FT|40FT", "101|102|103|201|301|302");
        InitDataCombo(0, prefix+"jo_stl_itm_cd", itemComboCode, itemComboCode)
        
		FrozenCols = 14;	        
  
		MessageText("Sum") = ""; //summary row에 자동으로 생성되는 TOTAL이란 글자를 없앰
		
	   ColHidden(prefix+"rev_crr_cd") = true;
	   ColHidden(prefix+"rev_bsa_qty") = true;
	   ColHidden(prefix+"rev_bsa_slt_prc") = true;
	   ColHidden(prefix+"rev_enbl_flg") = true;	   
	   ColHidden(prefix+"n2nd_rev_crr_cd") = true;
	   ColHidden(prefix+"n2nd_rev_bsa_qty") = true;
	   ColHidden(prefix+"n2nd_rev_bsa_slt_prc") = true;
	   ColHidden(prefix+"n2nd_rev_enbl_flg") = true;	   
	   ColHidden(prefix+"n3rd_rev_crr_cd") = true;
	   ColHidden(prefix+"n3rd_rev_bsa_qty") = true;
	   ColHidden(prefix+"n3rd_rev_bsa_slt_prc") = true;
	   ColHidden(prefix+"n3rd_rev_enbl_flg") = true;	   
	   ColHidden(prefix+"rev_chk") = true;
	   ColHidden(prefix+"n2nd_rev_chk") = true;
	   ColHidden(prefix+"n3rd_rev_chk") = true;
	   
       InitDataValid(0,prefix+"trd_cd",vtEngUpOther, "0123456789" );
       InitDataValid(0,prefix+"crr_cd",vtEngUpOther, "0123456789" );
       InitDataValid(0,prefix+"rlane_cd",vtEngUpOther, "0123456789" );
       InitDataValid(0,prefix+"re_divr_cd",vtEngUpOther, "0123456789" );
       InitDataValid(0,prefix+"vsl_cd",vtEngUpOther, "0123456789" );
       InitDataValid(0,prefix+"skd_dir_cd",vtEngUpOther, "0123456789" );
       InitDataValid(0,prefix+"locl_curr_cd",vtEngUpOther, "0123456789" );

		
		}
		break;
		
	case 2: // 단지 Estiamted Period 변경시 마감여부를 check할 때 깜빡임을 방지하기 위한 sheet임
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
	if (!validateForm(sheetObj, formObj, sAction)) {
		return;
	}

	switch (sAction) {

		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			setConditionValue('1');			
			var param = FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0110GS.do", param);						
			sheetObj.LoadSearchXml(sXml, false); //Append X			
			break;
													
		case IBSAVE: //저장			
			var ibflag = '';
			var updCnt = 0;
			
			for(var i=2; i<sheetObj.RowCount+2; i++){
				ibflag = sheetObj.CellValue(i, prefix + "ibflag");
				
				if(ibflag == 'U' || ibflag == 'I' || ibflag == 'D'){				
					updCnt = updCnt +1;
				}
								
				// Row Add 입력시								
				if(sheetObj.CellValue(i, prefix + "rev_shw_flg") == "A"){					
					if(sheetObj.CellValue(i, prefix+"rev_yrmon") == ""){ ComShowCodeMessage("JOO00019", "Revenue Month"); return false;};
					if(sheetObj.CellValue(i, prefix+"trd_cd") == ""){ ComShowCodeMessage("JOO00019", "Trade"); return false; };
					if(sheetObj.CellValue(i, prefix+"crr_cd") == ""){ ComShowCodeMessage("JOO00019", "Carrier"); return false; };
					if(sheetObj.CellValue(i, prefix+"rlane_cd") == ""){ ComShowCodeMessage("JOO00019", "Rlane"); return false; };
					if(sheetObj.CellValue(i, prefix+"re_divr_cd") == ""){ ComShowCodeMessage("JOO00019", "Rev/Exp"); return false; };
					if(sheetObj.CellValue(i, prefix+"vsl_cd") == ""){ ComShowCodeMessage("JOO00019", "VSL"); return false; };
					if(sheetObj.CellValue(i, prefix+"skd_voy_no") == ""){ ComShowCodeMessage("JOO00019", "VOY"); return false; };
					if(sheetObj.CellValue(i, prefix+"skd_dir_cd") == ""){ ComShowCodeMessage("JOO00019", "DIR"); return false; };
					if(sheetObj.CellValue(i, prefix+"rev_dir_cd") == ""){ ComShowCodeMessage("JOO00019", "Fin Dir"); return false; };
					if(sheetObj.CellValue(i, prefix+"vps_port_cd") == ""){ ComShowCodeMessage("JOO00019", "Port"); return false; };
					
					if(comboObjects[0].Code == "OUS"){
						if(sheetObj.CellValue(i, prefix+"tml") == ""){ ComShowCodeMessage("JOO00019", "TML"); return false; };
						sheetObj.CellValue(i, prefix+"yd_cd") = sheetObj.CellValue(i, prefix+"vps_port_cd")+sheetObj.CellValue(i, prefix+"tml");	
						if(sheetObj.CellValue(i, prefix+"clpt_ind_seq") == ""){ ComShowCodeMessage("JOO00019", "IND"); return false; };						
					}					
					
					if(sheetObj.CellValue(i, prefix+"vps_etd_dt") == ""){ ComShowCodeMessage("JOO00019", "ETD"); return false; };
					if(sheetObj.CellValue(i, prefix+"acct_cd") == ""){ ComShowCodeMessage("JOO00019", "Account Code"); return false; };
					if(sheetObj.CellValue(i, prefix+"jo_stl_itm_cd") == ""){ ComShowCodeMessage("JOO00019", "Item"); return false; };
					if(sheetObj.CellValue(i, prefix+"locl_curr_cd") == ""){ ComShowCodeMessage("JOO00019", "Cur."); return false; };					
				}
			}
			
			if(updCnt == 0){
				alert("There is no Target data to save.");
				return false;				
			}
						
			var SaveStr = ComGetSaveString(sheetObj);			
			
			if (SaveStr == ""){
				ComShowCodeMessage("JOO00036");
				return false;
			}
						
			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}
			
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0110GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			
			break;
			
		case IBINSERT: //저장
			
			var ibflag = '';			
			var rev_crr_cd = '';
			var rev_bsa_qty = '';
			var rev_bsa_slt_prc = '';
			var rev_enbl_flg = '';

			var n2nd_rev_crr_cd = '';
			var n2nd_rev_bsa_qty = '';
			var n2nd_rev_bsa_slt_prc = '';
			var n2nd_rev_enbl_flg = '';

			var n3rd_rev_crr_cd = '';
			var n3rd_rev_bsa_qty = '';
			var n3rd_rev_bsa_slt_prc = '';
			var n3rd_rev_enbl_flg = '';
								
			var stl_tgt_flg2 = '';	// 체크 여부
			
			if(!(comboObjects[0].Code == 'OUS' && form.re_divr_cd[1].checked == true)){
				alert("조회조건에서\n" +
						"Rev./Exp. : Expense\n" +
						"Item : OUS, R/F, OTH 일 때\n" +
						"Sublet OUS/RF Save 할 수 있습니다.");						
				return false;	
			} 			
						
			for(var i=2; i<sheetObj.RowCount+2; i++){
				ibflag = sheetObj.CellValue(i, prefix + "ibflag");		
				
				rev_crr_cd = sheetObj.CellValue(i, prefix + "rev_crr_cd");
				rev_bsa_qty = sheetObj.CellValue(i, prefix + "rev_bsa_qty");
				rev_bsa_slt_prc = sheetObj.CellValue(i, prefix + "rev_bsa_slt_prc");
				rev_enbl_flg = sheetObj.CellValue(i, prefix + "rev_enbl_flg");	
				
				n2nd_rev_crr_cd = sheetObj.CellValue(i, prefix + "n2nd_rev_crr_cd");
				n2nd_rev_bsa_qty = sheetObj.CellValue(i, prefix + "n2nd_rev_bsa_qty");
				n2nd_rev_bsa_slt_prc = sheetObj.CellValue(i, prefix + "n2nd_rev_bsa_slt_prc");
				n2nd_rev_enbl_flg = sheetObj.CellValue(i, prefix + "n2nd_rev_enbl_flg");	

				n3rd_rev_crr_cd = sheetObj.CellValue(i, prefix + "n3rd_rev_crr_cd");
				n3rd_rev_bsa_qty = sheetObj.CellValue(i, prefix + "n3rd_rev_bsa_qty");
				n3rd_rev_bsa_slt_prc = sheetObj.CellValue(i, prefix + "n3rd_rev_bsa_slt_prc");
				n3rd_rev_enbl_flg = sheetObj.CellValue(i, prefix + "n3rd_rev_enbl_flg");	
				
				stl_tgt_flg2 = sheetObj.CellValue(i, prefix + "stl_tgt_flg2");	
												
				if(ibflag == 'U'){					
					
					if(stl_tgt_flg2  != "1"){
						alert("You can complete [Sublet Ous/RF Save], only when you save it with (Target) checked");
						return false;
					}					
					
					if(  sheetObj.CellValue(i, prefix + "rev_enbl_flg") == "1" ){	
						if(         ComTrim(sheetObj.CellValue(i, prefix + "rev_crr_cd")) == "" 
							    || ComTrim(sheetObj.CellValue(i, prefix + "rev_bsa_qty")) == ""
								|| ComTrim(sheetObj.CellValue(i, prefix + "rev_bsa_slt_prc")) == ""
									
								){
							alert("Please insert data for 1st Sublet BSA. ");
							return false;
						}
					}
					if(  sheetObj.CellValue(i, prefix + "n2nd_rev_enbl_flg") == "1" ){	
						if(         ComTrim(sheetObj.CellValue(i, prefix + "n2nd_rev_crr_cd")) == "" 
							    || ComTrim(sheetObj.CellValue(i, prefix + "n2nd_rev_bsa_qty")) == ""
								|| ComTrim(sheetObj.CellValue(i, prefix + "n2nd_rev_bsa_slt_prc")) == ""
									
								){
							alert("Please insert data for 2nd Sublet BSA. ");
							return false;
						}
					}
					if(  sheetObj.CellValue(i, prefix + "n3rd_rev_enbl_flg") == "1" ){	
						if(         ComTrim(sheetObj.CellValue(i, prefix + "n3rd_rev_crr_cd")) == "" 
							    || ComTrim(sheetObj.CellValue(i, prefix + "n3rd_rev_bsa_qty")) == ""
								|| ComTrim(sheetObj.CellValue(i, prefix + "n3rd_rev_bsa_slt_prc")) == ""
									
								){
							alert(" Please insert data for 3rd Sublet BSA. ");
							return false;
						}
					}										
				}
			}			
			
			var SaveStr = ComGetSaveString(sheetObj);			
			
			if (SaveStr == ""){
				ComShowCodeMessage("JOO00036");
				return false;
			}
						
			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}
			
			formObj.f_cmd.value = MULTI01;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0110GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			
			break;
			
		case IBRESET: //NEW 버튼  
			UF_reset();
			break;								
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
			case IBSEARCH:								
				if (formObj.jo_crr_cd2.index == -1){
					ComShowCodeMessage('JOO00008');
					formObj.jo_crr_cd2.focus();
					return false;
				}
				
				break;
				
			case IBSAVE:
				if (formObj.jo_crr_cd2.index == -1){
					ComShowCodeMessage('JOO00008');
					formObj.jo_crr_cd2.focus();
					return false;
				}
				
				break;
		}
	}
	return true;
}
/************************************** Object EVENT FUNCTION ********************************************************/
function jo_crr_cd2_OnChange(comboObj, Value, Text) {
	sheetObjects[0].RemoveAll();
}

function trd_cd2_OnChange(comboObj, Value, Text) {
	UF_setCond("3");
}

function rlane_cd2_OnChange(comboObj, Value, Text) {
	UF_setCond("4");
}

/**************************************USER FUNCTION *****************************************************/

/**
 * NEW 버튼 처리 
 * @param    void
 * @return   void
 */
function UF_reset() {
	var formObj = document.form;
	formObj.page_no.value = "1";
	sheetObjects[0].RemoveAll();
	
	comboObjects[1].RemoveAll();			// Trade
	comboObjects[2].RemoveAll();			// Lane
	comboObjects[3].RemoveAll();			// Carrier
	
	var comboItems;
	
	if (ComTrim(gTrdCd) != ""){
		comboItems = (" |"+gTrdCd).split("|");
		addComboItem(comboObjects[1], comboItems);          // Trade 		
	}

	//Rlane Combo setting
	if (ComTrim(gRlaneCd) != ""){
		comboItems = (" |"+gRlaneCd).split("|");
		addComboItem(comboObjects[2], comboItems);			// Lane
	}
	
	//Carrier Combo setting
	if (ComTrim(gJoCrrCd) != ""){
		comboItems = (" |"+gJoCrrCd).split("|");
		addComboItem(comboObjects[3], comboItems);			// Carrier           	
	}
	
	formObj.rev_yrmon_fr.value = gYyyyMM;	
	formObj.rev_yrmon_to.value = gYyyyMM;
	
	formObj.re_divr_cd[0].checked = true;
	formObj.vvd.value = "";
	sheetObjects[0].RemoveAll();	
}

/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 잃었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnDeactivate() {
	switch (event.srcElement.name) {
		case 'rev_yrmon_fr':
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함..                  
			break;
		case 'rev_yrmon_to':
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함..                        
			break;
	}
}
/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 얻었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnActivate() {
	switch (event.srcElement.name) {
	case 'rev_yrmon_fr':
		ComClearSeparator(event.srcElement);
		break;
	case 'rev_yrmon_to':
		ComClearSeparator(event.srcElement);
		break;
	}
	event.srcElement.select();
}


/**
 * <pre>
 *    form Element의 KeyPress Event 발생시 처리.
 *    
 * </pre>
 * @return
 */
function fnObjKeyPress() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {	
		case 'rev_yrmon_fr':
			ComKeyOnlyNumber(obj);
			break;
	
		case 'rev_yrmon_to':
			ComKeyOnlyNumber(obj);
			break;
			
		case 'vvd':
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * 
 * <pre>
 *      버튼권한 처리
 * </pre>
 *
 * @param   
 * @return
 * @author jang kang cheol
 */
function fnBtnEnable(auth, blUse) {
	var doc = document.all;
	var className = "";
	if (blUse) {
		className = "btn1";
	} else {
		className = "btn1_1";
	}

	for ( var i = 0; i < doc.length; i++) {
		if (doc[i].id.indexOf("btn") > -1) {
			if (doc[i].getAttribute("auth") != undefined) {
				if (doc[i].getAttribute("auth") == auth) {
					doc[i].className = className;
				}
			}
		}
	}
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj    = document.form;
	
	var cmd = formObj.f_cmd.value;
	var cur_page = formObj.page_no.value;
	if( (cmd == SEARCH) && sheetObj.RowCount > 0 && cur_page == "1") {
		var tot_page_cnt = sheetObj.EtcData('tot_page_cnt');
		formObj.tot_page_cnt.value = tot_page_cnt;
	}
	
	var stl_tgt_flg = '0';
	var rev_enbl_flg = '0';
	var n2nd_rev_enbl_flg = '0';
	var n3rd_rev_enbl_flg = '0';
	var jo_stl_itm_cd = '';	
	var acct_yrmon = '';	
		
	for(var i=2; i<sheetObj.RowCount+2; i++){
		stl_tgt_flg = sheetObj.CellValue(i, prefix + "stl_tgt_flg");
		rev_enbl_flg = sheetObj.CellValue(i, prefix + "rev_enbl_flg");
		n2nd_rev_enbl_flg = sheetObj.CellValue(i, prefix + "n2nd_rev_enbl_flg");
		n3rd_rev_enbl_flg = sheetObj.CellValue(i, prefix + "n3rd_rev_enbl_flg");	
		jo_stl_itm_cd = sheetObj.CellValue(i, prefix + "jo_stl_itm_cd");
		acct_yrmon = sheetObj.CellValue(i,prefix + "acct_yrmon");		
				
		if(acct_yrmon != "999912"){
			sheetObj.CellEditable(i, prefix+"stl_tgt_flg") = false;
		}			
		
		if(rev_enbl_flg == "1"){
			sheetObj.CellEditable(i, prefix + "rev_enbl_flg") = false;
		}
		if(n2nd_rev_enbl_flg == "1"){
			sheetObj.CellEditable(i, prefix + "n2nd_rev_enbl_flg") = false;
		}
		if(n3rd_rev_enbl_flg == "1"){
			sheetObj.CellEditable(i, prefix + "n3rd_rev_enbl_flg") = false;
		}			
		
		// 2016.08.10 OTH Type도 sublet가능하도록
		if(jo_stl_itm_cd == 'S/H'){
			sheetObj.CellEditable(i, prefix + "rev_crr_cd") = false;
			sheetObj.CellEditable(i, prefix + "rev_bsa_qty") = false;
			sheetObj.CellEditable(i, prefix + "rev_bsa_slt_prc") = false;
			sheetObj.CellEditable(i, prefix + "rev_enbl_flg") = false;
			sheetObj.CellEditable(i, prefix + "n2nd_rev_crr_cd") = false;
			sheetObj.CellEditable(i, prefix + "n2nd_rev_bsa_qty") = false;
			sheetObj.CellEditable(i, prefix + "n2nd_rev_bsa_slt_prc") = false;
			sheetObj.CellEditable(i, prefix + "n2nd_rev_enbl_flg") = false;
			sheetObj.CellEditable(i, prefix + "n3rd_rev_crr_cd") = false;
			sheetObj.CellEditable(i, prefix + "n3rd_rev_bsa_qty") = false;
			sheetObj.CellEditable(i, prefix + "n3rd_rev_bsa_slt_prc") = false;
			sheetObj.CellEditable(i, prefix + "n3rd_rev_enbl_flg") = false;			
		}
	}	
}

function UF_setCond(flg){
	var formObj = document.form;
		
	formObj.estm_cond_flg.value = flg;
	
	switch (flg){
	//exe month, re_divr_cd 변경시
	case "1":
	case "2":
		formObj.trd_cd2.Index2 = -1;
		formObj.trd_cd2.RemoveAll();
		setBTNSublet();		// sublet button 제어
	//Trade변경시
	case "3":
		formObj.rlane_cd2.Index2 = -1;
		formObj.rlane_cd2.RemoveAll();
	//Lane변경시
	case "4":
		formObj.jo_crr_cd2.Index2 = -1;
		formObj.jo_crr_cd2.RemoveAll();
		break;
	}
	sheetObjects[0].RemoveAll();		
}

/**
 * 화면 Reset
 */
function reset_all(){	 
	var formObject = document.form;
		formObject.tot_page_cnt.value="0";
		formObject.page_no.value="1";
		formObject.sheet1.RemoveEtcData();
		formObject.sheet1.RemoveAll();	
}

  /**
   * setConditionValue
   */    
  function setConditionValue(searchGubun){
		var formObj = document.form;
				
		formObj.pagerows.value = formObj.pagerows2.value; 
		formObj.jo_stl_itm_cd.value = comboObjects[0].Code;		// Item		
		formObj.trd_cd.value = comboObjects[1].Code;				// Trade
		formObj.rlane_cd.value = comboObjects[2].Code;			// Lane
		formObj.jo_crr_cd.value = comboObjects[3].Code;			// Carrier 
  } 
  
  
  /**
   * sheet1_OnChange
   **/
function sheet1_OnChange(sheetObj, row, col){
	  
	  var sName = sheetObj.ColSaveName(col);
	  
	 if(sName == "sheet1_stl_tgt_flg") {
		 if(sheetObj.CellValue(row, prefix + "stl_tgt_flg") == '1'){
			 if(sheetObj.CellValue(row, prefix + "jo_stl_itm_cd") == 'S/H'){
				 if(sheetObj.CellValue(row, prefix + "rev_shw_flg") == 'Y'){
					 sheetObj.CellValue2(row, prefix + "fnl_bsa_qty") =  sheetObj.CellValue(row, prefix + "bsa_qty");
				     sheetObj.CellValue2(row, prefix + "fnl_bsa_slt_prc") = sheetObj.CellValue(row, prefix + "bsa_slt_prc");
				 }
			 }
		 }else{
			 sheetObj.CellValue2(row, prefix + "fnl_bsa_qty") = ''; 
			 sheetObj.CellValue2(row, prefix + "fnl_bsa_slt_prc") = '';			 
		 } 
	 }else if(sName == prefix+"jo_stl_itm_cd"){
		 if(comboObjects[0].Code == "S/H" && sheetObj.CellValue(row, prefix+"jo_stl_itm_cd") != "S/H" ){
			 ComShowCodeMessage("JOO00215");
			 sheetObj.CellValue2(row, prefix+"jo_stl_itm_cd") = "S/H"
			 return;
		 } else if(comboObjects[0].Code == "OUS" && sheetObj.CellValue(row, prefix+"jo_stl_itm_cd") == "S/H") {
			 ComShowCodeMessage("JOO00215");
			 sheetObj.CellValue2(row, prefix+"jo_stl_itm_cd") = "OUS"
			 return;
		 }
	 }
  }  
  
  /**
   * doActionIBCombo
   **/  
  function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
	sheetObj.ShowDebugMsg = false;
	setConditionValue('1');
		
      switch(sAction) {      
         case IBSEARCH:        	         	 
  			if (sComboObj.id == "jo_crr_cd2") {  				
  				if(comboObjects[0].Code == 'OUS' && formObj.re_divr_cd[1].checked == true){			// Item이 OUS, R/F, OTH이고 Expese인 경우  				  				  			
	  				//콤보필드를 초기화시킨다.
	  				sComboObj.RemoveAll();
	  									
	  				formObj.f_cmd.value = SEARCH28;
	  				formObj.code.value = formObj.trd_cd2.Code;
	  				formObj.lane_cd.value = formObj.rlane_cd2.Code;  				
	  				formObj.super_cd1.value = formObj.rev_yrmon_fr.value;
	  				formObj.super_cd2.value = formObj.rev_yrmon_to.value;
	  				
	  				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
	                ComXml2ComboItem(sXml, formObj.jo_crr_cd2,"code","code");
  				}else{
  	  				formObj.f_cmd.value = SEARCHLIST05;			
  	  				var param = FormQueryString(formObj);
  	  				var sXml = sheetObj.GetSearchXml("FNS_JOO_0110GS.do", param);						
  	                ComXml2ComboItem(sXml, formObj.jo_crr_cd2,"jo_crr_cd","jo_crr_cd");  				  					
  				}
  			}
  														
  			if (sComboObj.id == "trd_cd2") {
  				formObj.f_cmd.value = SEARCHLIST03;			
  				var param = FormQueryString(formObj);
  				var sXml = sheetObj.GetSearchXml("FNS_JOO_0110GS.do", param);						
                ComXml2ComboItem(sXml, formObj.trd_cd2,"trd_cd","trd_cd");  				
  			}
  			
  			if (sComboObj.id == "rlane_cd2") {
  				formObj.f_cmd.value = SEARCHLIST04;			
  				var param = FormQueryString(formObj);
  				var sXml = sheetObj.GetSearchXml("FNS_JOO_0110GS.do", param);						
                ComXml2ComboItem(sXml, formObj.rlane_cd2,"rlane_cd","rlane_cd");  				
  			}
  			
  	        break;
      }
  }
  
  /**
   * trd_cd2_OnFocus
   **/    
function trd_cd2_OnFocus(comboObj){
	var formObj = document.form;	
	comboObj.RemoveAll();
		
	if (comboObj.GetCount() == 0){		
		comboObj.Enable = false;		
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"trd_cd");		
		comboObj.Enable = true;	
	}		
} 
  
  /**
   * rlane_cd2_OnFocus
   **/    
function rlane_cd2_OnFocus(comboObj){
	var formObj = document.form;	
	comboObj.RemoveAll();
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;	
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"rlane_cd");
		comboObj.Enable = true;	
	}		
}   
  
  /**
   * jo_crr_cd2_OnFocus
   **/    
  function jo_crr_cd2_OnFocus(comboObj){			  	  
		var formObj = document.form;
						
		if(comboObjects[0].Code == 'OUS' && formObj.re_divr_cd[1].checked == true){			// Item이 OUS, R/F, OTH이고 Expense인 경우
			if (comboObjects[1].Code.length < 3){			// Trade
				ComShowCodeMessage("JOO00009");
				formObj.trd_cd2.focus();
				return;
			}
			
			if (comboObjects[2].Code.length < 3){			// Lane
				ComShowCodeMessage("JOO00010");			// Please select 'Revenue Lane code'.";
				formObj.rlane_cd2.focus();
				return;
			}		
		}
					
		comboObj.RemoveAll();		
		if (comboObj.GetCount() == 0){
			comboObj.Enable = false;	
			doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"crr_cd");
			comboObj.Enable = true;	
		}	
	}      
  
  /**
   * jo_stl_itm_cd2_OnChange
   **/    
  function jo_stl_itm_cd2_OnChange(comboObj, idx_cd, text){
	  UF_setCond("1");
  } 
  
  /**
   * REDIVR_FLG = EXPENSE, ITEM = OUS,RF,OTH 일때만 활성화
   */
  function setBTNSublet(){

	  var tmpReDivrFlg = document.form.re_divr_cd[1].checked
	  var tmpItemCd = comboObjects[0].Code;
	  
	  if(tmpReDivrFlg && tmpItemCd == "OUS"){
		  ComEnableObject(document.form.sublet_yn,true);
		  ComBtnEnable("btn1_sublet_save");
	  } else {
		  ComEnableObject(document.form.sublet_yn,false)
		  ComBtnDisable("btn1_sublet_save");
		  document.form.sublet_yn.checked = false;
		  sublet_yn_click();
	  }
  }
/* 개발자 작업  끝 */