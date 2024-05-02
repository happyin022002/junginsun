/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0125.js
*@FileTitle : Commitment Vol./Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2007-03-20 Kim Jong Beom
*            CSR No.N200807218173 Commercial Base U/C 화면 추가
* 2008.07.23 전윤주 N200807218173 Commercial Base U/C 화면 추가로 sheet2 삭제
* 2008.09.10 박칠서 N200809080013, N200806250012 Commitment Vol./Ratio : 약정율 4자리까지 표시
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => masFormQueryString 변경
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2010.10.01 김기종 Ticket ID:CHM-201006017-01[MAS] 아주 노선 선복사용량에 대한 원양으로의 운항 변고정비 배부 로직(약정율) 추가 요청
* 2011.05.26 최성민 [CHM-201006017-01] MAS 약정율 로직 추가 - 신규 생성 테이블로 변경 Month Copy 기능 추가
* 2013.12.04 최성민 [CHM-201327860] 약정율 및 OP5, OP6 배부로직 변경-fm_hul_bnd_cd, to_hul_bnd_cd pk 추가
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0125 : ESM_MAS_0125 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0125() {
    this.processButtonClick    = processButtonClick   ;  
    this.loadPage              = loadPage             ;
    this.initSheet             = initSheet            ;
    this.setSheetObject        = setSheetObject       ;
    this.setPeriod             = setPeriod            ;
    this.keyEnter_loc          = keyEnter_loc         ;
    this.fnYearMonthSet        = fnYearMonthSet       ;
    this.ComAddSeparator_Local = ComAddSeparator_Local;
    this.sheet1_OnSaveEnd      = sheet1_OnSaveEnd     ;
    this.doActionIBSheet       = doActionIBSheet      ;
    this.validateSheet         = validateSheet        ;
    this.validateCond          = validateCond         ;
}


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet_height1 = 19; // sheet1의 height

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    var sheetObject1 = sheetObjects[0];
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        //message("srcName = " + srcName);

        switch(srcName) {

            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;

			case "btn_Month_Copy":		//팝업창(Month Copy)
        	       var display = "0,1";
        	       ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0125", 250, 160, "", display, true, false);
        	       break;	
                
            case "btn_add":
                doActionIBSheet(sheetObject1,formObject,IBINSERT);
                break;
                
            case "btn_Save":
                doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break;

            case "btn_Downexcel":
                doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                break;

            case "bu_zoom_in1":
                sheet_height1 = getSheetHeightCnt(sheetObject1,"MAX",0);
                sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
                div_zoom_in1.style.display = "none";
                div_zoom_out1.style.display = "inline";
                //parent.syncHeight();
                break;

            case "bu_zoom_out1":
                sheet_height1 = 8;
                sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
                div_zoom_in1.style.display = "inline";
                div_zoom_out1.style.display = "none";
                //parent.syncHeight();
                break;

            case "btn_close":
                self.close();
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
 */
function loadPage() {
	loadingMode = true;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
	loadingMode = false;
	document.form.f_cobtrade.Index = 3;
    document.form.f_cobtrade.focus();
    
    
}

/**
 * IBCOMBO를 초기화하는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} comboObj 필수 IBMultiCombo Object
 * @param {int} comboNo 필수 IBMultiCombo의 순번
 * @return 없음
 * @author 최성민
 * @version 2011.06.01
 */ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "f_cobtrade":
            with(comboObj) {
            	DropHeight = 300;
            	MultiSelect = false;
            	MaxSelect = 1;
            	MaxLength = 3;
            	UseAutoComplete = false;
            	ValidChar(2, 0);	//영어 대문자
            }
            break;
        case "f_coblane":
            with(comboObj) {
            	DropHeight = 300;
            	MultiSelect = false;
            	MaxSelect = 1;
            	MaxLength = 5;
            	UseAutoComplete = false;
            	ValidChar(2, 1);	//영어대문자, 숫자
            }
            break;	 
        case "f_cobdir":
            with(comboObj) {
            	DropHeight = 300;
            	MultiSelect = false;
            	MaxSelect = 1;
            	MaxLength = 1;
            	UseAutoComplete = false;
            	ValidChar(2, 0);
            	Index2 = 0;
            }
            break;	      
        case "f_cobioc":
            with(comboObj) {
            	DropHeight = 300;
            	MultiSelect = false;
            	MaxSelect = 1;
            	MaxLength = 1;
            	UseAutoComplete = false;
            	ValidChar(2, 0);
            	Index2 = 0;
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

/**
 * 시트 초기설정값, 헤더 정의
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                SheetWidth = mainTable1.clientWidth;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                //MergeSheet = msHeaderOnly; //msAll, msPrevColumnMerge, msHeaderOnly, msNone
                MergeSheet =msHeaderOnly + msPrevColumnMerge;
                Editable = true;
                InitRowInfo(2, 1, 9, 100);
                InitColumnInfo(19, 0, 0, true);
                InitHeadMode(false, true, false, true, false, false)

                var HeadTitle0 = "DEL|YYYY-MM|From|From|From|From|From|To|To|BSA|Ratio|ROWTYPE|RANK|DIR RANK|EAMT|WAMT|ERATIO|WRATIO|STS";
                var HeadTitle1 = "DEL|YYYY-MM|Trade|R.Lane|IOC|Dir.|Trade Dir.|Trade|Trade Dir.|BSA|Ratio|ROWTYPE|RANK|DIR RANK|EAMT|WAMT|ERATIO|WRATIO|STS";
                InitHeadRow(0, HeadTitle0, true); 
                InitHeadRow(1, HeadTitle1, false);
                InitDataProperty(0,	cnt++, dtDelCheck, 30, daCenter, true,  "delflag",        false,      "",        dfNone,       0,         true,       true);	
                InitDataProperty(0, cnt++, dtData,     70, daCenter, true, "cost_yrmon",      false, "", dfDateYm,  0, false, false, 6);

                InitDataProperty(0, cnt++, dtCombo,     55, daCenter, true, "fm_trd_cd",     true, "", dfNone,    0, false, true, 3);
                InitDataProperty(0, cnt++, dtCombo,     65, daCenter, true, "fm_rlane_cd",   true, "", dfNone,    0, false, true, 5);
                InitDataProperty(0, cnt++, dtCombo,     45, daCenter, true, "fm_ioc_cd",     true, "", dfNone,    0, false, true, 1);
                InitDataProperty(0, cnt++, dtData,     60, daCenter, true, "fm_dir_cd", false, "", dfEngUpKey,    0, false, false, 1);
                
                InitDataProperty(0, cnt++, dtCombo,     70, daCenter, true, "fm_hul_bnd_cd",       false, "", dfNone,    0, false, true);
                
                InitDataProperty(0, cnt++, dtData,     55, daCenter, true, "to_trd_cd",       false, "", dfEngUpKey,    0, false, false, 3);

                InitDataProperty(0, cnt++, dtCombo,     70, daCenter, true, "to_hul_bnd_cd",       false, "", dfNone,    0, false, false);
                
                InitDataProperty(0, cnt++, dtAutoSum, 	50, daRight,  true, "bsa_cmmt_amt",       false, "", dfInteger,   0, true,  true, 10);
                InitDataProperty(0, cnt++, dtData, 		60, daRight,  true, "bsa_cmmt_rto",       false, "", dfFloatOrg, 2, false,  false);
                InitDataProperty(0, cnt++, dtHidden,     80, daCenter, true, "row_type",       false, "", dfNone,    0, false, true, 3);
                InitDataProperty(0, cnt++, dtHidden,     80, daCenter, true, "rank",       false, "", dfNone,    0, false, true, 3);
                InitDataProperty(0, cnt++, dtHidden,     80, daCenter, true, "dir_rank",       false, "", dfNone,    0, false, true, 3);
                
                InitDataProperty(0, cnt++, dtHidden,     80, daCenter, true, "e_amt",       false, "", dfInteger,   0, true,  true);
                InitDataProperty(0, cnt++, dtHidden,     80, daCenter, true, "w_amt",       false, "", dfInteger,   0, true,  true);
                InitDataProperty(0, cnt++, dtHidden,     80, daCenter, true, "e_ratio",       false, "", dfFloatOrg,   2, true,  true);
                InitDataProperty(0, cnt++, dtHidden,     80, daCenter, true, "w_ratio",       false, "", dfFloatOrg,   2, true,  true);
                InitDataProperty(0, cnt++, dtHiddenStatus,   45, daCenter, true, "ibflag");
                
                CellBackColor(1, "fm_trd_cd")     = RgbColor(222,251,248);
                CellBackColor(1, "fm_rlane_cd")   = RgbColor(222,251,248);
                CellBackColor(1, "fm_ioc_cd")     = RgbColor(222,251,248);
                CellBackColor(1, "fm_dir_cd") = RgbColor(222,251,248);

                CellBackColor(1, "to_trd_cd")     = RgbColor(255,248,251);
                CountPosition = 0;
                style.height = GetSheetHeight(sheet_height1) ;
                FocusEditMode = -1;

            }
            break;
    }
}

/**
 * IBSheet Object를 배열로 등록
 */
function setSheetObject(sheet_obj) {
     sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
 */
function f_cobtrade_OnChange(obj,value,text) {
	var formObj = document.form;
	if ("All"!=value) {
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST02;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0125GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.f_coblane, "code", "name");
		formObj.f_coblane.Index = 0;
	} else {
		formObj.f_coblane.RemoveAll();
		formObj.f_coblane.InsertItem(0, "All", "All");
		formObj.f_coblane.Index = 0;
	}
}

/**
 * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
 */
function setPeriod(obj) {
	ComMasSetPeriod3(obj);
}

//화면의 Enter-Key 처리
function keyEnter_loc(){
    var sheetObject1 = sheetObjects[0];
    var formObject = document.form;
    if (event.keyCode == 13) {
        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    }
}

function fnYearMonthSet(obj){
    obj.value = ComGetMaskedValue(obj.value,"ym");
    setPeriod(obj);
}

function ComAddSeparator_Local(obj, sFormat) {
    try {
        obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
    } catch(err) { ComFuncErrMsg(err.message); }
}

function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
	if (ErrMsg == "") {
		f_showSubSum(sheetObj);
		ComShowCodeMessage("COM130102", "BSA");
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	f_showSubSum(sheetObj);
}


/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 * @return 없음
 * @author 최성민
 * @version 2011.06.01
 */  
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	
	with(sheetObj){
		var sRow = HeaderRows;
		var eRow = RowCount;
		
		if (sRow <= Row-16 ) sRow = Row-16 ;
		if (eRow >= Row+16 ) eRow = Row+16 ;
		
		if (colName == "delflag") {
			for ( var i = sRow ; i <= eRow; i++) {
				if (CellValue(i,"rank") == CellValue(Row,"rank")){
					CellValue2(i,"delflag") = Value;
				}	
			}
		} else if (colName == "fm_trd_cd") {
			Redraw = false;
			// 한행에 6개의 행이 Merge 되어 있음
			for(var i=0; i< 14; i++) {
				CellValue2(Row + i, Col) = Value;
			}
			
 			var sParam = "f_cmd=" + SEARCHLIST03 + "&f_cobtrade=" + Value;
 			var sXml = sheetObj.GetSearchXml("ESM_MAS_0125GS.do", sParam);
 			
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0) {
 				ComMasSetIBCombo(sheetObj, arrXml[0], "fm_rlane_cd", true, 0);
 			}
 			
 			// 한행에 6개의 행이 Merge 되어 있음
 			for(var i=0; i< 14; i++) {
				CellValue2(Row + i, "fm_rlane_cd") = " ";
			}
			
 			Redraw = true;
		} else if (colName == "fm_rlane_cd") {
			Redraw = false;
			// 한행에 6개의 행이 Merge 되어 있음
			for(var i=0; i< 14; i++) {
				CellValue2(Row + i, Col) = Value;
			}
			
			
			//////////////////////////////////////////////////////////////////
			//Trade Dir.
			getFromTradeDir(sheetObj, Row, Col, Value);
			
			//////////////////////////////////////////////////////////////////
			Redraw = true;
		} else if (colName == "fm_ioc_cd") {
			Redraw = false;
			// 한행에 6개의 행이 Merge 되어 있음
			for(var i=0; i< 14; i++) {
				CellValue2(Row + i, Col) = Value;
			}	
			Redraw = true;
		} else if (colName == "fm_hul_bnd_cd") {
			Redraw = false;
			// 한행에 6개의 행이 Merge 되어 있음
			for(var i=0; i< 7; i++) {
				CellValue2(Row + i, Col) = Value;
			}	
			Redraw = true;
		} else if (colName == "bsa_cmmt_amt") {
			if (CellValue(Row,"fm_dir_cd") =="E"){
				CellValue2(Row,"e_amt") = CellValue(Row,"bsa_cmmt_amt");
			}else	if (CellValue(Row,"fm_dir_cd") =="W"){
				CellValue2(Row,"w_amt") = CellValue(Row,"bsa_cmmt_amt");
			}
			f_showSubSum(sheetObj);

			if (CellValue(Row,"fm_dir_cd") =="E"){
				var fRow = FindSubSumRow("dir_rank");

				var arrRow = fRow.split("|");
				for (idx=0; idx<arrRow.length-1; idx++){ 
				  if (arrRow[idx] > Row){
					  for (jdx=arrRow[idx]-14; jdx < arrRow[idx]; jdx ++){ 
						  if (CellValue(Row,"fm_dir_cd") == CellValue(jdx,"fm_dir_cd")){
							  //var ibFlag = CellValue(jdx,"ibflag");
							  if(CellValue(arrRow[idx],"bsa_cmmt_amt") == 0) {
								  CellValue2(jdx,"bsa_cmmt_rto") =  0;
							  } else {
								  CellValue2(jdx,"bsa_cmmt_rto") =  CellValue(jdx,"bsa_cmmt_amt") / CellValue(arrRow[idx],"bsa_cmmt_amt") * 100;
							  }							  
						  }
					  }
					  break;
				  }
				}
			}else 	if (CellValue(Row,"fm_dir_cd") =="W"){
				var fRow = FindSubSumRow("rank");
				var arrRow = fRow.split("|");
				for (idx=0; idx<arrRow.length-1; idx++){ 
				  if (arrRow[idx] > Row){
					  for (jdx=arrRow[idx]-15; jdx < arrRow[idx]-1; jdx ++){ 
						  if (CellValue(Row,"fm_dir_cd") == CellValue(jdx,"fm_dir_cd")){
							  if(CellValue(arrRow[idx],"bsa_cmmt_amt") == 0) {
								  CellValue2(jdx,"bsa_cmmt_rto") =  0;								  
							  } else {
								  CellValue2(jdx,"bsa_cmmt_rto") =  CellValue(jdx,"bsa_cmmt_amt") / CellValue(arrRow[idx],"bsa_cmmt_amt") * 100;
							  }
						  }
					  }
					  break;
				  }
				}
			}
		}
		
	}
}

function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var chkflag = false;
	with(sheetObj){
		var sRow = HeaderRows;
		var eRow = RowCount;
		var rank = CellValue(Row,"rank");
		var status = CellValue(Row,"ibflag");
		
		if (sRow <= Row-15 ) sRow = Row-30 ;
		if (eRow >= Row+15 ) eRow = Row+30 ;

		if (colName == "delflag" && status == "I") {
			for ( var i = eRow ; i >= sRow; i--) {
				if (CellValue(i,"rank") == rank){
					RowDelete(i, false);
				}	
			}
			
			f_showSubSum(sheetObj);
		}
	}
}
function f_showSubSum(sheetObj){
	with(sheetObj){
		HideSubSum();
		ShowSubSum("rank", "bsa_cmmt_amt|bsa_cmmt_rto|w_amt", -1, false, false, -1, "to_hul_bnd_cd=W;bsa_cmmt_amt=|w_amt|;bsa_cmmt_rto=100%");
		ShowSubSum("dir_rank", "bsa_cmmt_amt|bsa_cmmt_rto|e_amt", -1, false, false, -1, "to_trd_cd=TOTAL;to_hul_bnd_cd=E;bsa_cmmt_amt=|e_amt|;bsa_cmmt_rto=100%" );
	}
	
}
//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
  sheetObj.ShowDebugMsg = false;

  switch(sAction) {

		case IBCLEAR:          //조회
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0125GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (0 < arrXml.length) {
				ComXml2ComboItem(arrXml[0], formObj.f_cobtrade, "code", "name");
			}
			
			if (1 < arrXml.length)
				ComXml2ComboItem(arrXml[1], formObj.f_coblane, "code", "name");
			if (2 < arrXml.length)
				ComXml2ComboItem(arrXml[2], formObj.f_cobdir, "code", "name");
			if (3 < arrXml.length)
				ComXml2ComboItem(arrXml[3], formObj.f_cobioc, "code", "name");
			if (4 < arrXml.length) {
				ComMasSetIBCombo(sheetObj, arrXml[4], "fm_trd_cd", true, 0);
			}
			if (5 < arrXml.length) {
				ComMasSetIBCombo(sheetObj, arrXml[5], "fm_rlane_cd", true, 0);
			}
			if (6 < arrXml.length) {
				ComMasSetIBCombo(sheetObj, arrXml[6], "fm_ioc_cd", false, 0);
			}
			if (7 < arrXml.length) {
				ComMasSetIBCombo(sheetObj, arrXml[7], "fm_hul_bnd_cd", true, 0);
				ComMasSetIBCombo(sheetObj, arrXml[7], "to_hul_bnd_cd", true, 0);
			}
			
		
			formObj.f_yearmonth.value = ComGetNowInfo("ym");
			fnYearMonthSet(formObj.f_yearmonth);
			ComOpenWait(false);
			break;
	  case IBINSERT:      //입력
	  		ComOpenWaitCallFunc("makeRowAdd",true);
        	break;	
        	
        	
      case IBSEARCH:      //조회
          if (validateCond(formObj,sAction)) {
        	  // 업무처리중 버튼사용 금지 처리
        	  sheetObj.WaitImageVisible = false;
        	  ComOpenWait(true);
              formObj.f_cmd.value = SEARCHLIST01;
              sheetObj.DoSearch4Post("ESM_MAS_0125GS.do", masFormQueryString(formObj));
              ComOpenWait(false);
          }
          break;

      case IBSAVE:        // 저장
          if (validateSheet(sheetObj)) {
              if (sheetObj.RowCount > 0) {
            	  /*
            	  if (ComShowCodeConfirm("COM130101","BSA") == false){
            		  return;
            	  }*/
            	  var rowM = sheetObj.ColValueDup("fm_trd_cd|fm_rlane_cd|fm_ioc_cd|to_trd_cd|fm_dir_cd|fm_hul_bnd_cd|to_hul_bnd_cd");
            	  if (rowM >= 0) {
					 var msg = ComGetMsg("COM131301");
					 msg += "\n----------------------------------";
					 msg += "\nTrade	: " + sheetObj.CellValue(rowM, "fm_trd_cd");
					 msg += "\nR.Lane	: " + sheetObj.CellValue(rowM, "fm_rlane_cd");
					 msg += "\nIOC	: " + sheetObj.CellValue(rowM, "fm_ioc_cd");
					 msg += "\n----------------------------------";
					 
					 alert(msg);
					 return false;
            	  }	
            	  // 업무처리중 버튼사용 금지 처리
            	  sheetObj.WaitImageVisible = false;
            	  ComOpenWait(true);
                  formObj.f_cmd.value = MULTI01;
                  //sheetObj.DoSave("ESM_MAS_125GS.do", masFormQueryString(formObj), -1, false);
                  sheetObj.DoSave("ESM_MAS_0125GS.do", masFormQueryString(formObj,'f_cmd',true),"");
                  ComOpenWait(false);
              }
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

function makeRowAdd(){
	var sheetObj = sheetObjects[0];
    var formObj = document.form;
    sheetObj.HideSubSum();
	var rank = parseInt(sheetObj.CellValue(sheetObj.RowCount, "rank")) + 1;

	makeRowAddHtml(formObj,sheetObj,rank,"E","AES","HH",-1);
	makeRowAddHtml(formObj,sheetObj,rank,"E","AES","BH",-1);
	makeRowAddHtml(formObj,sheetObj,rank,"E","TPS","HH",1);
	makeRowAddHtml(formObj,sheetObj,rank,"E","TPS","BH",1);
	makeRowAddHtml(formObj,sheetObj,rank,"E","EMS","HH",1);
	makeRowAddHtml(formObj,sheetObj,rank,"E","EMS","BH",1);
	makeRowAddHtml(formObj,sheetObj,rank,"E","IAS","",1);
	
	makeRowAddHtml(formObj,sheetObj,rank,"W","AES","HH",-1);
	makeRowAddHtml(formObj,sheetObj,rank,"W","AES","BH",-1);
	makeRowAddHtml(formObj,sheetObj,rank,"W","TPS","HH",1);
	makeRowAddHtml(formObj,sheetObj,rank,"W","TPS","BH",1);
	makeRowAddHtml(formObj,sheetObj,rank,"W","EMS","HH",1);
	makeRowAddHtml(formObj,sheetObj,rank,"W","EMS","BH",1);
	makeRowAddHtml(formObj,sheetObj,rank,"W","IAS","",-1);
		
	f_showSubSum(sheetObj);
	sheetObj.SelectCell(sheetObj.RowCount+2,"fm_trd_cd");
}
function makeRowAddHtml(formObj,sheetObj,rank,fm_dir_cd,to_trd_cd,to_hul_bnd_cd,xVal){
	var rownum = sheetObj.RowCount+2;
	sheetObj.DataInsert(-1);
	sheetObj.CellValue2(rownum, "cost_yrmon") = ComGetObjValue(formObj.f_yearmonth);
	sheetObj.CellValue2(rownum, "fm_trd_cd") = document.getElementById("f_cobtrade").Code;
	//sheetObj.CellValue2(rownum, "fm_rlane_cd") = " ";
	sheetObj.CellValue2(rownum, "fm_ioc_cd") = "I";
	sheetObj.CellValue2(rownum, "fm_dir_cd") = fm_dir_cd;  
	//sheetObj.CellValue2(rownum, "fm_hul_bnd_cd") = " ";
	sheetObj.CellValue2(rownum, "to_trd_cd") =to_trd_cd;
	sheetObj.CellValue2(rownum, "to_hul_bnd_cd") = to_hul_bnd_cd;
	sheetObj.CellValue2(rownum, "rank") = rank;
	sheetObj.CellValue2(rownum, "row_type") = "Y";  
	
}

//화면 폼입력값에 대한 유효성검증 프로세스 처리
function validateSheet(sheetObj) {
  with(sheetObj){
  }

  return true;
}

//화면 조회값에 대한 유효성검증 프로세스 처리
function validateCond(formObj,sAction) {
  with(formObj) {
      // msg1 + '  를(을) 확인하세요.';
      if (ComTrim(f_yearmonth.value) == "") {
          ComAlertFocus(formObj, ComGetMsg('COM12114','Year-Month'));
          return false;
      }
  }

  return true;
}

/**
 * From R.lane 선택시 Trade Dir 정보를 자동 세팅한다. <br>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 * @return 없음
 * @author 최성민
 * @version 2014.01.21
 */  
function getFromTradeDir(sheetObj, Row, Col, Value) {
	
	with(sheetObj){
		var sTrade = CellValue(Row, "fm_trd_cd");
		var sIoc   = CellValue(Row, "fm_ioc_cd");	
		/*			
		if (Value == "" || sTrade == "" || sIoc == ""){ 
            ComShowCodeMessage("COM12114","mandatory item");
			return;
		}
		*/		
		var sParam = "f_cmd="+ SEARCH01 + "&f_cobtrade="+ sTrade +"&f_coblane=" + Value + "&f_cobioc="+sIoc;
		
		var sXml = GetSearchXml("ESM_MAS_0125GS.do", sParam); 		
		var sEBound = ComGetEtcData(sXml,"E"); 
		var sWBound = ComGetEtcData(sXml,"W"); 
		
		// 14개 Row 중 Dir 별로 Trade Dir 세팅
		for(var i=0; i< 14; i++) {
			if(CellValue(Row + i, "fm_dir_cd") == "W") {
				CellValue2(Row + i, "fm_hul_bnd_cd") = sWBound;
			} else {
				CellValue2(Row + i, "fm_hul_bnd_cd") = sEBound;
			}
		}

	}
	
}

