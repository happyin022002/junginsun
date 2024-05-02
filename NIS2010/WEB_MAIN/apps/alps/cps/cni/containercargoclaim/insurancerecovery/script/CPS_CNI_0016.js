/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0016.js
 *@FileTitle : [CPS_GEM_0016] Insurance Recovery by VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0016] Insurance Recovery by VVD
 * @extends
 * @class Insurance Recovery by VVD 대상 검색 및 금액 입력화면
 */
function cps_cni_0016() {
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
    if (!ComIsNull(frm.trnk_ref_vvd_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	

    
    // ==================================
    // 본사관리자 만 관리 
    // ==================================
	ComBtnDisable("btn1_Save");
	ComBtnDisable("btn1_FileUpload");  
	
    if (equalsRole("03") || equalsRole("93")) {
    	ComBtnEnable("btn1_Save");
    	ComBtnEnable("btn1_FileUpload");
    }     
    
    frm.trnk_ref_vvd_no.focus();
}


/**
* Form 이벤트 등록
*/
function initControl() {
	axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
	axon_event.addListener ('keyup', 'keyupTrnkRefVvdNo', 'trnk_ref_vvd_no');
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
			style.height = 440;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 100);
			// hidden title
			var HeadTitleHidden = "|cgo_clm_stl_locl_curr_cd|cgo_clm_stl_xch_rt|clm_area_cd|hdlr_ofc_cd|hdlr_usr_id";
			var HeadTitle1 = "|Seq.|STS|Claim No.|Claimed (USD)|Claimed (USD)|Settled (USD)|Settled (USD)|LP Recovered Amount (USD)|LP Recovered Amount (USD)|Net Settled\nAmount(USD)|INS Claimed (USD)|INS Claimed (USD)|INS Recovered (USD)|INS Recovered (USD)" + HeadTitleHidden ;
			var HeadTitle2 = "|Seq.|STS|Claim No.|Amount|DOF|Amount|DOS|Amount|LP DOR|Net Settled\nAmount(USD)|Amount|INS DOF|Amount|INS DOR"  + HeadTitleHidden ;
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, false, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");            
            InitDataProperty(0, cnt++ , dtData,		    45,		daCenter,	true,		"data_seq",			false,		"",				dfNone,		0,			false,		false);            
            InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"cgo_clm_sts_cd",			false,		"",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cgo_clm_no",			false,		"",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		90,		daRight,	true,		"clmt_usd_amt",			false,		"",				 dfFloat,		2,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	true,		"fmal_clm_rcv_dt",			false,		"",				dfDateYmd,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		90,	    daRight,	true,		"cgo_clm_stl_usd_amt",			false,		"",				 dfFloat,		2,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,	    daCenter,	true,		"cgo_clm_stl_dt",			false,		"",				dfDateYmd,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		97,	    daRight,	true,		"labl_pty_rcvr_usd_amt",			false,		"",				 dfFloat,		2,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			77,	    daCenter,	true,		"labl_pty_rcvr_dt",			false,		"",				dfDateYmd,		0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,		120,	daRight,	true,	"rcvr_usd_amt",			false,		"",				 dfFloat,		2,			true,		true);
			
			InitDataProperty(0, cnt++ , dtAutoSum,		90,	daRight,	true,		"insur_dmnd_usd_amt",			false,		"",				 dfFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,		"insur_fmal_clm_dt",			false,		"",				dfDateYmd,		0,			true,		true);
			
			
			InitDataProperty(0, cnt++ , dtAutoSum,		90,	daRight,	true,		"insur_rcvr_usd_amt",			false,		"",				 dfFloat,		2,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,		"insur_rcvr_dt",			false,		"",				dfDateYmd,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,		"cgo_clm_stl_locl_curr_cd",			false,		"",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,		"cgo_clm_stl_xch_rt",			false,		"",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,		"clm_area_cd",			false,		"",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,		"hdlr_ofc_cd",			false,		"",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,		"hdlr_usr_id",			false,		"",				dfNone,		0,			false,		false);
			InitViewFormat(0, "fmal_clm_rcv_dt", "yyyy-mm-dd");
			InitViewFormat(0, "cgo_clm_stl_dt", "yyyy-mm-dd");
			InitViewFormat(0, "insur_fmal_clm_dt", "yyyy-mm-dd");
			InitViewFormat(0, "insur_rcvr_dt", "yyyy-mm-dd");
		
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
		case "btn1_Retrieve":
			
			if(ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST01);
			}
			
			break;	
	    case "btn1_New":
	    	//msgs["CNI00015"] = "Do you want to initialize?";
	    	if (ComShowCodeConfirm("CNI00015")) {
	    		ComResetAll();
	    		frm.trnk_ref_vvd_no.value = "";
	    	}	    	
	        break;	
		case "btn1_Save":
			frm.f_cmd.value = MULTI;		
			if(ComChkValid(frm)) {
				//CNI00012(Do you want to save changes?)
				if (ComShowCodeConfirm("CNI00012")) {
					doActionIBSheet(MULTI);
				}
			}			
	        break;
		case "btn1_FileUpload":
			
			var trnkRefVvdNo = frm.trnk_ref_vvd_no.value;
			if (ComIsNull(trnkRefVvdNo) || trnkRefVvdNo.length != 9) {
				//msgs["CNI00009"] = "Please input {?msg1},";
				ComShowCodeMessage("CNI00009" , "VVD");
				return;
			}
			
			popupFileUpload("001601" ,trnkRefVvdNo);
			
	        break;	    	        
		case "btn1_close":
			self.close();
	        break;	  	        
		case "btn1_Print":
			if (sheet1.RowCount < 1) {
				//msgs["CNI00024"] = "There is no data to print.";
				ComShowCodeMessage("CNI00024");
				frm.trnk_ref_vvd_no.focus();
				return;
			}			
			
			doActionIBSheet(PRINT);
	        break; 		        
	}

}


/**
 * HTML Control KeyPress 이벤트 호출
 */
function keypressFormat() {
	if (event.keyCode >= 37 && event.keyCode <= 40) return;
 	var obj = event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;
    switch (obj.name) {    
    case "trnk_ref_vvd_no":    
    	KeyOnlyUpper();
    	break;
	}
}

 /**
  * HTML Control KeyPress 이벤트 호출
  */
 function keyupTrnkRefVvdNo() {
  	var obj = event.srcElement;
     switch (obj.name) {    
     case "trnk_ref_vvd_no":    
     	if(obj.value.length == 9) {
			doActionIBSheet(SEARCHLIST01);		    	
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
    case "trnk_ref_vvd_no":    	
    	if(ComChkValid(frm)) {
			doActionIBSheet(SEARCHLIST01);		    	
		}
    	break;          	
	}	  
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
	if (row < 1 || col  > 9) {
		return;
	}	
	
	
	var cgoClmNo = sheet.CellValue(row, "cgo_clm_no");
	//popupClaimMainView(cgoClmNo);
	
 	var sUrl = "/hanjin/alpsMain.screen?parentPgmNo=CPS_CNI_M001&pgmUrl=^hanjin^CPS_CNI_0033.do&mainPage=true&pgmNo=CPS_CNI_0033&cgo_clm_no="+cgoClmNo;
 	var winName = "CPS_CNI_0033";
  	var reqWin = ComOpenWindow(sUrl,winName,"width=1024,height=700, resizable=yes, scrollbars=yes, status=no");
			
	

} 

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	
	if (sAction == SEARCHLIST01) {		
		frm.f_cmd.value = SEARCHLIST01;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0016GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");
		// ------------------------------------------------------------
		// List 정보 설정
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0]);			
			for(var i = 0 ; i < sheet1.RowCount ; i++ ) {
				var row = sheet1.HeaderRows + i ;
				var cgoClmStsCd = sheet1.CellValue(row , "cgo_clm_sts_cd");
				if (cgoClmStsCd == "C" || cgoClmStsCd == "X") {
					sheet1.RowEditable(row) = false;
				}	
			}
			
			if (sheet1.RowCount == 0) {
				frm.trnk_ref_vvd_no.value = "";
			}
        }

		// ------------------------------------------------------------
		// Entry Status Vo
		// ------------------------------------------------------------
		if (arrXml.length > 1) {
			var list = SheetXml2ListMap(arrXml[1]);
			if (list.length > 0) {
				var vo = list[0];
				frm.insur_clm_pty_no.value = vo["insur_clm_pty_no"]; 
				frm.insur_clm_pty_abbr_nm.value = vo["insur_clm_pty_abbr_nm"];
				frm.insur_pty_nm.value = vo["insur_pty_nm"];
				frm.insur_vsl_oshp_cd.value = vo["insur_vsl_oshp_cd"];
				frm.insur_plcy_yr.value = vo["insur_plcy_yr"];
				frm.ddct_cgo_amt.value = ComAddComma(vo["ddct_cgo_amt"]);
			}
		}
		
	} else if (sAction == MULTI) {
		// -----------------------------------------------------------------
		// VVD는 본사 사용자만 보험관련 처리이므로 별도의 권한설정은 필요하지 않음
		// -----------------------------------------------------------------
		var ddct_cgo_amt = frm.ddct_cgo_amt.value;	
		if (ComIsNull(ddct_cgo_amt)) {
			 //msgs["CNI00105"] = "No Deductible. Please update Insurance Entry Status!";
			ComShowCodeMessage("CNI00105");
			return;
		}
		
		/*
		var insurAmt = 0;
		var rcvrAmt = 0;
		
		
		for ( var i = 0; i < sheet1.RowCount; i++) {
			var row = sheet1.HeaderRows + i;
			
			var cgoClmStsCd = sheet1.CellValue(row , "cgo_clm_sts_cd");
			if (cgoClmStsCd == "C" || cgoClmStsCd == "X") {
				continue;
			}			
		}
		*/
		
		
		frm.f_cmd.value = MULTI;
		var param = FormQueryString(frm);		
		var saveString = sheet1.GetSaveString();
		
		if (sheet1.IsDataModified && ComIsNull(saveString))  {	
			return;
		}
		
		if (ComIsNull(saveString))  {	
			 //msgs["CNI00022"] = "There is no contents to save.";
			ComShowCodeMessage("CNI00022");
			return;
		}
		
		saveString = ComSetPrifix(saveString, "sheet1_");
		param += "&" + saveString;		
		var sXml = sheet1.GetSaveXml("CPS_CNI_0016GS.do", param);		
		sheet1.LoadSaveXml(sXml);
		doActionIBSheet(SEARCHLIST01);
		
	} else if (sAction == PRINT) {
		
		frm.f_cmd.value = PRINT;
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0094.do]";
		var rpost =  "/rpost ["+FormQueryString(frm)+"]";
		var rpaper = "/rpaper [A4]";		 
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		var rv = "/rv trnk_ref_vvd_no["+ frm.trnk_ref_vvd_no.value+"]" +
		         " insur_clm_pty_abbr_nm[" + frm.insur_clm_pty_abbr_nm.value+"]" +
		         " insur_plcy_yr[" + frm.insur_plcy_yr.value + "]" +
		         " ddct_cgo_amt["+ frm.ddct_cgo_amt.value +"]";		
		frm.com_mrdArguments.value = rf + " " + rpost +  " " + rpaper +  " " + rv  ;
		frm.com_mrdTitle.value = "Insurance Recovery by VVD Status Report";
		frm.com_mrdBodyTitle.value = "Insurance Recovery by VVD";
		frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaim/insurancerecovery/report/CPS_CNI_0094.mrd";
		var feature = "resizable=yes,width=1000,height=600"
		popupRd(1000,600);
	} 
}

