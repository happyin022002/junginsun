/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0100.js
*@FileTitle  : Sales Activity Item
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	/*시트, 화면, 기능 제어를 위한 플래그 변수 선언*/
	var rowInserted = false;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_Retrieve":
					if(sheetObject1.IsDataModified() || sheetObject2.IsDataModified()){
						if(!validateRetrieve()){
							return false;
						}else{
							if(ComShowCodeConfirm("SAM00010")){
								if(!doActionIBSheet(sheetObject1, document.form, IBSAVE)){
									return false;
								}
							}
						}
					}
					doActionIBSheet(sheetObject1, document.form, SEARCH01);
					break;
				case "btn_Row_Add_L":
					doActionIBSheet(sheetObject1, document.form, IBINSERT);
					break;
				case "btn_Row_Add_R":
					doActionIBSheet(sheetObject2, document.form, IBINSERT);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	}
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		axon_event.addListenerForm('change', 'obj_change', form);
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		switch (sheetNo) {
			case 1:
				with (sheetObj) {
			        var HeadTitle="| DEL|SEQ|Code|Description";
			        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0, NewRowDeleteMode:0 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"DelCheck",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			               {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"sls_act_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
			               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",  ColMerge:0,   SaveName:"sls_act_tp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetColProperty(0 ,"sls_act_tp_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
			        SetSheetHeight(540);
			        resizeSheet();
				}
				break;
			case 2:
				with(sheetObj) {
			        var HeadTitle="| DEL|SEQ|Code|Description|sls_act_tp_cd";
	
			        SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0, NewRowDeleteMode:0 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"DelCheck",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			               {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"sls_act_sub_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
			               {Type:"Text",      Hidden:0,  Width:90,  Align:"Left",  ColMerge:0,   SaveName:"sls_act_sub_tp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
			               {Type:"Text",      Hidden:1,  Width:20,  Align:"Left",  ColMerge:0,   SaveName:"sls_act_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetColProperty(0 ,"sls_act_sub_tp_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
			        SetSheetHeight(540);
			        resizeSheet();
				}
				break;
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, frmObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case SEARCH01: //조회
				if (!validateForm(sheetObj, frmObj, sAction)) {
					return false;
				}
					sheetObjects[0].SetWaitImageVisible(0);
		            ComOpenWait(true);
		            frmObj.f_cmd.value=SEARCH01;	
		            var sParam=FormQueryString(frmObj);
		            var xml=sheetObj.GetSearchData("ESM_SAM_0100GS.do", sParam);
		            sheetObjects[0].LoadSearchData(xml,{Sync:1} );
		            sheetObjects[0].SetWaitImageVisible(1);
		            ComOpenWait(false);
		            sheetObj.ClearHeaderCheck();
			break;
			case SEARCH02: //조회	
				if (!validateForm(sheetObj, frmObj, sAction)) {
					return false;
				}
					sheetObjects[1].SetWaitImageVisible(0);
					ComOpenWait(false);
					frmObj.f_cmd.value=SEARCH02;	
					var sParam=FormQueryString(frmObj);
					sls_act_tp_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sls_act_tp_cd");
					var xml=sheetObj.GetSearchData("ESM_SAM_0100GS.do?sls_act_tp_cd="+sls_act_tp_cd, sParam);
					sheetObjects[1].LoadSearchData(xml,{Sync:1} );
					sheetObjects[1].SetWaitImageVisible(1);
					ComOpenWait(false);
					sheetObj.ClearHeaderCheck();
			break;
			case IBSAVE:
				if(!validateForm(sheetObj, frmObj, sAction)){
					return false;
				}
				var sParamSheet1=sheetObjects[0].GetSaveString(0);
				if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
				    return;
				}
				var sls_act_tp_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sls_act_tp_cd");
				for(var i=1; i<=sheetObjects[1].RowCount(); i++){
					sheetObjects[1].SetCellValue(i, "sls_act_tp_cd", sls_act_tp_cd);
				}
                var sParamSheet2=sheetObjects[1].GetSaveString(0);
				if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
				    return;
				}
	 			frmObj.f_cmd.value=MULTI;	
	 			var sParam=FormQueryString(frmObj);
		 		if( sParamSheet1 != "" ){
					sParam += "&" + ComSamSetPrefix(sParamSheet1, "sheet1_");
				}
		 		if( sParamSheet2 != "" ){
					sParam += "&" + ComSamSetPrefix(sParamSheet2, "sheet2_");
				}
		 		var sXml=sheetObjects[0].GetSaveData("ESM_SAM_0100GS.do", sParam);
		 		sheetObjects[0].LoadSaveData(sXml);
				var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if(sav!="F"){
					ComShowCodeMessage("COM130102", "Data" );
					doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
				}
				break;
			case IBINSERT:
				if(sheetObj.id=='sheet1'){
					if (!validateForm(sheetObj, frmObj, sAction)) {
						return false;
					}
					rowInserted = true;
					var nowRow=sheetObjects[0].DataInsert(-1);
			       	sheetObjects[1].RemoveAll();
				}else if(sheetObj.id=='sheet2'){
					if (!validateForm(sheetObj, frmObj, sAction)) {
						return false;
					}
				       	var nowRow=sheetObjects[1].DataInsert(-1);
				       	sheetObjects[1].SelectCell(nowRow, "sls_act_sub_tp_cd", 1);
				       	sheetObjects[1].SetCellValue(nowRow, "sls_act_tp_cd", sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sls_act_tp_cd"));
				}
				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
		function validateForm(sheetObj, formObj, sAction) {
			switch (sAction){
			case IBSAVE:
				if(!sheetObjects[0].IsDataModified() && !sheetObjects[1].IsDataModified()){
					ComShowCodeMessage("SAM00006");
					return false;
				}
				var lastRow = sheetObjects[1].LastRow();
				for(var i=1; i<=lastRow; i++){
					if(sheetObjects[1].GetCellValue(i, "sls_act_sub_tp_cd")==""){
						ComShowCodeMessage("SAM00009", "Code");
						sheetObjects[1].SelectCell(i, "sls_act_sub_tp_cd", true);
						return false;
					}
				}
				lastRow = sheetObjects[0].LastRow();
				for(var i=1; i<=lastRow; i++){
					if(sheetObjects[0].GetCellValue(i, "sls_act_tp_cd")==""){
						ComShowCodeMessage("SAM00009", "Code");
						sheetObjects[0].SelectCell(i, "sls_act_tp_cd", true);
						return false;
					}
				}
				if(sheetObjects[0].GetSaveString(1)=="" && sheetObjects[1].GetSaveString(1)!==""){
					ComShowCodeMessage("SAM00011");
					sheetObjects[1].RemoveAll();
					doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
					return false;
				}
                var dupRow = sheetObjects[1].ColValueDup("sls_act_sub_tp_cd", 0);
                if(dupRow>0){
                	ComShowCodeMessage("SAM00007","Code");
                	sheetObjects[1].SetCellValue(dupRow, "sls_act_sub_tp_cd", "");
                	sheetObjects[1].SelectCell(dupRow, "sls_act_sub_tp_cd", true);
                	return false;
                }
                dupRow = sheetObjects[0].ColValueDup("sls_act_tp_cd", 0);
                if(dupRow>0){
                	ComShowCodeMessage("SAM00007","Code");
                	sheetObjects[0].SetCellValue(dupRow, "sls_act_tp_cd", "");
                	sheetObjects[0].SelectCell(dupRow, "sls_act_tp_cd", true);
                	return false;
                }
				var sheet1DelRow = sheetObjects[0].FindCheckedRow("del_chk");
				var sheet2DelRow = sheetObjects[1].FindCheckedRow("del_chk");
					if(sheet1DelRow!="" && sheet1DelRow!=undefined){
						var sheet1Arr = sheet1DelRow.split("|");
			 			for(var i=sheet1Arr.length-1; i>=0; i--){
			 				sheetObjects[0].SetRowStatus(sheet1Arr[i], "D");
			 				sheetObjects[0].SetRowHidden(sheet1Arr[i], 1);
			 				if(sheet1Arr.length==sheetObjects[0].RowCount() && i==0){
			 					sheetObjects[1].RemoveAll();
			 				}
			 			}
					}else if(sheet2DelRow!="" && sheet2DelRow!=undefined){
						var sheet2Arr = sheet2DelRow.split("|");
			 			for(var i=sheet2Arr.length-1; i>=0; i--){
			 				sheetObjects[1].SetRowStatus(sheet2Arr[i], "D");
			 				sheetObjects[1].SetRowHidden(sheet2Arr[i], 1);
			 			}
					}
			break;
			case IBINSERT:
				if(sheetObj.id=='sheet1'){
					var dupRow = sheetObjects[0].ColValueDup("sls_act_tp_cd", 0);
	                if(dupRow>0){
	                	for(var i=1; i<=sheetObjects[0].RowCount(); i++){
	                		if(sheetObjects[0].GetCellValue(i, "sls_act_tp_cd")==""){
		                		return true;
		                	}
	                	}
	                	ComShowCodeMessage("SAM00007","Code");
	                	sheetObjects[0].SetCellValue(dupRow, "sls_act_tp_cd", "");
	                	sheetObjects[0].SelectCell(dupRow, "sls_act_tp_cd", true);
	                	return false;
	                }
				}else if(sheetObj.id=='sheet2'){
					if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sls_act_tp_cd")==""){
						ComShowCodeMessage("SAM00011");
						sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(), "sls_act_tp_cd", 1);
						return false;
					}
					var dupRow = sheetObjects[0].ColValueDup("sls_act_tp_cd", 0);
	                if(dupRow>0){
	                	for(var i=1; i<=sheetObjects[0].RowCount(); i++){
	                		if(sheetObjects[0].GetCellValue(i, "sls_act_tp_cd")==""){
		                		return true;
		                	}
	                	}
	                	sheetObjects[1].RemoveAll();
	                	ComShowCodeMessage("SAM00007","Code");
	                	sheetObjects[0].SetCellValue(dupRow, "sls_act_tp_cd", "");
	                	sheetObjects[0].SelectCell(dupRow, "sls_act_tp_cd", true);
	                	return false;
	                }
	                var dupRow = sheetObjects[1].ColValueDup("sls_act_sub_tp_cd", 0);
	                if(dupRow>0){
	                	for(var i=1; i<=sheetObjects[1].RowCount(); i++){
	                		if(sheetObjects[1].GetCellValue(i, "sls_act_sub_tp_cd")==""){
		                		return true;
		                	}
	                	}
	                	ComShowCodeMessage("SAM00007","Code");
	                	sheetObjects[1].SetCellValue(dupRow, "sls_act_sub_tp_cd", "");
	                	sheetObjects[1].SelectCell(dupRow, "sls_act_sub_tp_cd", true);
	                	return false;
	                }
				}
				break;
			}
			return true;
		}
	
	/**
	 * Retrieve 클릭 시 셀 입력값이 없으면 원래대로, 값 있으면 저장 메세지
	 */
	function validateRetrieve(){
		sheetObject1 = sheetObjects[0];
		sheetObject2 = sheetObjects[1];
		var saveData = 0;
		var noneSaveData = 0;
		var s1Row = sheetObject1.FindStatusRow("I");
		var s2Row = sheetObject2.FindStatusRow("I");
		var s1InsertRow = s1Row.split(";");
		var s2InsertRow = s2Row.split(";");
		for(var i=0; i<s1InsertRow.length; i++){
			if(sheetObject1.GetRowStatus(s1InsertRow[i])=='I' && sheetObject1.GetCellValue(s1InsertRow[i], "sls_act_tp_cd")!=""){
				saveData++;
			}
		}
		for(var i=0; i<s2InsertRow.length; i++){
			if(sheetObject2.GetRowStatus(s2InsertRow[i])=='I' && sheetObject2.GetCellValue(s2InsertRow[i], "sls_act_sub_tp_cd")!=""){
				saveData++;
			}
		}
		if(saveData>0){
			return true;
		}else if(saveData==0){
			for(var i=0; i<s1InsertRow.length; i++){
				if(sheetObject1.GetCellValue(s1InsertRow[i], "sls_act_tp_cd")=="" && sheetObject1.GetCellValue(s1InsertRow[i], "sls_act_tp_desc")==""){
					noneSaveData++;
				}
			}
			for(var i=0; i<s2InsertRow.length; i++){
				if(sheetObject2.GetCellValue(s2InsertRow[i], "sls_act_sub_tp_cd")=="" && sheetObject2.GetCellValue(s2InsertRow[i], "sls_act_sub_tp_desc")==""){
					noneSaveData++;
				}
			}
			if(noneSaveData>0){
				doActionIBSheet(sheetObject1, document.form, SEARCH01);
				return false;
			}
			return true;
		}
	}
	
	/**
	 * Main type 선택 시 해당 Sub type도 자동 조회
	 */
	function sheet1_OnSelectCell (sheetObj, OldRow, OldCol, NewRow, NewCol){
		if(rowInserted){
			NewRow = sheetObj.RowCount();
			if(sheetObj.GetCellValue(NewRow, "sls_act_tp_cd")==""){
				sheetObj.SelectCell(NewRow, "sls_act_tp_cd", 1);
				rowInserted = false;
				return true;
			}
		}
		doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
	}
	   
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	    ComResizeSheet(sheetObjects[1]);
	}

