/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0229_11.jsp
 *@FileTitle : e-Booking & SI Process Detail(HBL 2)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 
 */
/**
 * @extends 
 * @class esm_bkg_0229_11 : esm_bkg_0229_11 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_11() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
/* 개발자 작업	*/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var iterator="|$$|";
var isCopy="false";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_cancelcopydata":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			isCopy="false";
			top.isCopyAllRequested=false;
			//ComBtnColor("btn_cancelcopydata", "blue");
			//ComBtnColor("btn_datacopytoopus", "#737373");	
			
			document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;font-weight:bold;";
			document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
			break;
		case "btn_datacopytoopus":
			if (isCopy == "false") {
				dataCopy();
			}
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
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		// IBMultiCombo
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}
function initControl() {
	applyShortcut();
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
		
		var HeadTitle1="||AMS File No.|SCAC|Piece";
		var headCount=ComCountHeadTitle(HeadTitle1);
		(headCount, 0, 0, true);
		var prefix="sheet1_";

		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:"usa_cstms_file_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"scac_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		 
		InitColumns(cols);
		SetColProperty(0 ,"scac_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
		SetSheetHeight(302);
		SetEditable(1);
//		SetGetCountPosition(0);
		}
		break;
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
		
		var HeadTitle1="||AMS File No.|SCAC|Piece";
		var headCount=ComCountHeadTitle(HeadTitle1);
		(headCount, 0, 0, true);
		var prefix="sheet2_";

		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);

		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:"usa_cstms_file_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"scac_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		 
		InitColumns(cols);
		SetSheetHeight(302);
		SetEditable(1);
//		SetGetCountPosition(0);
		}
		break;
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH_ASYNC01: //조회
//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(10)="#96c792";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		break;
	case IBSEARCH: //조회
		var sXml=formObj.sXml.value;
		var arrXml=sXml.split("|$$|");
		for ( var i=0; i < arrXml.length; i++) {
			//sheetObjects[i].RenderSheet(0);
			if (i > 0) {
				sheetObjects[i].SetWaitImageVisible(0);
			}
			sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
			//sheetObjects[i].RenderSheet(1);
		}
		formObj.hbl2_opus.value=(sheetObjects[0].GetTotalRows()> 0)?"Y":"N";
		formObj.hbl2_esvc.value=(sheetObjects[1].GetTotalRows()> 0)?"Y":"N";
		if(top.document.form.tabload11.value == "COPY"){
			dataCopy();
		}
		compareItem();
		top.document.form.tabload11.value="LOAD";
		
		if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_11');
		break;
	case IBSEARCH_ASYNC02: //Data Copy
		var formObj2=document.form2;
		var obj=null;
		var objNm=null;
		var objVal=null;
		var cntrNo=new Array();
		var cntrSeq=0;
		var cntrTpszCd=new Array();
		var cntrTpszCdSeq=0;
		var pckQty=new Array();
		var pckQtySeq=0;
		var pckTpCd=new Array();
		var pckTpCdSeq=0;
		var cntrWgt=new Array();
		var cntrWgtSeq=0;
		var wgtUtCd=new Array();
		var wgtUtCdSeq=0;
		var measQty=new Array();
		var measQtySeq=0;
		var measUtCd=new Array();
		var measUtCdSeq=0;
		var poNo=new Array();
		var poNoSeq=0;
//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(10)="#fff270";
		var isInsert=true;
		for ( var i=1; i <= sheetObjects[1].GetTotalRows(); i++) {
			for ( var j=1; j <= sheetObjects[0].GetTotalRows(); j++) {
				if (sheetObjects[1].GetCellValue(i, "usa_cstms_file_no") == sheetObjects[0].GetCellValue(j, "usa_cstms_file_no")) {
					isInsert=false;
					break;
				} else {
					isInsert=true;
				}
			}
			if (isInsert) {
				var Row=sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetCellValue(Row, 2,sheetObjects[1].GetCellValue(i, 2));
				sheetObjects[0].SetCellValue(Row, 3,sheetObjects[1].GetCellValue(i, 3));
				sheetObjects[0].SetCellValue(Row, 4,sheetObjects[1].GetCellValue(i, 4));
			} else {
				if (sheetObjects[0].GetCellValue(i, 2) == '') {
					sheetObjects[0].SetCellValue(i, 2,sheetObjects[1].GetCellValue(i, 2));
				}
				if (sheetObjects[0].GetCellValue(i, 3) == '') {
					sheetObjects[0].SetCellValue(i, 3,sheetObjects[1].GetCellValue(i, 3));
				}
				if (sheetObjects[0].GetCellValue(i, 4) == '') {
					sheetObjects[0].SetCellValue(i, 4,sheetObjects[1].GetCellValue(i, 4));
				}
			}
		}
		formObj.hbl2_opus.value="Y";
		isCopy="true";
		compareItem();
		break;
	}
}
/*
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm() {
	var sheetObj=sheetObjects[0];
	for (var i=1; i < sheetObj.LastRow(); i++) {
		if (ComIsNull(sheetObj.GetCellValue(i, "usa_cstms_file_no"))) {
			//validation 변경 20100311 신은영 차장 요청
//			ComShowCodeMessage("BKG00104","AMS File No");
//			return false;
			sheetObj.RowDelete(i, false);
		}
	if (ComIsNull(sheetObj.GetCellValue(i, "pck_qty"))) {
			sheetObj.SetCellValue(i, "pck_qty","0",0);
		}
	}
	return true;
}
/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * Validate 실패 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동
 * Focus 이동까지 한 후 return false
 */
function validateForUpload() {	 
	return validateForm();
}
/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * 각 화면에서 Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	var formObj=document.form;
	//서버 전달 값 감소
	var sXml=formObj.sXml.value;
	formObj.sXml.value=null;
	formObj.f_cmd.value=MULTI;
	var params=FormQueryString(formObj);
	formObj.sXml.value=sXml;
	// AMS Filer US, CA 둘중에 하나라도 '1'인 경우에만 저장하도록 함. ( 이정희 차장님 요청 - 2010.05.27 - YC KIM )
	if ( ComGetObjValue(parent.frames["t1frame"].document.form.usa_cstms_file_cd) == '1' || ComGetObjValue(parent.frames["t1frame"].document.form.cnd_cstms_file_cd) == '1' ) {
//	if (sheetObjects[0].IsDataModified) {
		params=params + "&" + sheetObjects[0].GetSaveString(true);
	} else {
		params="";
	}
	return (params);	
}
function dataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	//ComBtnColor("btn_cancelcopydata", "#737373");
	//ComBtnColor("btn_datacopytoopus", "blue");	
	
	document.getElementById("btn_datacopytoopus").style.cssText = "color:blue !important;font-weight:bold;";
	document.getElementById("btn_cancelcopydata").style.cssText = "color:#737373 !important;font-weight:normal;";
}
//색 비교 처리
function compareItem() {
	var diffColor="#0000FF";
	var sameColor="#000000";
	var opusSeq=0;
	var esvcSeq=0;
	for ( var i=1; i <= sheetObjects[1].GetTotalRows(); i++) {
		esvcSeq=i;
		opusSeq=i;
		if(ComIsNull(ComTrim(sheetObjects[1].GetCellValue(esvcSeq, "usa_cstms_file_no")))) continue;
		for(var j=1; j <= sheetObjects[0].GetTotalRows(); j++){
			if (sheetObjects[1].GetCellValue(esvcSeq, "usa_cstms_file_no") == sheetObjects[0].GetCellValue(j, "usa_cstms_file_no")) {
				opusSeq=j;
			}
		}
		if (sheetObjects[1].GetCellValue(esvcSeq, 2) != sheetObjects[0].GetCellValue(opusSeq, 2)) {
 			sheetObjects[1].SetCellFontColor(esvcSeq, 2,diffColor);
		} else {
 			sheetObjects[1].SetCellFontColor(esvcSeq, 2,sameColor);
		}
		if (sheetObjects[1].GetCellValue(esvcSeq, 3) != sheetObjects[0].GetCellValue(opusSeq, 3)) {
 			sheetObjects[1].SetCellFontColor(esvcSeq, 3,diffColor);
		} else {
 			sheetObjects[1].SetCellFontColor(esvcSeq, 3,sameColor);
		}
		if (sheetObjects[1].GetCellValue(esvcSeq, 4) != sheetObjects[0].GetCellValue(opusSeq, 4)) {
 			sheetObjects[1].SetCellFontColor(esvcSeq, 4,diffColor);
		} else {
 			sheetObjects[1].SetCellFontColor(esvcSeq, 4,sameColor);
		}
	}
	sheetObjects[0].SetColBackColor("usa_cstms_file_no","#CCFFFD");
}
function sheet1_OnChange(sheetObj, Row, Col, Value){
	//sheet 수정시 false로 하면 다시 copy할 때 밑으로 추가됨 
//	isCopy = "false";	 
	compareItem()
}
