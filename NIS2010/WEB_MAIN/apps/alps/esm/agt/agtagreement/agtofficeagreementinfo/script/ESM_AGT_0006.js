// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var IBSEARCH01  = 29;
var IBSEARCH02  = 30;
var IBSEARCH03  = 31;
var IBSEARCH04  = 32;
var IBSEARCH05  = 33;
var IBSEARCH06  = 34;
var IBSEARCH07  = 35;
var IBSEARCH08  = 36;
var IBSEARCH09  = 37;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];
		 var sheetObject2 = sheetObjects[2];
		 var sheetObject3 = sheetObjects[3];
		 var sheetObject4 = sheetObjects[4];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_ok":
					  comPopupOK();
				  break;

				case "btn_close":
					  window.close();
				  break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj)
	{
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		var formObject = document.form;
		if(formObject.agn_seq.value != ""){
			doActionIBSheet(sheetObject,formObject,IBSEARCH01);
			doActionIBSheet(sheetObject1, formObject, IBSEARCH02);
			doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
			doActionIBSheet(sheetObject3,formObject,IBSEARCH04);
			doActionIBSheet(sheetObject4,formObject,IBSEARCH05);
		}else{
			doActionIBSheet(sheetObject,formObject,IBSEARCH01);
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
			case 1:	  //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(5) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Code|Name";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	false,	"",			false,		"",	   dfNone,		0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"",			false,		"",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		"",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"conti_cd",		false,		"",	   dfNone,		0,	 false,	   false);
					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	false,	"conti_nm",		false,		"",	   dfNone,		0,	 false,	   false);

					CountPosition = 0 ;
//					AllowEvent4CheckAll = true;
				}
				break;
			case 2:	  //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(5) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Code|Name";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	false,	"",			false,		"",	   dfNone,		0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"",			false,		"",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		"",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"sconti_cd",		false,		"",	   dfNone,		0,	 false,	   false);
					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	false,	"sconti_nm",		false,		"",	   dfNone,		0,	 false,	   false);
					CountPosition = 0 ;
				}
				break;
			case 3:	  //sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(11) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Code|Name";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	false,	"",			false,		"",		dfNone,   		0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"",			false,		"",		dfNone,		  0,	 true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		"",		dfNone,		  0,	 true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	false,	"cnt_cd",		false,		"",		dfNone,		  0,	 false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	false,	"cnt_nm",		false,		"",		dfNone,		  0,	 false,		false);
					CountPosition = 0 ;
				}
				break;

			case 4:	  //sheet6 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(11) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					if(document.form.pageType.value != "Inquiry"){
						InitHeadMode(true, true, true, true, false,false) ;
					}else{
						InitHeadMode(true, true, false, true, false,false) ;
					}
					

					var HeadTitle = "STS|No|CHK|Code";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	0,	daCenter,	false,	"",			false,		  "",	   dfNone,		0,	false,	  true);
					InitDataProperty(0, cnt++, dtSeq,			30,	daCenter,	false,	"",			false,		  "",	   dfNone,		0,	true,	   true);
					InitDataProperty(0, cnt++, dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		  "",	   dfNone,		0,	true,	   true);
					InitDataProperty(0, cnt++, dtData,			80,	daCenter,	false,	"loc_cd",		false,		  "",	   dfNone,		0,	false,	   false);

					CountPosition = 0 ;
				}
				break;
			case 5:	  //sheet7 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(11) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Code";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	false,	"",			false,		  "",	   dfNone,		0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	false,	"",			false,		  "",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	false,	"checkbox",	false,		  "",	   dfNone,		0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,	"ofc_cd",		false,		  "",	   dfNone,		0,	 false,	   false);

					CountPosition = 0 ;
				}
				break;
		}
	}

  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		
		switch(sAction) {
			case IBSEARCH01:		 //조회
				if(!validateForm(sheetObject,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH02:	  //조회
				if(!validateForm(sheetObject1,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH03:	  //조회
				if(!validateForm(sheetObject2,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH03;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH04:	  //조회
				if(!validateForm(sheetObject3,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH04;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH05:	  //조회
				if(!validateForm(sheetObject4,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH05;
				sheetObj.DoSearch4Post("ESM_AGT_0006GS.do", agtQryStr(formObj));
				break;
			case IBSEARCH06:	  //조회
				if(!validateForm(sheetObject,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH02;
				var agn_seq = formObj.agn_seq.value;
				formObj.agn_seq.value = '';
				var parameter = agtQryStr(formObj);
				parameter = parameter + '&conti_cd='+chkdArgs(sheetObject, 'checkbox', 'conti_cd');
				sheetObject1.DoSearch4Post("ESM_AGT_0006GS.do", parameter);
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				sheetObject4.RemoveAll();
				formObj.agn_seq.value = agn_seq;
				break;
			case IBSEARCH07:	  //조회
				if(!validateForm(sheetObject1,formObj,sAction)) return false;
				var agn_seq = formObj.agn_seq.value;
				formObj.agn_seq.value = '';
				formObj.f_cmd.value = SEARCH03;
				var parameter = agtQryStr(formObj);
				parameter = parameter + '&sconti_cd='+chkdArgs(sheetObject1, 'checkbox', 'sconti_cd');
				sheetObject2.DoSearch4Post("ESM_AGT_0006GS.do", parameter);
				sheetObject3.RemoveAll();
				sheetObject4.RemoveAll();
				formObj.agn_seq.value = agn_seq;
				break;
			case IBSEARCH08:	  //조회
				if(!validateForm(sheetObject2,formObj,sAction)) return false;
				var agn_seq = formObj.agn_seq.value;
				formObj.agn_seq.value = '';
				formObj.f_cmd.value = SEARCH04;
				parameter = "";
				parameter = agtQryStr(formObj);
				parameter = parameter + '&cnt_cd='+chkdArgs(sheetObject2, 'checkbox', 'cnt_cd');
				sheetObject3.DoSearch4Post("ESM_AGT_0006GS.do", parameter);	
				formObj.f_cmd.value = SEARCH05;
				parameter = "";
				parameter = agtQryStr(formObj);
				parameter = parameter + '&cnt_cd='+chkdArgs(sheetObject2, 'checkbox', 'cnt_cd');
				sheetObject4.DoSearch4Post("ESM_AGT_0006GS.do", parameter);			
				formObj.agn_seq.value = agn_seq;
				break;
			case IBSEARCH09:	  //조회
				if(!validateForm(sheetObject3,formObj,sAction)) return false;
				var agn_seq = formObj.agn_seq.value;
				formObj.agn_seq.value = '';
				formObj.f_cmd.value = SEARCH05;
				var parameter = agtQryStr(formObj);
				parameter = parameter + '&loc_cd='+chkdArgs(sheetObject3, 'checkbox', 'loc_cd');
				sheetObject4.DoSearch4Post("ESM_AGT_0006GS.do", parameter);
				formObj.agn_seq.value = agn_seq;
				break;
		}
	}

	/**
	 * Conti 시트의 Check 박스 클릭했을때 해당 Sub Conti 조회
	 */

	function sheet1_OnClick(sheetObject, Row, Col, Value)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.colSaveName(Col)== "checkbox"){
				if(Value == 0){
					sheetObject.CellValue(Row,Col) = 1;
				}else{
					sheetObject.CellValue(Row,Col) = 0;
				}
				doActionIBSheet(sheetObject,formObject,IBSEARCH06);
			
				if(sheetObject.CellValue(Row,Col) == 1){
					sheetObject.CellValue(Row,Col) = 0;
				}else{
					sheetObject.CellValue(Row,Col) = 1;
				}					   
			}	
		}
	}
	

	
	/**
	 * Sub Conti 시트의 Check 박스 클릭했을때 해당 Country Code 조회
	 */

	function sheet2_OnClick(sheetObject, Row, Col, Value)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.colSaveName(Col)== "checkbox"){
				if(Value == 0){
					sheetObject.CellValue(Row,Col) = 1;
				}else{
					sheetObject.CellValue(Row,Col) = 0;
				}	
				doActionIBSheet(sheetObject,formObject,IBSEARCH07);
				if(sheetObject.CellValue(Row,Col) == 1){
					sheetObject.CellValue(Row,Col) = 0;
				}else{
					sheetObject.CellValue(Row,Col) = 1;
				}				   
			}
		}
		
	}
	
	
	/**
	 * Country Code 시트의 Check 박스 클릭했을때 해당 Region Code 조회
	 */

	function sheet3_OnClick(sheetObject, Row, Col, Value)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.colSaveName(Col)== "checkbox"){
				if(Value == 0){
					sheetObject.CellValue(Row,Col) = 1;
				}else{
					sheetObject.CellValue(Row,Col) = 0;
				} 
				doActionIBSheet(sheetObject,formObject,IBSEARCH08);
				if(sheetObject.CellValue(Row,Col) == 1){
					sheetObject.CellValue(Row,Col) = 0;
				}else{
					sheetObject.CellValue(Row,Col) = 1;
				}					  
			}
		}
	}
	

	/**
	 * Location Code 시트의 Check 박스 클릭했을때 해당 OFC Code 조회
	 */

	function sheet4_OnClick(sheetObject, Row, Col, Value)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.colSaveName(Col)== "checkbox"){
				if(Value == 0){
					sheetObject.CellValue(Row,Col) = 1;
				}else{
					sheetObject.CellValue(Row,Col) = 0;
				}	 
				doActionIBSheet(sheetObject,formObject,IBSEARCH09);
				if(sheetObject.CellValue(Row,Col) == 1){
					sheetObject.CellValue(Row,Col) = 0;
				}else{
					sheetObject.CellValue(Row,Col) = 1;
				}				  
			}
		}
		
	}
	
	// checkAll 박스 클릭했을때 해당 OFC Code 조회

	function sheet4_OnMouseDown(sheetObject, Btn, Shift, X, Y)
	{
		var formObject = document.form;
		if(document.form.pageType.value != "Inquiry"){
			if ( sheetObject.MouseRow < 1  && sheetObject.MouseCol == 2){
				
				if(sheetObject.CheckAll(2) == 0){
					sheetObject.CheckAll(2) = 0;
				}else{
					sheetObject.CheckAll(2) = 1;
				}
				
				sheetObject.CheckReverse(2);
				doActionIBSheet(sheetObject,formObject,IBSEARCH09);
	
			}
		}
		
	}

   /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		
		switch(sAction) {

			case IBSEARCH06:
				if(sheetObject.CheckedRows("checkbox") < 1){
					ComShowMessage(ComGetMsg('COM12113','Conti 체크박스'));
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					sheetObject4.RemoveAll();
					return false;
				}
				break;
			case IBSEARCH07:
				if(sheetObject1.CheckedRows("checkbox") < 1){
					ComShowMessage(ComGetMsg('COM12113','S. Conti 체크박스'));
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					sheetObject4.RemoveAll();
					return false;
				}
				break;
			case IBSEARCH08:
				if(sheetObject2.CheckedRows("checkbox") < 1){
					ComShowMessage(ComGetMsg('COM12113','Country Code 체크박스'));
					sheetObject3.RemoveAll();
					sheetObject4.RemoveAll();
					return false;
				}
				break;
			case IBSEARCH09:
				if(sheetObject3.CheckedRows("checkbox") < 1){
					ComShowMessage(ComGetMsg('COM12113','Location Code 체크박스'));
					sheetObject4.RemoveAll();
					return false;
				}
				break;
		}
		return true;
	}

	function chkdArgs(sheetObj,chkCol,valCol,isNum)
	{
		var rtn = '';
		with(sheetObj)
		{
			for (var i = 1; i <= LastRow; i ++)
			{
				if ("1" == CellValue(i, chkCol))
					rtn += (''!=rtn?',':'')+(isNum?'':'\'')+CellValue(i, valCol)+(isNum?'':'\'');
			}
		}
		return rtn;
	}