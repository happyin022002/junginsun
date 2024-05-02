/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_SCE_0140.js
 *@FileTitle : SCEM - Dwell Status Inquiry by Dwell Type
 *Open Issues :
 *@LastModifyDate : 2011.07.05
 *@LastModifier : 손은주
 *@LastVersion : 1.0
 * 2011.07.05 손은주
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class ESD_SCE_0140 : ESD_SCE_0140 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */


function ESD_SCE_0140() {
	this.processButtonClick = tprocessButtonClick;
	this.setComboObject = setComboObject;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var isFirstOnLoad = "false";
var isCopyAllRequested = false;
var saveFail = false;
var saveSuccess = true;

var tabTitle = new Array();
tabTitle[0] = "96 hrs TMNL Dwell";
tabTitle[1] = "48hrs Enroute Dwell";
tabTitle[2] = "72 hrs DEST Dwell";
tabTitle[3] = "24 hrs Vessel Delay";	


//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":
			formObject.t1_load_flg.value="N";
			formObject.t2_load_flg.value="N";
			formObject.t3_load_flg.value="N";
			formObject.t4_load_flg.value="N";
			formObject.btn_action.value="R";
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_new":

			sheetObject.RemoveAll();
			initSheet(sheetObject,1);
			clearAllTabPages();
			formObject.reset();
			document.sc_no.Code = "";
			document.sc_no.Text = "";	
			document.sc_no.Enable = true; 
			for(var k = 0; k < comboObjects[0].GetCount(); k++){
				comboObjects[0].CheckIndex(k) = true; 
		    }
			tabObjects[0].SelectedIndex = 0;

			break;
		case "btns_calendar": //달력버튼
            var cal = new ComCalendar();                
            cal.select(document.form.search_dt,'yyyy-MM-dd');

            break;  
            
		case "btn_clm":
			goESD_SCE_0044();
			break;

		case "btn_cntrhis":
			goCntrHistory();
			break;

		case "btn_excel":
			downExcel();
			break;

		case "btn_text":
			downText();
			break;
			
		case "btn_print":
			downPrint();
			break;
		case "btn_ctrt_cust":
          	openCustomerPop(false,'cust_cd');
        break; 	
        
		case "ComOpenPopupWithTarget":	// Office Code 가져오기 팝업
            ComOpenPopupWithTarget('COM_ENS_071.do', 800, 470, "ofc_cd:ctrt_ofc_cd", "1,0,1,1,1,1,1,1", true);
            break;
            
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function initControl() {
//    axon_event.addListenerForm('keyup', 'objKeyUp', form ); 
    axon_event.addListenerForm('keypress', 'objKeyPress', document.form);
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

 
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을<br>
 * 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function loadPage() {
	var dwll_tm_tp_cd = document.form.dwll_tm_tp_cd.value; 
	for ( var k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	if( dwll_tm_tp_cd == 'T96')
		tabObjects[0].SelectedIndex = 0;
	else if( dwll_tm_tp_cd == 'E48')
		tabObjects[0].SelectedIndex = 1;
	else if( dwll_tm_tp_cd == 'D72')
		tabObjects[0].SelectedIndex = 2;
	else if( dwll_tm_tp_cd == 'V24')
		tabObjects[0].SelectedIndex = 3;
	else
		tabObjects[0].SelectedIndex = 0;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k = 0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
	
	getScNoList();
	for(var k = 0; k < comboObjects[0].GetCount(); k++){
		comboObjects[0].CheckIndex(k) = true; 
    }
	
	tab1_OnChange(tabObjects[0], tabObjects[0].SelectedIndex);
	
	initControl();
	
}
 
/**
 * 콤보 초기설정값 정의 <br>
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            comboObj 필수, combo개체
 * @param {int}
 *            comboNo 필수, combo index
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "sc_no":
            with(comboObj) {
            	DropHeight = 120;
            	SetColAlign("left|left");
            	SetColWidth("50|350");
            	MultiSelect = true;
            	//MaxSelect = 1;
            	UseAutoComplete = true;
            	
            	IMEMode = 0;
            	ValidChar(2, 0);
            }
            break;
    }
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인<br>
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, sheet개체
 * @param {int}
 *            sheetNo 필수, sheet 번호
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: 
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 4, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(4, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "tab1Total|tab2Total|tab3Total|tab4Total";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "tab1total");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "tab2total");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "tab3total");
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "tab4total");
		}
		break;
	}
}


/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스상단에 정의<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            tabObj 필수, tab개체
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function setTabObject(tabObj) {
	tabObjects[tabCnt++] = tabObj;
}
 
/**
 * IBCombo Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            comboObj 필수, combo개체
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function setComboObject(comboObj){
	comboObjects[comboCnt++] = comboObj;
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            tabObj 필수, Sheet개체
 * @param {Object}
 *            tabNo 필수, tab번호
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, tabTitle[0], -1);	
			InsertTab(cnt++, tabTitle[1], -1);	
			InsertTab(cnt++, tabTitle[2], -1);	
			InsertTab(cnt++, tabTitle[3], -1);	
		}
		break;
	}
	tabObj.TabMouseOverEffect = true;
}


/**
 * Sheet 관련 처리 프로세스<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {Object}
 *            formObj 필수, 폼개체
 * @param {String}
 *            sAction 필수, 작업코드
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH:	
		if(!validateForm(sheetObj,formObj,sAction)) { return;}

//		if( formObj.search_dt.value == ""){
//			ComShowCodeMessage("COM130201","Date");
//			return;
//		}
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH01 ;
//		alert(formObj.cust_value1.value);
//		alert(SceFrmQryString(formObj));
		sheetObj.DoSearch4Post("ESD_SCE_0140GS.do", SceFrmQryString(formObj));
		if( sheetObj.RowCount > 0 ){
			for (var i = 0; i < tabObjects[0].GetCount(); i++) {
				tabObjects[0].tabText(i) = tabTitle[i]+ " (total: "+sheetObj.cellValue(1,"tab"+(i+1)+"total")+")";

			}
		}else{
			for (var i = 0; i < tabObjects[0].GetCount(); i++) {
				tabObjects[0].tabText(i) = tabTitle[i]+ " (total: 0)";
			}
		}
		for (var i = 0; i < tabObjects[0].GetCount(); i++) {
			loadTabPage(i);
		}
//		ComOpenWait(false);
		break;
	}
}
 
 /**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {Object}
 *            formObj 필수, 폼개체
 * @param {int}
 *            sAction 필수, 작업코드
 * @return {boolean} Validation 결과값
 * @author Park Mangeon
 * @version 2009.10.01
 */
 function validateForm(sheetObj,formObj,sAction){
    var formObj = document.form;
    if(!ComChkValid(formObj)) return false;
    return true;
 }

/**
 * Tab 기본 설정 탭의 항목을 설정한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function getScNoList() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var query = SceFrmQryString(formObj);
	sheetObj.RemoveEtcData();
	sheetObj.DoSearch4Post("ESD_SCE_0140GS.do", query);
	eval(sheetObj.EtcData('sc_no'));

	var comboObj = document.sc_no;
	comboObj.RemoveAll();
	var scCodeArray = scCode.split('|');
	var scTextArray = scText.split('|');
	for(k=0; k < scCodeArray.length; k++){
		comboObj.InsertItem(k, scCodeArray[k]+'|'+scTextArray[k], scCodeArray[k]);
	}
}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {Object} tabObj 필수 IBSheet Tab Object
 * @param {int} tabIndex 필수 Tab의 Index번호
 * @return {void}
 * @author 손은주
 * @version 2011.07.08
 */
function tab1_OnChange(tabObj, tabIndex) {
	var formObj = document.form;
	if (beforetab != tabIndex) {
	    var objs = document.all.item("tabLayer");

	    objs[tabIndex].style.display = "inline";
	    objs[beforetab].style.display = "none";
	    
	    if(tabIndex == 0){
	    	formObj.dwll_tm_tp_cd.value="T96";
	    }else if(tabIndex == 1){
	    	formObj.dwll_tm_tp_cd.value="E48";
	    }else if(tabIndex == 2){
	    	formObj.dwll_tm_tp_cd.value="D72";
	    }else if(tabIndex == 3){
	    	formObj.dwll_tm_tp_cd.value="V24";
	    }

	}

   beforetab = tabIndex;
   
   loadTabPage(tabIndex);
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.<br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {int} tabIndex 필수 Tab배열의 번호
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function loadTabPage(tabIndex) {
	var formObj = document.form;
	if (tabIndex == null || tabIndex == "") {
		//tabIndex = tabObjects[0].SelectedIndex;
		//alert("kk");
	}

	var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;

	if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
			
		var sUrl = "";
		switch (tabIndex) {
		case 0:
			sUrl = "ESD_SCE_0141.do"; 
			break;
		case 1:
			sUrl = "ESD_SCE_0142.do"; 
			break;
		case 2:
			sUrl = "ESD_SCE_0143.do";  
			break;
		case 3:
			sUrl = "ESD_SCE_0144.do";  
			break;
		
		}
		objTabWindow.location.href = sUrl;
		return true;
	
	}
	
	objTabWindow.tabLoadSheet();

}

/**
 * 모든 Tab을 초기화 한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function clearAllTabPages() {
	for (var i = 0; i < tabObjects[0].GetCount(); i++) {
		if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
			document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
		}
	}
}

/**
 * 모든 Tab을 활성화 할 것인지 결정한다.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {boolean} flag 필수 Tab 기본 설정 탭의 항목을 설정
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function enableAllTabPages(flag) {
	
	if (flag == null || flag == "") {
		if (isAproUsr && document.form.cfm_flg.value.toUpperCase() != "YES") {
			flag = true;
		} else {
			flag = false;
		}
	}
	
	for (var i = 0; i < tabObjects[0].GetCount(); i++) {
		if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
			document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
		}
	}
}

/**
 * CLM Open.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function goESD_SCE_0044(){
	var tabIndex = tabObjects[0].SelectedIndex;
	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabCntrSelect();
	
    var formObj = document.form ;
	if(formObj.t_cntr_no.value==""){
  		ComShowMessage(ComGetMsg('SCE90018'));
  		return ;
  	}
    var cntrNO      =  formObj.t_cntr_no.value ;
    var tpszCd		=  formObj.t_cntr_tpsz_cd.value;

    var paramUrl = "cntr_no="+cntrNO+"&tpsz_cd="+tpszCd;
    var newWin = window.showModalDialog("ESD_SCE_0044.do?"+paramUrl, "clm_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:525px");


}

/**
 * index : 해당 tab index, total : 변경하고자 하는 total count : -1값이면 초기화 상태로 setting.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {int} index 필수 해당 Tab index
 * @param {int} total 필수 -1값이면 초기화 상태로
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function setTabTotal(index, total) {
	if( total >= 0 ){
		tabObjects[0].tabText(index) = tabTitle[index]+ " (total: "+total+")";
	}else{
		tabObjects[0].tabText(index) = tabTitle[index];
	}
}

/**
 * Excel Download<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function downExcel(){
	var tabIndex = tabObjects[0].SelectedIndex;
	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabDownExcel();
}

/**
 * Text Download.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function downText(){
	var tabIndex = tabObjects[0].SelectedIndex;
	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabDownText();
}

/**
 * 화면 Print.<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function downPrint(){
	var tabIndex = tabObjects[0].SelectedIndex;
	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabDownPrint();
}

/**
 * comboObject인 sc_no가 변경되었을 경우의 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object} comboObj 필수 Combo객체
 * @param {String} text 필수 Combo에 선택된 코드를 연결한 문자열
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function sc_no_OnChange(comboObj,text){
	var formObj = document.form;
	var textArray = text.split(',');
	if( textArray.length >= 2){
		formObj.sc_no2.value="";
		formObj.sc_no2.disabled = true;
		formObj.sc_no2.className ="input2";
	}else{
		formObj.sc_no2.disabled = false;
		formObj.sc_no2.className ="input";
	}
}

/**
 * History Popup<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {void}
 * @return {void}
 * @author Son eun ju
 * @version 2011.08.30
 */
function goCntrHistory(){
	var tabIndex = tabObjects[0].SelectedIndex;
	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabCntrSelect();
	
    var formObj = document.form ;
	if(formObj.t_cntr_no.value==""){
  		ComShowMessage(ComGetMsg('SCE90018'));
  		return ;
  	}
    var cntrNO      =  formObj.t_cntr_no.value ;
    var tpszCd		=  formObj.t_cntr_tpsz_cd.value;


    var paramUrl = "func=&cntrNo="+cntrNO+"&checkDigit=&typeSize="+tpszCd;
    //Cntr History URL 변경해줘야함.
    var newWin = window.showModalDialog("EES_CTM_0411.do?"+paramUrl, "cntrHis_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1010px;dialogHeight:650px");

}

///**
//* 화면 개체에 클릭했을 때의 이벤트 처리<br>
//* <br>
//* <b>Example : </b>
//*
//* <pre>
//* </pre>
//*
//* @param {void}
//* @return {void}
//* @author Park Mangeon
//* @version 2009.10.01
//*/
//function objKeyUp() {
//   var objName = event.srcElement.name;
//   var formObj = document.form;
//   switch(objName) {
//       case "pod_cd":
//    	   ComChkObjValid(event.srcElement);
//           break;
//       case "rail_dest":
//    	   ComChkObjValid(event.srcElement);
//           break;
//       case "vvd":
//    	   ComChkObjValid(event.srcElement);
//           break;
//       case "bkg_no":
//    	   ComChkObjValid(event.srcElement);
//           break;
//       case "bl_no":
//    	   ComChkObjValid(event.srcElement);
//           break;
//       case "cntr_no":
//    	   ComChkObjValid(event.srcElement);
//           break;
//   }
//}	

/**
* 개체에서 키보드를 눌렀을때 발생하는 이벤트를 처리<br>
* <br>
* <b>Example : </b>
*
* <pre>
* </pre>
*
* @param {void}
* @return void
* @author Park Mangeon
* @version 2009.10.01
*/
function objKeyPress() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
	    case "search_dt":
	    	obj_KeyPress(event.srcElement);
		    break;
	    case "ctrt_ofc_cd":
		    ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "pod_cd":
		    ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "del_cd":
		    ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "rail_dest":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "vvd":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "bkg_no":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "bl_no":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "cntr_no":
	    	ComKeyOnlyAlphabet('uppernum');
		    break;
	    case "sc_no2":
	    	ComKeyOnlyNumber(event.srcElement);
	    	break;
	    case "cust_seq":
	    	ComKeyOnlyNumber(event.srcElement);
	    	break;
	    case "cust_cnt_cd":
	    	ComKeyOnlyAlphabet('uppernum');
	    	break;
    }
    
}


function changeSCNoFlg() {
	var formObject = document.form;
    if(formObject.SCNoFlg.checked ){
    	 for(var k = 0; k < comboObjects[0].GetCount(); k++){
     		comboObjects[0].CheckIndex(k) = true; 
         }
              
     } else {
    	 for(var k = 0; k < comboObjects[0].GetCount(); k++){
     		comboObjects[0].CheckIndex(k) = false; 
         }
     }
}
// CUSTOMER 환경 설정 
function changeCustNoText(){
	formObj = document.form;
	formObj.cust_cd.value = formObj.cust_cnt_cd.value + formObj.cust_seq.value;
}

function focusCustSeq(){
	formObj = document.form;
	if(formObj.cust_cnt_cd.value.length == 2){
	formObj.cust_seq.focus();
	}
}

function openCustomerPop(multi, custCd, custNm, ofcCd, custSgmt){
	var formObj = document.form ;
	var param   = "" ;
	var display = getCommPopDisplay(multi) ;

	param  = "?classId=" + getCommPopClassId() ;
	param += getURLParam(multi, "cust_cd", custCd) ;
	param += getURLParam(multi, "cust_nm", custNm) ;
	param += getURLParam(multi, "ofc_cd",  ofcCd) ;

	custCdFld   = custCd ;
	custNmFld   = custNm ;
	ofcCdFld    = ofcCd ;
	custSgmtFld = custSgmt ;
	multiChkYN  = multi ;
	ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 450, 'setValFromCustomerPop', display, true) ;
}

 function setValFromCustomerPop(rowArray){
	var colArray = null ;
	var formObj = document.form;
	
	colArray = rowArray[0] ;
	formObj.cust_cnt_cd.value = colArray[3].substring(0,2);
	formObj.cust_seq.value = colArray[3].substring(2);
}