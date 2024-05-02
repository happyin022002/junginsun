/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0095.js
 *@FileTitle : [CPS_CNI_0095] Main Code-Popup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.03
 *@LastModifier : 이준범
 *@LastVersion : 1.0
 * 2010.12.03 이준범
 * 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2010.12.10 이준범 [CHM-201007236-01]
 * 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
 * 2.처리내역
 *  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
 *      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
 *      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완 
=========================================================*/

/**
 * [CPS_CNI_0095] Main Code-Popup
 * @extends
 * @class Main Code Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 *        
 *        
 *        
 */
function cps_cni_0095() {
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
    //if (!ComIsNull(frm.clm_pty_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    //}	

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

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|Code|Name|Location|Register|RGOFC|Update|Tel|Tel|Address|clm_pty_no";

			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");            
			InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,		"seq");			
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"clm_pty_abbr_nm",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,		"pty_nm",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,		"loc_cd",			false,		"",				dfNone,		0,			true,		true);			
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"cre_usr_id",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"cre_ofc_cd",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"upd_dt",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,		"intl_phn_no",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"phn_no",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			120,	daLeft,	    true,		"pty_addr",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		"clm_pty_no");
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
	    case "btn2_Save":
	    	opener.setMainCodePopup();
	    	self.close();	    	
	        break;
	    case "btn1_Close":
			self.close();
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
      case "pty_nm":
  		if (validForm() && frm.pty_nm.value != "") {
  				doActionIBSheet(SEARCHLIST01);
  		}	    	
       	break;       	
 	}	  
  }
   
   /**
   * 검색 폼 체크
   */   
   function validForm() {
//	   var clm_pty_abbr_nm = frm.clm_pty_abbr_nm.value;			
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
	if (row < 1) {
		return;
	}
	
	
	var partyVo = {
			clm_pty_no:sheet.CellValue(row , "clm_pty_no"),
			clm_pty_abbr_nm:sheet.CellValue(row , "clm_pty_abbr_nm"),
			pty_nm:sheet.CellValue(row , "pty_nm"),
			intl_phn_no:sheet.CellValue(row , "intl_phn_no"),
			phn_no:sheet.CellValue(row , "phn_no"),			
			loc_cd:sheet.CellValue(row , "loc_cd"),
			pty_eml:sheet.CellValue(row , "pty_eml")
	};
	
	opener.setMainViewPopup(partyVo);
	self.close();
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {	
	 
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value = SEARCHLIST01;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0095GS.do", FormQueryString(frm));
		sheet1.LoadSearchXml(sXml);
	} 
}

