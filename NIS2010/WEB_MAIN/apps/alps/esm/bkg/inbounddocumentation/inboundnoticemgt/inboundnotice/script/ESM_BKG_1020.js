/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1020.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.17 손윤석
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var isSaveable = false;
var isDeleteable = false;

document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function processButtonClick()
{
    var sheetObject1 = sheetObjects[0];
    var formObj = document.form;


        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName)
        {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObj,IBSEARCH);
//                isSaveable = true;
            break;
            case "btn_Close":
                self.close();
            break;
            case "btn_Save":
                if(!isSaveable)
                {
                    ComShowCodeMessage("BKG00448");
                    return;
                }
                doActionIBSheet(sheetObject1,formObj,MULTI);
            break;
            case "btn_Delete":
                doActionIBSheet(sheetObject1,formObj,REMOVE);
//                isSaveable = false;
            break;
        }

}

/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 필수, 등록할 개체
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function loadPage()
{
    for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    axon_event.addListenerFormat("keypress","obj_keypress", form);
    axon_event.addListener("keydown","obj_keydown1", "ofc_cd");
    axon_event.addListener("keydown","obj_keydown2", "impt_ntc_rmk");

    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리를 수행<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, Form 객체
 * @param {int} sAction 필수, 처리할 작업 코드
 * @return boolean 유효성 여부
 * @author Son Yunseok
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction)
{
    var len = formObj.ofc_cd.value.length;
    switch(sAction)
    {
    case MULTI:
        if(len < 5 || len > 6)
        {
            //"Input Issue OFC !"
            ComShowCodeMessage("BKG00604");
            return false;
        }

        break;
    case REMOVE:
        if(!isDeleteable)
        {
            ComShowCodeMessage("BKG03054");
            return false;
        }
        if(len < 5 || len > 6)
        {
            //"Input Issue OFC !"
            ComShowCodeMessage("BKG00604");
            return false;
        }

        break;
    case IBSEARCH:
        if(len < 5 || len > 6)
        {
            //"Input Issue OFC !"
            ComShowCodeMessage("BKG00604");
            return false;
        }
        break;
    }
    return true;
}

/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {int} sheetNo 필수, Sheet Index
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo)
{
    var cnt = 0;
    switch(sheetNo)
    {
        case 1:      //sheet1 init
            with (sheetObj)
            {
                //높이 설정
                style.height = 100;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(12, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)
                var HeadTitle = "|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                var prefix = "sheet1_";

                InitDataProperty(0, cnt++ , dtStatus,    30,    daCenter,    false, prefix + "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,   40,       daCenter,      true, prefix + "Seq");
                InitDataProperty(0, cnt++ , dtData,  80,       daCenter,     false, prefix + "ofc_cd",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  75,       daCenter,     false, prefix + "addr_ctnt",   false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  75,       daCenter,     false, prefix + "impt_ntc_rmk",   false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  90,       daRight,      false, prefix + "an_seq",  false, "",    dfNone, 0, true, true);

                CountPosition = 0;
            }
        break;
    }
}

/**
 * Sheet관련 프로세스 처리<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet
 * @param {Object} formObj 필수, form객체
 * @param {int} sAction 필수, 작업처리코드
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj,sAction)
{
    //sheetObj.ShowDebugMsg = false;
    var status = '';

    switch(sAction)
    {
        case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCH;
            validateForm(sheetObj,formObj,sAction)
            if(!validateForm(sheetObj,formObj,sAction)) return;
            //ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_1020GS.do", FormQueryString(formObj)
                        + "&"
                        + ComGetPrefixParam("sheet1_"));



            break;
        case REMOVE:
            formObj.f_cmd.value = REMOVE;
            if(!validateForm(sheetObj,formObj,sAction)) return;

				formObj.addr_ctnt.value = "";
				formObj.impt_ntc_rmk.value = "";
				formObj.an_seq.value = "";

				sheetObj.RowStatus(1) = "D";
                sheetObj.DoSave("ESM_BKG_1020GS.do", FormQueryString(formObj)+ "&"
                        + ComGetPrefixParam("sheet1_"));

            break;

        case MULTI:
            if(!validateForm(sheetObj,formObj,sAction)) return;
            formObj.f_cmd.value = MULTI;

			if(sheetObj.RowCount < 1){
				sheetObj.DataInsert();
			}

			sheetObj.CellValue( 1,"sheet1_" + "addr_ctnt") = formObj.addr_ctnt.value;
			sheetObj.CellValue( 1,"sheet1_" + "impt_ntc_rmk") = formObj.impt_ntc_rmk.value;
			sheetObj.CellValue( 1,"sheet1_" + "an_seq") = formObj.an_seq.value;


            sheetObj.RowStatus(1) = "U";
            sheetObj.DoSave("ESM_BKG_1020GS.do", FormQueryString(formObj)+ "&"
                        + ComGetPrefixParam("sheet1_"));

            break;

    }
}

/**
 * 폼 객체에다 키보드 이벤트를 수행할 경우 발생한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function obj_keypress()
{
    switch(event.srcElement.dataformat)
    {
        case "int": //숫자 만입력하기
            ComKeyOnlyNumber(event.srcElement); break;
        case "float": //숫자+"."입력하기
            ComKeyOnlyNumber(event.srcElement, "."); break;
        case "eng": //영문만입력하기
            ComKeyOnlyAlphabet(); break;
        case "engup": //영문대문자만입력하기
            ComKeyOnlyAlphabet('upper'); break;
        default: //숫자만입력하기
            ComKeyOnlyNumber(event.srcElement);
    }
}

/**
 * 폼 객체에다 키보드 이벤트(Key Down 이벤트 처리)를 수행할 경우 발생한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function obj_keydown1()
{
    var key = event.keyCode;
    if(key == 13)
    {
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
}

/**
 * 폼 객체에다 키보드 이벤트(Key Down 이벤트 처리)를 수행할 경우 발생한다.<br>
 * 텍스트Area의 경우 검사하낟.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function obj_keydown2()
{
    fncTextareaMaxLine(document.form.impt_ntc_rmk, 10);
}

/**
 * text Area의 최대 길이를 넘지 않도록 조정한다.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} obj 필수, 이벤트 객체
 * @param {int} maxLine 선택, 최대 행 수
 * @return void
 * @author Son Yunseok
 * @version 2009.10.01
 */
function fncTextareaMaxLine(obj, maxLine)
{
    var str_len = obj.value;
    line = str_len.split("\r\n");
    ln = line.length;

    if(ln == maxLine && event.keyCode == 13)
    {
        event.returnValue = false;
    }
}


function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	var formObj = document.form;

	if(sheetObj.RowCount > 0){
		isDeleteable = true;
        isSaveable = true;
		formObj.addr_ctnt.value = sheetObj.CellValue( 1,"sheet1_" + "addr_ctnt");
		formObj.impt_ntc_rmk.value = sheetObj.CellValue( 1,"sheet1_" + "impt_ntc_rmk");
		formObj.an_seq.value = sheetObj.CellValue( 1,"sheet1_" + "an_seq");
	}else{
		ComOpenWait(false);
		isDeleteable = false;
		isSaveable = true;
		formObj.addr_ctnt.value = "";
		formObj.impt_ntc_rmk.value = "";
		formObj.an_seq.value = "";
	}


}

function sheet1_OnSaveEnd(sheetObj, errMsg){
    ComOpenWait(false);
	var formObj = document.form;
	var sheetObject1 = sheetObjects[0];


    if(errMsg != ""){

	}else{
		doActionIBSheet(sheetObject1,formObj,IBSEARCH);
	}

}