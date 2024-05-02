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
var beforeDistchVolTab = 0;
var parentTabIdx = 1;
var enableButton = new Array(
								"btn_t3RowAdd",
								"btn_t3RowInsert",
								"btn_t3RowCopy",
								"btn_t3Delete",
								"btn_t3Import",
								"btn_t3ImportPart"
							);

var mBtnDis = "N";
var checkyDcDFlg = false;   //Pod 체크 
	document.onclick = processButtonClick;

   	/* 개발자 작업	*/

    function processButtonClick(){

		/*******************************************************/
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_t3RowAdd":
						var sheetObj = sheetObjCur();
						var Row = sheetObj.DataInsert(-1);

						if(beforeDistchVolTab == 0 || beforeDistchVolTab == 1)
							sheetObj.SelectCell(Row, "t3sheet" + (beforeDistchVolTab + 1) + "_opr_cd", true);
						else
							sheetObj.SelectCell(Row, "t3sheet" + (beforeDistchVolTab + 1) + "_dml", true);
						
						if(beforeDistchVolTab == 1 || beforeDistchVolTab == 2){
							sheetObj.CellValue(Row, "t3sheet" + (beforeDistchVolTab + 1) + "_pod") = parent.document.form.port_cd.value;
						}

						break;

				case "btn_t3RowInsert":
						var sheetObj = sheetObjCur();
						var Row = sheetObj.DataInsert();

						if(beforeDistchVolTab == 0 || beforeDistchVolTab == 1)
							sheetObj.SelectCell(Row, "t3sheet" + (beforeDistchVolTab + 1) + "_opr_cd", true);
						else
							sheetObj.SelectCell(Row, "t3sheet" + (beforeDistchVolTab + 1) + "_pod", true);
						
						if(beforeDistchVolTab == 1 || beforeDistchVolTab == 2){
							sheetObj.CellValue(Row, "t3sheet" + (beforeDistchVolTab + 1) + "_pod") = parent.document.form.port_cd.value;
						}

						break;

				case "btn_t3RowCopy":
						var sheetObj = sheetObjCur();
						var Row = sheetObj.DataCopy();

						if(beforeDistchVolTab == 0 || beforeDistchVolTab == 1)
							sheetObj.SelectCell(Row, "t3sheet" + (beforeDistchVolTab + 1) + "_opr_cd", true);
						else
							sheetObj.SelectCell(Row, "t3sheet" + (beforeDistchVolTab + 1) + "_pod", true);

						break;
						
				case "btn_t3Delete":
						var sheetObj = sheetObjCur();
						var prefixDel = "t3sheet" + (beforeDistchVolTab + 1) + "_del_chk";

						ComRowHideDelete(sheetObj, prefixDel);
						break;
				//Disch Vol Tab Change
				case "chk_DischVol":
					disChargTabChange();
					break;
					
				case "btn_t3ImportPart":
					parent.doActionIBSheetImport1(beforeDistchVolTab, parent.document.form);
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
		switch(beforeDistchVolTab){
			case 0:
				sheetObj = document.t3sheet1;
				break;
			case 1:
				sheetObj = document.t3sheet2;
				break;
			case 2:
				sheetObj = document.t3sheet3;
				break;
		}

		return sheetObj;
	}

	function disChargTabChange(changeSheet){
		if(changeSheet == null || changeSheet == undefined)
			changeSheet = false;

		var formObject = document.form;
		var idx = 0;
		var oldBeforeDistchVolTab = beforeDistchVolTab;

		for(; idx < formObject.chk_DischVol.length; idx++){
			if(formObject.chk_DischVol[idx].checked)
				break;
		}

		//변경된데이터 적용후 Tab Change시에.
		if(idx == 0 && changeSheet){
			beforeDistchVolTab = idx;
			setTimeout("disChargTabChangeExec(" + oldBeforeDistchVolTab + ", "+ idx + ")", 100 );
		}else if(idx == beforeDistchVolTab){
			return;
		}else{
			var objs = document.all.item("t3sheetDiv");
			objs[idx].style.display = "inline";
			objs[beforeDistchVolTab].style.display = "none";

			objs[beforeDistchVolTab].style.zIndex = objs[idx].style.zIndex -1 ;

			beforeDistchVolTab = idx;
		}
	}

	
	function disChargTabChangeExec(beforeDistchVolTab,idx ){
		
		var objs = document.all.item("t3sheetDiv");

		objs[beforeDistchVolTab].style.display = "none";
		objs[idx].style.display = "inline";

		objs[beforeDistchVolTab].style.zIndex = objs[idx].style.zIndex -1 ;
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

		if(parent.bRetrive){
			parent.doActionIBSheetMulti(parentTabIdx, parent.document.form);
			parent.setTabEditSheet();
		}
		
		initControl();
		parent.frameButtonSheet(parent.document.t3frame, parent.readonlStatus());
	 	parent.topSync();
	 	
    }
	
	function initControl(){
		axon_event.addListener('blur', 't3sheet1_onblur', 't3sheet1', '');	
		axon_event.addListener('blur', 't3sheet2_onblur', 't3sheet2', '');	
		axon_event.addListener('blur', 't3sheet3_onblur', 't3sheet3', '');	
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
			case "t3sheet1":
				parent.sheetInitTotal(sheetObj);
				break;
			case "t3sheet2":
				parent.sheetInitSC(sheetObj);
				break;
			case "t3sheet3":
				parent.sheetInitBreakBulk(sheetObj);
				break;
		}
	}

	function t3sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t3sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t3sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

    function t3sheet1_OnChange(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "t3sheet1_opr_cd"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t3sheet1_opr_cd");	//imdg_segr_grp_no Value Duplication Check
		}
	}

	function t3sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t3sheet1_opr_cd" && sheetObj.CellValue(OldRow, "t3sheet1_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}

	function t3sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t3sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = sheetObj;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t3sheet2_OnClick(sheetObj, Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "t3sheet2_pod"){
			if(!checkyDcDFlg){
				sheetObj.SelectCell(Row, "t3sheet2_pod", true);
			}
		}
	}

	function t3sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t3sheet2_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t3sheet2_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

    function t3sheet2_OnChange(sheetObj,Row, Col, Value) {
		var prefix = "t3sheet2_";
		
		if(sheetObj.ColSaveName(Col) == "t3sheet2_opr_cd" || sheetObj.ColSaveName(Col) == "t3sheet2_pod"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t3sheet2_opr_cd");	//imdg_segr_grp_no Value Duplication Check
		}
	}

	function t3sheet2_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t3sheet2_opr_cd" && sheetObj.CellValue(OldRow, "t3sheet2_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}

	function t3sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t3sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = sheetObj;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t3sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t3sheet3_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t3sheet3_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t3sheet3_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t3sheet3_opr_cd" && sheetObj.CellValue(OldRow, "t3sheet3_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}

	function t3sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t3sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t3sheet3;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t3sheet3_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t3sheet3_";
		
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod" || sheetObj.ColSaveName(Col) == prefix + "cntr_no"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t3sheet3_opr_cd|t3sheet3_pod|t3sheet3_cntr_no");	//imdg_segr_grp_no Value Duplication Check
		}

		if( (	Col == sheetObj.SaveNameCol(prefix + "commence") || 
				Col == sheetObj.SaveNameCol(prefix + "complete")
			) && sheetObj.CellValue(Row, Col) != ""){
			var dateTmp = sheetObj.CellValue(Row, Col);
			if(!ComIsDate(dateTmp.substring(0, 8), "ymd") || !ComIsTime(dateTmp.substring(8), "hm")){
				alert(ComGetMsg('COM12187', 'yyyy-mm-dd hh:mm'));
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
	}

	function t3sheet1_onblur(){
 
		if(mBtnDis == "Y"){
			if(parent.mCheckValue){
				parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
			}
		}
	}

	function t3sheet2_onblur(){
		if(mBtnDis == "Y"){
			if(parent.mCheckValue){
				parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
			}
		}
	}

	function t3sheet3_onblur(){
		if(mBtnDis == "Y"){
			if(parent.mCheckValue){
				parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
			}
		}
	}
