/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0124.js
*@FileTitle : So Cost Code Column hide
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.07.31 임옥영
* 1.0 Creation
* HISTORY
* 2009.11.30 임옥영 bkg_cgo_tp_cd -> full_mty_cd로 컬럼명 변경
* 2012.05.09 전윤주 [CHM-201217633] Hinterland cost table 생성 시 필요한 flag 추가
                   inlnd_expn_use_flg, inlnd_tml_expn_calc_flg, ocn_fdr_expn_use_flg 추가 
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
     * @class ESM_MAS_0124 : ESM_MAS_0124 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0124() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl 			= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
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
				case "btn_close":
					window.close();
				break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage(OBJECT_ERROR);
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
			initSheet(sheetObjects[i]);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj) {

		var cnt = 0;
		with (sheetObj) {

		SheetWidth = mainTable.clientWidth;								//전체 너비 설정
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
		MergeSheet = msHeaderOnly;										//전체Merge 종류 [선택, Default msNone]
		Editable = true;												//전체Edit 허용 여부 [선택, Default false]
		InitRowInfo(1, 1, 9, 100);										//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitColumnInfo(3, 0, 0, true);									//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitHeadMode(false, false, true, true, false,false)			//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

		var HeadTitle = "Column|H|Hide" ;

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		//데이터속성[row,col,		datatype,	width,	dataalign,	colmerge,	savename,	keyfield,	calculogic,	dataformat,
			//pointcount,	 updateedit,	insertedit,	editlen,fullinput,sortenable,tooltip,allcheck,savestatus,formatfix]
		InitDataProperty(0,cnt++,	dtData,			160,	daLeft,		true,	"header");
		InitDataProperty(0,cnt++,	dtHidden,		0,	daLeft,		true,	"col_nm");
		InitDataProperty(0,cnt++,	dtCheckBox,		60,		daCenter,	true,	"flag",	false,	"",	dfNone,	0,true);

		CountPosition  = 0 ;
		style.height = GetSheetHeight(15) ;
				
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

	/* checkbox를 선택하면 부모창의 해당 컬럼을 hidden 시킨다.*/
	function sheet1_OnChange(sheetObj , Row, Col, Val) {
		var sName = sheetObj.ColSaveName(Col);
		if ( sName == "flag") {
			if(Val == "1"){
				opener.columnHideByChild(sheetObj.CellValue(Row, Col-1), true);
			} else { //parent.document.getElementById("sheet1").CellValue(Row, Col-1)
				opener.columnHideByChild(sheetObj.CellValue(Row, Col-1), false);
			}
		}
	}
	
	/* 화면 로딩후 부모창의 Header를 가져와서 데이터를 세팅한다.*/
	function setDataFromParentHeader() {
		
		//sheet세팅
		//HeadTitle1 = "Del.|STS|Seq.|Sub Grouping1 & 2| |Description|Code|Owner\nship|SRC\nSYS|SRC\nMon|Source\nCode|Source Code_Description|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|";
		//sgrp_cost_cd_desc, , stnd_cost_nm, stnd_cost_cd, mas_cost_src_prt_cd, cost_src_sys_cd, cost_src_mon, mas_cost_src_cd, mas_cost_src_cd_nm, cost_ass_bse_cd, cost_ut_amt_cd, bkg_cgo_tp_cd, cost_vol_cd, cost_vol_cd1

		var sheetObj = sheetObjects[0];
		var currentRow = sheetObj.DataInsert(-1); 
		sheetObj.CellValue2(currentRow, 0) = "Sub Grouping1 & 2";sheetObj.CellValue2(currentRow, 1) = "sgrp_cost_cd_desc";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Description";sheetObj.CellValue2(currentRow, 1) = "stnd_cost_nm";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Code";sheetObj.CellValue2(currentRow, 1) = "stnd_cost_cd";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Owner ship";sheetObj.CellValue2(currentRow, 1) = "mas_cost_src_prt_cd";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "SRC SYS";sheetObj.CellValue2(currentRow, 1) = "cost_src_sys_cd";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "SRC Mon";sheetObj.CellValue2(currentRow, 1) = "cost_src_mon";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Source Code";sheetObj.CellValue2(currentRow, 1) = "mas_cost_src_cd";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Source Code_Description";sheetObj.CellValue2(currentRow, 1) = "mas_cost_src_cd_nm";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "C/A";sheetObj.CellValue2(currentRow, 1) = "cost_ass_bse_cd";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "UOM";sheetObj.CellValue2(currentRow, 1) = "cost_ut_amt_cd";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "CGO Type";sheetObj.CellValue2(currentRow, 1) = "full_mty_cd";//bkg_cgo_tp_cd -> full_mty_cd로 컬럼명 변경
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "UOM Code1";sheetObj.CellValue2(currentRow,1) = "cost_vol_cd";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "UOM Code2";sheetObj.CellValue2(currentRow, 1) = "cost_vol_cd1";
		
		if(opener != null){
			var hdCdArr = opener.getHeadCodeByChild().split("|");
			var hdTxtArr=  opener.getHeadTextByChild().split("|");
			for(var k=0; k<hdCdArr.length; k++){
				currentRow = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(currentRow, 0) = hdTxtArr[k];//row, col
				sheetObj.CellValue2(currentRow, 1) = hdCdArr[k].toLowerCase();//row, col
			}
		} 
		
		//HeadTitle1 += "DG|RF|AWK|BB|Rev_MT|SOC|Node_Avg only\nCreation" ;
		//spcl_cgo_dg_flg,spcl_cgo_rf_flg,spcl_cgo_awk_flg,spcl_cgo_bb_flg,bkg_full_soc_cgo_flg,bkg_rev_mcgo_flg,bkg_mcgo_flg
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "DG";sheetObj.CellValue2(currentRow, 1) = "spcl_cgo_dg_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "RF";sheetObj.CellValue2(currentRow, 1) = "spcl_cgo_rf_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "AWK";sheetObj.CellValue2(currentRow, 1) = "spcl_cgo_awk_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "BB";sheetObj.CellValue2(currentRow, 1) = "spcl_cgo_bb_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Rev_MT";sheetObj.CellValue2(currentRow, 1) = "bkg_full_soc_cgo_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "SOC";sheetObj.CellValue2(currentRow, 1) = "bkg_rev_mcgo_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Node_Avg only\nCreation";sheetObj.CellValue2(currentRow, 1) = "bkg_mcgo_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Inland\nTotal";sheetObj.CellValue2(currentRow, 1) = "inlnd_expn_use_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Inland\nDifferential Only";sheetObj.CellValue2(currentRow, 1) = "inlnd_tml_expn_calc_flg";
		currentRow = sheetObj.DataInsert(-1); sheetObj.CellValue2(currentRow, 0) = "Ocean Feeder\nTotal";sheetObj.CellValue2(currentRow, 1) = "ocn_fdr_expn_use_flg";
		
		sheetObj.SelectCell(1,2);
	}
	