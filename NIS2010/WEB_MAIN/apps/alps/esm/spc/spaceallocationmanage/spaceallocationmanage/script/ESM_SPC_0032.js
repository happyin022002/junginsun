/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0032.js
*@FileTitle : Status by Load Office
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.01
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.02.01 진마리아
* 1.0 Creation
* 2013.02.01 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
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
     * @class ESM_SPC_0032 : ESM_SPC_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0032() {
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
       			case "btn_retrieve":
       				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
       				break;

       			case "btn_downexcel":
       				if(sheetObjects[0].RowCount > 0){
       					sheetObjects[0].Down2Excel(-1);
       				}
       				break;

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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

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
                    // 높이 설정
                    
                    style.height = 500;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 3, 1, 9, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false, false)
                  
                    var HeadTitle = "|OFC|Rep.\nTrade|Sub\nTrade|Lane|BD|VVD|Yield\nGroup|";
                    var HeadTitle1 = HeadTitle + "Guided|Guided|Forecast|Forecast|Forecast|Forecast|Allocation|Allocation|Allocation|Allocation|"
                                               + "BKG|BKG|BKG|BKG|Accu.by Group|Accu.by Group|Accu.by Group|Accu.by Group|";
                    var HeadTitle2 = HeadTitle + "Volume|Portion|Volume|Volume|Portion|Portion|Volume|Volume|Portion|Portion|"
                    						   + "Volume|Volume|Portion|Portion|Accu.\nGuide|Accu. Volume|Accu. Volume|Accu.\nRatio|";
                    var HeadTitle3 = HeadTitle + "Volume|Portion||Diff||Diff||Diff||Diff|"
                    						   + "|Diff||Diff|Accu.\nGuide||Diff|Accu.\nRatio|";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	10,	daCenter,	true,		"ibflag");
    				InitDataProperty(0, cnt++ , dtData,		45,		daCenter,	true,		"sls_rgn_ofc_cd",	false,	"",		dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		45,		daCenter,	true,		"trd_cd",		false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		45,		daCenter,	true,		"sub_trd_cd",	false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"rlane_cd",		false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	true,		"dir_cd",		false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"vvd",			false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"cust_ctrl_cd",	false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		55,		daRight,	true,		"mdl_qty",		false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		55,		daRight,	true,		"mdl_rto",		false,	"",			dfNone,			0,		true,  true);
    				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"fcast_qty",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"fcast_diff",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"fcast_rto",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"fcast_rto_diff",	false,	"",		dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"aloc_qty",		false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"aloc_diff",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"aloc_rto",		false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"aloc_rto_diff",false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"bkg_qty",		false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"bkg_diff",		false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"bkg_rto",		false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"bkg_rto_diff",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"accum_mdl",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"accum_bkg",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		50,		daRight,	true,		"accum_diff",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		90,		daRight,	true,		"accum_rto",	false,	"",			dfNone,			0,		true,  true);
     				InitDataProperty(0, cnt++ , dtData,		1,		daRight,	true,		"",	false,	"",			dfNone,			0,		true,  true);
                
     				HeadRowHeight  = 10;
     				
               }
            break;

        } 
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if (validateForm(sheetObj, formObj, sAction)) {
    				formObj.f_cmd.value = SEARCH;
    				sheetObj.ReDraw=false;
    				sheetObj.RemoveAll();
    				
    				var param = SpcFormString(formObj,"ALL");

    				var rtnXml = sheetObj.GetSearchXml("ESM_SPC_0032GS.do", param);
    				
    				sheetObj.LoadSearchXml(rtnXml);
    				sheetObj.ReDraw=true;
    			}
            break;

    	}
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
	 	case IBSEARCH:
	 		break;
	 		
		}
    	return true;
    }
     
     /*
      * 조회 후처리
      */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
    	var size = sheetObj.LastCol;
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    		var cnt=0;
    		for(var j=0 ; j<=size ; j++){
				var name = sheetObj.ColSaveName(j);
				var value = Number(sheetObj.CellValue(i, j).replace("%", ""));
				if(name.indexOf("diff")>=0){
					if(value<0){
						sheetObj.CellFontColor(i, j) = sheetObj.RgbColor(255, 0, 0);
					}else if(value>0){
						sheetObj.CellFontColor(i, j) = sheetObj.RgbColor(0, 0, 255);
					}else{
						sheetObj.CellFontColor(i, j) = sheetObj.RgbColor(0, 0, 0);
					}
				}
				
				if(sheetObj.CellValue(i, "cust_ctrl_cd")=="TOTAL" && name=="cust_ctrl_cd") cnt++;
				if(cnt>0){
					sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(247,231,236);
				}
			}
    	}
    }
     
	/* 개발자 작업  끝 */