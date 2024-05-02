/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_1214.js   --ESM_BKG_1154.js
*@FileTitle : Multi POL/POD Input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*===============================================================================
 History
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
     * @class ESM_BKG_1214 : esm_bkg_1214 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1214() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var opener = window.dialogArguments;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_add":
				sheetObject.DataInsert(-1);
				break;
				
			case "btn_delete":
				for( var idx = sheetObject.LastRow; idx >= 0 + parseInt(sheetObject.HeaderRows); idx-- ){
					if( sheetObject.CellValue(idx,"chk") == "1" ){
						sheetObject.RowDelete(idx, false);
					}
				}
				break;

			case "btn_apply":
				var locMultiStr = "";
				for( var idx = 0 + parseInt(sheetObject.HeaderRows); idx <= sheetObject.LastRow; idx++ ){
					if( sheetObject.CellValue(idx,"loc_cd") != "" ){
						for( var jdx = sheetObject.LastRow; jdx > idx; jdx-- ){
							if( sheetObject.CellValue(idx,"loc_cd") == sheetObject.CellValue(jdx,"loc_cd") ){
								sheetObject.RowDelete(jdx, false);
							}
						}
						locMultiStr = locMultiStr + sheetObject.CellValue(idx,"loc_cd") + ",";
					}
				}
				locMultiStr = locMultiStr.substr(0,locMultiStr.length-1);
				
				//Apply 대상이 0건인지 여부 판단
				if( formObject.org_sheet.value == "0" ){
					var org_sheet = opener.sheetObjects[0];
				} 
				
				var org_row = formObject.org_row.value;
				/*if( locMultiStr.length == 0 ){
					org_sheet.CellValue2(org_row,"trunk_pol_cd") = locMultiStr;
				} else{
					org_sheet.CellValue2(org_row,"trunk_pol_cd") = locMultiStr;
				}*/
				
				if (formObject.loc_cd_tp.value == "TPOL") {
					org_sheet.CellValue2(org_row,"trunk_pol_cd") = locMultiStr;
				}
				else if (formObject.loc_cd_tp.value == "TPOD") {
					org_sheet.CellValue2(org_row,"trunk_pod_cd") = locMultiStr;
				}
				else if (formObject.loc_cd_tp.value == "SPOL") {
					org_sheet.CellValue2(org_row,"n1st_ts_pol_cd") = locMultiStr;
				}
				else if (formObject.loc_cd_tp.value == "SPOD") {
					org_sheet.CellValue2(org_row,"n1st_ts_pod_cd") = locMultiStr;
				}
				
				if( formObject.org_ui_id.value == "ESM_BKG_1215" ){
					// 데이타 수정 여부 기록 
					opener.form.dirty_flag.value = 'Y'
				}
				
				window.close();
				break;
				
			case "btn_close":
				window.close();
				break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
function loadPage(){
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	initSet();
}


/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 */
function initControl() {
//    axon_event.addListener('click', 'obj_click', 'manual');    		//Click
//    axon_event.addListener('keyup', 'obj_keyup', 'boo_bkg_no'); 		//Key Up
//    axon_event.addListenerFormat('blur',    'obj_blur',     form);	//Blur
//    axon_event.addListenerFormat('focus',   'obj_focus',    form);	//Focus
    axon_event.addListenerFormat('keypress','form1_keypress', form);	//Key Press 
}


/**
 * HTML Control의 objClick이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_click() {
}


/**
 * HTML Control의 objKeyup이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keyup() {
}


/**
 * HTML Control의 onBlur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur(){
}

/**
 * HTML Control의 onFocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}


/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function form1_keypress(){
	switch(event.srcElement.dataformat){
		case "engupnum":
			ComKeyOnlyAlphabet("uppernum");
		break;
	}
}
//Axon 이벤트 처리2. 이벤트처리함수 --- end

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(10);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 23);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, false, false) ;

				var HeadTitle1 =  "|No.|Location Code";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtCheckBox,   	    30,	daCenter, 	true,    	"chk",				false, 		"", 		dfNone, 		0, 			true, 		true, 			 10, 	false,	 	false, 		"", 		true);
				InitDataProperty(0, cnt++, 	dtSeq,   		    70,	daCenter, 	true,    	"seq",				false, 		"", 		dfNone, 		0, 			false, 		false, 			 10, 	false,	 	false, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   	       100,	daCenter, 	true,    	"loc_cd",      		false, 		"", 		dfNone, 		0, 			true, 		true, 			  5, 	false,	 	false, 		"", 		false);
				
			}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
	sheetObj.ShowDebugMsg = false;
	var col_save_name = sheetObj.ColSaveName(Col);
	switch(sAction) {
	
		case SEARCH02:		//Validation Check
			sParam = "f_cmd=102&" + "&val_type="+"Location"+"&val_value="+sheetObj.CellValue(Row,col_save_name);
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1215GS.do", sParam);    	
	    	var val_cnt  = ComGetEtcData(sXml, "val_cnt");

			if(val_cnt < 1 && val_cnt != ""){
				ComShowCodeMessage('BKG00993',"Location" + " : " + sheetObj.CellValue(Row,col_save_name));
				sheetObj.CellValue2(Row,col_save_name) = "";
    			sheetObj.SelectCell(Row, Col);
				return false;
			}

	   		break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
//	switch(sAction){
//		case MULTI:
//			//그리드 데이터 없을 경우
//			if( sheetObj.RowCount <= 0 ){
//				return false;
//			}
//			break;
//	}
	
	return true;
}

function initSet(){
	var locArr = document.form.loc_multi_cd.value.split(",");
	for( var idx = 0; idx < locArr.length; idx++ ){
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].CellValue2(idx+1,"loc_cd") = locArr[idx];
	}
	
	if (document.form.loc_cd_tp.value.substring(0,1) == "T") {
		aloc_type_lane.innerHTML="Trunk Lane";
		aloc_type_bd.innerHTML="Trunk BD";
	} else {
		aloc_type_lane.innerHTML="T/S Lane";
		aloc_type_bd.innerHTML="T/S BD";
	}
	

}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
}
 
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObject = document.form;
    var colName = sheetObj.ColSaveName(Col);
    
    var data_type = sheetObj.ReadDataProperty(Row, Col, 0);
	if(data_type == dtData) {
		sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();
	}
    
    switch(colName) {
    	case "loc_cd" :
    		doActionIBSheet(sheetObj, formObject, SEARCH02, Row, Col);
    		break;
    }
}


