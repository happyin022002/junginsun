	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0217.js
	 *@FileTitle : M&R Colleague Tree
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.20
	 *@LastModifier : 정영훈
	 *@LastVersion : 1.0
	 * 2009.05.20 정영훈
	 * 1.0 Creation
	=========================================================*/
	/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
						[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
						기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	
	/**
	 * @extends 
	 * @class EES_MNR_0217 : EES_MNR_0217 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0217() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		    = setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl              = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	
	var initInd='N';
	var mainMsg='M&R Colleague Tree';
	var subMsg = 'XXX';
	
	var nowLoad = 0;
	var regionalHQ = "";
	var operationOfc = "";
	var HOOfc = "";	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
	
			case "btn_New":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
	
			case "btn_Save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
	
			case "btn_RowAdd":
				doRowAdd(sheetObjects[0], formObject);
				break;
	
	
			case "btn_RowDelete":
				ComRowHideDelete(sheetObjects[0],"del_chk");
				break;
	
	
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {     
				ComFuncErrMsg(e);          
			} else {      
				ComFuncErrMsg(e);    
			}   
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
		MnrWaitControl(true);
		nowLoad = 1;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}	
		sheetObjects[0].WaitImageVisible = false;
		initCombo(); 
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	
		nowLoad = 0;
		MnrWaitControl(false);
	}
	
	/**
	 * 로딩시 Operation Office를 setting
	 * @return
	 */
	function initOperationOfc(){
		var result  = "";
		var sCondition = new Array (
				new Array("MdmOrganization","SEARCH","NOTHQ")   //Office
			);   
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
	
		if(comboList[0] != null){
			for(var i = 0; i < comboList[0].length;i++){ 
	
				var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				result = result + code + "|";
			}
	
			result = result.substring(0, result.length - 1);
			sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("ofc_cd"), result, result, result.substring(0,result.indexOf("|")) );
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
		var sheetId = sheetObj.id;
	
		switch(sheetId) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 342;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);
	
				var HeadTitle = "|Del|Seq.|Regional HQ|Operation Office|Work Type|User Id|User Name|User E-mail|Remark(s)";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount + 3 , 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,	COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	    daCenter,	false,	"ibflag");
	
				InitDataProperty(0, cnt++ , dtCheckBox,		30,	    daCenter,	false,	"del_chk");
				InitDataProperty(0, cnt++ , dtSeq,          30,     daCenter,   true,   "Seq");
				InitDataProperty(0, cnt++ , dtCombo,    	90,		daCenter,	false,	"ar_hd_qtr_ofc_cd", 	true,		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtComboEdit,	125,	daCenter,	false,	"ofc_cd", 	            true,		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtCombo,		85,		daCenter,	false,	"mnr_grp_tp_cd",        true,		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtPopupEdit,	140,	daLeft,  	false,	"cntc_usr_id", 	        true,		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,		    140,	daLeft,	    false,	"usr_nm", 	            false,		"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		    140,	daLeft,	    false,	"usr_eml", 	            false,		"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		    200,	daLeft,	    false,	"mnr_cntc_rmk",         false,		"",		dfNone,		0,		true,		true,  4000);
	
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	"org_ofc_cd", 	        false, 		"", 	dfNone);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	"org_mnr_grp_tp_cd", 	false, 		"", 	dfNone);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	"org_cntc_usr_id", 	 	false, 		"", 	dfNone);
				//
				//SELECT 로우 배경색       
				SelectionMode = smSelectionRow;    
				SelectHighLight = true;            
				SelectFontBold = false;          
				SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
	
				CountPosition = 0;
	
				PopupImage  =  "img/btns_search.gif";
				ShowButtonImage = 2;
	
			}
			break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH:      //조회
			MnrWaitControl(true);
			sheetObjects[0].Redraw = false;    
			sheetObjects[0].WaitImageVisible = false;	
			formObj.f_cmd.value = SEARCH;
			//alert(FormQueryString(formObj));
			var sXml = sheetObj.GetSearchXml("EES_MNR_0217GS.do",  FormQueryString(formObj));
			//alert(sXml);
			sheetObjects[0].LoadSearchXml(sXml); 
			sheetObjects[0].Redraw = true; 
			break;
	
		case IBSAVE:        //저장
		doIBSAVE(sheetObj,formObj,sAction);
		break;
	
		case IBCLEAR:
			MnrWaitControl(true);
			nowLoad = 1;
	    	ComOpenWait(true);
			//콤보데이타 초기화
			formObj.combo1.removeAll();
			formObj.combo2.removeAll();
			
			//콤보조회
			var sCondition = new Array (
					new Array("MnrGenCd","HOOFC", "COMMON") //Regional HQ
					,new Array("MnrGenCd","CD00006", "COMMON")  //Work Type
					,new Array("MdmOrganization","RHQ","FALSE")   //Regional HQ
			);
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
			//쉬트 설정
			var sheetComboText = "";
			var sheetComboCode = "";
			var sheetComboCodeText = "";
			var sheetComboDefault = "";
			regionalHQ = "";
			for(var i = 0; i < comboList.length;i++)
			{
				//쉬트콤보별 초기화
				sheetComboText = "";
				sheetComboCode = "";
				sheetComboCodeText = "";
				sheetComboDefault = ""; 
				if(comboList[i] != null)
				{
					for(var j = 0; j < comboList[i].length;j++)
					{ 
						var tempText = comboList[i][j].split("|");   
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
						if(j ==0){	
							sheetComboDefault = tempText[0];      	
						}
						if(i==0) {
							HOOfc =  tempText[0];
						}else if(i==2)
						{
							formObj.combo1.InsertItem(j, comboList[i][j] , tempText[0]);
							formObj.combo1.Code = tempText[0];
							regionalHQ = regionalHQ + tempText[0] + "|";
						}
		
					}
					//쉬트 콤보 설정
					if(i == 1) {
						sheetObjects[0].InitDataCombo(0, "mnr_grp_tp_cd", sheetComboText, sheetComboCode, sheetComboDefault);
					}else if(i==2)
					{
						regionalHQ = regionalHQ.substring(0, regionalHQ.length - 1);
						formObj.combo1.Code = rhqOfcCd;
						formObj.combo2.Code = "ALL";
					}
				}else{
					if(i==0){
						HOOfc =  "";
					}
				}
			}	    
		
			//쉬트 초기화
			sheetObj.RemoveAll(); 
		
			sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"), regionalHQ, regionalHQ, regionalHQ.substring(0,regionalHQ.indexOf("|")) );
			initOperationOfc();
			comboOnChange(formObj.combo1,formObj.combo1.Text, formObj.combo1.Text);
			nowLoad = 0;     
			MnrWaitControl(false);
	    	ComOpenWait(false);
			break;
		}
	}
	
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
	
			if(sAction==IBSAVE) {
				if (!ComChkValid(formObj)) return false;
				//저장시 각시트별 중복체크
				for (var i=0; i<sheetObjects.length; i++){
					var Row = sheetObjects[i].ColValueDup("ofc_cd|mnr_grp_tp_cd|cntc_usr_id");
					if(sheetObjects[i].IsDataModified){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	
	/**
	 * 멀티 콤보 초기화 
	 * @return
	 */
	function initCombo() {
	
		var formObject = document.form
		with (formObject.combo1) { 
			MultiSeparator = "|";
			SetTitle("Office Code|Office Name");
			//MultiSelect = false;
			SetColAlign("left|left");        
			//SetColWidth("100|150");    
			DropHeight = 160;
	
		} 
		with (formObject.combo2) { 
			MultiSeparator = "|";
			SetTitle("Office Code|Office Name");
			//MultiSelect = false;
			SetColAlign("left|left");        
			//SetColWidth("100|150");    
			DropHeight = 160; 
	
		} 
	
	}

	/**
	 * row add버튼이 클릭될경우 발생되는 이벤트 처리
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function doRowAdd(sheetObj, formObj){
		nowLoad = 1;
		var iRow = sheetObjects[0].DataInsert(-1);
		sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("cntc_usr_id")) = "";
		sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ofc_cd")) = "";
		//alert(HOOfc + " :: " + currOfcCd);
		//sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"), formObj.combo1.Code, formObj.combo1.Code, formObj.combo1.Code);
	
	//	if(HOOfc != currOfcCd){ 
	//	sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = rhqOfcCd;
	//	cellSetItems(sheetObjects[0], iRow, sheetObjects[0].SaveNameCol("ofc_cd"),   sheetObjects[0].CellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
	//	sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ofc_cd")) = "";
	//	}else{
		sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = formObj.combo1.Code;
		cellSetItems(sheetObjects[0], iRow, sheetObjects[0].SaveNameCol("ofc_cd"),   sheetObjects[0].CellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
		sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ofc_cd")) = "";
	//	}
		nowLoad = 0;
	}	  
	/**
	 * combo1에서 onChange가 발생하는 경우
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function combo1_OnChange(comboObj,Index_Code, Text){
		if(nowLoad == 0){
			comboOnChange(comboObj,Index_Code, Text);
		}
	}
	
	/**
	 * combo1에서 OnChange가 발생하는 경우 이벤트처리
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */   
	function comboOnChange(comboObj,Index_Code, Text){ 
		//alert(comboObj +" :: "+ Index_Code + " :: "+ Text);
	
		var formObj = document.form;
		formObj.combo2.removeAll();
		var sCondition = new Array (
				new Array("MdmOrganization","SEARCH",Index_Code)   //Office
			);   
		sheetObjects[0].WaitImageVisible = false;
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].WaitImageVisible = true;
		
		if(comboList[0] != null){
			for(var i = 0; i < comboList[0].length;i++){ 
				var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				formObj.combo2.InsertItem(i, comboList[0][i] , code);
				formObj.combo2.Code = code;
			}
			formObj.combo2.InsertItem(0, "ALL" , "ALL");
			formObj.combo2.Code = "ALL";
		}
	
		//sheetObjects[0].RemoveAll(); 
	
	} 
	
	/**
	 * operation office의 validation을 검사한다.
	 * @param strhq
	 * @param strofc
	 * @param Row
	 * @param Col
	 * @return
	 */
	function  checkOperationOfc(strhq, strofc, Row, Col){
		var srchStr = strofc+","+strhq;
		var retArray = MnrGeneralCodeCheck(sheetObjects[0],"OFC",srchStr);
		if(retArray == null){
			ComShowCodeMessage("MNR00010", "Office");
			sheetObjects[0].CellValue2(Row, sheetObjects[0].SaveNameCol("ofc_cd")) = "";
			sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("ofc_cd"));
		}
	}
	
	/**
	 * sheet1에서 발생하는 OnChange이벤트를 처리한다.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
	
		if(sheetObj.ColSaveName(Col) == "ar_hd_qtr_ofc_cd"){
	
	//		if(HOOfc != currOfcCd){
	//		sheetObj.CellValue2(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = currOfcCd;
	//		cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), currOfcCd);
	//		}else{
			// Operation Office에 값을 넣는다.
			cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), Value);
	//		}  
			sheetObjects[0].CellValue2(Row,   sheetObjects[0].SaveNameCol("cntc_usr_id") )= "";
			sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("usr_nm")) = "";
			sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("usr_eml")) = "";
			sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("mnr_cntc_rmk")) = "";
			sheetObjects[0].CellValue2(Row,  sheetObjects[0].SaveNameCol("ofc_cd")) = "";
	
		}else if(sheetObj.ColSaveName(Col) == "cntc_usr_id"){
			checkUsrId(sheetObj.CellValue(Row, Col), Row, Col);
	
		}else if(sheetObj.ColSaveName(Col) == "ofc_cd"){
			if(sheetObj.CellValue(Row, Col) != ""){
				checkOperationOfc(sheetObj.CellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")), sheetObj.CellValue(Row, Col), Row, Col);
			}
			sheetObjects[0].CellValue2(Row,   sheetObjects[0].SaveNameCol("cntc_usr_id") )= "";
			sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("usr_nm")) = "";
			sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("usr_eml")) = "";
			sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("mnr_cntc_rmk")) = "";
		}
	
	}
	
	function checkUsrId(strid, Row, Col){
		var sheetObj=sheetObjects[0];
		var sCondition = new Array (
				new Array("ComUser",strid,"COMMON") //Regional HQ
		);
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null){
				var xmlVal = comboList[i][0].split("|");
				//alert(xmlVal[0] + " ** "+ xmlVal[1]);
				sheetObjects[0].CellValue(Row,  sheetObjects[0].SaveNameCol("usr_nm")) = xmlVal[0];
				sheetObjects[0].CellValue(Row,  sheetObjects[0].SaveNameCol("usr_eml")) = xmlVal[1];
				return true;
			}else{
				ComShowCodeMessage("MNR00005", "USR_ID  ");
				sheetObjects[0].CellValue2(Row,   sheetObjects[0].SaveNameCol("cntc_usr_id") )= "";
				sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("usr_nm")) = "";
				sheetObjects[0].CellValue(Row,   sheetObjects[0].SaveNameCol("usr_eml")) = "";
				sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("cntc_usr_id"));
				return false;
			}
		}	
	}
	
	/**
	 * sheet1에서 클릭이벤트를 처리한다.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnClick(sheetObj,Row, Col, Value){
		//alert("ONClick "+Value+ "<<<<<"+ HOOfc + " >>>> "+ currOfcCd); 
	
		if(sheetObj.ColSaveName(Col) == "ofc_cd"){  
			nowLoad = 1;
	
	//		if(HOOfc != currOfcCd){
	//		sheetObj.CellValue2(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = currOfcCd;
	//		cellSetItems(sheetObjects[0], Row, sheetObjects[0].SaveNameCol("ofc_cd"),   currOfcCd);
	//		}else{
			// Operation Office에 값을 넣는다.
			cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"),  sheetObj.CellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
	//		}
	
			nowLoad = 0;
		}
	
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg)
	{
		nowLoad = 0;
		MnrWaitControl(false);
	}
	
	/**
	 * operation office 필드의 combo필드의 데이터를 입력한다.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function cellSetItems(sheetObj, Row, Col, Value){
//		alert(sheetObj + " :: "+ Row + " :: "+ Col + " :: "+ Value);
		var sCondition = new Array (
				new Array("MdmOrganization","SEARCH",Value)   //Office
			);   
		sheetObjects[0].WaitImageVisible = false;
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].WaitImageVisible = true;
	
		if(comboList[0] != null){
			operationOfc = "";
			for(var i = 0; i < comboList[0].length;i++){ 
	
				var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				operationOfc = operationOfc + code + "|";
			}
	
			operationOfc = operationOfc.substring(0, operationOfc.length - 1);
			sheetObjects[0].CellComboItem(Row, Col, operationOfc, operationOfc, 0);
	
		}else{
			ComShowCodeMessage("MNR00010", "Regional H/Q Office");
			sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"));
		}
	}
	
	/**
	 * 저장이벤트를 처리한다.
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBSAVE(sheetObj,formObj,sAction){
		MnrWaitControl(true);
		if(!validateForm(sheetObj,formObj,sAction)){
			MnrWaitControl(false);
			return;
		}
		formObj.f_cmd.value = MULTI;
		var sParam = ComGetSaveString(sheetObjects);
	
		if (sParam == "")
		{
			MnrWaitControl(false);
			return;
		}
		sParam += "&" + FormQueryString(formObj) ;
		var sXml = sheetObj.GetSaveXml("EES_MNR_0217GS.do", sParam);   
		sheetObjects[0].LoadSaveXml(sXml);  
	

	
	}
	
	/**
	 * sheet1에서 이미지버튼을 클릭한 경우 를 처리한다.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObject = document.form;
		with(sheetObj) {
			var sName = ColSaveName(Col);
			switch (sName) {
			case "cntc_usr_id":
				//alert(sheetObj.CellValue(Row, "ofc_cd"));
				ComOpenPopup("COM_ENS_091.do?ofc_cd="+ sheetObj.CellValue(Row, "ofc_cd"), 770, 580, 'setPopupParam', '0,0', true, false, Row, Col, 0);
				break;
			}
		}
	
	}
	
	/**
	 * popup된 창으로 부터 파라미터를 전달받는 함수
	 * @param aryPopupData
	 * @param Row
	 * @param Col
	 * @param SheetIdx
	 * @return
	 */
	function setPopupParam(aryPopupData, Row, Col, SheetIdx) {
		//alert( aryPopupData + "::"+ Row + "::"+ Col+ "::"+SheetIdx);
		var str = aryPopupData +"";
		var arr = str.split(',');
		var sheetObj =  sheetObjects[SheetIdx];
	
		sheetObj.CellValue2( Row, Col ) = arr[4];
		if(checkUsrId(arr[4], Row, Col)){
			sheetObj.CellValue( Row, ++Col ) = arr[5];
			sheetObj.CellValue( Row, ++Col ) = arr[6];
		}
	}
	
	/**
	 * 저장후에 로딩메시지
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */   
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		 var formObj=document.form;
		if (ErrMsg == "") { 
			ComShowCodeMessage("MNR00023");   
		} else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}       
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	/* 개발자 작업  끝 */