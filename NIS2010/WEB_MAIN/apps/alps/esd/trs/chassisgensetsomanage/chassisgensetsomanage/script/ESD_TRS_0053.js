/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0053 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0053() {
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
var seqNo = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];
	 var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_reset":
				resetForm(formObject);
				break;

			case "btn_minimize":
				if(document.all.MiniLayer.style.display != "none"){
					document.all.MiniLayer.style.display = "none";
					sheetObject.style.height = sheetObject.GetSheetHeight(17);
				}
				else {
					document.all.MiniLayer.style.display = "";
					sheetObject.style.height = sheetObject.GetSheetHeight(13);
				}
				break;
				
			case "btns_calendar1":
				 var cal = new ComCalendar();
				 cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
				break;

			case "btns_calendar2":
				 var cal = new ComCalendar();
				 cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
				break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btng_sodelete":
				doActionIBSheet(sheetObject,formObject,IBDELETE);
         	    break;

			case "btng_unbundling":
				unBundle(sheetObject);
				break;

			case "btng_bundling":
				itemBundling(sheetObject);
				break;

			case "btng_fillineq":
				popEqFileImport(sheetObject, formObject);
				break;

			case "btn_fm_node":
				openHireYardPopup('fm_node');
				break;

			case "btn_to_node":
				openHireYardPopup('to_node');
				break;

			case "btng_rateapply":
				popMultiApply(sheetObject);
				break;

			case "btng_socreation":
				doActionIBSheet(sheetObject,formObject, IBSAVE, 'C');
				break;

			case "btng_woissue":
				doActionIBSheet(sheetObject,formObject, IBSAVE, 'I');
				break;

			case "btn_eq_no":
				rep_Multiful_inquiry(srcName);
				break;
			case 'btns_calendar':
				var cal2 = new ComCalendarFromTo();
				cal2.displayType = "date";
				cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
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
	    //Axon 이벤트 처리1. 이벤트catch
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
	    //???? ????
	//    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation?? manual? ???? ??? ????. <br>
	 **/
	function manual_click() {
	    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
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
	//    return ComChkObjValid(event.srcElement);
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
	    //?????? ???
	//    ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	    //???????
	//    ComKeyOnlyNumber(event.srcElement);
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
				style.height = GetSheetHeight(13);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(45, 6, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "|STS|Bundle\nSEQ||Bundle\nKind|Kind|EQ No|EQ\nTP/SQ|From\nNode|From\nNode|To\nNode"
							+ "|To\nNode|Trans.\nMode|Distance(Km)|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus" 
							+ "|Creation Yard|Event Date|Internal Remark"
							+ "|Reference\nCNTR No|Reference\nTP\SZ|Reference\nBKG No"
							+ "|Reference\nB/L No|Outgate Date|Outgate Date|Ingate Date|Ingate Date"
							+ "|Remark\n(Special Instruction)|Verify\nresult|row no";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,  30,	daCenter,	false,  "ibcheck");
				InitDataProperty(0, cnt++ , dtStatus,	 30,	daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	true,   "trsp_so_cmb_seq",		false,	"",	dfNone,      0,     false,	false,  10);
				InitDataProperty(0, cnt++ , dtHidden,    30,	daCenter,	false,  "trsp_so_cmb_tp_cd",	false,	"",	dfNone,		 0,  	false,	false,	10);
				InitDataProperty(0, cnt++ , dtData,     100,	daCenter,	false,  "trsp_so_cmb_tp_nm",	false,	"",	dfNone,		 0,  	false,	false,	10);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "chss_mgst_trsp_tp_cd",	true,  	"", dfNone,      0,     false,	false,  20);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "eq_no",				false,  "", dfNone,      0,    	false,	false,  10);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,	false,  "eq_tpsz_cd",			true,  	"", dfNone,      0,     false,	false,   3);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,	false,  "fm_loc_value",			true,  	"", dfNone,      0,      true,	 true,   5);
				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,	false,  "fm_yard_value",		true,  	"", dfNone,      0,      true,	 true,   2);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,	false,  "to_loc_value",			true,  	"", dfNone,      0,      true,	 true,   5);
				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,	false,  "to_yard_value",		true,  	"", dfNone,      0,      true,	 true,   2);
				InitDataProperty(0, cnt++ , dtCombo,    110,    daCenter,	false,  "trsp_crr_mod_cd",		true,  	"", dfNone,      0,     false,  false,   2);
   				
				//2012.06.11 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData,   	90, 	 daRight,   false, 	"ttl_dist", 			false, "", dfInteger, 	0, 		false, 	false);
				
				InitDataProperty(0, cnt++ , dtData,      70,      daLeft,	false,  "vndr_abbr_nm",			false,  "", dfNone,      0,     false,  false,   4);
				InitDataProperty(0, cnt++ , dtData,      90,    daCenter,	false,  "lstm_cd",				false,  "", dfNone,      0,     false,  false,   4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "ownr_co_cd",			false,  "", dfNone,      0,     false,  false,   5);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "usr_co_cd",			false,  "", dfNone,      0,     false,  false,   4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "mvmt_sts_cd",			false,  "", dfNone,      0,     false,  false,   5);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "lst_sts_yd_cd",		false,  "", dfNone,      0,     false,  false,   4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "mvmt_dt",				false,  "", dfNone,      0,     false,  false,   8);
				InitDataProperty(0, cnt++ , dtData,     120,      daLeft,	false,  "inter_rmk",			false,  "", dfNone,      0,     true,    true, 255);
				
				InitDataProperty(0, cnt++ , dtData,     120,	daCenter,	false,	"cntr_no",				false,  "", dfNone,		 0,  	true,    true,  14);
				InitDataProperty(0, cnt++ , dtData,      80,	daCenter,	false,	"cntr_tpsz_cd",			false,  "", dfNone,		 0,  	true,    true,   4);
				InitDataProperty(0, cnt++ , dtData,     100,	daCenter,	false,	"ref_bkg_no",			false,  "", dfNone,		 0,  	true,    true,  11);
				InitDataProperty(0, cnt++ , dtData,     120,	daCenter,	false,	"ref_bl_no",			false,  "", dfNone,		 0,  	true,    true,  12);
				InitDataProperty(0, cnt++ , dtData,      80,	daCenter,	false,	"org_gate_out_date",	false,  "", dfDateYmd,	 0,  	true,    true,   8);
				InitDataProperty(0, cnt++ , dtData,      80,	daCenter,	false,	"org_gate_out_time",	false,  "", dfTimeHms,	 0,  	true,    true,   8);
				InitDataProperty(0, cnt++ , dtData,      80,	daCenter,	false,	"dest_gate_in_date",	false,  "", dfDateYmd,	 0,  	true,    true,   8);
				InitDataProperty(0, cnt++ , dtData,      80,	daCenter,	false,	"dest_gate_in_time",	false,  "", dfTimeHms,	 0,  	true,    true,   8);
				
				InitDataProperty(0, cnt++ , dtData,     150,      daLeft,	false,  "spcl_instr_rmk",		false,  "", dfNone,      0,     true,    true, 255);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "verify_result",		false,  "", dfNone,      0,    false,   false,  20);
				InitDataProperty(0, cnt++ , dtDataSeq,	 50,    daCenter,	false,	"sheet_row");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"vndr_seq");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"mvmt_sts_nm");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"isimport");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"eq_knd_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"trsp_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"trsp_so_seq");
				InitDataProperty(0, cnt++ , dtCheckBox,   0,    daCenter,	false,	"bun_check");
				InitDataProperty(0, cnt++ , dtHidden,	  0,	daCenter,	false,	"trsp_so_cmb_seq2");
				InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,	false,	"org_gate_out_dt");
				InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,	false,	"dest_gate_in_dt");
  			    InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,	false,	"wo_issue");
  			    
  			    InitDataProperty(0, cnt++,  dtHidden,  	  0, 	daCenter, 	false, "lnk_dist_div_cd", 	false, "", dfNone, 		1, false, false);
  			  
				
				InitDataCombo(0, 'trsp_crr_mod_cd', " |"+trsp_crr_mod_cdText, " |"+trsp_crr_mod_cdCode);
				InitDataCombo(0, 'chss_mgst_trsp_tp_cd', " |"+chss_mgst_trsp_tp_cdText, " |"+chss_mgst_trsp_tp_cdCode);
				//InitDataCombo(0, 'trsp_so_cmb_tp_cd', " |"+trsp_so_cmb_tp_cdText, " |"+trsp_so_cmb_tp_cdCode);
				ColHidden('sheet_row') = true;
				ColHidden('ibflag') = true;
				ColHidden('bun_check') = true;
			}
			break;
		 case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable2.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(32, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "|STS|Bundle\nSEQ||Bundle\nKindKind|EQ No|EQ\nTP/SQ|From\nNode|From\nNode|To\nNode|To\nNode|Trans.\nMode|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Internal Remark|Remark\n(Special Instruction)|Verify\nResult|row no";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,  30,	daCenter,	false,   "ibcheck");
				InitDataProperty(0, cnt++ , dtStatus,	 30,	daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	true,   "trsp_so_cmb_seq",		false,	"",	dfNone,      0,    false,       false,          10);
				InitDataProperty(0, cnt++ , dtCombo,    100,	daCenter,	false,  "trsp_so_cmb_tp_cd",false,	"",	dfNone,		0,  false,	false,	10);
				InitDataProperty(0, cnt++ , dtCombo,     80,    daCenter,	false,  "chss_mgst_trsp_tp_cd",	true,  "", dfNone,      0,     false,       false,          20);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "eq_no",				false,  "", dfNone,      0,     true,       true,          10);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,	false,  "eq_tpsz_cd",			true,  "", dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,	false,  "fm_loc_value",			true,  "", dfNone,      0,     true,       true,          5);
				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,	false,  "fm_yard_value",		true,  "", dfNone,      0,     true,       true,          2);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,	false,  "to_loc_value",			true,  "", dfNone,      0,     true,       true,          5);
				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,	false,  "to_yard_value",		true,  "", dfNone,      0,     true,       true,          2);
				InitDataProperty(0, cnt++ , dtCombo,    110,    daCenter,	false,  "trsp_crr_mod_cd",		true,  "", dfNone,      0,     true,       true,          2);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,	false,  "vndr_abbr_nm",			false,  "", dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,      90,    daCenter,	false,  "lstm_cd",				false,  "", dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "ownr_co_cd",			false,  "", dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "usr_co_cd",			false,  "", dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "mvmt_sts_cd",			false,  "", dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "lst_sts_yd_cd",		false,  "", dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "mvmt_dt",				false,  "", dfNone,      0,     false,       false,          8);
				InitDataProperty(0, cnt++ , dtData,     120,    daCenter,	false,  "inter_rmk",			false,  "", dfNone,      0,     true,       true,          255);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "spcl_instr_rmk",		false,  "", dfNone,      0,     true,       true,          255);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "verify_result",		false,  "", dfNone,      0,     true,       true,          20);
				InitDataProperty(0, cnt++ , dtDataSeq,	 50,    daCenter,	false,	"sheet_row");
				InitDataProperty(0, cnt++ , dtHidden,    0,     daCenter,	false,	"vndr_seq");
				InitDataProperty(0, cnt++ , dtHidden,    0,     daCenter,	false,	"mvmt_sts_nm");
				InitDataProperty(0, cnt++ , dtHidden,    0,     daCenter,	false,	"isimport");
				InitDataProperty(0, cnt++ , dtHidden,    0,     daCenter,	false,	"eq_knd_cd");
				InitDataProperty(0, cnt++ , dtHidden,    0,     daCenter,	false,	"trsp_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden,    0,     daCenter,	false,	"trsp_so_seq");
				InitDataProperty(0, cnt++ , dtCheckBox,  0,     daCenter,	false,	"bun_check");
				InitDataProperty(0, cnt++ , dtData,  	 0,     daCenter,	false,	"trsp_so_cmb_seq2");
  			    InitDataProperty(0, cnt++ , dtHidden,    0,		daCenter,	false,	"wo_issue");
				
				InitDataCombo(0, 'trsp_crr_mod_cd', " |"+trsp_crr_mod_cdText, " |"+trsp_crr_mod_cdCode);
				InitDataCombo(0, 'chss_mgst_trsp_tp_cd', " |"+chss_mgst_trsp_tp_cdText, " |"+chss_mgst_trsp_tp_cdCode);
				//InitDataCombo(0, 'trsp_so_cmb_tp_cd', " |"+trsp_so_cmb_tp_cdText, " |"+trsp_so_cmb_tp_cdCode);
				InitDataCombo (0, 2, "Stack|Flatbed", "BS|BF","Stack");

				ColHidden('bun_check') = true;
				ColHidden('trsp_so_cmb_seq2') = true;
			}																		 
			break;

			case 3:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable3.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(31, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "|STS|Bundle\nSEQ|Kind|EQ No|EQ\nTP/SQ|From\nNode|From\nNode|To\nNode|To\nNode|Trans.\nMode|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Internal Remark|Remark\n(Special Instruction)|Verify\nResult|row no";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,  30,	daCenter,	false,   "ibcheck");
				InitDataProperty(0, cnt++ , dtStatus,	 30,	daCenter,	false,	"ibflag");
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	true,   "trsp_so_cmb_seq",		false,	"",	dfNone,      0,     true,       true,          10);
				InitDataProperty(0, cnt++ , dtCombo,     80,    daCenter,	false,  "chss_mgst_trsp_tp_cd",	true,  "", dfNone,      0,     false,       false,          20);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "eq_no",				false,  "", dfNone,      0,     true,       true,          10);
				InitDataProperty(0, cnt++ , dtData,      50,    daCenter,	false,  "eq_tpsz_cd",			true,  "", dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,	false,  "fm_loc_value",			true,  "", dfNone,      0,     true,       true,          5);
				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,	false,  "fm_yard_value",		true,  "", dfNone,      0,     true,       true,          2);
				InitDataProperty(0, cnt++ , dtData,      70,    daCenter,	false,  "to_loc_value",			true,  "", dfNone,      0,     true,       true,          5);
				InitDataProperty(0, cnt++ , dtData,      40,    daCenter,	false,  "to_yard_value",		true,  "", dfNone,      0,     true,       true,          2);
				InitDataProperty(0, cnt++ , dtCombo,    110,    daCenter,	false,  "trsp_crr_mod_cd",		true,  "", dfNone,      0,     true,       true,          2);
				InitDataProperty(0, cnt++ , dtData,      70,      daLeft,	false,  "vndr_abbr_nm",			false,  "", dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,      90,    daCenter,	false,  "lstm_cd",				false,  "", dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "ownr_co_cd",			false,  "", dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "usr_co_cd",			false,  "", dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "mvmt_sts_cd",			false,  "", dfNone,      0,     false,       false,          5);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "lst_sts_yd_cd",		false,  "", dfNone,      0,     false,       false,          4);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "mvmt_dt",				false,  "", dfNone,      0,     false,       false,          8);
				InitDataProperty(0, cnt++ , dtData,     120,    daCenter,	false,  "inter_rmk",			false,  "", dfNone,      0,     true,       true,          255);
				InitDataProperty(0, cnt++ , dtData,      80,      daLeft,	false,  "spcl_instr_rmk",		false,  "", dfNone,      0,     true,       true,          255);
				InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	false,  "verify_result",		false,  "", dfNone,      0,     true,       true,          20);
				InitDataProperty(0, cnt++ , dtDataSeq,	 50,    daCenter,	false,	"sheet_row");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"vndr_seq");
				InitDataProperty(0, cnt++ , dtHidden,     0,      daLeft,	false,	"mvmt_sts_nm");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"isimport");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"eq_knd_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"trsp_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,	false,	"trsp_so_seq");
				InitDataProperty(0, cnt++ , dtCheckBox,   0,    daCenter,	false,	"bun_check");
				InitDataProperty(0, cnt++ , dtData,       0,    daCenter,	false,	"trsp_so_cmb_seq2");
  			    InitDataProperty(0, cnt++ , dtHidden,     0,	daCenter,	false,	"wo_issue");
				
				InitDataCombo(0, 'trsp_crr_mod_cd', " |"+trsp_crr_mod_cdText, " |"+trsp_crr_mod_cdCode);
				InitDataCombo(0, 'chss_mgst_trsp_tp_cd', " |"+chss_mgst_trsp_tp_cdText, " |"+chss_mgst_trsp_tp_cdCode);
				ColHidden('bun_check') = true;
				ColHidden('trsp_so_cmb_seq2') = true;
			}																		 
			break;

			case 4:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
					cnt = 0;
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = hiddenTable1.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "sts|svc_ord|seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE, WIDTH,DATAALIGN,COLMERGE, SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,   150,	daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++,  dtData,		150,	daCenter,	false,  "trsp_so_ofc_cty_cd", false,  "", dfNone,		0,	false,  false,  20);
                    InitDataProperty(0, cnt++ , dtData,     150,	daCenter,	false,  "trsp_so_seq", false,  "", dfNone,		0,	false,  false,  20);
			   }
               break;
	}
}



// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, trspSoStsCD) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}

			if(formObj.kind_chassis[0].checked ||formObj.kind_chassis[2].checked){
				formObj.f_cmd.value = SEARCH08;
			}else{
				formObj.f_cmd.value = SEARCH09;
			}

			if(document.search_fm_yard.Code != '' && formObj.search_fm_loc.value != '')
			{
				formObj.TRSP_SO_FM_NODE.value = formObj.search_fm_loc.value+document.search_fm_yard.Code;
			}else{
				formObj.TRSP_SO_FM_NODE.value = '';
			}

			if(document.search_to_yard.Code != '' && formObj.search_to_loc.value != '')
			{
				formObj.TRSP_SO_TO_NODE.value = formObj.search_to_loc.value+document.search_to_yard.Code;
			}else{
				formObj.TRSP_SO_TO_NODE.value = '';
			}

			sheetObj.DoSearch4Post("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));

			break;

		case IBSAVE:		//SO Creation, WO Issue

				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');

				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}

			if(trspSoStsCD == 'C'){

				setGateOutDate(sheetObj, checkArray);
				sheetObj.RemoveEtcData();
				
				var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
			
				if(queryStr=='') return false;

				formObj.f_cmd.value = SEARCH03;
				var searchXml = sheetObj.GetSaveXml("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(formObj));
				sheetObj.LoadSearchXml(searchXml, false, -1, true);
				if (getVerifyColumn(sheetObj))
				{
					formObj.f_cmd.value = MODIFY;
					formObj.TRSP_SO_TP_CD.value = 'H';
					formObj.TRSP_SO_STS_CD.value = 'R'; // SO - C, WO - I, CORRECTION - R

					sheetObj.DoSave("ESD_TRS_0014GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
				}
			}else{
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}

				var cty_cd = '';
				var seq_no = '';
				for(var i=0; i<checkArray.length-1; i++)
				{
					if(i!=0){
						cty_cd += ',';
						seq_no += ',';
					}
					cty_cd += sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
					seq_no += sheetObj.CellValue(checkArray[i], 'trsp_so_seq');
				}

				document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
				document.woForm.trsp_so_seq.value = seq_no;
				
				document.woForm.submit();
				return;
			}
			break;			

		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
			break;

		case IBINSERT:      // 입력
			sheetObj.DataInsert();
			break;

		case IBDELETE:
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');

			if(checkList == '' || !confirm(ComGetMsg('COM12165', 'S/O')) )
			{
				ComShowCodeMessage('COM12176');
				return false;
			}		

			for(var i=0; i<checkArray.length-1; i++){
				if(sheetObj.CellValue(checkArray[i],'wo_issue')=='Y')
					{ComShowMessage('W/O needs to be canceled first.');
					return false;
				}
			}

			formObj.f_cmd.value = REMOVELIST;
			sheetObj.DoSave("ESD_TRS_0014GS.do", TrsFrmQryString(formObj), '', false);
			break;	

	}
}
 

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {

	   case IBSEARCH:      //조회
			if(	formObj.form_eq_no.value == '')
				{
					if (formObj.fmdate == '')
					{
						ComShowCodeMessage('COM12114', 'from date');
						formObj.fmdate.focus();
						return false;
					}else if (formObj.todate == '')
					{
						ComShowCodeMessage('COM12114', 'to date');
						formObj.todate.focus();
						return false;
					}
				}
			break;

		case IBSAVE:
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				var fmNode = '';
				var toNode = '';

				for(var k=0; k<checkArray.length-1; k++)
				{
					var row = checkArray[k];
					fmNode = sheetObj.CellValue(row, 'fm_loc_value')+sheetObj.CellValue(row, 'fm_yard_value');
					toNode = sheetObj.CellValue(row, 'to_loc_value')+sheetObj.CellValue(row, 'to_yard_value');
					if(fmNode == toNode)
					{
						ComShowCodeMessage('COM12115', 'From Node and To Node');
						sheetObj.SelectCell(row, 'fm_loc_value');
						return false;
					}
				}

				var sheetObj3 = sheetObjects[2];
				sheetObj3.RemoveAll();
				var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
				
				if(queryStr == '') return false;

				sheetObj3.DoSearch4Post("ESD_TRS_0969.screen", queryStr, '', false);

				var dupRow = sheetObj3.ColValueDup('eq_no|fm_loc_value|fm_yard_value');
				if(dupRow != -1)
				{
					ComShowCodeMessage('COM12115', 'EQ No AND From Node');
					sheetObj.SelectCell(row, 'eq_no');
					return false;
				}
				break;
	}

	return true;
}

/**
 * sheet click시 일어나는 이벤트
 **/
function sheet_OnClick(sheetObj, row, col, value)
{
	if(!sheetObj.CellEditable(row, col)) return;

	if(sheetObj.ReadDataProperty(row, col, 0)==6) 
	{	
		return;
	}
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	var k_h_value = sheetObj.CellValue(row, 'chss_mgst_trsp_tp_cd');

	if(colName == 'fm_loc_value' && k_h_value == 'D'){
		document.form.TRSP_SO_EQ_KIND.value = 'A';
	}else if(colName == 'fm_loc_value' && (k_h_value == 'N' || k_h_value == 'F')){
		document.form.TRSP_SO_EQ_KIND.value = k_h_value;
	}else if(colName == 'to_loc_value' && (k_h_value == 'N')) {
		document.form.TRSP_SO_EQ_KIND.value = 'Y';
	}else if(colName == 'to_loc_value' && (k_h_value == 'D')) {
		document.form.TRSP_SO_EQ_KIND.value = 'A';
	}else if(colName == 'to_loc_value' && k_h_value == 'F') {
		document.form.TRSP_SO_EQ_KIND.value = 'N';
	}

	switch(colName){

		case 'fm_yard_value':
			
			if( sheetObj.cellValue(row, 'fm_loc_value') != '' )
			{
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_loc_value'));
			}
			break;

		case 'to_yard_value':
			
			if( sheetObj.cellValue(row, 'to_loc_value') != '' )
			{
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_loc_value'));
			}
			break;

		case 'eq_no':
			if(sheetObj.CellValue(row,'isimport') == '' ) sheetObj.CellEditable(row,'eq_no') = false;
			else sheetObj.CellEditable(row,'eq_no') = true;
			break;
		
		case 'eq_tpsz_cd':
				if(sheetObj.CellValue(row,'eq_no') == '' ) sheetObj.CellEditable(row,'eq_tpsz_cd') = true;
				else if(sheetObj.CellValue(row,'eq_no') != '')sheetObj.CellEditable(row,'eq_tpsz_cd') = false;
				break;
	}
}

function sheet_OnKeyDown(sheetObj, row, col, keycode, Shift) 
{
	var colName = sheetObj.ColSaveName(col);

	if(colName == 'chss_mgst_trsp_tp_cd' && (keycode == 9 || keycode == 13) && sheetObj.CellValue(row,'isImport') == '' ) sheetObj.CellEditable(row,'eq_no') = false;
	else if(colName == 'chss_mgst_trsp_tp_cd' && (keycode == 9 || keycode == 13) && sheetObj.CellValue(row,'isImport') != '' )sheetObj.CellEditable(row,'eq_no') = true;

	if(colName == 'eq_no' && (keycode == 9 || keycode == 13) && sheetObj.CellValue(row,'eq_no') == '' ) sheetObj.CellEditable(row,'eq_tpsz_cd') = true;
	else if(colName == 'eq_no' && (keycode == 9 || keycode == 13) && sheetObj.CellValue(row,'eq_no') != '')sheetObj.CellEditable(row,'eq_tpsz_cd') = false;


}

/**
 * sheet cell value 변경시 발생하는 이벤트
 **/
function sheet_OnChange(sheetObj, row, col, value){
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;
	var k_h_value = sheetObj.CellValue(row, 'chss_mgst_trsp_tp_cd');

	if(colName == 'fm_loc_value' && k_h_value == 'D'){
		document.form.TRSP_SO_EQ_KIND.value = 'A';
	}else if(colName == 'fm_loc_value' && (k_h_value == 'N' || k_h_value == 'F')){
		document.form.TRSP_SO_EQ_KIND.value = k_h_value;
	}else if(colName == 'to_loc_value' && (k_h_value == 'N')) {
		document.form.TRSP_SO_EQ_KIND.value = 'Y';
	}else if(colName == 'to_loc_value' && (k_h_value == 'D')) {
		document.form.TRSP_SO_EQ_KIND.value = 'A';
	}else if(colName == 'to_loc_value' && k_h_value == 'F') {
		document.form.TRSP_SO_EQ_KIND.value = 'N';
	}

	switch(colName){
		case 'delflag':
		case 'ibcheck':
			toggleCheckBundle(sheetObj, row, col);
			break;

		case 'fm_loc_value':
		case 'to_loc_value':
			if( sheetObj.cellValue(row, colName) != '' )
			{
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
			}
			
			if(formObject.dist_div_cd.value=="G"){ //Grid OnChange Event일때만  Distance를 조회한다.
				distance_cal(sheetObj, row);
			}
			
			break;
			
		case 'fm_yard_value':
		case 'to_yard_value':
			if(formObject.dist_div_cd.value=="G"){ //Grid OnChange Event일때만  Distance를 조회한다.
				distance_cal(sheetObj, row);
			}			
		break;	
			
		case 'chss_mgst_trsp_tp_cd':
		case 'eq_no':

			var sheetObj2 = sheetObjects[1];			
			if(value == '') return;

			sheetObj.CellValue2(row, colName) = '';
/*
			if( sheetObj.FindText('eq_no', value) != -1)
			{
//				sheetObj.CellValue2(row, colName) = value;
				ComShowCodeMessage('COM12115', value);
				return;
			}
*/
			sheetObj.InitCellProperty(row, 'fm_yard_value', dtData);
			sheetObj.InitCellProperty(row, 'to_yard_value', dtData);

			sheetObj.CellValue2(row, colName) = value;
			if(sheetObj.CellValue(row,'eq_knd_cd')=='Z') formObject.f_cmd.value = SEARCH01;
			else formObject.f_cmd.value = SEARCH02;
			
			var queryString = "row=1"+"&eq_no="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
			
			sheetObj2.RemoveAll();
			sheetObj2.DataInsert();
			sheetObj2.DoRowSearch("ESD_TRS_0014GS.do", queryString , false );
			
			if(sheetObj.CellValue(row, 'eq_tpsz_cd') != sheetObj2.CellValue(1, 'eq_tpsz_cd'))
			{
				ComShowCodeMessage('COM12114', 'EQ TYPE CODE');
				return;
			}else{
				sheetObj.CellValue(row, 'vndr_seq')		= sheetObj2.CellValue(1, 'vndr_seq');
				sheetObj.CellValue(row, 'vndr_abbr_nm') = sheetObj2.CellValue(1, 'vndr_abbr_nm');
				sheetObj.CellValue(row, 'lstm_cd')		= sheetObj2.CellValue(1, 'lstm_cd');
				sheetObj.CellValue(row, 'ownr_co_cd')	= sheetObj2.CellValue(1, 'ownr_co_cd');
				sheetObj.CellValue(row, 'usr_co_cd')	= sheetObj2.CellValue(1, 'usr_co_cd');
				sheetObj.CellValue(row, 'mvmt_sts_cd')	= sheetObj2.CellValue(1, 'mvmt_sts_cd');
				sheetObj.CellValue(row, 'lst_sts_yd_cd')= sheetObj2.CellValue(1, 'lst_sts_yd_cd');
				sheetObj.CellValue(row, 'mvmt_dt')		= sheetObj2.CellValue(1, 'mvmt_dt');
			}
			break;
		case 'eq_tpsz_cd':
			sheetObj.RemoveEtcData();
			value = value.toUpperCase();

			if(formObject.kind_chassis[0].checked||document.form.kind_chassis[2].checked){
				formObject.f_cmd.value = SEARCH12;
			}else if(formObject.kind_chassis[1].checked||document.form.kind_chassis[3].checked){
				formObject.f_cmd.value = SEARCH13;
			}

			formObject.EQ_TPSZ_CD.value = value;
			sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObject) , false );

			if(formObject.kind_chassis[0].checked){
				if (sheetObj.EtcData("eq_tpsz_cd") == undefined || sheetObj.EtcData("eq_tpsz_cd") == ''){
					ComShowCodeMessage('COM12114', 'Type size Code');
					sheetObj.CellValue2( row, col) = '';
					return;
				}
			}else if(formObject.kind_chassis[1].checked){
				if (sheetObj.EtcData("eq_tpsz_cd") == undefined || sheetObj.EtcData("eq_tpsz_cd") == ''){
					ComShowCodeMessage('COM12114', 'Type size Code');
					sheetObj.CellValue2( row, col) = '';
					return;
				}
			}

			sheetObj.cellValue2(row, 'eq_tpsz_cd') = value;

			if(!checkEqTypeSizeByBundle(sheetObj)){
				sheetObj.cellValue2(row, 'eq_tpsz_cd') = '';
			}
			break;
		case 'org_gate_out_date':
			if(value != '' && sheetObj.CellValue(row, 'org_gate_out_time')==''){
				sheetObj.CellValue2(row, 'org_gate_out_time') = '000000';
			}else if(value == ''){
				sheetObj.CellValue2(row, 'org_gate_out_time') = '';
			}
			break;
		case 'dest_gate_in_date':
			if(value != '' && sheetObj.CellValue(row, 'dest_gate_in_time')==''){
				sheetObj.CellValue2(row, 'dest_gate_in_time') = '000000';
			}else if(value == ''){
				sheetObj.CellValue2(row, 'dest_gate_in_time') = '';
			}
			break;
	}
}

/**
 * 외부 콤보박스의 리스트 가져오기
 **/
function getComboList(obj)
{
	var yard_obj = null;
	var formObj = document.form;

	obj.value = obj.value.toUpperCase();
	if(obj.name == 'search_fm_loc'){
		yard_obj = document.search_fm_yard;
		if(formObj.trs_tp_cd.value == 'ALL' || formObj.trs_tp_cd.value == 'D'){
			formObj.TRSP_SO_EQ_KIND.value = 'A';
		}else{
			formObj.TRSP_SO_EQ_KIND.value = formObj.trs_tp_cd.value;
		}
	}else if(obj.name == 'search_to_loc'){
		yard_obj = document.search_to_yard;
		if(formObj.trs_tp_cd.value == 'ALL' || formObj.trs_tp_cd.value == 'D'){
			formObj.TRSP_SO_EQ_KIND.value = 'A';
		}else if(formObj.trs_tp_cd.value == 'N'){
			formObj.TRSP_SO_EQ_KIND.value = 'Y'
		}else if(formObj.trs_tp_cd.value == 'F'){
			formObj.TRSP_SO_EQ_KIND.value = 'N'
		}
	}
	var locValue = obj.value;
	if(ComTrim(locValue) == ''){
		yard_obj.RemoveAll();
		return;
	}
	getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'search_fm_loc':
			case 'search_to_loc':
				getComboList(obj);
				break;
		}
	}
}

/**
* 공통 Node popup
*/
function openHireYardPopup( btn_obj )
{
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_061_1";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var returnFunction = 'setFmNode';
	if(btn_obj == 'to_node') returnFunction = 'setToNode';

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 430, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * popSearchPiCommCodeGrid 프로세스 처리
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;

	if(myWin != null) myWin.close();
	url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}

/**
* fmNode를 팝업을 통해 세팅
*/
function setFmNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_fm_loc.value = loc;
	getComboList(document.form.search_fm_loc);
	document.search_fm_yard.CODE = yard;
}

/**
* fmNode를 팝업을 통해 세팅
*/
function setToNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.search_to_loc.value = loc;
	getComboList(document.form.search_to_loc);
	document.search_to_yard.CODE = yard;
}

/**
 * 체크박스 클릭시 번들끼리 묶어주기
 **/
function toggleCheckBundle(sheetObj, row, col)
{
	var value = sheetObj.cellValue(row, col);
	var bundle_seq = sheetObj.cellValue(row, 'trsp_so_cmb_seq');
	if(bundle_seq == '') return;

	for(var i=row-1; i>=1; i--)
	{
		if(bundle_seq == sheetObj.cellValue(i, 'trsp_so_cmb_seq'))
		{
			sheetObj.cellValue2(i, col) = value;
		}else{
			break;
		}
	}

	for(var i=row+1; i<=sheetObj.RowCount; i++)
	{
		if(bundle_seq == sheetObj.cellValue(i, 'trsp_so_cmb_seq'))
		{
			sheetObj.cellValue2(i, col) = value;
		}else{
			break;
		}
	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == REMOVELIST){
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');

			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}
			ComShowCodeMessage('COM12167', 'S/O');

		}else if(formObj.f_cmd.value == MODIFY){
			ComShowCodeMessage('COM12116', 'S/O Correction');
		}
	}
}


/**
 * bundle 풀기
 **/
function unBundle(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');

	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}

	for(var k=0; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		var bundle_seq = sheetObj.CellValue(row, 'trsp_so_cmb_seq');
		if(bundle_seq != ''){ 
			sheetObj.CellValue2(row, 'trsp_so_cmb_seq') = '';
			sheetObj.CellValue2(row, 'trsp_so_cmb_tp_cd') = '';
			sheetObj.CellValue2(row, 'trsp_so_cmb_tp_nm') = '';
			sheetObj.CellBackColor(row, 'trsp_so_cmb_seq') = 15723503;
		}
	}
}

/**
 * sheet에 있는 item을 bundling 하기
 **/
function itemBundling(sheetObj)
{
	var formObj = document.form;
	if(!checkEqTypeSize(sheetObj)) return;

	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');

	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}

	var unit = formObj.bundle_unit.value;
	var checkLength = checkArray.length-1;

	if(checkLength<unit)
	{
		ComShowCodeMessage('TRS90125');
		return;
	}

	unBundle(sheetObj);

	var share = Math.floor(Number(checkLength) / Number(unit));

	cnt = 0;
	for(var i=0; i<share; i++)
	{
		var seq = getSeqNo();
		for(var j=0; j<unit; j++)
		{
			sheetObj.CellBackColor(checkArray[cnt], 'trsp_so_cmb_seq') = 15723503;
			sheetObj.cellValue2(checkArray[cnt], 'trsp_so_cmb_tp_cd') = formObj.bundle_kind.value;
			var listn = formObj.bundle_kind.selectedIndex;
			sheetObj.cellValue2(checkArray[cnt], 'trsp_so_cmb_tp_nm') = formObj.bundle_kind.options[listn].text;

			sheetObj.cellValue2(checkArray[cnt++], 'trsp_so_cmb_seq') = seq;
		}
	}

	for(var i=cnt; i<checkLength; i++){
		sheetObj.CellBackColor(checkArray[i], 'trsp_so_cmb_seq') = sheetObj.RgbColor(238,255,226);
	}

	cnt=1;
	for(var i=0; i< share*unit; i++)
	{
		if(cnt != checkArray[i]){
			sheetObj.DataMove(cnt++, checkArray[i]);
		}else{
			cnt++;
		}
	}
}


/**
 * check된 리스트중에 eq type size가 중복된것이 있는지 확인한다. 
 **/
function checkEqTypeSize(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var src_type_size = '';

	for(var k=1; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		if(sheetObj.cellValue(checkArray[0], 'eq_tpsz_cd') != sheetObj.cellValue(row, 'eq_tpsz_cd'))
		{
			ComShowCodeMessage('COM12114', 'EQ Type Size');
			return false;
		}

	}
	return true;
}

/**
 * Bundle seq no 반환
 **/
function getSeqNo()
{

	if(seqNo == 0)
	{
		var sheetObj = sheetObjects[0];
		var max = 0;
		for(var k=1; k<sheetObj.RowCount+1; k++)
		{
			max = Math.max(Number(sheetObj.CellValue(k, 'trsp_so_cmb_seq')), Number(max))
		}
		seqNo = max+1;
	}

	return seqNo++;
}

/**
* MULTIAPPLY 팝업창
*/
function popMultiApply(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}

	var myOption = "width=500,height=220,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0015.screen';
	myWin = window.open(url, "popMultiApply", myOption);
}

/**
* MULTIAPPLY 팝업창에서 APPLY를 눌러서 적용하기
*/
function setPopupValue(fm_loc, fm_yd, to_loc, to_yd, trans_md, remark, popObj)
{
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	for(var k=0; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		
		if(ComTrim(fm_loc) != '') sheetObj.cellValue2(row, 'fm_loc_value') = fm_loc;
		if(ComTrim(fm_yd) != '') {
			sheetObj.InitCellProperty(row, 'fm_yard_value', dtData);
			sheetObj.cellValue2(row, 'fm_yard_value') = fm_yd;
		}
		if(ComTrim(to_loc) != '') sheetObj.cellValue2(row, 'to_loc_value') = to_loc;
		if(ComTrim(to_yd) != '') {
			sheetObj.InitCellProperty(row, 'to_yard_value', dtData);
			sheetObj.cellValue2(row, 'to_yard_value') = to_yd;
		}
		if(ComTrim(trans_md) != '') sheetObj.cellValue2(row, 'trsp_crr_mod_cd') = trans_md;
		if(ComTrim(remark) != '') sheetObj.cellValue2(row, 'inter_rmk') = remark;
		
		formObj.dist_div_cd.value = "F";
		distance_cal(sheetObj, row);
		formObj.dist_div_cd.value = "G";
	}
	popObj.close();
}

/**
* file import window 호출
*/
function popEqFileImport(sheetObject, formObject)
{
//	var myOption = "width=500,height=360,menubar=0,status=0,scrollbars=0,resizable=0";
//	var url = 'ESD_TRS_0911.screen';
//	myWin = window.open(url, "popEqFileImport", myOption);
//	myWin.focus();
	
	var myOption = "dialogWidth:500px; dialogHeight:380px; help:no; status:no; resizable:no; scroll=no; ";
	window.showModalDialog("ESD_TRS_0911.screen", window, myOption);
}

/**
* import popup 에서 호출하여 data를 sheet에 비교하여 채운다.
*/
function importEqNo(popSheetObj, obj)
{
	var sheetObj = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var checkList = popSheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var row = 0;
	var value = '';
/*	10.27 스펙 변경에 따라 중복체크 삭제
	for(var k=checkArray.length-2; k>=0; k--)
	{
		row = checkArray[k];
		value = popSheetObj.CellValue(row, 'eq_no');
		
		if( sheetObj.FindText('eq_no', value) != -1)
		{
			popSheetObj.RowDelete(row, false);
		}
	}
*/
	if(document.form.kind_chassis[0].checked||document.form.kind_chassis[2].checked)
	{
		document.form.f_cmd.value = SEARCH06;
	}else{
		document.form.f_cmd.value = SEARCH07;
	}

	var queryStr = popSheetObj.GetSaveString(false, false, "ibcheck");
	if(queryStr==''){
		obj.close();
		return false;
	}

	sheetObj2.DoSearch4Post("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(document.form), '', false);

	// eq_no가 비어있는 row를 array로 담는다.
	var emptyEqArray = new Array();
	var cnt=0;

	for(var k=1; k<sheetObj.RowCount+1; k++)
	{
		if(sheetObj.CellValue(k, 'eq_no')=='') emptyEqArray[cnt++] = k;
	}

	cnt=0; // insert된 data의 갯수를 센다.
	var tempEqNo = '';

	for(var i=1; i<sheetObj2.RowCount+1; i++)
	{
		for(var k=0; k<emptyEqArray.length;k++)
		{
			if(emptyEqArray[k] != -1)	// 이미 채워진 row는 검사하지 않는다.
			{
				if(sheetObj.CellValue(emptyEqArray[k], 'eq_tpsz_cd') == sheetObj2.CellValue(i, 'eq_tpsz_cd'))
				{
					sheetObj.CellValue2(emptyEqArray[k], 'eq_no')			= sheetObj2.CellValue(i, 'eq_no');
					sheetObj.CellValue2(emptyEqArray[k], 'vndr_seq')		= sheetObj2.CellValue(i, 'vndr_seq');
					sheetObj.CellValue2(emptyEqArray[k], 'vndr_abbr_nm')	= sheetObj2.CellValue(i, 'vndr_abbr_nm');
					sheetObj.CellValue2(emptyEqArray[k], 'lstm_cd')			= sheetObj2.CellValue(i, 'lstm_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'ownr_co_cd')		= sheetObj2.CellValue(i, 'ownr_co_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'usr_co_cd')		= sheetObj2.CellValue(i, 'usr_co_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'mvmt_sts_cd')		= sheetObj2.CellValue(i, 'mvmt_sts_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'lst_sts_yd_cd')	= sheetObj2.CellValue(i, 'lst_sts_yd_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'mvmt_dt')			= sheetObj2.CellValue(i, 'mvmt_dt');					
					emptyEqArray[k] = -1;	// 채워진 row는 -1로 세팅
					cnt++;	// row를 채운 갯수 카운트
					break;
				}
			}
		}
		if(cnt == emptyEqArray.length) break; // import할 data가 empty보다 많을경우 모두 채우면 종료
	}
	obj.close();
}

/**
* 조회조건 reset
*/
function resetForm(formObj)
{
	formObj.kind_chassis[0].checked = true;
	formObj.trs_tp_cd.options[0].selected = true;
	formObj.fmdate.value=today;
	formObj.todate.value=beforeOneMonth;
	formObj.trs_md_cd.options[0].selected = true;
	formObj.search_fm_loc.value = '';
	document.search_fm_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	document.search_to_yard.RemoveAll();
	formObj.form_eq_no.value = '';
}

/**
 * S/O Creation시 2주이내에 create됐는지 여부 확인
 */
function getVerifyColumn(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var returnFlag = true;

	if(checkList == '')
	{
		ComShowCodeMessage('COM12176');
		return false;
	}

	for(var k=0; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		var eq_no = sheetObj.CellValue(row, 'eq_no');

		if(sheetObj.CellValue(row,'isimport')=='T' && sheetObj.EtcData(eq_no) != '' &&  sheetObj.EtcData(eq_no) != undefined)
		{
			sheetObj.CellValue2(row, 'ibcheck') = false;
			sheetObj.CellValue2(row, 'verify_result') = sheetObj.EtcData(eq_no);
			sheetObj.RowBackColor(row) = sheetObj.RgbColor(238,255,226);
			returnFlag = false;
		}
	}

	return returnFlag;
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
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 320, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, x1) {
	var formObject = document.form;
	if(x1 == 'btn_eq_no')
		formObject.form_eq_no.value = rowArray;
}


function getCalendar(){
 var cal2 = new ComCalendarFromTo();
 cal2.displayType = "date";
 cal2.select(document.form.fmdate, 'fmdate',document.form.todate, 'todate', 'yyyyMMdd');
}

//'포커스주기
function fun_Focus(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

function removeBar(str) {
    var value = "";
    for ( var i = 0; i < str.length; i++ ) {
    var ch = str.charAt(i);
    if ( ch != '-' ) value = value + ch;
    }
    return value;
 }

function setGateOutDate(sheetObj, checkArray){

	var row = 0;
	for(var i=0; i<checkArray.length-1; i++){
		row = checkArray[i];
		if(sheetObj.CellValue(row, 'org_gate_out_date') == '') {
			sheetObj.CellValue2(row, 'org_gate_out_dt') = '';
		}else{
			if(sheetObj.CellValue(row, 'org_gate_out_time') == '') {
				sheetObj.CellValue2(row, 'org_gate_out_time') = '000000';
			}
			sheetObj.CellValue2(row, 'org_gate_out_dt') = 
					sheetObj.CellValue(row, 'org_gate_out_date')
				+	sheetObj.CellValue(row, 'org_gate_out_time');
		}

		if(sheetObj.CellValue(row, 'dest_gate_in_date') == '') {
			sheetObj.CellValue2(row, 'dest_gate_in_dt') = '';
		}else{
			if(sheetObj.CellValue(row, 'dest_gate_in_time') == '') {
				sheetObj.CellValue2(row, 'dest_gate_in_time') = '000000';
			}
			sheetObj.CellValue2(row, 'dest_gate_in_dt') = 
					sheetObj.CellValue(row, 'dest_gate_in_date')
				+	sheetObj.CellValue(row, 'dest_gate_in_time');
		}
	}
}

/**
* 2012.06.05 신동일 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project
* PRD의 데이터를 조회하여 Distance를  계산한다. 
*/
function  distance_cal(sheetObj, row) {

	var fm_nod_cd	= sheetObj.CellValue(row, "fm_loc_value")
	var fm_nod_yard = sheetObj.CellValue(row, "fm_yard_value");
	var to_nod_cd	= sheetObj.CellValue(row, "to_loc_value");
	var to_nod_yard = sheetObj.CellValue(row, "to_yard_value");
	var dor_nod_cd = "";
	var dor_nod_yard = "";
	var via_nod_cd = "";
	var via_nod_yard = "";
	var trsp_bnd_cd = "";
	var trsp_crr_mod_cd = sheetObj.CellValue(row, "trsp_crr_mod_cd");
	var trsp_cost_dtl_mod_cd = "CY";
	
 	var queryString ="f_cmd="+SEARCH22
		            +"&fm_nod_cd="+fm_nod_cd
		            +"&fm_nod_yard="+fm_nod_yard
		            +"&to_nod_cd="+to_nod_cd
		            +"&to_nod_yard="+to_nod_yard
		            +"&dor_nod_cd="+dor_nod_cd
		            +"&dor_nod_yard="+ dor_nod_yard
		            +"&via_nod_cd="+via_nod_cd
		            +"&via_nod_yard="+ via_nod_yard
		            +"&trsp_bnd_cd="+ trsp_bnd_cd
		            +"&trsp_crr_mod_cd="+trsp_crr_mod_cd
		            +"&trsp_cost_dtl_mod_cd="+trsp_cost_dtl_mod_cd
		            ;
 	// sheetObj.GetSearchXml("ESD_TRS_0002GS.do", queryString);
 	sheetObj.DoRowSearch("ESD_TRS_0002GS.do", queryString);
 	 
	sheetObj.CellValue2(row, "ttl_dist") = sheetObj.EtcData("ttl_dist");
	sheetObj.CellValue2(row, "lnk_dist_div_cd") = sheetObj.EtcData("lnk_dist_div_cd");
	
	sheetObj.RemoveEtcData();
	 	
}

