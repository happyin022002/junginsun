/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0110.js
*@FileTitle : (DXBSC) INV B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2010.02.19 최우석
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
     * @class fns_inv_0110 : fns_inv_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0110() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
	 * 
	 * @return 없음
	 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_paperissue":
	            	doActionIBSheet(sheetObject1,formObject,IBSAVE);
	            	window.close();
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
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의<br>
     *
     * @param {object} sheet_obj
     * @return 없음
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화<br>
     * body 태그의 onLoad 이벤트핸들러 구현<br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
     *
     * @return 없음
     */
    function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);

//             sheetObjects[i].ExtendLastCol = false;
         }
    }

    /**
     * 시트 초기설정값, 헤더 정의<br>
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
     * 
     * @param {object} sheetObj
     * @param {int} sheetNo
     * @return 없음
     * @see #loadPage
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;

    	switch(sheetNo) {
    		case 1:      //sheet1 init
    			with (sheetObj) {
    				WaitImageVisible = false;
    			
    				// 높이 설정
                    style.height = 240;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false, false)

                    var HeadTitle = "INV|VVD|Cust Code|B/L No.|CHRG CODE|Cur.|Amount|Ex.Rate|LCL Amount|io_bnd_cd|port_cd|svc_scp_cd|inv_split_cd|usd_xch_rt|inv_iss_tp_cd|ar_if_no|ar_ofc_cd";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,  		30,   	daRight,  	true,   "inv_no",    		false,  "",     dfNone,  		0,  false,  false);
                    InitDataProperty(0, cnt++, dtData,    		90,   	daCenter,  	true,  	"vvd",   			false,  "",     dfNone,      	0,  false,  false);
                    InitDataProperty(0, cnt++, dtData,    		90,   	daCenter,  	true,  	"cust_cd",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtData,  		100,  	daCenter,   true,   "bl_src_no",   		false,	"",		dfNone,   		0,	false,	false);
 					InitDataProperty(0, cnt++, dtData,    		100,   	daCenter,  	false,  "chg_cd",   		false,  "",     dfNone,      	0,  false,  false);
                    InitDataProperty(0, cnt++, dtData,    		90,   	daCenter,  	false,  "curr_cd",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtData,  		90,   	daRight,  	false,  "chg_amt",    		false,  "",     dfNullFloat,  	2,  false,  false);
 					InitDataProperty(0, cnt++, dtData,  		90,   	daRight,  	false,  "inv_xch_rt",    	false,  "",     dfNullFloat,  	6,  false,  false);
 					InitDataProperty(0, cnt++, dtData,  		90,   	daRight,  	false,  "lcl_amt",    		false,  "",     dfFloat,  		2,  false,  false);

 					//----------------------------------------------------------------------
 					InitDataProperty(0, cnt++, dtHidden,   		100,   	daCenter,  	false,  "io_bnd_cd",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		100,   	daCenter,  	false,  "port_cd",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		100,   	daCenter,  	false,  "svc_scp_cd",   	false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		100,   	daCenter,  	false,  "inv_split_cd",   	false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		100,   	daCenter,  	false,  "usd_xch_rt",   	false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		100,   	daCenter,  	false,  "inv_iss_tp_cd",   	false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		100,   	daCenter,  	false,  "ar_if_no",   		false,  "",     dfNone,      	0,  false,  false);
 					InitDataProperty(0, cnt++, dtHidden,   		100,   	daCenter,  	false,  "ar_ofc_cd",   		false,  "",     dfNone,      	0,  false,  false);
 					//----------------------------------------------------------------------
 					
 					WordWrap = true;
 					CountFormat = "[0]";
    			}
                break;
    	}
    }

    /** Sheet관련 프로세스 처리<br>
     * 
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return 없음
     * @see #processButtonClick
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("FNS_INV_0110GS.do", FormQueryString(formObj));
    			break;

    		case IBSAVE:        //저장
			    opener.getFnsInv0110();
    			break;

    		case IBINSERT:      //입력
    			break;
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
     *
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @return bool;
     */
    function validateForm(sheetObj,formObj,sAction){
    	return true;
    }
     
    /**
     * 업무 자바스크립트 OnLoadFinish 이벤트 처리한다.<br>
     * 
     * @param {object} sheetObj
     * @return 없음
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	if(sheetObj.RowCount == 0) {
    		ComBtnDisable("btn_paperissue");
    	} else {
    		ComBtnEnable("btn_paperissue");
    	}
    	
    	var cnt = 0;
    	var b_blNo = "";
    	var a_blNo = "";
    	for(var i=1; i<=sheetObj.RowCount; i++) {
    		b_blNo = sheetObj.CellValue(i, "bl_src_no");
    		a_blNo = sheetObj.CellValue(i-1, "bl_src_no");
    		if(b_blNo != " ") {
    			if(b_blNo != a_blNo){
    				cnt++;
    			}	
    		}
    	}
    	sheetObj.CountFormat = "[" + cnt + "]"; 
    }
     
    /**
     * Sheet1에 OnSearchEnd 이벤트 발생시 소계의 백그라운드 색을 변경한다.<br>
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	for(var i=1; i<=sheetObj.LastRow; i++) {
    		var invTotal = sheetObj.CellValue(i, "vvd");
    		if(invTotal == "INV TOTAL") {
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(199,199,199);
//    			sheetObj.RowMerge(i) = true;
    			sheetObj.CellFont("FontBold", i, "vvd") = true;
    			sheetObj.CellFont("FontBold", i, "cust_cd") = true;
    			sheetObj.CellFont("FontBold", i, "bl_src_no") = true;
    			sheetObj.CellFont("FontBold", i, "chg_cd") = true;
    			sheetObj.CellFont("FontBold", i, "curr_cd") = true;
    			sheetObj.CellFont("FontBold", i, "chg_amt") = true;
    			sheetObj.CellFont("FontBold", i, "inv_xch_rt") = true;
    			sheetObj.CellFont("FontBold", i, "lcl_amt") = true;
    		}
     	}
    }
	/* 개발자 작업  끝 */