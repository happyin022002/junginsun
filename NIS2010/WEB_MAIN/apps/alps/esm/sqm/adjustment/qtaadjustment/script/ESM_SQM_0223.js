/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESM_SQM_0223.jsp
*@FileTitle      : Allocation = QTA Setting for IAS Sector
*@Open Issues    :
*@Change history :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
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
 * @class ESM_SQM_0223 : ESM_SQM_0223 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0223() {
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

var saveflg = "Y";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj     = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_Downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;

			case "btn_Apply":
				doActionIBSheet(sheetObject,formObj,MULTI01);
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
	var formObj = document.form;
	loadingMode = true;

	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	initControl();
	toggleButtons("INIT");
	loadingMode = false;
}

/**
* f_bse_yr가 바뀌었을때 week,month콤보 변경
*/
function f_bse_yr_OnChange(obj, value, text) {
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
}
 /**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
 function obj_keypress(){
	switch(event.srcElement.dataformat){
    	case "int":
	        //숫자만입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;
        case "engup":
            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        default:
            //숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
    }
}
 
 function initControl(){
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- 키보드 입력할때
}     

 /**
  * 조회조건 입력할 때 처리
  */
 function obj_KeyUp() {
      var formObject = document.form;
      var srcName = window.event.srcElement.getAttribute("name");
      var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
      var srcValue = window.event.srcElement.getAttribute("value");
      if (ComChkLen(srcValue, srcMaxLength) == "2") {
      	ComSetNextFocus();
      }
 }
  
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 =  "STS|SEQ|Year|Trade|Sub Trade|IAS Region|R.Lane|Lane Bound|Trade Direction|Month|Week|VVD|vsl_cd|skd_voy_no|skd_dir_cd|P/F SKD Group|Supply|RHQ|Office|POL|POD|Load|Applied|SEL";


				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, true, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(19);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,	  daCenter,	 true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,	  daCenter,  true,	"seq",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,	  daCenter,	 true,	"bse_yr",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,	  daCenter,	 true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	  daCenter,	 true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	  daCenter,	 true,	"ias_rgn_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	  daCenter,	 true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);				
				InitDataProperty(0,	cnt++,	dtData,			75,	  daCenter,	 true,	"dir_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,	  daCenter,	 true,	"hul_bnd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,	  daCenter,	 true,	"bse_mon",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			50,   daCenter,  true,	"bse_wk",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			110,  daCenter,	 true,	"vvd",		    false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,   daCenter,	true,	"vsl_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,	  daCenter,	true,	"skd_voy_no",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,   daCenter,	true,	"skd_dir_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,   daCenter,	 true,	"pf_grp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,   daCenter,	 true,	"fnl_bsa_capa",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,   daCenter,	 true,	"rhq_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	  daCenter,	 true,	"rgn_ofc_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	  daCenter,	 true,	"pol_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	  daCenter,	 true,	"pod_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	  daRight,	 true,	"lod_qty",		false,	"",	dfFloat,0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			60,	  daCenter,	true,	"aply_flg",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		30,	  daCenter,	 true,	"sel",			false,	"",	dfNone,	0,	true,	true);
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
			with (comboObj) {
				DropHeight = 300;
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
		case IBCLEAR:          // 화면 접속 시
			sheetObj.WaitImageVisible = false;
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = INIT;
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0223GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComSetYear(arrXml[1]);
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.f_rhq_cd, "code", "name");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_sub_trd_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_ias_rgn_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_dir_cd, "code", "name");
			
			ComOpenWait(false);
			break;
			
		case SEARCH01:          // Month,Week콤보셋팅
		
			formObj.f_cmd.value = SEARCH01;
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0034GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_to_mon, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_to_wk, "code", "name");
				
			comboObjects[2].Index = 0;
			comboObjects[3].Index = 0;
			break;
			
		case IBSEARCH:          // 화면 조회 시
			sheetObj.WaitImageVisible = false;			
			ComOpenWait(true);
	
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			sheetObj.DoSearch("ESM_SQM_0223GS.do", searchParams);
			toggleButtons("SEARCH");
			saveflg = "Y";
			ComOpenWait(false);
			break;
			
		case IBSAVE:          // 화면 저장시
		
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
			    return false;
			} else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
			}
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0223GS.do", searchParams + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			
			break;

			
		case MULTI01:		// SPC Alloc apply
			if (sheetObj.CheckedRows("sel") == 0) {
				ComShowCodeMessage("COM12113", "rows to apply");
				return false;
			}

			if(saveflg == "N"){
				ComShowCodeMessage("SQM00030","SPC Alloc Apply");
				return false;
			}
			if (ComShowConfirm (ComGetMsg('SQM00012','apply')) != 1) {
				return false;
		    }

			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sParam 	= sheetObj.GetSaveString(false, true, "sel");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0223GS.do", searchParams + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}

			break;
		
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;

    }
}

 /**
 * 화면 오픈시 Year 세팅
 */
function ComSetYear(xml) {
	var formObj = document.form;
	var arrData = ComSqmGetXmlValue(xml);
	var arrCode = arrData.split("-");
	formObj.f_bse_yr.Code     = arrCode[0];
}

  /**
   * onChange event
   * f_rhq_cd 바뀌었을때  f_rgn_ofc_cd 콤보조회
   */	
  function f_rhq_cd_OnChange(obj, value, value) {

  	var formObj = document.form;
  	var rhqCd  = value;	// rhq code
  	if(value!="All"){
  		var param = "f_cmd=" + SEARCH01
  	    + "&code_name=office"
  	    + "&code_param=" + rhqCd
  	    + "&all_flag=All";	// Trade
  	
  		var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
  		ComXml2ComboItem(xmlStr, formObj.f_rgn_ofc_cd, "code", "name");

  	}else{
  		formObj.f_rgn_ofc_cd.RemoveAll();
  		formObj.f_rgn_ofc_cd.InsertItem(0, "All", "All");

  	}
		comboObjects[4].Index = 0;
  }
  

  /**
  * onChange event
  * f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
  */	
  function f_sub_trd_cd_OnChange(obj, value, text) {
  	setLaneCombo();
   }

  /**
  * onChange event
  * f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
  */	
  function f_ias_rgn_cd_OnChange(obj, value, text) {
  	setLaneCombo();
  }

  /**
   *  f_sub_trd_cd, f_ias_rgn_cd 변경시 f_rlane_cd를 변경한다.
   */
  function setLaneCombo(){
   	var formObj = document.form;
   	var sub_trd_cd = ComGetObjValue(formObj.f_sub_trd_cd);
   	var ias_rgn_cd = ComGetObjValue(formObj.f_ias_rgn_cd);
   	
   	if ( (sub_trd_cd != ""  && sub_trd_cd != "All" ) || (ias_rgn_cd != "" && ias_rgn_cd != "All")  ) {
  	 	var param = "f_cmd=" + SEARCH01
  	    + "&code_name=rLane"
  	    + "&code_param=IAS|"+formObj.f_sub_trd_cd.Code+"|"+formObj.f_ias_rgn_cd.Code
  	    + "&all_flag=All";
  	
  	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
  	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
  	 	formObj.f_rlane_cd.Index = 0;
   	} else {
  		formObj.f_rlane_cd.RemoveAll();
  		formObj.f_rlane_cd.InsertItem(0, "All", "All");
  		formObj.f_rlane_cd.Index = 0; 		
   	}
  }

  /**
   * f_rlane_cd 바뀌었을때 POL, POD 변경
   */
  function f_rlane_cd_OnChange(obj, value, text) {
  	var formObj  = document.form;
  	var sheetObj = sheetObjects[0];
  	
  	if(value != "" && value != "All") {
  		var code_name  = new Array("polCdSector", "podCdSector");
  		var code_param = new Array(value, value);
  		var all_flag   = new Array("All", "All");
  	
  		var param = "f_cmd="		+ SEARCH02
  		          + "&code_name="	+ code_name
  		          + "&code_param="	+ code_param
  		          + "&all_flag="	+ all_flag
  		          + "&" + FormQueryString(formObj);	
  		var sXml   = sheetObj.GetSearchXml("CommonGS.do", param);
  		var arrXml = sXml.split("|$$|");
  	
  		if (arrXml.length > 0) {
  			ComXml2ComboItem(arrXml[0], formObj.f_pol_cd, "code", "name");
  			formObj.f_pol_cd.Index = 0;
  		}
  		if (arrXml.length > 1) {
  			ComXml2ComboItem(arrXml[1], formObj.f_pod_cd, "code", "name");
  			formObj.f_pod_cd.Index = 0;
  		}
  		
  		var param2 = "f_cmd="	+ SEARCH01
  		+ "&code_name=pfGroup"	
  		+ "&code_param="	+ value
  		+ "&all_flag="
  		+ "&" + FormQueryString(formObj);	
  		var sXml2   = sheetObj.GetSearchXml("CommonGS.do", param2);
  		var arrXml2 = sXml2.split("|$$|");
  	
  		if (sXml2.length > 0) {
  			ComXml2ComboItem(arrXml2[0], formObj.f_pf_grp_cd, "code", "name");
  			formObj.f_pf_grp_cd.InsertItem(0, "All|All", "All");
  			formObj.f_pf_grp_cd.Index = 0;
  		}
  	}
  }
  
   /**
   * sheet1_onChange event
   * lod_qty 바뀌었을때 validation
   */  
  function sheet1_OnChange(sheetObj, row, col, value){
	   sheetObj.WaitImageVisible = false;
    		with(sheetObj){
    			switch(ColSaveName(col)){
            		case "lod_qty":
            			saveflg = "N";
            			break;
            			
    			}
    		}
    	}   
   
   /**
    * 화면의 모든 버튼들의 Enable/Disable 을 처리
    */
   function toggleButtons(step) {
   	switch (step) {
   		case "INIT":
   			ComBtnDisable("btn_Save");
   			ComBtnDisable("btn_Downexcel");
   			ComBtnDisable("btn_Apply");
   			break;

   		case "SEARCH":
   			ComBtnEnable("btn_Save");
   			ComBtnEnable("btn_Downexcel");
   			ComBtnEnable("btn_Apply");
   			break;
   			

   	}
   }  
/* 개발자 작업  끝 */