/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0212.js
*@FileTitle : DG Cargo Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.02 박상훈
* 1.0 Creation
* 2012.02.23 채창호 [CHM-201216183]:KOREA - DG CARGO MANIFEST 하역회사 추가 요청
* 2012.11.15 변종건 [CHM-201221332-01] Manifest - Korea - DG Cargo Manifest 보완 요청
* 2015.10.28 [CHM-201538422] 선광신컨테이너 터미널 이용관련 EDI 문서 송수신 위한 APLS 셋팅 요청
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0212()
{
	this.processButtonClick			= processButtonClick;
	this.setSheetObject				= setSheetObject;
	this.setComboObject				= setComboObject;
	this.loadPage					= loadPage;
	this.disableButtons				= disableButtons;
	this.initSheet					= initSheet;
	this.initCombo					= initCombo;
	this.comboAuth_OnChange			= comboAuth_OnChange;
	this.comboIO_OnChange			= comboIO_OnChange;
	this.comboDchgComCd_OnChange	= comboDchgComCd_OnChange;
	this.doActionIBSheet			= doActionIBSheet;
	this.validateForm				= validateForm;
	this.changeTextToNumberFormat	= changeTextToNumberFormat;
	this.changeNumberToTextFormat	= changeNumberToTextFormat;
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
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_RowAdd":
			sheetObject1.DataInsert(-1);
			break;

		case "btn_Delete":
			doActionIBSheet(sheetObject1,formObject,IBDELETE);
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject , IBSAVE);
			break;
			
		case "btn_TransDGM":
			doActionIBSheet(sheetObject1, formObject , MULTI01);
			break;
			
		case "btn_TransDGL":
			doActionIBSheet(sheetObject1, formObject , MULTI02);
			break;
			
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_New":
			sheetObjects[0].RemoveAll();
			formObject.reset();
			formObject.vvd.focus();
			comboObjects[0].Code = "020";
			comboObjects[1].Code = "02";
			comboObjects[2].Code = "BS-G-4122";
			formObject.dsch_com_nm.value = "㈜한진해운 신항만";
			break;
		case "btn_SelectAll":
			sheetObject1.CheckAll(1) = 2;
			if (sheetObject1.CheckedRows(1) < 1) {
				document.getElementById("btn_SelectAll").innerHTML  = "Select All";
			}else {
				document.getElementById("btn_SelectAll").innerHTML  = "Deselect All";
			}
			break;
		case "btn_DownExcel":
			var exceptLines = "";
			var chkCnt = 0;
			// 체크 안된 데이터들 묶음
			for(var i=1; i <= sheetObjects[0].RowCount; i++) {
				if (sheetObjects[0].CellValue(i, "Sel")==0) 
					exceptLines = exceptLines + "|" + i;
				else {
					chkCnt++;
				}
			}			
			if (chkCnt > 0) {
				sheetObjects[0].Redraw = false;
				sheetObjects[0].Down2Excel(-1, false, false, true, "", "", false, false, "", false, "Sel", exceptLines);
				sheetObjects[0].Redraw = true; 
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;
		case "btn_cal1":
			var cal = new ComCalendar();
			cal.select(formObject.send_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal2":
			var cal = new ComCalendar();
			cal.select(formObject.io_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal3":
			var cal = new ComCalendar();
			cal.select(formObject.arv_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal4":
			var cal = new ComCalendar();
			cal.select(formObject.from_dt, 'yyyy-MM-dd');
			break;
		case "btn_cal5":
			var cal = new ComCalendar();
			cal.select(formObject.to_dt, 'yyyy-MM-dd');
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

// 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;	
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
	
	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }

	// Key 입력 처리
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	// 버튼 상태 초기화
	disableButtons();
	
}
 
/**
 * 버튼 비활성화
 * @return
 */ 
function disableButtons()
{
	ComBtnDisable("btn_TransDGM");
	ComBtnDisable("btn_TransDGL");
	ComBtnDisable("btn_Save");
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
			style.height = 300;
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

			var HeadTitle = "|Sel.|Seq.|I/B Seq.|Container No.|UN No.|Certi No.|Certi No.|Job|Class|Class|Net Weight|B/L No.|Substance||||||";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++ , dtHiddenStatus,			60,		daCenter,		true,	"ibflag");
			InitDataProperty(0,		cnt++ , dtCheckBox,				40,		daCenter,		true,	"Sel");
			InitDataProperty(0,		cnt++ , dtDataSeq,				40,		daCenter,		true,	"seq");
			InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,	"ib_seq");
			InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		false,	"cntr_no",			false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		false,	"imdg_un_no",		false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		false,	"certi_no",			false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		false,	"certi_seq_no",		false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		false,	"job",				false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		false,	"imdg_clss_cd",		false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtData,					20,		daCenter,		false,	"imdg_comp_grp_cd", false,		"",		dfNone,					0,		false,		false);
			InitDataProperty(0,		cnt++ , dtData,					100,	daRight,		false,	"net_weight",		false,		"",		dfNullFloat,			3,		true,		true);
			InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		false,	"bl_no",			false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtData,					110,	daLeft,			false,	"substance",		false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtHidden,				0,		daLeft,			false,	"bkg_no",			false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtHidden,				0,		daLeft,			false,	"msn_no",			false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtHidden,				0,		daLeft,			false,	"pol_cd",			false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtHidden,				0,		daLeft,			false,	"pod_cd",			false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtHidden,				0,		daLeft,			false,	"cntr_seq",			false,		"",		dfNone,					0,		true,		true);
			InitDataProperty(0,		cnt++ , dtHidden,				0,		daLeft,			false,	"cstms_decl_tp_cd", false,		"",		dfNone,					0,		true,		true);

			CountPosition = 0;

		}
		break;
	// SAVE 동작을 위한 SHEET
	case "sheet2":
		with (sheetObj) {
			
			// 높이 설정
			style.height = 0;
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
			
			var HeadTitle = "|Save";
			var headCount = ComCountHeadTitle(HeadTitle);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++ , dtHiddenStatus,			60,		daCenter,		true,	"ibflag");
			InitDataProperty(0,		cnt++ , dtData,					40,		daCenter,		true,	"save");
			
			CountPosition = 0;
			
		}
		break;


	}
}

/**
 * Combo Object 초기화
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;	
	switch(comboObj.id) {
	case "comboAuth":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|100");			
			DropHeight = 400;
			ShowCol = 0;
			SetTitle("Code|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "020|KRPUS", "020");
			InsertItem(cnt ++, "030|KRINC", "030");
			InsertItem(cnt ++, "031|KRPTK", "031");
			InsertItem(cnt ++, "050|KRGIN", "050");
			InsertItem(cnt ++, "622|KRKAN", "622");
			InsertItem(cnt ++, "820|KRUSN", "820");
			Code = "020";
		}
		break;    	            
	case "comboIO":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("50|100");			
			DropHeight = 400;
			ShowCol = 0;
			SetTitle("Code|Description");
			MultiSelect = false;
			MaxSelect = 1 ;
			InsertItem(cnt ++, "01|입항", "01");
			InsertItem(cnt ++, "02|출항", "02");
			Code = "02";
		}
		break;    	            
	case "comboDchgComCd":
		with (comboObj) {
			SetColAlign("center|left");
			SetColWidth("90|180");			
			DropHeight = 400;
			ShowCol = 0;
			SetTitle("Com Code|DSCH Com");
			MultiSelect = false;
			MaxSelect = 1 ;

//			[CSR전환 중] SRM-201112614 DG CARGO MANIFEST 하역회사 추가 요청		
//			1. 등록 요청 하역 회사 		
//			SEQ	Com Code	DSCH Com
//			1	BS-G-9114	대한통운 부산컨테이너 터미널
//			2	BS-G-4111	부산 신항만
//			3	BS-G-0004	인터지스 감만
//			4	BS-G-9606	우암 터미널
//			5	BS-G-0014	한국허치슨부산터미널㈜ 부산
//			6	BS-R-2204	현대상선부산신항터미널
//			7	BS-G-9942	동부부산컨테이너터미널㈜ 			
			
			/* 기존에 BS-G-0010 코드를 사용하던 ㈜부산인터내셔널 터미널 을 BS-G-4137 코드를 사용하는 ㈜세방 부산 터미널 로 변경 
			 * [CHM-201112946-01] DG CARGO MANIFEST의 DISCHARGING COMPANY CODE & DSCH COM 변경 요청
			 * [CHM-201216183]:KOREA - DG CARGO MANIFEST 하역회사 추가 요청
			 * 내용:  BS-Z-9558     부산신항국제터미널  <--추가
             *       BS-G-4141    (주)비엔시티  <-- 추가 
             *       OLD:   YS-G-0006   (주)세방한진   --> NEW:  YS-G-2013   (주)한진해운 광양터미널 변경
			 */
//			InsertItem(cnt ++, "BS-G-0010|㈜부산인터내셔널 터미널", "BS-G-0010");
			InsertItem(cnt ++, "BS-G-4122|㈜한진해운 신항만", "BS-G-4122");
			InsertItem(cnt ++, "BS-G-4137|BPT감만", "BS-G-4137"); 
			InsertItem(cnt ++, "YS-G-2013|SM상선 광양터미널", "YS-G-2013");
			InsertItem(cnt ++, "IC-G-1048|㈜인천컨테이너터미날", "IC-G-1048");
			InsertItem(cnt ++, "PT-K-1107|㈜평택컨테이너터미날", "PT-K-1107");						
			InsertItem(cnt ++, "GI-G-1003|SM상선 경인터미널", "GI-G-1003");	
			InsertItem(cnt ++, "BS-G-9114|BPT 신선대", "BS-G-9114");
			InsertItem(cnt ++, "BS-G-4111|부산 신항만", "BS-G-4111");
//			InsertItem(cnt ++, "BS-G-0004|인터지스 감만", "BS-G-0004");
//			InsertItem(cnt ++, "BS-G-9606|우암 터미널", "BS-G-9606");
			InsertItem(cnt ++, "BS-G-0014|한국허치슨부산터미널㈜ 부산", "BS-G-0014");			
			InsertItem(cnt ++, "BS-R-2204|현대상선부산신항터미널", "BS-R-2204");			
			InsertItem(cnt ++, "BS-G-9942|동부부산컨테이너터미널㈜", "BS-G-9942");
			InsertItem(cnt ++, "BS-Z-9558|부산신항국제터미널", "BS-Z-9558");			
			InsertItem(cnt ++, "BS-G-4141|㈜비엔시티", "BS-G-4141");			
			InsertItem(cnt ++, "IC-G-1059|E1컨테이너터미널", "IC-G-1059");
			InsertItem(cnt ++, "IC-G-1067|선광신컨테이너터미널(주)", "IC-G-1067");
			InsertItem(cnt ++, "IC-G-1068|한진인천컨테이너터미널", "IC-G-1068");
			InsertItem(cnt ++, "US-G-0901|울산동방아이포트", "US-G-0901");
			InsertItem(cnt ++, "US-G-1004|정일 울산컨테이너 터미널", "US-G-1004");
			InsertItem(cnt ++, " | ", " ");
			Code = "BS-G-4122";
		}
		break;    	            
	}
}

/**
 * Auth 변경시 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function comboAuth_OnChange(comboObj,value,text) {
	var form = document.form;
	form.authority.value = value;
}

/**
 * IO 변경시 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function comboIO_OnChange(comboObj,value,text) {
	var form = document.form;
	form.io.value = value;
}

/**
 * Discharging Compnay Code 변경시 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function comboDchgComCd_OnChange(comboObj, value, text) {
	var form = document.form;
	form.dchg_com_cd.value = value;
	if (value.length < 1) {
		form.dchg_com_cd.value = text;
	} else {
		form.dsch_com_nm.value = comboObjects[2].GetText(value, 1);
	}
}

 
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			disableButtons();
			// 시간 및 변수 초기화
			formObj.arv_tm.value="";
			formObj.io_tm.value="";
			formObj.send_tm.value="";
			formObj.to_tm.value="";
			formObj.from_tm.value="";
			formObj.deleteBtnChkYN.value = 'N';         //RowDelete Clear
			formObj.max_vvd_seq.value = "0";
			formObj.dgco_seq.value="001";
			formObj.f_cmd.value = SEARCH;
			sheetObj.Redraw = false;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.getSearchXml("ESM_BKG_0212GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");			
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			// SORT
			sheetObjects[0].ColumnSort("4");

			// 조회결과 매핑 
			ComEtcDataToForm(formObj, sheetObj);

			if ( ComLpad(sheetObjects[0].EtcData("dgco_seq"),3,"0") == "undefined"){
				formObj.dgco_seq.value = "001";
			}else{
				formObj.dgco_seq.value = ComLpad(sheetObjects[0].EtcData("dgco_seq"),3,"0");
			}
			
			sheetObj.Redraw = true;			
			// 날짜와 시간을 분리 처리
			with(formObj) {
				if (arv_dt.value.length > 10) {
					arv_tm.value = arv_dt.value.substring(11,16);
					arv_dt.value = arv_dt.value.substring(0,10);
				}
				if (io_dt.value.length > 10) {
					io_tm.value = io_dt.value.substring(11,16);
					io_dt.value = io_dt.value.substring(0,10);
				}
				if (send_dt.value.length > 10) {
					send_tm.value = send_dt.value.substring(11,16);
					send_dt.value = send_dt.value.substring(0,10);
				}
				if (from_dt.value.length > 10) {
					from_tm.value = from_dt.value.substring(11,16);
					from_dt.value = from_dt.value.substring(0,10);
				}
				if (to_dt.value.length > 10) {
					to_tm.value = to_dt.value.substring(11,16);
					to_dt.value = to_dt.value.substring(0,10);
				}
			}

			 /**
			  * 기존에 BS-G-0010 코드를 사용하던 '㈜부산인터내셔널 터미널'을 BS-G-4137 코드를 사용하는 '㈜세방 부산 터미널'로 변경 
			  * [CHM-201112946-01] DG CARGO MANIFEST의 DISCHARGING COMPANY CODE & DSCH COM 변경 요청
			  */ 
			if(formObj.dchg_com_cd.value == 'BS-G-0010') {
		 		formObj.dchg_com_cd.value = 'BS-G-4137';
		 	}
			
			// 콤보 처리
			comboObjects[0].Code = formObj.authority.value;
			comboObjects[1].Code = formObj.io.value;
			if (comboObjects[2].FindIndex(formObj.dchg_com_cd.value,0) < 0) 
				comboObjects[2].InsertItem(-1, formObj.dchg_com_cd.value, formObj.dchg_com_cd.value);
			comboObjects[2].Code = formObj.dchg_com_cd.value;

			changeTextToNumberFormat(formObj);
			
			// 조회결과에 따른 처리
			if( formObj.mrn_no.value.length > 1 ){
				ComBtnEnable("btn_Save");
				if( formObj.current_check[1].checked ){
					//MRN 항목에 SMLM가 아닌 타선사 운항인 경우 반입신고서 버튼 비활성화
					if( formObj.mrn_no.value.indexOf("SMLM") >= 0 ){
						ComBtnEnable("btn_TransDGM");
					}
					
					if( sheetObjects[0].RowCount > 0 ){
						ComBtnEnable("btn_TransDGL");
					}
				}
				sheetObj.CheckAll("Sel") = 1;
				document.getElementById("btn_SelectAll").innerHTML  = "Deselect All";
			}

			ComOpenWait(false);
		}	
		break;

	case IBSAVE:        //저장
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			ComOpenWait(true);
			ibSeqAssign(formObj, sheetObjects[0]);
			
			sheetObjects[1].RemoveAll();
			sheetObjects[1].DataInsert(-1);
			sheetObjects[1].RowStatus(1) = "U";
			formObj.f_cmd.value = MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			var params = FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, true), "sheet1_");
			var sXml = sheetObjects[1].DoSave("ESM_BKG_0212GS.do",  params, -1, false);
			changeTextToNumberFormat(formObj);
			// 자동 조회
			formObj.current_check[1].checked = true;
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			ComOpenWait(false);
			formObj.deleteBtnChkYN.value = 'N';         //RowDelete Clear
		}
		break;
		
	case MULTI01:        // Transmit DGN
		// Validation Check
		if(validateForm(sheetObj,formObj,sAction)) {
			if(ComShowCodeConfirm('BKG95003', 'Transmit')){   // Do you want to ...?
				ComOpenWait(true);
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].RowStatus(1) = "U";
				formObj.f_cmd.value = MULTI;
				changeNumberToTextFormat(formObj);
				ComBtnDisable("btn_Save");
				var params = FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, true), "sheet1_");
				var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0212GS.do",  params);
				changeTextToNumberFormat(formObj);
				// 자동 조회
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				
				// Transmit
				formObj.f_cmd.value = MULTI01;
				params = FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, true), "sheet1_");
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].RowStatus(1) = "U";
				sheetObjects[1].DoSave("ESM_BKG_0212GS.do",  params, -1, false);
				ComOpenWait(false);
			}
		}
		break;
		
	case MULTI02: 	// Transmit DGM
		// Validation Check
		if(validateForm(sheetObj,formObj,sAction)) {
			if(ComShowCodeConfirm('BKG95003', 'Transmit')){
				ComOpenWait(true);
				
				ibSeqAssign(formObj, sheetObjects[0]);
				
				// 우선 SAVE
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].RowStatus(1) = "U";
				formObj.f_cmd.value = MULTI;
				changeNumberToTextFormat(formObj);
				ComBtnDisable("btn_Save");
				var params = FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, true), "sheet1_");
				var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_0212GS.do",  params);
				changeTextToNumberFormat(formObj);
				
				// Transmit
				formObj.f_cmd.value = MULTI02;
				params = FormQueryString(formObj) + "&" + ComSetPrifix(ComGetSaveString(sheetObj, true, false, "Sel"), "sheet1_");
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].RowStatus(1) = "U";
				sheetObjects[1].DoSave("ESM_BKG_0212GS.do",  params, -1, false);
				ComOpenWait(false);
				
				// 자동 조회
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
		break;
	
	case IBDELETE:		// ROW DELETE
		ComRowHideDelete(sheetObj,"Sel");
	    formObj.deleteBtnChkYN.value = 'Y';         //RowDelete Check
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		
		switch(sAction) {
		case IBSEARCH:
			if (vvd.value.length < 9) {
				ComShowCodeMessage("BKG00115");
				vvd.focus();
				return false;
			}
			if (pol_cd.value.length + pod_cd.value.length < 5) {
				ComShowCodeMessage("BKG00214");
				return false;
			}
			if (pod_cd.value.length > 1 && pol_cd.value.length > 1) {
				ComShowCodeMessage("BKG00231");
				return false;
			}
			break;
		case IBSAVE:
			if (vvd.value.length < 9) {
				ComShowCodeMessage("BKG00115");
				vvd.focus();
				return false;
			}
			if (pol_cd.value.length + pod_cd.value.length < 5) {
				ComShowCodeMessage("BKG00214");
				return false;
			}
			if (pod_cd.value.length > 1 && pol_cd.value.length > 1) {
				ComShowCodeMessage("BKG00231");
				return false;
			}
			break;
		case MULTI02:
			
			var gridChecked = false;
			
			// Grid Check 여부 확인
			for(var i=1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, "Sel")==1) {
					gridChecked = true;
					break;
				}
			}
			
			if (gridChecked==false) {
				ComShowCodeMessage("BKG00775");
				return false;
			}
			
			if (pod_cd.value.length < 1 && pol_cd.value.length > 1) {

				var certiCheck = false;
				for(var i=1; i <= sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i, "Sel")==1 && sheetObj.CellValue(i, "certi_seq_no").length < 1) {
						certiCheck = true;
						break;
					}
				}	
				
				if (certiCheck) {
					ComShowCodeMessage("COM12114", "Certi Seq");
					sheetObj.CheckAll(1) = 0;
					return false;
				}
			}
			
			break;
		}
	}

	return true;
}

/**
 * 숫자형태 콤마 등 추가
 * @param formObj
 * @return
 */
function changeTextToNumberFormat(formObj) {
	formObj.total_cntr.value  	= ComGetMaskedValue(formObj.total_cntr.value, 	"int");
	formObj.total_wgt.value  	= ComGetMaskedValue(formObj.total_wgt.value, 	"float");
}

/**
 * 숫자형태 콤마 제거
 * @param formObj
 * @return
 */
function changeNumberToTextFormat(formObj) {
	formObj.total_cntr.value  	= ComGetUnMaskedValue(formObj.total_cntr.value, "int");
	formObj.total_wgt.value  	= ComGetUnMaskedValue(formObj.total_wgt.value, 	"float");
}

function ibSeqAssign(formObj, sheetObj){
	
	// In Bound 인 경우에만 자동 채번
	if(formObj.pod_cd.value.length == 5){
	
		var ibSeq = formObj.dgco_seq.value;
		for(var i=1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "ib_seq").trim().length > 0) continue;
			sheetObj.CellValue(i, "ib_seq") = ComLpad(ibSeq, 3, "0");
			ibSeq++;
		}
	}
}