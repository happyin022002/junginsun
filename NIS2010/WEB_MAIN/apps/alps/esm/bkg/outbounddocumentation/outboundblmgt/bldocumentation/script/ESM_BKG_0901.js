/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0901.js
*@FileTitle : Container Repor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.18 김영출
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.04.23 김보배 [CHM-201324188] [BKG] "Not updated container" Clear 버튼 생성
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
     * @class esm_bkg_0901 : esm_bkg_0901 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0901() {
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
	var callback_func = '';
		

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

				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;

				case "btn_select":
					doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
				//break;

				case "btn_close":
					window.close();
				break;

				case "btn_clear":
					doActionIBSheet(sheetObject1, formObject, MULTI01);
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
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|Container No|N/P|Booking No|Status|Origin YD|Dest. YD|Event Date";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,  0,    daCenter,  false,  "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox,  40,   daCenter,    false,     "sel");
					InitDataProperty(0, cnt++, dtData,      90,   daCenter,    false,     "cntr_no",         false,    "",      dfNone, 		0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      30,   daCenter,    false,     "cntr_bkg_atch_cd",    		 false,    "",      dfNone, 		0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      90,   daCenter,    false,     "bkg_no",          false,    "",      dfNone, 		0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      45,   daCenter,    false,     "sts",         false,    "",      dfNone,		0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      70,   daCenter,    false,     "org_yd",       	 false,    "",      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      70,   daCenter,    false,     "dest_yd",         false,    "",      dfNone,		0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      90,   daCenter,    false,     "evnt_dt",         false,    "",      dfUserFormat2,	0,     false,       true);


					ShowButtonImage = 2;
					InitUserFormat2(0,   "evnt_dt",   "####.##.## ##:##", ".|:");

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
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0901GS.do", FormQueryString(formObj));
					return true;
				}else{
					return false;
				}
			break;

			case IBCOPYROW:        //Select
				if(!opener) opener = window.dialogArguments;
				if(callback_func != ''){
					var arr = ComFindText(sheetObj, "sel", 1);
					if(arr.length==0){
						ComShowMessage(ComGetMsg("BKG01093"));
					}else if(arr.length==1){
						var returnVal = sheetObj.CellValue(arr[0], "cntr_no");
						//opener.setNotUpdatedContainer(returnVal);
						eval('opener.'+callback_func)(returnVal);
						return true;
					}else{
						ComShowMessage(ComGetMsg("BKG08040"));
					}
				}
				return false;
			break;
			
			
			case MULTI01:		// Clear
				if(callback_func != ''){
					var arr = ComFindText(sheetObj, "sel", 1);
					if(arr.length==0){
						ComShowMessage(ComGetMsg("BKG01093"));
					}else if(arr.length==1){
//						formObj.f_cmd.value = MULTI;
//						var sParam = FormQueryString(formObj);
//		                sheetObjects[0].DoSave("ESM_BKG_0901GS.do", sParam, -1, false);
//		                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						
						ComOpenWait(true);
						formObj.f_cmd.value = MULTI;
						var sParam = sheetObjects[0].GetSaveString();
						sParam += "&" + FormQueryString(formObj);
						var sXml = sheetObj.GetSaveXml("ESM_BKG_0901GS.do", sParam);
						var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

						if(State == "S"){
			                sheetObj.Redraw = false;           
			                sheetObj.LoadSearchXml(sXml);
			                sheetObj.Redraw = true;
				        	ComOpenWait(false);
					   		ComShowCodeMessage("BKG00593"); // Data Deleted Successfully
					   		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				        }else{
				        	ComOpenWait(false);
				        	ComShowMessage(ComResultMessage(sXml));
				        }
					}else{
						ComShowMessage(ComGetMsg("BKG08040"));
					}
				}
				return false;
			break;
			
        }
		return true;
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

	/* 개발자 작업  끝 */
