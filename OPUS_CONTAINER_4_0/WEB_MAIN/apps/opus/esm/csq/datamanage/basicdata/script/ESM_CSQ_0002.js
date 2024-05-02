/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0002.js
*@FileTitle  : Lane Master
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND38=11; ~ COMMAND20=30;

 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
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
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "f_bse_tp_cd":
					f_bse_tp_cd_OnChange();
				break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject, formObj, IBSAVE);
					break;
				case "btn_PreQTACopy":
					doActionIBSheet(sheetObject, formObj, "IBCOPY");
					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObject, formObj, IBINSERT);
					break;
				case "btn_Downexcel":
					if (sheetObject.RowCount() < 1){//no data
			          ComShowCodeMessage("COM132501");
			        } else{
			        	sheetObject.Down2Excel({ CheckBoxOffValue:" ", CheckBoxOnValue:"Y", HiddenColumn:1 });
			        }
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
		var formObj=document.form;
		loadingMode=true;
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
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
				var bse_tp_cd=ComGetObjValue(document.form.f_bse_tp_cd[0]);
		        var HeadTitle="DEL|STS|SEQ|Year|Quarter|Trade|Sub Trade|R.Lane|Active Lane Bound|Sector|Active|bse_tp_cd|";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = 
			    	[{Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:3 },
		             {Type:"Combo", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:2 },
		             {Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:5 },
		             {Type:"Combo", 	Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"lane_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:1 },
		             {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ias_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"csq_act_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"",  		Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 }];
		      InitColumns(cols);
		      InitComboNoMatchText(1,'',1);
		      SetEditable(1);
		      SetSheetHeight(400);
		      SetColProperty(0 ,"trd_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		      SetColProperty(0 ,"sub_trd_cd" , {AcceptKeys:"N|E" , InputCaseSensitive:1});
		      SetColProperty(0 ,"rlane_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		      SetColProperty(0 ,"lane_dir_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
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
			case IBCLEAR:          // 화면 접속 시
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0002GS.do", FormQueryString(formObj));
//				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
				var arrXml=sXml.split("|$$|");
				
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
				if (arrXml.length > 2)
					ComSetYearQta(arrXml[2]);
				if (arrXml.length > 3){
					ComXml2ComboItem(arrXml[3], f_trd_cd, "code", "name");
					comboObjects[2].InsertItem(0, 'All', 'All');
					ComCsqSetIBCombo(sheetObj, arrXml[3], "trd_cd", true);
					// f_trd_cd.SetSelectIndex(0);
				}
				if (arrXml.length > 4){
					ComXml2ComboItem(arrXml[4], f_lane_dir_cd, "code", "name");
					comboObjects[5].InsertItem(0, 'All', 'All');
					ComCsqSetIBCombo(sheetObj, arrXml[4], "lane_dir_cd", true);
					// lane_dir_cd.SetSelectIndex(0);
				}
				
//				if (arrXml.length > 5)
//					ComCsqSetIBCombo(sheetObj, arrXml[5], "rlane_cd", true);
					comboObjects[4].InsertItem(0, 'All', 'All');
//				if (arrXml.length > 6)
//					ComCsqSetIBCombo(sheetObj, arrXml[6], "sub_trd_cd", true);
				
				ComOpenWait(false);
				break;
				
			case IBSEARCH:          // 화면 조회 시
				sheetObj.SetWaitImageVisible(1);
				toggleButtons("INIT");
				
				formObj.f_cmd.value=SEARCH;
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0002GS2.do",FormQueryString(formObj)); //GS2
	    		sheetObj.LoadSearchData(rtnXml,{Sync:1} );
				break;
				
			case IBSAVE:          // 화면 저장 시 
				
				if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006");
			        return false;
			    }
				
				// Yongseup Kim - made a logic to make sure that all the 'Sector' cells related to a trade are checked altogether before saving  
				
				var trade_with_sector_problem = '';
					
				for(z=0 ; z<=sheet1.LastRow(); z++){
					if( sheet1.GetCellValue(z,'trd_cd') == sheet1.GetCellValue(z+1,'trd_cd') ){
						if( sheet1.GetCellValue(z,'ias_sctr_flg') != sheet1.GetCellValue(z+1,'ias_sctr_flg') ){
							trade_with_sector_problem = trade_with_sector_problem + "|" + sheet1.GetCellValue(z,'trd_cd');
						}
					}
				}	
				
				var array_of_trade_with_sector_problem = trade_with_sector_problem.split("|");
				
				var filtered_trade = '';
				
				for(q=1; q<=array_of_trade_with_sector_problem.length; q++){
					if(array_of_trade_with_sector_problem[q] != array_of_trade_with_sector_problem[q+1]){
						filtered_trade =  array_of_trade_with_sector_problem[q] + " " +  filtered_trade;
					}
				} 
				
				if(trade_with_sector_problem != ""){
					ComShowCodeMessage('CSQ00052',filtered_trade);
					break;
				}
				
				var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
				if ( saveStr == "" ) {
					return;
				}
				if (sheetObj.IsDataModified()== false) {
					ComShowCodeMessage("CSQ00006"); //There is no data to save.
				    return false;
				} else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) { //Do you want to save?"
					return false;
				}
				
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				var sParam=sheetObj.GetSaveString(false, true, "ibflag");
				var sXml=sheetObjects[0].GetSaveData("ESM_CSQ_0002GS.do",FormQueryString(formObj) + "&" +sParam);
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
				
			case "IBCOPY":			// 최근 이전 분기의 데이터를 복사
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				if (ComShowConfirm (ComGetMsg("CSQ00005")) != 1) {
					return false;
			    }
				
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI01;
				var sXml=sheetObjects[0].GetSaveData("ESM_CSQ_0002GS.do",FormQueryString(formObj));
				ComOpenWait(false);
				
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if ( State == "S" ) {
					ComShowCodeMessage("CSQ00003", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);  
				} else if ( State != "S" ) {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
				break;
				
			case IBINSERT:          // Row Add 시
				sheetObj.RenderSheet(0);
				var row = sheetObj.DataInsert();
				sheetObj.RenderSheet(1);
				sheetObj.SetCellValue(row, "bse_tp_cd",ComGetObjValue(formObj.f_bse_tp_cd[0]),0);
				sheetObj.SetCellValue(row, "bse_yr",ComGetObjValue(f_bse_yr),0);
				if (ComGetObjValue(formObj.f_bse_tp_cd[0]) == "Q") sheetObj.SetCellValue(row, "bse_qtr_cd",ComGetObjValue(f_bse_qtr_cd),0);

				break;
				//sub_trd_cd
	    }
	}
	 /**
	  * onChange event
	  * f_trd_cd 바뀌었을때  sub_trd_cd,f_lane_cd 콤보조회
	  */	
	 function f_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	 	var formObj=document.form;
		var trdcd=comboObjects[2].GetSelectCode();
	 	var param="f_cmd=" + SEARCH01 
	     		+ "&code_name=mdmSubTrade"
	     		+ "&code_param=" + trdcd
	     		+ "&all_flag=All";	// Trade
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
		comboObjects[3].SetSelectIndex(0);
	 }
	    /**
	   * sheet1_onChange event
	   */  
	  function sheet1_OnChange(sheetObj, row, col, value){
		   sheetObj.SetWaitImageVisible(0);
	    		with(sheetObj){
	    			switch(ColSaveName(col)){
	                	case "trd_cd":
	            			var trdCd=getSheetComboCode(sheetObj, row, col);
	            			if(trdCd != ""){
		            			var param="f_cmd=" + SEARCH01
		           			     + "&code_name=mdmSubTrade"
		           			     + "&code_param=" + trdCd[0]
		           			     + "&all_flag=";	// Trade
		            			var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		           				var arrXml=xmlStr.split("|$$|");
		           				var ttlRow=ComGetTotalRows(arrXml[0]);
		        				if (ttlRow == "0"){
		        					sheetObj.CellComboItem(row,"sub_trd_cd", {ComboText:"", ComboCode:""} );
		        				}else{
		        					if (arrXml.length > 0)
			        					ComCsqSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true, "sub_trd_cd", row);
		        					else
		        						sheetObj.CellComboItem(row,"sub_trd_cd", {ComboText:"", ComboCode:""} );
		        				}
	            			} else {
	            				sheetObj.CellComboItem(row,"sub_trd_cd", {ComboText:"", ComboCode:""} );
	            			}
	                		break;  
	                	case "sub_trd_cd":
		            		var trdCd=getSheetComboCode(sheetObj, row, "trd_cd");
		        			var subTrdCd=getSheetComboCode(sheetObj, row, "sub_trd_cd");
		        			if(trdCd != " " && subTrdCd != " "){	
		        			 	var param="f_cmd=" + SEARCH01
		        			     + "&code_name=mdmRLane"
		        			     + "&code_param=" + trdCd[0] + "|" + subTrdCd[0]
		        			     + "&all_flag=";	// Trade
		        			     var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		        				var arrXml=xmlStr.split("|$$|");
		        				var ttlRow=ComGetTotalRows(arrXml[0]);
		        				if (ttlRow == "0"){
		        					sheetObj.CellComboItem(row,"rlane_cd", {ComboText:"", ComboCode:""} );
		        				}else{
		        					if (arrXml.length > 0)
			        					ComCsqSetIBCombo(sheetObj, arrXml[0], "rlane_cd", true, "rlane_cd", row);
		        					else
		        						sheetObj.CellComboItem(row,"rlane_cd", {ComboText:"", ComboCode:""} );
		        				}
		        			} else {
		        				sheetObj.CellComboItem(row,"rlane_cd", {ComboText:"", ComboCode:""} );
		        			}
		        			break;
	            		case "rlane_cd":
	            			var text=getSheetComboCode(sheetObj, row, col);
	            			sheetObj.SetCellValue(row, col,text,0);
	            			break;
	    			}
	    		}
	    	}
	   /**
	    * onChange event
	    * f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
	    */	 
	    function f_sub_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	   		var formObj=document.form;
			var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
			var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
			var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
			var trdcd 		 = comboObjects[2].GetSelectCode();
			var subtrdcd 	 = comboObjects[3].GetSelectCode();
	   		if( trdcd != "All" || subtrdcd != "All"){
			 	var param="f_cmd=" + SEARCH01
			     		+ "&code_name=mdmRLane"
			     		+ "&code_param="+trdcd+"|"
			     				 		+subtrdcd
			     		+ "&all_flag=All";
	   			var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	   			ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
	   			f_rlane_cd.SetSelectIndex(0);
	   		}else{
	   			f_rlane_cd.RemoveAll();
	   			f_rlane_cd.InsertItem(0, "All", "All");
	   			f_rlane_cd.SetSelectIndex(0);
	   		}
	   	}
	    
	    /**
	     * f_bse_tp_cd 諛붾��덉쓣��qtr_cd, week 蹂�꼍
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
	     * f_bse_yr 변경시 period 와 year 설정한다.
	     */
	    function f_bse_yr_OnChange(obj, value, text) {
	    	period_change();
	    }
	    /**
	     * f_bse_qtr_cd 변경시 period 와 week 설정한다.
	     */
	    function f_bse_qtr_cd_OnChange(obj, value, text) {
	    	period_change();
	    }
	/* 媛쒕컻���묒뾽  ��*/
	    
	    function resizeSheet(){
	        ComResizeSheet(sheetObjects[0]);
	    }
	    
	    /**
	     * 화면의 모든 버튼들의 Enable/Disable을 처리
	     */
	    function toggleButtons(step) {
	    	switch (step) {
	    		case "INIT":
	    			ComBtnDisable("btn_Save");
	    			ComBtnDisable("btn_PreQTACopy");
	    			ComBtnDisable("btn_Downexcel");
	    			ComBtnDisable("btn_RowAdd");
	    			break;
	    		case "COPY":
	    			// 議고쉶��Year, Quarter ���대떦�섎뒗 Data ��Count 媛�0 ��寃쎌슦
	    			ComBtnEnable("btn_PreQTACopy");
	    			break;
	    		case "SEARCH":
	    			ComBtnEnable("btn_Save");
	    			ComBtnEnable("btn_Downexcel");
	    			ComBtnEnable("btn_RowAdd");
	    			break;
	    	}
	    }
	    
	    /**
	     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	     */
	    function validateForm(sheetObj, formObj, sAction){
	    	switch(sAction) {
	    		case IBSAVE:
	    			var sList=sheetObj.FindStatusRow("I");
	    			var sArr=sList.split(";");
	    			var team_cd="";
	    			for (var i=0; i < sArr.length; i++) {
	    				team_cd=sheetObj.GetCellValue(sArr[i], "team_cd");
	    				if (team_cd.length != 6) {
	    					ComShowMessage(ComGetMsg("CSQ00002"));
	    					sheetObj.SelectCell(sArr[i], "team_cd");
	    					return false;
	    				}
	    			}
	        		break;
	    	}
	    	return true;
	    }
	    
		function sheet1_OnSearchEnd(sheetObj, errMsg) {
			sheetObj.SetWaitImageVisible(0);
			// Yearly/Quarterly 에 따라서  sheet 의 Quarter 항목을 컨트롤한다. 
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.SetColHidden("bse_qtr_cd",1);
			} else {
				sheetObj.SetColHidden("bse_qtr_cd",0);
			}
			
			if (sheetObj.GetCellValue(1,1) == -1) { // when there is no data found
				toggleButtons("COPY");
			} else {
				toggleButtons("SEARCH");
			}
		}
