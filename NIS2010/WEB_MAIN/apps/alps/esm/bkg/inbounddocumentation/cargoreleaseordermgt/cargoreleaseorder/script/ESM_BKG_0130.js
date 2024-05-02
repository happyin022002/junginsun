/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1030.js
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
var dataRetrieved = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/** 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
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
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    /*******************************************************/
    var formObj = document.form;

    try
    {
        var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName)
        {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0],formObj, IBSEARCH);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObjects[0],formObj, MODIFY);
                break;
            case "btn_Close":
                if(isDataChanged())
                {
                	// Data was changed. Do you want to save it?
                    if(ComShowCodeConfirm("BKG95002"))  {  window.close(); }
                }
                else
                {
                    window.close();
                }

                break;
        } // end switch
    }
    catch(e)
    {
        if(e == "[object Error]")
        {
            ComShowMessage(OBJECT_ERROR);
        }
        else
        {
            ComShowMessage(e);
        }
    }
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
function validateForm(sheetObj,formObj,sAction)
{
    with(formObj)
    {
        switch(sAction)
        {
        case IBSEARCH:
               if (!ComChkObjValid(do_no)) return false;
            break;
        case MODIFY:
            if(!dataRetrieved)
            {
            	// D/O was not Assign yet !!
                ComShowCodeMessage("BKG00170");
                return false;
            }
            if(old_do_no.value != do_no.value)
            {
            	// Searching option was changed. Please retrive first.
                ComShowCodeMessage("BKG03053");
                return false;
            }

            if(old_rcvr_co_nm.value  != rcvr_co_nm.value)     return true;
            if(old_cntc_phn_no.value != cntc_phn_no.value)     return true;
            if(old_pic.value         != pic.value)             return true;
            if(old_act_cnee_nm.value != act_cnee_nm.value)     return true;
            if(old_cust_ref_nm.value != cust_ref_nm.value)     return true;

            // Nothing has been changed after data is retrieved
            ComShowCodeMessage("BKG00797");
            return false;

            break;
        }
    }
    return true;
}


/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj)
{
    sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
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
    axon_event.addListenerFormat("keypress","obj_KeyPress", document.form);
    axon_event.addListener("keydown","ComKeyEnter", "do_no");

    if(document.getElementById("do_no").value !='' ){
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
}

/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {int} sheetNo Sheet Index 번호
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
                style.height = 0;
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
                var prefix = "";
                InitDataProperty(0, cnt++ , dtStatus,    30,    daCenter,    false, prefix + "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,   40,       daCenter,     true,  prefix + "Seq");
                InitDataProperty(0, cnt++ , dtData,  170,      daCenter,     false, prefix + "mrn",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  110,      daCenter,     false, prefix + "vvd",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  100,      daCenter,     false, prefix + "pol",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  80,       daCenter,     false, prefix + "pod",      false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  75,       daCenter,     false, prefix + "office",   false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  75,       daCenter,     false, prefix + "userid",   false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  90,       daRight,      false, prefix + "blcount",  false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  60,       daCenter,     false, prefix + "ac",       false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  90,       daCenter,     false, prefix + "dt",       false, "",    dfNone, 0, true, true);
                InitDataProperty(0, cnt++ , dtData,  80,       daCenter,     false, prefix + "dt2",      false, "",    dfNone, 0, true, true);
                CountPosition = 0;
            }
        break;
    }
}

/**
 * Sheet관련 프로세스 처리
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {Object} formObj 필수, 폼개체
 * @param {String} sAction 필수, 작업코드
 * @param {String} CondParam 선택, 이전 조회 조건정보
 * @param {int} pageNo 선택, 페이지 번호
 * @return {void}
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
        if(!validateForm(sheetObj,formObj,sAction)) return;
        formObj.f_cmd.value = SEARCH;
        sheetObj.DoSearch("ESM_BKG_0130GS.do", FormQueryString(formObj));
        status = sheetObj.EtcData('status');
        if(status == 'no_data')
        {
            // No data found.
            ComShowCodeMessage("BKG00095");
            return;
        }
        else
        {
            formObj.bkg_no.value           = sheetObj.EtcData('bkg_no');
            formObj.rcvr_co_nm.value       = sheetObj.EtcData('rcvr_co_nm');
            formObj.cntc_phn_no.value       = sheetObj.EtcData('cntc_phn_no');
            formObj.pic.value               = sheetObj.EtcData('pic');
            formObj.act_cnee_nm.value       = sheetObj.EtcData('act_cnee_nm');
            formObj.cust_ref_nm.value       = sheetObj.EtcData('cust_ref_nm');
            formObj.order_flg.value       = sheetObj.EtcData('order_flg');

            formObj.old_do_no.value       = formObj.do_no.value;
            formObj.old_rcvr_co_nm.value  = formObj.rcvr_co_nm.value;
            formObj.old_cntc_phn_no.value = formObj.cntc_phn_no.value;
            formObj.old_pic.value         = formObj.pic.value;
            formObj.old_act_cnee_nm.value = formObj.act_cnee_nm.value;
            formObj.old_cust_ref_nm.value = formObj.cust_ref_nm.value;
            dataRetrieved = true;
        }
        break;
    case MODIFY:
        if(!validateForm(sheetObj,formObj,MODIFY)) return;
        formObj.f_cmd.value = MULTI;
        var sXml = sheetObj.GetSaveXml("ESM_BKG_0130GS.do", FormQueryString(formObj));
        status = ComGetEtcData(sXml, 'status');
        if(status == 'ok')
        {
        	// Data Saved Successfully!!
            ComShowCodeMessage("BKG00166");
            formObj.old_rcvr_co_nm.value  = formObj.rcvr_co_nm.value
            formObj.old_cntc_phn_no.value = formObj.cntc_phn_no.value
            formObj.old_pic.value         = formObj.pic.value
            formObj.old_act_cnee_nm.value = formObj.act_cnee_nm.value
            formObj.old_cust_ref_nm.value = formObj.cust_ref_nm.value
        	window.close();
            return true;
        }
        else
        {
        	// Data Save Action Failed!!
            ComShowCodeMessage("BKG00167");
            return false;
        }
        break;
    }
}


/**
 * 데이터 변경되었을 때의 처리
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Son Yunseok
 * @version 2009.10.01
 */
function isDataChanged()
{
    var formObj = document.form;
    try
    {
        if(formObj.old_rcvr_co_nm.value  != formObj.rcvr_co_nm.value) return true;
        if(formObj.old_cntc_phn_no.value != formObj.cntc_phn_no.value)return true;
        if(formObj.old_pic.value         != formObj.pic.value)          return true;
        if(formObj.old_act_cnee_nm.value != formObj.act_cnee_nm.value)return true;
        if(formObj.old_cust_ref_nm.value != formObj.cust_ref_nm.value)return true;
        return false;
    }
    catch(e)
    {
        return false;
    }
}

/**
 * TextArea 입력 최대길이 제어
 * @param {void}
 * @return {void}
 * @author Kim Soo Hyun
 * @version 2016.04.19
 */
function fncTextareaMaxLine(obj){
    var text_val 	 = obj;
    var text_val_len = text_val.length;

    //최대 100글자 && (문자키 || 스페이스키) 제한
    if(text_val_len > 99 && (event.keyCode > 47 || event.keyCode == 32)){
    	event.returnValue = false;
    }
}

