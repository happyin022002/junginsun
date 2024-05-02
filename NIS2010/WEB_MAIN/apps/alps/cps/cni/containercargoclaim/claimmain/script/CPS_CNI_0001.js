/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0001.js
 *@FileTitle : [CPS_GEM_0001]  Client Default Setup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0001]Client Default Setup
 * 사용자가  시스템 최초 Log In하는 경우 지휘를 받는 Office의 지역 Code을 Setup하는 화면
 * @extends
 * @class Client Default Setup 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0001() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}



// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;


// html form
var frm = null;
// Main Code Inquiry 팝업 타입
var type = "";
// Area Name Array
var names = new Array();

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param {string} year 현재년도
 **/
function loadPage(year) {
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
 
    var xml = frm.sXml.value;    
	var list = SheetXml2ListMap(xml);
	var combo = frm.clm_area_cd;
	var clmAreaCd = frm.clmAreaCd.value;
	for(var i = 0 ; i < list.length; i++) {
		var code = list[i];
		ComAddComboItem(combo ,code["code"] , code["code"]);
		names[i] = code["name"];
	}
	
	if (ComIsNull(clmAreaCd)) {		 
		frm.clm_area_nm.value = names[0];
	} else {
		combo.value = clmAreaCd;
		frm.clm_area_nm.value = names[combo.selectedIndex];
	}
	
}


/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			break;		
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================

// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {	 	
		case "btn1_Save":
			//msgs["CNI00012"] = "Data was changed. Do you want to save it?";
			if (ComShowCodeConfirm("CNI00012")) {
				doActionIBSheet(MULTI);
			} 
			break;	        
		case "btn1_Close":			
			self.close(); 
	        break;	  
		case "btn1_Test":			
			popupClientDefaultSetup();
	        break;	  
	        
	        
	}

}

/**
* Area변경시 코드명 설정 
*/
function onchangeClmAreaCd() {	
	var combo = frm.clm_area_cd;	
	frm.clm_area_nm.value = names[combo.selectedIndex];
}

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {	
	if (sAction == MULTI) {		
		frm.f_cmd.value = MULTI;		
		var param = "f_cmd=" + MULTI;
		param += "&" + FormQueryString(frm);
		var sXml = sheet1.GetSearchXml("CPS_CNI_0001GS.do", param);		
		sheet1.LoadSearchXml(sXml);				
	}
}

