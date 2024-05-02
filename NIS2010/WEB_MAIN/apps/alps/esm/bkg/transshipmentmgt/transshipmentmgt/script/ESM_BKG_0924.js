/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0924.js
*@FileTitle : Yard Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.29 최영희
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
     * @class esm_bkg_0924 : esm_bkg_0924 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0924() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1="sheet1_";

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
				case "btn_Close":
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

			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);

			ComEndConfigSheet(sheetObjects[i]);

        }

		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }

	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.WaitImageVisible = false;  
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
		sheetObj.WaitImageVisible = true;   
	}   


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
				var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 242;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|YARD|S.Day|40'|20'|AK40|AK20|DG40|DG20|RF40'|RF20'";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	prefix1+"yd_cd",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,	prefix1+"s_day",	false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	true,	prefix1+"ft40",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	true,	prefix1+"ft20",		false,		"",		dfNone,		0,		false,	true);

					InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	true,	prefix1+"ak40",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	true,	prefix1+"ak20",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	true,	prefix1+"dg40",		false,		"",		dfNone,		3,		false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	true,	prefix1+"dg20",		false,		"",		dfNone,		3,		false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		75,		daRight,	true,	prefix1+"rf40",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,	prefix1+"rf20",		false,		"",		dfNone,		0,		false,	true);

					CountPosition = 0;

					
					AutoSumBottom = true; 
					//MessageText("Cumulate") = "Sub Total";
					MessageText("Sum")  = "Grand Total";

			}
			break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
       var arrPreFix = new Array("sheet1_");
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          	case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH; 
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0924GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.Redraw = false; 
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.Redraw = true;  
				
				break; 
        }
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

		// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
		function sheet1_OnSearchEnd(sheetObj, ErrMsg)
		{
			with(sheetObj)
			{
				//Syntax : ShowSubSum(StdCol, SumCols, [PosBottom], [Sort], [ShowCumulate], [CaptionCol], [OtherColText], [AvgCols], [IsSumEx]) 
				//ShowSubSum("Yard", "G40|G20|AK40|AK20|DG40|DG20|RF40|RF20", true, false, false, 0, "1=Sub Total")
				//HideSubSum(); 
				ShowSubSum(prefix1+"yd_cd", prefix1+"ft40|"+prefix1+"ft20|"+prefix1+"ak40|"+prefix1+"ak20|"+prefix1+"dg40|"+prefix1+"dg20|"+prefix1+"rf40|"+prefix1+"rf20", true, false, false, 0, "1=Sub Total");

				var sRow = FindSubSumRow(prefix1 +"yd_cd");
                var arrRow = sRow.split("|");
				for (idx=0; idx<arrRow.length-1; idx++) { 
				 CellFont("FontBold", arrRow[idx],1, arrRow[idx],LastCol) = true;
				}
			}
		}

	/* 개발자 작업  끝 */