/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0219.js
 *@FileTitle : Inbound Domestic T/S Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013-11-01
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2013-11-01 김상수
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author CyberLogitec
 */

/**
 * @extends
 * @class : Inbound Domestic T/S Manifest 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function esm_bkg_0219() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
}

/* 개발자 작업    */

//공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var formObject = document.form;

//	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;

			case "btn_Downexcel":
				ComOpenWait(true);
				doActionIBSheet(sheetObjects[1], formObject, IBDOWNEXCEL);
				ComOpenWait(false);
				break;

		} // end switch
//	} catch(e) {
//		if( e == "[object Error]") {
//			ComShowMessage(OBJECT_ERROR);
//		} else {
//			ComShowMessage(e);
//		}
//	}
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
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
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
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++ , " Container Info." , -1 );
				InsertTab( cnt++ , " Customer Info." , -1 );
				InsertTab( cnt++ , " Special Cargo Detail " , -1 );
			}
			break;
	}
}


/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}

	//화면에서 필요한 이벤트
	axon_event.addListenerForm("FocusIn","obj_FocusIn", document.form);
	axon_event.addListenerForm("FocusOut","obj_FocusOut", document.form);
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener("keydown", "ComKeyEnter", "form");

	document.form.bkg_no.focus();
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {

		case "sheet1":
			with (sheetObj) {

				// 높이 설정
				style.height = GetSheetHeight(11);

				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 2, 100);

				var HeadTitle = "|Seq.|Container No.|TP|Seal No.|HS Code|Weight|Measure";
				var headCount = ComCountHeadTitle(HeadTitle);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,    false,    "ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,      30,    daCenter,    false,    "seq");
				InitDataProperty(0, cnt++ , dtData,         150,   daCenter,    false,    "cntr_no");
				InitDataProperty(0, cnt++ , dtData,         60,    daCenter,    false,    "cntr_tpsz_cd");
				InitDataProperty(0, cnt++ , dtData,         100,   daCenter,    false,    "cntr_seal_no");
				InitDataProperty(0, cnt++ , dtData,         100,   daCenter,    false,    "cmdt_hs_cd");
				InitDataProperty(0, cnt++ , dtData,         135,   daRight,     false,    "cntr_wgt");
				InitDataProperty(0, cnt++ , dtData,         95,    daRight,     false,    "cntr_meas");

				CountPosition = 0;
			}
		break;

		case "sheet2":    // Down Excel용 Hidden Sheet
			with (sheetObj) {

				// 높이 설정
				style.height = 0;
//				style.height = GetSheetHeight(10);

				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 2, 100);

				var HeadTitle = "|BARGE OPERATOR|B/L NO|POR|POL|T/S PORT|DEL|GROSS WEIGHT: KGS (UNDER 1 B/L)|TOTAL PACKAGES|TOTAL MEASURE|SHPR|CNEE|NTFY|MARKS|CARGO DESCRIPTION|ENGLISH COMMOIDTY NAME|CHINESE COMMODITY NAME|HS CODE|CNTR OWNER|CNTR NO|CNTR TYPE|SEAL NO|CNTR WEIGHT|CNTR MEASURE|STARTING TEMPERATURE|FIANL TEMPERATURE|CELSIUS/FAHRENHEIT|DG CLASS|UN NO|OVER DIMENSION/ FRONT|OVER DIMENSION/ REAR|OVER HEIGHT|OVER DIMENSION/ LEFT|OVER DIMENSION/ RIGHT";
				var headCount = ComCountHeadTitle(HeadTitle);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,    false,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "brg_opr");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "bkg_no");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "por_cd");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "pol_cd");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "pod_cd");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "del_cd");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "act_wgt");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "pck_qty");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "meas_qty");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "shpr");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cnee");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "ntfy");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "mk_desc");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cmdt_desc");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cmdt_nm");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cmdt_chn_nm");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cmdt_hs_cd");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cntr_owner");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cntr_no");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "sipgl_code");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cntr_seal_no");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cntr_wgt");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cntr_meas");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "rf_tmp");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "fnl_tmp");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "tmp_div");  // CELSIUS/FAHRENHEIT
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "dg_cls");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "dg_un");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "over_frnt");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "over_rear");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "over_hght");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "over_left");
				InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "over_rght");

				CountPosition = 0;
			}
		break;
	}
}


/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {

	switch(sAction) {

		case IBSEARCH:    // Retrieve
			if (!ComChkValid(formObj)) return;
			ComOpenWait(true);
			var tempBkgNo = formObj.bkg_no.value;
			formObj.f_cmd.value = SEARCH;
			var xmlArr = sheetObj.GetSearchXml("ESM_BKG_0219GS.do", FormQueryString(formObj)).split("|$$|");
			ComResetAll();    //기본 object 초기화
			sheetObj.RemoveEtcData();
			sheetObjects[0].LoadSearchXml(xmlArr[0]);
			if (xmlArr[1] != null) {
				with (sheetObjects[1]) {
					DataInsert(0);
					DataInsert(0);
					DataInsert(0);

					CellValue2(1, 1) = "COM INBOUND MANIFEST";
					CellValue2(1, 2) = "COM INBOUND MANIFEST";
					CellValue2(1, 3) = "COM INBOUND MANIFEST";
					RowMerge(1) =  true;

					CellValue2(2, 1) = "TRUNK VSL NAME";
					CellValue2(2, 3) = "VOYAGE";
					CellValue2(2, 5) = "TERMINAL";
					CellValue2(2, 7) = "POD ETA";
					var tmpArr = new Array(1, 3, 5, 7);
					for (var k in tmpArr) {
						CellBackColor(2, tmpArr[k]) = RgbColor(193,196,232);
						CellFontColor(2, tmpArr[k]) = RgbColor(39,95,101);
						CellFont("FontBold", 2, tmpArr[k]) = true;
					}

					var headTitleArray = GetRangeText(0, LeftCol, 0, LastCol).split("|");
					for (var i=0; i<headTitleArray.length; i++) {
						CellValue2(3, i+1) = headTitleArray[i];
					}
					RangeBackColor(3, LeftCol, 3, LastCol) = RgbColor(193,196,232);
					RangeFontColor(3, LeftCol, 3, LastCol) = RgbColor(39,95,101);
					RangeFontBold(3, LeftCol, 3, LastCol) = true;

					LoadSearchXml(xmlArr[1], true);
				}
			}
			formObj.bkg_no.value = tempBkgNo;
			ComOpenWait(false);
		break;

		case IBDOWNEXCEL:    // Downexcel
			if (sheetObjects[0].SearchRows < 1) return;
			with (sheetObj) {
				CellValue2(2, 2) = formObj.vsl_eng_nm.value;
				CellValue2(2, 4) = formObj.skd_voy_no.value;

				var sipglYdcd = ""; if (formObj.yd_cd.value.substring(0, 5) ==
				"CNSHA") { var comYdcd = formObj.yd_cd.value.substr(5); switch
				(comYdcd) { case "W1": sipglYdcd = "WGQ1"; break; case "GQ":
				sipglYdcd = "WGQ2"; break; case "W4": sipglYdcd = "WGQ4"; break;
				case "W5": sipglYdcd = "WGQ5"; break; case "YS": sipglYdcd =
				"YS01"; break; case "M1": sipglYdcd = "YS03"; break; default :
				sipglYdcd = formObj.yd_cd.value; break; } } else { sipglYdcd =
				formObj.yd_cd.value; } CellValue2(2, 6) = sipglYdcd;

				CellValue2(2, 8) = formObj.vps_eta_dt.value;

				for (var i=4; i<=LastRow; i++) {
					CellValue2(i, "cntr_owner") = formObj.cntr_owner.value;
					CellValue2(i, "pod_cd") = formObj.pod_cd.value;
					CellValue2(i, "brg_opr") = formObj.brg_opr.value;
					CellValue2(i, "cmdt_chn_nm") = formObj.cmdt_chn_nm.value;
					CellValue2(i, "rf_tmp") = formObj.rf_tmp.value;
					CellValue2(i, "fnl_tmp") = formObj.fnl_tmp.value;
					CellValue2(i, "tmp_div") = formObj.tmp_div.value;
					CellValue2(i, "dg_cls") = formObj.dg_cls.value;
					CellValue2(i, "dg_un") = formObj.dg_un.value;
					CellValue2(i, "over_frnt") = formObj.over_frnt.value;
					CellValue2(i, "over_rear") = formObj.over_rear.value;
					CellValue2(i, "over_hght") = formObj.over_hght.value;
					CellValue2(i, "over_left") = formObj.over_left.value;
					CellValue2(i, "over_rght") = formObj.over_rght.value;
				}
				Down2Excel(-1, false, false, true, "", "", false, false, "", false, "", "0");
			}
		break;
	}
}


/**
 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param {shtObj} String : 해당 IBSheet Object
 * @param {ErrMsg} String : 조회 후 메시지
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg != "") return;
	//조회된 ETC데이터를 Form내의 각각 오브젝트에 setting
	ComEtcDataToForm(document.form, sheetObj);
}


/**
 * Form 컨트롤에서 포커스인 시 데이터 처리
 */
function obj_FocusIn(){
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "temp") {
		srcObj.style.textAlign = "left";
		if(srcValue == "0.0"){
			srcObj.value = "";
		}
	}
}

/**
 * Form 컨트롤에서 포커스아웃 시 데이터 처리
 */
function obj_FocusOut(){
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "temp") {
		srcObj.style.textAlign = "right";
		if(srcValue == ""){
			srcObj.value = "0.0";
		}else{
			AddComma(srcObj,"#,###.#");
		}
	}
}

/**
 * 키보드 누를 때 Form 데이터 처리
 */
function obj_KeyUp() {
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "temp") {
		AddComma(srcObj,"#,###.##",srcMaxLength);
	}
}


/**
 * 문자열을 숫자포멧에 맞게 변경하여 리턴한다. 숫자포멧으로 설정할수 있는 값은 다음과 같다. <br>
 * <br>
 * @param {object,string}   obj      필수,숫자문자열 또는 HTML태그(Object)
 * @param {string}   		string   필수,포맷 스트링
 * @param {int}   			int      선택,HTML태그(Object)의 Maxlength
 * @returns string, 숫자포멧이 설정된 문자열<br>
 *          "":sVal인자의 값이 잘못된 경우 공백("")을 리턴한다.
 * @see #ComAddComma
 * @see #ComGetMaskedValue
 */
function AddComma(obj, sFormat, len){
	try {
		var sVal = obj.value.replace(/\,/g,"");
		switch(sFormat){
			case "#,###":
				obj.value = ComAddComma(sVal);
				break;
			case "#,###.#":
				if(sVal == ".") sVal = "0.";
				p = sVal.split(".");
				p[0] = ComAddComma(p[0]);
				if (p.length <= 1) obj.value = p[0]+".000";
				else if (p.length == 2) obj.value = p[0]+"."+p[1].substr(0,3);
				else if (p.length > 2) 	obj.value = p[0]+"."+p[1].substr(0,3);
				else sVal = "";
				break;
			case "#,###.##":
				if(sVal == ".") sVal = "0.";
				p = sVal.split(".");
				p[0] = ComAddComma(p[0]);
				if (p.length <= 1) {
					if(p[0].length > len-3) {
						sVal = p[0].substr(0, len-3).replace(/\,/g,"");
						p[0] = ComAddComma(sVal);
					}
					obj.value = p[0];
				}
				else if (p.length == 2) obj.value = p[0]+"."+p[1].substr(0,2);
				else if (p.length > 2) obj.value = p[0]+"."+p[1].substr(0,2);
				else sVal = "";
				break;
			case "#,###.###":
				if(sVal == ".") sVal = "0.";
				p = sVal.split(".");
				p[0] = ComAddComma(p[0]);
				if (p.length <= 1) {
					if(p[0].length > len-4) {
						sVal = p[0].substr(0, len-3).replace(/\,/g,"");
						p[0] = ComAddComma(sVal);
					}
					obj.value = p[0];
				}
				else if (p.length == 2) obj.value = p[0]+"."+p[1].substr(0,3);
				else if (p.length > 2) obj.value = p[0]+"."+p[1].substr(0,3);
				else sVal = "";
				break;
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}


/* 개발자 작업  끝 */
