/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0048.js
 *@FileTitle : [CPS_CNI_0048] CSR Manager
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0048] CSR Manager
 * @extends
 * @class 전표 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0048() {
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
var sheet2 = null;
var sheet3 = null;

//IBMultiCombo
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
 * IBCombo Object를 배열에 등록
 * @param comboObj
 **/
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
    sheet2 = sheetObjects[1];
    sheet3 = sheetObjects[2];
    
    sheetCnt = sheetObjects.length ;
   
    
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    //Form 이벤트 등록
    initControl();
    
	// IBMultiCombo초기화
	combo1 = comboObjects[0];
	comboCnt = comboObjects.length;

	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}    
    
    // 현재 로케일 날짜  및 이전한달  취득 
    /* from 한달전 ~ to 오늘 */
    
    var sXml = frm.sXml.value;    
    var arrXml = sXml.split("|$$|");
 	
 	// Area
	var areaList = SheetXml2ListMap(arrXml[0]);
	
	combo1.InsertItem(0, "All", "");	
	
	for ( var i = 1; i < areaList.length+1; i++) {
		var vo = areaList[i-1];
		text = vo["code"] + "|" + vo["name"];
		combo1.InsertItem(i, text, vo["code"]);
	}
    
	combo1.Index = 0;
	
	// Date 설정
	frm.fm_eff_dt.value = ComGetEtcData(arrXml[0], "FM_EFF_DT");
	frm.to_eff_dt.value = ComGetEtcData(arrXml[0], "TO_EFF_DT");
    
    // 조회
    doActionIBSheet(SEARCHLIST01);
    
    frm.ofc_cd.focus();

}


/**
* Form 이벤트 등록
*/
function initControl() {
	axon_event.addListener('keypress', 'keypressFormat', 'form');	
	axon_event.addListener('keyup', 'keypressCgoClmNo', 'cgo_clm_no');
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
function initCombo(comboObj, comboNo) {

	with (comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.BackColor = "#ffffff";
		comboObj.SetColAlign("center|left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 190;
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
			style.height = 420;
								
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

			var HeadTitle1 = "|Seq.|CSR No.|Area|Invoice\nOffice|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error\nReason|No. of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|Payment\nGroup|attr_ctnt2|iss_dt|rcv_dt|vndr_term_nm|aft_act_flg|if_flg|rcv_err_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|apro_rqst_no|cost_ofc_cd" ;
			
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);
	         
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			FrozenCols = 3;
			
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");
			InitDataProperty(0, cnt++ , dtSeq,	35,	daCenter,	true,		"",	false,  "",		dfNone,		0,	false,		false);    					
			InitDataProperty(0, cnt++ , dtData,	130, daCenter,		false,    "csr_no",				false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	    true,		"clm_area_cd",	false,	"",		dfNone,		0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,	55,	daCenter,	    true,		"inv_ofc_cd",	false,	"",		dfNone,		0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,	60, daCenter,		false,    "vndr_no",			false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData, 100, daLeft,		false,    "inv_desc",			false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	60, daLeft,		false,    "if_status",			false,			"",			dfNone,			0,			false,			false	);

			InitDataProperty(0, cnt++ , dtData,	90,	daCenter,		    false,    "if_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	65, daLeft,			    false,    "if_err_rsn",			false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	50, daCenter,			false,    "no_of_inv",			false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	60, daCenter,			false,    "csr_curr_cd",		false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	80, daRight,			false,    "csr_amt",			false,			"",			dfFloat,			2,			false,			false	);

			InitDataProperty(0, cnt++ , dtData,	80,	daCenter,		    false,    "due_dt",				false,			"",			dfDateYmd,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	60,	daLeft,		    	false,    "pay_grp_lu_cd",		false,			"",			dfDateYmd,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "attr_ctnt2",			false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "iss_dt",				false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "rcv_dt",				false,			"",			dfNone,			0,			false,			false	);

			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "vndr_term_nm",		false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "aft_act_flg",		false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "if_flg",				false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "rcv_err_flg",		false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "tml_inv_sts_cd",		false,			"",			dfNone,			0,			false,			false	);

			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "tml_inv_rjct_sts_cd",false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "apro_rqst_no",		false,			"",			dfNone,			0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	0, daLeft,			false,    "cost_ofc_cd",		false,			"",			dfNone,			0,			false,			false	);
			
			break;			
		case "sheet2" :
			// 높이 설정
            style.height = GetSheetHeight(13);
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(24, 1, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false);

            //var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt" ;
			var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt|pay_curr_cd|pay_amt|apro_step|title|chk_addr1|chk_addr2|chk_addr3|chk_cty_nm|chk_ste_cd|chk_zip_cd|chk_cnt_cd" ;

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
            
            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,	 				70,	daLeft,			false,    "pre_csr_no",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_office",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_prpd_dy",			false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_to",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_csr_type",			false,			"",			dfNone,				0,			false,			false	);

			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_desc",					false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_group",		false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_evi_tp",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_due_date",			false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_asa_no",				false,			"",			dfNone,				0,			false,			false	);

			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_inv_dt",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_curr_cd",			false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_amt",					false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_curr_cd",	false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_pay_amt",					false,			"",			dfNone,				0,			false,			false	);

			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "apro_step",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "pre_title",				false,			"",			dfNone,				0,			false,			false	);
            // CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr1",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr2",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_addr3",				false,			"",			dfNone,				0,			false,			false	);

			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_cty_nm",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_ste_cd",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_zip_cd",				false,			"",			dfNone,				0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 				70,	daRight,		false,    "chk_cnt_cd",				false,			"",			dfNone,				0,			false,			false	);			
			break;
		case "sheet3" :
            // 높이 설정
            style.height = GetSheetHeight(13);
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(10, 1, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle = "char of account|account name|gl date|city|inv no|desc|debit|credit|debit2|credit2" ;

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME,  								KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,	 			80,			daCenter,		false,    "pre_chart_of_account",		false,			"",			dfNone,					0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData, 			80,			daCenter,		false,    "pre_account_name",				false,			"",			dfNone,					0,			true,			true	);
			InitDataProperty(0, cnt++ , dtData,	 			80,			daLeft,			false,    "pre_gl_date",						false,			"",			dfNone,					0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_city",								false,			"",			dfNone,					0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_inv_no",							false,			"",			dfNone,					0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_desc",								false,			"",			dfNone,					0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_debit",							false,			"",			dfNone,					0,			false,			false	);
			InitDataProperty(0, cnt++ , dtData,	 			80,			daRight,		false,    "pre_credit",							false,			"",			dfNone,					0,			false,			false	);

			InitDataProperty(0, cnt++ , dtHidden,	 		0,			daRight,		false,    "pre_debit2",							false,			"",			dfNone,					0,			false,			false	);
			InitDataProperty(0, cnt++ , dtHidden,	 		0,			daRight,		false,    "pre_credit2",						false,			"",			dfNone,					0,			false,			false	);			
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
		case "btng_retrieve":
			if (ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST01);
			}
			break;
		case "btng_new":
    		ComResetAll();
    		combo1.Index = 0;    		
    		// Date 설정
    	    var sXml = frm.sXml.value;    
    	    var arrXml = sXml.split("|$$|");
    		frm.fm_eff_dt.value = ComGetEtcData(arrXml[0], "FM_EFF_DT");
    		frm.to_eff_dt.value = ComGetEtcData(arrXml[0], "TO_EFF_DT");			
			frm.ofc_cd.focus();
			break;
		case "btng_csrformat":
			if (sheet1.RowCount <= 0){
				//msgs['CNI25006'] = 'There is no data retrieved.' ;
				ComShowCodeMessage("CNI25006");
				return false;
			}
			
			if (sheet1.SelectRow==undefined || sheet1.SelectRow==null || sheet1.SelectRow==0) {				
				//msgs['CNI21908'] = 'There is no row selected.';
				ComShowCodeMessage("CNI21908");
				return false;
			}
			
			if (sheet1.CellValue(sheet1.SelectRow,'csr_no')==undefined ||
					sheet1.CellValue(sheet1.SelectRow,'csr_no')==null ||
				sheet1.CellValue(sheet1.SelectRow,'csr_no').trim()==''){
				//msgs["CNI40048"] = "There is no CSR No. on selected row." ;
				ComShowCodeMessage("CNI40048");
				return false;
			}
			
			sheet2.RemoveAll();
			sheet3.RemoveAll();
			doActionIBSheet1(sheet2,frm,IBSEARCH);
			break;			
			//달력
		case "btns_Calendar2" :		// Agreement Date (To Date)
	 		var cal = new ComCalendarFromTo();
	        cal.select(frm.fm_eff_dt,  frm.to_eff_dt,  'yyyy-MM-dd');
	 		break;   			
		case "btng_invoicelistinquiry":
			if (sheet1.RowCount <= 0){
				//msgs['CNI25006'] = 'There is no data retrieved.' ;
				ComShowCodeMessage("CNI25006");
				return false;
			}
			if (sheet1.SelectRow==undefined || sheet1.SelectRow==null || sheet1.SelectRow==0){
				//msgs['CNI21908'] = 'There is no row selected.';
				ComShowCodeMessage("CNI21908");
				return false;
			}
			if (sheet1.CellValue(sheet1.SelectRow,'csr_no')==undefined ||
				sheet1.CellValue(sheet1.SelectRow,'csr_no')==null ||
				sheet1.CellValue(sheet1.SelectRow,'csr_no').trim()==''){
				//msgs["CNI40048"] = "There is no CSR No. on selected row." ;
				ComShowCodeMessage("CNI40048");
				return false;
			}

			var csrNo = sheet1.CellValue(sheet1.SelectRow,'csr_no');
			var costOfcCd = sheet1.CellValue(sheet1.SelectRow,'cost_ofc_cd');
			var currCd = sheet1.CellValue(sheet1.SelectRow,'csr_curr_cd');
			var invSubSysCd = document.form.inv_sub_sys_cd.value;
			window.showModalDialog("/hanjin/COM_CSR_0011.do?csr_no="+csrNo+"&cost_ofc_cd="+costOfcCd+"&inv_sub_sys_cd="+invSubSysCd+"&curr_cd="+currCd, window, "dialogWidth:820px; dialogHeight:500px; help:no; status:no; scroll:no; resizable:no;");
			break;

		case "btng_viewapprovalstep":
			if (sheet1.RowCount <= 0){
				//msgs['CNI25006'] = 'There is no data retrieved.' ;
				ComShowCodeMessage("CNI25006");
				return false;
			}
			if (sheet1.SelectRow==undefined || sheet1.SelectRow==null || sheet1.SelectRow==0){
				//msgs['CNI21908'] = 'There is no row selected.';
				ComShowCodeMessage("CNI21908");
				return false;
			}
			if (sheet1.CellValue(sheet1.SelectRow,'csr_no')==undefined ||
				sheet1.CellValue(sheet1.SelectRow,'csr_no')==null ||
				sheet1.CellValue(sheet1.SelectRow,'csr_no').trim()==''){
				//msgs["CNI40048"] = "There is no CSR No. on selected row." ;
				ComShowCodeMessage("CNI40048");
				return false;
			}
        	var apro_rqst_no = sheet1.CellValue(sheet1.SelectRow, "apro_rqst_no");
			if (apro_rqst_no==undefined || apro_rqst_no==null || apro_rqst_no.trim()==''){
				//msgs["CNI40041"] = "{?msg1} has been omitted." ;
				ComShowCodeMessage("CNI40041","Approval Request No");
				return false;
			}
			//var url = "/hanjin/COM_ENS_0W1.do?apro_rqst_no="+apro_rqst_no;
			//window.showModalDialog(url, window, "dialogWidth:640px; dialogHeight:310px; help:no; status:no; resizable:yes;");

			var param = "?apro_rqst_no="+apro_rqst_no;
				ComOpenPopup('/hanjin/COM_ENS_0W1.do' + param, 640, 270, '', 'none', true);
			break;

		case "btng_print":
			/* 2008-11-18 : 부산의 요청에 의해 Excel로 download 기능 추가 */
			sheet1.Down2Excel();
			break;
	    	
	}

}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function keypressCgoClmNo() {
 	var obj = event.srcElement;
    switch (obj.name) {    
    case "cgo_clm_no":
    	if (obj.value.length == 10) {    		
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
     case "ofc_cd":
     case "search_csr_no":
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
     case "ofc_cd":     	
     	if (obj == null || 
     			obj.value.length < 5 ||  obj.value.length > 6 ) {
     		return;
     	}
     	
 		doActionIBSheet(SEARCHLIST01);
 		
     	break;          	
     case "search_csr_no":     	
      	if (obj == null || obj.value.length < 3  ) {
      		return;
      	}
      	
  		doActionIBSheet(SEARCHLIST01);
  		
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
   	case "fm_eff_dt":   		
   	case "to_eff_dt":
   		ComChkObjValid(event.srcElement);
   		break;
   	}
   } 
    
  //===================================================================================
  //IBCombo 이벤트 처리
  //===================================================================================
  /**
  * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
  * @return
  */
  function combo1_OnChange(comboObj, code, text) {
	frm.clm_area_cd.value = "";
	if (code != -1 ) {
	  	frm.clm_area_cd.value = code;
	  	frm.ofc_cd.focus();
	}
  }	 
  
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value = SEARCHLIST01;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0048GS.do", FormQueryString(frm));
		sheet1.LoadSearchXml(sXml);
	}
}

function doActionIBSheet1(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
       case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH02;
			formObj.csr_no.value = sheet1.CellValue(sheet1.SelectRow,'csr_no'); //이미 csr_no가 존재하는지 위에서 검사
			var sXml = sheet3.GetSearchXml("COM_CSR_00081GS.do", FormQueryString(formObj),"",true);
			var arrXml = sXml.split("|$$|");
			sheet2.LoadSearchXml(arrXml[0]);	//플릿폼
			sheet3.LoadSearchXml(arrXml[1]);	//리스트
       break;
    }
}

function sheet1_OnSearchEnd(sheet1, ErrMsg){
	if (sheet1.RowCount > 0){
		for (var i=1; i<=sheet1.RowCount; i++){
			if (sheet1.CellValue(i,'aft_act_flg')!=null && (sheet1.CellValue(i,'aft_act_flg')=='N' || sheet1.CellValue(i,'aft_act_flg')=='X')){
				sheet1.RowBackColor(i) = sheet1.RgbColor(255, 153, 153);
			}
		}
	}
	//sheet1.CellValue(1,'if_status') = 'A/P Rejected';	//A/P Rejected 팝업 건건이 인보이스 취소 테스트 하기위해 임시로
}

function sheet1_OnSaveEnd(sheet1, ErrMsg){
	if (sheet1.RowCount > 0){
		for (var i=1; i<=sheet1.RowCount; i++){
			if (sheet1.CellValue(i,'aft_act_flg')!=null && (sheet1.CellValue(i,'aft_act_flg')=='N' || sheet1.CellValue(i,'aft_act_flg')=='X')){
				sheet1.RowBackColor(i) = sheet1.RgbColor(255, 153, 153);
			}
		}
	}
}

function sheet3_OnSearchEnd(sheetObj,errMsg){
 	var srcName = window.event.srcElement.getAttribute("name");
    
    var previewFlg    = "";
    var pre_csr_no    = sheet2.CellValue(1,"pre_csr_no") 	 ;
    var pre_prpd_dy   = sheet2.CellValue(1,"pre_prpd_dy")  ;
    var pre_pay_to    = sheet2.CellValue(1,"pre_pay_to") 	 ;
    var pre_csr_type  = sheet2.CellValue(1,"pre_csr_type") ;
    var pre_desc      = sheet2.CellValue(1,"pre_desc") 		 ;
    var pre_pay_group = sheet2.CellValue(1,"pre_pay_group");
    var pre_evi_tp    = sheet2.CellValue(1,"pre_evi_tp") 	 ;
    var pre_due_date  = sheet2.CellValue(1,"pre_due_date") ;
    var pre_asa_no    = sheet2.CellValue(1,"pre_asa_no") 	 ;
    var pre_inv_dt    = sheet2.CellValue(1,"pre_inv_dt") 	 ;
    var pre_curr_cd   = sheet2.CellValue(1,"pre_curr_cd")  ;
    var pre_amt       = sheet2.CellValue(1,"pre_amt") 		 ;
    var pre_pay_curr_cd   = sheet2.CellValue(1,"pre_pay_curr_cd")  ;
    var pre_pay_amt       = sheet2.CellValue(1,"pre_pay_amt") 		 ;
    var pre_title     = sheet2.CellValue(1,"pre_title") 	 ;
    var apro_step	  = sheet2.CellValue(1,"apro_step") 	 ;
    
    // CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 2009. 02. 24 - 송민정 요청)                       
    var chk_addr1     = sheet2.CellValue(1,"chk_addr1") 	 ;
    var chk_addr2     = sheet2.CellValue(1,"chk_addr2") 	 ;
    var chk_addr3     = sheet2.CellValue(1,"chk_addr3") 	 ;
    var chk_cty_nm    = sheet2.CellValue(1,"chk_cty_nm") 	 ;
    var chk_ste_cd    = sheet2.CellValue(1,"chk_ste_cd") 	 ;
    var chk_zip_cd    = sheet2.CellValue(1,"chk_zip_cd") 	 ;
    var chk_cnt_cd    = sheet2.CellValue(1,"chk_cnt_cd") 	 ;
    //var ofc_cd        = document.form.ofc_cd.value;
    var ofc_cd		  = sheet1.CellValue(sheet1.SelectRow,'cost_ofc_cd');
    
	var pre_evi_tp_count	= "";
	var pre_title	  = "CONSULTATION SLIP";
	
	var pre_evi_tp;
	if(cnt_cd =="KR"){
		pre_evi_tp_count ="1";
		pre_evi_tp  = pre_evi_tp;
	}else{
		var sRow = sheet1.FindCheckedRow(1);
		var arrRow = sRow.split("|");
		pre_evi_tp_count =arrRow.length-1;
		pre_evi_tp_count = sheet1.CellValue(sheet1.SelectRow,'no_of_inv');
		pre_evi_tp = pre_evi_tp+"/"+pre_evi_tp_count;
	} 
	
	if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY" || pre_curr_cd=="TWD"){
     	previewFlg = "krjp";
     	pre_amt = csr_chkAmtFmt(pre_amt,pre_curr_cd);
     	pre_pay_amt = csr_chkAmtFmt(pre_pay_amt,pre_curr_cd);
    }else{
    	pre_amt = csr_chkAmtFmt(pre_amt);
    	pre_pay_amt = csr_chkAmtFmt(pre_pay_amt);
    }
    
    //다시 셋팅 
    sheet2.RemoveAll();
	sheet2.DataInsert(-1);

    sheet2.CellValue(1,"pre_csr_no") 	= pre_csr_no   ;
    sheet2.CellValue(1,"pre_prpd_dy")  = pre_prpd_dy  ;
    sheet2.CellValue(1,"pre_pay_to") 	= pre_pay_to   ;
    sheet2.CellValue(1,"pre_csr_type") = pre_csr_type ;
    sheet2.CellValue(1,"pre_desc") 	= pre_desc     ;
    sheet2.CellValue(1,"pre_pay_group")= pre_pay_group;
    sheet2.CellValue(1,"pre_evi_tp") 	= pre_evi_tp   ;
    sheet2.CellValue(1,"pre_due_date") = pre_due_date ;
    sheet2.CellValue(1,"pre_asa_no") 	= pre_asa_no   ;
    sheet2.CellValue(1,"pre_inv_dt") 	= pre_inv_dt   ;
    sheet2.CellValue(1,"pre_curr_cd")  = pre_curr_cd  ;
    sheet2.CellValue(1,"pre_amt") 		= ComReplaceStr(pre_amt,",","");
    sheet2.CellValue(1,"pre_pay_curr_cd")  = pre_pay_curr_cd  ;
    sheet2.CellValue(1,"pre_pay_amt") 	= ComReplaceStr(pre_pay_amt,",","");
    sheet2.CellValue(1,"pre_title") 	= pre_title    ;
    sheet2.CellValue(1,"apro_step") 	= apro_step    ;
    sheet2.CellValue(1,"pre_office") 	= ofc_cd;

    sheet2.CellValue(1,"chk_addr1") 	= chk_addr1    ;
    sheet2.CellValue(1,"chk_addr2") 	= chk_addr2    ;
    sheet2.CellValue(1,"chk_addr3") 	= chk_addr3    ;
    sheet2.CellValue(1,"chk_cty_nm") 	= chk_cty_nm   ;
    sheet2.CellValue(1,"chk_ste_cd") 	= chk_ste_cd   ;
    sheet2.CellValue(1,"chk_zip_cd") 	= chk_zip_cd   ;
    sheet2.CellValue(1,"chk_cnt_cd") 	= chk_cnt_cd   ;
	
	//  'Approval Requested'이거나 'Disapproved'인 경우에는 print화면의 'APPRD BY'란을 채우지 않는다.  
	var v_apro_step = '';

	if (sheet1.RowCount > 0 &&
		(sheet1.CellValue(sheet1.SelectRow,'if_status')!='Approval Requested' && sheet1.CellValue(sheet1.SelectRow,'if_status')!='Disapproved'))
	{
		//
	}else{
		//sheet2.CellValue(1,"apro_step") 		=  "";
	}
	
	window.showModalDialog("/hanjin/COM_CSR_0006.do?previewFlg="+previewFlg+"&previewFlgYN=N", window, "dialogWidth:775px; dialogHeight:750px; help:no; status:no; scroll:no; resizable:no;");
	//ComOpenPopup('/hanjin/COM_CSR_0006.do?previewFlg='+previewFlg+'&previewFlgYN=N', 775, 700, "", "0,1,1,1,1,1");
}

function csr_chkAmtFmt(src, curr_cd){

	src = new String(src);
	if (src==undefined || src==null || src.trim()==''){
		return '';
	}

	src = csr_deleteComma(src);

	//if (curr_cd!=undefined && curr_cd!=null && (curr_cd=='KRW' || curr_cd=='JPY')){
	if (curr_cd!=undefined && curr_cd!=null && tes_isNoDecimalPointCurrCD(curr_cd)){
		if (src.indexOf('.') != -1){
			src = src.substring(0,src.indexOf('.'));
		}
		src = csr_addComma(src);
	} else {
		if (src.indexOf('.') == -1){
			src = csr_addComma(src) + '.00'
		} else {
			var temp = src.split(".");
			if (temp.length == 2){
				if (temp[1]==null || temp[1].trim()==''){temp[1] = '00';}
				if (temp[1].length == 1){temp[1] = temp[1] + '0';
				} else if (temp[1].length == 2){
				} else if (temp[1].length > 2){temp[1] = temp[1].substring(0,2);
				}
				src = csr_addComma(temp[0])+'.'+temp[1];
			} else if (temp.length > 2){
				// 두번째 .부터 .를 다 삭제하고 재계산하기
				var tmp_str = '';
				for (var i=1; i<temp.length; i++){
					tmp_str = tmp_str + new String(temp[i]).trim();
				}
				if (tmp_str==null || tmp_str.trim()==''){tmp_str = '00';}
				if (tmp_str.length == 1){tmp_str = tmp_str + '0';
				} else if (tmp_str.length == 2){
				} else if (tmp_str.length > 2){tmp_str = tmp_str.substring(0,2);
				}
				src = csr_addComma(temp[0])+'.'+tmp_str;
			} else {
				//showErrMessage('ERR!');
				return false;
			}
		}
	}
	return src;
}

function csr_deleteComma(src){
	// comma를 제거
	var src = String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	return src.replace(/,/gi,'');
}

function csr_addComma(src){
	// comma를 3자리마다 끼워넣기
	var src = String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	var re = /(-?\d+)(\d{3})/;
	while (re.test(src)) {
		src = src.replace(re, "$1,$2");
	}
	return  src;
}