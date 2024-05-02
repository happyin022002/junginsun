/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0041.js
*@FileTitle : Slot Price Creation/Update (Yearly Plan)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.25
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.25 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.25 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가 - BSA I/F 버튼추가
* 2011.05.25 최윤성 [CHM-201110971-01] BSA // Slot Price Creation 화면 기능 보완
* 2011.07.18 이행지 [CHM-201112101-01] Currency 항목 추가
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
     * @class ESM_BSA_0041 : ESM_BSA_0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0041() {
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

	//var tabObjects = new Array();

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var sheet_height = 20; // sheet의 height

	var first_load = true;  //최초 Load시만 sheet height 조정
	var selRow = "";
	var selValue = "";


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
					
				case "btng_bsaif":
					var param = "?cobTrade="  + comboObjects[0].Code
					          + "&cobLane="   + comboObjects[1].Code
					          + "&opCd="
					          + "&ctrtprice=" + "price";
					
					var rtn = window.showModalDialog("ESM_BSA_0045.do" + param, "BSA Data IF", "dialogWidth:400px;dialogHeight:315px");
					
					if (rtn == "reLoad") {
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
					}
					break;
					
				case "btng_rowcopy":
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
	function loadPage(head1,head2,head3) {
		for(l=0;l<sheetObjects.length;l++){
			ComConfigSheet(sheetObjects[l]);
			initSheet(sheetObjects[l],l+1,head1,head2,head3);
			ComEndConfigSheet(sheetObjects[l]);
		}
		
		loadingMode = true;
		
		
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
	
	function loadCombo() {
		var formObj = document.form;
	 	var sXml = formObj.sXml.value;

	 	var arrXml = sXml.split("|$$|");
	 	comboXml = arrXml;
	 	
	 	if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.cobLane,  "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], formObj.cobDir,   "code", "code");
		if (arrXml.length > 4)
			ComXml2ComboItem(arrXml[4], formObj.cobCurr,  "code", "code");
	 	document.form.sXml.value="";
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo,head1,head2,head3) {
		var formObj = document.form;
		
		var head0="";
		var arrHead1 = "";
		var arrHead2 = "";
		var arrHead3 = "";

		var fixCnt = 18; //고정길이
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
				    
					SheetWidth = mainTable1.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
					Editable = true;
					InitRowInfo(3, 1, 9, 100);
					InitColumnInfo(fixCnt+varCnt, 13, 0, true);
					InitHeadMode(false, false, false, true, false, false);
					
					for (var cnt=0; cnt<varCnt; cnt++) {
						head0 = head0 + "|Rate (Income)";
					}
					
					var HeadTitle0 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Curr.|★|Rate (Expense)|Rate (Expense)|Rate (Expense)"
			               + head0;

					var HeadTitle1 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Curr.|★|Basic Slots|Basic Chartered|Additional Chartered"
					               + head1;
					var HeadTitle2 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Curr.|★|SML|SML|SML"
					               + head2;

					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, false);

					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					var cnt = 0;
					InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true, "del");
					InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");
					InitDataProperty(0, cnt++, dtHidden,  40, daCenter, true, "group", false, "", dfInteger, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,  40, daCenter, true, "maxseq", false, "", dfInteger, 0, false, false);

					InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "slt_prc_seq",        false, "", dfInteger, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,  30, daCenter, true, "slt_prc_seq_org",    false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "vvd_cd" ,            false, "", dfEngUpKey,9, true,  true);
					InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "bsa_slt_prc_fm_dt",  false, "", dfDateYmd, 0, true,  true);
					InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "bsa_slt_prc_to_dt",  false, "", dfDateYmd, 0, true,  true);
					InitDataProperty(0, cnt++, dtData,    45, daCenter, true, "trd_cd",             false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    45, daCenter, true, "rlane_cd",           false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "dir_cd",             false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtCombo,   40, daCenter, true, "curr_cd",            false, "", dfNone,    0, true,  true);

					InitDataProperty(0, cnt++, dtHidden,  30, daCenter, true, "bsa_slt_cost_tp_cd", false, "", dfNone,    0, false, false);

					InitDataProperty(0, cnt++, dtAutoSum,100, daRight,  true, "hjs_bfr_sub_capa",   false, "", dfFloatOrg, 2, true,  true);
					InitDataProperty(0, cnt++, dtAutoSum,100, daRight,  true, "sub_chtr_bsa_capa",  false, "", dfFloatOrg, 2, true,  true);
					InitDataProperty(0, cnt++, dtAutoSum,130, daRight,  true, "crs_chtr_bsa_capa",  false, "", dfFloatOrg, 2, true,  true);

					for (var n=0; n<varCnt; n++) {
						InitDataProperty(0, cnt, dtAutoSum, 60, daRight, true, "slt_prc_capa"+n, false, "", dfFloatOrg, 2, true, true);
						cnt++;
					}
					
					InitDataProperty(0, cnt++, dtAutoSum,    30, daCenter, true, "M_yellow_cnt",      false, "", dfInteger, 0, false, true);
					
					ColHidden("M_yellow_cnt") = true;
					
					RangeBackColor(1, 14, 2, 15 + varCnt) = RgbColor(203, 210, 248);
					
					HeadRowHeight = 10;
					CountPosition = 0 ;

					//Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시할지 여부를 확인하거나 설정한다.
					EditableColorDiff = false;
				}

				initIBCombo(sheetObj);
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

			switch (comboObj.id){
				case "cobTrade":
	            	MaxLength = 3;
	            	UseAutoComplete = true;
	            	ValidChar(2, 1);	//영문대문자+숫자					
					break;
				case "cobLane":
	            	MaxLength = 5;
	            	UseAutoComplete = true;
	            	ValidChar(2, 1);	//영문대문자+숫자
					break;
				case "cobDir":
	            	MaxLength = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);	//영문만 입력
					break;	
				case "cobCurr":
	            	MaxLength = 3;
//	            	UseAutoComplete = true;
	            	ValidChar(2, 0);	//영문만 입력
					break;				
			}
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
			comSetIBCombo(sheetObj, comboXml[0], "trd_cd",   true, 0);
		}
		if (comboXml.length > 2){
			comSetIBCombo(sheetObj, comboXml[2], "dir_cd",   true, 0);
		}
		if (comboXml.length > 3){
			comSetIBCombo(sheetObj, comboXml[3], "rlane_cd", true, 0);
		}
		if (comboXml.length > 4){
			comSetIBCombo(sheetObj, comboXml[4], "curr_cd",  true, 0);
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var trdCnt;
		var ibRlaneArr = "";


		switch(sAction) {
			case IBSEARCH:      //조회
				if (!validateCond(formObj)) {
					return false;
				}
				formObj.f_cmd.value = SEARCHLIST;
				var sXml = sheetObj.GetSearchXml("ESM_BSA_0041GS.do", bsaFormString(formObj,getParam(curPgmNo)));
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
				var param = "&gsno=1";
				sheetObj.DoSave("ESM_BSA_0041GS.do", bsaFormString(formObj,getParam(curPgmNo,'S'))+param, -1, false);
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

			case IBINSERT:      // 행추가
				with(sheetObj) {
	    			if (RowCount > 0) {
	    				var Row = DataCopy(false); //행을 복사
	    				CellValue2(Row,"slt_prc_seq_org") = "";
	    				
						if (Row > HeaderRows) {
	        				InitHeadMode(false, false, false, true, false, false); //Sort불가능
	        				CellValue2(Row,"slt_prc_seq")  = parseInt(CellValue(Row,"slt_prc_seq")) + 1;
	                		CellBackColor(Row, "ibflag")     = RgbColor(239,235,239);
	                		CellBackColor(Row, "trd_cd")   = RgbColor(239,235,239);
	                		CellBackColor(Row, "rlane_cd") = RgbColor(239,235,239);
	                		CellBackColor(Row, "dir_cd")   = RgbColor(239,235,239);
	                		
	        				// 해당 그룹의 삭제된 Row를 제외하고 전체적으로 SEQ를 부여한다. 
	        				var index = 0;
	        				var v_num = 1;
	                        
	                        for(i=1; i<LastRow; i++){
	                            index = FindText("group", CellValue(Row,"group"), i, true);
	                            if(i == 1) v_num = CellValue(index, "slt_prc_seq");// 화면에 조회된 seq 에서 부터 증가시키도록 함
	                            if (index >0){// 찾은 문자열이 있을면
	                                if(CellValue(index, "ibflag") != "D"){
	                                    CellValue(index,"slt_prc_seq") = v_num;
	                                    v_num++;
	                                } else {
	                                    CellValue(index, "slt_prc_seq") = CellSearchValue(index, "slt_prc_seq");
	                                }
	                                i = parseInt(index);
	                            } else {
	                                i = LastRow;
	                            }
	                        }

	                		// SEQ 가 케에 해당 하므로 현재 삽인된 행은 UPDATE가 되고  맨 마지막 행은 INSERT가 되어야한다.
	                		// 따라서 아래와 같이 상태를 변경한다. maxseq
//	                		Cellvalue2(Row, "ibflag") = "U"; 
	                		RowStatus(Row) = "U"; 
	                		for(i=Row; i<=LastRow; i++){
	                		    if(CellValue(Row,"group") == CellValue(i,"group")){
	                		        if(parseInt(CellValue(Row,"maxseq")) < parseInt(CellValue(i,"slt_prc_seq"))){
	                            		if(RowStatus(i) != "D") RowStatus(i) = "I";
	                		        }
	                		    }
	                		}

	                		if( CellValue(Row,"curr_cd") == "" ){
	                			CellValue(Row,"curr_cd") = "USD";
	                		}
						}
	    			}
				}
				break;

		}
	}

	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			//행 전체의 배경색을 설정하거나 확인한다.
			ColBackColor("ibflag")        = RgbColor(239,235,239);
			ColBackColor("slt_prc_seq") = RgbColor(239,235,239);
			ColBackColor("trd_cd")      = RgbColor(239,235,239);
			ColBackColor("rlane_cd")    = RgbColor(239,235,239);
			ColBackColor("dir_cd")      = RgbColor(239,235,239);
		}
	    //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
	    if(document.form.isExcludZero.checked) {
	      for(var k=0; k<=sheetObj.LastCol; k++) {          
	          if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(2, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
	             sheetObj.ColHidden(k) = true;	 
	      }
	    } else {
	      for(var k=0; k<=sheetObj.LastCol; k++){
	           if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(2, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
	              sheetObj.ColHidden(k) = false;	            
	      }	      
	    }
	    // Sub Total Row Hidden
	    if(sheetObj.RowCount > 0){
		    sheetObj.RowHidden(sheetObj.LastRow) = true;
	    }
	}
				
    /**
     * sheet 데이터 변경시 처리해주는 부분
     * vvd 변경시 First ETD 데이타를 가지고 온다.
     */
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
    	 var param = "";
    	 ComOpenWait(true);

    	 with(sheetObj){
    		 // 컬럼 색깔 컨트롤 
    		 if (Value != 0 && CellBackColor(Row,Col) == RgbColor(255,255,0)) { //값을 바꾸면 RgbColor(255,248,251)으로 만들고
    			 CellBackColor(Row,Col) = RgbColor(255,248,251);
    			 CellValue(Row,"M_yellow_cnt") = parseInt(CellValue(Row,"M_yellow_cnt"), 10) - 1;
    		 } else { //값을 바뀌었는데 이전값과 동일하면 RgbColor(255,255,0) 되돌림
    			 if (Value == CellSearchValue(Row,Col) && CellBackColor(Row,Col) == RgbColor(255,248,251)) {
    				 CellBackColor(Row,Col) = RgbColor(255,255,0);
    				 CellValue(Row,"M_yellow_cnt") = parseInt(CellValue(Row,"M_yellow_cnt"), 10) + 1;
    			 }
    		 }
    		 // 기간과, 상태 컨트롤 
    		 if (ColSaveName(Col) == "bsa_slt_prc_fm_dt" && CellValue(Row-1,"group") == CellValue(Row,"group")) {
    			 CellValue2(Row-1,"bsa_slt_prc_to_dt") = getOffsetDate(Value,-1);
    			 RowStatus(Row-1) = "U";
    			 if(CellValue(Row,"group") == CellValue(Row+1,"group")){
    				 CellValue2(Row,"bsa_slt_prc_to_dt") = getOffsetDate(CellValue(Row+1,"bsa_slt_prc_fm_dt"),-1);
    			 }
    		 }
	    		
			// DEL 상태가 변경시 SEQ와 상태 그리고 기간을 변경한다..
			if(sheetObj.ColSaveName(Col) == "del") {
				// 상태가 Delete 일경우 
				// 해당 그룹의 삭제된 Row를 제외하고 전체적으로 SEQ를 부여한다. 
				var index = 0;
				var v_num = 1;
				
				for(i=1; i<LastRow; i++){
					index = FindText("group", CellValue(Row,"group"), i, true);
					if(i == 1) v_num = CellValue(index, "slt_prc_seq"); // 조회된 처음 seq를 조회 한다.
					if (index >0){// 찾은 문자열이 있을면
						if(CellValue(index, "ibflag") != "D"){
							CellValue2(index,"slt_prc_seq") = v_num;
							v_num++;
						} else {
							CellValue2(index, "slt_prc_seq") = CellSearchValue(index, "slt_prc_seq");
						}
						i = parseInt(index);
					} else {
						i = LastRow;
					}
				}
	        		
				// SEQ의 변화에 따라서 상태를 변경한다.
				for(i=Row+1; i<=sheetObj.LastRow; i++){
					if(sheetObj.CellValue(Row,"group") == sheetObj.CellValue(i,"group")){
						if(parseInt(sheetObj.CellValue(Row,"maxseq")) < parseInt(sheetObj.CellValue(i,"slt_prc_seq"))){
							if(sheetObj.CellValue(i, "ibflag") != "D") sheetObj.RowStatus(i) = "I";
						} else {
							if(sheetObj.CellValue(i, "ibflag") != "D") sheetObj.RowStatus(i) = "U";
						}
					}
				}
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
		ComOpenWait(false);
	}

    //VVD --> edt-date
    function getEdtDate(result) {
    	var sheetObj ;
    	var tmpRow = 0;
    	var formObj = document.form;
    
    	if(formObj.rdoType[0].checked){
    		sheetObj = sheetObjects[0];
   		}else if(formObj.rdoType[1].checked){
   			if(formObj.rdoType2[0].checked){
	   			sheetObj = sheetObjects[1];	
   	   		}else if(formObj.rdoType2[1].checked){
	   	    	sheetObj = sheetObjects[2];	
   			}
   		}else if(formObj.rdoType[2].checked){
   			if(formObj.rdoType2[0].checked){
	   			sheetObj = sheetObjects[3];	
   	   		}else if(formObj.rdoType2[1].checked){
	   	    	sheetObj = sheetObjects[4];
   	   		}
   		}
    	if(result == null || result == "" || result == "null"){
    		ComShowCodeMessage('BSA10027',selValue);  //msg1 + '는(은) 유효한 VVD가 아니거나 EDT Date가 존재하지 않습니다.'
    		sheetObj.SelectCell(selRow,"vvd_cd",true);
    	} else {
    		sheetObj.CellValue(selRow,"bsa_slt_prc_fm_dt") = result;
    	}
    }
    
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj) {
		with(sheetObj){
			// 필드의 color 색이 yellow 인 필드의 존재 여부 확인
			if(sheetObj.SumValue(0, "M_yellow_cnt") != 0) {
				if(!ComShowCodeConfirm('BSA10046')){
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 화면 조회값에 대한 유효성검증 프로세스 처리
	 */
	function validateCond(formObj) {
		with(formObj){
			if (ComTrim(txtSDate.value) == "") {
				ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
				return false;
			}

			// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
			if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
				if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
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
		
		if(obj.Text != ""){
			sheetObj.WaitImageVisible = false;
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
	 
	//sheet의 현재선택된 Row의 상/하위(offset 만큼) Row를 리턴
	 function getFindRow(sheetObj, Row, offset) {
	 	var rtnRow = -1;
	 	var bsa_group = "";
	 	var bsa_seq   = -1;
	 	var col1 = 0;
	 	var col2 = 0;
	 	var tmp = 0;

	 	with(sheetObj) {
	 		sltPrcGroup = CellValue(Row,"group");
	 		sltPrcSeq   = parseInt(CellValue(Row,"slt_prc_seq")) + offset;

	 		for (var i=HeaderRows; i<LastRow; i++) {
	 			col1 = FindText("group", sltPrcGroup, tmp);
	 			if (col1 == -1) { break; } //Not Found

	 			col2 = FindText("slt_prc_seq", sltPrcSeq, col1);
	 			if (col1 == col2) { //Found
	 				rtnRow = col2;
	 				break;
	 			}
	 			tmp = col1 + 1;
	 		}
	 	}

	 	return rtnRow;
	 }
	//Grouping별 Max값을 추출
	 function getMaxRow(sheetObj) {
	 	var bsa_group = "";
	 	var bsa_seq = 0;
	 	var tmpSeq = 0;
	 	var tmpRow = 0;
	 	var maxRow = 0;
	 	var tmp = 0;

	 	with(sheetObj) {
	 		if (SelectRow > 0) {
	 			maxRow = SelectRow;
	 			bsa_group = CellValue(SelectRow,"group");
	 			for (var i=HeaderRows; i<LastRow; i++) {
	 				tmpRow = FindText("group", bsa_group, tmp);
	 				if (tmpRow == -1) {
	 					break;
	 				} else {
	 					tmpSeq = parseInt(CellValue(tmpRow,"slt_prc_seq"));
	 					if (bsa_seq <= tmpSeq) {
	 						bsa_seq = tmpSeq;  //최대값
	 						maxRow = tmpRow;  //최대값이 위치한 Row
	 					}
	 				}
	 				tmp = tmpRow + 1;
	 			} //end of for
	 		}
	 	} //end of with

	 	return maxRow;
	 }
	/**
	 * ifram을 이용하여 R.Lane 표시
	 */
	function ibTrade_OnChange(sheetObj, row, col) {
		if (loadingMode == true) return; 
		var param = "";
		var trd_cd = "";
		with(sheetObj) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(false);
			trd_cd = CellValue(row, col);
			
			if(trd_cd != ""){
				param = "f_cmd="+SEARCHLIST02;
				param = param+"&trd_cd="+trd_cd;
				param = param+"&code=ibLane";
				var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
				var rlane = GetEtcDataForExceptional(sXml, "trdCd", "0");
				sheetObj.CellComboItem(row,"rlane_cd", rlane, rlane);
			}
		}
		sheetObj.WaitImageVisible = true;
	}
	/* 개발자 작업  끝 */