/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1162.js
*@FileTitle  : ESM_BKG_1162 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06 
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
 * @class ESM_BKG_1162 : ESM_BKG_1162 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업 */
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var bkgNo="";
var state="";
var intervalId;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, document.form, IBSEARCH);
			break;
		case "btn_new":
			document.form.reset();
			sheetObject.RemoveAll();
			formObject.vvd.focus();
			break;
		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btn_downXML":
			doActionIBSheet(sheetObjects[2], formObject, MULTI01);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	// ** Date 구분자 **/
	DATE_SEPARATOR="-";
	var formObject=document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	ComBtnDisable("btn_downExcel");
	ComBtnDisable("btn_downXML");
//	doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	document.form.vvd.focus()
}
/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");
	var srcValue=ComGetEvent("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
	        var HeadTitle1="ibflag|cntr_no2|Seq.|Container No.|" +
	        "TP|Seal No.|Kind/Code|Kind/Code|W/O|WGT|WGT (T)|E.WGT (T)|" +
	        "PKG|PKG|B/L No.|POR|POR|POR|" +
	        "A/POL|A/POL|A/POL|A/POD|A/POD|A/POD|B/POL|B/POL|B/POL|B/POD|B/POD|B/POD|DEL|DEL|DEL|" +
	        "BS|R|D|TS|CTP|Hot|Special Cargo|Special Cargo";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	
	        SetConfig( { SearchMode:2, FrozenCol:14, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_no2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:false },
	               {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:false },
	               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seal_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal_pty_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"wo_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"a_cntr_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"e_cntr_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:0,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"por_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"por_nm" },
	               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bpol_nm" },
	               {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bpod_nm" },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"a_pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"pol_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apol_nm" },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"a_pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"pod_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apod_nm" },
	               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"del_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"del_nm" },
	               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"blck_stwg_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ts_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hot_de_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_desc_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
	        SetShowButtonImage(1);
	        ComResizeSheet(sheetObj);
		}
		break;
	case "sheet2": // backendjob 용
		with (sheetObj) {
	        var HeadTitle1="f_text1"
	        var headCount=(ComCountHeadTitle(HeadTitle1), 0, 0, false);	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);	
	        var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ]; 
	        InitColumns(cols);	
	        SetEditable(1);
	        SetVisible(0);//backendjob용으로같이씀참고:0015
	        SetSheetHeight(100);
		}
		break;
    case "sheet3":      //sheet1 init
        with (sheetObj) {
	        var HeadTitle="XML";
	        var headCount=ComCountHeadTitle(HeadTitle);	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);	
	        var cols = [ 
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"down_xml",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];     
	        InitColumns(cols);	
	        SetEditable(1);
	        SetSheetHeight(220);
	        SetVisible(0);
		}
        break;		
	}
}
/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_1162GS.do", FormQueryString(formObj));
			var key=ComGetEtcData(sXml, "KEY");
			// top.document.body.scrollTop = 0;
			intervalId=setInterval("doActionValidationResult(sheetObjects[1], '" + key + "');", 3000);
//			ComOpenWait(false);
		}
		break;
	case IBDOWNEXCEL:
		
		if (!validateForm(sheetObj, formObj, sAction)) return;
		
		sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		break;
	case MULTI01: // Down XML
		if (!validateForm(sheetObj, formObj, sAction)) {
			return;
		}
		if(!ComShowConfirm(ComGetMsg("BKG95003", "Down XML"))) {
        	// sel 조회시 상태로 초기화
//			sheetObj.CheckAll2("sel") = 0;
			return false;
        }
		if (sheetObjects[2].RowCount()> 0) {
			sheetObjects[2].RemoveAll()
		} 
		sheetObjects[2].DataInsert(1);
		var savedFileName=formObj.vvd.value + ".xml";
		sheetObjects[2].SetWaitImageVisible(0);
		ComOpenWait(true);
		var rowCnt=sheetObj.RowCount();
		formObj.f_cmd.value=MULTI01;

		var sXml=sheetObjects[2].GetSearchData("ESM_BKG_1162GS.do", FormQueryString(formObj));
		
		var state=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		
		if (state == "S") {
			sheetObjects[2].SetCellText(1, "down_xml" ,ComGetEtcData(sXml, "down_xml"));
			sheetObjects[2].Down2Text({ ColDelim:"",FileName:savedFileName,DownHeader:false});
		} else {
			ComShowCodeMessage("BKG01021","XML");
		}		
		
		ComOpenWait(false);		
		break;		
	}
}
/**
 * BackEndJob 처리
 * @param sheetObj Sheet
 * @param sKey sKey
 */
function doActionValidationResult(sheetObj, sKey) {
	// top.document.body.scrollTop = 0;
	var formObj=document.form;
	// sheetObjects[0].WaitImageVisble = false;
	// ComOpenWait(true);
	// top.document.body.scrollTop = 0;
	var sXml=sheetObj.GetSearchData("ESM_BKG_1162GS.do?f_cmd=" + SEARCH01 + "&key=" + sKey + "&formCommand=" + formObj.f_cmd.value);
	// ComOpenWait(true);
	var arrXml=sXml.split("|$$|");
	var sJbStsFlg=ComGetEtcData(arrXml[0], "jb_sts_flg");
	// top.document.body.scrollTop = 0;
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, arrXml[0])) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		// ComShowCodeMessage('BKG00166');
		// ComShowMessage(ComResultMessage(sXml));
		// sheet1, sheet2 다시 조회
		// var selRow = sheetObjects[0].SelectRow;
		if (document.form.f_cmd.value == "2") {
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
//			sheetObjects[4].LoadSearchXml(arrXml[1]);
			state = ComGetEtcData(arrXml[0], "TRANS_RESULT_KEY");
			if (state == "S") {
				var rowCnt=sheetObjects[0].RowCount();
				// alert(rowCnt);
				if (rowCnt == 0) {
					ComBtnDisable("btn_downExcel");
					ComBtnDisable("btn_downXML");
				} else {
					ComBtnEnable("btn_downExcel");
					ComBtnEnable("btn_downXML");
				}
//				sheetObj.CheckAll("sel") = 0;				
			}
		} else {
			//alert("test");
			ComShowMessage(ComResultMessage(arrXml[0]));
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(arrXml[0]));
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		//기본포멧체크
		if (!ComChkValid(formObj)) return false;
		return true;
		break;
	case MULTI01 : // down xml
		if(sheetObj == 0) {
    		ComShowCodeMessage("BKG01096");
    		return false;
		}
		//기본포멧체크
		if (!ComChkValid(formObj)) return false;
		
		break;
	case IBDOWNEXCEL:
		if(sheetObj.RowCount()== 0) {
    		ComShowCodeMessage('BKG00109');
    		return false;
		}
		break;
	}
	return true;
}
/**
 * Sheet에서 클랙했을시 체크박스 처리
 * @param sheetObj Sheet
 * @param row row
 * @param col col
 */
function sheet1_OnClick(sheetObj, row, col) {
	var rowCnt=sheetObj.RowCount();
	var check=sheetObj.GetCellValue(row, "sel");
	var keyCntrNo=sheetObj.GetCellValue(row, "cntr_no");
	var colSaveName=sheetObj.ColSaveName(col);
	for (i=1; i <= rowCnt + 2; i++) {
		if (colSaveName == "sel") {
			if (check == 0) {
				if (i == row)
					continue;
				if (keyCntrNo == sheetObj.GetCellValue(i, "cntr_no")) {
					sheetObj.SetCellValue(i, "sel",1);
				}
			} else if (check == 1) {
				if (i == row)
					continue;
				if (keyCntrNo == sheetObj.GetCellValue(i, "cntr_no")) {
					sheetObj.SetCellValue(i, "sel",0);
				}
			}
		}
	} // end for(i)
}

/* 개발자 작업 끝 */
