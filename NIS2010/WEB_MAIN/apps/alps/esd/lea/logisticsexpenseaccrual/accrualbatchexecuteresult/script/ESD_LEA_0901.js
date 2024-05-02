/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0901.js
*@FileTitle : Account Cost Inquiry (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.30 전재홍
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
     * @class ESD_LEA_0901 : ESD_LEA_0901 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0901() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;

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

            	    case "btng_select":
        	            lea_selectAccontCode(sheetObject);
            	        break;

    				case "btn_ok":
    				  break;

    				case "btn_close":
    					  window.close();
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
        function loadPage() {

            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Account\nCode|Rep.\nAcount\nCode|Cost\nType l |sub_cost_tp_cd|Cost Type Ⅱ|Account Name" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData	,        60,    daCenter,  true,    "acct_cd"   		,        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,        60,    daCenter,  true,    "rep_acct_cd"   ,        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,        60,    daCenter,  true,    "mn_cost_tp_cd" ,        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,  true,    "sub_cost_tp_cd",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,       200,    daCenter,  true,    "sub_cost_tp_nm",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,       220,    daCenter,  true,    "acct_nm"    ,        false,          "",       dfNone,     	0,     false,       false);

                    style.height = GetSheetHeight(13) ;
               }
                break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //조회
                   //if(validateForm(sheetObj,formObj,sAction))
			    	formObj.f_cmd.value = SEARCH;
					  //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0901GS.do", FormQueryString(formObj));
					  
					  var searchXml = sheetObj.GetSearchXml("ESD_LEA_0901GS.do", leaFormQueryString(formObj));
					  
					  
				    //ComShowMessage(searchXml);
				    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
                    break;

            }
        }


       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(iPage)) {
    //
//                    return false;
//                }
            }

            return true;
        }
      /*
       * Sheet Search 끝난후 발생하는 Event처리 함수
       */

    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
    			var openerFormObj = window.dialogArguments.document.form;
    			var Row = sheetObj.FindText("acct_cd", openerFormObj.frm_acct_cd.value);
    			if(Row > 0){
    	      sheetObj.SelectCell(Row, "acct_cd", false);  
    	      sheetObj.TopRow = Row;
    	   	}

    	}
        
       /**
         * 선택된 Row의 AccontCode Parent로 보낸다.
         */
        
        function lea_selectAccontCode(sheetObj){
        	var openerFormObj = window.dialogArguments.document.form;
        	if(sheetObj.RowCount < 1){
        		ComShowMessage("No searched data.");
        		return false;
        	}
        	
        	if(sheetObj.SelectRow <= 0){
        		ComShowMessage("No selected row.");
        		return false;
        	}
        	openerFormObj.frm_acct_cd.value = sheetObj.CellValue(sheetObj.SelectRow,"acct_cd");
        	window.close();
        }
        
        
        	/**
    	 * 해당 Sheet change Event발생시 실행하는 함수.
    	 *
    	 */
    	function sheet1_OnDblClick(sheet1,row, col){
    			lea_selectAccontCode(sheet1);		
    	}


	/* 개발자 작업  끝 */