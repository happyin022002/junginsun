/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0213.js
*@FileTitle : Expense Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.09.25 김진일
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
     * @class VOP_PSO_0213 : VOP_PSO_0213 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0213() {
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
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_Retrieve":
            		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    				break;
				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
					break;
				case "btn_ok":
				case "btn_close":
					self.close();
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

            for(i=0;i<sheetObjects.length;i++){
            		doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
            }
            
//            changeColor();

        }

         /**
          * IBSHEET의 Color를 변경 한다.  
          */
         function changeColor(){
        	  var colorObj = sheetObjects[0].RgbColor(255,255,255);
              sheetObjects[0].ColBackColor(1) = colorObj;
              sheetObjects[0].ColBackColor(2) = colorObj;
              sheetObjects[0].ColBackColor(3) = colorObj;
              sheetObjects[0].ColBackColor(4) = colorObj;
              sheetObjects[0].ColBackColor(5) = colorObj;
              sheetObjects[0].ColBackColor(6) = colorObj;
              sheetObjects[0].ColBackColor(7) = sheetObjects[0].RgbColor(205,255,254);// Class Input1의 RGB색상
              sheetObjects[0].ColBackColor(8) = colorObj;
              sheetObjects[0].ColBackColor(9) = colorObj;
              sheetObjects[0].ColBackColor(10) = colorObj; 
         }

      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
    			var sheetid = sheetObj.id;
          switch(sheetid) {

    				case "sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 392;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = false;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, 100);

    							var HeadTitle1 = "|Revenue\nMonth|Lane|VVD|Terminal\nCode|Compulsory|Account\nCode|Cost\nCode|S/P\nCode|IN/OUT|Currency|Amount|USD Amount|Accrual Cost|SYS_SRC_ID|ESTM_SEQ_NO|Formula\nDescription|Formula\nExpression";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(false, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							var prefix="sheet1_";
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,	true,		prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtData,					60,	daCenter,	true,		prefix+"expn_yrmon",			false,		"",	dfDateYm,		0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					40,	daCenter,	true,		prefix+"vsl_slan_cd",		false,		"",	dfNone,		0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	true,		prefix+"vvd",		false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					60,	daCenter,	true,		prefix+"yd_cd",		false,		"",	dfNone,			0,		false,		true);
    							//InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		prefix+"skd_cng_sts_cd",		false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtCheckBox,					50,	daCenter,	true,		prefix+"cpls_flg",		false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					60,	daCenter,	true,		prefix+"acct_cd",			false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					60,	daCenter,	true,		prefix+"lgs_cost_cd",		false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	true,		prefix+"vndr_seq",		false,		"",	dfNone,			0,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	true,		prefix+"io_bnd_cd",		false,		"",	dfNone,	2,		false,		false);
    							InitDataProperty(0, cnt++ , dtData,					60,	    daCenter,	true,		prefix+"locl_curr_cd",		false,		"",	dfNone,	2,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					85,	daRight,	true,		prefix+"inv_locl_amt",		false,		"",	dfNullFloat,	2,		false,		true);
    							InitDataProperty(0, cnt++ , dtData,					85,	daRight,	true,		prefix+"inv_usd_amt",		false,		"",	dfNullFloat,	2,		false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,				90,	daRight,	true,		prefix+"accl_amt",		false,		"",	dfNone,	2,		false,		true);
    							InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,	true,		prefix+"sys_src_id");
    							InitDataProperty(0, cnt++ , dtHidden,				40,		daCenter,	true,		prefix+"estm_seq_no");
    							InitDataProperty(0, cnt++ , dtData,					115,		daLeft,	true,		prefix+"foml_desc",		false,		"",	dfNone,	2,		false,		false);
    							InitDataProperty(0, cnt++ , dtData,					115,		daLeft,	true,		prefix+"xpr_desc",		false,		"",	dfNone,	2,		false,		false);
    							
    							CountPosition = 0;
    							//[2010.03.15]
    							HeadRowHeight = 40;
    							DataRowHeight = 45;
    						}
    						break;
    						
            }
        }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible=false;
        switch(sAction) {

          case IBSEARCH:      //조회
           	if(validateForm(sheetObj,formObj,sAction)){
				if ( sheetObj.id == "sheet1"){
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("VOP_PSO_0213GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
					ComOpenWait(false);
				}
           	}
          	break;
        }
    }
        

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }

        return true;
    }
    /**
     * Est-Act의 값이 음수 이면 Accrual Cost의 값을 강제로 0으로 셋팅한다. 
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnAfterEdit(sheetObj, Row,Col){
    	//Est-Act >= 0 이어야 한다.  
    	if(Col===7)//Estimate Cost가 변경 된 후 
    		sheetObj.CellValue(Row,Col+2) = sheetObj.CellValue(Row,Col) - sheetObj.CellValue(Row,Col+1) < 0 ?  0:sheetObj.CellValue(Row,Col) - sheetObj.CellValue(Row,Col+1);
    }

	/* 개발자 작업  끝 */