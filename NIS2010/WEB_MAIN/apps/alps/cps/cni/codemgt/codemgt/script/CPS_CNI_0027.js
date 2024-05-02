/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0027.js
 *@FileTitle : [CPS_GEM_0027] Main Code View
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
 * [CPS_CNI_0027] Main Code View
 * @extends
 * @class Main Code View 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0027() {
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
    
    //claim party no가 존재하는경우 조회
    if (!ComIsNull(frm.clm_pty_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
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
            if (frm.popupYn.value == "Y") {
            	style.height = 150;
            } else {
            	style.height = 250;
            }
			
								
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

			var HeadTitle1 = "|Seq.|Contact Person|Tel|Tel|Fax|Fax|E-Mail|Remark(s)|cntc_pnt_no";

			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
            
			InitDataProperty(0, cnt++ , dtDataSeq,	    50,	    daCenter,	true,		"seq");
			InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,		"cntc_pnt_nm",			true,		"",				dfNone,		0,			true,		true , 100);
			InitDataProperty(0, cnt++ , dtData,			40,	    daCenter,		true,		"intl_phn_no",			false,		"",				dfNone,		0,			true,		true ,4);
			InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,		"cntc_pnt_phn_no",			false,		"",				dfNone,		0,			true,		true ,30);
			InitDataProperty(0, cnt++ , dtData,			40,	    daCenter,		true,		"intl_fax_no",			false,		"",				dfNone,		0,			true,		true ,4);
			InitDataProperty(0, cnt++ , dtData,			120,	daLeft,	true,		"cntc_pnt_fax_no",			false,		"",				dfNone,		0,			true,		true , 30);
			InitDataProperty(0, cnt++ , dtData,			150,	daLeft,	true,		"cntc_pnt_eml",			false,		"",				dfNone,		0,			true,		true , 200);
			InitDataProperty(0, cnt++ , dtData,		    250,	daLeft,	true,		"cntc_pnt_rmk",	false,		"",				dfNone,		0,			true,		true, 1300);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"cntc_pnt_no");
			PopupImage  =  "img/btns_note.gif";
			ShowButtonImage = 1;		
			
			InitDataValid(0,    "intl_phn_no",   vtNumericOnly);
			InitDataValid(0,    "cntc_pnt_phn_no",   vtNumericOther, "-");
			InitDataValid(0,    "intl_fax_no",   vtNumericOnly);
			InitDataValid(0,    "cntc_pnt_fax_no",   vtNumericOther, "-");
			InitDataValid(0,    "cntc_pnt_eml",   vtEngOther, "1234567890@.-_");
			
			break;		
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================
/**
 * Main Code Inquiry 설정
 */
function setMainCodeInquiry(partyVo) {	
	frm.clm_pty_no.value = partyVo.clm_pty_no;
	frm.clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
	doActionIBSheet(SEARCHLIST01);	
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
			var clm_pty_abbr_nm = frm.clm_pty_abbr_nm.value;
			if (ComIsNull(clm_pty_abbr_nm)) {
				//msgs["CNI00018"] = "Please select {?msg1}";
				ComShowCodeMessage("CNI00018" , "Code");
				return;
			}
			
			doActionIBSheet(SEARCHLIST01);			
			break;	
	    case "btn1_New":
	    	//msgs["CNI00015"] = "Do you want to initialize?";
	    	//if (ComShowCodeConfirm("CNI00015")) {
	    	//	ComResetAll();
	    	//}
	    	ComResetAll();
	        break;	
	    case "btn1_Code":
	    	popupMainCodeInquiry(); 
	        break;
	    case "btn1_close":
	    	self.close();
	    	break;	        
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
		var sXml = sheet1.GetSearchXml("CPS_CNI_0025GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");
		// ------------------------------------------------------------
		// party 정보 설정
		// ------------------------------------------------------------
		if (arrXml.length > 0) {			
			var list = SheetXml2ListMap(arrXml[0]);			
			if (list.length > 0) {
				var partyVO = list[0];
				frm.clm_pty_abbr_nm.value = partyVO["clm_pty_abbr_nm"];
				frm.prnt_clm_pty_no.value = partyVO["prnt_clm_pty_no"];
				frm.clm_pty_clr_cd.value = partyVO["prnt_clm_pty_abbr_nm"];
				frm.pty_nm.value = partyVO["pty_nm"];
				frm.intl_phn_no.value = partyVO["intl_phn_no"];
				frm.phn_no.value = partyVO["phn_no"];
				frm.intl_fax_no.value = partyVO["intl_fax_no"];
				frm.fax_no.value = partyVO["fax_no"];
				frm.pty_eml.value = partyVO["pty_eml"];
				frm.pty_addr.value = partyVO["pty_addr"];
				frm.pty_rmk.value = partyVO["pty_rmk"];
				frm.loc_cd.value = partyVO["loc_cd"];
				frm.zip_cd_ctnt.value = partyVO["zip_cd_ctnt"];
				frm.cnt_cd.value = partyVO["cnt_cd"];
				frm.cust_seq.value = partyVO["cust_seq"];
				frm.cust_nm.value = partyVO["cust_nm"];
				frm.vndr_seq.value = partyVO["vndr_seq"];
				frm.clm_pty_clr_no.value = partyVO["clm_pty_clr_no"];			
				frm.clm_pty_clr_cd.value = partyVO["clm_pty_clr_cd"];
				frm.cre_ofc_cd.value = partyVO["cre_ofc_cd"];
				frm.cre_usr_id.value = partyVO["cre_usr_id"];				
				frm.upd_dt.value = partyVO["upd_dt"];
				frm.clm_area_cd.value = partyVO["clm_area_cd"];
				frm.tpb_cd.value = partyVO["vndr_seq"];
				
				var delt_flg = partyVO["delt_flg"];				
				if (delt_flg == "N") {
					frm.delt_flg[0].checked = true;
					frm.delt_flg[1].checked = false;
				} else {
					frm.delt_flg[0].checked = false;
					frm.delt_flg[1].checked = true;					
				}
				
			}
        }

		// ------------------------------------------------------------
		//contact point 설정 
		// ------------------------------------------------------------
		if (arrXml.length > 1) {
			sheet1.LoadSearchXml(arrXml[1]);	
		}
		 	
		
	}
}

