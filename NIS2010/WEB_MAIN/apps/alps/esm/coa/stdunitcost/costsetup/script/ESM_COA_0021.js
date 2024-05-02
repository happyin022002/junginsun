/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0021.js
*@FileTitle : Manual Cost Set up
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.14
*@LastModifier : 이석준
*@LastVersion : 1.0 
=========================================================
* History
* 2012.09.17 이석준 [CHM-201220161] 실시간 영업현황 관련 UI- Manual Cost Set Up 기능 신규 개발
* 2012.12.13 송호진 [CHM-201221879] [COA] Manual Cost Set up 화면 로직 수정
* 2013.01.14 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2013.02.19 서미진 [CHM-201323054] ESM_COA_0022 팝업 사이즈 조절
* 2014.06.19 최성민 [CHM-201430638] [COA] BU Other (계선/대선) 항목의 각 계정별 분리 반영 위한 CSR 
=========================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0110 : ESM_COA_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0021() {
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
//    this.validateSheet      = validateSheet      ;
//    this.validateCond       = validateCond       ;
//    this.chkValidSearch     = chkValidSearch     ;
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

var loadingMode = false;

var prevWeek = "";
var fYear = "";

// 각각의 메인 화면에서 각각의 팝업화면을 띄우기 위해 사용
var POPUP_OPEN_ID = parseInt(Math.random() * 100).toString(10);

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
  var sheetObject  = sheetObjects[0];
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
          
		case "btn_save":
			if (tab_selno == 0) { //첫번째 탭이면				
					doActionIBSheet(sheetObject,formObject,IBSAVE);
			} else {  					
					doActionIBSheet2(sheetObject2,formObject,IBSAVE);
			}
		 break;
		 
      case "btn_Creation":
          if (tab_selno == 0) { //첫번째 탭이면
            doActionIBSheet(sheetObject,formObject,IBCREATE);          
          }       
          break;
          
		case "btn_down_excel":
			 if (tab_selno == 0) { //첫번째 탭이면
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				} else {
					doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
				}
		break;          

		case "btn_Month_copy":		//팝업창(Month Copy)		
  	       var display = "0,1";
  	     if (tab_selno == 0) { //첫번째 탭이면
  	       ComOpenPopup("ESM_COA_0173.do?classId=ESM_COA_0021&prev_week="+prevWeek, 250, 200, "AverageUcCopy", display, true, false);
  	     }
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

    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
    tab_selno = 0;
	loadingMode = false;
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
          InitColumnInfo(16, 0, 0, true);
          // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
          InitHeadMode(true, true, false, true, false, false);
          
          var HeadTitle = "||Items|TPS|AES|TAS|IAS|EMS|COM|TTL";
          
          //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle, true);

          //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
          //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
          //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
          //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
          var cnt = 0;
		  InitDataProperty(0, cnt++, dtHiddenStatus,    40,     daCenter, false, "ibflag");
		  InitDataProperty(0, cnt++, dtHidden,         150,     daCenter, false, "itm_cd", false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,           150,     daCenter, false, "itm_nm", false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum,        100,     daRight,    false, "tps_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtAutoSum,        100,     daRight,    false, "aes_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtAutoSum,        100,     daRight,    false, "tas_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtAutoSum,        100,     daRight,    false, "ias_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtAutoSum,        100,     daRight,    false, "ems_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtPopup,        100,     daRight,    false, "com_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtAutoSum,        100,     daRight,    false, "ttl_amt", false, "|tps_amt|+|aes_amt|+|tas_amt|+|ias_amt|+|ems_amt|+|com_amt|", dfInteger,  0,  false,   false);
          InitDataProperty(0, cnt++, dtHidden,        100,     daRight,    false, "tps_old_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtHidden,        100,     daRight,    false, "aes_old_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtHidden,        100,     daRight,    false, "tas_old_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtHidden,        100,     daRight,    false, "ias_old_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtHidden,        100,     daRight,    false, "ems_old_amt", false, "", dfInteger,  0,  true,   true);
          InitDataProperty(0, cnt++, dtHidden,        100,     daRight,    false, "com_old_amt", false, "", dfInteger,  0,  true,   true);


          ShowButtonImage = 2;
          ImageList(0) = "img/btns_search_off.gif"; // btns_search_off.gif
          ImageList(1) = "img/btns_search.gif";
          

          HeadRowHeight = 10;
          CountPosition  = 0 ;
        }
        break;
  
      case 2:      //sheet2 init
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
            InitColumnInfo(6, 0, 0, true);
            // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
            InitHeadMode(true, true, false, true, false, false);
            
            var HeadTitle = "||Items|Amount|Amount";
            
            //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
            //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
            //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
            //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
            var cnt = 0;
  		    InitDataProperty(0, cnt++, dtHiddenStatus,   40,      daCenter,   false, "ibflag");
  		    InitDataProperty(0, cnt++, dtHidden,          150,     daCenter,   false, "itm_cd",  false, "", dfNone,     0,  false, false);
            InitDataProperty(0, cnt++, dtData,           150,     daCenter,   false, "itm_nm",  false, "", dfNone,     0,  false, false);
            InitDataProperty(0, cnt++, dtPopup,          700,     daRight,    false, "pop_mty", false, "", dfNone,  0,  true,   true);
            InitDataProperty(0, cnt++, dtAutoSum,        100,     daRight,    false, "com_amt", false, "", dfInteger,  0,  true,   true, 12);
            InitDataProperty(0, cnt++, dtHidden,        100,     daRight,    false, "com_old_amt", false, "", dfInteger,  0,  true,   true);

            ShowButtonImage = 2;
            ImageList(0) = "img/btns_search_off.gif"; // btns_search_off.gif
            ImageList(1) = "img/btns_search.gif";
            
            
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
          InsertTab(cnt++ , "Other Expense", -1);
          InsertTab(cnt++ , "MT/ABC", -1);
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
 * 입력창에 금월 셋팅
 * 사용 : setYrMon()
 *
 * @param NONE
 * @return NONE
 */        
function setYrMon(){
	var formObj = document.form;
	with(formObj){
        var nowYear = ComGetNowInfo("yy");
        var nowMon  = ComGetNowInfo("mm"); 
        if ( nowMon.length == 1 ) nowMon = "0" + nowMon; // 1월 -> 01월로 변환
		var nowYrMon = nowYear + nowMon;
        f_yearweek.value = nowYrMon;	
		//isValidYYYYMM(f_yearweek,true,'-',true);
        if(!ComAddSeparator(f_yearweek)) return false;
		f_yearweek.select();
		// 기간 표시 
        setPeriod(f_yearweek);
	}

    fnYearWeekSet(document.getElementById("f_yearweek"));
}	

function fnYearWeekSet(obj){
    if ( document.form.f_yrtype[0].checked ) {
        obj.value = ComGetMaskedValue(obj.value,"ym");
    } else {
        obj.value = ComGetMaskedValue(obj.value,"yw");
    }

    setPeriod(obj);

}
/**
 * 입력창에 지정한 주 셋팅
 * 사용 : setYrWk('2013','25')
 *
 * @param Previous Week's year
 * @param Previous Week
 * @return NONE
 */    
function setYrWk(fYear, prevWeek){
	var formObj = document.form;
	with(formObj){
		var nowYear = fYear;
        f_yearweek.value = nowYear+prevWeek;	
        //if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
        //if(!ComAddSeparator(f_yearweek)) return false;
        if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
		f_yearweek.select();
		// 기간 표시     		
        setPeriod(f_yearweek);    		
	}

    fnYearWeekSet(document.getElementById("f_yearweek"));
}
    
/**
 * month, week가 변경되었을때 Period를 변경한다.
 */
function setPeriod(obj){		
    ComCoaSetPeriod2(obj);
}  
    
function sheet1_OnChange(sheetObj,Row,Col,Value) {
}

function sheet1_OnSearchEnd(sheetObj, errMsg){

    sheetObj.SumText(0,"itm_nm") = "TOTAL";      
    
    // 각 컬럼별로 editable 조절
    // Trade중 Vessel charter와 layup은 COM Trade에만 editable 가능
    for (var i=1; i<=sheetObj.RowCount; i++) {

    	if (sheetObj.CellValue(i,"itm_cd") == "CNTMR" || sheetObj.CellValue(i,"itm_cd") == "CNTTS"){
    		sheetObj.CellEditable(i,"tps_amt") = true;
    		sheetObj.CellEditable(i,"aes_amt") = true;
    		sheetObj.CellEditable(i,"tas_amt") = true;
    		sheetObj.CellEditable(i,"ias_amt") = true;
    		sheetObj.CellEditable(i,"ems_amt") = true;  
    		sheetObj.CellEditable(i,"com_amt") = false;
    	} else {
    		sheetObj.CellEditable(i,"tps_amt") = false;
    		sheetObj.CellEditable(i,"aes_amt") = false;
    		sheetObj.CellEditable(i,"tas_amt") = false;
    		sheetObj.CellEditable(i,"ias_amt") = false;
    		sheetObj.CellEditable(i,"ems_amt") = false;  
    		sheetObj.CellEditable(i,"com_amt") = true;
    	}
    	
    	
    	if(sheetObj.CellValue(i,"itm_cd") != "CNTLY" && sheetObj.CellValue(i,"itm_cd") != "CDMCO"){
    		sheetObj.PopupButtonImage(i, "com_amt") = 0;   
    	}
    }

    
    
}

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj, nItem) {
    	var formObj = document.form;
      var objs = document.all.item("tabLayer");
      
      objs[nItem].style.display = "inline";
      objs[beforetab].style.display = "none";
      
      //--------------- 요기가 중요 --------------------------------//
      objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
      //----------------------------------------------------------//
      beforetab = nItem;
      
      tab_selno = nItem;
      
      if (tab_selno == 0) { //YYYY-MM을 선택하지 못하게..
    	  formObj.f_yrtype[0].disabled = true;
    	  formObj.f_yrtype[1].disabled = false
    	  formObj.f_yrtype[0].checked = false;
    	  formObj.f_yrtype[1].checked = true;   
    	  ComBtnEnable("btn_Creation");
    	  ComBtnEnable("btn_Month_copy");
    	  setYrWk(fYear,prevWeek);


      } else {//MT ABC
    	  formObj.f_yrtype[0].disabled = false;
    	  formObj.f_yrtype[1].disabled = true;
    	  formObj.f_yrtype[0].checked = true;
    	  formObj.f_yrtype[1].checked = false;
    	  ComBtnDisable("btn_Creation");
    	  ComBtnDisable("btn_Month_copy"); 
    	  setYrMon();
 
      }
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
				
				var sXml = sheetObj.GetSearchXml("ESM_COA_0021GS.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				
				if (0 < arrXml.length) {
				   prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
				   fYear = ComGetEtcData(arrXml[0], "fYear"); 
				   formObj.f_yrtype[1].onclick = function(){setYrWk(fYear,prevWeek)};
				   setYrWk(fYear,prevWeek);
				}
				
//				setYrMon();  // 월/주 입력 창에 금월 셋팅

				ComOpenWait(false);
				break;
            
            case IBSEARCH:      //결과조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                ComOpenWait(true);
                
                if(formObj.f_yrtype[0].checked) {
                	ComAddSeparator(formObj.f_yearweek, "ym");
                } else {
                	ComAddSeparator(formObj.f_yearweek, "yw");
                }
                
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch("ESM_COA_0021GS.do", coaFormQueryString(formObj));
                
                
                //Deferred Expense를 위한 값 추출
                ComEtcDataToForm(formObj,sheetObj);
                
                ComOpenWait(false);
                break;
            
            case IBCREATE:      //생성
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
				
            	if (!ComShowCodeConfirm("COA10020")) {
            		return false;
            	}
            	
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI03;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0021GS.do", coaFormQueryString(formObj));
				sheetObj.LoadSaveXml(sXml);

				ComOpenWait(false);
				
            break;
  			
            case IBSAVE:	//저장
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = MULTI01;
  					sheetObj.DoSave("ESM_COA_0021GS.do", coaFormQueryString(formObj));
  					ComOpenWait(false);
  				}
  				break;
  				
  			case IBDOWNEXCEL:	//엑셀 다운로드
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
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        // 업무처리중 버튼사용 금지 처리
		sheetObj.WaitImageVisible = false;
        
        switch(sAction) {
            case IBSEARCH:      //결과조회
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                ComOpenWait(true);

                if(formObj.f_yrtype[0].checked) {
                	ComAddSeparator(formObj.f_yearweek, "ym");
                } else {
                	ComAddSeparator(formObj.f_yearweek, "yw");
                }
                
                formObj.f_cmd.value = SEARCHLIST02;
                sheetObj.DoSearch4Post("ESM_COA_0021GS.do",coaFormQueryString(formObj)); 
                
                sheetObj.DataLinkMouse("pop_mty") = true;
                sheetObj.PopupButtonImage(2, "pop_mty") = 0;                
                ComOpenWait(false);
                break;
                
            case IBSAVE:	//저장
  				if(validateForm(sheetObj,formObj,sAction)){
  					formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,"ym");
  			
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = MULTI02;
  					sheetObj.DoSave("ESM_COA_0021GS.do", coaFormQueryString(formObj));
  					ComOpenWait(false);
  				}
  				break;
  				
  			case IBDOWNEXCEL:	//엑셀 다운로드
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
        }
    }

    /**
     * MT/ABC TAB Retrieve 후 호출
     */    
    function sheet2_OnSearchEnd(sheetObj, errMsg){
        // MTY Reposition Cost 는 수정불가 
        for (var i=1; i<=sheetObj.RowCount; i++) {
        	if (sheetObj.CellValue(i,"itm_cd") == "MTYTT"){
        		sheetObj.CellEditable(i,"com_amt") = false;
        	}
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//공통 체크	       
    	with(formObj){        	
            if(f_yrtype[0].checked) {
            	if(!ComIsDate(f_yearweek, "ym")){
            		ComShowMessage(ComGetMsg("COM12114", "Month"));
    				f_yearweek.focus();
    				return false;
            	}
            } else if(f_yrtype[1].checked) {
            	if(!ComIsDate(f_yearweek, "yw")){
            		ComShowMessage(ComGetMsg("COM12114", "Week"));
    				f_yearweek.focus();
    				return false;
            	}
            }
        } 
        return true;
    }
    
	/**
	* 저장메세지 지정
	*/
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		if(errMsg == ""){
			ComShowMessage(ComGetMsg("COA00004","Data"));
			
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
	}

    /**
    * sheet에서 팝업 버튼을 클릭시 발생한다.<br>
    * 팝업 호출 후 리턴 값을 sheet에 세팅한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet1_OnPopupClick(sheetObj, Row, Col) 
    * </pre>
    * @param {ibsheet} sheetObj    필수,IBSheet Object
    * @param {int}  Row        
    * @param {int}  Col    
    * @return 없음
    * @version 2012.12.06
    */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
   	 
       var colName = sheetObj.ColSaveName(Col);
       var formObj = document.form;
       ComClearSeparator(formObj.f_yearweek, 'ym','-');
       var costYrmon = formObj.f_yearweek.value;
       var targetFun = "";
       
       if (colName == "com_amt" && sheetObj.CellValue(Row,"itm_cd") == "CNTLY") {
    	   
           var param = "?cost_yrmon="+costYrmon+"&rlane_cd="+sheetObj.CellValue(Row,"itm_cd");
           ComOpenWindowCenter('/hanjin/ESM_COA_0024.do' + param, "ESM_COA_0024_"+POPUP_OPEN_ID, 930, 570, false );    // radio PopUp

       } else if (colName == "com_amt" && sheetObj.CellValue(Row,"itm_cd") == "CDMCO") {

           var param = "?cost_yrmon="+costYrmon+"&rlane_cd="+sheetObj.CellValue(Row,"itm_cd");
           ComOpenWindowCenter('/hanjin/ESM_COA_0024.do' + param, "ESM_COA_0024_"+POPUP_OPEN_ID, 930, 570, false );    // radio PopUp

       }
   }
   
    /** 
    * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
    * @param {int} x 필수, X 좌표
    * @param {int} y 필수, Y 좌표
    * @return 없음
    */   
 	function sheet1_OnMouseMove(sheetObj,button,shift,x,y){
 		with(sheetObj){
 			var sValue = CellValue(MouseRow, "itm_cd");
 			//alert(sValue);
 			if(ColSaveName(MouseCol) == "com_amt" && (sValue == "CNTLY" || sValue == "CDMCO")) {
 				sheetObj.MousePointer = "Hand";
 			} else {
 				MousePointer = "Default";
 			} 	
 		}
 	}
    

    /**
    * sheet에서 팝업 버튼을 클릭시 발생한다.<br>
    * 팝업 호출 후 리턴 값을 sheet에 세팅한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet2_OnPopupClick(sheetObj, Row, Col) 
    * </pre>
    * @param {ibsheet} sheetObj    필수,IBSheet Object
    * @param {int}  Row        
    * @param {int}  Col    
    * @return 없음
    * @version 2012.12.06
    */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
   	 
       var colName = sheetObj.ColSaveName(Col);
       var formObj = document.form;
       ComClearSeparator(formObj.f_yearweek, 'ym','-');
       var costYrmon = formObj.f_yearweek.value;
       var targetFun = "";
       
       if (colName == "pop_mty" && sheetObj.CellValue(Row,"itm_cd") == "MTYTT") {
    	   
           var param = "?cost_yrmon="+costYrmon;
           ComOpenWindowCenter('/hanjin/ESM_COA_0022.do' + param, "ESM_COA_0022_"+POPUP_OPEN_ID, 930, 570, false );    // radio PopUp

       } else if (colName == "pop_mty" && sheetObj.CellValue(Row,"itm_cd") == "GENTT") {
    	  
    	   if(sheetObj.CellValue(Row,"com_amt") < 1 ) {
    		   ComShowCodeMessage("COA10015","General Expense");
    		   sheetObj.SelectCell(Row,"com_amt");
    		   return false;
    	   }
    	   
    	   var param = "?cost_yrmon="+ComGetMaskedValue(costYrmon,"ym");
           ComOpenWindowCenter('/hanjin/ESM_COA_0023.do' + param, "ESM_COA_0023_"+POPUP_OPEN_ID, 700, 345, false );    // radio PopUp
       }
   }
    
	/**
	* 팝업 close 할때 메인화면 retrieve
	*/    
   function getRetrieve() {
		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
   }
       
 