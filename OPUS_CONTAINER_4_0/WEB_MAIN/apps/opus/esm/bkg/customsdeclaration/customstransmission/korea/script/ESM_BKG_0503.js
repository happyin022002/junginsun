/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0503.js
 *@FileTitle : Transmit Cross-Check
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.01.17
 *@LastModifier : 이수진
 *@LastVersion : 1.0
 * 2011.01.17 이수진
 * 1.0 Creation
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
 * @class Transmit Cross-Check 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function esm_bkg_0503() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.doActionIBSheet = doActionIBSheet;
//    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
//    this.sheet1_OnClick = sheet1_OnClick;
//    this.sheet1_OnDblClick = sheet1_OnDblClick;
}

/* 개발자 작업    */

//공통전역변수

//var tabObjects = new Array();
//var tabCnt = 0 ;
//var beforetab = 1;

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
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;

			case "btn_new":
				formClear();
			break;
			case "rad_dep_type":
				formObject.rad_vvd.checked = false;
				formObject.start_dt.disabled=false;
				formObject.end_dt.disabled=false;
				formObject.dep_type.disabled=false;
				formObject.start_dt.className="input1";
				formObject.end_dt.className="input1";
				formObject.dep_type.className="input1";

				//formObject.vvd.disabled=true;
				formObject.vvd.className="input2";
				if(formObject.dep_type.value == "ETD") {
					setPolPod("POL", "");
				} else {
					setPolPod("POD", "");
				}

				formObject.vvd.value = "";
				formObject.rad_trans_type[2].checked = true;

			break;
			case "rad_vvd":
				formObject.rad_dep_type.checked = false;
				formObject.start_dt.className="input2";
				formObject.end_dt.className="input2";
				formObject.dep_type.className="input2";
				formObject.start_dt.disabled=true;
				formObject.end_dt.disabled=true;
				formObject.dep_type.disabled=true;
				formObject.vvd.disabled=false;
				formObject.vvd.className="input1";

				formObject.rad_trans_type[0].checked = true;
				formObject.rad_lane_type[0].checked = true;


			break;

			case "btns_calendar" :
				var cal = new ComCalendarFromTo();
				cal.select(formObject.start_dt, formObject.end_dt, 'yyyy-MM-dd');
				break;
			case "btn_manifest_generate" :
				sUrl = "ESM_BKG_0329.do&pgmNo=ESM_BKG_0329";
				sId = "ESM_BKG_0329";
				if (sId != "") module_pop(sUrl, sId);
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
 * 링크화면 오픈(Manifest Generate)
 */
function module_pop(url, id) {
    var iWidth = 1040;
    var iHeight = 700;
    var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
    var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
    var sFeatures = "status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
    var winObj = window.open("opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^clt^" + url, "", sFeatures);
    winObj.focus();
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
function loadPage(offCd) {
	for(i=0;i<sheetObjects.length;i++){
	    //khlee-시작 환경 설정 함수 이름 변경
	    ComConfigSheet (sheetObjects[i] );

	    initSheet(sheetObjects[i],i+1);
	    //khlee-마지막 환경 설정 함수 추가
	    ComEndConfigSheet(sheetObjects[i]);
    }
//	//화면에서 필요한 이벤트
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);

//	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerForm("Click","obj_Click", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

//	document.form.start_dt.value = getCalculatedDate(0, 0, -3, "-");
//	document.form.end_dt.value = getCalculatedDate(0, 0, +1, "-");

	assignBasePort(offCd);

	setBaseDate();



}



/**
 * POL, POD 별로 SHEET를 가변적으로 변환한다.
 * @param formObj
 * @param pol
 * @param pod
 * @return
 */
function polPodTypeCheck(formObj, pol, pod) {
	if(pol != "" && pod == "") {
		sheetObjects[0].ColHidden("pic_a") = false;
		sheetObjects[0].ColHidden("type_b") = false;
		sheetObjects[0].ColHidden("pic_b") = false;
		sheetObjects[0].ColHidden("type_c") = false;
		sheetObjects[0].ColHidden("pic_c") = false;
		sheetObjects[0].ColHidden("type_d") = false;
		sheetObjects[0].ColHidden("pic_d") = false;
//		sheetObjects[0].ColHidden("type_oth") = false;
		sheetObjects[0].CellValue2(1, "type_a") = "Type_A";
		sheetObjects[0].CellValue2(1, "pic_oth") = "PIC";

	} else if(pol == "" && pod != "") {
		sheetObjects[0].ColHidden("pic_a") = true;
		sheetObjects[0].ColHidden("type_b") = true;
		sheetObjects[0].ColHidden("pic_b") = true;
		sheetObjects[0].ColHidden("type_c") = true;
		sheetObjects[0].ColHidden("pic_c") = true;
		sheetObjects[0].ColHidden("type_d") = true;
		sheetObjects[0].ColHidden("pic_d") = true;
		sheetObjects[0].ColHidden("pic_oth") = true;
		sheetObjects[0].CellValue2(1, "type_a") = "Type";
//		sheetObjects[0].CellValue2(1, "pic_oth") = "Type_OTH";

	}
}


/**
 * 마이스 이동시 이벤트
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	//window.status = "OnMouseMove Row=" + Row + ", Col=" + Col + ", Text=" + sText;

	Row = sheetObjects[0].MouseRow;
	Col = sheetObjects[0].MouseCol;

    var colSaveName = sheetObjects[0].ColSaveName(Col);

	if(colSaveName == "crr_cd") {

		//sText = sheetObjects[0].CellText(Row,Col);
		if(sheetObjects[0].CellValue(Row,"crr_cd")=="NYK"){
			sText = sheetObjects[0].CellText(Row,"cust_opr_cd");
		}else{
			sText = "";
		}

	}else{
		sText = "";
	}

	//풍선도움말 만들기
	sheetObjects[0].MouseToolTipText = sText;

}

/**
 * 화면 초기화
 * @return
 */
function formClear() {

	var formObj = document.form;
	formObj.rad_dep_type.checked = true;
	formObj.dep_type.value = "ETD";
	formObj.dep_type.disabled=false;

	formObj.start_dt.disabled=false;
	formObj.end_dt.disabled=false;
	formObj.start_dt.className="input1";
	formObj.end_dt.className="input1";
	formObj.dep_type.className="input1";

	formObj.rad_vvd.checked = false;
	formObj.vvd.value = "";
	formObj.vvd.className="input2";

	formObj.rad_trans_type[2].checked = true;

	assignBasePort(formObj.offCd.value);

	setBaseDate();
	document.getElementById("col1").style.display = "block";
	document.getElementById("col2").style.display = "none";
}
/**
 * 화면 Open시 ETD/DTA에 따라 Start Date, End Date Setting
 * @return
 */
function setBaseDate() {
	var form = document.form;
	var startDiff = 0;
	var endDiff = 1;

	if(form.dep_type.value == "ETD") {
		startDiff = -3;
	} else {
		startDiff = -1;
	}

	form.start_dt.value = ComGetDateAdd(null, 'd', startDiff, '-');
	form.end_dt.value = ComGetDateAdd(null, 'd', endDiff, '-');


}

/**
* 오피스에 따리 port값 설정
* @param offCd
* @return
*/
function assignBasePort(offCd) {
	var portCd = "";

	if(offCd == "SELBB" || offCd == "PUSBT" || offCd == "PUSBI") {
		portCd = "KRPUS";
	} else if (offCd == "INCBO") {
		portCd = "KRINC";
	} else if (offCd == "KANBO") {
		portCd = "KRKAN";
	}

	//alert(portCd);
	document.form.portCd.value = portCd;
	if(document.form.dep_type.value == "ETD") {
		setPolPod("POL", "");
	} else {
		setPolPod("POD", "");
	}

}

/**
* pol 또는 pod 값에 type setting
* @param type
* @return
*/
function setPolPod(type, eventType) {
	var frm = document.form;

		if(type == "POL") {
			if(eventType != "CLICK"|| frm.pod.value != "") {
				frm.pol.value = frm.portCd.value;
				frm.pod.value = "";
				document.getElementById("col1").style.display = "block";
				document.getElementById("col2").style.display = "none";
			}
			frm.pol.readOnly=false;
			frm.pol.className="input1";
			frm.pod.readOnly=true;
			frm.pod.className="input2";

			frm.sel_type.className="input1";
			frm.sel_type.disabled=false;
			frm.sel_type.value = "";

			frm.dep_type.value ='ETD';



		} else {
			if(eventType != "CLICK" || frm.pol.value != "") {
				frm.pod.value = frm.portCd.value;
				frm.pol.value = "";
				document.getElementById("col1").style.display = "none";
				document.getElementById("col2").style.display = "block";
			}
			frm.pod.readOnly=false;
			frm.pod.className="input1";

			frm.pol.readOnly=true;
			frm.pol.className="input2";

			frm.sel_type.className="input2";
			frm.sel_type.disabled=true;
			frm.sel_type.value = "";

			frm.dep_type.value ='ETA';


		}
}

/**
* 폼 필드 변경시 이벤트
*
* @return
*/
function obj_change() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "dep_type" || srcName == "rad_dep_type" ) {
		if(formObject.dep_type.value == "ETD") {
			setPolPod("POL", "");
		} else {
			setPolPod("POD", "");
		}
		setBaseDate();
	}


}

/**
 * POL, POD Click 여부
 * @return
 */
function obj_Click() {
	var frm = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	var sheetObject1 = sheetObjects[0];

	//alert(srcName);

	if(frm.rad_vvd.checked)  {

		if (srcName == "pol" ) {
			setPolPod("POL", "");

		} else if (srcName == "pod" ) {
			setPolPod("POD", "");
		}

		setBaseDate();
	}else{

		if (srcName == "pol" ) {

			 if(frm.dep_type.value == "ETA"){
				 setBaseDate();
			 }

			setPolPod("POL", "CLICK");



			document.getElementById("col1").style.display = "block";
			document.getElementById("col2").style.display = "none";

		} else if (srcName == "pod" ) {

			 if(frm.dep_type.value == "ETD"){
				 setBaseDate();
			 }

			setPolPod("POD", "CLICK");

			document.getElementById("col1").style.display = "none";
			document.getElementById("col2").style.display = "block";

		}	else if (srcName == "vvd" ) {
			setBaseDate();
		}
	}


	if(srcName == "vvd"){
		frm.vvd.disabled=false;
		frm.vvd.className="input1";
		frm.rad_vvd.checked = true;

		frm.rad_dep_type.checked = false;
		frm.start_dt.className="input2";
		frm.end_dt.className="input2";
		frm.dep_type.className="input2";
		frm.start_dt.disabled=true;
		frm.end_dt.disabled=true;
		frm.dep_type.disabled=true;

		frm.rad_trans_type[0].checked = true;
		frm.rad_lane_type[0].checked = true;
	}else if (srcName == "rad_trans_type" || srcName == "rad_lane_type" ){
		doActionIBSheet(sheetObject1,frm,IBSEARCH);
	}


}





///**
// * 조회조건 입력할 때 MaxLength까지 입력하면 다음탭으로 이동
// */
//function obj_KeyUp() {
//	var formObject = document.form;
//	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
//	var srcValue = window.event.srcElement.getAttribute("value");
//	var srcName = window.event.srcElement.getAttribute("name");
//
//	if ( (  srcName == "vvd" || srcName == "pol_cd" ) && ComChkLen(srcValue, srcMaxLength) == "2" ) {
//		ComSetNextFocus();
//	}
//}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
     	case "sheet1":      //sheet1 init
	        with (sheetObj) {
	            // 높이 설정
	            style.height = 362;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;

	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;

	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;

	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 2, 1, 3, 100);

	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            //mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
	            InitHeadMode(true, true, true, true, false,false)

	            var HeadTitle1 = "|Sel.|Seq.|Lane|VVD|POL/POD|ETD/ETA|Send Data|Send Data|Send Data|Send Data|Send Data|Send Data|Send Data|Send Data|Send Data|Send Data|OPR|CUST OPR|PORT_DIV";
	            var HeadTitle2 = "|Sel.|Seq.|Lane|VVD|POL/POD|ETD/ETA|Type A|PIC|Type B|PIC|Type C|PIC|Type D|PIC|Type_OTH|PIC|OPR|CUST OPR|PORT_DIV";

	            var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);

	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtHiddenStatus,  0, 	daCenter,  	false,    "ibflag");
		        InitDataProperty(0, cnt++ , dtCheckBox,		40, 	daCenter,  	true,     "Chk");
	            InitDataProperty(0, cnt++ , dtDataSeq,	    30, 	daCenter,  	true,     "Seq");
	            InitDataProperty(0, cnt++ , dtData, 		60,		daCenter,	true,     "slan_cd", 	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,	daCenter,	true,     "vvd",  		false,    "",  dfNone, 0,   true,	true);

	            InitDataProperty(0, cnt++ , dtData, 		60,		daCenter,	true,     "port_cd", 	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		150,	daCenter,	true,     "etda_dt", 	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "type_a", 	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "pic_a",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "type_b", 	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "pic_b",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "type_c",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "pic_c",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "type_d",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "pic_d",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,	true,     "type_oth",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtHidden, 		80,		daCenter,	true,     "pic_oth",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,	true,     "crr_cd",		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		250,	daCenter,	true,     "cust_opr_cd",		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtHidden, 		30,	    daCenter,	true,     "port_div",		false,    "",  dfNone, 0,   true,	true);

	            // 틀고정 설정 (cntr_no)
	    		FrozenCols = 7;

	           }




	        break;

	}
}

/**
* Sheet관련 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
*/

function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch(sAction) {

		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;

			var pol = formObj.pol.value;
			var pod = formObj.pod.value;

			// POL, POD에 따라 SHEET가 가변적으로 변환
			polPodTypeCheck(formObj,pol, pod);


			formObj.f_cmd.value = SEARCH;

			ComOpenWait(true, true);

			var sXml = sheetObj.GetSearchXml("ESM_BKG_0503GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);



			for ( var i = 2; i <= sheetObj.Rows; i++) {

//				if(sheetObj.cellValue(i,"crr_cd") == "OTHERS"){
//					//sheetObj.crr_cd.RgbColor(255, 0, 0)
//					sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
////					sheetObj.CellBackColor(i, "cell_psn_no") = sheetObj.RgbColor(0x87,0xce,0xeb);
//				}
				if(sheetObj.cellValue(i,"port_div") == "X"){
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(204,255,204);
				}
				if(sheetObj.cellValue(i,"type_oth") != ""){
					sheetObj.CellBackColor(i,"type_oth") = sheetObj.RgbColor(255, 0, 0);
				}
			}



			ComOpenWait(false);

		break;

        case IBRESET:        //New
    	break;


	}
}



/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
*/

function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
	    case IBSEARCH: // 조회

		var vvd = formObj.vvd.value;
		var pod = formObj.pod.value;
		var pol  = formObj.pol.value;
//		var radVvd  = formObj.rad_vvd.value;


	    if(formObj.pol.readOnly == false) { // pol
	    	if(pol.length < 5) {
	    		ComShowCodeMessage("COM12114", "POL");
	    		return false;
	    	}
	    } else { // pod
	    	if(pod.length < 5) {
	    		ComShowCodeMessage("COM12114", "POD");
	    		return false;

	    	}
	    }

	    if(formObj.rad_vvd.checked) {
	    	if(vvd.length < 9) {
	    		ComShowCodeMessage("BKG00566");
	    		return false;

	    	}
	    } else {

				if (ComIsNull(formObj.start_dt) ||
					ComIsNull(formObj.end_dt)) {
					ComShowCodeMessage('BKG00626', 'Send Date & Send Time');
					return false;
				}
				if (formObj.start_dt.value  > formObj.end_dt.value ) {
					ComShowMessage('Send Date is invalid');
					return false;
				}
				var diffDate = ComGetDaysBetween(formObj.start_dt, formObj.end_dt);
				var year = formObj.start_dt.value.substring(0, 4);
				var month = formObj.start_dt.value.substring(5, 7);
				var lastDay = ComGetLastDay(year, parseInt(month, 10));
				if (diffDate + 1 > lastDay) {
					ComShowCodeMessage('BKG01080');
					formObj.end_dt.select();
					return false;
				}

	    }

	    return true;
	    break;
    }
}

/* 개발자 작업  끝 */