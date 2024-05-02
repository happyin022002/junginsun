/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0002.js
*@FileTitle : Register C/A Code 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.09 김기대
* 1.0 Creation 
* =========================================================
* History
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
=========================================================*/
/**
 * @extends 
 * @class ESM_COA_0002 : ESM_COA_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0002() {
    this.processButtonClick		= processButtonClick;
    this.goURL()               	= goURL();
    this.loadPage 				= loadPage;
    this.initSheet 				= initSheet;
    this.setSheetObject 		= setSheetObject;
    this.sheet1_OnChange 		= sheet1_OnChange;
    this.doActionIBSheet 		= doActionIBSheet;
    this.doActionIBSheet2 		= doActionIBSheet2;
    this.validateForm           = validateForm;
}

// 공통전역변수
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

				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;


			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg(OBJECT_ERROR));
			} else {
				ComShowMessage(e);
			}
		}
	}

	// radio 버튼 클릭 시 화면 전환
	function goURL( kind ){
		if ( kind == "1" )	{
			document.location.href = "/hanjin/ESM_COA_0002.do";
		} else if ( kind == "2") {
			document.location.href = "/hanjin/ESM_COA_0003.do?pgmNo=ESM_COA_0003";
		}
	}

	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);//khlee-시작 환경 설정 함수 이름 변경
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);//khlee-마지막 환경 설정 함수 추가
		}
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		btn_retrieve.focus();
	}
	
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		switch(sheetNo) {
			case 1:	//sheet1 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;														//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;																//전체Merge 종류 [선택, Default msNone]
					Editable = true;																		//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo(2, 1, 9, 100);																//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(18, 3, 0, true);														//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
					var HeadTitle0 = "||Profit Level" +
							"|Profitability-related View|Profitability-related View|Profitability-related View|Profitability-related View" +
							"|Profitability-related View|Profitability-related View||" +
							"|Responsibility-related View|Responsibility-related View|Responsibility-related View|Responsibility-related View" +
							"|Responsibility-related View|Responsibility-related View" +
							"|";
					var HeadTitle1 = "Del.|STS|Profit Level" +
							"|Main Grouping1|H_MG|Sub Grouping1|Grp\nCode1|PA View Code|PA View Code" +
							"|View\nHierarchy1|Hire-Cost\nSelect" +
							"|Main Grouping2|H_S_MG|Sub Grouping2|Grp\nCode2|RA View Code|RA View Code" +
							"|View\nHierarchy2"

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
					//데이터속성	[row,		col,	datatype,	width,	dataalign,	colmerge,	savename,	keyfield,	calculogic, dataformat, pointcount, updateedit, insertedit, editlen, fullinput, sortenable, tooltip, allcheck, savestatus, formatfix]
					InitDataProperty(0, cnt++ , dtCheckBox,	25,	daLeft,		false,	"delt_flg");
					InitDataProperty(0, cnt++ , dtStatus,	25,	daLeft,		false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCombo,	120,daLeft,		true,	"stnd_cost_tp_cd",	true,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,	120,daLeft,		true,	"mgrp_cost_nm",		true,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	50,	daLeft,		true,	"mgrp_cost_cd",		true,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,	130,daLeft,		true,	"sgrp_cost_nm",		true,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		55,	daCenter,	true,	"sgrp_cost_cd",		true,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		200,daLeft,		false,	"stnd_cost_nm",		true,	"",	dfNone,	0,	true,	true, 1000);
					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	false,	"stnd_cost_cd",		true,	"",	dfNone,	0,	false,	true, 8, true);
					InitDataProperty(0, cnt++ , dtData,		65,	daCenter,	false,	"perf_vw_cd",		false,	"",	dfNone,	0,	true,	true, 3, true);
					InitDataProperty(0, cnt++ , dtCheckBox,	60,	daCenter,	false,	"hir_scp_flg",		false,	"",	dfNone,	0,	true,	true);
					//책임회계
					InitDataProperty(0, cnt++ , dtCombo,	120,daLeft,		true,	"ra_mn_cost_nm",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	50,	daLeft,		true,	"ra_mn_cost_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,	130,daLeft,		true,	"ra_sgrp_cost_nm",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"ra_sgrp_cost_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		200,daLeft,		false,	"krn_cost_full_desc",	false,	"",	dfNone,	0,	true,	true, 1000);
					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	false,	"ra_acct_cd",			false,	"",	dfNone,	0,	true,	true, 8, true);
					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	false,	"ra_perf_vw_cd",		false,	"",	dfNone,	0,	true,	true, 3, true);

					CountPosition = 0 ;
					RangeBackColor(1, 2, 1, 8) = RgbColor(222, 251, 248);  // ENIS
					RangeBackColor(1, 11, 1, 16) = RgbColor(222, 251, 248);  // ENIS

					style.height = GetSheetHeight(23) ;
					//HeadRowHeight = 10;

					//InitDataValid(DataRow, Col, ValidType, [ValidChar])
					InitDataValid(0, "stnd_cost_nm", vtEngOther, " "); //stnd_cost_nm
					InitDataValid(0, "stnd_cost_cd", vtEngOther, "0123456789"); //stnd_cost_cd
					InitDataValid(0, "perf_vw_cd", vtEngUpOnly); //perf_vw_cd
					InitDataValid(0, "krn_cost_full_desc", vtEngOther, " "); //krn_cost_full_desc
					InitDataValid(0, "ra_acct_cd", vtEngOther, "0123456789"); //ra_acct_cd
					InitDataValid(0, "ra_perf_vw_cd", vtEngUpOnly); //ra_perf_vw_cd

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
	
	// stnd_cost_tp_cd, mgrp_cost_cd가 변경되었을때 mnGroup을 변경시킨다.
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.hiddenF;
		var tmpSN = sheetObj.ColSaveName(col);
		formObj.sRow.value = row;
		if(tmpSN == "stnd_cost_tp_cd")	{
			formObj.changeCol.value = "stnd_cost_tp_cd";
			formObj.changeValue.value = value;
			doActionIBSheet(sheetObj,formObj,IBROWSEARCH);
		} else if(tmpSN == "mgrp_cost_nm") {
			sheetObj.CellValue(row, "mgrp_cost_cd") = value;
			formObj.changeCol.value = "mgrp_cost_cd";
			formObj.changeValue.value = value;
			sheetObj.CellValue2(row,"mgrp_cost_cd") = value;
			doActionIBSheet(sheetObj,formObj, IBROWSEARCH)
		} else if(tmpSN == "sgrp_cost_nm"){
			sheetObj.CellValue2(row,"sgrp_cost_cd") = value;
		} else if(tmpSN == "ra_mn_cost_nm") {//ra
			sheetObj.CellValue(row, "ra_mn_cost_cd") = value;
			formObj.changeCol.value = "ra_mn_cost_cd";
			formObj.changeValue.value = value;
			sheetObj.CellValue2(row,"ra_mn_cost_cd") = value;
			doActionIBSheet2(sheetObj,formObj, IBROWSEARCH)
		} else if(tmpSN == "ra_sgrp_cost_nm"){//ra
			sheetObj.CellValue2(row,"ra_sgrp_cost_cd") = value;
		}

		if(tmpSN == "ra_sgrp_cost_nm"){

		}

	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_COA_0002_1GS.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "stnd_cost_tp_cd", false, 0);
				if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "mgrp_cost_nm", false, 0);
				if (arrXml.length > 2)
					ComCoaSetIBCombo(sheetObj, arrXml[2], "sgrp_cost_nm", false, 0);
				if (arrXml.length > 3)
					ComCoaSetIBCombo(sheetObj, arrXml[3], "ra_mn_cost_nm", false, 0);
				if (arrXml.length > 4)
					ComCoaSetIBCombo(sheetObj, arrXml[4], "ra_sgrp_cost_nm", false, 0);
				
				ComOpenWait(false);
			break	
			
			case IBSEARCH:	//조회
				if(validateForm(sheetObj,formObj,sAction)){
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCHLIST;
					sheetObj.DoSearch4Post("ESM_COA_0002GS.do", coaFormQueryString(formObj, 'cond1|code'));
					ComOpenWait(false);
				}
				break;

			case IBSAVE:		//저장
				if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_COA_0002GS.do", coaFormQueryString(formObj, 'cond1|code'));
				ComOpenWait(false);
				}
				break;

			case IBROWSEARCH: //행내용 업데이트
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var formObj2 = document.hiddenF;
				formObj2.f_cmd.value = MULTI02;
				sheetObj.DoRowSearch("ESM_COA_0002GS2.do", coaFormQueryString(formObj2));
				ComOpenWait(false);
				break;

			case IBINSERT:	// 입력
				sheetObj.DataInsert(-1); // 마지막행에 행삽입
				//sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
                sheet1_OnChange(sheetObj, sheetObj.LastRow, 3, sheetObj.CellValue(sheetObj.LastRow, "mgrp_cost_nm"));
				break;

			case IBCOPYROW:	//행 복사
				sheetObj.DataCopy();
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

	// Sheet관련 프로세스 처리
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBROWSEARCH: //행내용 업데이트
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var formObj2 = document.hiddenF;
				formObj2.f_cmd.value = MULTI02;
				sheetObj.DoRowSearch("ESM_COA_0002GS3.do", coaFormQueryString(formObj2));
				ComOpenWait(false);
				break;
		}
	}
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		var rtn = true;
		with(formObj){			
			var dr = sheetObj.ColValueDup("stnd_cost_cd");
			if(dr>0){//중복된 값이 있는경우				
				ComShowCodeMessage('COM12115', 'PA View_Code');
				sheetObj.SelectCell(dr,"stnd_cost_cd");
				rtn = false;
			}
		}
		return rtn;
	}