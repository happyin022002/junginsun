/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_4026.js
 *@FileTitle : Location Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.04.28 최성민
 * 1.0 Creation
=========================================================
* History
* 2011-07-15 서미진 [CHM-201112248] continent code, sub continent code도 조회 할 수 있도록 변경
========================================================= */

/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 사용예) ********************************************************************************
 *****************************************************************************************
 var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	 sUrl += "&group_cmd=" + PRI_SP_SCP;   											// (1) 
 	 sUrl += "&location_cmd=LG";													// (2)
 	 sUrl += "&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "loc_tp_cd"); 	// (3)
 	 sUrl += "&org_dest_cd=O"; 														// (4)
 	 sUrl += "&multi_yn=N"; 														// (5)

 var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 280, true);
 if (rtnVal != null){
	sheetObj.CellValue2(Row, "loc_cd") = rtnVal.cd;
	sheetObj.CellValue2(Row, "loc_nm") = rtnVal.nm;
	sheetObj.CellValue2(Row, "loc_tp") = rtnVal.tp;
 )
 ==========================================================================================
 (1) 현재화면에 맞는 상수를 선택한다.
 	 PRI_RG          = 0;  // RFA Guideline
 	 PRI_RP_SCP      = 1;  // RFA Proposal
 	 PRI_SG          = 2;  // S/C Guideline
 	 PRI_SP_SCP      = 3;  // S/C Proposal
 	 PRI_CMPB      	 = 5;  // CMPB Guideline
 	 PRI_SQ      	 = 6;  // SQ Guideline
 	 PRI_RQ      	 = 7;  // RQ Guideline
 
 (2) LOCATION TYPE을 선택(다중선택)예)"LGTCR"
	 L:Location
	 G:Group Location
	 T:State
	 C:Country
	 R:Region
 (3) 화면에서 선택한 LOCATION TYPE에 맞는 화면을 보여주기 위해 사용 
     (데이터가 없을 경우 DEFAULT:(2)번의 첫번째 TYPE에 해당하는 화면)
 
 (4) RFA에서 사용(LOCATION CODE) - 메인화면에서 받음
 (5) TRI GRI에서만 사용됨(멀티선택) - 메인화면에서 받음
 ==========================================================================================
*/



/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class ESM_PRI_4026 : ESM_PRI_4026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_4026() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;



// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2009.10.28
 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	//Location
	var sheetObject1 = sheetObjects[0];
	//Group Location
	var sheetObject2 = sheetObjects[1];
	//State
	var sheetObject3 = sheetObjects[2];
	//Region
	var sheetObject4 = sheetObjects[3];
	//Country
	var sheetObject5 = sheetObjects[4];	
	//Conti.
	var sheetObject6 = sheetObjects[5];
	//Sub conti.
	var sheetObject7 = sheetObjects[6];
	
	//Group Location
	var comboObject1 = comboObjects[0];
	//State
	var comboObject2 = comboObjects[1];
	//Region
	var comboObject3 = comboObjects[2];


	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		/** Radio Tab [ Location ] (S) * */
		case "btn_t1Retrieve":
			
			if (validateForm(sheetObject1,document.form,IBSEARCH)) {
				doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			}			
			break;

		case "btn_t1New":
			//폼객체 리셋
			ComClearManyObjects(formObject.loc_cd, formObject.loc_nm);
			//IBSHEET 리셋
			sheetObject1.RemoveAll();
			break;
		/** Radio Tab [ Location ] (E) * */

		/** Radio Tab [ Group Location ] (S) * */
		case "btn_t2Retrieve":
			if (validateForm(sheetObject2,document.form,IBSEARCH)) {
				
				doActionIBSheet(sheetObject2,document.form,IBSEARCH);
			}	
			break;

		case "btn_t2New":
			//폼객체 리셋
			ComClearManyObjects(formObject.combo_grp_loc_nm);
			//IBSHEET 리셋
			sheetObject2.RemoveAll();
			comboObject1.Index= "-1";
			break;
		/** Radio Tab [ Group Location ] (E) * */

		/** Radio Tab [ State ] (S) * */
		case "btn_t3Retrieve":
			if (validateForm(sheetObject3,document.form,IBSEARCH)) {
				doActionIBSheet(sheetObject3,document.form,IBSEARCH);
			}		
			break;

		case "btn_t3New":
			//폼객체 리셋
			ComClearManyObjects(formObject.ste_cd, formObject.ste_nm, formObject.combo_cnt_nm);
			
			//IBSHEET 리셋
			sheetObject3.RemoveAll();
			comboObject2.Index= "-1";
			break;
		/** Radio Tab [ State ] (E) * */

		/** Radio Tab [ Region ] (S) * */
		case "btn_t4Retrieve":
			if (validateForm(sheetObject4,document.form,IBSEARCH)) {
				doActionIBSheet(sheetObject4,document.form,IBSEARCH);
			}
			break;

		case "btn_t4New":
			//폼객체 리셋
			ComClearManyObjects(formObject.rgn_cd, formObject.rgn_nm, formObject.combo2_cnt_nm);
			sheetObject4.RemoveAll();
			comboObject3.Index= "-1";
			break;
		/** Radio Tab [ Region ] (E) * */

		/** Radio Tab [ Country ] (S) * */
		case "btn_t5Retrieve":
			if (validateForm(sheetObject5,document.form,IBSEARCH)) {				
				doActionIBSheet(sheetObject5,document.form,IBSEARCH);
			}
			break;

		case "btn_t5New":
			//폼객체 리셋
			ComClearManyObjects(formObject.cnt_cd, formObject.cnt_nm);
			//IBSHEET 리셋
			sheetObject5.RemoveAll();
			
			break;
		/** Radio Tab [ Country ] (E) * */
			
		/** Radio Tab [ Conti. ] (S)   * */
		case "btn_t6Retrieve":
			if (validateForm(sheetObject6,document.form,IBSEARCH)) {	
				doActionIBSheet(sheetObject6,document.form,IBSEARCH);
			}
			break;

		case "btn_t6New":
			//IBSHEET 리셋
			sheetObject6.RemoveAll();			
			break;
		/** Radio Tab [ Conti ] (E) * */	
	
		/** Radio Tab [ Sub conti. ] (S) * */
		case "btn_t7Retrieve":
			if (validateForm(sheetObject7,document.form,IBSEARCH)) {				
				doActionIBSheet(sheetObject7,document.form,IBSEARCH);
			}
			break;

		case "btn_t7New":
			//폼객체 리셋
			ComClearManyObjects(formObject.sconti_cd, formObject.sconti_nm);
			//IBSHEET 리셋
			sheetObject7.RemoveAll();		
			break;
		/** Radio Tab [ Sub conti. ] (E) * */				
			

		case "btn_OK":
			
			if(formObject.multi_yn.value != "Y") {
				returnButtonSheetData(formObject);		
			} else {
				returnButtonSheetDataMulti(formObject);	
			}
			break;

		case "btn_Close":
			window.close();
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
 * @version 2009.10.28
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* IBCombo Object를 배열로 등록 <br>
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
* 배열은 소스 상단에 정의 <br>
* <br><b>Example :</b>
* <pre>
*     setComboObject(comboObj);
* </pre>
* @param {ibcombo} combo_obj 필수 IBCombo Object
* @return 없음
* @author 최성민
* @version 2009.10.28
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
* 현재창을 resize 한다.
* @param weight
* @param height
* @return 없음
* @author 최성민
* @version 2009.10.28
*/
function reSize(weight, height)
{
    dialogWidth = getWidth(weight) + 'px';
    dialogHeight = getHeight(height) + 'px';
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
	var formObj = document.form;
	//reSize(700,353);
	//reSize(700,375);

	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		
		if(formObj.multi_yn.value != "Y") {
			sheetObjects[i].InitDataProperty2(0, 1, dtHidden, "width=40; data-align=daCenter");
	    }
		
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//IBMultiCombo초기화
    for(var k = 0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }

    //html컨트롤 이벤트초기화
    initControl();
    initRadioCheck();

    if(formObj.loc_nm.value != "" && ComGetObjValue(formObj.radio_type) == "1") {
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
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
 * @version 2009.05.22
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch (sheetid) {
	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 120;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|Code|Description|S-Conti.|Region|sconti_nm";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"Status");
            InitDataProperty(0, cnt++, dtDummyCheck, 	40,   	daCenter,  	true,	"chk");
			InitDataProperty(0, cnt++, dtSeq, 			30, 	daCenter, 	false, 	"Seq");
			InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	"loc_cd",	false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			280, 	daLeft, 	false, 	"loc_nm", 	false, "", dfNone, 0, false, true, 20);
			InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	false, 	"sconti_cd",false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	false, 	"rgn_cd", 	false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 		70, 	daCenter, 	false, 	"sconti_nm");
			
			EditableColorDiff = false;
		}
		break;

	case "sheet2":
		with (sheetObj) {

			// 높이 설정
			style.height = 120;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|Code|Description|S-Conti.|Region|";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "Status");
            InitDataProperty(0, cnt++, dtDummyCheck,   		40,   	daCenter,  	false,	"chk");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 350, daLeft, false, "loc_nm", false, "", dfNone, 0, false, true, 20);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "sconti_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rgn_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "zip_cd");
			
			EditableColorDiff = false;
		}
		break;

	case "sheet3":
		with (sheetObj) {

			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|Country|Code|Description|Continent|S-Conti.";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "Status");
            InitDataProperty(0, cnt++, dtDummyCheck,   		40,   	daCenter,  	false,	"chk");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "combo_cnt_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "ste_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 300, daLeft, false, "ste_nm", false, "", dfNone, 0, false, true, 20);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "conti_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "sconti_cd", false, "", dfNone, 0, false, true);

			EditableColorDiff = false;
		}
		break;

	case "sheet4":
		with (sheetObj) {

			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|Code|Description|Continent|S-Conti.";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "Status");
            InitDataProperty(0, cnt++, dtDummyCheck,   		40,   	daCenter,  	false,	"chk");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "rgn_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 320, daLeft, false, "rgn_nm", false, "", dfNone, 0, false, true, 20);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "conti_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "sconti_cd", false, "", dfNone, 0, false, true);

			EditableColorDiff = false;
		}
		break;

	case "sheet5":
		with (sheetObj) {

			// 높이 설정
			style.height = 120;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|Code|Description|Continent|S-Conti.";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,"Status");
            InitDataProperty(0, cnt++, dtDummyCheck,   		40,   	daCenter,  	false,	"chk");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cnt_cd",false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 400, daLeft, false, "cnt_nm", false, "", dfNone, 0, false, true, 20);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "conti_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "sconti_cd", false, "", dfNone, 0, false, true);

			EditableColorDiff = false;
		}
		break;

	case "sheet6":	// Conti.
		with (sheetObj) {		
			// 높이 설정
			style.height = 120;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle = "|Sel.|Seq.|Conti Code|Conti Description";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++, dtHiddenStatus,		30,		daCenter,		false,	"Status");
            InitDataProperty(0, cnt++, dtDummyCheck, 	30,   	daCenter,  	false,	"chk");
			InitDataProperty(0, cnt++, dtSeq, 				30, 	daCenter, 	false, 	"Seq");
			InitDataProperty(0, cnt++, dtData, 				100, 	daCenter, 	false, 	"conti_cd",	false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 				200, 	daLeft, 		false, 	"conti_nm", 	false, "", dfNone, 0, false, true);

			EditableColorDiff = false;
		}
		break;
		
	case "sheet7":	// Sub conti.
		with (sheetObj) {

			// 높이 설정
			style.height = 120;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|Sub conti Code|Sub conti Description";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,		30,		daCenter,		false,	"Status");
            InitDataProperty(0, cnt++, dtDummyCheck, 	40,   	daCenter,  	false,	"chk");
			InitDataProperty(0, cnt++, dtSeq, 				30, 	daCenter, 	false, 	"Seq");
			InitDataProperty(0, cnt++, dtData, 				100, 	daCenter, 	false, 	"sconti_cd",	false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 				280, 	daLeft, 		false, 	"sconti_nm", 	false, "", dfNone, 0, false, true);
			
			EditableColorDiff = false;
		}
		break;

	}
}
 
/**
 * 콤보 초기화모듈을 구성한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initCombo(comboObj, comboNo);
 * </pre>
 * @param {ibcombo} combo_obj 필수 IBCombo Object
 * @param {int} comboNo 필수 IBCombo Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 최성민
 * @version 2009.05.22
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "combo_cnt_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "white";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            	UseAutoComplete = true;
            	IMEMode = 0;
            	ValidChar(2, 0);
                MaxLength = 2;      // 2자리만 입력
            }
            break;
            
        case "combo2_cnt_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "white";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            	UseAutoComplete = true;
            	IMEMode = 0;
            	ValidChar(2, 0);
                MaxLength = 2;      // 2자리만 입력
            }
            break;
            
        case "combo_grp_loc_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "cyan";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            	UseAutoComplete = true;
            	IMEMode = 0;
            	ValidChar(2, 0);
                MaxLength = 4;      // 4자리만 입력
            }
            break;
    }
}

/**
* 업무 자바스크립트 이벤트함수를 초기화 한다. <br>
* <br><b>Example :</b>
* <pre>
*     initCombo(comboObj, comboNo);
* </pre>
* @return 없음
* @author 최성민
* @version 2009.05.22
*/
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch 
    axon_event.addListener ('keypress', 'engnum_keypress', 'loc_cd','ste_cd','cnt_cd','rgn_cd', 'sconti_cd');
	
    //Axon 이벤트 처리1. 이벤트catch 
    axon_event.addListener ('click', 'obj_OnClick', 'radio_type');
    axon_event.addListener ('keyup', "getKeyEnter('LengthNextFocus')", document.form);
    axon_event.addListener ('keydown', 'getKeyEnter', 'form');
}

/**
 * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2009.05.22
 */
function engnum_keypress() {
    //영대문자 자동변환
    ComKeyOnlyAlphabet('uppernum');
}
 
 /**
 * HTML태그(Object)의 onKeyDown 이벤트에서 이 함수를 호출할수 있으며, Enter키를 눌렀을때 자동화 기능을 처리한다. <br>
 * 인자로 사용되는 sFlag 인자의 설정값은 다음과 같다. <br>
 * sFlag = 설정안한경우      : sFlag="Search"의 경우와 동일하게 처리한다.<br>
 * sFlag = "Search"          : Enter키가 누르면 조회버튼(btn_Retrieve 또는 btn_retrieve)이 눌린것처럼 처리한다.OnKeyDown에서 호출할것!<br>
 * sFlag = "NextFocus"       : Enter키를 누르면 Tab키를 누른것 처럼 다음 입력필드로 포커스를 이동한다.OnKeyDown에서 호출할것!<br>
 * sFlag = "LengthNextFocus" : 입력필드의 maxlength길이만큼 모두 입력되면 자동으로 포커스를 다음으로 이동하고, Enter키를 누르면 길이에 관계없이 Tab을 누른것처럼 옆으로 이동한다. OnKeyUp에서 호출할 것!<br>
 * sFlag = Function명문자열  : 특정Function명 문자열을 인자로 받아서 Enter키를 누르면 해당 함수를 호출한다. OnKeyDown에서 호출할 것!<br>
 * sFlag = "LengthNextFocus"는 OnKeyUp이벤트에서 호출하여야 하고, 나머지는 모두 OnKeyDown이벤트에서 호출해야 한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     &lt;form name="form" onKeyDown="ComKeyEnter()"&gt; 					//조회조건Form에서 주로 사용
 *     &lt;form name="form" onKeyDown="ComKeyEnter('NextFocus')"&gt;		//저장Form에서 주로 사용
 *     &lt;form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')"&gt;	//저장Form에서 주로 사용
 * </pre>
 * @param {string} sFlag 선택,키처리 구분, default="Search"
 * @see #ComSetNextFocus
 */
function getKeyEnter(sFlag)
{
	 var formObj = document.form;
	 var radioType = ComGetObjValue(formObj.radio_type);
	 
    try {
    	var keyValue = null;
    	if(event == undefined || event == null) {
    		keyValue = 13;
    	}else {
    		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	}

       if (sFlag==undefined || sFlag==null || sFlag.constructor!=String || sFlag.trim() == "") sFlag="search";
       
       switch(sFlag.toLowerCase()) {
        	case "search" :
        		//Enter키를 누르면 조회버튼을 눌린것 처럼 처리
        		if (keyValue != 13) return;
        		var obj = document.getElementById("btn_Retrieve");
        		
        		if(radioType == "1") {
        			obj = document.getElementById("btn_t1Retrieve");
        		} else if(radioType == "2") {
        			obj = document.getElementById("btn_t2Retrieve");
        		} else if(radioType == "3") {
        			obj = document.getElementById("btn_t3Retrieve");
        		} else if(radioType == "4") {
        			obj = document.getElementById("btn_t4Retrieve");
        		} else if(radioType == "5") {
        			obj = document.getElementById("btn_t5Retrieve");
        		} else if(radioType == "6") {
        			obj = document.getElementById("btn_t6Retrieve");
        		} else if(radioType == "7") {
        			obj = document.getElementById("btn_t7Retrieve");
        		}     
        		
        		if (obj==null) obj = document.getElementById("btn_retrieve");
        		if (obj) obj.fireEvent("onclick");
        		break;
       		
        	case "nextfocus":
        		//Enter키를 누르면 Tab키를 누른것 처럼 처리
        		if (keyValue == 13) event.keyCode = 9;
        		break;

        	case "lengthnextfocus":
        		//입력필드는 maxlength만큼 모두 입력하면 Enter키를 누르지 않아도 자동이동하고,
        		//그외의 경우 Enter키를 누르면 Tab키를 누른것 처럼 처리
			        var iMaxLen=event.srcElement.getAttribute("maxLength");
			        var sValue =event.srcElement.getAttribute("value");
			        var bFocusProcess = false;
			        
			        //Enter키를 눌렀을 때
			        if (keyValue == 13)  {
			        	//Enter키를 누른것이 IBSheet가 아닌 경우만 처리한다.
			        	if (event.srcElement.classid != CLSID_IBSHEET) {
				        	bFocusProcess=true;
				        }
			        //iMaxLen 속성이 없거나 Value 속성이 없는것들은 처리하지 않는다.
			        } else if(iMaxLen!=null && sValue!=null) {
				        //ComDebug(iMaxLen+"=="+sValue.lengthByte());
	
			            if(iMaxLen==sValue.lengthByte()){
			                //if(!((keyValue==37)||(keyValue==39)||(keyValue==46)||(keyValue==8)||(keyValue==9))){
			                //참고:http://cdmanii.tistory.com/153
			                if (!((keyValue>=8   && keyValue<=40)  ||  //BackSpace~아래방향키키
			                      (keyValue>=45  && keyValue<=46)  ||  //Insert,Delete키
			                      (keyValue>=91  && keyValue<=93)  ||  //기능키
			                      (keyValue>=112 && keyValue<=123) ||  //F1~F12키
			                      (keyValue>=144 && keyValue<=145) )) {//NumLock,ScrollLock
			                	
					            bFocusProcess=true;
			                }
			            } 
			        } 
		            
		            //포커스를 다음 컨트롤로 옮기는 처리를 해야 하는 경우
		            if (bFocusProcess)  ComSetNextFocus();

        	default :
        		//Enter키를 누르면 sFlag 명의 자바스크립트 함수를 호출 한다.
        	    if (keyValue==13 && ComFuncCheck(sFlag)) ComFunc();

        }

    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj 필수 IBCombo Object
 * @param {string} code 필수 OnChange 이벤트가 발생한 combo code값
 * @param {string} text 필수 OnChange 이벤트가 발생한 combo name값
 * @return 없음
 * @author 최성민
 * @version 2009.06.25
 */  
function combo_cnt_cd_OnChange(comboObj, code, text) {
	var formObj = document.form;
	
	if(code != "") {
		comboObj.Code = code;
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.combo_cnt_nm.value = arrText[1];
			formObj.ste_cd.focus();
		} else {
			formObj.combo_cnt_nm.value = comboObj.GetText(code,1);
		}
	} else {
		formObj.combo_cnt_nm.value = "";
	}
	
}
 /**
  * OnFocus 이벤트 발생시 호출되는 function <br>
  * 콤보 코드를 공백으로 세팅한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {ibcombo} comboObj 필수 IBCombo Object
  * @return 없음
  * @author 최성민
  * @version 2009.06.25
  */  
function combo_cnt_cd_OnFocus(comboObj) {
	comboObj.Code = -1;
}

/**
* OnChange 이벤트 발생시 호출되는 function <br>
* Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibcombo} comboObj 필수 IBCombo Object
* @param {string} code 필수 OnChange 이벤트가 발생한 combo code값
* @param {string} text 필수 OnChange 이벤트가 발생한 combo name값
* @return 없음
* @author 최성민
* @version 2009.06.25
*/  
function combo2_cnt_cd_OnChange(comboObj, code, text) {
	var formObj = document.form;
	if(code != "") {	
		comboObj.Code = code;
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.combo2_cnt_nm.value = arrText[1];
			formObj.rgn_cd.focus();
		} else {
			formObj.combo2_cnt_nm.value = comboObj.GetText(code,1);
		}
	} else {
		formObj.combo2_cnt_nm.value = "";
	}
	
}
/**
* OnFocus 이벤트 발생시 호출되는 function <br>
* 콤보 코드를 공백으로 세팅한다. <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibcombo} comboObj 필수 IBCombo Object
* @return 없음
* @author 최성민
* @version 2009.06.25
*/ 
function combo2_cnt_cd_OnFocus(comboObj) {
	comboObj.Code = -1;
}
/**
* OnChange 이벤트 발생시 호출되는 function <br>
* Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibcombo} comboObj 필수 IBCombo Object
* @param {string} code 필수 OnChange 이벤트가 발생한 combo code값
* @param {string} text 필수 OnChange 이벤트가 발생한 combo name값
* @return 없음
* @author 최성민
* @version 2009.06.25
*/  
function combo_grp_loc_cd_OnChange(comboObj, code, text) {
	var formObj = document.form;
	try{	
		
		//CMPB GUIDELINE 일경우에는 키가3개-별도작업필요
		if(formObj.group_cmd.value == PRI_CMPB) {
			var arrKey = code.split("|");
			if (arrKey != null && arrKey.length > 1) {
				code = arrKey[0];
				formObj.cre_ofc_cd.value = arrKey[1];
				formObj.gline_seq.value = arrKey[2];
			}
		}
		
		if(code != "") {			
			comboObj.Code = code;
			var arrText = text.split("|");
			if (arrText != null && arrText.length > 1) {
				formObj.combo_grp_loc_nm.value = arrText[1];
				formObj.grp_loc_seq.value = code;
			} else {
				formObj.combo_grp_loc_nm.value = formObj.combo_grp_loc_cd.GetText(code,1);	
				formObj.grp_loc_seq.value = code;
			}
			
			if (validateForm(sheetObjects[1],document.form,IBSEARCH)) {
		 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		 		
		 		formObj.combo_grp_loc_cd.focus();
 			}
		} else {
			formObj.combo_grp_loc_nm.value = "";
		}
	}catch(e){}	
}

/**
* 업무 자바스크립트 OnClick 이벤트 처리
* 
* group_cmd 의 타입구분: 부모창에서 그룹타입을 받아야한다.<br>
* SP_SCP : S/C Proposal<br>
* RG : RFA Guideline<br>
* SG : S/C Guideline<br>
* RP_SCP :RFA Proposal<br>
* SCG : Surcharge<br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
* @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
* @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
* @param {string} Value 필수 cell 값
* @return 없음
* @author 최성민
* @version 2009.06.25
*/ 
function obj_OnClick(sheetObj,Row, Col, Value) {
	var formObj = document.form;
	var objs = document.form.group_cmd.value;	 
	if(event.srcElement.value == "1") {
		ComSetObjValue(formObj.loc_cd,"");
		ComSetObjValue(formObj.loc_nm,"");
		sheetObjects[0].RemoveAll();
		
		document.getElementById("radioLayer1").style.display='inline';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
		
	} else if(event.srcElement.value == "2") {
		ComSetObjValue(formObj.combo_grp_loc_cd,"");
		ComSetObjValue(formObj.combo_grp_loc_nm,"");
		sheetObjects[1].RemoveAll();
		
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='inline';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
		
		//GROUP LOCATION 경우에는 타입구분에 따라 조회하는 DB가 다르기 때문에 
		//group_cmd를 지정하여 각각 조회한다.
		if(objs == PRI_SP_SCP){
			document.form.f_cmd.value = SEARCH09;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RG){
			document.form.f_cmd.value = SEARCH10;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SG){
			document.form.f_cmd.value = SEARCH11;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RP_SCP){
			document.form.f_cmd.value = SEARCH12;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SCG){
			document.form.f_cmd.value = SEARCH13;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_CMPB){
			document.form.f_cmd.value = SEARCH19;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SQ){
			document.form.f_cmd.value = SEARCHLIST01;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RQ){
			document.form.f_cmd.value = SEARCHLIST03;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		}
		
		
		
	} else if(event.srcElement.value == "3") {
		ComSetObjValue(formObj.combo_cnt_cd,"");
		ComSetObjValue(formObj.combo_cnt_nm,"");
		ComSetObjValue(formObj.ste_cd,"");
		ComSetObjValue(formObj.ste_nm,"");
		sheetObjects[2].RemoveAll();
		
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='inline';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
		
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC10);
		
	} else if(event.srcElement.value == "4") {		
		ComSetObjValue(formObj.combo2_cnt_cd,"");
		ComSetObjValue(formObj.combo2_cnt_nm,"");
		ComSetObjValue(formObj.rgn_cd,"");
		ComSetObjValue(formObj.rgn_nm,"");
		sheetObjects[3].RemoveAll();
		
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='inline';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
		
		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC11);
		
	} else if(event.srcElement.value == "5") {
		ComSetObjValue(formObj.cnt_cd,"");
		ComSetObjValue(formObj.cnt_nm,"");
		sheetObjects[4].RemoveAll();
		
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='inline';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
	} else if(event.srcElement.value == "6") {
		sheetObjects[5].RemoveAll();
		
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='inline';
		document.getElementById("radioLayer7").style.display='none';
	} else if(event.srcElement.value == "7") {
		ComSetObjValue(formObj.sconti_cd,"");
		ComSetObjValue(formObj.sconti_nm,"");
		sheetObjects[6].RemoveAll();
		
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='inline';
	}
}

 /**
  * Sheet관련 프로세스 처리 <br>
  * group_cmd 의 타입구분: 부모창에서 그룹타입을 받아야한다. <br>
  * PRI_SP_SCP : S/C Proposal <br>
  * RG : RFA Guideline <br>
  * SG : S/C Guideline <br>
  * RP_SCP :RFA Proposal <br>
  * SCG : Surcharge <br>
  * <br><b>Example :</b>
  * <pre>
  *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
  * </pre>
  * @param {ibsheet} sheetObj 필수 IBSheet Object
  * @param {form} formObj 필수 html form object
  * @param {int} sAction 필수 프로세스 플래그 상수
  * @return 없음
  * @author 최성민
  * @version 2009.05.22
  */
function doActionIBSheet(sheetObj, formObj, sAction) {
	
	sheetObj.ShowDebugMsg = false;
	
	switch (sAction) {	
		case IBSEARCH_ASYNC10: // 화면 로딩시 Service Scope 조회
			formObj.f_cmd.value = SEARCH07;
			var sXml = sheetObj.GetSearchXml("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, formObj.combo_cnt_cd, "cd", "cd|nm");
			break;
			
		case IBSEARCH_ASYNC11: // 화면 로딩시 Service Scope 조회
			formObj.f_cmd.value = SEARCH08;
			var sXml = sheetObj.GetSearchXml("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, formObj.combo2_cnt_cd, "cd", "cd|nm");
			break;	
			
		case IBSEARCH_ASYNC12: // 화면 로딩시 Service Scope 조회
			var sXml = sheetObj.GetSearchXml("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, formObj.combo_grp_loc_cd, "grp_loc_seq", "cd|nm");
			break;	
	
			
		case IBSEARCH: // 조회
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1" && formObj.radio_type[0].checked) {
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
				} else if (sheetObj.id == "sheet2" && formObj.radio_type[1].checked) {
					// GROUP LOCATION				
					if(formObj.group_cmd.value == PRI_SP_SCP){
						formObj.f_cmd.value = SEARCH14;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
					} else if(formObj.group_cmd.value == PRI_RG){
						formObj.f_cmd.value = SEARCH15;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
					} else if(formObj.group_cmd.value == PRI_SG){
						formObj.f_cmd.value = SEARCH16;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
					} else if(formObj.group_cmd.value == PRI_RP_SCP){
						formObj.f_cmd.value = SEARCH17;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
					} else if(formObj.group_cmd.value == PRI_SCG){
						formObj.f_cmd.value = SEARCH18;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
					} else if(formObj.group_cmd.value == PRI_CMPB){
						formObj.f_cmd.value = SEARCH20;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
					} else if(formObj.group_cmd.value == PRI_SQ){
						formObj.f_cmd.value = SEARCHLIST02;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
					} else if(formObj.group_cmd.value == PRI_RQ){
						formObj.f_cmd.value = SEARCHLIST04;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
					}
				} else if (sheetObj.id == "sheet3" && formObj.radio_type[2].checked) {
					formObj.f_cmd.value = SEARCH03;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
				} else if (sheetObj.id == "sheet4" && formObj.radio_type[3].checked) {
					formObj.f_cmd.value = SEARCH04;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
				} else if (sheetObj.id == "sheet5" && formObj.radio_type[4].checked) {
					formObj.f_cmd.value = SEARCH05;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
				} else if (sheetObj.id == "sheet6" && formObj.radio_type[5].checked) {
					formObj.f_cmd.value = SEARCHLIST05;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
				} else if (sheetObj.id == "sheet7" && formObj.radio_type[6].checked) {
					formObj.f_cmd.value = SEARCHLIST06;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj));
				} 
				
			}
			
			break;
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
	
	if (sheetObj.id == "sheet1" && formObj.radio_type[0].checked) {
			
		if (formObj.loc_cd.value == "" && formObj.loc_nm.value =="") {
			ComShowCodeMessage("PRI00117", "2");
			formObj.loc_cd.focus();
			return false;
		} else if ( formObj.loc_cd.value != "" && formObj.loc_cd.value.length < 2) {	
			ComShowCodeMessage("PRI00117", "2");
			formObj.loc_cd.focus();
			return false;
		} else {
			if(formObj.loc_nm.value != "" && formObj.loc_nm.value.length < 3 ) {
				ComShowCodeMessage("PRI00117", "3");
				formObj.loc_nm.focus();
				return false;
			}
		}	
		
	} else if (sheetObj.id == "sheet2" && formObj.radio_type[1].checked) {
		
		if(comboObjects[0].Code == "" ) {
			ComShowCodeMessage("PRI00316","Code");
			return false;
		}
		
	} else if (sheetObj.id == "sheet3" && formObj.radio_type[2].checked) {		
		if(comboObjects[1].Code == "" ) {
			ComShowCodeMessage("PRI00316","Country Code");
			return false;
		}
		
		if ( !ComIsEmpty(formObj.ste_nm) &&  (formObj.ste_nm.value.length < 3 ||  formObj.ste_nm.value.length > 30)) {	
			ComShowCodeMessage("PRI00117", "3");
			return false;
		}
	} else if (sheetObj.id == "sheet5" && formObj.radio_type[4].checked) {
		
		if ( !ComIsEmpty(formObj.cnt_cd) && formObj.cnt_cd.value.length < 2 ) {	
			ComShowCodeMessage("PRI00117", "2");
			
			return false;
		} else if ( !ComIsEmpty(formObj.cnt_nm) && (formObj.cnt_nm.value.length < 3 || formObj.cnt_nm.value.length > 30)) {
			ComShowCodeMessage("PRI00117", "3");
			return false;
		}
	} else if (sheetObj.id == "sheet4" && formObj.radio_type[3].checked) {
		if(comboObjects[2].Code == "" ) {
			ComShowCodeMessage("PRI00316","Country Code");
			return false;
		}
		
		if ( !ComIsEmpty(formObj.rgn_cd) &&  (formObj.rgn_cd.value.length < 2 || formObj.rgn_cd.value.length > 3)) {	
			ComShowCodeMessage("PRI00117","2");
			return false;
		} else if ( !ComIsEmpty(formObj.rgn_nm) &&  (formObj.rgn_nm.value.length < 3 ||  formObj.rgn_nm.value.length > 30)) {	
			ComShowCodeMessage("PRI00117", "3");
			return false;
		}
	}
	
	return true;
}


 /**
  * opener로 값을 리턴하는 기능 구현<br>
  * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,<br>
  * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.<br>
  * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.<br>
  * 둘중 하나만 사용한다 .<br>
  * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
  * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
  * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
  * @return 없음
  * @author 최성민
  * @version 2009.05.19
  */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var multiYn = formObj.multi_yn.value;
	var array = new Array(); 
	var obj = new Object();
    try{    	
    	 obj.cd = sheetObj.CellValue(Row, "loc_cd");
    	 obj.nm = sheetObj.CellValue(Row, "loc_nm");
    	 obj.sconti_cd = sheetObj.CellValue(Row, "sconti_cd");
 	   	 obj.sconti_nm = sheetObj.CellValue(Row, "sconti_nm");
 	   	 obj.zip_cd = sheetObj.CellValue(Row, "zip_cd");
    	 obj.tp = "L";
    	 
    	 if(multiYn != "Y") {
    		 window.returnValue = obj;
    	 } else {
    		 array[0] = obj;
    		 window.returnValue = array;
    	 }
    	 self.close();

    }catch(e){}    
}

 /**
  * opener로 값을 리턴하는 기능 구현<br>
  * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,<br>
  * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.<br>
  * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.<br>
  * 둘중 하나만 사용한다 .<br>
  * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
  * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
  * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
  * @return 없음
  * @author 최성민
  * @version 2009.05.19
  */
function sheet2_OnDblClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var multiYn = formObj.multi_yn.value; 
    var array = new Array();   	
  	var obj = new Object(); 

	try{
   	 obj.cd = formObj.combo_grp_loc_cd.text;
	 obj.nm = formObj.combo_grp_loc_nm.value;
   	 obj.tp = "G";

	 if(multiYn != "Y") {
		 window.returnValue = obj;
	 } else {
		 array[0] = obj;
		 window.returnValue = array;
	 }
	 self.close();

   }catch(e){}    
}

 /**
  * opener로 값을 리턴하는 기능 구현<br>
  * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,<br>
  * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.<br>
  * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.<br>
  * 둘중 하나만 사용한다 .<br>
  * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
  * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
  * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
  * @return 없음
  * @author 최성민
  * @version 2009.05.19
  */
function sheet3_OnDblClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var multiYn = formObj.multi_yn.value;  
	var array = new Array();   
  	var obj = new Object(); 

	try{   
	   	 obj.cd = sheetObj.CellValue(Row, "ste_cd");
	   	 obj.nm = sheetObj.CellValue(Row, "ste_nm");
	   	 obj.tp = "T";
	   	 
	   	 //STATE 코드는 CNT_CD+STE_CD로 구성해서 저장해야함. 화면상에 보여줄때는 STE_CD만 보여줌.
	   	 obj.cnt_cd = sheetObj.CellValue(Row, "combo_cnt_cd");

    	 if(multiYn != "Y") {
    		 window.returnValue = obj;
    	 } else {
    		 array[0] = obj;
    		 window.returnValue = array;
    	 }
    	 self.close();

	   }catch(e){}    
}

 /**
  * opener로 값을 리턴하는 기능 구현<br>
  * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,<br>
  * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.<br>
  * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.<br>
  * 둘중 하나만 사용한다 .<br>
  * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
  * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
  * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
  * @return 없음
  * @author 최성민
  * @version 2009.05.19
  */
function sheet4_OnDblClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var multiYn = formObj.multi_yn.value;  
	var array = new Array();   
  	var obj = new Object(); 

	try{    
	   	 obj.cd = sheetObj.CellValue(Row, "rgn_cd");
	   	 obj.nm = sheetObj.CellValue(Row, "rgn_nm");
	   	 obj.tp = "R";

    	 if(multiYn != "Y") {
    		 window.returnValue = obj;
    	 } else {
    		 array[0] = obj;
    		 window.returnValue = array;
    	 }
    	 self.close();
	   }catch(e){}    
}

/**
 * opener로 값을 리턴하는 기능 구현<br>
 * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,<br>
 * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.<br>
 * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.<br>
 * 둘중 하나만 사용한다 .<br>
 * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 최성민
 * @version 2009.05.19
 */
function sheet5_OnDblClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var multiYn = formObj.multi_yn.value;  
	var array = new Array();   
  	var obj = new Object(); 

	try{    	
	   	 obj.cd = sheetObj.CellValue(Row, "cnt_cd");
	   	 obj.nm = sheetObj.CellValue(Row, "cnt_nm");
	   	 obj.tp = "C";

    	 if(multiYn != "Y") {
    		 window.returnValue = obj;
    	 } else {
    		 array[0] = obj;
    		 window.returnValue = array;
    	 }
    	 self.close();
	   }catch(e){}    
}

/**
 * opener로 값을 리턴하는 기능 구현<br>
 * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,<br>
 * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.<br>
 * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.<br>
 * 둘중 하나만 사용한다 .<br>
 * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 최성민
 * @version 2009.05.19
 */
function sheet6_OnDblClick(sheetObj, Row, Col) {   // Conti.
	var formObj = document.form;
	var multiYn = formObj.multi_yn.value;  
	var array = new Array();   
  	var obj = new Object(); 

	try{    	
	   	 obj.cd = sheetObj.CellValue(Row, "conti_cd");
	   	 obj.nm = sheetObj.CellValue(Row, "conti_nm");
	   	 obj.tp = "O";

    	 if(multiYn != "Y") {
    		 window.returnValue = obj;
    	 } else {
    		 array[0] = obj;
    		 window.returnValue = array;
    	 }
    	 self.close();
	   }catch(e){}    
}

/**
 * opener로 값을 리턴하는 기능 구현<br>
 * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,<br>
 * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.<br>
 * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.<br>
 * 둘중 하나만 사용한다 .<br>
 * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 최성민
 * @version 2009.05.19
 */
function sheet7_OnDblClick(sheetObj, Row, Col) {			// Sub conti.
	var formObj = document.form;
	var multiYn = formObj.multi_yn.value;  
	var array = new Array();   
  	var obj = new Object(); 

	try{    	
	   	 obj.cd = sheetObj.CellValue(Row, "sconti_cd");
	   	 obj.nm = sheetObj.CellValue(Row, "sconti_nm");
	   	 obj.tp = "S";

    	 if(multiYn != "Y") {
    		 window.returnValue = obj;
    	 } else {
    		 array[0] = obj;
    		 window.returnValue = array;
    	 }
    	 self.close();
	   }catch(e){}    
}

 /**
 * radio combo를 초기화하는 함수 <br>
 * 메인에서 넘려온 값에 따라 radio combo에 체크한다. <br>
 * L : radio_type[0] : location<br>
 * G : radio_type[1] : Group location<br>
 * T : radio_type[2] : State<br>
 * R : radio_type[3] : Region<br>
 * C : radio_type[4] : Country<br>
 * <br><b>Example :</b>
 * <pre>
 *     initRadioCheck()
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2009.05.19
 */
function initRadioCheck(){
	
	var formObj = document.form;
	var prcCmdtTdCd = formObj.loc_tp_cd.value;
	var cmd = formObj.location_cmd.value;
	var arr = cmd.split("");
	var radio_cnt = formObj.radio_type.length;
	
	for(i=0; i<radio_cnt; i++) {
		formObj.radio_type[i].disabled = true;
	}
	
	if ( arr.length == 1 ) {
		document.getElementById("radioLayer0").style.display='none';
	} else if ( arr.length > 1 ) {
		document.getElementById("radioLayer0").style.display='inline';
	}
	
	for(i=0; i<arr.length; i++) {
		if(arr[i] == "L") {
			formObj.radio_type[0].disabled = false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[0].checked = true;
			} else if (i==0){
				formObj.radio_type[0].checked = true;
			}
		} else if(arr[i] == "G") {
			formObj.radio_type[1].disabled = false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[1].checked = true;
			} else if(i==0){
				formObj.radio_type[1].checked = true;
			}
		} else if(arr[i] == "T") {
			formObj.radio_type[2].disabled = false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[2].checked = true;
			} else if(i==0){
				formObj.radio_type[2].checked = true;
			}
		} else if(arr[i] == "R") {
			formObj.radio_type[3].disabled = false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[3].checked = true;
			} else if(i==0){
				formObj.radio_type[3].checked = true;
			}
		} else if(arr[i] == "C") {
			formObj.radio_type[4].disabled = false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[4].checked = true;
			} else if(i==0){
				formObj.radio_type[4].checked = true;
			}
		} else if(arr[i] == "O") {
			formObj.radio_type[5].disabled = false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[5].checked = true;
			} else if(i==0){
				formObj.radio_type[5].checked = true;
			}
		} else if(arr[i] == "S") {
			formObj.radio_type[6].disabled = false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[6].checked = true;
			} else if(i==0){
				formObj.radio_type[6].checked = true;
			}
		} 
	}
	//첫번째 layer를 display한다.
	if(prcCmdtTdCd != "") {
		showDivCheck(prcCmdtTdCd);
	} else {
		showDivCheck(arr[0]);
	}
	
}

 /**
 *  location_cmd에서 받아온 값들중에서 첫번째  layer를 display한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     showDivCheck(locationCmd)
 * </pre>
 * @param {string} locationCmd 메인화면에서 넘어온 값
 * @return 없음
 * @author 최성민
 * @version 2009.05.19
 */
function showDivCheck(locationCmd) {
	
	var objs = document.form.group_cmd.value;
	 
	if(locationCmd == "L") {
		document.getElementById("radioLayer1").style.display='inline';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
	} else if(locationCmd == "G") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='inline';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
		
		if(objs == PRI_SP_SCP){
			document.form.f_cmd.value = SEARCH09;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RG){
			document.form.f_cmd.value = SEARCH10;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SG){
			document.form.f_cmd.value = SEARCH11;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RP_SCP){
			document.form.f_cmd.value = SEARCH12;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SCG){
			document.form.f_cmd.value = SEARCH13;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_CMPB){
			document.form.f_cmd.value = SEARCH19;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SQ){
			document.form.f_cmd.value = SEARCHLIST01;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RQ){
			document.form.f_cmd.value = SEARCHLIST03;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		}
	} else if(locationCmd == "T") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='inline';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
		
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC10);
		
	} else if(locationCmd == "R") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='inline';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
		
		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC11);
	
	} else if(locationCmd == "C") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='inline';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='none';
	} else if(locationCmd == "O") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='inline';
		document.getElementById("radioLayer7").style.display='none';
	} else if(locationCmd == "S") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		document.getElementById("radioLayer6").style.display='none';
		document.getElementById("radioLayer7").style.display='inline';
	}
}

 /**
 * SHEET에서 선택된 값을 부모창으로 리턴한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     returnButtonSheetData(formObj);
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2009.05.19
 */
 function returnButtonSheetData(formObj) {
	var obj = new Object(); 
	var Row = 0;
	
	if(formObj.radio_type[0].checked){
		Row = sheetObjects[0].SelectRow;
	   	obj.cd = sheetObjects[0].CellValue(Row, "loc_cd");
	   	obj.nm = sheetObjects[0].CellValue(Row, "loc_nm");
	   	obj.sconti_cd = sheetObjects[0].CellValue(Row, "sconti_cd");
	   	obj.sconti_nm = sheetObjects[0].CellValue(Row, "sconti_nm");
	   	obj.tp = "L";
	   	
	} else if(formObj.radio_type[1].checked){
		obj.cd = formObj.combo_grp_loc_cd.text;
		obj.nm = formObj.combo_grp_loc_nm.value;
		obj.tp = "G";
	    
	} else if(formObj.radio_type[2].checked){
		Row = sheetObjects[2].SelectRow;
	   	obj.cd = sheetObjects[2].CellValue(Row, "ste_cd");
	   	obj.nm = sheetObjects[2].CellValue(Row, "ste_nm");
	   	obj.tp = "T";
	   	//STATE 코드는 CNT_CD+STE_CD로 구성해서 저장해야함. 화면상에 보여줄때는 STE_CD만 보여줌.
	   	obj.cnt_cd = sheetObjects[2].CellValue(Row, "combo_cnt_cd");
	   	
	} else if(formObj.radio_type[3].checked){
		Row = sheetObjects[3].SelectRow;
	   	obj.cd = sheetObjects[3].CellValue(Row, "rgn_cd");
	   	obj.nm = sheetObjects[3].CellValue(Row, "rgn_nm");
	   	obj.tp = "R";
	   		    
	} else if(formObj.radio_type[4].checked){
		Row = sheetObjects[4].SelectRow;
	   	obj.cd = sheetObjects[4].CellValue(Row, "cnt_cd");
	   	obj.nm = sheetObjects[4].CellValue(Row, "cnt_nm");	
	   	obj.tp = "C";
	} else if(formObj.radio_type[5].checked){
		Row = sheetObjects[5].SelectRow;
	   	obj.cd = sheetObjects[5].CellValue(Row, "conti_cd");
	   	obj.nm = sheetObjects[5].CellValue(Row, "conti_nm");	
	   	obj.tp = "O";
	} else if(formObj.radio_type[6].checked){
		Row = sheetObjects[6].SelectRow;
	   	obj.cd = sheetObjects[6].CellValue(Row, "sconti_cd");
	   	obj.nm = sheetObjects[6].CellValue(Row, "sconti_nm");	
	   	obj.tp = "S";
	}
	
	if ( formObj.radio_type[1].checked){
		if (formObj.combo_grp_loc_cd.text !=""){
			window.returnValue = obj;
			self.close();
		}else{
			ComShowCodeMessage("PRI00310");
		}

	}else{
		if(Row > 0) {
		    window.returnValue = obj;
		    self.close();
		} else {
			ComShowCodeMessage("PRI00310");
		}
	}
 }
 
/**
 * SHEET에서 선택된 값을 부모창으로 리턴한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     returnButtonSheetData(formObj);
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2009.05.19
 */
 function returnButtonSheetDataMulti(formObj) {
	 	var array = new Array();
		//var obj = new Object(); 
		//배열의 크기를 세팅한다.
		var arrayCnt = 0;
		
		if(formObj.radio_type[0].checked){
			// 선택된 ROW 리스트
			var chkArr = ComPriSheetCheckedRows(sheetObjects[0], "chk");
			if(chkArr.length == 0){
				sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObjects[0], "chk");
			
			for(var i=0;i < chkArr.length;i++){
				var obj = new Object(); 
				obj.cd = sheetObjects[0].CellValue(chkArr[i], "loc_cd");
			   	obj.nm = sheetObjects[0].CellValue(chkArr[i], "loc_nm");
			   	obj.sconti_cd = sheetObjects[0].CellValue(chkArr[i], "sconti_cd");
			   	obj.sconti_nm = sheetObjects[0].CellValue(chkArr[i], "sconti_nm");
			   	obj.tp = "L";
							
			   	array[arrayCnt]= obj;
				arrayCnt++;
			}
		} else if(formObj.radio_type[1].checked){
			var obj = new Object(); 
			obj.cd = formObj.combo_grp_loc_cd.text;
			obj.nm = formObj.combo_grp_loc_nm.value;
			obj.tp = "G";
			
			array[arrayCnt]= obj;
		} else if(formObj.radio_type[2].checked){
			// 선택된 ROW 리스트
			var chkArr = ComPriSheetCheckedRows(sheetObjects[2], "chk");
			if(chkArr.length == 0){
				sheetObjects[2].CellValue2(sheetObjects[2].SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObjects[2], "chk");
			
			for(var i=0;i < chkArr.length;i++){
				var obj = new Object(); 
				obj.cd = sheetObjects[2].CellValue(chkArr[i], "ste_cd");
			   	obj.nm = sheetObjects[2].CellValue(chkArr[i], "ste_nm");
			   	obj.tp = "T";
			   	//STATE 코드는 CNT_CD+STE_CD로 구성해서 저장해야함. 화면상에 보여줄때는 STE_CD만 보여줌.
			   	obj.cnt_cd = sheetObjects[2].CellValue(chkArr[i], "combo_cnt_cd");
				
			   	array[arrayCnt]= obj;
				arrayCnt++;
			}		   	
		} else if(formObj.radio_type[3].checked){
			// 선택된 ROW 리스트
			var chkArr = ComPriSheetCheckedRows(sheetObjects[3], "chk");
			if(chkArr.length == 0){
				sheetObjects[3].CellValue2(sheetObjects[3].SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObjects[3], "chk");
			
			for(var i=0;i < chkArr.length;i++){
				var obj = new Object(); 
				obj.cd = sheetObjects[3].CellValue(chkArr[i], "rgn_cd");
			   	obj.nm = sheetObjects[3].CellValue(chkArr[i], "rgn_nm");
			   	obj.tp = "R";

			   	array[arrayCnt]= obj;
				arrayCnt++;
			}
		   		    
		} else if(formObj.radio_type[4].checked){
			// 선택된 ROW 리스트
			var chkArr = ComPriSheetCheckedRows(sheetObjects[4], "chk");
			if(chkArr.length == 0){
				sheetObjects[4].CellValue2(sheetObjects[4].SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObjects[4], "chk");
			
			for(var i=0;i < chkArr.length;i++){
				var obj = new Object(); 
				obj.cd = sheetObjects[4].CellValue(chkArr[i], "cnt_cd");
			   	obj.nm = sheetObjects[4].CellValue(chkArr[i], "cnt_nm");	
			   	obj.tp = "C";
			   	
			   	array[arrayCnt]= obj;
				arrayCnt++;
			}
		} else if(formObj.radio_type[5].checked){
			// 선택된 ROW 리스트
			var chkArr = ComPriSheetCheckedRows(sheetObjects[5], "chk");
			if(chkArr.length == 0){
				sheetObjects[5].CellValue2(sheetObjects[5].SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObjects[5], "chk");
			
			for(var i=0;i < chkArr.length;i++){
				var obj = new Object(); 
				obj.cd = sheetObjects[5].CellValue(chkArr[i], "conti_cd");
			   	obj.nm = sheetObjects[5].CellValue(chkArr[i], "conti_nm");	
			   	obj.tp = "O";
			   	
			   	array[arrayCnt]= obj;
				arrayCnt++;
			}
		} else if(formObj.radio_type[6].checked){
			// 선택된 ROW 리스트
			var chkArr = ComPriSheetCheckedRows(sheetObjects[6], "chk");
			if(chkArr.length == 0){
				sheetObjects[6].CellValue2(sheetObjects[6].SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObjects[6], "chk");
			
			for(var i=0;i < chkArr.length;i++){
				var obj = new Object(); 
				obj.cd = sheetObjects[6].CellValue(chkArr[i], "sconti_cd");
			   	obj.nm = sheetObjects[6].CellValue(chkArr[i], "sconti_nm");	
			   	obj.tp = "S";
			   	
			   	array[arrayCnt]= obj;
				arrayCnt++;
			}
		}
		
		if ( formObj.radio_type[1].checked){
			if (formObj.combo_grp_loc_cd.text !=""){
				window.returnValue = array;
				self.close();
			}else{
				ComShowCodeMessage("PRI00310");
			}

		}else{
			if(arrayCnt > 0) {
			    window.returnValue = array;
			    self.close();
			} else {
				ComShowCodeMessage("PRI00310");
			}
		}
	 }
 
/* 개발자 작업 끝 */