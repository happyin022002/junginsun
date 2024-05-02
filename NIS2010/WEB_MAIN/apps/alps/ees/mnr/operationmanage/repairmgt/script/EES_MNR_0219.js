	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_mnr_0219.js 
	 *@FileTitle : Tire Purchase W/O Inquiry - Popup
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.08.18
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 * 2009.08.18 권영법
	 * 1.0 Creation
	=========================================================*/
	//공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;  
	
	//검증작업을 한데이타만 부모화면으로 이동가능
	var verifyCheck = false;      
	var retComboVal = "";  
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject = sheetObjects[0];
	//	var sheetObject2 = sheetObjects[1];
	//	var sheetObject3 = sheetObjects[2];
	//	var sheetObject4 = sheetObjects[3];	
	//	var sheetObject5 = sheetObjects[4];
	//	var sheetObject6 = sheetObjects[5];
	//	var sheetObject7 = sheetObjects[6];
	//	var sheetObject8 = sheetObjects[7];
	
	
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_FileImport": 
				sheetObject.LoadExcel(0, 1, "", -1, -1, "", false,false,"1=>4|2=>5|3=>6");
				for(var i = 1; i <= sheetObject.RowCount; i++){        
					sheetObject.RowStatus(i) = "R";  
					sheetObject.CellEditable(i,"checkbox") = false;          
				}                  
				break;     
	
			case "btn_new":
				doActionIBSheet(sheetObjects[0],formObject,IBCLEAR)
				break;
	
			case "btn_ok":
				if(sheetObject.FindCheckedRow("checkbox") == ""){ 
					ComShowCodeMessage("MNR00038","SELECT ");             	   
				} else if(!verifyCheck){  
					ComShowCodeMessage("MNR00157");          		 	  
				} else {     
					comPopupOK_219(sheetObject,formObject); 	
				}                                   
				break; 
	
			case "btn_Save":    
				doActionIBSheet(sheetObject, formObject, IBSAVE); 
				break;        
	
			case "btn_RowAdd":                  
				doActionIBSheet(sheetObject, formObject, IBINSERT);        
				break; 
	
			case "btn_RowDel":                     
				doActionIBSheet(sheetObject, formObject, IBDELETE);        
				break;        
	
			case "btn_close":    
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
	/** 
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){     
		comboObjects[comboCnt++] = combo_obj;  
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
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}
	
	
	/**
	 * 추가로 넘겨야 될값이 많아서 따로 구현한다.
	 */
	function comPopupOK_219(sheetObj,formObject) {
		var formObject = document.form; 
		if(formObject.combo_cost_dtl_cd.value == ""){
			ComShowCodeMessage("MNR00036","Cost Detail Code");    
			ComSetFocus(formObject.combo_cost_dtl_cd);     
			return false;
		}
	
	
	
		var rArray = new Array(); //행데이터를 담고 있는 배열
		var ret_val = new Array(); 
	
	
		ret_val[0] = formObject.combo_cost_dtl_cd.value;
	//	ret_val[1] =  ComGetObjValue(formObject.dmg_flag); 
	
		var sRow = sheetObj.FindCheckedRow("checkbox");
		//가져온 행을 배열로 반든다.          
		var arrRow = sRow.split("|");   
	
		for (idx=0; idx < arrRow.length - 1; idx++){     
			var cArray = new Array(); //열데이터를 담고 있는 배열
			cArray[0] = sheetObj.CellValue(arrRow[idx], "inp_msg1");
			cArray[1] = sheetObj.CellValue(arrRow[idx], "inp_msg2"); 
			cArray[2] = sheetObj.CellValue(arrRow[idx], "inp_msg3"); 
			cArray[3] = sheetObj.CellValue(arrRow[idx], "inp_msg6"); 
			cArray[4] = sheetObj.CellValue(arrRow[idx], "inp_msg7"); 
			cArray[5] = sheetObj.CellValue(arrRow[idx], "inp_msg8");  			
			rArray[idx] = cArray;                           
		}                   
		window.dialogArguments.setPopUpParam_EES_MNR_0219(rArray,ret_val);   //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
		window.close();                 
	}   
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
	
		var formObject=document.form;
		if(window.dialogArguments != undefined)
		{
	
			//hidden Text Setting
			if(window.dialogArguments.document.form.mnr_grp_tp_cd!=undefined)
			{
				formObject.mnr_grp_tp_cd.value=window.dialogArguments.document.form.mnr_grp_tp_cd.value;
	
			}
			if(window.dialogArguments.document.form.mnr_wo_tp_cd!=undefined)
			{
				formObject.mnr_wo_tp_cd.value=window.dialogArguments.document.form.mnr_wo_tp_cd.value;
	
			}
			if(window.dialogArguments.document.form.agmt_ofc_cty_cd!=undefined)
			{
				formObject.agmt_ofc_cty_cd.value=window.dialogArguments.document.form.agmt_ofc_cty_cd.value;
	
			}
	
			if(window.dialogArguments.document.form.agmt_seq!=undefined)
			{
				formObject.agmt_seq.value=window.dialogArguments.document.form.agmt_seq.value;
	
			}
			if(window.dialogArguments.document.form.agmt_ver_no!=undefined)
			{
				formObject.agmt_ver_no.value=window.dialogArguments.document.form.agmt_ver_no.value;
	
			}     
	
			if(window.dialogArguments.document.form.cost_ofc_cd!=undefined)
			{
				formObject.cost_ofc_cd.value=window.dialogArguments.document.form.cost_ofc_cd.value;
			}
	
			//Text Setting        	
			if(typeof(window.dialogArguments.document.form.combo_eq_knd_cd)!="undefined")
			{
	
				formObject.eq_knd_cd_text.value=window.dialogArguments.document.form.combo_eq_knd_cd.Text;
				formObject.eq_knd_cd.value=window.dialogArguments.document.form.combo_eq_knd_cd.Code;
				formObject.eq_type.value=window.dialogArguments.document.form.combo_eq_knd_cd.Code;
			}
	
			if(typeof(window.dialogArguments.document.form.combo_cost_cd)!="undefined")
			{
	
				formObject.cost_cd_text.value=window.dialogArguments.document.form.combo_cost_cd.Text;
				formObject.cost_cd.value=window.dialogArguments.document.form.combo_cost_cd.Code;
	
			}
			if(typeof(window.dialogArguments.document.form.combo_vndr_seq)!="undefined")
			{
	
				formObject.vndr_seq.value=window.dialogArguments.document.form.combo_vndr_seq.Code;
	
			}
		}
		MnrWaitControl(true); 
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	
			//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
		}
	
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}   
		doActionIBSheet(sheetObj,document.form,IBCLEAR);
	
	}
	
	function initCombo() {
		if(window.dialogArguments!=undefined)
		{
			if(window.dialogArguments.document.form.combo_cost_cd!=undefined)
			{
				var costtype=window.dialogArguments.document.form.combo_cost_cd.Code;
				var formObj = document.form;
				//콤보조회
				var sheetObj = sheetObjects[0];
				var sCondition = new Array (
						new Array("MnrGenCd",costtype, "COMMON") //Extra Expense Type Combo 	
				);
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				//쉬트 설정
				var sheetComboText = "";
				var sheetComboCode = "";
				var sheetComboCodeText = "";
				var sheetComboDefault = "";
				for(var i = 0; i < comboList.length;i++){
					//쉬트콤보별 초기화
					sheetComboText = "";
					sheetComboCode = "";
					sheetComboCodeText = "";
					sheetComboDefault = ""; 
					if(comboList[i] != null){
						for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");   
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							if(j ==0){	
								sheetComboDefault = tempText[0];      	
							}
							if(i==0) {
								var new_option = new Option(tempText[1],tempText[0]);
								formObj.combo_cost_dtl_cd.add(new_option,formObj.combo_cost_dtl_cd.length);
							}
						}
					}
				}
			}
		}
		
	}
	
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		with (sheetObj) { 
	
			// 높이 설정  
			style.height = 282;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;  
	
			//전체Edit 허용 여부 [선택, Default false] 
			Editable = true;             
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100); 
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(13, 0, 0, true);        
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)
	
			var HeadTitle = "|Sel|Del|Seq|EQ No.|Yard|Work Date|System Verify Result||||||";
			//var HeadTitle = "|Sel|DSeq|EQ No.|Yard|Work Date|System Verify Result|";	 	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true); 
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	false,   	"ibflag"); 
			InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,   "checkbox",     false,          "",      dfNone,		0,			true,		true);           
			InitDataProperty(0, cnt++ , dtDummyCheck,   40,    daCenter,  false,   "del_check",     false,          "",      dfNone,		0,			true,		true);               
	
	
			InitDataProperty(0, cnt++ , dtDataSeq,    40,    daCenter,  true,    "Seq",     false,          "",      dfNone);
			InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  false,     "inp_msg1",     true,          "",      dfNone,		0,			true,		true,	11,	false);      
			InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,     "inp_msg2",     true,        "",      dfNone,		0,			true,		true,	7,	true); 
			InitDataProperty(0, cnt++ , dtData,      170,    daCenter,  false,     "inp_msg3",     true,       "",      dfDateYmd,		0,			true,		true);    
	
			InitDataProperty(0, cnt++ , dtData,      65,    daLeft,     false,     "inp_msg5",     false,        "",      dfNone,		0,			false,		false);               
			InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg4",	   false,		"",		 dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg6",	   false,		"",		 dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg7",	   false,		"",		 dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg8",	   false,		"",		 dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,	 80,	daLeft,		true,	   "inp_msg9",	   false,		"",		 dfNone,		0,			false,		false);
	
			InitDataValid(0,  "inp_msg1", vtEngUpOther,"0123456789"); 
			InitDataValid(0,  "inp_msg2", vtEngUpOther,"0123456789"); 
	
			//SELECT 로우 배경색                  
			//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
			EditableColorDiff = false;     
			MultiSelection = true;                                    
			SelectionMode = smSelectionRow;  
			//선택시 하이라이트사용하지 않음            
			SelectHighLight = false;           
			//선택시 볼드 사용하지 않음             
			CountPosition = 0;             
		}
		break;  
		}  
	}
	
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction))return;
			formObj.f_cmd.value = MULTI;   
			formObj.cost_dtl_cd.value = formObj.combo_cost_dtl_cd.value;
			for(var i = 1; i <= sheetObj.RowCount; i++){
				sheetObj.RowStatus(i) = "I";      
			}          
			var sParam = sheetObj.GetSaveString(false, true); 
			if (sParam == "") return;
			sParam += "&" + FormQueryString(formObj);  
			var sXml = sheetObj.GetSaveXml("EES_MNR_0219GS.do", sParam);
			sheetObj.LoadSaveXml(sXml); 
		
			//체크된 로우에 색상을 입힌다.     
			for(var i = 1; i <= sheetObj.RowCount; i++){  
				if(sheetObj.CellValue(i,"checkbox") == 1){    
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);	
					//success 된것은 수정하지 못하게 한다.
					sheetObj.CellEditable(i,"inp_msg1") = false;
					sheetObj.CellEditable(i,"inp_msg2") = false;
					sheetObj.CellEditable(i,"inp_msg3") = false; 
				} else {                 
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);         
					//실패한건은 선택할수 없다. 
					sheetObj.CellEditable(i,"checkbox") = false;
				}
			}
			verifyCheck = true;
			//verifyCheck에 사용된 eqtype을 저장한다. 
		
			break;
	
		case IBINSERT:  // ROWADD                   
			var Row = sheetObj.DataInsert(-1); 
			sheetObj.CellValue2(Row,"inp_msg3") = ComGetNowInfo("ymd"); 
			sheetObj.CellEditable(Row,"checkbox") = false; 
			verifyCheck = false;                       
			break; 
	
		case IBDELETE:  // ROWDELETE   
			for(var i = sheetObj.RowCount; i > 0; i--){  
				if(sheetObj.CellValue(i,"del_check") == 1){
					sheetObj.RowDelete(i, false);                     	
				}     	
			}           
			break;
			
		case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
			MnrWaitControl(true);
		
			sheetObj.WaitImageVisible=false;
		
			//콤보데이타 초기화  
			for(var i = 0; i < comboObjects.length;i++){ 
				comboObjects[i].RemoveAll(); 	
			}     
		
			initCombo();							 
			//쉬트 초기화
			sheetObj.RemoveAll();  
			verifyCheck = false;  
			sheetObj.WaitImageVisible=true;
			MnrWaitControl(false);  
		
		
			break; 			
	
	
		}
	}
	
	
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
	
	
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	
	
	}
	
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		 with(formObj){
				//추가시
				if(sAction==IBSAVE)
				{
					if(formObj.combo_cost_dtl_cd.value == ""){
						ComShowCodeMessage("MNR00036","Service Sub Type");
						ComSetFocus(formObj.combo_cost_dtl_cd);
						return false;
					}
				}
		 }
		return true;
	}
	
	/**  
	 * combo1 체크박스 이벤트      
	 * @param	{IBSheet}		sheetObj	콤보오브젝트  
	 * @param 	{String} 			Row 		Row 
	 * @param 	{String} 			Col 		Col 
	 */  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){  
		if(sheetObj.ColSaveName(Col) == 'checkbox')    
		{
			if(sheetObj.CellValue(Row,Col) != 1){                   
				sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
	
			} else {                            
				sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);  
				sheetObj.CellValue2(Row,"inp_msg5") = "";            
				sheetObj.CellEditable(Row,"checkbox") = false;                
				sheetObj.CellEditable(Row,"inp_msg1") = true; 
				sheetObj.CellEditable(Row,"inp_msg2") = true; 
				sheetObj.CellEditable(Row,"inp_msg3") = true;       
				verifyCheck = false;        
			} 
		}				
	} 
	
	//저장후 결과메세지 표시
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){ 
		if (ErrMsg == "") {   
			ComShowCodeMessage("MNR00158");         
		} else { 
			ComShowCodeMessage("MNR00159",ErrMsg);   
		}       
	}
