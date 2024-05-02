/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0106.js
*@FileTitle : > Estimated PFMC-PA > Allocate Network Cost > Allocation Results
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2006-11-28 Kim Jong Beom
* 2008.02.28 박칠서 N200801154875 주차와 월 조회 기준 분리
* 2008.06.16 박칠서 N200805276923 S.Cht Rev Missing시 팝업 알림
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => coaFormQueryString 변경
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2013.01.15 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2014.03.25 최성민 [CHM-201429403-01] [COA] Apply to P&L시 전 OP view에 대해서 장기주차 가능하도록 수정
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0106 : ESM_COA_0106 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0106() {
    this.processButtonClick = processButtonClick ; 
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.sheet1_OnSaveEnd   = sheet1_OnSaveEnd   ;
    this.sheet1_OnChange    = sheet1_OnChange    ;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateSheet      = validateSheet      ;
    this.validateCond       = validateCond       ;
    this.setPeriod          = setPeriod          ;
    this.chkValidSearch     = chkValidSearch     ;
    this.validateForm       = validateForm       ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(p_srcName) {
  var sheetObject = sheetObjects[0];
  var formObject = document.form;

  try {
      if(p_srcName == undefined) {
        srcName = window.event.srcElement.getAttribute("name");
      } else {
        srcName = p_srcName;
      }
    switch(srcName) {

      case "btn_Retrieve":
          doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;

      case "btn_Applytopl":
            // Missing 체크
            setSpcChtrRevMssCnt();
          break;

      case "btn_applytopl_step2":
          doActionIBSheet(sheetObject,formObject,IBCREATE);
          break;

      case "btn_Downexcel":
          doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
          break;

    } // end switch
  } catch(e) {
    if( e == "[object Error]") {
      ComShowMessage(OBJECT_ERROR);
    } else {
      ComShowMessage(e);
    }
  }
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
	loadingMode = true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode = false;
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	with (comboObj) {
		DropHeight = 300;
		Index = 0;
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

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
  switch(sheetNo) {
      case 1:      //sheet1 init
        var com_head1 = "YYYY-MM|Week|Trade|Lane|IOC|VVD|Trade Dir.|Charter-out\n(a)";
        var com_head2 = "|Total Network Cost\n(a+b)";
        var head1 = "|Cost allocation process for HJS Sales"
                  + "|Cost allocation process for HJS Sales"
                  + "|Cost allocation process for HJS Sales"
                  + "|Cost allocation process for HJS Sales"
                  + "|Cost allocation process for HJS Sales";
        var head2 = "|HJS Sales(Initial)|1st TS Alloc.|2nd TS Alloc.|Internal Pricing|HJS Sales final(b)";

        with (sheetObj) {
          style.height = GetSheetHeight(14) ;

          //전체 너비 설정
          SheetWidth = mainTable.clientWidth;

          //Host정보 설정[필수][HostIp, Port, PagePath]
          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

          //전체Merge 종류 [선택, Default msNone]
          MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
          Editable = false;

          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
          InitRowInfo(2, 1, 9, 100);

          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          InitColumnInfo(14, 2, 0, true);
          // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
          InitHeadMode(true, true, false, true, false, false);

          var HeadTitle0 = com_head1 + head1 + com_head2;
          var HeadTitle1 = com_head1 + head2 + com_head2;

          //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle0, true);
          InitHeadRow(1, HeadTitle1, false);

          //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
          //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
          //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
          //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
          var cnt = 0;
          InitDataProperty(0, cnt++, dtData,     60, daCenter, true, "cost_yrmon",         false, "", dfDateYm,  0, false, false);
          InitDataProperty(0, cnt++, dtData,     40, daCenter, true, "cost_wk",            false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,     50, daCenter, true, "trd_cd",             false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,     55, daCenter, true, "rlane_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,     45, daCenter, true, "ioc_cd",             false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,     90, daCenter, true, "vvd_cd",             false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,     75, daCenter, true, "hul_bnd_cd",             false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum,  80, daRight,  true, "co_amt",             false, "", dfFloatOrg, 0, false, false);

          InitDataProperty(0, cnt++, dtAutoSum, 105, daRight,  true, "hjs_sls_amt",        false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 105, daRight,  true, "n1st_asgn_amt",      false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtHidden,  105, daRight,  true, "n2st_asgn_amt",      false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 105, daRight,  true, "ipt_asgn_amt",       false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 105, daRight,  true, "hjs_sales_final",    false, "", dfFloatOrg, 0, false, false);

          InitDataProperty(0, cnt++, dtAutoSum, 115, daRight,  true, "total_network_cost", false, "", dfFloatOrg, 0, false, false);

          RangeBackColor(1, 7, 1, 11) = RgbColor(222, 251, 248);


          HeadRowHeight = 10;
          CountPosition  = 0 ;
        }
        break;

  }
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
 */
function f_seltrade_OnChange(obj,value,text) {
 	var formObj = document.form;
 	if ("All"!=value) {
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST01;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0106GS2.do", coaFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_selrlane, "code", "name");
		formObj.f_selrlane.Index = 0;
	} else {
		formObj.f_selrlane.RemoveAll();
		formObj.f_selrlane.InsertItem(0, "All", "All");
 		formObj.f_selrlane.Index = 0;
	}
}

/**
 * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
 */
function setPeriod(obj) {
	ComCoaSetPeriod(obj);
}

/**
 * 검색시 필수입력사항 체크
*/
function chkValidSearch(){
  var formObj = document.form;
  with(formObj){
      if (f_year.value == "") {
           // [COM12114] : Year 를(을) 확인하세요.
           ComShowMessage(ComGetMsg("COM12114", "Year"));
           f_year.focus();
           return false;
      }
      if (f_fm_mon.value != "" && f_to_mon.value == ""){
          // [COM12114] : Month 를(을) 확인하세요.
          ComShowMessage(ComGetMsg("COM12114", "Month"))
          f_to_mon.focus();
          return false;
     }
     if (f_fm_mon.value == "" && f_to_mon.value != "") {
          // [COM12114] : Month 를(을) 확인하세요.
          ComShowMessage(ComGetMsg("COM12114", "Month"));
          f_fm_mon.focus();
          return false;
     }
     if (f_fm_mon.value > f_to_mon.value) {
         // [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
         ComShowMessage(ComGetMsg("COA10011","Month","From","To"));
         f_to_mon.focus();
         return false;
     }
     if (f_fm_wk.value != "" && f_to_wk.value == ""){
         // [COM12114] : Week 를(을) 확인하세요.
         ComShowMessage(ComGetMsg("COM12114", "Week"));
         f_to_wk.focus();
         return false;
     }
     if (f_fm_wk.value == "" && f_to_wk.value != ""){
         // [COM12114] : Week 를(을) 확인하세요.
         ComShowMessage(ComGetMsg("COM12114", "Week"));
         f_fm_wk.focus();
         return false;
     }
     if (f_fm_wk.value > f_to_wk.value) {
         // [COA10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
         ComShowMessage(ComGetMsg("COA10011","Week","From","To"));
         f_to_wk.focus();
         return false;
     }
     if(f_fm_mon.value == "" && f_fm_wk.value == ""){
         // [COM12138] : Month 과 Week 중 하나는 입력하세요.
    	 // ComShowMessage(ComGetMsg("COM12138", "Month", "Week"));
         return false;
     }
     //if(!isValidYear(f_year,false,true)) return false;
     //if(!isValidMonth(f_fm_mon,false,true)) return false;
     //if(!isValidMonth(f_to_mon,false,true)) return false;
     //if(!isValidWeek(f_fm_wk,false,true)) return false;
     //if(!isValidWeek(f_to_wk,false,true)) return false;
     if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
     if(!ComChkObjValid(f_fm_mon, null, null, "ym")) return false;
     if(!ComChkObjValid(f_to_mon, null, null, "ym")) return false;
     if(!ComChkObjValid(f_fm_wk, null, null, "yw")) return false;
     if(!ComChkObjValid(f_to_wk, null, null, "yw")) return false;
   }
   return true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
  with(formObj){
      if (f_year.value == "") {
          // [COM12114] : Year 를(을) 확인하세요.
          ComShowMessage(ComGetMsg("COM12114", "Year"));
          f_year.focus();
          return false;
      }
      if((f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == "")
           && f_vsl_cd.value == "" && f_skd_voy_no.value == "" && f_dir_cd.value == ""){
          ComShowMessage(ComGetMsg("COM12138", "Month", "VVD"));
          return false;
      }
      if((f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == "")
           && f_vsl_cd.value == "" && f_skd_voy_no.value == "" && f_dir_cd.value == ""){
          ComShowMessage(ComGetMsg("COM12138", "Week", "VVD"));
          return false;
      }
      if(!isValidYear(f_year,false,true)) return false;
      if(!chkValidSearch()) return false;
      if(f_fm_mon.value == "" && f_fm_wk.value == ""){
        // [COM12138] : Month 과 Week 중 하나는 입력하세요.
        ComShowMessage(ComGetMsg("COM12138", "Month", "Week"));
        return false;
      }

      if(f_chkprd[0].checked){
           if(f_fm_wk.value == "") {
                  ComShowMessage(ComGetMsg("COM12114","From Week",""));
                  f_fm_wk.focus();
                  return false;
           }
           if(f_fm_wk.value.length != 2) {
                  ComShowMessage(ComGetMsg("COM12114","From Week",""));
                  f_fm_wk.focus();
                  return false;
           }
           if(f_to_wk.value == "") {
                  ComShowMessage(ComGetMsg("COM12114","To Week",""));
                  f_to_wk.focus();
                  return false;
           }
           if(f_to_wk.value.length != 2) {
                  ComShowMessage(ComGetMsg("COM12114","To Week",""));
                  f_to_wk.focus();
                  return false;
           }
     }else{
           if(f_fm_mon.value == "") {
                   ComShowMessage(ComGetMsg("COM12114","From Month",""));
                   f_fm_mon.focus();
                   return false;
           }
           if(f_fm_mon.value.length != 2) {
                   ComShowMessage(ComGetMsg("COM12114","From Month",""));
                   f_fm_mon.focus();
                   return false;
           }
           if(f_to_mon.value == "") {
                   ComShowMessage(ComGetMsg("COM12114","To Month",""));
                   f_to_mon.focus();
                   return false;
           }
           if(f_to_mon.value.length != 2) {
                   ComShowMessage(ComGetMsg("COM12114","To Month",""));
                   f_to_mon.focus();
                   return false;
           }
      }
    }
    return true;
}

/**
 * Space Charter Revenue Missing Row Count를 Main 화면에 셋팅한다.
 */
function setSpcChtrRevMssCnt() {
 	var formObj = document.form;
	var sheetObj = sheetObjects[0];
    formObj.f_cmd.value = SEARCHLIST;  //SEARCHLIST02;
    
    var sXml = sheetObj.GetSearchXml("ESM_COA_0154GS.do", coaFormQueryString(formObj));
    var arrXml = sXml.split("|$$|");
	if (0 < arrXml.length) {
		if (0 < Number(ComGetEtcData(arrXml[0],"rowCount"))) {
	    	var strUrl = "?f_chkprd="+(formObj.f_chkprd[0].checked ? "W":"M");
	        strUrl += "&f_year="  +ComGetObjValue(formObj.f_year  );
	        strUrl += "&f_fm_mon="+ComGetObjValue(formObj.f_fm_mon);
	        strUrl += "&f_to_mon="+ComGetObjValue(formObj.f_to_mon);
	        strUrl += "&f_fm_wk=" +ComGetObjValue(formObj.f_fm_wk );
	        strUrl += "&f_to_wk=" +ComGetObjValue(formObj.f_to_wk );
	        ComOpenWindow2("ESM_COA_0154.do" + strUrl,'', "width=800,height=300,menubar=0,status=0,scrollbars=0,resizable=1");
		} else {
	    	if (ComShowConfirm(ComGetMsg("COA10033"))) {
	    		processButtonClick("btn_applytopl_step2");
		    }
		}
    }
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg){
}

function sheet1_OnChange(sheetObj,Row,Col,Value) {
}

function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	if(document.form.f_op_view.selectedIndex == 1) {		
		//sheetObj.ColHidden("D_cml_bse_cost_amt") = true;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	case IBCLEAR:          //조회
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = INIT;
			
		var sXml = sheetObj.GetSearchXml("ESM_COA_0106GS2.do", coaFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		var prevWeek = "";
		if (0 < arrXml.length) {
			ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "name");
			prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
		}
		if (1 < arrXml.length)
			ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");
		if (2 < arrXml.length)
			ComXml2ComboItem(arrXml[2], formObj.f_selioc, "code", "name");
		if (3 < arrXml.length)
			ComXml2ComboItem(arrXml[3], formObj.f_selcost, "code", "name");

		formObj.f_year.focus();
		formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		formObj.f_fm_wk.value = formObj.f_to_wk.value = prevWeek;
		setPeriod(formObj.f_to_wk);

		ComOpenWait(false);
		break;	

  	case IBSEARCH:      //조회
          if(!validateForm(sheetObj,formObj,sAction)) return false;
          // 업무처리중 버튼사용 금지 처리
          sheetObj.WaitImageVisible = false;
          ComOpenWait(true);
          if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
          if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
          if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
          if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');
          formObj.f_cmd.value = SEARCHLIST;
          sheetObj.DoSearch4Post("ESM_COA_0106GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
          ComOpenWait(false);
          break;

//      case IBCREATE:      //Apply to P/L
//          if(!validateForm(sheetObj,formObj,sAction)) return false;
//          
//          // 업무처리중 버튼사용 금지 처리
//          sheetObj.WaitImageVisible = false;
//          ComOpenWait(true);
//          formObj.f_cmd.value = MULTI01;
//          sheetObj.DoSearch4Post("ESM_COA_0106GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
//          var err_cd = sheetObj.EtcData("err_cd");
//          var err_msg = sheetObj.EtcData("err_msg");
//
//          if (err_cd == "00000") {
//              ComShowMessage(ComGetMsg('COA10018','Apply to P/L Chart'));
//          }
//          ComOpenWait(false);
//           //}
//          break;
          
    case IBCREATE:      //Apply to P/L
        if(!validateForm(sheetObj,formObj,sAction)) return false;
        
        // 업무처리중 버튼사용 금지 처리
        sheetObj.WaitImageVisible = false;
        ComOpenWait(true);
        formObj.f_cmd.value = MULTI01;
        var sXml = sheetObj.GetSearchXml("ESM_COA_0106GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
		var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
		
		if (backendJobKey != null && backendJobKey.length > 0) {
			ComSetObjValue(formObj.backendjob_key, backendJobKey);
			sheetObj.RequestTimeOut = 7200; //초 - 2시간
			backEndJobTimer = setInterval(getBackEndJobStatus, 5000);	//밀리초  - 5초
		}
        break;          
        

      case IBDOWNEXCEL:   //엑셀 다운로드
          //sheetObj.Down2Excel(-1, false, false, true);
          var excelType = selectDownExcelMethod(sheetObj);
          switch (excelType) {
          case "AY":
              sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }
                break;

        }
    }

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateSheet(sheetObj) {
   with(sheetObj){
   }

   return true;
}

/**
 * 화면 조회값에 대한 유효성검증 프로세스 처리
*/
function validateCond(formObj) {
   with(formObj){
   // msg1 + '  를(을) 확인하세요.';
   if (ComTrim(f_year.value) == "") {
      ComShowMessage(ComGetMsg('COM12114','Year'));
      f_year.focus();
      return false;
   }
   // msg1 + '  과 ' + msg2 + '중 하나는 입력하세요.';
   if (ComTrim(txtSMonth.value) == "" && ComTrim(f_sweek.value) == "") {
      ComShowMessage(ComGetMsg('COM12138','Month','Week'));
      txtSMonth.focus();
      return false;
   }
   // msg1 + ' 의 ' + msg2 + ' 를(을) 입력하세요.';
   if (ComTrim(txtSMonth.value) != "" && ComTrim(txtEMonth.value) == "") {
      ComShowMessage(ComGetMsg('COM12130','Month','Second Element'));
      txtEMonth.focus();
      return false;
   }
   if (ComTrim(f_sweek.value) != "" && ComTrim(f_eweek.value) == "") {
      ComShowMessage(ComGetMsg('COM12130','Week','Second Element'));
      f_eweek.focus();
      return false;
   }
   // msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
   if (ComTrim(txtSMonth.value) != "" && ComTrim(txtEMonth.value) != "") {
      if(ComParseInt(txtSMonth.value) > ComParseInt(txtEMonth.value)){
         ComShowMessage(ComGetMsg('COA10011','Month','First Element','Second Element'));
         txtSMonth.focus();
         return false;
      }
   }
   if (ComTrim(f_sweek.value) != "" && ComTrim(f_eweek.value) != "") {
	   if(ComParseInt(f_sweek.value) > ComParseInt(f_eweek.value)){
	       ComShowMessage(ComGetMsg('COA10011','Week','First Element','Second Element'));
	       f_sweek.focus();
	       return false;
	   }
   }
   // msg1 + ' 는(은) ' + msg2 + '자리가 되어야 합니다.';
   if (ComTrim(f_vessel.value) != "" && ComTrim(f_vessel.value).length != 4){
      ComShowMessage(ComGetMsg('COM12174','VVD First Element','4'));
      f_vessel.focus();
      return false;
   }
   if (ComTrim(f_voyage.value) != "" && ComTrim(f_voyage.value).length != 4){
      ComShowMessage(ComGetMsg('COM12174','VVD Second Element','4'));
      f_voyage.focus();
      return false;
   }
  }
  return true;
}    



/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *      getBackEndJobStatus();
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2011.06.01
 */     
function getBackEndJobStatus() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	ComOpenWait(true);
	formObj.f_cmd.value = SEARCH11;
	var sXml = sheetObj.GetSearchXml("ESM_COA_0106GS.do", coaFormQueryString(formObj));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	
	if (jobState == "3") {
		getBackEndJobSearch();
		clearInterval(backEndJobTimer);
	} else if (jobState == "4") {
		ComShowCodeMessage("COA00001");
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	} else if (jobState == "5") {
		ComShowCodeMessage("COA00002");
		ComOpenWait(false);
		clearInterval(backEndJobTimer);
	}
}   

/**
 * BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *      getBackEndJobSearch();
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2011.06.01
 */       
function getBackEndJobSearch() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	formObj.f_cmd.value = SEARCH12;    	
	var sXml = sheetObj.GetSearchXml("ESM_COA_0106GS.do", coaFormQueryString(formObj));
	var err_cd = ComGetEtcData(sXml, "err_cd");
		
	ComOpenWait(false);
	
	if (err_cd == "00000") {
		ComShowCodeMessage('COA10018','Apply to P/L Chart');
	} else{
		ComShowCodeMessage("COM130505");
	}

	sheetObj.EtcData("err_cd")  = "";
	sheetObj.EtcData("err_msg") = "";
	
}
