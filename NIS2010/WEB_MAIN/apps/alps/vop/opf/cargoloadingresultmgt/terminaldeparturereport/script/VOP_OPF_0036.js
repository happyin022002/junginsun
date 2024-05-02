
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0036.js
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation

2009-10-13 일 수정사항.
Tab은 이동가능하고, 이동하면 아무때나 TDR헤더 생성.
script => 먼저 TDR_HeaderSearch()조회.
          없으면, 메세지 박스 표시..
          
BC => 	TDRHeader search이후,
		없으면 Insert
		
* No. Date       Modifier  CSR No.        Content
* 1   2010.06.08 K.H.U                    Reason Validation 누수 수정, COMMAND11-->SEARCHLIST13		
* 2   2010.12.13 P.H.D                    I-Stowage에서 입력한 데이터(Externally Produced)라도 일부 Tab에서 수정 가능하도록 수정     
* 3   2011.04.25 공창식        CHM-201110101   TDR내 Port log 누락시 저장 불가 로직 추가요청
                                          Description : TDR내 Port log의 crane별 시간이 입력되지 않으며 저장되지 않도록 로직 추가 요청건 
* 4   2011.07.28 송호진        CHM-201112556   TDR Rehandling 화면에서 i-Stowage 입력데이터 정합성체크로직 보완요청
* 5   2011.08.16 김민아        CHM-201112982-01   [TDR] R/H의 acct 관련 보완요청 : 모든 Reason에 대하여 Carrier code (3digits)로 선택 또는 입력 가능하도록 수정
                                                                                                                                                    입력값 Validation 보완
* 6   2011.11.07 김민아 	 [CHM-201114250-01]	 TDR내 SKD& Condition Tap 삭제 - TDR Creation 및 Inqiury 메뉴상 Schedule& Condition Tap 삭제 처리
* 7   2012.01.11 김민아      [CHM-201115396-01]  [OPF] TOR Port Log 데이터중 Net Work Hours 계산로직변경
* 8   2012.02.20 김민아      [CHM-201215989-01]  TOR Creation내 Working Time 칼럼 활성화 요청건
* 
* 9   2012.11.13 김영오      [CHM-201221261]  [OPF] Port Log 입력 Validation 보완요청
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
     * @class vop_opf_0036 : vop_opf_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0036() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var gSubTabNo = 0;

var marrTabTitle = new Array("Port Log", "Disch. Vol.", "Load Vol.", "COD", "R/H", "Mishandle", "Slot", "Temp. STWG", "Remark(s)");

var enableButton = new Array(	"btn_first_pilot_on",
								"btn_unberth",
								"btn_anchorage_dep",
								"btn_berth",
								"btn_last_pilot_off",
								"btn_eta_next_date",
								"btn_ExcludefromTPR",
								"btn_Save",
								"btn_Delete",
								"btn_Print",
								"btn_t2AutoCalcu"
							);

//VVD CD 관련 항목들
var strVVDOptions = "vsl_cd|skd_voy_no|skd_dir_cd";
var bRetrive = false;
var bFirst = true;
var bFirstTdrSearch = true;

var sheetCheckEdit = null;

//크래인 정보.
var beforeCraneCnt = 0;

var arrPreCond = new Array("", "", "", "");
var sheetSplit = "|$$|";

var totColor = null;//RgbColor(204, 255, 253);		//기타 색상...
var titColor = null;//RgbColor(229, 234, 255);		//타이틀 색상

var oldLoseTime = "";
var autoCalcuCheck = false;
var popupSheet = null;		//팝업 클릭한 시트.
var popupPrefix = "";
var popupColNm = "";
var checkyDcDFlg = false;	//Pod 체크 

var multiSearchCheck = false;	//Multi Search여부 조회.

// Import BKG data for ref. Button YN
var importDischTotal = false;
var importDischSC = false;
var importDischBB = false;
var importLoadTotalOc = false;
var importLoadTotalIn = false;
var importLoadSC = false;
var importLoadBB = false;

//PopUpEdit Check 
var mCheckValue = false;
var mPopUpEditSheet = null;
var mPopUpEditRow = -1;
var mPopUpEditCol = -1;

//InitCombo Val
var mPodCode = "";
var mPodName = "";
var mLoadPodCode = "";
var mLoadPodName = "";
var mSztpCode = "";
var mSztpName = "";
var mReasonCode = "";
var mReasonName = "";
var mSlotDepRetrive = false;

var arrClptIndSeq = new Array();

var t6sheet1_loopCheck = false;

 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    function processButtonClick(){

		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		
		/*******************************************************/
		var formObject = document.form;

    //	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {

				case "btns_searchVvd":
					var vslcd = getObjValue("vsl_cd");
					var sUrl = "";
					
					if(vslcd == ""){
						sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
					}else{
						sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslcd;
						ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
					}

					break;
				case "btn_first_pilot_on" :
					calenderCall(srcName);
					break;
				case "btn_unberth": 
					calenderCall(srcName);
					break;
				case "btn_anchorage_arr":
					calenderCall(srcName);
					break;
				case "btn_anchorage_dep":
					calenderCall(srcName);
					break;
				case "btn_berth":
					calenderCall(srcName);
					break;
				case "btn_last_pilot_off":
					calenderCall(srcName);
					break;
				case "btn_eta_next_date":
					calenderCall(srcName);
					break;
				case "btn_ExcludefromTPR":
					//formObject.clpt_ind_seq.value = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_call_ind");
					ComOpenPopup("/hanjin/VOP_OPF_0037.do?" + FormQueryString(document.form), 520, 520, "setCallBackPort", "0,0,1,1,1,1,1", true, false);
					break;
				case "btns_searchPort":
					if(document.form.sys_create.value.substring(0, 2) == "In"){
						ComOpenPopup("/hanjin/COM_ENS_051.do", 650, 500, "setCallBackPort", "0,0,1,1,1,1,1", true);
					}
					break;
				case "btn_Retrieve":
					doActionIBSheet(beforetab, formObject, IBSEARCH);
					break;
				case "btn_New":
					tdrScreenNew(formObject, true);
					break;

				case "btn_Delete":
                    formObject.clpt_ind_seq.value = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_call_ind");
					doActionIBSheet(beforetab, formObject, IBDELETE);
					break;
						
				case "btn_Save":
					if(marrTabTitle[beforetab] == "Slot"){
						if(t8frame.document.t8sheet4.Rowcount > 0){
							mSlotDepRetrive = true;
						}
					}
					doActionIBSheet(beforetab, formObject, IBSAVE);
					break;

				case "btn_Print":
					var rdParam = "/rp ["+(formObject.vsl_cd.value)+"]"					// 1.Vessel Code
								   + " ["+(formObject.voy_no.value)+"]"					// 2.Voyage Nu
								   + " ["+(formObject.dir_cd.value)+"]"					// 3.Direction            
								   + " ["+(formObject.port_cd.value)+"]"				// 4.Port Code
								   + " ["+(formObject.yd_cd.Code)+"]"					// 5.Yard Code
                                   + " ["+(formObject.clpt_ind_seq.value)+"]";
                    formObject.com_mrdArguments.value = rdParam; 
 
                    ComOpenRDPopupModal();    
					break;

/** (Tab) [ Port Log ] (S) **/

				case "btn_t2AutoCalcu":
						if(!calcuPortLog(formObject, sheetObject2)){							
						}
						break;

/** (Tab) [ Port Log ] (E) **/



/** (Tab) [ Remark ] (S) **/

				case "btn_t10RowAdd":
						document.form.tdr_info.value = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_info");
						break;
						
/** (Tab) [ Remark ] (E) **/


			} // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowMessage(OBJECT_ERROR);
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
    }


	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		//Disable Button;
		// IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}

		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		initSheetTrans();
		initControl();
		initComboSzTp();
		
		formReadonly(true);
		document.form.vsl_cd.focus();
    }

	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
		if(sheet_obj.id != "sheetTransc"){
			sheetObjects[sheetCnt++] = sheet_obj;
		}
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
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}

	// 업무 자바스크립트 OnKeyUp 이벤트 처리
	function obj_keyup() {
		switch(event.srcElement.name){ 
			case "skd_dir_cd":
				if(getObjValue("skd_dir_cd") != ""){
					searchVVDInfo();	
				}
				break;
			default:
				//obj_nextfocus(event.srcElement);
				ComKeyEnter('LengthNextFocus');
				break;     
		}
	}  
	// 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
	function obj_nextfocus(obj) {
		var objMaxLength = obj.getAttribute("maxlength");
		var objValue = obj.getAttribute("value");
		
		if (ComChkLen(objValue, objMaxLength) == 2) {
			ComSetNextFocus(obj);
		}
	}

	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetObj.id){
			case "t1sheet1":
				with (sheetObj) {
										// 높이 설정
					style.height = 100;
					//전체 너비 설정
					SheetWidth = 50;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle1 = "";

					for(var idxCol = 0; idxCol < 38; idxCol++){
						HeadTitle1 += "|";
					}
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t1sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "first_pilot_on",	false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "anchorage_arr",   false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "berth",           false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "eta_next_port",   false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "eta_next_date",   false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "unberth",         false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "anchorage_dep",   false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "last_pilot_off",  false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_draft_fwd",   false,		"",					dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_draft_aft",   false,		"",					dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_draft_fwd",   false,		"",					dfNullFloat,		 2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_draft_aft",   false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_ballast",     false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_ballast",     false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_rob_fo",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_rob_do",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_rob_fw",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_rob_fo",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_rob_do",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_rob_fw",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_low_sul_fo",  false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_low_sul_do",  false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_low_sul_fo",  false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_low_sul_do",  false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_slp_fo",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_slp_do",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_slp_fw",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_low_sul_fo_wgt",  false,	"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_low_sul_do_wgt",  false,	"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_dwt",         false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_displt",      false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_dwt",         false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_displ",       false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_gm",          false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_gm",          false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "arr_tugboat",     false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "dep_tugboat",     false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "clpt_ind_seq",    false,		"",					dfNone,				0,		false,		false);

					for(var rowIdx = 1; rowIdx <= SaveNameCol(prefix + "last_pilot_off"); rowIdx++){
						if(ColSaveName(rowIdx) != prefix + "eta_next_port"){
							InitUserFormat2(0, rowIdx, "####-##-## ##:##", "-|:" );
						}
					}
				}
				break;

            case "t2sheet1":
                with (sheetObj) {
					// 높이 설정
                    style.height = 190;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "||Work Commenced|Work Completed|Break Down|Meal|Weather|Other|Total|work|crane_no";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t2sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,	false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,					150,	daCenter,	false,		prefix + "crane_desc",	false,		"",				dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix + "work_comm",	true,		"",				dfUserFormat2,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix + "work_comp",	true,		"",				dfUserFormat2,		0,		true,		true);

					InitDataProperty(0, cnt++ , dtData,					115,	daRight,	false,		prefix + "break_down",	false,		"",				dfUserFormat,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					115,	daRight,	false,		prefix + "meal",		false,		"",				dfUserFormat,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					115,	daRight,	false,		prefix + "weather",		false,		"",				dfUserFormat,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					115,	daRight,	false,		prefix + "other",		false,		"",				dfUserFormat,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					110,	daRight,	false,		prefix + "total",		false,		"",				dfUserFormat,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,				110,	daRight,	false,		prefix + "work",		false,		"",				dfUserFormat,		0,		true,		true);

					//Code
					InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	false,		prefix + "crane_no",	false,		"",				dfUserFormat,		0,		true,		true);

					InitUserFormat2(0, prefix + "work_comm", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "work_comp", "####-##-## ##:##", "-|:" );

					InitUserFormat(0,  prefix + "break_down", "###:##", ":" );
					InitUserFormat(0, prefix + "meal", "###:##", ":" );
					InitUserFormat(0, prefix + "weather", "###:##", ":" );
					InitUserFormat(0, prefix + "other", "###:##", ":" );
					InitUserFormat(0, prefix + "total",	"###:##", ":" );
					InitUserFormat(0, prefix + "work",	"###:##", ":" );
					
					totColor = RgbColor(204, 255, 253);		//기타 색상...
					titColor = RgbColor(229, 234, 255);		//타이틀 색상

					//FrozenRows = 2;
				}
				break;

			case "sheetTdrH":
                with (sheetObj) {

                    style.height = 102;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|VSL_CD|VOY_NO|DIR_CD|PORT_CD|CALL_IND|TML_CD|TDR_DATE|TDR_USER|NIS_DATE|COMMENCE|COMPLETE|GROSS_WORK|NET_WORK|LOSE_HR|GROSS_GANG|NET_GANG|MVS|NET_TML|GROSS_TML|NET_GC|GROSS_GC|REMARK|HATCH|CON|PILOT_ARR|PILOT_DEP|ANCHOR_ARR|ANCHOR_DEP|BERTH|UNBERTH|DRAFT_FWD_ARR|DRAFT_FWD_DEP|DRAFT_AFT_ARR|DRAFT_AFT_DEP|BALLAST_ARR|BALLAST_DEP|ROB_FO_ARR|ROB_FO_DEP|ROB_DO_ARR|ROB_DO_DEP|ROB_FW_ARR|ROB_FW_DEP|BUNKER_FO_ARR|BUNKER_FO_DEP|BUNKER_DO_ARR|BUNKER_DO_DEP|BUNKER_FW_ARR|BUNKER_FW_DEP|DWT_ARR|DWT_DEP|DISPL_ARR|DISPL_DEP|GM_ARR|GM_DEP|TUG_ARR|TUG_DEP|ETA|ETA_CANAL|INFO|UPDATE_USER|UPDATE_TIME|SULPHUR_FO_ARR|SULPHUR_FO_DEP|SULPHUR_DO_ARR|SULPHUR_DO_DEP|SUPPLY_SULPHUR_FO|SUPPLY_SULPHUR_DO|UPDATE_SYS|NEXT_PORT|NEXT_PORT_DT|NEXT_CANAL|NEXT_CANAL_DT|EXISTS_TML_DEP_RPT_DTL";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

					var prefix = "sheetTdrH_"; 
					InitDataProperty(0, cnt++ , dtHiddenStatus,			    30,		daCenter,	false,		prefix  +	"ibflag");
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"vsl_cd",				false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"voy_no",               false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"dir_cd",               false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"port_cd",              false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"call_ind",             false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"tml_cd",               false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"tdr_date",             false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"tdr_user",             false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"nis_date",             false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"commence",             false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"complete",             false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gross_work",           false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"net_work",             false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"lose_hr",              false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gross_gang",           false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"net_gang",             false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"mvs",                  false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"net_tml",              false,		"",					dfFloat,			1,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gross_tml",            false,		"",					dfFloat,			1,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"net_gc",               false,		"",					dfFloat,			1,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gross_gc",             false,		"",					dfFloat,			1,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"remark",               false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"hatch",                false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"con",                  false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"pilot_arr",            false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"pilot_dep",            false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"anchor_arr",           false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"anchor_dep",           false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"berth",                false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"unberth",              false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"draft_fwd_arr",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"draft_fwd_dep",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"draft_aft_arr",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"draft_aft_dep",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"ballast_arr",          false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"ballast_dep",          false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_fo_arr",           false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_fo_dep",           false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_do_arr",           false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_do_dep",           false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_fw_arr",           false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_fw_dep",           false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_fo_arr",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_fo_dep",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_do_arr",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_do_dep",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_fw_arr",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_fw_dep",        false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"dwt_arr",              false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"dwt_dep",              false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"displ_arr",            false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"displ_dep",            false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gm_arr",               false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gm_dep",               false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"tug_arr",              false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"tug_dep",              false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"eta",                  false,		"",					dfUserFormat2,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"eta_canal",            false,		"",					dfUserFormat2,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"info",                 false,		"",					dfNone,					0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"sulphur_fo_arr",       false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"sulphur_fo_dep",       false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"sulphur_do_arr",       false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"sulphur_do_dep",       false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"supply_sulphur_fo",    false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"supply_sulphur_do",    false,		"",					dfNullFloat,			2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"update_sys",           false,		"",					dfNone,					0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"next_port",            false,		"",					dfNone,					0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"next_port_dt",         false,		"",					dfUserFormat2,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"next_canal",           false,		"",					dfNone,					0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"next_canal_dt",        false,		"",					dfNone,					0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"used_crane",			false,		"",					dfNone,					0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"avg_gang",				false,		"",					dfNone,					2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"exists_tml_dep_rpt_dtl",false,		"",					dfNone,					0,		false,		false);

					for(var rowIdx = SaveNameCol(prefix + "pilot_arr"); rowIdx <= SaveNameCol(prefix + "unberth"); rowIdx++){
						InitUserFormat2(0, rowIdx, "####-##-## ##:##", "-|:" );
					}
					InitUserFormat2(0, prefix + "next_port_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "eta", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "eta_canal", "####-##-## ##:##", "-|:" );
				}
				
				break;

		}
	}

	/**
	* IBSheet 초기화. <br>
	**/
	function sheetInitTotal(sheetObj){
		var cnt = 0;
		with (sheetObj) {
			// 높이 설정
			style.height = 360;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			if(sheetObj.id == "t3sheet1"){
				InitRowInfo(3, 1, 3, 100);
			}else{
				InitRowInfo(2, 1, 3, 100);
			}

			var cellCol = "";	
			var prefix = "";	
			var HeadTitle1 = "";
			var HeadTitle2 = "";
			var HeadTitle3 = "";
			var subTitle1 = (sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2" ? "Outbound" : "Inbound");

			if(sheetObj.id == "t3sheet1"){
				cellCol = "full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|full_bo_dx|full_ts_20|full_ts_2h|full_ts_40|full_ts_4h|full_ts_45|full_ts_dx|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|et_bo_dx|et_ts_20|et_ts_2h|et_ts_40|et_ts_4h|et_ts_45|et_ts_dx|wt_20|wt_2h|wt_40|wt_4h|wt_45|wt_dx";
			}else{
				cellCol = "full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|full_bo_dx|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|et_bo_dx|wt_20|wt_2h|wt_40|wt_4h|wt_45|wt_dx";
			}
			prefix = sheetObj.id + "_";
			
			if(sheetObj.id == "t3sheet1"){
				HeadTitle1 = "|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
				HeadTitle2 = "|Sel.|Operator|POD|idx_Sheet|chk_valid|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo| | | | | | |";
				HeadTitle3 = "|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX";
			}else{
				HeadTitle1 = "|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
				HeadTitle2 = "|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX";
			}

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			if(sheetObj.id == "t3sheet1"){
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				InitHeadRow(2, HeadTitle3, true);
			}else{
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
			}

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix + "del_chk",			false,		"",					dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtPopupEdit,	80,		daCenter,	true,		prefix + "opr_cd",			true,		"",					dfEngUpKey,	0,		false,		true,  4);
			
			//POD는 Inbound의 경우는 상위조회조건의 Port와 같기 때문에. POD를 입력할 필요가 없지만...
			//Outbound의 경우 Pod는 입력...
			if(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2"){
				InitDataProperty(0, cnt++ , dtComboEdit,	65,		daCenter,	true,		prefix + "pod_cd",			true,		"",					dfEngUpKey,	0,		false,		true, 5);
			}else{
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix + "pod_cd",			false,		"",					dfNone,		0,		false,		true);
			}
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix + "idx_sheet",		false,		"",					dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix + "chk_valid",		false,		"",					dfNone,		0,		true,		true);
			
			var arrCol = cellCol.split("|");
			
			if(sheetObj.id == "t3sheet1"){
				for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
					//5자리는 Weight입니다. Float
					if(arrCol[idxCol].length == 5)
						InitDataProperty(0, cnt++ , dtAutoSumEx,			60,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullFloat,	1,		true,		true,		7);
					else
						InitDataProperty(0, cnt++ , dtAutoSumEx,			40,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullInteger,	0,		true,		true,		4);
				}
			}else{
				for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
					//5자리는 Weight입니다. Float
					if(arrCol[idxCol].length == 5)
						InitDataProperty(0, cnt++ , dtAutoSumEx,			60,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullFloat,	1,		true,		true,		7);
					else
						InitDataProperty(0, cnt++ , dtAutoSumEx,			50,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullInteger,	0,		true,		true,		4);
				}
			}
			if(sheetObj.id == "t3sheet1"){
				FrozenCols = 3;
			}
			InitDataValid(0, prefix + "opr_cd", vtEngUpOnly);
			InitDataValid(0, prefix + "pod_cd", vtEngUpOnly);
		}
	}
	
	function sheetInitSC(sheetObj){
		var cnt = 0;
		with (sheetObj) {
								// 높이 설정
			style.height = 360;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(3, 1, 3, 100);

			var HeadTitle1 = "|Sel.|Operator|POD|idx_sheet|DG Cargo|DG Cargo|DG Cargo|DG Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo";
			var HeadTitle2 = "|Sel.|Operator|POD|idx_sheet|Quantity|Quantity|Weight(Ton)|Weight(Ton)|Quantity|Quantity|Weight(Ton)|Weight(Ton)|Quantity|Quantity|Weight(Ton)|Weight(Ton)";
			var HeadTitle3 = "|Sel.|Operator|POD|idx_sheet|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);
			var cellCol = "dg_20_qty|dg_40_qty|dg_20_wgt|dg_40_wgt|rf_20_qty|rf_40_qty|rf_20_wgt|rf_40_wgt|ak_20_qty|ak_40_qty|ak_20_wgt|ak_40_wgt";
			var prefix = sheetObj.id + "_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix + "del_chk",			false,		"",			dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtPopupEdit,	80,		daCenter,	true,		prefix + "opr_cd",			true,		"",			dfEngUpKey,	0,		false,		true, 4);
			
			//POD Discharge에서는 POD그냥 Readonly 세팅.
			if(id == "t3sheet2")
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix + "pod",				false,		"",			dfEngUpKey,	0,		false,		false, 5);
			else
				InitDataProperty(0, cnt++ , dtComboEdit,	80,		daCenter,	true,		prefix + "pod",				true,		"",			dfEngUpKey,	0,		true,		true, 5);

			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix + "idx_sheet",		false,		"",			dfNone,		0,		true,		true);

			var arrCol = cellCol.split("|");
			
			for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
				if(idxCol % 4 == 0 || idxCol % 4 == 1)
					InitDataProperty(0, cnt++ , dtAutoSumEx,			65,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullInteger,	0,		true,		true,		4);
				else
					InitDataProperty(0, cnt++ , dtAutoSumEx,			65,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullFloat,	1,		true,		true,		7);
			}
		}
	}
	
	function sheetInitBreakBulk(sheetObj){
		var cnt = 0;
		with (sheetObj) {
			style.height = 360;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			//Unit|
			var HeadTitle1 = "|Sel.|POD|Dimension (L X W X H)|Dimension (L X W X H)|Dimension (L X W X H)|Slot|Weight (Ton)|Crane Type|Working Time|Working Time|Operator|Container No.|cod_chk";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			var prefix = sheetObj.id + "_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	false,		prefix + "del_chk",		false,		"",					dfNone,			0,		true,		true);
			
			if(id == "t3sheet3")
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		prefix + "pod",			true,		"",					dfEngUpKey,		0,		false,		false,	5);
			else
				InitDataProperty(0, cnt++ , dtComboEdit,	80,		daCenter,	false,		prefix + "pod",			true,		"",					dfEngUpKey,		0,		true,		true,	5);

			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,		prefix + "dml",			false,		"",					dfNullInteger,	0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,		prefix + "dmb",			false,		"",					dfNullInteger,	0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,		prefix + "dmh",			false,		"",					dfNullInteger,	0,		true,		true,	4);
			
			//InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,		prefix + "unit",		false,		"",					dfNullInteger,	0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,		prefix + "slot",		false,		"",					dfNullInteger,	0,		true,		true,	2);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,		prefix + "weight",		false,		"",					dfNullFloat,	1,		true,		true,	7);
			InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	false,		prefix + "crane",		false,		"",					dfNone,			0,		true,		true);
			
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix + "commence",	false,		"",					dfUserFormat2,	0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix + "complete",	false,		"",					dfUserFormat2,	0,		true,		true);
			InitDataProperty(0, cnt++ , dtPopupEdit,	80,		daCenter,	false,		prefix + "opr_cd",		true,		"",					dfEngUpKey,		0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		prefix + "cntr_no",		true,		"",					dfEngUpKey,		0,		true,		true,	13);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	false,		prefix + "cod_chk",		false,		"",					dfNone,			0,		true,		true);
			
			InitDataCombo(0, prefix + "crane", "G/Crane|F/Crane", "G|F");
			InitUserFormat2(0, prefix + "commence", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix + "complete", "####-##-## ##:##", "-|:" );

			InitDataValid(0, prefix + "cntr_no", vtEngUpOther, "1234567890");

		}
	}

	function initSheetTrans(){
		var cnt = 0;
		with (document.sheetTransc) {
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		}
	}
	/**
	* IBCOMBO 초기화. <br>
	**/
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "yd_cd":
				var i=0;
				with(comboObj) {
					BackColor = "#CCFFFF";
					DropHeight = 200;
					MultiSelect = false;
					MaxSelect = 1;
					
                    UseAutoComplete = true;    
                    ValidChar(2,0);
				}
				
				break;
		}
	} 

	/**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
			case 1:
                with (tabObj) {
                    var cnt  = 0 ;
					for(; cnt < marrTabTitle.length; cnt++){
						InsertTab(cnt, marrTabTitle[cnt], -1);
					}
			}
            break;
        }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tabTdr_OnChange(tabObj , nItem){
    	 
		if(bFirst){
			var objs = document.all.item("tabLayer");

			objs[nItem].style.display 		= "Inline";
			objs[beforetab].style.display 	= "none";

			//--------------- 요기가 중요 --------------------------//
			objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
			//------------------------------------------------------//
			beforetab	= nItem;
		}
		bFirst = false;
		
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
	 */
    function tabTdr_OnClick(tabObj , nItem){
		var formObject = document.form;
		if(nItem == beforetab){
			return;
		}

		multiSearchCheck 	= false;
		var changeSheet 	= false;
		var oldIdxTab 		= beforetab;

		if(bRetrive){
			
			//Tab클릭시 Skd_Condi가 새로 생성되는 TDR이면 자동저장.
			if(document.form.sys_create.value.toUpperCase().substring(0, 2) == "IN"){
				if(beforetab == 0){
					if(document.sheetTdrH.RowCount > 0){
						setTdrHeaderVal2(document.form, sheetCheckEdit[0]);
					}
				}

				for(var cnt = 0; cnt < sheetCheckEdit.length; cnt++){
					if(
						(
							parseInt(sheetCheckEdit[cnt].RowCount("I")) + 
							parseInt(sheetCheckEdit[cnt].RowCount("U")) + 
							parseInt(sheetCheckEdit[cnt].RowCount("D"))
						) 
						> 0
					){
							changeSheet = true;
							break;
					}
				}

				//Sheet에 변경된 내용이 있을시에...
				if(changeSheet){
					//Sheet에 체크되는 사항이 있을때...
					if(ComShowCodeConfirm("COM130504", marrTabTitle[beforetab])){
						if(marrTabTitle[beforetab] == "Disch. Vol." || marrTabTitle[beforetab] == "Load Vol." || marrTabTitle[beforetab] == "Slot"){
							if(!multiInputCheck()){
								return;
							}
							
							if(!dupcheckSave(marrTabTitle[beforetab], true)){
								return;
							}
						}else {
							var sParam = ComGetSaveString(sheetCheckEdit);
							
							if(sParam == ""){
								//Mishandle 일때...
								if(marrTabTitle[beforetab] == "Mishandle"){
									var shtObj = sheetCheckEdit[1];
									var prefix = sheetCheckEdit[1].id + "_";
									//Sheet를 돌면서. 필수조건이 아님놈을 검색한다.
									for(var idxRow = shtObj.HeaderRows; idxRow <= shtObj.LastRow; idxRow++){
										//만약 조회나 삭제가 아니면.
										if(shtObj.RowStatus(idxRow) != "R" && shtObj.RowStatus(idxRow) != "D"){
											var objFrm7 = t7frame.document.form;
											//필수 체크
											if( shtObj.CellValue(idxRow, prefix + "cntr_no") == "" || shtObj.CellValue(idxRow, prefix + "opr_cd") == "" ){
												for(var cnt = 0; cnt < objFrm7.misDischLoad.length; cnt++){
													if(objFrm7.misDischLoad[cnt].value == shtObj.CellValue(idxRow, prefix + "mishandle_chk") ){
														objFrm7.misDischLoad[cnt].checked = true;
														filterMishandle(shtObj, objFrm7.misDischLoad[cnt].value);
														break;
													}
												}
											}
										}
									}
								}

								return;
							}
							
							//MisHandle일때. 
							if(marrTabTitle[beforetab] == "R/H"){
								if(!checkExcelValidate()){
									tabObjects[0].SelectedIndex = beforetab;
									return;
								}
							}

							if(!dupcheckSave(marrTabTitle[beforetab], true)){
								return;
							}
						}
						doActionIBSheet(beforetab, formObject, IBSAVE);
					}else{
						document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "R";
						
						//취소를 선택시에.
						for(var cnt = 1; cnt < sheetCheckEdit.length; cnt++){
							sheetCheckEdit[cnt].RemoveAll();
						}
						
						if(beforetab == 0){
							
							var sheetObj = document.sheetTdrH;
							document.form.f_cmd.value = SEARCHLIST04;
							var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheetTdrH_"));

							sheetObj.Redraw = false;
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.Redraw = true; 
						}

						changeSheet = false;
					}
				}
			}
		}

		//처음탭이 아니면. 패스..............
		if(bFirst){
			sheetRemoveAll();
		}

		//변경될만한 Sheet의 객체를 저장한다.
		var objs = document.all.item("tabLayer");

		objs[nItem].style.display 		= "inline";
		objs[beforetab].style.display 	= "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//

		beforetab	= nItem;
		
		//2010.12.20 P.H.D 기본적으로 Internally일 때만 Editable하고 특정 Tab인 경우는 Externally여도 Editable하다. 
		var updateSys = (document.form.sys_create.value == "" ? "NU" : document.form.sys_create.value).toUpperCase().substring(0,2);
		var bReadOnly = (updateSys == "IN" ? false : true);
		
		formReadonly(bReadOnly); //2010.12.20 P.H.D. 추가
		
		switch(marrTabTitle[nItem]) {
			case "Disch. Vol.":
				var frame = document.getElementById("t3frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_3.do?btnDis=Y";
					return;
				}
				break;
			case "Load Vol.":
				var frame = document.getElementById("t4frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_4.do?btnDis=Y";
					return;
				}
				break;
			case "COD":
				formReadonly(updateSys == "NU"? true : false); //2010.12.20 P.H.D. 추가	
				var frame = document.getElementById("t5frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_5.do?btnDis=Y";
					return;
				}
				break;
			case "R/H":
				formReadonly(updateSys == "NU"? true : false); //2010.12.20 P.H.D. 추가	
				var frame = document.getElementById("t6frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_6.do?btnDis=Y";
					return;
				}
				break;
			case "Mishandle":
				formReadonly(updateSys == "NU"? true : false); //2010.12.20 P.H.D. 추가	
				var frame = document.getElementById("t7frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_7.do?btnDis=Y";
					return;
				}
				break;
				
			case "Slot":
				//formReadonly(readOnly); //2010.12.20 P.H.D. 추가
				var frame = document.getElementById("t8frame");
				if(frame.src != ""){					
					frameButtonSheetSub(document.t8frame, gSubTabNo);
				}else{
					formReadonly(updateSys == "NU"? true : false); //2010.12.20 P.H.D. 추가	
				}
				
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_8.do?btnDis=Y";
					return;
				}
				break;
			case "Temp. STWG":
				formReadonly(updateSys == "NU"? true : false); //2010.12.20 P.H.D. 추가	
				var frame = document.getElementById("t9frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_9.do?btnDis=Y";
					return;
				}
				break;
				
			case "Remark(s)":
				formReadonly(updateSys == "NU"? true : false); //2010.12.20 P.H.D. 추가	
				break;
		}		
		
		setTabEditSheet();
		
		if(bRetrive){
			if(marrTabTitle[beforetab] == "Disch. Vol." || marrTabTitle[beforetab] == "Load Vol." || marrTabTitle[beforetab] == "Slot"){
				if(marrTabTitle[beforetab] == "Disch. Vol."){
					t3frame.document.form.chk_DischVol.checked = true;
					t3frame.disChargTabChange(changeSheet);
				}else if(marrTabTitle[beforetab] == "Load Vol."){
					t4frame.document.form.chk_LoadVol.checked = true;
					
					/**
					 * Load Vol. 탭의 Break-Bulk 시트 "Save" 버튼 활성화
					 */
					//::jsk::
					
/*					alert('start');
					alert('1 ==> '+document.t4frame);
					alert('2 ==> '+t4frame.document.form.chk_LoadVol[3].checked); //t4frame.document.form.chk_LoadVol[3].checked	
					
					var updateSys	= document.form.sys_create.value.toUpperCase().substring(0,2);*/
					
					/* Load Vol. 탭의 Break-Bulk 시트 Work Time 컬럼 컨트롤 */
					////if(updateSys == 'EX' && objFrame.sheetObjects[idx].id == 't4sheet4'){
						
						//::jsk::
						/*
						 * Externally + Load Vol. 탭 + Break-Bulk 시트 "Save"버튼 활성화
						 */
		/*				if(t4frame.document.form.chk_LoadVol[3].checked == true){
							parent.ComBtnEnable("btn_Save");
						}else{
							parent.ComBtnDisable("btn_Save");
						}*/						
					
/*					if(updateSys == 'EX' && t4frame.document.form.chk_LoadVol[3].checked == true){
						ComBtnEnable("btn_Save");
					}*/
					

					
					
					t4frame.disLoadTabChange(changeSheet);
				}else if(marrTabTitle[beforetab] == "Slot"){
					t8frame.document.form.chk_Slot.checked = true;
					t8frame.disSlotTabChange(changeSheet);
				}

				doActionIBSheetMulti(beforetab, document.form);
			}else{
				if(changeSheet){
					setTimeout("tabTdr_OnClickExec(" + oldIdxTab + ", "+ nItem + ")", 100 );
					doActionIBSheet(beforetab, document.form, IBSEARCH);
				}else{
					doActionIBSheet(beforetab, document.form, IBSEARCH);
				}
			}
		}else{
			document.form.vsl_cd.focus();
		}
		
		topSync();
		
		//::jsk::2012-02-14 Load Vol. 탭일경우에만 실행.
		/*
		 * formReadonly에서 비활성화된 Load Vol.탭 Break-Bulk 시트의 셀속성 및 버튼 컨트롤처리. 
		 */
		if(nItem == '2'){	
			fncLoadVolBBSheetCellControl();
		}		
		
    }
     
 	/**
      * Loading Vol. 탭에서 Break Bulk 시트(radio) 선택시에만 Save버튼 활성화 시킨다.
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
/*  	function fncLoadVolExternalSaveBtnDisabled(){
      	//::JSK:: document.form.sys_create.value.toUpperCase().substring(0,2)
      	//alert(parent.document.form.sys_create.value);
  		if(document.form.chk_LoadVol[3].checked == true){
  			parent.ComBtnEnable("btn_Save");
  		}else{
  			parent.ComBtnDisable("btn_Save");
  		}
  	}*/     

	function tabTdr_OnClickExec(beforetab, idx){
		var objs = document.all.item("tabLayer");

		objs[idx].style.display = "none";
		objs[idx].style.display = "inline";
		objs[idx].style.zIndex = objs[beforetab].style.zIndex -1 ;
	}

	function topSync(){
		if(!bRetrive){
			document.form.vsl_cd.focus();
		}
		top.syncHeight();
	}

    /**
    * 초기 이벤트 등록 
    */
    function initControl() {
		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerForm	("keyup",			'obj_keyup',		form);	
        axon_event.addListenerFormat('focus',			'obj_activate',		form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',        'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리

		axon_event.addListener('keypress', 'slan_cd_onkeypress', 'slan_cd', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('keyup', 'slan_cd_onkeyup', 'slan_cd', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('blur', 'used_crane_onblur', 'used_crane', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('blur', 'tdr_info_onchange', 'tdr_info', '');			//Port Cd변경시에 처리되는 로직...

		//ssss
    	axon_event.addListener('change', 'vsl_cd_onchange', 'vsl_cd', '');				//Vsl_cd변경시.
    	axon_event.addListener('change', 'skd_voy_no_onchange', 'skd_voy_no', '');				//Vsl_cd변경시.

		//Port Log 
		axon_event.addListener('keypress', 'gross_work_keypress', 'gross_work', '');	
		axon_event.addListener('blur', 'gross_work_onblur', 'gross_work', '');			
		axon_event.addListener('keypress', 'net_work_keypress', 'net_work', '');		
		axon_event.addListener('blur', 'net_work_onblur', 'net_work', '');				
		axon_event.addListener('keypress', 'lost_time_keypress', 'lost_time', '');		
		axon_event.addListener('blur', 'lost_time_onblur', 'lost_time', '');			
		axon_event.addListener('keypress', 'gross_gang_keypress', 'gross_gang', '');	
		axon_event.addListener('blur', 'lost_time_onblur', 'gross_gang', '');			
		axon_event.addListener('keypress', 'net_gang_keypress', 'net_gang', '');	
		axon_event.addListener('blur', 'net_gang_onblur', 'net_gang', '');			
		//axon_event.addListener('change', 'move_handl_onchange', 'move_handl', '');			
	}
	
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        /*ComClearSeparator(event.srcElement);

		if(event.srcElement.dataformat != "ymdhm"){
			event.srcElement.select();
		}*/

		if(event.srcElement.name == "vsl_cd" || event.srcElement.name == "skd_voy_no" || event.srcElement.name == "skd_dir_cd"){
			event.srcElement.select();
		}else if(event.srcElement.name == "hatch_handl" || event.srcElement.name == "gear_handl"  ){
			if(document.form.sys_create.value.toUpperCase().substring(0, 2) == "IN"){
				ComClearSeparator(event.srcElement);
				event.srcElement.select();
			}
			if(event.srcElement.name == "hatch_handl"){
				ComShowCodeMessage("OPF50043");
			}
		}
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		ComChkObjValid(event.srcElement);
		/*var objName = event.srcElement.name;
		if(sheetObjects[0].SaveNameCol("t1sheet1_" + objName) > 0){
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "t1sheet1_" + objName) = event.srcElement.value;
		}*/
	}
	

	/**
	 * 조회조건 입력시 Validation <br>
	 **/
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				switch(event.srcElement.name){
					case "vsl_cd":	
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;
					case "skd_voy_no":	
						//숫자입력하기
						ComKeyOnlyNumber(event.srcElement);
						break;
					case "skd_dir_cd":	
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "vsl_opr_tp_cd":	
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
				}
				break;
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ymdhm":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
				ComKeyOnlyNumber(event.srcElement, "-.");
				break;

			default:
				//공통기준:영문, 숫자만을 인식
				ComKeyOnlyAlphabet("num");
				break;     
		}

		if(event.KeyCode == 13){
			ComSetNextFocus(event.srcElement);
		}
	}
	
	/**
	 * VVD 정보 조회 <br>
	 **/
	function searchVVDInfo() {
		var formObj = document.form;
		
		formObj.f_cmd.value = SEARCH06;
		var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj)); 	   	

		//VVD 정보 관련 항목 셋팅
		setVVDInfo(formObj, sXml);
	}

	/**
	 * VVD 정보 관련 항목 셋팅 : VVD, Lane, Vessel Operator
	 */
	function setVVDInfo(formObj, sXml) { 	 
		var vvdData = ComOpfXml2Array(sXml, strVVDOptions);
		
		if(vvdData == null) {
			ComShowCodeMessage("COM132201", "VVD CD");
			initObjs("form", formObj, strVVDOptions, 0, "");
		}else{
			if(vvdData.length > 1) {
				ComShowCodeMessage("COM132201", "VVD CD");
				initObjs("form", formObj, strVVDOptions, 0, "");
			} else {
				formObj.f_cmd.value = SEARCH05;
				var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));
				var sClptIndSeq = ComGetEtcData(sXml, "strClptIndSeq");
				arrClptIndSeq = sClptIndSeq.split("|");	
				//alert(arrClptIndSeq[0]);
				ComOPFXml2ComboItem(sXml, comboObjects[0], "val", "name");
				sheetObjects[0].Index = 1;
				//포커스 이동
				ComSetFocus(document.all.item("yd_cd"));
			}
		}
	}

	/**
	 * Get Object Value
	 */
	function getObjValue(name) {
		return ComGetObjValue(eval("document.form."+name));
	}

	/**
	 * Set Object Value
	 */
	function setObjValue(name, value) {
		ComSetObjValue(eval("document.form."+name), value);
	}

    function setObjValueFmt(name, value) {
        var eObj = eval("document.form."+name);
        if( eObj.getAttribute("dataformat") == "float" ){
 
            value = ComAddComma(tdrRoundNull( value,3));
            eObj.value =  value;
        }else{
            ComSetObjValue(eval("document.form."+name), value);
        }
    }
	/**
	 * 선택된 Object의 초기화와 포커스 이동
	 */
	function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
		var nameArrs = nameVars.split("|");
		
		for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
			
			if(type == 'sheet') 
				sheetObj.CellValue2(etcVal, prefixs[0]+nameArrs[objIdx]) = "";
			else 
				ComClearObject(eval("document.form." + nameArrs[objIdx]));
			
			if(focusIdx == objIdx) {
				if(type == 'sheet') 
					sheetObj.SelectCell(etcVal, focusIdx);
				else 
					ComSetFocus(document.all.item(nameArrs[objIdx]));
			}
		}
	}

    function doActionIBSheet(tabIdx, formObj, sAction) {
    	switch(sAction) {
			case IBSEARCH:		//조회
				if(validateForm(formObj,sAction)){
					var sheetObjSkd = document.t1sheet1;

					/*
						Tdr헤더 여부 없을시에 TDR헤더.
					*/
					if(document.sheetTdrH.RowCount < 1){
						tdrHeaderSearch(formObj);
					}
 
					switch(marrTabTitle[tabIdx]){
						case "Port Log":
							var sheetObj = document.t2sheet1;
							var prefix = "t2sheet1_";
							
							with(sheetObj){
								formObj.f_cmd.value = SEARCH02;
								var sXml = GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_"));
								Redraw = false;    
								WaitImageVisible = false;	
								LoadSearchXml(sXml); 
								Redraw = true; 
								
								DataInsert(0);
								
								for(var idxRow = HeaderRows; idxRow <= LastRow; idxRow++){
									if(idxRow == HeaderRows){
										CellValue2(idxRow, prefix + "crane_desc") = "Terminal Working Time";
										CellValue2(idxRow, prefix + "work_comm") = ComGetEtcData(sXml, "commence");
										CellValue2(idxRow, prefix + "work_comp") = ComGetEtcData(sXml, "complete");

										CellEditable(idxRow, prefix + "work_comm") = false;
										CellEditable(idxRow, prefix + "work_comp") = false;
										CellEditable(idxRow, prefix + "break_down") = false;
										CellEditable(idxRow, prefix + "meal") = false;
										CellEditable(idxRow, prefix + "weather") = false;
										CellEditable(idxRow, prefix + "other") = false;
										CellEditable(idxRow, prefix + "total") = false;
										
									}else{
										//CellValue(idxRow, prefix + "crane_desc") = (idxRow - 1) + " G/Crane";
						                if( formObj.sys_create_desc.value.indexOf("Ext")>-1 ){
						                    sheetObj.CellValue(idxRow, prefix + "crane_desc") = sheetObj.CellValue(idxRow, prefix + "crane_no")  + " G/Crane";   
						                }else{//
						                    CellValue(idxRow, prefix + "crane_desc") = (idxRow - 1) + " G/Crane";
						                }
						                
										CellBackColor(idxRow, prefix + "work") = titColor;
									}
									CellBackColor(idxRow, prefix + "crane_desc") = totColor;
									RowStatus(idxRow) = "R";
								}

								beforeCraneCnt = RowCount - 1;
								getTdrHeaderVal2(formObj, document.sheetTdrH, sXml);
							}

							break;
						case "Disch. Vol.":
log("multiSearchCheck : "  + multiSearchCheck);
							if(t3frame.beforeDistchVolTab == 0){
								formObj.f_cmd.value = SEARCH03;
								formObj.status1.value = "LM";
								formObj.status2.value = "";
							}else if(t3frame.beforeDistchVolTab == 1){
								formObj.f_cmd.value = SEARCH04;
								formObj.sc_status1.value = "DS";
								formObj.sc_status2.value = "DG";
								formObj.sc_status3.value = "";
							}else if(t3frame.beforeDistchVolTab == 2){
								formObj.f_cmd.value = SEARCH05;
								formObj.sc_status1.value = "DS";
								formObj.sc_status2.value = "DG";
								formObj.sc_status3.value = "";
							}
							if(multiSearchCheck){ 
								var sheetObj = t3frame.sheetObjCur(); //t3frame.document.all.item("t3sheet" + (t3frame.beforeDistchVolTab + 1));
								var prefix = "t3sheet" + (t3frame.beforeDistchVolTab + 1) + "_"

								var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

								sheetObj.Redraw = false;    
								sheetObj.WaitImageVisible = false;	
								sheetObj.LoadSearchXml(sXml); 
								sheetObj.Redraw = true; 

								//정상적으로 호출이후에 상태를 변경시켜 준다.
								if(t3frame.beforeDistchVolTab == 0){
									importDischTotal = false;
								}else if(t3frame.beforeDistchVolTab == 1){
									importDischSC = false;
								}else if(t3frame.beforeDistchVolTab == 2){
									importDischBB = false;
								}
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}

							break;
							
						case "Load Vol.":
							if(t4frame.beforeLoadVolTab == 0){
								formObj.f_cmd.value = SEARCH06;
								formObj.status1.value = "LM";
								formObj.status2.value = "OT";
							}else if(t4frame.beforeLoadVolTab == 1){
								formObj.f_cmd.value = SEARCH17;
								formObj.status1.value = "LI";
								formObj.status2.value = "LT";
							}else if(t4frame.beforeLoadVolTab == 2){
								if(document.form.sys_create.value.substring(0, 2) == "In"){
									formObj.f_cmd.value = SEARCH04;

									formObj.sc_status1.value = "LS";
									formObj.sc_status2.value = "ST";
									formObj.sc_status3.value = "";
								}else{
									formObj.f_cmd.value = SEARCH15;

									formObj.sc_status1.value = "LS";
									formObj.sc_status2.value = "ST";
								}
							}else if(t4frame.beforeLoadVolTab == 3){
								formObj.f_cmd.value = SEARCH05;
								formObj.sc_status1.value = "LS";
								formObj.sc_status2.value = "";
								formObj.sc_status3.value = "";
							}

							if(multiSearchCheck){
								var sheetObj = t4frame.sheetObjCur();  //t4frame.document.all.item("t4sheet" + (t3frame.beforeDistchVolTab + 1));
								var prefix = "t4sheet" + (t4frame.beforeLoadVolTab + 1) + "_"

								var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

								sheetObj.Redraw = false;    
								sheetObj.WaitImageVisible = false;	
								sheetObj.LoadSearchXml(sXml); 
								sheetObj.Redraw = true; 
								
								//조회이후에는 정상적인 포멧으로.
								if(t4frame.beforeLoadVolTab == 0){
									importLoadTotalOc = false;
								}else if(t4frame.beforeLoadVolTab == 1){
									importLoadTotalIn = false;
								}else if(t4frame.beforeLoadVolTab == 2){
									importLoadSC = false;
								}else if(t4frame.beforeLoadVolTab == 3){
									importLoadBB = false;
								}
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}
 
							break;
						case "COD":
							formObj.f_cmd.value = SEARCH07;
							var sheetObj = t5frame.document.all.item("t5sheet1"); //document.t5sheet1;

							var prefix = "t5sheet1_";
							var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.Redraw = true; 
						
							break;
						case "R/H":
							formObj.f_cmd.value = SEARCH08;
							var sheetObj = t6frame.document.all.item("t6sheet1"); //document.t5sheet1;

							var prefix = "t6sheet1_";
							var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.Redraw = true; 
						
							break;
						case "Mishandle":
							formObj.f_cmd.value = SEARCH09;
							//var sheetObj = t7frame.document.all.item("t7sheet1"); //document.t5sheet1;
							var sheetObj = t7frame.document.all.t7sheet1;  
 
							var prefix = "t7sheet1_";
							
                            var formObject   = document.form;
                            var mishandlechk = formObject.misHandleChk.value;

                            var param        = FormQueryString(formObject)+"&mishandlechk="+mishandlechk + "&" + ComGetPrefixParam(prefix);
							var sXml         = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", param );

							//sheetObj.Redraw = false;    
							//sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							//sheetObj.Redraw = true; 
 
							filterMishandle(sheetObj, formObj.misHandleChk.value);

							 
		                    for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
		                        if( !sheetObj.RowHidden(idxRow)  ){
		                            sheetObj.SelectRow =  idxRow;
		                            break;
		                        }                   
		                    }
							break;
						case "Slot":
							if(t8frame.beforeSlotTab == 0){
								formObj.f_cmd.value = SEARCH10;
							}else if(t8frame.beforeSlotTab == 1){
								formObj.f_cmd.value = SEARCH11;
							}else if(t8frame.beforeSlotTab == 2){
								formObj.f_cmd.value = SEARCH12;
								formObj.sl_status1.value = "OM";
								formObj.sl_status2.value = "OI";
							}else if(t8frame.beforeSlotTab == 3){
								formObj.f_cmd.value = SEARCH14;
								formObj.sl_status1.value = "SM";
								formObj.sl_status2.value = "SI";
							}

							if(multiSearchCheck){
								var sheetObj = t8frame.sheetObjCur(); //document.all.item("t8sheet" + (t4frame.beforeSlotTab + 1));
								var prefix = "t8sheet" + (t8frame.beforeSlotTab + 1) + "_";

								var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

								sheetObj.Redraw = false;    
								sheetObj.WaitImageVisible = false;	
								sheetObj.LoadSearchXml(sXml); 
								sheetObj.Redraw = true; 
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}
							
							break;
						case "Temp. STWG":
							formObj.f_cmd.value = SEARCH13;
							var sheetObj = t9frame.document.all.item("t9sheet1"); //document.t5sheet1;

							var prefix = "t9sheet1_";
							var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.Redraw = true; 

							break;
						case "Remark(s)":
							if(document.sheetTdrH.RowCount > 0){
								document.form.tdr_info.value = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_info");
							}
							break;
					}

					arrPreCond[0] = document.form.vsl_cd.value;
					arrPreCond[1] = document.form.skd_voy_no.value;
					arrPreCond[2] = document.form.skd_dir_cd.value;
					arrPreCond[3] = document.form.yd_cd.Code;
					mCheckValue = false;
				}
				break;
				
			case IBSAVE:		//저장.
				if(validateForm(formObj,sAction)){
					var dupSheet = null;
					var dupCol = null;

					switch(marrTabTitle[tabIdx]){
						case "Port Log":
							formObj.f_cmd.value = MULTI02;
							
                            if(!calcuPortLog(formObj, sheetCheckEdit[1])){
                            	return;
                            }
                            
							//만약 TDR헤더가 존재할경우...
							if(document.sheetTdrH.RowCount > 0){
                                setTdrHeaderVal2(formObj, document.sheetTdrH);
							}
//			                var sParam = ComGetSaveString(sheetCheckEdit[1]);
							var sheetTransc = document.sheetTransc;
						    var sPrefix = sheetTransc.id+"_";							
							var sheetObj = document.t2sheet1;
							var prefix = "t2sheet1_";								
							var days = sheetObj.EvalDateDiff("D", sheetObj.CellText(i, prefix + "work_comm"), 
														   sheetObj.CellText(i, prefix + "work_comp"));
                            for(var i= sheetTransc.HeaderRows; i <= sheetTransc.LastRow  ;i++ ){
                                if( sheetTransc.CellValue(i, sPrefix + "work_comm"  ) == "" ){
                                    ComShowCodeMessage("COM130404", i, "Work Commenced" );
                                    //Work Commenced|Work Completed
                                    break;
                                }
                                if(  sheetTransc.CellValue(i, sPrefix + "work_comp"  ) == "") {
                                    ComShowCodeMessage("OPF50025", i, "Work Completed" );
                                    break;
                                }
								
								var berth = "";
								var unberth = "";
								if(document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_berth") != ""){
									berth = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_berth");
								}else{
									berth = document.t1sheet1.CellValue(document.t1sheet1.SelectRow , "t1sheet1_berth");
								}
								if(document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_unberth") != ""){
									unberth = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_unberth");
								}else{
									unberth = document.t1sheet1.CellValue(document.t1sheet1.SelectRow , "t1sheet1_unberth");
								}
								
								//WORK COMPLETED TIME이 COMMENCE보다 빠른시간인 경우 입력불가
								if (sheetObj.CellText(i, prefix + "work_comp") != '') {
									if (sheetObj.CellText(i, prefix + "work_comm") >= sheetObj.CellText(i, prefix + "work_comp")) {
										ComShowCodeMessage("OPF50013",  "Completed Date", "Commeced Date");
										sheetObj.CellValue2(Row, Col) = "";
										sheetObj.SelectCell(i, sheetObj.CellValue(i, prefix + "work_comp"), true);
										return;
									}
								}
								if (berth != '') {
									// work completed time은 work commence time보다 이전일수 없음(시간, 분 비교)
									if (berth > sheetObj.CellValue(i, prefix + "work_comm")) {
										ComShowCodeMessage("OPF50035", ComGetMaskedValue(berth,"ymdhm"), ComGetMaskedValue(unberth,"ymdhm"));
										sheetObj.SelectCell(i, sheetObj.CellValue(i, prefix + "work_comm"), true);
										return;
									}
								}
								
								if (unberth != '') {
									// work completed time은 work commence time보다 이전일수 없음(시간, 분 비교)
									if (unberth < sheetObj.CellValue(i, prefix + "work_comp")) {
										ComShowCodeMessage("OPF50035", ComGetMaskedValue(berth,"ymdhm"), ComGetMaskedValue(unberth,"ymdhm"));
										sheetObj.SelectCell(i, sheetObj.CellValue(i, prefix + "work_comp"), true);
										return;
									}
								}
                            }
							
							if(!setCraneSheet()){
								ComShowCodeMessage("OPF50009", "g/crane working time");
								return;
							}
							
							//TDR헤더에 변동사항이 없으므로.
							if(document.sheetTdrH.RowCount > 0 && document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}
 
							
							break;
						case "Disch. Vol.":
							formObj.f_cmd.value = MULTI03;
  
							if(!multiInputCheck()){
								return;
							}

							if(mCheckValue){
								checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);

								if(mPopUpEditSheet.CellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}

							//TDR헤더에 변동사항이 없으므로.
							if(document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}

							//IdxSheet Import시에 해당 이전시트를 삭제하기 위해서.
							if(importDischTotal){
								setSheetIdx(sheetCheckEdit[1], "3", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[1], "0", "idx_sheet");
							}
							
							if(importDischSC){
								setSheetIdx(sheetCheckEdit[2], "2", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[2], "0", "idx_sheet");
							}
							
							if(importDischBB){
								setSheetIdx(sheetCheckEdit[3], "2", "cod_chk");
							}else{
								setSheetIdx(sheetCheckEdit[3], "0", "cod_chk");
							}

							break;
						case "Load Vol.":
							formObj.f_cmd.value = MULTI04;

							if(!multiInputCheck()){
								return;
							}

							//체크여부.....
							if(mCheckValue){
								checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);

								if(mPopUpEditSheet.CellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}

							//TDR헤더에 변동사항이 없으므로.
							if(document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}
 
							//importLoadTotalOc, importLoadTotalIn, importLoadSC, importLoadBB
 
							if(importLoadTotalOc){
								setSheetIdx(sheetCheckEdit[1], "4", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[1], "1", "idx_sheet");
							}

							if(importLoadTotalIn){
								setSheetIdx(sheetCheckEdit[2], "5", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[2], "2", "idx_sheet");
							}
							
							if(importLoadSC){
								setSheetIdx(sheetCheckEdit[3], "3", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[3], "1", "idx_sheet");
							}

							if(importLoadBB){
								setSheetIdx(sheetCheckEdit[4], "3", "cod_chk");
							}else{
								setSheetIdx(sheetCheckEdit[4], "1", "cod_chk");
							}
 
							break;
						case "COD":
							formObj.f_cmd.value = MULTI05;

							//체크여부.....
							if(mCheckValue){
								checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);

								if(mPopUpEditSheet.CellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}

							//TDR헤더에 변동사항이 없으므로.
							if(document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}
							break;
						case "R/H":
							formObj.f_cmd.value = MULTI06;
							//엑셀 Upload시에 체크...
							var prefix = "t6sheet1_";
							if(!checkExcelValidate()){  
								return;
							}

							//체크여부.....
							if(mCheckValue){
								if(mPopUpEditSheet.ColSaveName(mPopUpEditCol) == "t6sheet1_shift_rsn"){
									checkShiftReasonNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol, mPopUpEditSheet.CellValue(mPopUpEditRow, mPopUpEditCol));
								}else{
									checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
								}
								
								if(mPopUpEditSheet.CellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}

							//TDR헤더에 변동사항이 없으므로.
							if(document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}
							break;
						case "Mishandle":
							formObj.f_cmd.value = MULTI07;

							//TDR헤더에 변동사항이 없으므로.
							if(document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}
							break;
						case "Slot":
							formObj.f_cmd.value = MULTI08;

							//TDR헤더에 변동사항이 없으므로.
							if(document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}
							
							//Slot의 경우 변경된 내용이 있으면 해당내용을 지우고 삭제하기 때문에. 다 저장으로 변경.
							if(parseInt(sheetCheckEdit[2].RowCount("I")) + parseInt(sheetCheckEdit[2].RowCount("U")) + parseInt(sheetCheckEdit[2].RowCount("D")) > 0){
								for(var idxRow = sheetCheckEdit[2].HeaderRows; idxRow <= sheetCheckEdit[2].LastRow; idxRow++){
									if(sheetCheckEdit[2].RowStatus(idxRow) == "R"){
										sheetCheckEdit[2].RowStatus(idxRow) = "U";
									}
								}
							}
/*
							setSheetIdx(sheetCheckEdit[3], "S", "status");
							setSheetIdx(sheetCheckEdit[4], "O", "status");
*/
							setSheetIdx(sheetCheckEdit[3], "O", "status");
							setSheetIdx(sheetCheckEdit[4], "S", "status");
							break;
						case "Temp. STWG":
							formObj.f_cmd.value = MULTI09;

							if(mCheckValue){
								checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);

								if(mPopUpEditSheet.CellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}

							//TDR헤더에 변동사항이 없으므로.
							if(document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}
							break;
						case "Remark(s)":
							formObj.f_cmd.value = MULTI10;
							if(document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) == "R"){
								document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "U";
							}
							break;
					}
/*					
					//중복체크...
					if(!dupcheckSave(marrTabTitle[tabIdx], false)){
						return;
					}
*/

					//TDR헤더가 없으면. 저장 TDR헤더 자동 저장.............
					if(document.sheetTdrH.RowCount < 1){
						var tdrSht = document.sheetTdrH;
						var Row = tdrSht.DataInsert();
						var hdrPrefix = "sheetTdrH_";

						tdrSht.CellValue(Row, hdrPrefix + "vsl_cd"  )     = getObjValue("vsl_cd");
						tdrSht.CellValue(Row, hdrPrefix + "voy_no"  )     = getObjValue("skd_voy_no");
						tdrSht.CellValue(Row, hdrPrefix + "dir_cd"  )     = getObjValue("skd_dir_cd");
						tdrSht.CellValue(Row, hdrPrefix + "port_cd" )     = getObjValue("yd_cd").substring(0, 5);
						tdrSht.CellValue(Row, hdrPrefix + "call_ind")     = getObjValue("clpt_ind_seq");
						tdrSht.CellValue(Row, hdrPrefix + "tml_cd"  )     = getObjValue("yd_cd");
						tdrSht.CellValue(Row, hdrPrefix + "update_sys")   = "N";					//우리시스템이라는 표시... 
						//만약 Port Log가 
						if(marrTabTitle[tabIdx] == "Port Log"){
							setTdrHeaderVal2(formObj, document.sheetTdrH);
						}
					} 

					var sParam = ComGetSaveString(sheetCheckEdit);
					if (sParam == "") return;
					sParam +=  "&" + FormQueryString(formObj);

					if(marrTabTitle[beforetab] == "Slot" && mSlotDepRetrive){
						if( sParam.indexOf("t8sheet1") > 0 || sParam.indexOf("t8sheet2") > 0 ){
							mSlotDepRetrive = true;
						}else{
							mSlotDepRetrive = false;
						}
					}
					document.sheetTransc.WaitImageVisible=false;
                    ComOpenWait(true);
                    var sXml = document.sheetTransc.GetSaveXml("VOP_OPF_0036GS.do", sParam);
                    ComOpenWait(false);
                    
                    
					//저장이후 다른 처리를 해야 될경우는 아래에 작성...
					if(formObj.sys_create_desc.value == ""){
						formObj.sys_create_desc.value = formObj.sys_create.value;
					}

					for(var cnt = 0; cnt < sheetCheckEdit.length; cnt++){
						sheetCheckEdit[cnt].LoadSaveXml(sXml);
	                    if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {                 
	                         
	                        if(importLoadTotalOc){
	                            importLoadTotalOc = false;
	                        }
                            if(importLoadTotalIn){
                                importLoadTotalIn = false;
                            }
                            if(importLoadSC){
                                importLoadSC = false;
                            }
                            if(importLoadBB){
                                importLoadBB = false;
                            }
	                        
	                    }
						//처음 이후에 메세지 삭제.
						if(cnt == 0)
							sXml = ComDeleteMsg(sXml);
					}


					//Slot Departure의 파트에 Retreive할 내용이 있을시엔..
					if(mSlotDepRetrive){
						formObj.f_cmd.value = SEARCH14;
						formObj.sl_status1.value = "SM";
						formObj.sl_status2.value = "SI";
						var sheetObj = t8frame.document.t8sheet4;
						var prefix = "t8sheet4_";
						var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

						sheetObj.Redraw = false;    
						sheetObj.WaitImageVisible = false;	
						sheetObj.LoadSearchXml(sXml); 
						sheetObj.Redraw = true;

						mSlotDepRetrive = false;
					}
				}
				break;
			case IBDELETE:
				if(!ComShowCodeConfirm("COM12165", "TDR Data")){
					return;
				}
				formObj.f_cmd.value = MULTI01;
				document.sheetTdrH.RowStatus(document.sheetTdrH.SelectRow) = "D";

				var sParam = ComGetSaveString(document.sheetTdrH);
				if (sParam == "") return;
				sParam +=  "&" + FormQueryString(formObj)+"&BTN_DELETE=Y";
				var sXml = sheetCheckEdit[0].GetSaveXml("VOP_OPF_0036GS.do", sParam);

				for(var cnt = 0; cnt < sheetCheckEdit.length; cnt++){
					sheetCheckEdit[cnt].LoadSaveXml(sXml);

					if(cnt == 0)
						sXml = ComDeleteMsg(sXml);
				}

				formObj.vsl_cd.value = "";
				resetFormNsheet(formObj.vsl_cd);
				formObj.vsl_cd.focus();
				break;
		}
	}

    function doActionImportDisch(formObj) {
		var sheetObj = document.all.item("t3sheet" + (beforeDistchVolTab + 1));
		var arrPre = new Array("t3sheet1_", "t3sheet2_", "t3sheet3_");
		
		var chkWrite = false;
		for(var idx = 1; idx < sheetCheckEdit.length; idx++){
			//작성여부 체크....
			if( parseInt(sheetCheckEdit[idx].RowCount("I")) + 
				parseInt(sheetCheckEdit[idx].RowCount("U")) + 
				parseInt(sheetCheckEdit[idx].RowCount("D"))  > 0 ){
					chkWrite = true;
					break;
			}
		}

		if(chkWrite && !ComShowCodeConfirm("OPF50016")){
			return;
		}

		formObj.f_cmd.value = SEARCHLIST17;
		var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPre));

		var arrXml = sXml.split(sheetSplit);

		for(var cnt = 0; cnt < arrXml.length; cnt++){
			sheetCheckEdit[cnt + 1].Redraw = false;
			sheetCheckEdit[cnt + 1].LoadSearchXml(arrXml[cnt]);
			sheetCheckEdit[cnt + 1].Redraw = true;
		}
		
		//삽입 모드로 RowStat변경..........
		for(var idxObj = 1; idxObj < sheetCheckEdit.length; idxObj++){
			sheetObj = sheetCheckEdit[idxObj];
			for(var idxRow = sheetObj.HeaderRows; idxRow < sheetObj.LastRow; idxRow++){
				sheetObj.RowStatus(idxRow) = "I";
			}
		}
	}

    function doActionIBSheetImport1(tabIdx, formObj) {
		var sheetObj = t3frame.sheetObjCur(); //t3frame.document.all.item("t3sheet" + (t3frame.beforeDistchVolTab + 1));
		var prefix = "t3sheet" + (t3frame.beforeDistchVolTab + 1) + "_"

		var chkWrite = false;

		//작성여부 체크....
		if( parseInt(sheetObj.RowCount) > 0 ){
			chkWrite = true;
		}

		if(chkWrite && !ComShowCodeConfirm("OPF50016")){
			return;
		}

        if(tabIdx == 0){
			formObj.f_cmd.value = SEARCHLIST06;
			formObj.status1.value = "";
        }else if(tabIdx == 1){
			formObj.f_cmd.value = SEARCHLIST07;
			formObj.sc_status1.value = "DS";
			formObj.sc_status2.value = "DG";
			formObj.sc_status3.value = "";
		}else if(tabIdx == 2){
			formObj.f_cmd.value = SEARCHLIST08;
			formObj.sc_status1.value = "DS";
			formObj.sc_status2.value = "DG";
			formObj.sc_status3.value = "";
		}

		var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

		sheetObj.Redraw = false;
		sheetObj.WaitImageVisible = false;	
		sheetObj.LoadSearchXml(sXml); 
		sheetObj.Redraw = true; 

		for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
			sheetObj.RowStatus(idxRow) = "I";
		}
		
		//정상적으로 호출이후에 상태를 변경시켜 준다.
        if(tabIdx == 0 && chkWrite){
			importDischTotal = true;
        }else if(tabIdx == 1 && chkWrite){
			importDischSC = true;
		}else if(tabIdx == 2 && chkWrite){
			importDischBB = true;
		}
	}

    function doActionIBSheetImport2(tabIdx, formObj) {
		var sheetObj = t4frame.sheetObjCur(); //document.all.item("t4sheet" + (tabIdx + 1));
		var prefix = "t4sheet" + (t4frame.beforeLoadVolTab + 1) + "_";

		var chkWrite = false;

		//작성여부 체크....
		if( parseInt(sheetObj.RowCount) > 0 ){
			chkWrite = true;
		}

		if(chkWrite && !ComShowCodeConfirm("OPF50016")){
			return;
		}

		if(tabIdx == 0){
			formObj.f_cmd.value = SEARCHLIST14;
			formObj.status1.value = "LM";
        }else if(tabIdx == 1){
			formObj.f_cmd.value = SEARCHLIST14;
			formObj.status1.value = "LI";
		}else if (tabIdx == 2){					
			formObj.f_cmd.value = SEARCHLIST15;
			formObj.sc_status1.value = "LM";
			formObj.sc_status2.value = "LI";
			formObj.sc_status3.value = "LT";
		}else if (tabIdx == 3){
			formObj.f_cmd.value = SEARCHLIST16;
			formObj.sc_status1.value = "LM";
			formObj.sc_status2.value = "LI";
			formObj.sc_status3.value = "LT";
		}

		var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

		sheetObj.Redraw = false;
		sheetObj.WaitImageVisible = false;	
		sheetObj.LoadSearchXml(sXml); 
		sheetObj.Redraw = true; 

		for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
			sheetObj.RowStatus(idxRow) = "I";
		}

		if(tabIdx == 0){
			importLoadTotalOc = true;
        }else if(tabIdx == 1){
			importLoadTotalIn = true;
		}else if (tabIdx == 2){
			importLoadSC = true;
		}else if (tabIdx == 3){
			importLoadBB = true;
		}
	}

	function doActionIBSheetImport3(tabIdx, formObj) {
		if(t8frame.beforeSlotTab == 0){
			formObj.f_cmd.value = SEARCHLIST09;
		}else if(t8frame.beforeSlotTab == 1){
			formObj.f_cmd.value = SEARCHLIST10;
		}else if(t8frame.beforeSlotTab == 2){
			formObj.f_cmd.value = SEARCHLIST11;
		}else if(t8frame.beforeSlotTab == 3){
			formObj.f_cmd.value = SEARCHLIST12;
		}
		var sheetObj = t8frame.sheetObjCur(); //document.all.item("t8sheet" + (beforeSlotTab + 1));
		var prefix = "t8sheet" + (t8frame.beforeSlotTab + 1) + "_";

		var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		sheetObj.Redraw = false;
		sheetObj.WaitImageVisible = false;	
		sheetObj.LoadSearchXml(sXml); 
		sheetObj.Redraw = true; 

		for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
			sheetObj.RowStatus(idxRow) = "I";
		}
	}
	
	function doActionIBSheetMulti(tabIdx, formObj){
		var multiSheet = new Array();
		var sXml = "";
		if(marrTabTitle[tabIdx] == "Disch. Vol."){
			formObj.f_cmd.value = SEARCHLIST01;

			multiSheet[0] = t3frame.document.t3sheet1;
			multiSheet[1] = t3frame.document.t3sheet2;
			multiSheet[2] = t3frame.document.t3sheet3;

			var arrPrefix = new Array("t3sheet1_", "t3sheet2_", "t3sheet3_");
			sXml = multiSheet[0].GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));

		}else if(marrTabTitle[tabIdx] == "Load Vol."){
			formObj.f_cmd.value = SEARCHLIST02;

			multiSheet[0] = t4frame.document.t4sheet1;
			multiSheet[1] = t4frame.document.t4sheet2;
			multiSheet[2] = t4frame.document.t4sheet3;
			multiSheet[3] = t4frame.document.t4sheet4;
 
			var arrPrefix = new Array("t4sheet1_", "t4sheet2_", "t4sheet3_", "t4sheet4_");
			sXml = multiSheet[0].GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
		}else if(marrTabTitle[tabIdx] == "Slot"){
			formObj.f_cmd.value = SEARCHLIST03;

			multiSheet[0] = t8frame.document.t8sheet1;
			multiSheet[1] = t8frame.document.t8sheet2;
			multiSheet[2] = t8frame.document.t8sheet3;
			multiSheet[3] = t8frame.document.t8sheet4;

			var arrPrefix = new Array("t8sheet1_", "t8sheet2_", "t8sheet3_", "t8sheet4_");
			sXml = multiSheet[0].GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
		}
		
		var arrXml = sXml.split(sheetSplit);

		for(var cnt = 0; cnt < multiSheet.length; cnt++){
			multiSheet[cnt].Redraw = false;
			multiSheet[cnt].LoadSearchXml(arrXml[cnt]);
			multiSheet[cnt].Redraw = true;
		}
		
		//상태값 변경.
		if(marrTabTitle[tabIdx] == "Disch. Vol."){
			importDischTotal = false;
			importDischSC = false;
			importDischBB = false;
		}else{
			importLoadTotalOc = false;
			importLoadTotalIn = false;
			importLoadSC = false;
			importLoadBB = false;
		}

		multiSearchCheck = true;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(formObj,sAction){
		switch(sAction) {

			case IBSEARCH:
				//VVD 정보는 Key 이므로 기본 적으로 확인한다.
				if(formObj.vsl_cd.value == ""){
					ComShowCodeMessage("COM130201", "VVD CD");
					ComSetFocus(document.all.item("vsl_cd"));
					return false;
				}
				if(formObj.skd_voy_no.value == ""){
					ComShowCodeMessage("COM130201", "VVD CD");
					ComSetFocus(document.all.item("skd_voy_no"));
					return false;
				}
				if(formObj.skd_dir_cd.value == ""){ 	
					ComShowCodeMessage("COM130201", "VVD CD");
					ComSetFocus(document.all.item("skd_dir_cd"));
					return false;
				}

				if(formObj.yd_cd.Code == ""){
					ComShowCodeMessage("COM130201", "YARD");
					ComSetFocus(document.all.item("yd_cd"));
					return false;
				}
				
				return true;

				break;
			case IBSAVE:
 
			    
				//VVD 정보는 Key 이므로 기본 적으로 확인한다.
				if(formObj.vsl_cd.value == ""){
					ComShowCodeMessage("COM130201", "VVD");
					ComSetFocus(document.all.item("vsl_cd"));
					return false;
				}
				if(formObj.skd_voy_no.value == ""){
					ComShowCodeMessage("COM130201", "VVD");
					ComSetFocus(document.all.item("skd_voy_no"));
					return false;
				}
				if(formObj.skd_dir_cd.value == ""){ 	
					ComShowCodeMessage("COM130201", "VVD");
					ComSetFocus(document.all.item("skd_dir_cd"));
					return false;
				}

				if(formObj.yd_cd.Code == ""){
					ComShowCodeMessage("COM130201", "YARD");
					ComSetFocus(document.all.item("yd_cd"));
					return false;
				}
				
				return true;

				break;

		}
	}
	
	function checkCondiChange(){
		if(arrPreCond[0] != document.form.vsl_cd.value)
			return true;
		if(arrPreCond[1] != document.form.skd_voy_no.value)
			return true;
		if(arrPreCond[2] != document.form.skd_dir_cd.value)
			return true;
		if(arrPreCond[3] != document.form.yd_cd.Code)
			return true;

		return false;
	}

	/**
	 * 화면 컨트롤 Start
	 */
	function vsl_cd_onchange(){
		if(bRetrive){
			resetFormNsheet(document.form.vsl_cd);
		}
	}

	function skd_voy_no_onchange(){
		if(bRetrive){
			resetFormNsheet(document.form.skd_voy_no);
		}
	}

	function skd_dir_cd_onchange(){
		if(bRetrive){
			resetFormNsheet(document.form.skd_dir_cd);
		}
	}

	function gross_work_keypress(){
		ComKeyOnlyNumber(document.form.gross_work, ":");
	}
	
	function gross_work_onblur(){
		autoCalcuCheck = true;
		hhMMCheck(document.form.gross_work);
	}

	function net_work_keypress(){
		autoCalcuCheck = true;
		ComKeyOnlyNumber(document.form.net_work, ":");
	}
	
	function net_work_onblur(){
		hhMMCheck(document.form.net_work);
	}

	function lost_time_keypress(){
		autoCalcuCheck = true;
		ComKeyOnlyNumber(document.form.lost_time, ":");
	}
	
	function lost_time_onblur(){
		hhMMCheck(document.form.lost_time);
	}

	function gross_gang_keypress(){
		autoCalcuCheck = true;
		ComKeyOnlyNumber(document.form.gross_gang, ":");
	}
	
	function gross_gang_onblur(){
		hhMMCheck(document.form.gross_gang);
	}

	function net_gang_keypress(){
		autoCalcuCheck = true;
		ComKeyOnlyNumber(document.form.net_gang, ":");
	}
	
	function net_gang_onblur(){
		hhMMCheck(document.form.net_gang);
	}

	function move_handl_onchange(){
		if(document.form.move_handl.value != ""){
			//calcuPortLog(document.form, sheetObjects[1]);
			calcuPortLogHeader();
		}
	}

	function yd_cd_OnChange(sheetObj, Row, Col, Value){
        var formObj = document.form;
        formObj.yd_nm.value = "";
		if(comboObjects[0].Code != ""){
			document.form.yd_nm.value = comboObjects[0].getText(comboObjects[0].Text, 1);
			if(bRetrive){
				resetFormNsheet(document.form.port_cd);
			}
		}else{
			return;
		}

		//[2010-04-06]추가
		document.form.clpt_ind_seq.value = arrClptIndSeq[comboObjects[0].Index];
		
		//해당 POD와 POL가져오기..

		formObj.f_cmd.value = SEARCH08;
		formObj.port_cd.value = formObj.yd_cd.Code.substring(0, 5);
		var unKnownPortName = "|XXXXX\tUnknown";
		var unKnownPortCode = "|XXXXX";
		//"", "", 

		var arrPre = new Array("", "");
		var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPre));

		var arrXml = sXml.split(sheetSplit);

		var arrCombo = ComXml2ComboString(arrXml[0], "val", "name");
		mPodCode = " |" + arrCombo[0] + unKnownPortCode;
		mPodName = " |" + arrCombo[1] + unKnownPortName;


		arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
		if(arrCombo != null){
			mLoadPodCode = " |" + arrCombo[0] + unKnownPortCode;
			mLoadPodName = " |" + arrCombo[1] + unKnownPortName;
		}

		var frame = document.getElementById("t4frame");
		if(frame.src != ""){
			t4frame.podComboInit();
		}

		var frame = document.getElementById("t5frame");
		if(frame.src != ""){
			t5frame.podComboInit();
		}

		var frame = document.getElementById("t6frame");
		if(frame.src != ""){
			t6frame.podComboInit();
		}

		var frame = document.getElementById("t7frame");
		if(frame.src != ""){
			t7frame.podComboInit();
		}

		var frame = document.getElementById("t9frame");
		if(frame.src != ""){
			t9frame.podComboInit();
		}
	}
	
	function initComboSzTp(){
		var formObj = document.form;

		formObj.f_cmd.value = SEARCH09;
		var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));

		var arrCombo = ComXml2ComboString(sXml, "val", "name");
		
		mSztpCode = " |" + arrCombo[0];
		mSztpName = " |" + arrCombo[1];

		formObj.f_cmd.value = SEARCH10;
		formObj.comboCd.value = "COD_RSN";
		var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		arrCombo = ComXml2ComboString(sXml, "val", "name");

		mReasonCode = " |" + arrCombo[0];
		mReasonName = " |" + arrCombo[1];
	}

	function hhMMCheck(objText){
		if(objText.value != ""){
			if(objText.value.indexOf(":") > -1){
				var arrTxt = objText.value.split(":");

				if(parseInt(arrTxt[1]) > 59){
					objText.value = ( parseInt(arrTxt[1] / 60) + 
									  parseInt(arrTxt[0] == "" ? "0" : arrTxt[0]) 
						            ) + ":" + fillZero(arrTxt[1] % 60);
				}else if(arrTxt[0] == ""){
					objText.value = "0" + objText.value;
				}
			}else{
				if(parseInt(objText.value) > 59){
					objText.value = parseInt(objText.value / 60) + ":" + fillZero(objText.value % 60);
				}else{
					objText.value = "0:" + objText.value;
				}
			}
		}
	}

	function used_crane_onblur(){
		var sheetObj = document.t2sheet1;
		var prefix = "t2sheet1_";
		var formObj = document.form;
		if(beforeCraneCnt == parseInt(document.form.used_crane.value)){
			return;
		}

		if(parseInt(beforeCraneCnt) < parseInt(document.form.used_crane.value)){		//이전 크래인수보다 클 경우.
			for(var crtRow = 1; crtRow <= parseInt(document.form.used_crane.value) - parseInt(beforeCraneCnt); crtRow++){
				var Row = sheetObj.DataInsert(-1);
//				if( formObj.sys_create_desc.value.indexOf("Ext")>-1 ){
//		            sheetObj.CellValue(Row, prefix + "crane_desc") = sheetObj.CellValue(Row, prefix + "crane_no")  + " G/Crane";   
//				}else{//
				    sheetObj.CellValue(Row, prefix + "crane_desc") = (parseInt(beforeCraneCnt) + parseInt(crtRow)) + " G/Crane";
//				}
				//일단 초기 날짜 세팅.
				
				//00:00으로 세팅...
				sheetObj.CellValue(Row, prefix + "break_down") = "000:00";
				sheetObj.CellValue(Row, prefix + "meal") = "000:00";
				sheetObj.CellValue(Row, prefix + "weather") = "000:00";
				sheetObj.CellValue(Row, prefix + "other") = "000:00";
				sheetObj.CellValue(Row, prefix + "total") = "000:00";

				sheetObj.CellBackColor(Row, prefix + "work") = titColor;
				sheetObj.CellBackColor(Row, prefix + "crane_desc") = totColor;
			}
		}else{
			for(var crtRow = 1; crtRow <= parseInt(beforeCraneCnt) - parseInt(document.form.used_crane.value); crtRow++){
				sheetObj.RowDelete(sheetObj.LastRow, false);
			}
		}

		for(var crtRow = 1; crtRow <= sheetObj.LastRow; crtRow++){
			sheetObj.CellValue2(crtRow, prefix + "work_comm") = "";
			sheetObj.CellValue2(crtRow, prefix + "work_comp") = "";

			//처음 빼고....
			if(crtRow != 1){
				sheetObj.CellValue2(crtRow, prefix + "break_down") = "000:00";
				sheetObj.CellValue2(crtRow, prefix + "meal") = "000:00";
				sheetObj.CellValue2(crtRow, prefix + "weather") = "000:00";
				sheetObj.CellValue2(crtRow, prefix + "other") = "000:00";
				sheetObj.CellValue2(crtRow, prefix + "total") = "000:00";
			}
		}

		document.form.avg_gang.value			=	"";
		document.form.gross_work.value			=	"";
		document.form.net_work.value			=	"";
		document.form.lost_time.value			=	"";
		document.form.gross_gang.value			=	"";
		document.form.net_gang.value			=	"";
		document.form.tmnl_gross.value			=	"";
		document.form.tmnl_net.value			=	"";
		document.form.per_gang_gross.value		=	"";
		document.form.per_gan_net.value			=	"";

		if(parseInt(document.form.used_crane.value) > 0){
			sheetObj.SelectCell(2, prefix + "work_comm", true);
		}

		beforeCraneCnt = parseInt(document.form.used_crane.value);
	}

	function tdr_info_onchange(){
		document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_info") = document.form.tdr_info.value;
	}

	/**
	 * 화면 컨트롤 End
	 */

	/**
	 * Sheet 컨트롤 Start
	 */
	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var prefix = "t2sheet1_";
		if(NewCol > sheetObj.SaveNameCol(prefix + "work_comp") && NewCol < sheetObj.SaveNameCol(prefix + "total")){
			oldLoseTime = sheetObj.CellValue(NewRow, NewCol);
		}
	}
 
	function t2sheet1_OnChange(sheetObj, Row, Col, Value){
 log( Row+ "   "+ Col );
		var prefix = "t2sheet1_";
        var formObj = document.form;
		if(Col > sheetObj.SaveNameCol(prefix + "crane_desc") && Col < sheetObj.SaveNameCol(prefix + "total")){
			//Work_comm Validation
			if( (	Col == sheetObj.SaveNameCol(prefix + "work_comm") || 
					Col == sheetObj.SaveNameCol(prefix + "work_comp")
				) && sheetObj.CellValue(Row, Col) != ""){
				var dateTmp = sheetObj.CellValue(Row, Col);
				if(!ComIsDate(dateTmp.substring(0, 8), "ymd") || !ComIsTime(dateTmp.substring(8), "hm")){
					ComShowCodeMessage('COM12187', 'yyyy-mm-dd hh:mm');
					sheetObj.SelectCell(Row, Col, true);
					return;
				}
								
				if(Row > sheetObj.HeaderRows){
					if(sheetObj.CellValue(Row, prefix + "work_comm") != "" && sheetObj.CellValue(Row, prefix + "work_comp") != "" ){
						var days = sheetObj.EvalDateDiff("D", sheetObj.CellText(Row, prefix + "work_comm")  , 
															   sheetObj.CellText(Row, prefix + "work_comp") );
						if(days < 0){		
							ComShowCodeMessage("OPF50035", ComGetMaskedValue(berth,"ymdhm"), ComGetMaskedValue(unberth,"ymdhm"));
							sheetObj.SelectCell(Row, Col, true);
							return;
						}else{
				                
						}
					}
				}
				//2011.01.06 P.H.D 각 G/Crane의 작업 시각은 Berth Time 보다 이후여야 하고 UNBerth Time보다 이전이어야 한다.  				
//				var berth   = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_berth");
//				var unberth = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_unberth");
				
				var berth = "";
				var unberth = "";
				if(document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_berth") != ""){
					berth = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_berth");
				}else{
					berth = document.t1sheet1.CellValue(document.t1sheet1.SelectRow , "t1sheet1_berth");
				}
				if(document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_unberth") != ""){
					unberth = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_unberth");
				}else{
					unberth = document.t1sheet1.CellValue(document.t1sheet1.SelectRow , "t1sheet1_unberth");
				}
				
				if(  days  > 40   ){ //40일 초과 에러 
                    ComShowCodeMessage("OPF50035", ComGetMaskedValue(berth,"ymdhm"), ComGetMaskedValue(unberth,"ymdhm"));
                    sheetObj.CellValue2(Row, Col) = "";
                    sheetObj.SelectCell(Row, Col, true);
                    return;
                }
				//WORK COMPLETED TIME이 COMMENCE보다 빠른시간인 경우 입력불가
				if (sheetObj.CellText(Row, prefix + "work_comp") != '') {
					if (sheetObj.CellText(Row, prefix + "work_comm") >= sheetObj.CellText(Row, prefix + "work_comp")) {
						ComShowCodeMessage("OPF50013",  "Completed Date", "Commeced Date");
						//ComShowCodeMessage("OPF50035", ComGetMaskedValue(berth,"ymdhm"), ComGetMaskedValue(unberth,"ymdhm"));
						sheetObj.CellValue2(Row, Col) = "";
						sheetObj.SelectCell(Row, Col, true);
						return;
					}
				}
				
				//if ((berth != '') && sheetObj.CellText(Row, prefix + "work_comm")) {
				if (berth != '') {
					// work completed time은 work commence time보다 이전일수 없음(시간, 분 비교)
					if (berth > sheetObj.CellValue(Row, prefix + "work_comm")) {
						ComShowCodeMessage("OPF50035", ComGetMaskedValue(berth,"ymdhm"), ComGetMaskedValue(unberth,"ymdhm"));
						sheetObj.CellValue2(Row, Col) = "";
						sheetObj.SelectCell(Row, Col, true);
						return;
					}
				}
								
				//if ((unberth != '') && sheetObj.CellText(Row, prefix + "work_comp")) {
				if (unberth != '') {
					// work completed time은 work commence time보다 이전일수 없음(시간, 분 비교)
					if (unberth < sheetObj.CellValue(Row, prefix + "work_comp")) {
	
						ComShowCodeMessage("OPF50035", ComGetMaskedValue(berth,"ymdhm"), ComGetMaskedValue(unberth,"ymdhm"));
						sheetObj.CellValue2(Row, Col) = "";
						sheetObj.SelectCell(Row, Col, true);
						return;
					}
				}
				
				//헤더 Terminal Working Time값이 변경되는 것을 제외하고, CellValue가 Null일때 비고하는 로직제외...
				if(Col == sheetObj.SaveNameCol(prefix + "work_comm") && Row > sheetObj.HeaderRows){
					//2011.01.06 P.H.D 각 G/Crane의 작업 시각은 Berth Time 보다 이후여야 하고 UNBerth Time보다 이전이어야 한다.  
					if (berth != "" && unberth != ""){
						if (ComChkPeriod(berth, Value) < 1 || ComChkPeriod(Value, unberth) < 1){
							ComShowMessage("'Work Commenced time' should be between \n\n["+ComGetMaskedValue(berth,"ymdhm")+"] and ["+ComGetMaskedValue(unberth,"ymdhm")+"]");
							sheetObj.CellValue2(Row, Col) = "";
							sheetObj.SelectCell(Row, Col);
							return;
						}
					}
					
					if (sheetObj.CellValue(Row, prefix+"work_comm") != "" && sheetObj.CellValue(Row, prefix+"work_comp") != ""){
						if (ComChkPeriod(sheetObj.CellValue(Row, prefix+"work_comm"), sheetObj.CellValue(Row, prefix+"work_comp")) < 1){
							ComShowMessage("'Work Commenced time' should be before 'Work completed'.");
							sheetObj.CellValue2(Row, Col) = "";
							sheetObj.SelectCell(Row, Col);
							return;
						}
					}
					
					var minDateTime = "";
					
					for(var idxRow = sheetObj.HeaderRows + 1; idxRow <= sheetObj.RowCount; idxRow++){

						if(sheetObj.CellValue(idxRow, Col) != ""){
							if(minDateTime == ""){
								minDateTime = sheetObj.CellValue(idxRow, Col);
							}else if(parseInt(minDateTime) > parseInt(sheetObj.CellValue(idxRow, Col))){
								minDateTime = sheetObj.CellValue(idxRow, Col);
							}
						}
					}

					if(minDateTime != ""){
						sheetObj.CellValue2(sheetObj.HeaderRows, Col) = minDateTime;
					}
				}

				//헤더 Terminal Working Time값이 변경되는 것을 제외하고, CellValue가 Null일때 비고하는 로직제외...
				if(Col == sheetObj.SaveNameCol(prefix + "work_comp") && Row > sheetObj.HeaderRows){
					//2011.01.06 P.H.D 각 G/Crane의 작업 시각은 Berth Time 보다 이후여야 하고 UNBerth Time보다 이전이어야 한다.  
					if (berth != "" && unberth != ""){
						if (ComChkPeriod(berth, Value) < 1 || ComChkPeriod(Value, unberth) < 1){
							ComShowMessage("'Work Commenced time' should be between \n\n["+ComGetMaskedValue(berth,"ymdhm")+"] and ["+ComGetMaskedValue(unberth,"ymdhm")+"]");
							sheetObj.CellValue2(Row, Col) = "";
							sheetObj.SelectCell(Row, Col);
							return;
						}
					}

					if (sheetObj.CellValue(Row, prefix+"work_comm") != "" && sheetObj.CellValue(Row, prefix+"work_comp") != ""){
						if (ComChkPeriod(sheetObj.CellValue(Row, prefix+"work_comm"), sheetObj.CellValue(Row, prefix+"work_comp")) < 1){
							ComShowMessage("'Work Completed time' should be after 'Work Commenced'.");
							sheetObj.CellValue2(Row, Col) = "";
							sheetObj.SelectCell(Row, Col);
							return;
						}
					}

					var maxDateTime = "";
					
					for(var idxRow = sheetObj.HeaderRows + 1; idxRow <= sheetObj.RowCount; idxRow++){
						if(sheetObj.CellValue(idxRow, Col) != ""){
							if(maxDateTime == ""){
								maxDateTime = sheetObj.CellValue(idxRow, Col);
							}else if(parseInt(maxDateTime) < parseInt(sheetObj.CellValue(idxRow, Col))){
								maxDateTime = sheetObj.CellValue(idxRow, Col);
							}
						}
					}

					if(maxDateTime != ""){
						sheetObj.CellValue2(sheetObj.HeaderRows, Col) = maxDateTime;
					}
				}
			}else{
				//헤더 Terminal Working Time값이 변경되는 것을 제외하고, CellValue가 Null일때 비고하는 로직제외...
				if(Col == sheetObj.SaveNameCol(prefix + "work_comm") && Row > sheetObj.HeaderRows){
					var minDateTime = "";
					
					for(var idxRow = sheetObj.HeaderRows + 1; idxRow <= sheetObj.RowCount; idxRow++){

						if(sheetObj.CellValue(idxRow, Col) != ""){
							if(minDateTime == ""){
								minDateTime = sheetObj.CellValue(idxRow, Col);
							}else if(parseInt(minDateTime) > parseInt(sheetObj.CellValue(idxRow, Col))){
								minDateTime = sheetObj.CellValue(idxRow, Col);
							}
						}
					}

					if(minDateTime != ""){
						sheetObj.CellValue2(sheetObj.HeaderRows, Col) = minDateTime;
					}
				}

				//헤더 Terminal Working Time값이 변경되는 것을 제외하고, CellValue가 Null일때 비고하는 로직제외...
				if(Col == sheetObj.SaveNameCol(prefix + "work_comp") && Row > sheetObj.HeaderRows){
					var maxDateTime = "";
					
					for(var idxRow = sheetObj.HeaderRows + 1; idxRow <= sheetObj.RowCount; idxRow++){
						if(sheetObj.CellValue(idxRow, Col) != ""){
							if(maxDateTime == ""){
								maxDateTime = sheetObj.CellValue(Row, Col);
							}else if(parseInt(maxDateTime) < parseInt(sheetObj.CellValue(idxRow, Col))){
								maxDateTime = sheetObj.CellValue(idxRow, Col);
							}
						}
					}

					if(maxDateTime != ""){
						sheetObj.CellValue2(sheetObj.HeaderRows, Col) = maxDateTime;
					}
				}
			}
			
			//80분으로 입력시 1:20으로 변환..........
			if(Col > sheetObj.SaveNameCol(prefix + "work_comp") && Col < sheetObj.SaveNameCol(prefix + "total")){
				var arrTime = sheetObj.CellText(Row, Col).split(":");
				if(parseInt(arrTime[1]) > 60){
						var tmpVal =	( parseInt(arrTime[1] / 60) + 
										  parseInt(arrTime[0] == "" ? "0" : arrTime[0]) 
										) + ":" + (arrTime[1] % 60);

						if(tmpVal.length == 4) sheetObj.CellValue2(Row, Col) =  "00" + tmpVal;
						else if(tmpVal.length == 5) sheetObj.CellValue2(Row, Col) =  "0" + tmpVal;
						else sheetObj.CellValue2(Row, Col) =  tmpVal;
				}
			}
			
			//Crane타임 계산.
			if(Row >= sheetObj.HeaderRows + 1){
				var totMM = 0;
				var waitMM = sheetObj.EvalDateDiff("N", sheetObj.CellText(Row, prefix + "work_comm") + ":00", 
														sheetObj.CellText(Row, prefix + "work_comp") + ":00");
				
				for(var idxCol = sheetObj.SaveNameCol(prefix + "work_comp") + 1; idxCol < sheetObj.LastCol - 2; idxCol++){
					if(sheetObj.CellValue(Row, idxCol) != ""){

						var arrTime = sheetObj.CellText(Row, idxCol).split(":");
						
						var strHr = "";
						var strMi = "";

						
						if(isNaN(parseInt(arrTime[0])) ||  parseInt(arrTime[0], 10)<0) {
							strHr = "000";
							strMi = "00";
						}
						else {
							var tmpHr = parseInt(arrTime[0], 10);
							if(tmpHr >= 0 && tmpHr < 10) strHr = "00" + tmpHr;
							else if(tmpHr >= 10 && tmpHr < 100) strHr = "0" + tmpHr;
							else strHr = tmpHr;
						
							if(isNaN(parseInt(arrTime[1]))) strMi = "00";
							else {
								var tmpMi = parseInt(arrTime[1], 10);
								if(tmpMi < 10) strMi= "0"+tmpMi;
								else strMi = arrTime[1];
							}
						}
						
						sheetObj.CellText(Row, idxCol) = strHr +":"+ strMi;
						
						totMM += parseHHMM(sheetObj.CellText(Row, idxCol));
					}
				}

				// LoseTime
				if(totMM >= 0){
					var tmpVal = parseInt(totMM / 60) + ":" + fillZero(totMM % 60);
					if(tmpVal.length == 4) sheetObj.CellValue2(Row, prefix + "total") =  "00" + tmpVal;
					else if(tmpVal.length == 5) sheetObj.CellValue2(Row, prefix + "total") =  "0" + tmpVal;
					else sheetObj.CellValue2(Row, prefix + "total") =  tmpVal;
				}
				
				//WorkTime
				sheetObj.CellValue2(Row, prefix + "work") = parseInt(waitMM / 60) + ":" + fillZero(waitMM % 60);
			}
		}
        
 
 
        if(sheetObj.CellValue(sheetObj.HeaderRows, prefix + "work_comm") != "" && sheetObj.CellValue(sheetObj.HeaderRows, prefix + "work_comp") != "" ){
            var days = sheetObj.EvalDateDiff("D", sheetObj.CellText(sheetObj.HeaderRows, prefix + "work_comm")  , 
                                                   sheetObj.CellText(sheetObj.HeaderRows, prefix + "work_comp") );
 
            if(  days  > 40   ){ //40일 초과 에러 
            	ComShowCodeMessage("OPF50035", ComGetMaskedValue(berth,"ymdhm"), ComGetMaskedValue(unberth,"ymdhm"));
                //ComShowCodeMessage("OPF50024", "Gross Work Hours");
                sheetObj.CellValue2(sheetObj.HeaderRows, prefix + "work_comp") = "";
                sheetObj.CellValue2(Row, Col) = "";   
                formObj.gross_work.value = "";
                formObj.net_work.value = "";
                formObj.gross_gang.value = "";
                formObj.net_gang.value = "";
 
                return;
            }
 
        }
 
        //t2sheet1_break_down
        var colDateName = prefix+"break_down,"+prefix+"meal,"+prefix+"weather,"+prefix+"other";
 
        if( colDateName.indexOf( sheetObj.ColSaveName(Col) )  > -1 ){
            
            fnCheckDate2(sheetObj, Row, Col);
            return;
        }
 
	}
    function fnCheckDate2(sheetObj, Row, Col){
        var dateTmp = sheetObj.CellText(Row, Col);
 
        if( dateTmp.indexOf(":") >-1 ){
            var  aDateTmp =  dateTmp.split(":");
            var  sMm = "00";
 
            if( aDateTmp[1].trim() != "" ) { //ex) 123: => 123:00
                sMm = aDateTmp[1];
            } 
 
            if( aDateTmp[0].trim() == ""){ aDateTmp[0] = "000"; }
            sheetObj.CellValue2( Row, sheetObj.ColSaveName(Col) )  =  aDateTmp[0]+":"+sMm;
        }else{
            if(dateTmp.trim() == "" ){ dateTmp = "000";}
            sheetObj.CellValue2( Row, sheetObj.ColSaveName(Col) )  =  dateTmp+":00";
        }
        return;
    }

	/**
	 * Sheet 컨트롤 End
	 */

	/**
	 * Sheet내의 Common Control
	 */
	function t3sheet1_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t3sheet2_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t3sheet3_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t4sheet1_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t4sheet2_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t4sheet3_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t4sheet4_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t5sheet1_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t6sheet1_onblur(){
		if(mCheckValue){
			if(mPopUpEditSheet.ColSaveName(mPopUpEditCol) == "t6sheet1_shift_rsn"){
				checkShiftReason(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol, mPopUpEditSheet.CellValue(mPopUpEditRow, mPopUpEditCol));
			}else{
				checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
			}
		}
	}

	function t8sheet3_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t8sheet4_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function t9sheet1_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}

	function checkOprCd(sheetObj, Row, Col){
		//빈값입력시 반환...
		if(sheetObj.CellValue(Row, Col) == ""){
			mCheckValue = false;
			return;
		}
		
		// 체크를 했을때만...........
		// t6sheet1 의 Loop Check 가 아닐 때에만 기동되게끔 한다.
		if(!mCheckValue && !t6sheet1_loopCheck ){
			return;
		}
		//===================== 
		var l_opr_cd = sheetObj.CellValue(Row, Col);
		if(l_opr_cd.length < 3){
			// Account 필드일 경우는 분기한다.
			if(sheetObj.ColSaveName ( Col ) == "t6sheet1_account"){
				ComShowCodeMessage("COM12175", "Account", "3", "4");
			}else{
				ComShowCodeMessage("COM12175", "Operator", "3", "4");
			}
			sheetObj.SelectCell(Row, Col, true);
			return true;
		}else{
			if(Row < sheetObj.HeaderRows){
				return;
			}

			var sParam = "";
			if ( sheetObj.ColSaveName ( Col ) == "t6sheet1_account" ) {
				sParam = "&account=" + l_opr_cd;
			}
			else {
				sParam = "&opr_cd=" + l_opr_cd;
			}
			
			var sXml = document.sheetTdrH.GetSearchXml("VOP_OPF_0036GS.do", "f_cmd=" + SEARCH16 + sParam );

			var oprData = ComOpfXml2Array(sXml, "val|name");

			if(oprData == null){
				ComShowCodeMessage("COM132201", "Data");
				sheetObj.CellValue(Row, Col) = "";
				sheetObj.SelectCell(Row, Col);
				sheetObj.CellValue(Row, sheetObj.id + "") = "";
			}
			
			mCheckValue = false;
		}
	}

	function checkOprCdNoMsg(sheetObj, Row, Col){
		//빈값입력시 반환...
		if(sheetObj.CellValue(Row, Col) == ""){
			mCheckValue = false;
			return;
		}
		
		//체크를 했을때만...........
		if(!mCheckValue){
			return;
		}
		//===================== 
		var l_opr_cd = sheetObj.CellValue(Row, Col);
		if(l_opr_cd.length < 3){
			sheetObj.SelectCell(Row, Col, true);
		}else{
			if(Row < sheetObj.HeaderRows){
				return;
			}

			var sParam = "";
			if ( sheetObj.ColSaveName ( Col ) == "t6sheet1_account" ) {
				sParam = "&account=" + l_opr_cd;
			}
			else {
				sParam = "&opr_cd=" + l_opr_cd;
			}
			
			var sXml = document.sheetTdrH.GetSearchXml("VOP_OPF_0036GS.do", "f_cmd=" + SEARCH16 + sParam );
//			var sXml = document.sheetTdrH.GetSearchXml("VOP_OPF_UTILGS.do", "f_cmd=" + SEARCH04 + "&crr_cd=" + sheetObj.CellValue(Row, Col));

			var oprData = ComOpfXml2Array(sXml, "val|name");

			if(oprData == null){
				sheetObj.CellValue(Row, Col) = "";
				sheetObj.SelectCell(Row, Col);
				sheetObj.CellValue(Row, sheetObj.id + "") = "";
			}
			mCheckValue = false;
		}
	}

/*
	function checkOprCd2(sheetObj, Row, Col){
		//빈값입력시 반환...
		if(sheetObj.CellValue(Row, Col) == "" || Row < sheetObj.HeaderRows){
			return;
		}
		//===================== 
		if(sheetObj.CellValue(Row, Col).length < 3){
			ComShowCodeMessage("COM12175", "Operator", "3", "4");
			sheetObj.SelectCell(Row, Col, true);
		}else{
			var sXml = document.sheetTdrH.GetSearchXml("VOP_OPF_UTILGS.do", "f_cmd=" + SEARCH04 + "&crr_cd=" + sheetObj.CellValue(Row, Col));

			var oprData = ComOpfXml2Array(sXml, "val|name");

			if(oprData == null){
				ComShowCodeMessage("COM132201", "Data");
				sheetObj.CellValue(Row, Col) = "";
				sheetObj.SelectCell(Row, Col);
				sheetObj.CellValue(Row, sheetObj.id + "_chk_valid") = "N";
			}else{
				if(sheetObj.SaveNameCol(sheetObj.id + "_chk_valid") > 0){
					sheetObj.CellValue(Row, sheetObj.id + "_chk_valid") = "Y";
				}
			}
		}
	}
*/
	/**
	 * Container No Validation Check
	 * 주석처리한 이유는???
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function checkCntrNo(sheetObj, Row, Col){
		sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();

//2011.01.06 P.H.D Container No. Validation Check 제거 		
//		document.form.f_cmd.value = SEARCH13;
//		document.form.cntr_no.value = sheetObj.CellValue(Row, Col);
//
//		var sXml = document.all.item("sheetTdrH").GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam(""));
//		//var strCntrOptions = "bkg_no|cntr_tpsz_cd|pck_tp_cd|pck_qty|org_yd_cd";
//		var strCntrOptions = "val";
//		var cntrData = ComOpfXml2Array(sXml, strCntrOptions);
//		
//		if (cntrData == null){
//			ComShowCodeMessage("COM132201", "'"+sheetObj.CellValue(Row, Col)+"'");
//			sheetObj.CellValue2(Row, Col) = "";
//			sheetObj.SelectCell(Row, Col);
//		}

//		if(cntrData == null)
//			sheetObj.CellFont("FontItalic", Row, Col) = true;
//		else
//			sheetObj.CellFont("FontItalic", Row, Col) = false;
	}
	

	function checkShiftReason(sheetObj, Row, Col, Value){
		//빈값입력시 반환...
		if(sheetObj.CellValue(Row, Col) == ""){
			mCheckValue = false;
			return;
		}
		
		// 체크를 했을때만...........
		// t6sheet1 의 Loop Check 가 아닐때에만 
		if(!mCheckValue && !t6sheet1_loopCheck ){
			return;
		}

		if(Row < sheetObj.HeaderRows){
			return;
		}
		
		// Reason Validation
		var sXml = document.sheetTdrH.GetSearchXml("VOP_OPF_0036GS.do", "f_cmd=" + SEARCHLIST13 + "&rstwg_rsn_cd=" + Value);	//[1]수정
		var strCntrOptions = "rstwg_rsn_cd|delt_flg";
		var reasonData = ComOpfXml2Array(sXml, strCntrOptions);

		if(reasonData == null){
			ComShowCodeMessage("COM132201", "Data");
			sheetObj.CellValue(Row, Col) = "";
			sheetObj.SelectCell(Row, Col, true);
		}

		mCheckValue = false;
	}

	function checkShiftReasonNoMsg(sheetObj, Row, Col, Value){
		//빈값입력시 반환...
		if(sheetObj.CellValue(Row, Col) == ""){
			mCheckValue = false;
			return;
		}
		
		//체크를 했을때만...........
		if(!mCheckValue){
			return;
		}

		if(Row < sheetObj.HeaderRows){
			return;
		}

		//첫자리가. B,Q인지 확인.
		if(Value.substring(0, 1) != "B" && Value.substring(0, 1) != "Q"){
			sheetObj.CellValue(Row, Col) = "";
			sheetObj.SelectCell(Row, Col, true);
		}else{
			//두번째자리이후는 DB에 등록되어 있는 Reson코드인지.
			//var sXml = document.all.item("sheetTdrH").GetSearchXml("VOP_OPF_0036GS.do", "f_cmd=" + SEARCHLIST13 + "&rstwg_rsn_cd=" + Value.substring(1));
			var sXml = document.sheetTdrH.GetSearchXml("VOP_OPF_0036GS.do", "f_cmd=" + SEARCHLIST13 + "&rstwg_rsn_cd=" + Value.substring(1));
			var strCntrOptions = "rstwg_rsn_cd|delt_flg";
			var reasonData = ComOpfXml2Array(sXml, strCntrOptions);

			if(reasonData == null){
				sheetObj.CellValue(Row, Col) = "";
				sheetObj.SelectCell(Row, Col, true);
			}
		}

		mCheckValue = false;
	}

	function chkPortCombo(sheetObj, Row, Col, Value){
		if(Row < sheetObj.HeaderRows){
			return;
		}

		if(sheetObj.CellValue(Row, Col) == ""){
			return;
		}

		checkyDcDFlg = false;

		//유효 Pod 체크
		var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
		var arrCode = sCode.split("|");

		for(var i=0 ; i< arrCode.length ; i++){
			if(arrCode[i] == Value ){
				checkyDcDFlg = true;
			}
		}

		//유효 TMNL Code 없을 경우 TMNL Code 이동
		if(!checkyDcDFlg){
			//7자리 체크 및 유효 TMNL Code 체크 
			if(sheetObj.CellValue(Row, Col) != "" ){
				/*
				if(sheetObj.CellValue(Row, Col).length < 5){
					//ComShowCodeMessage("OPF00014");
				}else{
					//ComShowCodeMessage("OPF00015");
				}
				*/
			}
			sheetObj.CellValue(Row, Col) = "";
			sheetObj.SelectCell(Row, Col, true);
		}
	}

	function chkSzTpCombo(sheetObj, Row, Col, Value){
		checkyDcDFlg = false;

		//유효 Pod 체크
		var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
		var arrCode = sCode.split("|");

		for(var i=0 ; i< arrCode.length ; i++){
			if(arrCode[i] == Value ){
				checkyDcDFlg = true;
			}
		}

		//유효 TMNL Code 없을 경우 TMNL Code 이동
		if(!checkyDcDFlg){
			//7자리 체크 및 유효 TMNL Code 체크 
			if(sheetObj.CellValue(Row, Col) != "" ){
/*
				if(sheetObj.CellValue(Row, Col).length < 2){
					ComShowCodeMessage("COM12174", "Type/Size", "2");
				}else{
					ComShowCodeMessage("COM132201", "Data");
				}
*/
			}
			sheetObj.CellValue(Row, Col) = "";
			sheetObj.SelectCell(Row, Col, true);
		}
	}

	/**
	 *	TDR정보 조회시...
	 */
	function tdrHeaderSearch(formObj){
		var sheetObj = document.sheetTdrH;
		var prefix = "sheetTdrH_";
		document.form.f_cmd.value = SEARCHLIST04;
		document.form.port_cd.value = document.form.yd_cd.Code.substring(0, 5);
		document.form.voy_no.value = document.form.skd_voy_no.value;
		document.form.dir_cd.value = document.form.skd_dir_cd.value;
		
		var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheetTdrH_"));
		
		sheetObj.Redraw = false;
		sheetObj.WaitImageVisible = false;	
		sheetObj.LoadSearchXml(sXml); 
		sheetObj.Redraw = true; 

		if(sheetObj.RowCount > 0){
			if(sheetObj.CellValue(sheetObj.SelectRow, prefix + "update_sys") == "N"){
				formObj.sys_create.value = "Internally Produced";
				formObj.sys_create_desc.value = "Internally Produced";
				formReadonly(false);
			}else{
				formObj.sys_create.value = "Externally Produced";
				formObj.sys_create_desc.value = "Externally Produced";
				
				//2010.12.23 P.H.D. 추가, Slot 인 경우 Slot(Port), Slot(DEP)탭은 수정불가, BSA 는 RowAdd만 불가, 수정은 가능, HC/45는 CUD 모두 가능  
				/* ========= "befortab" Numbering =========================== 
				 * 0 : Port Log
				 * 1 : Disch. Vol.
				 * 2 : Load Vol.
				 * 3 : COD
				 * 4 : R/H
				 * 5 : Mishandle
				 * 6 : Slot
				 * 7 : Temp. STWG
				 * 8 : Remark(s)
				 * ==========================================================
				 */
				if (beforetab == 6){
					frameButtonSheetSub(document.t8frame, gSubTabNo);
				}else if (beforetab == 3 || beforetab == 4 || beforetab == 5 || beforetab == 7 || beforetab == 8){
					formReadonly(false);
					// ::jsk:: //
				}else{
					formReadonly(true);
				}
 			}
			
			opentScreen(); //1. t1Sheet1을 제외한 모든 sheet 초기화 2. sheetCheckEdit 배열에 해당 sheet를 넣는다.

			// Exclude TPR에 저장시에 글짜색만 바꾸어 준다.
			if(sheetObj.CellValue(sheetObj.SelectRow, prefix + "exists_tml_dep_rpt_dtl") == "Y"){
				document.all("btn_ExcludefromTPR").style.color = "#e41010";
			}else{
				document.all("btn_ExcludefromTPR").style.color = "#514747";
			}
		}else{
			if(sheetObjects[0].RowCount == 0){
				var prefix = "t1sheet1_";
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

				sheetObjects[0].Redraw = false;    
				sheetObjects[0].WaitImageVisible = false;	
				sheetObjects[0].LoadSearchXml(sXml); 
				sheetObjects[0].Redraw = true; 
				
			}

			document.all("btn_ExcludefromTPR").style.color = "#514747";
 
			opentScreen();
 
			formReadonly(false);
 
			//포커스 이동
			formObj.sys_create.value = "Internally Produced";
		}
	}

	function opentScreen(){
		bRetrive = true;

		//TDR을 들고 온넘을 지울순 없짠아요. ^^
		for(var cnt = 0; cnt < sheetObjects.length - 1; cnt++){
			if(sheetObjects[cnt].id != "t1sheet1"){
				sheetObjects[cnt].RemoveAll();
			}
		}

		setTabEditSheet();
	}

	function closeScreen(){
		bRetrive = false;

		for(var cnt = 0; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
		document.all("btn_ExcludefromTPR").style.color = "#514747";

		frameSheetRemove();

		formReadonly(true);
		bFirstTdrSearch = true;
		multiSearchCheck = false;
	}

	function frameSheetRemove(){
		var frame = document.getElementById("t3frame");
		if(frame.src != ""){
			for(var idx = 0; idx < t3frame.sheetObjects.length; idx++){
				t3frame.sheetObjects[idx].RemoveAll();
			}
		}

		var frame = document.getElementById("t4frame");
		if(frame.src != ""){
			for(var idx = 0; idx < t4frame.sheetObjects.length; idx++){
				t4frame.sheetObjects[idx].RemoveAll();
			}
		}

		var frame = document.getElementById("t5frame");
		if(frame.src != ""){
			for(var idx = 0; idx < t5frame.sheetObjects.length; idx++){
				t5frame.sheetObjects[idx].RemoveAll();
			}
		}

		var frame = document.getElementById("t6frame");
		if(frame.src != ""){
			for(var idx = 0; idx < t6frame.sheetObjects.length; idx++){
				t6frame.sheetObjects[idx].RemoveAll();
			}
		}

		var frame = document.getElementById("t7frame");
		if(frame.src != ""){
			for(var idx = 0; idx < t7frame.sheetObjects.length; idx++){
				t7frame.sheetObjects[idx].RemoveAll();
			}
		}

		var frame = document.getElementById("t8frame");
		if(frame.src != ""){
			for(var idx = 0; idx < t8frame.sheetObjects.length; idx++){
				t8frame.sheetObjects[idx].RemoveAll();
			}
		}

		var frame = document.getElementById("t9frame");
		if(frame.src != ""){
			for(var idx = 0; idx < t9frame.sheetObjects.length; idx++){
				t9frame.sheetObjects[idx].RemoveAll();
			}
		}
	}

	function resetFormNsheet(objText){
		var tmpMenu = new Array();
		var shearchCon = strVVDOptions.split("|");
		var tmpYdNm = "";

		if(objText.name == "vsl_cd"){
		    setObjValue("skd_voy_no", "");
			setObjValue("skd_dir_cd", "");
			setObjValue("yd_cd", "");
		}else if(objText.name == "skd_voy_no"){
			setObjValue("skd_dir_cd", "");
			setObjValue("yd_cd", "");
		}else{
			tmpYdNm = getObjValue("yd_nm");
		}

		for(var cnt = 0; cnt < shearchCon.length; cnt++){
			tmpMenu[cnt] = getObjValue(shearchCon[cnt]);
		}

		document.form.reset();

		for(var cnt = 0; cnt < shearchCon.length; cnt++){
			setObjValue(shearchCon[cnt], tmpMenu[cnt]);
		}

		if(tmpYdNm != "")
			setObjValue("yd_nm", tmpYdNm);
		
		closeScreen();
		
		//해당 그리드로 이동.
		if(marrTabTitle[beforetab] == "Disch. Vol."){
			if(t3frame.beforeDistchVolTab != 0)
				t3frame.disChargTabChange();
		}else if(marrTabTitle[beforetab] == "Load Vol."){
			if(t4frame.beforeLoadVolTab != 0)
				t4frame.disLoadTabChange();
		}else if(marrTabTitle[beforetab] == "Slot"){
			if(t8frame.beforeSlotTab != 0){
				t8frame.disSlotTabChange();
			}
		}

		//포커스 이동.
		if(objText.name == "vsl_cd"){
			ComSetFocus(document.form.skd_voy_no);
		}else if(objText.name == "skd_voy_no"){
			ComSetFocus(document.form.skd_dir_cd);
		}else if(objText.name == "skd_dir_cd"){
			ComSetFocus(document.form.yd_cd);
		}
	}
	
	function setTdrHeaderVal2(formObj, sheetObj){
		var prefix = "sheetTdrH_";

		sheetObj.CellValue(sheetObj.SelectRow, prefix + "gross_work")			=	formObj.gross_work.value;			//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "net_work")			    =	formObj.net_work.value;				//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "lose_hr")			    =	formObj.lost_time.value;			//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "gross_gang")			=	formObj.gross_gang.value;			//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "net_gang")			    =	formObj.net_gang.value;				//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "hatch")			    =	formObj.hatch_handl.value;          //	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "con")					=	formObj.gear_handl.value;			//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "mvs")					=	formObj.move_handl.value;			//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "gross_tml")			=	formObj.tmnl_gross.value;			//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "net_tml")				=	formObj.tmnl_net.value;				//	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "gross_gc")				=	formObj.per_gang_gross.value;       //	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "net_gc")				=	formObj.per_gan_net.value;          //	Departure Tugboat                       //	TUG_DEP      
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "avg_gang")				=	formObj.avg_gang.value;          	//	Departure Tugboat                       //	TUG_DEP      

		
		// 시트에 해당되는 값...
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "commence")				=	document.t2sheet1.CellValue(document.t2sheet1.HeaderRows, "t2sheet1_work_comm");          //	Departure Tugboat                       //	TUG_DEP
 
		
		sheetObj.CellValue(sheetObj.SelectRow, prefix + "complete")				=	document.t2sheet1.CellValue(document.t2sheet1.HeaderRows, "t2sheet1_work_comp");          //	Departure Tugboat                       //	TUG_DEP      
	}

	function getTdrHeaderVal2(formObj, sheetObj, sXml){
		var prefix = "sheetTdrH_";
		
		if(sheetObj.RowCount > 0){
		     
			formObj.gross_work.value			=	sheetObj.CellText(sheetObj.SelectRow, prefix + "gross_work");	
			formObj.net_work.value				=	sheetObj.CellText(sheetObj.SelectRow, prefix + "net_work");		
			formObj.lost_time.value				=	sheetObj.CellText(sheetObj.SelectRow, prefix + "lose_hr");		
			formObj.gross_gang.value			=	sheetObj.CellText(sheetObj.SelectRow, prefix + "gross_gang");	
			formObj.net_gang.value				=	sheetObj.CellText(sheetObj.SelectRow, prefix + "net_gang");		
			formObj.hatch_handl.value          	=	sheetObj.CellText(sheetObj.SelectRow, prefix + "hatch");		
			formObj.gear_handl.value			=	sheetObj.CellText(sheetObj.SelectRow, prefix + "con");	
/*          2010-04-13 Mvs 수정  jkc  Start */
//          formObj.move_handl.value			=	sheetObj.CellText(sheetObj.SelectRow, prefix + "mvs");			
//			formObj.tmnl_gross.value			=	sheetObj.CellText(sheetObj.SelectRow, prefix + "gross_tml");
//			formObj.tmnl_net.value				=	sheetObj.CellText(sheetObj.SelectRow, prefix + "net_tml");		
//			formObj.per_gang_gross.value       	=	sheetObj.CellText(sheetObj.SelectRow, prefix + "gross_gc");		
//			formObj.per_gan_net.value           =	sheetObj.CellText(sheetObj.SelectRow, prefix + "net_gc");		

			formObj.move_handl.value            =   ComAddComma( ComGetEtcData(sXml, "move_handl") );  
			
            formObj.tmnl_gross.value            =   ComAddComma( ComGetEtcData(sXml, "tmnl_gross"    ) );  
            formObj.tmnl_net.value              =   ComAddComma( ComGetEtcData(sXml, "tmnl_net"      ) );      
            formObj.per_gang_gross.value        =   ComAddComma( ComGetEtcData(sXml, "per_gang_gross") );   
            formObj.per_gan_net.value           =   ComAddComma( ComGetEtcData(sXml, "per_gan_net"   ) );  
            /*          2010-04-13 Mvs 수정  jkc  End */
            

			if(ComGetEtcData(sXml, "used_crane") != null || ComGetEtcData(sXml, "used_crane") != undefined){
				formObj.used_crane.value			=	ComGetEtcData(sXml, "used_crane");	
				beforeCraneCnt             			=	ComGetEtcData(sXml, "used_crane");	
				formObj.avg_gang.value				=	tdrRound( ComGetEtcData(sXml, "avg_gang"), 2);
			}else{//
				formObj.used_crane.value			=	"0";	
				beforeCraneCnt                      =   "0";
				formObj.avg_gang.value				=	"0";
			}
			
		}else{
			formObj.gross_work.value			=	"";	
			formObj.net_work.value				=	"";		
			formObj.lost_time.value				=	"";		
			formObj.gross_gang.value			=	"";	
			formObj.net_gang.value				=	"";		
			formObj.hatch_handl.value          	=	"";		
			formObj.gear_handl.value			=	"";			
			formObj.move_handl.value			=	"";			
			formObj.tmnl_gross.value			=	"";
			formObj.tmnl_net.value				=	"";		
			formObj.per_gang_gross.value       	=	"";		
			formObj.per_gan_net.value           =	"";		
			formObj.used_crane.value			=	"0";	
			formObj.avg_gang.value				=	"0";
			beforeCraneCnt                      =   "0";
		}
	}

	function setCraneSheet(){
		var sheetObj = document.t2sheet1;
		
		//첫번째 Row는 조회모드.
		sheetObj.RowStatus(sheetObj.HeaderRows) = "R";
		//어차피 생성된 놈인지 알수가 없음... 모두 Insert 모드...
		for(var idxRow = sheetObj.HeaderRows+1; idxRow <= sheetObj.LastRow; idxRow++){			
			sheetObj.RowStatus(idxRow) = "I";
		}
		if(idxRow > 2){
			return true;
		}else{
			return false;
		}
	}

	function formReadonly(readonly)
	{
		var frmObj = document.getElementsByTagName("form"); 
		var fObj = frmObj.item(0); 
		
		var updateSys = document.form.sys_create.value.toUpperCase().substring(0, 2);
		
		//버튼 Enable/Disable
		for( var k = 0; k < enableButton.length; k++){
			
			//alert(beforetab);
			
			if(readonly){
				//프린트 버트과 Exclude from TPR이외에는 Disable
				if(updateSys == "EX" && (enableButton[k] == "btn_Print" || enableButton[k] == "btn_ExcludefromTPR")){
					ComBtnEnable(enableButton[k]);
					
				//2010.12.27 P.H.D. 추가 Port Log 수정 가능
				}else if(updateSys == "EX" && beforetab == 0 && (enableButton[k] == "btn_Save" || enableButton[k] == "btn_Delete")){
					ComBtnEnable(enableButton[k]);			
				}else{
					ComBtnDisable(enableButton[k]);
				}
			}else{
				ComBtnEnable(enableButton[k]);
			}
		}

		//TextBox  readonly/writable
		for(var idxObj = 0; idxObj < fObj.length; idxObj++){
			var objText = fObj.item(idxObj);
			/*
			if(objText.type == "text" && (	objText.name != "vsl_cd" && 
											objText.name != "skd_voy_no" && 
											objText.name != "skd_dir_cd" && 
											objText.name != "yd_nm" && 
											objText.name != "sys_create_desc" && 
											objText.name != "eta_next_port" && 
											objText.name != "eta_next_date"&& 
											objText.name != "eta_canal" && 
											objText.name != "next_canal")
			){
				objText.readOnly = readonly;
				objText.className = (readonly ? "input2" : "input");
			}
			*/

			/*
				요건 변경 2010-02-18 
				조회조건은 활성화. 나머지 Hatch Cover Handling, Gear Box Handling, Total Container Handling Moves, Remark 는 활성화 비 활성화.
			*/
			if(	objText.name == "vsl_cd" ||
				objText.name == "skd_voy_no" || 
				objText.name == "skd_dir_cd" ){
				objText.readOnly = false;
			}else if(	objText.name == "hatch_handl" || 
						objText.name == "gear_handl" || 
					//	objText.name == "move_handl" || 
						objText.name == "used_crane" ){
				//2010.12.27 P.H.D 추가
				if (updateSys == "EX"){				
					objText.readOnly = false;
					objText.className = "input";
				}else{
					objText.readOnly = readonly;
					objText.className = (readonly ? "input2" : "input");
				}
			}else if(objText.name == "tdr_info"){
				objText.readOnly = readonly;
				objText.className = (readonly ? "input2" : "textarea");
			}else if(objText.type == "text"){
				objText.readOnly = true;
				objText.className = "input2";
			}
		}
		
		//Sheet의 Write설정
		for(var idx = 0; idx < sheetObjects.length - 1; idx++){
			if (updateSys == "EX" && beforetab == 0 && sheetObjects[idx].id == "t2sheet1"){
				sheetObjects[idx].Editable = true;
			}else{
				sheetObjects[idx].Editable = (readonly ? false : true);
				
				
			}
		}
		
		var frame = document.getElementById("t3frame");
		if(frame.src != ""){
			frameButtonSheet(document.t3frame, readonly);
		}
		
		//Loading Volume
		var frame = document.getElementById("t4frame");
		if(frame.src != ""){
			frameButtonSheet(document.t4frame, readonly);
		}

		var frame = document.getElementById("t5frame");
		if(frame.src != ""){
			frameButtonSheet(document.t5frame, readonly);
		}

		var frame = document.getElementById("t6frame");
		if(frame.src != ""){
			frameButtonSheet(document.t6frame, readonly);
		}

		var frame = document.getElementById("t7frame");
		if(frame.src != ""){
			frameButtonSheet(document.t7frame, readonly);
		}

		var frame = document.getElementById("t8frame");
		if(frame.src != ""){
			frameButtonSheet(document.t8frame, readonly);
		}

		var frame = document.getElementById("t9frame");
		if(frame.src != ""){
			frameButtonSheet(document.t9frame, readonly);
		}
		
		//::jsk::2012-02-14 Load Vol. 탭일경우에만 실행.
		////::jsk::fncLoadVolBBSheetCellControl();
		
	}

	function frameButtonSheet(objFrame, readonly){
		//Button Enable
		for( var k = 0; k < objFrame.enableButton.length; k++){
			if(readonly){
				objFrame.ComBtnDisable(objFrame.enableButton[k]);
			}else{
				objFrame.ComBtnEnable(objFrame.enableButton[k]);
			}
		}

		for(var idx = 0; idx < objFrame.sheetObjects.length; idx++){
			objFrame.sheetObjects[idx].Editable = (readonly ? false : true);
			
//			var updateSys	= document.form.sys_create.value.toUpperCase().substring(0,2);
//			
//			/* Load Vol. 탭의 Break-Bulk 시트 Work Time 컬럼 컨트롤 */
//			
///*			alert(updateSys);
//			alert(objFrame.sheetObjects[idx].id);
//			alert(t4frame.document.form.chk_LoadVol[3].checked);*/
//			
//			if(updateSys == 'EX' && objFrame.sheetObjects[idx].id == 't4sheet4' && t4frame.document.form.chk_LoadVol[3].checked == true)
//			{
//				
//			
//				//::jsk::
//				/*
//				 * Externally + Load Vol. 탭 + Break-Bulk 시트 "Save"버튼 활성화
//				 */
//				 
//				 //alert('kkk');
//				 //alert(t4frame.document.form.chk_LoadVol[3].checked);
//				 
///*				if(t4frame.document.form.chk_LoadVol[3].checked == true){
//					parent.ComBtnEnable("btn_Save");
//				}else{
//					parent.ComBtnDisable("btn_Save");
//				}*/						
//				
//				ComBtnEnable("btn_Save");
//				objFrame.sheetObjects[idx].Editable	= true;
//				
//				alert('before ==> '+objFrame.sheetObjects[idx].id);
//				
////				for(var inx = 1; inx <= objFrame.sheetObjects[idx].LastRow; inx++)
////				{
////					/* Externally인 경우 , Work Time (commence+complete) 2개 컬럼만 활성화 */	
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_commence") 	= true;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_complete") 	= true;
////					
////					alert('inner');
////					
////					/* column editable = false */
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_del_chk") 	= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_pod") 		= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_dml") 		= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_dmb") 		= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_dmh") 		= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_slot") 		= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_weight") 	= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_crane") 		= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_opr_cd")		= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_cntr_no")	= false;
////					objFrame.sheetObjects[idx].CellEditable(inx, "t4sheet4_cod_chk")	= false;
////					
////					alert('inner2');					
////				}				
//			}
		}
	}

 	/**
    * Loading Vol. 탭에서 Break Bulk 시트(radio) 선택시에만 Save버튼 활성화 시킨다.
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
  	function fncLoadVolBBSheetCellControl(){
    	
    	//::JSK:: document.form.sys_create.value.toUpperCase().substring(0,2)
		var updateSys	= document.form.sys_create.value.toUpperCase().substring(0,2);
		
		//alert(updateSys);
		//alert(document.t4frame.document.form.chk_LoadVol[3].checked);

		if(updateSys == 'EX' && document.t4frame.document.form.chk_LoadVol[3].checked == false){
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
		}
		
		if(updateSys != 'EX' || document.t4frame.document.form.chk_LoadVol[3].checked == false || document.t4frame.document.form.chk_LoadVol[3].checked == "" ){
			return false;			
		}
		
		//alert('2-3');
		
		document.t4frame.document.t4sheet4.Editable	= true;
		
		//alert('2-4');
		
		for(var inx = 1; inx <= document.t4frame.document.t4sheet4.LastRow; inx++)
		{
			/* Externally인 경우 , Work Time (commence+complete) 2개 컬럼만 활성화 */	
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_commence"	) 	= true;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_complete"	) 	= true;
			
			/* column editable = false */
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_del_chk"		) 	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_pod"			) 	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_dml"			) 	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_dmb"			) 	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_dmh"			) 	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_slot"		) 	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_weight"		) 	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_crane"		) 	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_opr_cd"		)	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_cntr_no"		)	= false;
			document.t4frame.document.t4sheet4.CellEditable(inx, "t4sheet4_cod_chk"		)	= false;	
		}
		
		//alert('2-5');
		
		/*
		 * Externally + Load Vol. 탭 + Break-Bulk 시트 "Save"버튼 활성화
		 */
		ComBtnEnable("btn_Save");	
		
		//alert('2-6');
		
	} 	
	
	/**
	 * 2010.12.21 P.H.D. 추가 Slot 탭을 위해 별도로 만듬...
	 * Externally일 경우 BSA는 수정불가, HC 4/5내 loaded, add slot은 수정불가, 그외는 모두 수정가능
	 * @param objFrame
	 * @param subTabNo
	 */
	function frameButtonSheetSub(objFrame, subTabNo){
		gSubTabNo = subTabNo;

		var readOnly = true;
		var updateSys = "NU";
		if (document.form.sys_create.value.length > 0){
			updateSys = document.form.sys_create.value.toUpperCase().substring(0,2)
		}

		if (updateSys == "IN"){
			readOnly = false;
		}else if (updateSys == "EX"){
			//Slot(Port), Slot(DEP)탭은 수정불가
			if (subTabNo == 2 || subTabNo == 3){				
				readOnly = true;
			}else{
				readOnly = false;
			}
		}else{
			readOnly = true;
		}
		
		//Main Button Handing
		for( var k = 0; k < enableButton.length; k++){
			if(readOnly){
				if(updateSys == "EX" && (enableButton[k] == "btn_Print" || enableButton[k] == "btn_ExcludefromTPR")){
					ComBtnEnable(enableButton[k]);
				}else{
					ComBtnDisable(enableButton[k]);
				}
			}else{
				ComBtnEnable(enableButton[k]);
			}
		}

		//Button Enable
		for( var k = 0; k < objFrame.enableButton.length; k++){
			if(readOnly){
				objFrame.ComBtnDisable(objFrame.enableButton[k]);
			}else{
				//readOnly false여도 EX이면 row버튼을 disable시킨다.
				if (updateSys == "EX"){
					objFrame.ComBtnDisable(objFrame.enableButton[k]);
				}else{
					objFrame.ComBtnEnable(objFrame.enableButton[k]);
				}
			}
		}

		for(var idx = 0; idx < objFrame.sheetObjects.length; idx++){
			objFrame.sheetObjects[idx].Editable = (readOnly ? false : true);
		}
	}
	
	function calenderCall(srcName){
		if(document.form.sys_create.value.substring(0, 2) == "In"){
			var objName = srcName.substring(4);
			var cal = new ComCalendar();
			cal.select(document.form.item(objName), 'yyyy-MM-dd');
			document.form.item(objName).value = document.form.item(objName).value;
		}
	}
	
	function setTabEditSheet(){ 
		sheetCheckEdit = new Array();
		switch(marrTabTitle[beforetab]){
			case "Port Log":
				sheetCheckEdit[0] = document.sheetTdrH;
				sheetCheckEdit[1] = document.t2sheet1;
				break;
			case "Disch. Vol.":
				sheetCheckEdit[0] = document.sheetTdrH;
				if(t3frame.document.t3sheet1 != null && t3frame.document.t3sheet1 != undefined){
					sheetCheckEdit[1] = t3frame.document.t3sheet1;
					sheetCheckEdit[2] = t3frame.document.t3sheet2;
					sheetCheckEdit[3] = t3frame.document.t3sheet3;
				}
				break;
			case "Load Vol.":
				sheetCheckEdit[0] = document.sheetTdrH;
				if(t4frame.document.t4sheet1 != null && t4frame.document.t4sheet1 != undefined){
					sheetCheckEdit[1] = t4frame.document.t4sheet1;
					sheetCheckEdit[2] = t4frame.document.t4sheet2;
					sheetCheckEdit[3] = t4frame.document.t4sheet3;
					sheetCheckEdit[4] = t4frame.document.t4sheet4;
				}

				break;
			case "COD":
				sheetCheckEdit[0] = document.sheetTdrH;
				if(t5frame.document.t5sheet1 != null && t5frame.document.t5sheet1 != undefined){
					sheetCheckEdit[1] = t5frame.document.t5sheet1;
				}
				break;
			case "R/H":
				sheetCheckEdit[0] = document.sheetTdrH;
				if(t6frame.document.t6sheet1 != null && t6frame.document.t6sheet1 != undefined){
					sheetCheckEdit[1] = t6frame.document.t6sheet1;
				}
				break;
			case "Mishandle":
				sheetCheckEdit[0] = document.sheetTdrH;
				if(t7frame.document.t7sheet1 != null && t7frame.document.t7sheet1 != undefined){
					sheetCheckEdit[1] = t7frame.document.t7sheet1;
				}
				break;
			case "Slot":
				sheetCheckEdit[0] = document.sheetTdrH;
				if(t8frame.document.t8sheet1 != null && t8frame.document.t8sheet1 != undefined){
					sheetCheckEdit[1] = t8frame.document.t8sheet1;
					sheetCheckEdit[2] = t8frame.document.t8sheet2;
					sheetCheckEdit[3] = t8frame.document.t8sheet3;
					sheetCheckEdit[4] = t8frame.document.t8sheet4;
				}
				break;
			case "Temp. STWG":
				sheetCheckEdit[0] = document.sheetTdrH;
				if(t9frame.document.t9sheet1 != null && t9frame.document.t9sheet1 != undefined){
					sheetCheckEdit[1] = t9frame.document.t9sheet1;
				}
				break;
			case "Remark(s)":
				sheetCheckEdit[0] = document.sheetTdrH;
				break;
		}
	}

	function sheetRemoveAll(){
		sheetCheckEdit[0].RowStatus(sheetCheckEdit[0].SelectRow) = "R";
		for(var cnt = 1; cnt < sheetCheckEdit.length; cnt++){
			sheetCheckEdit[cnt].RemoveAll();
		}
	}
	
	function calcuPortLog(formObject, sheetObj){
		var prefix = "t2sheet1_";
		/*
			=================================	Port Log 계산방법	=================================
			0. Average Number of Used Crane =  Gross Gang Hours / Gross Work Hours
			1. Gross Working Hours = 각 Crane중 Max Work Completed – 각 Crane중 Min Work Commenced
			2. Net Working Hours = 각 Crane Work Time (Completed-Commence) 중 Max 값
			3. Lost Time by G/Crane = Gross Work Hours – Net Work Hours
			4. Gross Gang Hours = 각 Crane Work Time (Completed-Commence)을 합한 값
			5. Net Gang Hours = Gross Gang Hours에서 각 Crane의 Lost Time을 뺀 값
			6. Terminal Gross = Total Container Handling Moves / Gross Work Hours
			7. Terminal Net = Total Container Handling Moves / Net Work Hours
			8. Per Gang Gross = Total Container Handling Moves / Gross Gang Hours
			9. Per Gang Gross = Total Container Handling Moves / Net Gang Hours

			-- 2009-10-15 수정
			2. Net Working Hours = 각 Crane Work Time (Completed-Commence) 중 Max 값 
								   같은값이 2개이상이면 그중 Total Loas Time중 Max값
			3. Lost Time by G/Crane = Max Row 의 Completed - Commence - Total Lose Time

			-- 2009-10-27 수정
			Number of Used Crane을 0인 상태에서 Tdr헤더만의 정보만 수정시에. Productivity 수정가능.
			==========================================================================================
		*/
		with(sheetObj){
			if(RowCount < 2){
				calcuPortLogHeader();
				return true;
			}
			var maxNetWork = 0;
			var sumGang = 0;
			var sumLose = 0;
			var idxMaxTime = "";
			var losework = 0;
			for(var idxRow = HeaderRows + 1; idxRow <= LastRow; idxRow++){
				var tmpMM = EvalDateDiff("N", CellText(idxRow, prefix + "work_comm") + ":00", CellText(idxRow, prefix + "work_comp") + ":00");

				if(maxNetWork < tmpMM){
					maxNetWork = tmpMM;
					idxMaxTime = idxRow + ",";
				}else if(maxNetWork == tmpMM){
					idxMaxTime = idxMaxTime + idxRow +  ",";
				}

/*
				var arrHHMM = CellText(idxRow, prefix + "total").split(":");
				var loseMM = parseInt(arrHHMM[0]) * 60 + parseInt(arrHHMM[1]);
*/
				var loseMM = parseHHMM(CellText(idxRow, prefix + "total"));
				sumLose += loseMM;
				sumGang += tmpMM;
				
				if (tmpMM-loseMM < 0){
					ComShowCodeMessage("OPF50042"); 
					//alert("idxMaxLose: "+idxMaxLose + ", maxNetWork-losework: "+ (maxNetWork-losework));
					SelectCell(idxRow, prefix + "work_comp");				
					return false;
				}
			}
			var glossTemp = EvalDateDiff("N", CellText(HeaderRows, prefix + "work_comm") + ":00", 
								              CellText(HeaderRows, prefix + "work_comp") + ":00");

			formObject.gross_work.value = parseInt(glossTemp / 60) + ":" + fillZero(glossTemp % 60);

			//Completed-Commence의 Max지만 같은 값이 있으면. Lose의 최고값을 찾아낸다...
			var arrSearchLose = idxMaxTime.split(",");
 
			var idxMaxLose = 0;
			var valMaxLose = 0;
			if(arrSearchLose.length > 2){
				for(var idxFind = 0; idxFind < arrSearchLose.length - 1; idxFind++){
					var arrHHMM = CellText(parseInt(arrSearchLose[idxFind]), prefix + "total").split(":");
					var tempLose = parseInt(arrHHMM[0], 10) * 60 + parseInt(arrHHMM[1], 10);

					if(valMaxLose < tempLose){
						idxMaxLose = parseInt(arrSearchLose[idxFind]);
						valMaxLose = tempLose;
					//lose time 이 없을 경우 idxMaxLose 셋팅
					} else if(valMaxLose == 0 && tempLose == 0){
						idxMaxLose = parseInt(arrSearchLose[idxFind]);
					}
				}
				//아무것두 선택이 되지 않았을때.........
				if(valMaxLose < 0){
					idxMaxLose = parseInt(arrSearchLose[0]);
					valMaxLose = 0;
				}
			}else{
				idxMaxLose = parseInt(arrSearchLose[0]);

				var arrHHMM = CellText(parseInt(arrSearchLose[0]), prefix + "total").split(":");
				valMaxLose = parseInt(arrHHMM[0], 10) * 60 + parseInt(arrHHMM[1], 10);
			}
/*
			maxNetWork = EvalDateDiff("N", CellText(idxMaxLose, prefix + "work_comm") + ":00", CellText(idxMaxLose, prefix + "work_comp") + ":00");
			losework = maxNetWork - valMaxLose;
*/			
			maxNetWork = EvalDateDiff("N", CellText(idxMaxLose, prefix + "work_comm") + ":00", CellText(idxMaxLose, prefix + "work_comp") + ":00");
			losework = valMaxLose;

			if (maxNetWork-losework < 0){
				ComShowCodeMessage("OPF50042"); 
				//alert("idxMaxLose: "+idxMaxLose + ", maxNetWork-losework: "+ (maxNetWork-losework));
				SelectCell(idxMaxLose, prefix + "work_comp");				
				return false;
			}
			
			maxNetWork -= losework;

			formObject.net_work.value = parseInt(maxNetWork / 60) + ":" + fillZero(maxNetWork % 60);
			formObject.lost_time.value = parseInt(losework / 60) + ":" + fillZero(losework % 60);
			 
			formObject.gross_gang.value = parseInt(sumGang / 60) + ":" + fillZero(sumGang % 60);
			//var netGang = sumGang - (glossTemp - maxNetWork);
			var netGang = sumGang - sumLose;
			formObject.net_gang.value = parseInt(netGang / 60) + ":" + fillZero(netGang % 60);
			
			//Gross Gang Hours / Gross Work Hours
			formObject.avg_gang.value = tdrRound(sumGang / glossTemp);
 
/*
			if(formObject.move_handl.value != ""){
				formObject.tmnl_gross.value = ComRound(parseInt(formObject.move_handl.value) / parseFloat(glossTemp / 60), 1);
				formObject.tmnl_net.value = ComRound(parseInt(formObject.move_handl.value) / parseFloat(maxNetWork / 60), 1);
				formObject.per_gang_gross.value = ComRound(parseInt(formObject.move_handl.value) / parseFloat(sumGang / 60), 1);
				formObject.per_gan_net.value = ComRound(parseInt(formObject.move_handl.value) / parseFloat(netGang / 60), 1);
			}

*/
			if(formObject.move_handl.value != ""){
				calcuPortLogHeader();
			}
		}
		return true;
	}

	function calcuPortLogHeader(){
		var formObject = document.form; 

		//Total Container Handling Moves가 없을시에 Pass...
		if(formObject.move_handl.value == "")
			return;
 
		var moveHandle = parseInt(ComReplaceStr(formObject.move_handl.value, ",", ""));
      log(   formObject.gross_work.value.replace(":","")   );
		if(formObject.gross_work.value != "" && parseInt(  formObject.gross_work.value.replace(":","") )  != 0   ){
			formObject.tmnl_gross.value = tdrRound(moveHandle / parseFloat(parseHHMM(formObject.gross_work.value) / 60), 1);

		}
		if(formObject.net_work.value != "" && parseInt(  formObject.net_work.value.replace(":","") )  != 0  ){
			formObject.tmnl_net.value = tdrRound(moveHandle / parseFloat(parseHHMM(formObject.net_work.value) / 60), 1);
		}
		if(formObject.gross_gang.value != "" && parseInt(  formObject.gross_gang.value.replace(":","") )  != 0  ){
			formObject.per_gang_gross.value = tdrRound(moveHandle / parseFloat(parseHHMM(formObject.gross_gang.value) / 60), 1);
		}
		if(formObject.net_gang.value != "" && parseInt(  formObject.net_gang.value.replace(":","") )  != 0  ){
			formObject.per_gan_net.value = tdrRound(moveHandle / parseFloat(parseHHMM(formObject.net_gang.value) / 60), 1);
		}
		if( formObject.gross_work.value != "" && formObject.gross_gang.value != ""
		){
 
		    if ( parseInt(  formObject.gross_work.value.replace(":","") )  != 0 
		      && parseInt(  formObject.gross_gang.value.replace(":","") )  != 0 ){ 
		        formObject.avg_gang.value = tdrRound(parseHHMM( formObject.gross_gang.value ) / parseHHMM( formObject.gross_work.value ));
		    }else if ( parseInt(  formObject.gross_work.value.replace(":","") )  != 0 ){
		        formObject.avg_gang.value =  formObject.gross_work.value  ;
		    }else if ( parseInt(  formObject.gross_gang.value.replace(":","") )  != 0 ){
                formObject.avg_gang.value =  formObject.gross_gang.value  ;
            }
            
		} 
	}

	function fillZero(str){
		if(parseInt(str) < 10){
			str = "0" + str;
		}

		return str;
	}

	function parseHHMM(hhmm){
		var arrHHMM = hhmm.split(":");
		var strHH = arrHHMM[0];
		var strMM = arrHHMM[1];
		
		var sumMM = 0;
		if(strHH.substring(0, 2) == "00"){
			sumMM = parseInt(strHH.substring(2)) * 60;
		}else if(strHH.substring(0, 1) == "0"){
			sumMM = parseInt(strHH.substring(1)) * 60;
		}else{
			sumMM = parseInt(strHH) * 60;
		}

		if(strMM.substring(0, 1) == "0"){
			sumMM += parseInt(strMM.substring(1));
		}else{
			sumMM += parseInt(strMM);
		}

		return sumMM;
	}

	function setSheetIdx(sheetObj, idx, colNm){
		for(var cnt = sheetObj.HeaderRows; cnt <= sheetObj.LastRow; cnt++){
			if(sheetObj.RowStatus(cnt) == "I" || sheetObj.RowStatus(cnt) == "U" || sheetObj.RowStatus(cnt) == "D"){
				sheetObj.CellValue(cnt, sheetObj.id + "_" + colNm) = idx;
			}
		}
	}
	
	function filterMishandle(sheetObj, misHandleChk){
		for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
			if(sheetObj.CellValue(idxRow, "t7sheet1_mishandle_chk") == misHandleChk){
				sheetObj.RowHidden(idxRow) = false;
			}else{
			    if( sheetObj.RowCount != 0 ){
			        sheetObj.RowHidden(idxRow) = true;
			    }
			}
		}
	}

	function jshUseVal(formObj){
		formObj.vsl_cd.value = "HJCQ";
		formObj.skd_voy_no.value = "0005";
		formObj.skd_dir_cd.value = "W";

		searchVVDInfo();

		document.form.yd_cd.Code = "KRPUSYG";

		//doActionIBSheet(beforetab, formObj, IBSEARCH);
	}
	
	function dupcheckSave(tabNm, tabChange){
		var idxRow = 0;
		var dupRow = 0;

		var	dupSheet = null;
		var	dupCol = null;
		
		switch(tabNm){
			case "Disch. Vol.":
				dupSheet = new Array();
				dupCol = new Array();

				dupSheet[0] = t3frame.document.t3sheet1;
				dupSheet[1] = t3frame.document.t3sheet2;
				dupSheet[2] = t3frame.document.t3sheet3;
				
				dupCol[0] = "t3sheet1_opr_cd";
				dupCol[1] = "t3sheet2_opr_cd";
				dupCol[2] = "t3sheet3_opr_cd|t3sheet3_cntr_no";

				break;

			case "Load Vol.":
				dupSheet = new Array();
				dupCol = new Array();

				dupSheet[0] = t4frame.document.t4sheet1;
				dupSheet[1] = t4frame.document.t4sheet2;
				dupSheet[2] = t4frame.document.t4sheet3;
				dupSheet[3] = t4frame.document.t4sheet4;
				
				dupCol[0] = "t4sheet1_opr_cd|t4sheet1_pod_cd";
				dupCol[1] = "t4sheet2_opr_cd|t4sheet2_pod_cd";
				dupCol[2] = "t4sheet3_opr_cd|t4sheet3_pod";
				dupCol[3] = "t4sheet4_pod|t4sheet4_opr_cd|t4sheet4_cntr_no";

				break;

			case "COD":
				dupSheet = new Array();
				dupCol = new Array();

				dupSheet[0] = t5frame.document.t5sheet1;
				
				dupCol[0] = "t5sheet1_cntr_no|t5sheet1_opr_cd";

				break;

			case "R/H":
				dupSheet = new Array();
				dupCol = new Array();

				dupSheet[0] = t6frame.document.t6sheet1;
				
				dupCol[0] = "t6sheet1_cntr_no|t6sheet1_opr_cd";

				break;

			case "Mishandle":
				dupSheet = new Array();
				dupCol = new Array();

				dupSheet[0] = t7frame.document.t7sheet1;
				
				dupCol[0] = "t7sheet1_cntr_no|t7sheet1_opr_cd";

				break;

			case "Slot":
				dupSheet = new Array();
				dupCol = new Array();

				dupSheet[0] = t8frame.document.t8sheet1;
				dupSheet[1] = t8frame.document.t8sheet2;
				dupSheet[2] = t8frame.document.t8sheet3;
				dupSheet[3] = t8frame.document.t8sheet4;
				
				dupCol[0] = "t8sheet1_opr_cd";
				dupCol[1] = "t8sheet2_opr_cd";
				dupCol[2] = "t8sheet3_opr_cd";
				dupCol[3] = "t8sheet4_opr_cd";

				break;

			case "Temp. STWG":
				dupSheet = new Array();
				dupCol = new Array();

				dupSheet[0] = t9frame.document.t9sheet1;
				
				dupCol[0] = "t9sheet1_cntr_no|t9sheet1_opr_cd";

				break;
		}

		if(dupSheet != "undefined" && dupSheet != null){
			for( ; idxRow < dupSheet.length; idxRow++){
				dupRow = dupSheet[idxRow].ColValueDup(dupCol[idxRow], true);

				if(dupRow != -1){
					break;
				}
			}

			if(dupRow != -1){
				var arrColName = dupCol[idxRow].split("|");
				if(dupSheet.length > 1){
					if(tabNm == "Disch. Vol." && t3frame.beforeDistchVolTab != idxRow){
						t3frame.document.form.chk_DischVol[idxRow].checked = true;
						t3frame.disChargTabChange();
					}

					if(tabNm == "Load Vol." && t4frame.beforeDistchVolTab != idxRow){
						t4frame.document.form.chk_LoadVol[idxRow].checked = true;
						t4frame.disLoadTabChange();
					}
				}
				
				ComShowCodeMessage("COM131302", "Data"); 
				
				for(idxCol = 0; idxCol < arrColName.length; idxCol++){
					dupSheet[idxRow].CellValue(dupRow, arrColName[idxCol]) = "";
				}

				dupSheet[idxRow].SelectCell(dupRow, arrColName[0], true);
				
				if(tabChange){
					tabObjects[0].SelectedIndex = beforetab;
				}
				return false;
			}
		}

		return true;
	}
 
	function multiInputCheck(){
		for (var idxArr = 1; idxArr < sheetCheckEdit.length; idxArr++){
			if( parseInt(sheetCheckEdit[idxArr].RowCount("I")) + 
				parseInt(sheetCheckEdit[idxArr].RowCount("U")) + 
				parseInt(sheetCheckEdit[idxArr].RowCount("D"))		> 0 ){
				var sParam = ComGetSaveString(sheetCheckEdit[idxArr]);

				if(sParam == ""){
					if(marrTabTitle[beforetab] == "Disch. Vol." && t3frame.beforeDistchVolTab != (idxArr - 1)){
						t3frame.document.form.chk_DischVol[idxArr - 1].checked = true;
						t3frame.disChargTabChange();
					}
					
					if(marrTabTitle[beforetab] == "Load Vol." && t4frame.beforeLoadVolTab != (idxArr - 1)){
						t4frame.document.form.chk_LoadVol[idxArr - 1].checked = true;
						t4frame.disLoadTabChange();
					}

					if(marrTabTitle[beforetab] == "Slot" && t8frame.beforeSlotTab != (idxArr - 1)){
						t8frame.document.form.chk_Slot[idxArr - 1].checked = true;
						t8frame.disSlotTabChange();
					}

					return false;
				}
			}
		}

		return true;
	}

	function duplCheck(sheetObj,Row, Col, Value, chkCol){
		var dupRow = sheetObj.ColValueDup(chkCol, true);
		
		var arrCheckCol = chkCol.split("|");

		if(arrCheckCol == null || arrCheckCol.length < 2){
			if(dupRow != -1 && sheetObj.CellValue(dupRow, chkCol) != '') {
				ComShowCodeMessage('COM131302', "Data"); 
				sheetObj.CellValue(dupRow, Col) = "";

				//해당 Row포커스.. ....
				sheetObj.SelectCell(dupRow, chkCol, true);
				return;
			}
		}else{
			if(dupRow != -1){
				for(var cnt = 0; cnt < arrCheckCol.length; cnt++){
					if(sheetObj.CellValue(dupRow, arrCheckCol[cnt]) == ''){
						return;
					}
				}

				ComShowCodeMessage('COM131302', "Data"); 
				for(var cnt = 0; cnt < arrCheckCol.length; cnt++){
					sheetObj.CellValue(dupRow, arrCheckCol[cnt]) = "";
				}

				//해당 Row포커스.. ....
				sheetObj.SelectCell(dupRow, arrCheckCol[0], true);
				return;
			}
		}
	}

	/**
	 * 화면 컨트롤 End
	 */

	 /**
	  * Popup 클릭시 Call Back Start ...
	  */

	function setCallBackVSL(rtnObjs) {
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("vsl_cd", rtnDatas[1]);
					obj_nextfocus(document.form.vsl_cd);
				}
			}
		}
	} 

	function setCallBackVVD(obj) {
		if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
				setObjValue("skd_voy_no", rtnDatas[2]);
				setObjValue("skd_dir_cd", rtnDatas[3]);
				}
			}
		}
		
		//[#1-2]VVD 관련 항목 채우기
		searchVVDInfo();
	} 

	function setCallBackPort(rtnObjs){
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("eta_next_port", rtnDatas[3]);
				}
			}
		}
	}

	function getCallBackOprCd(sheetObj, prefix, colNm, Row, Col){
		popupSheet = sheetObj;
		popupPrefix = prefix;
		popupColNm = colNm;

		ComOpenPopup("COM_ENS_0N1.do", 430, 450, "setCallBackOprCd", "0,0,1,1,1,1", true, false, Row, Col, 0);
	}

	function setCallBackOprCd(rtnObjs){
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					popupSheet.CellValue(popupSheet.SelectRow, popupPrefix + popupColNm) = rtnDatas[3];

					if(popupSheet.SaveNameCol(popupSheet.id + "_chk_valid") > 0){
						popupSheet.CellValue(popupSheet.SelectRow, popupSheet.id + "_chk_valid") = "Y";
					}
				}
			}
		}
		mCheckValue = false;
	}
	 /**
	  * Popup 클릭시 Call Back End ...
	  */
	

	/**
     * Screen New
	 */
	function tdrScreenNew(formObject, checkFlag){
		var changeSheet2 = false;
//      Req : 2010-04-06 서부장님요구사항. : New 버튼 사용시, 무조건 바로 클리어 		
//		if(checkFlag){
//			if(sheetCheckEdit != null){
//				if(sheetCheckEdit.length != null){
//					for(var cnt = 0; cnt < sheetCheckEdit.length; cnt++){
//						if(
//							(
//								parseInt(sheetCheckEdit[cnt].RowCount("I")) + 
//								parseInt(sheetCheckEdit[cnt].RowCount("U")) + 
//								parseInt(sheetCheckEdit[cnt].RowCount("D"))
//							) 
//							> 0
//						){
//								changeSheet2 = true;
//								break;
//						}
//					}
//				}
//			}
//		}
//
//		if(changeSheet2 && !ComShowCodeConfirm("COM130504")){
//			return;
//		}

 	
		formObject.vsl_cd.value = "";
		
		resetFormNsheet(formObject.vsl_cd);
		formObject.vsl_cd.focus();
		
		if(marrTabTitle[beforetab] == "Disch. Vol."){
		     t3frame.form.chk_DischVol[0].checked = true;
			//document.form.chk_DischVol[0].checked = true;   2010.03.31 Bug 수정 - Jkc
			if(t3frame.beforeDistchVolTab != 0)
			    t3frame.disChargTabChange();
		}else if(marrTabTitle[beforetab] == "Load Vol."){
		    t4frame.form.chk_LoadVol[0].checked = true;  //2010.03.31 Bug 수정 - Jkc
			if(t4frame.beforeLoadVolTab != 0)
			    t4frame.disLoadTabChange(); //2010.03.31 Bug 수정 - Jkc
		}else if(marrTabTitle[beforetab] == "Slot"){
		    t8frame.form.chk_Slot[0].checked = true;
			if(t8frame.beforeSlotTab != 0){
			    t8frame.disSlotTabChange();
			}
		}

		multiSearchCheck = false;
		mCheckValue = false;
	}

	function readonlStatus(){
		var parentReaonly = true;
		if(document.sheetTdrH.RowCount > 0){
			if (document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow, "sheetTdrH_update_sys") == "N"){
				parentReaonly = false;
			}else{
				
				//2010.12.21 P.H.D. 추가, COD, R/H, Mishandling, Slot, Temp.STWG, Remark는 Externally여도 수정 가능하다.
				if (beforetab == 3 || beforetab == 4 || beforetab == 5 || beforetab == 6 || beforetab == 7 || beforetab == 8){
					parentReaonly = false;
				}
			}
		}else if(document.form.sys_create.value.toUpperCase().substring(0, 2) == "IN"){
			parentReaonly = false;			
		}
		return parentReaonly; 
	}

	function tdrRound(obj, posN){
        if (posN==undefined || posN==null ) posN = 2;

		var rstFloat = ComRound(obj, posN);
		var strFloat = rstFloat + "";
		var flt = "";

		if(strFloat.indexOf(".") == -1){
			for(var cnt = 0; cnt < posN; cnt++){
				flt = flt + "0";
			}
			strFloat = strFloat + "." +  flt;
		}else{
			var arrFloat = strFloat.split(".");
			if(arrFloat[1].length < posN){
				for(var cnt = arrFloat[1].length; cnt < posN; cnt++){
					flt = flt + "0";
				}
				strFloat = strFloat + flt;
			}
		}

		return strFloat;
	}
    function tdr0Null(obj){
        obj = ComReplaceStr(obj, ",","");
        if( eval( obj ) ==  0 )return "";
        return obj;
    }
    function tdrRoundNull(obj, posN){
        if (posN==undefined || posN==null ) posN = 2;
 
        if ( obj == ""  ){
            return "";
        }else {
            obj  =  obj.replaceStr(",","");
            if( eval( obj ) ==  0 )return "";
        }
        var rstFloat = ComRound(obj, posN);
        var strFloat = rstFloat + "";
        var flt = "";

        if(strFloat.indexOf(".") == -1){
            for(var cnt = 0; cnt < posN; cnt++){
                flt = flt + "0";
            }
            strFloat = strFloat + "." +  flt;
        }else{
            var arrFloat = strFloat.split(".");
            if(arrFloat[1].length < posN){
                for(var cnt = arrFloat[1].length; cnt < posN; cnt++){
                    flt = flt + "0";
                }
                strFloat = strFloat + flt;
            }
        }

        return strFloat;
    }
	function checkExcelValidate(){
		var prefix = "t6sheet1_";
		var rtn = true;
		t6sheet1_loopCheck = true;
		for(var idxRow = sheetCheckEdit[1].HeaderRows; idxRow <= sheetCheckEdit[1].LastRow; idxRow++){
			// i-Stowage 에서 I/F 된 데이터도 Save 처리시 함께 Validation 처리 되도록 조건을 제외 시킴 2011.07.28 - 송호진
			//if(sheetCheckEdit[1].CellValue(idxRow, prefix + "check_row") == "N"){
				//Cntr Check...........
				// 1. Container No. 체크.
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "cntr_no") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "Container No." );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "cntr_no", true);
					rtn = false;
					break;
				}else{
					if(!ComIsAlphabet(sheetCheckEdit[1].CellValue(idxRow,  prefix + "cntr_no"), "n")) {
						sheetCheckEdit[1].CellValue(idxRow,  prefix + "cntr_no") = "";
						sheetCheckEdit[1].SelectCell(idxRow,  prefix + "cntr_no", true);
						rtn = false;
						break;
					}
				}
				
				// 신규로 Mandatory Option 을 가지게 된 두개의 컬럼에 대해 기존의 데이터도 체크가 되도록
				// 조건 바깥에 Check Logic 을 추가함. 2011.06.15 - 송호진
				// 2. Responsible CNTR No. 체크.
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "respb_cntr_no") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "Responsible CNTR No." );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "respb_cntr_no", true);
					rtn = false;
					break;
				}
				
				//FE 필수체크
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "fe") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "F/M" );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "fe", true);
					rtn = false;
					break;
				}
				
				// 3. Operator 체크.
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "opr_cd") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "Operator" );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "opr_cd", true);
					rtn = false;
					break;
				}else{
					var rtnVal = checkOprCd(sheetCheckEdit[1], idxRow, sheetCheckEdit[1].SaveNameCol(prefix + "opr_cd")); //sheetObj.
					if(rtnVal){
						rtn = false;
						break;
					}
					//체크이후에. 만약 정확한 데이터 입력하지 않을시에. 다른로직을 타지 않게...
					if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "opr_cd") == ""){
						rtn = false;
						break;
					}
				}

				// 4. From Position 체크.
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "precell") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "From Position" );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "precell", true);
					rtn = false;
					break;
				}else{
					if(!ComIsNumber(sheetCheckEdit[1].CellValue(idxRow,  prefix + "precell"))) {
						sheetCheckEdit[1].CellValue(idxRow,  prefix + "precell") = "";
						sheetCheckEdit[1].SelectCell(idxRow,  prefix + "precell", true);
						rtn = false;
						break;
						//return false;		//무슨Message?
					}
				}

				// 5. To Position 체크.
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "position") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "To Position" );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "position", true);
					rtn = false;
					break;
				}else{
					if(!ComIsNumber(sheetCheckEdit[1].CellValue(idxRow,  prefix + "position"))) {
						sheetCheckEdit[1].CellValue(idxRow,  prefix + "position") = "";
						sheetCheckEdit[1].SelectCell(idxRow,  prefix + "position", true);
						rtn = false;
						break;
					}
				}

				// 6. Reason 체크.
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "shift_rsn") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "Reason" );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "shift_rsn", true);
					rtn = false;
					break;
				}else{
					checkShiftReason(sheetCheckEdit[1], idxRow, sheetCheckEdit[1].SaveNameCol(prefix + "shift_rsn"), sheetCheckEdit[1].CellValue(idxRow, sheetCheckEdit[1].SaveNameCol(prefix + "shift_rsn")));

					//체크이후에. 만약 정확한 데이터 입력하지 않을시에. 다른로직을 타지 않게...
					if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "shift_rsn") == ""){
						rtn = false;
						break;
					}
				}

				// 7. Account 체크.
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "account") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "Account" );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "account", true);
					rtn = false;
					break;
				}else{
					var rtnVal = checkOprCd(sheetCheckEdit[1], idxRow, sheetCheckEdit[1].SaveNameCol(prefix + "account")); //sheetObj.
					if(rtnVal){
						rtn = false;
						break;
					}

					//체크이후에. 만약 정확한 데이터 입력하지 않을시에. 다른로직을 타지 않게...
					if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "account") == ""){
						rtn = false;
						break;
					}
				}

				//Resposible Party체크.
				/* 유효성 검사는 필요없음. 2011.06.10 송호진
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "party") != ""){
					checkOprCd(sheetCheckEdit[1], idxRow, sheetCheckEdit[1].SaveNameCol(prefix + "party")); //sheetObj.

					//체크이후에. 만약 정확한 데이터 입력하지 않을시에. 다른로직을 타지 않게...
					if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "account") == ""){
						rtn = false;
						break;
					}
				}
				*/
			//}

				// 신규로 Mandatory Option 을 가지게 된 두개의 컬럼에 대해 기존의 데이터도 체크가 되도록
				// 조건 바깥에 Check Logic 을 추가함. 2011.06.15 - 송호진
				// 8. Resposible Party체크.
				if(sheetCheckEdit[1].CellValue(idxRow,  prefix + "party") == ""){
	                ComShowCodeMessage("OPF50025", idxRow, "Responsible Party" );
	                sheetCheckEdit[1].SelectCell(idxRow,  prefix + "party", true);
					rtn = false;
					break;
				}

		}

		t6sheet1_loopCheck = false;
		return rtn;
	}

	function checkFormEdit(){
		var prefix = "t1sheet1_";
		var shtObj = document.t1sheet1;
		for(var idxCol = 1; idxCol <= shtObj.LastCol; idxCol++){
			var colTxtName = ComReplaceStr(shtObj.ColSaveName(idxCol), prefix, "");

			if(getObjValue(colTxtName) != ""){
				return true;
			}
		}

		return false;
	}
	function log(msg){
	    var form = document.form;
	    if (form.s_parameter != undefined){
	        form.s_parameter.value += "\n"+msg;
	    }
	}	
	/* 개발자 작업  끝 */