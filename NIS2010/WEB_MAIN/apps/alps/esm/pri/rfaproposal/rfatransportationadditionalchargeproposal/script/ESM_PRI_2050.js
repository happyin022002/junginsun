/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2050.js
 *@FileTitle : RFA Proposal Creation - Arbitrary[Load Excel]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.07.29 최성민
 * 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
 * @class ESM_PRI_2050 : ESM_PRI_2050 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_2050() {
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
 * @author 최성민
 * @version 2009.07.30
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
			//sheetObjects[0].LoadExcel(-1);
			sheetObjects[0].LoadExcel(-1, 1, "", "-1", "-1", "", false);
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
 * @author 최성민
 * @version 2009.05.20
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
 * @author 최성민
 * @version 2009.05.17
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
 * @author 최성민
 * @version 2009.05.17
 */
function initSheet(sheetObj, sheetNo) {

	var formOrg = document.form;
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

			var HeadTitle = "|Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base\nPort|Actual\nCustomer|Per|CGO\nType|Cur.|Proposal";
			HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12";
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
            InitDataProperty(0, cnt++ , dtCombo,  		80,    	daLeft,  	true,  	"prc_trsp_mod_cd",     		false,	"",	dfNone,   		0,	true, 	true);
            InitDataProperty(0, cnt++ , dtCombo,      	50,    	daCenter,  	true,  	"rcv_de_term_cd",    		false, 	"",	dfNone, 		0,	true, 	true);
            InitDataProperty(0, cnt++ , dtData,   		60,   	daRight,  	true,  	"min_cgo_wgt",    			false,	"",	dfNullFloat,	2,	true,	true,	4);
            InitDataProperty(0, cnt++ , dtData,  		60,   	daRight,  	true,  	"max_cgo_wgt",      		false,	"", dfNullFloat, 	2,	true, 	true,	4);
            InitDataProperty(0, cnt++ , dtData,      	60,    	daCenter,  	true,  	"bse_port_def_cd",     		false,	"", dfNone, 		0,	true, 	true,	5);
            InitDataProperty(0, cnt++ , dtCombo,      	80,   	daCenter,  	true,  	"cust_def_cd",     			false,	"", dfNone, 		0,	true, 	true);
            
            InitDataProperty(0, cnt++ , dtCombo,      	40,    	daCenter,  	true,  	"rat_ut_cd",     			false,	"", dfNone, 		0, 	true, 	true);
            InitDataProperty(0, cnt++ , dtCombo,  		40,    	daCenter,  	true,  	"prc_cgo_tp_cd",       		false,	"", dfNone, 	 	0, 	true, 	true);
            InitDataProperty(0, cnt++ , dtCombo,    	45,    	daCenter,  	true, 	"curr_cd",      			false, 	"", dfNone, 		0, 	true, 	true);
            InitDataProperty(0, cnt++ , dtData,   		70,    	daRight,  	true,  	"prop_frt_rt_amt",     		false, 	"",	dfNullFloat, 	2, 	true,  	true,	9);

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

            InitDataCombo(0, "rcv_de_term_cd", rcvDeTermCdComboText, rcvDeTermCdComboValue);
            InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdComboText, prcTrspModCdComboValue);            
            InitDataCombo(0, "rat_ut_cd", ratUtCdComboText, ratUtCdComboValue);
            InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdComboText, prcCgoTpCdComboValue);
            InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);
            InitDataCombo(0, "cust_def_cd", custDefCdComboText, custDefCdComboValue);
            
            //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정
			InitDataValid(0, "rout_pnt_loc_def_cd",vtEngUpOther, "1234567890");
			InitDataValid(0, "bse_port_def_cd", vtEngUpOther, "1234567890");
			//InitDataValid(0, "cust_def_cd", vtEngUpOther, "1234567890");

			ShowButtonImage = 2;
            WaitImageVisible = false;
			
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

			var HeadTitle = "|Seq.|Point|Description|Trans Mode|Term|Weight(Ton<=)|Weight(<Ton)|Base Port|Actual Customer|Per|Cargo Type|Currency|Proposal";
			HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12";
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
		if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			formObj.cd.value = sheetObj.Cellvalue(Row, Col);
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do",
					FormQueryString(formObj));
			var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_desc") = arrData[0][1];
				sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
				
			} else {
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_desc") = "";
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
				sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "";
				sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
			}
		} else {
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_desc") = "";
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
			sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "";
			sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
		}
		break;
	case "bse_port_def_cd":
		if (Value.length == 5) {
			if(Value == sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") && sheetObj.CellValue(Row, "rcv_de_term_cd") != "D") {
				ComShowCodeMessage('PRI01020');
				sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
				sheetObj.SelectCell(Row, "bse_port_def_cd");
				break;
			}
			
			formObj.f_cmd.value = SEARCH05;
			formObj.cd.value = Value;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do",
					FormQueryString(formObj));
			var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "L";
			} else {
				sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
		} else if(Value.length == 4) {
			formObj.f_cmd.value = COMMAND24;
			formObj.cd.value = Value;
			var sParam = FormQueryString(formObj);
			sParam += "&etc1="+PRI_RP_SCP;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "G";
			} else {
				sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
		} else {
			sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
			sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
			sheetObj.SelectCell(Row, "bse_port_def_cd");
		}
		break;
	/*	
	case "cust_def_cd": 				
		if (Value.length > 2 && ComIsNumber(Value.slice(2))){
						
			var custCntCd		= Value.substring(0,2);
			var custSeq 		= ComLpad(Value.slice(2), 6, "0");
		
			formObj.f_cmd.value = SEARCHLIST15;
			var sParam = FormQueryString(formObj);
			sParam += "&etc1="+custCntCd;
			sParam += "&etc2="+custSeq;
			
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);	  			
			var arrData = ComPriXml2Array(sXml, "cd|nm");
			
			if (arrData != null && arrData.length > 0){
				sheetObj.CellValue2(Row,"cust_def_cd") = custCntCd + custSeq;
				sheetObj.CellValue2(Row, "cust_cnt_cd")	= custCntCd;
				sheetObj.CellValue2(Row, "cust_seq")	= custSeq;
			}else{
				sheetObj.CellValue2(Row, "cust_def_cd")	= "";
				sheetObj.CellValue2(Row, "cust_cnt_cd")	= "";
				sheetObj.CellValue2(Row, "cust_seq")	= "";
				sheetObj.SelectCell(Row, "cust_def_cd");	
	
			} 					
		} else {
			sheetObj.CellValue2(Row, "cust_def_cd")	= "";
			sheetObj.CellValue2(Row, "cust_cnt_cd")	= "";
			sheetObj.CellValue2(Row, "cust_seq")	= "";
			sheetObj.SelectCell(Row, "cust_def_cd");
		}
 		break; 	 
 	*/	
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
 * @author 최성민
 * @version 2009.05.17
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
				
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2050GS.do", sParam);
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
					sheetObj.DoSave("ESM_PRI_2050GS.do", FormQueryString(formObj), -1, false);
				}
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
 * @author 최성민
 * @version 2009.04.17
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
			//-------------checkValidationAllData(sheetObjects[1]);
			
			formObj.f_cmd.value = SEARCH01;
			sXml = sheetObj.GetSearchXml("ESM_PRI_2019_04GS.do", FormQueryString(formObj));
			sheetObjects[1].LoadSearchXml(sXml,true);
			
			//sXml = ComPriSheet2Xml(dialogArguments.sheetObjects[0]);
			//sheetObjects[1].LoadSearchXml(sXml,true);
			
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
 * @author 최성민
 * @version 2009.05.17
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
 * @author 최성민
 * @version 2009.06.25
 */
function sheet1_OnLoadExcel(sheetObj) {

	var formObj = document.form;

	if (sheetObj.RowCount > 0) {
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			//필수코드 데이터셋
			sheetObj.CellValue2(i, "svc_scp_cd") 		= formObj.svc_scp_cd.value;
			sheetObj.CellValue2(i, "amdt_seq") 			= formObj.amdt_seq.value;
			sheetObj.CellValue2(i, "prop_no") 			= formObj.prop_no.value;
			sheetObj.CellValue2(i, "add_chg_tp_cd") 	= formObj.add_chg_tp_cd.value;
			sheetObj.CellValue2(i, "org_dest_tp_cd") 	= formObj.org_dest_tp_cd.value;
			sheetObj.CellValue2(i, "n1st_cmnc_dt") 		= formObj.n1st_cmnc_dt.value;
		}
	}
	
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
 * @author 최성민
 * @version 2009.05.20
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
  * @author 최성민
  * @version 2009.05.20
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
   * @author 최성민
   * @version 2010.01.26
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
 * @author 최성민
 * @version 2009.06.25
 */
function validateSheetData(sheetObj, color) {
	var check = 0;

	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {

		if (sheetObj.CellValue(i, "rout_pnt_loc_def_cd").length != 5) {
			sheetObj.CellBackColor(i, "rout_pnt_loc_def_cd") = color;
			check++;
		}

		if (sheetObj.CellValue(i, "prc_trsp_mod_cd") == ""
				&& ComTrim(sheetObj.CellText(i, "prc_trsp_mod_cd")) != "") {
			sheetObj.CellBackColor(i, "prc_trsp_mod_cd") = color;
			check++;
		}

		if (sheetObj.CellValue(i, "rcv_de_term_cd") == "") {
			sheetObj.CellBackColor(i, "rcv_de_term_cd") = color;
			check++;
		}
		
		if (sheetObj.CellValue(i, "min_cgo_wgt") != "" && sheetObj.CellValue(i, "min_cgo_wgt") > 99.99) {
			sheetObj.CellBackColor(i, "min_cgo_wgt") = color;
			check++;
		}
		
		if (sheetObj.CellValue(i, "max_cgo_wgt") != "" && sheetObj.CellValue(i, "max_cgo_wgt") > 99.99) {
			sheetObj.CellBackColor(i, "max_cgo_wgt") = color;
			check++;
		}
		
		if (sheetObj.CellValue(i, "bse_port_def_cd") == "") {
			sheetObj.CellBackColor(i, "bse_port_def_cd") = color;
			check++;
		}
		
		if (sheetObj.CellValue(i, "cust_def_cd") == ""
				&& ComTrim(sheetObj.CellText(i, "cust_def_cd")) != "") {
			sheetObj.CellBackColor(i, "cust_def_cd") = color;
			check++;
		}

		if (sheetObj.CellValue(i, "rat_ut_cd") == "") {
			sheetObj.CellBackColor(i, "rat_ut_cd") = color;
			check++;
		}
		
		if (sheetObj.CellValue(i, "prc_cgo_tp_cd") == ""
				&& ComTrim(sheetObj.CellText(i, "prc_cgo_tp_cd")) != "") {
			sheetObj.CellBackColor(i, "prc_cgo_tp_cd") = color;
			check++;
		}

		if (sheetObj.CellValue(i, "curr_cd") == "" && ComTrim(sheetObj.CellText(i, "curr_cd")) != "" ) {
			sheetObj.CellBackColor(i, "curr_cd") = color;
			check++;
		}
		
		if (sheetObj.CellValue(i, "prop_frt_rt_amt") == ""
				|| sheetObj.CellValue(i, "prop_frt_rt_amt").length > 10) {
			sheetObj.CellBackColor(i, "prop_frt_rt_amt") = color;
			check++;
		}
		
		// Term 이 Door 가 아니고, b.port와 point 에 동일 Code 가 입력 된 경우  validation 이 필요
		if (sheetObj.CellValue(i, "rcv_de_term_cd") != "D" 
			&& (sheetObj.CellValue(i, "rout_pnt_loc_def_cd") == sheetObj.CellValue(i, "bse_port_def_cd"))) {
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
 * @author 최성민
 * @version 2009.05.17
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
		/*
		if (sheetObj.CellValue(i, "cust_def_cd") == "0") {
			sheetObjects[0].CellBackColor(arbSeq, "cust_def_cd") = color;
			check++;
		} else {
			custDefCd		= sheetObjects[0].CellValue(arbSeq, "cust_def_cd");	
			if(custDefCd != "") {
				sheetObjects[0].CellValue2(arbSeq, "cust_cnt_cd") 	= custDefCd.substring(0,2);
				sheetObjects[0].CellValue2(arbSeq, "cust_seq") 		= ComLpad(custDefCd.slice(2), 6, "0");
			}
		}
		*/
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
  * @author 최성민
  * @version 2009.07.31
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
				//ComBtnEnable("btn_file");
				//ComBtnEnable("btn_check");
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

/* 개발자 작업  끝 */