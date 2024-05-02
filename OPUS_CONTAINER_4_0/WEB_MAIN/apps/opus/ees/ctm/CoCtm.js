/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoCtm.js
*@FileTitle  : CTM 업무 공통 js 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
msgs["CTM99999"]='{?msg1}.';
msgs["CTM00000"]='Mandatory field is missing. Please enter {?msg1}.';
msgs["CTM00001"]='Date format is wrong. Please enter a valid date format..';
msgs["CTM00002"]='Please input [Value].';
msgs["CTM10001"]="Location doesn't exist";
msgs["CTM10002"]="Since event date/time is 3 hour later than now, movement status will not be reflected right now. Status will be updated around inputted event date/time.";
msgs["CTM10004"]="Container No. doesn't exist.";
msgs["CTM10005"]="Inactive Container No.";
msgs["CTM10006"]="Immediately Exit Container.";
msgs["CTM10007"]="Container is not located in this area.";
msgs["CTM10008"]="This is not a adequate container.";
msgs["CTM10009"]="Container can't be updated as TS. Please check previous movement status.";
msgs["CTM10010"]="Booking No. is combined to other booking No. {?msg1}.";
msgs["CTM10011"]="Booking No. was already cancelled.";
msgs["CTM10012"]="Please input \"Booking No.\"";
msgs["CTM10013"]="Server Provider doesn't exist.";
msgs["CTM10014"]="Chassis No. doesn't exist.";
msgs["CTM10015"]="M.G Set No. doesn't exist.";
msgs["CTM10016"]="Mode code is invalid.";
msgs["CTM10017"]="Booking No. doesn't exist.";
msgs["CTM10018"]="There is no problem to update.";
msgs["CTM10019"]="Container can’t be updated. Please refer the reason in remarks.";
msgs["CTM10022"]="{?msg1} was saved successfully.";
msgs["CTM10024"]="Unexpected system error occurred during data processing";
msgs["CTM10025"]="Event date should be between previous & following event date.";
msgs["CTM10027"]="VVD doesn't exist.";
msgs["CTM10029"]="IC / ID shouldn't be before VL, and OP / OC shouldn't be after VD.";
msgs["CTM10030"]="Please input the reason.";
msgs["CTM10031"]="You can't delete {?msg1}.";
msgs["CTM10032"]="Unexpected system error occurred during data processing. [Select CS SEQ & SPLIT From View Error !]";
msgs["CTM10033"]="Unexpected system error occurred during data processing. [Update CNTR_MOVE Error !(U)]";
msgs["CTM10034"]="Unexpected system error occurred during data processing. [Select Max ID Error !(I)]";
msgs["CTM10035"]="Unexpected system error occurred during data processing. [Select Level Error !(I)]";
msgs["CTM10036"]="Unexpected system error occurred during data processing. [Select New Flag Error !(D)]";
msgs["CTM10037"]="XX / MT status created on EQ master can't be deleted.";
msgs["CTM10038"]="Unexpected system error occurred during data processing. [Insert MOVE_CORR Error !(D)]";
msgs["CTM10039"]="Unexpected system error occurred during data processing. [Select Level Error !(D)]";
msgs["CTM10040"]="Unexpected system error occurred during data processing. [Select BKG_CNTR Error !(D_LVL1ii)]";
msgs["CTM10041"]="Unexpected system error occurred during data processing. [Select BKG_CNTR Error !(D_LVL1)]";
//msgs["CTM10042'] = "Booking Is Already Confirmed, You Can Detach Container & Booking At Booking Screen!(D_LVL1) ";
//msgs["CTM10043'] = "Delete BUFFER Error!(D_LVL1)";
msgs["CTM10044"]="Unexpected system error occurred during data processing. [Delete MOVE Error !(D)]";
//msgs["CTM10045'] = "Select Move Error!(Last)";
//msgs["CTM10046'] = "Unable To Return To The Original CNTR Status(New Van), Please Check The CNTR Status, Not The Movement Status! ";
msgs["CTM10047"]="Do you want to delete {?msg1}?";
msgs["CTM10048"]="[Value] was deleted successfully.";
msgs["CTM10049"]="Mandatory field is missing. Please enter {?msg1}";
msgs["CTM10050"]="B/L No. doesn't exist.";
msgs["CTM10051"]="Too many rows were selected. It must be below {?msg1} rows.";
msgs["CTM10052"]="Do you want to save [value] ?";
msgs["CTM10053"]="Event date should be earlier than now";
msgs["CTM10054"]="Event date can’t exceed +7 days from today";
msgs["CTM10055"]="ID shouldn't be updated to OP / OC.";
msgs["CTM20053"]="Event date should be later than now.";
msgs["CTM20054"]="Current status should not be VL, VD, EN, TN and MT";
msgs["CTM20056"]="CNTR should be \"Empty\" Status.";
msgs["CTM20057"]="Container should be located in origin yard.";
msgs["CTM20058"]="Replaced Container must exist.";
msgs["CTM20059"]="Unexpected system error occurred during data processing. [DUAL Select Error]";
msgs["CTM20060"]="Unexpected system error occurred during data processing. [LOC, LCC, RCC Select Error]";
msgs["CTM20061"]="Unexpected system error occurred during data processing.  [YARD Select Error]";
msgs["CTM20062"]="Unexpected system error occurred during data processing. [CONTAINER Select Error]";
msgs["CTM20063"]="Unexpected system error occurred during data processing. [CNTR_MOVE Select Error]";
msgs["CTM20064"]="Unexpected system error occurred during data processing. [CNTR_MOVE Update Error]";
msgs["CTM20065"]="Unexpected system error occurred during data processing. [CNTR_MOVE_SEQ Select Error]";
msgs["CTM20066"]="Unexpected system error occurred during data processing. [CNTR_MOVE Insert Error]";
msgs["CTM20067"]="Unexpected system error occurred during data processing. [CNTR_MVMT_XCH Insert Error]";
msgs["CTM20068"]="Unexpected system error occurred during data processing. [CNTR_MVMT_XCH_DTL Insert Error]";
msgs["CTM20069"]="You could correct VL movement from ? 3 days to today.";
msgs["CTM20070"]="You could correct VL / VD movement from ? 3 days to today.";
msgs["CTM20071"]="Please select only one row.";
msgs["CTM20072"]="Location is not under control of user's area.";
msgs["CTM20073"]="VVD Code doesn't exist.";
msgs["CTM20074"]="Please run \"pre check\" first.";
msgs["CTM20075"]="Container is not empty status in this yard.";
msgs["CTM20076"]="{?msg1} was already created.";
msgs["CTM20077"]="VD status can't be created due to different VVD or POD.";
msgs["CTM20078"]="Container can't be updated as TS. Please check previous movement status.";
msgs["CTM20080"]="Container can't be updated. Please refer to the reason in remark.";
msgs["CTM20081"]="Illegal Server ID!";
msgs["CTM20082"]="Domestic movement can be udpated on USA area only.";
msgs["CTM20083"]="Row can't be inserted after VL,VD.";
msgs["CTM20084"]="New status can'be created on this menu. Please use movement creation menu.";
msgs["CTM20085"]="Status can't be modified.";
msgs["CTM20087"]="Event date should be between previous & following event date.";
msgs["CTM20088"]="XX status can't be updated.";
msgs["CTM20090"]="XX & MT status which was created on EQ master can't be updated.";
msgs["CTM20091"]="VL, VD status can't be created on this menu.";
msgs["CTM20092"]="Location can't be changed";
msgs["CTM20093"]="VL, VD status can't be deleted. If VL, VD status is last one on this container, then it can be deleted.";
msgs["CTM20094"]="Please input remark.";
msgs["CTM20095"]="IC / ID shouldn't be before VL, and OP / OC shouldn't be after VD";
msgs["CTM20096"]="XX / MT status created on EQ master can't be deleted.";
msgs["CTM20097"]="Office code doesn't exist.";
msgs["CTM20098"]="Same container no. is only allowed when the container is replaced with 2 or more containers.";
msgs["CTM20099"]="VL status can't be created due to different VVD or POL.";
msgs["CTM20100"]="VVD of VL / VD should be same. Do you want to change VVD on VD too ?";
msgs["CTM20101"]="VVD of VL / VD should be same. Do you want to change VVD on VL too ?";
msgs["CTM20102"]="Status code is invalid.";
msgs["CTM20103"]="MT for new van can't be deleted while other status still remained. Please delete other status first.";
msgs["CTM20105"]="Same container can't used in case object container selected by \"MVMT History\"";
msgs["CTM20106"]="Same container no. is only allowed when the container is replaced with 2 or more containers.";
//restuffing popup 창 이용한 creation logic 수정 by 2015/06/01 황미연
//msgs["CTM20107"]="Last status can't be selected on MVMT History. Please input container no. in main screen.";
msgs["CTM20107"]="Restuffing have to be created at last movement.";
//end restuffing popup 창 이용한 creation logic 수정 by 2015/06/01 황미연
msgs["CTM20108"]="This row can't be modified.";
msgs["CTM20109"]="OP status can't be deleted. If OP status is last one on this container, then it can be deleted.";
msgs["CTM20110"]="If you upload a file, remained data will be disappeared. Do you want to upload a file ?";
msgs["CTM20111"]="Container check digit error";
msgs["CTM20112"]="Download could be possible under 10,000.";
msgs["CTM20113"]="Please check \"error message\". If you want to save again, please delete \"error message\" first.";
msgs["CTM10114"]="Duration date is wrong";
msgs["CTM10115"]="{?msg1} was downloaded successfully.";
msgs["CTM20115"]="The inputted M.G. Set No. is not registered or not active";
msgs["CTM20116"]="The inputted Chassis No. is not registered or not active! Do you want to save?"
msgs["CTM20117"]="Container is not \"MT\" or used by domestic.";
msgs["CTM20118"]="There is no Contents to save";
msgs["CTM20119"]="There is no previous status. Please create \"MT\" status first  from container master.";
msgs["CTM20120"]="Please delete termination status in Master first."
msgs["CTM20121"]="ID status can't be deleted. If ID status is last one on this container, then it can be deleted.";
msgs["CTM20122"]="TN / EN status can't be deleted. If TN / EN status is last one on this container, then it can be deleted.";
msgs["CTM20998"]="EQR Ref. No does not exist";	// [EES_CTM_0406] Reference No validation 추가 by 2015/06/12 황미연
msgs["CTM20999"]="Booking No does not exist";
msgs["CTM30001"]="Please select data";
msgs["CTM30002"]="Please check Empty CY.";
msgs["CTM30003"]="Please check P/D Date.";
msgs["CTM30004"]="Please check Q'ty.";
msgs["CTM30005"]="Empty CY is different.";
msgs["CTM30006"]="Are you sure? ";
msgs["CTM30010"]="{?msg1} was issued successfully.";    // [EES_CTM_0426] Release/Redelivery Order
msgs["CTM30011"]="{?msg1} Same data exist.";    // [EES_CTM_0426] Release/Redelivery Order
msgs["CTM30012"]="Maximum duration is {?msg1}";
msgs["CTM30013"]="VVD does not call POD/POL.";
msgs["CTM30014"]="There is no checked container No.";	// [EES_CTM_0433] Select Container No. Validation by 2015/06/01 황미연
msgs["CTM30015"]="Event date is earlier than last event date in CTM.";	// [EES_CTM_0433] Select Container No. Validation by 2015/06/01 황미연
msgs["CTM30016"]="Please attach OSCAR Booking to container in OSCAR {?msg1}";	// [EES_CTM_0406] CTM_BKG_CNTR 존재 여부 확인 by 2015/07/09 황미연
msgs["CTM30017"]="VVD doesn’t exist";
// Date Format Check 성공 여부 저장. Date + Time의 경우 사용 함.
var dateFormatFalse=0
var srcValue="";
var changedIndex=0;
// Event를 취소시키기 위해 사용. Tab키 이동에 의한 Focus 이동과 MaxLength에 의한 Focus이동을 구분하기 위해 사용함
var isCencelEvent=true;
// 현재 Key Event를 감지하기 위해 사용함.
var curKeyCode="";
var curEventElement="";
var curEventElementEvent="";
// EVENT리스트를 담아두기 위한 변수
var onShowErrMsg=false;
var eventSaction=[[null, null], [null, null], [null, null], [null, null], [null, null], [null, null], [null, null], [null, null], [null, null], [null, null], [null, null]];
var eventFaction=null;
var svrChk=null;
var cancelDate=false;
var queryString=[null, null];
// 병렬 처리시 최대 쓰레드 갯수 지정.
// RowStatus를 기준으로 처리 할 경우 갯수 지정 할 수 없음.
// (미리 얻어오는데 소요되는 시간이 처리하는 시간보다 더 클 우려가 있음)
var maxThreadCount=10;
var sendRows=100;    // 한번에 보내는 row갯수 [기본: 100]
var sendCount=0;     // 보낸갯수
var errCount=0;      // 리턴되는 결과중 error갯수
/**
 * 서버에서 넘겨받은 컨테이너정보중 Type Size , Check Digit를 Input에 입력하기 위해 사용함.
 * @param CTNRNO  : 서버에서 리턴된 컨테이너 정보 String
 * @param formObj : form object
 */
function parseCTNRNo(CTNRNO, formObj) {
    if (!CTNRNO) return;
    var CtnrVal=CTNRNO.split("|");
    if (CtnrVal.length >= 3) {
//        if (formObj.check_digit) {
//            formObj.check_digit.value=CtnrVal[0].substring(10,11);
//        }
        if (formObj.ctnr_sts_cd) {
            formObj.ctnr_sts_cd.value=CtnrVal[1];
        }
        if (formObj.ctnr_tpsz_cd) {
            formObj.ctnr_tpsz_cd.value=CtnrVal[2];
        }
    } else {
//        if (formObj.check_digit) {
//            formObj.check_digit.value="";
//        }
        if (formObj.ctnr_sts_cd) {
            formObj.ctnr_sts_cd.value="";
        }
        if (formObj.ctnr_tpsz_cd) {
            formObj.ctnr_tpsz_cd.value="";
        }
    }
}
/**
 * FORM의 모든 객체에 대하여 Enter값을 처리하기 위한 KeyDown Event 설정.
 * 사용 안함
 */
function setEnterEvent() {
    docForm=document.form;
    len=docForm.elements.length - 1;
    for (i=0 ; i <= len ; i++) {
        formElement=docForm.elements[i];
        nam=formElement.name;
        if (nam == '') nam=formElement.id;
        if (nam.substring(0, 5) != "sheet") {
            axon_event.addListener('keydown', 'body_onkeydown', nam);
        }
        if (nam.substring(0, 6) == "p_date") {
            //axon_event.addListener("blur", "date_focusout", nam);
            //axon_event.addListener("keyup", "date_keyup", nam);
            //axon_event.addListener("focus", "date_focus", nam);
        }
    }
}
/**
 * 달력INPUT에 focus시 선택한 상태로 바꿈.
 */
function date_focus(event) {
    var obj = ComGetEvent();
    obj.select();
    obj.focus();
}
/**
 * 달력INPUT에 Key Up시 길이를 확인 후 다음 엘리먼트로 넘겨주고 포맷을 맞춘다.
 */
function date_focusout(event) {
    if (dateFormatFalse == 0) {
        checkDate(ComGetEvent());
    }
}
/**
 * 달력INPUT의 Value길이가 8자리가 되면 checkDate
 */
function date_keyup(event) {
    obj=ComGetEvent();
    objValue=obj.value;
    dateFormatFalse=1;
    // deleting '-'
    objValue=ComGetUnMaskedValue(objValue, "ymd")
    if (objValue.length == 8) {
        checkDate(obj);
        dateFormatFalse=0;
    }
}
function checkDate(obj) {
    obj=ComGetEvent();
    objValue=obj.value;
    // deleting '-'
    objValue=ComGetUnMaskedValue(objValue, "ymd")
    if (!ComIsDate(objValue)) {
        ComShowCodeMessage("CTM00001");
        obj.value=objValue;
        obj.select();
        obj.focus();
        return;
    } else {
        objValue=ComGetMaskedValue(objValue, "ymd");
        obj.value=objValue;
        if (obj.name == "p_date1") {
            document.form.p_date2.select();
            document.form.p_date2.focus();
        }
    }
}
/**
 * 엔터 입력 시 자동 Retrive를 실행하기 위한 메소드
 * @param keyCode
 */
function body_onkeydown(keyCode) {
    sheetObject=sheetObjects[0];
    formObject=document.form;
    // Enter Key가 아니면 실행을 중단한다.
    try {
        if (ComGetEvent("keycode") != 13) return;
    } catch (e) {
        if (keyCode != 13) return;
    }
    // Enter는 Retrive를 실행한다. 다음에 이루어 져야하는 모든 이벤트를 중단하도록 flag 설정
    isCencelEvent=true;
    docForm=document.form;
    len=docForm.elements.length - 1;
    for (i=0 ; i <= len ; i++) {
        formElement=docForm.elements[i];
        nam=formElement.name;
        // 모든 Input에 대한 Class 를 체크한다. Class가 input1인 경우 필수 항목으로 간주하고 비어 있을 경우
        // 실행을 중단하고 메시지를 출력한다. (setMsg)
        if (formElement.className == "input1") {
            if (formElement.value.length < 1) {
                setMsg(nam);
                return false;
            }
        }
    }
    // fireEvent를 발생시켜 자동 Retirve를 진행시킨다.
    var obj=ComGetObject("btn_retrieve");
    if (obj) $(obj).click();
}
/**
 * IBCombo 멀티콤보 데이터 세팅
 * @param YardCode
 * @param comboObj : 여러개의 Multi Combo가 있을 수 있기 때문에 ComboObject를 받아서 처리하도록 한다
 */
function parseYardMultiCombo(YardCode, comboObj) {
    if (!YardCode) return;
    var YardList=YardCode.split("^");
    comboObj.RemoveAll();
    for (i=0; i <= YardList.length; i++) {
        if (YardList[i]) {
            YardValue=YardList[i].split("|");
            comboObj.InsertItem(i, YardValue[0] + "|" + YardValue[1], YardValue[0]);
        }
    }
    comboObj.SetUseAutoComplete(1);
    //지원안함[확인요망]HANJIN: comboObj.ValidChar(2, 1);    // 영대문자 + 숫자만 입력
}
/**
* String으로 받은 Code값과 Text로 IBMultiCombo 생성
* Param ComboObj    : [ComboObject]
* Param CodeString    : [Combo의 Code값 (연결문자 : ^#^)]
* Param TextString    : [Combo의 Code값 (연결문자 : ^#^)]
*/
function parseMultiCombo(ComboObj, CodeString, TextString) {
    var ComboCodeList=CodeString.split("^#^");
    var ComboTextList=TextString.split("^#^");
    ComboObj.RemoveAll();
    for (var w=0; w<ComboCodeList.length-1; w++) {
        ComboObj.InsertItem(w, ComboTextList[w], ComboCodeList[w]);
    }
}
/**
 * 초기 구축시 생성된 메소드이나 현재는 사용하지 않음. 삭제는 금지.
 * @param {string} eventName    필수,이벤트명 중 맨앞의 "On"을 제외한 이벤트명
 * @param {string} functionName    필수,이벤트발생시 호출할 자바스크립트 함수명
 * @param {string} id1            필수,Html Object의 name 또는 id
 * @param {string} id2            선택,여러 Html Object의 이벤트시 실행할 메소드
 * @see ComEvent#addListenerForm
 * @see ComEvent#addListenerFormat
 */
comAddListener=function(eventName, functionName, id1, id2) {
    try {
        if (BrowserDetect.browser == "Explorer") {
            for (var i=2; i<arguments.length; i+=2) {
                //같은 name이나 id로 여러개가 있는 경우 getElementById는 하나만 처리하므로 getElementsByName으로 변경함
                var objs=document.getElementsByName(arguments[i]);
                for (var idx=0; idx<objs.length; idx++) {
                    eventFaction=functionName;
                    ord=objs[idx].getAttribute("tabIndex");
                    if (arguments[Number(i)+1].length > 1) {
                        eventSaction[i][0]=arguments[Number(i)];
                        eventSaction[i][1]=arguments[Number(i)+1];
                    }
                    objs[idx].attachEvent("onfocus", eval("getFocus"));
                    objs[idx].attachEvent("on" + eventName, eval("processFunc"));
                }
            }
        } else {
            for (var i=2; i<arguments.length; i++) {
                //ComGetObject(arguments[i]).addEventListener(eventName, eval(functionName), false);
            }
        }
    } catch(err) {
        ComFuncErrMsg("[ERROR] AXON ComEvent addListener : " + err.message );
    }
}
/**
 * IBCombo Object의 값 변경 처리
 * param : combo_obj ==> 콤보오브젝트
 */
function processFunc() {
    frst=eventFaction + "()";
    var rtn=0;
    try {
        if (isCencelEvent) {
            rtn=eval(frst);
        } else {
            rtn=1;
            isCencelEvent=true;
        }
        if (rtn) {
            for (i=0; i < eventSaction.length; i++) {
                srcName=eventSaction[i][0];
                srcFunc=eventSaction[i][1];
                if (srcName == ComGetEvent("name")) {
                    if (srcFunc.length > 0)
                        eval(srcFunc + "()");
                }
            }
        }
    } catch (e) {
    }
}
/**
 * 이미 입력 내용이 존재하고 있을 경우 키 이벤트를 막기위한 메소드
 * param : combo_obj ==> 콤보오브젝트
 */
function checkMaxLengthOrverWrite() {
    try {
        var obj=ComGetEvent();
        var maxLength=obj.getAttribute("maxlength");
        var newValue=obj.value;
        changedIndex=0;
        if (srcValue == null) srcValue="";
        if (srcValue == newValue) return 0;
        else if (newValue.length != maxLength) return 0;
        else if (obj.type == 'text' && newValue.length == maxLength && newValue == srcValue) return 0;
        else if (obj.type == 'text' && newValue.length == maxLength) {
            /**********************************************
            * 과거 이미 최대 값과 동일한 자료가 입력 되어 있다
            * 모든 이벤트를 취소한다.
            *************************************************/
            // 몇번째 자리를 바꾼건지 확인한다.
            for (i=1; i <= maxLength; i++ ) {
                if (srcValue.substring(i-1, i) != newValue.substring(i-1, i))
                    changedIndex=i;
            }
            // 바뀐 자리의 마지막 인덱스가 MaxLength와 동일하다면 keyUp Event를 실행한다.
            if (changedIndex == maxLength) {
                return 1;
            } else return 0;
        } else {
            return 1;
        }
    } catch (e) {
        alert ("checkMaxLengthOrverWrite :" + e)
        return 0;
    }
}
/**
 * YARD 이벤트
 * param : combo_obj ==> 콤보오브젝트
 */
function yard_onkeypress() {
    formObj=document.form;
    p_yard=formObj.p_yard1.value;
    if (p_yard.length == 5) {
        var sheetObj=sheetObjects[0];
        formObj.f_cmd.value=SEARCH11;
        xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj));
        sheetObj.LoadSearchData(xml,{Sync:1} );
        rtnValue=ComGetEtcData(xml, "rtnValue");
        parseYardMultiCombo(rtnValue, p_yard2);
    }
}
/**
 * Container No 이벤트
 * param : combo_obj ==> 콤보오브젝트
 */
function cntr_onkeypress() {
    frmObj=document.form;
    cntrno=frmObj.p_cntrno.value.toUpperCase();
    if (cntrno.length < 10) return;
//    frmObj.check_digit.value="";
    var sheetObj=sheetObjects[0];
    xml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntrno);
    rtnValue=ComGetEtcData(xml, "rtnValue");
    if (rtnValue == null) sheetObj.LoadSearchData(xml,{Sync:1} );
    parseCTNRNo(rtnValue, frmObj);
}
/**
 * TEXT 박스의 입력 형식 고정
 */
function obj_onkeypress() {
    switch(ComGetEvent("name")) {
        case "p_date0":
        case "p_date1":
        case "p_date2":
            // 숫자만 + "-"만 입력허용
            ComKeyOnlyNumber(ComGetEvent(), "-");
            break;
        default :
            ComKeyOnlyAlphabet("uppernum");
            break;
    }
}
/***********************************************************************
 * 메소드를 새로 만들면서 위에 정의된 메소드는 대부분 사용하지 않으나  *
 * 기본적인 메소드는 사용중이기 때문에 삭제하면 안됨                   *
 ***********************************************************************/
/**
 * FORM의 모든 객체에 대하여 Enter값을 처리하기 위한 KeyDown Event 설정.
 * eventObj 제외 대상
 */
function setEventProcess(eventObj) {
    var docForm=document.form;
    var len=docForm.elements.length - 1;
    var formElement=null;
    var elementName=null; 
    for (i=0 ; i <= len ; i++) {
        /** 전체 Element 객체중 현재 커서가 가있는 Element 를 얻어온다. */
        formElement=docForm.elements[i];
        elementName=getSrcElementName(formElement);
        if (elementName=="") continue;
        /**************************************************************************
         *   EVENT를 선택적으로 타게 하기 위해 eventObj와 elementName을 비교하고  *
         *  동일한 Element에 대해서 Event Skip                                    *
         **************************************************************************/
        isFind=false;
        switch(elementName){
            case "sheet":
            case "sheet1":
            case "sheet2":
                if (BrowserDetect.browser == "Explorer") {
                    formElement.attachEvent("onblur", eval( elementName + "_blur"));
                } else {
                    formElement.addEventListener("blur", eval( elementName + "_blur"), false);
                }
                isFind=true;
                break;
            default:
                if(arguments.length) {
                    for (j=0; j <= arguments.length; j++) {
                        if (elementName == arguments[j]) {
                            isFind=true;
                            break;
                        }
                    }
                }
                break;
        }        
        if (isFind == true)  continue;
        
        switch(formElement.type){
            case "password":
            case "text":
            case "textarea":
                /** 이벤트를 설정하기 위하여 Element List를 생성한다. */
                /** 이벤트는 KeyPress 와 KeyUp만 사용하도록 지정한다. */
                //formElement.value="111111";
                if (BrowserDetect.browser == "Explorer") {
                    formElement.attachEvent("onkeypress", obj_keypress);
                    formElement.attachEvent("onkeyup", obj_keyup);
                    formElement.attachEvent("onkeydown", obj_keydown);
                    formElement.attachEvent("onfocus", date_focus);
                    formElement.attachEvent("onblur", obj_blur);
                } else {
                    formElement.addEventListener("keypress", obj_keypress, false);
                    formElement.addEventListener("keyup", obj_keyup, false);
                    formElement.addEventListener("keydown", obj_keydown, false);
                    formElement.addEventListener("focus", date_focus, false);
                    formElement.addEventListener("blur", obj_blur, false);

                }
                break;
        }
        
    }
}
/**
 * 객체를 받아 객체의 이름을 리턴한다.
 */
function getSrcElementName(formElement) {
    return formElement.name || formElement.id;
}
/**
 * Key Down에 대한 이벤트. TAB을 제외한 모든 키는 무시한다
 * tab이 눌려진 Object의 이름이 cntr_no이거나 date이면
 * 포맷 체크를 실행한다.
 * date가 from-to로 구성된경우도 포맷체크를 실행한다.
 */
function obj_keydown(event) {
     if (ComGetEvent("keycode") == "9") {
        curKeyCode="9";
        try {
            formElement=ComGetEvent();
            formElement.value=formElement.value.toUpperCase();
            elementName=getSrcElementName(formElement);
            if (elementName == "p_cntrno") {
                if (cntr_search()) {
                    return;
                } else {
                    tmp=setFocusIndex (formElement, 0);
                    formElement.select();
                    formElement.focus();
                    return false;
                }
            } else if (elementName.substring(0, 6) == "p_date") {
                if (formElement.value.length == 8) {
                    formElement.value=ComGetMaskedValue(formElement.value, "ymd");
                    dateFormatFalse=0;
                    cancelDate=true;
                }
            } else {
                obj_keyup (event);
            }
            return;
        } catch (e) {}
    }else if (ComGetEvent("keycode") == "8") {
        try {
            formElement=ComGetEvent();
            elementName=getSrcElementName(formElement);
            if (elementName == "p_cntrno") {
                frmObj=document.form;
                cntrno=frmObj.p_cntrno.value.toUpperCase();
                if (cntrno == "") {
//                    if (typeof(frmObj.check_digit) == "object") frmObj.check_digit.value="";
                    if (typeof(frmObj.ctnr_tpsz_cd) == "object") frmObj.ctnr_tpsz_cd.value="";
                    return;
                }
            }
        } catch (e) {}
    }
}
/******************************************
 * FOCUS가 빠져나갈 때 포맷체크를 실행한다*
// ******************************************/
function obj_blur(event) {
    try {
        formElement=ComGetEvent();
        formElement.value=formElement.value.toUpperCase();
        var elementName=getSrcElementName(formElement);
        if (elementName.substring(0, 6) == "p_date") {
            if (formElement.value.length < 8 && cancelDate == false) {
                rtn=checkDateFormat(formElement, elementName);
                dateFormatFalse=0;
            } else {
                formElement.value=ComGetMaskedValue(formElement.value, "ymd");
                return;
            }
        } else {
            obj_keyup(event);
        }
    } catch (e) {}
}
/**
 * KeyPress에 대한 이벤트 처리
 */
function obj_keypress(event) {
    /** 대소문자, 숫자등 타입에 관련된 내용을 실행한다. */
    obj_FormatString(event);
    /** 엔터키가 입력되거나 탭키가 입력 되었을 경우의 이벤트를 처리한다. */
    obj_enterProcess(event);
}
/*****************************************************************
 * 시간차를 위해 Sleep을 주기 위한 메소드였으나 미사용 으로 전환 *
 *****************************************************************/
function delay(gap) {
    var then,now;
    then=new Date().getTime();
    now=then;
    while((now-then)<gap) {
        now=new Date().getTime();
    }
}
/*************************************************
 * Key Event를 감지하고 길이에 의한 Validation.  *
 * 또는 Key Code에 의한 Validation을 실행한다    *
 *************************************************/
function obj_keyup(event) {
    /** 입력된 내용의 길이를 구하고 최대값과 동일하면 자동 이벤트를 부른다 */
    var eventElement=ComGetEvent();
    //try {
        if (eventElement == null) return;
        if (eventElement.type != "text") return;
        var elementName=getSrcElementName(eventElement);
        var maxLength=eventElement.getAttribute("maxlength");
        var curValue=eventElement.value;
        // Focus를 넘길 것인지 결정하는 Boolean변수
        var flgNext=false;
        if (curEventElement == elementName && curEventElementEvent == event.type) {
            if (curEventElementEvent == "blur") {
                onShowErrMsg=false; // 동일 이벤트로 리턴 처리 했음.
                return;
            }
            curEventElementEvent=event.type;
        } else {
            curEventElementEvent=event.type;
        }
        curEventElement=elementName;
        /** 날짜에 관련 된 내용들이다. 날짜 처리를 해주도록 한다 */
        if (elementName.substring(0, 6) == "p_date") {
            obj=ComGetEvent();
            objValue=ComReplaceStr(obj.value,"-","");
            curKeyCode="";
            if (objValue.length == 8) {
                checkDateFormat(obj, elementName);
                dateFormatFalse=0;
                cancelDate=true;
            } else {
                cancelDate=false;
            }
            return;
        }
        // 입력된 내용이 null이고 Key Code가 Tab이면  포커스를 이동시키지 않고
        // 현재 위치에 고정하기 위해 TabIndex를 현재값으 -1로 처리해서 Focus를 넘겨준다
        if (curValue == null || curValue == "") {
            if (curKeyCode == "9") {
                tmp=GetObjectByTabIndex(eventElement.tabIndex-1);
                if (tmp == null) GetObjectByTabIndex(1);
                curValue=tmp.value;
            } else {
            }
            onShowErrMsg=false; // 길이 제한으로 리턴 처리 했음.
            if (curValue.length < 10 && elementName == "p_cntrno") {
//                if (typeof(form.check_digit) == "object") document.form.check_digit.value="";
                if (typeof(form.ctnr_tpsz_cd) == "object") document.form.ctnr_tpsz_cd.value="";
                if (curKeyCode != "9") return;
            }
            return;
        }
        if (srcValue != null && srcValue == curValue) {
            // 기존 문자열이 이미 존재 하고 있었다. 문자열이 완전히 바뀔 때까지 모든 이벤트 중지
            srcV=srcValue.substring(srcValue.length -1);
            curV=curValue.substring(curValue.length -1);
            // 마지막 문자가 동일하다. 이벤트를 보류하고 리턴한다. 그렇지 않은 경우 다음으로 진행
            // 그러나 키가 탭이라면 예외로 처리한다.
            if (curKeyCode == "9") {
                if (srcValue == curValue) {
                    onShowErrMsg=false;    // 동일 문자열 리턴처리.
                    //document.form.p_vvdcd.value ="3 " + event.type;
                    return;
                }
            } else if(srcV == curV) {
                onShowErrMsg=false;    // 마지막 문자열이 동일 리턴처리.
                //document.form.p_vvdcd.value ="4 " + event.type;
                return;
            }
        }
        if (maxLength == curValue.length || curKeyCode == "13") {
            if (srcValue == curValue) return;
            /** 입력된 문자열이 최대값과 동일함. 문자열에 따른 포맷 변환 */
            switch(elementName) {
                case "p_cntrno" :
                    flgNext=cntr_search();
                    break;
                case "p_yard1":
                    flgNext=yard_search();
                    break;
                default :
                    flgNext=true;
                    break;
            }
            /** 이벤트가 종료 된 후 다음으로 포커스를 옮겨준다 */
            if (flgNext) {
                if (curKeyCode == "9") {
                    // 탭키가 실행되어진 상태이다. 초기화 시키고 종료한다.
                    curKeyCode="";
                } else {
                    if (elementName == "p_yard1") {
                        p_yard2.Focus();
                    }
                    else {
                        objTmp=setFocusIndex(eventElement, 1);
                        try {
                            objTmp.focus();
                        } catch (e) {}
                    }
                    curKeyCode="";
                    return;
                }
            } else {
                if (curKeyCode == "9") {
                    // 탭키가 실행되어진 상태이다. 초기화 시키고 종료한다.
                    curKeyCode="";
                    try {
                        eventElement.select();
                        eventElement.focus();
                    } catch (e) {}
                } else {
                    curKeyCode="";
                    try {
                        eventElement.select();
                        eventElement.focus();
                    } catch (e) {}
                }
            }
        } else {
            switch(elementName) {
                case "p_cntrno" :
                    if (curValue.length < 10) {
//                        if (typeof(form.check_digit) == "object") document.form.check_digit.value="";
                        if (typeof(form.ctnr_tpsz_cd) == "object") document.form.ctnr_tpsz_cd.value="";
                        if (curKeyCode != "9") return;
                    }
                    break;
                case "p_yard1":
                    if (curValue.length < 5) {
                        if (typeof(p_yard2) == "undefined" ) break;
                        if (typeof(p_yard2) == "object") p_yard2.RemoveAll();
                    }
                    break;
                default :
                    flgNext=true;
                    break;
            }
        }
        //event.cancelbubble = true;
    //} catch (e) {
    //    ComFuncErrMsg ("오류가 발생 했음 :" + e + ":" + eventElement.name);
    //}
}
/**
 *탭 인덱스를 + 시키거나 - 시키도록 지정한다.
 */
function setFocusIndex(obj, idx) {
    var tmp=null;
    tmp=GetObjectByTabIndex(Number(obj.tabIndex) + Number(idx), idx);
    if (tmp != null) {
        tmp.focus();
    } else {
        tmp=GetObjectByTabIndex(1, 0);
    }
    return tmp;
}
/**
 * 이벤트 종료시 자동으로 탭을 옮겨 준다.
 */
function GetObjectByTabIndex(index, idx) {
    for (i=0; i < document.forms[0].length; i++) {
        tmp=document.forms[0].elements[i];
        if (tmp.tabIndex == index)
        {
            if (tmp.getAttribute("display") == "none") {
                index=Number(index) + Number(idx);
            } else
                return tmp;
        }
    }
    return null;
}
/**
 * Container No 이벤트
 * param : combo_obj ==> 콤보오브젝트
 */
function cntr_search() {
    frmObj=document.form;
    cntrno=frmObj.p_cntrno.value.toUpperCase();
    if (cntrno == "") {
        return;
    }
    if (cntrno.length < 10) {
//        if (typeof(frmObj.check_digit) == "object") frmObj.check_digit.value="";
        if (typeof(frmObj.ctnr_tpsz_cd) == "object") frmObj.ctnr_tpsz_cd.value="";
    }
    if (onShowErrMsg) {
        onShowErrMsg=false; //이미 동일한 오브젝트에 동일한 내용으로 이벤트를 수행 하였다.
        return false;
    }
    onShowErrMsg=true;
    var sheetObj=sheetObjects[0];
    xml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntrno);
    rtnValue=ComGetEtcData(xml, "rtnValue");
    if (rtnValue == null) {
//        if (typeof(frmObj.check_digit) == "object") frmObj.check_digit.value="";
        if (typeof(frmObj.ctnr_tpsz_cd) == "object") frmObj.ctnr_tpsz_cd.value="";
        sheetObj.LoadSearchData(xml,{Sync:1} );
        return false;
    }
//    frmObj.check_digit.value="";
    parseCTNRNo(rtnValue, frmObj);
    return true;
}
/**
 * YARD 이벤트
 * Yard Code Change혹은 Focus Out으로 발생하고 리턴은 true/ false만 해준다.
 */
function yard_search() {
    formObj=document.form;
    p_yard=formObj.p_yard1.value;
    if (p_yard.length == 5) {
        if (onShowErrMsg) {
            onShowErrMsg=false; //이미 동일한 오브젝트에 동일한 내용으로 이벤트를 수행 하였다.
            return false;
        }
        onShowErrMsg=true; // 체크 로직을 수행한다.
        var sheetObj=sheetObjects[0];
        formObj.f_cmd.value=SEARCH11;
        xml=sheetObj.GetSearchData("CTMCommonGS.do", FormQueryString(formObj));
        rtnValue=ComGetEtcData(xml, "rtnValue");
        svrChk=ComGetEtcData(xml, "svrChk");
        ofcChk=ComGetEtcData(xml, "ofcChk");
        obj= p_yard2;
        if (obj == null || obj == 'null') return false;
        if (rtnValue == null) {
            obj.RemoveAll();
            sheetObj.LoadSearchData(xml,{Sync:1} );
            return false;
        } else {
            parseYardMultiCombo(rtnValue, obj);
            return true;
        }
    } else return false;
}
/**
 * INPUT에 focus시 현재 내용을 저장.
 */
function getFocus() {
    // 멀티 콤보는 Value를 얻어 올 수 없다. 그대로 리턴한다.
    curKeyCode="";
    try {
        srcObj=ComGetEvent("name");
    } catch (e) {
        srcValue="";
        return;
    }
    cancelDate=true;
    try {
        var obj = ComGetEvent();
        if (obj.type == 'text') {
            srcValue=obj.value.split("-").join("");
            obj.value=srcValue;
        }
    } catch (e) {
        srcValue='';
    }
}
/**
 * 달력INPUT에 focus시 선택한 상태로 바꿈.
 */
function date_focus(event) {
    try {
        cancelDate=false;
        curKeyCode="";
        getFocus(event);
        ComGetEvent().select();
    } catch (e) {
    }
}
function obj_enterProcess (eventName) {
    /** MULTI COMBO는 event.keyCode를 인식하지 않는다 */
    try {
        if (ComGetEvent("keycode") != 13) return;
    } catch (e) {
        if (keyCode != 13) return;
    }
    /** 화면에서 가져와야 하는 자료가 있을 경우 처리 */
    curKeyCode="13";
    if (ComGetEvent() != null) {
        obj_keyup(event);
    }
    curKeyCode="";
    if (!checkFormField()) return;
    /** 필수 입력 사항을 확인 하고 난 이후 조회버튼이 눌려진 것처럼 동작한다. */
    var obj=ComGetObject("btn_retrieve");
    if (obj) $(obj).click();
}
/**
 * TEXT 박스의 입력 형식 고정
 */
function obj_FormatString (event) {
    switch(ComGetEvent("name")) {
        case "p_date0":
        case "p_date1":
        case "vvdcd_change":
        	if(document.form.vvdsts_change_combo.value != "REMARK"){ 
        		ComKeyOnlyAlphabet("uppernum");
        	}
        	break;
        case "p_date2":
            // 숫자만 + "-"만 입력허용
            ComKeyOnlyNumber(ComGetEvent(), "-", " ");
            break;
        default :
            // 영문 대문자와 숫자만 입력허용
            ComKeyOnlyAlphabet("uppernum");
            break;
    }
}
/***************************************
 * Date Format check.
 * from-to형태의 경우 기간체크를 겸한다
 ***************************************/
function checkDateFormat(obj, objName) {
    objValue=obj.value;
    // deleting '-'
    objValue=ComGetUnMaskedValue(objValue, "ymd");
    
    if (!ComIsDate(objValue)) {
        ComShowCodeMessage("CTM00001");
        obj.value=ComGetNowInfo(); //chrome54 infinite alert bug - initialize
        obj.select();
        obj.focus();
    } else {
        if (objName == "p_date1" || objName == "p_date2") {
            date1=ComGetObject("p_date1").value;
            date2=ComGetObject("p_date2").value;
            date1=ComGetUnMaskedValue(date1, "ymd");
            date2=ComGetUnMaskedValue(date2, "ymd");
            if (date1 == '' || date2 == '') return;
            if (date1 > date2) {
                //ComShowCodeMessage("CTM10114");
                ComShowCodeMessage("COM12133","From Date","To Date","earlier");
                cancelDate=true;
                obj.value=ComGetNowInfo(); //chrome54 infinite alert bug - initialize
                obj.focus();
                return;
            }
        }
        if (objName == 'p_date1') {
            document.form.p_date2.focus();
        } else {
            if (cancelDate == false)
                setFocusIndex(obj, 1);
        }
    }
}
/**************************************************************************************
 * 필수 입력 항목의 Validation을 처리한다
 * 필수입력은 class name이 input1인겻을기준
 * 메시지에 출력되는 이름은 별도 테그를 사용하면 바꿀 수 있으나 현재는 이름을 출력 함
 **************************************************************************************/
function checkFormField() {
    docForm=document.form;
    len=docForm.elements.length - 1;
    for (i=0 ; i <= len ; i++) {
        formElement=docForm.elements[i];
        nam=formElement.name;
        if (formElement.className == "input1") {
            try {
                formElement.value=formElement.value.toUpperCase();
                if (formElement.value.length < 1) {
                    setMsg(nam);
                    onShowErrMsg=false;
                    formElement.focus();
                    return false;
                }
            } catch (e) {}
        }
    }
    return true;
}
/**
 * 라인의 상태값 변경
 * param : sheetObj ==> 시트오브젝트, Row ==> Sheet Object의 라인 번호
 * 현재 선택된 라인의 Status 초기화
 */
function clearStatus(sheetObj, Row) {
    nowStatus=sheetObj.GetRowStatus(Row);
    if (nowStatus == 'I' || nowStatus == 'D') {
        return;
    } else {
        sheetObj.SetRowStatus(Row,"R");
    }
}
/**
 * 변경 추가된 라인의 배경 색 변경
 * param : sheetObj ==> 시트오브젝트, Row ==> Sheet Object의 라인 번호
 * 현재 선택된 라인의 색을 연두색으로 변경한다
 */
function changeColor(sheetObj, Row) {
    sheetObj.SetRowBackColor(Row,"#7CFC00");
    //alert (Row + "::::" + sheetObj.RowStatus(Row))
    // A/F가 C가 아니면 N으로 변경한다.
    Sts=sheetObj.GetCellValue(Row, 5);
    nowStatus=sheetObj.GetRowStatus(Row);
    if (Sts != 'C' && Sts != '' && Sts != 'M') {
        sheetObj.SetCellValue(Row, 5,'N');
    }
    if (nowStatus == 'I' || nowStatus == 'D') {
        return;
    } else {
        sheetObj.SetRowStatus(Row,"U");
    }
}
/**
 * Value, Column, Table을 Param으로 받아서 Value(rows data)를 가져옴
 * param : code_value, column_nm, table_nm
 */
function code_get(Return, Value, Column, Table) {
    if (!Value || !Column || !Table) return false;
    var sheetObj=sheetObjects[0];
    var rtnValue=ComSearchEtcData(sheetObj, "CTMCommonGS.do", "f_cmd=" + SEARCH18 + "&return_nm=" + Return + "&code_value=" + Value + "&column_nm=" + Column + "&table_nm=" + Table, "rtnValue");
    if (rtnValue == null) {
        return "";
    } else {
        return rtnValue.trim();
    }
}
/**
 * Value, Column, Table을 Param으로 받아서 Exist검사
 * param : code_value, column_nm, table_nm
 */
function code_search(Value, Column, Table) {
    if (!Value || !Column || !Table) return false;
    var sheetObj=sheetObjects[0];
    var coCtmXml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH19 + "&code_value=" + Value + "&column_nm=" + Column + "&table_nm=" + Table);
    var rtnValue=ComGetEtcData(coCtmXml, "rtnValue");
    if (rtnValue) {
        if (rtnValue == "1") {
            return true;
        } else {
            sheetObj.LoadSearchData(coCtmXml,{Sync:1} );
            return false;
        }
    } else {
        sheetObj.LoadSearchData(coCtmXml,{Sync:1} );
        return false;
    }
}
 /*
 Form의 모든 객체에 대해 disable 처리 (이미지 버튼 포함)
 Disable 처리를 원하지 않는 객체에는 disabletype="no" 를 붙여줌
 */
 function DomSetFormObjDisable(form, flag) {
     
     var elems = $(".wrap_search *");
     
     if (typeof (form) != "object") {
         ComFuncErrMsg("FORM 태그가 아닙니다.");
         return "";
     }
     
     for (var i=0; i < elems.length; i++){
        if(elems[i].getAttribute("disabletype") != "no" && elems[i].type != "hidden")
            elems[i].disabled=flag;
     }
 }
/**********************************************************************
 * Sheet에서 Focus가 빠져 나갈 때 Validation해야하는 Cell에 있을 때도 *
 * 그냥 빠져나가는 버그를 해결하기 위해 추가함                        *
 **********************************************************************/
 function sheet_blur() {
     var sheet=ComGetEvent();
     var row=sheet.GetSelectRow();
     var col=sheet.GetSelectCol();
     if (row == "") row=0;
     if (col == "") col=0;
     try {
         sheet_OnSelectCell(sheet, row, col, 0, 0);
         row=sheet.GetSelectRow();
         col=sheet.GetSelectCol();
         errorRow=-1;
         errorBack=-1;
     } catch (e) {
     }
 }
/**********************************************************************
 * Sheet에서 Focus가 빠져 나갈 때 Validation해야하는 Cell에 있을 때도 *
 * 그냥 빠져나가는 버그를 해결하기 위해 추가함                        *
 **********************************************************************/
 function sheet1_blur() {
     var sheet=ComGetEvent();
     var row=sheet.GetSelectRow();
     var col=sheet.GetSelectCol();
     if (row == "") row=0;
     if (col == "") col=0;
     try {
         sheet1_OnSelectCell(sheet, row, col, 0, 0);
     } catch (e) {
     }
 }
/**********************************************************************
 * Sheet에서 Focus가 빠져 나갈 때 Validation해야하는 Cell에 있을 때도 *
 * 그냥 빠져나가는 버그를 해결하기 위해 추가함                        *
 **********************************************************************/
 function sheet2_blur() {
     var sheet=ComGetEvent();
     var row=sheet.GetSelectRow();
     var col=sheet.GetSelectCol();
     if (row == "") row=0;
     if (col == "") col=0;
     try {
         sheet2_OnSelectCell(sheet, row, col, 0, 0);
         errorRow=-1;
         errorBack=-1;
     } catch (e) {
     }
 }
/*****************************************************************
 * 조회 버튼 클릭 시 ALERT MESSAGE를 출력해야 할 경우 FILED NAME *
 * 대신 출력해야하는 문자열이 있을 경우 설정한다. 해당없는 경우  *
 * Field Name을 출력하게 된다                                    *
 *****************************************************************/
function setMsg(name) {
   if (name.substring(0, 6) == "p_yard")
       ComShowCodeMessage("CTM00000", "yard cd");
   else if (name.substring(0, 6) == "p_cntr")
       ComShowCodeMessage("CTM00000", "container");
   else if (name.substring(0, 5) == "p_vvd")
       ComShowCodeMessage("CTM00000", "vvd code");
   else if (name.substring(0, 6) == "p_date")
       ComShowCodeMessage("CTM00000", "date");
   else if (name.substring(0, 8) == "p_office")
       ComShowCodeMessage("CTM00000", "Office");
   else
       ComShowCodeMessage("CTM00000", name);
}
/************************************************************************
 * 대량 자료를 처리할 때 속도문제가 있어 병렬처리(데이타를 조각내서 보냄*
 * 를 위해 AJAX를 호출한다.                                             *
 ************************************************************************/
function xmlHttpPost(actionUrl, submitParameter, resultFunction, target) {
    if (target == null || target == "undefined"){target="0";}
    var xmlHttpRequest=window.ActiveXObject ?  new ActiveXObject("Microsoft.XMLHTTP"): new XMLHttpRequest();
    
    xmlHttpRequest.open("POST", (actionUrl), true);
    xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    xmlHttpRequest.send(submitParameter);
    xmlHttpRequest.onreadystatechange=function() {
        if(xmlHttpRequest.readyState == 4) {
            switch (xmlHttpRequest.status) {
                case 200:
                    eval(resultFunction + "(xmlHttpRequest.responseText, "+ target +");");
                    break;
                case 404:
                    alert("오류: " + actionUrl + "이 존재하지 않음");
                    break;
            }
        }
    }
}
/**
 * <br><b>Example :</b>
 * <pre>
 *     sXml = getFastString(sheetObj, 1, 100, true);
 * </pre>
 * @param {ibsheet}    sheetObj    필수, IBSheet Object ID
 * @param {int}        startRow    필수, 리턴할 최초 Row Count.
 * @param {int}        endRow      필수, 리턴할 마지막 Row Count. sendType이 true일 경우 반환 Row 수
 * @param {bool}       sendType    필수. true일 경우 트랜젝션 처리데이터만 반환. false일 경우 전체 반환
 * @return string[]    Sheet의 데이터를 구성한 문자열. 0 : endRowCount. 1 : queryString
 */
function getFastString(sheetObj, startRow, endRow, sendType) {
    var saveString="";
    var checkColName=false;
    var rowSaveString="";
    with (sheetObj) {
        queryString[0]=0;
        if (LastRow()< 1) return;
        if (sendType) {   // 지정 row중 트랜젝션 처리데이터만
            var selfJnCount=0;
            for (i=startRow; i <= LastRow(); i++) {
                if (GetRowStatus(i) != "R") {
                    saveString += (RowSaveStr(i) + "&");
                    selfJnCount++;
                }
                if (selfJnCount == endRow || i == LastRow()) {
                    if (selfJnCount > 0) {
                        queryString[0]=i;
                        saveString=saveString.substring(0, saveString.length-1);
                        queryString[1]=saveString;
                    }
                    break;
                }
            }
            return queryString;
        } else {   // 지정 row 전체
            for (i=startRow; i <= endRow; i++) {
                saveString += (RowSaveStr(i) + "&");
            }
            saveString=saveString.substring(0, saveString.length-1);
            return saveString;
        }
    }
}
/**
 * MultiCombo(MultiSelection허용)의 MultiSelection OnCheckClick 이벤트 처리
 *  HTML object가 있을경우 쿼리의 In 조건에 사용가능한 "('A', 'B', 'C')" 형식을 setting
 */
function multiComboOnCheckClick(comboObj, index, htmlObj) {
    // 선택된 Index가 없을 경우는 0번 Index 강제 선택
    if (comboObj.GetSelectText()== null || comboObj.GetSelectText()== "") {
        comboObj.SetItemCheck(0,1,false);
        if (typeof(htmlObj) == "object") htmlObj.value="";
    } else {
        // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
        if (index == 0) {
            for(var i=1; i<comboObj.GetItemCount(); i++) {
                comboObj.SetItemCheck(i,0,false);
            }
            // Submit할 내용도 Clear
            if (typeof(htmlObj) == "object") htmlObj.value="";
        // 다른Index가 선택된 경우는 Index 0을 해제
        } else {
            comboObj.SetItemCheck(0,0,false);
            // Submit할 내용 Define
            if (typeof(htmlObj) == "object") htmlObj.value="'" + ComReplaceStr(comboObj.GetSelectCode(), ",", "', '") + "'";
        }
    }
}