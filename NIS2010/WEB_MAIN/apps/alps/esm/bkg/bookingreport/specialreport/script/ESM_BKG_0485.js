/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0485.js
 *@FileTitle : Special cargo summary information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.20
 *@LastModifier : 이일민
 *@LastVersion : 1.0
 * 2009.08.20 이일민
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
 * @class ESM_BKG_0485 : ESM_BKG_0485 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0485() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수

var rdObjects = new Array();
var rdCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	initRdConfig(rdObjects[0]);
	for (var i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++] = sheet_obj;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch(sheetID) {
        case "sheet1":
			cnt = 0;
            with (sheetObj) {
				style.height = 0;
				SheetWidth = 0;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly;
				Editable = true;
				InitRowInfo(1, 1, 2, 100);
				var HeadTitle1 = "polCd|podCd|vesselName|nationality|officialNo|callSign|voyageNo|kindOfShip|polNm|podNm";
				var headCount = ComCountHeadTitle(HeadTitle1);
				InitColumnInfo(headCount, 0, 0, true);
				InitHeadMode(true, true, false, true, false,false);
				InitHeadRow(0, HeadTitle1, true);
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"pol_cd"      );
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"pod_cd"      );
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"vessel_name" );
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"nationality" );
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"official_no" );
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"call_sign"   );
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"voyage_no"   );
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"kind_of_ship");
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"pol_name"    );
				InitDataProperty(0,	cnt++,	dtHidden,	0,	daLeft,	false,	"pod_name"    );
            }
            break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObject,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {
    	case IBSEARCH :
    		var form2 = document.form2;
			form2.f_cmd     .value = SEARCH;
			form2.vsl_cd    .value = formObject.vvd_cd.value.substring(0,4);
			form2.skd_voy_no.value = formObject.vvd_cd.value.substring(4,8);
			form2.skd_dir_cd.value = formObject.vvd_cd.value.substring(8,9);
			form2.pol_cd    .value = formObject.vvd_pol.value;
			form2.pod_cd    .value = formObject.vvd_pod.value;
			form2.pol_yd_cd .value = formObject.pol_yd_cd.value;
			form2.pod_yd_cd .value = formObject.pod_yd_cd.value;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0485GS.do", FormQueryString(form2));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			rdOpen(rdObjects[0],formObject);
			break;
    	case SEARCH01 :		// RD 데이터가 존재하는지 CHECK
    		var form2 = document.form2;
			form2.f_cmd     .value = SEARCH01;
			form2.vsl_cd    .value = formObject.vvd_cd.value.substring(0,4);
			form2.skd_voy_no.value = formObject.vvd_cd.value.substring(4,8);
			form2.skd_dir_cd.value = formObject.vvd_cd.value.substring(8,9);
			form2.vvd_pol   .value = formObject.vvd_pol.value;
			form2.vvd_pod   .value = formObject.vvd_pod.value;
			form2.por_cd    .value = formObject.por_cd.value;
			form2.pol_cd    .value = formObject.pol_cd.value;
			form2.pod_cd    .value = formObject.pod_cd.value;
			form2.del_cd    .value = formObject.del_cd.value;
			form2.pol_yd_cd .value = formObject.pol_yd_cd.value;
			form2.pod_yd_cd .value = formObject.pod_yd_cd.value;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0485GS.do", FormQueryString(form2));
			form2.dg.value = ComGetEtcData(sXml,"dg");
			form2.awk.value = ComGetEtcData(sXml,"awk");
			form2.bb.value = ComGetEtcData(sXml,"bb");
			form2.rf.value = ComGetEtcData(sXml,"rf");
			form2.stwg.value = ComGetEtcData(sXml,"stwg");
			ComOpenWait(false);
			break;
    }
}

function initControl() {
	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
    axon_event.addListener('keydown', 'ufRetrieveByEnterKey', 'form');
}

function ufRetrieveByEnterKey() {
    if (13!=event.keyCode) return;
    document.getElementById("btn_retrieve").fireEvent("onclick");
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":
			if (!validateForm(formObject)) return;
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH)
			break;
		case "rdo_in_out":  /*inbound,outbound*/
			var bkg_cust_tp_cd = ComGetObjValue(window.event.srcElement);
			formObject.elements["rdo_in_out"].value = bkg_cust_tp_cd;
			switch (bkg_cust_tp_cd) {
				case "IN":  /*inbound*/
					formObject.elements["vvd_pol"].className = "input";
					formObject.elements["vvd_pol"].removeAttribute("required");
					formObject.elements["vvd_pod"].className = "input1";
					formObject.elements["vvd_pod"].setAttribute("required","");
					break;
				case "OUT":  /*outbound*/
					formObject.elements["vvd_pol"].className = "input1";
					formObject.elements["vvd_pol"].setAttribute("required","");
					formObject.elements["vvd_pod"].className = "input";
					formObject.elements["vvd_pod"].removeAttribute("required");
					break;
			}
			break;
		} // end switch
	} catch (e) {
		ComShowMessage(e);
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObject) {
    with(formObject){
    	var chk = formObject.rdo_manifest_type1.checked+ formObject.rdo_manifest_type2.checked + formObject.rdo_manifest_type3.checked + formObject.rdo_manifest_type4.checked + formObject.rdo_manifest_type5.checked + formObject.rdo_manifest_type6.checked;
    	for (var i=0; i<formObject.elements.length; i++) {
    		if ("text"==formObject.elements[i].type) {
	    		if (null!=formObject.elements[i].getAttribute("required") && ComIsNull(formObject.elements[i])) {
	    			returnValidate("NULL", formObject.elements[i]);
	    			return false;
	    		}
	    		if (!ComIsNull(formObject.elements[i].value)) {
		    		if (null!=formObject.elements[i].getAttribute("minlength") && 1==ComChkLenByByte(formObject.elements[i].value, formObject.elements[i].getAttribute("minlength"))) {
		    			returnValidate("MIN", formObject.elements[i]);
		    			return false;
		    		}
		    		if (null!=formObject.elements[i].getAttribute("maxlength") && 0==ComChkLenByByte(formObject.elements[i].value, formObject.elements[i].getAttribute("maxlength"))) {
		    			returnValidate("MAX", formObject.elements[i]);
		    			return false;
		    		}
	    		}
    		}
    	}
    	if (!ComChkValid(formObject,false)) return false;
    	if (chk == 0){
    		alert("please check the checkbox");
    		return false;
    	}
    	
    }
    return true;
}

function returnValidate(mode, obj) {
	switch (mode) {
		case "NULL":
			var msg1 = msg2 = "";
			switch (obj.name) {
				case "vvd_cd":
					msg1 = "\"VVD & POL / POD\"", "\"VVD\"";
					msg2 = "\"VVD\"";
					break;
				case "vvd_pol":
					msg1 = "\"VVD & POL / POD\"", "\"VVD\"";
					msg2 = "\"POL\"";
					break;
				case "vvd_pod":
					msg1 = "\"VVD & POL / POD\"", "\"VVD\"";
					msg2 = "\"POD\"";
					break;
			}
			if (""!=msg1 && ""!=msg2) {
				ComShowCodeMessage("COM12130", msg1, msg2);  //Please enter {?msg2} of {?msg1}.
			} else {
				ComShowCodeMessage("BKG08020");  //Invalid data (NULL)
			}
			break;
		case "MAX":
			switch (obj.name) {
				case "vvd_cd":
					ComShowCodeMessage("BKG00710");  //Length of VVD is INCORRECT!
					break;
				case "vvd_pol":
					ComShowCodeMessage("BKG00711");  //Length of POL is INCORRECT!
					break;
				case "vvd_pod":
					ComShowCodeMessage("BKG00712");  //Length of POD is INCORRECT!
					break;
				default:
					ComShowCodeMessage("BKG00381");  //Incorrect Data Length
			}
			break;
		case "MIN":
			switch (obj.name) {
				case "vvd_cd":
					ComShowCodeMessage("BKG00710");  //Length of VVD is INCORRECT!
					break;
				case "vvd_pol":
					ComShowCodeMessage("BKG00711");  //Length of POL is INCORRECT!
					break;
				case "vvd_pod":
					ComShowCodeMessage("BKG00712");  //Length of POD is INCORRECT!
					break;
				default:
					ComShowCodeMessage("BKG00381");  //Incorrect Data Length
			}
			break;
	}
	ComSetFocus(obj);
}

//rd 설정
function initRdConfig(rdObject){
	var Rdviewer = rdObject;
	Rdviewer.AutoAdjust = true;
	Rdviewer.HideToolbar();
	Rdviewer.HideStatusbar();
	Rdviewer.ViewShowMode(0); 
	Rdviewer.setbackgroundcolor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);
}

//rd 오픈
function rdOpen(rdObject, formObject) {
	var Rdviewer = rdObject;
	var form2 = document.form2;
	var strPath,strTitle;
	var inOut = ComGetObjValue(formObject.elements["rdo_in_out"]);
	form2.rdo_in_out.value = ComGetObjValue(formObject.elements["rdo_in_out"]);
	var localTs = ComGetObjValue(formObject.elements["rdo_local_ts"]);
	form2.rdo_local_ts.value = ComGetObjValue(formObject.elements["rdo_local_ts"]);
    var where = " where[]";
    if ("IN"==inOut) {
		if ("LOCAL"==localTs) {
			where = " where[AND BKG.POD_CD = SP.VVD_POD]";
		} else if ("TS"==localTs) {
			where = " where[AND BKG.POD_CD <> SP.VVD_POD]";
		}
	} else if ("OUT"==inOut) {
		if ("LOCAL"==localTs) {
			where = " where[AND BKG.POL_CD = SP.VVD_POL]";
		} else if ("TS"==localTs) {
			where = " where[AND BKG.POL_CD <> SP.VVD_POL]";
		}
	}
	var vslCd    = " vslCd["   +formObject.elements["vvd_cd"   ].value.substring(0,4)+ "]";
	var skdVoyNo = " skdVoyNo["+formObject.elements["vvd_cd"   ].value.substring(4,8)+ "]";
	var skdDirCd = " skdDirCd["+formObject.elements["vvd_cd"   ].value.substring(8,9)+ "]";
	var vvdPol   = " vvdPol["  +formObject.elements["vvd_pol"  ].value+"%]";
	var vvdPod   = " vvdPod["  +formObject.elements["vvd_pod"  ].value+"%]";
	var polYdCd  = " polYdCd[" +formObject.elements["pol_yd_cd"].value+"%]";
	var podYdCd  = " podYdCd[" +formObject.elements["pod_yd_cd"].value+"%]";
	var porCd    = " porCd["   +formObject.elements["por_cd"   ].value+"%]";
	var polCd    = " polCd["   +formObject.elements["pol_cd"   ].value+"%]";
	var podCd    = " podCd["   +formObject.elements["pod_cd"   ].value+"%]";
	var delCd    = " delCd["   +formObject.elements["del_cd"   ].value+"%]";
	var usrNm    = " usrNm["+ComGetObjValue(formObject.elements["usr_nm"])+"]";
	var txtVesselName  = " txtVesselName[" +sheetObjects[0].CellValue(1,"vessel_name") +"]";
	var txtNationality = " txtNationality["+sheetObjects[0].CellValue(1,"nationality") +"]";
	var txtOfficialNo  = " txtOfficialNo[" +sheetObjects[0].CellValue(1,"official_no") +"]";
	var txtCallSign    = " txtCallSign["   +sheetObjects[0].CellValue(1,"call_sign")   +"]";
	var txtVoyageNo    = " txtVoyageNo["   +sheetObjects[0].CellValue(1,"voyage_no")   +"]";
	var txtKindOfShip  = " txtKindOfShip[" +sheetObjects[0].CellValue(1,"kind_of_ship")+"]";
	var txtPolName     = " txtPolName["    +sheetObjects[0].CellValue(1,"pol_name")    +"]";
	var txtPodName     = " txtPodName["    +sheetObjects[0].CellValue(1,"pod_name")    +"]";
	var chk = formObject.rdo_manifest_type1.checked+ formObject.rdo_manifest_type2.checked + formObject.rdo_manifest_type3.checked + formObject.rdo_manifest_type4.checked + formObject.rdo_manifest_type5.checked + formObject.rdo_manifest_type6.checked;
	var rvParam = " /rv"+where+vslCd+skdVoyNo+skdDirCd+vvdPol+vvdPod+polYdCd+podYdCd+porCd+polCd+podCd+delCd+usrNm;
	rvParam += txtVesselName;
	rvParam += txtNationality;
	rvParam += txtOfficialNo;
	rvParam += txtCallSign;
	rvParam += txtVoyageNo;
	rvParam += txtKindOfShip;
	rvParam += txtPolName;
	rvParam += txtPodName;
	rvParam += " /riprnmargin /rwait";
	
	var len = formObject.elements.length;
	for (var i=0; i<len; i++) {
		if (formObject.elements[i] && formObject.elements[i].name) {
			if ("com_mrdPath"==formObject.elements[i].name) {
				formObject.elements[i--].removeNode(true);
			}
			if ("com_mrdArguments"==formObject.elements[i].name) {
				formObject.elements[i--].removeNode(true);
			}
		}
	}
//	formObject.elements["com_mrdPath"     ].value = strPath;
//	formObject.elements["com_mrdArguments"].value = rvParam;
	
	//checkbox에 2개 이상 check했을 시에만 RD 데이터 존재유무 check
	if(chk > 1){
		doActionIBSheet(sheetObjects[0], formObject, SEARCH01);

		var popChk = "";
		
		if(formObject.rdo_manifest_type1.checked){
			popChk = "DG";
		}else if(formObject.rdo_manifest_type2.checked){
			popChk = "AWK";			
		}else if(formObject.rdo_manifest_type3.checked){
			popChk = "BB";			
		}else if(formObject.rdo_manifest_type4.checked){
			popChk = "RF";
		}else if(formObject.rdo_manifest_type5.checked){
			popChk = "STWG";
		}

		if(form2.dg.value == "N"){
			formObject.rdo_manifest_type1.checked = false;
		}
		if(form2.awk.value == "N"){
			formObject.rdo_manifest_type2.checked = false;
		}
		if(form2.bb.value == "N"){
			formObject.rdo_manifest_type3.checked = false;
		}
		if(form2.rf.value == "N"){
			formObject.rdo_manifest_type4.checked = false;
		}
		if(form2.stwg.value == "N"){
			formObject.rdo_manifest_type5.checked = false;
		}
		
		chk = formObject.rdo_manifest_type1.checked+ formObject.rdo_manifest_type2.checked + formObject.rdo_manifest_type3.checked + formObject.rdo_manifest_type4.checked + formObject.rdo_manifest_type5.checked + formObject.rdo_manifest_type6.checked;

		if( chk<1 ){
			if(popChk == "DG"){
				formObject.rdo_manifest_type1.checked = true;
			}else if(popChk == "AWK"){
				formObject.rdo_manifest_type2.checked = true;
			}else if(popChk == "BB"){
				formObject.rdo_manifest_type3.checked = true;
			}else if(popChk == "RF"){
				formObject.rdo_manifest_type4.checked = true;
			}else if(popChk == "STWG"){
				formObject.rdo_manifest_type5.checked = true;
			}
		}
	}
	if(formObject.rdo_manifest_type1.checked){
		strTitle = "Danger Cargo Manifest";
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdPath";
		inp.value = "apps/alps/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0891.mrd";
		formObject.appendChild(inp);
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdArguments";
		inp.value = rvParam;
		formObject.appendChild(inp);
	}
	if(formObject.rdo_manifest_type2.checked){
		strTitle = "Awkward Cargo Manifest";
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdPath";
		inp.value = "apps/alps/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0864.mrd";
		formObject.appendChild(inp);
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdArguments";
		inp.value = rvParam;
		formObject.appendChild(inp);
	}
	if(formObject.rdo_manifest_type3.checked){
		strTitle = "Break Bulk Cargo Manifest";
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdPath";
		inp.value = "apps/alps/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0865.mrd";
		formObject.appendChild(inp);
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdArguments";
		inp.value = rvParam;
		formObject.appendChild(inp);
	}
	if(formObject.rdo_manifest_type4.checked){
		strTitle = "Reefer Cargo Manifest";
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdPath";
		inp.value = "apps/alps/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0863.mrd";
		formObject.appendChild(inp);
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdArguments";
		inp.value = rvParam;
		formObject.appendChild(inp);
	}
	if(formObject.rdo_manifest_type5.checked){
		strTitle = "Special Stowage Cargo Manifest";
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdPath";
		inp.value = "apps/alps/esm/bkg/bookingreport/specialreport/report/ESM_BKG_5016.mrd";
		formObject.appendChild(inp);
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdArguments";
		inp.value = rvParam;
		formObject.appendChild(inp);
	}
	if(formObject.rdo_manifest_type6.checked){
		strTitle = "Precaution Cargo Manifest";
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdPath";
		inp.value = "apps/alps/esm/bkg/bookingreport/specialreport/report/ESM_BKG_0935.mrd";
		if ("IN"==inOut) {
			if ("LOCAL"==localTs) {
				where = " where[AND BV.POD_CD LIKE '"+formObject.elements["vvd_pod"].value+"%']";
			} else if ("TS"==localTs) {
				where = " where[AND BV.POD_CD <> '"+formObject.elements["vvd_pod"].value+"']";
			}
		} else if ("OUT"==inOut) {
			if ("LOCAL"==localTs) {
				where = " where[AND BV.POL_CD LIKE '"+formObject.elements["vvd_pol"].value+"%']";
			} else if ("TS"==localTs) {
				where = " where[AND BV.POL_CD <> '"+formObject.elements["vvd_pol"].value+"']";
			}
		}
		formObject.appendChild(inp);
		inp = document.createElement("input");
		inp.type = "hidden";
		inp.name = "com_mrdArguments";
		inp.value = rvParam;
		formObject.appendChild(inp);
	}
	
	if(chk > 1){
		strTitle = "Special Cargo Manifest";
	}
	formObject.elements["com_mrdTitle"].value = strTitle;
	formObject.elements["com_mrdBodyTitle"].value = "<span style='color:red'>"+strTitle+"</span>";
	formObject.elements["com_mrdSaveDialogFileName"].value = formObject.elements["vvd_cd"].value;
	ComOpenRDPopup("width=1024, height=660");
}

/* 개발자 작업  끝 */
