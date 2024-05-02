/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1018.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.13
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.13 손윤석
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

    try
    {
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName)
        {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObj,IBSEARCH);
            break;
            case "btn_Close":
                if(formObj.old_rmk.value != formObj.do_prn_rmk.value)
                {
                    if(ComShowCodeConfirm("BKG00168"))
                    {
                        self.close();
                    }
                }
                else
                {
                    self.close();
                }
            break;
            case "btn_Save":
                if(doActionIBSheet(sheetObject1,formObj,MODIFY))
                {
                    self.close();
                }
            break;
        }
    }
    catch(e)
    {
        if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
        else                        ComShowMessage(e);
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
    axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListenerForm("KeyDown","obj_KeyDown", document.form);

    if (document.getElementById("do_no").value != "") {
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
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
    with(formObj)
    {
        //if (!isNumber(formObj.iPage))
        //{
        //    return false;
        //}
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
                var HeadTitle = "|Seq|do_no|do_no_split|ofc_cd|bkg_no|usr_id|do_prn_rmk";
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                var prefix = "sheet1_";
                InitDataProperty(0, cnt++ , dtStatus,     30,  daCenter,    false, prefix + "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,        40,  daCenter,     true, prefix + "Seq");
                InitDataProperty(0, cnt++ , dtData,      170,  daCenter,    false, prefix + "do_no",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,      110,  daCenter,    false, prefix + "do_no_split",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,      100,  daCenter,    false, prefix + "ofc_cd",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,       80,  daCenter,    false, prefix + "bkg_no",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,       75,  daCenter,    false, prefix + "usr_id",   false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,       75,  daCenter,    false, prefix + "do_prn_rmk",   false, "",    dfNone, 0, true, true);


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
            sheetObj.DoSearch("ESM_BKG_1018GS.do", FormQueryString(formObj)+ "&"
                        + ComGetPrefixParam("sheet1_"));



			return;



            status = sheetObj.EtcData('status');
			alert(status);
            if(status == 'no_data')
            {
                ComShowCodeMessage("BKG00095");
                ComOpenWait(false);
                formObj.do_prn_rmk.value = '';
                return;
            }
            //DO_PRN_RMK
            formObj.do_prn_rmk.value = sheetObj.EtcData('do_prn_rmk');
            formObj.old_rmk.value = formObj.do_prn_rmk.value;
            break;

        case MODIFY:
            formObj.f_cmd.value = MULTI;
            var sXml = sheetObj.GetSaveXml("ESM_BKG_1018GS.do", FormQueryString(formObj));
            status = ComGetEtcData(sXml, 'status');
            if(status == 'ok')
            {
                ComShowCodeMessage("BKG00166");
                formObj.old_rmk.value = formObj.do_prn_rmk.value;
                return true;
            }
            else
            {
                ComShowCodeMessage("BKG00167");
                return false;
            }
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
function obj_KeyDown()
{
    var srcName = window.event.srcElement.getAttribute("name").substring(10);
    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    var srcValue = window.event.srcElement.getAttribute("value");
    fncTextareaMaxLine(window.event.srcElement, 5);
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

		formObj.do_prn_rmk.value = sheetObj.CellValue( 1,"sheet1_" + "do_prn_rmk");
		formObj.old_rmk.value = formObj.do_prn_rmk.value;

	}else{

		formObj.do_prn_rmk.value = "";
		formObj.old_rmk.value = "";

	}


}