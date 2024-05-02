/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0102.js
*@FileTitle : USA Rail Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.10
*@LastModifier : 김종호
*@LastVersion : 1.15
* 2007.12.19 Jun Ho Kim
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.02.18 손은주 1.1 [CHM-201108834-01][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청
* 2011.03.15 최 선     1.2 [CHM-201109283] [TRS] ALPS의 Location 조회불가건 수정 보완 요청
* 2011.05.27 김종호 1.14 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청
* 2011.06.10 김종호 1.15 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청
* 2011.07.12 김영철 1.16 [CHM-201111646][TRS] US rail report 조회 조건 보완요청
* 2013.06.25 조인영 [CHM-201324798] [TRS] Report 메뉴 40ft CNTR 세분화 및 조회조건 추가
=========================================================*/

/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0102 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0102() {
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
var sheetCnt 	= 0;

var tabObjects = new Array();
var tabCnt = 0 ;

var beforetab = 1;
var Mincount = 0;

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */

function initTab(tabObj, tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++, "SML S/O & Invoice, HJL Invoice" , -1 );
				InsertTab( cnt++, "SML S/O" , -1 );
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
 * comSheetObject(id)에서 호출한다
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
    }
	
 	//IBMultiCombo초기화
    for(var c=0; c<comboObjects.length; c++){
        initCombo(comboObjects[c], c+1);
    }
    getRailVendorComboList(document.rail_road_code , rail_road_codeCode , rail_road_codeText , '');                           // Serveic Provider 멀티 콤보 (Rail Load) 설정
	initVendorCombo(document.rail_road_code);       // 공통스크립트
}

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
			
                //style.height = GetSheetHeight(8); // 높이 설정
                style.height = 400;
                SheetWidth = mainTable.clientWidth; //전체 너비 설정
                //SheetWidth = mainTable1.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;     
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 9, 100);
	
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(33, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "Seq.|Month|Week|Company|Rail Company|Rail Company Name|F/M|Bound|Agmt. Ref. No.|Lane|VVD|From|To|Curr.|20' Vol|20' Amount(Local)|20' Amount(USD)|40' Vol|40' Amount(Local)|40' Amount(USD)|40HC Vol|40HC Amount(Local)|40HC Amount(USD)|40' Vol|40' Amount(Local)|40' Amount(USD)|45' Vol|45' Amount(Local)|45' Amount(USD)|TTL Vol|TTL Amount(Local)|TTL Amount(USD)";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
	
                //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                
				InitDataProperty(0, cnt++ , dtSeq			,   50	,   daCenter,  true,    "seq"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //01
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "month"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //02
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "week"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //02
				InitDataProperty(0, cnt++ , dtData			,   80	,   daCenter,  true,    "company"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //03
                InitDataProperty(0, cnt++ , dtData			,  100	,   daCenter,  true,    "rail_code"		,   false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //04
				InitDataProperty(0, cnt++ , dtData			,  250	,   daCenter,  true,    "rail_name"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //05
                InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "full_empty"	,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //06
                InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "bound"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //07
                InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true,    "agmt_ref_no"	,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //newly added
                InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "slan_cd"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //08
                InitDataProperty(0, cnt++ , dtData			,   80	,   daCenter,  true,    "vvd"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //09
                InitDataProperty(0, cnt++ , dtData			,   70	,   daCenter,  true,    "from"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //10
                InitDataProperty(0, cnt++ , dtData			,   70	,   daCenter,  true,	"to"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //11
                InitDataProperty(0, cnt++ , dtData			,   40	,   daCenter,  true,    "curr"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //12
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_20"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //13
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_20"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //14
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "usd_amt_20"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //15
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_40"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //16
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_40"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //17
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight	,  true,    "usd_amt_40"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //18
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_40hc"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //16
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_40hc"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //17
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight	,  true,    "usd_amt_40hc"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //18
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_40_hc"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //16
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_40_hc"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //17
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight	,  true,    "usd_amt_40_hc"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //18
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_45"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //19
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_45"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //20
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight	,  true,    "usd_amt_45"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //21
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "tot_vol"		,	false,  "", dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //22
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "tot_loc_amt"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //23
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "tot_usd_amt"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //24
                InitDataProperty(0, cnt++,  dtHidden		,  	 0	,   daCenter,  false,   "ibcheck"                                                                                                         	);  //25
	
				ColHidden('ibflag')				= true;
			}
			break;
			
		case 2:      //sheet2 init
			with (sheetObj) {
				//style.height = GetSheetHeight(8); // 높이 설정
				style.height = 400;
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				//SheetWidth = mainTable2.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(33, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle1 = "Seq.|Month|Week|Company|Rail Company|Rail Company Name|F/M|Bound|Agmt. Ref. No.|Lane|VVD|From|To|Curr.|20' Vol|20' Amount(Local)|20' Amount(USD)|40' Vol|40' Amount(Local)|40' Amount(USD)|40HC Vol|40HC Amount(Local)|40HC Amount(USD)|40' Vol|40' Amount(Local)|40' Amount(USD)|45' Vol|45' Amount(Local)|45' Amount(USD)|TTL Vol|TTL Amount(Local)|TTL Amount(USD)";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq			,   50	,   daCenter,  true,    "seq"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //01
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "month"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //02
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "week"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //02
				InitDataProperty(0, cnt++ , dtData			,   80	,   daCenter,  true,    "company"	,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //03
                InitDataProperty(0, cnt++ , dtData			,  100	,   daCenter,  true,    "rail_code"	,   false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //04
				InitDataProperty(0, cnt++ , dtData			,  250	,   daCenter,  true,    "rail_name"	,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //05
                InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "full_empty",	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //06
                InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "bound"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //07
                InitDataProperty(0, cnt++ , dtData			,   100	,   daCenter,  true,    "agmt_ref_no",	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //newly added
                InitDataProperty(0, cnt++ , dtData			,   50	,   daCenter,  true,    "slan_cd"	,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //08
                InitDataProperty(0, cnt++ , dtData			,   80	,   daCenter,  true,    "VVD"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //09
                InitDataProperty(0, cnt++ , dtData			,   70	,   daCenter,  true,    "from"		,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //10
                InitDataProperty(0, cnt++ , dtData			,   70	,   daCenter,  true,	"to"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //11
                InitDataProperty(0, cnt++ , dtData			,   40	,   daCenter,  true,    "curr"			,	false,  "",	dfNone		,   0,  false,	false,		100,	false,		true,	   "",	  false	);  //12
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_20"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //13
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_20"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //14
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "usd_amt_20"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //15
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_40"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //16
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_40"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //17
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight	,  true,    "usd_amt_40"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //18
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_40hc"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //16
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_40hc"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //17
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight	,  true,    "usd_amt_40hc"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //18
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_40_hc"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //16
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_40_hc"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //17
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight	,  true,    "usd_amt_40_hc"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //18
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "vol_45"		,	false,  "",	dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //19
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "loc_amt_45"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //20
				InitDataProperty(0, cnt++ , dtData			,  120	,   daRight	,  true,    "usd_amt_45"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //21
                InitDataProperty(0, cnt++ , dtData			,   60	,   daCenter,  true,    "tot_vol"		,	false,  "", dfInteger	,   0,  false,	false,		100,	false,		false,	   "",	  false	);  //22
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "tot_loc_amt"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //23
                InitDataProperty(0, cnt++ , dtData			,  120	,   daRight,   true,    "tot_usd_amt"	,	false,  "",	dfNullFloat	,   2,  false,	false,		100,	false,		false,	   "",	  false	);  //24
                InitDataProperty(0, cnt++,  dtHidden		,  	 0	,   daCenter,  false,   "ibcheck"                                                                                                       );  //25
	
				ColHidden('ibflag')				= true;
			}
			break;
			
		case 3:      //sheet3 init
		with (sheetObj) {
			//style.height = GetSheetHeight(8); // 높이 설정
			//style.height = 400;
			//SheetWidth = mainTable.clientWidth; //전체 너비 설정
			//SheetWidth = mainTable2.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

		   //전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 1, 1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(1, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)

			var HeadTitle1 = "";
			//var HeadTitle1 = "Seq.|Month|Company|Rail Company|Rail Company Name|F/M|Bound|Lane|VVD|From|To|Curr.|20' Vol|20' Basic(Local)|20' FSC(Local)|20' Surcharge(Local)|20' TTL(Local)|20' Basic(USD)|20' FSC(USD)|20' Surcharge(USD)|20' TTL(USD)|40' Vol|40' Basic(Local)|40' FSC(Local)|40' Surcharge(Local)|40' TTL(Local)|40' Basic(USD)|40' FSC(USD)|40' Surcharge(USD)|40' TTL(USD)|45' Vol|45' Basic(Local)|45' FSC(Local)|45' Surcharge(Local)|45' TTL(Local)|45' Basic(USD)|45' FSC(USD)|45' Surcharge(USD)|45' TTL(USD)|TTL Vol|TTL Basic(Local)|TTL FSC(Local)|TTL Surcharge(Local)|Total Amount(Local)|TTL Basic(USD)|TTL FSC(USD)|TTL Surcharge(USD)|Total Amount(USD)";
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			InitDataProperty(0, cnt++,  dtHidden		,  	 0	,   daCenter,  false,   "base" );  //25
			
		}
		break;
	}

}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){


/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];


	var formObject = document.form;

	/*******************************************************/	

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
	
			case "btn_retrieve":

				if(document.form.vvd_dip.checked){
					sheetObjects[0].ColHidden("from") = false;
					sheetObjects[0].ColHidden("to") = false;
					sheetObjects[0].ColHidden("bound") = false;
					sheetObjects[0].ColHidden("slan_cd") = false;
					sheetObjects[0].ColHidden("vvd") = false;
				}else{
					sheetObjects[0].ColHidden("from") = true;
					sheetObjects[0].ColHidden("to") = true;
					sheetObjects[0].ColHidden("bound") = true;
					sheetObjects[0].ColHidden("slan_cd") = true;
					sheetObjects[0].ColHidden("vvd") = true;
				}
				
				if(document.form.loc_on.checked){
					sheetObjects[0].ColHidden("month") = true;
					sheetObjects[0].ColHidden("week") = true;
				}else{
					sheetObjects[0].ColHidden("month") = false;
					sheetObjects[0].ColHidden("week") = false;
				}
				
				//Agmt. Ref. No. 조회 조건 체크 여부에 따라 시트 컬럼 설정
				if(document.form.agmt_chk.checked == true){
					sheetObjects[0].ColHidden("agmt_ref_no") = false; //AGMT REF. No. 칼럼이 추가되어 보이도록 설정
					sheetObjects[1].ColHidden("agmt_ref_no") = false;
				} else {
					sheetObjects[0].ColHidden("agmt_ref_no") = true; //AGMT REF. No. 칼럼 제외
					sheetObjects[1].ColHidden("agmt_ref_no") = true;
				}
				
				
				
				if( tabObjects[0].SelectedIndex == "0" ) {
					if(!validateForm(sheetObject1, formObject, IBSEARCH, "ENIS"))	return false;
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "ENIS"  );
				}else if ( tabObjects[0].SelectedIndex == "1" ){
					if(!validateForm(sheetObject2, formObject, IBSEARCH, "NIS"))	return false;
					doActionIBSheet(sheetObject2, formObject, IBSEARCH, "NIS"  );
				}
				
				//Detailed Size 조회 조건 체크 여부에 따라 시트 컬럼 설정
				if(document.form.size_chk.checked == true){ //40HC 관련 칼럼이 추가되어 보이도록 설정
					sheetObjects[0].ColHidden("vol_40hc") = false;
					sheetObjects[0].ColHidden("loc_amt_40hc") = false;
					sheetObjects[0].ColHidden("usd_amt_40hc") = false;
					
					sheetObjects[0].ColHidden("vol_40") = false;
					sheetObjects[0].ColHidden("loc_amt_40") = false;
					sheetObjects[0].ColHidden("usd_amt_40") = false;
					
					sheetObjects[0].ColHidden("vol_40_hc") = true;
					sheetObjects[0].ColHidden("loc_amt_40_hc") = true;
					sheetObjects[0].ColHidden("usd_amt_40_hc") = true;
					
				} else { //40HC 관련 칼럼 제외
					sheetObjects[0].ColHidden("vol_40") = true;
					sheetObjects[0].ColHidden("loc_amt_40") = true;
					sheetObjects[0].ColHidden("usd_amt_40") = true;
					
					sheetObjects[0].ColHidden("vol_40hc") = true;
					sheetObjects[0].ColHidden("loc_amt_40hc") = true;
					sheetObjects[0].ColHidden("usd_amt_40hc") = true;
					
					sheetObjects[0].ColHidden("vol_40_hc") = false;
					sheetObjects[0].ColHidden("loc_amt_40_hc") = false;
					sheetObjects[0].ColHidden("usd_amt_40_hc") = false;
				}
  
				break;

			case "btn_new":

				fn_reset();
				break;
					
			case "btn_downexcel":
				if (tabObjects[0].SelectedIndex == '0' ) {
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				} else {
					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
				}
				break;
				
			case "fm_date":
				formObject.fm_date.value="";
				break;
			
			case "to_date":
				formObject.to_date.value="";
				break;
			
			case "ctrl_ofc":
				formObject.ctrl_ofc.value="";
				break;
			
				
			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;

			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;
			
		} // end switch

	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}

}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, srcName) {

	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:
	
			switch(srcName) {
				
				case "ENIS":
					if(document.form.date_type.value == "I") {
						if (document.form.vvd_dip.checked) {
							formObj.f_cmd.value = SEARCH11; // Lane/VVD Checked
						} else {
							formObj.f_cmd.value = SEARCH01; // Lane/VVD Unchecked
						}
						sheetObj.DoSearch4Post("ESD_TRS_0102GS.do", TrsFrmQryString(formObj));
					} 
					break;
			}
			break;


		//ExcelDownload			
		case IBDOWNEXCEL:
		
			sheetObj.SpeedDown2Excel(-1);			
			break;

	}

}



	function sheet1_OnSearchEnd(sheetObj, ErrMsg){


	sheetObj.ShowSubSum("ibcheck", "13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31", -1, true, false, -1, "seq=TTL;");

//sheetObj.HideSubSum();
//  sheetObj.FrozenRows = 1;
//alert(sheetObj.AutoSumBottom);
//sheetObj.AutoSumBottom = true;
	}


	function sheet2_OnSearchEnd(sheetObj, ErrMsg){


	sheetObj.ShowSubSum("ibcheck", "13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31", -1, true, false, -1, "seq=TTL;");
	
	}
	




/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, srcName){

    var formObject = document.form;	
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	
	if (formObj.f_chkprd[1].checked ){
		if( formObj.f_fm_mon.value == ""){
			ComShowMessage(ComGetMsg("COM12114", "Month"))
			formObj.f_fm_mon.focus();
			return false;
		}else if(formObj.f_to_mon.value == ""){
			ComShowMessage(ComGetMsg("COM12114", "Month"))
			formObj.f_to_mon.focus();
			return false;
			
		}
	}
	
	if ( formObj.f_chkprd[0].checked ){
		if( formObj.f_fm_wk.value == ""){
			ComShowMessage(ComGetMsg("COM12114", "Week"))
			formObj.f_fm_wk.focus();
			return false;
		}else if(formObj.f_to_wk.value == ""){
			ComShowMessage(ComGetMsg("COM12114", "Week"))
			formObj.f_to_wk.focus();
			return false;
			
		}
	}
	
	var check_fm_date 	= formObject.fm_date.value ;
	var check_to_date 	= formObject.to_date.value ;
	
	if( check_fm_date == "" || check_to_date == ""){
		return false;
	}

	
	/*
	if( check_fm_month.length == 6 && check_to_month.length == 6 ) {
		var check_fm_date 	= check_fm_month.substr(0,4)+ "-" + check_fm_month.substr(4,2) + "-" + "01";
		var check_to_date 	= check_to_month.substr(0,4)+ "-" + check_to_month.substr(4,2) + "-" + "01";
	}
		
	var fm_month = check_fm_month.substr(4,2);
	var to_month = check_to_month.substr(4,2);
	
	if ( !checkMonth( fm_month ) || !checkMonth( to_month )) {
		ComShowMessage('Duration Validation Error!.');
		return false;
	}

	if(check_fm_month == '' || check_fm_month == null || check_fm_month == 'YYYYMM' || check_to_month == '' || check_to_month == null || check_to_month == 'YYYYMM') 
	{
		ComShowMessage('Duration is mandatory!.');
		fn_reset();
					
		return false;
	}*/
	
	// Route or Rail Company 미선택시 Duration 조건 3개월 그외 12개월 제한 
	/* [CHM-201108834-01][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청시 기간제한 해제요청
	if (document.form.rail_road_name.value == "")
		{if (formObject.frm_node.value == "")
		{if (formObject.to_node.value == "")
 			{if (dateCalcuration(check_fm_date , check_to_date) > 90) {
				ComShowMessage('Inquiry Period is limited to 3 months!');
				return false;
 			}
 			}	
 		}
	}
	if (dateCalcuration(check_fm_date , check_to_date) > 365) {
		ComShowMessage('Inquiry Period is limited to 12 months!');
		return false;
	}*/

	if (tabObjects[0].SelectedIndex == '0' && document.form.comp_cd.value == 'S')
	{
		ComShowMessage('SEN Data not found!.');
		return false;
	}
	
	if (tabObjects[0].SelectedIndex == '1')
	{
		if (document.form.comp_cd.value == 'H'){
			ComShowMessage('SML Data not found!.');
			return false;
		} else if (document.form.comp_cd.value == 'I' || document.form.date_type.value == 'I') {
			ComShowMessage('Under Construction!.');
			return false;
		}
	} 
		
	return true;
}




/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
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
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'D' ) {
		lvDelNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'P' ) {
		lvDelNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}

/**
* Rail Road combo 선택시 textfield의 값 변경하는 이벤트
**/
function rail_road_code_OnChange(combo, Index_Code, Text) {

	if ( document.form.rail_road_name.value == Text )  return;

	document.form.rail_road_name.value = combo.GetText(Index_Code,1);
	
}

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	

	sheetObjects[0].RemoveAll();  //TAB1 sheet
	sheetObjects[1].RemoveAll();  //TAB2 sheet

	formObject.frm_yard.RemoveAll();
	formObject.to_yard.RemoveAll();


	tabObjects[0].SelectedIndex = 0; //tab 이동

	formObject.date_type.value="I";
	formObject.fm_date.value="";
	formObject.to_date.value="";
	formObject.f_chkprd[0].checked = true;
	formObject.f_fm_mon.value="";
	formObject.f_to_mon.value="";
	formObject.f_fm_wk.value="";
	formObject.f_to_wk.value="";
	formObject.comp_cd.value="A";
	formObject.rail_road_code.Text = "";
	formObject.rail_road_name.value="";
	formObject.status.value="A";
	formObject.io_bound.value="A";
	formObject.frm_node.value="";
	formObject.frm_yard.value="";
	formObject.to_node.value="";
	formObject.to_yard.value="";
	formObject.ctrl_ofc.value="";
	
//	formObject.input_cre_ofc_cd.value=formObject.login_ofc_cd.value;
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
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.frm_node.value = lvLoc;
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

///////////////////////////////////////////////////////////////////////////////
// 월 체크
function checkMonth( month ) {
	var intmonth = parseInt( month , 10 )
	if( intmonth >= 1  && intmonth <= 12  ) {
		return true;
	} else {
		return false;
	}
}

//function fun_vvdDisplay(){
//	if(document.form.vvd_dip.checked){
//		sheetObjects[0].ColHidden("vvd") = false;
//		sheetObjects[1].ColHidden("VVD") = false;
//		
//		sheetObjects[0].ColHidden("slan_cd") = false;
//		sheetObjects[1].ColHidden("slan_cd") = false;
//	}else{
//		sheetObjects[0].ColHidden("vvd") = true;
//		sheetObjects[1].ColHidden("VVD") = true;
//		
//		sheetObjects[0].ColHidden("slan_cd") = true;
//		sheetObjects[1].ColHidden("slan_cd") = true;
//	}
//	
//}

//-- -----------------------------------------------------------------------------------------
//Period 관련 변경내역	
//-- -----------------------------------------------------------------------------------------
/**
* Month/Week 에 따라서 화면에 컨트롤을 변경시켜준다.
*/
function chkWM(param1, param2){
	if(param1 == 'W'){ 		
		    document.all.div_week.style.display = "inline";
			document.all.div_month.style.display = "none";
			setPeriod(document.form.f_to_wk);
	} else { 		
		    document.all.div_week.style.display = "none";
			document.all.div_month.style.display = "inline";
			setPeriod(document.form.f_to_mon);
	}
}

/**
* month, week가 변경되었을때 Period를 변경한다.
*/
function setPeriod(obj){

	var formObj = document.form;
	if(obj == null){
      return;
  }
  if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
      if(obj.name == "f_to_mon" ){
          formObj.f_fm_mon.value = "";
      } else if (obj.name == "f_to_wk"){
          formObj.f_fm_wk.value = "";
      }
      return false;
  } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
      if(obj.name == "f_fm_mon") return false;
      if(obj.name == "f_fm_wk") return false;
  }

  if(chkValidSearch()){
      var sheetObj = sheetObjects[2];
	  	sheetObj.RemoveEtcData();
	  	formObj.fm_date.value = "";
		formObj.to_date.value = "";
		document.getElementById("div_period").innerHTML = ".....";
		formObj.f_cmd.value = SEARCH02;
		sheetObj.DoSearch4Post("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));

		var fm_date = sheetObj.EtcData('FM_DATE');
		var to_date = sheetObj.EtcData('TO_DATE');
		if( fm_date != null && to_date != null){
			formObj.fm_date.value=doSepRemove(doSepRemove(fm_date, " "), "-");
			formObj.to_date.value=doSepRemove(doSepRemove(to_date, " "), "-");
			document.getElementById("div_period").innerHTML = "( "+fm_date + " ~ "+ to_date +" )";
			ComBtnEnable("btn_retrieve");
		}
	
  }
}

/**
* 검색시 필수입력사항 체크
*/
function chkValidSearch(){
	var formObj = document.form;

	with(formObj){
		if (f_chkprd[1].checked && f_fm_mon.value != "" && f_to_mon.value == ""){
			ComShowMessage(ComGetMsg("COM12114", "Month"))
			f_to_mon.focus();
			return false;
		}
		if (f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value != "") {
			ComShowMessage(ComGetMsg("COM12114", "Month"));
			f_fm_mon.focus();
			return false;
		}
		if (f_chkprd[1].checked && f_fm_mon.value > f_to_mon.value) {
			ComShowMessage(ComGetMsg("TRS90386","Month of From should be equal to or less than To."));
			f_to_mon.focus();
			return false;
		}	
		if (f_fm_wk.value != "" && f_to_wk.value == ""){
			ComShowMessage(ComGetMsg("COM12114", "Week"));
			f_to_wk.focus();
			return false;
		}
		if (f_fm_wk.value == "" && f_to_wk.value != ""){
			ComShowMessage(ComGetMsg("COM12114", "Week"));
			f_fm_wk.focus();
			return false;
		}
		if (f_fm_wk.value > f_to_wk.value) {
			ComShowMessage(ComGetMsg("TRS90386","Week of From should be equal to or less than To."));
			f_to_wk.focus();
			return false;
		}
		if(f_fm_mon.value == "" && f_fm_wk.value == ""){
			return false;
		}
		if(f_chkprd[1].checked){
			 var inputValue = f_fm_mon.value;
			 var year  = inputValue.substring(0,4);
			 var month = inputValue.substring(4,6);
         if (!((ComParseInt(year)>1900)  && (0 < ComParseInt(month) &&  ComParseInt(month) < 13))){
       	  return false;
         }
		}
		if(f_chkprd[1].checked){
			 var inputValue = f_to_mon.value;
			 var year  = inputValue.substring(0,4);
			 var month = inputValue.substring(4,6);
        if (!((ComParseInt(year)>1900)  && (0 < ComParseInt(month) &&  ComParseInt(month) < 13))){
       	 return false;
        }
		}
		if(f_chkprd[0].checked){
			var inputValue = f_fm_wk.value;
			var year  = inputValue.substring(0,4);
          var week = inputValue.substring(4,6);
          if (!((ComParseInt(year)>1900)  && (0 < ComParseInt(week) && ComParseInt(week)< 54))){
       	   return false;
          }
		}
		if(f_chkprd[0].checked){
			var inputValue = f_to_wk.value;
			var year  = inputValue.substring(0,4);
          var week = inputValue.substring(4,6);
          if (!((ComParseInt(year)>1900)  && (0 < ComParseInt(week) && ComParseInt(week)< 54))){
       	   return false;
          }
		}
	}
	return true;
}

/**
* HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 숫자만으로 제어한다. <br>
* 예를 들어 다음과 같이 사용한다.<br>
*     &lt;input type="text" name="txtAmt" <font color="red">onKeyPress="ComKeyOnlyNumber(this)"</font>&gt; <br>
* 인자로 사용되는 sSubChar 인자는 숫자이외에 부가적으로 입력할수 있는 문자를 여러개 연결하여 설정한다.<br>
* <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
* <br><b>Example :</b>
* <pre>
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this)"&gt;
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-")"&gt;
*     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-.,")"&gt;
* </pre>
* @param {object} obj      필수,대상 HTML태그(Object)
* @param {string} sSubChar 선택,숫자이외의 부가 글자
* @returns 없음 <br>
* @see #ComKeyOnlyAlphabet
*/
function ComKeyOnlyNumberChk(obj,sSubChar)
{
   try {
       var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

       if(keyValue >= 48 && keyValue <= 57) {//숫자
           event.returnValue = true;

       } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
       	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
       	for(var i=0; i<sSubChar.length; i++) {
        		if (keyValue == sSubChar.charCodeAt(i)) {
	                event.returnValue = true;
	                return;
       		}
       	}
           event.returnValue = false;
       } else {
           event.returnValue = false;
       }
       ComBtnDisable("btn_retrieve");
       
      
   } catch(err) { ComFuncErrMsg(err.message); }
}

/*
* Month(YYYYMM), Week(YYYYWW) Format check
*/
function check_format(obj){
	var formObj = document.form;
	if(formObj.f_chkprd[0].checked){
		if( !ComIsDate(obj,'yw')){
			ComShowMessage(ComGetMsg("COM12114", "Week Format(YYYYWW)"));
			obj.focus();
			return;
		}
	}else if(formObj.f_chkprd[1].checked){
		if( !ComIsDate(obj,'ym')){
			ComShowMessage(ComGetMsg("COM12114", "Month Format(YYYYMM)"));
			obj.focus();
			return;
		}
	}
}

/*
* 입력 키 체크
*/
function keyCheck(obj){
	if(event.keyCode == '9'){
		check_format(obj);
	}else{
		ComKeyOnlyNumberChk(this);
		
	}
}

/*
* 제대로된  month, week 입력시 검색 기간 조회로 넘김
*/
function checkLength(obj){
	var formObj = document.form;
	var inputValue = obj.value;
	var year = null;
	var month = null;
	var week = null;
	if( inputValue.length == 6 ){
		if(formObj.f_chkprd[0].checked){
			 year  = inputValue.substring(0,4);
             week = inputValue.substring(4,6);
             if ((ComParseInt(year)>1900)  && (0 < ComParseInt(week) && ComParseInt(week)< 54)){
            	 setPeriod(obj);
             }
             
		}
		if(formObj.f_chkprd[1].checked){
			 year  = inputValue.substring(0,4);
			 month = inputValue.substring(4,6);
            if ((ComParseInt(year)>1900)  && (0 < ComParseInt(month) &&  ComParseInt(month) < 13)){
            	setPeriod(obj);
            }
            
		}
	}
}

/*
 * Full / Empty 선택 콤보박스의 F를 선택했을 때에만 Bound 드랍다운 박스가 활성화 - 2011.05.24.
 */
function checkFullEmptyOption(code){ 
	if(code.value=='F'){ 
		document.form.io_bound.value = 'A';
		document.form.io_bound.disabled = false; 
	}else if (code.value=='X'){
		document.form.io_bound.value = 'O'; //Empty+Full Out 일 경우 Bound는 Out으로 고정
		document.form.io_bound.disabled = true; 
	}else{
		document.form.io_bound.value = 'A';
		document.form.io_bound.disabled = true; 
	} 
} 



/*
 * Agmt. Ref. No. 체크박스 선택 시 입력란 활성화
 */
function checkAgmtRefNoOption(){
	if(document.form.agmt_chk.checked == true){
		document.form.agmt_ref_no.disabled = false;
		document.form.agmt_chk.value = "Y";
	} else {
		document.form.agmt_ref_no.value = "";
		document.form.agmt_ref_no.disabled = true;
		document.form.agmt_chk.value = "";
	}
}


/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */
function initCombo(comboObj, comboNo) {
	var i=0;
	//가져온 행을 배열로 반든다.
	    switch(comboObj.id) {

		case "cntr_tpsz":
			with(comboObj) {
			comboObj.DropHeight=400;
			comboObj.MultiSelect = true;
			comboObj.MultiSeparator=",";
			comboObj.UseEdit = false;
			InsertItem(i++,  "ALL",  "ALL");
			InsertItem(i++,  "A4",  "A4");
			InsertItem(i++,  "D2",  "D2");
			InsertItem(i++,  "D4",  "D4");
			InsertItem(i++,  "D5",  "D5");
			InsertItem(i++,  "D7",  "D7");
			InsertItem(i++,  "F2",  "F2");
			InsertItem(i++,  "F4",  "F4");
			InsertItem(i++,  "F5",  "F5");
			InsertItem(i++,  "O2",  "O2");
			InsertItem(i++,  "O4",  "O4");
			InsertItem(i++,  "O5",  "O5");
			InsertItem(i++,  "O7",  "O7");
			InsertItem(i++,  "R2",  "R2");
			InsertItem(i++,  "R5",  "R5");
			InsertItem(i++,  "S2",  "S2");
			InsertItem(i++,  "S4",  "S4");
			InsertItem(i++,  "T2",  "T2");
			InsertItem(i++,  "T4",  "T4");
			comboObj.Code = "ALL";
        	}
			break;  
	}
}

function cntr_tpsz_OnCheckClick(comboObj, index, code) {
	if( code == "ALL" ){
		if( comboObj.CheckIndex(0) == false ){
			comboObj.Code = "ALL";
			comboObj.CheckIndex(0) = false;
		} else{
			comboObj.Code = "ALL";
			comboObj.CheckIndex(0) = true;
		}
	} else{
		comboObj.CheckIndex(0) = false;
	}
}