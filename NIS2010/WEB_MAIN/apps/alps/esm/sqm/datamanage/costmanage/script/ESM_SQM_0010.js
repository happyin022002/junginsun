/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0010.js
*@FileTitle      : NEW Lane/Office CMCB
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0010 : ESM_SQM_0010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0010() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var clickParam = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;
			case "btn_Retrieve1":
				doActionIBSheet(sheetObj1,formObj,IBSEARCH);
				break;
			case "btn_Save1":
				doActionIBSheet(sheetObj1,formObj,IBSAVE);
				break;
			case "btn_Creation":
				doActionIBSheet(sheetObj1,formObj,COMMAND01);
				break;
			case "btn_Save2":
				doActionIBSheet(sheetObj2,formObj,COMMAND02);
				break;
			case "btn_Retreive2":
				doActionIBSheet(sheetObj2,formObj,IBSEARCH_ASYNC01);
				break;

				break;
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
	var formObject  = document.form;
	loadingMode = true;

	doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);

	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}

	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	toggleButtons("INIT");
	setTradeCombo();
	loadingMode = false;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {

				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				var HeadTitle1 =  "SEL|STS|SEQ|Trade|Lane Bound|New Lane|Copy Source|flg|saveflg";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1)+1, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(false, false, false, true, false, false);

				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(5);

				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	true,	"sel",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,		daCenter,	true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtComboEdit,	100,	daCenter,	true,	"src_rlane_cd",	true,	"",	dfNone,	0,	true,	false,	5);
				InitDataProperty(0,	cnt++,	dtHidden,		30,		daCenter,	true,	"flg",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		30,		daCenter,	true,	"saveflg",		false,	"",	dfNone,	0,	false,	false);


                InitDataValid(0,"src_rlane_cd",vtEngUpOnly );

			}
			break;
		case 2:		//sheet1 init
			with (sheetObj) {

				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 14, 100);

				var HeadTitle1 =  "STS|SEQ||||Office View|Lane\nBound|Trade|New\nLane|RHQ|Office|Original CM cost UC|Original CM cost UC|Original CM cost UC|Revised CM cost UC|Revised CM cost UC|Revised CM cost UC";
				var HeadTitle2 =  "STS|SEQ||||Office View|Lane\nBound|Trade|New\nLane|RHQ|Office|CMCB(PA)|CMCB(RA)|PA-RA|CMCB(PA)|CMCB(RA)|PA-RA";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(false, false, false, true, false, false);

				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(9);

				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,	daCenter,	true,	"ibflag",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,	daCenter,	true,	"seq",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,	daCenter,	true,	"bse_tp_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		60,	daCenter,	true,	"bse_yr",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,	daCenter,	true,	"bse_qtr_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"ofc_vw_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"trd_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,	daCenter,	true,	"dir_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"rlane_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"rhq_cd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"rgn_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"gid_pa_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"gid_ra_cm_uc_amt",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"gid_diff",			false,	"|gid_pa_cm_uc_amt|-|gid_ra_cm_uc_amt|",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"pa_cm_uc_amt",		false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"ra_cm_uc_amt",		false,	"",	dfInteger,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			80,	daRight,	true,	"cm_diff",			false,	"|pa_cm_uc_amt|-|ra_cm_uc_amt|",	dfInteger,	0,	false,	false);


			}
			break;
	}
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	switch(comboObj.id) {
	case "f_bse_yr":
	case "f_bse_qtr_cd":
		with (comboObj) {
			DropHeight = 300;
		}
		break;

	case "f_ofc_vw_cd":
		with (comboObj) {
			DropHeight = 300;
			Index      = 1;
		}
		break;
	default:
		with (comboObj) {
			DropHeight = 300;
			Index      = 0;
		}
		break;
	}
}

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBCLEAR:          //조회
			sheetObj.WaitImageVisible = false;

			ComOpenWait(true);

			formObj.f_cmd.value = INIT;

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0010GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_dir_cd, "code", "name");

			ComOpenWait(false);
			break;

		case IBSEARCH:          // 화면1 조회 시
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0010GS.do", searchParams);
			sheetObj.LoadSearchXml(rtnXml);
			ComOpenWait(false);

			sheetObjects[1].RemoveAll();
			break;


		case IBSAVE:          // 화면 저장시
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			var saveStr = sheetObj.GetSaveString(false, true, "ibflag");

			if ( saveStr == "" ) {
				return;
			}
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
			    return false;
			} else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
			}
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			sheetObj.DoSave("ESM_SQM_0010GS.do", searchParams, -1, false);

			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			ComOpenWait(false);
			if (State == "S") {
				ComShowCodeMessage("SQM00001", "Data");
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}else{
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}

			break;


		case COMMAND01:          // creation
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
				return false;
		    }

			ComOpenWait(true);

			ComSetSearchParams("f_cmd", MULTI01);
			var sParam 	= sheetObj.GetSaveString(false, true, "sel");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0010GS.do", searchParams + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			var msg = ComGetEtcData(sXml,"msg");
			ComOpenWait(false);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				if(msg.length>2){
					ComShowCodeMessage('SQM00031',msg.substr(1));
				}else{
					ComShowCodeMessage('SQM00001','Data');
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}

			break;


		case IBSEARCH_ASYNC01:          // 화면2 조회 시
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			ComSetSearchParams("f_cmd", SEARCHLIST);
			ComSetSearchParams("f_ofc_vw_cd", formObj.f_ofc_vw_cd.Code);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0010GS.do", searchParams + "&" +clickParam);
			sheetObj.LoadSearchXml(rtnXml);

			if (sheetObj.SearchRows == 0) {
				toggleButtons("SEARCH2-1");
			}else{
				toggleButtons("SEARCH2");

			}
			break;


		case COMMAND02:          // 화면2 저장시

			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
			    return false;
			} else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
			}
			ComSetSearchParams("f_cmd", MULTI02);
			sheetObj.DoSave("ESM_SQM_0010GS.do", searchParams, -1, false);
			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			if (State == "S") {
				ComShowCodeMessage("SQM00001", "Data");
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
			}else{
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}

			break;
    }
}

 /**
 * sheet1_OnSearchEnd
 *01. 해당 row가 creation 된 상태일 때 row비활성화
 *02. 해당 row가 creation되지 않은 상태일 때 trd_cd콤보활성화
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	for(var i=1;i<sheetObj.Rows;i++){
   		if(sheetObj.CellValue(i,"flg") == "Y"){
   			sheetObj.RowEditable(i) = false;
   		}else {
			var trdcd  = sheetObj.CellValue(i,"trd_cd");	// trade code
			var param = "f_cmd=" + SEARCH01
		    + "&code_name=rLane"
		    + "&code_param=" + trdcd
		    + "&all_flag=";	// Trade

			var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
			var arrXml = xmlStr.split("|$$|");
			if (arrXml.length > 0)
				ComSqmSetIBCombo(sheetObj, arrXml[0], "src_rlane_cd", true, 1, i);

			sheetObj.CellValue(i,"ibflag") = "R";
   		}

		//creation 될 row가 존재하지 않을때
		if(sheetObj.FindText("flg","N", 0) == "-1")
			toggleButtons("SEARCH1");
		else
			toggleButtons("Creation");
	}

}


   /**
   * sheet1_onChange event
   * src_rlane_cd 바뀌었을때 validation
   */
  function sheet1_OnChange(sheetObj, row, col, value){
	   sheetObj.WaitImageVisible = false;
    		with(sheetObj){
    			switch(ColSaveName(col)){
            		case "src_rlane_cd":
            			var text = getSheetComboCode(sheetObj, row, col);
            			sheetObj.CellValue2(row, col) = text;
            			sheetObj.CellValue(row, "saveflg") = "N";
            			break;

    			}
    		}
    	}

   /**
   * sheet1_OnDblClick event
   * sheet1 row클릭시 sheet2조회
   */
  function sheet1_OnDblClick(sheetObj, Row, Col){
	   var formObj = document.form;
	   sheetObj.WaitImageVisible = false;
		clickParam 	= "trd_cd=" + sheetObj.CellValue(Row,"trd_cd")
					+"&dir_cd=" + sheetObj.CellValue(Row,"dir_cd")
					+"&rlane_cd=" + sheetObj.CellValue(Row,"rlane_cd");

	   doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC01);

    	}


	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리
	 */
  function toggleButtons(step) {
      switch (step) {
      case "INIT":
          ComBtnEnable("btn_Retrieve1");
          ComBtnDisable("btn_Retreive2");
          ComBtnDisable("btn_Save1");
          ComBtnDisable("btn_Save2");
          ComBtnDisable("btn_Creation");

          break;
      case "SEARCH1":
          ComBtnEnable("btn_Retrieve1");
          ComBtnEnable("btn_Retreive2");
          ComBtnEnable("btn_Save1");
          ComBtnDisable("btn_Save2");
          ComBtnDisable("btn_Creation");
          break;

      case "Creation":
          ComBtnEnable("btn_Retrieve1");
          ComBtnEnable("btn_Retreive2");
          ComBtnEnable("btn_Save1");
          ComBtnDisable("btn_Save2");
          ComBtnEnable("btn_Creation");
          break;

      case "SEARCH2":
    	  ComBtnEnable("btn_Save2");
    	  break;

      case "SEARCH2-1":
    	  ComBtnDisable("btn_Save2");
    	  break;


      }
  }


  /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
  function validateForm(sheetObj, formObj, sAction){

  	switch(sAction) {
  		case IBSAVE: //Save시
			for(var i=0;i<sheetObj.Rows;i++){
					if(sheetObj.CellValue(i,"ibflag") == "U" && sheetObj.CellValue(i,"rlane_cd") == sheetObj.CellValue(i,"src_rlane_cd")){
						ComShowCodeMessage("SQM00048");
						return false;
					}
				}
			break;
  	
  		case IBSEARCH_ASYNC01:  // 화면 2 조회시
			if (sheetObjects[0].CheckedRows("sel") > 1) {
				ComShowCodeMessage("COM12113", "one row");
				return false;
			}

      		break;
      		
  		case COMMAND01:  // Creation시
  			var chkRow = sheetObj.FindCheckedRow("sel");
  			if(chkRow ==""){
				ComShowCodeMessage("COM12113", "rows to creation");
				return false;
  			}
  			for(var i=0;i<sheetObj.Rows;i++){
  				if(sheetObj.CellValue(i,"sel") == "1" && sheetObj.CellValue(i,"src_rlane_cd")==""){
  					ComShowCodeMessage("SQM00024", "Copy Source");
  					return false;
  				}
  				if(sheetObj.CellValue(i,"sel") == "1" && sheetObj.CellValue(i,"rlane_cd") == sheetObj.CellValue(i,"src_rlane_cd")){
  					ComShowCodeMessage("SQM00048");
  					return false;
  				}
  			}
  			var chk = chkRow.split("|");
  			for(var i=0;i<chk.length;i++){
  				if(sheetObj.CellValue(chk[0],"saveflg")=="N"){
  					ComShowCodeMessage("SQM00017");
  					return false;
  				}
  			}

  			break;
  	}
  	return true;
  }

   /**
	* f_ofc_vw_cd 바뀌었을때 sheet2초기화
	*/
   function f_ofc_vw_cd_OnChange(obj, value, text) {
		toggleButtons("SEARCH2-1");
   }


   /**
    * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
    */
   function f_bse_tp_cd_OnChange() {
   	var formObj    = document.form;
   	var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
   	var div_qtr    = document.getElementById("div_qtr");
   	var div_period = document.getElementById("div_period");

   	if (bse_tp_cd == "Y") {
   		div_qtr.style.display = "none";
   		div_period.style.display = "none";
   		formObj.f_bse_qtr_cd.style.display = "none";
   	} else {
   		div_qtr.style.display = "inline";
   		div_period.style.display = "inline";
   		formObj.f_bse_qtr_cd.style.display = "inline";
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
   
   /**
    * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
    */
   function setTradeCombo() {
   	var formObj  = document.form;
   	var sheetObj = sheetObjects[0];
   	var param    = "";

   var bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
   var bse_yr     = ComGetObjValue(formObj.f_bse_yr);
   var trd_cd     = ComGetObjValue(formObj.f_trd_cd);

 	param = "f_cmd=" + SEARCH01
     + "&code_name=trade"
     + "&code_param= " + bse_yr + "" + bse_qtr_cd
     + "&all_flag=All";	// Trade

	var sXml = sheetObj.GetSearchXml("CommonGS.do",param);
	ComXml2ComboItem(sXml, formObj.f_trd_cd, "code", "name");
	// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
	var index = SearchIndex(formObj.f_trd_cd, trd_cd);
	formObj.f_trd_cd.Index = index;
}
   
/* 개발자 작업  끝 */