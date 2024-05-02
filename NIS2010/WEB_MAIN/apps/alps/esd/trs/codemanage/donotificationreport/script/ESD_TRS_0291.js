/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0291.jsp
*@FileTitle : D/O notification Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 2015-06-03 
* History
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


function ESD_TRS_0291() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수
var sheetObjects 	= new Array();
var sheetCnt 	= 0;
var Mincount 	= 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	/*******************************************************/	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
	
			case "btn_retrieve":
				retrieveAll();	
			break;
			
			case "btn_new":
				formObject.reset();
	            sheetObject.RemoveAll();
	            document.search_fm_yard.removeAll();
	            document.search_to_yard.removeAll();
	            document.search_door_yard.removeAll();
	        break;
				
			case "btns_calendar":
        		cal = new ComCalendarFromTo();
        		cal.select(formObject.f_sent_fm_dt, formObject.f_sent_to_dt, 'yyyy-MM-dd');
        	break;
        	
			case "btns_office":
				if( validation_check() ) {
					var ofc_cd = formObject.f_ctrl_ofc_cd.value;
					ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
				}
			break;
			
			case "btns_fmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;
			
			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;
			
			case "btns_dorloc": //DoorLocation Popup창
				openHireYardPopup('getDorLoc');
			break;
			
			case "btns_tvvd": //Trunk VVD Popup창
				openTVVDPopup("getCOM_ENS_VVD_1");
			break;
			
			case "btns_contract":
				openContractNoPopup();
			break;
			
			case 'btng_exceldown':
				sheetObject.SpeedDown2Excel(true);
			break;
			
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, srcName) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch4Post("ESD_TRS_0291GS.do", TrsFrmQryString(formObj));
		break;
		
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch4Post("ESD_TRS_0291GS.do", TrsFrmQryString(formObj));
		break;


	}
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
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
		case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 430;
				// 전체 너비 설정
				SheetWidth = mainTable1.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 20, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(38, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle0 = "Seq.|S/O Office|Sent Date|CNTR No|TP/SZ|From Node|From Node|To Node|To Node|Door Node|Door Node|Door Node|BKG No|Contract No|T.VVD|Lane|in VVD|ETA|ETA|Rail ETA|Rail ETA|"
					           + "Customer|Customer|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|BROKER#1|BROKER#1|BROKER#2|BROKER#2|A/NTFY #1|A/NTFY #1|A/NTFY #2|A/NTFY #2|One Time Only|One Time Only|";
				var HeadTitle1 ="Seq.|S/O Office|Sent Date|CNTR No|TP/SZ|Location|Node|Location|Node|Location|Node|Name|BKG No|Contract No|T.VVD|Lane|in VVD|Date|Time|Date|Time|"
					           +"Code|Name|Result|Email/Fax|Result|Email/Fax|Result|Email/Fax|Result|Email/Fax|Result|Email/Fax|Result|Email/Fax|Result|Email/Fax|";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,    DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, 	CALCULOGIC, 	DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDataSeq,    	40,   	daCenter,  true,   "seq");
				InitDataProperty(0, cnt++ , dtData,       	80,   	daCenter,  true,   "ctrl_ofc_cd",			false,		"",			dfNone,         	0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	80,   	daCenter,  true,   "ntc_snd_dt",  			false,		"",			dfDateYmd,			0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	100,   	daCenter,  true,   "cntr_no",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	60,   	daCenter,  true,   "cntr_tpsz_cd",			false,		"",			dfNone,         	0,       false,		false,		0,		false,		true,	   "",	  false);				
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "fm_nod_cd",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	60,   	daCenter,  true,   "fm_yard_cd",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "to_nod_cd",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	60,   	daCenter,  true,   "to_yard_cd",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "dor_nod_cd",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	60,   	daCenter,  true,   "dor_yard_cd",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	150,   	daLeft,    true,   "dor_nod_nm",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	100,   	daCenter,  true,   "bkg_no",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	100,   	daCenter,  true,   "sc_no",					false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	90,   	daCenter,  true,   "trnk_vvd_cd",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	60,   	daCenter,  true,   "slan_cd",				false,		"",			dfNone,         	0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	90,   	daCenter,  true,   "ib_vvd_cd",  			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	80,   	daCenter,  true,   "eta_dt",	  			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	60,   	daCenter,  true,   "eta_time",	  			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	80,   	daCenter,  true,   "rail_eta_dt",	  			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	60,   	daCenter,  true,   "rail_eta_time",	  			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	60,   	daCenter,  true,   "cust_seq",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	250,   	daCenter,  true,   "cust_nm",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "result_1",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	150,   	daLeft,    true,   "eml_fax_1",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "result_2",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	150,   	daLeft,    true,   "eml_fax_2",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "result_3",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	150,   	daLeft,    true,   "eml_fax_3",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "result_4",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	150,   	daLeft,    true,   "eml_fax_4",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "result_5",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	150,   	daLeft,    true,   "eml_fax_5",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "result_6",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	150,   	daLeft,    true,   "eml_fax_6",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	80,   	daCenter,  true,   "result_7",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	150,   	daLeft,    true,   "eml_fax_7",				false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   	daCenter,  true,   "ibflag");

			}
			break;
	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function hidden_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} 	
}

//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.f_ctrl_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.f_ctrl_ofc_cd.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		document.form.f_ctrl_ofc_cd.disabled = false;
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = "";
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
		document.form.f_ctrl_ofc_cd.disabled = true;
	} else {		
		document.form.f_ctrl_ofc_cd.value = document.form.old_ofc_cd.value;
		document.form.f_ctrl_ofc_cd.disabled = false;
	}
}

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.f_ctrl_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.f_ctrl_ofc_cd.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.f_ctrl_ofc_cd.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;
		} else {
			ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
			return false;
		}
	}
}

/**
* From Node 팝업에 대한 리턴값
*/
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_node.value = lvLoc;
	getYardCombo(document.search_fm_yard, sheetObjects[0], formObject, lvLoc);
	document.search_fm_yard.CODE = lvYard;
}

/**
* To Node 팝업에 대한 리턴값
*/
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_to_node.value = lvLoc;
	getYardCombo(document.search_to_yard, sheetObjects[0], formObject, lvLoc);
	document.search_to_yard.CODE = lvYard;
}

/**
* Door Location 팝업에 대한 리턴값
*/
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door.value = lvLoc;
	getZoneCombo(document.search_door_yard, sheetObjects[0], formObject, lvLoc);
	document.search_door_yard.CODE = lvYard;
}

/**
* Trunk VVD return value
*/
function getCOM_ENS_VVD_1(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.f_trnk_vvd.value = colArray[7] + gubun;
}

/**
* 공통 Node popup
*/
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v6 = "";
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	if( objName == "getDorLoc" ) {
		v6 = "zone"
	} else {
		v6 = "yard";
	}

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
* 공통 Trunk VVD popup
*/
function openTVVDPopup(obj) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v1 = ""; //ETDETA
	var v2 = ""; //SDATE
	var v3 = ""; //EDATE
	var v4 = ""; //VVD_CD
	var v5 = ""; //LOC_CD
	var v6 = ""; //LANE_CD
	var v7 = ""; //OPER
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = obj;

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 450, classId, '1,0,1,1,1,1,1,1');
}

/**
* 공통 Contract No popup
*/
function openContractNoPopup() {
	
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getContractNo";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="true";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var flag="";
	var cont_tp = '';
	var cont_no = '';

	if(formObject.f_sc_no.value != '' && formObject.f_sc_no.value.length > 2) {
		cont_tp = formObject.f_sc_no.value.substring(0,3);
		cont_no = formObject.f_sc_no.value.substring(3);
	}
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	param += "&flag=1";
	param += "&cont_tp="+cont_tp;
	param += "&cont_no="+cont_no;

	ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 772, 450, 'getContractNo', '1,0,1,1,1,1,1,1,1,1,1,1');
}

function getContractNo(rowArray){
	var formObject = document.form;

	var colArray = rowArray[0];
	var in_val = colArray[2];
	formObject.f_sc_no.value = in_val;

}

function retrieveAll(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	formObject.f_fm_node.value = formObject.search_fm_node.value + formObject.search_fm_yard.Code;
	formObject.f_to_node.value = formObject.search_to_node.value + formObject.search_to_yard.Code;
	formObject.f_door.value = formObject.search_door.value + formObject.search_door_yard.Code;
	
	if((formObject.f_trnk_vvd.value != null && formObject.f_trnk_vvd.value != '') ||
			(formObject.f_bkg_no.value != null && formObject.f_bkg_no.value != '') ||
			(formObject.f_cntr_no.value != null && formObject.f_cntr_no.value != '') ||
			(formObject.f_sc_no.value != null && formObject.f_sc_no.value != ''))
	{
		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	} else {
		if(formObject.f_sent_fm_dt.value == null || formObject.f_sent_fm_dt.value == '' ||
		   formObject.f_sent_to_dt.value == null || formObject.f_sent_to_dt.value == ''){
			ComShowCodeMessage("TRS90720");
		} else if(formObject.f_ctrl_ofc_cd.value == null || formObject.f_ctrl_ofc_cd.value == ''){
			ComShowCodeMessage("TRS90721");
		} else {
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
		}
	}			
}

function doSearchEnter(){
	if( event.keyCode == 13 ) {
		retrieveAll();
	}
}

/**
 * 외부 콤보박스의 리스트 가져오기
 **/
function getComboList(obj)
{
	
	var yard_obj = null;
	var formObj = document.form;
	obj.value = obj.value.toUpperCase();
	var locValue = obj.value;

	if(obj.name == 'search_fm_node'){
		yard_obj = document.search_fm_yard;
	}else if(obj.name == 'search_to_node'){
		yard_obj = document.search_to_yard;
	}else if(obj.name == 'search_door'){
		yard_obj = document.search_door_yard;
	}
	
	if(obj.name == 'search_door') {
		getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}else{
		getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}
	
}

//'포커스주기
function fun_Focus(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

function removeBar(str) {
    var value = "";
    for ( var i = 0; i < str.length; i++ ) {
    var ch = str.charAt(i);
    if ( ch != '-' ) value = value + ch;
    }
    return value;
}


/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){			
			case 'search_fm_node':
			case 'search_to_node':
			case 'search_door':
				getComboList(obj);
				break;
		}
	}
}


/**
 * 팝업호출
 */
function do_OnPopupClick(val) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_so";
	var xx1=val;  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var title = val;
	
	var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}



/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject = document.form;
	
	
	if(returnval=="T.VVD") {
		var x1=document.form.f_trnk_vvd.value;
		if(x1==""){
			document.form.f_trnk_vvd.value = rowArray;
			formObject.f_trnk_vvd.focus();
		}else{
			document.form.f_trnk_vvd.value = document.form.f_trnk_vvd.value+","+rowArray;
			formObject.f_trnk_vvd.focus();
		}
	}else if(returnval=="Booking No"){
		var x2=document.form.f_bkg_no.value;
		if(x2==""){
			document.form.f_bkg_no.value = rowArray;
			formObject.f_bkg_no.focus();
		}else{
			document.form.f_bkg_no.value = document.form.f_bkg_no.value+","+rowArray;
			formObject.f_bkg_no.focus();
		}
	}else if(returnval=="Container No"){
		var x3=document.form.f_cntr_no.value;
		if(x3==""){
			document.form.f_cntr_no.value = rowArray;
			formObject.f_cntr_no.focus();
		}else{
			document.form.f_cntr_no.value = document.form.f_cntr_no.value+","+rowArray;
			formObject.f_cntr_no.focus();
		}
	}else if(returnval=="Contract No"){
		var x4=document.form.f_sc_no.value; 
		if(x4==""){
			document.form.f_sc_no.value = rowArray;
			formObject.f_sc_no.focus();
		}else{
		    document.form.f_sc_no.value = document.form.f_sc_no.value+","+rowArray;
			formObject.f_sc_no.focus();
		}	
	}
}
