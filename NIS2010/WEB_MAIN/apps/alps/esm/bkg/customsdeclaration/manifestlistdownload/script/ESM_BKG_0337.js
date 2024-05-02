/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0337.js
*@FileTitle : MSN Create
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation 
=========================================================*/

/**
 * JSDOC을 위한 함수 정의
 */
function esm_bkg_0337()
{
	this.processButtonClick 		= processButtonClick;
	this.setSheetObject				= setSheetObject;
	this.loadPage					= loadPage;
	this.initSheet					= initSheet;
	this.doActionIBSheet			= doActionIBSheet;
	this.setTabObject				= setTabObject;
	this.initTab					= setInitTab;
	this.tab1_OnChange				= tab1_OnChange;
	this.validateForm				= validateForm;
	this.t2sheet1_OnClick			= t2sheet1_OnClick;
	this.t1sheet1_OnClick			= t1sheet1_OnClick;
	this.t1sheet1_OnDblClick		= t1sheet1_OnDblClick;
	this.t2sheet1_OnDblClick		= t2sheet1_OnDblClick;
	this.obj_keypress				= obj_keypress;
}

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_Retrieve":
			// 데이터 조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;						
		case "btn_ManifestGeneration":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;
		case "btn_EDISend":
			doActionIBSheet(sheetObjects[2], document.form, COMMAND02);
			break;
		case "btn_Inquiry":
			var params = "mrn_no="+formObject.in_mrn_no.value +
			"&vvd="+formObject.in_vvd.value+
			"&port_cd="+formObject.in_port.value +
			"&pgmNo=ESM_BKG_0358";
			var rtnObj = ComOpenWindowCenter("/hanjin/ESM_BKG_0358.do?"+params,'MrnInquiry' ,1024,600, true);
			if (rtnObj) {
				formObject.in_mrn_no.value 	 = rtnObj.mrn_no;
				formObject.in_mrn_chk_no.value = rtnObj.mrn_chk_no;
				formObject.in_vvd.value    	 = rtnObj.vvd;
				formObject.in_port.value   	 = rtnObj.port_cd;
			}
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(k=0;k<tabObjects.length;k++) {
		initTab(tabObjects[k],k+1);
	}

	ComBtnDisable("btn_EDISend");
	axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {
	case "t1sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 222;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Sel|Seq.|VVD|POL|ETD|POD|Yard|ETA|B/L Record";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtRadioCheck,	30,		daCenter,	true,		"Sel"); //,			false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtSeq,			70,		daCenter,	true,		"t1SEQ");
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"vvd",			false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"pol_cd",		false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		   100,		daCenter,	true,		"vps_etd_dt",	false,		"",	dfDateYmd,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"pod_cd",		false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"pod_yd_cd",	false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		   100,		daCenter,	true,		"vps_eta_dt",	false,		"",	dfDateYmd,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		   100,		daCenter,	true,		"cnt_bl_no",	false,		"",	dfDateYmd,	0,		false,		false);

			CountPosition = 0;
		}
		break;
	case "t2sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 222;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Sel|Seq.|VVD|POL|ETD|POD|Yard|ETA|B/L Record";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtRadioCheck,	30,		daCenter,	true,		"Sel"); //,			false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtSeq,			70,		daCenter,	true,		"t2SEQ");
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"vvd",			false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"pol_cd",		false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		   100,		daCenter,	true,		"vps_etd_dt",	false,		"",	dfDateYmd,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"pod_cd",		false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"pod_yd_cd",	false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		   100,		daCenter,	true,		"vps_eta_dt",	false,		"",	dfDateYmd,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,		   100,		daCenter,	true,		"cnt_bl_no",	false,		"",	dfDateYmd,	0,		false,		false);

			CountPosition = 0;

		}
		break;
	case "sheet3":
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = 0

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,		daCenter,	true,		"ibflag",		false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		"Sel",			false,		"",	dfNone,		0,		false,		false);

			CountPosition = 0;

		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH:      //조회
		// TAB을 LOCAL로 전환
		tabObjects[0].SelectedIndex = 0;
		sheetObjects[0].focus();
		formObj.f_cmd.value = SEARCH;
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0337GS.do", FormQueryString(formObj) );
			var arrXml = sXml.split("|$$|");

			// GRID UPDATE
			for(var i = 0; i < arrXml.length; i++)
			{ 
				sheetObjects[i].Redraw = false;    
				if(i > 0) sheetObjects[i].WaitImageVisible = false;	
				sheetObjects[i].LoadSearchXml(arrXml[i]); 
				sheetObjects[i].Redraw = true; 
			}

			for(var i = 0; i < sheetObj.RowCount; i++)
			{ 
				sheetObj.RowHidden(i) = false;          		
			}
			// FORM UPDATE
			if(sheetObj.EtcData('mrn_no')!=null) {
				formObj.in_mrn_no.value = sheetObj.EtcData('mrn_no').substring(0,10);
				formObj.in_mrn_chk_no.value = sheetObj.EtcData('mrn_no').substring(10,11);
			}
			formObj.snd_dt.value = sheetObj.EtcData('snd_dt')==null? '':sheetObj.EtcData('snd_dt');
			formObj.rslt_dt.value	= sheetObj.EtcData('rslt_dt')==null? '':sheetObj.EtcData('rslt_dt');
			formObj.rslt.value 		= sheetObj.EtcData('rslt')==null? '':sheetObj.EtcData('rslt');
			formObj.err_msg.value 	= sheetObj.EtcData('err_msg')==null? '':sheetObj.EtcData('err_msg');
			formObj.in_vvd.value 	= sheetObj.EtcData('vvd')==null? '':sheetObj.EtcData('vvd');
			formObj.in_port.value 	= sheetObj.EtcData('port')==null? '':sheetObj.EtcData('port');

			document.all.t1simple.innerHTML = sheetObj.EtcData('local_bl_tp_simple')==null? '0':sheetObj.EtcData('local_bl_tp_simple');
			document.all.t1console.innerHTML = sheetObj.EtcData('local_bl_tp_console')==null? '0':sheetObj.EtcData('local_bl_tp_console');
			document.all.t1empty.innerHTML = sheetObj.EtcData('local_bl_tp_empty')==null? '0':sheetObj.EtcData('local_bl_tp_empty');
			document.all.t2simple.innerHTML = sheetObj.EtcData('ts_bl_tp_simple')==null? '0':sheetObj.EtcData('ts_bl_tp_simple');
			document.all.t2console.innerHTML = sheetObj.EtcData('ts_bl_tp_console')==null? '0':sheetObj.EtcData('ts_bl_tp_console');
			document.all.t2empty.innerHTML = sheetObj.EtcData('ts_bl_tp_empty')==null? '0':sheetObj.EtcData('ts_bl_tp_empty');

			// SND_DI > 7 인경우 EDI 버튼 비활성화
			if (sheetObj.EtcData('edi_snd_ind')!=null && sheetObj.EtcData('edi_snd_ind') > 7) {
				ComBtnDisable("btn_EDISend");
			}else {
				ComBtnEnable("btn_EDISend");
			}
			ComOpenWait(false);
		}
		break;
	case COMMAND01:        //MSN CREATE				
		if(validateForm(sheetObj,formObj,sAction)){		
			if (sheetObjects[beforetab].RowCount < 1 || sheetObjects[beforetab].SelectRow < 1) {
				ComShowCodeMessage('BKG00249');
			}else {
				var params = "?type=";
				if (beforetab==0) {
					params = params + "Local";
				}else {
					params = params + "T/S";
				}
				var Row = sheetObjects[beforetab].SelectRow;
				if (sheetObjects[beforetab].CellValue(Row, "Sel")==0) {
					ComShowCodeMessage('BKG00249');
				}else {
					params = params + "&vvd=" + sheetObjects[beforetab].CellValue(Row, "vvd");
					params = params + "&mrn_no=" + formObj.in_mrn_no.value;
					params = params + "&mrn_chk_no=" + formObj.in_mrn_chk_no.value;
					params = params + "&mode=Inbound";
					params = params + "&pol=" + sheetObjects[beforetab].CellValue(Row, "pol_cd");
					params = params + "&etd=" + sheetObjects[beforetab].CellValue(Row, "vps_etd_dt");
					params = params + "&pod=" + sheetObjects[beforetab].CellValue(Row, "pod_cd");
					params = params + "&eta=" + sheetObjects[beforetab].CellValue(Row, "vps_eta_dt");
					params = params + "&cnt_bl_no=" + sheetObjects[beforetab].CellValue(Row, "cnt_bl_no");
					params = params + "&yard=" + sheetObjects[beforetab].CellValue(Row, "pod_yd_cd");
					params = params + "&pgmNo=ESM_BKG_0338";
					ComOpenWindowCenter('/hanjin/ESM_BKG_0338.do'+params, 'msnCreatePop' ,1010,650, false);
				}
			}
		}
		break;
	case COMMAND02:      // EDI SEND
		if(validateForm(sheetObj,formObj,sAction)){
			if(ComShowCodeConfirm('BKG95003', 'Transmit')){
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND02;
				sheetObj.RemoveAll();
				sheetObj.DataInsert();
				var sXml = sheetObj.doSave("ESM_BKG_0337GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			}
		}
		break;                 
	}

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
function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {
			var cnt  = 0 ;
			InsertTab( cnt++ , "LOCAL" , -1 );
			InsertTab( cnt++ , "T/S" , -1 );
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

	// LOCAL 에만 EDI 버튼 활성화
	if (nItem==0 && sheetObjects[0].EtcData("edi_snd_ind")!=null && sheetObjects[0].EtcData("edi_snd_ind") < 8 ) {
		ComBtnEnable("btn_EDISend");
	}else {
		ComBtnDisable("btn_EDISend");
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){

		if (formObj.in_vvd.value < 9) {
			ComShowCodeMessage("COM130201", "VVD");
			formObj.in_vvd.focus();
			return false;
		}
		if (formObj.in_port.value < 5) {
			ComShowCodeMessage("COM130201", "Port");
			formObj.in_port.focus();
			return false;
		}
		if (formObj.in_vvd.value.length==9) {
			// 검색조건을 위해 VVD를 분해하는 작업 (4-4-1)
			formObj.in_vsl_cd.value = formObj.in_vvd.value.substring(0,4);
			formObj.in_skd_voyage_no.value = formObj.in_vvd.value.substring(4,8);
			formObj.in_skd_dir_cd.value = formObj.in_vvd.value.substring(8,9);
		}else {
			formObj.in_vsl_cd.value = '';
			formObj.in_skd_voyage_no.value = '';
			formObj.in_skd_dir_cd.value = '';
		}

	}

	return true;
}

/**
 * Tab2 Sheet1 의 클릭 이벤트 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function t2sheet1_OnClick(sheetObj,Row, Col, Value)
{    	
	sheetObj.CellValue(Row,"Sel") = 1;
}

/**
 * Tab1 Sheet1 의 클릭 이벤트 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function t1sheet1_OnClick(sheetObj,Row, Col, Value)
{
	sheetObj.CellValue(Row,"Sel") = 1;
}

/**
 * Tab1 Sheet1 의 더블 클릭 이벤트 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function t1sheet1_OnDblClick(sheetObj, Row, Col, Value) {
	doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
}

/**
 * Tab2 Sheet1 의 더블클릭 이벤트 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function t2sheet1_OnDblClick(sheetObj, Row, Col, Value) {
	doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
}

/**
 * 키 입력 처리 
 * @return
 */
function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "saupja":
		ComKeyOnlyNumber(obj);
		break;
	case "int":
		if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
		else ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet(); break;
	case "engup":
		ComKeyOnlyAlphabet('upper'); break;
	case "engupnum":
		ComKeyOnlyAlphabet('uppernum'); break;
	case "engdn":
		if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
		else ComKeyOnlyAlphabet('lower');
		break;
	}
}
