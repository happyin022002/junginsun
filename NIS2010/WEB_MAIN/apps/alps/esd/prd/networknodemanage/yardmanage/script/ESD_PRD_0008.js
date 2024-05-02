/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0008.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.23 김귀진
* 1.0 Creation
=========================================================*/

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var validateData ="";
var retValidate = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var formObject = document.form;

         var dispaly ;
         var classId ;
         var func ;
         var param ;
         var chkStr ;
         
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            /****************************
             enterKey 처리
            *****************************/
            var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;
            //if(srcObj =='INPUT' && keyObj ==13) {
             //   srcName ='btn_retrieve';
            //}
           
            switch(srcName) {
 

        	    case "btn_close":
    	              window.close();
        	      break;
 

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('PRD90054'));
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
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_org_cd', 'i_dest_cd');
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
                    //전체 너비 설정
                    style.height = GetSheetHeight(11) ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1, 9, 100);

                   // MassOfSearch = 1;
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle   = "Node|Month|Average Dwell|Average Dwell|Average Dwell|Average Dwell|Average Dwell for Inland COP|Average Dwell for Inland COP|Average Dwell for Inland COP|Average Dwell for Inland COP|Minimum Dwell|Minimum Dwell|Minimum Dwell|Minimum Dwell" ;
                    var HeadTitle1  = "Node|Month|I/B|I/B|O/B|O/B|I/B|I/B|O/B|O/B|I/B|I/B|O/B|O/B" ;
                    var HeadTitle2 = "Node|Month|Dry|Reefer|Dry|Reefer|Dry|Reefer|Dry|Reefer|Dry|Reefer|Dry|Reefer" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);
//                    nod_cd his_month ib_dry_avg_dwll_hrs ib_rf_avg_dwll_hrs ob_dry_avg_dwll_hrs ob_rf_avg_dwll_hrs cop_ib_dry_avg_dwll_hrs
//                    cop_ib_rf_avg_dwll_hrs cop_ob_dry_avg_dwll_hrs cop_ob_rf_avg_dwll_hrs ib_dry_min_dwll_hrs ib_rf_min_dwll_hrs ob_dry_min_dwll_hrs ob_rf_min_dwll_hrs

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtHidden,        30,    daCenter,  false,    "",               false,          "",       dfNone,	    0,     false,       true);
//                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,    "ibflag",         false,          "",       dfNone,	    0,     true,       true);
//                    InitDataProperty(0, cnt++ , dtSeq,           30,    daCenter,  false,    "",               false,          "",       dfNone,   	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  true,    "nod_cd",       false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  true,    "his_month",      false,          "",       dfNone,        0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,    false,    "ib_dry_avg_dwll_hrs",      false,          "",       dfNone, 	    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "ib_rf_avg_dwll_hrs",   false,           "",       dfNone, 0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "ob_dry_avg_dwll_hrs",       false,          "",       dfNone, 0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "ob_rf_avg_dwll_hrs", false,          "",       dfNone, 	    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "cop_ib_dry_avg_dwll_hrs", false,          "",       dfNone,   	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "cop_ib_rf_avg_dwll_hrs",false,          "",       dfNone, 	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "cop_ob_dry_avg_dwll_hrs",       false,          "",       dfNone, 	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "cop_ob_rf_avg_dwll_hrs",    false,          "",       dfNone, 	    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "ib_dry_min_dwll_hrs",             false,          "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "ib_rf_min_dwll_hrs",             false,          "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "ob_dry_min_dwll_hrs",             false,          "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        60,    daCenter,  false,    "ob_rf_min_dwll_hrs",             false,          "",       dfNone,        0,     false,       false);
                    
 
					WaitImageVisible=false;
               }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
	    sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            
           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction));
           		ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
//                if(formObj.i_org_cd.value=="" && formObj.i_dest_cd.value=="" ) {
//                    return false;  
//                }
                sheetObj.DoSearch4Post("ESD_PRD_0008GS.do", PrdFQString(formObj));
                ComOpenWait(false);
                break;
           
        }
    }
     
  
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
 
    	
    }
 
    
     
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }