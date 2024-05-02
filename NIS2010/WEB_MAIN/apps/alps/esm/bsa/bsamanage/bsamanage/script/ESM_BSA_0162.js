/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0162.jsp
* @FileTitle : Inquire/Edit Over Used Slot Price
* Open Issues :
* Change history :
* @LastModifyDate : 2008-10-01
* @LastModifier : 전성진
* @LastVersion : 1.0
*  2007-01-18 전성진
*  1.0 최초 생성
*=========================================================
* History :
* 2008.10.01 전성진 CSR No.N200809059194 
*					: Over Used Slot Price Table 생성
* 2009.10.16 남궁진호 ALPS 전환   1.0 Creation
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
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
     * @class ESM_BSA_0162 : ESM_BSA_0162 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0162() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var sheet_height = 20; // sheet의 height

    var first_load = true;  //최초 Load시만 sheet height 조정
    var selRow = "";
    var selValue = "";
    var selCol = "";

	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	var comboXml = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	var sheetObject = sheetObjects[0];
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;

    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;

    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;

    			case "btns_calendar1":
    				 var cal = new ComCalendar();
    				cal.select(formObject.txtSDate,  'yyyy-MM-dd');
    				break;

    			case "btns_calendar2":
    				 var cal = new ComCalendar();
    				cal.select(formObject.txtEDate,  'yyyy-MM-dd');
    				break;

    			case "bu_zoom_in":
    				sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "none";
    				div_zoom_out.style.display = "inline";
    				parent.syncHeight();
    				break;

    			case "bu_zoom_out":
    				sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "inline";
    				div_zoom_out.style.display = "none";
    				parent.syncHeight();
    				break;

    			case "btng_rowcopy":
    				doActionIBSheet(sheetObject,formObject,IBCOPYROW);
    				break;
    			
    			case "btng_rowadd":
    				doActionIBSheet(sheetObject,formObject,IBINSERT);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
    	 sheetObjects[sheetCnt++] = sheet_obj;
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(head1,head2) {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1,head1,head2);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	// 멀티콤보 처리
    	loadingMode = true;
    	loadCombo();
    	
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
    	
		for(l=0;l<sheetObjects.length;l++){
			initIBCombo(sheetObjects[l]);			
		}
		loadingMode = false;
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,head1,head2) {
    	var formObj = document.form;

    	var arrHead1 = "";
    	var arrHead2 = "";

    	var fixCnt = 16; //고정길이
    	var varCnt = 0;  //가변길이

    	switch(sheetNo) {
    		case 1:      //sheet1 init
    			if (head1 == "" && head2 == "") {
    				head1 = "|Joint Operation (Charter-out)|Joint Operation (Charter-out)|Joint Operation (Charter-out)"
    							+ "|Sub lease(Charter-out)|Sub lease(Charter-out)|Sub lease(Charter-out)"
    							+ "|Cross-charter out(lease)|Cross-charter out(lease)|Cross-charter out(lease)";
    				head2 = "|CRR1|CRR2|CRR3|CRR1|CRR2|CRR3|CRR1|CRR2|CRR3";
    			}

    			arrHead1 = head1.replace(/(^\s*)/g, '').split("|");
    			arrHead2 = head2.replace(/(^\s*)/g, '').split("|");

    			varCnt = arrHead2.length - 1;

    			with (sheetObj) {
    			    if (first_load == true) { style.height = GetSheetHeight(sheet_height); }
    			    first_load = false;
    			    
    				SheetWidth = mainTable.clientWidth;
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				MergeSheet = msHeaderOnly;
    				Editable = true;
    				InitRowInfo(2, 1, 9, 100);
    				InitColumnInfo(fixCnt+varCnt, 12, 0, true);
    				InitHeadMode(false, false, false, true, false, false);

    				var HeadTitle0 = "Del|STS|group|SEQ|VVD|From|To|Trade|R.Lane|Dir.|From Port|To Port||Charter In|Charter In|Charter In"
    				               + head1;
    				var HeadTitle1 = "Del|STS|group|SEQ|VVD|From|To|Trade|R.Lane|Dir.|From Port|To Port||Basic Chartered|Chartered|Additional Chartered"
    				               + head2;

    				InitHeadRow(0, HeadTitle0, true);
    				InitHeadRow(1, HeadTitle1, true);

    				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
    				//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
    				//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
    				//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
    				var cnt = 0;
    				InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true, "del");
    				InitDataProperty(0, cnt++, dtStatus,    30, daCenter, true, "ibflag");
    				InitDataProperty(0, cnt++, dtHidden,    40, daCenter, true, "grp",                 false, "", dfInteger,  0, false, false);
    				InitDataProperty(0, cnt++, dtData,      40, daCenter, true, "seq",                 false, "", dfNone,     0, false, false);
    				
    				InitDataProperty(0, cnt++, dtData,      70, daCenter, true, "vvd_cd" ,             false, "", dfEngUpKey, 9, true,  true);
    				InitDataProperty(0, cnt++, dtData,      70, daCenter, true, "bsa_slt_prc_fm_dt",   true , "", dfDateYmd,  0, true,  true);
    				InitDataProperty(0, cnt++, dtData,      70, daCenter, true, "bsa_slt_prc_to_dt",   true , "", dfDateYmd,  0, true,  true);
    				InitDataProperty(0, cnt++, dtCombo,     50, daCenter, true, "trd_cd",              true , "", dfNone,     0, true,  true);
    				InitDataProperty(0, cnt++, dtCombo,     60, daCenter, true, "rlane_cd",            true , "", dfNone,     0, true,  true);
    				InitDataProperty(0, cnt++, dtCombo,     45, daCenter, true, "dir_cd",              true , "", dfNone,     0, true,  true);				
    				InitDataProperty(0, cnt++, dtData,      75, daCenter, true, "fm_port_cd",          true , "", dfNone,     0, true,  true);
    				InitDataProperty(0, cnt++, dtData,      75, daCenter, true, "to_port_cd",          true , "", dfNone,     0, true,  true);
    				InitDataProperty(0, cnt++, dtHidden,    30, daCenter, true, "ovr_usd_slt_prc_seq", false, "", dfNone,     0, false, false);

    				InitDataProperty(0, cnt++, dtAutoSum,  100, daRight,  true, "bzc_chtr_uc_amt",     false, "", dfFloatOrg, 2, true,  true);
    				InitDataProperty(0, cnt++, dtAutoSum,  100, daRight,  true, "chtr_uc_amt",         false, "", dfFloatOrg, 2, true,  true);
    				InitDataProperty(0, cnt++, dtAutoSum,  130, daRight,  true, "add_chtr_uc_amt",     false, "", dfFloatOrg, 2, true,  true);

    				for (var n=0; n<varCnt; n++) {
    					InitDataProperty(0, cnt, dtAutoSum, 60, daRight, true, "uc_amt"+n, false, "", dfFloatOrg, 2, true, true);
    					CellBackColor(1, cnt) = RgbColor(211, 219, 255);
    					cnt++;
    				}

    				RangeBackColor(1, 13, 1, 15) = RgbColor(255, 248, 251);
    				HeadRowHeight = 10;
    				CountPosition = 0 ;

    				//Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시할지 여부를 확인하거나 설정한다.
    				EditableColorDiff = false;
    			}
    			break;

    	}
    }
     
    /**
 	 * 콤보 항목을 설정한다. by.yjjeon
 	 */
 	function initCombo (comboObj, comboNo) {
 		with (comboObj) {
 			DropHeight = 300;
 			comboObj.InsertItem(0, 'All' ,''); 
 			Index = 0;
 		}
 	}
 	
 	/**
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function initIBCombo(sheetObj){
		if (comboXml.length > 0){
			comSetIBCombo(sheetObj, comboXml[0], "trd_cd", true, 0);
		}
		if (comboXml.length > 2){
			comSetIBCombo(sheetObj, comboXml[2], "dir_cd",true,0);
		}
		if (comboXml.length > 3){
			comSetIBCombo(sheetObj, comboXml[3], "rlane_cd",true,0);
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if (!validateCond(formObj)) {
    				return false;
    			}

    			formObj.f_cmd.value = SEARCHLIST;
    			var sXml = sheetObj.GetSearchXml("ESM_BSA_0162GS.do",  bsaFormString(formObj,getParam(curPgmNo)));
    			var head1 = GetEtcDataForExceptional(sXml,"head1");
    			var head2 = GetEtcDataForExceptional(sXml,"head2");
    			if (head1 != "" && head2 != "") {
    				sheetObj.Redraw = false;
    				sheetObj.Visible = false;
    				sheetObj.RemoveAll();
    				sheetObj.Reset();
    				ComConfigSheet(sheetObjects[0]);	
    				initSheet(sheetObj, 1, head1, head2);
    				initIBCombo(sheetObj);
    				sheetObj.Visible = true;
    				sheetObj.Redraw = true;
    				sheetObj.LoadSearchXml(sXml);
    				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
    			}
    			sheetObj.InitHeadMode(false, false, false, true, false, false); //Sort가능

    			break;

    		case IBSAVE:        //저장
    			if (!validateForm(sheetObj)) {
    				return false;
    			}
    			formObj.f_cmd.value = MULTI;
    			sheetObj.DoSave("ESM_BSA_0162GS.do",  bsaFormString(formObj,getParam(curPgmNo)), -1, false);
    			break;

    		case IBDOWNEXCEL:   //엑셀 다운로드
    			//sheetObj.SpeedDown2Excel(-1);
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
    		
    		case IBINSERT:   // 행 추가
    			with(sheetObj) {
    			    var row = 0;
    			    
    			    row = DataInsert(-1);
    			    CellValue2(row, "seq") = "";
    			}
    			break;	

    		case IBCOPYROW:      // 행 복사
    			with(sheetObj) {
        			if (RowCount > 0) {
        				var row = DataCopy(false); //행을 복사
        				CellValue2(row, "seq") = "";
        				CellValue2(row, "ovr_usd_slt_prc_seq") = "";
            		}
    			}
    			break;
    	}
    }

    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
    	with(sheetObj){
    		//행 전체의 배경색을 설정하거나 확인한다.
    		ColBackColor("ibflag")        = RgbColor(239,235,239);
    		ColBackColor("seq") = RgbColor(239,235,239);
    	}
    	
        //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
        if(document.form.isExcludZero.checked) {
          for(var k=0; k<=sheetObj.LastCol; k++) {          
              if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
                 sheetObj.ColHidden(k) = true;	 
          }
        } else {
          for(var k=0; k<=sheetObj.LastCol; k++){
               if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
                  sheetObj.ColHidden(k) = false;	            
          }	      
        }
    }

    /**
     * sheet 데이터 변경시 처리해주는 부분
     * vvd 변경시 First ETD 데이타를 가지고 온다.
     */
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        var formObj = document.form;
        var param = "";
        
    	with(sheetObj){
    		// 기간과, 상태 컨트롤 
    		if (ColSaveName(Col) == "bsa_slt_prc_fm_dt") {		    
    		    if(CellValue(Row-1,"grp") == CellValue(Row,"grp")) {
        			CellValue2(Row-1,"bsa_slt_prc_to_dt") = getOffsetDate(Value,-1);
        			Cellvalue2(Row-1, "ibflag") = "U";    		
    		    }

    			if(CellValue(Row,"grp") == CellValue(Row+1,"grp"))  {
    			    CellValue2(Row,"bsa_slt_prc_to_dt") = getOffsetDate(CellValue(Row+1,"bsa_slt_prc_fm_dt"),-1);
    			}
    		}
    		if (ColSaveName(Col) == "bsa_slt_prc_to_dt" && CellValue(Row+1,"grp") == CellValue(Row,"grp")) {
    			CellValue2(Row+1,"bsa_slt_prc_fm_dt") = getOffsetDate(Value,1);
    		}			
    	}
    	
    	// VVD 변경시 First ETD DT를 구해온다.
    	if (sheetObj.ColSaveName(Col) == "vvd_cd") {
			selRow = Row;
			selValue = Value;
			
			param = param+"f_cmd="+SEARCHLIST02;
			param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
			param = param+"&code=etdDt";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			var etdDt = GetEtcDataForExceptional(sXml, "etdDt", "0");
			getEdtDate(etdDt);
    	}
    	
    	if (sheetObj.ColSaveName(Col) == "trd_cd") {
    		ibTrade_OnChange(sheetObj, Row, Col);
		}
    	
    	if (sheetObj.ColSaveName(Col) == "fm_port_cd" || sheetObj.ColSaveName(Col) == "to_port_cd") {
    		selRow = Row;
    		selCol = Col;
    		selValue = Value;
    		

    		
    		param = "f_cmd="+SEARCHLIST02;
    		param = param+"&port_cd="+sheetObj.CellValue(Row,Col);
    		param = param+"&code=locCd";
    		var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    		var locCd = GetEtcDataForExceptional(sXml, "locCd", "0");
    		
    		isValidLocation(locCd);
    	}
    }

    //VVD --> edt-date
    function getEdtDate(result) {
    	var sheetObj = sheetObjects[0];
    	var tmpRow = 0;

    	if(result == null || result == "" || result == "null"){
    		ComShowMessage(ComGetMsg('BSA10027',selValue));  //msg1 + '는(은) 유효한 VVD가 아니거나 EDT Date가 존재하지 않습니다.'
    		sheetObj.SelectCell(selRow,"vvd_cd",true);
    	} else {
    		sheetObj.CellValue(selRow,"bsa_slt_prc_fm_dt") = result;
    	}
    }

    function isValidLocation(result) {
        var sheetObj = sheetObjects[0];
        
        if(!result){
    		ComShowMessage(ComGetMsg('BSA10004',selValue));  //msg1 + ' 는(은) 유효한 PORT가 아닙니다.'
        	sheetObj.SelectCell(selRow,selCol,true);
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj) {
    	with(sheetObj){
    	}

    	return true;
    }

    /**
     * 화면 조회값에 대한 유효성검증 프로세스 처리
     */
    function validateCond(formObj) {
    	with(formObj){
    		if (ComTrim(txtSDate.value) == "") {
    			//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
    			//txtSDate.focus();
    			ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
    			return false;
    		}

    		// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
    		if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
    			if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
    				//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
    				//txtEDate.focus();
    				ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
    				return false;
    			}
    		}
    	}

    	return true;
    }

    /**
     * ifram을 이용하여 R.Lane 표시
     */
    function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var param = "";
		var trd_cd = "";
		sheetObj.WaitImageVisible = false;
		
		if(obj.Text != ""){
			trd_cd = obj.Code;
			param = "f_cmd="+SEARCHLIST01;
			param = param+"&trd_cd="+trd_cd;
			param = param+"&code=rLane";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
			formObj.cobLane.Index = 0;
		}
		sheetObj.WaitImageVisible = true;
    }
    function ibTrade_OnChange(sheetObj, row, col) {
 		if (loadingMode == true) return; 
 		var param = "";
 		var trd_cd = "";
		trd_cd = sheetObj.CellValue(row, col);
		sheetObj.WaitImageVisible = false;
		
		if(trd_cd != ""){
			param = "f_cmd="+SEARCHLIST02;
			param = param+"&trd_cd="+trd_cd;
			param = param+"&code=ibLane";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			var rlane = GetEtcDataForExceptional(sXml, "trdCd", "0");
			sheetObj.CellComboItem(row,"rlane_cd", rlane, rlane);
		}
		sheetObj.WaitImageVisible = true;
 	}
    
    function loadCombo() {
    	var formObj = document.form;
		var sXml = formObj.sXml.value;

		var arrXml = sXml.split("|$$|");
		comboXml = arrXml;

		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
		document.form.sXml.value="";
    }
	/* 개발자 작업  끝 */