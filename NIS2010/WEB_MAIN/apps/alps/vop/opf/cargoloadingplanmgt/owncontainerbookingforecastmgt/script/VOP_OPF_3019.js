/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_3019.js
*@FileTitle : Weight Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.11 김종옥
* 1.0 Creation
* 2011.12.15 김민아 [CHM-201115274-01] [VOP-OPF] Weight Group code 일괄 Update 요청
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
     * @class vop_opf_3019 : vop_opf_3019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_3019() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.dataClear				= dataClear;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    //Weight Group 코드 임시 저장
    var comboValue = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1 = sheetObjects[0];
	         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
      		var prefix = "sheet1_";

            switch(srcName) {
            	case "slan_cd_pop":
            		var slan_cd = formObject.slan_cd.value;
            		ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 420, 480, "setSlanCd", "0,0", true);
            		break;
            		
            	case "pol_cd_pop":
            		var port_cd = formObject.pol_cd.value;
            		ComOpenPopup("VOP_VSK_0043.do?port_cd="+port_cd, 422, 520, "setPolCd", "0,0", true);
            		break;
            	
				case "btn_RowAdd":
					if((sheetObject1.RowCount - sheetObject1.RowCount("D")) == 5) return;
					
					var new_seq = ComParseInt(sheetObject1.CellValue(sheetObject1.LastRow, prefix+"cntr_wgt_grp_seq"))+1;
					var from1_ton = "";
					var from3_ton = "";
					
					var row = sheetObject1.DataInsert(-1);					
					sheetObject1.CellText(row, prefix+"slan_cd")	= formObject.slan_cd.value;
					sheetObject1.CellText(row, prefix+"skd_dir_cd")	= formObject.skd_dir_cd.value;
					sheetObject1.CellText(row, prefix+"pol_cd")		= formObject.pol_cd.value;

					setCntr_wgt_grp_seq();

					setCntr_wgt_grp_cd(row);
					break;

				case "btn_RowCopy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					break;
					
				case "btn_RowDelete":
					var delChkFlg = ComRowHideDelete(sheetObject1,"sheet1_del_chk");
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
					self.close();
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

    //No. 순서 및 From To 정렬 시킴.
    function setCntr_wgt_grp_seq(){
    	var seq = 1;
    	var prefix = "sheet1_";
    	var nextRow = 0;
    	
		for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++){
			if(sheetObjects[0].RowStatus(i) != "D"){
				sheetObjects[0].CellValue(i, prefix+"cntr_wgt_grp_seq") = seq;
				seq++;

				for(var j=i+1 ; j<=sheetObjects[0].LastRow; j++){
					if(sheetObjects[0].RowStatus(j) != "D")
					{
						nextRow = j;
						j = j+sheetObjects[0].LastRow;
						continue;
					}
				}
				
				//i 맨 마지막 Row는 적용하사지 않음.
				if( i != nextRow){
					sheetObjects[0].CellValue(nextRow, prefix+"cntr_lmt_wgt2") = sheetObjects[0].CellText(i, prefix+"cntr_lmt_wgt1");
					sheetObjects[0].CellValue(nextRow, prefix+"cntr_lmt_wgt4") = sheetObjects[0].CellText(i, prefix+"cntr_lmt_wgt3");
				}
			}
		}
    }
    
    function setCntr_wgt_grp_cd(row) {
    	var sheetObj = sheetObjects[0];
    	var prefix = "sheet1_";
    	var rowCnt = sheetObj.RowCount - sheetObj.RowCount("D");
    	var rowValue = "";
    	if(rowCnt == 1){
    		rowValue = "X";
    	} else {
    		var bfRowIdx = row - 1;
    		for(var i=bfRowIdx ; i>0 ; i--){
    			if(sheetObj.RowStatus(i) == "D"){
        			bfRowIdx = bfRowIdx - 1;
        		}else{
        			break;
        		}
    		}
    		
    		var bfRowValue = sheetObj.CellValue(bfRowIdx, prefix+"cntr_wgt_grp_cd");
    		switch (bfRowValue) {
    		case "X":
    			rowValue = "H";
    			break;
    		case "H":
    			rowValue = "M";
    			break;
    		case "M":
    			rowValue = "L";
    			break;
    		case "L":
    			rowValue = "E";
    			break;
    		}
    	}
    	sheetObj.CellText(row, prefix+"cntr_wgt_grp_cd") = rowValue;
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

       sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObject = document.form;
    	for(var x=0; x<formObject.skd_dir_cd.length; x++){
    		if(formObject.skd_dir_cd[x].value == formObject.sel_skd_dir_cd.value){
    			formObject.skd_dir_cd[x].selected = true;
    		}
    	}    	
    	
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
    	
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		initControl();
		
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
		form.slan_cd.value = aryPopupData[0][1];
		form.slan_cd_desc.value = aryPopupData[0][2];
    }
    
    /**
	 * Pol Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
    function setPolCd(aryPopupData){
		form.pol_cd.value = aryPopupData[0][2];
    }
    
    /**
     * Slan Code 변경 시 해당 Name 을 가져온다. <br>
     **/
    function slan_cd_change() {
    	document.form.slan_cd_desc.value = "";
    	
    	var slanCdObj = document.form.slan_cd;
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
    	var polCdObj = document.form.pol_cd;
    	
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
    	var elementObj = event.srcElement;
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

            var cnt = 0;
    		var sheetID = sheetObj.id;

            switch(sheetID) {

                case "sheet1":
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 300;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 2, 100);
                        
                        var HeadTitle  = "|No.|Sel.|Weight Group Category|Weight Group Category|20'Full (ton)|20'Full (ton)|40'Full (ton)|40'Full (ton)";
                        var HeadTitle1 = "|No.|Sel.|Code|Category|From(equal or above)|To(less than)|From(equal or above)|To(less than)";
                        
                        //var HeadTitle = "|Sel|Weight Group Category|Weight Group Category|20'Full\n(ton)|20'Empty\n(ton)|40'Full\n(ton)|40'Empty\n(ton)";
                        //var HeadTitle1 = "|Sel|Code|Category|20'Full\n(ton)|20'Empty\n(ton)|40'Full\n(ton)|40'Empty\n(ton)";
                        
    					var headCount = ComCountHeadTitle(HeadTitle)+3;

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        var prefix="sheet1_";
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	prefix+"ibflag");
						//InitDataProperty(0, cnt++ , dtDataSeq,		25,		daCenter,	true,	prefix+"Seq");
						InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,	prefix+"cntr_wgt_grp_seq",	false,	"",  dfInteger,	0,	false,	false);
						InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,	prefix+"del_chk");
						InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"cntr_wgt_grp_cd",	true,	"",  dfNone,	0,	false,	true, 1);
						InitDataProperty(0, cnt++ , dtData,			105,	daLeft,		true,	prefix+"wgt_grp_cd_desc",	false,	"",  dfNone,	0,	false,	false, 500);
						
						InitDataProperty(0, cnt++ , dtData,			142,	daRight,	true,	prefix+"cntr_lmt_wgt1",		true,	"",  dfNumber,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtData,			82,		daRight,	true,	prefix+"cntr_lmt_wgt2",		false,	"",  dfNumber,	0,	false,	false);
						InitDataProperty(0, cnt++ , dtData,			142,	daRight,	true,	prefix+"cntr_lmt_wgt3",		true,	"",  dfNumber,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtData,			82,		daRight,	true,	prefix+"cntr_lmt_wgt4",		false,	"",  dfNumber,	0,	false,	false);

						InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix+"slan_cd",			true,	"",  dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix+"skd_dir_cd",		true,	"",  dfNone,	0,	false,	true);
						InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix+"pol_cd",			true,	"",  dfNone,	0,	false,	true);
						
						//InitDataValid(0, prefix+"cntr_wgt_grp_cd", vtEngUpOnly);

						FocusAfterProcess = false;

					}
                    break;
            }
        }

        function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
        	sheetObj.ShowDebugMsg = false;
      		
    	    switch(sAction) {
    	    
    	      case IBSEARCH:      //조회
    	        formObj.f_cmd.value = SEARCH;
    	        sheetObj.DoSearch("VOP_OPF_3019GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));

    	        ComBtnEnable("btn_RowAdd");
    	        ComBtnEnable("btn_RowDelete");
    	        break;
    	        
    	      case IBROWSEARCH:
    	    	  if(gubun=="SlanCd"){
    	    		  if(formObj.slan_cd.value==null || formObj.slan_cd.value==""){
    	    			  formObj.slan_cd_desc.value = "";
    	    			  return false;
    	    		  }
    	    		  else{
    	    			  formObj.f_cmd.value = COMMAND12;
        	    		  var lanXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op=0202&vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
        	    		  
        	    		  var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");
        	    		  
        	    		  if(strLanCdDesc != null && strLanCdDesc != "" && strLanCdDesc != "undefined"){
        	    			  //formObj.slan_cd.value = strLanCd;
        	    			  formObj.slan_cd_desc.value = strLanCdDesc;
        	    			  formObj.skd_dir_cd.focus();
        	    		  }
        	    		  else{
        	    			  //ComShowMessage("Data is not available.");
        	    			  ComShowCodeMessage("OPF50004", "Data");
        	    			  formObj.slan_cd.value = "";
      						  formObj.slan_cd_desc.value = "";
      						  sheetObjects[0].RemoveAll();
      						  ComBtnDisable("btn_RowAdd");
      						  ComBtnDisable("btn_RowDelete");
      						  formObj.slan_cd.focus();
      						  return false;
        	    		  }
    	    		  }
    	    	  }
    	    	  else if(gubun=="PolCd"){
    	    		  formObj.f_cmd.value = COMMAND13;
    	    		  var polXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do?op=0043&loc_cd="+formObj.pol_cd.value , FormQueryString(formObj));
    	    		  var strPolCd = ComGetEtcData(polXml, "port_name");
    	    		  
    	    		  if(strPolCd == null || strPolCd == "" || strPolCd == undefined){
    	    			  //ComShowMessage("Data is not available.");
    	    			  ComShowCodeMessage("OPF50004", "Data");
    	    			  formObj.pol_cd.value = "";
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
    	        formObj.f_cmd.value = MULTI;
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
        	if(Col == 3){
        		comboValue = sheetObj.CellValue(Row, "sheet1_cntr_wgt_grp_cd");
        	}
        }
        
        function sheet1_OnChange(sheetObj, Row, Col, Value){

        	if(sheetObj.CellValue(Row, "sheet1_cntr_wgt_grp_seq") == "1" ){
        		sheetObj.CellValue(Row, "sheet1_cntr_lmt_wgt2") = "";
        		sheetObj.CellValue(Row, "sheet1_cntr_lmt_wgt4") = "";
        	}
        	//Weight Group Combo 
        	if(Col == 3){
            	for(var i=sheetObj.HeaderRows ; i<=sheetObj.LastRow ; i++){
            		if(i!=Row && sheetObj.RowStatus(i)!="D"){
    		        	if(sheetObj.CellValue(Row, "sheet1_cntr_wgt_grp_cd") == sheetObj.CellValue(i, "sheet1_cntr_wgt_grp_cd")){
    		        		sheetObj.CellValue2(Row, "sheet1_cntr_wgt_grp_cd") = comboValue;
    		        	}
            		}
            	}
            	getComboText(sheetObj, Row, Col);
        	}

        	if(Col == 5 || Col == 7){
        		if(Row <= sheetObj.LastRow && Value != ""){
        			var vAllDelCnt = sheetObj.RowCount("D");
    				var vLastRow = sheetObj.LastRow;
    				var vDelCnt = 0;
					for(var i=Row+1 ; i<=vLastRow ; i++){
						if( sheetObj.RowStatus(i)=="D" ){
							vDelCnt++;
						}else{
							vLastRow=0;
						}
					}
					
					var vFastRow = sheetObj.HeaderRows;
					var vLastRow2 = sheetObj.LastRow;
					for(var i=vFastRow ; i<=vLastRow2 ; i++){
						if( sheetObj.RowStatus(i)=="D" ){
							vFastRow++;
						}else{
							vLastRow2=0;
						}
					}
					
					//입력한 row가 첫번째 일 경우					
					if(vFastRow == Row){
						if( sheetObj.HeaderRows != Row){
							if( (Value > ComParseInt(sheetObj.CellValue(Row+(vDelCnt+1), Col)))  || (sheetObj.CellValue(Row+(vDelCnt+1), Col) == "")){
								sheetObj.CellValue(Row+(vDelCnt+1), Col+1) = Value;
							}else{
	        					if(Col == 5){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt1",true, "");
	        					}else if(Col == 7){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt3",true, "");
	        					}							
							}
						}
						else
						{
							sheetObj.CellValue(Row+1, Col+1) = Value;
						}
        			}else{
        				if( Row < (sheetObj.LastRow-vAllDelCnt) )
        				{
        					if( (Value < ComParseInt(sheetObj.CellValue(Row-1, Col))) && (Value > ComParseInt(sheetObj.CellValue(Row+vDelCnt+1, Col)) || sheetObj.CellValue(Row+vDelCnt+1, Col) == "") ){
	        					sheetObj.CellValue(Row+(vDelCnt+1), Col+1) = Value;
	        				}else{
	        					if(Col == 5){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt1",true, "");
	        					}else if(Col == 7){
	        						ComShowCodeMessage("OPF50010");
	        						sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt3",true, "");
	        					}
	        				}
        				}else{
        					var vBeForeRow;
        					var vTemp = sheetObj.HeaderRows;
        					for(var x=Row; x>vTemp; x--){
        						if( sheetObj.RowStatus(x)!="D"){
        							vBeForeRow = x-1;
        							vTemp = x+2;
        						}
        					}

        					if( (Value < ComParseInt(sheetObj.CellValue(vBeForeRow, Col))) || (sheetObj.CellValue(vBeForeRow, Col) == "") ){
        						sheetObj.CellValue(Row+(vDelCnt+1), Col+1) = Value;
        					}else{
	        					if(Col == 5){
	        						if(Value == 0){
	        							ComShowCodeMessage("OPF50010");
	        							sheetObj.SelectCell(vBeForeRow,"sheet1_cntr_lmt_wgt1",true, "");
	        						}else{
	        							ComShowCodeMessage("OPF50010");
	        							sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt1",true, "");
	        						}
	        					}else if(Col == 7){
	        						if(Value == 0){
	        							ComShowCodeMessage("OPF50010");
		        						sheetObj.SelectCell(vBeForeRow,"sheet1_cntr_lmt_wgt3",true, "");
	        						}else{	        						
	        							ComShowCodeMessage("OPF50010");
	        							sheetObj.SelectCell(Row,"sheet1_cntr_lmt_wgt3",true, "");
	        						}
	        					}
        					}
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
            if(sheetObj.RowCount > 0){
	    		// Port 중복체크
            	var idxDub = sheetObj.ColValueDup("sheet1_cntr_wgt_grp_cd", false);
            	if(idxDub > -1){
            		ComShowCodeMessage("OPF50005", "Code", idxDub-1);
            		sheetObj.SelectCell(idxDub, "sheet1_cntr_wgt_grp_cd", true);
            		return ;
            	}
	    		
	    		
	    		//전체 삭제 일 경우 Pass
	    		if(sheetObj.RowCount == sheetObj.RowCount("D")){
	    			return true;
            	}
            
	    		//맨마지막에서 삭제 된 Row 카운터
	    		var vLastRow = sheetObj.LastRow;
	    		var vLastCnt = 0;
	    		for(var i=sheetObj.LastRow; i <= vLastRow; i--){
	    			if(sheetObj.RowStatus(i)=="D"){
	    				vLastCnt = i-1;
	    			}else{
	    				vLastCnt = i;
	    				vLastRow -= vLastRow;
	    			}
	    		}
	    		
	    		//맨마지막 로우 "0" 체크 - 20'Full, 40'Full From(equal or above)
	    		if( sheetObj.CellValue(vLastCnt, "sheet1_cntr_lmt_wgt1") != "0"){
	    			ComShowCodeMessage("OPF50011");
	    			sheetObj.SelectCell(vLastCnt,"sheet1_cntr_lmt_wgt1",true);
	    			return false;
	    		}
	    		if( sheetObj.CellValue(vLastCnt, "sheet1_cntr_lmt_wgt3") != "0"){
	    			ComShowCodeMessage("OPF50011");
	    			sheetObj.SelectCell(vLastCnt,"sheet1_cntr_lmt_wgt3",true);
	    			return false;
	    		}
	    		
	    		//맨마지막 로우 "0" 이면 안됨 체크 - 20'Full, 40'Full To(less than)
	    		if( sheetObj.CellValue(vLastCnt, "sheet1_cntr_lmt_wgt2") == "0"){
	    			ComShowCodeMessage("OPF50012");
	    			sheetObj.SelectCell(vLastCnt,"sheet1_cntr_lmt_wgt2",true);
	    			return false;
	    		}
	    		if( sheetObj.CellValue(vLastCnt, "sheet1_cntr_lmt_wgt4") == "0"){
	    			ComShowCodeMessage("OPF50012");
	    			sheetObj.SelectCell(vLastCnt,"sheet1_cntr_lmt_wgt4",true);
	    			return false;
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
        	var formObj = document.form;
        	
    		//시트에서 사용하는 콤보 목록 모두 가져오기 : TP, FM, CGO, IMO, POSTEXTD, STWG
        	sheetObj.WaitImageVisible = false;
    		formObj.f_cmd.value = SEARCHLIST01;
    		var sXml = sheetObj.GetSearchXml("VOP_OPF_3019GS.do", FormQueryString(formObj)+"&intg_cd_id=CD01878");
    		sheetObj.WaitImageVisible = true;
    		
    		var arrCombo = ComXml2ComboString(sXml, "intg_cd_val_dp_desc", "intg_cd_val_desc");
//    		alert(sXml);
    		if (arrCombo != null) {			
    			var arrVal  = arrCombo[0].split("|");
    			var arrName = arrCombo[1].split("|");
    			var itemNm  = "";
    			for ( var j = 0; j < arrVal.length; j++) {
    				if (j == 0) itemNm = itemNm + arrVal[j]	+ "\t" + arrName[j];
    				else itemNm = itemNm + "|" + arrVal[j] + "\t" + arrName[j];
    			}
    			sheetObj.InitDataCombo(0, "sheet1_cntr_wgt_grp_cd", itemNm, arrCombo[0]);
    		}
        }
        
        function getComboText(sheetObj, row, col, code, text){
        	var sText = sheetObj.GetComboInfo(row, col, "Text");
        	var sCode = sheetObj.GetComboInfo(row, col, "Code");
        	var arrText = sText.split("|");
        	var arrCode = sCode.split("|");
        	var idx = sheetObj.GetComboInfo(row, col, "SelectedIndex");
        	
        	if(idx!=-1){
	        	var arrView = arrText[idx].split("\t");
        	}else{
        		var arrView = "";
        	}
        	sheetObj.CellValue2(row, "sheet1_wgt_grp_cd_desc") = arrView[1];
        }
	/* 개발자 작업  끝 */