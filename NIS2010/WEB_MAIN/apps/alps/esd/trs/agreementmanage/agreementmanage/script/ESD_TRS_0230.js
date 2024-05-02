/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0230.js
*@FileTitle : Agreement Surcharge Rate History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2010-03-18 cjh
* 1.0 최초 생성
* HISTORY
* 
* 2011.05.11 민정호   1.1 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
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
  case 1: //sheet0 init
  with (sheetObj) {
	  	  
//	  style.height    = 325; // 높이 설정(버튼이 없을 경우)
	  style.height    = 305; // 높이 설정(버튼이 있을 경우)		  
	  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
	  Editable = true; //전체Edit 허용 여부 [선택, Default false]
	  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitColumnInfo(29, 7, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, true, true, false,false)
	  var HeadTitle1 = "Seq|Equipment|Weight\nTier|UOM|Surcharge|Delete Y/N|Rank\n(ASC)|Effective Date|Effective Date|Currency|Rate|Rate|Route|Route|Route|Route|Route|Fixed or Per\nDistance|To Distance|To Distance|Update\nDate|Update\nUser||" ;
	  var HeadTitle2 = "Seq|Equipment|Weight\nTier|UOM|Surcharge|Delete Y/N|Rank\n(ASC)|From|To|Currency|One Way|Round Trip|From|Via|Door|To|Route All|Fixed or Per\nDistance|Distance|Unit|Update\nDate|Update\nUser||" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);
	  InitHeadRow(1, HeadTitle2, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtSeq,        30,  daCenter,  true,"seq_no",  				false,    "",  dfNone,     0,      false,   false,    2,   false,   true);	  
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,"trsp_agmt_eq_tp_sz_cd",  	false,    "",  dfNone,     0,      false,   false,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,           "to_wgt", 	false,    "",  	dfNone,     0,      false,   false,    9,   false,   true,     "The final value of weight tier should be 'Max'",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      50,  daCenter,  true,   "wgt_meas_ut_cd",	false,    "",  	dfNone,     0,      false,   false,    3,   false,   true,     "Unit of measure for weight",    false);
      InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,      "trsp_scg_cd",  	false,    "",  	dfNone,     0,      false,   false,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,       80,  daCenter, true,        "delt_flg",  	false,    "",  	dfNone,     0,     	true,  	true,  10,   false,   true,  "", false);      
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,              "rk",  	false,    "",  	dfNone,     0,      false,   false,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,       "eff_fm_dt",  	false,    "",	dfDateYmd,    0,      false,   false,    8,   false,   true,     "Effective period of this rate",   false);
      InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,       "eff_to_dt",  	false,    "",	dfDateYmd,    0,      false,   false,    8,   false,   true,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,         "curr_cd",  	false,    "",  	dfNone,     0,      false,   false,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,  "trsp_one_wy_rt",  	false,    "",  	dfNullFloat,3,      false,   false,   18,   false,   true,     "Applied rate. The currency is same as currency informarion of header information",    false);
      InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,     "trsp_rnd_rt",  	false,    "",  	dfNullFloat,3,      false,   false,   18,   false,   true,     "Applied rate. The currency is same as currency informarion of header information",    false);
      InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,       "fm_nod_cd",  	false,    "",  	dfEngUpKey, 0,      false,   false,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,      "via_nod_cd",  	false,    "",  	dfEngUpKey, 0,      false,   false,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,      "dor_nod_cd",  	false,    "",  	dfEngUpKey, 0,      false,   false,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,       "to_nod_cd",  	false,    "",  	dfEngUpKey, 0,      false,   false,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,"agmt_rout_all_flg",  	false,    "",  	dfNone,     0,      false,   false,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true, "trsp_dist_tp_cd",  	false,    "",  	dfNone,     0,      false,   false,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       60,   daRight,  true,  "trsp_agmt_dist",  	false,    "",  	dfNone,     0,      false,   false,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true, "dist_meas_ut_cd",  	false,    "",  	dfNone,     0,      false,   false,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,      110,  daCenter, true,            "upd_dt",  	false,    "",  	dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,        "upd_usr_id",  	false,    "",  	dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++,  dtStatus,	    40,	 daCenter, true,	  "ibflag");
	  
	  InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter, true,   "trsp_agmt_ofc_cty_cd",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter, true,   "trsp_agmt_seq",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter, true,   "trsp_agmt_rt_tp_ser_no",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter, true,   "trsp_agmt_scg_nod_seq",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter, true,   "trsp_agmt_scg_rt_seq",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);
	  InitDataProperty(0, cnt++ , dtHidden,       80,  daCenter, true,   "trsp_agmt_rt_his_seq",  false,    "",  dfNone,     0,     false,  false,  10,   false,   true,  "", false);	  
	  
	  ColHidden('ibflag')				= true;
	  InitDataCombo(0, 'delt_flg', "Y|N",  "Y|N");
	  	  
  }
  break;
	case 2 :		//민정호-추가
	with (sheetObj) {
		style.height = 0; // 높이 설정
		SheetWidth = 0; //전체 너비 설정
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
		MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
		Editable = false; //전체Edit 허용 여부 [선택, Default false]
		InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitColumnInfo(1, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false)

		var HeadTitle0 = "tpsz";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle0, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "tpsz", false, "", dfNone, 0, false, false);						
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
	
    /* IBMultiCombo 초기화 */
 	for ( var k = 0 ; k < comboObjects.length ; k++ ) {		// 민정호-추가 
 		initCombo(comboObjects[k], k+1);
 	}	 	 	 	
}

/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
/* 공통전역변수 */
var openWindownm     = 'AGMT';
var sheetObjects     = new Array();
var comboObjects 	 = new Array();		// 민정호-추가
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
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;

			/* [1.2.minimize버튼-화면최소화] */
			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;
			
			/* [1.3.상단의 create버튼] */
//			case "btn_creation":
//				openAgmtHdrPopup();
//			break;

			/* [1.4.상단 로우추가버튼] */
//			case "btn_rowadd":
//				doActionIBSheet(sheetObject,formObject,IBINSERT);
//			break;
			
			/* [1.5.상단 로우삭제버튼] */
//			case "btn_delete":
//
//			break;
			
			/* [1.6.상단의 저장버튼] */
//			case "btn_save":
//			
//			break;
			
			/* [2.1.하단 로우추가버튼] */
//			case "btn_rowadd":
//
//			break;

			/* [2.2.하단 sheet1의 엑셀파일추가] */
//			case "btng_fileselect":
//				document.all.btng_verify2.disabled = true;
//				doActionIBSheet(sheetObjects[1],formObject,IBLOADEXCEL);
//			break;
			
			/* [2.3.하단 로우삭제버튼] */
//			case "btng_delete":
//
//			break;
			
			/* [2.4.모든정보의 초기화버튼] */
//			case "btng_reset":
//			  reset_all();
//			break;

			/* [2.5.하단의 verify두번째 단계버튼] */
//			case "btng_verify":
//
//			break;

			/* [2.6.최종저장버튼 -하단의 모든정보를 저장하는 버튼] */
//			case "btng_update":
//			    update(formObject);
//			break;

			/* [2.7.엑셀다운로드 버튼] */
//			case "btng_downexcel":
//			  var sheet2_count =sheetObjects[1].RowCount;
//			  //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
//			  if(sheet2_count > 0){
//			    doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
//			  }
//			break;

			/* [2.service provider의 팝업버튼] */
//			case "btng_provider":
//			rep_OnPopupClick();
//			break;

  			
		
		case "btng_save":		// 추가-민정호
			doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;			
			
		case "btn_close":
		 	window.close();
			break;
			
		case "btng_download":
			if(sheetObject.RowCount > 0){
				sheetObject.Down2Excel(-1, false, false, true);
			}
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

	if(formObject.fm_agmt_route_all_flg.checked){			// 추가-민정호
		formObject.fm_agmt_route_all_flg.value = 'Y';
	}else{
		formObject.fm_agmt_route_all_flg.value = '';			
	}
				
	if(formObject.fm_eqtpsz.value == 'ALL'){			// 추가-민정호	
		formObject.fm_eqtpsz.value = '';
	}
	
	switch(sAction) {
	case IBSEARCH:				
		formObj.f_cmd.value = SEARCH01;
		sheetObj.DoSearch4Post("ESD_TRS_0230GS.do", TrsFrmQryString(formObj));
		break;
		
	case IBSAVE:        //저장
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("ESD_TRS_0230GS.do", TrsFrmQryString(formObj), 'ibflag', false);
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

function openAgmtHdrPopup() {
	var formObject = document.form;
	var Option = "width=724,height=290,menubar=0,status=0,scrollbars=0,resizable=0";
	var agmt_no = formObject.fm_agmtno.value;  
	var agmt_no ="";
	var param ="?agmt_no="+agmt_no;
	window.open('/hanjin/ESD_TRS_0220.do' + param, "popup", Option);
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
 	} else if( lvobj.length != 5 ) {
 		errMsg = ComGetMsg("TRS90074");
 		ComShowMessage(errMsg);
 		obj.focus();
 		return false;
 	}
 	if( !doengnumcheck(lvobj) ) {
 		obj.value = "";
 		comObj.RemoveAll();
 		obj.focus();
 		return false;
 	}
 	if( sep == 'F' ) {
 		formObj.TRSP_SO_EQ_KIND.value = "";
 		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 		formObj.fm_fm_nod_yd.value = fm_nod_yd;
 	} else if( sep == 'V' ) {
 		formObj.TRSP_SO_EQ_KIND.value = "";
 		lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 	} else if( sep == 'T' ) {
 		formObj.TRSP_SO_EQ_KIND.value = "A";
 		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
 	} else if( sep == 'D' ) {
 		formObj.TRSP_SO_EQ_KIND.value = "";
 		lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
 	}
 	comObj.focus();
 }
 
 /**
 * Sheet 확대/축소
 */
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(19);
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(13);
	}
}
 
//###################################################################################
 
/**
 * EQ 조회
 **/
 function getTypeSizeList(sheetObj, formObject)
 {
 	 sheetObj.WaitImageVisible  = false;
 	 formObject.f_cmd.value = SEARCH03;
 	 var queryString = TrsFrmQryString(formObject);
 	 sheetObj.DoRowSearch("ESD_TRS_0231GS.do", queryString);
 	 sheetObj.WaitImageVisible  = true;
 	 return sheetObj.EtcData('TPSZ');
 }   
 
/**
 * EQ 조회
 **/  
function getTypeSizeCombo(comboObj)
{
	  var formObj = document.form;
	  var TySzList = getTypeSizeList(sheetObjects[1], formObj);	  
	  var TySzArray = new Array();	  	 
	  TySzArray = TySzList.split("|");
	  comboObj.RemoveAll();
	  comboObj.InsertItem(0, "ALL", "ALL");
	  for(var i=1; i<TySzArray.length+1; i++)
	  {
		  comboObj.InsertItem(i, TySzArray[i-1], TySzArray[i-1]);
	  }	  
//	  comboObj.Index=0;  
	  
	comboObjects[4].UseCode = false;	 	
					
    // 추가-민정호
    // Eq Type 세팅
	var sw = 0;
	comboObjects[4].UseCode = false;	
	var eqtpsz = formObj.fm_eqtpsz.value;
	for(var j = 1; j < comboObjects[4].GetCount(); j++) {
		if(eqtpsz == comboObjects[4].GetText (j, 0)){		
			comboObjects[4].CheckIndex(j) = true;
			sw = 1;
		}
	} 	 
	if(sw == 0) comboObjects[4].CheckIndex(0) = true;
		
	
	if(formObj.gubun2.value == '0231' || formObj.gubun2.value == '0236'){
		comboObjects[4].CheckIndex(0) = true;
		formObj.fm_agmt_route_all_flg.checked = true;
	}		
	comboObjects[4].UseCode = true;	  	  
} 
 
 /**
  * MultiCombo object initial property //LHS
  * @param comboObj
  * @param comboNo
  * @return
  */
 function initCombo (comboObj, comboNo) {
 	 switch(comboObj.id) {
    	 case "combo1":
 		with(comboObj) {
 			//BackColor = "cyan";
 			DropHeight = 150;
 			MultiSelect = true;
 			UseAutoComplete = true;
 			MultiSeparator = ",";
 			Style = 0;
 			ValidChar(2,3);
// 			UseCode = false;				// 민정호-추가
 		}
 	break;
 	 }      	
 } 
 
 /**
  * IBCombo Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
 */
 function setComboObject(combo_obj){
     comboObjects[comboCnt++] = combo_obj;
 }
  
function sheet_tpsz_OnLoadFinish(sheetObj) {
	getTypeSizeCombo(document.combo1);		// 민정호-추가		
//	comboObjects[4].CheckIndex(0) = true;
}  
  
  
 /**
  * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
  * @return
  */
 function combo1_OnCheckClick(comboObj, index, code) { 	
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	} 	
 }


 /**
  * combo1_OnBlur
  */
 function combo1_OnBlur(comboObj, Index_Code, Text) {
 	var formObj = document.form;
 	if( comboObj.CheckIndex(0)){
 		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
 			comboObj.CheckIndex(i) = false;
 		}
 		formObj.fm_eqtpsz.value = "";
 	}else if(comboObj.Text == ""){
 		comboObj.CheckIndex(0) = true;
 		formObj.fm_eqtpsz.value = "";
 	}else{
 	    formObj.fm_eqtpsz.value = ComGetObjValue(comboObj);
 	}
 }
  
 /**
  * combo1_OnKeyDown
  */
 function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
 	with(comboObj) {
 		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
 			comboObj.Text = "";
 		}
 	}
 }

  
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
//		sheetObj.style.height    = 305; // 높이 설정(버튼이 있을 경우)
		sheetObj.Editable = true;		
	}else{
		sheetObj.Editable = false;
//		sheetObj.style.height    = 325; // 높이 설정(버튼이 없을 경우)		
	}			  
}     