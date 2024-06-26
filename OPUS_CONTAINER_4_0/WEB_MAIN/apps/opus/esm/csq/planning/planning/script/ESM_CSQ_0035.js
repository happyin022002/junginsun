/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0035.js
*@FileTitle  : Office QTA Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/05
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_CSQ_0035 : ESM_CSQ_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			case "btn_DownExcel":
				if(sheetObject.RowCount() < 1) {
					 ComShowCodeMessage("COM132501");
				} else{
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", ""));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * IBSheet Object 를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * IBSheet Object 를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	
	function loadPage(){
		var formObject=document.form;
		loadingMode=true;
		for (k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		f_bse_tp_cd_OnChange();
		document.form.f_bse_tp_cd[0].disabled=true;
		document.form.f_bse_tp_cd[1].disabled=true;
		if(formObject.f_ob_div_cd.value == "O"){
			formObject.f_ob.value="O/B";
		}else if(formObject.f_ob_div_cd.value == "N"){
			formObject.f_ob.value="N.OB";
		}else{
			formObject.f_ob.value=formObject.f_ob_div_cd.value;
		}
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		loadingMode=false;
	}

	function f_bse_tp_cd_OnChange() {
		var formObj=document.form;
		var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var div_qtr=document.getElementById("div_qtr");
		var div_period=document.getElementById("div_period");
		if (bse_tp_cd == "Y") {
			div_qtr.style.display="none";
			div_period.style.display="none";
			formObj.f_bse_qtr_cd.style.display="none";
		} else {
			div_qtr.style.display="inline";
			div_period.style.display="inline";
			formObj.f_bse_qtr_cd.style.display="inline";
		}
		if (bse_tp_cd == "Y") {
			sheetObjects[0].SetColHidden("bse_qtr_cd",1);
		} else {
			sheetObjects[0].SetColHidden("bse_qtr_cd",0);
		}
	}
	
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		        var HeadTitle1="SEQ|Year|Quarter|N.OB/\nOB|Office\nView|Trade|Trade\nBound|RHQ|Office|Office Load QTA Summary|Office Load QTA Summary|Office Load QTA Summary|Office G.REV QTA Summary|Office G.REV QTA Summary|Office G.REV QTA Summary|Office Past PFMC Per Week|Office Past PFMC Per Week|Office Past PFMC Per Week|Office Past PFMC Per Week|Office Simulation vs Office Past PFMC|Office Simulation vs Office Past PFMC|Office Simulation vs Office Past PFMC|Office Simulation vs Office Past PFMC";
		        var HeadTitle2="SEQ|Year|Quarter|N.OB/\nOB|Office\nView|Trade|Trade\nBound|RHQ|Office|TTL Load|Weekly Load|Office %|TTL G.REV|Weekly G.REV|Office %|Load|Load %|G.REV|G.REV %|Load|Load %|G.REV|G.REV %";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"},
		                        { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ob_div_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ofc_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"ofc_wk_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ofc_qty_rto",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ofc_rev",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ofc_wk_rev",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ofc_rev_rto",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pst_wk_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pst_qty_rto",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pst_wk_rev",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pst_rev_rto",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"diff_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"diff_qty_rto",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"diff_rev",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"diff_rev_rto",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetRangeBackColor(1, 9, 1, 30, "#555555");
		        SetSheetHeight(300);
	            }
			break;
		}
	}
	/**
	 * Sheet 관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:          //조회
				formObj.f_cmd.value=INIT;
				if(formObj.f_ob_div_cd.value == "N"){
					formObj.f_qta_step_cd.value="04";
				}else if(formObj.f_ob_div_cd.value == "O"){
					formObj.f_qta_step_cd.value="05";
				}else{
					formObj.f_qta_step_cd.value="All";
				}	
				var sParam=FormQueryString(formObj);
				sheetObj.DoSearch("ESM_CSQ_0026GS2.do",sParam );
				sheetObj.SetSumText(0, "seq","");
				sheetObj.SetSumText(0, "ob_div_cd","TOTAL");
				break;
			case IBDOWNEXCEL:		// 엑셀 다운로드
				sheetObj.MergeSheet=msNone;
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				sheetObj.MergeSheet=msHeaderOnly;
				break;
	    }
	}
	/* 개발자 작업  끝 */