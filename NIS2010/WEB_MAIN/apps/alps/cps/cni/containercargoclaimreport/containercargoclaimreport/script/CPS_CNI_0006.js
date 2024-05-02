/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0006.js
 *@FileTitle : [CPS_CNI_0006] Cargo Claim Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.20
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.11.20 정행룡
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0006] Status
 * 
 * @extends
 * @class Status 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function cps_cni_0006() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.validateForm       = validateForm;
}

// 공통전역변수

//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
//HTML Form
var frm = null;

var rdObjects = new Array();
var rdCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	frm = document.form;
	
	
	sheet1 = sheetObjects[0];
	
	sheetCnt = sheetObjects.length;
	
	sheet1.WaitImageVisible = false;
	// 시트 초기화
	for ( var i = 0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//Form 이벤트 등록
	initControl();
	
	//RD
	initRdConfig(rdObjects[0],"CPS_CNI_0062_01.mrd");
	
	if (ComGetObjValue(frm.cgo_clm_no) !=""){
		doActionIBSheet(SEARCH);
	}
	
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];

	var frm = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn1_Retrieve":
				doActionIBSheet(SEARCH);
				break;
	
			case "btn1_New":
				ComResetAll();
				//ComSetObjValue(frm.area, area_cd);
				break;
			case "btn1_Print":
				rdObjects[0].PrintDialog(); //인쇄 시작
				break;
			
		} // end switch
	} catch (e) {
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
 
function setrdObject(rd_obj){
	rdObjects[rdCnt++] = rd_obj;	
}
     
/**
 * Form 이벤트 등록
 **/
function initControl() {
	axon_event.addListenerForm('keypress',        'obj_keypress', frm);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	axon_event.addListenerForm('keyup',			   'obj_keyup', frm); 
	axon_event.addListenerForm('click', 'obj_focus', frm);
}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
**/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
			if (location.hostname != "") {
				InitHostInfo(location.hostname, location.port, page_path);
			}
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "";

			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
         
          //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
          InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
		}//end of with
		break;
	}// end of switch
}
//focus in
function obj_activate(){
	obj = event.srcElement;
	//readonly 일때 데이터 포맷 변경되는 것  방지
	if (obj.getAttribute("readOnly")) return;
	ComClearSeparator(obj);
} 

// focus out
function obj_deactivate(){
	obj = event.srcElement;
	
	ComChkObjValid(obj);
	if (ComIsNull(obj.value)) {
		return;
	}
}

/**
 * HTML Control KeyPress 이벤트 호출
 **/
function obj_keypress() {

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
            ComKeyOnlyAlphabet(); 
            break;
        case "engup":
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
            else ComKeyOnlyAlphabet('lower');
            break;
   }// end of switch
}
/**
 * HTML Control KeyUp 이벤트 호출
 **/
function obj_keyup() {
	 if ((event.keyCode >= 37 && event.keyCode <= 40)|| (event.keyCode == 16)) return;
	 switch (event.srcElement.name) {
		case "cgo_clm_no":
			ComKeyOnlyAlphabet('uppernum');
			if (frm.cgo_clm_no.value.length == 10) {
				doActionIBSheet(SEARCH);
			}
			break;
	}//end of switch
}

 /**
  * HTML Control Click 이벤트 호출
  */
 function obj_focus() {
     switch (event.srcElement.name) {  
 		//Before /After 선택시
 		case "status":
 			
 			if (frm.cgo_clm_no.value.length == 10) { 
 			    doActionIBSheet(SEARCH);
 			}else {
	 			if(frm.status[0].checked == true){
	 				initRdConfig(rdObjects[0],"CPS_CNI_0062_01.mrd");
	 			}else{
	 				initRdConfig(rdObjects[0],"CPS_CNI_0062_02.mrd");
	 			}
 			}	
 		break;

 	}
 }

 
// Sheet관련 프로세스 처리
function doActionIBSheet(sAction) {
	frm.f_cmd.value = sAction;
	switch (sAction) {
		case SEARCH: // Retrieve
			if (validateForm(sAction)) {
				var status = ComGetObjValue(frm.status);
				var reportFileName = "CPS_CNI_0062_01.mrd";
				if (status == "A"){
				   reportFileName = "CPS_CNI_0062_02.mrd";	
				}
				
				var sXml = sheet1.GetSearchXml("CPS_CNI_0006GS.do", FormQueryString(frm) );
				var list = SheetXml2ListMap(sXml);
				if (list.length == 0) {
					ComShowCodeMessage("CNI00013");
					ComSetObjValue(frm.area_cd, "");
					rdObjects[0].FileOpen(RD_path+ "apps/alps/cps/cni/containercargoclaimreport/containercargoclaimreport/report/" + reportFileName, "" );
					return;
				}
				var area_cd = ComGetEtcData(sXml,"AREA_CD");
				ComSetObjValue(frm.area_cd, area_cd);
				
				frm.f_cmd.value = PRINT;
				
				frm.com_mrdArguments.value = "";
				frm.com_mrdTitle.value = "";
				frm.com_mrdBodyTitle.value = "";
				
				var rf = "/rf [" + RDServerIP + "/CPS_CNI_0006_01.do]";
				var rpost =  "/rpost [" + FormQueryString(frm) + "]";
				var rpaper = "/rpaper [A4]";
				
				if (frm.usr_area.value == "A") {
					rpaper = "/rpaper [LETTER]";
				}
				
				var rv = "/rv ";
				
				frm.com_mrdArguments.value = rf + " " + rv + " " + rpost + " " + rpaper;
				frm.com_mrdTitle.value = "Cargo Claim Report";
				frm.com_mrdBodyTitle.value = "Cargo Claim Report";
			    //frm.com_mrdPath.value = "apps/alps/cps/cni/codemgt/codemgt/report/CPS_CNI_0084.mrd";
				frm.com_mrdPath.value = "";
				
				rdObjects[0].SetRData("");
				rdObjects[0].FileOpen(RD_path+ "apps/alps/cps/cni/containercargoclaimreport/containercargoclaimreport/report/" + reportFileName, rf + " " + rv + " " + rpost + " " + rpaper );
				
			}
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sAction) {
	var cgo_clm_no = ComGetObjValue(frm.cgo_clm_no);
	if (cgo_clm_no =="") {
		ComShowCodeMessage("CNI00003", "Claim No.");
		frm.cgo_clm_no.focus();
		return false;	
	}
	return true;
}
 
 /**
  * 페이지에 있는 RD Object를 로드한다. <br>
  * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
  * @param {rdObject} rdObject    RD Object
  **/
	function initRdConfig(rdObject, rdFileName){
	    var Rdviewer = rdObject ;
	    
		Rdviewer.AutoAdjust = false;
		Rdviewer.ViewShowMode(0);
		Rdviewer.style.height = 440;
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.setbackgroundcolor(255,255,255);
		var rpaper = "/rpaper [A4]";	
		Rdviewer.FileOpen(RDServerIP + "/apps/alps/cps/cni/containercargoclaimreport/containercargoclaimreport/report/" + rdFileName , rpaper );
			
	} 