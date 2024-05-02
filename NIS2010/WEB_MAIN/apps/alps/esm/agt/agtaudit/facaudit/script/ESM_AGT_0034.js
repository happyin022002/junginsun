// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var ifOptVal = "BF";
var currentRow = 0;

// RD
var rdObjects = new Array();
var rdCnt = 0;

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
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
	    //시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		//IBSheet 초기화
		initSheet(sheetObjects[i],i+1);
	    
	    //마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
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
				InitColumnInfo(10, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "CHK|STS|Freight Forwarder|Freight Forwarder|CNT|AMT|AP OFC|CSR NO|I/F Remark|RCV Remark";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,     30,    daCenter,  false,    "chk",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtHiddenStatus, 30,    daCenter,  false,    "sts",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "fwdr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         280,   daLeft,    true,     "fwdrNm", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum,      50,    daRight,   false,    "totCnt", false,    "",         dfInteger,  0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum,      80,    daRight,   false,    "totAmt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "apOfc",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         130,   daCenter,  true,     "csrNo",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         300,   daLeft,    false,    "ifRsn",  false,    "",         dfNone,     0,          true,       false);
				InitDataProperty(0, cnt++, dtData,         300,   daLeft,    false,    "rcvRsn", false,    "",         dfNone,     0,          true,       false);
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
				MergeSheet = msHeaderOnly;
				
			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "BL NO|I/F AMT|Type|Rate|BKG NO|SPLIT|SEQ";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    140,   daCenter,  false,    "blNo",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 130,   daRight,   false,    "ifAmt",  false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,    130,   daCenter,  false,    "type",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    130,   daCenter,  false,    "rate",   false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,    120,   daCenter,  false,    "bkgNo",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    40,    daCenter,  false,    "bkgNoS", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    40,    daCenter,  false,    "facSeq", false,    "",         dfNone,     0,          false,      false);
				CountPosition = 0;
			}
			break;
			
		case 3:     	//sheet2 init
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

        case 4:      //sheet3 init
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

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var formObject = document.form;
	var sheetObject  = sheetObjects[0];
	var rdObject = rdObjects[0];

	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_print":
				doActionIBSheet(sheetObject,formObject,RDPRINT);				
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);				
				break;

			case "btn_interfacetoap":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;

			case "btn_cancel":
				doActionIBSheet(sheetObject,formObject,IBDELETE);
				break;
		} // end switch
		
	}catch(e) {
		if( e == "[object Error]") {
			showErrMessage(getMsg("COM12111", "", ""));
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
	    case IBSEARCH:		//조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;

			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_034GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.CellAlign(sheetObj.LastRow,3) = daCenter;
			
			sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			
			currentRow = 0;
			break;    

		case IBDOWNEXCEL:	//엑셀내려받기
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			sheetObj.SpeedDown2Excel(-1);
			break;
		
		case RDPRINT:
			if(!validateForm(sheetObj,formObj,sAction))	return false;

			var sheetObj3 = sheetObjects[2];
   	        var sheetObj4 = sheetObjects[3];
   	        
			//체크된 첫번째행의 번호를 읽어와서 Hidden Input에 담는다.
			var sRow = sheetObj.FindCheckedRow("chk");
			var arrRow = sRow.split("|");
            formObj.h_csrNo.value = sheetObj.CellValue(arrRow[0], "csrNo");
            
			//보고서출력을 위해 AP_INV_HDR, AP_INV_DTRB 정보 조회
			formObj.f_cmd.value = PRINT;
			var sXml = sheetObj3.GetSearchXml("ESM_AGT_034GS3.do", agtQryStr(formObj));
			sheetObj3.LoadSearchXml(sXml);
			var sxml1 = sheetObj3.EtcData("sxml1");
   	        
   	        //ETC데이터를 IBSheet에 세팅한다.
   	        sheetObj3.RemoveEtcData();
   	        sheetObj4.LoadSearchXml(sxml1);
   	        
			//보고서출력
			var fromObj = new Array();
			var rdObj  	= new Array();
			var parmObj = new Array();
			
            fromObj[0] = formObj;  //RD로 보내기 위해 배열로담는다
            rdObj[0] = sheetObjects[2]; //sheet를 RD로 보내기 위해 배열로 담는다
            rdObj[1] = sheetObjects[3];
            RD_path  = "http://127.0.0.1:7001/hanjin/";
            //RD_path = "http://kov440h.hanjin.com:9300/hanjin/";

            // RD 로 보내기 위한 설정
            parmObj[0] = "1";
            parmObj[1] = "";
            parmObj[2] = "N";
            parmObj[3] = RD_path + "apps/enis/esm/agt/agtaudit/agtaudit/report/ESM_AGT_017A.mrd"; //RD 화면
            parmObj[4] = rdObj;
            parmObj[5] = fromObj;
            rdObjModaless(RdReport, parmObj, 700, 700);	
			break;
            			
		case IBINSERT:
		    if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESM_AGT_034GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			break;
		
		case IBDELETE:
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESM_AGT_034GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			break;
	}
}

/*
 *
 */
function cbOfcCd_OnChange(obj){
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
}

/*
 * I/F Option을 변경하면, 그리드의 데이터를 초기화한다.
 */
function ifOpt_OnChange(obj){
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
		formObj.ifCnt.disabled = true;
		//Radio Check
		sheetObj1.InitDataProperty(0, 0, dtRadioCheck, 30, daCenter, false, "chk", false, "", dfNone, 0, true, true);
	}else{
		//I/F Count : enable
		formObj.ifCnt.disabled = false;
		//Multi Check
		sheetObj1.InitDataProperty(0, 0, dtCheckBox,   30, daCenter, false, "chk", false, "", dfNone, 0, true, true);
	}
}

/**
 * I/F Count를 변경하면, 그리드의 Check컬럼을 건수만큼 체크한다.
 */
function ifCnt_OnChange(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];
	
	var ifCnt = formObj.ifCnt.value;
	var sRows = sheetObj.RowCount;
		
	if(ifCnt == "SEL"){
		//사용자선택건 
		sheetObj.CheckAll2("chk") = 0;
	}else{
		//나머지
		if(ifCnt >= sRows){
			sheetObj.CheckAll2("chk") = 1;
		}else{
			sheetObj.CheckAll2("chk") = 0;
	
			//선택한 건수만큼 선택하기
			for(var i=1; i<sRows; i++){
				sheetObj.CellValue2(i,"chk") = 1;
				if(i >= ifCnt) break;
			}
		}
	}
		
	sheetObj.focus();
}

/*
 * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 해당 F.Forwarder의 상세내역을 조회한다.
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	var formObj = document.form;
	var sheetObj2 = sheetObjects[1];
	
	if(col != 0){
		//if(ifOptVal == "IF"){
			sheetObj.CellValue2(row, "chk") = 1;
		//}else{
		//	if(sheetObj.CellValue(row, "chk") == 0){
		//		sheetObj.CellValue2(row, "chk") = 1;
		//	}else{
		//		sheetObj.CellValue2(row, "chk") = 0;
		//	}
		//}
	}
	
	if(row != currentRow){		
		formObj.f_cmd.value = SEARCHLIST;
		formObj.param1.value = sheetObj.CellValue(row, "fwdr");
		formObj.param2.value = sheetObj.CellValue(row, "csrNo");
		sheetObj2.DoSearch4Post("ESM_AGT_034GS2.do", agtQryStr(formObj));	
		sheetObj.SelectCell(row, col);
	}
	
	currentRow = row;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (!isNumber(iPage)) {
			return false;
		}
		
		switch(sAction) {
		    case IBSEARCH:
			    if(cbOfcCd.value == ""){
			    	showErrMessage(getMsg("COM12113", "Office", "", ""));
		    		formObj.cbOfcCd.focus();
					return false;
				}
		    	break;
		    	
		    case IBDOWNEXCEL:	//엑셀내려받기
		    	var rCnt = sheetObj.RowCount;
		    	if(rCnt < 1){
		    		showErrMessage(getMsg("AGT10004", "", "", ""));
					return false;
				}
				break;
			
			case RDPRINT:
		    	if(ifOptVal != "IF"){
		    		//Can't print. Please check I/F Option.
		    		showErrMessage(getMsg("AGT10015", "Can't print.", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					showErrMessage(getMsg("AGT10016", "", "", ""));
					return false;
				}
				break; 
				
			case IBINSERT:
				if(ifOptVal != "BF"){
		    		//Can't interface. Please check I/F Option.
		    		showErrMessage(getMsg("AGT10015", "Can't interface.", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					showErrMessage(getMsg("COM12113", "row for interface", "", ""));
					return false;
				}
		    	break; 
		    
		    case IBDELETE:
		    	if(ifOptVal != "IF"){
		    		//Can't cancel. Please check I/F Option.
		    		showErrMessage(getMsg("AGT10015", "Can't cancel.", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					showErrMessage(getMsg("COM12113", "row for cancel", "", ""));
					return false;
				}
		    	break; 
		}
	}
	
	return true;
}
