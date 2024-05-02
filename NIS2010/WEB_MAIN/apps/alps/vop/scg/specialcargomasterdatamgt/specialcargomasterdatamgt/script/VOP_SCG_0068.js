/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0068.js
*@FileTitle : Excepted Quantities (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철 jkc
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
     * @class vop_scg_0068 : vop_scg_0068 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0068() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* 개발자 작업   */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
             
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
    			case "btn1_Retrieve":
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    				break;
                   
    			case "btn1_Excel":
    				var paramObj = new Object();
    				paramObj.title = "Special Provisions for Segregation";
    				paramObj.columnwidth = "2:10|3:55|4:55";
    				paramObj.datarowheight   = "0:35";
    				var url = ComScgGetPgmTitle(sheetObjects[0], paramObj);  
    				sheetObjects[0].SpeedDown2Excel(-1, false,false, "", url );
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
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	initControl();
    }
    
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet( sheetObj,document.form,IBSEARCH);
    }   

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
            switch(sheetObj.id) {
            	case "sheet1":      //t2sheet1 init
            		with (sheetObj) {
            			// 높이 설정
            			style.height = 460;
                                           
                       //전체 너비 설정
                       SheetWidth = mainTable.clientWidth;

                       //Host정보 설정[필수][HostIp, Port, PagePath]
                       if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                       //전체Merge 종류 [선택, Default msNone]
                       MergeSheet = msAll;

                       //전체Edit 허용 여부 [선택, Default false]
                       Editable = false;

                       //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                       InitRowInfo(1, 1, 15, 100);

                       var HeadTitle1 = "|No.|Code|Maximum net quantity \n per inner packaging \n (in grams for solids and ml for liquids and gases)|Maximum net quantity per outer packaging \n (in grams for solids and ml for liquids and gases, \n or sum of grams and ml in the case of mixed packaging)";
                       var headCount = ComCountHeadTitle(HeadTitle1);
                                           
                       //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                       InitColumnInfo(headCount, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                       InitHeadMode(true, true, false, true, false,false);

                       //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                       InitHeadRow(0, HeadTitle1, true);

                       //데이터속성   [ROW, COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC,     DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                       InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,   false,       "ibflag");
                       InitDataProperty(0, cnt++ , dtDataSeq,      30,    daCenter);
                       InitDataProperty(0, cnt++ , dtData,         60,     daCenter,   false,      "imdg_expt_qty_cd", false,       "",     dfNone,     0,          false,      true,   2);
                       InitDataProperty(0, cnt++ , dtData,         400,    daCenter,   false,      "max_inr_pck_qty",  false,       "",     dfNone,     0,          true,       true,   9);
                       InitDataProperty(0, cnt++ , dtData,         400,      daCenter,   false,      "max_outr_pck_qty", false,       "",     dfNone,     0,          true,       true,   9);
                       
                       InitDataValid(0, "imdg_expt_qty_cd", vtEngUpOther, "0123456789");
                       InitDataValid(0, "max_inr_pck_qty", vtNumericOnly);
                       InitDataValid(0, "max_outr_pck_qty", vtNumericOnly);

                   }
                    break;
            }
        }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if(validateForm(sheetObj,formObj,sAction)) {
    				if(sheetObj.id == "sheet1") {
    					formObj.f_cmd.value = SEARCH;
    					sheetObj.DoSearch("VOP_SCG_0067GS.do", FormQueryString(formObj));
    				}
    			}           
    			break;
 
    	}
    }

    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {       
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
 
    	return true;
    }
    
    /* 개발자 작업  끝 */