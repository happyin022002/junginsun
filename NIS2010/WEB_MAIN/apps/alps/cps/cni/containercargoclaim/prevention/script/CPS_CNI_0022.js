/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0022.js
 *@FileTitle : [CPS_CNI_0022] Prevention
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0022] Prevention
 * @extends
 * @class Prevention 대상 검색 및 금액 입력화면
 */
function cps_cni_0022() {
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

//IBmultiCombo
var comboObjects = new Array();
var comboCnt = 0;
var combo1 = null;
// html form
var frm = null;
// Main Code Inquiry 팝업 타입
var type = "";

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


/*
 * IBCombo Object를 배열에 등록
 * @param comboObj
 */
function setComboObject(comboObj){
	comboObjects[comboCnt++] = comboObj;
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
    
    combo1 = comboObjects[0];
	// IBMultiCombo초기화
	comboCnt = comboObjects.length;	
	for (var j=0; j<comboCnt; j++) {
		initCombo(comboObjects[j]);
	}    
    
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    //Form 이벤트 등록
    initControl();
    
    var sXml = frm.sXml.value;    
    
    var arrXml = sXml.split("|$$|");
    
	var arr = SheetXml2ListMap(arrXml[0]);
	
	combo1.InsertItem(0,"ALL","ALL");		
	var k = 1;
	for(var i=0 ; i < arr.length ; i++ ) {			
		var code = arr[i];
		// 읽기 사용자는 CCC리스트 제외 
		if (code["code"] == "C" ) {
			if (equalsRole("CNI42") || equalsRole("CNI41") || equalsRole("CNI93")) {					
				combo1.InsertItem( k ,code["name"],code["code"]);
				k++
			}
		} else {				
			combo1.InsertItem( k ,code["name"],code["code"]);
			k++
		} 
		
	}		
	
	combo1.Code = "ALL";	    
    
	var list = SheetXml2ListMap(arrXml[1]);
	
	var combo = frm.clm_area_cd;		
	ComAddComboItem(combo ,"ALL" , "");	
	
	for(var i = 0 ; i < list.length; i++) {
		var code = list[i];
		ComAddComboItem(combo ,code["code"] , code["code"]);		
	}
	

	ComBtnDisable("btn1_Delete");
	
	//초기 focus();
	frm.cond_search_text.focus();
	
	doActionIBSheet(SEARCHLIST01);	
}


/**
* Form 이벤트 등록
*/
function initControl() {

	axon_event.addListener ('keydown', 'keydownEnter', 'form');
	// focus out
    axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
    axon_event.addListenerFormat('focus',   'obj_activate',    frm);
}


/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
**/
function initCombo(comboObj) {
	with (comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 190;
	    comboObj.BackColor = "#FFFFFF";
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

            // 높이 설정
			style.height = 250;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|Class|PRV No.|Subject|DORG|A|RGOFC|Register|Att.|View|";

			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
            
			InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,		"seq",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"clm_prve_div_nm",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,		"clm_prve_no",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			360,	daLeft,		true,		"clm_prve_subj_nm",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cre_dt",			false,		"",				dfDateYmd,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"clm_area_cd",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cre_ofc_cd",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cre_usr_id",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtImage,		    50,		daCenter,	true,		"file_cnt",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,		    20,		daCenter,	true,		"clm_prve_read_knt",			false,		"",				dfInteger,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"clm_prve_desc");
            ImageList(0)= "img/ico_attach.gif";
            InitViewFormat(0, "cre_dt", "yyyy-mm-dd");
            ShowButtonImage = 1;
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
	    case "btn2_Search":
		case "btn1_Retrieve":
			if (ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST01);			
			}
			break;
		case "btns_cre_dt_start":			
			var vCal = new ComCalendar();
			vCal.setDisplayType("date");
			vCal.select(frm.cre_dt_start, "yyyy-MM-dd");			
			break;
		case "btns_cre_dt_end":
			var vCal = new ComCalendar();
			vCal.setDisplayType("date");
			vCal.select(frm.cre_dt_end, "yyyy-MM-dd");
			break;
		case "btng_plus":
			popupPreventionRegister("");
			break;
		case "btn1_New":
			ComResetAll();
			combo1.Code = "ALL";
			break;			
		case "btn1_Delete":
			
			// msgs["CNI00018"] = "Please select {?msg1}";
			if (sheet1.SelectRow < 1) {			
				ComShowCodeMessage("CNI00013" , "row");
				return;
			}
			// msgs["CNI00016"] = "Do you want to delete it?";
			if (ComShowCodeConfirm("CNI00016")) {
				doActionIBSheet(REMOVE);
			}
			
			break;
	}

}



 
  
 
 
 /**
  * HTML Control KeyDown 이벤트 호출
  */
 function keydownEnter() {
 	 
 	if (event.keyCode != 13) {
 		return;
 	}
 	 
 	var obj = event.srcElement;
    switch (obj.name) {    
    case "cre_ofc_cd":
    case "cre_usr_id":    	
    case "cond_search_text":    	
    	if (obj == null || 
    			obj.value.length < 1 ) {
    		return;
    	}

		doActionIBSheet(SEARCHLIST01);
		
		focusOut();

    	break;       
    	
	}	  
 } 

  
  /**
   * HTML Control Foucs in
   */
  function obj_activate(){
      ComClearSeparator(event.srcElement);    
  }
  
  /**
   * HTML Control Focus out
   **/
  function obj_deactivate() {
  	switch (event.srcElement.name) {
  	case "cre_dt_start":  		
  	case "cre_dt_end":  		
  		ComChkObjValid(event.srcElement);
  		break;
  	}
  }  
  
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
function combo1_OnChange(comboObj,IndexCode, Text) {  		
	doActionIBSheet(SEARCHLIST01);
} 

/**
* sheet1 OnClick후 이벤트
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnClick(sheet , row, col, value) {	
	var clm_prve_desc = sheet.CellValue(row , "clm_prve_desc");
	frm.clm_prve_desc.value = clm_prve_desc;
	var creUsrId = sheet.CellValue(row, "cre_usr_id");	
	setRollBtnCtlPrevention(creUsrId, "btn1_Delete");
} 


/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {	
	if (row < 1) {
		return;
	}	
	var clmPrveNo = sheet.CellValue(row, "clm_prve_no");
	var creUsrId = sheet.CellValue(row, "cre_usr_id");
	var usrId = frm.usr_id.value;
	if (!ComIsNull(clmPrveNo)) {
		
		setRollBtnCtlPrevention(creUsrId, "btn1_Delete");
		
		if (usrId == creUsrId || equalsRole("42") || equalsRole("93")) {				
			popupPreventionRegister(clmPrveNo);	
		} else {
			popupPreventionView(clmPrveNo);
				
		}
	}
	

}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	
	if (sAction == SEARCHLIST01) {		
		
		frm.f_cmd.value = SEARCHLIST01;
		//이전선택 내용 삭제
		frm.clm_prve_desc.value = "";
		
		var cls = combo1.Code;
		
		if (cls == "ALL") {
			cls = "";
		}
		frm.clm_prve_div_cd.value = cls;
		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0022GS.do", FormQueryString(frm));
		sheet1.LoadSearchXml4Sax(sXml);	
		
		sheet1.SelectRow = 0;
		
	} else if(sAction == REMOVE) {
		var param = "f_cmd="+REMOVE+"&clm_prve_no=" + sheet1.CellValue(sheet1.SelectRow,"clm_prve_no");
		var sXml = sheet1.GetSearchXml("CPS_CNI_0023GS.do", param);
		sheet1.LoadSearchXml(sXml);
		doActionIBSheet(SEARCHLIST01);
		
	}
		

}

