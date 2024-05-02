/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : FNS_JOO_0095.js
 *@FileTitle : Basic Information for Loading Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.23
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2010.12.23 박희동
 * 1.0 Creation
* -------------------------------------------------------
* 2012.04.05 조병연[CHM-201217059-01]
* Title : [ALPS JOO] Estimate VVD Code Check - Current Estimate Cost 0 조회 기능 추가
* 내용 :
* 1. BSA adjustment 칼럼 추가  :
* 기존 통합선복사용실적조회 화면에 있던 BSA adjustment 기능을 Basic Info 화면으로 옮겨, 
* 해당 Lane, Carrier에 일괄적으로 적용 (TEU, WT 분리하여 적용)
* 2. Add Carriers 수정 : 
* Main에서 Lane, Rep. Carrier를 신규로 생성했을 때, Add Carriers로 자동으로 저장되도록 수정
* 3. Bay plan table에서 같은 포트가 2개 이상일 경우, 가장 늦은 ETD에 해당하는 plan의 data를 적용 수정 : 
* 테스트 서버 적용된 사항 미반영 상태. 
* 모든 레인에서 같은 포트가 두 개 이상이라면 마지막에 CALLING 한 포트를 기준으로 해야 함 
* (ALX, BRSSZ & ALW, MXZLO)
* EX. ALX/ HJAA0014E : ETD 2011-10-15 data (현재 ETD 2011-10-03 data 임)
* 4. RF sub alloc 수정 : 
* Basic Info에 입력된 RF sub alloc 을 반영하여, sub alloc 보다 loading 개수가 
* 적은 경우 “0”으로 표기되도록 쿼리 수정
* 
* 
Date : 2012.07.24.
Ticket ID : SRM-201227013
Title :[ALPS JOO] TDR Inquiry by VVD - Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가
개발자 : 전상화
Description
   1. Lane 조회 조건 수정 (PopUp -> Select Box)로 수정하면서 추가 사항(select Key 추가)을 반영


* =========================================================*/
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
 * @class FNS_JOO_0095 : FNS_JOO_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0095() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix = "sheet1_";
var gRow = "";

var gTrdLaneCrrArr; //0 : Trade, 1 : Lane, 2 : Carrier

var atchRow = "";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
     	case "btns_calendar1": //달력버튼
     		var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObj.fm_prd1, 'yyyy-MM');           	 
			break;
     	case "btns_calendar2": //달력버튼
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObj.to_prd2, 'yyyy-MM');  
		 	break; 
		case "btns_copy":
			UF_copyRow();
			break;

		case "btns_add":
			UF_addRow();
			break;

		case "btns_insert":
			UF_addRow();
			break;
			
		case "btns_del":
			JooRowHideDelete(sheetObj, prefix+"del_chk");
			break;
			
		case "btn_retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_new":
			UF_reset();
			break;

		case "btn_downexcel":
/*			var paramObj = new Object();
			var url = ComJooGetPgmTitle(sheetObj, paramObj);
			sheetObj.SpeedDown2Excel(-1, false, false, "", url,false,false,"",false,"","","","",true);
			break;*/
			
			var paramObj = new Object();
			var url = ComJooGetPgmTitle(sheetObj, paramObj);
//			alert(url);
        	if ( sheetObj.rowCount != 0 ) {
      	  		sheetObj.Down2Excel(-1, false, false, true,"",url,false,false,"",false,"1");
        	} else {
        		ComShowCodeMessage('JOO00143');	//No data found
        		return; 
        	}
      	  	break;

		case "btn_save":
			doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;
			
		case "btn_pop_ofc_cd":
			ComOpenPopup("/hanjin/COM_ENS_071.do", 750, 470, "ofc_cd_pop_event", "1,0,1", true);
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	var arr1d = gTrdLaneCrr.split("|");
	gTrdLaneCrrArr = arr1d;
	for (var i=0; i< arr1d.length; i++){
		var arr2d = arr1d[i];
		gTrdLaneCrrArr[i] = arr2d.split(",");
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
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'obj_keyup'     ,  formObj);
    axon_event.addListenerFormat('click'           , 'obj_onclick'   , 	formObj);

    axon_event.addListener('beforedeactivate'	   , 'ofc_cd_onblur'    , 'ofc_cd');
    axon_event.addListener('keypress'			   , 'ofc_cd_keypress' 	, 'ofc_cd');
    axon_event.addListener('keyup'   			   , 'ofc_cd_keyup'    	, 'ofc_cd');
}

//function obj_keypress() {
//	alert("zz");
//	var obj = event.srcElement;
//    switch(obj.name){
//	    case "ofc_cd":
//	    	alert("1");
//	        ComKeyOnlyAlphabet('upper');
//	    break;
//	}
//}

function obj_keyup() {
	ComKeyEnter('lengthnextfocus');
//	alert("obj_keyup");
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
//	alert("obj_deactivate");
	var bReturn;
	bReturn = ComChkObjValid(event.srcElement);
	if (!bReturn){
		event.srcElement.value  = "";
		//document.form.trd_cd.focus();
		event.srcElement.focus();
	}
}

function obj_activate() {
//	alert("obj_activate");
	ComClearSeparator(event.srcElement);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 420;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle  = "|Sel|Office|Related\nOffice|Kind|Rev/Exp|Carrier|YYYY/MM|Week|Trade|Lane|VSL|VOY|DIR|VVD|BSA|Price|Amount|Remark|Settlement|Settlement|Settlement|Settlement|Settlement|Attached|Attatched|Delete|Seq";
			var HeadTitle2  = "||Office|Related\nOffice|Kind|Rev/Exp|Carrier|YYYY/MM|Week|Trade|Lane|VSL|VOY|DIR|VVD|BSA|Price|Amount|Remark|VSL|VOY|DIR|VVD|Date|Attached|Attatched|Delete|Seq";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, false, true, false)
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 80, daCenter, true, prefix + "ibflag" );
			InitDataProperty(0, cnt++, dtCheckBox    , 30, daCenter, true, prefix + "del_chk");
			
			InitDataProperty(0, cnt++, dtData   	 , 70, daCenter, true, prefix + "ofc_cd"              		, false, "", dfNone        , 0, false, false ,6);
			InitDataProperty(0, cnt++, dtCombo   	 , 70, daCenter, true, prefix + "agmt_ofc_cd"              	, false, "", dfNone        , 0, true , true  ,6);

			InitDataProperty(0, cnt++, dtCombo   	 , 80, daCenter, true, prefix + "jo_cmpn_knd_cd"            , false, "", dfNone        , 0, true , true );			
			InitDataProperty(0, cnt++, dtCombo       , 70, daCenter, true, prefix + "re_divr_cd"          		, true , "", dfNone        , 0, false, true );		//
			
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true, prefix + "jo_crr_cd"           		, true , "", dfNone        , 0, false, true );		//
			InitDataProperty(0, cnt++, dtData        , 70, daCenter, true, prefix + "cmpn_agmt_yrmon"           , false, "", dfDateYm  	   , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 70, daCenter, true, prefix + "cmpn_agmt_yrwk"            , false, "", dfUserFormat  , 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true, prefix + "trd_cd"            		, true , "", dfNone        , 0, false, true );		//
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true, prefix + "rlane_cd"            		, true , "", dfNone        , 0, false, true );		//

			InitDataProperty(0, cnt++, dtHidden      , 50, daCenter, true, prefix + "vsl_cd"            		, false, "", dfNone        , 0, true , true );
			InitDataProperty(0, cnt++, dtHidden      , 50, daCenter, true, prefix + "skd_voy_no"            	, false, "", dfNone        , 0, true , true );
			InitDataProperty(0, cnt++, dtHidden      , 50, daCenter, true, prefix + "skd_dir_cd"            	, false, "", dfNone        , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 80, daCenter, true, prefix + "vvd_cd"            		, false, "", dfNone        , 0, true , true, 9 );
			
			InitDataProperty(0, cnt++, dtData        , 80, daRight  , true, prefix + "bsa_qty"            		, false, "", dfNullInteger , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 80, daRight  , true, prefix + "bsa_slt_prc"            	, false, "", dfNullFloat   , 2, true , true );
			
			InitDataProperty(0, cnt++, dtData        , 80, daRight  , true, prefix + "bsa_amount"            	, false, "|15|*|16|",  dfNullFloat       , 2, false, false );

			InitDataProperty(0, cnt++, dtData        , 100, daLeft  , true, prefix + "cmpn_agmt_rmk"            , false, "", dfNone        , 0, true , true );

			InitDataProperty(0, cnt++, dtHidden      , 50, daCenter, true, prefix + "stl_vsl_cd"            	, false, "", dfNone        , 0, true , true );
			InitDataProperty(0, cnt++, dtHidden      , 50, daCenter, true, prefix + "stl_voy_no"            	, false, "", dfNone        , 0, true , true );
			InitDataProperty(0, cnt++, dtHidden      , 50, daCenter, true, prefix + "stl_dir_cd"            	, false, "", dfNone        , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 80, daCenter, true, prefix + "stl_vvd_cd"            	, false, "", dfNone        , 0, true , true, 9 );
			InitDataProperty(0, cnt++, dtData        , 80, daCenter, true, prefix + "stl_dt"            		, false, "", dfDateYmd     , 0, true , true );
 
			InitDataProperty(0, cnt++, dtPopup       , 70, daCenter, true, prefix + "atch_file_flag"            , false, "", dfNone        , 0, true , true , 200);
			InitDataProperty(0, cnt++, dtHidden      , 50, daCenter, true, prefix + "atch_file_id"            	, false, "", dfNone        , 0, false , false );
			InitDataProperty(0, cnt++, dtCombo       , 70, daCenter, true, prefix + "delt_flg"            		, false, "", dfNone        , 0, false , false );
			InitDataProperty(0, cnt++, dtHidden      , 50, daCenter, true, prefix + "cmpn_agmt_seq"            	, false, "", dfNone        , 0, true , false );

			ImageList(0) = "/hanjin/img/button/btns_calendar.gif";
			
			// Settled, Rev/Exp, Delete : list 하드코딩
			InitDataCombo(0, prefix+"re_divr_cd" 	 , " |Rev|Exp", " |R|E");
			InitDataCombo(0, prefix+"delt_flg"   	 , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"agmt_ofc_cd"    , " |SELADG|SELCTS|SELCTY|SELCOV", " |SELADG|SELCTS|SELCTY|SELCOV");
			
			initDataComboSetting (sheetObj, "jo_crr_cd" 	 , gCrrCd.split("|"));
			initDataComboSetting (sheetObj, "trd_cd" 		 , gTrdCd.split("|"));
			//initDataComboSetting (sheetObj, "rlane_cd" 		 , gTrdLaneCrr.split("|"));
			initDataComboSetting (sheetObj, "jo_cmpn_knd_cd" , gKndCd.split("|"));

//			InitDataCombo(0, prefix+"ofc_cd"      , ofcName  , ofcCode);*/
//			InitDataCombo(0, prefix+"trd_cd"      , trdName  , trdCode);*/
						//InitDataCombo(0, prefix+"jo_src_cd"   , gJoSrcNm  , gJoSrcCd);
			//InitDataCombo(0, prefix+"jo_bkg_tp_cd", gJoBkgTpNm, gJoBkgTpCd);
			//InitDataValid(0, prefix+"ofc_cd"   , vtEngUpOnly); //영문대문자
			
//			InitUserFormat(0, prefix+"cmpn_agmt_yrmon" , "####-##", "-");
			InitUserFormat(0, prefix+"cmpn_agmt_yrwk" , "####-##", "-");
//			InitUserFormat(0, prefix+"STL_DT" ,	"####-##-##", "-");
//			InitUserFormat2(0, prefix+"cre_dt" , "####-##-## ##:##:##", "-|:");
//			InitUserFormat2(0, prefix+"upd_dt" , "####-##-## ##:##:##", "-|:");

			InitComboNoMatchText(true);
			ComboOpenMode = true; //한번 클릭으로 펼쳐짐
			
			InitDataValid(0, prefix + "vvd_cd"    	 , vtEngUpOther, "0123456789");//영문대문자+숫자
			InitDataValid(0, prefix + "stl_vvd_cd"   , vtEngUpOther, "0123456789");//영문대문자+숫자
			
//            InitDataValid(0, "leg_fport", vtEngUpOnly);    			// 영대문자만
//            InitDataValid(0, "leg_tport", vtEngUpOnly);    			// 영대문자만
		}
		break;

	}
}

function initDataComboSetting(sheetObj, saveName, dataList) {
	var trdList = dataList
	var trdSheet = "";
	var trdName = "";
	var trdCode = "";

	for (var i=0; i<trdList.length; i++){
		trdSheet = trdList[i].split(",");
		for (var j=0; j<trdSheet.length; j++){
			if ( i == 0) {
				if (j == 0){
					trdName = " |" + trdSheet[j]; 
				}else{
					trdCode = " |" + trdSheet[j];
				}	
			} else {
				if (j == 0){
					trdName = trdName + "|" + trdSheet[j]; 
				}else{
					trdCode = trdCode + "|" + trdSheet[j];
				}						
			}
		}
	}

//	alert("saveName : " + saveName);
	sheetObj.InitDataCombo(0, prefix+saveName      , trdName  , trdCode);
}


//Pop-up창에서 Close시 호출한다.
function parentSearch() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction)){
		return;
	}
	switch (sAction) {

	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("FNS_JOO_0095GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		sheetObj.LoadSearchXml(sXml,false);
		break;

	case IBSAVE: //저장
		formObj.f_cmd.value = MULTI;

		var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
		if (SaveStr == ""){
			ComShowCodeMessage("JOO00036");
			return false;			
		}
		
		if (!ComShowCodeConfirm("JOO00046")){
			return false;
		}
		
/*		for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
		{
			var joSrcCd =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_src_cd")," ");
			if(joSrcCd == "R" || joSrcCd == "T")
			{
				//sheetObj.cellValue(Row,prefix+"jo_bkg_tp_cd") = "";
			}
		}*/
//		alert(SaveStr + "&" + FormQueryString(formObj));
//		alert( ComGetPrefixParam(prefix))
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSaveXml("FNS_JOO_0095GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		if (ComGetEtcData(sXml,"RTNVAL") == "N"){
			sheetObj.LoadSaveXml(sXml);		
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else{
			ComShowMessage(ComGetEtcData(sXml,"RTNVAL"));
		}
		break;
// 2012.05.31 사용자 요청으로 삭제
	case IBROWSEARCH: //조회
		formObj.f_cmd.value = SEARCH01;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("FNS_JOO_0095GS.do", FormQueryString(formObj));
		var refNoList = ComGetEtcData(sXml,"REF_NO_COMBO");
		comboObjects[0].RemoveAll();		
		var comboItems = ("ALL, |"+refNoList).split("|");
		UF_addComboItem(comboObjects[0], comboItems);  		
		break;
		
	case IBSEARCH_ASYNC01: //VVD Validation Check
		formObj.f_cmd.value = SEARCH26;
		sheetObj.WaitImageVisible = false;
		var vvd = sheetObj.CellValue(gRow, prefix+"vvd_cd");

		sheetObj.CellValue2(gRow, prefix+"vsl_cd") = vvd.substr(0,4);
		sheetObj.CellValue2(gRow, prefix+"skd_voy_no") = vvd.substr(4,4);
		sheetObj.CellValue2(gRow, prefix+"skd_dir_cd") = vvd.substr(8,1);
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", "f_cmd=" + formObj.f_cmd.value
												+"&super_cd1="+sheetObj.CellValue(gRow, prefix+"vsl_cd")
												+"&super_cd2="+sheetObj.CellValue(gRow, prefix+"skd_voy_no")
												+"&super_cd3="+sheetObj.CellValue(gRow, prefix+"skd_dir_cd"));
		
//		alert("kkk1 : " + sheetObj.CellValue(gRow, prefix+"trd_cd"));
//		alert("kkk2 : " + sheetObj.CellText(gRow, prefix+"rlane_cd"));
		
		if (ComGetEtcData(sXml,"RESULT") == "E"){
			ComShowCodeMessage("JOO00031");
			sheetObj.CellValue2(gRow, prefix+"vvd_cd") = "";
			sheetObj.CellValue2(gRow, prefix+"vsl_cd") = "";
			sheetObj.CellValue2(gRow, prefix+"skd_voy_no") = "";
			sheetObj.CellValue2(gRow, prefix+"skd_dir_cd") = "";
			sheetObj.SelectCell(gRow, prefix+"vvd_cd");
		}
		break;
		
	case IBSEARCH_ASYNC02: //Settlement Validation Check
		formObj.f_cmd.value = SEARCH26;
		sheetObj.WaitImageVisible = false;
		var vvd2 = sheetObj.CellValue(gRow, prefix+"stl_vvd_cd");

		sheetObj.CellValue2(gRow, prefix+"stl_vsl_cd") = vvd2.substr(0,4);
		sheetObj.CellValue2(gRow, prefix+"stl_voy_no") = vvd2.substr(4,4);
		sheetObj.CellValue2(gRow, prefix+"stl_dir_cd") = vvd2.substr(8,1);
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", "f_cmd=" + formObj.f_cmd.value
				+"&super_cd1="+sheetObj.CellValue(gRow, prefix+"stl_vsl_cd")
				+"&super_cd2="+sheetObj.CellValue(gRow, prefix+"stl_voy_no")
				+"&super_cd3="+sheetObj.CellValue(gRow, prefix+"stl_dir_cd"));
		
		if (ComGetEtcData(sXml,"RESULT") == "E"){
			ComShowCodeMessage("JOO00031");
			sheetObj.CellValue2(gRow, prefix+"stl_vvd_cd") = "";
			sheetObj.CellValue2(gRow, prefix+"stl_vsl_cd") = "";
			sheetObj.CellValue2(gRow, prefix+"stl_voy_no") = "";
			sheetObj.CellValue2(gRow, prefix+"stl_dir_cd") = "";
			sheetObj.SelectCell(gRow, prefix+"stl_vvd_cd");
		}
		break;

	case IBSEARCH_ASYNC03: //IBSheet상의 Trade Code변경시 Revenue Lane Setting
		formObj.f_cmd.value = SEARCH16;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1=&super_cd2="+sheetObj.CellValue(gRow, prefix+"trd_cd"));
		var rlaneCdList = ComGetEtcData(sXml,"rlane_combo_sheet");
		sheetObj.InitCellProperty(gRow, prefix+"rlane_cd", dtCombo);
        sheetObj.CellComboItem(gRow, prefix+"rlane_cd" , rlaneCdList, rlaneCdList);
		sheetObj.CellValue2(gRow, prefix+"rlane_cd") = "";
//		sheetObj.CellValue2(gRow, prefix+"jo_crr_cd") = "";
		break;

//	case IBSEARCH_ASYNC04: 
//		sheetObj.WaitImageVisible = false;
//		var sXml = sheetObj.GetSearchXml("FNS_JOO_0095GS.do", "f_cmd=102"
//				+"&ofc_cd="+sheetObj.CellValue(gRow, prefix+"ofc_cd")
//				+"&re_divr_cd="+sheetObj.CellValue(gRow, prefix+"re_divr_cd")
//				+"&trd_cd="+sheetObj.CellValue(gRow, prefix+"trd_cd")
//				+"&rlane_cd="+sheetObj.CellValue(gRow, prefix+"rlane_cd"));
//
//		var code = ComGetEtcData(sXml,"CODE");
//		var text = ComGetEtcData(sXml,"TEXT");
//		var comboList = text.split("|");
//
//		if (sheetObj.RowStatus(gRow) == "I"){
//			sheetObj.CellValue2(gRow, prefix+"jo_ref_no"  ) = "";
//			sheetObj.CellValue2(gRow, prefix+"agmt_eff_dt") = "";
//			sheetObj.CellValue2(gRow, prefix+"agmt_exp_dt") = "";
//		}
//
//		//기존 같은 Data가 없으면 수기 입력 가능
//		if (code == "" || comboList.length == 0){
//			sheetObj.InitCellProperty(gRow, prefix+"jo_ref_no", dtData);
//			sheetObj.CellEditable(gRow, prefix+"jo_ref_no") = false;
//		}else if (comboList.length >= 1){
//			if (ComShowCodeConfirm("JOO00188",comboList.length)){
//				sheetObj.InitCellProperty(gRow, prefix+"jo_ref_no", dtData);
//				sheetObj.CellEditable (gRow, prefix+"jo_ref_no"  ) = false;
//				sheetObj.CellEditable (gRow, prefix+"agmt_eff_dt") = true;
//				sheetObj.CellEditable (gRow, prefix+"agmt_exp_dt") = true;
//		        sheetObj.SelectCell(gRow, prefix+"rlane_cd");
//			}else{
//				sheetObj.InitCellProperty(gRow, prefix+"jo_ref_no", dtCombo);
//				sheetObj.CellEditable (gRow, prefix+"jo_ref_no"  ) = true;
//				sheetObj.CellEditable (gRow, prefix+"agmt_eff_dt") = false;
//				sheetObj.CellEditable (gRow, prefix+"agmt_exp_dt") = false;
//		        sheetObj.CellComboItem(gRow, prefix+"jo_ref_no" , text, code);
//				sheetObj.CellValue2(gRow, prefix+"jo_ref_no"  ) = "";
//				sheetObj.CellValue2(gRow, prefix+"agmt_eff_dt") = "";
//				sheetObj.CellValue2(gRow, prefix+"agmt_exp_dt") = "";
//		        sheetObj.SelectCell(gRow, prefix+"del_chk");
//			}
//		}
//
//		break;
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */
function initCombo(comboObj, comboNo) {
	var formObj = document.form;

	switch (comboObj.id) {
	case "jo_crr_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = ("ALL, |"+gCrrCd).split("|");
		UF_addComboItem(comboObj, comboItems);
		comboObj.Text2 = "ALL";
		break;

	case "trd_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = ("ALL, |"+gTrdCd).split("|");
		UF_addComboItem(comboObj, comboItems);
		comboObj.Text2 = "ALL";
		
		break;
		
	case "jo_cmpn_knd_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = ("ALL, |"+gKndCd).split("|");
		UF_addComboItem(comboObj, comboItems);
		comboObj.Text2 = "ALL";
		
		break;

	case "rlane_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("50");
			DropHeight = 160;
			ValidChar(2, 1);//영문대문자+숫자만 입력가능
			MaxLength = 5;
		}
			
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCH16;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1="+formObj.jo_crr_cd.Code);
	    ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code");
	    comboObj.InsertItem(0, "ALL", " ");
	    comboObj.Index2 = 0;
		
		break;
		
/*	case "rlane_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("50");
			DropHeight = 160;
			ValidChar(2, 1);//영문대문자+숫자만 입력가능
			MaxLength = 5;
		}
			
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCH16;
		sheetObj.WaitImageVisible = false;
		//alert("before");
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1="+formObj.jo_crr_cd.Code);
       // alert ("after");
		ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code");
        comboObj.InsertItem(0, "ALL", " ");
        comboObj.Index2 = 0;
		
		break;*/
		
	case "sttl_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 200;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = "ALL, |Y,Y|N,N";
		UF_addComboItem(comboObj, comboItems.split("|"));
		comboObj.text2 = "ALL";
		
		break;
		
	case "delt_flg":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 200;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = "ALL, |Y,Y|N,N";
		UF_addComboItem(comboObj, comboItems.split("|"));
		comboObj.text2 = "N"; 
		
		break;	
	case "re_divr_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 7;
		}
		var comboItems = "ALL, |Revenue,R|Expense,E";
		UF_addComboItem(comboObj, comboItems.split("|"));
		comboObj.Text2 = "ALL";
		break;
	}
}

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			if (sComboObj.id == "trd_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
				formObj.f_cmd.value = SEARCH15;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+formObj.jo_crr_cd.Code+"&super_cd2=");
                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
				sComboObj.InsertItem(0, "ALL", " ");
				sComboObj.Index2 = 0;
    	   }else if (sComboObj.id == "rlane_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH16;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1=");
				var comboItems = ("ALL, |"+ComGetEtcData(sXml, "rlane_cd")).split("|");
				addComboItem(comboObjects[2],comboItems);
				sComboObj.Index2 = 0;
			}
														
	        break;
    }
}

/* 2012.05.31 사용자 요청으로 삭제
function jo_ref_no_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}

function jo_ref_no_OnFocus(comboObj) {
//	if (comboObj.GetCount() == 1){
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
		comboObj.Enable = true;
//	}
}
*/

/**
 * Popup Data Validation Check. <br>
 **/
function ofc_cd_pop_event(aryPopupData) {
	document.form.ofc_cd.value = aryPopupData[0][3];
	sheetObjects[0].RemoveAll();
}

function re_divr_cd_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}

function jo_crr_cd_OnChange(comboObj, code, text){
	sheetObjects[0].RemoveAll();

	//comboObjects[3].RemoveAll();
	//comboObjects[3].InsertItem(0, "ALL", " ");
	//comboObjects[3].Text2 = "ALL";

	//comboObjects[4].RemoveAll();
	//comboObjects[4].InsertItem(0, "ALL", " ");
	//comboObjects[4].Text2 = "ALL";
}

//TRADE 변경시 LANE 변경
function trd_cd_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
	
	var formObj = document.form;

	formObj.rlane_cd.Index2 = -1;
	formObj.rlane_cd.RemoveAll();
	doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObjects[2] ,"rlane_cd");
	formObj.trd_cd.focus();
}
/*
function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	if (comboObj.GetCount() == 0) {
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObj ,"rlane_cd");
		comboObj.Enable = true;
	}
}
*/
function rlane_cd_OnChange(comboObj, code, text){
	sheetObjects[0].RemoveAll();
}

function re_divr_cd_OnChange(comboObj, code, text){
	sheetObjects[0].RemoveAll();
}

function sttl_cd_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}

function jo_cmpn_knd_cd_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}
function delt_flg_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			break;
			
		case IBSAVE:
			for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
				var rowStatus = sheetObj.RowStatus(i);
				
				if (rowStatus == "R" || rowStatus == "D")
					continue;
				
				if (sheetObj.CellValue(i, prefix+"re_divr_cd").length < 1){
					ComShowCodeMessage("JOO00184");
					sheetObj.SelectCell(i, prefix+"re_divr_cd");
					return false;
				}

				if (sheetObj.CellValue(i, prefix+"trd_cd").length < 3){
					ComShowCodeMessage("JOO00009");
					sheetObj.SelectCell(i, prefix+"trd_cd");
					return false;
				}

				if (sheetObj.CellValue(i, prefix+"rlane_cd").length < 5){
					alert("1-3")
					ComShowCodeMessage("JOO00010");
					sheetObj.SelectCell(i, prefix+"rlane_cd");
					return false;
				}
				
//				//2012.06.01
//				if (sheetObj.CellValue(i, prefix+"skd_dir_cd").length < 1) {
//					ComShowCodeMessage("JOO00190");
//					sheetObj.SelectCell(i, prefix+"skd_dir_cd");
//					return false;					
//				}

				if (sheetObj.CellValue(i, prefix+"jo_crr_cd") < 3){
					ComShowCodeMessage("JOO00008");
					sheetObj.SelectCell(i, prefix+"jo_crr_cd");
					return false;
				}

				if ( ComTrim(sheetObj.CellValue(i, prefix+"stl_vvd_cd")) == "" &&  ComTrim(sheetObj.CellValue(i, prefix+"stl_dt")) != "" ){
					ComShowCodeMessage("JOO00116","Settlement VVD");
					sheetObj.SelectCell(i, prefix+"stl_vvd_cd");
					return false;
				}
				
				if ( ComTrim(sheetObj.CellValue(i, prefix+"stl_vvd_cd")) != "" &&  ComTrim(sheetObj.CellValue(i, prefix+"stl_dt")) == "" ){
					ComShowCodeMessage("JOO00116","Settlement Date");
					sheetObj.SelectCell(i, prefix+"stl_dt");
					return false;
				}


//				if (sheetObj.CellValue(i, prefix+"jo_src_cd") == "B"){
//					if (sheetObj.CellValue(i, prefix+"jo_bkg_tp_cd").length < 1){
//						ComShowCodeMessage("JOO00186");
//						sheetObj.SelectCell(i, prefix+"jo_bkg_tp_cd");
//						return false;
//					}
//				}
//				if (sheetObj.CellValue(i, prefix+"agmt_eff_dt").length < 8){
//					ComShowCodeMessage("JOO00187", "Fm Date");
//					sheetObj.SelectCell(i, prefix+"agmt_eff_dt");
//					return false;
//				}
//				if (sheetObj.CellValue(i, prefix+"agmt_exp_dt").length < 8){
//					ComShowCodeMessage("JOO00187", "To Date");
//					sheetObj.SelectCell(i, prefix+"agmt_exp_dt");
//					return false;
//				}
//				if (Number(sheetObj.CellValue(i, prefix+"agmt_eff_dt").replace(/-/g,"")) > Number(sheetObj.CellValue(i, prefix+"agmt_exp_dt").replace(/-/g,""))){
//					ComShowCodeMessage("JOO00078");
//					sheetObj.SelectCell(i, prefix+"agmt_exp_dt");
//					return false;
//				}
			}
			break;
		}
	}

	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (sheetObj.RowCount == 0){
		return;
	}
	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){		
		
		var joCrrCd = sheetObj.CellValue(i, prefix+"jo_crr_cd");
		var deltFlg = sheetObj.CellValue(i, prefix+"delt_flg");		
		var trd   = sheetObj.CellValue(i, prefix+"trd_cd");
		var rlane = sheetObj.CellValue(i, prefix+"rlane_cd");
		var crrList = "";
		
		if (deltFlg == "Y"){
			sheetObj.RowEditable(i) = false;
		}else{
			sheetObj.RowEditable(i) = true;
		}

		for(var k=0; k<gTrdLaneCrrArr.length; k++){
			if (trd == gTrdLaneCrrArr[k][0] && rlane == gTrdLaneCrrArr[k][1]){
				if (k==0){
					crrList = gTrdLaneCrrArr[k][2];
				}else{
					crrList = crrList+"|"+gTrdLaneCrrArr[k][2];
				}
			}
		}
		sheetObj.InitCellProperty(i, prefix+"jo_crr_cd", dtCombo);
        sheetObj.CellComboItem(i, prefix+"jo_crr_cd" , crrList, crrList);
        sheetObj.CellValue2(i, prefix+"jo_crr_cd") = joCrrCd;
	}	// end for
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
	var sName = sheetObj.ColSaveName(Col);
	var Value = sheetObj.EditValue;
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	gRow = Row;
	var formObj = document.form;
    switch (sheetObj.ColSaveName(Col)) {
		case prefix+"trd_cd":
			if (sheetObj.RowStatus(Row) == "I" || sheetObj.RowStatus(Row) == "U"){
				if (Value == ""){
					ComShowCodeMessage("JOO00009");
					sheetObj.SelectCell(Row, Col);
					return;
				}
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			}
			break;
		case prefix+"re_divr_cd":
/*			var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
			if (reDivrCd == "E") {
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "HJS";
				sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = false;
			} else {
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "";
				sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
			}*/
			
			break;
		case prefix+"rlane_cd":
			if (sheetObj.RowStatus(Row) == "I" || sheetObj.RowStatus(Row) == "U"){
				if (sheetObj.CellValue(Row, prefix+"trd_cd") == ""){
					ComShowCodeMessage("JOO00009");
					sheetObj.SelectCell(Row, prefix+"trd_cd");
					return;
				}
				if (Value == ""){
					ComShowCodeMessage("JOO00010");
					sheetObj.SelectCell(Row, Col);
					return;
				}
				
//				var trd   = sheetObj.CellValue(Row, prefix+"trd_cd");
//				var rlane = sheetObj.CellValue(Row, prefix+"rlane_cd");
//				var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
//				
//				var crrList = "";
//				
//				if (reDivrCd == "R") {
//					
//				for(var k=0; k<gTrdLaneCrrArr.length; k++){
//					if (trd == gTrdLaneCrrArr[k][0] && rlane == gTrdLaneCrrArr[k][1]){
//						if (k==0){
//							crrList = gTrdLaneCrrArr[k][2];
//						}else{
//							crrList = crrList+"|"+gTrdLaneCrrArr[k][2];
//						}
//					}
//				}
//					sheetObj.InitCellProperty(Row, prefix+"jo_crr_cd", dtCombo);
//			        sheetObj.CellComboItem(Row, prefix+"jo_crr_cd" , crrList, crrList);
//			        sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "";
//					sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
//				} else {
//					sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "HJS";
//					sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = false;
//				}
				
				
		        
//		        var findSameRefNo = false;
//		        for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
//		        	if (i == Row || sheetObj.CellValue(i, prefix+"delt_flg") == "Y" || sheetObj.RowStatus(i) == "D") continue;
//		        	//같으면 날짜도 같고 수정 불가
//		        	if (sheetObj.CellValue(i, prefix+"ofc_cd"    ) == sheetObj.CellValue(Row, prefix+"ofc_cd"    )
//		        	&&  sheetObj.CellValue(i, prefix+"re_divr_cd") == sheetObj.CellValue(Row, prefix+"re_divr_cd")
//		        	&&  sheetObj.CellValue(i, prefix+"trd_cd"    ) == sheetObj.CellValue(Row, prefix+"trd_cd"    )
//		        	&&  sheetObj.CellValue(i, prefix+"rlane_cd"  ) == sheetObj.CellValue(Row, prefix+"rlane_cd"  )){
//		        		
//		        		sheetObj.CellValue2(Row, prefix+"agmt_eff_dt") = sheetObj.CellValue(i, prefix+"agmt_eff_dt"); 
//		        		sheetObj.CellValue2(Row, prefix+"agmt_exp_dt") = sheetObj.CellValue(i, prefix+"agmt_exp_dt");
//		        		sheetObj.CellEditable(Row, prefix+"agmt_eff_dt") = false;
//		        		sheetObj.CellEditable(Row, prefix+"agmt_exp_dt") = false;
//		        		findSameRefNo = true;
//		        		break;
//		        	}
//		        }
		        
//		        	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
			}
			break;

		case prefix+"vvd_cd":
			var arrText = ComTrim(sheetObj.CellValue(Row, prefix+"vvd_cd"));
			//VVD Length : 9
			if (arrText.length != 9 && arrText.length != 0){
				ComShowCodeMessage("JOO00210","VVD","9");
				sheetObj.CellValue2(gRow, prefix+"vvd_cd") = "";
				sheetObj.CellValue2(gRow, prefix+"vsl_cd") = "";
				sheetObj.CellValue2(gRow, prefix+"skd_voy_no") = "";
				sheetObj.CellValue2(gRow, prefix+"skd_dir_cd") = "";
				sheetObj.SelectCell(Row, prefix+"vvd_cd");
				return;
			} else {
				sheetObj.CellValue2(gRow, prefix+"vsl_cd") = arrText.substr(0,4); 
				sheetObj.CellValue2(gRow, prefix+"skd_voy_no") = arrText.substr(4,4); 
				sheetObj.CellValue2(gRow, prefix+"skd_dir_cd") = arrText.substr(8); 
			}
//			// VVD : ar_mst_rev_vvd 에 값이 존재해야 한다.
//			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
			break;
		
		case prefix+"stl_vvd_cd":
			var arrText = ComTrim(sheetObj.CellValue(Row, prefix+"stl_vvd_cd"));
			//VVD Length : 9
			if (arrText.length != 9 && arrText.length != 0){
				ComShowCodeMessage("JOO00210","Settlement VVD","9");
				sheetObj.CellValue2(gRow, prefix+"stl_vvd_cd") = "";
				sheetObj.CellValue2(gRow, prefix+"stl_vsl_cd") = "";
				sheetObj.CellValue2(gRow, prefix+"stl_voy_no") = "";
				sheetObj.CellValue2(gRow, prefix+"stl_dir_cd") = "";
				sheetObj.SelectCell(Row, prefix+"stl_vvd_cd");
				return;
			} else {
				sheetObj.CellValue2(gRow, prefix+"stl_vsl_cd") = arrText.substr(0,4);
				sheetObj.CellValue2(gRow, prefix+"stl_voy_no") = arrText.substr(4,4);
				sheetObj.CellValue2(gRow, prefix+"stl_dir_cd") = arrText.substr(8);
			}
			// Sttlement VVD : ar_mst_rev_vvd 에 값이 존재해야 한다.
			if (arrText.length != 0){
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
			}
			break;
			
		case prefix+"atch_file_id":
			
			var arrText = sheetObj.CellValue(Row, prefix+"stl_vvd_cd");
			
			if (arrText.length > 0 ){
				sheetObj.CellValue2(Row, prefix+"atch_file_flag") = "Y";
			} else{
				sheetObj.CellValue2(Row, prefix+"atch_file_flag") = "N";
			}
			break;
			
		case prefix+"re_divr_cd":
	        var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
	        
	        var cdList = "";
	        var nmList = "";
	        
	        for (var j=0; j<gJoSrcCd.length; j++){
	        	if (reDivrCd == "E"){
	        		if (gJoSrcCd[j] == "B"){
		        		if (j==0){
		        			cdList = gJoSrcCd[j];
		        			nmList = gJoSrcNm[j];
		        		}else{
		        			cdList = cdList+"|"+gJoSrcCd[j];
		        			nmList = nmList+"|"+gJoSrcNm[j];
		        		}
	        		}
	        	}else if (reDivrCd == "R"){
	        		if (gJoSrcCd[j] != "B"){
		        		if (j==0){
		        			cdList = gJoSrcCd[j];
		        			nmList = gJoSrcNm[j];
		        		}else{
		        			cdList = cdList+"|"+gJoSrcCd[j];
		        			nmList = nmList+"|"+gJoSrcNm[j];
		        		}
	        		}
	        	}
	        }
			//sheetObj.InitCellProperty(Row, prefix+"jo_src_cd", dtCombo);
	        //sheetObj.CellComboItem(Row, prefix+"jo_src_cd" , nmList, cdList);
			
			break;
			
		case prefix+"jo_src_cd":
	        
			var cdList = "";
	        var nmList = "";

	        if (Value == "B"){
	        	for (var j=0; j<gJoBkgTpCd.length; j++){
	        		if (j==0){
	        			cdList = gJoBkgTpCd[j];
	        			nmList = gJoBkgTpNm[j];
	        		}else{
	        			cdList = cdList+"|"+gJoBkgTpCd[j];
	        			nmList = nmList+"|"+gJoBkgTpNm[j];
	        		}
	        	}
				sheetObj.InitCellProperty(Row, prefix+"jo_bkg_tp_cd", dtCombo);
	            sheetObj.CellComboItem(Row, prefix+"jo_bkg_tp_cd" , nmList, cdList);
				sheetObj.CellEditable(Row, prefix+"jo_bkg_tp_cd") = true;
	        }else{
				sheetObj.InitCellProperty(Row, prefix+"jo_bkg_tp_cd", dtData);
				sheetObj.CellEditable(Row, prefix+"jo_bkg_tp_cd") = false;
	        }
			
			var cdList = "";
	        var nmList = "";

	        if (Value == "T" || Value == "R"){
				for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
					sheetObj.cellValue(Row,prefix+"jo_bkg_tp_cd") = "";
				}
				sheetObj.CellEditable(Row, prefix+"jo_bkg_tp_cd") = false;
	        }else{for (var j=0; j<gJoBkgTpCd.length; j++){
	        		if (j==0){
	        			cdList = gJoBkgTpCd[j];
	        			nmList = gJoBkgTpNm[j];
	        		}else{
	        			cdList = cdList+"|"+gJoBkgTpCd[j];
	        			nmList = nmList+"|"+gJoBkgTpNm[j];
	        		}
	        	}
				sheetObj.InitCellProperty(Row, prefix+"jo_bkg_tp_cd", dtCombo);
	            sheetObj.CellComboItem(Row, prefix+"jo_bkg_tp_cd" , nmList, cdList);
				sheetObj.CellEditable(Row, prefix+"jo_bkg_tp_cd") = true;
	        }			
			break;
    }
}

function sheet1_OnPopupClick(sheetObj, Row, Col){

	var saveName = sheetObj.ColSaveName(Col);
	
	if (saveName == prefix+"atch_file_flag"){
		var saveFileId = sheetObj.CellValue(Row, prefix+"atch_file_id");
/*		alert(Row);
		alert(sheetObj.CellValue(Row, prefix+"jo_crr_cd"));
		alert(sheetObj.CellValue(Row, prefix+"trd_cd"));
		alert(sheetObj.CellValue(Row, prefix+"rlane_cd"));
		alert(sheetObj.CellValue(Row, prefix+"re_divr_cd"));
		alert(sheetObj.CellValue(Row, prefix+"cmpn_agmt_seq"));*/
		var param = "?file_save_id="+saveFileId+
					"&tbl_nm="+"joo_cmpn_agmt"+
					"&col_nm1="+"jo_crr_cd"+
					"&col_val1="+sheetObj.CellValue(Row, prefix+"jo_crr_cd")+
					"&col_nm2="+"trd_cd"+
					"&col_val2="+sheetObj.CellValue(Row, prefix+"trd_cd")+
					"&col_nm3="+"rlane_cd"+
					"&col_val3="+sheetObj.CellValue(Row, prefix+"rlane_cd")+
					"&col_nm4="+"re_divr_cd"+
					"&col_val4="+sheetObj.CellValue(Row, prefix+"re_divr_cd")+
					"&col_nm5="+"cmpn_agmt_seq"+
					"&col_val5="+sheetObj.CellValue(Row, prefix+"cmpn_agmt_seq")+
					"&edit_able="+"Y";
		atchRow = Row;
		ComOpenPopup("/hanjin/FNS_JOO_0097.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
	}
}


function get_Child(arg){
	var sheetObj = sheetObjects[0];
	
	if (arg == ""|| arg == undefined) {
		sheetObj.CellValue2(atchRow, prefix+"atch_file_flag"  ) = "N";
	} else {
		sheetObj.CellValue2(atchRow, prefix+"atch_file_flag"  ) = "Y";
	}
	sheetObj.CellValue2(atchRow, prefix+"atch_file_id") = arg;
}

function ofc_cd_sheet_pop_event(aryPopupData, row, col, sheetIdx){
	sheetObjects[sheetIdx].CellValue(row, col) = aryPopupData[0][3];
}


function ofc_cd_OnChange(comObj, Value, Text) {
	sheetObjects[0].RemoveAll();
}

function UF_copyRow(){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	var arrs = sheetObj.GetSelectionRows(",");
	var rows = arrs.split(",");
	for (var i = rows.length-1; i >= 0; i--){
		sheetObj.SelectCell(rows[i], 7);		
		var row = sheetObj.DataCopy();
		sheetObj.CellValue2(row, prefix+"ibflag"    ) = "I";
		sheetObj.CellValue2(row, prefix+"jo_ref_no" ) = "";
		sheetObj.CellValue2(row, prefix+"jo_ref_seq") = "";
		sheetObj.CellValue2(row, prefix+"delt_flg"  ) = "N";
		sheetObj.CellValue2(row, prefix+"cre_dt"    ) = "";
		sheetObj.CellValue2(row, prefix+"upd_dt"    ) = "";
		sheetObj.CellValue2(row, prefix+"cre_usr_id") = gUsrId;
		sheetObj.CellValue2(row, prefix+"cre_usr_nm") = gUsrNm;
		
		var sCode = sheetObj.GetComboInfo(row, prefix+"rlane_cd", "Code");
		var arrCode = sCode.split("|");
		
		//Copy한 Lane이 Combo가 아니라면 Combo로 만들어 준다.
		if (arrCode.length <= 1){
			var trd = sheetObj.CellValue(row, prefix+"trd_cd");
			
			var laneList = "";
			var lane = "";
			var cnt = 0;
			for(var k=0; k<gTrdLaneCrrArr.length; k++){
				if (trd == gTrdLaneCrrArr[k][0]){
					//TRADE_-LANE-CARRIER를 열거한 거라 lane이 같은게 있을 수 있으므로 중복을 제거한다.
					if (lane != gTrdLaneCrrArr[k][1]){
						lane = gTrdLaneCrrArr[k][1];
						
						if (cnt==0){
							laneList = gTrdLaneCrrArr[k][1];
						}else{
							laneList = laneList+"|"+gTrdLaneCrrArr[k][1];
						}
						cnt++;
					}
				}
			}
			sheetObj.InitCellProperty(row, prefix+"rlane_cd", dtCombo);
	        sheetObj.CellComboItem(row, prefix+"rlane_cd" , laneList, laneList);
		}
		
		if (i==0){
			sheetObj.SelectCell(row, prefix+"ofc_cd");
		}			
	}
}

function UF_addRow(i){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var row;
	
//	if (i == undefined || i == null || i == ""){
//		row = sheetObj.DataInsert();
//	}else{
		row = sheetObj.DataInsert(-1);		
//	}

	sheetObj.CellValue2(row, prefix+"ofc_cd")   		= gOfcCd;		// Login 한 User 의 Office
	sheetObj.CellValue2(row, prefix+"re_divr_cd")   	= "";
	sheetObj.CellValue2(row, prefix+"trd_cd"   )    	= "";
	sheetObj.CellValue2(row, prefix+"jo_crr_flag")  	= "N"; 			//2012.06.01 Add
	sheetObj.CellValue2(row, prefix+"jo_src_cd")    	= "";
	//sheetObj.CellValue2(row, prefix+"jo_bkg_tp_cd") = "";
	sheetObj.CellValue2(row, prefix+"delt_flg")     	= "N";
	sheetObj.CellValue2(row, prefix+"cre_usr_id")   	= gUsrId;
	sheetObj.CellValue2(row, prefix+"cre_usr_nm")   	= gUsrNm;
	sheetObj.SelectCell(row, prefix+"ofc_cd");
	sheetObj.CellValue2(row, prefix+"jo_ton_wgt_rnd_rt")= "1";
	sheetObj.CellValue2(row, prefix+"jo_20ft_rnd_rt")   = "1";
	sheetObj.CellValue2(row, prefix+"jo_40ft_rnd_rt")   = "1";
	sheetObj.CellValue2(row, prefix+"jo_45ft_rnd_rt")   = "1";
	
	return row;
}

function UF_reset(){
	//Combo reset
	for(var i=0; i<comboObjects.length; i++){
		comboObjects[i].Index2 = 0;
	}
	
	//VVD reset
	document.form.vvd_cd.value = "";
	
	// Delete 는 'N'
	document.form.delt_flg.text2 = "N";
	//Date Reset - Hold
	
	//Sheet reset
	sheetObjects[0].RemoveAll();
	
	// Date Reset
	document.form.fm_prd1.value = gDateFrom;
	document.form.to_prd2.value = gDateTo;
	
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_focus(){
	var formObj = document.form;
	var obj = event.srcElement;
	
    if (event.srcElement.name == "fm_prd1"){		
    	ComClearSeparator(formObj.fm_prd1, "ym");
    	ComSetFocus(formObj.fm_prd1);
    }	
    if (event.srcElement.name == "to_prd1"){		
    	ComClearSeparator(formObj.to_prd1, "ym");
    	ComSetFocus(formObj.to_prd1);
    }    
}

function obj_keypress(){    
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;
    
    switch(obj.dataformat) {
        case "ym":
            if(obj.name=="fm_prd1") ComKeyOnlyNumber(this, "-");
            if(obj.name=="to_prd1") ComKeyOnlyNumber(this, "-");            
            break;
        case "engup": 
        	if(obj.name == "vvd_cd") {
        		if(obj.value.length > 3 && obj.value.length < 8) {
					ComKeyOnlyNumber(obj);
        		} else if (obj.value.length == 8) {
        			ComKeyOnlyAlphabet('upper');
        		} else {
					ComKeyOnlyAlphabet('uppernum');
	        	}
        	}
            break;
        case "int":
        	ComKeyOnlyNumber(this);
        	break;            
    }        
}
/* 개발자 작업  끝 */