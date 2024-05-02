/*=========================================================
 * History
 * 2011.02.21 김상수 [CHM-201108827-01] 1. R.month/Week 및 OPR/OPR2 정보 보여주는 컬럼 추가
 *                                      2. Re-Assignment by bound, Re-Assignment by bound(OP4)
 *                                         화면상에서 틀고정 기능 추가
 *                                      3. js상의 validation함수 정리 및  coMas.js로 소스이동
 * 2011.03.02 김상수 [CHM-201109144-01] js상의 validation함수 정리 및  coMas.js로 소스이동
 * 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
 *                                      - 공통메소드중 ESM_MAS_0029에서 호출되지 않아야 할 기능 수정
 * 2011.05.26 최성민 [CHM-201006017-01] MAS 약정율 로직 추가 - masPeriod() 함수 수정
 * 2011.06.02 최성민 [CHM-201111115-01] Split 02-Split 03-ALPS Error 처리 요청  -  메세지 추가(MAS00001~)
 * 2011.06.22 김민아 [CHM-201111640-01] chkWM()에서 ESM_MAS_0060 UI인 경우 해당 js에서 처리하는 로직 추가
 * 2011.07.01 이석준 [CHM-201111498-01] 메세지 추가,MAS10060,MAS00003
 * 2011.10.07 최성민 [CHM-201113373-01] 메세지 추가,MAS10061
 * 2011.11.01 최성민 [CHM-201114173-01] 메세지 추가,MAS10062
 * 2012.01.02 최성민 [CHM-201114896-01] ComTextCode2ComboItem() 추가 * 
 * 2012.01.31 김종준 [CHM-201215754-01] MAS10063,MAS10064 메세지 추가 
 * 2012.04.24 이석준 [CHM-201217454] Office report vs QTA 메뉴의 Special 적용 대상 변경
 * 2012.06.25 이석준 [CHM-201218363-01] P&L by Lane Report data creation 기능 추가
 * 2012.08.29 이석준 [CHM-201219872]   Inquiry by customized condition_MT Pick up Location 등 메뉴 추가
 * 2012.12.13 송호진 [CHM-201221879] [MAS] Manual Cost Set up 화면 로직 수정
 * 2012.01.02 최윤성 [CHM-201222075-01] 메세지 추가,MAS10067
 * 2013.07.10 성미영 [CHM-201325516] Split 01-[MAS] Customer Segmentation 관련 변경사항 MDM DB 변경 
 * 2013.11.13 김수정 [CHM-201327494] [MAS] 2013년 하반기 통합로그 결함 복구
 * 2013.12.13 김수정 [CHM-201328111] [MAS] EMU COST 변경 로직 Pre CM 반영 요청 - DEL Code, DEL Term 에 따른 MT Return CY 조회 추가 
 * 2016.03.14 김성욱  OOME 발생 방지를 위한 검색 제약조건 강화
 * 2016.03.16 Create Lane Table, Create Vessel Table history 자동 관리
*=========================================================*/
 
    // MAS 추가 메세지 
    msgs['MAS10001'] = 'Please enter correct date.\n\n Format : YYYY-WW';
    msgs['MAS10002'] = 'Please enter {?msg1}.'; 
    msgs['MAS10003'] = '{?msg1} can be processed only {?msg2}.';
    msgs['MAS10004'] = '{?msg1} is invalid PORT.';
    msgs['MAS10005'] = 'There is no data retrieved on {?msg1}.\n\n Please retrieve {?msg1} first.';
    msgs['MAS10006'] = 'Process completed.';
    msgs['MAS10007'] = 'A maximum of {?msg1} weeks can be entered.';
    msgs['MAS10008'] = 'Can not exceed {?msg1}.';
    msgs['MAS10009'] = 'Please enter {?msg1} correctly.\n\n Format : {?msg2}';
    msgs['MAS10010'] = 'Please enter group name to save.';
    msgs['MAS10011'] = '{?msg2} of {?msg1} should be equal to or less than {?msg3}.';
    msgs['MAS10012'] = '{?msg2} of {?msg1} should be equal to {?msg3}.';
    msgs['MAS10013'] = 'It differs from number of {?msg1}.';
    msgs['MAS10014'] = 'Please save {?msg1} first.';
    msgs['MAS10015'] = 'Please check {?msg1} first.';
    msgs['MAS10016'] = '3rd value of {?msg1} differs from {?msg2}.';
    msgs['MAS10017'] = 'Can create after retrieve.';
    msgs['MAS10018'] = '{?msg1} process has been completed normally.';
    msgs['MAS10019'] = 'Do you want to create selected data?';
    msgs['MAS10020'] = 'Do you want to create data?';
    msgs['MAS10021'] = 'Do you want to reset data?';
    msgs['MAS10022'] = 'There are {?msg1} data on saved vessel information.\n\n Please check.';
    msgs['MAS10024'] = 'It can not be exceeded by {?msg1} weeks.\n\n Please select {?msg2} data.';
    msgs['MAS10025'] = 'Do you want to execute BSA batch?';
    msgs['MAS10026'] = 'Please select {?msg1}.';
    msgs['MAS10027'] = '{?msg1} is invalid VVD or has no ETD.';
    msgs['MAS10028'] = 'Do you want to delete the selected data?';
    msgs['MAS10029'] = 'You can delete maximum number in the same group.';
    msgs['MAS10030'] = 'It is impossible to delete under level X.';
    msgs['MAS10031'] = 'It is impossible to delete level X.';
    msgs['MAS10032'] = 'Please select a line with a Route No. when there are more than two Route.';
    msgs['MAS10033'] = 'Do you apply to P/L Chart?' ;
    msgs['MAS10034'] = 'You can only retreive the Sales Office, Sub Ofc 1, Sub Ofc2 Level.' ;
    msgs['MAS10035'] = 'Please choose within the same terminal only.' ;
    msgs['MAS10036'] = 'Do you wish to apply BSA 0 function?';
    msgs['MAS10037'] = 'The data earlier than July 2007 and 27wk 2007 are not available.\nPlease refer to DW, CRM, etc.';
    msgs['MAS10038'] = 'The inquiry period is limited to {?msg1}.';
    msgs['MAS10039'] = 'You can add rows after retrieving data.';
    msgs['MAS10040'] = 'There is no relevant data.';
    msgs['MAS10041'] = 'You are reqeusted to insert proper Port or Lane code to apply Temp P/C.';
    msgs['MAS10042'] = 'Requested Temp Route is alreayd registered.\nPlease check and use actually registered Route.';
    msgs['MAS10043'] = 'vessel code [{?msg1}] is duplicated. Please enter another code.';
    msgs['MAS10044'] = 'Slot Price is missing.';
    msgs['MAS10045'] = 'There is already Route Projection data.';
    msgs['MAS10046'] = 'Durations are not match.\pPlease calculation again after control sheet data .';
    msgs['MAS10047'] = 'Please make Route Projection Data before Saving.';
    msgs['MAS10048'] = 'Please fill in frequency data.';
    msgs['MAS10049'] = '1st save is successed.';
    msgs['MAS10050'] = '2st save is successed.';
    msgs['MAS10051'] = 'Source month can\'t be preceded by target month \nor shouldn\'t be the same as target month.';
    msgs['MAS10052'] = 'Do you want to Copy From Source Data To Target Data?';
    msgs['MAS10053'] = 'It\'s not possible to proceed with "CREATION" when the selected date is before the creation date';
    msgs['MAS10054'] = 'Pass word is missing. Will you close this window?';
    msgs['MAS10055'] = 'Wrong password. Please try again ';
    msgs['MAS10056'] = 'OP is not available for Trade Profit.';
    msgs['MAS10057'] = 'Port tariff creation has been restricted for the past period before October2010 or week40 of y2010.\nYou may inquire the past tariff before week40 of y2010 but can\'t re-create the old tariff.';
    msgs['MAS10058'] = 'This class is not empty';
    msgs['MAS10059'] = 'There is no unit cost registered on this route. Please contact NOA for correct rate quotation.';
    msgs['MAS10060'] = 'Zero Amount can not be saved!!.';
    msgs['MAS10061'] = 'Creation is not allowed before WK 40, 2011 due to system logic change.';
    msgs['MAS10062'] = 'If a route cost is not displayed(found), please check the Pre CM/OP Simulation menu.\nIf the problem continues, please contact NOA for further assistance.';
    msgs['MAS10063'] = 'Target VVD Sent to FCM - Completed';
    msgs['MAS10064'] = 'Do you want to VVD Send?';
    msgs['MAS10065'] = 'Please check one. RF only or Special only';
    msgs['MAS10066'] = '{?msg1} Request is submitted.\nPlease wait for {?msg2} minutes to create data.';
    msgs['MAS10067'] = 'Please check one.\nCore Customer or Regional Customer or Local Customer.';
    msgs['MAS10068'] = '{?msg1} must be inputted';
    msgs['MAS10069'] = 'Average RPB was created. \n\n Do you want to create data?';
    msgs['MAS10070'] = 'Data will be changed, will you continue ?';
//    msgs['MAS10071'] = '{?msg1} is invalid Vessel.';
//    msgs['MAS10072'] = 'Source week can\'t be preceded by target week \nor shouldn\'t be the same as target week.';
    msgs['MAS10073'] = 'Your booking is under Network Constraint in PRD.\nLocation (USIWS : DEL) - ITEM(Others) - Remark((COE\'s Request)\nThis location is not allowed for import due to reduction of M/B cost.)\n- SVC(N)';
    msgs['MAS10074'] = '\'RF\' option should not be checked for RD container.';
    msgs['MAS10075'] = 'Please enter one. BKG No. or CNTR No.';
    msgs['MAS10076'] = 'Please check the history. Errors in dates.';
    
    msgs['MAS00001'] = 'BackEndJob Request Fail!';
    msgs['MAS00002'] = 'Created BackEndJob File exist already!';
    msgs['MAS00003'] = '{?msg1} is Processing...';//Batch Processing 이 진행 중임을 표시
    msgs['MAS00004'] = '{?msg1} saved successfully.';
    msgs['MAS00005'] = '{?msg1} is failed. Please {?msg2} again.';
    msgs['MAS00006'] = 'Do you want to save?';
    msgs['MAS00007'] = 'There is no contents to save.';
    msgs['MAS00008'] = 'When you search Rating Date, You can not seach the Month.';
    msgs['MAS00009'] = 'When you search Rating Date, only week period can be selected.';
    msgs['MAS00010'] = 'Sub trade selection is mandatory.';
    msgs['MAS00011'] = "At least one row needs to be selected";
    msgs['MAS00012'] = 'Pls input {?msg1}!';
    msgs['MAS00013'] = 'Please input {?msg1}'; 
    msgs['MAS00014'] = 'Please select Day Filter';
    msgs['MAS00015'] = '{?msg1} is duplicated';
    msgs['MAS00016'] = 'Data saved successfully.';


    msgs['MAS29031'] = 'Invalid RCC Code.';
    msgs['MAS29032'] = 'Invalid LCC Code.';
    msgs['MAS29033'] = 'Invalid ECC Code.';
    msgs['MAS29034'] = 'Invalid SCC Code.';
    msgs['MAS29037'] = 'Invalid Location Code.';
    /**
     * 화면에서 Enter클릭시 Retrieve를 처리하도록함.
     *   <form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
     *
     */
    function keyEnter(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        if(event.keyCode == 13){
            doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
    }

    /**
     * depSheet1 : sheet1에 종속적인지 여부
     *
     * 만약 depShett1 이 true이면 sheet1에 값이 없는 경우 sheet2는 조회하지 않는다.
     */
    function keyEnter2(depSheet1){
        var sheetObj = sheetObjects[1];
        var formObj = document.form;
        if(depSheet1 == null) depSheet1 = false;
        if(event.keyCode == 13){
            if(depSheet1) {
                   if(sheetObjects[0].RowCount("R") >0){
                   doActionIBSheet2(sheetObj, formObj, IBSEARCH);
                   } else {
                     sheetObj.RemoveAll();
                   }
            } else {
               doActionIBSheet2(sheetObj,formObj,IBSEARCH);
            }
        }
    }

    /**
     * input box의 maxlength를 입력하면 input text의 길이와 maxlength를 체크하여 다음 컨트롤로 자동으로 이동한다.
     *      onKeyUp = "javascript:autoMoveTab(this, txtToDate);"
     *
     * @param obj1 : 이동 하기 전 input box
     * @param obj2 : 이동 할 input box
     */
    function moveTab(obj1, obj2){
        var keyValue = event.keyCode;

        if(obj1.maxLength == obj1.value.length &&
           keyValue != '9'                     &&            // Tab
           keyValue != '16'                    ){          // 역 Tab
            if (obj2.type == "text" ||  obj2.type == "password" || obj2.type == "textarea") {
                obj2.select();
            } else {
                obj2.focus();
            }
        }
    }

    /**
     * 영대문자만 입력되도록 함
     *    onKeyPress="onlyEng();"
     */
    function onlyEng(){
        var keyValue = event.keyCode;

        if((keyValue >= 97 && keyValue <= 122) || (keyValue >= 65 && keyValue <= 90)) {
            if(keyValue > 90) {
                event.keyCode = 65 + keyValue - 97;
            }
            event.returnValue = true;
        }else{
            event.returnValue = false;
        }
        return true;
    }

    /**
     * 영대문자와 숫자만 입력되도록 함
     *     onKeyPress="onlyEngNumber();"
     */
    function onlyEngNumber(){
        var keyValue = event.keyCode;

        if((keyValue >= 97 && keyValue <= 122) ||
           (keyValue >= 65 && keyValue <= 90)  ||
           (keyValue >= 48 && keyValue <= 57)  ||
            keyValue == 8 || keyValue == 46 || keyValue == 9) {
            if(keyValue > 90) {
                event.keyCode = 65 + keyValue - 97;
            }
            event.returnValue = true;
        }else{
            event.returnValue = false;
        }

        return true;
    }

    /**
     * 숫자와 dash(-)만 입력 가능하도록 한다
     */
    function onlyNumberDash(event){
        var keyValue = event.keyCode;
        /* 0 ~ 9 : 48 ~ 57, 키패드 0 ~ 9 : 96 ~ 105 ,8 : backspace, 46 : delete, 9 : tab */
        if((keyValue >= 48 && keyValue <= 57) || (keyValue >= 96 && keyValue <= 105) || keyValue == 8 || keyValue == 46 || keyValue == 9){
            event.returnValue = true;
        } else {
            event.returnValue = false;
        }
        return true;
    }

    /**
     * 숫자와 두번째 인자로 들어온 char만 허용
     */
    function onlyNumberDot(event){
        var keyValue = event.keyCode;
        // 0 ~ 9 : 48 ~ 57, 키패드 0 ~ 9 : 96 ~ 105 ,. : 190
        if((keyValue >= 48 && keyValue <= 57 ) ||
             ( keyValue >= 96 && keyValue <= 105) ||
             keyValue == 8 || keyValue == 46 || keyValue == 9|| keyValue == 190){
            event.returnValue = true;
        } else {
            event.returnValue = false;
        }
        return true;
    }

    /**
     * 날자의 유효성체크 후 dash입력하여 리턴한다.
     *
     * @param obj  object
     */
    function validDate(obj){
        var str = obj.value.replace(/\/|\-|\./g,"");

        if(obj.value.length>0){
            if(!ComIsDate(obj)){
                ComShowMessage(ComGetMsg("COM12132", "", ""));
            }else{
                addDateDash(obj);
            }
        }

    }

    /**
     * 입력값이 유효한 일자인지 확인하고
     * 일자 형식에 맞추어 Dash[-]를 추가한다.
     *
     * @param obj  object
     * @return 구분자가 추가된 일자 형식의 문자열
     */
    function addDateDash(obj){
        if (ComIsEmpty(obj)) return false;
        var numstr = obj.value.replace(/\/|\-|\./g,"");

        if (numstr.length < 6) {
            obj.value = '';
            ComShowMessage(ComGetMsg('MAS10009','Date','YYYYMM')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
            obj.focus();
            return false;
        } // end if
        if (numstr.length == 6){
            if (!isValidYYYYMM(obj)) return false;
            var rxSplit = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])');
            numstr = numstr.replace(rxSplit, '$1'+'-'+'$2');
        } else {
            if (!ComIsDate(obj)) return false;
            var rxSplit = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])');
            numstr = numstr.replace(rxSplit, '$1'+'-'+'$2'+'-'+'$3');
        } // end if
        obj.value = numstr;
        return true;
    }

    /**
     * 원하는 위치에 Dash를 넣어준다.
     *
     * @param obj object
     * @param dash를 넣을 위치
     */
    function addDash(obj, cnt){
        var value = obj.value.replace(/\/|\-|\./g,"");
        var rtnValue = "";

        if(value.length > cnt){
            rtnValue = value.substring(0, cnt)+"-"+value.substring(cnt);
            obj.value = rtnValue;
        }
    }

    /**
      * 입력된 문자열이 일자 Format YYYYWW이 맞는지를 확인 - (/, -, .) 제거되고 비교
     * @param obj        object
      * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
      * @param ch         세팅할 구분자('/', '-', .....)
      * @param isN        널스트링 허용여부
      * @return true 일자 , false
     */
    function isValidYYYYWW(obj , isSet, ch,  isN) {

       rtn = true;
        str = obj.value.replace(/\/|\-|\./g,"");
        if (!ComIsNumber(obj,"/") && !ComIsNumber(obj,"-") && !ComIsNumber(obj,"-")) rtn = false;
        if (str.length != 6) rtn = false;

        var year  = "";
        var week = "";

        if(rtn) {
          year  = str.substring(0,4);
          week = str.substring(4,6);

          if (ComParseInt( year ) >= 1900  && (ComParseInt(week)>0 && ComParseInt( week) <= 53)) rtn = true;
          else rtn = false;
        }

        if(rtn){
           if(isSet) obj.value = year + ch + week;
        } else {
            if(isN && str == '') {
              rtn = true;
            } else {
              ComShowMessage(ComGetMsg('MAS10001'));
              if(isSet) obj.value = "";
              obj.focus();
           }
        }
        return rtn;
    }

    /**
      * 입력된 문자열이 일자 Format YYYYMM이 맞는지를 확인 - (/, -, .) 제거되고 비교
      * @param obj        object
      * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
      * @param ch         세팅할 구분자('/', '-', .....)
      * @param isN        널스트링 허용여부
      * @return true 일자 , false
     */
    function isValidYYYYMM(obj , isSet, ch, isN) {

        rtn = true;
        str = obj.value.replace(/\/|\-|\./g,"");
        if (!ComIsNumber(obj,'/') && !ComIsNumber(obj, '-') && !ComIsNumber(obj, '-')) rtn = false;
        if (str.length != 6) rtn = false;

        var year = "";
        var month = "";

        if(rtn){
          year  = str.substring(0,4);
          month = str.substring(4,6);

          //1007년 데이터 처리를 위해, 1008년 데이터 처리 추가
          if((ComParseInt( year ) == 1007 || ComParseInt( year ) == 1008)  && ComIsMonth(month))  rtn = true;
          else if (ComParseInt( year ) >= 1900  && ComIsMonth(month)) rtn = true;
          else rtn = false;
        }

        if(rtn){
           if(isSet) obj.value = year + ch + month;
        } else {
           if(isN && str == '') {
              rtn = true;
            } else {
              ComShowMessage(ComGetMsg('COM12180'));
              if(isSet) obj.value = "";
              obj.focus();
           }
        }
        return rtn;
    }

    /**
     * 1을 001, 100로 세팅할 때 사용
     *     ex) onBlur="fillSpace(this, 2, '0', 'left');"
     *
     * str : 원본 문자열
     * spaceNum : 리턴 받고자하는 문자열의 총길이
     * spaceStr : 채울 값
     * flag :  왼쪽(left) 오른쪽(right)
     */
    function fillSpace(obj, spaceNum, spaceStr, flag){
        var i=0;
        var val = obj.value;
        var fillString = "";

        if(val.length>0){
            for(i=0;i<(spaceNum - val.length); i++){
                fillString = fillString + spaceStr;
            }
        }

        if(flag == "left"){
            obj.value = fillString + val;
        } else if(flag == "right"){
            obj.value = val + fillString;
        }
    }

    /**
     * from, to날짜의 유효성 체크
     * obj1:앞날짜
     * obj2:뒤날짜
     */

     function isLateDate(obj1, obj2){
       str1 = obj1.value.replace(/\/|\-|\./g,"");
       str2 = obj2.value.replace(/\/|\-|\./g,"");
       if(ComParseInt(str1)>ComParseInt(str2)){
         ComShowMessage(ComGetMsg('COM12133', "To Date", "From Date", "many more"));
         obj2.value = "";
         obj2.focus();
       }
     }

    /**
     * 앞뒤를 비교하여 뒤가 크면 true<br>단순히 true, false만 리턴
     * val1:앞날짜
     * val2:뒤날짜
     */

     function isLateDate2(val1, val2){
       rtn = true;
       str1 = val1.replace(/\/|\-|\./g,"");
       str2 = val2.value.replace(/\/|\-|\./g,"");
       if(ComParseInt(str1)>ComParseInt(str2)){
         rtn = false;
       }
       return rtn;
     }


    /**
     * 오늘날짜를 'YYYY-MM' 포맷으로 리턴
     * delim:구분자, 없으면 ""
     */

   function getTodayForYYYYMM(delim){
      var current_date = getTodayForYYYYMM('-');
      var year = current_date.getFullYear().toString();
      var month = current_date.getMonth() + 1;
      month = (month < 10 ? "0" : "") + month;
      if(delim == null) delim = "";
      return year + delim + month;
   }



  /**
   * -n일자를 구함
   * str : YYYYMMDD형태의 일자
   * offset : 계산할 수 = ...,2,1,0,-1,-2,...
   *
   * Author : kevin.kim (2006.12.18)
   */
    function getOffsetDate(str,offset)
    {
    if(str.length != 8) {
        return
    }
    var yyyy = str.substring(0,4);
    var mm = str.substring(4,6);
    var dd = str.substring(6,8);

        plann = eval(offset);         //+ 몇일

        var dayStr = mm+"-"+dd+"-"+yyyy;
        var Meet = new Date(dayStr);

    //annitime = Meet.getTime()+plann*1000*3600*24-1
    annitime = Meet.getTime() + plann * 1000 * 3600 * 24;

    var anniday = new Date();
    anniday.setTime(annitime);

    var plusyear  = (anniday.getYear()<100)?"19"+anniday.getYear():anniday.getYear();
    var plusmonth = anniday.getMonth()+1;
    var plusday   = anniday.getDate();

    return plusyear + "-" + fillZero(plusmonth,2,'0','left') + "-" + fillZero(plusday,2,'0','left') ;
    }


  /**
   * 1을 001, 100로 세팅할 때 사용
   *     ex) fillZero('sss',2,'0','left');
   *
   * str : 원본 문자열
   * spaceNum : 리턴 받고자하는 문자열의 총길이
   * spaceStr : 채울 값
   * flag :  왼쪽(left) 오른쪽(right)
   *
   * Author : kevin.kim (2006.12.18)
   */
  function fillZero(str, spaceNum, spaceStr, flag){
    var i=0;
    var ret = "";
    var fillString = "";

    if(str.length>0){
      for(i=0;i<(spaceNum - str.length); i++){
        fillString = fillString + spaceStr;
      }
    }

    if(flag == "left"){
      ret = fillString + str;
    } else if(flag == "right"){
      ret = str + fillString;
    }
    return ret;
  }

  /**
   * 현재일자를 구함
   * str : YYYY-MM-DD형태의 일자를 리턴
   *
   * Author : kevin.kim (2006.12.19)
   */
    function getCurrDate(delimiter)
    {
    var current_date = new Date();
    var year = current_date.getFullYear().toString();
    var month = current_date.getMonth() + 1;
    month = (month < 10 ? "0" : "") + month;
    var day = current_date.getDay();
    day = (day < 10 ? "0" : "") + day;

    if(delimiter == null) delimiter = "";

    return year + delimiter + month + delimiter + day;
    }

  /**
   * 현재년월을 구함
   * str : YYYY-MM형태의 년월을 리턴
   *
   * Author : kevin.kim (2007.01.11)
   */
    function getCurrYearMonth(delimiter)
    {
    var current_date = new Date();
    var year = current_date.getFullYear().toString();
    var month = current_date.getMonth() + 1;
    month = (month < 10 ? "0" : "") + month;

    if(delimiter == null) delimiter = "";

    return year + delimiter + month;
    }


    /**
     * 입력된 문자열이 년 Format YYYY이 맞는지를 확인
     *
     * @param obj        object
     * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
     * @param isN        널스트링 허용여부
     * @return true, false
     */
    function isValidYear(obj, isSet, isN) {
        var rtn = true;
        var str = obj.value;

        if(!(str.length == 4)) { rtn = false; }
        if (!(ComParseInt(str) >= 1900 && ComParseInt(str) <= 9999)) {
            rtn = false;
        }

        if(isN && str == "") { rtn = true; }

        if(rtn == false) {
            ComShowMessage(ComGetMsg('MAS10009','Year','YYYY')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
            if(isSet) { obj.value = ""; }
            obj.focus();
        }

        return rtn;
    }

    /**
     * 입력된 문자열이 주 Format WW이 맞는지를 확인
     *
     * @param obj        object
     * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
     * @param isN        널스트링 허용여부
     * @return true, false
     */
    function isValidWeek(obj, isSet, isN) {
        var rtn = true;
        var str = obj.value;
        str = fillZero(str,2,'0','left');

        //if (!isNumSlash(obj) && !isNumPeriod(obj) && !isNumDash(obj)) { rtn = false; }
        if (!(ComParseInt(str) >= 0 && ComParseInt(str) <= 53)) {
            rtn = false;
        }

        if(isN && str == "") { rtn = true; }

        if(rtn == false) {
            ComShowMessage(ComGetMsg('MAS10009','Week','WW')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
            if(isSet) { obj.value = ""; }
            obj.focus();
        }

        return rtn;
    }


    /**
     * 입력된 문자열이 월 Format MM이 맞는지를 확인
     *
     * @param obj        object
     * @param isSet      Setting 여부, true->값세팅함, false->값 세팅 안함.
     * @param isN        널스트링 허용여부
     * @return true, false
     */
    function isValidMonth(obj, isSet, isN) {
        var rtn = true;
        var str = obj.value;
        str = fillZero(str,2,'0','left');

        //if (!isNumSlash(obj) && !isNumPeriod(obj) && !isNumDash(obj)) { rtn = false; }
        if (!(ComParseInt(str) >= 1 && ComParseInt(str) <= 12)) {
            rtn = false;
        }
        if (!ComIsMonth(str)) {
            rtn = false;
        }

        if(isN && str == "") { rtn = true; }

        if(rtn == false) {
            ComShowMessage(ComGetMsg('MAS10009','Month','MM')); //msg1 + '을(를)  정확하게 입력하세요. 입력형식:' + msg2
            if(isSet) { obj.value = ""; }
            obj.focus();
        }

        return rtn;
    }

    /**
     * sheet의 height를 계산한다.
     * (2007.2.14 - Kevin.KIM)
     *
     * @param sheetObj : sheet
     * @param retType : 추출방법 (MAX:최대값,MIN:최소값)
     * @param scrollCnt : 스크롤 여부 (0:없음, 1:있음) --> 단, MAX만 적용
     * @return heightCnt
     */
    function getSheetHeightCnt(sheetObj, retType, scrollCnt) {
        var basCnt = 20;  //기본 height
        var maxCnt = 100; //허용가능한 최대 height

        var heightCnt = 0;

        with (sheetObj) {
            if (retType.toUpperCase() == "MAX") {
                heightCnt = maxCnt;
                   if (RowCount > 0) {
                       heightCnt = HeaderRows + LastRow + scrollCnt + 1; //예비 +1
                } else { //조회된 데이터가 없으면
                    heightCnt = basCnt;
                }
            } if (retType.toUpperCase() == "MIN") {
                   heightCnt = basCnt;
            }
        }

        if (heightCnt > maxCnt) {
            heightCnt = maxCnt;
        }
        if (heightCnt < basCnt) {
            heightCnt = basCnt;
        }

        return heightCnt;
    }

    /**
     * Excel Dowload시 사용
     * 사용 : var rtn = selectDownExcelMethod(sheetObj);
     * (2007.4.13 - Kevin.KIM)
     *
     * @param sheetObj : sheet
     * @return String
     *         NODATA = Not Found Data
     *         AY = Down2Excel(0, false, false, true);
     *         DY = Down2Excel(-1, false, false, true);
     *         AN = SpeedDown2Excel(0, false, false);
     *         DN = SpeedDown2Excel(-1, false, false);
     *         CANCEL = Cancel + Window Close
     */
    function selectDownExcelMethod(sheetObj){
        if(sheetObj.RowCount == 0){
            sheetObj.Down2Excel(-1, false, false, true);
            return "NODATA";
        }
        var sFeature = "";
        sFeature = sFeature + "dialogHeight:230px;"
        sFeature = sFeature + "dialogWidth:302px;"
        sFeature = sFeature + "center:yes;"
        sFeature = sFeature + "resizable:no;"
        sFeature = sFeature + "scroll:no;"
        sFeature = sFeature + "status:no;"
        var rtn = window.showModalDialog("ESM_MAS_3002.do", "", sFeature);
        return rtn;
    }


    /******************************************************************************************************/
    /**                                        Sheet 관련 function                                        */
    /******************************************************************************************************/

    /**
     * getSearchXml()메소드를 이용하여 가져온 xml string을 sheet에 loading 하지 않고
     * etcData의 내용을 뽑아 오는 함수
     *
     * @param fName ETC의  key필드명
     * @param xml string
     * @param index
     */
    function searchEtcData(fName, xmlStr, index) {
        var ind = 0;

        if (index !="") ind = index;

        if(xmlStr == null || xmlStr == "") return;

        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(ind);
        if(etcDataNode == null) return;

        var etcNodes = etcDataNode.childNodes;
        if(etcDataNode == null) return;

        var clength = etcNodes.length;
        var rtnValue = "";

        for(var i = 0; i < clength; i++) {
            var xname = etcNodes[i].getAttribute("KEY");
            var xvalue = etcNodes[i].text;
            if(fName.toUpperCase() == xname.toUpperCase()) {
                rtnValue = xvalue;
            } //--if Upper
        } //--for(i)
        return rtnValue;
    }

    /**
     * IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 ETC-DATA로 넣은 KEY의 값을 리턴한다.
     * 단, 본 함수는 공통함수 ComGetEtcData와 유사한 함수로 와 ComGetEtcData은 ETC-DATA가 1개일 경우이며
     *     현재 함수는 ETC-DATA가 2개일 경우에 사용한다.
     * <br><b>Example :</b>
     * <pre>
     *     xmlStr = mySheet.GetSearchXml("list.jsp");
     *     sValue = ComGetEtcData(xmlStr, "UserId");
     *     예를 들어 xmlStr의 내용이 아래와 같다면 sValue의 값은 "ibs006"이 된다.
     *     xmlStr ======================================================
     *       &lt;?xml version='1.0' ?&gt;
     *       &lt;SHEET&gt;
     *         &lt;ETC-DATA&gt;
     *              &lt;ETC KEY="UserId"&gt;ibs006&lt;/ETC&gt;
     *              &lt;ETC KEY="UserName"&gt;khlee&lt;/ETC&gt;
     *         &lt;/ETC-DATA&gt;
     *       &lt;/SHEET&gt;
     *     xmlStr ======================================================
     * </pre>
     * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
     * @param   {string} etcName    필수,xml 문자열에서 추출하고자하는 ETC Key이름
     * @return  string, ETC-DATA로 넣은 KEY의 값
     * @version 3.4.0.50
     */
    function GetEtcDataForExceptional(xmlStr,etcName){
        if(xmlStr == null  || xmlStr == "" || etcName == null || etcName == "") return;

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;

            var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(1);
            if(etcDataNode == null) return;

            var etcNodes = etcDataNode.childNodes;
            if(etcDataNode == null) return;

            for(var i=0;i<etcNodes.length;i++){
              if(etcNodes[i].nodeType!=1 || etcNodes[i].attributes.length == 0) continue;

              if(etcNodes[i].attributes(0).text==etcName) {
                if (etcNodes[i].firstChild==null) {
                  return "";
                } else {
                  return etcNodes[i].firstChild.nodeValue;
                }
              }
            }

        } catch(err) { ComFuncErrMsg(err.message); }
    }


    /**
     * Sheet의 데이터를 조회XML로 구성하여 반환한다.
     * @param : sheet_obj - IBSheet Object ID
     * @param : allSave - sheet 전체를 xml string으로 만들지 여부[true/false]
     * @param : col     - 대상이 되는 기준 컬럼[dtCheckBox]
     * @param : saveColName - 특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     * @return : Sheet의 데이터를 조회XML로 구성한 문자열
     * @sample
     *  var sXml = makeDataXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
     */
    function makeDataXml(sheet_obj, allSave, col, saveColName)  {
        //함수 인자 유효성 확인
        if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
            return "";
        }

        var rowXml = "";
        var allXml = "<?xml version='1.0'  ?>\n<SHEET>\n  <DATA TOTAL='"+ sheet_obj.TotalRows +"'>\n";
        if(allSave){
            for (ir = sheet_obj.HeaderRows; ir <= sheet_obj.LastRow; ir++) {
                rowXml = "    <TR>";
                for (ic = 0; ic<= sheet_obj.LastCol; ic++) {
                    //셀의 값을 변수에 저장한다.
                    var sValue = String(sheet_obj.CellValue(ir,ic));
                    //특수문자(&, <, >)가 포함된 경우만 CDATA로 감싼다
                    if (sValue.indexOf("&") > -1 || sValue.indexOf("<") > -1 || sValue.indexOf(">") > -1) {
                        sValue = "<![CDATA[" + sValue + "]]>";
                    }
                    //XML을 만든다.
                    rowXml += "<TD>" + sValue + "</TD>";
                }
                rowXml += "</TR>\n";
                allXml += rowXml;
            }
        }else{
            if(col != ""){
                var findRows = sheet_obj.FindCheckedRow(col);
                if(findRows != ""){
                    findRows = findRows.substring(0, findRows.length-1);
                    var arrRow = findRows.split("|");
                    var arrCol = saveColName.split("|");
                    for(ir = 0; ir<arrRow.length; ir++){
                        rowXml = "    <TR>";
                        for(ic = 0; ic<arrCol.length; ic++){
                            //셀의 값을 변수에 저장한다.
                            var sValue = String(sheet_obj.CellValue(arrRow[ir], arrCol[ic]));
                            //특수문자(&, <, >)가 포함된 경우만 CDATA로 감싼다
                            if (sValue.indexOf("&") > -1 || sValue.indexOf("<") > -1 || sValue.indexOf(">") > -1) {
                                sValue = "<![CDATA[" + sValue + "]]>";
                            }
                            //XML을 만든다.
                            rowXml += "<TD>" + sValue + "</TD>";
                        }
                        rowXml += "</TR>\n";
                        allXml += rowXml;
                    }
                }
            }
        }
        allXml += "  </DATA>\n</SHEET>";

        return allXml;
    }




    /**
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 숫자만으로 제어한다. <br>
     * 예를 들어 다음과 같이 사용한다.<br>
     *     &lt;input type="text" name="txtAmt" <font color="red">onKeyPress="ComKeyOnlyNumber(this)"</font>&gt; <br>
     * 인자로 사용되는 sSubChar 인자는 숫자이외에 부가적으로 입력할수 있는 문자를 여러개 연결하여 설정한다.<br>
     * <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this)"&gt;
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKeyOnlyNumber(this, "-")"&gt;
     *     &lt;input type="text" name="txtAmt" onKeyPress="ComKey(this, "-.,")"&gt;
     * </pre>
     * @param {object} obj      필수,대상 HTML태그(Object)
     * @param {string} sSubChar 선택,숫자이외의 부가 글자
     * @returns 없음 <br>
     * @see #ComKeyOnlyAlphabet
     */
    function MasKeyOnlyNumber(obj,sSubChar){
        try {
            var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

            //ComDebug('key  = '+keyValue);

            if((keyValue >= 48 && keyValue <= 57) //숫자
                    || keyValue == 8
                    || keyValue == 9
                    || keyValue == 37
                    || keyValue == 38
                    || keyValue == 39
                    || keyValue == 40
                    || keyValue == 46) {
                event.returnValue = true;

            } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
                //SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
                for(var i=0; i<sSubChar.length; i++) {
                    //ComDebug("sSubChar.charAt(" + i + ")=" + sSubChar.charAt(i));
                    if (keyValue == sSubChar.charCodeAt(i)) {
                        event.returnValue = true;
                        return;
                    }
                }
                event.returnValue = false;
            } else {
                event.returnValue = false;
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
    * @param :
    * sample    : get_NowYear();
    * @return     : 현재 년도
    * 설명        : 현재 년도 가지고 오기
    **/
    function get_NowYear()
    {
        today     = new Date()
        return     ""+today.getFullYear();
    }

    /**
    * @param :
    * sample    : get_NowMonth();
    * @return     : 현재 월
    * 설명        : 현재 월 가지고 오기
    **/
    function get_NowMonth()
    {
        today     = new Date()
        month1     = today.getMonth()+1;
        return     month1.toString();
    }
    /******************************************************************************************************/
    /**  Cost_yrmon, Sls_yrmon 으로 인해 화면의 컨트롤응 공통화합                                             */
    /******************************************************************************************************/

// -- -----------------------------------------------------------------------------------------
// Period 관련 변경내역
// -- -----------------------------------------------------------------------------------------
 /**
  * Month/Week 에 따라서 화면에 컨트롤을 변경시켜준다.
  */
function chkWM(param1, param2) {
    if (param1 == 'W') {
        //ESM_MAS_0029 UI가 아니고 sls_yrmon컬럼과 cost_yrmon컬럼이 둘 다 존재할때
        if (location.pathname.toUpperCase().indexOf("ESM_MAS_0029") == -1 && sheetObjects[0] == "[object]" && sheetObjects[0].SaveNameCol("sls_yrmon") != -1 && sheetObjects[0].SaveNameCol("cost_yrmon") != -1) {
            //ESM_MAS_0060 UI인 경우 해당 js에서 처리
        	if(location.pathname.toUpperCase().indexOf("ESM_MAS_0060") != -1){
            	viewWeek();
            }else{
            	sheetObjects[0].ColHidden("sls_yrmon") = false;
            	sheetObjects[0].ColHidden("cost_yrmon") = true;
            }
        }
        document.all.div_week.style.display = "inline";
        document.all.div_month.style.display = "none";
        setPeriod(document.form.f_to_wk);
    } else {
        //ESM_MAS_0029 UI가 아니고 sls_yrmon컬럼과 cost_yrmon컬럼이 둘 다 존재할때
        if (location.pathname.toUpperCase().indexOf("ESM_MAS_0029") == -1 && sheetObjects[0] == "[object]" && sheetObjects[0].SaveNameCol("sls_yrmon") != -1 && sheetObjects[0].SaveNameCol("cost_yrmon") != -1) {
        	//ESM_MAS_0060 UI인 경우 해당 js에서 처리
        	if(location.pathname.toUpperCase().indexOf("ESM_MAS_0060") != -1){
            	viewWeek();
            }else{
            	sheetObjects[0].ColHidden("sls_yrmon") = true;
            	sheetObjects[0].ColHidden("cost_yrmon") = false;
            }
        }
        document.all.div_week.style.display = "none";
        document.all.div_month.style.display = "inline";
        if (param2 == '1') {
            setPeriod(document.form.f_to_mon);
        } else {
            setPeriod(document.form.f_mon);
        }
    }
}

/**
 * YYYY-MM : [Year-Month]
 * 위 항목을 화면에 디스플레이 함
 *
 * html 부분에 넣어 준다.
 * <script language="javascript">masPeriod();</script>
 */
function masPeriod(){
    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
    document.write("\n <table class='search' border='0'> ");
    document.write("\n     <tr class='h23'> ");
    document.write("\n         <td width='9%'>YYYY-MM</td> ");
    document.write("\n         <td width='16%'> ");
    document.write("\n             <input type='text' class='input1' name='f_yearmonth' style='width:70;text-align:center;' maxlength='6' onkeyPress='ComKeyOnlyNumber(window);' onBlur='javascript:fnYearMonthSet(this);' onFocus=\"ComAddSeparator_Local(this, '-');this.select();\"> ");
    document.write("\n         </td> ");
    document.write("\n         <td colspan='6' class='sm'><div id='div_period'></div></td> ");
    document.write("\n     </tr> ");
    document.write("\n </table> ");
}


/**
 * M : [Year, Month] Week : [Year, Month, Fm_week, To_week]
 * 위 항목을 화면에 디스플레이 함
 *
 * html 부분에 넣어 준다.
 * <script language="javascript">initPeriod();</script>
 * initPeriod->masPeriod1
 */
 function masPeriod1(){
    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
    document.write("\n <table border='0'> ");
    document.write("\n     <tr class='h23'> ");
    document.write("\n         <td width='50'>&nbsp;&nbsp;W/M</td> ");
    document.write("\n         <td width='160'> ");
    document.write("\n             <div id='div_wm' style='display:inline;border:solid 0;'> ");
    document.write("\n             <input type='radio' value='W' name='f_chkprd' class='trans' onClick=\"chkWM('W','1');\" checked>&nbsp;Week ");
    document.write("\n             <input type='radio' value='M' name='f_chkprd' class='trans' onClick=\"chkWM('M','1');\">&nbsp;Month ");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td width='25' class='sm'>Year</td> ");
    document.write("\n         <td width='60'><input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);'></td> ");
    document.write("\n         <td width='150' class='sm'> ");
    document.write("\n             <div id='div_month' style='display:none;border:solid 0;width:140;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
    document.write("\n             </div> ");
    document.write("\n             <div id='div_week' style='display:inline;border:solid 0;width:140;height:16'> ");
    document.write("\n             Week&nbsp;&nbsp;&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);' >&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td class='sm'><div id='div_period'></div></td> ");
    document.write("\n     </tr> ");
    document.write("\n </table> ");
    document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");

 }


/**
 *  설  명 : 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br><b>Example : </b>
 * <pre>
 *     validateForm(sheetObj,formObj,sAction)
 * </pre>
 * @param {object}    sheetObj - Sheet Object
 * @param {form}    formObj  - From Object
 * @param {String}    sAction  - 프로세스 종류
 * @see #링크연결
 * @author 작성자
 * @version 2009.01.01
 */
function validateForm1(formObj) {
    with(formObj){

        if (f_year.value == "") {
            // [COM12114] : Year 를(을) 확인하세요.
            ComShowMessage(ComGetMsg("COM12114", "Year"));
            ComSetFocus(f_year);
            return false;
        } else {
            if(!ComIsDate(f_year, "yyyy")){
                // [MAS10009] = 'Please enter Year correctly.\n\n Format : YYYY
                ComShowCodeMessage('MAS10009','Year','YYYY');
                ComSetFocus(f_year);
                return false;
            }
        }

        if(f_chkprd[0].checked) {
            if (f_fm_wk.value == ""  || f_to_wk.value == "") {
                // [COM12114] : Week 를(을) 확인하세요.
                ComShowMessage(ComGetMsg("COM12114", "Week"));
                if (f_fm_wk.value == "") {
                    ComSetFocus(f_fm_wk);
                } else if (f_to_wk.value == "") {
                    ComSetFocus(f_to_wk);
                }
                return false;
            } else {
                if (!ComIsWeek(f_fm_wk)){
                    // [MAS10009] = 'Please enter Week correctly.\n\n Format : WW
                    ComShowCodeMessage('MAS10009','Week','WW');
                    ComSetFocus(f_fm_wk);
                    return false;
                } else if(!ComIsWeek(f_to_wk)) {
                    // [MAS10009] = 'Please enter Week correctly.\n\n Format : WW
                    ComShowCodeMessage('MAS10009','Week','WW');
                    ComSetFocus(f_to_wk);
                    return false;
                } else if (ComParseInt(f_fm_wk.value) > ComParseInt(f_to_wk.value)) {
                    // [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
                    ComShowCodeMessage("MAS10011","Week","From","To");
                    ComSetFocus(f_to_wk);
                    return false;
                }
            }

        } else {
            if (f_fm_mon.value == "" || f_to_mon.value == "") {
                // [COM12114] : Month 를(을) 확인하세요.
                ComShowMessage(ComGetMsg("COM12114", "Month"));
                if (f_fm_mon.value == "") {
                    ComSetFocus(f_fm_mon);
                } else if (f_to_mon.value == "") {
                    ComSetFocus(f_to_mon);
                }
                return false;
            } else {
                if(!ComIsMonth(f_fm_mon)){
                    // [MAS10009] = 'Please enter Month correctly.\n\n Format : MM
                    ComShowCodeMessage('MAS10009','Month','MM');
                    ComSetFocus(f_fm_mon);
                    return false;
                } else if(!ComIsMonth(f_to_mon)) {
                    // [MAS10009] = 'Please enter Month correctly.\n\n Format : MM
                    ComShowCodeMessage('MAS10009','Month','MM');
                    ComSetFocus(f_to_mon);
                    return false;
                } else if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
                    // [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
                    ComShowCodeMessage("MAS10011","Month","From","To");
                    ComSetFocus(f_to_mon);
                    return false;
                }
            }
        }
    }
    return true;
}


/**
 * M : [Year, Month] Week : [Year, Month, Fm_week, To_week]
 * 위 항목을 화면에 디스플레이 함
 *
 * html 부분에 넣어 준다.
 * <script language="javascript">initPeriod_2();</script>
 * initPeriod2 ->masPeriod2
 */
 function masPeriod2(){
    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
    document.write("\n <table border='0'> ");
    document.write("\n     <tr class='h23'> ");
    document.write("\n         <td width='50'>&nbsp;&nbsp;W/M</td> ");
    document.write("\n         <td width='160'> ");
    document.write("\n             <div id='div_wm' style='display:inline;border:solid 0;'> ");
    document.write("\n             <input type='radio' value='W' name='f_chkprd' class='trans' onClick=\"chkWM('W','2');\" checked>&nbsp;Week ");
    document.write("\n             <input type='radio' value='M' name='f_chkprd' class='trans' onClick=\"chkWM('M','2');\">&nbsp;Month ");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td width='25' class='sm'>Year</td> ");
    document.write("\n         <td width='60'><input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);'></td> ");
    document.write("\n         <td width='150' class='sm'> ");
    document.write("\n             <div id='div_month' style='display:none;border:solid 0;width:140;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"this.value=ComLpad(this, 2, '0');\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>");
    document.write("\n             </div> ");
    document.write("\n             <div id='div_week' style='display:inline;border:solid 0;width:240;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' name='f_sls_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>&nbsp;&nbsp;");
    document.write("\n             Week&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td class='sm'><div id='div_period'></div></td> ");
    document.write("\n     </tr> ");
    document.write("\n </table> ");
    document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");

 }


/**
 * M : [Year, Fm_month, To_month] Week : [Year, Month, Fm_week, To_week]
 * 위 항목을 화면에 디스플레이 함
 *
 * html 부분에 넣어 준다.
 * <script language="javascript">initPeriod3();</script>
 * initPeriod3 ->masPeriod3
 */
 function masPeriod3(){
    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
    document.write("\n <table border='0'> ");
    document.write("\n     <tr class='h23'> ");
    document.write("\n         <td width='50'>&nbsp;&nbsp;W/M</td> ");
    document.write("\n         <td width='150'> ");
    document.write("\n             <div id='div_wm' style='display:inline;border:solid 0;'> ");
    document.write("\n             <input type='radio' value='W' name='f_chkprd' class='trans' onClick=\"chkWM('W','1');\" checked>&nbsp;Week ");
    document.write("\n             <input type='radio' value='M' name='f_chkprd' class='trans' onClick=\"chkWM('M','1');\">&nbsp;Month ");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td width='25' class='sm'>Year</td> ");
    document.write("\n         <td width='60'><input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);'></td> ");
    document.write("\n         <td width='200' class='sm'> ");
    document.write("\n             <div id='div_month' style='display:none;border:solid 0;width:140;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>");
    document.write("\n             </div> ");
    document.write("\n             <div id='div_week' style='display:inline;border:solid 0;width:200;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' name='f_sls_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>&nbsp;&nbsp;");
    document.write("\n             Week&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td class='sm'><div id='div_period'></div></td> ");
    document.write("\n     </tr> ");
    document.write("\n </table> ");
    document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");

}


/**
 * M : [Year, Month] Week : [Year, Month, Fm_week, To_week]
 * 위 항목을 화면에 디스플레이 함
 *
 * html 부분에 넣어 준다.
 * <script language="javascript">initPeriod_ofc();</script>
 * initPeriod_ofc->masPeriod1_ofc
 */
function masPeriod1_ofc(){
    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
    document.write("\n <table border='0'> ");
    document.write("\n     <tr class='h23'> ");
    document.write("\n         <td width='50'>&nbsp;&nbsp;W/M</td> ");
    document.write("\n         <td width='160'> ");
    document.write("\n             <div id='div_wm' style='display:inline;border:solid 0;'> ");
    document.write("\n             <input type='radio' value='W' name='f_chkprd' class='trans' onClick=\"chkWM('W','1');changeCostYrmon(this.value);\" checked>&nbsp;Week ");
    document.write("\n             <input type='radio' value='M' name='f_chkprd' class='trans' onClick=\"chkWM('M','1');changeCostYrmon(this.value);\">&nbsp;Month ");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td width='25' class='sm'>Year</td> ");
    document.write("\n         <td width='60'><input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);changeCostYrmon(this.value);'></td> ");
    document.write("\n         <td width='150' class='sm'> ");
    document.write("\n             <div id='div_month' style='display:none;border:solid 0;width:140;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);changeCostYrmon(this.value);'>&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
    document.write("\n             </div> ");
    document.write("\n             <div id='div_week' style='display:inline;border:solid 0;width:140;height:16'> ");
    document.write("\n             Week&nbsp;&nbsp;&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);' >&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td class='sm'><div id='div_period'></div></td> ");
    document.write("\n     </tr> ");
    document.write("\n </table> ");
    document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");

}


/**
 * M : [Year, Month] Week : [Year, Month, Fm_week, To_week]
 * 위 항목을 화면에 디스플레이 함
 *
 * html 부분에 넣어 준다.
 * <script language="javascript">initPeriod_2_ofc();</script>
 * initPeriod2_ofc ->masPeriod2_ofc
 */
 function masPeriod2_ofc(){
    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
    document.write("\n <table border='0'> ");
    document.write("\n     <tr class='h23'> ");
    document.write("\n         <td width='50'>&nbsp;&nbsp;W/M</td> ");
    document.write("\n         <td width='160'> ");
    document.write("\n             <div id='div_wm' style='display:inline;border:solid 0;'> ");
    document.write("\n             <input type='radio' value='W' name='f_chkprd' class='trans' onClick=\"chkWM('W','2');changeCostYrmon(this.value);\" checked>&nbsp;Week ");
    document.write("\n             <input type='radio' value='M' name='f_chkprd' class='trans' onClick=\"chkWM('M','2');changeCostYrmon(this.value);\">&nbsp;Month ");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td width='25' class='sm'>Year</td> ");
    document.write("\n         <td width='60'><input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);changeCostYrmon(this.value);'></td> ");
    document.write("\n         <td width='150' class='sm'> ");
    document.write("\n             <div id='div_month' style='display:none;border:solid 0;width:140;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"this.value=ComLpad(this, 2, '0');\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>");
    document.write("\n             </div> ");
    document.write("\n             <div id='div_week' style='display:inline;border:solid 0;width:240;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' name='f_sls_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);changeCostYrmon(this.value);'>&nbsp;&nbsp;");
    document.write("\n             Week&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td class='sm'><div id='div_period'></div></td> ");
    document.write("\n     </tr> ");
    document.write("\n </table> ");
    document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");

 }

    /**
     * M : [Year, Fm_month, To_month] Week : [Year, Month, Fm_week, To_week]
     * 위 항목을 화면에 디스플레이 함
     *
     * html 부분에 넣어 준다.
     * <script language="javascript">initPeriod3initPeriod3_ofc();</script>
     * initPeriod3_ofc ->masPeriod3_ofc
     */
function masPeriod3_ofc(){
    document.write("\n <!--  -------------------------------------------------------------------------------------------- --> ");
    document.write("\n <table border='0'> ");
    document.write("\n     <tr class='h23'> ");
    document.write("\n         <td width='50'>&nbsp;&nbsp;W/M</td> ");
    document.write("\n         <td width='160'> ");
    document.write("\n             <div id='div_wm' style='display:inline;border:solid 0;'> ");
    document.write("\n             <input type='radio' value='W' name='f_chkprd' class='trans' onClick=\"chkWM('W','1');changeCostYrmon(this.value);\" checked>&nbsp;Week ");
    document.write("\n             <input type='radio' value='M' name='f_chkprd' class='trans' onClick=\"chkWM('M','1');changeCostYrmon(this.value);\">&nbsp;Month ");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td width='25' class='sm'>Year</td> ");
    document.write("\n         <td width='60'><input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);changeCostYrmon(this.value);'></td> ");
    document.write("\n         <td width='150' class='sm'> ");
    document.write("\n             <div id='div_month' style='display:none;border:solid 0;width:140;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);changeCostYrmon(this.value);'>&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>");
    document.write("\n             </div> ");
    document.write("\n             <div id='div_week' style='display:inline;border:solid 0;width:240;height:16'> ");
    document.write("\n             Month&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' name='f_sls_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);changeCostYrmon(this.value);'>&nbsp;&nbsp;");
    document.write("\n             Week&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onKeyUp=\"ComKeyEnter('LengthNextFocus')\" onChange='setPeriod(this);'>&nbsp;&nbsp;~&nbsp;");
    document.write("\n             <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur=\"if(this.value!=''){this.value=ComLpad(this, 2, '0');}\" onChange=\"if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}\">");
    document.write("\n             </div> ");
    document.write("\n         </td> ");
    document.write("\n         <td class='sm'><div id='div_period'></div></td> ");
    document.write("\n     </tr> ");
    document.write("\n </table> ");
    document.write("\n<!--  -------------------------------------------------------------------------------------------- --> ");

 }


 /**
  * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
  * @param{form} str  Form 객체
  * @param{exElmNms} str   exElmNms값들은 form elemente name으로 구성하지 않을 값들이다.
  */
function masFormQueryString(form, exElmNms, isUse) {
    if (typeof form != "object" || form.tagName != "FORM") {
        //Msg : Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag. <== 모듈별 Error Msg 등록하여 사용
        showMsg("");
        return "";
    }
    var name = new Array(form.elements.length);
    var value = new Array(form.elements.length);
    var j = 0;
    var plain_text="";

    //사용가능한 컨트롤을 배열로 생성한다.
    len = form.elements.length;

    for (i = 0; i < len; i++) {

      //클래스 아이디로 제품을 구분함-아래는 HTMl제품
      if(form.elements[i].classid==undefined){
      switch (form.elements[i].type) {
        case "button":
        case "reset":
        case "submit":
        break;
        case "radio":
        case "checkbox":
            if (!checkExcludeElements(form.elements[i].name, exElmNms, isUse) && form.elements[i].checked == true) {
                name[j] = form.elements[i].name;
                value[j] = form.elements[i].value;
                j++;
            }
        break;
        case "select-one":
            var ind = form.elements[i].selectedIndex;
            if(!checkExcludeElements(form.elements[i].name, exElmNms, isUse) && ind >= 0 && form.elements[i].options[ind].value != '') {
                name[j] = form.elements[i].name;
                value[j] = form.elements[i].options[ind].value;
                j++;
            }
        break;
        case "select-multiple":
            var llen = form.elements[i].length;
            var increased = 0;
            for( k = 0; k < llen; k++) {
                if (!checkExcludeElements(form.elements[i].name, exElmNms, isUse) && form.elements[i].options[k].selected && form.elements[i].options[k].value != '') {
                    name[j] = form.elements[i].name;
                    value[j] = form.elements[i].options[k].value;
                    j++;
                    increased++;
                }
            }
        break;
        default :
                    if(form.elements[i].value.length >0 ) {
                     if(exElmNms!=null && exElmNms!='' && exElmNms!=undefined){
                      if(!checkExcludeElements(form.elements[i].name, exElmNms, isUse)){
                       name[j] = form.elements[i].name;
                       value[j] = form.elements[i].value;
                       j++;
                      }
                     } else {
                     name[j] = form.elements[i].name;
                      value[j] = form.elements[i].value;
                      j++;
                     }
                    }
        }

    //IB에서 제공하는 컨트롤의 값을 조합한다.
    } else {
      switch(form.elements[i].classid){
        case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":          // IBMaskEdit 경우
            if (!checkExcludeElements(form.elements[i].name==""?form.elements[i].id:form.elements[i].name, exElmNms, isUse)) {
                name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
              value[j] = form.elements[i].Value;
              j++;
            }
          break;
        case CLSID_IBMCOMBO: // IBMultiCombo 경우
          if (!checkExcludeElements(form.elements[i].name==""?form.elements[i].id:form.elements[i].name, exElmNms, isUse)) {
              name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;

              if(form.elements[i].UseCode ){
                  if (form.elements[i].Code == "All"){
                      value[j] = "";
                  }else{
                      value[j] = form.elements[i].Code;
                  }
              } else{
                  if (form.elements[i].Text == "All"){
                      value[j] = "";
                  }else{
                      value[j] = form.elements[i].Text;
                  }
              }
              j++;
          }
          break;
      }
    }
    }
    // QueryString을 조합한다.
    //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
    //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
    var webBrowserName = navigator.appName;
    var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                        navigator.appVersion.indexOf("MSIE") + 8)
    if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
        for (i = 0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
        }
    } else {
        var tmpUrlEncodeSheet    = document.getElementById("formquerystring");
        if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
        {
            //인코딩을 위해 숨겨진IBSheet를 만든다.
            var sTag = ComGetSheetObjectTag("formquerystring");
            form.insertAdjacentHTML('afterEnd', sTag);
        }
        for (i = 0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
        }
    }

    //마지막에 &를 없애기 위함
    if (plain_text != "")
      plain_text = plain_text.substr(0, plain_text.length -1);
      //plain_text = ComReplaceStr(plain_text,"=All","=");
//          var plain_text2 = plain_text.replace(/\&/g,"\n");
//          alert(plain_text2);
      return plain_text;
}


    function checkExcludeElements(elmNm, exElmNms, isUse){
        var arr_exElmNms = '';
        var rstTF = false;

        try{
            if(exElmNms != null && exElmNms != '' && exElmNms != undefined){
                arr_exElmNms = exElmNms.split('|');

                for(var i =0; i < arr_exElmNms.length; i++){
                    if(arr_exElmNms[i] != "") {
                        if(elmNm==null || elmNm=='' || elmNm==undefined){
                            rstTF = true;
                            break;
                        }else if(elmNm == arr_exElmNms[i]){
                            if( isUse == true)
                                rstTF = false;
                            else
                                rstTF = true;
                            break;
                        }
                        else {
                            if( isUse == true){
                                rstTF = true;
                            }
                        }
                    }
                }
            }
        }catch(e){
            rstTF = true;
        }
        return rstTF;
     }

    /**
     * IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
     * <b>Example :</b>
     * <pre>
     *     ComMasSetIBCombo(sheetObj,sXml,"trd_cd",false,1);
     * </pre>
     *
     * @param {string} sheetObj 필수
     * @param {string} sXml 필수, Combo에 채울 데이터(IBSheet를 통해 받아온 xml 문자열.)
     * @param {string} title 필수, Combo field명(IBSheet SaveName).
     * @param {string} iBlank 선택, Combo의 첫번째로우를 블랭크로 설정
     * @param {string} sCol 선택, 멀티콤보일경우 콤보를 선택하면 콤보에 보여질 순서설정(0:코드 or 1:description)
     * @param {string} iRow 선택, 생성할 선택 Row
     * @param {string} dCode 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Code값
     * @param {string} dText 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Text값
     * @param {string} bFlag multicombo 용 XML 파일을 Sheet 내에서 Combo 형태로 사용할 경우, Text 에 Code+"\t"+Text 형태로 만들어 사용할 수 있게 해 줌
     * (코드|디스크립션 형태가 아닐 경우는 0으로 설정해야함)
     * @return 없음
     * @version 2010.08.01
     */
    function ComMasSetIBCombo(sheetObj, sXml, title, iBlank, sCol,iRow, dCode, dText, bFlag){
        var showCol = 0;
        if (ComGetTotalRows(sXml) == "0") return;
        if (bFlag == undefined || bFlag == ""){
            bFlag = false;
        }
        if (sCol != undefined && sCol !=""){
            showCol = sCol;
        }
        if (iBlank == undefined || iBlank == ""){
            iBlank = false;
        }
        if (iRow == undefined || iBlank == ""){
            iRow = 0;
        }
        var arrData = ComXml2ComboString(sXml, "code", "name");
        if (bFlag == true && arrData != null){
            var arrCode = arrData[0].split("|");
            var arrName = arrData[1].split("|");
            var conData = "";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i] = arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                }
                conData = conData.concat(arrName[i]);
            }
            arrData[1] = conData;
        }
        if(iBlank){
            arrData[0] = " |" + arrData[0];
            arrData[1] = " |" + arrData[1];
        }
        if (arrData != null){
            if (iRow == 0){
                sheetObj.InitDataCombo(iRow,title, arrData[1], arrData[0],dText, dCode, showCol);
            }else{
                sheetObj.CellComboItem(iRow,title, arrData[1],arrData[0]);
            }
        }
    }

	/**
     * month, week가 변경되었을때 Period를 변경한다.(임시-삭제예정 : 2011.02.21 김상수)
     */
    function ComMasSetPeriod(obj){
        var formObj = document.form;

        if(obj == null){
            return;
        }
        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if(obj.name == "f_to_mon" ){
                formObj.f_fm_mon.value = "";
            } else if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value = "";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "f_fm_mon") return false;
            if(obj.name == "f_fm_wk") return false;
        }

        if(chkValidSearch()){
            var sheetObj = sheetObjects[0];
        	formObj.f_cmd.value = SEARCH02;

			var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
        }
    }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function ComMasSetPeriod1(obj){
        var formObj = document.form;

        if(obj == null){
            return;
        }
        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if(obj.name == "f_to_mon" ){
                formObj.f_fm_mon.value = "";
            } else if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value = "";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "f_fm_mon") return false;
            if(obj.name == "f_fm_wk") return false;
        }

        if (validateForm1(formObj)){
            var sheetObj = sheetObjects[0];
            formObj.f_cmd.value = SEARCH02;

            var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));
            var arrXml = sXml.split("|$$|");
            if (arrXml.length > 0)
                document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
        }
    }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function ComMasSetPeriod2(obj){
        var formObj = document.form;
        if (null==obj) return;
        if (""==obj.value) {  //to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if ("f_to_mon"==obj.name) {
                ComSetObjValue(formObj.f_fm_mon,"");
            } else if ("f_to_wk"==obj.name) {
                ComSetObjValue(formObj.f_fm_wk,"");
            }
            return false;
        } else {  // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if ("f_fm_mon"==obj.name) return false;
            if ("f_fm_wk"==obj.name) return false;
        }
        var sheetObj = sheetObjects[0];
        formObj.f_cmd.value = SEARCH03;
        var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));
        var arrXml = sXml.split("|$$|");
        if (0<arrXml.length) {
            document.getElementById("div_period").innerHTML = ComGetEtcData(arrXml[0],"period");
        }
    }

    /**
     * year-month가 변경되었을때 Period를 변경한다.
     */
    function ComMasSetPeriod3(obj){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if (null==obj) return;
        formObj.f_cmd.value = SEARCH04;
        var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));
        var arrXml = sXml.split("|$$|");
        if (0<arrXml.length) {
            document.getElementById("div_period").innerHTML = ComGetEtcData(arrXml[0],"period");
        }
    }

     /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function ComMasSetPeriod4(obj){
        var formObj = document.form;

        if(obj == null){
            return;
        }
        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value = "";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "f_fm_wk") return false;
        }

        var sheetObj = sheetObjects[0];
        formObj.f_cmd.value = SEARCH05;

        var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));
        var arrXml = sXml.split("|$$|");
        if (arrXml.length > 0)
            document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
    }

     /**
      * year-week가 변경되었을때 Period를 변경한다.
      */
     function ComMasSetPeriod5(obj,divName){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         if (null==obj) return;
         formObj.f_cmd.value = SEARCH06;
         var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));
         var arrXml = sXml.split("|$$|");
         if (0<arrXml.length) {
             document.getElementById(divName).innerHTML = ComGetEtcData(arrXml[0],"period");
         }
     }

     /**
       * Location을 Check한다.
       */
      function ComMasCheckLocCd(f_type_cd, obj, f_d_term, f_tml_cd, f_pol_pod_cd, spcl_cgo_cd){
           var formObj = document.form;
           var sheetObj = sheetObjects[0];
           var param = "f_cmd="+SEARCH07;
           if (f_pol_pod_cd == null || f_pol_pod_cd == "undefined") {
        	   f_pol_pod_cd = "";
           }
           if (spcl_cgo_cd == null || spcl_cgo_cd == "undefined") {
        	   spcl_cgo_cd = "";
           }
           param = param + "&f_type_cd="+f_type_cd+"&f_loc_cd="+ComGetObjValue(obj)+"&f_del="+f_d_term+"&f_tml_cd="+f_tml_cd+"&f_pol_pod_cd="+f_pol_pod_cd+"&f_spcl_cgo_cd="+spcl_cgo_cd;
           var sXml = sheetObj.GetSearchXml("MasCommonUtilGS.do", param);
           var arrXml = sXml.split("|$$|");
           if (0<arrXml.length) {
              var rtnValue = ComGetEtcData(arrXml[0],"rtnValue");
              isValidLocation(obj,rtnValue);
           }
      }

      function ComMasGetEtcData(xml, name){
          if (ComGetEtcData(xml, name) == undefined){
              return "";
          }else{
              return ComGetEtcData(xml, name);
          }
      }
     
      /**
       *   jsp에서 페이지 최초 로딩시 아래와 같이 combo를 위한 값을 구성하고 script에서 multi combo에 값을 assign 하고자 할경우
       *   그 값을 파싱해 multi combo에 assign 해준다.
       *   JSP의 Value 예시)
       *    var appOfcCdComboText = "HAMUR  EUROPE REGIONAL HEADQUARTERS|NYCNA  AMERICA REGIONAL HEADQUARTERS|SAOBB San Paulo Branch Office|SELSKM  KEY ACCOUNT GROUP|SELSTA    Trans-pacific Trade Group|SELSTE    European Trade Group|SELSTI Intra-Asia Trade Group|SHAAS    ASIA REGIONAL HEADQUARTERS";
       *    var appOfcCdComboValue = "HAMUR|NYCNA|SAOBB|SELSKM|SELSTA|SELSTE|SELSTI|SHAAS";
       *
       *    var profitViewComboText = "Trade Profit|Office Profit";
       *    var profitViewComboValue = "P|R";
       *  사용 예시
       * <pre>
       *    ComTextCode2ComboItem(appOfcCdComboValue,appOfcCdComboText, formObj.frm_svc_scp_cd ,"|","\t" );
       *    ComTextCode2ComboItem(profitViewComboValue,profitViewComboText, formObj.prop_apro_ofc_cd);
       * </pre>
       *
       * @param {string} codeStr MultiCombo에 assign될 rowSeparator(아래 예제에서는 '|')로 구분된 Code String
       *                 <BR> 예) "HAMUR|NYCNA|SAOBB|SELSKM|SELSTA|SELSTE|SELSTI|SHAAS";
       * @param {string} textStr MultiCombo에 assign될 rowSeparator과 colSeparator로 구분된 Text String
       *                 <BR> combo를 다중컬럼으로 보여줄경우 colSeparator로 구분해서 값을 구성한다.
       *                 <BR> 예) 1. 하나의 컬럼일경우 textStr값
       *                            "Trade Profit|Office Profit";
       *                 <BR>     2. 다중컬럼으로 구성했을경우 textStr값
       *                 <BR>       이때의 rowSeparator는 '|'이되고 colSeparator는 '\t"가 된다.
       *                              "HAMUR    EUROPE REGIONAL HEADQUARTERS|NYCNA  AMERICA REGIONAL HEADQUARTERS|SAOBB San Paulo Branch Office|SELSKM  KEY ACCOUNT GROUP|SELSTA    Trans-pacific Trade Group|SELSTE    European Trade Group|SELSTI Intra-Asia Trade Group|SHAAS    ASIA REGIONAL HEADQUARTERS";
       *
       * @param {object} cmbObj 해당 ComboObject
       * @param (stirng) rowSeparator code,text에서 공통으로 쓰이는 구분자로 combo의 row를 구분하는 구분자 default : '|'
       * @param (stirng) colSeparator combo의 text에서만 사용하는 구분자로 다중컬럼을 보여줄때 각 컬럼의 값을 구분하는 구분자다 default : '\t'
       * @param (stirng) showCellIdx  textStr의 값은 colSeparator로 구분된 여러 값이 들어 있으나 다중컬럼으로 보여주지 않고
       *                 <BR>  showCellIdx번째 cell을 보여주고자 할때 사용한다., 0부터 시작,  default : 넘어온 textStr의 컬럼 갯수만큼 컬럼을 보여줌
       */
      function ComTextCode2ComboItem(codeStr,textStr, cmbObj,rowSeparator,colSeparator,showCellIdx ){
          if( rowSeparator  == undefined ){
              rowSeparator = "|"
          }
          if( colSeparator  == undefined ){
              colSeparator = "\t"
          }
          var isSplit = true;
          var isShowSpclCol = false;
          var arrCode = codeStr.split(rowSeparator);
          var arrText = textStr.split(rowSeparator);
          if( colSeparator == "|"){
              isSplit = false;
          }
          if( showCellIdx != undefined && ( ComIsNumber(showCellIdx) ||  showCellIdx == "0")
                  && showCellIdx < (arrText[0].split(colSeparator)).length ){
              isShowSpclCol = true;
          }
          for(var idx=0;idx < arrCode.length; idx++ ){
              var text = arrText[idx];
              //특정 Text값을 보여준다.
              if( isShowSpclCol ){
                  text =  text.split(colSeparator)[showCellIdx];
              }else if( isSplit ){
                      text=text.replace(colSeparator,"|");
              }
              cmbObj.InsertItem(-1, text, arrCode[idx]);
          }
      }

      /**
       * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
       *
       * @param {string} shtObj 필수, IBSheet Object
       * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
       * @return {Boorean}
       */
      function ACMDecideErrXml(shtObj, xmlStr) {
          if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
          if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
              shtObj.LoadSearchXml(xmlStr);
              return true;    // Error일때
          } else {
              return false;
          }
      }


      /**
       * IBSheet의 GetSearchXml함수를 통해 가져온 XML데이터를
       * HTML Input Select Object의 option으로 insert
       *
       * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
       * @param {object} Select Object 필수, insert하고자 하는 HTML Input Select Object.
       * @param {string} textCol 필수, xmlStr 중 Text컬럼명.
       * @param {string} codeCol 필수, xmlStr 중 Code컬럼명.
       * @param {boolean} firstNull 선택, 첫번째 Item에 Null Item 생성여부
       * @return {boolean} Select Object의 option생성 실패시 false return.
       */
      function ACMXml2SelectItem(xmlStr, selectObj, textCol, codeCol, firstNull) {
          if (xmlStr == null || xmlStr == "" || selectObj == null || selectObj == "") return false;
          if (ACMDecideErrXml(sheetObjects[0], xmlStr))return false;
          if (codeCol == null || codeCol == "" || textCol == null || textCol == "") return false;
          if (!firstNull || firstNull == null) firstNull == false;

          try {
              // Select Object Clear
              ComClearCombo(selectObj);

              var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
              xmlDoc.loadXML(xmlStr);

              var xmlRoot = xmlDoc.documentElement;
              if (xmlRoot == null) return false;

              var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
              if (dataNode == null || dataNode.attributes.length < 3) return false;

              var colArr = dataNode.getAttribute("COLORDER").split("|");
              var sep = dataNode.getAttribute("COLSEPARATOR");
              var total = dataNode.getAttribute("TOTAL");

              var dataChildNodes = dataNode.childNodes;
              if (dataChildNodes == null) return false;

              // code/text에 해당하는 컬럼index 추출
              var codeColIdx = 0;
              var textColIdx = 0;
              for (var i=0; i<colArr.length; i++) {
                  if (colArr[i] == codeCol) {
                      codeColIdx = i;
                  }
                  if (colArr[i] == textCol) {
                      textColIdx = i;
                  } 
              }

              // firstNull이 true이면 null item생성
              if (firstNull) {
                  ComAddComboItem(selectObj, "", "");
                  selectObj.options[0].selected = true;
              }
              // 컬럼index로  code/text 내용추출
              for (var i=0; i<dataChildNodes.length; i++) {
                  if (dataChildNodes[i].nodeType != 1) continue;
                  var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
                  // Select Object에 item생성
                  ComAddComboItem(selectObj, arrData[textColIdx], arrData[codeColIdx]);
              }
              // 첫번째 항목 선택
              if (selectObj.options.length > 0) {
                  selectObj.options[0].selected = true;
              }
              return true;

          } catch (err) {
              ComFuncErrMsg(err.message);
          }
      }
      
      /**
       * Shipper 입력 데이터 체크
       *  - 문자열 2자리 + 숫자로 구성되었는지 확인한다.
       * @param obj
       */
      function chkFormat(obj){
          var formObj = document.form;

          if(obj == null){
              return;
          }
          
          if(formObj.txtShipper.value.length > 2 && !ComIsNumber((formObj.txtShipper.value).substring(2))){
        	  ComShowMessage(ComGetMsg('MAS10009', 'Shipper', 'AA123456'));
        	  formObj.txtShipper.value = "";
        	  return;
          }
      }
      
  	/**
  	 * 여러 HTML Object의 Style Sheet ClassName을 지정한다.
  	 * @param clsNm
  	 * @param objs
  	 * @return 없음
  	 * @author	
  	 */
  	function MasComSetClassManyObjects(clsNm, objs) {
          try {
              var args = arguments;
              if (args.length < 2) return;

              for(var i=1; i<args.length; i++) {
                  if (args[i].tagName != undefined) {
                  	args[i].className = clsNm;
                  }
              }
          } catch(err) { ComFuncErrMsg(err.message); }
      }
  	
    /**
     * 로그인한 ofc cd가 OP Ofc cd에 관리에 따라 .OP 활성화
     */
    function ComMasOpCheckOfcCd(ogj, ofcCd){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	var param = "f_cmd="+SEARCH08+"&f_ofc_cd="+ofcCd;
    	var sXml = sheetObj.GetSearchXml("MasCommonUtilGS.do", param);
    	var arrXml = sXml.split("|$$|");
    	if (0<arrXml.length) {
            var rtnValue = ComGetEtcData(arrXml[0],"op_ofc_cd");
            if(rtnValue == "")
            	ogj.DeleteItem("O")
    	}
    }
    
    
    /**
     * 전체 Row 중에 Checkbox의 체크가 되어있는 Row들을 숨기고 상태를 삭제로 변경한다.<br>
     * isSelectDel 파라메터를 주면 check된 Checkbox가 없을 경우 현재 선택된 row를 삭제한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     deleteRowCheck(sheetObj);
     *     deleteRowCheck(sheetObj, "chk");
     *     deleteRowCheck(sheetObj, "chk", true);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} selColName 선택 화면에 보여지는 checkbox의 SaveName.
     *                               default="sel_chk"
     * @param {bool} isSelectDel 선택 현재 선택되어있는 row를 삭제할지 여부
     *                                 true : 체크된 row가 없으면 선택되어 있는 row를 삭제
     *                                 그 외 : 체크된 row 만 삭제
     * @return ComRowHideDelete() 함수 return 값
     * @author 문동규
     * @version 2009.04.22
     */
    function deleteRowCheck(sheetObj, selColName, isSelectDel) {
        if (arguments.length == 1) {
            selColName = "sel_chk";
        }

        var checkRow = sheetObj.FindCheckedRow(selColName);
        var selRow = sheetObj.SelectRow;
        var delRowCount = 0;
        var nextVisibleRow = sheetObj.SelectRow;
        var fireEventPostDelete = false;

        // 삭제대상중에 현재 로우가 포함되어있는지 체크
        if ((checkRow == "" && isSelectDel)
                || ("|" + checkRow).indexOf("|" + sheetObj.SelectRow + "|") >= 0) {
            fireEventPostDelete = true;
        }
        // IBSheet의 마지막 로우를 Delete하면(중간 Row를 Delete하는 경우와는 다르게) 이벤트가 발생한다.
        // X같은 IBSheet의 넘치는 버그 중 하나... 따라서 이런 경우 이벤트를 강제로 발생시키지 않도록 처리.
        if (sheetObj.RowStatus(selRow) == "I" && sheetObj.SelectRow == sheetObj.LastRow) {
            fireEventPostDelete = false;
        }

        if (checkRow == "") {
            if (isSelectDel) {
                // check된 row가 없고 선택된 row 상태가 Delete가 아니면 선택된 row를 삭제
                if (selRow != 0 && sheetObj.RowStatus(selRow) != "D") {
                    // 선택된 row를 삭제하기위해 checkbox를 check한다.
                    sheetObj.CellValue2(sheetObj.SelectRow, selColName) = 1;
                    delRowCount = ComRowHideDelete(sheetObj, selColName);
                }
            } else {
                return;
            }
        } else {
            delRowCount = ComRowHideDelete(sheetObj, selColName);
        }

        nextVisibleRow = sheetObj.SelectRow;

        if (sheetObj.RowCount > 0 && delRowCount > 0) {
            if (sheetObj.RowStatus(sheetObj.SelectRow) == "D" && sheetObj.RowHidden(sheetObj.SelectRow)) {
                nextVisibleRow = -1;
//              for (var i = sheetObj.SelectRow; i <= sheetObj.LastRow; i++) {
//                  if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
//                      nextVisibleRow = i;
//                      break;
//                  }
//              }
//              if (nextVisibleRow < 0) {
//                  for (var i = sheetObj.SelectRow; i >= sheetObj.HeaderRows; i--) {
//                      if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
//                          nextVisibleRow = i;
//                          break;
//                      }
//                  }
//              }
// IBSheet 버그가 해결될때까지 Row를 삭제 후,아래 행이 아닌 윗 행으로 이동한다. 2010-01-05.
                for (var i = sheetObj.SelectRow; i >= sheetObj.HeaderRows; i--) {
                    if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
                        nextVisibleRow = i;
                        break;
                    }
                }
                if (nextVisibleRow < 0) {
                    for (var i = sheetObj.SelectRow; i <= sheetObj.LastRow; i++) {
                        if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
                            nextVisibleRow = i;
                            break;
                        }
                    }
                }
            }

            if (fireEventPostDelete && nextVisibleRow > 0) {
                try {
                    eval(sheetObj.id + "_OnSelectCell(sheetObj, -2, " + sheetObj.SelectCol + ", " + nextVisibleRow + ", " + sheetObj.SelectCol + ")");
                } catch (err) {
                }
            }

//          nextVisibleRow = nextVisibleRow > sheetObj.LastRow ? sheetObj.LastRow : nextVisibleRow;
// IBSheet 버그가 해결될때까지 Row를 삭제 후,아래 행이 아닌 윗 행으로 이동한다. 2010-01-05.
            nextVisibleRow = nextVisibleRow < sheetObj.HeaderRows ? sheetObj.HeaderRows : nextVisibleRow;
            if (nextVisibleRow > 0) {
                sheetObj.SelectRow = nextVisibleRow;
            }
        }

        return delRowCount;
    }
    
    
    
    /**
     * 삭제된 row를 제외한 컬럼의 Max값 구하기 <br>
     *
     * @param {object} sheetObj 필수, IBSheet Object.
     * @param {string} sCol 필수, Max값을 구할 컬럼명(Savename).
     * @return int Max값
      * @author 박성수
      * @version 2009.04.22
     */
    function ComMasGetMaxExceptDelete(sheetObj, sCol) {
        var max = 0;
        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
            if(sheetObj.RowStatus(i) == "D") continue;

            if (parseInt(sheetObj.CellValue(i, sCol), 10) > max) {
                max = sheetObj.CellValue(i, sCol);
            }
        }
        return max;
    }

