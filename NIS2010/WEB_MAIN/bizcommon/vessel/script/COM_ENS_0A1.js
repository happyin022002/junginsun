/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_0A1.js
*@FileTitle : Vessel조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-02 sangyool pak
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
var mainPage;
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
               case "btn_Close":
      	            self.close();
          	   break;
          	   case "btn_OK":
                    comPopupOK();
          	   break;
          	   
          	 case "btn2_Down_Excel":
          		if(mainPage == undefined){                    	
    	    		sheetObject.SpeedDown2Excel(false,false,true,"","",false,false,"",false,"0|1");
    	    	} else {
    	    		sheetObject.SpeedDown2Excel(false,false,true,"","",false,false,"",false,"");
                }
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
     function loadPage(mainpage) {
    	 mainPage = mainpage;
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        
        var formObject = document.form;
        if(!(ComIsNull(formObject.vsl_eng_nm) && ComIsNull(formObject.vsl_cd) && ComIsNull(formObject.car_cd) && ComIsNull(formObject.call_sgn_no) && ComIsNull(formObject.lloyd_no))) {
	        var sXml = document.form.sXml.value;
	        var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
	        if(State == "S"){
	        	sheetObjects[0].Redraw = false;         
	        	sheetObjects[0].WaitImageVisible = false;     
	        	sheetObjects[0].LoadSearchXml(sXml);   
	        	sheetObjects[0].Redraw = true;   
	        }
        }
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
   	    switch(obj.name) {
   	        case "vsl_eng_nm":
   	        	ComKeyOnlyAlphabet('upper','32');
   	            break;
   	            
   	        case "vsl_cd":
	        	ComKeyOnlyAlphabet('upper');
	            break;
	            
   	        case "car_cd":
	        	ComKeyOnlyAlphabet('upper');
	            break;
	            
   	        case "call_sgn_no":
   	        	ComKeyOnlyAlphabet('uppernum','46');
   	        	break;
   	        	
   	        case "lloyd_no":
	        	ComKeyOnlyAlphabet('uppernum','46');
	        	break;
   	    }
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
                    style.height = 220;
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

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    var HeadTitle;
                    if(mainPage == undefined){
                    	HeadTitle = "Rdo.|Chk.|Seq.|Vessel Code|Vessel Name|Carrier|Net Ton|Rgst_Port_Code|Call_Sgn_No|LLOYD_NO|VSL_LNCH_DT" ;
                    }else{
                    	HeadTitle = "Seq.|Vessel Code|Vessel Name|Carrier|Net Ton|Rgst_Port_Code|Call_Sgn_No|LLOYD_NO|VSL_LNCH_DT" ;
                    }

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
            
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    if(mainPage == undefined){
                    	InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false,    "radio",       false,          "",       dfNone,	    0,     true,       true);
                    	InitDataProperty(0, cnt++ , dtCheckBox,  50,    daCenter,  false,    "checkbox",       false,          "",       dfNone,   	0,     true,       true);
                    }
                    InitDataProperty(0, cnt++ , dtSeq,       50,    daCenter,  false,    "seq",            false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "vsl_cd",            false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     240,    daLeft,  false,    	"vsl_eng_nm",            false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "crr_cd",            false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,    "vsl_nrt",            false,          "",       dfInteger, 	0,     false,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,      0,    daCenter,  false,    "rgst_port_cd",            false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      0,    daCenter,  false,    	"call_sgn_no",            false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      0,    daCenter,  false,    "lloyd_no",            false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      0,    daCenter,  false,    "vsl_lnch_dt",            false,          "",       dfInteger, 	0,     false,       true);
                    //vsl_cd, vsl_eng_nm, car_cd, vsl_nrt
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
               }
                break;
        }
    }

//    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
//       // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
//       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
//    }   



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
               
                formObj.f_cmd.value = SEARCH;                
                selectVal = FormQueryString(formObj);
                sheetObj.DoSearch4Post("COM_ENS_0A1GS.do", selectVal);              
               
           break;
           case IBSEARCHAPPEND:  // 페이징 조회
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("COM_ENS_0A1GS.do", selectVal, "iPage=" + PageNo, true);
           break;

        }
    }

    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    }  

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//      	      if(formObj.vsl_cd.value=="" && formObj.vsl_eng_nm.value=="" && formObj.car_cd.value=="") {
//      	        ComShowMessage("You must input Vessel code or Vessel Name or Carrier");
//      	        ComSetFocus(formObj.vsl_cd);
//      	        return false;
//      	      }
//        }

        return true;
    }