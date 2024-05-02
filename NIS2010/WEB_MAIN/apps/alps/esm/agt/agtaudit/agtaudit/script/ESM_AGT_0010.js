// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

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

		initSheet(sheetObjects[i],i+1);
	    
	    //마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// S/A Date Unit 날짜 세팅	
	var formObj = document.form;
	var today = ComGetNowInfo();
	var frday = ComGetDateAdd(null, "D", -7);
	formObj.search_dt_fr.value = frday;
	formObj.search_dt_to.value = today;
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
				style.height = GetSheetHeight(15);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, 1000);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(39, 4, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, true, true, false, false) ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle1 = "STS|CHK|No.|B/L No.|BKG No.|BND|VVD|PORT|S/A Date|SEQ|BKG STS||||||||||PRE AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
				var HeadTitle2 = "STS|CHK|No.|B/L No.|BKG No.|BND|VVD|PORT|S/A Date|SEQ|BKG STS||||||||||PRE AMT|Common1|Common2|BRKG|CHF|T/S|T/R|SOC|Cross|DOC|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,   DATATYPE,	WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,30,	daCenter,  	true,    	"ibflag",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtCheckBox, 	40,		daCenter,   true,    	"check",  	false,		"",			dfNone,		0,			true,		false);
				InitDataProperty(0, cnt++, dtSeq,		30,		daCenter,   true,    	"seq",    	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		90,		daCenter,   true,    	"bl_no",   	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		90,		daCenter,   true,    	"bkg_no",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		30,		daCenter,   true,    	"io_bnd_cd",    	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		80,		daCenter,   true,    	"vvd",    	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,	    50,		daCenter,   true,    	"port",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		70,		daCenter,   true,    	"sail_arr_dt", 	false,		"",			dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		35,		daCenter,   true,    	"ac_seq",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		60,		daCenter,   true,    	"bkg_sts_cd",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pcommon1",	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pcommon2",	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pbrkg",  	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pchf",   	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pts",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"ptr",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"psoc",   	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pcross", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pdoc",   	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	70,		daRight,    true,    	"pre_amt", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	65,		daRight,    false,    	"comm1", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	65,		daRight,    false,    	"comm2", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"brkg",   	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"chf",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"ts",     	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"tr",     	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"soc",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"cross",  	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"doc",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	80,		daRight,    true,    	"usd_amt", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtData,		70,		daRight,    true,    	"ex_rate", 	false,		"",			dfFloat,	4,			false,		false);
				InitDataProperty(0, cnt++, dtData,		40,		daCenter,   true,    	"curr_cd",   	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	80,		daRight,    true,    	"lcl_amt", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtData,		45,		daCenter,   true,    	"comm_proc_sts_cd", 	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		500,	daLeft,   	true,    	"comm_proc_sts_rsn", 	false,		"",			dfNone,		0,			true,		false);
				InitDataProperty(0, cnt++, dtHidden,	50,		daCenter,   true,    	"ar_ofc_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	50,		daCenter,   true,    	"agn_cd",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	50,		daCenter,   true,    	"scp",  	false,		"",			dfNone,		0,			false,		false);
				
				RangeBackColor(1,19,1,27) = RgbColor(222, 251, 248);   // ENIS
			}
			break;
	}
}

/* 
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 */
function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_showdetail":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
				break;

			case "btn_recalculate":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);
				break;

			case "btn_exrateinput":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC04);
				break;

			case "btn_request":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
				
			case "btn_cal_fr":
	         	var cal = new ComCalendar();
				cal.select(formObject.search_dt_fr, 'yyyy-MM-dd');
	            break;

            case "btn_cal_to":
             	var cal = new ComCalendar();
                cal.select(formObject.search_dt_to, 'yyyy-MM-dd');
                break;
				
			case "check_apply":
				auditCnt_Check();
				break;
				
			case "uncheck_apply":
				auditCnt_Uncheck();
				break;
					
		} // end switch
		
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111", "", "");
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
	    case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			    if(formObj.bl.value.trim().length > 0){
		    		setBlNoRetrieve(formObj.bl);
		    	}
	    	sheetObj.Redraw = false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0010GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.Redraw = true;
			break;
			
		case IBSEARCH_ASYNC01:	//Detail
//		alert("  처리중입니다....         ");
		
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			var row = sheetObj.SelectRow;
			var bl_no  = sheetObj.CellValue(row,"bl_no");
			var bkg_no = sheetObj.CellValue(row,"bkg_no");
			var agn_cd = sheetObj.CellValue(row,"agn_cd");
			var io_bnd_cd = sheetObj.CellValue(row,"io_bnd_cd");
			var seq   = sheetObj.CellValue(row,"ac_seq");
			var arOfc = sheetObj.CellValue(row,"ar_ofc_cd");
			var sailArrDt = sheetObj.CellValue(row,"sail_arr_dt").replace(/-/g, '');
			
			if(bkg_no == ""){
				ComShowCodeMessage("COM12113", "BKG No for detail information", "", "");
				break;
			}
		
			var param = "?bl_no=" + bl_no + "&bkg_no=" + bkg_no + "&agn_cd=" + agn_cd + "&io_bnd_cd=" + io_bnd_cd + "&ac_seq=" + seq + "&ar_ofc_cd=" + arOfc + "&sail_arr_dt=" + sailArrDt;
            //window.showModalDialog("ESM_AGT_011.do" + param, "Detail & History", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px");
            //window.showModelessDialog("ESM_AGT_011.do" + param, window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px")
			ComOpenWindowCenter("ESM_AGT_0011.do" + param, "compop1", "800", "600", false);
            break;
			
		case IBSEARCH_ASYNC02:	//Re-calculate
		    if(!validateForm(sheetObj,formObj,sAction))	return false;
//			alert("  처리중입니다....         ");
			sheetObj.Redraw = false;
			formObj.f_cmd.value = REPLY;
			sheetObj.DoSave("ESM_AGT_0010GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.Redraw = true;
			break;
		
		case IBSEARCH_ASYNC04:	//ex.Rate Input
		    if(!validateForm(sheetObj,formObj,sAction))	return false;
			sheetObj.Redraw = false;
			formObj.f_cmd.value = MODIFY01;
			sheetObj.DoSave("ESM_AGT_0010GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.Redraw = true;
			break;
		
		case IBSEARCH_ASYNC03:	//Request

			if(!validateForm(sheetObj,formObj,sAction))	return false;
			sheetObj.Redraw = false;
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESM_AGT_0010GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.Redraw = true;
			break;
		
		case IBDOWNEXCEL:	//Down Excel
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
	
	//Status에 따른 색깔 표시
	var rows = sheetObj.RowCount;
	for(var i=0; i<rows; i++){
		sts = sheetObj.CellValue(i+2,"comm_proc_sts_cd");
		
		if(sts == "CE"){
			sheetObj.RowFontColor(i+2) = sheetObj.RgbColor(255,0,0); //red
		}else if(sts == "IC" || sts == "CA"){
			sheetObj.RowFontColor(i+2) = sheetObj.RgbColor(0,0,255); //blue
		}
	}
}

/**
 * 행을 더블클릭하면 Detail 이벤트를 발생시킨다.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObj = document.form;
		
	//Detail 팝업 조회
	if(sheetObj.ColSaveName(col) == "bl_no" || sheetObj.ColSaveName(col) == "bkg_no"){
		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
	}
	
	//VVD환율 공통팝업 조회
	if (sheetObj.ColSaveName(col) == "ex_rate") {
        var vvd  = sheetObj.CellValue(row, "vvd");
        vvd = vvd.substring(0,9);
        var port = sheetObj.CellValue(row, "port");
        var curr_cd = sheetObj.CellValue(row, "curr_cd");
        var io_bnd_cd  = sheetObj.CellValue(row, "io_bnd_cd");
        var scp  = sheetObj.CellValue(row, "scp");
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
        var classId = "ESM_AGT_0047"; //"COM_ENS_0F1";
	    var param = '?vvd_cd=' + vvd + '&port_cd=' + port + '&locl_curr_cd=' + curr_cd + '&io_bnd_cd=' + io_bnd_cd + '&svc_scp_cd=' + scp+'&chg_curr_cd=USD';
		var chkStr = dispaly.substring(0,3) ;         
        
        if(chkStr == "1,0") {
        	//Radio PopUp  
//           	ComOpenPopup('/hanjin/COM_ENS_0F1.do' + param, 770, 470, 'getCOM_ENS_0F1_2', dispaly, true, false, row, col);
           	ComOpenPopup('/hanjin/ESM_AGT_0047.do' + param, 770, 470, '', dispaly, true, false, row, col);
        } 
        /*
        else if(chkStr == "0,1") {
            //CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
        	ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getESM_AGT_025_2', dispaly, sheetIdx, row, col);
        } else if(chkStr == "0,0") {
           	//Row 선택 PopUp
        	ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 470, 'getESM_AGT_025_3', dispaly, row, col);
        } else if(chkStr == "1,1"){
           	ComShowMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
           	return;
        } else {
           	ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
           	return;
        }*/
    }
}

//Ex.Rate 값 수정 
//function getCOM_ENS_0F1_2(rowArray, row, col){
//	var sheetObject = sheetObjects[0];
//	var colArray = rowArray[0];
//	sheetObject.CellValue(row, "ex_rate") = colArray[10];
//}

/**
 * A/R Office를 변경하면, 해당 Subject Office를 다시 조회한다.
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
    
    //Grid Reset
	sheetObj.RemoveAll();
    
    //Sub Office ComboBox Setting
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0010FR.do";
    formObj.submit();
}

/**
 * Subject Office를 변경하면, 그리드를 초기화한다.
 */
function agn_cd_OnChange(obj){
    var sheetObj = sheetObjects[0];
    
    //Grid Reset
	sheetObj.RemoveAll();
}

/**
 * Status를 변경하면, Grid를 초기화하고 조회일자를 세팅한다.
 */
function sts_cd_OnChange(obj){
	var formObj = document.form;
    var sheetObj = sheetObjects[0];
	
	//Grid Reset
	sheetObj.RemoveAll();
	
	//조회일자 세팅
	var sts_cd = obj.value;
	if(sts_cd == "4"){
		var today = ComGetDateAdd(null, "D", -90);
		formObj.search_dt_fr.value = "2000-01-01";
		formObj.search_dt_to.value = today;
	}else{
		var today = ComGetNowInfo();
		var frday = ComGetDateAdd(today, "D", -6);
		formObj.search_dt_fr.value = frday;
		formObj.search_dt_to.value = today;
	}
	
	//Status 세팅
	var optLen = formObj.sts_dv.options.length - 1;
	for(var i = optLen; i >= 0; i--){
		formObj.sts_dv.remove(i);
	}
	
	if(sts_cd == "0" || sts_cd == "3" || sts_cd == "4"){
		//created, S/A, Old
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'ALL';
		addOpt.value = '0';
		
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'CS';
		addOpt.value = '1';
		
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'CE';
		addOpt.value = '2';
		
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'CA';
		addOpt.value = '3';
		
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'IC';
		addOpt.value = '4';
	}

	if(sts_cd == "1"){
		//requested(RS,RM)
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'ALL';
		addOpt.value = '5';
	}
	 
	if(sts_cd == "2"){
	 	//audited(AS)
	 	addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'ALL';
		addOpt.value = '6';
	}

	if(sts_cd == "5"){ 
		//interfaced(IF)
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'ALL';
		addOpt.value = '7';
	}
	 
}

/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function search_dt_fr_onfocus(obj){
	delete_Char(obj,'-');	//입력값에서 '-'를 없앤다.
	obj.select();	//입력값을 전체선택한다.
}

/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function search_dt_to_onfocus(obj){
	delete_Char(obj,'-');	//입력값에서 '-'를 없앤다.
	obj.select();	//입력값을 전체선택한다.
}

/**
 * 날짜가 변경되면, 날짜를 검사하여 보여준다. 
 */
function search_dt_fr_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = obj.value;
		var toDt = delete_Char(formObj.search_dt_to.value,'-');
		
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

/**
 * 날짜가 변경되면, 날짜를 검사하여 보여준다. 
 */
function search_dt_to_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = delete_Char(formObj.search_dt_fr.value,'-');
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
		    		//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
		    		formObj.ar_ofc_cd.focus();
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "Subject Office", "", ""));
		    		formObj.agn_cd.focus();
		    		return false;
		    	}
		    	break;
		    	
		    case IBSEARCH_ASYNC01:	//Detail
				//선택된 행 체크(Header가 2줄이므로, SelectRow가 2보다 작으면 선택한 행이 없는것임)
				var sRow = sheetObj.SelectRow;
				if(sRow < 2){
					//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "BKG No for detail information", "", ""));
					return false;
				}	  
				break; 
				
			case IBSEARCH_ASYNC02:	//Re-calculate
				//Status 체크
				var status = formObj.sts_cd.value;
				if(status == "1" || status == "2") {
			    	ComShowMessage(ComGetMsg("AGT10027", "Re-calculate", "", ""));
					return false;
	     		}
	  		
				//선택건수 체크
				var checkCnt = sheetObj.CheckedRows("check");
				if(checkCnt < 1){
					//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "row for re-calculate", "", ""));
					return false;
				}
				
				//200건이상 실행금지 체크
				if(checkCnt > 200){
					//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "under 200 B/Ls at a time when you re-calculate.", "", ""));
					return false;
				}
				
				break; 
			
			case IBSEARCH_ASYNC04:	//ex.Rate Input
				//Status 체크
				var status = formObj.sts_cd.value;
				if(status == "1" || status == "2") {
			    	ComShowMessage(ComGetMsg("AGT10027", "ex.Rate Input", "", ""));
					return false;
	     		}
	     		
	     		//선택건수 체크
				var checkCnt = sheetObj.CheckedRows("check");
				if(checkCnt < 1){
					//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "row for ex.Rate Input", "", ""));
					return false;
				}
	  		
				break; 
			
			case IBSEARCH_ASYNC03:	//Request
				//Status 체크
				var checkCnt = sheetObj.RowCount;
//				alert("checkCnt="+checkCnt)
				var status = formObj.sts_cd.value;
				if(status == "1" || status == "2") {
			    	ComShowCodeMessage("AGT10027", "Request", "", "");
					return false;
	     		}
				
				for(var j=0; j<checkCnt ; j++){
					if(sheetObj.CellValue(j+2,"check") == 1){
//					alert("1="+sheetObj.CellValue(j+2,"comm_proc_sts_cd"));
					if(sheetObj.CellValue(j+2,"comm_proc_sts_cd") == "CE"){
//						alert("2="+sheetObj.CellValue(j+2,"comm_proc_sts_cd"));
						ComShowCodeMessage("AGT10027", "Request", "", "");
						return false;
					}
					
				}
				}
//    	  		var totCount = chkEnd - chkStart;
//            	CreateVBArray( totCount, 1, "@");
//            	
//            	for(var i=0; i<=totCount; i++) {
//            	    SetVBValue(i, 1, "1");
//            	}
//            	
//            	var vbArray = GetVBArray();
//              sheetObj.Paste2ColumnVBArray(vbArray, "@", "1|check", chkStart);
          
				//처리상태 체크
				var rows = sheetObj.RowCount;
				CreateVBArray( rows, 1, "@");
				
				var checkRowCnt = 0;
				var checkRowCntTmp = 0;
				
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellValue(i+2,"check") == 1){
				    	//ex_rate
						ex_rate = sheetObj.CellValue(i+2,"ex_rate");
						if(ex_rate == 0){
							checkRowCntTmp++;
						}
						checkRowCnt++;
				    }
				    if((i+2 == rows+1) && (checkRowCnt == checkRowCntTmp)){
				    	ComShowCodeMessage("AGT00089", "Exchange Rate", "", "");
					    return false;
				    }

				}
				
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellValue(i+2,"check") == 1){
				    	//ex_rate
						ex_rate = sheetObj.CellValue(i+2,"ex_rate");
						if(ex_rate == 0){
							sheetObj.CellValue2(i+2,"check") = 0;
						}
				    }
				}
				
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellValue(i+2,"check") == 1){
				    	
				    	status = sheetObj.CellValue(i+2,"comm_proc_sts_cd");

				    	if(status != "CS"){
//				    		ComShowCodeMessage("AGT10028", i+1, "Request", "");
//							return false;
//                          sheetObj.CellValue(i+2,"check") = 0;
                            SetVBValue(i, 1, "0");
						}
						var blNo = sheetObj.CellValue(i+2,"bl_no");
						
						if(blNo == ""){
							ComShowCodeMessage("AGT10028", i+1, "Request! Because B/L No does not exist.", "");
							sheetObj.CellValue(i+2,"check") = 0;
							SetVBValue(i, 1, "0");
							return false;
                            
						}
						var bkg_sts_cd = sheetObj.CellValue(i+2,"bkg_sts_cd");
						
						if(bkg_sts_cd == "A"){
							ComShowCodeMessage("AGT10090", "A", "", "");
							sheetObj.CellValue(i+2,"check") = 0;//
							SetVBValue(i, 1, "0");
							return false;
                            
						}
						lcl_amt = sheetObj.CellValue(i+2,"lcl_amt");
						if(lcl_amt == 0){
//						    sheetObj.CellValue(i+2,"check") = 0;
                          SetVBValue(i, 1, "0");
						}
		     		}
		  		}
				
		  		var vbArray = GetVBArray();
		  		sheetObj.Paste2ColumnVBArray(vbArray, "@", "1|check", 1);
		  		var checkCnt = sheetObj.CheckedRows("check");
		  		//500건이상 실행금지 체크
				if(checkCnt > 500){
					//Please select **.
		    		ComShowCodeMessage("COM12113", "under 500 B/Ls at a time when you request.", "", "");
					return false;
				}
				
				break;
				
				//선택건수 체크
//				var checkCnt = sheetObj.CheckedRows("check");
//				if(checkCnt < 1){
//					//Please select **.
//		    		ComShowMessage(ComGetMsg("COM12113", "row for request", "", ""));
//					return false;
//				}
				
				 
		}
	}

	return true;
}
	
/**
 * check 하고싶은 시작 과 끝 건수만큼 체크한다.
 */
function auditCnt_Check(){
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
	        sheetObj.Paste2Column(checkd,"|","\r\n","","check",numChkStart);
	    	sheetObj.Redraw = true;
		}	
}

/**
 * uncheck 하고싶은 시작 과 끝 건수만큼 체크한다.
 */
function auditCnt_Uncheck(){
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
		    sheetObj.Paste2Column(checkd,"|","\r\n","","check", unchkStart);
	    	sheetObj.Redraw = true;

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
