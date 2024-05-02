﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1952.js
*@FileTitle : T/Time by MVMT CNTR (Detail)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2013.09.05 이영두
* 1.0 Creation
* ---------------------------------------------------------
* History
* 
=========================================================*/
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var shtCnt = 0;
         var sheetObject = sheetObjects[shtCnt++];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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

        	//khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

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
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "Seq.|CNTR No.|TP/SZ|FM LOC|TO LOC|T/T Days";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtDataSeq,	60,   daCenter, 	true,	"Seq",   	    false,	"",	dfNone);
                  InitDataProperty(0, cnt++ , dtData,		150,   daCenter, 	true,	"cntr_no",   	false,	"",	dfNone);
                  InitDataProperty(0, cnt++ , dtData,		60,   daCenter, 	true,	"cntr_tpsz_cd", false,	"",	dfNone);
                  InitDataProperty(0, cnt++ , dtData,		100,   daCenter, 	true,	"fm_yd_cd",   	false,	"",	dfNone);
                  InitDataProperty(0, cnt++ , dtData,		100,   daCenter, 	true,	"to_yd_cd",   	false,	"",	dfNone);
                  InitDataProperty(0, cnt++ , dtData,		60,   daCenter, 	true,	"tt_dys",   	false,	"",	dfNone);

                    CountPosition = 0;
                }
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCH02;

                sheetObj.WaitImageVisible=false;
                ComOpenWait(true); 

                var sXml = sheetObj.GetSearchXml("EES_CIM_1952GS.do",FormQueryString(formObj));
		        sheetObj.LoadSearchXml(sXml);
		        
		        sheetObj.WaitImageVisible = true;
				ComOpenWait(false);
                break;

			case IBDOWNEXCEL:      // 입력
	   			sheetObj.SpeedDown2Excel(true);
	   			break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }

        return true;
    }

    /**
     * 화면 조회 종료후 프로세스 처리
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		sheetObj.SelectHighLight = false;
	}
	
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	