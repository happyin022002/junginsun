/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0030.js
*@FileTitle : Korea Manifest Amend
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================*/

//공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Retrieve":
			sheetObject.RemoveAll();
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			updateSummary();
			break;
		case "btn_New":
			doNew(formObject);
			updateSummary();
			break;
		case "btn_DownExcel":
			var exceptLines="";
			var chkCnt=0;
			// 체크 안된 데이터들 묶음
			for(var i=2; i < sheetObject.RowCount()+2; i++) {
				if (sheetObject.GetCellValue(i, "Sel")==0)
					exceptLines=exceptLines + "|" + i;
				else {
					chkCnt++;
				}
			}
			if (chkCnt > 0) {
				//sheetObject.RenderSheet(0);
				sheetObject.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false, SheetDesign:1, AutoSizeColumn:1, DownCols: makeHiddenSkipCol(sheetObject)});
				//sheetObject.RenderSheet(1);
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;
		case "btn_Print":
			var chkCnt=0;
			var params="f_cmd="+SEARCH03;
			// 체크된 데이터들 묶음
			for(var i=sheet1.HeaderRows(); i <= sheet1.RowCount()+sheet1.HeaderRows(); i++) {
				if (sheetObject.GetCellValue(i, "Sel")==1) {
					params=params + "&ibflag=R"+
							 "&in_type=" + formObject.in_type.value +
							 "&vvd=" + formObject.vvd.value +
							 "&pol_cd="+formObject.pol_cd.value+
							 "&pod_cd="+formObject.pod_cd.value+
							 "&yard_cd="+formObject.yard_cd.value+
							 "&bl_no="+sheetObject.GetCellValue(i, "bl_no")+
							 "&msn_no="+sheetObject.GetCellValue(i, "mst_bl_seq_no")+
							 "&bkg_no="+sheetObject.GetCellValue(i, "bkg_no");
					if (formObject.io_bnd_cd[0].checked) {
						params=params + "&io_bnd_cd=I";
					}else {
						params=params + "&io_bnd_cd=O";
					}
					chkCnt++;
				}
			}
			if (chkCnt > 0) {
				// Sheet2에 조회 XML 생성
				var sXml=sheetObject1.GetSearchData("ESM_BKG_0030GS.do", params, "", true);
				sheetObject1.LoadSearchData(sXml,{Sync:1} );
				// 정렬
				sheetObject1.ColumnSort("snd_dt");
				//ComOpenWait(false);
				if (sheetObject1.RowCount()> 0) {
					ComOpenWindowCenter("ESM_BKG_0851.do?pgmNo=ESM_BKG_0851", "0851", 1024, 720, false);
				} else {
					ComShowCodeMessage('BKG00394');
				}
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;
		case "btn_BLInfo":
			addBlInfo();
			break;
		case "io_bnd_cd":
			checkBound();
			break;
		case "pol_cd":
			formObject.io_bnd_cd[1].checked=true;
			checkBound();
			formObject.pol_cd.focus();
			break;
		case "pod_cd":
			formObject.io_bnd_cd[0].checked=true;
			checkBound();
			formObject.pod_cd.focus();
			break;
		case "only_error":
			if (formObject.only_error[0].checked) {
				//sheetObject.RenderSheet(0);
				showAllRows(sheetObject);
				//sheetObject.RenderSheet(1);
			}else {
				//sheetObject.RenderSheet(0);
				showOnlyErrRows(sheetObject);
				//sheetObject.RenderSheet(1);
			}
			updateSummary();
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * NEW 버튼 클릭시 초기화
 * @param formObject
 * @return
 */
function doNew(formObject)
{
	formObject.reset();
	sheetObjects[0].RemoveAll();
	checkBound();
	formObject.vvd.focus();
	checkBtnStatus();
}
/**
 * 버튼 상태 처리
 * @return
 */
function checkBtnStatus()
{
	var sheetObj=sheetObjects[0];
	if (sheetObj.RowCount()< 1) {
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_Print");
		ComBtnDisable("btn_BLInfo");
	}else {
		ComBtnEnable("btn_DownExcel");
		ComBtnEnable("btn_Print");
		ComBtnEnable("btn_BLInfo");
	}
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	sheet1_OnLoadFinish(sheet1);
	/*axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);*/
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //sheet1 init
		with(sheetObj){

		  var HeadTitle1="Sel|Seq.|B/L No.|BKG No.|MSN|STS|TP|FE|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|CNTR|BAC|W/H|DESC|T/R|S/C|ELNO|ELNO|Customer Name|CM|BZ|";
		  var HeadTitle2="Sel|Seq.|B/L No.|BKG No.|MSN|STS|TP|FE|POL|POD|Package|Package|Weight|Weight|Measure|Measure|N|A|N|A|N|A|CNTR|BAC|W/H|DESC|T/R|S/C| | |Customer Name|CM|BZ|";
		  var headCount=ComCountHeadTitle(HeadTitle1);

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		  var headers = [ { Text:HeadTitle1, Align:"Center"},
					  { Text:HeadTitle2, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
				 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mst_bl_seq_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"kr_bl_amdt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Int",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cntr_ttl_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"meas_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bl_meas_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"c_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"c_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"n_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"n_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cnt",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bd_area_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"wh",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_desc1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mf_snd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"kr_cstms_bl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"elno_a",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"elno_b",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"biz_rgst_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"error_check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

		  InitColumns(cols);
		  SetEditable(1);
		  SetSheetHeight(360);
		  SetRangeBackColor(1, 2, 1, 28,"#777777");

			}


		break;
	case 2:      //sheet2 init
		with(sheetObj){

		  var HeadTitle1="MSN|MRN_NO|BL_TP_CD|P1|C1|BL_NO|SEND_DT";
		  var headCount=ComCountHeadTitle(HeadTitle1);

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"msn_no" },
					{Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"mrn_no" },
					{Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"bl_tp_cd" },
					{Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"p1" },
					{Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"c1" },
					{Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"bl_no" },
					{Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt" } ];

		  InitColumns(cols);

		  SetEditable(1);
		  SetCountPosition(0);
		  //SetSheetHeight(0);
		  SetVisible(0);
	}


	break;
	case 3:      //sheet3 init
		with(sheetObj){

			var HeadTitle1="BKG_NO|CNTR_NO|TP_CD";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
			{Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no" },
			{Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd" } ];

			InitColumns(cols);

			SetEditable(1);
			SetCountPosition(0);
			//SetSheetHeight(0);
			SetVisible(0);
		}


		break;
	}
}
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value=SEARCH;
			//sheetObj.RenderSheet(0);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0030GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
			changeErrorColor(sheetObj);
			if (formObj.only_error[1].checked) showOnlyErrRows(sheetObj);
			//sheetObj.RenderSheet(1);
			// MRN UPDATE
			formObj.mrn_no.value=sheetObj.GetEtcData('mrn_no') + sheetObj.GetEtcData('mrn_chk_no');
			checkBtnStatus();
		}
		break;
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.vvd.value.length < 8) {
			ComShowCodeMessage('BKG00115');
			formObj.vvd.focus();
			return false;
		}
		if (formObj.io_bnd_cd[0].checked) {
			if (formObj.pod_cd.value.length < 5) {
				ComShowCodeMessage('BKG00203');
				formObj.pod_cd.focus();
				return false;
			}
		}else {
			if (formObj.pol_cd.value.length < 5) {
				ComShowCodeMessage('BKG00209');
				formObj.pol_cd.focus();
				return false;
			}
		}
	}
	return true;
}
/**
 * SHEET1 로드 완료 이벤트 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	// TYPE 비활성화 체크
	checkBound();
	doNew(document.form);
	if (document.form.strOfc_cd.value.substring(0,5)=="SELSC") {
		document.form.io_bnd_cd[1].checked=true;
		checkBound();
	}
}
/**
 * 클릭시 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Val
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col, Val) {
	if (Row > 1 && Col == 2) {
if (sheetObj.GetCellValue(Row, "Sel")==0)
			sheetObj.SetCellValue(Row, "Sel",1);
		else
			sheetObj.SetCellValue(Row, "Sel",0);
	}
}
/**
 * 더블클릭 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Val
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col, Val) {
	if (Row > 1)
	{
		addBlInfo();
	}
}
/**
 * BL INFO 로 넘김
 * @return
 */
function addBlInfo()
{
	 var form=document.form;
	 var row=sheetObjects[0].GetSelectRow();
	 var params;
	 // 체크되어있으면 EDIT 로 그 외에는 ADD BL로 처리
	 if (sheetObjects[0].GetCellValue(row, "Sel")==1) {
		 params="pgmNo=ESM_BKG_0031&mode=EDIT&io_bnd_cd=";
		 if (form.io_bnd_cd[0].checked) {
			params=params + "I";
			params=params + "&port_cd="+form.pod_cd.value;
			if (form.pod_cd.value==sheetObjects[0].GetCellValue(row,"pod_cd")) {
				params=params + "&cgo_spec_clear=Y";
			}
		 } else {
			params=params + "O";
			params=params +"&port_cd="+form.pol_cd.value;
		 }
		 params=params + "&pol_cd="+form.pol_cd.value+"&pod_cd="+form.pod_cd.value;
		 params=params + "&vvd="+form.vvd.value+"&bl_no="+sheetObjects[0].GetCellValue(row, "bl_no");
		 params=params + "&bkg_no="+sheetObjects[0].GetCellValue(row, "bkg_no");
		 params=params + "&cstms_decl_tp_cd="+sheetObjects[0].GetCellValue(row,"cstms_decl_tp_cd");
		 params=params + "&msn_no="+sheetObjects[0].GetCellValue(row, "mst_bl_seq_no");
		 params=params + "&in_type="+form.in_type.value;
	 }else {
		params="pgmNo=ESM_BKG_0031&mode=ADD&io_bnd_cd=";
		if (form.io_bnd_cd[0].checked) {
			params=params + "I";
			params=params + "&port_cd="+form.pod_cd.value;
		 } else {
			params=params + "O";
			params=params +"&port_cd="+form.pol_cd.value;
		 }
		 params=params + "&pol_cd="+form.pol_cd.value + "&pod_cd=" + form.pod_cd.value + "&vvd="+form.vvd.value;
	 }
	 ComOpenPopup("ESM_BKG_0031.do?"+params, 1248, 680, "0002", "1,0", false);
}
/**
 * In / Out Bound 구분에 따른 처리
 * @return
 */
function checkBound()
{
	var formObj=document.form;
	if (formObj.io_bnd_cd[0].checked) {
		// IN-BOUND
		formObj.in_type.value="A";
		comboObjects[0].SetSelectCode("A",false);
		comboObjects[0].SetEnable(0);
		formObj.in_type.value="";
		formObj.pod_cd.className="input1";
		formObj.pod_cd.disabled=false;
		formObj.pol_cd.className="input2";
		formObj.pol_cd.disabled=true;
		formObj.pol_cd.value="";
		formObj.yard_cd.className="input";
		formObj.yard_cd.disabled=false;
	}else {
		// OUT-BOUND
		comboObjects[0].SetEnable(1);
		formObj.in_type.value="A";
		comboObjects[0].SetSelectCode("A",false);
		formObj.pod_cd.className="input2";
		formObj.pod_cd.disabled=true;
		formObj.pod_cd.value="";
		formObj.pol_cd.className="input1";
		formObj.pol_cd.disabled=false;
		formObj.yard_cd.className="input2";
		formObj.yard_cd.disabled=true;
		formObj.yard_cd.value="";
	}
}
/**
 * 콤보 초기화
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt=0;
	switch(comboObj.options.id) {
	case "combo1":
		with (comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "50");
			SetColWidth(1, "100");
			SetDropHeight(400);
			//ShowCol=0;
			SetTitle("Type|Description");
			SetMultiSelect(0);
			SetMaxSelect(1 );
			InsertItem(cnt ++, "A|미주 LOCAL", "A");
			InsertItem(cnt ++, "B|아/구주 LOCAL", "B");
			InsertItem(cnt ++, "C|T/S", "C");
			InsertItem(cnt ++, "D|A+B+C", "D");
			Code="A";
		}
		break;
	}
}
/**
 * TYPE 콤보 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function combo1_OnChange(comboObj,value,text) {
	var form=document.form;
	form.in_type.value=value;
}
/**
 * 키 누를때 선택되게 하기
 * @param comboObj
 * @param key
 * @param shift
 * @return
 */
function combo1_OnKeyDown(comboObj, key, shift) {
	if (key==65) comboObj.SetSelectCode("A");
	if (key==66) comboObj.SetSelectCode("B");
	if (key==67) comboObj.SetSelectCode("C");
	if (key==68) comboObj.SetSelectCode("D");
}
//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * 그리드의 비지니스 에러 판단 (컬러 변경 처리)
 * @return
 */
function changeErrorColor(sheetObj)
{
	for(var i=2; i < sheetObj.RowCount()+2; i++) {
		// BL_NO 색 변경
		if (sheetObj.SetCellValue(i, "error_check")=="E") sheetObj.GetCellFontColor(i, "bl_no","#FF0000");
		// 에러 컬럼 체크
		if (sheetObj.SetCellValue(i, "wh")=="N") sheetObj.GetCellFontColor(i, "wh","#FF0000");
		if (sheetObj.SetCellValue(i, "cgo_desc1")=="N") sheetObj.GetCellFontColor(i, "cgo_desc1","#FF0000");
		if (sheetObj.SetCellValue(i, "s_nm")=="N") sheetObj.GetCellFontColor(i, "s_nm","#FF0000");
		if (sheetObj.SetCellValue(i, "s_addr")=="N") sheetObj.GetCellFontColor(i, "s_addr","#FF0000");
		if (sheetObj.SetCellValue(i, "c_nm")=="N") sheetObj.GetCellFontColor(i, "c_nm","#FF0000");
		if (sheetObj.SetCellValue(i, "n_nm")=="N") sheetObj.GetCellFontColor(i, "n_nm","#FF0000");
		if (sheetObj.SetCellValue(i, "cmdt_cd")=="N") sheetObj.GetCellFontColor(i, "cmdt_cd","#FF0000");
		if (sheetObj.SetCellValue(i, "biz_rgst_no")=="N") sheetObj.GetCellFontColor(i, "biz_rgst_no","#FF0000");
		if (sheetObj.SetCellValue(i, "cntr_cnt")=="0") sheetObj.GetCellFontColor(i, "cntr_cnt","#FF0000");
		if (sheetObj.SetCellValue(i, "pck_qty")=="0") sheetObj.GetCellFontColor(i, "pck_qty","#FF0000");
		if (sheetObj.SetCellValue(i, "cntr_ttl_wgt")=="0") sheetObj.GetCellFontColor(i, "cntr_ttl_wgt","#FF0000");
		if (sheetObj.SetCellValue(i, "elno_b")=="U") sheetObj.GetCellFontColor(i, "elno_b","#FF0000");
		// IN BOUND
		if (document.form.io_bnd_cd[0].checked) {
			if (sheetObj.SetCellValue(i, "bd_area_cd")=="N") sheetObj.GetCellFontColor(i, "bd_area_cd","#FF0000");
			if (sheetObj.SetCellValue(i, "c_addr")=="N") sheetObj.GetCellFontColor(i, "c_addr","#FF0000");
			if (sheetObj.SetCellValue(i, "n_addr")=="N") sheetObj.GetCellFontColor(i, "n_addr","#FF0000");
		}
	}
}
/**
 * 그리드 숨김 해제
 * @param sheetObj
 * @return
 */
function showAllRows(sheetObj) {
	for(var i=2; i < sheetObj.RowCount()+2; i++) {
		sheetObj.SetRowHidden(i,0);
	}
}
/**
 * 그리드에서 에러 행만 보여줌
 * @param sheetObj
 * @return
 */
function showOnlyErrRows(sheetObj) {
	for(var i=2; i < sheetObj.RowCount()+2; i++) {
if (sheetObj.GetCellValue(i, "error_check")!="E")
			sheetObj.SetRowHidden(i,1);
	}
}
/**
 * 통계 정보 UPDATE
 * @return
 */
function updateSummary()
{
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var bl_local=0, bl_ts=0, bl_empty=0;
	var cntr_local=0, cntr_ts=0, cntr_empty=0;
	var cntrRow, prev_cntr_no="";
	sheetObjects[2].ColumnSort("cntr_no", "ASC");
	// 루프돌며 계산
	for(var i=2; i < sheetObj.RowCount()+2; i++) {
		// HIDDEN 은 패스~
		if (sheetObj.GetRowHidden(i)) continue;
		// EMPTY CHECK
			if (sheetObj.GetCellValue(i, "bkg_cgo_tp_cd")=="P" || sheetObj.GetCellValue(i, "bkg_cgo_tp_cd")=="E" || sheetObj.GetCellValue(i, "bkg_cgo_tp_cd")=="R" ) {
			bl_empty++;
			cntrRow=sheetObjects[2].FindText("bkg_no", sheetObj.GetCellValue(i, "bkg_no"));
			while(cntrRow > 0 ) {
				sheetObjects[2].SetCellValue(cntrRow, "bkg_cgo_tp_cd","E");
				cntrRow=sheetObjects[2].FindText("bkg_no", sheetObj.GetCellValue(i, "bkg_no"), cntrRow+1);
			}
		}else {
			// EMPTY 가 아닌 경우 LOCAL / TS 구분
			// LOCAL 의 경우
			if (sheetObj.GetCellValue(i, "cstms_decl_tp_cd")=="I" || sheetObj.GetCellValue(i, "cstms_decl_tp_cd")=="E" ) {
				bl_local++;
				cntrRow=sheetObjects[2].FindText("bkg_no", sheetObj.GetCellValue(i, "bkg_no"));
				while(cntrRow > 0 ) {
					sheetObjects[2].SetCellValue(cntrRow, "bkg_cgo_tp_cd","L");
					cntrRow=sheetObjects[2].FindText("bkg_no", sheetObj.GetCellValue(i, "bkg_no"), cntrRow+1);
				}
			}else {
			// TS 의 경우
				bl_ts++;
				cntrRow=sheetObjects[2].FindText("bkg_no", sheetObj.GetCellValue(i, "bkg_no"));
				while(cntrRow > 0 ) {
					sheetObjects[2].SetCellValue(cntrRow, "bkg_cgo_tp_cd","T");
					cntrRow=sheetObjects[2].FindText("bkg_no", sheetObj.GetCellValue(i, "bkg_no"), cntrRow+1);
				}
			}
		}
	}
	// 컨테이너 갯수 계산
	for(var i=1; i <= sheetObjects[2].RowCount(); i++ ) {
		// BKG_NO 가 메인에서 Hidden 이면 카운트 하지 않음
		cntrRow=sheetObjects[0].FindText("bkg_no", sheetObjects[2].GetCellValue(i, "bkg_no"));
		if (cntrRow > 0 && sheetObjects[0].GetRowHidden(cntrRow)) continue;
		// COUNT
		if (prev_cntr_no != sheetObjects[2].GetCellValue(i, "cntr_no")) {
		if (sheetObjects[2].GetCellValue(i, "bkg_cgo_tp_cd")=="E") cntr_empty++;
		if (sheetObjects[2].GetCellValue(i, "bkg_cgo_tp_cd")=="L") cntr_local++;
		if (sheetObjects[2].GetCellValue(i, "bkg_cgo_tp_cd")=="T") cntr_ts++;
		}
		prev_cntr_no=sheetObjects[2].GetCellValue(i, "cntr_no");
	}
	// 계산결과 뿌려주기
	formObj.bl_local.value=bl_local;
	formObj.bl_ts.value=bl_ts;
	formObj.bl_empty.value=bl_empty;
	formObj.cntr_local.value=cntr_local;
	formObj.cntr_ts.value=cntr_ts;
	formObj.cntr_empty.value=cntr_empty;
	formObj.bl_total.value=bl_local + bl_ts + bl_empty;
	formObj.cntr_total.value=cntr_local + cntr_ts + cntr_empty;
	comboObjects[0].SetEnable(formObj.io_bnd_cd[1].checked);
}
 /**
 * 조회조건 입력할 때 처리
 */
 function obj_KeyUp() {
	 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	 var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
 }

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}
