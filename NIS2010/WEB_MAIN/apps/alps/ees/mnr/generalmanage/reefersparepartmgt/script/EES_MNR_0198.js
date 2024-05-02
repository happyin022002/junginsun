	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0198.js 
	 *@FileTitle : Reefer Spare Kit Type Inquiry_Pop Up
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
	 * @class ees_mnr_0198 : ees_mnr_0198 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0198() {
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
			style.height = 260;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);
	
			var HeadTitle1 = "|Seq.|Unit Type|Part Name|Part No.|Type A|Type B|Type C|Remark(s)";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,0,		daCenter,	true,	prefix+	"ibflag");
			InitDataProperty(0, cnt++ , dtDataSeq,	   40,		daCenter,	true,		    "Seq");
			InitDataProperty(0, cnt++ , dtCombo,	   80,	    daLeft,	    true,	prefix+	"spr_ut_tp_nm",		        false,	"",		dfNone,		0,  false,false);
			InitDataProperty(0, cnt++ , dtData,		   200,		daLeft,		false,	prefix+	"spr_prt_nm",		false,	"",		dfNone,				0,			 false,false);
			InitDataProperty(0, cnt++ , dtData,		   120,		daCenter,	false,	prefix+	"spr_prt_no",		false,	"",		dfNone,				0,			 false,false);
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	false,	prefix+	"spr_prt_tp_flg1",		false,	"",		dfNone,				0,		 false,false,1,true,true,"",false);
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	false,	prefix+	"spr_prt_tp_flg2",		false,	"",		dfNone,				0,		 false,false,1,true,true,"",false);
			InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	false,	prefix+	"spr_prt_tp_flg3",		false,	"",		dfNone,				0,		 false,false,1,true,true,"",false);
			InitDataProperty(0, cnt++ , dtData,		100,		daCenter,	false,	prefix+	"spr_prt_rmk",		false,	"",		dfNone,				0,			 false,false);
	
		}
		break;
	
		}
	}
	

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		case IBCLEAR:  //NEW
			MnrWaitControl(true);
			formObj.f_gubuns.value = "";
			formObj.cost_ofc_cd.value = currOfcCd;
			formObj.combo_spr_tp_cd.Code2="-1";
			formObj.combo_spr_tp_cd.RemoveAll();
			//콤보조회
			var sCondition = new Array (
				new Array("MnrGenCd","CD00031", "CUSTOM8") //Spare Type			
				,new Array("MnrGenCd","CD00009", "COMMON")  //Unit Type Sheet Combo 
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
					if(i==0)
					{
						formObj.combo_spr_tp_cd.InsertItem(0, "All", " ");
					}
					for(var j = 0; j < comboList[i].length;j++){ 
						var tempText = comboList[i][j].split("|");   
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
						if(j ==0){	
							sheetComboDefault = tempText[0];      	
						}
						if(i==0) {
							formObj.combo_spr_tp_cd.InsertItem(j+1, tempText[1] ,tempText[0]);
						}
					}
					if(i==0){
						formObj.combo_spr_tp_cd.Index=0;
					}

					//쉬트 콤보 설정
					if(i == 0) {
						sheetObjects[0].InitDataCombo(0, "sheet1_spr_ut_tp_nm", sheetComboText, sheetComboCode, sheetComboDefault);
					}
				}
			}
			
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
			formObj.spr_tp_cd.value=formObj.combo_spr_tp_cd.Code;
			var sParam = "";
			var aryPrefix = new Array("sheet1_");
		
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		
			//alert("IBSEARCH : " + "\n"+ sParam);
			var sXml   = sheetObj.GetSearchXml("EES_MNR_0198GS.do", sParam);
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
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
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
		with (formObject.combo_spr_tp_cd) {
	
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("80");
			DropHeight = 160;
	
			Enable = true;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet1_";
		MnrWaitControl(false);
		nowLoad = 0;
	}     
	
