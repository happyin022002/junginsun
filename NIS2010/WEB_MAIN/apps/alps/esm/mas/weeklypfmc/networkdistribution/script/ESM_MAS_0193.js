/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0193.js
*@FileTitle : Cost Inquiry by PFMC Type
*Open Issues :
*@LastModifyDate : 2015-05-21
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2015-05-21 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0193 : ESM_MAS_0193 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0193() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateForm       = validateForm       ;
    this.validateSheet      = validateSheet      ;    
    this.setPeriod          = setPeriod          ;
    this.chkValidSearch     = chkValidSearch     ;
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
function processButtonClick() {
  var sheetObject = sheetObjects[0];
  var formObject = document.form;
  
  try {
    var srcName = window.event.srcElement.getAttribute("name");
    
    switch(srcName) {
    
      case "btn_Retrieve":
          doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;
      
      /*case "btn_Creation":
          doActionIBSheet(sheetObject,formObject,IBCREATE);
          // 재 조회
          // doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;*/
      
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

function chk_WM(param1, param2) {
	var formObj = document.form;
	if (param1 == 'W') {
        document.all.div_week.style.display = "inline";
        document.all.div_month.style.display = "none";
        setPeriod(document.form.f_to_wk);
    } else {
        document.all.div_week.style.display = "none";
        document.all.div_month.style.display = "inline";
        if (param2 == '1') {
            setPeriod(document.form.f_to_mon);
        } else {
            setPeriod(document.form.f_mon);
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
		switch(comboObj.id) {
			case "f_seltrade":
				DropHeight = 200;
				SetColWidth("100");
				ValidChar(2, 1);	//영문대문자+숫자
				Index = 0;
				break;
			case "f_sub_trd_cd":
				DropHeight = 100;
				SetColWidth("80");
				ValidChar(2, 1);	//영문대문자+숫자
				Index = 0;
				break;
			case "f_selrlane":
				DropHeight = 300;
				SetColWidth("100");
				ValidChar(2, 1);	//영문대문자+숫자
				Index = 0;
				break;				
			case "f_dir_cd_combo":
				DropHeight = 100;
				SetColWidth("60");
				ValidChar(2, 1);	//영문대문자+숫자				
				Index = 0;
				break; //Bound
	
			case "f_hul_bnd_cd":
				DropHeight = 100;
				SetColWidth("80");
				ValidChar(2, 1);	//영문대문자+숫자
				Index = 0;
				break; //Trade Dir.
		}			
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
  var cnt = 0;	
  switch(sheetNo) {
	  case 1:      //sheet1 init
	      with (sheetObj) {
	  		  //style.height = 202;
	          SheetWidth = sheetTable.clientWidth; //전체 너비 설정
	  		  //SheetWidth = 400; //전체 너비 설정
	          
	          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	          MergeSheet = msHeaderOnly;  //전체Merge 종류 [선택, Default msNone]
	          Editable = true;            //전체Edit 허용 여부 [선택, Default false]
	          InitRowInfo(1 , 1, 2, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	          
	          //var HeadTitle1  = "|STS|SEQ|R.MONTH|S.MONTH|WEEK|TRADE|SUB TRD|R.LANE|IOC|REV VVD|DIR|Trade Dir.|Cost type|Supply|Load|L/F|TTL Days|F.Rev|Port EXP|Canal Transit Fee|Bunker|Crew EXP|Insurance|Lubricant EXP|Store Supply EXP|Vessel M&R|Depreciations|Telecom EXP|Other Operation Fixed Exp|Time Charterage|Space Charterage|General Expense|Vessel Interest|OP COST Total";
	          var HeadTitle1  = "|STS|SEQ|R.MONTH|S.MONTH|WEEK|TRADE|SUB TRD|R.LANE|IOC|REV VVD";
	          var HeadTitle2  = "|DIR|Trade Dir.|Cost type|Supply|Load|L/F|TTL Days|Port EXP|Canal Transit Fee";
	          var HeadTitle3  = "|Bunker|Crew EXP|Insurance|Lubricant EXP|Store Supply EXP|Vessel M&R|Depreciations";
	          var HeadTitle4  = "|Telecom EXP|Other Operation Fixed Exp|Time Charterage|Space Charterage|General Expense";
	          var HeadTitle5  = "|Vessel Interest|OP COST Total";
	          
	          var headCount = ComCountHeadTitle(HeadTitle1 + HeadTitle2 + HeadTitle3 + HeadTitle4 + HeadTitle5);
	          
	          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	          InitColumnInfo(headCount, 0, 0, true);
	          
	          // 해더에서 처리할 수 있는 각종 기능을 설정한다
	          InitHeadMode(true, true, true, true, false,false); 
	          
	          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	          //InitHeadRow(0, HeadTitle0, true);
	          InitHeadRow(0, HeadTitle1 + HeadTitle2 + HeadTitle3 + HeadTitle4 + HeadTitle5, true);    				
	          
	          //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	          InitDataProperty(0, cnt++, dtHidden,       30, daCenter, true,  "");
              InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
              InitDataProperty(0, cnt++, dtSeq,     40, daCenter, true, "seq",      		false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    60, daCenter, true, "cost_yrmon",    	false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    60, daCenter, true, "sls_yrmon",    	false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "cost_wk",         	false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "trd_cd",           false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    60, daCenter, true, "sub_trd_cd",       false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "rlane_cd",         false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "ioc_cd",           false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,   120, daCenter, true, "rev_vvd",          false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "dir_cd",           false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "hul_bnd_cd",       false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "cost_tp",          false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    50, daRight,  true, "fnl_hjs_bsa_capa", false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    40, daRight,  true, "load",             false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    35, daCenter, true, "load_ft",          false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    60, daCenter, true, "ttl_dys",          false, "", dfNone,    0, false, false);
	          InitDataProperty(0, cnt++, dtData,    60, daRight,  true, "amt_1_01",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,   110, daRight,  true, "amt_1_02",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    50, daRight,  true, "amt_1_03",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    60, daRight,  true, "amt_1_04",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    70, daRight,  true, "amt_1_05",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    90, daRight,  true, "amt_1_06",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,   110, daRight,  true, "amt_1_07",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    90, daRight,  true, "amt_1_08",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    90, daRight,  true, "amt_1_09",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,    90, daRight,  true, "amt_1_10",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,   165, daRight,  true, "amt_1_11",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,   110, daRight,  true, "amt_1_12",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtData,   120, daRight,  true, "amt_1_13",         false, "", dfFloatOrg, 2, false, false);
	          InitDataProperty(0, cnt++, dtHidden, 110, daRight,  true, "amt_1_15",         false, "", dfFloatOrg, 2, false, false); // General Expense
	          InitDataProperty(0, cnt++, dtData,   100, daRight,  true, "amt_1_14",         false, "", dfFloatOrg, 2, false, false);	          
	          InitDataProperty(0, cnt++, dtData,   100, daRight,  true, "op_total",         false, "", dfFloatOrg, 2, false, false);
	          
	          CountPosition = 0;
	          
	          sheetObj.style.height = 390;                    
	          //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
	          EditableColorDiff = true;
	          WaitImageVisible = false;
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
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0193GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_selrlane, "code", "name");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.f_sub_trd_cd, "code", "name");
		formObj.f_selrlane.Index = 0;
		formObj.f_sub_trd_cd.Index = 0;
	} else {
		formObj.f_selrlane.RemoveAll();
		formObj.f_selrlane.InsertItem(0, "All", "All");
		formObj.f_selrlane.Index = 0;
		formObj.f_sub_trd_cd.RemoveAll();
		formObj.f_sub_trd_cd.InsertItem(0, "All", "All");
		formObj.f_sub_trd_cd.Index = 0;
	}
}
    
/**
 * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
 */
function setPeriod(obj) {
	ComMasSetPeriod(obj);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    
    switch(sAction) {
	    case IBCLEAR:          //조회
		    sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0193GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			var prevWeek = "";
			if (0 < arrXml.length) {
				ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "name");
				prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
			}
			if (1 < arrXml.length)
				ComXml2ComboItem(arrXml[1], formObj.f_sub_trd_cd, "code", "name");
			if (2 < arrXml.length)
				ComXml2ComboItem(arrXml[2], formObj.f_selrlane, "code", "name");
			if (3 < arrXml.length)
				ComXml2ComboItem(arrXml[3], formObj.f_dir_cd_combo, "code", "name");
			if (arrXml.length > 4)
                ComXml2ComboItem(arrXml[4], formObj.f_hul_bnd_cd, "code", "name");            
			
			formObj.f_year.focus();
			formObj.f_year.value   = ComGetEtcData(arrXml[0], "fYear"); 
		    formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		    formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		    formObj.f_fm_wk.value  = formObj.f_to_wk.value = prevWeek;
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
            //sheetObj.DoSearch4Post("ESM_MAS_0193GS.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
            sheetObj.DoSearch("ESM_MAS_0193GS.do", masFormQueryString(formObj));
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
        
        /*case IBCREATE:      //생성
        	if (!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }			
        	if (!ComShowCodeConfirm("MAS10020")) {
        		return false;
        	}						
			ComOpenWait(true);
            sheetObj.Redraw = false;                
            formObj.f_cmd.value = MULTI01;                
            //alert(FormQueryString(formObj));                
            sheetObj.DoSearch("ESM_MAS_0193GS.do", FormQueryString(formObj));
//          var sXml = sheetObj.GetSearchXml("ESM_MAS_0193GS.do", masFormQueryString(formObj));
//			sheetObj.LoadSaveXml(sXml);
            //doActionIBSheet(sheetObject,formObject,IBSEARCH);
            sheetObj.Redraw = true;
            ComOpenWait(false);
            break;*/
    }
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
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
function validateSheet(sheetObj) {
	with(sheetObj){
	}

	return true;
}


/**
 * 검색시 필수입력사항 체크
*/
function chkValidSearch(){
    var formObj = document.form;
	
	with(formObj){
		// Year Check..
		if (f_year.value == "") {
			// [COM12114] : Year 를(을) 확인하세요.
			ComShowCodeMessage("COM12114", "Year");
			f_year.focus();
			return false;
		}
		
		if(!ComIsDate(f_year, "yyyy")){
			// [MAS10009] = 'Please enter Year correctly.\n\n Format : YYYY
			ComShowCodeMessage('MAS10009','Year','YYYY');
			f_year.focus();
			return false;
		}
		
		// Week Check..
		if(f_chkprd[0].checked){
			if (f_fm_wk.value != "" && f_to_wk.value == ""){
				// [COM12114] : Week 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Week");
				f_to_wk.focus();
				return false;
			}
			if (f_fm_wk.value == "" && f_to_wk.value != ""){
				// [COM12114] : Week 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Week");
				f_fm_wk.focus();
				return false;
			}
			if (f_fm_wk.value > f_to_wk.value) {
				// [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
				ComShowCodeMessage("MAS10011","Week","From","To");
				f_to_wk.focus();
				return false;
			}
			if(!ComIsWeek(f_fm_wk)){
				// [MAS1009] = Week 값을 확인하십시오.
				ComShowCodeMessage('MAS10009','Week','WW');
				f_fm_wk.focus();
				return false;
			}
			if(!ComIsWeek(f_to_wk)) {
				// [MAS1009] = Week 값을 확인하십시오.
				ComShowCodeMessage('MAS10009','Week','WW');
				f_to_wk.focus();
				return false;
			}
		}
		// Month Check..
		else {
			if (f_fm_mon.value != "" && f_to_mon.value == ""){
				// [COM12114] : Month 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Month")
				f_to_mon.focus();
				return false;
			}
			if (f_fm_mon.value == "" && f_to_mon.value != "") {
				// [COM12114] : Month 를(을) 확인하세요.
				ComShowCodeMessage("COM12114", "Month");
				f_fm_mon.focus();
				return false;
			}
			if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
				// [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
				ComShowCodeMessage("MAS10011","Month","From","To");
				f_to_mon.focus();
				return false;
			}
			if(f_fm_mon.value == "" && f_fm_wk.value == ""){
				//ComShowCodeMessage("COM12138", "month", "week");
				return false;
			}
			if(!ComIsMonth(f_fm_mon)){
				// [MAS1009] = Month 값을 확인하십시오.
				ComShowCodeMessage('MAS10009','Month','MM');
				f_fm_mon.focus();
				return false;
			}
			if(!ComIsMonth(f_to_mon)) {
				// [MAS1009] = Month 값을 확인하십시오.
				ComShowCodeMessage('MAS10009','Month','MM');
				f_to_mon.focus();
				return false;
			}
		}
	}
	return true;
}

/**
 * 조회 후
 * @param sheetObj
 * @param errMsg
 */
function sheet1_OnSearchEnd(sheetObj, errMsg){
	var formObj = document.form;	
	/*if(formObj.f_op_view.value == "OP4"){
		sheetObj.ColHidden("op_lane_tp_cd") = false;
	}else{
		sheetObj.ColHidden("op_lane_tp_cd") = true;
	}*/
}



