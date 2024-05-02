/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0066.js
*@FileTitle :
*Open Issues :  주석작성
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*Change history :
* 2009.09.16 김기식 Alps전환작업
* 2009-10-12 임옥영  ticket-id:CHM-200901248 EQ Repo Contribution 메뉴 수정 요청
*                                                     Volume incentive  계정 비용 추가
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리                                                    
=========================================================*/

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_COA_0066 : ESM_COA_0066 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0066() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.setSheetObject = setSheetObject;
	this.setRetrieveAction = setRetrieveAction;	
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
	function loadPage(cntrs) {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1,cntrs);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	}

	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj, sheetNo, cntrs) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:		//sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
					Editable = false;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]

					var HeadTitle = "H_IT|Items|BKG Total|BKG Total|";
					var HeadTitle1 = "H_IT|Items|Full PFMC|MT Repo.\nSimulated|" ;
					var aryCd = null;
					var aryCnt = 0;

					//가변헤더의 헤더정보 세팅
					if(cntrs != ''){
						cntrs.substring(1);

						aryCd = cntrs.split("|");
						aryCnt = aryCd.length;
						HeadTitle = "H_IT|Items|BKG Total|BKG Total|";
						HeadTitle1 = "H_IT|Items|Full PFMC|MT Repo.\nSimulated|";
						for(var k=0; k<aryCnt; k++) {
							HeadTitle = HeadTitle + aryCd[k]+ "|" +	aryCd[k];
							HeadTitle1 = HeadTitle1 + "Full PFMC|MT Repo.\nSimulated";
							if(k != aryCnt-1) {
								HeadTitle = HeadTitle + "|";
								HeadTitle1 = HeadTitle1 + "|";
							}
						}
					}

					//
					document.form.f_cntrNo.value = aryCnt;

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					if(aryCnt>0) InitColumnInfo(4+(aryCnt*2), 2, 0, true);
					else InitColumnInfo(4, 2, 0, true);

					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,	50,		daRight,	true,	"item");
					InitDataProperty(0, cnt++ , dtData,		125,	daCenter,	true,	"item_nm");
					InitDataProperty(0, cnt++ , dtData,		75,		daRight,	true,	"estm_total", false, "", dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtData,		75,		daRight,	true,	"repo_total", false, "", dfNullFloatOrg, 2);

					//가변헤더의 데이터 속성 Setting
					if(cntrs != ''){
						for(var k=0; k<aryCnt; k++) {
							InitDataProperty(0,	cnt++,	dtData,	70,	daRight,	true,	'estm_' + aryCd[k], false, "", dfNullFloatOrg, 2);
							InitDataProperty(0,	cnt++,	dtData,	70,	daRight,	true,	'repo_' + aryCd[k], false, "", dfNullFloatOrg, 2);
						}
					}

					//CellBackColor(1,"a1") = RgbColor(222, 251, 248);	// ENIS
					if(aryCnt>0){
						RangeBackColor(1, 2, 1, 3+(aryCnt*2)) = RgbColor(222, 251, 248);	// ENIS
					} else {
						RangeBackColor(1, 2, 1, 3) = RgbColor(222, 251, 248);	// ENIS
					}

					HeadRowHeight	= 10;
					CountPosition	= 0 ;
					style.height = GetSheetHeight(13) ;
					//AutoSumBottom = 2;

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
	* 조회후 소계 계산
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		//sheetObj.ShowSubSum( "estm_total", "estm_total", -1, true, false);
		var cnt = parseInt(document.form.f_cntrNo.value);//컨테이너 갯수
	    var start_data_row = 4;//Full Stevedorage
		var last_data_row = 13;// Terminal Volume Inccentive, 앞으로 컬럼 추가,삭제시 이 값만 변경하면 됨
		//cost total
		//Full Stevedorage(4) ~ Terminal Volume Incentive(13) 까지의 합
		sheetObj.CellValue2(last_data_row + 1, "estm_total") = sheetObj.ComputeSum("|2|", start_data_row, last_data_row);
		sheetObj.CellValue2(last_data_row + 1, "repo_total") = sheetObj.ComputeSum("|3|", start_data_row, last_data_row);

		//contribution margin
		sheetObj.CellValue2(last_data_row + 2, "estm_total") = sheetObj.CellValue(3, "estm_total") - sheetObj.CellValue(last_data_row + 1, "estm_total");
		sheetObj.CellValue2(last_data_row + 2, "repo_total") = sheetObj.CellValue(3, "repo_total") - sheetObj.CellValue(last_data_row + 1, "repo_total");
		//cost saving
		sheetObj.CellValue2(last_data_row + 3, "estm_total") = sheetObj.CellValue(last_data_row + 2, "estm_total") - sheetObj.CellValue(last_data_row + 2, "repo_total");

		var m = 0;
		var saving = 0;
		for(var k=2; k<=(2*cnt + 3); k++) {
			//cost_total
			sheetObj.CellValue2(last_data_row + 1, k) = sheetObj.ComputeSum("|"+ k +"|", start_data_row, last_data_row);
			//contribution margin
			sheetObj.CellValue2(last_data_row + 2, k) = sheetObj.CellValue(3, k) - sheetObj.CellValue(last_data_row + 1, k);

			if(k%2==1){
				//cost saving
				sheetObj.CellValue2(last_data_row + 3, k-1) = sheetObj.CellValue(last_data_row + 2, k-1) - sheetObj.CellValue(last_data_row + 2, k);
				//credit amount
				sheetObj.CellValue2(last_data_row + 4, k-1) = sheetObj.CellValue(last_data_row + 3, k-1) * sheetObj.CellValue(last_data_row + 5, k-1);
				saving = saving + parseFloat(sheetObj.CellValue(last_data_row + 4, k-1));
				//credit ratio 100분율 변경
				if(k>3)	sheetObj.CellValue2(last_data_row + 5, k-1) = parseFloat(sheetObj.CellValue(last_data_row + 5, k-1))*100;;
			}
		}
		//
		sheetObj.CellValue2(last_data_row + 4, "estm_total") = saving;

		//포커스 이동 및 sum관련
		sheetObj.SelectCell(last_data_row + 1, 0, false);
		sheetObj.RangeBackColor(last_data_row + 1,1,last_data_row + 1, 2*cnt+3 ) = sheetObj.UnEditableColor ;
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
				sheetObj.DoSearch4Post("ESM_COA_0066GS.do", coaFormQueryString(formObj));
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

