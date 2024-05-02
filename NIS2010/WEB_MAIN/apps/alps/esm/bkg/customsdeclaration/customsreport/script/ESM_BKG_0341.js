/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0341.js
 *@FileTitle : Korea Manifest Print
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.03
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.07.03 박상훈
 * 1.0 Creation 
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0341()
{
	this.processButtonClick		= processButtonClick;
	this.checkSearchType		= checkSearchType;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.validateForm			= validateForm;
	this.obj_keypress			= obj_keypress;
	this.funcBlTypeOnChange		= funcBlTypeOnChange;
} 

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var ViewOptionBlType = '';			//'', 'S', 'C', 'E'

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;

		case "btn_listprint":
			var exceptLines = "";
			var chkCnt = 0;
			// 체크 안된 데이터들 묶음
			for(var i=1; i <= sheetObject1.RowCount; i++) {
				if (sheetObject1.CellValue(i, "Sel")==0) 
					exceptLines = exceptLines + "|" + i;
				else
					chkCnt++;
			}			
			if (chkCnt > 0) {
				var xmlUrl = "http://"+location.hostname +":"+ location.port + "/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/script/ESM_BKG_0341.xml"; 
				sheetObjects[0].Redraw = false; 
				sheetObject1.SpeedDown2Excel(-1, false, false, "", xmlUrl, false, false, "", false, "", exceptLines);
				sheetObjects[0].Redraw = true; 
			}else {
				ComShowCodeMessage('BKG00394');
			}
			break;

		case "btn_formprint":
			var chkCnt = 0;
			var params = "f_cmd="+SEARCH03;
			// 체크된 데이터들 묶음
			for(var i=1; i <= sheetObject1.RowCount; i++) {
				if (sheetObject1.CellValue(i, "Sel")==1) { 
					params = params + "&ibflag=R"+ 
							 "&vsl_cd=" + formObject.vsl_cd.value +
					         "&skd_voy_no="+formObject.skd_voy_no.value + 
					         "&io_bnd_cd="+formObject.io_bnd_cd.value + 
					         "&skd_dir_cd="+formObject.skd_dir_cd.value + 
					         "&port_cd="+formObject.port_cd.value+
					         "&mrn_no="+formObject.mrn_no.value+formObject.mrn_chk_no.value+
					         "&bkg_no="+sheetObject1.CellValue(i, "bkg_no")+
					         "&pol_cd="+sheetObject1.CellValue(i, "pol_cd")+
					         "&pod_cd="+sheetObject1.CellValue(i, "pod_cd")+
					         "&fnl_pod_cd="+sheetObject1.CellValue(i, "fnl_pod_cd")+
					         "&mrn_bl_ts_cd="+sheetObject1.CellValue(i, "mrn_bl_ts_cd");
					chkCnt++;
				}
			}			
			if (chkCnt > 0) {	
				sheetObject2.WaitImageVisible = false;
				ComOpenWait(true);
				// Sheet2에 조회 XML 생성
				var sXml = sheetObject2.GetSearchXml("ESM_BKG_0341GS.do", params, "", true);
				sheetObject2.LoadSearchXml(sXml, false, -1, false);
				// 정렬
				sheetObject2.ColumnSort("msn_no");
				ComOpenWait(false);
				// BOUND 에 따라 처리
				if (formObject.io_bnd_cd.value=="I") {
					ComOpenWindowCenter("/hanjin/ESM_BKG_0827.do?pgmNo=ESM_BKG_0827", "0827", 1024, 720, false);
				}else {
					ComOpenWindowCenter("/hanjin/ESM_BKG_5029.do?pgmNo=ESM_BKG_5029", "5029", 1024, 720, false);
				}
			}else {
				ComShowCodeMessage('BKG00394');
				ComOpenWait(false);
			}
			break;																					

		case "btn_selectAll":
			for(var i=1; i <= sheetObjects[0].RowCount; i++) {
				sheetObjects[0].CellValue(i, "Sel") = 1; 
			}
			break;																					
		case "btn_deselectAll":
			for(var i=1; i <= sheetObjects[0].RowCount; i++) {
				sheetObjects[0].CellValue(i, "Sel") = 0; 
			}
			break;				
		case "mrn_no":
			formObject.search_type[1].checked=true;
			checkSearchType();
			break;
		case "vvd":
			formObject.search_type[0].checked=true;
			checkSearchType();
			break;
		case "port_cd":
			formObject.search_type[0].checked=true;
			checkSearchType();
			formObject.port_cd.focus();
			break;
		case "btn_mrn_search":
			var sUrl = "ESM_BKG_0358.do?mrn_no="+formObject.mrn_no.value;
			sUrl = sUrl + "&pgmNo=ESM_BKG_0358";
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0358", 1024, 600, true);
  			if (rtnVal != null) {
  				formObject.mrn_no.value 	= rtnVal.mrn_no;
  				formObject.mrn_chk_no.value = rtnVal.mrn_chk_no;
  				formObject.search_type[1].checked=true;
  			}
			break;
		case "search_type": // 활성/비활성화 처리
			checkSearchType();
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
* 체크박스 활성 체크 
* @return
*/
function checkSearchType()
{
	var formObject = document.form;
	if (formObject.search_type[1].checked) {
		formObject.mrn_no.className= "input1";
		formObject.vvd.className= "input2";
		formObject.port_cd.className= "input2";
		formObject.mrn_no.focus();
	}else {
		formObject.vvd.className= "input1";
		formObject.port_cd.className= "input1";
		formObject.mrn_no.className= "input2";
		formObject.vvd.focus();
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

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	checkSearchType();
}


/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
	case "sheet1":      //sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 400;

		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 1, 1, 3, 100);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(17, 0, 0, true); 

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false)

		var HeadTitle = "|Sel.|Seq|MSN|BKG No.|B/L No.|Local\n/T/S|POL|POD|Type|Final\nPOD|Cutoms Description|Consignee Name|Notify Name|DG\nClass|Bonded W/H Detail|";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);


		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,   	daCenter,  	 false,		"Status");
		InitDataProperty(0, cnt++ , dtCheckBox,		45,     daCenter,    false,     "Sel",      			false,    "",      dfNone, 			0,     true,		false,  	0, false, false);
		InitDataProperty(0, cnt++ , dtDataSeq,	   	35,     daCenter,    false,     "Seq",         			false,    "",      dfNone, 			0,     false,		false,		0, false, false);
		InitDataProperty(0, cnt++ , dtData,      	40,     daCenter,    false,     "mf_seq_no",   			false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	95,     daCenter,    false,     "bkg_no",      			false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	100,    daCenter,    false,     "bl_no",       			false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	60,     daCenter,    false,     "mrn_bl_ts_cd", 		false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
		InitDataProperty(0, cnt++ , dtData,      	50,     daCenter,    false,     "pol_cd",     			false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	60,     daCenter,    false,     "pod_cd",     			false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	50,     daCenter,    false,     "kr_cstms_bl_tp_cd",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	70,     daCenter,    false,     "fnl_pod_cd",   		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	340,    daLeft,	     false,     "cstms_desc",   		false,    "",      dfNone, 			0,     false,		false,	4000);
		InitDataProperty(0, cnt++ , dtData,      	180,    daLeft,	     false,     "cust_c_nm",   			false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
		InitDataProperty(0, cnt++ , dtData,      	180,    daLeft,   	 false,     "cust_n_nm",  			false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	70,     daCenter,    false,     "imdg_clss_cd", 		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      	150,    daLeft,    	 false,     "wh_name",  			false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtHidden,      	  0,    daCenter,    false,     "bl_tp",  				false,    "",      dfNone, 			0,     false,		false);
	}
	break;
	case "sheet2":      //sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 0;
		
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		
		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;
		
		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;
		
		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 1, 1, 3, 100);
		
		var HeadTitle = "|MRN_NO|MRN_BL_TS_CD|VSL_ENG_NM|SKD_VOY_NO|CALL_SGN_NO|CNT_NM|LOC1_INFO|LOC2_INFO|VPS_ETB_DT|MSN_NO|BL_TP_CD|BL_NO|BKG_CUST_TP_CD|CUST_INFO|C_INFO|N_INFO|S_INFO|CNTR_INFO|CSTMS_DESC|PCK_QTY|TOT_WGT|IMDG_UN_NO|WH_NM|VPS_ETD_DT";
		var headCount = ComCountHeadTitle(HeadTitle);
		
		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true); 
		
		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false)
		
		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);
		
		
		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,   daCenter,    false,  	   "ibflag");
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "mrn_no",   		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "mrn_bl_ts_cd",  	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "vsl_eng_nm",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "skd_voy_no",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "call_sgn_no",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "cnt_nm",   		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "loc1_info",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "loc2_info",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "vps_etb_dt",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "msn_no",   		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "bl_tp_cd",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "bl_no",   		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "bkg_cust_tp_cd",	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "cust_info",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "c_cust_info",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "n_cust_info",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "s_cust_info",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "cntr_info",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "cstms_desc",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "pck_qty",   		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "tot_wgt",   		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "imdg_un_no",   	false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "wh_nm",   		false,    "",      dfNone, 			0,     false,		false);
		InitDataProperty(0, cnt++ , dtData,      100,     daCenter,    false,     "vps_etd_dt",   	false,    "",      dfNone, 			0,     false,		false);
	}
	break;


	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	
	switch(sAction) {
	case IBSEARCH:      //조회
		formObj.f_cmd.value = SEARCH;
		if(validateForm(sheetObj,formObj,sAction)) {	
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			// OUTBOUND는 E혹은 R로 바꾸기 위한 처리
			if (formObj.io_bnd_cd.value=="O") {
				if (formObj.mrn_bl_ts_cd2.value=="I") {
					formObj.mrn_bl_ts_cd.value="E";
				}else if (formObj.mrn_bl_ts_cd2.value=="T") {
					formObj.mrn_bl_ts_cd.value="R";
				}else {
					formObj.mrn_bl_ts_cd.value="";
				}
			}else {
				formObj.mrn_bl_ts_cd.value = formObj.mrn_bl_ts_cd2.value;
			}
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0341GS.do", FormQueryString(formObj));
			sheetObjects[0].Redraw = false; 
			sheetObjects[0].LoadSearchXml(sXml);
			// 전체 선택상태로
			sheetObjects[0].CheckAll(1)=1; 
			sheetObjects[0].Redraw = true;
			// FORM 값 적용
			ComEtcDataToForm(formObj, sheetObj);
			formObj.mrn_no.value	 = sheetObj.EtcData("mrn_no");
			formObj.vvd.value 		 = sheetObj.EtcData("vvd");
			formObj.vvd.value		 = sheetObj.EtcData("vvd");
			formObj.vsl_cd.value 	 = formObj.vvd.value.substring(0,4);
			formObj.skd_voy_no.value = formObj.vvd.value.substring(4,8);
			formObj.skd_dir_cd.value = formObj.vvd.value.substring(8,9);
			// Bound 구분에 따른 타이틀 변경
			if (formObj.io_bnd_cd.value=='I') {
				sheetObjects[0].CellValue(0, "cust_c_nm") =  "Consignee Name";
				sheetObjects[0].CellValue(0, "cust_n_nm") =  "Notify Name";
			}else {
				sheetObjects[0].CellValue(0, "cust_c_nm") = "Shipper Name";
				sheetObjects[0].CellValue(0, "cust_n_nm") = "Consignee Name";
			}
			if(formObj.bl_type.value != ''){
				funcBlTypeOnChange();
			}
			ComOpenWait(false);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.search_type[0].checked) {
			if (formObj.vvd.value.length < 9 ) {
				ComShowCodeMessage('BKG00203');
				formObj.vvd.focus();
				return false;
			}			
			if (formObj.port_cd.value.length < 5) {
				ComShowCodeMessage('BKG00203');
				formObj.port_cd.focus();
				return false;
			}
			formObj.vsl_cd.value 	 = formObj.vvd.value.substring(0,4);
			formObj.skd_voy_no.value = formObj.vvd.value.substring(4,8);
			formObj.skd_dir_cd.value = formObj.vvd.value.substring(8,9);

		}else {
			if (formObj.mrn_no.value.length < 9) {
				ComShowCodeMessage('BKG00689');
				formObj.mrn_no.focus();
				return false;
			}
		}
	}

	return true;
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
	case "num":
		ComKeyOnlyNumber(obj);
		break;
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
 
 /**
  * BL TYPE 변경처리 
  * @param obj
  * @return
  */
 function funcBlTypeOnChange()
 {
	var formObject = document.form;
 	ViewOptionBlType = formObject.bl_type.value;
 	funcShowValueRows();
 }
 
 /**************************************************************************************************
  * IBSheet 내용을 특정 데이타만 걸러내서 보여주기
  * @param sheetObj : IBSheetName
  *        flagName : IBSheet에서 Show,Hidden여부를 판단할 대상필드명
  *        hiddenValue : IBSheet에서 Hidden여부를 결정지을 값
  * @return void
  **************************************************************************************************/
 function funcShowValueRows()
 {
 	var sheetObj = sheetObjects[0];
 	if(ViewOptionBlType == '' )
 	{
 		for(var i=1 ; i <= sheetObj.RowCount ; i++)
 		{
 			sheetObj.RowHidden(i) = false;
 		}
 	}
 	else
 	{
 		for(var i=1 ; i <= sheetObj.RowCount ; i++)
 		{
 			if(ViewOptionBlType != '')
 			{
 				if (sheetObj.CellValue(i, "bl_tp") != ViewOptionBlType) {
 					sheetObj.RowHidden(i) = true;
 					continue;
 				}
 			}
 			sheetObj.RowHidden(i) = false;
 		}
 	}
 }