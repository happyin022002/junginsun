// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
//        var array = new Array();
        
		/*******************************************************/
		var formObject = document.form;
        
		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				 case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				 case "btn_ok":
    				popUpOk(sheetObject,formObject);
					break;
					
				 case "btn_close":
					self.close();
					break;
					
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;	
					
				case "btng_rowclear":
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
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
		    doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);    
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
					style.height = GetSheetHeight(8) ;
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
					InitColumnInfo(5, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Rdo.|Del.|STS|No|Location";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC,     DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,   30,    daCenter,  false,    "radio",     false,          "",       dfNone,	    0,          true,       true);
					InitDataProperty(0, cnt++ , dtDelCheck,     30,    daCenter,  false,    "check",     false,          "",       dfNone,   	0,          true,       true);
					InitDataProperty(0, cnt++ , dtStatus,       30,    daCenter,  false,    "",          false,          "",       dfNone,   	0,          false,      true);
					InitDataProperty(0, cnt++ , dtSeq,          50,    daCenter,   true,    "",          false,          "",       dfNone,      0,          true,       true);
					InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   true,    "rout_info_cd",    false,          "",       dfNone,      0,          true,       true,     6);

                    InitDataValid(0, "rout_info_cd", vtEngUpOnly);
				}
				break;

		}
	}

    // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {

		sheetObj.ShowDebugMsg = false;
        var newRow = -1;
        
		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_AGT_0035GS.do", agtQryStr(formObj));			
				break;
				
			case IBINSERT:      // 입력
				sheetObj.DataInsert(); 
				break;
				
			case IBCLEAR:      // 삭제
				sheetObj.RowDelete(); 
				break;
								
		}
	}
	
	// 데이타 입력 유무를 체크한다.
	function popUpOk(sheetObj,formObj) {
        if(checkData(sheetObj,formObj)==false) {
            return false;
        }
	    comPopupOK();
	}
	
	// 데이타 입력 유무를 체크한다.
	function checkData(sheetObj,formObj) {
	   	var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		var value = "";

		if(rows == 0) {
		    showErrMessage(getMsg("AGT10004", "", "", ""));
		    return false;
		} else {
    		for(var i = 1; i < rows; i++) {
  			    value = trim(sheetObj.CellValue(i, 4));
                if(value == null || value.length == 0) {
                    showErrMessage(getMsg("AGT10001", "Location", "", ""));
                    sheetObj.SelectCell (i, 4);
                    return false;
                }
      		}
		}
		
		return true;
	}
	
	
	function validateForm(sheetObj,formObj,sAction){

		with(formObj){
		   
		}

		return true;
	}
	
