/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0110.js
*@FileTitle : Create Networkcost & Slot Charter In & Out
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2008.02.28 박칠서 N200801154875 주차와 월 조회 기준 분리
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => masFormQueryString 변경
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.10.07 최성민 [CHM-201113373-01] AES Trade VSL Pool노선의 OP1 및 OP4 산출 로직 변경
* 2013.01.15 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 \
* 2013.06.26 박찬민 [CHM-201325163] [MAS] Network Cost by VVD - Network Cost 탭 Creation 관련 CSR
=========================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0110 : ESM_MAS_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0110() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.initTab            = initTab            ;
    this.setSheetObject     = setSheetObject     ;
    this.setTabObject       = setTabObject       ;
    this.keyEnter_loc  		= keyEnter_loc  ;
    this.setYrWk()  		= setYrWk()  ;
    this.setPeriod()  		= setPeriod()  ;
    this.sheet1_OnChange    = sheet1_OnChange    ;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
    this.tab1_OnChange      = tab1_OnChange      ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.doActionIBSheet2   = doActionIBSheet2   ;
    this.validateForm       = validateForm       ;
    this.validateSheet      = validateSheet      ;
    this.validateCond       = validateCond       ;
    this.chkValidSearch     = chkValidSearch     ;
}


// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var beforetab2 = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var IBNEW = 999; //New
var tab_selno = 0; //현재선택된 탭번호 (0, 1, ...)

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var fYear = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
  var sheetObject = sheetObjects[0];
  var sheetObject2 = sheetObjects[1];
  var formObject = document.form;
  
  try {
    var srcName = window.event.srcElement.getAttribute("name");
    
    switch(srcName) {
    
      case "btn_New":
          if (tab_selno == 0) { //첫번째 탭이면
            doActionIBSheet(sheetObject,formObject,IBNEW);
          } else { //아니면
            doActionIBSheet2(sheetObject2,formObject,IBNEW);
          }
          break;
      
      case "btn_Retrieve":
          if (tab_selno == 0) { //첫번째 탭이면
            doActionIBSheet(sheetObject,formObject,IBSEARCH);
          } else { //아니면
            doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
          }
          break;
      
      case "btn_Creation":
          if (tab_selno == 0) { //첫번째 탭이면
            doActionIBSheet(sheetObject,formObject,IBCREATE);
          } else { //아니면
            doActionIBSheet2(sheetObject2,formObject,IBCREATE);
            if (formObject.f_fm_wk.value != formObject.f_to_wk.value){
              window.event.srcElement.setAttribute("name","t2btng_missingstatus");
              processButtonClick();               
              window.event.srcElement.setAttribute("name","btn_Creation");                 
            }             
          }         
          break;

      case "t1btng_missingstatus": //next
      case "t2btng_missingstatus":
          if (!validateCond(formObject)) {
            return false;
          }

          var strType = "";
          if (srcName == "t1btng_missingstatus") strType = "1";
          if (srcName == "t2btng_missingstatus") strType = "2";
          
          var strYear     = formObject.f_year.value;
          var strFmMonth   = formObject.f_fm_mon.value;
          var strToMonth   = formObject.f_to_mon.value;     
          var strFmWeek   = formObject.f_fm_wk.value;
          var strToWeek   = formObject.f_to_wk.value;     
          var strChkPrd   = "";                                   
          if(formObject.f_chkprd[0].checked){
            strChkPrd   = "W";  // Week                  
          } else {
            strChkPrd   = "M";  // Month                  
          }
          var strTrade    = (formObject.f_cobtrade.Code=="All")?"":formObject.f_cobtrade.Code ;
          var strLane     = (formObject.f_coblane.Code=="All")?"":formObject.f_coblane.Code ;
          var strVessel   = formObject.f_vessel.value;
          var strVoyage   = formObject.f_voyage.value;
          var strDir      = (formObject.cobDir.Code=="All")?"":formObject.cobDir.Code ;
          if (strDir == "") {
            strDir = formObject.f_dir.value;
          }
          strUrl = "?f_stryear="+strYear;
          strUrl += "&f_strfmmonth="+strFmMonth;
          strUrl += "&f_strtomonth="+strToMonth;                    
          strUrl += "&f_strfmweek="+strFmWeek;
          strUrl += "&f_strtoweek="+strToWeek;                    
          strUrl += "&f_strchkprd="+strChkPrd;    // W:Week, M: Month                
          strUrl += "&f_strtrade="+strTrade;
          strUrl += "&f_strlane="+strLane;
          strUrl += "&f_strvessel="+strVessel;
          strUrl += "&f_strvoyage="+strVoyage;
          strUrl += "&f_strdir="+strDir;
          strUrl += "&f_strtype="+strType;
          if(strType == "1") {
            strUrl += "&f_strprcnm=MAS_CREATE_NTCOST_PRC";
          } else {
            strUrl += "&f_strprcnm=MAS_CREATE_SPC_CHT_PRC";
          }
                    
          ComOpenWindow2("ESM_MAS_0114.do" + strUrl,'', "width=900,height=360,menubar=0,status=0,scrollbars=0,resizable=1");
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
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
    tab_selno = 0;
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
        with (sheetObj) {
          style.height = GetSheetHeight(14) ;
          
          //전체 너비 설정
          SheetWidth = mainTable1.clientWidth;
          
          //Host정보 설정[필수][HostIp, Port, PagePath]
          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
          
          //전체Merge 종류 [선택, Default msNone]
          MergeSheet = msPrevColumnMerge; //msNone;
          
           //전체Edit 허용 여부 [선택, Default false]
          Editable = true;
          
          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
          InitRowInfo(1, 1, 9, 100);
          
          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          InitColumnInfo(8, 0, 0, true);
          // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
          InitHeadMode(true, true, false, true, false, false);
          
          var HeadTitle = "STS|SEQ|Item Code|Account Code|OPR 1|OPR 2|Status|Select";
          
          //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle, true);

          //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
          //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
          //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
          //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
          var cnt = 0;
					InitDataProperty(0, cnt++, dtStatus,    40, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtSeq,       40, daCenter, false, "ibseq");

          InitDataProperty(0, cnt++, dtData,      70, daCenter, false, "stnd_cost_cd", false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,     200, daLeft,   false, "stnd_cost_nm", false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtCombo,     70, daCenter, false, "vsl_oshp_cd",  false, "", dfNone,    0, true,  false);
          InitDataProperty(0, cnt++, dtCombo,     70, daCenter, false, "vop_cd",       false, "", dfNone,    0, true,  false);
          InitDataProperty(0, cnt++, dtCombo,    100, daCenter, false, "cre_sts_cd",   false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtCheckBox,  65, daCenter, false, "cre_slct_flg", false, "", dfNone,    0, true,  false);

          initDataCombo(0, "vsl_oshp_cd", " |CHT|COM|OTH|OWN",                           " |CHT|COM|OTH|OWN");
          initDataCombo(0, "vop_cd",      " |SML|OTH",                                   " |SML|OTH");
          initDataCombo(0, "cre_sts_cd",  " |Completed|Progressing|Ready|Missing|Error", " |C|P|R|M|E");


          HeadRowHeight = 10;
          CountPosition  = 0 ;
        }
        break;
  
      case 2:      //sheet2 init
        with (sheetObj) {
          style.height = GetSheetHeight(14) ;
          
          //전체 너비 설정
          SheetWidth = mainTable2.clientWidth;
          
          //Host정보 설정[필수][HostIp, Port, PagePath]
          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
          
          //전체Merge 종류 [선택, Default msNone]
          MergeSheet = msHeaderOnly; 
          
           //전체Edit 허용 여부 [선택, Default false]
          Editable = true;
          
          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
          InitRowInfo(2, 1, 9, 100);
          
          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          InitColumnInfo(12, 0, 0, true);
          // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
          InitHeadMode(true, true, false, true, false, false);
          
          var varHead1 = "Charter-out(Income)|Charter-out(Income)|Charter-out(Income)|"
                       + "Charter-in(Expense)|Charter-in(Expense)|Charter-in(Expense)" ;
          var varHead2 = "Basic-chtr|Sub-let|Crs-chtr|Basic-chtred|Sub-chtred|Crs-chtred" ;

          var HeadTitle0 = "STS|TypeCd|Type|OPR 2|" + varHead1 + "|Status|Select" ;
          var HeadTitle1 = "STS|TypeCd|Type|OPR 2|" + varHead2 + "|Status|Select" ;
          
          //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle0, true);
          InitHeadRow(1, HeadTitle1, false);

          //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
          //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
          //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
          //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
          var cnt = 0;
					InitDataProperty(0, cnt++, dtStatus,   30, daCenter, true, "ibflag");
					//InitDataProperty(0, cnt++, dtSeq,30, daCenter, true, "ibseq");

          InitDataProperty(0, cnt++, dtHidden,   30, daCenter, true, "slt_tp_cd",        false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    130, daLeft,   true, "slt_tp_nm",        false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtCombo,    40, daCenter, true, "vop_cd",           false, "", dfNone,    0, true,  false);
          
          InitDataProperty(0, cnt++, dtCombo,    70, daCenter, true, "incm_bzc_chtr_cd", false, "", dfNone,    0, true,  false);
          InitDataProperty(0, cnt++, dtCombo,    70, daCenter, true, "incm_sub_lse_cd",  false, "", dfNone,    0, true,  false);
          InitDataProperty(0, cnt++, dtCombo,    70, daCenter, true, "incm_crs_chtr_cd", false, "", dfNone,    0, true,  false);
          InitDataProperty(0, cnt++, dtCombo,    75, daCenter, true, "expn_bzc_chtr_cd", false, "", dfNone,    0, true,  false);
          InitDataProperty(0, cnt++, dtCombo,    70, daCenter, true, "expn_sub_chtr_cd", false, "", dfNone,    0, true,  false);
          InitDataProperty(0, cnt++, dtCombo,    70, daCenter, true, "expn_crs_chtr_cd", false, "", dfNone,    0, true,  false);
          
          InitDataProperty(0, cnt++, dtCombo,    65, daCenter, true, "op_cre_sts_cd",    false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtCheckBox, 35, daCenter, true, "cre_slct_flg",     false, "", dfNone,    0, true,  false);

          initDataCombo(0, "vop_cd", " |SML|OTH", " |SML|OTH");
          initDataCombo(0,"incm_bzc_chtr_cd", " |Income|Cost" , " |I|C");
          initDataCombo(0,"incm_sub_lse_cd",  " |Income|Cost" , " |I|C");
          initDataCombo(0,"incm_crs_chtr_cd", " |Income|Cost" , " |I|C");
          initDataCombo(0,"expn_bzc_chtr_cd", " |Income|Cost" , " |I|C");
          initDataCombo(0,"expn_sub_chtr_cd", " |Income|Cost" , " |I|C");
          initDataCombo(0,"expn_crs_chtr_cd", " |Income|Cost" , " |I|C");
          initDataCombo(0, "op_cre_sts_cd", " |Completed|Progressing|Ready|Missing|Error", " |C|P|R|M|E");

          //CellBackColor(1,"incm_bzc_chtr_cd") = RgbColor(222, 251, 248);
          //CellBackColor(1,"expn_bzc_chtr_cd") = RgbColor(255, 248, 251);
          RangeBackColor(1, 4, 1, 6) = RgbColor(222, 251, 248);
          RangeBackColor(1, 7, 1, 9) = RgbColor(255, 248, 251);


          HeadRowHeight = 10;
          CountPosition  = 0 ;
        }
        break;

  }
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
  switch(tabNo) {
    case 1:
        with (tabObj) {
          var cnt = 0 ;
          InsertTab(cnt++ , "Network Cost", -1);
          InsertTab(cnt++ , "Slot Charter In & Out", -1);
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
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
  tabObjects[tabCnt++] = tab_obj;
}

/**
* trade코드 변경시 rLane 리스트를 리플래쉬 한다.
*/
function f_cobtrade_OnChange(obj,value,text) {
	var formObj = document.form;
	if ("All"!=value) {
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST05;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0110GS3.do", masFormQueryString(formObj));
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

//화면의 Enter-Key 처리
function keyEnter_loc(){
	var sheetObject = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var formObject = document.form;
	if(event.keyCode == 13){
	    if (tab_selno == 0) { //첫번째 탭이면
	      doActionIBSheet(sheetObject,formObject,IBNEW);
	    } else { //아니면
	      doActionIBSheet2(sheetObject2,formObject,IBNEW);
	    }
	}
}

/**
 * 주차 셋팅, Period 표시 By LHI 2007.07.18
 */
function setYrWk(prevWeek){
    // 주차 셋팅   
	var formObj = document.form;
	with(formObj){	 	    
		var nowYear = ComGetNowInfo("yy");		
        f_year.value = nowYear;	
        f_fm_wk.value = prevWeek;
        f_to_wk.value = prevWeek;  	        
		f_fm_wk.select();		
	    // Period 표시		
   	    setPeriod(formObj.f_fm_wk);		
	}
}	
    
/**
 * month, week가 변경되었을때 Period를 변경한다.
*/
function setPeriod(obj){
	ComMasSetPeriod(obj);
}  
    
function sheet1_OnChange(sheetObj,Row,Col,Value) {
}

function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
}

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj, nItem) {
      var objs = document.all.item("tabLayer");
      
      objs[nItem].style.display = "inline";
      objs[beforetab].style.display = "none";
      
      //--------------- 요기가 중요 --------------------------------//
      objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
      //----------------------------------------------------------//
      beforetab = nItem;
      
      tab_selno = nItem;
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        // 업무처리중 버튼사용 금지 처리
		sheetObj.WaitImageVisible = false;
				
        
        switch(sAction) {
        	case IBCLEAR:          //조회
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;

				var sXml = sheetObj.GetSearchXml("ESM_MAS_0110GS3.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				var prevWeek = "";
				if (0 < arrXml.length) {
					ComXml2ComboItem(arrXml[0], formObj.f_cobtrade, "code", "name");
					prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
				}
				if (1 < arrXml.length)
					ComXml2ComboItem(arrXml[1], formObj.f_coblane, "code", "name");
				if (2 < arrXml.length)
					ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "name");

				formObj.f_year.focus();
				fYear = ComGetEtcData(arrXml[0], "fYear"); 
				formObj.f_year.value = fYear;
				formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
				formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
				formObj.f_fm_wk.value = formObj.f_to_wk.value = prevWeek;
				setPeriod(formObj.f_to_wk);

				ComOpenWait(false);
				break;

    		case IBNEW:      //초기화
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch4Post("ESM_MAS_0110GS.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8')); 
                break;
            
            case IBSEARCH:      //결과조회
                if (!validateForm(formObj)) {
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST02;
                sheetObj.DoSearch4Post("ESM_MAS_0110GS.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8')); 
                ComOpenWait(false);
                break;
            
            case IBCREATE:      //생성
                if (!validateCond(formObj)) {
                    return false;
                }
                if (sheetObj.RowCount > 0) {
                	///////////////////////////////////////////////////////
                	// Creation is not allowed before WK 40, 2011 due to system logic change.
                	with(formObj){
	                	if(f_chkprd[0].checked){
	                		if (ComParseInt(f_year.value) < 2011 || (ComParseInt(f_year.value) == 2011 && ComParseInt(f_fm_wk.value) < 40)){
		        				ComShowCodeMessage("MAS10061");
		        			}
	                	} else {
	                		if (ComParseInt(f_year.value) < 2011 || (ComParseInt(f_year.value) == 2011 && ComParseInt(f_fm_mon.value) < 10)){
		        				ComShowCodeMessage("MAS10061");
		        			}
	                	}
                	}
                	///////////////////////////////////////////////////////
                	
                    if (ComShowConfirm(ComGetMsg('MAS10020')) == true) { 
                        ComOpenWait(true);
                        formObj.f_cmd.value = MULTI01;
                        sheetObj.DoAllSave("ESM_MAS_0110GS.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
                        
                        var saveStr = sheetObj.GetSaveString(true);
                        var sXml = sheetObj.GetSearchXml("ESM_MAS_0110GS.do", masFormQueryString(formObj, 'param1|param2|param3|param4|param5|param6|param7|param8|f_chkprevcre|fm_date|to_date')+"&"+saveStr);
        				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
        				
        				if (backendJobKey != null && backendJobKey.length > 0) {
        					ComSetObjValue(formObj.backendjob_key, backendJobKey);
        					sheetObj.RequestTimeOut = 7200; //초 - 2시간
        					backEndJobTimer = setInterval(getBackEndJobStatus, 10000);	//밀리초  - 10초
        				}
                    }
                } else {
                    ComShowMessage(ComGetMsg('MAS10017'));
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        // 업무처리중 버튼사용 금지 처리
		sheetObj.WaitImageVisible = false;
        
        switch(sAction) {
            case IBNEW:      //초기화
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST03;
                sheetObj.DoSearch4Post("ESM_MAS_0110GS2.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8')); 
                ComOpenWait(false);
                break;
            
            case IBSEARCH:      //결과조회
                if (!validateForm(formObj)) {
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST04;
                sheetObj.DoSearch4Post("ESM_MAS_0110GS2.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8')); 
                ComOpenWait(false);
                break;
            
            case IBCREATE:      //생성
                if (!validateCond(formObj)) {
                    return false;
                }
                if (sheetObj.RowCount > 0) {
                	///////////////////////////////////////////////////////
                	// Creation is not allowed before WK 40, 2011 due to system logic change.
                	with(formObj){
	                	if(f_chkprd[0].checked){
	                		if (ComParseInt(f_year.value) < 2011 || (ComParseInt(f_year.value) == 2011 && ComParseInt(f_fm_wk.value) < 40)){
		        				ComShowCodeMessage("MAS10061");
		        			}
	                	} else {
	                		if (ComParseInt(f_year.value) < 2011 || (ComParseInt(f_year.value) == 2011 && ComParseInt(f_fm_mon.value) < 10)){
		        				ComShowCodeMessage("MAS10061");
		        			}
	                	}
                	}
                	///////////////////////////////////////////////////////
                	
                    if (ComShowConfirm(ComGetMsg('MAS10020')) == true) { 
                        ComOpenWait(true);
                        formObj.f_cmd.value = MULTI02;
                        sheetObj.DoAllSave("ESM_MAS_0110GS2.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
                        ComOpenWait(false);
                        var err_cd = sheetObj.EtcData("err_cd");
                        var err_msg = sheetObj.EtcData("err_msg");
                        if (err_cd == "00000") {
                            ComShowMessage(ComGetMsg('MAS10018','CREATION')); 
                        } else {
                            ComShowMessage(err_cd+"\n"+err_msg);
                        }
                        sheetObj.EtcData("err_cd") = "";
                        sheetObj.EtcData("err_msg") = "";
                        
                        //재조회
                        ComOpenWait(true);
                        formObj.f_cmd.value = SEARCHLIST04;
                        sheetObj.DoSearch4Post("ESM_MAS_0110GS2.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8')); 
                        ComOpenWait(false);
                    }
                } else {
                    ComShowMessage(ComGetMsg('MAS10017'));
                }
                break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj){
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
    				return false;
    			}
    			if(!ComIsWeek(f_to_wk)) {
    				// [MAS1009] = Week 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Week','WW');
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
					//        			    ComShowCodeMessage("COM12138", "month", "week");
					return false;
				}
    			if(!ComIsMonth(f_fm_mon)){
    				// [MAS1009] = Month 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Month','MM');
    				return false;
    			}
    			if(!ComIsMonth(f_to_mon)) {
    				// [MAS1009] = Month 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Month','MM');
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
     * 화면 조회값에 대한 유효성검증 프로세스 처리
     */
    function validateCond(formObj) {
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
    				return false;
    			}
    			if(!ComIsWeek(f_to_wk)) {
    				// [MAS1009] = Week 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Week','WW');
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
					//        			    ComShowCodeMessage("COM12138", "month", "week");
					return false;
				}
    			if(!ComIsMonth(f_fm_mon)){
    				// [MAS1009] = Month 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Month','MM');
    				return false;
    			}
    			if(!ComIsMonth(f_to_mon)) {
    				// [MAS1009] = Month 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Month','MM');
    				return false;
    			}
            }
            // Vessel Check... 
            if (ComTrim(f_vessel.value) != "" && ComTrim(f_vessel.value).length != 4){
            	ComShowMessage(ComGetMsg('COM12174','VVD First Element','4'));
            	f_vessel.focus();
            	return false;
            }
            // Voayage Check...
            if (ComTrim(f_voyage.value) != "" && ComTrim(f_voyage.value).length != 4){
            	ComShowMessage(ComGetMsg('COM12174','VVD Second Element','4'));
            	f_voyage.focus();
            	return false;
            }
            // Direction Check...
            // msg1 + '과 ' + msg2 + '의 3번째 인자값이 같지 않습니다.';
            if (ComTrim(cobDir.value) != ComTrim(f_dir.value) && ComTrim(cobDir.value) != "" && ComTrim(f_dir.value) != ""){
            	ComShowMessage(ComGetMsg('MAS10016','DIR','VVD'));
            	f_dir.focus();
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
    				return false;
    			}
    			if(!ComIsWeek(f_to_wk)) {
    				// [MAS1009] = Week 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Week','WW');
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
					//        			    ComShowCodeMessage("COM12138", "month", "week");
					return false;
				}
    			if(!ComIsMonth(f_fm_mon)){
    				// [MAS1009] = Month 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Month','MM');
    				return false;
    			}
    			if(!ComIsMonth(f_to_mon)) {
    				// [MAS1009] = Month 값을 확인하십시오.
    				ComShowCodeMessage('MAS10009','Month','MM');
    				return false;
    			}
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
     * @author 박찬민
     * @version 2013.06.25
     */     
    function getBackEndJobStatus() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	if(tab_selno == 1){
    		sheetObj = sheetObjects[1];
    	}
    	
    	ComOpenWait(true);
    	formObj.f_cmd.value = SEARCH11;
    	var sXml = sheetObj.GetSearchXml("ESM_MAS_0110GS.do", masFormQueryString(formObj));
    	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
    	
    	if (jobState == "3") {
    		getBackEndJobSearch();
    		clearInterval(backEndJobTimer);
    	} else if (jobState == "4") {
    		ComShowCodeMessage("MAS00001");
    		ComOpenWait(false);
    		clearInterval(backEndJobTimer);
    	} else if (jobState == "5") {
    		ComShowCodeMessage("MAS00002");
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
     * @author 박찬민
     * @version 2013.06.25
     */       
    function getBackEndJobSearch() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	if(tab_selno == 1){
    		sheetObj = sheetObjects[1];
    	}
    	formObj.f_cmd.value = SEARCH12;    	
    	var sXml = sheetObj.GetSearchXml("ESM_MAS_0110GS.do", masFormQueryString(formObj));
    	var err_cd = ComGetEtcData(sXml, "err_cd");
    	var err_msg = ComGetEtcData(sXml, "err_msg");

    	ComOpenWait(false);
		
		if (err_cd == "00000") {
          ComShowMessage(ComGetMsg('MAS10018','CREATION')); 
      } else {
          ComShowMessage("["+err_cd+"]:"+err_msg);
      }
      //재조회
      formObj.f_cmd.value = SEARCHLIST02;
      sheetObj.DoSearch4Post("ESM_MAS_0110GS.do", masFormQueryString(formObj,'param1|param2|param3|param4|param5|param6|param7|param8'));
      if (formObj.f_fm_wk.value != formObj.f_to_wk.value){
    	  var strType = "1";
    	  var strYear     = formObj.f_year.value;
          var strFmMonth   = formObj.f_fm_mon.value;
          var strToMonth   = formObj.f_to_mon.value;     
          var strFmWeek   = formObj.f_fm_wk.value;
          var strToWeek   = formObj.f_to_wk.value;     
          var strChkPrd   = "";                                   
          if(formObj.f_chkprd[0].checked){
            strChkPrd   = "W";  // Week                  
          } else {
            strChkPrd   = "M";  // Month                  
          }
          var strTrade    = (formObj.f_cobtrade.Code=="All")?"":formObj.f_cobtrade.Code ;
          var strLane     = (formObj.f_coblane.Code=="All")?"":formObj.f_coblane.Code ;
          var strVessel   = formObj.f_vessel.value;
          var strVoyage   = formObj.f_voyage.value;
          var strDir      = (formObj.cobDir.Code=="All")?"":formObj.cobDir.Code ;
          if (strDir == "") {
            strDir = formObj.f_dir.value;
          }
          strUrl = "?f_stryear="+strYear;
          strUrl += "&f_strfmmonth="+strFmMonth;
          strUrl += "&f_strtomonth="+strToMonth;                    
          strUrl += "&f_strfmweek="+strFmWeek;
          strUrl += "&f_strtoweek="+strToWeek;                    
          strUrl += "&f_strchkprd="+strChkPrd;    // W:Week, M: Month                
          strUrl += "&f_strtrade="+strTrade;
          strUrl += "&f_strlane="+strLane;
          strUrl += "&f_strvessel="+strVessel;
          strUrl += "&f_strvoyage="+strVoyage;
          strUrl += "&f_strdir="+strDir;
          strUrl += "&f_strtype="+strType;
          strUrl += "&f_strprcnm=MAS_CREATE_NTCOST_PRC";
          
          ComOpenWindow2("ESM_MAS_0114.do" + strUrl,'', "width=900,height=360,menubar=0,status=0,scrollbars=0,resizable=1"); 
        } 
		
	}