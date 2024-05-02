/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0104.js
*@FileTitle : Container Type Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.14 김봉균
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

    /**
     * @extends
     * @class ESM_ACM_0104 : ESM_ACM_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function ESM_ACM_0104() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
	
/* 개발자 작업	*/


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_ok":
					selectCntrTp (shtObj, frmObj)
				  break;

				case "btn_close":
					  window.close();
				  break;

			} // end switch
	}


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++] = shtObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {

        with (shtObj) {

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
            InitRowInfo(1, 1, 13, 500);
            document.form.pagerows.value = 500;

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, false, false, true, false, false);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            //WaitImageVisible = false;

            CountPosition = 0;


            switch (shtNo) {
                case 1:    // sheet[0] init
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(10);

                    // 전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|No.|CHK|Type|Description";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,30,	daCenter,   false,	"",	 			 false,		  "",	   dfNone,   	  0,	 false,	  true);
					InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,  	false,	"",	 			 false,		  "",	   dfNone,		  0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtCheckBox,   40,	daCenter,   false,	"chk",	 		 false,		  "",	   dfNone,		  0,	 true,	   true);
					InitDataProperty(0, cnt++ , dtData,	   	50,		daCenter,   false,	"cntr_tp_cd",	 false,		  "",	   dfNone,		  0,	 false,	   false);
					InitDataProperty(0, cnt++ , dtData,	   	50,		daLeft,   	false,	"cntr_tp_desc",	 false,		  "",	   dfNone,		  0,	 false,	   false);

                    break;
            }
        }
    }


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj,frmObj,sAction) {
		switch(sAction) {
		
			case IBSEARCH:	  //조회
				if (!ComChkValid(frmObj)) return;
				//ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_ACM_0104GS.do", FormQueryString(frmObj));
				//ComOpenWait(false);
				break;
		}
	}


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        // 조회조건의 Office Select Object 생성
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        //부모창에서 넘어온 Container Type 리스트를 배열로
        var cntrTp = document.form.cntrTp.value;
        var arrCntrTp = cntrTp.split(",");
        with (shtObj) {
            if (RowCount > 0) {
                ReDraw = false;
                for (var i=HeaderRows; i<=LastRow; i++) {
                	var shtCntrTp = CellValue(i, "cntr_tp_cd");
                	//일치하는 로우에 체크
                	for (var j=0; j<=arrCntrTp.length; j++) {
                		if(shtCntrTp == arrCntrTp[j]) {
                			CellValue(i, "chk") = "Y";
                			break;
                		}
                	}
                }
                ReDraw = true;
            }
        }
    }


	/**
	 * 사용자가 선택한 값을 부모 창의 그리드로 값 셋팅
	 * @param {Object} shtObj
	 * @param {Object} frmObj
	 */
	function selectCntrTp (shtObj, frmObj) {
		var opener = window.dialogArguments;    // MODAL창에서 부모창 javascript호출
	    var opnr_sheet1 = opener.document.form.sheet1;
	    var row = frmObj.row.value;
	    var col = frmObj.col.value;
	    var cellVal = "";
	
	    //체크된 행의 번호를 읽어온다.
	    var iCheckRow = shtObj.FindCheckedRow("chk");

	    //가져온 행을 배열로 만들어 해당 로우의 값을 얻는다.
	    var arrRow = iCheckRow.split("|");
	    for (var i=0; i<arrRow.length-1; i++) {
	    	if(cellVal.length > 0) {
		       cellVal = cellVal + "," + shtObj.CellValue(arrRow[i], "cntr_tp_cd");
		    } else {
		        cellVal = shtObj.CellValue(arrRow[i], "cntr_tp_cd");
		    }
	    }
	    //부모창의 sheet 에 값 설정
		opnr_sheet1.CellValue(row, col)  =  cellVal;
		window.close();
	}

	/* 개발자 작업  끝 */