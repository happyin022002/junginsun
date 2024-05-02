/* 
 * 공통전역변수
 */
var sheetObjects = new Array();
var sheetCnt = 0;
var currentRow = 0;

/* 
 * RD
 */
var rdObjects = new Array();
var rdCnt = 0;

/* 
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
	formObj.inv_dt.value = today;
	formObj.ar_ofc_cd.focus();

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
				InitColumnInfo(21, 3, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, true, true, false, false) ;
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Status|No.|CHK|Audit No|Invoice No|Subj.OFC|VVD Cnt|Cur|Net AMT|VAT|TTL AMT|CSR No|I/F Date|I/F Remark|RCV Remark|IF Flag|RCV Flag|Pay AMT|Pay Date|Check No|Method";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,    30,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtSeq,      30,    daCenter,  true,     "seq",    false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtCheckBox, 40,    daCenter,  true,     "chk",    false,    "",         dfNone,     0,          true,        false);
				InitDataProperty(0, cnt++, dtData,     90,    daCenter,  true,     "comm_apro_no", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     90,    daCenter,  true,     "inv_no",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     60,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     60,    daCenter,  true,     "vvd_cnt", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,     "curr_cd",   false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     70,    daRight,   true,     "net_amt", false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,     50,    daRight,   true,     "vat",    false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,     70,    daRight,   true,     "tot_amt", false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,     140,   daCenter,  true,     "csr_no",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     80,    daCenter,  true,     "ac_if_dt",   false,    "",         dfDateYmd,  0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     400,   daLeft,    true,     "if_flg_msg",  false,    "",         dfNone,     0,          false,        false);
				InitDataProperty(0, cnt++, dtData,     400,   daLeft,    true,     "rcv_err_flg_msg", false,    "",         dfNone,     0,          false,        false);
				InitDataProperty(0, cnt++, dtHidden,   50,    daLeft,    true,     "if_flg",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtHidden,   50,    daLeft,    true,     "rcv_err_flg", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     100,   daRight,   true,     "pay_amt", false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,     100,   daCenter,  true,     "pay_dt",  false,    "",         dfDateYmd,  0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     100,   daLeft,    true,     "ftu_use_ctnt1",false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     100,   daLeft,    true,     "pay_mzd_lu_cd", false,    "",         dfNone,     0,          false,       false);
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
				InitColumnInfo(10, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "VVD|BL NO|BKG NO|AGN CD|TYPE|AR OFC|AP OFC|BKG STS|I/F AMT";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    90,    daCenter,  true,     "vvd",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    100,   daCenter,  true,     "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    100,   daCenter,  true,     "bkg_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    90,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
				//InitDataProperty(0, cnt++, dtHidden,  70,    daCenter,  false,    "seq",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    90,    daCenter,  false,    "tp",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "ar_ofc_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "ap_ofc_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "bkg_sts_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   false,    "if_amt",  false,    "",         dfFloat,    2,          false,      false);
				CountPosition = 0;
			}
			break;
			
		case 3:     	//sheet3 init
            with (sheetObj) {
                //높이 설정
                style.height = GetSheetHeight(3);
                
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
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_prpd_by",  false,    "",         dfNone,     0,          false,      false);
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
	}
}

/* 
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 */
function processButtonClick(){
	var formObject = document.form;
	var sheetObject  = sheetObjects[0];
	var sheetObject2  = sheetObjects[1];
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
				
			case "btng_downexcel1":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			
			case "btng_downexcel2":
				doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
				break;

			case "btn_print":
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

			case "btn_inv_dt":
				var cal = new ComCalendar();
				cal.select(formObject.inv_dt, 'yyyy-MM-dd');
				break;
			
			// 2008.09.18 권상준 추가 (Approval & Request 상태에서 승인권자 변경 가능하도록 Approval Step 팝업 호출)	
            case "btng_editapprovalstep":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC04);
				break;
            case "check_apply":
				cnt_Check();
				break;
				
			case "uncheck_apply":
				cnt_Uncheck();
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

/*
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
	    case IBSEARCH:	//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;

			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0017GS.do", agtQryStr(formObj));
			sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			break;

		case IBSEARCH_ASYNC03: //Approval Request
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESM_AGT_0017GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
            break;
            
		case IBDELETE:	//Cancel
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESM_AGT_0017GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			break;
			
		case IBDOWNEXCEL:	//Down Excel
			sheetObj.SpeedDown2Excel(-1);
			break;

		case RDPRINT:	//Print
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			//체크된 첫번째행의 번호를 읽어와서 Hidden Input에 담는다.
			var sRow = sheetObj.FindCheckedRow("chk");
			var arrRow = sRow.split("|");
            formObj.h_csrNo.value = sheetObj.CellValue(arrRow[0], "csr_no");
            var currCd = sheetObj.CellValue(arrRow[0], "curr_cd");
			
			//보고서출력을 위해 AP_INV_HDR, AP_INV_DTRB 정보 조회
			formObj.f_cmd.value = PRINT;
			var sXml = sheetObj.GetSearchXml("ESM_AGT_0017GS2.do", agtQryStr(formObj));
			var arrXml = sXml.split("|$$|");

   	        var sheetObj3 = sheetObjects[2];
   	        var sheetObj4 = sheetObjects[3];
   	        
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
            if(currCd == "JPY" || currCd == "KRW"){
	            parmObj[3] = RD_path + "apps/alps/esm/agt/agtaudit/agtaudit/report/ESM_AGT_0017B.mrd"; //RD 화면
	        }else{
	            parmObj[3] = RD_path + "apps/alps/esm/agt/agtaudit/agtaudit/report/ESM_AGT_0017A.mrd"; //RD 화면
	        }
            parmObj[4] = rdObj;
            parmObj[5] = fromObj;
            rdObjModaless(RdReport, parmObj, 700, 700);	
            //ComOpenRDPopup(RdReport, parmObj, 700, 700);	
            break;

		case IBSEARCH_ASYNC01: //popup
			var v_ofc_cd = formObj.ofcCd.value;
			var v_sub_sys_cd = "AGT";
			var v_apro_step = formObj.apro_step.value;
       	    var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
			ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true, false);
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
			
		// 2008.09.18 권상준 추가 (Approval & Request 상태에서 승인권자 변경 가능하도록 Approval Step 팝업 호출)	
		case IBSEARCH_ASYNC04: //popup
			if (sheetObj.RowCount > 0) 
			{
//			    if(!validateForm(sheetObj,formObj,sAction))	return false;
			    var sRow = sheetObj.FindCheckedRow("chk");
    			var arrRow = sRow.split("|");
    			var v_sub_sys_cd = "AGT";
    			var v_apro_step = formObj.apro_step.value;

//				var param = '?mode=csr&csr_no='+sheetObj.CellValue(arrRow[0],'csr_no')+'&classId=COM_ENS_0T1';
    			var param = '?mode=save&csr_no='+sheetObj.CellValue(arrRow[0],'csr_no')+'&classId=COM_ENS_0T1&ofc_cd='+v_ofc_cd+'&sub_sys_cd='+v_sub_sys_cd+'&target_obj_nm=apro_step';
 				ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 550, '', 'none', true);	
			}
			break;	

		case IBSEARCH_ASYNC02: //clear
			formObj.apro_step.value = "";
			break;
	}
	
	//인터페이스 오류건의 색깔 표시
	var sts = formObj.if_option.value;
	if(sts == "IF"){
		var rows = sheetObj.RowCount;
		for(var i=0; i<rows; i++){
			ifFlag = sheetObj.CellValue(i+1,"if_flg");
			rcvFlag = sheetObj.CellValue(i+1,"rcv_err_flg");
			
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

/*
 * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	var formObj = document.form;
	var sheetObj2 = sheetObjects[1];
	
	if(currentRow == row) return false;
	currentRow = row;
	
	formObj.f_cmd.value = SEARCHLIST;
	formObj.comm_apro_no.value = sheetObj.CellValue(row,"comm_apro_no");
	sheetObj2.DoSearch4Post("ESM_AGT_0017GS.do", agtQryStr(formObj));	
	sheetObj.SelectCell(row, col);
}

/*
 * 마스터 그리드에서 CSR No 컬럼을 더블클릭했을때, CSR Deatil Popup을 조회한다.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var csrNo = sheetObj.CellValue(row, col);

	if (sheetObj.ColSaveName(col) == "csr_no" && csrNo != "") {
		var param = "?csr_no=" + csrNo;
        //window.showModalDialog("ESM_AGT_011.do" + param, "Detail & History", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px");
        //window.showModelessDialog("ESM_AGT_011.do" + param, window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px")
		ComOpenWindowCenter("ESM_AGT_0043.do" + param, "compop3", "700", "507", false);
	}
}

/**
 * A/R Office를 변경하면, 해당 Subject Office 리스트 조회하기
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.param5.value = "SUBOFC";
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0017FR.do";
    formObj.submit();
    
    var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	currentRow = 0;
}

/**
 * Subject Office를 변경하면, 해당 ASA No 리스트 조회하기
 */
function agn_cd_OnChange(obj){
    var formObj = document.form;
    formObj.param1.value = "asaNo";
    formObj.param2.value = "";
    formObj.param3.value = "asa_no";
    formObj.param4.value = obj.value;
    formObj.param5.value = "ASANO";
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0017FR.do";
    formObj.submit();
    
    var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	currentRow = 0;
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

/**
 * I/F Option를 변경하면, Grid를 초기화한다.
 */
function if_option_OnChange(obj){
    var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	currentRow = 0;
}

/**
 * Exp. Type Option를 변경하면, Grid를 초기화한다.
 */
function exp_type_OnChange(obj){
    var formObj = document.form;
    var aproStep = formObj.aproStep.value;
    var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	currentRow = 0;
	if(formObj.exp_type.value == "G"){
	    formObj.apro_step.value = aproStep;
	}else{
	    formObj.apro_step.value = "";
	}
}

/**
 * ASA No를 변경하면, ASA TO_DATE를 Effect Date로 세팅한다.
 */
function asa_no_OnChange(){
	var formObj = document.form;
	var idx = formObj.asa_no.selectedIndex;
	if(idx >= 0){
		//ASA No의 TO_DATE로 세팅
	    var asaNo = formObj.asa_no[idx].text;
    	var split = asaNo.split('~');
    	var temp = ComReplaceStr(split[1], ')', ' ');
    	temp = ComReplaceStr(temp, '/', '-');
    	temp = ComReplaceStr(temp, ' ', '');
    	formObj.inv_dt.value = temp;
    }else{
    	//오늘 날짜로 세팅
    	formObj.inv_dt.value = ComGetNowInfo();
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
		    	if(ar_ofc_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
		    		formObj.cbArOfcCd.focus();
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "Subject Office", "", ""));
		    		formObj.agn_cd.focus();
		    		return false;
		    	}
		    	break;
		    	
			case IBSEARCH_ASYNC03:	//Approval Request
				if(if_option.value != "AS"){
					//Please check **.
					ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
		    		return false;
		    	}
			
				if(ar_ofc_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)A/R Office", "", ""));
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)Subject Office", "", ""));
		    		return false;
		    	}
		    	
		    	if(offsetFlag.value == "Y" && asa_no.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", " ASA No", "", ""));
		    		formObj.asa_no.focus();
		    		return false;
		    	}
		    	
		    	if(apro_step.value == ""){
//		    		ComShowMessage(ComGetMsg("COM12114", "Approval Step", "", ""));
		    		ComShowMessage(ComGetMsg("AGT10034", "", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");s
				if(checkCnt < 1){
					ComShowMessage(ComGetMsg("COM12113", "row for approval request", "", ""));
					return false;
				}
		    	break; 
		    
		    case IBDELETE:	//Cancel
		    	if(if_option.value != "IF"){
					ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
		    		return false;
		    	}
			
				if(ar_ofc_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)A/R Office", "", ""));
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)Subject Office", "", ""));
		    		return false;
		    	}
		    	if(agn_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)Subject Office", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					ComShowMessage(ComGetMsg("COM12113", "row for cancel", "", ""));
					return false;
				}else{
					var sRows = sheetObj.RowCount;
					
					for(var i=0; i<sRows; i++){
						if_flg_msg = sheetObj.CellValue(i+1,"if_flg_msg");
						chk = sheetObj.CellValue(i+1,"chk");
						
						if(chk == "1" && if_flg_msg == "Already Interfaced"){
							ComShowCodeMessage("AGT00091", "[" + sheetObj.CellValue(i+1,"csr_no") + "] CSR No", "", "");
							return false;
						}
					}
					
				}
		    	break; 

		    case RDPRINT:	//Print
		    	if(if_option.value != "IF"){
					ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
		    		return false;
		    	}
			
				var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1 || checkCnt > 1){
					ComShowMessage(ComGetMsg("AGT10016", "", "", ""));
					return false;
				}
				break;
			
			case IBSEARCH_ASYNC04:
			    var checkCnt = sheetObj.CheckedRows("chk");
			    
			    if(checkCnt < 1 || checkCnt > 1){
					ComShowMessage(ComGetMsg("COM12177", "", "", ""));
					return false;
				}
			    
			    if(if_option.value != "IF"){
					ComShowMessage(ComGetMsg("COM12114", "Approval Request!", "", ""));
		    		return false;
		    	}
		    	
		    	var selectValue = sheetObj.CellValue(sheetObj.SelectRow,'if_flg');
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
	 * check 하고싶은 시작 과 끝 건수만큼 체크한다.
	 */
	function cnt_Check(){
		var formObj = document.form;
		var sheetObj  = sheetObjects[0];
		
		var chkStart = formObj.chkStart.value;
		var chkEnd = formObj.chkEnd.value;

		var sRows = sheetObj.RowCount;
		
		if(sRows > 0){
		    if(chkStart == "" || chkStart == null){
		    	ComShowCodeMessage("AGT10001", "Check Start Row", "", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}
	    	
	    	if(chkStart == "0"){
	    		ComShowCodeMessage("AGT10001", "number 1 over", "", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}
	    	
	    	if(chkEnd == "" || chkEnd == null){
	    		ComShowCodeMessage("AGT10001", "Check End Row", "", "");
	    		formObj.chkEnd.focus();
	    		return false;
	    	}

	    	
	    	var numChkStart	= parseInt(chkStart);
	    	var numChkEnd	= parseInt(chkEnd);
	    	if(numChkStart > numChkEnd){
	    		ComShowCodeMessage("COM12142", "Check Start Row", "Check End Row", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}
	    	
	    	if(numChkEnd > sheetObj.RowCount){
	    		ComShowCodeMessage("AGT10001", "number less than "+ sheetObj.RowCount+" or equal", "", "");
	    		formObj.chkEnd.focus();
	    		return false;
	    	}
	    	
	    	if(numChkStart > sheetObj.RowCount){
	    		ComShowCodeMessage("AGT10001", "number less than "+ sheetObj.RowCount+" or equal", "", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}
	    	
	    	if(numChkStart > sheetObj.RowCount){
	    		ComShowCodeMessage("AGT10001", "number less than end row or equal", "", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}

	    	var i = numChkStart;
	    	var max = numChkEnd;
	    	var checkd = "";
	    	sheetObj.Redraw = false;
	    	while ( i <= max )
	        {
	         checkd = checkd + "1\r\n";
	         sheetObj.RowStatus(i++) = "U";
	        }
	        sheetObj.Paste2Column(checkd,"|","\r\n","","chk",numChkStart);
	    	sheetObj.Redraw = true;
		}	
	}

	/**
	 * uncheck 하고싶은 시작 과 끝 건수만큼 체크한다.
	 */
	function cnt_Uncheck(){
		var formObj = document.form;
		var sheetObj  = sheetObjects[0];
		
		var unchkStart = formObj.unchkStart.value;
		var unchkEnd = formObj.unchkEnd.value;
		
		    if(unchkStart == "" || unchkStart == null){
		    	ComShowCodeMessage("AGT10001", "Uncheck Start Row", "", "");
	    		formObj.unchkStart.focus();
	    		return false;
	    	}
	    	
	    	if(unchkStart == "0"){
	    		ComShowCodeMessage("AGT10001", "number 1 over", "", "");
	    		formObj.unchkStart.focus();
	    		return false;
	    	}
	    	
	    	if(unchkEnd == "" || unchkEnd == null){
	    		ComShowCodeMessage("AGT10001", "Uncheck End Row", "", "");
	    		formObj.unchkEnd.focus();
	    		return false;
	    	}
	    	
	    	if(parseInt(unchkStart) > parseInt(unchkEnd)){
	    		ComShowCodeMessage("COM12142", "Uncheck Start Row", "Uncheck End Row", "");
	    		formObj.unchkStart.focus();
	    		return false;
	    	}
	    	
	    	var i =  parseInt(unchkStart);
	    	var max =  parseInt(unchkEnd);
	    	var checkd = "";
	    	sheetObj.Redraw = false;
	    	while ( i <= max )
		    {
		    	checkd = checkd + "0\r\n"
		    	sheetObj.RowStatus(i++) = "R";
		    }
		    sheetObj.Paste2Column(checkd,"|","\r\n","","chk", unchkStart);
	    	sheetObj.Redraw = true;

	}

	 /**
	  * 조회 옵션별 그리드 변경
	  */
	 function checkFunc(){
	 	var formObj = document.form;
	 	
 		if (formObj.s_rev_chg.checked) {
 			formObj.s_rev_chg.value = "Y";
 		}else{
 			formObj.s_rev_chg.value = "N";
 		}
	 }
