/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_2053.js
 *@FileTitle : RFA Proposal Creation - Arbitrary[Load Excel] (Add-On Tariff Management)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.17
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================
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
 * @class ESM_PRI_2053 : ESM_PRI_2053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_2053() {
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

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var errFlg = false;	// Check 버튼동작후 flag 값 세팅

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * processButtonClick();
 * </pre>
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.07.02
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_save":
			if (validateForm(sheetObject1, formObject, IBSAVE)) {
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			}
			break;

		case "btn_check":
			if (validateForm(sheetObject1, formObject, IBSEARCH)) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			break;

		case "btn_close":
			window.close();
			break;

		case "btn_file":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
			break;
			
		case "btn_Template":
		    downform.submit();
		    break;


		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 이은섭
 * @version 2012.07.02
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     loadPage();
 * </pre>
 * @return 없음
 * @author 이은섭
 * @version 2012.07.02
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	buttonControl("INIT");
}

/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 이은섭
 * @version 2012.07.02
 */
function initSheet(sheetObj, sheetNo) {
	var formObj = document.form;
	var cnt = 0;
	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 260;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Seq.|Point|Description|Term|Base\nPort|Trans\nMode|Per|CGO\nType|Actual\nCustomer|Cur.|Proposal|G/L|Diff|Weight\n(Ton<=)|Weight\n(<Ton)";
			HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12|fic_rt_use_sts_cd|fic_rout_cmb_tp_cd|optm_trsp_mod_flg|fic_gline_upd_dt";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, 	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtSeq,     		35,		daCenter,  	true, 	"add_chg_seq");
            InitDataProperty(0, cnt++ , dtData,    		50,    	daCenter,  	true, 	"rout_pnt_loc_def_cd",		false,	"",	dfNone, 		0,	true,	true,	5);
            InitDataProperty(0, cnt++ , dtData,        	110,    daLeft,  	true,  	"rout_pnt_loc_def_desc",	false, 	"",	dfNone, 		0,	false,	false,	40);
            InitDataProperty(0, cnt++ , dtCombo,      	50,    	daCenter,  	true,  	"rcv_de_term_cd",    		false, 	"",	dfNone, 		0,	true, 	true);            
            InitDataProperty(0, cnt++ , dtData,      	60,    	daCenter,  	true,  	"bse_port_def_cd",     		false,	"", dfNone, 		0,	true, 	true,	5);    
            InitDataProperty(0, cnt++ , dtCombo,  		80,    	daLeft,  	true,  	"prc_trsp_mod_cd",     		false,	"",	dfNone,   		0,	true, 	true);
            InitDataProperty(0, cnt++ , dtCombo,      	40,    	daCenter,  	true,  	"rat_ut_cd",     			false,	"", dfNone, 		0, 	true, 	true);
            InitDataProperty(0, cnt++ , dtCombo,  		40,    	daCenter,  	true,  	"prc_cgo_tp_cd",       		false,	"", dfNone, 	 	0, 	true, 	true);
            InitDataProperty(0, cnt++ , dtCombo,      	80,   	daCenter,  	true,  	"cust_def_cd",     			false,	"", dfNone, 		0,	true, 	true);
            InitDataProperty(0, cnt++ , dtCombo,    	45,    	daCenter,  	true, 	"curr_cd",      			false, 	"", dfNone, 		0, 	true, 	true);
            InitDataProperty(0, cnt++ , dtData,   		70,    	daRight,  	true,  	"prop_frt_rt_amt",     		false, 	"",	dfNullFloat, 	2, 	true,  	true,	9);
    		InitDataProperty(0, cnt++, 	dtHidden,      	68,		daRight,   	false,  "fic_gline_rt_amt",    	false, 	"", dfFloat,		2,  true,	true,	9);
    		InitDataProperty(0, cnt++, 	dtData,      	68,		daRight,   	false,  "diff_with_gl",     	false, 	"", dfNone,			2,  false,	false,	9);     
    		InitDataProperty(0, cnt++ , dtData,   		60,   	daRight,  	true,  	"min_cgo_wgt",    			false,	"",	dfNullFloat,	2,	true,	true,	4);
            InitDataProperty(0, cnt++ , dtData,  		60,   	daRight,  	true,  	"max_cgo_wgt",      		false,	"", dfNullFloat, 	2,	true, 	true,	4);       

            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"svc_scp_cd");
			InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"amdt_seq");
			InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"prop_no");
			InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"org_dest_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"add_chg_tp_cd");
            InitDataProperty(0, cnt++, dtHidden, 		86, 	daRight, 	false, 	"rout_pnt_loc_tp_cd");
            InitDataProperty(0, cnt++, dtHidden, 		86, 	daRight, 	false, 	"bse_port_tp_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"cust_cnt_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"cust_seq");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"prc_prog_sts_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"src_info_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"n1st_cmnc_dt");
            
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"fic_rt_use_sts_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"fic_rout_cmb_tp_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"optm_trsp_mod_flg");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"fic_gline_upd_dt");

            InitDataCombo(0, "rcv_de_term_cd", rcvDeTermCdComboText, rcvDeTermCdComboValue);
            InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdComboText, prcTrspModCdComboValue);            
            InitDataCombo(0, "rat_ut_cd", ratUtCdComboText, ratUtCdComboValue);
            InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdComboText, prcCgoTpCdComboValue);
            InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);
            InitDataCombo(0, "cust_def_cd", custDefCdComboText, custDefCdComboValue);
            
			InitDataValid(0, "rout_pnt_loc_def_cd",vtEngUpOther, "1234567890");
			InitDataValid(0, "bse_port_def_cd", vtEngUpOther, "1234567890");

			ShowButtonImage = 2;
            WaitImageVisible = false;
			ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";        
			
		}
		break;

	case 2: //컬럼 VALIDATION - 디비조회시 사용
		with (sheetObj) {
			// 높이 설정
			style.height = 160;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Seq.|Point|Description|Term|Base\nPort|Trans\nMode|Per|CGO\nType|Actual\nCustomer|Cur.|Proposal|G/L|Diff|Weight\n(Ton<=)|Weight\n(<Ton)";
			HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12|fic_rt_use_sts_cd|fic_rout_cmb_tp_cd|optm_trsp_mod_flg|fic_gline_upd_dt";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, 	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtHidden,  		40,		daCenter,  	true, 	"add_chg_seq");
            InitDataProperty(0, cnt++ , dtHidden,  		70,    	daCenter,  	true, 	"rout_pnt_loc_def_cd");
            InitDataProperty(0, cnt++ , dtHidden,      	120,    daLeft,  	true,  	"rout_pnt_loc_def_desc");
            InitDataProperty(0, cnt++ , dtHidden,  		60,    	daLeft,  	true,  	"prc_trsp_mod_cd");
            InitDataProperty(0, cnt++ , dtHidden,      	60,    	daLeft,  	true,  	"rcv_de_term_cd");
            InitDataProperty(0, cnt++ , dtHidden,   	70,    	daRight,  	true,  	"min_cgo_wgt");
            InitDataProperty(0, cnt++ , dtHidden,  		50,    	daRight,  	true,  	"max_cgo_wgt");
            InitDataProperty(0, cnt++ , dtHidden,      	50,    	daCenter,  	true,  	"bse_port_def_cd");
            InitDataProperty(0, cnt++ , dtHidden,      	60,    	daCenter,  	true,  	"cust_def_cd");
            
            InitDataProperty(0, cnt++ , dtHidden,      	60,    	daCenter,  	true,  	"rat_ut_cd");
            InitDataProperty(0, cnt++ , dtHidden,  		50,    	daLeft,  	true,  	"prc_cgo_tp_cd");
            InitDataProperty(0, cnt++ , dtHidden,    	35,    	daCenter,  	true, 	"curr_cd");
            InitDataProperty(0, cnt++ , dtHidden,   	50,    	daRight,  	true,  	"prop_frt_rt_amt");

            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"svc_scp_cd");
			InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"amdt_seq");
			InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"prop_no");
			InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"org_dest_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"add_chg_tp_cd");
            InitDataProperty(0, cnt++, dtHidden, 		86, 	daRight, 	false, 	"rout_pnt_loc_tp_cd");
            InitDataProperty(0, cnt++, dtHidden, 		86, 	daRight, 	false, 	"bse_port_tp_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"cust_cnt_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"cust_seq");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"prc_prog_sts_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"src_info_cd");
            InitDataProperty(0, cnt++, dtHidden, 		40, 	daCenter, 	true, 	"n1st_cmnc_dt");

            WaitImageVisible = false;
		}
		break;		
	}
}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	var formObj = document.form
	switch (colname) {
	case "rout_pnt_loc_def_cd":
		if(!checkRoutePointLocation(sheetObj, Row, Value)) {
			return;
		}
		initFicRoute(sheetObj, Row, Col);
		checkLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false);
		break;	
		
	case "rcv_de_term_cd": //Term
		initFicRoute(sheetObj, Row, Col);
		break;
		
	case "bse_port_def_cd":
		if(sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && !checkBasePort(sheetObj, Row, Value)) { //point와 비교
			 return;
		}
		initFicRoute(sheetObj, Row, Col);
		checkLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC07);
		break;
		
	case "prc_trsp_mod_cd": //trans mode
		if(Value == ""){
			initFicRoute(sheetObj, Row, Col);
		}
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);		
		break;
	
	case "rat_ut_cd":
		checkPerType(sheetObj, Row, Value);
		initFicRoute(sheetObj, Row, Col);
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);		
		break;
		
	case "prc_cgo_tp_cd":
		checkCargoType(sheetObj, Row, Value);
		if(Value==""){
			initFicRoute(sheetObj, Row, Col);
		}
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);		
		break;
			
	case "curr_cd":
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
		break;	
		
	case "prop_frt_rt_amt":
		calcProposalAmt(sheetObj, Row);
		break;			
	}
	
	var propStsCd = formObj.prop_sts_cd.value;
	var amdtSeq = formObj.amdt_seq.value;
	if(amdtSeq == 0 && propStsCd == 'I') {
		if (sheetObj.CellValue(Row, "src_info_cd") == "PC") {
			sheetObj.CellValue2(Row, "src_info_cd") = "PM";
		} else if (sheetObj.CellValue(Row, "src_info_cd") == "GC") {
			sheetObj.CellValue2(Row, "src_info_cd") = "GM";
		}
	}
}

/**
 * location code 를 리셋하는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
 * </pre>
 * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param (string) cellTpCdNm 선택한 cell의 tp code
 * @param (string) cellDefCdNm 선택한 cell의 def code
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
	sheetObj.CellValue2(Row, cellTpCdNm) = "";
	sheetObj.CellValue2(Row, cellDefCdNm) = "";
}

/**
 * location code 유효성 확인하는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *    checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
 * </pre>
 * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param (string) cellTpCdNm 선택한 cell의 tp code
 * @param (string) cellDefCdNm 선택한 cell의 def code
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
	var formObj = document.form;
	var locCd = sheetObj.CellValue(Row, cellDefCdNm);
	// Location
	if (locCd.length == 5 && isLoc) {
		formObj.f_cmd.value = SEARCH05; 	    			
		formObj.cd.value = locCd;
		var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
		if (arrDesc != null && arrDesc.length > 0) {
			sheetObj.CellValue2(Row, cellTpCdNm) = "L" ;
			if (cellDefCdNm == "rout_pnt_loc_def_cd") {
				sheetObj.CellValue2(Row,"rout_pnt_loc_def_desc") = arrDesc[0][1];
			}
		} else {	
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			if (cellDefCdNm == "rout_pnt_loc_def_cd") {
				sheetObj.CellValue2(Row,"rout_pnt_loc_def_desc") = "";
			}
		}
	} 
	// Group Location
	else if (locCd.length == 4 && isGrpLoc) {
		formObj.f_cmd.value = COMMAND24;
		formObj.cd.value = locCd;
		var sParam = FormQueryString(formObj);
		sParam += "&etc1="+PRI_RP_SCP;
		var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
		var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
		if (arrData != null && arrData.length > 0) {
			sheetObj.CellValue2(Row, "bse_port_tp_cd") = "G";
		} else {
			sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
			sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
		}
	} else {
		locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
		if (cellDefCdNm == "rout_pnt_loc_def_cd") {
			sheetObj.CellValue2(Row,"rout_pnt_loc_def_desc") = "";
		}
	}
}

/**
 * Sheet관련 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return 없음
 * @author 이은섭
 * @version 2012.07.02
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		switch (sAction) {
			case IBSEARCH: //조회	
  				ComOpenWait(true);
				formObj.f_cmd.value = MULTI02;
				var sParam = FormQueryString(formObj);
				var sParamSheet1 = sheetObj.GetSaveString(true);
				sParam += "&" + sParamSheet1;
				
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2053GS.do", sParam);
				sheetObjects[1].LoadSearchXml(sXml);
				
				//오류데이터 빨간색 처리
				checkValidationAllData(sheetObjects[1]);
				break;
		
			case IBSAVE: //저장
				if(errFlg) {
					buttonControl("FAIL");
					return false;
				}
			
				if((ComShowCodeConfirm("PRI00001")) ) {	
	  				ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("ESM_PRI_2053GS.do", FormQueryString(formObj), -1, false);
				}
				break;
			case IBSEARCH_ASYNC07: //Search FIC Guide Line
				if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
				funcPrcTrspModCd(sheetObj, sheetObj.SelectRow);
				break;	
												
			case IBSEARCH_ASYNC08: //Search FIC Guide Line
				if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
				funcGuidelineAmt(sheetObj, sheetObj.SelectRow);
				break;	
				
			case IBSEARCH_ASYNC02: // Open
				ComOpenWait(true);
				sheetObjects[0].LoadExcel(-1, 1, "", "-1", "-1", "", false);
				break;										
		}
	}catch(e){
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}finally {
		 ComOpenWait(false);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *         로직처리;
 *     }
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @returns bool <br>
 *          true  : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 이은섭
 * @version 2012.07.02
 */
function validateForm(sheetObj, formObj, sAction) {

	switch (sAction) {
	case IBSEARCH: // 체크

		if (!sheetObjects[0].IsDataModified) {
			ComShowCodeMessage("PRI00312");
			return false;
		}

		break;

	case IBSAVE: // 저장

		if (!ComIsBtnEnable("btn_save")) {
			return false;
		}

		if (sheetObjects[0].IsDataModified) {
			//기존데이터와 중복 체크 위한 처리
			sheetObjects[1].RemoveAll();
			var sXml = ComPriSheet2Xml(sheetObjects[0])
			sheetObjects[1].LoadSearchXml(sXml);

			//오류데이터 빨간색 처리
			formObj.f_cmd.value = SEARCH01;
			sXml = sheetObj.GetSearchXml("ESM_PRI_2019_04GS.do", FormQueryString(formObj));
			sheetObjects[1].LoadSearchXml(sXml,true);
			
			var rowM = sheetObjects[1].ColValueDupRows("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|" +
					"bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|min_cgo_wgt|max_cgo_wgt|cust_def_cd|amdt_seq", false, true);
			
			if (rowM != "") {
				var rowDup = rowM.split("|");
				ComShowCodeMessage("PRI00303", "Sheet", rowDup[0]);

				// 중복된 데이터를 수정하기 위한 처리
				sheetObj.Editable = true;
				buttonControl("FAIL");
				return false;
			}
		}
		break;
		
		case IBSEARCH_ASYNC07:
			var Row = sheetObj.SelectRow;
			if(sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == "" ||
					sheetObj.CellValue(Row, "rcv_de_term_cd") == "" ||
					sheetObj.CellValue(Row, "bse_port_def_cd") == ""){
				return false;
			}
			return true;
			break;
			
		case IBSEARCH_ASYNC08: //
			var Row = sheetObj.SelectRow;
			if(sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == "" ||
					sheetObj.CellValue(Row, "rcv_de_term_cd") == "" ||
					sheetObj.CellValue(Row, "bse_port_def_cd") == "" ||
					sheetObj.CellValue(Row, "prc_trsp_mod_cd") == "" ||
					sheetObj.CellValue(Row, "rat_ut_cd") == "" ||
					sheetObj.CellValue(Row, "prc_cgo_tp_cd") == ""){
				return false;
			}
			return true;
			break;		
	}

	return true;
}

/**
 * OnSaveEnd 이벤트 발생시 호출되는 function <br>
 * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.02
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	 
	var psheetObj = dialogArguments.sheetObjects[0];
	var pformObj = dialogArguments.document.form;
	
	dialogArguments.setProposalStatusSummary(pformObj);
	dialogArguments.doActionIBSheet(psheetObj, pformObj, IBSEARCH);
	window.close();
}

/**
 * LoadExcel 이벤트 발생시 호출되는 function <br>
 * 엑셀파일 로드 후 정상이면 SHEET COLUMN 을 제어한다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @return 없음
 * @author 이은섭
 * @version 2012.07.02
 */
function sheet1_OnLoadExcel(sheetObj) {
	sheetObj.Redraw = false;
	var formObj = document.form;
	if (sheetObj.RowCount > 0) {
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			sheetObj.CellValue2(i, "svc_scp_cd") 		= formObj.svc_scp_cd.value;
			sheetObj.CellValue2(i, "amdt_seq") 			= formObj.amdt_seq.value;
			sheetObj.CellValue2(i, "prop_no") 			= formObj.prop_no.value;
			sheetObj.CellValue2(i, "add_chg_tp_cd") 	= formObj.add_chg_tp_cd.value;
			sheetObj.CellValue2(i, "org_dest_tp_cd") 	= formObj.org_dest_tp_cd.value;
			sheetObj.CellValue2(i, "n1st_cmnc_dt") 		= formObj.n1st_cmnc_dt.value;
			var propFrtRtAmt = sheetObj.CellValue(i, "prop_frt_rt_amt");
			
			funcGuidelineAmt(sheetObj, i);
			sheetObj.CellValue(i, "prop_frt_rt_amt")	= propFrtRtAmt;
		}
	}
	sheetObj.Redraw = true;
	buttonControl("LOAD");
}

/**
 * Check 버튼 이벤트 발생후 호출되는 function 으로 오류데이터가 존재할경우 SHEET배경색을 빨간색으로 처리한다.<br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @return 없음
 * @author 이은섭
 * @version 2012.07.02
 */
function checkValidationAllData(sheetObj) {
		var check = 0;
		// 오류셀 색지정
		var color = sheetObjects[0].RgbColor(255, 0, 0); // 빨강

		//초기색지정-흰색
		for ( var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
			sheetObjects[0].RowBackColor(i) = 0;
		}

		//화면에서의 validation 체크
		check += validateSheetData(sheetObjects[0], color);

		// DB에서의 validation 체크
		check += checkDBCodeExist(sheetObj, color);

		if (check > 0) {
			errFlg = true;
			buttonControl("FAIL");
		} else {
			errFlg = false;
			//모든셀 readonly 처리할것
			sheetObjects[0].Editable = false;
			buttonControl("SUCCEED");
		}
}

 
 /**
  * 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event function <br>
  * <br><b>Example :</b>
  * <pre>
  * 
  * </pre>
  * @param {ibsheet} sheetObj 필수 IBSheet Object
  * @param {Long} Row 필수 해당 셀의 Row Index
  * @param {Long} Col 필수 해당 셀의 Column Index
  * @param {Integer} KeyCode 필수 키보드의 아스키 값
  * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
  * @return 없음
  * @author 이은섭
  * @version 2012.07.02
  */ 
  function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
      if (errFlg && KeyCode == 9) {
          while (true) {
              if (Col > sheetObj.LastCol) {
                  Row++;
                  Col = 1;
              }
              if (Row > sheetObj.LastRow) {
                  Row = sheetObj.HeaderRows;
              }
              if (sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255,0,0)) {
                  sheetObj.SelectCell(Row, Col, false);
                  break;
              }
              Col++;
          }
      }
  }
  
  /**
   * OnMouseMove 이벤트 발생시 호출되는 function <br>
   * Tool Tip 을 보여준다. <br>
   * <br><b>Example :</b>
   * <pre>
   * 
   * </pre>
   * @param {int} Button 필수 마우스버튼 방향, 1:왼쪽, 2:오른쪽
   * @param {int} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
   * @param (Long) X 필수 X 좌표
   * @param (Long) Y 필수 Y 좌표
   * @return 없음
   * @author 이은섭
   * @version 2012.07.02
   */ 
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var sRow = sheetObj.MouseRow;
	var sCol = sheetObj.MouseCol;
	var sText = sheetObj.GetComboInfo(sRow, sCol, "Text");
	var arrText = sText.split("|");

	if (sRow > 0 && sCol == 9) {
		var sIdx = sheetObj.GetComboInfo(sRow, sCol, "SelectedIndex");
		sheetObj.MouseToolTipText = arrText[sIdx].split("\t")[1];
	}
}

/**
 * 화면상에서의  validation 체크하는 function <br>
 * validate 에 걸릴경우 check 값을 return 한다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {object} color 필수 IBSheet RgbColor
 * @return check
 * @author 이은섭
 * @version 2012.07.02
 */
function validateSheetData(sheetObj, color) {
	var check = 0;
	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		if (sheetObj.CellValue(i, "rout_pnt_loc_def_cd").length != 5) {
			sheetObj.CellBackColor(i, "rout_pnt_loc_def_cd") = color;	
			check++;
		}
		if (ComIsNull(sheetObj.CellValue(i, "prc_trsp_mod_cd"))) {
			sheetObj.CellBackColor(i, "prc_trsp_mod_cd") = color;	
			check++;
		}

		if (ComIsNull(sheetObj.CellValue(i, "rcv_de_term_cd"))) { 
			sheetObj.CellBackColor(i, "rcv_de_term_cd") = color;
			check++;
		}
		
		if (!ComIsNull(sheetObj.CellValue(i, "min_cgo_wgt")) && sheetObj.CellValue(i, "min_cgo_wgt") > 99.99) {
			sheetObj.CellBackColor(i, "min_cgo_wgt") = color;
			check++;
		}
		
		if (!ComIsNull(sheetObj.CellValue(i, "max_cgo_wgt")) && sheetObj.CellValue(i, "max_cgo_wgt") > 99.99) {
			sheetObj.CellBackColor(i, "max_cgo_wgt") = color;
			check++;
		}
		
		if (ComIsNull(sheetObj.CellValue(i, "bse_port_def_cd"))) {
			sheetObj.CellBackColor(i, "bse_port_def_cd") = color;
			check++;
		}
		
		if (ComIsNull(sheetObj.CellValue(i, "cust_def_cd")) && ComTrim(sheetObj.CellText(i, "cust_def_cd")) != "") {
			sheetObj.CellBackColor(i, "cust_def_cd") = color;
			check++;
		}

		if (ComIsNull(sheetObj.CellValue(i, "rat_ut_cd"))) {
			sheetObj.CellBackColor(i, "rat_ut_cd") = color;
			check++;
		}
		
		if (ComIsNull(sheetObj.CellValue(i, "prc_cgo_tp_cd")) && ComTrim(sheetObj.CellText(i, "prc_cgo_tp_cd")) != "") {
			sheetObj.CellBackColor(i, "prc_cgo_tp_cd") = color;
			check++;
		}

		if (ComIsNull(sheetObj.CellValue(i, "curr_cd")) && ComTrim(sheetObj.CellText(i, "curr_cd")) != "" ) {
			sheetObj.CellBackColor(i, "curr_cd") = color;
			check++;
		}
		
		if (ComIsNull(sheetObj.CellValue(i, "prop_frt_rt_amt")) || sheetObj.CellValue(i, "prop_frt_rt_amt") == 0 || sheetObj.CellValue(i, "prop_frt_rt_amt").length > 10) {
			sheetObj.CellBackColor(i, "prop_frt_rt_amt") = color;		
			check++;
		}
		
		// Term 이 Door 가 아니고, b.port와 point 에 동일 Code 가 입력 된 경우  validation 이 필요
		if (sheetObj.CellValue(i, "rcv_de_term_cd") != "D" && (sheetObj.CellValue(i, "rout_pnt_loc_def_cd") == sheetObj.CellValue(i, "bse_port_def_cd"))) {
			sheetObj.CellBackColor(i, "rcv_de_term_cd") = color;
			sheetObj.CellBackColor(i, "rout_pnt_loc_def_cd") = color;
			sheetObj.CellBackColor(i, "bse_port_def_cd") = color;
			check++;
		}
	}

	return check;

}

/**
 * 엑셀파일을 로드한후  디비조회하여 validation 하는 함수 <br>
 * 잘못된 데이터 존재할때 색상처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 		checkDBCodeExist(sheetObj, formObj);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {object} color 필수 IBSheet RgbColor
 * @return check
 * @author 이은섭
 * @version 2012.07.02
 */
function checkDBCodeExist(sheetObj, color) {
	var check = 0;
	var arbSeq = 0;
	var custDefCd = "";

	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		arbSeq = sheetObjects[0].CellValue(i, "add_chg_seq");

		if (sheetObj.CellValue(i, "rout_pnt_loc_def_cd") == "0") {
			sheetObjects[0].CellBackColor(arbSeq, "rout_pnt_loc_def_cd") = color;
			check++;
		} else {
			sheetObjects[0].CellValue2(arbSeq, "rout_pnt_loc_tp_cd") = "L";
		}

		if (sheetObj.CellValue(i, "bse_port_def_cd") == "0") {
			sheetObjects[0].CellBackColor(arbSeq, "bse_port_def_cd") = color;
			check++;
		} else {
			if (sheetObjects[0].CellValue(arbSeq, "bse_port_def_cd").length == 4) {
				sheetObjects[0].CellValue2(arbSeq, "bse_port_tp_cd") = "G";
			} else if (sheetObjects[0].CellValue(arbSeq, "bse_port_def_cd").length == 5) {
				sheetObjects[0].CellValue2(arbSeq, "bse_port_tp_cd") = "L";
			}
		}
		
		if(sheetObj.CellValue(i, 'rcv_de_term_cd') == "0") {
			sheetObjects[0].CellBackColor(arbSeq, "rcv_de_term_cd") = color;
			check++;
		}
		if(sheetObj.CellValue(i, 'bse_port_def_cd') == "0") {
			sheetObjects[0].CellBackColor(arbSeq, "bse_port_def_cd") = color;
			check++;
		}
		if(sheetObj.CellValue(i, 'prc_trsp_mod_cd') == "0") {
			sheetObjects[0].CellBackColor(arbSeq, "prc_trsp_mod_cd") = color;
			check++;
		}
		if(sheetObj.CellValue(i, 'rat_ut_cd') == "0") {
			sheetObjects[0].CellBackColor(arbSeq, "rat_ut_cd") = color;
			check++;
		}
		if(sheetObj.CellValue(i, 'prc_cgo_tp_cd') == "0") {
			sheetObjects[0].CellBackColor(arbSeq, "prc_cgo_tp_cd") = color;
			check++;
		}
	}

	return check;
}
 
 
/**
  * 버튼 권한 컨트롤 function <br>
  * 버튼을 제어한다. <br>
  * <br><b>Example :</b>
  * <pre>
  * buttonControl()
  * </pre>
  * @param 없음
  * @return 없음
  * @author 이은섭
  * @version 2012.07.02
  */
function buttonControl(valChck){
	var formObj = document.form;
	var rowCount = sheetObjects[0].RowCount;
	try{
		ComBtnDisable("btn_file");
		ComBtnDisable("btn_check");
		ComBtnDisable("btn_save");
		ComBtnEnable("btn_close");
					
		switch(valChck) {
			case "SUCCEED":
				ComBtnEnable("btn_save");
				break;
				
			case "FAIL":
				ComBtnEnable("btn_file");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				break;
				
			case "LOAD":
				ComBtnEnable("btn_file");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				break;
				
			case "INIT":
				ComBtnEnable("btn_file");
				ComBtnDisable("btn_check");
				ComBtnDisable("btn_save");
				break;
		}	
		
	} catch (e) {}
}

/**
 * GuideLine 금액 조회.
 */
function funcGuidelineAmt(sheetObj, Row) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH03;
	var sParam = FormQueryString(formObj);
	sParam += "&fic_prop_sts_cd=" + sheetObj.CellValue(Row, "prc_prog_sts_cd") ;
	sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd");
	sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd") ;
	sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd") ;
	sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "prc_trsp_mod_cd") ;
	sParam += "&rat_ut_cd=" + sheetObj.CellValue(Row, "rat_ut_cd") ;
	sParam += "&prc_cgo_tp_cd=" + sheetObj.CellValue(Row, "prc_cgo_tp_cd");
	sParam += "&curr_cd=" + sheetObj.CellValue(Row, "curr_cd") ;
	sParam += "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
	sParam += "&org_dest_tp_cd=" + sheetObj.CellValue(Row, "org_dest_tp_cd");
	
	var sXml = sheetObjects[1].getSearchXml("ESM_PRI_2003_12GS.do", sParam);
	var saveName = "fic_rt_use_sts_cd|fic_rout_cmb_tp_cd|optm_trsp_mod_flg|fic_gline_rt_amt|fic_gline_upd_dt";
	var saveNameArr = saveName.split("|");
	var arrDesc = ComPriXml2Array(sXml, saveName);
	if (arrDesc != null && arrDesc.length > 0) {
		sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = arrDesc[0][0];
		sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = arrDesc[0][1];
		sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = arrDesc[0][2];
		sheetObj.CellValue2(Row, "fic_gline_rt_amt") = arrDesc[0][3];
		sheetObj.CellValue2(Row, "prop_frt_rt_amt") = arrDesc[0][3];
		sheetObj.CellValue2(Row, "fic_gline_upd_dt") = arrDesc[0][4];
		calcProposalAmt(sheetObj, Row);
	}	
}

/**
 * 
 */
function funcPrcTrspModCd(sheetObj, Row) {
	var formObj = document.form;	
	formObj.f_cmd.value = SEARCH02;
	
	var sParam = FormQueryString(formObj);
	sParam += "&fic_prop_sts_cd=" + sheetObj.CellValue(Row, "prc_prog_sts_cd");
	sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd");
	sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd");
	sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd");
	sParam += "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
	sParam += "&org_dest_tp_cd=" + sheetObj.CellValue(Row, "org_dest_tp_cd");
	
	var sXml = sheetObjects[1].getSearchXml("ESM_PRI_2003_12GS.do", sParam);
	var arr = ComPriXml2ComboString(sXml, "prc_trsp_mod_cd", "prc_trsp_mod_cd");
	if(arr!=null && arr.length > 0){
		sheetObj.CellValue(Row, "prc_trsp_mod_cd") = arr[0];
	}	
}

    /**
     * Propocal Amount 계산 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		calcProposalAmt(sheetObj, Row)
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
    function calcProposalAmt(sheetObj, Row){
    	var strPropFrtRtAmt = "";
		var strFicGlineRtAmt = "";
		var numPropFrtRtAmt = 0;
		var numFicGlineRtAmt = 0;
		if("S"==sheetObj.CellValue(Row, "fic_rt_use_sts_cd")){
    		strPropFrtRtAmt = sheetObj.CellValue(Row, "prop_frt_rt_amt");
			if(strPropFrtRtAmt){
				numPropFrtRtAmt = Number(strPropFrtRtAmt);
			}
			strFicGlineRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
			if(strFicGlineRtAmt){
				numFicGlineRtAmt = Number(strFicGlineRtAmt);
			}
			
			// 부동소수점 제어를 위해 정수형 변경후 처리
			numPropFrtRtAmt = numPropFrtRtAmt * 100;
			numFicGlineRtAmt = numFicGlineRtAmt * 100;
			
			numPropFrtRtAmt = numPropFrtRtAmt.toFixed();
			numFicGlineRtAmt = numFicGlineRtAmt.toFixed();
			sheetObj.CellValue2(Row, "diff_with_gl") =  ComAddComma2(((numPropFrtRtAmt - numFicGlineRtAmt)/100).toString(), '#,###.00');
		} else {
			sheetObj.CellValue2(Row, "diff_with_gl") = "N/A";
		}
    }
    
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
	 * Change가 발생한 Row를 초기화 한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	 * @return 없음
	 * @author 김재연
	 * @version 2009.05.19
	 */ 
    function initFicRoute(sheetObj, Row, Col) {
    	var formObj = document.form;
    	var amdt_seq = formObj.amdt_seq.value;
    	
    	sheetObj.Redraw = false;
		var saveName = sheetObj.ColSaveName(Col);
		switch(saveName){
			case "rout_pnt_loc_def_cd":
				sheetObj.CellValue(Row, "rcv_de_term_cd") = "";
			case "rcv_de_term_cd":
				sheetObj.CellValue(Row, "bse_port_def_cd") = "";
				
			case "bse_port_def_cd":
				sheetObj.CellValue2(Row, "prc_trsp_mod_cd") = "";
				
			case "prc_trsp_mod_cd":
				sheetObj.CellValue2(Row, "rat_ut_cd") = "";
				
			case "rat_ut_cd":
				sheetObj.CellValue2(Row, "prop_frt_rt_amt") = "";
				sheetObj.CellValue2(Row, "fic_gline_rt_amt") = "";
				sheetObj.CellValue2(Row, "diff_with_gl") = "";
				sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = "";
				sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = "";
				sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = "";
				sheetObj.CellValue2(Row, "fic_gline_upd_dt") = "";
				break;
		}
		sheetObj.Redraw = true;
    }   
    
	/**
     * prc_cgo_tp_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
	function checkPerType(sheetObj, Row, Value) {
		var validPerClass = "A,F,O,Q,S,P";
        if(sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
        	ComShowCodeMessage("PRI08003");
    		sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
        }
	}

	/**
     * rat_ut_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
	function checkCargoType(sheetObj, Row, Value) {
    	var validPerClass = "A,F,O,Q,S,P";
    	var ratUtCd = sheetObj.CellValue(Row, "rat_ut_cd");
        if (Value == "AK" && ( ComIsNull(ratUtCd) || validPerClass.indexOf(ratUtCd.charAt(0)) < 0 )) {
            ComShowCodeMessage("PRI08003");
            sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
        }
	} 
	    
	/**
     * rout_pnt_loc_tp_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkRoutePointLocation(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
	function checkRoutePointLocation(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if (sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.CellValue(Row, "bse_port_def_cd") == Value) {
			ComShowCodeMessage('PRI01078');
			sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") = "";
			sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "";
			return false;
		}
		return true;
	}
	
    function clearTooltip() {
        var sheetObj = sheetObjects[0];
        var n = sheetObj.HeaderRows+sheetObj.RowCount;
        var m = sheetObj.LastCol;
        var i = sheetObj.HeaderRows;
        var j = 0;
        for (i = sheetObj.HeaderRows ; i < n; i++) {
            for (j = 0 ; j <= m ; j++) {
                if (sheetObj.ToolTipText(i, j) != "") {
                	if(sheetObj.CellEditable(i, j)) {
                    	sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
                	} else {
                		sheetObj.CellBackColor(i, j) = sheetObj.UnEditableColor;
                	}
                    sheetObj.ToolTipText(i, j) = "";
                }
            }
        }
    }

    function add2Tooltip(row, col, msg) {
        var sheetObj = sheetObjects[0];

        sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
        sheetObj.ToolTipText(row, col) +="\n- " +  msg;
    }	

    
	/**
     * bse_port_def_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
	function checkBasePort(sheetObj, Row, Value) {
		if (sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") != "" && sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
			sheetObj.CellValue(Row, "bse_port_def_cd") = "";			
			return false;
		}
		return true;
	}