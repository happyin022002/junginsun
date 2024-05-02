/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0104.js
*@FileTitle  : Container Type Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
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
/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
        var shtObj=sheetObjects[0];
        var frmObj=document.form;
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_ok":
					comPopupOK();
//					selectCntrTp (shtObj, frmObj)
				  break;
				case "btn_close":
					ComClosePopup(); 
				  break;
			} // end switch
	}
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++]=shtObj;
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
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            // Host정보 설정[필수][HostIp, Port, PagePath]
            //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            // 전체Merge 종류 [선택, Default msNone]
//        	document.form.pagerows.value=500;
//        	SetGetEditEnterBehavior()("tab");
        	switch (shtNo) {
	        	case 1:    // sheet[0] init
	        	var cnt=0;
	        	var HeadTitle="STS|No.|CHK|Type|Description";
	        	(ComCountHeadTitle(HeadTitle), 0, 0, false);
	
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        	InitHeaders(headers, info);
	
	        	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	        	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_tp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	        	 
	        	InitColumns(cols);
	        	SetEditable(1);
	        	SetSheetHeight(300);
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
				frmObj.f_cmd.value=SEARCH;
 				shtObj.DoSearch("ESM_ACM_0104GS.do", FormQueryString(frmObj) );
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
        var cntrTp=document.form.cntrTp.value;
        var arrCntrTp=cntrTp.split(",");
        with (shtObj) {
            if (RowCount()> 0) {
                ReDraw=false;
                for (var i=HeaderRows(); i<=LastRow(); i++) {
                	var shtCntrTp=GetCellValue(i, "cntr_tp_cd");
                	//일치하는 로우에 체크
                	for (var j=0; j<=arrCntrTp.length; j++) {
                		if(shtCntrTp == arrCntrTp[j]) {
                			SetCellValue(i, "chk","Y");
                			break;
                		}
                	}
                }
                ReDraw=true;
            }
        }
    }
	/**
	 * 사용자가 선택한 값을 부모 창의 그리드로 값 셋팅
	 * @param {Object} shtObj
	 * @param {Object} frmObj
	 */
	function selectCntrTp (shtObj, frmObj) {
		var opener = window.dialogArguments;
		if (!opener) opener = parent;    // MODAL창에서 부모창 javascript호출
	    var opnr_sheet1=opener.sheet1;
	    var row=frmObj.row.value;
	    var col=frmObj.col.value;
	    var cellVal="";
	    //체크된 행의 번호를 읽어온다.
	    var iCheckRow=shtObj.FindCheckedRow("chk");
	    //가져온 행을 배열로 만들어 해당 로우의 값을 얻는다.
	    var arrRow=iCheckRow.split("|");
	    for (var i=0; i<arrRow.length; i++) {
	    	if(cellVal.length > 0) {
	    		cellVal=cellVal + "," + shtObj.GetCellValue(arrRow[i], "cntr_tp_cd");
		    } else {
		    	cellVal=shtObj.GetCellValue(arrRow[i], "cntr_tp_cd");
		    }
	    }
	    //부모창의 sheet 에 값 설정
		opnr_sheet1.SetCellValue(row, col, cellVal);
//		ComClosePopup(); 
	}
	/* 개발자 작업  끝 */
