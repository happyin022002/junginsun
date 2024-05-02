/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0212.js
*@FileTitle : M&R Expense Plan Creation by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.20 정영훈
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends 
     * @class ees_mnr_0212 : ui_mnr_0212 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0212() {
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
    	var sheetObject1 = sheetObjects[0];
 		
    		    
         /*******************************************************/
         

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
					case "btn_OK":
						//comPopupOK();   
						self.close();
					break;
					
					case "btn_CLOSE":
						self.close();
					break;

				} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {     
				ComFuncErrMsg(e);          
			} else {      
				ComFuncErrMsg(e);    
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
        	 MnrWaitControl(true);
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    		MnrWaitControl(false);
        }


      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
    		var sheetID = sheetObj.id;
    				
            switch(sheetID) {
                case "sheet1":
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 112;
                        // 전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 10, 100);

    		            var HeadTitle1 = "|S|Office|Office Name|Office Location";
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        var prefix="sheet1_";
                        InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter, true,   prefix + "Status");
                      //InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter, true,   prefix + "Chk");
                        InitDataProperty(0, cnt++ , dtSeq,          30,     daLeft,   true,   prefix + "Seq");
                        InitDataProperty(0, cnt++ , dtData,         80,     daLeft,   false,  prefix + "ofc_cd",      false,  "",   dfNone,   0,  true,   true);
                        InitDataProperty(0, cnt++ , dtData,         220,    daLeft,   false,  prefix + "ofc_eng_nm",  false,  "",   dfNone,   0,  true,   true);
                        InitDataProperty(0, cnt++ , dtData,         40,     daLeft,   false,  prefix + "loc_cd",      false,  "",   dfNone,   0,  true,   true);			    	
    		

			    		CountPosition = 0;

    		  }
    	  break;

            }
        }

    	function sheet1_OnSearchEnd(sheetObj, errMsg) {
   		 	MnrWaitControl(false);
    	}

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
           
            switch(sAction) {
				case IBSEARCH:      //조회
					MnrWaitControl(true);
					if(validateForm(sheetObj,formObj,sAction)){
						ComShowCodeMessage("MNR00003");
						
					}else{
					   sheetObj.Redraw = false;    
	    	           formObj.f_cmd.value = SEARCH;
	        	       sheetObj.DoSearch("EES_MNR_0212GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	       	           sheetObj.Redraw = true;
					}
				break;
            }
        }



        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
				if(!ComIsNull(formObj.ofc_cd)){
					MnrWaitControl(false);
					return false;
				}
            }
           
            return true;
        }
            
       
            
        function sheet1_OnDblClick(sheetObj,Row,Col){
        	var formObj = document.form; 
        	 formObj.retfld.value = sheetObj.CellText(Row, "sheet1_ofc_cd");
            
        	  comPopupOK();    
        	  //self.close();
         }
         function sheet1_OnClick(sheetObj,Row,Col){
        		var formObj = document.form; 
              	 formObj.retfld.value = sheetObj.CellText(Row,  "sheet1_ofc_cd");
              	 
         }
       
        
      

	/* 개발자 작업  끝 */