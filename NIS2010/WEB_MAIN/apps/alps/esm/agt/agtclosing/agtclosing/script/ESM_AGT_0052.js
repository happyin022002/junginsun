// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var prefix1 = "t1sheet1_";
var multi_csr_no = "";


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
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
		//alert("loadpage");
		ComConfigSheet(sheetObjects[i]);
		//alert("initSheet");
		initSheet(sheetObjects[i],i+1);
	    //마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj = document.form;
	//Date 날짜 세팅	
	formObj.search_dt_fr.value = ComGetDateAdd(null, "M", -1);
	formObj.search_dt_to.value = ComGetNowInfo();
	formObj.ar_ofc_cd.focus();
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;


	switch(sheetID) {
		case "sheet2":      //sheet1 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(16);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 1000);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 4, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, true, true, false, false) ;

				var HeadTitle1 = "CHK|Office|CSR No.|CSR Detail|Acct. Code|USD AMT|Local AMT|R.VVD|Ex.Rate|Status|Creation Date|Approval Date|Payment Date|Creation User ID|Approval User ID";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);


				//데이터속성  [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,  	true,		"ibflag",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtRadioCheck,	50,		daCenter,   true,    	"check",    false,		"",			dfNone,		0,			true,		false);
				//InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,   true,    	"seq",     	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,   true,    	"agn_ofc_cd",     false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		130,	daCenter,   true,    	"csr_no",    false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		200,		daLeft,   true,    	"inv_desc", false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,   true,    	"comm_stnd_cost_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,		100,		daRight,   true,    	"usd_amt",	false,	"",			dfFloat,	0,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,		100,		daRight,   true,    	"local_amt",	false,		"",			dfFloat,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,   true,    	"rev_vvd_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,60,		daCenter,    true,    	"xch_rt",   false,		"",			dfNone,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,65,		daCenter,    false,    	"status",    false,		"",			dfNone,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,100,		daCenter,    false,    	"cre_dt",    false,		"",			dfDateYmd,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,100,		daCenter,    false,    	"if_dt",     false,		"",			dfDateYmd,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,100,		daCenter,    false,    	"pay_dt",     	false,		"",			dfDateYmd,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,100,		daCenter,    false,    	"cre_usr_id",     	false,		"",			dfNone,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,100,		daCenter,    false,    	"apro_usr_id",     	false,		"",			dfNone,	2,			false,		false);

				//전체선택시 이벤트 발생안함
                AllowEvent4CheckAll = false;
			}
			break;
			
		case "t1sheet1":
			with (sheetObj) {

				// 높이 설정
				style.height = 150;
				// 전체 너비 설정
				SheetWidth = 150;//mainTable1.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 2, 100);

				var HeadTitle1 = " |bl_no|bl_combo";
				var headCount = ComCountHeadTitle(HeadTitle1);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, prefix1 + "ibflag", false, "", dfNone, 0, true, true, 19);
				InitDataProperty(0, cnt++, dtData, 80, daLeft, true, prefix1 + "bl_no", false, "", dfEngUpKey, 0, true, true, 19);
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, prefix1 + "bl_combo", false, "", dfNone, 0, true, true);

				CountPosition = 0;

			}
			var formObject = document.form;

			// row 50개 생성 후
			// input_bl_no.value 값을 초기 Row에 설정 후
			// 타이틀 제거

			for ( var i = 1; i <= 50; i++) {
				//
				sheetObj.DataInsert(-1);
				sheetObj.CellValue(i, prefix1 + "ibflag") = "R";
			}
			
			//alert(formObject.s_csr_no.value);
			sheetObj.CellValue2(1, prefix1 + "bl_no") = formObject.s_csr_no.value;
			formObject.s_csr_no.value = sheetObj.CellValue(1, prefix1 + "bl_no");
			sheetObj.SelectCell(1, prefix1 + "bl_no");

			sheetObj.RowHidden(0) = true;

			break;	
			
	}
}

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var sheetObj = sheetObjects[1];
	var sheetObj1 = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		// B/L No. sheet입력란이 활성화 된 경우 비활성화로....
		// bl_sheet
		if (srcName != "tb1_btn_input_bl_no") {
			if (srcName != "s_csr_no") {
				setBlNo(sheetObj1, 3);

			}
		}
		
				
		switch(srcName) {
			case "btn_retrieve":
//				moveToMultiCsr(formObj, sheetObj1);
				setMultiCsr(sheetObj1);
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				multi_csr_no = "";
				
				break;
			
			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				formObj.search_dt_fr.value = ComGetDateAdd(null, "M", -1);
				formObj.search_dt_to.value = ComGetNowInfo();
				formObj.ar_ofc_cd.focus();
				break;
				
			case "btn_detail":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
				
			case "btn_dt_fr":
				var cal = new ComCalendar();
				cal.select(formObj.search_dt_fr, 'yyyy-MM-dd');
				sheetObj.RemoveAll();
				break;
			case "btn_dt_to":
				var cal = new ComCalendar();
				cal.select(formObj.search_dt_to, 'yyyy-MM-dd');
				sheetObj.RemoveAll();
				break;
				
			case "tb1_btn_input_bl_no": // B/L No.				
				if (document.getElementById("bl_input").style.display == "block") {
					setBlNo(sheetObj1, 1);
				} else {
					setBlNo(sheetObj1, 2);
				}
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
			
			formObj.multi_csr_no.value = multi_csr_no;
			//alert(formObj.multi_csr_no.value);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0052GS.do", agtQryStr(formObj));
			

			break;
			
		case IBSEARCH_ASYNC01:	//Detail
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			row = sheetObj.SelectRow;
			
			var csr_no  = sheetObj.CellText(row,"csr_no");
			var comm_stnd_cost_cd  = sheetObj.CellText(row,"comm_stnd_cost_cd");
			var agn_cd  = sheetObj.CellText(row,"agn_ofc_cd");
			var rev_vvd_cd  = sheetObj.CellText(row,"rev_vvd_cd");

			var param = "s_csr_no=" + csr_no+"&comm_stnd_cost_cd=" + comm_stnd_cost_cd+"&agn_cd=" + agn_cd+"&rev_vvd_cd=" + rev_vvd_cd;
            
			ComOpenWindowCenter("ESM_AGT_0053.do?" + param, "compop1", "800", "470", false);
            break;
		
		case IBDOWNEXCEL:	//Down Excel
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
}


/**
 * A/R Office를 변경하면, 해당 Subject Office를 다시 조회한다.
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0052FR.do";
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
 * 컬럼을 더블클릭하면 Detail 이벤트를 발생시킨다.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
		var formObj = document.form;
		
		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);

}

/*
 * Focus를 받으면, 텍스트를 전체선택한다.
 */
function search_dt_onfocus(obj){
	delete_Char(obj,'-');	//입력값에서 '-'를 없앤다.
	obj.select();	//입력값을 전체선택한다.
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
		    		ComShowCodeMessage("COM12113", "A/R Office", "", "");
		    		formObj.ar_ofc_cd.focus();
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowCodeMessage("COM12113", "Subject Office", "", "");
		    		formObj.agn_cd.focus();
		    		return false;
		    	}
		    	break;
		    	
		    case IBSEARCH_ASYNC01:	//Detail
				//선택건수 체크(Header가 1줄이므로, SelectRow가 1보다 작으면 선택한 행이 없는것임)
				var sRow = sheetObj.SelectRow;
				if(sRow < 1){
					ComShowCodeMessage("COM12113", "row for detail information", "", "");
					return false;
				}	  
				break; 

	}

	return true;
}
}

/**
 * CSR No. 값 설정
 */
function setBlNo(sheetObj, param) {

	//alert("param : [" + param + "]");

	var formObject = document.form;
	var rect = document.getElementById("td_csr_no").getBoundingClientRect();

	formObject.rect_top.value = formObject.rect_top.value == "" ? rect.top : formObject.rect_top.value;
	formObject.rect_left.value = formObject.rect_left.value == "" ? rect.left : formObject.rect_left.value;

	if (param == 1) {

		// sheet 활성화
		document.getElementById("bl_input").style.display = "none";
		document.getElementById("bl_sheet").style.display = "block";

		// sheet 위치설정
		document.getElementById("bl_sheet").style.top = formObject.rect_top.value;
		document.getElementById("bl_sheet").style.left = formObject.rect_left.value;

		var BlNoselectRow = !ComIsEmpty(formObject.sheet_bl_no_row_chk) ? formObject.sheet_bl_no_row_chk.value : "1";

		if (!ComIsEmpty(formObject.s_csr_no)) {
			sheetObj.CellValue2(BlNoselectRow, prefix1 + "bl_no") = formObject.s_csr_no.value;
		}
		sheetObj.SelectCell(BlNoselectRow, prefix1 + "bl_no");
	} else if (param == 2) {
		// input 활성화
		document.getElementById("bl_input").style.display = "block";
		document.getElementById("bl_sheet").style.display = "none";

		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if (!ComIsEmpty(sheetObj.CellValue(i, prefix1 + "blank")) && !ComIsEmpty(sheetObj.CellValue(i, prefix1 + "bl_no"))) {
				formObject.sheet_bl_no_row_chk.value = i;
				formObject.s_csr_no.value = sheetObj.CellValue(i, prefix1 + "bl_no");
				break;
			}
		}
	} else if (param == 3) {
		if (document.getElementById("bl_sheet").style.display == "block") {
			setBlNo(sheetObj, 2);
		}
	}

}

/**
 * t1sheet1 시트가 OnChange 일 때 값을 지정해줌
 */
function t1sheet1_OnChange(sheetObj, row , col , value) {

	var formObject = document.form;
	formObject.s_csr_no.value = sheetObj.CellValue(1, col);
}

/**
 * MultiCsr  값을 지정해줌
 */
function setMultiCsr ( sheetObj ){

	var formObject = document.form;
	if( formObject.s_csr_no.value != "" ){
		sheetObj.CellValue(1, prefix1 + "bl_no") = formObject.s_csr_no.value;
	}
	else {
		sheetObj.CellValue(1, prefix1 + "bl_no") = formObject.s_csr_no.value;
	}
	
	if(sheetObj.CellValue(1, prefix1 + "bl_no") != "" ){

		for (var i = 1 ; i <= 50 ; i++){
			if ( sheetObj.CellValue(i, prefix1 + "bl_no") != "" && sheetObj.CellValue(i+1, prefix1 + "bl_no") != ""  ){
				multi_csr_no = multi_csr_no + sheetObj.CellValue(i, prefix1 + "bl_no")+",";
			}
			else{
				multi_csr_no = multi_csr_no + sheetObj.CellValue(i, prefix1 + "bl_no");
			}				
		}
		
	}
	//alert(multi_csr_no);	

}

//function moveToMultiCsr(formObj, sheetObj) {
//	
//	if()
//}

