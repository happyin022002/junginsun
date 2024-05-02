/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_061.js
*@FileTitle : Node 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-17
*@LastModifier : Hyung Choon
*@LastVersion : 1.0
* 2006-08-17 Hyung Choon
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 공통전역변수 */
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
var mainPage;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

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
        /***********************************************************************************************************
            이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
            공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.        
         **********************************************************************************************************/
        /*
           이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
           메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
           (순서상도 form[1]이 되겠죠?) 
           그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
            document.form.f_cmd.value = INSERT;   이런식의 코딩은 지양해주십시오.
        */
        switch(srcName) {
            case "btn_Retrieve":
                // 하단 그리드 Display 항목이, Yard/Zone 구분에 따라 틀리므로, loadPage() 를 호출한다.	\
                sheetObject.RemoveAll();
//                loadPage();
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;

    	    case "btn_New":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;

            case "btn_Close":
	            self.close();
    	        break;

    	    case "btn_OK":
                comPopupOK();
    	        break;
    	        
    	    case "btn2_Down_Excel":    	    	
    	    	if(mainPage == undefined){                    	
    	    		sheetObject.SpeedDown2Excel(false,false,true,"","",false,false,"",false,"0|1|12|13");
    	    	} else {
    	    		sheetObject.SpeedDown2Excel(false,false,true,"","",false,false,"",false,"10|11");
                }
    	        break;
        } // end switch
    }catch(e) {            
        /*
        자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
        물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
        */
        if( e == "[object Error]") {
        	ComShowMessage(OBJECT_ERROR);
        } else {
        	ComShowMessage(e);
        }
    }
}

    /**
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
        initControl();
    }
    
    /**
     * Sheet 기본 설정 및 초기화 
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage(mainpage) {
    	 mainPage = mainpage;
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // 초기화면에서 조회내용을 보기 위한 소스 추후 삭제
//        var sheetObject = sheetObjects[0];
//        var formObject = document.form;        
//      	doActionIBSheet(sheetObject,formObject,IBSEARCH);
      	
    }

     function initControl() {
     	var formObject = document.form;
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     }

     //업무 자바스크립트 OnKeyPress 이벤트 처리
     function keypressFormat() {
     	obj = event.srcElement;
   	    if(obj.dataformat == null) return;
   	    window.defaultStatus = obj.dataformat;
   	    switch(obj.dataformat) {
   	        case "engup":
   	        	ComKeyOnlyAlphabet('uppernum','32');
   	            break;
   	    }
     }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        sheetObj.UseUtf8 = true;
        var cnt = 0;
        
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 5000);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    
                    var HeadTitle = "";
                    if(document.form.modeVal.value == "yard") {
                        if(mainPage == undefined){
                        	HeadTitle = "||Seq.|Node Code|Node Name|Ctrl Office|MAT|CY|CFS|R/R|PY|Type|vndr_cnt_cd|loc_cd|Customs No";
                        }else{
                        	HeadTitle = "SEQ|Node Code|Node Name|Ctrl Office|MAT|CY|CFS|R/R|PY|TYPE|vndr_cnt_cd|loc_cd|Customs No";
                        }
                    } else {;
                        if(mainPage == undefined){
                        	HeadTitle = "||SEQ|Node Code|Node Name|Ctrl Office|Postal Code|District|Street|Address|vndr_cnt_cd|loc_cd";
                        }else{
                        	HeadTitle = "SEQ|Node Code|Node Name|Ctrl Office|Postal Code|District|Street|Address|vndr_cnt_cd|loc_cd";
                        }
                    }

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
     
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    if(mainPage == undefined){
                    	InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false,    "radio",        false,          "",       dfNone,	    0,     true,       true);
                    	InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "checkbox",        false,          "",       dfNone,   	0,     true,       true);
                    }
                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);
                    
                    if(document.form.modeVal.value == "yard") {
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "yd_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      200,    daLeft,  false,    "yd_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        
                        InitDataProperty(0, cnt++ , dtData,     40,    daCenter,    false,    "yd_fcty_tp_mrn_tml_flg",        false,          "",       dfNone,       0,     false,       true);                        
                        InitDataProperty(0, cnt++ , dtData,     40,    daCenter,  false,    "yd_fcty_tp_cy_flg",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,    "yd_fcty_tp_cfs_flg",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,    "yd_fcty_tp_rail_rmp_flg",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,    "yd_fcty_tp_psdo_yd_flg",        false,          "",       dfNone,       0,     false,       true);                        
                        InitDataProperty(0, cnt++ , dtData,     70,    daCenter,    false,    "yd_tp_cd",        false,          "",       dfNone,       0,     false,       true);
                        
                        ImageList(0) = "/hanjin/img/alps/ico_round.gif" ;
                        // Yard : Node Code, Node Name, Ctrl Office, MAT, CY, CFS, R/R, PY, Type
                    } else {
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "zn_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      120,    daLeft,  false,    "zn_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,    "zip_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  false,    "dstr_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     70,    daLeft,  false,    "strt_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     100,    daLeft,  false,    "address",        false,          "",       dfNone,       0,     false,       true);
                        // Zone : Node Code, Node Name, Postal Code, District, Street, Address
                    }
                    
                    // Hidden으로 Country코드, Location 코드를 세팅한다.
                    InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  false,   "cnt_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  false,   "loc_cd");
                    if(document.form.modeVal.value == "yard") {
                        InitDataProperty(0, cnt++ , dtData,     70,    daCenter,    false,    "yd_cstms_no",        false,          "",       dfNone,       0,     false,       true);
                    }
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
                    
                    ToolTipText(0,"yd_fcty_tp_mrn_tml_flg") = "Marine terminal";
                    ToolTipText(0,"yd_fcty_tp_cy_flg") = "Container yard";
                    ToolTipText(0,"yd_fcty_tp_cfs_flg") = "Container Freight Station";
                    ToolTipText(0,"yd_fcty_tp_rail_rmp_flg") = "Rail Ramp";
                    ToolTipText(0,"yd_fcty_tp_psdo_yd_flg") = "Paeudo";
                }
                
                break;           
        }
    }

    
    
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:      //조회
                	if(!validateForm(formObj,sAction))return;
                	
                	formObj.f_cmd.value = SEARCH;    
                    selectVal = FormQueryString(formObj);
                    sheetObj.DoSearch("COM_ENS_061GS.do", selectVal);
            
                    break;
           case IBSEARCHAPPEND:  // 페이징 조회            
                formObj.f_cmd.value = SEARCHLIST; 
                sheetObj.DoSearch4Post("COM_ENS_061GS.do", selectVal, "iPage=" + PageNo, true);
           break;
        }
    }
    
    function sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {        
       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj,sAction){
    	 with(formObj){
    		 if(formObj.node_nm.value.length == 1) {
               ComShowMessage("Node Name must be 2 characters");
               return false;
             }
          }
          return true;
    }
    