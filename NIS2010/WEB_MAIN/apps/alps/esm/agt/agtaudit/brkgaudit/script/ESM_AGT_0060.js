/* 
 * 공통전역변수
 */
var sheetObjects = new Array();
var sheetCnt = 0;
var ifOptVal = "BF";
var CurrentRow = 0;

/* 
 * RD
 */
var rdObjects = new Array();
var rdCnt = 0;

/** 
 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
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
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
	    //시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		//IBSheet 초기화
		initSheet(sheetObjects[i],i+1);
	    
	    //마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// FROM ~ TO 날짜 세팅	
	var formObj = document.form;
	var today = ComGetNowInfo();
	var frday = ComGetDateAdd(null, "D", -7);
	formObj.search_dt_fr.value = frday;
	formObj.search_dt_to.value = today;
	formObj.eff_date.value = today;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(10);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(26, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "CHK|STS|AGMT Customer|AGMT Customer|AGMT Customer|CNT|AMT|VAT|TOT AMT|vndrSeq|AP OFC|CSR NO|I/F Date|I/F Remark|RCV Remark|IF Flag|RCV Flag|Pay AMT|Pay Date|Check No|Method";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,     30,    daCenter,  false,    "chk",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtHiddenStatus, 	   30,    daCenter,  false,    "ibflag",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "fwdr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "vndr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         200,   daLeft,    true,     "fwdr_name", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum,      30,    daRight,   false,    "tot_cnt", false,    "",         dfInteger,  0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum,     70,    daRight,   true,     "net_amt", false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtAutoSum,     50,    daRight,   true,     "vat",    false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtAutoSum,      80,    daRight,   false,    "tot_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  true,     "vndr_seq",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "ap_ofc_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         140,   daCenter,  true,     "csr_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,     "if_date",   false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         400,   daLeft,    true,     "if_rsn",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,         400,   daLeft,    true,     "rcv_rsn", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtHidden,       50,    daLeft,    true,     "if_flg",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,       50,    daLeft,    true,     "rcv_flg", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daRight,   true,     "pay_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daCenter,  true,     "pay_dt",  false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daLeft,    true,     "ftu_use_ctnt1",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daLeft,    true,     "pay_mzd_lu_cd", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "bkg_no", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "bkg_cre_dt", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "VNDR_TERM_NM", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "COA_INTER_COMPY_CD", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "INV_DESC", false,    "",         dfNone,     0,          false,      false);
				CountPosition = 0;
			}
			break;
			
		case 2:      //sheet2 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(10);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
				
			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(11, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "F.F|VNDR|BL NO|REF NO|I/F AMT|Type|Rate|BKG NO|BKG STS|SEQ|Remark";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    70,    daCenter,  true,     "fwdr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    50,    daCenter,  true,     "vndr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    100,   daCenter,  false,    "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    100,   daCenter,  false,    "cmpn_ref_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 70,    daRight,   false,    "act_if_comm_amt",  false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,    50,    daCenter,  false,    "cmpn_type",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    50,    daRight,   false,    "cmpn_bkg_rt",   false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,    90,    daCenter,  false,    "bkg_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "bkg_sts_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  40,    daCenter,  false,    "cmpn_seq",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    300,   daLeft,    false,    "comm_proc_rslt_rsn",false,    "",         dfNone,     0,          false,      false);
				CountPosition = 0;
			}
			break;
			
		case 3:     	//sheet3 init
            with (sheetObj) {
                //높이 설정
                style.height = GetSheetHeight(10);
                
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
                InitColumnInfo(15, 1, 0, true);

                //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                var HeadTitle = "title|csr no|office|prpd by|pay to|csr type|desc|pay grp|evi tp|due date|asa no|inv dt|currcd|amt|apprd" ;
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_title",    false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_csr_no",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_office",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_prpd_dy",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_pay_to",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_csr_type", false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_desc",     false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_pay_grp",  false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_evi_tp",   false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_due_dt",   false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_asa_no",   false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_inv_dt",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_curr_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_apprd_by", false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_amt",      false,    "",         dfNone,     0,          false,      false);
            }
            break; 

        case 4:      //sheet4 init
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(10);
                
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
                InitColumnInfo(9, 1, 0, true);

                //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, false, true, false, false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                var HeadTitle = "count|char of account|account name|gl date|city|inv no|desc|debit|credit" ;
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_seq",      false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_cht_acct", false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_acct_nm",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_gl_dt",    false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_city",     false,    "",         dfNone,     2,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_inv_no",   false,    "",         dfNone,     2,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_desc",     false,    "",         dfNone,     2,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_debit",    false,    "",         dfNone,     2,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_credit",   false,    "",         dfNone,     2,          false,      false);                                      
            }
            break;    
                              
		case 5:      //sheet5 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(10);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "SEQ|CSR No|Vendor|CUR|Amount|Desc";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "seq",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "csr_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "vendor", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "cur",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "amount", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "vendor_nm",   false,    "",         dfNone,     0,          false,      false);
				CountPosition = 0;
			}
			break;
		
		case 6:      //sheet1 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(10);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;
				
			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(23, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "CHK|STS|Freight Forwarder|Vendor|Freight Forwarder Name|CSR NO|BKG_NO|BL_NO|CNT|AMT|VAT|TOT AMT|vndrSeq|AP OFC|I/F Date|I/F Remark|RCV Remark|IF Flag|RCV Flag|Pay AMT|Pay Date|Check No|Method";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,     30,    daCenter,  false,    "chk",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtHidden, 	   30,    daCenter,  false,    "ibflag",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "fwdr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "vndr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         200,   daLeft,    true,     "fwdr_name", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         140,   daCenter,  true,     "csr_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         90,    daCenter,  false,    "bkg_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         90,    daCenter,  false,    "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         30,    daRight,   false,    "tot_cnt", false,    "",         dfInteger,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         80,    daRight,   false,    "net_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,         80,    daRight,   false,    "vat", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,         80,    daRight,   false,    "tot_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,     "vndr_seq",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         60,    daCenter,  false,     "ap_ofc_cd",  false,    "",         dfNone,     0,          false,      false);				
				InitDataProperty(0, cnt++, dtData,         80,    daCenter,  false,     "if_date",   false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         400,   daLeft,    false,     "if_rsn",  false,    "",         dfNone,     0,          true,       false);
				InitDataProperty(0, cnt++, dtData,         400,   daLeft,    false,     "rcv_rsn", false,    "",         dfNone,     0,          true,       false);
				InitDataProperty(0, cnt++, dtHidden,       50,    daLeft,    false,     "if_flg",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,       50,    daLeft,    false,     "rcv_flg", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daRight,   false,     "pay_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daCenter,  false,     "pay_dt",  false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daLeft,    false,     "ftu_use_ctnt1",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daLeft,    false,     "pay_mzd_lu_cd", false,    "",         dfNone,     0,          false,      false);
				//CountPosition = 0;
			}
			break;
	}
}

/** 
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 */
function processButtonClick(){
	var formObject = document.form;
	var sheetObject  = sheetObjects[0];
	var sheetObject6  = sheetObjects[5];
	var rdObject = rdObjects[0];

//	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_request":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03);
				break;

			case "btn_cancel":
				doActionIBSheet(sheetObject,formObject,IBDELETE);
				break;
				
			case "btn_downexcel":
				doActionIBSheet(sheetObject6,formObject,IBDOWNEXCEL);				
				break;

			case "btn_print":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC04);				
				break;

			case "btn_csrprint":
				doActionIBSheet(sheetObject,formObject,RDPRINT);				
				break;

			case "btn_popup":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
				break;

			case "btn_clear":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);
				break;
				
			case "btn_cal_fr":
				var cal = new ComCalendar();
				cal.select(formObject.search_dt_fr, 'yyyy-MM-dd');
				break;

			case "btn_cal_to":
				var cal = new ComCalendar();
				cal.select(formObject.search_dt_to, 'yyyy-MM-dd');
				break;

			case "btn_eff_dt":
				var cal = new ComCalendar();
				cal.select(formObject.eff_date, 'yyyy-MM-dd');
			
			// 2008.09.18 권상준 추가 (Approval & Request 상태에서 승인권자 변경 가능하도록 Approval Step 팝업 호출)	
            case "btng_editapprovalstep":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC05);
				break;
		} // end switch
		
//	}catch(e) {
//		if( e == "[object Error]") {
//			ComShowMessage(ComGetMsg("COM12111", "", ""));
//		} else {
//			ComShowMessage(e);
//		}
//	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
	    case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			    if(formObj.bl_no.value.trim().length > 0){
		    		setBlNoRetrieve(formObj.bl_no);
		    	}
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0060GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,4) = "TOTAL";
			sheetObj.CellAlign(sheetObj.LastRow,4) = daCenter;
			
			sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			
			formObj.if_cnt.selectedIndex = 0;
			break; 
            			
		case IBSEARCH_ASYNC03: //Approval Request
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESM_AGT_0060GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj1 = sheetObjects[0];
			var sheetObj2 = sheetObjects[1];
			
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0060GS.do", agtQryStr(formObj));
			
//			sheetObj1.RemoveAll();
//			sheetObj2.RemoveAll();
			currentRow = 0;
            break;
            
		case IBDELETE:	//Cancel
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESM_AGT_0060GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			break;   

		case IBDOWNEXCEL:	//Down Excel
			//if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch4Post("ESM_AGT_0060GS5.do", agtQryStr(formObj));
			
//			sheetObj.SpeedDown2Excel(-1);
            sheetObj.Down2Excel(-1);
			break;
		
		case IBSEARCH_ASYNC04:  //Print
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			var sheetObj5 = sheetObjects[4];
   	        
			formObj.f_cmd.value = SEARCH01;
			//sheetObj5.DoSearch4Post("ESM_AGT_0060GS4.do", agtQryStr(formObj));
			var sXml = sheetObj5.GetSearchXml("ESM_AGT_0060GS4.do", agtQryStr(formObj));
			
			sheetObj5.LoadSearchXml(sXml);
			
			//보고서출력
			var fromObj = new Array();
			var rdObj  	= new Array();
			var parmObj = new Array();
			
            fromObj[0] = formObj;  //RD로 보내기 위해 배열로담는다
            rdObj[0] = sheetObj5; //sheet를 RD로 보내기 위해 배열로 담는다
            //RD_path  = "http://127.0.0.1:7001/hanjin/";
            //RD_path = "http://kov440h.hanjin.com:9300/hanjin/";

            // RD 로 보내기 위한 설정
            parmObj[0] = "1";
            parmObj[1] = "";
            parmObj[2] = "N";
            parmObj[3] = RD_path + "apps/alps/esm/agt/agtaudit/brkgaudit/report/ESM_AGT_0018.mrd"; //RD 화면
            parmObj[4] = rdObj;
            parmObj[5] = fromObj;
            rdObjModaless(RdReport, parmObj, 700, 700);	
			break;

		case RDPRINT:	//CSR Print
			if(!validateForm(sheetObj,formObj,sAction))	return false;

			var sheetObj3 = sheetObjects[2];
   	        var sheetObj4 = sheetObjects[3];
   	        
			//체크된 첫번째행의 번호를 읽어와서 Hidden Input에 담는다.
			var sRow = sheetObj.FindCheckedRow("chk");
			var arrRow = sRow.split("|");
            formObj.h_csrno.value = sheetObj.CellValue(arrRow[0], "csr_no");
            
			//보고서출력을 위해 AP_INV_HDR, AP_INV_DTRB 정보 조회
			formObj.f_cmd.value = PRINT;
			var sXml = sheetObj3.GetSearchXml("ESM_AGT_0060GS3.do", agtQryStr(formObj));
			var arrXml = sXml.split("|$$|");
//			sheetObj3.LoadSearchXml(sXml);
//			var sxml1 = sheetObj3.EtcData("sxml1");
				
   	        
   	        //ETC데이터를 IBSheet에 세팅한다.
   	        sheetObj.RemoveEtcData();         
	        sheetObj3.LoadSearchXml(arrXml[0]);
	        sheetObj4.LoadSearchXml(arrXml[1]);
   	        
			//보고서출력
			var fromObj = new Array();
			var rdObj  	= new Array();
			var parmObj = new Array();
			
            fromObj[0] = formObj;  //RD로 보내기 위해 배열로담는다
            rdObj[0] = sheetObjects[2]; //sheet를 RD로 보내기 위해 배열로 담는다
            rdObj[1] = sheetObjects[3];
            //RD_path  = "http://127.0.0.1:7001/hanjin/";
            //RD_path = "http://kov440h.hanjin.com:9300/hanjin/";

            // RD 로 보내기 위한 설정
            parmObj[0] = "1";
            parmObj[1] = "";
            parmObj[2] = "N";
            parmObj[3] = RD_path + "apps/alps/esm/agt/agtaudit/agtaudit/report/ESM_AGT_0017A.mrd"; //RD 화면
            parmObj[4] = rdObj;
            parmObj[5] = fromObj;
            rdObjModaless(RdReport, parmObj, 700, 700);	
			break;

		case IBSEARCH_ASYNC01: //Approval Step Popup
			var v_ofc_cd = formObj.ofcCd.value;
			var v_sub_sys_cd = "AGT";
			var v_apro_step = encodeURIComponent(formObj.apro_step.value);
       	    var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
			ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
	        /*
			var cust_cd = sheetObj.CellValue(1, 6);
	        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
	        var classId = "COM_ENS_0T1";
		    var param = '?cust_cd=' + cust_cd;
			var chkStr = dispaly.substring(0,3) ;         
	        
	        if(chkStr == "1,0") {
	        	//Radio PopUp  
	           	comPopupInSheet('/hanjin/COM_ENS_0T1.do' + param, 620, 450, 'getCOM_ENS_0T1_1', '0,1', true);
	        } 
	        else if(chkStr == "0,1") {
	            //CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
	        	comPopupInSheet('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getESM_AGT_025_2', dispaly, sheetIdx, row, col);
	        } else if(chkStr == "0,0") {
	           	//Row 선택 PopUp
	        	comPopupInSheet('/hanjin/COM_ENS_041.do' + param, 770, 470, 'getESM_AGT_025_3', dispaly, row, col);
	        } else if(chkStr == "1,1"){
	           	showErrMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
	           	return;
	        } else {
	           	showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
	           	return;
	        }*/
			break;

		case IBSEARCH_ASYNC02: //Clear
			formObj.apro_step.value = "";
			break;
		
		// 2008.09.18 권상준 추가 (Approval & Request 상태에서 승인권자 변경 가능하도록 Approval Step 팝업 호출)	
		case IBSEARCH_ASYNC05: //popup
			if (sheetObj.RowCount > 0) 
			{
			    if(!validateForm(sheetObj,formObj,sAction))	return false;
			    var sRow = sheetObj.FindCheckedRow("chk");
    			var arrRow = sRow.split("|");

//				var param = '?mode=csr&csr_no='+sheetObj.CellValue(arrRow[0],'csr_no')+'&classId=COM_ENS_0T1';
				var param = '?mode=save&csr_no='+sheetObj.CellValue(arrRow[0],'csr_no')+'&classId=COM_ENS_0T1&ofc_cd='+v_ofc_cd+'&sub_sys_cd='+v_sub_sys_cd+'&target_obj_nm=apro_step';
 				ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 550, '', 'none', true);	
			}
			break;
	}
	
	//인터페이스 오류건의 색깔 표시
	if(ifOptVal == "IF"){
		var rows = sheetObj.RowCount;
		for(var i=0; i<rows; i++){
			ifFlag = sheetObj.CellValue(i+1,"if_flg");
			rcvFlag = sheetObj.CellValue(i+1,"rcv_flg");
			
			//오류건
			if(ifFlag == "E" || rcvFlag == "E"){
				sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(255,0,0); //red
			}
			
			//인터페이스 미완료건
			if(ifFlag == ""){
				sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(0,0,255); //blue
			}
		}
	}
}

/**
 * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 해당 F.Forwarder의 상세내역을 조회한다.
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	var formObj = document.form;
	var sheetObj2 = sheetObjects[1];
	
	if(currentRow == row) return;
	currentRow = row;
	
//	if(sheetObj.CellValue(row,"chk") == 0){
//		alert(sheetObj.CellValue(row,"chk"));
//	}
	formObj.f_cmd.value = SEARCHLIST;
	formObj.vndr_seq.value = sheetObj.CellValue(row,"vndr_seq");
	formObj.fwdr.value = sheetObj.CellValue(row,"fwdr");
	formObj.csr_no.value = sheetObj.CellValue(row,"csr_no");
	formObj.ap_ofc_cd.value = sheetObj.CellValue(row,"ap_ofc_cd");
	sheetObj2.DoSearch4Post("ESM_AGT_0060GS2.do", agtQryStr(formObj));	
	sheetObj.SelectCell(row, col);
}

/**
 * 마스터 그리드에서 CSR No 컬럼을 더블클릭했을때, CSR Deatil Popup을 조회한다.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
//	var csr_no = sheetObj.CellValue(row, col);
	var csr_no = sheetObj.CellValue(row, "csr_no");
/*	
	if (sheetObj.ColSaveName(col) == "csr_no" && csr_no != "") {
		var param = "?csr_no=" + csr_no;
		//window.showModalDialog("ESM_AGT_011.do" + param, "Detail & History", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px");
        //window.showModelessDialog("ESM_AGT_011.do" + param, window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px")
		ComOpenWindowCenter("ESM_AGT_0043.do" + param, "compop3", "700", "507", false);
	}
	*/
}

/**
 * I/F Option을 변경하면, 그리드의 데이터를 초기화한다.
 */
function if_option_OnChange(obj){
	var formObj = document.form;
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	
	if(ifOptVal == obj.value){
		return;
	}else{
		ifOptVal = obj.value;
		
		sheetObj1.RemoveAll();
		sheetObj2.RemoveAll();
	}
	
	if(ifOptVal == "IF"){
		//I/F Count : disable
		formObj.if_cnt.disabled = true;
		//Radio Check
		sheetObj1.InitDataProperty(0, 0, dtRadioCheck, 30, daCenter, false, "chk", false, "", dfNone, 0, true, true);
		
		//Status : disable
		formObj.sts_option.disabled = true;
	}else{
		//I/F Count : enable
		formObj.if_cnt.disabled = false;
		//Multi Check
		sheetObj1.InitDataProperty(0, 0, dtCheckBox,   30, daCenter, false, "chk", false, "", dfNone, 0, true, true);
		
		//Status : enable
		formObj.sts_option.disabled = false;
	}
}

/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function frDate_onfocus(obj){
	delete_Char(obj,'-');	//입력값에서 '-'를 없앤다.
	obj.select();	//입력값을 전체선택한다.
}

/**
 * 날짜가 변경되면, 날짜를 검사하여 보여준다. 
 */
function frDate_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = obj.value;
		var toDt = delete_Char(formObj.toDate.value,'-');
		
		if(frDt > toDt){
			obj.value = toDt;

			//TO DATE must be greater than FROM DATE.
			ComShowMessage(ComGetMsg("COM12133", "End date", "start date", "greater"));
			obj.focus();
		}else{
			str = obj.value;
			str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
			obj.value = str;
		}
	}
}

/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function toDate_onfocus(obj){
	delete_Char(obj,'-');	//입력값에서 '-'를 없앤다.
	obj.select();	//입력값을 전체선택한다.
}

/**
 * 날짜가 변경되면, 날짜를 검사하여 보여준다. 
 */
function toDate_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = delete_Char(formObj.frDate.value,'-');
		var toDt = obj.value;
		
		if(frDt > toDt){
			obj.value = frDt;

			//TO DATE must be greater than FROM DATE.
			ComShowMessage(ComGetMsg("COM12133", "End date", "start date", "greater"));
			obj.focus();
		}else{
			str = obj.value;
			str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
			obj.value = str;
		}
	}
}

/**
 * I/F Count를 변경하면, 그리드의 Check컬럼을 건수만큼 체크한다.
 */
function if_cnt_OnChange(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];
	
	var if_cnt = formObj.if_cnt.value;
	var sRows = sheetObj.RowCount;
		
	if(if_cnt == "SEL"){
		//사용자선택건 
		sheetObj.CheckAll2("chk") = 0;
	}else{
		//나머지
		if(if_cnt >= sRows){
			sheetObj.CheckAll2("chk") = 1;
		}else{
			sheetObj.CheckAll2("chk") = 0;
	
			//선택한 건수만큼 선택하기
			for(var i=1; i<sRows; i++){
				sheetObj.CellValue2(i,"chk") = 1;
				if(i >= if_cnt) break;
			}
		}
	}
		
	sheetObj.focus();
}

/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function effDate_onfocus(obj){
	delete_Char(obj,'-');	//입력값에서 '-'를 없앤다.
	obj.select();	//입력값을 전체선택한다.
}

/**
 * 날짜가 변경되면, 날짜를 검사하여 보여준다. 
 */
function effDate_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		str = obj.value;
		str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
		obj.value = str;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//		if (!isNumber(iPage)) {
//			return false;
//		}
		
		switch(sAction) {
		    case IBSEARCH:	//Retrieve
		    	break;
		    	
		    case IBDOWNEXCEL:	//Down Excel
		    	var rCnt = sheetObj.RowCount;
		    	if(rCnt < 1){
		    		ComShowMessage(ComGetMsg("AGT10004", "", "", ""));
					return false;
				}
				break; 
				
			case IBSEARCH_ASYNC03:	//Approval Request
				if(ifOptVal != "BF"){
		    		//Can't interface. Please check I/F Option.
		    		ComShowMessage(ComGetMsg("AGT10015", "Can't interface.", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					//Please select **.
					ComShowMessage(ComGetMsg("COM12113", "row for interface", "", ""));
					return false;
				}
				
				if(apro_step.value == ""){
		    		ComShowMessage(ComGetMsg("COM12114", "Approval Step", "", ""));
		    		return false;
		    	}
				
				//AR_OFC_CD 유무 체크
				var rows = sheetObj.RowCount;
				for(var i=1; i<rows; i++) {
				    if(sheetObj.CellValue(i,"chk") == 1){
				    	apOfcCd = sheetObj.CellValue(i,"ap_ofc_cd");
				    	if(apOfcCd == ""){
				    		ComShowMessage(ComGetMsg("AGT10021", i, "", ""));
							return false;
						}
		     		}
		  		}
		    	break; 
		    
		    case IBDELETE:	//Cancel
		    	if(ifOptVal != "IF"){
		    		//Can't cancel. Please check I/F Option.
		    		ComShowMessage(ComGetMsg("AGT10015", "Can't cancel.", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					//Please select **.
					ComShowMessage(ComGetMsg("COM12113", "row for cancel", "", ""));
					return false;
				}
		    	break; 
			
			case IBSEARCH_ASYNC04:	//Print
		    	if(ifOptVal != "IF"){
		    		//Can't print REPORT. Please check I/F Option.
		    		ComShowMessage(ComGetMsg("AGT10015", "Can't print report[Brokerage Interfaced Status]", "", ""));
		    		return false;
		    	}
		    	break;
				
			case RDPRINT:	//CSR Print
		    	if(ifOptVal != "IF"){
		    		//Can't print CSR Report. Please check I/F Option.
		    		ComShowMessage(ComGetMsg("AGT10015", "Can't print report[CONSULTATION SLIP]", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1 || checkCnt > 1){
					ComShowMessage(ComGetMsg("AGT10016", "", "", ""));
					return false;
				}
				break;
				
			case IBSEARCH_ASYNC05:
			    var checkCnt = sheetObj.CheckedRows("chk");
			    
			    if(checkCnt < 1 || checkCnt > 1){
					ComShowMessage(ComGetMsg("COM12177", "", "", ""));
					return false;
				}
				
			    if(ifOptVal != "IF"){
					ComShowMessage(ComGetMsg("COM12114", "Approval Request!", "", ""));
		    		return false;
		    	}
		    	
		    	var selectValue = sheetObj.CellValue(sheetObj.SelectRow,'if_rsn');
		    	if(selectValue != "Approval Request!"){
					ComShowMessage(ComGetMsg("COM12113", "Approval Request!", "", ""));
		    		return false;
		    	}
		    	
		    	
				
			    break;
		}
	}
	
	return true;
}

/**
 * F.Forwarder 조회 팝업 열기
 */	
function openWindowCustomer(formObj) {
	//var cust_cd = "US"; // Default 셋팅
	var url = "COM_ENS_041.do";
	var width = 775;
	var height = 484;
	var func = "setForwarder";
	var display = "1,0,1";
	//url = url + "?cust_cd="+cust_cd;
	//comPopup(url, width, height, func, display, bModal, b2ndSheet);
	ComOpenPopup(url, width, height, func, display, true, false);
}

/**
 * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
 */
function setForwarder(rowArray, row, col) {
	var colArray = rowArray[0];
    	
	document.form.ff_cnt_cd.value = colArray[3];
}

/**
 * 사용자가 입력한 BL NO를 셋팅한다.
 */
function setBlNo(obj) {

    var form = document.form;
    var bl_no = obj.value.trim().toUpperCase();
    var bl_no_list = form.bl_nos.value.trim().toUpperCase();
        
    if (window.event.keyCode==13) {
        if(bl_no.length > 0) {
   
            if(bl_no_list.length > 0) {
                form.bl_nos.value = bl_no_list + "," + bl_no;
            } else {
                form.bl_nos.value = bl_no;
            }

            obj.value = "";
        }
    }
}

/**
 * BL NO가 입력이 되면 Date를 삭제해 준다.
 */
function setDateEmpty() {
    
    var form = document.form;
    var bl_no_list = form.bl_nos.value.trim().toUpperCase();

    /**
     * 사용자가 입력한 BL NO를 셋팅한다.
     */
}
function setBlNos(obj) {
     var form = document.form;
     form.bl_nos.value = obj.value.trim().toUpperCase();
}
/**
 * 사용자가 Retrieve 클릭시 BL NO를 셋팅 후 조회.
 */
function setBlNoRetrieve(obj) {
    var form = document.form;
    var bl_no = obj.value.trim().toUpperCase();
    var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if(bl_no_list.length > 0) {
            form.bl_nos.value = bl_no_list + "," + bl_no;
        } else {
            form.bl_nos.value = bl_no;
        }

        obj.value = "";
}
/**
 * 화면 VAT 항목에 FOCUS가 왔을때 처리
 */
function invTaxRt_onfocus(obj){
	obj.select();
}
/**
 * 화면 VAT 항목에 FOCUS가 나갈때 유효성검증 프로세스 처리
 */
function invTaxRt_validate(obj){
	var formObj = document.form;
  	
  	if(!ComIsNumber(obj,'.')){
 		ComShowMessage(ComGetMsg("AGT10003", "", "", ""));
 		obj.value = "0.00";
 		formObj.inv_tax_rt.focus();
 		formObj.inv_tax_rt.select();
 		return false;
}

  	var vat = parseFloat(obj.value);
  	if(vat < 0 || vat >= 100){
		ComShowMessage(ComGetMsg("AGT10003", "", "", ""));
		obj.value = "0.00";
     		formObj.inv_tax_rt.focus();
     		formObj.inv_tax_rt.select();
  		return false
  	}
  
 }