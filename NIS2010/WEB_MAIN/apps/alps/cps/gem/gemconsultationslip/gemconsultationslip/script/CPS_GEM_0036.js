/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_GEM_0036.js
 *@FileTitle : [CPS_GEM_0036] Authorized Expense Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM_0036] Authorized Expense Code
 * @extends
 * @class Authorized Expense Code생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_GEM_0036() {
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

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// IBMultiCombo
var comboObjects = new Array();
var combo1 = null
var comboCnt = 0;

// html form
var frm = null;


/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
 **/
function setComboObject(combo_obj){
   comboObjects[comboCnt++] = combo_obj;
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
    frm = document.form;
    
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
   
    combo1 = comboObjects[0]
    comboCnt = comboObjects.length;
    
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    //IBMultiCombo초기화
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k]);
    }
    
    
    //Form 이벤트 등록
    initControl();

}

/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.MultiSelect = true;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ","; 
	comboObj.DropHeight = 240;
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

            // 높이 설정
            style.height = 260;
            
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 18, 100);
   
			var HeadTitle1 = "Seq.|CSR No.|Office|Input Date|Invoice Date|Expense Type|Approval Status|Currency|Inv Amount|USD Amount|Creator";
            var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false)

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]			
			InitDataProperty(0, cnt++ , dtSeq,			70,		daCenter,	true,		"seq",			    false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,		"subs_csr_no",	    false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"subs_ofc_cd",	    false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"inp_dt",		    false,		"",			dfNone,		0,			false,		false);						
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"inv_dt",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	true,		"expn_div_cd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"apro_rslt_cd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"inv_curr_cd",		false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"inv_locl_ttl_amt",	false,		"",			dfFloat,	2,			false,		false);						
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"inv_usd_ttl_amt",	false,		"",			dfFloat,	2,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cre_usr_id",		false,		"",			dfNone,		0,			false,		false);
			break;
		}
		
	}
}


// ===================================================================================
// Private function
// ===================================================================================
 /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
function validateForm(sAction){
	var formObj = document.form;
		if(sAction == SEARCHLIST){
			if(formObj.period_stdt.value ==""){
				ComShowCodeMessage("GEM00009","Input Date");
				formObj.period_stdt.focus();
	    		return false;
			}
		
			if(formObj.period_eddt.value ==""){
				ComShowCodeMessage("GEM00009","Input Date");
				formObj.period_eddt.focus();
	    		return false;
			}
		}
	return true;
	
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
	var formObject = document.form;
	
	switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(SEARCHLIST);
			break;
		case "btn_Select":
			
			//선택된 행번호 
			var arrRow = sheet1.SelectRow;
			
			if (arrRow != null) {
				var csr_no = sheet1.CellValue(arrRow, "subs_csr_no");
				opener.setCsrNo(csr_no);		
				self.close();
				
			} else {
				//msgs['COM12114'] = 'Please check {?msg1}';
				ComShowCodeMessage("COM12114" , "CSR No.");	
			}
			break;
		case "btn_Close":
			self.close();
			break;
		case "btns_calendar2":
			var cal = new ComCalendarFromTo();
		    	cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM-dd');
			break;
	} 
}



/**
 * Form 이벤트 등록
 */
function initControl() {
	//key up
	axon_event.addListenerForm('keyup', 'obj_keyup', frm);
    //keypress
    axon_event.addListenerForm('keypress', 'obj_keypress', frm);
    // focus out
    axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
    axon_event.addListenerFormat('focus',   'obj_activate',    frm);    
}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {
	
    switch (event.srcElement.name) {    
    case "gen_expn_cd":
		ComKeyOnlyNumber(event.srcElement);
		break;  
    }
}

 /**
  * HTML Control KeyPress 이벤트 호출
  */
 function obj_keypress() { 	
     switch (event.srcElement.name) {    
     case "gen_expn_cd":
    	 
 		if (event.srcElement.value.length == 6 && 
 				event.keyCode == 13) {
 			doActionIBSheet(SEARCHLIST);
 		}
 		break;  
     }
 }

    
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {
	switch (event.srcElement.name) {
	case "gen_expn_cd":
		ComChkObjValid(event.srcElement);
		break;
	default:
		ComChkObjValid(event.srcElement);
	}
}
 


/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}


function sheet1_OnLoadFinish(sheetObj) {
    // 초기Data조회
	var formObject = document.form;
	doActionIBSheet(SEARCHLIST20);
	doActionIBSheet(IBSEARCH_ASYNC01);
	
	}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	 var formObj = document.form;
	//[Retrieve]
	if (sAction == SEARCHLIST) {
		if(!validateForm(sAction)) return;
		frm.f_cmd.value = SEARCH;
		var sXml = sheet1.GetSearchXml("CPS_GEM_0036GS.do", FormQueryString(frm));	
		sheet1.LoadSearchXml(sXml);		
	//[open]	 	
	} else if (sAction == IBSEARCH_ASYNC01) {  
    	formObj.f_cmd.value = SEARCH;
		var sXml = sheet1.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(formObj));

		var arrXml = sXml.split("|$$|");
		var authFlg  = "";
		
		// 로그인 오피스 정보 
		if (arrXml.length > 0) {			
			var list = ComXml2ListMap(arrXml[0]);
			var officeLevelVo  = list[0];
			var loginOfcCd = ComGetEtcData(arrXml[0] ,"usr_ofc_cd");
		
			authFlg  = officeLevelVo["auth_flg"];
			//권한 설정
		formObj.auth_flg.value = authFlg;
		formObj.login_ofc_cd.value = loginOfcCd;
			
		}
		// 권한 없는 Office 가 로그인 시 화면 닫음
		if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
			goNoAuthority();
	    }

		// 실적을 입력할 년월
		if (arrXml.length > 0) {
			
			var closingDate = ComGetEtcData(arrXml[0] ,"closingDate");
			
		    formObj.pln_yr.value = closingDate.substring(0,4);
			formObj.pln_mon.value = closingDate.substring(4,6);
			
			formObj.hpln_yr.value = closingDate.substring(0,4);
			formObj.hpln_mon.value = closingDate.substring(4,6);
			
		}		

		// 로그인 사용자 오피스 정보
		if (arrXml.length > 1) {

			var list = ComXml2ListMap(arrXml[1]);

			if(list.length > 0){
				var officeHierarchyVO  = list[0];
				var level1   = officeHierarchyVO["level1"];
				var level2   = officeHierarchyVO["level2"];
				var level3   = officeHierarchyVO["level3"];
				var level4   = officeHierarchyVO["level4"];
				var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
				if ("N" == rgnOfcFlg) {
					formObj.sls_ofc_div_cd[0].checked = true;
				} else {
					formObj.sls_ofc_div_cd[1].checked = true;
				}
				//집행단위.지역그룹
				if ( authFlg == "YNNN" || authFlg == "YYNN" ) {
					ComEnableObject(formObj.ofc_lvl1, false);
					ComEnableObject(formObj.ofc_lvl2, false);
					ComEnableObject(formObj.ofc_lvl3, false);
					if ( authFlg == "YYNN" ) {
						ComEnableObject(formObj.ofc_lvl3, true);
					}
					formObj.sls_ofc_div_cd[0].disabled=true;
					formObj.sls_ofc_div_cd[1].disabled=true;
					//LV1
					ComSetObjValue(formObj.ofc_lvl1,level2);					
					//LV2
					selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');			
					ComSetObjValue(formObj.ofc_lvl2,level3);					
					//LV3
					selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');			
					ComSetObjValue(formObj.ofc_lvl3,level4);					
									
				//사무국 , BU ,TIC
				} else if ( authFlg == "YNYN" || authFlg == "YNYY" || authFlg == "YYYN") {
					ComEnableObject(formObj.ofc_lvl1, true);
					ComEnableObject(formObj.ofc_lvl2, true);
					ComEnableObject(formObj.ofc_lvl3, true);				
					formObj.sls_ofc_div_cd[0].checked = false;
					formObj.sls_ofc_div_cd[1].checked = false;
					
					if ( authFlg == "YNYY")
					{
						if ( formObj.usr_auth_tp_cd.value != USR_AUTH_TP_CD ) {
							authFlg = "YNYN";
							formObj.auth_flg.value = authFlg;
						} 							
					}
					
				} else {
					ComEnableObject(formObj.ofc_lvl1, false);
					ComEnableObject(formObj.ofc_lvl2, false);
					ComEnableObject(formObj.ofc_lvl3, false);		
					formObj.sls_ofc_div_cd[0].disabled=true;
					formObj.sls_ofc_div_cd[1].disabled=true;
				}
			}
		}	

     }else if (sAction == SEARCHLIST20){
         // 조회
    		formObj.f_cmd.value = SEARCH;
    		
    		var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(formObj));
    		
    		// LEVEL2 조회
    		var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
    		
    		if (typeof comboListData != "undefined" && comboListData != "") {
    			
    			var ofcLvl = formObj.ofc_lvl1;
    			ofcLvl.length = 0;
    			ComAddComboItem(ofcLvl, "", "");
    			
    			for ( var i = 0; i < comboListData.length; i++) {
    				ComAddComboItem(ofcLvl, comboListData[i], comboListData[i]);
    			}
    		}
     }
	

}
 
/**
 * HO, HQ 체크 박스 설정 
 * @param {value} 선택된 체크 박스구분
 */
 function setHOHQ01(value) {
	 var frm = document.form;
 	var c1 = frm.sls_ofc_div_cd[0].checked;
 	var c2 = frm.sls_ofc_div_cd[1].checked;	

 	if ( c1 && c2 ) {
 		
 		if (value == "HO") {
		frm.sls_ofc_div_cd[1].checked = false;
	} else if (value == "HQ") {
 			frm.sls_ofc_div_cd[0].checked = false;
 		}
 		isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');
 	}
 	if ( !c1 && !c2 ) {
 		ComSetObjValue(frm.ofc_lvl1,"");
 		ComSetObjValue(frm.ofc_lvl2,"");
 		ComSetObjValue(frm.ofc_lvl3,"");
 	}

 } 

 

  
 
