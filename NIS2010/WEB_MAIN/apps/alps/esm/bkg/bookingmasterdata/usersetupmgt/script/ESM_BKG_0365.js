/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0365.js
*@FileTitle : Mark & Description Template
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.27 김영출
* 1.0 Creation
* 2011.09.02 변종건 [CHM-201111165-01] [BKG] BL Data Input Cross-check 기능 추가 보완-Sailing Date 및  Multi-VVD Base 검색 조건 추가
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
     * @class ui_bkg_0365 : ui_bkg_0365 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ui_bkg_0365() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var cur_usr_id = '';
	var cur_ofc_cd = '';
	var returnObject = '';
	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject1 = sheetObjects[0];
     //var sheetObject2 = sheetObjects[1];

     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = event.srcElement.getAttribute("name");

        switch(srcName) {

				case "marks_type":
					var mk_type = event.srcElement.value;
					if( mk_type == 'V'){
						vvd_note.innerHTML = 'Note : When VVDs are entered, use "",(comma)"" in between VVDs as a delimiter';
					}else{
						vvd_note.innerHTML = '';
					}
					//alert("mk_type -> " + mk_type);
					filteredData(sheetObject1, mk_type);
                break;

				case "btn_office":
					var ofc_cd = sheetObject1.EtcData("ofc_cd");
					var url = "ESM_BKG_0922.do?func=callbackOffice&ofc_cd="+cur_ofc_cd;
					if (!ComIsEmpty(ofc_cd)) {
						url = "ESM_BKG_0922.do?func=callbackOffice&ofc_cd="+ofc_cd;
					}
					ComOpenWindow(url, "ESM_BKG_0922", "dialogWidth:500px;dialogHeight:290px;", true);
                break;
				
				case "btn_rowAdd":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
                break;

				case "btn_delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
                break;

				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;

				case "btn_select":
					doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
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
	if (!opener) opener = window.dialogArguments;
    for(i=0;i<sheetObjects.length;i++){

    	//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
    	//khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);

    }

	// set init-data for sheets
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	//add listener
	axon_event.addListenerForm('blur', 'form1_blur', document.form);
	axon_event.addListenerForm('change', 'form1_change', document.form);

}


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

                // 높이 설정
                style.height = 220;
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

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(6, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle1 = "|Sel|Template Seq.|Template Type|Template Name|Contents";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,      WIDTH,   DATAALIGN,  COLMERGE,    SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(0, cnt++ , dtCheckBox,	45,		daCenter,	false,       "Check",        false,		"",        dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtHiddenStatus,  30,     daCenter,   false,      "ibflag");
				InitDataProperty(0, cnt++, dtDummyCheck,    40,     daCenter,   false,      "sel");

				InitDataProperty(0, cnt++ , dtHidden,       90,     daCenter,   false,      "tmplt_seq",    false,		"",        dfNone,     0,          true,       true,      10);
				InitDataProperty(0, cnt++ , dtHidden,       90,     daCenter,   false,      "tmplt_tp_cd",  false,		"",        dfNone,     0,          true,       true,      10);
				InitDataProperty(0, cnt++ , dtData,	       140,     daLeft,     false,      "tmplt_hdr_nm", false,		"",        dfNone,     0,          true,       true,      10);
				InitDataProperty(0, cnt++ , dtData,	       200,     daLeftTop,  false,      "tmplt_ctnt",   false,		"",        dfNone,     0,          true,       true,      2000);

				WordWrap = true;
				CountPosition = 0;

			}
		break;

    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
		
		case IBSEARCH:      //조회
			if(validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_BKG_0365GS.do", FormQueryString(formObj));
			}
			var mk_type = getRadioValue(formObj.marks_type);
			filteredData(sheetObj, mk_type);
		break;
		
		case IBINSERT:      // 입력
			var newRow = sheetObj.DataInsert(-1);
			sheetObj.cellValue2(newRow, "tmplt_tp_cd") = getRadioValue(formObj.marks_type);//formObj.tmplt_tp_cd.value;
		break;
		
		case IBDELETE:      // 삭제
			ComRowHideDelete(sheetObj, "sel");
		break;
		
		case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_BKG_0365GS.do", FormQueryString(formObj), -1, false, true);
			}
		break;
		
		case IBCOPYROW:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
				//alert(sheetObj.CellValue(row, "tmplt_ctnt"));
				if(returnObject == undefined || returnObject == null){
					//alert("부모창에서 객체를 확인 할 수 없습니다.");
				}else{
					var arrRow = ComFindText(sheetObj, "sel", 1);
					if(formObj.tmplt_tp_cd.value == 'T'){
						returnObject.value = sheetObj.CellValue(arrRow[0], "tmplt_ctnt");
					}else{
						returnObject.value += sheetObj.CellValue(arrRow[0], "tmplt_ctnt");
					}
					opener.document.form.dirty_flag.value = "Y";
					self.close();
				}
			}
		break;
		
    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj,sAction){
	
	switch(sAction) {
	
		case IBSEARCH:      //조회
		
		break;
		
		case IBSAVE:        //저장
			if(!confirm(ComGetMsg("BKG00498"))) {
				return false;
			}
			if(cur_usr_id == '') {
				ComShowMessage(ComGetMsg("BKG00768"));
				return false;
			}
		break;
		
      	case IBCOPYROW:      // 복사
		    var arrRow = ComFindText(sheetObj, "sel", 1);
			//alert(arrRow);
			if(arrRow.length == 0) {
				ComShowMessage(ComGetMsg("BKG08040"));
				return false;
			}
			if(arrRow.length > 1) {
				ComShowMessage(ComGetMsg("BKG08040"));
				return false;
			}
        break;
		
	}
	
    return true;
	
}


function form1_blur(){
	var srcName = event.srcElement.getAttribute("name");
	switch(srcName){
		case "bkg_no":
			
		break;
	}
}

function form1_change(){
	/* 대문자 */
	if(event.srcElement.type =="text") {
		event.srcElement.value = event.srcElement.value.toUpperCase();
	}

	var srcName = event.srcElement.getAttribute("name");
	switch(srcName){
		case "marks_type":

		break;
	}		
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	if(!opener) opener = window.dialogArguments; 
	opener.doActionIBSheet(opener.sheetObjects[1], opener.document.form, SEARCH01);	
}

function filteredData(sheetObj, mkType){
	var cnt = sheetObj.RowCount;
	for (ix = 1; ix <= cnt; ix++) {
		if(sheetObj.RowStatus(ix) == 'D') continue;
		//alert("* " + ix + " : " + mkType + " = " + sheetObj.CellValue(ix, "tmplt_tp_cd"));
		if(sheetObj.CellValue(ix, "tmplt_tp_cd") == mkType){
			sheetObj.RowHidden(ix) = false;
		}else{
			sheetObj.CellValue(ix, "sel") = 0;
			sheetObj.RowHidden(ix) = true;
		}
	}
}

function callbackOffice(retVal){
	//alert(retVal);
	if(retVal == undefined || retVal.length == 0) return;
	//HEAD OFFICE,SEOUL|$$|25-11,YOIDO-DONG, YOUNGDEUNGPO-KU, SEOUL, KOREA|$$|KR|$$|82-2-3770-6114|$$|82-2-3770-6747
	var rets = retVal.split("|$$|");
	//
	var nrow = sheetObjects[0].DataInsert(-1);
	sheetObjects[0].cellValue2(nrow, "tmplt_tp_cd") = getRadioValue(document.form.marks_type);
	sheetObjects[0].cellValue2(nrow, "tmplt_hdr_nm") = rets[0];
	sheetObjects[0].cellValue2(nrow, "tmplt_ctnt") = rets[1] + '\n' + rets[2] + '\nTel: ' + rets[4] + '\nFax: ' + rets[5];
}

/* 개발자 작업  끝 */


//===================================
