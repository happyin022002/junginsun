// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];


		 /*******************************************************/
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

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn2_Row_Copy":
					doActionIBSheet(sheetObject,formObject,IBCOPYROW);
					break;

				case "btn2_Row_Add":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
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

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
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
					// 높이 설정
					style.height = GetSheetHeight(15) ;
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
					InitColumnInfo(15, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|SEQ|F.Fowarder|Name|Shipper|Name";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "del",            false,          "",       dfNone,   		0,     true,       true);
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false, "ibflag",         false,          "",       dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,   true,    "seq",            false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit, 130,    daCenter,   true, "cust_cd",         true,          "",       dfEngUpKey,     0,     true,       true,          8);
					InitDataProperty(0, cnt++ , dtData,      170,    daLeft,     true, "cust_nm",        false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtPopupEdit, 130,    daCenter,   true, "shpr_cd",         true,          "",       dfEngUpKey,     0,     true,       true ,         8);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     true, "shpr_nm",        false,          "",       dfNone,          0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,    130,    daCenter,   true, "cust_cnt_cd",    false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    170,    daCenter,   true, "cust_seq",       false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    130,    daCenter,   true, "shpr_cnt_cd",    false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    150,    daCenter,   true, "shpr_seq",       false,          "",       dfNone,          0,     true,       true);
					
					InitDataProperty(0, cnt++ , dtHidden,    130,    daCenter,   true, "cust_cnt_cd2",    false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    170,    daCenter,   true, "cust_seq2",       false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    130,    daCenter,   true, "shpr_cnt_cd2",    false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    150,    daCenter,   true, "shpr_seq2",       false,          "",       dfNone,          0,     true,       true);
                    
                    InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");//영대문자 + 숫자만 입력되도록 설정
                    InitDataValid(0, "cust_nm", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); //한글빼고 입력
                    InitDataValid(0, "shpr_cd", vtEngUpOther, "1234567890");//영대문자 + 숫자만 입력되도록 설정
                    InitDataValid(0, "shpr_nm", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); //한글빼고 입력
                    //CountPosition  = 0;
				}
				break;

		}
	}

  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

		   case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_AGT_0026GS.do", agtQryStr(formObj));
				break;
				
		   case IBSAVE:		//저장
				if(!validateForm(sheetObj,formObj,sAction))	return false;
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_AGT_0026GS.do", agtQryStr(formObj));
				break;
								
		   case IBINSERT:		//입력
				var Row = sheetObj.DataInsert();
				break;

		   case IBCOPYROW:        //행 복사
			  sheetObj.DataCopy();
			  break;

		   case IBDOWNEXCEL:        //엑셀 다운로드
			  sheetObj.SpeedDown2Excel(-1);
			  break;
		}
	}

    function sheet1_OnPopupClick(sheetObj, row, col){
    	var formObj = document.form;
       //F.Forwarder Popup Click   
	    if (sheetObj.ColSaveName(col) == "cust_cd" || sheetObj.ColSaveName(col) == "shpr_cd") {
	        var cust_cd = sheetObj.CellValue(row, col).substring(0,2);
	        if(cust_cd == ""){
	        	cust_cd = formObj.cust_cnt_cd.value
	        }
	        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
	        var classId = "COM_ENS_041";
		    var param = '?cust_cd=' + cust_cd;
			var chkStr = dispaly.substring(0,3) ;         
	        
	        if(chkStr == "1,0") {
	        	// Radio PopUp  
	        	ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 470, 'getESM_AGT_026_1', dispaly, true, false, row, col, 0);
	        //} else if(chkStr == "0,1") {
	            // CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
	        	//comPopupInSheet('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getESM_AGT_025_2', dispaly, sheetIdx, row, col);
	        //} else if(chkStr == "0,0") {
	           	// Row 선택 PopUp
	        //	comPopupInSheet('/hanjin/COM_ENS_041.do' + param, 770, 470, 'getESM_AGT_025_3', dispaly, row, col);
	        } else if(chkStr == "1,1"){
	           	return;
	        } else {
	           	return;
	        }
	    }
    }
    
    /**
	 * F.Forwarder(Customer) : 팝업에서 Radio로 단일 선택을 한경우..
	 */
	function getESM_AGT_026_1(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];
	    
		var colArray = rowArray[0];
//		alert(colArray[3]+":"+colArray[4]);
		if(sheetObj.ColSaveName(col) == "cust_cd"){
			sheetObj.CellValue(row, "cust_cd") = colArray[3];
			sheetObj.CellValue(row, "cust_nm") = colArray[4];
		}
		
		if(sheetObj.ColSaveName(col) == "shpr_cd"){
			sheetObj.CellValue(row, "shpr_cd") = colArray[3];
			sheetObj.CellValue(row, "shpr_nm") = colArray[4];
		}
	}

   /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
		}

		return true;
	}
	
	function sheet1_OnChange(sheetObj, row, col) {
		if (sheetObj.ColSaveName(col) == "cust_cd") {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		
		if (sheetObj.ColSaveName(col) == "shpr_cd") {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
	}
	
