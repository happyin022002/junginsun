/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1047.js
*@FileTitle  : MTY Balance Repo Out
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var headCount=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt=0;
        var sheetObject=sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
                case "btn_RowAdd":
                	sheetObjects[0].DataInsert(-1);
                	for ( var j=0; j<headCount; j++ ) {
 	    			   if(sheetObjects[0].ColSaveName(j).substring(3) == "fcast_qty"){
 	    				   sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), j,0,0);
 	    			   }
 	    		    }
                	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "total",0,0);
                	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "inp_yrwk",formObject.inp_yrwk.value,0);
                	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "fcast_yrwk",formObject.fcast_yrwk.value,0);
                	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "loc_grp_cd",formObject.loc_grp_cd.value,0);
                	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "loc_cd",formObject.loc_cd.value,0);
                	setTotalForm();
                    break;
                case "btn_Delete":
                	if(sheetObjects[0].FindCheckedRow("Seq") != ""){
    					ComRowHideDelete(sheetObjects[0],"Seq"); 
    				}
                	setTotalForm();
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
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
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        if(document.form.save_option.value == "0"){
  		   ComBtnEnable("btn_save");
  		   ComBtnEnable("btn_RowAdd");
		   ComBtnEnable("btn_Delete");
		   sheetObjects[0].SetEditable(1);
  	   }else{
  		   ComBtnDisable("btn_save");
  		   ComBtnDisable("btn_RowAdd");
		   ComBtnDisable("btn_Delete");
		   sheetObjects[0].SetEditable(0);
  	   }
	   setHiddenCol(sheetObjects[0], document.form.tpsz_flag.value); // column 히든
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
		             var HeadTitle1="Seq.|Trans Mode|Lane|VVD|From|From|To|To|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|TP/SZ|Remark||||||";
		             var HeadTitle2="Seq.|Trans Mode|Lane|VVD|LOC|ETD|LOC|ETB/ETA|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|Remark||||||";
		             headCount=ComCountHeadTitle(HeadTitle1);
		
		             SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1} );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"},
		                       { Text:HeadTitle2, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",           KeyField:0,   CalcLogic:"",   Format:"" },
		                 {Type:"Combo",     Hidden:0, Width:73,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:0,   InsertEdit:1, ComboText:trspModCdText, ComboCode:trspModCdCode},
		                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_cd",   KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"", UpdateEdit:0,   InsertEdit:1,   EditLen:9, InputCaseSensitive:1, AcceptKeys:"E|N|[-~[]{}_|*&^%$#@!]"},
		                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_yd_cd",      KeyField:1,   CalcLogic:"",   Format:"", UpdateEdit:0,   InsertEdit:1, ComboText:"", ComboCode:""},
		                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_etd_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd", UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_yd_cd",      KeyField:1,   CalcLogic:"",   Format:"", UpdateEdit:0,   InsertEdit:1, ComboText:"", ComboCode:""},
		                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_etb_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd", UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"d2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"d4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"d5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"d7_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"r2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"r5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"r9_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"o2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"s2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"o4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"s4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"f2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"a2_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"f4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"a4_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"f5_fcast_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"repo_out_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"inp_yrwk",      KeyField:0,   CalcLogic:"",   Format:"" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"fcast_yrwk",    KeyField:0,   CalcLogic:"",   Format:"" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_grp_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cre_seq",       KeyField:0,   CalcLogic:"",   Format:"" },
		                 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		     
		             var trspModCdTextArr=trspModCdText.split("|");
		             var trspModCdCodeArr=trspModCdCode.split("|");
		             trspModCdText=trspModCdTextArr[1];
		             trspModCdCode=trspModCdCodeArr[1];
		             for(var i = 2; i < trspModCdCodeArr.length; i++){
			             trspModCdText += "|"+trspModCdTextArr[i];
			             trspModCdCode += "|"+trspModCdCodeArr[i];
		             }
		             InitColumns(cols);
		             SetWaitImageVisible(0);
		             SetKeyFieldImage("/opuscntr/js/ibsheet/Main/keyfield.png");
		             SetCountPosition(0);//페이지카운트없애기
		             SetSheetHeight(522);
        		}
                break;
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //조회
            	ComOpenWait(true); 
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("EES_EQR_1047GS.do",FormQueryString(formObj) );
                break;
            case IBDOWNEXCEL:      // 엑셀 다운
        		if(sheetObj.RowCount()>0){
        			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
    			}else{
    				ComShowCodeMessage("EQR01104");
    			}
             	break;
            case IBSAVE:      //저장
            	if(validateForm(sheetObj,formObj,sAction)){
		        	ComOpenWait(true); 
		            formObj.f_cmd.value=MULTI;
		            sheetObj.DoSave("EES_EQR_1047GS.do",FormQueryString(formObj),"ibflag");
            	}
	            break;
        }
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
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
     function sheet1_OnSearchEnd(sheetObj, code, msg){
    	 ComOpenWait(false);
    //no support[implemented common]CLT 	 sheetObj.SelectHighLight=false;
//    	 sheetObj.Redraw = true;
    	 setTotalForm();
     }
     /**
      * 셀을 클릭했을때 발생하는 이벤트 <br>
      * 선택시 선택행 배경색 세팅
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      	if ( row == sheetObj.LastRow()) {
          //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
      		sheetObj.SetRowBackColor(row,-1);
      	} else {
          //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
      		if (sheetObj.GetCellValue(row, "trsp_mod_cd") == "V") {
				//row, col, 타입, 너비, 정렬, 머지여부, 이름, 필수입력, 계산, 
      			sheetObj.SetColProperty(0, "fm_yd_cd",  {KeyField:0});
      			sheetObj.SetColProperty(0, "fm_etd_dt", {KeyField:0});
      			sheetObj.SetColProperty(0, "to_yd_cd",  {KeyField:0});
      			sheetObj.SetColProperty(0, "to_etb_dt", {KeyField:0});
		   }else{
			    sheetObj.SetColProperty(0, "fm_yd_cd",  {KeyField:0, EditLen:7, InputCaseSensitive:1, AcceptKeys:"E|N|[-~[]{}_|*&^%$#@!]"});
     			sheetObj.SetColProperty(0, "fm_etd_dt", {KeyField:0, InsertEdit:1});
     			sheetObj.SetColProperty(0, "to_yd_cd",  {KeyField:0, EditLen:7, InputCaseSensitive:1, AcceptKeys:"E|N|[-~[]{}_|*&^%$#@!]"});
     			sheetObj.SetColProperty(0, "to_etb_dt", {KeyField:0, InsertEdit:1});
           }
      		if(sheetObj.GetCellValue(row, "trsp_mod_cd") == "O"){ // other 선택한 경우 mandantory 이미지 해제
		      sheetObjects[0].SetKeyFieldImage("/opuscntr/img/blank.gif");
		   }else{
		      sheetObjects[0].SetKeyFieldImage("/opuscntr/js/ibsheet/Main/keyfield.png");
		   }
      	}
     }
      /**
       * 셀에 키입력 했을때 발생하는 이벤트 <br>
       * @param {ibsheet} sheetObj    IBSheet Object
       * @param {ibsheet} row     	sheetObj의 선택된 Row
       * @param {ibsheet} col     	sheetObj의 선택된 Col
       **/
      function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	   var formObj=document.form;
    	   with(sheetObj){
    		   if(ColSaveName(Col).substring(3) == "fcast_qty"){
	    		   var rowTotal=0;
	    		   for ( var j=0; j<headCount; j++ ) {
	    			   if(ColSaveName(j).substring(3) == "fcast_qty"){
	    				   rowTotal += parseInt(GetCellValue(Row, j));
	    			   }
	    		   }
	    		   SetCellValue(Row, "total",rowTotal,0);
	    	   }
    		   switch (ColSaveName(Col)) {
    		   case "vvd":
    			   if(GetCellValue(Row, "trsp_mod_cd") == "V"){
    				   if(Value.length != 9){
	     					ComShowCodeMessage("EQR90078","9");
	     					SelectCell(Row, Col);
	     				}else{	//VVD로 lane 조회 및 from, to yard combo list 만들기
		                	ComOpenWait(true); 
		                    formObj.f_cmd.value=SEARCH01;
 		                    var sXml=GetSearchData("EES_EQR_1047GS.do",FormQueryString(formObj)+"&vvd="+Value);
		                    var arrXml=sXml.split("|$$|");
		                    var slnaCd=ComGetEtcData(arrXml[0], "slan_cd");
		                    if(slnaCd != ""){
			                    SetCellValue(Row, "vsl_lane_cd",slnaCd,0);
			                    var frYdCdArr=ComXml2ComboString(arrXml[0], "fm_yd_cd", "fm_etd_dt");
			                    var toYdCdArr=ComXml2ComboString(arrXml[1], "to_yd_cd", "to_etb_dt");
								if(ComGetTotalRows(arrXml[0]) > 0){
									CellComboItem(Row,"fm_yd_cd", {ComboText:"|"+frYdCdArr[0], ComboCode:"|"+frYdCdArr[1]} );
									SetCellValue(Row, "fm_yd_cd","",0);
									SetCellValue(Row, "fm_etd_dt","",0);
								}
//								if(ComGetTotalRows(arrXml[1]) > 0){
//									CellComboItem(Row, "to_yd_cd", "|"+toYdCdArr[0], "|"+toYdCdArr[1]);
//									CellValue2(Row, "to_yd_cd") = "";
//									CellValue2(Row, "to_etb_dt") = "";
//								}
			                    ComOpenWait(false);
		                    }else{
		                    	ComOpenWait(false);
		                    	ComShowCodeMessage("EQR90001","accurate vvd code");
		                    	SelectCell(Row, Col);
		                    }
	     				}
    			   }
    			   break;
    		   case "fm_yd_cd":
    			   if(GetCellValue(Row, "trsp_mod_cd") == "V"){
    				   if(Value.length > 7){
		                   ComOpenWait(true); 
    					   var frYdDt=Value.split("%%");
	    				   SetCellValue(Row, "fm_yd_cd",frYdDt[1],0);
	    				   SetCellValue(Row, "fm_etd_dt",frYdDt[0],0);
		                   formObj.f_cmd.value=SEARCH01;
		                   var sXml=GetSearchData("EES_EQR_1047GS.do",FormQueryString(formObj)+"&vvd="+GetCellValue(Row, "vvd")+"&fm_etd_dt="+GetCellValue(Row, "fm_etd_dt"));
		                   var arrXml=sXml.split("|$$|");
			               var toYdCdArr=ComXml2ComboString(arrXml[1], "to_yd_cd", "to_etb_dt");
			               if(ComGetTotalRows(arrXml[1]) > 0){
			            	   CellComboItem(Row,"to_yd_cd", {ComboText:"|"+toYdCdArr[0], ComboCode:"|"+toYdCdArr[1]} );
								SetCellValue(Row, "to_yd_cd","",0);
								SetCellValue(Row, "to_etb_dt","",0);
							}
			                ComOpenWait(false);
    				   }
    			   }else{
    				   if(Value.length == 7){
	    				   ComOpenWait(true); 
	    				   formObj.f_cmd.value=SEARCH02;
 	    				   var sXml=GetSearchData("EES_EQR_1047GS.do",FormQueryString(formObj)+"&fm_yd_cd="+Value);
	    				   var ydCd=ComGetEtcData(sXml, "yd_cd");
	    				   if(ydCd == "" || ydCd == null){
	    					   ComOpenWait(false);
	    					   ComShowCodeMessage("EQR90206");
	    					   SetCellValue(Row, "fm_yd_cd","",0);
	    					   SelectCell(Row, Col);
	    				   }
	    				   ComOpenWait(false); 
    				   }else if(Value.length > 4){
    					   var colName=ColSaveName(Col);
    					   formObj.f_cmd.value=SEARCH02;
 	    				   var sXml=GetSearchData("EES_EQR_1047GS.do",FormQueryString(formObj)+"&fm_yd_cd="+Value);
	    				   var ydCd=ComGetEtcData(sXml, "yd_cd");
	    				   if(ydCd == "" || ydCd == null){
	    					   ComOpenWait(false);
	    					   ComShowCodeMessage("EQR90203");
	    					   SetCellValue(Row, "fm_yd_cd","",0);
	    					   SelectCell(Row, Col);
	    				   }else{
	    					   if(sheetObj.GetCellValue(Row,"trsp_mod_cd")=="W") {  // ITEM -> WATER 은   SEARCHLIST20
	    						   var f_cmd=SEARCHLIST20;
	    						   	DoRowSearch(ROW, "row=Row&searchword=Value&colname=colName&f_cmd=f_cmd");
	               		    	    //sheetObj.CellValue2(row, colName) = searchword;
	               			        SetCellValue(Row, colName,"",0);
	       			    	    }else { // ITEM -> TRUCK, RAIL 은   SEARCHLIST05
	               	     		    var f_cmd=SEARCHLIST05;
	               	     		    DoRowSearch(ROW, "row=Row&searchword=Value&colname=colName&f_cmd=f_cmd");
	                   			    //sheetObj.CellValue2(row, colName) = searchword;
	                   			    SetCellValue(Row, colName,"",0);
	       		    		    }
	    				   }
    				   }
    			   }
    			   break;
     			case "to_yd_cd":
     				if(GetCellValue(Row, "trsp_mod_cd") == "V"){
     					if(Value.length > 7){
     						var toYdDt=Value.split("%%");
     						SetCellValue(Row, "to_yd_cd",toYdDt[1],0);
    	     				SetCellValue(Row, "to_etb_dt",toYdDt[0],0);
     					}
     				}else{
     					if(Value.length == 7){
	     					ComOpenWait(true); 
	     					formObj.f_cmd.value=SEARCH02;
	     					var sXml=GetSearchData("EES_EQR_1047GS.do",FormQueryString(formObj)+"&to_yd_cd="+Value);
	     					var ydCd=ComGetEtcData(sXml, "yd_cd");
	     					if(ydCd == "" || ydCd == null){
	     						ComOpenWait(false);
	 	                    	ComShowCodeMessage("EQR90206");
	 	                    	SetCellValue(Row, "to_yd_cd","",0);
	 	                    	SelectCell(Row, Col);
	     				    }
	     					ComOpenWait(false);
     					}else if(Value.length > 4){
    					   var colName=ColSaveName(Col);
    					   formObj.f_cmd.value=SEARCH02;
	    				   var sXml=GetSearchData("EES_EQR_1047GS.do",FormQueryString(formObj)+"&to_yd_cd="+Value);
	    				   var ydCd=ComGetEtcData(sXml, "yd_cd");
	    				   if(ydCd == "" || ydCd == null){
	    					   ComOpenWait(false);
	    					   ComShowCodeMessage("EQR90203");
	    					   SetCellValue(Row, "fm_yd_cd","",0);
	    					   SelectCell(Row, Col);
	    				   }else{
	    					   if(sheetObj.GetCellValue(Row,"trsp_mod_cd")=="W") {  // ITEM -> WATER 은   SEARCHLIST20
	               	    		    var f_cmd=SEARCHLIST20;
	               	    		    DoRowSearch( ROW, "row=Row&searchword=Value&colname=colName&f_cmd=f_cmd");
	               		    	    //sheetObj.CellValue2(row, colName) = searchword;
	               			        SetCellValue(Row, colName,"",0);
	       			    	    }else { // ITEM -> TRUCK, RAIL 은   SEARCHLIST05
	               	     		    var f_cmd=SEARCHLIST05;
	               	     		    DoRowSearch( ROW, "row=Row&searchword=Value&colname=colName&f_cmd=f_cmd");
	                   			    //sheetObj.CellValue2(row, colName) = searchword;
	                   			    SetCellValue(Row, colName,"",0);
	       		    		    }
	    				   }
    				   }
     				}
        			break;
     			case "trsp_mod_cd" :
     				SetCellValue(Row, "vvd","",0);
     				SetCellValue(Row, "fm_yd_cd","",0);
     				SetCellValue(Row, "to_yd_cd","",0);
     				SetCellValue(Row, "fm_etd_dt","",0);
     				SetCellValue(Row, "to_etb_dt","",0);
     				if(sheetObj.GetCellValue(Row, "trsp_mod_cd") == "O"){ // other 선택한 경우 mandantory 이미지 해제
		               sheetObjects[0].SetKeyFieldImage("/opuscntr/img/blank.gif");
		            }else{
		               sheetObjects[0].SetKeyFieldImage("/opuscntr/js/ibsheet/Main/keyfield.png");
		            }
     				break;
    		   }
    	   }
    	   setTotalForm();
      }
    /**
    * Row add 시 
    */	
  	function setTotalForm() {
  		var sheetObj=sheetObjects[0];
		sheetObj.SetCellFont("FontBold", sheetObj.LastRow(),"",1);
		sheetObj.SetCellFont("FontBold", sheetObj.LastRow(),"vsl_lane_cd",1);
		sheetObj.SetCellFont("FontBold", sheetObj.LastRow(),"vvd",1);
		sheetObj.SetCellFont("FontBold", sheetObj.LastRow(),"total",1);
		for ( var j=1; j<=15; j++ ) {
			sheetObj.SetCellFont("FontBold", sheetObj.LastRow(),8+j,1);
		}
		sheetObj.SetCellValue(sheetObj.LastRow(),"Seq",'MTY Repo. Out Total',0);
		sheetObj.SetCellAlign(sheetObj.LastRow(),"Seq","Center");
		sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 8);
 		sheetObj.SetSumBackColor("#D3EBED");
		sheetObj.SetSumFontBold(1);
		if ( sheetObj.GetCellValue(i,"total") > 0 ) {
 			sheetObj.SetCellFontColor(i,"total","#0000FF");
		}
		if ( sheetObj.GetCellValue(i,"total") < 0 ) {
 			sheetObj.SetCellFontColor(i,"total","#FF0000");
		}
		if ( sheetObj.GetCellValue(sheetObj.LastRow(),"total") > 0 ) {
			sheetObj.SetCellFontColor(sheetObj.LastRow(),"total","#0000FF");
		}
		if ( sheetObj.GetCellValue(sheetObj.LastRow(),"total") < 0 ) {
			sheetObj.SetCellFontColor(sheetObj.LastRow(),"total","#FF0000");
		}
		for ( var j=1; j<=15; j++ ) {
			if ( sheetObj.GetCellValue(sheetObj.LastRow(),8+j) > 0 ) {
 				sheetObj.SetCellFontColor(sheetObj.LastRow(),8+j,"#0000FF");
			}
			if ( sheetObj.GetCellValue(sheetObj.LastRow(),8+j) < 0 ) {
 				sheetObj.SetCellFontColor(sheetObj.LastRow(),8+j,"#FF0000");
			}
		} 
 		sheetObj.SetRowBackColor(sheetObj.LastRow(),"#D3EBED");
  	}
    /**
    * 저장 완료시 처리
    */
   function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
	    ComOpenWait(false);
		save_flag=true;
		if ( ErrMsg == "" ) {
			if ( save_flag ) { 
		    	var opener_obj=window.dialogArguments;
				//opener_obj.popupEditFlg = "Y";
		    	for ( var j=9; j<=24; j++ ) {
	    			if ( sheetObjects[0].rowCount > 0 ) {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),sheetObjects[0].ColSaveName(j)));
	    			} else {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), 0);
	    			}
	            }
                opener_obj.calcBalance(); //EES_EQR_1001 재계산
                opener_obj.calcAllTotal();
			}
			ComShowCodeMessage("EQR01001");
		}
   }
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(sheetObj){
			switch (sAction) {
  			case IBSAVE:
  				for(var i=0; i <= LastRow(); i++){
  					if((GetRowStatus(i) == "I" || GetRowStatus(i) == "U") && GetCellValue(i, "trsp_mod_cd") == "V" && (GetCellValue(i, "vvd") == "" || GetCellValue(i, "vvd") == null)){
  						ComShowCodeMessage("COM130403", "VVD"); // 'Mandatory field is missing. Please enter {?msg1}.'
  						SelectCell(i, "vvd");
  						return false;
  					}
  					if((GetRowStatus(i) == "I" || GetRowStatus(i) == "U") && GetCellValue(i, "trsp_mod_cd") != "O"
  						&& (GetCellValue(i, "fm_yd_cd") == "" || GetCellValue(i, "fm_yd_cd") == null)){
                        ComShowCodeMessage("COM130403", "From LOC"); // 'Mandatory field is missing. Please enter {?msg1}.'
                        SelectCell(i, "fm_yd_cd");
                        return false;
                    }  
  					if((GetRowStatus(i) == "I" || GetRowStatus(i) == "U") && GetCellValue(i, "trsp_mod_cd") != "O"
  						&& (GetCellValue(i, "fm_etd_dt") == "" || GetCellValue(i, "fm_etd_dt") == null)){
                        ComShowCodeMessage("COM130403", "From ETD"); // 'Mandatory field is missing. Please enter {?msg1}.'
                        SelectCell(i, "fm_etd_dt");
                        return false;
                    }  
  					if((GetRowStatus(i) == "I" || GetRowStatus(i) == "U") && GetCellValue(i, "trsp_mod_cd") != "O"
  						&& (GetCellValue(i, "to_yd_cd") == "" || GetCellValue(i, "to_yd_cd") == null)){
                        ComShowCodeMessage("COM130403", "To LOC"); // 'Mandatory field is missing. Please enter {?msg1}.'
                        SelectCell(i, "to_yd_cd");
                        return false;
                    }  
					if((GetRowStatus(i) == "I" || GetRowStatus(i) == "U") && GetCellValue(i, "trsp_mod_cd") != "O"
					&& (GetCellValue(i, "fm_yd_cd") == "" || GetCellValue(i, "to_etb_dt") == null)){
                        ComShowCodeMessage("COM130403", "To ETB/ETA"); // 'Mandatory field is missing. Please enter {?msg1}.'
                        SelectCell(i, "to_etb_dt");
                        return false;
                    }   
  				}
  				break;
			}
	    }
	    return true;
	}
	function setHiddenCol(sheetObj, tpszStr){
		if(tpszStr != ""){
			var arr_tpsz=tpszStr.split(",");
			var consTpszArr="D2,D4,D5,D7,R2,R5,R9,O2,S2,O4,S4,F2,A2,F4,A4,F5".split(",");//전체의 Container Type/Size
			for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size     
	            for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
	                if(consTpszArr[i] == arr_tpsz[j]){
	                    sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_fcast_qty",0);
	                    break;
	                }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
	                    sheetObj.SetColHidden(consTpszArr[i].toLowerCase()+"_fcast_qty",1);
	                }
	            }
	        }
		}
	}
