/**
*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0003.js
*@FileTitle : 물류비용 코드 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : OKYOUNG IM
*@LastVersion : 1.0
* 2006-10-13 OKYOUNG IM
* 1.0 최초 생성
* =========================================================
* History
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2009.09.16 김기식 Alps전환작업 
* 2010.02.19 이연각 업무처리중 버튼사용 금지 처리
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2012.05.07 전윤주 [CHM-201217633] Hinterland cost table 생성 시 필요한 flag 추가
                   inlnd_expn_use_flg, inlnd_tml_expn_calc_flg, ocn_fdr_expn_use_flg 추가
* 2012.11.20 원종규 [CHM-201221551] inlnd_expn_use_flg, inlnd_tml_expn_calc_flg, ocn_fdr_expn_use_flg 체크 시 로직 추가
* =========================================================
*/ 

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_COA_0003 : ESM_COA_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0003() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.setSheetObject = setSheetObject;
	this.goURL = goURL;
	this.changeStndCostCode = changeStndCostCode;
	this.openHideCheckBox = openHideCheckBox;
	this.columnHideByChild = columnHideByChild;
	this.sheet1_OnChange = sheet1_OnChange;
	this.getHeadCodeByChild = getHeadCodeByChild;
	this.getHeadTextByChild = getHeadTextByChild;
	this.doActionIBSheet = doActionIBSheet;
	this.doActionIBSheet2 = doActionIBSheet2;
	this.validateForm = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

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

				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "btng_hidecheckbox":
					openHideCheckBox();
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
	function loadPage(hdCode, hdText) {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);//khlee-시작 환경 설정 함수 이름 변경
			initSheet(sheetObjects[i],i+1, hdCode, hdText);
			ComEndConfigSheet(sheetObjects[i]);//khlee-마지막 환경 설정 함수 추가
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
        btn_retrieve.focus();
	}
	/**
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
    	 with (comboObj) {
	    	 DropHeight = 300;
	    	 comboObj.InsertItem(0, 'All' ,'');
	    	 Index = 0;
	    	 
    	 }
     }	
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo, hdCode, hdText) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:
				with (sheetObj) {
				style.height = GetSheetHeight(23) ;
				SheetWidth = mainTable.clientWidth;													//전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msHeaderOnly;															//전체Merge 종류 [선택, Default msNone]
				Editable = true;																	//전체Edit 허용 여부 [선택, Default false]
				InitRowInfo(2, 1, 9, 100);															//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				var HeadTitle0 = "Del.|STS|Seq.|Sub Grouping1 & 2|H_SG|PA View Code & RA View Code|PA View Code & RA View Code|Owner\nship|SRC\nSYS|SRC\nMon|Source Code|Source Code_Description" +
						"|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|" +
						"OTD1|OTD2|OTD3|OTD4|OTD5|OTD6|OTD7|OTD8|OTD9|OTD10|OTD11|OTD12|OTD13|OTD14|OTD15|OTD16|OTD17|OTD18|OTD19|OTD20|OTD21|OTD22|OTD23|OTD24|OTD25|OTD26|OTD27|OTD28|OTD29|OTD30|OTD31" +
						"|Spcial Cargo Type|Spcial Cargo Type|Spcial Cargo Type|Spcial Cargo Type|Cost Deleted|Cost Deleted|Cost Deleted|Node_Avg only\nCreation|Cost Table|Cost Table|Cost Table" ;
				var HeadTitle1 = "Del.|STS|Seq.|Sub Grouping1 & 2|H_SG|Description|Code|Owner\nship|SRC\nSYS|SRC\nMon|Source Code|Source Code_Description" +
						"|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|" +
						"OTD1|OTD2|OTD3|OTD4|OTD5|OTD6|OTD7|OTD8|OTD9|OTD10|OTD11|OTD12|OTD13|OTD14|OTD15|OTD16|OTD17|OTD18|OTD19|OTD20|OTD21|OTD22|OTD23|OTD24|OTD25|OTD26|OTD27|OTD28|OTD29|OTD30|OTD31" +
						"|DG|RF|AWK|BB|Rev_MT|SOC|Node_Avg only\nCreation|Inland\nTotal|Inland\nDifferential Only|Ocean Feeder\nTotal" ;
				var aryNm = null;
				var aryCd = null;
				var aryCnt = 0;

				//가변헤더의 헤더정보 세팅
				if(hdCode != '' && hdText != ''){
					aryNm = hdText.split("|");
					aryCd = hdCode.split("|");
					aryCnt = aryNm.length;

					HeadTitle0 = "Del.|STS|Seq.|Sub Grouping1 & 2| |PA View Code & RA View Code|PA View Code & RA View Code|Owner\nship|SRC\nSYS|SRC\nMon|Source\nCode|Source Code_Description|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|";
					HeadTitle1 = "Del.|STS|Seq.|Sub Grouping1 & 2| |Description|Code|Owner\nship|SRC\nSYS|SRC\nMon|Source\nCode|Source Code_Description|C/A|UOM|CGO\nType|UOM\nCode1|UOM\nCode2|";

					for(var k=0; k<aryCnt; k++) {
						HeadTitle0 = HeadTitle0 + aryNm[k]+ "|";
						HeadTitle1 = HeadTitle1 + aryCd[k]+ "|";
					}

					HeadTitle0 += "Spcial Cargo Type|Spcial Cargo Type|Spcial Cargo Type|Spcial Cargo Type|Cost Deleted|Cost Deleted|Node_Avg only\nCreation|Cost Table|Cost Table|Cost Table";
					HeadTitle1 += "DG|RF|AWK|BB|Rev_MT|SOC|Node_Avg only\nCreation|Inland\nTotal|Inland\nDifferential Only|Ocean Feeder\nTotal" ;
				}

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				if(aryCnt>0) InitColumnInfo(27+aryCnt, 11, 0, true);
				else InitColumnInfo(58, 11, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성[ROW,COL,	DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,	KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,
				//	EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
				InitDataProperty(0,cnt++,	dtCheckBox,	30,	daCenter,	true,	"delt_flg",				false,	"",	dfNone,		0,	true,	true,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtStatus,	30,	daCenter,	true,	"ibflag",				false,	"",	dfNone,		0,	false,	false,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtHidden,	27,	daCenter,	true,	"seq",					false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,cnt++,	dtCombo,	140,daLeft,		true,	"sgrp_cost_cd_desc",	true,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,cnt++,	dtHidden,	0,	daCenter,	true,	"sgrp_cost_cd",			true,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,cnt++,	dtCombo,	140,daLeft,		true,	"stnd_cost_nm",			false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,cnt++,	dtData,		60,	daCenter,	true,	"stnd_cost_cd",			true,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,cnt++,	dtData,		45,	daCenter,	true,	"coa_cost_src_prt_cd",	false,	"",	dfNone,		0,	true,	true,	2,	false,	false);
				InitDataProperty(0,cnt++,	dtData,		40,	daCenter,	true,	"cost_src_sys_cd",		false,	"",	dfNone,		0,	true,	true,	3,	false,	false);
				InitDataProperty(0,cnt++,	dtData,		30,	daCenter,	true,	"cost_src_mon",			false,	"",	dfNone,		0,	true,	true,	2,	false,	false);
				InitDataProperty(0,cnt++,	dtData,		60,	daCenter,	true,	"coa_cost_src_cd",		true,	"",	dfNone,		0,	true,	true,	8);
				InitDataProperty(0,cnt++,	dtData,		150,daLeft,		true,	"coa_cost_src_cd_nm",	false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,cnt++,	dtCombo,	60,	daCenter,	true,	"cost_ass_bse_cd",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,cnt++,	dtData,		40,	daCenter,	true,	"cost_ut_amt_cd",		false,	"",	dfNone,		0,	true,	true,	3,	false,	false);
				//
				InitDataProperty(0,cnt++,	dtData,		50,	daCenter,	true,	"full_mty_cd",		false,	"",	dfEngUpKey,	0,	true,	true,	1,	false,	false);
				InitDataProperty(0,cnt++,	dtData,		60,	daCenter,	true,	"cost_vol_cd",			false,	"",	dfEngUpKey,	0,	true,	true,	8,	false,	false);
				InitDataProperty(0,cnt++,	dtData,		60,	daCenter,	true,	"cost_vol_cd1",			false,	"",	dfEngUpKey,	0,	true,	true,	8,	false,	false);
				//otd
				//가변헤더의 데이터 속성 Setting
				if(hdCode != '' && hdText != ''){
					for(var k=0; k<aryCnt; k++) {
						aryCd[k]=aryCd[k].toLowerCase();
						InitDataProperty(0,	cnt++,	dtCheckBox,	100,	daCenter,	true,	aryCd[k],	false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
					}
				} else {
					for(var k=1; k<32; k++){
						InitDataProperty(0,	cnt++,	dtCheckBox,	100,	daCenter,	true,	"otd"+k,	false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
					}
				}

				//spcl
				InitDataProperty(0,cnt++,	dtCheckBox,	50,	daCenter,	true,	"spcl_cgo_dg_flg",		false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtCheckBox,	50,	daCenter,	true,	"spcl_cgo_rf_flg",		false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtCheckBox,	50,	daCenter,	true,	"spcl_cgo_awk_flg",				false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtCheckBox,	50,	daCenter,	true,	"spcl_cgo_bb_flg",				false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);

				InitDataProperty(0,cnt++,	dtCheckBox,	50,	daCenter,	true,	"bkg_full_soc_cgo_flg",	false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtCheckBox,	50,	daCenter,	true,	"bkg_rev_mcgo_flg",		false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtCheckBox,	100,daCenter,	true,	"bkg_mcgo_flg",		false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
				//Inland EXPN 계정 setting
				InitDataProperty(0,cnt++,	dtCheckBox,	50,	daCenter,	true,	"inlnd_expn_use_flg",		false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtCheckBox,	100, daCenter,	true,	"inlnd_tml_expn_calc_flg",		false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
				InitDataProperty(0,cnt++,	dtCheckBox,	60,	daCenter,	true,	"ocn_fdr_expn_use_flg",		false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);

				InitDataCombo(0, "cost_ass_bse_cd", "|Average|Contract", "|A|C");
				RangeBackColor(1, 5, 1, 7) = RgbColor(222, 251, 248);	// ENIS

				//style.height = GetSheetHeight(23) ;
				CountPosition	= 0
				//HeadRowHeight = 10;

				if(hdCode != '' && hdText != ''){
					RangeBackColor(1, 17, 1, 21+aryCnt-1+3) = RgbColor(222, 251, 248);	// ENIS
				} else {
					RangeBackColor(1, 17, 1, 54) = RgbColor(222, 251, 248);	// ENIS
				}

				//InitDataValid(DataRow, Col, ValidType, [ValidChar])
				InitDataValid(0, "coa_cost_src_prt_cd", vtEngUpOnly);
				InitDataValid(0, "cost_src_sys_cd", vtEngUpOnly);
				InitDataValid(0, "cost_src_mon", vtNumericOnly);
				//InitDataValid(0, "cost_ass_bse_cd", vtCharOnly, "AC");
				InitDataValid(0, "cost_ut_amt_cd", vtEngUpOnly);
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
	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
	// radio 버튼 클릭 시 화면 전환
	function goURL( kind ){
		if ( kind == "1" )	{
			document.location.href	= "/hanjin/ESM_COA_0002.do?pgmNo=ESM_COA_0002";
		} else if ( kind == "2") {
			document.location.href = "/hanjin/ESM_COA_0003.do";
		}
	}

	/**
     * f_selgroup 변경시 sheet의 Header정보를 변경
     */
    function f_sgrp_cost_cd_OnChange(obj, code){
   	 	if (loadingMode == true) return; 
	   	var formObj = document.form;
	    var sheetObj = sheetObjects[0];
	  	formObj.f_cmd.value = SEARCHLIST10;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0003_1GS.do", FormQueryString(formObj));
		
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], formObj.f_stnd_cost_cd, "code", "name");
		formObj.f_stnd_cost_cd.InsertItem(0, 'All' ,'');
		formObj.f_stnd_cost_cd.Index = 0;
    }
    

	function openHideCheckBox(){
		ComOpenWindow('ESM_COA_0124.do?headerCode='+document.form.f_header_code.value, 'Hide Pop', 'width=300,height=430,menubar=0,status=0,scrollbars=0,resizable=0');
		//noRtnPopup('ESM_COA_0124.do?headerCode='+document.form.header_code.value, 'width=300,height=430,menubar=0,status=0,scrollbars=0,resizable=0')
	}

	function columnHideByChild(colName, val){
		sheetObjects[0].ColHidden(colName) = val;
	}
	
	// sgrp_cost_cd가 변경되었을때 stndard cost code 콤보를 변경
	function sheet1_OnChange(sheetObj, Row, Col, value){
		var formObj = document.form;
		var param = "";
		if(sheetObj.ColSaveName(Col) == "sgrp_cost_cd_desc"){
			param = param+"&f_cmd="+SEARCHLIST10;
			param = param+"&f_sgrp_cost_cd="+sheetObj.CellValue(Row,Col);
			
			var sXml = sheetObj.GetSearchXml("ESM_COA_0003_1GS.do", param);
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComCoaSetIBCombo(sheetObj, arrXml[0], "stnd_cost_nm", true,0,Row);
			
			sheetObj.CellValue2(Row,"sgrp_cost_cd") = value;
		}else if(sheetObj.ColSaveName(Col) == "stnd_cost_nm"){
			sheetObj.CellValue2(Row,"stnd_cost_cd") = value;
		}else if(sheetObj.ColSaveName(Col) == "inlnd_tml_expn_calc_flg"){ //Calculation flag가 찍힌 계정은 inland 사용 계정과 동시에 찍혀야 됨
			sheetObj.CellValue2(Row,"inlnd_expn_use_flg") = sheetObj.CellValue(Row,"inlnd_tml_expn_calc_flg")	
		}else if(sheetObj.ColSaveName(Col) == "inlnd_expn_use_flg" && sheetObj.CellValue(Row, "inlnd_expn_use_flg")== 0 
		         && sheetObj.CellValue(Row, "inlnd_tml_expn_calc_flg")== 1  ){
			sheetObj.CellValue2(Row,"inlnd_tml_expn_calc_flg") = 0	//Calculation flag만 찍힐 수 없음           
					 ;
		};
	}
	
	/*
	 * 컬럼 HIDDEN을 위해 팝업창에 headerCode값을 제공
	 */
	function getHeadCodeByChild(){
		return document.form.f_header_code.value;
	}
	
	/*
	 * 컬럼 HIDDEN을 위해 팝업창에 headerText 제공
	 */
	function getHeadTextByChild(){
	  return document.form.f_header_text.value;
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBCLEAR:          //조회				
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0003_1GS.do", coaFormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_sgrp_cost_cd, "code", "name");
				/*if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_stnd_cost_cd, "code", "name");
				*/
				
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "sgrp_cost_cd_desc", false, 0);
				
				if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "stnd_cost_nm", false, 0);			
				
				ComOpenWait(false);
				break	
			case IBSEARCH:	//조회
				
				if(validateForm(sheetObj,formObj,sAction)){
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCHLIST;
					sheetObj.DoSearch4Post("ESM_COA_0003GS.do", coaFormQueryString(formObj, 'f_header_code|f_header_text|code'));
					ComOpenWait(false);
				}				
				
				break;

			case IBSAVE:		//저장
				if(validateForm(sheetObj,formObj,sAction)){
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("ESM_COA_0003GS.do", coaFormQueryString(formObj, 'code'));
					//sheetObj.DoAllSave("ESM_COA_0003GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
				break;

			case IBINSERT:	// 입력
				sheetObj.DataInsert(-1); // 마지막행에 행삽입
				//sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
				sheetObj.CellValue2(sheetObj.LastRow, "sgrp_cost_cd_desc") = getIbComboObjValue(formObj.f_sgrp_cost_cd);
				sheetObj.CellValue2(sheetObj.LastRow, "stnd_cost_nm") = getIbComboObjValue(formObj.f_stnd_cost_cd);
				
				sheetObj.CellValue2(sheetObj.LastRow, "sgrp_cost_cd") = getIbComboObjValue(formObj.f_sgrp_cost_cd);
				sheetObj.CellValue2(sheetObj.LastRow, "stnd_cost_cd") = getIbComboObjValue(formObj.f_stnd_cost_cd);
				
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
		//	if (!isNumber(iPage)) {
		//
		//		return false;
		//	}
		}

		return true;
	}
	/**AOC 모듈에서 사용하는 Tariff 계정 설정 flag 제한
	 * Full 운반비, 하역비에 대해서만 설정하며 
	 * inlnd_tml_expn_calc_flg는 Full 하역비에 한하여 선택 가능 	*/
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		for(i=2; i<=sheetObj.LastRow; i++){			
            sheetObj.CellEditable(i,"inlnd_expn_use_flg")= false;
            sheetObj.CellEditable(i,"inlnd_tml_expn_calc_flg")  = false;
            sheetObj.CellEditable(i,"ocn_fdr_expn_use_flg")       = false;
            
            if(sheetObj.CellValue(i, "sgrp_cost_cd") == 'CVFS'||sheetObj.CellValue(i, "sgrp_cost_cd") == 'CVTR'){
            	sheetObj.CellEditable(i,"inlnd_expn_use_flg")= true;              
                sheetObj.CellEditable(i,"ocn_fdr_expn_use_flg")       = true;
			}
            if(sheetObj.CellValue(i, "sgrp_cost_cd") == 'CVFS'){ //full 하역비의 경우에만 calculation 설정 flag 활성화
            	sheetObj.CellEditable(i,"inlnd_tml_expn_calc_flg")  = true;
            }
        }
  	}
	
	function getIbComboObjValue(obj){
	  	if (ComGetObjValue(obj) == "All" ){
	  		return "";
	  	}
	  	return ComGetObjValue(obj);
	  } 	