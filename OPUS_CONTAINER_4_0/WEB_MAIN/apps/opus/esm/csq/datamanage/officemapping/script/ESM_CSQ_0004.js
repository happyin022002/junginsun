/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0004.js
*@FileTitle  : RHQ-Office Mapping
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_CSQ_0004 : ESM_CSQ_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_Creation":
					if (!validateForm(sheetObject, formObject, srcName)) {
						return false;
					}
		        	ComOpenPopup("/opuscntr/ESM_CSQ_0005.do?", 350, 200,'','0,1,1,1,1,1,1,1', true);
					break;
				case "btn_Downexcel":
					if (sheetObject.RowCount() < 1){//no data
			          ComShowCodeMessage("COM132501");
			        } else{
			        	sheetObject.Down2Excel({ CheckBoxOffValue:" ", CheckBoxOnValue:"Y", HiddenColumn:1 });
			        }
					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
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
		for (i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		
		doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
		toggleButtons("INIT");
		loadingMode=false;
		resizeSheet();
		toggleButtons("SEARCH");
	}
	
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:		//sheet1 init
		   with(sheetObj){
			   var HeadTitle1="SEL|DEL|STS|Seq|RHQ|Office|ADD_FLG|Deleted|";
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			   var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"sel",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo", Hidden:0,  Width:80,  Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"add_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			   InitColumns(cols);
			   SetEditable(1);
			   SetSheetHeight(400);
			   InitComboNoMatchText(1,'',1);
	      }
		  break;
		}
	}
	/**
	 * 멀티콤보 항목을 설정한다.
	 */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			SetDropHeight(300);
			ValidChar(2);
		}
	}
	/**
	 * Sheet 관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          //화면 오픈시 콤보 setting
				sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0004GS.do", FormQueryString(formObj));
//				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0){
					ComXml2ComboItem(arrXml[0], f_rhq_cd, "code", "name");
					comboObjects[0].InsertItem(0, 'All', 'All');
					ComCsqSetIBCombo(sheetObj, arrXml[0], "rhq_cd", true);
//					ComCsqSetIBCombo(sheetObj, arrXml[1], "rgn_ofc_cd", true);
					f_rhq_cd.SetSelectIndex(0);
				}
				break;
				
			case IBINSERT:          // Row Add 시
				var row=sheetObj.DataInsert();
				break;
				
			case IBSEARCH:          //화면 조회시
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_CSQ_0004GS.do", FormQueryString(formObj), {Sync:2} );
				
				break;
				
			case IBSAVE:          // 화면 저장시
				var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
				if ( saveStr == "" ) {
					ComShowCodeMessage("CSQ00006");
					return;
				}
				if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006");
				    return false;
				} else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
					return false;
				}
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				var sParam=sheetObj.GetSaveString(false, true, "ibflag");
				var sXml=sheetObjects[0].GetSaveData("ESM_CSQ_0004GS.do",FormQueryString(formObj) + "&" +sParam);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				ComOpenWait(false);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('CSQ00001','Data');
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}

				break;
	    }
	}
	    /**
	    * 추가된 office일 경우 creation check 활성화
	    * @param sheetObj
	    * @param ErrMsg
	    */
	 function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(document.form.f_deleted_flg.checked == false){
			sheetObj.SetColHidden('del', 0);
			sheetObj.SetWaitImageVisible(0);
			var formObj=document.form;
			for (var i = 0; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i,"add_flg") == "Y"){   // 추가된 office일 경우 creation check 활성화
					sheetObj.SetCellEditable(i, "sel", 1);
				}				
			}
			
			if(sheetObj.FindText("add_flg", "Y", 0) == "-1"){
				toggleButtons("SEARCH");
			}else{
				toggleButtons("Creation");
			}
		}else if(document.form.f_deleted_flg.checked == true){
			ComBtnDisable("btn_Creation");
			sheetObj.SetColHidden('del', 1);
			sheetObj.SetWaitImageVisible(0);
			var formObj=document.form;
			for (var i = 0; i <= sheetObj.RowCount(); i++) {
					sheetObj.SetCellEditable(i, "sel", 1);
			}
		}
	 }
	    /**
	     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	     */
	    function validateForm(sheetObj, formObj, sAction){
	    	switch(sAction) {
	    		case "btn_Creation":  // Creation
		  			if (sheetObjects[0].CheckedRows("sel") < 1) {
		  				ComShowCodeMessage("COM12113", "one row");
		  				return false;
		  			}
	        		break;
	    	}
	    	return true;
	    }
		/**
		 * 화면의 모든 버튼들의 Enable/Disable을 처리
		 */
	function toggleButtons(step) {
	   switch (step) {
		   case "INIT":
		       ComBtnEnable("btn_Retrieve");
		       ComBtnDisable("btn_Save");
		       ComBtnDisable("btn_Creation");
		       ComBtnDisable("btn_Downexcel");
		       ComBtnDisable("btn_RowAdd");
		       break;
		   case "SEARCH":
			   ComBtnEnable("btn_Save");
		       ComBtnDisable("btn_Creation");
			   ComBtnEnable("btn_Downexcel");
			   ComBtnEnable("btn_RowAdd");
		       break;
		   case "Creation":
			   ComBtnEnable("btn_Save");
			   ComBtnEnable("btn_Creation");
			   ComBtnEnable("btn_Downexcel");
			   ComBtnEnable("btn_RowAdd");
		       break;
	   }
	}
	
	function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
   }
	
	
function sheet1_OnChange(sheetObj, row, col, value){
	switch(sheetObj.ColSaveName(col)){
		case "rhq_cd":
			if(sheetObj.GetCellValue(row, 'ibflag') == 'I'){
				if( sheetObj.GetCellValue(row, 'rhq_cd') != '' ){
					sheetObj.SetCellEditable(row, "rgn_ofc_cd",1);
				} 
				
				var rhqCd=sheetObj.GetCellValue(row, 'rhq_cd')
				if(rhqCd != ""){
					var param="f_cmd=" + SEARCH01
					     + "&code_name=office"
					     + "&code_param=" + rhqCd
					     + "&all_flag=";	// Trade
					var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
					var arrXml=xmlStr.split("|$$|");
					ComCsqSetIBCombo(sheetObj, arrXml[0], "rgn_ofc_cd", true);
				}
				
			}
			break;
		case "sel":
			if( sheetObj.GetColHidden('del') == 1 ){
				if( sheetObj.GetCellValue(row, 'sel') == true/* || sheetObj.GetCellValue(row, 'delt_flg') == 'Y' */){
					sheetObj.SetCellValue(row, "delt_flg",'N');
				}else if( sheetObj.GetCellValue(row, 'sel') == false/* || sheetObj.GetCellValue(row, 'delt_flg') == 'N' */){
					sheetObj.SetCellValue(row, "delt_flg",'Y');
				}
			}else if( sheetObj.GetColHidden('del') == 0 ){
				if( sheetObj.GetCellValue(row, 'del') == false ){
					sheetObj.SetCellValue(row, "ibflag",'R');
				}
			}
			break;
		case "del":
			if( sheetObj.GetColHidden('del') == 0 ){
				if( sheetObj.GetCellValue(row, 'del') == true ){
					sheetObj.SetCellValue(row, "delt_flg",'Y');
				}else if( sheetObj.GetCellValue(row, 'del') == false ){
					sheetObj.SetCellValue(row, "delt_flg",'N');
				}
			}
			break;
	}
	
}

	/* 媛쒕컻���묒뾽  ��*/
