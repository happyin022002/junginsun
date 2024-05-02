/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0042.js
 *@FileTitle : [CPS_CNI_0042]  CCC VVD & SKD Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0042]  CCC VVD & SKD Inquiry
 * @extends
 * @class  CCC VVD & SKD Inquiry 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0042() {
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
var locType = "";

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
    
    var trnk_ref_vvd_no = frm.trnk_ref_vvd_no.value;
   
    if (!ComIsNull(trnk_ref_vvd_no) && trnk_ref_vvd_no.length == 9) {
    	doActionIBSheet(SEARCHLIST01);
    } 
    
    frm.trnk_ref_vvd_no.focus();
    
    
}


/**
* Form 이벤트 등록
*/
function initControl() {
   //keypress
   axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
   axon_event.addListener ('keyup', 'keyup', "form");
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
			style.height = 282;
								
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

			var HeadTitle1 = "Seq.|Lane|VVD|POL|CCT|ETD|POD|ETB";
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtDataSeq,			40,		daCenter,	true,		"seq");
			InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,		"slan_cd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	70,	daCenter,		true,		"vvd",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,		"pol",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	130,	daCenter,		true,		"cct",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	130,	daCenter,	true,		"vps_etd_dt",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	50,	daCenter,		true,		"pod",	false,  "",	dfNone,		0,	true,		true);
			InitDataProperty(0, cnt++ , dtData,	120,	daCenter,		true,		"vps_etb_dt",	false,  "",	dfNone,		0,	true,		true);
			
			break;		
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================


/**
 * VVD 설정
 */
 function setVVD(rowArray) {
	 var vvd = rowArray[0][7];
	 frm.vsl_cd.value = vvd.substring(0,4);
	 frm.skd_voy_no.value = vvd.substring(4,8);
	 frm.skd_dir_cd.value = vvd.substring(8,9);
	 doActionIBSheet(SEARCHLIST01);
 }

 /**
  * Location 설정
  */
 function setLocation(rowArray) { 
	if (locType == "pod") {
		frm.pod.value = rowArray[0][3];
	}
	
	if (locType == "pol") {
		frm.pol.value = rowArray[0][3];
	}
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
	        break;
	    case "btn1_Select":
	    	var row = sheet1.SelectRow;	    		    	
	    	if (sheet1.RowCount == 0 || row  < 1) {
	    		return;
	    	}	    	
	    	var vvdSkdVo = {
	    			slan_cd:sheet1.CellValue(row , "slan_cd"),
	    			vvd:sheet1.CellValue(row , "vvd"),
	    			pol:sheet1.CellValue(row , "pol"),
	    			pod:sheet1.CellValue(row , "pod"),
	    			cct:sheet1.CellValue(row , "cct"),			
	    			vps_etd_dt:sheet1.CellValue(row , "vps_etd_dt"),
	    			vps_etb_dt:sheet1.CellValue(row, "vps_etb_dt")	    			
	    	};	    	
	    	opener.setVvdSkd(vvdSkdVo);   	
	    	self.close();	    	
	        break;
	    case "btn1_Close":	    	
			self.close();
	        break;
	    case "btns_vvd":
	    	popupVVD();
	        break;
	    case "btns_pol":
	    	locType = "pol";
	    	popupLocation();
	        break;	        
	    case "btns_pod":
	    	locType = "pod";
	    	popupLocation();
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
     case "trnk_ref_vvd_no":    
    	 ComKeyOnlyAlphabet('uppernum');
    	 break;
     case "pol":
     case "pod":
    	 ComKeyOnlyAlphabet('upper');     	
      	break;     	
 	}
 }
   
  
  /**
   * HTML Control Keyup 이벤트 호출
   */
  function keyup() {  	 
  	 var obj = event.srcElement;
     switch (obj.name) {   
     case "trnk_ref_vvd_no":
    	 if (obj.value.length == 9 || (event.keyCode == 13 && validForm()) ) {    	  	
    		 doActionIBSheet(SEARCHLIST01);  
    	 }
    	 break;
     case "pol":	 
     case "pod":
    	 if (obj.value.length > 0) {
    	  	 if (event.keyCode == 13 && validForm()) {
    	  		 doActionIBSheet(SEARCHLIST01);
    	  	 }
    	 }
    	 break;    	 
     }
  }
  
   /**
   * 검색 폼 체크
   */   
   function validForm() {
	   return ComChkValid(frm);
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
	
	var vvdSkdVo = {
			slan_cd:sheet.CellValue(row , "slan_cd"),
			vvd:sheet.CellValue(row , "vvd"),
			pol:sheet.CellValue(row , "pol"),
			pod:sheet.CellValue(row , "pod"),
			cct:sheet.CellValue(row , "cct"),			
			vps_etd_dt:sheet.CellValue(row , "vps_etd_dt"),
			vps_etb_dt:sheet.CellValue(row, "vps_etb_dt")
	};
	
	opener.setVvdSkd(vvdSkdVo);
	self.close();
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value = SEARCHLIST01;
		var trnk_ref_vvd_no = frm.trnk_ref_vvd_no.value;
		frm.vsl_cd.value = trnk_ref_vvd_no.substring(0,4);
		frm.skd_voy_no.value = trnk_ref_vvd_no.substring(4,8);
		frm.skd_dir_cd.value = trnk_ref_vvd_no.substring(8,9);		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0042GS.do", FormQueryString(frm));
		sheet1.LoadSearchXml(sXml);
	} 
}

