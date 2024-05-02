/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0069.jsp
*@FileTitle : EQ 회송기여도 RPT 조회 4
*Open Issues :
*Change history : CSR No. R200804296329 내부 경로 변경
*@LastModifyDate : 2006-12-08
*                : 2008-05-06
*@LastModifier : Chilseo_Park
*              : 전윤주
*@LastVersion : 1.0
* 2006-12-08 Chilseo_Park
* 2008-05-06 전윤주
* 1.0 최초 생성
* =========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.09.16 김기식 Alps전환작업
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_COA_0069 : ESM_COA_0069 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0069() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initCombo = initCombo;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
	this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
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
		var sheetObject1 = sheetObjects[1];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					sheetObject1.RemoveAll();
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
					break;

				case "btng_costdetail":
					doActionIBSheet2(sheetObject1, formObject, IBSEARCH);
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
		
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        // 멀티콤보 처리
		//---------------------------------------------
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k], comboObjects[k].id);
		}
		//---------------------------------------------
		loadingMode = false;
		
		
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
	function initSheet(sheetObj,sheetNo,cntrs) {

		var cnt = 0;
		switch(sheetNo) {
			case 1:		//sheet1 init
				with (sheetObj) {

					SheetWidth = mainTable.clientWidth; //전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
					Editable = false;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 3, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(21, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

					var HeadTitle = "POR|DEL|R.Lane|Bound|REV POL|REV POD|Type|Minimum G.RPB\nfor Cost Saving|PFMC Per Box (Unit Cost)|PFMC Per Box (Unit Cost)|PFMC Per Box (Unit Cost)|PFMC Per Box (Unit Cost)|PFMC Per Box (Unit Cost)|PFMC Per Box (Unit Cost)|Previous Month PFMC|Previous Month PFMC|Previous Month PFMC|Previous Month PFMC|Previous Month PFMC|Previous Month PFMC|Previous Month PFMC";
					var HeadTitle1 = "POR|DEL|R.Lane|Bound|REV POL|REV POD|Type|Minimum G.RPB\nfor Cost Saving|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT|Load|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT" ;
					var HeadTitle2 = "POR|DEL|R.Lane|Bound|REV POL|REV POD|Type|Minimum G.RPB\nfor Cost Saving|G.RPB|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT|Load|G.RPB|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, false);

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	60,	daCenter,	true,"por");
					InitDataProperty(0, cnt++ , dtData,	60,	daCenter,	true,"del");
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,"rlane_cd");
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,"dir_cd");
					InitDataProperty(0, cnt++ , dtData,	60,	daCenter,	true,"pol");
					InitDataProperty(0, cnt++ , dtData,	60,	daCenter,	true,"pod");
					InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,"cntr_tpsz_cd");

					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,true,"saving",	false,	"(|cost|/|bkg_qty|)+(|repo_cost_amt|/|bkg_qty|)",dfNullFloatOrg,	2,	true,	true);

					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"rev1",	false,	"|rev|/|bkg_qty|",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"cost1",	false,	"|cost|/|bkg_qty|",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"cm1",		false,	"|cm|/|bkg_qty|",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"repo1",	false,	"|repo_cost_amt|/|bkg_qty|",dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"save1",	false,	"|save|/|bkg_qty|",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"cr_rto1",	false,	"|rev|/|bkg_qty|",		dfNullInteger);

					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"bkg_qty",		false,	"",					dfNullInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"rev",		false,	"",					dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"cost",	false,	"",					dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"cm",		false,	"",					dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"repo_cost_amt",false,	"",					dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,true,"save",	false,	"",					dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,true,"cr_amt",	false,	"",					dfNullInteger);

					RangeBackColor(1, 8, 1, 10) = RgbColor(222, 251, 248);
					RangeBackColor(1, 12, 1, 13) = RgbColor(222, 251, 248);
					RangeBackColor(1, 15, 1, 17) = RgbColor(222, 251, 248);
					RangeBackColor(1, 19, 1, 20) = RgbColor(222, 251, 248);

					RangeBackColor(2, 8, 2, 10) = RgbColor(222, 251, 248);
					RangeBackColor(2, 12, 2, 13) = RgbColor(222, 251, 248);
					RangeBackColor(2, 15, 2, 17) = RgbColor(222, 251, 248);
					RangeBackColor(2, 19, 2, 20) = RgbColor(222, 251, 248);

					HeadRowHeight	= 10;
					CountPosition	= 0 ;
					style.height = GetSheetHeight(11) ;

				}
				break;
			case 2:		//sheet2 init
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
						cntrs = cntrs.substr(2, cntrs.length);
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
					if(aryCnt>0) InitColumnInfo(4+(aryCnt*2), 2, 0, false);
					else InitColumnInfo(4, 2, 0, false);

					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,80,	daCenter,	true,	"item");
					InitDataProperty(0, cnt++ , dtData,	180,	daCenter,	true,	"item_nm");
					InitDataProperty(0, cnt++ , dtData,	90,	daRight,	true,	"estm_total", false, "", dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtData,	90,	daRight,	true,	"repo_total", false, "", dfNullFloatOrg, 2);

					//가변헤더의 데이터 속성 Setting
					if(cntrs != ''){
						for(var k=0; k<aryCnt; k++) {
							InitDataProperty(0,	cnt++,	dtData,	70,	daRight,true,	'estm_' + aryCd[k], false, "", dfNullFloatOrg, 2);
							InitDataProperty(0,	cnt++,	dtData,	70,	daRight,true,	'repo_' + aryCd[k], false, "", dfNullFloatOrg, 2);
						}
					}

					//CellBackColor(1,"a1") = RgbColor(222, 251, 248);	// ENIS
					if(aryCnt>0){
						RangeBackColor(1, 2, 1, 3+(aryCnt*2)) = RgbColor(222, 251, 248);	// ENIS
					} else {
						RangeBackColor(1, 2, 1, 3) = RgbColor(222, 251, 248);	// ENIS
					}

					HeadRowHeight	= 30;
					CountPosition	= 0 ;
					style.height = GetSheetHeight(18) ;
					//AutoSumBottom = 2;

				}
				break;
		}
	}
	
	/**
	* Tab 기본 설정
	* 탭의 항목을 설정한다.
	*/
	function initCombo (comboObj, comboId) {
		with (comboObj) {
			Index = 0;
			DropHeight = 300;
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

	/**
	* sheet1을 더블클릭하여 상세조회한다
	*/
	function sheet1_OnDblClick(sheetObj , row, col){
		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
	}


	/**
	* 조회후 소개 계산
	*/
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		//sheetObj.ShowSubSum( "estm_total", "estm_total", -1, true, false);
		var cnt = parseInt(document.form.f_cntrNo.value);//컨테이너 갯수

		//cost total
		//Full Stevedorage(4) ~ Business Activity Cost(12) 까지의 합
		sheetObj.CellValue2(13, "estm_total") = sheetObj.ComputeSum("|2|", 4, 12);
		sheetObj.CellValue2(13, "repo_total") = sheetObj.ComputeSum("|3|", 4, 12);

		//contribution margin
		sheetObj.CellValue2(14, "estm_total") = sheetObj.CellValue(3, "estm_total") - sheetObj.CellValue(13, "estm_total");
		sheetObj.CellValue2(14, "repo_total") = sheetObj.CellValue(3, "repo_total") - sheetObj.CellValue(13, "repo_total");

		//cost saving
		sheetObj.CellValue2(15, "estm_total") = sheetObj.CellValue(14, "estm_total") - sheetObj.CellValue(14, "repo_total");

		var m = 0;
		for(var k=2; k<=(2*cnt + 3); k++) {
			//cost_total
			sheetObj.CellValue2(13, k) = sheetObj.ComputeSum("|"+ k +"|", 4, 12);
			//contribution margin
			sheetObj.CellValue2(14, k) = sheetObj.CellValue(3, k) - sheetObj.CellValue(13, k);

			if(k%2==1){
				//cost saving
				sheetObj.CellValue2(15, k-1) = sheetObj.CellValue(14, k-1) - sheetObj.CellValue(14, k);
				//credit amount
				//sheetObj.CellValue2(16, k-1) = sheetObj.CellValue(15, k-1) * sheetObj.CellValue(17, k-1);
			}
		}

		//포커스 이동 및 sum관련
		sheetObj.SelectCell(13, 0, false);
		sheetObj.RangeBackColor(13,1,13, 2*cnt+3 ) = sheetObj.UnEditableColor ;
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
		        
				var sXml = document.form.sXml.value; 
				document.form.sXml.value = "";
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_r_cmdt, "code", "code|name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_usa_mode, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_cntr_tpsz_cd_s, "code", "code");
				
				
				ComOpenWait(false);
				break;
				
			case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				formObj.f_pol.value = formObj.f_pol_s.value;
				formObj.f_pod.value = formObj.f_pod_s.value;
				formObj.f_por.value = formObj.f_por_s.value;
				formObj.f_del.value = formObj.f_del_s.value;
				formObj.f_cntr_tpsz_cd.value = getComboObjValue(formObj.f_cntr_tpsz_cd_s);
				
				sheetObj.DoSearch4Post("ESM_COA_0069GS.do", coaFormQueryString(formObj));
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

	// Sheet관련 프로세스 처리
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;

				if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCHLIST02;
					//setting
					var obj = sheetObjects[0];
					var row = obj.SelectRow;
					
					formObj.f_dir_cd.value = obj.CellValue(row, "dir_cd");
					formObj.f_rlane_cd.value = obj.CellValue(row, "rlane_cd");
					formObj.f_pol.value = obj.CellValue(row, "pol");
					formObj.f_pod.value = obj.CellValue(row, "pod");
					formObj.f_por.value = obj.CellValue(row, "por");
					formObj.f_del.value = obj.CellValue(row, "del");
					formObj.f_cntr_tpsz_cd.value = obj.CellValue(row, "cntr_tpsz_cd");
					
					sheetObj.DoSearch4Post("ESM_COA_0069GS2.do", coaFormQueryString(formObj));
					ComOpenWait(false);
				} else {
					ComShowMessage(ComGetMsg('COA10005', 'Sheet1'));
				}
				break;

			case IBDOWNEXCEL:	//엑셀 다운로드
				if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
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
				}
				break;

		}
	}

	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		var rt = false;
		with(formObj){
			if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
				ComShowCodeMessage('COM12180');
			} else {
				rt = true;
			}
		}
		return rt;
	}

	function getComboObjValue(obj){
	 	if (ComGetObjValue(obj) == "All") return "";
	 	return ComGetObjValue(obj);
	 } 
