	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0137.js 
	 *@FileTitle : Standard Reefer Spare Parts List of the vsl
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.02
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 *  2009.08.25 권영법
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
	 * @class ees_mnr_0137 : ees_mnr_0137 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0137() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	//공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break; 
	
			case "btn_del":
				if(sheetObjects[0].FindCheckedRow("del_chk") == ""){ 
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
				if(ComShowCodeConfirm("MNR00026")){
					ComRowHideDelete(sheetObjects[0], "del_chk");
					calReq=0;
				}
	
				break;
			case "btn_add":
				doActionIBSheet(sheetObjects[0], formObject,IBINSERT);
				break;
			case "btn_new":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
	
			case "btn_downexcel":
				sheetObjects[0].SpeedDown2Excel();
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 420;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)
	
			var HeadTitle1 = "|Sel|Seq.|Unit Type|Part Name|Part No.|Type|Type A|Type B|Type C|Remark(s)";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,0,		daCenter,	true,	prefix+	"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,    40,      daCenter,   true,           "del_chk",          false,	"", 	dfNone,				0, 			true,  		true);
			InitDataProperty(0, cnt++ , dtDataSeq,	   40,		daCenter,	true,		    "Seq");
			InitDataProperty(0, cnt++ , dtCombo,	   80,	    daLeft,	    true,	prefix+	"spr_ut_tp_nm",		false,	"",		dfNone,				0,  		true,		true);
			InitDataProperty(0, cnt++ , dtData,		   200,		daLeft,		false,	prefix+	"spr_prt_nm",		false,	"",		dfNone,				0,			true,		true, 100);
			InitDataValid(   0,    cnt,  vtEngUpOther, "0123456789-");  
			InitDataProperty(0, cnt++ , dtData,		   120,		daCenter,	false,	prefix+	"spr_prt_no",		false,	"",		dfEngUpKey,			0,			false,		false, 30);
			InitDataProperty(0, cnt++ , dtCombo,	   80,	    daLeft,	    false,	prefix+	"spr_prt_spl_tp_cd",false,	"",		dfNone,				0,  		false,		false);       
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	false,	prefix+	"spr_prt_tp_flg1",	false,	"",		dfNone,				0,			true,		true,1,true,true,"",true);
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	false,	prefix+	"spr_prt_tp_flg2",	false,	"",		dfNone,				0,			true,		true,1,true,true,"",true);
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	false,	prefix+	"spr_prt_tp_flg3",	false,	"",		dfNone,				0,			true,		true,1,true,true,"",true);
			InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	false,	prefix+	"spr_prt_rmk",		false,	"",		dfNone,				0,			true,		true, 4000);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	prefix+	"spr_prt_qty",		false,	"",		dfNone,				0,			true,		true);
						
	
		}
		break;
	
		}
	}
	
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
	}
	
	
	/**
	 * 멀티 콤보 초기화 
	 * @return
	 */
	function initCombo() {
	
		var formObject = document.form
		with (formObject.combo_spr_ut_tp_nm) {
	
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("100");
			DropHeight = 160;
	
			Enable = true;
		}
	
		with (formObject.combo_spr_tp_cd) {
	
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("80");
			DropHeight = 160;
	
			Enable = true;
		}
	
	
	}
	
	
	
	
	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction)
		{
		case IBCLEAR:  //NEW
			MnrWaitControl(true);
			formObj.f_gubuns.value = "";
			formObj.cost_ofc_cd.value = currOfcCd;
			formObj.combo_spr_ut_tp_nm.Code2="-1";
			formObj.combo_spr_tp_cd.Code2="-1";
		
			formObj.combo_spr_ut_tp_nm.RemoveAll();
			formObj.combo_spr_tp_cd.RemoveAll();
			var sCondition = new Array (
					new Array("MnrGenCd","CD00009", "COMMON")	//Unit Type
					,new Array("MnrGenCd","CD00031", "CUSTOM8") // Spare Type 
					,new Array("MnrGenCd","CD00037", "COMMON") //Supply To	
			);   
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
			var sheetComboText = "";
			var sheetComboCode = "";
			var sheetComboCodeText = "";
			var sheetComboDefault = "";
			for(var i=0; i<comboList.length; i++)
			{	
				sheetComboText = "";
				sheetComboCode = "";
				sheetComboCodeText = "";
				sheetComboDefault = ""; 
				if(comboList[i] != null)
				{
					if(i==0){
						formObj.combo_spr_ut_tp_nm.InsertItem(0, "All" ," ");
					}else if(i==1){
						formObj.combo_spr_tp_cd.InsertItem(0, "All" ," ");
					}
					for(var j = 0; j < comboList[i].length;j++)
					{   
						var xmlVal = comboList[i][j].split("|");  
						if(i==0){
							formObj.combo_spr_ut_tp_nm.InsertItem(j+1, xmlVal[1] ,xmlVal[0]);
							sheetComboText +=  xmlVal[1] + "|";
							sheetComboCode +=  xmlVal[0] + "|";
							sheetComboCodeText +=  xmlVal[0] + "\t" + xmlVal[1] + "|";
							if(j ==0){	
								sheetComboDefault = xmlVal[0];      	
							}
						}else if(i==1){
							formObj.combo_spr_tp_cd.InsertItem(j+1, xmlVal[1] , xmlVal[0]);
						}else if(i==2){
							sheetComboText +=  xmlVal[1] + "|";
							sheetComboCode +=  xmlVal[0] + "|";
						}	
					}	
					if(i==0){
						sheetObjects[0].InitDataCombo (0, "sheet1_spr_ut_tp_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
					}else if(i==2){
						sheetObjects[0].InitDataCombo (0, "sheet1_spr_prt_spl_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				}
				else
				{
					if(i==0){
						ComShowCodeMessage("MNR00005", "EQ Type   ");
					}else if(i==1){
						ComShowCodeMessage("MNR00005", "Status    ");
					}
				}
			}					
			formObj.combo_spr_ut_tp_nm.Index=0;
			formObj.combo_spr_tp_cd.Index=0;
			sheetObjects[0].RemoveAll();
			MnrWaitControl(false);
			break;	
	
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad = 1;
			formObj.f_gubuns.value = "";
			sheetObjects[0].RemoveAll();
		
			formObj.f_cmd.value = SEARCH; 
			formObj.spr_prt_no.value="";
			formObj.spr_ut_tp_nm.value=formObj.combo_spr_ut_tp_nm.Code;
			formObj.spr_tp_cd.value=formObj.combo_spr_tp_cd.Code;
			formObj.spr_prt_spl_tp_cd.value='';
			
		
			var sParam = "";
			var aryPrefix = new Array("sheet1_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		
			var sXml   = sheetObj.GetSearchXml("EES_MNR_0137GS.do", sParam);
			arrDataSearchDbXml = sXml.split("|$$|");
		
			for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
				sheetObjects[i].Redraw = false;
				sheetObjects[i].WaitImageVisible = false;
				sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
				sheetObjects[i].Redraw = true; 
			}   
		
			break;		
		case IBINSERT:
			if(!validateForm(sheetObj,formObj,sAction))return;
			//MnrWaitControl(true);
			var row = sheetObj.DataInsert(-1);
			sheetObj.CellBackColor(row,"sheet1_spr_prt_no") = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
			sheetObj.CellEditable(row,"sheet1_spr_prt_no") = true;
			sheetObj.CellEditable(row,"sheet1_spr_prt_spl_tp_cd") = true;       		 
			sheetObj.CellValue2(row, "sheet1_spr_prt_qty") = "1";
			sheetObj.CellValue2(row, "sheet1_spr_ut_tp_nm") = "";
			sheetObj.SelectCell(row, "sheet1_spr_ut_tp_nm");
	
			break;
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			formObj.f_cmd.value = MULTI;
		
			var aryPrefix = new Array("sheet1_");
			var sParam = ComGetSaveString(sheetObjects, true, true);
			if (sParam == "")
			{
				MnrWaitControl(false);
				return false;
			}
		
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);
		
			//ComDebug(sParam);
			var sXml = sheetObj.GetSaveXml("EES_MNR_0137GS.do", sParam);
			sheetObjects[0].LoadSaveXml(sXml);
			break;
		}
	}
	
	
	
	/**
	 * 그리드 파트넘버(PART NO) 입력값에 대한 고유성검증 프로세스 처리
	 */
	function sheet1_spr_prt_no_UniqueCheck(sheetObj,formObj,Row){
		formObj.f_cmd.value = SEARCH; 
		formObj.spr_prt_no.value=sheetObj.CellValue(Row,"sheet1_spr_prt_no");
		formObj.spr_ut_tp_nm.value="";
		formObj.spr_tp_cd.value="";
		formObj.spr_prt_spl_tp_cd.value=sheetObj.CellValue(Row,"sheet1_spr_prt_spl_tp_cd");
		formObj.spr_work_type.value='check'; 
			
	
		var sParam = "";
		var aryPrefix = new Array("sheet1_");
	
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
	
		var sXml   = sheetObj.GetSearchXml("EES_MNR_0137GS.do", sParam);
		
		
	    if(!MnrIsEmptyXml(sXml)) {  
			return false;		          
	    }
		                   
	    return true;
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			//저장(확정)시
			if(sAction==IBSAVE)
			{
	
	
				//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
				var rCnt=sheetObj.RowCount;
				if(rCnt<=0)
				{
					//ComShowCodeMessage("MNR00072");
	
					return false;             	   
	
				}
	
				for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
				{
					//2.Unit Type를 Mandatory에 대한 체크를 수행 한다.
					var strSel =ComTrimAll(sheetObj.CellValue(i, "sheet1_spr_ut_tp_nm")," ");
					if(strSel=="")
					{
						ComShowCodeMessage("MNR00036","Unit Type");
						sheetObj.SelectCell(i, "sheet1_spr_ut_tp_nm",true);
						return false; 
					}
	
					//3.Part Name를 Mandatory에 대한 체크를 수행 한다.    				
					var strInput =ComTrimAll(sheetObj.CellValue(i, "sheet1_spr_prt_nm")," ");
					if(strInput=="")
					{
						ComShowCodeMessage("MNR00172","Part Name ");
						sheetObj.SelectCell(i, "sheet1_spr_prt_nm",true);
						return false; 
					}    				
					//4.Part No.를 Mandatory에 대한 체크를 수행 한다. 
					var strInput =ComTrimAll(sheetObj.CellValue(i, "sheet1_spr_prt_no")," ");
					if(strInput=="")
					{
						ComShowCodeMessage("MNR00172","Part No.");
						sheetObj.SelectCell(i, "sheet1_spr_prt_no",true);
						return false; 
					}  
	
					
					
					if(sheetObj.RowStatus(i) == 'I'  || sheetObj.RowStatus(i) == 'U')
					{
						if(!sheet1_spr_prt_no_UniqueCheck(sheetObj,formObj,i)){
							sheetObj.CellValue2(i,"sheet1_spr_prt_no") = "";   
							sheetObj.CellValue2(i,"sheet1_spr_prt_spl_tp_cd") = ""; 
							ComShowCodeMessage("MNR00006","Part No and Type");
							sheetObj.SelectCell(i, "sheet1_spr_prt_no",true);
							return false;   
						}
						
					}
	
					//6.Type A,Type B,Type C의 OPTION에 대한 체크를 수행 한다. 
					if(sheetObj.CellValue(i, "sheet1_spr_prt_spl_tp_cd")=="V"){
						var strFlg_1 =sheetObj.CellValue(i, "sheet1_spr_prt_tp_flg1");
						var strFlg_2 =sheetObj.CellValue(i, "sheet1_spr_prt_tp_flg2");
						var strFlg_3 =sheetObj.CellValue(i, "sheet1_spr_prt_tp_flg3");
						if(strFlg_1=="0" && strFlg_2=="0"  && strFlg_3=="0")
						{
							ComShowCodeMessage("MNR00239","Type A, Type B, Type C");
							sheetObj.SelectCell(i, "sheet1_spr_prt_tp_flg1",true);
							return false; 
						}  
					}
				}
	
			}
	
			//5.PART NO. DB및 입력값의  대한 중복체크를 수행 한다.     		
			var Row = sheetObj.ColValueDup("sheet1_spr_prt_no|sheet1_spr_prt_spl_tp_cd",false);
			if(Row>0){
				sheetObj.CellValue2(Row,"sheet1_spr_prt_no") = "";   
				sheetObj.CellValue2(Row,"sheet1_spr_prt_spl_tp_cd") = "";   

				ComShowCodeMessage("MNR00006","Part No and Type");
				sheetObj.SelectCell(i, "sheet1_spr_prt_no",true);
				return false;		
					
										
			}
			
			//조회시
			else if(sAction==IBSEARCH)
			{
				var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
				if(sRow != "") // sheet 수정내용 있음
				{                               	
					if(!ComShowCodeConfirm("MNR00007"))
					{
						return false;
					}
				}
			}
		}
	
	
	
	
		return true;
	}


	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_spl_tp_cd"){
			if(sheetObj.CellValue(Row, "sheet1_spr_prt_spl_tp_cd")=="V"){
				sheetObj.CellEditable(Row,"sheet1_spr_prt_tp_flg1") = true;
				sheetObj.CellEditable(Row,"sheet1_spr_prt_tp_flg2") = true;
				sheetObj.CellEditable(Row,"sheet1_spr_prt_tp_flg3") = true;
			}else{
				sheetObj.CellValue2(Row, "sheet1_spr_prt_tp_flg1")= "0";
				sheetObj.CellValue2(Row, "sheet1_spr_prt_tp_flg2")= "0";
				sheetObj.CellValue2(Row, "sheet1_spr_prt_tp_flg3")= "0";
				
				sheetObj.CellEditable(Row,"sheet1_spr_prt_tp_flg1") = false;
				sheetObj.CellEditable(Row,"sheet1_spr_prt_tp_flg2") = false;
				sheetObj.CellEditable(Row,"sheet1_spr_prt_tp_flg3") = false;
			}
		}
	}
			
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		var formObj = document.form;
		if(OldRow !=NewRow)
		{
			if (nowLoad != 0) return;
			if(sheetObj.CellValue(NewRow,"sheet1_ibflag")== "I"){ 
	
				sheetObj.CellBackColor(NewRow,"sheet1_spr_prt_no") = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
				sheetObj.CellEditable(NewRow,"sheet1_spr_prt_no") = true;
	
	
			}else
			{
				sheetObj.CellBackColor(NewRow,"sheet1_spr_prt_no") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);	
				sheetObj.CellEditable(NewRow,"sheet1_spr_prt_no") = false;
			}
			return;
	
	
		}	 	
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet1_";
		MnrWaitControl(false);
	
		nowLoad = 0;
		for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)	{
			if(sheetObj.CellValue(i, "sheet1_spr_prt_spl_tp_cd")=="V"){
				sheetObj.CellEditable(i,"sheet1_spr_prt_tp_flg1") = true;
				sheetObj.CellEditable(i,"sheet1_spr_prt_tp_flg2") = true;
				sheetObj.CellEditable(i,"sheet1_spr_prt_tp_flg3") = true;
			}else{
				sheetObj.CellEditable(i,"sheet1_spr_prt_tp_flg1") = false;
				sheetObj.CellEditable(i,"sheet1_spr_prt_tp_flg2") = false;
				sheetObj.CellEditable(i,"sheet1_spr_prt_tp_flg3") = false;
			}
		}
		
		formObj.spr_prt_no.value="";
		formObj.spr_ut_tp_nm.value="";
		formObj.spr_tp_cd.value="";
		formObj.spr_prt_spl_tp_cd.value="";
		formObj.spr_ut_tp_nm.value="";
		
	}     
	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") { 
	
				ComShowCodeMessage("MNR00009","Standard Reefer Spare Parts List");
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	
			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
		nowLoad = 0;
		MnrWaitControl(false);
	}	   
	
	
