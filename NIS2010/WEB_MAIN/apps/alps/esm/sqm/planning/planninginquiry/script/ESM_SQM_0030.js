/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0030.js
*@FileTitle      : QTA Inquiry_Quarterly Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.30
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.30 SQM USER
* 1.0 Creation
* 2013.11.11 박은주 [CHM-201327449] SQM 몇몇 화면 내 틀 고정 기능 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0030 : ESM_SQM_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0030() {
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
			case "btn_DownExcel":
				doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
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
	initcontrol();
	loadingMode = false;
}

function initcontrol(){
	 
		var formObj = document.form;
		axon_event.addListenerForm  ("KeyUp",    "obj_KeyUp", 	formObj);
		axon_event.addListenerForm  ('click',    'obj_click',   formObj); 
		axon_event.addListenerForm  ('change', 	 'obj_change',  formObj); 
	    axon_event.addListenerFormat('keypress', 'obj_keypress',formObj); //- 키보드 입력할때
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
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
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
			
			var HeadTitle1 =  "SEQ|Year|Office View|RHQ|Office|Trade|Sub Trade|Lane|Lane Bound|Trade Direction|Month|Supply|Load|L/F|G.REV|G.RPB|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 12, 0, true);
			
			// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
			InitHeadMode(true, false, false, true, false, false);
			
			//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			
			// 전체 높이 설정
			style.height = GetSheetHeight(19);
			
			//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
			InitDataProperty(0,	cnt++,	dtSeq,		30,		daCenter,	true,	"seq",			false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_yr",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"ofc_vw_cd",	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rhq_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rgn_ofc_cd",	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"trd_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,	true,	"sub_trd_cd",	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"rlane_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		75,		daCenter,	true,	"dir_cd",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daCenter,	true,	"hul_bnd_cd",	false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,	true,	"bse_mon",		false,	"",	dfNone,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	60,		daRight,	true,	"fnl_bsa_capa",	false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"lod_qty",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		80,		daRight,	true,	"ldf_rto",		false,	"|lod_qty|/|fnl_bsa_capa|*100",	dfFloat,	2,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"g_rev",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"grpb",			false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm_c",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm_c",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmcb",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmcb",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"pa_cm",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtAutoSum,	100,	daRight,	true,	"ra_cm",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"pa_cmpb",		false,	"",	dfInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,		100,	daRight,	true,	"ra_cmpb",		false,	"",	dfInteger,	0,	false,	false);

			RangeBackColor(0, 12,0, 15) = RgbColor(203,210,248);
			RangeBackColor(0, 20,0, 23) = RgbColor(203,210,248);
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
* f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
*/
function f_bse_qtr_cd_OnChange(obj, value, text) {
    var formObj = document.form;
	period_change();

}

/**
* f_bse_yr가 바뀌었을때 office콤보 셋팅
*/
function f_bse_yr_OnChange(obj, value, text) {
	period_change();

}


//
///**
//* f_bse_yr,f_ofc_vw_cd,f_rhq_cd가 바뀌었을때 office콤보 settting
//*/
//function office_change() {
//	var formObj = document.form;
//	if(comboObjects[0].Code!="" && comboObjects[1].Code!="" && comboObjects[4].Code!=""){
//
//
//	 	var param = "f_cmd=" + SEARCH02
//	     + "&code_name=activeOfc"
//	     + "&code_param= " 
//	     + "&all_flag=All"
//	     + "&" + FormQueryString(formObj);	// Trade
//
//	 	
//		var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
//		var arrXml = xmlStr.split("|$$|");
//		if (arrXml.length > 0)
//			ComXml2ComboItem(arrXml[0], formObj.f_rgn_ofc_cd, "code", "name");
//		
//		comboObjects[5].Index = 0; 	
//	}
//}
//
///**
//* f_bse_yr,f_ofc_vw_cd,f_trd_cd가 바뀌었을때 rlane콤보 settting
//*/
//function rlane_change() {
//	var formObj = document.form;
//	if(comboObjects[0].Code!="" && comboObjects[1].Code!="" && comboObjects[6].Code!=""){
//
//	 	var param = "f_cmd=" + SEARCH02
//	     + "&code_name=rLaneControl"
//	     + "&code_param= " 
//	     + "&all_flag=All"
//	     + "&" + FormQueryString(formObj);	// Trade
//
//	 	
//		var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
//		var arrXml = xmlStr.split("|$$|");
//		if (arrXml.length > 0)
//			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");			
//		comboObjects[7].Index = 0; 	
//	}
//}


/**
 * onChange event
 * f_rhq_cd 바뀌었을때  f_rgn_ofc_cd 콤보조회
 */	
function f_rhq_cd_OnChange(obj, value, text) {
	var formObj = document.form;
	if (value != "All") {	
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=office"
	     + "&code_param=" + value
	     + "&all_flag=All";	// Trade
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rgn_ofc_cd, "code", "name");
	
	} else {
		formObj.f_rgn_ofc_cd.RemoveAll();
		formObj.f_rgn_ofc_cd.InsertItem(0, "All", "All");
	}
 	comboObjects[5].Index = 0; 	
}

/**
 * onChange event
 * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */	
function f_trd_cd_OnChange(obj, value, text) {
	var formObj = document.form;
	if (value != "All") {	
	 	var param = "f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param=" + value
	     + "&all_flag=All";	// Trade
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
	
	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
	}
 	comboObjects[7].Index = 0; 	
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
			
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0030GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ofc_lvl, "code", "name");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.f_trd_cd, "code", "name");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_rhq_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_dir_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 7)
				ComSetYearQta(arrXml[7]);
			if (arrXml.length > 8)
				ComXml2ComboItem(arrXml[8], formObj.f_trd_dir, "code", "name");

			ComOpenWait(false);
			break;
		
		case IBSEARCH:          //화면 조회시
			sheetObj.WaitImageVisible = false;	
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);	
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_SQM_0030GS.do", FormQueryString(formObj));
			if (ComGetObjValue(formObj.f_ofc_lvl) == "01") {
				  sheetObjects[0].ColHidden("rhq_cd") = true;
				  sheetObjects[0].ColHidden("rgn_ofc_cd") = true;
				  sheetObjects[0].ColHidden("ldf_rto") = false;
			} else if (ComGetObjValue(formObj.f_ofc_lvl) == "02"){
				  sheetObjects[0].ColHidden("rhq_cd") = false;
				  sheetObjects[0].ColHidden("rgn_ofc_cd") = true;
				  sheetObjects[0].ColHidden("ldf_rto") = true;
			}else{
				  sheetObjects[0].ColHidden("rhq_cd") = false;
				  sheetObjects[0].ColHidden("rgn_ofc_cd") = false;
				  sheetObjects[0].ColHidden("ldf_rto") = true;
			}
			ComOpenWait(false);
			break;
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;
  }
}

/**
 *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param sheetObj
 * @param ErrMsg
 */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	 


	sheetObj.SumText(0, "seq") = "";
	sheetObj.SumText(0, "bse_yr") = "TOTAL";

	if(comboObjects[3].Code == "01"){
		if(sheetObj.SumValue(0, "fnl_bsa_capa")!=0)
			var num = (sheetObj.SumValue(0, "lod_qty")/sheetObj.SumValue(0, "fnl_bsa_capa")*100).toFixed(2);
		else
			var num = 0.00;
		sheetObj.SumText(0, "ldf_rto") = num;
		
	}else{
		sheetObj.SumText(0, "fnl_bsa_capa") = "";
	}
	

	//단가 total값 set
	if(sheetObj.SumValue(0, "lod_qty")!=0){
		sheetObj.SumText(0, "grpb")    = AddComma(Math.round(sheetObj.SumValue(0, "g_rev")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "pa_cmcb") = AddComma(Math.round(sheetObj.SumValue(0, "pa_cm_c")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "ra_cmcb") = AddComma(Math.round(sheetObj.SumValue(0, "ra_cm_c")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "pa_cmpb") = AddComma(Math.round(sheetObj.SumValue(0, "pa_cm")/sheetObj.SumValue(0, "lod_qty")));
		sheetObj.SumText(0, "ra_cmpb") = AddComma(Math.round(sheetObj.SumValue(0, "ra_cm")/sheetObj.SumValue(0, "lod_qty")));

	}else{
		sheetObj.SumText(0, "grpb")    = 0;
		sheetObj.SumText(0, "pa_cmcb") = 0;
		sheetObj.SumText(0, "ra_cmcb") = 0;
		sheetObj.SumText(0, "pa_cmpb") = 0;
		sheetObj.SumText(0, "ra_cmpb") = 0;
	}
	
}
/**
 * f_ofc_lvl 바뀌었을때 sheet change
 */
 function f_ofc_lvl_OnChange(obj, value, text) {
 	  var formObj    = document.form;
 	  var div_rhq    = document.getElementById("div_rhq");//rhq콤보
 	  var div_ofc    = document.getElementById("div_ofc");//ofc콤보

 	  if(value == "01"){//Head Office일때
 		  div_rhq.style.display = "none";
 		  div_ofc.style.display = "none";
 		  formObj.f_rhq_cd.style.display = "none";
 		  formObj.f_rgn_ofc_cd.style.display = "none";

 	  }else{
 		if(value == "02"){//RHQ일때
			div_rhq.style.display = "inline";
			div_ofc.style.display = "none";
			formObj.f_rhq_cd.style.display = "inline";
			formObj.f_rgn_ofc_cd.style.display = "none";
 		}else{//Office일때
 			div_rhq.style.display = "inline";
 			div_ofc.style.display = "inline";
 			formObj.f_rhq_cd.style.display = "inline";
 			formObj.f_rgn_ofc_cd.style.display = "inline";
 		}

 	  }

 }  
// /**
//  * 조회 정보를 sheet위에 보여줌
//  */
// function setShowMsg() {
//	  var formObj    = document.form;
//	  var div_show   = document.getElementById("div_show");//상세정보
//	  var level      = formObj.f_ofc_lvl.Text;
//	  var view       = formObj.f_ofc_vw_cd.Text;
//	  var year       = ComGetObjValue(formObj.f_bse_yr);
//	  var qta        = ComGetObjValue(formObj.f_bse_qtr_cd); //Quarter
//	  
//	  if(ComGetObjValue(formObj.f_ofc_lvl) == "01"){
//
//		  if(ComGetObjValue(formObj.f_fm_mon) != "" && ComGetObjValue(formObj.f_to_mon) != "")
//			  msg = level + " / " + year + "." + ComGetObjValue(formObj.f_fm_mon) + " ~ " + year + "." + ComGetObjValue(formObj.f_to_mon);
//		  else
//			  msg = level + " / " + year + "." + qtaMonArr[qta][0] + " ~ " + year + "." + qtaMonArr[qta][1];
//	  }else{
//		  
//		  if(ComGetObjValue(formObj.f_fm_mon) != "" && ComGetObjValue(formObj.f_to_mon) != "")
//			  msg = level + " / Office View : " + view + " / " + year + "." + ComGetObjValue(formObj.f_fm_mon) + " ~ " + year + "." + ComGetObjValue(formObj.f_to_mon);  
//		  else
//			  msg = level + " / Office View : " + view + " / " + year + "." + qtaMonArr[qta][0] + " ~ " + year + "." + qtaMonArr[qta][1];
//	  }
//	  
//	  div_show.innerHTML = msg;
// }
 /**
  * f_gubun가 체크될때 direction콤보 change
  */ 
 function obj_click() {
 	var formObj = document.form;        

 	if(formObj.f_gubun.checked){
    		trd_dir.style.display = "inline";
    		dir_cd.style.display = "none";
     		document.all("div_dir").innerHTML = "Trade Dir.";
 	}else{
    		trd_dir.style.display = "none";
    		dir_cd.style.display = "inline";
     		document.all("div_dir").innerHTML = "Lane Bound";
 	}
 }


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){

	switch(sAction) {
		
		case IBSEARCH:  // 화면 조회시에
			var qta = ComGetObjValue(formObj.f_bse_qtr_cd); //Quarter
			if(formObj.f_fm_mon.value!=""&&formObj.f_to_mon.value!=""){
				if(formObj.f_fm_mon.value<qtaMonArr[qta][0]
				        ||formObj.f_to_mon.value>qtaMonArr[qta][1]){
						ComShowCodeMessage('SQM00025',qta); 
						//Duration doesn't include {?msg1}
						return false;
				}
				
				// To month 가 From month 보다 큰지 체크
				if ( formObj.f_fm_mon.value > formObj.f_to_mon.value ) {
					ComShowCodeMessage("COM12133", "To month", "from month", "later");
					formObj.f_to_mon.value = "";
					formObj.f_to_mon.focus();
					return false;
				}
			}else{
				if(formObj.f_fm_mon.value==""&&formObj.f_to_mon.value==""){
					return true;
				}else{
					ComShowCodeMessage('SQM00024','Month'); 
					return false;
				}
			}
    		break;
    		
	}
	return true;
} 

/**
 * f_fm_mon,f_to_mon 가 두자리수로 표시되도록 onchange
 */ 
function obj_change(){
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcVal = window.event.srcElement.getAttribute("value");
	
	if(srcName == "f_fm_mon" || srcName == "f_to_mon"){

		if(srcVal.length<2 && srcVal.length != 0){
			formObject.elements[srcName].value = "0" + srcVal;
		}
	}
}
 
 /**
  * 천단위마다 콤마를 찍어주는 함수
  */
 function AddComma(number){
	 var str=new Array(); 
	 number=String(number);
	 for(var i=1;i<=number.length;i++){
		 
	  if(i%3) 
		  str[number.length-i]=number.charAt(number.length-i); //자리수가 아니면 숫자만삽입
	  else  
		  str[number.length-i]=','+number.charAt(number.length-i); //자리수 이면 콤마까지 삽입
	 }
	 return str.join('').replace(/^,/,'');
}

/* 개발자 작업  끝 */