/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0086_01.js
*@FileTitle : Verification Rule
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.06
*@LastModifier : 변종건
*@LastVersion : 1.0 
* 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESD_PRD_0086_01 : ESD_PRD_0086_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */


var sheetObjects = new Array();
var sheetCnt = 0;
var prefix = "s_";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];

         /*******************************************************/
         var formObject = document.form;

      try {
      var srcName = window.event.srcElement.getAttribute("name");

      switch(srcName) {

        case "btn_close":
            window.close();
            break;

      } // end switch
      }catch(e) {
        if( e == "[object Error]") {
          ComShowMessage(ComGetMsg('COM12111'));
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
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
            	//전체 너비 설정
//              style.height = GetSheetHeight(12) ;
            	style.height = 0 ;
            	SheetWidth = mainTable.clientWidth;

            	//Host정보 설정[필수][HostIp, Port, PagePath]
            	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            	//전체Merge 종류 [선택, Default msNone]
            	MergeSheet = msHeaderOnly;

            	//전체Edit 허용 여부 [선택, Default false]
            	Editable = true;

            	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            	InitRowInfo( 3, 1, 9, 100);

            	var HeadTitle = "Chk|Status|Error Type|SEQ|Del.|STS|POL|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Type|Note|C.Date|C.User|U.Date|U.User";

            	var headCount = ComCountHeadTitle(HeadTitle);

            	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            	InitColumnInfo(headCount, 4, 0, true);
//              InitColumnInfo(64, 4, 0, true);

            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
            	InitHeadMode(true, true, true, true, false,false);

            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            	InitHeadRow(0, HeadTitle, true);

            	//데이터속성    [  ROW, COL,    DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE,	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter,  	true,    	"ibflag",  	false,          "",       dfNone,	    0,     false,      false);

				InitComboNoMatchText(true);		            
	            HeadRowHeight = 20 ;
	            
	            WaitImageVisible=false;
            }
            
            break;
        }
    }



    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBDELETE:
        	   	var idx = 0;
        	   	for( idx = sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx >= 0+parseInt(sheetObj.HeaderRows); idx-- ){
        	   		if( sheetObj.CellValue(idx,"s_chk") == "1" ){
        	   			sheetObj.RowDelete(idx, false);
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

        }

        return true;
    }
