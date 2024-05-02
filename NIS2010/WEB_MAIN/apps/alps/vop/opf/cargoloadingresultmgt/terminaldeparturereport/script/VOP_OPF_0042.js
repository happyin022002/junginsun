
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0036.js
*@FileTitle : TDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation

* 2011.11.07 김민아 [CHM-201114250-01] TDR내 SKD& Condition Tap 삭제 - TDR Creation 및 Inqiury 메뉴상 Schedule& Condition Tap 삭제 처리
* 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가(작업중 해당 화면 에러 발경하여 수정함)
* 2016.05.10 avg_crane 셋팅 부분을 avg_gang으로 변경
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
    function vop_opf_0042() {
    	this.processButtonClick		= tprocessButtonClick;
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

//var marrTabTitle = new Array("SKD & COND", "Port Log", "Disch. Vol.", "Load Vol.", "COD", "R/H", "Mishandle", "Slot", "Temp. STWG", "Remark(s)");
var marrTabTitle = new Array("Port Log", "Disch. Vol.", "Load Vol.", "COD", "R/H", "Mishandle", "Slot", "Temp. STWG", "Remark(s)");

var enableButton = new Array("btn_ExcludefromTPR","btn_Mail", "btn_Print");

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
var mCheckValue = false;
var checkyDcDFlg = false;	//Pod 체크 

//InitCombo Val
var mPodCode = "";
var mPodName = "";
var mLoadPodCode = "";
var mLoadPodName = "";
var mSztpCode = "";
var mSztpName = "";
var mReasonCode = "";
var mReasonName = "";

var multiSearchCheck = false;	//Multi Search여부 조회.  -> Retrieve 사용 여부 .

var arrClptIndSeq = new Array();
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

				case "btn_Retrieve":
					doActionIBSheet(beforetab, formObject, IBSEARCH);
					break;
				case "btn_New":
					tdrScreenNew(formObject, true);
					break;

				case "btn_Delete":
					doActionIBSheet(beforetab, formObject, IBDELETE);
					break;

                case "btn_ExcludefromTPR":
                    var btnObj = window.event.srcElement;
                    formObject.authbtn.value = "R";
                    formObject.clpt_ind_seq.value = document.sheetTdrH.CellValue(document.sheetTdrH.SelectRow , "sheetTdrH_call_ind");

                    var param = FormQueryString(document.form);
                    param  = "f_cmd="+formObject.f_cmd.value;
                    param += "&vsl_cd="+formObject.vsl_cd.value;
                    param += "&skd_dir_cd="+formObject.dir_cd.value;
                    param += "&skd_voy_no="+formObject.voy_no.value;
                    param += "&port_cd="+formObject.port_cd.value;
                    param += "&clpt_ind_seq="+formObject.clpt_ind_seq.value;
                    param += "&authbtn=R";
 
                    ComOpenPopup("/hanjin/VOP_OPF_0037.do?"+param, 520, 520, "setCallBackPort", "0,1,1,1,1,1,1", true);
                    break;
					
				case "btn_Save":
					doActionIBSheet(beforetab, formObject, IBSAVE);
					break;
					
				case "btn_Print":
					var rdParam = "/rp ["+(formObject.vsl_cd.value)+"]"					// 1.Vessel Code
								   + " ["+(formObject.skd_voy_no.value)+"]"					// 2.Voyage Nu
								   + " ["+(formObject.skd_dir_cd.value)+"]"					// 3.Direction            
								   + " ["+(formObject.port_cd.value)+"]"				// 4.Port Code
								   + " ["+(formObject.yd_cd.Code)+"]" 					// 5.Yard Code
                                   + " ["+(formObject.clpt_ind_seq.value)+"]";
//								   + " ["+(formObject.sys_create.value)+"]"				// 6.Gernerate System (I-Storage : EX, ALPS : IN)
				     formObject.com_mrdArguments.value = rdParam;
 
                    //searchVvdMailInfo();
    	    		//ComOpenRDPopup();
				     ComOpenRDPopupModal();
					break;
				
				case "btn_Mail":
                    var rdParam = "/rp ["+(formObject.vsl_cd.value)+"]"                 // 1.Vessel Code
                                    + " ["+(formObject.skd_voy_no.value)+"]"                 // 2.Voyage Nu
                                    + " ["+(formObject.skd_dir_cd.value)+"]"                 // 3.Direction            
                                    + " ["+(formObject.port_cd.value)+"]"                // 4.Port Code
                                    + " ["+(formObject.yd_cd.Code)+"]"                   // 5.Yard Code
                                    + " ["+(formObject.clpt_ind_seq.value)+"]";
					//			   + " ["+(formObject.sys_create.value)+"]"				// 6.Gernerate System (I-Storage : EX, ALPS : IN)
							//	   + " ["+(formObject.sys_create.value)+"]"        
					formObject.com_templateMrdArguments.value = rdParam;
					
					searchVvdMailInfo();
					//ComSendMail();
					ComSendMailModal();
					break;
				
				//Disch Vol Tab Change
				case "chk_DischVol":
					disChargTabChange();
					break;

						
				//Disch Vol Tab Change
				case "chk_LoadVol":
					disLoadTabChange();
					break;

				//Disch Vol Tab Change
				case "chk_Slot":
						disSlotTabChange();
						break;
				case "btn_Close":
					window.close();
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

		initControl();
		initComboSzTp();

		//초기 세팅을 위해 나중에 지울꺼에요. ㅋㅋ
		//jshUseVal(document.form);
		
		formReadonly(true);
		document.form.vsl_cd.focus();

		for( var k = 0; k < enableButton.length; k++){
			ComBtnDisable(enableButton[k]);
		}
		// document.all("btn_ExcludefromTPR").style.color = "#514747";

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
				obj_nextfocus(event.srcElement);
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
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t1sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,      prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "first_pilot_on",  false,      "",                 dfUserFormat2,      0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "anchorage_arr",   false,      "",                 dfUserFormat2,      0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "berth",           false,      "",                 dfUserFormat2,      0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "eta_next_port",   false,      "",                 dfNone,             0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "eta_next_date",   false,      "",                 dfUserFormat2,      0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "unberth",         false,      "",                 dfUserFormat2,      0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "anchorage_dep",   false,      "",                 dfUserFormat2,      0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "last_pilot_off",  false,      "",                 dfUserFormat2,      0,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_draft_fwd",   false,      "",                 dfNullFloat,        2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_draft_aft",   false,      "",                 dfNullFloat,        2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_draft_fwd",   false,      "",                 dfNullFloat,         2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_draft_aft",   false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_ballast",     false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_ballast",     false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_rob_fo",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_rob_do",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_rob_fw",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_rob_fo",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_rob_do",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_rob_fw",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_low_sul_fo",  false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_low_sul_do",  false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_low_sul_fo",  false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_low_sul_do",  false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_slp_fo",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_slp_do",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_slp_fw",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_low_sul_fo_wgt",  false,  "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_low_sul_do_wgt",  false,  "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_dwt",         false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_displt",      false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_dwt",         false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_displ",       false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_gm",          false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_gm",          false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "arr_tugboat",     false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "dep_tugboat",     false,      "",                 dfNullFloat,            2,      false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,       prefix + "clpt_ind_seq",    false,      "",                 dfNone,             0,      false,      false);
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
                    style.height = 230;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "||Work\nCommenced|Work\nCompleted|Break Down|Meal|Weather|Other|Total|work|crane_no|Net Working\n(HRS)|Gross Working\n(HRS)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 2, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t2sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,	false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,					150,	daCenter,	false,		prefix + "crane_desc",	false,		"",				dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,	false,		prefix + "work_comm",	false,		"",				dfUserFormat2,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,	false,		prefix + "work_comp",	false,		"",				dfUserFormat2,		0,		true,		true);

					InitDataProperty(0, cnt++ , dtData,					100,	daRight,	false,		prefix + "break_down",	false,		"",				dfUserFormat,		0,		true,		true,  -1,  false, false);
					InitDataProperty(0, cnt++ , dtData,					70,	daRight,	false,		prefix + "meal",		false,		"",				dfUserFormat,		0,		true,		true,  -1,  false, false);
					InitDataProperty(0, cnt++ , dtData,					70,	daRight,	false,		prefix + "weather",		false,		"",				dfUserFormat,		0,		true,		true,  -1,  false, false);
					InitDataProperty(0, cnt++ , dtData,					70,	daRight,	false,		prefix + "other",		false,		"",				dfUserFormat,		0,		true,		true,  -1,  false, false);
					InitDataProperty(0, cnt++ , dtData,					80,	daRight,	false,		prefix + "total",		false,		"",				dfUserFormat,		0,		false,		false,  -1,  false, false);
					InitDataProperty(0, cnt++ , dtHidden,				0,	daRight,	false,		prefix + "work",		false,		"",				dfUserFormat,		0,		true,		true,  -1,  false, false);
					InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	false,		prefix + "crane_no",	false,		"",				dfUserFormat,		0,		true,		true,  -1,  false, false);
					InitDataProperty(0, cnt++ , dtData,					90,	daRight,	false,		prefix + "net_work_hrs",		false,		"",		dfUserFormat,		0,		false,		false,	-1,	false,	false, "Gross Working(HRS)-Total");
					InitDataProperty(0, cnt++ , dtData,					70,	daRight,	false,		prefix + "gross_work_hrs",		false,		"",		dfUserFormat,		0,		false,		false,	-1,	false,	false, "Work Completed-Work Commenced");				//Code
					

					InitUserFormat2(0, prefix + "work_comm", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "work_comp", "####-##-## ##:##", "-|:" );

					InitUserFormat(0,  prefix + "break_down", "###:##", ":" );
					InitUserFormat(0, prefix + "meal", "###:##", ":" );
					InitUserFormat(0, prefix + "weather", "###:##", ":" );
					InitUserFormat(0, prefix + "other", "###:##", ":" );
					InitUserFormat(0, prefix + "total",	"###:##", ":" );
					InitUserFormat(0, prefix + "work",	"###:##", ":" );
//					InitUserFormat(0, prefix + "net_work_hrs",	"###.##", "." );
//					InitUserFormat(0, prefix + "gross_work_hrs",	"###.##", "." );
					
					totColor = RgbColor(204, 255, 253);		//기타 색상...
					titColor = RgbColor(229, 234, 255);		//타이틀 색상

					FrozenRows = 2;
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
                    Editable = false;

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
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,		prefix  +	"ibflag");
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
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"net_tml",              false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gross_tml",            false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"net_gc",               false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gross_gc",             false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"remark",               false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"hatch",                false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"con",                  false,		"",					dfInteger,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"pilot_arr",            false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"pilot_dep",            false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"anchor_arr",           false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"anchor_dep",           false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"berth",                false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"unberth",              false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"draft_fwd_arr",        false,		"",					dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"draft_fwd_dep",        false,		"",					dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"draft_aft_arr",        false,		"",					dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"draft_aft_dep",        false,		"",					dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"ballast_arr",          false,		"",					dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"ballast_dep",          false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_fo_arr",           false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_fo_dep",           false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_do_arr",           false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_do_dep",           false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_fw_arr",           false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"rob_fw_dep",           false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_fo_arr",        false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_fo_dep",        false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_do_arr",        false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_do_dep",        false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_fw_arr",        false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"bunker_fw_dep",        false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"dwt_arr",              false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"dwt_dep",              false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"displ_arr",            false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"displ_dep",            false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gm_arr",               false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"gm_dep",               false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"tug_arr",              false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"tug_dep",              false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"eta",                  false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"eta_canal",            false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"info",                 false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"sulphur_fo_arr",       false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"sulphur_fo_dep",       false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"sulphur_do_arr",       false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"sulphur_do_dep",       false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"supply_sulphur_fo",    false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"supply_sulphur_do",    false,		"",					dfNullFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"update_sys",           false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"next_port",            false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"next_port_dt",         false,		"",					dfUserFormat2,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"next_canal",           false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"next_canal_dt",        false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"used_crane",			false,		"",					dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		prefix	+	"avg_crane",			false,		"",					dfNone,				0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,                 115,    daCenter,   false,      prefix  +   "exists_tml_dep_rpt_dtl",false,     "",                 dfNone,             0,      false,      false);
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
	* IBCOMBO 초기화. <br>
	**/
	function sheetInitTotal(sheetObj){
		var cnt = 0;
		with (sheetObj) {
			// 높이 설정
			style.height = 380;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

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
				HeadTitle1 = "|Operator|POD|idx_Sheet|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight|Weight|Weight|Weight|Weight|Weight";
				HeadTitle2 = "|Operator|POD|idx_Sheet|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo| | | | | | |";
				HeadTitle3 = "|Operator|POD|idx_Sheet|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX";
			}else{
				HeadTitle1 = "|Operator|POD|idx_Sheet|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight|Weight|Weight|Weight|Weight|Weight";
				HeadTitle2 = "|Operator|POD|idx_Sheet|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX|20'|20HC|40'|40HC|45'|DX";
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
			InitDataProperty(0, cnt++ , dtPopupEdit,	80,		daCenter,	true,		prefix + "opr_cd",			false,		"",					dfEngUpKey,	0,		false,		true,  4);
			
			//POD는 Inbound의 경우는 상위조회조건의 Port와 같기 때문에. POD를 입력할 필요가 없지만...
			//Outbound의 경우 Pod는 입력...
			if(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2"){
				InitDataProperty(0, cnt++ , dtComboEdit,	65,		daCenter,	true,		prefix + "pod_cd",			false,		"",					dfEngUpKey,	0,		false,		true, 5);
			}else{
				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix + "pod_cd",			false,		"",					dfNone,		0,		false,		true);
			}
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix + "idx_sheet",		false,		"",					dfNone,		0,		true,		true);
			
			var arrCol = cellCol.split("|");
			
			if(sheetObj.id == "t3sheet1"){
				for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
					//5자리는 Weight입니다. Float
					if(arrCol[idxCol].length == 5)
						InitDataProperty(0, cnt++ , dtAutoSum,			60,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullFloat,	1,		true,		true,		4);
					else
						InitDataProperty(0, cnt++ , dtAutoSum,			40,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullInteger,	0,		true,		true,		4);
				}
			}else{
				for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
					//5자리는 Weight입니다. Float
					if(arrCol[idxCol].length == 5)
						InitDataProperty(0, cnt++ , dtAutoSum,			65,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullFloat,	1,		true,		true,		4);
					else
						InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullInteger,	0,		true,		true,		4);
				}
			}
			InitDataValid(0, prefix + "opr_cd", vtEngUpOnly);
			InitDataValid(0, prefix + "pod_cd", vtEngUpOnly);
		}
	}
	
	function sheetInitSC(sheetObj){
		var cnt = 0;
		with (sheetObj) {
								// 높이 설정
			style.height = 380;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(3, 1, 3, 100);

			var HeadTitle1 = "|Operator|POD|idx_sheet|DG Cargo|DG Cargo|DG Cargo|DG Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo";
			var HeadTitle2 = "|Operator|POD|idx_sheet|Quantity|Quantity|Weight|Weight|Quantity|Quantity|Weight|Weight|Quantity|Quantity|Weight|Weight";
			var HeadTitle3 = "|Operator|POD|idx_sheet|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'";
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
			InitDataProperty(0, cnt++ , dtPopupEdit,	80,		daCenter,	true,		prefix + "opr_cd",			false,		"",			dfEngUpKey,	0,		false,		true, 4);
			
			//POD Discharge에서는 POD그냥 Readonly 세팅.
			if(id == "t3sheet2")
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix + "pod",				false,		"",			dfEngUpKey,	0,		false,		false, 5);
			else
				InitDataProperty(0, cnt++ , dtComboEdit,	80,		daCenter,	true,		prefix + "pod",				false,		"",			dfEngUpKey,	0,		true,		true, 5);

			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix + "idx_sheet",		false,		"",			dfNone,		0,		true,		true);

			var arrCol = cellCol.split("|");
			
			for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
			    if(arrCol[idxCol].indexOf("wgt") == -1 ){//
			        InitDataProperty(0, cnt++ , dtAutoSum,			65,		daRight,	true,		prefix + arrCol[idxCol],				false,		"",					dfNullInteger,	0,		true,		true,		4);
			    }else{
			        InitDataProperty(0, cnt++ , dtAutoSum,          65,     daRight,    true,       prefix + arrCol[idxCol],                false,      "",                 dfNullFloat,  1,      true,       true,       4);
			    }
			}

		}
	}
	
	function sheetInitBreakBulk(sheetObj){
		var cnt = 0;
		with (sheetObj) {
			style.height = 380;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			//Unit|
			var HeadTitle1 = "|POD|Dimension (L X W X H)|Dimension (L X W X H)|Dimension (L X W X H)|Slot|Weight (Ton)|Crane Type|Working Time|Working Time|Operator|Container No.|cod_chk";
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
			InitDataProperty(0, cnt++ , dtComboEdit,	80,		daCenter,	false,		prefix + "pod",			false,		"",					dfEngUpKey,		0,		false,		false,	5);

			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,		prefix + "dml",			false,		"",					dfNullInteger,	0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,		prefix + "dmb",			false,		"",					dfNullInteger,	0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,		prefix + "dmh",			false,		"",					dfNullInteger,	0,		true,		true,	4);
			
			//InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,		prefix + "unit",		false,		"",					dfNullInteger,	0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,		prefix + "slot",		false,		"",					dfNullInteger,	0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,		prefix + "weight",		false,		"",					dfNullFloat,	1,		true,		true,	8);
			InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	false,		prefix + "crane",		false,		"",					dfNone,			0,		true,		true);
			
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix + "commence",	false,		"",					dfUserFormat2,	0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix + "complete",	false,		"",					dfUserFormat2,	0,		true,		true);
			InitDataProperty(0, cnt++ , dtPopupEdit,	80,		daCenter,	false,		prefix + "opr_cd",		false,		"",					dfEngUpKey,		0,		true,		true,	4);
			InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		prefix + "cntr_no",		false,		"",					dfEngUpKey,		0,		true,		true,	13);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		prefix + "cod_chk",		false,		"",					dfNone,			0,		true,		true);
			
			InitDataCombo(0, prefix + "crane", "G/Crane|F/Crane", "G|F");
			InitUserFormat2(0, prefix + "commence", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix + "complete", "####-##-## ##:##", "-|:" );

			InitDataValid(0, prefix + "cntr_no", vtEngUpOther, "1234567890");

		}
	}

	function slotPortDep(sheetObj){
		var cnt = 0;
		with (sheetObj) {
								// 높이 설정
			style.height = 380;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "";
			var HeadTitle2 = "";
			
			if(sheetObj.id == "t8sheet3"){
				HeadTitle1 = "|Operator|Status|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|Grand TTL Used Slot|Grand TTL Used Slot";
				HeadTitle2 = "|Operator|Status|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)";
			}else if(sheetObj.id == "t8sheet4"){
				HeadTitle1 = "|Operator|Status|Bsa Type|Teu|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Add Slot\n(HC/45)|Sub TTL Used Slot|Sub TTL Used Slot|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Add Slot\n(HC/45)|Sub TTL Used Slot|Sub TTL Used Slot|Grand TTL Used Slot|Grand TTL Used Slot|BSA\n(+ Slot Swap)|BSA\n(+ Slot Swap)|Over Used Slot|Over Used Slot|Over Slot Settlement|Over Slot Settlement";
				HeadTitle2 = "|Operator|Status|Bsa Type|Teu|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Add Slot\n(HC/45)|Slot\n(TEU)|Slot\n(Ton)|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Add Slot\n(HC/45)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot(TEU)|By";
			}

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var cellCol = "";
			
			if(sheetObj.id == "t8sheet3")
				cellCol = "trade_full|trade_mt|trade_ab|trade_sub_slot|trade_sub_wgt|inter_full|inter_mt|inter_ab|inter_sub_slot|inter_sub_wgt|grand_ttl_slot|grand_ttl_wgt";
			else if(sheetObj.id == "t8sheet4")
				cellCol = "trade_full|trade_mt|trade_ab|trade_45|trade_sub_slot|trade_sub_wgt|inter_full|inter_mt|inter_ab|inter_45|inter_sub_slot|inter_sub_wgt|grand_ttl_slot|grand_ttl_wgt|bsa_slot|bsa_wgt|over_slot|over_wgt|over_settle|over_settle_by";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = sheetObj.id + "_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtPopupEdit,			80,		daCenter,	true,		prefix + "opr_cd",					false,		"",		dfEngUpKey,		0,		false,		true, 3);
			InitDataProperty(0, cnt++ , dtHidden,				80,		daCenter,	true,		prefix + "status",					false,		"",		dfEngUpKey,		0,		false,		true, 3);

			if(sheetObj.id == "t8sheet4"){
				InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix + "bsa_type",				false,		"",		dfNone,			0,		false,		false, 3);
				InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		prefix + "teu",						false,		"",		dfFloat,		0,		false,		false, 6);
			}

			var arrCol = cellCol.split("|");
			//over_slot|over_wgt|over_settle|over_settle_by
			for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
				if(arrCol[idxCol] == "trade_sub_wgt" || arrCol[idxCol] == "inter_sub_wgt")	//Float고 작성가능.
					InitDataProperty(0, cnt++ , dtAutoSum,		 75,	daRight,	true,		prefix + arrCol[idxCol],				false,		"",		dfFloat,		1,		true,		true);
				else if(arrCol[idxCol] == "trade_sub_slot" || arrCol[idxCol] == "inter_sub_slot" || arrCol[idxCol] == "grand_ttl_slot" || arrCol[idxCol] == "bsa_slot" || arrCol[idxCol] == "over_slot")	//Integer고 작성불가능.
					InitDataProperty(0, cnt++ , dtAutoSum,		 75,	daRight,	true,		prefix + arrCol[idxCol],				false,		"",		dfInteger,		1,		false,		false);
				else if(arrCol[idxCol] == "grand_ttl_wgt" || arrCol[idxCol] == "bsa_wgt" || arrCol[idxCol] == "over_wgt" || arrCol[idxCol] == "over_settle")					//Float고 작성불가능.
					InitDataProperty(0, cnt++ , dtAutoSum,		 75,	daRight,	true,		prefix + arrCol[idxCol],				false,		"",		dfFloat,		1,		false,		false);
				else if(arrCol[idxCol] == "over_settle_by")
					InitDataProperty(0, cnt++ , dtCombo,		 80,	daCenter,	false,		prefix + arrCol[idxCol],				false,		"",		dfNone,			0,		false,		false);
				else
					InitDataProperty(0, cnt++ , dtAutoSum,		 75,	daRight,	true,		prefix + arrCol[idxCol],				false,		"",		dfInteger,		1,		true,		true);
			}

			if(sheetObj.id == "t8sheet4")
				InitDataCombo(0, prefix + "over_settle_by", " |Slot|Weight|Fixed", " |S|W|F");

			InitDataValid(0, prefix + "opr_cd", vtEngUpOnly);
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

			objs[nItem].style.display = "Inline";
			objs[beforetab].style.display = "none";

			//--------------- 요기가 중요 --------------------------//
			objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
			//------------------------------------------------------//
			beforetab= nItem;
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

		//처음탭이 아니면. 패스..............
		if(bFirst){
			sheetRemoveAll();
		}
		//변경될만한 Sheet의 객체를 저장한다.
		var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//

		beforetab= nItem;

		switch(marrTabTitle[nItem]) {
			case "Disch. Vol.":
				var frame = document.getElementById("t3frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_3.do?btnDis=N";
					return;
				}
				break;
			case "Load Vol.":
				var frame = document.getElementById("t4frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_4.do?btnDis=N";
					return;
				}
				break;
			case "COD":
				var frame = document.getElementById("t5frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_5.do?btnDis=N";
					return;
				}
				break;
			case "R/H":
				var frame = document.getElementById("t6frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_6.do?btnDis=N";
					return;
				}
				break;
			case "Mishandle":
				var frame = document.getElementById("t7frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_7.do?btnDis=N";
					return;
				}
				break;
			case "Slot":
				var frame = document.getElementById("t8frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_8.do?btnDis=N";
					return;
				}
				break;
			case "Temp. STWG":
				var frame = document.getElementById("t9frame");
				if(frame.src == ""){
					frame.src = "VOP_OPF_0036_9.do?btnDis=N";
					return;
				}
				break;
		}

		if(bRetrive){
			if(marrTabTitle[beforetab] == "Disch. Vol." || marrTabTitle[beforetab] == "Load Vol." || marrTabTitle[beforetab] == "Slot"){
				if(marrTabTitle[beforetab] == "Disch. Vol."){
					t3frame.document.form.chk_DischVol[0].checked = true;
					if(t3frame.beforeDistchVolTab != 0)
						t3frame.disChargTabChange();
				}else if(marrTabTitle[beforetab] == "Load Vol."){
					t4frame.document.form.chk_LoadVol[0].checked = true;
					if(t4frame.beforeLoadVolTab != 0)
						t4frame.disLoadTabChange();
				}else if(marrTabTitle[beforetab] == "Slot"){
					t8frame.document.form.chk_Slot[0].checked = true;
					if(t8frame.beforeSlotTab != 0){
						t8frame.disSlotTabChange();
					}
				}

				doActionIBSheetMulti(beforetab, document.form);
			}else{
				doActionIBSheet(beforetab, document.form, IBSEARCH);
			}
		}

		topSync();
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
		sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		arrCombo = ComXml2ComboString(sXml, "val", "name");

		mReasonCode = " |" + arrCombo[0];
		mReasonName = " |" + arrCombo[1];
	}

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        //ComClearSeparator(event.srcElement);
		event.srcElement.select();
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		if(event.srcElement.dataformat == "ymdhm"){

		}
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
    function searchVvdMailInfo(){
        var formObj = document.form;
        formObj.f_cmd.value = SEARCH06;
        var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));    
 
        //Mail Subject에 사용하기위해.
        var dataColNm = "vsl_slan_cd|vsl_eng_nm|skd_voy_no|skd_dir_cd";
        var vvdInfoData = ComOpfXml2Array(sXml, dataColNm);
        var aVvdInfoData = vvdInfoData[0];
        //[FEX TDR] M/V HANJIN ROME 0012W, ASIA
        var s = "["+aVvdInfoData[0]+" TDR] M/V "+aVvdInfoData[1]+" "+aVvdInfoData[2]+aVvdInfoData[3]+", "+formObj.yd_cd.Code;
 
        formObj.com_subject.value = s;
    }
	/**
	 * VVD 정보 관련 항목 셋팅 : VVD, Lane, Vessel Operator
	 */
	function setVVDInfo(formObj, s2Xml) { 	 
		var vvdData = ComOpfXml2Array(s2Xml, strVVDOptions);
		
		if(vvdData == null) {
			ComShowCodeMessage("COM12114", "VVD CD");
			initObjs("form", formObj, strVVDOptions, 0, "");
		}else{
			if(vvdData.length > 1) {
				ComShowCodeMessage("COM12114", "VVD CD");
				initObjs("form", formObj, strVVDOptions, 0, "");
			} else {
				formObj.f_cmd.value = SEARCH05;
				var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(formObj));
	            var sClptIndSeq = ComGetEtcData(sXml, "strClptIndSeq");
                arrClptIndSeq = sClptIndSeq.split("|"); 
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

								if(ComGetEtcData(sXml, "used_crane") != null && ComGetEtcData(sXml, "used_crane") != "undefined"){
									setObjValue("used_crane", 		ComGetEtcData(sXml, "used_crane")); 		
									setObjValue("avg_gang", 		ComGetEtcData(sXml, "avg_gang")); 			
									setObjValue("gross_work", 		ComGetEtcData(sXml, "gross_work")); 		
									setObjValue("net_work", 		ComGetEtcData(sXml, "net_work")); 		
									setObjValue("lost_time", 		ComGetEtcData(sXml, "lost_time")); 		
									setObjValue("gross_gang", 		ComGetEtcData(sXml, "gross_gang")); 		
									setObjValue("net_gang", 		ComGetEtcData(sXml, "net_gang")); 		
									setObjValue("hatch_handl", 		ComGetEtcData(sXml, "hatch_handl")); 	    
									setObjValue("gear_handl", 		ComGetEtcData(sXml, "gear_handl")); 		
									setObjValue("move_handl", 		ComGetEtcData(sXml, "move_handl")); 		
									setObjValue("tmnl_gross", 		ComGetEtcData(sXml, "tmnl_gross")); 		
									setObjValue("tmnl_net", 		ComGetEtcData(sXml, "tmnl_net")); 		
									setObjValue("per_gang_gross", 	ComGetEtcData(sXml, "per_gang_gross")); 	
									setObjValue("per_gan_net", 		ComGetEtcData(sXml, "per_gan_net")); 	    
									
									setObjValue("work_comm", 		ComGetEtcData(sXml, "commence"));
									setObjValue("work_comp", 		ComGetEtcData(sXml, "complete")); 
								}

								Redraw = false;    
								WaitImageVisible = false;	
								LoadSearchXml(sXml); 
								Redraw = true; 
								
								//DataInsert(0);
								
//								for(var idxRow = HeaderRows; idxRow <= LastRow; idxRow++){
//									if(idxRow == HeaderRows){
//										CellValue(idxRow, prefix + "crane_desc") = "Terminal Working Time";
//										CellValue(idxRow, prefix + "work_comm") = ComGetEtcData(sXml, "commence");
//										CellValue(idxRow, prefix + "work_comp") = ComGetEtcData(sXml, "complete");
//
//										CellEditable(idxRow, prefix + "work_comm") = false;
//										CellEditable(idxRow, prefix + "work_comp") = false;
//										CellEditable(idxRow, prefix + "break_down") = false;
//										CellEditable(idxRow, prefix + "meal") = false;
//										CellEditable(idxRow, prefix + "weather") = false;
//										CellEditable(idxRow, prefix + "other") = false;
//										CellEditable(idxRow, prefix + "total") = false;
//									}else{
										//CellValue(idxRow, prefix + "crane_desc") = (idxRow - 1) + " G/Crane";
								for(var idxRow = HeaderRows; idxRow <= LastRow; idxRow++){
						                if( formObj.sys_create_desc.value.indexOf("Ext")>-1 ){
						                    sheetObj.CellValue(idxRow, prefix + "crane_desc") = sheetObj.CellValue(idxRow, prefix + "crane_no")  + " G/Crane";   
						                }else{//
						                    CellValue(idxRow, prefix + "crane_desc") = idxRow + " G/Crane";
						                }
										CellBackColor(idxRow, prefix + "work") = titColor;
//									}
									CellBackColor(idxRow, prefix + "crane_desc") = totColor;
									RowStatus(idxRow) = "R";
								}

								beforeCraneCnt = RowCount - 1;
							}

							break;
						case "Disch. Vol.":
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
								formObj.f_cmd.value = SEARCH06;
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
							var sheetObj = t5frame.document.t5sheet1;

							var prefix = "t5sheet1_";
							var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.Redraw = true; 
						
							break;
						case "R/H":
							formObj.f_cmd.value = SEARCH08;
							var sheetObj = t6frame.document.t6sheet1;

							var prefix = "t6sheet1_";

							var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.Redraw = true; 
						
							break;
						case "Mishandle":
							formObj.f_cmd.value = SEARCH09;
							var sheetObj = t7frame.document.t7sheet1;

							var prefix = "t7sheet1_";
 
							var mishandlechk = formObj.misHandleChk.value;
                            var pParam = FormQueryString(formObj)+"&mishandlechk="+mishandlechk+"&"+ ComGetPrefixParam(prefix);
 
							var sXml = sheetObj.GetSearchXml("VOP_OPF_0036GS.do", pParam  );

							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.Redraw = true; 
							
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
							var sheetObj = t9frame.document.t9sheet1;

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
					multiSearchCheck = true;
				}
				break;
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
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(formObj,sAction){
		switch(sAction) {

			case IBSEARCH:
				//VVD 정보는 Key 이므로 기본 적으로 확인한다.
				if(!ComChkObjValid(formObj.vsl_cd)){ 	
					return false;
				}
				
				if(!ComChkObjValid(formObj.skd_voy_no)){
					return false;
				}
				
				if(!ComChkObjValid(formObj.skd_dir_cd)){
					return false;
				}

				if(formObj.yd_cd.Code == ""){
					ComShowCodeMessage("COM130404", "YARD");
					ComSetFocus(document.all.item("yd_cd"));
					return false;
				}
				
				return true;

				break;
			case IBSAVE:
				//VVD 정보는 Key 이므로 기본 적으로 확인한다.
				if(!ComChkObjValid(formObj.vsl_cd)) 	return false;
				if(!ComChkObjValid(formObj.skd_voy_no)) return false;
				if(!ComChkObjValid(formObj.skd_dir_cd)) return false;
				if(!ComChkObjValid(formObj.yd_cd)) return false;
				
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
 

	function yd_cd_OnChange( comboObj, idx_cd, text ){
	    
        var formObj = document.form;
        formObj.yd_nm.value = "";
		if(comboObjects[0].Code != ""){
			document.form.yd_nm.value = comboObjects[0].getText(comboObjects[0].Text, 1);
			resetFormNsheet(document.form.port_cd);
		}else{
			return;
		}
        //[2010-04-06]추가
        document.form.clpt_ind_seq.value = arrClptIndSeq[comboObjects[0].Index];

		//해당 POD와 POL가져오기..

		formObj.f_cmd.value = SEARCH08;
		formObj.port_cd.value = formObj.yd_cd.Code.substring(0, 5);
		var unKnownPortName = "|XXXXX\tUnkown";
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

	function hhMMCheck(objText){
		if(objText.value != ""){
			if(objText.value.indexOf(":") > -1){
				var arrTxt = objText.value.split(":");

				if(parseInt(arrTxt[1]) > 59){
					objText.value = ( parseInt(arrTxt[1] / 60) + 
									  parseInt(arrTxt[0] == "" ? "0" : arrTxt[0]) 
						            ) + ":" + (arrTxt[1] % 60);
				}else if(arrTxt[0] == ""){
					objText.value = "0" + objText.value;
				}
			}else{
				if(parseInt(objText.value) > 59){
					objText.value = parseInt(objText.value / 60) + ":" + (objText.value % 60);
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
		if(beforeCraneCnt < parseInt(document.form.used_crane.value)){		//이전 크래인수보다 클 경우.
			for(var crtRow = 1; crtRow <= parseInt(document.form.used_crane.value) - beforeCraneCnt; crtRow++){
				var Row = sheetObj.DataInsert(-1);

				//sheetObj.CellValue(Row, prefix + "crane_desc") = (parseInt(beforeCraneCnt) + parseInt(crtRow)) + " G/Crane";
                if( formObj.sys_create_desc.value.indexOf("Ext")>-1 ){
                    sheetObj.CellValue(Row, prefix + "crane_desc") = sheetObj.CellValue(Row, prefix + "crane_no")  + " G/Crane";   
                }else{//
                    sheetObj.CellValue(Row, prefix + "crane_desc") = (parseInt(beforeCraneCnt) + parseInt(crtRow)) + " G/Crane";
                }
				
				
				//일단 초기 날짜 세팅.
				sheetObj.CellValue(Row, prefix + "work_comm") = sheetObj.CellValue(1, prefix + "work_comm");
				sheetObj.CellValue(Row, prefix + "work_comp") = sheetObj.CellValue(1, prefix + "work_comp");
				
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
			for(var crtRow = 1; crtRow <= beforeCraneCnt - parseInt(document.form.used_crane.value); crtRow++){
				sheetObj.RowDelete(sheetObj.LastRow, false);
			}
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
	 *	TDR정보 조회시...
	 */
	function tdrHeaderSearch(formObj){
		var sheetObj = document.sheetTdrH;
		var prefix = "sheetTdrH_";
		document.form.f_cmd.value = SEARCHLIST05;
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
				formReadonly(true);
			}else{
				formObj.sys_create.value = "Externally Produced";
				formObj.sys_create_desc.value = "Externally Produced";

				formReadonly(true);
			}
			
			opentScreen();

			
			for( var k = 0; k < enableButton.length; k++){
				ComBtnEnable(enableButton[k]);
			}
			
            // Exclude TPR에 저장시에 글짜색만 바꾸어 준다.
 
            if(sheetObj.CellValue(sheetObj.SelectRow, prefix + "exists_tml_dep_rpt_dtl") == "Y"){
                document.all("btn_ExcludefromTPR").style.color = "#e41010";
            }else{
                document.all("btn_ExcludefromTPR").style.color = "#514747";
            }
			
		}else{
			//ComShowCodeMessage('COM132201', "TDR"); 
            formObj.sys_create.value = "Internally Produced";			
			formReadonly(true);
            document.all("btn_ExcludefromTPR").style.color = "#514747";
			for( var k = 0; k < enableButton.length; k++){
				ComBtnDisable(enableButton[k]);
			}
		}
	}

	function opentScreen(){
		bRetrive = true;

		//TDR을 들고 온넘을 지울순 없짠아요. ^^
		for(var cnt = 0; cnt < sheetObjects.length - 1; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
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
	}
	
	function setCraneSheet(){
		var sheetObj = document.t2sheet1;
		
		//첫번째 Row는 조회모드.
		sheetObj.RowStatus(sheetObj.HeaderRows) = "R";
		//어차피 생성된 놈인지 알수가 없음... 모두 Insert 모드...
		for(var idxRow = sheetObj.HeaderRows + 1; idxRow < sheetObj.LastRow; idxRow++){
			sheetObj.RowStatus(idxRow) = "I";
		}
	}

	function formReadonly(readonly){
		var frmObj = document.getElementsByTagName("form"); 
		var fObj = frmObj.item(0); 

		for( var k = 0; k < enableButton.length; k++){
			if(readonly){
	            ComBtnDisable(enableButton[k]);
			}else{
                ComBtnEnable(enableButton[k]);
			}
		}

		for(var idxObj = 0; idxObj < fObj.length; idxObj++){
			var objText = fObj.item(idxObj);
			if(objText.type == "text" && (	objText.name != "vsl_cd" && 
											objText.name != "skd_voy_no" && 
											objText.name != "skd_dir_cd" && 
											objText.name != "yd_nm" && 
											objText.name != "sys_create_desc" && 
											objText.name != "eta_next_port" && 
											objText.name != "eta_next_date")
			){
				objText.readOnly = readonly;
				objText.className = (readonly ? "input2" : "input");
			}
		}
		
		//Sheet의 Write설정
		for(var idx = 0; idx < sheetObjects.length - 1; idx++)
			sheetObjects[idx].Editable = (readonly ? false : true);
	}

	function calenderCall(srcName){
		if(document.form.sys_create.value.substring(0, 2) == "In"){
			var objName = srcName.substring(4);
			var cal = new ComCalendar();
			cal.select(document.form.item(objName), 'yyyy-MM-dd');
			document.form.item(objName).value = document.form.item(objName).value;
		}
	}
	

	function fillZero(str){
		if(parseInt(str) < 10){
			str = "0" + str;
		}

		return str;
	}

	function jshUseVal(formObj){
		formObj.vsl_cd.value = "HJMU";
		formObj.skd_voy_no.value = "0009";
		formObj.skd_dir_cd.value = "E";

		searchVVDInfo();

		document.form.yd_cd.Code = "SGSINKA";

		//doActionIBSheet(beforetab, formObj, IBSEARCH);
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

	function setCallBackOprCd(rtnObjs){
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					popupSheet.CellValue(popupSheet.SelectRow, popupPrefix + popupColNm) = rtnDatas[3];
				}
			}
		}
		mCheckValue = false;
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
    function tdrRoundNull(obj, posN){
        if (posN==undefined || posN==null ) posN = 2;
        if(obj == "" || obj == "0"){
            return "";
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
	/**
     * Screen New
	 */
	function tdrScreenNew(formObject, checkFlag){
		var changeSheet2 = false;
		

		formObject.vsl_cd.value = "";
		resetFormNsheet(formObject.vsl_cd);
		formObject.vsl_cd.focus();

		for( var k = 0; k < enableButton.length; k++){
			ComBtnDisable(enableButton[k]);
		}
        document.all.btn_ExcludefromTPR.style.color = "#514747";
	}
     function tdr0Null(obj){
         obj = ComReplaceStr(obj, ",","");
         if( eval( obj ) ==  0 )return "";
         return obj;
     }
	function setTabEditSheet(){
	}

	function frameButtonSheet(objFrame, readonly){
	}

	function readonlStatus(){
		return true;
	}
	function fncLoadVolBBSheetCellControl(){}

	/* 개발자 작업  끝 */