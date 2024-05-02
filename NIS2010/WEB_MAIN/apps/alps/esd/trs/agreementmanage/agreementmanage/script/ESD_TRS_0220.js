/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0220.js
*@FileTitle : Agreement Header
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-18
*@LastModifier : cjh
*@LastVersion : 1.0 
* 2010-03-18 cjh
* 1.0 최초 생성
* HISTORY
=========================================================*/

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * 구주 S/O
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject   = sheetObjects[0];
  var sheetObject1  = sheetObjects[1];
  var cnt = 0;
  switch(sheetNo) {
  case 1: //sheet0 init ( Child S/P )
  with (sheetObj) {
	  // 높이 설정
	  style.height = GetSheetHeight(3);
	  //전체 너비 설정
	  SheetWidth = mainTable.clientWidth;

	  //Host정보 설정[필수][HostIp, Port, PagePath]
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	  //전체Merge 종류 [선택, Default msNone]
	  MergeSheet = msHeaderOnly;

	  //전체Edit 허용 여부 [선택, Default false]
	  Editable = true;

	  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitRowInfo( 1, 1, 9, 100);

	  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  InitColumnInfo(7, 0, 0, true);

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, false, true, false,false)

	  var HeadTitle1 = "Del.|STS|SEQ|Child Service\nProvider|Child Service\nProvider" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtDelCheck,    30,  daCenter, true,   "check",   false,   "",  dfNone,   0,  true,  true );
	  InitDataProperty(0, cnt++ , dtStatus,30,  daCenter, true,   "ibflag",  false,   "",  dfNone,   0,  true,  true,    0, false, true,     "",    false);
	  InitDataProperty(0, cnt++ , dtSeq,         30, daCenter,  true,   "",        false,   "",  dfNone,   0,  false, false,   0, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,        50, daCenter,  true,   "vndr_seq",true,    "",  dfNone,   0,  false, true,   10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtPopup,       40, daLeft,    true,   "vndr_nm", false,   "",  dfNone,   0,  false, true,  100, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,        40, daLeft,    true,   "trsp_agmt_ofc_cty_cd", false,   "",  dfNone,   0,  false, true,  100, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,        40, daLeft,    true,   "trsp_agmt_seq", false,   "",  dfNone,   0,  false, true,  100, false, true,  "", false);

	  CountPosition = 0 ;
	  HeadRowHeight = 25;
  }
  break;
  case 2: //sheet2 init ( ATMT Header ) Hidden Sheet
  with (sheetObj) {
	  // 높이 설정
	  style.height = 100;
	  //전체 너비 설정
	  SheetWidth = mainTable.clientWidth;

	  //Host정보 설정[필수][HostIp, Port, PagePath]
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	  //전체Merge 종류 [선택, Default msNone]
	  MergeSheet = msHeaderOnly;

	  //전체Edit 허용 여부 [선택, Default false]
	  Editable = true;

	  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitRowInfo( 1, 1, 9, 100);

	  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  InitColumnInfo(11, 0, 0, true);

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, false, true, false,false)

	  var HeadTitle1 = "Ststus|AGMT CITY CODE|AGMT NO|VNDR_SEQ|VNDR_NM|CONTRACT OFFICE CODE|REFERENCE NUMBER|PIC NAME|REMARK|OFC_CD|USR_ID" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
      InitDataProperty(0, cnt++ , dtStatus, 45, daCenter,true,   "ibflag",              false,   "",  dfNone,   0,  true,  true,   0,  false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "trsp_agmt_ofc_cty_cd",false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "trsp_agmt_seq",       false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "vndr_prmry_seq",      false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "vndr_prmry_nm",       false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);	  
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "ctrt_ofc_cd",         false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "agmt_ref_no",         false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "agmt_pic_nm",         false,   "",  dfNone,   0,  true, true,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "inter_rmk",           false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "cre_ofc_cd",          false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "cre_usr_id",          false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);

	  CountPosition = 0 ;
	  HeadRowHeight = 25;
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
	if(document.form.fm_agmtno.value!=""){
		doSearch();
	}	
}

/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
/* 공통전역변수 */
var openWindownm     = 'AGMT';
var sheetObjects     = new Array();
var sheetCnt         = 0;

document.onclick = processButtonClick;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];

    /*******************************************************/
    var formObject = document.form;

   try {
       var srcName = window.event.srcElement.getAttribute("name");
       switch(srcName) {
			/* [1.1.상단 로우추가버튼] */
			case "btn_rowadd":
				var agmt_ofc_cty_cd = formObject.fm_trsp_agmt_ofc_cty_cd.value;
				if(agmt_ofc_cty_cd == "") return;
				doActionIBSheet(sheetObject,formObject,"INSERT");
			break;
			/* [1.2.상단 로우삭제버튼] */
			case "btn_delete":
				doActionIBSheet(sheetObject,formObject,"DELETE");
			break;
			
			/* [1.3.상단의 저장버튼] */
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,"SAVE");
			break;
			
			/* [1.3.service provider의 팝업버튼] */
			case "btn_provider":
			    rep_OnPopupClick();
			break;
			
			/* [2.1.조회로직] */
			case "btng_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			
			/* [2.2.하단  Creation버튼] */
			case "btng_create":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
			/* [2.3.하단  Update버튼] */
			case "btng_update":
				doActionIBSheet(sheetObject1,formObject,"IBUPDATE");
			break;
			/* [2.4.하단  Ok버튼] */
			case "btng_ok":
				var opener_obj = window.dialogArguments;	
				opener.form.fm_agmtno.value = form.fm_agmtno.value;
				opener.doActionIBSheet(opener.sheetObjects[2],formObject,IBSEARCH);
				window.close();
			break;
			/* [2.5.하단  Close버튼] */
			case "btng_close":
    	        window.close();
    	    break;
    	    /* [2.6.하단  New버튼] */
			case "btng_new":
				document.form.fm_vndr_prmry_seq.readOnly = false;
				document.form.fm_agmt_ref_no.readOnly = false;
				document.form.fm_ctrt_ofc_cd.readOnly = false;
				sheetObject.RemoveAll();
	            sheetObject1.RemoveAll();
	            formObject.reset();
	            formObject.fm_agmtno.value="";
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
       case "INSERT":
   	    	var row = sheetObj.DataInsert();
   	    	sheetObj.CellValue(row, "trsp_agmt_ofc_cty_cd") = formObject.fm_agmtno.value.substring(0,3);
   	    	sheetObj.CellValue(row, "trsp_agmt_seq") = formObject.fm_agmtno.value.substring(3);
   	    	break;
       case "DELETE":
			var checkList = sheetObj.FindCheckedRow('check');
			var checkArray = checkList.split('|');
			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}
  	        break;
       case "SAVE":
	   	    formObj.f_cmd.value = MULTI;
	   	    sheetObjects[0].DoSave("ESD_TRS_0220GS.do", TrsFrmQryString(formObj),-1,false);
  	    	break;
       case IBSEARCH:
	   	    formObj.f_cmd.value = SEARCH01;
			sheetObjects[1].DoSearch4Post("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));

		    formObj.f_cmd.value = SEARCH02;
			sheetObjects[0].DoSearch4Post("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));

			break;
       case IBSAVE:
    	    if (!valcheck()) return;
    	    formObj.sheet1.RemoveEtcData();
    	    setAgreementInfo(); //중복체크를 위해 Agreement Header정보를 IbSheet에 셋팅
			formObj.f_cmd.value = SEARCH03;
			var queryStr = sheetObjects[1].GetSaveString(true, true);

			sheetObj.DoSearch4Post("ESD_TRS_0220GS.do", queryStr+"&"+TrsFrmQryString(formObj), "", true); //Agreement 중복체크
			x1 = formObject.sheet1.EtcData('CNT_CD_AGREE');
			if(x1 =="" || x1 == undefined){ //존재하는 Agreement no가 없으면 AGMT를 생성한다.
				setAgreementInfo(); //중복체크를 위해 Agreement Header정보를 IbSheet에 셋팅
			
			    formObj.sheet1.RemoveEtcData();
			    queryStr = sheetObjects[1].GetSaveString(true, true);
				formObj.f_cmd.value = SEARCH04;
			    sheetObj.DoSearch4Post("ESD_TRS_0220GS.do", queryStr+"&"+TrsFrmQryString(formObj), "", true); //Agreement 생성
			    x1 = formObject.sheet1.EtcData('NEW_AGMT_NO');

				if(x1 !="" && x1 != undefined){ //
					formObject.fm_agmtno.value = x1;
				    formObj.f_cmd.value = SEARCH02;
					sheetObjects[0].DoSearch4Post("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
				}else{
					formObject.fm_agmtno.value = "";
				}
			}else{
				ComShowCodeMessage('TRS90032', '');
			}
    	    break;
       case "IBUPDATE":
	   	    if (!valcheck()) return;
	   	    sheetObj.RemoveEtcData();
//	   	    formObj.fm_ctrt_ofc_cd.value = sheetObj.CellValue(1, "ctrt_ofc_cd");
	   	    setAgreementInfo();
	   	    sheetObj.CellValue(1, "ibflag") = 'U';
	   	    sheetObj.CellValue(1, "trsp_agmt_ofc_cty_cd") = formObject.fm_agmtno.value.substring(0,3);
	   	    sheetObj.CellValue(1, "trsp_agmt_seq") = formObject.fm_agmtno.value.substring(3);
		    formObj.f_cmd.value = MODIFY;
    	    sheetObjects[1].DoSave("ESD_TRS_0220GS.do", TrsFrmQryString(formObj),-1,false);
    	    ComShowCodeMessage('TRS90405');
    	    break;
    }
}

function doSearch() {
	var sheetObject = sheetObjects[0];
	var formObject  = document.form;
	doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
}

function doSearchEnter() {
	if( event.keyCode == 13 ) {
		doSearch();
	}
}

/**
 * 조회후 발생하는 EVENT
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg){
	//RowCount
	var formObj = document.form;
	var fCmd = formObj.f_cmd.value;
	if (fCmd == SEARCH01) { //Agreement 조회
		if(sheetObj.RowCount > 0) {
		    formObj.fm_vndr_prmry_seq.value = sheetObj.CellValue(1, "vndr_prmry_seq");
		    formObj.fm_vndr_prmry_nm.value  = sheetObj.CellValue(1, "vndr_prmry_nm");
		    formObj.fm_agmt_ref_no.value  = sheetObj.CellValue(1, "agmt_ref_no");
		    formObj.fm_ctrt_ofc_cd.value  = sheetObj.CellValue(1, "ctrt_ofc_cd");
		    formObj.fm_inter_rmk.value    = sheetObj.CellValue(1, "inter_rmk");
		    formObj.fm_trsp_agmt_ofc_cty_cd.value    = sheetObj.CellValue(1, "trsp_agmt_ofc_cty_cd");
			
		    formObj.fm_vndr_prmry_seq.readOnly = true;
		    formObj.fm_agmt_ref_no.readOnly = true;
		    formObj.fm_ctrt_ofc_cd.readOnly = true;
		}else{
		    formObj.fm_vndr_prmry_seq.value = "";
		    formObj.fm_vndr_prmry_nm.value  = "";
		    formObj.fm_agmt_ref_no.value  = "";
		    formObj.fm_ctrt_ofc_cd.value  = "";
		    formObj.fm_inter_rmk.value    = "";
		    formObj.fm_trsp_agmt_ofc_cty_cd.value  = "";
		}
	}else if (fCmd == SEARCH03) { //Agreement NO 존재여부 체크
		
	}else if (fCmd == SEARCH04) { //Agreement NO 생성
		
	}else if (fCmd == SEARCH05) { //S/P명칭 조회
		
	}
	sheetObj.RowDelete(1, false); //자료를 HTML Form에 셋팅하고 ibsheet의 자료는 삭제한다.
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

/**
 * OnChange event
 *
 */
function sheet0_OnChange(sheetObj, row, col, value){
	 var formObject = document.form;
	 var colName = sheetObj.ColSaveName(col);
	 var loop_val ="N";
	 var charval ="Y";
	 var inputStr = value;

	 switch(colName){
	 case 'vndr_seq':
		 var sheet0_vndr_seq=formObject.sheet0.CellValue(row, "vndr_seq");
		 var inputStr = sheet0_vndr_seq;

		 for (var i = 0; i < inputStr.length; i++)
		 {
			 var oneChar = inputStr.charAt(i)
			 if (oneChar != "")
			 {
				 if ( (oneChar >= "0" && oneChar <= "9" )){
				 }else {
					 charval ="N";
					 break;
				 }
			 }else{
				 charval ="N";
				 break;
			 }

		 }

		 var b_vndr_seq =   formObject.sheet0.CellValue(row, "vndr_seq");
		 if(charval !="N"){
			 if(sheet0_vndr_seq!=""){
				 formObject.f_cmd.value = SEARCH04;
				 var queryString = "vndr_cd="+value+"&"+TrsFrmQryString(formObject);
				 sheetObj.DoRowSearch("ESD_TRS_0075GS.do", queryString);
				 if(!check_sheet_vndr(formObject.sheet0.EtcData('CNT_CD'),row, col)){
					 formObject.sheet0.CellValue2(row, col)="";
					 formObject.sheet0.CellValue2(row, col+1)="";
					 formObject.sheet0.SelectCell(row, col);
					 return false;
				 }
			 }
		 }
		 break;
	 }
}
 
/**
  * VNDR check
  *
 */
function check_sheet_vndr(value, row, col)
{
	 var formObject = document.form;
	 if( value == 0)
	 {
		 ComShowCodeMessage('COM12114', 'VNDR');
		 return false;
	 }else{
		 formObject.sheet0.CellValue2(row, col+1) = value;

		 var xxx = formObject.sheet0.ColValueDup("vndr_seq");
		 if(xxx>0){
			 ComShowCodeMessage('TRS90033');
			 formObject.sheet0.CellValue2(row, col)="";
			 formObject.sheet0.CellValue2(row, col+1)="";
			 formObject.sheet0.CellEditable(xxx,'vndr_seq') = true;
			 formObject.sheet0.SelectCell(xxx, 'vndr_seq');
		 }
		 return true;
	 }
}
 
/**
  * Agreement Header 필수값 체크
*/
function valcheck(){
	var formObj = document.form;
    var prmry_seq = formObj.fm_vndr_prmry_seq.value;
    var ref_no    = formObj.fm_agmt_ref_no.value;
    var ofc_cd    = formObj.fm_ctrt_ofc_cd.value;
    
	// 권한체크 추가 2014.07.04
	if(!checkAuth()) {
		ComShowCodeMessage('TRS90537');
		return false;
	}
    
    if(prmry_seq == "" || ref_no == "" || ofc_cd == "" ) {
    	ComShowCodeMessage('TRS90075');
    	return false;
    }
    return true;
}
 
/**
  * Agreement Header정보를 IbSheet에 셋팅
*/
function setAgreementInfo(){
	var formObj = document.form;
	sheetObjects[1].DataInsert();
	sheetObjects[1].CellValue(1, "vndr_prmry_seq") = formObj.fm_vndr_prmry_seq.value;
	sheetObjects[1].CellValue(1, "vndr_prmry_nm")  = formObj.fm_vndr_prmry_nm.value;
	sheetObjects[1].CellValue(1, "agmt_ref_no")    = formObj.fm_agmt_ref_no.value;
	sheetObjects[1].CellValue(1, "ctrt_ofc_cd")    = formObj.fm_ctrt_ofc_cd.value;
	sheetObjects[1].CellValue(1, "inter_rmk")      = formObj.fm_inter_rmk.value;
	sheetObjects[1].CellValue(1, "trsp_agmt_ofc_cty_cd") = (formObj.fm_ctrt_ofc_cd.value).substring(0,3);
	sheetObjects[1].CellValue(1, "cre_ofc_cd") = formObj.fm_ctrt_ofc_cd.value;
	sheetObjects[1].CellValue(1, "cre_usr_id") = formObj.fm_account_usr_id.value;
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
    formObj.sheet1.RemoveEtcData();
	formObj.f_cmd.value = SEARCH07;
	sheetObjects[1].DoRowSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
	x1 = formObj.sheet1.EtcData('VNDR_NM');
	if(x1 !="" && x1 != undefined){ //
		formObj.fm_vndr_prmry_nm.value = x1;
	}else{
		formObj.fm_vndr_prmry_nm.value = "";
	}
}

 /**
  * Office Code의 존재여부를 조회
  */
 function  office_blur(){
	 var formObj = document.form;
	 setgetUpper(formObj.fm_ctrt_ofc_cd);
	 var error_val = "";
	 var lvobj = formObj.fm_ctrt_ofc_cd.value;
	 if(lvobj !=""){
		 for (var i = 0; i < lvobj.length; i++)
		 {
			 var oneChar = lvobj.charAt(i)
			 if (oneChar != "")
			 {
				 if (  (oneChar >= "0" && oneChar <= "9" )  ){
					 error_val ="Y";
					 break;
				 }
			 }
		 }
	 }
	 if(error_val =="Y" ){
		 return;
	 }

	 formObj.sheet1.RemoveEtcData();
	 formObj.f_cmd.value = SEARCH06;
	 sheetObjects[1].DoRowSearch("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
	 x1 = formObj.sheet1.EtcData('CTRT_OFC_CD');

	 if(x1 !="" && x1 != undefined){ //
		 formObj.fm_ctrt_ofc_cd.value = x1;
	 }else{
		 formObj.fm_ctrt_ofc_cd.value = "";
	 }
 }

/**
  * rep_commodity팝업호출
  */
function rep_OnPopupClick()
 {
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
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for(var i=0; i<rowArray.length; i++) 
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];
		formObj.fm_vndr_prmry_seq.value = colArray2;
		formObj.fm_vndr_prmry_nm.value  = colArray4;
	}
}

/**
 * sheet0 OnPopupClick event
 */
function sheet0_OnPopupClick(sheetObj, row, col)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   
		var rep_cmdt_cd_val =""; 
		var cmdt_desc_val =""; 
		var classId ="getCOM_ENS_0C1";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		formObject.hid_row.value=row;   //row 
		formObject.hid_col.value=col;   //col
	if ( sheetObj.ColSaveName(col) == "vndr_nm" )
	{
		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1,1,1,1,1');
	}else{
	}
}

/**
 * 
 */
function getCOM_ENS_0C1(rowArray) {

	var formObject = document.form;

	for(var i=0; i<rowArray.length; i++)
	{
		//if(i ==rowArray.length-1) gubun ='';
		var colArray = rowArray[0];
		var row_val = formObject.hid_row.value;   //row hidden
		var col_val = formObject.hid_col.value;   //col hidden
		var in_val_1 = colArray[2];
		var in_val_2 = colArray[4];

		formObject.sheet0.CellValue2(row_val, col_val-1) = in_val_1;
		formObject.sheet0.CellValue2(row_val, col_val) = in_val_2;
	}
	val_pop_check();
}

function val_pop_check(){
	var formObject = document.form;
	var xxx = formObject.sheet0.ColValueDup("vndr_seq");
	if(xxx>0){
		ComShowCodeMessage('TRS90033');
		formObject.sheet0.CellValue2(xxx, 'vndr_seq')="";
		formObject.sheet0.CellValue2(xxx, 'vndr_nm')="";
		formObject.sheet0.CellEditable(xxx,'vndr_seq') = true;
		formObject.sheet0.SelectCell(xxx, 'vndr_seq');
	}

}

/**
 * 로그인 오피스로 해당 오피스의 상위/하위 오피스 리스트를 조회하여 화면에서 넘겨 받은 Contract Office 코드와 일치하는 오피스가 있을 경우에만 등록/수정가 가능하도록 체크
 */
function checkAuth() {
	var formObj = document.form;
	var sheetObject = sheetObjects[0];
	var ctrt_ofc_cd = formObj.fm_ctrt_ofc_cd.value;
	var auth_chk = false;
	
	formObj.f_cmd.value = SEARCH08;
	var sXml = sheetObject.GetSearchXml("ESD_TRS_0221GS.do", FormQueryString(formObj));
	var arrXml = sXml.split("|$$|");
	
	if( ComGetTotalRows(sXml) > 0 ) {
		var list = TrsXmlToListMap(arrXml);
		for(var i=0; i<list.length; i++) {
			if(ctrt_ofc_cd == list[i]['ofc_cd'])
				auth_chk = true;
		}
	}
	
	return auth_chk;
}
