/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0575.js
*@FileTitle : PSA Vessel Registeration
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
function esm_bkg_0575()
{
	this.processButtonClick			= processButtonClick;
	this.setSheetObject				= setSheetObject;
	this.loadPage					= loadPage;
	this.obj_KeyUp					= obj_KeyUp;
	this.initSheet					= initSheet;
	this.sheet1_OnChange			= sheet1_OnChange;
	this.doActionIBSheet			= doActionIBSheet;
	this.validateForm				= validateForm;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

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

		case "btn_SelectAll":
			sheetObject1.CheckAll(2) = 2;
			if (sheetObject1.CheckedRows(2) < 1) {
				document.getElementById("btn_SelectAll").innerHTML  = "Select All";
			}else {
				document.getElementById("btn_SelectAll").innerHTML  = "Deselect All";
			}
			break;

		case "btn_RowAdd":
			sheetObject1.DataInsert(-1);
			break;

		case "btn_Delete":
			if(ComShowCodeConfirm('BKG95003', 'delete')){ 
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
			}
			break;

		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_Save":
			
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;

		case "btn_ImportSchedule":
			var params = "pgmNo=ESM_BKG_1013";
			ComOpenPopup("/hanjin/ESM_BKG_1013.do?"+params, 540, 400, "0002", "1,0", false);
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

	for(i=0;i<sheetObjects.length;i++){

		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);

		ComEndConfigSheet(sheetObjects[i]);

	}

	// Key 입력 처리
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListenerFormat("KeyUp", "obj_KeyUp",  document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

}

/**
 * VVD 탭키 없이 이동 처리
 * @return
 */
function obj_KeyUp()
{
	var formObj = document.form;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    var srcName = event.srcElement.getAttribute("name");
    var srcValue = event.srcElement.getAttribute("value");
    
    if (keyValue <=16 || keyValue==46 || ( keyValue >= 35 && keyValue <=40) ) return;
    
    switch(srcName) {
    case "vsl_cd":
    	if (formObj.vsl_cd.value.length > 3) formObj.skd_voy_no.focus();
    	break;
    case "skd_voy_no":
    	if (formObj.skd_voy_no.value.length > 3) formObj.skd_dir_cd.focus();
    	break;
    }
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

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 402;
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

			var HeadTitle1 = "|Seq.|Sel.|ALPS VVD|ALPS VVD|ALPS VVD|PSA Vessel Name|Voyage/Direction";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW,   COL,    DATATYPE,           WIDTH,  DATAALIGN,      COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,		"ibflag");
			InitDataProperty(0,		cnt++ , dtDataSeq,			50,		daCenter,		true,		"Seq",					false,     "",		dfNone,			0,		false, false, 0, 		false, false);
			InitDataProperty(0,		cnt++ , dtCheckBox,			50,		daCenter,		true,		"Sel",					false,		"",		dfNone,			0,		true,	true);
			InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"vsl_cd",				true,		"",		dfEngUpKey,		0,		true,	true,	4,		true);
			InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"skd_voy_no",			true,		"",		dfEngUpKey,		0,		true,	true,	4,		true);
			InitDataProperty(0,		cnt++ , dtData,				30,		daCenter,		true,		"skd_dir_cd",			true,		"",		dfEngUpKey,		0,		true,	true,	1,		true);
			InitDataProperty(0,		cnt++ , dtData,				400,	daLeft,			true,		"psa_vsl_nm",			true,		"",		dfEngUpKey,		0,		true,	true,	100);
			InitDataProperty(0,		cnt++ , dtData,				120,	daLeft,			true,		"psa_voy_dir_cd",		true,		"",		dfEngUpKey,		0,		true,	true,	6);

			CountPosition = 0;

		}
		break;
	}
}

/**
 * Sheet1 변경 처리 ( VSL_CD 입력시 VSL_NM 자동 조회 )
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col) {
	// VSL CD 입력시 VSL NM 조회
	 if (Col==3) {
		  var formObj = document.form;
		  if (Col==3) {
			  // 데이터 조회
			  formObj.f_cmd.value = COMMAND01;
			  var sXml = sheetObj.GetSearchXml("ESM_BKG_0575GS.do?vsl_cd="+sheetObj.CellValue(Row,Col)+"&f_cmd="+formObj.f_cmd.value);
			  if (ComGetEtcData(sXml, "psa_vsl_nm")!=null && ComGetEtcData(sXml, "psa_vsl_nm").length > 1) {
				  sheetObj.CellValue(Row, "psa_vsl_nm") = ComGetEtcData(sXml, "psa_vsl_nm");
			  }else {
				  sheetObj.CellValue(Row, "psa_vsl_nm") = "";
			  }
		  }
	  }
}
 
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회		
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0575GS.do",  FormQueryString(formObj));
			ComOpenWait(false);
		}
	break;
	
	case IBSAVE:        //저장
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSave("ESM_BKG_0575GS.do",  FormQueryString(formObj), -1, false);
			ComOpenWait(false);
			
		}
		break;

	case IBDELETE:      // 삭제
		ComRowHideDelete(sheetObj,"Sel");
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){

		switch(sAction) {
		case IBSEARCH:
			if (formObj.vsl_cd.value.length < 4) {
				ComShowCodeMessage("BKG00115");
				formObj.vsl_cd.focus();
				return false;
			}
			break;
		}
	}

	return true;
}
