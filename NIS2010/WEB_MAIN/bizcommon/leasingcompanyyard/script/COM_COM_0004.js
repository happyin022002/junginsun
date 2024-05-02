/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_COM_0004.js
*@FileTitle  :  Leasing Company yard
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 공통전역변수 */
function COM_COM_0004(){
	this.tab1_OnChange    = tab1_OnChange;
	this.ChangeTab        = ChangeTab;
	this.setSheetObject   = setSheetObject;
	this.loadPage         = loadPage;
	this.initControl      = initControl;
	this.keypressFormat   = keypressFormat;
	this.initSheet        = initSheet; 
	this.processButtonClick = processButtonClick;
	this.doActionIBSheet    = doActionIBSheet;
	this.sheet_OnScrollNext = sheet_OnScrollNext;
	this.validateForm       = validateForm;

} 

var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
var mainPage;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
    /**
     * tab1의 onChange이벤트핸들러
     * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
     */
    function tab1_OnChange(nItem){
        ChangeTab(document.all.tab1,nItem);
    }
    /**
     * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
     * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
     */
    function ChangeTab(tabObj,nItem){
          tabObj.SetBackColor("#FFFFFF");
        //no support[check again]CLT tabObj.TabBackColor(nItem)="146,174,230";
        var objs=document.all.item("tabLayer");
        objs[beforetab].style.display="none";
        objs[nItem].style.display="Inline";
        //--------------- 요기가 중요 --------------------------//
        //objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        //ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
        objs[beforetab].style.zIndex=0;
        objs[nItem].style.zIndex=9;
        //------------------------------------------------------//
        beforetab=nItem;
    }
    /**
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화 
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage(mainpage) {
    	 mainPage=mainpage;
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        // 초기화면에서 조회내용을 보기 위한 소스 추후 삭제
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        initControl();
    }
     function initControl() {
       	var formObject=document.form;
           //Axon 이벤트 처리1. 이벤트catch(개발자변경)
           axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
           axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
       }
     //업무 자바스크립트 OnKeyPress 이벤트 처리
       function keypressFormat() {
       	obj=event.srcElement;
     	    if(obj.dataformat == null) return;
     	    window.defaultStatus=obj.dataformat;
     	    switch(ComGetEvent("name")) {
     	        case "lse_co_yd_cd":
     	        	ComKeyOnlyAlphabet('uppernum');
     	        	break;
     	       case "lse_co_yd_nm":
    	   //    	ComKeyOnlyAlphabet('upper'); 
    	        	break;
     	    }
       }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        //sheetObj.UseUtf8 = true;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
            	style.height = 220;
            	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
    	         InitRowInfo( 1, 1, 5, 100);	         
    	         InitColumnInfo(5, 0, 0, true);
    	         
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, false, false, false);
               
              var HeadTitle;
              if(mainPage == undefined){
              HeadTitle="||Seq.|Leasing Code|Description" ;
              }else{
              HeadTitle="|Seq.|Leasing Code|Description" ;
              }
              var mdmYN=document.form.mdm_yn.value;
              if(mdmYN.replace(/\s/g,"") != ""){
              HeadTitle += "|Status";
              }
              
              InitHeadRow(0, HeadTitle, true);
              
    		 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, cnt++ , dtCheckBox,       20,    daCenter,  true,      "radio", 				false,          "",         dfNone,      0,     true,        true);
             InitDataProperty(0, cnt++ , dtSeq,    		30,    daCenter,  true,      "seq", 				false,          "",         dfNone,      0,     true,        true);
 			 InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "lse_co_yd_cd",		false,          "",      	dfNone,      0,     false,       true);
 			 InitDataProperty(0, cnt++ , dtData,      	500,   daLeft,    false,     "lse_co_yd_nm",		false,          "",      	dfNone,      0,     false,       true);
 			 if(mdmYN.replace(/\s/g,"") != ""){
 			 InitDataProperty(0, cnt++ , dtData,          0,   daCenter,  false,     "delt_flg",		    false,          "",      	dfNone,      0,     false,       true);
 			 }
           }
           break;
        }
    }
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */    
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            //if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
                case "btn_DownExcel":
                	if(sheetObject.RowCount < 1){//no data
                		ComShowCodeMessage("COM132501");
                		}else{
                			//sheetObject.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObject),HiddenColumn:false,Merge:false,TreeLevel:false});
                			sheetObject.SpeedDown2Excel(1);
                		}

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
            } // end switch
        }catch(e) {            
            /*
            자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
            물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
            */
            if( e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
            	ComShowMessage(e.message);
            }
        }
    }
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj, formObj, sAction,  a,  PageNo) {
        //sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:        //조회
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=SEARCH;                
//                alert("IBSEARCH => "+IBSEARCH+" || SEARCH=>"+SEARCH+" || formObj.f_cmd.value =>"+formObj.f_cmd.value);
                //alert("123123123123123132123123123123");
                selectVal=FormQueryString(formObj);
//                alert(selectVal);
                 sheetObj.DoSearch("COM_COM_0004GS.do", selectVal );
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
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            /*if(formObj.cnt_cd.value == "") {
              showErrMessage("You must input Country code");
              setFocus(formObj.cnt_cd);
              return false;
            }
            if(formObj.cnt_cd.value.length < 2) {
              showErrMessage("Country code must be 2 characters");
              setFocus(formObj.cnt_cd);
              return false;
            }
            if(formObj.cnt_cd.value == "US" && formObj.loc_state.value == "") {
              showErrMessage("You must input State");
              setFocus(formObj.loc_state);
              return false;
            }*/     
        }
        return true;
    }
    /**
     * 조회결과가 오류가 발생했을 때 공통처리하는 함수
     * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
     */
//    function sheet_OnSearchEnd(sheetObj,errMsg){
//        if(errMsg!=null){
//            ComShowMessage(errMsg);
//        }
//    }
