	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0135.jsp
	 *@FileTitle : Equipment Repair Approval Authority Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.22
	 *@LastModifier : 정영훈
	 *@LastVersion : 1.1
	 * 2009.06.22 정영훈
	 * 2009.10.16 권영법
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
	 * @class ees_mnr_0135 : ui_mnr_0135 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0135() {
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
	
	var nowLoad = 0;
	
	var regionalHQ = "";
	var operationOfc = "";
	var upperOfc = "";
	var cost_cdCode = "";
	var cost_cdDesc = "";
	var equipmentKindCode = "";
	var equipmentKindDesc = "";
	var currencyKindCode = "";
	var currencyKindDesc = "";
	var HOOfc = "";	
	var initLoader = 0;
	
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	document.onclick = processButtonClick;
	
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가  지정 *****/
		var sheetObject = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
			case "btn_Retrive":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
	
			case "btn_New":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
	
	
			case "btn_Excel":
				sheetObjects[0].SpeedDown2Excel(-1);
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
			SetColWidth("100|150");    
			DropHeight = 160;
	
		} 
		with (formObject.combo2) { 
			MultiSeparator = "|";
			SetTitle("Office Code|Office Name");
			//MultiSelect = false;
			SetColAlign("left|left");        
			SetColWidth("100|150");    
			DropHeight = 160; 
	
		} 
		with (formObject.combo3) { 
			MultiSeparator = "|";
			//SetTitle("Equipment Code|Equipment Name");
			//MultiSelect = false;
			SetColAlign("left|left");        
			SetColWidth("100|0");    
			DropHeight = 160; 
	
		} 
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		MnrWaitControl(true);
		var formObject = document.form;
	
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		sheetObjects[0].WaitImageVisible = false;
		initCombo();    
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		sheetObjects[0].WaitImageVisible = true;
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
	
			sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("uppr_ofc_cd"), result, result, result.substring(0,result.indexOf("|")) );
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
	
				style.height = 435;
	
				SheetWidth = mainTable.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly;
				Editable = true;
	
				InitRowInfo( 2, 1, 10, 100);
	
				InitColumnInfo(12, 0, 0, true);
	
				InitHeadMode(true, true, false, true, false,false)
	
				var HeadTitle1 = "|Seq.|Regional\nH/Q|Operation\nOffice|Upper\nOffice|Equipment \nType|Currency|Effective \nFrom Date|After Effective Date|After Effective Date|Before Effective Date|Before Effective Date";
				var HeadTitle2 = "|Seq.|Regional\nH/Q|Operation\nOffice|Upper\nOffice|Equipment \nType|Currency|Effective \nFrom Date|Group\nApproval|Self\nAuthority|Group\nApproval|Self\nAuthority";
	
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
	
				//   [ROW, COL,  DATATYPE,                             WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,     	     40,	    daCenter,	   false,	    "ibflag");
	
				//InitDataProperty(0, cnt++ , dtCheckBox,		         30,	    daCenter,	   true,		"del_chk");
				InitDataProperty(0, cnt++ , dtSeq,                         30,       daCenter,    true,       "Seq");
	
				InitDataProperty(0, cnt++ , dtData,					    80,	    daCenter,	   true,		"ar_hd_qtr_ofc_cd",			false,	"",		dfNone,				0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,				        80,	    daCenter,	   true,		"ofc_cd",			            false,	"",		dfNone,				0,			false,		false);
	
				InitDataProperty(0, cnt++ , dtData,				        80,	    daCenter,	   true,		"uppr_ofc_cd",				false,	"",		dfNone,				0,			false,		false);
				InitDataProperty(0, cnt++ , dtCombo,					     150,		daCenter,	   true,		"cost_cd",				        false,	"",		dfNone,				0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,					     80,		daCenter,	   true,		"curr_cd",				        false,	"",		dfNone,				0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		                 90,	    daCenter,	   true,		"eff_dt",	                    false,	"",		dfDateYmd,		    0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,					     90,		daRight,	   false,	     "aft_auto_apro_amt",		false,	"",		dfFloat,	            2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,					     90,		daRight,	   false,	     "aft_self_auth_amt",		false,	"",		dfNullFloat,	        2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,					     90,		daRight,	   false,	     "bfr_auto_apro_amt",		false,	"",		dfFloat,	            2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,					     90,		daRight,	   false,	     "bfr_self_auth_amt",		false,	"",		dfNullFloat,	        2,			false,		false);
	
				//InitDataProperty(0, cnt++ , dtHidden,					     100,		daLeft,	   false,	     "org_ofc_cd",	        	    true,	"",		dfNone,	        2,			true,		true);
				//InitDataProperty(0, cnt++ , dtHidden,					     100,		daLeft,	   false,	     "org_mnr_grp_tp_cd",	       	true,	"",		dfNone,	        2,			true,		true);
				//InitDataProperty(0, cnt++ , dtHidden,					     100,		daLeft,	   false,	     "org_cost_cd",	        	    true,	"",		dfNone,	        2,			true,		true);
	
				//SELECT 로우 배경색       
				SelectionMode = smSelectionRow;    
				SelectHighLight = true;            
				SelectFontBold = false;          
				SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
	
				PopupImage  =  "img/btns_calendar.gif"; 
				ShowButtonImage = 2;
			}
			break;
	
		}
	}
	
	// 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		case IBSEARCH:      //조회
		doIBSEARCH(sheetObj,formObj,sAction);
		break;
	
		case IBCLEAR:
			doIBCLEAR(sheetObj,formObj,sAction);
			break;				
	
		}
	}
	
	/**
	 * IBSEARCH이벤트를 처리하는 경우
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBSEARCH(sheetObj,formObj,sAction){
		MnrWaitControl(true);
		sheetObjects[0].Redraw = false;    
		sheetObjects[0].WaitImageVisible = false;	
		formObj.f_cmd.value = SEARCH;
		//alert(FormQueryString(formObj));
		var sXml = sheetObj.GetSearchXml("EES_MNR_0135GS.do",  FormQueryString(formObj));
		//alert(sXml);
	
		sheetObjects[0].LoadSearchXml(sXml); 
		sheetObjects[0].Redraw = true; 
	
	
	}
	
	function doIBCLEAR(sheetObj,formObj,sAction){
		nowLoad = 1;
		MnrWaitControl(true);
    	ComOpenWait(true);
		//alert( formObj.combo1.GetCount() + " >>>>"+  formObj.combo2.GetCount() + ">>>>"+  formObj.combo3.GetCount());
		if(initLoader == 0){
			//콤보데이타 초기화
			currencyKindCode="";
			currencyKindDesc="";
			cost_cdCode="";
			cost_cdDesc="";
			formObj.combo1.removeAll();
			formObj.combo2.removeAll();
			formObj.combo3.removeAll();
	
			//Combo 세팅 
			var sCondition = new Array (
					new Array("MnrGenCd"   ,  "HOOFC", "COMMON") //HOofc 
					,new Array("MdmCurrency",       "", "COMMON") //currency combo
					,new Array("MnrGenCd"   ,"CD00015", "COMMON") //cost_cd combo
					,new Array("MdmOrganization","RHQ","FALSE")   //Regional HQ
			);   
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
			regionalHQ="";
			for(var i=0; i<comboList.length; i++)
			{	
				if(comboList[i] != null)
				{
					for(var j = 0; j < comboList[i].length;j++)
					{   
						var xmlVal = comboList[i][j].split("|");  
						if(i==0){
							HOOfc = xmlVal[0];
						}else if(i==1){
							currencyKindCode = currencyKindCode + xmlVal[0] + "|";
							currencyKindDesc =  currencyKindDesc + xmlVal[0]+"\t"+xmlVal[1] + "|";
						}else if(i==2){
							formObj.combo3.InsertItem(j, xmlVal[1] , xmlVal[0]);
							cost_cdCode = cost_cdCode + xmlVal[0] + "|";
							cost_cdDesc =  cost_cdDesc + xmlVal[1] + "|";
						}else if(i==3){
							formObj.combo1.InsertItem(j, comboList[i][j] ,  xmlVal[0]);
							formObj.combo1.Code =  xmlVal[0];
							regionalHQ = regionalHQ +  xmlVal[0] + "|";
						}
					}	
					if(i==1){
						sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("curr_cd"),  currencyKindDesc,  currencyKindCode, currencyKindCode.substring(0,currencyKindCode.indexOf("|")) );
	
					}else if(i==2){
						formObj.combo3.InsertItem(0, "ALL" , "ALL");
						formObj.combo3.Code = "ALL";
						sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("cost_cd"),  cost_cdDesc,  cost_cdCode, cost_cdCode.substring(0,cost_cdCode.indexOf("|")) );
					}else if(i==3){
						formObj.combo1.InsertItem(0, "ALL" , "ALL");
			
						regionalHQ = regionalHQ.substring(0, regionalHQ.length - 1);
						//alert(HOOfc + " :: "+ currOfcCd + " :: "+rhqOfcCd);
						if(HOOfc != currOfcCd){
							formObj.combo1.Enable = false;
							formObj.combo1.Code = rhqOfcCd;
							formObj.combo2.Code = "ALL";
							regionalHQ = 	currOfcCd ;
						}else{
							formObj.combo1.Code = "ALL";
							formObj.combo2.Code = "ALL";
						}					
					}
				}
				else
				{
					if(i==0){
						HOOfc =  "";
					}else if(i==1){
						ComShowCodeMessage("MNR00005", "Currency Code  ");
					}else if(i==2){
						ComShowCodeMessage("MNR00005", "Class Type (COST_CD) Code  ");
					}else if(i==3){
						ComShowCodeMessage("MNR00005", "Regional HQ Code  ");
					}
				}
			}			
	
			comboOnChange(formObj.combo1,formObj.combo1.Text, formObj.combo1.Text);
			initLoader = 1;		
		}
	
		//쉬트 초기화
		sheetObj.RemoveAll(); 
	
		sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"), regionalHQ, regionalHQ, regionalHQ.substring(0,regionalHQ.indexOf("|")) );
	
		initOperationOfc();
	
		formObj.combo2.Code = "ALL";
		formObj.combo3.Code = "ALL";
		nowLoad = 0;   
		ComOpenWait(false);
		MnrWaitControl(false);
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
		//alert(HOOfc + " :: " + currOfcCd);
		sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd"), formObj.combo1.Code, formObj.combo1.Code, formObj.combo1.Code);
	
		if(HOOfc != currOfcCd){ 
			sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = rhqOfcCd;
			cellSetItems(sheetObjects[0], iRow, sheetObjects[0].SaveNameCol("ofc_cd"),   sheetObjects[0].CellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
			sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ofc_cd")) = "";
			sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("uppr_ofc_cd")) = "";
			sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("curr_cd")) = "USD";
			if(formObj.combo3.Code == "ALL"){
				sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("cost_cd")) = "";
			}else{
				sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("cost_cd")) = formObj.combo3.Code;
			}
		}else{
			sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = formObj.combo1.Code;
			cellSetItems(sheetObjects[0], iRow, sheetObjects[0].SaveNameCol("ofc_cd"),   sheetObjects[0].CellValue(iRow,  sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")));
			sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("ofc_cd")) = "";
			sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("uppr_ofc_cd")) = "";
			sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("curr_cd")) = "USD";
			if(formObj.combo3.Code == "ALL"){
				sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("cost_cd")) = "";
			}else{
				sheetObjects[0].CellValue2(iRow,  sheetObjects[0].SaveNameCol("cost_cd")) = formObj.combo3.Code;
			}
		}
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
		sheetObjects[0].WaitImageVisible = false;
    	ComOpenWait(true);
		if(Index_Code=="ALL")Index_Code="%";
		var sCondition = new Array (
				new Array("MdmOrganization","SEARCH",Index_Code)   //Office
			);   
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
	
		if(comboList[0] != null){
			for(var i = 0; i < comboList[0].length;i++){ 
				var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				formObj.combo2.InsertItem(i, comboList[0][i] , code);
				formObj.combo2.Code = code;
			}
			formObj.combo2.InsertItem(0, "ALL" , "ALL");
			formObj.combo2.Code = "ALL";
		}
		sheetObjects[0].WaitImageVisible = true;
    	ComOpenWait(false);

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
	function  checkUpprOfc(strofc, Row, Col){
		//alert(strofc+"||"+Row+"||"+Col);
		var result  = "";
		var sCondition = new Array (
				new Array("MdmOrganization","SEARCH","NOTHQ")   //Office
			);   
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		var chkofc = false;
		if(comboList[0] != null){
			for(var i = 0; i < comboList[0].length;i++){ 
				var strcbo = comboList[0][i].split('|');
				if(strcbo[0] == strofc ){
					chkofc = true;
					break;
				}
			}
	
			if(chkofc != true){
				ComShowCodeMessage("MNR00010", "Upper Office");
				sheetObjects[0].CellValue2(Row, sheetObjects[0].SaveNameCol("uppr_ofc_cd")) = "";
				sheetObjects[0].SelectCell(Row, sheetObjects[0].SaveNameCol("uppr_ofc_cd"));
			}
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
	 * operation office 필드의 combo필드의 데이터를 입력한다.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function cellSetItems(sheetObj, Row, Col, Value){
		// alert(sheetObj + " :: "+ Row + " :: "+ Col + " :: "+ Value);
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
	 * sheet1에서 발생하는 OnChange이벤트를 처리한다.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
	
		if(sheetObj.ColSaveName(Col) == "ar_hd_qtr_ofc_cd"){
	
			if(HOOfc != currOfcCd){
	
				sheetObj.CellValue2(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")) = currOfcCd;
				cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), currOfcCd);
			}else{
				// Operation Office에 값을 넣는다.
				cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ofc_cd"), Value);
			}  
	
	
		}else if(sheetObj.ColSaveName(Col) == "ofc_cd"){
			checkOperationOfc(sheetObj.CellValue(Row, sheetObjects[0].SaveNameCol("ar_hd_qtr_ofc_cd")), sheetObj.CellValue(Row, Col), Row, Col);
	
		}else if(sheetObj.ColSaveName(Col) == "uppr_ofc_cd"){
			checkUpprOfc(sheetObj.CellValue(Row, Col), Row, Col);
	
		}
	
	}   
	function sheet1_OnPopupClick(sheetObj, Row,Col,Value)
	{
		var formObject = document.form;
		with(sheetObj) {
			var sName = ColSaveName(Col);
			switch (sName) {
			case "eff_dt":
				var cal = new ComCalendarGrid("myCal");
				cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
				break;
			}
		}
	}

	/**
	 * 저장후에 로딩메시지
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */   
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") { 
			ComShowCodeMessage("MNR00023");   
		} else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}       
		MnrWaitControl(false);
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		MnrWaitControl(false); 
	}			    
	
	
	/* 개발자 작업  끝 */