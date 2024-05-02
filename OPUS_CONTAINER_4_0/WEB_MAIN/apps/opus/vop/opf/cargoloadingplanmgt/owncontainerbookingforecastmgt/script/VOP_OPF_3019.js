/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_3019.jsp
*@FileTitle  : Weight Group (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    //Weight Group 코드 임시 저장
    var comboValue="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1=sheetObjects[0];
	         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form; 
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
      		var prefix="sheet1_";
            switch(srcName) {
            	case "slan_cd_pop":
            		var slan_cd=formObject.slan_cd.value;
            		ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 500, 480, "setSlanCd", "0,0", true);
            		break;
            	case "pol_cd_pop":
            		var port_cd=formObject.pol_cd.value;
            		ComOpenPopup("VOP_VSK_0043.do?port_cd="+port_cd, 500, 550, "setPolCd", "0,0", true);
            		break;
				case "btn_RowAdd":
					if((sheetObject1.RowCount() - sheetObject1.RowCount("D")) == 5) return;
					var new_seq=ComParseInt(sheetObject1.GetCellValue(sheetObject1.LastRow(), prefix+"cntr_wgt_grp_seq"))+1;
					var from1_ton="";
					var from3_ton="";
					var row=sheetObject1.DataInsert(-1);
					sheetObject1.SetCellText(row, prefix+"slan_cd" ,formObject.slan_cd.value);
					sheetObject1.SetCellText(row, prefix+"skd_dir_cd" ,formObject.skd_dir_cd.value);
					sheetObject1.SetCellText(row, prefix+"pol_cd" ,formObject.pol_cd.value);
					setCntr_wgt_grp_seq();
					setCntr_wgt_grp_cd(row);
					break;
				case "btn_RowCopy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					break;
				case "btn_RowDelete":
					var delChkFlg=ComRowHideDelete(sheetObject1,"sheet1_del_chk");
					setCntr_wgt_grp_seq();
					break;
				case "btn_Retrieve":
					if(!ComChkValid(formObject)) {
						return false;
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_Save":
					if(!validateForm(sheetObject1,formObject)) {
						return false;
					}
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_Close":
					ComClosePopup(); 
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
    //No. 순서 및 From To 정렬 시킴.
    function setCntr_wgt_grp_seq(){
    	var seq=1;
    	var prefix="sheet1_";
    	var nextRow=0;
		for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++){
			if(sheetObjects[0].GetRowStatus(i) != "D"){
				sheetObjects[0].SetCellValue(i, prefix+"cntr_wgt_grp_seq",seq);
				seq++;
				for(var j=i+1 ; j<=sheetObjects[0].LastRow(); j++){
					if(sheetObjects[0].GetRowStatus(j) != "D")
					{
						nextRow=j;
						j=j+sheetObjects[0].LastRow();
						continue;
					}
				}
				//i 맨 마지막 Row는 적용하사지 않음.
				if(  i != sheetObjects[0].HeaderRows() && i != nextRow){
					sheetObjects[0].SetCellValue(nextRow, prefix+"cntr_lmt_wgt2",sheetObjects[0].GetCellText(i, prefix+"cntr_lmt_wgt1"));
					sheetObjects[0].SetCellValue(nextRow, prefix+"cntr_lmt_wgt4",sheetObjects[0].GetCellText(i, prefix+"cntr_lmt_wgt3"));
				}
			}
		}
    }
    function setCntr_wgt_grp_cd(row) {
    	var sheetObj=sheetObjects[0];
    	var prefix="sheet1_";
    	var rowCnt = sheetObj.RowCount() - sheetObj.RowCount("D");
    	var rowValue="";
    	if(rowCnt == 1){
    		rowValue="X";
    	} else {
    		var bfRowIdx=row - 1;
    		for(var i=bfRowIdx ; i>0 ; i--){
    			if(sheetObj.GetRowStatus(i) == "D"){
        			bfRowIdx=bfRowIdx - 1;
        		}else{
        			break;
        		}
    		}
    		var bfRowValue=sheetObj.GetCellValue(bfRowIdx, prefix+"cntr_wgt_grp_cd");
    		switch (bfRowValue) {
    		case "X":
    			rowValue="H";
    			break;
    		case "H":
    			rowValue="M";
    			break;
    		case "M":
    			rowValue="L";
    			break;
    		case "L":
    			rowValue="E";
    			break;
    		}
    	}
    	
    	sheetObj.SetCellText(row, prefix+"cntr_wgt_grp_cd" ,rowValue);
    	if(rowValue != ""){
    		getComboText(sheetObj, row, prefix+"cntr_wgt_grp_cd", rowValue, "");
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
    	var formObject=document.form;
    	for(var x=0; x<formObject.skd_dir_cd.length; x++){
    		if(formObject.skd_dir_cd[x].value == formObject.sel_skd_dir_cd.value){
    			formObject.skd_dir_cd[x].selected=true;
    		}
    	}    	
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			//ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();
		
		sheet1_OnLoadFinish(sheetObjects[0])
		
		//Lane Name		
		slan_cd_change();
		
	}
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl(){
    	axon_event.addListener  ('keypress', 'eng_keypress' , 'slan_cd'
    			                                            , 'pol_cd');
    	axon_event.addListener  ('change'  , 'slan_cd_change', 'slan_cd');			//Lane Code 입력 후 Validation Check & Lane Description 정보 가져오기
    	axon_event.addListener  ('change'  , 'pol_cd_change', 'pol_cd');			//POL Code 입력 후 Validation Check.
    	axon_event.addListener  ('focus'  , 'focus_event', 'slan_cd'
    			                                         , 'pol_cd');
    	// Enter Key Search.
       axon_event.addListener ('keydown', 'ComKeyEnter', 'slan_cd'
        												, 'skd_dir_cd'
        												, 'pol_cd');
    }
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
    	 ComKeyOnlyAlphabet('uppernum');
    }
    /**
	 * Slan Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
    function setSlanCd(aryPopupData){
		form.slan_cd.value=aryPopupData[0][1];
		form.slan_cd_desc.value=aryPopupData[0][2];
    }
    /**
	 * Pol Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
    function setPolCd(aryPopupData){
//		form.pol_cd.value=aryPopupData[0][2];
    	form.pol_cd.value=aryPopupData;
    }
    /**
     * Slan Code 변경 시 해당 Name 을 가져온다. <br>
     **/
    function slan_cd_change() {
    	document.form.slan_cd_desc.value="";
    	var slanCdObj=document.form.slan_cd;
    	if(slanCdObj.value != null && slanCdObj.value !=""){
    		if(slanCdObj.value.length != slanCdObj.maxLength){
    			ComShowCodeMessage("OPF50007", "Lane", slanCdObj.maxLength);
    			slanCdObj.focus();
    			return false;
    		}
    		else if(!isTrue(doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, "SlanCd"))){
    			return false;
    		}
    	}
    }
    /**
     * Pol Code 변경 시 해당 Name 을 가져온다. <br>
     **/
    function pol_cd_change() {
    	var polCdObj=document.form.pol_cd;
    	if(polCdObj.value!=null && polCdObj.value!="" ){
    		if(polCdObj.value.length != polCdObj.maxLength){
    			ComShowCodeMessage("OPF50007", "POL", polCdObj.maxLength);
    			polCdObj.focus();
    			return false;
    		}
    		else if(!isTrue(doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, "PolCd"))){
    			return false;
    		}
    	}
    }
     /**
      * 입력된 값의 True/False 여부 리턴.
      */
     function isTrue(strValue)
     {
     	if(strValue+""=="false"){
     		return false;
     	}
     	else{
     		return true;
     	}
     }
    function focus_event(){
    	var elementObj=event.srcElement;
    	elementObj.select();
    }
    /**
     * Search 조건 데이터값 초기화<br>
     */
    function dataClear(){
    	document.form.slan_cd.value="";
    	document.form.slan_cd_desc.value="";
    	document.form.skd_dir_cd.value="E";
    	document.form.pol_cd.value="";
    	//ComBtnEnable("rpr_seq_delete");
    	ComBtnDisable("btn_RowAdd");
    	ComBtnDisable("btn_RowDelete");
    }
      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		var sheetID=sheetObj.id;
            switch(sheetID) {
                case "sheet1":
                    with(sheetObj){                    
		                  var HeadTitle="|No.|Sel.|Weight Group Category|Weight Group Category|20'Full (ton)|20'Full (ton)|40'Full (ton)|40'Full (ton)";
		                  var HeadTitle1="|No.|Sel.|Code|Category|From(equal or above)|To(less than)|From(equal or above)|To(less than)";
		                  var headCount=ComCountHeadTitle(HeadTitle)+3;
		                  var prefix="sheet1_";
		
		                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                  var headers = [ { Text:HeadTitle, Align:"Center"},
		                              { Text:HeadTitle1, Align:"Center"} ];
		                  InitHeaders(headers, info);
		
		                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                         {Type:"Int",       Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_wgt_grp_seq", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		                         {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_wgt_grp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
		                         {Type:"Text",      Hidden:0,  Width:105,  Align:"Left",    ColMerge:1,   SaveName:prefix+"wgt_grp_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 },
		                         {Type:"Float",     Hidden:0,  Width:142,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_lmt_wgt1",    KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Float",     Hidden:0,  Width:82,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_lmt_wgt2",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Float",     Hidden:0,  Width:142,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_lmt_wgt3",    KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                         {Type:"Float",     Hidden:0,  Width:82,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_lmt_wgt4",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		                   
		                  InitColumns(cols);
		
		                  SetEditable(1);
		                  SetFocusAfterProcess(0);
		                  SetSheetHeight(300);
		                  InitComboNoMatchText(1,"",1);
                  }

               break;
            }
        }
        function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
        	sheetObj.ShowDebugMsg(false);
    	    switch(sAction) {
    	      case IBSEARCH:      //조회
    	        formObj.f_cmd.value=SEARCH;
    	        sheetObj.DoSearch("VOP_OPF_3019GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
    	        ComBtnEnable("btn_RowAdd");
    	        ComBtnEnable("btn_RowDelete");
    	        break;
    	      case IBROWSEARCH:
    	    	  if(gubun=="SlanCd"){
    	    		  if(formObj.slan_cd.value==null || formObj.slan_cd.value==""){
    	    			  formObj.slan_cd_desc.value="";
    	    			  return false;
    	    		  }
    	    		  else{
    	    			  formObj.f_cmd.value=COMMAND12;
    	    			  var lanXml=sheetObj.GetSearchData("VOP_VSK_0202GS.do?op=0202&vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
        	    		  var strLanCdDesc=ComGetEtcData(lanXml, "checkLane");
        	    		  if(strLanCdDesc != null && strLanCdDesc != "" && strLanCdDesc != "undefined"){
        	    			  //formObj.slan_cd.value = strLanCd;
        	    			  formObj.slan_cd_desc.value=strLanCdDesc;
        	    			  formObj.skd_dir_cd.focus();
        	    		  }
        	    		  else{
        	    			  //ComShowMessage("Data is not available.");
        	    			  ComShowCodeMessage("OPF50004", "Data");
        	    			  formObj.slan_cd.value="";
      						  formObj.slan_cd_desc.value="";
      						  sheetObjects[0].RemoveAll();
      						  ComBtnDisable("btn_RowAdd");
      						  ComBtnDisable("btn_RowDelete");
      						  formObj.slan_cd.focus();
      						  return false;
        	    		  }
    	    		  }
    	    	  }
    	    	  else if(gubun=="PolCd"){
    	    		  formObj.f_cmd.value=COMMAND13;
    	    		  var polXml=sheetObj.GetSearchData("VOP_VSK_0043GS.do?op=0043&loc_cd="+formObj.pol_cd.value , FormQueryString(formObj));
    	    		  var strPolCd=ComGetEtcData(polXml, "port_name");
    	    		  if(strPolCd == null || strPolCd == "" || strPolCd == undefined){
    	    			  //ComShowMessage("Data is not available.");
    	    			  ComShowCodeMessage("OPF50004", "Data");
    	    			  formObj.pol_cd.value="";
    	    			  formObj.pol_cd.focus();
  						  return false;
    	    		  }
					  sheetObjects[0].RemoveAll();
					  ComBtnDisable("btn_RowAdd");
					  ComBtnDisable("btn_RowDelete");
    	    	  }
    	    	  break;
    	      case IBCLEAR:      //초기화
    	    	dataClear();
    	    	sheetObj.RemoveAll();
    	    	document.form.slan_cd.focus();
    	        break;
    	      case IBSAVE:        //저장
    	        formObj.f_cmd.value=MULTI;
    	        sheetObj.DoSave("VOP_OPF_3019GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), -1, false);
    	        break;
    	      case IBCOPYROW:      // 행복사
    	    	 sheetObj.DataCopy();
     	         break;
    	    }
    	}
        function sheet1_OnLoadFinish(sheetObj) { 
        	//Sheet Combo 초기화
        	initSheetCombo(sheetObj);
        }
        function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
        	//Weight Group Combo 선택시
        	if(Col == sheetObj.SaveNameCol("sheet1_cntr_wgt_grp_cd")){
        		comboValue=sheetObj.GetCellValue(Row, "sheet1_cntr_wgt_grp_cd");
        	}
        }
        function sheet1_OnChange(sheetObj, Row, Col, Value){
        	var is1st = false;
        	var isLast = false;
        	if(sheetObj.GetCellValue(Row, "sheet1_cntr_wgt_grp_seq") == "1" ){
        		sheetObj.SetCellValue(Row, "sheet1_cntr_lmt_wgt2","999999");//DBmax
        		sheetObj.SetCellValue(Row, "sheet1_cntr_lmt_wgt4","999999");
        		is1st = true;
        	}
        	//Weight Group Combo 
        	if(Col == sheetObj.SaveNameCol("sheet1_cntr_wgt_grp_cd")){
            	for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
            		if(i!=Row && sheetObj.GetRowStatus(i)!="D"){
            			if(sheetObj.GetCellValue(Row, "sheet1_cntr_wgt_grp_cd") == sheetObj.GetCellValue(i, "sheet1_cntr_wgt_grp_cd")){
    		        		sheetObj.SetCellValue(Row, "sheet1_cntr_wgt_grp_cd",comboValue,0);
    		        	}
            		}
            	}
            	getComboText(sheetObj, Row, Col);
        	}
        	if(Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt1") || Col == sheetObj.SaveNameCol("sheet1_cntr_lmt_wgt3")){
        		var nextRow = Row;
        		//변경 row이후 삭제row가 아닌 row의 index
        		for(var i=Row+1;i<=sheetObj.LastRow();i++) {
        			if(sheetObj.GetRowStatus(i)!="D") {
        				nextRow = i;
        				break;
        			}
        		}
        		if(nextRow == Row) {
        			isLast = true;
        		}
        		// 마지막 row의 경우, From이 0이 아닐 경우, 경고메세지 표시
        		if(isLast) {
        			if(Value != 0) {
        				ComShowCodeMessage("OPF50011");
						sheetObj.SelectCell(Row, Col, true, "");
						return false;
        			}
        		} else { // 다음 row의 From 이하일  경우, 경고메세지 표시
	        		if(Value <= ComParseInt(sheetObj.GetCellValue(nextRow, Col))) {
	        			ComShowCodeMessage("OPF50010");
						sheetObj.SelectCell(Row, Col, true, "");
						return false;
	    			}
        		}
        		// To보다 From이 크면, 경고메세지 표시
        		if(Value >= ComParseInt(sheetObj.GetCellValue(Row, Col+1))) {
        			ComShowCodeMessage("OPF50010");
					sheetObj.SelectCell(Row, Col, true, "");
					return false;
        		}
        		if(!isLast) {
        			sheetObj.SetCellValue(nextRow, Col+1, Value, true);
        			// 현재 row의 To와 이전 row의 From의 sync를 맞춘다.(이전 row의 정합성이 맞는 경우)
        			if(!is1st) {
        				var prevRow = 0;
        				for(var i=Row-1;i>sheetObj.HeaderRows();i--) {
        					if(sheetObj.GetRowStatus(i)!="D") {
        						prevRow = i;
        						break;
        					}
        				}
        				var preValue = ComParseInt(sheetObj.GetCellValue(prevRow, Col));
        				if(preValue < ComParseInt(sheetObj.GetCellValue(prevRow, Col+1)) && preValue > Value) {
        					sheetObj.SetCellValue(Row, Col+1, preValue, true);
    	    			}
        			}
        		}
        	}
        }
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	//필수 입력 체크
            //if (!ComChkValid(formObj)) return false;
            //alert(formObj.slan_cd.value+"|||"+formObj.slan_cd.value);
            if(formObj.slan_cd.value==null || formObj.slan_cd.value==""){
            	ComShowCodeMessage("OPF50009", "Lane");
            	ComSetFocus(formObj.slan_cd);
            	return false;
            }
            else if(formObj.pol_cd.value==null || formObj.pol_cd.value==""){
            	ComShowCodeMessage("OPF50009", "POL");
            	ComSetFocus(formObj.pol_cd);
            	return false;
            }
            //Data 중복 입력 체크
            if(sheetObj.RowCount()> 0){
	    		// Port 중복체크
            	var idxDub=sheetObj.ColValueDup("sheet1_cntr_wgt_grp_cd", false);
            	if(idxDub > -1){
            		ComShowCodeMessage("OPF50005", "Code", idxDub-1);
            		sheetObj.SelectCell(idxDub, "sheet1_cntr_wgt_grp_cd", true);
            		return ;
            	}
	    		//전체 삭제 일 경우 Pass
	    		if(sheetObj.RowCount() == sheetObj.RowCount("D")){
	    			return true;
            	}
	    		
	    		// 마지막 row
	    		var lastRow = sheetObj.LastRow();
        		//변경 row이후 삭제row가 아닌 row의 index
	    		for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++) {
        			if(sheetObj.GetRowStatus(i)!="D") {
        				lastRow = i;
        			}
        		}
	    		// 값의 범위 체크
	    		for(var i=sheetObj.HeaderRows();i<=lastRow;i++) {
	    			if(sheetObj.GetRowStatus(i)!="D") {
	    				var wgt1 = ComParseInt(sheetObj.GetCellValue(i, "sheet1_cntr_lmt_wgt1"));
	    				var wgt2 = ComParseInt(sheetObj.GetCellValue(i, "sheet1_cntr_lmt_wgt2"));
	    				var wgt3 = ComParseInt(sheetObj.GetCellValue(i, "sheet1_cntr_lmt_wgt3"));
	    				var wgt4 = ComParseInt(sheetObj.GetCellValue(i, "sheet1_cntr_lmt_wgt4"));
	    				// To보다 From이 크면, 경고메세지 표시
	    				if(wgt1 >= wgt2) {
	    					ComShowCodeMessage("OPF50010");
	    					sheetObj.SelectCell(i, "sheet1_cntr_lmt_wgt1", true, "");
	    					return false;
	    				}
	    				if(wgt3 >= wgt4) {
	    					ComShowCodeMessage("OPF50010");
	    					sheetObj.SelectCell(i, "sheet1_cntr_lmt_wgt3", true, "");
	    					return false;
	    				}
	    			}
	    		}
	    		for(var i=sheetObj.HeaderRows();i<=lastRow;i++) {
	    			if(sheetObj.GetRowStatus(i)!="D") {
	    				var wgt1 = ComParseInt(sheetObj.GetCellValue(i, "sheet1_cntr_lmt_wgt1"));
	    				var wgt2 = ComParseInt(sheetObj.GetCellValue(i, "sheet1_cntr_lmt_wgt2"));
	    				var wgt3 = ComParseInt(sheetObj.GetCellValue(i, "sheet1_cntr_lmt_wgt3"));
	    				var wgt4 = ComParseInt(sheetObj.GetCellValue(i, "sheet1_cntr_lmt_wgt4"));
	    				// 마지막 row의 경우, From이 0이 아닐 경우, 경고메세지 표시
	    				if(i==lastRow) {
	    					if(ComParseInt(wgt1) != 0) {
	    						ComShowCodeMessage("OPF50011");
	    						sheetObj.SelectCell(i, "sheet1_cntr_lmt_wgt1", true, "");
	    						return false;
	    					}
	    					if(ComParseInt(wgt3) != 0) {
	    						ComShowCodeMessage("OPF50011");
	    						sheetObj.SelectCell(i, "sheet1_cntr_lmt_wgt3", true, "");
	    						return false;
	    					}
	    				} else {// 다음 row의 From 이하일  경우, 경고메세지 표시
	    					var nextRow = 0;
	    					for(var j=i+1;j<=lastRow;j++) {
	    						if(sheetObj.GetRowStatus(j)!="D") {
	    							nextRow = j;
	    	        				break;
	    						}
	    					}
	    					if(wgt1 <= ComParseInt(sheetObj.GetCellValue(nextRow, "sheet1_cntr_lmt_wgt1"))) {
		    					ComShowCodeMessage("OPF50010");
		    					sheetObj.SelectCell(i, "sheet1_cntr_lmt_wgt1", true, "");
		    					return false;
		    				}
		    				if(wgt3 <= ComParseInt(sheetObj.GetCellValue(nextRow, "sheet1_cntr_lmt_wgt3"))) {
		    					ComShowCodeMessage("OPF50010");
		    					sheetObj.SelectCell(i, "sheet1_cntr_lmt_wgt3", true, "");
		    					return false;
		    				}
	    				}
	    			}
	    		}
	    	}
            return true;
        }
        function skd_dir_cd_change(form){
        	sheetObjects[0].RemoveAll();
        	ComBtnDisable("btn_RowAdd");
        	ComBtnDisable("btn_RowDelete");
        }
        function initSheetCombo(sheetObj) {
        	var formObj=document.form;
    		//시트에서 사용하는 콤보 목록 모두 가져오기 : TP, FM, CGO, IMO, POSTEXTD, STWG
        	sheetObj.SetWaitImageVisible(0);
    		formObj.f_cmd.value=SEARCHLIST01;
    		var sXml=sheetObj.GetSearchData("VOP_OPF_3019GS.do", FormQueryString(formObj)+"&intg_cd_id=CD01878");
    		sheetObj.SetWaitImageVisible(1);
    		var arrCombo=ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_desc");
    		if (arrCombo != null) {			
    			var arrVal=arrCombo[0].split("|");
    			var arrName=arrCombo[1].split("|");
    			var itemNm="";
    			for ( var j=0; j < arrVal.length; j++) {
    				if (j == 0) itemNm=itemNm + arrVal[j]	+ "\t" + arrName[j];
    				else itemNm=itemNm + "|" + arrVal[j] + "\t" + arrName[j];
    			}
    			sheetObj.SetColProperty("sheet1_cntr_wgt_grp_cd", {ComboText:itemNm, ComboCode:arrCombo[0]} );
    		}
        }
        function getComboText(sheetObj, row, col, code, text){
        	var sText=sheetObj.GetComboInfo(row, col, "Text");
        	var sCode=sheetObj.GetComboInfo(row, col, "Code");
        	var arrText=sText.split("|");
        	var arrCode=sCode.split("|");
        	var idx=sheetObj.GetComboInfo(row, col, "SelectedIndex");
        	if(idx!=-1){
	        	var arrView=arrText[idx].split("\t");
        	}else{
        		var arrView="";
        	}
        	sheetObj.SetCellValue(row, "sheet1_wgt_grp_cd_desc",arrView[1],0);
        }
	/* 개발자 작업  끝 */
