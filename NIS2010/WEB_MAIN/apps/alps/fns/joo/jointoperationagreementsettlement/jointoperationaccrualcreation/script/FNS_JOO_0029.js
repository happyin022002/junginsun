/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0029.js
 *@FileTitle : Estimate Performance Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier : 장강철
 *@LastVersion : 1.0
 * 2009.06.30 장강철
 * 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2011.06.30 [CHM-201111621-01]
 * 개발자 : 이준범
 * 제   목 : Estimate Performance  Creation 기능 보완 요청
 * 내   용 : 항목 및 항목별 조회 조건 추가
 *        - Adjust, Adjusted BSA, Adjusted Slot Cost, Adjuest Estimated Cost, Adjuest Actual Cost, Remark
 * 2011.08.16 [CHM-201112783-01]
 * 개발자 : 이준범
 * 제   목 : Estimate Performance Creation 기능 보완 요청
 * 내   용 : 1) Estimated Period 가 다른 경우도 Adjust 관련 Logic 을 적용 
 *        2) 검색조건에 Account, Type 신규 츄가         
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
 * @class fns_joo_0029 : fns_joo_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0029() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix="sheet1_";

var gRefresh = true;
var IBSEARCH2 = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

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
		case "btn1_Create": //CREATE
			doActionIBSheet(sheetObjects[0], formObject, IBCREATE);
			break;

		case "btn1_Target": //Target Retrieve					
			if(formObject.page_no.value == ""){
				formObject.page_no.value = "1";
			}		
			
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
			break;
						
		case "btn1_save": //SAVE
			if(sheetObjects[0].CellValue(1, prefix+"vvd") == ''){
				 return;
			}
			
			//class name 이 btn1_1 이면 click하지 않은 것 처럼 보이기 위함
			if (!fnBtnEnbleCheck(srcName)) {
				return;
			}
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;
	
		case "btn1_I_F": //InterFace
			//class name 이 btn1_1 이면 click하지 않은 것 처럼 보이기 위함
			if (!fnBtnEnbleCheck(srcName)) {
				return;
			}
			doActionIBSheet(sheetObjects[0], formObject, IBBATCH);
			break;
			
		case "btn1_F_R": //I/F 조회
			if(formObject.page_no.value == ""){
				formObject.page_no.value = "1";
			}			
			
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC05);
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
		
//		case "btn_Down_Excel2": //DownExcel
//			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
//			break;			
												
		case "btn_last" :
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH2);			
			break;
			
		case "reward":
			var ipageNo = formObject.page_no.value;
			ipageNo--;

//			if(Number(ipageNo) < 1){
//				var errMessage = ComGetMsg('JOO00214','','','');  		// msgs['TRS90351'] = 'You have just selected the number of page beyond that of total pages.' ;
//				ComShowMessage(errMessage);
//				break;
//			}  
			
			if(ipageNo < 1){
				ipageNo = 1;
			}
			
			formObject.page_no.value = ipageNo;
//			doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;

		case "forward":
			var ipageNo = formObject.page_no.value;
			var totpage = formObject.tot_page_cnt.value;
			ipageNo++;  
//			if( (Number(ipageNo) > Number(formObject.tot_page_cnt.value)) || totpage < 1){
//				var errMessage = ComGetMsg('JOO00214','','','');	// msgs['TRS90351'] = 'You have just selected the number of page beyond that of total pages.' ;  
//				ComShowMessage(errMessage);
//				break;
//			}
			formObject.page_no.value = ipageNo;
//			doActionIBSheet(sheetObject,formObject,IBSEARCH);
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

	form.rev_yrmon_fr.value = ComGetDateAdd(gYyyyMM+"01", "Y", -3,"-1").substring(0,4)+"-01";	
	
	initControl();
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
			
		case 2: 
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
			
		case 3: 
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

			comboObj.InsertItem(0, "", "");
			comboObj.InsertItem(1, "411221", "411221");
			comboObj.InsertItem(2, "411223", "411223");
			comboObj.InsertItem(3, "411222", "411222");
			comboObj.InsertItem(4, "510921", "510921");
			comboObj.InsertItem(5, "510922", "510922");
			comboObj.InsertItem(6, "510991", "510991");

			break;		

		case 5: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}

			comboObj.InsertItem(0, "", "");
			comboObj.InsertItem(1, "RV", "RV");
			comboObj.InsertItem(2, "BV", "BV");
			comboObj.InsertItem(3, "PV ", "PV ");

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

	axon_event.addListener('click', 'fnDocClick', "btn_exe_back");
	axon_event.addListener('click', 'fnDocClick', "btn_exe_next");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_from_back");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_from_next");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_to_back");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_to_next");
    axon_event.addListener('click', 're_divr_cd_click', 're_divr_cd');

	axon_event.addListenerForm('keypress', 'fnObjKeyPress', formObject);
    axon_event.addListenerForm('keyup'   , 'fnObjKeyUp'   , formObject);    

	axon_event.addListenerFormat('blur', 'fnDeactivate', formObject);
	axon_event.addListenerFormat('focus', 'fnActivate', formObject);

	if (gClzFlg == "N") {
		fnBtnEnable("C", true);
	} else {
		fnBtnEnable("C", false);
	}
		
	formObject.exe_yrmon.focus();
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
			style.height = 352;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Seq.|Revenue\nMonth|Carrier\nCode|Service\nProvider/\nCustomer|Revenue\nVVD|Revenue\nLane|BSA\nType|BSA|Slot\nPrice"
				+"|Account\nCode|Estimated\nCost|Actual\nCost|Accrual\nCost|Type|IO\nFlag|STS\nMK|Adjust|Adjust\nRelease|Adjusted\nBSA|Adjusted\nSlot Price|Adjusted\nEstimated Cost|Adjusted\nAccrual Cost|Review\nResult|Remark|Actual Month|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|REV_DIR_CD||||||estm_act_seq|cust_cnt_cd|cust_seq|Bsa Type";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(39, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus       , 30, daCenter, false, prefix+"ibflag"           , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData    	    ,  30, daCenter, false, prefix+"seq_no"              , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  60, daCenter, false, prefix+"rev_yrmon"        , false, "", dfDateYm, 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  50, daCenter, false, prefix+"jo_crr_cd"        , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  90, daCenter, false, prefix+"vndr_cust_seq"    , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  80, daLeft  , false, prefix+"vvd"              , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  60, daCenter, false, prefix+"rlane_cd"         , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData         , 110, daLeft  , false, prefix+"jo_stl_jb_nm"     , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  50, daRight , false, prefix+"bsa_qty"          , false, "", dfNumber, 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  60, daRight , false, prefix+"bsa_slt_prc"      , false, "", dfFloat , 2, false, false);
			InitDataProperty(0, cnt++, dtData         ,  70, daCenter, false, prefix+"acct_cd"          , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtAutoSum  ,  120, daRight , false, prefix+"estm_amt"         , false, "", dfFloat , 2, false, false);
			InitDataProperty(0, cnt++, dtAutoSum  ,  120, daRight , false, prefix+"act_amt"          , false, "", dfFloat , 2, false, false);
			InitDataProperty(0, cnt++, dtAutoSum  ,  120, daRight , false, prefix+"accl_amt"         , false, "", dfFloat , 2, true , true );
			InitDataProperty(0, cnt++, dtData         ,  40, daCenter, false, prefix+"estm_vvd_tp_cd"   , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  40, daCenter, false, prefix+"jo_ioc_div_cd"    , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  40, daCenter, false, prefix+"accl_amt_corr_flg", false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtCombo        ,  60, daCenter, false, prefix+"adj_estm_flg"     , false, "", dfNone  , 0, true, true);
			
			InitDataProperty(0, cnt++, dtData        ,  90, daCenter, false, prefix+"adj_rlse_rmk"     , false, "", dfNone  , 0, false, false);
			
			InitDataProperty(0, cnt++, dtData         ,  70, daRight , false, prefix+"adj_bsa_qty"      , false, "", dfNumber, 0, false, false);
			InitDataProperty(0, cnt++, dtData         ,  70, daRight , false, prefix+"adj_bsa_slt_prc"  , false, "", dfFloat , 2, false, false);
			InitDataProperty(0, cnt++, dtData         ,  90, daRight , false, prefix+"adj_estm_amt"     , false, "", dfFloat , 2, false, false);
			InitDataProperty(0, cnt++, dtData         ,  90, daRight , false, prefix+"adj_accl_amt"     , false, "", dfFloat , 2, false, false);
		
			InitDataProperty(0, cnt++, dtCombo         ,  100, daCenter, false, prefix+"adj_rslt_cd"     , false, "", dfNone  , 0, true, true);
			
			InitDataProperty(0, cnt++, dtData         , 110, daLeft  , false, prefix+"adj_rmk"          , false, "", dfNone  , 0,  true, true);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"exe_yrmon"        , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"vsl_cd"           , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"skd_voy_no"       , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"skd_dir_cd"       , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"rev_dir_cd"       , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"estm_vvd_hdr_id"  , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"cntr_blk_div_cd"  , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"sys_src_id"       , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"jo_cntr_div_ctnt" , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"loc_cd"           , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"estm_act_seq"     , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"cust_cnt_cd"      , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"cust_seq"         , false, "", dfNone  , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden       ,   0, daLeft  , false, prefix+"jo_stl_jb_cd"     , false, "", dfNone  , 0, false, false);
			//InitDataCombo (0, prefix+"jo_stl_jb_cd",gBsaTpNm , gBsaTpCd);
			InitDataCombo(0, prefix+"adj_estm_flg",    "N|Y", "N|Y");
			InitDataCombo(0, prefix+"adj_rslt_cd",    " |Wrong BSA/Price|Used Basis Sttl|Wrong Sttl|Next Sttl|Others", " |A|B|C|D|E");
			CountPosition = 0;
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
			formObj.cre_flg.value = "N";
			setConditionValue('1');			
			var param = FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0029GS.do", param);						
			sheetObj.LoadSearchXml(sXml, false); //Append X
			
			setTotalValue(sXml);
			break;
			
		case IBSEARCH_ASYNC05: //조회

			if(sheetObj.CellValue(1, prefix+"vvd") != ''){
				formObj.f_cmd.value = SEARCH;				
			}else{
				formObj.f_cmd.value = SEARCH01;				
			}			
			
			formObj.f_cmd.value = SEARCH01;
			formObj.cre_flg.value = "N";
			
			setConditionValue('3');	
			
			var param = FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0029GS.do", param);
			sheetObj.LoadSearchXml(sXml, false); //Append X
			
			setTotalValue(sXml);			
			break;			
			
		case IBSEARCH2: //End 조회			
			if(sheetObj.CellValue(1, prefix+"vvd") != ''){
				formObj.f_cmd.value = SEARCH;
			}else{
				formObj.f_cmd.value = SEARCH01;
			}
			var pageNo = Number(formObj.page_no.value);
			formObj.cre_flg.value = "N";			
			formObj.page_no.value = ("");			
			sheetObj.RemoveAll();
			
			var param = FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			sheetObj.SpeedOption = "NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOSEQ,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
			sheetObj.DoSearch4Fx("FNS_JOO_0029GS.do", param);
			
			break;
			
		case IBCREATE: //Create			
			if (!ComShowCodeConfirm("JOO00212")){
				return false;
			}			
						
			formObj.f_cmd.value = SEARCHLIST01;
			formObj.cre_flg.value = "Y"; //삭제후 서버에서 create용 query로 insert한다
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0029GS.do", FormQueryString(formObj));
			var key = ComGetEtcData(sXml,"key");

            if (key.length > 0) {
    			gRefresh = true; // 결과 file에서 조회해야함
                formObj.key.value = key;
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                sheetObj.RequestTimeOut = 10000;
                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
            }			
			break;
			

		case IBSEARCH_ASYNC04: //Create 대상 조회
			if (!ComShowCodeConfirm("JOO00213")){
				return false;
			}			
						
			formObj.f_cmd.value = SEARCHLIST04;
			formObj.cre_flg.value = "Y2"; //삭제후 서버에서 create용 query로 insert한다
			setConditionValue('2');
									
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0029GS.do", FormQueryString(formObj));
			var key = ComGetEtcData(sXml,"key");
			
            if (key.length > 0) {
    			gRefresh = true; // 결과 file에서 조회해야함
                formObj.key.value = key;
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                sheetObj.RequestTimeOut = 10000;
                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
            }			
			break;
			
			
		case IBSAVE: //저장
			formObj.f_cmd.value = MULTI;

			var SaveStr = ComGetSaveString(sheetObj);			
			
			if (formObj.cre_flg.value == "N" && SaveStr == ""){
				ComShowCodeMessage("JOO00036");
				return false;
			}
			
			// Create한 후에 저장 할 수 없음.(2015.03 민정호)
			if (formObj.cre_flg.value == "Y" ||  formObj.cre_flg.value == "Y2"){
				ComShowCodeMessage("JOO00036");
				return false;
			}			
			
			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}
			
			var param = SaveStr + "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0029GS.do", param);
			var key = ComGetEtcData(sXml, "key");
            if (key.length > 0) {
    			gRefresh = false; // 결과 file에서 조회해야함
                formObj.key.value = key;
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                sheetObj.RequestTimeOut = 10000;
                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
    			formObj.cre_flg.value = "N"; //저장후에는 N으로 
            }			
			break;


		case IBBATCH: //I/F
			formObj.f_cmd.value = MULTI01;

			if (sheetObj.RowCount == 0){
				ComShowCodeMessage('JOO00036');
				return;
			}

			var SaveStr = ComGetSaveString(sheetObj);

			if (SaveStr != ""){					
				ComShowCodeMessage('JOO00128');
				return false;
			}
			
			if (!ComShowCodeConfirm("JOO00129")){
				return false;
			}
			formObj.page_no.value = "";//전체를 넘겨야 함
			//var param = SaveStr + "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0029GS.do", param);
			var key = ComGetEtcData(sXml, "key");

            if (key.length > 0) {
    			gRefresh = false; // 결과 file에서 조회 필요없음
                formObj.key.value = key;
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                sheetObj.RequestTimeOut = 10000;
                timer = setInterval(UF_getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
            }			
			
			break;			
			
		
		//조회조건 변경
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value = SEARCHLIST02;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0029GS.do", FormQueryString(formObj));
			
			var conFlg = formObj.estm_cond_flg.value;
			switch(conFlg){
				//EXE_YRMON, RE_DIVR_Cd변경시 REV_YRMON_FR, REV_YRMON_TO, TRADE, LANE, CARRIER 조회한다.
				case "1":
					var clzFlg = ComGetEtcData(sXml, "estm_clz_flg");
					if (clzFlg == "N") {
						fnBtnEnable("C", true);
					} else {
						fnBtnEnable("C", false);
					}	
				//EXE_YRMON, RE_DIVR_Cd변경시 REV_YRMON_FR, REV_YRMON_TO, TRADE, LANE, CARRIER 조회한다.
				case "2":
					var trdCombo = ComGetEtcData(sXml, "TRD_CD");
					if (ComTrim(trdCombo) != ""){
						var comboItems = (" |"+trdCombo).split("|");
						addComboItem(comboObjects[0], comboItems);
					}
				
				case "3":
					var rlaneCombo = ComGetEtcData(sXml, "RLANE_CD");
					if (ComTrim(rlaneCombo) != ""){
						var comboItems = (" |"+rlaneCombo).split("|");
						addComboItem(comboObjects[1], comboItems);
					}
					
				case "4":
					var crrCombo = ComGetEtcData(sXml, "JO_CRR_CD");
					if (ComTrim(crrCombo) != ""){
						var comboItems = (" |"+crrCombo).split("|");
						addComboItem(comboObjects[2], comboItems);
					}
					break;
			}
			break;

		case IBRESET: //NEW 버튼  
			UF_reset();
			break;

		//BackEndJob Status 조회
		case IBSEARCH_ASYNC02: 			
		    formObj.f_cmd.value = SEARCHLIST;
		    var sXml = sheetObj.GetSearchXml("FNS_JOO_0029GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix));
		    var jobState = ComGetEtcData(sXml, "jb_sts_flg")

		    if (jobState == "3") {
		        ComOpenWait(false);
		        clearInterval(timer);
		        ComShowCodeMessage("JOO00160");
		        if (gRefresh)
//------------------------------------------------------------------
					if(formObj.cre_flg.value == "Y2"){
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
					}else if(formObj.cre_flg.value == "Y"){
						// Create 한 후에 조회(2015.03 민정호)
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
//------------------------------------------------------------------		        	
		    } else if (jobState == "4") {
		        ComOpenWait(false);
		        clearInterval(timer);
		        // BackEndJob을 실패 하였습니다.
		        ComShowCodeMessage('JOO00151');
		    } else if (jobState == "5") {
		        ComOpenWait(false);
		        clearInterval(timer);
		        // 이미 BackEndJob 결과 파일을 읽었습니다.
		        ComShowCodeMessage('JOO00152');
		    }
			
			break;

		//BackEndJob 결과 조회
		case IBSEARCH_ASYNC03: 			
            sheetObj.WaitImageVisible = true;			
		    formObj.f_cmd.value = SEARCHLIST03;
		    var sXml = sheetObj.GetSearchXml("FNS_JOO_0029GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix));
		    sheetObj.LoadSearchXml(sXml);
		    
			setTotalValue(sXml);	    		    		    
			break;
			
//		case IBDOWNEXCEL:
//			if(validateForm(sheetObj,formObj,sAction)){
//				ComOpenWait(true);
//				
//				formObj.cre_flg.value = "N";			
//								
//				setConditionValue('0');
//											
//			    formObj.f_cmd.value = SEARCH02;
//			    formObj.target = "_blank";
//				formObj.action = "FNS_JOO_0029GSEXL.do?"+ FormQueryString(formObj);
//								
//			    formObj.submit();
//			    ComOpenWait(false);
//			}
//	        break;						
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
			case IBSEARCH:
				if (formObj.exe_yrmon.value.length == 0){
					ComShowCodeMessage('JOO00089');
					formObj.exe_yrmon.focus();
					return false;
				}
				break;
				
			case IBSEARCH_ASYNC05:
				if (formObj.exe_yrmon.value.length == 0){
					ComShowCodeMessage('JOO00089');
					formObj.exe_yrmon.focus();
					return false;
				}
				break;				
				
			case IBSEARCH2:
				
				if (formObj.cre_flg.value == "Y" || formObj.cre_flg.value == "Y2"){					
					ComShowCodeMessage("JOO00172");
					return false;
				}
				break;
				
			case IBCREATE:
				if (formObj.exe_yrmon.value.length == 0){
					ComShowCodeMessage('JOO00089');
					formObj.exe_yrmon.focus();
					return false;
				}

				if (formObj.rev_yrmon_fr.value.length == 0){
					ComShowCodeMessage('JOO00089');
					formObj.rev_yrmon_fr.focus();
					return false;
				}

				if (formObj.rev_yrmon_to.value.length == 0){
					ComShowCodeMessage('JOO00089');
					formObj.rev_yrmon_to.focus();
					return false;
				}

				var exDt = formObj.exe_yrmon.value.replaceStr("-","")+"01";
				var frDt = formObj.rev_yrmon_fr.value.replaceStr("-","")+"01";
				var toDt = formObj.rev_yrmon_to.value.replaceStr("-","")+"01";

				if (ComGetDaysBetween(frDt, toDt) < 0){
					ComShowCodeMessage('JOO00078');
					formObj.rev_yrmon_to.focus();
					return false;
				}	

				//Estimate Year Month가 Target VVD From Year month 보다 연도가 다르면서 적은경우 에러처리 
				if ((exDt.substring(0,4) != frDt.substring(0,4)) && (ComGetDaysBetween(exDt, frDt) > 0)){
					ComShowCodeMessage('JOO00130');
					formObj.exe_yrmon.focus();
					return false;
				}	

				break;
				
			case IBSAVE:
				break;

			case IBBATCH: // I/F
				if (JooGetRadioValue(formObj.re_divr_cd) != ""){
					ComShowCodeMessage('JOO00127');
					return false;
				}
				if (comboObjects[0].Index != -1){
					ComShowCodeMessage('JOO00127');
					return false;
				}
				if (comboObjects[1].Index != -1){
					ComShowCodeMessage('JOO00127');
					return false;
				}
				if (comboObjects[2].Index != -1){
					ComShowCodeMessage('JOO00127');
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

	formObj.estm_amt.value = 0;
	formObj.act_amt .value = 0;
	formObj.accl_amt.value = 0;
	formObj.tot_cnt .value = 0;
	
	comboObjects[0].RemoveAll();
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	comboObjects[3].Code2 = "";
	comboObjects[4].Code2 = "";
//	ComBtnEnable("btn_next");
	formObj.diff.checked = false;
	formObj.adjust.checked = false;	
	
	var comboItems;
	
	if (ComTrim(gTrdCd) != ""){
		comboItems = (" |"+gTrdCd).split("|");
		addComboItem(comboObjects[0], comboItems);           	
	}

	//Rlane Combo setting
	if (ComTrim(gRlaneCd) != ""){
		comboItems = (" |"+gRlaneCd).split("|");
		addComboItem(comboObjects[1], comboItems);
	}
	
	//Carrier Combo setting
	if (ComTrim(gJoCrrCd) != ""){
		comboItems = (" |"+gJoCrrCd).split("|");
		addComboItem(comboObjects[2], comboItems);           	
	}
	
	formObj.exe_yrmon.value    = ComGetDateAdd(gYyyyMM+"01","M",-1,"-").substring(0,7);
	formObj.rev_yrmon_fr.value = ComGetDateAdd(gYyyyMM+"01", "Y", -2,"-1").substring(0,4)+"-01";	
	formObj.rev_yrmon_to.value = gYyyyMM;
	
	formObj.re_divr_cd[0].checked = true;
	formObj.vvd.value = "";
	sheetObjects[0].RemoveAll();
	
	formObj.exe_yrmon.focus();
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
		case 'exe_yrmon':
			ComAddSeparator(event.srcElement);
			break;
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
	case 'exe_yrmon':
		ComClearSeparator(event.srcElement);
		break;
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
 * 년월 NAVI 처리 이벤트 
 * @param void
 * @return void
 */
function fnDocClick() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
		case "btn_exe_back":
			UF_addMonth(formObj.exe_yrmon, -1);
			UF_setCond("1");
			break;

		case "btn_exe_next":
			UF_addMonth(formObj.exe_yrmon, +1);
			UF_setCond("1");
			break;

		case "btn_vvd_from_back":
			UF_addMonth(formObj.rev_yrmon_fr, -1);
			formObj.estm_amt.value = "";
			formObj.act_amt .value = "";
			formObj.accl_amt.value = "";
			formObj.tot_cnt .value = "";
			sheetObjects[0].RemoveAll();
			break;

		case "btn_vvd_from_next":
			if (!UF_checkPeriod()){
				ComShowCodeMessage("JOO00078");
				return;
			}
			UF_addMonth(formObj.rev_yrmon_fr, +1);
			formObj.estm_amt.value = "";
			formObj.act_amt .value = "";
			formObj.accl_amt.value = "";
			formObj.tot_cnt .value = "";
			sheetObjects[0].RemoveAll();
			break;

		case "btn_vvd_to_back":
			if (!UF_checkPeriod()){
				ComShowCodeMessage("JOO00078");
				return;
			}
			UF_addMonth(formObj.rev_yrmon_to, -1);
			formObj.estm_amt.value = "";
			formObj.act_amt .value = "";
			formObj.accl_amt.value = "";
			formObj.tot_cnt .value = "";
			sheetObjects[0].RemoveAll();
			break;

		case "btn_vvd_to_next":
			UF_addMonth(formObj.rev_yrmon_to, +1);
			formObj.estm_amt.value = "";
			formObj.act_amt .value = "";
			formObj.accl_amt.value = "";
			formObj.tot_cnt .value = "";
			sheetObjects[0].RemoveAll();
			break;
	}
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
		case 'exe_yrmon':
			ComKeyOnlyNumber(obj);
			break;
	
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

function fnObjKeyUp() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
		case 'exe_yrmon':
			if (obj.value.length == 6){
				ComKeyEnter('lengthnextfocus');
				UF_setCond("1");
			}
			break;
	}
}
/**
 * 
 * <pre>
 *     버튼 Event Check
 * </pre>
 *
 * @param   
 * @return
 * @author jang kang cheol
 */
function fnBtnEnbleCheck(srcName) {
	var docObj = eval("document.all." + srcName);

	var aBol = true;

	if (docObj.id.indexOf("btn") > -1) {
		if (docObj.className == "btn1_1") {
			aBol = false;
		}
	}
	return aBol;
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

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	
	var adjEstmFlg   = sheetObj.CellValue(Row, prefix+"adj_estm_flg");
	var adjBsaQty    = sheetObj.CellValue(Row, prefix+"adj_bsa_qty");
	var adjBsaSltPrc = sheetObj.CellValue(Row, prefix+"adj_bsa_slt_prc");
	var bsaQty       = sheetObj.CellValue(Row, prefix+"bsa_qty");
	var bsaSltPrc    = sheetObj.CellValue(Row, prefix+"bsa_slt_prc");
	var actAmt       = sheetObj.CellValue(Row, prefix+"act_amt");
	var adjEstmAmt   = null;
	
	
	if (sName == prefix+"accl_amt"){
		sheetObj.CellValue2(Row, prefix+"accl_amt_corr_flg") = "Y";
	
	} else if (sName == prefix+"adj_estm_flg"){
		
		if ( Value == "Y") {
			sheetObj.CellEditable(Row, prefix+"adj_bsa_qty")     = true;
			sheetObj.CellEditable(Row, prefix+"adj_bsa_slt_prc") = true;

		}else {
			
			sheetObj.CellValue2(Row, prefix+"adj_bsa_qty")     = bsaQty;
			sheetObj.CellValue2(Row, prefix+"adj_bsa_slt_prc") = bsaSltPrc;
			sheetObj.CellValue2(Row, prefix+"adj_rmk") = "";
			
			adjEstmAmt = bsaQty * bsaSltPrc;
			sheetObj.CellValue2(Row, prefix+"adj_estm_amt") = adjEstmAmt;

			sheetObj.CellEditable(Row, prefix+"adj_bsa_qty")     = false;
			sheetObj.CellEditable(Row, prefix+"adj_bsa_slt_prc") = false;
			
			//sheetObj.CellValue2(Row, prefix+"adj_accl_amt") = adjEstmAmt - actAmt;	
			/////////////////////////////////////
			// * -50<=Adjusted Accrual Cost<=50인 경우에는, 
			//실제 값(Adjusted Estimated Cost-Actual Cost) 대신에 0(zero)으로 계산함.
			
			var sumAmt = adjEstmAmt - actAmt;
			if ((sumAmt > -51) && (sumAmt < 51)) {
				sheetObj.CellValue2(Row, prefix+"adj_accl_amt") = 0;			
			} else {
				sheetObj.CellValue2(Row, prefix+"adj_accl_amt") = adjEstmAmt - actAmt;					
			}
			
		}
	} else if (sName == prefix+"adj_bsa_qty" || sName == prefix+"adj_bsa_slt_prc"){
	
		adjEstmAmt = adjBsaQty * adjBsaSltPrc;
		sheetObj.CellValue2(Row, prefix+"adj_estm_amt") = adjEstmAmt;
		
		//sheetObj.CellValue2(Row, prefix+"adj_accl_amt") = adjEstmAmt - actAmt;	
		/////////////////////////////////////
		// * -50<=Adjusted Accrual Cost<=50인 경우에는, 
		//실제 값(Adjusted Estimated Cost-Actual Cost) 대신에 0(zero)으로 계산함.
		
		var sumAmt = adjEstmAmt - actAmt;
		if ((sumAmt > -51) && (sumAmt < 51)) {
			sheetObj.CellValue2(Row, prefix+"adj_accl_amt") = 0;			
		} else {
			sheetObj.CellValue2(Row, prefix+"adj_accl_amt") = adjEstmAmt - actAmt;					
		}
		
	}
	
	if (adjEstmFlg == "Y") {
		sheetObj.CellValue2(Row, prefix+"adj_rlse_rmk") = "";
	} else {
		//sheetObj.CellValue2(Row, prefix+"adj_rlse_rmk") = "Released";
	}
	
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj    = document.form;
	var adjEstmFlg = null ;
	
//	if (formObj.cre_flg.value == "Y" || formObj.cre_flg.value == "Y2"){
//		formObj.estm_amt.value = sheetObj.SumText(0, prefix+"estm_amt");
//		formObj.act_amt .value = sheetObj.SumText(0, prefix+"act_amt");
//		formObj.accl_amt.value = sheetObj.SumText(0, prefix+"accl_amt");
//		formObj.tot_cnt .value = sheetObj.RowCount;
//	    ComAddSeparator(formObj.tot_cnt ,"int");			
//	}

	for (i = 0; i < sheetObj.RowCount; i++) {
		adjEstmFlg = sheetObj.CellValue(i, prefix+"adj_estm_flg");
		if ( adjEstmFlg == "Y"){
			sheetObj.CellEditable(i, prefix+"adj_bsa_qty")     = true;
			sheetObj.CellEditable(i, prefix+"adj_bsa_slt_prc") = true;
		}
	}
		
	var cmd = formObj.f_cmd.value;
	var cur_page = formObj.page_no.value;
	if( (cmd == SEARCH || cmd == SEARCH01 || cmd == SEARCHLIST03) && sheetObj.RowCount > 0 && cur_page == "1") {
		var tot_page_cnt = sheetObj.EtcData('tot_page_cnt');
		formObj.tot_page_cnt.value = tot_page_cnt;
	}			
}

function UF_setCond(flg){
	var formObj = document.form;
	
	formObj.estm_amt.value = "";
	formObj.act_amt .value = "";
	formObj.accl_amt.value = "";
	formObj.tot_cnt .value = "";
	
	formObj.estm_cond_flg.value = flg;
	
	switch (flg){
	//exe month, re_divr_cd 변경시
	case "1":
	//rev year month변경시
	case "2":
		formObj.trd_cd2.Index2 = -1;
		formObj.trd_cd2.RemoveAll();
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
	doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);		
}

function UF_checkPeriod(){
	var formObj = document.form;
	var frDt = formObj.rev_yrmon_fr.value.replaceStr("-","")+"01";
	var toDt = formObj.rev_yrmon_to.value.replaceStr("-","")+"01";

	if (ComGetDaysBetween(frDt, toDt) <= 0){
		return false;
	}	
	
	return true;
}

function UF_getBackEndJobStatus() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
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
 * Onkeydown 이벤트 관련
 */
 function gotopage(){
	 var formObject = document.form;
	 var tot_page = "";
	 var cur_page = "";
	 cur_page = formObject.page_no.value;
	 tot_page = formObject.tot_page_cnt.value;
	 if( (Number(cur_page) > Number(tot_page)) || tot_page < 1){
		 var errMessage = ComGetMsg('JOO00214','','','');  			// 	msgs['TRS90351'] = 'You have just selected the number of page beyond that of total pages.' ;
		 ComShowMessage(errMessage);
		 return;
	 }
	 doActionIBSheet(sheetObjects[0],formObject,"IBSEARCH"); 
 }

 /**
  * setTotalValue
  */
  function setTotalValue(sXml){ 
	var formObj = document.form;  
  
	if(formObj.page_no.value == '1'){	// 1page만 실행
		formObj.estm_amt.value = ComGetEtcData(sXml, "estm_amt");
		formObj.act_amt .value = ComGetEtcData(sXml, "act_amt");
		formObj.accl_amt.value = ComGetEtcData(sXml, "accl_amt");
		formObj.tot_cnt .value = ComGetEtcData(sXml, "tot_cnt");

		ComAddSeparator(formObj.estm_amt,"float");
	    ComAddSeparator(formObj.act_amt ,"float");
	    ComAddSeparator(formObj.accl_amt,"float");
	    ComAddSeparator(formObj.tot_cnt ,"int");
	}	 
  }
  
  /**
   * setTotalValue
   */  
  function changeRetreieveGubun(){
		var formObj = document.form;
		
		sheetObjects[0].RemoveAll();
		
//		formObj.search_gubun2.value = formObj.search_gubun3.value;
//		formObj.search_gubun.value = formObj.search_gubun3.value;		
  }
  
  /**
   * setConditionValue
   */    
  function setConditionValue(searchGubun){
		var formObj = document.form;
		
		if(searchGubun == '0'){
//			formObj.search_gubun2.value = formObj.search_gubun3.value;			
//			formObj.search_gubun.value = formObj.search_gubun3.value;			
		}else{
//			formObj.search_gubun3.value = searchGubun;
			formObj.search_gubun2.value = searchGubun;
			formObj.search_gubun.value = searchGubun;					
		}
		
		formObj.pagerows.value = formObj.pagerows2.value; 
		formObj.trd_cd.value = comboObjects[0].Code;
		formObj.rlane_cd.value = comboObjects[1].Code;
		formObj.jo_crr_cd.value = comboObjects[2].Code;
		formObj.acct_cd.value = comboObjects[3].Code;
		formObj.estm_vvd_tp_cd.value = comboObjects[4].Code;
  } 
      
/* 개발자 작업  끝 */