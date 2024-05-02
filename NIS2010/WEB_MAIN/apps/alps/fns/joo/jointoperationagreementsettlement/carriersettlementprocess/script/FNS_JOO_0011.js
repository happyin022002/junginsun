/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0011.js
 *@FileTitle : Reefer Surcharge Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.13
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.07.13 박희동
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.11.12 신자영 [CHM-201007065-01] JOO Unit Cost Basic Port컬럼 삭제 요청
 * 2013.12.04 이수진 [CHM-201327910] JO - SETTLEMENT 변경 (RF Surcharge (20',40') 항목 입력 가능하도록 로직 수정)
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
 * @class FNS_JOO_0011 : FNS_JOO_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0011() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var gCurRow = 0;
var gVVD = "";
var gChange=true;
var prefix = "sheet1_";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		if (srcName == null || srcName == "re_divr_cd" || srcName == "rf_scg_stl_tp_cd") {
			return;
		}

		//class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {
			case "btns_back":
				formObj.jo_crr_cd.focus();
		    	sheetObjects[0].RemoveAll();
				if (formObj.acct_yrmon.value!=""){
					formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",-1).substring(0,7);
				}
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
				
//				if (canRetrieve()){
//					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//				}
				break;
	
			case "btns_next":
				formObj.jo_crr_cd.focus();
				sheetObjects[0].RemoveAll();
				if (formObj.acct_yrmon.value!=""){
					formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M", 1).substring(0,7);
				}
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);

//				if (canRetrieve()){
//					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//				}
				break;
	
			case "btn_add":
				if (formObj.jo_crr_cd.index == -1){ 
					ComShowCodeMessage('JOO00008');
					return;
				}
				
				if (formObj.trd_cd.index    == -1){
					ComShowCodeMessage('JOO00009');
					return;
				}
				
				if (formObj.rlane_cd.index  == -1){
					ComShowCodeMessage('JOO00010');
					return;
				}
				
//				if (sheetObject1.HeaderRows == sheetObject1.LastRow){
//					ComShowCodeMessage('JOO00010');
//					return;
//				}
				
				var idx_cd = formObj.rlane_cd.Code;
				var rtu    = formObj.rlane_cd.GetText(idx_cd,1);
				
//				if (rtu.length != 1){
//					ComShowCodeMessage('JOO00083');
//					return;
//				}
				
				var loclCurrCd = formObj.rlane_cd.GetText(idx_cd,2);
				
				if (loclCurrCd.length!=3){
					ComShowCodeMessage('JOO00082');
					return;
				}

				if (JooGetRadioValue(formObj.rf_scg_stl_tp_cd) == ""){
					ComShowCodeMessage('JOO00171');
					return false;
				}
				
				var row = sheetObject1.DataInsert(-1);
	
				var reDivrCd = JooGetRadioValue(formObj.re_divr_cd);

				sheetObjects[0].CellEditable(row, prefix+"vsl_cd"          ) = true; //Row Add한 것은 수정가능하게 한다.
				sheetObjects[0].CellEditable(row, prefix+"skd_voy_no"      ) = true; //Row Add한 것은 수정가능하게 한다.
				sheetObjects[0].CellEditable(row, prefix+"skd_dir_cd"      ) = true; //Row Add한 것은 수정가능하게 한다.
				sheetObjects[0].CellEditable(row, prefix+"rf_scg_stl_tp_cd") = true; //Row Add한 것은 수정가능하게 한다.

				sheetObjects[0].CellValue2(row, prefix+"acct_yrmon"      ) = ComReplaceStr(formObj.acct_yrmon.value,"-","");
				sheetObjects[0].CellValue2(row, prefix+"trd_cd"          ) = formObj.trd_cd.Code;
				sheetObjects[0].CellValue2(row, prefix+"jo_crr_cd"       ) = formObj.jo_crr_cd.Code;
				sheetObjects[0].CellValue2(row, prefix+"rlane_cd"        ) = formObj.rlane_cd.Code;
				sheetObjects[0].CellValue2(row, prefix+"re_divr_cd"      ) = reDivrCd;
				sheetObjects[0].CellValue2(row, prefix+"jo_stl_itm_cd"   ) = formObj.jo_stl_itm_cd.value;
				sheetObjects[0].CellValue2(row, prefix+"jo_mnu_nm"       ) = formObj.jo_mnu_nm.value;
				sheetObjects[0].CellValue2(row, prefix+"rf_scg_stl_tp_cd") = rtu; //선택할 수 있도록 한다.
				sheetObjects[0].CellValue2(row, prefix+"skd_dir_cd"      ) = "";
				sheetObjects[0].CellValue2(row, prefix+"rev_dir_cd"      ) = "";
				sheetObjects[0].CellValue2(row, prefix+"stl_adj_flg"     ) = "N"; //보정여부 N
				sheetObjects[0].CellValue2(row, prefix+"stl_lst_flg"     ) = "Y"; //최종여부 Y
				sheetObjects[0].CellValue2(row, prefix+"locl_curr_cd"    ) = loclCurrCd;
				sheetObjects[0].CellValue2(row, prefix+"ioc_cd"          ) = "";
				sheetObjects[0].CellValue2(row, prefix+"sconti_cd"       ) = "";
				
				//TDR 인 경우 I/O는 Inter Port이고 RGN은 A로 임의 setting한다. ==> VVD변경시(10자리) T이면 I로 setting한다. (수정불가) 
				if (rtu == "T"){
					sheetObjects[0].CellEditable(row, prefix+"ioc_cd"        ) = false;
					sheetObjects[0].CellEditable(row, prefix+"sconti_cd"     ) = false;
				//RDR, UI인 경우 수정가능함
				}else{
					sheetObjects[0].CellEditable(row, prefix+"ioc_cd"        ) = true;
					sheetObjects[0].CellEditable(row, prefix+"sconti_cd"     ) = true;
				}
				//vsl_cd에 focus
				sheetObjects[0].SelectCell(row, prefix+"vsl_cd", true);			
				break;
	
			case "btn_delete":
				JooRowHideDelete(sheetObject1, prefix+"del_chk");
				break;

			case "btn_delete_all":
				doActionIBSheet(sheetObject1, formObj, IBDELETE);
				break;
				
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
	
			case "btn_create":
				doActionIBSheet(sheetObject1, formObj, IBCREATE);
				break;
				
			case "btn_new":
				sheetObjects[0].RemoveAll();
				formObj.jo_crr_cd.Index2 = -1;
				formObj.trd_cd.Index2 = -1;
				formObj.rlane_cd.Index2 = -1;
				formObj.re_divr_cd[0].checked = true;
				formObj.acct_yrmon.focus();
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
	
			case "btn_downexcel":
				sheetObject1.SpeedDown2Excel();
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
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
 
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
 
	initControl();
}

/**
* 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
* {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {int}     sheetNo     sheetObjects 배열에서 순번
**/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);    

    axon_event.addListener('keypress', 'acct_yrmon_keypress', 'acct_yrmon');	
    axon_event.addListener('click'   , 'change_event_radio' , 're_divr_cd');
    axon_event.addListener('click'   , 'rt_click'           , 'rf_scg_stl_tp_cd');
    
    formObj.acct_yrmon.focus();
}

// Axon 이벤트 처리2. 이벤트처리함수
function obj_blur() {
	ComChkObjValid(event.srcElement);
    
	var src = window.event.srcElement.getAttribute("name")
    if (src == "acct_yrmon"){
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC10);
    }
}

function obj_focus() {
	ComClearSeparator(event.srcElement);
}

function obj_keypress(){
	var src = window.event.srcElement.getAttribute("name")
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}

function acct_yrmon_keypress(){
	ComKeyOnlyNumber(this, '');
}

function obj_onclick(){
	var src = window.event.srcElement.getAttribute("name")
}

function change_event_radio(){
	var src = window.event.srcElement.getAttribute("name")
	sheetObjects[0].RemoveAll();

	//re_divr_cd 가 변경될때에도 rlane을 읽어온다.
	if (document.form.trd_cd.Code.length == 3){
		doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[2] ,"rlane_cd");
	}
	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC10);
}

/**
 * RDR/TDR Radio Button Click 
 * @return
 */
function rt_click(){
	var src = window.event.srcElement.getAttribute("name")
	var sheetObj = sheetObjects[0]; 
	sheetObj.RemoveAll();
	
	var rtuNmList = "";
	var rtuCdList = "";
	
	var rtu = JooGetRadioValue(document.form.rf_scg_stl_tp_cd);
	//RDR이면
	if (rtu == "R"){
		rtuCdList = "R|U";
		rtuNmList = "RDR|UI";
	}else if (rtu == "T"){
		rtuCdList = "T|U";
		rtuNmList = "TDR|UI";
	}
	sheetObj.InitDataCombo(0, prefix+"rf_scg_stl_tp_cd", rtuNmList, rtuCdList);
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
			style.height = 394;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			//MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
			//Unit Cost\nBasic Port| 제외함 (2010.11.15 신자영 [CHM-201007065-01] JOO Unit Cost Basic Port컬럼 삭제 요청)
			var HeadTitle  = "STS||VSL|VOY|Dir.|Fin.\nDir|R/T/U|Ocean/\nInter port|RGN|Port|Port|Used RF|Used RF|RF Surcharge|RF Surcharge|CUR.|Amount|Amount|Amount|VVD Amt|Combined\nNo.|RVS|Basic Port|Schedule|Unit Cost\nBasic Port";
			HeadTitle += "|ACCT_YRMON|STL_VVD_SEQ|STL_SEQ_20|STL_SEQ_40|TRD_CD|JO_CRR_CD|RLANE_CD|RE_DIVR_CD|JO_STL_ITM_CD|JO_MNU_NM|SLIP_NO|UC_BSS_PORT_ETD_DT|FR_PORT|TO_PORT|STL_ADJ_FLG|STL_LST_FLG|DUP|DUP";

			var HeadTitle1  = "STS||VSL|VOY|Dir.|Fin.\nDir|R/T/U|Ocean/\nInter port|RGN|POL|POD|20FT|40FT|20FT|40FT|CUR.|20FT|40FT|Total|VVD Amt|Combined\nNo.|RVS|Basic Port|Schedule|Unit Cost\nBasic Port";
			HeadTitle1 += "|ACCT_YRMON|STL_VVD_SEQ|STL_SEQ_20|STL_SEQ_40|TRD_CD|JO_CRR_CD|RLANE_CD|RE_DIVR_CD|JO_STL_ITM_CD|JO_MNU_NM|SLIP_NO|UC_BSS_PORT_ETD_DT|FR_PORT|TO_PORT|STL_ADJ_FLG|STL_LST_FLG|20FT|40FT";

			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount,11, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			InitHeadRow(1, HeadTitle1, true);
			//SetMergeCell(0,2,2,4);

			InitComboNoMatchText(true); //COMBO에서 match된 data가 없어도 보여짐
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus  ,  30, daCenter,  true, prefix+"ibflag"  ); //0
			InitDataProperty(0, cnt++, dtCheckBox,  30, daCenter,  true, prefix+"del_chk" ); //1
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter,  true, prefix+"vsl_cd"            ,false, "", dfNone       ,0,false,false,  4);//2
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter,  true, prefix+"skd_voy_no"        ,false, "", dfNone       ,0,false,false,  4);//3
			InitDataProperty(0, cnt++, dtCombo   ,  30, daCenter,  true, prefix+"skd_dir_cd"        ,false, "", dfNone       ,0,false,false,  1);//4
			InitDataProperty(0, cnt++, dtData    ,  30, daCenter,  true, prefix+"rev_dir_cd"        ,false, "", dfNone       ,0,false,false,  1);//5
			InitDataProperty(0, cnt++, dtCombo   ,  70, daCenter,  true, prefix+"rf_scg_stl_tp_cd"  ,false, "", dfNone       ,0,false,true );//6
			InitDataProperty(0, cnt++, dtCombo   ,  70, daCenter,  true, prefix+"ioc_cd"            ,false, "", dfNone       ,0,false,false);//7
			InitDataProperty(0, cnt++, dtCombo   ,  40, daCenter,  true, prefix+"sconti_cd"         ,false, "", dfNone       ,0,false,false);//8
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter,  true, prefix+"fm_port_cd1"       ,false, "", dfNone       ,0,false,false);//9
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter,  true, prefix+"to_port_cd1"       ,false, "", dfNone       ,0,false,false);//10
			InitDataProperty(0, cnt++, dtAutoSum ,  50, daRight ,  true, prefix+"usd_slt_bsa_qty_20",false, "", dfInteger    ,0,false,false);//11
			InitDataProperty(0, cnt++, dtAutoSum ,  50, daRight ,  true, prefix+"usd_slt_bsa_qty_40",false, "", dfInteger    ,0,false,false);//12
			InitDataProperty(0, cnt++, dtData    ,  60, daRight ,  true, prefix+"rf_scg_prc_20"     ,false, "", dfFloat      ,2,true,true);//13
			InitDataProperty(0, cnt++, dtData    ,  60, daRight ,  true, prefix+"rf_scg_prc_40"     ,false, "", dfFloat      ,2,true,true);//14
			InitDataProperty(0, cnt++, dtData    ,  60, daCenter,  true, prefix+"locl_curr_cd"      ,false, "", dfNone       ,0,false,false);//15
			InitDataProperty(0, cnt++, dtAutoSum ,  80, daRight ,  true, prefix+"stl_locl_amt_20"   ,false, "Round(|sheet1_usd_slt_bsa_qty_20|*|sheet1_rf_scg_prc_20|,2)", dfFloat,2,false,false); //16
			InitDataProperty(0, cnt++, dtAutoSum ,  80, daRight ,  true, prefix+"stl_locl_amt_40"   ,false, "Round(|sheet1_usd_slt_bsa_qty_40|*|sheet1_rf_scg_prc_40|,2)", dfFloat,2,false,false); //17
			InitDataProperty(0, cnt++, dtAutoSum , 100, daRight ,  true, prefix+"stl_locl_amt"      ,false, "Round(|sheet1_usd_slt_bsa_qty_20|*|sheet1_rf_scg_prc_20|,2) + Round(|sheet1_usd_slt_bsa_qty_40|*|sheet1_rf_scg_prc_40|,2)", dfFloat,2,false,false); //18
			InitDataProperty(0, cnt++, dtHidden  , 100, daRight ,  true, prefix+"vvd_sum_amt"       ,false, "", dfFloat      ,2,false,false);//19
			InitDataProperty(0, cnt++, dtData    ,  80, daCenter,  true, prefix+"stl_cmb_seq"       ,false, "", dfNone       ,0,false,false);//20 combined No.  
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter,  true, prefix+"rvs_cmb_flg"       ,false, "", dfNone       ,0,false,false);//20 combined No.  
			InitDataProperty(0, cnt++, dtData    ,  70, daCenter,  true, prefix+"stl_bzc_port_cd"   ,false, "", dfNone       ,0,false,false);//21
			InitDataProperty(0, cnt++, dtData    , 110, daCenter,  true, prefix+"eta_dt"            ,false, "", dfUserFormat2,0,false,false);//22
			//2010.11.15 신자영 [CHM-201007065-01] JOO Unit Cost Basic Port컬럼 삭제 요청 - dtHidden으로 변경
			InitDataProperty(0, cnt++, dtHidden  ,  70, daCenter,  true, prefix+"uc_bss_port_cd"    ,false, "", dfNone       ,0,false,false);//23

			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"acct_yrmon"        ,false, "", dfNone, 0, false, false);//22
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"stl_vvd_seq"       ,false, "", dfNone, 0, false, false);//23
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"stl_seq_20"        ,false, "", dfNone, 0, false, false);//24
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"stl_seq_40"        ,false, "", dfNone, 0, false, false);//25
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"trd_cd"            ,false, "", dfNone, 0, false, false);//26
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"jo_crr_cd"         ,false, "", dfNone, 0, false, false);//27
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"rlane_cd"          ,false, "", dfNone, 0, false, false);//28
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"re_divr_cd"        ,false, "", dfNone, 0, false, false);//29
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"jo_stl_itm_cd"     ,false, "", dfNone, 0, false, false);//30
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"jo_mnu_nm"         ,false, "", dfNone, 0, false, false);//31
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"slip_no"           ,false, "", dfNone, 0, false, false);//32
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"uc_bss_port_etd_dt",false, "", dfNone, 0, false, false);//33
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false, prefix+"fm_port_cd"        ,false, "", dfNone, 0, false, false);//34
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false, prefix+"to_port_cd"        ,false, "", dfNone, 0, false, false);//35
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"stl_adj_flg"       ,false, "", dfNone, 0, false, false);//36
			InitDataProperty(0, cnt++, dtHidden  ,   0, daLeft  , false, prefix+"stl_lst_flg"       ,false, "", dfNone, 0, false, false);//37
			InitDataProperty(0, cnt++, dtHidden  ,  50, daCenter, false, prefix+"stl_dup_flg_20"    ,false, "", dfNone, 0, false, false);//38
			InitDataProperty(0, cnt++, dtHidden  ,  50, daCenter, false, prefix+"stl_dup_flg_40"    ,false, "", dfNone, 0, false, false);//39
			
			MessageText("Sum") = ""; //summary row에 자동으로 생성되는 TOTAL이란 글자를 없앰
			
			InitDataValid(0, prefix+"vsl_cd"     , vtEngUpOther, "0123456789");//영문대문자+숫자
			InitDataValid(0, prefix+"skd_voy_no" , vtNumericOnly);//숫자만 올 수 있음
			
			InitDataCombo(0, prefix+"skd_dir_cd" , "E|W|S|N", "E|W|S|N");
			InitDataCombo(0, prefix+"ioc_cd"     , "A|"+gIocNm , "A|"+gIoc);
			InitDataCombo(0, prefix+"sconti_cd"  , gRgnNm      , gRgn);
			
			InitUserFormat2(0, prefix+"eta_dt" , "####-##-## ##:##:##", "-|:");

			HeadRowHeight = 25;
		}
		break;
		
	case 2: //t1sheet1 init
		sheetObj.style.height = 0;
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {

	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_JOO_0011GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;

		//Create
		case IBCREATE:
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0011GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml,false);
			
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				var addedCnt = sheetObj.RowCount("I");
				if (addedCnt == 0){
					ComShowCodeMessage('JOO00054'); //append된 data가 존재하지 않습니다.
				}
			}
			
			break;

		case IBSAVE: //저장
			var SaveStr = ComGetSaveString(sheetObjects[0], true, true);
			
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
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0011GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);

			var RTNVAL = ComGetEtcData(sXml, "RTNVAL");
			if (RTNVAL == "E"){
// DUPLICATE ERROR나면 confirm하지 않고 종료함				
//				if (ComShowCodeConfirm('JOO00132', dupRows)){
//					doActionIBSheet(sheetObj, document.form, IBINSERT);					
//				}
			}else{
				if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				}
			}
			
			break;

		//SAVE => Do you want to save the changes? 물음 없이...저장 ==> Dup 나면 error message뿌리고 종료하므로 필요없음
//		case IBINSERT: //중복체크하지 않는 저장
//			var SaveStr = ComGetSaveString(sheetObjects[0], true, true);
//			
//			formObj.f_cmd.value = MULTI;
//
//			var sXml = sheetObj.GetSaveXml("FNS_JOO_0011GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//			sheetObj.LoadSearchXml(sXml);
//			
//			var dupRows = "";
//			for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow; i++){
//				if (sheetObj.RowStatus(i) == "R" || sheetObj.RowStatus(i) == "D")
//					continue;
//				
//				if (sheetObj.CellValue(i,prefix+"stl_dup_flg_20") == "Y"
//				||  sheetObj.CellValue(i,prefix+"stl_dup_flg_40") == "Y"){
//					dupRows = dupRows + (i-sheetObj.HeaderRows+1) +"|";
//				}
//			}
//			
//			if (dupRows.length > 0)
//				dupRows = dupRows.substring(0, dupRows.length-1);
//			
//			
//			var RTNVAL = ComGetEtcData(sXml, "RTNVAL");
//			if (RTNVAL == "E"){
//				if (ComShowCodeConfirm('JOO00132', dupRows)){
//					doActionIBSheet(sheetObj, document.form, IBINSERT);					
//				}
//			}else{
//				doActionIBSheet(sheetObj, document.form, IBSEARCH);					
//			}
//			
//			break;

		//전체삭제
		case IBDELETE:
			if (!ComShowCodeConfirm("JOO00061")){
				return;
			}
			formObj.f_cmd.value = REMOVE01;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			sheetObj.DoSearch("FNS_JOO_0011GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			break;

		//VVD 9자리 입력시 REVENUE Dir.을 조회한다.
		case IBROWSEARCH:
			formObj.f_cmd.value = SEARCHLIST;
			formObj.cur_row.value = (gCurRow - sheetObj.HeaderRows);
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0011GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			var revDirList = ComGetEtcData(sXml,"REV_DIR_LIST");
			var errCd      = ComGetEtcData(sXml,"ERR_CD");
			if (errCd == "N"){
				if ((revDirList.split("|")).length > 1){
			        sheetObj.InitCellProperty(gCurRow, 5, dtCombo, daCenter, prefix+"rev_dir_cd", "", dfNone);
					sheetObj.CellComboItem(gCurRow, prefix+"rev_dir_cd"  , revDirList , revDirList, 0);
				}else{
					sheetObj.CellValue(gCurRow, prefix+"rev_dir_cd")=revDirList;
				}
			}else{
				ComShowCodeMessage("JOO00031");
				sheetObj.CellValue2(gCurRow, prefix+"skd_dir_cd") ="";
			}
			break;
			
		//VVD변경시 (10자리)
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value = SEARCHLIST01;
			formObj.cur_row.value = gCurRow-sheetObj.HeaderRows;

			formObj.super_cd1.value = formObj.rlane_cd.Code;
			formObj.super_cd2.value = gVVD;
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1); //전체 다 넘김
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0011GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

			var CHECKVVD = ComGetEtcData(sXml,"CHECKVVD");
			
			//VVD가 유효하다면
			if (CHECKVVD=="N"){
				sheetObj.CellValue2(gCurRow, prefix+"stl_vvd_seq"       ) = ComGetEtcData(sXml,"stl_vvd_seq");
				sheetObj.CellValue2(gCurRow, prefix+"stl_bzc_port_cd"   ) = ComGetEtcData(sXml,"stl_bzc_port_cd");
				sheetObj.CellValue2(gCurRow, prefix+"eta_dt"            ) = ComGetEtcData(sXml,"eta_dt");
				//sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_cd"    ) = ComGetEtcData(sXml,"uc_bss_port_cd");
				//sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_etd_dt") = ComGetEtcData(sXml,"uc_bss_port_etd_dt");
				
				//2010.01.21 ==> R/F Surcharge Price를 가져오기 위해 필요함
				//formObj.uc_bss_port_etd_dt.value = ComGetEtcData(sXml,"uc_bss_port_etd_dt");
				var portList = ComGetEtcData(sXml,"portList");

				sheetObj.InitCellProperty(gCurRow, 9, dtCombo); //, daCenter, prefix+"fm_port_cd1" , "", dfNone);
		        sheetObj.InitCellProperty(gCurRow,10, dtCombo); //, daCenter, prefix+"to_port_cd1" , "", dfNone);

		        //Change event를 타지 못하게 하기 위함...
		        gChange = false;
		        sheetObj.CellComboItem(gCurRow, prefix+"fm_port_cd1" , portList, portList, 0);
		        sheetObj.CellComboItem(gCurRow, prefix+"to_port_cd1" , portList, portList, 0);
		        gChange = true;
		        
		        sheetObj.CellValue2(gCurRow, prefix+"fm_port_cd1") = "";
		        sheetObj.CellValue2(gCurRow, prefix+"to_port_cd1") = "";

		        //TDR인 경우 InterPort에 Region 정보가 없으므로 자동으로 sheet1_OnChange의 ioc_cd 를 실행하도록 한다.
				if (JooGetRadioValue(formObj.rf_scg_stl_tp_cd) == "T"){
					sheetObj.CellValue(gCurRow, prefix+"ioc_cd") = "I";
				}
			}else{
				if (CHECKVVD=="E"){
					ComShowCodeMessage("JOO00141"); //No data found in 'Target VVD'.
				}else if (CHECKVVD=="T"){
					ComShowCodeMessage("JOO00142"); //Two or more data in 'Target VVD'.
				}
				sheetObj.CellValue2(gCurRow, prefix+"stl_vvd_seq"    ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"stl_bzc_port_cd") = "";
				sheetObj.CellValue2(gCurRow, prefix+"eta_dt"         ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"vsl_cd"         ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"skd_voy_no"     ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"skd_dir_cd"     ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"rev_dir_cd"     ) = "";
				sheetObj.SelectCell(gCurRow, prefix+"vsl_cd", true);
			}
			break;

		//I/O 변경
		case IBSEARCH_ASYNC03:
			formObj.f_cmd.value = SEARCHLIST03;
			formObj.cur_row.value = gCurRow-sheetObj.HeaderRows;

			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0011GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

			var CHECKVVD = ComGetEtcData(sXml,"CHECKVVD");
			if (CHECKVVD=="N"){
				var arrIocCd = ComGetEtcData(sXml,"ioc_cd").split("|");
				var arrPrc20 = ComGetEtcData(sXml,"rf_scg_prc_20").split("|");
				var arrPrc40 = ComGetEtcData(sXml,"rf_scg_prc_40").split("|");
				//alert(arrIocCd);
				sheetObj.CellValue2(gCurRow, prefix+"ioc_cd")        = arrIocCd[0];
				sheetObj.CellValue2(gCurRow, prefix+"rf_scg_prc_20") = arrPrc20[0];
				sheetObj.CellValue2(gCurRow, prefix+"rf_scg_prc_40") = arrPrc40[0];
				
				//TDR인 경우 InterPort에 Region 정보가 없으므로 자동으로 타게 한다.
				if (JooGetRadioValue(formObj.rf_scg_stl_tp_cd) == "T"){
					sheetObj.CellValue(gCurRow, prefix+"sconti_cd") = "A";
				}				

				for (i=1; i<arrIocCd.length; i++){
					sheetObj.SelectCell(gCurRow, 12);
					var row = sheetObj.DataCopy();
					sheetObj.CellValue2(row, prefix+"ioc_cd")        = arrIocCd[i];
					sheetObj.CellValue2(row, prefix+"rf_scg_prc_20") = arrPrc20[i];
					sheetObj.CellValue2(row, prefix+"rf_scg_prc_40") = arrPrc40[i];
					//TDR인 경우 InterPort에 Region 정보가 없으므로 자동으로 타게 한다.
					if (JooGetRadioValue(formObj.rf_scg_stl_tp_cd) == "T"){
						sheetObj.CellValue(row, prefix+"sconti_cd") = "A";
					}				
				}
				
			}else{
				if (CHECKVVD=="E"){
					ComShowCodeMessage("JOO00143");
					sheetObj.CellValue2(gCurRow, prefix+"ioc_cd") = "";
				}
			}
			break;

		//RGN변경시
		case IBSEARCH_ASYNC04:
			formObj.f_cmd.value = SEARCHLIST04;
			formObj.cur_row.value = gCurRow-sheetObj.HeaderRows;

			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0011GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

			var CHECKVVD = ComGetEtcData(sXml,"CHECKVVD");
			if (CHECKVVD=="N"){
				//여러건이 올수 있으므로...data copy로 넣는다.
				var arrFmPort = ComGetEtcData(sXml,"fm_port_cd").split("|");
				var arrToPort = ComGetEtcData(sXml,"to_port_cd").split("|");
				var arrQty20  = ComGetEtcData(sXml,"usd_slt_bsa_qty_20").split("|");
				var arrQty40  = ComGetEtcData(sXml,"usd_slt_bsa_qty_40").split("|");
				sheetObj.InitCellProperty(gCurRow, 9, dtData); //, daCenter, prefix+"fm_port_cd1" , "", dfNone)				
				sheetObj.InitCellProperty(gCurRow,10, dtData); //, daCenter, prefix+"to_port_cd1" , "", dfNone)				
				sheetObj.CellValue2(gCurRow, prefix+"fm_port_cd")         = arrFmPort[0];
				sheetObj.CellValue2(gCurRow, prefix+"to_port_cd")         = arrToPort[0];
				sheetObj.CellValue2(gCurRow, prefix+"fm_port_cd1")        = arrFmPort[0];
				sheetObj.CellValue2(gCurRow, prefix+"to_port_cd1")        = arrToPort[0];
				sheetObj.CellValue2(gCurRow, prefix+"usd_slt_bsa_qty_20") = arrQty20[0];
				sheetObj.CellValue2(gCurRow, prefix+"usd_slt_bsa_qty_40") = arrQty40[0];

				for (i=1; i<arrFmPort.length; i++){
					sheetObj.SelectCell(gCurRow, 12);
					var row = sheetObj.DataCopy();
					sheetObj.InitCellProperty(row, 9, dtData); //, daCenter, prefix+"fm_port_cd1" , "", dfNone)				
					sheetObj.InitCellProperty(row,10, dtData); //, daCenter, prefix+"to_port_cd1" , "", dfNone)				
					sheetObj.CellValue2(row, prefix+"fm_port_cd")         = arrFmPort[i];
					sheetObj.CellValue2(row, prefix+"to_port_cd")         = arrToPort[i];
					sheetObj.CellValue2(row, prefix+"fm_port_cd1")        = arrFmPort[i];
					sheetObj.CellValue2(row, prefix+"to_port_cd1")        = arrToPort[i];
					sheetObj.CellValue2(row, prefix+"usd_slt_bsa_qty_20") = arrQty20[i];
					sheetObj.CellValue2(row, prefix+"usd_slt_bsa_qty_40") = arrQty40[i];
				}
			}else if (CHECKVVD=="E"){
				sheetObj.CellValue2(gCurRow, prefix+"sconti_cd"         ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"usd_slt_bsa_qty_20") = "";
				sheetObj.CellValue2(gCurRow, prefix+"usd_slt_bsa_qty_40") = "";
				ComShowCodeMessage("JOO00143");
			}
			break;

		case IBSEARCH_ASYNC10: //마감여부 조회
			formObj.f_cmd.value = SEARCH10;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0011GS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				gClzYn = ComGetEtcData(sXml,"clz_yn"); 
				if (gClzYn == "C"){
					ComShowCodeMessage("JOO00177");
					JooSetBtnClass("C", false);
					sheetObjects[0].Editable = false;
				//Open상태면 Authority에 따라 Button을 활성화, 비활성화 한다.
				}else{
					if (comboObjects[2].index != -1){
						var code = comboObjects[2].Code;
						UF_setAuth(comboObjects[2].GetText(code, 3));
					}
				}
				
				if (canRetrieve()){
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
			}
			
			break;
	}
}

/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
*/ 
function initCombo(comboObj, comboNo) {
 var formObj = document.form
 
 switch(comboNo) {  
 	case 1: 
        with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
		    }
         var comboItems = gCrrCombo.split("|");
         addComboItem(comboObj, comboItems);           	
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
			break;
			
 	case 3: 
         with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left|left|left|left|left");        
				SetColWidth("30|0|0|0|0"); //rlane_cd, RTU, currency, auth_cd, JO_STL_OPT_CD (Bound, Round, Cycle)
				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
		    }
			break;
	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj, formObj, sAction, sComboObj, sComboKey) {
sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	
	case IBSEARCH: // TRADE
		// if(validateForm(sheetObj,formObj,sAction))
		if (sComboObj.id == "trd_cd") {
			// 콤보필드를 초기화시킨다.
			sComboObj.RemoveAll();
	
			formObj.f_cmd.value = SEARCHLIST06;
			formObj.code.value = "";
			formObj.super_cd1.value = formObj.jo_crr_cd.text;
			formObj.super_cd2.value = "";
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
            ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
		} else if (sComboObj.id == "rlane_cd") {
			// 콤보필드를 초기화시킨다.
			sComboObj.RemoveAll();
	
			formObj.f_cmd.value = SEARCHLIST15;
			formObj.code.value = formObj.jo_stl_itm_cd.value; // Item
			formObj.name.value = JooGetRadioValue(formObj.re_divr_cd); // re_divr_cd
			formObj.super_cd1.value = formObj.jo_crr_cd.text;
			formObj.super_cd2.value = formObj.trd_cd.text;
			//rlane_cd, RTU, currency, auth_cd, JO_STL_OPT_CD (Bound, Round, Cycle)
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
            ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code|name|super_cd1|auth_cd|super_cd2");
		}
	
		break;
	}
}

// Carrier 변경시 Trade조회
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();	
	comboObjects[1].Index2 = -1;
	comboObjects[2].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
}

function trd_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[0].Code.length < 3){
		ComShowCodeMessage("JOO00008");
		formObj.jo_crr_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;	
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"trd_cd");
		comboObj.Enable = true;	
	}	
}

//TRADE 변경시 LANE 조회
function trd_cd_OnChange(idx_cd, text){
	sheetObjects[0].RemoveAll();
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();
}

function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[1].Code.length < 3){
		ComShowCodeMessage("JOO00009");
		formObj.trd_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;	
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj, "rlane_cd");
		comboObj.Enable = true;	
	}	
}

//RLANE 변경시 clear
function rlane_cd_OnChange(comboObj, code, text){
	var sheetObj = sheetObjects[0]; 
	formObj = document.form;

	sheetObj.RemoveAll();
	var stlOptCd = comboObj.GetText(code,4);
	var rtu = comboObj.GetText(code,1);

	//Bound, Round이면 RDR/TDR을 Basic Port 에서 읽어 setting해준다.
	if (stlOptCd == null || stlOptCd == undefined || ComTrim(stlOptCd) == "" || stlOptCd == "B" ||  stlOptCd == "R"){
		if (rtu == null || rtu == undefined || ComTrim(rtu) == ""){
			JooSetRadioDisabled(formObj.rf_scg_stl_tp_cd, false);
		}else{
			JooSetRadioValue(formObj.rf_scg_stl_tp_cd, rtu);
			JooSetRadioDisabled(formObj.rf_scg_stl_tp_cd, true);
		}
	//Cycle이면 RDR/TDR 선택가능하게 한다. 
	}else if (stlOptCd == "C"){	
		JooSetRadioValue(formObj.rf_scg_stl_tp_cd, rtu);
		JooSetRadioDisabled(formObj.rf_scg_stl_tp_cd, false);
	}

	formObj.locl_curr_cd.value = comboObj.GetText(code,2);
	
	var rtuNmList = "";
	var rtuCdList = "";
	
	//RDR이면
	if (rtu == "R"){
		rtuCdList = "R|U";
		rtuNmList = "RDR|UI";
	}else if (rtu == "T"){
		rtuCdList = "T|U";
		rtuNmList = "TDR|UI";
	}else{
		rtuCdList = "R|T|U";
		rtuNmList = "RDR|TDR|UI";
	}
	sheetObj.InitDataCombo(0, prefix+"rf_scg_stl_tp_cd", rtuNmList, rtuCdList);
	UF_setAuth(comboObj.GetText(code, 3));
}

function rlane_cd_OnBlur(comboObj){
	var sheetObj = sheetObjects[0]; 
	formObj = document.form;

	if (comboObj.Code.length == 5){
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}
}

function UF_setAuth(auth){
	//마감되었다면 이미 버튼제어가 된 상태고 권한에 상관없이 disable
	if (gClzYn == "C") return;
	
	if (auth == null || auth == undefined){
		auth = "R";
	}
	var editable = true;
	if (auth == "R"){
		editable = false;
	}
	JooSetBtnClass("C", editable);
	for (var i = 0; i < sheetObjects.length; i++) {
		sheetObjects[i].Editable = editable;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBCREATE: //저장용 조회
			if (formObj.acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00033');
				formObj.acct_yrmon.focus();
				return false;
			}
			if (formObj.jo_crr_cd.index == -1){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Index == -1){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Index == -1){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}
			
			var idx_cd = formObj.rlane_cd.Code;
//			var rtu    = formObj.rlane_cd.GetText(idx_cd,1);
//			
//			if (rtu.length != 1){
//				ComShowCodeMessage('JOO00083');
//				return false;
//			}
//			
			var loclCurrCd = formObj.rlane_cd.GetText(idx_cd,2);
			
			if (loclCurrCd.length!=3){
				ComShowCodeMessage('JOO00082');
				return false;
			}
			
			if (JooGetRadioValue(formObj.rf_scg_stl_tp_cd) == ""){
				ComShowCodeMessage('JOO00171');
				return false;
			}
			break;
			
		case IBSEARCH: //조회
			if (formObj.acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00033');
				formObj.acct_yrmon.focus();
				return false;
			}
			if (formObj.jo_crr_cd.index == -1){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Index == -1){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Index == -1){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}
			break;
			
		case IBSAVE:   //저장
			var cnt = 0;
			for (var inx=sheetObj.HeaderRows; inx <= sheetObj.LastRow; inx++){
				var status = sheetObj.RowStatus(inx); 
				if (status == "R")
					continue;
				cnt++;

				var slip = sheetObj.CellValue(inx, prefix+"stl_cmb_seq");

				if (status == "D" &&  slip != ""){
					ComShowCodeMessage('JOO00057',inx, slip);
					sheetObj.SelectCell(inx, prefix+"del_chk", true);
					return false;
				}
				
				if ((status == "I" || status == "U") && sheetObj.CellValue(inx, prefix+"del_chk") == "1"){
					ComShowCodeMessage("JOO00079");
					sheetObj.SelectCell(inx,prefix+"del_chk",true);
					return false;
				}

				if (status == "D") 
					continue;
				
				if (sheetObj.CellValue(inx, prefix+"vsl_cd").length < 4){
					ComShowCodeMessage('JOO00040',inx);
					sheetObj.SelectCell(inx, prefix+"vsl_cd", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"skd_voy_no").length < 4){
					ComShowCodeMessage('JOO00041',inx);
					sheetObj.SelectCell(inx, prefix+"skd_voy_no", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"skd_dir_cd").length < 1){
					ComShowCodeMessage('JOO00042',inx);
					sheetObj.SelectCell(inx, prefix+"skd_dir_cd", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"rev_dir_cd").length < 1){
					ComShowCodeMessage('JOO00055',inx);
					sheetObj.SelectCell(inx, prefix+"rev_dir_cd", true);
					return false;
				}
				
				var rfScgStlTpCd = sheetObj.CellValue(inx, prefix+"rf_scg_stl_tp_cd");
				
				if (rfScgStlTpCd.length == 0){
					ComShowCodeMessage('JOO00084',inx);
					sheetObj.SelectCell(inx, prefix+"rf_scg_stl_tp_cd", true);
					return false;
				}

				var iocCd = sheetObj.CellValue(inx, prefix+"ioc_cd");
				
				if (iocCd.length == 0){
					ComShowCodeMessage('JOO00085',inx);
					sheetObj.SelectCell(inx, prefix+"ioc_cd", true);
					return false;
				}

				var scontiCd = sheetObj.CellValue(inx, prefix+"sconti_cd");
				
				if (scontiCd.length == 0){
					ComShowCodeMessage('JOO00086',inx);
					sheetObj.SelectCell(inx, prefix+"sconti_cd", true);
					return false;
				}

				var fmPortCd = sheetObj.CellValue(inx, prefix+"fm_port_cd");
				
				if (fmPortCd.length == 0){
					ComShowCodeMessage('JOO00087',inx);
					sheetObj.SelectCell(inx, prefix+"fm_port_cd1", true);
					return false;
				}

				var toPortCd = sheetObj.CellValue(inx, prefix+"to_port_cd");
				
				if (toPortCd.length == 0){
					ComShowCodeMessage('JOO00088',inx);
					sheetObj.SelectCell(inx, prefix+"to_port_cd1", true);
					return false;
				}
				
				//2010.01.05 AMOUNT가 0이면 저장못하도록 수정
				//Adjustment의 0값을 Combined시키기 위함
				if (sheetObj.CellValue(inx, prefix+"stl_locl_amt").length == 0
				||  sheetObj.CellValue(inx, prefix+"stl_locl_amt") == "0"){
					ComShowCodeMessage('JOO00056',inx);
					sheetObj.SelectCell(inx, prefix+"stl_locl_amt", true);
					return false;
				}
			}
			
			if (cnt==0){
				ComShowCodeMessage('JOO00036');
				return false;
			}
			break;
			
			
		case IBDELETE: //전체삭제
			var isCombined = false;
			var stlCmbSeq = "";
			//전체 Data삭제시 하나라도 Combined된 data가 있으면 삭제불가
			for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
				stlCmbSeq = sheetObj.CellValue(i, prefix+"stl_cmb_seq");
				if (ComTrim(stlCmbSeq) != ""){
					isCombined = true;
					break;
				}
			}
			if (isCombined){
				ComShowCodeMessage('JOO00057',i, stlCmbSeq);
				return false;
			}
			break;
	}
	return true;
}

/**
 * sheet1_OnSearchEnd
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SumText(0,prefix+"vsl_cd") = "TOTAL"; //TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김

	var rtu = JooGetRadioValue(formObj.rf_scg_stl_tp_cd);
	var rtuEditable = true;

	//TDR인 경우는 CREATE시 모든 값을 가져오므로 editable을 막아준다.
	if (rtu == "T"){
		rtuEditable = false;
	}

	//combined data는 삭제 checkbox를 막는다.
	for (var i=sheetObj.HeaderRows; i<= sheetObj.LastRow; i++){
		var stlCmbSeq = sheetObj.CellValue(i, prefix+"stl_cmb_seq");
		//combined No가 있으면 usd slot 을 수정할 수 없다.
		var bEditable = true;
		if (stlCmbSeq.length != 0){
			bEditable = false;
		}
		sheetObj.CellEditable(i, prefix+"del_chk"           ) = bEditable;
		sheetObj.CellEditable(i, prefix+"usd_slt_bsa_qty_20") = bEditable; 
		sheetObj.CellEditable(i, prefix+"usd_slt_bsa_qty_40") = bEditable;
		
		var ibflag = sheetObj.RowStatus(i);
		if (ibflag == "R"){
			sheetObj.CellEditable(i, prefix+"ioc_cd"   ) = false; 
			sheetObj.CellEditable(i, prefix+"sconti_cd") = false; 
		}else if (ibflag == "I"){
			sheetObj.CellEditable(i, prefix+"ioc_cd"   ) = rtuEditable; 
			sheetObj.CellEditable(i, prefix+"sconti_cd") = rtuEditable; 
		} 
	}	
	
	sheetObj.CellFont("FontBold",sheetObj.HeaderRows, prefix+"stl_locl_amt", sheetObj.LastRow) = true;
//	var ft20 = sheetObj.SumText(0,prefix+"stl_locl_amt_20");
//	var ft40 = sheetObj.SumText(0,prefix+"stl_locl_amt_40");
//	var total = Number(ComReplaceStr(ft20,",","")) + Number(ComReplaceStr(ft40,",",""));
//	sheetObj.SumText(0,prefix+"stl_cmb_seq") = ComAddCommaRun(total+"");  
}

/**
 * Sheet1_OnKeyUp
 * @param sheetObj
 * @param Row
 * @param Col
 * @param KeyCode
 * @param Shift
 * @return
 */
function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
	var sName = sheetObj.ColSaveName(Col);

	var Value = sheetObj.EditValue;
	//4자리 치면 NEXT로 이동
	if ((sName == (prefix+"vsl_cd")) && (Value.length == 4)){
		sheetObj.SelectCell(Row, prefix+"skd_voy_no",true);
	}

	//4자리 치면 NEXT로 이동
	if ((sName == (prefix+"skd_voy_no")) && (Value.length == 4)){
		sheetObj.SelectCell(Row, prefix+"skd_dir_cd",true);
	}
}

/**
 * sheet1_OnChange
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	gCurRow = Row;

	var vvd  = sheetObj.CellValue(Row, prefix+"vsl_cd");
	vvd += sheetObj.CellValue(Row, prefix+"skd_voy_no");
	vvd += sheetObj.CellValue(Row, prefix+"skd_dir_cd");
	vvd += sheetObj.CellValue(Row, prefix+"rev_dir_cd");
	
	if (vvd.length == 10){
		gVVD = vvd;
	}

	//VVD변경시 기본정보 조회
	if (sName == prefix+"vsl_cd" || sName==prefix+"skd_voy_no" || sName==prefix+"skd_dir_cd" || sName==prefix+"rev_dir_cd"){
		//9자리 입력시 Rev Dir.을 자동조회한다.
		var tmp = sheetObj.GetComboInfo(Row, prefix+"rev_dir_cd", "Code").split("|");
		if ( sName!=prefix+"rev_dir_cd" || tmp.length <= 1 && Value == "" && sheetObj.RowStatus(Row) == "I"){
			var vvd1  = sheetObj.CellValue(Row, prefix+"vsl_cd");
			vvd1 += sheetObj.CellValue(Row, prefix+"skd_voy_no");
			vvd1 += sheetObj.CellValue(Row, prefix+"skd_dir_cd");
			
			if (vvd1.length == 9){
				doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
			}
		}
		
		if (vvd.length == 10){
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}

	// R/T/U 변경시 Editable 변경 로직
	if (sName == prefix+"rf_scg_stl_tp_cd"){
		//User Input 인 경우 변경 못하도록 한다. 
		if (Value == "U"){
			sheetObj.CellEditable(Row, prefix+"rf_scg_stl_tp_cd"  ) = false;
			sheetObj.CellEditable(Row, prefix+"ioc_cd"            ) = true;
			sheetObj.CellEditable(Row, prefix+"sconti_cd"         ) = true;
			sheetObj.CellEditable(Row, prefix+"fm_port_cd1"       ) = true;
			sheetObj.CellEditable(Row, prefix+"to_port_cd1"       ) = true;
			sheetObj.CellEditable(Row, prefix+"usd_slt_bsa_qty_20") = true;
			sheetObj.CellEditable(Row, prefix+"usd_slt_bsa_qty_40") = true;
			sheetObj.CellValue(Row, prefix+"usd_slt_bsa_qty_20") = 0;
			sheetObj.CellValue(Row, prefix+"usd_slt_bsa_qty_40") = 0;			
		}else if (Value == "T"){
			sheetObj.CellEditable(Row, prefix+"rf_scg_stl_tp_cd"  ) = true;
			sheetObj.CellEditable(Row, prefix+"ioc_cd"            ) = false;
			sheetObj.CellEditable(Row, prefix+"sconti_cd"         ) = false;
			sheetObj.CellEditable(Row, prefix+"fm_port_cd1"       ) = true;
			sheetObj.CellEditable(Row, prefix+"to_port_cd1"       ) = true;
			sheetObj.CellEditable(Row, prefix+"usd_slt_bsa_qty_20") = true;
			sheetObj.CellEditable(Row, prefix+"usd_slt_bsa_qty_40") = true;
			sheetObj.CellValue(Row, prefix+"ioc_cd"   ) = "I";
			sheetObj.CellValue(Row, prefix+"sconti_cd") = "A";
		}else{
			sheetObj.CellEditable(Row, prefix+"rf_scg_stl_tp_cd"  ) = true;
			sheetObj.CellEditable(Row, prefix+"ioc_cd"            ) = true;
			sheetObj.CellEditable(Row, prefix+"sconti_cd"         ) = true;
			sheetObj.CellEditable(Row, prefix+"fm_port_cd1"       ) = false;
			sheetObj.CellEditable(Row, prefix+"to_port_cd1"       ) = false;
			sheetObj.CellEditable(Row, prefix+"usd_slt_bsa_qty_20") = false;
			sheetObj.CellEditable(Row, prefix+"usd_slt_bsa_qty_40") = false;
		}
		
		//2010.01.25 박효숙 차장 => Create해온 data중에 POL, POD가 없다면 UI로 변경시에 Port List를 조회해서 Combo로 Setting해준다.
		var tmp = sheetObj.GetComboInfo(Row, prefix+"fm_port_cd1", "Code").split("|");
		if (sheetObj.CellValue(Row, prefix+"fm_port_cd1") == "" && tmp.length <= 1){
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}
	
	// I/O 변경시 RF Surcharge (단가정보)를 조회한다.
	if (sName == prefix+"ioc_cd"){
		if (vvd.length != 10){
			ComShowCodeMessage("JOO00039");
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}
		
		var rf_scg_stl_tp_cd = sheetObj.CellValue(Row, prefix+"rf_scg_stl_tp_cd");
		
		if (rf_scg_stl_tp_cd.length < 1){
			ComShowCodeMessage("JOO00084");
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}

		sheetObj.CellValue2(Row, prefix+"sconti_cd"  )        = "";
		sheetObj.CellValue2(Row, prefix+"fm_port_cd" )        = "";
		sheetObj.CellValue2(Row, prefix+"to_port_cd" )        = "";
		sheetObj.CellValue2(Row, prefix+"fm_port_cd1")        = "";
		sheetObj.CellValue2(Row, prefix+"to_port_cd1")        = "";
		sheetObj.CellValue2(Row, prefix+"usd_slt_bsa_qty_20") = "";
		sheetObj.CellValue2(Row, prefix+"usd_slt_bsa_qty_40") = "";

		if (Value.length == 1){
			//2010.11.17 신자영  uc_bss_port_etd_dt 관련 로직 막음		
			//var ucBssPortEtdDt = sheetObj.CellValue(Row, prefix+"uc_bss_port_etd_dt");
			//if (ComTrim(ucBssPortEtdDt).length == 0){
			//	ComShowCodeMessage("JOO00173");
			//	sheetObj.CellValue2(Row, prefix+"ioc_cd") = "";
			//	return;
			//}
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
		}
	}

	// RGN변경시 Used RF 를 조회한다.
	if (sName == prefix+"sconti_cd"){
		if (vvd.length != 10){
			ComShowCodeMessage("JOO00039");
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}
		var ioc = sheetObj.CellValue(Row, prefix+"ioc_cd"); 
		if (ioc == ""){
			ComShowCodeMessage("JOO00155");
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}
		//RGN 변경시 R/T/U가 UI이면 user가 입력하는 것이므로 server에서 읽어올 필요 없다.
		var rtu = sheetObj.CellValue(Row, prefix+"rf_scg_stl_tp_cd");		
		if (rtu != "U" && Value.length == 1)
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
	}

	//From Port, To Port 변경시 Check
	if ((sName == prefix+"fm_port_cd1" || sName == prefix+"to_port_cd1") && gChange){
		var fmPortCd = sheetObj.CellValue(Row, prefix+"fm_port_cd1");
		var toPortCd = sheetObj.CellValue(Row, prefix+"to_port_cd1");
		
		sheetObj.CellValue2(Row, prefix+"fm_port_cd") = fmPortCd; 		
		sheetObj.CellValue2(Row, prefix+"to_port_cd") = toPortCd; 		
		
//		if (fmPortCd == toPortCd && fmPortCd.length >0 && toPortCd.length > 0){
//			ComShowCodeMessage("JOO00080");
//			sheetObj.CellValue2(Row, prefix+"to_port_cd1") = "";
//			sheetObj.SelectCell(Row, prefix+"to_port_cd1",true);
//			return;
//		}
	}
	
	//Used RF 변경시 중복체크
	if (sName == prefix+"usd_slt_bsa_qty_20" || sName == prefix+"usd_slt_bsa_qty_40"){
		//alert("탄다.");
		if (vvd.length != 10){
			ComShowCodeMessage("JOO00039");
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}

		var ioc = sheetObj.CellValue(Row, prefix+"ioc_cd"); 
		if (ioc == ""){
			ComShowCodeMessage("JOO00155"); // Please input 'Inter/Ocean' at first.
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}

		var rgn = sheetObj.CellValue(Row, prefix+"sconti_cd"); 
		if (rgn == ""){
			ComShowCodeMessage("JOO00156"); // Please input 'RGN' at first.
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}
		
		var vsl    = sheetObj.CellValue(Row, prefix+"vsl_cd");
		var voy    = sheetObj.CellValue(Row, prefix+"skd_voy_no");
		var dir    = sheetObj.CellValue(Row, prefix+"skd_dir_cd");
		var fin    = sheetObj.CellValue(Row, prefix+"rev_dir_cd");
		var fmPort = sheetObj.CellValue(Row, prefix+"fm_port_cd1");
		var toPort = sheetObj.CellValue(Row, prefix+"to_port_cd1");
		var qty20  = sheetObj.CellValue(Row, prefix+"usd_slt_bsa_qty_20");
		var qty40  = sheetObj.CellValue(Row, prefix+"usd_slt_bsa_qty_40");
		var amt20  = sheetObj.CellValue(Row, prefix+"stl_locl_amt_20");
		var amt40  = sheetObj.CellValue(Row, prefix+"stl_locl_amt_40");

		//같은 데이터가 있는지 확인
		if (existsSamePair(sheetObj, Row, vsl, voy, dir, fin, ioc, rgn, fmPort, toPort, qty20, qty40, amt20, amt40)){
			//계속하겠냐? 했을 때 아니면 삭제?
			if (!ComShowCodeConfirm("JOO00157")){
				sheetObj.CellValue2(Row, prefix+"sconti_cd" ) = "";
				sheetObj.CellValue2(Row, prefix+"fm_port_cd") = "";
				sheetObj.CellValue2(Row, prefix+"fm_port_cd1")= "";
				sheetObj.CellValue2(Row, prefix+"to_port_cd") = "";
				sheetObj.CellValue2(Row, prefix+"to_port_cd1")= "";
				sheetObj.CellValue2(Row, prefix+"usd_slt_bsa_qty_20") = "";
				sheetObj.CellValue2(Row, prefix+"usd_slt_bsa_qty_40") = "";
				sheetObj.CellValue2(Row, prefix+"stl_locl_amt_20") = "";
				sheetObj.CellValue2(Row, prefix+"stl_locl_amt_40") = "";
			}else{
				sheetObj.CellValue2(Row, prefix+"stl_dup_flg_20" ) = "Y";
				sheetObj.CellValue2(Row, prefix+"stl_dup_flg_40" ) = "Y";
			}
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	if (sName == prefix+"stl_locl_amt"){
		sheetObj.InitDataProperty(0, 16, dtAutoSum ,  80, daRight ,  true, prefix+"stl_locl_amt_20"   ,false, "Round(|sheet1_usd_slt_bsa_qty_20|*|sheet1_rf_scg_prc_20|,2)", dfFloat,2,false,false); //16
		sheetObj.InitDataProperty(0, 17, dtAutoSum ,  80, daRight ,  true, prefix+"stl_locl_amt_40"   ,false, "Round(|sheet1_usd_slt_bsa_qty_40|*|sheet1_rf_scg_prc_40|,2)", dfFloat,2,false,false); //17
	}
}

/**
 * 같은 Data가 있는 지 확인한다. (VVD, From port, To Port, 20FT Used RF, 40FT Used RF)
 * @param sheetObj
 * @param Row
 * @param vsl
 * @param voy
 * @param dir
 * @param fin
 * @param fmPort
 * @param toPort
 * @param qty20
 * @param qty40
 * @param amt20
 * @param amt40
 * @return
 */
function existsSamePair(sheetObj, Row, vsl, voy, dir, fin, ioc, rgn, fmPort, toPort, qty20,  qty40, amt20, amt40){
	var rtnVal = false;
	for(var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
		if (inx==Row) continue;
		
		var lvsl    = sheetObj.CellValue(inx, prefix+"vsl_cd");
		var lvoy    = sheetObj.CellValue(inx, prefix+"skd_voy_no");
		var ldir    = sheetObj.CellValue(inx, prefix+"skd_dir_cd");
		var lfin    = sheetObj.CellValue(inx, prefix+"rev_dir_cd");
		var lioc    = sheetObj.CellValue(inx, prefix+"ioc_cd");
		var lrgn    = sheetObj.CellValue(inx, prefix+"sconti_cd");
		var lfmPort = sheetObj.CellValue(inx, prefix+"fm_port_cd");
		var ltoPort = sheetObj.CellValue(inx, prefix+"to_port_cd");
		var lqty20  = sheetObj.CellValue(inx, prefix+"usd_slt_bsa_qty_20"); 
		var lqty40  = sheetObj.CellValue(inx, prefix+"usd_slt_bsa_qty_40"); 
		var lamt20  = sheetObj.CellValue(inx, prefix+"stl_locl_amt_20"); 
		var lamt40  = sheetObj.CellValue(inx, prefix+"stl_locl_amt_40"); 
		

		if (lvsl    == vsl 
		&&  lvoy    == voy  
		&&  ldir    == dir    
		&&  lfin    == fin    
		&&  lioc    == ioc    
		&&  lrgn    == rgn    
		&&  lfmPort == fmPort 
		&&  ltoPort == toPort 
		&& ((lqty20  == qty20 && lamt20  == amt20)
		 || (lqty40  == qty40 && lamt40  == amt40))){
			rtnVal = true;
			break;
		}
	}
	return rtnVal;
}

/**
 * account year month 버튼으로 변경시 조회가능여부를 check한다.
 * @return
 */
function canRetrieve(){
	formObj = document.form;
	var acctYrmon = ComReplaceStr(formObj.acct_yrmon.value,"-","");
	
	if (acctYrmon.length < 6)
		return false;
	
	var joCrrCd = formObj.jo_crr_cd.Code;
	
	if (joCrrCd.length < 3)
		return false;
	
	var trdCd = formObj.trd_cd.Code;
	
	if (trdCd.length < 3)
		return false;
	
	var rlaneCd = formObj.rlane_cd.Code;
	
	if (rlaneCd.length < 5)
		return false;
	
	return true;
}
/* 개발자 작업  끝 */