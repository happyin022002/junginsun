/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0345.js
 *@FileTitle : Warehouse by Country Inquiry
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
function esm_bkg_0345()
{
	this.processButtonClick			= processButtonClick;
	this.setSheetObject				= setSheetObject;
	this.loadPage					= loadPage;
	this.sheet1_OnLoadFinish		= sheet1_OnLoadFinish;
	this.initSheet					= initSheet;
	this.doActionIBSheet			= doActionIBSheet;
	this.setTabObject				= setTabObject;
	this.validateForm				= validateForm;
	this.select						= select;
	this.sheet1_OnDblClick			= sheet1_OnDblClick;
	this.sheet1_OnClick				= sheet1_OnClick;
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
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;

		case "btn_Select":
			doActionIBSheet(sheetObjects[0],formObject,SEARCH11);
			break;
			
		case "btn_downexcel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
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

}

/**
 * Sheet1 로드 완료 후 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	var form = document.form;
	
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	//doActionIBSheet(sheetObjects[0], form, IBSEARCH);
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
			style.height = 322;
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

			var HeadTitle1 = "Sel.|Seq.|Abbr. Code|Customs Code|Warehouse Name|Location|Phone|PIC|Fax";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,		false,		"Sel");
			InitDataProperty(0, cnt++ , dtSeq,	        40,	    daCenter,	    true,	  	"Seq",	        false,	        "",	     dfNone,    0,	    false,       false);
			InitDataProperty(0, cnt++ , dtData,			110,	daCenter,		true,		"wh_cd",		false,			"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			150,	daCenter,		true,		"cstms_cd",		false,			"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			200,	daCenter,		true,		"wh_nm",		false,			"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		"loc_cd",		false,			"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		"phn_no",		false,			"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		"pson_nm",		false,			"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		"fax_no",		false,			"",      dfNone,	0,		false,		false);


			CountPosition = 2;
		}
		break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0345GS.do", FormQueryString(formObj));
			sheetObjects[0].Redraw = false; 
  			sheetObjects[0].LoadSearchXml(sXml);
  			sheetObjects[0].Redraw = true;
  			ComOpenWait(false);
		}
		break;

	case SEARCH11:        //SELECT
		select(sheetObj, sheetObj.selectRow, '');
		break;
		
	case IBDOWNEXCEL: // 엑셀
	     if(!validateForm(sheetObj,formObj,sAction)) return false;

           var columnSkipList = "";
  
	        columnSkipList = "ibflag|Sel";
  
            sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, columnSkipList, "");
			
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
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.cnt_cd.value.length < 2) {
			ComShowCodeMessage('BKG00186');
			formObj.cnt_cd.focus();
			return false;
		}
	}

	return true;
}

 /**
 * select 버튼 클릭시
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function select(sheetObj,Row,Col) {
	
    if (sheetObj.CellValue(sheetObj.selectRow, 'cstms_cd').length < 1) {
 	   // 조회선택된것이 없는 경우 패스
    }else {
	       try{    	
				var obj = new Object(); 
				obj.cd 		= sheetObj.CellValue(Row, "cstms_cd");
				obj.wh_nm      = sheetObj.CellValue(Row, "wh_nm");
				obj.loc_cd  = sheetObj.CellValue(Row, "loc_cd");
				window.returnValue = obj;
				self.close();
	      }catch(e){}
    }
} 
 
/**
 * 더블클릭 처리 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	select(sheetObj, Row, Col);
}

/**
* 클릭이벤트 처리 (1개만 선택되도록 처리)
* @param SheetObj
* @param formObj
* @param sAction
* @return
*/
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	// 전체 선택 해제 처리
	for(var i=1; i <= sheetObj.RowCount; i++) {
		if (i != Row) {
			sheetObj.CellValue(i, "Sel") = 0;
		} else {
			sheetObj.CellValue(i, "Sel") = 1;
		}
	}
}
