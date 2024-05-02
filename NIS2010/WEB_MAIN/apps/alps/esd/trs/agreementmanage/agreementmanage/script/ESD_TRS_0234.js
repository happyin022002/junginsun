/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0234.js
*@FileTitle : Agreement Rail Surcharge History
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2010-05-25 pjy
* 1.0 최초 생성
* 
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
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
		  InitRowInfo( 2, 1, 9, 100);
	
		  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		  InitColumnInfo(24, 0, 0, true);
	
		  // 해더에서 처리할 수 있는 각종 기능을 설정한다
		  InitHeadMode(true, true, false, true, false,false)
	
		  var HeadTitle1 = "Seq|Agreement\nNo|Rail Company|Rail Company|Delete|Surcharge\nKind|Route|Route|Route|Cargo\Type|Ratio(%)|Effective Date|Effective Date|Decimal|Over Weight\n(LBS)|Amount|Amount|Amount|Amount|Amount|FSC\nApply|||" ;
		  var HeadTitle2 = "Seq|Agreement\nNo|Code|Name|Delete|Surcharge\nKind|All|ORG|DEST|Cargo\Type|Ratio(%)|From|To|Decimal|Over Weight\n(LBS)|Cur|All|20'|40'|45'|FSC\nApply|||" ;
	
		  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		  InitHeadRow(0, HeadTitle1, true);
		  InitHeadRow(1, HeadTitle2, true);
	
		  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		  InitDataProperty(0, cnt++ , dtData,      30,  daCenter, true,     "seq",  false,    "",  dfNone,     0,     false,  false,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      70,  daCenter, true,     "agmt_no",  false,    "",  dfNone,     0,     false,  false,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      60,  daCenter, true,    "vndr_seq",  false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     140,  daLeft,   true,     "vndr_nm",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtCombo,      50,  daCenter, true,"delt_flg", 		 false,   "",  dfNone,     0,      true,   true,    1,   false,   true,     "",    false);		  
		  InitDataProperty(0, cnt++ , dtData,      80,  daCenter, true, "trsp_rail_scg_cd",  false,    "",  dfNone,     0,     false,   false,    3,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtCheckBox,  50,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,     false,   false );
		  InitDataProperty(0, cnt++ , dtData,      65,  daCenter, true,   "fm_nod_cd",  false,    "",  dfNone,     0,     false,   false,    7,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      65,  daCenter, true,   "to_nod_cd",  false,    "",  dfNone,     0,     false,   false,    7,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      80,  daCenter, true,   "cgo_tp_cd",  false,    "",  dfNone,     0,     false,   false,    1,   false,   true,     "",    false);		
		  InitDataProperty(0, cnt++ , dtData,      80,   daRight, true,"trsp_rail_rto",  false,   "",dfNullFloat,  2,      false,   false,    5,   false,   true,     "",    false);
	      InitDataProperty(0, cnt++ , dtData,      75,  daCenter, true,   "eff_fm_dt",  false,    "",dfDateYmd,    0,      false,   false,    8,   false,   true,     "Effective period of this rate",   false);
	      InitDataProperty(0, cnt++ , dtData,      75,  daCenter, true,   "eff_to_dt",  false,    "",dfDateYmd,    0,      false,   false,    8,   false,   true,     "Effective period of this rate",   false);
	      InitDataProperty(0, cnt++ , dtData,      80,   daRight, true, "rail_rto_no",  false,    "",  dfNone,     0,      false,   false,    4,   false,   true,     "",    false);
	      InitDataProperty(0, cnt++ , dtData,      80,  daCenter, true, "lbs_ovr_wgt",  false,    "",dfNullFloat,  3,      false,   false,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      50,  daCenter, true,     "curr_cd",  false,    "",  dfNone,     0,      false,   false,    3,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      60,  daCenter, true,"fx_scg_all_rt",  false,   "",dfNullFloat,  3,      false,   false,   15,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      60,  daCenter, true,"fx_scg_20ft_rt", false,   "",dfNullFloat,  3,      false,   true,   15,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      60,  daCenter, true,"fx_scg_40ft_rt", false,   "",dfNullFloat,  3,      false,   false,   15,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      60,  daCenter, true,"fx_scg_45ft_rt", false,   "",dfNullFloat,  3,      false,   false,   15,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      50,  daCenter, true,"fuel_scg_aply_flg", false,"",  dfNone,     0,      false,   false,    1,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++,  dtStatus,	    40,	 daCenter, true,	  "ibflag");
		  InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter, true,   "trsp_agmt_scg_seq",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
		  InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter, true,   "trsp_agmt_rt_his_seq",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  
		  
		  ColHidden('ibflag')				= true;
		  InitDataCombo(0, 'delt_flg', "Y|N",  "Y|N");		  
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
	
//	var sheetObject = sheetObjects[0];
//	var formObject = document.form;
	
//	doActionIBSheet(sheetObject,formObject,IBSEARCH, "Popup");	
}

function loadPage2(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	
	if(!(formObject.gubun.value == '0231' || formObject.gubun.value == '0236')){ 
		doActionIBSheet(sheetObject,formObject,IBSEARCH, "Popup");	
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
				if( validateFormSearch(formObject) ) {
					if(formObject.gubun.value == '0231' || formObject.gubun.value == '0236'){
						doActionIBSheet(sheetObject,formObject,IBSEARCH, "Retrieve");
					}else{
						doActionIBSheet(sheetObject,formObject,IBSEARCH, "Popup");						
					}										
				}									
			break;
			
			/* [2.2.하단  Close버튼] */
			case "btng_close":
    	        window.close();
    	        break;
			break;
			
			case "btn_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;
			
			case "btn_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;
			
			case "btng_calendar":
				getCalendar();
			break;
			
			case "btng_save":		// 추가-민정호
				doActionIBSheet(sheetObject,formObject,IBSAVE);
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

function doActionIBSheet(sheetObj,formObj,sAction,srcName) {
    sheetObj.ShowDebugMsg = false;
	var formObject = document.form;

    switch(sAction) {       
       case IBSEARCH:    	   
    	   switch(srcName) {
    	   		case "Retrieve":
    	   			formObj.f_cmd.value = SEARCH01;
    		   	    sheetObj.DoSearch4Post("ESD_TRS_0234GS.do", TrsFrmQryString(formObj));
    		    break;
    		    
    	   		case "Popup":
    	   			formObj.f_cmd.value = SEARCH02;
    		   	    sheetObj.DoSearch4Post("ESD_TRS_0234GS.do", TrsFrmQryString(formObj));
    		    break;
    	   }
    	   break;

   	case IBSAVE:        //저장
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("ESD_TRS_0234GS.do", TrsFrmQryString(formObj), 'ibflag', false);
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

/**
 * 외부 콤보박스의 리스트 가져오기
 */
 function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
 	var formObj = document.form;
 	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
 	obj.value = lvobj;
 	if( lvobj == "" ) {
 		obj.value = "";
 		comObj.RemoveAll();
 		return false;
 	}
 	
 	if( sep == 'F' ) {
 		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 	} else if( sep == 'T' ) {
 		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 	}
 	comObj.focus();
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
 	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
 	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
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
  	formObject.fm_fm_nod_cd.value = lvLoc;
  	getYardCombo(document.fm_fm_nod_yd, sheetObjects[0], formObject, lvLoc);
  	document.fm_fm_nod_yd.CODE = lvYard;
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
  	formObject.fm_to_nod_cd.value = lvLoc;
  	getYardCombo(document.fm_to_nod_yd, sheetObjects[0], formObject, lvLoc);
  	document.fm_to_nod_yd.CODE = lvYard;
  }
  
  /*
   * 멀티 달력 입력 Pop-Up
   */
  function getCalendar() {
		var cal = new ComCalendar();
		cal.select(document.form.effective_date, 'yyyy-MM-dd');	   
  }
  
  /**
   * 조회시 필수 항목과 날짜 형식 유효성검증 프로세스 처리
   */
  function validateFormSearch(formObj){
		var effective_date = ComTrimAll(ComTrimAll(formObj.effective_date.value, " "), "-");
		
		var lvFmNode = ComTrimAll(formObj.fm_fm_nod_cd.value, " ");
		var lvToNode = ComTrimAll(formObj.fm_to_nod_cd.value, " ");
		
		if( effective_date != "" ) { //날짜 체크하는 부분
			if( !ComIsDate(effective_date) ) {
				errMsg = ComGetMsg("TRS90070");
				ComShowMessage(errMsg);
				formObj.eff_dt.focus();
				return false;
			}
		}
				
		if( lvFmNode == "" && lvToNode == "" && !formObj.routeAll.checked ) {	// 필수값 Check 부분
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
		
		if( lvFmNode == "" ) { //From Node
			formObj.fm_fm_nod_cd.value = "";
			formObj.fm_fm_nod_yd.RemoveAll(); // combo 데이터삭제
		}
		
//		formObj.hid_fm_eff_fm_dt1.value = effective_date; //from Effective Date
		formObj.fm_fm_nod_cd.value = lvFmNode.toUpperCase();
		formObj.fm_fm_nod_yd.value = lvToNode.toUpperCase();
		
		return true;
  }
  
  function fun_allRoute(){
		if(document.form.routeAll.checked == true){
			document.form.routeAll.value = "Y";
		}		
	} 
  
//#######################################################################
  
  
   /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
function validateForm(sheetObj,formObj,sAction){
	var cnt = 0;
	switch(sAction){
		case IBSAVE:
			for(var k=2; k<sheetObj.RowCount+2; k++)
			{
				if(sheetObj.RowStatus(k)=='U'){
					cnt++;
				}
			}			
			
			if(cnt > 0){
				return true;
			}else{
				return false;
			}
	}
} 

/**
 * 버튼 유무에 따른 Sheet 높이 조절
 */   
function sheet0_OnLoadFinish(sheetObj) {
	var formObj = document.form;
	if(formObj.gubun.value == 'save'){
		sheetObj.Editable = true;		
	}else{
		sheetObj.Editable = false;
	}			  
}  