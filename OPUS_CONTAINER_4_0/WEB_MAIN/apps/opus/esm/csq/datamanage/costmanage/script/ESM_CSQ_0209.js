/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0209.js
*@FileTitle  : New Lane & Sector CMCB
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
 * @class ESM_CSQ_0209 : ESM_CSQ_0209 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var clickParam="";
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	function processButtonClick(){
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "f_bse_tp_cd":
					f_bse_tp_cd_OnChange();
					break;
				case "btn_Retrieve1":
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
					break;
				case "btn_Save1":
					doActionIBSheet(sheetObj1,formObj,IBSAVE);
					break;
				case "btn_Creation":
					doActionIBSheet(sheetObj1,formObj,COMMAND01);
					break;
				case "btn_Save2":
					doActionIBSheet(sheetObj2,formObj,COMMAND02);
					break;
				case "btn_Retreive2":
					doActionIBSheet(sheetObj2,formObj,IBSEARCH_ASYNC01);
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
		for (i=0; i<sheetObjects.length; i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
		for (k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}	
		toggleButtons("INIT");
		loadingMode=false;
		resizeSheet();
	}
	
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
			        var HeadTitle1="SEL|STS|SEQ|Trade|Sub Trade|New Lane|Lane Bound|Copy Source|cre_flg|save_flg|";
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
			        var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sel_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"src_rlane_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
					             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"save_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			        InitColumns(cols);
			        SetEditable(1);
			        SetSheetHeight(250);
			        InitComboNoMatchText(1,'',1);
	            }
			break;
			case 2:		//sheet1 init
			    with(sheetObj){
		        var HeadTitle1="STS|SEQ|bse_tp_cd|bse_yr|bse_qtr_cd|Trade|Sub Trade|New Lane|Lane Bound|POL|POD|Original CM cost UC|Original CM cost UC|Original CM cost UC|Revised CM cost UC|Revised CM cost UC|Revised CM cost UC|";
		        var HeadTitle2="STS|SEQ|bse_tp_cd|bse_yr|bse_qtr_cd|Trade|Sub Trade|New Lane|Lane Bound|POL|POD|CMCB(PA)|CMCB(RA)|PA-RA|CMCB(PA)|CMCB(RA)|PA-RA|";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"},
		                        { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gid_pa_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gid_ra_cm_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gid_diff",          KeyField:0,   CalcLogic:"|gid_pa_cm_uc_amt|-|gid_ra_cm_uc_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pa_cm_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ra_cm_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cm_diff",           KeyField:0,   CalcLogic:"|pa_cm_uc_amt|-|ra_cm_uc_amt|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		        InitColumns(cols);
		        SetEditable(1);
		        SetRangeBackColor(1, 9, 1, 30 , "#555555");
		        SetSheetHeight(250);
	            }
			break;
		}
	}
	/**
	 * 멀티콤보 항목을 설정한다.
	 */
	function initCombo(comboObj, comboId) {
		switch(comboObj.options.id) {
		case "f_bse_yr":
		case "f_bse_qtr_cd":
			with (comboObj) {
				SetDropHeight(300);
			}
			break;
		default:
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(0);
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
			case IBCLEAR:          //조회
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0209GS.do", FormQueryString(formObj));
				// var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
				if (arrXml.length > 2)
					ComSetYearQta(arrXml[2]);
				ComOpenWait(false);
				break;
			case IBSEARCH:          // 화면1 조회 시
				ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					searchParams=FormQueryString(formObj);
					var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0209GS.do", searchParams, {Sync:2});
					sheetObj.LoadSearchData(rtnXml,{Sync:1} );
					ComOpenWait(false);
				break;
			case IBSAVE:          // 화면 저장시
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
					return false;
				}
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI01);
				
				var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
				var sXml = sheetObj.GetSaveData("ESM_CSQ_0209GS.do", searchParams + "&" + saveStr);
				var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				
				ComOpenWait(false);
				if (State == "S") {
					ComShowCodeMessage("CSQ00001", "Data");
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				} else {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
				break;
			case COMMAND01:          // creation
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI);
				var sParam=sheetObj.GetSaveString(false, true, "sel_flg");
				var sXml=sheetObjects[0].GetSaveData("ESM_CSQ_0209GS.do", searchParams + "&" +sParam);
				// var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				ComOpenWait(false);
				if (State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					return false;
				} else if(State == "S"){
					ComShowCodeMessage('CSQ00010','Data');
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
				break;
			case IBSEARCH_ASYNC01:          // 화면2 조회 시
				ComOpenWait(true);
				setTimeout(function(){
					clickParam = "f_trd_cd="       + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"trd_cd")
					+"&f_sub_trd_cd="   + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"sub_trd_cd")
					+"&f_dir_cd="       + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"dir_cd")
					+"&f_rlane_cd="     + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"rlane_cd");
					ComSetSearchParams("f_cmd", SEARCHLIST);
					var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0209GS.do", searchParams + "&" + clickParam);
					sheetObj.LoadSearchData(rtnXml,{Sync:1} );
					if (sheetObj.SearchRows()== 0) {
						toggleButtons("SEARCH2-1");
					} else {
						toggleButtons("SEARCH2");
					}
				}, 100);
				break;
			case COMMAND02:          // 화면2 저장시
				if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006");
				    return false;
				} else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
					return false;
				}
				ComSetSearchParams("f_cmd", MULTI02);
				
				var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
				var sXml = sheetObj.GetSaveData("ESM_CSQ_0209GS.do", searchParams + "&" + saveStr);
				var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				
				if (State == "S") {
					ComShowCodeMessage("CSQ00001", "Data");
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
				} else {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
				break;
	    }
	}
	 /**
	 * sheet1_OnSearchEnd
	 *01. 해당 row가 creation 된 상태일 때 row비활성화
	 *02. 해당 row가 creation되지 않은 상태일 때 trd_cd콤보활성화
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @param value
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		var xmlStr=null;
		var arrXml=null;
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		//creation 될 row가 존재하지 않을때
		if(sheetObj.FindText("cre_flg", "N", 0) == "-1"){
			toggleButtons("SEARCH1");
		}else{
			toggleButtons("Creation");
		}
	    //sheet내 lane combo세팅	
		for (var i=sheetObj.HeaderRows(); i<sheetObj.RowCount()+sheetObj.HeaderRows(); i++){
			if (sheetObj.GetCellValue(i,"cre_flg") == "Y"){
	   			sheetObj.SetRowEditable(i,0);
	   		} else {
	   			var subTrdCd	 =sheetObj.GetCellValue(i,"sub_trd_cd");	// sub trade code
	   			var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	   			
			 	var param="f_cmd=" + SEARCH01
			     + "&code_name=rLaneSector"
			     + "&code_param="+trd_cd+"|"
			     				+f_bse_tp_cd+"|"
			     				+f_bse_yr+"|"
			     				+f_bse_qtr_cd+"|"
			     			    +subTrdCd
			     + "&all_flag=";
				xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
				arrXml=xmlStr.split("|$$|");
				if (arrXml.length > 0)
					ComCsqSetIBCombo(sheetObj, arrXml[0], "src_rlane_cd", true, 1, i);
				sheetObj.SetCellValue(i,"ibflag","R");
	   		}
		}
	}
	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		ComOpenWait(false);
	}
	   /**
	   * sheet1_onChange event
	   * src_rlane_cd 바뀌었을때 validation
	   */
	  function sheet1_OnChange(sheetObj, row, col, value){
		   sheetObj.SetWaitImageVisible(0);
	    		with(sheetObj){
	    			switch(ColSaveName(col)){
	            		case "src_rlane_cd":
	            			var text=getSheetComboCode(sheetObj, row, col);
	            			sheetObj.SetCellValue(row, col,text,0);
	            			sheetObj.SetCellValue(row, "save_flg","N");
	            			break;
	    			}
	    		}
	    	}
	   /**
	   * sheet1_OnDblClick event
	   * sheet1 row클릭시 sheet2조회
	   */
	  function sheet1_OnDblClick(sheetObj, Row, Col){
		   var formObj=document.form;
		   sheetObj.SetWaitImageVisible(0);
		   doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC01);
	  }
		/**
		 * 화면의 모든 버튼들의 Enable/Disable을 처리
		 */
	  function toggleButtons(step) {
	      switch (step) {
	      case "INIT":
	          ComBtnEnable("btn_Retrieve1");
	          ComBtnDisable("btn_Retreive2");
	          ComBtnDisable("btn_Save1");
	          ComBtnDisable("btn_Save2");
	          ComBtnDisable("btn_Creation");
	          break;
	      case "SEARCH1":
	          ComBtnEnable("btn_Retrieve1");
	          ComBtnEnable("btn_Retreive2");
	          ComBtnEnable("btn_Save1");
	          ComBtnDisable("btn_Save2");
	          ComBtnDisable("btn_Creation");
	          break;
	      case "Creation":
	          ComBtnEnable("btn_Retrieve1");
	          ComBtnEnable("btn_Retreive2");
	          ComBtnEnable("btn_Save1");
	          ComBtnDisable("btn_Save2");
	          ComBtnEnable("btn_Creation");
	          break;
	      case "SEARCH2":
	    	  ComBtnEnable("btn_Save2");
	    	  break;
	      case "SEARCH2-1":
	    	  ComBtnDisable("btn_Save2");
	    	  break;
	      }
	  }
	  /**
	   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	   */
	  function validateForm(sheetObj, formObj, sAction){
	  	switch(sAction) {
	  		case IBSAVE: //Save시
	  			if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006");
				    return false;
				} 
				for(var i=sheetObj.HeaderRows();i<sheetObj.RowCount()+sheetObj.HeaderRows();i++){
	  				if(sheetObj.GetCellValue(i,"ibflag") == "U" && sheetObj.GetCellValue(i,"rlane_cd") == sheetObj.GetCellValue(i,"src_rlane_cd")){
	  					ComShowCodeMessage("CSQ00048");
	  					return false;
	  				}
	  			}
	  			break;
	  		case COMMAND01:  // Creation시
	  			var chkRow=sheetObj.FindCheckedRow("sel_flg");
	  			if	(chkRow == ""){
					ComShowCodeMessage("COM12113", "rows to creation");
					return false;
	  			}
				for(var i=sheetObj.HeaderRows();i<sheetObj.RowCount()+sheetObj.HeaderRows();i++){
	  				if (sheetObj.GetCellValue(i,"sel_flg") == "1" && sheetObj.GetCellValue(i,"src_rlane_cd")== ""){
	  					ComShowCodeMessage("CSQ00024", "Copy Source");
	  					return false;
	  				}
	  				if (sheetObj.GetCellValue(i,"sel_flg") == "1" && sheetObj.GetCellValue(i,"rlane_cd") == sheetObj.GetCellValue(i,"src_rlane_cd")){
	  					ComShowCodeMessage("CSQ00048");
	  					return false;
	  				}
	  			}
	  			var chk=chkRow.split("|");
	  			for (var i=0; i<chk.length; i++){
	  				if(sheetObj.GetCellValue(chk[0],"save_flg") == "N"){
	  					ComShowCodeMessage("CSQ00017");
	  					return false;
	  				}
	  			}
	  			break;
	  	}
	  	return true;
	  }
	   /**
	    * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
	    */
	   function f_bse_tp_cd_OnChange() {
		   	var formObj=document.form;
		   	var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd[0]);
		   	var div_qtr=document.getElementById("div_qtr");
		   	var div_period=document.getElementById("div_period");
		   	if (bse_tp_cd == "Y") {
		   		div_qtr.style.display="none";
		   		div_period.style.display="none";
		   		f_bse_qtr_cd.SetVisible(0);
		   	} else {
		   		div_qtr.style.display="inline";
		   		div_period.style.display="inline";
		   		f_bse_qtr_cd.SetVisible(1);
		   	}
		   	period_change();
	   }
	   /**
	    * f_bse_yr가 바뀌었을때 period 의 year 변경
	    */
	   function f_bse_yr_OnChange(obj, value, text) {
	   		period_change();
	   }
	   /**
	    * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
	    */
	   function f_bse_qtr_cd_OnChange(obj, value, text) {
		   period_change();
	   }
	   
	   function resizeSheet(){
		   ComResizeSheet(sheetObjects[1]);
	   }
	/* 개발자 작업  끝 */