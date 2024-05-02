/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName       : ESM_CSQ_0003.js
*@FileTitle      : Lane Direction Change
*@LastVersion    : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND02=11; ~ COMMAND20=30;
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
				case "btn_Copy":
					doActionIBSheet(sheetObject, formObj,IBSEARCH_ASYNC01);
					break;
				case "btn_Downexcel":
					if (sheetObject.RowCount() < 1){//no data
			          ComShowCodeMessage("COM132501");
			        } else{
			        	sheetObject.Down2Excel({ CheckBoxOffValue:" ", CheckBoxOnValue:"Y", HiddenColumn:1 });
			        }
					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObject, formObj, IBINSERT);
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
		toggleButtons("INIT");
		doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode=false;
		resizeSheet();
	}
	
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		        var HeadTitle="DEL|STS|SEQ|Trade|R.Lane|Lane Bound|Trade Bound|bse_tp_cd|bse_yr|bse_qtr_cd|";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"delete",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		             {Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dir_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetSheetHeight(ComGetSheetHeight(sheetObj, 18));
		        InitComboNoMatchText(1,'',1);
		        SetColProperty(0 ,"trd_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
			    SetColProperty(0 ,"sub_trd_cd" , {AcceptKeys:"N|E" , InputCaseSensitive:1});
			    SetColProperty(0 ,"dir_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
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
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0003GS.do", FormQueryString(formObj));
				// var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
				if (arrXml.length > 2)
					ComSetYearQta(arrXml[2]);
				if (arrXml.length > 3){
					ComXml2ComboItem(arrXml[3], f_dir_cd, "code", "name");
					f_dir_cd.InsertItem(0, 'All', 'All');
					ComCsqSetIBCombo(sheetObj, arrXml[3], "dir_cd", true);
					ComCsqSetIBCombo(sheetObj, arrXml[3], "conv_dir_cd", true);
				}
				ComOpenWait(false);
				break;
				
			case IBSEARCH:          // 화면 조회 시
				formObj.f_cmd.value=SEARCH;
				searchParams = FormQueryString(formObj);
				var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0003GS.do",searchParams);
	    		sheetObj.LoadSearchData(rtnXml,{Sync:1} );
				var etcData = sheetObj.GetEtcData("dataCnt");
				if (etcData == 0) {
					toggleButtons("COPY");
				} else {
					toggleButtons("SEARCH");
				}
				break;
				
			case IBSAVE:          // 화면 저장시
				
				var saveStr = sheetObj.GetSaveString(false, true, "ibflag");
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
				var sXml=sheetObjects[0].GetSaveData("ESM_CSQ_0003GS.do",FormQueryString(formObj) + "&" +saveStr);
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
			case IBINSERT:          // Row Add 시
				sheetObj.RenderSheet(0);
				var row = sheetObj.DataInsert();
				sheetObj.DataInsert(row+1);
				sheetObj.RenderSheet(1);
				
				sheetObj.SetCellEditable(row, "trd_cd",1);
				sheetObj.SetCellEditable(row, "rlane_cd",1);
				sheetObj.SetCellEditable(row, "dir_cd",1);
				
				sheetObj.SetCellValue(row, "bse_tp_cd",ComGetObjValue(formObj.f_bse_tp_cd[0]),0);
				sheetObj.SetCellValue(row, "bse_yr",ComGetObjValue(f_bse_yr),0);
				if (ComGetObjValue(formObj.f_bse_tp_cd[0]) == "Q") sheetObj.SetCellValue(row, "bse_qtr_cd",ComGetObjValue(f_bse_qtr_cd),0);

				break;
				
			case IBSEARCH_ASYNC01:          // 최근 이전 분기의 데이터를 복사
				if (ComShowConfirm (ComGetMsg("CSQ00005")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				setTimeout(function(){
					ComSetSearchParams("f_cmd", MULTI01);
					var sXml = sheetObjects[0].GetSaveData("ESM_CSQ_0003GS.do", searchParams);
					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					if(State != "S"){
						ComShowMessage(ComResultMessage(sXml));
						return false;
					}else if(State == "S"){
						ComShowCodeMessage('CSQ00003','Data');
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
					ComOpenWait(false);
				}, 100);
				break;
	    }
	}
	

	 /**
	  * onChange event
	  * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
	  */	
	 function f_trd_cd_OnChange(obj, value, text) {
	 	var formObj=document.form;
	 	var trd_cd		 = ComGetObjValue(f_trd_cd);	// trade code
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var sector_include = "Y"; //rlane 조회시 sector도 포함
   		if( trd_cd != "All" ){
		 	var param="f_cmd=" + SEARCH01
		     		+ "&code_name=rLane"
		     		+ "&code_param="+trd_cd+"|"
		     						+f_bse_tp_cd+"|"
		     						+f_bse_yr+"|"
		     						+f_bse_qtr_cd+"|"
		     						+"|"
		     						+sector_include
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
		 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
		 */
		function setTradeCombo() {
		    var formObj=document.form;
		    var sheetObj=sheetObjects[0];
		    var param="";
			var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
			var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
			var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
			var sector_include = "Y"; //trade 조회시 sector도 포함
		    param="f_cmd=" + SEARCH01
		     + "&code_name=trade"
		     + "&code_param="  + f_bse_tp_cd + "|" + f_bse_yr + "|" + f_bse_qtr_cd+ "|" +sector_include
		     + "&all_flag=";    // Trade
		    var sXml=sheetObj.GetSearchData("CommonGS.do",param);
		    if (sXml != "") {
		    	//sheet 내 trd_cd
				ComCsqSetIBCombo(sheetObj, sXml, "trd_cd", true);
				//form 조건 내 trd_cd 
		        ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
		        f_trd_cd.InsertItem(0, "All", "All");
		        f_trd_cd.SetSelectIndex(0);
		    } else {
		        f_trd_cd.RemoveAll();
		        f_trd_cd.InsertItem(0, "All", "All");
		        f_trd_cd.SetSelectIndex(0);
		    }
		}
	 
	  /**
	   * sheet1_onChange event
	   * trd_cd 바뀌었을때 lane_cd 콤보조회
	   */  
	  function sheet1_OnChange(sheetObj, row, col, value){
		    var formObj=document.form;
			var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
			var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
			var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
			var sector_include = "Y"; //rlane 조회시 sector도 포함
		   sheetObj.SetWaitImageVisible(0);
	    		with(sheetObj){
	    			switch(ColSaveName(col)){
	                	case "trd_cd":
	            			var text=getSheetComboCode(sheetObj, row, col);
	                		sheetObj.SetCellValue(row, col,text,0);
	            			if(text != " "){	
	            				var param="f_cmd=" + SEARCH01
	            			     + "&code_name=rLane"
	            			     + "&code_param="+sheetObj.GetCellValue(row, "trd_cd")+"|"
	            			     				+f_bse_tp_cd+"|"
	            			     				+f_bse_yr+"|"
	            			     				+f_bse_qtr_cd+"|"
	            			     				+"|"
	        		     						+sector_include
	            			     + "&all_flag=";
	            				
	            				var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	            				var arrXml=xmlStr.split("|$$|");
//		                   		ComCsqSetIBCombo(sheetObj, xmlStr, "rlane_cd", true);	
//		                   		sheetObj.CellComboItem(row,"rlane_cd", {ComboText:"", ComboCode:""} );
		                   		
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
	            			
	        	    		if(sheetObj.GetCellValue(row, 'ibflag') == 'I'){
	        	    			var trdCd = sheetObj.GetCellValue(row, 'trd_cd');
	        		    		sheetObj.SetCellValue(row+1, 'trd_cd', trdCd, 0);
	        	    		}
	            			
	                		break;  
	            		case "rlane_cd":
	            			var text=getSheetComboCode(sheetObj, row, col);
	            			sheetObj.SetCellValue(row, col,text,0);
	            			
	        	    		if(sheetObj.GetCellValue(row, 'ibflag') == 'I'){
	        		    		var rlaneCd = sheetObj.GetCellValue(row, 'rlane_cd');
	        		    		sheetObj.SetCellValue(row+1, 'rlane_cd', rlaneCd, 0);
	        	    		}
	            			break;
	            			
	            		case "dir_cd":
	            			var text=getSheetComboCode(sheetObj, row, col);
	            			sheetObj.SetCellValue(row, col,text,0);
	            			
	            			if(sheetObj.GetCellValue(row, 'ibflag') == 'I'){
	        		    		var dirCd = sheetObj.GetCellValue(row, 'dir_cd');
	        		    		if(dirCd == 'E'){
	        		    			sheetObj.SetCellValue(row, 'conv_dir_cd', 'W', 0);
	        		    			sheetObj.SetCellValue(row+1, 'dir_cd', 'W', 0);
	        		    			sheetObj.SetCellValue(row+1, 'conv_dir_cd', 'E', 0);
	        		    		}else if(dirCd == 'W'){
	        		    			sheetObj.SetCellValue(row, 'conv_dir_cd', 'E', 0);
	        		    			sheetObj.SetCellValue(row+1, 'dir_cd', 'E', 0);
	        		    			sheetObj.SetCellValue(row+1, 'conv_dir_cd', 'W', 0);
	        		    		}if(dirCd == 'S'){
	        		    			sheetObj.SetCellValue(row, 'conv_dir_cd', 'N', 0);
	        		    			sheetObj.SetCellValue(row+1, 'dir_cd', 'N', 0);
	        		    			sheetObj.SetCellValue(row+1, 'conv_dir_cd', 'S', 0);
	        		    		}if(dirCd == 'N'){
	        		    			sheetObj.SetCellValue(row, 'conv_dir_cd', 'S', 0);
	        		    			sheetObj.SetCellValue(row+1, 'dir_cd', 'S', 0);
	        		    			sheetObj.SetCellValue(row+1, 'conv_dir_cd', 'N', 0);
	        		    		}
	        	    		}
	            			break;
	            			
	            		case "conv_dir_cd":
	            			var text=getSheetComboCode(sheetObj, row, col);
	            			sheetObj.SetCellValue(row, col,text,0);
	            			break;
	            			
	            		case "delete":
	        	    		//Yongseup Kim - a logic to delete related rows as a pair
	        	    		if(sheetObj.GetCellValue(row, 'ibflag') == 'D'){
	        	    			var trdCd = sheetObj.GetCellValue(row, 'trd_cd');
	        	    			var rlaneCd = sheetObj.GetCellValue(row, 'rlane_cd');
	        	    			var dirCd = sheetObj.GetCellValue(row, 'dir_cd');
	        	    			
	        	    			for(i=1; i<=sheetObj.LastRow(); i++){
	        	    					if( sheetObj.GetCellValue(i, 'trd_cd') == sheetObj.GetCellValue(row, 'trd_cd') && 
	        	    						sheetObj.GetCellValue(i, 'rlane_cd') == sheetObj.GetCellValue(row, 'rlane_cd') ){
	        	    						if(dirCd == 'E' &&
	        	    						   sheetObj.GetCellValue(i, 'dir_cd') == 'W' &&
	        	    						   sheetObj.GetCellValue(i, 'conv_dir_cd') == 'E' ){
	        	    			    			sheetObj.SetCellValue(i, 'ibflag', 'D', 0);
	        	    			    		}else if(dirCd == 'W' &&
	        	 	    						   sheetObj.GetCellValue(i, 'dir_cd') == 'E' &&
	        		    						   sheetObj.GetCellValue(i, 'conv_dir_cd') == 'W' ){
	        		    			    			sheetObj.SetCellValue(i, 'ibflag', 'D', 0);
	        	    			    		}else if(dirCd == 'S' &&
	        		 	    						   sheetObj.GetCellValue(i, 'dir_cd') == 'N' &&
	        			    						   sheetObj.GetCellValue(i, 'conv_dir_cd') == 'S' ){
	        			    			    			sheetObj.SetCellValue(i, 'ibflag', 'D', 0);
	        	    			    		}else if(dirCd == 'N' &&
	        		 	    						   sheetObj.GetCellValue(i, 'dir_cd') == 'S' &&
	        			    						   sheetObj.GetCellValue(i, 'conv_dir_cd') == 'N' ){
	        			    			    			sheetObj.SetCellValue(i, 'ibflag', 'D', 0);
	        	    			    		}
	        	    			    		
	        	    					}
	        	    					
	        	    			} // the end of the for loop
	        	    		}
	        	    		
	        	    		//Yongseup Kim - a logic to inactivate delete flag of rows as a pair
	        	    		if(sheetObj.GetCellValue(row, 'ibflag') == 'R'){
	        	    			var trdCd = sheetObj.GetCellValue(row, 'trd_cd');
	        	    			var rlaneCd = sheetObj.GetCellValue(row, 'rlane_cd');
	        	    			var dirCd = sheetObj.GetCellValue(row, 'dir_cd');
	        	    			
	        	    			for(i=1; i<=sheetObj.LastRow(); i++){
	        	    					if( sheetObj.GetCellValue(i, 'trd_cd') == sheetObj.GetCellValue(row, 'trd_cd') && 
	        	    						sheetObj.GetCellValue(i, 'rlane_cd') == sheetObj.GetCellValue(row, 'rlane_cd') ){
	        	    						if(dirCd == 'E' &&
	        	    						   sheetObj.GetCellValue(i, 'dir_cd') == 'W' &&
	        	    						   sheetObj.GetCellValue(i, 'conv_dir_cd') == 'E' ){
	        	    			    			sheetObj.SetCellValue(i, 'ibflag', 'R', 0);
	        	    			    		}else if(dirCd == 'W' &&
	        	 	    						   sheetObj.GetCellValue(i, 'dir_cd') == 'E' &&
	        		    						   sheetObj.GetCellValue(i, 'conv_dir_cd') == 'W' ){
	        		    			    			sheetObj.SetCellValue(i, 'ibflag', 'R', 0);
	        	    			    		}else if(dirCd == 'S' &&
	        		 	    						   sheetObj.GetCellValue(i, 'dir_cd') == 'N' &&
	        			    						   sheetObj.GetCellValue(i, 'conv_dir_cd') == 'S' ){
	        			    			    			sheetObj.SetCellValue(i, 'ibflag', 'R', 0);
	        	    			    		}else if(dirCd == 'N' &&
	        		 	    						   sheetObj.GetCellValue(i, 'dir_cd') == 'S' &&
	        			    						   sheetObj.GetCellValue(i, 'conv_dir_cd') == 'N' ){
	        			    			    			sheetObj.SetCellValue(i, 'ibflag', 'R', 0);
	        	    			    		}
	        	    			    		
	        	    					}
	        	    					
	        	    			} // the end of the for loop
	        	    		}
	        	    		break;
	        	    		
	    			}
	    		}
	    	}
		/**
		 * 화면의 모든 버튼들의 Enable/Disable을 처리
		 */
	   function toggleButtons(step) {
	       switch (step) {
	       case "INIT":
	           ComBtnEnable("btn_Retrieve");
	           ComBtnDisable("btn_Save");
	           ComBtnDisable("btn_Copy");
	           ComBtnDisable("btn_Downexcel");
	           ComBtnDisable("btn_RowAdd");
	           break;
	       case "SEARCH":
	    	   ComBtnEnable("btn_Retrieve");
	    	   ComBtnEnable("btn_Save");
	    	   ComBtnDisable("btn_Copy");
	    	   ComBtnEnable("btn_Downexcel");
	    	   ComBtnEnable("btn_RowAdd");
	           break;
	       case "COPY":
	    	   ComBtnEnable("btn_Retrieve");
	    	   ComBtnDisable("btn_Save");
	    	   ComBtnEnable("btn_Copy");
	    	   ComBtnDisable("btn_Downexcel");
	    	   ComBtnDisable("btn_RowAdd");
	           break;
	       }
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
	   	setTradeCombo();
	   }
	   /**
	    * f_bse_yr가 바뀌었을때 period 의 year 변경
	    */
	   function f_bse_yr_OnChange(obj, value, text) {
	   	period_change();
	   	setTradeCombo();
	   }
	   /**
	    * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
	    */
	   function f_bse_qtr_cd_OnChange(obj, value, text) {
	   	period_change();
	   	setTradeCombo();
	   }
	   
	   function resizeSheet(){
	        ComResizeSheet(sheetObjects[0]);
	   }
	/* 개발자 작업  끝 */
