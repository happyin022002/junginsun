	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0214.js 
	 *@FileTitle : Reefer Spare Part Inquiry_Pop Up
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
	 * @class ees_mnr_0214 : ees_mnr_0214 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0214() {
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
	
	
			case "btn_new":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
			case "btn_ok":
				if(sheetObjects[0].FindCheckedRow("sel_chk") == ""){ 
					ComShowCodeMessage("MNR00038","SELECT ");             	   
				} else {     
					if(window.dialogArguments != undefined)
					{
	
						var checkValue=sheetObjects[0].GetRangeText(sheetObjects[0].SelectRow, 1, sheetObjects[0].SelectRow,  sheetObjects[0].LastCol , "|", "^");

						window.dialogArguments.setPopUpParam_EES_MNR_0214(checkValue);
						self.close();
					}else{
						comPopupOK(); 	
					}
				}                                   
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
	
			// 높이 설정
			style.height = 200;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);
	
			var HeadTitle1 = "|SEL.|Seq.|Unit Type|Part Name|Part No.|Type A|Type B|Type C|Remark(s)";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,0,		daCenter,	true,	prefix+	"ibflag");
 	    	if(typeof(window.dialogArguments)!="undefined")
 	    	{
 	    		if(window.dialogArguments.document.form.sel_type.value=="M")
 	    			InitDataProperty(0, cnt++, dtCheckBox,        40,  daCenter,   true, "sel_chk");
 	    		else if(window.dialogArguments.document.form.sel_type.value=="S")
 					InitDataProperty(0, cnt++, dtRadioCheck,        40,  daCenter,   true, "sel_chk"); 			

 	    	}else{
 				InitDataProperty(0, cnt++, dtRadioCheck,        40,  daCenter,   true, "sel_chk");
 	    	}
			
			InitDataProperty(0, cnt++ , dtDataSeq,	   30,		daCenter,	true,		    "Seq");
			InitDataProperty(0, cnt++ , dtCombo,	   70,	    daLeft,	    true,	prefix+	"spr_ut_tp_nm",		        false,	"",		dfNone,		0,  false,false);
			InitDataProperty(0, cnt++ , dtData,		   190,		daLeft,		false,	prefix+	"spr_prt_nm",		false,	"",		dfNone,				0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		   90,		daCenter,	false,	prefix+	"spr_prt_no",		false,	"",		dfNone,				0,			false,		false);
			InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	false,	prefix+	"spr_prt_tp_flg1",		false,	"",		dfNone,				0,			false,		false,1,true,true,"",false);
			InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	false,	prefix+	"spr_prt_tp_flg2",		false,	"",		dfNone,				0,			false,		false,1,true,true,"",false);
			InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	false,	prefix+	"spr_prt_tp_flg3",		false,	"",		dfNone,				0,			false,		false,1,true,true,"",false);
			InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	false,	prefix+	"spr_prt_rmk",		false,	"",		dfNone,				0,			false,		false);
	
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
		MnrWaitControl(true);
		for(i=0;i<sheetObjects.length;i++)
		{
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		if(window.dialogArguments != undefined)
		{
			var formObject=document.form;
			formObject.combo_spr_ut_tp_nm.Code2=window.dialogArguments.sheetObjects[0].CellValue(window.dialogArguments.sheetObjects[0].SelectRow,"sheet1_spr_prt_ut_tp_nm");
			formObject.combo_spr_ut_tp_nm.Enable=false;
			formObject.spr_prt_spl_tp_cd.value=window.dialogArguments.document.form.combo_spr_prt_spl_tp_cd.Code;
			formObject.spr_prt_spl_tp_nm.value=window.dialogArguments.document.form.combo_spr_prt_spl_tp_cd.Text;
			if(window.dialogArguments.document.form.cost_ofc_cd!=undefined)
			{
				formObject.cost_ofc_cd.value=window.dialogArguments.document.form.cost_ofc_cd.value;
			}
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		}else{		
	
		}
		MnrWaitControl(false);
	}
	
	
	/**
	 * 멀티 콤보 초기화 
	 * @return
	 */
	function initCombo() {
	
		var formObject = document.form
		with (formObject.combo_spr_ut_tp_nm)
		{
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("100");
			DropHeight = 160;
	
			Enable = true;
		}
	
	
	
	}
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) 
		{
		case IBCLEAR:  //NEW
		MnrWaitControl(true);
		formObj.f_gubuns.value = "";
		formObj.cost_ofc_cd.value = currOfcCd;
		formObj.combo_spr_ut_tp_nm.RemoveAll();
		formObj.combo_spr_ut_tp_nm.Code2="-1";
		var sCondition = new Array (
				new Array("MnrGenCd","CD00009", "COMMON")	//Unit Type
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
				}
				for(var j = 0; j < comboList[i].length;j++)
				{   
					var xmlVal = comboList[i][j].split("|");
					sheetComboText +=  xmlVal[1] + "|";
					sheetComboCode +=  xmlVal[0] + "|";
					sheetComboCodeText +=  xmlVal[0] + "\t" + xmlVal[1] + "|";
					if(j ==0){	
						sheetComboDefault = xmlVal[0];      	
					}
					if(i==0){
						formObj.combo_spr_ut_tp_nm.InsertItem(j+1, xmlVal[1] ,xmlVal[0]);

					}
				}	
				if(i==0){
					sheetObjects[0].InitDataCombo (0, "sheet1_spr_ut_tp_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
				}
			}
			else
			{
				if(i==0){
					ComShowCodeMessage("MNR00005", "Unit Type   ");
				}
			}
		}				
		
		
		formObj.combo_spr_ut_tp_nm.Index=0;
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
		formObj.spr_ut_tp_nm.value=formObj.combo_spr_ut_tp_nm.Code;
	
		var sParam = "";
		var aryPrefix = new Array("sheet1_");
	
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
	
		//alert("IBSEARCH : " + "\n"+ sParam);
		var sXml   = sheetObj.GetSearchXml("EES_MNR_0214GS.do", sParam);
		arrDataSearchDbXml = sXml.split("|$$|");
	
		for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
			sheetObjects[i].Redraw = false;
			sheetObjects[i].WaitImageVisible = false;
			sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
			sheetObjects[i].Redraw = true;
		}   
	
		break;		
	
		}
	}
	
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
	
		return true;
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet1_";
		MnrWaitControl(false);
	
		nowLoad = 0;
	
	}     
	
	function sheet1_OnDblClick(sheetObj,Row,Col){
		if(window.dialogArguments != undefined)
		{

			var checkValue=sheetObjects[0].GetRangeText(Row, 1, Row,  sheetObj.LastCol , "|", "^");

			window.dialogArguments.setPopUpParam_EES_MNR_0214(checkValue);
			self.close();
		}
	
	}    
	
