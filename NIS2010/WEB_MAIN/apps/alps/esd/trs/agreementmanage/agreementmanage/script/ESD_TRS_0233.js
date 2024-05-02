/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0233.js
*@FileTitle : Agreement Header Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-17
*@LastModifier : pjy
*@LastVersion : 1.0
* 2010-05-17 pjy
* 1.0 최초 생성
=========================================================*/

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * 구주 S/O
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject   = sheetObjects[0]; 
  var cnt = 0;
  
  switch(sheetNo) {
  	case 1: //sheet0 init ( Child S/P )
	  with (sheetObj) {
		  // 높이 설정
		  style.height = GetSheetHeight(10);
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
	
		  var HeadTitle1 = "Chk.|AGMT NO|S/P SEQ|S/P NAME|Rererence No|Contract Office|Remark" ;
	
		  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		  InitHeadRow(0, HeadTitle1, true);
	
		  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		  InitDataProperty(0, cnt++ , dtCheckBox,  30,  daCenter, true,       "check",   false,    "",  dfNone,     0,     true,   true );
		  InitDataProperty(0, cnt++ , dtData,      60,  daCenter, true,     "agmt_no",  false,    "",  dfNone,     0,     false,  false,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      60,  daCenter, true,    "vndr_seq",  false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     140,  daLeft,   true,     "vndr_nm",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     100,  daLeft,   true, "agmt_ref_no",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     100,  daCenter, true, "ctrt_ofc_cd",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     140,  daLeft,   true,   "inter_rmk",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);		  
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
var sheetObjects     = new Array();
var sheetCnt         = 0;

document.onclick = processButtonClick;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObject = sheetObjects[0];

    /*******************************************************/
    var formObject = document.form;

   try {
       var srcName = window.event.srcElement.getAttribute("name");
       switch(srcName) {
			/* [2.1.하단 조회로직] */
			case "btng_retrieve":				
					doActionIBSheet(sheetObject,formObject,IBSEARCH);				
			break;
			
			/* [2.2.하단  Ok버튼] */
			case "btng_ok":				
				if( validateForm(sheetObject, formObject) ) {
					var checkList = sheetObject.FindCheckedRow('check');
					var checkArray = checkList.split('|');
					
					opener.getAgmtNo( sheetObject.CellValue(checkArray[0], 'agmt_no')
									, sheetObject.CellValue(checkArray[0], 'agmt_ref_no')
									, sheetObject.CellValue(checkArray[0], 'vndr_seq')
									, sheetObject.CellValue(checkArray[0], 'vndr_nm')
									, formObject.mainRow.value );
					window.close();
				}
			break;
			
			/* [2.3.하단  Close버튼] */
			case "btng_close":
    	        window.close();
    	        break;
			break;
			
			/* [2.4.service provider의 팝업버튼] */
			case "btn_provider":
			    rep_OnPopupClick();
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

    switch(sAction) {       
       case IBSEARCH:
    	    var agmt_no = formObj.agmt_no.value;
    	    if(agmt_no != '') {
    	    	if(agmt_no.length < 4) {
    	    		ComShowCodeMessage('TRS90066');
    	    		return;
    	    	} else if(!ComIsNumber( agmt_no.substr(3) )){
    	    		ComShowCodeMessage('TRS90066');
    	    		return;
    	    	}
    	    }
    	    
	   	    formObj.f_cmd.value = SEARCH01;
	   	    sheetObj.DoSearch4Post("ESD_TRS_0233GS.do", TrsFrmQryString(formObj));
			break;
    }
}

function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
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

/**
 * S/P 정보를 조회
 */
function getVendorSeq(sheetObj, formObj, vndr_seq){

	formObj.f_cmd.value = SEARCH11;
	//Vendor Code Validation 추가 2013.11.13 조인영
	if(!ComIsNumber(vndr_seq)) {
		ComShowCodeMessage('COM12122', 'S/P Code');
		formObj.combo_svc_provider.focus();
		return false;
		}
	formObj.combo_svc_provider.value = get_only_num(vndr_seq);

	sheetObj.RemoveEtcData();
	sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));
    
	var vendorNoList = sheetObj.EtcData('vndr_no');
	var vendorNmList = sheetObj.EtcData('vndr_nm_eng');

	if (vendorNoList == undefined || vendorNoList == ''){
		formObj.combo_svc_provider.value = '';
		formObj.svc_provider.value = '';
		
		return false;
	}

	formObj.combo_svc_provider.value = lpad(vendorNoList, 6, '0') ;
	formObj.svc_provider.value = vendorNmList;
	return true;
}

/**
 * 저장시 CHECK가 되어있는지, 하나만 CHECK가 되었는지 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj){
	if( sheetObj.CheckedRows("check") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	
	if( sheetObj.CheckedRows("check") > 1 ) {
		errMsg = ComGetMsg("COM12177" );
		ComShowMessage(errMsg);
		return false;
	}
	return true;
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
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value  = colArray4;
	}
}
