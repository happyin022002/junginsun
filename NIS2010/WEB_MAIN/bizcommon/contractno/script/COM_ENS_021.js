﻿// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_Retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_New":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;

                case "btns_calendar1":
                	var cal = new ComCalendarFromTo();
                	cal.select(formObject.sdate,  formObject.edate,  'yyyy-MM-dd');
        	        break;

                case "btn_Close":
    	            self.close();
        	        break;

        	    case "btn_OK":
                    comPopupOK();
        	        break;
        	   
        	    case "btn2_Down_Excel":
        	    	sheetObject.Down2Excel(false,false,true,false,"","",false,false,"",false,"0|1");
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    function initControl() {
    	var formObject = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
        axon_event.addListenerFormat ('focus', 'obj_activate', formObject);
        axon_event.addListenerForm ('focusout', 'obj_deactivate', formObject);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }

    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function keypressFormat() {
    	obj = event.srcElement;
  	    if(obj.dataformat == null) return;
  	    window.defaultStatus = obj.dataformat;
  	    switch(obj.name) {
  	        case "cont_no":
  	        	ComKeyOnlyNumber(obj);
  	            break;
  	        case "cont_tp":
  	        	ComKeyOnlyAlphabet('upper');
  	            break;
  	        case "sdate":
  	        	ComKeyOnlyNumber(obj);
	            break;
  	        case "edate":
	        	ComKeyOnlyNumber(obj);
	            break;
  	        case "cust_nm":
	        	ComKeyOnlyAlphabet('upper');
	            break;
  	        case "ofc_cd":
	        	ComKeyOnlyAlphabet('upper');
	            break;
  	        case "ctrt_cust_sls_ofc_cd":
  	        	ComKeyOnlyAlphabet('upper');
            break;
	            
  	    }
    }

  //업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
    	obj = event.srcElement;
	  	//마스크 구분자 없애기
//    	if(obj.name == 'edate'){
//    		if(document.form.edate.value == ''){
//    			document.form.edate.value = getCurrDate('-');
//    		}
//    	}
    	ComClearSeparator (event.srcElement);
    }

    //업무 자바스크립트 Onblur 이벤트 처리
    function obj_deactivate(){
        //입력Validation 확인 및 마스킹 처리
        obj = event.srcElement;
	  	//마스크 구분자 없애기
    	if(obj.name != 'cont_no'){
    		ComChkObjValid(event.srcElement);
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 5000);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "||Contract No.|Customer Name|Effective Date|Expire Date|S Office|C Office" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [	ROW, COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, 	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,	30,    	daCenter,  false,    "radio",   			false,          "",     	dfNone,	    	0,     	true,       	true);
                    InitDataProperty(0, cnt++ , dtCheckBox,  	30,    	daCenter,  false,    "checkbox",   			false,          "",       	dfNone,   		0,     	true,       	true);
                    InitDataProperty(0, cnt++ , dtData,     	90,    	daCenter,  false,    "sc_no",        		false,          "",       	dfNone,   		0,     	false,       	true);
                    InitDataProperty(0, cnt++ , dtData,     	240,    daLeft  ,  false,    "cust_lgl_eng_nm", 	false,          "",       	dfNone,       	0,     	false,       	true);
                    InitDataProperty(0, cnt++ , dtData,     	90,    	daCenter,  false,    "ctrt_eff_dt",        	false,          "",       	dfDateYmd,    	0,     	false,       	true);
                    InitDataProperty(0, cnt++ , dtData,     	90,    	daCenter,  false,    "ctrt_exp_dt",			false,          "",       	dfDateYmd,    	0,     	false,       	true);
                    InitDataProperty(0, cnt++ , dtData,     	80,    	daCenter,  false,    "ofc_cd",        		false,          "",       	dfNone, 	    0,     	false,       	true);
                    InitDataProperty(0, cnt++ , dtData,     	60,    	daCenter,  false,    "ctrt_cust_sls_ofc_cd",false,          "",       	dfNone,      	0,     	false,       	true);
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
            	}
            break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value = SEARCH;
                selectVal = FormQueryString(formObj);
                sheetObj.DoSearch4Post("COM_ENS_021GS.do", selectVal);
           break;
           
           case IBSEARCHAPPEND:  // 페이징 조회
                formObj.f_cmd.value = SEARCH;    
                sheetObj.DoSearch4Post("COM_ENS_021GS.do", selectVal, "iPage=" + PageNo, true);  
           break;
        }
    }

    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    } 

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            // Contract No(3자리) or 고객이름(4자리이상) 필수 입력
//            if(formObj.cont_tp.value == "" && formObj.cust_nm.value == "") {
//              ComShowMessage("You must input Contract No or Customer Name");
//              setFocus(formObj.cont_tp);
//              return false;
//            } else {            
//                if(formObj.cont_tp.value != "") {
//                    if(formObj.cont_tp.value.length < 3) {
//                      ComShowMessage("Contract No must be 3 characters");
//                      setFocus(formObj.cont_tp);
//                      return false;
//                    }
//                } else {
//                    if(formObj.cust_nm.value.length < 4) {
//                      ComShowMessage("Customer name must be more than 4 characters");
//                      setFocus(formObj.cust_nm);
//                      return false;
//                    }
//                }
//            }
            
            // Period 유효성 체크
            if(formObj.sdate.value != "") {
                if(formObj.edate.value == "") {
                    ComShowMessage("You must input period(end date)");
                    setFocus(formObj.edate);
                    return false;
                }
            } else {
                if(formObj.edate.value != "") {
                    ComShowMessage("You must input period(start date)");
                    setFocus(formObj.sdate);
                    return false;
                }
            }
        }

        return true;
    }
     
     /**
      * 현재일자를 구함
      * str : YYYY-MM-DD형태의 일자를 리턴
      */
   	function getCurrDate(delimiter){
       var current_date = new Date();
       var year = current_date.getFullYear().toString();
       var month = current_date.getMonth() + 1;
       month = (month < 10 ? "0" : "") + month;
       var day = current_date.getDay();
       day = (day < 10 ? "0" : "") + day;
       if(delimiter == null) delimiter = "";
       return year + delimiter + month + delimiter + day;
   	}