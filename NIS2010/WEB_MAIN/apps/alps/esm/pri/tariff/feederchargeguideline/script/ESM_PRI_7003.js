/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7003.js
 *@FileTitle : Add-on Tariff Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.04
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================
* History                                      
* 2012.11.05 서미진 [CHM-201220395] Add-on management T/F Project                   
* 2013.07.08 서미진 [CHM-201325626] HAMRU 산하 TAE, TAW, ASE, ASW 인 경우 Local Currency 가 기준이 되도록 변경   
* 2013.09.11 전윤주 [CHM-201326761] HAMRU 산하 EAN,EAS 인 경우 Local Currency 가 기준이 되도록 추가                                                 
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7003() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
	this.setTabObject = setTabObject;
}
 
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

document.onclick = processButtonClick;

function processButtonClick() {
	var form = document.form;
	var rdoDateObj = form.rdoDate;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_new":
			doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_ctryPopup":
			selectCountry();
			break;		
		case "btn_pnt_loc_cd" :
		case "btn_bse_port_loc_cd" :
			 var sUrl = "/hanjin/ESM_PRI_4026.do?";
             sUrl += "group_cmd=" + PRI_SP_SCP;
             sUrl += "&location_cmd=L";
             sUrl += "&svc_scp_cd=" + form.svc_scp_cd.Code;
             var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
             if (rtnVal != null){
                 if(srcName == "btn_pnt_loc_cd") {
                     form.pnt_loc_cd.value = rtnVal.cd;
                 }else if(srcName == "btn_bse_port_loc_cd"){
                     form.bse_port_loc_cd.value = rtnVal.cd;
                 }
             }
             break;	
             
        case "btn_calendar": 
        	if(!document.getElementById(srcName).disabled){
                var cal = new ComCalendar();                
                cal.select(document.form.acc_dt, 'yyyy-MM-dd');
        	}
            break; 
             
		}
	} catch (e) {

	}
}

function selectCountry(){
	var parameter = FormQueryString(document.form);
	ComOpenPopup("/hanjin/ESM_PRI_7027.do?" + parameter,565, 480, 'getCountry', "0,1,1,1,1", true);
}

function getCountry(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;
	if ( aryPopupData.length > 0 ) {
		var cntCdVal = "";
		for(var i =0; i < aryPopupData.length; i++) {
			cntCdVal += aryPopupData[i][3];
			if( i < aryPopupData.length-1) {
				cntCdVal += ",";
			}
		}
		formObj.cnt_cd.value = cntCdVal
	}
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBTab Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setTabObject(tab_obj);
 * </pre>
 * @param {ibtab} tab_obj 필수 IBTab Object
 * @return 없음
 * @author 공백진
 * @version 2012.04.17
 */        
 function setTabObject(tab_obj) {
     tabObjects[tabCnt++] = tab_obj;
 }

function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
    // tab 
	for ( var k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	} 
	
	for ( var k = 0; k < comboObjects.length; k++) {
		doActionComboSheet(sheetObjects[0], document.form, comboObjects[k]);
	}
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
	// loading 시 In bound 선택하도록 셋팅
	comboObjects[0].Code = 'D' ;
	initControl();    
	document.form.acc_dt.value = ComGetNowInfo();
	document.form.pnt_loc_cd.focus();
}


function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			style.height = 100;
			SheetWidth = mainTable.clientWidth;

			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = false;
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "ibflag|PNT_LOC_CD|ORG_DEST_TP_CD|SVC_SCP_CD|ACC_DT|BSE_PORT_LOC_CD|SVC TYPE";

			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false);
			InitHeadRow(0, HeadTitle1, true);
			
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter,	true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	true, "pnt_loc_cd", 				false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, 	dtData, 			100, 		daCenter, 	true, 	"org_dest_tp_cd", false, "", dfNone, 0, false, false); 
            InitDataProperty(0, cnt++, 	dtData, 			100, 		daCenter, 	true, 	"svc_scp_cd", false, "", dfNone, 0, false, false); 
            InitDataProperty(0, cnt++, 	dtData, 			100, 		daCenter, 	true, 	"acc_dt", false, "", dfNone, 0, false, false); 
			InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	true, "bse_port_loc_cd", 			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			80, daCenter, 	true, "svc_tp_cd",	 				false, "", dfNone, 0, false, false);		
		}
		break;
	}
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "svc_scp_cd":
		with (comboObj) {
			DropHeight = 260;
			MultiSelect = false;
			MaxSelect = 1;
			UseAutoComplete = true;
			MaxLength = 3;
			IMEMode = 0;
			ValidChar(2, 0);
			SetColWidth("50|350");
		}
		break;
		
	case "org_dest_tp_cd" :	
        var i = 0;
        with (comboObj) {
			DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
			MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
			MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
			UseAutoComplete = true;  
            InsertItem(i++, "In bound", "D");
			InsertItem(i++, "Out bound", "O");
        }
        break;
 	        
	case "svc_tp_cd":
		with (comboObj) {
			DropHeight = 260;
			MultiSelect = false;
			MaxSelect = 1;
			UseAutoComplete = true;

			IMEMode = 0;
			ValidChar(2, 0);
		}
		break;	
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		case IBSEARCH:
            if (!validateForm(sheetObjects[0],document.form,sAction)) {
                return false;
            } 
            sheetObjects[0].RemoveAll();
            var iRow = sheetObjects[0].DataInsert(-1);           
            sheetObjects[0].CellValue(iRow, 'svc_scp_cd') = comboObjects[1].Code; 
            sheetObjects[0].CellValue(iRow, 'org_dest_tp_cd') = comboObjects[0].Code; 
            sheetObjects[0].CellValue(iRow, 'acc_dt') = formObj.acc_dt.value;
            sheetObjects[0].CellValue(iRow, 'pnt_loc_cd') = formObj.pnt_loc_cd.value ;
            sheetObjects[0].CellValue(iRow, 'bse_port_loc_cd') = formObj.bse_port_loc_cd.value ;
            sheetObjects[0].CellValue(iRow, 'svc_tp_cd') = comboObjects[2].Code; 
	        clearAllTabPages();         
	        loadTabPage(tabObjects[0].SelectedIndex);
			break;
			
		case IBCREATE :
			sheetObj.RemoveAll();
			formObj.reset();
			comboObjects[0].Index = 0 ;
			comboObjects[1].Index = -1 ;
			comboObjects[2].Index = -1 ;
			clearAllTabPages();
			document.form.acc_dt.value = ComGetNowInfo();
			tabObjects[0].SelectedIndex = 0;
			formObj.pnt_loc_cd.focus();
			break;
		}
		
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}
}
	

function doActionComboSheet(sheetObj, formObj, comboObjects) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}

		sheetObj.ShowDebugMsg = false;
		switch (comboObjects.id) {
		case "svc_tp_cd":
			comboObjects.RemoveAll();
			comboObjects.InsertItem(0, '', ''); 
			comboObjects.InsertItem(1, 'Add-on', '1'); 
			comboObjects.InsertItem(2, 'IHC', '2'); 
			comboObjects.InsertItem(3, 'Combined', '3'); 
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}		
}	


/**
 * Validation 체크
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if(comboObjects[1].Code == '') {
			ComShowCodeMessage("COM130403", "Service Scope");
			return false;
		}
		// TAE, TAW, ASE, ASW 은 조회 안되도록 변경
		if(comboObjects[1].Code == 'TAE' || comboObjects[1].Code == 'TAW' || comboObjects[1].Code == 'ASE' || comboObjects[1].Code == 'ASW'
	    || comboObjects[1].Code == 'EAN' || comboObjects[1].Code == 'EAS'){
			ComShowCodeMessage("PRI07047");
			return false;
		}
		
		if(formObj.acc_dt.value == '') {
			ComShowCodeMessage("COM130403", "Access Date");
			formObj.acc_dt.focus();
			return false;
		}
		
		if(!ComChkValid(formObj)) {
			return false;
		}
		
		break;
	}
	return true;
}

/**
 * SVC Type에 따른 필수 변경
 */
function svc_tp_cd_OnChange(Index_Code, Text) {
	var formObj = document.form;
	if(Text != '1') {
		formObj.pnt_loc_cd.setAttribute("required", "required");
		formObj.pnt_loc_cd.setAttribute("className", "input1");
	} else {
		formObj.pnt_loc_cd.removeAttribute("required");
		formObj.pnt_loc_cd.setAttribute("className", "input");
	}
}
 
 
 function replaceAll(inputString, targetString, replacement)
 {
	  var v_ret = null;
	  var v_regExp = new RegExp(targetString, "g");
	  v_ret = inputString.replace(v_regExp, replacement);
	  
	  return v_ret;
 }
 
 function DoPaste(){
	event.returnValue=false;
	var a = window.clipboardData.getData('Text');
	var b = replaceAll(a,'\r\n', ',');
	document.form.pnt_loc_cd.value=b;
}
 
 /**
  * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
  * <br><b>Example :</b>
  * <pre>
  *     initControl()
  * </pre>
  * @param 없음
  * @return 없음
  * @author 공백진
  * @version 2012.04.17
  */    
  function initControl() {
	        //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
	    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	 }
 
 /**
  * Onbeforedeactivate  event를 처리한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *     obj_deactivate()
  * </pre>
  * @param 없음
  * @return 없음
  * @author 공백진
  * @version 2012.04.17
  */        
function obj_deactivate() {
    var formObj = document.form;
    var sheetObj = sheetObjects[0]; 
    var eleName = event.srcElement.name;

    switch(eleName){
	      case "acc_dt":
		      ComChkObjValid(event.srcElement);   
		      break;
    }        
}  

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author 서미진
 * @version 2010.11.01
 */
function org_dest_tp_cd_OnChange(comboObj, code, text) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH25;
	formObj.cd.value = "";  // RHQ_CD
	formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
	var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm", true, "");  
}

/**
 * 탭 화면
 *  
 * @return 없음
 * @author 서미진
 * @version 2012.10.04
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Dry", 0);
			InsertTab(cnt++, "Reefer", 1);
			ShowIcon = false;
		}
		break;
	}
}

function tab1_OnChange(tabObj, tabIndex) {
	if (beforetab != tabIndex) {
		var objs = document.all.item("tabLayer");
		objs[tabIndex].style.display = "inline";
		objs[beforetab].style.display = "none";
	}
	beforetab = tabIndex;
	loadTabPage(tabIndex);
}

function loadTabPage(tabIndex) {
	var formObj = document.form;
	if (tabIndex == null || tabIndex == "" || tabIndex == undefined) {
		tabIndex = tabObjects[0].SelectedIndex;
	}

	var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;	
	if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
		var sUrl = "";	
		switch (tabIndex) {
		case 0:
			sUrl = "ESM_PRI_7003_01.do";
			break;
		case 1:
			sUrl = "ESM_PRI_7003_02.do";
			break;
		}
		objTabWindow.location.href = sUrl;		
		return true;
	}
 
	if(sheetObjects[0].RowCount > 0){
		var iRow = sheetObjects[0].SelectRow;
	    var sSvcScpCd = sheetObjects[0].CellValue(iRow, 'svc_scp_cd');
	    var sOrgDestTpCd = sheetObjects[0].CellValue(iRow, 'org_dest_tp_cd');
	    var sAccDt = sheetObjects[0].CellValue(iRow, 'acc_dt');
	    var sPntLocCd = sheetObjects[0].CellValue(iRow, 'pnt_loc_cd');
	    var sBsePortLocCd = sheetObjects[0].CellValue(iRow, 'bse_port_loc_cd');
	    var sSvcTpCd = sheetObjects[0].CellValue(iRow, 'svc_tp_cd'); 
	}

    if (sSvcScpCd != null && sSvcScpCd != "" && sOrgDestTpCd != null && sOrgDestTpCd != "" && sAccDt != null && sAccDt != "") {	
    		document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet(sSvcScpCd, sOrgDestTpCd, sAccDt, sPntLocCd, sBsePortLocCd, sSvcTpCd );
    	}       
}

/**
 * Tab에 로드된 모든 Sheet의 데이터를 Clear한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 *     clearAllTabPages()
 * </pre>
 * @param  없음
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */      
 function clearAllTabPages() {
     for (var i = 0; i < tabObjects[0].GetCount(); i++) {
         if (document.getElementById("t" + (i + 1) + "frame").contentWindow.clearAllForms) {
             document.getElementById("t" + (i + 1) + "frame").contentWindow.clearAllForms();
         }
     }
 }