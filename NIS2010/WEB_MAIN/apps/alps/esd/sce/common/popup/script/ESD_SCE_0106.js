/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0105 .js
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-23
*@LastModifier : yujin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 var sheetObjects = new Array();
var sheetCnt = 0;
var selRow = 0;
var selCol = 0;
var selOfc = "";

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {

		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);

		ComEndConfigSheet(sheetObjects[i]);
	}
}

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
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;

    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;

            case "btn_close":
	            self.close();
    	        break;

			case "btn_ok":
				
					ComOpenPopupOK();
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
                style.height = GetSheetHeight(10) ;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 50);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(3, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                var HeadTitle = "|Country Code|Country Name" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, false);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "radio",        false,          "",       dfNone,   	0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "cnt_cd",        false,          "",       dfNone,       0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,      116,    daCenter  ,  false,    "cnt_nm",        false,          "",       dfNone,       0,     false,       true);

           }
            break;

    }
}
//sheetObj.CellValue(sheetObj.SelectRow, "usr_nm")

    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCH07;
                selectVal = SceFrmQryString(formObj);
                //alert(formObj.conti_cd.value);
                //alert(formObj.sub_conti_cd.value);
                //alert(formObj.cnt_cd.value);
                //alert(formObj.cnt_nm.value);
                sheetObj.DoSearch4Post("ESD_SCE_0106GS.do", selectVal);

           break;

           case IBSAVE:
//           		aa = sheetObj.cellvalue(sheetObj.SelectRow,"SCNo");
//           		alert(aa);
//           		return aa;
           break;
        }
    }


