/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0036_3.js
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation

* 2011.11.07 김민아 [CHM-201114250-01] TDR내 SKD& Condition Tap 삭제 - parentTabIdx 수정
* 2012.02.20 김민아 [CHM-201215989-01] TOR Creation내 Working Time 칼럼 활성화 요청건
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
     * @class vop_opf_0036 : vop_opf_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0036_3() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    }

var sheetObjects = new Array();
var sheetCnt = 0;
var beforeLoadVolTab = 0;
var parentTabIdx = 2;
var enableButton = new Array(
								"btn_t4RowAdd",
								"btn_t4RowInsert",
								"btn_t4RowCopy",
								"btn_t4Delete",
								"btn_t4ImportPart"
							);

var mBtnDis = "N";

	document.onclick = processButtonClick;

   	/* 개발자 작업	*/

    function processButtonClick(){

		/*******************************************************/
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_t4RowAdd":
						var sheetObj = sheetObjCur();
						var Row = sheetObj.DataInsert(-1);
						
						if(beforeLoadVolTab == 0 || beforeLoadVolTab == 1 || beforeLoadVolTab == 2)
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_opr_cd", true);
						else
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_pod", true);

						break;

				case "btn_t4RowInsert":
						var sheetObj = sheetObjCur();
						var Row = sheetObj.DataInsert();
						
						if(beforeLoadVolTab == 0 || beforeLoadVolTab == 1 || beforeLoadVolTab == 2)
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_opr_cd", true);
						else
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_pod", true);

						break;

				case "btn_t4RowCopy":
						var sheetObj = sheetObjCur();
						var Row = sheetObj.DataCopy();
						
						if(beforeLoadVolTab == 0 || beforeLoadVolTab == 1 || beforeLoadVolTab == 2)
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_opr_cd", true);
						else
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_pod", true);

						break;
						
				case "btn_t4Delete":
						var sheetObj = sheetObjCur();
						var prefixDel = "t4sheet" + (beforeLoadVolTab + 1) + "_del_chk";

						ComRowHideDelete(sheetObj, prefixDel);

						break;
						
				//Disch Vol Tab Change
				case "chk_LoadVol":
					disLoadTabChange();
					//::jsk::2012-02-14
					fncLoadVolExternalBtn();
					break;
				case "btn_t4ImportPart":
					parent.doActionIBSheetImport2(beforeLoadVolTab, parent.document.form);
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

	function sheetObjCur(){
		var sheetObj = null;
		switch(beforeLoadVolTab){
			case 0:
				sheetObj = document.t4sheet1;
				break;
			case 1:
				sheetObj = document.t4sheet2;
				break;
			case 2:
				sheetObj = document.t4sheet3;
				break;
			case 3:
				sheetObj = document.t4sheet4;
				break;
		}

		return sheetObj;
	}

	function disLoadTabChange(changeSheet){
		if(changeSheet == null || changeSheet == undefined)
			changeSheet = false;

		var formObject = document.form;
		var idx = 0;
		var oldBeforeLoadVolTab = beforeLoadVolTab;
		
		for(; idx < formObject.chk_LoadVol.length; idx++){
			if(formObject.chk_LoadVol[idx].checked)
				break;
		}

		//변경된데이터 적용후 Tab Change시에.
		if(idx == 0 && changeSheet){
			beforeLoadVolTab = idx;
			setTimeout("disLoadTabChangeExec(" + oldBeforeLoadVolTab + ", "+ idx + ")", 100 );
		}else if(idx == beforeLoadVolTab){
			return;
		}else{
			var objs = document.all.item("t4sheetDiv");
			objs[idx].style.display = "inline";
			objs[beforeLoadVolTab].style.display = "none";

			objs[beforeLoadVolTab].style.zIndex = objs[idx].style.zIndex -1 ;

			beforeLoadVolTab = idx;
		}
/*
		document.all.item("btn_t4ImportPart").innerHTML = (	 idx == 0 ? "Ocean" : 
															(idx == 1 ? "Inter Port" : 
															(idx == 2 ? "Special Cargo" : "Break-Bulk" )));
*/		
	}

	/**
    * Loading Vol. 탭에서 Break Bulk 시트(radio) 선택시에만 Save버튼 활성화 시킨다.
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
	function fncLoadVolExternalBtn(){
    	//::JSK:: document.form.sys_create.value.toUpperCase().substring(0,2)
    	parent.fncLoadVolBBSheetCellControl();	//btn_save enabled 포함.
	}
	
	function disLoadTabChangeExec(beforeLoadVolTab, idx){
		
		var objs = document.all.item("t4sheetDiv");

		objs[beforeLoadVolTab].style.display = "none";
		objs[idx].style.display = "inline";

		objs[beforeLoadVolTab].style.zIndex = objs[idx].style.zIndex -1 ;
	}


	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(btnDis) {
		mBtnDis = btnDis;

		//Disable Button;
		// IBMultiCombo초기화
        for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		
		podComboInit();

		if(parent.bRetrive){
			parent.doActionIBSheetMulti(parentTabIdx, parent.document.form);
			parent.setTabEditSheet();
		}

		initControl();
		parent.frameButtonSheet(parent.document.t4frame, parent.readonlStatus());
		parent.topSync();
		
    }

	function initControl(){
		axon_event.addListener('blur', 't4sheet1_onblur', 't4sheet1', '');	
		axon_event.addListener('blur', 't4sheet2_onblur', 't4sheet2', '');	
		axon_event.addListener('blur', 't4sheet3_onblur', 't4sheet3', '');	
		axon_event.addListener('blur', 't4sheet4_onblur', 't4sheet4', '');	
	}
	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
    }
	
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetObj.id){
			case "t4sheet1":
				parent.sheetInitTotal(sheetObj);
				break;
			case "t4sheet2":
				parent.sheetInitTotal(sheetObj);
				break;
			case "t4sheet3":
				parent.sheetInitSC(sheetObj);
				break;
			case "t4sheet4":
				parent.sheetInitBreakBulk(sheetObj);
				break;
		}

	}

	function podComboInit(){
		document.t4sheet1.InitDataCombo(0, "t4sheet1_pod_cd", parent.mLoadPodName,  parent.mLoadPodCode);
		document.t4sheet2.InitDataCombo(0, "t4sheet2_pod_cd", parent.mLoadPodName,  parent.mLoadPodCode);
		document.t4sheet3.InitDataCombo(0, "t4sheet3_pod", parent.mLoadPodName,  parent.mLoadPodCode);
		document.t4sheet4.InitDataCombo(0, "t4sheet4_pod", parent.mLoadPodName,  parent.mLoadPodCode);
	}

	function t4sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t4sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t4sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t4sheet1_opr_cd" && sheetObj.CellValue(OldRow, "t4sheet1_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}

	function t4sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t4sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t4sheet1;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t4sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t4sheet1_";
		
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod_cd"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t4sheet1_opr_cd|t4sheet1_pod_cd");	//imdg_segr_grp_no Value Duplication Check
		}

		if(sheetObj.ColSaveName(Col) == prefix + "pod_cd"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
	}

	function t4sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet2_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t4sheet2_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t4sheet2_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t4sheet2_opr_cd" && sheetObj.CellValue(OldRow, "t4sheet2_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}

	function t4sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t4sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t4sheet2;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t4sheet2_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t4sheet2_";
		
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod_cd"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t4sheet2_opr_cd|t4sheet2_pod_cd");	//imdg_segr_grp_no Value Duplication Check
		}

		if(sheetObj.ColSaveName(Col) == prefix + "pod_cd"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
	}

	function t4sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet3_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t4sheet3_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t4sheet3_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t4sheet3_opr_cd" && sheetObj.CellValue(OldRow, "t4sheet3_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}

	function t4sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t4sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t4sheet3;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t4sheet3_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t4sheet3_";
		
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t4sheet3_opr_cd|t4sheet3_pod");	//imdg_segr_grp_no Value Duplication Check
		}

		if(sheetObj.ColSaveName(Col) == prefix + "pod"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
	}

	function t4sheet4_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet4_opr_cd"){
			popupSheet = document.t4sheet4;
			popupPrefix = "t4sheet4_";
			popupColNm = "opr_cd";

			ComOpenPopup("COM_ENS_0N1.do", 430, 400, "setCallBackOprCd", "0,0,1,1,1,1", false, false, Row, Col, 0);
		}
	}

	function t4sheet4_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t4sheet4_opr_cd" && sheetObj.CellValue(OldRow, "t4sheet4_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}

	function t4sheet4_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t4sheet4_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t4sheet4;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t4sheet4_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t4sheet4_";
		
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod" || sheetObj.ColSaveName(Col) == prefix + "cntr_no"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t4sheet4_opr_cd|t4sheet4_pod|t4sheet4_cntr_no");	//imdg_segr_grp_no Value Duplication Check
		}

		if(sheetObj.ColSaveName(Col) == prefix + "cntr_no"){
			parent.checkCntrNo(sheetObj, Row, Col)
		}

		if( (	Col == sheetObj.SaveNameCol(prefix + "commence") || 
				Col == sheetObj.SaveNameCol(prefix + "complete")
			) && sheetObj.CellValue(Row, Col) != ""){
			var dateTmp = sheetObj.CellValue(Row, Col);
			if(!ComIsDate(dateTmp.substring(0, 8), "ymd") || !ComIsTime(dateTmp.substring(8), "hm")){
				//--::JSK::--
				ComShowCodeMessage('COM12187', 'yyyy-mm-dd hh:mm');
				sheetObj.SelectCell(Row, Col, true);
				return;
			}

			if(sheetObj.CellValue(Row, prefix + "commence") != "" && sheetObj.CellValue(Row, prefix + "complete") != "" ){
				var tmpMM = sheetObj.EvalDateDiff("N", sheetObj.CellText(Row, prefix + "commence") + ":00", 
													   sheetObj.CellText(Row, prefix + "complete") + ":00");
				
				if(tmpMM < 0){		//어떻게 해야 할지를
					ComShowCodeMessage('OPF50013', "Completed Date", "Commeced Date");
					sheetObj.CellValue(Row, prefix + "commence") = "";
					sheetObj.CellValue(Row, prefix + "complete") = "";
					sheetObj.SelectCell(Row, prefix + "commence", true);
					return;
				}
			}
		}

		if(sheetObj.ColSaveName(Col) == prefix + "pod"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
	}

	function t4sheet1_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}

	function t4sheet2_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}

	function t4sheet3_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}

	function t4sheet4_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}