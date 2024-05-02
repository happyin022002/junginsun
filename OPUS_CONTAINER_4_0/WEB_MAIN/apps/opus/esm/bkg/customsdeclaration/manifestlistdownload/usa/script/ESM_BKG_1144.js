/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_BKG_1144.js
 *@FileTitle : SNP/Broker Nomination
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.03.26
 *@LastModifier : KIM HYUN HWA
 *@LastVersion : 1.0
 * 2012.03.26 KIM HYUN HWA
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 개발자 작업 */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 
function processButtonClick()
{
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_RowAdd":
			doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
			break;
		case "btn_Copy":
			doActionIBSheet(sheetObjects[0], formObject, IBCOPYROW);
			break;
		case "btn_Delete":
			doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_New":
			doActionIBSheet(sheetObjects[0], formObject, IBRESET);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	if (document.form.cust_cd.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	sheet1_OnLoadFinish(sheetObjects[0]);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;
    var sheetID = sheetObj.id;

    switch (sheetID) {
    case "sheet1": //sheet1 init
        with(sheetObj){
          
          if (location.hostname != "")
          var HeadTitle1="|Sel.|Seq.|Customer\nCode|Customer\nName|S/C No.|POD|POD|DEL|DEL|Type|Customs code|Name|cstms_pty_seq|delt_flg|cre_usr_id|cre_ofc_cd|upd_usr_id|upd_ofc_cd";
          var headCount=ComCountHeadTitle(HeadTitle1);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
  		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
  		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
  		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
  		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
  		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
  		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
  		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
  		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_yd_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
  		             {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cstms_pty_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cstms_pty_id",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:17 },
  		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cstms_pty_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:35 },
  		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cstms_pty_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
  		             {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
  		             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

          InitColumns(cols);
          SetEditable(1);
          ComResizeSheet(sheetObjects[0]);
          }
    break;
    }
}

/**
 * 저장 후 재 조회
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if(ErrMsg == null || ErrMsg == ""){
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}
/**
 * 시트에 키필드 Validation 체크 및 해당 코드의 description 조회
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj=document.form;
	
	// 해당 ROW UPDATE 시 UPDATE USER ID,OFFICE 데이터 세팅
	if (sheetObj.GetRowStatus(Row) == "U") {
		sheetObj.SetCellValue(Row, "upd_usr_id",formObj.usr_id.value,0);
		sheetObj.SetCellValue(Row, "upd_ofc_cd",userOfficeCode,0);
	}
	
	// S/C NO. 에 대한 유효성 체크
	if (sheetObj.ColSaveName(Col) == "sc_no") {
		if (Value == "") {
			sheetObj.SetCellValue(Row, Col,"",0);
			return;
		}
		var errFlg = false;
		if (Value.length == 9) {
			if (ComIsAlphabet(Value.substring(0, 3))) {
				if (!ComIsNumber(Value.substring(3))) {
					errFlg = true;
				}
			} else if (ComIsAlphabet(Value.substring(0, 2))) {
				if (!ComIsNumber(Value.substring(2))) {
					errFlg = true;
				}
			} else {
				errFlg = true;
			}
		}
		else
		{
			errFlg = true;
		}
		if (errFlg) {
			ComShowCodeMessage('BKG06012', "S/C No.(" + Value + ")" ); // {?msg1} is invalid.
			sheetObj.SetCellValue(Row, Col,"",0);
			sheetObj.SelectCell(Row, Col);
			return;
		}
	}
	
	// CUSTOMER CODE 에 대한 CUSTOMER NAME 조회
	if (sheetObj.ColSaveName(Col) == "cust_cd") {
		formObj.f_cmd.value=SEARCH01;
		if (Value == "") {
			sheetObj.SetCellValue(Row, "cust_cd","",0);
			sheetObj.SetCellValue(Row, "cust_nm","",0);
			return;
		}
		if (!ComIsAlphabet(Value.substring(0, 2)) || !ComIsNumber(Value.substring(2))) {
			ComShowCodeMessage('BKG06012', Value); // {?msg1} is invalid.
			sheetObj.SetCellValue(Row, "cust_cd","",0);
			sheetObj.SetCellValue(Row, "cust_nm","",0);
			sheetObj.SelectCell(Row, Col);
		} else {
			formObj.strCustCntCd.value=Value.substring(0, 2);
			formObj.strCustSeq.value=Value.substring(2);
		}
		if (formObj.strCustCntCd.value != "") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		}
	}
	
	// POD 유효성 체크
	if (sheetObj.ColSaveName(Col) == "pod_cd") {
		formObj.f_cmd.value=SEARCH02;
		formObj.strLocCd.value=sheetObj.GetCellValue(Row, Col);
		if (formObj.strLocCd.value != "" && formObj.strLocCd.value != "ALL") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		}
		formObj.strPod.value=sheetObj.GetCellValue(Row, "pod_cd");
	}
	// DEL 유효성 체크
	if (sheetObj.ColSaveName(Col) == "del_cd") {
		formObj.f_cmd.value=SEARCH02;
		formObj.strLocCd.value=sheetObj.GetCellValue(Row, Col);
		if (formObj.strLocCd.value != "" && formObj.strLocCd.value != "ALL") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		}
		formObj.strDel.value=sheetObj.GetCellValue(Row, "del_cd");
	}
}

function sheet1_OnLoadFinish(sheetObj){
	sheetObj.SetWaitImageVisible(0);
	doActionIBSheet(sheetObj, document.form, IBRESET);
	sheetObj.SetWaitImageVisible(1);
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.SetWaitImageVisible(0);
	
	switch (sAction) {
	case IBRESET:
		formObj.reset();
		sheetObj.RemoveAll();

		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetObj.GetSearchData("ESM_BKG_1144GS.do", FormQueryString(formObj));
		if(sXml.length > 0){
 	         var arrCombo=ComXml2ComboString(sXml, "desc", "val"); 			
 	         if (arrCombo  != undefined ){
		        sheetObj.SetColProperty("cstms_pty_tp_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
 	         } 
		}
		break;
	case IBSEARCH: // 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_1144GS.do", FormQueryString(formObj));
		break;
	case IBROWSEARCH: // Customer Name
		var sXml = sheetObj.GetSearchData("ESM_BKG_1144GS.do", FormQueryString(formObj));
		var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		var row = sheetObj.GetSelectRow();
		if (state == "S") {
			if (formObj.f_cmd.value == SEARCH01) {
				if (sheetObj.GetCellValue(row, "cust_cd") != "") {
					sheetObj.SetCellValue(row, "cust_nm", ComGetEtcData(sXml, "result"),0);
				}
			} else if (formObj.f_cmd.value == SEARCH02) {
				if (ComGetEtcData(sXml, "result") == undefined) {
					var locCd=formObj.strLocCd.value;
					ComShowCodeMessage('BKG06012', locCd); // {?msg1} is
					if (sheetObj.GetCellValue(row, "pod_cd") == locCd) {
						sheetObj.SetCellValue(row, "pod_cd","",0);
						sheetObj.SelectCell(row, "pod_cd");
					} else {
						sheetObj.SetCellValue(row, "del_cd","",0);
						sheetObj.SelectCell(row, "del_cd");
					}
				}
			}
		} else {

			if (formObj.f_cmd.value == SEARCH01) {
				ComBkgErrMessage(sheetObj, sXml);
				sheetObj.CellValue2(row, "cust_cd") = "";
				sheetObj.CellValue2(row, "cust_nm") = "";
				sheetObj.SelectCell(row, "cust_cd");
			}
		}
		sheetObj.SetWaitImageVisible(1);
		break;
	case IBSAVE: // 저장
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value=MULTI;
		sheetObj.DoSave("ESM_BKG_1144GS.do", FormQueryString(formObj), -1, false);
		ComOpenWait(false);
		break;
	case IBINSERT: // 입력
		var row=sheetObj.DataInsert(-1);
		sheetObj.SetCellValue(row, "delt_flg",'N',0);
		sheetObj.SetCellValue(row, "cre_usr_id",formObj.usr_id.value,0);
		sheetObj.SetCellValue(row, "cre_ofc_cd",userOfficeCode,0);
		sheetObj.SetCellValue(row, "upd_usr_id",formObj.usr_id.value,0);
		sheetObj.SetCellValue(row, "upd_ofc_cd",userOfficeCode,0);
		sheetObj.SetCellEditable(row, "cust_cd",1);
		sheetObj.SetCellEditable(row, "pod_cd",1);
		sheetObj.SetCellEditable(row, "del_cd",1);
		sheetObj.SetCellEditable(row, "sc_no",1);
		break;
	case IBCOPYROW: // 행 복사
		if (sheetObj.CheckedRows("Chk") == 0) {
			ComShowCodeMessage('BKG00567');
			return false;
		}
		var Row;
		var ColName;
		for (i=1; i < sheetObj.RowCount()+ 1; i++) {
			if (sheetObj.GetCellValue(i, "Chk") == 1) {
				Row=sheetObj.DataInsert(-1);
				// col 개수 만큼 반복하면서 추가된 row에 데이터 카피
				for (j=2; j <= sheetObj.LastCol()- 2; j++) {
					sheetObj.SetCellValue(Row, j,sheetObj.GetCellValue(i, j),0);
					ColName=sheetObj.ColSaveName(j);
					if (ColName == "cust_cd") {
						sheetObj.SetCellEditable(Row, ColName,1);
					} else if (ColName == "pod_cd") {
						sheetObj.SetCellEditable(Row, ColName,1);
					} else if (ColName == "del_cd") {
						sheetObj.SetCellEditable(Row, ColName,1);
					} else if (ColName == "sc_no") {
					sheetObj.SetCellEditable(Row, ColName,1);
			     	}
				}
				sheetObj.ReturnCellData(i, "Chk");
				sheetObj.ReturnCellData(i, "upd_usr_id");
				sheetObj.ReturnCellData(i, "upd_ofc_cd");
				sheetObj.SetCellValue(Row, "cre_usr_id",formObj.usr_id.value,0);
				sheetObj.SetCellValue(Row, "cre_ofc_cd",userOfficeCode,0);
				sheetObj.SetCellValue(Row, "upd_usr_id",formObj.usr_id.value,0);
				sheetObj.SetCellValue(Row, "upd_ofc_cd",userOfficeCode,0);
			}
		}
		break;
	case IBDELETE:
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		var delCnt=0;
		for ( var i=0; i < sheetObj.LastRow()+ 1; i++) {
			if (sheetObj.GetCellValue(i, "Chk") == 1 && sheetObj.GetRowStatus(i) == "U") {
				delCnt++;
				sheetObj.SetCellValue(i, "delt_flg",'Y',0);
				sheetObj.SetCellValue(i, "upd_usr_id",formObj.usr_id.value,0);
			}
		}
		if (ComShowCodeConfirm('BKG03037')) {
			if (delCnt > 0) {
				ComRowHideDelete(sheetObj, "Chk");
			} else {
				sheetObj.RenderSheet(0);
				for ( var i=0; i < sheetObj.LastRow()+ 1; i++) {
					if (sheetObj.GetCellValue(i, "Chk") == 1) {
						sheetObj.RowDelete(i, false);
					}
				}
				sheetObj.RenderSheet(1);
			}
		}
		break;
	case IBDOWNEXCEL:
        if(sheetObjects[0].RowCount() < 1){//no data
            ComShowCodeMessage("COM132501");
            return;
        }
		sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg) { 
    ComOpenWait(false);
}

/**
 * 현재 날짜,시간 구하기
 */
function setDate() {
	var d=new Date;
	var s=leadingZeros(d.getFullYear(), 4) + '-' + leadingZeros(d.getMonth() + 1, 2) + '-' + leadingZeros(d.getDate(), 2) + ' '
			+ leadingZeros(d.getHours(), 2) + ':' + leadingZeros(d.getMinutes(), 2) + ':';
	return s;
}
/**
 * 한자리 숫자 앞에 '0' 붙이기
 */
function leadingZeros(n, digits) {
	var zero='';
	n=n.toString();
	if (n.length < digits) {
		for (i=0; i < digits - n.length; i++)
			zero += '0';
	}
	return zero + n;
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSAVE: // 저장
		if (sheetObj.RowCount()<= 0)
			return false;
		if (sheetObj.RowCount("U") + sheetObj.RowCount("D") + sheetObj.RowCount("I") == 0) {
			ComShowCodeMessage('BKG00501');
			return false;
		}
		var cust_cd="";
		var sc_no="";
		var pod_cd="";
		var del_cd="";
		var pty_tp_cd="";
		var pty_nm="";
		var confirmCnt=0;
		for ( var i=1; i < sheetObj.RowCount()+ 1; i++) {
			if (sheetObj.GetRowStatus(i) == "D" )	continue;
			cust_cd=sheetObj.GetCellValue(i, "cust_cd");
			sc_no=sheetObj.GetCellValue(i, "sc_no");
			pod_cd=sheetObj.GetCellValue(i, "pod_cd");
			del_cd=sheetObj.GetCellValue(i, "del_cd");
			pty_tp_cd=sheetObj.GetCellValue(i, "cstms_pty_tp_cd");
			pty_nm=sheetObj.GetCellValue(i, "cstms_pty_nm");
			if (cust_cd == "" && sc_no == "" && pod_cd == "" && del_cd == "") {
				ComShowMessage("Please select one among 4 items ( Customer code, S/C No, POD and DEL )");
				return false;
			}
			for ( var j=i + 1; j < sheetObj.RowCount()+ 1; j++) {
				if (sheetObj.GetRowStatus(j) == "D")	continue;
				if (sheetObj.GetCellValue(j, "cust_cd") == cust_cd && sheetObj.GetCellValue(j, "sc_no") == sc_no
						&& sheetObj.GetCellValue(j, "pod_cd") == pod_cd && sheetObj.GetCellValue(j, "del_cd") == del_cd
						&& sheetObj.GetCellValue(j, "cstms_pty_tp_cd") == pty_tp_cd
						&& sheetObj.GetCellValue(j, "cstms_pty_nm") == pty_nm) {
					
					if(!ComShowCodeConfirm('BKG06029', sheetObj.GetCellValue(j, "Seq"))){
							return false;
					}
				}
			}
		}
		break;
	case IBDELETE:
		if (sheetObj.CheckedRows("Chk") == 0) {
			ComShowCodeMessage('BKG00567');
			return false;
		}
	}
	return true;
}
/* 개발자 작업 끝 */
