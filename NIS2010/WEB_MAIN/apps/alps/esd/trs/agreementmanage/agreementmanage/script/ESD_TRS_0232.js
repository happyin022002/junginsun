/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0232.js
*@FileTitle : Agreement Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.29
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2010.03.18 최종혁
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.12.29 최 선     1.1 [CHM-201108115] POP UP resizable 처리
* 2014.05.28 최종혁 [CHM-201430241] AGMT Confirm 기능 추가
* 2015.06.16 9014787 [CHM-201535825] Surcharge confirm 대상 추가
=========================================================*/

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject   = sheetObjects[0];
  var cnt = 0;
  switch(sheetNo) {
  case 1: //sheet_main init
  with (sheetObj) {
	  style.height    = 356; // 높이 설정
	  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
	  Editable = true; //전체Edit 허용 여부 [선택, Default false]
	  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitColumnInfo(29, 5, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, true, true, false,false)
	  var HeadTitle1 = "||Seq|AGMT\nType|AGMT NO|Service Provider|Service Provider|Cost\nMode|Trans\nMode|Cargo\nType|Surcharge|Effective Date\n(Surcharge)|Effective Date\n(Surcharge)|HJS/CNT|CNT\nType|Customer\nCode|Commodity\nCode|Rail\nService|Reference No|Contract\nOffice|Update\nDate|Update\nUser|Update\nOffice|Confirm\n(Manager Level)|Confirm\nUser|Total\nRate" ;
	  var HeadTitle2 = "||Seq|AGMT\nType|AGMT NO|Code|Name|Cost\nMode|Trans\nMode|Cargo\nType|Surcharge|From|To|HJS/CNT|CNT\nType|Customer\nCode|Commodity\nCode|Rail\nService|Reference No|Contract\nOffice|Update\nDate|Update\nUser|Update\nOffice|Confirm\n(Manager Level)|Confirm\nUser|Total\nRate" ;
	  //var HeadTitle2 = "|Seq|AGMT\nType|AGMT NO|Version|Code|Name|Cost\nMode|Cargo\nType|Cargo\nType|Trans\nMode" ;
	  
	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);
	  InitHeadRow(1, HeadTitle2, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,              	    "chk",  false,    "",  dfNone,     0,      true,   true );
	  InitDataProperty(0, cnt++ , dtHiddenStatus,45, daCenter, true,          	     "ibflag",  false,    "",  dfNone,     0,      true,   true,   0,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtSeq,        45,  daCenter, true,     	            "seq",  false,    "",  dfNone,     0,      true,   true,   0,   false,   true,  "", false);	  
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,	 "trsp_agmt_rt_tp_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,           	    "agmt_no",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       60,  daCenter, true,          	   "vndr_seq",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,      140,  daLeft,   true,       		    "vndr_nm",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,  	   "trsp_cost_mod_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,   	    "agmt_trsp_tp_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,         	  "cgo_tp_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,          "scg_exist_flg",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,     	75,  daCenter, true,              "eff_fm_dt",  false,    "",  dfDateYmd,  0,     false,  false,   8,   false,   false, "", false);
	  InitDataProperty(0, cnt++ , dtData,     	75,  daCenter, true,              "eff_to_dt",  false,    "",  dfDateYmd,  0,     false,  false,   8,   false,   false, "", false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,             "hjs_cnt_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtCombo,      50,  daCenter, true,  "cust_nomi_trkr_ind_cd",  false, 	  "",  dfNone,     0,    false,  false,   2,   false,   false,    "",    false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,           		"cust_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,       		"cmdt_grp_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,      100,  daCenter, true,    	 "rail_svc_tp_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,      100,  daCenter, true,       	 	"agmt_ref_no",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,       		"ctrt_ofc_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,      110,  daCenter, true,            	 "upd_dt",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daLeft,   true,        	 "upd_usr_id",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       60,  daCenter, true,        	 "cre_ofc_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,      100,  daCenter, true,                "cfm_flg",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daLeft,   true,        	 "cfm_usr_nm",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);		  
	  //InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,      "rate_tot_cnt",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  //CHM-201535825 Surcharge confirm 대상 추가
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,    "eq_scg_rate_tot_cnt",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,     70,  daCenter, true,   "trsp_agmt_ofc_cty_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,     70,  daCenter, true,          "trsp_agmt_seq",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,     70,  daCenter, true, "trsp_agmt_rt_tp_ser_no",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  
	  //InitDataCombo(0, 'cust_nomi_trkr_ind_cd',	"HJS|CNT|CPT|HPT|MIC",		"HJS|CNT|CPT|HPT|MIC");
	  InitDataCombo(0, 'cust_nomi_trkr_ind_cd',	"SML|CNT|CPT|HPT",		"HJS|CNT|CPT|HPT");
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
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); //khlee-시작 환경 설정 함수 이름 변경
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
	}

}

/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
/* 공통전역변수 */
var openWindownm     = 'AGMT';
var sheetObjects     = new Array();
var sheetCnt         = 0;

document.onclick = processButtonClick;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
var Mincount = 0;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		/* [1.1.조회로직] */
		case "btn_retrieve":
			if( validateFormSearch() ) {
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			}
			break;

			/* [1.2.minimize버튼-화면최소화] */
		case "btn_minimize":
			Mincount = (Mincount+1)%2;
			Minimize(Mincount);
			break;

			/* [1.3.모든정보의 초기화버튼] */
		case "btn_serviceprovider":
			rep_OnPopupClick();
			break;

			/* [1.3.모든정보의 초기화버튼] */
		case "btn_reset":
			reset_all();
			break;

		case "btn_agmtno":
			openAgmtNo();
			break;

			/* [2.1.Rate Inquiry] */
		case "btng_allrateinquiry":
			openAllRateInquiry();
			break;

			/* [2.1.Rate Inquiry] */
		case "btng_rateinquiry":
			openRateInquiry();
			break;

			/* [2.3.Surcharge Inquiry] */
		case "btng_allsurchargeinquiry":
			openAllScgRageInquiry();
			break;

			/* [2.3.Surcharge Inquiry] */
		case "btng_surchargeinquiry":
			openScgRageInquiry();
			break;

			/* [2.7.엑셀다운로드 버튼] */
		case "btng_downexcel":
			sheetObject.Down2Excel(-1, false, false, true);
			break;
			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
		} else {
			ComShowMessage(e);
		}
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
	var formObject = document.form;
	var x1 ="";

	switch(sAction) {
	case IBSEARCH:
		formObj.f_cmd.value = SEARCH01;
		sheetObj.DoSearch4Post("ESD_TRS_0224GS.do", TrsFrmQryString(formObj));
		break;
	case IBDELETE:
		if( sheetObj.CheckedRows("chk") < 1 ) {
			errMsg = ComGetMsg("TRS90036");
			ComShowMessage(errMsg);
			return false;
		} else {
			formObj.f_cmd.value = REMOVE02;
			sheetObj.DoSave("ESD_TRS_0224GS.do", TrsFrmQryString(formObj), -1, false, true);
		}
		break;
	}
}


/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function vndr_change(){
	var formObj = document.form;
	var val = formObj.fm_vndr_select.value;
	formObj.fm_vndr_cd.value ="";
	if(val!="HJS"){
		formObj.fm_vndr_cd.disabled = false;
	}else{
		formObj.fm_vndr_cd.disabled = true;
	}
}

//Include Check Bok를 Click했을 때
function getSubOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.fm_ctrt_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.fm_ctrt_ofc_cd.value = "";
		ComShowMessage("Please input the 'Contract Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0221GS.do?f_cmd="+SEARCH07+"&fm_ctrt_ofc_cd="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.fm_ctrt_ofc_cd.value = document.form.old_ofc_cd.value;
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
			document.form.fm_ctrt_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

function openAllRateInquiry()
{
    var sheetObject = sheetObjects[0];
    var checkList = sheetObject.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var resultcheck = 0;
    if(checkList.length < 1) {
    	ComShowCodeMessage('TRS90215'); 
    	return;
    }
    var chk_agmt_no = sheetObject.CellValue(checkArray[0], 'agmt_no');
    var chk_trsp_agmt_rt_tp_ser_no = sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no');
    var chk_trsp_agmt_rt_tp_cd = sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');
    var formObj = document.form;
    formObj.chk_agmt_no.value = chk_agmt_no;
    formObj.chk_trsp_agmt_rt_tp_ser_no.value = "";
    formObj.chk_trsp_agmt_rt_tp_cd.value = chk_trsp_agmt_rt_tp_cd;

    if(checkArray.length > 1){
        resultcheck = 1;
        for(var i=0; i<checkArray.length-1; i++){
            if(sheetObject.CellValue(checkArray[0], 'agmt_no')+ sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no') 
            		== sheetObject.CellValue(checkArray[i], 'agmt_no') + sheetObject.CellValue(checkArray[i], 'trsp_agmt_rt_tp_ser_no') ){                
            }else{
                resultcheck++;
            }
        }
    }

	if(resultcheck == 1){
		var myOption = "width=1024,height=650,menubar=0,status=0,scrollbars=0,resizable=1";
        var param = "?"+TrsFrmQryString(formObj);
		myWin = window.open('/hanjin/ESD_TRS_0226.do' + param, "popup", myOption);  		
	}else if(resultcheck == 0){
		ComShowCodeMessage('TRS90215');
	}else if(resultcheck > 1){
		ComShowCodeMessage('TRS90357');
	}
}

function openRateInquiry()
{
    var sheetObject = sheetObjects[0];
    var checkList = sheetObject.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var resultcheck = 0;
    if(checkList.length < 1) {
    	ComShowCodeMessage('TRS90215'); 
    	return;
    }
    var chk_agmt_no = sheetObject.CellValue(checkArray[0], 'agmt_no');
    var chk_trsp_agmt_rt_tp_ser_no = sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no');
    var chk_trsp_agmt_rt_tp_cd = sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');

    var formObj = document.form;
    formObj.chk_agmt_no.value = chk_agmt_no;
    formObj.chk_trsp_agmt_rt_tp_ser_no.value = chk_trsp_agmt_rt_tp_ser_no;
    formObj.chk_trsp_agmt_rt_tp_cd.value = chk_trsp_agmt_rt_tp_cd;
    
    if(checkArray.length > 1){
        resultcheck = 1;
        for(var i=0; i<checkArray.length-1; i++){
            if(sheetObject.CellValue(checkArray[0], 'agmt_no')+ sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no') 
            		== sheetObject.CellValue(checkArray[i], 'agmt_no') + sheetObject.CellValue(checkArray[i], 'trsp_agmt_rt_tp_ser_no') ){                
            }else{
                resultcheck++;
            }
        }
    }

	if(resultcheck == 1){
		var myOption = "width=1024,height=650,menubar=0,status=0,scrollbars=0,resizable=1";
        var param = "?"+TrsFrmQryString(formObj);
		myWin = window.open('/hanjin/ESD_TRS_0226.do' + param, "popup", myOption);  		
	}else if(resultcheck == 0){
		ComShowCodeMessage('TRS90215');
	}else if(resultcheck > 1){
		ComShowCodeMessage('TRS90357');
	}
}

function openAllScgRageInquiry()
{
    var sheetObject = sheetObjects[0];
    var checkList = sheetObject.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var resultcheck = 0;
    if(checkList.length < 1) {
    	ComShowCodeMessage('TRS90215'); 
    	return;
    }
    var chk_agmt_no = sheetObject.CellValue(checkArray[0], 'agmt_no');
    var chk_trsp_agmt_rt_tp_ser_no = sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no');
    var chk_trsp_agmt_rt_tp_cd = sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');
    
    var formObj = document.form;
    formObj.chk_agmt_no.value = chk_agmt_no;
    formObj.chk_trsp_agmt_rt_tp_ser_no.value = "";
    formObj.chk_trsp_agmt_rt_tp_cd.value = chk_trsp_agmt_rt_tp_cd;

    if(checkArray.length > 1){
        resultcheck = 1;
        for(var i=0; i<checkArray.length-1; i++){
            if(sheetObject.CellValue(checkArray[0], 'agmt_no')+ sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no') 
            		== sheetObject.CellValue(checkArray[i], 'agmt_no') + sheetObject.CellValue(checkArray[i], 'trsp_agmt_rt_tp_ser_no') ){                
            }else{
                resultcheck++;
            }
        }
    }

	if(resultcheck == 1){
		var myOption = "width=1024,height=645,menubar=0,status=0,scrollbars=0,resizable=1";
        var param = "?"+TrsFrmQryString(formObj);
		myWin = window.open('/hanjin/ESD_TRS_0229.do' + param, "popup", myOption);  		
	}else if(resultcheck == 0){
		ComShowCodeMessage('TRS90215');
	}else if(resultcheck > 1){
		ComShowCodeMessage('TRS90357');
	}
}

function openScgRageInquiry()
{
    var sheetObject = sheetObjects[0];
    var checkList = sheetObject.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var resultcheck = 0;
    if(checkList.length < 1) {
    	ComShowCodeMessage('TRS90215'); 
    	return;
    }
    var chk_agmt_no = sheetObject.CellValue(checkArray[0], 'agmt_no');
    var chk_trsp_agmt_rt_tp_ser_no = sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no');
    var chk_trsp_agmt_rt_tp_cd = sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_cd');

    var formObj = document.form;
    formObj.chk_agmt_no.value = chk_agmt_no;
    formObj.chk_trsp_agmt_rt_tp_ser_no.value = chk_trsp_agmt_rt_tp_ser_no;
    formObj.chk_trsp_agmt_rt_tp_cd.value = chk_trsp_agmt_rt_tp_cd;
    
    if(checkArray.length > 1){
        resultcheck = 1;
        for(var i=0; i<checkArray.length-1; i++){
            if(sheetObject.CellValue(checkArray[0], 'agmt_no')+ sheetObject.CellValue(checkArray[0], 'trsp_agmt_rt_tp_ser_no') 
            		== sheetObject.CellValue(checkArray[i], 'agmt_no') + sheetObject.CellValue(checkArray[i], 'trsp_agmt_rt_tp_ser_no') ){                
            }else{
                resultcheck++;
            }
        }
    }

	if(resultcheck == 1){
		var myOption = "width=1024,height=645,menubar=0,status=0,scrollbars=0,resizable=1";
        var param = "?"+TrsFrmQryString(formObj);
		myWin = window.open('/hanjin/ESD_TRS_0229.do' + param, "popup", myOption);  		
	}else if(resultcheck == 0){
		ComShowCodeMessage('TRS90215');
	}else if(resultcheck > 1){
		ComShowCodeMessage('TRS90357');
	}
}

/**
 * Sheet 확대/축소
 */
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(22);
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(16);
	}
}
 
 /*
  * rep_commodity팝업호출
  */
 function rep_OnPopupClick() {
	 var formObject = document.form;
	 var cmdt_cd_val ="";   //향후 사용가능 예정변수
	 var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	 var cmdt_desc_val ="";   //향후 사용가능 예정변수
	 var classId ="getCOM_ENS_rep";
	 var xx1="";  //CONTI
	 var xx2="";  //SUB CONTI
	 var xx3="";  //COUNTRY
	 var xx4="";  //STATE
	 var xx5="";  //CONTROL OFFIC
	 var xx6="";  //LOC CODE
	 var xx7="";  //LOC NAME
	 var xx8="";
	 var xx9="";

	 var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
 }

/**
 * Service Provider 팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for(var i=0; i<rowArray.length; i++) 
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];
		formObj.fm_vndr_prmry_seq.value =colArray2;
		formObj.fm_vndr_prmry_nm.value =colArray4;
	}
}

/**
 * Service Provider 팝업에서 Return
 */
function vndr_OnPopupClick()
{
	var formObject = document.form;
	var check_vndr= formObject.fm_hjscnt.value;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_vndr";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	
	if(check_vndr=="CNT"){
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 772, 419, 'getCOM_ENS_vndr', '1,0,1,1,1,1,1,1,1,1,1,1');
	}
}

/**
* Customer 팝업호출
*/
function vndr_change(){
	var formObj = document.form;
	var val = formObj.fm_hjscnt.value;
	formObj.fm_cust_cd.value ="";
	if(val!="HJS"){
		formObj.fm_cust_cd.disabled = false;
	}else{
		formObj.fm_cust_cd.disabled = true;
	}
}

/**
 * Customer 팝업에서 Return
 */
function getCOM_ENS_vndr(rowArray) {
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		document.form.fm_cust_cd.value = colArray3;	
	}
}

/**
* 화면 Container Reset
*/
function reset_all(){
	var formObject = document.form;
	formObject.fm_agmtno.value="";
	formObject.fm_vndr_prmry_seq.value="";
    formObject.fm_vndr_prmry_nm.value = "";
    formObject.fm_ctrt_ofc_cd.value = "";
    formObject.chk_office.value = "";
    formObject.old_ofc_cd.value = "";
    formObject.chk_office.value = "";
    formObject.fm_trsp_agmt_rt_tp_cd.value = "A";
    formObject.fm_effective_agmt.value = "C";
    formObject.fm_hjscnt.value = "HJS";
    formObject.fm_cust_cd.value = "";
    formObject.fm_trsp_cost_mod_cd.value = "A";
    formObject.fm_agmt_trsp_tp_cd.value = "";
    formObject.fm_cgo_tp_cd.value = "";
    formObject.fm_rail_svc_tp_cd.value = "";
    formObject.fm_cmdt_grp_cd.value = "";
    formObject.fm_trsp_scg_cd.value = "A";

	formObject.sheet0.RemoveEtcData();
	formObject.sheet0.RemoveAll();
}

/**
* 조회시 필수 항목 유효성검증
*/
function validateFormSearch(){
	var formObj = document.form;
	var agmtno = formObj.fm_agmtno.value;
	var vndr_prmry_seq = formObj.fm_vndr_prmry_seq.value;
	var ctrt_ofc_cd = formObj.fm_ctrt_ofc_cd.value;
	var cust_cd = formObj.fm_cust_cd.value;
	var cmdt_grp_cd = formObj.fm_cmdt_grp_cd.value;

	//Agreement No 정합성 체크
	if (doengnumcheckNoMsg(agmtno) == false || doNumcheckNoMsg(agmtno.substring(3, agmtno.length)) == false) {
		errMsg = ComGetMsg("TRS90533");
		ComShowMessage(errMsg);
		return false;
	}
	
	if( agmtno == "" && vndr_prmry_seq == "" && ctrt_ofc_cd == "" && cust_cd == "" && cmdt_grp_cd == "") { 
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			formObj.fm_agmtno.focus();
			return false;
	}
	return true;
}

/*
* Agreement No조회 팝업 Open
*/
function openAgmtNo() {
	var formObject = document.form;
	var Option = "width=700,height=400,menubar=0,status=0,scrollbars=0,resizable=1";
	var agmt_no = formObject.fm_agmtno.value;   
	var param ="?agmt_no="+agmt_no;
	window.open('/hanjin/ESD_TRS_0233.do' + param, "popup", Option);
}

/*
* Agreement No조회 팝업에서  Agreement No를 리턴받는 함수
*/
function getAgmtNo( value, vndr_seq, vndr_nm, row ){
	var formObject = document.form;
	formObject.fm_agmtno.value = value;
}

/**
* S/P 정보를 조회
*/
function  vender_blur(){
	var formObj = document.form;
	var error_val = "";
	var lvobj = formObj.fm_vndr_prmry_seq.value;
	if(lvobj !=""){
		for (var i = 0; i < lvobj.length; i++)
		{
			var oneChar = lvobj.charAt(i)
			if (oneChar != "")
			{
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val ="Y";
					break;
				}
			}
		}
	}
	if(error_val =="Y" ){
		return;
	}
    formObj.sheet0.RemoveEtcData();
	formObj.f_cmd.value = SEARCH07;
	sheetObjects[0].DoRowSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
	x1 = formObj.sheet0.EtcData('VNDR_NM');
	if(x1 !="" && x1 != undefined){ //
		formObj.fm_vndr_prmry_nm.value = x1;
	}else{
		formObj.fm_vndr_prmry_nm.value = "";
	}
}