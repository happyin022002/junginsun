/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0032.js
 *@FileTitle : [CPS_CNI_0032] Incident-Claim Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0032] Incident-Claim Inquiry
 * @extends
 * @class Find 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_CNI_0032() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
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

	//초기값세팅
	if(frm.popupYn.value != "Y"){//팝업으로 열릴때는 inci_no를 받으므로.
		frm.cgo_clm_inci_no.value = "INCID"+frm.schToStrGmt.value;
	}
   
    //Form 이벤트 등록
    initControl();

	ComSetFocus(frm.cgo_clm_inci_no);
	
	if(frm.popupYn.value == "Y"){
		doActionIBSheet(SEARCHLIST01);
	}

}

/**
* Form 이벤트 등록
*/
function initControl() {
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
   axon_event.addListenerForm('keyup', 'obj_keyup',frm);

}



/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
					style.height = 402;

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, CNI_PAGE_SIZE);

					var HeadTitle1 = "Seq.|CL|Claim No.|A|HOFC|STS|LIT|DOC|NOPC|DOF|DOU|Claimant|VVD|B/L No.|CNTR No.|Term|POR|POL|POD|DEL|DDL|FVD|PRE_POT|ON_POT|Cargo|TOC|Claim Amount|TOS|DOS|Settled Amount|Surveyor|DOSV|Survey Fee|cgo_clm_inci_no|inci_a|inci_rgofc|inci_register|inci_dorg|inci_update|inci_poi|inci_vvd|inci_location|inci_doi|inci_subject";

					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 3, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                //InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");

					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"",				false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			20,		daCenter,	true,		"cgo_clm_div_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,		"cgo_clm_no",		false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			20,		daCenter,	true,		"clm_area_cd1",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"hdlr_ofc_cd",			false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"cgo_clm_sts_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"smns_sve_dt",			false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"cs_clz_dt",			false,		"",				dfDateYmd,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"prlm_clm_ntc_dt",	false,      "",				dfDateYmd,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"fmal_clm_rcv_dt",			false,		"",				dfDateYmd,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"upd_dt1",		false,      "",				dfDateYmd,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,	true,		"pty_nm1",		false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,		"trnk_ref_vvd_no",			false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,		"cgo_clm_ref_bl_no",		false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,		"cgo_clm_ref_cntr_no",		false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"crr_term_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"por_cd",			false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"pol_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"pod_cd",			false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"del_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"de_dt",			false,      "",				dfDateYmd,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			150,		daCenter,	true,		"n1st_pre_ref_vvd_no",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"n1st_pre_ts_loc_cd",		false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"n1st_pst_ts_loc_cd",		false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			120,		daLeft,	true,		"cgo_qlty_desc",		false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"cgo_clm_tp_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"clmt_locl_amt",	false,      "",				dfFloat,		2,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"cgo_clm_stl_tp_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"cgo_clm_stl_dt",			false,      "",				dfDateYmd,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"cgo_clm_stl_usd_amt",			false,		"",				dfFloat,		2,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daLeft,	true,		"pty_nm2",		false,      "",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"svey_inp_dt",			false,		"",				dfDateYmd,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"svyr_fee_usd_amt",	false,      "",				dfFloat,		2,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"cgo_clm_inci_no",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"clm_area_cd2",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"cre_ofc_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"cre_usr_id",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"cre_dt",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"upd_dt2",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"inci_plc_tp_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"inci_ref_vvd_no",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"inci_loc_cd",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"inci_occr_dt",			false,		"",				dfNone,		0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"inci_subj_nm",			false,		"",				dfNone,		0,			false,		true);
										  
					//CountPosition = 0;
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
               }
                break;

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

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn1_Retrieve":
				var cgoClmInciNo = frm.cgo_clm_inci_no.value;
				if (ComIsNull(cgoClmInciNo) || cgoClmInciNo.length != 13) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Incident No 13 characters");
					ComSetFocus(frm.cgo_clm_inci_no);
					return;
				}
				sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
				frm.page_no.value="1";

				doActionIBSheet(SEARCHLIST01);			
				
				break;	

			case "btn1_New":
				ComResetAll();
				frm.cgo_clm_inci_no.value = "INCID"+frm.schToStrGmt.value;
				ComSetFocus(frm.cgo_clm_inci_no);
				break;

			case "btn1_Print":
				if (sheet1.RowCount <= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 

			case "btn1_Down_Excel":
				sheet1.SpeedDown2Excel(-1)
                break;

			case "btn1_close":
	    		self.close();
	    		break;	

		} // end switch

}

/**
 * HTML Control KeyPress 이벤트 호출
 */

function obj_keypress() {
    switch (event.srcElement.name) {    
		case "cgo_clm_inci_no":  
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}


/**
 * HTML Control KeyDowm 이벤트 호출
 */
function obj_keydown() {
	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;     
    if (event.keyCode != 13) {
	  		 return;
	}
	    
    switch (event.srcElement.name) {    
		case "cgo_clm_inci_no":

			var cgoClmInciNo = frm.cgo_clm_inci_no.value;
			if (cgoClmInciNo.length != 13) {
				//msgs["CNI00009"] = "Please input {?msg1}";
				ComShowCodeMessage("CNI00009" , "Incident No 13 characters");
				ComSetFocus(frm.cgo_clm_inci_no);
				return;
			}

			if (frm.cgo_clm_inci_no.value.length == 13) {
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;
	}
}

/**
 * HTML Control KeyUp 이벤트 호출
 */
function obj_keyup() {
	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;  
    switch (event.srcElement.name) {    
		case "cgo_clm_inci_no":
			if(frm.cgo_clm_inci_no.value.length == 13){
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
			break;
	}
}

/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm = document.form;
	switch (event.srcElement.name) {

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


// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
 
/**
 * row double click 시 CPS_CNI_0003 화면전환
 * @param {IBSheet} sheet
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 */

function sheet1_OnDblClick(sheet, row, col) {
	var cgoClmNo = sheet1.CellValue(row , "cgo_clm_no");
	location.href = "CPS_CNI_0003.do?pgmNo=CPS_CNI_0003&cgo_clm_no="+cgoClmNo;	
}

function sheet1_OnSearchEnd(sheet, ErrMsg) {
	
	if(sheet.RowCount <= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}
}

function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
	frm.page_no.value = PageNo;  
	doActionIBSheet(SEARCHLIST01);
}   

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;

	if (sAction == SEARCHLIST01) {

		frm.f_cmd.value = SEARCHLIST01;	

		var sXml = sheet1.GetSearchXml("CPS_CNI_0032GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0], true);

			var list = SheetXml2ListMap(arrXml[0]);
			if (list.length > 0) {
				var vo = list[0];

				frm.clm_area_cd2.value = vo["clm_area_cd2"];
				frm.cre_ofc_cd.value = vo["cre_ofc_cd"];
				frm.cre_usr_id.value = vo["cre_usr_id"];
				frm.cre_dt.value = vo["cre_dt"];
				frm.upd_dt2.value = vo["upd_dt2"];
				frm.inci_plc_tp_cd.value = vo["inci_plc_tp_cd"];
				frm.inci_ref_vvd_no.value = vo["inci_ref_vvd_no"];
				frm.inci_loc_cd.value = vo["inci_loc_cd"];
				frm.inci_occr_dt.value = vo["inci_occr_dt"];
				frm.inci_subj_nm.value = vo["inci_subj_nm"];

			}
		}

	} else if (sAction == PRINT) {		
		frm.f_cmd.value = PRINT;
		frm.page_no.value = "";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0087.do]";
		var rpost =  "/rpost ["+FormQueryString(frm)+"]";
		var rpaper = "/rpaper [A4]";
		
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		
		var rv =  "/rv cgo_clm_inci_no["+frm.cgo_clm_inci_no.value+"]";
		frm.com_mrdArguments.value = rf + " " + rv + " " + rpost + " " + rpaper;
		frm.com_mrdBodyTitle.value = "Incident-Claim Inquiry-Print";		
		frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaim/incidentsurvey/report/CPS_CNI_0087.mrd";
		popupRd(1000,600);
	} 
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }