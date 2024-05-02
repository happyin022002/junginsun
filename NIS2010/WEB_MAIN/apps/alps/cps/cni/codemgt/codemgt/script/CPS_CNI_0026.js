/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0026.js
 *@FileTitle : [CPS_CNI_0026] Main Code-Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
 * 2010.07.01 윤진영 CHM-201004242 Grid title변경 vender -> Refund/Vndr Code
=========================================================*/

/**
 * [CPS_CNI_0026] Main Code-Inquiry
 * @extends
 * @class Main Code Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0026() {
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
    
    //Form 이벤트 등록
    initControl();
    //claim party no가 존재하는경우 조회
    if (!ComIsNull(frm.clm_pty_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	
    
    frm.clm_pty_abbr_nm.focus();

}


/**
* Form 이벤트 등록
*/
function initControl() {
   //keypress
   axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
   axon_event.addListener ('keydown', 'keydownEnter', 'form');
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
			style.height = 330;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			MultiSelection = false;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|Code|Refund/Vndr Code|Name|Location|Register|RGOFC|Update|Tel|Tel|Fax|Fax|E-Mail|pty_rmk|clm_pty_no";

			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");            
			InitDataProperty(0, cnt++ , dtDataSeq,			50,		daCenter,	true,		"seq");			
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"clm_pty_abbr_nm",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			120,		daCenter,	true,		"vndr_seq",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,		"pty_nm",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,		"loc_cd",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"cre_usr_id",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"cre_ofc_cd",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"upd_dt",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,		"intl_phn_no",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,	true,		"phn_no",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,		"intl_fax_no",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,	true,		"fax_no",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			120,	daLeft,	true,		"pty_eml",			false,		"",				dfNone,		0,			true,		true);			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"pty_rmk");			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"clm_pty_no");
			break;		
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================
/**
 * Location 설정
 */
function setLocation(rowArray) { 
   frm.loc_cd.value = rowArray[0][3];
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
	
	switch (srcName) {	
		case "btn1_Retrieve":
			if (validForm()) {
				doActionIBSheet(SEARCHLIST01);
			}
			break;
	    case "btn1_New":
    		ComResetAll();
    		frm.clm_pty_abbr_nm.focus();
	        break;	
		case "btn1_Detail":
			var row = sheet1.SelectRow;			
			var clmPtyNo = sheet1.CellValue(row , "clm_pty_no");
			
			popupMainCodeView(clmPtyNo);
	        break;
		case "btn1_Print":	
			if (sheet1.RowCount < 1) {
				//msgs["CNI00024"] = "There is no data to print.";
				ComShowCodeMessage("CNI00024");
				frm.clm_pty_abbr_nm.focus();
				return;
			}			
			doActionIBSheet(PRINT);
	        break; 	
		case "btns_location":
			//공통팝업 Location호출
			popupLocation();
	        break;
		case "delt_flg":
			if (frm.delt_flg.checked) {
				doActionIBSheet(SEARCHLIST01);
			}
	        break;
	}

}

 
 /**
  * HTML Control KeyPress 이벤트 호출
  */
 function keypressFormat() {
  	var obj = event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
     switch (obj.name) {    
     case "clm_pty_abbr_nm":    
    	KeyOnlyUpper();
     	break;
     case "loc_cd":    
     	KeyOnlyUpper();
      	break;
     case "cre_ofc_cd":    
      	KeyOnlyUpper();
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
     case "clm_pty_abbr_nm":
		if (validForm() && frm.clm_pty_abbr_nm.value != "") {
				doActionIBSheet(SEARCHLIST01);
		}	    	
     	break;
     case "pty_nm":
 		if (validForm() && frm.pty_nm.value != "") {
 				doActionIBSheet(SEARCHLIST01);
 		}	    	
      	break;
     case "loc_cd":
 		if (validForm() && frm.loc_cd.value != "") {
 				doActionIBSheet(SEARCHLIST01);
 		}	  
 		break;
     case "cre_ofc_cd":
  		if (validForm() && frm.cre_ofc_cd.value != "") {
  				doActionIBSheet(SEARCHLIST01);
  		}
  		break;
     case "cre_usr_id":
  		if (validForm() && frm.cre_usr_id.value != "") {
  				doActionIBSheet(SEARCHLIST01);
  		}  		
      	break;
 	}	  
  }

   /**
   * 검색 폼 체크
   */   
   function validForm() {
	   var clm_pty_abbr_nm = frm.clm_pty_abbr_nm.value;			
	   if (!frm.delt_flg.checked && 
			ComIsNull(clm_pty_abbr_nm) && 
			ComIsNull(frm.pty_nm.value) &&
			ComIsNull(frm.cre_ofc_cd.value) &&
			ComIsNull(frm.cre_usr_id.value) ) {
			//msgs["CNI00009"] = "Please input {?msg1},";
			ComShowCodeMessage("CNI00009" , "Code or Name or Register or RGOFC");
			frm.clm_pty_abbr_nm.focus();
			return false;
		}	   
	   
		return true;
   }
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================

/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {
	var clmPtyNo = sheet1.CellValue(row , "clm_pty_no");
	popupMainCodeView(clmPtyNo);	
}


/**
* sheet1 OnClick후 이벤트
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnClick(sheet , row, col, value) {	
	var ptyRmk = sheet.CellValue(row , "pty_rmk");
	frm.pty_rmk.value = ptyRmk;
}



/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		
		frm.pty_rmk.value = "";		
		frm.f_cmd.value = SEARCHLIST01;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0026GS.do", FormQueryString(frm));
		sheet1.LoadSearchXml(sXml);
		
		if (sheet1.RowCount > 0) {
			frm.pty_rmk.value = sheet1.CellValue(1 , "pty_rmk");
		}
		
	} else if (sAction == PRINT) {
		frm.f_cmd.value = PRINT;
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0084.do]";
		var rpost =  "/rpost ["+FormQueryString(frm)+"]";
		var rpaper = "/rpaper [A4]";	
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		var rv = "";
		frm.com_mrdArguments.value = rf + " " + rpost +  " " + rpaper  ;
		frm.com_mrdTitle.value = "Main Code-Inquiry Print";
		frm.com_mrdBodyTitle.value = "Main Code-Inquiry";
		frm.com_mrdPath.value = "apps/alps/cps/cni/codemgt/codemgt/report/CPS_CNI_0084.mrd";
		var feature = "resizable=yes,width=1000,height=600"
		popupRd(1000,600);
	} 
}

