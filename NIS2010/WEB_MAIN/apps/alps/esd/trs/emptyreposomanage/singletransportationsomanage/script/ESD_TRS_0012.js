s/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0012.js
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.05
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2006.10.30 kim_sang_geun
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
 * @class ESD_TRS_0012 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0012() {
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

/*
docobj[0] = MT HD Sheet
docobj[1] = MT DTL Sheet
docobj[2] = MT DTL Sheet for combined case 1
docobj[3] = Combined case 1 을 위한 임시 sheet
docobj[4] = Verify 용 sheet

*/

/* 공통전역변수 */
var openWindownm = 'MT';

var sheetObjects = new Array();
var sheetCnt = 0;

var tabObjects = new Array();
var tabCnt = 0 ;

var beforetab = 1;
var Mincount = 0;

var R = 222;
var G = 251;
var B = 248;

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++, "   Transportation  " , -1 );
				InsertTab( cnt++, "Combined CNTR Trans. Case |" , -1 );
			}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
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
	
	//그리드 CNTR TP/SZ 설정
	setCntrTypeCd();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon ??? ??1. ???catch
//            axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//            axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//            axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//            axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//            axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//            axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
//            axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
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
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;
}

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
				style.height = GetSheetHeight(8); // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") 
					InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]

				InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(27, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle0 = "||Kind|Reference No|Requested\nDate|Trans.\nMode|CNTR \nTP/SZ|Quantity|Quantity|Quantity|Quantity|From|From|From|To|To|To|Lane|VVD|Reason\nRemark|";
				var HeadTitle1 = "||Kind|Reference No|Requested\nDate|Trans.\nMode|CNTR \nTP/SZ|Allocated|S/O Created|W/O Issued|Remaining|Loc|Node|ETD|Loc|Node|ETA|Lane|VVD|Reason\nRemark|";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, true, 	"chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, true, 	"ibflag", 					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtCombo,			80, 	daCenter, true, 	"so_if_div_cd", 			false, "", dfNone, 		0, false, false); //SO_IF_DIV_CD
				InitDataProperty(0, cnt++, dtData,			120, 	daCenter, true, 	"ref_id", 					false, "", dfNone, 		1, false, false);
				InitDataProperty(0, cnt++, dtData,			80, 	daCenter, true, 	"so_rqst_dt", 				false, "", dfDateYmd,	0, false, false); //SO_RQST_DT				
				InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, true, 	"trsp_mod_cd",				false, "", dfNone, 		1, false, false, 1); //TRSP_MOD_CD
				InitDataProperty(0, cnt++, dtCombo, 		50, 	daCenter, true, 	"eq_tpsz_cd", 				false, "", dfNone, 		1, false, false, 2); //CNTR_TPSZ_CD
				InitDataProperty(0, cnt++, dtData, 			60, 	daRight,  true, 	"allocated", 				false, "", dfInteger, 	0, false, false, 4);
				InitDataProperty(0, cnt++, dtData, 			80, 	daRight,  true, 	"cret_qty", 				false, "", dfInteger, 	1, false, false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daRight,  true, 	"wo_qty", 					false, "", dfInteger, 	1, false, false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daRight,  true, 	"remaing_qty", 				false, "", dfInteger, 	1, false, false);
				InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, true, 	"fm_loc_cd", 				false, "", dfNone, 		1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 		40, 	daCenter, true, 	"fm_nod_cd", 				false, "", dfNone, 		1, false, false);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, 	"fm_dt", 					false, "", dfDateYmd, 	0, false, false); //ETD
				InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, true, 	"to_loc_cd", 				false, "", dfNone, 		1, false, false, 5);
				InitDataProperty(0, cnt++, dtCombo, 		40, 	daCenter, true, 	"to_nod_cd", 				false, "", dfNone, 		1, false, false);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, 	"to_dt", 					false, "", dfDateYmd, 	0, false, false); //ETA
				

				InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, true, 	"slan_cd",					false, "", dfNone, 		1, false, false, 3); //Lane
				InitDataProperty(0, cnt++, dtData, 			75, 	daCenter, true, 	"vvd_cd",					false, "", dfNone, 		1, false, false, 9); //VVD
				InitDataProperty(0, cnt++, dtData,	 		80, 	daLeft,   true, 	"repo_purp_rmk",			false, "", dfNone, 		1, false, false, 100); //Reason Remark

				InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, true, 	"trsp_cost_dtl_mod_cd",		false, "", dfNone, 		0, false, false, 1);
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, true, 	"trsp_crr_mod_cd",			false, "", dfNone, 		1, false, false);
				InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, true, 	"trsp_cost_dtl_mod_name",	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, true, 	"requested_date", 			false, "", dfDateYmd, 	0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, true, 	"repo_pln_id",				false, "", dfNone, 		1, false, false);
				InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, true, 	"pln_yrwk",					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, true, 	"pln_seq", 					false, "", dfNone, 		0, false, false);
				
				InitDataValid(0, "fm_loc_cd",	vtEngUpOnly, "");
				InitDataValid(0, "to_loc_cd", 	vtEngUpOnly, "");

				InitDataValid(0, "slan_cd", 	vtEngUpOther, "0123456789");
				InitDataValid(0, "vvd_cd", 		vtEngUpOther, "0123456789");

				HeadRowHeight = 10;
				RangeBackColor (1, 6, 1, 9) = RgbColor(222, 251, 248);
				
//				InitDataCombo(0, "eq_tpsz_cd","D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4","D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4");
				InitDataCombo(0, 'so_if_div_cd', 'Empty Repo|On-Hire|Off-Hire', 'R|O|F');
				InitDataCombo(0, 'trsp_mod_cd', ' |WD|RD|TD', ' |W|R|T');
			}
		break;
		case 2:      //t1sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(8); // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]

				InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(46, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, true, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle = "||CB\nSeq|Kind|Reference No|Purpose|CNTR No|CNTR\nTP/SZ|From\nNode|To\nNode|Trans.\nMode|Distance(Km)|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date||Due Date|Due Date|Remark|Verify Result|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Lease\n flag|Org\n To Nod";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,   	30,    	daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, true, "ibflag",  					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, true, "trsp_so_cmb_seq", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData,			100, 	daCenter, true, "trsp_cost_dtl_mod_name",	false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			120, 	daCenter, true, "ref_id", 					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, true, "repo_purp_rmk", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, true, "eq_no", 					false, "", dfNone, 		0, true, 	true, 	11);
				InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, true, "eq_tpsz_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "fm_nod_cd", 				false, "", dfNone,		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "to_nod_cd", 				false, "", dfNone, 		0, false, 	false);
				
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "trsp_crr_mod_cd",			false, "", dfNone, 		0, false, 	false);
				
				//2012.06.11 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData, 			90, 	daRight,  true, "ttl_dist", 				false, "", dfInteger, 	0, false, 	false);
				
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "lessor", 					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "lstm_cd", 					false, "", dfNone, 		0, false,	false);
				InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "ownr_co_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, true, "eq_used", 					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, true, "movement_sts", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, true, "creation_yard", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, true, "event_date", 				false, "", dfDateYmd, 	0, false, 	false);
				
				InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, true, "spot_bid_flg");
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, true, "spot_bid_due_dt", 			false, "", dfDateYmd, 	1, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, true, "spot_bid_due_dt_hms", 		false, "", dfTimeHms, 	1, false, 	false);
				
				InitDataProperty(0, cnt++, dtData, 			200, 	daCenter, true, "inter_rmk", 				false, "", dfNone, 		0, true, 	true, 	255);
				InitDataProperty(0, cnt++, dtData,  		90, 	daCenter, true, "verify_result", 			false, "", dfNone, 		0, true, 	true, 	255);

				InitDataProperty(0, cnt++, dtData,  		80, 	daCenter, true, "trns_rqst_ofc_cd", 		false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, true, "trns_rqst_usr_id", 		false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			120, 	daLeft,   true, "trns_rqst_rsn", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, true, "lse_cntr_flg", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData,  		50, 	daCenter, true, "org_to_yd_cd", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden,		10, 	daCenter, true, "trsp_so_ofc_cty_cd", 		false, "", dfNone, 		0, false, 	false);
				
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, true, "cre_usr_id", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, true, "upd_usr_id", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, true, "trsp_mty_rqst_dt",			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, true, "trsp_mty_cost_mod_cd",		false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, true, "repo_pln_id",				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, true, "pln_yrwk",					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, true, "ref_seq",					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, true, "vsl_cd",					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, true, "skd_voy_no",				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, true, "skd_dir_cd",				false, "", dfNone, 		0, false, 	false);
				
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, true, "slan_cd",					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, true, "imdt_ext_flg",				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		10, 	daCenter, true, "conti_cd",					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		30, 	daCenter, true, "so_cre_yn", 				false, "", dfNone, 		0, false, 	false);     // verify 결과.  Y: SO 생성불가 , N:생성가능 
				InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, true, "org_eq_no", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, true, "lnk_dist_div_cd", 			false, "", dfNone, 		0, false, 	false);
				
			}
		break;
		case 3:      //t2sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(8); // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]

				InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(43, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, true, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle = "||CB\nSeq|Kind|Reference No|Purpose|CNTR No|CNTR\nTP/SZ|From\nNode|To\nNode|Trans.\nMode|Distance(Km)|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Remark|Verify Result|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Lease\n flag|Org\n To Nod";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,   	30,  daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 	30,  daCenter, true, "ibflag",  				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			50,  daCenter, true, "trsp_so_cmb_seq", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden,		100, daCenter, true, "trsp_cost_dtl_mod_name",	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			120, daCenter, true, "ref_id", 					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			100, daCenter, true, "repo_purp_rmk", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			100, daCenter, true, "eq_no", 					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			60,  daCenter, true, "eq_tpsz_cd", 				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			80,  daCenter, true, "fm_nod_cd", 				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			80,  daCenter, true, "to_nod_cd", 				false, "", dfNone, 		0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 			80,  daCenter, true, "trsp_crr_mod_cd",			false, "", dfNone, 		0, false, false);
				//2012.06.11 Add Distance column by SHIN DONG IL
				InitDataProperty(0, cnt++, dtData, 			90,  daRight,  true, "ttl_dist", 				false, "", dfInteger, 	0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 			80,  daCenter, true, "lessor", 					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			80,  daCenter, true, "lstm_cd", 				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			80,  daCenter, true, "ownr_co_cd", 				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			100, daCenter, true, "eq_used", 				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			100, daCenter, true, "movement_sts", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			100, daCenter, true, "creation_yard", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			100, daCenter, true, "event_date", 				false, "", dfDateYmd, 	0, false, false);
				InitDataProperty(0, cnt++, dtData, 			200, daCenter, true, "inter_rmk", 				false, "", dfNone, 		0, false, false, 	255);
				InitDataProperty(0, cnt++, dtData,  		90,  daCenter, true, "verify_result", 			false, "", dfNone, 		0, true,  true, 	255);

				InitDataProperty(0, cnt++, dtData,			80 , daCenter, true, "trns_rqst_ofc_cd", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,			100, daCenter, true, "trns_rqst_usr_id", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			120, daLeft,   true, "trns_rqst_rsn", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			50,  daCenter, true, "lse_cntr_flg", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 			50,  daCenter, true, "org_to_yd_cd",	 		false, "", dfNone, 		0, false, false);
				

				InitDataProperty(0, cnt++, dtHidden, 		10,  daCenter, true, "trsp_so_ofc_cty_cd", 		false, "", dfNone, 		0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 		10,  daCenter, true, "cre_usr_id",				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		10,  daCenter, true, "upd_usr_id", 				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		80,  daCenter, true, "trsp_mty_rqst_dt",		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		10,  daCenter, true, "trsp_mty_cost_mod_cd",	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		80,  daCenter, true, "repo_pln_id",				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		80,  daCenter, true, "pln_yrwk",				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden,		100, daCenter, true, "ref_seq",					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		80,  daCenter, true, "vsl_cd",					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		80,  daCenter, true, "skd_voy_no",				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		10,  daCenter, true, "skd_dir_cd",				false, "", dfNone, 		0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 		10,  daCenter, true, "slan_cd",					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		10,  daCenter, true, "imdt_ext_flg",			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		10,  daCenter, true, "conti_cd",				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		30,  daCenter, true, "so_cre_yn", 				false, "", dfNone, 		0, false, false);     // verify 결과.  Y: SO 생성불가 , N:생성가능 
				InitDataProperty(0, cnt++, dtHidden, 		50,  daCenter, true, "org_eq_no", 				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 		50,  daCenter, true, "lnk_dist_div_cd", 		false, "", dfNone, 		0, false, false);
				EditableColorDiff = false; //배경 색을 유지한다. false일 경우만.
			}
		break;
		case 4: //sheet 2 init
			with (sheetObj) {
				style.height = 0; // 높이 설정
				SheetWidth = 0; //전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = false; //전체Edit 허용 여부 [선택, Default false]
				InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(12, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle0 = "chk|S/O Office|Seqence|Bid Flag|Due Date|Due Time|crr_mod_cd|fm node|via node|dor node|to node";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,  50, 	daCenter, 	true, "chk");
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "trsp_so_ofc_cty_cd"	,false, 	"",			dfNone, 	0, false, false);
				InitDataProperty(0, cnt++, dtData,  	80, 	daCenter, 	true, "trsp_so_seq"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	50, 	daCenter, 	true, "spot_bid_flg"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "spot_bid_due_dt"     ,false, 	"", 		dfDateYmd, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "spot_bid_due_dt_hms" ,false, 	"", 		dfTimeHms, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	50, 	daCenter, 	true, "trsp_crr_mod_cd"     ,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "fm_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "via_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "dor_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++, dtData,  	100, 	daCenter, 	true, "to_nod_cd"       	,false, 	"", 		dfNone, 	1, false, false);
				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,	daCenter,   true, "ibflag");
			}
		break;

	
		case 5:      //sheet1 init
			with (sheetObj) {
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

				InitDataProperty(0, cnt++, dtData,60, 	daCenter, true, "sep", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,100, 	daCenter, true, "eq_no", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,20, 	daCenter, true, "eq_tpsz_cd", 	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,600, 	daCenter, true, "verify_result",false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,90,  	daCenter, true, "verify_yn", 	false, "", dfNone, 		0, false, false);

				InitDataProperty(0, cnt++, dtData, 80, 	daCenter, true, "lessor", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, 	daCenter, true, "lstm_cd",  	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, 	daCenter, true, "ownr_co_cd", 	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, 	daCenter, true, "eq_used", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, 	daCenter, true, "movement_sts", false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, 	daCenter, true, "creation_yard",false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, 	daCenter, true, "event_date", 	false, "", dfDateYmd, 	0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, 	daCenter, true, "offh_yd_cd", 	false, "", dfNone, 		0, false, false);
			}
		break;	
	
	
	
	
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */ 
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	var sheetObject4 = sheetObjects[4];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
					sheetObject1.RemoveAll(); //Single Transportation의 쉬트 내용을 제거
					sheetObject2.RemoveAll(); //Combined CNTR Trans. Case1의 쉬트 내용을 제거
					tabObjects[0].SelectedIndex = 0; //tab 이동
				}
			break;
			case "btn_new":
				tabObjects[0].SelectedIndex = 0; //tab 이동	
				formObject.reset();
				formObject.frm_yard.RemoveAll(); // combo 데이터삭제
				formObject.to_yard.RemoveAll(); // combo 데이터삭제
			break;
			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;
			case "btng_apply": //적용
				var sRow = sheetObject.FindCheckedRow("chk1");
				var arrRow = sRow.split("|");
				for( var i=0; i<arrRow.length-1; i++ ) {
					if(sheetObject.CellValue(arrRow[i],"ref_id")==""){
						errMsg = ComGetMsg("TRS90526");
						ComShowMessage(errMsg);
						return;
					}
//					if (sheetObject.CellValue(arrRow[i], "fm_loc_cd")+sheetObject.CellValue(arrRow[i], "fm_nod_cd") == sheetObject.CellValue(arrRow[i], "to_loc_cd")+sheetObject.CellValue(arrRow[i], "to_nod_cd")) {
//						errMsg = ComGetMsg("TRS90053");
//						ComShowMessage( arrRow[i]-1 + " Rows " + errMsg);
//					}
				}
				if( searchValidation(sheetObject, formObject, "chk1") ) {
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "SE");
					sheetObject2.RemoveAll(); //Combined CNTR Trans. Case1의 쉬트 내용을 제거
					tabObjects[0].SelectedIndex = 0; //tab 이동
				}
			break;
			case "btng_fillincontainers":
				if( contatnerValidation(sheetObject1, formObject, "chk1") ) {
					popEqFileImport(sheetObject1, formObject);
				}
			break;
			case "btng_matchmaking1":
				if(	doDataEquals(sheetObject1) ) 
					IBS_Sheet2SheetStatus2(sheetObject1, sheetObject2, "chk1");
			break;
			case "btng_socreation": //입력
				if( validateForm(sheetObject1, formObject) ) {
					doActionIBSheet(sheetObject1, formObject, IBINSERT, "");
				}
				
			break;
			case "btng_socreation1":
				if( validateForm(sheetObject2, formObject) ) {
					doActionIBSheet(sheetObject2, formObject, IBINSERT, "CF");
				}
			break;
			case "btng_woissue":
				if( sheetObject3.RowCount<1 ) {
					errMsg = 'W/O Issue is not possible at this moment.';
					ComShowMessage(errMsg);
					return false;
				}else{
					doActionIBSheet(sheetObject3, formObject, IBINSERT, "WO");
				}
			break;
			case "btng_woissue2":
				if( sheetObject3.RowCount<1 ) {
					errMsg = 'W/O Issue is not possible at this moment.';
					ComShowMessage(errMsg);
					return false;
				}else{
					doActionIBSheet(sheetObject3, formObject, IBINSERT, "WO");
				}
			break;
			case "btng_downexcel":
				sheetObject1.SpeedDown2Excel(true);
			break;
			case "btng_downexcel2":
				sheetObject2.SpeedDown2Excel(true);
			break;
			case "btng_separate2":
				if(	doDataEquals(sheetObject2) ) {
					IBS_Sheet2SheetStatus3(sheetObject2, sheetObject1, "chk1");
				}
			break;
			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;
			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;
			case "btns_multireference": //Reference No
				openMultipleinquiry('REF', 'Reference No');
			break;
			case "btns_multicntrno": //CNTR No
				openMultipleinquiry2(srcName,'CNT');
			break;
			case "btns_calendar": //CNTR No
				getCalendar();
			break;
			case "btns_office": //M CNTR
			    var ofc_cd = formObject.ctrl_so_office.value;
			    ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
			break;
			case "btng_officetransfer": //Office Transfer 버튼
				if( doOfficeTrans(sheetObject1) )
					ComOpenWindow('ESD_TRS_0930Pop.screen', 'ESD_TRS_0930Pop', 'top=200, left=200, width=500, height=180, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
			break;
			case "btng_verify":
			if( searchVerify(sheetObject1, formObject, "chk1") ) {
					doActionIBSheet(sheetObject4, formObject, IBSEARCH, "VY");
				}

			break;
			case "btng_rowadd":
				addOneRow(sheetObject);
			break;
			case "btng_delete":
				deleteCheckedRow(sheetObject);
			break;
			case "btng_save":
				if(validateSave()){
					doActionIBSheet(sheetObject, formObject, IBSAVE, "");
				}
			break;
			
			case "btng_rowcopy":
				checkedRowCopy(sheetObject);
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90108");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.ctrl_so_office.value = obj;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj) {

	if( sheetObj.FindCheckedRow("chk1") == "" ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;

	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for( var i=0; i<arrRow.length-1; i++ ) { //Case One으로 넘길 경우
		fromRow = arrRow[i];
		var lvfmnod = doSepRemove(sheetObj.CellValue(fromRow, "fm_loc_cd")+sheetObj.CellValue(fromRow, "fm_nod_cd"), " ");
		var lvtonod = doSepRemove(sheetObj.CellValue(fromRow, "to_loc_cd")+sheetObj.CellValue(fromRow, "to_nod_cd"), " ");
	}

	var doc_eq_no = "";
	var bverifychk = false;
	var birgchk = false;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for( var i=0; i<arrRow.length-1; i++ ) {
		doc_eq_no = doSepRemove(sheetObj.CellValue(arrRow[i], "eq_no"), " ");
		if( sheetObj.CellValue(arrRow[i], "so_cre_yn") != "Y" 
			&& sheetObj.CellValue(arrRow[i], "eq_no") != "" ) {
			//sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.CellValue2(arrRow[i], "chk1") = "0";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
			bverifychk = true;
			if( sheetObj.CellValue(arrRow[i], "verify_result") == "" )
			{
				errMsg = ComGetMsg("TRS90360");
			} else {
				errMsg = ComGetMsg("TRS90078");
			}
		} else if( sheetObj.CellValue(arrRow[i], "so_cre_yn") != "Y" 
			&& sheetObj.CellValue(arrRow[i], "eq_no") == "" 
				&& sheetObj.CellValue(arrRow[i], "org_eq_no") != "" ) {
			sheetObj.CellValue2(arrRow[i], "chk1") = "0";
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
 * 화면 검색 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateFormSearch(formObj) {
	if( sheetObjects[2].RowCount > 0 ) {
		errMsg = ComGetMsg("TRS90130");
		if( confirm(errMsg) ) {
		} else {
			return false;
		}
	}
	var lvfrmDate = doSepRemove(doSepRemove(formObj.frm_reqdate.value, " "), "-");
	var lvtoDate = doSepRemove(doSepRemove(formObj.to_reqdate.value, " "), "-");

	var lvfrm_node = doSepRemove(formObj.frm_node.value, " ");
	var lvto_node = doSepRemove(formObj.to_node.value, " ");
	var lvcntr_no = doSepRemove(formObj.cntr_no.value, " ");
	var lvreference_no = doSepRemove(formObj.reference_no.value, " ");
	
	if( lvfrmDate == "" ) //from date
		formObj.frm_reqdate.value = "";
	if( lvtoDate == "" ) //to date
		formObj.to_reqdate.value = "";

	if( lvfrmDate == "" && lvtoDate != "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvfrmDate != "" && lvtoDate == "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvfrmDate != "" && lvtoDate != "" ) { //날짜 체크하는 부분
		if( !doDatecheck(lvfrmDate) ) {
			errMsg = ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_reqdate.focus();
			return false;
		} else if( !doDatecheck(lvtoDate) ) {
			errMsg = ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
			formObj.to_reqdate.focus();
			return false;
		}
		if( dateCalcuration(lvfrmDate, lvtoDate) > 14 ) {
			errMsg = ComGetMsg("TRS90120");
			ComShowMessage(errMsg);
			return false;
		} else if( dateCalcuration(lvfrmDate, lvtoDate) < 0 ) {
			errMsg = ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
		}
	} else {
		if( lvreference_no == "" && lvcntr_no == "" ) {
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
	}
	if( lvfrm_node == "" ) { //From Node
		formObj.frm_node.value = "";
		formObj.frm_yard.RemoveAll(); // combo 데이터삭제
	}
	if( lvto_node == "" ) { //To Node
		formObj.to_node.value = "";
		formObj.to_yard.RemoveAll(); // combo 데이터삭제
	}
	if( !doengnumcheck(lvreference_no) ) {
		formObj.reference_no.value = "";
		formObj.reference_no.focus();
		return false;
	}
	if( !doengnumcheck(lvcntr_no) ) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}

	formObj.hid_frmreqdate.value = lvfrmDate; //from Date
	formObj.hid_toreqdate.value = lvtoDate; //to Date

	formObj.frm_node.value = lvfrm_node.toUpperCase();
	formObj.to_node.value = lvto_node.toUpperCase();

	formObj.cntr_no.value = lvcntr_no.toUpperCase(); //CNTR No
	formObj.reference_no.value = lvreference_no.toUpperCase(); //Reference No
	return true;
}

/**
 * Save시 Validation
 */
function validateSave() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var rtnVal = true;
	var add_row_cnt = 0;
	
	//조회된 데이터가 없을 경우
	if(sheetObj.RowCount == 0){
		ComShowMessage("TRS90390");
		rtnVal = false;
	}
	
	//Add Row한 데이터 Validation Check
	for(var i=0 ;i<sheetObj.RowCount ; i++ ){

		if(sheetObj.RowStatus(i+2)=="I"){ //Add Row일 경우만 체크
		
			add_row_cnt++;//Add Row된 수
			
			if(rtnVal == false){
				break;
			}
			
			if(sheetObj.CellValue(i+2,"so_rqst_dt")==""){ // Requested Date
				ComShowCodeMessage("COM12114","Requested Date");
				sheetObj.SelectCell(i+2,"so_rqst_dt");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"trsp_mod_cd")==""){ // Requested Date
				ComShowCodeMessage("COM12114","Trans Mode");
				sheetObj.SelectCell(i+2,"trsp_mod_cd");
				rtnVal = false;	
			}else if(sheetObj.CellValue(i+2,"allocated") <= 0){// allocated
				ComShowCodeMessage("COM12114","allocated");
				sheetObj.SelectCell(i+2,"allocated");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"fm_loc_cd")==""){// From Location code
				ComShowCodeMessage("COM12114","From Loc");
				sheetObj.SelectCell(i+2,"fm_loc_cd");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"fm_nod_cd")==""){// From node code
				ComShowCodeMessage("COM12114","From Node");
				sheetObj.SelectCell(i+2,"fm_nod_cd");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"fm_dt")==""){// From ETD
				ComShowCodeMessage("COM12114","ETD");
				sheetObj.SelectCell(i+2,"fm_dt");
				rtnVal = false;				
			}else if(sheetObj.CellValue(i+2,"to_loc_cd")==""){//To Location code
				ComShowCodeMessage("COM12114","To Loc");
				sheetObj.SelectCell(i+2,"to_loc_cd");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"to_nod_cd")==""){//To Node code
				ComShowCodeMessage("COM12114","To Node");
				sheetObj.SelectCell(i+2,"to_nod_cd");
				rtnVal = false;				
			}else if(sheetObj.CellValue(i+2,"to_dt")==""){//To ETA
				ComShowCodeMessage("COM12114","ETA");
				sheetObj.SelectCell(i+2,"to_dt");
				rtnVal = false;	
			}else if(sheetObj.CellValue(i+2,"slan_cd")!="" && (sheetObj.CellValue(i+2,"slan_cd")).length != 3){
				ComShowCodeMessage("COM12114","Lane");
				sheetObj.CellValue2(i+2,"slan_cd")="";
				sheetObj.SelectCell(i+2,"slan_cd");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"vvd_cd")!="" && (sheetObj.CellValue(i+2,"vvd_cd")).length != 9){
				ComShowCodeMessage("COM12114","VVD");
				sheetObj.CellValue2(i+2,"vvd_cd")="";
				sheetObj.SelectCell(i+2,"vvd_cd");
				rtnVal = false; 
			}else if(ComGetDaysBetween(sheetObj.CellValue(i+2, "so_rqst_dt"), sheetObj.CellValue(i+2, "fm_dt")) < 0) {
				ComShowCodeMessage("COM12133","From date","greater","or equal to the the requested date");
				sheetObj.CellValue(i+2,"fm_dt") = "";
				rtnVal = false;
			}else if(ComGetDaysBetween(sheetObj.CellValue(i+2, "fm_dt"), sheetObj.CellValue(i+2, "to_dt")) < 0) {
				ComShowCodeMessage("COM12133","To date","greater","or equal to the the from date");
				sheetObj.CellValue(i+2,"to_dt") = "";
				rtnVal = false;
			}			
		}
	}

	// Add  Row가 없을 경우
	if(add_row_cnt == 0){
		ComShowCodeMessage("TRS90381");
		rtnVal = false;		
	}
	
	return rtnVal;
}

// Enter Key시 지연대리 요청 20070115
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var formObject = document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
			sheetObject1.RemoveAll(); //Single Transportation의 쉬트 내용을 제거
			sheetObject2.RemoveAll(); //Combined CNTR Trans. Case1의 쉬트 내용을 제거
			tabObjects[0].SelectedIndex = 0; //tab 이동
		}
	}
}

/*
 * Tab1 Sheet1에 대한 IbSheet 관련 Controller
 **/
function t1sheet1_OnChange(sheetObj, row , col , value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.RowStatus(row) = "I";
		} else {
			//sheetObj.RowStatus(row) = "R";
		}
	} else if( sheetObj.ColSaveName(col) == "eq_no" ) {
		var doc_eq_no = sheetObj.CellValue(row, "eq_no");
		var doc_org_eq_no = sheetObj.CellValue(row, "org_eq_no");
		if( doc_eq_no.length >= 10 && doc_org_eq_no == "" ) {
			doc_row = row;
			document.form.hid_cntr_no.value = doc_eq_no.toUpperCase();
			document.form.hid_cntr_tpsz_cd.value = sheetObj.CellValue(row, "eq_tpsz_cd");
			document.form.frm_node_verify.value =  sheetObj.CellValue(row, "fm_nod_cd");
			sheetObj.CellValue2(row, "so_cre_yn") = "";
			sheetObj.CellValue2(row, "verify_result") = "";
			doActionIBSheet(sheetObjects[4], document.form, IBSEARCH, "EQ");
		} else {
			if( doc_org_eq_no != "" ){
			
				sheetObj.CellValue(row, "eq_no") = doc_org_eq_no;
				
			}else{
				sheetObj.CellValue(row, "eq_no") = "";
				sheetObj.CellValue2(row, "lessor") = "";
				sheetObj.CellValue2(row, "lstm_cd") = "";
				sheetObj.CellValue2(row, "ownr_co_cd") = "";
				sheetObj.CellValue2(row, "eq_used") = "";
				sheetObj.CellValue2(row, "movement_sts") = "";
				sheetObj.CellValue2(row, "creation_yard") = "";
				sheetObj.CellValue2(row, "event_date") = "";
				sheetObj.CellValue2(row, "so_cre_yn") = "";
				sheetObj.CellValue2(row, "verify_result") = "";
				sheetObj.CellValue2(row, "to_nod_cd") = sheetObj.CellValue(row, "org_to_yd_cd");
				sheetObj.CellValue2(row, "lse_cntr_flg") = "N";
			}
		}
	} else if (sheetObj.ColSaveName(col) == "spot_bid_flg" ){
		var spot_bid_flg = sheetObj.CellValue(row, "spot_bid_flg"); //Spot Bid Flag
		if(spot_bid_flg == "1"){
			sheetObj.CellEditable(row, "spot_bid_due_dt") 		= true;
			sheetObj.CellEditable(row, "spot_bid_due_dt_hms") 	= true;
		}else{
			sheetObj.CellEditable(row, "spot_bid_due_dt") 		= false;
			sheetObj.CellEditable(row, "spot_bid_due_dt_hms") 	= false;
			sheetObj.CellValue(row, "spot_bid_due_dt") 			= "";
			sheetObj.CellValue(row, "spot_bid_due_dt_hms") 		= "";
		}	
	}
	
}

/*
 * Tab2 Sheet1에 대한 IbSheet 관련 Controller
 **/
var doc_row = 0; //container check..
function t2sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		var lvchk = sheetObj.CellValue(row, "trsp_so_cmb_seq").split("-");
		if ( value == "1") {
			sheetObj.RowStatus(row) = "I";
			for( var i=1; i<(sheetObj.RowCount+1); i++ ) {
				var lvchk2 = sheetObj.CellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					sheetObj.RowStatus(i) = "I";
					sheetObj.CellValue2(i, "chk1") = "1";
				}
			}
		} else {
			//sheetObj.RowStatus(row) = "R";
			for( var i=1; i<(sheetObj.RowCount+1); i++ ) {
				var lvchk2 = sheetObj.CellValue(i, "trsp_so_cmb_seq").split("-");
				if( lvchk[0] == lvchk2[0] ) {
					//sheetObj.RowStatus(i) = "R";
					sheetObj.CellValue2(i, "chk1") = "0";
				}
			}
		}
	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, sObj) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			if( sObj == "RE" ) {
				formObj.f_cmd.value = SEARCH;
				formObj.hid_fm_yard_cd.value = formObj.frm_yard.text;
				formObj.hid_to_yard_cd.value = formObj.to_yard.text;
				sheetObj.DoSearch4Post("ESD_TRS_0012GS.do", TrsFrmQryString(formObj));
			} else if( sObj == "SE" ) {
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESD_TRS_0013GS.do", TrsFrmQryString(formObj));
			} else if( sObj == "VY" ) {
				formObj.f_cmd.value = SEARCH05;
				sheetObj.DoSearch4Post("ESD_TRS_0012GS.do", TrsFrmQryString(formObj));
			} else if( sObj == "EQ" ) { //Verify
				formObj.f_cmd.value = SEARCH04;
				sheetObj.DoSearch4Post("ESD_TRS_0012GS.do", TrsFrmQryString(formObj));
			} 

		break;

		case IBINSERT: //저장
			if( sObj == "" || sObj == "CF" ) {
				formObj.f_cmd.value = MULTI;
				formObj.cbstatus.value = sObj;
				var queryStr = sheetObj.GetSaveString(false, true, "chk1");
				sheetObjects[3].DoSearch4Post("ESD_TRS_0012GS.do", queryStr+"&"+TrsFrmQryString(formObj), "", true);
				
				var bid_flg = "N";
				for(var i=1; i<=sheetObjects[3].RowCount; i++) {
					if(sheetObjects[3].CellValue(i, 'spot_bid_flg') == "Y"){
						bid_flg = "Y";
					}
				}
				
				if(bid_flg == "Y"){
				   if(!validSpot()){
					   return;
				   }
				   
				    var myOption = "dialogWidth:550px; dialogHeight:420px; help:no; status:no; resizable:no; scroll=no;";
				    var url = 'ESD_TRS_0940.screen';
				    var myWin = window.showModalDialog(url,window, myOption);
//				    var myWin = window.open(url,"", myOption);
				    
				}
			} else if( sObj == "WO" ) {
				if( sheetObjects[2].RowCount > 0 ) {
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
				document.woForm.action = "ESD_TRS_0023.screen";
				document.woForm.submit();				
			}
		break;
		
		case IBSAVE:
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESD_TRS_0012GS.do",FormQueryString(formObj)); 
		break;
	}
}

/**
 * Spot Bidding Validation check
 * 2015.08.20 by SHIN DONG IL
 */
function validSpot(){
	var sheetObj  = sheetObjects[1];   //t1sheet1
	var formObj = document.form;
	var rtn_flg = true;
	//지역별 현재일자 조회.
   	
	getLocalTime(sheetObj,formObj,formObj.ctrl_ofc_cd.value);
    var locl_dt_tm = sheetObj.EtcData('locl_dt_tm');
    sheetObj.RemoveEtcData();
    var locl_dt = locl_dt_tm.substr(0,8);
    var add_d7_locl_dt =  ComGetDateAdd(locl_dt, "D", 7, "")
    var add_d14_locl_dt =  ComGetDateAdd(locl_dt, "D", 14, "")
    var trans_mode ="";
    var fm_nod_cd ="";
    var to_nod_cd ="";
    var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	
	for( var i=0; i<arrRow.length-1; i++ ) { //Case One으로 넘길 경우
		if(rtn_flg){
			fromRow = arrRow[i];
			if(sheetObj.CellValue(fromRow,"spot_bid_flg")=="1"){
				if(trans_mode == ""){
					trans_mode = sheetObj.CellValue(fromRow,"trsp_crr_mod_cd");					
				}
				if(fm_nod_cd == "" && via_nod_cd == "" && dor_nod_cd == "" && to_nod_cd == ""){
				    fm_nod_cd  =sheetObj.CellValue(fromRow,"fm_nod_cd");			
				    via_nod_cd =sheetObj.CellValue(fromRow,"via_nod_cd");			
				    dor_nod_cd =sheetObj.CellValue(fromRow,"dor_nod_cd");			
				    to_nod_cd =sheetObj.CellValue(fromRow,"to_nod_cd");			
				}
				if(sheetObj.CellValue(fromRow,"spot_bid_due_dt")== ""){
					errMsg = ComGetMsg("TRS90701");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(sheetObj.CellValue(fromRow,"spot_bid_due_dt_hms") == ""){
					errMsg = ComGetMsg("TRS90701");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(locl_dt_tm > (sheetObj.CellValue(fromRow,"spot_bid_due_dt")+" "+sheetObj.CellValue(fromRow,"spot_bid_due_dt_hms"))){
					errMsg = ComGetMsg("TRS90388","Bid due date");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(ComGetDaysBetween(add_d14_locl_dt,sheetObj.CellValue(fromRow,"spot_bid_due_dt")) > 0){
					errMsg = ComGetMsg("TRS90388","Bid due date");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(trans_mode != sheetObj.CellValue(fromRow,"trsp_crr_mod_cd")){
					errMsg = ComGetMsg("TRS90702","(Spot Bidding)Trans mode");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(fm_nod_cd != sheetObj.CellValue(fromRow,"fm_nod_cd")){
					errMsg = ComGetMsg("TRS90388","Route(From)");
					ComShowMessage(errMsg);
					rtn_flg = false;
				}else if(to_nod_cd  != sheetObj.CellValue(fromRow,"to_nod_cd")){
					errMsg = ComGetMsg("TRS90388","Route(To)");
					ComShowMessage(errMsg);
					rtn_flg = false;		
				}else{
					rtn_flg = true;
				}
			}
		}
	}
    return rtn_flg; 
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function searchValidation(sheetObj, formObj, sStatus) {
/*	if( sheetObj.RowCount("U") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} */
	if( sheetObj.CheckedRows("chk1") < 1  ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;
	var lvTrspCostModCd = "";
	var lvRefId = "";
	var lvFmNodCd = "";
	var lvToNodCd = "";
	var lvTrspCrrModCd = "";
	var lvEqTpszCd = "";

	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i=0; i<arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		if( arrRow.length-2 == i ) {
			lvTrspCostModCd = lvTrspCostModCd +""+ sheetObj.CellValue(fromRow, "trsp_cost_dtl_mod_cd");
			lvRefId         = lvRefId         +""+ sheetObj.CellValue(fromRow, "ref_id");
			lvFmNodCd       = lvFmNodCd       +""+ sheetObj.CellValue(fromRow, "fm_loc_cd") + sheetObj.CellValue(fromRow, "fm_nod_cd");
			lvToNodCd       = lvToNodCd       +""+ sheetObj.CellValue(fromRow, "to_loc_cd") + sheetObj.CellValue(fromRow, "to_nod_cd");
			lvTrspCrrModCd  = lvTrspCrrModCd  +""+ sheetObj.CellValue(fromRow, "trsp_crr_mod_cd");
			lvEqTpszCd      = lvEqTpszCd      +""+ sheetObj.CellValue(fromRow, "eq_tpsz_cd");
		} else {
			lvTrspCostModCd = lvTrspCostModCd +""+ sheetObj.CellValue(fromRow, "trsp_cost_dtl_mod_cd")+",";
			lvRefId         = lvRefId         +""+ sheetObj.CellValue(fromRow, "ref_id")         +",";
			lvFmNodCd       = lvFmNodCd       +""+ sheetObj.CellValue(fromRow, "fm_loc_cd") + sheetObj.CellValue(fromRow, "fm_nod_cd") +",";
			lvToNodCd       = lvToNodCd       +""+ sheetObj.CellValue(fromRow, "to_loc_cd") + sheetObj.CellValue(fromRow, "to_nod_cd") +",";
			lvTrspCrrModCd  = lvTrspCrrModCd  +""+ sheetObj.CellValue(fromRow, "trsp_crr_mod_cd")     +",";			
			lvEqTpszCd      = lvEqTpszCd      +""+ sheetObj.CellValue(fromRow, "eq_tpsz_cd")          +",";
		}
	}
	formObj.hid_trsp_cost_mod_cd.value = lvTrspCostModCd;
	formObj.hid_ref_id.value           = lvRefId;
	formObj.hid_fm_nod_cd.value        = lvFmNodCd;
	formObj.hid_to_nod_cd.value        = lvToNodCd;
	formObj.hid_trsp_crr_mod_cd.value  = lvTrspCrrModCd;
	formObj.hid_eq_tpsz_cd.value       = lvEqTpszCd;
	return true;
}

/**
 * Container File import에 대한 유효성검증 프로세스 처리
 */
function contatnerValidation(sheetObj, formObj, sStatus) {
	if( sheetObj.CheckedRows("chk1") < 1  ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length - 1; i++ ) {
		if( sheetObj.CellValue(arrRow[i], "eq_no") != "" ) {
			sheetObj.CellValue2(arrRow[i], "chk1") = "0"; //체크한 박스를 체크 해제를 시킨다.
			//sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
		}
	}
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90051");
		ComShowMessage(errMsg);
		return false;
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
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(15);
		sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(15);
	} else {
		objs.style.display = "inline";
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(10);
		sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(10);
	}
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
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
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

/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
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
		lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}

/*
 * 팝업창에서 사용하는 Sheet 객체(지우면 안됨) contain File Import할 때 사용함.
 */
function getSheetObj() {
	return sheetObjects[1];
}

/**
* file import window 호출
*/
function popEqFileImport(sheetObject, formObject) {
	ComOpenWindow('ESD_TRS_0951.screen', 'ESD_TRS_0951', 'top=200, left=200, width=395, height=385, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
}

/**
* import popup 에서 호출하여 data를 sheet에 비교하여 채운다.
*/
function importEqNo(popSheetObj, obj) {
	var sheetObj = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var checkList = popSheetObj.FindCheckedRow('chk1');
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
	if(document.form.kind_chassis[0].checked) {
		document.form.f_cmd.value = SEARCH06;
	}else{
		document.form.f_cmd.value = SEARCH07;
	}

	var queryStr = popSheetObj.GetSaveString(false, false, "chk1");
	if(queryStr==''){
		obj.close();
		return false;
	}

	sheetObj2.DoSearch4Post("ESD_TRS_0014GS.do", queryStr+'&'+TrsFrmQryString(document.form), '', false);

	// eq_no가 비어있는 row를 array로 담는다.
	var emptyEqArray = new Array();
	var cnt=0;

	for(var k=1; k<sheetObj.RowCount+1; k++) {
		if(sheetObj.CellValue(k, 'eq_no')=='') emptyEqArray[cnt++] = k;
	}

	cnt=0; // insert된 data의 갯수를 센다.
	var tempEqNo = '';

	for(var i=1; i<sheetObj2.RowCount+1; i++) {
		for(var k=0; k<emptyEqArray.length;k++) {
			if(emptyEqArray[k] != -1) {	// 이미 채워진 row는 검사하지 않는다.
				if(sheetObj.CellValue(emptyEqArray[k], 'eq_tpsz_cd') == sheetObj2.CellValue(i, 'eq_tpsz_cd')) {
					sheetObj.CellValue2(emptyEqArray[k], 'eq_no')         = sheetObj2.CellValue(i, 'eq_no');
					sheetObj.CellValue2(emptyEqArray[k], 'vndr_abbr_nm')  = sheetObj2.CellValue(i, 'vndr_abbr_nm');
					sheetObj.CellValue2(emptyEqArray[k], 'lstm_cd')       = sheetObj2.CellValue(i, 'lstm_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'ownr_co_cd')    = sheetObj2.CellValue(i, 'ownr_co_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'usr_co_cd')     = sheetObj2.CellValue(i, 'usr_co_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'mvmt_sts_cd')	  = sheetObj2.CellValue(i, 'mvmt_sts_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'lst_sts_yd_cd') = sheetObj2.CellValue(i, 'lst_sts_yd_cd');
					sheetObj.CellValue2(emptyEqArray[k], 'mvmt_dt')       = sheetObj2.CellValue(i, 'mvmt_dt');					
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
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
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
	
	if(x1 == 'REF'){
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
		if( x1 == "REF" ) {
			formObject.reference_no.value = reObj;
		} else {
			errMsg = ComGetMsg("TRS90132");
			ComShowMessage(errMsg);
		}
	}else{
		var formObject = document.form;
		if(x1 == 'btns_multicntrno'){
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
 * 업무에 따른 Validation Check / Combined CNTR Trans. Case One과 Single Transportation의 관계 체크
 */
function doDataEquals(sheetObj) { //데이터를 비교하기 위해서 추가함.
/*	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}*/
	if( sheetObj.CheckedRows("chk1") < 1  ) {
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
			//sheetObj.RowStatus(fromRow) = "R"; //false
			sheetObj.CellValue2(fromRow, "chk1") = "0";
			sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
		} else {
			if( lvFmnod == "" || lvTonod == "" ) {
				//sheetObj.RowStatus(fromRow) = "R"; //false
				sheetObj.CellValue2(fromRow, "chk1") = "0";
				sheetObj.RowBackColor(fromRow) = sheetObj.RgbColor(R,G,B);
			}
		}
	}
	return true;
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
 * Combined CNTR Trans. Case One으로 데이터를 이동시키는 함수
 */
function IBS_Sheet2SheetStatus2(fromSheet, toSheet, sStatus)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;
	else if (typeof toSheet != "object" || toSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;

	var sRow = fromSheet.FindStatusRow("I");
	var arrRow = sRow.split(";");
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
		if( fromSheet.CellValue(fromRow, "ibflag") == "I" ) {
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
					//fromSheet.RowStatus(arrRow[z]) = "R";
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
	for (ir = arrRow.length-2; ir >=0 ; ir--) {
		fromRow = arrRow[ir];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchXml(allXml, true);
	IBS_Sheet2SheetStatus4(fromSheet);
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
			fromSheet.CellValue2(i+1, "trsp_so_cmb_seq") = iz+"-"+cs;
			fromSheet.RowBackColor(i+1) = fromSheet.RgbColor(238,255,226);
		} else {
			fromSheet.CellValue2(i+1, "trsp_so_cmb_seq") = iz+"-"+cs;
			fromSheet.RowBackColor(i+1) = fromSheet.RgbColor(255,255,255);
		}
	}
}

/*
 * 멀티 달력 입력 Pop-Up
 */

function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.frm_reqdate, document.form.to_reqdate, 'yyyyMMdd');
}

/**
 * Grid Change Event
 */
function sheet1_OnChange(sheetObj, row, col, Value){
	var form = document.form;
	
	form.TRSP_SO_EQ_KIND.value = "";
	if( sheetObj.ColSaveName(col) == "so_if_div_cd" ) {
		if(Value =="W" ||Value =="T"||Value =="R"){
			sheetObj.CellValue(row, "trsp_mod_cd") = Value;
		}
	}else if( sheetObj.ColSaveName(col) == "fm_loc_cd" ) {
		var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_loc_cd"), " ");
		sheetObj.CellValue2(row, "fm_loc_cd") = lvfm;
		if( lvfm.length == 5 ) {
			if( sheetObj.CellValue(row, "fm_loc_cd") != "" ) {
				if(sheetObj.CellValue(row,"so_if_div_cd") == "F" || sheetObj.CellValue(row,"so_if_div_cd") == "O"){
					//Off Hire일 경우 MDM Yard와 LSE Yard정보를 콤보박스 값에 설정한다.
					form.TRSP_SO_EQ_KIND.value = "A";
					getNodCdForOffHire(sheetObj,row,lvfm,"fm_nod_cd");
				}else{
					getYardSheetCombo(sheetObj, document.form, row, "fm_nod_cd", lvfm);					
				}	
			} else {
				sheetObj.CellComboItem(row, "fm_nod_cd", "", "");
				sheetObj.CellValue2(row, "fm_nod_cd") = "";					
			}
		} else {
			if( lvfm.length == 0 ) {
				sheetObj.CellComboItem(row, "fm_nod_cd", "", "");
				sheetObj.CellValue2(row, "fm_nod_cd") = "";
			} else {
				errMsg = ComGetMsg("TRS90122");
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row,"fm_loc_cd") = "";
				sheetObj.SelectCell(row,"fm_loc_cd");
				sheetObj.CellComboItem(row, "fm_nod_cd", "", "");
				sheetObj.CellValue2(row, "fm_nod_cd") = "";
			}
		}
	} else if( sheetObj.ColSaveName(col) == "to_loc_cd" ) {
		var lvto = doSepRemove(sheetObj.CellValue(row,"to_loc_cd"), " ");
		sheetObj.CellValue(row,"to_loc_cd") = lvto;

		if( lvto.length == 5 ) {
			if( sheetObj.CellValue(row, "to_loc_cd") != "" ) {
				if (sheetObj.CellValue(row, "so_if_div_cd") == "F" || sheetObj.CellValue(row, "so_if_div_cd") == "O") {
					//Off Hire일 경우 MDM Yard와 LSE Yard정보를 콤보박스 값에 설정한다.
					form.TRSP_SO_EQ_KIND.value = "A";
					getNodCdForOffHire(sheetObj, row, lvto, "to_nod_cd");
				}else {
					getYardSheetCombo(sheetObj, document.form, row, "to_nod_cd", lvto);
				}
			} else {
				sheetObj.CellComboItem(row, "to_nod_cd", "", "");
				sheetObj.CellValue2(row, "to_nod_cd") = "";
			}
		} else {
			if( lvto.length == 0 ) {
				sheetObj.CellComboItem(row, "to_nod_cd", "", "");
				sheetObj.CellValue2(row, "to_nod_cd") = "";
			} else {
				errMsg = ComGetMsg("TRS90122");
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row,"to_loc_cd") = "";
				sheetObj.SelectCell(row,"to_loc_cd");
				sheetObj.CellComboItem(row, "to_nod_cd", "", "");
				sheetObj.CellValue2(row, "to_nod_cd") = "";
			}
		}
		
	} 

}

/**
 * Grid OnClick Event
 * 
 * @param {Object} sheetObj
 * @param {Object} row
 * @param {Object} col
 * @param {Object} value
 */
function sheet1_OnClick(sheetObj, row , col , value) {
	var form = document.form;
	form.TRSP_SO_EQ_KIND.value = "";
	if(sheetObj.RowStatus(row)=="I"){//Add된 Row일 경우만
		if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
			value = doSepRemove(sheetObj.CellValue(row, "fm_loc_cd"), " ");
			if( value.length > 0 ) {
				if (sheetObj.CellValue(row, "so_if_div_cd") == "F" || sheetObj.CellValue(row, "so_if_div_cd") == "O") {
					//Off Hire일 경우 MDM Yard와 LSE Yard정보를 콤보박스 값에 설정한다.
					form.TRSP_SO_EQ_KIND.value = "A";
					getNodCdForOffHire(sheetObj, row, value, "fm_nod_cd");
				}else {
					getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
				}
			} else {
				sheetObj.CellValue2(row, "fm_loc_cd") = "";
			}
		} else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
			value = doSepRemove(sheetObj.CellValue(row, "to_loc_cd"), " ");
			if( value.length > 0 ) {
				if (sheetObj.CellValue(row, "so_if_div_cd") == "F" || sheetObj.CellValue(row, "so_if_div_cd") == "O") {
					//Off Hire일 경우 MDM Yard와 LSE Yard정보를 콤보박스 값에 설정한다.
					form.TRSP_SO_EQ_KIND.value = "A";
					getNodCdForOffHire(sheetObj, row, value, "to_nod_cd");
				}else {
					getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
				}
			} else {
				sheetObj.CellValue2(row, "to_loc_cd") = "";
			}
		}
	}

}

/**
 * 저장후 메세지 표현
 */
function sheet1_OnSaveEnd(sheetObj, errMsg){
	var formObj = document.form;
	
	if (errMsg == "") {
		if (formObj.f_cmd.value == "181") { //MULTI01  : Save Button Event
			formObj.reference_no.value = sheetObj.EtcData("ref_id");
			sheetObj.RemoveEtcData();
			ComShowCodeMessage("TRS90511");
			doActionIBSheet(sheetObj, formObj, IBSEARCH, "RE");
		}else if (formObj.f_cmd.value == "161") {//REMOVE01 : Delete Button Event 
			ComShowCodeMessage("TRS90331");
			doActionIBSheet(sheetObj, formObj, IBSEARCH, "RE");
			sheetObjects[1].RemoveAll();
		}
	}
 
}

 /**
 * 조회 완료 이벤트 후 로직 <br>
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var cmbTbcd = "";
	cmbTbcd = document.form.cbstatus.value;
	var sheetObjOrigin;
	var cmbSep = "";

	if( cmbTbcd == "" ) {
		sheetObjOrigin = sheetObjects[1];
		cmbSep = "NO";
	} else if( cmbTbcd == "CF" ) {
		sheetObjOrigin = sheetObjects[2];
		cmbSep = "YES";
	}

	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		errMsg = ComGetMsg("TRS90107");
		ComShowMessage(errMsg);
		IBS_Sheet2SheetStatus3_2(sheetObjOrigin, "chk1", cmbSep);

	}
}


/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function t1sheet1_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {

		if( document.form.f_cmd.value == SEARCH04 ) {
			sheetObjects[1].CellValue2(doc_row, "eq_no") = "";
			//sheetObjects[1].RowStatus(doc_row) = "R";
			sheetObjects[1].CellValue2(doc_row, "chk1") = "0";
			sheetObjects[1].RowBackColor(doc_row) = sheetObjects[1].RgbColor(R,G,B);
		} else {
			ComShowMessage(errMsg);
		}
	} 
}


/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet3_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		if( document.form.f_cmd.value == SEARCH04 ) {
			sheetObjects[1].CellValue2(doc_row, "eq_no") = "";
			//sheetObjects[1].RowStatus(doc_row) = "R";
			sheetObjects[1].CellValue2(doc_row, "chk1") = "0";
			sheetObjects[1].RowBackColor(doc_row) = sheetObjects[1].RgbColor(R,G,B);
		} else {
			ComShowMessage(errMsg);
		}
	} else {
		var bchk = false;
		if( document.form.f_cmd.value == SEARCH04 ) {
			var doc_cntr_no = sheetObjects[4].CellValue(1, "eq_no");
			  if(doc_cntr_no == ""){
   			     bchk = true;
				 errMsg = ComGetMsg("TRS00412");

			  }else{
					for( var ir = 1; ir < sheetObjects[1].RowCount+1; ir++ ) {
						if( doc_cntr_no == sheetObjects[1].CellValue(ir, "eq_no") && (ir != doc_row) ) {
							bchk = true;
							errMsg = ComGetMsg("TRS90359");
							break;
						}
						if( doc_cntr_no == sheetObjects[1].CellValue(ir, "eq_no") && (ir == doc_row)
							&& ( sheetObjects[1].CellValue(ir, "eq_tpsz_cd") != sheetObjects[4].CellValue(1, "eq_tpsz_cd")   )  ) {
							bchk = true;
							errMsg = ComGetMsg("TRS90345");
							break;
						}
					 }
		     }
			if( bchk ) {
				//sheetObjects[1].RowStatus(doc_row) = "R";
				sheetObjects[1].CellValue2(doc_row, "chk1") = "0";
				sheetObjects[1].RowBackColor(doc_row) = sheetObjects[1].RgbColor(R,G,B);
				sheetObjects[1].CellValue2(doc_row, "eq_no") = "";
				sheetObjects[1].CellValue2(doc_row, "lessor") = "";
				sheetObjects[1].CellValue2(doc_row, "lstm_cd") = "";
				sheetObjects[1].CellValue2(doc_row, "ownr_co_cd") = "";
				sheetObjects[1].CellValue2(doc_row, "eq_used") = "";
				sheetObjects[1].CellValue2(doc_row, "movement_sts") = "";
				sheetObjects[1].CellValue2(doc_row, "creation_yard") = "";
				sheetObjects[1].CellValue2(doc_row, "event_date") = "";
				sheetObjects[1].CellValue2(doc_row, "so_cre_yn") = "";
				sheetObjects[1].CellValue2(doc_row, "verify_result") = "";
				
				ComShowMessage(errMsg);
			} else {
				sheetObjects[1].CellValue2(doc_row, "eq_no") = sheetObjects[4].CellValue(1, "eq_no");
				sheetObjects[1].CellValue2(doc_row, "lessor") = sheetObjects[4].CellValue(1, "lessor");
				sheetObjects[1].CellValue2(doc_row, "lstm_cd") = sheetObjects[4].CellValue(1, "lstm_cd");
				sheetObjects[1].CellValue2(doc_row, "ownr_co_cd") = sheetObjects[4].CellValue(1, "ownr_co_cd");
				sheetObjects[1].CellValue2(doc_row, "eq_used") = sheetObjects[4].CellValue(1, "eq_used");
				sheetObjects[1].CellValue2(doc_row, "movement_sts") = sheetObjects[4].CellValue(1, "movement_sts");
				sheetObjects[1].CellValue2(doc_row, "creation_yard") = sheetObjects[4].CellValue(1, "creation_yard");
				sheetObjects[1].CellValue2(doc_row, "event_date") = sheetObjects[4].CellValue(1, "event_date");
				//Off-Hire Cntr 입력했을때
				if( sheetObjects[1].CellValue(doc_row, "trsp_cost_dtl_mod_name") == 'Off-Hire' 
					&& sheetObjects[1].CellValue(doc_row, "org_eq_no") == ''
						&& sheetObjects[4].CellValue(1, "offh_yd_cd") != ''){
							
					//PLAN의 TO NODE CODE와 Off-Hire Node code가 다를 경우 경고 메시지 
					if(sheetObjects[1].CellValue(doc_row, "to_nod_cd")!=sheetObjects[4].CellValue(1, "offh_yd_cd")){
						ComShowCodeMessage('TRS90527',sheetObjects[1].CellValue(doc_row, "to_nod_cd"),sheetObjects[4].CellValue(1, "offh_yd_cd"));
					}
					
					sheetObjects[1].CellValue2(doc_row, "to_nod_cd") = sheetObjects[4].CellValue(1, "offh_yd_cd");
					sheetObjects[1].CellValue2(doc_row, "lse_cntr_flg") = 'Y';
				}
			}
			
			sheetObjects[4].RemoveAll();
			document.form.hid_cntr_no.value = "";
			doc_row = 0;


		} else {
			doSearchVerify(sheetObjects[1], sheetObjects[4]);
			ComShowCodeMessage('COM12116', 'Verify');
		}
	}
}


/**
 * Inert 성공에 따라 그리드의 내용을 제거 한다.
 */
function IBS_Sheet2SheetStatus3_2(fromSheet, sStatus, bgObj)  {
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object" || fromSheet.tagName != "OBJECT")
		return false;

	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");
	for( var ir = arrRow.length-2; ir >=0 ; ir-- ) {
		fromRow = arrRow[ir];
		//원본에서 지움
		fromSheet.RowDelete(fromRow, false);
	}
	if( bgObj == "YES" ) {
		IBS_Sheet2SheetStatus4(fromSheet);
	}
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var formObject = document.form;
	if( validateFormSearch(formObject) ) {
		doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
	}
}

// 일자에 더하기를 한다.
function getDateBetween(obj) {
	document.form.to_reqdate.value = ComGetDateAdd(obj.value,'d', 14, '');
}

function doOfficeTrans(sheetObj) {
	var fromRow = 0;
/*	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}*/
	if( sheetObj.CheckedRows("chk1") < 1  ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
/*	지연 대리의 요청으로 체크 로직 삭제 20070115
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		if( sheetObj.CellValue(fromRow, "trsp_crr_mod_cd").indexOf("T") < 0 ) {
			return false;
		}
	}
*/
	return true;
}

//팝업창에 넘겨주는 Sheet의 Object
function openObjSheet() {
	return sheetObjects[1];
}

function doOfficeTrans_end(obj) {

	var formObject = document.form;
	var sheetObject = sheetObjects[0];


	if( validateFormSearch(formObject) ) {
		doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
	}

    obj.close();


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

		if( sheetObj.CellValue(fromRow, "eq_no") == "" ) {
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
	if( sheetObj.CheckedRows("chk1") < 1  ||  lvEq_no.length < 1 ) {
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

		if( sheetObj1.CellValue(fromRow, "verify_result") == "" && sheetObj1.CellValue(fromRow, "eq_no") != "") { // EQ_NO 있는것만 VERIFY RESULT 뿌림.
			sheetObj1.CellValue2(fromRow, "verify_result") = "OK";
		}
		for( var z=1; z<(sheetObj2.RowCount+1); z++ ) {
			if( lvEa_no == sheetObj2.CellValue(z, "eq_no") ) {
				sheetObj1.CellValue2(fromRow, "verify_result") = sheetObj2.CellValue(z, "verify_result");
				if( sheetObj2.CellValue(z, "verify_yn") == "N" ) { //S/O Creation 가능
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "Y";
					
				} else {
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";  // S/O Creation 불가.
					//sheetObj1.RowStatus(fromRow) = "R";
					sheetObj1.CellValue2(fromRow, "chk1") = "0";
					sheetObj1.RowBackColor(fromRow) = sheetObj1.RgbColor(R,G,B);
				}
				sheetObj2.RowDelete(z, false);
				break;
			}
		}
	}
}

// Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.ctrl_so_office.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.ctrl_so_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.ctrl_so_office.value = document.form.old_ofc_cd.value;
	}
}

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

// Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.ctrl_so_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//Add Row
function addOneRow(sheetObj)
{
	var Row = sheetObj.DataInsert(-1);
	sheetObj.CellEditable(Row, "so_if_div_cd") 	= true;
	sheetObj.CellEditable(Row, "so_rqst_dt") 	= true;
	sheetObj.CellEditable(Row, "eq_tpsz_cd") 	= true;
	sheetObj.CellEditable(Row, "allocated") 	= true;
	sheetObj.CellEditable(Row, "trsp_mod_cd") 	= true;
	sheetObj.CellEditable(Row, "vsl_lane_cd") 	= true;
	sheetObj.CellEditable(Row, "vvd_cd") 		= true;
	sheetObj.CellEditable(Row, "fm_loc_cd") 	= true;
	sheetObj.CellEditable(Row, "fm_nod_cd") 	= true;
	sheetObj.CellEditable(Row, "fm_dt") 		= true;
	sheetObj.CellEditable(Row, "to_loc_cd") 	= true;
	sheetObj.CellEditable(Row, "to_nod_cd") 	= true;
	sheetObj.CellEditable(Row, "to_dt") 		= true;	
	sheetObj.CellEditable(Row, "slan_cd") 		= true;
	sheetObj.CellEditable(Row, "vvd_cd") 		= true;
	sheetObj.CellEditable(Row, "repo_purp_rmk") = true;
}

/*
 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
 * DELETE Logic 추가
 * 2013.11.27 by SHIN DONG IL
 */
function deleteCheckedRow(sheetObj){
	var formObj = document.form;
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');

	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return;
	}

	// 1.S/O,W/O 발행 건수 체크
	for (var i = 0; i < checkArray.length-1; i++) {
		//S/O가 생성된 건이 존재 할 경우 Delete 불가

		if( sheetObj.CellValue(checkArray[i], "ref_id") != "" && sheetObj.CellValue(checkArray[i], "cret_qty") > 0){
			ComShowCodeMessage("TRS90528","S/O");
			return;
		}
		
		//W/O가 생성된 건이 존재 할 경우 Delete 불가
		if( sheetObj.CellValue(checkArray[i], "ref_id") != "" && sheetObj.CellValue(checkArray[i], "wo_qty") > 0){
			ComShowCodeMessage("TRS90528","W/O");
			return;
		}		
	}
	// 2.체크된 건 중에 신규 Row Add한 건을 삭제
	for(var k = checkArray.length-2; k >= 0; k--){
		if( sheetObj.CellValue(checkArray[k], "ref_id") == "" ) {
			sheetObj.RowDelete(checkArray[k], false);
		}
	}
	
	// 3.체크된 건 중에 신규 Row Add한 건을 삭제 후 남은 체크된 건 삭제.
	if(sheetObj.CheckedRows('chk1') > 0){
		formObj.f_cmd.value = REMOVE01;
		sheetObj.DoSave("ESD_TRS_0012GS.do",FormQueryString(formObj)); 
	}
}

/**
 * CHM-201327722 MT repo & EQ on/off-hire 메뉴 개선사항1
 * 2013.11.21 by SHIN DONG IL
 * Off Hire일 경우 Node Combo정보를 MDM YARD와 LSE YARD정보를 모두 가져온다.
 * @param {Object} sheetObj
 * @param {Object} row
 * @param {Object} loc_cd : LOCATION CODE VALUE
 * @param {Object} nod_cd : Mapping할 Node Column
 */
function getNodCdForOffHire(sheetObj,row,loc_cd,nod_cd){
	var formObj = document.form;
	
	if(loc_cd !=""){
		formObj.f_cmd.value = SEARCH06;
		var sXml = sheetObj.GetSearchXml("ESD_TRS_0012GS.do", FormQueryString(formObj) + "&locCd=" + loc_cd);
		var rtn_nod_cd = ComGetEtcData(sXml,"nod_cd");
		
		if(rtn_nod_cd != ""){
			sheetObj.CellComboItem (row, nod_cd, " |"+rtn_nod_cd," |"+rtn_nod_cd);
		}else{
			ComShowCodeMessage('COM12161', loc_cd);
		}
	}
	 
}

/**
 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
 * REF ID 제외하고 Check된 복수개의 Row Copy
 * 2013.11.27 by SHIN DONG IL
 * @param {Object} sheetObj
 */
function checkedRowCopy(sheetObj){
    
	var checkList = sheetObj.FindCheckedRow("chk1");
	var arrRow = checkList.split("|");

	if (checkList != "") {
		for (var i = 0; i < arrRow.length - 1; i++) { //선택된 Row 갯수 만큼 Loop
			sheetObj.DataInsert(-1);
			for (var j = 0; j < sheetObj.LastCol; j++) {
				if(sheetObj.ColSaveName(j) !="chk1"
				&& sheetObj.ColSaveName(j) !="ibflag" 
				&& sheetObj.ColSaveName(j) !="ref_id" 
				&& sheetObj.ColSaveName(j) !="allocated" 
				&& sheetObj.ColSaveName(j) !="cret_qty" 
				&& sheetObj.ColSaveName(j) !="wo_qty"
				&& sheetObj.ColSaveName(j) !="remaing_qty"
				&& sheetObj.ColSaveName(j) !="repo_pln_id"
				&& sheetObj.ColSaveName(j) !="pln_yrwk"
				&& sheetObj.ColSaveName(j) !="pln_seq"
				){
					sheetObj.CellValue(sheetObj.SelectRow,sheetObj.ColSaveName(j)) = sheetObj.CellValue(arrRow[i],sheetObj.ColSaveName(j));
				}
			}

			sheetObj.CellEditable(sheetObj.SelectRow, "so_if_div_cd") 	= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "so_rqst_dt") 	= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "eq_tpsz_cd") 	= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "allocated") 		= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "trsp_mod_cd") 	= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "vsl_lane_cd") 	= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "vvd_cd") 		= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "fm_loc_cd") 		= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "fm_nod_cd") 		= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "fm_dt") 			= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "to_loc_cd") 		= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "to_nod_cd") 		= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "to_dt") 			= true;	
			sheetObj.CellEditable(sheetObj.SelectRow, "slan_cd") 		= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "vvd_cd") 		= true;
			sheetObj.CellEditable(sheetObj.SelectRow, "repo_purp_rmk") 	= true;
		}
	}else{
		ComShowCodeMessage('TRS90529');
		return;
	}
}

/**
 * CHM-201640857 - Empty Repo & On/Off Hire
 * 공통테이블 MDM 기준으로 변경함
 */
function setCntrTypeCd(){
	var sheetObj = sheetObjects[2];
	var formObj = document.form;
    var vParam = "f_cmd="+SEARCH10;		
	var sXml = sheetObj.GetSearchXml("ESD_TRS_0999GS.do", vParam);
	ComSetIBCombo(sheetObjects[0],sXml, "eq_tpsz_cd", false, 0);
}