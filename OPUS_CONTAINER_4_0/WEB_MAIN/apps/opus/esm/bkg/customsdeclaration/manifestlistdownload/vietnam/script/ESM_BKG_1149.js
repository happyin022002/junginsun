/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1149.js
*@FileTitle : Vietnam Customs Manifest
*@author : CLT
*@version : 1.0
*@since : 2014/08/11
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */
/**
 * @extends
 * @class ESM_BKG-1149 : ESM_BKG-1149 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업 */
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var intervalId="";
var comboObjects=new Array();
var comboCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			 if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_down_excel":
						doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
					break;
				case "btn_Transmit":
					doActionIBSheet(sheetObjects[0], document.form, MULTI);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	 sheetObjects[sheetCnt++]=sheet_obj;
	}
	 /**
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	 *
	 * @param {IBMultiCombo}
	 * combo_obj IBMultiCombo Object
	 */
	 function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	 }
	 /**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	 function setTabObject(tab_obj){
		 tabObjects[tabCnt++]=tab_obj;
	 }
	 /**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	 function initTab(tabObj , tabNo) {
		 switch(tabNo) {
			 case 1:
				 with (tabObj) {
					 var cnt=0 ;
					 InsertItem( "B/L Info" , "");
					 InsertItem( "CNTR Info" , "");
				 }
			 break;
		 }
	 }
	 /**
	 * 콤보 초기설정값
	 *
	 * @param {IBMultiCombo}
	 * comboObj comboObj
	 */
	 function initCombo(comboObj) {
		switch(comboObj.options.id) {
			case "s_status":
				doActionIBSheet(sheetObjects[0],document.form,"setCombo");
				comboObj.SetSelectCode("9");
				comboObj.SetDropHeight(350);
				comboObj.SetColBackColor(0,"#eeeeee");
				break;
			default:
				comboObj.SetMultiSelect(0);
	 //no support[check again]CLT 			comboObj.UseCode=true;
	 //no support[check again]CLT 			comboObj.LineColor="#ffffff";
				comboObj.SetColAlign(0, "left");
				comboObj.SetColAlign(1, "left");
				comboObj.SetMultiSeparator("|");
				break;
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
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();
	}
	 /**
	 * 조회조건 입력할 때 처리
	 */
	 function obj_KeyUp() {
		 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		 var formObject=document.form;
		 var srcName=ComGetEvent("name");
		 var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		 var srcValue=window.event.srcElement.getAttribute("value");
		 if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		 }
	 }
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 *
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {int} heetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		//** Date 구분자 **/
		DATE_SEPARATOR="-";
		var formObject=document.form;
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListenerForm("change", "obj_OnChange", document.form);
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1": //sheet1 init
				with(sheetObj){
				var cnt=0;

			 var HeadTitle1="|Sel.|Seq.|VVD|BL No|CNEE|CNTR No|TP|FA|RD|LS|B/POR|V/POL|V/POD|YD|B/DEL|YD|Weight|Weight|Measure|Measure|Package|Package|Freight|RF|DG|S.Date" +
							// Hidden
							"|bkg_no|vsl_nm|vsl_callsign|etd|eta|trsm_sts|tpsz_20_chk|tpsz_40_chk|tpsz_tot_chk|pol_gubun|Weight_sum";
			 var headCount=ComCountHeadTitle(HeadTitle1);

			 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			 var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			 InitHeaders(headers, info);

			 var cols = [{Type:"Status",      Hidden:1,    Width:30,     Align:"Center",    ColMerge:0,    SaveName:"ibflag" },
						 {Type:"CheckBox",    Hidden:0,    Width:40,     Align:"Center",    ColMerge:0,    SaveName:"sel" },
						{Type:"Seq",          Hidden:0,    Width:30,     Align:"Center",    ColMerge:0,    SaveName:"seq" },
						{Type:"Text",         Hidden:0,    Width:80,     Align:"Center",    ColMerge:0,    SaveName:"vvd",             Edit:0 },
						{Type:"Text",         Hidden:0,    Width:90,     Align:"Center",    ColMerge:0,    SaveName:"bl_no",          Edit:0 },
						{Type:"Text",         Hidden:0,    Width:120,    Align:"Left",      ColMerge:0,    SaveName:"cust_nm",         Edit:0 },
						{Type:"Text",         Hidden:0,    Width:80,     Align:"Center",    ColMerge:0,    SaveName:"cntr_no",         Edit:0 },
						{Type:"Text",         Hidden:0,    Width:20,     Align:"Center",    ColMerge:0,    SaveName:"cntr_tpsz_cd",    Edit:0 },
						{Type:"Text",         Hidden:0,    Width:30,     Align:"Center",    ColMerge:0,    SaveName:"sf",              Edit:0 },
						{Type:"Text",         Hidden:0,    Width:20,     Align:"Center",    ColMerge:0,    SaveName:"rd",              Edit:0 },
						{Type:"Text",         Hidden:0,    Width:20,     Align:"Center",    ColMerge:0,    SaveName:"ls",              Edit:0 },
						{Type:"Text",         Hidden:0,    Width:70,     Align:"Center",    ColMerge:1,    SaveName:"b_por",           Edit:0 },
						{Type:"Text",         Hidden:0,    Width:70,     Align:"Center",    ColMerge:1,    SaveName:"v_pol",           Edit:0 },
						{Type:"Text",         Hidden:0,    Width:70,     Align:"Center",    ColMerge:1,    SaveName:"v_pod",           Edit:0 },
						{Type:"Text",         Hidden:0,    Width:30,     Align:"Center",    ColMerge:1,    SaveName:"v_pod_cd",        Edit:0 },
						{Type:"Text",         Hidden:0,    Width:70,     Align:"Center",    ColMerge:1,    SaveName:"b_del",           Edit:0 },
						{Type:"Text",         Hidden:0,    Width:30,     Align:"Center",    ColMerge:1,    SaveName:"b_del_cd",        Edit:0 },
						{Type:"Float",        Hidden:0,    Width:60,     Align:"Right",     ColMerge:0,    SaveName:"act_wgt",         Edit:0, Format:"Float"},
						{Type:"Text",         Hidden:0,    Width:30,     Align:"Center",    ColMerge:0,    SaveName:"wgt_ut_cd",       Edit:0 },
						{Type:"Float",        Hidden:0,    Width:60,     Align:"Right",     ColMerge:0,    SaveName:"meas_qty",        Edit:0, Format:"Float" },
						{Type:"Text",         Hidden:0,    Width:30,     Align:"Center",    ColMerge:0,    SaveName:"meas_ut_cd",      Edit:0 },
						{Type:"Float",        Hidden:0,    Width:60,     Align:"Right",     ColMerge:0,    SaveName:"pck_qty",         Edit:0, Format:"Float" },
						{Type:"Text",         Hidden:0,    Width:30,     Align:"Center",    ColMerge:0,    SaveName:"pck_tp_cd",       Edit:0 },
						{Type:"Text",         Hidden:0,    Width:50,     Align:"Center",    ColMerge:0,    SaveName:"freight",         Edit:0 },
						{Type:"Text",         Hidden:0,    Width:30,     Align:"Center",    ColMerge:0,    SaveName:"rf",              Edit:0 },
						{Type:"Text",         Hidden:0,    Width:30,     Align:"Center",    ColMerge:0,    SaveName:"dg",              Edit:0 },
						{Type:"Text",         Hidden:0,    Width:50,     Align:"Center",    ColMerge:0,    SaveName:"s_date",          Edit:0 },

						{Type:"Text",         Hidden:1,    Width:90,     Align:"Center",    ColMerge:0,    SaveName:"bkg_no" },
						{Type:"Text",         Hidden:1,    Width:50,     Align:"Center",    ColMerge:0,    SaveName:"vsl_nm" },
						{Type:"Text",         Hidden:1,    Width:50,     Align:"Center",    ColMerge:0,    SaveName:"vsl_callsign" },
						{Type:"Text",         Hidden:1,    Width:50,     Align:"Center",    ColMerge:0,    SaveName:"etd" },
						{Type:"Text",         Hidden:1,    Width:50,     Align:"Center",    ColMerge:0,    SaveName:"eta" },
						{Type:"Text",         Hidden:1,    Width:70,     Align:"Center",    ColMerge:0,    SaveName:"trsm_sts" },
						{Type:"Text",         Hidden:1,    Width:70,     Align:"Center",    ColMerge:0,    SaveName:"tpsz_20_chk" },
						{Type:"Text",         Hidden:1,    Width:70,     Align:"Center",    ColMerge:0,    SaveName:"tpsz_40_chk" },
						{Type:"Text",         Hidden:1,    Width:70,     Align:"Center",    ColMerge:0,    SaveName:"tpsz_tot_chk" },
						{Type:"Text",         Hidden:1,    Width:70,     Align:"Center",    ColMerge:0,    SaveName:"pol_gubun" },
						{Type:"Text",         Hidden:1,    Width:60,     Align:"Right",     ColMerge:0,    SaveName:"act_wgt_sum" } ];

			 InitColumns(cols);

			 SetEditable(1);
			 SetWaitImageVisible(0);
			 SetSheetHeight(400);
					}


			 break;
		}
	}
 // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case "setCombo": // Status id 콤보값 조회
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1149GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, s_status, "val", "name");
				break;
			case IBSEARCH: //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				//ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1149GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (document.form.pol_gubun1.checked) {
					document.form.frm_pol_cd.value=document.form.frm_port_cd.value;
					document.form.frm_pod_cd.value="";
				} else {
					document.form.frm_pol_cd.value="";
					document.form.frm_pod_cd.value=document.form.frm_port_cd.value;
				}
				sheetObj.LoadSearchData(arrXml[0],{Sync:1} );

				//ComOpenWait(false);
				break;

			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
			case MULTI: //Transmit
				if( ! validateForm(sheetObj,formObj,sAction)) return;
				var idx=0;
				for( idx=0+parseInt(sheetObj.HeaderRows()); idx < sheetObj.RowCount()+parseInt(sheetObj.HeaderRows()); idx++ ){
					sheetObj.SetCellValue(idx,"trsm_sts",comboObjects[0].GetSelectCode(),0);
					sheetObj.SetRowStatus(idx,"U");
				}
//				for( idx = 0+parseInt(sheetObjects[1].HeaderRows); idx < sheetObjects[1].RowCount+parseInt(sheetObjects[1].HeaderRows); idx++ ){
//					sheetObjects[1].RowStatus(idx)= "U";
//				}
				if (sheetObj.CheckedRows("sel") < 1) {
					 ComShowCodeMessage("COM12113", "data"); // Please select {?msg1}
					 return;
				}
				var updVvd=formObj.to_vsl_cd.value + formObj.to_skd_voy_no.value + formObj.to_skd_dir_cd.value;
				if (updVvd != "") {
					if (!ComShowConfirm("Manifest will be processed with updated VVD [" + updVvd + "].\n\nDo you want to proceed ?")) return;
				} else {
					if (!ComShowConfirm("Do you want to proceed ?")) return;
				}
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				var sParam="";
				var sParamSheet1=sheetObjects[0].GetSaveString(false, true, "sel");
				if (sParamSheet1 != "") {
					sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
				}
				sParam=sParam + "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("ESM_BKG_1149GS.do", sParam);
				var key=ComGetEtcData(sXml, "KEY");
				intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				break;
		}
	}
	/**
	 * BackEndJob 실행결과조회.
	 */
	function doActionValidationResult(sheetObj, sKey) {
		var sXml=sheetObj.GetSearchData("ESM_BKG_1149GS.do?f_cmd=" + SEARCH01 + "&key=" + sKey);
		var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
		// 에러가 발생했을 경우 대기사항을 종료한다.
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			// 성공메시지 보여주고
			ComShowCodeMessage('BKG00101');
			return;
		} else if (sJbStsFlg == "FAIL") {
			//에러
			clearInterval(intervalId);
			ComOpenWait(false);
			// 에러메시지 보여주고
			ComShowMessage(ComResultMessage(sXml));
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				break;
			case MULTI:
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;
			case IBDOWNEXCEL:
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;
		}
		return true;
	}
	/**
	 * 조회완료후 이벤트
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg != "" || sheetObj.RowCount()< 1) return;
		var tpsz_20_chk_cnt=0;
		var tpsz_40_chk_cnt=0;
		var tpsz_tot_chk_cnt=0;
		var startRow1=sheetObj.HeaderRows();
		var endRow1=sheetObj.HeaderRows()+ sheetObj.RowCount();
		var sVvd=document.form.s_vvd.value;
		document.form.to_vsl_cd.value=sVvd.substring(0,4);
		document.form.to_skd_voy_no.value=sVvd.substring(4,8);
		document.form.to_skd_dir_cd.value=sVvd.substring(8,9);;
		document.form.vsl_nm.value=sheetObj.GetCellValue(startRow1,"vsl_nm");
		document.form.vsl_callsign.value=sheetObj.GetCellValue(startRow1,"vsl_callsign");
		document.form.etd.value=sheetObj.GetCellValue(startRow1,"etd").substring(0,4)+"-"+sheetObj.GetCellValue(startRow1,"etd").substring(4,6)+"-"+sheetObj.GetCellValue(startRow1,"etd").substring(6,8);
		document.form.eta.value=sheetObj.GetCellValue(startRow1,"eta").substring(0,4)+"-"+sheetObj.GetCellValue(startRow1,"eta").substring(4,6)+"-"+sheetObj.GetCellValue(startRow1,"eta").substring(6,8);
		for (var i=startRow1; i < endRow1; i++) {
			if (!ComIsEmpty(sheetObj.GetCellValue(i,"tpsz_20_chk"))) {tpsz_20_chk_cnt++;}
			if (!ComIsEmpty(sheetObj.GetCellValue(i,"tpsz_40_chk"))) {tpsz_40_chk_cnt++;}
			if (!ComIsEmpty(sheetObj.GetCellValue(i,"tpsz_tot_chk"))) {tpsz_tot_chk_cnt++;}
		}
		document.form.tpsz_20_chk.value=tpsz_20_chk_cnt;
		document.form.tpsz_40_chk.value=tpsz_40_chk_cnt;
		document.form.tpsz_tot_chk.value=tpsz_tot_chk_cnt;
		if (document.form.pol_gubun[0].checked) {
			for (var j=startRow1; j < endRow1; j++) {
				sheetObj.SetCellValue(j,"pol_gubun","1",0);
			}
		} else {
			for (var j=startRow1; j < endRow1; j++) {
				sheetObj.SetCellValue(j,"pol_gubun","2",0);
			}
		}
	}
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab=nItem;
	}
