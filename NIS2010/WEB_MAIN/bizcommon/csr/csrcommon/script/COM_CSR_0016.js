/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : COM_CSR_0016.js
 *@FileTitle : [COM_CSR_0016] CSR Approval Type Selection
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.06
 *@LastModifier : SY SHIM
 *@LastVersion : 1.0
 * 2016.01.06 SY SHIM
 * 1.0 Creation
=========================================================*/


/**
 * [COM_CSR_0016] CSR Approval Type Selection
 * @extends
 * @class 집행단위에서 수립한 비용계획에 대한 Rquest Number 를 조회한다.
 */
function COM_CSR_0016() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}

// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================

// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// html form
var formObj = null;
var aproTpCd = "";

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
 **/
function loadPage() {
    //전역 변수 설정 
    formObj = document.form;
    axon_event.addListenerForm  ('click'	   , 'obj_onclick'   , 	formObj); //라디오 버튼
    
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
    
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    aproTpCd = 'AL'
    formObj.apro_tp_cd.value = aproTpCd;
}

/**
 * 시트 초기설정값, 헤더 정의
 * @param {ibsheet} sheetObj  sheet
 * @param {int} sheetNo 시트번호
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    switch(sheetNo) {
        case 1:   //t1sheet1 init
            with (sheetObj) {

                style.height=GetSheetHeight(10);
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1 , 5, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(1, 0, 0, true);

            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
            	InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = "";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,        80,    daLeft,  false,    "",     false,          "",       dfNone,   		0,     false,      false, 3);
			}
            break;
	}
}

/**
 * AXON 이벤트 처리
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}

/**
 * Radio 클릭시 이벤트 관련
 * 
 */
function obj_onclick(){
	var obj	 = event.srcElement;
	if ( obj.name == "apro_tp_cd" ) {
		aproTpCd = ComGetObjValue(obj);
		formObj.apro_tp_cd.value = aproTpCd;
	}
}


// ===================================================================================
// Private function
// ===================================================================================
 /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
function validateForm(formObj){
	
	var rtnVal = true;
	if(ComTrimAll(formObj.apro_tp_cd.value) == ""){
		showErrMessage(getMsg('CSR25038')); //Please select Approval Type.
		rtnVal = false;
	}
	if(ComTrimAll(formObj.csr_no.value) == ""){
		showErrMessage(getMsg('CSR25039'));//There is no CSR No.
		rtnVal = false;
	}
	return rtnVal;
	
}

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
	var aproTpCd = formObj.apro_tp_cd.value;
	
	switch (srcName) {
	case "btn1_Select":
		if(!validateForm(formObj)) {
	        return false;
	    }else{
			doActionIBSheet(MULTI01);
			self.close();
		}
		break;
	} 
}

 


/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	switch(sAction) {
	case MULTI01:        //
		formObj.f_cmd.value = MULTI;
		var f_cmd = formObj.f_cmd.value;
		var csrNo = formObj.csr_no.value;
		
    	var param = "f_cmd="+f_cmd+"&csr_no="+csrNo+"&apro_tp_cd="+aproTpCd;
		var sXml = sheet1.GetSaveXml("COM_CSR_0016GS.do", param);
		break;
	}
 	
}
 
 

 
