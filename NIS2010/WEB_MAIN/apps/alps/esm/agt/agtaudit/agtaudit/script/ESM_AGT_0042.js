// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sRow = 0;

/*
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(account_code, account_name) {
    for(i=0;i<sheetObjects.length;i++){
        //시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1,account_code, account_name);

        //마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

    // Subj.Month 날짜 세팅
    var formObj = document.form;
    formObj.comm_yrmon.value = ComGetNowInfo("ym");
    
    // 처음 페이지 로드시 AR_OFC 검색
    if(formObj.ar_ofc_cd.value != ""){
        ar_ofc_cd_OnChange();
    }   
    
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,account_code,account_name) {
    var cnt = 0;
    var formObj = document.form;    
    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                //높이 설정
                style.height = GetSheetHeight(15);

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(27, 5, 0, true);

                //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, true, true, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
                var HeadTitle = "DEL|STS|CHK|No.|Acct.|Description|vdCnt|Office|Vendor|Name|City|Center|Apply\nDate|VVD|Cur|PYMT AMT|Ex. Rate|USD AMT|Approval\nDate|bkgNo|bkgNoS|agnCd|bndCd|tpCd|acSeq|Status|Remarks";
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtDelCheck,  40,    daCenter,  false,    "del",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtStatus,    30,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      true);
                InitDataProperty(0, cnt++, dtCheckBox,  40,    daCenter,  true,     "chk",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtSeq,       30,    daCenter,  true,     "seq",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtCombo,     60,    daCenter,  true,     "comm_stnd_cost_cd",   false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtData,      150,   daLeft,    true,     "otr_comm_acct_ctnt",   true,     "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "vndr_cnt_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtPopup,      60,    daCenter,  true,     "ofc_cd",  false,    "",         dfNone,     0,         false,      true);
				InitDataProperty(0, cnt++, dtPopup,     70,    daCenter,  true,     "vndr_seq",  false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtData,      150,   daLeft,    true,     "vndr_lgl_eng_nm",   false,    "",         dfNone,     0,          false,      false);                
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "comm_occr_info_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "ap_ctr_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "aply_dt", true,     "",         dfDateYmd,  0,          true,       true);
                InitDataProperty(0, cnt++, dtData,      90,    daCenter,  true,     "vvd",    true,     "",         dfNone,     0,          true,       true, 10);
                InitDataProperty(0, cnt++, dtCombo,     45,    daCenter,  true,     "curr_cd",   false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,    daRight,   true,     "act_locl_comm_amt", true,     "",         dfFloat,    2,          true,       true);
                InitDataProperty(0, cnt++, dtData,      60,    daRight,   true,     "mon_xch_rt",  false,    "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,    daRight,   true,     "act_comm_amt", true,     "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "ac_apro_dt", false,    "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "bkg_no",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "bkgNoS", false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "io_bnd_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "ac_tp_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "ac_seq",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "comm_proc_sts_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,      200,   daLeft,    true,     "comm_proc_sts_rsn", false,    "",         dfNone,     0,          false,      false);
				
				//컬럼 속성 설정
				InitDataValid(0, "otr_comm_acct_ctnt",  vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?");	//Description 컬럼은 영문자 + 숫자 + 특수키만 입력되도록 설정
                //InitDataValid(0, "ofc_cd", vtEngUpOther, "");			//Office 컬럼은 영대문자만 입력되도록 설정
                //InitDataValid(0, "vndr_seq", vtEngUpOther, "1234567890");	//영대문자 + 숫자만 입력되도록 설정
                InitDataCombo(0, "curr_cd", currText, currCode, "USD");
                //콤보 항목 설정하기
                //InitDataCombo(0, "acct", "512611|512621|512631|512641|512661|512691", "512611|512621|512631|512641|512661|512691","512691");
                //InitDataCombo(0, "acct", "512691", "512692","512693");
                InitDataCombo(0, "comm_stnd_cost_cd", account_code, account_code);
                //전체선택시 이벤트 발생안함
                AllowEvent4CheckAll = false; 
                
                CountPosition = 0;                
                
            }
            break;
    }
}

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

            case "btn_save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;

            case "btn_request":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
				
			case "btng_rowadd":
                doActionIBSheet(sheetObject,formObject,IBINSERT);
                break;
        } // end switch

    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
            ComShowMessage(e);
        }
    }
}

/*
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //조회

            if(!validateForm(sheetObj,formObj,sAction)) return false;
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch4Post("ESM_AGT_0042GS.do", agtQryStr(formObj));
            sheetObj.SumText(0,1) = "";
            sheetObj.SumText(0,4) = "TOTAL";
            break;

        case IBSAVE:        //저장
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = MULTI;
            sheetObj.DoSave("ESM_AGT_0042GS.do", agtQryStr(formObj));
            
            //저장후 재조회
//            formObj.f_cmd.value = SEARCH;
//            sheetObj.DoSearch4Post("ESM_AGT_042GS.do", agtQryStr(formObj));
//            sheetObj.SumText(0,1) = "";
//            sheetObj.SumText(0,4) = "TOTAL";
            break;

		case IBSEARCH_ASYNC03:	//Request
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESM_AGT_0042GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,4) = "TOTAL";
			break;
		
        case IBDOWNEXCEL:	//엑셀내려받기
			sheetObj.SpeedDown2Excel(-1);
			break;
			
		case IBINSERT:      //행추가
            if(!validateForm(sheetObj,formObj,sAction)) return false;
           
            formObj.gubun.value = "IN";
            
            //그리드의 첫행에 행추가
            var insRow = sheetObj.DataInsert(0);
            var yyyymm = ComTrimAll(formObj.comm_yrmon.value,'-');
            var currCombo = "USD|" + formObj.param8.value;
            sRow = insRow;
            sheetObj.CellValue2(insRow, "vndr_cnt_cd") = formObj.param3.value;
            sheetObj.CellValue2(insRow, "vndr_seq") = formObj.param4.value;
            sheetObj.CellValue2(insRow, "vndr_lgl_eng_nm")  = formObj.param5.value;
            sheetObj.CellValue2(insRow, "ofc_cd") = formObj.param6.value;
            sheetObj.CellValue2(insRow, "comm_occr_info_cd")  = formObj.param7.value;
            sheetObj.CellValue2(insRow, "ap_ctr_cd")  = formObj.param8.value;
            sheetObj.CellValue2(insRow, "curr_cd")  = formObj.param9.value;
            sheetObj.CellValue2(insRow, "mon_xch_rt") = formObj.param10.value;
            sheetObj.CellValue2(insRow, "vvd")   = "CNTC" + yyyymm.substring(2,6) + "MM";
            sheetObj.CellValue(insRow, "aply_dt") = ComGetNowInfo();
            sheetObj.SumText(0,1) = "";
            sheetObj.SumText(0,4) = "TOTAL";
            sheetObj.SelectCell(insRow, "otr_comm_acct_ctnt");
            break;
    }
	
	//Status에 따른 색깔 표시
	var rows = sheetObj.RowCount;
	for(var i=0; i<rows; i++){
		sts = sheetObj.CellValue(i+1,"comm_proc_sts_cd");
		if(sts == "IC"){
			sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(255,0,0); //red
		}
	}
}

/**
 * A/R Office를 변경하면, 해당 Vendor, Vendor Name, Office, City, Center 정보 조회하기
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
    var arOfcCd = formObj.ar_ofc_cd.value;

    formObj.param1.value = arOfcCd;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0042FR.do";
    formObj.submit();
    
    //Grid를 초기화한다.
    sheetObj.RemoveAll();
}

/*
 * Office정보를 체크
 */
function checkOfficeInfo(){
    var formObj = document.form;
	var vendor = formObj.param4.value;
    var arOfcCd = formObj.ar_ofc_cd.value;

    if(vendor == ""){
    	ComShowMessage(ComGetMsg("AGT10025", arOfcCd, "", ""));
    	formObj.ar_ofc_cd.value = "";
    	formObj.param1.value = "";
    }
}

/*
 * 그리드에서 컬럼값 변경시 처리
 */
function sheet1_OnChange(sheetObj, row, col) {
	var formObj = document.form;
	var colNm =	sheetObj.ColSaveName(col);
	var yyyymm = ComTrimAll(formObj.comm_yrmon.value, '-');

//    if(sheetObj.CellValue(row, "iflag") == "I"){
//        if(formObj.office_code.value.length == 6){
//            sheetObj.CellEditable(row, "vndr_seq") = true;
//            sheetObj.CellEditable(row, "curr_cd") = true;
//        }
//    }
	
	// 2007.11.07 추가
    if(colNm == "vvd"){
       // if(!validateForm(sheetObj,formObj,IBINSERT)) return false;
        sRow = row;
        var vvd = sheetObj.CellValue(row, "vvd");
        var vvdLen = vvd.length;
        if(vvdLen < 10 ){          
          ComShowMessage(ComGetMsg("AGT10017", "VVD", "", ""));
          sheetObj.SelectCell(row,"vvd",true,"CNTC" + yyyymm.substring(2,6) + "MM");
          return false;
        }
        
        if(vvd.substring(0,4) != "CNTC" ){     
          ComShowMessage(ComGetMsg("AGT10017", "VVD", "", ""));
          sheetObj.SelectCell(row,"vvd",true,"CNTC" + yyyymm.substring(2,6) + "MM");
          return false;
        }
        

    }
    
    // 2007.06.18 추가
    if(colNm == "ofc_cd"){
        if(!validateForm(sheetObj,formObj,IBINSERT)) return false;
        sRow = row;
        var arOfcCd = sheetObj.CellValue(row, "ofc_cd");
        formObj.gubun.value = "RE";
        
        formObj.param1.value = arOfcCd;
        formObj.target = "frmHidden";
        formObj.action = "ESM_AGT_0042FR.do";
        formObj.submit();

    } 
	// 2007.06.18 추가
	
	//Apply Date 변경시, mon_xch_rt를 재설정한다.
	/*
	if(colNm == "aply_dt"){
		sRow = row;
		var aply_dt = sheetObj.CellValue(row, "aply_dt");
		formObj.param1.value = sheetObj.CellValue(row, "ofc_cd");
		formObj.gubun.value = "IN";
		
		formObj.param2.value = aply_dt;
	    formObj.target = "frmHidden";
	    formObj.action = "ESM_AGT_0042FR2.do";
	    formObj.submit();
	}
	*/
	//Cur 변경시 , xchRt를 재설정 한다.
	if(colNm == "aply_dt" || colNm == "curr_cd"){
	    sRow = row;
	    var curr = sheetObj.CellValue(row, "curr_cd");
	    var aplyDt = sheetObj.CellValue(row, "aply_dt");
	    formObj.gubun.value = "IN";
	    
	    formObj.param2.value = aplyDt;
	    formObj.param9.value = curr;
	    formObj.target = "frmHidden";
	    formObj.action = "ESM_AGT_0042FR2.do";
	    formObj.submit();
	    
	}
	
	//LCL AMT 변경시, USD AMT를 재계산한다.
	if(colNm == "act_locl_comm_amt"){
		sheetObj.CellValue2(row, "act_comm_amt") = sheetObj.CellValue(row, "act_locl_comm_amt") / sheetObj.CellValue(row, "mon_xch_rt");
	}
	
	//USD AMT 변경시, LCL AMT를 재계산한다.
	if(colNm == "act_comm_amt"){
		sheetObj.CellValue2(row, "act_locl_comm_amt") = sheetObj.CellValue(row, "act_comm_amt") * sheetObj.CellValue(row, "mon_xch_rt");
	}
	
	formObj.gubun.value = "IN";
}

/*
 * 환율을 Grid에 세팅
 */
function setXchRt(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	var arOfcCd = formObj.param1.value;
	var mon_xch_rt = formObj.param10.value;
	
	if(mon_xch_rt == "" || mon_xch_rt == "0"){
    	ComShowMessage(ComGetMsg("AGT10026", arOfcCd, mon_xch_rt, ""));
    }else{
    	sheetObj.CellValue2(sRow, "mon_xch_rt") = mon_xch_rt;
    	
    	var act_locl_comm_amt = sheetObj.CellValue(sRow, "act_locl_comm_amt");
    	var act_comm_amt = sheetObj.CellValue(sRow, "act_comm_amt");
    	
    	if(act_comm_amt > 0){
    		sheetObj.CellValue2(sRow, "act_locl_comm_amt") = act_comm_amt * mon_xch_rt;
    	}else{
    		sheetObj.CellValue2(sRow, "act_comm_amt") = act_locl_comm_amt / mon_xch_rt;
    	}
	}
}

/*
 * 환율을 Grid에 세팅
 */
function setValue(){    
    
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	var arOfcCd = formObj.ar_ofc_cd.value;
	var mon_xch_rt = formObj.param10.value;
	
	var yyyymm = removeDash(formObj.comm_yrmon.value);
    var currCombo = "USD|" + formObj.param8.value;
	
	sheetObj.CellValue2(sRow, "vndr_cnt_cd") = formObj.param3.value;
    sheetObj.CellValue2(sRow, "vndr_seq") = formObj.param4.value;
    sheetObj.CellValue2(sRow, "vndr_lgl_eng_nm")  = formObj.param5.value;
    sheetObj.CellValue2(sRow, "ofc_cd") = formObj.param6.value;
    sheetObj.CellValue2(sRow, "comm_occr_info_cd")  = formObj.param7.value;
    sheetObj.CellValue2(sRow, "ap_ctr_cd")  = formObj.param8.value;
    sheetObj.CellValue2(sRow, "curr_cd")  = formObj.param9.value;
    sheetObj.CellValue2(sRow, "mon_xch_rt") = formObj.param10.value;
    sheetObj.CellValue2(sRow, "vvd")   = "CNTC" + yyyymm.substring(2,6) + "MM";
    sheetObj.CellValue(sRow, "aply_dt") = ComGetNowInfo();
    sheetObj.SumText(0,1) = "";
    sheetObj.SumText(0,4) = "TOTAL";
    sheetObj.SelectCell(sRow, "otr_comm_acct_ctnt");
    
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
//        if (!isNumber(iPage)) {
//            return false;
//        }

        switch(sAction) {
            case IBSEARCH:
                if(ar_ofc_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }
                break;

            case IBSAVE:
                if(ar_ofc_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }

                var cnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");
                if(cnt < 1){
                    ComShowMessage(ComGetMsg("AGT10010", "", "", ""));
                    return false;
                }
                break;

			case IBSEARCH_ASYNC03:	//Request
				if(ar_ofc_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }
                
                //상태 체크
				var rows = sheetObj.RowCount;
				for(var i=0; i<rows; i++) {
					if(sheetObj.CellValue(i+1,"chk") == 1){
				    	status = sheetObj.CellValue(i+1,"comm_proc_sts_cd");
				    	if(status != "CS" && status != "CA"){
				    		ComShowMessage(ComGetMsg("AGT10028", i+1, "Request", ""));
							return false;
						}
		     		}
		  		}
		  		break;

            case IBINSERT:
                if(ar_ofc_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
                    formObj.ar_ofc_cd.focus();
                    return false;
                }
                break;
        }
    }

    return true;
}

/**
 * 시트에서 Biz 공통 팝업 호출
 * - ComOpenPopup() 호출 : row, col 정보를 Parameter로 전달  
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var formObj = document.form;

	//Vendor Popup Click
	if (sheetObj.ColSaveName(col) == "vndr_seq") {
        var vndr_cd = sheetObj.CellValue(row,col);
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
        var classId = "COM_ENS_0C1";
	    var param = '?vndr_cd=' + vndr_cd + '&ofc_cd=N';
	    var chkStr = dispaly.substring(0,3);          
        if(chkStr == "1,0") {
        	//Radio PopUp  
           	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 705, 470, 'getESM_AGT_0042_1', dispaly, true, false, row, col, 0);
        } 
        /*
        else if(chkStr == "0,1") {
            //CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
        	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_5', dispaly, sheetIdx, row, col);
        } else if(chkStr == "0,0") {
           	//Row 선택 PopUp
        	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_6', dispaly, row, col);
        } else if(chkStr == "1,1"){
           	showErrMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
           	return;
        } else {
           	showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
           	return;
        }
        */
    }else if (sheetObj.ColSaveName(col) == "ofc_cd") {
        var ofc_cd = sheetObj.CellValue(row,col);
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
        var classId = "COM_ENS_071";
        var sheet = "1";
        var ofc_pts_cd = "N";
    	var param = '?sheet='+sheet+'&classId='+classId+'&ofc_cd='+ofc_cd+"&ofc_pts_cd="+ofc_pts_cd;    	
	    var chkStr = dispaly.substring(0,3);          
        
        if(chkStr == "1,0") {
        	//Radio PopUp  
           	ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 470, 'getESM_AGT_0042_2', dispaly, true, false, row, col);
        	//ComOpenPopup('/hanjin/ESM_AGT_0047.do' + param, 770, 470, '', dispaly, true, false, row, col);
        } 
        /*
        else if(chkStr == "0,1") {
            //CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
        	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_5', dispaly, sheetIdx, row, col);
        } else if(chkStr == "0,0") {
           	//Row 선택 PopUp
        	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_6', dispaly, row, col);
        } else if(chkStr == "1,1"){
           	showErrMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
           	return;
        } else {
           	showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
           	return;
        }
        */
    }
	
}

/**
 * Vendor : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getESM_AGT_0042_1(rowArray, row, col, sheetIdx) {
    var sheetObj = sheetObjects[0];
    sRow = row;
	var colArray = rowArray[0];
	sheetObj.CellValue2(row, col) = colArray[2];
	sheetObj.CellValue2(row, "vndr_cd") = colArray[7];
	sheetObj.CellValue2(row, "vndr_seq") = colArray[2];
	sheetObj.CellValue2(row, "vndr_lgl_eng_nm") = colArray[4];
}

/**
 * COM_ENS_071 : 팝업에서 Check로 한개 선택을 한경우..
 */
function getESM_AGT_0042_2(rowArray, row, col) {
 	
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
    var arrayLen = rowArray.length;
    var cellVal = "";
    sRow = row;

    var colArray = rowArray[0];
	sheetObj.CellValue2(row, "ofc_cd") = colArray[3];
//	sheetObj.CellValue2(row, "vndr_lgl_eng_nm") = colArray[4];

//	if(!validateForm(sheetObj,formObj,IBINSERT)) return false;

    var arOfcCd = sheetObj.CellValue(row, "ofc_cd");
    formObj.gubun.value = "RE";
    
    formObj.param1.value = arOfcCd;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0042FR.do";
    formObj.submit();

}
