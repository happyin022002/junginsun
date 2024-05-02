/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0063.js
*@FileTitle :
*Open Issues :
*Change history : 
*@LastModifyDate : 2008-02-28
*@LastModifier : IM OKYOUNG
*              : Jeon Yunju
* 2009.09.16 김기식 Alps전환작업 
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
=========================================================*/

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_COA_0065 : ESM_COA_0065 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0065() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.setSheetObject = setSheetObject;
	this.setRetrieveAction = setRetrieveAction;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
	this.openCostDetail = openCostDetail;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}


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
				case "btn_costdetail":
					openCostDetail();
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_close":
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
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
					Editable = false;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(9, 1, 0, true);
					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

					var HeadTitle = "BKG_NO|Type|Load|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT";
					var HeadTitle1 = "BKG_NO|Type|Load|G.Rev|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"bkg_no");
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");
					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,	true,	"bkg_qty",		false,	"",		dfNullFloatOrg,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"rev",			false,	"",		dfNullFloatOrg,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"cost",			false,	"",		dfNullFloatOrg,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"cm",			false,	"",		dfNullFloatOrg,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"repo_cost_amt",false,	"",		dfNullFloatOrg,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"save",			false,	"",		dfNullFloatOrg,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"cr_amt",		false,	"",		dfNullFloatOrg,	2,	true,	true);

					RangeBackColor(1, 4, 1, 6) = RgbColor(222, 251, 248);	// ENIS
					RangeBackColor(1, 8, 1, 9) = RgbColor(222, 251, 248);	// ENIS

					HeadRowHeight	= 10;
					CountPosition	= 0 ;
					style.height = GetSheetHeight(13) ;

				}
				break;
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

	/*화면이 로드 되면서 바로 retrieve 되도록 */
	function setRetrieveAction(){
		sheetObject = sheetObjects[0];
		formObject = document.form;

		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}

	/**
	* sheet2을 더블클릭하여 팝업을 띄운다.
	*/
	function sheet1_OnDblClick(sheetObj , row, col){
		if(validateForm(sheetObj,document.form,IBSEARCH)) openCostDetail();
	}

	/**
	* BKG detail정보를 팝업창에서 띄워준다.
	*/
	function openCostDetail(){
		var cond = '';
		var row = sheetObjects[0].SelectRow;
		cond = cond + "&f_bkg_no=" +sheetObjects[0].CellValue(row, "bkg_no");
		ComOpenWindow('ESM_COA_0066.do?'+ coaFormQueryString(document.form)+cond, '_Invoice', 'width=750,height=400,menubar=0,status=0,scrollbars=0,resizable=0');
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch4Post("ESM_COA_0065GS.do", coaFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBDOWNEXCEL:	//엑셀 다운로드
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

	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		return true;
	}
