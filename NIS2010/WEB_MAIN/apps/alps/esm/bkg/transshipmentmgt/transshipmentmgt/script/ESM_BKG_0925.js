/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ems_bkg_0925.js
*@FileTitle : T/S List by 1st VSL & 2nd VSL T/S Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.04 최영희
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.05.27 이일민 [CHM-201110190] * 전배 모선 표시 사항
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
     * @class ems_bkg_0925 : ems_bkg_0925 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ems_bkg_0925() {
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
				case "btn_DownExcel":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
					break;

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
        formObj = document.form;
        if(formObj.disc_load_cd.value == 'D'){
        	sheetObjects[0].ColHidden(prefix1+"pod_yd_cd") = true;
       	}else{
       		sheetObjects[0].ColHidden(prefix1+"pol_yd_cd") = true;
       	}

		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		axon_event.addListenerForm  ('Change', 'bkg0925_Change', document.form);
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
                    style.height = 260;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|LANE|T/S VVD|TMNL Code|TMNL Code||ETA|40'|20'|R/F40'|R/F20'";
				 	var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	    0,		daCenter,	true,	prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,	prefix1+"lane",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	prefix1+"vvd",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	prefix1+"pod_yd_cd",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	prefix1+"pol_yd_cd",		false,		"",		dfNone,		0,		false,	true);
					InitDataProperty(0, cnt++ , dtHidden,	    	0,		daCenter,	true,	prefix1+"p_yd_cd");
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,	prefix1+"eta",		false,		"",		dfDateYmd,	0,		false,	true);

					InitDataProperty(0, cnt++ , dtAutoSum,			50,		daCenter,	true,	prefix1+"ft40",		false,		"",		dfNone,		0,		false,	true,-1,false,false);
					InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	true,	prefix1+"ft20",		false,		"",		dfNone,		0,		false,	true,-1,false,false);
					InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	true,	prefix1+"rf40",		false,		"",		dfNone,		0,		false,	true,-1,false,false);
					InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	true,	prefix1+"rf20",		false,		"",		dfNone,		0,		false,	true,-1,false,false);

					//CountPosition = 0;
					MessageText("Sum") = "TTL";

			}
			break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = new Array("sheet1_");
        switch(sAction) {

          	case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH; 
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0925GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix)); 
					sheetObj.Redraw = false;   
					sheetObj.LoadSearchXml(sXml); 
					sheetObj.Redraw = true; 
				break; 
	 		 
			case IBDOWNEXCEL:	//엑셀다운로드
				sheetObj.SpeedDown2Excel(-1);
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

    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var polYdCd,podYdCd,pYdCd;
		with (sheetObj) {
	       	for (var i=HeaderRows; i<Rows; i++) {
				polYdCd = CellValue(i, prefix1+"pol_yd_cd");
				podYdCd = CellValue(i, prefix1+"pod_yd_cd");
				pYdCd = CellValue(i, prefix1+"p_yd_cd");
				if (!ComIsEmpty(polYdCd) && polYdCd!=pYdCd) {
		       		CellFontColor(i, prefix1+"pol_yd_cd") = RgbColor(255, 0, 0);
				} else if (!ComIsEmpty(podYdCd) && podYdCd!=pYdCd) {
		       		CellFontColor(i, prefix1+"pod_yd_cd") = RgbColor(255, 0, 0);
				}
	       	}
       	}
    }

	function bkg0925_Change(){
		obj = event.srcElement; 
		var formObject = document.form; 
		if(obj.name =="selSort"){ 
			sheetObjects[0].ColumnSort(ComGetObjValue(formObject.selSort)); 
		}
	}

	/* 개발자 작업  끝 */