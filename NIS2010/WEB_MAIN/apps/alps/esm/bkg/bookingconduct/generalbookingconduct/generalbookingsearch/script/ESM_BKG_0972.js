/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0972.js
*@FileTitle : Service Mode And Route
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.12 KimByungKyu
* 1.0 Creation
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
     * @class esm_bkg_0972 : esm_bkg_0972 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0972() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {                   
	          case "btn_Close":
	        	  window.close();
              break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
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
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);                 
        }
    }        

  	 function sheet1_OnLoadFinish(sheetObj) {   
 		sheetObj.WaitImageVisible = false;   
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);   
 		sheetObj.WaitImageVisible = true;   
 	 }             
  	 
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|22";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);                
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	  daCenter,		true,	 "ibflag");
                    InitDataProperty(0, cnt++ , dtRadioCheck,	 35,     daCenter,    	false,     "detailChk");
               }
                break;

        }
    }        
        
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          case IBSEARCH:      //조회
        	  formObj.f_cmd.value = SEARCH;		

        	  var sXml = sheetObj.GetSearchXml("ESM_BKG_0972GS.do", FormQueryString(formObj));
        	  sheetObj.LoadSearchXml(sXml);
	           formObj.orgScontiCd.value = ComGetEtcData(sXml,"org_sconti_cd");
 		       formObj.destScontiCd.value = ComGetEtcData(sXml,"dest_sconti_cd");
 		       formObj.orgTrnsSvcModCd.value = ComGetEtcData(sXml,"org_trns_svc_mod_cd");      
 		       formObj.destTrnsSvcModCd.value = ComGetEtcData(sXml,"dest_trns_svc_mod_cd");
 		       formObj.org_trns_svc_mod_nm.value = ComGetEtcData(sXml,"org_trns_svc_mod_nm");      
 		       formObj.dest_trns_svc_mod_nm.value = ComGetEtcData(sXml,"dest_trns_svc_mod_nm");
 		       formObj.blckStwgCd.value = ComGetEtcData(sXml,"blck_stwg_cd");
 		       formObj.estmIbMtyRtnYdCd.value = ComGetEtcData(sXml,"estm_ib_mty_rtn_yd_cd");
 		            	 		       
          break;
        }
    }        
    
	function msgmove(type){
		var stop = 100;
		var sleft = 0;
		
		if(type == "org"){
			sleft = 400;
		} else {
			sleft = 550;
		}
		msg.style.left=sleft;
		msg.style.top=stop;
	}

	function msgset(strmsg){
		text ='<table  width=150  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strmsg + '</td></tr></table>';
		msg.innerHTML=text;
	}

	function msghide(){
		msg.innerHTML='';
	}	
        
	/* 개발자 작업  끝 */