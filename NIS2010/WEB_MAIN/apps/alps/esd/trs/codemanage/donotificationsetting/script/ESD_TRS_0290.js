/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0290.jsp
*@FileTitle : D/O notification Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-27
*@LastModifier : geun hwan park
*@LastVersion : 1.0
* 2016-05-27 geun hwan park
* History
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


function ESD_TRS_0290() {
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
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

			case "btn_new":
				fn_reset();
			break;
					
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
				
			/* [Effective Date] */
			case "btns_onecalendar":
				var cal = new ComCalendar();
        		cal.select(formObject.f_eff_dt, 'yyyyMMdd');
        	break;
			
			case 'btng_rowadd':
				sheetObject.DataInsert(-1);
			break;
			
			case 'btng_rowdel':
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
			
			case "btns_contract":
				openContractNoPopup();
			break;
			
			case "btns_dorloc": //DoorLocation Popup창
				openHireYardPopup('getDorLoc');
			break;
			
			case "btng_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
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


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, srcName) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch4Post("ESD_TRS_0290GS.do", TrsFrmQryString(formObj));
		break;

		case IBSAVE	:
			var checkList = sheetObj.FindCheckedRow('chk');
			if(checkList == '') {
				ComShowCodeMessage('COM12176');
				return false;
			}
			if(validSave(sheetObj)){
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESD_TRS_0290GS.do", TrsFrmQryString(formObj), 'chk');
			}
		break;
		
		case IBDELETE :
			var checkList = sheetObj.FindCheckedRow('chk');
			if(checkList == '') {
				ComShowCodeMessage('COM12176');
				return false;
			}
			formObj.f_cmd.value = REMOVE;
			sheetObj.DoSave("ESD_TRS_0290GS.do", TrsFrmQryString(formObj), 'chk');
		break;
		
		//ExcelDownload
		case IBDOWNEXCEL :
			sheetObj.SpeedDown2Excel(-1, false);
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
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
	var formObject = document.form;
    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
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
				style.height = GetSheetHeight(18) ;
				// 전체 너비 설정
				SheetWidth = mainTable1.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 10, 100);

				var HeadTitle1 = "Sel|Seq|Active|Contract|Contract|Contract|Contract|Contract|Door Location|Door Location|Door Location|Update Date|Update\nUser Name|||";
				var HeadTitle2 = "Sel|Seq|Active|Type|No.|Customer Name|Effective Date|Expire Date|Loc|Zone|Name|Update Date|Update\nUser Name|||";

				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				//해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				HeadRowHeight = 12;
				//데이터속성    [ROW, COL,    DATATYPE,   	WIDTH,     DATAALIGN, COLMERGE, SAVENAME,  			 KEYFIELD, 	CALCULOGIC, 	DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox, 	40,   	daCenter,  true,   "chk");
				InitDataProperty(0, cnt++ , dtDataSeq,    	40,   	daCenter,  true,   "seq");
				InitDataProperty(0, cnt++ , dtCombo,   		50,   	daCenter,  true,   "ntfc_act_flg",			false,		"",			dfNone,         	0,       true,		true,		1,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtCombo,       	55,   	daCenter,  true,   "ctrt_tp_cd",					false,		"",			dfNone,         	0,       true,		true,		20,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	90,   	daCenter,  true,   "sc_no",					false,		"",			dfNone,         	0,       true,		true,		20,		false,		true,	   "",	  false);				
				InitDataProperty(0, cnt++ , dtData,     	130,   	daLeft,    true,   "ctrt_cust_nm",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,     	100,   	daCenter,  true,   "ctrt_eff_dt",  			false,		"",			dfDateYmd,			0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	100,   	daCenter,  true,   "ctrt_exp_dt",			false,		"",			dfDateYmd,			0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	70,   	daCenter,  true,   "dest_nod_cd",			false,		"",			dfNone,				0,       true,		true,		5,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,       	70,   	daCenter,  true,   "dest_nod_yd",			false,		"",			dfNone,				0,       true,		true,		2,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	130,   	daLeft,    true,   "dest_nod_nm",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtData,        	100,   	daCenter,  true,   "upd_dt",				false,		"",			dfDateYmd,			0,       false,		false);
				InitDataProperty(0, cnt++ , dtData,       	130,   	daLeft,    true,   "upd_usr_nm",			false,		"",			dfNone,				0,       false,		false,		0,		false,		true,	   "",	  false);
				InitDataProperty(0, cnt++ , dtHidden,       80,   	daCenter,  true,   "do_ntfc_set_seq",		false,		"",			dfNone,				0,       false,		false);
				InitDataProperty(0, cnt++ , dtHidden,       80,   	daCenter,  true,   "ctrt_cust_cd",			false,		"",			dfNone,         	0,       false,		false);
				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   	daCenter,  true,   "ibflag");
				
				InitDataCombo(0, 'ctrt_tp_cd', "S/C|RFA", "S|R");
				InitDataCombo(0, 'ntfc_act_flg', "Y|N", "Y|N");
				InitDataValid(0, 'dest_nod_cd',  vtEngUpOnly);
			}
			break;
	
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} 
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
//		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == MULTI){
			ComShowCodeMessage('COM130102', 'Data');
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else if(formObj.f_cmd.value == REMOVE){
			var checkList = sheetObj.FindCheckedRow('chk');
			var checkArray = checkList.split('|');

			for(var k=checkArray.length-sheetObj.HeaderRows; k>=0; k--){
				sheetObj.RowDelete(checkArray[k-1], false);
			}
		}
	}
}


/**
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row , col , value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);

	switch(colName){
		case 'sc_no':
			if(sheetObj.CellValue(row, "sc_no") != "") {
				var sc_no = sheetObj.CellValue(row, "sc_no");
				
				formObj.f_cmd.value = SEARCH02;
				var queryString = "sc_no="+sc_no;
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0290GS.do",TrsFrmQryString(formObj)+"&"+ queryString);
				var arrXml = sXml.split("|$$|");
		
		 		if( ComGetTotalRows(sXml) == 0 ) {
		 			sheetObj.CellValue2(row, 'sc_no') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_cd') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_nm') = "";
		 			sheetObj.CellValue2(row, 'ctrt_eff_dt') = "";
		 			sheetObj.CellValue2(row, 'ctrt_exp_dt') = "";
		 		} else if( ComGetTotalRows(sXml) > 0 ) {
					var list = TrsXmlToListMap(arrXml);
					if( list.length > 0 ) {
						sheetObj.CellValue2(row, 'ctrt_cust_cd')	= list[0]["cust_cd"];
						sheetObj.CellValue2(row, 'ctrt_cust_nm')	= list[0]["cust_nm"];
						sheetObj.CellValue2(row, 'ctrt_eff_dt')		= list[0]["eff_dt"];
						sheetObj.CellValue2(row, 'ctrt_exp_dt')		= list[0]["exp_dt"];
					}
		 		}
			}
		break;
		case 'dest_nod_cd':
			if( sheetObj.cellValue(row, 'dest_nod_cd') != '' ){
				getZoneSheetCombo1(sheetObj, formObj, row, col, 'dest_nod_yd', value);
			}

		break;

		case 'dest_nod_yd':
			var dor_loc = sheetObj.cellValue(row, 'dest_nod_cd');
			var dor_yard = sheetObj.cellValue(row, 'dest_nod_yd');
			
			if(dor_loc!= '' && dor_yard != ''){
				formObj.f_cmd.value = SEARCH03;
				var queryString = "dest_nod_cd="+dor_loc+dor_yard;
				var sXml = sheetObj.GetSearchXml("ESD_TRS_0290GS.do",TrsFrmQryString(formObj)+"&"+ queryString);
				var arrXml = sXml.split("|$$|");
				
		 		if( ComGetTotalRows(sXml) == 0 ) {
		 			sheetObj.CellValue2(row, 'dest_nod_nm') = "";
		 		} else if( ComGetTotalRows(sXml) > 0 ) {
					var list = TrsXmlToListMap(arrXml);
					if( list.length > 0 ) {
						sheetObj.CellValue2(row, 'dest_nod_nm')	= list[0]["zn_nm"];
					}
		 		}
			}
		break;
	}
}

/***
 * Save시 Validation 
 */
function validSave(sheetObj){
	var rtnVal 		= true;
	var chkScNo 	= true;
	var chkCustCd 	= true;
	var chkDorNod 	= true;
	var checkList 	= sheetObj.FindCheckedRow('chk');
	var arrRow 		= checkList.split("|");
	
	for(var i=0;i<arrRow.length-1;i++){
		if(sheetObj.CellValue(arrRow[i],"sc_no")==""){
			if(chkScNo){
				chkScNo = false;
			}
		}else if(sheetObj.CellValue(arrRow[i],"cntr_cust_cd")==""){
			if(chkCustCd){
				chkCustCd = false;
			}
		}else if(sheetObj.CellValue(arrRow[i],"dest_nod_cd")=="" || sheetObj.CellValue(arrRow[i],"dest_nod_yd")==""){
			if(chkDorNod){
				chkDorNod = false;
			}
		}
	}
	
	if(chkScNo == false){
		errMsg = ComGetMsg("COM12114","S/C No");
		ComShowMessage(errMsg);
		rtnVal = false;
	}else if(chkCustCd==false){
		errMsg = ComGetMsg("COM12114","Customer code");
		ComShowMessage(errMsg);
		rtnVal = false;
	}else if(chkDorNod==false){
		errMsg = ComGetMsg("COM12114","Door code");
		ComShowMessage(errMsg);
		rtnVal = false;	
	}
	
	return rtnVal
}


/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){
	var formObject = document.form;	
	formObject.f_sc_no.value = '';
	formObject.f_eff_dt.value = '';
	formObject.f_dor_nod_cd.value = '';
	formObject.f_dor_nod_yd.value = '';
	formObject.f_act_flg.value = '';
	sheetObjects[0].RemoveAll();  //Master sheet

}	



/**
 * 
 */
function obj_keypress(){
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;

    switch(obj.dataformat) {
        case "engup":
            if(obj.name=="f_sc_no" ||obj.name=="f_dor_nod_cd"  ){
				ComKeyOnlyAlphabet('uppernum');	
			}
        break;
    }
}


/**
 *	Inquiry Option
 *	Door Location input, Yard Inquiry
 */
function getComboList(obj){
	var yard_obj = null;
	var formObj = document.form;
	obj.value = obj.value.toUpperCase();
	var locValue = obj.value;

	if(ComTrim(locValue) == ''){
		yard_obj.RemoveAll();
		return;
	}
	if(obj.name == 'f_dor_nod_cd'){
		yard_obj = document.f_dor_nod_yd;
		getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}

}


/**
* 공통 Node popup
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
	
	if(formObject.f_ctrt_tp_cd.value = 'S') flag = "1";
	else if(formObject.f_ctrt_tp_cd.value = 'R') flag = "2";

	if(formObject.f_sc_no.value != '' && formObject.f_sc_no.value.length > 2) {
		cont_tp = formObject.f_sc_no.value.substring(0,3);
		cont_no = formObject.f_sc_no.value.substring(3);
	}
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	param += "&flag="+flag;
	param += "&cont_tp="+cont_tp;
	param += "&cont_no="+cont_no;

	ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 772, 450, 'getCOM_ENS_021', '1,0,1,1,1,1,1,1,1,1,1,1');
}


/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_021(rowArray) {
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var in_val = colArray[2];
		formObject.f_sc_no.value  = in_val;
	}
}


/**
 * 공통 Node popup
 */
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
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
 * Door Location 팝업에 대한 리턴값
 */
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
		
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.f_dor_nod_cd.value = lvLoc;
	getZoneCombo(document.f_dor_nod_yd, sheetObjects[0], formObject, lvLoc);
	document.f_dor_nod_yd.CODE = lvYard;
}