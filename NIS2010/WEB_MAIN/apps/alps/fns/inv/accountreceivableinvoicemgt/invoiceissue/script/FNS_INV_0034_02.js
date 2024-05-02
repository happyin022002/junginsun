/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_inv_0034_02.js
 *@FileTitle : Invoice Issue (Email)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.06
 *@LastModifier : 정휘택
 *@LastVersion : 1.0
 * 2009.07.06 정휘택
 * 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.06 최도순 [CHM-201005730] DXBSC의 화주 LPO No 입력란 확대 요청
* 2012.03.12 권   민 [CHM-201216480] SAOSC의 인보이스 이슈 기능 개발 요청
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
 * fns_inv_0034_02 : fns_inv_0034_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     fns_inv_0034_02()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function fns_inv_0034_02() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
	this.initRdConfig			= initRdConfig;
	this.rdOpen					= rdOpen;
	this.setUploadObject		= setUploadObject;
}

/* 개발자 작업	*/

// 공통전역변수

var ROWMARK = "|";
var FIELDMARK = "^";

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var uploadObjects = new Array();
var uploadCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
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
			//alert("btn_retrieve");
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;

		case "btn_preview":
			//alert("btn_preview");
			invPreview(sheetObject1, formObject);
			break; 
		
		case "btn_oldPreview":	
			btnOldPreview(sheetObject1, formObject);
			break; 
		case "btn_oldSend":
			invOldSend(sheetObject1, formObject);      					
			break; 
		case "btn_send":
			//alert("btn_send");   
			invSend(sheetObject1, formObject);      					
			break; 

		case "btn_close":
			window.close();
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
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function setSheetObject(sheetObj){

	sheetObjects[sheetCnt++] = sheetObj;

}

/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     loadPage()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function loadPage() {

	var formObject = document.form;

	if (formObject.issue_gubn.value == "I") {

		formObject.f_inv.value = opener.document.form.f_inv.value;
		formObject.t_inv.value = opener.document.form.t_inv.value;
		formObject.flag.value = "M";
		formObject.copy_cnt.value = opener.document.form.copy_cnt.value;
		//formObject.iss_ofc_cd.value = "HKGSC"; 
		formObject.iss_ofc_cd.value = opener.document.form.ar_ofc_cd2.value; 
			
		if (formObject.iss_ofc_cd.value == "SYDSC") {
			formObject.sydbb_exrate_type.value = (opener.document.form.exrate_type[0].checked ? "A" : "U");
			// A : AUD, U : USD
		}
		
//			if (formObject.iss_ofc_cd.value == "DXBSC") {
//				formObject.issue_type.value = (opener.document.form.issue_type[0].checked ? "P" : "F");
//			}
		
	// 구분이 "S"인 신규 0130 화면의 추가
	} else if (formObject.issue_gubn.value == "S") {

		// IF_NO, INV NOs(복수)를 파라미터로 받는다.
		formObject.if_no.value = opener.document.form.ar_if_no.value;
		// inv no들이 f_inv에 'inv1','inv2','inv3'.... 형태로 온다 (소스의 간략화를 위해 from to의 의미에서 변형됨..)
		formObject.f_inv.value = opener.document.form.f_inv.value;
		// t_inv의 값으 의미가 없음.
		//formObject.t_inv.value = opener.document.form.t_inv.value;

		formObject.flag.value = "S"; //타입은 싱글만 존재
		formObject.copy_cnt.value = opener.document.form.copy_cnt.value;
		formObject.iss_ofc_cd.value = opener.document.form.ar_ofc_cd2.value; 
	
		// 구분이 "SS"인 신규 0135 화면의 추가
	} else if (formObject.issue_gubn.value == "SS") {
            
			// IF_NO, INV NOs(복수)를 파라미터로 받는다.
			formObject.if_no.value = "";
			
			// inv no들이 f_inv에 'inv1','inv2','inv3'.... 형태로 온다 (소스의 간략화를 위해 from to의 의미에서 변형됨..)
			formObject.f_inv.value = opener.document.form.invs_email.value;
			formObject.invs.value = opener.document.form.invs_email.value;
			// t_inv의 값은 의미가 없음.
			//formObject.t_inv.value = opener.document.form.t_inv.value;

			formObject.flag.value = "S"; //타입은 싱글만 존재
			formObject.copy_cnt.value = opener.document.form.copy_cnt.value;
			formObject.iss_ofc_cd.value = opener.document.form.ar_ofc_cd2.value; 

	} else {

		formObject.invs.value = opener.document.form.invs_email.value;
		formObject.f_inv.value = opener.document.form.f_inv.value;
		formObject.t_inv.value = opener.document.form.t_inv.value;
		
		if(opener.document.form.sel_option[0].checked){
			formObject.flag.value = "S"; //Single
		} else if (opener.document.form.sel_option[2].checked){
			formObject.flag.value = "IF";  //IF No
		} else {
			formObject.flag.value = "M"; //Multi
		}
//		formObject.flag.value = (opener.document.form.sel_option[0].checked ? "S" : "M");

		formObject.copy_cnt.value = opener.document.form.copy_cnt.value;
		//formObject.iss_ofc_cd.value = opener.document.form.iss_ofc_cd.value;   
		formObject.iss_ofc_cd.value = opener.document.form.ar_ofc_cd2.value; 
		
//			formObject.issue_type.value = "F";
		
		if (formObject.iss_ofc_cd.value == "SGNSC") {
			
			formObject.send_type[1].checked = true;
			formObject.send_type[0].disabled = true;
			formObject.send_type[3].disabled = true;
			formObject.send_type[4].disabled = true;
							
		}
		
		if (formObject.iss_ofc_cd.value == "LEHSC") {
			formObject.logo_gb1.disabled = false;
			formObject.logo_gb2.disabled = false;
			formObject.logo_gb1.checked = false;
			formObject.logo_gb2.checked = false;
			formObject.iss_lehbb.value = "Y";
			logoGbChk();
			document.all.layer1.style.display = "";
			document.all.layer2.style.display = "";
		}else{
			formObject.logo_gb1.disabled = true;
			formObject.logo_gb2.disabled = true;
			formObject.logo_gb1.checked = false;
			formObject.logo_gb2.checked = false;
			document.all.layer1.style.display = "none";
			document.all.layer2.style.display = "none";
		}
		
		if (formObject.iss_ofc_cd.value == "SYDSC") {
			formObject.sydbb_exrate_type.value = (opener.document.form.exrate_type[0].checked ? "A" : "U");
			// A : AUD, U : USD
		}

	}

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);

		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
	}

	initRdConfig(rdObjects[0]);
	initRdConfig(rdObjects[1]);
	ComConfigUpload(uploadObjects[0], "/hanjin/FNS_INV_0034_02GS.do");
	sheetObjects[0].ColHidden("f_add") = true;
	sheetObjects[0].ColHidden("f_del") = true;
	sheetObjects[0].ColHidden("f_copy") = true;
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	sheetObjects[0].ColHidden("f_add") = false;
	sheetObjects[0].ColHidden("f_del") = false;
	sheetObjects[0].ColHidden("f_copy") = false;


}

/**	 
 * logo_gb1, logo_gb2 클릭시 값 세팅 <br>
 * <br><b>Example :</b>
 * <pre>
 *     
 * </pre>
 * @param 없음
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function logoGbChk(){
	var formObject = document.form;
	if (formObject.iss_ofc_cd.value == "LEHSC") {
		if(formObject.logo_gb1.checked == true && formObject.logo_gb2.checked == false){
			formObject.logo_gb.value = "1";			
		}
		if(formObject.logo_gb1.checked == false && formObject.logo_gb2.checked == true){
			formObject.logo_gb.value = "2";			
		}
		if(formObject.logo_gb1.checked == true && formObject.logo_gb2.checked == true){
			formObject.logo_gb.value = "3";			
		}
		if(formObject.logo_gb1.checked == false && formObject.logo_gb2.checked == false){
			formObject.logo_gb.value = "";			
		}
	}	
}

/**	 
 * send_type 클릭시 값 세팅 <br>
 * <br><b>Example :</b>
 * <pre>
 *    
 * </pre>
 * @param 없음
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function sendTypeChk(){
	var formObject = document.form;
	if (formObject.iss_ofc_cd.value == "LEHSC") {
		if (formObject.send_type[0].checked || formObject.send_type[1].checked || formObject.send_type[2].checked){
			formObject.logo_gb1.disabled = false;
			formObject.logo_gb2.disabled = false;
			formObject.logo_gb1.checked = false;
			formObject.logo_gb2.checked = false;
			formObject.iss_lehbb.value = "Y";
				logoGbChk();
		}else{
			formObject.logo_gb1.disabled = true;
			formObject.logo_gb2.disabled = true;
			formObject.logo_gb1.checked = false;
			formObject.logo_gb2.checked = false;
			formObject.logo_gb.value = "";
			formObject.iss_lehbb.value = "";
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의 <br> 
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj, 0)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
 * @return 없음 
 * @author 정휘택
 * @version 2009.10.20     
 */  
function initSheet(sheetObj,sheetNo) {

	var formObject = document.form;
	var cnt = 0;

	switch(sheetNo) {
	case 1:      //t2sheet1 init
	with (sheetObj) {

		SelectionMode = smSelectionList;				    
		//ClipPasteMode = 1;

		//SelectHighLight = false;
		// 높이 설정
		style.height = 480;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;                       

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);			// 단위 데이터 행의 맨 아래 Row를 RowHidden 속성으로 구분한다.

		var HeadTitle1 = "|Sel.|VVD|Cust. Code|Cust. Name|Invoice No.|LPO No.|E-mail Address|Fax No.|INV Ref. No.|I/F No.|B/L No.|Port Cd.|Remark(s)|inv_rmk2||Attach letter by VVD||Attach letter by Cust.|Attach more from my PC|Attach more from my PC|Attach more from my PC|Attach more from my PC|File Key|Inv Seq.|CMB FLG||";
		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 6, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
		InitHeadMode(false, true, true, true, false, false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성            [ROW, COL,   DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0,   cnt++, dtHiddenStatus,  30,    daCenter,  false,   "ibflag");

		InitDataProperty(0,   cnt++, dtCheckBox, 50,    daCenter,  false,    "slt",   	   false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "vvd",   	   false,    "",         dfNone,	 0,          false,      false);
		InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "cust_cd",    false,    "",         dfNone,	 0,          false,      false);
		InitDataProperty(0,   cnt++, dtData,   	 215,   daLeft,    false,    "cust_nm",    false,    "",         dfNone,	 0,          false,      false);
		InitDataProperty(0,   cnt++, dtData,   	 105,   daCenter,  false,    "inv_no",     false,    "",         dfNone,	 0,          false,      false);
		if (formObject.iss_ofc_cd.value == "DXBSC") {
//				if (formObject.issue_type.value == "F") {
//					InitDataProperty(0,   cnt++, dtComboEdit,   	 180,   daCenter,  false,    "locl_po_no", false,    "",         dfNone,	 0,          true,      true, 25);
//				} else {
//					InitDataProperty(0,   cnt++, dtComboEdit,   	 180,   daCenter,  false,    "locl_po_no", false,    "",         dfNone,	 0,          false,      false, 25);
//				}	
            //InitDataProperty(0,   cnt++, dtComboEdit,   	 200,   daCenter,  false,    "locl_po_no", false,    "",         dfNone,	 0,          true,      true, 25);
            InitDataProperty(0,   cnt++, dtData,   	 200,   daCenter,  false,    "locl_po_no", false,    "",         dfNone,	 0,          true,      true, 25);
		} else {
			InitDataProperty(0,   cnt++, dtHidden,   	 200,   daCenter,  false,    "locl_po_no", false,    "",         dfNone,	 0,          true,      true, 25);
		}

		InitDataProperty(0,   cnt++, dtData,   	 200,   daLeft,    false,    "cust_eml",      false,    "",         dfNone,     0,          true,       true);
		InitDataProperty(0,   cnt++, dtData,   	 200,   daLeft,    false,    "cust_fax_no",   	   false,    "",         dfNone,	 0,          true,       true);

		InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "inv_ref_no", false,    "",         dfNone,	 0,          false,      false);
		InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "ar_if_no",   false,    "",         dfNone,	 0,          false,      false);
		InitDataProperty(0,   cnt++, dtData,   	 100,   daCenter,  false,    "bl_src_no",  false,    "",         dfNone,	 0,          false,      false);

		InitDataProperty(0,   cnt++, dtHidden,   50,    daCenter,  false,    "port_cd",    false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtPopup,    70,    daCenter,  false,    "inv_rmk",    false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtHidden,   100,   daCenter,  false,    "inv_iss_rmk",   false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtCheckBox, 20,    daCenter,  false,    "attach",     false,    "",         dfNone,	 0,          true,       true, 0, false, false, false, true);
		InitDataProperty(0,   cnt++, dtPopup,    125,   daCenter,  false,    "attach_view",    false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtCheckBox, 20,    daCenter,  false,    "attach2",     false,    "",         dfNone,	 0,          true,       true, 0, false, false, false, true);
		InitDataProperty(0,   cnt++, dtPopup,    130,   daCenter,  false,    "attach_view2",    false,    "",         dfNone,	 0,          true,       true);

		InitDataProperty(0,   cnt++, dtImage,    50,    daCenter,  false,    "f_add",      false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtImage,    75,    daCenter,  false,    "f_del",      false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtImage,    140,    daCenter,  false,    "f_copy",      false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtData,     200,   daCenter,  false,    "f_name",     false,    "",         dfNone,	 0,          false,      false);
		InitDataProperty(0,   cnt++, dtHidden,   100,   daCenter,  false,    "f_key",      false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtHidden,   50,    daCenter,  false,    "inv_seq",    false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtHidden,   10,   daCenter,  false,    "inv_iss_cmb_flg",      false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtHidden,   10,   daCenter,  false,    "inv_eml_split_flg",      false,    "",         dfNone,	 0,          true,       true);
		InitDataProperty(0,   cnt++, dtHidden,   10,   daCenter,  false,    "if_no",      false,    "",         dfNone,	 0,          true,       true);

		ImageList(0) = "img/btng_add.gif";
		ImageList(1) = "img/btng_delete.gif";
		ImageList(2) = "img/btng_copy_to_same_vvd.gif";
		//InitDataValid(0,    "locl_po_no",   vtEngOther, "1234567890");
		
		//InitDataCombo(0, "locl_po_no",  "NONE", "NONE");

		ShowButtonImage = 2;							
		CountPosition = 2;

		WordWrap = true;
		//Ellipsis = true;

	}
	break;
	
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
 * @author 정휘택
 * @version 2009.10.20
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회

	formObj.f_cmd.value = SEARCH01;
	//sheetObj.DoSearch("FNS_INV_0034_02GS.do", FormQueryString(formObj));
	var sXml = sheetObj.GetSearchXml("FNS_INV_0034_02GS.do", FormQueryString(formObj));
	sheetObj.LoadSearchXml(sXml);

	var vvd = "";
	var cust_cd = "";
	var inv_no = "";
	var if_cd = "";
	var bl_no = "";
	var rows = "";		      	    

	// vvd, cust_cd, inv_no 가 같을때 row 병합처리
	for (var idx = 0; idx < sheetObj.RowCount + 1; idx++){

		if(vvd == sheetObj.CellValue(idx, "vvd") && cust_cd == sheetObj.CellValue(idx, "cust_cd") && inv_no == sheetObj.CellValue(idx, "inv_no")) {
			if_cd = sheetObj.CellValue(idx - 1, "ar_if_no");
			if_cd = if_cd + "\r\n" + sheetObj.CellValue(idx, "ar_if_no");
			bl_no = sheetObj.CellValue(idx - 1, "bl_src_no");
			bl_no = bl_no + "\r\n" + sheetObj.CellValue(idx, "bl_src_no");

			rows = rows + (idx - 1) + "|";

			sheetObj.CellValue(idx, "ar_if_no") = if_cd;
			sheetObj.CellValue(idx, "bl_src_no") = bl_no;
		} else{
			if_cd = "";
			bl_no = "";

		}

		vvd = sheetObj.CellValue(idx, "vvd");
		cust_cd = sheetObj.CellValue(idx, "cust_cd");
		inv_no = sheetObj.CellValue(idx, "inv_no");

	}

	var arrRow = rows.split("|");

	for (var idx = arrRow.length - 2; idx >= 0; idx--){

		//sheetObj.RowHidden(Number(arrRow[idx])) = true;
		sheetObj.RowDelete(Number(arrRow[idx]), false);

	}

	sheetObj.CheckAll("slt") = 1;   
	
	if (formObj.iss_ofc_cd.value == "DXBSC") {
		
		for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
			//alert(sheetObj.CellValue(idx, "inv_no").substr(2,1));
			if (sheetObj.CellValue(idx, "inv_no").substr(2,1) == "P") {
				sheetObj.CellEditable(idx, "locl_po_no") = false;					
			}

		}
		
	}
	
	// 0130.js 중복허용 OFC 대응 - RD에 IF_NO를 설정해야한다. 
	if (formObj.iss_ofc_cd.value == "BOMSC" || formObj.iss_ofc_cd.value == "SAOSC" ) {
		
		for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
			sheetObj.CellValue(idx, "if_no") = formObj.if_no.value;
		}
	}
	
	var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
	formObj.print_nm.value = sStr;

	break;

	case IBSAVE:        //저장	    		
	
	formObj.f_cmd.value = MULTI01;    
	//	sheetObj.DoSave("FNS_INV_0034_02GS.do", FormQueryString(formObj)); 	

	var sParam = FormQueryString(formObj);					
	var sParam1 = sheetObj.GetSaveString(false, true, 1); 	

	if (sParam1 == "") {	
		formObj.state.value = "";
		return; 
	} else {
		sParam1 = ComSetPrifix(sParam1, "sheet1_");
		sParam = sParam + "&" + sParam1;					   
	}				    

	var sXml = sheetObj.GetSaveXml("FNS_INV_0034_02GS.do", sParam);	
	//sheetObj.LoadSaveXml(sXml);				       
	var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	formObj.state.value = state;
	var issueCnt = ComGetEtcData(sXml, "issueCnt");
	formObj.issueCnt.value = issueCnt;

	break;

	case IBINSERT:      // 입력

	formObj.f_cmd.value = MULTI02;    			
	sheetObj.DoSearch("FNS_INV_0034_02GS.do", FormQueryString(formObj));
	var sXml = sheetObj.GetSearchXml("FNS_INV_0034_02GS.do", FormQueryString(formObj));
	var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	formObj.state.value = state;

	break;
	}
}

/**
 * Invoice Remark(FNS_INV_0087) 화면 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     sheet1_OnPopupClick(sheetObj, Row, Col)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row ibsheet 해당 row
 * @param {int} Col ibsheet 해당 col
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */       
function sheet1_OnPopupClick(sheetObj, Row, Col)
{

	if (sheetObj.ColSaveName(Col) == "inv_rmk") {
		ComOpenWindowCenter("FNS_INV_0087.do", "pop2", 700, 259);

	} else if (sheetObj.ColSaveName(Col) == "attach_view") {
		if (sheetObj.CellValue(sheetObj.SelectRow, "attach_view") == "YES") {
			invPreviewWordingByVVD(sheetObj, document.form);
		}

	} else if (sheetObj.ColSaveName(Col) == "attach_view2") {
		if (sheetObj.CellValue(sheetObj.SelectRow, "attach_view2") == "YES") {
			invPreviewWordingByCust(sheetObj, document.form);
		}

	}

}

/**
 * RD Preview(FNS_INV_0034_02_prev) 화면 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     invPreviewWordingByVVD(sheetObj, formObj)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function invPreviewWordingByVVD(sheetObj, formObj) {     	

	var rdFile = "FNS_INV_0524_vvd.mrd"+"|";
	var ofc_cd = formObj.iss_ofc_cd.value;

	var vvd = sheetObj.CellValue(sheetObj.SelectRow, "vvd");
	var port_cd = sheetObj.CellValue(sheetObj.SelectRow, "port_cd");

	var	rdParam = "/rv frm1_ar_ofc_cd["+ofc_cd+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"]"+"|";

	formObj.com_mrdPath.value = rdFile ;
	formObj.com_mrdArguments.value = rdParam;

	ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=L", "pop3", 800, 700);

}

/**
 * RD Preview(FNS_INV_0034_02_prev) 화면 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     invPreviewWordingByCust(sheetObj, formObj)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function invPreviewWordingByCust(sheetObj, formObj) {     	

	var rdFile = "FNS_INV_0524_cust.mrd"+"|";
	var ofc_cd = formObj.iss_ofc_cd.value;

	var cust_cd = sheetObj.CellValue(sheetObj.SelectRow, "cust_cd");

	var	rdParam = "/rv frm1_ar_ofc_cd["+ofc_cd+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]"+"|";

	formObj.com_mrdPath.value = rdFile ;
	formObj.com_mrdArguments.value = rdParam;

	ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=L", "pop3", 800, 700);

}      

/**
 * RD Preview(FNS_INV_0034_02_prev) 화면 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     invPreview(sheetObj, formObj)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function invPreview(sheetObj, formObj) {

	var sRow = sheetObj.FindCheckedRow(1);
	if (sRow == "") {
		ComShowCodeMessage("INV00025");
		//return 0;
	}  

	var rdFile = "";
	var rdFiles = "";
	var ofc_cd = formObj.iss_ofc_cd.value;
	var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
	var flag = formObj.flag.value;
	
//alert(flag);
//		var issue_type = "";

	if (ofc_cd == "HAMSC" || ofc_cd == "HAMRU") {
		rdFile = "FNS_INV_0503.mrd";
	} else if (ofc_cd == "GOASC") {
		rdFile = "FNS_INV_0504.mrd";
	} else if (ofc_cd == "ANRSO") {
		rdFile = "FNS_INV_0505.mrd";
	} else if (ofc_cd == "BUDSC") {
		rdFile = "FNS_INV_0506.mrd";
	} else if (ofc_cd == "RTMSC") {
		rdFile = "FNS_INV_0507.mrd";
	} else if (ofc_cd == "GDYSC") {
		rdFile = "FNS_INV_0508.mrd";
	} else if (ofc_cd == "PRGSC") {
		rdFile = "FNS_INV_0509.mrd";
	} else if (ofc_cd == "VLCSC") {
		rdFile = "FNS_INV_0510.mrd";
	} else if (ofc_cd == "SINSC") {
		rdFile = "FNS_INV_0511.mrd";
	} else if (ofc_cd == "PKGSC") {
		rdFile = "FNS_INV_0512.mrd";
	} else if (ofc_cd == "CMBSC") {
		rdFile = "FNS_INV_0513.mrd";
	} else if (ofc_cd == "SYDSC") {
		if(sydbb_exrate_type == "U"){
			rdFile = "FNS_INV_0545.mrd";
		} else {
			rdFile = "FNS_INV_0515.mrd";
		}
	} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
		rdFile = "FNS_INV_0516.mrd";
	} else if (ofc_cd == "HKGSC") {
		rdFile = "FNS_INV_0518.mrd";
	} else if (ofc_cd == "FXTSC" || ofc_cd == "LONBC1") {
		rdFile = "FNS_INV_0521.mrd";
	} else if (ofc_cd == "LEHSC") {
		rdFile = "FNS_INV_0522.mrd";
		//		} else if (ofc_cd == "SGNSC") {
		//		if (cmbFlg == "Y") {
		//		rdFile = "FNS_INV_0520_MULTI.mrd";
		//		} else {
		//		rdFile = "FNS_INV_0520_SINGLE.mrd";
		//		}	
	} else if (ofc_cd == "JKTSC") {
		rdFile = "FNS_INV_0527.mrd";
	} else if (ofc_cd == "DXBSC") {
		rdFile = "FNS_INV_0530.mrd";
	} else if (ofc_cd == "BKKSC") {
		rdFile = "FNS_INV_0540.mrd";
	} else if (ofc_cd == "DACSC") {
		rdFile = "FNS_INV_0541.mrd";

	
	// 중복 체크 OFC  (부모창이 0130일경우)	
	} else if (ofc_cd == "BOMSC") {
		if (document.form.issue_gubn.value == "S" ) {
			rdFile = "FNS_INV_0550.mrd";     //2018.05.16 인도지역 Split Invoice Issue 기능 보완 (0543 -> 0550 으로 변경)
		}else {
			 if (flag == "IF" ){ 
					rdFile = "FNS_INV_0546.mrd";
			 } else {
				 	//2017.07.31 인도 GST 세법 변경 관련 보완
				 	if(document.form.issue_gubn.value == "R" && opener.document.form.ind_type[1].checked) {
				 		rdFile = "FNS_INV_0514.mrd";
				 	} else {
				 		rdFile = "FNS_INV_0548.mrd";
				 	}
			 }
		}
	} else if (ofc_cd == "SAOSC") {
		if (document.form.issue_gubn.value == "S" || document.form.issue_gubn.value == "SS" ) {  // S-Split, SS-Split Reissue
			rdFile = "FNS_INV_0544.mrd";
		} else {
			rdFile = "FNS_INV_0542.mrd";
		}
	} else if (ofc_cd == "MNLBA") {
		rdFile = "FNS_INV_0512.mrd";
	}
	
//alert(rdFile);

	var ar_ofc_cd = ofc_cd;
	if (ofc_cd == "BOMSC" || ofc_cd == "SYDSC" || ofc_cd == "FXTSC" || ofc_cd == "LEHSC" || ofc_cd == "SGNSC") {
		ofc_cd = document.form.login_ofc_cd.value;
	}

//		if(ofc_cd == "DXBSC"){			
//			issue_type = formObj.issue_type.value;
//		}
					
	//REISSUE -  LEHSC 일 경우--------끝
	
	var arrRow = sRow.split("|");
	var rdParam = "";

	for (var idx = 0; idx < arrRow.length - 1; idx++){

		var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
		var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
		var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
		//		var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
		//		var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
		var attach = "N";
		var attach2 = "N";
		var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
		var cmb_flg = sheetObj.CellValue(arrRow[idx], "inv_iss_cmb_flg");
		
		var logo = "ORIGINAL";
		//REISSUE - LEHSC 일 경우--------시작
		if (formObj.iss_lehbb.value == "Y") {
			if(formObj.logo_gb.value == "1"){
				logo = "COPIE2";
			}else if(formObj.logo_gb.value == "2"){
				logo = "COPY";
			}else if(formObj.logo_gb.value == "3"){
				logo = "COPIE2";
			}
		}
		
		if (ar_ofc_cd == "SGNSC") {

			if (cmb_flg == "Y") {
				rdFiles = rdFiles +"FNS_INV_0531_MULTI.mrd" +"|";
			} else {
				rdFiles = rdFiles +"FNS_INV_0531_SINGLE.mrd" +"|";
			}

			rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_inv_gb ["+inv_no.substr(0,1)+"] frm1_ar_ofc_cd["+ar_ofc_cd+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";


		} else {
//alert(ofc_cd);
			rdFiles = rdFiles + rdFile +"|";				
			// 부모창이 0130인 경우 RD파라미터에 IF_NO를 설정한다.
			if (document.form.issue_gubn.value == "S"  || document.form.issue_gubn.value == "SS") {
				if (document.form.issue_gubn.value == "S") { //부모창이 0130
					var if_no = document.form.if_no.value;	
				} else { // SS - 부모창이 0135
					var if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");
				}
				rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_ar_if_no["+if_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
			} else {
				if (ar_ofc_cd == "BOMSC" && flag == "IF") {
					var if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");
					rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_ar_if_no["+if_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
//alert(rdParam);
				} else {
					rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
				}
			}
			if (formObj.iss_lehbb.value == "Y" && formObj.logo_gb.value == "3") {
				logo = "COPY";
				rdFiles = rdFiles + rdFile +"|";
				// 부모창이 0130인 경우 RD파라미터에 IF_NO를 설정한다.
				if (document.form.issue_gubn.value == "S"  || document.form.issue_gubn.value == "SS" ) {
					if (document.form.issue_gubn.value == "S") { //부모창이 0130
						var if_no = document.form.if_no.value;	
					} else { // SS - 부모창이 0135
						var if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");
					}
					rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_ar_if_no["+if_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
				} else {
					rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
				}
			}

		}

//alert(rdParam);

		formObj.com_mrdPath.value = rdFiles ;
		formObj.com_mrdArguments.value = rdParam;

	}			

	ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=I", "pop3", 800, 700);

}



/**
 * RD Preview(FNS_INV_0034_02_prev) 화면 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     btnOldPreview(sheetObj, formObj)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */
function btnOldPreview(sheetObj, formObj) {
	
	var sRow = sheetObj.FindCheckedRow(1);
	if (sRow == "") {
		ComShowCodeMessage("INV00025");
		//return 0;
	}  
 
	var rdFile = "";
	var rdFiles = "";
	var ofc_cd = formObj.iss_ofc_cd.value;
	var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
	var flag = formObj.flag.value;
	
 
	if (ofc_cd == "ANRSO") {
		rdFile = "FNS_INV_0505_IMSI.mrd";
	} 
	
	var arrRow = sRow.split("|");
	var rdParam = "";

	for (var idx = 0; idx < arrRow.length - 1; idx++){

		var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
		var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
		var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
 
		var attach = "N";
		var attach2 = "N";
		var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
		var cmb_flg = sheetObj.CellValue(arrRow[idx], "inv_iss_cmb_flg");
		
		var logo = "ORIGINAL";
		//REISSUE - LEHSC 일 경우--------시작
		if (formObj.iss_lehbb.value == "Y") {
			if(formObj.logo_gb.value == "1"){
				logo = "COPIE2";
			}else if(formObj.logo_gb.value == "2"){
				logo = "COPY";
			}else if(formObj.logo_gb.value == "3"){
				logo = "COPIE2";
			}
		}
		
 
		rdFiles = rdFiles + rdFile +"|";				
		// 부모창이 0130인 경우 RD파라미터에 IF_NO를 설정한다.
		if (document.form.issue_gubn.value == "S"  || document.form.issue_gubn.value == "SS") {

			var if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");

			rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_ar_if_no["+if_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
		} else {
				rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
		}
		if (formObj.iss_lehbb.value == "Y" && formObj.logo_gb.value == "3") {
			logo = "COPY";
			rdFiles = rdFiles + rdFile +"|";
			// 부모창이 0130인 경우 RD파라미터에 IF_NO를 설정한다.
			if (document.form.issue_gubn.value == "S"  || document.form.issue_gubn.value == "SS" ) {
				var if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");
				rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_ar_if_no["+if_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
			} else {
				rdParam = rdParam + "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+formObj.user_nm.value+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num [15] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]" +"|";
			}
		}
 

		formObj.com_mrdPath.value = rdFiles ;
		formObj.com_mrdArguments.value = rdParam;
 
	}			

	ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=I", "pop3", 800, 700);

}


/**
 *  Send 버튼 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     invSend(sheetObj, formObj)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */     
function invSend(sheetObj, formObj) {
	var sRow = sheetObj.FindCheckedRow(1);
	if (sRow == "") {
		ComShowCodeMessage("INV00025");
		return 0;
	}
	
	var arrRow = sRow.split("|");
	var v_copy_cnt = formObj.copy_cnt.value;  
	var issue_type = ""; 
		
	if (formObj.iss_ofc_cd.value == "DXBSC") {
			
		var lpoNullCnt = 0;
		for (var idx = 0; idx < arrRow.length - 1; idx++){
			issue_type = sheetObj.CellValue(arrRow[idx], "inv_no").substr(2,1);
			//alert(issue_type);
			if (issue_type == "F" && sheetObj.CellValue(arrRow[idx], "locl_po_no") == "") {					
				lpoNullCnt++;
			}				
		}
					
		if (lpoNullCnt > 0) {			
			ComShowCodeMessage("INV00129");
			return;
		}
	
	}
	
	// Paper Issue

	if (formObj.send_type[0].checked) {

		formObj.send_flag.value = "P"; 
		doActionIBSheet(sheetObj,formObj,IBSAVE);

		var attachCnt = 0;
		var attachCnt2 = 0;

		if (formObj.state.value == "S") {

			rdObjects[0].SetAppendReport(0);
			for (var idx = 0; idx < arrRow.length - 1; idx++){
				var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
				var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
				var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
				var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
				var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
				var attach_view = sheetObj.CellValue(arrRow[idx], "attach_view");
				var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
				var attach_view2 = sheetObj.CellValue(arrRow[idx], "attach_view2");
				var cmb_flg = sheetObj.CellValue(arrRow[idx], "inv_iss_cmb_flg");
				var ar_if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");
				var logo = "ORIGINAL";
				
				//REISSUE - LEHSC 일 경우--------시작
				if (formObj.iss_lehbb.value == "Y") {
					if(formObj.logo_gb.value == "1"){
						v_copy_cnt = "0";
						logo = "COPIE2";
					}else if(formObj.logo_gb.value == "2"){
						v_copy_cnt = "0";
						logo = "COPY";
					}else if(formObj.logo_gb.value == "3"){
						v_copy_cnt = "1";
						logo = "COPIE2";
					}
				}		
				//REISSUE -  LEHSC 일 경우--------끝

				rdOpen(rdObjects[0], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, logo, vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

				rdObjects[0].SetAppendReport(1);

				for(var j=0; j<v_copy_cnt; j++) {  	
					logo = "COPY";
					if (formObj.iss_lehbb.value == "Y" && formObj.logo_gb.value == "3") {
						logo = "COPY";
					}
					rdOpen(rdObjects[0], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, logo, vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

				}

				rdObjects[0].SetAppendReport(1);

				if (idx < arrRow.length - 2) {

					if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[0], sheetObj.CellValue(arrRow[idx], "cust_cd"));
							attachCnt2 = 0;
						}

					} else {

						if (attach2 == "Y") {
							attachCnt2++
						}
					}

					rdObjects[0].SetAppendReport(1);

					if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
							&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[0], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
							attachCnt = 0;

						}	

					} else {

						if (attach == "Y") {
							attachCnt++
						}

					}

				} else {

					if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
						rdOpenWordingByCust(rdObjects[0], sheetObj.CellValue(arrRow[idx], "cust_cd"));
					}

					rdObjects[0].SetAppendReport(1);

					if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
						rdOpenWordingByVVD(rdObjects[0], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
					}

				}					

			}
			// 프린터 세팅
	    	var print_nm = form.print_nm.value;
	    	if(print_nm != ""){
	    		rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
	    	}

			rdObjects[0].CMPrint(); //인쇄 시작
			rdObjects[0].SetAppendReport(0);
			ComShowCodeMessage("INV00065", formObj.issueCnt.value);
		}

		// E-mail, Fax Issue 

	} else if (formObj.send_type[1].checked || formObj.send_type[2].checked){ 

		if (formObj.send_type[1].checked) {
			formObj.send_flag.value = "E";
			formObj.send_flag2.value = "";
			var invNos = "";
			for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
				if (sheetObj.CellValue(idx, "slt") == "1" && sheetObj.CellValue(idx, "cust_eml") == "") {
					invNos = invNos + sheetObj.CellValue(idx, "inv_no") + (idx == sheetObj.RowCount ? "" : ", ");
					sheetObj.CellValue(idx, "slt") = 0;
				}
				
				if(sheetObj.CellValue(idx, "slt") == "1" && !InvIsEmailAddr(sheetObj.CellValue(idx, "cust_eml"))){
					invNos = invNos + sheetObj.CellValue(idx, "inv_no") + (idx == sheetObj.RowCount ? "" : ", ");
					sheetObj.CellValue(idx, "slt") = 0;
				}
			}
			if (invNos != "") {
				ComShowCodeMessage("INV00099", invNos);
			}				

		} else {
			formObj.send_flag.value = "F";
			formObj.send_flag2.value = "";
			var invNos = "";
			for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
				if (sheetObj.CellValue(idx, "slt") == "1" && sheetObj.CellValue(idx, "cust_fax_no") == "") {
					invNos = invNos + sheetObj.CellValue(idx, "inv_no") + (idx == sheetObj.RowCount ? "" : ", ");
					sheetObj.CellValue(idx, "slt") = 0;
				}
			}
			if (invNos != "") {
				ComShowCodeMessage("INV00110", invNos);
			}	
		}

		var ofc_cd = formObj.iss_ofc_cd.value;
		var rdFile = "";
		var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
		var flag = formObj.flag.value;

		if (ofc_cd == "HAMSC" || ofc_cd == "HAMRU") {
			rdFile = "FNS_INV_0503.mrd";
		} else if (ofc_cd == "GOASC") {
			rdFile = "FNS_INV_0504.mrd";
		} else if (ofc_cd == "ANRSO") {
			rdFile = "FNS_INV_0505.mrd";
		} else if (ofc_cd == "BUDSC") {
			rdFile = "FNS_INV_0506.mrd";
		} else if (ofc_cd == "RTMSC") {
			rdFile = "FNS_INV_0507.mrd";
		} else if (ofc_cd == "GDYSC") {
			rdFile = "FNS_INV_0508.mrd";
		} else if (ofc_cd == "PRGSC") {
			rdFile = "FNS_INV_0509.mrd";
		} else if (ofc_cd == "VLCSC") {
			rdFile = "FNS_INV_0510.mrd";
		} else if (ofc_cd == "SINSC") {
			rdFile = "FNS_INV_0511.mrd";
		} else if (ofc_cd == "PKGSC") {
			rdFile = "FNS_INV_0512.mrd";
		} else if (ofc_cd == "CMBSC") {
			rdFile = "FNS_INV_0513.mrd";
		} else if (ofc_cd == "SYDSC") {
			if(sydbb_exrate_type == "U"){
				rdFile = "FNS_INV_0545.mrd";
			} else {
				rdFile = "FNS_INV_0515.mrd";
			}
		} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
			rdFile = "FNS_INV_0516.mrd";
		} else if (ofc_cd == "HKGSC") {
			rdFile = "FNS_INV_0518.mrd";
		} else if (ofc_cd == "FXTSC" || ofc_cd == "LONBC1") {
			rdFile = "FNS_INV_0521.mrd";
		} else if (ofc_cd == "LEHSC") {
			rdFile = "FNS_INV_0522.mrd";
		} else if (ofc_cd == "SGNSC") {
			rdFile = "FNS_INV_0520.mrd";
		} else if (ofc_cd == "JKTSC") {
			rdFile = "FNS_INV_0527.mrd";
		} else if (ofc_cd == "DXBSC") {
			rdFile = "FNS_INV_0530.mrd";
		} else if (ofc_cd == "BKKSC") {
			rdFile = "FNS_INV_0540.mrd";
		} else if (ofc_cd == "DACSC") {
			rdFile = "FNS_INV_0541.mrd";

		// 중복 체크 OFC  (부모창이 0130일경우)	
		} else if (ofc_cd == "BOMSC") {
			if (document.form.issue_gubn.value == "S" ) {
				rdFile = "FNS_INV_0550.mrd";     //2018.05.16 인도지역 Split Invoice Issue 기능 보완 (0543 -> 0550 으로 변경)
			} else {
				 if (flag == "IF" ){ 
						rdFile = "FNS_INV_0546.mrd";
				 } else {
					 	//2017.07.31 인도 GST 세법 변경 관련 보완
					 	if(document.form.issue_gubn.value == "R" && opener.document.form.ind_type[1].checked) {
					 		rdFile = "FNS_INV_0514.mrd";
					 	} else {
					 		rdFile = "FNS_INV_0548.mrd";
					 	}
				 }
			}
			
		} else if (ofc_cd == "SAOSC") {
			if (document.form.issue_gubn.value == "S" || document.form.issue_gubn.value == "SS" ) {  // S-Split, SS-Split Reissue
				rdFile = "FNS_INV_0544.mrd";
			} else {
				rdFile = "FNS_INV_0542.mrd";
			}
		} else if (ofc_cd == "MNLBA") {
			rdFile = "FNS_INV_0512.mrd";
		}	
			formObj.rd_name.value = rdFile;						
		doActionIBSheet(sheetObj,formObj,IBSAVE);	
		if (formObj.state.value == "S") {
			ComShowCodeMessage("INV00065", formObj.issueCnt.value);
		}

			
		
		// Paper Issue + E-mail Issue

	} else if (formObj.send_type[3].checked){

		var ofc_cd = formObj.iss_ofc_cd.value;
		var rdFile = "";
		var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
		var flag = formObj.flag.value;

		if (ofc_cd == "HAMSC" || ofc_cd == "HAMRU") {
			rdFile = "FNS_INV_0503.mrd";
		} else if (ofc_cd == "GOASC") {
			rdFile = "FNS_INV_0504.mrd";
		} else if (ofc_cd == "ANRSO") {
			rdFile = "FNS_INV_0505.mrd";
		} else if (ofc_cd == "BUDSC") {
			rdFile = "FNS_INV_0506.mrd";
		} else if (ofc_cd == "RTMSC") {
			rdFile = "FNS_INV_0507.mrd";
		} else if (ofc_cd == "GDYSC") {
			rdFile = "FNS_INV_0508.mrd";
		} else if (ofc_cd == "PRGSC") {
			rdFile = "FNS_INV_0509.mrd";
		} else if (ofc_cd == "VLCSC") {
			rdFile = "FNS_INV_0510.mrd";
		} else if (ofc_cd == "SINSC") {
			rdFile = "FNS_INV_0511.mrd";
		} else if (ofc_cd == "PKGSC") {
			rdFile = "FNS_INV_0512.mrd";
		} else if (ofc_cd == "CMBSC") {
			rdFile = "FNS_INV_0513.mrd";
		} else if (ofc_cd == "SYDSC") {
			if(sydbb_exrate_type == "U"){
				rdFile = "FNS_INV_0545.mrd";
			} else {
				rdFile = "FNS_INV_0515.mrd";
			}
		} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
			rdFile = "FNS_INV_0516.mrd";
		} else if (ofc_cd == "HKGSC") {
			rdFile = "FNS_INV_0518.mrd";
		} else if (ofc_cd == "FXTSC" || ofc_cd == "LONBC1") {
			rdFile = "FNS_INV_0521.mrd";
		} else if (ofc_cd == "LEHSC") {
			rdFile = "FNS_INV_0522.mrd";
		} else if (ofc_cd == "SGNSC") {
			rdFile = "FNS_INV_0520.mrd";
		} else if (ofc_cd == "JKTSC") {
			rdFile = "FNS_INV_0527.mrd";
		} else if (ofc_cd == "DXBSC") {
			rdFile = "FNS_INV_0530.mrd";
		} else if (ofc_cd == "BKKSC") {
			rdFile = "FNS_INV_0540.mrd";
		} else if (ofc_cd == "DACSC") {
			rdFile = "FNS_INV_0541.mrd";
		
		// 중복 체크 OFC  (부모창이 0130일경우)	
		} else if (ofc_cd == "BOMSC") {
			if (document.form.issue_gubn.value == "S" ) {
				rdFile = "FNS_INV_0550.mrd";     //2018.05.16 인도지역 Split Invoice Issue 기능 보완 (0543 -> 0550 으로 변경)
			} else {
				 if (flag == "IF" ){ 
						rdFile = "FNS_INV_0546.mrd";
				 } else {
					 	//2017.07.31 인도 GST 세법 변경 관련 보완
					 	if(document.form.issue_gubn.value == "R" && opener.document.form.ind_type[1].checked) {
					 		rdFile = "FNS_INV_0514.mrd";
					 	} else {
					 		rdFile = "FNS_INV_0548.mrd";
					 	}
				 }
			}
		} else if (ofc_cd == "SAOSC") {
			if (document.form.issue_gubn.value == "S" || document.form.issue_gubn.value == "SS" ) {  // S-Split, SS-Split Reissue
				rdFile = "FNS_INV_0544.mrd";
			} else {
				rdFile = "FNS_INV_0542.mrd";
			}
		}

		formObj.rd_name.value = rdFile;		

		formObj.send_flag.value = "E"; 
		formObj.send_flag2.value = "P"; 
		doActionIBSheet(sheetObj,formObj,IBSAVE);

		var attachCnt = 0;
		var attachCnt2 = 0;

		if (formObj.state.value == "S") {
			rdObjects[1].SetAppendReport(0);

			for (var idx = 0; idx < arrRow.length - 1; idx++){

				var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
				var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
				var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
				var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
				var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
				var attach_view = sheetObj.CellValue(arrRow[idx], "attach_view");
				var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
				var attach_view2 = sheetObj.CellValue(arrRow[idx], "attach_view2");
				var cmb_flg = sheetObj.CellValue(arrRow[idx], "inv_iss_cmb_flg");
				var ar_if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");

				if (sheetObj.CellValue(arrRow[idx], "cust_eml") == "") {	

					rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "ORIGINAL", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no); 

					rdObjects[1].SetAppendReport(1);

					for(var j=0; j<v_copy_cnt; j++) {  	

						rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

					}

					rdObjects[1].SetAppendReport(1);

					if (idx < arrRow.length - 2) {							

						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}

						} else {

							if (attach2 == "Y") {
								attachCnt2++
							}
						}

						rdObjects[1].SetAppendReport(1);

						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
							}							

						} else {
							if (attach == "Y") {
								attachCnt++
							}
						}

					} else {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}

						rdObjects[1].SetAppendReport(1);

						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}

					}

				} else {
				   				
					for(var j=0; j<v_copy_cnt; j++) {			

							rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);	

					}		

					rdObjects[1].SetAppendReport(1);

					if (idx < arrRow.length - 2) {

						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}

						} else {

							if (attach2 == "Y") {
								attachCnt2++
							}
						}

						rdObjects[1].SetAppendReport(1);

						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
							}							

						} else {
							if (attach == "Y") {
								attachCnt++
							}
						}

					} else {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}

						rdObjects[1].SetAppendReport(1);

						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}

					}

				}					

			}
			// 프린터 세팅
	    	var print_nm = form.print_nm.value;
	    	if(print_nm != ""){
	    		rdObjects[1].SetPrintInfo (print_nm, 1, 1, 4);
	    	}

			rdObjects[1].CMPrint(); //인쇄 시작
			rdObjects[1].SetAppendReport(0);
			ComShowCodeMessage("INV00065", formObj.issueCnt.value);

		}

		// Paper(Original) Issue + E-mail(Copy) Issue

	} else if (formObj.send_type[4].checked){

		var ofc_cd = formObj.iss_ofc_cd.value;
		var rdFile = "";
		var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
		var flag = formObj.flag.value;

		if (ofc_cd == "HAMSC" || ofc_cd == "HAMRU") {
			rdFile = "FNS_INV_0503.mrd";
		} else if (ofc_cd == "GOASC") {
			rdFile = "FNS_INV_0504.mrd";
		} else if (ofc_cd == "ANRSO") {
			rdFile = "FNS_INV_0505.mrd";
		} else if (ofc_cd == "BUDSC") {
			rdFile = "FNS_INV_0506.mrd";
		} else if (ofc_cd == "RTMSC") {
			rdFile = "FNS_INV_0507.mrd";
		} else if (ofc_cd == "GDYSC") {
			rdFile = "FNS_INV_0508.mrd";
		} else if (ofc_cd == "PRGSC") {
			rdFile = "FNS_INV_0509.mrd";
		} else if (ofc_cd == "VLCSC") {
			rdFile = "FNS_INV_0510.mrd";
		} else if (ofc_cd == "SINSC") {
			rdFile = "FNS_INV_0511.mrd";
		} else if (ofc_cd == "PKGSC") {
			rdFile = "FNS_INV_0512.mrd";
		} else if (ofc_cd == "CMBSC") {
			rdFile = "FNS_INV_0513.mrd";
		} else if (ofc_cd == "SYDSC") {
			if(sydbb_exrate_type == "U"){
				rdFile = "FNS_INV_0545.mrd";
			} else {
				rdFile = "FNS_INV_0515.mrd";
			}
		} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
			rdFile = "FNS_INV_0516.mrd";
		} else if (ofc_cd == "HKGSC") {
			rdFile = "FNS_INV_0518.mrd";
		} else if (ofc_cd == "FXTSC" || ofc_cd == "LONBC1") {
			rdFile = "FNS_INV_0521.mrd";
		} else if (ofc_cd == "LEHSC") {
			rdFile = "FNS_INV_0522.mrd";
		} else if (ofc_cd == "SGNSC") {
			rdFile = "FNS_INV_0520.mrd";
		} else if (ofc_cd == "JKTSC") {
			rdFile = "FNS_INV_0527.mrd";
		} else if (ofc_cd == "DXBSC") {
			rdFile = "FNS_INV_0530.mrd";
		} else if (ofc_cd == "BKKSC") {
			rdFile = "FNS_INV_0540.mrd";
		} else if (ofc_cd == "DACSC") {
			rdFile = "FNS_INV_0541.mrd";
		
		// 중복 체크 OFC  (부모창이 0130일경우)	
		} else if (ofc_cd == "BOMSC") {
			if (document.form.issue_gubn.value == "S" ) {
				rdFile = "FNS_INV_0550.mrd";     //2018.05.16 인도지역 Split Invoice Issue 기능 보완 (0543 -> 0550 으로 변경)
			} else {
				 if (flag == "IF" ){ 
						rdFile = "FNS_INV_0546.mrd";
				 } else {
					 	//2017.07.31 인도 GST 세법 변경 관련 보완
					 	if(document.form.issue_gubn.value == "R" && opener.document.form.ind_type[1].checked) {
					 		rdFile = "FNS_INV_0514.mrd";
					 	} else {
					 		rdFile = "FNS_INV_0548.mrd";
					 	}
				 }
			}
		} else if (ofc_cd == "SAOSC") {
			if (document.form.issue_gubn.value == "S" || document.form.issue_gubn.value == "SS" ) {  // S-Split, SS-Split Reissue
				rdFile = "FNS_INV_0544.mrd";
			} else {
				rdFile = "FNS_INV_0542.mrd";
			}
		}

		formObj.rd_name.value = rdFile;		

		formObj.send_flag.value = "E"; 
		formObj.send_flag2.value = "P"; 
		doActionIBSheet(sheetObj,formObj,IBSAVE);

		var attachCnt = 0;
		var attachCnt2 = 0;

		if (formObj.state.value == "S") {
			rdObjects[1].SetAppendReport(0);

			for (var idx = 0; idx < arrRow.length - 1; idx++){

				var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
				var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
				var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
				var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
				var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
				var attach_view = sheetObj.CellValue(arrRow[idx], "attach_view");
				var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
				var attach_view2 = sheetObj.CellValue(arrRow[idx], "attach_view2");
				var cmb_flg = sheetObj.CellValue(arrRow[idx], "inv_iss_cmb_flg");
				var ar_if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");

				if (sheetObj.CellValue(arrRow[idx], "cust_eml") == "") {	

					rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "ORIGINAL", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no); 

					rdObjects[1].SetAppendReport(1);

					for(var j=0; j<v_copy_cnt; j++) {  	

						rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

					}

					rdObjects[1].SetAppendReport(1);

					if (idx < arrRow.length - 2) {

						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}

						} else {

							if (attach2 == "Y") {
								attachCnt2++
							}
						}

						rdObjects[1].SetAppendReport(1);

						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
							}							

						} else {
							if (attach == "Y") {
								attachCnt++
							}
						}

					} else {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}

						rdObjects[1].SetAppendReport(1);

						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}

					}

				} else {

					rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "ORIGINAL", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

					rdObjects[1].SetAppendReport(1);

					if (idx < arrRow.length - 2) {

						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}

						} else {

							if (attach2 == "Y") {
								attachCnt2++
							}
						}

						rdObjects[1].SetAppendReport(1);

						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
							}							

						} else {
							if (attach == "Y") {
								attachCnt++
							}
						}

					} else {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}

						rdObjects[1].SetAppendReport(1);

						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}

					}

				}					

			}
			// 프린터 세팅
	    	var print_nm = form.print_nm.value;
	    	if(print_nm != ""){
	    		rdObjects[1].SetPrintInfo (print_nm, 1, 1, 4);
	    	}

			rdObjects[1].CMPrint(); //인쇄 시작
			rdObjects[1].SetAppendReport(0);
			ComShowCodeMessage("INV00065", formObj.issueCnt.value);

		}

	}

}



/**
 *  Send 버튼 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     invOldSend(sheetObj, formObj)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */     
function invOldSend(sheetObj, formObj) {
	var sRow = sheetObj.FindCheckedRow(1);
	if (sRow == "") {
		ComShowCodeMessage("INV00025");
		return 0;
	}
	
	var arrRow = sRow.split("|");
	var v_copy_cnt = formObj.copy_cnt.value;  
	var issue_type = ""; 
		

	// Paper Issue

	if (formObj.send_type[0].checked) {

		formObj.send_flag.value = "P"; 
		doActionIBSheet(sheetObj,formObj,IBSAVE);

		var attachCnt = 0;
		var attachCnt2 = 0;

		if (formObj.state.value == "S") {

			rdObjects[0].SetAppendReport(0);

			for (var idx = 0; idx < arrRow.length - 1; idx++){
				var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
				var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
				var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
				var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
				var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
				var attach_view = sheetObj.CellValue(arrRow[idx], "attach_view");
				var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
				var attach_view2 = sheetObj.CellValue(arrRow[idx], "attach_view2");
				var cmb_flg = sheetObj.CellValue(arrRow[idx], "inv_iss_cmb_flg");
				var ar_if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");
				var logo = "ORIGINAL";
				
				//REISSUE - LEHSC 일 경우--------시작
				if (formObj.iss_lehbb.value == "Y") {
					if(formObj.logo_gb.value == "1"){
						v_copy_cnt = "0";
						logo = "COPIE2";
					}else if(formObj.logo_gb.value == "2"){
						v_copy_cnt = "0";
						logo = "COPY";
					}else if(formObj.logo_gb.value == "3"){
						v_copy_cnt = "1";
						logo = "COPIE2";
					}
				}		
				//REISSUE -  LEHSC 일 경우--------끝

				rdOldOpen(rdObjects[0], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, logo, vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

				rdObjects[0].SetAppendReport(1);

				for(var j=0; j<v_copy_cnt; j++) {  	
					logo = "COPY";
					if (formObj.iss_lehbb.value == "Y" && formObj.logo_gb.value == "3") {
						logo = "COPY";
					}
					rdOldOpen(rdObjects[0], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, logo, vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

				}

				rdObjects[0].SetAppendReport(1);

				if (idx < arrRow.length - 2) {

					if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[0], sheetObj.CellValue(arrRow[idx], "cust_cd"));
							attachCnt2 = 0;
						}

					} else {

						if (attach2 == "Y") {
							attachCnt2++
						}
					}

					rdObjects[0].SetAppendReport(1);

					if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
							&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[0], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
							attachCnt = 0;

						}	

					} else {

						if (attach == "Y") {
							attachCnt++
						}

					}

				} else {

					if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
						rdOpenWordingByCust(rdObjects[0], sheetObj.CellValue(arrRow[idx], "cust_cd"));
					}

					rdObjects[0].SetAppendReport(1);

					if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
						rdOpenWordingByVVD(rdObjects[0], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
					}

				}					

			}
			// 프린터 세팅
	    	var print_nm = form.print_nm.value;
	    	if(print_nm != ""){
	    		rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
	    	}

			rdObjects[0].CMPrint(); //인쇄 시작
			rdObjects[0].SetAppendReport(0);
			ComShowCodeMessage("INV00065", formObj.issueCnt.value);
		}

		// E-mail, Fax Issue 

	} else if (formObj.send_type[1].checked || formObj.send_type[2].checked){ 

		if (formObj.send_type[1].checked) {
			formObj.send_flag.value = "E";
			formObj.send_flag2.value = "";
			var invNos = "";
			for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
				if (sheetObj.CellValue(idx, "slt") == "1" && sheetObj.CellValue(idx, "cust_eml") == "") {
					invNos = invNos + sheetObj.CellValue(idx, "inv_no") + (idx == sheetObj.RowCount ? "" : ", ");
					sheetObj.CellValue(idx, "slt") = 0;
				}
				
				if(sheetObj.CellValue(idx, "slt") == "1" && !InvIsEmailAddr(sheetObj.CellValue(idx, "cust_eml"))){
					invNos = invNos + sheetObj.CellValue(idx, "inv_no") + (idx == sheetObj.RowCount ? "" : ", ");
					sheetObj.CellValue(idx, "slt") = 0;
				}
			}
			if (invNos != "") {
				ComShowCodeMessage("INV00099", invNos);
			}				

		} else {
			formObj.send_flag.value = "F";
			formObj.send_flag2.value = "";
			var invNos = "";
			for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){
				if (sheetObj.CellValue(idx, "slt") == "1" && sheetObj.CellValue(idx, "cust_fax_no") == "") {
					invNos = invNos + sheetObj.CellValue(idx, "inv_no") + (idx == sheetObj.RowCount ? "" : ", ");
					sheetObj.CellValue(idx, "slt") = 0;
				}
			}
			if (invNos != "") {
				ComShowCodeMessage("INV00110", invNos);
			}	
		}

		var ofc_cd = formObj.iss_ofc_cd.value;
		var rdFile = "";
		var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
		var flag = formObj.flag.value;

		if (ofc_cd == "ANRSO") {
			rdFile = "FNS_INV_0505_IMSI.mrd";
		}

		formObj.rd_name.value = rdFile;						
		doActionIBSheet(sheetObj,formObj,IBSAVE);	
		if (formObj.state.value == "S") {
			ComShowCodeMessage("INV00065", formObj.issueCnt.value);
		}

		// Paper Issue + E-mail Issue

	} else if (formObj.send_type[3].checked){

		var ofc_cd = formObj.iss_ofc_cd.value;
		var rdFile = "";
		var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
		var flag = formObj.flag.value;
		
		if (ofc_cd == "ANRSO") {
			rdFile = "FNS_INV_0505_IMSI.mrd";
		}

		formObj.rd_name.value = rdFile;		

		formObj.send_flag.value = "E"; 
		formObj.send_flag2.value = "P"; 
		doActionIBSheet(sheetObj,formObj,IBSAVE);

		var attachCnt = 0;
		var attachCnt2 = 0;

		if (formObj.state.value == "S") {
			rdObjects[1].SetAppendReport(0);

			for (var idx = 0; idx < arrRow.length - 1; idx++){

				var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
				var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
				var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
				var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
				var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
				var attach_view = sheetObj.CellValue(arrRow[idx], "attach_view");
				var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
				var attach_view2 = sheetObj.CellValue(arrRow[idx], "attach_view2");
				var cmb_flg = sheetObj.CellValue(arrRow[idx], "inv_iss_cmb_flg");
				var ar_if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");

				if (sheetObj.CellValue(arrRow[idx], "cust_eml") == "") {	

					rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "ORIGINAL", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no); 

					rdObjects[1].SetAppendReport(1);

					for(var j=0; j<v_copy_cnt; j++) {  	

						rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

					}

					rdObjects[1].SetAppendReport(1);

					if (idx < arrRow.length - 2) {							

						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}

						} else {

							if (attach2 == "Y") {
								attachCnt2++
							}
						}

						rdObjects[1].SetAppendReport(1);

						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
							}							

						} else {
							if (attach == "Y") {
								attachCnt++
							}
						}

					} else {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}

						rdObjects[1].SetAppendReport(1);

						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}

					}

				} else {
				   				
					for(var j=0; j<v_copy_cnt; j++) {			

							rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);	

					}		

					rdObjects[1].SetAppendReport(1);

					if (idx < arrRow.length - 2) {

						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}

						} else {

							if (attach2 == "Y") {
								attachCnt2++
							}
						}

						rdObjects[1].SetAppendReport(1);

						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
							}							

						} else {
							if (attach == "Y") {
								attachCnt++
							}
						}

					} else {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}

						rdObjects[1].SetAppendReport(1);

						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}

					}

				}					

			}
			// 프린터 세팅
	    	var print_nm = form.print_nm.value;
	    	if(print_nm != ""){
	    		rdObjects[1].SetPrintInfo (print_nm, 1, 1, 4);
	    	}

			rdObjects[1].CMPrint(); //인쇄 시작
			rdObjects[1].SetAppendReport(0);
			ComShowCodeMessage("INV00065", formObj.issueCnt.value);

		}

		// Paper(Original) Issue + E-mail(Copy) Issue

	} else if (formObj.send_type[4].checked){

		var ofc_cd = formObj.iss_ofc_cd.value;
		var rdFile = "";
		var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
		var flag = formObj.flag.value;

		if (ofc_cd == "ANRSO") {
			rdFile = "FNS_INV_0505_IMSI.mrd";
		}

		formObj.rd_name.value = rdFile;		

		formObj.send_flag.value = "E"; 
		formObj.send_flag2.value = "P"; 
		doActionIBSheet(sheetObj,formObj,IBSAVE);

		var attachCnt = 0;
		var attachCnt2 = 0;

		if (formObj.state.value == "S") {
			rdObjects[1].SetAppendReport(0);

			for (var idx = 0; idx < arrRow.length - 1; idx++){

				var inv_no = sheetObj.CellValue(arrRow[idx], "inv_no");
				var vvd = sheetObj.CellValue(arrRow[idx], "vvd");
				var cust_cd = sheetObj.CellValue(arrRow[idx], "cust_cd");
				var port_cd = sheetObj.CellValue(arrRow[idx], "port_cd");
				var attach = sheetObj.CellValue(arrRow[idx], "attach") == "1" ? "Y" : "N";
				var attach_view = sheetObj.CellValue(arrRow[idx], "attach_view");
				var attach2 = sheetObj.CellValue(arrRow[idx], "attach2") == "1" ? "Y" : "N";
				var attach_view2 = sheetObj.CellValue(arrRow[idx], "attach_view2");
				var cmb_flg = sheetObj.CellValue(arrRow[idx], "inv_iss_cmb_flg");
				var ar_if_no = sheetObj.CellValue(arrRow[idx], "ar_if_no");

				if (sheetObj.CellValue(arrRow[idx], "cust_eml") == "") {	

					rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "ORIGINAL", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no); 

					rdObjects[1].SetAppendReport(1);

					for(var j=0; j<v_copy_cnt; j++) {  	

						rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "COPY", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

					}

					rdObjects[1].SetAppendReport(1);

					if (idx < arrRow.length - 2) {

						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}

						} else {

							if (attach2 == "Y") {
								attachCnt2++
							}
						}

						rdObjects[1].SetAppendReport(1);

						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
							}							

						} else {
							if (attach == "Y") {
								attachCnt++
							}
						}

					} else {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}

						rdObjects[1].SetAppendReport(1);

						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}

					}

				} else {

					rdOpen(rdObjects[1], inv_no, 15, formObj.user_nm.value, formObj.iss_ofc_cd.value, "ORIGINAL", vvd, port_cd, "N", "Y", cmb_flg, ar_if_no);

					rdObjects[1].SetAppendReport(1);

					if (idx < arrRow.length - 2) {

						if (sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {

							if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
								rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
								attachCnt2 = 0;
							}

						} else {

							if (attach2 == "Y") {
								attachCnt2++
							}
						}

						rdObjects[1].SetAppendReport(1);

						if (sheetObj.CellValue(arrRow[idx], "vvd") != sheetObj.CellValue(arrRow[idx+1], "vvd") 
								&& sheetObj.CellValue(arrRow[idx], "cust_cd") != sheetObj.CellValue(arrRow[idx+1], "cust_cd")) {
							if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
								rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
								attachCnt = 0;
							}							

						} else {
							if (attach == "Y") {
								attachCnt++
							}
						}

					} else {

						if ((attach2 == "Y" || attachCnt2 > 0) && attach_view2 == "YES") {
							rdOpenWordingByCust(rdObjects[1], sheetObj.CellValue(arrRow[idx], "cust_cd"));
						}

						rdObjects[1].SetAppendReport(1);

						if ((attach == "Y" || attachCnt > 0) && attach_view == "YES") {
							rdOpenWordingByVVD(rdObjects[1], sheetObj.CellValue(arrRow[idx], "vvd"), sheetObj.CellValue(arrRow[idx], "port_cd"));
						}

					}

				}					

			}
			// 프린터 세팅
	    	var print_nm = form.print_nm.value;
	    	if(print_nm != ""){
	    		rdObjects[1].SetPrintInfo (print_nm, 1, 1, 4);
	    	}

			rdObjects[1].CMPrint(); //인쇄 시작
			rdObjects[1].SetAppendReport(0);
			ComShowCodeMessage("INV00065", formObj.issueCnt.value);

		}

	}

}

/**
 *  RD외 첨부파일 업로드 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     fileUpload(formObj, file_path)
 * </pre>
 * @param {form} formObj 필수 html form object
 * @param {String} file_path 업로드할 파일명
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */     
function fileUpload(formObj, file_path) {

	formObj.f_cmd.value = SEARCH02;

	var sFile = file_path;
	var upObj = uploadObjects[0];

	upObj.Files = "";

	// IBUpload에 파일 추가하기
	upObj.AddFile(sFile);

	if(upObj.LocalFiles == "") {
		return;
	}

	upObj.ExtendParam = FormQueryString(formObj);
	upObj.ParamDecoding = true;
	var sXml = upObj.DoUpload(true);
	var fileKey = ComGetEtcData(sXml, "fileKey");
	//formObj.fileKey.value = fileKey;	
	return fileKey;	 		

}

/**
 * RD Object 초기화 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initRdConfig(rdObject)
 * </pre>
 * @param {rdviewer} rdObject Rdviewer Object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */ 
function initRdConfig(rdObject){

	var Rdviewer = rdObject;
	Rdviewer.style.height = 0;
	Rdviewer.style.width = 0;
	//Rdviewer.DisableToolbar(1)

	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);

	Rdviewer.setbackgroundcolor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);

}

/**
 * RD File 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     rdOpen(Rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn, cmbFlg, ar_if_no)
 * </pre>
 * @param {rdviewer} rdObject Rdviewer Object
 * @param {String} inv_no Invoice number
 * @param {String} line_num Description lile 수 
 * @param {String} user_nm 사용자명
 * @param {String} ofc_cd office code
 * @param {String} logo logo 명
 * @param {String} vvd vvd
 * @param {String} port_cd port code
 * @param {String} attach letter wording 첨부 flag
 * @param {String} paperYn print, email 구분
 * @param {String} cmbFlg CMBSC Flag
 * @param {String} ar_if_no AR Interface No
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */ 
function rdOpen(rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn, cmbFlg, ar_if_no){  		

	var rdFile = "";	
	var formObj = document.form;
	var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
	var flag = formObj.flag.value;
	if(sydbb_exrate_type == ""){
		sydbb_exrate_type = "A";
	}

	if (ofc_cd == "HAMSC" || ofc_cd == "HAMRU") {
		rdFile = "FNS_INV_0503.mrd";
	} else if (ofc_cd == "GOASC") {
		rdFile = "FNS_INV_0504.mrd";
	} else if (ofc_cd == "ANRSO") {
		rdFile = "FNS_INV_0505.mrd";
	} else if (ofc_cd == "BUDSC") {
		rdFile = "FNS_INV_0506.mrd";
	} else if (ofc_cd == "RTMSC") {
		rdFile = "FNS_INV_0507.mrd";
	} else if (ofc_cd == "GDYSC") {
		rdFile = "FNS_INV_0508.mrd";
	} else if (ofc_cd == "PRGSC") {
		rdFile = "FNS_INV_0509.mrd";
	} else if (ofc_cd == "VLCSC") {
		rdFile = "FNS_INV_0510.mrd";
	} else if (ofc_cd == "SINSC") {
		rdFile = "FNS_INV_0511.mrd";
	} else if (ofc_cd == "PKGSC") {
		rdFile = "FNS_INV_0512.mrd";
	} else if (ofc_cd == "CMBSC") {
		rdFile = "FNS_INV_0513.mrd";
	} else if (ofc_cd == "SYDSC") {
		if(sydbb_exrate_type == "U"){
			rdFile = "FNS_INV_0545.mrd";
		} else {
			rdFile = "FNS_INV_0515.mrd";
		}
	} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
		rdFile = "FNS_INV_0516.mrd";
	} else if (ofc_cd == "HKGSC") {
		rdFile = "FNS_INV_0518.mrd";
	} else if (ofc_cd == "FXTSC" || ofc_cd == "LONBC1") {
		rdFile = "FNS_INV_0521.mrd";
	} else if (ofc_cd == "LEHSC") {
		rdFile = "FNS_INV_0522.mrd";
	} else if (ofc_cd == "SGNSC") {
		if (cmbFlg == "Y") {
			rdFile = "FNS_INV_0520_MULTI.mrd";
		} else {
			rdFile = "FNS_INV_0520_SINGLE.mrd";
		}
	} else if (ofc_cd == "JKTSC") {
		rdFile = "FNS_INV_0527.mrd";
	} else if (ofc_cd == "DXBSC") {
		rdFile = "FNS_INV_0530.mrd";
	} else if (ofc_cd == "BKKSC") {
		rdFile = "FNS_INV_0540.mrd";
	} else if (ofc_cd == "DACSC") {
		rdFile = "FNS_INV_0541.mrd";

	// 중복 체크 OFC  (부모창이 0130일경우)	
	} else if (ofc_cd == "BOMSC") {
		if (document.form.issue_gubn.value == "S" ) {
			rdFile = "FNS_INV_0550.mrd";     //2018.05.16 인도지역 Split Invoice Issue 기능 보완 (0543 -> 0550 으로 변경)
		} else {
			 if (flag == "IF" ){ 
					rdFile = "FNS_INV_0546.mrd";
			 } else {
				 	//2017.07.31 인도 GST 세법 변경 관련 보완
				 	if(document.form.issue_gubn.value == "R" && opener.document.form.ind_type[1].checked) {
				 		rdFile = "FNS_INV_0514.mrd";
				 	} else {
				 		rdFile = "FNS_INV_0548.mrd";
				 	}
			 }
		}
	} else if (ofc_cd == "SAOSC") {
		if (document.form.issue_gubn.value == "S" || document.form.issue_gubn.value == "SS" ) {  // S-Split, SS-Split Reissue
			rdFile = "FNS_INV_0544.mrd";
		} else {
			rdFile = "FNS_INV_0542.mrd";
		}
	}	
		

	var ar_ofc_cd = ofc_cd;
	if (ofc_cd == "BOMSC" || ofc_cd == "SYDSC" || ofc_cd == "FXTSC" || ofc_cd == "LEHSC") {
		ofc_cd = document.form.login_ofc_cd.value;
	}

	if (ofc_cd == "SGNSC") {
		rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_inv_gb ["+inv_no.substr(0,1)+"] frm1_ar_ofc_cd["+ar_ofc_cd+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
	} else {
		// 부모창이 0130일 경우 RD 파라미터에 IF_NO를 설정한다.
		if (document.form.issue_gubn.value == "S" || document.form.issue_gubn.value == "SS" ) {  // S-Split, SS-Split Reissue
			if (document.form.issue_gubn.value == "S") {
					var if_no = document.form.if_no.value; 
			} else if (document.form.issue_gubn.value == "SS") {
				    var if_no = ar_if_no; 
			}
			rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_ar_if_no["+if_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
		} else {

			if (ofc_cd == "BOMSC" && flag == "IF") {
				var if_no = ar_if_no; 
				rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_ar_if_no["+if_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
			} else {
				rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
			}	
		}
	}

	//alert(rdParam); 

	var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	

	// 열고자 하는 RD 파일을 지정한다.		
	rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	//rdviewer.FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");

}



/**
 * RD File 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     rdOpen(Rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn, cmbFlg, ar_if_no)
 * </pre>
 * @param {rdviewer} rdObject Rdviewer Object
 * @param {String} inv_no Invoice number
 * @param {String} line_num Description lile 수 
 * @param {String} user_nm 사용자명
 * @param {String} ofc_cd office code
 * @param {String} logo logo 명
 * @param {String} vvd vvd
 * @param {String} port_cd port code
 * @param {String} attach letter wording 첨부 flag
 * @param {String} paperYn print, email 구분
 * @param {String} cmbFlg CMBSC Flag
 * @param {String} ar_if_no AR Interface No
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */ 
function rdOldOpen(rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn, cmbFlg, ar_if_no){  		

	var rdFile = "";	
	var formObj = document.form;
	var sydbb_exrate_type = formObj.sydbb_exrate_type.value;
	var flag = formObj.flag.value;
	if(sydbb_exrate_type == ""){
		sydbb_exrate_type = "A";
	}

	if(ofc_cd == "ANRSO") {
		rdFile = "FNS_INV_0505_IMSI.mrd";
	} 
		
		rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type["+inv_no.substr(2,1)+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";


	//alert(rdParam); 

	var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	

	// 열고자 하는 RD 파일을 지정한다.		
	rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	//rdviewer.FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");

}




/**
 * RD File 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     rdOpenWordingByVVD(rdviewer, vvd, port_cd)
 * </pre>
 * @param {rdviewer} rdObject Rdviewer Object
 * @param {String} vvd vvd
 * @param {String} port_cd port code
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */ 
function rdOpenWordingByVVD(rdviewer, vvd, port_cd){   		 

	var rdFile = "FNS_INV_0524_vvd.mrd";
	var formObj = document.form;
	var ofc_cd = formObj.iss_ofc_cd.value;

	var	rdParam = "/rv frm1_ar_ofc_cd["+ofc_cd+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"]";

	var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	

	// 열고자 하는 RD 파일을 지정한다.		
	rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");

}      

/**
 * RD File 오픈 <br>
 * <br><b>Example :</b>
 * <pre>
 *     rdOpenWordingByCust(rdviewer, cust_cd)
 * </pre>
 * @param {rdviewer} rdObject Rdviewer Object
 * @param {String} cust_cd Customer Code
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */ 
function rdOpenWordingByCust(rdviewer, cust_cd){   		 

	var rdFile = "FNS_INV_0524_cust.mrd";
	var formObj = document.form;
	var ofc_cd = formObj.iss_ofc_cd.value;

	var	rdParam = "/rv frm1_ar_ofc_cd["+ofc_cd+"] frm1_cust_cnt_cd["+cust_cd.substr(0,2)+"] frm1_cust_seq["+Number(cust_cd.substr(2,6))+"]";

	var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	

	// 열고자 하는 RD 파일을 지정한다.		
	rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");

}         

/**
 * 첨부파일 Add, Delete 버튼 클릭 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     sheet1_OnClick(sheetObj, row, col, value)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row ibsheet 해당 row
 * @param {int} Col ibsheet 해당 col
 * @param {String} value ibsheet 해당 row, col의 값
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */  
function sheet1_OnClick(sheetObj, row, col, value) {

	var formObj = document.form;

	if (sheetObj.ColSaveName(col) == "f_add") {
		if (sheetObj.CellValue(row, "f_key") == "") {

			var file = sheetObj.OpenFileDialog("", "", "C:\\","All Files(*.*)|*.*" );
			var fileKey = fileUpload(formObj, file);
			if (fileKey != "" && fileKey != undefined) {
				sheetObj.CellValue(row, "f_name") = file;
				sheetObj.CellValue(row, "f_key") = fileKey;    
			} else {
				sheetObj.CellValue(row, "f_name") = "";
				sheetObj.CellValue(row, "f_key") = "";    
			}       		    		

		} else {

			if(ComShowCodeConfirm("INV00124")) {
				var file = sheetObj.OpenFileDialog("", "", "C:\\","All Files(*.*)|*.*" );
				var fileKey = fileUpload(formObj, file);            		
				if (fileKey != "" && fileKey != undefined) {
					sheetObj.CellValue(row, "f_name") = file;
					sheetObj.CellValue(row, "f_key") = fileKey;    
				} else {
					sheetObj.CellValue(row, "f_name") = "";
					sheetObj.CellValue(row, "f_key") = "";    
				}

			} else {
				return;
			} 			

		}

	}

	if (sheetObj.ColSaveName(col) == "f_del") {

		sheetObj.CellValue(row, "f_name") = "";
		sheetObj.CellValue(row, "f_key") = "";

	}	

//		if (sheetObj.ColSaveName(col) == "f_name") {	    	
//	
//			if (value != "") {
//				document.getElementById("key").value = sheetObj.CellValue(row, "f_key");
//				sheetObj.HtmlControlEnterKey("downbtn","sheet1");
//				sheetObj.HtmlControlEnterKey("downbtn","sheet1");
//			}
//	
//		}

	if (sheetObj.ColSaveName(col) == "f_copy") {


		if (sheetObj.CellValue(row, "f_key") != "") {
			for (var idx = 1; idx < sheetObj.RowCount + 1; idx++){

				if (sheetObj.CellValue(row, "vvd") == sheetObj.CellValue(idx, "vvd")) {

					sheetObj.CellValue2(idx, "f_name") = sheetObj.CellValue(row, "f_name");
					sheetObj.CellValue2(idx, "f_key") = sheetObj.CellValue(row, "f_key");

				}

			}

		}

	}

}
 
/**
 * 첨부파일 보기 <br>
 * <br><b>Example :</b>
 * <pre>
 *     sheet1_OnDblClick(sheetObj, row, col, value)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row ibsheet 해당 row
 * @param {int} Col ibsheet 해당 col
 * @param {String} value ibsheet 해당 row, col의 값
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */  
function sheet1_OnDblClick(sheetObj, row, col) {

	var formObj = document.form;
    var value = sheetObj.CellValue(row, col);
	if (sheetObj.ColSaveName(col) == "f_name") {	    	
		if (value != "") {
			document.getElementById("key").value = sheetObj.CellValue(row, "f_key");
			sheetObj.HtmlControlEnterKey("downbtn","sheet1");
			sheetObj.HtmlControlEnterKey("downbtn","sheet1");
		}

	}
	
}	

/**
 * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     setUploadObject(uploadObj)
 * </pre>
 * @param {ibupload} uploadObj IBUpload Object
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */  
function setUploadObject(uploadObj) {
	uploadObjects[uploadCnt++] = uploadObj;
}   

/**
 * Help tooltip 을 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     showHelp()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */      
function showHelp() {
	if(document.getElementById) { 
		var msg = "* Where e-mail address or fax no is brought from\n"
			+ "  - O/B : BKG Contact in BKG/DOC > S/I Contact in BKG/DOC > O/B contact in MDM\n"
			+ "  - I/B : I/B contact in MDM\n"
			+ "  - If nothing in above, e-mail or fax lastly sent is displayed in case of re-issue.\n";
		var elm = document.getElementById("help_layer")      
		elm.innerText = msg;
		elm.style.width = 500;
		//elm.style.height=obj.style.height
		elm.style.top = document.body.scrollTop+event.clientY - 50
		elm.style.left= document.body.scrollLeft+event.clientX - 500
		elm.style.visibility = "visible"
	}
}

/**
 * Help tooltip 을 닫는다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     showHelp()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */ 
function hideHelp(){

	if(document.getElementById) { 
		var elm=document.getElementById("help_layer")     
		elm.style.visibility="hidden"
	}

}

/**
 * E-mail 형식을 check한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     showHelp()
 * </pre>
 * @param obj
 * @return 없음
 * @author 정휘택
 * @version 2009.10.20
 */ 
function InvIsEmailAddr(obj) {

	try {
          //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
			var retArr = obj.split(";");

			for ( var i = 0; i < retArr.length; i++) {
				if(retArr[i].trim() != ""){ 
					var sVal = getArgValue(retArr[i]);
					var format =  /^\s*[\w\~\-\.]+\@[\w\~\-]+(\.[\w\~\-]+)+\s*$/g;
					if(sVal.search(format) == -1&& sVal != ""){
						break;
					}
				}else{ 
					if(sVal == "" || sVal == null||sVal == undefined){
						return;
					}
					break;
				}
			}
			return (sVal.search(format) != -1);
	} catch(err) { ComFuncErrMsg(err.message); }
	
}

/* 개발자 작업  끝 */