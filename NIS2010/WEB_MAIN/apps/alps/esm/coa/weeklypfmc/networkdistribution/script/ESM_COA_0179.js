/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0179.js
*@FileTitle : TS Allocation2
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.09.17 김기종
* 1.0 Creation
* =========================================================
* History
* 2011.05.26 최성민 [CHM-201006017-01] COA 약정율 로직 추가 
* 									 - Commercial Based Unit Cost 링크 삭제
* 									 - Commitment Vol./Ratio -> Commitment BSA/Ratio 로 이름 변경 
* 									 - Trade Economical Profit 컬럼 3개 삭제
* 2013.01.15 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2013.05.06 김수정 [CHM-201324486][COA] TS Allocation상 WK, Month Display 기능 추가
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
     * @class ESM_COA_0179 : ESM_COA_0179 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0179() {
    	this.processButtonClick = processButtonClick ;
        this.loadPage           = loadPage           ;
        this.initSheet          = initSheet          ;
        this.setSheetObject     = setSheetObject     ;
        this.setPeriod          = setPeriod          ;
        this.sheet1_OnSaveEnd   = sheet1_OnSaveEnd   ;
        this.sheet1_OnChange    = sheet1_OnChange    ;
        this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
        this.doActionIBSheet    = doActionIBSheet    ;
        this.validateSheet      = validateSheet      ;
        this.validateCond       = validateCond       ;
        this.chkValidSearch     = chkValidSearch     ;
        this.validateForm       = validateForm       ;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;

 var comboObjects = new Array();
 var comboCnt = 0;
 var loadingMode = false;
 /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick() {
   var sheetObject = sheetObjects[0];
   var formObject = document.form;
   
   try {
     var srcName = window.event.srcElement.getAttribute("name");
     
     switch(srcName) {
     
       case "btn_Retrieve":
           doActionIBSheet(sheetObject,formObject,IBSEARCH);
           break;
       
       case "btn_Downexcel":
           doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
           break;

       case "btn_Creation":
           doActionIBSheet(sheetObject,formObject,IBCREATE);
           //// 재 조회
           //doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
     
     hiddenWk();
     hiddenMonth();
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
         var com_head = "R.Month|Week|Trade|Lane|IOC|VVD|Unit Cost\nPer Slot|HJS Sales AMT";
         var head1 = "|Network Cost Assignment"
                   + "|Network Cost Assignment"
                   + "|Network Cost Assignment"
                   + "|Network Cost Assignment"
                   + "|Network Cost Assignment"
                   + "|Network Cost Assignment"
                   + "|Network Cost Assignment"
                   + "|Actual Operating Profit"
                   + "|Actual Operating Profit"
                   + "|Actual Operating Profit"
                   //+ "|Trade Economical Profit"
                   //+ "|Trade Economical Profit"
                   //+ "|Trade Economical Profit"
         var head2 = "|R.Month|Week|Trade|Lane|IOC|VVD|Status"
                   + "|Vol(TEU)|Ratio(%)|Assigned AMT"
                   //+ "|Commercial Based|BSA Based|T/S Contribution"

         with (sheetObj) {
           SheetWidth = mainTable.clientWidth;
           if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
           MergeSheet = msPrevColumnMerge; //msHeaderOnly;
           Editable = false;
           InitRowInfo(2, 1, 9, 100);
           InitColumnInfo(18, 0, 0, true);
           InitHeadMode(true, true, false, true, false, false);
           
           var HeadTitle0 = com_head + head1;
           var HeadTitle1 = com_head + head2;
           InitHeadRow(0, HeadTitle0, true);
           InitHeadRow(1, HeadTitle1, false);

           var cnt = 0;
           InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_cost_yrmon",            false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    55, daCenter, true, "M_cost_wk",               false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "M_trd_cd",                false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    55, daCenter, true, "M_rlane_cd",              false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "M_ioc_cd",                false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    90, daCenter, true, "M_vvd_cd",                false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    80, daRight,  true, "M_ts_uc_amt",             false, "", dfFloatOrg,   1, false, false);
           InitDataProperty(0, cnt++, dtAutoSum, 90, daRight,  true, "M_hjs_sls_amt",           false, "", dfNullFloatOrg, 1, false, false);

           InitDataProperty(0, cnt++, dtData,    70, daCenter, true,  "D_cost_yrmon",            false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    55, daCenter, true,  "D_cost_wk",               false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    50, daCenter, false, "D_trd_cd",               false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    55, daCenter, false, "D_rlane_cd",             false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    40, daCenter, false, "D_ioc_cd",               false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    90, daCenter, false, "D_vvd_cd",               false, "", dfNone,    0, false, false);
           InitDataProperty(0, cnt++, dtData,    45, daCenter, false, "D_locl_ts_sts_cd",       false, "", dfNone,    0, false, false);

           InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  false, "D_ts_qty",               false, "", dfFloatOrg, 1, false, false);
           InitDataProperty(0, cnt++, dtData,    70, daRight,  false, "D_ts_rto",               false, "", dfFloatOrg, 2, false, false);
           InitDataProperty(0, cnt++, dtAutoSum, 90, daRight,  false, "D_fx_cost_dtrb_amt",     false, "", dfFloatOrg, 1, false, false);

           //InitDataProperty(0, cnt++, dtAutoSum,110, daRight,  false, "D_cml_bse_cost_amt",     false, "", dfFloatOrg, 1, false, false);
           //InitDataProperty(0, cnt++, dtAutoSum, 90, daRight,  false, "D_bsa_bse_cost_amt",     false, "", dfFloatOrg, 1, false, false);
           //InitDataProperty(0, cnt++, dtAutoSum,105, daRight,  false, "D_ts_ctrb_bse_cost_amt", false, "", dfFloatOrg, 1, false, false);

           //RangeBackColor(1,  6, 1,  9) = RgbColor(222, 251, 248);
           //RangeBackColor(1, 10, 1, 12) = RgbColor(255, 248, 251);

           CellBackColor(1, "D_cost_yrmon")       = RgbColor(222, 251, 248);
           CellBackColor(1, "D_cost_wk")          = RgbColor(222, 251, 248);
           CellBackColor(1, "D_trd_cd")           = RgbColor(222, 251, 248);
           CellBackColor(1, "D_rlane_cd")         = RgbColor(222, 251, 248);
           CellBackColor(1, "D_ioc_cd")           = RgbColor(222, 251, 248);
           CellBackColor(1, "D_vvd_cd")           = RgbColor(222, 251, 248);
           CellBackColor(1, "D_locl_ts_sts_cd")   = RgbColor(222, 251, 248);

           CellBackColor(1, "D_ts_qty")           = RgbColor(255, 248, 251);
           CellBackColor(1, "D_ts_rto")           = RgbColor(255, 248, 251);
           CellBackColor(1, "D_fx_cost_dtrb_amt") = RgbColor(255, 248, 251);
           
           //CellBackColor(1, "D_cml_bse_cost_amt")     = RgbColor(222, 251, 248);
           //CellBackColor(1, "D_bsa_bse_cost_amt")     = RgbColor(222, 251, 248);
           //CellBackColor(1, "D_ts_ctrb_bse_cost_amt") = RgbColor(222, 251, 248);


           HeadRowHeight = 10;
           CountPosition  = 0 ;
           style.height = GetSheetHeight(20) ;
           
           /*
 	      var op = document.form.f_op_view.value;
 	      if(op == "OP1") {	
 	      	sheetObj.ColHidden("D_cml_bse_cost_amt") = true;
 	      	sheetObj.ColHidden("D_bsa_bse_cost_amt") = true;
 	      	sheetObj.ColHidden("D_ts_ctrb_bse_cost_amt") = true;
 	      	sheetObj.ColHidden("D_cmmt_qty") = true;
 	      	sheetObj.ColHidden("D_cmmt_bse_cost_rto") = true;
 	      	sheetObj.ColHidden("D_cmmt_bse_cost_amt") = true;
 	      } else if(op == "OP4") {
 	      	sheetObj.ColHidden("D_cml_bse_cost_amt") = false;
 	      	sheetObj.ColHidden("D_bsa_bse_cost_amt") = false;
 	      	sheetObj.ColHidden("D_ts_ctrb_bse_cost_amt") = false;
 	      	sheetObj.ColHidden("D_cmmt_qty") = false;
 	      	sheetObj.ColHidden("D_cmmt_bse_cost_rto") = false;
 	      	sheetObj.ColHidden("D_cmmt_bse_cost_amt") = false;
 	      }
 	      */
 	      FrozenCols = 8;

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
 		var sXml = sheetObj.GetSearchXml("ESM_COA_0047GS2.do", coaFormQueryString(formObj));
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

 function sheet1_OnSaveEnd(sheetObj, ErrMsg){
 }

 function sheet1_OnChange(sheetObj,Row,Col,Value) {
 }
/*
 function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
 	var op = document.form.f_op_view.value;
 	if(op == "OP1") {
 		sheetObj.ColHidden("D_cml_bse_cost_amt") = false;
 		sheetObj.ColHidden("D_bsa_bse_cost_amt") = false;
 		sheetObj.ColHidden("D_ts_ctrb_bse_cost_amt") = false;
 	} else if(op == "OP4") {	
 		sheetObj.ColHidden("D_cml_bse_cost_amt") = true;
 		sheetObj.ColHidden("D_bsa_bse_cost_amt") = true;
 		sheetObj.ColHidden("D_ts_ctrb_bse_cost_amt") = true;
 	}
 }
*/
 // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
 	sheetObj.ShowDebugMsg = false;
 	sheetObj.WaitImageVisible=false;

 	switch(sAction) {

     case IBCLEAR:          //조회
 	    sheetObj.WaitImageVisible = false;
 		ComOpenWait(true);
 		formObj.f_cmd.value = INIT;
 		
 		var sXml = sheetObj.GetSearchXml("ESM_COA_0179GS.do", coaFormQueryString(formObj));
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
 		if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
 		if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
 		if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
 		if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');
 		  // 업무처리중 버튼사용 금지 처리
 		  sheetObj.WaitImageVisible = false;
 		  ComOpenWait(true);
 	      formObj.f_cmd.value = SEARCHLIST;
 		  sheetObj.DoSearch4Post("ESM_COA_0179GS2.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
 		  ComOpenWait(false);
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
 	        
 	case IBCREATE:      //생성
 		if(!validateForm(sheetObj,formObj,sAction)) return false;
 	    if (ComShowConfirm(ComGetMsg('COA10020')) == true) {
 	       // 업무처리중 버튼사용 금지 처리
 		   sheetObj.WaitImageVisible = false;
 		   ComOpenWait(true);
 	       formObj.f_cmd.value = MULTI01;
 	       sheetObj.DoSearch4Post("ESM_COA_0179GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
 	       ComOpenWait(false);
 	       var err_cd = sheetObj.EtcData("err_cd");
 	       var err_msg = sheetObj.EtcData("err_msg");
 	          
 	       if (err_cd == "00000") {
 	            ComShowMessage(ComGetMsg('COA10018','CREATION'));
 	       }

 	       if(!validateForm(sheetObj,formObj,sAction)) return false;
 	       if(formObj.f_fm_mon.value != "" && formObj.f_fm_mon.value.length != 2) formObj.f_fm_mon.value = fillZero(formObj.f_fm_mon.value, 2, '0','left');
 	       if(formObj.f_to_mon.value != "" && formObj.f_to_mon.value.length != 2) formObj.f_to_mon.value = fillZero(formObj.f_to_mon.value, 2, '0','left');
 	       if(formObj.f_fm_wk.value != "" && formObj.f_fm_wk.value.length != 2) formObj.f_fm_wk.value = fillZero(formObj.f_fm_wk.value, 2, '0','left');
 	       if(formObj.f_to_wk.value != "" && formObj.f_to_wk.value.length != 2) formObj.f_to_wk.value = fillZero(formObj.f_to_wk.value, 2, '0','left');
 	       // 업무처리중 버튼사용 금지 처리
 		   sheetObj.WaitImageVisible = false;
 	       ComOpenWait(true);
 	       formObj.f_cmd.value = SEARCHLIST;
 	       sheetObj.DoSearch4Post("ESM_COA_0179GS2.do", coaFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
 	       ComOpenWait(false);
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
 function validateCond(formObj,sAction) {
 	with(formObj){
 	  // msg1 + '  를(을) 확인하세요.';
 	  if (ComTrim(f_year.value) == "") {
 	    ComShowMessage(ComGetMsg('COM12114','Year'));
 	    f_year.focus();
 	    return false;
 	  }

 	   //생성시에 만 사용...
 	   if (sAction == IBCREATE) { 
 	      // msg1 + ' 의 ' + msg2 + ' 를(을) 입력하세요.';
 	  	  if (ComTrim(f_sweek.value) == "") {
 	        ComShowMessage(ComGetMsg('COM12130','Week','First Element'));
 	        f_sweek.focus();
 	        return false;
 	  	  }
 	  	  if (ComTrim(f_eweek.value) == "") {
 	        ComShowMessage(ComGetMsg('COM12130','Week','Second Element'));
 	        f_eweek.focus();
 	        return false;
 	  	  }
// 	      // msg1 + '의 ' + msg2 + '는(은) ' + msg3 + '와 같아야 합니다.';
// 	  	  if (ComParseInt(formObj.f_sweek.value) != ComParseInt(formObj.f_eweek.value)) {
// 	        ComShowMessage(ComGetMsg('COA10012','Week', 'First Element', 'Second Element'));
// 	        formObj.f_sweek.focus();
// 	        return false;
// 	  	  }
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
// 			    ComShowMessage(ComGetMsg("COM12138", "Month", "Week"));
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
 		//if(!isValidYear(f_year,false,true)) return false;
 	    if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
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
 	    }
 	     else{
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
  * Week 항목 숨김처리 
  * 
  * @return 없음
  * @author 김수정
  * @version 2013.05.02
  */
 function hiddenWk(){
 	var sheetObj = sheetObjects[0];
 	var formObj = document.form;
 	
 	sheetObj.ColHidden("M_cost_wk") = !formObj.chkWk.checked;
 	sheetObj.ColHidden("D_cost_wk") = !formObj.chkWk.checked;
 }

 /**
  * R.Month 항목 숨김처리 
  * 
  * @return 없음
  * @author 김수정
  * @version 2013.05.02
  */
 function hiddenMonth(){
 	var sheetObj = sheetObjects[0];
 	var formObj = document.form;
 	
 	sheetObj.ColHidden("M_cost_yrmon") = !formObj.chkMonth.checked;
 	sheetObj.ColHidden("D_cost_yrmon") = !formObj.chkMonth.checked;
 }

	/* 개발자 작업  끝 */