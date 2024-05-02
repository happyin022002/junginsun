/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0892.js
*@FileTitle : Container No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.24 김영출
* 1.0 Creation
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
     * @class ui_bkg_0892 : ui_bkg_0892 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ui_bkg_0892() {
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
	var callback_func = '';
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject1 = sheetObjects[0];
     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

			case "btn_Select":
				//var sRow = sheetObject1.FindCheckedRow("sel");
				//alert("sRow -> "+sRow);
				/*
				if(sRow==''){
					alert("no selected row.");
					break;
				}else{
					//returnArr
					var returnArr = new Array();
					//arrRow
					var arrRow = sRow.split("|");
					for(ir=0;ir<arrRow.length;ir++){
						if(arrRow[ir] == '') continue;
						//rowArr
						var rowArr = new Array();
						rowArr.push(sheetObject1.CellValue(arrRow[ir], "cntr_no"));
						rowArr.push(sheetObject1.CellValue(arrRow[ir], "cntr_tpsz_cd"));
						rowArr.push(sheetObject1.CellValue(arrRow[ir], "mf_cfm_flg"));
						//returnArr
						returnArr.push(rowArr);

					}				
					//alert(returnArr);
					if(!opener) opener = window.dialogArguments; 
					if(callback_func != ''){
						eval('opener.'+callback_func)(returnArr);
					}
				}
				*/
				var arrRow = ComFindText(sheetObject1, "sel", 1);
				if(arrRow.length==0){
					alert(ComGetMsg('BKG00188'));
					break;
				}else if(arrRow.length==1){
					if(!opener) opener = window.dialogArguments; 
					if(callback_func != ''){
						eval('opener.'+callback_func)(sheetObject1.CellValue(arrRow[0], "cntr_no"), formObject.bkg_vvd.value);
					}
				}else{
					alert(ComGetMsg('BKG00193'));
					break;
				}
			//break;

			case "btn_Close":
				self.close();
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

    	//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );
		//init sheet
        initSheet(sheetObjects[i],i+1);
    	//khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);

    }

	// init data
	//if(document.form.bkg_vvd.value != ''){
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	//}
	
	//add listener
	//axon_event.addListenerForm('blur', 'form1_blur', document.form);
	//axon_event.addListenerForm('focus', 'form1_focus', document.form);
    axon_event.addListenerFormat('keypress', 'form1_keypress', document.form);
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
				style.height = 120;

				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 5, 100);

				var HeadTitle = "|Seq.|Container No.|TP/SZ|C/M Confirm";
				var headCount = ComCountHeadTitle(HeadTitle);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtCheckBox,	20,		daCenter,	false,	"sel");
				InitDataProperty(0,	cnt++,	dtSeq,		40,		daCenter,	false,	"seq");
				InitDataProperty(0,	cnt++,	dtData,		130,	daLeft,		false,	"cntr_no",      false,	"",		dfNone,		0,		true,		true);
				InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	false,	"cntr_tpsz_cd", false,	"",		dfNone,		0,		true,		true);
				InitDataProperty(0,	cnt++,	dtData,		40,		daCenter,	false,	"mf_cfm_flg",   false,	"",		dfNone,		0,		true,		true);
				
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
          		sheetObj.DoSearch("ESM_BKG_0892GS.do", FormQueryString(formObj));

				for(ir=1;ir<=sheetObj.RowCount;ir++){
					if(sheetObj.CellValue(ir, "mf_cfm_flg") == 'Y'){
						//sheetObj.CellEditable(ir, "cntr_no")  = false;
						//sheetObj.CellEditable(ir, "cntr_tpsz_cd")  = false;
						//sheetObj.RowBackColor(ir) = 0;
						sheetObj.RowEditable(ir)  = false;
					}else{
						//sheetObj.CellEditable(ir, "cntr_no")  = true;
						//sheetObj.CellEditable(ir, "cntr_tpsz_cd")  = true;
						//sheetObj.RowBackColor(ir) = -1;
						sheetObj.RowEditable(ir)  = true;
					}
				}

          	}
        break;

    }
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
    switch(sAction) {

      	case IBSEARCH:      // 조회
			if(formObj.bkg_vvd.value == '') {
				alert(ComGetMsg('BKG00115'));
				formObj.bkg_vvd.focus();
				return false;
			}
			if(formObj.bkg_vvd.value.length != '9') {
				alert(ComGetMsg('BKG00780'));
				formObj.bkg_vvd.select();
				return false;
			}
			if(formObj.bkg_ofc_cd.value == '') {
				alert(ComGetMsg('BKG00823'));
				formObj.bkg_ofc_cd.focus();
				return false;
			}
			if(formObj.bkg_pol.value == '') {
				alert(ComGetMsg('BKG00823'));
				formObj.bkg_pol.focus();
				return false;
			}
			//if(formObj.bkg_pod.value == '') {
			//	alert(ComGetMsg('BKG00823'));
			//	formObj.bkg_pod.focus();
			//	return false;
			//}
        break;

      	case IBCOPYROW:      // 선택
			var selCount = 0;
			for(ir=1;ir<sheetObj.RowCount+1;ir++){
				if(sheetObj.CellValue(ir, "sel") == 1){
					selCount++;
				}
			}
			if(selCount == 0) {
				alert(ComGetMsg('BKG00188'));
				return false;
			}
			if(selCount > 1) {
				alert(ComGetMsg('BKG00193'));
				return false;
			}
        break;
    } // end switch

    return true;
}


function form1_keypress(){
	if (event.srcElement.type == "text" && event.keyCode == 13 ) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		//ComKeyEnter("search");
	}
	switch(event.srcElement.dataformat){
		case "ymd":
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "ym":
		case "yw":
		case "jumin":
		case "saupja":	//숫자 + "-"
			ComKeyOnlyNumber(event.srcElement, "-"); 
		break;
		case "hms":
		case "hm":		//숫자 + ":"
			ComKeyOnlyNumber(event.srcElement, ":"); 
		break;
		case "int":		//숫자
			ComKeyOnlyNumber(event.srcElement); 
		break;
		case "float":	//숫자+"."	            
			ComKeyOnlyNumber(event.srcElement, "."); 
		break;	    
		case "engup":
			//영문대문자
			ComKeyOnlyAlphabet("upper");
		break;
		case "engupnum":
			//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet("uppernum");
		break;
		case "engupnumspc":
			//영문대문자 + 숫자 + 스페이스
			//ComKeyOnlyAlphabet("uppernum", "32|45|95");
			var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
			if(keyValue >= 97 && keyValue <= 122){                  //소문자
            	event.keyCode = keyValue + 65 - 97;
			}
			//event.returnValue = true;
		break;
	}	
}

function form1_change(){
	
	/* 대문자 */
	//if(event.srcElement.type =="text") {
	//	event.srcElement.value = event.srcElement.value.toUpperCase();
	//}

	var srcName = event.srcElement.getAttribute("name");
	switch(srcName){
		case "bkg_no":
			//var comboObj = event.srcElement;
			//document.form.bkg_no_split.value = comboObj.options[comboObj.selectedIndex].value;
		break;
	}
}

function sheet1_OnChange(sheetObj, row, col) {
	//sheetObj.cellValue2(row, col) = sheetObj.cellValue(row, col).toUpperCase();
}

/* 개발자 작업  끝 */