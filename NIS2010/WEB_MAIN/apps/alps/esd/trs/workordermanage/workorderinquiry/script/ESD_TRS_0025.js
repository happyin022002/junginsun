/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/*
 * 
 * ---------------------------------------------------------------------------
 * history
 * 2011.07.03 김영철 [CHM-201112014] W/O Inquiry 화면에 VAT 값 추가
 * 2011.10.25 최종혁 [CHM-201114099] [TRS] W/O inquiry 화면 기능 일부 수정요청
 * 2011.11.28 변종건 [CHM-201114747-01] [TRS] W/O inquiry 화면상 일부 칼럼 수정/변경 요청
 * 2015.06.23 9014787 [CHM-201535923] W/O Inquiry 개선2
 */
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0025 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0025() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];

	 /*******************************************************/
	 var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_reset":
				sheetObject.RemoveAll();
				formObject.reset();
				break;

			case "btn_minimize":
				if(document.all.MiniLayer.style.display != "none"){
					document.all.MiniLayer.style.display = "none";
					sheetObject.style.height = sheetObject.GetSheetHeight(16);
				}else {
					document.all.MiniLayer.style.display = "";
					sheetObject.style.height = sheetObject.GetSheetHeight(13);
				}
				break;
			case 'btns_wo_no':
				rep_Multiful_inquiry(srcName);
				break;

			case "btng_provider":
				rep_OnPopupClick();
				break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btng_detailinquiry":
				goSoInquiry(sheetObjects[1], formObject);
				break;

			case "btng_wopreview":
				goWoPreview(sheetObjects[1], formObject);
				break;

			case 'btns_calendar':
				getCalendar();
				break;

			case 'btng_edi':
				popEdiInquiry(sheetObject, formObject);
				break;

			case "btng_sohistory":
				soHistory(sheetObjects[2]);
			break;

			case "btng_detailinquiry2":
				goSoInquirySheet3(sheetObjects[2], formObject);
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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
	//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	//html컨트롤 이벤트초기화
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon ??? ??1. ???catch
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value = "";
    else
	form.boo_bl_no.value = form.hdn_boo_bl_no.value;
	*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(13) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(45, 4 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				var HeadTitle = "Seq.||S/N|W/O No.|Cost\nMode|Trans\nMode|Service\nProvider|Vendor|W/O ISS STS|Internal|W/O ISS TP|";
					HeadTitle += "W/O ISS Time|W/O ISS\nOffice|W/O ISS ID|User NM|From|Via|To|Door|Currency|Basic|Negotiated|Fuel|Vat|Additional |Total|Fax 1\nNumber|Fax 1\nStatus|Fax 2\nNumber|";
					HeadTitle += "Fax 2\nStatus|Fax 3\nNumber|Fax 3\nStatus|E-Mail\nAdd|E-Mail\nStatus|E-Mail 2\nAdd|E-Mail 2\nStatus";
					HeadTitle += "|E-Mail 3\nAdd|E-Mail 3\nStatus|edi_rslt_cd_text|EDI\nResult|EDI\nReceive Date|ETS";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDataSeq,    30,    daCenter,   false,    "seq",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtCheckBox,	  30,    daCenter,   false,    "wo_check",     false,          "",       dfNone,          0,     true,       true);;
				InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   false,    "wo_iss_knt",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "trsp_wo_ofc_cty_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "trsp_cost_dtl_mod_nm",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   false,    "trsp_crr_mod_nm",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "wo_vndr_seq",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       90,    daLeft,     false,    "vndr_nm",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "wo_iss_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "inter_use_flg",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "wo_iss_tp",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,      120,    daCenter,   false,    "wo_iss_dt",     false,          "",       dfNone,       0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "cre_ofc_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "upd_usr_id",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daLeft,     false,    "upd_usr_nm",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,		  60,	 daCenter,	 false,    "fm_nod_cd", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  60,	 daCenter,	 false,    "via_nod_cd", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  60,	 daCenter,	 false,    "to_nod_cd", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  60,	 daCenter,	 false,    "dor_nod_cd", false,    "",         dfNone,     0,     false,       false);		
				InitDataProperty(0, cnt++ , dtData,		  60,	 daCenter,	 false,    "curr_cd", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daRight,	 false,    "bzc_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daRight,	 false,    "nego_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daRight,	 false,    "fuel_scg_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daRight,	 false,    "scg_vat_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daRight,	 false,    "etc_add_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daRight,	 false,    "total",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       80,    daLeft,     false,    "wo_n1st_fax_no",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "fax1_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daLeft,     false,    "wo_n2nd_fax_no",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "fax2_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daLeft,     false,    "wo_n3rd_fax_no",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "fax3_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       90,    daLeft,     false,    "wo_n1st_eml",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "eml1_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     90,    daLeft,     false,    "wo_n2nd_eml",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     90,    daCenter,   false,    "eml2_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     90,    daLeft,     false,    "wo_n3rd_eml",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     80,    daCenter,   false,    "eml3_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     80,    daCenter,   false,    "edi_rslt_cd_text", false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daCenter,	 false,    "edi_rcv_rslt_cd", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daCenter,	 false,    "edi_rcv_rslt_dt", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  80,	 daCenter,	 false,    "ets_sts_flg", false,    "",         dfNone,     0,     false,       false);					
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "max_knt",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "trsp_cost_dtl_mod_cd",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "trsp_crr_mod_cd",     false,          "",       dfNone,          0,     true,       true);
				
				ToolTipOption="balloon:false;";
				
		   }
			break;

			case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = hiddenTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(25, 0 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;

				var HeadTitle = "Seq.||S/N|W/O No.|Cost Mode|Trans Mode|Vendor|Vendor|W/O ISS STS|W/O ISS TP|W/O ISS Time|W/O ISS OFC|W/O ISS ID|User NM|Fax 1 Number|Fax 1 Status|Fax 2 Number|Fax 2 Status|Fax 3 Number|Fax 3 Status|E-Mail 1 Add|E-Mail 1 Status|E-Mail 2 Add|E-Mail 2 Status|E-Mail 3 Add|E-Mail 3 Status";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,  30,   daCenter,   true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "trsp_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "trsp_so_seq");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "wo_cxl_flg");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "dtn_use_flg");
				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "wo_bl_no_iss_flg");
		   }
			break;
			
			
		case 3:      //sheet1 init
			with (sheetObj) {
			
				CountPosition = 1;
			
				// 높이 설정
				style.height = 140;
				//전체 너비 설정
				SheetWidth = subTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//				InitColumnInfo(46, 4 , 0, true);
				InitColumnInfo(47, 4 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				var HeadTitle = "Seq.||S/N|S/O No.|Cost\nMode|Trans\nMode|Service\nProvider|Vendor|W/O ISS STS|Internal|W/O ISS TP|";
//					HeadTitle += "CNTR No.|S/O Office|S/O CRE DT|W/O ISS ID|S/O UPD Name|S/O DEL|W/O Cancel Reason|To|Door|Currency|Basic|Negotiated|Fuel|Vat|Additional |Total|Fax 1\nNumber|Fax 1\nStatus|Fax 2\nNumber|";
					HeadTitle += "CNTR No.|S/O Office|S/O CRE DT|W/O ISS ID|S/O UPD Name|S/O DEL|Block Stowage|W/O Cancel Reason|To|Door|Currency|Basic|Negotiated|Fuel|Vat|Additional |Total|Fax 1\nNumber|Fax 1\nStatus|Fax 2\nNumber|";
					HeadTitle += "Fax 2\nStatus|Fax 3\nNumber|Fax 3\nStatus|E-Mail\nAdd|E-Mail\nStatus|E-Mail 2\nAdd|E-Mail 2\nStatus";
					HeadTitle += "|E-Mail 3\nAdd|E-Mail 3\nStatus|edi_rslt_cd_text|EDI\nResult|EDI\nReceive Date|ETS";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDataSeq,    30,    daCenter,   false,    "seq",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtCheckBox,	  30,    daCenter,   false,    "so_check",     false,          "",       dfNone,          0,     true,       true);;
				InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,   false,    "wo_iss_knt",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "trsp_so_no",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       90,    daCenter,   false,    "trsp_cost_dtl_mod_nm",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       40,    daCenter,   false,    "trsp_crr_mod_nm",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   false,    "wo_vndr_seq",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       90,    daLeft,     false,    "vndr_nm",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,   false,    "wo_iss_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   false,    "inter_use_flg",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       70,    daCenter,   false,    "wo_iss_tp",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "eq_no",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "cre_ofc_cd",     false,          "",       dfNone,          0,     false,       true);
				//InitDataProperty(0, cnt++ , dtData,      120,    daCenter,   false,    "locl_cre_dt",     false,          "",       dfNone,       0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,      120,    daCenter,   false,    "locl_cre_dt",     false,          "",       dfNone,       0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,   false,    "upd_usr_id",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       120,    daCenter,     false,    "upd_usr_nm",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,		  60,	 daCenter,	 false,    "delt_flg", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  100,	 daCenter,	 false,    "blck_stwg", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,		  120,	 daCenter,	 false,    "trsp_rjct_rsn_nm", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  60,	 daCenter,	 false,    "to_nod_cd", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  60,	 daCenter,	 false,    "dor_nod_cd", false,    "",         dfNone,     0,     false,       false);		
				InitDataProperty(0, cnt++ , dtHidden,		  60,	 daCenter,	 false,    "curr_cd", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daRight,	 false,    "bzc_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daRight,	 false,    "nego_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daRight,	 false,    "fuel_scg_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daRight,	 false,    "scg_vat_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daRight,	 false,    "etc_add_amt",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daRight,	 false,    "total",      false,          "",       dfNullFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       80,    daLeft,     false,    "trsp_so_ofc_cty_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,   false,    "trsp_so_seq",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       80,    daLeft,     false,    "dtn_use_flg",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,   false,    "wo_bl_no_iss_flg",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       80,    daLeft,     false,    "wo_n3rd_fax_no",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,   false,    "fax3_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       90,    daLeft,     false,    "wo_n1st_eml",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,       90,    daCenter,   false,    "eml1_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     90,    daLeft,     false,    "wo_n2nd_eml",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     90,    daCenter,   false,    "eml2_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     90,    daLeft,     false,    "wo_n3rd_eml",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     80,    daCenter,   false,    "eml3_sts_cd",     false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,     80,    daCenter,   false,    "edi_rslt_cd_text", false,          "",       dfNone,          0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daCenter,	 false,    "edi_rcv_rslt_cd", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daCenter,	 false,    "edi_rcv_rslt_dt", false,    "",         dfNone,     0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,		  80,	 daCenter,	 false,    "ets_sts_flg", false,    "",         dfNone,     0,     false,       false);					
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "max_knt",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "trsp_cost_dtl_mod_cd",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "trsp_crr_mod_cd",     false,          "",       dfNone,          0,     true,       true);
				
				ToolTipOption="balloon:false;";
				
		   }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:      //조회
		   if(ComIsNull(formObj.wo_no)){
	   			if(ComIsNull(formObj.fmdate) || ComIsNull(formObj.todate) || ComIsNull(formObj.wo_issue_office)){

	   				var errMsg = ComGetMsg('TRS90372');
                    ComShowMessage(errMsg);
//	   				ComShowCodeMessage("TRS90372");
					return false;
	   			}	   			
	   		}
	   		var days_between = ComGetDaysBetween(formObj.fmdate , formObj.todate) ;  // 조회 기간
	   		if( days_between   < 0) {
                var errMsg = ComGetMsg("TRS90118" );
                ComShowMessage(errMsg);
//				ComShowCodeMessage("TRS90118");
				formObject.from_date.focus();
				return false;
			}			
			if ( days_between > 60 ) {
				ComShowMessage(" Possible inquiry period is limited to 2 months.");
				return false;
			}
			
			// Clear sheet3
			sheetObjects[2].RemoveAll();
						
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_TRS_0025GS.do", TrsFrmQryString(formObj));
			break;

		case IBDOWNEXCEL:        // excel down
			if(validateForm(sheetObj,formObj,sAction))
			sheetObj.Down2Excel(-1, false, false, true);
			break;
	}
}

function doActionIBSheet3(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			url += '&wo_iss_knt='+sheetObj0.CellValue(arrRow, 'wo_iss_knt');
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch4Post("ESD_TRS_0025GS.do", TrsFrmQryString(formObj));

		break;
	}
}

/**
 * Surcharge Input Inquiry popup
 **/
function popEdiInquiry(sheetObj0,formObj){

	var sheetObj0 = sheetObjects[0];
	var arrRow = '' ;
	var chkRows = '' ;
	chkRows = sheetObj0.FindCheckedRow ("wo_check");
	arrRow = chkRows.split("|");

		if(arrRow == '' || arrRow.length-1 > 1)
    {
		ComShowMessage("Please select one row");
        
		return;
	}

		var wo_iss_tp = sheetObj0.CellValue(arrRow,'wo_iss_tp'); 
	
		if (wo_iss_tp.indexOf("EDI") < 0 ) {
            var errMsg = ComGetMsg('TRS90320');
            ComShowMessage(errMsg);	
//		ComShowCodeMessage('TRS90320');
		return;				
		}
	
	
	
	
	if(sheetObj0.CellValue(arrRow,'max_knt') != sheetObj0.CellValue(arrRow,'wo_iss_knt')){
        var errMsg = ComGetMsg("TRS90322" );
        ComShowMessage(errMsg);	
//		ComShowCodeMessage('TRS90322');
		return;
	}

	var myOption = "width=800,height=360,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0962.screen';
	url += '?trsp_wo_ofc_cty_cd='+sheetObj0.CellValue(arrRow, 'trsp_wo_ofc_cty_cd');
	url += '&wo_iss_knt='+sheetObj0.CellValue(arrRow, 'wo_iss_knt');
	url += '&wo_vndr_seq='+sheetObj0.CellValue(arrRow, 'wo_vndr_seq');
	url += '&wo_vndr_nm='+sheetObj0.CellValue(arrRow, 'vndr_nm');
	url += '&wo_iss_sts_cd='+sheetObj0.CellValue(arrRow, 'wo_iss_sts_cd');
	url += '&trsp_crr_mod_cd='+sheetObj0.CellValue(arrRow, 'trsp_crr_mod_cd');
	url += '&trsp_cost_dtl_mod_cd='+sheetObj0.CellValue(arrRow, 'trsp_cost_dtl_mod_cd');
	url += '&ets_sts_flg='+sheetObj0.CellValue(arrRow, 'ets_sts_flg');

//	myWin = window.open(url, "popEdiInquiry", myOption);
//	myWin.focus();
    ComOpenWindow(url, 'popEdiInquiry', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:800px;dialogHeight:400px', true);
}

// preview에서 조회
function goWoPreview(sheetObj,formObj){
	
	var sheetObj0 = sheetObjects[0];
	var chkRows = sheetObj0.FindCheckedRow ("wo_check");
	var arrRow = chkRows.split("|");
	var knt_wo_no = '';
	var total_knt_wo_no = '';

 	if(chkRows.length < 1){
        var errMsg = ComGetMsg("TRS90036" );
        ComShowMessage(errMsg);	
		return;
	}  	
	for (idx=0; idx<arrRow.length-1; idx++){ 
		var chkMax = sheetObj0.CellValue( arrRow[idx] , "seq" );   	
			if(sheetObj0.CellValue(chkMax,'max_knt') != sheetObj0.CellValue(chkMax,'wo_iss_knt')){
			ComShowMessage("Seq " + chkMax + " is not lastest Work Order Data!!");
			return;
	}else if(sheetObj0.CellValue(chkMax,'ets_sts_flg') == 'Y'){
		ComShowMessage("Seq " + chkMax + ComGetMsg('TRS90368'));
		return;
	}	
         knt_wo_no = sheetObj0.CellValue(chkMax, 'trsp_wo_ofc_cty_cd') ;
         total_knt_wo_no = total_knt_wo_no+','+knt_wo_no;
  	 } 
 	 		  		
	

	formObj.f_cmd.value = SEARCH01;
    formObj.wo_no_a.value = total_knt_wo_no;
	sheetObj.DoSearch4Post("ESD_TRS_0025GS.do", TrsFrmQryString(formObj));

	
	var cnt = 0;
	var cty_cd = '';
	var seq_no = '';
	var cancel_check = '';
	var detain = '';
	var bno_iss = '';

	for(var i=1; i<sheetObj.RowCount+1; i++)
	{
		if(cnt!=0){
			cty_cd += ',';
			seq_no += ',';
			cancel_check += ',';
			detain += ','; 
			bno_iss += ',';
		}
		
		cty_cd += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd');
		seq_no += sheetObj.CellValue(i, 'trsp_so_seq');
		cancel_check += 'N';
		detain += sheetObj.CellValue(i, 'dtn_use_flg');
		bno_iss += sheetObj.CellValue(i, 'wo_bl_no_iss_flg');
		cnt++;
	}

	document.woForm.issued.value = 'Y';
	document.woForm.pgmNo.value = 'ESD_TRS_0024';
	document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
	document.woForm.trsp_so_seq.value = seq_no;
	document.woForm.wo_cancel_flag.value = cancel_check;
	document.woForm.detain.value = detain;
	document.woForm.bno_issue.value = bno_iss;
	document.woForm.submit();
}


// so inquiry에서 조회
function goSoInquiry(sheetObj,formObj){

	var sheetObj0 = sheetObjects[0];	
	var chkRows = sheetObj0.FindCheckedRow ("wo_check");
	var arrRow = chkRows.split("|");
	var knt_wo_no = '';
	var total_knt_wo_no = '';

	if(chkRows.length < 1){
        var errMsg = ComGetMsg("TRS90036" );
        ComShowMessage(errMsg);	
		return;
	}    	

	for (idx=0; idx<arrRow.length-1; idx++){ 
		var chkMax = sheetObj0.CellValue( arrRow[idx] , "seq" );   	
			if(sheetObj0.CellValue(chkMax,'max_knt') != sheetObj0.CellValue(chkMax,'wo_iss_knt')){
			ComShowMessage("Seq " + chkMax + " is not lastest Work Order Data!!");
			return;
	  	}		
         knt_wo_no = sheetObj0.CellValue(chkMax, 'trsp_wo_ofc_cty_cd') ;
         total_knt_wo_no = total_knt_wo_no+','+knt_wo_no;
  	 } 

	formObj.f_cmd.value = SEARCH04;
    formObj.wo_no_a.value = total_knt_wo_no;
	sheetObjects[1].DoSearch4Post("ESD_TRS_0025GS.do", TrsFrmQryString(formObj));

	if(sheetObjects[1].RowCount < 1){
        var errMsg = ComGetMsg("TRS90321" );
        ComShowMessage(errMsg);	
		return;
	}

	var cnt = 0;
	var cty_cd = '';
	var seq_no = '';
	var cancel_check = '';
	var detain = '';
	var bno_iss = '';
	var sowonumber = '';

	for(var i=1; i<sheetObj.RowCount+1; i++)
	{
		if(cnt!=0){
			cty_cd += ',';
			seq_no += ',';
			cancel_check += ',';
			detain += ','; 
			bno_iss += ',';
			sowonumber += ',';
		}
		cty_cd += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd');
		seq_no += sheetObj.CellValue(i, 'trsp_so_seq');
		cancel_check += 'N';
		detain += sheetObj.CellValue(i, 'dtn_use_flg');
		bno_iss += sheetObj.CellValue(i, 'wo_bl_no_iss_flg');
		sowonumber += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd')+sheetObj.CellValue(i, 'trsp_so_seq');
		cnt++;
	}
//	document.woForm.pgmNo.value = 'ESD_TRS_0019';
//	document.woForm.sysCommUiNavigation.value = 'Trans S/O > Service Order';
//	document.woForm.sysCommUiTitle.value = 'Inquiry';
//	document.woForm.issued.value = 'Y';
//	document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
//	document.woForm.trsp_so_seq.value = seq_no;
//	document.woForm.wo_cancel_flag.value = cancel_check;
//	document.woForm.detain.value = detain;
//	document.woForm.bno_issue.value = bno_iss;
//	document.woForm.sowonumber.value = sowonumber;
//	document.woForm.action = 'ESD_TRS_0019.screen';
//	document.woForm.submit();
	
	var url = "ESD_TRS_0019.do";
		url += "?sysCommUiNavigation='Trans S/O > Service Order'";
		url += "&sysCommUiTitle=Inquiry";
		url += "&issued=Y";
		url += "&trsp_so_ofc_cty_cd="+cty_cd;
		url += "&trsp_so_seq="+seq_no;
		url += "&wo_cancel_flag="+cancel_check;
		url += "&detain="+detain;
		url += "&bno_issue="+bno_iss;
		url += "&sowonumber="+sowonumber;
	
	//ComOpenWindow(url, 'popSoInquiry', 'scroll:yes;status:no;toolbar:no;directories:yes;menubar:no;resizable:yes;dialogwidth:1024px;dialogHeight:800px', false);
	ComOpenWindow(url, 'popSoInquiry', 'width=1024, height=700, toolbar=0, directories=0, status=0, menubar=0, scrollbars=1, resizable=1');
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

	return true;
}


/**
 * rep_commodity팝업호출
 */
function rep_Multiful_inquiry(btn_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, x1) {
	var formObject = document.form;
	formObject.wo_no.value = rowArray;
}

function getCalendar(){
	
	var cal2 = new ComCalendarFromTo();
	cal2.displayType = "date";
	cal2.select(document.form.fmdate,document.form.todate,'yyyyMMdd');
	
}


/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick()
{
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');

}


/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}

/**
 * ofc팝업호출
 */
function ofc_OnPopupClick(val)
{

		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_so";
		var xx1=val;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 768, 447, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1');

} 

/** 이하 조회옵션 추가부분 
*/


//function bound_OnChange_1(obj) {
//	var codeval =obj.value;
//	var formObject = document.form;
//
//	formObject.hid_boundmode.value=codeval;
//}

/**
 * 콤보박스 -cost
 */
function bound_OnChange_2(obj){
	var codeval =obj.value;
	var formObject = document.form;
	formObject.hid_costmode.value=codeval;
//
//	//cost mode에 따른 화면정의!
//	setKindEnabled(); 
}

/**
 * 콤보박스 -trans
 */
function bound_OnChange_3(obj){
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_transmode.value=codeval;
//
//	//trans mode에 따른 화면정의!
//	setKindEnabled();
}

function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
//function sheet1_OnClick(sheetObj, row, col, value){
	with (sheetObj) {
		Row = MouseRow;
		var colName = ColSaveName(MouseCol);
		//var colName = ColSaveName(col);
		if (Row > 0 && "edi_rcv_rslt_cd" == colName) {
			MouseToolTipText = CellValue(Row, "edi_rslt_cd_text");
		}else{
			MouseToolTipText = "";
		}
	}
}

function sheet1_OnClick(sheetObj, row, col, value){
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH03;
	formObj.wo_no_a.value = sheetObj.CellValue(row, 'trsp_wo_ofc_cty_cd');
	sheetObjects[2].DoSearch4Post('ESD_TRS_0025GS.do?wo_iss_knt='+sheetObj.CellValue(row, 'wo_iss_knt'), TrsFrmQryString(formObj));
}

/**
 * S/O History
 */
function soHistory(sheetObj){
	var chkRows = null;
	chkRows = sheetObj.FindCheckedRow ("so_check");
	var soNo ="";
	
	var arrRow = chkRows.split("|");
	if ( chkRows == "") {
		ComShowCodeMessage('COM12176');
		return false;
	}else if(arrRow.length > 2){
		ComShowCodeMessage("COM12113", 'only one row');
		return false;
	}
	var so_no = null;
	var cost_mode = null;
	var param = null;
	for (idx=0; idx<arrRow.length-1; idx++){
		cost_mode = sheetObj.CellValue(arrRow[idx], 'trsp_cost_dtl_mod_cd');
		so_no = sheetObj.CellValue(arrRow[idx], 'trsp_so_no');
		param = "?so_no="+so_no;
   		
		if( cost_mode == 'CY' || cost_mode == 'DR' || cost_mode == 'TS' || cost_mode == 'LS'){
//			window.open('ESD_TRS_0975.do'+param, 'OpneHistoryWin', "scroll:no,status:no,help:no,width=900,Height=460");
			ComOpenWindow('ESD_TRS_0975.do'+param, 'OpneSOHistoryWin', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:930px;dialogHeight:460px', true);
		}
	}
	
}

/**
 * W/O 조회후 S/O 조회
 * @param sheetObj
 * @param errMsg
 */
function sheet1_OnSearchEnd(sheetObj,errMsg){
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		
		if(sheetObj.RowCount > 0){
			var formObj = document.form;
			formObj.f_cmd.value = SEARCH03;
			formObj.wo_no_a.value = sheetObj.CellValue(1, 'trsp_wo_ofc_cty_cd');
			sheetObjects[2].DoSearch4Post('ESD_TRS_0025GS.do?wo_iss_knt='+sheetObj.CellValue(1, 'wo_iss_knt'), TrsFrmQryString(formObj));
		}
	}
}

// Sheet3 so inquiry에서 조회
function goSoInquirySheet3(sheetObj,formObj){
	
	var chkRows = sheetObj.FindCheckedRow ("so_check");
	var arrRow = chkRows.split("|");

	if(chkRows.length < 1){
        var errMsg = ComGetMsg("TRS90036" );
        ComShowMessage(errMsg);	
		return;
	}

	var cnt = 0;
	var cty_cd = '';
	var seq_no = '';
	var cancel_check = '';
	var detain = '';
	var bno_iss = '';
	var sowonumber = '';

	for(var i=1; i<sheetObj.RowCount+1; i++)
	{
		if(cnt!=0){
			cty_cd += ',';
			seq_no += ',';
			cancel_check += ',';
			detain += ','; 
			bno_iss += ',';
			sowonumber += ',';
		}
		cty_cd += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd');
		seq_no += sheetObj.CellValue(i, 'trsp_so_seq');
		cancel_check += 'N';
		detain += sheetObj.CellValue(i, 'dtn_use_flg');
		bno_iss += sheetObj.CellValue(i, 'wo_bl_no_iss_flg');
		sowonumber += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd')+sheetObj.CellValue(i, 'trsp_so_seq');
		cnt++;
	}

	var url = "ESD_TRS_0019.do";
		url += "?sysCommUiNavigation='Trans S/O > Service Order'";
		url += "&sysCommUiTitle=Inquiry";
		url += "&issued=Y";
		url += "&trsp_so_ofc_cty_cd="+cty_cd;
		url += "&trsp_so_seq="+seq_no;
		url += "&wo_cancel_flag="+cancel_check;
		url += "&detain="+detain;
		url += "&bno_issue="+bno_iss;
		url += "&sowonumber="+sowonumber;
	
	//ComOpenWindow(url, 'popSoInquiry', 'scroll:yes;status:no;toolbar:no;directories:yes;menubar:no;resizable:yes;dialogwidth:1024px;dialogHeight:800px', false);
	ComOpenWindow(url, 'popSoInquiry', 'width=1024, height=700, toolbar=0, directories=0, status=0, menubar=0, scrollbars=1, resizable=1');
}
//
///**
// * 콤보박스 -so
// */
////function bound_OnChange_4(obj){
////	var codeval =obj.value;
////	var formObject = document.form;
////
////	formObject.hid_somode.value=codeval;
////}
////
/////**
//// * 콤보박스 -wo
//// */
////function bound_OnChange_5(obj){
////	var codeval =obj.value;
////	var formObject = document.form;
////
////	formObject.hid_womode.value=codeval;
////}
////
/////**
//// * 콤보박스 -invoice
//// */
////function bound_OnChange_6(obj){
////	var codeval =obj.value;
////	var formObject = document.form;
////
////	formObject.hid_invoicemode.value=codeval;
////}
////
/////**
//// * 콤보박스 -cargo
//// */
////function bound_OnChange_7(obj){
////	var codeval =obj.value;
////	var formObject = document.form;
////
////	formObject.hid_cargomode.value=codeval;
////}
////
////function bound_OnChange_8(obj){
////	var codeval =obj.value;
////	var formObject = document.form;
////
////	formObject.hid_sotype.value=codeval;
////}
////
////function bound_OnChange_9(obj){
////	var codeval =obj.value;
////	var formObject = document.form;
////
////	formObject.hid_amount.value=codeval;
////}
////
////function bound_OnChange_10(obj){
////	var codeval =obj.value;
////	var formObject = document.form;
////
////	formObject.hid_unplanned.value=codeval;
////}
//
///**
// * COST MODE, TRANS MODE 선택에 따른 조회조건 enabled처리
// **/
//function setKindEnabled() {
//	var formObj = document.form;
//	var sheetObj = sheetObjects[0];
//	var obj = document.form;
//
////		document.combo_svc_provider.Text = '';
////		formObj.svc_provider.value='';
//	formObj.search_fm_loc.value = '';
//	document.search_fm_yard.RemoveAll();
//	formObj.search_via_loc.value = '';
//	document.search_via_yard.RemoveAll();
//	formObj.search_to_loc.value = '';
//	document.search_to_yard.RemoveAll();
//	formObj.search_door_loc.value = '';
//	document.search_door_yard.RemoveAll();
//
//	node_add();
//	switch(ctMode) {
//		case 1:
//			obj.search_via_loc.disabled = true;
//			obj.search_door_loc.disabled = true;
//			document.search_via_yard.Enable = false;
//			document.search_door_yard.Enable = false;
//		break;
//
//		case 2:
//			obj.search_via_loc.disabled = false;
//			obj.search_door_loc.disabled = true;
//			document.search_via_yard.Enable = true;
//			document.search_door_yard.Enable = false;
//		break;
//
//		case 3:
//			obj.search_via_loc.disabled = true;
//			obj.search_door_yard.disabled = false;
//			document.search_via_yard.Enable = false;
//			document.search_door_yard.Enable = true;
//		break;
//
//		case 4:
//			obj.search_via_loc.disabled = false;
//			obj.search_door_yard.disabled = false;
//			document.search_via_yard.Enable = true;
//			document.search_door_yard.Enable = true;
//		break;
//	}
//}
