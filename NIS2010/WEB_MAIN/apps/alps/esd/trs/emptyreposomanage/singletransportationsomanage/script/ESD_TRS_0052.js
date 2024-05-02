/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0052.js
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.05
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2006.10.27 kim_sang_geun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.03.15 최 선   1.1 [CHM-201109283] [TRS] ALPS의 Location 조회불가건 수정 보완 요청
* 2011.04.05 최 선   1.2 [CHM-201109877] [TRS] Empty S/O 발행 시 node 가 동일한 경우에 대한 로직 확인 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0052 : Booking 
 */
function ESD_TRS_0052() {
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
 
/* 공통전역변수 */
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var R = 0;
var G = 255;
var B = 0;

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
		with (tabObj) {
			var cnt  = 0 ;
			InsertTab( cnt++, "   Correction Candidates   " , -1 );
			InsertTab( cnt++, "Combined CNTR Trans. Case Ⅰ" , -1 );
		}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem) {
	var objs = document.all.item("tabLayer");
	
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
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
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
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
    //Axon 
//            axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//            axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//            axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//            axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//            axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//            axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
//            axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
}


//Axon --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {

//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation manual <br>
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
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){

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
				style.height = GetSheetHeight(10); // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(33, 0, 0, true);
				InitHeadMode(true, true, true, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle = "||Reference No|Kind|CNTR No|CNTR\nTP/SZ|From\nNode|To\nNode|CB\nSEQ|Trans.\nMode|Distance(Km)|Purpose|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Bid|Bid No|Bid Due Date|Verify Result|Internal Remark|Remark\n(Special Instruction)";
				InitHeadRow(0, HeadTitle, true); //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter, 	true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, 	true, "ibflag", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		   150, daCenter, 	true, "ref_id", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		    80, daCenter,   true, "trsp_cost_dtl_mod_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			90, daCenter, 	true, "eq_no", 					false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	true, "eq_tpsz_cd", 			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			80, daCenter, 	true, "fm_nod_cd", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			80, daCenter, 	true, "to_nod_cd", 				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	true, "trsp_so_cmb_seq", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	true, "trsp_crr_mod_cd", 		false, "", dfNone, 0, false, false);
				
				//2012.06.12 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData, 	90,  daRight, true, "ttl_dist", 		false, "", dfInteger, 	0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 	80, daCenter, true, "repo_purp_rmk", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 	60, daCenter, true, "lessor", 			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80, daCenter, true, "lstm_cd", 			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80, daCenter, true, "ownr_co_cd", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80, daCenter, true, "eq_used", 			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80, daCenter, true, "movement_sts", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 	90, daCenter, true, "creation_yard", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80, daCenter, true, "event_date", 		false, "", dfDateYmd, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 	30, daCenter, true, "spot_bid_flg", 			false, "", dfNone, 1, false,  false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "spot_bid_no", 				false, "", dfNone, 1, false,  false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "spot_bid_due_dt", 			false, "", dfNone, 1, false, false);
				
				InitDataProperty(0, cnt++, dtData, 		100, daCenter, true, "verify_result", 		false, "", dfNone, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtData,		150, daCenter, true, "inter_rmk", 			false, "", dfNone, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtData,		150, daCenter, true, "spcl_instr_rmk", 		false, "", dfNone, 0, true, true, 255);
				
				InitDataProperty(0, cnt++, dtHidden,	50, daCenter, true, "trsp_so_ofc_cty_cd", 	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,	10, daCenter, true, "trsp_so_seq", 			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 	10, daCenter, true, "cre_usr_id", 			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 	10, daCenter, true, "upd_usr_id", 			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 	80, daCenter, true, "repo_pln_id",			false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 	80, daCenter, true, "pln_yrwk",				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 	90, daCenter, true, "ref_seq",				false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 	30, daCenter, true, "so_cre_yn", 			false, "", dfNone, 0, false, false);     // verify 결과.  Y: SO 생성불가 , N:생성가능 

    ActionMenu = "Check Selected|Uncheck Selected|-|Check All"
    MultiSelection = true;
//    SelectionMode = smSelectionRow;

			}
		break;
		case 2:      //sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(10); // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(34, 0, 0, true);
				InitHeadMode(true, true, true, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle = "||Reference No|Kind|CNTR No|CNTR\nTP/SZ|From\nNode|To\nNode|CB\nSEQ|Trans.\nMode|Distance(Km)|Purpose|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Verify Result|Internal Remark|Remark\n(Special Instruction)";
				InitHeadRow(0, HeadTitle, true); //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,   40,   daCenter,  true,    "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag",  false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "ref_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "trsp_cost_dtl_mod_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "eq_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "trsp_so_cmb_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "trsp_crr_mod_cd", false, "", dfNone, 0, false, false);
				
				//2012.06.12 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData, 90, 	daRight,  true, "ttl_dist", false, 	"", dfInteger, 	0, false, false);				
				
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "repo_purp_rmk", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "lessor", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lstm_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "ownr_co_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "eq_used", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "movement_sts", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "creation_yard", false, "", dfNone, 0, false, false);
				
				
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "event_date", false, "", dfDateYmd, 0, false, false);
				

				
				InitDataProperty(0, cnt++, dtData,100, daCenter, true, "verify_result", false, "", dfNone, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtData,150, daCenter, true, "inter_rmk", false, "", dfNone, 0, false, false, 255);
				InitDataProperty(0, cnt++, dtData,150, daCenter, true, "spcl_instr_rmk", false, "", dfNone, 0, false, false, 255);
				
				InitDataProperty(0, cnt++, dtHidden,50, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,10, daCenter, true, "trsp_so_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, "cre_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "repo_pln_id",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "pln_yrwk",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "ref_seq",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "so_cre_yn", false, "", dfNone, 0, false, false);     // verify 결과.  Y: SO 생성불가 , N:생성가능 

				EditableColorDiff = false; //배경 색을 유지한다. false일 경우만.
			}
		break;
		case 3: //sheet 2 init
			with (sheetObj) {		
				style.height = 0; // 높이 설정
				SheetWidth = 0; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = false; //전체Edit 허용 여부 [선택, Default false]
				InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(2, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle0 = "Office Code|Seqence";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "trsp_so_seq", false, "", dfNone, 1, false, false);
			}
		break;

		case 4:      //sheet1 init
			with (sheetObj) {
			    //style.height = GetSheetHeight(10); // 높이 설정
				style.height = 0; // 높이 설정 
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
				InitColumnInfo(13, 5, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "SEP|EQ_NO|VERIFY_RESULT|VERIFY_YN" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				InitDataProperty(0, cnt++, dtData,60, daCenter, true, "sep", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,100, daCenter, true, "eq_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,20, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,600, daCenter, true, "verify_result", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,90,  daCenter, true, "verify_yn", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lessor", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "lstm_cd",  false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "ownr_co_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "eq_used", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "movement_sts", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "creation_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "event_date", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "offh_yd_cd", false, "", dfNone, 0, false, false);
			}
		break;	
	

	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve": //조회
				if( validateFormSearch(formObject) ) {
					tabObjects[0].SelectedIndex = 0; //tab 이동
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
					sheetObject1.RemoveAll(); //Combined CNTR Trans. Case1의 쉬트 내용을 제거
				}
			break;
			case "btn_reset": //reset
				tabObjects[0].SelectedIndex = 0; //tab 이동
				formObject.reset();
				formObject.frm_yard.RemoveAll(); // combo 데이터삭제
				formObject.to_yard.RemoveAll(); // combo 데이터삭제
			break;
			case "btn_minimize": //Minimize
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;
			case "btns_calendar": //달력
				getCalendar();
			break;
			case "btng_downexcel1": //sheet1 엑셀다운로드
				sheetObject.SpeedDown2Excel(true);
			break;
			case "btng_downexcel2": //sheet2 엑셀다운로드
				sheetObject1.SpeedDown2Excel(true);
			break;
			case "btng_matchmaking1": //Combined CNTR Trans. Case One
				if( validationCheck(sheetObject) ) {
					if(	doDataEquals(sheetObject) ) {
					IBS_Sheet2SheetStatus2(sheetObject, sheetObject1, "chk1");
					}
				}
			break;
			case "btng_socreation1": //sheet1 S/O Creation
				var sRow = sheetObject.FindCheckedRow("chk1");
				var arrRow = sRow.split("|");
				for( var i=0; i<arrRow.length-1; i++ ) {
					if (sheetObject.CellValue(arrRow[i], "fm_nod_cd") == sheetObject.CellValue(arrRow[i], "to_nod_cd")) {
						errMsg = ComGetMsg("TRS90053");
						ComShowMessage( arrRow[i] + " Rows " + errMsg);
					}
				}
				if( validationCheck(sheetObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSAVE, "");
				}
			break;
			case "btng_socreation2": //Combined Case 2인경우 Correction
				if( sheetObject1.RowCount("U") < 1 ) {
					errMsg = ComGetMsg("TRS90036");
					ComShowMessage(errMsg);
				} else {
					doActionIBSheet(sheetObject1, formObject, IBSAVE, "CF");
				}
			break;
			case "btng_woissue1": //sheet1 W/O Issue
				doActionIBSheet(sheetObject2, formObject, IBSAVE, "WO");
			break;
			case "btng_woissue2": //sheet1 W/O Issue
				doActionIBSheet(sheetObject2, formObject, IBSAVE, "WO");
			break;
			case "btng_separate0": //Combined한 데이터를 해제 시킨다. Single에서
				doActionIBSheet(sheetObject, formObject, IBSAVE, "SP");
			break;
			case "btng_separate1": //Combined CNTR Trans. Case One 취소
				if(	doDataEquals(sheetObject1) ) {
					IBS_Sheet2SheetStatus3(sheetObject1, sheetObject, "chk1");
				}

			break;
			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;
			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;
			case "btns_multicntr": //M CNTR
				openMultipleinquiry2(srcName,'CNT');
			break;
			case "btns_multirefno": //M Reference No
				openMultipleinquiry('RFN', 'Reference No');
			break;
			case "btng_fillincontainers": //Container Select PopUp
				if( contatnerValidation(sheetObject, formObject, "chk1") ) {
					popEqFileImport(sheetObject, formObject);
				}
			break;
			case "btng_sodelete": //S/O Delete
				if( sheetObject.RowCount("U") < 1 ) {
					errMsg = ComGetMsg("TRS90036");
					ComShowMessage(errMsg);
				} else {
					doActionIBSheet(sheetObject, formObject, IBDELETE, "SO");
				}
			break;

			case "btng_verify":
				if( searchVerify(sheetObject, formObject, "chk1") ) {
					doActionIBSheet(sheetObject3, formObject, IBSEARCH, "VY");
				}
			break;

		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

// Enter Key시 지연대리 요청 20070115
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var formObject = document.form;

		if( validateFormSearch(formObject) ) {
			tabObjects[0].SelectedIndex = 0; //tab 이동
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "");
			sheetObject1.RemoveAll(); //Combined CNTR Trans. Case1의 쉬트 내용을 제거
		}
	}
}

/**
* file import window 호출
*/
function popEqFileImport(sheetObject, formObject) {
	ComOpenWindow('ESD_TRS_0951.screen', 'ESD_TRS_0951', 'top=200, left=200, width=395, height=370, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
}

/**
 * 화면 검색 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateFormSearch(formObj) {
	if( sheetObjects[1].RowCount > 0 ) {
		errMsg = ComGetMsg("TRS90130");
		if( confirm(errMsg) ) {
		} else {
			return false;
		}
	}
	var lvFrmDate = doSepRemove(doSepRemove(formObj.frm_reqdate.value, " "), "-");
	var lvToDate = doSepRemove(doSepRemove(formObj.to_reqdate.value, " "), "-");

	var lvFrm_node     = doSepRemove(formObj.frm_node.value,     " ");
	var lvTo_node      = doSepRemove(formObj.to_node.value,      " ");
	var lvCntr_no      = doSepRemove(formObj.cntr_no.value,      " ");
	var lvReference_no = doSepRemove(formObj.reference_no.value, " ");
	var lvspot_bid_no  = doSepRemove(formObj.spot_bid_no.value, " ");
	
	if( lvFrmDate == "" ) //from date
		formObj.frm_reqdate.value = "";
	if( lvToDate == "" ) //to date
		formObj.to_reqdate.value = "";
	if( lvFrmDate == "" && lvToDate != "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) { //날짜 체크하는 부분
		if( !doDatecheck(lvFrmDate) ) {
			errMsg = ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_reqdate.focus();
			return false;
		} else if( !doDatecheck(lvToDate) ) {
			errMsg = ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
			formObj.to_reqdate.focus();
			return false;
		}
		if( dateCalcuration(lvFrmDate, lvToDate) > 14 ) {
			errMsg = ComGetMsg("TRS90120");
			ComShowMessage(errMsg);
			return false;
		} else if( dateCalcuration(lvFrmDate, lvToDate) < 0 ) {
			errMsg = ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
		}
	} else {
		if( lvReference_no == "" && lvCntr_no == "" && lvspot_bid_no == "") {
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
	}
	if( lvFrm_node == "" ) { //From Node
		formObj.frm_node.value = "";
		formObj.frm_yard.RemoveAll(); // combo 데이터삭제
	}
	if( lvTo_node == "" ) { //To Node
		formObj.to_node.value = "";
		formObj.to_yard.RemoveAll(); // combo 데이터삭제
	}
	if( !doengnumcheck(lvCntr_no) ) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}
	if( !doengnumcheck(lvReference_no) ) {
		formObj.reference_no.value = "";
		formObj.reference_no.focus();
		return false;
	}
	
	if( !doengnumcheck(lvspot_bid_no) ) {
		formObj.spot_bid_no.value = "";
		formObj.spot_bid_no.focus();
		return false;
	}
	formObj.hid_frmreqdate.value = lvFrmDate; //from Date
	formObj.hid_toreqdate.value = lvToDate; //to Date

	formObj.frm_node.value = lvFrm_node.toUpperCase();
	formObj.to_node.value = lvTo_node.toUpperCase();

	formObj.cntr_no.value = lvCntr_no.toUpperCase(); //CNTR No
	formObj.reference_no.value = lvReference_no.toUpperCase(); //Reference No
	return true;
}

/* Sheet관련 프로세스 처리 */ 
function doActionIBSheet(sheetObj,formObj,sAction,sObj) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			if( sObj == "RE" ) {
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch4Post("ESD_TRS_0052GS.do", TrsFrmQryString(formObj));
			} else if( sObj == "EQ" ) { //CNTR No Verify
				formObj.f_cmd.value = SEARCH04;
				sheetObj.DoSearch4Post("ESD_TRS_0052GS.do", TrsFrmQryString(formObj));
			} else if( sObj == "VY" ) { //Verify
				formObj.f_cmd.value = SEARCH05;
				sheetObj.DoSearch4Post("ESD_TRS_0052GS.do", TrsFrmQryString(formObj));
			}

		break;

		case IBSAVE:
			if( sObj == "" || sObj == "CF" ) {
				formObj.f_cmd.value = MODIFY;
				formObj.cbstatus.value = sObj;
				sheetObj.DoSave("ESD_TRS_0052GS.do", TrsFrmQryString(formObj), "chk1", false, true);
			} else if( sObj == "WO" ) {
				if( sheetObjects[1].RowCount > 0 ) {
					errMsg = ComGetMsg("TRS90130");
					if( confirm(errMsg) ) {
					} else {
						return false;
					}
				}
				var cty_cd = "";
				var seq_no = "";
				for(var i=1; i<sheetObj.RowCount+1; i++) {
					if( i == sheetObj.RowCount ) {
						cty_cd += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd');
						seq_no += sheetObj.CellValue(i, 'trsp_so_seq');
					} else {
						cty_cd += sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd') + ",";
						seq_no += sheetObj.CellValue(i, 'trsp_so_seq') + ",";					
					}
				}
				document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
				document.woForm.trsp_so_seq.value = seq_no;
				document.woForm.eq_mode.value = "CG";
				document.woForm.pgmNo.value="ESD_TRS_0023"
				document.woForm.action = "ESD_TRS_0023.screen";
				document.woForm.submit();
			} else if( sObj == "SP" ) {
				if( sheetObj.RowCount("U") < 1 ) {
					errMsg = ComGetMsg("TRS90036");
					ComShowMessage(errMsg);
					return false;
				} else {
					formObj.f_cmd.value = MODIFY01;
					formObj.cbstatus.value = "";
					sheetObj.DoSave("ESD_TRS_0052GS.do", TrsFrmQryString(formObj), "chk1", false, true);
				}
			}
		break;
		
		case IBDELETE:
			formObj.f_cmd.value = REMOVE;
			formObj.cbstatus.value = sObj;
			sheetObj.DoSave("ESD_TRS_0052GS.do", TrsFrmQryString(formObj), -1, false, true);
		break;
	}
}

/*
 * Single에서 Separate로 기존의 combined 데이터를 해제 시킴.
 *
 */
function doSeparateRemove(sheetObj) {
	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		if( sheetObj.CellValue(fromRow, "trsp_so_cmb_seq").length > 0 ) {
			sheetObj.CellValue2(fromRow, "trsp_so_cmb_seq") = "";
			sheetObj.CellEditable(fromRow, "inter_rmk") = true;
			sheetObj.CellEditable(fromRow, "spcl_instr_rmk") = true;
		}
	}
}

/*
 * CB Seq에 대한 체크 로직
 */
function validationCheck(sheetObj) {
	if( sheetObj.RowCount("U") < 1 || sheetObj.FindCheckedRow("chk1")=="" ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		if( sheetObj.CellValue(fromRow, "trsp_so_cmb_seq").length > 0 ) {
			errMsg = ComGetMsg("TRS90062");
			ComShowMessage(errMsg);
			return false;
		}
	}

	var doc_eq_no = "";
	var bverifychk = false;

	for( var i=0; i<arrRow.length-1; i++ ) {
		doc_eq_no = doSepRemove(sheetObj.CellValue(arrRow[i], "eq_no"), " ");
		if( sheetObj.CellValue(arrRow[i], "so_cre_yn") != "Y" && sheetObj.CellValue(arrRow[i], "eq_no") != "" 
			&& sheetObj.CellEditable( arrRow[i] ,"eq_no")   ) {  // EQ_NO 가 처음부터 존재하면 Verify 없이 save 가능.
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
			bverifychk = true;

			if( sheetObj.CellValue(arrRow[i], "verify_result") == "" )
			{
			errMsg = ComGetMsg("TRS90360");
			} else {
			errMsg = ComGetMsg("TRS90078");
			}

		
		}
	}

	if( bverifychk ) {
		ComShowMessage(errMsg);
		return false;
	}

	return true;
}

/**
 * Container File import에 대한 유효성검증 프로세스 처리
 */
function contatnerValidation(sheetObj, formObj, sStatus) {
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length - 1; i++ ) {
		if( sheetObj.CellValue(arrRow[i], "eq_no") != "" ) {
			sheetObj.CellValue2(arrRow[i], "chk1") = "0"; //체크한 박스를 체크 해제를 시킨다.
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
		}
	}

	if( sheetObj.RowCount("U") < 1 ) {
		errMsg = ComGetMsg("TRS90051");
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}
 
//tab1의 sheet에 대한 정보
function t1sheet1_OnClick(sheetObj, row , col , value) {
	if( sheetObj.CellValue(row, "trsp_so_cmb_seq").length > 0 ) {
		return false;
	}
	if( sheetObj.ReadDataProperty(row, col, dpDataType) == 6 ) {
		value = sheetObj.CellValue(row, sheetObj.ColSaveName(col-1));
		if( sheetObj.ColSaveName(col).indexOf("yard")>-1 ) {
			getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		}
	}
}

function doSeperationCheck(sheetObj, col, row) {
	if( sheetObj.ColSaveName(col) == "CMC" ) {
		if( sheetObj.CellValue(row, "trsp_so_cmb_seq").length > 0 ) {
			sheetObj.CellValue2(row, "CMC") = "0";
			return false;
		} else {
			return true;
		}
	}
}

var doc_row = 0; //container check..
function t1sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.RowStatus(row) = "U";
			if( sheetObj.CellValue(row, "trsp_so_cmb_seq").length > 0 ) {
				for( var i=1; i<(sheetObj.RowCount+1); i++ ) {
					if( sheetObj.CellValue(row, "trsp_so_cmb_seq") == sheetObj.CellValue(i, "trsp_so_cmb_seq") ) {
						sheetObj.RowStatus(i) = "U";
						sheetObj.CellValue2(i, "chk1") = "1";
					}
				}
			}
		} else {
			sheetObj.RowStatus(row) = "R";
			if( sheetObj.CellValue(row, "trsp_so_cmb_seq").length > 0 ) {
				for( var i=1; i<(sheetObj.RowCount+1); i++ ) {
					if( sheetObj.CellValue(row, "trsp_so_cmb_seq") == sheetObj.CellValue(i, "trsp_so_cmb_seq") ) {
						sheetObj.RowStatus(i) = "R";
						sheetObj.CellValue2(i, "chk1") = "0";
					}
				}
			}
		}
	} else if( sheetObj.ColSaveName(col) == "eq_no" ) {
		var doc_eq_no = sheetObj.CellValue(row, "eq_no");
		if( doc_eq_no.length >= 10 ) {
			doc_row = row;
			document.form.hid_cntr_no.value = doc_eq_no.toUpperCase();
			document.form.hid_cntr_tpsz_cd.value = sheetObj.CellValue(row, "eq_tpsz_cd");
			document.form.frm_node_verify.value =  sheetObj.CellValue(row, "fm_nod_cd");
			doActionIBSheet(sheetObjects[3], document.form, IBSEARCH, "EQ");
		} else {
			sheetObj.CellValue(row, "eq_no") = "";
			sheetObj.CellValue2(row, "lessor") = "";
			sheetObj.CellValue2(row, "lstm_cd") = "";
			sheetObj.CellValue2(row, "ownr_co_cd") = "";
			sheetObj.CellValue2(row, "eq_used") = "";
			sheetObj.CellValue2(row, "movement_sts") = "";
			sheetObj.CellValue2(row, "creation_yard") = "";
			sheetObj.CellValue2(row, "event_date") = "";
		}
	}
}

function t2sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		var lvchk = sheetObj.CellValue(row, "trsp_so_cmb_seq").split("-");
		if ( value == "1") {
			sheetObj.RowStatus(row) = "U";
			if( lvchk[1] == "1" ) {
				sheetObj.RowStatus(row+1) = "U";
				sheetObj.CellValue2(row+1, "chk1") = "1";
			} else if( lvchk[1] == "2" ) {
				sheetObj.RowStatus(row-1) = "U";
				sheetObj.CellValue2(row-1, "chk1") = "1";
			}
		} else {
			sheetObj.RowStatus(row) = "R";
			if( lvchk[1] == "1" ) {
				sheetObj.RowStatus(row+1) = "R";
				sheetObj.CellValue2(row+1, "chk1") = "0";
			} else if( lvchk[1] == "2" ) {
				sheetObj.RowStatus(row-1) = "R";
				sheetObj.CellValue2(row-1, "chk1") = "0";
			}
		}
	}
}

function t3sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		var lvchk = sheetObj.CellValue(row, "trsp_so_cmb_seq").split("-");
		if ( value == "1") {
			sheetObj.RowStatus(row) = "U";
			if( lvchk[1] == "1" ) {
				sheetObj.RowStatus(row+1) = "U";
				sheetObj.CellValue2(row+1, "chk1") = "1";
			} else if( lvchk[1] == "2" ) {
				sheetObj.RowStatus(row-1) = "U";
				sheetObj.CellValue2(row-1, "chk1") = "1";
			}
		} else {
			sheetObj.RowStatus(row) = "R";
			if( lvchk[1] == "1" ) {
				sheetObj.RowStatus(row+1) = "R";
				sheetObj.CellValue2(row+1, "chk1") = "0";
			} else if( lvchk[1] == "2" ) {
				sheetObj.RowStatus(row-1) = "R";
				sheetObj.CellValue2(row-1, "chk1") = "0";
			}
		}
	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/*
 * 업무에 따른 Validation Check / Combined CNTR Trans. Case One과 Single Transportation의 관계 체크
 */
function doDataEquals(sheetObj) { //데이터를 비교하기 위해서 추가함.
	if( sheetObj.RowCount("U") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;

	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		var lvFmnod = doSepRemove(sheetObj.CellValue(fromRow, "fm_nod_cd"), " ");
		var lvTonod = doSepRemove(sheetObj.CellValue(fromRow, "to_nod_cd"), " ");

		if( sheetObj.CellValue(fromRow, "eq_tpsz_cd").indexOf("2") < 0 ) {
			sheetObj.RowStatus(fromRow) = "R"; //false
			sheetObj.CellValue2(fromRow, "chk1") = "0";
			sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
		} else {
			if( lvFmnod == "" || lvTonod == "" ) {
				sheetObj.RowStatus(fromRow) = "R"; //false
				sheetObj.CellValue2(fromRow, "chk1") = "0";
				sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
			}
		}
	}
	return true;
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(15);
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(15);
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(10);
	}
}

/*
 * 팝업창에서 사용하는 Sheet 객체(지우면 안됨)
 */
function getSheetObj() {
	return sheetObjects[0];
}

// From Node1/2,  To Node1/2
function doTimeCheck(of, of2, ot, ot2) {
	if( of == of2 && ot == ot2 ) { //Location 정보를 비교
		return true;
	} else {
		return false;
	}
}

/**
 * 2개 Sheet에서 데이터 이동하기 - 특정 트랜잭션 상태만 이동하기
 * @param : fromSheet - 이동 원본 Sheet의 Object id
 * @param : toSheet   - 이동 대상 Sheet의 Object id
 * @param : sStatus   - 트랜잭션 상태를 "|"로 연결할것, 예) sStatus = "U|D"
 * @return : 없음
 * @version : 2.4.0.0
 * @sample
 *  IBS_Sheet2SheetStatus(mySheet1, mySheet2, "U");
 *  IBS_Sheet2SheetStatus(mySheet1, mySheet2, "U|D");
 */
function IBS_Sheet2SheetStatus2(fromSheet, toSheet, sStatus)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;

//	var sRow = fromSheet.FindStatusRow("U");      // ; 로 구분됨. 
	var sRow = fromSheet.FindCheckedRow("chk1");  // | 로 구분됨.

	var arrRow = sRow.split("|");
	var rowCount = (arrRow.length-1)+toSheet.RowCount;
	var rowXml = "";
	var colOrder = ""; //SaveName Setting
	var iz = 1 + (toSheet.RowCount/2); //combined
	var cb = ""; //combined 앞자리 수
	var cs = 0; //combined 뒷자리 수
	var lvcolor = "";
	var btime = false;

	if( arrRow.length < 3 ) {
		errMsg = ComGetMsg("TRS90131");
		ComShowMessage(errMsg);
		return false;
	}

	for (ic = 0; ic<=fromSheet.LastCol; ic++) {
		colOrder += fromSheet.ColSaveName(ic)+"|";
	}
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"' COLORDER='"+colOrder+"'>";

	var lvFmnod = "";
	var lvTonod = "";
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = 0; ir < arrRow.length-1; ir++) {
		fromRow = arrRow[ir];
		if( fromSheet.CellValue(fromRow, "ibflag") == "U" ) {
			lvFmnod = doSepRemove(fromSheet.CellValue(fromRow, "fm_nod_cd")+fromSheet.CellValue(fromRow, "fm_nod_yard"), " ");
			lvTonod = doSepRemove(fromSheet.CellValue(fromRow, "to_nod_cd")+fromSheet.CellValue(fromRow, "to_nod_yard"), " ");
			for( var z = ir+1; z < arrRow.length-1; z++ ) {
				var lvFmnod2 = doSepRemove(fromSheet.CellValue(arrRow[z], "fm_nod_cd")+fromSheet.CellValue(arrRow[z], "fm_nod_yard"), " ");
				var lvTonod2 = doSepRemove(fromSheet.CellValue(arrRow[z], "to_nod_cd")+fromSheet.CellValue(arrRow[z], "to_nod_yard"), " ");
				btime = doTimeCheck(lvFmnod, lvFmnod2, lvTonod, lvTonod2); //Location 정보 비교
				if( btime ) {
					if( cs == 0 )
						cs = 1;
					else if( cs == 1 )
						cs = 2;
					else if( cs == 2 )
						cs = 1;
					
					if( iz % 2 == 0 ) {
						lvcolor = "220,234,162";
						cb = iz+"-"+cs;
					} else {
						lvcolor = "255,255,255";
						cb = iz+"-"+cs;
					}
					//옮길 데이터를 xml로 구성한다.
					rowXml += "<TR BGCOLOR='"+lvcolor+"'>";
					for (ic = 0; ic<=fromSheet.LastCol; ic++) {
						if( fromSheet.ColSaveName(ic) == "chk1" ) {
							rowXml += "<TD BGCOLOR='"+lvcolor+"'></TD>";
						} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
							rowXml += "<TD BGCOLOR='"+lvcolor+"'></TD>";
						} else if( fromSheet.ColSaveName(ic) == "trsp_so_cmb_seq" ) {
							rowXml += "<TD>"+cb+"</TD>";
						} else {
							rowXml += "<TD>" + fromSheet.CellValue(arrRow[z],ic) + "</TD>";
						}
					}
					rowXml += "</TR>";
					fromSheet.CellValue2(arrRow[z], "chk1") = "1";
					fromSheet.RowStatus(arrRow[z]) = "R";
					break;
				}
			} //for End

			if( btime ) {
				if( cs == 0 )
					cs = 1;
				else if( cs == 1 )
					cs = 2;
				else if( cs == 2 )
					cs = 1;
				
				if( iz % 2 == 0 ) {
					lvcolor = "220,234,162";
					cb = iz+"-"+cs;
				} else {
					lvcolor = "255,255,255";
					cb = iz+"-"+cs;
				}
				//옮길 데이터를 xml로 구성한다.
				rowXml += "<TR BGCOLOR='"+lvcolor+"'>";
				for (ic = 0; ic<=fromSheet.LastCol; ic++) {
					if( fromSheet.ColSaveName(ic) == "chk1" ) {
						rowXml += "<TD BGCOLOR='"+lvcolor+"'></TD>";
					} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
						rowXml += "<TD BGCOLOR='"+lvcolor+"'></TD>";
					} else if( fromSheet.ColSaveName(ic) == "trsp_so_cmb_seq" ) {
						rowXml += "<TD>"+cb+"</TD>";
					} else {
						rowXml += "<TD>" + fromSheet.CellValue(fromRow,ic) + "</TD>";
					}
				}
				rowXml += "</TR>";
				btime = false;
				fromSheet.CellValue2(arrRow[z], "chk1") = "1";
				fromSheet.RowStatus(arrRow[z]) = "R";
				iz++;
			} else {
				fromSheet.CellValue2(fromRow, "chk1") = "0";
				fromSheet.RowStatus(fromRow) = "R";
				fromSheet.RowBackColor(fromRow) = fromSheet.RgbColor(R,G,B);
			}
		}
	} //LAST FOR END
	//원본에서 역순으로 특정 상태의 행을 이동한다.

	var sRow = fromSheet.FindCheckedRow(sStatus);
//	var sRow = fromSheet.FindStatusRow("U");
//	var sRow = fromSheet.FindCheckedRow(sStatus);

	
	var arrRdel = sRow.split("|");
	for (ir = arrRdel.length-2; ir >=0 ; ir--) {
		//원본에서 지움
		fromSheet.RowDelete(arrRdel[ir], false);
	}
	allXml += rowXml;
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);
}

//Combined CNTR Trans. Case One --> Single Transportation(원복시 사용)
function IBS_Sheet2SheetStatus3(fromSheet, toSheet, sStatus)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;

	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	var rowCount = (arrRow.length-1)+toSheet.RowCount;
	var rowXml = "";
	var colOrder = ""; //SaveName Setting

	for (ic = 0; ic<=fromSheet.LastCol; ic++) {
		colOrder += fromSheet.ColSaveName(ic)+"|";
	}
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"' COLORDER='"+colOrder+"'>";

	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = 0; ir < arrRow.length-1; ir++) {
		fromRow = arrRow[ir];
		//옮길 데이터를 xml로 구성한다.
		rowXml = "<TR>";
		for (ic = 0; ic<=fromSheet.LastCol; ic++) {
			if( fromSheet.ColSaveName(ic) == "chk1" ) {
				rowXml += "<TD></TD>";
			} else if( fromSheet.ColSaveName(ic) == "ibflag" ) {
				rowXml += "<TD></TD>";
			} else if( fromSheet.ColSaveName(ic) == "trsp_so_cmb_seq" ) {
				rowXml += "<TD></TD>";
			} else {
				rowXml += "<TD>" + fromSheet.CellValue(fromRow,ic) + "</TD>";
			}
		}
		rowXml += "</TR>";
		allXml += rowXml;
	}

	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = arrRow.length-1; ir >=0 ; ir--) {
		fromRow = arrRow[ir-1];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);
	IBS_Sheet2SheetStatus4(fromSheet);

}

/*
 * 체크해서 넘기 데이터를 그리드 상에서 삭제한다.
 */
function IBS_Sheet2SheetStatus3_3(fromSheet, sStatus) {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = arrRow.length-2; ir >=0 ; ir--) {
		fromRow = arrRow[ir];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
}

// 배경 색상 및 CB의 내용을 변경하는 부분
function IBS_Sheet2SheetStatus4(fromSheet) {
	var iz = 0;
	var cs = 0;
	for( var i=0; i<fromSheet.RowCount; i++ ) {
		if( i % 2 == 0 )
			iz++;

		if( cs == 0 )
			cs = 1;
		else if( cs == 1 )
			cs = 2;
		else if( cs == 2 )
			cs = 1;
		
		if( iz % 2 == 0 ) {
			fromSheet.CellValue2(i+2, "trsp_so_cmb_seq") = iz+"-"+cs;
			fromSheet.RowBackColor(i+2) = fromSheet.RgbColor(220,234,162);
		} else {
			fromSheet.CellValue2(i+2, "trsp_so_cmb_seq") = iz+"-"+cs;
			fromSheet.RowBackColor(i+2) = fromSheet.RgbColor(255,255,255);
		}
	}
}

/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
	var lvkind = formObj.sel_kind.value; //20070613 정원근
	if( lvobj == "" ) {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if( !doengnumcheck(lvobj) ) {
		obj.value = "";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' ) {
		if( lvkind == "ALL" ) {  //20070613 정원근
			formObj.TRSP_SO_EQ_KIND.value = "A";
		} else if( lvkind == "ER" ) {
			formObj.TRSP_SO_EQ_KIND.value = "A";
		} else if( lvkind == "CN" ) {
			formObj.TRSP_SO_EQ_KIND.value = "N";
		} else {
			formObj.TRSP_SO_EQ_KIND.value = "";
		}
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'V' ) {
		lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		if( lvkind == "ALL" ) {  //20070613 정원근
			formObj.TRSP_SO_EQ_KIND.value = "A";
		} else if( lvkind == "CF" ) {
			formObj.TRSP_SO_EQ_KIND.value = "N";
		} else {
			formObj.TRSP_SO_EQ_KIND.value = "";
		}
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'D' ) {
		lvDoorLoc = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}

/**
 * 공통 Node popup
 */
 function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 430, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * popSearchPiCommCodeGrid 프로세스 처리
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;
	
	if(myWin != null) myWin.close();
	url = myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.frm_node.value = lvLoc;
	formObject.TRSP_SO_EQ_KIND.value = "A";
	getYardCombo(document.frm_yard, sheetObjects[0], formObject, lvLoc);
	document.frm_yard.CODE = lvYard;
}

/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.to_node.value = lvLoc;
	getYardCombo(document.to_yard, sheetObjects[0], formObject, lvLoc);
	document.to_yard.CODE = lvYard;
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function t1sheet1_OnSearchEnd(sheetObj,errMsg){
	if(errMsg!=null){
		ComShowMessage(errMsg);
	}
}

function sheet3_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		if( document.form.f_cmd.value == SEARCH04 ) {
			sheetObjects[0].CellValue2(doc_row, "eq_no") = "";
			sheetObjects[0].RowStatus(doc_row) = "R";
			sheetObjects[0].CellValue2(doc_row, "chk1") = "0";
			sheetObjects[0].RowBackColor(doc_row) = sheetObjects[0].RgbColor(R,G,B);
		} else {
			ComShowMessage(errMsg);
		}
	} else {
		var bchk = false;
		if( document.form.f_cmd.value == SEARCH04 ) {
			var doc_cntr_no = sheetObjects[3].CellValue(1, "eq_no");
			for( var ir = 1; ir < sheetObjects[0].RowCount+1; ir++ ) {
				if( doc_cntr_no == sheetObjects[0].CellValue(ir, "eq_no") && (ir != doc_row) ) {
					bchk = true;
					errMsg = ComGetMsg("TRS90359");
					break;
				}
				if( doc_cntr_no == sheetObjects[0].CellValue(ir, "eq_no") && (ir == doc_row)
					&& ( sheetObjects[0].CellValue(ir, "eq_tpsz_cd") != sheetObjects[3].CellValue(1, "eq_tpsz_cd")   )  ) {
					bchk = true;	
					errMsg = ComGetMsg("TRS90345");
					break;	
				}
			}

			if( bchk ) {	
				sheetObjects[0].RowStatus(doc_row) = "R";
				sheetObjects[0].CellValue2(doc_row, "chk1") = "0";
				sheetObjects[0].RowBackColor(doc_row) = sheetObjects[0].RgbColor(R,G,B);
				sheetObjects[0].CellValue2(doc_row, "eq_no") = "";
				sheetObjects[0].CellValue2(doc_row, "lessor") = "";
				sheetObjects[0].CellValue2(doc_row, "lstm_cd") = "";
				sheetObjects[0].CellValue2(doc_row, "ownr_co_cd") = "";
				sheetObjects[0].CellValue2(doc_row, "eq_used") = "";
				sheetObjects[0].CellValue2(doc_row, "movement_sts") = "";
				sheetObjects[0].CellValue2(doc_row, "creation_yard") = "";
				sheetObjects[0].CellValue2(doc_row, "event_date") = "";
				ComShowMessage(errMsg);
			} else {
				sheetObjects[0].CellValue2(doc_row, "eq_no") = sheetObjects[3].CellValue(1, "eq_no");
				sheetObjects[0].CellValue2(doc_row, "lessor") = sheetObjects[3].CellValue(1, "lessor");
				sheetObjects[0].CellValue2(doc_row, "lstm_cd") = sheetObjects[3].CellValue(1, "lstm_cd");
				sheetObjects[0].CellValue2(doc_row, "ownr_co_cd") = sheetObjects[3].CellValue(1, "ownr_co_cd");
				sheetObjects[0].CellValue2(doc_row, "eq_used") = sheetObjects[3].CellValue(1, "eq_used");
				sheetObjects[0].CellValue2(doc_row, "movement_sts") = sheetObjects[3].CellValue(1, "movement_sts");
				sheetObjects[0].CellValue2(doc_row, "creation_yard") = sheetObjects[3].CellValue(1, "creation_yard");
				sheetObjects[0].CellValue2(doc_row, "event_date") = sheetObjects[3].CellValue(1, "event_date");
				sheetObjects[0].RowBackColor(doc_row) = "";
			}

			sheetObjects[3].RemoveAll(); 
			document.form.hid_cntr_no.value = "";
			doc_row = 0;
		} else {
			doSearchVerify(sheetObjects[0], sheetObjects[3]);
		}
	}

}


/**
 * Inert 성공에 따라 그리드의 내용을 제거 한다.
 */
function IBS_Sheet2SheetStatus3_2(fromSheet, toSheet, sStatus)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	var rowCount = (arrRow.length-1)+toSheet.RowCount;
	var rowXml = "";
	var allXml = "<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"'>";
	//원본에서 역순으로 특정 상태의 행을 이동한다.
	for (ir = 0; ir < arrRow.length-1; ir++) {
		fromRow = arrRow[ir];
		//옮길 데이터를 xml로 구성한다.
		rowXml = "<TR>";
		rowXml += "<TD>" + fromSheet.CellValue(fromRow,"trsp_so_ofc_cty_cd") + "</TD>";
		rowXml += "<TD>" + fromSheet.CellValue(fromRow,"trsp_so_seq") + "</TD>";
		rowXml += "</TR>";
		allXml += rowXml;
	}
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		if( document.form.f_cmd.value == REMOVE ) {
			IBS_Sheet2SheetStatus3_3(sheetObj, "chk1"); //삭제하는 함수
		} else if( document.form.f_cmd.value == MODIFY01 ){
			doSeparateRemove(sheetObj);
		} else {
			errMsg = ComGetMsg("TRS90105");
			ComShowMessage(errMsg);
			IBS_Sheet2SheetStatus3_2(sheetObj, sheetObjects[2], "chk1");

			if ( validateFormSearch(document.form) ) {
			tabObjects[0].SelectedIndex = 0; //tab 이동
			doActionIBSheet(sheetObj, document.form, IBSEARCH, "RE");
			sheetObjects[1].RemoveAll(); //Combined CNTR Trans. Case1의 쉬트 내용을 제거
			}
		
		}
	}
}

function t2sheet1_OnSaveEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		errMsg = ComGetMsg("TRS90105");
		ComShowMessage(errMsg);
		IBS_Sheet2SheetStatus3_2(sheetObj, sheetObjects[2], "chk1");
	}
}

function t3sheet1_OnSaveEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		errMsg = ComGetMsg("TRS90105");
		ComShowMessage(errMsg);
	}
}

/**
 * 공통 Trunk VVD popup
 */
function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = obj; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param ="?returnval="+xx1+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 320, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * 공통 Multiple Inquiry popup
 */
 function openMultipleinquiry2(btn_obj,obj2) 
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var classId ="getTRS_ENS_906";
		
		var param ="?returnval="+xx1+"&sconti_cd="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 다중 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, x1) {
	
	if(x1 == 'RFN'){
		var reObj = "";
		var formObject = document.form;
		for(var i=0; i<rowArray.length; i++) {
			var colArray = rowArray[i];
			if( i == rowArray.length-1 ) {
				reObj = reObj + colArray;
			} else {
				reObj = reObj + colArray + ",";
			}
		}
		if( x1 == "RFN" ) {
			formObject.reference_no.value = reObj;
		} else {
			errMsg = ComGetMsg("TRS90132");
			ComShowMessage(errMsg);
		}
	}else{
		var formObject = document.form;
		if(x1 == 'btns_multicntr'){
			formObject.cntr_no.value = rowArray;
			checkDigit();
		}
	}
}

function checkDigit(obj){
	var formObj = document.form;
	if (obj == undefined){
		obj = formObj.cntr_no;
	}
	obj.value = obj.value.toUpperCase();

	if(formObj.name == 'form'){
		obj.value = multiCntrChkDgt(obj.value);
	}
}

/*
 * 멀티 달력 입력 Pop-Up
 */
function getCalendar() {
    var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.frm_reqdate, document.form.to_reqdate, 'yyyy-MM-dd');
}

// 일자에 더하기를 한다.
function getDateBetween(obj) {
	document.form.to_reqdate.value = ComGetDateAdd(obj.value,"D", 14, "-");	
}

function t1sheet1_OnSelectMenu(sheetObj,sAction){
	//메뉴에 대한 처리
switch(sAction){
    case "Check Selected" :

	var sRowStr = sheetObj.GetSelectionRows("/");

      //자바 스크립트 배열로 만들기
      var arr = sRowStr.split("/");
      for (i=0; i<arr.length; i++) {
      	sheetObj.CellValue2(arr[i], "chk1") = 1;
      }
      
      break;
	
    case "Uncheck Selected" :
	var sRowStr = sheetObj.GetSelectionRows("/");

      //자바 스크립트 배열로 만들기
      var arr = sRowStr.split("/");
      for (i=0; i<arr.length; i++) {
      	sheetObj.CellValue2(arr[i], "chk1") = 0;
      }
      
      break;

    case "Check All" :
      sheetObj.CheckAll2("chk1") = 1;                     break;
  }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 - Cntr verify
 */
function searchVerify(sheetObj, formObj, sStatus) {
	if( sheetObj.CheckedRows("chk1") < 1  ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;
	var lvEq_no = "";
	var lvFm_nod_cd = "";

	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i=0; i<arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		sheetObj.CellValue2(fromRow, "verify_result") = "";  // verify result 초기화

		if( sheetObj.CellValue(fromRow, "eq_no") == "" || !sheetObj.CellEditable( fromRow ,"eq_no")  ) {  // EQ_NO 가 없거나 EDIT 불가하면 Verify 생략.
/*
			sheetObj.CellValue2(arrRow[i], "chk1") = "0"; //체크한 박스를 체크 해제를 시킨다.
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
			errMsg = ComGetMsg("TRS90036");
			ComShowMessage(errMsg);
			return false;
*/
		} else {
			if( arrRow.length-2 == i ) {
				lvEq_no = lvEq_no +""+ sheetObj.CellValue(fromRow, "eq_no");
				lvFm_nod_cd = lvFm_nod_cd +""+ sheetObj.CellValue(fromRow, "fm_nod_cd");
			} else {
				lvEq_no = lvEq_no +""+ sheetObj.CellValue(fromRow, "eq_no")+",";
				lvFm_nod_cd = lvFm_nod_cd +""+ sheetObj.CellValue(fromRow, "fm_nod_cd")+",";
			}
		}
	}
	
	if( sheetObj.CheckedRows("chk1") < 1   ||  lvEq_no.length < 1 ) {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
		return false;
	}
	formObj.eq_no_verify.value = lvEq_no;
	formObj.frm_node_verify.value = lvFm_nod_cd;

	return true;
}

/*
 * Verify 조회한 결과에 대한 S/O Creation 항목 선택
 */
function doSearchVerify(sheetObj1, sheetObj2) {
	var sRow = sheetObj1.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	var fromRow = 0;

	for( var i=0; i<arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		var lvEa_no = sheetObj1.CellValue(fromRow, "eq_no");

		if( sheetObj1.CellValue(fromRow, "eq_no") != "") { // 일단 모두 so 생성가능토록 'Y' 마킹,   EQ_NO 있는것만 
			sheetObj1.CellValue2(fromRow, "so_cre_yn") = "Y";  // Verify 로직 돌려서 데이터 없다는건 verify ok 이므로..  
		}

		if( sheetObj1.CellValue(fromRow, "verify_result") == "" && sheetObj1.CellValue(fromRow, "eq_no") != "" ) { //지연요청(이용태)
			sheetObj1.CellValue2(fromRow, "verify_result") = "OK";
		}
		for( var z=1; z<(sheetObj2.RowCount+1); z++ ) {
			if( lvEa_no == sheetObj2.CellValue(z, "eq_no") ) {
				sheetObj1.CellValue2(fromRow, "verify_result") = sheetObj2.CellValue(z, "verify_result");
				if( sheetObj2.CellValue(z, "verify_yn") == "N" ) { //S/O Creation 가능
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "Y";
				} else {
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";  // S/O Creation 불가.
					sheetObj1.RowStatus(fromRow) = "R";
					sheetObj1.CellValue2(fromRow, "chk1") = "0";
					sheetObj1.RowBackColor(fromRow) = sheetObj1.RgbColor(R,G,B);
				}
				sheetObj2.RowDelete(z, false); 
				break;
			}
		}
	}
	
	ComShowMessage(ComGetMsg("TRS90375"));
}