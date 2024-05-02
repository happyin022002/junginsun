/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0141.js
*@FileTitle : Link별 표준단가 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2007-06-07 IM OKYOUNG
* 1.0 최초 생성
=========================================================
* History
* 2009.09.04 장영석 New frame work 적용 
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2011.12.30 최윤성 [CHM-201115391-01] [COA] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - avg_lvl_chk 추가 하여 값에 따라 색상 및 Bold 처리
* ======================================================*/
/****************************************************************************************
	이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_COA_0139 : ESM_COA_0139 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0139() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setRetrieveAction 		= setRetrieveAction;
    	this.validateForm   		= validateForm;
    }
    
/* 공통전역변수 */
//var calPop = new calendarPopupGrid();
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		

		try {
		    var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

                case "btn_Close":
                    window.close();
                    break;

			} // end switch
		}catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
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
			case 1:		//sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msPrevColumnMerge;//msHeaderOnly; //msAll;
					Editable = false;
					InitRowInfo(2, 1, 9, 100);
					InitColumnInfo(7, 0, 0, true);
					InitHeadMode(false, false, false, true, false,false);

					var HeadTitle = "Node Link|Activity Group|Cost Group/Cost Element|Feeder Term|Feeder Term|Amt|avg_lvl_chk" ;
					var HeadTitle1 = "Node Link|Activity Group|Cost Group/Cost Element|Rev_Term|Del_Term|Amt|avg_lvl_chk" ;
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);

					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"nod_cd");
					//InitDataProperty(0, cnt++, dtHidden,	30,		daCenter,	true,	"cost_act_grp_seq");
					InitDataProperty(0, cnt++, dtData,		130,	daCenter,	true,	"grp");
					InitDataProperty(0, cnt++, dtData,		220,	daLeft,		true,	"tree_col");					
					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_rcv_term_cd");
					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_de_term_cd");
					InitDataProperty(0, cnt++ ,dtAutoSum,	80,		daRight,	true,	"amt",		false,	"",		dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ ,dtHidden,	70,		daCenter,	true,	"avg_lvl_chk");

					RangeBackColor(1, 3, 1, 4) = RgbColor(222, 251, 248);

					InitTreeInfo("tree_col", "", RgbColor(0,0,255), false);
					CountPosition	= 0 ;
					style.height = GetSheetHeight(20) ;
				}
				break;
		}
	}
	
	/**
	 * sheet1조회후 상단 정보 세팅
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        sheetObj.ShowTreeLevel(0, 1);
        
        // NOD, LOC를 제외한 평균단가로 추정된 비용에 대해 파란색 글씨 및 진하게 표시
        var s_row = 1;
        
        while(s_row > 0){
        	s_row = sheetObj.FindText("avg_lvl_chk", "Y", s_row);
        	
        	if(s_row == -1) {
        		break;
        	}
        	
        	sheetObj.CellFont("FontBold", s_row, 0, s_row, "avg_lvl_chk") = true;
        	sheetObj.RowFontColor(s_row) = sheetObj.RgbColor(0,0,255);
        	s_row = s_row + 1;
        }
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {

		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:		//조회
				if(validateForm(sheetObj,formObj,sAction)){
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESM_COA_0141GS.do", coaFormQueryString(formObj));
					ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL:		//엑셀 다운로드
				var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
						sheetObj.Down2Excel(0, false, false, true);
						break;
					case "DY":
						sheetObj.Down2Excel(-1, false, false, true);
						break;
					case "AN":
						sheetObj.SpeedDown2Excel(0, false, false);
						break;
					case "DN":
						sheetObj.SpeedDown2Excel(-1, false, false);
						break;
				}

				break;
		}
	}
	

	/*화면이 로드 되면서 바로 retrieve 되도록 */
	function setRetrieveAction(){
		sheetObject = sheetObjects[0];
		formObject = document.form;
		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}

		return true;
	}




