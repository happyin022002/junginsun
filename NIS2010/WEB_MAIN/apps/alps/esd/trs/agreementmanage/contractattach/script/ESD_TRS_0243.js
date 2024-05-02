/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_TRS_0243.js
 *@FileTitle : Contract Attach
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
===============================================================================
 History

=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESD_TRS_0243 : ESD_TRS_0243 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0243() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
//var calPop = new ComCalendarGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var comboObjects = new Array();
var comboCnt = 0 ;
var rdObjects = new Array();

var allClickFlg = false;
var request = null;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btng_save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btng_delete":
				doActionIBSheet(sheetObject, formObj, IBDELETE);
				break;
			case "btng_rowadd2":
				doActionIBSheet2(sheetObject2, formObj, IBINSERT);
				break;	
			case "btng_save2":
				doActionIBSheet2(sheetObject2, formObj, IBSAVE);
				break;	
			case "btng_delete2":
				doActionIBSheet2(sheetObject2, formObj, IBDELETE);
				break;	
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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
	//Initializing
	initControl();
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
    axon_event.addListenerFormat('blur',    'obj_blur',     form);	//Blur
//    axon_event.addListenerFormat('focus',   'obj_focus',    form);	//Focus
    axon_event.addListenerFormat('keypress','obj_keypress', form);	//Key Press 
	var formObj = document.form;
    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH);
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
	var elementObj = event.srcElement;
	var formObj = document.form;
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
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "engup":		//영문대문자
	 		ComKeyOnlyAlphabet('upper');
	 		break;
	 		
		case "engupnum":	//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "num":			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		
		case "engnum":		//숫자+"영문대소"입력하기
			ComKeyOnlyAlphabet('num'); 
			break;
			
		case "engupcomma":	//영문대문자+Comma
			ComKeyOnlyAlphabet('upper', '44');
	        break;
		
		default:
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
				style.height = GetSheetHeight(2);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = 				"Sts||SEQ|G/W Link|View|agmt_doc_no|trsp_agmt_ofc_cty_cd|trsp_agmt_seq|ctrt_seq|ctrt_mn_flg";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,	0,	daCenter,	true,		"ibflag",   	false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++ , dtCheckBox,		0, daCenter,   true,       "chk",		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"seq", 			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtPopup,   	 320,	daLeft, 	true,    	"agmt_doc_desc", 	false, 		"", 		dfNone, 	0, 			true, 		true, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtPopup,   	  13,	daCenter, 	true,    	"contract_view", 	false, 		"", 		dfNone, 	0, 			true, 		true, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"agmt_doc_no", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"trsp_agmt_ofc_cty_cd", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"trsp_agmt_seq", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"ctrt_seq", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"ctrt_mn_flg", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				CountPosition = 0 ;
				ColHidden("chk") = true;
			}
			break;
			
		case 2:      //sheet1 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(7);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 1);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = 				"Sts||SEQ|G/W Link|View|agmt_doc_no|trsp_agmt_ofc_cty_cd|trsp_agmt_seq|ctrt_seq|ctrt_mn_flg";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,	0,	daCenter,	true,		"ibflag",   	false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++ , dtCheckBox,		0, daCenter,   true,       "chk",		false);
				InitDataProperty(0, cnt++, 	dtSeq,   		0,	daCenter, 	true,    	"seq", 			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtPopup,   	250,	daLeft, 	true,    	"agmt_doc_desc", 	false, 		"", 		dfNone, 	0, 			true, 		true, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtPopup,   	  13,	daCenter, 	true,    	"contract_view", 	false, 		"", 		dfNone, 	0, 			true, 		true, 			30, 	false,	 	true, 		"", 		false);				
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"agmt_doc_no", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"trsp_agmt_ofc_cty_cd", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"trsp_agmt_seq", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"ctrt_seq", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		0,	daCenter, 	true,    	"ctrt_mn_flg", 		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);

				CountPosition = 0 ;
			}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, chkflg) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:		//Retrieve
		    formObj.f_cmd.value = SEARCH02;
		    formObj.f_ctrt_mn_flg.value = "Y";
		    sheetObj.DoSearch("ESD_TRS_0243GS.do", TrsFrmQryString(formObj));
	   		break;
		case IBSAVE:       //Save
			formObj.f_cmd.value = MULTI01;			
			sheetObj.DoSave("ESD_TRS_0243GS.do", TrsFrmQryString(formObj),-1, false);
			break;
		case IBDELETE:       //delete
			formObj.f_cmd.value = REMOVE;
			sheetObj.CellValue2(1,'chk') = "1";
			sheetObj.DoSave("ESD_TRS_0243GS.do",TrsFrmQryString(formObj),-1,false);
			break;
		case IBINSERT:       //insert
    	    var row = sheetObj.DataInsert(-1);
    	    var agmt_no = formObj.agmt_no.value;
    	    sheetObj.CellValue2(row,'ctrt_seq') = "0";
    	    sheetObj.CellValue2(row,'ctrt_mn_flg') = "Y";
    	    sheetObj.CellValue2(row,'trsp_agmt_ofc_cty_cd') = agmt_no.substring(0,3);
    	    sheetObj.CellValue2(row,'trsp_agmt_seq') = agmt_no.substring(3);
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj,formObj,sAction, chkflg) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:		//Retrieve
		    formObj.f_cmd.value = SEARCH02;
		    formObj.f_ctrt_mn_flg.value = "N";
		    sheetObj.DoSearch("ESD_TRS_0243GS.do", TrsFrmQryString(formObj));
	   		break;
		case IBSAVE:       //Save
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESD_TRS_0243GS.do", TrsFrmQryString(formObj),-1, false);
			break;
		case IBDELETE:       //delete
			var vMsg = "";
			var saveRows = sheetObj.FindCheckedRow("chk");
			var arrRow = saveRows.split("|");
			if(arrRow.length == 1){
				var errMessage = ComGetMsg('TRS90215'); 
				ComShowMessage(errMessage);
				break;
			}else if(confirm(ComGetMsg("COM12165", vMsg))){
				var checkList = sheetObj.FindCheckedRow('chk');
				if(checkList == '') {
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');
				var queryStr = sheetObj.GetSaveString(false, false, "chk");
				formObj.f_cmd.value = REMOVE;
				sheetObj.DoSave("ESD_TRS_0243GS.do", TrsFrmQryString(formObj), -1, false, true);
			}
			break;
		case IBINSERT:       //insert
    	    var row = sheetObj.DataInsert(-1);
    	    var agmt_no = formObj.agmt_no.value;
    	    sheetObj.CellValue2(row,'ctrt_mn_flg') = "N";
    	    sheetObj.CellValue2(row,'trsp_agmt_ofc_cty_cd') = agmt_no.substring(0,3);
    	    sheetObj.CellValue2(row,'trsp_agmt_seq') = agmt_no.substring(3);
			break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case IBDOWNEXCEL:
			//그리드 데이터 없을 경우
			if( sheetObj.RowCount <= 0 ){
				return false;
			}
			break;
	}
	
	return true;
}

/**
 * 조회후 발생하는 EVENT
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg){
	//RowCount
	var formObj = document.form;
	if(sheetObj.RowCount == 0) {
		doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
	}
}

/**
 * Rate 삭제후 발생하는 이벤트를 처리
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		//ComShowMessage(errMsg);
	} else {
		var formObj = document.form;
	    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
}

/**
 * sheet1 OnPopupClick event
 */
function sheet1_OnPopupClick(sheetObj, row, col)
{
	var formObj = document.form;
	formObj.f_sheet.value = 'sheet1';
	formObj.f_row.value = row;
	var csrGwUrl = formObj.csr_gw_rul.value;
	ifrm = document.createElement("IFRAME");
	ifrm.setAttribute("id", "gwrequest");
	ifrm.style.width = 0+"px";
	ifrm.style.height = 0+"px";
	if ( sheetObj.ColSaveName(col) == "agmt_doc_desc" )
	{
		var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACT&parameter=ALPS|TRS");
		ifrm.setAttribute("src", url);
		document.body.appendChild(ifrm);
	}else if ( sheetObj.ColSaveName(col) == "contract_view" ) {
		assetcd =  sheetObj.CellValue(row,'agmt_doc_no');
		var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+assetcd);
		ifrm.setAttribute("src", url);
		document.body.appendChild(ifrm);
	}
}

/**
 * 조회후 발생하는 EVENT
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj,errMsg){
	//RowCount
	var formObj = document.form;
	if(sheetObj.RowCount == 0) {
		doActionIBSheet2(sheetObjects[1], formObj, IBINSERT);
	}
}

/**
 * Rate 삭제후 발생하는 이벤트를 처리
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		//ComShowMessage(errMsg);
	} else {
		var formObj = document.form;
		doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH);
	}
}

/**
 * sheet2 OnPopupClick event
 */
function sheet2_OnPopupClick(sheetObj, row, col)
{
	var formObj = document.form;
	formObj.f_sheet.value = 'sheet2';
	formObj.f_row.value = row;
	var csrGwUrl = formObj.csr_gw_rul.value;
	ifrm = document.createElement("IFRAME");
	ifrm.setAttribute("id", "gwrequest");
	ifrm.style.width = 0+"px";
	ifrm.style.height = 0+"px";
	if ( sheetObj.ColSaveName(col) == "agmt_doc_desc" )
	{
		var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACT&parameter=ALPS|TRS");
		ifrm.setAttribute("src", url);
		document.body.appendChild(ifrm);
	}else if ( sheetObj.ColSaveName(col) == "contract_view" ) {
		assetcd =  sheetObj.CellValue(row,'agmt_doc_no');
		var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+assetcd);
		ifrm.setAttribute("src", url);
		document.body.appendChild(ifrm);
	}
}

/**
 * G/W 값 return
 */
//return 처리를 위한 함수 (필수)
function receiveMessage(event) {
	// 리턴 처리 방법
	returnGwLink(event.data)
}

if(window.addEventListener) {
	window.addEventListener("message", receiveMessage, false);
}

if(window.attachEvent) {
	window.attachEvent("onmessage", receiveMessage);
}

if(document.attachEvent) {
	document.attachEvent("onmessage", receiveMessage);
}

//GW에서 리턴된 값 화면 적용
function returnGwLink(msg){
	msg = msg.split(",");
	/* IBTab 초기화 */
	var formObj = document.form;
	var gw_no = msg[0];
	var gw_desc = msg[1];
	
	var sheet = formObj.f_sheet.value;
	var row = formObj.f_row.value;
	if (sheet == 'sheet1') {
		sheetObjects[0].CellValue2(row,'agmt_doc_no') = gw_no;
		sheetObjects[0].CellValue2(row,'agmt_doc_desc') = gw_desc;
	}else if (sheet == 'sheet2') {
		sheetObjects[1].CellValue2(row,'agmt_doc_no') = gw_no;
		sheetObjects[1].CellValue2(row,'agmt_doc_desc') = gw_desc;
	}	
}

